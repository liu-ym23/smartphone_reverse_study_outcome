package com.bytedance.android.live.emoji.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.emoji.online.OnlineSmallEmojiResManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class EmojiResHelper implements r90.c {
    public static EmojiResHelper c;
    public r90.c a;
    public final Lazy b;

    public static final class a {
        @JvmStatic
        public static EmojiResHelper a(Context r1) {
            Intrinsics.checkNotNullParameter(r1, "context");
            if (EmojiResHelper.c == null) goto L5;
        L15:
            EmojiResHelper r2 = EmojiResHelper.c;
            Intrinsics.checkNotNull(r2);
            return r2;
        L5:
            monitor-enter(EmojiResHelper.class);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (EmojiResHelper.c != null) goto L9;
            EmojiResHelper.c = new EmojiResHelper();     // Catch: Throwable -> L12
        L9:
            Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(EmojiResHelper.class);
            goto L15
        }
    }

    static {
    }

    public final r90.c e() {
        if (((Boolean) this.b.getValue()).booleanValue() == false) goto L18;
        int r0 = com.bytedance.android.live.emoji.online.b.a;
        if (OnlineSmallEmojiResManager.i.d() == false) goto L18;
        r90.c r1 = this.a;
        if (r1 != null) goto L10;
    L11:
        monitor-enter(this);
        this.a = new com.bytedance.android.live.emoji.online.b();     // Catch: Throwable -> L15
        ALogger.d("EmojiResHelper", " init online adapter");     // Catch: Throwable -> L15
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(this);
    L25:
        r90.c r3 = this.a;
        Intrinsics.checkNotNull(r3);
        return r3;
    L15:
        th = move-exception;
        throw th;
    L10:
        if ((r1 instanceof r90.d) == false) goto L25;
    L18:
        r90.c r4 = this.a;
        if (r4 != null) goto L21;
    L22:
        monitor-enter(this);
        this.a = new r90.d(jc1.a.b());     // Catch: Throwable -> L27
        ALogger.d("EmojiResHelper", " init local adapter");     // Catch: Throwable -> L27
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(this);
    L27:
        th = move-exception;
        throw th;
    L21:
        if ((r4 instanceof com.bytedance.android.live.emoji.online.b) == false) goto L25;
        goto L22
    }

    public EmojiResHelper() {
        this.b = LazyKt.lazy(EmojiResHelper$disableOnline$2.INSTANCE);
    }

    @Override // r90.c
    public final int c() {
        return e().c();
    }

    @Override // r90.c
    public final List b(List r2) {
        return e().b(r2);
    }

    @Override // r90.c
    public final List d(int r2) {
        return e().d(r2);
    }

    @Override // r90.c
    public final Drawable a(Context r2, String r3) {
        return e().a(r2, r3);
    }
}
