package com.ss.android.lark.coremd.facade.setspan.permission;

import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.coremd.base.parse.q;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremd.facade.bizext.props.IMMediaExtend;
import com.ss.android.lark.coremd.impl.parse.i;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import eab.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements q<f> {
    public final q<f> a;

    public b(com.ss.android.lark.coremd.facade.setspan.b r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        this.a = r2;
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final i r11) {
        Intrinsics.checkNotNullParameter(r11, "parseContext");
        IMContextExtend.a r0 = IMContextExtend.A;
        ValidateIMFileResult r2 = null;
        if (((Boolean) r0.b(new IMMediaSpanPermissionInterceptor$produceSpan$1$1(r11))).booleanValue() == false) goto L5;
        return null;
    L5:
        final ResourceCleanScene r1 = (ResourceCleanScene) com.ss.android.lark.coremd.ext.i.a(IMMediaExtend.class, new IMMediaSpanPermissionInterceptor$produceSpan$1$resourceCleanScene$1(r11));
        v9b.b r8 = (v9b.b) r0.b(new IMMediaSpanPermissionInterceptor$produceSpan$1$permissionContextData$1(r11));
        String r3 = (String) com.ss.android.lark.coremd.ext.i.a(IMMediaExtend.class, new IMMediaSpanPermissionInterceptor$produceSpan$1$resourceKey$1(r11));
        ValidateIMFileResult r4 = r8.c;
        if (r4 == null) goto L8;
        ValidateIMFileResult.Companion.getClass();
        final ValidateIMFileResult r5 = ValidateIMFileResult.a.a(r4, r3);
    L9:
        ValidateIMFileResult r6 = r8.c;
        if (r6 == null) goto L12;
        ValidateIMFileResult.Companion.getClass();
        r2 = ValidateIMFileResult.a.a(r6, r3);
    L12:
        if (r2 == null) goto L16;
        IMFileResult r7 = r2.getResultType();
        if (r7 == null) goto L16;
        final int r9 = r7.getValue();
    L17:
        final ValidateResult r10 = r8.a;
        final v9b.a r12 = (v9b.a) r0.b(new IMMediaSpanPermissionInterceptor$produceSpan$1$messageContextData$1(r11));
        boolean r13 = false;
        if (r1 != null) goto L20;
    L22:
        boolean r14 = false;
    L23:
        if (r14 == false) goto L26;
        int r15 = d.a;
        return d.a(r11.getContext().getString(2131891117), ((Number) com.ss.android.lark.coremd.ext.i.a(IMMediaExtend.class, new IMMediaSpanPermissionInterceptor$produceSpan$1$2(r11))).intValue(), ((Number) com.ss.android.lark.coremd.ext.i.a(IMMediaExtend.class, new IMMediaSpanPermissionInterceptor$produceSpan$1$3(r11))).intValue(), r11, r8, new IMMediaSpanPermissionInterceptor$produceSpan$1$4(r11, r1, r12));
    L26:
        EntityDomain r16 = xbc.c.a;
        if (r9 == 0) goto L34;
        if (r9 != 1) goto L30;
    L33:
        r13 = true;
        goto L34
    L30:
        if (r9 == 2) goto L34;
        if (r9 == 3) goto L33;
    L34:
        if (r13 == false) goto L41;
        if (r9 != 3) goto L37;
        String r17 = r11.getContext().getString(2131891244);
    L38:
        int r18 = d.a;
        return d.a(r17, ((Number) com.ss.android.lark.coremd.ext.i.a(IMMediaExtend.class, new IMMediaSpanPermissionInterceptor$produceSpan$1$5(r11))).intValue(), ((Number) com.ss.android.lark.coremd.ext.i.a(IMMediaExtend.class, new IMMediaSpanPermissionInterceptor$produceSpan$1$6(r11))).intValue(), r11, r8, new IMMediaSpanPermissionInterceptor$produceSpan$1$7(r9, r11, r5));
    L37:
        r17 = BuildConfig.FLAVOR;
        goto L38
    L41:
        if (r8.b == true) goto L45;
        int r19 = d.a;
        return d.a(r11.getContext().getString(2131891414), ((Number) com.ss.android.lark.coremd.ext.i.a(IMMediaExtend.class, new IMMediaSpanPermissionInterceptor$produceSpan$1$8(r11))).intValue(), ((Number) com.ss.android.lark.coremd.ext.i.a(IMMediaExtend.class, new IMMediaSpanPermissionInterceptor$produceSpan$1$9(r11))).intValue(), r11, r8, new IMMediaSpanPermissionInterceptor$produceSpan$1$10(r11, r10));
    L45:
        return this.a.a(r11);
    L20:
        if (r1.isCSAMDelete() != true) goto L22;
        r14 = true;
    L16:
        r9 = 4;
        goto L17
    L8:
        r5 = null;
        goto L9
    }
}
