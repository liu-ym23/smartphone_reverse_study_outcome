package com.bytedance.ai.applet.db;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f extends EntityDeletionOrUpdateAdapter<i> {
    public final String createQuery() {
        return "UPDATE OR ABORT `widget_context_info` SET `card_id` = ?,`message_id` = ?,`conversation_id` = ?,`bot_id` = ? WHERE `card_id` = ?";
    }

    public f(WidgetContextDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r10, Object r11) {
        i r12 = (i) r11;
        String r0 = r12.a;
        if (r0 != null) goto L5;
        r10.bindNull(1);
    L6:
        String r1 = r12.b;
        if (r1 != null) goto L9;
        r10.bindNull(2);
    L10:
        String r13 = r12.c;
        if (r13 != null) goto L13;
        r10.bindNull(3);
    L14:
        String r14 = r12.d;
        if (r14 != null) goto L17;
        r10.bindNull(4);
    L18:
        String r15 = r12.a;
        if (r15 != null) goto L21;
        r10.bindNull(5);
        return;
    L21:
        r10.bindString(5, r15);
        return;
    L17:
        r10.bindString(4, r14);
        goto L18
    L13:
        r10.bindString(3, r13);
        goto L14
    L9:
        r10.bindString(2, r1);
        goto L10
    L5:
        r10.bindString(1, r0);
        goto L6
    }
}
