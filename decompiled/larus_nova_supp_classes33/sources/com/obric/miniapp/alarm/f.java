package com.obric.miniapp.alarm;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM alarm WHERE id = ? AND token = ?";
    }

    public f(AlarmDatabase r1) {
        super(r1);
    }
}
