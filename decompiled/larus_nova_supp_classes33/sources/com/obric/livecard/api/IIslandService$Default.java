package com.obric.livecard.api;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class IIslandService$Default implements IIslandService {
    public IIslandService$Default() {
    }

    public void addIIslandStatusCallback(IIslandStatusCallback r1) throws RemoteException {
    }

    public void addOnTopCardChangedListener(ITopSessionChangedCallback r1) throws RemoteException {
    }

    public IBinder asBinder() {
        return null;
    }

    public void collapseNotificationPanel() throws RemoteException {
    }

    public void createSession(IslandSession r1, String r2, IIslandCardCallback r3) throws RemoteException {
    }

    public void destroySession(IslandSession r1) throws RemoteException {
    }

    public void doCollapse() throws RemoteException {
    }

    public Bundle getIslandVersion() throws RemoteException {
        return null;
    }

    public Bundle getPriority(IslandSession r1) throws RemoteException {
        return null;
    }

    public void onLauncherFocused() throws RemoteException {
    }

    public void onNotificationVisible(boolean r1) throws RemoteException {
    }

    public void onSysUIFlagsChanged(long r1) throws RemoteException {
    }

    public void onVolumeButtonClick() throws RemoteException {
    }

    public void refreshScene(IslandSession r1) throws RemoteException {
    }

    public void removeIIslandStatusCallback(IIslandStatusCallback r1) throws RemoteException {
    }

    public void removeOnTopCardChangedListener(ITopSessionChangedCallback r1) throws RemoteException {
    }

    public void sendEvent(IslandSession r1, IslandWidget r2, String r3, String r4) throws RemoteException {
    }

    public void setKeyguardLocked(boolean r1) throws RemoteException {
    }

    public void setPriority(IslandSession r1) throws RemoteException {
    }

    public void setVisible(boolean r1) throws RemoteException {
    }

    public void tryExpand(IslandSession r1, boolean r2) throws RemoteException {
    }

    public void updateAudioAmplitude(IslandSession r1, float r2) throws RemoteException {
    }

    public void updateSessionFlags(IslandSession r1) throws RemoteException {
    }

    public void updateWidget(IslandSession r1, IslandWidget r2) throws RemoteException {
    }

    public void updateWidgetAnimation(IslandSession r1, IslandWidget r2) throws RemoteException {
    }
}
