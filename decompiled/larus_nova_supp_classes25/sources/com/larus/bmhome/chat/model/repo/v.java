package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class v extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM `chat_bot`";
    }

    public v(ChatDatabase r1) {
        super(r1);
    }
}
