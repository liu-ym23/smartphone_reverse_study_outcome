package m91;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ BaseElement a;
    public final /* synthetic */ Function1 b;

    public b(BaseElement r1) {
        this.a = r1;
        this.b = null;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        ALogger.e(this.a.g(), "[" + this.a + "] Element事件订阅出错", r5);
        Function1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.invoke(r5);
        return;
    }
}
