package com.bytedance.ai.resource.core.db;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b0 extends SharedSQLiteStatement {
    public final String createQuery() {
        return "UPDATE ai_widget_info SET ready_for_deleting = 1 WHERE widget_id = ? AND package_name = ?";
    }

    public b0(AIPackageDatabase r1) {
        super(r1);
    }
}
