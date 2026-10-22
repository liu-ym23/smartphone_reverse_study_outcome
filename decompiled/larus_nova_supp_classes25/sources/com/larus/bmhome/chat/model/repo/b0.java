package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b0 extends SharedSQLiteStatement {
    public final String createQuery() {
        return "\n        UPDATE `chat_bot`\n        SET `status` = ?\n        WHERE `bot_id` = ? AND `owner` = ?\n    ";
    }

    public b0(ChatDatabase r1) {
        super(r1);
    }
}
