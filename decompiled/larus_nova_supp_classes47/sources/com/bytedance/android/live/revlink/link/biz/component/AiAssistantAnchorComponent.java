package com.bytedance.android.live.revlink.link.biz.component;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.utils.w;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.bridge.LinkmicAIUserType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import fr2.a0;
import fr2.g0;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AiAssistantAnchorComponent extends com.bytedance.android.live.revenuelink.rtc.e implements com.bytedance.android.live.revlink.link.biz.service.e {
    public static final /* synthetic */ int o = 0;
    public final CompositeDisposable a;
    public final r41.a b;
    public String c;
    public boolean d;
    public boolean e;
    public final String f;
    public final List<m11.a> g;
    public final com.bytedance.android.live.revlink.link.biz.component.a h;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a i;
    public final com.bytedance.android.livesdk.revenue.service.room.c j;
    public final yz0.g k;
    public final yz0.f l;
    public final MultiRTCBizComponent m;
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.i n;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.AiAssistantAnchorComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/b;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.link.model.b, Unit> {
        public AnonymousClass1(AiAssistantAnchorComponent r8) {
            super(1, r8, AiAssistantAnchorComponent.class, "onJoinMessage", "onJoinMessage(Lcom/bytedance/android/livesdk/link/model/IAIAssistantJoinMessage;)V", 0);
        }

        public final void invoke(com.bytedance.android.livesdk.link.model.b r8) {
            Intrinsics.checkNotNullParameter(r8, "p1");
            AiAssistantAnchorComponent r0 = (AiAssistantAnchorComponent) ((CallableReference) this).receiver;
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
            if (r1.intValue() != r2) goto L68;
            boolean r3 = true;
            if (r0.c.length() != 0) goto L15;
            boolean r4 = true;
        L16:
            if (r4 == false) goto L25;
            com.bytedance.android.live.revenuelink.rtc.i r5 = com.bytedance.android.live.revlink.link.biz.service.i.f(r0.m);
            if (r5 == null) goto L21;
            String r6 = r5.getBusinessId();
            if (r6 == null) goto L21;
        L22:
            r0.c = r6;
            com.bytedance.android.live.revenuelink.rtc.i r7 = com.bytedance.android.live.revlink.link.biz.service.i.f(r0.m);
            if (r7 == null) goto L25;
            r7.g("linkmic_pk_ai_assistant");
        L21:
            r6 = "";
        L25:
            vh7.c r10 = r9.getAIUser();
            if (r10 == null) goto L28;
            com.bytedance.android.livesdk.link.model.e r12 = (com.bytedance.android.livesdk.link.model.e) r10.castToOrNull(com.bytedance.android.livesdk.link.model.e.class);
        L29:
            List<m11.a> r13 = r0.g;
            if ((r13 instanceof Collection) == true) goto L32;
        L34:
            Iterator r14 = ((ArrayList) r13).iterator();
        L36:
            if (r14.hasNext() == false) goto L44;
            String r15 = ((m11.a) r14.next()).a.getId();
            if (r12 == null) goto L40;
            String r16 = r12.getId();
        L42:
            if (Intrinsics.areEqual(r15, r16) == false) goto L36;
        L45:
            if (r3 == true) goto L69;
            if (r12 == null) goto L49;
            ((ArrayList) r0.g).add(new m11.a(r12, new m11.b(r12.getId(), r12.getBelongUserId(), 0, 0)));
        L49:
            NextLiveData r17 = r0.getContext().getLinkDataSet().lj();
            List<m11.a> r18 = r0.g;
            ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
            Iterator r20 = ((ArrayList) r18).iterator();
        L51:
            if (r20.hasNext() == false) goto L53;
            r19.add(((m11.a) r20.next()).a);
            goto L51
        L53:
            r17.setValue(r19);
            NextLiveData r22 = r0.getContext().getLinkDataSet().q2();
            List<m11.a> r23 = r0.g;
            ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
            Iterator r25 = ((ArrayList) r23).iterator();
        L55:
            if (r25.hasNext() == false) goto L57;
            r24.add(((m11.a) r25.next()).b);
            goto L55
        L57:
            r22.setValue(r24);
            com.bytedance.android.live.revenuelink.rtc.i r26 = com.bytedance.android.live.revlink.link.biz.service.i.f(r0.m);
            if (r26 == null) goto L66;
            r26.f();
            return;
        L66:
            return;
        L69:
            return;
        L40:
            r16 = null;
        L44:
            r3 = false;
            goto L45
        L32:
            if (((ArrayList) r13).isEmpty() == false) goto L34;
        L28:
            r12 = null;
            goto L29
        L15:
            r4 = false;
            goto L16
        L68:
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

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.AiAssistantAnchorComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/c;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.link.model.c, Unit> {
        public AnonymousClass2(AiAssistantAnchorComponent r8) {
            super(1, r8, AiAssistantAnchorComponent.class, "onLeaveMessage", "onLeaveMessage(Lcom/bytedance/android/livesdk/link/model/IAIAssistantLeaveMessage;)V", 0);
        }

        public final void invoke(com.bytedance.android.livesdk.link.model.c r8) {
            Intrinsics.checkNotNullParameter(r8, "p1");
            AiAssistantAnchorComponent r0 = (AiAssistantAnchorComponent) ((CallableReference) this).receiver;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r8, "_message");
            String r4 = null;
            jy0.b.c("RevenueLinkBaseComponent", "onLeaveMessage, " + r8, null, 4);
            com.bytedance.android.livesdk.link.model.c r9 = r8.castToOrNull(com.bytedance.android.livesdk.link.model.c.class);
            if (r9 == null) goto L5;
            Integer r1 = r9.getAIUserType();
        L6:
            int r2 = LinkmicAIUserType.Assistant.getType();
            if (r1 != null) goto L10;
            return;
        L10:
            if (r1.intValue() != r2) goto L55;
            vh7.c r3 = r9.getAIUser();
            if (r3 == null) goto L15;
            final com.bytedance.android.livesdk.link.model.e r5 = (com.bytedance.android.livesdk.link.model.e) r3.castToOrNull(com.bytedance.android.livesdk.link.model.e.class);
        L16:
            if (r5 == null) goto L56;
            CollectionsKt.removeAll(r0.g, new AiAssistantAnchorComponent$onLeaveMessage$1(r5));
            NextLiveData r6 = r0.getContext().getLinkDataSet().lj();
            List<m11.a> r7 = r0.g;
            ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator r12 = ((ArrayList) r7).iterator();
        L20:
            if (r12.hasNext() == false) goto L22;
            r10.add(((m11.a) r12.next()).a);
            goto L20
        L22:
            r6.setValue(r10);
            NextLiveData r13 = r0.getContext().getLinkDataSet().q2();
            List<m11.a> r14 = r0.g;
            ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
            Iterator r16 = ((ArrayList) r14).iterator();
        L24:
            if (r16.hasNext() == false) goto L26;
            r15.add(((m11.a) r16.next()).b);
            goto L24
        L26:
            r13.setValue(r15);
            com.bytedance.android.live.revenuelink.rtc.i r17 = com.bytedance.android.live.revlink.link.biz.service.i.f(r0.m);
            if (r17 == null) goto L29;
            r17.f();
        L29:
            String r18 = r9.getToast();
            if (r18 == null) goto L32;
            ToastUtil.b(r18, 0);
        L32:
            com.bytedance.android.livesdk.link.model.bridge.d r19 = r9.getAIUser();
            if (r19 == null) goto L36;
            r4 = r19.getBelongUserId();
        L36:
            if (Intrinsics.areEqual(r4, r0.getContext().Ab()) == false) goto L39;
            r0.getContext().getPkBaseLogger().b(r9.getLeaveReason());
        L39:
            if (((ArrayList) r0.g).isEmpty() == true) goto L41;
            return;
        L41:
            if (r0.c.length() <= 0) goto L43;
            boolean r20 = true;
        L44:
            if (r20 == false) goto L49;
            com.bytedance.android.live.revenuelink.rtc.i r22 = com.bytedance.android.live.revlink.link.biz.service.i.f(r0.m);
            if (r22 == null) goto L48;
            r22.g(r0.c);
        L48:
            r0.c = "";
        L49:
            r0.n(false);
            return;
        L43:
            r20 = false;
            goto L44
        L56:
            return;
        L15:
            r5 = null;
            goto L16
        L55:
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

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.AiAssistantAnchorComponent$attach$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/d;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/d;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.link.model.d, Unit> {
        public AnonymousClass3(AiAssistantAnchorComponent r8) {
            super(1, r8, AiAssistantAnchorComponent.class, "onSilenceStatus", "onSilenceStatus(Lcom/bytedance/android/livesdk/link/model/IAIAssistantSilenceStatusMessage;)V", 0);
        }

        public final void invoke(com.bytedance.android.livesdk.link.model.d r7) {
            Intrinsics.checkNotNullParameter(r7, "p1");
            AiAssistantAnchorComponent r0 = (AiAssistantAnchorComponent) ((CallableReference) this).receiver;
            int r1 = AiAssistantAnchorComponent.o;
            r0.getClass();
            Object r3 = null;
            jy0.b.c("RevenueLinkBaseComponent", "onSilenceStatus, " + r7, null, 4);
            com.bytedance.android.livesdk.link.model.d r8 = r7.castToOrNull(com.bytedance.android.livesdk.link.model.d.class);
            Iterator r2 = ((ArrayList) r0.g).iterator();
        L4:
            if (r2.hasNext() == false) goto L12;
            Object r4 = r2.next();
            String r5 = ((m11.a) r4).a.getId();
            if (r8 == null) goto L8;
            String r6 = r8.getAIUserId();
        L10:
            if (Intrinsics.areEqual(r5, r6) == false) goto L4;
            r3 = r4;
            goto L12
        L8:
            r6 = null;
        L12:
            m11.a r9 = (m11.a) r3;
            if (r9 == null) goto L34;
            m11.b r10 = r9.b;
            if (r8 == null) goto L20;
            Integer r12 = r8.getSilenceStatus();
            if (r12 == null) goto L20;
            int r13 = r12.intValue();
        L21:
            r10.f(r13);
            NextLiveData r14 = r0.getContext().getLinkDataSet().q2();
            List<m11.a> r15 = r0.g;
            ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
            Iterator r17 = ((ArrayList) r15).iterator();
        L23:
            if (r17.hasNext() == false) goto L25;
            r16.add(((m11.a) r17.next()).b);
            goto L23
        L25:
            r14.setValue(r16);
            com.bytedance.android.live.revenuelink.rtc.i r18 = com.bytedance.android.live.revlink.link.biz.service.i.f(r0.m);
            if (r18 == null) goto L33;
            r18.f();
            return;
        L33:
            return;
        L20:
            r13 = 0;
            goto L21
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.livesdk.link.model.d) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AiAssistantAnchorComponent a;

        public b(AiAssistantAnchorComponent r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (Intrinsics.areEqual((Boolean) sh6.c.b((sh6.b) r2), Boolean.TRUE) == false) goto L8;
            AiAssistantAnchorComponent r3 = this.a;
            if (r3.d == false) goto L9;
            r3.n(false);
            return;
        L9:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            ExtraResponse r2 = (ExtraResponse) r1;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
            com.bytedance.android.live.revenue.common.k.c(r2);
            r2.printStackTrace();
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
        yz0.f r0 = this.l;
        com.bytedance.android.live.revenue.common.message.a r1 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r2 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r1, "$this$AI_ASSISTANT_JOIN_MESSAGE");
        Observable r3 = yz0.h.a.a(r0, (yh6.b) CommonMessageTypeKt.S.getValue(), false, 6);
        final AnonymousClass1 r4 = new AnonymousClass1(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r3.subscribe(new e(r4)), this.a);
        yz0.f r5 = this.l;
        Intrinsics.checkNotNullParameter(r1, "$this$AI_ASSISTANT_LEAVE_MESSAGE");
        Observable r6 = yz0.h.a.a(r5, (yh6.b) CommonMessageTypeKt.T.getValue(), false, 6);
        final AnonymousClass2 r7 = new AnonymousClass2(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r6.subscribe(new e(r7)), this.a);
        yz0.f r8 = this.l;
        Intrinsics.checkNotNullParameter(r1, "$this$AI_ASSISTANT_SILENCE_STATUS");
        Observable r9 = yz0.h.a.a(r8, (yh6.b) CommonMessageTypeKt.U.getValue(), false, 6);
        final AnonymousClass3 r10 = new AnonymousClass3(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r9.subscribe(new e(r10)), this.a);
        this.n.g(this.h);
        com.bytedance.android.live.revenuelink.rtc.i r12 = com.bytedance.android.live.revlink.link.biz.service.i.f(this.m);
        if (r12 == null) goto L5;
        r12.g1(this);
    L5:
        com.bytedance.revenue.platform.api.core.rx.f.a(ld.c.a(getContext().getLinkDataSet().go()).subscribe(new b(this)), this.a);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.a.clear();
        this.c = "";
        this.n.k(this.h);
        getContext().getLinkDataSet().lj().setValue(CollectionsKt.emptyList());
        getContext().getLinkDataSet().q2().setValue(CollectionsKt.emptyList());
        getContext().getLinkDataSet().go().setValue(Boolean.FALSE);
        com.bytedance.android.live.revenuelink.rtc.i r0 = com.bytedance.android.live.revlink.link.biz.service.i.f(this.m);
        if (r0 == null) goto L5;
        r0.f();
    L5:
        List<m11.a> r1 = this.g;
        if ((r1 instanceof Collection) == true) goto L8;
    L10:
        Iterator r2 = ((ArrayList) r1).iterator();
    L12:
        if (r2.hasNext() == false) goto L16;
        if (Intrinsics.areEqual(((m11.a) r2.next()).a.getBelongUserId(), getContext().Ab()) == false) goto L12;
        boolean r3 = true;
    L17:
        if (r3 == false) goto L19;
        getContext().getPkBaseLogger().b("anchor_quit");
    L19:
        ((ArrayList) this.g).clear();
        this.e = false;
        n(false);
        return;
    L16:
        r3 = false;
        goto L17
    L8:
        if (((ArrayList) r1).isEmpty() == false) goto L10;
        goto L10
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
        return this.f;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.i;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void L(String r8) {
        Iterator r0 = ((ArrayList) this.g).iterator();
    L3:
        String r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((m11.a) r1).a.getLinkmicIdStr(), r8) == false) goto L3;
    L9:
        m11.a r3 = (m11.a) r1;
        if (r3 != null) goto L12;
        return;
    L12:
        com.bytedance.android.livesdk.link.model.e r9 = r3.a;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r4 = getContext().R8();
        if (r4 == null) goto L30;
        i11.b r5 = r4.getLinkUserCenter();
        if (r5 == null) goto L30;
        List<com.bytedance.android.livesdk.link.model.p> r6 = r5.getOnlineUserList();
        if (r6 == null) goto L30;
        Iterator<T> r7 = r6.iterator();
    L20:
        if (r7.hasNext() == false) goto L28;
        Object r10 = r7.next();
        IBaseUser r12 = ((com.bytedance.android.livesdk.link.model.p) r10).getUser();
        if (r12 == null) goto L24;
        String r13 = r12.getIdString();
    L26:
        if ((!Intrinsics.areEqual(r13, getContext().Ab())) == false) goto L20;
    L29:
        com.bytedance.android.livesdk.link.model.p r14 = (com.bytedance.android.livesdk.link.model.p) r10;
    L31:
        if (r14 == null) goto L35;
        IBaseUser r15 = r14.getUser();
        if (r15 == null) goto L35;
        String r16 = r15.getIdString();
    L36:
        if (r9 == null) goto L38;
        String r17 = r9.getBelongUserId();
    L40:
        if (Intrinsics.areEqual(r16, r17) == false) goto L78;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r18 = getContext().R8();
        if (r18 == null) goto L59;
        i11.b r19 = r18.getLinkUserCenter();
        if (r19 == null) goto L59;
        List<com.bytedance.android.livesdk.link.model.p> r20 = r19.getOnlineUserList();
        if (r20 == null) goto L59;
        Iterator<T> r22 = r20.iterator();
    L49:
        if (r22.hasNext() == false) goto L57;
        Object r23 = r22.next();
        IBaseUser r24 = ((com.bytedance.android.livesdk.link.model.p) r23).getUser();
        if (r24 == null) goto L53;
        String r25 = r24.getIdString();
    L55:
        if ((!Intrinsics.areEqual(r25, getContext().Ab())) == false) goto L49;
    L58:
        com.bytedance.android.livesdk.link.model.p r26 = (com.bytedance.android.livesdk.link.model.p) r23;
    L60:
        com.bytedance.android.live.revlink.impl.multianchor.ui.i r27 = this.n;
        if (r26 == null) goto L66;
        IBaseUser r28 = r26.getUser();
        if (r28 == null) goto L66;
        r2 = r28.getIdString();
    L66:
        if (r27.j(r2, "") == false) goto L79;
        k(r3, true);
        return;
    L79:
        return;
    L53:
        r25 = null;
        goto L55
    L57:
        r23 = null;
    L59:
        r26 = null;
        goto L60
    L78:
        return;
    L38:
        r17 = null;
    L35:
        r16 = null;
        goto L36
    L24:
        r13 = null;
        goto L26
    L28:
        r10 = null;
    L30:
        r14 = null;
        goto L31
    L8:
        r1 = null;
        goto L9
    }

    public final void n(boolean r8) {
        if (this.d != r8) goto L5;
        return;
    L5:
        this.d = r8;
        com.bytedance.android.live.revenuelink.rtc.i r1 = com.bytedance.android.live.revlink.link.biz.service.i.g(this);
        if (r1 == null) goto L9;
        r1.J0(r8, r8, false, false, false);
    L9:
        if (r8 == false) goto L11;
        ToastUtil.b("已使用流量提升流畅度", 0);
    L11:
        int r2 = w.a;
        if (v.a() == false) goto L19;
        int r3 = ToastUtil.a;
        if (r8 == false) goto L16;
        String r9 = "开启";
    L17:
        ToastUtil.b("弱网双发已经".concat(r9), 0);
        return;
    L16:
        r9 = "关闭";
        goto L17
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void C1(vc0.a r12, vc0.a[] r13) {
        if (r12 == null) goto L67;
        Object r14 = r12.b;
        if ((r14 instanceof xh6.c) == true) goto L6;
        xh6.c r15 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(a0.class), r12.a);
        if ((r15 instanceof a0) == true) goto L12;
        r15 = null;
    L12:
        a0 r16 = (a0) r15;
    L13:
        if (r16 == null) goto L76;
        int r17 = com.bytedance.live.kmp.util.b.a;
        com.bytedance.live.kmp.util.c r18 = com.bytedance.live.kmp.util.c.a;
        Context r0 = r18.getContext();
        Intrinsics.checkNotNullParameter(r0, "context");
        if (NetworkUtils.g(r0) == false) goto L68;
        Context r19 = r18.getContext();
        Intrinsics.checkNotNullParameter(r19, "context");
        if (NetworkUtils.e(r19) == false) goto L77;
        r16.T0();
        if (this.b.m2() <= 0) goto L23;
        return;
    L23:
        if (((ArrayList) this.g).isEmpty() == false) goto L25;
        return;
    L25:
        if (this.d == false) goto L27;
        return;
    L27:
        if (this.e == true) goto L78;
        HashMap<String, Integer> r110 = l51.a.a().get(getContext().Ab());
        if (r110 != null) goto L32;
        r110 = new HashMap();
    L32:
        Integer r1 = r110.get("last_show_ts");
        if (r1 != null) goto L35;
        r1 = 0;
    L35:
        int r2 = r1.intValue();
        Integer r3 = r110.get("freq_control_always");
        if (r3 != null) goto L38;
        r3 = 0;
    L38:
        int r4 = r3.intValue();
        Integer r5 = r110.get("cellular_open");
        if (r5 != null) goto L41;
        r5 = 0;
    L41:
        int r6 = r5.intValue();
        Integer r111 = r110.get("reject_count");
        if (r111 != null) goto L44;
        r111 = 0;
    L44:
        int r112 = r111.intValue();
        if (r6 != 1) goto L47;
        n(true);
        return;
    L47:
        if (r4 != 1) goto L49;
    L63:
        this.e = true;
        return;
    L49:
        if (r112 >= 4) goto L63;
        long r7 = r2;
        i97.a r113 = i97.a.a;
        if (r7 > ((System.currentTimeMillis() / ((long) WebcastRedirectException.UNKNOWN)) - ((long) 86400))) goto L63;
        Uri r114 = com.bytedance.revenue.platform.api.core.e.a(this.b.getSchema());
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L56
        cy0.e.a.getClass();     // Catch: Throwable -> L56
        cy0.j r9 = cy0.e.a.a;     // Catch: Throwable -> L56
        com.bytedance.android.scope.m.e.getClass();     // Catch: Throwable -> L56
        Object r10 = com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(vy0.b.class));     // Catch: Throwable -> L56
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L56
        Object r115 = Result.constructor-impl(((vy0.b) ((f80.a) r10)).U0(this.k.getContext(), r114, new AiAssistantAnchorComponent$showCellularEnhancedDialog$$inlined$runCatching$lambda$1(this, r114)));     // Catch: Throwable -> L56
    L58:
        Throwable r116 = Result.exceptionOrNull-impl(r115);
        if (r116 == null) goto L73;
        jy0.b.c("RevenueLinkBaseComponent", "showCellularEnhancedDialog, fail, " + r116, null, 4);
        int r20 = w.a;
        if (v.a() == false) goto L74;
        int r22 = ToastUtil.a;
        ToastUtil.b(r116.getMessage(), 0);
        return;
    L74:
        return;
    L73:
        return;
    L56:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r115 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L78:
        return;
    L77:
        return;
    L68:
        return;
    L76:
        return;
    L6:
        if ((r14 instanceof a0) == true) goto L8;
        r14 = null;
    L8:
        r16 = (a0) r14;
        goto L13
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void g(String r7, Boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "interactId");
        Intrinsics.checkNotNullParameter(r7, "interactId");
        long r0 = IRoomKtKt.getId(this.j.getRoomContext().getCommonRoom());
        List<m11.a> r9 = this.g;
        com.bytedance.android.live.revenuelink.rtc.i r2 = com.bytedance.android.live.revlink.link.biz.service.i.f(this.m);
        String r3 = this.b.c2();
        Intrinsics.checkNotNullParameter(r7, "interactID");
        Intrinsics.checkNotNullParameter(r9, "aiAssistantList");
        Intrinsics.checkNotNullParameter(r3, "configName");
        Iterator r10 = ((ArrayList) r9).iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Object r4 = r10.next();
        if (Intrinsics.areEqual(((m11.a) r4).a.getId(), r7) == false) goto L4;
    L10:
        if (((m11.a) r4) != null) goto L12;
        return;
    L12:
        if (r0 == 0) goto L22;
        if (r2 == null) goto L23;
        JSONObject r12 = new JSONObject();
        r12.put("room_id", r0);
        r12.put("remote_user_id", r7);
        r12.put("stream_index", 0);
        JSONObject r13 = new JSONObject();
        r13.put("config_name", r3);
        r13.put("config_info", r12);
        Unit r14 = Unit.INSTANCE;
        r2.N0(r13);
        return;
    L23:
        return;
    L22:
        return;
    L8:
        r4 = null;
        goto L10
    }

    public final void j(String r12, boolean r13) {
        r31.a r1 = getContext().getLinkNetwork();
        long r2 = IRoomKtKt.getId(this.j.getRoomContext().getCommonRoom());
        int r4 = getContext().getScene();
        long r5 = getContext().G();
        if (r13 == false) goto L5;
        int r14 = t11.a.a;
        int r7 = 1;
    L6:
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.a(r1.M(r2, r4, r5, r7, false, r12)).subscribe(c.a, d.a), this.a);
        return;
    L5:
        int r15 = t11.a.a;
        r7 = 2;
        goto L6
    }

    public final void k(m11.a r3, boolean r4) {
        String r0 = r3.a.getId();
        if (r0 == null) goto L5;
        j(r0, r4);
    L5:
        String r5 = r3.a.getLinkmicIdStr();
        if (r5 == null) goto L11;
        com.bytedance.android.live.revenuelink.rtc.i r1 = com.bytedance.android.live.revlink.link.biz.service.i.f(this.m);
        if (r1 == null) goto L12;
        r1.h(r5, r4, "mute anchor");
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void J(String[] r9, boolean[] r10, int[] r12) {
        if (r9 == null) goto L31;
        int r13 = r9.length;
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r13) goto L41;
        String r3 = r9[r1];
        int r4 = r2 + 1;
        Iterator<T> r5 = this.g.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((m11.a) r6).a.getLinkmicIdStr(), r3) == false) goto L7;
    L12:
        m11.a r7 = (m11.a) r6;
        if (r7 == null) goto L30;
        if (r10 == null) goto L19;
        int r8 = 1;
        if (r10[r2] != true) goto L19;
    L21:
        if (r7.b.e() == r8) goto L30;
        r7.b.g(r8);
        NextLiveData r14 = getContext().getLinkDataSet().q2();
        List<m11.a> r15 = this.g;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r17 = r15.iterator();
    L25:
        if (r17.hasNext() == false) goto L27;
        r16.add(((m11.a) r17.next()).b);
        goto L25
    L27:
        r14.setValue(r16);
        com.bytedance.android.live.revenuelink.rtc.i r18 = com.bytedance.android.live.revlink.link.biz.service.i.f(this.m);
        if (r18 == null) goto L30;
        r18.f();
    L19:
        r8 = 0;
    L30:
        r1 = r1 + 1;
        r2 = r4;
        goto L4
    L11:
        r6 = null;
        goto L12
    L41:
        return;
    }

    public AiAssistantAnchorComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r2, com.bytedance.android.livesdk.revenue.service.room.c r3, yz0.g r4, yz0.f r5, MultiRTCBizComponent r6, com.bytedance.android.live.revlink.link.domain.service.a r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomService");
        Intrinsics.checkNotNullParameter(r4, "newRoomService");
        Intrinsics.checkNotNullParameter(r5, "messageService");
        Intrinsics.checkNotNullParameter(r6, "rtcBizComponent");
        Intrinsics.checkNotNullParameter(r7, "muteManager");
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.l = r5;
        this.m = r6;
        this.n = r7;
        this.a = new CompositeDisposable();
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r8 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        r8.getClass();
        this.b = (r41.a) com.bytedance.android.live.revlink.impl.settings.dynamic.a.F.getValue(r8, com.bytedance.android.live.revlink.impl.settings.dynamic.a.a[30]);
        this.c = "";
        this.f = "AiAssistantComponent";
        this.g = new ArrayList();
        this.h = new com.bytedance.android.live.revlink.link.biz.component.a(this);
    }
}
