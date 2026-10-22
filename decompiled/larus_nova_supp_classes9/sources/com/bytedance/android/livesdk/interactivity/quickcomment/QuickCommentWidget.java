package com.bytedance.android.livesdk.interactivity.quickcomment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdk.interactivity.api.quickcomment.IQuickCommentShowWord;
import com.bytedance.android.livesdk.interactivity.api.quickcomment.event.BackRoomViewState;
import com.bytedance.android.livesdk.interactivity.common.business.quickcomment.QuickCommentView;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdkapi.depend.live.vs.listener.IVsVideoListManager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import zg1.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/quickcomment/QuickCommentWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/bytedance/android/livesdk/interactivity/quickcomment/a;", "Llh1/a;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class QuickCommentWidget extends MiddlewareRoomRecyclableWidget implements com.bytedance.android.livesdk.interactivity.quickcomment.a, lh1.a {
    public static final int h = 0;
    public static final int i = 0;
    public QuickCommentView a;
    public Animator b;
    public Animator c;
    public Animator d;
    public final AnimStateMachine e;
    public CompositeDisposable f;
    public boolean g;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ QuickCommentWidget a;

        public b(QuickCommentWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            QuickCommentWidget r0 = this.a;
            int r1 = QuickCommentWidget.h;
            r0.zq((List) r3);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ QuickCommentWidget a;

        public c(QuickCommentWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            i1 r4 = (i1) r3;
            QuickCommentView r0 = this.a.a;
            if (r0 == null) goto L15;
            QuickCommentView.b r1 = r0.b;
            if (r1 != null) goto L7;
        L9:
            boolean r2 = false;
        L10:
            if (r2 == true) goto L12;
            return;
        L12:
            if (r4.b == false) goto L17;
            this.a.e.a(new AnimStateMachine.a.c());
            return;
        L17:
            return;
        L7:
            if (r1.getItemCount() <= 0) goto L9;
            r2 = true;
            goto L10
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ QuickCommentWidget a;

        public d(QuickCommentWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            QuickCommentView r0 = this.a.a;
            if (r0 == null) goto L15;
            QuickCommentView.b r1 = r0.b;
            if (r1 != null) goto L7;
        L9:
            boolean r2 = false;
        L10:
            if (r2 == true) goto L12;
            return;
        L12:
            if (r4.booleanValue() == true) goto L17;
            this.a.e.a(new AnimStateMachine.a.d());
            return;
        L17:
            return;
        L7:
            if (r1.getItemCount() <= 0) goto L9;
            r2 = true;
            goto L10
        }
    }

    public static final class e implements QuickCommentView.a {
        public final /* synthetic */ QuickCommentWidget a;

        @Override // com.bytedance.android.livesdk.interactivity.common.business.quickcomment.QuickCommentView.a
        public final void a(QuickCommentView r1) {
        }

        public e(QuickCommentWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.common.business.quickcomment.QuickCommentView.a
        public final void b(IQuickCommentShowWord r5) {
            Intrinsics.checkNotNullParameter(r5, "content");
            QuickCommentWidget r0 = this.a;
            int r1 = QuickCommentWidget.h;
            r0.getClass();
            StringBuilder r2 = new StringBuilder("handleSendQuickComment isDisableChat:");
            r2.append(r0.Bq());
            r2.append(" isBannedTalk");
            r2.append(r0.Aq());
            r2.append(" isUnLogin");
            r2.append(!k.n(IMiddlewareUserService.class).user().isLogin());
            com.bytedance.android.livesdk.interactivity.quickcomment.b.a(r2.toString());
            if (r0.Bq() == false) goto L6;
            return;
        L6:
            if (r0.Aq() == false) goto L9;
            return;
        L9:
            if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r0).dataCenter).F0(PaidInteractEntry.CONTROL_ENTRY_COMMENT) == true) goto L12;
            return;
        L12:
            if ((!k.n(IMiddlewareUserService.class).user().isLogin()) == false) goto L14;
            Bundle r6 = new Bundle();
            com.bytedance.android.livesdk.user.e r3 = k.n(IMiddlewareUserService.class).user();
            Context r4 = r0.getContext();
            l.a r7 = new l.a();
            r7.h = r6;
            r7.e = BuildConfig.FLAVOR;
            r7.a = s1.B(2131915990);
            r7.d = "comment_live";
            r7.c = -1;
            r0.wq(r3.login(r4, new l(r7)).subscribe(new com.bytedance.android.livesdk.interactivity.quickcomment.g(r0), com.bytedance.android.livesdk.interactivity.quickcomment.h.a));
            return;
        L14:
            com.bytedance.android.livesdk.interactivity.api.quickcomment.f r8 = r0.xq();
            if (r8 == null) goto L19;
            r8.sendQuickComment(r5);
            return;
        }
    }

    public static final class f implements Action {
        public final /* synthetic */ QuickCommentWidget a;

        public f(QuickCommentWidget r1) {
            this.a = r1;
        }

        public final void run() {
            QuickCommentView r0 = this.a.a;
            if (r0 == null) goto L6;
            r0.setListener(null);
            return;
        }
    }

    public static final class g extends AnimatorListenerAdapter {
        public final /* synthetic */ QuickCommentView a;
        public final /* synthetic */ QuickCommentWidget b;
        public final /* synthetic */ int c;
        public final /* synthetic */ BackRoomViewState d;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            ViewGroup.LayoutParams r4 = this.a.getLayoutParams();
            if (r4 == null) goto L11;
            r4.width = this.c;
            this.a.setLayoutParams(r4);
            QuickCommentWidget r5 = this.b;
            if (this.d.a != BackRoomViewState.ChangeType.GONE) goto L7;
            boolean r0 = true;
        L8:
            r5.g = r0;
            return;
        L7:
            r0 = false;
            goto L8
        L11:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }

        public g(QuickCommentView r1, QuickCommentWidget r2, int r3, BackRoomViewState r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public final class h implements Consumer {
        public final /* synthetic */ Function1 a;

        public h(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.quickcomment.QuickCommentWidget$onLoad$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lo52/a;", "p1", BuildConfig.FLAVOR, "invoke", "(Lo52/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<o52.a, Unit> {
        public AnonymousClass5(QuickCommentWidget r8) {
            super(1, r8, QuickCommentWidget.class, "onBackRoomViewChangeEvent", "onBackRoomViewChangeEvent(Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/event/BackRoomViewChangeEvent;)V", 0);
        }

        public final void invoke(o52.a r5) {
            QuickCommentWidget r0 = (QuickCommentWidget) ((CallableReference) this).receiver;
            int r1 = QuickCommentWidget.h;
            r0.getClass();
            if (r5 == null) goto L7;
            r0.Cq(r5.a, r5.b);
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((o52.a) r1);
            return Unit.INSTANCE;
        }
    }

    public final int getLayoutId() {
        return 2131567398;
    }

    static {
        h = s1.f(36.0f);
        i = s1.f(12.0f);
    }

    @Override // com.bytedance.android.livesdk.interactivity.quickcomment.a
    public final void Ei() {
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L11;
        Animator r1 = this.b;
        if (r1 == null) goto L7;
        r1.end();
    L7:
        Animator r2 = this.c;
        if (r2 == null) goto L10;
        r2.end();
    L10:
        r0.setVisibility(8);
        ViewGroup.LayoutParams r3 = r0.getLayoutParams();
        r3.height = h;
    L11:
        yq();
    }

    @Override // com.bytedance.android.livesdk.interactivity.quickcomment.a
    public final void G6() {
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L12;
        Animator r1 = this.b;
        if (r1 == null) goto L7;
        r1.cancel();
    L7:
        Animator r2 = this.c;
        if (r2 == null) goto L10;
        r2.start();
    L10:
        r0.setVisibility(0);
        ViewGroup.LayoutParams r3 = r0.getLayoutParams();
        r3.height = h;
        return;
    }

    public final boolean Ki() {
        QuickCommentView r0 = this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.d;
    }

    @Override // com.bytedance.android.livesdk.interactivity.quickcomment.a
    public final void O9() {
        com.bytedance.android.livesdk.interactivity.api.h r0 = i.a(((MiddlewareRoomRecyclableWidget) this).dataContext, ((Widget) this).dataCenter);
        if (r0 == null) goto L9;
        n<BackRoomViewState> r1 = r0.getBackRoomViewState();
        if (r1 == null) goto L9;
        BackRoomViewState r2 = (BackRoomViewState) r1.getValue();
        if (r2 == null) goto L9;
        Cq(r2, 0);
    L9:
        View r3 = ((Widget) this).contentView;
        if (r3 == null) goto L19;
        Animator r4 = this.c;
        if (r4 == null) goto L14;
        r4.end();
    L14:
        Animator r5 = this.b;
        if (r5 == null) goto L17;
        r5.start();
    L17:
        r3.setVisibility(0);
        ViewGroup.LayoutParams r6 = r3.getLayoutParams();
        r6.height = h;
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.quickcomment.a
    public final void b9() {
        com.bytedance.android.livesdk.interactivity.api.h r0 = i.a(((MiddlewareRoomRecyclableWidget) this).dataContext, ((Widget) this).dataCenter);
        if (r0 == null) goto L9;
        n<BackRoomViewState> r1 = r0.getBackRoomViewState();
        if (r1 == null) goto L9;
        BackRoomViewState r2 = (BackRoomViewState) r1.getValue();
        if (r2 == null) goto L9;
        Cq(r2, 0);
    L9:
        View r3 = ((Widget) this).contentView;
        if (r3 == null) goto L18;
        Animator r4 = this.b;
        if (r4 == null) goto L14;
        r4.end();
    L14:
        Animator r5 = this.c;
        if (r5 == null) goto L17;
        r5.end();
    L17:
        r3.setVisibility(0);
        ViewGroup.LayoutParams r6 = r3.getLayoutParams();
        r6.height = h;
    L18:
        yq();
    }

    public final void onUnload() {
        Animator r0 = this.b;
        if (r0 == null) goto L5;
        r0.end();
    L5:
        Animator r1 = this.c;
        if (r1 == null) goto L8;
        r1.end();
    L8:
        Animator r2 = this.d;
        if (r2 == null) goto L11;
        r2.end();
    L11:
        CompositeDisposable r3 = this.f;
        if (r3 == null) goto L15;
        r3.dispose();
    L15:
        if (this.g == false) goto L24;
        QuickCommentView r4 = this.a;
        if (r4 == null) goto L24;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L23;
        r4.setTranslationX(0.0f);
        r4.setLayoutParams(r5);
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L24:
        IRoomContextService r6 = getRoomContextService();
        if (r6 == null) goto L34;
        o r7 = IRoomContextService.a.a(r6, ((Widget) this).dataCenter, 0, 2);
        if (r7 == null) goto L35;
        n r8 = r7.Z1();
        if (r8 == null) goto L36;
        lh1.b r9 = (lh1.b) r8.getValue();
        if (r9 == null) goto L37;
        r9.g(this);
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    }

    public final void yq() {
        QuickCommentView r0 = this.a;
        if (r0 == null) goto L25;
        IRoomContextService r1 = getRoomContextService();
        IVsVideoListManager r5 = null;
        if (r1 == null) goto L11;
        o r2 = IRoomContextService.a.a(r1, ((Widget) this).dataCenter, 0, 2);
        if (r2 == null) goto L11;
        j r3 = r2.u1();
        if (r3 == null) goto L11;
        IVsVideoListManager r4 = (IVsVideoListManager) r3.getValue();
    L13:
        if ((r4 instanceof IVsVideoListManager) == false) goto L26;
        int[] r6 = new int[2];
        r0.getLocationOnScreen(r6);
        ALogger.d("QuickCommentView", "quickComment`s location is :" + r6[0] + ' ' + r6[1]);
        IRoomContextService r7 = getRoomContextService();
        if (r7 == null) goto L21;
        o r8 = IRoomContextService.a.a(r7, ((Widget) this).dataCenter, 0, 2);
        if (r8 == null) goto L21;
        j r9 = r8.u1();
        if (r9 == null) goto L21;
        r5 = (IVsVideoListManager) r9.getValue();
    L21:
        if (r5 == null) goto L24;
        r5.onLeftSlideSafeArea("QuickCommentView", r6);
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.live.vs.listener.IVsVideoListManager");
    L26:
        return;
    L11:
        r4 = null;
        goto L13
    }

    public QuickCommentWidget() {
        this.e = new AnimStateMachine(this);
    }

    public final boolean Aq() {
        com.bytedance.android.livesdk.interactivity.api.h r0 = i.a(getRoomContext(), ((Widget) this).dataCenter);
        if (r0 == null) goto L9;
        m<Boolean> r1 = r0.isUserBannedTalk();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        return r2.booleanValue();
    L9:
        return false;
    }

    public final boolean Bq() {
        IRoomContextService r0 = getRoomContextService();
        if (r0 == null) goto L15;
        o r1 = IRoomContextService.a.a(r0, ((Widget) this).dataCenter, 0, 2);
        if (r1 == null) goto L15;
        m r2 = r1.getRoom();
        if (r2 == null) goto L15;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L15;
        IRoomAuthStatus r4 = r3.getRoomAuthStatus();
        if (r4 == null) goto L15;
        if (r4.getEnableChat() == true) goto L15;
        return true;
    L15:
        return false;
    }

    public final com.bytedance.android.livesdk.interactivity.api.quickcomment.f xq() {
        com.bytedance.android.livesdk.interactivity.api.h r0 = i.a(getRoomContext(), ((Widget) this).dataCenter);
        if (r0 == null) goto L7;
        j<com.bytedance.android.livesdk.interactivity.api.quickcomment.f> r1 = r0.getQuickCommentManager();
        if (r1 == null) goto L7;
        return (com.bytedance.android.livesdk.interactivity.api.quickcomment.f) r1.getValue();
    L7:
        return null;
    }

    public final void onInit(Object[] r2) {
        this.a = (QuickCommentView) ((Widget) this).contentView.findViewById(2131392578);
    }

    public final void onLoad(Object[] r9) {
        this.f = new CompositeDisposable();
        wq(xs2.b.a().b(i1.class).subscribe(new c(this)));
        IRoomContextService r10 = getRoomContextService();
        if (r10 == null) goto L13;
        o r11 = IRoomContextService.a.a(r10, ((Widget) this).dataCenter, 0, 2);
        if (r11 == null) goto L13;
        m r13 = r11.D1();
        if (r13 == null) goto L13;
        Observable r14 = r13.a();
        if (r14 == null) goto L13;
        Disposable r15 = r14.subscribe(new d(this));
        if (r15 == null) goto L13;
        wq(r15);
    L13:
        QuickCommentView r16 = this.a;
        if (r16 == null) goto L16;
        r16.setListener(new e(this));
    L16:
        wq(Disposables.fromAction(new f(this)));
        this.e.a(new AnimStateMachine.a.c());
        com.bytedance.android.livesdk.interactivity.api.h r17 = i.a(((MiddlewareRoomRecyclableWidget) this).dataContext, ((Widget) this).dataCenter);
        if (r17 == null) goto L27;
        com.bytedance.live.datacontext.k<o52.a> r18 = r17.getBackRoomChanged();
        if (r18 == null) goto L27;
        PublishSubject r19 = r18.onEvent();
        if (r19 == null) goto L27;
        Disposable r20 = r19.subscribe(new h(new AnonymousClass5(this)));
        if (r20 == null) goto L27;
        CompositeDisposable r3 = this.f;
        if (r3 == null) goto L27;
        r3.add(r20);
    L27:
        com.bytedance.android.livesdk.interactivity.api.quickcomment.f r21 = xq();
        if (r21 == null) goto L35;
        com.bytedance.android.live.core.arch.mvvm.d<List<IQuickCommentShowWord>> r23 = r21.getQuickComment();
        if (r23 == null) goto L35;
        Disposable r4 = r23.subscribe(new b(this));
        if (r4 == null) goto L34;
        wq(r4);
    L34:
        zq((List) r23.getValue());
    L35:
        View r24 = ((Widget) this).contentView;
        long r5 = n52.b.c;
        int r6 = h;
        ValueAnimator r7 = ObjectAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r7.setDuration(r5);
        r7.addUpdateListener(new com.bytedance.android.livesdk.interactivity.quickcomment.f(r7, r24, r6));
        com.bytedance.android.live.core.utils.h.a(r7, new QuickCommentWidget$initAnim$1(this));
        this.b = r7;
        View r25 = ((Widget) this).contentView;
        ValueAnimator r8 = ObjectAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r8.setDuration(r5);
        r8.addUpdateListener(new com.bytedance.android.livesdk.interactivity.quickcomment.e(r8, r25, r6));
        com.bytedance.android.live.core.utils.h.a(r8, new QuickCommentWidget$initAnim$2(this));
        this.c = r8;
        IRoomContextService r26 = getRoomContextService();
        if (r26 == null) goto L45;
        o r27 = IRoomContextService.a.a(r26, ((Widget) this).dataCenter, 0, 2);
        if (r27 == null) goto L46;
        n r28 = r27.Z1();
        if (r28 == null) goto L47;
        lh1.b r29 = (lh1.b) r28.getValue();
        if (r29 == null) goto L48;
        r29.b(this);
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    }

    public final Boolean wq(Disposable r2) {
        CompositeDisposable r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r0.add(r2));
    }

    public final void zq(List<? extends IQuickCommentShowWord> r7) {
        ALogger.i("QuickComment_Preload", "quick comment  size" + r7.size() + "   dataCenter" + ((Widget) this).dataCenter.hashCode() + " widget : " + hashCode());
        com.bytedance.android.livesdk.interactivity.quickcomment.b.a("handleQuickCommentChanged");
        QuickCommentView r0 = this.a;
        if (r0 == null) goto L5;
        r0.setQuickComment(r7);
    L5:
        AnimStateMachine r8 = this.e;
        IRoomContextService r1 = getRoomContextService();
        boolean r2 = false;
        if (r1 == null) goto L14;
        o r3 = IRoomContextService.a.a(r1, ((Widget) this).dataCenter, 0, 2);
        if (r3 == null) goto L14;
        m r4 = r3.D1();
        if (r4 == null) goto L14;
        Boolean r5 = (Boolean) r4.getValue();
        if (r5 == null) goto L14;
        boolean r6 = r5.booleanValue();
    L15:
        if (r6 == true) goto L26;
        QuickCommentView r9 = this.a;
        if (r9 == null) goto L23;
        QuickCommentView.b r10 = r9.b;
        if (r10 == null) goto L23;
        if (r10.getItemCount() <= 0) goto L23;
        boolean r11 = true;
    L24:
        if (r11 == false) goto L26;
        r2 = true;
    L23:
        r11 = false;
    L26:
        if (r2 == false) goto L28;
        AnimStateMachine.a r13 = new AnimStateMachine.a.b();
    L29:
        r8.a(r13);
        return;
    L28:
        r13 = new AnimStateMachine.a.C0212a();
    L14:
        r6 = false;
        goto L15
    }

    public final void Cq(BackRoomViewState r7, long r8) {
        ViewGroup r0 = ((Widget) this).containerView;
        if (r0 != null) goto L5;
        return;
    L5:
        BackRoomViewState.ChangeType r1 = r7.a;
        BackRoomViewState.ChangeType r2 = BackRoomViewState.ChangeType.GONE;
        if (r1 != r2) goto L8;
        float r4 = 0.0f;
    L9:
        if (r1 != r2) goto L11;
        int r3 = r0.getWidth();
    L12:
        QuickCommentView r5 = this.a;
        if (r5 == null) goto L16;
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r5, "translationX", new float[]{r4});
        r6.setDuration(r8);
        r6.addListener(new g(r5, this, r3, r7));
        r6.start();
        Unit r9 = Unit.INSTANCE;
        this.d = r6;
        return;
    L16:
        return;
    L11:
        r3 = r0.getWidth() - ((int) ((r7.b + 6.0f) - i));
        goto L12
    L8:
        r4 = (r7.b + 6.0f) - i;
        goto L9
    }
}
