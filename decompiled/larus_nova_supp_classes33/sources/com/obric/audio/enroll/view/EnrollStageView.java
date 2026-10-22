package com.obric.audio.enroll.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import com.obric.audio.enroll.IEnrollService;
import com.obric.audio.enroll.animation.AnimationType;
import com.obric.audio.enroll.model.TeamEnrollState;
import com.obric.audio.enroll.model.TeamMember;
import com.obric.audio.enroll.model.TeamState;
import com.obric.audio.enroll.model.TipsCode;
import com.obric.audio.enroll.vm.EnrollViewModel;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\fJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(J\u0012\u0010)\u001a\u0004\u0018\u00010\u00112\u0006\u0010*\u001a\u00020\"H\u0002J\b\u0010+\u001a\u00020&H\u0014J4\u0010,\u001a\u00020&2\u0014\b\u0002\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u00020\b2\f\u00101\u001a\b\u0012\u0004\u0012\u00020&02H\u0002J@\u00103\u001a\u00020&2\u0014\b\u0002\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020/0.2\f\u00104\u001a\b\u0012\u0004\u0012\u00020&022\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020&06H\u0002J\u000e\u00107\u001a\b\u0012\u0004\u0012\u0002080\u0010H\u0002J\b\u00109\u001a\u00020&H\u0002J\f\u0010=\u001a\u00020\b*\u00020\bH\u0002J\u001c\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0?2\u0006\u0010@\u001a\u00020\bH\u0002J\u0014\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0?H\u0002J\u0012\u0010B\u001a\u00020&2\b\b\u0002\u0010C\u001a\u00020\u0013H\u0002J\b\u0010D\u001a\u00020&H\u0014J\b\u0010E\u001a\u00020&H\u0002J\u0018\u0010F\u001a\u00020&2\u0006\u0010*\u001a\u00020\"2\u0006\u0010G\u001a\u00020\"H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010:\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006I"}, d2 = {"Lcom/obric/audio/enroll/view/EnrollStageView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/audio/enroll/EnrollAsrCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "sentence", "Lcom/obric/audio/enroll/model/EnrollSentence;", "teamViews", "", "Lcom/obric/audio/enroll/view/EnrollTeamView;", "firstShowDispatched", "", "stageTeam", "getStageTeam", "()Lcom/obric/audio/enroll/view/EnrollTeamView;", "candidateTeam", "getCandidateTeam", "doneTeams", "", "getDoneTeams", "()Ljava/util/List;", "viewModel", "Lcom/obric/audio/enroll/vm/EnrollViewModel;", "getViewModel", "()Lcom/obric/audio/enroll/vm/EnrollViewModel;", "resolveSentenceAssetName", "", "getCurrentLocale", "Ljava/util/Locale;", "observe", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getTeamFromTaskId", "taskId", "onAttachedToWindow", "animateToCandidate", "args", "", "", "index", "onEnd", "Lkotlin/Function0;", "animateToStage", "firstLineEnd", "end", "Lkotlin/Function1;", "getTipsFirstShowAnimator", "Landroidx/dynamicanimation/animation/SpringAnimation;", "animateToDone", "parentID", "getParentID", "()I", "limit", "makePair", "Lkotlin/Pair;", "head", "arrangeNextTeam", "showNextTeam", "firstTime", "onDetachedFromWindow", "clear", "onAsrResult", "resp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnrollStageView extends ConstraintLayout implements com.obric.audio.enroll.a {
    public static final Pair<Integer, Integer> e = null;
    public final qia.f a;
    public final List<EnrollTeamView> b;
    public boolean c;
    public final EnrollViewModel d;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {
        public final /* synthetic */ Function0 a;
        public final /* synthetic */ EnrollTeamView b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r3) {
            FLogger.a.i("EnrollStageView", "animator cancel");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            FLogger.a.i("EnrollStageView", "animator end");
            this.a.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            this.b.setVisibility(0);
        }

        public b(Function0 r1, EnrollTeamView r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    private final int getParentID() {
        return 2131387165;
    }

    static {
        e = TuplesKt.to(-2, -2);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [android.view.View, android.view.ViewGroup, com.obric.audio.enroll.view.EnrollTeamView, java.lang.Object] */
    public final void clear() {
        FLogger.a.i("EnrollStageView", "clear the teamViews ...");
        Iterator r0 = ((ArrayList) this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        ?? r1 = (EnrollTeamView) r0.next();
        r1.getClass();
        Intrinsics.checkNotNullParameter(this, "callback");
        String r2 = r1.U5();
        FLogger.a.i("EnrollTeamView", "releaseAsrResource stopRecord deviceType=" + r1.d.getEnrollDeviceType() + " taskId=" + r2);
        IEnrollService.a.getClass();
        IEnrollService r3 = IEnrollService.a.a();
        if (r3 == null) goto L9;
        r3.a(r2);
    L9:
        if (Intrinsics.areEqual(r1.getParent(), this) == false) goto L4;
        removeView(r1);
        goto L4
    L11:
        ((ArrayList) this.b).clear();
    }

    public final EnrollTeamView getCandidateTeam() {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((EnrollTeamView) r1).getState() != TeamState.CANDIDATE) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L13:
        return (EnrollTeamView) r1;
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L13
    }

    public final List<EnrollTeamView> getDoneTeams() {
        List<EnrollTeamView> r0 = this.b;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (((EnrollTeamView) r3).getState() != TeamState.DONE) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        r4 = false;
        goto L9
    L11:
        return r1;
    }

    public final EnrollTeamView getStageTeam() {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((EnrollTeamView) r1).getState() != TeamState.ONSTAGE) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L13:
        return (EnrollTeamView) r1;
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<SpringAnimation> getTipsFirstShowAnimator() {
        ViewParent r0 = getParent();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        final AppCompatTextView r1 = ((ViewGroup) r0).findViewById(2131388739);
        float r2 = getResources().getDimension(2131168412);
        SpringAnimation r3 = new SpringAnimation(r1, DynamicAnimation.TRANSLATION_Y, 0.0f);
        r3.setStartValue(r2);
        r3.getSpring().setStiffness(60.0f);
        r3.getSpring().setDampingRatio(0.8f);
        SpringAnimation r4 = new SpringAnimation(r1, DynamicAnimation.ALPHA, 1.0f);
        r4.setStartValue(0.0f);
        r4.getSpring().setStiffness(60.0f);
        r4.getSpring().setDampingRatio(0.8f);
        r4.addUpdateListener(new com.obric.audio.enroll.view.a(r1));
        r4.addEndListener(new j(r1));
        return CollectionsKt.mutableListOf(new SpringAnimation[]{r3, r4});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.view.View, android.view.ViewGroup, com.obric.audio.enroll.view.EnrollTeamView, java.lang.Object] */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        clear();
        int r0 = 0;
    L4:
        if (r0 >= 5) goto L12;
        ?? r1 = new EnrollTeamView(getContext());
        r1.setIndex(r0);
        r1.setUuid(UUID.randomUUID());
        List<qia.g> r2 = this.a.a();
        if (r2 != null) goto L8;
        r2 = CollectionsKt.emptyList();
    L8:
        qia.g r3 = (qia.g) CollectionsKt.getOrNull(r2, r0);
        if (r3 != null) goto L11;
        r3 = new qia.g(r0, 126);
    L11:
        r1.setTeam(r3);
        r1.setState(TeamState.NA);
        r1.setVisibility(8);
        ((ArrayList) this.b).add(r1);
        addView(r1);
        r0 = r0 + 1;
        goto L4
    L12:
        FLogger.a.i("EnrollStageView", "onAttachedToWindow with teamViewsize " + ((ArrayList) this.b).size());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        FLogger.a.i("EnrollStageView", "onDetachedFromWindow");
        clear();
    }

    public final EnrollViewModel getViewModel() {
        return this.d;
    }

    public EnrollStageView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final Pair<Integer, Integer> T5(int r5) {
        int r0 = 0;
        if (r5 >= 0) goto L7;
        return TuplesKt.to(0, 1);
    L7:
        if (r5 < 5) goto L9;
        r5 = -1;
    L11:
        int r3 = r5 + 1;
        if (r3 < 5) goto L14;
        r0 = -1;
    L18:
        return TuplesKt.to(Integer.valueOf(r5), Integer.valueOf(r0));
    L14:
        if (r3 < 0) goto L18;
        r0 = r3;
        goto L18
    L9:
        if (r5 >= 0) goto L11;
        r5 = 0;
        goto L11
    }

    public final void U5(LifecycleOwner r14) {
        Intrinsics.checkNotNullParameter(r14, "lifecycleOwner");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r14), null, null, new EnrollStageView$observe$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r14), null, null, new EnrollStageView$observe$2(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r14), null, null, new EnrollStageView$observe$3(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r14), null, null, new EnrollStageView$observe$4(this, null), 3, null);
    }

    public final void V5(boolean r7) {
        if (getStageTeam() != null) goto L6;
        Pair<Integer, Integer> r0 = T5(-1);
    L21:
        if (Intrinsics.areEqual(r0, e) == false) goto L23;
        return;
    L23:
        int r2 = ((Number) r0.getFirst()).intValue();
        final int r1 = ((Number) r0.getSecond()).intValue();
        FLogger.a.i("EnrollStageView", "showNextTeam will onStage " + r2 + ", and candidata is " + r1);
        if (r2 != r1) goto L28;
        if (r2 != Integer.MAX_VALUE) goto L28;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new EnrollStageView$showNextTeam$1(this, null), 3, null);
        return;
    L28:
        if (r7 == true) goto L32;
        EnrollTeamView r3 = getStageTeam();
        ArrayList r4 = new ArrayList();
        if (r3 == null) goto L32;
        r3.setState(TeamState.DONE);
        r3.T5(new g(r3, r4));
    L32:
        if (r7 == false) goto L34;
        R5(MapsKt.mapOf(TuplesKt.to("no-anim", Boolean.TRUE)), r2, new k(this, r1));
        return;
    L34:
        S5(this, new l(this, r1), new m());
        return;
    L6:
        if (getCandidateTeam() == null) goto L9;
        EnrollTeamView r5 = getStageTeam();
        Intrinsics.checkNotNull(r5);
        r0 = T5(r5.getIndex() + 1);
        goto L21
    L9:
        if (getCandidateTeam() != null) goto L16;
        if (getStageTeam() == null) goto L16;
        if ((!getDoneTeams().isEmpty()) == false) goto L16;
        r0 = TuplesKt.to(Integer.MAX_VALUE, Integer.MAX_VALUE);
    L16:
        if (getStageTeam() == null) goto L37;
        if (getCandidateTeam() != null) goto L37;
        r0 = e;
    L37:
        throw new RuntimeException("should not reach here s:" + getStageTeam() + " c:" + getCandidateTeam() + " d:" + getDoneTeams());
    }

    public EnrollStageView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    @Override // com.obric.audio.enroll.a
    public final void J0(String r20, String r21) {
        Intrinsics.checkNotNullParameter(r20, "taskId");
        Intrinsics.checkNotNullParameter(r21, "resp");
        FLogger r3 = FLogger.a;
        r3.i("EnrollStageView", "onAsrResult " + r20 + ' ' + r21);
        kia.a r4 = (kia.a) GsonProtectorUtils.fromJson(new Gson(), r21, kia.a.class);
        StringBuilder r6 = new StringBuilder("onAsrResult with entity ---> : ");
        r6.append(r21);
        r3.i("EnrollStageView", r6.toString());
        Iterator r5 = ((ArrayList) this.b).iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r7 = r5.next();
        if (Intrinsics.areEqual(((EnrollTeamView) r7).U5(), r20) == false) goto L4;
    L9:
        EnrollTeamView r8 = (EnrollTeamView) r7;
        if (r8 == null) goto L90;
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNullParameter(r4, "resp");
        FLogger r0 = FLogger.a;
        StringBuilder r2 = new StringBuilder("onAsrResponseStream :");
        r2.append(r4);
        r2.append(" , size ");
        r2.append(r4.b().length());
        r2.append(" , rawSize: ");
        qia.g r9 = r8.h;
        if (r9 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("team");
        r9 = null;
    L14:
        String r10 = r9.c();
        String r11 = "";
        if (r10 != null) goto L17;
        r10 = "";
    L17:
        int r12 = r8.u6(r10).length();
        qia.g r13 = r8.h;
        if (r13 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("team");
        r13 = null;
    L20:
        String r14 = r13.f();
        if (r14 != null) goto L23;
        r14 = "";
    L23:
        r2.append(r12 + r8.u6(r14).length());
        r0.i("EnrollTeamView", r2.toString());
        int r15 = r8.u6(r4.b()).length();
        qia.g r16 = r8.h;
        if (r16 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("team");
        r16 = null;
    L26:
        String r17 = r16.c();
        if (r17 != null) goto L29;
        r17 = "";
    L29:
        int r18 = r8.u6(r17).length();
        qia.g r19 = r8.h;
        if (r19 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("team");
        r19 = null;
    L32:
        String r22 = r19.f();
        if (r22 == null) goto L36;
        r11 = r22;
    L36:
        int r23 = r18 + r8.u6(r11).length();
        boolean r24 = false;
        if ((r8.e + r15) < r23) goto L39;
        boolean r25 = true;
    L40:
        r0.i("EnrollTeamView", "onAsrResponseStream oversize ? " + r25 + " with enrollState " + r8.j.getValue() + " ... rawlength " + r23 + "  givenLength " + r15 + " historyLength " + r8.e);
        if (((List) EnrollTeamView.G.getValue()).contains(Integer.valueOf(r4.a())) == false) goto L56;
        r0.i("EnrollTeamView", "onAsrResponseStream get error code of " + r4.a());
        int r1 = r4.a();
        if (r1 != 500) goto L45;
        r8.d.reportEvent(new qia.q(TipsCode.TIPS_CODE_ASR_TASK_START_FAILED));
    L55:
        BuildersKt.launch$default(r8.c, null, null, new EnrollTeamView$onAsrResponseStream$2(r8, null), 3, null);
        r8.V5();
        return;
    L45:
        if (r1 != 504) goto L47;
        r8.d.reportEvent(new qia.q(TipsCode.TIPS_CODE_ASR_SESSION_START_FAILED));
        goto L55
    L47:
        if (r1 != 505) goto L55;
        if (r8.F == true) goto L52;
        r8.d.reportEvent(new qia.q(TipsCode.TIPS_CODE_ASR_NETWORK_ERROR));
        r8.F = true;
    L52:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EnrollTeamView$onAsrResponseStream$1(r8, null), 3, null);
        goto L55
    L56:
        r8.F = false;
        BuildersKt.launch$default(r8.c, null, null, new EnrollTeamView$onAsrResponseStream$3(r8, r15, r23, null), 3, null);
        if (r4.c() == true) goto L60;
        if (r25 == true) goto L60;
    L62:
        if (r25 == false) goto L64;
        return;
    L64:
        if (r4.c() == true) goto L66;
    L71:
        boolean r26 = false;
    L73:
        if (r4.c() == false) goto L75;
    L80:
        r8.d.reportEvent(qia.a.a);
        r0.i("EnrollTeamView", "------ startTimeout ------");
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EnrollTeamView$startTimeout$1(r8, null), 3, null);
        r0.i("EnrollTeamView", "------ restartAsrTimer ------");
        Job r27 = r8.n;
        if (r27 == null) goto L83;
        Job.DefaultImpls.cancel$default(r27, null, 1, null);
    L83:
        r8.n = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EnrollTeamView$restartAsrTimer$1(r8, null), 3, null);
    L84:
        if (r26 == false) goto L94;
        r8.e += r15;
        r0.i("EnrollTeamView", "onAsrResponseStream vad end , but text is not enough , historyLength " + r8.e);
        return;
    L94:
        return;
    L75:
        if (r4.b().length() != 0) goto L77;
        r24 = true;
    L77:
        if (r24 == true) goto L80;
        r0.i("EnrollTeamView", "onAsrResponseStream cancel timeout");
        r8.d.reportEvent(qia.b.a);
        r8.Y5();
        r8.V5();
        goto L84
    L66:
        if (r4.b().length() <= 0) goto L68;
        boolean r28 = true;
    L69:
        if (r28 == false) goto L71;
        r26 = true;
        goto L73
    L68:
        r28 = false;
    L60:
        if (r8.j.getValue() != TeamEnrollState.ENROLLING) goto L62;
        r8.i = r4;
        EnrollTeamView.l7(r8, TeamEnrollState.OVERSIZE);
        r8.e = 0;
        r8.V5();
        return;
    L39:
        r25 = false;
        goto L40
    L90:
        return;
    L8:
        r7 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v12, types: [com.obric.audio.enroll.view.n, java.lang.Object] */
    public EnrollStageView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        this.b = new ArrayList();
        EnrollViewModel r11 = (EnrollViewModel) new ViewModelProvider((FragmentActivity) r8).get(EnrollViewModel.class);
        this.d = r11;
        if (r11 == null) goto L56;
        Configuration r12 = r8.getResources().getConfiguration();
        boolean r1 = false;
        if (Build.VERSION.SDK_INT < 24) goto L10;
        Locale r13 = r12.getLocales().get(0);
        if (r13 != null) goto L9;
        r13 = Locale.getDefault();
    L9:
        Intrinsics.checkNotNull(r13);
    L14:
        String r14 = r13.getLanguage();
        Locale r0 = Locale.ROOT;
        String r15 = r14.toLowerCase(r0);
        String r2 = r13.getScript().toLowerCase(r0);
        String r16 = r13.toLanguageTag().toLowerCase(r0);
        if (Intrinsics.areEqual(r15, "zh") == true) goto L17;
    L34:
        FLogger.a.i("EnrollStageView", "resolveSentenceAssetName language=" + r15 + " languageTag=" + r16 + " script=" + r2 + " isTraditionalChinese=" + r1);
        if (r1 == false) goto L37;
        String r17 = "sentence_hk.json";
    L38:
        InputStream r18 = ((FragmentActivity) r8).getAssets().open(r17);
        int r3 = sia.c.a;
        Intrinsics.checkNotNullParameter(r18, "inputStream");
        StringBuilder r4 = new StringBuilder();
        BufferedReader r5 = new BufferedReader(new InputStreamReader(r18));
    L59:
        String r19 = r5.readLine();     // Catch: Throwable -> L50
        if (r19 == null) goto L42;
        r4.append(r19);     // Catch: Throwable -> L50
        goto L59
    L42:
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L50
        CloseableKt.closeFinally(r5, null);
        String r21 = r4.toString();
        FLogger r6 = FLogger.a;
        r6.i("EnrollStageView", "load sentence asset: " + r17 + ", json is " + r21);
        qia.f r22 = (qia.f) GsonProtectorUtils.fromJson(new Gson(), r21, qia.f.class);
        this.a = r22;
        r6.i("EnrollStageView", "sentence is " + r22);
        this.d.getEnrollSentences().clear();
        List<qia.g> r23 = this.d.getEnrollSentences();
        List<qia.g> r110 = r22.a();
        if (r110 != null) goto L46;
        r110 = CollectionsKt.emptyList();
    L46:
        r23.addAll(CollectionsKt.filterNotNull(r110));
        this.d.setEnrollSentence(r22);
        int r24 = com.obric.audio.enroll.f.a;
        ?? r25 = new n(this);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r25, "closure");
        if (getViewTreeObserver().isAlive() == false) goto L62;
        getViewTreeObserver().addOnGlobalLayoutListener(new com.obric.audio.enroll.e(this, r25));
        return;
    L62:
        return;
    L50:
        th = move-exception;
        throw th;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    L37:
        r17 = "sentence.json";
        goto L38
    L17:
        if (Intrinsics.areEqual(r2, "hant") == false) goto L19;
    L31:
        boolean r7 = true;
    L32:
        if (r7 == false) goto L34;
        r1 = true;
        goto L34
    L19:
        if (StringsKt.contains$default(r16, "hant", false, 2, null) == true) goto L31;
        if (Intrinsics.areEqual(r2, "hans") == false) goto L24;
    L30:
        r7 = false;
        goto L32
    L24:
        if (StringsKt.contains$default(r16, "hans", false, 2, null) == true) goto L30;
        if (StringsKt.contains$default(r16, "-cn", false, 2, null) == true) goto L30;
        if (StringsKt.contains$default(r16, "-sg", false, 2, null) == false) goto L31;
    L10:
        r13 = r12.locale;
        if (r13 != null) goto L13;
        r13 = Locale.getDefault();
    L13:
        Intrinsics.checkNotNull(r13);
        goto L14
    L56:
        throw new RuntimeException("viewModel is null");
    }

    public static void S5(final EnrollStageView r18, final Function0 r19, final Function1 r20) {
        Map r2 = MapsKt.emptyMap();
        final EnrollTeamView r1 = r18.getCandidateTeam();
        if (r1 == null) goto L65;
        r1.setState(TeamState.ONSTAGE);
        int r3 = r1.getTextLines();
        FLogger r4 = FLogger.a;
        r4.i("EnrollTeamView", "onStageReset");
        r1.o6();
        LinkedHashMap r5 = new LinkedHashMap();
        List<SpringAnimation> r6 = new ArrayList();
        boolean r7 = Intrinsics.areEqual(r2.get("first"), Boolean.TRUE);
        if (r7 == false) goto L8;
        r6 = r18.getTipsFirstShowAnimator();
    L8:
        r18.d.getStageingIndex().setValue(Integer.valueOf(r1.getIndex()));
        r4.i("EnrollStageView", "animateToStage set stageingIndex " + r1.getIndex() + " firstShow=" + r7);
        final int r8 = 0;
    L9:
        if (r8 >= r3) goto L46;
        List r11 = (List) r5.get(Integer.valueOf(r8));
        if (r11 != null) goto L13;
        r11 = new ArrayList();
    L13:
        TeamMember.Companion.getClass();
        SpringAnimation r13 = new SpringAnimation(r1.Z5(TeamMember.a.a(r8)), DynamicAnimation.TRANSLATION_Y, r1.b6(TeamMember.a.a(r8)));
        TeamMember r12 = TeamMember.a.a(r8);
        Intrinsics.checkNotNullParameter(r12, "teamMember");
        float r14 = r1.d.getFootGuideLine();
        if (r12 == TeamMember.TITLE) goto L30;
        Iterator r15 = ((ArrayList) r1.z).iterator();
    L18:
        if (r15.hasNext() == false) goto L25;
        Object r16 = r15.next();
        if (((Pair) r16).getFirst() != r12) goto L22;
        boolean r9 = true;
    L23:
        if (r9 == false) goto L18;
        Object r10 = r16;
    L26:
        Pair r17 = (Pair) r10;
        if (r17 != null) goto L29;
        r14 = 0.0f;
        goto L30
    L29:
        r14 = (r14 + ((Number) mia.h.d.getValue()).floatValue()) + (((Number) mia.h.f.getValue()).floatValue() * ((TeamMember) r17.getFirst()).getOrder());
        goto L30
    L22:
        r9 = false;
        goto L23
    L25:
        r10 = null;
    L30:
        r13.setStartValue(r14);
        r13.getSpring().setStiffness(960.0f);
        r13.getSpring().setDampingRatio(1.3f);
        r11.add(r13);
        TeamMember.Companion.getClass();
        SpringAnimation r21 = new SpringAnimation(r1.Z5(TeamMember.a.a(r8)), DynamicAnimation.ALPHA, 0.7f);
        r21.setStartValue(0.0f);
        r21.getSpring().setStiffness(120.0f);
        r21.getSpring().setDampingRatio(1.3f);
        if (r7 == false) goto L33;
        r21.addUpdateListener(new q(r1, r8));
        r21.addEndListener(new r(r8, r1));
    L33:
        r11.add(r21);
        SpringAnimation r22 = new SpringAnimation(r1.Z5(TeamMember.a.a(r8)), DynamicAnimation.SCALE_X, 1.0f);
        r22.setStartValue(0.6f);
        r22.getSpring().setStiffness(120.0f);
        r22.getSpring().setDampingRatio(0.8f);
        SpringAnimation r110 = new SpringAnimation(r1.Z5(TeamMember.a.a(r8)), DynamicAnimation.SCALE_Y, 1.0f);
        r110.setStartValue(0.6f);
        r110.getSpring().setStiffness(120.0f);
        r110.getSpring().setDampingRatio(0.8f);
        r11.add(r22);
        r11.add(r110);
        if (r8 != 0) goto L37;
        r13.addEndListener(new com.obric.audio.enroll.view.b(r18, r1));
    L37:
        if (r8 != 1) goto L41;
        r13.addEndListener(new c(r19));
    L41:
        if (r8 != (r3 - 1)) goto L44;
        r13.addEndListener(new d(r1, r20));
    L44:
        r5.put(Integer.valueOf(r8), r11);
        r8 = r8 + 1;
        goto L9
    L46:
        if ((!r6.isEmpty()) == true) goto L49;
        r6 = null;
    L49:
        if (r6 == null) goto L54;
        Iterator<T> r0 = r6.iterator();
    L52:
        if (r0.hasNext() == false) goto L54;
        ((SpringAnimation) r0.next()).start();
    L54:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EnrollStageView$animateToStage$6(r1, r2, r3, r5, null), 3, null);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.view.ViewGroup, com.obric.audio.enroll.view.EnrollTeamView, java.lang.Object] */
    public final void R5(Map<String, ? extends Object> r20, int r21, Function0<Unit> r22) {
        Iterator r1 = ((ArrayList) this.b).iterator();
    L3:
        qia.g r5 = null;
        if (r1.hasNext() == false) goto L13;
        Object r2 = r1.next();
        EnrollTeamView r6 = (EnrollTeamView) r2;
        if (r6.getIndex() == r21) goto L8;
    L10:
        boolean r7 = false;
    L11:
        if (r7 == false) goto L3;
    L14:
        final ?? r3 = (EnrollTeamView) r2;
        ConstraintLayout r4 = findViewById(2131387165);
        FLogger r8 = FLogger.a;
        r8.i("EnrollStageView", "animateToCandidate " + r3);
        if (r3 != 0) goto L17;
        return;
    L17:
        boolean r9 = Intrinsics.areEqual(r20.get("no-anim"), Boolean.TRUE);
        StringBuilder r10 = new StringBuilder("prepare with index ");
        r10.append(r3.f);
        r10.append(" and team is ");
        qia.g r11 = r3.h;
        if (r11 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("team");
        r11 = null;
    L20:
        r10.append(r11);
        r8.i("EnrollTeamView", r10.toString());
        qia.g r12 = r3.h;
        if (r12 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("team");
        r12 = null;
    L23:
        r3.f = r12.a();
        TextView r13 = r3.A;
        qia.g r14 = r3.h;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("team");
        r14 = null;
    L26:
        String r15 = r14.f();
        if (r15 != null) goto L29;
        r15 = "";
    L29:
        r13.setText(r15);
        qia.g r16 = r3.h;
        if (r16 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("team");
        r16 = null;
    L32:
        String r17 = r16.c();
        if (r17 != null) goto L35;
        String r18 = "";
    L36:
        List r19 = StringsKt.split$default(r18, new String[]{"$"}, false, 0, 6, null);
        int r110 = r19.size();
        qia.g r111 = r3.h;
        if (r111 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("team");
    L41:
        if (r110 != r5.d()) goto L61;
        int r23 = r19.size();
        if (r23 == 1) goto L51;
        if (r23 != 2) goto L46;
        r3.B.setText((CharSequence) ListProtector.get(r19, 0));
        r3.C.setText((CharSequence) ListProtector.get(r19, 1));
    L52:
        r3.setState(TeamState.CANDIDATE);
        r3.setVisibility(0);
        ConstraintLayout.LayoutParams r24 = new ConstraintLayout.LayoutParams(-1, -1);
        r24.topToBottom = getParentID();
        r24.bottomToBottom = getParentID();
        r24.startToStart = getParentID();
        r24.endToEnd = getParentID();
        setBackgroundColor(0);
        r3.setLayoutParams(r24);
        r3.setBackgroundColor(getContext().getResources().getColor(2131100573));
        r3.o6();
        if (r4 == null) goto L55;
        r4.requestLayout();
    L55:
        if (r9 == false) goto L58;
        r3.setAlpha(1.0f);
        EnrollTeamView.n6(r3, TeamMember.ALL, AnimationType.FADE_IN_TO_CANDIDATE, 1.0f);
        r3.setVisibility(0);
        r22.invoke();
        return;
    L58:
        ValueAnimator r25 = new ValueAnimator();
        r25.setIntValues(new int[]{0, 1});
        r25.setDuration(500);
        r25.addUpdateListener(new p(r3));
        r25.addListener(new b(r22, r3));
        r8.i("EnrollStageView", "start animator to candidate with tv " + r3);
        r25.start();
        return;
    L46:
        if (r23 != 3) goto L49;
        r3.B.setText((CharSequence) ListProtector.get(r19, 0));
        r3.C.setText((CharSequence) ListProtector.get(r19, 1));
        r3.D.setText((CharSequence) ListProtector.get(r19, 2));
        goto L52
    L49:
        throw new RuntimeException("invalid subtitleLines");
    L51:
        r3.B.setText((CharSequence) ListProtector.get(r19, 0));
        goto L52
    L61:
        throw new RuntimeException("invalid subtitleLines , not equal with $ ");
    L39:
        r5 = r111;
        goto L41
    L35:
        r18 = r17;
        goto L36
    L8:
        if (r6.getState() != TeamState.NA) goto L10;
        r7 = true;
        goto L11
    L13:
        r2 = null;
        goto L14
    }
}
