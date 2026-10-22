package com.sdk.bwdl.StateMachine;

import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
public interface IBWDLState {
    public static final boolean HANDLED = true;
    public static final boolean NOT_HANDLED = false;

    void enter();

    void exit();

    boolean processMessage(Message r8);
}
