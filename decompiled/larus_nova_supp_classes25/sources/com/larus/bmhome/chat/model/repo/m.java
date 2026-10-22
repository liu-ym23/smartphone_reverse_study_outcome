package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m extends SharedSQLiteStatement {
    public final String createQuery() {
        return "\n        UPDATE `chat_bot`\n        SET `hover_answer_actions` = ?\n        WHERE `bot_id` = ? AND `owner` = ?\n        ";
    }

    public m(ChatDatabase r1) {
        super(r1);
    }
}
