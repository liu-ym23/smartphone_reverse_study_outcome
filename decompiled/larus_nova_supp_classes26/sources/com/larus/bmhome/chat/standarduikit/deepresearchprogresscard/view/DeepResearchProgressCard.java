package com.larus.bmhome.chat.standarduikit.deepresearchprogresscard.view;

import android.content.Context;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.block.ResearchProcessBlock;
import com.larus.im.bean.message.block.Status;
import com.larus.mainbot.impl.databinding.LarusCardDeepResearchProgressBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ok8.b;
import ok8.c;
import ok8.e;
import ok8.f;
import ok8.g;
import pk8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001\u001aB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/deepresearchprogresscard/view/DeepResearchProgressCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/deepresearchprogresscard/view/DeepResearchProgressCardViewInput;", "Lcom/larus/bmhome/chat/standarduikit/deepresearchprogresscard/view/DeepResearchProgressCardViewOutput;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "cycleInfo", "Lcom/larus/bmhome/chat/standarduikit/deepresearchprogresscard/view/CycleInfo;", "binding", "Lcom/larus/mainbot/impl/databinding/LarusCardDeepResearchProgressBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusCardDeepResearchProgressBinding;", "binding$delegate", "Lkotlin/Lazy;", "bindData", "", "input", "output", "tryStartCycleTask", "data", "Lcom/larus/im/bean/message/block/ResearchProcessBlock;", "updateProgress", "cycleTask", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeepResearchProgressCard extends ConstraintLayout {
    public static final /* synthetic */ int c = 0;
    public final ok8.a a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    private final LarusCardDeepResearchProgressBinding getBinding() {
        return (LarusCardDeepResearchProgressBinding) this.b.getValue();
    }

    public DeepResearchProgressCard(final Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.a = new ok8.a(0);
        this.b = LazyKt.lazy(new b(r3, this));
    }

    public final void T5(ResearchProcessBlock r12) {
        Integer r0 = null;
        if (r12 == null) goto L5;
        Integer r1 = r12.getStartTimestamp();
    L6:
        if (r12 == null) goto L9;
        r0 = r12.getEstimatedDuration();
    L9:
        if (r1 == null) goto L14;
        if (r0 == null) goto L14;
        long r3 = AppHost.a.getAppClock().currentTimeMillis() / ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY);
        float r5 = RangesKt.coerceAtLeast(r3 - ((long) r1.intValue()), 0);
        float r6 = RangesKt.coerceIn(r5 / r0.intValue(), 0.0f, 1.0f);
        float r7 = new DecelerateInterpolator(2.0f).getInterpolation(r6);
        int r8 = (int) (100 * r7);
        FLogger.a.d("DeepResearchProgressCard", "updateProgress: startTimestamp=" + r1 + ", current = " + r3 + " estimatedDuration=" + r0 + ", elapsed=" + r5 + ", fraction=" + r6 + ", eased=" + r7 + ", newProgress=" + r8);
        getBinding().c.setProgress(RangesKt.coerceAtLeast(getBinding().c.getProgress(), r8));
        return;
    L14:
        FLogger.a.d("DeepResearchProgressCard", "updateProgress: startTimestamp=" + r1 + ", estimatedDuration=" + r0);
        getBinding().c.setProgress(RangesKt.coerceAtLeast(getBinding().c.getProgress(), 50));
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(f r5, final d.b r6) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r6, "output");
        ResearchProcessBlock r0 = r5.b;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r5.a == false) goto L13;
        Integer r7 = r0.getStatus();
        int r1 = Status.STATUS_FINISH.getValue();
        if (r7 == null) goto L13;
        if (r7.intValue() != r1) goto L13;
        e1.o(getBinding().d);
        e1.x(getBinding().b);
        getBinding().b.setText(r0.title);
    L44:
        e1.d(getBinding().a, new c(r6, this));
        getBinding().a.setOnLongClickListener(new ok8.d(r6));
        r6.c();
        return;
    L13:
        e1.x(getBinding().d);
        e1.o(getBinding().b);
        getBinding().f.setText(r0.title);
        getBinding().e.setText(r0.getSubtitle());
        Integer r8 = r0.getStatus();
        int r2 = Status.STATUS_FINISH.getValue();
        if (r8 != null) goto L17;
    L18:
        Integer r9 = r0.getStatus();
        int r3 = Status.STATUS_FAIL.getValue();
        if (r9 != null) goto L22;
    L23:
        String r10 = r0.getResourceId();
        if (r10 != null) goto L26;
    L29:
        boolean r11 = true;
    L30:
        if (r11 == true) goto L33;
        e1.x(getBinding().c);
    L34:
        Integer r12 = r0.getStatus();
        int r4 = Status.STATUS_PROCESSING.getValue();
        if (r12 != null) goto L38;
    L42:
        ok8.a r13 = this.a;
        r13.b = null;
        r13.a = false;
    L43:
        T5(r0);
        goto L44
    L38:
        if (r12.intValue() != r4) goto L42;
        ok8.a r14 = this.a;
        r14.b = r0;
        r14.a = true;
        if (r14.c == true) goto L43;
        r14.c = true;
        postDelayed(new e(this), 20000);
    L33:
        e1.o(getBinding().c);
        goto L34
    L26:
        if (r10.length() == 0) goto L29;
        r11 = false;
        goto L30
    L22:
        if (r9.intValue() == r3) goto L33;
    L17:
        if (r8.intValue() == r2) goto L33;
        goto L18
    }

    public static Unit R5(g r1, DeepResearchProgressCard r2, FrameLayout r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r1.b(r2.getBinding().c.getContext());
        return Unit.INSTANCE;
    }
}
