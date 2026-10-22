package l70;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import h70.b;
import j70.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a<T extends b> implements com.bytedance.android.live.core.tetris.layer.core.data.b {
    public T a;
    public v70.a b;
    public LifecycleOwner c;
    public com.bytedance.android.live.core.tetris.layer.core.data.b d;
    public com.bytedance.android.live.core.tetris.layer.core.delegate.b e;
    public final f f;

    public abstract void c();

    public abstract void d();

    public final T b() {
        T r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L5:
        return r0;
    }

    public a(f r2) {
        Intrinsics.checkNotNullParameter(r2, "elementType");
        this.f = r2;
    }

    public final void a(ElementConstraint r3) {
        Intrinsics.checkNotNullParameter(r3, "elementConstraint");
        com.bytedance.android.live.core.tetris.layer.core.delegate.b r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("constraintRefresh");
    L5:
        r0.a(this.f, r3);
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.data.b
    public final <T extends ViewModel> T getViewModel(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "modelClass");
        com.bytedance.android.live.core.tetris.layer.core.data.b r0 = this.d;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("vmProvider");
    L6:
        return r0.getViewModel(r3);
    }
}
