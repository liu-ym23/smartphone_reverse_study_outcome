package com.ss.android.lark.officesdk.integrator.im.sdk.service;

import android.app.Activity;
import com.bytedance.lark.pb.basic.v1.Chat;
import com.ss.android.lark.audit.AuditManager;
import com.ss.android.lark.auditsdk.authorization.AuthorizationService;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements okb.b {
    public a() {
    }

    public final boolean a() {
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).aiApi().a();
        return false;
    }

    public final int getUnifiedStorageLimitErrorCode() {
        return owa.a.d().getUnifiedStorageLimitErrorCode();
    }

    public final boolean b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "entityId");
        ((AuthorizationService) AuthorizationService.a.getValue()).getClass();
        Intrinsics.checkNotNullParameter(r4, "entityId");
        com.ss.android.lark.auditsdk.wrapper.b.d.a.getClass();
        Integer r5 = (Integer) AuditManager.getInstance().checkAuthorityWithErrorType(27, "BAIKEREPO", r4).first;
        if (r5 != null) goto L6;
    L8:
        return false;
    L6:
        if (r5.intValue() != 2) goto L8;
        return true;
    }

    public final boolean isFeatureGatingEnable(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        return FeatureGatingModule.getFeatureGatingService().isEnable(r2);
    }

    public final boolean isHitStorageQuotaLimit(int r2) {
        return owa.a.d().isHitStorageQuotaLimit(r2);
    }

    public final boolean isInterceptSendCallback(int r2) {
        IIMApi r0 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isInterceptSendCallback(r2);
    }

    public final void showUnifiedStorageLimitCTADialog(Activity r2) {
        owa.a.d().showUnifiedStorageLimitCTADialog(r2);
    }

    public final boolean isCalendarAbbrHighlightEnabled(String r2, Chat r3) {
        return ((IIMApi) ApiUtils.getApi(IIMApi.class)).isCalendarAbbrHighlightEnabled(r2, r3);
    }

    public final boolean showQuotaLimitDialog(Activity r2, int r3) {
        return owa.a.d().showQuotaLimitDialog(r2, r3);
    }
}
