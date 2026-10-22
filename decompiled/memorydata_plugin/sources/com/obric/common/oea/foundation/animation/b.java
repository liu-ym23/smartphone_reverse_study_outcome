package com.obric.common.oea.foundation.animation;

import android.view.View;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.common.oea.foundation.animation.d.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u000eJ\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0007J\u0014\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\rJ\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rJ\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/common/oea/foundation/animation/AnimationLifecycleListener;", "", "()V", "TAG", "", "animationManagers", "Ljava/util/ArrayList;", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "Lkotlin/collections/ArrayList;", "isInit", "", "viewAnimationMap", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "Lcom/obric/common/oea/foundation/animation/AnimationInfo;", "addAnimationInfo", "", "view", "animationInfo", "addAnimationManager", "animationManager", "getAnimationInfo", CommonConsts.APM_INNER_EVENT_COST_INIT, "application", "Landroid/app/Application;", "removeAnimationInfo", "removeAnimationManager", "ActivityLifeCallback", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f7673a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ArrayList<d> f7674b = null;
    private static final WeakHashMap<View, a<?>> c = null;

    static {
        f7673a = new b();
        f7674b = new ArrayList();
        c = new WeakHashMap();
    }

    private b() {
    }

    public final a<?> a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        return (a) ZeusTransformUtils.preCheckCast(c.get(r2), a.class, "com.obric.memorydata.plugin");
    }

    public final void a(View r3, a<?> r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "animationInfo");
        ((Map) ZeusTransformUtils.preCheckCast(c, Map.class, "com.obric.memorydata.plugin")).put(r3, r4);
    }

    public final void a(d r3) {
        Intrinsics.checkNotNullParameter(r3, "animationManager");
        ArrayList<d> r2 = f7674b;
        r2.add(r3);
        com.obric.common.oea.foundation.a.b.f7661a.a("AnimationLifecycleListener", "addAnimationManager, size: " + r2.size());
    }

    public final void b(d r3) {
        Intrinsics.checkNotNullParameter(r3, "animationManager");
        ArrayList<d> r2 = f7674b;
        r2.remove(r3);
        com.obric.common.oea.foundation.a.b.f7661a.a("AnimationLifecycleListener", "removeAnimationManager, size: " + r2.size());
    }
}
