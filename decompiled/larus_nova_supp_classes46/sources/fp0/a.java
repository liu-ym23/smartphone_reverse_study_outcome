package fp0;

import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ Function2 a;
    public final /* synthetic */ MiniAppEntranceCell b;
    public final /* synthetic */ int c;

    public a(Function2 r1, MiniAppEntranceCell r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r3) {
        this.a.invoke(this.b, Integer.valueOf(this.c));
    }
}
