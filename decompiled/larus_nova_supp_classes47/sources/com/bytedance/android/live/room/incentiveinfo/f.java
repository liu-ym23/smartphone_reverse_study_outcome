package com.bytedance.android.live.room.incentiveinfo;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.room.view.InterceptFrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements u81.e.a {
    public final /* synthetic */ View a;
    public final /* synthetic */ IncentiveInfoLayout b;
    public final /* synthetic */ u81.d c;
    public final /* synthetic */ u81.d d;
    public final /* synthetic */ Object e;

    public static final class a implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ f b;

        public a(View r1, f r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r0 = this.a;     // Catch: Throwable -> L12
            WeakReference<View> r1 = this.b.b.c;     // Catch: Throwable -> L12
            if (r1 == null) goto L5;
            View r2 = r1.get();     // Catch: Throwable -> L12
        L7:
            if ((!Intrinsics.areEqual(r0, r2)) == false) goto L15;
            UtilityKotlinExtentionsKt.t(this.a);     // Catch: Throwable -> L12
            InterceptFrameLayout r3 = x81.a.b(this.a);     // Catch: Throwable -> L12
            if (r3 == null) goto L19;
            r3.setIntercept(true);     // Catch: Throwable -> L12
            return;
        L19:
            return;
        L15:
            return;
        L5:
            r2 = null;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    @Override // u81.e.a
    public final void a() {
    }

    @Override // u81.e.a
    public final void b() {
    }

    @Override // u81.e.a
    public final void c() {
        u81.d r0 = this.d;
        if (r0 == null) goto L8;
        View r1 = r0.a();
        if (r1 == null) goto L9;
        this.b.post(new a(r1, this));
        return;
    L9:
        return;
    }

    @Override // u81.e.a
    public final void d() {
        IncentiveInfoLayout r0 = this.b;
        r0.c = new WeakReference(this.a);
    }

    public f(View r1, IncentiveInfoLayout r2, u81.d r3, u81.d r4, u81.c r5, Object r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }
}
