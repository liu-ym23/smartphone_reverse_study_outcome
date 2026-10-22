package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import java.io.File;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t extends v {
    public static final /* synthetic */ int b = 0;

    public static final class a {
        public static String a(long r3) {
            StringBuilder r0 = new StringBuilder(KtvCommonConfigParams.a());
            String r1 = File.separator;
            r0.append(r1);
            r0.append("musicPack");
            r0.append(r1);
            r0.append(r3);
            r0.append(r1);
            r0.append("lyrics");
            r0.append(r1);
            return r0.toString();
        }

        public static String b(String r11, long r12) {
            if (r11 == null) goto L28;
            boolean r1 = false;
            if (r11.length() <= 0) goto L6;
            boolean r0 = true;
        L7:
            String r3 = null;
            if (r0 == true) goto L11;
            r11 = null;
        L11:
            if (r11 == null) goto L28;
            int r2 = StringsKt.lastIndexOf$default(r11, "/", 0, false, 6, null);
            if (r2 >= 0) goto L15;
        L17:
            if (r2 >= 0) goto L19;
        L21:
            if (r1 == true) goto L24;
            r11 = null;
        L24:
            if (r11 == null) goto L26;
            r3 = r11.substring(r2 + 1);
        L26:
            if (r3 == null) goto L28;
            return r3;
        L19:
            if (r2 >= r11.length()) goto L21;
            r1 = true;
            goto L21
        L15:
            if (r2 != (r11.length() - 1)) goto L17;
            r11 = r11.substring(0, r11.length() - 1);
            r2 = StringsKt.lastIndexOf$default(r11, "/", 0, false, 6, null);
            goto L17
        L6:
            r0 = false;
        L28:
            return String.valueOf(r12);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public String getType() {
        return KtvSubElement.LYRIC;
    }

    public t() {
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String a(KtvMusic r4) {
        Intrinsics.checkNotNullParameter(r4, "music");
        List r0 = r4.getMLyricUrlList();
        if (r0 == null) goto L5;
        String r1 = (String) CollectionsKt.firstOrNull(r0);
    L7:
        return a.b(r1, r4.getMId());
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String b(KtvMusic r3) {
        Intrinsics.checkNotNullParameter(r3, "music");
        return a.a(r3.getMId());
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String c(KtvMusic r2) {
        Intrinsics.checkNotNullParameter(r2, "music");
        List r3 = r2.getMLyricUrlList();
        if (r3 == null) goto L6;
        String r4 = (String) CollectionsKt.getOrNull(r3, 0);
        if (r4 == null) goto L6;
        return r4;
    L6:
        return "";
    }
}
