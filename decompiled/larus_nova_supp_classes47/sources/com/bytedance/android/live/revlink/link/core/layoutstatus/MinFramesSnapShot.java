package com.bytedance.android.live.revlink.link.core.layoutstatus;

import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MinFramesSnapShot implements c<l> {
    public final l a;
    public final CompositeDisposable b;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g c;
    public final d d;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.core.layoutstatus.MinFramesSnapShot$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/link/core/layoutstatus/l;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/link/core/layoutstatus/l;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<l, Unit> {
        public AnonymousClass1(MinFramesSnapShot r8) {
            super(1, r8, MinFramesSnapShot.class, "onMinFramesInfoChange", "onMinFramesInfoChange(Lcom/bytedance/android/live/revlink/link/core/layoutstatus/MinFramesInfo;)V", 0);
        }

        public final void invoke(l r3) {
            MinFramesSnapShot r0 = (MinFramesSnapShot) ((CallableReference) this).receiver;
            if (r3 != null) goto L6;
            r0.getClass();
            return;
        L6:
            if (MinFramesSnapShot.a(r0.a, r3) == true) goto L11;
            r0.d.requestLayout();
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((l) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.c
    public final void attach() {
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.i(this.c.a, new AnonymousClass1(this)), this.b);
    }

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.c
    public final void detach() {
        this.b.clear();
    }

    public MinFramesSnapShot(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "snapShotContext");
        this.c = r2;
        this.d = r3;
        this.a = new l(1, null);
        this.b = new CompositeDisposable();
    }

    public static boolean a(l r5, l r6) {
        if (r5 != null) goto L7;
        if (r6 != null) goto L7;
        return true;
    L7:
        if (r5 == null) goto L26;
        if (r6 == null) goto L26;
        if (r5.a != r6.a) goto L26;
        Map<String, Integer> r7 = r5.b;
        if (r7 == null) goto L26;
        if (r6.b == null) goto L26;
        Iterator<Map.Entry<String, Integer>> r8 = r7.entrySet().iterator();
    L18:
        if (r8.hasNext() == false) goto L25;
        Map.Entry<String, Integer> r2 = r8.next();
        String r3 = r2.getKey();
        int r4 = r2.getValue().intValue();
        Integer r9 = r6.b.get(r3);
        if (r9 == null) goto L24;
        if (r9.intValue() == r4) goto L18;
    L24:
        return false;
    L25:
        return true;
    L26:
        return false;
    }
}
