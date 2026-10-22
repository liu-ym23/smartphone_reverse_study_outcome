package z91;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.navi.userinfo_p.mvi.UserInfoDataSource;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ UserInfoDataSource a;

    public f(UserInfoDataSource r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        String r0 = this.a.a;
        ALogger.e(r0, (Throwable) r2);
    }
}
