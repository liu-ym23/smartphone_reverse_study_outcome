package com.bytedance.android.btm.api.model;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class PageFinder {
    public String btmPageId;
    public Fragment fragment;
    public Object page;
    public View view;

    public boolean isEmpty() {
        if (this.page == null) goto L5;
    L11:
        return false;
    L5:
        if (this.view != null) goto L11;
        if (this.fragment != null) goto L11;
        if (TextUtils.isEmpty(this.btmPageId) == false) goto L11;
        return true;
    }

    public PageFinder() {
        this.btmPageId = null;
        this.page = null;
        this.view = null;
        this.fragment = null;
    }

    public static PageFinder via(View r1) {
        PageFinder r0 = new PageFinder();
        r0.view = r1;
        return r0;
    }

    public static PageFinder via(Fragment r1) {
        PageFinder r0 = new PageFinder();
        r0.fragment = r1;
        return r0;
    }

    public static PageFinder via(Object r1) {
        PageFinder r0 = new PageFinder();
        r0.page = r1;
        return r0;
    }

    public static PageFinder via(String r1) {
        PageFinder r0 = new PageFinder();
        r0.btmPageId = r1;
        return r0;
    }
}
