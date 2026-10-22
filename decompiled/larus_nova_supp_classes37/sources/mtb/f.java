package mtb;

import com.ss.android.lark.officesdk.contact.api.model.DoubaoAddFriendSettingType;
import com.ss.android.lark.officesdk.contact.api.model.OfficeContactSettingsItemAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f {
    public final DoubaoAddFriendSettingType a;
    public final String b;
    public final int c;
    public boolean d;
    public final OfficeContactSettingsItemAction e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.e.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "OfficeContactSettingsItem(id=" + this.a + ", title=" + this.b + ", iconName=" + this.c + ", enabled=" + this.d + ", action=" + this.e + ')';
    }

    public f(DoubaoAddFriendSettingType r2, String r3, int r4, boolean r5, OfficeContactSettingsItemAction r6) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r6, "action");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
