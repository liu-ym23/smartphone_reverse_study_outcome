package com.larus.platform.model.upload;

import com.larus.trace.CopyContentTypeString;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/larus/platform/model/upload/ResourceUploadError;", "", CopyContentTypeString.CODE, "", "msg", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getMsg", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ResourceUploadError extends Throwable {
    public static final String AUTH_TOKEN = "upload_get_auth_token_error";
    public static final String CANCELED = "canceled";
    public static final a Companion = null;
    public static final String NO_NETWORK = "no_network";
    public static final String REGISTER_ERROR = "upload_resource_register_error";
    public static final String UPLOAD_ERROR = "upload_imagex_error";
    public static final String VIDEO_TRANSCODE_ERROR = "process_transcode_error";
    private final String code;
    private final String msg;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ ResourceUploadError copy$default(ResourceUploadError r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.msg;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final ResourceUploadError copy(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, CopyContentTypeString.CODE);
        Intrinsics.checkNotNullParameter(r3, "msg");
        return new ResourceUploadError(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResourceUploadError) == true) goto L8;
        return false;
    L8:
        ResourceUploadError r6 = (ResourceUploadError) r5;
        if (Intrinsics.areEqual(this.code, r6.code) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r6.msg) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.code.hashCode() * 31) + this.msg.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "ResourceUploadError(code=" + this.code + ", msg=" + this.msg + ')';
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public ResourceUploadError(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, CopyContentTypeString.CODE);
        Intrinsics.checkNotNullParameter(r3, "msg");
        super(r3);
        this.code = r2;
        this.msg = r3;
    }
}
