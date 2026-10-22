package d18;

import android.content.Context;
import com.larksuite.component.universe_design.util.CalendarDate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements e18.a<a> {
    public final Context a;
    public final int b;
    public final int c;
    public final String[] d;
    public final int e;
    public final boolean f;
    public final int g;

    public final class a implements e18.c {
        public final int a;
        public final /* synthetic */ d b;

        @Override // e18.c
        public final String a() {
            int r0 = this.a;
            if (r0 >= 0) goto L5;
            return "";
        L5:
            if (r0 >= this.b.getItemsCount()) goto L14;
            d r1 = this.b;
            int r2 = r1.e + this.a;
            CalendarDate r3 = new CalendarDate(r1.b, r1.c, r2, 0, 0, 0);
            StringBuilder r4 = new StringBuilder();
            r4.append(h18.b.a(this.b.getContext(), 2131887018, "numberDay", String.valueOf(r2)));
            if (this.b.f == false) goto L11;
            r4.append("(");
            r4.append(this.b.d[r3.getWeekDay() - 1]);
            r4.append(")");
        L11:
            return r4.toString();
        L14:
            return "";
        }

        public a(d r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    @Override // e18.a
    public final int getItemsCount() {
        return (this.g - this.e) + 1;
    }

    public final Context getContext() {
        return this.a;
    }

    @Override // e18.a
    public final int a(Object r1) {
        return e18.a.C0102a.a(this, r1);
    }

    @Override // e18.a
    public final a getItem(int r2) {
        return new a(this, r2);
    }

    @Override // e18.a
    public final int indexOf(a r2) {
        a r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "dayWeek");
        return r3.a;
    }

    public d(Context r3, int r4, int r5, String[] r6, boolean r7) {
        int r0 = com.larksuite.component.universe_design.util.a.a(r4, r5);
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r6, "mWeeks");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = 1;
        this.f = r7;
        this.g = r0;
    }
}
