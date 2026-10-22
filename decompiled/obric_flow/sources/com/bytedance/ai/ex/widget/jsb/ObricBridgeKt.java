package com.bytedance.ai.ex.widget.jsb;

import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¨\u0006\u0006"}, d2 = {"getAnnotatedFieldsJson", "Lcom/google/gson/JsonObject;", "obj", "", "clazz", "Ljava/lang/Class;", "widget-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nObricBridge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObricBridge.kt\ncom/bytedance/ai/ex/widget/jsb/ObricBridgeKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,155:1\n13346#2,2:156\n*S KotlinDebug\n*F\n+ 1 ObricBridge.kt\ncom/bytedance/ai/ex/widget/jsb/ObricBridgeKt\n*L\n142#1:156,2\n*E\n"})
public final class ObricBridgeKt {
    public static final JsonObject getAnnotatedFieldsJson(Object r10, Class<?> r11) {
        Intrinsics.checkNotNullParameter(r10, "obj");
        Intrinsics.checkNotNullParameter(r11, "clazz");
        JsonObject r5 = new JsonObject();
        Method[] r12 = r11.getDeclaredMethods();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L10;
        Method r15 = r12[r14];
        AIBridgeParamField r16 = (AIBridgeParamField) r15.getAnnotation(AIBridgeParamField.class);
        if (r16 == null) goto L9;
        String r17 = r16.keyPath();
        Object r18 = r15.invoke(r10, null);
        if (r18 == null) goto L9;
        r5.add(r17, new JsonPrimitive(r18.toString()));
    L9:
        r14 = r14 + 1;
        goto L3
    L10:
        return r5;
    }
}
