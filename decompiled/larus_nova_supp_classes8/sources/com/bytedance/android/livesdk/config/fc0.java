package com.bytedance.android.livesdk.config;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fc0 extends SSettingKey<List<? extends String>> {
    public static final fc0 a = null;

    static {
        a = new fc0();
    }

    public fc0() {
        super("live_multi_pub_stream_succeed_codes", "跨房厅战公共流Result回调，处理为成功的返回码", CollectionsKt.mutableListOf(new String[]{"0", "1", "2"}), CollectionsKt.mutableListOf(new String[]{"0", "1", "2"}));
    }
}
