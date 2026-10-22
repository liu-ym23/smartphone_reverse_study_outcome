package com.bytedance.android.live.core.tetris.layer.view;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.live.core.tetris.layer.core.delegate.c;
import com.bytedance.android.live.core.tetris.layer.core.element.ElementBuilderMap;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public c<h70.b> a;
    public ElementBuilderMap b;
    public h70.b c;
    public LayerEventDispatcher d;
    public r70.b<h70.b> e;
    public r70.a<h70.b> f;
    public r70.a<h70.b> g;
    public final Map<Class<s70.b<h70.b>>, s70.a<s70.b<h70.b>, h70.b>> h;
    public b80.a i;
    public ViewModelProvider j;
    public final C0161a k;
    public final p70.b l;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.layer.view.a$a, reason: collision with other inner class name */
    public static final class C0161a implements com.bytedance.android.live.core.tetris.layer.core.data.b {
        public final /* synthetic */ a a;

        public C0161a(a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.core.tetris.layer.core.data.b
        public final <T extends ViewModel> T getViewModel(Class<T> r3) {
            Intrinsics.checkNotNullParameter(r3, "modelClass");
            ViewModelProvider r0 = this.a.j;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("viewModelProvider");
        L6:
            return (T) r0.get(r3);
        }
    }

    public final h70.b a() {
        h70.b r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L5:
        return r0;
    }

    public a() {
        this.h = new LinkedHashMap();
        this.k = new C0161a(this);
        this.l = new p70.b();
    }
}
