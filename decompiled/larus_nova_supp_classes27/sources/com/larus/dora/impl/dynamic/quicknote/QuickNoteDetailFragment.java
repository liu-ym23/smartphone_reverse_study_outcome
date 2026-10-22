package com.larus.dora.impl.dynamic.quicknote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.dora.impl.databinding.LarusDoraPageQuickNoteDetailBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.dynamic.quicknote.entity.QuickNoteItemState;
import com.larus.dora.impl.dynamic.quicknote.views.QuickNoteItemTextSelectorSubTitle;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\u0016\u0010\u001e\u001a\u00020\u00192\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\n\u0010\"\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010#\u001a\u00020$H\u0016J\n\u0010%\u001a\u0004\u0018\u00010\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/dora/impl/dynamic/quicknote/QuickNoteDetailFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageQuickNoteDetailBinding;", "viewModel", "Lcom/larus/dora/impl/dynamic/quicknote/QuickNoteDetailViewModel;", "getViewModel", "()Lcom/larus/dora/impl/dynamic/quicknote/QuickNoteDetailViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "itemViews", "Ljava/util/ArrayList;", "Lcom/larus/dora/impl/dynamic/quicknote/views/QuickNoteItemTextSelectorSubTitle;", "Lkotlin/collections/ArrayList;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "setupObservers", "setupItems", "updateItems", "states", "", "Lcom/larus/dora/impl/dynamic/quicknote/entity/QuickNoteItemConfig;", "setupTitle", "getCurrentPageName", "", "getPageMaskView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuickNoteDetailFragment extends DoraBaseFragment {
    public static final /* synthetic */ int i = 0;
    public LarusDoraPageQuickNoteDetailBinding f;
    public final Lazy g;
    public final ArrayList<QuickNoteItemTextSelectorSubTitle> h;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[QuickNoteItemState.values().length];
            r0[QuickNoteItemState.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[QuickNoteItemState.SELECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[QuickNoteItemState.CONFIRMED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public final String k() {
        return "quick_note_detail";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageQuickNoteDetailBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g;
    }

    public final QuickNoteDetailViewModel W90() {
        return (QuickNoteDetailViewModel) this.g.getValue();
    }

    public QuickNoteDetailFragment() {
        final Function0<Fragment> r0 = new QuickNoteDetailFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(QuickNoteDetailViewModel.class), new QuickNoteDetailFragment$special$$inlined$viewModels$default$2(r0), new QuickNoteDetailFragment$special$$inlined$viewModels$default$3(r0, this));
        this.h = new ArrayList();
    }

    public final void onResume() {
        super.onResume();
        W90().onAction(com.larus.dora.impl.dynamic.quicknote.a.c.a);
    }

    public final void onViewCreated(View r18, Bundle r110) {
        Intrinsics.checkNotNullParameter(r18, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r18, r110);
        LarusDoraPageQuickNoteDetailBinding r1 = this.f;
        if (r1 == null) goto L5;
        NovaTitleBarEx.b6(r1.h, 2131240517, false, null, null, new c(this), 14);
    L5:
        LarusDoraPageQuickNoteDetailBinding r2 = this.f;
        if (r2 == null) goto L15;
        final int r5 = 0;
        CollectionsKt.addAll(this.h, new QuickNoteItemTextSelectorSubTitle[]{r2.e, r2.f, r2.c, r2.d});
        r2.e.setMainTitle(getString(2131903367));
        r2.f.setMainTitle(getString(2131903368));
        r2.c.setMainTitle(getString(2131903941));
        r2.d.setMainTitle(getString(2131903942));
        Iterator<QuickNoteItemTextSelectorSubTitle> r3 = this.h.iterator();
    L9:
        if (r3.hasNext() == false) goto L14;
        ConstraintLayout r4 = r3.next();
        int r6 = r5 + 1;
        if (r5 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        e1.d((QuickNoteItemTextSelectorSubTitle) r4, new d(this, r5));
        r5 = r6;
        goto L9
    L14:
        e1.d(r2.b, new e(this));
        e1.d(r2.i, new f(this));
    L15:
        Lifecycle.State r7 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new QuickNoteDetailFragment$setupObservers$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r7, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new QuickNoteDetailFragment$setupObservers$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r7, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new QuickNoteDetailFragment$setupObservers$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r7, null, this), 3, null);
    }

    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        ConstraintLayout r14 = r11.inflate(2131562288, r12, false);
        int r15 = 2131364689;
        DoraTextView r2 = (DoraTextView) ViewBindings.findChildViewById(r14, 2131364689);
        if (r2 == null) goto L31;
        r15 = 2131369526;
        QuickNoteItemTextSelectorSubTitle r3 = (QuickNoteItemTextSelectorSubTitle) ViewBindings.findChildViewById(r14, 2131369526);
        if (r3 == null) goto L31;
        r15 = 2131369527;
        QuickNoteItemTextSelectorSubTitle r4 = (QuickNoteItemTextSelectorSubTitle) ViewBindings.findChildViewById(r14, 2131369527);
        if (r4 == null) goto L31;
        r15 = 2131369616;
        if (ViewBindings.findChildViewById(r14, 2131369616) == null) goto L31;
        r15 = 2131369620;
        if (ViewBindings.findChildViewById(r14, 2131369620) == null) goto L31;
        r15 = 2131369621;
        if (ViewBindings.findChildViewById(r14, 2131369621) == null) goto L31;
        r15 = 2131369700;
        QuickNoteItemTextSelectorSubTitle r5 = (QuickNoteItemTextSelectorSubTitle) ViewBindings.findChildViewById(r14, 2131369700);
        if (r5 == null) goto L31;
        r15 = 2131369701;
        QuickNoteItemTextSelectorSubTitle r6 = (QuickNoteItemTextSelectorSubTitle) ViewBindings.findChildViewById(r14, 2131369701);
        if (r6 == null) goto L31;
        r15 = 2131369962;
        View r7 = ViewBindings.findChildViewById(r14, 2131369962);
        if (r7 == null) goto L31;
        r15 = 2131376535;
        if (((ImageView) ViewBindings.findChildViewById(r14, 2131376535)) == null) goto L31;
        r15 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r14, 2131385238)) == null) goto L31;
        r15 = 2131388772;
        NovaTitleBarEx r8 = ViewBindings.findChildViewById(r14, 2131388772);
        if (r8 == null) goto L31;
        r15 = 2131392579;
        AppCompatTextView r9 = ViewBindings.findChildViewById(r14, 2131392579);
        if (r9 == null) goto L31;
        ConstraintLayout r16 = r14;
        this.f = new LarusDoraPageQuickNoteDetailBinding(r16, r2, r3, r4, r5, r6, r7, r8, r9);
        return r16;
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }
}
