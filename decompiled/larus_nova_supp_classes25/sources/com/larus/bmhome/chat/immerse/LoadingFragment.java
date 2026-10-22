package com.larus.bmhome.chat.immerse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.databinding.LarusFragmentLoadingBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/immerse/LoadingFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/bmhome/databinding/LarusFragmentLoadingBinding;", "immerseViewModel", "Lcom/larus/bmhome/chat/immerse/ChatImmersViewModel;", "getImmerseViewModel", "()Lcom/larus/bmhome/chat/immerse/ChatImmersViewModel;", "immerseViewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class LoadingFragment extends Fragment {
    public static final /* synthetic */ int f = 0;
    public LarusFragmentLoadingBinding d;
    public final Lazy e;

    public final void onDestroy() {
        ChatImmersViewModel r0 = (ChatImmersViewModel) this.e.getValue();
        if (r0 == null) goto L7;
        MutableLiveData<Boolean> r1 = r0.getAllowVpOffset();
        if (r1 == null) goto L7;
        r1.setValue(Boolean.TRUE);
    L7:
        i0.b = false;
        super.onDestroy();
    }

    public LoadingFragment() {
        this.e = LazyKt.lazy(new m0(this));
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        i0 r4 = i0.a;
        i0.b = true;
        ChatImmersViewModel r5 = (ChatImmersViewModel) this.e.getValue();
        if (r5 == null) goto L7;
        MutableLiveData<Boolean> r6 = r5.getAllowVpOffset();
        if (r6 == null) goto L7;
        r6.setValue(Boolean.FALSE);
    L7:
        LarusFragmentLoadingBinding r7 = this.d;
        if (r7 != null) goto L10;
        return;
    L10:
        if (i0.c() != 0) goto L12;
        com.larus.utils.e1.x(r7.b);
        com.larus.utils.e1.o(r7.c);
        return;
    L12:
        com.larus.utils.e1.o(r7.b);
        com.larus.utils.e1.x(r7.c);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131562401, r3, false);
        int r6 = 2131383299;
        ProgressBar r7 = (ProgressBar) ViewBindings.findChildViewById(r5, 2131383299);
        if (r7 == null) goto L9;
        r6 = 2131383303;
        ProgressBar r0 = (ProgressBar) ViewBindings.findChildViewById(r5, 2131383303);
        if (r0 == null) goto L9;
        FrameLayout r8 = (FrameLayout) r5;
        this.d = new LarusFragmentLoadingBinding(r8, r7, r0);
        return r8;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
