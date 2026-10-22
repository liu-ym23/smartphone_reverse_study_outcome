package com.bytedance.ai.applet.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.bytedance.android.ec.base.api.ai.conversation.ConversationConstants;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements com.bytedance.ai.applet.db.a {
    public final RoomDatabase a;
    public final com.bytedance.ai.applet.db.c b;
    public final com.bytedance.ai.applet.db.d c;
    public final com.bytedance.ai.applet.db.e d;
    public final f e;

    public class a implements Callable<Unit> {
        public final /* synthetic */ i a;
        public final /* synthetic */ b b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Unit call2() throws Exception {
            this.b.a.beginTransaction();
            this.b.d.handle(this.a);     // Catch: Throwable -> L6
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

        public a(b r1, i r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.applet.db.b$b, reason: collision with other inner class name */
    public class CallableC0017b implements Callable<Unit> {
        public final /* synthetic */ i a;
        public final /* synthetic */ b b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Unit call2() throws Exception {
            this.b.a.beginTransaction();
            this.b.e.handle(this.a);     // Catch: Throwable -> L6
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

        public CallableC0017b(b r1, i r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    public class c implements Callable<i> {
        public final /* synthetic */ RoomSQLiteQuery a;
        public final /* synthetic */ b b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public i call() throws Exception {
            i r10 = null;
            String r11 = null;
            Cursor r0 = DBUtil.query(this.b.a, this.a, false, null);
            int r1 = CursorUtil.getColumnIndexOrThrow(r0, "card_id");     // Catch: Throwable -> L25
            int r12 = CursorUtil.getColumnIndexOrThrow(r0, "message_id");     // Catch: Throwable -> L25
            int r13 = CursorUtil.getColumnIndexOrThrow(r0, ConversationConstants.KEY_CONVERSATION_ID);     // Catch: Throwable -> L25
            int r14 = CursorUtil.getColumnIndexOrThrow(r0, "bot_id");     // Catch: Throwable -> L25
            if (r0.moveToFirst() == true) goto L6;
        L23:
            r0.close();
            this.a.release();
            return r10;
        L6:
            if (r0.isNull(r1) == false) goto L8;
            String r15 = null;
        L10:
            if (r0.isNull(r12) == false) goto L12;
            String r16 = null;
        L14:
            if (r0.isNull(r13) == false) goto L16;
            String r17 = null;
        L18:
            if (r0.isNull(r14) == true) goto L21;
            r11 = r0.getString(r14);     // Catch: Throwable -> L25
        L21:
            r10 = new i(r15, r16, r17, r11);     // Catch: Throwable -> L25
            goto L23
        L16:
            r17 = r0.getString(r13);     // Catch: Throwable -> L25
            goto L18
        L12:
            r16 = r0.getString(r12);     // Catch: Throwable -> L25
            goto L14
        L8:
            r15 = r0.getString(r1);     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            r0.close();
            this.a.release();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ i call() throws Exception {
            return call();
        }

        public c(b r1, RoomSQLiteQuery r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    public class d implements Callable<Unit> {
        public final /* synthetic */ i a;
        public final /* synthetic */ b b;

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

        public d(b r1, i r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    public class e implements Callable<Long> {
        public final /* synthetic */ i a;
        public final /* synthetic */ b b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Long call() throws Exception {
            this.b.a.beginTransaction();
            long r0 = this.b.c.insertAndReturnId(this.a);     // Catch: Throwable -> L6
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

        public e(b r1, i r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    public b(WidgetContextDatabase r10) {
        this.a = r10;
        this.b = new com.bytedance.ai.applet.db.c(r10);
        this.c = new com.bytedance.ai.applet.db.d(r10);
        this.d = new com.bytedance.ai.applet.db.e(r10);
        this.e = new f(r10);
        new g(r10);
        new h(r10);
    }

    @Override // com.bytedance.ai.applet.db.a
    public final Object a(String r10, Continuation<? super i> r11) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM widget_context_info WHERE card_id = ? LIMIT 1", 1);
        if (r10 != null) goto L5;
        r0.bindNull(1);
    L6:
        CancellationSignal r12 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.a, false, r12, new c(this, r0), r11);
    L5:
        r0.bindString(1, r10);
        goto L6
    }

    @Override // com.bytedance.ai.applet.db.a
    public final Object b(i r10, Continuation<? super Long> r11) {
        return CoroutinesRoom.execute(this.a, true, new e(this, r10), r11);
    }

    @Override // com.bytedance.ai.applet.db.a
    public Object delete(i r10, Continuation<? super Unit> r11) {
        return CoroutinesRoom.execute(this.a, true, new a(this, r10), r11);
    }

    @Override // com.bytedance.ai.applet.db.a
    public Object insert(i r10, Continuation<? super Unit> r11) {
        return CoroutinesRoom.execute(this.a, true, new d(this, r10), r11);
    }

    @Override // com.bytedance.ai.applet.db.a
    public Object update(i r10, Continuation<? super Unit> r11) {
        return CoroutinesRoom.execute(this.a, true, new CallableC0017b(this, r10), r11);
    }
}
