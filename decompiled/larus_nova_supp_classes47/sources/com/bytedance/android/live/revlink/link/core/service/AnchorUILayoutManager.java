package com.bytedance.android.live.revlink.link.core.service;

import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.link.core.layoutstatus.LayoutSnapShotCollect;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AnchorUILayoutManager implements com.bytedance.android.scope.o, com.bytedance.android.live.revlink.link.biz.service.a {
    public final CompositeDisposable a;
    public final NextLiveData<o> b;
    public final l c;
    public long d;
    public o51.e e;
    public final yz0.f f;
    public final yz0.g g;
    public final b h;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g i;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/bytedance/android/livesdk/link/model/p;", "p1", "", "p2", "", "invoke", "(Ljava/util/List;I)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<List<? extends com.bytedance.android.livesdk.link.model.p>, Integer, Unit> {
        public AnonymousClass1(AnchorUILayoutManager r8) {
            super(2, r8, AnchorUILayoutManager.class, "onOnlineListChange", "onOnlineListChange(Ljava/util/List;I)V", 0);
        }

        public final void invoke(List<? extends com.bytedance.android.livesdk.link.model.p> r10, int r12) {
            Intrinsics.checkNotNullParameter(r10, "p1");
            AnchorUILayoutManager r13 = (AnchorUILayoutManager) ((CallableReference) this).receiver;
            o51.e r14 = r13.e;
            int r0 = r14.a.b;
            int r3 = o51.f.j.e.b;
            if (r0 != r3) goto L10;
            int r4 = r14.c.ordinal();
            int r5 = r13.e.d.ordinal();
            String r7 = o51.g.b(r13.e);
            o r15 = (o) r13.b.getValue();
            if (r15 != null) goto L8;
            r15 = new o(com.bytedance.revenue.platform.api.core.d.a(new Pair[0]));
        L8:
            r13.d(new r(r3, r4, r5, false, r7, r15), "onlineListChange");
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((List) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final void onStart() {
        l r0 = this.c;
        Observable r1 = yz0.h.a.a(r0.d, CommonMessageTypeKt.a(com.bytedance.android.live.revenue.common.message.a.g), false, 6);
        final LayoutChangeManager$attach$1 r2 = new LayoutChangeManager$attach$1(r0);
        com.bytedance.revenue.platform.api.core.rx.f.a(r1.subscribe(new m(r2)), r0.a);
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.g(r0.getContext().t(), new LayoutChangeManager$attach$2(r0)), r0.a);
        com.bytedance.revenue.platform.api.core.rx.f.a(com.bytedance.android.live.revlink.link.biz.service.i.t(this).m(new AnonymousClass1(this)), this.a);
    }

    public final void onStop() {
        l r0 = this.c;
        r0.a.clear();
        r0.b = false;
        this.a.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g getContext() {
        return this.i;
    }

    public final void a(o r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "layoutDetails");
        Intrinsics.checkNotNullParameter(r5, "source");
        jy0.b.c("xuzr_position", "updateLayoutDetails " + r4 + " from " + r5, null, 4);
        this.b.setValue(r4);
    }

    public final void d(r r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        if (r9 != null) goto L6;
        f(c.a(getContext()), "empty layoutInfo fallback to default " + c.a(getContext()) + " from " + r10);
        return;
    L6:
        a(r9.f, r10);
        y41.d r0 = y41.d.j;
        r0.getClass();
        if (((Boolean) y41.d.f.getValue(r0, y41.d.a[4])).booleanValue() == true) goto L10;
        jy0.b.c("AnchorUILayoutManager", "refuse change uiLayout for not support enlarge", null, 4);
        return;
    L10:
        String r1 = r9.e;
        String r2 = "";
        if (r1 != null) goto L13;
        r1 = "";
    L13:
        boolean r4 = true;
        if (r9.b == 1) goto L16;
        IAnchorUpdateLayoutContent.AnchorLayoutRange r3 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
    L17:
        int r5 = r9.c;
        if (r5 == 0) goto L29;
        if (r5 == 1) goto L28;
        if (r5 != 2) goto L22;
        IAnchorUpdateLayoutContent.UpdateAnchorLayoutType r6 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UnEnlargeAllStream;
    L30:
        int r7 = r9.a;
        if (r7 == 0) goto L53;
        if (r7 == 1) goto L51;
        if (r7 == 2) goto L36;
        o51.e r12 = c.a(getContext());
    L56:
        f(r12, r10);
        return;
    L36:
        if (IRoomKtKt.getStreamType(getContext().getRoom()) == LiveMode.SCREEN_RECORD) goto L40;
        r4 = false;
    L40:
        if (r4 == false) goto L46;
        boolean r13 = r9.d;
        Intrinsics.checkNotNullParameter(r1, "$this$linkerID");
        Intrinsics.checkNotNullParameter(r1, "$this$linkerID");
        String r8 = com.bytedance.android.live.revlink.link.biz.service.j.a.a(this, r1);
        if (r8 == null) goto L45;
        r2 = r8;
    L45:
        r12 = new o51.e.C0283e(r13, r1, r2);
        goto L56
    L46:
        Intrinsics.checkNotNullParameter(r1, "$this$linkerID");
        Intrinsics.checkNotNullParameter(r1, "$this$linkerID");
        String r14 = com.bytedance.android.live.revlink.link.biz.service.j.a.a(this, r1);
        if (r14 == null) goto L50;
        r2 = r14;
    L50:
        r12 = new o51.e.d(r1, r2, r3, r6);
        goto L56
    L51:
        r12 = new o51.e.c(r1, r1, r3, r6);
        goto L56
    L53:
        if (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.j.a(getContext()) == false) goto L55;
        r12 = h.a(this);
        goto L56
    L55:
        r12 = o51.e.f.e;
        goto L56
    L22:
        if (r5 == 3) goto L26;
        if (r5 == 4) goto L25;
        r6 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown;
        goto L30
    L25:
        r6 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UnEnlargeMyStream;
        goto L30
    L26:
        r6 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.EnlargeMyStream;
        goto L30
    L28:
        r6 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.EnlargeAllStream;
        goto L30
    L29:
        r6 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown;
        goto L30
    L16:
        r3 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeAllRoom;
        goto L17
    }

    public final void f(o51.e r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "uiLayout");
        Intrinsics.checkNotNullParameter(r9, "source");
        String r5 = null;
        jy0.b.c("AnchorUILayoutManager", "updateUILayout from " + this.e + " to " + r8 + ", source=" + r9, null, 4);
        if (this.e.a(r8) == false) goto L7;
        jy0.b.c("AnchorUILayoutManager", "updateUILayout reject for same from " + this.e + " to " + r8 + ", source=" + r9, null, 4);
        return;
    L7:
        if ((r8 instanceof o51.e.f) == false) goto L9;
    L12:
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r10 = com.bytedance.android.live.revlink.link.biz.service.i.B(this);
        UILayout r1 = o51.g.c(r8);
        String r2 = o51.g.b(r8);
        if (r8.c != IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeAllRoom) goto L17;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r3 = com.bytedance.android.live.revlink.link.biz.service.i.w(this);
        if (r3 == null) goto L18;
        r5 = r3.Me();
    L18:
        r10.C(r1, r2, r5);
    L19:
        this.e = r8;
        b r12 = this.h;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r8, "uiLayout");
        AnchorDynamicLayoutImpl r13 = r12.a;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r8, "uiLayout");
        LayoutSnapShotCollect r4 = r13.b;
        AnchorDynamicLayoutImpl$requestLayout$1 r6 = new AnchorDynamicLayoutImpl$requestLayout$1(r13);
        AnchorDynamicLayoutImpl$requestLayout$2 r7 = new AnchorDynamicLayoutImpl$requestLayout$2(r13);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r8, "uiLayout");
        Intrinsics.checkNotNullParameter(r6, "onResolve");
        Intrinsics.checkNotNullParameter(r7, "onReject");
        r4.k = r8;
        r4.a(r6, r7);
        return;
    L17:
        r5 = getContext().d.k;
        goto L18
    L9:
        if ((r8 instanceof o51.e.c) == true) goto L12;
        if (r8.a.a() == false) goto L19;
        goto L12
    }

    public final void c(String r17, boolean r18, boolean r19) {
        i97.a r1 = i97.a.a;
        long r2 = System.currentTimeMillis();
        long r3 = r2 - this.d;
        y41.d r5 = y41.d.j;
        r5.getClass();
        boolean r8 = false;
        if (r3 <= ((Number) y41.d.i.getValue(r5, y41.d.a[7])).longValue()) goto L5;
        this.d = r2;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L8;
        return;
    L8:
        l r6 = this.c;
        boolean r7 = !r19;
        IRoomSpecificSceneTypeInfo r9 = this.g.mo444getRoom().getSceneTypeInfo();
        if (r9 == null) goto L14;
        if (r9.isLandscapeVerticalRoom() != 1) goto L14;
        r8 = true;
    L14:
        if (r5.a(r8) == true) goto L19;
        if (Intrinsics.areEqual(this.e.a, o51.f.c.e) == false) goto L19;
        IAnchorUpdateLayoutContent.AnchorUIOperationType r10 = IAnchorUpdateLayoutContent.AnchorUIOperationType.OperationSmall;
    L28:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r10, "operateType");
        if (r6.b == true) goto L47;
        r6.b = true;
        long r12 = System.currentTimeMillis();
        if (r18 == false) goto L35;
        if (r7 == false) goto L35;
        IAnchorUpdateLayoutContent.UpdateAnchorLayoutType r13 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.EnlargeMyStream;
    L45:
        IAnchorUpdateLayoutContent.UpdateAnchorLayoutType r14 = r13;
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.a(r6.getContext().getLinkNetwork().z(r13.ordinal(), r6.getContext().getRoomID(), r6.getContext().G(), r17, r10.ordinal())).subscribe(new j(r6, r17, r14, r12), new k(r6, r17, r14, r12)), r6.a);
        return;
    L35:
        if (r18 == false) goto L38;
        if (r7 == true) goto L38;
        r13 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.EnlargeAllStream;
    L38:
        if (r18 == true) goto L41;
        if (r7 == false) goto L41;
        r13 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UnEnlargeMyStream;
    L41:
        if (r18 == true) goto L44;
        if (r7 == true) goto L44;
        r13 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UnEnlargeAllStream;
    L44:
        r13 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown;
        goto L45
    L47:
        return;
    L19:
        if (getContext().d.o != 1) goto L24;
        Intrinsics.checkNotNullParameter(this, "$this$anchorLinkFullEnlargeUtils");
        if (com.bytedance.android.live.revlink.link.biz.service.i.getContext(this).km().a() == false) goto L23;
        r10 = IAnchorUpdateLayoutContent.AnchorUIOperationType.OperationSmall;
        goto L28
    L23:
        r10 = IAnchorUpdateLayoutContent.AnchorUIOperationType.OperationUnknown;
        goto L28
    L24:
        Intrinsics.checkNotNullParameter(this, "$this$anchorLinkFullEnlargeUtils");
        if (com.bytedance.android.live.revlink.link.biz.service.i.getContext(this).km().a() == false) goto L27;
        r10 = IAnchorUpdateLayoutContent.AnchorUIOperationType.OperationSmall;
        goto L28
    L27:
        r10 = IAnchorUpdateLayoutContent.AnchorUIOperationType.Operation1V3Enlarge;
        goto L28
    L5:
        int r15 = ToastUtil.a;
        int r16 = w11.a.a;
        ToastUtil.a(2131920543, 0);
        r4 = false;
        goto L6
    }

    public AnchorUILayoutManager(yz0.f r2, yz0.g r3, b r4, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r5) {
        Intrinsics.checkNotNullParameter(r2, "messageService");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "dynamicLayoutManger");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.a = new CompositeDisposable();
        this.b = getContext().b;
        this.c = new l(this, r2, getContext());
        this.e = c.a(getContext());
    }
}
