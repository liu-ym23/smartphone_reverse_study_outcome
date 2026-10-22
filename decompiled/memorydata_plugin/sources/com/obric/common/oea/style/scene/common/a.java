package com.obric.common.oea.style.scene.common;

import android.view.View;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.common.oea.foundation.animation.d.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0017J\b\u0010\u000f\u001a\u00020\rH\u0017J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0006\u0010\u0016\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H&J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H&J+\u0010\u001b\u001a\u00020\r2#\b\u0002\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\r0\u001dJ+\u0010!\u001a\u00020\r2#\b\u0002\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\r0\u001dJ\b\u0010\"\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\u0014H\u0002J\b\u0010$\u001a\u00020\rH\u0017Jq\u0010%\u001a\u00020\r2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u001d26\u0010'\u001a2\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0(H\u0002Jq\u0010)\u001a\u00020\r2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u001d26\u0010'\u001a2\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0(H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/common/oea/style/scene/common/AbstractModeSwitchAnimComposer;", "", "animTimeout", "", "(J)V", "TAG", "", "animStartTime", "enterAnims", "", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "exitAnims", "clearAllAnims", "", "enterWithoutAnim", "exitWithoutAnim", "handleSingleEnterAnimEnd", "view", "Landroid/view/View;", "finished", "", "handleSingleExitAnimEnd", "isAnimRunning", "makeEnterAnims", "", "Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "makeExitAnims", "playEnterAnim", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "finishedSuccess", "playExitAnim", "prepareEnterAnim", "prepareExitAnim", "release", "startEnterAnim", "anims", "onSingleEnd", "Lkotlin/Function2;", "startExitAnim", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<d> f7825b;
    private final List<d> c;
    private long d;
    private final long e;

    public a() {
        this(0, 1, null);
    }

    public a(long r2) {
        this.e = r2;
        this.f7824a = "AbstractModeSwitchAnimComposer";
        this.f7825b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ a(long r1, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = 1000;
    L5:
        this(r1);
    }

    public static final /* synthetic */ String a(a r0) {
        return r0.f7824a;
    }

    public static final /* synthetic */ long b(a r2) {
        return r2.d;
    }

    public static final /* synthetic */ List c(a r0) {
        return r0.f7825b;
    }

    public static final /* synthetic */ List d(a r0) {
        return r0.c;
    }

    public abstract void a(View r1, boolean r2);

    public abstract void b(View r1, boolean r2);
}
