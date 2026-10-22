package com.larus.avlink.gallery.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k implements j {
    public final RoomDatabase a;
    public final l b;
    public final m c;
    public final n d;

    public class a implements Callable<Integer> {
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;
        public final /* synthetic */ k c;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            StringBuilder r0 = StringUtil.newStringBuilder();
            r0.append("DELETE FROM thumbnail_metadata_table WHERE image_uuid IN (");
            int r1 = this.a.size();
            StringUtil.appendPlaceholders(r0, r1);
            r0.append(") AND sn = ");
            r0.append("?");
            String r2 = r0.toString();
            SupportSQLiteStatement r3 = this.c.a.compileStatement(r2);
            Iterator r4 = this.a.iterator();
            int r5 = 1;
        L4:
            if (r4.hasNext() == false) goto L6;
            r3.bindLong(r5, ((Long) r4.next()).longValue());
            r5 = r5 + 1;
            goto L4
        L6:
            int r6 = r1 + 1;
            String r7 = this.b;
            if (r7 != null) goto L9;
            r3.bindNull(r6);
        L10:
            this.c.a.beginTransaction();
            Integer r8 = Integer.valueOf(r3.executeUpdateDelete());     // Catch: Throwable -> L14
            this.c.a.setTransactionSuccessful();     // Catch: Throwable -> L14
            this.c.a.endTransaction();
            return r8;
        L14:
            th = move-exception;
            this.c.a.endTransaction();
            throw th;
        L9:
            r3.bindString(r6, r7);
            goto L10
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Integer call() throws Exception {
            return call();
        }

        public a(k r1, List r2, String r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class b implements Callable<Long> {
        public final /* synthetic */ i a;
        public final /* synthetic */ k b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Long call() throws Exception {
            this.b.a.beginTransaction();
            long r0 = this.b.b.insertAndReturnId(this.a);     // Catch: Throwable -> L6
            this.b.a.setTransactionSuccessful();     // Catch: Throwable -> L6
            Long r1 = Long.valueOf(r0);     // Catch: Throwable -> L6
            this.b.a.endTransaction();
            return r1;
        L6:
            th = move-exception;
            this.b.a.endTransaction();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Long call() throws Exception {
            return call();
        }

        public b(k r1, i r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class c implements Callable<Integer> {
        public final /* synthetic */ i a;
        public final /* synthetic */ k b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            this.b.a.beginTransaction();
            int r0 = this.b.c.handle(this.a) + 0;     // Catch: Throwable -> L6
            this.b.a.setTransactionSuccessful();     // Catch: Throwable -> L6
            Integer r1 = Integer.valueOf(r0);     // Catch: Throwable -> L6
            this.b.a.endTransaction();
            return r1;
        L6:
            th = move-exception;
            this.b.a.endTransaction();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Integer call() throws Exception {
            return call();
        }

        public c(k r1, i r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class d implements Callable<Integer> {
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;
        public final /* synthetic */ k c;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            SupportSQLiteStatement r0 = this.c.d.acquire();
            r0.bindLong(1, this.a);
            String r1 = this.b;
            if (r1 != null) goto L5;
            r0.bindNull(2);
        L6:
            this.c.a.beginTransaction();
            Integer r2 = Integer.valueOf(r0.executeUpdateDelete());     // Catch: Throwable -> L10
            this.c.a.setTransactionSuccessful();     // Catch: Throwable -> L10
            this.c.a.endTransaction();
            this.c.d.release(r0);
            return r2;
        L10:
            th = move-exception;
            this.c.a.endTransaction();
            this.c.d.release(r0);
            throw th;
        L5:
            r0.bindString(2, r1);
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Integer call() throws Exception {
            return call();
        }

        public d(k r1, long r2, String r4) {
            this.c = r1;
            this.a = r2;
            this.b = r4;
        }
    }

    public class e implements Callable<List<i>> {
        public final /* synthetic */ RoomSQLiteQuery a;
        public final /* synthetic */ k b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<i> call2() throws Exception {
            Cursor r2 = DBUtil.query(this.b.a, this.a, false, null);
            int r0 = CursorUtil.getColumnIndexOrThrow(r2, "id");     // Catch: Throwable -> L47
            int r5 = CursorUtil.getColumnIndexOrThrow(r2, "file_path");     // Catch: Throwable -> L47
            int r6 = CursorUtil.getColumnIndexOrThrow(r2, "file_name");     // Catch: Throwable -> L47
            int r7 = CursorUtil.getColumnIndexOrThrow(r2, "file_size");     // Catch: Throwable -> L47
            int r8 = CursorUtil.getColumnIndexOrThrow(r2, "sn");     // Catch: Throwable -> L47
            int r9 = CursorUtil.getColumnIndexOrThrow(r2, "image_uuid");     // Catch: Throwable -> L47
            int r10 = CursorUtil.getColumnIndexOrThrow(r2, "media_type");     // Catch: Throwable -> L47
            int r11 = CursorUtil.getColumnIndexOrThrow(r2, "width");     // Catch: Throwable -> L47
            int r12 = CursorUtil.getColumnIndexOrThrow(r2, "height");     // Catch: Throwable -> L47
            int r13 = CursorUtil.getColumnIndexOrThrow(r2, "duration");     // Catch: Throwable -> L47
            int r14 = CursorUtil.getColumnIndexOrThrow(r2, "create_time");     // Catch: Throwable -> L47
            int r15 = CursorUtil.getColumnIndexOrThrow(r2, "modify_time");     // Catch: Throwable -> L47
            int r3 = CursorUtil.getColumnIndexOrThrow(r2, "download_time");     // Catch: Throwable -> L47
            int r4 = CursorUtil.getColumnIndexOrThrow(r2, "geo_location_info");     // Catch: Throwable -> L47
            int r16 = CursorUtil.getColumnIndexOrThrow(r2, "source_type");     // Catch: Throwable -> L45
            int r17 = CursorUtil.getColumnIndexOrThrow(r2, "processing_status");     // Catch: Throwable -> L45
            int r18 = CursorUtil.getColumnIndexOrThrow(r2, "is_synced");     // Catch: Throwable -> L45
            int r19 = r4;
            ArrayList r1 = new ArrayList(r2.getCount());     // Catch: Throwable -> L45
        L5:
            if (r2.moveToNext() == false) goto L43;
            if (r2.isNull(r0) == false) goto L10;
            String r21 = null;
        L12:
            if (r2.isNull(r5) == false) goto L14;
            String r22 = null;
        L16:
            if (r2.isNull(r6) == false) goto L18;
            String r23 = null;
        L19:
            long r24 = r2.getLong(r7);     // Catch: Throwable -> L45
            if (r2.isNull(r8) == false) goto L22;
            String r26 = null;
        L23:
            long r27 = r2.getLong(r9);     // Catch: Throwable -> L45
            if (r2.isNull(r10) == false) goto L26;
            String r29 = null;
        L27:
            int r30 = r2.getInt(r11);     // Catch: Throwable -> L45
            int r31 = r2.getInt(r12);     // Catch: Throwable -> L45
            long r32 = r2.getLong(r13);     // Catch: Throwable -> L45
            long r34 = r2.getLong(r14);     // Catch: Throwable -> L45
            long r36 = r2.getLong(r15);     // Catch: Throwable -> L45
            long r38 = r2.getLong(r3);     // Catch: Throwable -> L45
            int r20 = r19;
            if (r2.isNull(r20) == false) goto L31;
            String r40 = null;
        L30:
            int r44 = r16;
            int r110 = r0;
            if (r2.isNull(r44) == false) goto L36;
            String r41 = null;
        L35:
            int r45 = r17;
            int r42 = r2.getInt(r45);     // Catch: Throwable -> L45
            r18 = r18;
            if (r2.getInt(r18) == 0) goto L40;
            boolean r43 = true;
        L41:
            r1.add(new i(r21, r22, r23, r24, r26, r27, r29, r30, r31, r32, r34, r36, r38, r40, r41, r42, r43));     // Catch: Throwable -> L45
            r0 = r110;
            r16 = r44;
            r17 = r45;
            r19 = r20;
            goto L5
        L40:
            r43 = false;
            goto L41
        L36:
            r41 = r2.getString(r44);     // Catch: Throwable -> L45
            goto L35
        L31:
            r40 = r2.getString(r20);     // Catch: Throwable -> L45
            goto L30
        L26:
            r29 = r2.getString(r10);     // Catch: Throwable -> L45
            goto L27
        L22:
            r26 = r2.getString(r8);     // Catch: Throwable -> L45
            goto L23
        L18:
            r23 = r2.getString(r6);     // Catch: Throwable -> L45
            goto L19
        L14:
            r22 = r2.getString(r5);     // Catch: Throwable -> L45
            goto L16
        L10:
            r21 = r2.getString(r0);     // Catch: Throwable -> L45
            goto L12
        L43:
            r2.close();
            this.a.release();
            return r1;
        L45:
            th = th;
            e r25 = this;
        L49:
            r2.close();
            r25.a.release();
            throw th;
        L47:
            th = th;
            r25 = this;
            goto L49
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<i> call() throws Exception {
            return call2();
        }

        public e(k r1, RoomSQLiteQuery r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class f implements Callable<List<i>> {
        public final /* synthetic */ RoomSQLiteQuery a;
        public final /* synthetic */ k b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<i> call2() throws Exception {
            Cursor r2 = DBUtil.query(this.b.a, this.a, false, null);
            int r0 = CursorUtil.getColumnIndexOrThrow(r2, "id");     // Catch: Throwable -> L47
            int r5 = CursorUtil.getColumnIndexOrThrow(r2, "file_path");     // Catch: Throwable -> L47
            int r6 = CursorUtil.getColumnIndexOrThrow(r2, "file_name");     // Catch: Throwable -> L47
            int r7 = CursorUtil.getColumnIndexOrThrow(r2, "file_size");     // Catch: Throwable -> L47
            int r8 = CursorUtil.getColumnIndexOrThrow(r2, "sn");     // Catch: Throwable -> L47
            int r9 = CursorUtil.getColumnIndexOrThrow(r2, "image_uuid");     // Catch: Throwable -> L47
            int r10 = CursorUtil.getColumnIndexOrThrow(r2, "media_type");     // Catch: Throwable -> L47
            int r11 = CursorUtil.getColumnIndexOrThrow(r2, "width");     // Catch: Throwable -> L47
            int r12 = CursorUtil.getColumnIndexOrThrow(r2, "height");     // Catch: Throwable -> L47
            int r13 = CursorUtil.getColumnIndexOrThrow(r2, "duration");     // Catch: Throwable -> L47
            int r14 = CursorUtil.getColumnIndexOrThrow(r2, "create_time");     // Catch: Throwable -> L47
            int r15 = CursorUtil.getColumnIndexOrThrow(r2, "modify_time");     // Catch: Throwable -> L47
            int r3 = CursorUtil.getColumnIndexOrThrow(r2, "download_time");     // Catch: Throwable -> L47
            int r4 = CursorUtil.getColumnIndexOrThrow(r2, "geo_location_info");     // Catch: Throwable -> L47
            int r16 = CursorUtil.getColumnIndexOrThrow(r2, "source_type");     // Catch: Throwable -> L45
            int r17 = CursorUtil.getColumnIndexOrThrow(r2, "processing_status");     // Catch: Throwable -> L45
            int r18 = CursorUtil.getColumnIndexOrThrow(r2, "is_synced");     // Catch: Throwable -> L45
            int r19 = r4;
            ArrayList r1 = new ArrayList(r2.getCount());     // Catch: Throwable -> L45
        L5:
            if (r2.moveToNext() == false) goto L43;
            if (r2.isNull(r0) == false) goto L10;
            String r21 = null;
        L12:
            if (r2.isNull(r5) == false) goto L14;
            String r22 = null;
        L16:
            if (r2.isNull(r6) == false) goto L18;
            String r23 = null;
        L19:
            long r24 = r2.getLong(r7);     // Catch: Throwable -> L45
            if (r2.isNull(r8) == false) goto L22;
            String r26 = null;
        L23:
            long r27 = r2.getLong(r9);     // Catch: Throwable -> L45
            if (r2.isNull(r10) == false) goto L26;
            String r29 = null;
        L27:
            int r30 = r2.getInt(r11);     // Catch: Throwable -> L45
            int r31 = r2.getInt(r12);     // Catch: Throwable -> L45
            long r32 = r2.getLong(r13);     // Catch: Throwable -> L45
            long r34 = r2.getLong(r14);     // Catch: Throwable -> L45
            long r36 = r2.getLong(r15);     // Catch: Throwable -> L45
            long r38 = r2.getLong(r3);     // Catch: Throwable -> L45
            int r20 = r19;
            if (r2.isNull(r20) == false) goto L31;
            String r40 = null;
        L30:
            int r44 = r16;
            int r110 = r0;
            if (r2.isNull(r44) == false) goto L36;
            String r41 = null;
        L35:
            int r45 = r17;
            int r42 = r2.getInt(r45);     // Catch: Throwable -> L45
            r18 = r18;
            if (r2.getInt(r18) == 0) goto L40;
            boolean r43 = true;
        L41:
            r1.add(new i(r21, r22, r23, r24, r26, r27, r29, r30, r31, r32, r34, r36, r38, r40, r41, r42, r43));     // Catch: Throwable -> L45
            r0 = r110;
            r16 = r44;
            r17 = r45;
            r19 = r20;
            goto L5
        L40:
            r43 = false;
            goto L41
        L36:
            r41 = r2.getString(r44);     // Catch: Throwable -> L45
            goto L35
        L31:
            r40 = r2.getString(r20);     // Catch: Throwable -> L45
            goto L30
        L26:
            r29 = r2.getString(r10);     // Catch: Throwable -> L45
            goto L27
        L22:
            r26 = r2.getString(r8);     // Catch: Throwable -> L45
            goto L23
        L18:
            r23 = r2.getString(r6);     // Catch: Throwable -> L45
            goto L19
        L14:
            r22 = r2.getString(r5);     // Catch: Throwable -> L45
            goto L16
        L10:
            r21 = r2.getString(r0);     // Catch: Throwable -> L45
            goto L12
        L43:
            r2.close();
            this.a.release();
            return r1;
        L45:
            th = th;
            f r25 = this;
        L49:
            r2.close();
            r25.a.release();
            throw th;
        L47:
            th = th;
            r25 = this;
            goto L49
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<i> call() throws Exception {
            return call2();
        }

        public f(k r1, RoomSQLiteQuery r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public k(AlbumDatabase r2) {
        this.a = r2;
        this.b = new l(r2);
        this.c = new m(r2);
        this.d = new n(r2);
    }

    @Override // com.larus.avlink.gallery.database.j
    public final Object f(Continuation<? super List<i>> r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM thumbnail_metadata_table ORDER BY create_time DESC", 0);
        CancellationSignal r2 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.a, false, r2, new e(this, r0), r6);
    }

    @Override // com.larus.avlink.gallery.database.j
    public final Object e(i r3, Continuation<? super Long> r4) {
        return CoroutinesRoom.execute(this.a, true, new b(this, r3), r4);
    }

    @Override // com.larus.avlink.gallery.database.j
    public final Object g(i r3, Continuation<? super Integer> r4) {
        return CoroutinesRoom.execute(this.a, true, new c(this, r3), r4);
    }

    @Override // com.larus.avlink.gallery.database.j
    public final Object a(long r3, String r5, Continuation<? super Integer> r6) {
        return CoroutinesRoom.execute(this.a, true, new d(this, r3, r5), r6);
    }

    @Override // com.larus.avlink.gallery.database.j
    public final Object b(long r4, String r6, ContinuationImpl r7) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM thumbnail_metadata_table WHERE image_uuid = ? AND sn = ? LIMIT 1", 2);
        r0.bindLong(1, r4);
        if (r6 != null) goto L5;
        r0.bindNull(2);
    L6:
        CancellationSignal r5 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.a, false, r5, new o(this, r0), r7);
    L5:
        r0.bindString(2, r6);
        goto L6
    }

    @Override // com.larus.avlink.gallery.database.j
    public final Object c(List<Long> r3, String r4, Continuation<? super Integer> r5) {
        return CoroutinesRoom.execute(this.a, true, new a(this, r3, r4), r5);
    }

    @Override // com.larus.avlink.gallery.database.j
    public final Object d(List<Long> r7, String r8, Continuation<? super List<i>> r9) {
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT * FROM thumbnail_metadata_table WHERE image_uuid IN (");
        int r1 = r7.size();
        StringUtil.appendPlaceholders(r0, r1);
        r0.append(") AND sn = ");
        r0.append("?");
        int r2 = r1 + 1;
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire(r0.toString(), r2);
        Iterator<Long> r10 = r7.iterator();
        int r4 = 1;
    L4:
        if (r10.hasNext() == false) goto L6;
        r3.bindLong(r4, r10.next().longValue());
        r4 = r4 + 1;
        goto L4
    L6:
        if (r8 != null) goto L8;
        r3.bindNull(r2);
    L9:
        CancellationSignal r11 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.a, false, r11, new f(this, r3), r9);
    L8:
        r3.bindString(r2, r8);
        goto L9
    }
}
