package com.ss.android.lark.officesdk.api;

import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmUploadRetryConfigSetting;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0014\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u001e\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH&J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0018\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H¦@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017H&¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/officesdk/api/IUserManager;", "", "loginState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$State;", "login", "", "callback", "Lcom/ss/android/lark/officesdk/api/ILoginCallback;", "logout", "Lcom/ss/android/lark/officesdk/api/ILogoutCallback;", "action", "Lcom/ss/android/lark/officesdk/api/OfficeSDKPassportUserAction;", "getUserApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "awaitUserApi", "timeoutMs", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginRx", "Lio/reactivex/Single;", "Lcom/ss/android/lark/officesdk/api/OfficeSDKDriveResult;", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/ss/android/lark/officesdk/api/OfficeSDKHostSession;", "logoutRx", "createUserHandle", "Lcom/ss/android/lark/officesdk/api/IOfficeSDKUserHandle;", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public interface IUserManager {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class DefaultImpls {
        public static /* synthetic */ void login$default(IUserManager r0, ILoginCallback r1, int r2, Object r3) {
            if (r3 != null) goto L9;
            if ((r2 & 1) == 0) goto L6;
            r1 = null;
        L6:
            r0.login(r1);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: login");
        }

        public static /* synthetic */ Object awaitUserApi$default(IUserManager r0, long r1, Continuation r3, int r4, Object r5) throws OfficeSDKException {
            if (r5 != null) goto L9;
            if ((r4 & 1) == 0) goto L7;
            r1 = MmUploadRetryConfigSetting.MAX_INTERVAL_MS;
        L7:
            return r0.awaitUserApi(r1, r3);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitUserApi");
        }

        public static /* synthetic */ void logout$default(IUserManager r0, ILogoutCallback r1, OfficeSDKPassportUserAction r2, int r3, Object r4) {
            if (r4 != null) goto L12;
            if ((r3 & 1) == 0) goto L7;
            r1 = null;
        L7:
            if ((r3 & 2) == 0) goto L9;
            r2 = OfficeSDKPassportUserAction.LOGOUT;
        L9:
            r0.logout(r1, r2);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logout");
        }
    }

    Object awaitUserApi(long r1, Continuation<? super OfficeSDKUserApi> r3) throws OfficeSDKException;

    IOfficeSDKUserHandle createUserHandle(OfficeSDKHostSession r1);

    OfficeSDKUserApi getUserApi();

    void login(ILoginCallback r1);

    Single<OfficeSDKDriveResult> loginRx(OfficeSDKHostSession r1);

    i1<IOnlineOfflineService.State> loginState();

    void logout(ILogoutCallback r1, OfficeSDKPassportUserAction r2);

    Single<OfficeSDKDriveResult> logoutRx(OfficeSDKHostSession r1);
}
