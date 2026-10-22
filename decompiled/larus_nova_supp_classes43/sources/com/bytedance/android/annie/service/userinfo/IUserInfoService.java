package com.bytedance.android.annie.service.userinfo;

import android.app.Activity;
import com.bytedance.android.annie.bridge.method.v0;
import com.bytedance.android.annie.bridge.method.x0;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IUserInfoService extends com.bytedance.android.annie.service.a {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/annie/service/userinfo/IUserInfoService$ILoginStatusCallback;", "", "onFail", "", "onSuccess", "annie_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public interface ILoginStatusCallback {
        void onFail();

        void onSuccess();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/annie/service/userinfo/IUserInfoService$ILogoutStatusCallback;", "", "onFail", "", "reason", "", "onSuccess", "annie_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public interface ILogoutStatusCallback {
        void onFail(String r1);

        void onSuccess();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/annie/service/userinfo/IUserInfoService$LoginParamsExt;", "", "()V", "keepOpen", "", "getKeepOpen", "()Z", "setKeepOpen", "(Z)V", "annie_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class LoginParamsExt {
        private boolean keepOpen;

        public LoginParamsExt() {
            this.keepOpen = true;
        }

        public final boolean getKeepOpen() {
            return this.keepOpen;
        }

        public final void setKeepOpen(boolean r1) {
            this.keepOpen = r1;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/annie/service/userinfo/IUserInfoService$UserModelExt;", "", "()V", "shortID", "", "getShortID", "()Ljava/lang/String;", "setShortID", "(Ljava/lang/String;)V", "annie_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class UserModelExt {
        private String shortID;

        public UserModelExt() {
        }

        public final String getShortID() {
            return this.shortID;
        }

        public final void setShortID(String r1) {
            this.shortID = r1;
        }
    }

    void U(Activity r1, v0 r10, LoginParamsExt r11);

    void getUserId();

    void hasLogin();

    void z(Activity r1, x0 r10);

    void z1(Activity r1, v0 r10);
}
