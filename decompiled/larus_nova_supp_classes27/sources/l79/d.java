package l79;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.larus.drive.biz.impl.database.DriveDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d extends EntityInsertionAdapter<a> {
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `drive_list_mine` (`file_token`,`drive_token`,`order_index`,`file_name`,`file_url`,`open_time`,`edit_time`,`icon_info`,`file_type`,`is_owner`,`drive_obj_type`,`extra`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public d(DriveDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r4, Object r5) {
        a r6 = (a) r5;
        String r0 = r6.a;
        if (r0 != null) goto L5;
        r4.bindNull(1);
    L6:
        String r1 = r6.b;
        if (r1 != null) goto L9;
        r4.bindNull(2);
    L10:
        r4.bindLong(3, r6.c);
        String r2 = r6.d;
        if (r2 != null) goto L13;
        r4.bindNull(4);
    L14:
        String r3 = r6.e;
        if (r3 != null) goto L17;
        r4.bindNull(5);
    L18:
        r4.bindLong(6, r6.f);
        r4.bindLong(7, r6.g);
        String r7 = r6.h;
        if (r7 != null) goto L21;
        r4.bindNull(8);
    L22:
        String r8 = r6.i;
        if (r8 != null) goto L25;
        r4.bindNull(9);
    L26:
        r4.bindLong(10, r6.j);
        r4.bindLong(11, r6.k);
        String r9 = r6.l;
        if (r9 != null) goto L29;
        r4.bindNull(12);
        return;
    L29:
        r4.bindString(12, r9);
        return;
    L25:
        r4.bindString(9, r8);
        goto L26
    L21:
        r4.bindString(8, r7);
        goto L22
    L17:
        r4.bindString(5, r3);
        goto L18
    L13:
        r4.bindString(4, r2);
        goto L14
    L9:
        r4.bindString(2, r1);
        goto L10
    L5:
        r4.bindString(1, r0);
        goto L6
    }
}
