package com.bytedance.android.livesdk.ktvapi;

import androidx.lifecycle.ViewModelStore;
import bn0.b;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.chatroom.widget.f0;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/HolderRoomWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "Lcom/bytedance/android/livesdk/chatroom/widget/f0;", "<init>", "()V", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public class HolderRoomWidget extends MiddlewareRoomWidget implements ViewModelStoreOwnerCompat, f0 {
    public final ViewModelStore a;
    public b b;
    public final ConcurrentHashMap<Class<? extends dn0.b>, dn0.b> c;

    public final /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.-CC.$default$getViewModelStore(this);
    }

    public void onDestroy() {
        this.a.clear();
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
    }

    public HolderRoomWidget() {
        this.a = new ViewModelStore();
        this.c = new ConcurrentHashMap();
    }

    public final ViewModelStore tf() {
        return this.a;
    }

    public final void setMultiLinkRoomScope(b r1) {
        this.b = r1;
    }
}
