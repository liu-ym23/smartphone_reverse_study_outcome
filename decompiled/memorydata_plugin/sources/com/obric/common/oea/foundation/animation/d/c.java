package com.obric.common.oea.foundation.animation.d;

import android.view.View;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u000bJ\u0006\u0010!\u001a\u00020\u0004J\u0010\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006J\u0006\u0010#\u001a\u00020\tJ\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u0015J\u0006\u0010'\u001a\u00020\u0017J\u0006\u0010(\u001a\u00020\u0013J\u0006\u0010)\u001a\u00020\u0004J\b\u0010*\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010+\u001a\u00020\u000bJ\u0006\u0010,\u001a\u00020\u000bJ\u0006\u0010-\u001a\u00020\u001fJ\u0006\u0010.\u001a\u00020\u001fJ\u000e\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u0004J\u0018\u00101\u001a\u00020\u001f2\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006J\u000e\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\tJ\u000e\u00104\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u0004J\u000e\u00105\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u0004J\u000e\u00106\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u00107\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u00108\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u0013J\u000e\u00109\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u0004J\u000e\u0010:\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u0013J\u0010\u0010;\u001a\u00020\u001f2\b\u0010<\u001a\u0004\u0018\u00010\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/obric/common/oea/foundation/animation/manager/AnimatableStateManager;", "", "()V", "accumulatedPausedTimeNanos", "", "animationInfos", "", "Lcom/obric/common/oea/foundation/animation/AnimationInfo;", "curRunningSequenceAnimIndex", "", "isPausedFlag", "", "isViewAnimation", "()Z", "setViewAnimation", "(Z)V", "lastFrameTimeNanos", "pausedTimeNanos", "refreshRate", "", "repeatMode", "Lcom/obric/common/oea/foundation/animation/constants/RepeatMode;", "runMode", "Lcom/obric/common/oea/foundation/animation/constants/RunMode;", "speed", "startTimeNanos", "targetFps", "viewWeakReference", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "cancelAnimation", "", "clearVelocity", "getAccumulatedPausedTimeNanos", "getAnimationInfos", "getCurRunningSequenceAnimIndex", "getLastFrameTimeNanos", "getPausedTimeNanos", "getRepeatMode", "getRunMode", "getSpeed", "getStartTimeNanos", "getView", "hasAnimationNeedToRunning", "isPaused", "pause", "resume", "setAccumulatedPausedTimeNanos", "timeNanos", "setAnimationInfos", "setCurRunningSequenceAnimIndex", "index", "setLastFrameTimeNanos", "setPausedTimeNanos", "setRepeatMode", "setRunMode", "setSpeed", "setStartTimeNanos", "setTargetFps", "setView", "view", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f7708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f7709b;
    private RunMode c;
    private RepeatMode d;
    private List<? extends com.obric.common.oea.foundation.animation.a<?>> e;
    private WeakReference<View> f;
    private long g;
    private int h;
    private float i;
    private boolean j;
    private long k;
    private long l;
    private boolean m;

    public c() {
        this.f7709b = 60.0f;
        this.c = RunMode.PARALLEL;
        this.d = RepeatMode.NORMAL;
        this.e = CollectionsKt.emptyList();
        this.h = -1;
        this.i = 1.0f;
        this.m = true;
    }

    public final void a(float r1) {
        this.f7709b = r1;
    }

    public final void a(int r1) {
        this.h = r1;
    }

    public final void a(long r1) {
        this.g = r1;
    }

    public final void a(View r2) {
        if (r2 == null) goto L4;
        boolean r0 = true;
    L5:
        this.m = r0;
        this.f = new WeakReference(r2);
        return;
    L4:
        r0 = false;
        goto L5
    }

    public final void a(RepeatMode r2) {
        Intrinsics.checkNotNullParameter(r2, "repeatMode");
        this.d = r2;
    }

    public final void a(RunMode r2) {
        Intrinsics.checkNotNullParameter(r2, "runMode");
        this.c = r2;
    }

    public final void a(List<? extends com.obric.common.oea.foundation.animation.a<?>> r3) {
        List<? extends com.obric.common.oea.foundation.animation.a<?>> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "animationInfos");
        this.e = r4;
    }

    public final void a(boolean r6) {
        WeakReference<View> r0 = this.f;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((com.obric.common.oea.foundation.animation.a) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.common.oea.foundation.animation.a.class, "com.obric.memorydata.plugin")).a(false, false, r6);
        goto L7
    L9:
        this.g = 0;
        this.h = -1;
        this.i = 1.0f;
        this.j = false;
        this.k = 0;
        this.l = 0;
    }

    public final boolean a() {
        return this.m;
    }

    public final void b(float r1) {
        this.i = r1;
    }

    public final void b(long r1) {
        this.f7708a = r1;
    }

    public final boolean b() {
        return this.j;
    }

    public final void c(long r1) {
        this.k = r1;
    }

    public final boolean c() {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        if (((com.obric.common.oea.foundation.animation.a) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.common.oea.foundation.animation.a.class, "com.obric.memorydata.plugin")).c() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        return false;
    }

    public final View d() {
        WeakReference<View> r2 = this.f;
        if (r2 != null) goto L7;
        return null;
    L7:
        return (View) ZeusTransformUtils.preCheckCast(r2.get(), View.class, "com.obric.memorydata.plugin");
    }

    public final void d(long r1) {
        this.l = r1;
    }

    public final RunMode e() {
        return this.c;
    }

    public final RepeatMode f() {
        return this.d;
    }

    public final List<com.obric.common.oea.foundation.animation.a<?>> g() {
        return this.e;
    }

    public final float h() {
        return this.i;
    }

    public final long i() {
        return this.g;
    }

    public final long j() {
        return this.f7708a;
    }

    public final long k() {
        return this.k;
    }

    public final long l() {
        return this.l;
    }

    public final int m() {
        return this.h;
    }
}
