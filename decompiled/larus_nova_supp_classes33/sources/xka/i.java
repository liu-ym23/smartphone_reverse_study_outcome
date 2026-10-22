package xka;

import android.database.Cursor;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i implements vka.b<JsonArray> {
    public static final /* synthetic */ int f = 0;
    public final ala.e a;
    public final String[] b;
    public final String c;
    public final String[] d;
    public final String e;

    public static final class a {
        public static i a(ala.e r10, JsonObject r11) {
            Intrinsics.checkNotNullParameter(r10, "token");
            Intrinsics.checkNotNullParameter(r11, "json");
            JsonElement r0 = r11.get("projection");
            if (r0 == null) goto L11;
            JsonArray r1 = r0.getAsJsonArray();
            if (r1 == null) goto L11;
            ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L10;
            r4.add(((JsonElement) r2.next()).getAsString());
            goto L8
        L10:
            String[] r6 = (String[]) r4.toArray(new String[0]);
        L12:
            JsonElement r3 = r11.get("selection");
            if (r3 == null) goto L15;
            String r7 = r3.getAsString();
        L16:
            JsonElement r5 = r11.get("selectionArgs");
            if (r5 == null) goto L25;
            JsonArray r8 = r5.getAsJsonArray();
            if (r8 == null) goto L25;
            ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
            Iterator r12 = r8.iterator();
        L22:
            if (r12.hasNext() == false) goto L24;
            r9.add(((JsonElement) r12.next()).getAsString());
            goto L22
        L24:
            String[] r13 = (String[]) r9.toArray(new String[0]);
        L26:
            JsonElement r14 = r11.get("sortOrder");
            if (r14 == null) goto L29;
            String r15 = r14.getAsString();
        L30:
            if (r6 != null) goto L35;
            if (r7 != null) goto L35;
            if (r13 != null) goto L35;
            if (r15 != null) goto L35;
            return null;
        L35:
            return new i(r10, r6, r7, r13, r15);
        L29:
            r15 = null;
        L25:
            r13 = null;
            goto L26
        L15:
            r7 = null;
        L11:
            r6 = null;
            goto L12
        }
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r0 = vka.f.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        Cursor r1 = r0.query(this.a, this.b, this.c, this.d, this.e);
        JsonArray r2 = vka.n.b(r1, false);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r1, null);
        return r2;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    }

    public /* synthetic */ i(ala.e r7) {
        this(r7, null, null, null, null);
    }

    public i(ala.e r2, String[] r3, String r4, String[] r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "token");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
