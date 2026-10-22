package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t extends SharedSQLiteStatement {
    public final String createQuery() {
        return "\n        UPDATE `chat_bot`\n        SET `bot_feature_label` = ?\n        WHERE `bot_id` = ?\n        ";
    }

    public t(ChatDatabase r1) {
        super(r1);
    }
}
