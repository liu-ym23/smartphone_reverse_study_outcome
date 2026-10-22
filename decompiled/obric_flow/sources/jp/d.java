package jp;

import android.view.Choreographer;
import android.view.View;
import c7.e;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static int d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f18413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ja.d f18414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18415c;

    static {
        new rp.a();
    }

    public d() {
        b r5 = new b();
        r5.f18404a = RunMode.PARALLEL;
        r5.f18405b = RepeatMode.NORMAL;
        r5.f18406c = CollectionsKt.emptyList();
        r5.f = -1;
        r5.g = 1.0f;
        r5.f18408i = true;
        this.f18413a = r5;
        int r10 = d;
        d = r10 + 1;
        this.f18415c = r10;
    }

    public final void a(boolean r10) {
        String r5 = "cancel, instanceId: [" + this.f18415c + "], clearVelocity: " + r10;
        Intrinsics.checkNotNullParameter("AnimationManager", "tag");
        Intrinsics.checkNotNullParameter(r5, "msg");
        if (rp.b.f21793a == null) goto L5;
        rp.a.b("AnimationManager", r5);
    L6:
        ja.d r11 = this.f18414b;
        if (r11 == null) goto L16;
        String r12 = "cancelAnimation, clearVelocity: " + r10;
        Intrinsics.checkNotNullParameter("AnimatableRunner", "tag");
        Intrinsics.checkNotNullParameter(r12, "msg");
        if (rp.b.f21793a == null) goto L11;
        rp.a.b("AnimatableRunner", r12);
    L11:
        Choreographer.getInstance().removeFrameCallback((e) r11.f18301a);
        ((b) r11.f18302b).a(r10);
        Function2 r13 = (Function2) r11.d;
        if (r13 == null) goto L14;
        Unit r14 = (Unit) r13.mo2invoke(Boolean.FALSE, null);
    L14:
        r11.k("cancelAnimation");
        return;
    L16:
        return;
    L5:
        rp.a.b("AnimationManager", r5);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(View r17, RunMode r18, float r19, RepeatMode r20, ArrayList r21, Function3 r22, Function2 r23) {
        StringBuilder r10 = new StringBuilder("start, instanceId: [");
        r10.append(this.f18415c);
        r10.append("], runAnimation, mode: ");
        r10.append(r18);
        r10.append(", speed: ");
        r10.append(r19);
        r10.append(", repeatMode: ");
        r10.append(r20);
        r10.append(", animationInfos: ");
        ArrayList r11 = new ArrayList(CollectionsKt.h(r21));
        Iterator r12 = r21.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        fp.a r13 = (fp.a) r12.next();
        StringBuilder r14 = new StringBuilder("AnimationInfo(property: ");
        r14.append(r13.e);
        r14.append(", initialValue: ");
        r14.append(r13.f);
        r14.append(", targetValue: ");
        r14.append(r13.g);
        r14.append(", spec: ");
        com.obric.common.oea.foundation.animation.spec.spring.b r15 = r13.f16967h;
        r14.append("FloatSpringSpec(dampingRatio: " + r15.f11324c + ", stiffness: " + r15.d + ", delay: " + r15.e + ", visibilityThreshold: " + r15.f + ", delta: " + r15.f11323b + ')');
        r14.append(", initialVelocity: ");
        r14.append(r13.f16968i);
        r14.append(", valueClass: ");
        r14.append(r13.f16969j);
        r14.append(", currentVelocity: ");
        r14.append(r13.f16970k);
        r14.append(", durationNanos: ");
        r14.append(r13.f16964a);
        r14.append(", firstFrameTimeNanos: ");
        r14.append(r13.f16965b);
        r14.append(", lastFrameTimeNanos: ");
        r14.append(r13.f16966c);
        r14.append(", isRunning: ");
        r14.append(r13.d);
        r14.append(')');
        r11.add(r14.toString());
        goto L4
    L6:
        String r16 = androidx.room.jarjarred.org.antlr.runtime.a.w(r10, CollectionsKt.q(r11, "\n", null, null, 0, null, null, 62), "AnimationManager", "tag", "msg");
        if (rp.b.f21793a == null) goto L9;
        rp.a.b("AnimationManager", r16);
    L10:
        b r24 = this.f18413a;
        r24.getClass();
        Intrinsics.checkNotNullParameter(r18, "runMode");
        r24.f18404a = r18;
        Intrinsics.checkNotNullParameter(r20, "repeatMode");
        r24.f18405b = r20;
        Intrinsics.checkNotNullParameter(r21, "animationInfos");
        r24.f18406c = r21;
        if (r17 == null) goto L13;
        boolean r5 = true;
    L14:
        r24.f18408i = r5;
        r24.d = new WeakReference(r17);
        r24.g = r19;
        Intrinsics.checkNotNullParameter(r24, "stateManager");
        ja.d r25 = new ja.d();
        r25.f18302b = r24;
        r25.f18303c = (Lambda) r22;
        r25.d = r23;
        r25.f18301a = new e(r25, 6);
        this.f18414b = r25;
        Choreographer.getInstance().postFrameCallback((e) r25.f18301a);
        return;
    L13:
        r5 = false;
        goto L14
    L9:
        rp.a.b("AnimationManager", r16);
        goto L10
    }
}
