package bt8;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.instruction.impl.databinding.LarusItemActionbarDropdownListBinding;
import com.skydoves.balloon.Balloon;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h extends RecyclerView.ViewHolder {
    public final LarusItemActionbarDropdownListBinding a;
    public final Function3<Integer, Long, Integer, Unit> b;
    public final Function3<com.larus.bmhome.actionbar.model.h, com.larus.bmhome.actionbar.model.w, Integer, Unit> c;
    public final Function0<Boolean> d;
    public Balloon e;
    public long f;
    public final int[] g;
    public final Rect h;
    public final Lazy i;
    public final Lazy j;

    /* JADX WARN: Multi-variable type inference failed */
    public h(LarusItemActionbarDropdownListBinding r2, Function3<? super Integer, ? super Long, ? super Integer, Unit> r3, Function3<? super com.larus.bmhome.actionbar.model.h, ? super com.larus.bmhome.actionbar.model.w, ? super Integer, Unit> r4, Function0<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "onOptionSelected");
        Intrinsics.checkNotNullParameter(r4, "onOptionShow");
        Intrinsics.checkNotNullParameter(r5, "shouldConsumeOutsideClick");
        super(r2.a);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.g = new int[2];
        this.h = new Rect();
        LazyThreadSafetyMode r6 = LazyThreadSafetyMode.NONE;
        this.i = LazyKt.lazy(r6, new b(this));
        this.j = LazyKt.lazy(r6, new c(this));
    }
}
