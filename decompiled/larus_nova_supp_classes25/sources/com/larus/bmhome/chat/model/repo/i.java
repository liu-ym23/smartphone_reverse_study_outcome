package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i extends SharedSQLiteStatement {
    public final String createQuery() {
        return "\n        UPDATE `chat_bot`\n        SET `creator_info` = ?\n        WHERE `bot_id` = ? AND `owner` = ?\n        ";
    }

    public i(ChatDatabase r1) {
        super(r1);
    }
}
