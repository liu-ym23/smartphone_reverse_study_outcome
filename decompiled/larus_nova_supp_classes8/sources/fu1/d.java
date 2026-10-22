package fu1;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends SlcFlexElementView implements com.bytedance.android.livesdk.dslservice.view.a {
    public final HashSet<View> e;
    public View f;

    @Override // com.bytedance.android.livesdk.dslservice.view.a
    public final void reset() {
    }

    public final HashSet<View> getAutoGoneViewSet() {
        return this.e;
    }

    public final View getLastSeparateView() {
        return this.f;
    }

    public d(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        this.e = new HashSet();
    }

    public final void setLastSeparateView(View r1) {
        this.f = r1;
    }
}
