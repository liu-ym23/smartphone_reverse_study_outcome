package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.bottommenu.MentionFilePickerType;
import com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionPanelController;
import com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionPanelListView;
import com.larus.bmhome.chat.component.bottom.core.inputtext.project.ProjectPanelController;
import com.larus.bmhome.chat.component.bottom.core.inputtext.slash.SlashPanelController;
import com.larus.bmhome.chat.component.bottom.core.y8;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import hq9.m2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MultiTypeMentionPanelController {
    public static final /* synthetic */ int c0 = 0;
    public final boolean A;
    public final boolean B;
    public final SkillSearchIndex C;
    public boolean D;
    public boolean E;
    public final h1 F;
    public k1 G;
    public Integer H;
    public b I;
    public boolean J;
    public boolean K;
    public Integer L;
    public boolean M;
    public boolean N;
    public final e1 O;
    public List<d0> P;
    public Job Q;
    public Job R;
    public Pair<Boolean, Boolean> S;
    public final EditText T;
    public final b0 U;
    public com.larus.bmhome.chat.component.bottom.core.inputtext.mention.q0 V;
    public com.larus.bmhome.chat.component.bottom.core.inputtext.slash.r W;
    public com.larus.bmhome.chat.component.bottom.core.inputtext.project.h X;
    public MentionPanelController Y;
    public SlashPanelController Z;
    public final ChatInputWithMentionDelegate a;
    public ProjectPanelController a0;
    public final ViewGroup b;
    public final i1 b0;
    public final y8 c;
    public final va8.c d;
    public final Function0<Integer> e;
    public final CoroutineScope f;
    public final qp8.e g;
    public final Fragment h;
    public final Function0<Boolean> i;
    public final Function0<Boolean> j;
    public final Function0<Boolean> k;
    public final Function0<Boolean> l;
    public final Function0<Boolean> m;
    public final Function0<Boolean> n;
    public final Function0<be8.a> o;
    public final Function1<MentionFilePickerType, Unit> p;
    public final Function1<Boolean, Unit> q;
    public final Function1<Boolean, Unit> r;
    public final Function1<Boolean, Unit> s;
    public final Function0<Unit> t;
    public final boolean u;
    public final boolean v;
    public final Set<SlashPanelContent> w;
    public final Set<MentionPanelContent> x;
    public final boolean y;
    public final boolean z;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.inputtext.MultiTypeMentionPanelController$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.MultiTypeMentionPanelController$3", f = "MultiTypeMentionPanelController.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MultiTypeMentionPanelController this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.inputtext.MultiTypeMentionPanelController$3$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ MultiTypeMentionPanelController a;

            public a(MultiTypeMentionPanelController r1) {
                this.a = r1;
            }

            public final Object emit(Object r2, Continuation r3) {
                Pair<Boolean, Boolean> r4 = (Pair) r2;
                MultiTypeMentionPanelController r5 = this.a;
                if (r5.E == true) goto L19;
                if (Intrinsics.areEqual(r4, r5.S) == true) goto L19;
                MultiTypeMentionPanelController r6 = this.a;
                r6.S = r4;
                if (r6.x.contains(MentionPanelContent.CONTACT) == false) goto L20;
                MultiTypeMentionPanelController r7 = this.a;
                k1 r8 = r7.G;
                if (r8 == null) goto L13;
                MultiTypePanelTrigger r9 = r8.d;
            L15:
                if (r9 != MultiTypePanelTrigger.MENTION) goto L17;
                r7.l();
            L17:
                this.a.d();
                return Unit.INSTANCE;
            L13:
                r9 = null;
                goto L15
            L20:
                return Unit.INSTANCE;
            L19:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass3(MultiTypeMentionPanelController r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            LarkSocialExp.a.getClass();
            final StateFlowImpl r6 = LarkSocialExp.e;
            Flow r7 = kotlinx.coroutines.flow.e.n(new MultiTypeMentionPanelController$3$invokeSuspend$$inlined$map$1(r6));
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final MultiTypePanelTrigger b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "DismissedQuery(start=" + this.a + ", trigger=" + this.b + ')';
        }

        public b(int r2, MultiTypePanelTrigger r3) {
            Intrinsics.checkNotNullParameter(r3, "trigger");
            this.a = r2;
            this.b = r3;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MultiTypePanelTrigger.values().length];
            r0[MultiTypePanelTrigger.MENTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MultiTypePanelTrigger.SLASH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MultiTypePanelTrigger.EXTERNAL_SKILL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public final void l() {
        o(false);
        this.G = null;
        this.H = null;
        this.M = false;
        MentionPanelController r1 = this.Y;
        if (r1 == null) goto L5;
        r1.i();
    L5:
        SlashPanelController r2 = this.Z;
        if (r2 == null) goto L8;
        r2.d();
    L8:
        ProjectPanelController r3 = this.a0;
        if (r3 == null) goto L11;
        r3.b();
    L11:
        p(false);
    }

    public final void d() {
        MentionPanelController r0 = this.Y;
        if (r0 == null) goto L17;
        Job r4 = r0.q;
        if (r4 == null) goto L7;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L7:
        r0.E.a();
        r0.F = null;
        gc8.b r5 = r0.G;
        if (r5 == null) goto L10;
        r5.release();
    L10:
        r0.B++;
        r0.C++;
        Job r6 = r0.p;
        if (r6 == null) goto L13;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L13:
        Job r7 = r0.r;
        if (r7 == null) goto L16;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
    L16:
        r0.q();
        r0.Q.remove();
        r0.n = null;
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.m0 r1 = r0.P;
        r1.c = false;
        ExposeXTrackerExtKt.a(r1.a, "mention_panel_option:");
    L17:
        this.Y = null;
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.q0 r2 = this.V;
        if (r2 == null) goto L25;
        r2.d.i(false);
        MentionPanelListView r8 = r2.a;
        r8.f(true);
        r8.j(0);
        r8.h = null;
        ViewParent r3 = r2.b.getParent();
        if ((r3 instanceof ViewGroup) == false) goto L22;
        ViewGroup r9 = (ViewGroup) r3;
    L23:
        if (r9 == null) goto L25;
        r9.removeView(r2.b);
        goto L25
    L22:
        r9 = null;
    L25:
        this.V = null;
    }

    public final void f() {
        ProjectPanelController r0 = this.a0;
        if (r0 == null) goto L8;
        r0.j = false;
        Job r2 = r0.n;
        if (r2 == null) goto L7;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L7:
        r0.o.remove();
    L8:
        this.a0 = null;
        com.larus.bmhome.chat.component.bottom.core.inputtext.project.h r1 = this.X;
        if (r1 == null) goto L16;
        r1.b = null;
        ViewParent r3 = r1.i.getParent();
        if ((r3 instanceof ViewGroup) == false) goto L13;
        ViewGroup r4 = (ViewGroup) r3;
    L14:
        if (r4 == null) goto L16;
        r4.removeView(r1.i);
        goto L16
    L13:
        r4 = null;
    L16:
        this.X = null;
    }

    public final void g() {
        SlashPanelController r0 = this.Z;
        if (r0 == null) goto L14;
        r0.w = false;
        r0.s.a();
        r0.C++;
        View r3 = r0.E;
        if (r3 == null) goto L7;
        com.larus.bmhome.view.screenmenu.d.b(r3);
    L7:
        r0.E = null;
        Job r4 = r0.B;
        if (r4 == null) goto L10;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L10:
        Job r5 = r0.D;
        if (r5 == null) goto L13;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L13:
        r0.x = null;
        r0.F = false;
        r0.G = 0;
        ExposeXTrackerExtKt.a(r0.r, "slash_panel_option:");
    L14:
        this.Z = null;
        com.larus.bmhome.chat.component.bottom.core.inputtext.slash.r r1 = this.W;
        if (r1 == null) goto L22;
        r1.e.i(false);
        ViewParent r2 = r1.d.getParent();
        if ((r2 instanceof ViewGroup) == false) goto L19;
        ViewGroup r6 = (ViewGroup) r2;
    L20:
        if (r6 == null) goto L22;
        r6.removeView(r1.d);
        goto L22
    L19:
        r6 = null;
    L22:
        this.W = null;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.x0] */
    public final ProjectPanelController h() {
        ProjectPanelController r0 = this.a0;
        if (r0 == null) goto L5;
        return r0;
    L5:
        com.larus.bmhome.chat.component.bottom.core.inputtext.project.h r4 = new com.larus.bmhome.chat.component.bottom.core.inputtext.project.h(this.b, new x0(this));
        this.X = r4;
        ProjectPanelController r1 = new ProjectPanelController(this.f, this.h, r4, this.o, this.j, new MultiTypeMentionPanelController$ensureProjectController$2(this), new MultiTypeMentionPanelController$ensureProjectController$3(this));
        this.a0 = r1;
        return r1;
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.z0] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.a1] */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.b1] */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.c1] */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.d1] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.y0] */
    public final SlashPanelController i() {
        SlashPanelController r1 = this.Z;
        if (r1 == null) goto L5;
        return r1;
    L5:
        final String r2 = AccountService.a.getUserId();
        final String r3 = (String) this.g.d.invoke();
        final com.larus.bmhome.chat.component.bottom.core.inputtext.slash.r r15 = new com.larus.bmhome.chat.component.bottom.core.inputtext.slash.r(this.b, new y0(this));
        this.W = r15;
        SlashPanelController r14 = new SlashPanelController(this.a, this.f, this.h, r15, this.o, this.j, this.l, new z0(this, r2, r3), new a1(this), this.t, this.n, this.w, new b1(this), new c1(r15, this), new d1(this), new MultiTypeMentionPanelController$ensureSlashController$7(this), new MultiTypeMentionPanelController$ensureSlashController$8(this), this.C);
        this.Z = r14;
        return r14;
    }

    public final void m() {
        boolean r0 = ((Boolean) this.i.invoke()).booleanValue();
        if (this.D != r0) goto L5;
        return;
    L5:
        this.D = r0;
        k1 r1 = this.G;
        k1 r2 = null;
        if (r1 == null) goto L8;
        MultiTypePanelTrigger r3 = r1.d;
    L10:
        if (r3 != MultiTypePanelTrigger.MENTION) goto L12;
        l();
    L12:
        d();
        k1 r4 = this.G;
        if (r4 != null) goto L15;
        return;
    L15:
        if (r4.d != MultiTypePanelTrigger.SLASH) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == false) goto L20;
        r2 = r4;
    L20:
        if (r2 == null) goto L26;
        SlashPanelController r6 = this.Z;
        if (r6 == null) goto L27;
        r6.l(r2);
        return;
    L27:
        return;
    L26:
        return;
    L17:
        r5 = false;
        goto L18
    L8:
        r3 = null;
        goto L10
    }

    public final void q() {
        k1 r0 = this.G;
        if (r0 == null) goto L5;
        String r1 = r0.c;
    L6:
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        MentionPanelController r2 = this.Y;
        if (r2 == null) goto L11;
        r2.i();
    L11:
        SlashPanelController r3 = this.Z;
        if (r3 == null) goto L17;
        r3.w = false;
        r3.s.a();
        View r4 = r3.E;
        if (r4 == null) goto L16;
        com.larus.bmhome.view.screenmenu.d.b(r4);
    L16:
        r3.E = null;
        r3.d.e.i(false);
        r3.F = false;
        r3.G = 0;
        ExposeXTrackerExtKt.a(r3.r, "slash_panel_option:");
    L17:
        ProjectPanelController r5 = h();
        Intrinsics.checkNotNullParameter(r1, "query");
        r5.j = true;
        r5.i = StringsKt.trim(r1).toString();
        r5.o.setEnabled(true);
        r5.d();
        r5.e();
        p(true);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void s() {
        if (this.K == true) goto L5;
        return;
    L5:
        Integer r0 = (Integer) this.e.invoke();
        if (r0 != null) goto L9;
        FLogger.a.i("MultiTypeMentionPanelController", "[updatePanelMaxHeight] skip, reason=missingTopAnchor");
        return;
    L9:
        int[] r3 = new int[2];
        this.b.getLocationOnScreen(r3);
        int r5 = r3[1] + this.b.getHeight();
        int r6 = RangesKt.coerceAtLeast(r5 - r0.intValue(), 0);
        FLogger r8 = FLogger.a;
        r8.i("MultiTypeMentionPanelController", "[updatePanelMaxHeight] apply, topAnchorY=" + r0 + ", panelY=" + r3[1] + ", panelSize=" + this.b.getWidth() + 'x' + this.b.getHeight() + ", availableHeight=" + r6);
        View r9 = this.b.getRootView();
        int[] r2 = new int[2];
        r9.getLocationOnScreen(r2);
        int r4 = r2[1] + ((int) (((float) r9.getHeight()) * 0.34f));
        WindowInsetsCompat r10 = ViewCompat.getRootWindowInsets(r9);
        if (r10 != null) goto L12;
    L14:
        boolean r11 = false;
    L15:
        View r12 = this.d.j();
        Integer r13 = null;
        if (r12 != null) goto L18;
    L23:
        int r1 = r0.intValue();
        ConstraintLayout r7 = this.d.h();
        if (r7 == null) goto L26;
        int r14 = r7.getPaddingTop();
    L27:
        int r15 = r1 + r14;
        int r16 = RangesKt.coerceAtLeast(r5 - r15, 0);
        int r17 = r5 - r4;
        r8.i("MultiTypeMentionPanelController", "[updatePanelMaxHeight] inputBounds, inputPanelTop=" + r15 + ", inputPanelBottom=" + r5 + ", inputPanelMaxHeight=" + r16 + ", inputPanelInitialHeight=" + r17 + ", imeVisible=" + r11);
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.q0 r18 = this.V;
        if (r18 == null) goto L55;
        if (r16 <= 0) goto L55;
        if (r18.d.p == true) goto L55;
        if (r18.e == r11) goto L36;
        MentionPanelListView r19 = r18.a;
        r19.f(true);
        r19.j(0);
        r19.h = null;
        r18.e = r11;
    L36:
        r18.d.j(r16, r17, r11);
        MentionPanelListView r20 = r18.a;
        r20.getClass();
        int r21 = RangesKt.coerceAtLeast(r16, 0);
        if (r20.g == r21) goto L55;
        r20.g = r21;
        Integer r22 = r20.h;
        if (r22 == null) goto L42;
        r13 = Integer.valueOf(RangesKt.coerceAtMost(r22.intValue(), r21));
    L42:
        r20.h = r13;
        if (r20.j.isEmpty() == true) goto L45;
    L47:
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.y> r23 = r20.e();
        r20.c(r23);
        if (Intrinsics.areEqual(r23, r20.k) == true) goto L50;
        r20.k = r23;
        r20.d.y2(r23, r20.l, r20.n);
        r20.u.invalidateItemDecorations();
    L50:
        Integer r24 = r20.h;
        if (r24 == null) goto L53;
        int r25 = r24.intValue();
    L54:
        r20.i = r25;
        r20.b.invoke(Boolean.FALSE);
        goto L55
    L53:
        r25 = RangesKt.coerceAtMost(r20.g(r20.k), r20.g);
        goto L54
    L45:
        if (r20.m == true) goto L47;
    L55:
        com.larus.bmhome.chat.component.bottom.core.inputtext.slash.r r26 = this.W;
        if (r26 == null) goto L59;
        r26.e.j(r16, r17, r11);
    L59:
        if (this.b.getHeight() <= 0) goto L67;
        com.larus.bmhome.chat.component.bottom.core.inputtext.project.h r27 = this.X;
        if (r27 == null) goto L68;
        int r28 = RangesKt.coerceAtLeast(r6, 0);
        if (r27.c == r28) goto L69;
        r27.c = r28;
        r27.a();
        return;
    L69:
        return;
    L68:
        return;
    L67:
        return;
    L26:
        r14 = 0;
        goto L27
    L18:
        if (r12.isLaidOut() == true) goto L21;
        r12 = null;
    L21:
        if (r12 == null) goto L23;
        r12.getLocationOnScreen(r3);
        r5 = r3[1];
        goto L23
    L12:
        if (r10.isVisible(WindowInsetsCompat.Type.ime()) != true) goto L14;
        r11 = true;
        goto L15
    }

    public final void a(MultiTypePanelTrigger r3) {
        if (r3 != MultiTypePanelTrigger.MENTION) goto L5;
        boolean r4 = true;
    L6:
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.q0 r0 = this.V;
        if (r0 == null) goto L9;
        r0.d.i(r4);
    L9:
        com.larus.bmhome.chat.component.bottom.core.inputtext.slash.r r1 = this.W;
        if (r1 == null) goto L12;
        r1.e.i(!r4);
    L12:
        com.larus.bmhome.chat.component.bottom.core.inputtext.project.h r5 = this.X;
        if (r5 == null) goto L16;
        r5.i.setVisibility(8);
        return;
    L16:
        return;
    L5:
        r4 = false;
        goto L6
    }

    public final void b(MultiTypePanelTrigger r6) {
        o(false);
        k1 r1 = this.G;
        if (r1 != null) goto L5;
    L13:
        b r3 = null;
    L14:
        this.I = r3;
        this.G = null;
        this.H = null;
        this.M = false;
        e(r6);
        p(false);
        return;
    L5:
        if (r1.d != r6) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L13;
        r3 = new b(r1.a, r1.d);
        goto L14
    L7:
        r4 = false;
        goto L8
    }

    public final boolean c(k1 r7) {
        Editable r0 = this.T.getText();
        if (r0 != null) goto L5;
        return false;
    L5:
        int r2 = r0.length();
        int r3 = r7.a;
        if (r3 < 0) goto L9;
        if (r3 > r2) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L25;
        int r5 = r0.length();
        int r6 = r7.b;
        if (r3 > r6) goto L15;
        if (r6 > r5) goto L15;
        boolean r8 = true;
    L16:
        if (r8 == false) goto L25;
        this.J = true;
        r0.delete(r7.a, r6);     // Catch: Throwable -> L22
        this.J = false;
        this.G = null;
        this.H = null;
        this.I = null;
        return true;
    L22:
        th = move-exception;
        this.J = false;
        throw th;
    L15:
        r8 = false;
    L25:
        return false;
    L9:
        r4 = false;
        goto L10
    }

    public final void e(MultiTypePanelTrigger r2) {
        int r3 = c.a[r2.ordinal()];
        if (r3 != 1) goto L5;
        d();
        return;
    L5:
        if (r3 != 2) goto L7;
    L11:
        g();
        f();
        return;
    L7:
        if (r3 == 3) goto L11;
        throw new NoWhenBranchMatchedException();
    }

    public final k1 j(Editable r12) {
        if (r12 != null) goto L5;
        return null;
    L5:
        int r1 = this.T.getSelectionStart();
        if (r1 >= 0) goto L8;
    L71:
        return null;
    L8:
        if (r1 != this.T.getSelectionEnd()) goto L71;
        if (r1 > r12.length()) goto L71;
        int r2 = r1 - 1;
    L13:
        if (r2 < 0) goto L71;
        if (CharsKt.isWhitespace(r12.charAt(r2)) == true) goto L71;
        char r3 = r12.charAt(r2);
        if (r3 != '/') goto L19;
        MultiTypePanelTrigger r4 = MultiTypePanelTrigger.SLASH;
        if (this.y == true) goto L26;
    L20:
        r4 = null;
    L26:
        if (r4 == null) goto L70;
        boolean r5 = false;
        if (r2 <= 0) goto L55;
        char r6 = r12.charAt(r2 - 1);
        if ('A' <= r6) goto L32;
    L34:
        boolean r7 = false;
    L35:
        if (r7 == false) goto L37;
    L52:
        boolean r8 = true;
    L53:
        if (r8 == false) goto L55;
    L37:
        if ('a' <= r6) goto L39;
    L41:
        boolean r9 = false;
    L42:
        if (r9 == true) goto L52;
        if ('0' <= r6) goto L46;
    L48:
        boolean r10 = false;
    L49:
        if (r10 == true) goto L52;
        r8 = false;
        goto L53
    L46:
        if (r6 >= ':') goto L48;
        r10 = true;
        goto L49
    L39:
        if (r6 >= '{') goto L41;
        r9 = true;
        goto L42
    L32:
        if (r6 >= '[') goto L34;
        r7 = true;
    L55:
        Object[] r11 = r12.getSpans(0, r12.length(), l0.class);
        int r13 = r11.length;
        int r14 = 0;
    L56:
        if (r14 >= r13) goto L66;
        l0 r15 = (l0) r11[r14];
        if (r12.getSpanStart(r15) <= r2) goto L60;
    L62:
        boolean r16 = false;
    L63:
        if (r16 == true) goto L64;
        r14 = r14 + 1;
        goto L56
    L64:
        r5 = true;
        goto L66
    L60:
        if (r12.getSpanEnd(r15) < r1) goto L62;
        r16 = true;
    L66:
        if (r5 == false) goto L69;
        return null;
    L69:
        return new k1(r2, r1, r12.subSequence(r2 + 1, r1).toString(), r4);
    L70:
        r2 = r2 - 1;
        goto L13
    L19:
        if (r3 != '@') goto L20;
        r4 = MultiTypePanelTrigger.MENTION;
        if (this.z == false) goto L20;
        goto L20
    }

    public final void k(MultiTypePanelTrigger r3) {
        o(false);
        this.G = null;
        this.H = null;
        this.I = null;
        this.M = false;
        e(r3);
        p(false);
    }

    public final boolean n(boolean r14) {
        FLogger r0 = FLogger.a;
        r0.i("MultiTypeMentionPanelController", "[openSkillPanel] begin, available=" + this.A + ", useActionBarPresetMaxHeight=" + r14 + ", editVisibility=" + this.T.getVisibility() + ", editShown=" + this.T.isShown() + ", editAttached=" + this.T.isAttachedToWindow() + ", editEnabled=" + this.T.isEnabled() + ", editFocused=" + this.T.isFocused() + ", containerVisibility=" + this.b.getVisibility() + ", containerShown=" + this.b.isShown() + ", containerAttached=" + this.b.isAttachedToWindow() + ", containerSize=" + this.b.getWidth() + 'x' + this.b.getHeight());
        if (this.A == true) goto L6;
        r0.i("MultiTypeMentionPanelController", "[openSkillPanel] rejected, reason=skillPanelUnavailable");
        return false;
    L6:
        Editable r1 = this.T.getText();
        int r8 = this.T.getSelectionStart();
        int r9 = this.T.getSelectionEnd();
        StringBuilder r10 = new StringBuilder("[openSkillPanel] input ready, textLength=");
        if (r1 == null) goto L9;
        int r11 = r1.length();
    L10:
        r10.append(r11);
        r10.append(", selection=");
        r10.append(r8);
        r10.append("..");
        r10.append(r9);
        r0.i("MultiTypeMentionPanelController", r10.toString());
        if (r8 < 0) goto L50;
        if (r8 != r9) goto L50;
        k1 r2 = j(r1);
        if (r2 != null) goto L17;
    L22:
        r2 = null;
    L23:
        if (r2 != null) goto L26;
        r2 = new k1(r8, r8, "", MultiTypePanelTrigger.EXTERNAL_SKILL);
    L26:
        if (this.H != null) goto L35;
        if (r14 == true) goto L29;
    L33:
        boolean r15 = false;
    L34:
        o(r15);
        goto L35
    L29:
        if (r2.d != MultiTypePanelTrigger.EXTERNAL_SKILL) goto L33;
        if (((Boolean) this.m.invoke()).booleanValue() == false) goto L33;
        r15 = true;
    L35:
        this.G = r2;
        Integer r16 = Integer.valueOf(r2.a);
        r16.intValue();
        if (r2.d != MultiTypePanelTrigger.EXTERNAL_SKILL) goto L38;
        boolean r12 = true;
    L39:
        if (r12 == true) goto L42;
        r16 = null;
    L42:
        this.H = r16;
        this.I = null;
        this.M = false;
        SlashPanelController r17 = i();
        MentionPanelController r7 = this.Y;
        if (r7 == null) goto L45;
        r7.i();
    L45:
        ProjectPanelController r13 = this.a0;
        if (r13 == null) goto L48;
        r13.b();
    L48:
        a(r2.d);
        Intrinsics.checkNotNullParameter(r2, "queryRange");
        r17.l(r2);
        r0.i("MultiTypeMentionPanelController", "[openSkillPanel] end, trigger=" + r2.d + ", taskSkillPanelVisible=" + this.K + ", containerVisibility=" + this.b.getVisibility() + ", containerShown=" + this.b.isShown() + ", containerSize=" + this.b.getWidth() + 'x' + this.b.getHeight());
        return true;
    L38:
        r12 = false;
        goto L39
    L17:
        if (r2.d != MultiTypePanelTrigger.SLASH) goto L19;
        boolean r18 = true;
    L20:
        if (r18 == false) goto L22;
    L19:
        r18 = false;
    L50:
        r0.i("MultiTypeMentionPanelController", "[openSkillPanel] rejected, reason=invalidSelection");
        return false;
    L9:
        r11 = 0;
        goto L10
    }

    public final void o(boolean r2) {
        if (this.N != r2) goto L5;
        return;
    L5:
        this.N = r2;
        this.s.invoke(Boolean.valueOf(r2));
    }

    public final void p(boolean r13) {
        FLogger r0 = FLogger.a;
        r0.i("MultiTypeMentionPanelController", "[setPanelVisible] request=" + r13 + ", current=" + this.K + ", containerVisibility=" + this.b.getVisibility() + ", containerShown=" + this.b.isShown() + ", containerAttached=" + this.b.isAttachedToWindow() + ", containerSize=" + this.b.getWidth() + 'x' + this.b.getHeight());
        int r1 = 0;
        if (r13 == true) goto L11;
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.q0 r7 = this.V;
        if (r7 == null) goto L7;
        r7.d.i(false);
    L7:
        com.larus.bmhome.chat.component.bottom.core.inputtext.slash.r r8 = this.W;
        if (r8 == null) goto L11;
        r8.e.i(false);
    L11:
        if (this.K == r13) goto L13;
        this.K = r13;
        this.r.invoke(Boolean.valueOf(r13));
    L13:
        ConstraintLayout r9 = this.d.h();
        if (r9 == null) goto L27;
        if (r13 == true) goto L18;
        Integer r10 = this.L;
        if (r10 == null) goto L27;
        int r11 = r10.intValue();
        this.L = null;
        if (r9.getPaddingTop() != 0) goto L27;
        r9.setPadding(r9.getPaddingLeft(), r11, r9.getPaddingRight(), r9.getPaddingBottom());
        goto L27
    L18:
        if (this.L != null) goto L27;
        this.L = Integer.valueOf(r9.getPaddingTop());
        r9.setPadding(r9.getPaddingLeft(), 0, r9.getPaddingRight(), r9.getPaddingBottom());
    L27:
        if (this.b.getVisibility() != 0) goto L29;
        boolean r12 = true;
    L30:
        if (r12 == r13) goto L36;
        ViewGroup r14 = this.b;
        if (r13 == true) goto L35;
        r1 = 8;
    L35:
        r14.setVisibility(r1);
        this.q.invoke(Boolean.valueOf(r13));
    L36:
        r0.i("MultiTypeMentionPanelController", "[setPanelVisible] applied=" + r13 + ", taskSkillPanelVisible=" + this.K + ", containerVisibility=" + this.b.getVisibility() + ", containerShown=" + this.b.isShown() + ", containerSize=" + this.b.getWidth() + 'x' + this.b.getHeight());
        if (r13 == false) goto L40;
        this.b.post(new q0(this));
        return;
    L40:
        return;
    L29:
        r12 = false;
        goto L30
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void r(List<d0> r15) {
        this.P = r15;
        ChatInputWithMentionDelegate r0 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r15, "references");
        List<d0> r2 = r0.k;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L3:
        boolean r5 = false;
        if (r4.hasNext() == false) goto L17;
        Object r6 = r4.next();
        d0 r7 = (d0) r6;
        if (r15.isEmpty() == true) goto L14;
        Iterator<T> r8 = r15.iterator();
    L10:
        if (r8.hasNext() == false) goto L14;
        if (ChatInputWithMentionDelegate.k(r7, (d0) r8.next()) == false) goto L10;
    L15:
        if (r5 == false) goto L3;
        r3.add(r6);
    L14:
        r5 = true;
        goto L15
    L17:
        r0.k = r15;
        Editable r9 = r0.e.getEditableText();
        if (r9 == null) goto L64;
        Object[] r10 = r9.getSpans(0, r9.length(), l0.class);
        ArrayList r11 = new ArrayList();
        int r12 = r10.length;
        int r13 = 0;
    L21:
        if (r13 >= r12) goto L29;
        Object r14 = r10[r13];
        if (((l0) r14).a.getType() != InputReferenceType.ATTACHMENT) goto L25;
        boolean r16 = true;
    L26:
        if (r16 == false) goto L28;
        r11.add(r14);
    L28:
        r13 = r13 + 1;
        goto L21
    L25:
        r16 = false;
        goto L26
    L29:
        Iterator r17 = CollectionsKt.sortedWith(r11, new z(r9)).iterator();
    L31:
        if (r17.hasNext() == false) goto L64;
        l0 r18 = (l0) r17.next();
        d0 r19 = r18.a;
        int r20 = r9.getSpanStart(r18);
        int r110 = r9.getSpanEnd(r18);
        if (r20 < 0) goto L31;
        if (r110 <= r20) goto L31;
        if (r3.isEmpty() == true) goto L45;
        Iterator r111 = r3.iterator();
    L41:
        if (r111.hasNext() == false) goto L45;
        if (ChatInputWithMentionDelegate.k(r19, (d0) r111.next()) == false) goto L41;
        boolean r112 = true;
    L46:
        if (r112 == true) goto L48;
        d0 r113 = r0.m(r19);
        if (Intrinsics.areEqual(r113, r19) == true) goto L31;
        r9.removeSpan(r18);
        Object[] r21 = r9.getSpans(r20, r110, j0.class);
        int r22 = r21.length;
        int r114 = 0;
    L61:
        if (r114 >= r22) goto L63;
        r9.removeSpan(r21[r114]);
        r114 = r114 + 1;
        goto L61
    L63:
        r0.e(r9, r113, r20, r110);
        goto L31
    L48:
        if (r110 < r9.length()) goto L50;
    L52:
        r0.i = true;
        r9.delete(r20, r110);     // Catch: Throwable -> L55
        r0.i = false;
        r0.j = CollectionsKt.emptyList();
    L55:
        th = move-exception;
        r0.i = false;
        r0.j = CollectionsKt.emptyList();
        throw th;
    L50:
        if (r9.charAt(r110) != ' ') goto L52;
        r110 = r110 + 1;
    L45:
        r112 = false;
    L64:
        MentionPanelController r1 = this.Y;
        if (r1 == null) goto L99;
        Intrinsics.checkNotNullParameter(r15, "references");
        r1.o = r15;
        k1 r115 = r1.n;
        if (r115 == null) goto L100;
        r1.p(r115);
        return;
    L100:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v24, types: [android.view.View$OnLayoutChangeListener, com.larus.bmhome.chat.component.bottom.core.inputtext.e1] */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.f1] */
    public MultiTypeMentionPanelController(ChatInputWithMentionDelegate r17, ViewGroup r18, y8 r19, va8.c r20, Function0 r21, CoroutineScope r22, qp8.e r23, Fragment r24, Function0 r25, Function0 r26, i r27, j r28, k r29, l r30, Function0 r31, Function1 r32, Function1 r33, Function1 r34, Function1 r35, m r36, boolean r37, boolean r38, boolean r39, List r40, List r41) {
        Intrinsics.checkNotNullParameter(r17, "inputDelegate");
        Intrinsics.checkNotNullParameter(r18, "panelContainer");
        Intrinsics.checkNotNullParameter(r19, "dependency");
        Intrinsics.checkNotNullParameter(r20, "inputUiContract");
        Intrinsics.checkNotNullParameter(r21, "panelTopAnchorYProvider");
        Intrinsics.checkNotNullParameter(r22, "coroutineScope");
        Intrinsics.checkNotNullParameter(r23, "officeMentionConfig");
        Intrinsics.checkNotNullParameter(r24, "hostFragment");
        Intrinsics.checkNotNullParameter(r25, "isInTaskMode");
        Intrinsics.checkNotNullParameter(r26, "switchToTaskModeIfNeeded");
        Intrinsics.checkNotNullParameter(r27, "isVoiceMode");
        Intrinsics.checkNotNullParameter(r28, "canCreateDocument");
        Intrinsics.checkNotNullParameter(r29, "shouldSelectSkillInActionBar");
        Intrinsics.checkNotNullParameter(r30, "shouldShowProjects");
        Intrinsics.checkNotNullParameter(r31, "skillAbilityProvider");
        Intrinsics.checkNotNullParameter(r32, "onSelectFile");
        Intrinsics.checkNotNullParameter(r33, "onPanelVisibleChanged");
        Intrinsics.checkNotNullParameter(r34, "onTaskSkillPanelVisibleChanged");
        Intrinsics.checkNotNullParameter(r35, "onSkillSearchModeChanged");
        Intrinsics.checkNotNullParameter(r36, "onSkillSearchFinished");
        this.a = r17;
        this.b = r18;
        this.c = r19;
        this.d = r20;
        this.e = r21;
        this.f = r22;
        this.g = r23;
        this.h = r24;
        this.i = r25;
        this.j = r26;
        this.k = r27;
        this.l = r28;
        this.m = r29;
        this.n = r30;
        this.o = r31;
        this.p = r32;
        this.q = r33;
        this.r = r34;
        this.s = r35;
        this.t = r36;
        this.u = r37;
        this.v = r38;
        SlashPanelContent.Companion.getClass();
        if (r40 != null) goto L5;
        List r1 = SlashMentionConfig.DEFAULT_SLASH_CONTENTS;
    L6:
        EnumEntries<SlashPanelContent> r2 = SlashPanelContent.getEntries();
        LinkedHashSet r3 = new LinkedHashSet();
        Iterator r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L12;
        Object r5 = r4.next();
        if (r1.contains(((SlashPanelContent) r5).getConfigValue()) == false) goto L8;
        r3.add(r5);
        goto L8
    L12:
        this.w = r3;
        MentionPanelContent.Companion.getClass();
        if (r41 != null) goto L15;
        List r6 = SlashMentionConfig.DEFAULT_MENTION_CONTENTS;
    L16:
        EnumEntries<MentionPanelContent> r7 = MentionPanelContent.getEntries();
        LinkedHashSet r8 = new LinkedHashSet();
        Iterator r9 = r7.iterator();
    L18:
        if (r9.hasNext() == false) goto L22;
        Object r10 = r9.next();
        if (r6.contains(((MentionPanelContent) r10).getConfigValue()) == false) goto L18;
        r8.add(r10);
        goto L18
    L22:
        this.x = r8;
        boolean r11 = this.h instanceof xe8.a;
        boolean r12 = false;
        if (r11 == true) goto L25;
    L30:
        boolean r13 = false;
    L31:
        this.y = r13;
        if (r11 == true) goto L34;
    L39:
        boolean r14 = false;
    L40:
        this.z = r14;
        if (r13 == true) goto L43;
    L45:
        boolean r15 = false;
    L46:
        this.A = r15;
        if (r13 == true) goto L49;
    L51:
        this.B = r12;
        this.C = new SkillSearchIndex();
        this.D = ((Boolean) this.i.invoke()).booleanValue();
        this.F = new h1(this);
        ?? r16 = new e1(this);
        this.O = r16;
        this.P = CollectionsKt.emptyList();
        LarkSocialExp.a.getClass();
        m2 r42 = (m2) LarkSocialExp.e.getValue();
        this.S = TuplesKt.to(Boolean.valueOf(r42.c), Boolean.valueOf(r42.d));
        EditText r43 = this.a.a;
        this.T = r43;
        this.U = new b0(r43, new f1(this));
        this.b.removeAllViews();
        this.b.setOutlineProvider(new g1());
        this.b.setClipToOutline(true);
        this.b.addOnLayoutChangeListener(r16);
        ViewExtKt.n(this.b, null, null, new r0(this), 3);
        i1 r44 = new i1(this);
        this.b0 = r44;
        r43.addTextChangedListener(r44);
        com.larus.bmhome.chat.component.bottom.attachment.g1 r45 = this.c.f70();
        if (r45 == null) goto L60;
        kotlinx.coroutines.flow.b1 r46 = r45.YB();
        if (r46 == null) goto L60;
        Iterable r47 = (Iterable) r46.getValue();
        ArrayList r48 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r47, 10));
        Iterator r49 = r47.iterator();
    L57:
        if (r49.hasNext() == false) goto L59;
        r48.add(k0.d((id8.f) r49.next()));
        goto L57
    L59:
        r(r48);
        this.Q = BuildersKt.launch$default(this.f, null, null, new MultiTypeMentionPanelController$observeAttachmentReferences$2(r46, this, null), 3, null);
    L60:
        AccountService.a.E(this.F);
        this.R = BuildersKt.launch$default(this.f, Dispatchers.getMain().getImmediate(), null, new AnonymousClass3(this, null), 2, null);
        return;
    L49:
        if (this.w.contains(SlashPanelContent.PROJECT) == false) goto L51;
        r12 = true;
        goto L51
    L43:
        if (this.w.contains(SlashPanelContent.SKILL) == false) goto L45;
        r15 = true;
        goto L46
    L34:
        if (this.v == false) goto L39;
        if ((!r8.isEmpty()) == false) goto L39;
        if (r39 == true) goto L39;
        r14 = true;
        goto L40
    L25:
        if (this.u == false) goto L30;
        if ((!this.w.isEmpty()) == false) goto L30;
        if (r39 == true) goto L30;
        r13 = true;
        goto L31
    L15:
        r6 = r41;
        goto L16
    L5:
        r1 = r40;
        goto L6
    }
}
