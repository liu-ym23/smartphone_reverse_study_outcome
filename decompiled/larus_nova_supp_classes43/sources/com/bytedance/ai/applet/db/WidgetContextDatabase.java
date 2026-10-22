package com.bytedance.ai.applet.db;

import androidx.room.RoomDatabase;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/applet/db/WidgetContextDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "widgetContextDao", "Lcom/bytedance/ai/applet/db/WidgetContextDao;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class WidgetContextDatabase extends RoomDatabase {
    public static final a a = null;
    public static volatile WidgetContextDatabase b;

    public static final class a {
        public a() {
        }
    }

    static {
        a = new a();
    }

    public abstract com.bytedance.ai.applet.db.a c();

    public WidgetContextDatabase() {
    }
}
