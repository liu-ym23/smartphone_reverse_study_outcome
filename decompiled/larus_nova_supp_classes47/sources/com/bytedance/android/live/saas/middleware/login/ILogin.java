package com.bytedance.android.live.saas.middleware.login;

import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/login/ILogin;", "T", "", "getUid", "", "getUidObservable", "Lio/reactivex/Observable;", "isLogin", "", "updateCurrentAuthUserOpenId", "", "openId", "middleware_release"}, k = 1, mv = {1, 4, 3})
public interface ILogin<T> {
    String getUid();

    Observable<String> getUidObservable();

    boolean isLogin();

    void updateCurrentAuthUserOpenId(String r1);
}
