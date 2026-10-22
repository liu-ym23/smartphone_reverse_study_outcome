package com.bytedance.android.live.revlink.link.biz.audiencecomponent;

import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.link.model.bridge.LinkmicAIUserType;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import yz0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AiAssistantAudienceComponent implements com.bytedance.android.live.revlink.link.biz.service.e {
    public final String a;
    public final CompositeDisposable b;
    public final List<m11.a> c;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b d;
    public final com.bytedance.android.livesdk.revenue.service.room.c e;
    public final yz0.f f;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.AiAssistantAudienceComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/b;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.link.model.b, Unit> {
        public AnonymousClass1(AiAssistantAudienceComponent r8) {
            super(1, r8, AiAssistantAudienceComponent.class, "onJoinMessage", "onJoinMessage(Lcom/bytedance/android/livesdk/link/model/IAIAssistantJoinMessage;)V", 0);
        }

        public final void invoke(com.bytedance.android.livesdk.link.model.b r8) {
            Intrinsics.checkNotNullParameter(r8, "p1");
            AiAssistantAudienceComponent r0 = (AiAssistantAudienceComponent) ((CallableReference) this).receiver;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r8, "_message");
            jy0.b.c("RevenueLinkBaseComponent", "onJoinMessage, " + r8, null, 4);
            com.bytedance.android.livesdk.link.model.b r9 = r8.castToOrNull(com.bytedance.android.livesdk.link.model.b.class);
            if (r9 == null) goto L5;
            Integer r1 = r9.getAIUserType();
        L6:
            int r2 = LinkmicAIUserType.Assistant.getType();
            if (r1 != null) goto L10;
            return;
        L10:
            if (r1.intValue() != r2) goto L47;
            vh7.c r10 = r9.getAIUser();
            if (r10 == null) goto L15;
            com.bytedance.android.livesdk.link.model.e r12 = (com.bytedance.android.livesdk.link.model.e) r10.castToOrNull(com.bytedance.android.livesdk.link.model.e.class);
        L16:
            List<m11.a> r3 = r0.c;
            if ((r3 instanceof Collection) == true) goto L19;
        L21:
            Iterator r4 = ((ArrayList) r3).iterator();
        L23:
            if (r4.hasNext() == false) goto L31;
            String r5 = ((m11.a) r4.next()).a.getId();
            if (r12 == null) goto L27;
            String r6 = r12.getId();
        L29:
            if (Intrinsics.areEqual(r5, r6) == false) goto L23;
            boolean r7 = true;
        L32:
            if (r7 == true) goto L48;
            if (r12 == null) goto L36;
            ((ArrayList) r0.c).add(new m11.a(r12, new m11.b(r12.getId(), r12.getBelongUserId(), 0, 0)));
        L36:
            NextLiveData r13 = r0.getContext().getLinkDataSet().lj();
            List<m11.a> r14 = r0.c;
            ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
            Iterator r16 = ((ArrayList) r14).iterator();
        L38:
            if (r16.hasNext() == false) goto L40;
            r15.add(((m11.a) r16.next()).a);
            goto L38
        L40:
            r13.setValue(r15);
            return;
        L48:
            return;
        L27:
            r6 = null;
        L31:
            r7 = false;
            goto L32
        L19:
            if (((ArrayList) r3).isEmpty() == false) goto L21;
        L15:
            r12 = null;
            goto L16
        L47:
            return;
        L5:
            r1 = null;
            goto L6
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.livesdk.link.model.b) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.AiAssistantAudienceComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/c;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.link.model.c, Unit> {
        public AnonymousClass2(AiAssistantAudienceComponent r8) {
            super(1, r8, AiAssistantAudienceComponent.class, "onLeaveMessage", "onLeaveMessage(Lcom/bytedance/android/livesdk/link/model/IAIAssistantLeaveMessage;)V", 0);
        }

        public final void invoke(com.bytedance.android.livesdk.link.model.c r6) {
            Intrinsics.checkNotNullParameter(r6, "p1");
            AiAssistantAudienceComponent r0 = (AiAssistantAudienceComponent) ((CallableReference) this).receiver;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r6, "_message");
            final com.bytedance.android.livesdk.link.model.e r4 = null;
            jy0.b.c("RevenueLinkBaseComponent", "onLeaveMessage, " + r6, null, 4);
            com.bytedance.android.livesdk.link.model.c r7 = r6.castToOrNull(com.bytedance.android.livesdk.link.model.c.class);
            if (r7 == null) goto L5;
            Integer r1 = r7.getAIUserType();
        L6:
            int r2 = LinkmicAIUserType.Assistant.getType();
            if (r1 != null) goto L10;
            return;
        L10:
            if (r1.intValue() != r2) goto L23;
            vh7.c r8 = r7.getAIUser();
            if (r8 == null) goto L15;
            r4 = (com.bytedance.android.livesdk.link.model.e) r8.castToOrNull(com.bytedance.android.livesdk.link.model.e.class);
        L15:
            CollectionsKt.removeAll(r0.c, new AiAssistantAudienceComponent$onLeaveMessage$1(r4));
            NextLiveData r9 = r0.getContext().getLinkDataSet().lj();
            List<m11.a> r3 = r0.c;
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
            Iterator r10 = ((ArrayList) r3).iterator();
        L17:
            if (r10.hasNext() == false) goto L19;
            r5.add(((m11.a) r10.next()).a);
            goto L17
        L19:
            r9.setValue(r5);
            return;
        L23:
            return;
        L5:
            r1 = null;
            goto L6
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.livesdk.link.model.c) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkBaseComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        jy0.b.c("RevenueLinkBaseComponent", "attach", null, 4);
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.e(getContext().getLinkDataSet().T4(), false, new AiAssistantAudienceComponent$subscribeAiAssistantListFromEnter$1(this)), this.b);
        yz0.f r0 = this.f;
        com.bytedance.android.live.revenue.common.message.a r1 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r3 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r1, "$this$AI_ASSISTANT_JOIN_MESSAGE");
        Observable r2 = h.a.a(r0, (yh6.b) CommonMessageTypeKt.S.getValue(), false, 6);
        final AnonymousClass1 r4 = new AnonymousClass1(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r2.subscribe(new b(r4)), this.b);
        yz0.f r5 = this.f;
        Intrinsics.checkNotNullParameter(r1, "$this$AI_ASSISTANT_LEAVE_MESSAGE");
        Observable r6 = h.a.a(r5, (yh6.b) CommonMessageTypeKt.T.getValue(), false, 6);
        final AnonymousClass2 r7 = new AnonymousClass2(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r6.subscribe(new b(r7)), this.b);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.b.clear();
        ((ArrayList) this.c).clear();
        getContext().getLinkDataSet().lj().setValue(CollectionsKt.emptyList());
        getContext().getLinkDataSet().T4().setValue(CollectionsKt.emptyList());
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b getContext() {
        return this.d;
    }

    public AiAssistantAudienceComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b r2, com.bytedance.android.livesdk.revenue.service.room.c r3, yz0.f r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomService");
        Intrinsics.checkNotNullParameter(r4, "messageService");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.a = "AiAssistantComponent";
        this.b = new CompositeDisposable();
        this.c = new ArrayList();
    }
}
