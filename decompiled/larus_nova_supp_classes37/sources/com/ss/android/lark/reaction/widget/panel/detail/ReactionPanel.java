package com.ss.android.lark.reaction.widget.panel.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class ReactionPanel extends LinearLayout implements t2c.a {
    public View a;

    public class FacePagerAdapter extends PagerAdapter {
        public final boolean isViewFromObject(View r1, Object r2) {
            if (r1 != r2) goto L4;
            return true;
        L4:
            return false;
        }

        public final int getCount() {
            throw null;
        }

        public final int getItemPosition(Object r1) {
            return super.getItemPosition(r1);
        }

        public final Object instantiateItem(View r1, int r2) {
            ViewPager r3 = (ViewPager) r1;
            throw null;
        }

        public final void destroyItem(View r1, int r2, Object r3) {
            ViewPager r4 = (ViewPager) r1;
            throw null;
        }
    }

    public interface a {
    }

    public void setPageCount(int r1) {
    }

    public void setReactionSelectListener(t2c.a r1) {
    }

    public void setShowMoreBgColor(int r1) {
    }

    public void setWindowTokenProvider(a r1) {
    }

    public ReactionPanel(Context r1) {
        super(r1);
        a(r1);
    }

    public final void a(Context r3) {
        LayoutInflater.from(r3).inflate(2131563393, this, true);
        this.a = findViewById(2131384813);
        ViewPager r4 = findViewById(2131373270);
        ((LinearLayout) findViewById(2131373271)).setClickable(true);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r1) {
        return super.onTouchEvent(r1);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r2) {
        this.a.setBackgroundColor(r2);
    }

    public ReactionPanel(Context r1, AttributeSet r2) {
        super(r1, r2);
        a(r1);
    }

    public ReactionPanel(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a(r1);
    }
}
