package com.ss.android.lark.opmonitor.trace;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.optrace.impl.TracingSpanImpl;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.lang.reflect.Type;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OPTraceGSONParser {
    public static final Gson a = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J(\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/opmonitor/trace/OPTraceGSONParser$OPTraceTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/ss/android/lark/opmonitor/trace/OPTrace;", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "opmonitor_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class OPTraceTypeAdapter implements JsonDeserializer<OPTrace> {
        public OPTraceTypeAdapter() {
        }

        public final Object deserialize(JsonElement r4, Type r5, JsonDeserializationContext r6) {
            if (r4 == null) goto L48;
            JsonObject r7 = r4.getAsJsonObject();     // Catch: Exception -> L36
            if (r7 == null) goto L49;
            JsonElement r8 = r7.get("trace");     // Catch: Exception -> L36
            if (r8 == null) goto L9;
            JsonObject r9 = r8.getAsJsonObject();     // Catch: Exception -> L36
        L10:
            if (r9 == null) goto L12;
            Object r10 = OPTraceGSONParser.a.fromJson(r9, new b().getType());     // Catch: Exception -> L36
        L13:
            Ref.ObjectRef r0 = new Ref.ObjectRef();     // Catch: Exception -> L36
            TracingSpanImpl r11 = (TracingSpanImpl) r10;     // Catch: Exception -> L36
            if (r11 == null) goto L16;
            OPTrace r1 = new OPTrace(r11);     // Catch: Exception -> L36
        L17:
            r0.element = r1;     // Catch: Exception -> L36
            JsonElement r12 = r7.get("monitorCache");     // Catch: Exception -> L36
            if (r12 == null) goto L20;
            JsonArray r13 = r12.getAsJsonArray();     // Catch: Exception -> L36
        L21:
            if (r13 == null) goto L30;
            Iterator r14 = r13.iterator();     // Catch: Exception -> L36
        L24:
            if (r14.hasNext() == false) goto L30;
            JsonElement r2 = (JsonElement) r14.next();     // Catch: Exception -> L36
            if (r2 == null) goto L24;
            String r3 = OPTraceGSONParser.a.toJson(r2);     // Catch: Exception -> L36
            if (r3 == null) goto L24;
            ((OPTrace) r0.element).getMonitors().add(r3);     // Catch: Exception -> L36
        L30:
            JsonElement r15 = r7.get("batchEnabled");     // Catch: Exception -> L36
            if (r15 == null) goto L33;
            boolean r16 = r15.getAsBoolean();     // Catch: Exception -> L36
        L34:
            ((OPTrace) r0.element).setBatchEnabled(r16);     // Catch: Exception -> L36
            return (OPTrace) r0.element;
        L33:
            r16 = false;
            goto L34
        L20:
            r13 = null;
            goto L21
        L16:
            r1 = gyb.a.a();     // Catch: Exception -> L36
            goto L17
        L12:
            r10 = null;
            goto L13
        L9:
            r9 = null;
            goto L10
        L49:
            return null;
        L36:
            e = move-exception;
            Log.e("OPTraceGSONParser", "deserialize error:" + e.getMessage());
            return null;
        L48:
            return null;
        }
    }

    public static final class a {
    }

    static {
        a = new GsonBuilder().registerTypeAdapter(OPTrace.class, new OPTraceTypeAdapter()).excludeFieldsWithoutExposeAnnotation().disableHtmlEscaping().create();
    }
}
