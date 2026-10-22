package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ o a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ long d;

    public n(o r1, String r2, String r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r13) {
        Throwable r14 = (Throwable) r13;
        this.a.g.remove(this.b);
        Iterator<g> r0 = this.a.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().L2(this.b, r14);
        goto L4
    L6:
        String r1 = this.b;
        String r2 = this.c;
        long r3 = this.d;
        long r9 = System.currentTimeMillis() - r3;
        if (this.a.d == false) goto L9;
        String r4 = "anchor";
    L10:
        dl0.m r5 = dl0.m.a;
        Intrinsics.checkNotNullParameter(r1, "toUserId");
        Intrinsics.checkNotNullParameter(r4, "role");
        JSONObject r11 = new JSONObject();
        BaseMonitor.add(r11, "to_user_id", r1.toString());
        BaseMonitor.add(r11, "sec_to_user_id", String.valueOf(r2));
        BaseMonitor.add(r11, "operate_role_type", r4);
        if (r14 != null) goto L13;
        return;
    L13:
        if ((r14 instanceof ApiServerException) == false) goto L18;
        dl0.m r6 = dl0.m.a;
        ApiServerException r15 = (ApiServerException) r14;
        int r7 = r15.getErrorCode();
        String r16 = r15.getErrorMsg();
        if (r16 != null) goto L17;
        r16 = "";
    L17:
        r6.getClass();
        dl0.m.z("audience_invite", r7, r16, r9, r11);
        return;
    L18:
        dl0.m r8 = dl0.m.a;
        String r10 = r14.toString();
        r8.getClass();
        dl0.m.z("audience_invite", 1, r10, r9, r11);
        return;
    L9:
        r4 = "administrator";
        goto L10
    }
}
