package l79;

import androidx.room.SharedSQLiteStatement;
import com.larus.drive.biz.impl.database.DriveDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM drive_list_recent WHERE file_token = ?";
    }

    public k(DriveDatabase r1) {
        super(r1);
    }
}
