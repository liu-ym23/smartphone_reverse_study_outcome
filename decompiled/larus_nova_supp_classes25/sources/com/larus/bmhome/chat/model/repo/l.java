package com.larus.bmhome.chat.model.repo;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.larus.bmhome.chat.bean.ChatBot;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l extends EntityInsertionAdapter<ChatBot> {
    public final /* synthetic */ e0 a;

    public final String createQuery() {
        return "INSERT OR REPLACE INTO `chat_bot` (`id`,`bot_id`,`bot_type`,`bot_feature_label`,`bot_mode`,`bot_conf`,`owner`,`name`,`avatar`,`icon_image`,`icon_prompt`,`desc`,`context`,`time`,`update_time`,`type`,`status`,`message_push`,`private_status`,`prefer`,`config`,`share_info`,`creator_info`,`conversation_page`,`answer_actions`,`hover_answer_actions`,`streaming_answer_actions`,`bot_switch_config_info`,`caller_name`,`caller_name_setting`,`bg_img_url`,`bg_img_avg_hue`,`digital_human_data`,`first_met`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public l(e0 r1, ChatDatabase r2) {
        this.a = r1;
        super(r2);
    }

    public final void bind(SupportSQLiteStatement r4, Object r5) {
        ChatBot r6 = (ChatBot) r5;
        r6.getClass();
        r4.bindNull(1);
        r4.bindNull(2);
        r4.bindNull(3);
        r4.bindNull(4);
        r4.bindNull(5);
        this.a.b.getClass();
        r4.bindNull(6);
        r4.bindNull(7);
        r4.bindNull(8);
        r4.bindNull(9);
        this.a.c.getClass();
        r4.bindNull(10);
        r4.bindNull(11);
        r4.bindNull(12);
        if (r6.getContext() != null) goto L5;
        r4.bindNull(13);
    L6:
        r4.bindLong(14, 0);
        r4.bindNull(15);
        if (r6.getType() != null) goto L9;
        r4.bindNull(16);
    L10:
        r4.bindNull(17);
        r4.bindNull(18);
        r4.bindNull(19);
        this.a.b.getClass();
        r4.bindNull(20);
        this.a.b.getClass();
        r4.bindNull(21);
        this.a.b.getClass();
        r4.bindNull(22);
        this.a.b.getClass();
        r4.bindNull(23);
        this.a.b.getClass();
        r4.bindNull(24);
        this.a.b.getClass();
        r4.bindNull(25);
        this.a.b.getClass();
        r4.bindNull(26);
        this.a.b.getClass();
        r4.bindNull(27);
        this.a.b.getClass();
        r4.bindNull(28);
        r4.bindNull(29);
        r4.bindNull(30);
        r4.bindNull(31);
        r4.bindNull(32);
        this.a.b.getClass();
        r4.bindNull(33);
        this.a.b.getClass();
        r4.bindNull(34);
        return;
    L9:
        r4.bindString(16, r6.getType());
        goto L10
    L5:
        r4.bindString(13, r6.getContext());
        goto L6
    }
}
