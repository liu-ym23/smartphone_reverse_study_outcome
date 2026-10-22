package wka;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.google.gson.JsonArray;
import f06.d;
import kotlin.Pair;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import vka.f;
import vka.k;
import vka.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b implements vka.b<JsonArray> {
    public static final /* synthetic */ int d = 0;
    public final Long a;
    public final long b;
    public final long c;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        Intrinsics.checkNotNullParameter(f.a, "context");
        k r0 = new k();
        r0.a("event_id", this.a);
        Pair<String, String[]> r1 = r0.b();
        String r7 = (String) r1.component1();
        String[] r8 = (String[]) r1.component2();
        Uri.Builder r2 = CalendarContract.Instances.CONTENT_URI.buildUpon();
        ContentUris.appendId(r2, this.b);
        ContentUris.appendId(r2, this.c);
        Uri r5 = r2.build();
        ContentResolver r3 = f.d();
        String[] r6 = {"event_id", "begin", "end"};
        f06.c r4 = new f06.c();
        Object[] r9 = {r5, r6, r7, r8, null};
        f06.b r17 = new f06.b();
        d r15 = r4.b(240004, "android/content/ContentResolver", "query", r3, r9, "android.database.Cursor", r17);
        if (r15.a == false) goto L5;
        r4.a(240004, "android/content/ContentResolver", "query", r3, r9, null, r17, false);
        Cursor r10 = (Cursor) r15.b;
        boolean r11 = true;
    L6:
        Cursor r12 = r10;
        JsonArray r13 = n.b(r12, r11);     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r12, null);
        return r13;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    L5:
        r10 = r3.query(r5, r6, r7, r8, null);
        r11 = true;
        r4.a(240004, "android/content/ContentResolver", "query", r3, r9, r10, r17, true);
        goto L6
    }

    public b(Long r1, long r2, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
