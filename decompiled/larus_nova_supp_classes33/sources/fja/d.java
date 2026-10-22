package fja;

import android.view.Choreographer;
import android.view.View;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d {
    public static int d;
    public final c a;
    public fja.a b;
    public final int c;

    public static final class a {
    }

    static {
        new mja.b();
    }

    public d() {
        this.a = new c();
        int r0 = d;
        d = r0 + 1;
        this.c = r0;
    }

    public final void a(boolean r4) {
        mja.a.C0063a r0 = mja.a.a;
        mja.a.d("AnimationManager", "cancel, instanceId: [" + this.c + "], clearVelocity: " + r4);
        fja.a r1 = this.b;
        if (r1 == null) goto L9;
        mja.a.c("cancelAnimation, clearVelocity: " + r4);
        Choreographer.getInstance().removeFrameCallback(r1.a);
        r1.b.a(r4);
        Function2<? super Boolean, ? super Throwable, Unit> r5 = r1.d;
        if (r5 == null) goto L7;
        Unit r6 = (Unit) r5.invoke(Boolean.FALSE, null);
    L7:
        mja.a.a("AnimatableRunner", "releaseCallbacks, scene: ".concat("cancelAnimation"));
        r1.c = null;
        r1.d = null;
        return;
    }

    public final void b(float r18, boolean r19, View r20, RunMode r21, float r22, RepeatMode r23, List<? extends bja.a<?>> r24, Function3<? super String, Object, ? super Float, Unit> r25, Function2<? super Boolean, ? super Throwable, Unit> r26) {
        mja.a.C0063a r6 = mja.a.a;
        StringBuilder r7 = new StringBuilder("start, instanceId: [");
        r7.append(this.c);
        r7.append("], runAnimation, mode: ");
        r7.append(r21);
        r7.append(", speed: ");
        r7.append(r22);
        r7.append(", repeatMode: ");
        r7.append(r23);
        r7.append(", animationInfos: ");
        List<? extends bja.a<?>> r8 = r24;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        bja.a r11 = (bja.a) r10.next();
        r11.getClass();
        r9.add("AnimationInfo(property: " + r11.e + ", initialValue: " + r11.f + ", targetValue: " + r11.g + ", spec: " + r11.h.dump() + ", initialVelocity: " + r11.i + ", valueClass: " + r11.j + ", currentVelocity: " + r11.k + ", durationNanos: " + r11.a + ", firstFrameTimeNanos: " + r11.b + ", lastFrameTimeNanos: " + r11.c + ", isRunning: " + r11.d + ')');
        goto L4
    L6:
        r7.append(CollectionsKt.joinToString$default(r9, "\n", null, null, 0, null, null, 62, null));
        mja.a.d("AnimationManager", r7.toString());
        c r12 = this.a;
        r12.b = r18;
        Intrinsics.checkNotNullParameter(r21, "runMode");
        r12.c = r21;
        c r2 = this.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r23, "repeatMode");
        r2.d = r23;
        c r3 = this.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r24, "animationInfos");
        r3.e = r24;
        c r4 = this.a;
        r4.getClass();
        if (r20 == null) goto L9;
        boolean r5 = true;
    L10:
        r4.l = r5;
        r4.f = new WeakReference(r20);
        c r1 = this.a;
        r1.i = r22;
        r1.m = r19;
        fja.a r13 = new fja.a(this.a, r25, r26);
        this.b = r13;
        Choreographer.getInstance().postFrameCallback(r13.a);
        return;
    L9:
        r5 = false;
        goto L10
    }
}
