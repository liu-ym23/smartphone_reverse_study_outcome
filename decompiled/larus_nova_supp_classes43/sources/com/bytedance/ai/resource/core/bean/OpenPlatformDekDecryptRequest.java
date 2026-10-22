package com.bytedance.ai.resource.core.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformDekDecryptRequest;", "", "wrappedDek", "", "crypto", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformDekDecryptCryptoRequest;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ai/resource/core/bean/OpenPlatformDekDecryptCryptoRequest;)V", "getWrappedDek", "()Ljava/lang/String;", "getCrypto", "()Lcom/bytedance/ai/resource/core/bean/OpenPlatformDekDecryptCryptoRequest;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformDekDecryptRequest {
    private final OpenPlatformDekDecryptCryptoRequest crypto;

    @SerializedName("wrapped_dek")
    private final String wrappedDek;

    /* JADX WARN: Multi-variable type inference failed */
    public OpenPlatformDekDecryptRequest() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ OpenPlatformDekDecryptRequest copy$default(OpenPlatformDekDecryptRequest r0, String r1, OpenPlatformDekDecryptCryptoRequest r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.wrappedDek;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.crypto;
    L9:
        return r0.copy(r1, r10);
    }

    public final String component1() {
        return this.wrappedDek;
    }

    public final OpenPlatformDekDecryptCryptoRequest component2() {
        return this.crypto;
    }

    public final OpenPlatformDekDecryptRequest copy(String r10, OpenPlatformDekDecryptCryptoRequest r11) {
        return new OpenPlatformDekDecryptRequest(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof OpenPlatformDekDecryptRequest) == true) goto L8;
        return false;
    L8:
        OpenPlatformDekDecryptRequest r11 = (OpenPlatformDekDecryptRequest) r10;
        if (Intrinsics.areEqual(this.wrappedDek, r11.wrappedDek) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.crypto, r11.crypto) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.wrappedDek;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        OpenPlatformDekDecryptCryptoRequest r12 = this.crypto;
        if (r12 == null) goto L11;
        r1 = r12.hashCode();
    L11:
        return r11 + r1;
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "OpenPlatformDekDecryptRequest(wrappedDek=" + this.wrappedDek + ", crypto=" + this.crypto + ')';
    }

    public final OpenPlatformDekDecryptCryptoRequest getCrypto() {
        return this.crypto;
    }

    public final String getWrappedDek() {
        return this.wrappedDek;
    }

    public OpenPlatformDekDecryptRequest(String r1, OpenPlatformDekDecryptCryptoRequest r10) {
        this.wrappedDek = r1;
        this.crypto = r10;
    }

    public /* synthetic */ OpenPlatformDekDecryptRequest(String r10, OpenPlatformDekDecryptCryptoRequest r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
