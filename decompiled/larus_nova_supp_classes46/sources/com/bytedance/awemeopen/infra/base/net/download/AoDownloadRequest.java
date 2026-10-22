package com.bytedance.awemeopen.infra.base.net.download;

import com.bytedance.awemeopen.infra.base.net.AoFromSource;
import com.bytedance.awemeopen.infra.base.net.AoRequestType;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import q64.c;
import q64.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0087\u0001\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020\u001c\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010/\u001a\u00020*\u0012\b\u00101\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u00103\u001a\u00020\u001c\u0012\u0006\u00105\u001a\u00020\u001c\u0012\u0006\u00108\u001a\u000207¢\u0006\u0004\b<\u0010=J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 R\u0017\u0010#\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 R\u0017\u0010&\u001a\u00020%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010+\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010/\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b/\u0010,\u001a\u0004\b0\u0010.R\u0019\u00101\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b1\u0010\u0005\u001a\u0004\b2\u0010\u0007R\u0017\u00103\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b3\u0010\u001e\u001a\u0004\b4\u0010 R\u0017\u00105\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b5\u0010\u001e\u001a\u0004\b6\u0010 R\u0017\u00108\u001a\u0002078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/net/download/AoDownloadRequest;", "", "", "toString", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "Ljava/io/File;", "targetFile", "Ljava/io/File;", "getTargetFile", "()Ljava/io/File;", "Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;", "from", "Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;", "getFrom", "()Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;", "Lq64/d;", "body", "Lq64/d;", "getBody", "()Lq64/d;", "Lq64/c;", "headers", "Lq64/c;", "getHeaders", "()Lq64/c;", "", "addHostSecurityParams", "Z", "getAddHostSecurityParams", "()Z", "addHostCommonParams", "getAddHostCommonParams", "addBdpCommonParams", "getAddBdpCommonParams", "Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "requestLibType", "Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "getRequestLibType", "()Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "", "timeout", "J", "getTimeout", "()J", "maxLength", "getMaxLength", "md5", "getMd5", "verifyHttpCode", "getVerifyHttpCode", "enableHttp2", "getEnableHttp2", "", "priority", "I", "getPriority", "()I", "<init>", "(Ljava/lang/String;Ljava/io/File;Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;Lq64/d;Lq64/c;ZZZLcom/bytedance/awemeopen/infra/base/net/AoRequestType;JJLjava/lang/String;ZZI)V", "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
public final class AoDownloadRequest {
    private final boolean addBdpCommonParams;
    private final boolean addHostCommonParams;
    private final boolean addHostSecurityParams;
    private final d body;
    private final boolean enableHttp2;
    private final AoFromSource from;
    private final c headers;
    private final long maxLength;
    private final String md5;
    private final int priority;
    private final AoRequestType requestLibType;
    private final File targetFile;
    private final long timeout;
    private final String url;
    private final boolean verifyHttpCode;

    public /* synthetic */ AoDownloadRequest(String r1, File r2, AoFromSource r3, d r4, c r5, boolean r6, boolean r7, boolean r8, AoRequestType r9, long r10, long r12, String r14, boolean r15, boolean r16, int r17, DefaultConstructorMarker r18) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r14, r15, r16, r17);
    }

    public String toString() {
        return "BdpDownloadRequest(url='" + this.url + "', targetFile=" + this.targetFile + ", from=" + this.from + ", body=" + this.body + ", headers=" + this.headers + ", addHostSecurityParams=" + this.addHostSecurityParams + ", addHostCommonParams=" + this.addHostCommonParams + ", addBdpCommonParams=" + this.addBdpCommonParams + ", requestLibType=" + this.requestLibType + ", timeout=" + this.timeout + ", maxLength=" + this.maxLength + ", md5=" + this.md5 + ", verifyHttpCode=" + this.verifyHttpCode + ", priority=" + this.priority + ')';
    }

    public final boolean getAddBdpCommonParams() {
        return this.addBdpCommonParams;
    }

    public final boolean getAddHostCommonParams() {
        return this.addHostCommonParams;
    }

    public final boolean getAddHostSecurityParams() {
        return this.addHostSecurityParams;
    }

    public final d getBody() {
        return this.body;
    }

    public final boolean getEnableHttp2() {
        return this.enableHttp2;
    }

    public final AoFromSource getFrom() {
        return this.from;
    }

    public final c getHeaders() {
        return this.headers;
    }

    public final long getMaxLength() {
        return this.maxLength;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final AoRequestType getRequestLibType() {
        return this.requestLibType;
    }

    public final File getTargetFile() {
        return this.targetFile;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean getVerifyHttpCode() {
        return this.verifyHttpCode;
    }

    private AoDownloadRequest(String r4, File r5, AoFromSource r6, d r7, c r8, boolean r9, boolean r10, boolean r11, AoRequestType r12, long r13, long r15, String r17, boolean r18, boolean r19, int r20) {
        this.url = r4;
        this.targetFile = r5;
        this.from = r6;
        this.body = r7;
        this.headers = r8;
        this.addHostSecurityParams = r9;
        this.addHostCommonParams = r10;
        this.addBdpCommonParams = r11;
        this.requestLibType = r12;
        this.timeout = r13;
        this.maxLength = r15;
        this.md5 = r17;
        this.verifyHttpCode = r18;
        this.enableHttp2 = r19;
        this.priority = r20;
    }
}
