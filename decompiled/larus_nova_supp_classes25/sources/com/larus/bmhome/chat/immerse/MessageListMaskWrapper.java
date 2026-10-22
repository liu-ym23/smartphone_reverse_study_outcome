package com.larus.bmhome.chat.immerse;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.api.b0$a;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.ChatTitleAlignLeftStyle;
import com.larus.common_ui.widget.concat_adapter.ConcatAdapter;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.utils.SafeExtKt;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MessageListMaskWrapper {
    public final ChatFragment a;
    public final LarusPageChatBinding b;
    public final com.larus.platform.api.g0 c;
    public int d;
    public final Integer e;
    public final boolean f;
    public final String g;
    public int h;
    public int i;
    public int j;
    public int k;
    public Boolean l;
    public int m;
    public float n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public int u;
    public com.larus.bmhome.chat.component.immerse.m v;
    public final g1 w;
    public final Lazy x;
    public final Lazy y;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {
        public final /* synthetic */ Function0 a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r1) {
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
        public final void onAnimationCancel(Animator r1) {
            this.a.invoke();
        }
    }

    public static final class c implements Animator.AnimatorListener {
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

        public c(Function0 r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r1) {
            this.a.invoke();
        }
    }

    static {
    }

    public final void c() {
        Integer r0 = this.e;
        if (r0 != null) goto L6;
    L8:
        SafeExtKt.c(this.a, new b1(this), 0);
    L9:
        FLogger.a.d(this.g, "firstInitImmerse, immerseHeight=" + this.k + ", listHeight=" + this.h);
        this.l = Boolean.TRUE;
        a(this.k);
        return;
    L6:
        if (r0.intValue() != 1) goto L8;
        this.k = this.h - e().a;
        FLogger.a.d(this.g, "firstInitImmerse orientation vertical immerseHeight= " + this.k);
        d();
        this.a.MQ(true);
        SafeExtKt.c(this.a, new z0(this), 500);
        p();
        goto L9
    }

    public final void d() {
        FLogger r0 = FLogger.a;
        r0.w(this.g, "fitLastSelfMessageOutOfScreen");
        final ChatMessageList r2 = this.b.n;
        RecyclerView.OnScrollListener r1 = new MessageListMaskWrapper$fitLastSelfMessageOutOfScreen$lambda$48$$inlined$doOnNextSmoothScrollEnd$1(this, r2, this);
        this.b.n.addOnScrollListener(r1);
        r0.d(this.g, "doOnNextSmoothScrollEnd, addOnScrollListener");
        r0.w(this.g, "fitLastSelfMessageOutOfScreen, scrollToLatest");
        b0$a.a(r2, false, 0, null, null, 0, 31);
    }

    public final l0 e() {
        ChatMessageList r0 = this.b.n;
        LinearLayoutManager r1 = r0.getLayoutManager();
        List<Message> r3 = null;
        if ((r1 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r2 = r1;
    L6:
        int r4 = 0;
        int r5 = -1;
        if (r2 == null) goto L78;
        z2 r6 = z2.a;
        if (r6.enableChatWithTab() == false) goto L13;
        if (r6.enableShowDisclaimer() == false) goto L13;
    L14:
        ConcatAdapter r7 = r0.getAdapter();
        if ((r7 instanceof ConcatAdapter) == false) goto L17;
        ConcatAdapter r8 = r7;
    L18:
        if (r8 == null) goto L22;
        List r9 = r8.getAdapters();
        if (r9 == null) goto L22;
        RecyclerView.Adapter r10 = (RecyclerView.Adapter) ListProtector.get(r9, 0);
    L24:
        if ((r10 instanceof MessageAdapter) == false) goto L26;
        MessageAdapter r11 = (MessageAdapter) r10;
    L27:
        if (r11 != null) goto L34;
    L35:
        if (r3 == null) goto L37;
        int r12 = r3.size();
    L38:
        int r13 = r2.findFirstVisibleItemPosition();
        int r14 = r2.findLastCompletelyVisibleItemPosition();
        boolean r15 = true;
        if (r3 == null) goto L52;
        Iterator<Message> r16 = r3.iterator();
        int r17 = 0;
    L42:
        if (r16.hasNext() == false) goto L52;
        Message r18 = r16.next();
        if (com.larus.bmhome.chat.bean.d.G0(r18) == true) goto L46;
    L48:
        boolean r19 = false;
    L49:
        if (r19 == true) goto L50;
        r17 = r17 + 1;
        goto L42
    L50:
        r5 = r17;
        goto L52
    L46:
        if (com.larus.bmhome.social.userchat.model.b0.f(r18) == true) goto L48;
        r19 = true;
    L52:
        FLogger r20 = FLogger.a;
        r20.i(this.g, "LastRoundHeight, currentListSize = " + r12 + ", firstPosition=" + r13 + ", lastPosition=" + r14 + ", lastSelfMessageIndex=" + r5);
        if (r5 >= 0) goto L62;
        r20.w(this.g, "LastRoundHeight, has no self message");
        IntIterator r21 = new IntRange(0, r14).iterator();
        int r22 = 0;
    L56:
        if (r21.hasNext() == false) goto L60;
        int r23 = r21.nextInt();
        View r24 = r2.findViewByPosition(r23);
        if (r24 == null) goto L56;
        FLogger.a.i(this.g, "LastRoundHeight, position=" + r23 + ", measuredHeight = " + r24.getMeasuredHeight());
        r22 = r22 + (r24.getMeasuredHeight() + r0.getSpacing());
        goto L56
    L60:
        l(false);
    L61:
        r4 = r22;
        goto L78
    L62:
        l(true);
        if (r5 >= r13) goto L66;
        int r25 = r2.getHeight();
        r20.w(this.g, "LastRoundHeight, lastSelfMessage is before firstPosition");
    L65:
        r4 = r25;
        goto L78
    L66:
        if (r5 <= r14) goto L68;
        r20.w(this.g, "LastRoundHeight, lastSelfMessage is after lastPosition");
        r25 = r2.getHeight();
        goto L65
    L68:
        r20.w(this.g, "LastRoundHeight, lastSelfMessage in the middle");
        if (r2.findViewByPosition(0) != null) goto L71;
        r20.w(this.g, "LastRoundHeight, lastBotMessage miss");
        r4 = r2.getHeight();
    L79:
        FLogger.a.i(this.g, "LastRoundHeight = " + r4);
        return new l0(r4, r5, r15);
    L71:
        IntIterator r26 = new IntRange(0, r5).iterator();
        r22 = 0;
    L73:
        if (r26.hasNext() == false) goto L77;
        int r27 = r26.nextInt();
        View r28 = r2.findViewByPosition(r27);
        if (r28 == null) goto L73;
        FLogger.a.i(this.g, "LastRoundHeight, position=" + r27 + ", measuredHeight = " + r28.getMeasuredHeight());
        r22 = r22 + (r28.getMeasuredHeight() + r0.getSpacing());
        goto L73
    L77:
        FLogger.a.i(this.g, "LastRoundHeight, lastRoundConversationHeight=" + r22);
        goto L61
    L37:
        r12 = 0;
    L34:
        r3 = r11.getCurrentList();
        goto L35
    L26:
        r11 = null;
    L22:
        r10 = null;
        goto L24
    L17:
        r8 = null;
    L13:
        if (r6.enableBioInChatTop() != 0) goto L14;
        MessageAdapter r29 = r0.getAdapter();
        if ((r29 instanceof MessageAdapter) == false) goto L32;
        r11 = r29;
    L33:
        if (r11 == null) goto L35;
    L32:
        r11 = null;
    L78:
        r15 = false;
        goto L79
    L5:
        r2 = null;
        goto L6
    }

    public final void f() {
        FLogger r0 = FLogger.a;
        r0.d(this.g, "handlePrologue begin");
        ChatMessageList r1 = this.b.n;
        z2 r2 = z2.a;
        MessageAdapter r4 = null;
        int r5 = 0;
        if (r2.enableChatWithTab() == false) goto L7;
        if (r2.enableShowDisclaimer() == false) goto L7;
    L8:
        ConcatAdapter r3 = r1.getAdapter();
        if ((r3 instanceof ConcatAdapter) == false) goto L11;
        ConcatAdapter r6 = r3;
    L12:
        if (r6 == null) goto L16;
        List r7 = r6.getAdapters();
        if (r7 == null) goto L16;
        RecyclerView.Adapter r8 = (RecyclerView.Adapter) ListProtector.get(r7, 0);
    L18:
        if ((r8 instanceof MessageAdapter) == false) goto L23;
        r4 = (MessageAdapter) r8;
    L23:
        if (r4 == null) goto L25;
        int r9 = ((ArrayList) r4.getCurrentList()).size();
    L26:
        RecyclerView.Adapter r10 = r1.getAdapter();
        if (r10 == null) goto L29;
        int r11 = r10.getItemCount();
    L30:
        r0.d(this.g, "handlePrologue itemCount=" + r11 + " messsageCount=" + r9);
        if (this.m != 100) goto L34;
        r0.e(this.g, "handlePrologueAndRetry: failed when retry " + this.m);
        r1.setVisibility(0);
        return;
    L34:
        if (r9 != 0) goto L36;
    L78:
        g();
        return;
    L36:
        if (this.b.n.getFirstLayoutCompleted() == false) goto L78;
        Integer r12 = this.e;
        if (r12 != null) goto L42;
    L44:
        if (r4 == null) goto L56;
        int r13 = r4.getItemCount();
        int r14 = 0;
        int r15 = 0;
    L46:
        if (r14 >= r13) goto L57;
        int r16 = r4.getItemViewType(r14);
        if ((((xc8.b) CollectionsKt.getOrNull(r4.z2(), r14)) instanceof com.larus.bmhome.chat.list.cell.prompt.w0) == true) goto L55;
        if (r16 == 2) goto L55;
        if (r16 == 3) goto L55;
        if (r16 == 1) goto L55;
        r15 = r15 + 1;
    L55:
        r14 = r14 + 1;
    L57:
        FLogger r17 = FLogger.a;
        r17.d(this.g, "handlePrologue count=" + r15);
        if (r15 != 1) goto L76;
        r17.d(this.g, "handlePrologue: only prologue message");
        l(false);
        r1.setVisibility(0);
        int r18 = this.b.n.getChildCount();
        int r19 = 0;
    L60:
        if (r5 >= r18) goto L62;
        r19 = r19 + (this.b.n.getChildAt(r5).getHeight() + i5.h());
        r5 = r5 + 1;
        goto L60
    L62:
        int r20 = r19 - (this.h - this.k);
        FLogger r21 = FLogger.a;
        r21.d(this.g, "handlePrologue:  transY=" + r20 + ", c=" + r19 + ", i=" + this.k);
        if (r19 > 0) goto L66;
        g();
        return;
    L66:
        if (r20 <= 0) goto L75;
        Integer r22 = this.e;
        if (r22 != null) goto L71;
    L72:
        this.b.n.setTranslationY(r20 + this.n);
        RecyclerView.Adapter r23 = this.b.n.getAdapter();
        if (r23 == null) goto L87;
        r23.registerAdapterDataObserver(new MessageListMaskWrapper$handlePrologue$1(this));
        return;
    L87:
        return;
    L71:
        if (r22.intValue() != 1) goto L72;
    L75:
        r21.d(this.g, "handlePrologue: transY <=0");
        c();
        return;
    L76:
        r17.d(this.g, "handlePrologue: has multi message");
        l(true);
        c();
        return;
    L56:
        r15 = 0;
        goto L57
    L42:
        if (r12.intValue() != 1) goto L44;
        this.k = this.h - e().a;
        goto L44
    L29:
        r11 = 0;
        goto L30
    L25:
        r9 = 0;
    L16:
        r8 = null;
        goto L18
    L11:
        r6 = null;
    L7:
        if (r2.enableBioInChatTop() != 0) goto L8;
        RecyclerView.Adapter r24 = r1.getAdapter();
        if ((r24 instanceof MessageAdapter) == false) goto L23;
        r4 = (MessageAdapter) r24;
        goto L23
    }

    public final void g() {
        this.b.n.postDelayed(new a1(this), 100);
        this.m++;
        FLogger.a.d(this.g, "handlePrologueRetry prologueRetryCount=" + this.m);
    }

    public final boolean h() {
        if (((int) this.b.n.getTranslationY()) == ((int) this.n)) goto L5;
        return true;
    L5:
        return false;
    }

    public final void i() {
        this.h = this.b.n.getHeight();
        this.j = this.b.n.getWidth();
        this.n = this.b.n.getTranslationY();
        FLogger.a.d(this.g, "recordListLayoutInfo, listHeight=" + this.h + ", listWidth=" + this.j + ", srcListTranslationY=" + this.n);
    }

    public final void j() {
        FLogger.a.d(this.g, "renderInputBg");
        int r0 = k0.a;
        int r1 = k0.a(this.d, 0.4f, 0.15f);
        com.larus.bmhome.chat.component.list.b r2 = this.a.WF().getAbility(com.larus.bmhome.chat.component.list.b.class);
        if (r2 == null) goto L8;
        Intrinsics.checkNotNullParameter(r2, "$this$withChatBgAbility");
        ImageView r3 = r2.z00();
        if (r3 == null) goto L7;
        r3.setBackgroundColor(r1);
    L7:
        Unit r4 = Unit.INSTANCE;
    L8:
        GradientDrawable r5 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{r1, 0});
        r5.setGradientType(0);
        com.larus.bmhome.chat.component.list.b r6 = this.a.WF().getAbility(com.larus.bmhome.chat.component.list.b.class);
        if (r6 == null) goto L15;
        Intrinsics.checkNotNullParameter(r6, "$this$withChatBgAbility");
        ImageView r7 = r6.Nm();
        if (r7 == null) goto L13;
        r7.setBackground(r5);
    L13:
        Unit r8 = Unit.INSTANCE;
        return;
    }

    public final void k() {
        int r0 = (int) this.b.n.getTranslationY();
        int r1 = (int) this.n;
        FLogger.a.d(this.g, "restoreTranslation: startHeight=" + r0 + ", endH=" + r1 + ", immerseHeight=" + this.k);
        b(r0, r1, new n0(this), new y0(this));
    }

    public final void m() {
        FLogger r0 = FLogger.a;
        r0.d(this.g, "showFullChatList");
        this.a.MQ(false);
        r0.i(this.g, "removeChatMessageObserver");
        this.b.n.getViewTreeObserver().removeOnGlobalLayoutListener(this.w);
        this.p = false;
        SafeExtKt.c(this.a, new o0(this), 50);
    }

    public final void p() {
        if (this.p == false) goto L5;
        return;
    L5:
        FLogger.a.i(this.g, "watchOnChatMessageChange");
        this.b.n.getViewTreeObserver().addOnGlobalLayoutListener(this.w);
        this.p = true;
    }

    public final void a(int r6) {
        ChatMessageList r0 = this.b.n;
        r0.setTopPaddingOffsetForImmerse(r6);
        if (((Boolean) this.x.getValue()).booleanValue() == false) goto L5;
        int r1 = ((Number) this.y.getValue()).intValue();
    L6:
        int r2 = this.j;
        if (r2 != 0) goto L9;
        r2 = r0.getWidth();
    L9:
        if (r1 != 0) goto L11;
        r1 = r0.getHeight();
    L11:
        r0.setClipBounds(new Rect(0, r6, r2, r1));
        FLogger.a.d(this.g, "clipMessageList, clipBounds: " + r0.getClipBounds());
        r0.invalidate();
        u7 r7 = this.a.u3();
        if (r7 == null) goto L14;
        r7.U1();
    L14:
        com.larus.bmhome.chat.component.immerse.m r8 = this.v;
        if (r8 == null) goto L18;
        r8.onChange();
        return;
    L18:
        return;
    L5:
        r1 = this.i;
        goto L6
    }

    public final void l(boolean r6) {
        this.t = r6;
        Integer r0 = this.e;
        if (r0 == null) goto L8;
        boolean r2 = true;
        if (r0.intValue() != 1) goto L8;
    L9:
        ChatTitleAlignLeftStyle r1 = null;
        if (r2 == false) goto L18;
        FLogger.a.d(this.g, "setChatHistoryIconVisible = " + r6 + " in scrollVertical");
        com.larus.platform.api.g0 r3 = this.c;
        if ((r3 instanceof ChatTitleAlignLeftStyle) == false) goto L14;
        r1 = (ChatTitleAlignLeftStyle) r3;
    L14:
        if (r1 != null) goto L16;
        return;
    L16:
        if (z2.a.V1() == true) goto L25;
        r1.setShowHistory(r6);
        return;
    L25:
        return;
    L18:
        FLogger.a.d(this.g, "setChatHistoryIconVisible = false in scrollHorizontal");
        com.larus.platform.api.g0 r7 = this.c;
        if ((r7 instanceof ChatTitleAlignLeftStyle) == false) goto L21;
        r1 = (ChatTitleAlignLeftStyle) r7;
    L21:
        if (r1 == null) goto L27;
        r1.setShowHistory(false);
        return;
    L27:
        return;
    L8:
        r2 = false;
        goto L9
    }

    public final void n(final boolean r7) {
        if (this.k != 0) goto L7;
        FLogger.a.e(this.g, "showImmerse immerseHeight=0, listH =" + this.h);
        return;
    L7:
        if (Intrinsics.areEqual(Boolean.valueOf(r7), this.l) == false) goto L10;
        FLogger.a.d("MessageListMaskWrapper", "showImmerse: immerse=" + r7 + ", last=" + this.l);
        return;
    L10:
        boolean r0 = h();
        FLogger r1 = FLogger.a;
        r1.d(this.g, "showImmerse: shouldRevertTranslationY = " + r0);
        if (r0 == false) goto L13;
        k();
        return;
    L13:
        int r2 = 0;
        if (r7 == false) goto L16;
        int r3 = 0;
    L17:
        if (r7 == false) goto L19;
        r2 = this.k;
    L19:
        r1.d(this.g, "exeClipOperateAndAnim: isImmerse=" + r7 + ", startH=" + r3 + ", endH=" + r2);
        this.s = true;
        b(r3, r2, new d1(this), new e1(this, r7));
        return;
    L16:
        r3 = this.k;
        goto L17
    }

    public final void o(int r4) {
        this.k = r4;
        FLogger.a.d(this.g, "updateImmerseHeight immerseHeight=" + this.k);
    }

    public static void b(int r2, int r3, final Function1 r4, Function0 r5) {
        ValueAnimator r6 = ObjectAnimator.ofInt(new int[]{r2, r3}).setDuration(250);
        r6.addUpdateListener(new f1(r4));
        Intrinsics.checkNotNull(r6);
        r6.addListener(new c(r5));
        r6.addListener(new b(r5));
        r6.start();
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [com.larus.bmhome.chat.immerse.g1] */
    public MessageListMaskWrapper(ChatFragment r2, LarusPageChatBinding r3, com.larus.platform.api.g0 r4, int r5, Integer r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "binding");
        Intrinsics.checkNotNullParameter(r4, "title");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = "MessageListMaskWrapper-" + r2.hashCode();
        this.o = c7.b(50);
        z2 r8 = z2.a;
        if (r8.enableChatWithTab() == true) goto L5;
    L6:
        r8.enableBioInChatTop();
    L7:
        this.w = new g1(this);
        this.x = LazyKt.lazy(new h1());
        this.y = LazyKt.lazy(new i1());
        return;
    L5:
        if (r8.enableShowDisclaimer() == true) goto L7;
        goto L6
    }
}
