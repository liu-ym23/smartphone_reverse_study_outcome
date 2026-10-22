package com.bytedance.ai.resource.core.db;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ai.model.objects.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t extends EntityDeletionOrUpdateAdapter<Widget> {
    public final String createQuery() {
        return "DELETE FROM `ai_widget_info` WHERE `id` = ?";
    }

    public t(AIPackageDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r10, Object r11) {
        r10.bindLong(1, ((Widget) r11).m);
    }
}
