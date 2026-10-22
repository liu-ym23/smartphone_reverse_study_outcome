package com.bytedance.ai.resource.core.db;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class z extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM ai_widget_info WHERE widget_id = ? AND package_name = ?";
    }

    public z(AIPackageDatabase r1) {
        super(r1);
    }
}
