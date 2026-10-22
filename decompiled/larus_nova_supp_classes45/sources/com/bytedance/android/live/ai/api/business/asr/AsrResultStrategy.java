package com.bytedance.android.live.ai.api.business.asr;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\u0019\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000bHÆ\u0003JM\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R&\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/ai/api/business/asr/AsrResultStrategy;", "", "type", "", "modelPath", "", "modelVersion", "", "needUpdateModel", "", "extraParams", "", "(ILjava/lang/String;JZLjava/util/Map;)V", "getExtraParams", "()Ljava/util/Map;", "getModelPath", "()Ljava/lang/String;", "getModelVersion", "()J", "getNeedUpdateModel", "()Z", "getType", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "liveai-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AsrResultStrategy {

    @SerializedName("extra_params")
    private final Map<String, Object> extraParams;

    @SerializedName("model_path")
    private final String modelPath;

    @SerializedName("model_version")
    private final long modelVersion;

    @SerializedName("need_update_model")
    private final boolean needUpdateModel;

    @SerializedName("type")
    private final int type;

    public AsrResultStrategy() {
        this(0, null, 0, false, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AsrResultStrategy copy$default(AsrResultStrategy r4, int r5, String r6, long r7, boolean r9, Map r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r5 = r4.type;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r6 = r4.modelPath;
    L8:
        String r14 = r6;
        if ((r12 & 4) == 0) goto L11;
        r7 = r4.modelVersion;
    L11:
        long r0 = r7;
        if ((r12 & 8) == 0) goto L14;
        r9 = r4.needUpdateModel;
    L14:
        boolean r2 = r9;
        if ((r12 & 16) == 0) goto L17;
        r11 = r4.extraParams;
    L17:
        int r8 = r5;
        return r4.copy(r8, r14, r0, r2, r11);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.modelPath;
    }

    public final long component3() {
        return this.modelVersion;
    }

    public final boolean component4() {
        return this.needUpdateModel;
    }

    public final Map<String, Object> component5() {
        return this.extraParams;
    }

    public final AsrResultStrategy copy(int r9, String r11, long r12, boolean r13, Map<String, ? extends Object> r14) {
        return new AsrResultStrategy(r9, r11, r12, r13, r14);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof AsrResultStrategy) == false) goto L16;
        AsrResultStrategy r7 = (AsrResultStrategy) r6;
        if (this.type == r7.type) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.modelPath, r7.modelPath) == true) goto L10;
        return false;
    L10:
        if (this.modelVersion == r7.modelVersion) goto L12;
        return false;
    L12:
        if (this.needUpdateModel == r7.needUpdateModel) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.extraParams, r7.extraParams) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public int hashCode() {
        int r0 = this.type * 31;
        String r1 = this.modelPath;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        long r4 = this.modelVersion;
        int r5 = (((r0 + r3) * 31) + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        boolean r6 = this.needUpdateModel;
        ?? r7 = r6;
        if (r6 == false) goto L9;
        r7 = 1;
    L9:
        int r8 = (r5 + r7) * 31;
        Map<String, Object> r9 = this.extraParams;
        if (r9 == null) goto L13;
        r2 = r9.hashCode();
    L13:
        return r8 + r2;
    L5:
        r3 = 0;
        goto L6
    }

    public String toString() {
        return "AsrResultStrategy(type=" + this.type + ", modelPath=" + this.modelPath + ", modelVersion=" + this.modelVersion + ", needUpdateModel=" + this.needUpdateModel + ", extraParams=" + this.extraParams + ")";
    }

    public final Map<String, Object> getExtraParams() {
        return this.extraParams;
    }

    public final String getModelPath() {
        return this.modelPath;
    }

    public final long getModelVersion() {
        return this.modelVersion;
    }

    public final boolean getNeedUpdateModel() {
        return this.needUpdateModel;
    }

    public final int getType() {
        return this.type;
    }

    public AsrResultStrategy(int r1, String r2, long r3, boolean r5, Map<String, ? extends Object> r6) {
        this.type = r1;
        this.modelPath = r2;
        this.modelVersion = r3;
        this.needUpdateModel = r5;
        this.extraParams = r6;
    }

    public /* synthetic */ AsrResultStrategy(int r5, String r6, long r7, boolean r9, Map r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r5 = 0;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r6 = "";
    L8:
        String r14 = r6;
        if ((r12 & 4) == 0) goto L11;
        r7 = -1;
    L11:
        long r0 = r7;
        if ((r12 & 8) == 0) goto L14;
        boolean r2 = true;
    L16:
        if ((r12 & 16) == 0) goto L18;
        r11 = null;
    L18:
        int r8 = r5;
        boolean r15 = r2;
        this(r8, r14, r0, r15, r11);
        return;
    L14:
        r2 = r9;
        goto L16
    }
}
