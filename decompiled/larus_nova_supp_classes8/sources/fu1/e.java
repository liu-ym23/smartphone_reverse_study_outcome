package fu1;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<T extends SlcFlexElementView> extends com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b {
    public final yt1.f<T> W3;

    public final /* bridge */ /* synthetic */ View A0(Context r1) {
        return J1(r1);
    }

    public final void H0(Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "props");
        h r0 = new h(this, getView());
        this.W3.a(r0, r3);
    }

    public final T J1(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.W3.createView(r2);
    }

    public e(SlcTemplateContext r2, yt1.f<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "provider");
        super(r2);
        this.W3 = r3;
    }

    public final void D1(BaseSlcViewManager<?> r9, int r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r9, "childViewManager");
        this.W3.b(this, r9, r10, r11, r12, r13);
        r9.v(r10, r11, r12, r13);
    }
}
