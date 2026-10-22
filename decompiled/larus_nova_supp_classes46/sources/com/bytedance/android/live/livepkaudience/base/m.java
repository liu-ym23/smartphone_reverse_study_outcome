package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.livesdk.chatroom.interact.model.LinkInviteResult;
import com.bytedance.android.livesdk.link.model.bridge.m0;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ o a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ long d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;
    public final /* synthetic */ long g;

    public m(o r1, String r2, String r3, long r4, int r6, long r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = -1;
        this.f = r6;
        this.g = r7;
    }

    public final void accept(Object r13) {
        com.bytedance.android.live.network.response.e r14 = (com.bytedance.android.live.network.response.e) r13;
        this.a.g.remove(this.b);
        if (r14 == null) goto L14;
        LinkInviteResult r15 = (m0) r14.data;
        if (r15 == null) goto L16;
        String r0 = this.b;
        String r1 = this.c;
        long r9 = System.currentTimeMillis() - this.d;
        if (this.a.d == false) goto L9;
        String r2 = "anchor";
    L10:
        String r3 = "pos=" + this.e + ", teamId=" + this.f + ", msgBoardItemId=" + this.g;
        dl0.m r4 = dl0.m.a;
        Intrinsics.checkNotNullParameter(r0, "toUserId");
        Intrinsics.checkNotNullParameter(r2, "role");
        Intrinsics.checkNotNullParameter(r3, "extraStr");
        JSONObject r11 = new JSONObject();
        BaseMonitor.add(r11, "to_user_id", r0.toString());
        BaseMonitor.add(r11, "sec_to_user_id", String.valueOf(r1));
        BaseMonitor.add(r11, "operate_role_type", r2);
        BaseMonitor.add(r11, "extra_params", r3);
        dl0.m.a.getClass();
        dl0.m.z("audience_invite", 0, "", r9, r11);
        Iterator<g> r5 = this.a.e.iterator();
    L12:
        if (r5.hasNext() == false) goto L17;
        r5.next().V6(this.b, r15);
        goto L12
    L17:
        return;
    L9:
        r2 = "administrator";
        goto L10
    L16:
        return;
    }
}
