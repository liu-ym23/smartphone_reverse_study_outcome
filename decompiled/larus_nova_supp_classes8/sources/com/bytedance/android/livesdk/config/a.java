package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends SSettingKey<List<? extends String>> {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
        super("allow_schema_system_handle_list", "允许丢给系统处理的白名单", new ArrayList(), new ArrayList());
    }
}
