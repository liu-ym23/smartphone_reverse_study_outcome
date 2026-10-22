package fq8;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JA\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\nHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/larus/bmhome/instruction/repo/ImgInspirePrompt;", "", "id", "", "inspirationPrompt", "", "aspectRatioInfo", "Lcom/larus/bmhome/instruction/repo/AspectRatioInfo;", "actualPrompt", "scene", "", "<init>", "(JLjava/lang/String;Lcom/larus/bmhome/instruction/repo/AspectRatioInfo;Ljava/lang/String;I)V", "getId", "()J", "getInspirationPrompt", "()Ljava/lang/String;", "getAspectRatioInfo", "()Lcom/larus/bmhome/instruction/repo/AspectRatioInfo;", "getActualPrompt", "getScene", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    @SerializedName("actual_prompt")
    private final String actualPrompt;

    @SerializedName("aspect_ratio_info")
    private final a aspectRatioInfo;

    @SerializedName("id")
    private final long id;

    @SerializedName("inspiration_prompt")
    private final String inspirationPrompt;

    @SerializedName("scene")
    private final int scene;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r9 = (e) r8;
        if (this.id == r9.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.inspirationPrompt, r9.inspirationPrompt) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.aspectRatioInfo, r9.aspectRatioInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actualPrompt, r9.actualPrompt) == true) goto L21;
        return false;
    L21:
        if (this.scene == r9.scene) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r0 = this.id;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.inspirationPrompt;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r5 = (r1 + r4) * 31;
        a r6 = this.aspectRatioInfo;
        if (r6 != null) goto L9;
        int r7 = 0;
    L10:
        int r8 = (r5 + r7) * 31;
        String r9 = this.actualPrompt;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        return ((r8 + r3) * 31) + this.scene;
    L9:
        r7 = r6.hashCode();
        goto L10
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImgInspirePrompt(id=" + this.id + ", inspirationPrompt=" + this.inspirationPrompt + ", aspectRatioInfo=" + this.aspectRatioInfo + ", actualPrompt=" + this.actualPrompt + ", scene=" + this.scene + ')';
    }

    public e() {
        this.id = 0;
        this.inspirationPrompt = "";
        this.aspectRatioInfo = null;
        this.actualPrompt = "";
        this.scene = 0;
    }

    public final String a() {
        return this.actualPrompt;
    }

    public final a b() {
        return this.aspectRatioInfo;
    }

    public final long c() {
        return this.id;
    }

    public final String d() {
        return this.inspirationPrompt;
    }

    public final int e() {
        return this.scene;
    }
}
