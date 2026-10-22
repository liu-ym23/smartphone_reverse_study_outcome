package com.larus.bmhome.chat.model.repo;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.larus.bmhome.chat.bean.ChatBot;
import com.larus.bmhome.chat.bean.ChatConversation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k1 implements j1 {
    public final RoomDatabase a;
    public final ChatConversation.b b;
    public final ChatBot.b c;
    public final y d;

    public class a extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `member_list` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public a(RoomDatabase r1) {
            super(r1);
        }
    }

    public class a0 extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `priority` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public a0(RoomDatabase r1) {
            super(r1);
        }
    }

    public class b extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `tags` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public b(RoomDatabase r1) {
            super(r1);
        }
    }

    public class b0 extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `status` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public b0(RoomDatabase r1) {
            super(r1);
        }
    }

    public class c extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `last_section` = ?\n        WHERE `conversation_id` = ?\n        AND `last_section` != ?\n    ";
        }

        public c(RoomDatabase r1) {
            super(r1);
        }
    }

    public class c0 extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `name` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public c0(RoomDatabase r1) {
            super(r1);
        }
    }

    public class d extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `config` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public d(RoomDatabase r1) {
            super(r1);
        }
    }

    public class d0 extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `owner` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public d0(RoomDatabase r1) {
            super(r1);
        }
    }

    public class e extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `prefer` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public e(RoomDatabase r1) {
            super(r1);
        }
    }

    public class e0 extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `avatar` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public e0(RoomDatabase r1) {
            super(r1);
        }
    }

    public class f extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `last_message_index` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public f(RoomDatabase r1) {
            super(r1);
        }
    }

    public class f0 extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `templates` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public f0(RoomDatabase r1) {
            super(r1);
        }
    }

    public class g extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `last_message_index` = ?\n        WHERE `conversation_id` = ? AND `last_message_index` = ?\n    ";
        }

        public g(RoomDatabase r1) {
            super(r1);
        }
    }

    public class h extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `last_message_id` = ?, `last_message_time` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public h(RoomDatabase r1) {
            super(r1);
        }
    }

    public class i extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE `chat_conversation` SET `conversation_id` = ? WHERE `conversation_id` = ?";
        }

        public i(RoomDatabase r1) {
            super(r1);
        }
    }

    public class j extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE `chat_conversation` SET `is_local` = ? WHERE `conversation_id` = ?";
        }

        public j(RoomDatabase r1) {
            super(r1);
        }
    }

    public class k extends EntityInsertionAdapter<ChatConversation> {
        public final /* synthetic */ k1 a;

        public final String createQuery() {
            return "INSERT OR REPLACE INTO `chat_conversation` (`id`,`conversation_id`,`conversation_type`,`name`,`avatar`,`icon_image`,`time`,`update_time`,`type`,`status`,`owner`,`priority`,`last_section`,`last_message_id`,`last_message_time`,`member_list`,`last_message_index`,`prefer`,`config`,`is_local`,`recommend_bot_index`,`subtitle_message_id`,`tags`,`pinned`,`conversation_page`,`templates`,`bio`,`bot_stats`,`bot_type`,`bg_img_url`,`bg_img_avg_hue`,`bot_conversation_type`,`content_dist_type`,`default_onboarding`,`creator_info`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        public k(k1 r1, RoomDatabase r2) {
            this.a = r1;
            super(r2);
        }

        public final void bind(SupportSQLiteStatement r3, Object r4) {
            ChatConversation r5 = (ChatConversation) r4;
            r5.getClass();
            r3.bindNull(1);
            r3.bindNull(2);
            r3.bindNull(3);
            r3.bindNull(4);
            r3.bindNull(5);
            this.a.b.getClass();
            r3.bindNull(6);
            r3.bindNull(7);
            r3.bindNull(8);
            if (r5.getType() != null) goto L5;
            r3.bindNull(9);
        L6:
            r3.bindNull(10);
            r3.bindNull(11);
            r3.bindNull(12);
            r3.bindNull(13);
            r3.bindNull(14);
            r3.bindNull(15);
            this.a.b.getClass();
            r3.bindNull(16);
            r3.bindNull(17);
            this.a.b.getClass();
            r3.bindNull(18);
            this.a.b.getClass();
            r3.bindNull(19);
            r3.bindNull(20);
            r3.bindNull(21);
            r3.bindNull(22);
            this.a.b.getClass();
            r3.bindNull(23);
            r3.bindNull(24);
            this.a.c.getClass();
            r3.bindNull(25);
            this.a.b.getClass();
            r3.bindNull(26);
            r3.bindNull(27);
            this.a.c.getClass();
            r3.bindNull(28);
            r3.bindNull(29);
            r3.bindNull(30);
            r3.bindNull(31);
            r3.bindNull(32);
            r3.bindNull(33);
            r3.bindNull(34);
            this.a.c.getClass();
            r3.bindNull(35);
            return;
        L5:
            r3.bindString(9, r5.getType());
            goto L6
        }
    }

    public class l extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `subtitle_message_id` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public l(RoomDatabase r1) {
            super(r1);
        }
    }

    public class m extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `pinned` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public m(RoomDatabase r1) {
            super(r1);
        }
    }

    public class n extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `bio` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public n(RoomDatabase r1) {
            super(r1);
        }
    }

    public class o extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `bot_stats` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public o(RoomDatabase r1) {
            super(r1);
        }
    }

    public class p extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `icon_image` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public p(RoomDatabase r1) {
            super(r1);
        }
    }

    public class q extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        DELETE FROM `chat_conversation`\n        WHERE `conversation_id` = ? \n    ";
        }

        public q(RoomDatabase r1) {
            super(r1);
        }
    }

    public class r extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        DELETE FROM `chat_conversation`\n        WHERE `is_local` = 1 AND `priority` = 40\n    ";
        }

        public r(RoomDatabase r1) {
            super(r1);
        }
    }

    public class s extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `conversation_page` = ?\n        WHERE `conversation_id` = ?\n        ";
        }

        public s(RoomDatabase r1) {
            super(r1);
        }
    }

    public class t extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `bot_type` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public t(RoomDatabase r1) {
            super(r1);
        }
    }

    public class u extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `bg_img_url` = ?, `bg_img_avg_hue` = ? \n        WHERE `conversation_id` = ?\n    ";
        }

        public u(RoomDatabase r1) {
            super(r1);
        }
    }

    public class v extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `update_time` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public v(RoomDatabase r1) {
            super(r1);
        }
    }

    public class w extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `bot_conversation_type` = ?, `content_dist_type` = ?, `default_onboarding` = ? \n        WHERE `conversation_id` = ?\n    ";
        }

        public w(RoomDatabase r1) {
            super(r1);
        }
    }

    public class x extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `creator_info` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public x(RoomDatabase r1) {
            super(r1);
        }
    }

    public class y extends SharedSQLiteStatement {
        public final String createQuery() {
            return "DELETE FROM `chat_conversation`";
        }

        public y(RoomDatabase r1) {
            super(r1);
        }
    }

    public class z extends SharedSQLiteStatement {
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `time` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public z(RoomDatabase r1) {
            super(r1);
        }
    }

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

    public k1(RoomDatabase r2) {
        this.b = new ChatConversation.b();
        this.c = new ChatBot.b();
        this.a = r2;
        new k(this, r2);
        new v(r2);
        new z(r2);
        new a0(r2);
        new b0(r2);
        new c0(r2);
        new d0(r2);
        new e0(r2);
        new f0(r2);
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
        this.d = new y(r2);
    }
}
