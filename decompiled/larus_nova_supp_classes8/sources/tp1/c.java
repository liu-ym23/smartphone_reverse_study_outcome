package tp1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends SQLiteOpenHelper {
    public static final Boolean a = null;
    public static final c b = null;

    static {
        a = Boolean.valueOf(v.a());
        b = new c(jc1.a.b());
    }

    public c(Context r4) {
        super(r4, "VSCacheSQLHelper.db", null, 6);
    }

    public static long insert(ContentValues r3) {
        if (a.booleanValue() == false) goto L9;
        ALogger.e("VSCacheSQLHelper", new RuntimeException("insert"));
    L9:
        return b.getWritableDatabase().insert("VSVideoCache", null, r3);
    L7:
        return -1;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r2) {
        r2.execSQL("CREATE TABLE IF NOT EXISTS VSVideoCache (_id integer primary key autoincrement, title varchar(256),video_id varchar(256) NOT NULL,download_size long,total_size long,time long,state integer,error_code integer,season_name varchar(256),season_id varchar(256),definition varchar(256),episode_id long,video_key varchar(256),video_duration long,current_period varchar(256),cover_url varchar(256),item_id varchar(256),style integer,position long,vertical_url varchar(256),vertical_width long,vertical_margin_l long,vertical_margin_p long,horizontal_url varchar(256),horizontal_width long,horizontal_margin_l long,horizontal_margin_p long,episode_stage_type integer,download_uid varchar(256))");
    }

    public static int delete(String r2, String[] r3) {
        if (a.booleanValue() == false) goto L9;
        ALogger.e("VSCacheSQLHelper", new RuntimeException("delete"));
    L9:
        return b.getWritableDatabase().delete("VSVideoCache", r2, r3);
    L7:
        return 0;
    }

    public static void a(SQLiteDatabase r3, String r4, String r5) {
        if (a.booleanValue() == false) goto L5;
        ALogger.e("VSCacheSQLHelper", new RuntimeException("checkAndAddColumn"));
    L5:
        Cursor r0 = null;
        boolean r1 = false;
        r0 = r3.rawQuery("SELECT * FROM VSVideoCache LIMIT 0", null);     // Catch: Throwable -> L12
        if (r0 == null) goto L13;
        if (r0.getColumnIndex(r4) == (-1)) goto L13;
        r1 = true;
    L13:
        if (r0 != null) goto L15;
    L21:
        if (r1 == true) goto L26;
        r3.execSQL(r5);
        return;
    L26:
        return;
    L15:
        if (r0.isClosed() == true) goto L21;
    L20:
        r0.close();
    L17:
        if (r0 == null) goto L21;
        if (r0.isClosed() == true) goto L21;
        goto L20
    }

    public static void update(ContentValues r2, String r3, String[] r4) {
        if (a.booleanValue() == false) goto L5;
        ALogger.e("VSCacheSQLHelper", new RuntimeException("update"));
    L5:
        SQLiteDatabase r0 = null;
        r0 = b.getWritableDatabase();     // Catch: Throwable -> L8
        r0.beginTransaction();     // Catch: Throwable -> L8
        r0.update("VSVideoCache", r2, r3, r4);     // Catch: Throwable -> L8
        r0.setTransactionSuccessful();     // Catch: Throwable -> L8
    L10:
        r0.endTransaction();
        return;
    L9:
        if (r0 != null) goto L10;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r3, int r4, int r5) {
        if (r4 >= 2) goto L6;
        r3.execSQL("ALTER TABLE VSVideoCache ADD COLUMN item_id varchar(256)");
    L6:
        if (r4 >= 3) goto L9;
        r3.execSQL("ALTER TABLE VSVideoCache ADD COLUMN style integer");
    L9:
        if (r4 >= 4) goto L12;
        a(r3, "position", "ALTER TABLE VSVideoCache ADD COLUMN position long");
        a(r3, "vertical_url", "ALTER TABLE VSVideoCache ADD COLUMN vertical_url varchar(256)");
        a(r3, "vertical_width", "ALTER TABLE VSVideoCache ADD COLUMN vertical_width long");
        a(r3, "vertical_margin_l", "ALTER TABLE VSVideoCache ADD COLUMN vertical_margin_l long");
        a(r3, "vertical_margin_p", "ALTER TABLE VSVideoCache ADD COLUMN vertical_margin_p long");
        a(r3, "horizontal_url", "ALTER TABLE VSVideoCache ADD COLUMN horizontal_url varchar(256)");
        a(r3, "horizontal_width", "ALTER TABLE VSVideoCache ADD COLUMN horizontal_width long");
        a(r3, "horizontal_margin_l", "ALTER TABLE VSVideoCache ADD COLUMN horizontal_margin_l long");
        a(r3, "horizontal_margin_p", "ALTER TABLE VSVideoCache ADD COLUMN horizontal_margin_p long");
    L12:
        if (r4 >= 5) goto L15;
        a(r3, "episode_stage_type", "ALTER TABLE VSVideoCache ADD COLUMN episode_stage_type integer");
    L15:
        if (r4 >= 6) goto L25;
        r3.beginTransaction();
        r3.execSQL("create table VSVideoCache_dg_tmp( _id integer primary key autoincrement, title varchar(256), video_id varchar(256) not null, download_size long, total_size long, time long, state integer, error_code integer, season_name varchar(256), season_id varchar(256), definition varchar(256), episode_id long, video_key varchar(256), video_duration long, current_period varchar(256), cover_url varchar(256), item_id varchar(256), style integer, position long, vertical_url varchar(256), vertical_width long, vertical_margin_l long, vertical_margin_p long, horizontal_url varchar(256), horizontal_width long, horizontal_margin_l long, horizontal_margin_p long, episode_stage_type integer, download_uid varchar(256))");     // Catch: Throwable -> L19
        r3.execSQL("insert into VSVideoCache_dg_tmp( title, video_id, download_size, total_size, time, state, error_code, season_name, season_id, definition, episode_id, video_key, video_duration, current_period, cover_url, item_id, style, position, vertical_url, vertical_width, vertical_margin_l, vertical_margin_p, horizontal_url, horizontal_width, horizontal_margin_l, horizontal_margin_p, episode_stage_type)select  title, video_id, download_size, total_size, time, state, error_code, season_name, season_id, definition, episode_id, video_key, video_duration, current_period, cover_url, item_id, style, position, vertical_url, vertical_width, vertical_margin_l, vertical_margin_p, horizontal_url, horizontal_width, horizontal_margin_l, horizontal_margin_p, episode_stage_type from VSVideoCache");     // Catch: Throwable -> L19
        r3.execSQL("drop table VSVideoCache");     // Catch: Throwable -> L19
        r3.execSQL("alter table VSVideoCache_dg_tmp rename to VSVideoCache");     // Catch: Throwable -> L19
        r3.setTransactionSuccessful();     // Catch: Throwable -> L19
    L21:
        r3.endTransaction();
        return;
    L19:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r3.endTransaction();
        throw th;
    }

    public static Cursor query(String[] r9, String r10, String[] r11, String r12, String r13, String r14) {
        if (a.booleanValue() == false) goto L9;
        ALogger.e("VSCacheSQLHelper", new RuntimeException("query"));
    L9:
        return b.getReadableDatabase().query("VSVideoCache", r9, r10, r11, r12, r13, r14);
    L7:
        return null;
    }
}
