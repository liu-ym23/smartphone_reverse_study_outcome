package com.ss.android.lark.export.entity.preview;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003JC\u0010\u001a\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/Parameters;", "Ljava/io/Serializable;", "parameters", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "userId", "sourceId", "previewId", "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getParameters", "()Ljava/util/Map;", "getUserId", "()Ljava/lang/String;", "getSourceId", "getPreviewId", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "component1", "component2", "component3", "component4", "copy", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Parameters implements Serializable {
    private final Map<String, String> parameters;
    private final String previewId;
    private final String sourceId;
    private final String userId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Parameters copy$default(Parameters r0, Map r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.parameters;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.userId;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.sourceId;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.previewId;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Map<String, String> component1() {
        return this.parameters;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.sourceId;
    }

    public final String component4() {
        return this.previewId;
    }

    public final Parameters copy(Map<String, String> r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "parameters");
        return new Parameters(r2, r3, r4, r5);
    }

    public String toString() {
        return "Parameters(parameters=" + this.parameters + ", userId=" + this.userId + ", sourceId=" + this.sourceId + ", previewId=" + this.previewId + ')';
    }

    public int hashCode() {
        int r0 = this.parameters.hashCode() * 31;
        String r1 = this.userId;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.sourceId;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.previewId;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        return r7 + r2;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final Map<String, String> getParameters() {
        return this.parameters;
    }

    public final String getPreviewId() {
        return this.previewId;
    }

    public final String getSourceId() {
        return this.sourceId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(Parameters.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Parameters");
        Parameters r6 = (Parameters) r5;
        if (Intrinsics.areEqual(this.parameters, r6.parameters) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.userId, r6.userId) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.sourceId, r6.sourceId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.previewId, r6.previewId) == true) goto L24;
        return false;
    L24:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public Parameters(Map<String, String> r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "parameters");
        this.parameters = r2;
        this.userId = r3;
        this.sourceId = r4;
        this.previewId = r5;
    }
}
