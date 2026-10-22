package com.bytedance.ai.resource.core.db;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g extends SharedSQLiteStatement {
    public final String createQuery() {
        return "UPDATE ai_applet_info SET ready_for_deleting = 1 WHERE applet_id = ? AND package_name = ?";
    }

    public g(AIPackageDatabase r1) {
        super(r1);
    }
}
