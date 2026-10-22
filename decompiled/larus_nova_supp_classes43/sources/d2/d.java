package d2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.LruCache;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final LruCache<String, JSONObject> a;
    public final a b;
    public final b c;

    public class a extends LruCache<String, byte[]> {
        public a() {
            super(1048576);
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r1, byte[] r10) {
            return r10.length;
        }
    }

    public d(Context r10) {
        this.a = new LruCache(100);
        this.b = new a();
        this.c = new b(r10);
    }

    public final void a(String r10, JSONObject r11) {
        if (r10 == null) goto L10;
        this.a.put(r10, r11);
        this.b.put(r10, r11.toString().getBytes(StandardCharsets.UTF_8));
        SQLiteDatabase r0 = this.c.getWritableDatabase();
        r0.execSQL("INSERT OR REPLACE INTO policies (app_id, content, version) VALUES (?, ?, ?)", new Object[]{r10, r11.toString(), Long.valueOf(r11.optLong("version", System.currentTimeMillis()))});     // Catch: Exception -> L6
        return;
    L7:
        return;
    }
}
