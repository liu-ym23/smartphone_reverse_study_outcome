package g22;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.android.livesdk.i18n.db.I18nDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends EntityInsertionAdapter<d> {
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `translation` (`key`,`value`) VALUES (?,?)";
    }

    public f(I18nDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r3, Object r4) {
        d r5 = (d) r4;
        String r0 = r5.a;
        if (r0 != null) goto L5;
        r3.bindNull(1);
    L6:
        String r6 = r5.b;
        if (r6 != null) goto L9;
        r3.bindNull(2);
        return;
    L9:
        r3.bindString(2, r6);
        return;
    L5:
        r3.bindString(1, r0);
        goto L6
    }
}
