package com.ttnet.org.chromium.base;

import android.os.Process;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class UserDataHost {
    private final long mThreadId;
    private HashMap<Class<? extends UserData>, UserData> mUserDataMap;

    public UserDataHost() {
        this.mThreadId = Process.myTid();
        this.mUserDataMap = new HashMap();
    }

    private static void checkArgument(boolean r10) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("Neither key nor object of UserDataHost can be null.");
    }

    private void checkThreadAndState() {
        if (this.mThreadId != Process.myTid()) goto L10;
        if (this.mUserDataMap == null) goto L8;
        return;
    L8:
        throw new IllegalStateException("Operation is not allowed after destroy().");
    L10:
        throw new IllegalStateException("UserData must only be used on a single thread.");
    }

    public void destroy() {
        checkThreadAndState();
        HashMap<Class<? extends UserData>, UserData> r10 = this.mUserDataMap;
        this.mUserDataMap = null;
        Iterator<UserData> r11 = r10.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().destroy();
        goto L4
    }

    public <T extends UserData> T getUserData(Class<T> r10) {
        checkThreadAndState();
        if (r10 == null) goto L5;
        boolean r11 = true;
    L6:
        checkArgument(r11);
        return r10.cast(this.mUserDataMap.get(r10));
    L5:
        r11 = false;
        goto L6
    }

    public <T extends UserData> T removeUserData(Class<T> r10) {
        checkThreadAndState();
        if (r10 == null) goto L5;
        boolean r11 = true;
    L6:
        checkArgument(r11);
        if (this.mUserDataMap.containsKey(r10) == false) goto L11;
        return r10.cast(this.mUserDataMap.remove(r10));
    L11:
        throw new IllegalStateException("UserData for the key is not present.");
    L5:
        r11 = false;
        goto L6
    }

    public <T extends UserData> T setUserData(Class<T> r10, T r11) {
        checkThreadAndState();
        if (r10 == null) goto L6;
        if (r11 == null) goto L6;
        boolean r12 = true;
    L7:
        checkArgument(r12);
        this.mUserDataMap.put(r10, r11);
        return (T) getUserData(r10);
    L6:
        r12 = false;
        goto L7
    }
}
