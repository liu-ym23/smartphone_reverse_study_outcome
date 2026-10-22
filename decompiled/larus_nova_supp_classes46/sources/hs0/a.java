package hs0;

import android.view.View;
import com.bytedance.android.live.player.ILivePlatformPlayerManagerAdapter;
import com.bytedance.android.livesdkapi.depend.player.ILivePlatformPlayerProxy;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements ILivePlatformPlayerManagerAdapter {
    public static final ILivePlatformPlayerManagerAdapter a = null;
    public static final a b = null;

    public a() {
    }

    static {
        b = new a();
        a = (ILivePlatformPlayerManagerAdapter) k.n(ILivePlatformPlayerManagerAdapter.class);
    }

    @Override // com.bytedance.android.live.player.ILivePlatformPlayerManagerAdapter
    public final ILivePlatformPlayerProxy curRoomPlayer() {
        return a.curRoomPlayer();
    }

    @Override // com.bytedance.android.live.player.ILivePlatformPlayerManagerAdapter
    public final ILivePlayerClient getCurrentClient() {
        return a.getCurrentClient();
    }

    @Override // com.bytedance.android.live.player.ILivePlatformPlayerManagerAdapter
    public final View getCurrentLivePlayerParent() {
        return a.getCurrentLivePlayerParent();
    }
}
