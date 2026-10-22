package com.larus.bmhome.chat.model.repo;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.network.http.HttpExtKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k0 implements j0 {
    public final RoomDatabase a;
    public final ic8.i.b b;
    public final b0 c;

    public class a extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE `chat_message` SET `update_time` = ? WHERE `message_id` = ?";
        }

        public a(RoomDatabase r1) {
            super(r1);
        }
    }

    public class a0 extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_message`\n        SET `feedback` = ?\n        WHERE `message_id` = ?\n    ";
        }

        public a0(RoomDatabase r1) {
            super(r1);
        }
    }

    public class b extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE `chat_message` SET `time` = ? WHERE `message_id` = ?";
        }

        public b(RoomDatabase r1) {
            super(r1);
        }
    }

    public class b0 extends SharedSQLiteStatement {
        public final String createQuery() {
            return "DELETE FROM `chat_message`";
        }

        public b0(RoomDatabase r1) {
            super(r1);
        }
    }

    public class c extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE `chat_message` SET `type` = ? WHERE `message_id` = ?";
        }

        public c(RoomDatabase r1) {
            super(r1);
        }
    }

    public class c0 extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE `chat_message` SET `message_id` = ? WHERE `message_id` = ?";
        }

        public c0(RoomDatabase r1) {
            super(r1);
        }
    }

    public class d extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE `chat_message` SET `sender` = ? WHERE `message_id` = ?";
        }

        public d(RoomDatabase r1) {
            super(r1);
        }
    }

    public class d0 extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE `chat_message` SET `conversation_id` = ? WHERE `conversation_id` = ?";
        }

        public d0(RoomDatabase r1) {
            super(r1);
        }
    }

    public class e extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE `chat_message` SET `extras` = ? WHERE `message_id` = ?";
        }

        public e(RoomDatabase r1) {
            super(r1);
        }
    }

    public class e0 extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE `chat_message` SET `reply_for` = ? WHERE `message_id` = ?";
        }

        public e0(RoomDatabase r1) {
            super(r1);
        }
    }

    public class f extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE `chat_message` SET `msg_brief` = ? WHERE `message_id` = ?";
        }

        public f(RoomDatabase r1) {
            super(r1);
        }
    }

    public class f0 extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE `chat_message` SET `status` = ? WHERE `message_id` = ?";
        }

        public f0(RoomDatabase r1) {
            super(r1);
        }
    }

    public class g extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE `chat_message` SET `meta_info` = ? WHERE `message_id` = ?";
        }

        public g(RoomDatabase r1) {
            super(r1);
        }
    }

    public class g0 extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE `chat_message` SET `index` = ? WHERE `message_id` = ?";
        }

        public g0(RoomDatabase r1) {
            super(r1);
        }
    }

    public class h extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE `chat_message` SET `content` = ? WHERE `message_id` = ?";
        }

        public h(RoomDatabase r1) {
            super(r1);
        }
    }

    public class h0 extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE `chat_message` SET `intention_msg` = ? WHERE `message_id` = ?";
        }

        public h0(RoomDatabase r1) {
            super(r1);
        }
    }

    public class i extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE `chat_message` SET `tts_content` = ? WHERE `message_id` = ?";
        }

        public i(RoomDatabase r1) {
            super(r1);
        }
    }

    public class i0 extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE `chat_message` SET `section_id` = ? WHERE `message_id` = ?";
        }

        public i0(RoomDatabase r1) {
            super(r1);
        }
    }

    public class j extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE `chat_message` SET `prompt_content` = ? WHERE `message_id` = ?";
        }

        public j(RoomDatabase r1) {
            super(r1);
        }
    }

    public class k extends EntityInsertionAdapter<ic8.i> {
        public final /* synthetic */ k0 a;

        public final String createQuery() {
            return "INSERT OR REPLACE INTO `chat_message` (`id`,`message_id`,`time`,`update_time`,`type`,`status`,`index`,`sender`,`conversation_id`,`local_conversation_id`,`source_conversation_id`,`bot_id`,`source_start_index`,`source_end_index`,`section_id`,`reply_for`,`content`,`tts_content`,`extras`,`feedback`,`on_boarding`,`msg_brief`,`meta_info`,`is_connect_caller_name`,`intention_msg`,`reference_info`,`prompt_content`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        public k(k0 r1, RoomDatabase r2) {
            this.a = r1;
            super(r2);
        }

        public final void bind(SupportSQLiteStatement r5, Object r6) {
            ic8.i r7 = (ic8.i) r6;
            Long r0 = r7.a;
            if (r0 != null) goto L5;
            r5.bindNull(1);
        L6:
            String r1 = r7.b;
            if (r1 != null) goto L9;
            r5.bindNull(2);
        L10:
            r5.bindLong(3, r7.c);
            Long r2 = r7.d;
            if (r2 != null) goto L13;
            r5.bindNull(4);
        L15:
            if (r7.getType() != null) goto L17;
            r5.bindNull(5);
        L18:
            r5.bindLong(6, r7.f);
            Integer r3 = r7.g;
            if (r3 != null) goto L21;
            r5.bindNull(7);
        L22:
            String r4 = r7.h;
            if (r4 != null) goto L25;
            r5.bindNull(8);
        L26:
            String r8 = r7.i;
            if (r8 != null) goto L29;
            r5.bindNull(9);
        L30:
            String r9 = r7.j;
            if (r9 != null) goto L33;
            r5.bindNull(10);
        L34:
            String r10 = r7.k;
            if (r10 != null) goto L37;
            r5.bindNull(11);
        L38:
            String r11 = r7.l;
            if (r11 != null) goto L41;
            r5.bindNull(12);
        L42:
            Integer r12 = r7.m;
            if (r12 != null) goto L45;
            r5.bindNull(13);
        L46:
            Integer r13 = r7.n;
            if (r13 != null) goto L49;
            r5.bindNull(14);
        L50:
            String r14 = r7.o;
            if (r14 != null) goto L53;
            r5.bindNull(15);
        L54:
            String r15 = r7.p;
            if (r15 != null) goto L57;
            r5.bindNull(16);
        L58:
            String r16 = r7.q;
            if (r16 != null) goto L61;
            r5.bindNull(17);
        L62:
            String r17 = r7.r;
            if (r17 != null) goto L65;
            r5.bindNull(18);
        L66:
            String r18 = r7.s;
            if (r18 != null) goto L69;
            r5.bindNull(19);
        L70:
            Integer r19 = r7.t;
            if (r19 != null) goto L73;
            r5.bindNull(20);
        L74:
            Integer r20 = r7.u;
            if (r20 != null) goto L77;
            r5.bindNull(21);
        L78:
            String r21 = r7.v;
            if (r21 != null) goto L81;
            r5.bindNull(22);
        L82:
            String r22 = r7.w;
            if (r22 != null) goto L85;
            r5.bindNull(23);
        L86:
            Integer r23 = r7.x;
            if (r23 != null) goto L89;
            r5.bindNull(24);
        L90:
            ic8.i.b r24 = this.a.b;
            ic8.b0 r25 = r7.y;
            r24.getClass();
            if (r25 == null) goto L93;
            String r26 = GsonProtectorUtils.toJson(HttpExtKt.f, r25);
        L95:
            if (r26 != null) goto L97;
            r5.bindNull(25);
        L98:
            String r27 = r7.z;
            if (r27 != null) goto L101;
            r5.bindNull(26);
        L102:
            String r28 = r7.A;
            if (r28 != null) goto L105;
            r5.bindNull(27);
            return;
        L105:
            r5.bindString(27, r28);
            return;
        L101:
            r5.bindString(26, r27);
            goto L102
        L97:
            r5.bindString(25, r26);
            goto L98
        L93:
            r26 = null;
            goto L95
        L89:
            r5.bindLong(24, r23.intValue());
            goto L90
        L85:
            r5.bindString(23, r22);
            goto L86
        L81:
            r5.bindString(22, r21);
            goto L82
        L77:
            r5.bindLong(21, r20.intValue());
            goto L78
        L73:
            r5.bindLong(20, r19.intValue());
            goto L74
        L69:
            r5.bindString(19, r18);
            goto L70
        L65:
            r5.bindString(18, r17);
            goto L66
        L61:
            r5.bindString(17, r16);
            goto L62
        L57:
            r5.bindString(16, r15);
            goto L58
        L53:
            r5.bindString(15, r14);
            goto L54
        L49:
            r5.bindLong(14, r13.intValue());
            goto L50
        L45:
            r5.bindLong(13, r12.intValue());
            goto L46
        L41:
            r5.bindString(12, r11);
            goto L42
        L37:
            r5.bindString(11, r10);
            goto L38
        L33:
            r5.bindString(10, r9);
            goto L34
        L29:
            r5.bindString(9, r8);
            goto L30
        L25:
            r5.bindString(8, r4);
            goto L26
        L21:
            r5.bindLong(7, r3.intValue());
            goto L22
        L17:
            r5.bindString(5, r7.getType());
            goto L18
        L13:
            r5.bindLong(4, r2.longValue());
            goto L15
        L9:
            r5.bindString(2, r1);
            goto L10
        L5:
            r5.bindLong(1, r0.longValue());
            goto L6
        }
    }

    public class l extends SharedSQLiteStatement {
        public final String createQuery() {
            return "DELETE FROM `chat_message` WHERE `message_id` = ?";
        }

        public l(RoomDatabase r1) {
            super(r1);
        }
    }

    public class m extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        DELETE FROM `chat_message`\n        WHERE `conversation_id` = ? \n        AND `index` >= ?\n        AND `index` < ?\n    ";
        }

        public m(RoomDatabase r1) {
            super(r1);
        }
    }

    public class n extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        DELETE FROM `chat_message`\n        WHERE `conversation_id` = ? \n        AND `on_boarding` = 1\n    ";
        }

        public n(RoomDatabase r1) {
            super(r1);
        }
    }

    public class o extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE `chat_message` SET `status` = ? WHERE `message_id` = ?";
        }

        public o(RoomDatabase r1) {
            super(r1);
        }
    }

    public class p extends SharedSQLiteStatement {
        public final String createQuery() {
            return "DELETE FROM `chat_message` WHERE `reply_for` = ?";
        }

        public p(RoomDatabase r1) {
            super(r1);
        }
    }

    public class q extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE `chat_message` SET `status` = ? WHERE `reply_for` = ?";
        }

        public q(RoomDatabase r1) {
            super(r1);
        }
    }

    public class r extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        DELETE FROM `chat_message`\n        WHERE `type` = ?\n        AND `conversation_id` = ?\n    ";
        }

        public r(RoomDatabase r1) {
            super(r1);
        }
    }

    public class s extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_message`\n        SET `status` = ?\n        WHERE `type` = ?\n        AND `conversation_id` = ?\n    ";
        }

        public s(RoomDatabase r1) {
            super(r1);
        }
    }

    public class t extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE chat_message SET status = ? WHERE `type` = ? AND `conversation_id` = ? AND `index` = ?";
        }

        public t(RoomDatabase r1) {
            super(r1);
        }
    }

    public class u extends SharedSQLiteStatement {
        public final String createQuery() {
            return "DELETE FROM `chat_message` WHERE `type` = ?";
        }

        public u(RoomDatabase r1) {
            super(r1);
        }
    }

    public class v extends EntityDeletionOrUpdateAdapter<ic8.i> {
        public final String createQuery() {
            return "DELETE FROM `chat_message` WHERE `id` = ?";
        }

        public v(RoomDatabase r1) {
            super(r1);
        }

        public final void bind(SupportSQLiteStatement r4, Object r5) {
            Long r6 = ((ic8.i) r5).a;
            if (r6 != null) goto L5;
            r4.bindNull(1);
            return;
        L5:
            r4.bindLong(1, r6.longValue());
        }
    }

    public class w extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_message`\n        SET `status` = ?\n        WHERE `type` = ?\n    ";
        }

        public w(RoomDatabase r1) {
            super(r1);
        }
    }

    public class x extends SharedSQLiteStatement {
        public final String createQuery() {
            return "DELETE FROM `chat_message` WHERE `conversation_id` = ? AND `message_id` LIKE '%local-cvs%'";
        }

        public x(RoomDatabase r1) {
            super(r1);
        }
    }

    public class y extends SharedSQLiteStatement {
        public final String createQuery() {
            return "DELETE FROM `chat_message` WHERE `conversation_id` = ? AND `message_id` LIKE '%-local-msg%'";
        }

        public y(RoomDatabase r1) {
            super(r1);
        }
    }

    public class z extends SharedSQLiteStatement {
        public final String createQuery() {
            return "DELETE FROM `chat_message` WHERE `conversation_id` = ?";
        }

        public z(RoomDatabase r1) {
            super(r1);
        }
    }

    public final void clear() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.c.acquire();
        this.a.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        this.c.release(r0);
        return;
    L6:
        th = move-exception;
        this.a.endTransaction();
        this.c.release(r0);
        throw th;
    }

    public k0(RoomDatabase r2) {
        this.b = new ic8.i.b();
        this.a = r2;
        new k(this, r2);
        new v(r2);
        new c0(r2);
        new d0(r2);
        new e0(r2);
        new f0(r2);
        new g0(r2);
        new h0(r2);
        new i0(r2);
        new a(r2);
        new b(r2);
        new c(r2);
        new d(r2);
        new e(r2);
        new f(r2);
        new g(r2);
        new h(r2);
        new i(r2);
        new j(r2);
        new l(r2);
        new m(r2);
        new n(r2);
        new o(r2);
        new p(r2);
        new q(r2);
        new r(r2);
        new s(r2);
        new t(r2);
        new u(r2);
        new w(r2);
        new x(r2);
        new y(r2);
        new z(r2);
        new a0(r2);
        this.c = new b0(r2);
    }
}
