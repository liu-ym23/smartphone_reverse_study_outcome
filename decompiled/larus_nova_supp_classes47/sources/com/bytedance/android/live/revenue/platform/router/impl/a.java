package com.bytedance.android.live.revenue.platform.router.impl;

import android.content.Context;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.android.live.revenue.platform.schema.api.UIHandleStatus;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;
import zz0.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements SingleOnSubscribe<j> {
    public final /* synthetic */ com.bytedance.android.live.revenue.platform.router.impl.b a;
    public final /* synthetic */ String b;
    public final /* synthetic */ i57.a c;
    public final /* synthetic */ BehaviorSubject d;
    public final /* synthetic */ j e;
    public final /* synthetic */ zz0.a f;

    /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.router.impl.a$a, reason: collision with other inner class name */
    public static final class C0104a<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ SingleEmitter b;

        public C0104a(a r1, SingleEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            String r6 = (String) r5;
            a r0 = this.a;
            vy0.b r1 = r0.a.c;
            Object r2 = r0.c.a(i57.e.f.a());
            Intrinsics.checkNotNull(r2);
            int r3 = com.bytedance.revenue.platform.api.core.e.a;
            Intrinsics.checkNotNullParameter(r6, "schemeString");
            HybridDialogImpl r7 = r1.U0((Context) r2, UriProtector.parse(r6), new BaseRouterServiceImpl$openHybridDialog$1$subscribe$1$1(this));
            if (r7 == null) goto L5;
            a r4 = this.a;
            r4.a.a.put(r4.e.getId(), new c(this.a.d, r7));
            r7.j0(new BaseRouterServiceImpl$openHybridDialog$1$subscribe$1$$special$$inlined$let$lambda$1(this));
        L6:
            this.b.onSuccess(this.a.e);
            return;
        L5:
            a r8 = this.a;
            r8.a.a.put(r8.e.getId(), new c(this.a.d, null));
            a r9 = this.a;
            BehaviorSubject r10 = r9.d;
            com.bytedance.android.live.revenue.platform.router.impl.b r12 = r9.a;
            UIHandleStatus.HybridStatus.HybridStatusType r13 = UIHandleStatus.HybridStatus.HybridStatusType.LOAD_FAILED;
            r12.getClass();
            r10.onNext(com.bytedance.android.live.revenue.platform.router.impl.b.E(r13, "hybrid dialog is null"));
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r1) {
            throw ((Throwable) r1);
        }
    }

    public final void subscribe(SingleEmitter<j> r4) {
        Intrinsics.checkNotNullParameter(r4, "emitter");
        String r0 = this.b;
        Object r1 = this.c.a(i57.e.f.a());
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNullParameter(r0, "url");
        Intrinsics.checkNotNullParameter((Context) r1, "context");
        Single.create(new e(r0)).subscribe(new C0104a(this, r4), b.a);
    }

    public a(com.bytedance.android.live.revenue.platform.router.impl.b r1, String r2, i57.a r3, BehaviorSubject r4, j r5, zz0.a r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
