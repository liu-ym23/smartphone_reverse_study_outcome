package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d0 extends SharedSQLiteStatement {
    public final String createQuery() {
        return "\n        UPDATE `chat_bot`\n        SET `private_status` = ?\n        WHERE `bot_id` = ? AND `owner` = ?\n    ";
    }

    public d0(ChatDatabase r1) {
        super(r1);
    }
}
