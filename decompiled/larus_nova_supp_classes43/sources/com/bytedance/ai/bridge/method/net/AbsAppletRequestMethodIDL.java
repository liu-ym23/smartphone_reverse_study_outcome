package com.bytedance.ai.bridge.method.net;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005\n\u000b\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$AppletRequestParamModel;", "Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$AppletRequestResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "AppletRequestParamModel", "AppletRequestResultModel", "StreamResponseData", "StreamResponseStatus", "RequestMethodType", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsAppletRequestMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$RequestMethodType;", "", "<init>", "(Ljava/lang/String;I)V", "GET", "POST", "PUT", "DELETE", "UNSUPPORTED", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RequestMethodType extends Enum<RequestMethodType> {
        public static final a Companion = null;
        public static final RequestMethodType DELETE = null;
        public static final RequestMethodType GET = null;
        public static final RequestMethodType POST = null;
        public static final RequestMethodType PUT = null;
        public static final RequestMethodType UNSUPPORTED = null;
        public static final /* synthetic */ RequestMethodType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<RequestMethodType> getEntries() {
            return b;
        }

        static {
            RequestMethodType r0 = new RequestMethodType("GET", 0);
            GET = r0;
            RequestMethodType r1 = new RequestMethodType("POST", 1);
            POST = r1;
            RequestMethodType r10 = new RequestMethodType("PUT", 2);
            PUT = r10;
            RequestMethodType r11 = new RequestMethodType("DELETE", 3);
            DELETE = r11;
            RequestMethodType r12 = new RequestMethodType("UNSUPPORTED", 4);
            UNSUPPORTED = r12;
            RequestMethodType[] r13 = {r0, r1, r10, r11, r12};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
            Companion = new a();
        }

        public static RequestMethodType[] values() {
            return (RequestMethodType[]) a.clone();
        }

        public static RequestMethodType valueOf(String r1) {
            return (RequestMethodType) r27.a.a(RequestMethodType.class, r1);
        }

        public RequestMethodType(String r1, int r10) {
            super(r1, r10);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003JX\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u000bHÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012¨\u0006)"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseData;", "", "event", "Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseStatus;", "sessionId", "", "index", "", "data", "", "code", "", com.bytedance.android.ec.core.event.a.KEY_MSG, "<init>", "(Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseStatus;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)V", "getEvent", "()Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseStatus;", "getSessionId", "()Ljava/lang/String;", "getIndex", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getData", "()Ljava/util/List;", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseStatus;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseData;", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StreamResponseData {
        private final Integer code;
        private final List<String> data;
        private final StreamResponseStatus event;
        private final Long index;
        private final String message;
        private final String sessionId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StreamResponseData copy$default(StreamResponseData r10, StreamResponseStatus r11, String r12, Long r13, List r14, Integer r15, String r16, int r17, Object r18) {
            if ((r17 & 1) == 0) goto L6;
            r11 = r10.event;
        L6:
            if ((r17 & 2) == 0) goto L8;
            r12 = r10.sessionId;
        L8:
            String r19 = r12;
            if ((r17 & 4) == 0) goto L11;
            r13 = r10.index;
        L11:
            Long r0 = r13;
            if ((r17 & 8) == 0) goto L14;
            r14 = r10.data;
        L14:
            List r1 = r14;
            if ((r17 & 16) == 0) goto L17;
            r15 = r10.code;
        L17:
            Integer r20 = r15;
            if ((r17 & 32) == 0) goto L20;
            r16 = r10.message;
        L20:
            StreamResponseStatus r21 = r11;
            return r10.copy(r21, r19, r0, r1, r20, r16);
        }

        public final StreamResponseStatus component1() {
            return this.event;
        }

        public final String component2() {
            return this.sessionId;
        }

        public final Long component3() {
            return this.index;
        }

        public final List<String> component4() {
            return this.data;
        }

        public final Integer component5() {
            return this.code;
        }

        public final String component6() {
            return this.message;
        }

        public final StreamResponseData copy(StreamResponseStatus r10, String r11, Long r12, List<String> r13, Integer r14, String r15) {
            Intrinsics.checkNotNullParameter(r10, "event");
            Intrinsics.checkNotNullParameter(r11, "sessionId");
            return new StreamResponseData(r10, r11, r12, r13, r14, r15);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof StreamResponseData) == true) goto L8;
            return false;
        L8:
            StreamResponseData r11 = (StreamResponseData) r10;
            if (this.event == r11.event) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.sessionId, r11.sessionId) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.index, r11.index) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.data, r11.data) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.code, r11.code) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.message, r11.message) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.event.hashCode() * 31) + this.sessionId.hashCode()) * 31;
            Long r1 = this.index;
            int r10 = 0;
            if (r1 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = (r0 + r11) * 31;
            List<String> r13 = this.data;
            if (r13 != null) goto L9;
            int r14 = 0;
        L10:
            int r15 = (r12 + r14) * 31;
            Integer r16 = this.code;
            if (r16 != null) goto L13;
            int r17 = 0;
        L14:
            int r18 = (r15 + r17) * 31;
            String r19 = this.message;
            if (r19 == null) goto L19;
            r10 = r19.hashCode();
        L19:
            return r18 + r10;
        L13:
            r17 = r16.hashCode();
            goto L14
        L9:
            r14 = r13.hashCode();
            goto L10
        L5:
            r11 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "StreamResponseData(event=" + this.event + ", sessionId=" + this.sessionId + ", index=" + this.index + ", data=" + this.data + ", code=" + this.code + ", message=" + this.message + ')';
        }

        public final Integer getCode() {
            return this.code;
        }

        public final List<String> getData() {
            return this.data;
        }

        public final StreamResponseStatus getEvent() {
            return this.event;
        }

        public final Long getIndex() {
            return this.index;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public StreamResponseData(StreamResponseStatus r10, String r11, Long r12, List<String> r13, Integer r14, String r15) {
            Intrinsics.checkNotNullParameter(r10, "event");
            Intrinsics.checkNotNullParameter(r11, "sessionId");
            this.event = r10;
            this.sessionId = r11;
            this.index = r12;
            this.data = r13;
            this.code = r14;
            this.message = r15;
        }

        public /* synthetic */ StreamResponseData(StreamResponseStatus r10, String r11, Long r12, List r13, Integer r14, String r15, int r16, DefaultConstructorMarker r17) {
            if ((r16 & 4) == 0) goto L5;
            Long r18 = null;
        L7:
            if ((r16 & 8) == 0) goto L9;
            List r19 = null;
        L11:
            if ((r16 & 16) == 0) goto L13;
            Integer r20 = null;
        L15:
            if ((r16 & 32) == 0) goto L17;
            String r21 = null;
        L18:
            this(r10, r11, r18, r19, r20, r21);
            return;
        L17:
            r21 = r15;
            goto L18
        L13:
            r20 = r14;
            goto L15
        L9:
            r19 = r13;
            goto L11
        L5:
            r18 = r12;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseStatus;", "", "<init>", "(Ljava/lang/String;I)V", "DATA", "COMPLETE", "ERROR", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum StreamResponseStatus extends Enum<StreamResponseStatus> {

        @SerializedName("complete")
        public static final StreamResponseStatus COMPLETE = null;

        @SerializedName("data")
        public static final StreamResponseStatus DATA = null;

        @SerializedName(IHostStyleUIDepend.TOAST_TYPE_ERROR)
        public static final StreamResponseStatus ERROR = null;
        public static final /* synthetic */ StreamResponseStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<StreamResponseStatus> getEntries() {
            return b;
        }

        static {
            StreamResponseStatus r0 = new StreamResponseStatus("DATA", 0);
            DATA = r0;
            StreamResponseStatus r1 = new StreamResponseStatus("COMPLETE", 1);
            COMPLETE = r1;
            StreamResponseStatus r10 = new StreamResponseStatus("ERROR", 2);
            ERROR = r10;
            StreamResponseStatus[] r11 = {r0, r1, r10};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static StreamResponseStatus[] values() {
            return (StreamResponseStatus[]) a.clone();
        }

        public static StreamResponseStatus valueOf(String r1) {
            return (StreamResponseStatus) r27.a.a(StreamResponseStatus.class, r1);
        }

        public StreamResponseStatus(String r1, int r10) {
            super(r1, r10);
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(boolValue = true, type = DefaultType.BOOL), keyPath = "addCommonParams", required = true)
        boolean getAddCommonParams();

        @AIBridgeParamField(keyPath = "body", required = false)
        Object getBody();

        @AIBridgeParamField(keyPath = "bodyType", required = false)
        String getBodyType();

        @AIBridgeParamField(keyPath = "header", required = false)
        Map<String, Object> getHeader();

        @AIBridgeParamField(keyPath = "method", required = true)
        String getMethod();

        @AIBridgeParamField(keyPath = "params", required = false)
        Map<String, Object> getParams();

        @AIBridgeParamField(keyPath = "streamType", required = false)
        String getStreamType();

        @AIBridgeParamField(keyPath = com.bytedance.android.ec.core.event.a.KEY_URL, required = true)
        String getUrl();

        @AIBridgeParamField(keyPath = "isCustomizedCookie", required = false)
        Boolean isCustomizedCookie();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(intValue = 0, type = DefaultType.INT), keyPath = "clientCode", required = true)
        void setClientCode(Number r1);

        @AIBridgeParamField(keyPath = "header", required = false)
        void setHeader(Map<String, ? extends Object> r1);

        @AIBridgeParamField(keyPath = "httpCode", required = false)
        void setHttpCode(Number r1);

        @AIBridgeParamField(keyPath = "response", required = false)
        void setResponse(Object r1);

        @AIBridgeParamField(keyPath = "responseType", required = false)
        void setResponseType(String r1);

        @AIBridgeParamField(keyPath = "sessionId", required = false)
        void setSessionId(String r1);
    }

    public AbsAppletRequestMethodIDL() {
        this.a = "applet.request";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
