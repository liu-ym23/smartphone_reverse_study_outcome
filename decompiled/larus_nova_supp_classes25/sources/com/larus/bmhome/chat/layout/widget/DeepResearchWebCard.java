package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.ResearchWebpageBlock;
import com.larus.im.bean.message.block.Status;
import com.larus.mainbot.impl.databinding.LarusCardDeepResearchWebBinding;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 02\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JB\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000f2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"J*\u0010$\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0002J.\u0010%\u001a\u00020\u00172\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u0006\u0010&\u001a\u00020#2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170'H\u0002J\u001a\u0010(\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u001f\u0010)\u001a\u00020\u00172\b\u0010*\u001a\u0004\u0018\u00010\u000f2\u0006\u0010+\u001a\u00020\rH\u0002¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020\u0017H\u0002J\b\u0010.\u001a\u00020\u0017H\u0014J\b\u0010/\u001a\u00020\u0017H\u0014R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/DeepResearchWebCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusCardDeepResearchWebBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusCardDeepResearchWebBinding;", "binding$delegate", "Lkotlin/Lazy;", "isAttachedToWindow", "", "currentStatus", "", "Ljava/lang/Integer;", "loadingStartTime", "", "loadingDuration", "loadingJob", "Lkotlinx/coroutines/Job;", "bindData", "", "fragment", "Landroidx/fragment/app/Fragment;", "blockLongClickHandler", "Lcom/larus/bmhome/chat/block/base/config/IBlockLongClickHandler;", "message", "Lcom/larus/im/bean/message/Message;", "block", "Lcom/larus/im/bean/message/block/Block;", "maxContentWidth", "traceIdCache", "", "", "mobCardShowEvent", "reportOnceForKey", "key", "Lkotlin/Function0;", "mobClickEvent", "updateStatus", "status", "hasResourceId", "(Ljava/lang/Integer;Z)V", "startLoading", "onAttachedToWindow", "onDetachedFromWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepResearchWebCard extends ConstraintLayout {
    public static final /* synthetic */ int g = 0;
    public final Lazy a;
    public boolean b;
    public Integer c;
    public long d;
    public long e;
    public Job f;

    public static final class a {
    }

    static {
    }

    private final LarusCardDeepResearchWebBinding getBinding() {
        return (LarusCardDeepResearchWebBinding) this.a.getValue();
    }

    public final void T5() {
        Job r0 = this.f;
        DeepResearchWebProgressBar r1 = null;
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L6:
        if ((System.currentTimeMillis() - this.d) < this.e) goto L13;
        DeepResearchWebProgressBar r2 = getBinding().d;
        if ((r2 instanceof DeepResearchWebProgressBar) == false) goto L10;
        r1 = r2;
    L10:
        if (r1 == null) goto L15;
        r1.setProgress(0.9f);
        return;
    L15:
        return;
    L13:
        this.f = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DeepResearchWebCard$startLoading$1(this, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        this.b = true;
        Integer r0 = this.c;
        int r1 = Status.STATUS_PROCESSING.getValue();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.intValue() != r1) goto L9;
        T5();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        this.b = false;
        Job r0 = this.f;
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
        return;
    }

    public DeepResearchWebCard(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = LazyKt.lazy(new c0(r2, this));
    }

    public static final /* synthetic */ LarusCardDeepResearchWebBinding R5(DeepResearchWebCard r0) {
        return r0.getBinding();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.larus.bmhome.chat.layout.widget.f0] */
    public final void S5(final Fragment r17, final kc8.z r18, final Message r19, Block r20, int r21, Set<Object> r22) {
        Intrinsics.checkNotNullParameter(r19, "message");
        Intrinsics.checkNotNullParameter(r20, "block");
        BlockContent r5 = r20.getContent();
        if (r5 == null) goto L80;
        final ResearchWebpageBlock r6 = r5.getResearchWebpageBlock();
        if (r6 == null) goto L83;
        Long r7 = r6.getCreateTimestamp();
        long r9 = 0;
        if (r7 == null) goto L10;
        long r11 = r7.longValue() * 1000;
    L11:
        this.d = r11;
        Long r8 = r6.getEstimatedDuration();
        if (r8 == null) goto L14;
        r9 = r8.longValue() * 1000;
    L14:
        this.e = r9;
        if (getBinding().a.getWidth() == r21) goto L21;
        ConstraintLayout r10 = getBinding().a;
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if (r12 == null) goto L20;
        r12.width = r21;
        r10.setLayoutParams(r12);
        goto L21
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L21:
        getBinding().e.setText(r6.getTitle());
        Integer r3 = r6.getStatus();
        String r13 = r6.getResourceId();
        boolean r14 = false;
        if (r13 != null) goto L24;
    L27:
        boolean r15 = true;
    L28:
        boolean r16 = !r15;
        if (Intrinsics.areEqual(r3, this.c) == true) goto L70;
        int r23 = Status.STATUS_PROCESSING.getValue();
        if (r3 != null) goto L35;
    L40:
        int r24 = Status.STATUS_FAIL.getValue();
        if (r3 != null) goto L44;
    L55:
        AppCompatImageView r25 = getBinding().c;
        if (r25 == null) goto L62;
        AppCompatImageView r110 = getBinding().c;
        if (r110 == null) goto L60;
        Context r111 = r110.getContext();
    L61:
        r25.setImageResource(v19.c.b(2130971899, r111, 2131242342));
        goto L62
    L60:
        r111 = null;
    L62:
        getBinding().d.setVisibility(4);
        getBinding().c.setVisibility(0);
        if (r16 == false) goto L65;
        int r26 = v19.c.b(2130972079, getContext(), 2131103136);
    L66:
        getBinding().e.setTextColor(ContextCompat.getColor(getContext(), r26));
        Job r27 = this.f;
        if (r27 == null) goto L69;
        Job.DefaultImpls.cancel$default(r27, null, 1, null);
    L69:
        this.c = r3;
        goto L70
    L65:
        r26 = v19.c.b(2130972082, getContext(), 2131103146);
        goto L66
    L44:
        if (r3.intValue() != r24) goto L55;
        AppCompatImageView r28 = getBinding().c;
        if (r28 == null) goto L52;
        AppCompatImageView r29 = getBinding().c;
        if (r29 == null) goto L50;
        Context r30 = r29.getContext();
    L51:
        r28.setImageResource(v19.c.b(2130971905, r30, 2131242366));
        goto L52
    L50:
        r30 = null;
    L52:
        getBinding().d.setVisibility(4);
        getBinding().c.setVisibility(0);
        getBinding().e.setTextColor(ContextCompat.getColor(getContext(), v19.c.b(2130972082, getContext(), 2131103146)));
        Job r31 = this.f;
        if (r31 == null) goto L69;
        Job.DefaultImpls.cancel$default(r31, null, 1, null);
        goto L69
    L35:
        if (r3.intValue() != r23) goto L40;
        if (r16 == false) goto L40;
        getBinding().d.setVisibility(0);
        getBinding().c.setVisibility(4);
        getBinding().e.setTextColor(ContextCompat.getColor(getContext(), v19.c.b(2130972079, getContext(), 2131103136)));
        if (this.b == false) goto L69;
        T5();
    L70:
        com.larus.utils.e1.d(getBinding().b, new d0(r6, r17, this, r19));
        getBinding().b.setOnLongClickListener(new e0(r18));
        String r4 = "deep_research_webpage_card_show_" + r19.getMessageId();
        ?? r32 = new f0(r17, r19);
        if (r22 != null) goto L73;
    L75:
        if (r14 == true) goto L81;
        r32.invoke();
        if (r22 == null) goto L82;
        r22.add(r4);
        return;
    L82:
        return;
    L81:
        return;
    L73:
        if (r22.contains(r4) != true) goto L75;
        r14 = true;
        goto L75
    L24:
        if (r13.length() == 0) goto L27;
        r15 = false;
        goto L28
    L10:
        r11 = 0;
        goto L11
    L83:
        return;
    }
}
