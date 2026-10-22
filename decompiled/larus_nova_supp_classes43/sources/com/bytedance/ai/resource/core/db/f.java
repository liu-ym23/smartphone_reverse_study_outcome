package com.bytedance.ai.resource.core.db;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM ai_applet_info WHERE package_name = ?";
    }

    public f(AIPackageDatabase r1) {
        super(r1);
    }
}
