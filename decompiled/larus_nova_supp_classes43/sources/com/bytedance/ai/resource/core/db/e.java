package com.bytedance.ai.resource.core.db;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM ai_applet_info WHERE applet_id = ? AND package_name = ?";
    }

    public e(AIPackageDatabase r1) {
        super(r1);
    }
}
