package com.obric.aikernel.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.security.dbcipher.utils.CipherConst;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.WebSocket;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nJ\u0012\u0010\r\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0012"}, d2 = {"Lcom/obric/aikernel/debug/WebSocketUtils;", "", "()V", "sendLog", "", "socket", "Lokhttp3/WebSocket;", "priority", "", LocationMonitorConst.TAG, "", "log", "date", "sendResponse", NotificationCompat.CATEGORY_MESSAGE, "Lcom/obric/aikernel/debug/WebSocketUtils$Message;", "DebugInfo", "Message", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5980a = null;

    /* JADX INFO: renamed from: com.obric.aikernel.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/aikernel/debug/WebSocketUtils$Message;", "", "type", "", OaidModel.KEY_ID, ChatMessage.TYPE_RESPONSE, Params.CONTENT, "Lcom/google/gson/JsonElement;", "from", TypedValues.AttributesType.S_TARGET, "sendTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonElement;Ljava/lang/String;Ljava/lang/String;J)V", "getContent", "()Lcom/google/gson/JsonElement;", "getFrom", "()Ljava/lang/String;", "getId", "getResponse", "getSendTime", "()J", "getTarget", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0248a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("type")
        private final String f5981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName(OaidModel.KEY_ID)
        private final String f5982b;

        @SerializedName(ChatMessage.TYPE_RESPONSE)
        private final String c;

        @SerializedName(Params.CONTENT)
        private final JsonElement d;

        @SerializedName("from")
        private final String e;

        @SerializedName(TypedValues.AttributesType.S_TARGET)
        private final String f;

        @SerializedName("send_time")
        private final long g;

        public C0248a(String r2, String r3, String r4, JsonElement r5, String r6, String r7, long r8) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_ID);
            Intrinsics.checkNotNullParameter(r4, ChatMessage.TYPE_RESPONSE);
            Intrinsics.checkNotNullParameter(r5, Params.CONTENT);
            Intrinsics.checkNotNullParameter(r6, "from");
            Intrinsics.checkNotNullParameter(r7, TypedValues.AttributesType.S_TARGET);
            this.f5981a = r2;
            this.f5982b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }

        public /* synthetic */ C0248a(String r8, String r9, String r10, JsonElement r11, String r12, String r13, long r14, int r16, DefaultConstructorMarker r17) {
            String r1 = "";
            if ((r16 & 2) == 0) goto L5;
            String r0 = "";
        L7:
            if ((r16 & 4) != 0) goto L11;
            r1 = r10;
        L11:
            if ((r16 & 8) == 0) goto L13;
            JsonNull r2 = JsonNull.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(r2, "INSTANCE");
            JsonElement r3 = (JsonElement) ZeusTransformUtils.preCheckCast(r2, JsonElement.class, "com.obric.memorydata.plugin");
        L15:
            if ((r16 & 16) == 0) goto L17;
            String r4 = "client";
        L19:
            if ((r16 & 32) == 0) goto L21;
            String r5 = "browser";
        L23:
            if ((r16 & 64) == 0) goto L25;
            long r6 = System.currentTimeMillis();
        L26:
            this(r8, r0, r1, r3, r4, r5, r6);
            return;
        L25:
            r6 = r14;
            goto L26
        L21:
            r5 = r13;
            goto L23
        L17:
            r4 = r12;
            goto L19
        L13:
            r3 = r11;
            goto L15
        L5:
            r0 = r9;
            goto L7
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, C0248a.class) == true) goto L8;
            return false;
        L8:
            C0248a r8 = (C0248a) ZeusTransformUtils.preCheckCast(r7, C0248a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f5981a, r8.f5981a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f5982b, r8.f5982b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r8.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r8.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r8.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r8.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r8.g) goto L29;
            return false;
        L29:
            return true;
        }

        public final String getType() {
            return this.f5981a;
        }

        public int hashCode() {
            return (((((((((((this.f5981a.hashCode() * 31) + this.f5982b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + Long.hashCode(this.g);
        }

        public String toString() {
            return "Message(type=" + this.f5981a + ", id=" + this.f5982b + ", response=" + this.c + ", content=" + this.d + ", from=" + this.e + ", target=" + this.f + ", sendTime=" + this.g + ')';
        }
    }

    static {
        f5980a = new a();
    }

    private a() {
    }

    public static /* synthetic */ void a(a r6, WebSocket r7, int r8, String r9, String r10, String r11, int r12, Object r13) {
        WebSocket r1 = (WebSocket) ZeusTransformUtils.wrapperContextForParams(r7, WebSocket.class, "com.obric.memorydata.plugin");
        if ((r12 & 16) == 0) goto L5;
        r11 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
        Intrinsics.checkNotNullExpressionValue(r11, "SimpleDateFormat(\"yyyy-M…Default()).format(Date())");
    L5:
        r6.a(r1, r8, r9, r10, r11);
    }

    public final void a(WebSocket r27, int r28, String r29, String r30, String r31) {
        String r2 = r30;
        WebSocket r4 = (WebSocket) ZeusTransformUtils.wrapperContextForParams(r27, WebSocket.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r29, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r2, "log");
        Intrinsics.checkNotNullParameter(r31, "date");
        String r8 = CipherConst.LEVEL_DEBUG;
        if (r28 != 2) goto L5;
        r8 = "VERBOSE";
    L17:
        boolean r12 = false;
        Object r10 = "";
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r29, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("@", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L32;
        List r0 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r29, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"@"}, false, 0, 6, null);
        if (r0.size() != 2) goto L32;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r0.get(0), CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("-", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L29;
        List r1 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r0.get(0), CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"-"}, false, 0, 6, null);
        if (r1.size() != 1) goto L27;
        Object r3 = r1.get(0);
    L30:
        r10 = r3;
    L31:
        Object r5 = r0.get(1);
    L33:
        if (r4 == null) goto L41;
        String r17 = null;
        String r18 = null;
        JsonObject r6 = new JsonObject();
        JsonObject r9 = new JsonObject();
        r9.addProperty("level", r8);
        r9.addProperty("log", r2);
        r9.addProperty("date", r31);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L37;
        r12 = true;
    L37:
        if (r12 == false) goto L39;
        r9.addProperty("business_name", (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin"));
        r9.addProperty("business_version", (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin"));
    L39:
        Unit r7 = Unit.INSTANCE;
        r6.add("logs", (JsonElement) ZeusTransformUtils.preCheckCast(r9, JsonElement.class, "com.obric.memorydata.plugin"));
        Unit r11 = Unit.INSTANCE;
        a(r4, new C0248a("logs", r17, r18, (JsonElement) ZeusTransformUtils.preCheckCast(r6, JsonElement.class, "com.obric.memorydata.plugin"), null, null, 0, 118, null));
        return;
    L41:
        return;
    L27:
        if (r1.size() != 2) goto L31;
        Object r13 = r1.get(1);
        r2 = ((String) ZeusTransformUtils.preCheckCast(r1.get(0), String.class, "com.obric.memorydata.plugin")) + ": " + r2;
        r10 = r13;
        goto L31
    L29:
        r3 = r0.get(0);
    L32:
        r5 = "";
        goto L33
    L5:
        if (r28 == 3) goto L17;
        if (r28 != 4) goto L9;
        r8 = CipherConst.LEVEL_INFO;
        goto L17
    L9:
        if (r28 != 5) goto L11;
        r8 = "WARNING";
        goto L17
    L11:
        if (r28 != 6) goto L17;
        r8 = CipherConst.LEVEL_ERROR;
        goto L17
    }

    public final void a(WebSocket r2, C0248a r3) {
        WebSocket r1 = (WebSocket) ZeusTransformUtils.wrapperContextForParams(r2, WebSocket.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        String r4 = new Gson().toJson(r3);
        Intrinsics.checkNotNullExpressionValue(r4, "Gson().toJson(msg)");
        r1.send(r4);
    }
}
