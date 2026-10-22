package fu1;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g<T extends View> extends BaseSlcViewManager<T> {
    public final yt1.f<T> H3;

    public final T A0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return (T) this.H3.createView(r2);
    }

    public final void H0(Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "props");
        this.H3.a(new h(this, getView()), r4);
    }

    public g(SlcTemplateContext r2, yt1.f<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "provider");
        super(r2);
        this.H3 = r3;
    }
}
