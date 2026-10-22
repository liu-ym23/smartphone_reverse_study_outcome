package com.bytedance.android.anniex.lite.flow.base;

import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.lite.flow.base.dispatch.IAnnieXPreloadStrategyProvider;
import com.bytedance.android.anniex.lite.flow.base.model.AnnieXModel;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class b extends com.bytedance.android.anniex.lite.flow.base.model.c {
    public final String b;
    public final String c;
    public final CoroutineScope d;
    public final com.bytedance.android.anniex.lite.flow.base.model.a e;
    public final IAnnieXPreloadStrategyProvider f;

    public static final class a {
    }

    static {
    }

    public void e() {
        com.bytedance.android.anniex.lite.flow.base.model.b r0 = this.a;
        Iterator<AnnieXModel> r1 = r0.a.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().a();
        goto L4
    L6:
        r0.a.clear();
        CoroutineScopeKt.cancel$default(this.d, null, 1, null);
        com.bytedance.android.anniex.lite.flow.base.a r10 = com.bytedance.android.anniex.lite.flow.base.a.a;
        String r11 = this.c;
        monitor-enter(r10);
        Intrinsics.checkNotNullParameter(r11, "sessionId");     // Catch: Throwable -> L11
        com.bytedance.android.anniex.lite.flow.base.a.b.remove(r11);     // Catch: Throwable -> L11
        monitor-exit(r10);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public b(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        this.b = r10;
        this.c = r11;
        CoroutineScope r1 = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.d = r1;
        com.bytedance.android.anniex.lite.flow.base.a r0 = com.bytedance.android.anniex.lite.flow.base.a.a;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r11, "sessionId");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(this, "dispatchManager");     // Catch: Throwable -> L11
        com.bytedance.android.anniex.lite.flow.base.a.b.put(r11, this);     // Catch: Throwable -> L11
        monitor-exit(r0);
        com.bytedance.android.anniex.lite.flow.base.model.b r12 = this.a;
        if (com.bytedance.android.anniex.lite.flow.base.model.d.a != null) goto L9;
        com.bytedance.android.anniex.lite.flow.base.model.d.a = new com.bytedance.android.anniex.lite.flow.base.model.d();
    L9:
        com.bytedance.android.anniex.lite.flow.base.model.d r13 = com.bytedance.android.anniex.lite.flow.base.model.d.a;
        Intrinsics.checkNotNull(r13);
        this.e = new com.bytedance.android.anniex.lite.flow.base.model.a(r12, r13);
        AnnieXServiceCenter.a.getClass();
        this.f = (IAnnieXPreloadStrategyProvider) AnnieXServiceCenter.d(r10, IAnnieXPreloadStrategyProvider.class);
        BuildersKt.launch$default(r1, Dispatchers.getDefault(), null, new BaseAnnieXDispatchManager$releaseTask$1(this, null), 2, null);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
