package com.bytedance.ai.applet.db;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM widget_context_info";
    }

    public h(WidgetContextDatabase r1) {
        super(r1);
    }
}
