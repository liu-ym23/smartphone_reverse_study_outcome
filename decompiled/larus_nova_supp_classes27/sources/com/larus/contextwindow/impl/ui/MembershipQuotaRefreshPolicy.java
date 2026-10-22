package com.larus.contextwindow.impl.ui;

import androidx.lifecycle.LifecycleCoroutineScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class MembershipQuotaRefreshPolicy {
    public final CoroutineScope a;
    public final Function0<Long> b;
    public final Function1<Continuation<? super Unit>, Object> c;
    public boolean d;
    public Long e;
    public Long f;
    public Job g;

    /* JADX INFO: renamed from: com.larus.contextwindow.impl.ui.MembershipQuotaRefreshPolicy$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Long> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        public final Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m25invoke() {
            return invoke();
        }
    }

    public final void a() {
        this.d = false;
        Job r0 = this.g;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.g = null;
    }

    public final void b() {
        Job r0 = this.g;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.g = null;
        if (this.d == true) goto L8;
        return;
    L8:
        Long r1 = this.e;
        if (r1 == null) goto L18;
        long r5 = r1.longValue();
        Long r2 = this.f;
        if (r2 != null) goto L14;
    L16:
        long r3 = RangesKt.coerceAtLeast(r5 - ((Number) this.b.invoke()).longValue(), 0);
        this.g = BuildersKt.launch$default(this.a, null, null, new MembershipQuotaRefreshPolicy$scheduleDeadline$1(r3, this, r5, null), 3, null);
        return;
    L14:
        if (r2.longValue() != r5) goto L16;
        return;
    }

    public MembershipQuotaRefreshPolicy(LifecycleCoroutineScope r3, Function1 r4) {
        AnonymousClass1 r0 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r0, "nowMillis");
        Intrinsics.checkNotNullParameter(r4, "refresh");
        this.a = r3;
        this.b = r0;
        this.c = r4;
    }
}
