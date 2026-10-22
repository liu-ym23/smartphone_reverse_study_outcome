package com.larus.bmhome.instruction.base;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.view.actionbar.edit.c;
import com.larus.bmhome.view.actionbar.edit.n;
import com.larus.common_ui.widget.CircleProgressBarView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import up8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\u0004\b\u0000\u0010\u001e¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010.\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H$J\u000e\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\u0010J\b\u00101\u001a\u00020!H&J\b\u00102\u001a\u00020!H\u0014J\b\u00103\u001a\u00020!H\u0014J\b\u00104\u001a\u00020!H\u0016J\u0010\u00105\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u00106\u001a\u00020!2\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020!H\u0016J\b\u0010:\u001a\u00020!H\u0016J\b\u0010;\u001a\u00020!H\u0016R\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001b\u0010(\u001a\u00020)8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b*\u0010+¨\u0006<"}, d2 = {"Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Landroidx/fragment/app/Fragment;", "fragment", "getFragment", "()Landroidx/fragment/app/Fragment;", "componentController", "Lcom/larus/bmhome/instruction/base/AbsInstructionController;", "inputDepend", "Lcom/larus/bmhome/view/actionbar/edit/OutInputDepend;", "getInputDepend", "()Lcom/larus/bmhome/view/actionbar/edit/OutInputDepend;", "viewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "getViewModel", "()Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "instructionItem", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionItem;", "getInstructionItem", "()Lcom/larus/bmhome/actionbar/model/ActionBarInstructionItem;", "getController", "T", "()Ljava/lang/Object;", "bindFragment", "", "componentScope", "Lkotlinx/coroutines/CoroutineScope;", "getComponentScope", "()Lkotlinx/coroutines/CoroutineScope;", "setComponentScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "viewLifecycleOwner", "Lcom/larus/bmhome/instruction/base/ViewLifecycleOwner;", "getViewLifecycleOwner", "()Lcom/larus/bmhome/instruction/base/ViewLifecycleOwner;", "viewLifecycleOwner$delegate", "Lkotlin/Lazy;", "init", "bindView", "controller", "onBindView", "onAttachedToWindow", "onDetachedFromWindow", "onViewShow", "applyMarginTop", "bindPickPictureResult", "uri", "Landroid/net/Uri;", "reportShow", "requestInputBoxFocus", "clearInputFocus", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsInstructionWidget extends ConstraintLayout {
    public static final /* synthetic */ int e = 0;
    public Fragment a;
    public b b;
    public CoroutineScope c;
    public final Lazy d;

    public AbsInstructionWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AbsInstructionWidget(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public void S5(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
    }

    public void U5() {
    }

    public abstract void V5(Context r1, AttributeSet r2);

    public abstract void Y5();

    public void Z5() {
    }

    public void b6() {
    }

    public void c6() {
    }

    public final <T> T getController() {
        T r0 = (T) this.b;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0;
    }

    public final n getInputDepend() {
        b r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    public final u getInstructionItem() {
        b r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public final ViewLifecycleOwner getViewLifecycleOwner() {
        return (ViewLifecycleOwner) this.d.getValue();
    }

    public final c getViewModel() {
        b r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        getViewLifecycleOwner().b.setCurrentState(Lifecycle.State.STARTED);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        ViewLifecycleOwner r0 = getViewLifecycleOwner();
        Lifecycle.State r1 = r0.b.getCurrentState();
        Lifecycle.State r2 = Lifecycle.State.DESTROYED;
        if (r1 == r2) goto L11;
        LifecycleRegistry r3 = r0.b;
        if (r0.a == null) goto L9;
        r2 = Lifecycle.State.CREATED;
    L9:
        r3.setCurrentState(r2);
        return;
    }

    public final CoroutineScope getComponentScope() {
        return this.c;
    }

    public final Fragment getFragment() {
        return this.a;
    }

    public void R5(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T5(b r4) {
        Intrinsics.checkNotNullParameter(r4, "controller");
        this.b = r4;
        u r5 = r4.b;
        if (r5 == null) goto L9;
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-1, -2);
        int r1 = CircleProgressBarView.k;
        Context r2 = getContext();
        Integer r6 = r5.h;
        if (r6 == null) goto L7;
        float r7 = r6.intValue();
    L8:
        r0.setMargins(0, (int) CircleProgressBarView.a.a(r2, r7), 0, 0);
        setLayoutParams(r0);
        goto L9
    L7:
        r7 = 0.0f;
    L9:
        Y5();
    }

    public final void setComponentScope(CoroutineScope r1) {
        this.c = r1;
    }

    public AbsInstructionWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = LazyKt.lazy(LazyThreadSafetyMode.NONE, new up8.c(this));
        V5(r2, r3);
    }

    public /* synthetic */ AbsInstructionWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
