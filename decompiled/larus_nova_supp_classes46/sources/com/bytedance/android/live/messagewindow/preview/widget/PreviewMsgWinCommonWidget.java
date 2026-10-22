package com.bytedance.android.live.messagewindow.preview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.messagewindow.framework.context.CardContext;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.e;
import com.bytedance.android.live.room.api.messagewindow.monitor.f;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import d71.d;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/messagewindow/preview/widget/PreviewMsgWinCommonWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lw61/a;", "Lv61/a;", "<init>", "()V", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class PreviewMsgWinCommonWidget extends MiddlewareRoomRecyclableWidget implements w61.a<v61.a> {
    public final String a;
    public final Map<v61.a, a> b;
    public ViewGroup c;

    public static final class a {
        public View a;
        public WidgetElement b;

        public a(v61.a r2) {
            Intrinsics.checkNotNullParameter(r2, "cardWindow");
        }
    }

    public static final class b implements Animator.AnimatorListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ t61.c b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            Function0 r3 = this.b.c;
            if (r3 == null) goto L6;
            Unit r4 = (Unit) r3.invoke();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            Function0 r3 = this.b.b;
            if (r3 == null) goto L6;
            Unit r4 = (Unit) r3.invoke();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            Function0 r3 = this.b.d;
            if (r3 == null) goto L6;
            Unit r4 = (Unit) r3.invoke();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            Function0 r3 = this.b.a;
            if (r3 == null) goto L6;
            Unit r4 = (Unit) r3.invoke();
            return;
        }

        public b(View r1, t61.a r2, t61.c r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ t61.c b;

        public c(View r1, t61.a r2, t61.c r3) {
            this.a = r1;
            this.b = r3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            Function1 r0 = this.b.e;
            if (r0 == null) goto L6;
            Unit r3 = (Unit) r0.invoke(r2);
            return;
        }
    }

    public com.bytedance.android.live.messagewindow.business.util.a xq() {
        return null;
    }

    public final void Qg() {
        Set r0 = ((ConcurrentHashMap) this.b).keySet();
        if ((!r0.isEmpty()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L17;
        List r1 = CollectionsKt.toList(r0);
        if (r1 == null) goto L17;
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L17;
        v61.a r3 = (v61.a) r2.next();
        r3.dismiss();
        CardContext r4 = wq();
        if (r4 == null) goto L11;
        i r5 = r4.getMonitor();
        if (r5 == null) goto L11;
        CardAlogParamsBuilder r6 = new CardAlogParamsBuilder();
        r6.d(yq());
        r6.c("release window, " + r3.j);
        Unit r7 = Unit.INSTANCE;
        r5.d(r6.b());
    L17:
        ((ConcurrentHashMap) this.b).clear();
    }

    public final CardContext wq() {
        CardContext.a r0 = CardContext.Companion;
        DataCenter r1 = ((Widget) this).dataCenter;
        r0.getClass();
        com.bytedance.android.live.messagewindow.framework.context.c r2 = CardContext.a.a(r1);
        if ((r2 instanceof CardContext) == true) goto L6;
        r2 = null;
    L6:
        return (CardContext) r2;
    }

    public void zq() {
        Set r0 = ((ConcurrentHashMap) this.b).keySet();
        if ((!r0.isEmpty()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L31;
        List r1 = CollectionsKt.toList(r0);
        if (r1 == null) goto L31;
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L31;
        v61.a r3 = (v61.a) r2.next();
        if (r3.E() == true) goto L15;
        r3.dismiss();
        goto L11
    L15:
        if (r3.isShowing() == false) goto L11;
        CardContext r4 = wq();
        if (r4 == null) goto L21;
        d<v61.a, d71.b> r5 = r4.recordManager(r3.getPosition());
        if (r5 == null) goto L21;
        r5.r(r3);
    L21:
        CardContext r6 = wq();
        if (r6 == null) goto L11;
        d<v61.a, d71.b> r7 = r6.recordManager(r3.getPosition());
        if (r7 == null) goto L11;
        r7.j(r3);
        Unit r8 = Unit.INSTANCE;
        r3.n(ICardLifecycle.State.Stored);
        CardContext r9 = wq();
        if (r9 == null) goto L11;
        i r10 = r9.getMonitor();
        if (r10 == null) goto L11;
        CardAlogParamsBuilder r11 = new CardAlogParamsBuilder();
        r11.d(yq());
        r11.c("showing temporary card store, " + r3.j);
        r10.d(r11.b());
    L31:
        CardContext r12 = wq();
        if (r12 == null) goto L53;
        CompositeDisposable r13 = r12.getContainerCd();
        if (r13 == null) goto L54;
        r13.clear();
        return;
    L54:
        return;
    }

    public PreviewMsgWinCommonWidget() {
        this.a = "PreviewMsgWinCommonWidget";
        this.b = new ConcurrentHashMap();
    }

    public String yq() {
        return this.a;
    }

    public final void Fb(v61.a r6, Function0 r7) {
        Intrinsics.checkNotNullParameter(r6, "window");
        Intrinsics.checkNotNullParameter(r7, "finish");
        a r0 = (a) ((ConcurrentHashMap) this.b).get(r6);
        boolean r1 = true;
        if (r0 == null) goto L31;
        WidgetElement r3 = r0.b;
        if (r3 == null) goto L26;
        View r2 = r0.a;
        if (r2 == null) goto L10;
        r2.clearAnimation();
    L10:
        if (r3.m == null) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == true) goto L15;
        i r5 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r5 == null) goto L25;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r8 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_msgwindow_unloadwindow_fail");
        r8.c(new Pair[]{TuplesKt.to("card_id", r6.j)});
        Unit r9 = Unit.INSTANCE;
        r5.b(r8.a());
    L25:
        r7.invoke();
        return;
    L15:
        if ((this instanceof LiveTetris) == true) goto L17;
        PreviewMsgWinCommonWidget r10 = null;
    L18:
        LiveTetris r11 = (LiveTetris) r10;
        if (r11 == null) goto L31;
        r11.S(r3);
        goto L31
    L17:
        r10 = this;
        goto L18
    L12:
        r4 = false;
        goto L13
    L26:
        View r12 = r0.a;
        if (r12 == null) goto L31;
        r12.clearAnimation();
        ViewGroup r13 = UtilityKotlinExtentionsKt.p(r12);
        if (r13 == null) goto L31;
        r13.removeView(r12);
    L31:
        ((ConcurrentHashMap) this.b).remove(r6);
        if (r6.isShowing() == false) goto L34;
    L40:
        r6.n(ICardLifecycle.State.Hidden);
    L41:
        r6.n(ICardLifecycle.State.Destroyed);
        r7.invoke();
        return;
    L34:
        if (r6.E() == false) goto L41;
        if (r6.A() == ICardLifecycle.State.Stored) goto L39;
        r1 = false;
    L39:
        if (r1 == false) goto L41;
        goto L40
    }

    public final void pk(final v61.a r5, final Function0 r6) {
        Intrinsics.checkNotNullParameter(r5, "window");
        Intrinsics.checkNotNullParameter(r6, "finish");
        Intrinsics.checkNotNullParameter(r5, "window");
        if (((ConcurrentHashMap) this.b).get(r5) == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        f r1 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_container_loaded");
        i r2 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r2 == null) goto L10;
        r2.e(new e(r1));
    L10:
        Aq(r5, true, new PreviewMsgWinCommonWidget$loadWindow$1(r6));
        return;
    L11:
        ViewGroup r3 = this.c;
        if (r3 == null) goto L17;
        com.bytedance.android.live.messagewindow.business.util.a r4 = xq();
        if (r4 == null) goto L17;
        r4.d(((Widget) this).context, r3, r5, new PreviewMsgWinCommonWidget$loadWindow$$inlined$let$lambda$1(this, r5));
    L17:
        if (r5.isShowing() == true) goto L19;
        r5.n(ICardLifecycle.State.Showed);
    L19:
        r6.invoke();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void Aq(v61.a r2, boolean r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "window");
        Intrinsics.checkNotNullParameter(r4, "finish");
        a r0 = (a) ((ConcurrentHashMap) this.b).get(r2);
        if (r0 == null) goto L14;
        View r1 = r0.a;
        if (r1 == null) goto L14;
        r1.clearAnimation();
        UtilityKotlinExtentionsKt.z(r1, r3);
        if (r3 == false) goto L12;
        if (r2.isShowing() == true) goto L14;
        r2.n(ICardLifecycle.State.Showed);
        goto L14
    L12:
        if (r2.isShowing() == false) goto L14;
        r2.n(ICardLifecycle.State.Hidden);
    L14:
        r4.invoke();
    }

    public final void xl(v61.a r2, CardConstraint r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r2, "window");
        Intrinsics.checkNotNullParameter(r3, "constraint");
        Intrinsics.checkNotNullParameter(r4, "finish");
        a r5 = (a) ((ConcurrentHashMap) this.b).get(r2);
        if (r5 == null) goto L9;
        View r6 = r5.a;
        if (r6 == null) goto L9;
        if (xq() == null) goto L9;
        com.bytedance.android.live.messagewindow.business.util.a.c(r6, r3);
    L9:
        r4.invoke();
    }

    public final /* bridge */ /* synthetic */ void yc(v61.c r1, boolean r2, Function0 r3) {
        Aq((v61.a) r1, r2, r3);
    }

    public final void Wi(v61.a r6, t61.a r7, boolean r8, Function1 r9) {
        Intrinsics.checkNotNullParameter(r6, "window");
        Intrinsics.checkNotNullParameter(r9, "listener");
        int r1 = t61.c.f;
        final t61.c r10 = t61.c.a.a(r9);
        t61.c r11 = t61.c.a.a(new PreviewMsgWinCommonWidget$doAnim$innerListenerRef$1(r10));
        Intrinsics.checkNotNullParameter(r6, "window");
        if (r8 == false) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L16;
        Intrinsics.checkNotNullParameter(r11, "innerListenerRef");
        Function0 r12 = r11.a;
        if (r12 == null) goto L13;
        Unit r13 = (Unit) r12.invoke();
    L13:
        Function0 r14 = r11.b;
        if (r14 == null) goto L52;
        Unit r15 = (Unit) r14.invoke();
        return;
    L52:
        return;
    L16:
        Ref.BooleanRef r3 = new Ref.BooleanRef();
        r3.element = true;
        a r16 = (a) ((ConcurrentHashMap) this.b).get(r6);
        if (r16 == null) goto L44;
        View r17 = r16.a;
        if (r17 == null) goto L44;
        if (r7 != null) goto L22;
    L24:
        boolean r4 = false;
    L25:
        boolean r5 = true ^ r4;
        r3.element = r5;
        Animator r18 = null;
        if (r5 == false) goto L28;
        View r19 = r17;
    L29:
        if (r19 == null) goto L44;
        if (r7 == null) goto L44;
        if (r8 == false) goto L33;
        Animator r20 = r7.a(r17);
    L34:
        if (r20 == null) goto L44;
        r3.element = false;
        r17.clearAnimation();
        r20.setTarget(r17);
        r20.removeAllListeners();
        r20.addListener(new b(r17, r7, r11));
        if ((r20 instanceof ValueAnimator) == false) goto L39;
        r18 = r20;
    L39:
        ValueAnimator r21 = (ValueAnimator) r18;
        if (r21 == null) goto L42;
        r21.addUpdateListener(new c(r17, r7, r11));
    L42:
        r20.start();
        goto L44
    L33:
        r20 = r7.c(r17);
        goto L34
    L28:
        r19 = null;
        goto L29
    L22:
        if (r7.b(r17, r8, r11) != true) goto L24;
        r4 = true;
    L44:
        if (r3.element == false) goto L54;
        Intrinsics.checkNotNullParameter(r11, "innerListenerRef");
        Function0 r22 = r11.a;
        if (r22 == null) goto L48;
        Unit r23 = (Unit) r22.invoke();
    L48:
        Function0 r24 = r11.b;
        if (r24 == null) goto L55;
        Unit r25 = (Unit) r24.invoke();
        return;
    L55:
        return;
    L54:
        return;
    L5:
        if (r6.isShowing() == true) goto L7;
        r2 = true;
        goto L9
    }
}
