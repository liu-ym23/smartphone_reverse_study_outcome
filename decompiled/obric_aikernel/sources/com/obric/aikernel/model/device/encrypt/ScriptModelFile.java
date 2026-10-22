package com.obric.aikernel.model.device.encrypt;

import androidx.annotation.Keep;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class ScriptModelFile {
    private final String download_url;
    private final String encrypt_key_info;
    private String encrypt_type;
    private final String filename;
    private final String md5;
    private final String origin_md5;
    private final long origin_size_bytes;
    private final long size_bytes;

    public ScriptModelFile(String r10, String r11, String r12, String r13, String r14, String r15, long r16, long r17) {
        Intrinsics.checkNotNullParameter(r10, "download_url");
        Intrinsics.checkNotNullParameter(r11, "md5");
        Intrinsics.checkNotNullParameter(r12, "filename");
        this.download_url = r10;
        this.md5 = r11;
        this.filename = r12;
        this.origin_md5 = r13;
        this.encrypt_type = r14;
        this.encrypt_key_info = r15;
        this.size_bytes = r16;
        this.origin_size_bytes = r17;
    }

    public /* synthetic */ ScriptModelFile(String r14, String r15, String r16, String r17, String r18, String r19, long r20, long r22, int r24, DefaultConstructorMarker r25) {
        if ((r24 & 32) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r24 & 64) == 0) goto L9;
        long r11 = 0;
    L11:
        if ((r24 & 128) == 0) goto L13;
        long r12 = 0;
    L14:
        this(r14, r15, r16, r17, r18, r10, r11, r12);
        return;
    L13:
        r12 = r22;
        goto L14
    L9:
        r11 = r20;
        goto L11
    L5:
        r10 = r19;
        goto L7
    }

    public static /* synthetic */ ScriptModelFile copy$default(ScriptModelFile r12, String r13, String r14, String r15, String r16, String r17, String r18, long r19, long r21, int r23, Object r24) {
        if ((r23 & 1) == 0) goto L5;
        String r10 = r12.download_url;
    L7:
        if ((r23 & 2) == 0) goto L9;
        String r11 = r12.md5;
    L11:
        if ((r23 & 4) == 0) goto L13;
        String r20 = r12.filename;
    L15:
        if ((r23 & 8) == 0) goto L17;
        String r22 = r12.origin_md5;
    L19:
        if ((r23 & 16) == 0) goto L21;
        String r25 = r12.encrypt_type;
    L23:
        if ((r23 & 32) == 0) goto L25;
        String r26 = r12.encrypt_key_info;
    L27:
        if ((r23 & 64) == 0) goto L29;
        long r27 = r12.size_bytes;
    L31:
        if ((r23 & 128) == 0) goto L33;
        long r110 = r12.origin_size_bytes;
    L35:
        return r12.copy(r10, r11, r20, r22, r25, r26, r27, r110);
    L33:
        r110 = r21;
        goto L35
    L29:
        r27 = r19;
        goto L31
    L25:
        r26 = r18;
        goto L27
    L21:
        r25 = r17;
        goto L23
    L17:
        r22 = r16;
        goto L19
    L13:
        r20 = r15;
        goto L15
    L9:
        r11 = r14;
        goto L11
    L5:
        r10 = r13;
        goto L7
    }

    public final String component1() {
        return this.download_url;
    }

    public final String component2() {
        return this.md5;
    }

    public final String component3() {
        return this.filename;
    }

    public final String component4() {
        return this.origin_md5;
    }

    public final String component5() {
        return this.encrypt_type;
    }

    public final String component6() {
        return this.encrypt_key_info;
    }

    public final long component7() {
        return this.size_bytes;
    }

    public final long component8() {
        return this.origin_size_bytes;
    }

    public final ScriptModelFile copy(String r13, String r14, String r15, String r16, String r17, String r18, long r19, long r21) {
        Intrinsics.checkNotNullParameter(r13, "download_url");
        Intrinsics.checkNotNullParameter(r14, "md5");
        Intrinsics.checkNotNullParameter(r15, "filename");
        return new ScriptModelFile(r13, r14, r15, r16, r17, r18, r19, r21);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ScriptModelFile) == true) goto L8;
        return false;
    L8:
        ScriptModelFile r11 = (ScriptModelFile) r10;
        if (Intrinsics.areEqual(this.download_url, r11.download_url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.md5, r11.md5) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.filename, r11.filename) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.origin_md5, r11.origin_md5) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.encrypt_type, r11.encrypt_type) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.encrypt_key_info, r11.encrypt_key_info) == true) goto L27;
        return false;
    L27:
        if (this.size_bytes == r11.size_bytes) goto L30;
        return false;
    L30:
        if (this.origin_size_bytes == r11.origin_size_bytes) goto L32;
        return false;
    L32:
        return true;
    }

    public final String getDownload_url() {
        return this.download_url;
    }

    public final String getEncrypt_key_info() {
        return this.encrypt_key_info;
    }

    public final String getEncrypt_type() {
        return this.encrypt_type;
    }

    public final String getFilename() {
        return this.filename;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getOrigin_md5() {
        return this.origin_md5;
    }

    public final long getOrigin_size_bytes() {
        return this.origin_size_bytes;
    }

    public final long getSize_bytes() {
        return this.size_bytes;
    }

    public int hashCode() {
        int r10 = ((((this.download_url.hashCode() * 31) + this.md5.hashCode()) * 31) + this.filename.hashCode()) * 31;
        String r11 = this.origin_md5;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        String r15 = this.encrypt_type;
        if (r15 != null) goto L9;
        int r16 = 0;
    L10:
        int r17 = (r14 + r16) * 31;
        String r18 = this.encrypt_key_info;
        if (r18 == null) goto L15;
        r12 = r18.hashCode();
    L15:
        return ((((r17 + r12) * 31) + Long.hashCode(this.size_bytes)) * 31) + Long.hashCode(this.origin_size_bytes);
    L9:
        r16 = r15.hashCode();
        goto L10
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public final void setEncrypt_type(String r10) {
        this.encrypt_type = r10;
    }

    public String toString() {
        return "ScriptModelFile(download_url=" + this.download_url + ", md5=" + this.md5 + ", filename=" + this.filename + ", origin_md5=" + this.origin_md5 + ", encrypt_type=" + this.encrypt_type + ", encrypt_key_info=" + this.encrypt_key_info + ", size_bytes=" + this.size_bytes + ", origin_size_bytes=" + this.origin_size_bytes + ')';
    }
}
