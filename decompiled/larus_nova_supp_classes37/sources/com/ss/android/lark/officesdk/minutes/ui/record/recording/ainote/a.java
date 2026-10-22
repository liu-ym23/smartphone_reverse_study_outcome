package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.MmRecordingAINoteRepo;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final /* synthetic */ int n = 0;
    public final String a;
    public final String b;
    public final MmRecordingUILaunchMode c;
    public final Function0<MmRecordingAINoteRepo> d;
    public final Function1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l, Boolean> e;
    public long f;
    public boolean g;
    public FragmentActivity h;
    public MmAINoteFragment i;
    public boolean j;
    public MmAINoteControl$registerBackPressedHandlerIfNeeded$1 k;
    public boolean l;
    public final Map<String, Function1<Boolean, Unit>> m;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.a$a, reason: collision with other inner class name */
    public static final class C0058a {
    }

    static {
    }

    public final void b() {
        if (this.j == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        this.j = false;
        a(false);
        FragmentActivity r1 = this.h;
        MmAINoteFragment r2 = this.i;
        this.i = null;
        if (r2 == null) goto L12;
        r2.k = null;
    L12:
        if (r2 == null) goto L14;
        r2.l = null;
    L14:
        if (r1 == null) goto L19;
        if (r2 == null) goto L19;
        if (r2.isAdded() == false) goto L19;
        r1.getSupportFragmentManager().beginTransaction().remove(r2).commitAllowingStateLoss();
    L19:
        MmAINoteControl$registerBackPressedHandlerIfNeeded$1 r3 = this.k;
        if (r3 == null) goto L22;
        r3.remove();
    L22:
        this.k = null;
        this.h = null;
        if (r0 == false) goto L26;
        int r4 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "release", "ownerKey=" + this.a, null, 8);
        return;
    L26:
        return;
    L5:
        if (this.i != null) goto L8;
        r0 = false;
        goto L9
    }

    public final void a(boolean r4) {
        if (this.l != r4) goto L5;
        return;
    L5:
        this.l = r4;
        Iterator r0 = CollectionsKt.toList(((LinkedHashMap) this.m).values()).iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((Function1) r0.next()).invoke(Boolean.valueOf(r4));
        goto L7
    }

    public final long c(long r6) {
        if (r6 <= 0) goto L5;
        return r6;
    L5:
        if (this.f <= 0) goto L9;
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "resolveEffectiveDuration", "keep cached duration, ownerKey=" + this.a + " incoming=" + r6 + " cached=" + this.f, null, 8);
        return this.f;
    L9:
        return r6;
    }

    /* JADX WARN: Type inference failed for: r3v15, types: [androidx.activity.OnBackPressedCallback, com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteControl$registerBackPressedHandlerIfNeeded$1] */
    public final void d(FragmentActivity r22, long r23, final long r25) {
        Intrinsics.checkNotNullParameter(r22, "activity");
        if (r22.isFinishing() == false) goto L5;
    L110:
        int r0 = bwb.b.a;
        bwb.b.d(MmUiLogScene.AI_NOTE, "show", "skip, invalid activity state, ownerKey=" + this.a, null);
        return;
    L5:
        if (r22.isDestroyed() == true) goto L110;
        if (r22.getSupportFragmentManager().isStateSaved() == true) goto L110;
        final long r14 = c(r23);
        this.f = r14;
        final ViewGroup r2 = (ViewGroup) r22.findViewById(2131380181);
        if (r2 != null) goto L12;
        r2 = (ViewGroup) r22.findViewById(R.id.content);
    L12:
        if (r2 != null) goto L14;
        return;
    L14:
        boolean r11 = false;
        final boolean r12 = true;
        if (this.h == r22) goto L17;
    L56:
        MmAINoteFragment r5 = this.i;
        if (r5 == null) goto L63;
        r5.k = null;
        r5.l = null;
        this.i = null;
        Intrinsics.checkNotNullParameter("replace_detached_sheet", "reason");
        MmAINotePanelAnimator r7 = r5.q;
        if (r7 == null) goto L61;
        r7.r("replace_detached_sheet");
    L62:
        b();
        goto L63
    L61:
        r5.ga0();
    L63:
        this.h = r22;
        Integer r6 = Integer.valueOf(r2.getHeight());
        if (r6.intValue() <= 0) goto L66;
        boolean r8 = true;
    L67:
        if (r8 == true) goto L70;
        r6 = null;
    L70:
        if (r6 == null) goto L72;
    L71:
        int r1 = r6.intValue();
    L89:
        int r3 = (int) (r1 * 0.65f);
        FragmentActivity r13 = this.h;
        if (r13 == null) goto L95;
        MmRecordingAINoteRepo r9 = (MmRecordingAINoteRepo) this.d.invoke();
        if (r9 != null) goto L96;
        int r4 = bwb.b.a;
        bwb.b.d(MmUiLogScene.AI_NOTE, "showInternal", "skip, aiNoteRepo missing, ownerKey=" + this.a, null);
        goto L95
    L96:
        MmAINoteFragmentArgs r10 = new MmAINoteFragmentArgs(this.a, this.b, this.c, r3, r14, r25, true, this.g);
        int r15 = MmAINoteFragment.y;
        Intrinsics.checkNotNullParameter(r10, "args");
        MmAINoteFragment r16 = new MmAINoteFragment();
        Bundle r17 = new Bundle();
        r17.putSerializable("arg_ainote_args", r10);
        r16.setArguments(r17);
        r16.n = r9;
        final a r18 = this;
        r16.k = new MmAINoteControl$showInternal$newFragment$1$1(r2, r18);
        r16.l = new MmAINoteControl$showInternal$newFragment$1$2(r18);
        r16.m = r18.e;
        r18.i = r16;
        r18.j = true;
        FragmentActivity r19 = r18.h;
        if (r19 != null) goto L100;
    L103:
        FragmentTransaction r20 = r13.getSupportFragmentManager().beginTransaction();
        int r21 = r2.getId();
        String r24 = "MmAINoteControl:" + r18.a;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r20, r16, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r24, r21) == true) goto L107;
        r20 = r20.add(r21, r16, r24);
    L107:
        r20.commitNowAllowingStateLoss();
    L108:
        int r26 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "show", "ownerKey=" + r18.a + " meetingId=" + r18.b + " duration=" + r14, null, 8);
        return;
    L100:
        if (r18.k != null) goto L103;
        ?? r27 = new MmAINoteControl$registerBackPressedHandlerIfNeeded$1(r18);
        r19.getOnBackPressedDispatcher().addCallback(r19, r27);
        r18.k = r27;
    L95:
        r18 = this;
        goto L108
    L72:
        Window r28 = r22.getWindow();
        if (r28 == null) goto L85;
        View r29 = r28.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L79;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r30 = ThreadMethodProxy.currentThread();
        if (r30 == com.larus.home.impl.utils.c.a) goto L79;
        com.larus.home.impl.utils.c.a(r30, "getDecorView");
    L79:
        if (r29 == null) goto L85;
        r6 = Integer.valueOf(r29.getHeight());
        if (r6.intValue() <= 0) goto L83;
        r11 = true;
    L83:
        if (r11 == false) goto L85;
    L86:
        if (r6 != null) goto L71;
        r1 = y9c.d.g(r22);
    L85:
        r6 = null;
        goto L86
    L66:
        r8 = false;
        goto L67
    L17:
        if (this.j == false) goto L33;
        MmAINoteFragment r31 = this.i;
        if (r31 != null) goto L21;
    L23:
        boolean r32 = false;
    L24:
        if (r32 == false) goto L33;
        MmAINoteFragment r33 = this.i;
        if (r33 == null) goto L30;
        View r34 = r33.getView();
        if (r34 == null) goto L30;
        ViewParent r35 = r34.getParent();
    L31:
        if (r35 != r2) goto L33;
        boolean r36 = true;
    L34:
        if (r36 == false) goto L56;
        MmAINoteFragment r37 = this.i;
        if (r37 == null) goto L112;
        final boolean r110 = true;
        Function1<MmAINoteFragmentArgs, MmAINoteFragmentArgs> r38 = new MmAINoteFragment$showAgain$1(r14, r25, r110);
        Bundle r39 = r37.getArguments();
        if (r39 == null) goto L40;
        r39.putSerializable("arg_ainote_args", (Serializable) r38.invoke(r37.ea0()));
    L40:
        r37.fa0().dispatchEvent(new MmAINoteUIEvent.l(r14, r25));
        final MmAINotePanelAnimator r40 = r37.q;
        if (r40 == null) goto L54;
        boolean r41 = r40.K;
        if (r41 == true) goto L46;
        r40.p(MmAINotePanelAnimator.FullStateSource.MANUAL_GESTURE, "show_again_expand");
        goto L54
    L46:
        if (r40.o == MmAINoteSheetState.CLOSED) goto L48;
        if (r41 == false) goto L54;
    L48:
        r40.K = false;
        FrameLayout r42 = r40.f;
        Function0<Unit> r43 = new MmAINotePanelAnimator$showAgain$1(r12, r40);
        if (r42.getWidth() > 0) goto L51;
    L53:
        r42.addOnLayoutChangeListener(new n(r42, r43));
        goto L54
    L51:
        if (r42.getHeight() <= 0) goto L53;
        r43.invoke();
    L54:
        r37.fa0().dispatchEvent(new MmAINoteUIEvent.g(true));
        return;
    L112:
        return;
    L30:
        r35 = null;
        goto L31
    L21:
        if (r31.isAdded() != true) goto L23;
        r32 = true;
    L33:
        r36 = false;
        goto L34
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r2, String r3, MmRecordingUILaunchMode r4, Function0<MmRecordingAINoteRepo> r5, Function1<? super com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r2, "ownerKey");
        Intrinsics.checkNotNullParameter(r3, "meetingId");
        Intrinsics.checkNotNullParameter(r4, "uiLaunchMode");
        Intrinsics.checkNotNullParameter(r5, "aiNoteRepoProvider");
        Intrinsics.checkNotNullParameter(r6, "onNavigateToSubtitle");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.g = true;
        this.m = new LinkedHashMap();
    }
}
