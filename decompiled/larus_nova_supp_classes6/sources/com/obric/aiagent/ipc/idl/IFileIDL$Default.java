package com.obric.aiagent.ipc.idl;

import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class IFileIDL$Default implements IFileIDL {
    public IFileIDL$Default() {
    }

    public IBinder asBinder() {
        return null;
    }

    public boolean deleteFile(FilePath r1) throws RemoteException {
        return false;
    }

    public List listAllFile(FilePath r1) throws RemoteException {
        return null;
    }

    public List listDir(FilePath r1) throws RemoteException {
        return null;
    }

    public ParcelFileDescriptor openFile(FilePath r1, int r2) throws RemoteException {
        return null;
    }
}
