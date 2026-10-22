package com.larus.platform.model.chat;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJF\u0010\u0019\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000f¨\u0006 "}, d2 = {"Lcom/larus/platform/model/chat/UploadAudioEntityConf;", "", "allowTypes", "", "", "maxSize", "", "maxCount", "", "maxDuration", "<init>", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;)V", "getAllowTypes", "()Ljava/util/List;", "getMaxSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMaxCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxDuration", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/larus/platform/model/chat/UploadAudioEntityConf;", "equals", "", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class r0 {

    @SerializedName("allow_types")
    private final List<String> allowTypes;

    @SerializedName("max_cnt")
    private final Integer maxCount;

    @SerializedName("max_duration")
    private final Long maxDuration;

    @SerializedName("max_size")
    private final Long maxSize;

    public r0() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r0) == true) goto L8;
        return false;
    L8:
        r0 r6 = (r0) r5;
        if (Intrinsics.areEqual(this.allowTypes, r6.allowTypes) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxSize, r6.maxSize) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maxCount, r6.maxCount) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxDuration, r6.maxDuration) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        List<String> r0 = this.allowTypes;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.maxSize;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.maxCount;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.maxDuration;
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

    public final String toString() {
        return "UploadAudioEntityConf(allowTypes=" + this.allowTypes + ", maxSize=" + this.maxSize + ", maxCount=" + this.maxCount + ", maxDuration=" + this.maxDuration + ')';
    }

    public final List<String> b() {
        return this.allowTypes;
    }

    public final Integer c() {
        return this.maxCount;
    }

    public final Long d() {
        return this.maxDuration;
    }

    public final Long e() {
        return this.maxSize;
    }

    public /* synthetic */ r0(int r10) {
        this(CollectionsKt.listOf(new String[]{"mp3", "wav", "m4a", "wma", "aac", "ogg", "amr", "flac", "aiff"}), 314572800L, 10, 14400000L);
    }

    public static r0 a(r0 r3, List r4) {
        return new r0(r4, r3.maxSize, r3.maxCount, r3.maxDuration);
    }

    public r0(List<String> r1, Long r2, Integer r3, Long r4) {
        this.allowTypes = r1;
        this.maxSize = r2;
        this.maxCount = r3;
        this.maxDuration = r4;
    }
}
