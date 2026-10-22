package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j extends SharedSQLiteStatement {
    public final String createQuery() {
        return "\n        UPDATE `chat_bot`\n        SET `bot_switch_config_info` = ?\n        WHERE `bot_id` = ? AND `owner` = ?\n        ";
    }

    public j(ChatDatabase r1) {
        super(r1);
    }
}
