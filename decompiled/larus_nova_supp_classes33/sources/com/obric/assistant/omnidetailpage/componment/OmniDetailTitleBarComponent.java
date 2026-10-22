package com.obric.assistant.omnidetailpage.componment;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.common.apphost.AppHost;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.obric.assistant.card.databinding.ObricFragmentOmniDetailBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 #2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001#B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rH\u0002J\b\u0010\u001e\u001a\u00020\u0012H\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0002J\u0018\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\rH\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/assistant/omnidetailpage/componment/OmniDetailTitleBarComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/obric/assistant/omnidetailpage/componment/IOmniDetailTitleBarAbility;", "<init>", "()V", "binding", "Lcom/obric/assistant/card/databinding/ObricFragmentOmniDetailBinding;", "getBinding", "()Lcom/obric/assistant/card/databinding/ObricFragmentOmniDetailBinding;", "binding$delegate", "Lkotlin/Lazy;", "taskStartTime", "", "taskEndTime", "timerJob", "Lkotlinx/coroutines/Job;", "onAttach", "", "onViewCreated", "view", "Landroid/view/View;", "observerTaskStatus", "isFinishedStatus", "", "status", "", "formatDuration", "", "duration", "startTimer", "stopTimer", "updateTimeState", "startTimeStamp", "endTimeStamp", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniDetailTitleBarComponent extends BaseContentWidget implements d {
    public static final /* synthetic */ int q = 0;
    public final Lazy m;
    public long n;
    public long o;
    public Job p;

    public static final class a {
    }

    static {
    }

    public final ObricFragmentOmniDetailBinding h3() {
        return (ObricFragmentOmniDetailBinding) this.m.getValue();
    }

    public final void m3() {
        Job r0 = this.p;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.p = null;
        long r1 = this.n;
        if (r1 <= 0) goto L22;
        long r4 = this.o;
        if (r4 <= 0) goto L22;
        if (r4 < r1) goto L22;
        ObricFragmentOmniDetailBinding r2 = h3();
        if (r2 == null) goto L16;
        TextView r3 = r2.m;
        if (r3 == null) goto L16;
        e1.x(r3);
    L16:
        long r5 = this.o - this.n;
        ObricFragmentOmniDetailBinding r6 = h3();
        if (r6 == null) goto L34;
        TextView r7 = r6.m;
        if (r7 == null) goto L35;
        r7.setText(Y2(r5));
        return;
    L35:
        return;
    L34:
        return;
    L22:
        if (r1 <= 0) goto L37;
        ObricFragmentOmniDetailBinding r8 = h3();
        if (r8 == null) goto L28;
        TextView r9 = r8.m;
        if (r9 == null) goto L28;
        e1.x(r9);
    L28:
        long r10 = AppHost.a.getAppClock().currentTimeMillis() - this.n;
        ObricFragmentOmniDetailBinding r11 = h3();
        if (r11 == null) goto L38;
        TextView r12 = r11.m;
        if (r12 == null) goto L39;
        r12.setText(Y2(r10));
        return;
    L39:
        return;
    L38:
        return;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, d.class);
    }

    public OmniDetailTitleBarComponent() {
        this.m = LazyKt.lazy(new z(this));
        this.o = -1;
    }

    public final String Y2(long r11) {
        long r12 = RangesKt.coerceAtLeast(r11, 0);
        long r2 = 3600;
        long r4 = r12 / r2;
        long r6 = 60;
        long r3 = (r12 % r2) / r6;
        long r13 = r12 % r6;
        if (r4 <= 0) goto L6;
        return getContext().getString(2131912282, new Object[]{String.valueOf(r4), String.valueOf(r3)});
    L6:
        if (r3 <= 0) goto L9;
        return getContext().getString(2131912283, new Object[]{String.valueOf(r3), String.valueOf(r13)});
    L9:
        return getContext().getString(2131912284, new Object[]{String.valueOf(r13)});
    }

    public final void onViewCreated(View r7) {
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r7, "view");
        ObricFragmentOmniDetailBinding r8 = h3();
        if (r8 == null) goto L7;
        AppCompatImageView r9 = r8.c;
        if (r9 == null) goto L7;
        r9.setOnClickListener(new a0(this));
    L7:
        com.obric.assistant.omnidetailpage.componment.a r10 = (com.obric.assistant.omnidetailpage.componment.a) s1a.d.a(this).getAbility(com.obric.assistant.omnidetailpage.componment.a.class);
        if (r10 == null) goto L14;
        StateFlowImpl r11 = r10.Dy();
        if (r11 == null) goto L15;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new OmniDetailTitleBarComponent$observerTaskStatus$1(r11, this, null), 3, null);
        return;
    L15:
        return;
    }

    @Override // com.obric.assistant.omnidetailpage.componment.d
    public final void QV(long r7, long r9) {
        if (r7 <= 0) goto L6;
        this.n = r7;
    L6:
        if (r9 <= 0) goto L8;
        this.o = r9;
    L8:
        com.obric.assistant.omnidetailpage.componment.a r8 = (com.obric.assistant.omnidetailpage.componment.a) s1a.d.a(this).getAbility(com.obric.assistant.omnidetailpage.componment.a.class);
        boolean r10 = false;
        if (r8 != null) goto L11;
    L13:
        boolean r11 = false;
    L14:
        if (r11 == false) goto L16;
        m3();
        return;
    L16:
        Job r12 = this.p;
        if (r12 != null) goto L19;
    L21:
        if (r10 == true) goto L26;
        this.p = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new OmniDetailTitleBarComponent$startTimer$1(this, null), 3, null);
        return;
    L26:
        return;
    L19:
        if (r12.isActive() != true) goto L21;
        r10 = true;
        goto L21
    L11:
        if (r8.ss() != true) goto L13;
        r11 = true;
        goto L14
    }
}
