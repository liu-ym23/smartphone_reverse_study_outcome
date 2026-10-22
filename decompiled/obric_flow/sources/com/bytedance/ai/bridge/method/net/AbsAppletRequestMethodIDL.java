package com.bytedance.ai.bridge.method.net;

import ai.j0;
import androidx.annotation.Keep;
import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005\n\u000b\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$AppletRequestParamModel;", "Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$AppletRequestResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "AppletRequestParamModel", "AppletRequestResultModel", "StreamResponseData", "StreamResponseStatus", "RequestMethodType", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsAppletRequestMethodIDL extends CoreAIBridgeMethod<AppletRequestParamModel, AppletRequestResultModel> {
    private final String name;

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\t\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\"\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r\u0018\u00010\u00138gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r\u0018\u00010\u00138gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$AppletRequestParamModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "addCommonParams", "", "getAddCommonParams", "()Z", "url", "", "getUrl", "()Ljava/lang/String;", "method", "getMethod", "body", "", "getBody", "()Ljava/lang/Object;", "bodyType", "getBodyType", LynxResourceModule.PARAMS_KEY, "", "getParams", "()Ljava/util/Map;", "header", "getHeader", "isCustomizedCookie", "()Ljava/lang/Boolean;", "streamType", "getStreamType", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface AppletRequestParamModel extends ParamModel {
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

        @AIBridgeParamField(keyPath = LynxResourceModule.PARAMS_KEY, required = false)
        Map<String, Object> getParams();

        @AIBridgeParamField(keyPath = "streamType", required = false)
        String getStreamType();

        @AIBridgeParamField(keyPath = "url", required = true)
        String getUrl();

        @AIBridgeParamField(keyPath = "isCustomizedCookie", required = false)
        Boolean isCustomizedCookie();
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0013\bg\u0018\u00002\u00020\u0001R&\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR>\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u000e@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010\u0019\u001a\u0004\u0018\u00010\r2\b\u0010\u0002\u001a\u0004\u0018\u00010\r@gX¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR&\u0010\u001e\u001a\u0004\u0018\u00010\r2\b\u0010\u0002\u001a\u0004\u0018\u00010\r@gX¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u0006!"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$AppletRequestResultModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "value", "", "httpCode", "getHttpCode", "()Ljava/lang/Number;", "setHttpCode", "(Ljava/lang/Number;)V", "clientCode", "getClientCode", "setClientCode", "", "", "", "header", "getHeader", "()Ljava/util/Map;", "setHeader", "(Ljava/util/Map;)V", "response", "getResponse", "()Ljava/lang/Object;", "setResponse", "(Ljava/lang/Object;)V", "responseType", "getResponseType", "()Ljava/lang/String;", "setResponseType", "(Ljava/lang/String;)V", "sessionId", "getSessionId", "setSessionId", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface AppletRequestResultModel extends ResultModel {
        Number getClientCode();

        Map<String, Object> getHeader();

        Number getHttpCode();

        Object getResponse();

        String getResponseType();

        String getSessionId();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(intValue = 0, type = DefaultType.INT), keyPath = "clientCode", required = true)
        void setClientCode(Number r5);

        @AIBridgeParamField(keyPath = "header", required = false)
        void setHeader(Map<String, ? extends Object> r5);

        @AIBridgeParamField(keyPath = "httpCode", required = false)
        void setHttpCode(Number r5);

        @AIBridgeParamField(keyPath = "response", required = false)
        void setResponse(Object r5);

        @AIBridgeParamField(keyPath = "responseType", required = false)
        void setResponseType(String r5);

        @AIBridgeParamField(keyPath = "sessionId", required = false)
        void setSessionId(String r5);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$RequestMethodType;", "", "com/bytedance/ai/bridge/method/net/a", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum RequestMethodType extends Enum<RequestMethodType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f1857a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final RequestMethodType f1858b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ RequestMethodType[] f1859c = null;

        static {
            RequestMethodType r5 = new RequestMethodType("GET", 0);
            RequestMethodType r10 = new RequestMethodType("POST", 1);
            RequestMethodType r11 = new RequestMethodType("PUT", 2);
            RequestMethodType r12 = new RequestMethodType("DELETE", 3);
            RequestMethodType r13 = new RequestMethodType("UNSUPPORTED", 4);
            f1858b = r13;
            RequestMethodType[] r14 = {r5, r10, r11, r12, r13};
            f1859c = r14;
            EnumEntriesKt.enumEntries(r14);
            f1857a = new a();
        }

        public RequestMethodType(String r5, int r10) {
            super(r5, r10);
        }

        public static RequestMethodType valueOf(String r5) {
            return (RequestMethodType) Enum.valueOf(RequestMethodType.class, r5);
        }

        public static RequestMethodType[] values() {
            return (RequestMethodType[]) f1859c.clone();
        }
    }

    @Keep
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003JX\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u000bHÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012¨\u0006)"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseData;", "", "event", "Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseStatus;", "sessionId", "", "index", "", "data", "", "code", "", "message", "<init>", "(Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseStatus;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)V", "getEvent", "()Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseStatus;", "getSessionId", "()Ljava/lang/String;", "getIndex", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getData", "()Ljava/util/List;", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseStatus;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseData;", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StreamResponseData {
        private final Integer code;
        private final List<String> data;
        private final StreamResponseStatus event;
        private final Long index;
        private final String message;
        private final String sessionId;

        public StreamResponseData(StreamResponseStatus r5, String r10, Long r11, List<String> r12, Integer r13, String r14) {
            Intrinsics.checkNotNullParameter(r5, "event");
            Intrinsics.checkNotNullParameter(r10, "sessionId");
            this.event = r5;
            this.sessionId = r10;
            this.index = r11;
            this.data = r12;
            this.code = r13;
            this.message = r14;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StreamResponseData copy$default(StreamResponseData r5, StreamResponseStatus r10, String r11, Long r12, List r13, Integer r14, String r15, int r16, Object r17) {
            if ((r16 & 1) == 0) goto L6;
            r10 = r5.event;
        L6:
            if ((r16 & 2) == 0) goto L8;
            r11 = r5.sessionId;
        L8:
            String r18 = r11;
            if ((r16 & 4) == 0) goto L11;
            r12 = r5.index;
        L11:
            Long r19 = r12;
            if ((r16 & 8) == 0) goto L14;
            r13 = r5.data;
        L14:
            List r20 = r13;
            if ((r16 & 16) == 0) goto L17;
            r14 = r5.code;
        L17:
            Integer r21 = r14;
            if ((r16 & 32) == 0) goto L20;
            r15 = r5.message;
        L20:
            StreamResponseStatus r22 = r10;
            return r5.copy(r22, r18, r19, r20, r21, r15);
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

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof StreamResponseData) == true) goto L8;
            return false;
        L8:
            StreamResponseData r10 = (StreamResponseData) r5;
            if (this.event == r10.event) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.sessionId, r10.sessionId) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.index, r10.index) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.data, r10.data) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.code, r10.code) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.message, r10.message) == true) goto L26;
            return false;
        L26:
            return true;
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

        public int hashCode() {
            int r5 = kk.a.b(this.sessionId, this.event.hashCode() * 31, 31);
            Long r10 = this.index;
            int r11 = 0;
            if (r10 != null) goto L5;
            int r12 = 0;
        L6:
            int r13 = (r5 + r12) * 31;
            List<String> r14 = this.data;
            if (r14 != null) goto L9;
            int r15 = 0;
        L10:
            int r16 = (r13 + r15) * 31;
            Integer r17 = this.code;
            if (r17 != null) goto L13;
            int r18 = 0;
        L14:
            int r19 = (r16 + r18) * 31;
            String r20 = this.message;
            if (r20 == null) goto L19;
            r11 = r20.hashCode();
        L19:
            return r19 + r11;
        L13:
            r18 = r17.hashCode();
            goto L14
        L9:
            r15 = r14.hashCode();
            goto L10
        L5:
            r12 = r10.hashCode();
            goto L6
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("StreamResponseData(event=");
            r5.append(this.event);
            r5.append(", sessionId=");
            r5.append(this.sessionId);
            r5.append(", index=");
            r5.append(this.index);
            r5.append(", data=");
            r5.append(this.data);
            r5.append(", code=");
            r5.append(this.code);
            r5.append(", message=");
            return j0.p(r5, this.message, ')');
        }

        public /* synthetic */ StreamResponseData(StreamResponseStatus r10, String r11, Long r12, List r13, Integer r14, String r15, int r16, DefaultConstructorMarker r17) {
            if ((r16 & 4) == 0) goto L5;
            Long r5 = null;
        L7:
            if ((r16 & 8) == 0) goto L9;
            List r18 = null;
        L11:
            if ((r16 & 16) == 0) goto L13;
            Integer r19 = null;
        L15:
            if ((r16 & 32) == 0) goto L17;
            String r20 = null;
        L18:
            this(r10, r11, r5, r18, r19, r20);
            return;
        L17:
            r20 = r15;
            goto L18
        L13:
            r19 = r14;
            goto L15
        L9:
            r18 = r13;
            goto L11
        L5:
            r5 = r12;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseStatus;", "", "a", "b", "c", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum StreamResponseStatus extends Enum<StreamResponseStatus> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("data")
        public static final StreamResponseStatus f1860a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("complete")
        public static final StreamResponseStatus f1861b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("error")
        public static final StreamResponseStatus f1862c = null;
        public static final /* synthetic */ StreamResponseStatus[] d = null;

        static {
            StreamResponseStatus r5 = new StreamResponseStatus("DATA", 0);
            f1860a = r5;
            StreamResponseStatus r10 = new StreamResponseStatus("COMPLETE", 1);
            f1861b = r10;
            StreamResponseStatus r11 = new StreamResponseStatus("ERROR", 2);
            f1862c = r11;
            StreamResponseStatus[] r12 = {r5, r10, r11};
            d = r12;
            EnumEntriesKt.enumEntries(r12);
        }

        public StreamResponseStatus(String r5, int r10) {
            super(r5, r10);
        }

        public static StreamResponseStatus valueOf(String r5) {
            return (StreamResponseStatus) Enum.valueOf(StreamResponseStatus.class, r5);
        }

        public static StreamResponseStatus[] values() {
            return (StreamResponseStatus[]) d.clone();
        }
    }

    public AbsAppletRequestMethodIDL() {
        this.name = "applet.request";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return this.name;
    }
}
