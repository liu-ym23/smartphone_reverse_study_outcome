package fu1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f<T extends ViewGroup> extends BaseSlcViewGroupManager<T> {
    public final yt1.f<T> V3;

    public final View A0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return (ViewGroup) this.V3.createView(r2);
    }

    public final void H0(Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "props");
        this.V3.a(new h(this, getView()), r4);
    }

    public f(SlcTemplateContext r2, yt1.f<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "provider");
        super(r2);
        this.V3 = r3;
    }
}
