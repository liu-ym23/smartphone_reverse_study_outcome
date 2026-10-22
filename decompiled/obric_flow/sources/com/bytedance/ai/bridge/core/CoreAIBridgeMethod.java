package com.bytedance.ai.bridge.core;

import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxResourceModule;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import ko.r;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o1.a;
import o1.c;
import o1.d;
import o1.e;
import o1.f;
import o1.g;
import o1.h;
import o1.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J=\u0010 \u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001bH\u0016¢\u0006\u0004\b \u0010!J-\u0010$\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00028\u00002\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\"H&¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "Param", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "Result", "Lo1/a;", "<init>", "()V", "Lcom/google/gson/JsonObject;", "dataSource", "createParamModelProxy", "(Lcom/google/gson/JsonObject;)Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "Ljava/lang/Class;", "getParamClazz", "()Ljava/lang/Class;", "Ljava/lang/reflect/Method;", "method", "Lo1/k;", "getParamFieldModel", "(Ljava/lang/reflect/Method;)Lo1/k;", "paramFieldModel", "", "parseDefaultValue", "(Ljava/lang/reflect/Method;Lo1/k;)Ljava/lang/Object;", "Ln1/c;", "bridgeContext", LynxResourceModule.PARAMS_KEY, "Landroidx/core/util/Consumer;", "resolve", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod$Error;", "reject", "", "realHandle", "(Ln1/c;Lcom/google/gson/JsonObject;Landroidx/core/util/Consumer;Landroidx/core/util/Consumer;)V", "Lo1/f;", "callback", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;Lo1/f;)V", "", "mustRunInMain", "()Z", "applet-bridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCoreAIBridgeMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoreAIBridgeMethod.kt\ncom/bytedance/ai/bridge/core/CoreAIBridgeMethod\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,137:1\n3829#2:138\n4344#2,2:139\n3829#2:141\n4344#2,2:142\n1#3:144\n*S KotlinDebug\n*F\n+ 1 CoreAIBridgeMethod.kt\ncom/bytedance/ai/bridge/core/CoreAIBridgeMethod\n*L\n89#1:138\n89#1:139,2\n93#1:141\n93#1:142,2\n*E\n"})
public abstract class CoreAIBridgeMethod<Param extends ParamModel, Result extends ResultModel> implements a {
    public CoreAIBridgeMethod() {
    }

    public static /* synthetic */ Object a(JsonObject r5, CoreAIBridgeMethod r10, Object r11, Method r12, Object[] r13) {
        return createParamModelProxy$lambda$4(r5, r10, r11, r12, r13);
    }

    private final Param createParamModelProxy(JsonObject r5) {
        Class<?> r10 = getParamClazz();
        if (r10 == null) goto L7;
        Object r11 = Proxy.newProxyInstance(r10.getClassLoader(), new Class[]{r10}, new g(r5, this));
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type Param of com.bytedance.ai.bridge.core.CoreAIBridgeMethod");
        return (Param) r11;
    L7:
        throw new AIBridgeMethod$InvalidParamsError("Illegal class format, no param model is defined in class");
    }

    private static final Object createParamModelProxy$lambda$4(JsonObject r5, CoreAIBridgeMethod r10, Object r11, Method r12, Object[] r13) {
        if (Intrinsics.areEqual(r12.getName(), "toJson") == false) goto L5;
        return r5;
    L5:
        Intrinsics.checkNotNull(r12);
        k r14 = r10.getParamFieldModel(r12);
        boolean r15 = r5.has(r14.f20400b);
        String r16 = r14.f20400b;
        if (r15 == false) goto L17;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L9
        return z0.a.a().fromJson(r5.get(r16), r12.getReturnType());
    L9:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Object r19 = Result.m124constructorimpl(ResultKt.createFailure(th));
        Throwable r20 = Result.m127exceptionOrNullimpl(r19);
        if (r20 != null) goto L15;
        return Result.m123boximpl(r19);
    L15:
        throw new AIBridgeMethod$InvalidParamsError("convert param:" + r16 + " error with msg:" + r20.getMessage());
    L17:
        if (r14.f20401c.f20394a == DefaultType.NONE) goto L21;
        return r10.parseDefaultValue(r12, r14);
    L21:
        if (r14.f20399a == true) goto L25;
        return null;
    L25:
        throw new AIBridgeMethod$InvalidParamsError("can not find required param:" + r16);
    }

