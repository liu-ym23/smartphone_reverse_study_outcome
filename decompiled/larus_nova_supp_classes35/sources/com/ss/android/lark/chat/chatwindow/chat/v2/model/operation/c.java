package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements Function1<f5b.b, f5b.b> {
    public final Map<String, ValidateIMFileResult> a;

    public static final class a {
        @JvmStatic
        public static void a(f5b.b r5, ValidateIMFileResult r6) {
            Intrinsics.checkNotNullParameter(r5, "cloneItem");
            Intrinsics.checkNotNullParameter(r6, ChameleonOpenTracker.ParamKey.RESULT);
            ValidateIMFileResult r0 = r5.getMessage().getValidateIMFileResult();
            if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("im.file_authority_updater") == true) goto L34;
            boolean r1 = false;
            if (r0 != null) goto L7;
        L17:
            boolean r3 = false;
        L18:
            if (r3 == true) goto L21;
        L32:
            if (r1 == false) goto L50;
            return;
        L50:
            r5.getMessage().setValidateIMFileResult(r6);
            return;
        L21:
            if (r0.getResultType() == IMFileResult.DENY) goto L23;
        L31:
            r1 = !r1;
            goto L32
        L23:
            if (r0.getValidateResult().isCredible() == true) goto L31;
            if (r6.getResultType() != IMFileResult.ALLOW) goto L31;
            if (r6.getValidateResult().isCredible() == false) goto L31;
            if (r6.getValidateResult().getPolicyMethod() != ValidateResultSource.REMOTE_POLICY) goto L31;
            r1 = true;
            goto L31
        L7:
            if (r0.getResultType() != IMFileResult.ORIGIN) goto L9;
        L14:
            boolean r4 = true;
        L15:
            if (r4 != true) goto L17;
            r3 = true;
            goto L18
        L9:
            if (r0.getResultType() == IMFileResult.ALLOW) goto L14;
            if (r0.getResultType() == IMFileResult.DENY) goto L14;
            r4 = false;
            goto L15
        L34:
            IMFileResult r2 = null;
            if (r0 == null) goto L37;
            IMFileResult r7 = r0.getResultType();
        L39:
            if (r7 == IMFileResult.ORIGIN) goto L52;
            if (r0 == null) goto L42;
            IMFileResult r8 = r0.getResultType();
        L44:
            if (r8 == IMFileResult.ALLOW) goto L53;
            if (r0 == null) goto L48;
            r2 = r0.getResultType();
        L48:
            if (r2 != IMFileResult.DENY) goto L50;
            return;
        L53:
            return;
        L42:
            r8 = null;
            goto L44
        L52:
            return;
        L37:
            r7 = null;
            goto L39
        }
    }

    static {
    }

    public c(Map<String, ValidateIMFileResult> r2) {
        Intrinsics.checkNotNullParameter(r2, "validateResult");
        this.a = r2;
    }

    public final Object invoke(Object r4) {
        f5b.b r5 = (f5b.b) r4;
        if (r5 != null) goto L5;
        return null;
    L5:
        f5b.b r6 = r5.clone();
        ValidateIMFileResult r0 = this.a.get(r6.getId());
        if (r0 == null) goto L8;
        a.a(r6, r0);
    L8:
        f5b.b r1 = r6.getParent();
        if (r1 == null) goto L15;
        ValidateIMFileResult r2 = this.a.get(r1.getId());
        if (r2 == null) goto L16;
        a.a(r1, r2);
        return r6;
    L16:
        return r6;
    L15:
        return r6;
    }
}
