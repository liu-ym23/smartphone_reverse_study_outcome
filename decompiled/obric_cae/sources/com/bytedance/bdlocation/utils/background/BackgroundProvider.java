package com.bytedance.bdlocation.utils.background;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BackgroundProvider {
    private volatile boolean isEnterBackground;
    private List<Callback> mCallback;

    public interface Callback {
        void onAppBackgroundSwitch(boolean r8);
    }

    public BackgroundProvider() {
        this.mCallback = new ArrayList();
        this.isEnterBackground = true;
    }

    public void addCallback(Callback r8) {
        List<Callback> r10 = this.mCallback;
        if (r10 == null) goto L6;
        r10.add(r8);
        return;
    }

    public List<Callback> getCallback() {
        return this.mCallback;
    }

    public boolean isBackground() {
        return this.isEnterBackground;
    }

    public void onAppBackgroundSwitch(boolean r8) {
        this.isEnterBackground = r8;
        List<Callback> r10 = this.mCallback;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.size() <= 0) goto L17;
        int r11 = 0;
    L8:
        if (r11 >= this.mCallback.size()) goto L18;
        if (this.mCallback.get(r11) == null) goto L12;
        this.mCallback.get(r11).onAppBackgroundSwitch(r8);
    L12:
        r11 = r11 + 1;
        goto L8
    L18:
        return;
    }

    public void setCallback(List<Callback> r8) {
        if (r8 == null) goto L5;
        this.mCallback = r8;
        return;
    }
}
