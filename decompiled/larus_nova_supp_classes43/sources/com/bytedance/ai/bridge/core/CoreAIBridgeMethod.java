package com.bytedance.ai.bridge.core;

import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import e3.d;
import f3.e;
import f3.g;
import f3.h;
import f3.i;
import f3.j;
import f3.n;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J6\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000fH\u0016J+\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H&¢\u0006\u0002\u0010\u0015J#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u00172\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0015\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u001a\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010!\u001a\u00020\"2\u0006\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020'H\u0016¨\u0006("}, d2 = {"Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Param", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "Result", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod;", "<init>", "()V", "realHandle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/google/gson/JsonObject;", "resolve", "Landroidx/core/util/Consumer;", "reject", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod$Error;", "handle", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "(Lcom/bytedance/ai/bridge/context/IAIBridgeContext;Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;Lcom/bytedance/ai/bridge/core/CompletionBlock;)V", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "(Lcom/bytedance/ai/bridge/context/IAIBridgeContext;Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;)Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "realHandleSync", "createParamModelProxy", "dataSource", "(Lcom/google/gson/JsonObject;)Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "getParamClazz", "Ljava/lang/Class;", "getParamFieldModel", "Lcom/bytedance/ai/bridge/core/ParamFieldModel;", "method", "Ljava/lang/reflect/Method;", "parseDefaultValue", "", "paramFieldModel", "mustRunInMain", "", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class CoreAIBridgeMethod<Param extends ParamModel, Result extends ResultModel> implements AIBridgeMethod {

    public static final class a implements h<Result> {
        public final /* synthetic */ Consumer<JsonObject> a;
        public final /* synthetic */ JsonObject b;
        public final /* synthetic */ Consumer<AIBridgeMethod.Error> c;

        @Override // f3.h
        public final void a(String r10, Object r11) {
            Intrinsics.checkNotNullParameter(r10, "key");
            if ((r11 instanceof String) == false) goto L6;
            this.b.addProperty(r10, (String) r11);
            return;
        L6:
            if ((r11 instanceof Number) == false) goto L9;
            this.b.addProperty(r10, (Number) r11);
            return;
        L9:
            if ((r11 instanceof Boolean) == false) goto L14;
            this.b.addProperty(r10, (Boolean) r11);
            return;
        }

        @Override // f3.h
        public final void b(Result r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_RESULT);
            Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
            JsonObject r12 = r10.toJson();
            Consumer<JsonObject> r1 = this.a;
            JsonObject r13 = new JsonObject();
            JsonObject r14 = this.b;
            r13.addProperty("code", 1);
            r13.add("data", r12);
            r13.addProperty(MessageIndication.MESSAGE_TYPE_MSG, r11);
            f3.a r15 = f3.a.d;
            r13.addProperty("errNo", Integer.valueOf(r15.a));
            r13.addProperty("errMsg", r15.b);
            if (r14.size() <= 0) goto L5;
            r13.add("extras", r14);
        L5:
            r1.accept(r13);
        }

        public a(Consumer<JsonObject> r1, JsonObject r10, Consumer<AIBridgeMethod.Error> r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        @Override // f3.h
        public final void c(String r10, int r11, f3.a r12, JsonObject r13) {
            Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
            Consumer<AIBridgeMethod.Error> r0 = this.c;
            AIBridgeMethod.Error r1 = new AIBridgeMethod.Error(r11, r10, r13, r12);
            JsonObject r14 = this.b;
            if (r14.size() <= 0) goto L5;
            r1.setExtras(r14);
        L5:
            r0.accept(r1);
        }
    }

    public CoreAIBridgeMethod() {
    }

    public static /* synthetic */ Object a(JsonObject r0, CoreAIBridgeMethod r1, Object r10, Method r11, Object[] r12) {
        return createParamModelProxy$lambda$7(r0, r1, r10, r11, r12);
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public List<String> getAltNames() {
        return null;
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public boolean getSupportSyncCall() {
        return false;
    }

    public abstract void handle(d r1, Param r10, h<Result> r11);

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public boolean mustRunInMain() {
        return false;
    }

    private final Class<?> getParamClazz() {
        ConcurrentHashMap<Class<? extends AIBridgeMethod>, f3.d> r0 = g.a;
        Class<?> r1 = getClass();
        Intrinsics.checkNotNullParameter(r1, "clazz");
        f3.d r10 = g.a.get(r1);
        if (r10 == null) goto L5;
        Class<?> r11 = r10.a;
    L6:
        if (r11 == null) goto L8;
        return r11;
    L8:
        Class<?>[] r12 = getClass().getDeclaredClasses();
        ArrayList r13 = new ArrayList();
        int r14 = r12.length;
        int r15 = 0;
    L9:
        boolean r16 = true;
        if (r15 >= r14) goto L19;
        Class<?> r17 = r12[r15];
        if (r17.getAnnotation(AIBridgeParamModel.class) != null) goto L15;
        r16 = false;
    L15:
        if (r16 == false) goto L17;
        r13.add(r17);
    L17:
        r15 = r15 + 1;
        goto L9
    L19:
        if (r13.isEmpty() == false) goto L35;
        Class<?>[] r18 = getClass().getSuperclass().getDeclaredClasses();
        r13 = new ArrayList();
        int r19 = r18.length;
        int r20 = 0;
    L21:
        if (r20 >= r19) goto L30;
        Class<?> r21 = r18[r20];
        if (r21.getAnnotation(AIBridgeParamModel.class) == null) goto L25;
        boolean r22 = true;
    L26:
        if (r22 == false) goto L28;
        r13.add(r21);
    L28:
        r20 = r20 + 1;
        goto L21
    L25:
        r22 = false;
        goto L26
    L30:
        if (r13.isEmpty() == false) goto L35;
        throw new IllegalStateException("Illegal class format, no param model is defined in class");
    L35:
        return (Class) CollectionsKt.first(r13);
    L5:
        r11 = null;
        goto L6
    }

    private final Param createParamModelProxy(final JsonObject r10) {
        Class<?> r0 = getParamClazz();
        if (r0 == null) goto L7;
        Object r11 = Proxy.newProxyInstance(r0.getClassLoader(), new Class[]{r0}, new i(r10, this));
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type Param of com.bytedance.ai.bridge.core.CoreAIBridgeMethod");
        return (Param) r11;
    L7:
        throw new AIBridgeMethod.InvalidParamsError("Illegal class format, no param model is defined in class");
    }

    private final n getParamFieldModel(Method r14) {
        ConcurrentHashMap<Class<? extends AIBridgeMethod>, f3.d> r0 = g.a;
        Class<?> r1 = getClass();
        Intrinsics.checkNotNullParameter(r1, "clazz");
        f3.d r10 = g.a.get(r1);
        if (r10 == null) goto L7;
        e r11 = r10.c;
        if (r11 == null) goto L7;
        HashMap<Method, n> r12 = r11.a;
    L8:
        if (r12 == null) goto L12;
        n r13 = r12.get(r14);
        if (r13 == null) goto L12;
        return r13;
    L12:
        AIBridgeParamField r15 = (AIBridgeParamField) r14.getAnnotation(AIBridgeParamField.class);
        if (r15 == null) goto L17;
        AIBridgeDefaultValue r16 = r15.defaultValue();
        return new n(r15.required(), r15.keyPath(), new j(r16.type(), r16.doubleValue(), r16.stringValue(), r16.intValue(), r16.boolValue(), r16.longValue()));
    L17:
        throw new IllegalStateException("annotation ParamField not found");
    L7:
        r12 = null;
        goto L8
    }

    private final Object parseDefaultValue(Method r10, n r11) {
        Class<?> r12 = r10.getReturnType();
        if (Intrinsics.areEqual(r12, Integer.TYPE) == true) goto L33;
        if (Intrinsics.areEqual(r12, Integer.class) == true) goto L33;
        if (Intrinsics.areEqual(r12, Double.TYPE) == true) goto L38;
        if (Intrinsics.areEqual(r12, Double.class) == true) goto L38;
        if (Intrinsics.areEqual(r12, Long.TYPE) == true) goto L37;
        if (Intrinsics.areEqual(r12, Long.class) == true) goto L37;
        if (Intrinsics.areEqual(r12, Boolean.TYPE) == true) goto L36;
        if (Intrinsics.areEqual(r12, Boolean.class) == true) goto L36;
        if (Intrinsics.areEqual(r12, String.class) == true) goto L35;
        if (Intrinsics.areEqual(r12, String.class) == true) goto L35;
        return null;
    L35:
        return r11.c.c;
    L36:
        return Boolean.valueOf(r11.c.e);
    L37:
        return Long.valueOf(r11.c.f);
    L38:
        return Double.valueOf(r11.c.b);
    L33:
        return Integer.valueOf(r11.c.d);
    }

    public com.bytedance.ai.bridge.core.a<Result> handleSync(d r10, Param r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        int r12 = com.bytedance.ai.bridge.core.a.a;
        return com.bytedance.ai.bridge.core.a.C0020a.a(0, "sync call is not supported");
    }

    public final JsonObject realHandleSync(d r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        if (r11 != null) goto L5;
        r11 = new JsonObject();
    L5:
        com.bytedance.ai.bridge.core.a<Result> r12 = handleSync(r10, createParamModelProxy(r11));
        if ((r12 instanceof com.bytedance.ai.bridge.core.a.c) == false) goto L9;
        JsonObject r13 = new JsonObject();
        r13.addProperty("code", 1);
        com.bytedance.ai.bridge.core.a.c r14 = (com.bytedance.ai.bridge.core.a.c) r12;
        r13.add("data", ((BaseModel) r14.b).toJson());
        r13.addProperty(MessageIndication.MESSAGE_TYPE_MSG, r14.c);
        f3.a r15 = f3.a.d;
        r13.addProperty("errNo", Integer.valueOf(r15.a));
        r13.addProperty("errMsg", r15.b);
        return r13;
    L9:
        if ((r12 instanceof com.bytedance.ai.bridge.core.a.b) == false) goto L18;
        JsonObject r16 = new JsonObject();
        com.bytedance.ai.bridge.core.a.b r17 = (com.bytedance.ai.bridge.core.a.b) r12;
        r16.addProperty("code", Integer.valueOf(r17.b));
        r16.addProperty(MessageIndication.MESSAGE_TYPE_MSG, r17.c);
        JsonObject r18 = r17.d;
        if (r18 == null) goto L13;
        r16.add("data", r18);
    L13:
        f3.a r19 = r17.e;
        if (r19 == null) goto L20;
        r16.addProperty("errNo", Integer.valueOf(r19.a));
        r16.addProperty("errMsg", r19.b);
        return r16;
    L20:
        return r16;
    L18:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public void realHandle(d r10, JsonObject r11, Consumer<JsonObject> r12, Consumer<AIBridgeMethod.Error> r13) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, "resolve");
        Intrinsics.checkNotNullParameter(r13, "reject");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        if (r11 != null) goto L6;
        r11 = new JsonObject();     // Catch: Throwable -> L8
    L6:
        handle(r10, createParamModelProxy(r11), new a(r12, new JsonObject(), r13));     // Catch: Throwable -> L8
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 != null) goto L13;
        return;
    L13:
        if ((r15 instanceof AIBridgeMethod.Error) == false) goto L15;
        r13.accept(r15);
    L16:
        com.bytedance.ai.applet.base.log.b r16 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "method:" + getName(), r15);
        return;
    L15:
        r13.accept(new AIBridgeMethod.Error(r15.getMessage(), null, 2, null));
    L8:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    private static final Object createParamModelProxy$lambda$7(JsonObject r0, CoreAIBridgeMethod r1, Object r10, Method r11, Object[] r12) {
        if (Intrinsics.areEqual(r11.getName(), "toJson") == false) goto L5;
        return r0;
    L5:
        Intrinsics.checkNotNull(r11);
        n r13 = r1.getParamFieldModel(r11);
        if (r0.has(r13.b) == false) goto L17;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L9
        Lazy r15 = com.bytedance.ai.applet.base.gson.e.a;     // Catch: Throwable -> L9
        JsonElement r16 = r0.get(r13.b);     // Catch: Throwable -> L9
        Type r17 = r11.getGenericReturnType();     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r17, "typeOfT");     // Catch: Throwable -> L9
        return GsonProtectorUtils.fromJson((Gson) com.bytedance.ai.applet.base.gson.e.a.getValue(), r16, r17);
    L9:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Object r19 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 != null) goto L15;
        return Result.box-impl(r19);
    L15:
        throw new AIBridgeMethod.InvalidParamsError("convert param:" + r13.b + " error with msg:" + r20.getMessage());
    L17:
        if (r13.c.getType() == DefaultType.NONE) goto L21;
        return r1.parseDefaultValue(r11, r13);
    L21:
        if (r13.a == true) goto L25;
        return null;
    L25:
        throw new AIBridgeMethod.InvalidParamsError("can not find required param:" + r13.b);
    }
}
