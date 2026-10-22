package com.bytedance.android.live.profit.profitCheck;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.privilege.ProfitCheckConfig;
import com.bytedance.android.live.revenue.core.util.h;
import com.bytedance.android.livesdk.message.model.hb;
import com.bytedance.android.scope.o;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import yz0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfitReportMessageService implements o {
    public final CompositeDisposable a;
    public final l b;

    public final class a implements Consumer {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.profitCheck.ProfitReportMessageService$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/hb;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/message/model/hb;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<hb, Unit> {
        public AnonymousClass1(ProfitReportMessageService r8) {
            super(1, r8, ProfitReportMessageService.class, "onReceiveMessage", "onReceiveMessage(Lcom/bytedance/android/livesdk/message/model/IProfitReportMessage;)V", 0);
        }

        public final void invoke(hb r6) {
            Intrinsics.checkNotNullParameter(r6, "p1");
            ((ProfitReportMessageService) ((CallableReference) this).receiver).getClass();
            ProfitCheckConfig r7 = r6.getProfitCheckConfig();
            if (r7 == null) goto L6;
            LinkedHashMap r0 = new LinkedHashMap();
            r0.put("trace_id", String.valueOf(System.currentTimeMillis() + Random.Default.nextLong()));
            boolean r1 = h.a;
            ((com.bytedance.android.live.profit.privilege.c) h.d(com.bytedance.android.live.profit.privilege.c.class)).w(r0, r7);
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((hb) r1);
            return Unit.INSTANCE;
        }
    }

    public final void onStart() {
        l r0 = this.b;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        RxUtilKt.c(yz0.h.a.a(r0, com.bytedance.android.live.revenue.common.message.b.N, false, 6).subscribe(new a(new AnonymousClass1(this))), this.a);
    }

    public final void onStop() {
        this.a.clear();
    }

    public ProfitReportMessageService(l r2) {
        Intrinsics.checkNotNullParameter(r2, "roomMessageService");
        this.b = r2;
        this.a = new CompositeDisposable();
    }
}
