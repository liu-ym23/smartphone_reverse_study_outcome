package com.obric.miniapp.alarm;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e extends SharedSQLiteStatement {
    public final String createQuery() {
        return "UPDATE alarm SET triggerTime = ?, currentRepeatCount = ? WHERE id = ? AND token = ?";
    }

    public e(AlarmDatabase r1) {
        super(r1);
    }
}
