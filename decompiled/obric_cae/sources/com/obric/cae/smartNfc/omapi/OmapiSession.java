package com.obric.cae.smartNfc.omapi;

import android.se.omapi.Channel;
import android.se.omapi.Reader;
import android.se.omapi.Session;

/* JADX INFO: loaded from: classes2.dex */
public class OmapiSession implements AutoCloseable {
    private final Reader mReader;
    private final Session mSession;

    public OmapiSession(Reader r8, Session r10) {
        this.mReader = r8;
        this.mSession = r10;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.mSession.close();
    }

    public Reader getReader() {
        return this.mReader;
    }

    public Session getSession() {
        return this.mSession;
    }

    public Channel openLogicalChannel(byte[] r8) {
        return this.mSession.openLogicalChannel(r8);
    }
}
