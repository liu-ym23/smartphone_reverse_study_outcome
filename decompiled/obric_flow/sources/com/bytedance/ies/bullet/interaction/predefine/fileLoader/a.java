package com.bytedance.ies.bullet.interaction.predefine.fileLoader;

import com.bytedance.forest.model.Scene;
import com.bytedance.ies.bullet.forest.f;
import com.bytedance.ies.bullet.interaction.predefine.security.PredefineFileValidate$TypeEnum;
import com.lynx.tasm.utils.k;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import wc.g;
import xb.c;
import yb.b;
import yb.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f5425a;

    public a(c r5) {
        Intrinsics.checkNotNullParameter(r5, "metaModelConfig");
        this.f5425a = r5;
    }

    public final void a(final String r21, final String r22) {
        Intrinsics.checkNotNullParameter(r21, "matchRuleItem");
        Intrinsics.checkNotNullParameter(r22, "url");
        xb.a r5 = (xb.a) vb.a.f22568b.get(r21);
        if (r5 == null) goto L13;
        String r10 = r5.f23002a;
        if (r10 == null) goto L13;
        if (k.o(r10) != true) goto L13;
        yb.c r11 = new yb.c(0, r21, "MEMORY_CACHE", false);
        HashMap r12 = b.f23241a;
        d r13 = (d) r12.get(r22);
        if (r13 != null) goto L11;
        r13 = new d();
    L11:
        r13.f23245a.add(r11);
        r12.put(r22, r13);
        int r14 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XPredefine", "loadFile from cache result:" + r11 + ",thread:" + Thread.currentThread().getName(), null, 12);
        return;
    L13:
        final long r15 = System.currentTimeMillis();
        c r16 = this.f5425a;
        HashMap r17 = r16.f23009b;
        if (r17 == null) goto L16;
        final xb.b r18 = (xb.b) r17.get(r21);
    L17:
        if (r18 == null) goto L19;
        String r19 = (String) r18.f23005a.f905a;
    L20:
        String r110 = r16.f23008a + '/' + r19;
        if (r18 == null) goto L23;
        String r20 = r18.f23006b.f113a;
    L25:
        if (Intrinsics.areEqual(r20, "sha256") == false) goto L29;
        PredefineFileValidate$TypeEnum r23 = PredefineFileValidate$TypeEnum.f5427b;
    L27:
        final PredefineFileValidate$TypeEnum r24 = r23;
    L35:
        zm.c r25 = f.f5397a;
        f.e(r110, null, Scene.f4346b, "", new g(""), null, new MetaFileLoader$loadFile$1(r24, this, r18, r15, r21, r22), 197);
        return;
    L29:
        if (Intrinsics.areEqual(r20, "md5") == false) goto L32;
        r23 = PredefineFileValidate$TypeEnum.f5426a;
        goto L27
    L32:
        if (Intrinsics.areEqual(r20, "size_sha256") == false) goto L34;
        r23 = PredefineFileValidate$TypeEnum.f5428c;
        goto L27
    L34:
        int r26 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("XPredefine", com.lynx.tasm.utils.g.d("type ", r20, " not support"), null, 12);
        r24 = null;
        goto L35
    L23:
        r20 = null;
        goto L25
    L19:
        r19 = null;
        goto L20
    L16:
        r18 = null;
        goto L17
    }
}
