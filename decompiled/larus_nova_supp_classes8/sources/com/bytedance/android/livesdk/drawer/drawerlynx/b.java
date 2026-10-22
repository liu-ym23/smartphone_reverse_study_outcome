package com.bytedance.android.livesdk.drawer.drawerlynx;

import am2.n;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.model.LiveVSLog;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.service.ILiveService;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Ref;
import w20.j8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ j8 b;
    public final /* synthetic */ Ref.ObjectRef c;

    public b(d r1, j8 r2, Ref.ObjectRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r5) {
        FollowPair r6 = (FollowPair) r5;
        g r7 = u.l();
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = this.b.b();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.put("enter_from_merge", r1);
        String r3 = this.b.c();
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0.put("enter_method", r3);
        r0.put("action_type", "click");
        r0.put("request_page", "long_press");
        String r4 = this.b.f();
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        r0.put("to_user_id", r4);
        r0.put("event_page", "live_cover");
        ILiveService r8 = TTLiveService.getLiveService();
        if (r8 == null) goto L19;
        ILiveOntologyInfoManager r9 = r8.getLiveOntologyRecord();
        if (r9 == null) goto L19;
        String r10 = r9.getEnterFromMerge();
        if (r10 == null) goto L19;
        r2 = r10;
    L19:
        r0.put("drawer_page", r2);
        LiveVSLog r11 = (LiveVSLog) this.c.element;
        if (r11 == null) goto L22;
        r0.putAll(r11.a());
    L22:
        Unit r12 = Unit.INSTANCE;
        r7.sendLog("livesdk_unfollow", r0, new Object[]{n.f()});
        this.a.finishWithSuccess();
    }
}
