package com.ss.android.lark.coremd.facade.setspan.permission;

import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.coremd.base.parse.q;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremd.facade.bizext.props.IMImageExtend;
import com.ss.android.lark.coremd.impl.parse.i;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import v7b.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements q<l> {
    public final q<l> a;

    public a(com.ss.android.lark.coremd.facade.setspan.a r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        this.a = r2;
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final i r11) {
        Intrinsics.checkNotNullParameter(r11, "parseContext");
        IMContextExtend.a r0 = IMContextExtend.A;
        if (((Boolean) r0.b(new IMImageSpanPermissionInterceptor$produceSpan$1$1(r11))).booleanValue() == true) goto L5;
        final AuthorizationServiceV2 r1 = owa.a.c();
        final ResourceCleanScene r2 = (ResourceCleanScene) com.ss.android.lark.coremd.ext.i.a(IMImageExtend.class, new IMImageSpanPermissionInterceptor$produceSpan$1$resourceCleanScene$1(r11));
        v9b.b r8 = (v9b.b) r0.b(new IMImageSpanPermissionInterceptor$produceSpan$1$permissionContextData$1(r11));
        String r3 = (String) com.ss.android.lark.coremd.ext.i.a(IMImageExtend.class, new IMImageSpanPermissionInterceptor$produceSpan$1$resourceKey$1(r11));
        ValidateIMFileResult r4 = r8.c;
        ValidateIMFileResult r5 = null;
        if (r4 == null) goto L9;
        ValidateIMFileResult.Companion.getClass();
        final ValidateIMFileResult r6 = ValidateIMFileResult.a.a(r4, r3);
    L10:
        ValidateIMFileResult r7 = r8.c;
        if (r7 == null) goto L13;
        ValidateIMFileResult.Companion.getClass();
        r5 = ValidateIMFileResult.a.a(r7, r3);
    L13:
        if (r5 == null) goto L17;
        IMFileResult r9 = r5.getResultType();
        if (r9 == null) goto L17;
        final int r10 = r9.getValue();
    L18:
        final ValidateResult r12 = r8.a;
        final v9b.a r13 = (v9b.a) r0.b(new IMImageSpanPermissionInterceptor$produceSpan$1$messageContextData$1(r11));
        boolean r14 = false;
        if (r2 != null) goto L21;
    L23:
        boolean r15 = false;
    L24:
        if (r15 == false) goto L27;
        int r16 = d.a;
        return d.a(r11.getContext().getString(2131891117), ((Number) com.ss.android.lark.coremd.ext.i.a(IMImageExtend.class, new IMImageSpanPermissionInterceptor$produceSpan$1$2(r11))).intValue(), ((Number) com.ss.android.lark.coremd.ext.i.a(IMImageExtend.class, new IMImageSpanPermissionInterceptor$produceSpan$1$3(r11))).intValue(), r11, r8, new IMImageSpanPermissionInterceptor$produceSpan$1$4(r11, r2, r13));
    L27:
        EntityDomain r17 = xbc.c.a;
        if (r10 == 0) goto L35;
        if (r10 != 1) goto L31;
    L34:
        r14 = true;
        goto L35
    L31:
        if (r10 == 2) goto L35;
        if (r10 == 3) goto L34;
    L35:
        if (r14 == false) goto L42;
        if (r10 != 3) goto L38;
        String r18 = r11.getContext().getString(2131891244);
    L39:
        int r19 = d.a;
        return d.a(r18, ((Number) com.ss.android.lark.coremd.ext.i.a(IMImageExtend.class, new IMImageSpanPermissionInterceptor$produceSpan$1$5(r11))).intValue(), ((Number) com.ss.android.lark.coremd.ext.i.a(IMImageExtend.class, new IMImageSpanPermissionInterceptor$produceSpan$1$6(r11))).intValue(), r11, r8, new IMImageSpanPermissionInterceptor$produceSpan$1$7(r10, r11, r1, r6));
    L38:
        r18 = BuildConfig.FLAVOR;
        goto L39
    L42:
        if (r8.b == true) goto L46;
        int r20 = d.a;
        return d.a(r11.getContext().getString(2131891411), ((Number) com.ss.android.lark.coremd.ext.i.a(IMImageExtend.class, new IMImageSpanPermissionInterceptor$produceSpan$1$8(r11))).intValue(), ((Number) com.ss.android.lark.coremd.ext.i.a(IMImageExtend.class, new IMImageSpanPermissionInterceptor$produceSpan$1$9(r11))).intValue(), r11, r8, new IMImageSpanPermissionInterceptor$produceSpan$1$10(r11, r12, r1, r6));
    L46:
        return this.a.a(r11);
    L21:
        if (r2.isCSAMDelete() != true) goto L23;
        r15 = true;
    L17:
        r10 = 4;
        goto L18
    L9:
        r6 = null;
        goto L10
    L5:
        return this.a.a(r11);
    }
}
