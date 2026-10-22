package com.ss.android.lark.feed.export.feedcard;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final View a;
    public final FeedCardComponent<?, ?> b;
    public final FeedCardComponent<?, ?> c;
    public final FeedCardComponent<?, ?>[] d;
    public final FeedCardComponent<?, ?>[] e;
    public final FeedCardComponent<?, ?>[] f;
    public final FeedCardComponent<?, ?>[] g;
    public final FeedCardComponent<?, ?>[] h;
    public final FeedCardComponent<?, ?> i;

    public a(com.ss.android.lark.feed.cardcomponent.avatar.a r5, com.ss.android.lark.feed.cardcomponent.teams.b r6, FeedCardComponent[] r7, FeedCardComponent[] r8, FeedCardComponent[] r9, FeedCardComponent[] r10, dhb.a r11, int r12) {
        if ((r12 & 2) == 0) goto L6;
        r5 = null;
    L6:
        if ((r12 & 4) == 0) goto L9;
        r6 = null;
    L9:
        if ((r12 & 8) == 0) goto L12;
        r7 = new FeedCardComponent[0];
    L12:
        if ((r12 & 16) == 0) goto L15;
        r8 = new FeedCardComponent[0];
    L15:
        if ((r12 & 32) == 0) goto L17;
        FeedCardComponent<?, ?>[] r0 = new FeedCardComponent[0];
    L19:
        if ((r12 & 64) == 0) goto L22;
        r9 = new FeedCardComponent[0];
    L22:
        if ((r12 & 128) == 0) goto L25;
        r10 = new FeedCardComponent[0];
    L25:
        if ((r12 & 256) == 0) goto L27;
        r11 = null;
    L27:
        Intrinsics.checkNotNullParameter(r7, "title");
        Intrinsics.checkNotNullParameter(r8, "titleRight");
        Intrinsics.checkNotNullParameter(r0, "subtitle");
        Intrinsics.checkNotNullParameter(r9, "preview");
        Intrinsics.checkNotNullParameter(r10, "bottomAction");
        this.a = null;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r0;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        return;
    L17:
        r0 = null;
        goto L19
    }
}
