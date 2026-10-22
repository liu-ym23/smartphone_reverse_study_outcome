package oc2;

import am2.x;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeFeature;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.ss.android.ugc.effectmanager.common.ConcurrentHashSet;
import f32.f;
import java.lang.Enum;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a<T extends f32.f, F extends Enum<?>> implements h32.c<T> {
    public final ConcurrentHashSet b;
    public T c;
    public F d;
    public final com.bytedance.android.livesdk.interactivity.b e;

    public abstract T c(F r1);

    public abstract DegradeFeature d();

    public abstract F e();

    public void g() {
        this.b.clear();
    }

    public void h() {
        F r0 = (F) e();
        this.d = r0;
        this.c = (T) c(r0);
    }

    @Override // h32.c
    public final void a(h32.d<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (this.b.remove(r3) == false) goto L6;
        int r4 = g32.c.a;
        DegradeFeature r5 = d();
        Intrinsics.checkNotNullParameter(r5, "feature");
        ALogger.i("InteractivityDegradeLogger", "listener removed. feature: " + r5.name());
        return;
    }

    @Override // h32.c
    public final void b(h32.d<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (this.b.add(r3) == false) goto L9;
        T r0 = this.c;
        if (r0 == true) goto L7;
        r0 = (T) c(this.d);
    L7:
        r3.a(r0);
        int r4 = g32.c.a;
        DegradeFeature r5 = d();
        Intrinsics.checkNotNullParameter(r5, "feature");
        ALogger.i("InteractivityDegradeLogger", "new listener added. feature: " + r5.name());
        return;
    }

    public final void f(e32.a r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        F r0 = (F) e();
        if ((!Intrinsics.areEqual(this.d, r0)) == false) goto L8;
        T r1 = (T) c(r0);
        int r3 = g32.c.a;
        DegradeFeature r4 = d();
        F r5 = this.d;
        String r6 = String.valueOf(this.c);
        String r7 = r1.toString();
        Intrinsics.checkNotNullParameter(r4, "feature");
        Intrinsics.checkNotNullParameter(r5, "oldLevel");
        Intrinsics.checkNotNullParameter(r6, "oldConfig");
        Intrinsics.checkNotNullParameter(r0, "newLevel");
        Intrinsics.checkNotNullParameter(r7, "newConfig");
        ALogger.i("InteractivityDegradeLogger", "feature level update. feature: " + r4.name() + ", oldLevel: " + r5.name() + ", oldConfig: " + r6 + ", new level: " + r0.name() + ", new config: " + r7);
        int r8 = g32.d.a;
        DegradeFeature r9 = d();
        String r11 = this.d.name();
        String r13 = r0.name();
        Intrinsics.checkNotNullParameter(r10, "degradeRequest");
        Intrinsics.checkNotNullParameter(r9, "degradeFeature");
        Intrinsics.checkNotNullParameter(r11, "oldFeatureLevelName");
        Intrinsics.checkNotNullParameter(r13, "newFeatureLevelName");
        LinkedHashMap r14 = new LinkedHashMap();
        r14.put("degrade_scene", r10.a.name());
        r14.put("degrade_level", r10.b.logName());
        r14.put("old_feature_level", r11);
        r14.put("new_feature_level", r13);
        r14.put("degrade_feature", r9.name());
        j0.l().sendLog("livesdk_live_interactivity_degrade_feature_level_changed", r14, new Object[]{IRoom.class, x.class});
        this.d = r0;
        this.c = r1;
        Iterator r15 = CollectionsKt.toList(this.b).iterator();
    L6:
        if (r15.hasNext() == false) goto L10;
        ((h32.d) r15.next()).a(r1);
        goto L6
    L10:
        return;
    }

    public a(F r2, com.bytedance.android.livesdk.interactivity.b r3) {
        Intrinsics.checkNotNullParameter(r2, "curFeatureLevel");
        Intrinsics.checkNotNullParameter(r3, "statusHolder");
        this.d = r2;
        this.e = r3;
        this.b = new ConcurrentHashSet();
    }
}
