package com.ss.android.lark.chat.chatwindow.biz.component.keyboard;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.OneShotPreDrawListener;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.MessageListAnimationContainer;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.chat.utils.x;
import com.ss.android.lark.chat.utils.y;
import com.ss.android.lark.keyboard.base.ReEditInfo;
import com.ss.android.lark.keyboard.event.HeightChange;
import com.ss.android.lark.keyboard.event.ImeState;
import com.ss.android.lark.keyboard.event.l;
import com.ss.android.lark.keyboard.keyboard2.BasicKeyboard;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.q;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class ChatKeyboardEventHandler implements j2b.a {
    public static final /* synthetic */ int e = 0;
    public final Lazy a;
    public com.ss.android.lark.keyboard.b b;
    public boolean c;
    public boolean d;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {
        public final /* synthetic */ Function0 a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r1) {
            this.a.invoke();
        }
    }

    public static final class c implements Animator.AnimatorListener {
        public final /* synthetic */ Function0 a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        public c(Function0 r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
            this.a.invoke();
        }
    }

    static {
    }

    public abstract boolean c();

    public abstract int f();

    public boolean h() {
        return false;
    }

    public abstract boolean j();

    public abstract boolean k();

    public abstract boolean l(String r1);

    public abstract MessageListAnimationContainer m();

    public abstract void n();

    public abstract void o(String r1);

    public abstract void q(List<? extends hya.c<String, f5b.b>> r1);

    public abstract m2b.a r();

    public final com.ss.android.lark.keyboard.b g() {
        com.ss.android.lark.keyboard.b r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        return null;
    }

    public ChatKeyboardEventHandler() {
        this.a = LazyKt.lazy(LazyThreadSafetyMode.NONE, new ChatKeyboardEventHandler$animHandler$2(this));
    }

    public final boolean d() {
        if (g().z().getImeState().b().isEnterOrShow() == false) goto L11;
        BasicKeyboard r0 = g();
        View r1 = r0.l().getContext().getCurrentFocus();
        if (r1 != null) goto L7;
        boolean r2 = false;
    L8:
        if (r2 == true) goto L11;
        return false;
    L7:
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.keyboard.keyboard2.BasicKeyboard");
        r2 = Intrinsics.areEqual(r1, r0.b.findFocus());
    L11:
        return c();
    }

    public final void e(int r4) {
        BasicKeyboard r0 = g();
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if ((r0 instanceof BasicKeyboard) == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L11;
        p(0);
        return;
    L11:
        p(r4);
        return;
    L5:
        if (r0.b.getVisibility() != 0) goto L7;
        r1 = true;
        goto L8
    }

    public final void i(final com.ss.android.lark.keyboard.event.a r20) {
        if (r20.a != r20.b) goto L6;
        return;
    L6:
        if (d() == true) goto L9;
        e(r20.b);
        return;
    L9:
        boolean r8 = true;
        if (j() == true) goto L18;
        d r1 = (d) this.a.getValue();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r20, "animateHeightChange");
        MessageListAnimationContainer r2 = (MessageListAnimationContainer) r1.a.invoke();
        if (r2 == null) goto L29;
        int r3 = r20.a;
        int r4 = r20.b;
        int r5 = Math.min(r3, r4);
        Animator r6 = r1.f;
        if (r6 == null) goto L17;
        r6.cancel();
    L17:
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{1000.0f});
        r7.setDuration(r20.c);
        r7.setInterpolator(r20.d);
        r1.b.invoke(Integer.valueOf(r5));
        Ref.BooleanRef r9 = new Ref.BooleanRef();
        Intrinsics.checkNotNull(r7);
        r7.addListener(new e(r9));
        r7.addListener(new g(r1));
        r7.addListener(new f(r1, r9, r4));
        r1.d = true;
        OneShotPreDrawListener.add(r2, new k(r2, r1, r7));
        r1.f = r7;
    L30:
        if (r7 != null) goto L32;
        return;
    L32:
        Function0<Unit> r10 = new ChatKeyboardEventHandler$handleAnimateHeightChange$invokeScroll$1(this);
        if (r20.b > r20.a) goto L36;
        r8 = false;
    L36:
        if (r8 == true) goto L38;
        r7.addListener(new c(r10));
        return;
    L38:
        if (j() == false) goto L40;
        r10.invoke();
    L40:
        r7.addListener(new b(r10));
        return;
    L29:
        r7 = null;
        goto L30
    L18:
        final d r15 = (d) this.a.getValue();
        r15.getClass();
        Intrinsics.checkNotNullParameter(r20, "animateHeightChange");
        int r11 = r20.a;
        final int r12 = r20.b;
        final MessageListAnimationContainer r14 = (MessageListAnimationContainer) r15.a.invoke();
        if (r14 == null) goto L29;
        final int r13 = r14.getHeight();
        final int r16 = (r13 - r12) + r11;
        if (r13 <= 0) goto L29;
        if (r16 <= 0) goto L29;
        Animator r17 = r15.f;
        if (r17 == null) goto L28;
        r17.cancel();
    L28:
        final int r18 = Math.min(r11, r12);
        final Ref.BooleanRef r19 = new Ref.BooleanRef();
        Function1<Animator, Unit> r110 = new MessageListKeyboardAnimHandler$animateMessageList$animator$1(r20, r15, r18, r19, r12);
        final RecyclerView r21 = r14.findViewWithTag(SceneCoordinateRecyclerView.class);
        final int r22 = Math.max(r13, r16);
        r7 = ValueAnimator.ofFloat(new float[]{1000.0f});
        Function1<Float, Unit> r23 = new MessageListKeyboardAnimHandler$prepareAnimator$1$animUpdateAction$1(r13, r16, r22, r14, r21, r15);
        Intrinsics.checkNotNull(r7);
        r7.addListener(new j(r13, r16, r14, r15, r21, r23));
        r7.addListener(new i(r14, r21));
        r7.addUpdateListener(new h(r23));
        r110.invoke(r7);
        r15.d = true;
        OneShotPreDrawListener.add(r14, new k(r14, r15, r7));
        r15.f = r7;
        goto L30
    }

    public void p(int r3) {
        Log.i("ChatKeyboardEventHandle", "onSetMessageListMargin: " + r3);
    }

    public final void s(cya.h r7) {
        String r0 = null;
        if (r7 == null) goto L5;
        Integer r1 = Integer.valueOf(r7.a());
    L6:
        boolean r2 = false;
        if (r1 != null) goto L10;
    L23:
        if (r1 != null) goto L26;
    L27:
        if (r1 != null) goto L30;
    L32:
        if (r1 != null) goto L35;
    L37:
        if (r1 != null) goto L40;
        return;
    L40:
        if (r1.intValue() != 16) goto L58;
        n();
        return;
    L58:
        return;
    L35:
        if (r1.intValue() != 1) goto L37;
        n();
        return;
    L30:
        if (r1.intValue() != 8) goto L32;
    L43:
        if (h() == false) goto L54;
        cya.i r8 = (cya.i) r7.a.a(cya.i.h);
        if (r8 == null) goto L47;
        r0 = r8.a;
    L47:
        if (r0 != null) goto L49;
    L50:
        r2 = true;
    L51:
        if (r2 == false) goto L53;
        n();
        return;
    L53:
        o(r0);
        return;
    L49:
        if (r0.length() != 0) goto L51;
    L54:
        n();
        return;
    L26:
        if (r1.intValue() == 2) goto L43;
    L10:
        if (r1.intValue() != 4) goto L23;
        ReEditInfo r3 = (ReEditInfo) r7.a.a(ReEditInfo.Companion);
        if (r3 == null) goto L15;
        String r4 = r3.getMessageId();
        if (r4 == null) goto L15;
    L17:
        if (r4.length() != 0) goto L19;
        r2 = true;
    L19:
        if (r2 == false) goto L21;
        n();
    L22:
        u(r7);
        return;
    L21:
        o(r4);
    L15:
        r4 = BuildConfig.FLAVOR;
        goto L17
    L5:
        r1 = null;
        goto L6
    }

    public final void t(com.ss.android.lark.keyboard.event.k r2) {
        Intrinsics.checkNotNullParameter(r2, "eventCenter");
        r2.of(this).a();
    }

    public final void u(cya.h r8) {
        ReEditInfo r9 = (ReEditInfo) r8.a.a(ReEditInfo.Companion);
        String r0 = BuildConfig.FLAVOR;
        if (r9 == null) goto L6;
        String r10 = r9.getMessageId();
        if (r10 == null) goto L6;
    L7:
        m2b.a r1 = r();
        if (r1 == null) goto L13;
        String r2 = r1.D8();
        if (r2 == null) goto L13;
        r0 = r2;
    L13:
        if (r1 == null) goto L15;
        r1.z8(r10);
    L15:
        Set<RichTextElement.RichTextTag> r3 = x.a;
        String[] r4 = {r0, r10};
        Intrinsics.checkNotNullParameter(r4, "msgIds");
        ArrayList r11 = new ArrayList();
        int r5 = 0;
    L16:
        if (r5 >= 2) goto L24;
        String r6 = r4[r5];
        if (r6.length() <= 0) goto L20;
        boolean r7 = true;
    L21:
        if (r7 == false) goto L23;
        r11.add(r6);
    L23:
        r5 = r5 + 1;
        goto L16
    L20:
        r7 = false;
        goto L21
    L24:
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r13 = r11.iterator();
    L26:
        if (r13.hasNext() == false) goto L28;
        r12.add(new y((String) r13.next()));
        goto L26
    L28:
        Log.i("ChatKeyboardEventHandle", "onStateChanged: updateMsgs size " + r12.size());
        if ((!r12.isEmpty()) == false) goto L36;
        q(r12);
        return;
    L36:
        return;
    L6:
        r10 = BuildConfig.FLAVOR;
        goto L7
    }

    public static final boolean b(ChatKeyboardEventHandler r3, com.ss.android.lark.keyboard.b r4) {
        d r0 = (d) r3.a.getValue();
        boolean r1 = r0.c;
        if ((r0.d | r1) == false) goto L6;
        return true;
    L6:
        if (r3.d() == false) goto L21;
        com.ss.android.lark.keyboard.ime.a r5 = r4.z();
        if (r5.y() == false) goto L11;
    L13:
        boolean r6 = false;
    L15:
        if (r3.j() == true) goto L18;
        if (r6 == false) goto L18;
        return true;
    L18:
        return false;
    L11:
        if (r5.B() == true) goto L13;
        r6 = true;
        goto L15
    L21:
        return true;
    }

    @Override // j2b.a
    public final void a(com.ss.android.lark.keyboard.b r2, com.ss.android.lark.keyboard.event.k r3) {
        Intrinsics.checkNotNullParameter(r2, "keyboard");
        Intrinsics.checkNotNullParameter(r3, "eventCenter");
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
        l r4 = r3.of(this);
        r4.b(new ChatKeyboardEventHandler$bind$1$1(this));
        r4.b(new ChatKeyboardEventHandler$bind$1$2(this));
        r4.b(new ChatKeyboardEventHandler$bind$1$3(this));
        r4.c(k2b.a.class, new ChatKeyboardEventHandler$bind$1$4(this));
        r4.c(q.class, new ChatKeyboardEventHandler$bind$1$5(this));
        r4.c(com.ss.android.lark.keyboard.event.a.class, new ChatKeyboardEventHandler$bind$1$6(this));
        r4.d(InputSupportType.class, new ChatKeyboardEventHandler$bind$1$7(this));
        r4.c(HeightChange.class, new ChatKeyboardEventHandler$bind$1$8(this));
        r4.d(cya.h.class, new ChatKeyboardEventHandler$bind$1$9(this));
        r4.d(ImeState.class, new ChatKeyboardEventHandler$bind$1$10(this));
    }
}
