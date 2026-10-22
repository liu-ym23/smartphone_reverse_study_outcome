package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationContext;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkSucAnimationView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.SeatAnimationView;
import com.bytedance.android.livesdk.chatroom.ui.DynamicEmojiView;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.message.model.b8;
import com.bytedance.android.livesdk.message.model.n8;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdk.message.model.za;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class SeatAnimManager implements e {
    public final Map<String, SeatAnimationView> a;
    public Disposable b;
    public final Function0<? extends za> c;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.SeatAnimManager$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/za;", "invoke", "()Lcom/bytedance/android/livesdk/message/model/za;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    final class AnonymousClass1 extends Lambda implements Function0<za> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        public final za invoke() {
            IKtvService r0 = jc1.k.f(IKtvService.class);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.ktvCurrentSingerOrderInfo();
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m51invoke() {
            return invoke();
        }
    }

    public SeatAnimManager(Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "singerOrderInfoProvider");
        this.c = r2;
        this.a = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.e
    public final void a(w r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if ((r2 instanceof b) == false) goto L8;
        b r3 = (b) r2;
        if (f(r3.c) == false) goto L9;
        g(r3.c);
        ALogger.d("SeatAnimManager", "#GuestBattleDebug# [onTaskStart] GuestBattle Anim coming, stop Emoji");
        return;
    L9:
        return;
    }

    public final void b(a r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        InteractAnimationContext.a r1 = InteractAnimationContext.Companion;
        InteractAnimationController r2 = r1.a();
        if (r2 != null) goto L5;
    L6:
        InteractAnimationController r3 = r1.a();
        if (r3 != null) goto L9;
    L10:
        InteractAnimationController r4 = r1.a();
        if (r4 != null) goto L13;
    L15:
        com.bytedance.android.live.liveinteract.animation.universalwidget.a.f0.getClass();
        com.bytedance.android.live.liveinteract.animation.universalwidget.a r5 = com.bytedance.android.live.liveinteract.animation.universalwidget.a.C0014a.a();
        if (r5 != null) goto L18;
    L20:
        String r7 = r6.a.a.getIdString();
        if (TextUtils.isEmpty(r7) == false) goto L23;
        r7 = String.valueOf(r6.a.a.getIdString());
    L23:
        SeatAnimationView r8 = (SeatAnimationView) ((LinkedHashMap) this.a).get(r7);
        if (r8 == null) goto L26;
        SeatAnimTaskState r9 = r8.getTaskState();
    L27:
        if (r9 != null) goto L29;
        return;
    L29:
        if (r9 != SeatAnimTaskState.LINK_SUC_ANIM) goto L31;
        return;
    L31:
        if (r9 != SeatAnimTaskState.REVENUE_DRESS_ANIM) goto L33;
        return;
    L33:
        if (r9 == SeatAnimTaskState.THEMED_COMPETITION_ANIM) goto L48;
        SeatAnimationView r10 = (SeatAnimationView) ((LinkedHashMap) this.a).get(r7);
        if (r10 == null) goto L46;
        Intrinsics.checkNotNullParameter(r6, "event");
        v r0 = r10.a;
        if (r0 == null) goto L47;
        r0.c(r6);
        return;
    L47:
        return;
    L46:
        return;
    L48:
        return;
    L26:
        r9 = null;
        goto L27
    L18:
        if (com.bytedance.android.live.liveinteract.animation.universalwidget.a.b.a(r5) != true) goto L20;
        return;
    L13:
        if (r4.k(3) != true) goto L15;
        return;
    L9:
        if (r3.k(2) != true) goto L10;
        return;
    L5:
        if (r2.k(1) != true) goto L6;
    }

    public final void d(za r6) {
        if (r6 != null) goto L8;
        Iterator r7 = ((LinkedHashMap) this.a).entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L19;
        ((SeatAnimationView) ((Map.Entry) r7.next()).getValue()).a(new h(false));
        goto L6
    L19:
        return;
    L8:
        Iterator r1 = ((LinkedHashMap) this.a).entrySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L27;
        Map.Entry r2 = (Map.Entry) r1.next();
        Intrinsics.checkNotNullParameter(r6, "$this$topUserFlex");
        b8 r3 = r6.getTopUser();
        if (r3 == null) goto L14;
        String r4 = n8.b(r3);
    L16:
        if (Intrinsics.areEqual(r4, (String) r2.getKey()) == true) goto L17;
        ((SeatAnimationView) r2.getValue()).a(new h(false));
        goto L10
    L17:
        ((SeatAnimationView) r2.getValue()).a(new h(true));
        goto L10
    L14:
        r4 = null;
        goto L16
    }

    public final boolean f(String r3) {
        if (r3 == null) goto L13;
        SeatAnimationView r4 = (SeatAnimationView) ((LinkedHashMap) this.a).get(r3);
        if (r4 == null) goto L11;
        DynamicEmojiView r5 = r4.e;
        if (r5 != null) goto L10;
        return false;
    L10:
        return !(r5.b.a instanceof wj0.c.b);
    L11:
        return false;
    L13:
        return false;
    }

    public final void g(String r3) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        SeatAnimationView r4 = (SeatAnimationView) ((LinkedHashMap) this.a).get(r3);
        if (r4 == null) goto L10;
        DynamicEmojiView r5 = r4.e;
        if (r5 == null) goto L11;
        wj0.b r0 = r5.b.a();
        if (r0 == null) goto L12;
        r5.b.b(new wj0.a.C0287a(r0));
        return;
    L12:
        return;
    L11:
        return;
    }

    public SeatAnimManager(int r1) {
        this(AnonymousClass2.INSTANCE);
    }

    public final void e(String r3, SeatAnimationView r4) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "view");
        this.a.put(r3.toString(), r4);
        LinkSucAnimationView r0 = r4.d;
        if (r0 == null) goto L5;
        r0.h = false;
    L5:
        r4.setSeatAnimTaskListener(this);
        za r5 = (za) this.c.invoke();
        if (r5 == null) goto L15;
        Intrinsics.checkNotNullParameter(r5, "$this$topUserFlex");
        b8 r1 = r5.getTopUser();
        if (r1 == null) goto L10;
        String r2 = n8.b(r1);
    L12:
        if (Intrinsics.areEqual(r2, r3) == false) goto L16;
        d(r5);
        return;
    L16:
        return;
    L10:
        r2 = null;
        goto L12
    }

    public final void c(a r10, w8 r11, ViewGroup r12, View r13) {
        Intrinsics.checkNotNullParameter(r10, "event");
        Intrinsics.checkNotNullParameter(r11, MultiLinkOpenSource.MESSAGE);
        Intrinsics.checkNotNullParameter(r12, "container");
        InteractAnimationContext.a r2 = InteractAnimationContext.Companion;
        InteractAnimationController r3 = r2.a();
        if (r3 != null) goto L5;
    L6:
        InteractAnimationController r4 = r2.a();
        if (r4 != null) goto L9;
    L10:
        InteractAnimationController r5 = r2.a();
        if (r5 != null) goto L13;
    L15:
        com.bytedance.android.live.liveinteract.animation.universalwidget.a.f0.getClass();
        com.bytedance.android.live.liveinteract.animation.universalwidget.a r6 = com.bytedance.android.live.liveinteract.animation.universalwidget.a.C0014a.a();
        if (r6 == null) goto L21;
        if (com.bytedance.android.live.liveinteract.animation.universalwidget.a.b.a(r6) != true) goto L21;
        return;
    L21:
        if (TextUtils.isEmpty(r10.a.a.getIdString()) == false) goto L23;
        r10.a.a.getIdString();
    L23:
        HSImageView r7 = r12.findViewWithTag("emoj_animate_view");
        if (r13 == null) goto L35;
        int r8 = r13.getWidth();
        Intrinsics.checkNotNullParameter(r13, "targetView");
        Intrinsics.checkNotNullParameter(r12, "relativeToView");
        int[] r9 = new int[2];
        int[] r14 = new int[2];
        r13.getLocationOnScreen(r9);
        r12.getLocationOnScreen(r14);
        int r15 = r9[0] - r14[0];
        int r16 = r9[1] - r14[1];
        if (r7 != null) goto L29;
        ViewGroup.LayoutParams r17 = new ViewGroup.LayoutParams(r8, r8);
        ImageView r18 = new HSImageView(r12.getContext());
        r18.setLayoutParams(r17);
        r18.setTag("emoj_animate_view");
        r12.addView(r18, r17);
        r18.measure(View.MeasureSpec.makeMeasureSpec(r8, 1073741824), View.MeasureSpec.makeMeasureSpec(r8, 1073741824));
        r18.layout(r15, r16, r15 + r8, r8 + r16);
        r18.invalidate();
        r7 = r18;
    L29:
        if (r10.a.b.isRandomEmoji == false) goto L31;
        Intrinsics.checkNotNullParameter(r7, "animateView");
        Intrinsics.checkNotNullParameter(r10, "event");
        Intrinsics.checkNotNullParameter(r11, MultiLinkOpenSource.MESSAGE);
        this.b = Observable.create(new SeatAnimManager$handleResultEmoji$1(r7, r10)).doOnNext(new r(r7, r10)).concatMap(new s(r10)).doOnComplete(new t(r7)).doOnError(new u(r7)).subscribe();
        return;
    L31:
        Intrinsics.checkNotNullParameter(r7, "animateView");
        Intrinsics.checkNotNullParameter(r10, "event");
        Intrinsics.checkNotNullParameter(r11, MultiLinkOpenSource.MESSAGE);
        r7.post(new q(r7, r10, r11));
        return;
    L35:
        return;
    L13:
        if (r5.k(3) != true) goto L15;
        return;
    L9:
        if (r4.k(2) != true) goto L10;
        return;
    L5:
        if (r3.k(1) != true) goto L6;
    }
}
