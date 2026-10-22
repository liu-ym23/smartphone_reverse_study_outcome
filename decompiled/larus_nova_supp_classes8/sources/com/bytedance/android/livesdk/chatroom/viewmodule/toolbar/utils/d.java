package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.h0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.m0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    public static int a;

    public interface a {
        void a(String r1, String r2);

        void onFail(String r1, String r2);
    }

    public d() {
    }

    static {
    }

    public static void a(String r10, h0 r11, m0 r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = null;
    L8:
        Intrinsics.checkNotNullParameter(r10, "url");
        String r14 = s1.getContext().getCacheDir().getAbsolutePath();
        if (r10.length() != 0) goto L11;
        boolean r0 = true;
    L13:
        if (r0 == false) goto L15;
        a++;
        StringBuilder r1 = new StringBuilder();
        r1.append(System.currentTimeMillis());
        r1.append('_');
        r1.append(a);
        String r2 = r1.toString();
    L25:
        String r3 = r14 + File.separator + r2;
        Downloader.with(s1.getContext()).url(r10).name(r2).savePath(r14).retryCount(3).subThreadListener(new e(r11, r2, r3)).mainThreadListener(new f(r12, r2, r3)).download();
        return;
    L15:
        List r4 = StringsKt.split$default(r10, new String[]{"/"}, false, 0, 6, null);
        int r5 = r4.size() - 1;
    L16:
        if (r5 < 0) goto L24;
        String r6 = (String) ListProtector.get(r4, r5);
        if (r6.length() <= 0) goto L20;
        boolean r7 = true;
    L21:
        if (r7 == true) goto L22;
        r5 = r5 - 1;
        goto L16
    L22:
        r2 = r6;
        goto L25
    L20:
        r7 = false;
        goto L21
    L24:
        a++;
        StringBuilder r8 = new StringBuilder();
        r8.append(System.currentTimeMillis());
        r8.append('_');
        r8.append(a);
        r2 = r8.toString();
        goto L25
    L11:
        r0 = false;
        goto L13
    }
}
