package com.obric.cae.libs.statemachine;

import android.os.Message;

/* JADX INFO: loaded from: classes3.dex */
public class b implements a {
    public b() {
    }

    public void enter() {
    }

    public void exit() {
    }

    @Override // com.obric.cae.libs.statemachine.a
    public String getName() {
        String r1 = getClass().getName();
        return r1.substring(r1.lastIndexOf(36) + 1);
    }

    public boolean processMessage(Message r1) {
        return false;
    }
}
