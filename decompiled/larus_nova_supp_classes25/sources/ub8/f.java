package ub8;

import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public final boolean a;
    public final BotLanguage b;
    public final BotModel c;
    public final Long d;

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
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + this.b.hashCode()) * 31;
        BotModel r2 = this.c;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        Long r6 = this.d;
        if (r6 == null) goto L15;
        r3 = r6.hashCode();
    L15:
        return r5 + r3;
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "LanguageUpdateResult(success=" + this.a + ", botLanguage=" + this.b + ", botInfo=" + this.c + ", errCode=" + this.d + ')';
    }

    public f(boolean r2, BotLanguage r3, BotModel r4, Long r5) {
        Intrinsics.checkNotNullParameter(r3, "botLanguage");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
