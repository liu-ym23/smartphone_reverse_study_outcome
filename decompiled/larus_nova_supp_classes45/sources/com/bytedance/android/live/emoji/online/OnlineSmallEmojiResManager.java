package com.bytedance.android.live.emoji.online;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.emoji.online.model.OnlineSmallEmojiRes;
import com.bytedance.android.live.emoji.online.model.OnlineSmallEmojiResInfo;
import java.io.File;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class OnlineSmallEmojiResManager {
    public static final OnlineSmallEmojiResManager i = null;
    public OnlineSmallEmojiResInfo a;
    public final Lazy b;
    public final Lazy c;
    public OnlineSmallEmojiCache d;
    public volatile String e;
    public volatile int f;
    public volatile boolean g;
    public volatile boolean h;

    public static final class a {
    }

    public final LinkedHashMap<String, String> b() {
        return (LinkedHashMap) this.c.getValue();
    }

    static {
        i = new OnlineSmallEmojiResManager();
    }

    public final boolean d() {
        if (this.f != 2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        ALogger.d("OnlineEmojiResManager", "  not enabled: " + this.f);
    L8:
        return r0;
    L5:
        r0 = false;
        goto L6
    }

    public OnlineSmallEmojiResManager() {
        this.b = LazyKt.lazy(OnlineSmallEmojiResManager$emojiNameIdMap$2.INSTANCE);
        this.c = LazyKt.lazy(OnlineSmallEmojiResManager$panelEmojiNameMap$2.INSTANCE);
        this.e = "";
    }

    public final void a(OnlineSmallEmojiRes r6) {
        c r0 = c.c;
        int r1 = this.f;
        if (r1 == 1) goto L7;
        if (r1 == 2) goto L7;
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
    L15:
        String r7 = r6.getMd5();
        Intrinsics.checkNotNull(r7);
        r0.a(new String[]{r7});
        return;
    L10:
        if (this.e.length() <= 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        String r8 = r6.getMd5();
        Intrinsics.checkNotNull(r8);
        r0.a(new String[]{this.e, r8});
        return;
    L12:
        r3 = false;
    L7:
        r2 = true;
        goto L8
    }

    public final String c(String r3) {
        StringBuilder r0 = new StringBuilder("file://");
        OnlineSmallEmojiResInfo r1 = this.a;
        Intrinsics.checkNotNull(r1);
        r0.append(r1.getPicFileDirPath());
        r0.append(File.separator);
        r0.append(r3);
        return r0.toString();
    }
}
