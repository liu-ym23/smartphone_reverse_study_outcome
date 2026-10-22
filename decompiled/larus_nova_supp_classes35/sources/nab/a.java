package nab;

import com.bytedance.lark.pb.basic.v1.LanguageType;
import com.ss.android.lark.custom.repeat.CustomRepeatParams$DayOfWeek;
import com.ss.android.lark.custom.repeat.entity.CalendarDate;
import com.ss.android.lark.custom.repeat.entity.RepeatMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final RepeatMode a;
    public final CustomRepeatParams$DayOfWeek b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final CalendarDate f;
    public final Integer g;
    public final Integer h;
    public final LanguageType i;

    public a() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        RepeatMode r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
        int r4 = 1231;
        if (this.c == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.d == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        if (this.e == true) goto L18;
        r4 = 1237;
    L18:
        int r9 = (((r8 + r4) * 31) + this.f.hashCode()) * 31;
        Integer r10 = this.g;
        if (r10 != null) goto L21;
        int r11 = 0;
    L22:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.h;
        if (r13 == null) goto L27;
        r1 = r13.hashCode();
    L27:
        return ((r12 + r1) * 31) + this.i.hashCode();
    L21:
        r11 = r10.hashCode();
        goto L22
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CustomRepeatData(lastRepeatMode=" + this.a + ", firstDayOfWeek=" + this.b + ", isSingleInWeek=" + this.c + ", isSingleInMonth=" + this.d + ", isFixDefaultDate=" + this.e + ", defaultDate=" + this.f + ", bannedUnselectedStringId=" + this.g + ", bannedSlideStringId=" + this.h + ", languageType=" + this.i + ')';
    }

    public /* synthetic */ a(int r11) {
        this(null, CustomRepeatParams$DayOfWeek.SUNDAY, false, false, false, new CalendarDate(), null, null, LanguageType.UNKNOWN_LANGUAGE);
    }

    public a(RepeatMode r2, CustomRepeatParams$DayOfWeek r3, boolean r4, boolean r5, boolean r6, CalendarDate r7, Integer r8, Integer r9, LanguageType r10) {
        Intrinsics.checkNotNullParameter(r3, "firstDayOfWeek");
        Intrinsics.checkNotNullParameter(r7, "defaultDate");
        Intrinsics.checkNotNullParameter(r10, "languageType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
