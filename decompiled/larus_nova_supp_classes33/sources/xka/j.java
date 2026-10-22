package xka;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.google.gson.JsonArray;
import kotlin.Pair;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j implements vka.b<JsonArray> {
    public static final /* synthetic */ int e = 0;
    public final String[] a;
    public final Long b;
    public final long c;
    public final long d;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        Intrinsics.checkNotNullParameter(vka.f.a, "context");
        vka.k r0 = new vka.k();
        r0.a("event_id", this.b);
        Pair<String, String[]> r1 = r0.b();
        String r6 = (String) r1.component1();
        String[] r7 = (String[]) r1.component2();
        Uri.Builder r2 = CalendarContract.Instances.CONTENT_URI.buildUpon();
        ContentUris.appendId(r2, this.c);
        ContentUris.appendId(r2, this.d);
        Uri r4 = r2.build();
        ContentResolver r3 = vka.f.d();
        String[] r5 = this.a;
        f06.c r8 = new f06.c();
        Object[] r9 = {r4, r5, r6, r7, null};
        f06.b r16 = new f06.b();
        f06.d r15 = r8.b(240004, "android/content/ContentResolver", "query", r3, r9, "android.database.Cursor", r16);
        if (r15.a == false) goto L5;
        r8.a(240004, "android/content/ContentResolver", "query", r3, r9, null, r16, false);
        Cursor r10 = (Cursor) r15.b;
    L6:
        Cursor r11 = r10;
        JsonArray r12 = vka.n.b(r11, false);     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r11, null);
        return r12;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L5:
        Cursor r13 = r3.query(r4, r5, r6, r7, null);
        r8.a(240004, "android/content/ContentResolver", "query", r3, r9, r13, r16, true);
        r10 = r13;
        goto L6
    }

    public j(String[] r1, Long r2, long r3, long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }
}
