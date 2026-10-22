package lda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.obric.assistant.cocreationreview.s3;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i {
    public static final com.obric.assistant.cocreationreview.g b = null;
    public final lda.a a;

    public static final class a {
    }

    static {
        b = new com.obric.assistant.cocreationreview.g("cocreation_omni_data.db", "omni.database.observe");
    }

    public i(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        lda.a r0 = new lda.a(r6.getApplicationContext());
        this.a = r0;
        long r1 = System.currentTimeMillis() - 172800000;
        int r7 = r0.getWritableDatabase().delete("omni_data", "created_at < ?", new String[]{String.valueOf(r1)});
        int r2 = s3.a;
        s3.b("omni.database", "deleteExpired reason=store_init, cutoff=" + r1 + ", deleted=" + r7);
        if (r7 <= 0) goto L6;
        b.a("omni_records_expired:" + r7);
        return;
    }

    public final void a(List<b0> r15) {
        Intrinsics.checkNotNullParameter(r15, "records");
        if (r15.isEmpty() == false) goto L5;
        return;
    L5:
        SQLiteDatabase r0 = this.a.getWritableDatabase();
        r0.beginTransaction();
        Iterator<T> r1 = r15.iterator();     // Catch: Throwable -> L14
    L9:
        if (r1.hasNext() == false) goto L11;
        b0 r2 = (b0) r1.next();     // Catch: Throwable -> L14
        String r4 = CollectionsKt.joinToString$default(r2.i, null, "[", "]", 0, null, new f(), 25, null);     // Catch: Throwable -> L14
        int r5 = s3.a;     // Catch: Throwable -> L14
        s3.b("omni.database", "upsert row recordId=" + r2.a + ", taskId=" + r2.c + ", createdAt=" + r2.d + ", status=" + r2.g.getRaw() + ", taskTriggerType=" + r2.h.getRaw() + ", stepCount=" + r2.i.size() + ", time=" + r2.j + ", query=" + com.obric.assistant.cocreationreview.modules.omni.a.c(r2.e, 96) + ", answer=" + com.obric.assistant.cocreationreview.modules.omni.a.c(r2.f, 96) + ", steps=" + r4);     // Catch: Throwable -> L14
        r0.insertWithOnConflict("omni_data", null, com.obric.assistant.cocreationreview.modules.omni.a.a(r2), 5);     // Catch: Throwable -> L14
        goto L9
    L11:
        r0.setTransactionSuccessful();     // Catch: Throwable -> L14
        r0.endTransaction();
        int r3 = s3.a;
        s3.b("omni.database", "upsert count=" + r15.size() + ", ids=" + CollectionsKt.joinToString$default(r15, null, null, null, 0, null, new g(), 31, null));
        com.obric.assistant.cocreationreview.g r6 = b;
        StringBuilder r7 = new StringBuilder("omni_records_upsert:");
        r7.append(r15.size());
        r6.a(r7.toString());
        return;
    L14:
        th = move-exception;
        r0.endTransaction();
        throw th;
    }
}
