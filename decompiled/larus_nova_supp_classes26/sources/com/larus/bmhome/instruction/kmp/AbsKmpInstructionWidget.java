package com.larus.bmhome.instruction.kmp;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.larus.utils.logger.FLogger;
import cq8.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 *2\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH\u0014J\u001a\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H$J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\rH$J4\u0010\u001f\u001a\u00020\u001b\"\n\b\u0000\u0010 \u0018\u0001*\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u001b0\"H\u0084\bø\u0001\u0000J2\u0010#\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0%2\u0006\u0010&\u001a\u00020'J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\rH\u0002J\u0006\u0010)\u001a\u00020\u001bR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006+"}, d2 = {"Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "collectJob", "Lkotlinx/coroutines/Job;", "lastDescriptor", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "getVContext", "()Lcom/larus/ui/arch/context/external/VContext;", "setVContext", "(Lcom/larus/ui/arch/context/external/VContext;)V", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "(Landroidx/fragment/app/Fragment;)V", "onDetachedFromWindow", "", "init", "onDescriptorChanged", "descriptor", "withDescriptor", "D", "block", "Lkotlin/Function1;", "setup", "descriptorFlow", "Lkotlinx/coroutines/flow/StateFlow;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatchDescriptor", "stopObserving", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsKmpInstructionWidget extends ConstraintLayout {
    public static final /* synthetic */ int e = 0;
    public Job a;
    public a0 b;
    public t1a.b c;
    public Fragment d;

    public static final class a {
    }

    static {
    }

    public AbsKmpInstructionWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AbsKmpInstructionWidget(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public abstract void S5(Context r1, AttributeSet r2);

    public abstract void T5(a0 r1);

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        Job r0 = this.a;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.a = null;
        this.b = null;
    }

    public final Fragment getFragment() {
        return this.d;
    }

    public final t1a.b getVContext() {
        return this.c;
    }

    public final void R5(a0 r4) {
        String r0 = r4.a();
        a0 r1 = this.b;
        if (r1 == null) goto L5;
        String r2 = r1.a();
    L7:
        if (Intrinsics.areEqual(r0, r2) == false) goto L9;
        return;
    L9:
        FLogger.a.i("AbsKmpInstructionWidget", "[dispatchDescriptor] " + Reflection.getOrCreateKotlinClass(r4.getClass()).getSimpleName());
        this.b = r4;
        T5(r4);
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void setFragment(Fragment r1) {
        this.d = r1;
    }

    public final void setVContext(t1a.b r1) {
        this.c = r1;
    }

    public AbsKmpInstructionWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        S5(r2, r3);
    }

    public /* synthetic */ AbsKmpInstructionWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void U5(t1a.b r7, Fragment r8, i1<? extends a0> r9, CoroutineScope r10) {
        Intrinsics.checkNotNullParameter(r7, "vContext");
        Intrinsics.checkNotNullParameter(r9, "descriptorFlow");
        Intrinsics.checkNotNullParameter(r10, "scope");
        this.c = r7;
        this.d = r8;
        Job r11 = this.a;
        if (r11 == null) goto L5;
        Job.DefaultImpls.cancel$default(r11, null, 1, null);
    L5:
        this.b = null;
        a0 r12 = (a0) r9.getValue();
        if (r12 == null) goto L8;
        R5(r12);
    L8:
        this.a = BuildersKt.launch$default(r10, Dispatchers.getMain().getImmediate(), null, new AbsKmpInstructionWidget$setup$2(r9, this, null), 2, null);
    }
}
