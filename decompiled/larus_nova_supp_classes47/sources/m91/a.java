package m91;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ BaseElement a;
    public final /* synthetic */ Function1 b;

    public a(BaseElement r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(T r4) {
        this.b.invoke(r4);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        ALogger.e(this.a.g(), "[" + this.a + "] element invoke onNext() error", e);
        if (v.a() == true) goto L8;
        return;
    L8:
        throw e;
    }
}
