package com.larus.audio.utils;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.common.apphost.AppHost;
import com.larus.media.MediaResourceManager;
import com.larus.network.NetConnectionTypeProvider;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import p68.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class w implements com.larus.platform.api.n0 {
    public final /* synthetic */ e a;
    public final /* synthetic */ String b;

    public final void b(Integer r1, Integer r2) {
    }

    public final void onCompletion() {
        e r0 = this.a;
        if (r0 == null) goto L5;
        r0.onEnd();
    L5:
        Lazy r1 = MediaResourceManager.a;
        AudioLoadManager r2 = AudioLoadManager.a;
        MediaResourceManager.a(AudioLoadManager.a());
        FLogger.a.i("AudioLoadManager", "[realPlay] onCompletion");
    }

    public final void onPrepare() {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        StringBuilder r2 = new StringBuilder("[realPlay] onPrepare, styleId:");
        r2.append(this.b);
        r2.append(", network:");
        r2.append(NetworkUtils.getNetworkAccessType(NetworkUtils.getNetworkTypeFast(AppHost.a.getApplication())));
        r2.append(", network_status:");
        NetConnectionTypeProvider.NetworkStatus r3 = NetConnectionTypeProvider.a;
        r2.append(NetConnectionTypeProvider.a);
        r0.i("AudioLoadManager", r2.toString());
    }

    public final void onPrepared() {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        r0.i("AudioLoadManager", "[realPlay] onPrepared");
        boolean r2 = l1.e;
        l1.c = System.currentTimeMillis();
    }

    public final void onRenderStart() {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        r0.i("AudioLoadManager", "[realPlay] onRenderStart");
        l1.b();
    }

    public final void c(int r4) {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        r0.i("AudioLoadManager", "[realPlay] onPlaybackStateChanged playbackState:" + r4);
    }

    public final void d(int r4) {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        r0.i("AudioLoadManager", "[realPlay] onLoadStateChanged loadState:" + r4);
    }

    public final void onVideoStatusException(int r4) {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        r0.e("AudioLoadManager", "[realPlay] onVideoStatusException status:" + r4);
    }

    public w(e r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(Integer r4, Integer r5) {
        e r0 = this.a;
        if (r0 == null) goto L5;
        r0.onError();
    L5:
        FLogger r1 = FLogger.a;
        AudioLoadManager r2 = AudioLoadManager.a;
        r1.e("AudioLoadManager", "[realPlay] onError " + this.b + " code:" + r4 + ", internalCode:" + r5);
    }
}
