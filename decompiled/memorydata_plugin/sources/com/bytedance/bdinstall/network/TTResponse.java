package com.bytedance.bdinstall.network;

import android.util.Pair;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TTResponse {
    private final String body;
    private final List<Pair<String, String>> headers;
    private final int status;
    private final String url;

    public TTResponse(String r3, int r4, List<Pair<String, String>> r5, String r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.url = r3;
        this.status = r4;
        if (r7 != null) goto L5;
        List<Pair<String, String>> r8 = r3;
        ArrayList r9 = new ArrayList();
    L6:
        this.headers = r8;
        this.body = r6;
        return;
    L5:
        ArrayList r10 = new ArrayList(r7);
        r8 = Collections.unmodifiableList(r9);
        r9 = r10;
        goto L6
    }

    public String getBody() {
        return this.body;
    }

    public List<Pair<String, String>> getHeaders() {
        return this.headers;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUrl() {
        return this.url;
    }

    public List<Pair<String, String>> headers(String r6) {
        ArrayList r0 = null;
        if (r6 == null) goto L15;
        List<Pair<String, String>> r5 = this.headers;
        if (r5 == null) goto L15;
        Iterator<Pair<String, String>> r7 = r5.iterator();
    L9:
        if (r7.hasNext() == false) goto L15;
        Pair r1 = (Pair) ZeusTransformUtils.preCheckCast(r7.next(), Pair.class, "com.obric.memorydata.plugin");
        if (r6.equalsIgnoreCase((String) ZeusTransformUtils.preCheckCast(r1.first, String.class, "com.obric.memorydata.plugin")) == false) goto L9;
        if (r0 != null) goto L14;
        r0 = new ArrayList();
    L14:
        r0.add(r1);
    L15:
        return r0;
    }

    public boolean isSuccessful() {
        int r1 = this.status;
        if (r1 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r1 >= 300) goto L7;
        return true;
    }

    public String toString() {
        return "DeviceResponse{\n body=" + this.body + "\n headers=" + this.headers + "\n code=" + this.status + "\n url='" + this.url + "'}";
    }
}
