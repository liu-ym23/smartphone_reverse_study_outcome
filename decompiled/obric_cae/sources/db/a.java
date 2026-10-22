package db;

import android.view.Choreographer;
import android.view.View;
import ge.p;
import ge.q;
import he.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChoreographerFrameCallbackC0061a f7005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f7006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q<? super String, Object, ? super Float, j> f7007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p<? super Boolean, ? super Throwable, j> f7008d;

    /* JADX INFO: renamed from: db.a$a, reason: collision with other inner class name */
    public static final class ChoreographerFrameCallbackC0061a implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f7009a;

        public ChoreographerFrameCallbackC0061a(a r8) {
            this.f7009a = r8;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r24) {
            a r11 = this.f7009a;
            b r8 = r11.f7006b;
            Object r12 = null;
            if (r8.f7019j == false) goto L11;
            WeakReference<View> r10 = r8.f7013d;
            if (r10 == null) goto L7;
            View r13 = r10.get();
        L8:
            if (r13 != null) goto L11;
            mb.a.c("doFrame, view is null");
            return;
        L7:
            r13 = null;
        L11:
            b r14 = r11.f7006b;
            if (r14.f7014e != 0) goto L14;
            r14.f7014e = r24;
        L14:
            r14.getClass();
            long r15 = r14.f7017h;
            if (r15 <= 0) goto L17;
            r14.f7018i = r14.f7018i + (r24 - r15);
            r14.f7017h = 0;
        L17:
            long r16 = (r24 - r14.f7014e) - r14.f7018i;
            int r17 = r14.f7010a.ordinal();
            if (r17 == 0) goto L39;
            if (r17 == 1) goto L22;
        L27:
            String r18 = "AnimatableRunner";
            boolean r19 = false;
        L75:
            List<? extends ya.a<?>> r20 = r14.f7012c;
            if ((r20 instanceof Collection) == true) goto L78;
        L80:
            Iterator<T> r21 = r20.iterator();
        L82:
            if (r21.hasNext() == false) goto L86;
            if (((ya.a) r21.next()).f14096d == false) goto L82;
            boolean r22 = true;
        L87:
            Choreographer r23 = Choreographer.getInstance();
            if (r22 == true) goto L104;
            r23.removeFrameCallback(this);
            int r25 = r14.f7011b.ordinal();
            if (r25 != 0) goto L93;
            mb.a.c("endAnimationInternal, clearVelocity: true");
            Choreographer.getInstance().removeFrameCallback(r11.f7005a);
            r14.a(true);
            mb.a.a(r18, "releaseCallbacks, scene: ".concat("endAnimationInternal"));
            r11.f7007c = null;
            r11.f7008d = null;
            return;
        L93:
            if (r25 != 1) goto L95;
            mb.a.c("doFrame, 触发 loop");
            boolean r26 = r19;
        L103:
            a.a(r11, r26);
            r23 = Choreographer.getInstance();
            goto L104
        L95:
            if (r25 != 2) goto L120;
            mb.a.c("doFrame, 触发 reverse");
            List<? extends ya.a<?>> r27 = r14.f7012c;
            i.f(r27, "<this>");
            if (r27.size() > 1) goto L100;
            List<? extends ya.a<?>> r28 = yd.i.n1(r27);
        L101:
            r14.f7012c = r28;
            r26 = true;
            goto L103
        L100:
            ArrayList r29 = new ArrayList(r27);
            Collections.reverse(r29);
            r28 = r29;
            goto L101
        L120:
            return;
        L104:
            r23.postFrameCallback(this);
            return;
        L86:
            r22 = r19;
            goto L87
        L78:
            if (r20.isEmpty() == false) goto L80;
        L22:
            if (r14.f7015f != (-1)) goto L25;
            r14.f7015f = 0;
        L25:
            if (r14.f7015f < r14.f7012c.size()) goto L28;
            mb.a.a("AnimatableRunner", "runSequentialAnimations, return case 1");
            goto L27
        L28:
            long r30 = (long) (r16 * r14.f7016g);
            ya.a<?> r31 = r14.f7012c.get(r14.f7015f);
            boolean r32 = r31.a(r30);
            r31.f14096d = !r32;
            if (r32 == false) goto L37;
            r19 = false;
            r11.b("runSequentialAnimations 1", r16, r31, r24, false);
            int r33 = r14.f7015f + 1;
            r14.f7015f = r33;
            if (r33 < r14.f7012c.size()) goto L36;
            mb.a.a("AnimatableRunner", "runSequentialAnimations, return case 2");
            p<? super Boolean, ? super Throwable, j> r34 = r11.f7008d;
            if (r34 == null) goto L35;
            j r35 = r34.invoke(Boolean.TRUE, null);
        L35:
            r18 = "AnimatableRunner";
            goto L75
        L36:
            r14.f7014e = 0;
            r14.f7017h = 0;
            r14.f7018i = 0;
            r14.getClass();
            r31 = r14.f7012c.get(r14.f7015f);
            String r36 = "AnimatableRunner";
            String r37 = "runSequentialAnimations 2";
            long r38 = 0;
        L38:
            r18 = r36;
            r11.b(r37, r38, r31, r24, true);
            goto L75
        L37:
            r19 = false;
            r36 = "AnimatableRunner";
            r37 = "runSequentialAnimations 3";
            r38 = r16;
            goto L38
        L39:
            r19 = false;
            String r39 = "AnimatableRunner";
            List<? extends ya.a<?>> r40 = r14.f7012c;
            if (r40.size() <= 1) goto L51;
            ArrayList r41 = new ArrayList();
            Iterator<T> r42 = r40.iterator();
        L43:
            if (r42.hasNext() == false) goto L48;
            Object r43 = r42.next();
            if (((ya.a) r43).f14096d == false) goto L43;
            r41.add(r43);
            goto L43
        L48:
            if (r41.size() == 1) goto L51;
            boolean r110 = false;
        L52:
            Iterator<T> r111 = r40.iterator();
            int r44 = 0;
            int r45 = 0;
        L54:
            if (r111.hasNext() == false) goto L68;
            Object r46 = r111.next();
            int r112 = r44 + 1;
            if (r44 < 0) goto L66;
            ya.a<?> r47 = (ya.a) r46;
            if (r47.f14096d == false) goto L63;
            List<? extends ya.a<?>> r210 = r40;
            int r113 = r45;
            String r48 = r39;
            if (r11.b("runParallelAnimations", r16, r47, r24, r110) == true) goto L64;
            r45 = r113;
        L65:
            r39 = r48;
            r44 = r112;
            r40 = r210;
            r12 = null;
        L64:
            r45 = r113 + 1;
            goto L65
        L63:
            r210 = r40;
            r113 = r45;
            r48 = r39;
            goto L64
        L66:
            l6.a.T0();
            throw null;
        L68:
            List<? extends ya.a<?>> r211 = r40;
            r18 = r39;
            Object r49 = r12;
            int r114 = r45;
            if (r110 == true) goto L75;
            if (r114 != r211.size()) goto L75;
            mb.a.a(r18, "runParallelAnimations, all finished");
            p<? super Boolean, ? super Throwable, j> r50 = r11.f7008d;
            if (r50 == null) goto L75;
            j r51 = r50.invoke(Boolean.TRUE, r49);
        L51:
            r110 = true;
            goto L52
        }
    }

    public a(b r8, q<? super String, Object, ? super Float, j> r10, p<? super Boolean, ? super Throwable, j> r11) {
        i.f(r8, "stateManager");
        this.f7006b = r8;
        this.f7007c = r10;
        this.f7008d = r11;
        this.f7005a = new ChoreographerFrameCallbackC0061a(this);
    }

    public static final void a(a r8, boolean r10) {
        b r11 = r8.f7006b;
        WeakReference<View> r12 = r11.f7013d;
        if (r12 == null) goto L5;
        View r13 = r12.get();
    L6:
        Iterator<T> r14 = r11.f7012c.iterator();
    L8:
        if (r14.hasNext() == false) goto L19;
        ya.a r15 = (ya.a) r14.next();
        if (r13 == null) goto L16;
        String r16 = r15.f14097e;
        if (r10 == false) goto L14;
        Object r17 = r15.f14099g;
    L15:
        defpackage.c.j0(r13, r16, r17);
        goto L16
    L14:
        r17 = r15.f14098f;
    L16:
        r15.f14096d = true;
        r15.f14103k = 0.0f;
        r15.f14094b = -1;
        r15.f14095c = -1;
        if (r10 == false) goto L8;
        T r18 = r15.f14098f;
        r15.f14098f = r15.f14099g;
        r15.f14099g = r18;
        goto L8
    L19:
        r11.f7014e = 0;
        r11.f7017h = 0;
        r11.f7018i = 0;
        r11.getClass();
        r11.f7015f = -1;
        return;
    L5:
        r13 = null;
        goto L6
    }

    public final boolean b(String r23, long r24, ya.a<?> r26, long r27, boolean r29) {
        b r8 = this.f7006b;
        long r14 = (long) (r24 * r8.f7016g);
        r26.getClass();
        Class r10 = Float.TYPE;
        he.d r11 = he.p.a(r10);
        le.b<?> r13 = r26.f14102j;
        boolean r12 = i.a(r13, r11);
        l6.a r16 = l6.a.f9133b;
        defpackage.c r17 = defpackage.c.f3203h;
        if (r12 == false) goto L6;
        ab.a r15 = r17;
    L8:
        T r18 = r26.f14098f;
        T r19 = r26.f14099g;
        Float r20 = r26.f14101i;
        float r110 = 0.0f;
        if (r20 == null) goto L11;
        float r111 = r20.floatValue();
    L12:
        Object r112 = r15.c(r14, r18, r19, r111, r26.f14100h);
        WeakReference<View> r21 = r8.f7013d;
        if (r21 == null) goto L15;
        View r22 = r21.get();
    L17:
        if (r26.f14094b != (-1)) goto L19;
        r26.f14094b = r27;
    L19:
        boolean r113 = r26.a(r14);
        String r114 = r26.f14097e;
        if (r22 == null) goto L25;
        if (r113 == false) goto L23;
        Object r25 = r26.f14099g;
    L24:
        defpackage.c.j0(r22, r114, r25);
        goto L25
    L23:
        r25 = r112;
    L25:
        r26.f14095c = r27;
        r26.f14096d = !r113;
        if (i.a(r13, he.p.a(r10)) == false) goto L29;
        ab.a r28 = r17;
    L31:
        T r115 = r26.f14098f;
        T r30 = r26.f14099g;
        Float r31 = r26.f14101i;
        if (r31 == null) goto L34;
        r110 = r31.floatValue();
    L34:
        float r32 = r28.a(r14, r115, r30, r110, r26.f14100h);
        r26.f14103k = r32;
        if (r113 == true) goto L37;
        q<? super String, Object, ? super Float, j> r33 = this.f7007c;
        if (r33 == null) goto L46;
        j r34 = r33.invoke(r114, r112, Float.valueOf(r32));
    L46:
        return r113;
    L37:
        if (r29 == false) goto L41;
        StringBuilder r35 = defpackage.b.i("executeAnimation, ", r23, ", return case 1, property: ", r114, ", targetValue: ");
        r35.append(r26.f14099g);
        mb.a.c(r35.toString());
        p<? super Boolean, ? super Throwable, j> r36 = this.f7008d;
        if (r36 == null) goto L46;
        r34 = r36.invoke(Boolean.TRUE, null);
        goto L46
    L41:
        StringBuilder r37 = defpackage.b.i("executeAnimation, ", r23, ", return case 2, property: ", r114, ", targetValue: ");
        r37.append(r26.f14099g);
        mb.a.c(r37.toString());
        goto L46
    L29:
        if (i.a(r13, he.p.a(Integer.TYPE)) == false) goto L48;
        r28 = r16;
        goto L31
    L48:
        throw new IllegalArgumentException("Unsupported type " + r13);
    L15:
        r22 = null;
        goto L17
    L11:
        r111 = 0.0f;
        goto L12
    L6:
        if (i.a(r13, he.p.a(Integer.TYPE)) == false) goto L50;
        r15 = r16;
        goto L8
    L50:
        throw new IllegalArgumentException("Unsupported type " + r13);
    }
}
