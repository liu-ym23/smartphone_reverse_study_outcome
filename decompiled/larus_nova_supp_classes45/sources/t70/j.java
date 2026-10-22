package t70;

import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j extends i {
    public final Widget e;

    public static final class a implements w70.a<h70.b> {
        public final /* synthetic */ j a;

        public a(j r1) {
            this.a = r1;
        }

        @Override // w70.a
        public final Widget a(h70.b r2) {
            Intrinsics.checkNotNullParameter(r2, "layerContext");
            return this.a.e;
        }
    }

    @Override // t70.i, j70.o
    public final w70.a<? extends h70.b> j() {
        return new a(this);
    }

    public j(boolean r2, boolean r3, Widget r4) {
        Intrinsics.checkNotNullParameter(r4, "widget");
        super(r2, r3, r4.getClass());
        this.e = r4;
    }
}
