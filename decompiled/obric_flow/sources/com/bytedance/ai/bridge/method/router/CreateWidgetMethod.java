package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.utils.ConvertUtils;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.model.s;
import com.google.gson.JsonElement;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J{\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018Jt\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0082@¢\u0006\u0004\b\u0017\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ-\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/CreateWidgetMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsCreateWidgetMethodIDL;", "<init>", "()V", "Lcom/bytedance/ai/model/AppletRuntime;", "appletRuntime", "Lcom/bytedance/ai/bridge/method/router/AbsCreateWidgetMethodIDL$CreateWidgetParamModel;", LynxResourceModule.PARAMS_KEY, "Lcom/bytedance/ai/model/objects/PageInfo;", "pageInfo", "", "conversationId", "", "suggests", "", "extra", "suggestsV2", "", "runningInWorker", "Lo1/f;", "Lcom/bytedance/ai/bridge/method/router/AbsCreateWidgetMethodIDL$CreateWidgetResultModel;", "callback", "", "generateWidgetMessage", "(Lcom/bytedance/ai/model/AppletRuntime;Lcom/bytedance/ai/bridge/method/router/AbsCreateWidgetMethodIDL$CreateWidgetParamModel;Lcom/bytedance/ai/model/objects/PageInfo;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/util/List;ZLo1/f;)V", "questionId", "(Lcom/bytedance/ai/model/AppletRuntime;Ljava/lang/String;Lcom/bytedance/ai/model/objects/PageInfo;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Lo1/f;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mustRunInMain", "()Z", "Ln1/c;", "bridgeContext", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/router/AbsCreateWidgetMethodIDL$CreateWidgetParamModel;Lo1/f;)V", "Companion", "com/bytedance/ai/bridge/method/router/d", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CreateWidgetMethod extends AbsCreateWidgetMethodIDL {
    public static final d Companion = null;
    private static final String TAG = "CreateWidgetMethod";

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.router.CreateWidgetMethod$generateWidgetMessage$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.router.CreateWidgetMethod$generateWidgetMessage$1", f = "CreateWidgetMethod.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CreateWidgetMethod f1927b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppletRuntime f1928c;
        public final /* synthetic */ String d;
        public final /* synthetic */ PageInfo e;
        public final /* synthetic */ String f;
        public final /* synthetic */ List g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Map f1929h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ List f1930i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ o1.f f1931j;

        public AnonymousClass1(CreateWidgetMethod r5, AppletRuntime r10, String r11, PageInfo r12, String r13, List r14, Map r15, List r16, o1.f r17, Continuation r18) {
            this.f1927b = r5;
            this.f1928c = r10;
            this.d = r11;
            this.e = r12;
            this.f = r13;
            this.g = r14;
            this.f1929h = r15;
            this.f1930i = r16;
            this.f1931j = r17;
            super(2, r18);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object r12, Continuation r13) {
            return new AnonymousClass1(this.f1927b, this.f1928c, this.d, this.e, this.f, this.g, this.f1929h, this.f1930i, this.f1931j, r13);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.f1926a;
            if (r10 == 0) goto L8;
            if (r10 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            CreateWidgetMethod r11 = this.f1927b;
            AppletRuntime r13 = this.f1928c;
            String r14 = this.d;
            PageInfo r15 = this.e;
            String r16 = this.f;
            List r17 = this.g;
            Map r18 = this.f1929h;
            List r19 = this.f1930i;
            o1.f r20 = this.f1931j;
            this.f1926a = 1;
            if (CreateWidgetMethod.access$generateWidgetMessage(r11, r13, r14, r15, r16, r17, r18, r19, r20, this) != r5) goto L12;
            return r5;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.router.CreateWidgetMethod$generateWidgetMessage$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.router.CreateWidgetMethod$generateWidgetMessage$2", f = "CreateWidgetMethod.kt", i = {}, l = {159, 166}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbsCreateWidgetMethodIDL.CreateWidgetParamModel f1933b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o1.f f1934c;
        public final /* synthetic */ CreateWidgetMethod d;
        public final /* synthetic */ AppletRuntime e;
        public final /* synthetic */ PageInfo f;
        public final /* synthetic */ String g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ List f1935h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Map f1936i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ List f1937j;

        public AnonymousClass2(AbsCreateWidgetMethodIDL.CreateWidgetParamModel r5, o1.f r10, CreateWidgetMethod r11, AppletRuntime r12, PageInfo r13, String r14, List r15, Map r16, List r17, Continuation r18) {
            this.f1933b = r5;
            this.f1934c = r10;
            this.d = r11;
            this.e = r12;
            this.f = r13;
            this.g = r14;
            this.f1935h = r15;
            this.f1936i = r16;
            this.f1937j = r17;
            super(2, r18);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object r12, Continuation r13) {
            return new AnonymousClass2(this.f1933b, this.f1934c, this.d, this.e, this.f, this.g, this.f1935h, this.f1936i, this.f1937j, r13);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.f1932a;
            String r11 = "";
            if (r10 != 0) goto L5;
            ResultKt.throwOnFailure(r12);
            JsonElement r13 = this.f1933b.getContext().get("questionId");
            if (r13 == null) goto L17;
            String r14 = r13.getAsString();
        L18:
            if (r14 != null) goto L20;
        L23:
            JsonElement r15 = this.f1933b.getContext().get("msgId");
            if (r15 == null) goto L27;
            String r16 = r15.getAsString();
            if (r16 == null) goto L27;
        L29:
            if (r16.length() != 0) goto L36;
            Intrinsics.checkNotNullParameter(CreateWidgetMethod.TAG, "tag");
            t0.d r17 = com.bytedance.ai.utils.c.f2846a;
            if (r17 == null) goto L33;
            r17.e(CreateWidgetMethod.TAG, "CreateWidget error, msgId is empty");
        L33:
            this.f1934c.a("CreateWidget error, msgId is empty");
            return Unit.INSTANCE;
        L36:
            if (r11.length() != 0) goto L42;
            Intrinsics.checkNotNullParameter(CreateWidgetMethod.TAG, "tag");
            t0.d r18 = com.bytedance.ai.utils.c.f2846a;
            if (r18 == null) goto L40;
            r18.e(CreateWidgetMethod.TAG, "CreateWidget error, questionId is empty");
        L40:
            this.f1934c.a("CreateWidget error, questionId is empty");
            return Unit.INSTANCE;
        L42:
            String r19 = r11;
        L43:
            CreateWidgetMethod r20 = this.d;
            AppletRuntime r21 = this.e;
            PageInfo r22 = this.f;
            String r110 = this.g;
            List r23 = this.f1935h;
            Map r24 = this.f1936i;
            List r25 = this.f1937j;
            o1.f r26 = this.f1934c;
            this.f1932a = 2;
            if (CreateWidgetMethod.access$generateWidgetMessage(r20, r21, r19, r22, r110, r23, r24, r25, r26, this) != r5) goto L47;
            return r5;
        L47:
            return Unit.INSTANCE;
        L27:
            r16 = "";
            goto L29
        L20:
            if (r14.length() == 0) goto L23;
            r19 = r14;
            goto L43
        L17:
            r14 = null;
            goto L18
        L5:
            if (r10 == 1) goto L10;
            if (r10 != 2) goto L9;
            ResultKt.throwOnFailure(r12);
            goto L47
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r12);
            String r111 = (String) r12;
            if (r111 == null) goto L36;
            r11 = r111;
            goto L36
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.router.CreateWidgetMethod$generateWidgetMessage$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.router.CreateWidgetMethod", f = "CreateWidgetMethod.kt", i = {0, 0, 0, 0}, l = {181}, m = "generateWidgetMessage", n = {"questionId", "pageInfo", "conversationId", "callback"}, s = {"L$0", "L$1", "L$2", "L$3"})
    public static final class AnonymousClass3 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PageInfo f1939b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f1940c;
        public o1.f d;
        public /* synthetic */ Object e;
        public final /* synthetic */ CreateWidgetMethod f;
        public int g;

        public AnonymousClass3(CreateWidgetMethod r5, Continuation r10) {
            this.f = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            this.e = r11;
            this.g |= Integer.MIN_VALUE;
            return CreateWidgetMethod.access$generateWidgetMessage(this.f, null, null, null, null, null, null, null, null, this);
        }
    }

    static {
        Companion = new d();
    }

    public CreateWidgetMethod() {
    }

    public static final /* synthetic */ Object access$generateWidgetMessage(CreateWidgetMethod r5, AppletRuntime r10, String r11, PageInfo r12, String r13, List r14, Map r15, List r16, o1.f r17, Continuation r18) {
        return r5.generateWidgetMessage(r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public static /* synthetic */ Unit b(o1.f r5, AbsCreateWidgetMethodIDL.CreateWidgetParamModel r10, n1.c r11, CreateWidgetMethod r12, AppletRuntime r13) {
        return handle$lambda$2(r5, r10, r11, r12, r13);
    }

    private final void generateWidgetMessage(AppletRuntime r14, AbsCreateWidgetMethodIDL.CreateWidgetParamModel r15, PageInfo r16, String r17, List<String> r18, Map<String, String> r19, List<String> r20, boolean r21, o1.f r22) {
        String r5 = "generateWidgetMessage runningInWorker=" + r21 + " afterBotReply=" + r15.getAfterBotReply() + " context=" + r15.getContext() + " pageInfo=" + r16;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r10 = com.bytedance.ai.utils.c.f2846a;
        if (r10 == null) goto L5;
        r10.i(TAG, r5);
    L5:
        if (r21 == true) goto L7;
        BuildersKt.launch$default(h0.a(t2.b.f22089a), null, null, new AnonymousClass2(r15, r22, this, r14, r16, r17, r18, r19, r20, null), 3, null);
        return;
    L7:
        if (Intrinsics.areEqual(r15.getAfterBotReply(), Boolean.FALSE) == false) goto L24;
        JsonElement r11 = r15.getContext().get("questionId");
        if (r11 == null) goto L12;
        String r12 = r11.getAsString();
    L11:
        String r13 = r12;
        if (r13 != null) goto L15;
    L19:
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r23 = com.bytedance.ai.utils.c.f2846a;
        if (r23 == null) goto L22;
        r23.e(TAG, "CreateWidget error, questionId is empty.");
    L22:
        r22.a("CreateWidget error, questionId is empty.");
        return;
    L15:
        if (r13.length() == 0) goto L19;
        BuildersKt.launch$default(h0.a(t2.b.f22089a), null, null, new AnonymousClass1(this, r14, r13, r16, r17, r18, r19, r20, r22, null), 3, null);
        return;
    L12:
        r12 = null;
        goto L11
    L24:
        JsonElement r24 = r15.getContext().get("callbackId");
        if (r24 == null) goto L28;
        String r25 = r24.getAsString();
        if (r25 == null) goto L28;
    L30:
        if (r25.length() != 0) goto L36;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r26 = com.bytedance.ai.utils.c.f2846a;
        if (r26 == null) goto L34;
        r26.e(TAG, "CreateWidget error, callbackId is empty");
    L34:
        r22.a("CreateWidget error, callbackId is empty");
        return;
    L36:
        r14.getClass();
        Intrinsics.checkNotNullParameter(r16, "pageInfo");
        Intrinsics.checkNotNullParameter(r25, "callbackID");
        if (r14.f2208t.get(r25) != null) goto L44;
        Intrinsics.checkNotNullParameter("WorkerRuntime", "tag");
        t0.d r27 = com.bytedance.ai.utils.c.f2846a;
        if (r27 == null) goto L41;
        r27.e("WorkerRuntime", "CreateWidget error, No found callback.");
    L41:
        Intrinsics.checkNotNullParameter("No found callback.", "message");
        r22.a("No found callback.");
        Unit r28 = Unit.INSTANCE;
        return;
    L44:
        throw new ClassCastException();
    L28:
        r25 = "";
        goto L30
    }

    private static final Unit handle$lambda$2(o1.f r30, AbsCreateWidgetMethodIDL.CreateWidgetParamModel r31, n1.c r32, CreateWidgetMethod r33, AppletRuntime r34) {
        if (r34 != null) goto L9;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r5 = com.bytedance.ai.utils.c.f2846a;
        if (r5 == null) goto L7;
        r5.e(TAG, "appletRuntime is null");
    L7:
        r30.a("appletRuntime is null");
        return Unit.INSTANCE;
    L9:
        String r10 = r31.getWidgetName();
        JsonElement r11 = r31.getContext().get("botId");
        if (r11 == null) goto L15;
        String r12 = r11.getAsString();
        if (r12 == null) goto L15;
        String r16 = r12;
    L16:
        n1.a r13 = (n1.a) r32;
        m1.j r14 = (m1.j) r13.b(m1.j.class);
        ContainerType r15 = null;
        if (r14 == null) goto L19;
        ContainerType r17 = r14.d();
    L21:
        if (r17 != ContainerType.f1801c) goto L23;
        w0.f r18 = (w0.f) r13.b(w0.f.class);
    L23:
        JsonElement r19 = r31.getContext().get("conversationId");
        if (r19 == null) goto L27;
        String r20 = r19.getAsString();
        if (r20 == null) goto L27;
    L28:
        PageInfo r21 = new PageInfo(r10, r31.getWidgetData(), ConvertUtils.toJavaOnlyMap(r31.getContext()), null, PageType.WIDGET_PAGE, r16, r10, null, null, 0.0d, false, null, null, null, null, null, 65408, null);
        z2.d.b("applet_jsb_create_widget", new e(r31, r34, r10, r21));
        m1.j r22 = (m1.j) r13.b(m1.j.class);
        if (r22 == null) goto L32;
        r15 = r22.d();
    L32:
        if (r15 != ContainerType.d) goto L35;
        boolean r23 = true;
    L36:
        r33.generateWidgetMessage(r34, r31, r21, r20, r31.getSuggests(), r31.getExtra(), r31.getSuggestsV2(), r23, r30);
        return Unit.INSTANCE;
    L35:
        r23 = false;
    L27:
        r20 = "";
        goto L28
    L19:
        r17 = null;
    L15:
        r16 = "";
        goto L16
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, o1.f r11) {
        handle(r5, (AbsCreateWidgetMethodIDL.CreateWidgetParamModel) r10, r11);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public boolean mustRunInMain() {
        return true;
    }

    public void handle(n1.c r10, AbsCreateWidgetMethodIDL.CreateWidgetParamModel r11, o1.f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        n1.a r5 = (n1.a) r10;
        s r13 = (s) r5.b(s.class);
        if (r13 != null) goto L9;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L7;
        r14.e(TAG, "appletRuntimeProvider is null");
    L7:
        r12.a("appletRuntimeProvider is null");
        return;
    L9:
        r13.a(new a2.c(2, r12, r11, r5, this));
    }

    private final Object generateWidgetMessage(AppletRuntime r5, String r10, PageInfo r11, String r12, List<String> r13, Map<String, String> r14, List<String> r15, o1.f r16, Continuation<? super Unit> r17) {
        if ((r17 instanceof AnonymousClass3) == false) goto L7;
        AnonymousClass3 r18 = (AnonymousClass3) r17;
        int r19 = r18.g;
        if ((r19 & Integer.MIN_VALUE) == 0) goto L7;
        r18.g = r19 - Integer.MIN_VALUE;
    L8:
        Object r20 = r18.e;
        Object r21 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r22 = r18.g;
        if (r22 == 0) goto L14;
        if (r22 != 1) goto L13;
        r16 = r18.d;
        r12 = r18.f1940c;
        r11 = r18.f1939b;
        r10 = r18.f1938a;
        ResultKt.throwOnFailure(r20);
    L34:
        Boolean r23 = (Boolean) r20;
        String r24 = "generateWidgetMessage result " + r23;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r25 = com.bytedance.ai.utils.c.f2846a;
        if (r25 == null) goto L38;
        r25.d(TAG, r24);
    L38:
        if (Intrinsics.areEqual(r23, Boxing.boxBoolean(true)) == false) goto L41;
        Intrinsics.checkNotNullParameter(AbsCreateWidgetMethodIDL.CreateWidgetResultModel.class, "<this>");
        r16.b((ResultModel) com.lynx.tasm.behavior.ui.utils.e.c(AbsCreateWidgetMethodIDL.CreateWidgetResultModel.class), "");
    L45:
        return Unit.INSTANCE;
    L41:
        if (r23 != null) goto L43;
        StringBuilder r26 = com.lynx.tasm.utils.e.b("SaveBotReplyRequest timeout, questionId: ", r10, ", botId: ");
        r26.append(r11.getBotId());
        r26.append(", convId: ");
        r26.append(r12);
        r26.append(", timeoutInterval: 10000");
        r16.a(r26.toString());
        goto L45
    L43:
        StringBuilder r27 = com.lynx.tasm.utils.e.b("SaveBotReplyRequest API failed, questionId: ", r10, ", botId: ");
        r27.append(r11.getBotId());
        r27.append(", convId: ");
        r27.append(r12);
        r27.append(", error: Http Error");
        r16.a(r27.toString());
        goto L45
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r20);
        r18.f1938a = r10;
        r18.f1939b = r11;
        r18.f1940c = r12;
        r18.d = r16;
        r18.g = 1;
        ArrayList r28 = r5.f2197h.N;
        if (r28 == null) goto L28;
        Iterator r29 = r28.iterator();
    L18:
        if (r29.hasNext() == false) goto L26;
        Object r30 = r29.next();
        Widget r31 = (Widget) r30;
        if (com.bytedance.ai.utils.c.l(r31.F) == false) goto L22;
        String r32 = r31.F;
    L24:
        if (Intrinsics.areEqual(r32, r11.getPageId()) == false) goto L18;
    L27:
        Widget r33 = (Widget) r30;
    L29:
        if (r33 == null) goto L31;
        Boxing.boxBoolean(r33.J);
    L31:
        if (r21 != null) goto L33;
        return r21;
    L33:
        r20 = null;
        goto L34
    L22:
        r32 = r31.f2258a;
        goto L24
    L26:
        r30 = null;
        goto L27
    L28:
        r33 = null;
    L7:
        r18 = new AnonymousClass3(this, r17);
        goto L8
    }
}
