package com.obric.memorydata.aikernelcore;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crypto.platform.PlatformConst;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002)*B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0002J2\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\rJ\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J \u0010!\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010!\u001a\u00020\r2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\n\u0010&\u001a\u0004\u0018\u00010$H\u0002J\b\u0010'\u001a\u00020\rH\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/memorydata/aikernelcore/WebSocketManager;", "", "<init>", "()V", "listener", "com/obric/memorydata/aikernelcore/WebSocketManager$listener$1", "Lcom/obric/memorydata/aikernelcore/WebSocketManager$listener$1;", "socket", "Lokhttp3/WebSocket;", ObricMemoryConstants.KEY_SESSION_ID, "", "wsUrl", "connect", "", "url", "onInit", "context", "Landroid/content/Context;", "isCliConnected", "", "connectWs", "sendLog", "logLevel", "", LocationMonitorConst.TAG, "log", "date", "version", "sendHandshake", "onMessage", NotificationCompat.CATEGORY_MESSAGE, "Lcom/obric/memorydata/aikernelcore/WebSocketManager$Message;", "sendResponse", "writeDebugInfo", "pkg", "info", "Lcom/obric/memorydata/aikernelcore/WebSocketManager$DebugInfo;", "updateSession", "getDebugInfo", "cleanDebugInfo", "TAG", "Message", "DebugInfo", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WebSocketManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WebSocketManager f8445a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f8446b = null;
    private static WebSocket c;
    private static String d;
    private static String e;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/aikernelcore/WebSocketManager$DebugInfo;", "", ObricMemoryConstants.KEY_SESSION_ID, "", "targetPackage", "wsUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "getTargetPackage", "getWsUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("session_id")
        private final String f8447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("target_package")
        private final String f8448b;

        @SerializedName("ws_url")
        private final String c;

        public a(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_SESSION_ID);
            Intrinsics.checkNotNullParameter(r3, "targetPackage");
            Intrinsics.checkNotNullParameter(r4, "wsUrl");
            this.f8447a = r2;
            this.f8448b = r3;
            this.c = r4;
        }

        public final String a() {
            return this.f8447a;
        }

        public final String b() {
            return this.f8448b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8447a, r6.f8447a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8448b, r6.f8448b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f8447a.hashCode() * 31) + this.f8448b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "DebugInfo(sessionId=" + this.f8447a + ", targetPackage=" + this.f8448b + ", wsUrl=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/obric/memorydata/aikernelcore/WebSocketManager$Message;", "", "type", "", OaidModel.KEY_ID, ChatMessage.TYPE_RESPONSE, Params.CONTENT, "Lcom/google/gson/JsonElement;", "from", TypedValues.AttributesType.S_TARGET, "sendTime", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonElement;Ljava/lang/String;Ljava/lang/String;J)V", "getType", "()Ljava/lang/String;", "getId", "getResponse", "getContent", "()Lcom/google/gson/JsonElement;", "getFrom", "getTarget", "getSendTime", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("type")
        private final String f8449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName(OaidModel.KEY_ID)
        private final String f8450b;

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

        public b(String r2, String r3, String r4, JsonElement r5, String r6, String r7, long r8) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_ID);
            Intrinsics.checkNotNullParameter(r4, ChatMessage.TYPE_RESPONSE);
            Intrinsics.checkNotNullParameter(r5, Params.CONTENT);
            Intrinsics.checkNotNullParameter(r6, "from");
            Intrinsics.checkNotNullParameter(r7, TypedValues.AttributesType.S_TARGET);
            this.f8449a = r2;
            this.f8450b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }

        public /* synthetic */ b(String r8, String r9, String r10, JsonElement r11, String r12, String r13, long r14, int r16, DefaultConstructorMarker r17) {
            String r1 = "";
            if ((r16 & 2) == 0) goto L5;
            String r0 = "";
        L7:
            if ((r16 & 4) != 0) goto L11;
            r1 = r10;
        L11:
            if ((r16 & 8) == 0) goto L13;
            JsonElement r2 = (JsonElement) ZeusTransformUtils.preCheckCast(JsonNull.INSTANCE, JsonElement.class, "com.obric.memorydata.plugin");
        L15:
            if ((r16 & 16) == 0) goto L17;
            String r3 = "client";
        L19:
            if ((r16 & 32) == 0) goto L21;
            String r4 = "browser";
        L23:
            if ((r16 & 64) == 0) goto L25;
            long r5 = System.currentTimeMillis();
        L26:
            this(r8, r0, r1, r2, r3, r4, r5);
            return;
        L25:
            r5 = r14;
            goto L26
        L21:
            r4 = r13;
            goto L23
        L17:
            r3 = r12;
            goto L19
        L13:
            r2 = r11;
            goto L15
        L5:
            r0 = r9;
            goto L7
        }

        public final String a() {
            return this.f8450b;
        }

        public final JsonElement b() {
            return this.d;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, b.class) == true) goto L8;
            return false;
        L8:
            b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8449a, r8.f8449a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8450b, r8.f8450b) == true) goto L15;
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
            return this.f8449a;
        }

        public int hashCode() {
            return (((((((((((this.f8449a.hashCode() * 31) + this.f8450b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + Long.hashCode(this.g);
        }

        public String toString() {
            return "Message(type=" + this.f8449a + ", id=" + this.f8450b + ", response=" + this.c + ", content=" + this.d + ", from=" + this.e + ", target=" + this.f + ", sendTime=" + this.g + ')';
        }
    }

    @Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0016J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\"\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0015"}, d2 = {"com/obric/memorydata/aikernelcore/WebSocketManager$listener$1", "Lokhttp3/WebSocketListener;", "onOpen", "", "webSocket", "Lokhttp3/WebSocket;", ChatMessage.TYPE_RESPONSE, "Lokhttp3/Response;", "onMessage", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "bytes", "Lokio/ByteString;", "onClosing", "code", "", InfoRequestQPSOptTraceLogger.REASON, "onClosed", "onFailure", "t", "", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends WebSocketListener {
        c() {
        }

        @Override // okhttp3.WebSocketListener
        public void onClosed(WebSocket r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter((WebSocket) ZeusTransformUtils.wrapperContextForParams(r2, WebSocket.class, "com.obric.memorydata.plugin"), "webSocket");
            Intrinsics.checkNotNullParameter(r4, InfoRequestQPSOptTraceLogger.REASON);
            com.obric.aikernel.runtime.utils.d.f6216a.g("WebSocketManager", "onClosed: " + r3 + ' ' + r4);
            WebSocketManager r1 = WebSocketManager.f8445a;
            WebSocketManager.a(null);
            WebSocketManager.a(WebSocketManager.f8445a);
        }

        @Override // okhttp3.WebSocketListener
        public void onClosing(WebSocket r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter((WebSocket) ZeusTransformUtils.wrapperContextForParams(r2, WebSocket.class, "com.obric.memorydata.plugin"), "webSocket");
            Intrinsics.checkNotNullParameter(r4, InfoRequestQPSOptTraceLogger.REASON);
            com.obric.aikernel.runtime.utils.d.f6216a.g("WebSocketManager", "onClosing: " + r3 + ' ' + r4);
            WebSocketManager r1 = WebSocketManager.f8445a;
            WebSocketManager.a(null);
            WebSocketManager.a(WebSocketManager.f8445a);
        }

        @Override // okhttp3.WebSocketListener
        public void onFailure(WebSocket r2, Throwable r3, Response r4) {
            Intrinsics.checkNotNullParameter((WebSocket) ZeusTransformUtils.wrapperContextForParams(r2, WebSocket.class, "com.obric.memorydata.plugin"), "webSocket");
            Intrinsics.checkNotNullParameter(r3, "t");
            com.obric.aikernel.runtime.utils.d.f6216a.g("WebSocketManager", "onFailure: " + r4 + ' ' + ExceptionsKt.stackTraceToString(r3));
            WebSocketManager.a(WebSocketManager.f8445a);
        }

        @Override // okhttp3.WebSocketListener
        public void onMessage(WebSocket r4, String r5) {
            Intrinsics.checkNotNullParameter((WebSocket) ZeusTransformUtils.wrapperContextForParams(r4, WebSocket.class, "com.obric.memorydata.plugin"), "webSocket");
            Intrinsics.checkNotNullParameter(r5, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            com.obric.aikernel.runtime.utils.d.f6216a.d("WebSocketManager", "onMessage: " + r5);
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L5
            c r3 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
            WebSocketManager r7 = WebSocketManager.f8445a;     // Catch: Throwable -> L5
            Object r8 = new Gson().fromJson(r5, b.class);     // Catch: Throwable -> L5
            Intrinsics.checkNotNullExpressionValue(r8, "fromJson(...)");     // Catch: Throwable -> L5
            WebSocketManager.b(r7, (b) ZeusTransformUtils.preCheckCast(r8, b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
            Object r9 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L7:
            Throwable r10 = Result.m1424exceptionOrNullimpl(r9);
            if (r10 == null) goto L13;
            com.obric.aikernel.runtime.utils.d.f6216a.g("WebSocketManager", "onMessage: error " + ExceptionsKt.stackTraceToString(r10));
            return;
        L13:
            return;
        L5:
            th = move-exception;
            Result.Companion r11 = Result.Companion;
            r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        @Override // okhttp3.WebSocketListener
        public void onMessage(WebSocket r3, ByteString r4) {
            WebSocket r5 = (WebSocket) ZeusTransformUtils.wrapperContextForParams(r3, WebSocket.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "webSocket");
            Intrinsics.checkNotNullParameter(r4, "bytes");
            onMessage(r5, r4.string(Charsets.UTF_8));
        }

        @Override // okhttp3.WebSocketListener
        public void onOpen(WebSocket r2, Response r3) {
            WebSocket r1 = (WebSocket) ZeusTransformUtils.wrapperContextForParams(r2, WebSocket.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "webSocket");
            Intrinsics.checkNotNullParameter(r3, ChatMessage.TYPE_RESPONSE);
            com.obric.aikernel.runtime.utils.d.f6216a.e("WebSocketManager", "onOpen: ");
            WebSocketManager r4 = WebSocketManager.f8445a;
            WebSocketManager.a(r1);
            WebSocketManager r5 = WebSocketManager.f8445a;
            String r6 = WebSocketManager.c();
            if (r6 != null) goto L5;
            return;
        L5:
            String r7 = WebSocketManager.b();
            if (r7 != null) goto L8;
            return;
        L8:
            WebSocketManager.a(r5, r6, r7);
        }
    }

    static {
        f8445a = new WebSocketManager();
        f8446b = new c();
    }

    private WebSocketManager() {
    }

    private final void a(a r4) {
        File r3 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "aee_debug_info.json");
        String r5 = new Gson().toJson(r4);
        Intrinsics.checkNotNullExpressionValue(r5, "toJson(...)");
        FilesKt.writeText$default(r3, r5, null, 2, null);
    }

    private final void a(b r13) {
        String r0 = r13.getType();
        switch(r0.hashCode()) {
            case -1346283505: goto L28;
            case -1274890954: goto L24;
            case -807062458: goto L14;
            case 3441010: goto L10;
            case 70679543: goto L6;
            default: goto L37;
        };
    L37:
        return;
    L6:
        if (r0.equals("handshake") == false) goto L38;
        a();
        return;
    L38:
        return;
    L10:
        if (r0.equals("ping") == false) goto L39;
        b(new b("pong", r13.a(), null, null, null, null, 0, 124, null));
        return;
    L39:
        return;
    L14:
        if (r0.equals("package") == false) goto L40;
        JsonObject r14 = r13.b().getAsJsonObject();
        if (r14 == null) goto L36;
        JsonElement r12 = r14.get("package");
        if (r12 == null) goto L21;
        JsonObject r15 = r12.getAsJsonObject();
    L22:
        com.obric.aikernel.runtime.utils.d.f6216a.e("WebSocketManager", "onMessage: debugPushPackageInfo " + r15);
        al r4 = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
        CoroutineContext r5 = null;
        CoroutineStart r6 = null;
        Object r16 = ZeusTransformUtils.preCheckCast(new WebSocketManager$onMessage$1$1(r14, r15, null), Function2.class, "com.obric.memorydata.plugin");
    L32:
        i.a(r4, r5, r6, (Function2) r16, 3, null);
        return;
    L21:
        r15 = null;
        goto L22
    L36:
        return;
    L40:
        return;
    L24:
        if (r0.equals("deep_clean") == false) goto L41;
        r4 = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
        r5 = null;
        r6 = null;
        Object r17 = new WebSocketManager$onMessage$2(null);
    L31:
        r16 = ZeusTransformUtils.preCheckCast(r17, Function2.class, "com.obric.memorydata.plugin");
        goto L32
    L41:
        return;
    L28:
        if (r0.equals("execute_task") == false) goto L42;
        r4 = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
        r5 = null;
        r6 = null;
        r17 = new WebSocketManager$onMessage$3(r13, null);
        goto L31
    }

    public static final /* synthetic */ void a(WebSocketManager r0) {
        r0.e();
    }

    public static /* synthetic */ void a(WebSocketManager r6, int r7, String r8, String r9, String r10, String r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
    L5:
        String r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        r11 = "";
    L8:
        r6.a(r7, r8, r9, r4, r11);
    }

    public static final /* synthetic */ void a(WebSocketManager r0, b r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ void a(WebSocketManager r0, String r1, String r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(WebSocketManager r0, String r1, String r2, String r3) {
        r0.a(r1, r2, r3);
    }

    private final void a(String r3, String r4) {
        a r2 = d();
        if (r2 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r3, r2.a()) == false) goto L9;
        f8445a.a(new a(r3, r2.b(), r4));
        return;
    }

    private final void a(String r4, String r5, String r6) {
        File r3 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "aee_debug_info.json");
        String r7 = new Gson().toJson(new a(r4, r5, r6));
        Intrinsics.checkNotNullExpressionValue(r7, "toJson(...)");
        FilesKt.writeText$default(r3, r7, null, 2, null);
    }

    public static final /* synthetic */ void a(WebSocket r2) {
        c = (WebSocket) ZeusTransformUtils.wrapperContextForParams(r2, WebSocket.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ String b() {
        return e;
    }

    private final void b(b r2) {
        WebSocket r1 = c;
        if (r1 == null) goto L6;
        String r3 = new Gson().toJson(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "toJson(...)");
        r1.send(r3);
        return;
    }

    public static final /* synthetic */ void b(WebSocketManager r0, b r1) {
        r0.a(r1);
    }

    private final void b(String r5) {
        com.obric.aikernel.runtime.utils.d.f6216a.g("WebSocketManager", "connectWs: " + r5);
        new OkHttpClient().newWebSocket(new Request.Builder().url(r5).build(), (WebSocketListener) ZeusTransformUtils.preCheckCast(f8446b, WebSocketListener.class, "com.obric.memorydata.plugin"));
        e = r5;
    }

    public static final /* synthetic */ String c() {
        return d;
    }

    private final a d() {
        File r4 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "aee_debug_info.json");
        if (r4.canRead() == true) goto L5;
        return null;
    L5:
        return (a) ZeusTransformUtils.preCheckCast(new Gson().fromJson(FilesKt.readText$default(r4, null, 1, null), a.class), a.class, "com.obric.memorydata.plugin");
    }

    private final void e() {
        new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "aee_debug_info.json").delete();
    }

    public final void a() {
        String r4 = String.valueOf(System.currentTimeMillis());
        JsonObject r13 = new JsonObject();
        JsonObject r0 = new JsonObject();
        r0.addProperty("aid", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(AppContext.INSTANCE.getAid()), Number.class, "com.obric.memorydata.plugin"));
        r0.addProperty("did", AppContext.INSTANCE.getServerDeviceId());
        r0.addProperty("uid", AppContext.INSTANCE.getUserId());
        r0.addProperty("app_version", AppContext.INSTANCE.getVersionName());
        r0.addProperty(WsConstants.KEY_PLATFORM, "android");
        r0.addProperty("plugin_version", "");
        r0.addProperty("channel", AppContext.INSTANCE.getChannel());
        r0.addProperty("device_model", Build.MODEL);
        r0.addProperty("os_version", Build.VERSION.BASE_OS);
        r0.addProperty("sdk_build_version", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(Build.VERSION.SDK_INT), Number.class, "com.obric.memorydata.plugin"));
        r0.addProperty(PlatformConst.BUNDLE_KEY_SOC_MODEL, "SM8750");
        r0.addProperty("product", Build.PRODUCT);
        r0.addProperty("python_version", com.obric.aee.BuildConfig.PLATFORM_PYTHON_VERSION);
        r0.addProperty("sdk_version", "4.0.0");
        r0.addProperty("device_ndk_version", "r21b");
        r0.addProperty("sem_app_version", "3.7.2");
        r0.addProperty("project_id", "542488");
        r0.addProperty("send_time", (Number) ZeusTransformUtils.preCheckCast(Long.valueOf(System.currentTimeMillis()), Number.class, "com.obric.memorydata.plugin"));
        Unit r1 = Unit.INSTANCE;
        r13.add("client_info", (JsonElement) ZeusTransformUtils.preCheckCast(r0, JsonElement.class, "com.obric.memorydata.plugin"));
        Unit r2 = Unit.INSTANCE;
        String r3 = "handshake";
        String r5 = null;
        b r14 = new b(r3, r4, r5, (JsonElement) ZeusTransformUtils.preCheckCast(r13, JsonElement.class, "com.obric.memorydata.plugin"), null, null, 0, 116, null);
        WebSocket r6 = c;
        if (r6 == null) goto L6;
        String r15 = new Gson().toJson(r14);
        Intrinsics.checkNotNullExpressionValue(r15, "toJson(...)");
        r6.send(r15);
        return;
    }

    public final void a(int r9, String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r11, "log");
        Intrinsics.checkNotNullParameter(r12, "date");
        Intrinsics.checkNotNullParameter(r13, "version");
        com.obric.aikernel.a.a.a(com.obric.aikernel.a.a.f5980a, c, r9, r10, r11, null, 16, null);
    }

    public final void a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "url");
        com.obric.aikernel.runtime.utils.d.f6216a.g("WebSocketManager", "connect: " + r6);
        Uri r7 = Uri.parse(r6);
        String r0 = r7.getQueryParameter("session_id");
        String r8 = r7.getQueryParameter("ws") + '/' + r0 + "?identity=client";
        d = r0;
        com.obric.aikernel.runtime.utils.d.f6216a.g("WebSocketManager", "connect: " + r8);
        b(r8);
    }

    @com.obric.aee.utils.a
    public final boolean isCliConnected() {
        if (c != null) goto L5;
        return true;
    L5:
        return false;
    }
}
