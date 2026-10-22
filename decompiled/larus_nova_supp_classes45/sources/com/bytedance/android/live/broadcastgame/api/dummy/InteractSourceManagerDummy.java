package com.bytedance.android.live.broadcastgame.api.dummy;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractSourceManager;
import com.bytedance.android.livesdk.gecko.j;
import com.bytedance.android.livesdk.gecko.o;
import io.reactivex.Observable;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J4\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/dummy/InteractSourceManagerDummy;", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/IInteractSourceManager;", "Lcom/bytedance/android/livesdk/gecko/o;", "client", "", "setTC21GeckoClient", "", "accessKey", "channel", "localJsSdkVersion", "sourceFile", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdk/gecko/j$b;", "updateOpenPlatformJsSdk", "<init>", "()V", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractSourceManagerDummy implements IInteractSourceManager {
    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractSourceManager
    public void setTC21GeckoClient(o r1) {
    }

    public InteractSourceManagerDummy() {
        k.l(IInteractSourceManager.class, this);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractSourceManager
    public Observable<j.b> updateOpenPlatformJsSdk(String r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "accessKey");
        return Observable.error(new Throwable("can't create downloader"));
    }
}
