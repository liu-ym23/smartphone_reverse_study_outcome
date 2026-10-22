package com.larus.bmhome.chat.standarduikit.deepresearchcard.view;

import android.content.Context;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.im.bean.message.block.ResearchBlock;
import com.larus.mainbot.impl.databinding.LarusCardDeepResearchReportBinding;
import com.larus.utils.e1;
import dg8.s;
import gw8.c;
import gw8.c$b;
import kk8.a;
import kk8.b;
import kk8.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lk8.e;
import lw8.l;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0004H\u0016R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/deepresearchcard/view/DeepResearchCardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/deepresearchcard/view/DeepResearchCardViewInput;", "Lcom/larus/bmhome/chat/standarduikit/deepresearchcard/view/DeepResearchCardViewOutput;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusCardDeepResearchReportBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusCardDeepResearchReportBinding;", "binding$delegate", "Lkotlin/Lazy;", "bindData", "", "input", "output", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeepResearchCardView extends ConstraintLayout {
    public static final /* synthetic */ int b = 0;
    public final Lazy a;

    private final LarusCardDeepResearchReportBinding getBinding() {
        return (LarusCardDeepResearchReportBinding) this.a.getValue();
    }

    public DeepResearchCardView(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = LazyKt.lazy(new a(r2, this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(d r24, final e.a r25) {
        Intrinsics.checkNotNullParameter(r24, "input");
        Intrinsics.checkNotNullParameter(r25, "output");
        ResearchBlock r3 = r24.d;
        if (r3 != null) goto L5;
        return;
    L5:
        int r4 = r24.e;
        if (getBinding().a.getWidth() == r4) goto L12;
        ConstraintLayout r5 = getBinding().a;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L11;
        r6.width = r4;
        r5.setLayoutParams(r6);
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L12:
        getBinding().d.setText(getResources().getText(2131901469));
        String r10 = r3.getBrief();
        if (r10 == null) goto L20;
        c.a.getClass();
        c r7 = c.a.b();
        if (r7 == null) goto L17;
        Context r8 = getContext();
        int r9 = r4 - (i5.q() * 2);
        Lazy r11 = s.a;
        l r1 = c$b.a(r7, r8, r9, r10, true, s.a(getContext(), false, false, r24.a, Integer.valueOf(i5.r0()), null, false, r24.f, false, false, 1888), null, null, 224);
    L18:
        getBinding().e.setMarkdown(r1);
        e1.d(getBinding().b, new b(r25, this));
        getBinding().b.setOnLongClickListener(new kk8.c(r25, this));
        r25.c();
        return;
    L17:
        r1 = null;
        goto L18
    }
}
