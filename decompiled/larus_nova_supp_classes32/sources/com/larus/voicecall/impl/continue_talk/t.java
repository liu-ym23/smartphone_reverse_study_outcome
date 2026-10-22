package com.larus.voicecall.impl.continue_talk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.reference.a;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.databinding.LarusLayoutContinuousBottomContainerBinding;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class t implements Runnable {
    public final /* synthetic */ ChatContinuousTalkComponent a;

    public /* synthetic */ t(ChatContinuousTalkComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final ChatContinuousTalkComponent r1 = this.a;
        int r2 = ChatContinuousTalkComponent.M;
        fa9.e.a.a("voice_input", r1.o);
        if (r1.n != null) goto L53;
        View r4 = null;
        if (z2.a.enableChatWithTab() == false) goto L12;
        ViewStub r3 = r1.L;
        if (r3 == null) goto L53;
        r3.setLayoutResource(2131562789);
        View r5 = r3.inflate();
        if (r5 == null) goto L53;
        LarusLayoutContinuousBottomContainerBinding r6 = LarusLayoutContinuousBottomContainerBinding.a(r5);
    L29:
        Intrinsics.checkNotNull(r6);
        r6.c.setVisibility(8);
        r1.n = r6;
        ComponentViewModel.onEach$default(r1.m3(), ChatContinuousTalkComponent$observeCloseEvent$1.INSTANCE, null, new ChatContinuousTalkComponent$observeCloseEvent$2(r1, null), 2, null);
        ComponentViewModel.onEach$default(r1.m3(), ChatContinuousTalkComponent$observeQueryBeginEvent$1.INSTANCE, null, new ChatContinuousTalkComponent$observeQueryBeginEvent$2(r1, null), 2, null);
        ComponentViewModel.onEach$default(r1.m3(), ChatContinuousTalkComponent$observeQueryEndEvent$1.INSTANCE, null, new ChatContinuousTalkComponent$observeQueryEndEvent$2(r1, null), 2, null);
        ComponentViewModel.onEach$default(r1.m3(), ChatContinuousTalkComponent$observeOnUIStateChanged$1.INSTANCE, null, new ChatContinuousTalkComponent$observeOnUIStateChanged$2(r1, null), 2, null);
        LarusLayoutContinuousBottomContainerBinding r7 = r1.n;
        if (r7 == null) goto L34;
        ChatContinuousTalkLayout r8 = r7.d;
        if (r8 == null) goto L34;
        ConstraintLayout r9 = r8.getHotArea();
    L35:
        com.larus.utils.e1.d(r9, new b0(r1));
        LarusLayoutContinuousBottomContainerBinding r10 = r1.n;
        if (r10 == null) goto L40;
        ChatContinuousTalkLayout r11 = r10.d;
        if (r11 == null) goto L40;
        View r12 = r11.getRightIcon();
    L41:
        com.larus.utils.e1.d(r12, new c0(r1));
        LarusLayoutContinuousBottomContainerBinding r13 = r1.n;
        if (r13 == null) goto L46;
        ChatContinuousTalkLayout r14 = r13.d;
        if (r14 == null) goto L46;
        r4 = r14.getLeftIcon();
    L46:
        com.larus.utils.e1.d(r4, new d0(r1));
        LarusLayoutContinuousBottomContainerBinding r15 = r1.n;
        if (r15 == null) goto L53;
        ChatContinuousTalkLayout r16 = r15.d;
        if (r16 == null) goto L53;
        View r17 = r16.getLeftIcon();
        if (r17 == null) goto L53;
        r17.setOnLongClickListener(new e0(r1));
    L40:
        r12 = null;
    L34:
        r9 = null;
        goto L35
    L12:
        FragmentActivity r18 = r1.C3();
        if (r18 == null) goto L21;
        Window r19 = r18.getWindow();
        if (r19 == null) goto L21;
        View r20 = r19.getDecorView();
        if (c.e == false) goto L23;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r21 = ThreadMethodProxy.currentThread();
        if (r21 == c.a) goto L23;
        c.a(r21, "getDecorView");
    L23:
        if ((r20 instanceof ViewGroup) == false) goto L25;
        ViewGroup r22 = (ViewGroup) r20;
    L26:
        if (r22 == null) goto L53;
        r6 = LarusLayoutContinuousBottomContainerBinding.a(LayoutInflater.from(r1.getContext()).inflate(2131562789, r22, false));
        goto L29
    L25:
        r22 = null;
    L21:
        r20 = null;
    L53:
        a r23 = (a) r1.v.getValue();
        if (r23 == null) goto L56;
        r23.sZ();
    L56:
        com.larus.bmhome.instruction.g r24 = (com.larus.bmhome.instruction.g) r1.w.getValue();
        if (r24 == null) goto L59;
        r24.A1();
    L59:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r25 = (com.larus.bmhome.chat.component.bottom.attachment.g1) r1.x.getValue();
        if (r25 != null) goto L62;
    L64:
        ICoreInputAbility r26 = (ICoreInputAbility) r1.s.getValue();
        if (r26 == null) goto L67;
        r26.C1(false, false, NameKeys.UnloadStrategy_No_Strategy);
    L67:
        ICoreInputAbility r27 = (ICoreInputAbility) r1.s.getValue();
        if (r27 == null) goto L71;
        r27.qp(false);
    L71:
        if (z2.a.enableChatWithTab() == true) goto L84;
        LarusLayoutContinuousBottomContainerBinding r28 = r1.n;
        if (r28 == null) goto L84;
        FrameLayout r29 = r28.a;
        if (r29 == null) goto L84;
        if (r1.E == true) goto L84;
        r1.E = true;
        FrameLayout.LayoutParams r30 = new FrameLayout.LayoutParams(-1, -1);
        FragmentActivity r31 = r1.C3();
        if (r31 == null) goto L84;
        r31.addContentView(r29, r30);
    L84:
        LarusLayoutContinuousBottomContainerBinding r32 = r1.n;
        if (r32 == null) goto L90;
        FrameLayout r33 = r32.c;
        if (r33 == null) goto L91;
        r33.setVisibility(0);
        return;
    L91:
        return;
    L90:
        return;
    L62:
        if (r25.isVisible() == false) goto L64;
        r25.b2(r25.uM());
        goto L64
    }
}
