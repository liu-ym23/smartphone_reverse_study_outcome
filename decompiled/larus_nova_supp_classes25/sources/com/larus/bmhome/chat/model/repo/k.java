package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k extends SharedSQLiteStatement {
    public final String createQuery() {
        return "\n        UPDATE `chat_bot`\n        SET `answer_actions` = ?\n        WHERE `bot_id` = ? AND `owner` = ?\n        ";
    }

    public k(ChatDatabase r1) {
        super(r1);
    }
}
