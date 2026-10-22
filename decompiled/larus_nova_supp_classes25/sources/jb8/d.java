package jb8;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.bmhome.block.newheader.foldcontainer.HeadTitleLoadingTarget;
import com.larus.mainbot.impl.databinding.LarusWidgetTextSourceHeaderBinding;
import com.larus.utils.e1;
import ib8.q0;
import ib8.r0;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import po8.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d implements hb8.a {
    public final LarusWidgetTextSourceHeaderBinding a;
    public final Function1<View, Unit> b;
    public final Function1<View, Unit> c;
    public z d;
    public List<String> e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[HeadTitleLoadingTarget.values().length];
            r0[HeadTitleLoadingTarget.CONTAINER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[HeadTitleLoadingTarget.TEXT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    @Override // hb8.a
    public final void f() {
        AppCompatImageView r0 = this.a.g;
        r0.setImageResource(2131242202);
        r0.setRotation(0.0f);
        Intrinsics.checkNotNull(r0);
        e1.o(r0);
        this.a.b.b();
        e1.o(this.a.b);
        this.a.h.a();
        this.a.o.x();
        this.a.o.setText("");
        e1.x(this.a.o);
        e1.o(this.a.p);
        z r1 = this.d;
        if (r1 == null) goto L5;
        r1.b();
    L5:
        this.d = null;
        this.e = null;
    }

    public d(LarusWidgetTextSourceHeaderBinding r2, q0 r3, r0 r4) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "onClick");
        Intrinsics.checkNotNullParameter(r4, "longClickListener");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
