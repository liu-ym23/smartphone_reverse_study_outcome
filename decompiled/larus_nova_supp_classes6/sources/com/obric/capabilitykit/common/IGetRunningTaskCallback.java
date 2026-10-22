package com.obric.capabilitykit.common;

import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IGetRunningTaskCallback extends IInterface {
    void onResult(String r1) throws RemoteException;
}
