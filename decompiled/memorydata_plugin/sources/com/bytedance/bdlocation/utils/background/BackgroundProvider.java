package com.bytedance.bdlocation.utils.background;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BackgroundProvider {
    private volatile boolean isEnterBackground;
    private List<Callback> mCallback;

    public interface Callback {
        void onAppBackgroundSwitch(boolean r1);
    }

    public BackgroundProvider() {
        this.mCallback = new ArrayList();
        this.isEnterBackground = true;
    }

    public void addCallback(Callback r3) {
        Callback r4 = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin");
        List<Callback> r2 = this.mCallback;
        if (r2 == null) goto L6;
        r2.add(r4);
        return;
    }

    public List<Callback> getCallback() {
        return this.mCallback;
    }

    public boolean isBackground() {
        return this.isEnterBackground;
    }

    public void onAppBackgroundSwitch(boolean r5) {
        this.isEnterBackground = r5;
        List<Callback> r0 = this.mCallback;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= 0) goto L17;
        int r1 = 0;
    L8:
        if (r1 >= this.mCallback.size()) goto L18;
        if (this.mCallback.get(r1) == null) goto L12;
        ((Callback) ZeusTransformUtils.preCheckCast(this.mCallback.get(r1), Callback.class, "com.obric.memorydata.plugin")).onAppBackgroundSwitch(r5);
    L12:
        r1 = r1 + 1;
        goto L8
    L18:
        return;
    }

    public void setCallback(List<Callback> r3) {
        List<Callback> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.mCallback = r4;
        return;
    }
}
