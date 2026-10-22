package xc0;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ Function2 a;
    public final /* synthetic */ String b;

    public g(Function2 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        this.a.invoke(Boolean.FALSE, null);
        ALogger.i("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#error:" + this.b + ", " + ((Throwable) r4));
    }
}
