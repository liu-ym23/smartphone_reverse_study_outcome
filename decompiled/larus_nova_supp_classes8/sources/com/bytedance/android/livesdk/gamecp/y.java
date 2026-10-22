package com.bytedance.android.livesdk.gamecp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.webkit.URLUtil;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y implements bw.r {
    public y() {
    }

    public final boolean handle(Context r2, Uri r3) {
        jc1.k.n(IRoomService.class).actionHandler().handle(r2, r3);
        return true;
    }

    public final boolean handle(Context r2, String r3) {
        jc1.k.n(IRoomService.class).actionHandler().handle(r2, r3);
        return true;
    }

    public final boolean handleWithCallback(Context r2, Uri r3, DialogInterface.OnDismissListener r4) {
        return jc1.k.n(IRoomService.class).actionHandler().handleWithCallback(r2, r3, r4);
    }

    public final void openExternalBrowser(Context r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r5, "gameId");
        if (URLUtil.isNetworkUrl(r4) == true) goto L5;
        return;
    L5:
        Intent r6 = new Intent("android.intent.action.VIEW", UriProtector.parse(r4));
        if (r6.resolveActivity(r3.getPackageManager()) == null) goto L8;
        r3.startActivity(r6);
        return;
    L8:
        yr.b.b(6, "openExternalBrowser", "没有找到合适的浏览器，url=" + r4);
    }
}
