package com.bytedance.android.livesdk.interactivity.like;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.config.g2;
import com.bytedance.android.livesdk.interactivity.api.comment.datacontext.CommentContext;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/like/DigAccessibilityWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Landroidx/core/view/accessibility/AccessibilityManagerCompat$TouchExplorationStateChangeListener;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DigAccessibilityWidget extends RoomRecyclableWidget implements AccessibilityManagerCompat.TouchExplorationStateChangeListener {
    public View a;
    public int b;
    public MotionEvent c;
    public boolean d;
    public final PublishSubject<Integer> e;
    public Disposable f;
    public Disposable g;
    public Disposable h;
    public final long i;
    public final Long j;
    public final a k;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DigAccessibilityWidget a;

        public a(DigAccessibilityWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r13) {
            DigAccessibilityWidget r14 = this.a;
            if (r14.d == true) goto L5;
            return;
        L5:
            MotionEvent r0 = r14.c;
            DiggContext.a r1 = DiggContext.Companion;
            DataCenter r2 = ((Widget) r14).dataCenter;
            r1.getClass();
            DiggContext r3 = DiggContext.a.a(r2);
            if (r3 == null) goto L10;
            com.bytedance.live.datacontext.n<u32.k> r4 = r3.getDiggWidget();
            if (r4 == null) goto L10;
            u32.k r5 = (u32.k) r4.getValue();
        L11:
            u32.k r10 = r5;
            if (r0 == null) goto L25;
            if (r10 == null) goto L25;
            if (r14.b != 0) goto L19;
            u32.k.a.a(r10, r0, r14.j.longValue(), null, false, false, false, 60);
        L19:
            if (u32.k.a.a(r10, r0, r14.j.longValue(), null, false, false, false, 60) == false) goto L24;
            int r6 = r14.b + 1;
            r14.b = r6;
            r14.e.onNext(Integer.valueOf(r6));
            Disposable r7 = r14.f;
            if (r7 == null) goto L23;
            r7.dispose();
        L23:
            r14.f = ((ObservableSubscribeProxy) Observable.timer(r14.j.longValue(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).as(r14.autoDispose())).subscribe(new com.bytedance.android.livesdk.interactivity.like.a(r14), new com.bytedance.android.livesdk.interactivity.like.b(r14));
            return;
        L24:
            r14.xq();
            return;
        L25:
            r14.xq();
            return;
        L10:
            r5 = null;
            goto L11
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ DigAccessibilityWidget a;

        public b(DigAccessibilityWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            DigAccessibilityWidget r4 = this.a;
            r4.onTouchExplorationStateChanged(r4.d);
        }
    }

    public static final class c<T> implements Predicate {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final boolean test(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if (r3.size() <= 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ DigAccessibilityWidget a;

        public d(DigAccessibilityWidget r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            ExceptionUtils.handleException(((Widget) this.a).context, r3);
            return CollectionsKt.emptyList();
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ DigAccessibilityWidget a;

        public e(DigAccessibilityWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            List r5 = (List) r4;
            if (r5 != null) goto L5;
            return;
        L5:
            if (r5.size() == 0) goto L16;
            Context r0 = ((Widget) this.a).context;
            if (r0 != null) goto L10;
            return;
        L10:
            if (r3.l(r0) == false) goto L15;
            r3.q(((Widget) this.a).context, "点赞" + ((Integer) CollectionsKt.last(r5)) + 27425);
            return;
        L15:
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r3) {
            SafetyGuard.a(null, (Throwable) r3, "DigAnnounce Error");
        }
    }

    public final int getLayoutId() {
        return 2131566642;
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        r3.o(((Widget) this).context, this);
        MotionEvent r0 = this.c;
        if (r0 == null) goto L5;
        r0.recycle();
    L5:
        Disposable r1 = this.f;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.f = null;
        Disposable r2 = this.g;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        this.g = null;
        Disposable r3 = this.h;
        if (r3 == null) goto L14;
        r3.dispose();
    L14:
        this.h = null;
        this.a = null;
        xq();
    }

    public final boolean wq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L11;
        Room r1 = com.bytedance.android.live.core.utils.z.o(r0);
        if (r1 == null) goto L11;
        RoomAuthStatus r2 = r1.getRoomAuthStatus();
        if (r2 == null) goto L11;
        if (r2.getEnableDigg() == true) goto L11;
    L18:
        return true;
    L11:
        if (((Boolean) l42.a.g.getValue()).booleanValue() == true) goto L15;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.G0.getValue()).booleanValue() == true) goto L15;
        return false;
    L15:
        if (isScreenPortrait() == false) goto L17;
        return false;
    L17:
        if (com.bytedance.android.live.core.utils.z.e(((Widget) this).dataCenter, false) == false) goto L18;
        return false;
    }

    public final void xq() {
        this.e.onNext(Integer.valueOf(this.b));
        this.b = 0;
    }

    public DigAccessibilityWidget() {
        this.e = PublishSubject.create();
        this.i = 1;
        this.j = (Long) g2.a.getValue();
        this.k = new a(this);
    }

    public final void onLoad(Object[] r9) {
        CommentContext.a r10 = CommentContext.Companion;
        DataCenter r0 = ((Widget) this).dataCenter;
        r10.getClass();
        CommentContext r11 = CommentContext.a.a(r0);
        Disposable r1 = null;
        if (r11 == null) goto L9;
        com.bytedance.live.datacontext.n<FrameLayout> r13 = r11.getInteractionRootView();
        if (r13 == null) goto L9;
        FrameLayout r14 = (FrameLayout) r13.getValue();
        if (r14 == null) goto L9;
        r14.setImportantForAccessibility(1);
        r14.setFocusable(true);
        r14.setOnClickListener(this.k);
        Unit r2 = Unit.INSTANCE;
    L10:
        this.a = r14;
        RoomContext r15 = getRoomContext();
        if (r15 == null) goto L17;
        com.bytedance.live.datacontext.m r16 = r15.isCleanMode();
        if (r16 == null) goto L17;
        Observable r17 = r16.a();
        if (r17 == null) goto L17;
        r1 = r17.subscribe(new b(this));
    L17:
        this.h = r1;
        UIUtils.setViewVisibility(findViewById(2131369087), 8);
        onTouchExplorationStateChanged(r3.l(((Widget) this).context));
        this.c = MotionEvent.obtain(0, 0, 0, s1.y() / 2, s1.w() / 2, 0);
        r3.f(((Widget) this).context, this);
        Completable r18 = nd1.a.b;
        if (r18 != null) goto L21;
        r18 = Completable.complete();
    L21:
        ((com.bytedance.android.live.core.utils.rxutils.autodispose.u) r18.as(autoDispose())).a(new AnonymousClass3(this));
        onTouchExplorationStateChanged(this.d);
        return;
    L9:
        r14 = null;
        goto L10
    }

    public final void onTouchExplorationStateChanged(boolean r7) {
        boolean r1 = true;
        if (r7 == true) goto L5;
    L18:
        View r3 = this.a;
        if (r3 == null) goto L21;
        r3.setImportantForAccessibility(0);
        r3.setFocusable(false);
        r3.setOnClickListener(null);
        r3.clearFocus();
        r3.setClickable(false);
    L21:
        Disposable r4 = this.g;
        if (r4 == null) goto L24;
        r4.dispose();
    L24:
        this.g = null;
    L25:
        if (r7 == true) goto L27;
    L29:
        r1 = false;
    L30:
        this.d = r1;
        return;
    L27:
        if (wq() == true) goto L29;
    L5:
        if (wq() == true) goto L18;
        View r5 = this.a;
        if (r5 == null) goto L17;
        RoomContext r6 = getRoomContext();
        if (r6 == null) goto L16;
        com.bytedance.live.datacontext.m r8 = r6.isCleanMode();
        if (r8 == null) goto L16;
        if (((Boolean) r8.getValue()).booleanValue() != true) goto L16;
        r5.setImportantForAccessibility(0);
        r5.setFocusable(false);
        r5.setOnClickListener(null);
        r5.setClickable(false);
        r5.clearFocus();
    L16:
        r5.setImportantForAccessibility(1);
        r5.setFocusable(true);
        r5.setOnClickListener(this.k);
        r5.setClickable(true);
    L17:
        this.g = ((du2.a) this.e.as(new du2.b())).a(this.i, TimeUnit.SECONDS).filter(c.a).observeOn(AndroidSchedulers.mainThread()).onErrorReturn(new d(this)).subscribe(new e(this), f.a);
        goto L25
    }
}
