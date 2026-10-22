package ab8;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.api.creation.UserCreation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/larus/bmhome/avatar/api/DigitalAvatarTemplate;", "", "id", "", "prompt", "", "imageThumb", "Lcom/larus/bmhome/actionbar/model/Icon;", "imageOri", "imagePreview", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "<init>", "(JLjava/lang/String;Lcom/larus/bmhome/actionbar/model/Icon;Lcom/larus/bmhome/actionbar/model/Icon;Lcom/larus/bmhome/actionbar/model/Icon;Lcom/larus/platform/api/creation/UserCreation;)V", "getId", "()J", "getPrompt", "()Ljava/lang/String;", "getImageThumb", "()Lcom/larus/bmhome/actionbar/model/Icon;", "getImageOri", "getImagePreview", "getUserCreation", "()Lcom/larus/platform/api/creation/UserCreation;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class a {
    public final UserCreation a;

    @SerializedName("template_id")
    private final long id;

    @SerializedName("ori")
    private final g1 imageOri;

    @SerializedName("preview")
    private final g1 imagePreview;

    @SerializedName("thumb")
    private final g1 imageThumb;

    @SerializedName("prompt")
    private final String prompt;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.id == r9.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.prompt, r9.prompt) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageThumb, r9.imageThumb) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageOri, r9.imageOri) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.imagePreview, r9.imagePreview) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r0 = this.id;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.prompt;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r5 = (r1 + r4) * 31;
        g1 r6 = this.imageThumb;
        if (r6 != null) goto L9;
        int r7 = 0;
    L10:
        int r8 = (r5 + r7) * 31;
        g1 r9 = this.imageOri;
        if (r9 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = (r8 + r10) * 31;
        g1 r12 = this.imagePreview;
        if (r12 != null) goto L17;
        int r13 = 0;
    L18:
        int r14 = (r11 + r13) * 31;
        UserCreation r15 = this.a;
        if (r15 == null) goto L23;
        r3 = r15.hashCode();
    L23:
        return r14 + r3;
    L17:
        r13 = r12.hashCode();
        goto L18
    L13:
        r10 = r9.hashCode();
        goto L14
    L9:
        r7 = r6.hashCode();
        goto L10
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public final String toString() {
        return "DigitalAvatarTemplate(id=" + this.id + ", prompt=" + this.prompt + ", imageThumb=" + this.imageThumb + ", imageOri=" + this.imageOri + ", imagePreview=" + this.imagePreview + ", userCreation=" + this.a + ')';
    }

    public a() {
        this(0, "", null, null, null, null);
    }

    public final long a() {
        return this.id;
    }

    public final g1 b() {
        return this.imageOri;
    }

    public final g1 c() {
        return this.imagePreview;
    }

    public final g1 d() {
        return this.imageThumb;
    }

    public final String e() {
        return this.prompt;
    }

    public a(long r1, String r3, g1 r4, g1 r5, g1 r6, UserCreation r7) {
        this.id = r1;
        this.prompt = r3;
        this.imageThumb = r4;
        this.imageOri = r5;
        this.imagePreview = r6;
        this.a = r7;
    }
}
