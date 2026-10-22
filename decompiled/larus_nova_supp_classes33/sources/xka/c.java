package xka;

import android.content.ContentValues;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c implements vka.b<Object> {
    public static final /* synthetic */ int e = 0;
    public final Long a;
    public final long b;
    public final Long c;
    public final Integer d;

    public static final class a {
        public static c a(JsonObject r8, boolean r9) {
            Intrinsics.checkNotNullParameter(r8, "json");
            JsonElement r0 = r8.get("id");
            Integer r1 = null;
            if (r0 == null) goto L5;
            Long r3 = Long.valueOf(r0.getAsLong());
        L6:
            if (r9 == false) goto L11;
            if (r3 == null) goto L11;
            throw new IllegalArgumentException("add reminder with non-null id");
        L11:
            if (r9 == true) goto L16;
            if (r3 != null) goto L16;
            throw new IllegalArgumentException("update reminder with null id");
        L16:
            long r4 = r8.get("eventId").getAsLong();
            JsonElement r2 = r8.get("minutes");
            if (r2 == null) goto L19;
            Long r6 = Long.valueOf(r2.getAsLong());
        L20:
            JsonElement r10 = r8.get("method");
            if (r10 == null) goto L24;
            r1 = Integer.valueOf(r10.getAsInt());
        L24:
            return new c(r3, r4, r6, r1);
        L19:
            r6 = null;
            goto L20
        L5:
            r3 = null;
            goto L6
        }
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r0 = vka.f.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        ala.d r1 = new ala.d(this.a, 2);
        ContentValues r2 = new ContentValues();
        r2.put("event_id", Long.valueOf(this.b));
        r2.put("minutes", this.c);
        r2.put("method", this.d);
        if (this.a == null) goto L10;
        if (r0.update(r1, r2, null, null) <= 0) goto L7;
        boolean r3 = true;
    L11:
        return Boolean.valueOf(r3);
    L7:
        r3 = false;
        goto L11
    L10:
        return r0.insert(r1, r2);
    }

    public c(Long r1, long r2, Long r4, Integer r5) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
    }
}
