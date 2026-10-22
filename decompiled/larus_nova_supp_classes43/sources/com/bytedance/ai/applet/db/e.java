package com.bytedance.ai.applet.db;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e extends EntityDeletionOrUpdateAdapter<i> {
    public final String createQuery() {
        return "DELETE FROM `widget_context_info` WHERE `card_id` = ?";
    }

    public e(WidgetContextDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r10, Object r11) {
        String r12 = ((i) r11).a;
        if (r12 != null) goto L5;
        r10.bindNull(1);
        return;
    L5:
        r10.bindString(1, r12);
    }
}
