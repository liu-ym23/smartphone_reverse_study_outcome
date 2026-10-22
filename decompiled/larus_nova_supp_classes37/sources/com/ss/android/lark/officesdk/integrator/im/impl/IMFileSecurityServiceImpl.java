package com.ss.android.lark.officesdk.integrator.im.impl;

import android.content.Context;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.auditsdk.v2.receivecheck.ImFileAuthorityChecker;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.AuthorityParam;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.auditsdk.v2.utils.AuditUtilsV2;
import com.ss.android.lark.auditsdk.wrapper.AuditService;
import com.ss.android.lark.biz.officesdk.im.file.FlowFilePreviewData;
import com.ss.android.lark.biz.officesdk.im.file.OpenFeishuFileSecurityBlockReason;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.widget.cleanresource.ResourceType;
import java.util.ArrayList;
import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class IMFileSecurityServiceImpl implements jza.c {
    public static final /* synthetic */ int b = 0;
    public final Lazy a;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MessagePermissionUtil.ReceiveAuthorizationState.values().length];
            r0[MessagePermissionUtil.ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MessagePermissionUtil.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    @Inject
    public IMFileSecurityServiceImpl() {
        this.a = LazyKt.lazy(IMFileSecurityServiceImpl$authorityChecker$2.INSTANCE);
    }

    public final void d(FlowFilePreviewData r7) {
        Intrinsics.checkNotNullParameter(r7, "data");
        AuditService r0 = owa.a.a();
        if (r0 == null) goto L19;
        String r1 = r7.i.a;
        String r2 = r7.f;
        String r3 = "";
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        String r8 = r7.d;
        if (r8 != null) goto L10;
        String r4 = "";
    L11:
        if (r8 == null) goto L13;
        String r9 = StringsKt.substringAfterLast(r8, '.', "");
    L14:
        if (r9 == null) goto L17;
        r3 = r9;
    L17:
        r0.c(r1, r2, r4, r3);
        return;
    L13:
        r9 = null;
        goto L14
    L10:
        r4 = r8;
        goto L11
    }

    public final void e(Message r14) {
        if (r14 != null) goto L4;
        return;
    L4:
        ValidateIMFileResult r0 = r14.getValidateIMFileResult();
        Long r1 = null;
        if (r0 == null) goto L7;
        IMFileResult r2 = r0.getResultType();
    L8:
        if (r2 == null) goto L16;
        ValidateIMFileResult r3 = r14.getValidateIMFileResult();
        if (r3 == null) goto L12;
        IMFileResult r4 = r3.getResultType();
    L14:
        if (r4 == IMFileResult.UNKNOWN) goto L16;
        return;
    L12:
        r4 = null;
    L16:
        pmb.i r5 = nmb.a.a().getPassportDependency();
        String r6 = r5.getUserId();
        if (r6 == null) goto L21;
        Long r7 = StringsKt.toLongOrNull(r6);
        if (r7 == null) goto L21;
        long r8 = r7.longValue();
    L22:
        int r9 = AuthorityParam.j;
        String r10 = r5.getTenantId();
        AuthorityParam.Companion.AuthScene r11 = AuthorityParam.Companion.AuthScene.IM_FILE_LOCAL_AUTHORITY_INTERCEPTOR;
        long r12 = AuthorityParam.Companion.a(r10, r11);
        AuthorityParam.a r13 = new AuthorityParam.a();
        r13.a = r14.getId();
        r13.d = Long.valueOf(AuthorityParam.Companion.a(r14.getFromId(), r11));
        String r15 = r14.getFromChatterTenantId();
        if (r15 == null) goto L25;
        r1 = Long.valueOf(AuthorityParam.Companion.a(r15, r11));
    L25:
        r13.c = r1;
        r13.f = r8;
        r13.e = r12;
        AuthorityParam.AuthorityExtraParam r16 = new AuthorityParam.AuthorityExtraParam(r14.isPreMessage(), r14.isFromMe(), false, 4, null);
        Intrinsics.checkNotNullParameter(r16, "authorityExtraParam");
        r13.i = r16;
        AuthorityParam r17 = r13.a();
        if (r14.getFromChatterTenantId() != null) goto L28;
        AuthorityParam.Companion.b(r11, "tenant id is null fo chatter not null");
    L28:
        ValidateIMFileResult r18 = (ValidateIMFileResult) ((HashMap) ((ImFileAuthorityChecker) this.a.getValue()).b(MapsKt.mapOf(TuplesKt.to(r14.getId(), r17)), true)).get(r14.getId());
        if (r18 == null) goto L32;
        r14.setValidateIMFileResult(r18);
        return;
    L32:
        return;
    L21:
        r8 = 0;
        goto L22
    L7:
        r2 = null;
        goto L8
    }

    public final boolean b(Context r7, Message r8, Chat r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "message");
        e(r8);
        if (r8.getType() != Message.Type.FILE) goto L5;
        boolean r0 = true;
    L6:
        ResourceCleanScene r1 = null;
        if (r0 == false) goto L9;
        Message r2 = r8;
    L10:
        if (r2 == null) goto L12;
        FileContent r3 = r2.getContent();
    L14:
        if ((r3 instanceof FileContent) == true) goto L17;
        r3 = null;
    L17:
        if (r3 != null) goto L19;
    L21:
        boolean r4 = false;
    L22:
        if (r4 == false) goto L24;
    L62:
        ResourceType r5 = ResourceType.FILE;
        if (r3 == null) goto L65;
        r1 = r3.currentResourceScene();
    L65:
        acc.a.f(r7, new acc.d(r5, r1, acc.a.d(r8.getFromChatterTenantId())));
        return true;
    L24:
        if (r8.isCleaned() == true) goto L62;
        ValidateIMFileResult r6 = r8.getValidateIMFileResult();
        if (r6 == null) goto L29;
        ValidateResult r10 = r6.getValidateResult();
    L30:
        ValidateIMFileResult r11 = r8.getValidateIMFileResult();
        if (r11 == null) goto L33;
        IMFileResult r12 = r11.getResultType();
    L34:
        MessagePermissionUtil.ReceiveAuthorizationState r13 = MessagePermissionUtil.h(r12);
        if (MessagePermissionUtil.g(r13) == false) goto L45;
        int r14 = b.a[r13.ordinal()];
        if (r14 != 1) goto L39;
        MessagePermissionUtil.m(r7);
    L43:
        owa.a.c().a(r10, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
        return true;
    L39:
        if (r14 != 2) goto L43;
        owa.a.c().d(r10, MessagePermissionUtil.a());
        goto L43
    L45:
        owa.a.c().a(r10, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
        ValidateResult r15 = MessagePermissionUtil.b();
        if (r9 == null) goto L49;
        boolean r16 = MessagePermissionUtil.c(r8, r9, r15);
    L57:
        if (r16 == true) goto L60;
        MessagePermissionUtil.n(r7, 2131891409, r15);
        owa.a.c().a(r15, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
        return true;
    L60:
        owa.a.c().a(r15, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
        return false;
    L49:
        if (MessagePermissionUtil.j(r8, null) == true) goto L51;
    L53:
        if (r15 != null) goto L55;
        ValidateResult r17 = MessagePermissionUtil.b();
    L56:
        r16 = MessagePermissionUtil.e(r17);
        goto L57
    L55:
        r17 = r15;
        goto L56
    L51:
        if (AuditUtilsV2.b() == true) goto L53;
        r16 = true;
        goto L57
    L33:
        r12 = null;
        goto L34
    L29:
        r10 = null;
        goto L30
    L19:
        if (r3.resourceIsCleaned() != true) goto L21;
        r4 = true;
        goto L22
    L12:
        r3 = null;
        goto L14
    L9:
        r2 = null;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public final void c(final Context r13, final FlowFilePreviewData r14, final Function0<Unit> r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "previewData");
        Intrinsics.checkNotNullParameter(r15, "onAllowed");
        Function1<jza.e, Unit> r2 = new IMFileSecurityServiceImpl$checkPreviewAuthorization$1(r14, this, r13, r15);
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "previewData");
        Intrinsics.checkNotNullParameter(r2, "callback");
        jza.a r16 = r14.i;
        if (r16.f == false) goto L6;
        jza.e r17 = new jza.e(OpenFeishuFileSecurityBlockReason.RESOURCE_CLEANED);
    L15:
        if (r17 == null) goto L17;
        r2.invoke(r17);
        return;
    L17:
        AuthorizationServiceV2 r18 = owa.a.c();
        ValidateResult r19 = r18.c(true);
        boolean r1 = r18.isAuthorizationPassed(r19);
        r18.a(r19, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
        if (r1 == true) goto L20;
        com.ss.android.lark.auditsdk.v2.d.a.a(r18, r13, r19, 2131891237, null, null, r18.e(), null, 440);
    L20:
        Intrinsics.checkNotNull(r18);
        boolean r110 = r18.isAuthorizationPassed(r19);
        if (r110 == false) goto L24;
        OpenFeishuFileSecurityBlockReason r111 = OpenFeishuFileSecurityBlockReason.UNKNOWN;
    L36:
        r2.invoke(new jza.e(r110, r111, null));
        return;
    L24:
        if (r19.getResult() != ResultType.ERROR) goto L27;
        r111 = OpenFeishuFileSecurityBlockReason.ERROR;
        goto L36
    L27:
        switch(h.a[r19.getResultPolicy().ordinal()]) {
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L31;
            case 6: goto L30;
            default: goto L29;
        };
    L30:
        r111 = OpenFeishuFileSecurityBlockReason.UNKNOWN;
        goto L36
    L31:
        r111 = OpenFeishuFileSecurityBlockReason.RISK_FILE;
        goto L36
    L32:
        r111 = OpenFeishuFileSecurityBlockReason.FILE_STRATEGY;
        goto L36
    L33:
        r111 = OpenFeishuFileSecurityBlockReason.DLP_SENSITIVE;
        goto L36
    L34:
        r111 = OpenFeishuFileSecurityBlockReason.DLP_DETECTING;
        goto L36
    L35:
        r111 = OpenFeishuFileSecurityBlockReason.NO_PERMISSION;
        goto L36
    L29:
        throw new NoWhenBranchMatchedException();
    L6:
        if (r16.g == false) goto L8;
    L14:
        r17 = new jza.e(OpenFeishuFileSecurityBlockReason.RISK_FILE);
        goto L15
    L8:
        if (r16.h == true) goto L14;
        if (r16.e == true) goto L13;
        r17 = new jza.e(OpenFeishuFileSecurityBlockReason.NO_PERMISSION);
        goto L15
    L13:
        r17 = null;
        goto L15
    }

    public final FlowFilePreviewData a(String r25, String r26, String r27, String r28, Message r29, Chat r30) {
        Intrinsics.checkNotNullParameter(r25, "messageId");
        e(r29);
        if (r29 != null) goto L5;
    L13:
        FileContent r7 = null;
    L15:
        if ((r7 instanceof FileContent) == true) goto L18;
        r7 = null;
    L18:
        if (r7 == null) goto L20;
        ResourceCleanScene r8 = r7.currentResourceScene();
    L21:
        if (r28 != null) goto L25;
        if (r7 == null) goto L24;
        String r9 = r7.getKey();
    L26:
        FlowFilePreviewData.Source r11 = FlowFilePreviewData.Source.LOCAL;
        if (r30 == null) goto L30;
        String r14 = r30.getId();
        if (r14 == null) goto L30;
    L32:
        String r16 = r14;
    L34:
        if (r29 == null) goto L36;
        String r17 = r29.getFromId();
    L37:
        if (r29 == null) goto L39;
        String r18 = r29.getFromChatterTenantId();
    L40:
        if (r29 == null) goto L44;
        ValidateIMFileResult r15 = r29.getValidateIMFileResult();
        if (r15 == null) goto L44;
        IMFileResult r19 = r15.getResultType();
    L45:
        Integer r110 = Integer.valueOf(MessagePermissionUtil.h(r19).getValue());
        if (r30 == null) goto L49;
        boolean r1 = MessagePermissionUtil.c(r29, r30, null);
    L54:
        boolean r20 = r1;
        if (r7 != null) goto L57;
    L59:
        boolean r2 = false;
    L60:
        if (r2 == true) goto L69;
        if (r29 != null) goto L63;
    L65:
        boolean r0 = false;
    L66:
        if (r0 == true) goto L69;
        boolean r21 = false;
    L70:
        if (r8 != null) goto L72;
    L74:
        boolean r22 = false;
    L75:
        if (r9 == null) goto L85;
        if (r7 == null) goto L82;
        ArrayList r3 = r7.getRiskObjectKeys();
        if (r3 == null) goto L82;
        if (r3.contains(r9) != true) goto L82;
        boolean r4 = true;
    L83:
        if (r4 != true) goto L85;
        boolean r23 = true;
    L87:
        return new FlowFilePreviewData(r25, r11, r26, r27, null, r28, null, null, new jza.a(r16, r17, r18, r110, r20, r21, r22, r23));
    L82:
        r4 = false;
    L85:
        r23 = false;
        goto L87
    L72:
        if (r8.isCSAMDelete() != true) goto L74;
        r22 = true;
        goto L75
    L63:
        if (r29.isCleaned() != true) goto L65;
        r0 = true;
    L69:
        r21 = true;
        goto L70
    L57:
        if (r7.resourceIsCleaned() != true) goto L59;
        r2 = true;
        goto L60
    L49:
        if (MessagePermissionUtil.j(r29, null) == true) goto L51;
    L53:
        r1 = MessagePermissionUtil.e(MessagePermissionUtil.b());
        goto L54
    L51:
        if (AuditUtilsV2.b() == true) goto L53;
        r1 = true;
    L44:
        r19 = null;
        goto L45
    L39:
        r18 = null;
        goto L40
    L36:
        r17 = null;
    L30:
        if (r29 == null) goto L33;
        r14 = r29.getChatId();
        goto L32
    L33:
        r16 = null;
        goto L34
    L24:
        r9 = null;
        goto L26
    L25:
        r9 = r28;
        goto L26
    L20:
        r8 = null;
        goto L21
    L5:
        if (r29.getType() != Message.Type.FILE) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == false) goto L10;
        Message r12 = r29;
    L11:
        if (r12 == null) goto L13;
        r7 = (FileContent) r12.getContent();
        goto L15
    L10:
        r12 = null;
        goto L11
    L7:
        r10 = false;
        goto L8
    }
}
