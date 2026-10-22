package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class w extends SharedSQLiteStatement {
    public final String createQuery() {
        return "\n        UPDATE `chat_bot`\n        SET `update_time` = ?\n        WHERE `bot_id` = ? AND `owner` = ?\n    ";
    }

    public w(ChatDatabase r1) {
        super(r1);
    }
}
