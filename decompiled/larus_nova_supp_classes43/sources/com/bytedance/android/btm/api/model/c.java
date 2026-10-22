package com.bytedance.android.btm.api.model;

import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public String a;
    public Boolean b;
    public int c;
    public final List<String> d;
    public PageFinder e;
    public ViewPager f;
    public int g;
    public boolean h;
    public int i;
    public Map<String, Object> j;
    public boolean k;

    public final boolean a() {
        Boolean r0 = this.b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public final String toString() {
        return "BtmItem(btm='" + this.a + "', _enterPage=" + this.b + ", enterPageTimes=" + this.c + ", targetPagesBtm=" + this.d + ", content=" + this.j + ", useTopPageWhenNotFindPage= " + this.k + ')';
    }

    public c() {
        this.a = "";
        this.c = 1;
        this.d = new ArrayList();
        this.e = new PageFinder();
        this.g = -1;
        this.i = 10;
        this.j = new LinkedHashMap();
    }
}
