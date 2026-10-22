package u2;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003Jm\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0001J\u0013\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/bytedance/ai/applet/granting/GrantingData;", "", "doubaoAppletKey", "", "doubaoAppletName", "doubaoAppletIcon", "doubaoAppletVersion", "doubaoAppletType", "refuseInteractReplay", "", "cardStatus", "grantingList", "", "Lcom/bytedance/ai/applet/granting/GrantingItem;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;)V", "getDoubaoAppletKey", "()Ljava/lang/String;", "getDoubaoAppletName", "getDoubaoAppletIcon", "getDoubaoAppletVersion", "getDoubaoAppletType", "getRefuseInteractReplay", "()Z", "getCardStatus", "getGrantingList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    @SerializedName("cardStatus")
    private final String cardStatus;

    @SerializedName("doubaoAppletIcon")
    private final String doubaoAppletIcon;

    @SerializedName("doubaoAppletKey")
    private final String doubaoAppletKey;

    @SerializedName("doubaoAppletName")
    private final String doubaoAppletName;

    @SerializedName("doubaoAppletType")
    private final String doubaoAppletType;

    @SerializedName("doubaoAppletVersion")
    private final String doubaoAppletVersion;

    @SerializedName("grantingList")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<f> grantingList;

    @SerializedName("refuseInteractReplay")
    private final boolean refuseInteractReplay;

    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        Object[] r0 = 0 == true ? 1 : 0;
        Object[] r1 = 0 == true ? 1 : 0;
        this(null, r0, r1, 255);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof e) == true) goto L8;
        return false;
    L8:
        e r11 = (e) r10;
        if (Intrinsics.areEqual(this.doubaoAppletKey, r11.doubaoAppletKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.doubaoAppletName, r11.doubaoAppletName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.doubaoAppletIcon, r11.doubaoAppletIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.doubaoAppletVersion, r11.doubaoAppletVersion) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.doubaoAppletType, r11.doubaoAppletType) == true) goto L24;
        return false;
    L24:
        if (this.refuseInteractReplay == r11.refuseInteractReplay) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.cardStatus, r11.cardStatus) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.grantingList, r11.grantingList) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r0 = this.doubaoAppletKey;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.doubaoAppletName;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.doubaoAppletIcon;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.doubaoAppletVersion;
        if (r18 != null) goto L17;
        int r19 = 0;
    L18:
        int r20 = (r17 + r19) * 31;
        String r21 = this.doubaoAppletType;
        if (r21 != null) goto L21;
        int r22 = 0;
    L22:
        int r23 = (r20 + r22) * 31;
        if (this.refuseInteractReplay == false) goto L25;
        int r24 = 1231;
    L26:
        int r25 = (r23 + r24) * 31;
        String r26 = this.cardStatus;
        if (r26 != null) goto L29;
        int r27 = 0;
    L30:
        int r28 = (r25 + r27) * 31;
        List<f> r29 = this.grantingList;
        if (r29 == null) goto L35;
        r1 = r29.hashCode();
    L35:
        return r28 + r1;
    L29:
        r27 = r26.hashCode();
        goto L30
    L25:
        r24 = 1237;
        goto L26
    L21:
        r22 = r21.hashCode();
        goto L22
    L17:
        r19 = r18.hashCode();
        goto L18
    L13:
        r16 = r15.hashCode();
        goto L14
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "GrantingData(doubaoAppletKey=" + this.doubaoAppletKey + ", doubaoAppletName=" + this.doubaoAppletName + ", doubaoAppletIcon=" + this.doubaoAppletIcon + ", doubaoAppletVersion=" + this.doubaoAppletVersion + ", doubaoAppletType=" + this.doubaoAppletType + ", refuseInteractReplay=" + this.refuseInteractReplay + ", cardStatus=" + this.cardStatus + ", grantingList=" + this.grantingList + ')';
    }

    public final String b() {
        return this.cardStatus;
    }

    public final String c() {
        return this.doubaoAppletIcon;
    }

    public final String d() {
        return this.doubaoAppletKey;
    }

    public final String e() {
        return this.doubaoAppletName;
    }

    public final String f() {
        return this.doubaoAppletType;
    }

    public final String g() {
        return this.doubaoAppletVersion;
    }

    public final List<f> h() {
        return this.grantingList;
    }

    public final boolean i() {
        return this.refuseInteractReplay;
    }

    public /* synthetic */ e(String r12, String r13, List r14, int r15) {
        String r1 = null;
        if ((r15 & 1) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r15 & 8) == 0) goto L9;
        String r11 = null;
    L11:
        if ((r15 & 64) == 0) goto L13;
        r1 = "unexpired";
    L13:
        String r16 = r1;
        if ((r15 & 128) == 0) goto L16;
        r14 = CollectionsKt.emptyList();
    L16:
        this(r10, null, null, r11, null, false, r16, r14);
        return;
    L9:
        r11 = r13;
        goto L11
    L5:
        r10 = r12;
        goto L7
    }

    public static e a(e r11, String r12, List r13, int r14) {
        String r1 = null;
        if ((r14 & 1) == 0) goto L5;
        String r10 = r11.doubaoAppletKey;
    L7:
        if ((r14 & 2) == 0) goto L9;
        String r15 = r11.doubaoAppletName;
    L11:
        if ((r14 & 4) == 0) goto L13;
        String r16 = r11.doubaoAppletIcon;
    L15:
        if ((r14 & 8) == 0) goto L17;
        String r17 = r11.doubaoAppletVersion;
    L19:
        if ((r14 & 16) == 0) goto L21;
        r1 = r11.doubaoAppletType;
    L21:
        String r18 = r1;
        if ((r14 & 32) == 0) goto L24;
        boolean r19 = r11.refuseInteractReplay;
    L26:
        if ((r14 & 64) == 0) goto L28;
        r12 = r11.cardStatus;
    L28:
        String r20 = r12;
        if ((r14 & 128) == 0) goto L31;
        r13 = r11.grantingList;
    L31:
        r11.getClass();
        return new e(r10, r15, r16, r17, r18, r19, r20, r13);
    L24:
        r19 = false;
        goto L26
    L17:
        r17 = null;
        goto L19
    L13:
        r16 = null;
        goto L15
    L9:
        r15 = null;
        goto L11
    L5:
        r10 = null;
        goto L7
    }

    public e(String r1, String r10, String r11, String r12, String r13, boolean r14, String r15, List<f> r16) {
        this.doubaoAppletKey = r1;
        this.doubaoAppletName = r10;
        this.doubaoAppletIcon = r11;
        this.doubaoAppletVersion = r12;
        this.doubaoAppletType = r13;
        this.refuseInteractReplay = r14;
        this.cardStatus = r15;
        this.grantingList = r16;
    }
}
