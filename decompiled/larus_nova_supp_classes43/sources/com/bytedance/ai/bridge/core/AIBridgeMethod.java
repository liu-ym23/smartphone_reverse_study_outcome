package com.bytedance.ai.bridge.core;

import androidx.core.util.Consumer;
import com.bytedance.ai.event.MessageIndication;
import com.google.gson.JsonObject;
import e3.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface AIBridgeMethod {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B5\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fB!\b\u0017\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\rB\u0015\b\u0016\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/bridge/core/AIBridgeMethod$Error;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "code", "", MessageIndication.MESSAGE_TYPE_MSG, "", "data", "Lcom/google/gson/JsonObject;", "errNo", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "<init>", "(ILjava/lang/String;Lcom/google/gson/JsonObject;Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;)V", "(Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "(Lcom/google/gson/JsonObject;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getData", "()Lcom/google/gson/JsonObject;", "getErrNo", "()Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "extras", "getExtras", "setExtras", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class Error extends RuntimeException {
        private final int code;
        private final JsonObject data;
        private final f3.a errNo;
        private JsonObject extras;
        private final String msg;

        public Error() {
            String r0 = null;
            this(r0, r0, 3, r0);
        }

        public Error(int r10) {
            this(r10, null, null, null, 14, null);
        }

        public Error(int r10, String r11) {
            this(r10, r11, null, null, 12, null);
        }

        public Error(int r10, String r11, JsonObject r12) {
            this(r10, r11, r12, null, 8, null);
        }

        public Error(String r10) {
            JsonObject r0 = null;
            this(r10, r0, 2, r0);
        }

        public final int getCode() {
            return this.code;
        }

        public final JsonObject getData() {
            return this.data;
        }

        public final f3.a getErrNo() {
            return this.errNo;
        }

        public final JsonObject getExtras() {
            return this.extras;
        }

        public final String getMsg() {
            return this.msg;
        }

        public Error(JsonObject r10) {
            this(0, "", r10, null, 8, null);
        }

        public final void setExtras(JsonObject r1) {
            this.extras = r1;
        }

        public Error(String r10, JsonObject r11) {
            this(0, r10, r11, null, 8, null);
        }

        public /* synthetic */ Error(JsonObject r1, int r10, DefaultConstructorMarker r11) {
            if ((r10 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }

        public /* synthetic */ Error(String r1, JsonObject r10, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 1) == 0) goto L6;
            r1 = "";
        L6:
            if ((r11 & 2) == 0) goto L8;
            r10 = null;
        L8:
            this(r1, r10);
        }

        public Error(int r1, String r10, JsonObject r11, f3.a r12) {
            super(r10);
            this.code = r1;
            this.msg = r10;
            this.data = r11;
            this.errNo = r12;
        }

        public /* synthetic */ Error(int r10, String r11, JsonObject r12, f3.a r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 2) == 0) goto L6;
            r11 = "";
        L6:
            if ((r14 & 4) == 0) goto L9;
            r12 = null;
        L9:
            if ((r14 & 8) == 0) goto L11;
            r13 = null;
        L11:
            this(r10, r11, r12, r13);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/core/AIBridgeMethod$InvalidParamsError;", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod$Error;", MessageIndication.MESSAGE_TYPE_MSG, "", "<init>", "(Ljava/lang/String;)V", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InvalidParamsError extends Error {
        public InvalidParamsError() {
            String r0 = null;
            this(r0, 1, r0);
        }

        public InvalidParamsError(String r10) {
            super(-3, r10, null, null, 8, null);
        }

        public /* synthetic */ InvalidParamsError(String r1, int r10, DefaultConstructorMarker r11) {
            if ((r10 & 1) == 0) goto L5;
            r1 = "the result passed by the method implementor is invalid";
        L5:
            this(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/core/AIBridgeMethod$InvalidResultError;", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod$Error;", MessageIndication.MESSAGE_TYPE_MSG, "", "<init>", "(Ljava/lang/String;)V", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InvalidResultError extends Error {
        public InvalidResultError() {
            String r0 = null;
            this(r0, 1, r0);
        }

        public InvalidResultError(String r10) {
            super(-5, r10, null, null, 8, null);
        }

        public /* synthetic */ InvalidResultError(String r1, int r10, DefaultConstructorMarker r11) {
            if ((r10 & 1) == 0) goto L5;
            r1 = "the parameter passed by FE is invalid";
        L5:
            this(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/core/AIBridgeMethod$UnregisteredError;", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod$Error;", MessageIndication.MESSAGE_TYPE_MSG, "", "<init>", "(Ljava/lang/String;)V", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UnregisteredError extends Error {
        public UnregisteredError() {
            String r0 = null;
            this(r0, 1, r0);
        }

        public UnregisteredError(String r10) {
            super(-2, r10, null, null, 8, null);
        }

        public /* synthetic */ UnregisteredError(String r1, int r10, DefaultConstructorMarker r11) {
            if ((r10 & 1) == 0) goto L5;
            r1 = "the called method isn't registered";
        L5:
            this(r1);
        }
    }

    List<String> getAltNames();

    String getName();

    boolean getSupportSyncCall();

    boolean mustRunInMain();

    void realHandle(d r1, JsonObject r10, Consumer<JsonObject> r11, Consumer<Error> r12);
}
