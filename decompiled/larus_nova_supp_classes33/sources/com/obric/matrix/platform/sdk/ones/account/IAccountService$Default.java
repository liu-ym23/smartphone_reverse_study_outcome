package com.obric.matrix.platform.sdk.ones.account;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class IAccountService$Default implements IAccountService {
    public IAccountService$Default() {
    }

    public IBinder asBinder() {
        return null;
    }

    public void checkPassword(String r1, IAccountActionCallback r2) throws RemoteException {
    }

    public void forceUpdateAccount() throws RemoteException {
    }

    public void login(PendingIntent r1) throws RemoteException {
    }

    public void loginWithPassword(String r1, String r2, IAccountActionCallback r3) throws RemoteException {
    }

    public void logout(IAccountActionCallback r1) throws RemoteException {
    }

    public void quickLogin(String r1, String r2, IAccountActionCallback r3) throws RemoteException {
    }

    public void resetPassword(String r1, String r2, String r3, IAccountActionCallback r4) throws RemoteException {
    }

    public void sendCode(String r1, int r2, IAccountActionCallback r3) throws RemoteException {
    }

    public void setInitPassword(String r1, IAccountActionCallback r2) throws RemoteException {
    }

    public void ticketResetPassword(String r1, String r2, IAccountActionCallback r3) throws RemoteException {
    }

    public void updatePassword(String r1, String r2, IAccountActionCallback r3) throws RemoteException {
    }

    public void updateUserInfo(Bundle r1, String r2, IAccountActionCallback r3) throws RemoteException {
    }

    public void uploadAvatar(String r1, IAccountActionCallback r2) throws RemoteException {
    }

    public void verifyPassword(String r1, String r2, IAccountActionCallback r3) throws RemoteException {
    }

    public void verifyPasswordWithoutLogin(String r1, String r2, IAccountActionCallback r3) throws RemoteException {
    }

    public void verifySmsCode(String r1, String r2, int r3, IAccountActionCallback r4) throws RemoteException {
    }
}
