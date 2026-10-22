package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h extends SharedSQLiteStatement {
    public final String createQuery() {
        return "\n        UPDATE `chat_bot`\n        SET `share_info` = ?\n        WHERE `bot_id` = ? AND `owner` = ?\n    ";
    }

    public h(ChatDatabase r1) {
        super(r1);
    }
}
