package com.bytedance.android.live.ktv.common.speech;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n {
    public static final String b() {
        Context r0 = s1.getContext();
        File r1 = r0.getExternalCacheDir();
        if (r1 == null) goto L6;
        String r2 = r1.getPath();
        if (r2 == null) goto L6;
    L7:
        if (r2 == null) goto L10;
        return r2;
    L10:
        throw new IllegalArgumentException("Required value was null.".toString());
    L6:
        r2 = r0.getCacheDir().getPath();
        goto L7
    }

    public static final String c(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "musicId");
        Intrinsics.checkNotNullParameter(r12, "musicId");
        StringBuilder r1 = new StringBuilder(b());
        String r2 = File.separator;
        r1.append(r2);
        r1.append("lyrics");
        r1.append(r2);
        r1.append(r12);
        r1.append(r2);
        String r3 = r1.toString();
        PolarisFileWrapper r4 = new PolarisFileWrapper(r3);
        if (r4.exists() == false) goto L5;
    L8:
        StringBuilder r5 = new StringBuilder();
        r5.append(r3);
        Intrinsics.checkNotNullParameter(r12, "musicId");
        if (r11 == null) goto L36;
        boolean r6 = false;
        if (r11.length() <= 0) goto L13;
        boolean r0 = true;
    L14:
        String r7 = null;
        if (r0 == true) goto L18;
        r11 = null;
    L18:
        if (r11 == null) goto L36;
        int r8 = StringsKt.lastIndexOf$default(r11, "/", 0, false, 6, null);
        if (r8 >= 0) goto L22;
    L24:
        if (r8 >= 0) goto L26;
    L28:
        if (r6 == true) goto L31;
        r11 = null;
    L31:
        if (r11 == null) goto L33;
        r7 = r11.substring(r8 + 1);
    L33:
        if (r7 == null) goto L36;
        r12 = r7;
        goto L36
    L26:
        if (r8 >= r11.length()) goto L28;
        r6 = true;
        goto L28
    L22:
        if (r8 != (r11.length() - 1)) goto L24;
        r11 = r11.substring(0, r11.length() - 1);
        r8 = StringsKt.lastIndexOf$default(r11, "/", 0, false, 6, null);
        goto L24
    L13:
        r0 = false;
    L36:
        r5.append(r12);
        return r5.toString();
    L5:
        if (r4.mkdirs() == false) goto L7;
        Single.create(new l(b() + r2 + "lyrics")).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
        goto L8
    L7:
        ALogger.e("SpeechFileUtils", "mkdirs return false, dir=" + r4);
        goto L8
    }

    public static final jg4.j a(String r12, String r13, LyricsDisplayConfig r14) {
        Intrinsics.checkNotNullParameter(r12, "songUrl");
        Intrinsics.checkNotNullParameter(r13, "path");
        Intrinsics.checkNotNullParameter(r14, "config");
        float r0 = kg4.a.a;
        Intrinsics.checkNotNullParameter(r13, "filePath");
        String r7 = File.separator;
        int r1 = StringsKt.lastIndexOf$default(r13, r7, 0, false, 6, null);
        String r8 = null;
        if (r1 == (-1)) goto L5;
        String r2 = r13.substring(0, r1);
    L6:
        String r11 = "";
        if (r2 != null) goto L9;
        String r15 = "";
    L10:
        Intrinsics.checkNotNullParameter(r13, "filePath");
        int r3 = StringsKt.lastIndexOf$default(r13, r7, 0, false, 6, null);
        if (r3 == (-1)) goto L13;
        r8 = r13.substring(r3);
    L13:
        if (r8 == null) goto L17;
        r11 = r8;
    L17:
        return new jg4.j(r12, r15, r11, r14);
    L9:
        r15 = r2;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
