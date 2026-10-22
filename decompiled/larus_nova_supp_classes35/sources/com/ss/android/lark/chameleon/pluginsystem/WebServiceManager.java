package com.ss.android.lark.chameleon.pluginsystem;

import com.ss.android.lark.chameleon.idependency.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class WebServiceManager {
    private static final String TAG = "WebServiceManager";
    private Web mWeb;
    private List<WebService> mWebServices;

    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        Iterator<WebService> r0 = this.mWebServices.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        WebService r1 = r0.next();
        r0.remove();
        onDetachWebService(r1);
        goto L4
    L6:
        this.mWeb = null;
    }

    public void onWebBringToBackground() {
        Log.i(TAG, "onWebBringToBackground");
        Iterator<WebService> r0 = this.mWebServices.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onUserVisibleChanged(this.mWeb, false);
        goto L4
    }

    public void onWebBringToFront() {
        Log.i(TAG, "onWebBringToFront");
        Iterator<WebService> r0 = this.mWebServices.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onUserVisibleChanged(this.mWeb, true);
        goto L4
    }

    public WebServiceManager() {
        this.mWebServices = new ArrayList();
    }

    private void onAttachWebService(WebService r4) {
        if (this.mWeb != null) goto L6;
        Log.e(TAG, "onAttachWebService WEB NULL");
        return;
    L6:
        Log.i(TAG, "onAttachWebService:" + r4);
        r4.onAttachToWeb(this.mWeb);
    }

    private void onDetachWebService(WebService r4) {
        if (this.mWeb != null) goto L6;
        Log.e(TAG, "onDetachWebService WEB NULL");
        return;
    L6:
        Log.i(TAG, "onDetachWebService:" + r4);
        r4.onDetachFromWeb(this.mWeb);
    }

    public void addWebService(WebService r2) {
        if (this.mWebServices.contains(r2) == true) goto L6;
        this.mWebServices.add(r2);
        onAttachWebService(r2);
        return;
    }

    public <P extends WebService> P getWebService(Class<P> r4) {
        List<WebService> r0 = this.mWebServices;
        if (r0 == null) goto L11;
        if (r4 == null) goto L11;
        Iterator<WebService> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        P r2 = (P) r1.next();
        if (r2.getClass() != r4) goto L7;
        return r2;
    L11:
        Log.w(TAG, "WebService not found with type:" + r4);
        return null;
    }

    public void removeWebService(WebService r2) {
        if (this.mWebServices.remove(r2) == false) goto L6;
        onDetachWebService(r2);
        return;
    }

    public void onCreate(Web r3, List<WebService> r4) {
        Log.i(TAG, "onCreate");
        this.mWeb = r3;
        if (r4 == null) goto L8;
        Iterator<WebService> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        addWebService(r5.next());
        goto L6
    L10:
        return;
    }
}
