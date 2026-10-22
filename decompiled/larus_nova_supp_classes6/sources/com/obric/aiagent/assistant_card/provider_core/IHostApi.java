package com.obric.aiagent.assistant_card.provider_core;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IHostApi extends IInterface {
    void callMethod(String r1, Bundle r2) throws RemoteException;

    void notifyCardChanged(Bundle r1) throws RemoteException;
}
