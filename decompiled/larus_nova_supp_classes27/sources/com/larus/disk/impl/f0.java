package com.larus.disk.impl;

import com.larus.disk.api.CacheHandlerBiz;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f0 {
    public static final Set<String> a = null;
    public static final Set<String> b = null;

    public static final long a(long r5, long r7) {
        if ((com.larus.dora.impl.ota.g2.j0.G2_OTA_RECOVERY_BLOCK_FOREVER - r5) >= r7) goto L6;
        return com.larus.dora.impl.ota.g2.j0.G2_OTA_RECOVERY_BLOCK_FOREVER;
    L6:
        return r5 + r7;
    }

    static {
        a = SetsKt.setOf(new String[]{"app_assets", "app_gift_resource", "app_hws_webview", "app_lib", "app_librarian", "app_textures", "bbox_acc", "cache", "code_cache", "databases", "files", "lib", "no_backup", "oat", "share", CacheHandlerBiz.BIZ_SP, "small_emoji_res", "srpatch"});
        b = SetsKt.setOf(new String[]{"cache", "files"});
    }

    public static final double b(long r9, long r11) {
        if (r11 > 0) goto L7;
        return 0.0d;
    L7:
        return RangesKt.coerceIn(r9, 0, r11) / r11;
    }
}
