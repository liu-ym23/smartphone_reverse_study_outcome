package com.larus.bmhome.interactionpanel;

import android.view.View;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 32\u00060\u0001j\u0002`\u0002:\u00013B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020$H\u0016J\u0010\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020*H\u0002J\u0018\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020*H\u0002J\b\u0010/\u001a\u000200H\u0002J\n\u00101\u001a\u0004\u0018\u00010 H\u0002J\b\u00102\u001a\u000200H\u0002J\f\u0010.\u001a\u00020**\u00020 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/larus/bmhome/interactionpanel/ThreadInteractionPanelHostComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "manager", "Lcom/larus/bmhome/interactionpanel/IInteractionPanelQueueManager;", "<init>", "(Lcom/larus/bmhome/interactionpanel/IInteractionPanelQueueManager;)V", "cotDetailFragmentAbility", "Lcom/larus/bmhome/chat/cotdetail/ability/CotDetailFragmentAbility;", "getCotDetailFragmentAbility", "()Lcom/larus/bmhome/chat/cotdetail/ability/CotDetailFragmentAbility;", "cotDetailMessageListAbility", "Lcom/larus/bmhome/chat/cotdetail/ability/ICotDetailMessageListAbility;", "getCotDetailMessageListAbility", "()Lcom/larus/bmhome/chat/cotdetail/ability/ICotDetailMessageListAbility;", "clarificationAbility", "Lcom/larus/bmhome/clarification/IClarificationAbility;", "getClarificationAbility", "()Lcom/larus/bmhome/clarification/IClarificationAbility;", "inputAreaBlockAbility", "Lcom/larus/bmhome/inputarea/IInputAreaBlockAbility;", "getInputAreaBlockAbility", "()Lcom/larus/bmhome/inputarea/IInputAreaBlockAbility;", "renderer", "Lcom/larus/bmhome/interactionpanel/InteractionPanelRenderer;", "getRenderer", "()Lcom/larus/bmhome/interactionpanel/InteractionPanelRenderer;", "renderer$delegate", "Lkotlin/Lazy;", "observeJob", "Lkotlinx/coroutines/Job;", "currentScope", "Lcom/larus/bmhome/interactionpanel/InteractionPanelHostScope$ThreadOrganizer;", "currentEntry", "Lcom/larus/bmhome/interactionpanel/InteractionPanelEntry;", "onViewCreated", "", "view", "Landroid/view/View;", "onFragmentViewDestroyed", "bindThreadScope", "reason", "", "handleSnapshot", "snapshot", "Lcom/larus/bmhome/interactionpanel/InteractionPanelSnapshot;", "hostId", "canShowHost", "", "buildScope", "isCurrentThreadStreaming", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThreadInteractionPanelHostComponent extends BaseContentWidget {
    public static final /* synthetic */ int r = 0;
    public final g m;
    public final Lazy n;
    public Job o;
    public n.b p;
    public m q;

    public static final class a {
    }

    static {
    }

    public ThreadInteractionPanelHostComponent() {
        this(0);
    }

    public final void A2() {
        Job r0 = this.o;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.o = null;
        h3().a(this.q, "page_destroyed");
        this.q = null;
        this.p = null;
    }

    public final u h3() {
        return (u) this.n.getValue();
    }

    public final fe8.a Y2() {
        return s1a.d.a(this).getAbility(fe8.a.class);
    }

    public ThreadInteractionPanelHostComponent(int r2) {
        g r3 = s.a();
        Intrinsics.checkNotNullParameter(r3, "manager");
        this.m = r3;
        this.n = LazyKt.lazy(new w0(this));
    }

    public final void onViewCreated(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r3, "view");
        F2().post(new y0(this, "onViewCreated"));
        fe8.a r4 = Y2();
        if (r4 == null) goto L6;
        r4.RG(new x0(this));
        return;
    }
}
