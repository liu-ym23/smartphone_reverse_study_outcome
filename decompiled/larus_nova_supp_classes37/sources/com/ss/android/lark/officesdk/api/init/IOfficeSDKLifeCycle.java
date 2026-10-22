package com.ss.android.lark.officesdk.api.init;

import com.ss.android.lark.officesdk.api.api.OfficeSDKGlobalApi;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0014\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKLifeCycle;", "Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKProtocol;", "onInitReady", "", "officeSDKRuntime", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKRuntime;", "officeSDKGlobalApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKGlobalApi;", "onUserComponentReady", "officeSDKUserApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "onLoginSuccess", "onLogoutSuccess", "userId", "", "onLoadReady", "bizType", "Lcom/ss/android/lark/officesdk/api/init/OfficeBizType;", "onLoadFailed", "onWarmupReady", "onWarmupFailed", "reason", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public interface IOfficeSDKLifeCycle extends IOfficeSDKProtocol {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class DefaultImpls {
        public static void onLoadFailed(IOfficeSDKLifeCycle r0, OfficeBizType r1) {
            Intrinsics.checkNotNullParameter(r1, "bizType");
        }

        public static void onLoadReady(IOfficeSDKLifeCycle r0, OfficeBizType r1) {
            Intrinsics.checkNotNullParameter(r1, "bizType");
        }

        public static void onLoginSuccess(IOfficeSDKLifeCycle r0, OfficeSDKUserApi r1) {
            Intrinsics.checkNotNullParameter(r1, "officeSDKUserApi");
        }

        public static void onLogoutSuccess(IOfficeSDKLifeCycle r0, String r1) {
        }

        public static void onUserComponentReady(IOfficeSDKLifeCycle r0, OfficeSDKUserApi r1) {
            Intrinsics.checkNotNullParameter(r1, "officeSDKUserApi");
        }

        public static void onWarmupFailed(IOfficeSDKLifeCycle r0, OfficeBizType r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "bizType");
        }

        public static void onWarmupReady(IOfficeSDKLifeCycle r0, OfficeBizType r1) {
            Intrinsics.checkNotNullParameter(r1, "bizType");
        }

        public static /* synthetic */ void onLogoutSuccess$default(IOfficeSDKLifeCycle r0, String r1, int r2, Object r3) {
            if (r3 != null) goto L9;
            if ((r2 & 1) == 0) goto L6;
            r1 = null;
        L6:
            r0.onLogoutSuccess(r1);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLogoutSuccess");
        }

        public static /* synthetic */ void onWarmupFailed$default(IOfficeSDKLifeCycle r0, OfficeBizType r1, String r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 2) == 0) goto L6;
            r2 = null;
        L6:
            r0.onWarmupFailed(r1, r2);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onWarmupFailed");
        }
    }

    void onInitReady(IOfficeSDKRuntime r1, OfficeSDKGlobalApi r2);

    void onLoadFailed(OfficeBizType r1);

    void onLoadReady(OfficeBizType r1);

    void onLoginSuccess(OfficeSDKUserApi r1);

    void onLogoutSuccess(String r1);

    void onUserComponentReady(OfficeSDKUserApi r1);

    void onWarmupFailed(OfficeBizType r1, String r2);

    void onWarmupReady(OfficeBizType r1);
}
