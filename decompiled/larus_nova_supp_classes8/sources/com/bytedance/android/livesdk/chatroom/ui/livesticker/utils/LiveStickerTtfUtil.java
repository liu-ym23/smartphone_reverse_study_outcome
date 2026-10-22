package com.bytedance.android.livesdk.chatroom.ui.livesticker.utils;

import android.graphics.Typeface;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.depend.model.live.DecorationFontConfig;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveStickerTtfUtil {
    public static final Lazy<String> a = null;
    public static final Map<Long, Typeface> b = null;
    public static final NextLiveData<Integer> c = null;

    static {
        a = LazyKt.lazy(LiveStickerTtfUtil$ttfFilePath$1.INSTANCE);
        b = new ConcurrentHashMap();
        NextLiveData<Integer> r0 = new NextLiveData();
        r0.setValue(0);
        c = r0;
    }

    @JvmStatic
    public static final boolean a(Long r2) {
        if (r2 == null) goto L5;
        r2.longValue();
        return FileUtils.checkFileExists(c(r2.longValue()));
    L5:
        return false;
    }

    @JvmStatic
    public static final void b(DecorationFontConfig r4) {
        if (r4 == null) goto L11;
        long r0 = r4.getFontId();
        String r5 = r4.getDownloadUrl();
        if (r5 != null) goto L7;
        return;
    L7:
        if (a(Long.valueOf(r0)) == false) goto L9;
        return;
    L9:
        Downloader.with(s1.getContext()).url(r5).name(r0 + ".temp").savePath((String) a.getValue()).monitorScene("live_anchor_sticker_ttf").subThreadListener(new b(r0)).download();
        return;
    }

    public static String c(long r2) {
        return ((String) a.getValue()) + r2 + ".ttf";
    }
}
