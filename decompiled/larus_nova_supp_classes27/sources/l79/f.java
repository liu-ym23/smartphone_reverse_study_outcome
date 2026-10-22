package l79;

import androidx.room.SharedSQLiteStatement;
import com.larus.drive.biz.impl.database.DriveDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM drive_list_mine WHERE file_token = ?";
    }

    public f(DriveDatabase r1) {
        super(r1);
    }
}
