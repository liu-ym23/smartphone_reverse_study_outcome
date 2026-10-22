package up9;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentMediaSelectorBinding;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public abstract class v implements i0 {
    public final BottomSheetViewModel a;
    public final boolean b;

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    @Override // up9.i0
    public void onDestroyView() {
    }

    @Override // up9.i0
    public void f(LarusFragmentMediaSelectorBinding r4) {
        Intrinsics.checkNotNullParameter(r4, "binding");
        boolean r0 = kp9.b.a.c(r4.a.getContext(), this.b);
        wp9.i.c(r4.m.a, r0);
        if (r0 == false) goto L6;
        r4.m.a.setOnClickListener(new s(this));
        return;
    }

    public v(BottomSheetViewModel r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public static void p(v r3, final ViewPager2 r4, boolean r5) {
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "view");
        int r6 = r4.getChildCount();
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L14;
        RecyclerView r1 = r4.getChildAt(r0);
        if ((r1 instanceof RecyclerView) == true) goto L6;
        r0 = r0 + 1;
        goto L3
    L6:
        RecyclerView r2 = r1;
        if (r2.isNestedScrollingEnabled() == r5) goto L10;
        r2.setNestedScrollingEnabled(r5);
        r4.post(new t(r4));
        return;
    L10:
        return;
    }

    @Override // up9.i0
    public void g(LifecycleOwner r2, final LarusFragmentMediaSelectorBinding r3, BottomSheetViewModel r4, final MediaGalleryLiveDataViewModel r5) {
        Intrinsics.checkNotNullParameter(r2, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "binding");
        Intrinsics.checkNotNullParameter(r4, "nonNullBottomSheetViewModel");
        Intrinsics.checkNotNullParameter(r5, "mediaGalleryViewModel");
        r4.getBottomSheetOnStateChanged().observe(r2, new a(new u(this, r3, r5)));
    }
}
