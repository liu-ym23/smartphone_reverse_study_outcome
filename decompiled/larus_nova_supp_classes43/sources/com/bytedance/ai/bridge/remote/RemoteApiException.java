package com.bytedance.ai.bridge.remote;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0004\t\n\u000b\fB\u001d\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\b\u0082\u0001\u0004\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/remote/RemoteApiException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", com.bytedance.android.ec.core.event.a.KEY_MSG, "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "Business", "Http", "Network", "InvalidResponse", "Lcom/bytedance/ai/bridge/remote/RemoteApiException$Business;", "Lcom/bytedance/ai/bridge/remote/RemoteApiException$Http;", "Lcom/bytedance/ai/bridge/remote/RemoteApiException$InvalidResponse;", "Lcom/bytedance/ai/bridge/remote/RemoteApiException$Network;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class RemoteApiException extends Exception {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/bridge/remote/RemoteApiException$Business;", "Lcom/bytedance/ai/bridge/remote/RemoteApiException;", "code", "", com.bytedance.android.ec.core.event.a.KEY_MSG, "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Business extends RemoteApiException {
        private final Integer code;

        public final Integer getCode() {
            return this.code;
        }

        public Business(Integer r10, String r11) {
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_MSG);
            Throwable r0 = null;
            super(r11, r0, 2, r0);
            this.code = r10;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/bridge/remote/RemoteApiException$Http;", "Lcom/bytedance/ai/bridge/remote/RemoteApiException;", com.bytedance.android.ec.core.event.a.KEY_STATUS_CODE, "", "<init>", "(I)V", "getStatusCode", "()I", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Http extends RemoteApiException {
        private final int statusCode;

        public final int getStatusCode() {
            return this.statusCode;
        }

        public Http(int r10) {
            Throwable r1 = null;
            super("HTTP request failed with status " + r10, r1, 2, r1);
            this.statusCode = r10;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/remote/RemoteApiException$InvalidResponse;", "Lcom/bytedance/ai/bridge/remote/RemoteApiException;", com.bytedance.android.ec.core.event.a.KEY_MSG, "", "<init>", "(Ljava/lang/String;)V", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InvalidResponse extends RemoteApiException {
        public InvalidResponse(String r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
            Throwable r0 = null;
            super(r10, r0, 2, r0);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/remote/RemoteApiException$Network;", "Lcom/bytedance/ai/bridge/remote/RemoteApiException;", "cause", "", "<init>", "(Ljava/lang/Throwable;)V", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Network extends RemoteApiException {
        public Network(Throwable r10) {
            Intrinsics.checkNotNullParameter(r10, "cause");
            String r0 = r10.getMessage();
            if (r0 != null) goto L5;
            r0 = "network request failed";
        L5:
            super(r0, r10, null);
        }
    }

    public RemoteApiException(String r1, Throwable r10, DefaultConstructorMarker r11) {
        super(r1, r10);
    }

    public /* synthetic */ RemoteApiException(String r1, Throwable r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, null);
    }
}
