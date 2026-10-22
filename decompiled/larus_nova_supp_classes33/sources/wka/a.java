package wka;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.google.gson.JsonArray;
import f06.d;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import vka.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a implements vka.b<JsonArray> {
    public static final /* synthetic */ int d = 0;
    public final long a;
    public final long b;
    public final boolean c;

    /* JADX INFO: renamed from: wka.a$a, reason: collision with other inner class name */
    public static final class C0074a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        Intrinsics.checkNotNullParameter(f.a, "context");
        LinkedHashSet r0 = new LinkedHashSet();
        Uri.Builder r2 = CalendarContract.Instances.CONTENT_URI.buildUpon();
        ContentUris.appendId(r2, this.a);
        ContentUris.appendId(r2, this.b);
        Cursor r3 = a(f.d(), r2.build(), new String[]{"event_id"}, null);
        if (r3 == null) goto L18;
        Cursor r4 = r3;
        Cursor r5 = r4;     // Catch: Throwable -> L11
    L7:
        if (r5.moveToNext() == false) goto L9;
        r0.add(Long.valueOf(r5.getLong(0)));     // Catch: Throwable -> L11
        goto L7
    L9:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r4, null);
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    L18:
        if (this.c == true) goto L20;
    L36:
        JsonArray r7 = new JsonArray();
        Iterator r1 = r0.iterator();
    L38:
        if (r1.hasNext() == false) goto L40;
        r7.add((Number) r1.next());
        goto L38
    L40:
        return r7;
    L20:
        if ((!r0.isEmpty()) == false) goto L36;
        Cursor r8 = a(f.d(), CalendarContract.Reminders.CONTENT_URI, new String[]{"event_id"}, "event_id IN " + CollectionsKt.joinToString$default(r0, ",", "(", ")", 0, null, null, 56, null));
        if (r8 == null) goto L36;
        Cursor r9 = r8;
        Cursor r10 = r9;     // Catch: Throwable -> L30
        r0.clear();     // Catch: Throwable -> L30
    L26:
        if (r10.moveToNext() == false) goto L28;
        r0.add(Long.valueOf(r10.getLong(0)));     // Catch: Throwable -> L30
        goto L26
    L28:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L30
        CloseableKt.closeFinally(r9, null);
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);
        throw th;
    }

    public a(long r1, long r3, boolean r5) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
    }

    public static Cursor a(ContentResolver r12, Uri r13, String[] r14, String r15) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, r14, r15, null, null};
        f06.b r10 = new f06.b();
        d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r16 = r12.query(r13, r14, r15, null, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r16, r10, true);
        return r16;
    }
}
