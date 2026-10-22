package xka;

import android.content.ContentValues;
import android.net.Uri;
import android.provider.CalendarContract;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class o implements vka.b<Boolean> {
    public static final /* synthetic */ int f = 0;
    public final String a;
    public final String b;
    public final Integer c;
    public final String d;
    public final int e;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        Intrinsics.checkNotNullParameter(vka.f.a, "context");
        final Uri r0 = CalendarContract.Colors.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", this.a).appendQueryParameter("account_type", this.b).build();
        if (this.c == null) goto L5;
        final ContentValues r1 = new ContentValues();
        r1.put("account_name", this.a);
        r1.put("account_type", this.b);
        r1.put("color_type", this.c);
        r1.put("color_index", this.d);
        r1.put("color", Integer.valueOf(this.e));
        Function0 r2 = new m(r0, r1);
    L7:
        return (Boolean) r2.invoke();
    L5:
        final ContentValues r3 = new ContentValues();
        r3.put("account_name", this.a);
        r3.put("account_type", this.b);
        r3.put("color", Integer.valueOf(this.e));
        vka.k r5 = new vka.k();
        r5.a("account_type", this.b);
        r5.a("account_name", this.a);
        r5.a("color_index", this.d);
        Pair<String, String[]> r4 = r5.b();
        final String r6 = (String) r4.component1();
        final String[] r7 = (String[]) r4.component2();
        r2 = new n(r0, r3, r6, r7);
        goto L7
    }

    public o(String r2, String r3, Integer r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "accountName");
        Intrinsics.checkNotNullParameter(r3, "accountType");
        Intrinsics.checkNotNullParameter(r5, "colorKey");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
