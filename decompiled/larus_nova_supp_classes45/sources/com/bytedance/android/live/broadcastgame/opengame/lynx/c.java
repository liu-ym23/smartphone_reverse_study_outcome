package com.bytedance.android.live.broadcastgame.opengame.lynx;

import com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod;
import com.bytedance.android.live.broadcastgame.opengame.utils.j;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.util.Map;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ LynxOpenPlugin a;
    public final /* synthetic */ x7a.h b;
    public final /* synthetic */ com.bytedance.android.live.lynx.api.d c;

    public c(LynxOpenPlugin r1, x7a.h r2, com.bytedance.android.live.lynx.api.d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r6) {
        File r7 = (File) r6;
        Map r2 = null;
        Map r3 = null;
        String r4 = null;
        if (r7 != null) goto L11;
        com.bytedance.android.live.broadcastgame.opengame.panel.h r8 = this.a.z;
        if (r8 == null) goto L7;
        r8.i();
    L7:
        f2.c("跳转失败：资源加载失败！", 0);
        LynxOpenPlugin r9 = this.a;
        x7a.h r0 = this.b;
        if (r0 == null) goto L10;
        r3 = r0.c;
    L10:
        int r1 = BaseOpenMethod.g;
        r9.getClass();
        LynxOpenPlugin.H(r3, r1);
        return;
    L11:
        x7a.h r5 = this.b;
        if (r5 == null) goto L14;
        String r11 = r5.b;
    L16:
        if (Intrinsics.areEqual(r11, "introduce") == false) goto L24;
        int r12 = j.a;
        Intrinsics.checkNotNullParameter(r7, "res");
        Intrinsics.checkNotNullParameter("introduce", "pageAlias");
        byte[] r13 = j.b(FilesKt.resolve(r7, j.a(r7)).getAbsolutePath());
        if (r13 == null) goto L20;
        this.c.d(j.a(r7), r13, this.a.x());
        return;
    L20:
        com.bytedance.android.live.broadcastgame.opengame.panel.h r14 = this.a.z;
        if (r14 == null) goto L23;
        r14.i();
    L23:
        f2.c("跳转失败：资源加载失败！", 0);
        LynxOpenPlugin r15 = this.a;
        Map r16 = this.b.c;
        int r17 = BaseOpenMethod.g;
        r15.getClass();
        LynxOpenPlugin.H(r16, r17);
        return;
    L24:
        StringBuilder r18 = new StringBuilder();
        r18.append(this.a.u);
        x7a.h r19 = this.b;
        if (r19 == null) goto L27;
        String r21 = r19.b;
    L28:
        r18.append(r21);
        r18.append("/template.js");
        byte[] r22 = j.b(r18.toString());
        if (r22 == null) goto L38;
        Map<String, Object> r23 = this.a.x();
        x7a.h r24 = this.b;
        if (r24 == null) goto L33;
        String r25 = r24.b;
    L34:
        r23.put("location", r25);
        com.bytedance.android.live.lynx.api.d r26 = this.c;
        x7a.h r27 = this.b;
        if (r27 == null) goto L37;
        r4 = r27.b;
    L37:
        r26.d(Intrinsics.stringPlus(r4, "/template.js"), r22, r23);
        return;
    L33:
        r25 = null;
        goto L34
    L38:
        com.bytedance.android.live.broadcastgame.opengame.panel.h r28 = this.a.z;
        if (r28 == null) goto L41;
        r28.i();
    L41:
        f2.c("跳转失败：资源加载失败！", 0);
        LynxOpenPlugin r29 = this.a;
        x7a.h r31 = this.b;
        if (r31 == null) goto L44;
        r2 = r31.c;
    L44:
        int r32 = BaseOpenMethod.g;
        r29.getClass();
        LynxOpenPlugin.H(r2, r32);
        return;
    L27:
        r21 = null;
        goto L28
    L14:
        r11 = null;
        goto L16
    }
}
