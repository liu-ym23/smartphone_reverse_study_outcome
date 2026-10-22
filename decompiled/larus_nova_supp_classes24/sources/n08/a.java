package n08;

import com.larksuite.component.universe_design.datepicker.impl.data.CalendarAttr;
import com.larksuite.component.universe_design.util.CalendarDate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final int a;
    public final int b;
    public CalendarDate c;
    public final CalendarAttr d;

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
        if (this.b == r6.b) goto L15;
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
        return (((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "BaseDay(posRow=" + this.a + ", posCol=" + this.b + ", date=" + this.c + ", calendarAttr=" + this.d + ')';
    }

    public a(int r2, int r3, CalendarDate r4, CalendarAttr r5) {
        Intrinsics.checkNotNullParameter(r4, "date");
        Intrinsics.checkNotNullParameter(r5, "calendarAttr");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
