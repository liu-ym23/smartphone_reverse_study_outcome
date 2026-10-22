package com.obric.miniapp.alarm;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c implements com.obric.miniapp.alarm.b {
    public final RoomDatabase a;
    public final com.obric.miniapp.alarm.d b;
    public final com.obric.miniapp.alarm.e c;
    public final com.obric.miniapp.alarm.f d;

    public class a implements Callable<w> {
        public final /* synthetic */ RoomSQLiteQuery a;
        public final /* synthetic */ c b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public w call() throws Exception {
            w r3 = null;
            Long r4 = null;
            Cursor r0 = DBUtil.query(this.b.a, this.a, false, null);
        L12:
            th = move-exception;
            r0.close();
            this.a.release();
            throw th;
        L4:
            if (r0.moveToFirst() == true) goto L6;
        L10:
            r0.close();
            this.a.release();
            return r3;
        L6:
            if (r0.isNull(0) == true) goto L9;
            r4 = Long.valueOf(r0.getLong(0));     // Catch: Throwable -> L12
        L9:
            r3 = s.d(r4);     // Catch: Throwable -> L12
            goto L10
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ w call() throws Exception {
            return call();
        }

        public a(c r1, RoomSQLiteQuery r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements Callable<com.obric.miniapp.alarm.a> {
        public final /* synthetic */ RoomSQLiteQuery a;
        public final /* synthetic */ c b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.obric.miniapp.alarm.a call() throws Exception {
            com.obric.miniapp.alarm.a r4 = null;
            String r5 = null;
            Cursor r2 = DBUtil.query(this.b.a, this.a, false, null);
            int r0 = CursorUtil.getColumnIndexOrThrow(r2, "id");     // Catch: Throwable -> L57
            int r6 = CursorUtil.getColumnIndexOrThrow(r2, "title");     // Catch: Throwable -> L57
            int r7 = CursorUtil.getColumnIndexOrThrow(r2, "content");     // Catch: Throwable -> L57
            int r8 = CursorUtil.getColumnIndexOrThrow(r2, "triggerTime");     // Catch: Throwable -> L57
            int r9 = CursorUtil.getColumnIndexOrThrow(r2, "intervalMinutes");     // Catch: Throwable -> L57
            int r10 = CursorUtil.getColumnIndexOrThrow(r2, "repeatCount");     // Catch: Throwable -> L57
            int r11 = CursorUtil.getColumnIndexOrThrow(r2, "currentRepeatCount");     // Catch: Throwable -> L57
            int r12 = CursorUtil.getColumnIndexOrThrow(r2, "isActive");     // Catch: Throwable -> L57
            int r13 = CursorUtil.getColumnIndexOrThrow(r2, "createdAt");     // Catch: Throwable -> L57
            int r14 = CursorUtil.getColumnIndexOrThrow(r2, "extraInfo");     // Catch: Throwable -> L57
            int r15 = CursorUtil.getColumnIndexOrThrow(r2, "useSystemClock");     // Catch: Throwable -> L57
            int r16 = CursorUtil.getColumnIndexOrThrow(r2, "token");     // Catch: Throwable -> L57
            if (r2.moveToFirst() == true) goto L6;
        L55:
            r2.close();
            this.a.release();
            return r4;
        L6:
            if (r2.isNull(r0) == false) goto L8;
            String r17 = null;
        L10:
            if (r2.isNull(r6) == false) goto L12;
            String r18 = null;
        L14:
            if (r2.isNull(r7) == false) goto L16;
            String r19 = null;
        L18:
            if (r2.isNull(r8) == false) goto L20;
            Long r1 = null;
        L21:
            w r20 = s.d(r1);     // Catch: Throwable -> L57
            if (r20 == null) goto L54;
            long r21 = r2.getLong(r9);     // Catch: Throwable -> L57
            int r23 = r2.getInt(r10);     // Catch: Throwable -> L57
            int r24 = r2.getInt(r11);     // Catch: Throwable -> L57
            if (r2.getInt(r12) == 0) goto L27;
            boolean r25 = true;
        L29:
            if (r2.isNull(r13) == false) goto L31;
            Long r22 = null;
        L32:
            w r26 = s.d(r22);     // Catch: Throwable -> L57
            if (r26 == null) goto L52;
            if (r2.isNull(r14) == false) goto L37;
            String r3 = null;
        L38:
            Map r27 = s.b(r3);     // Catch: Throwable -> L57
            if (r27 == null) goto L50;
            if (r2.getInt(r15) == 0) goto L43;
            boolean r28 = true;
        L45:
            if (r2.isNull(r16) == true) goto L48;
            r5 = r2.getString(r16);     // Catch: Throwable -> L57
        L48:
            r4 = new com.obric.miniapp.alarm.a(r17, r18, r19, r20, r21, r23, r24, r25, r26, r27, r28, r5);     // Catch: Throwable -> L57
            goto L55
        L43:
            r28 = false;
            goto L45
        L50:
            throw new IllegalStateException("Expected non-null java.util.Map<java.lang.String, java.lang.String>, but it was null.");     // Catch: Throwable -> L57
        L37:
            r3 = r2.getString(r14);     // Catch: Throwable -> L57
            goto L38
        L52:
            throw new IllegalStateException("Expected non-null com.obric.miniapp.alarm.Instant, but it was null.");     // Catch: Throwable -> L57
        L31:
            r22 = Long.valueOf(r2.getLong(r13));     // Catch: Throwable -> L57
            goto L32
        L27:
            r25 = false;
            goto L29
        L54:
            throw new IllegalStateException("Expected non-null com.obric.miniapp.alarm.Instant, but it was null.");     // Catch: Throwable -> L57
        L20:
            r1 = Long.valueOf(r2.getLong(r8));     // Catch: Throwable -> L57
            goto L21
        L16:
            r19 = r2.getString(r7);     // Catch: Throwable -> L57
            goto L18
        L12:
            r18 = r2.getString(r6);     // Catch: Throwable -> L57
            goto L14
        L8:
            r17 = r2.getString(r0);     // Catch: Throwable -> L57
        L57:
            th = move-exception;
            r2.close();
            this.a.release();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ com.obric.miniapp.alarm.a call() throws Exception {
            return call();
        }

        public b(c r1, RoomSQLiteQuery r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: com.obric.miniapp.alarm.c$c, reason: collision with other inner class name */
    public class CallableC0044c implements Callable<Long> {
        public final /* synthetic */ com.obric.miniapp.alarm.a a;
        public final /* synthetic */ c b;

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

        public CallableC0044c(c r1, com.obric.miniapp.alarm.a r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class d implements Callable<Integer> {
        public final /* synthetic */ w a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ c e;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            SupportSQLiteStatement r0 = this.e.c.acquire();
            int r1 = s.a;
            Long r2 = s.a(this.a);
            if (r2 != null) goto L5;
            r0.bindNull(1);
        L6:
            r0.bindLong(2, this.b);
            String r3 = this.c;
            if (r3 != null) goto L9;
            r0.bindNull(3);
        L10:
            String r4 = this.d;
            if (r4 != null) goto L13;
            r0.bindNull(4);
        L14:
            this.e.a.beginTransaction();
            Integer r5 = Integer.valueOf(r0.executeUpdateDelete());     // Catch: Throwable -> L18
            this.e.a.setTransactionSuccessful();     // Catch: Throwable -> L18
            this.e.a.endTransaction();
            this.e.c.release(r0);
            return r5;
        L18:
            th = move-exception;
            this.e.a.endTransaction();
            this.e.c.release(r0);
            throw th;
        L13:
            r0.bindString(4, r4);
            goto L14
        L9:
            r0.bindString(3, r3);
            goto L10
        L5:
            r0.bindLong(1, r2.longValue());
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Integer call() throws Exception {
            return call();
        }

        public d(c r1, w r2, int r3, String r4, String r5) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public class e implements Callable<Integer> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ c c;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            SupportSQLiteStatement r0 = this.c.d.acquire();
            String r1 = this.a;
            if (r1 != null) goto L5;
            r0.bindNull(1);
        L6:
            String r2 = this.b;
            if (r2 != null) goto L9;
            r0.bindNull(2);
        L10:
            this.c.a.beginTransaction();
            Integer r3 = Integer.valueOf(r0.executeUpdateDelete());     // Catch: Throwable -> L14
            this.c.a.setTransactionSuccessful();     // Catch: Throwable -> L14
            this.c.a.endTransaction();
            this.c.d.release(r0);
            return r3;
        L14:
            th = move-exception;
            this.c.a.endTransaction();
            this.c.d.release(r0);
            throw th;
        L9:
            r0.bindString(2, r2);
            goto L10
        L5:
            r0.bindString(1, r1);
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Integer call() throws Exception {
            return call();
        }

        public e(c r1, String r2, String r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class f implements Callable<List<com.obric.miniapp.alarm.a>> {
        public final /* synthetic */ RoomSQLiteQuery a;
        public final /* synthetic */ c b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<com.obric.miniapp.alarm.a> call2() throws Exception {
            Cursor r2 = DBUtil.query(this.b.a, this.a, false, null);
            int r0 = CursorUtil.getColumnIndexOrThrow(r2, "id");     // Catch: Throwable -> L58
            int r5 = CursorUtil.getColumnIndexOrThrow(r2, "title");     // Catch: Throwable -> L58
            int r6 = CursorUtil.getColumnIndexOrThrow(r2, "content");     // Catch: Throwable -> L58
            int r7 = CursorUtil.getColumnIndexOrThrow(r2, "triggerTime");     // Catch: Throwable -> L58
            int r8 = CursorUtil.getColumnIndexOrThrow(r2, "intervalMinutes");     // Catch: Throwable -> L58
            int r9 = CursorUtil.getColumnIndexOrThrow(r2, "repeatCount");     // Catch: Throwable -> L58
            int r10 = CursorUtil.getColumnIndexOrThrow(r2, "currentRepeatCount");     // Catch: Throwable -> L58
            int r11 = CursorUtil.getColumnIndexOrThrow(r2, "isActive");     // Catch: Throwable -> L58
            int r12 = CursorUtil.getColumnIndexOrThrow(r2, "createdAt");     // Catch: Throwable -> L58
            int r13 = CursorUtil.getColumnIndexOrThrow(r2, "extraInfo");     // Catch: Throwable -> L58
            int r14 = CursorUtil.getColumnIndexOrThrow(r2, "useSystemClock");     // Catch: Throwable -> L58
            int r15 = CursorUtil.getColumnIndexOrThrow(r2, "token");     // Catch: Throwable -> L58
            ArrayList r3 = new ArrayList(r2.getCount());     // Catch: Throwable -> L58
        L5:
            if (r2.moveToNext() == false) goto L56;
            if (r2.isNull(r0) == false) goto L9;
            String r17 = null;
        L11:
            if (r2.isNull(r5) == false) goto L13;
            String r18 = null;
        L15:
            if (r2.isNull(r6) == false) goto L17;
            String r19 = null;
        L19:
            if (r2.isNull(r7) == false) goto L21;
            Long r4 = null;
        L22:
            w r20 = s.d(r4);     // Catch: Throwable -> L58
            if (r20 == null) goto L55;
            long r21 = r2.getLong(r8);     // Catch: Throwable -> L58
            int r23 = r2.getInt(r9);     // Catch: Throwable -> L58
            int r24 = r2.getInt(r10);     // Catch: Throwable -> L58
            if (r2.getInt(r11) == 0) goto L28;
            boolean r26 = true;
        L30:
            if (r2.isNull(r12) == false) goto L32;
            Long r16 = null;
        L33:
            w r27 = s.d(r16);     // Catch: Throwable -> L58
            if (r27 == null) goto L53;
            if (r2.isNull(r13) == false) goto L38;
            String r22 = null;
        L39:
            Map r25 = s.b(r22);     // Catch: Throwable -> L58
            if (r25 == null) goto L51;
            if (r2.getInt(r14) == 0) goto L44;
            boolean r28 = true;
        L46:
            if (r2.isNull(r15) == false) goto L48;
            String r29 = null;
        L49:
            r3.add(new com.obric.miniapp.alarm.a(r17, r18, r19, r20, r21, r23, r24, r26, r27, r25, r28, r29));     // Catch: Throwable -> L58
            r0 = r0;
            goto L5
        L48:
            r29 = r2.getString(r15);     // Catch: Throwable -> L58
            goto L49
        L44:
            r28 = false;
            goto L46
        L51:
            throw new IllegalStateException("Expected non-null java.util.Map<java.lang.String, java.lang.String>, but it was null.");     // Catch: Throwable -> L58
        L38:
            r22 = r2.getString(r13);     // Catch: Throwable -> L58
            goto L39
        L53:
            throw new IllegalStateException("Expected non-null com.obric.miniapp.alarm.Instant, but it was null.");     // Catch: Throwable -> L58
        L32:
            r16 = Long.valueOf(r2.getLong(r12));     // Catch: Throwable -> L58
            goto L33
        L28:
            r26 = false;
            goto L30
        L55:
            throw new IllegalStateException("Expected non-null com.obric.miniapp.alarm.Instant, but it was null.");     // Catch: Throwable -> L58
        L21:
            r4 = Long.valueOf(r2.getLong(r7));     // Catch: Throwable -> L58
            goto L22
        L17:
            r19 = r2.getString(r6);     // Catch: Throwable -> L58
            goto L19
        L13:
            r18 = r2.getString(r5);     // Catch: Throwable -> L58
            goto L15
        L9:
            r17 = r2.getString(r0);     // Catch: Throwable -> L58
            goto L11
        L56:
            r2.close();
            this.a.release();
            return r3;
        L58:
            th = move-exception;
            r2.close();
            this.a.release();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<com.obric.miniapp.alarm.a> call() throws Exception {
            return call2();
        }

        public f(c r1, RoomSQLiteQuery r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class g implements Callable<List<String>> {
        public final /* synthetic */ RoomSQLiteQuery a;
        public final /* synthetic */ c b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<String> call2() throws Exception {
            Cursor r0 = DBUtil.query(this.b.a, this.a, false, null);
            ArrayList r1 = new ArrayList(r0.getCount());     // Catch: Throwable -> L14
        L4:
            if (r0.moveToNext() == false) goto L12;
            if (r0.isNull(0) == false) goto L9;
            String r4 = null;
        L10:
            r1.add(r4);     // Catch: Throwable -> L14
            goto L4
        L9:
            r4 = r0.getString(0);     // Catch: Throwable -> L14
            goto L10
        L12:
            r0.close();
            this.a.release();
            return r1;
        L14:
            th = move-exception;
            r0.close();
            this.a.release();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<String> call() throws Exception {
            return call2();
        }

        public g(c r1, RoomSQLiteQuery r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class h implements Callable<List<com.obric.miniapp.alarm.a>> {
        public final /* synthetic */ RoomSQLiteQuery a;
        public final /* synthetic */ c b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<com.obric.miniapp.alarm.a> call2() throws Exception {
            Cursor r2 = DBUtil.query(this.b.a, this.a, false, null);
            int r0 = CursorUtil.getColumnIndexOrThrow(r2, "id");     // Catch: Throwable -> L58
            int r5 = CursorUtil.getColumnIndexOrThrow(r2, "title");     // Catch: Throwable -> L58
            int r6 = CursorUtil.getColumnIndexOrThrow(r2, "content");     // Catch: Throwable -> L58
            int r7 = CursorUtil.getColumnIndexOrThrow(r2, "triggerTime");     // Catch: Throwable -> L58
            int r8 = CursorUtil.getColumnIndexOrThrow(r2, "intervalMinutes");     // Catch: Throwable -> L58
            int r9 = CursorUtil.getColumnIndexOrThrow(r2, "repeatCount");     // Catch: Throwable -> L58
            int r10 = CursorUtil.getColumnIndexOrThrow(r2, "currentRepeatCount");     // Catch: Throwable -> L58
            int r11 = CursorUtil.getColumnIndexOrThrow(r2, "isActive");     // Catch: Throwable -> L58
            int r12 = CursorUtil.getColumnIndexOrThrow(r2, "createdAt");     // Catch: Throwable -> L58
            int r13 = CursorUtil.getColumnIndexOrThrow(r2, "extraInfo");     // Catch: Throwable -> L58
            int r14 = CursorUtil.getColumnIndexOrThrow(r2, "useSystemClock");     // Catch: Throwable -> L58
            int r15 = CursorUtil.getColumnIndexOrThrow(r2, "token");     // Catch: Throwable -> L58
            ArrayList r3 = new ArrayList(r2.getCount());     // Catch: Throwable -> L58
        L5:
            if (r2.moveToNext() == false) goto L56;
            if (r2.isNull(r0) == false) goto L9;
            String r17 = null;
        L11:
            if (r2.isNull(r5) == false) goto L13;
            String r18 = null;
        L15:
            if (r2.isNull(r6) == false) goto L17;
            String r19 = null;
        L19:
            if (r2.isNull(r7) == false) goto L21;
            Long r4 = null;
        L22:
            w r20 = s.d(r4);     // Catch: Throwable -> L58
            if (r20 == null) goto L55;
            long r21 = r2.getLong(r8);     // Catch: Throwable -> L58
            int r23 = r2.getInt(r9);     // Catch: Throwable -> L58
            int r24 = r2.getInt(r10);     // Catch: Throwable -> L58
            if (r2.getInt(r11) == 0) goto L28;
            boolean r26 = true;
        L30:
            if (r2.isNull(r12) == false) goto L32;
            Long r16 = null;
        L33:
            w r27 = s.d(r16);     // Catch: Throwable -> L58
            if (r27 == null) goto L53;
            if (r2.isNull(r13) == false) goto L38;
            String r22 = null;
        L39:
            Map r25 = s.b(r22);     // Catch: Throwable -> L58
            if (r25 == null) goto L51;
            if (r2.getInt(r14) == 0) goto L44;
            boolean r28 = true;
        L46:
            if (r2.isNull(r15) == false) goto L48;
            String r29 = null;
        L49:
            r3.add(new com.obric.miniapp.alarm.a(r17, r18, r19, r20, r21, r23, r24, r26, r27, r25, r28, r29));     // Catch: Throwable -> L58
            r0 = r0;
            goto L5
        L48:
            r29 = r2.getString(r15);     // Catch: Throwable -> L58
            goto L49
        L44:
            r28 = false;
            goto L46
        L51:
            throw new IllegalStateException("Expected non-null java.util.Map<java.lang.String, java.lang.String>, but it was null.");     // Catch: Throwable -> L58
        L38:
            r22 = r2.getString(r13);     // Catch: Throwable -> L58
            goto L39
        L53:
            throw new IllegalStateException("Expected non-null com.obric.miniapp.alarm.Instant, but it was null.");     // Catch: Throwable -> L58
        L32:
            r16 = Long.valueOf(r2.getLong(r12));     // Catch: Throwable -> L58
            goto L33
        L28:
            r26 = false;
            goto L30
        L55:
            throw new IllegalStateException("Expected non-null com.obric.miniapp.alarm.Instant, but it was null.");     // Catch: Throwable -> L58
        L21:
            r4 = Long.valueOf(r2.getLong(r7));     // Catch: Throwable -> L58
            goto L22
        L17:
            r19 = r2.getString(r6);     // Catch: Throwable -> L58
            goto L19
        L13:
            r18 = r2.getString(r5);     // Catch: Throwable -> L58
            goto L15
        L9:
            r17 = r2.getString(r0);     // Catch: Throwable -> L58
            goto L11
        L56:
            r2.close();
            this.a.release();
            return r3;
        L58:
            th = move-exception;
            r2.close();
            this.a.release();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<com.obric.miniapp.alarm.a> call() throws Exception {
            return call2();
        }

        public h(c r1, RoomSQLiteQuery r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public c(AlarmDatabase r2) {
        this.a = r2;
        this.b = new com.obric.miniapp.alarm.d(r2);
        this.c = new com.obric.miniapp.alarm.e(r2);
        this.d = new com.obric.miniapp.alarm.f(r2);
    }

    @Override // com.obric.miniapp.alarm.b
    public final Object a(Continuation<? super List<com.obric.miniapp.alarm.a>> r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM alarm", 0);
        CancellationSignal r2 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.a, false, r2, new f(this, r0), r6);
    }

    @Override // com.obric.miniapp.alarm.b
    public final Object d(Continuation<? super List<String>> r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id FROM alarm", 0);
        CancellationSignal r2 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.a, false, r2, new g(this, r0), r6);
    }

    @Override // com.obric.miniapp.alarm.b
    public final Object e(Continuation<? super w> r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT triggerTime FROM alarm WHERE NOT useSystemClock ORDER BY triggerTime LIMIT 1", 0);
        CancellationSignal r2 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.a, false, r2, new a(this, r0), r6);
    }

    @Override // com.obric.miniapp.alarm.b
    public final Object b(w r5, Continuation<? super List<com.obric.miniapp.alarm.a>> r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM alarm WHERE triggerTime <= ? ORDER BY triggerTime", 1);
        Long r7 = s.a(r5);
        if (r7 != null) goto L5;
        r0.bindNull(1);
    L6:
        CancellationSignal r8 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.a, false, r8, new h(this, r0), r6);
    L5:
        r0.bindLong(1, r7.longValue());
        goto L6
    }

    @Override // com.obric.miniapp.alarm.b
    public final Object c(String r4, Continuation<? super com.obric.miniapp.alarm.a> r5) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM alarm WHERE id = ?", 1);
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        CancellationSignal r6 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.a, false, r6, new b(this, r0), r5);
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.miniapp.alarm.b
    public Object insert(com.obric.miniapp.alarm.a r3, Continuation<? super Long> r4) {
        return CoroutinesRoom.execute(this.a, true, new CallableC0044c(this, r3), r4);
    }

    @Override // com.obric.miniapp.alarm.b
    public Object delete(String r3, String r4, Continuation<? super Integer> r5) {
        return CoroutinesRoom.execute(this.a, true, new e(this, r3, r4), r5);
    }

    @Override // com.obric.miniapp.alarm.b
    public Object update(String r9, w r10, int r11, String r12, Continuation<? super Integer> r13) {
        return CoroutinesRoom.execute(this.a, true, new d(this, r10, r11, r9, r12), r13);
    }
}
