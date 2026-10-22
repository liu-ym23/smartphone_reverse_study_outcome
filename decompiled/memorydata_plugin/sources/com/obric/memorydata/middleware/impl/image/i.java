package com.obric.memorydata.middleware.impl.image;

import com.bytedance.obric.memory.model.ImageXToken;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 12\u00020\u0001:\u00011Bc\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003Je\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011¨\u00062"}, d2 = {"Lcom/obric/memorydata/middleware/impl/image/ImageXToken;", "", "accessKeyId", "", "secretAccessKey", "sessionToken", "expiredTime", "", "currentTime", "serviceId", "uploadHost", "uploadPathPrefix", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessKeyId", "()Ljava/lang/String;", "setAccessKeyId", "(Ljava/lang/String;)V", "getSecretAccessKey", "setSecretAccessKey", "getSessionToken", "setSessionToken", "getExpiredTime", "()J", "setExpiredTime", "(J)V", "getCurrentTime", "setCurrentTime", "getServiceId", "setServiceId", "getUploadHost", "setUploadHost", "getUploadPathPrefix", "setUploadPathPrefix", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11735a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11736b;
    private String c;
    private String d;
    private long e;
    private long f;
    private String g;
    private String h;
    private String i;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/middleware/impl/image/ImageXToken$Companion;", "", "<init>", "()V", "from", "Lcom/obric/memorydata/middleware/impl/image/ImageXToken;", "token", "Lcom/bytedance/rpc/model/ImageXToken;", "Lcom/bytedance/obric/memory/model/ImageXToken;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final i a(ImageXToken r14) {
            Intrinsics.checkNotNullParameter(r14, "token");
            return new i(r14.accessKeyId, r14.secretAccessKey, r14.sessionToken, r14.expiredTime, r14.currentTime, r14.serviceId, null, null, 192, null);
        }

        public final i a(com.bytedance.rpc.model.ImageXToken r14) {
            Intrinsics.checkNotNullParameter(r14, "token");
            return new i(r14.accessKeyId, r14.secretAccessKey, r14.sessionToken, r14.expiredTime, r14.currentTime, r14.serviceId, null, null, 192, null);
        }
    }

    static {
        f11735a = new a(null);
    }

    public i() {
        this(null, null, null, 0, 0, null, null, null, 255, null);
    }

    public i(String r1, String r2, String r3, long r4, long r6, String r8, String r9, String r10) {
        this.f11736b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r6;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }

    public /* synthetic */ i(String r4, String r5, String r6, long r7, long r9, String r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r5 = null;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r6 = null;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r7 = 0;
    L15:
        if ((r14 & 16) == 0) goto L18;
        r9 = 0;
    L18:
        if ((r14 & 32) == 0) goto L21;
        r11 = null;
    L21:
        if ((r14 & 64) == 0) goto L24;
        r12 = null;
    L24:
        if ((r14 & 128) == 0) goto L26;
        r13 = null;
    L26:
        this(r4, r5, r6, r7, r9, r11, r12, r13);
    }

    public final String a() {
        return this.f11736b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final long d() {
        return this.e;
    }

    public final String e() {
        return this.g;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, i.class) == true) goto L8;
        return false;
    L8:
        i r10 = (i) ZeusTransformUtils.preCheckCast(r9, i.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f11736b, r10.f11736b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L18;
        return false;
    L18:
        if (this.e == r10.e) goto L21;
        return false;
    L21:
        if (this.f == r10.f) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.h, r10.h) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final String f() {
        return this.h;
    }

    public final String g() {
        return this.i;
    }

    public int hashCode() {
        String r0 = this.f11736b;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((((r6 + r8) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31;
        String r10 = this.g;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.h;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.i;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ImageXToken(accessKeyId=" + this.f11736b + ", secretAccessKey=" + this.c + ", sessionToken=" + this.d + ", expiredTime=" + this.e + ", currentTime=" + this.f + ", serviceId=" + this.g + ", uploadHost=" + this.h + ", uploadPathPrefix=" + this.i + ')';
    }
}
