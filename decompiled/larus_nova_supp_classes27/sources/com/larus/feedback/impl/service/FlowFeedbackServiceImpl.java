package com.larus.feedback.impl.service;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.larus.feedback.api.IFlowFeedbackService;
import com.larus.feedback.api.model.FlowDislikePanelConfig;
import com.larus.feedback.impl.dialog.DislikeFeedbackDialogFragment;
import com.larus.feedback.impl.gateway.FlowFeedbackRemoteGateway;
import com.larus.feedback.impl.manager.DefaultIMFeedbackManager;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p99.d;
import q99.i;
import q99.k;
import q99.l;
import q99.m;
import q99.n;
import tc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\nH\u0096@¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J,\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020 2\u001a\u0010!\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130#\u0012\u0004\u0012\u00020\u0013\u0018\u00010\"H\u0016J\u001a\u0010$\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020%H\u0002J\u0010\u0010)\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020%H\u0002J\u0014\u0010*\u001a\u0004\u0018\u00010\f2\b\u0010+\u001a\u0004\u0018\u00010\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/feedback/impl/service/FlowFeedbackServiceImpl;", "Lcom/larus/feedback/api/IFlowFeedbackService;", "<init>", "()V", "remoteGateway", "Lcom/larus/feedback/api/gateway/IFlowFeedbackRemoteGateway;", "deliveryParser", "Lcom/larus/feedback/impl/parser/FlowFeedbackDeliveryParser;", "managerCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/larus/feedback/api/manager/BaseIMFeedbackManager;", "collectRecentMessagesExtra", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindChatPage", "host", "Lcom/larus/feedback/api/model/FlowFeedbackHost;", "unbindChatPage", "", "cvsId", "onReceiveInAppNotification", "notify", "Lcom/larus/im/bean/InAppBannerNotify;", "tryQueryAndShowFeedbackNotification", "request", "Lcom/larus/feedback/api/model/FlowFeedbackContentRequest;", "createDislikeDialog", "Landroidx/fragment/app/DialogFragment;", "config", "Lcom/larus/feedback/api/model/FlowDislikePanelConfig;", "reportFeedback", "Lcom/larus/feedback/api/model/FlowFeedbackSubmitRequest;", "callback", "Lkotlin/Function1;", "Lcom/larus/network/bean/HttpDataResult;", "submitMessageFeedback", "Lcom/larus/feedback/api/model/FlowMessageFeedbackRequest;", "listener", "Lcom/larus/feedback/api/listener/IFeedbackListener;", "submitClickReportIfNeed", "buildSubmitRequest", "findActiveManager", "sectionId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowFeedbackServiceImpl implements IFlowFeedbackService {
    public static final /* synthetic */ int d = 0;
    public final FlowFeedbackRemoteGateway a;
    public final com.larus.feedback.impl.parser.c b;
    public final ConcurrentHashMap<String, WeakReference<d>> c;

    public static final class a {
    }

    public static final class b implements IIMCallback<Message> {
        public final /* synthetic */ o99.a a;
        public final /* synthetic */ m b;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r5) {
            Intrinsics.checkNotNullParameter(r5, "error");
            Intrinsics.checkNotNullParameter(r5, "error");
            o99.a r0 = this.a;
            if (r0 == null) goto L6;
            r0.a(this.b, new l(Integer.valueOf(r5.getCode()), r5.getTips()));
            return;
        }

        public final void onSuccess(Object r4) {
            Message r5 = (Message) r4;
            Intrinsics.checkNotNullParameter(r5, "result");
            o99.a r0 = this.a;
            if (r0 == null) goto L6;
            r0.g(this.b, new n(r5));
            return;
        }

        public b(o99.a r1, m r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public FlowFeedbackServiceImpl() {
        this.a = new FlowFeedbackRemoteGateway();
        this.b = new com.larus.feedback.impl.parser.c();
        this.c = new ConcurrentHashMap();
    }

    @Override // com.larus.feedback.api.IFlowFeedbackService
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        this.c.remove(r2);
    }

    @Override // com.larus.feedback.api.IFlowFeedbackService
    public final void c(e r7) {
        FLogger.a.d("FlowFeedbackServiceImpl", "onReceiveInAppNotification: " + r7);
        this.b.getClass();
        q99.e r8 = com.larus.feedback.impl.parser.c.b(r7);
        if (r8 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r8, "<this>");
        q99.d r0 = r8.f;
        if (r0 == null) goto L9;
        String r1 = r0.h();
        if (r1 == null) goto L9;
    L13:
        Collection<WeakReference<d>> r2 = this.c.values();
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L15:
        if (r4.hasNext() == false) goto L19;
        d r5 = (d) ((WeakReference) r4.next()).get();
        if (r5 == null) goto L15;
        r3.add(r5);
        goto L15
    L19:
        Iterator r6 = r3.iterator();
    L21:
        if (r6.hasNext() == false) goto L30;
        Object r9 = r6.next();
        d r10 = (d) r9;
        if (r10.e().b() == true) goto L25;
    L27:
        boolean r11 = false;
    L28:
        if (r11 == false) goto L21;
    L31:
        d r12 = (d) r9;
        if (r12 != null) goto L34;
        return;
    L34:
        r12.f(q99.e.a(r8, r12.e().c, null, null, 126));
        return;
    L25:
        if (Intrinsics.areEqual(r10.e().a(), r1) == false) goto L27;
        r11 = true;
        goto L28
    L30:
        r9 = null;
    L9:
        Map<String, String> r13 = r8.g;
        if (r13 == null) goto L12;
        r1 = r13.get("section_id");
        goto L13
    L12:
        r1 = null;
        goto L13
    }

    @Override // com.larus.feedback.api.IFlowFeedbackService
    public final DialogFragment d(FlowDislikePanelConfig r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        int r1 = DislikeFeedbackDialogFragment.g;
        Intrinsics.checkNotNullParameter(r4, "config");
        DislikeFeedbackDialogFragment r0 = new DislikeFeedbackDialogFragment();
        Bundle r2 = new Bundle();
        r2.putParcelable("arg_config", r4);
        r0.setArguments(r2);
        return r0;
    }

    @Override // com.larus.feedback.api.IFlowFeedbackService
    public final d e(i r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        DefaultIMFeedbackManager r0 = new DefaultIMFeedbackManager(r4, this.a);
        String r5 = r4.c;
        if (r5 == null) goto L5;
        this.c.put(r5, new WeakReference(r0));
    L5:
        return r0;
    }

    @Override // com.larus.feedback.api.IFlowFeedbackService
    public final Object f(Continuation<? super String> r2) {
        return RecentFeedbackMessageCollector.a.a(r2);
    }

    @Override // com.larus.feedback.api.IFlowFeedbackService
    public final void a(q99.c r5, i r6) {
        Intrinsics.checkNotNullParameter(r5, "request");
        Intrinsics.checkNotNullParameter(r6, "host");
        com.larus.feedback.impl.manager.a r2 = new com.larus.feedback.impl.manager.a(this.a);
        Intrinsics.checkNotNullParameter(r5, "request");
        Intrinsics.checkNotNullParameter(r6, "host");
        r2.query(r5, new com.larus.feedback.impl.manager.c(r2, r6));
    }

    @Override // com.larus.feedback.api.IFlowFeedbackService
    public final void g(m r11, o99.a r12) {
        Intrinsics.checkNotNullParameter(r11, "request");
        if (z2.a.getGlobalFeedbackConfig().getFeedbackEnable() == false) goto L34;
        yc9.m r1 = r11.a;
        List r2 = r1.e;
        if (r2 != null) goto L8;
    L10:
        r2 = null;
    L11:
        List r7 = r2;
        Integer r3 = r11.b;
        if (r3 == null) goto L14;
        int r4 = r3.intValue();
    L15:
        Integer r5 = Integer.valueOf(r4);
        String r6 = r11.c;
        if (r6 != null) goto L18;
        r6 = UUID.randomUUID().toString();
    L18:
        String r8 = r6;
        int r9 = r1.c.value;
        String r10 = r1.f;
        Map r13 = MapsKt.createMapBuilder();
        Map<String, String> r14 = r11.g;
        if (r14 != null) goto L21;
        r14 = MapsKt.emptyMap();
    L21:
        r13.putAll(r14);
        if (r13.containsKey("message_id") == true) goto L25;
        r13.put("message_id", r1.b);
    L25:
        if (r13.containsKey("section_id") == true) goto L28;
        r13.put("section_id", r11.d);
    L28:
        if (r13.containsKey("click_from") == true) goto L31;
        r13.put("click_from", r11.e);
    L31:
        if (r13.containsKey("call_id") == true) goto L33;
        r13.put("call_id", r11.f);
    L33:
        Unit r15 = Unit.INSTANCE;
        final k r16 = new k(r5, r8, r9, r7, r10, MapsKt.build(r13));
        Function1<? super dm9.a<Unit>, Unit> r17 = new com.larus.feedback.impl.service.a(r16);
        Intrinsics.checkNotNullParameter(r16, "request");
        this.a.b(r16, r17);
        goto L34
    L14:
        r4 = 0;
        goto L15
    L8:
        if ((!r2.isEmpty()) == false) goto L10;
    L34:
        com.larus.im.d.e().t(r11.a, new b(r12, r11));
    }
}
