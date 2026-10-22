package j70;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import h70.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class i<T extends h70.b> extends h<T> implements o {
    @Override // j70.h
    public final com.bytedance.android.live.core.tetris.layer.view.b K(T r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
        return null;
    }

    @Override // j70.o
    public final /* synthetic */ Object[] a() {
        return null;
    }

    @Override // j70.o
    public final ViewGroup e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return null;
    }

    @Override // j70.o
    public final boolean f() {
        return false;
    }

    @Override // j70.o
    public final /* synthetic */ boolean g() {
        return true;
    }

    @Override // j70.o
    public boolean h() {
        return this instanceof com.bytedance.android.livesdk.chatroom.widget.i;
    }

    @Override // j70.o
    public final boolean i() {
        return true;
    }

    @Override // j70.o
    public final /* synthetic */ w70.a j() {
        return null;
    }

    public i() {
    }

    @Override // j70.d
    public LayerIndex E(T r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
        return LayerIndex.INDEX_SERVICE;
    }

    @Override // j70.h
    public final ElementConstraint J(T r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
        ElementConstraint r3 = ElementConstraint.n;
        return ElementConstraint.n;
    }
}
