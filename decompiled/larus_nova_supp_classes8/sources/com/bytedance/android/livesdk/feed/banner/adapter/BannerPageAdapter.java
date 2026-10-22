package com.bytedance.android.livesdk.feed.banner.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.banner.a;
import com.bytedance.android.live.uikit.viewpager.AbsPagerAdapter;
import com.bytedance.android.livesdk.feed.l;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import pv1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class BannerPageAdapter extends AbsPagerAdapter {
    public final List<a> a;
    public final String b;
    public final l c;

    public final int getItemPosition(Object r1) {
        return -2;
    }

    public final int getCount() {
        List<a> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        if (((ArrayList) r0).size() <= 1) goto L10;
        return Integer.MAX_VALUE;
    L10:
        return ((ArrayList) this.a).size();
    }

    public final void destroyItem(ViewGroup r1, int r2, Object r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        View r4 = (View) r3;
        r1.removeView(r4);
        if (((AbsPagerAdapter) this).mScrapViews.size() >= ((ArrayList) this.a).size()) goto L7;
        ((AbsPagerAdapter) this).mScrapViews.add(r4);
    L7:
        unbindView(r4);
    }

    public final View getView(int r5, View r6, ViewGroup r7) {
        if (r6 != null) goto L5;
        r6 = ((AbsPagerAdapter) this).mInflater.inflate(2131566237, r7, false);
        b r1 = new b(r6, r7.getContext(), this.b, this.c);
        r6.setTag(r1);
    L6:
        List<a> r8 = this.a;
        if (r8 != null) goto L9;
    L23:
        return r6;
    L9:
        if (((ArrayList) r8).isEmpty() == true) goto L23;
        List<a> r9 = this.a;
        a r10 = (a) ListProtector.get(r9, r5 % ((ArrayList) r9).size());
        r1.h = r5 % ((ArrayList) this.a).size();
        r1.e = r10;
        if (r10 == null) goto L23;
        r1.c.setVisibility(8);
        String r11 = r10.e();
        if (r10.c() == null) goto L20;
        if (r10.c().getUrls() == null) goto L20;
        if (r10.c().getUrls().size() <= 0) goto L20;
        r1.a.setImageURI((String) ListProtector.get(r10.c().getUrls(), 0));
    L20:
        if (TextUtils.isEmpty(r11) == false) goto L22;
        r1.b.setVisibility(8);
        goto L23
    L22:
        r1.b.setVisibility(0);
        r1.b.setText(r11);
        goto L23
    L5:
        r1 = (b) r6.getTag();
        goto L6
    }

    public BannerPageAdapter(Context r1, LayoutInflater r2, String r3, l r4) {
        super(r1, r2);
        this.a = new ArrayList();
        this.b = r3;
        this.c = r4;
    }
}
