package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.common.utility.DigestUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w implements com.bytedance.android.scope.o, dy0.c {
    public final ConcurrentHashMap<String, Integer> a;
    public Disposable b;
    public boolean c;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public w() {
        this.a = new ConcurrentHashMap();
        this.c = true;
    }

    public final void a(String r6, z3.a r7) {
        Intrinsics.checkNotNullParameter(r6, "url");
        Intrinsics.checkNotNullParameter(r7, "callback");
        String r0 = DigestUtils.md5Hex(UriProtector.parse(r6).getPath()) + ".png";
        this.c = true;
        Downloader.with(com.bytedance.android.live.core.utils.s1.getContext()).url(r6).name(r0).savePath(com.bytedance.android.live.core.utils.s1.getContext().getDir("activity_image", 0).getAbsolutePath() + File.separator).monitorScene("activity_image").mainThreadListener(new v(r7, r6)).asyncDownload(new u(this, r6));
    }
}
