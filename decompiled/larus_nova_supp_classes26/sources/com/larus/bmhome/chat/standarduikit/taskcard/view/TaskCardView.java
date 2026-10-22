package com.larus.bmhome.chat.standarduikit.taskcard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.view.screenmenu.d;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.dialog.u;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Status;
import com.larus.im.bean.message.block.TaskCardActionStage;
import com.larus.im.bean.message.block.TaskCardBlock;
import com.larus.im.bean.message.block.TaskCardStyle;
import com.larus.mainbot.impl.databinding.LarusCardTaskProgressBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import ee8.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import un8.f;
import un8.g;
import un8.h;
import un8.i;
import un8.j;
import un8.k;
import un8.l;
import un8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 %2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001%B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010!\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\u0018\u0010$\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0004H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006&"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/taskcard/view/TaskCardView;", "Landroid/widget/FrameLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/taskcard/view/TaskCardViewInput;", "Lcom/larus/bmhome/chat/standarduikit/taskcard/view/TaskCardViewOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "disableClickFromSkip", "Lcom/larus/im/bean/message/block/TaskCardActionStage;", "cycleInfo", "Lcom/larus/bmhome/chat/standarduikit/taskcard/view/CycleInfo;", "binding", "Lcom/larus/mainbot/impl/databinding/LarusCardTaskProgressBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusCardTaskProgressBinding;", "binding$delegate", "Lkotlin/Lazy;", "bindData", "", "input", "output", "updateProgressLayout", "data", "Lcom/larus/im/bean/message/block/TaskCardBlock;", "isFinished", "", "tryStartCycleTask", "updateProgress", "cycleTask", "isDisableClick", "updateButtonView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskCardView extends FrameLayout {
    public static final /* synthetic */ int d = 0;
    public TaskCardActionStage a;
    public final un8.a b;
    public final Lazy c;

    public static final class a {
    }

    public static final class b implements p0 {
        public final /* synthetic */ LinearLayout a;
        public final /* synthetic */ m b;
        public final /* synthetic */ TaskCardView c;
        public final /* synthetic */ l d;

        public final void confirm() {
            d r0 = d.a;
            d.b(this.a);
            this.b.a(this.c.getContext(), TaskCardBtnAction.STOP_TASK);
            TaskCardView r1 = this.c;
            r1.a = TaskCardActionStage.THINKING;
            r1.d(this.d, this.b);
            Message r2 = this.d.c;
            String r3 = null;
            if (r2 == null) goto L5;
            String r4 = r2.getMessageId();
        L6:
            Message r5 = this.d.c;
            if (r5 == null) goto L9;
            r3 = r5.getConversationId();
        L9:
            e.c(r4, r3, this.d.b, "general_agent_card");
            return;
        L5:
            r4 = null;
            goto L6
        }

        public b(LinearLayout r1, m r2, TaskCardView r3, l r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class c implements u {
        public final /* synthetic */ LinearLayout a;

        public final void cancel() {
            d r0 = d.a;
            d.b(this.a);
        }

        public c(LinearLayout r1) {
            this.a = r1;
        }
    }

    public TaskCardView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TaskCardView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
    }

    private final LarusCardTaskProgressBinding getBinding() {
        return (LarusCardTaskProgressBinding) this.c.getValue();
    }

    public final boolean c() {
        if (this.a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void e(TaskCardBlock r12) {
        Long r0 = null;
        if (r12 == null) goto L5;
        Long r1 = r12.startTimestamp;
    L6:
        if (r12 == null) goto L9;
        r0 = r12.estimatedDuration;
    L9:
        if (r1 == null) goto L14;
        if (r0 == null) goto L14;
        long r3 = AppHost.a.getAppClock().currentTimeMillis() / ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY);
        float r5 = RangesKt.coerceAtLeast(r3 - r1.longValue(), 0);
        float r6 = RangesKt.coerceIn(r5 / r0.longValue(), 0.0f, 1.0f);
        float r7 = new DecelerateInterpolator(2.0f).getInterpolation(r6);
        int r8 = (int) (100 * r7);
        FLogger.a.d("TaskCardView", "updateProgress: startTimestamp=" + r1 + ", current = " + r3 + " estimatedDuration=" + r0 + ", elapsed=" + r5 + ", fraction=" + r6 + ", eased=" + r7 + ", newProgress=" + r8);
        getBinding().g.setProgress(RangesKt.coerceAtLeast(getBinding().g.getProgress(), r8));
        return;
    L14:
        FLogger.a.d("TaskCardView", "updateProgress: startTimestamp=" + r1 + ", estimatedDuration=" + r0);
        getBinding().g.setProgress(RangesKt.coerceAtLeast(getBinding().g.getProgress(), 50));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void b(l r5, final vn8.c.a r6) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r6, "output");
        TaskCardBlock r0 = r5.d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r5.a == true) goto L22;
        Integer r1 = r0.status;
        Status r2 = Status.STATUS_PROCESSING;
        int r3 = r2.getValue();
        if (r1 == null) goto L22;
        if (r1.intValue() != r3) goto L22;
        e1.x(getBinding().h);
        e1.o(getBinding().c);
        getBinding().m.setText(r0.title);
        getBinding().l.setText(r0.subTitle);
        e1.x(getBinding().g);
        Integer r4 = r0.status;
        int r7 = r2.getValue();
        if (r4 != null) goto L16;
    L20:
        un8.a r8 = this.b;
        r8.b = null;
        r8.a = false;
    L21:
        e(r0);
    L29:
        d(r5, r6);
        e1.d(getBinding().a, new un8.c(r6, this));
        getBinding().a.setOnLongClickListener(new un8.d(r6));
        r6.d();
        return;
    L16:
        if (r4.intValue() != r7) goto L20;
        un8.a r9 = this.b;
        r9.b = r0;
        r9.a = true;
        if (r9.c == true) goto L21;
        r9.c = true;
        postDelayed(new un8.e(this), 20000);
    L22:
        Integer r10 = r0.style;
        int r11 = TaskCardStyle.DEFAULT.getValue();
        if (r10 != null) goto L26;
    L28:
        e1.o(getBinding().h);
        e1.x(getBinding().c);
        getBinding().c.setText(r0.title);
        goto L29
    L26:
        if (r10.intValue() != r11) goto L28;
        e1.x(getBinding().h);
        e1.o(getBinding().c);
        getBinding().m.setText(r0.title);
        getBinding().l.setText(r0.subTitle);
        e1.o(getBinding().g);
        goto L29
    }

    public final void d(final l r8, final m r9) {
        TaskCardBlock r0 = r8.d;
        if (r0 != null) goto L5;
        return;
    L5:
        LarusCardTaskProgressBinding r1 = getBinding();
        Integer r2 = r0.status;
        int r3 = Status.STATUS_PROCESSING.getValue();
        if (r2 != null) goto L9;
    L48:
        e1.o(r1.b);
        return;
    L9:
        if (r2.intValue() != r3) goto L48;
        Integer r4 = r0.style;
        int r5 = TaskCardStyle.DEFAULT.getValue();
        if (r4 == null) goto L48;
        if (r4.intValue() != r5) goto L48;
        Integer r6 = r0.action;
        TaskCardActionStage r7 = TaskCardActionStage.COMPUTER_BROWSER;
        int r10 = r7.getValue();
        if (r6 == null) goto L22;
        if (r6.intValue() != r10) goto L22;
    L25:
        if (c() == false) goto L27;
        int r11 = ContextCompat.getColor(getContext(), v19.c.b(2130972081, getContext(), 2131103143));
        r1.f.setTextColor(r11);
        r1.k.setTextColor(r11);
        r1.d.setColorFilter(r11);
        r1.i.setColorFilter(r11);
    L28:
        Integer r12 = r0.action;
        int r13 = TaskCardActionStage.THINKING.getValue();
        if (r12 != null) goto L32;
    L34:
        int r14 = r7.getValue();
        if (r12 != null) goto L38;
    L40:
        int r15 = TaskCardActionStage.LARK_AUTH.getValue();
        if (r12 != null) goto L44;
    L46:
        e1.o(r1.b);
        return;
    L44:
        if (r12.intValue() != r15) goto L46;
        e1.x(r1.b);
        r1.d.setImageResource(2131242846);
        r1.f.setText(getContext().getString(2131910381));
        r1.k.setText(getContext().getString(2131910380));
        e1.d(r1.e, new j(this, r9));
        e1.d(r1.j, new k(this, r9));
        return;
    L38:
        if (r12.intValue() != r14) goto L40;
        e1.x(r1.b);
        r1.d.setImageResource(2131242846);
        r1.f.setText(getContext().getString(2131910382));
        r1.k.setText(getContext().getString(2131910380));
        e1.d(r1.e, new h(this, r9));
        e1.d(r1.j, new i(this, r9, r8));
        return;
    L32:
        if (r12.intValue() != r13) goto L34;
        e1.x(r1.b);
        r1.d.setImageResource(2131242848);
        r1.f.setText(getContext().getString(2131910377));
        r1.k.setText(getContext().getString(2131910389));
        e1.d(r1.e, new f(this, r9));
        e1.d(r1.j, new g(this, r8, r9));
        return;
    L27:
        int r16 = ContextCompat.getColor(getContext(), v19.c.b(2130972079, getContext(), 2131103136));
        r1.f.setTextColor(r16);
        r1.k.setTextColor(r16);
        r1.d.setColorFilter(r16);
        r1.i.setColorFilter(r16);
    L22:
        if (this.a != r7) goto L25;
        this.a = null;
        goto L25
    }

    public TaskCardView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = new un8.a(0);
        this.c = LazyKt.lazy(new un8.b(r2, this));
    }

    public static Unit a(m r1, TaskCardView r2, LinearLayout r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r1.b(r2.getBinding().a.getContext());
        return Unit.INSTANCE;
    }

    public /* synthetic */ TaskCardView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
