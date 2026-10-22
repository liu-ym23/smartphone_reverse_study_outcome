package com.bytedance.ai.resource.core.db;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ai.model.objects.Applet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w extends EntityDeletionOrUpdateAdapter<Applet> {
    public final String createQuery() {
        return "DELETE FROM `ai_applet_info` WHERE `id` = ?";
    }

    public w(AIPackageDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r10, Object r11) {
        r10.bindLong(1, ((Applet) r11).m);
    }
}
