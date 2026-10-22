package y6b;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.entity.chatter.AvatarMedal;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterCustomStatus;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.chat.entity.chatter.TagInfo;
import com.ss.android.lark.chat.entity.chatter.UserPrivateDescription;
import com.ss.android.lark.chat.entity.chatter.WorkStatus;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements y28.b<b> {
    public boolean A;
    public ChatterCustomStatus B;
    public List<ChatterCustomStatus> C;
    public String D;
    public final String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public Chatter.ChatterType j;
    public String k;
    public WorkStatus l;
    public boolean m;
    public long n;
    public ChatterDescription o;
    public UserPrivateDescription p;
    public boolean q;
    public boolean r;
    public String s;
    public boolean t;
    public String u;
    public String v;
    public String w;
    public boolean x;
    public List<TagInfo> y;
    public AvatarMedal z;

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public b(String r1) {
        this.a = r1;
    }

    public final boolean a(b r8) {
        if (r8 == null) goto L8;
        if (this != r8) goto L6;
    L7:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
    L65:
        return false;
    L11:
        if (TextUtils.equals(this.b, r8.b) == false) goto L65;
        if (TextUtils.equals(this.c, r8.c) == false) goto L65;
        if (TextUtils.equals(this.d, r8.d) == false) goto L65;
        if (TextUtils.equals(this.e, r8.e) == false) goto L65;
        if (TextUtils.equals(this.f, r8.f) == false) goto L65;
        if (TextUtils.equals(this.g, r8.g) == false) goto L65;
        if (TextUtils.equals(this.h, r8.h) == false) goto L65;
        if (TextUtils.equals(this.i, r8.i) == false) goto L65;
        if (TextUtils.equals(this.s, r8.s) == false) goto L65;
        if (this.t != r8.t) goto L65;
        if (TextUtils.equals(this.e, r8.e) == false) goto L65;
        if (TextUtils.equals(this.k, r8.k) == false) goto L65;
        if (this.n != r8.n) goto L65;
        if (Objects.equals(this.p, r8.p) == false) goto L65;
        if (Objects.equals(Boolean.valueOf(this.q), Boolean.valueOf(r8.q)) == false) goto L65;
        if (Objects.equals(this.l, r8.l) == false) goto L65;
        if (Objects.equals(this.z, r8.z) == false) goto L65;
        if (Objects.equals(Boolean.valueOf(this.A), Boolean.valueOf(r8.A)) == false) goto L65;
        List<TagInfo> r3 = r8.y;
        List<TagInfo> r4 = this.y;
        if (r4.size() != r3.size()) goto L54;
        int r5 = 0;
    L51:
        if (r5 >= r4.size()) goto L56;
        if (((TagInfo) ListProtector.get(r4, r5)).equals(ListProtector.get(r3, r5)) == false) goto L54;
        r5 = r5 + 1;
        goto L51
    L56:
        boolean r6 = true;
    L57:
        if (r6 == false) goto L65;
        if (Objects.equals(this.B, r8.B) == false) goto L65;
        if (Objects.equals(this.u, r8.u) == false) goto L65;
        if (Objects.equals(this.D, r8.D) == false) goto L65;
        return true;
    L54:
        r6 = false;
        goto L57
    L6:
        if (TextUtils.equals(this.a, r8.a) == true) goto L7;
    L8:
        r2 = false;
        goto L9
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (b.class == r3.getClass()) goto L10;
        return false;
    L10:
        return a((b) r3);
    }

    public final /* bridge */ /* synthetic */ boolean isContentSame(y28.b r1) {
        return a((b) r1);
    }

    public final boolean isItemSame(y28.b r2) {
        b r3 = (b) r2;
        if (r3 == null) goto L8;
        if (this != r3) goto L6;
    L7:
        return true;
    L6:
        if (TextUtils.equals(this.a, r3.a) == true) goto L7;
    L8:
        return false;
    }
}
