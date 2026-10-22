package com.bytedance.ai.resource.core.db;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a0 extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM ai_widget_info WHERE package_name = ?";
    }

    public a0(AIPackageDatabase r1) {
        super(r1);
    }
}
