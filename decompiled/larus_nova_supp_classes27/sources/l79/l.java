package l79;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.larus.drive.biz.impl.database.DriveDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l implements h {
    public final RoomDatabase a;
    public final i b;
    public final j c;
    public final k d;

    public class a implements Callable<Unit> {
        public final /* synthetic */ List a;
        public final /* synthetic */ l b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Unit call2() throws Exception {
            this.b.a.beginTransaction();
            this.b.b.insert(this.a);     // Catch: Throwable -> L6
            this.b.a.setTransactionSuccessful();     // Catch: Throwable -> L6
            Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L6
            this.b.a.endTransaction();
            return r0;
        L6:
            th = move-exception;
            this.b.a.endTransaction();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Unit call() throws Exception {
            return call2();
        }

        public a(l r1, List r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements Callable<Integer> {
        public final /* synthetic */ l a;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            SupportSQLiteStatement r0 = this.a.c.acquire();
            this.a.a.beginTransaction();
            Integer r1 = Integer.valueOf(r0.executeUpdateDelete());     // Catch: Throwable -> L6
            this.a.a.setTransactionSuccessful();     // Catch: Throwable -> L6
            this.a.a.endTransaction();
            this.a.c.release(r0);
            return r1;
        L6:
            th = move-exception;
            this.a.a.endTransaction();
            this.a.c.release(r0);
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Integer call() throws Exception {
            return call();
        }

        public b(l r1) {
            this.a = r1;
        }
    }

    public class c implements Callable<Integer> {
        public final /* synthetic */ String a;
        public final /* synthetic */ l b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            SupportSQLiteStatement r0 = this.b.d.acquire();
            String r1 = this.a;
            if (r1 != null) goto L5;
            r0.bindNull(1);
        L6:
            this.b.a.beginTransaction();
            Integer r2 = Integer.valueOf(r0.executeUpdateDelete());     // Catch: Throwable -> L10
            this.b.a.setTransactionSuccessful();     // Catch: Throwable -> L10
            this.b.a.endTransaction();
            this.b.d.release(r0);
            return r2;
        L10:
            th = move-exception;
            this.b.a.endTransaction();
            this.b.d.release(r0);
            throw th;
        L5:
            r0.bindString(1, r1);
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Integer call() throws Exception {
            return call();
        }

        public c(l r1, String r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class d implements Callable<List<l79.b>> {
        public final /* synthetic */ RoomSQLiteQuery a;
        public final /* synthetic */ l b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<l79.b> call2() throws Exception {
            Cursor r2 = DBUtil.query(this.b.a, this.a, false, null);
            int r0 = CursorUtil.getColumnIndexOrThrow(r2, "file_token");     // Catch: Throwable -> L38
            int r3 = CursorUtil.getColumnIndexOrThrow(r2, "drive_token");     // Catch: Throwable -> L38
            int r5 = CursorUtil.getColumnIndexOrThrow(r2, "order_index");     // Catch: Throwable -> L38
            int r6 = CursorUtil.getColumnIndexOrThrow(r2, "file_name");     // Catch: Throwable -> L38
            int r7 = CursorUtil.getColumnIndexOrThrow(r2, "file_url");     // Catch: Throwable -> L38
            int r8 = CursorUtil.getColumnIndexOrThrow(r2, "open_time");     // Catch: Throwable -> L38
            int r9 = CursorUtil.getColumnIndexOrThrow(r2, "edit_time");     // Catch: Throwable -> L38
            int r10 = CursorUtil.getColumnIndexOrThrow(r2, "icon_info");     // Catch: Throwable -> L38
            int r11 = CursorUtil.getColumnIndexOrThrow(r2, "file_type");     // Catch: Throwable -> L38
            int r12 = CursorUtil.getColumnIndexOrThrow(r2, "is_owner");     // Catch: Throwable -> L38
            int r13 = CursorUtil.getColumnIndexOrThrow(r2, "drive_obj_type");     // Catch: Throwable -> L38
            int r14 = CursorUtil.getColumnIndexOrThrow(r2, "extra");     // Catch: Throwable -> L38
            ArrayList r15 = new ArrayList(r2.getCount());     // Catch: Throwable -> L38
        L4:
            if (r2.moveToNext() == false) goto L36;
            if (r2.isNull(r0) == false) goto L9;
            String r17 = null;
        L11:
            if (r2.isNull(r3) == false) goto L13;
            String r18 = null;
        L14:
            int r110 = r2.getInt(r5);     // Catch: Throwable -> L38
            if (r2.isNull(r6) == false) goto L17;
            String r20 = null;
        L19:
            if (r2.isNull(r7) == false) goto L21;
            String r21 = null;
        L22:
            long r22 = r2.getLong(r8);     // Catch: Throwable -> L38
            long r24 = r2.getLong(r9);     // Catch: Throwable -> L38
            if (r2.isNull(r10) == false) goto L25;
            String r26 = null;
        L27:
            if (r2.isNull(r11) == false) goto L29;
            String r27 = null;
        L30:
            int r28 = r2.getInt(r12);     // Catch: Throwable -> L38
            int r210 = r2.getInt(r13);     // Catch: Throwable -> L38
            if (r2.isNull(r14) == false) goto L33;
            String r30 = null;
        L34:
            r15.add(new l79.b(r17, r18, r110, r20, r21, r22, r24, r26, r27, r28, r210, r30));     // Catch: Throwable -> L38
            goto L4
        L33:
            r30 = r2.getString(r14);     // Catch: Throwable -> L38
            goto L34
        L29:
            r27 = r2.getString(r11);     // Catch: Throwable -> L38
            goto L30
        L25:
            r26 = r2.getString(r10);     // Catch: Throwable -> L38
            goto L27
        L21:
            r21 = r2.getString(r7);     // Catch: Throwable -> L38
            goto L22
        L17:
            r20 = r2.getString(r6);     // Catch: Throwable -> L38
            goto L19
        L13:
            r18 = r2.getString(r3);     // Catch: Throwable -> L38
            goto L14
        L9:
            r17 = r2.getString(r0);     // Catch: Throwable -> L38
            goto L11
        L36:
            r2.close();
            this.a.release();
            return r15;
        L38:
            th = move-exception;
            r2.close();
            this.a.release();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<l79.b> call() throws Exception {
            return call2();
        }

        public d(l r1, RoomSQLiteQuery r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class e implements Callable<l79.b> {
        public final /* synthetic */ RoomSQLiteQuery a;
        public final /* synthetic */ l b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public l79.b call2() throws Exception {
            l79.b r4 = null;
            String r5 = null;
            Cursor r2 = DBUtil.query(this.b.a, this.a, false, null);
            int r0 = CursorUtil.getColumnIndexOrThrow(r2, "file_token");     // Catch: Throwable -> L36
            int r3 = CursorUtil.getColumnIndexOrThrow(r2, "drive_token");     // Catch: Throwable -> L36
            int r6 = CursorUtil.getColumnIndexOrThrow(r2, "order_index");     // Catch: Throwable -> L36
            int r7 = CursorUtil.getColumnIndexOrThrow(r2, "file_name");     // Catch: Throwable -> L36
            int r8 = CursorUtil.getColumnIndexOrThrow(r2, "file_url");     // Catch: Throwable -> L36
            int r9 = CursorUtil.getColumnIndexOrThrow(r2, "open_time");     // Catch: Throwable -> L36
            int r10 = CursorUtil.getColumnIndexOrThrow(r2, "edit_time");     // Catch: Throwable -> L36
            int r11 = CursorUtil.getColumnIndexOrThrow(r2, "icon_info");     // Catch: Throwable -> L36
            int r12 = CursorUtil.getColumnIndexOrThrow(r2, "file_type");     // Catch: Throwable -> L36
            int r13 = CursorUtil.getColumnIndexOrThrow(r2, "is_owner");     // Catch: Throwable -> L36
            int r14 = CursorUtil.getColumnIndexOrThrow(r2, "drive_obj_type");     // Catch: Throwable -> L36
            int r15 = CursorUtil.getColumnIndexOrThrow(r2, "extra");     // Catch: Throwable -> L36
            if (r2.moveToFirst() == true) goto L6;
        L34:
            r2.close();
            this.a.release();
            return r4;
        L6:
            if (r2.isNull(r0) == false) goto L8;
            String r16 = null;
        L10:
            if (r2.isNull(r3) == false) goto L12;
            String r17 = null;
        L13:
            int r18 = r2.getInt(r6);     // Catch: Throwable -> L36
            if (r2.isNull(r7) == false) goto L16;
            String r110 = null;
        L18:
            if (r2.isNull(r8) == false) goto L20;
            String r20 = null;
        L21:
            long r21 = r2.getLong(r9);     // Catch: Throwable -> L36
            long r23 = r2.getLong(r10);     // Catch: Throwable -> L36
            if (r2.isNull(r11) == false) goto L24;
            String r25 = null;
        L26:
            if (r2.isNull(r12) == false) goto L28;
            String r26 = null;
        L29:
            int r27 = r2.getInt(r13);     // Catch: Throwable -> L36
            int r28 = r2.getInt(r14);     // Catch: Throwable -> L36
            if (r2.isNull(r15) == true) goto L33;
            r5 = r2.getString(r15);     // Catch: Throwable -> L36
        L33:
            r4 = new l79.b(r16, r17, r18, r110, r20, r21, r23, r25, r26, r27, r28, r5);     // Catch: Throwable -> L36
            goto L34
        L28:
            r26 = r2.getString(r12);     // Catch: Throwable -> L36
            goto L29
        L24:
            r25 = r2.getString(r11);     // Catch: Throwable -> L36
            goto L26
        L20:
            r20 = r2.getString(r8);     // Catch: Throwable -> L36
            goto L21
        L16:
            r110 = r2.getString(r7);     // Catch: Throwable -> L36
            goto L18
        L12:
            r17 = r2.getString(r3);     // Catch: Throwable -> L36
            goto L13
        L8:
            r16 = r2.getString(r0);     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            r2.close();
            this.a.release();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ l79.b call() throws Exception {
            return call2();
        }

        public e(l r1, RoomSQLiteQuery r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public l(DriveDatabase r2) {
        this.a = r2;
        this.b = new i(r2);
        this.c = new j(r2);
        this.d = new k(r2);
    }

    @Override // l79.h
    public final Object a(Continuation<? super List<l79.b>> r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM drive_list_recent ORDER BY order_index ASC", 0);
        CancellationSignal r2 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.a, false, r2, new d(this, r0), r6);
    }

    @Override // l79.h
    public final Object d(Continuation<? super Integer> r4) {
        return CoroutinesRoom.execute(this.a, true, new b(this), r4);
    }

    @Override // l79.h
    public final Object b(String r4, Continuation<? super l79.b> r5) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM drive_list_recent WHERE file_token = ? LIMIT 1", 1);
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        CancellationSignal r6 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.a, false, r6, new e(this, r0), r5);
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // l79.h
    public final Object c(List<l79.b> r3, Continuation<? super Unit> r4) {
        return CoroutinesRoom.execute(this.a, true, new a(this, r3), r4);
    }

    @Override // l79.h
    public final Object e(String r3, Continuation<? super Integer> r4) {
        return CoroutinesRoom.execute(this.a, true, new c(this, r3), r4);
    }
}
