package com.obric.cae.libs.statemachine;

import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public class State implements IState {
    public State() {
    }

    @Override // com.obric.cae.libs.statemachine.IState
    public void enter() {
    }

    @Override // com.obric.cae.libs.statemachine.IState
    public void exit() {
    }

    @Override // com.obric.cae.libs.statemachine.IState
    public String getName() {
        String r8 = getClass().getName();
        return r8.substring(r8.lastIndexOf(36) + 1);
    }

    @Override // com.obric.cae.libs.statemachine.IState
    public boolean processMessage(Message r8) {
        return false;
    }
}
