package com.bytedance.android.live.liveinteract.animation;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.animation.tasklet.IconMoveAnimationTasklet;
import com.bytedance.android.live.liveinteract.animation.tasklet.PathEffectAnimationTasklet;
import com.bytedance.android.live.liveinteract.animation.tasklet.WebPAnimationTasklet;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TaskState;
import com.bytedance.android.livesdk.config.i8;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.o0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class InteractFlyMicAnimationTask extends com.bytedance.android.live.liveinteract.animation.c {
    public final String d;
    public final List<String> e;
    public com.bytedance.android.live.liveinteract.animation.e f;
    public com.bytedance.android.live.liveinteract.videotalk.emoji.model.m g;
    public o0 h;
    public boolean i;
    public boolean j;
    public com.bytedance.android.live.liveinteract.animation.tasklet.c k;
    public final Map<String, Integer> l;
    public final CompositeDisposable m;
    public final Set<com.bytedance.android.live.liveinteract.animation.tasklet.d> n;
    public final Set<com.bytedance.android.live.liveinteract.animation.tasklet.d> o;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ InteractFlyMicAnimationTask a;

        public b(InteractFlyMicAnimationTask r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            InteractFlyMicAnimationTask r4 = this.a;
            if (r4.i == true) goto L10;
            com.bytedance.android.live.liveinteract.animation.tasklet.b r5 = r4.n(3);
            if (r5 == null) goto L9;
            r5.start();
            return;
        L9:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.f a;
        public final /* synthetic */ InteractFlyMicAnimationTask b;

        public c(com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r1, InteractFlyMicAnimationTask r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            InteractFlyMicAnimationTask r4 = this.b;
            if (r4.i == false) goto L6;
            return;
        L6:
            if (this.a.getType() == 0) goto L8;
            int r0 = this.a.getType();
        L9:
            com.bytedance.android.live.liveinteract.animation.tasklet.b r5 = r4.n(r0);
            if (r5 == null) goto L13;
            r5.start();
            return;
        L13:
            return;
        L8:
            r0 = 1;
            goto L9
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ InteractFlyMicAnimationTask a;

        public d(InteractFlyMicAnimationTask r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            InteractFlyMicAnimationTask r4 = this.a;
            if (r4.i == true) goto L10;
            com.bytedance.android.live.liveinteract.animation.tasklet.b r5 = r4.n(4);
            if (r5 == null) goto L9;
            r5.start();
            return;
        L9:
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ InteractFlyMicAnimationTask a;

        public e(InteractFlyMicAnimationTask r1) {
            this.a = r1;
        }

        public final void accept(Object r14) {
            Long r15 = (Long) r14;
            if (this.a.i == false) goto L5;
            i.a("InteractAnimation.InteractFlyMicAnimationTask" + this.a.b, "sender anim stopped, currentAnimation is cleared");
            return;
        L5:
            com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r0 = this.a.g;
            if (r0 == null) goto L8;
            com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r2 = r0.getRevenueData();
        L9:
            Intrinsics.checkNotNull(r2);
            InteractFlyMicAnimationTask r3 = this.a;
            com.bytedance.android.live.liveinteract.animation.e r4 = r3.f;
            Intrinsics.checkNotNull(r4);
            com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r1 = this.a.g;
            if (r1 == null) goto L12;
            com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r5 = r1.getReceiverEmoji();
        L13:
            Intrinsics.checkNotNull(r5);
            com.bytedance.android.live.liveinteract.animation.tasklet.c r6 = this.a.k;
            Intrinsics.checkNotNull(r6);
            InteractFlyMicAnimationTask r7 = this.a;
            new com.bytedance.android.live.liveinteract.animation.tasklet.n(r2, r3, r4, r5, r6, r7.l, r7.j, r7.b, r7.c, true, new InteractFlyMicAnimationTask$startAnimation$4$1(this.a)).start();
            return;
        L12:
            r5 = null;
            goto L13
        L8:
            r2 = null;
            goto L9
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void c() {
        this.f = null;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final int f() {
        return 3;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final long b() {
        return ((i8) vm2.d.J5.getValue(null, vm2.d.a[345(0x159, float:4.83E-43)])).b();
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void recycle() {
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r0 = this.g;
        if (r0 == null) goto L7;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r1 = r0.getReceiverEmoji();
        if (r1 == null) goto L7;
        r1.getSoundUrl();
    L7:
        Iterator r2 = CollectionsKt.toList(this.n).iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        ((com.bytedance.android.live.liveinteract.animation.tasklet.d) r2.next()).stop();
        goto L9
    L11:
        this.n.clear();
        this.m.dispose();
        this.i = true;
        this.a.clear();
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void startAnimation() {
        if (this.f == null) goto L88;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r0 = this.g;
        if (r0 == null) goto L89;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r1 = r0.getRevenueData();
        if (r1 != null) goto L9;
        return;
    L9:
        if ((!r1.d.b.isEmpty()) != true) goto L91;
        ((LinkedHashMap) this.l).clear();
        if (((ArrayList) this.e).size() <= 1) goto L29;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r2 = this.g;
        if (r2 == null) goto L18;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r3 = r2.getPathEmoji();
        if (r3 == null) goto L18;
        int r4 = r3.getTimeOffset();
    L19:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r5 = this.g;
        if (r5 == null) goto L24;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r6 = r5.getReceiverEmoji();
        if (r6 == null) goto L24;
        int r7 = r6.getTimeOffset();
    L25:
        int r8 = Math.max(r4, r7);
        Iterator r9 = ((ArrayList) this.e).iterator();
    L27:
        if (r9.hasNext() == false) goto L29;
        this.l.put((String) r9.next(), Integer.valueOf(RangesKt.random(new IntRange(0, r8), Random.Default)));
    L24:
        r7 = 0;
    L18:
        r4 = 0;
    L29:
        CompositeDisposable r10 = this.m;
        TimeUnit r11 = TimeUnit.MILLISECONDS;
        r10.add(Observable.timer(10000, r11).observeOn(AndroidSchedulers.mainThread()).subscribe(new x(this)));
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r12 = this.g;
        if (r12 == null) goto L34;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r13 = r12.getSenderEmoji();
        if (r13 == null) goto L34;
        this.m.add(Observable.timer(r13.getStart(), r11).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this)));
    L34:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r14 = this.g;
        if (r14 == null) goto L39;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r15 = r14.getPathEmoji();
        if (r15 == null) goto L39;
        this.m.add(Observable.timer(r15.getStart(), r11).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r15, this)));
    L39:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r16 = this.g;
        if (r16 == null) goto L44;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r17 = r16.getReceiverEmoji();
        if (r17 == null) goto L44;
        this.m.add(Observable.timer(r17.getStart(), r11).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this)));
    L44:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r18 = this.g;
        Intrinsics.checkNotNull(r18);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r19 = r18.getReceiverEmoji();
        if (r19 == null) goto L56;
        if (r19.getReshape() != true) goto L56;
        if (this.j == false) goto L56;
        CompositeDisposable r20 = this.m;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r21 = this.g;
        Intrinsics.checkNotNull(r21);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r22 = r21.getReceiverEmoji();
        Intrinsics.checkNotNull(r22);
        Long r23 = r22.getReshapeStart();
        if (r23 == null) goto L53;
        long r24 = r23.longValue();
    L54:
        r20.add(Observable.timer(r24, r11).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this)));
        goto L56
    L53:
        r24 = 0;
    L56:
        if (this.h == null) goto L68;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r25 = this.g;
        if (r25 == null) goto L68;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r26 = r25.getRevenueData();
        if (r26 == null) goto L68;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.o r27 = r26.d;
        if (r27 == null) goto L68;
        if (r27.d != true) goto L68;
        com.bytedance.android.live.liveinteract.animation.tasklet.b r28 = n(5);
        if (r28 == null) goto L68;
        r28.start();
    L68:
        MultiLinkEventModule r29 = yc0.a.a;
        yc0.b.a r30 = new yc0.b.a();
        if (this.c != 4) goto L71;
        String r31 = "normal-big";
    L72:
        Intrinsics.checkNotNullParameter(r31, "flymicType");
        r30.c = r31;
        Intrinsics.checkNotNullParameter("success", "reason");
        r30.a = "success";
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r32 = this.g;
        h2 r33 = null;
        if (r32 == null) goto L77;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r34 = r32.getRevenueData();
        if (r34 == null) goto L77;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r35 = r34.b;
    L78:
        r30.e = r35;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r36 = this.g;
        if (r36 == null) goto L85;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r37 = r36.getRevenueData();
        if (r37 == null) goto L85;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r38 = r37.b;
        if (r38 == null) goto L85;
        r33 = r38.k;
    L85:
        r30.b = r33;
        yc0.a.d(new yc0.b(r30));
        return;
    L77:
        r35 = null;
        goto L78
    L71:
        r31 = "normal";
        goto L72
    L91:
        return;
    L89:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final String getToUserId() {
        return this.d;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final boolean e(InteractAnimationController r4) {
        Intrinsics.checkNotNullParameter(r4, "interactAnimationController");
        if (r4.k(1) == false) goto L6;
        r4.b(1);
    L6:
        if (r4.k(2) == false) goto L8;
        r4.b(2);
    L8:
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void g(com.bytedance.android.live.liveinteract.animation.e r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.f = r2;
        this.k = new com.bytedance.android.live.liveinteract.animation.tasklet.c(r2.vj().getContext());
    }

    public final com.bytedance.android.live.liveinteract.animation.tasklet.b n(int r14) {
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r1 = this.g;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r2 = null;
        if (r1 == null) goto L5;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r3 = r1.getRevenueData();
    L6:
        if (r3 != null) goto L9;
        return null;
    L9:
        if (r14 != 1) goto L11;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r0 = this.g;
        if (r0 == null) goto L71;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r4 = r0.getRevenueData();
    L72:
        Intrinsics.checkNotNull(r4);
        com.bytedance.android.live.liveinteract.animation.e r5 = this.f;
        Intrinsics.checkNotNull(r5);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r6 = this.g;
        if (r6 == null) goto L75;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r7 = r6.getPathEmoji();
    L76:
        Intrinsics.checkNotNull(r7);
        com.bytedance.android.live.liveinteract.animation.tasklet.c r8 = this.k;
        Intrinsics.checkNotNull(r8);
        com.bytedance.android.live.liveinteract.animation.tasklet.b r9 = new IconMoveAnimationTasklet(r4, this, r5, r7, r8, this.l, new InteractFlyMicAnimationTask$buildTasklet$1(this));
    L78:
        return r9;
    L75:
        r7 = null;
        goto L76
    L71:
        r4 = null;
        goto L72
    L11:
        if (r14 != 2) goto L13;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r10 = this.g;
        if (r10 == null) goto L62;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r11 = r10.getRevenueData();
    L63:
        Intrinsics.checkNotNull(r11);
        com.bytedance.android.live.liveinteract.animation.e r12 = this.f;
        Intrinsics.checkNotNull(r12);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r13 = this.g;
        if (r13 == null) goto L66;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r15 = r13.getPathEmoji();
    L67:
        Intrinsics.checkNotNull(r15);
        com.bytedance.android.live.liveinteract.animation.tasklet.c r16 = this.k;
        Intrinsics.checkNotNull(r16);
        r9 = new PathEffectAnimationTasklet(r11, this, r12, r15, r16, this.l, new InteractFlyMicAnimationTask$buildTasklet$2(this));
        goto L78
    L66:
        r15 = null;
        goto L67
    L62:
        r11 = null;
        goto L63
    L13:
        if (r14 != 3) goto L15;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r17 = this.g;
        if (r17 == null) goto L53;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r18 = r17.getRevenueData();
    L54:
        Intrinsics.checkNotNull(r18);
        com.bytedance.android.live.liveinteract.animation.e r19 = this.f;
        Intrinsics.checkNotNull(r19);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r20 = this.g;
        if (r20 == null) goto L57;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r21 = r20.getSenderEmoji();
    L58:
        Intrinsics.checkNotNull(r21);
        com.bytedance.android.live.liveinteract.animation.tasklet.c r22 = this.k;
        Intrinsics.checkNotNull(r22);
        return new WebPAnimationTasklet(r18, this, r19, r21, r22, new InteractFlyMicAnimationTask$buildTasklet$3(this));
    L57:
        r21 = null;
        goto L58
    L53:
        r18 = null;
        goto L54
    L15:
        if (r14 != 4) goto L17;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r23 = this.g;
        if (r23 == null) goto L44;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r24 = r23.getRevenueData();
    L45:
        Intrinsics.checkNotNull(r24);
        com.bytedance.android.live.liveinteract.animation.e r25 = this.f;
        Intrinsics.checkNotNull(r25);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r26 = this.g;
        if (r26 == null) goto L48;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r27 = r26.getReceiverEmoji();
    L49:
        Intrinsics.checkNotNull(r27);
        com.bytedance.android.live.liveinteract.animation.tasklet.c r28 = this.k;
        Intrinsics.checkNotNull(r28);
        return new com.bytedance.android.live.liveinteract.animation.tasklet.n(r24, this, r25, r27, r28, this.l, this.j, this.b, this.c, false, new InteractFlyMicAnimationTask$buildTasklet$4(this));
    L48:
        r27 = null;
        goto L49
    L44:
        r24 = null;
        goto L45
    L17:
        if (r14 != 5) goto L86;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r29 = this.g;
        if (r29 == null) goto L22;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r30 = r29.getRevenueData();
    L23:
        if (r30 == null) goto L79;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r31 = this.g;
        if (r31 == null) goto L27;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r32 = r31.getPathEmoji();
    L28:
        if (r32 != null) goto L30;
        return null;
    L30:
        if (this.f != null) goto L32;
        return null;
    L32:
        if (this.k == null) goto L82;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r33 = this.g;
        if (r33 == null) goto L36;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r34 = r33.getRevenueData();
    L37:
        Intrinsics.checkNotNull(r34);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r35 = this.g;
        if (r35 == null) goto L40;
        r2 = r35.getPathEmoji();
    L40:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r36 = r2;
        Intrinsics.checkNotNull(r36);
        o0 r37 = this.h;
        com.bytedance.android.live.liveinteract.animation.e r38 = this.f;
        Intrinsics.checkNotNull(r38);
        com.bytedance.android.live.liveinteract.animation.tasklet.c r39 = this.k;
        Intrinsics.checkNotNull(r39);
        return new com.bytedance.android.live.liveinteract.animation.tasklet.z(r34, r36, r37, r38, r39);
    L36:
        r34 = null;
        goto L37
    L82:
        return null;
    L27:
        r32 = null;
        goto L28
    L79:
        return null;
    L22:
        r30 = null;
        goto L23
    L86:
        return null;
    L5:
        r3 = null;
        goto L6
    }

    public final void o(com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r2) {
        Intrinsics.checkNotNullParameter(r2, "talkRoomInteractEmoji");
        this.g = r2;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r3 = r2.getPathEmoji();
        if (r3 == null) goto L9;
        py.k r4 = r3.dynamicImage();
        if (r4 == null) goto L9;
        if (r4.isValid() != true) goto L9;
        int r5 = com.bytedance.android.live.liveinteract.voicechat.emoji.a.a;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r6 = this.g;
        Intrinsics.checkNotNull(r6);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r7 = r6.getPathEmoji();
        Intrinsics.checkNotNull(r7);
        py.k r8 = r7.dynamicImage();
        Intrinsics.checkNotNull(r8);
        com.bytedance.android.live.liveinteract.voicechat.emoji.a.a(r8);
    L9:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r9 = this.g;
        if (r9 == null) goto L19;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r10 = r9.getReceiverEmoji();
        if (r10 == null) goto L20;
        py.k r11 = r10.dynamicImage();
        if (r11 != null) goto L16;
        return;
    L16:
        if (r11.isValid() != true) goto L22;
        int r12 = com.bytedance.android.live.liveinteract.voicechat.emoji.a.a;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r13 = this.g;
        Intrinsics.checkNotNull(r13);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r14 = r13.getReceiverEmoji();
        Intrinsics.checkNotNull(r14);
        py.k r15 = r14.dynamicImage();
        Intrinsics.checkNotNull(r15);
        com.bytedance.android.live.liveinteract.voicechat.emoji.a.a(r15);
        return;
    L22:
        return;
    L20:
        return;
    }

    public InteractFlyMicAnimationTask(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        super(r2, r3);
        this.d = "";
        this.e = new ArrayList();
        this.l = new LinkedHashMap();
        this.m = new CompositeDisposable();
        this.n = new LinkedHashSet();
        this.o = new LinkedHashSet();
    }

    public static final void m(InteractFlyMicAnimationTask r5, com.bytedance.android.live.liveinteract.animation.tasklet.d r6, boolean r7) {
        if (r7 == true) goto L5;
        r5.n.remove(r6);
        r5.o.add(r6);
        if (r5.n.size() != 0) goto L54;
        int r8 = r5.o.size();
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r9 = r5.g;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r1 = null;
        if (r9 == null) goto L23;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r10 = r9.getSenderEmoji();
    L24:
        int r2 = 1;
        if (r10 == null) goto L27;
        int r11 = 1;
    L28:
        int r12 = r11 + 0;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r4 = r5.g;
        if (r4 == null) goto L31;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r13 = r4.getPathEmoji();
    L32:
        if (r13 == null) goto L34;
        int r14 = 1;
    L35:
        int r15 = r12 + r14;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r16 = r5.g;
        if (r16 == null) goto L38;
        r1 = r16.getReceiverEmoji();
    L38:
        if (r1 != null) goto L42;
        r2 = 0;
    L42:
        if (r8 != (r15 + r2)) goto L55;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r17 = r5.g;
        if (r17 == null) goto L56;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r18 = r17.getRevenueData();
        if (r18 == null) goto L57;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r19 = r18.a;
        if (r19 == null) goto L51;
        r19.c(r18.b, TaskState.COMPLETE);
    L51:
        r5.h(r5);
        ALogger.i("InteractAnimation.InteractFlyMicAnimationTask", "onTaskletStop#GiftInfo:" + r18.b);
        return;
    L57:
        return;
    L56:
        return;
    L55:
        return;
    L34:
        r14 = 0;
        goto L35
    L31:
        r13 = null;
        goto L32
    L27:
        r11 = 0;
        goto L28
    L23:
        r10 = null;
        goto L24
    L54:
        return;
    L5:
        if (r5.n.size() == 0) goto L7;
    L17:
        r5.n.add(r6);
        return;
    L7:
        if (r5.o.size() != 0) goto L17;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r20 = r5.g;
        if (r20 == null) goto L17;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r21 = r20.getRevenueData();
        if (r21 == null) goto L17;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r3 = r21.a;
        if (r3 == null) goto L16;
        r3.c(r21.b, TaskState.START);
    L16:
        ALogger.i("InteractAnimation.InteractFlyMicAnimationTask", "onTaskletStart.GiftInfo:" + r21.b);
        goto L17
    }
}
