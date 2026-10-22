package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM `chat_bot` WHERE `bot_id` = ? AND `owner` = ?";
    }

    public u(ChatDatabase r1) {
        super(r1);
    }
}
