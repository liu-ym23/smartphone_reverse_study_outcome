package com.bytedance.android.live.liveinteract.animation.glflymic;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.animation.e;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TaskState;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.f;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.g;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.m;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.p;
import com.bytedance.android.livesdk.config.i8;
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
public final class GLFlyMicAnimationTask extends com.bytedance.android.live.liveinteract.animation.c {
    public e d;
    public m e;
    public final Map<String, Integer> f;
    public boolean g;
    public final CompositeDisposable h;
    public final List<String> i;
    public final Set<com.bytedance.android.live.liveinteract.animation.tasklet.d> j;
    public final Set<com.bytedance.android.live.liveinteract.animation.tasklet.d> k;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ com.bytedance.android.live.liveinteract.animation.tasklet.b a;

        public b(com.bytedance.android.live.liveinteract.animation.tasklet.b r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            com.bytedance.android.live.liveinteract.animation.tasklet.b r3 = this.a;
            if (r3 == null) goto L6;
            r3.start();
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ com.bytedance.android.live.liveinteract.animation.tasklet.b a;

        public c(com.bytedance.android.live.liveinteract.animation.tasklet.b r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            com.bytedance.android.live.liveinteract.animation.tasklet.b r3 = this.a;
            if (r3 == null) goto L6;
            r3.start();
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ com.bytedance.android.live.liveinteract.animation.tasklet.b a;

        public d(com.bytedance.android.live.liveinteract.animation.tasklet.b r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            com.bytedance.android.live.liveinteract.animation.tasklet.b r3 = this.a;
            if (r3 == null) goto L6;
            r3.start();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void c() {
        this.d = null;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final int f() {
        return 3;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final String getToUserId() {
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final long b() {
        return ((i8) vm2.d.J5.getValue(null, vm2.d.a[345(0x159, float:4.83E-43)])).b();
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void recycle() {
        m r0 = this.e;
        if (r0 == null) goto L7;
        f r1 = r0.getReceiverEmoji();
        if (r1 == null) goto L7;
        r1.getSoundUrl();
    L7:
        Iterator r2 = CollectionsKt.toList(this.j).iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        ((com.bytedance.android.live.liveinteract.animation.tasklet.d) r2.next()).stop();
        goto L9
    L11:
        this.j.clear();
        this.h.dispose();
        this.a.clear();
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void startAnimation() {
        if (this.d == null) goto L58;
        m r0 = this.e;
        if (r0 == null) goto L59;
        p r1 = r0.getRevenueData();
        if (r1 == null) goto L60;
        int r2 = 1;
        if ((!r1.d.b.isEmpty()) != true) goto L63;
        ALogger.d("InteractAnimation.GLFlyMicAnimationTask", "startAnimation: " + this.e);
        ((LinkedHashMap) this.f).clear();
        if (((ArrayList) this.i).size() <= 1) goto L29;
        m r3 = this.e;
        if (r3 == null) goto L18;
        f r4 = r3.getPathEmoji();
        if (r4 == null) goto L18;
        int r5 = r4.getTimeOffset();
    L19:
        m r6 = this.e;
        if (r6 == null) goto L24;
        f r7 = r6.getReceiverEmoji();
        if (r7 == null) goto L24;
        int r8 = r7.getTimeOffset();
    L25:
        int r9 = Math.max(r5, r8);
        Iterator r10 = ((ArrayList) this.i).iterator();
    L27:
        if (r10.hasNext() == false) goto L29;
        this.f.put((String) r10.next(), Integer.valueOf(RangesKt.random(new IntRange(0, r9), Random.Default)));
    L24:
        r8 = 0;
    L18:
        r5 = 0;
    L29:
        m r11 = this.e;
        if (r11 == null) goto L37;
        f r12 = r11.getSenderEmoji();
        if (r12 == null) goto L37;
        com.bytedance.android.live.liveinteract.animation.tasklet.b r13 = n(3);
        if (r13 == null) goto L36;
        r13.a();
    L36:
        this.h.add(Observable.timer(r12.getStart(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r13)));
    L37:
        m r14 = this.e;
        if (r14 == null) goto L48;
        f r15 = r14.getPathEmoji();
        if (r15 == null) goto L48;
        if (r15.getType() == 0) goto L44;
        r2 = r15.getType();
    L44:
        com.bytedance.android.live.liveinteract.animation.tasklet.b r16 = n(r2);
        if (r16 == null) goto L47;
        r16.a();
    L47:
        this.h.add(Observable.timer(r15.getStart(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r16)));
    L48:
        m r17 = this.e;
        if (r17 == null) goto L61;
        f r18 = r17.getReceiverEmoji();
        if (r18 == null) goto L62;
        com.bytedance.android.live.liveinteract.animation.tasklet.b r19 = n(4);
        if (r19 == null) goto L55;
        r19.a();
    L55:
        this.h.add(Observable.timer(r18.getStart(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r19)));
        return;
    L62:
        return;
    L61:
        return;
    L63:
        return;
    L60:
        return;
    L59:
        return;
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
    public final void g(e r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.d = r1;
    }

    public final com.bytedance.android.live.liveinteract.animation.tasklet.b n(int r21) {
        m r2 = this.e;
        q50.a r3 = null;
        if (r2 == null) goto L5;
        p r4 = r2.getRevenueData();
    L6:
        if (r4 != null) goto L9;
        return null;
    L9:
        if (r21 != 1) goto L11;
        m r5 = this.e;
        if (r5 == null) goto L62;
        p r12 = r5.getRevenueData();
    L63:
        Intrinsics.checkNotNull(r12);
        m r6 = this.e;
        if (r6 == null) goto L66;
        f r13 = r6.getPathEmoji();
    L67:
        Intrinsics.checkNotNull(r13);
        e r7 = this.d;
        if (r7 == null) goto L72;
        q50.b r8 = r7.jq();
        if (r8 == null) goto L72;
        r3 = r8.b;
    L72:
        com.bytedance.android.live.liveinteract.animation.tasklet.b r1 = new GLIconMoveAnimationTasklet(r12, r13, r3, this.d, this.f, new GLFlyMicAnimationTask$buildTasklet$1(this));
    L74:
        return r1;
    L66:
        r13 = null;
        goto L67
    L62:
        r12 = null;
        goto L63
    L11:
        if (r21 != 2) goto L13;
        m r9 = this.e;
        if (r9 == null) goto L48;
        p r10 = r9.getRevenueData();
    L49:
        Intrinsics.checkNotNull(r10);
        m r11 = this.e;
        if (r11 == null) goto L52;
        f r14 = r11.getPathEmoji();
    L53:
        Intrinsics.checkNotNull(r14);
        e r15 = this.d;
        if (r15 == null) goto L58;
        q50.b r16 = r15.jq();
        if (r16 == null) goto L58;
        r3 = r16.b;
    L58:
        r1 = new GLPathAnimationTasklet(r10, r14, r3, this.d, this.f, new GLFlyMicAnimationTask$buildTasklet$2(this));
        goto L74
    L52:
        r14 = null;
        goto L53
    L48:
        r10 = null;
        goto L49
    L13:
        if (r21 != 3) goto L15;
        m r17 = this.e;
        if (r17 == null) goto L34;
        p r18 = r17.getRevenueData();
    L35:
        Intrinsics.checkNotNull(r18);
        m r19 = this.e;
        if (r19 == null) goto L38;
        f r110 = r19.getSenderEmoji();
    L39:
        Intrinsics.checkNotNull(r110);
        e r20 = this.d;
        if (r20 == null) goto L44;
        q50.b r22 = r20.jq();
        if (r22 == null) goto L44;
        r3 = r22.b;
    L44:
        r1 = new GLWebPAnimationTasklet(r18, r110, r3, this.d, new GLFlyMicAnimationTask$buildTasklet$3(this));
        goto L74
    L38:
        r110 = null;
        goto L39
    L34:
        r18 = null;
        goto L35
    L15:
        if (r21 != 4) goto L75;
        m r23 = this.e;
        if (r23 == null) goto L20;
        p r24 = r23.getRevenueData();
    L21:
        Intrinsics.checkNotNull(r24);
        m r25 = this.e;
        if (r25 == null) goto L24;
        f r26 = r25.getReceiverEmoji();
    L25:
        Intrinsics.checkNotNull(r26);
        e r27 = this.d;
        if (r27 == null) goto L30;
        q50.b r28 = r27.jq();
        if (r28 == null) goto L30;
        r3 = r28.b;
    L30:
        r1 = new GLMicSeatAnimationTasklet(r24, r26, r3, this.d, this.f, this.b, this.c, this.g, new GLFlyMicAnimationTask$buildTasklet$4(this));
        goto L74
    L24:
        r26 = null;
        goto L25
    L20:
        r24 = null;
        goto L21
    L75:
        return null;
    L5:
        r4 = null;
        goto L6
    }

    public GLFlyMicAnimationTask(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        super(r2, r3);
        this.f = new LinkedHashMap();
        this.h = new CompositeDisposable();
        this.i = new ArrayList();
        this.j = new LinkedHashSet();
        this.k = new LinkedHashSet();
    }

    public static final void m(GLFlyMicAnimationTask r5, com.bytedance.android.live.liveinteract.animation.tasklet.d r6, boolean r7) {
        if (r7 == true) goto L5;
        r5.j.remove(r6);
        r5.k.add(r6);
        if (r5.j.size() != 0) goto L54;
        int r8 = r5.k.size();
        m r9 = r5.e;
        f r1 = null;
        if (r9 == null) goto L23;
        f r10 = r9.getSenderEmoji();
    L24:
        int r2 = 1;
        if (r10 == null) goto L27;
        int r11 = 1;
    L28:
        int r12 = r11 + 0;
        m r4 = r5.e;
        if (r4 == null) goto L31;
        f r13 = r4.getPathEmoji();
    L32:
        if (r13 == null) goto L34;
        int r14 = 1;
    L35:
        int r15 = r12 + r14;
        m r16 = r5.e;
        if (r16 == null) goto L38;
        r1 = r16.getReceiverEmoji();
    L38:
        if (r1 != null) goto L42;
        r2 = 0;
    L42:
        if (r8 != (r15 + r2)) goto L55;
        m r17 = r5.e;
        if (r17 == null) goto L56;
        p r18 = r17.getRevenueData();
        if (r18 == null) goto L57;
        g r19 = r18.a;
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
        if (r5.j.size() == 0) goto L7;
    L17:
        r5.j.add(r6);
        return;
    L7:
        if (r5.k.size() != 0) goto L17;
        m r20 = r5.e;
        if (r20 == null) goto L17;
        p r21 = r20.getRevenueData();
        if (r21 == null) goto L17;
        g r3 = r21.a;
        if (r3 == null) goto L16;
        r3.c(r21.b, TaskState.START);
    L16:
        ALogger.i("InteractAnimation.InteractFlyMicAnimationTask", "onTaskletStart.GiftInfo:" + r21.b);
        goto L17
    }
}
