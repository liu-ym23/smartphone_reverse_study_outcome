package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.s;
import com.google.gson.JsonElement;
import com.lynx.jsbridge.LynxResourceModule;
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
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0083\u0001\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00102\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J|\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001a2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00102\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001a2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0082@¢\u0006\u0004\b\u0017\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010 \u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/CreateTextMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsCreateTextMethodIDL;", "<init>", "()V", "", "runningInWorker", "", "content", "Lcom/bytedance/ai/bridge/method/router/AbsCreateTextMethodIDL$CreateTextParamModel;", LynxResourceModule.PARAMS_KEY, "Lcom/bytedance/ai/model/AppletRuntime;", "appletRuntime", "botId", "conversationId", "", "suggests", "", "extra", "suggestsV2", "Lo1/f;", "Lcom/bytedance/ai/bridge/method/router/AbsCreateTextMethodIDL$CreateTextResultModel;", "callback", "", "generateTextMessage", "(ZLjava/lang/String;Lcom/bytedance/ai/bridge/method/router/AbsCreateTextMethodIDL$CreateTextParamModel;Lcom/bytedance/ai/model/AppletRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Lo1/f;)V", "questionId", "", "(Lcom/bytedance/ai/model/AppletRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Lo1/f;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mustRunInMain", "()Z", "Ln1/c;", "bridgeContext", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/router/AbsCreateTextMethodIDL$CreateTextParamModel;Lo1/f;)V", "Companion", "com/bytedance/ai/bridge/method/router/c", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CreateTextMethod extends AbsCreateTextMethodIDL {
    public static final c Companion = null;
    private static final String TAG = "CreateTextMethod";

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.router.CreateTextMethod$generateTextMessage$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.router.CreateTextMethod$generateTextMessage$1", f = "CreateTextMethod.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CreateTextMethod f1910b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppletRuntime f1911c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ List f;
        public final /* synthetic */ String g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f1912h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Map f1913i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ List f1914j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ o1.f f1915k;

        public AnonymousClass1(CreateTextMethod r5, AppletRuntime r10, String r11, String r12, List r13, String r14, String r15, Map r16, List r17, o1.f r18, Continuation r19) {
            this.f1910b = r5;
            this.f1911c = r10;
            this.d = r11;
            this.e = r12;
            this.f = r13;
            this.g = r14;
            this.f1912h = r15;
            this.f1913i = r16;
            this.f1914j = r17;
            this.f1915k = r18;
            super(2, r19);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object r13, Continuation r14) {
            return new AnonymousClass1(this.f1910b, this.f1911c, this.d, this.e, this.f, this.g, this.f1912h, this.f1913i, this.f1914j, this.f1915k, r14);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.f1909a;
            if (r10 == 0) goto L8;
            if (r10 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            CreateTextMethod r11 = this.f1910b;
            AppletRuntime r14 = this.f1911c;
            String r12 = this.d;
            String r15 = this.e;
            List r16 = this.f;
            String r17 = this.g;
            String r18 = this.f1912h;
            Map r19 = this.f1913i;
            List r20 = this.f1914j;
            o1.f r110 = this.f1915k;
            this.f1909a = 1;
            if (CreateTextMethod.access$generateTextMessage(r11, r14, r12, r15, r16, r17, r18, r19, r20, r110, this) != r5) goto L12;
            return r5;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.router.CreateTextMethod$generateTextMessage$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.router.CreateTextMethod$generateTextMessage$2", f = "CreateTextMethod.kt", i = {}, l = {135, 142}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbsCreateTextMethodIDL.CreateTextParamModel f1917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o1.f f1918c;
        public final /* synthetic */ CreateTextMethod d;
        public final /* synthetic */ AppletRuntime e;
        public final /* synthetic */ String f;
        public final /* synthetic */ List g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f1919h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f1920i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ Map f1921j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ List f1922k;

        public AnonymousClass2(AbsCreateTextMethodIDL.CreateTextParamModel r5, o1.f r10, CreateTextMethod r11, AppletRuntime r12, String r13, List r14, String r15, String r16, Map r17, List r18, Continuation r19) {
            this.f1917b = r5;
            this.f1918c = r10;
            this.d = r11;
            this.e = r12;
            this.f = r13;
            this.g = r14;
            this.f1919h = r15;
            this.f1920i = r16;
            this.f1921j = r17;
            this.f1922k = r18;
            super(2, r19);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object r13, Continuation r14) {
            return new AnonymousClass2(this.f1917b, this.f1918c, this.d, this.e, this.f, this.g, this.f1919h, this.f1920i, this.f1921j, this.f1922k, r14);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r5 = this.f1916a;
            if (r5 != 0) goto L5;
            ResultKt.throwOnFailure(r14);
            JsonElement r10 = this.f1917b.getContext().get("questionId");
            if (r10 == null) goto L14;
            String r12 = r10.getAsString();
        L15:
            if (r12 != null) goto L17;
        L20:
            JsonElement r13 = this.f1917b.getContext().get("msgId");
            if (r13 == null) goto L23;
            String r15 = r13.getAsString();
        L24:
            if (r15 != null) goto L26;
        L43:
            Intrinsics.checkNotNullParameter(CreateTextMethod.TAG, "tag");
            t0.d r16 = com.bytedance.ai.utils.c.f2846a;
            if (r16 == null) goto L46;
            r16.e(CreateTextMethod.TAG, "CreateText error, msgId is empty.");
        L46:
            this.f1918c.a("CreateText error, msgId is empty.");
            return Unit.INSTANCE;
        L26:
            if (r15.length() == 0) goto L43;
            r12 = null;
        L29:
            if (r12 != null) goto L31;
        L38:
            Intrinsics.checkNotNullParameter(CreateTextMethod.TAG, "tag");
            t0.d r17 = com.bytedance.ai.utils.c.f2846a;
            if (r17 == null) goto L41;
            r17.e(CreateTextMethod.TAG, "CreateText error, questionId is empty.");
        L41:
            this.f1918c.a("CreateText error, questionId is empty.");
            return Unit.INSTANCE;
        L31:
            if (r12.length() == 0) goto L38;
        L19:
            String r18 = r12;
            CreateTextMethod r19 = this.d;
            AppletRuntime r20 = this.e;
            String r21 = this.f;
            List r22 = this.g;
            String r23 = this.f1919h;
            String r24 = this.f1920i;
            Map r25 = this.f1921j;
            List r26 = this.f1922k;
            o1.f r110 = this.f1918c;
            this.f1916a = 2;
            if (CreateTextMethod.access$generateTextMessage(r19, r20, r18, r21, r22, r23, r24, r25, r26, r110, this) != r11) goto L37;
            return r11;
        L37:
            return Unit.INSTANCE;
        L23:
            r15 = null;
            goto L24
        L17:
            if (r12.length() != 0) goto L19;
        L14:
            r12 = null;
            goto L15
        L5:
            if (r5 == 1) goto L10;
            if (r5 != 2) goto L9;
            ResultKt.throwOnFailure(r14);
            goto L37
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r14);
            r12 = (String) r14;
            goto L29
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.router.CreateTextMethod$generateTextMessage$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.router.CreateTextMethod", f = "CreateTextMethod.kt", i = {0, 0, 0, 0}, l = {158}, m = "generateTextMessage", n = {"questionId", "botId", "conversationId", "callback"}, s = {"L$0", "L$1", "L$2", "L$3"})
    public static final class AnonymousClass3 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f1924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f1925c;
        public o1.f d;
        public /* synthetic */ Object e;
        public final /* synthetic */ CreateTextMethod f;
        public int g;

        public AnonymousClass3(CreateTextMethod r5, Continuation r10) {
            this.f = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            this.e = r12;
            this.g |= Integer.MIN_VALUE;
            return CreateTextMethod.access$generateTextMessage(this.f, null, null, null, null, null, null, null, null, null, this);
        }
    }

    static {
        Companion = new c();
    }

    public CreateTextMethod() {
    }

    public static final /* synthetic */ Object access$generateTextMessage(CreateTextMethod r5, AppletRuntime r10, String r11, String r12, List r13, String r14, String r15, Map r16, List r17, o1.f r18, Continuation r19) {
        return r5.generateTextMessage(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static /* synthetic */ Unit b(o1.f r5, AbsCreateTextMethodIDL.CreateTextParamModel r10, n1.c r11, CreateTextMethod r12, AppletRuntime r13) {
        return handle$lambda$2(r5, r10, r11, r12, r13);
    }

    private final void generateTextMessage(boolean r15, String r16, AbsCreateTextMethodIDL.CreateTextParamModel r17, AppletRuntime r18, String r19, String r20, List<String> r21, Map<String, String> r22, List<String> r23, o1.f r24) {
        String r5 = "generateTextMessage " + r16 + ", runningInWorker=" + r15 + ", afterBotReply=" + r17.getAfterBotReply() + " context=" + r17.getContext();
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r10 = com.bytedance.ai.utils.c.f2846a;
        if (r10 == null) goto L5;
        r10.i(TAG, r5);
    L5:
        if (r15 == true) goto L7;
        BuildersKt.launch$default(h0.a(t2.b.f22089a), null, null, new AnonymousClass2(r17, r24, this, r18, r16, r21, r19, r20, r22, r23, null), 3, null);
        return;
    L7:
        if (Intrinsics.areEqual(r17.getAfterBotReply(), Boolean.FALSE) == false) goto L24;
        JsonElement r11 = r17.getContext().get("questionId");
        if (r11 == null) goto L12;
        String r12 = r11.getAsString();
    L11:
        String r13 = r12;
        if (r13 != null) goto L15;
    L19:
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L22;
        r14.e(TAG, "CreateText error, questionId is empty.");
    L22:
        r24.a("CreateText error, questionId is empty.");
        return;
    L15:
        if (r13.length() == 0) goto L19;
        BuildersKt.launch$default(h0.a(t2.b.f22089a), null, null, new AnonymousClass1(this, r18, r13, r16, r21, r19, r20, r22, r23, r24, null), 3, null);
        return;
    L12:
        r12 = null;
        goto L11
    L24:
        JsonElement r25 = r17.getContext().get("callbackId");
        if (r25 == null) goto L28;
        String r26 = r25.getAsString();
        if (r26 == null) goto L28;
    L29:
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "botId");
        Intrinsics.checkNotNullParameter(r16, "content");
        Intrinsics.checkNotNullParameter(r26, "callbackID");
        if (r18.f2208t.get(r26) != null) goto L37;
        Intrinsics.checkNotNullParameter("WorkerRuntime", "tag");
        t0.d r27 = com.bytedance.ai.utils.c.f2846a;
        if (r27 == null) goto L34;
        r27.e("WorkerRuntime", "CreateWidget error, No found callback.");
    L34:
        Intrinsics.checkNotNullParameter("No found callback.", "message");
        r24.a("");
        Unit r28 = Unit.INSTANCE;
        return;
    L37:
        throw new ClassCastException();
    L28:
        r26 = "";
        goto L29
    }

    private static final Unit handle$lambda$2(o1.f r11, AbsCreateTextMethodIDL.CreateTextParamModel r12, n1.c r13, CreateTextMethod r14, AppletRuntime r15) {
        if (r15 != null) goto L9;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L7;
        r16.e(TAG, "appletRuntime is null");
    L7:
        r11.a("appletRuntime is null");
        return Unit.INSTANCE;
    L9:
        String r5 = r12.getContent();
        List<String> r10 = r12.getSuggests();
        JsonElement r17 = r12.getContext().get("botId");
        if (r17 == null) goto L15;
        String r18 = r17.getAsString();
        if (r18 == null) goto L15;
        String r19 = r18;
    L16:
        n1.a r110 = (n1.a) r13;
        m1.j r20 = (m1.j) r110.b(m1.j.class);
        ContainerType r21 = null;
        if (r20 == null) goto L19;
        ContainerType r22 = r20.d();
    L21:
        if (r22 != ContainerType.f1801c) goto L23;
        w0.f r23 = (w0.f) r110.b(w0.f.class);
    L23:
        JsonElement r24 = r12.getContext().get("conversationId");
        if (r24 == null) goto L27;
        String r25 = r24.getAsString();
        if (r25 == null) goto L27;
    L29:
        if (r25.length() != 0) goto L33;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r26 = com.bytedance.ai.utils.c.f2846a;
        if (r26 == null) goto L33;
        r26.w(TAG, "conversation id is empty");
    L33:
        m1.j r111 = (m1.j) r110.b(m1.j.class);
        if (r111 == null) goto L37;
        r21 = r111.d();
    L37:
        if (r21 != ContainerType.d) goto L40;
        boolean r112 = true;
    L41:
        r14.generateTextMessage(r112, r5, r12, r15, r19, r25, r10, r12.getExtra(), r12.getSuggestsV2(), r11);
        return Unit.INSTANCE;
    L40:
        r112 = false;
    L27:
        r25 = "";
        goto L29
    L19:
        r22 = null;
    L15:
        r19 = "";
        goto L16
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, o1.f r11) {
        handle(r5, (AbsCreateTextMethodIDL.CreateTextParamModel) r10, r11);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public boolean mustRunInMain() {
        return true;
    }

    public void handle(n1.c r10, AbsCreateTextMethodIDL.CreateTextParamModel r11, o1.f r12) {
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
        r13.a(new a2.c(1, r12, r11, r5, this));
    }

    private final Object generateTextMessage(AppletRuntime r5, String r10, String r11, List<String> r12, String r13, String r14, Map<String, String> r15, List<String> r16, o1.f r17, Continuation<? super Unit> r18) {
        if ((r18 instanceof AnonymousClass3) == false) goto L7;
        AnonymousClass3 r19 = (AnonymousClass3) r18;
        int r20 = r19.g;
        if ((r20 & Integer.MIN_VALUE) == 0) goto L7;
        r19.g = r20 - Integer.MIN_VALUE;
    L8:
        Object r21 = r19.e;
        Object r22 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r23 = r19.g;
        if (r23 == 0) goto L14;
        if (r23 != 1) goto L13;
        r17 = r19.d;
        r14 = r19.f1925c;
        r13 = r19.f1924b;
        r10 = r19.f1923a;
        ResultKt.throwOnFailure(r21);
    L18:
        Boolean r24 = (Boolean) r21;
        String r25 = "generateTextMessage result " + r24;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r26 = com.bytedance.ai.utils.c.f2846a;
        if (r26 == null) goto L22;
        r26.d(TAG, r25);
    L22:
        if (Intrinsics.areEqual(r24, Boxing.boxBoolean(true)) == false) goto L25;
        Intrinsics.checkNotNullParameter(AbsCreateTextMethodIDL.CreateTextResultModel.class, "<this>");
        r17.b((ResultModel) com.lynx.tasm.behavior.ui.utils.e.c(AbsCreateTextMethodIDL.CreateTextResultModel.class), "");
    L29:
        return Unit.INSTANCE;
    L25:
        if (r24 != null) goto L27;
        StringBuilder r27 = com.lynx.tasm.base.a.e("SaveBotReplyRequest timeout, questionId: ", r10, ", botId: ", r13, ", convId: ");
        r27.append(r14);
        r27.append(", timeoutInterval: 10000");
        r17.a(r27.toString());
        goto L29
    L27:
        StringBuilder r28 = com.lynx.tasm.base.a.e("SaveBotReplyRequest API failed, questionId: ", r10, ", botId: ", r13, ", convId: ");
        r28.append(r14);
        r28.append(", error: Http Error");
        r17.a(r28.toString());
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r21);
        r19.f1923a = r10;
        r19.f1924b = r13;
        r19.f1925c = r14;
        r19.d = r17;
        r19.g = 1;
        r5.getClass();
        if (r22 != null) goto L17;
        return r22;
    L17:
        r21 = null;
    L7:
        r19 = new AnonymousClass3(this, r18);
        goto L8
    }
}
