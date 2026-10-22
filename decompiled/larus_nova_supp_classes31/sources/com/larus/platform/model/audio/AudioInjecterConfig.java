package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/larus/platform/model/audio/AudioInjecterConfig;", "", "tosAccessKey", "", "tosSecretKey", "tosBucketName", "tosEndpoint", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTosAccessKey", "()Ljava/lang/String;", "getTosSecretKey", "getTosBucketName", "getTosEndpoint", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AudioInjecterConfig {

    @SerializedName("tos_access_key")
    private final String tosAccessKey;

    @SerializedName("tos_bucket_name")
    private final String tosBucketName;

    @SerializedName("tos_endpoint")
    private final String tosEndpoint;

    @SerializedName("tos_secret_key")
    private final String tosSecretKey;

    public AudioInjecterConfig() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ AudioInjecterConfig copy$default(AudioInjecterConfig r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.tosAccessKey;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.tosSecretKey;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.tosBucketName;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.tosEndpoint;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.tosAccessKey;
    }

    public final String component2() {
        return this.tosSecretKey;
    }

    public final String component3() {
        return this.tosBucketName;
    }

    public final String component4() {
        return this.tosEndpoint;
    }

    public final AudioInjecterConfig copy(String r2, String r3, String r4, String r5) {
        return new AudioInjecterConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AudioInjecterConfig) == true) goto L8;
        return false;
    L8:
        AudioInjecterConfig r6 = (AudioInjecterConfig) r5;
        if (Intrinsics.areEqual(this.tosAccessKey, r6.tosAccessKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tosSecretKey, r6.tosSecretKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tosBucketName, r6.tosBucketName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tosEndpoint, r6.tosEndpoint) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.tosAccessKey;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.tosSecretKey;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.tosBucketName;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.tosEndpoint;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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
        return "AudioInjecterConfig(tosAccessKey=" + this.tosAccessKey + ", tosSecretKey=" + this.tosSecretKey + ", tosBucketName=" + this.tosBucketName + ", tosEndpoint=" + this.tosEndpoint + ')';
    }

    public final String getTosAccessKey() {
        return this.tosAccessKey;
    }

    public final String getTosBucketName() {
        return this.tosBucketName;
    }

    public final String getTosEndpoint() {
        return this.tosEndpoint;
    }

    public final String getTosSecretKey() {
        return this.tosSecretKey;
    }

    public AudioInjecterConfig(String r1, String r2, String r3, String r4) {
        this.tosAccessKey = r1;
        this.tosSecretKey = r2;
        this.tosBucketName = r3;
        this.tosEndpoint = r4;
    }

    public /* synthetic */ AudioInjecterConfig(String r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = "";
    L14:
        this(r2, r3, r4, r5);
    }
}
