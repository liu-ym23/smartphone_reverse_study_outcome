package wu8;

import com.larus.bmhome.share.panel.ShareType;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.bot.impl.common.propertyconfig.Visibility;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final Visibility a;
    public final TextRes b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "AutoFillBtnUIState(visibility=" + this.a + ", text=" + this.b + ')';
    }

    public a(Visibility r2, TextRes.StringResId r3) {
        Intrinsics.checkNotNullParameter(r2, "visibility");
        Intrinsics.checkNotNullParameter(r3, ShareType.TEXT);
        this.a = r2;
        this.b = r3;
    }
}
