package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.net.urlconnection.MessageLoop;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
public class DnsQuery {
    static final String LOG_TAG = "DnsQuery";
    private String mHostName;
    private MessageLoop mMessageLoop;
    private String[] mQueryResult;
    private int mStatus;

    public DnsQuery(String r8) {
        this.mStatus = 0;
        this.mHostName = r8;
        this.mMessageLoop = new MessageLoop();
    }

    public void done() {
        this.mMessageLoop.quit();
    }

    public String getHostName() {
        return this.mHostName;
    }

    public List<InetAddress> getResult() {
        if (this.mStatus != 0) goto L20;
        String[] r8 = this.mQueryResult;
        if (r8 == null) goto L20;
        if (r8.length == 0) goto L20;
        ArrayList r10 = new ArrayList();
        String[] r11 = this.mQueryResult;
        int r12 = r11.length;
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L15;
        byte[] r14 = InetAddress.getByName(r11[r13]).getAddress();
        if (r14 == null) goto L13;
        r10.add(InetAddress.getByAddress(this.mHostName, r14));
    L13:
        r13 = r13 + 1;
        goto L9
    L15:
        if (r10.isEmpty() == true) goto L18;
        return r10;
    L18:
        throw new UnknownHostException(this.mHostName);
    L20:
        throw new UnknownHostException(this.mHostName);
    }

    public void resume(Runnable r8) {
        this.mMessageLoop.execute(r8);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(LOG_TAG, "Exception DnsQuery resume ", new Object[]{e});
    }

    public void setResult(int r8, String[] r10) {
        this.mStatus = r8;
        this.mQueryResult = r10;
    }

    public void waitResult() {
        this.mMessageLoop.loop();
    }
}
