package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.bottommenu.MentionFilePickerType;
import com.larus.bmhome.chat.component.bottom.core.CoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.b4;
import com.larus.bmhome.chat.component.bottom.core.l2;
import com.larus.bmhome.chat.component.bottom.core.m4;
import com.larus.bmhome.chat.component.bottom.core.q3;
import com.larus.bmhome.chat.component.bottom.core.x4;
import com.larus.bmhome.chat.component.bottom.core.y8;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.input.api.officemention.OfficeMentionService;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatInputMentionPanelController {
    public static final /* synthetic */ int r = 0;
    public final c a;
    public final ViewGroup b;
    public final y8 c;
    public final CoreInputAbility<?> d;
    public final va8.o e;
    public final qp8.b f;
    public final MultiTypeMentionPanelController g;
    public final Lazy h;
    public boolean i;
    public boolean j;
    public String k;
    public int l;
    public int m;
    public boolean n;
    public RecyclerView o;
    public ViewTreeObserver.OnPreDrawListener p;
    public ViewTreeObserver q;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputMentionPanelController$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Integer> {
        public AnonymousClass1(Object r8) {
            super(0, r8, ChatInputMentionPanelController.class, "resolvePanelTopAnchorY", "resolvePanelTopAnchorY()Ljava/lang/Integer;", 0);
        }

        public final Integer invoke() {
            View r0 = ((ChatInputMentionPanelController) ((CallableReference) this).receiver).b.getRootView();
            if (r0.getHeight() <= 0) goto L5;
            boolean r1 = true;
        L7:
            if (r1 == true) goto L10;
            r0 = null;
        L10:
            if (r0 == null) goto L17;
            WindowInsetsCompat r2 = ViewCompat.getRootWindowInsets(r0);
            if (r2 == null) goto L18;
            int r3 = r2.getInsets(WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.displayCutout()).top;
            int[] r4 = new int[2];
            r0.getLocationOnScreen(r4);
            return Integer.valueOf(r4[1] + r3);
        L18:
            return null;
        L17:
            return null;
        L5:
            r1 = false;
            goto L7
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m58invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputMentionPanelController$6, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<MentionFilePickerType, Unit> {
        public AnonymousClass6(Object r8) {
            super(1, r8, ChatInputMentionPanelController.class, "launchFilePickerAfterPanelDismissed", "launchFilePickerAfterPanelDismissed(Lcom/larus/bmhome/chat/component/bottom/bottommenu/MentionFilePickerType;)V", 0);
        }

        public final void invoke(MentionFilePickerType r5) {
            Intrinsics.checkNotNullParameter(r5, "p0");
            ChatInputMentionPanelController r0 = (ChatInputMentionPanelController) ((CallableReference) this).receiver;
            va8.m r1 = r0.c.vU();
            if (r1 == null) goto L9;
            va8.l r2 = r1.iX();
            if (r2 == null) goto L9;
            ConstraintLayout r3 = r2.getRootView();
            if (r3 == null) goto L9;
        L11:
            if (Build.VERSION.SDK_INT <= 33) goto L13;
        L15:
            r0.a.u.invoke(r5);
            return;
        L13:
            if (r0.e.w() == false) goto L15;
            r0.d.qp(true);
            r0.b(r3, r5, 0);
            return;
        L9:
            r3 = r0.a.c;
            goto L11
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((MentionFilePickerType) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputMentionPanelController$7, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass7(Object r8) {
            super(1, r8, ChatInputMentionPanelController.class, "onPanelVisibleChanged", "onPanelVisibleChanged(Z)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Boolean) r1).booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean r3) {
            ChatInputMentionPanelController r0 = (ChatInputMentionPanelController) ((CallableReference) this).receiver;
            int r1 = ChatInputMentionPanelController.r;
            r0.d(r3);
        }
    }

    public /* synthetic */ class a implements qp8.d, FunctionAdapter {
        public final /* synthetic */ ChatInputMentionPanelController a;

        public a(ChatInputMentionPanelController r1) {
            this.a = r1;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof qp8.d) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(1, this.a, ChatInputMentionPanelController.class, "onPanelVisibleChanged", "onPanelVisibleChanged(Z)V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final void a(boolean r2) {
            this.a.d(r2);
        }
    }

    public static final class b {
    }

    public static final class c {
        public final p0 a;
        public final ViewGroup b;
        public final ViewGroup c;
        public final View d;
        public final y8 e;
        public final CoreInputAbility<?> f;
        public final va8.o g;
        public final String h;
        public final boolean i;
        public final boolean j;
        public final CoroutineScope k;
        public final boolean l;
        public final boolean m;
        public final boolean n;
        public final List<String> o;
        public final List<String> p;
        public final Fragment q;
        public final Function0<Boolean> r;
        public final Function0<Boolean> s;
        public final Function0<be8.a> t;
        public final Function1<MentionFilePickerType, Unit> u;
        public final Function1<Boolean, Unit> v;
        public final Function1<Boolean, Unit> w;

        public c(p0 r17, ViewGroup r18, ViewGroup r19, View r20, y8 r21, CoreInputAbility r22, va8.o r23, String r24, boolean r25, boolean r26, LifecycleCoroutineScope r27, boolean r28, boolean r29, boolean r30, List r31, List r32, Fragment r33, l2 r34, q3 r35, b4 r36, m4 r37, Function1 r38, x4 r39) {
            Intrinsics.checkNotNullParameter(r17, "inputDelegate");
            Intrinsics.checkNotNullParameter(r18, "panelView");
            Intrinsics.checkNotNullParameter(r19, "underlyingPanelsContainer");
            Intrinsics.checkNotNullParameter(r20, "inputAreaAboveDivider");
            Intrinsics.checkNotNullParameter(r21, "dependency");
            Intrinsics.checkNotNullParameter(r22, "coreInputAbility");
            Intrinsics.checkNotNullParameter(r23, "inputUiAbility");
            Intrinsics.checkNotNullParameter(r24, "appId");
            Intrinsics.checkNotNullParameter(r27, "coroutineScope");
            Intrinsics.checkNotNullParameter(r33, "hostFragment");
            Intrinsics.checkNotNullParameter(r34, "isInTaskMode");
            Intrinsics.checkNotNullParameter(r35, "switchToTaskModeIfNeeded");
            Intrinsics.checkNotNullParameter(r36, "skillAbilityProvider");
            Intrinsics.checkNotNullParameter(r37, "onSelectMentionFile");
            Intrinsics.checkNotNullParameter(r38, "onTaskSkillPanelVisibleChanged");
            Intrinsics.checkNotNullParameter(r39, "onSkillSearchModeChanged");
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
            this.w = r39;
        }
    }

    static {
    }

    public final void a() {
        ViewTreeObserver.OnPreDrawListener r0 = this.p;
        ViewTreeObserver r1 = this.q;
        if (r0 == null) goto L11;
        boolean r2 = false;
        if (r1 != null) goto L7;
    L9:
        if (r2 == false) goto L11;
        r1.removeOnPreDrawListener(r0);
        goto L11
    L7:
        if (r1.isAlive() != true) goto L9;
        r2 = true;
    L11:
        RecyclerView r3 = this.o;
        if (r3 == null) goto L14;
        r3.setTag(2131365551, Boolean.FALSE);
    L14:
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public final void c() {
        qp8.b r0 = this.f;
        if (r0 == null) goto L5;
        r0.onDestroy();
    L5:
        MultiTypeMentionPanelController r1 = this.g;
        if (r1 == null) goto L22;
        r1.E = true;
        AccountService.a.D(r1.F);
        r1.C.a();
        r1.o(false);
        r1.T.removeTextChangedListener(r1.b0);
        b0 r3 = r1.U;
        if (r3.a.getViewTreeObserver().isAlive() == false) goto L10;
        r3.a.getViewTreeObserver().removeOnPreDrawListener(r3.h);
    L10:
        r3.a.getOverlay().remove(r3.g);
        ColorStateList r4 = r3.f;
        if (r4 != null) goto L13;
    L15:
        r3.f = null;
        r1.b.removeOnLayoutChangeListener(r1.O);
        ViewCompat.setWindowInsetsAnimationCallback(r1.b, null);
        Job r5 = r1.Q;
        if (r5 == null) goto L18;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L18:
        r1.Q = null;
        Job r6 = r1.R;
        if (r6 == null) goto L21;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L21:
        r1.R = null;
        r1.G = null;
        r1.H = null;
        r1.I = null;
        r1.M = false;
        r1.d();
        r1.g();
        r1.f();
        r1.p(false);
        goto L22
    L13:
        if (r3.a.getCurrentHintTextColor() != 0) goto L15;
        r3.a.setHintTextColor(r4);
    L22:
        this.b.setVisibility(8);
        d(false);
        a();
    }

    public final void d(boolean r10) {
        if (r10 == this.i) goto L58;
        va8.p r0 = s1a.a.g(this.a.q).getAbility(va8.p.class);
        if (r0 == null) goto L7;
        r0.ZN(!r10);
    L7:
        if (r10 == false) goto L39;
        a();
        va8.p r1 = s1a.a.g(this.a.q).getAbility(va8.p.class);
        if (r1 == null) goto L50;
        RecyclerView r2 = r1.Ly();
        if (r2 == null) goto L50;
        if (r2.getHeight() <= 0) goto L50;
        String r3 = null;
        this.k = null;
        this.l = -1;
        this.m = 0;
        u7 r5 = this.c.u3();
        if (r5 == null) goto L18;
        boolean r6 = r5.D80();
    L19:
        this.n = r6;
        LinearLayoutManager r7 = r2.getLayoutManager();
        if ((r7 instanceof LinearLayoutManager) == false) goto L22;
        LinearLayoutManager r8 = r7;
    L23:
        if (r8 == null) goto L50;
        View r9 = r8.getChildAt(0);
        if (r9 == null) goto L50;
        int r11 = r8.getPosition(r9);
        if (r11 == (-1)) goto L50;
        Object r4 = r9.getTag(2131365552);
        if ((r4 instanceof String) == false) goto L34;
        r3 = (String) r4;
    L34:
        this.k = r3;
        this.l = r11;
        if (r8.getReverseLayout() == false) goto L37;
        int r12 = r2.getHeight() - r2.getPaddingBottom();
        int r13 = r8.getDecoratedBottom(r9);
    L38:
        this.m = r12 - r13;
        goto L50
    L37:
        r12 = r8.getDecoratedTop(r9);
        r13 = r2.getPaddingTop();
        goto L38
    L22:
        r8 = null;
        goto L23
    L18:
        r6 = true;
    L50:
        xa8.a r14 = (xa8.a) this.h.getValue();
        if (r14 == null) goto L53;
        r14.H9(r10);
    L53:
        if (r10 == true) goto L58;
        u7 r15 = this.c.u3();
        if (r15 == null) goto L58;
        r15.U1();
        goto L58
    L39:
        a();
        va8.p r16 = s1a.a.g(this.a.q).getAbility(va8.p.class);
        if (r16 == null) goto L50;
        RecyclerView r17 = r16.Ly();
        if (r17 == null) goto L50;
        if (r17.getHeight() > 0) goto L50;
        ViewTreeObserver r18 = r17.getViewTreeObserver();
        if (r18.isAlive() == false) goto L50;
        r17.setTag(2131365551, Boolean.TRUE);
        p r19 = new p(r17, this);
        this.o = r17;
        this.p = r19;
        this.q = r18;
        r18.addOnPreDrawListener(r19);
    L58:
        if (r10 == this.i) goto L68;
        if (r10 == true) goto L62;
        this.e.e10(this.j);
    L67:
        this.i = r10;
        goto L68
    L62:
        if (this.a.d.getVisibility() != 0) goto L64;
        boolean r20 = true;
    L65:
        this.j = r20;
        this.e.e10(true);
        goto L67
    L64:
        r20 = false;
    L68:
        ViewGroup r21 = this.a.c;
        if ((!r10) == false) goto L71;
        int r22 = 0;
    L72:
        r21.setVisibility(r22);
        if (r10 == true) goto L118;
        if (this.d.FF() != null) goto L106;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r110 = this.c.f70();
        if (r110 != null) goto L79;
    L81:
        boolean r111 = false;
    L82:
        if (r111 == true) goto L106;
        com.larus.bmhome.chat.component.bottom.reference.a r112 = this.c.g5();
        if (r112 != null) goto L86;
    L88:
        boolean r113 = false;
    L89:
        if (r113 == true) goto L106;
        com.larus.bmhome.instruction.g r114 = this.c.vc();
        if (r114 != null) goto L93;
    L95:
        boolean r115 = false;
    L96:
        if (r115 == true) goto L106;
        ys8.a r116 = this.c.DC();
        if (r116 != null) goto L100;
    L102:
        boolean r117 = false;
    L103:
        if (r117 == true) goto L106;
        boolean r118 = false;
    L107:
        if (r118 == true) goto L118;
        if (this.c.f1().C() == false) goto L116;
        int r119 = com.larus.bmhome.chat.immerse.k0.a;
        Integer r120 = this.c.f1().m();
        if (r120 == null) goto L114;
        int r121 = r120.intValue();
    L115:
        int r122 = com.larus.bmhome.chat.immerse.k0.a(r121, 0.1f, 0.35f);
        GradientDrawable r23 = new GradientDrawable();
        r23.setShape(0);
        r23.setCornerRadius(l1.a(this.b.getContext()));
        r23.setColor(r122);
        this.e.l70(r23, r122);
        return;
    L114:
        r121 = 0;
        goto L115
    L116:
        this.e.p9(v19.c.b(2130970689, this.b.getContext(), 2131239150));
        return;
    L100:
        if (r116.z0() != true) goto L102;
        r117 = true;
        goto L103
    L93:
        if (r114.z0() != true) goto L95;
        r115 = true;
        goto L96
    L86:
        if (r112.i9() != true) goto L88;
        r113 = true;
        goto L89
    L79:
        if (r110.isVisible() != true) goto L81;
        r111 = true;
    L106:
        r118 = true;
    L118:
        if (this.c.f1().C() == false) goto L124;
        int r123 = com.larus.bmhome.chat.immerse.k0.a;
        Integer r124 = this.c.f1().m();
        if (r124 == null) goto L122;
        int r125 = r124.intValue();
    L123:
        int r126 = com.larus.bmhome.chat.immerse.k0.a(r125, 0.1f, 0.35f);
        float r24 = l1.a(this.b.getContext());
        GradientDrawable r25 = new GradientDrawable();
        r25.setShape(0);
        r25.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, r24, r24, r24, r24});
        r25.setColor(r126);
        this.e.l70(r25, r126);
        return;
    L122:
        r125 = 0;
        goto L123
    L124:
        this.e.p9(v19.c.b(2130970690, this.b.getContext(), 2131239155));
        return;
    L71:
        r22 = 8;
        goto L72
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.m] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.i] */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.j] */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.k] */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.l] */
    public ChatInputMentionPanelController(c r30, boolean r31) {
        Intrinsics.checkNotNullParameter(r30, "mentionContext");
        this.a = r30;
        ViewGroup r9 = r30.b;
        this.b = r9;
        y8 r5 = r30.e;
        this.c = r5;
        CoreInputAbility<?> r2 = r30.f;
        this.d = r2;
        va8.o r3 = r30.g;
        this.e = r3;
        this.h = LazyKt.lazy(new h(this));
        this.l = -1;
        this.n = true;
        p0 r4 = r30.a;
        qp8.b r7 = null;
        if ((r4 instanceof ChatInputWithMentionDelegate) == false) goto L5;
        ChatInputWithMentionDelegate r6 = (ChatInputWithMentionDelegate) r4;
    L6:
        qp8.e r15 = new qp8.e(r30.h, r30.i, r30.j, new ChatInputMentionPanelController$officeMentionConfig$1(r2));
        if (r30.l == false) goto L10;
        if (r6 == null) goto L10;
        this.f = null;
        ViewGroup r1 = r9;
        this.g = new MultiTypeMentionPanelController(r6, r9, r5, r3.Uv(), new AnonymousClass1(this), r30.k, r15, r30.q, r30.r, r30.s, new i(this), new j(this), new k(this), new l(this), r30.t, new AnonymousClass6(this), new AnonymousClass7(this), r30.v, r30.w, new m(this), r30.m, r30.n, r31, r30.o, r30.p);
    L20:
        if (this.f == null) goto L22;
        return;
    L22:
        if (this.g != null) goto L28;
        r1.setVisibility(8);
        if (r31 == true) goto L29;
        FLogger.a.e("ChatInputMentionPanel", "[init] Office Mention panel is unavailable");
        return;
    L29:
        return;
    L28:
        return;
    L10:
        r1 = r9;
        this.g = null;
        if (r6 == null) goto L13;
        qp8.a r8 = r6.g;
    L14:
        if (r8 == null) goto L18;
        if (r31 == true) goto L18;
        r7 = OfficeMentionService.b.n(r8, r1, r15, new a(this));
    L18:
        this.f = r7;
        goto L20
    L13:
        r8 = null;
        goto L14
    L5:
        r6 = null;
        goto L6
    }

    public final void b(final View r2, final MentionFilePickerType r3, final int r4) {
        if (r2.isAttachedToWindow() == true) goto L6;
        return;
    L6:
        if (this.e.w() == false) goto L13;
        if (r4 >= 30) goto L13;
        r2.postOnAnimation(new g(this, r2, r3, r4));
        return;
    L13:
        if ((r2 instanceof ChatConstraintLayout) == false) goto L15;
        ChatConstraintLayout r5 = (ChatConstraintLayout) r2;
    L16:
        if (r5 == null) goto L18;
        r5.u6();
    L18:
        OneShotPreDrawListener.add(r2, new n(r2, r2, this, r3));
        return;
    L15:
        r5 = null;
        goto L16
    }
}
