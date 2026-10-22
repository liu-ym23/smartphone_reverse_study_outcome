package g22;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.android.livesdk.i18n.db.I18nDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM translation";
    }

    public g(I18nDatabase r1) {
        super(r1);
    }
}
