package mtb;

import com.bytedance.lark.pb.contact.v2.ContactProfile;
import com.bytedance.lark.pb.contact.v2.UserRelation;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d extends b {
    public static final /* synthetic */ int l = 0;
    public final long a;
    public final long b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final boolean i;
    public final boolean j;
    public final n k;

    public static final class a {
        public static d a(ContactProfile r22) {
            Intrinsics.checkNotNullParameter(r22, "contactProfile");
            long r3 = r22.feishu_user_id.longValue();
            long r5 = r22.db_user_id.longValue();
            String r7 = r22.name;
            String r8 = r22.alias;
            String r9 = r22.display_name;
            String r10 = r22.display_name_pinyin;
            String r11 = r22.avatar_key;
            String r12 = r22.doubao_key;
            boolean r13 = r22.is_b_user.booleanValue();
            boolean r14 = r22.is_contact_deleted.booleanValue();
            UserRelation r0 = r22.relation;
            if (r0 == null) goto L5;
            int r1 = n.f;
            Intrinsics.checkNotNullParameter(r0, "relation");
            n r15 = new n(r0.is_friend.booleanValue(), r0.request_user_apply.booleanValue(), r0.request_user_apply_id.longValue(), r0.request_user_apply_reason, r0.target_user_apply.booleanValue());
        L7:
            return new d(r3, r5, r7, r8, r9, r10, r11, r12, r13, r14, r15);
        L5:
            r15 = null;
            goto L7
        }
    }

    static {
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof d) == true) goto L8;
        return false;
    L8:
        d r9 = (d) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (((((((((((((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        int r4 = 1231;
        if (this.i == false) goto L5;
        int r5 = 1231;
    L6:
        int r6 = (r2 + r5) * 31;
        if (this.j == true) goto L10;
        r4 = 1237;
    L10:
        int r7 = (r6 + r4) * 31;
        n r8 = this.k;
        if (r8 != null) goto L13;
        int r9 = 0;
    L15:
        return r7 + r9;
    L13:
        r9 = r8.hashCode();
        goto L15
    L5:
        r5 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfficeContactItemModel(feishuUserId=" + this.a + ", dbUserId=" + this.b + ", name=" + this.c + ", alias=" + this.d + ", displayName=" + this.e + ", displayNamePinyin=" + this.f + ", avatarKey=" + this.g + ", doubaoKey=" + this.h + ", isBusinessUser=" + this.i + ", isDeleted=" + this.j + ", relation=" + this.k + ')';
    }

    public d(long r2, long r4, String r6, String r7, String r8, String r9, String r10, String r11, boolean r12, boolean r13, n r14) {
        Intrinsics.checkNotNullParameter(r6, AppbrandHostConstants.Schema_Meta.NAME);
        Intrinsics.checkNotNullParameter(r7, "alias");
        Intrinsics.checkNotNullParameter(r8, "displayName");
        Intrinsics.checkNotNullParameter(r9, "displayNamePinyin");
        Intrinsics.checkNotNullParameter(r10, "avatarKey");
        Intrinsics.checkNotNullParameter(r11, "doubaoKey");
        this.a = r2;
        this.b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
    }
}
