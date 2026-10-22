package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import am2.x;
import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import rj0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public HSImageView a;
    public Disposable b;
    public boolean c;
    public boolean d;
    public String e;
    public String f;
    public final CompositeDisposable g;
    public final long h;
    public final String i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            b r0 = this.a;
            int r5 = ((com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.c) r4).a;
            if (r0.d == true) goto L15;
            l.n2.getClass();
            l r1 = l.a.a();
            if (r1 != null) goto L7;
        L8:
            IVoiceChatGuestService.Companion.getClass();
            IVoiceChatGuestService r2 = IVoiceChatGuestService.a.a();
            if (r2 != null) goto L11;
        L12:
            if (r5 == 0) goto L15;
            r0.c();
            return;
        L11:
            if (r2.isEngineOn() == true) goto L15;
        L7:
            if (r1.isEngineOn() != true) goto L8;
        L15:
            r0.c = false;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.b$b, reason: collision with other inner class name */
    public static final class C0025b<T> implements Consumer {
        public final /* synthetic */ b a;

        public C0025b(b r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            if (((h) r1).a == false) goto L6;
            this.a.a();
            return;
        }
    }

    public static final class c extends BaseControllerListener<Object> {
        public final /* synthetic */ b a;

        public static final class a extends BaseAnimationListener {
            public int a;
            public final /* synthetic */ c b;
            public final /* synthetic */ Animatable c;

            public final void onAnimationStop(AnimatedDrawable2 r4) {
                Intrinsics.checkNotNullParameter(r4, "drawable");
                b r5 = this.b.a;
                if (r5.c == false) goto L9;
                Disposable r0 = r5.b;
                if (r0 == null) goto L7;
                r0.dispose();
            L7:
                r5.b = Observable.timer(r5.h, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.a(r5));
                return;
            }

            public a(c r1, Animatable r2) {
                this.b = r1;
                this.c = r2;
                this.a = -1;
            }

            public final void onAnimationFrame(AnimatedDrawable2 r2, int r3) {
                Intrinsics.checkNotNullParameter(r2, "drawable");
                if (r3 >= this.a) goto L5;
                this.c.stop();
            L5:
                this.a = r3;
            }
        }

        public c(b r1) {
            this.a = r1;
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            Intrinsics.checkNotNullParameter(r1, "id");
            if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
            ((AnimatedDrawable2) r3).setAnimationListener(new a(this, r3));
            return;
        }
    }

    public final void a() {
        this.c = false;
        HSImageView r0 = this.a;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        Disposable r1 = this.b;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.a = null;
        if (this.g.isDisposed() == true) goto L12;
        this.g.dispose();
        return;
    }

    public final void c() {
        AbstractDraweeController r0 = Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse(this.i)).setAutoPlayAnimations(true).setControllerListener(new c(this)).build();
        fj0.a r2 = fj0.b.a;
        String r3 = this.e;
        String r4 = this.f;
        PaidLinkMicContext r5 = PaidLinkMicContext.Companion.getContext();
        if (r5 == null) goto L7;
        m<Integer> r6 = r5.getDiscountMode();
        if (r6 == null) goto L7;
        Integer r7 = (Integer) r6.getValue();
    L8:
        Intrinsics.checkNotNullParameter(r3, "anchorId");
        Intrinsics.checkNotNullParameter(r4, "roomId");
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("anchor_id", r3);
        r8.put("room_id", r4);
        TalkRoomLogUtils.I0(r8, je0.d.f());
        TalkRoomLogUtils.B0(r8, null, null, 6);
        r8.put("play_mode", "rechargeable_normal");
        if (r7 != null) goto L12;
    L14:
        if (r7 != null) goto L17;
    L19:
        if (r7 != null) goto L22;
    L24:
        String r9 = "";
    L25:
        r8.put("discount_type", r9);
        j0.l().sendLog("livesdk_audience_rechargeable_discount_popup", r8, new Object[]{IRoom.class, x.class});
        HSImageView r1 = this.a;
        if (r1 == null) goto L28;
        r1.setVisibility(0);
    L28:
        HSImageView r10 = this.a;
        if (r10 == null) goto L32;
        r10.setController(r0);
        return;
    L32:
        return;
    L22:
        if (r7.intValue() != 3) goto L24;
        r9 = "strategy";
        goto L25
    L17:
        if (r7.intValue() != 2) goto L19;
        r9 = "activity";
        goto L25
    L12:
        if (r7.intValue() != 1) goto L14;
        r9 = "vip";
    L7:
        r7 = null;
        goto L8
    }

    public b() {
        this.c = true;
        this.e = "";
        this.f = "";
        this.g = new CompositeDisposable();
        this.h = ((Number) vm2.d.k7.getValue(null, vm2.d.a[423(0x1a7, float:5.93E-43)])).longValue();
        this.i = "https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/ttlive_toolbar_first_discount_anim.webp";
    }

    public final void b(HSImageView r2, boolean r3, String r4, String r5) {
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        this.e = r4;
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        this.f = r5;
        this.d = r3;
        this.a = r2;
        Disposable r6 = xs2.b.a().b(com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.c.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        if (r6 == null) goto L11;
        this.g.add(r6);
    L11:
        Disposable r7 = xs2.b.a().b(h.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0025b(this));
        if (r7 == null) goto L15;
        this.g.add(r7);
        return;
    }
}
