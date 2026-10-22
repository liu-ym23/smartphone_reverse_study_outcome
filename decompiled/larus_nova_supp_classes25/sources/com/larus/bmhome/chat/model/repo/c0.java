package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c0 extends SharedSQLiteStatement {
    public final String createQuery() {
        return "\n        UPDATE `chat_bot`\n        SET `message_push` = ?\n        WHERE `bot_id` = ? AND `owner` = ?\n    ";
    }

    public c0(ChatDatabase r1) {
        super(r1);
    }
}
