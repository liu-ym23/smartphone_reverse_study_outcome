package o81;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.n;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a {
    n<? extends Unit> getOnWidgetLoad();

    n<? extends IRoom> getOnWidgetRoomEnter();

    n<? extends Unit> getOnWidgetUnload();

    n<? extends Unit> getOnWidgetViewPrepared();

    void notifyWidgetLoad();

    void notifyWidgetRoomEnter(IRoom r1);

    void notifyWidgetUnload();

    void notifyWidgetViewPrepared();
}
