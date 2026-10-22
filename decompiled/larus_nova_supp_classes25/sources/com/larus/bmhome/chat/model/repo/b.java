package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b extends SharedSQLiteStatement {
    public final String createQuery() {
        return "\n        UPDATE `chat_bot`\n        SET `name` = ?\n        WHERE `bot_id` = ? AND `owner` = ?\n    ";
    }

    public b(ChatDatabase r1) {
        super(r1);
    }
}
