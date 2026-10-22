package com.larus.bmhome.chat.model.repo;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.larus.bmhome.chat.bean.ChatBot;
import com.larus.bmhome.chat.bean.ChatConversation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e0 implements a {
    public final RoomDatabase a;
    public final ChatBot.b b;
    public final ChatConversation.b c;
    public final v d;

    public final void clear() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.d.acquire();
        this.a.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        this.d.release(r0);
        return;
    L6:
        th = move-exception;
        this.a.endTransaction();
        this.d.release(r0);
        throw th;
    }

    public e0(ChatDatabase r2) {
        this.b = new ChatBot.b();
        this.c = new ChatConversation.b();
        this.a = r2;
        new l(this, r2);
        new w(r2);
        new x(r2);
        new y(r2);
        new z(r2);
        new a0(r2);
        new b0(r2);
        new c0(r2);
        new d0(r2);
        new b(r2);
        new c(r2);
        new d(r2);
        new e(r2);
        new f(r2);
        new g(r2);
        new h(r2);
        new i(r2);
        new j(r2);
        new k(r2);
        new m(r2);
        new n(r2);
        new o(r2);
        new p(r2);
        new q(r2);
        new r(r2);
        new s(r2);
        new t(r2);
        new u(r2);
        this.d = new v(r2);
    }
}
