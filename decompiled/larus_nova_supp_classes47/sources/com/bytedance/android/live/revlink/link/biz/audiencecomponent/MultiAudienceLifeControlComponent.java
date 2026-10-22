package com.bytedance.android.live.revlink.link.biz.audiencecomponent;

import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiAnchorLinkContext;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.RevLinkBizContext;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h;
import com.bytedance.android.livesdk.link.model.ILinkerCloseContent;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridge;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridgeKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiAudienceLifeControlComponent implements com.bytedance.android.live.revlink.link.biz.service.d {
    public final CompositeDisposable a;
    public final String b;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b c;
    public final yz0.f d;
    public final MultiAnchorLinkContext e;
    public final c f;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.MultiAudienceLifeControlComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/i6;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/i6;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<i6, Unit> {
        public AnonymousClass1(MultiAudienceLifeControlComponent r8) {
            super(1, r8, MultiAudienceLifeControlComponent.class, "onLinkerMessage", "onLinkerMessage(Lcom/bytedance/android/livesdk/link/model/ILinkerMessage;)V", 0);
        }

        public final void invoke(i6 r8) {
            Intrinsics.checkNotNullParameter(r8, "p1");
            MultiAudienceLifeControlComponent r0 = (MultiAudienceLifeControlComponent) ((CallableReference) this).receiver;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r8, "$this$sceneExt");
            int r2 = (int) r8.getScene();
            if (r2 == 1) goto L7;
            if (r2 == 7) goto L7;
            boolean r3 = false;
        L8:
            if (r3 == false) goto L51;
            Intrinsics.checkNotNullParameter(r8, "$this$typeExt");
            int r4 = (int) r8.getType2();
            if (r4 == 2) goto L34;
            com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b r5 = null;
            if (r4 == 6) goto L25;
            if (r4 != 7) goto L52;
            String r1 = com.bytedance.android.live.revlink.link.biz.service.e.a.a(r0);
            StringBuilder r6 = new StringBuilder("MultiAudienceLifeControlComponent receive LINKER_LEAVE with userID: ");
            ILinkerLeaveContentBridge r7 = r8.getLeave();
            if (r7 == null) goto L19;
            String r9 = ILinkerLeaveContentBridgeKt.getUserIdEx(r7);
        L20:
            r6.append(r9);
            r6.append(" and context.roomOwnerID: ");
            r6.append(r0.getContext().eg());
            jy0.b.c(r1, r6.toString(), null, 4);
            i.H(r0).B(r8);
            ILinkerLeaveContentBridge r10 = r8.getLeave();
            if (r10 != null) goto L23;
            return;
        L23:
            if (Intrinsics.areEqual(ILinkerLeaveContentBridgeKt.getUserIdEx(r10), r0.getContext().eg()) == false) goto L45;
            MultiAudienceLifeControlComponent.a(r0, "receive_link_message_7");
            return;
        L45:
            return;
        L19:
            r9 = null;
            goto L20
        L52:
            return;
        L25:
            MultiAnchorLinkContext r12 = r0.e;
            Intrinsics.checkNotNullParameter(r8, "$this$linkerIdExt");
            r12.setAudienceChannelId(r8.getLinkerId());
            com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b r13 = r0.getContext();
            if ((r13 instanceof h) == false) goto L29;
            r5 = r13;
        L29:
            h r14 = (h) r5;
            if (r14 == null) goto L47;
            RevLinkBizContext r15 = r14.d;
            if (r15 == null) goto L48;
            Intrinsics.checkNotNullParameter(r8, "$this$linkerIdExt");
            r15.a(r8.getLinkerId());
            return;
        L48:
            return;
        L47:
            return;
        L34:
            Intrinsics.checkNotNullParameter(r8, "$this$linkerIdExt");
            if (r8.getLinkerId() != r0.getContext().G()) goto L53;
            ILinkerCloseContent r16 = r8.getClose();
            if (r16 != null) goto L40;
        L42:
            i.H(r0).A(r8);
            MultiAudienceLifeControlComponent.a(r0, "receive_link_message_2");
            return;
        L40:
            if (r16.getSource() != 1) goto L42;
            i.j(r0).a = true;
            return;
        L53:
            return;
        L51:
            return;
        L7:
            r3 = true;
            goto L8
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((i6) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAudienceComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        Observable r0 = yz0.h.a.a(this.d, CommonMessageTypeKt.a(com.bytedance.android.live.revenue.common.message.a.g), false, 6);
        final AnonymousClass1 r1 = new AnonymousClass1(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r0.subscribe(new a(r1)), this.a);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.a.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.d, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.b;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.d, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b getContext() {
        return this.c;
    }

    public static void a(MultiAudienceLifeControlComponent r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "reqSrc");
        jy0.b.f("ttlive_anchor_link", "MultiAudienceLinkWidget call finishInernal reqSrc=" + r6 + ", clearAfterSuccess=false", null, 4);     // Catch: Throwable -> L7
        r5.e.getAudienceUnloadSource().setValue(new com.bytedance.android.live.revenuelink.h.a(r6));     // Catch: Throwable -> L7
        r5.f.b.a();     // Catch: Throwable -> L7
        com.bytedance.android.live.revlink.impl.service.internal.a r7 = i.p(r5);     // Catch: Throwable -> L7
        if (r7 == null) goto L12;
        com.bytedance.android.live.revlink.impl.service.internal.b.a.a(r7, 64, false, 6);     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(r5), "MultiAudienceLifeControlComponent onDestroy crash with " + ExceptionsKt.stackTraceToString(th), null, 4);
    }

    public MultiAudienceLifeControlComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b r2, yz0.f r3, MultiAnchorLinkContext r4, c r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "messageService");
        Intrinsics.checkNotNullParameter(r4, "linkContext");
        Intrinsics.checkNotNullParameter(r5, "bizDataContext");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.a = new CompositeDisposable();
        this.b = "MultiAudienceLifeControlComponent";
    }
}
