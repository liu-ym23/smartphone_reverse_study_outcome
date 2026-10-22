package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.live.IBarrageLauncher;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.view.IFakeDiggView;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.DiggService")
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002H&J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH&J\u001c\u0010\u0012\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J \u0010\u0019\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H&¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IDiggService;", "Lcom/bytedance/android/livesdk/interactivity/api/IBaseDiggService;", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getDiggWidgetClass", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", BuildConfig.FLAVOR, "count", BuildConfig.FLAVOR, "sendDiggMessage", "Landroid/content/Context;", "context", "Lcom/bytedance/android/livesdkapi/view/IFakeDiggView;", "getFakeDiggView", "Landroid/view/ViewGroup;", "container", "Lcom/bytedance/android/livesdkapi/depend/live/IBarrageLauncher;", "provideDiggBarrageLauncher", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/l;", "publicScreenContext", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "roomContext", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "loadInPublicScreenContext", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IDiggService extends IBaseDiggService {
    Class<? extends LiveRecyclableWidget> getDiggWidgetClass();

    IFakeDiggView getFakeDiggView(Context r1);

    void loadInPublicScreenContext(com.bytedance.android.livesdk.interactivity.api.publicscreen.l r1, RoomContext r2, DataCenter r3);

    IBarrageLauncher provideDiggBarrageLauncher(Context r1, ViewGroup r2);

    void sendDiggMessage(Room r1, int r2);
}
