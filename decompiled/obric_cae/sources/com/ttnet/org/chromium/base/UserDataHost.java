package com.ttnet.org.chromium.base;

import android.os.Process;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class UserDataHost {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long mThreadId;
    private HashMap<Class<? extends UserData>, UserData> mUserDataMap;

    public UserDataHost() {
        this.mThreadId = Process.myTid();
        this.mUserDataMap = new HashMap();
    }

    private void checkThreadAndState() {
    }

    public void destroy() {
        checkThreadAndState();
        HashMap<Class<? extends UserData>, UserData> r8 = this.mUserDataMap;
        this.mUserDataMap = null;
        Iterator<UserData> r10 = r8.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().destroy();
        goto L4
    }

    public <T extends UserData> T getUserData(Class<T> r8) {
        checkThreadAndState();
        return r8.cast(this.mUserDataMap.get(r8));
    }

    public <T extends UserData> T removeUserData(Class<T> r8) {
        checkThreadAndState();
        return r8.cast(this.mUserDataMap.remove(r8));
    }

    public <T extends UserData> T setUserData(Class<T> r8, T r10) {
        checkThreadAndState();
        this.mUserDataMap.put(r8, r10);
        return (T) getUserData(r8);
    }
}
