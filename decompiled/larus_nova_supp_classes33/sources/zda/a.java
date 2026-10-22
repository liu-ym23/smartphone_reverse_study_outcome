package zda;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.lang.reflect.Type;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final a a = null;

    /* JADX INFO: renamed from: zda.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/obric/assistant/entity/IntentCardEntityParser$parseAppIntentMessage$type$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/obric/aiagent/assistant/idl/bean/AppIntentMessage;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C0076a extends TypeToken<AppIntentMessage> {
        public C0076a() {
        }
    }

    static {
        a = new a();
    }

    public a() {
    }

    public static String b(String r8) {
        JsonObject r9 = GsonProtectorUtils.parse(new JsonParser(), r8).getAsJsonObject();
        JsonElement r0 = r9.get("data");
        if (r0 != null) goto L5;
    L18:
        JsonElement r1 = r9.get("dataV2");
        if (r1 == null) goto L42;
        if (r1.isJsonArray() == false) goto L23;
        JsonArray r2 = r1.getAsJsonArray();
    L24:
        if (r2 == null) goto L42;
        Iterator r3 = r2.iterator();
    L27:
        if (r3.hasNext() == false) goto L42;
        JsonElement r6 = (JsonElement) r3.next();
        a r7 = a;
        Intrinsics.checkNotNull(r6);
        r7.getClass();
        if (r6.isJsonObject() == false) goto L31;
        JsonObject r10 = r6.getAsJsonObject();
    L32:
        if (r10 == null) goto L27;
        JsonElement r11 = r10.get("appEntity");
        if (r11 == null) goto L27;
        if (r11.isJsonObject() == false) goto L38;
        JsonObject r12 = r11.getAsJsonObject();
    L39:
        if (r12 == null) goto L27;
        a(r12, "createTime", "createTimeStamp");
        a(r12, "lastModifiedTime", "lastModifiedTimeStamp");
        goto L27
    L38:
        r12 = null;
        goto L39
    L31:
        r10 = null;
        goto L32
    L23:
        r2 = null;
    L42:
        return r9.toString();
    L5:
        if (r0.isJsonArray() == false) goto L7;
        JsonArray r4 = r0.getAsJsonArray();
    L8:
        if (r4 == null) goto L18;
        Iterator r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L18;
        JsonElement r13 = (JsonElement) r5.next();
        a r14 = a;
        Intrinsics.checkNotNull(r13);
        r14.getClass();
        if (r13.isJsonObject() == false) goto L15;
        JsonObject r15 = r13.getAsJsonObject();
    L16:
        if (r15 == null) goto L11;
        a(r15, "createTime", "createTimeStamp");
        a(r15, "lastModifiedTime", "lastModifiedTimeStamp");
        goto L11
    L15:
        r15 = null;
        goto L16
    L7:
        r4 = null;
        goto L8
    }

    public static AppEntity c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "rawJson");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(AppEntity.CREATOR.fromJson(r2));     // Catch: Throwable -> L5
    L8:
        if (Result.exceptionOrNull-impl(r1) != null) goto L19;
    L15:
        ResultKt.throwOnFailure(r1);
        return (AppEntity) r1;
    L19:
        Object r3 = Result.constructor-impl(AppEntity.CREATOR.fromJsonKeepTimeStamp(r2));     // Catch: Throwable -> L12
    L14:
        r1 = r3;
    L12:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static AppEntity d(JSONObject r1) {
        Intrinsics.checkNotNullParameter(r1, "entityJson");
        return c(r1.toString());
    }

    public static AppIntentMessage e(String r3) {
        Intrinsics.checkNotNullParameter(r3, "rawJson");
        Type r0 = new C0076a().getType();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl((AppIntentMessage) EntityExtKt.a().fromJson(r3, r0));     // Catch: Throwable -> L5
    L8:
        if (Result.exceptionOrNull-impl(r2) != null) goto L17;
    L15:
        ResultKt.throwOnFailure(r2);
        return (AppIntentMessage) r2;
    L17:
        Gson r4 = EntityExtKt.a();     // Catch: Throwable -> L12
        a.getClass();     // Catch: Throwable -> L12
        Object r5 = Result.constructor-impl((AppIntentMessage) r4.fromJson(b(r3), r0));     // Catch: Throwable -> L12
    L14:
        r2 = r5;
    L12:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static void a(JsonObject r4, String r5, String r6) {
        if (r4.has(r6) == false) goto L5;
        return;
    L5:
        JsonElement r7 = r4.get(r5);
        if (r7 == null) goto L32;
        Long r1 = null;
        Object r2 = null;
        if (r7.isJsonPrimitive() == false) goto L27;
        JsonPrimitive r8 = r7.getAsJsonPrimitive();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L20
        if (r8.isNumber() == false) goto L15;
        Long r9 = Long.valueOf(r8.getAsLong());     // Catch: Throwable -> L20
    L18:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L20
    L23:
        if (Result.isFailure-impl(r10) == true) goto L26;
        r2 = r10;
    L26:
        r1 = (Long) r2;
        goto L27
    L15:
        if (r8.isString() == false) goto L17;
        r9 = StringsKt.toLongOrNull(r8.getAsString());     // Catch: Throwable -> L20
        goto L18
    L17:
        r9 = null;
    L20:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L27:
        if (r1 == null) goto L33;
        r4.addProperty(r6, Long.valueOf(r1.longValue()));
        return;
    L33:
        return;
    }
}
