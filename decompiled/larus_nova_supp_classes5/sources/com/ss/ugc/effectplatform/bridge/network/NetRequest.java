package com.ss.ugc.effectplatform.bridge.network;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\u0010\u000fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/ss/ugc/effectplatform/bridge/network/NetRequest;", "", "url", "", "backupUrl", "", "method", "Lcom/ss/ugc/effectplatform/bridge/network/HTTPMethod;", "headers", "", "bodyParams", "contentType", "useCommParam", "", "extraParms", "(Ljava/lang/String;Ljava/util/List;Lcom/ss/ugc/effectplatform/bridge/network/HTTPMethod;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;ZLjava/util/Map;)V", "getBackupUrl", "()Ljava/util/List;", "getBodyParams", "()Ljava/util/Map;", "getContentType", "()Ljava/lang/String;", "getExtraParms", "getHeaders", "getMethod", "()Lcom/ss/ugc/effectplatform/bridge/network/HTTPMethod;", "getUrl", "getUseCommParam", "()Z", "effect_bridge_release"}, k = 1, mv = {1, 1, 16})
public final class NetRequest {
    private final List<String> backupUrl;
    private final Map<String, Object> bodyParams;
    private final String contentType;
    private final Map<String, Object> extraParms;
    private final Map<String, String> headers;
    private final HTTPMethod method;
    private final String url;
    private final boolean useCommParam;

    public final List<String> getBackupUrl() {
        return this.backupUrl;
    }

    public final Map<String, Object> getBodyParams() {
        return this.bodyParams;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final Map<String, Object> getExtraParms() {
        return this.extraParms;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final HTTPMethod getMethod() {
        return this.method;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean getUseCommParam() {
        return this.useCommParam;
    }

    public NetRequest(String r1, List<String> r2, HTTPMethod r3, Map<String, String> r4, Map<String, ? extends Object> r5, String r6, boolean r7, Map<String, ? extends Object> r8) {
        this.url = r1;
        this.backupUrl = r2;
        this.method = r3;
        this.headers = r4;
        this.bodyParams = r5;
        this.contentType = r6;
        this.useCommParam = r7;
        this.extraParms = r8;
    }

    public /* synthetic */ NetRequest(String r9, List r10, HTTPMethod r11, Map r12, Map r13, String r14, boolean r15, Map r16, int r17, DefaultConstructorMarker r18) {
        Map r2 = null;
        if ((r17 & 2) == 0) goto L5;
        List r1 = null;
    L7:
        if ((r17 & 4) == 0) goto L9;
        HTTPMethod r3 = HTTPMethod.GET;
    L11:
        if ((r17 & 8) == 0) goto L13;
        Map r4 = null;
    L15:
        if ((r17 & 16) == 0) goto L17;
        Map r5 = null;
    L19:
        if ((r17 & 32) == 0) goto L21;
        String r6 = "application/x-www-form-urlencoded";
    L23:
        if ((r17 & 64) == 0) goto L25;
        boolean r7 = true;
    L27:
        if ((r17 & 128) != 0) goto L30;
        r2 = r16;
    L30:
        this(r9, r1, r3, r4, r5, r6, r7, r2);
        return;
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
