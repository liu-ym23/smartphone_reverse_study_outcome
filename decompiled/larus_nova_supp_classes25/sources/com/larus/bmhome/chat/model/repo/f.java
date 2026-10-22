package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f extends SharedSQLiteStatement {
    public final String createQuery() {
        return "\n        UPDATE `chat_bot`\n        SET `prefer` = ?\n        WHERE `bot_id` = ? AND `owner` = ?\n    ";
    }

    public f(ChatDatabase r1) {
        super(r1);
    }
}
