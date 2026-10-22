package r42;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ vlc.m a;

    public f(com.bytedance.android.livesdk.interactivity.publicscreen.repository.first.g r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        MainThreadPostUtils.e(new e(this, (Throwable) r2));
    }
}
