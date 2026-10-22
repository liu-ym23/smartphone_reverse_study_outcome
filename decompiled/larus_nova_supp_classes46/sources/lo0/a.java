package lo0;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Llo0/a;", "", "", "text", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "nickName", "getNickName", "desc", "c", "avatar", "a", "identity", "f", "schema", "g", "enterText", "d", "", "bdpLogExtra", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "extra", "e", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("avatar")
    private final String avatar;

    @SerializedName("bdp_log_extra")
    private final Map<String, String> bdpLogExtra;

    @SerializedName("desc")
    private final String desc;

    @SerializedName("enter_text")
    private final String enterText;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("identity")
    private final String identity;

    @SerializedName("nick_name")
    private final String nickName;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("text")
    private final String text;

    public a() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L24;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.text, r4.text) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.nickName, r4.nickName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.desc, r4.desc) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.avatar, r4.avatar) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.identity, r4.identity) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.schema, r4.schema) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.enterText, r4.enterText) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.bdpLogExtra, r4.bdpLogExtra) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        String r0 = this.text;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.nickName;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.desc;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.avatar;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.identity;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.schema;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.enterText;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Map<String, String> r22 = this.bdpLogExtra;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        Map<String, String> r25 = this.extra;
        if (r25 == null) goto L38;
        r1 = r25.hashCode();
    L38:
        return r24 + r1;
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PrivateMsgEntranceInfo(text=" + this.text + ", nickName=" + this.nickName + ", desc=" + this.desc + ", avatar=" + this.avatar + ", identity=" + this.identity + ", schema=" + this.schema + ", enterText=" + this.enterText + ", bdpLogExtra=" + this.bdpLogExtra + ", extra=" + this.extra + ")";
    }

    public final String a() {
        return this.avatar;
    }

    public final Map<String, String> b() {
        return this.bdpLogExtra;
    }

    public final String c() {
        return this.desc;
    }

    public final String d() {
        return this.enterText;
    }

    public final Map<String, String> e() {
        return this.extra;
    }

    public final String f() {
        return this.identity;
    }

    public final String g() {
        return this.schema;
    }

    public final String h() {
        return this.text;
    }

    public a(String r1, String r2, String r3, String r4, String r5, String r6, String r7, Map<String, String> r8, Map<String, String> r9) {
        this.text = r1;
        this.nickName = r2;
        this.desc = r3;
        this.avatar = r4;
        this.identity = r5;
        this.schema = r6;
        this.enterText = r7;
        this.bdpLogExtra = r8;
        this.extra = r9;
    }
}
