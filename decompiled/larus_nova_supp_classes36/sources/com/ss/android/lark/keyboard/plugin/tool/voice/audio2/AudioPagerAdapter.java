package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AudioPagerAdapter extends PagerAdapter {
    public final List<View> a;
    public final List<String> b;

    public final boolean isViewFromObject(View r1, Object r2) {
        if (r1 != r2) goto L4;
        return true;
    L4:
        return false;
    }

    public final int getCount() {
        return this.a.size();
    }

    public final CharSequence getPageTitle(int r2) {
        return (CharSequence) ListProtector.get(this.b, r2);
    }

    public AudioPagerAdapter(List r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object instantiateItem(ViewGroup r2, int r3) {
        View r4 = (View) ListProtector.get(this.a, r3);
        r2.addView(r4);
        return r4;
    }

    public final void destroyItem(ViewGroup r1, int r2, Object r3) {
        r1.removeView((View) r3);
    }
}
