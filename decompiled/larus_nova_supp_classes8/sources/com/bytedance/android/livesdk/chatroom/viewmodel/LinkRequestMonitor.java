package com.bytedance.android.livesdk.chatroom.viewmodel;

import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.config.link.LinkRequestMonitorConfig;
import com.bytedance.android.livesdk.config.z7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodel/LinkRequestMonitor;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkRequestMonitor implements Observer<KVData> {
    public long a;
    public final ConcurrentHashMap<String, Integer> b;
    public final String c;
    public final LinkRequestMonitorConfig d;
    public final HashMap<String, List<String>> e;
    public final IRoom f;
    public final DataCenter g;

    public final void b() {
        DataCenter r0 = this.g;
        if (r0 == null) goto L6;
        r0.removeObserver(this);
    L6:
        if (this.b.isEmpty() == false) goto L8;
        return;
    L8:
        long r1 = System.currentTimeMillis() - this.a;
        long r2 = BubbleId.PadCast;
        long r3 = r1 / r2;
        if (r3 > 0) goto L12;
        this.b.clear();
        return;
    L12:
        Iterator<String> r4 = this.b.keySet().iterator();
    L14:
        if (r4.hasNext() == false) goto L33;
        String r5 = r4.next();
        Integer r6 = this.b.get(r5);
        if (r6 == null) goto L14;
        int r7 = r6.intValue();
        if (r3 < 10) goto L14;
        if ((((long) r7) / r3) < this.d.getThreshold()) goto L14;
        int r8 = r6.intValue();
        HashMap r9 = new HashMap();
        r9.put("room_id", Long.valueOf(this.f.getId()));
        r9.put("anchor_id", this.f.getOwnerUserIdString());
        com.bytedance.android.livesdk.user.e r10 = jc1.k.n(IMiddlewareUserService.class).user();
        if (r10 == null) goto L24;
        Boolean r11 = Boolean.valueOf(r10.isAdmin());
    L25:
        r9.put("is_admin", Boolean.valueOf(r11.booleanValue()));
        r9.put("request_path", r5);
        r9.put("request_count", Integer.valueOf(r8));
        IRoom r12 = this.f;
        if (r12 == null) goto L32;
        Map r13 = r12.getLinkMap();
        if (r13 == null) goto L32;
        if ((!r13.isEmpty()) == false) goto L32;
        r9.put("scene", r13.keySet().toString());
    L32:
        r9.put("start_ts", Long.valueOf(this.a));
        r9.put("duration", Long.valueOf((System.currentTimeMillis() - this.a) / r2));
        r9.toString();
        LiveSlardarMonitor.monitorStatus(this.c, -1, r9);
        goto L14
    L24:
        r11 = null;
        goto L25
    L33:
        this.b.clear();
    }

    public final void a() {
        this.a = System.currentTimeMillis();
        DataCenter r0 = this.g;
        if (r0 == null) goto L6;
        r0.observe("cmd_show_user_profile", this);
        return;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.getKey() != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r5.getKey(), "cmd_show_user_profile") == false) goto L27;
        List<String> r6 = this.e.get(r5.getKey());
        if (r6 == null) goto L28;
        Iterator<String> r7 = r6.iterator();
    L13:
        if (r7.hasNext() == false) goto L30;
        String r0 = r7.next();
        if (this.b.containsKey(r0) == false) goto L13;
        Integer r1 = this.b.get(r0);
        if (r1 == null) goto L13;
        Integer r2 = this.b.put(r0, Integer.valueOf(r1.intValue() - 1));
        goto L13
    L30:
        return;
    L28:
        return;
    }

    public LinkRequestMonitor(IRoom r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "room");
        this.f = r2;
        this.g = r3;
        this.a = System.currentTimeMillis();
        this.b = new ConcurrentHashMap();
        this.c = "ttlive_request_too_much_all";
        this.d = z7.a.getValue();
        HashMap<String, List<String>> r4 = new HashMap();
        r4.put("cmd_show_user_profile", CollectionsKt.listOf(new String[]{"/webcast/user/", "/webcast/gift/exhibition/home/"}));
        Unit r5 = Unit.INSTANCE;
        this.e = r4;
    }
}
