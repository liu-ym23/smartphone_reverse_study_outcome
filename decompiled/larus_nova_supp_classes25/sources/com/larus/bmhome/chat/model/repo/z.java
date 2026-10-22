package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z extends SharedSQLiteStatement {
    public final String createQuery() {
        return "\n        UPDATE `chat_bot`\n        SET `caller_name_setting` = ?\n        WHERE `bot_id` = ? AND `owner` = ?\n    ";
    }

    public z(ChatDatabase r1) {
        super(r1);
    }
}
