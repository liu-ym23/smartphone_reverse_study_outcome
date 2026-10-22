package com.bytedance.ai.applet.webview;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final Map<String, String> a;

    public static final class a {
    }

    static {
    }

    public b() {
        this.a = MapsKt.mapOf(new Pair[]{TuplesKt.to("android.webkit.resource.VIDEO_CAPTURE", "android.permission.CAMERA"), TuplesKt.to("android.webkit.resource.AUDIO_CAPTURE", "android.permission.RECORD_AUDIO")});
    }
}
