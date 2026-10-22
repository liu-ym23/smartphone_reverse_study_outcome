package com.larus.avlink.simulInterpret.page.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.avlink.impl.databinding.LayoutBottomTranslationPanelViewBinding;
import com.larus.avlink.simulInterpret.page.model.DoraDeviceType;
import com.larus.avlink.simulInterpret.page.view.TranslationResultAdapter;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0002\u0019 \b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\u0006\u0010$\u001a\u00020\u001cJ\u0006\u0010%\u001a\u00020\u001cJ\u0006\u0010&\u001a\u00020\u001cJ\u000e\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u0010J\b\u0010)\u001a\u00020\u001cH\u0002Jb\u0010*\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f26\u0010+\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u001c0,J\u000e\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u0013J@\u00103\u001a\u00020\u001c26\u0010+\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u001c0,H\u0002J\b\u00104\u001a\u00020\u001cH\u0002J\u0006\u00105\u001a\u00020\u001cJ\b\u00106\u001a\u00020\u001cH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!¨\u00067"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/ui/BottomTranslatePanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LayoutBottomTranslationPanelViewBinding;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getCurrentLanguage", "Lkotlin/Function0;", "Lcom/larus/avlink/simulInterpret/page/model/Language;", "getOtherSideLanguage", "deviceType", "Lcom/larus/avlink/simulInterpret/page/model/DoraDeviceType;", "isUserScrolling", "", "idleJob", "Lkotlinx/coroutines/Job;", "dataObserver", "com/larus/avlink/simulInterpret/page/ui/BottomTranslatePanelView$dataObserver$1", "Lcom/larus/avlink/simulInterpret/page/ui/BottomTranslatePanelView$dataObserver$1;", "initRecyclerView", "", "bottomAdapter", "Lcom/larus/avlink/simulInterpret/page/view/TranslationResultAdapter;", "scrollListener", "com/larus/avlink/simulInterpret/page/ui/BottomTranslatePanelView$scrollListener$1", "Lcom/larus/avlink/simulInterpret/page/ui/BottomTranslatePanelView$scrollListener$1;", "startIdleCountdown", "cancelIdleCountdown", "updateForOnBoarding", "updateForListening", "updateForTranslating", "updateLanguage", "language", "reduceView", "initSelectLanguageView", "selectedListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "leftLanguage", "rightLanguage", "setIcon", "doraDeviceType", "showLanguageSelectionBottomSheet", "scrollToBottomIfNeeded", "scrollToBottomAfterAdjustView", "onDetachedFromWindow", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BottomTranslatePanelView extends ConstraintLayout {
    public static final /* synthetic */ int j = 0;
    public final LayoutBottomTranslationPanelViewBinding a;
    public FragmentManager b;
    public Function0<com.larus.avlink.simulInterpret.page.model.a> c;
    public Function0<com.larus.avlink.simulInterpret.page.model.a> d;
    public DoraDeviceType e;
    public boolean f;
    public Job g;
    public final BottomTranslatePanelView$dataObserver$1 h;
    public final BottomTranslatePanelView$scrollListener$1 i;

    public BottomTranslatePanelView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BottomTranslatePanelView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void R5() {
        if (this.f == false) goto L5;
        return;
    L5:
        RecyclerView.Adapter r0 = this.a.j.getAdapter();
        if ((r0 instanceof TranslationResultAdapter) == false) goto L8;
        TranslationResultAdapter r1 = (TranslationResultAdapter) r0;
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        int r2 = r1.getItemCount();
        if (r2 <= 0) goto L15;
        this.a.j.smoothScrollToPosition(r2 - 1);
        return;
    L15:
        return;
    L8:
        r1 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        RecyclerView.Adapter r0 = this.a.j.getAdapter();
        if (r0 == null) goto L5;
        r0.unregisterAdapterDataObserver(this.h);
    L5:
        Job r1 = this.g;
        if (r1 == null) goto L9;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
        return;
    }

    public final void setIcon(DoraDeviceType r3) {
        Intrinsics.checkNotNullParameter(r3, "doraDeviceType");
        this.e = r3;
        this.a.d.setImageResource(r3.getBottomTranslatingIconRes());
        this.a.e.setImageResource(r3.getBottomIconRes());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v7, types: [com.larus.avlink.simulInterpret.page.ui.BottomTranslatePanelView$dataObserver$1] */
    /* JADX WARN: Type inference failed for: r12v8, types: [com.larus.avlink.simulInterpret.page.ui.BottomTranslatePanelView$scrollListener$1] */
    public BottomTranslatePanelView(Context r12, AttributeSet r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r14);
        ConstraintLayout r15 = LayoutInflater.from(r12).inflate(2131563289, this, false);
        addView(r15);
        int r16 = 2131373888;
        View r2 = ViewBindings.findChildViewById(r15, 2131373888);
        if (r2 == null) goto L25;
        r16 = 2131373987;
        Group r3 = ViewBindings.findChildViewById(r15, 2131373987);
        if (r3 == null) goto L25;
        r16 = 2131374748;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r15, 2131374748);
        if (r4 == null) goto L25;
        r16 = 2131374776;
        if (((ImageView) ViewBindings.findChildViewById(r15, 2131374776)) == null) goto L25;
        r16 = 2131374782;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r15, 2131374782);
        if (r5 == null) goto L25;
        r16 = 2131377623;
        ConstraintLayout r6 = ViewBindings.findChildViewById(r15, 2131377623);
        if (r6 == null) goto L25;
        r16 = 2131388461;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r15, 2131388461);
        if (r7 == null) goto L25;
        r16 = 2131388467;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r15, 2131388467);
        if (r8 == null) goto L25;
        r16 = 2131388501;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r15, 2131388501);
        if (r9 == null) goto L25;
        r16 = 2131389355;
        RecyclerView r10 = ViewBindings.findChildViewById(r15, 2131389355);
        if (r10 == null) goto L25;
        this.a = new LayoutBottomTranslationPanelViewBinding(r15, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        this.e = DoraDeviceType.DEVICE_LITE;
        this.h = new BottomTranslatePanelView$dataObserver$1(this);
        this.i = new BottomTranslatePanelView$scrollListener$1(this);
        return;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r16)));
    }

    public /* synthetic */ BottomTranslatePanelView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
