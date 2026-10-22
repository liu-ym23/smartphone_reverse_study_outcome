package com.larus.disk.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class z {
    public static final Set<String> a = null;
    public static final Set<String> b = null;
    public static final Set<String> c = null;
    public static final Set<String> d = null;
    public static final Set<String> e = null;
    public static final Set<String> f = null;
    public static final Set<String> g = null;
    public static final Set<String> h = null;

    static {
        a = SetsKt.setOf(new String[]{"avif", "bmp", "gif", "heic", "heif", "jpeg", "jpg", "png", "webp"});
        b = SetsKt.setOf(new String[]{"3gp", "avi", "flv", "m4v", "mkv", "mov", "mp4", "mpeg", "mpg", "webm"});
        c = SetsKt.setOf(new String[]{"aac", "amr", "flac", "m4a", "mp3", "ogg", "opus", "pcm", "wav"});
        d = SetsKt.setOf(new String[]{"csv", "doc", "docx", "html", "md", "pdf", "ppt", "pptx", "rtf", "txt", "xls", "xlsx"});
        e = SetsKt.setOf(new String[]{"7z", "apk", "bz2", "gz", "rar", "tar", "tgz", "zip", "zst"});
        f = SetsKt.setOf(new String[]{"db", "db-shm", "db-wal", "sqlite", "sqlite3"});
        g = SetsKt.setOf(new String[]{"alog", "log", "trace"});
        h = SetsKt.setOf(new String[]{"external/files/update", "internal/files/plugins", "internal/files/update"});
    }

    public static boolean a(String r4, String... r5) {
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        if (b(r4, r5[r2]) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L11:
        return false;
    }

    public static boolean b(String r8, String r9) {
        List r10 = StringsKt.split$default(r8, new char[]{'/'}, false, 0, 6, null);
        if ((r10 instanceof Collection) == true) goto L5;
    L7:
        Iterator r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L19;
        String r1 = (String) r11.next();
        if (Intrinsics.areEqual(r1, r9) == false) goto L13;
    L16:
        boolean r2 = true;
    L17:
        if (r2 == false) goto L9;
        return true;
    L13:
        if (StringsKt.startsWith$default(r1, r9 + '_', false, 2, null) == true) goto L16;
        r2 = false;
    L19:
        return false;
    L5:
        if (r10.isEmpty() == false) goto L7;
        goto L7
    }
}
