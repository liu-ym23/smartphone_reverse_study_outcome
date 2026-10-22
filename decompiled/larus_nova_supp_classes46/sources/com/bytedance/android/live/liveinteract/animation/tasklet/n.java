package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.live.liveinteract.voicechat.emoji.sound.EmojiSoundManager;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n extends com.bytedance.android.live.liveinteract.animation.tasklet.b {
    public static final /* synthetic */ int r = 0;
    public final List<String> c;
    public final List<HSImageView> d;
    public final Set<Animatable> e;
    public final Set<Animatable> f;
    public boolean g;
    public ImageRequest h;
    public final com.bytedance.android.live.liveinteract.animation.c i;
    public final com.bytedance.android.live.liveinteract.animation.e j;
    public final com.bytedance.android.live.liveinteract.animation.tasklet.a k;
    public final Map<String, Integer> l;
    public final boolean m;
    public final String n;
    public final int o;
    public final boolean p;
    public final Function2<d, Boolean, Unit> q;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ n a;
        public final /* synthetic */ HSImageView b;
        public final /* synthetic */ EPointF c;
        public final /* synthetic */ String d;

        public b(n r1, HSImageView r2, EPointF r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            n r0 = this.a;
            HSImageView r1 = this.b;
            EPointF r2 = this.c;
            r0.getClass();
            r1.setX(((PointF) r2).x - (r1.getLayoutParams().width / 2));
            r1.setY(((PointF) r2).y - (r1.getLayoutParams().height / 2));
            n r3 = this.a;
            HSImageView r4 = this.b;
            int r5 = r3.j.zl(this.d);
            if (r3.b.isValid() == true) goto L5;
            ALogger.e("InteractAnimation.MicSeatAnimationTasklet", "playReceiverSeatAnimation#animation data invalid:" + r3.b);
            return;
        L5:
            if (r5 > 0) goto L7;
        L9:
            String r6 = r3.b.getSoundUrl();
            Uri r7 = null;
            if (r6 == null) goto L23;
            if (StringsKt.endsWith$default(r6, "null", false, 2, null) == true) goto L23;
            com.bytedance.android.live.liveinteract.animation.e r8 = r3.j;
            if ((r8 instanceof InteractAnimationController.d) == true) goto L16;
            r8 = null;
        L16:
            InteractAnimationController.d r9 = (InteractAnimationController.d) r8;
            if (r9 == null) goto L21;
            EmojiSoundManager r10 = InteractAnimationController.d.a.c(r9);
            if (r10 == null) goto L21;
            r10.e(r3.n, r6, r3.o);
        L21:
            r3.j.Mb(r3.n, r6, r3.o);
        L23:
            if (r3.b.getReshape() == true) goto L25;
        L30:
            List<py.k> r11 = r3.b.getResources();
            if (r11 != null) goto L34;
            return;
        L34:
            if (r11.size() == 0) goto L69;
            List<py.k> r12 = r3.b.getResources();
            if (r12 == null) goto L45;
            int r13 = r3.a.b.g - 1;
            if (vm2.d.F() == false) goto L47;
            if (r13 < 0) goto L47;
            if (r13 >= r12.size()) goto L45;
            py.k r14 = (py.k) ListProtector.get(r12, r13);
        L48:
            ImageRequest[] r15 = a1.b(r14, 1);
            if (r3.h != null) goto L54;
            if (r15 == null) goto L52;
            ImageRequest r16 = r15[0];
        L53:
            r3.h = r16;
            goto L54
        L52:
            r16 = null;
        L54:
            UtilityKotlinExtentionsKt.w(r4);
            PipelineDraweeController r17 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r15).setAutoPlayAnimations(true).setControllerListener(new q(r3, r4, r3.j.vj())).build();
            if (vm2.d.G() == true) goto L57;
        L64:
            r4.setController(r17);
            return;
        L57:
            if ((r17 instanceof PipelineDraweeController) == false) goto L64;
            PipelineDraweeController r18 = r17;
            Context r19 = r4.getContext();
            if (r15 == null) goto L63;
            ImageRequest r20 = r15[0];
            if (r20 == null) goto L63;
            r7 = r20.getSourceUri();
        L63:
            com.bytedance.android.live.core.utils.fresco.c.a(r18, r19, String.valueOf(r7));
        L47:
            r14 = (py.k) ListProtector.get(r12, (int) (r3.a.b.f % ((long) r12.size())));
        L45:
            r14 = null;
            goto L48
        L69:
            return;
        L25:
            if (r3.m == true) goto L30;
            long r21 = r3.b.getSizeScale();
            com.bytedance.android.live.liveinteract.animation.e r22 = r3.j;
            if (r21 != 0) goto L29;
            r21 = 1000;
        L29:
            r22.Ka(r5, r21 / 1000.0f);
            goto L30
        L7:
            if (r3.j.Ed(r5) == true) goto L9;
            ALogger.e("InteractAnimation.MicSeatAnimationTasklet", "playReceiverSeatAnimation#cur seat cant play,pos:" + r5);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void start() {
        ((ArrayList) this.c).clear();
        ((ArrayList) this.c).addAll(this.a.d.b);
        if ((!((ArrayList) this.c).isEmpty()) == true) goto L6;
        ALogger.e("InteractAnimation.MicSeatAnimationTasklet", "start#resource parse failed.");
        return;
    L6:
        ((ArrayList) this.d).clear();
        FrameLayout r1 = this.j.vj();
        int r3 = ((ArrayList) this.c).size();
        int r5 = 0;
    L7:
        long r6 = 0;
        if (r5 >= r3) goto L24;
        HSImageView r8 = this.k.b();
        int r9 = this.j.zl((String) ListProtector.get(this.c, r5));
        r1.addView(r8);
        long r10 = this.b.getSizeScale();
        if (r10 > 0) goto L12;
        r10 = 1000;
    L12:
        float r7 = r10 / 1000.0f;
        if (r8 == null) goto L15;
        ViewGroup.LayoutParams r11 = r8.getLayoutParams();
    L16:
        com.bytedance.android.live.liveinteract.animation.e r12 = this.j;
        Intrinsics.checkNotNull(r12);
        float r13 = r12.ma(r9, 1) / 1.2f;
        if (r11 == null) goto L19;
        r11.width = (int) (r13 * r7);
    L19:
        if (r11 == null) goto L21;
        r11.height = (int) (r13 * r7);
    L21:
        if (r8 == null) goto L23;
        r8.setLayoutParams(r11);
    L23:
        ((ArrayList) this.d).add(r8);
        r5 = r5 + 1;
        goto L7
    L15:
        r11 = null;
        goto L16
    L24:
        this.j.vj().getLocationOnScreen(new int[2]);
        if (((ArrayList) this.d).isEmpty() == false) goto L27;
        return;
    L27:
        if (((ArrayList) this.c).size() != ((ArrayList) this.d).size()) goto L60;
        int r4 = ((ArrayList) this.c).size();
        int r14 = 0;
    L30:
        if (r14 >= r4) goto L61;
        HSImageView r15 = (HSImageView) ListProtector.get(this.d, r14);
        String r16 = (String) ListProtector.get(this.c, r14);
        EPointF r17 = this.j.Mj(r16);
        if (r17 == null) goto L52;
        int r18 = this.j.zl(r16);
        if (r18 <= 0) goto L40;
        com.bytedance.android.live.liveinteract.animation.e r19 = this.j;
        Intrinsics.checkNotNull(r19);
        if (r19.Ed(r18) == false) goto L52;
    L40:
        if (this.p == false) goto L43;
        this.j.dm(r18);
        goto L52
    L43:
        Integer r110 = this.l.get(r16);
        if (r110 == null) goto L46;
        int r111 = r110.intValue();
    L48:
        if (this.a.b.e == false) goto L50;
        long r112 = r6;
    L51:
        double r20 = 0.5f;
        double r2 = 2;
        int r113 = (int) r112;
        float r114 = ((float) ((Math.random() - r20) * r2)) * UtilityKotlinExtentionsKt.i(r113);
        float r21 = ((float) (r2 * (Math.random() - r20))) * UtilityKotlinExtentionsKt.i(r113);
        int[] r22 = new int[2];
        this.j.vj().getLocationOnScreen(r22);
        ((PointF) r17).x = (((PointF) r17).x - r22[0]) + r114;
        ((PointF) r17).y = (((PointF) r17).y - r22[1]) + r21;
        r15.postDelayed(new b(this, r15, r17, r16), r111);
        goto L52
    L50:
        r112 = this.b.getOffset();
        goto L51
    L46:
        r111 = 0;
    L52:
        r14 = r14 + 1;
        r4 = r4;
        r6 = 0;
        goto L30
    L61:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void stop() {
        Iterator r0 = ((ArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((HSImageView) r0.next()).setController(null);
        goto L4
    L6:
        FrameLayout r1 = this.j.vj();
        r1.post(new r(this, r1));
    }

    public static final void b(n r2) {
        Function2<d, Boolean, Unit> r0 = r2.q;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke(r2, Boolean.FALSE);
    L5:
        r2.i.k();
        r2.stop();
        if (vm2.d.G() == false) goto L10;
        CountingMemoryCache r3 = com.bytedance.android.live.core.utils.fresco.e.a;
        if (r3 == null) goto L10;
        r3.removeAll(new o(r2));
    L10:
        r2.g = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r2, com.bytedance.android.live.liveinteract.animation.c r3, com.bytedance.android.live.liveinteract.animation.e r4, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r5, com.bytedance.android.live.liveinteract.animation.tasklet.a r6, Map<String, Integer> r7, boolean r8, String r9, int r10, boolean r11, Function2<? super d, ? super Boolean, Unit> r12) {
        Intrinsics.checkNotNullParameter(r2, "revenueData");
        Intrinsics.checkNotNullParameter(r3, "mTask");
        Intrinsics.checkNotNullParameter(r4, "mSeatInfoProvider");
        Intrinsics.checkNotNullParameter(r5, "animationData");
        Intrinsics.checkNotNullParameter(r6, "mViewProvider");
        Intrinsics.checkNotNullParameter(r7, "mDelayMap");
        Intrinsics.checkNotNullParameter(r9, "mTaskID");
        super(r2, r5);
        this.i = r3;
        this.j = r4;
        this.k = r6;
        this.l = r7;
        this.m = r8;
        this.n = r9;
        this.o = r10;
        this.p = r11;
        this.q = r12;
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new LinkedHashSet();
        this.f = new LinkedHashSet();
    }
}
