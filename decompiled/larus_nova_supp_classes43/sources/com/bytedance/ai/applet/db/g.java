package com.bytedance.ai.applet.db;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM widget_context_info WHERE card_id = ?";
    }

    public g(WidgetContextDatabase r1) {
        super(r1);
    }
}