    private final Class<?> getParamClazz() {
        ConcurrentHashMap r5 = e.f20389a;
        Class<?> r10 = getClass();
        Intrinsics.checkNotNullParameter(r10, "clazz");
        c r11 = (c) e.f20389a.get(r10);
        if (r11 == null) goto L5;
        Class<?> r12 = r11.f20385a;
    L6:
        if (r12 == null) goto L8;
        return r12;
    L8:
        Class<?>[] r13 = getClass().getDeclaredClasses();
        ArrayList r14 = new ArrayList();
        int r15 = r13.length;
        int r16 = 0;
        int r17 = 0;
    L10:
        if (r17 >= r15) goto L16;
        Class<?> r18 = r13[r17];
        if (r18.getAnnotation(AIBridgeParamModel.class) == null) goto L14;
        r14.add(r18);
    L14:
        r17 = r17 + 1;
        goto L10
    L16:
        if (r14.isEmpty() == false) goto L29;
        Class<?>[] r19 = getClass().getSuperclass().getDeclaredClasses();
        r14 = new ArrayList();
        int r20 = r19.length;
    L18:
        if (r16 >= r20) goto L24;
        Class<?> r21 = r19[r16];
        if (r21.getAnnotation(AIBridgeParamModel.class) == null) goto L22;
        r14.add(r21);
    L22:
        r16 = r16 + 1;
        goto L18
    L24:
        if (r14.isEmpty() == false) goto L29;
        throw new IllegalStateException("Illegal class format, no param model is defined in class");
    L29:
        return (Class) CollectionsKt.first(r14);
    L5:
        r12 = null;
        goto L6
    }

    private final k getParamFieldModel(Method r13) {
        ConcurrentHashMap r5 = e.f20389a;
        Class<?> r12 = getClass();
        Intrinsics.checkNotNullParameter(r12, "clazz");
        c r14 = (c) e.f20389a.get(r12);
        if (r14 == null) goto L7;
        d r15 = r14.f20387c;
        if (r15 == null) goto L7;
        HashMap r16 = r15.f20388a;
    L8:
        if (r16 == null) goto L12;
        k r17 = (k) r16.get(r13);
        if (r17 == null) goto L12;
        return r17;
    L12:
        AIBridgeParamField r18 = (AIBridgeParamField) r13.getAnnotation(AIBridgeParamField.class);
        if (r18 == null) goto L17;
        AIBridgeDefaultValue r19 = r18.defaultValue();
        return new k(r18.required(), r18.keyPath(), new h(r19.type(), r19.doubleValue(), r19.stringValue(), r19.intValue(), r19.boolValue(), r19.longValue()));
    L17:
        throw new IllegalStateException("annotation ParamField not found");
    L7:
        r16 = null;
        goto L8
    }

    private final Object parseDefaultValue(Method r5, k r10) {
        Class<?> r11 = r5.getReturnType();
        if (Intrinsics.areEqual(r11, Integer.TYPE) == true) goto L38;
        if (Intrinsics.areEqual(r11, Integer.class) == true) goto L38;
        if (Intrinsics.areEqual(r11, Double.TYPE) == true) goto L36;
        if (Intrinsics.areEqual(r11, Double.class) == true) goto L36;
        if (Intrinsics.areEqual(r11, Long.TYPE) == true) goto L34;
        if (Intrinsics.areEqual(r11, Long.class) == true) goto L34;
        if (Intrinsics.areEqual(r11, Boolean.TYPE) == true) goto L32;
        if (Intrinsics.areEqual(r11, Boolean.class) == true) goto L32;
        if (Intrinsics.areEqual(r11, String.class) == true) goto L30;
        if (Intrinsics.areEqual(r11, String.class) == true) goto L30;
        return null;
    L30:
        return r10.f20401c.f20396c;
    L32:
        return Boolean.valueOf(r10.f20401c.e);
    L34:
        return Long.valueOf(r10.f20401c.f);
    L36:
        return Double.valueOf(r10.f20401c.f20395b);
    L38:
        return Integer.valueOf(r10.f20401c.d);
    }

    @Override // o1.a
    public List<String> getAltNames() {
        return null;
    }

    @Override // o1.a
    public abstract /* synthetic */ String getName();

    public abstract void handle(n1.c r5, Param r10, f r11);

    @Override // o1.a
    public boolean mustRunInMain() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // o1.a
    public void realHandle(n1.c r5, JsonObject r10, Consumer<JsonObject> r11, Consumer<AIBridgeMethod$Error> r12) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "resolve");
        Intrinsics.checkNotNullParameter(r12, "reject");
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L6
        if (r10 != null) goto L8;
        r10 = new JsonObject();     // Catch: Throwable -> L6
    L8:
        handle(r5, createParamModelProxy(r10), new r(14, r11, r12));     // Catch: Throwable -> L6
        Object r14 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L11:
        Throwable r15 = Result.m127exceptionOrNullimpl(r14);
        if (r15 != null) goto L14;
        return;
    L14:
        if ((r15 instanceof AIBridgeMethod$Error) == false) goto L16;
        r12.accept(r15);
    L17:
        String r16 = "method:" + getName();
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter(r16, "msg");
        a1.a.f43a.e("ai_bridge", r16, r15);
        return;
    L16:
        r12.accept(new AIBridgeMethod$Error(r15.getMessage(), 0));
    L6:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
