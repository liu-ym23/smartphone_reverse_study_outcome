package t70;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import j70.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements o {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ Widget b;

    public static final class a implements w70.a<h70.b> {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        @Override // w70.a
        public final Widget a(h70.b r2) {
            Intrinsics.checkNotNullParameter(r2, "layerContext");
            return this.a.b;
        }
    }

    @Override // j70.o
    public final /* synthetic */ Object[] a() {
        return null;
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
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
    public final boolean i() {
        return false;
    }

    @Override // j70.o
    public final w70.a<? extends h70.b> j() {
        return new a(this);
    }

    @Override // j70.o
    public final boolean h() {
        return this.a;
    }

    public d(boolean r1, LiveRecyclableWidget r2) {
        this.a = r1;
        this.b = r2;
    }
}
