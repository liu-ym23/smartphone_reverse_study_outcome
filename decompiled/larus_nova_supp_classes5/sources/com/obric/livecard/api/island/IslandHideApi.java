package com.obric.livecard.api.island;

import com.obric.livecard.api.IIslandService;
import com.obric.livecard.api.impl.IslandStatusCallback;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\tH&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u0015"}, d2 = {"Lcom/obric/livecard/api/island/IslandHideApi;", "", "addIslandStatusCallback", "", "callback", "Lcom/obric/livecard/api/impl/IslandStatusCallback;", "onLauncherFocused", "onNotificationVisible", "visible", "", "onSysUIFlagsChanged", "sysuiFlags", "", "onVolumeButtonClick", "registerIslandService", "service", "Lcom/obric/livecard/api/IIslandService;", "removeIslandStatusCallback", "setKeyguardLocked", "locked", "setVisible", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IslandHideApi {
    void addIslandStatusCallback(IslandStatusCallback r1);

    void onLauncherFocused();

    void onNotificationVisible(boolean r1);

    void onSysUIFlagsChanged(long r1);

    void onVolumeButtonClick();

    void registerIslandService(IIslandService r1);

    void removeIslandStatusCallback(IslandStatusCallback r1);

    void setKeyguardLocked(boolean r1);

    void setVisible(boolean r1);
}
