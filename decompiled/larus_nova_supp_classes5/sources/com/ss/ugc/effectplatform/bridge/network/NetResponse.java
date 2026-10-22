package com.ss.ugc.effectplatform.bridge.network;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\f\u0018\u0000 /2\u00020\u0001:\u00010BO\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010%¢\u0006\u0004\b,\u0010-B-\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b,\u0010.R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010!R0\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00061"}, d2 = {"Lcom/ss/ugc/effectplatform/bridge/network/NetResponse;", "", "", "logId$delegate", "Lkotlin/Lazy;", "getLogId", "()Ljava/lang/String;", "logId", "", "statusCode", "I", "getStatusCode", "()I", "setStatusCode", "(I)V", "Lcom/ss/ugc/effectplatform/bridge/network/ByteReadStream;", "bodyStream", "Lcom/ss/ugc/effectplatform/bridge/network/ByteReadStream;", "getBodyStream", "()Lcom/ss/ugc/effectplatform/bridge/network/ByteReadStream;", "setBodyStream", "(Lcom/ss/ugc/effectplatform/bridge/network/ByteReadStream;)V", "", "contentLength", "J", "getContentLength", "()J", "setContentLength", "(J)V", "errorMsg", "Ljava/lang/String;", "getErrorMsg", "setErrorMsg", "(Ljava/lang/String;)V", "filePath", "getFilePath", "setFilePath", "", "headers", "Ljava/util/Map;", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "<init>", "(ILcom/ss/ugc/effectplatform/bridge/network/ByteReadStream;JLjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "(ILcom/ss/ugc/effectplatform/bridge/network/ByteReadStream;JLjava/lang/String;)V", "Companion", "a", "effect_bridge_release"}, k = 1, mv = {1, 4, 0})
public final class NetResponse {
    public static final a Companion = null;
    public static final String HEADER_KEY_LOG_ID = "x-tt-logid";
    private ByteReadStream bodyStream;
    private long contentLength;
    private String errorMsg;
    private String filePath;
    private Map<String, String> headers;
    private final Lazy logId$delegate;
    private int statusCode;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String getLogId() {
        return (String) this.logId$delegate.getValue();
    }

    public final ByteReadStream getBodyStream() {
        return this.bodyStream;
    }

    public final long getContentLength() {
        return this.contentLength;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final void setBodyStream(ByteReadStream r1) {
        this.bodyStream = r1;
    }

    public final void setContentLength(long r1) {
        this.contentLength = r1;
    }

    public final void setErrorMsg(String r1) {
        this.errorMsg = r1;
    }

    public final void setFilePath(String r1) {
        this.filePath = r1;
    }

    public final void setHeaders(Map<String, String> r1) {
        this.headers = r1;
    }

    public final void setStatusCode(int r1) {
        this.statusCode = r1;
    }

    public NetResponse(int r11, ByteReadStream r12, long r13, String r15) {
        this(r11, r12, r13, r15, null, null, 32, null);
    }

    public NetResponse(int r1, ByteReadStream r2, long r3, String r5, String r6, Map<String, String> r7) {
        this.statusCode = r1;
        this.bodyStream = r2;
        this.contentLength = r3;
        this.errorMsg = r5;
        this.filePath = r6;
        this.headers = r7;
        this.logId$delegate = LazyKt.lazy(new NetResponse$logId$2(this));
    }

    public /* synthetic */ NetResponse(int r7, ByteReadStream r8, long r9, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 8) == 0) goto L5;
        r11 = null;
    L5:
        this(r7, r8, r9, r11);
    }

    public /* synthetic */ NetResponse(int r11, ByteReadStream r12, long r13, String r15, String r16, Map r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 8) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r18 & 16) == 0) goto L9;
        String r8 = null;
    L11:
        if ((r18 & 32) == 0) goto L13;
        Map r9 = null;
    L14:
        this(r11, r12, r13, r7, r8, r9);
        return;
    L13:
        r9 = r17;
        goto L14
    L9:
        r8 = r16;
        goto L11
    L5:
        r7 = r15;
        goto L7
    }
}
