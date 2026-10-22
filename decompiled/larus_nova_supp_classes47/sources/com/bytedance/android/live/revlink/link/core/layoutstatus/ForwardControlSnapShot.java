package com.bytedance.android.live.revlink.link.core.layoutstatus;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.utils.b0;
import com.bytedance.android.live.revlink.impl.multianchor.connect.o;
import com.bytedance.android.live.revlink.impl.plantform.RevLinkMultiChannelDataContext;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.link.model.b7;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ForwardControlSnapShot implements c<List<? extends Long>>, com.bytedance.android.live.revlink.link.biz.service.j {
    public final CompositeDisposable a;
    public List<Long> b;
    public List<Long> c;
    public final com.bytedance.android.live.revlink.link.infra.rtcbiz.b d;
    public final d e;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a f;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.core.layoutstatus.ForwardControlSnapShot$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/connect/o;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/impl/multianchor/connect/o;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<o, Unit> {
        public AnonymousClass1(ForwardControlSnapShot r8) {
            super(1, r8, ForwardControlSnapShot.class, "onForwardInfoUpdate", "onForwardInfoUpdate(Lcom/bytedance/android/live/revlink/impl/multianchor/connect/RtcForwardData;)V", 0);
        }

        public final void invoke(o r2) {
            ForwardControlSnapShot r0 = (ForwardControlSnapShot) ((CallableReference) this).receiver;
            r0.getClass();
            if (r2 == null) goto L10;
            Map<Long, String> r3 = r2.a;
            if (r3 == null) goto L10;
            Set<Long> r4 = r3.keySet();
            if (r4 == null) goto L10;
            List<Long> r5 = CollectionsKt.toList(r4);
            if (r5 == null) goto L10;
        L11:
            r0.b = r5;
            r0.e.requestLayout();
            return;
        L10:
            r5 = CollectionsKt.emptyList();
            goto L11
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((o) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.core.layoutstatus.ForwardControlSnapShot$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/b7;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/b7;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<b7, Unit> {
        public AnonymousClass2(ForwardControlSnapShot r8) {
            super(1, r8, ForwardControlSnapShot.class, "onMultiChannelDataUpdate", "onMultiChannelDataUpdate(Lcom/bytedance/android/livesdk/link/model/IMultiChannelInfo;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((b7) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(b7 r2) {
            ((ForwardControlSnapShot) ((CallableReference) this).receiver).a(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.core.layoutstatus.ForwardControlSnapShot$attach$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass3(ForwardControlSnapShot r8) {
            super(0, r8, ForwardControlSnapShot.class, "onOnlineListChange", "onOnlineListChange()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m924invoke() {
            ForwardControlSnapShot r0 = (ForwardControlSnapShot) ((CallableReference) this).receiver;
            r0.getClass();
            RevLinkMultiChannelDataContext r1 = com.bytedance.android.live.revlink.link.biz.service.i.a0(r0);
            if (r1 == null) goto L10;
            LiveData<b7> r2 = r1.getMultiChannelData();
            if (r2 == null) goto L11;
            b7 r3 = (b7) r2.getValue();
            if (r3 == null) goto L12;
            r0.a(r3);
            return;
        L12:
            return;
        L11:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m924invoke();
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.c
    public final void attach() {
        com.bytedance.revenue.platform.api.core.rx.f.a(b0.b(this.d.getForwardInfo(), new AnonymousClass1(this)), this.a);
        RevLinkMultiChannelDataContext r0 = com.bytedance.android.live.revlink.link.biz.service.i.a0(this);
        if (r0 == null) goto L9;
        LiveData<b7> r1 = r0.getMultiChannelData();
        if (r1 == null) goto L9;
        Disposable r2 = UtilsKt.d(r1, new AnonymousClass2(this));
        if (r2 == null) goto L9;
        com.bytedance.revenue.platform.api.core.rx.f.a(r2, this.a);
    L9:
        com.bytedance.revenue.platform.api.core.rx.f.a(com.bytedance.android.live.revlink.link.biz.service.i.t(this).R(new AnonymousClass3(this)), this.a);
    }

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.c
    public final void detach() {
        this.a.clear();
        this.b = CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.f;
    }

    public final void a(b7 r3) {
        if (r3 != null) goto L4;
    L15:
        this.c = CollectionsKt.emptyList();
        return;
    L4:
        if (r3.getUseMultiChannel() != true) goto L15;
        Map r4 = r3.getChannelMap();
        if (r4 == null) goto L12;
        Set r5 = r4.keySet();
        if (r5 == null) goto L12;
        List<Long> r6 = CollectionsKt.toList(r5);
        if (r6 == null) goto L12;
    L13:
        this.c = r6;
        this.e.requestLayout();
        return;
    L12:
        r6 = CollectionsKt.emptyList();
        goto L13
    }

    public ForwardControlSnapShot(com.bytedance.android.live.revlink.link.infra.rtcbiz.b r2, h r3, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r4) {
        Intrinsics.checkNotNullParameter(r2, "rtcDataContext");
        Intrinsics.checkNotNullParameter(r3, "snapShotContext");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.a = new CompositeDisposable();
        this.b = CollectionsKt.emptyList();
        this.c = CollectionsKt.emptyList();
    }
}
