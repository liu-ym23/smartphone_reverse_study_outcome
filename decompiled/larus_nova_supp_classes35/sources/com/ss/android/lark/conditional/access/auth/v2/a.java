package com.ss.android.lark.conditional.access.auth.v2;

import android.util.Pair;
import com.ss.android.lark.audit.AuditManager;
import com.ss.android.lark.security.compliance.api.model.filepolicy.AuthEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public a() {
    }

    public final ValidateResult a(com.ss.android.lark.security.compliance.api.model.filepolicy.e r4, ValidateConfig r5) {
        AuthEntity r6 = (AuthEntity) r4;
        Intrinsics.checkNotNullParameter(r6, "p");
        Pair r7 = AuditManager.getInstance().checkAuthorityWithErrorType(r6.getPermType(), r6.getEntityType(), r6.getEntityId());
        Intrinsics.checkNotNull(r7);
        Integer r8 = (Integer) r7.first;
        Integer r9 = (Integer) r7.second;
        Intrinsics.checkNotNull(r8);
        int r10 = r8.intValue();
        boolean r0 = true;
        if (r10 == 0) goto L16;
        if (r10 != 1) goto L6;
        ResultType r11 = ResultType.DENY;
    L17:
        ValidateResult r1 = new ValidateResult(r11);
        r1.setResultPolicy(FileAuthResultFrom.COME_FROM_AUTHZ);
        Intrinsics.checkNotNull(r9);
        r1.setErrorReason(r9.intValue());
        r1.setPolicyMethod(ValidateResultSource.OTHERS);
        if (r11 != ResultType.ERROR) goto L21;
        r0 = false;
    L21:
        r1.setCredible(r0);
        return r1;
    L6:
        if (r10 != 2) goto L8;
        r11 = ResultType.ALLOW;
        goto L17
    L8:
        if (r10 != 3) goto L10;
        r11 = ResultType.NULL;
        goto L17
    L10:
        if (r10 == 4) goto L12;
        r11 = ResultType.UNKNOWN;
        goto L17
    L12:
        r11 = ResultType.ERROR;
        goto L17
    L16:
        r11 = ResultType.UNKNOWN;
        goto L17
    }
}
