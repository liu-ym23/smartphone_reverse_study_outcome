package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s extends SharedSQLiteStatement {
    public final String createQuery() {
        return "\n        UPDATE `chat_bot`\n        SET `first_met` = ?\n        WHERE `bot_id` = ? AND `owner` = ?\n        ";
    }

    public s(ChatDatabase r1) {
        super(r1);
    }
}
