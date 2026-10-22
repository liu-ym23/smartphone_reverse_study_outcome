package qe;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.ies.xelement.banner.Banner;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Banner f21504a;

    public b(Banner r5) {
        this.f21504a = r5;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r5, int r10, Object r11) {
        r5.removeView((View) r11);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        Banner r5 = this.f21504a;
        if (r5.f6381o == false) goto L7;
        return r5.f6371a;
    L7:
        return r5.F.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object r5) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final float getPageWidth(int r5) {
        Banner r10 = this.f21504a;
        if (r10.f6379m.equals("multi-pages") == false) goto L10;
        int r11 = r10.f6390y;
        if (r11 != 0) goto L8;
        return 1.0f;
    L8:
        return r10.f6378l / r11;
    L10:
        if (r10.f6379m.equals("carousel") == false) goto L13;
        return 0.8f;
    L13:
        return 1.0f;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r5, int r10) {
        Banner r11 = this.f21504a;
        int r12 = r11.e(r10);
        if (r11.F.size() != 0) goto L5;
        View r13 = new View(r11.getContext());
    L25:
        r5.addView(r13);
        return r13;
    L5:
        LynxUI r14 = (LynxUI) r11.F.get(r12);
        View r15 = r14.getView();
        FrameLayout r16 = new FrameLayout(r11.getContext());
        if ((r15 instanceof ViewGroup) == false) goto L13;
        if (r14.getOverflow() != 0) goto L10;
        boolean r17 = true;
    L11:
        r16.setClipChildren(r17);
        goto L13
    L10:
        r17 = false;
    L13:
        if ((r15.getParent() instanceof ViewGroup) == false) goto L16;
        ((ViewGroup) r15.getParent()).removeView(r15);
    L16:
        if (r11.E == false) goto L18;
        r15.setTag("swiper_lynx_view_tag");
    L18:
        r16.addView(r15);
        View r18 = new View(r11.getContext());
        r16.addView(r18, new FrameLayout.LayoutParams(-1, -1));
        if (r11.f6384r == true) goto L22;
        r18.setBackgroundColor(r11.f6385t);
        r18.setTag("swiper_item_mask_tag");
    L22:
        if (r11.E == false) goto L24;
        r16.setTag(Integer.valueOf(r10));
    L24:
        r13 = r16;
        goto L25
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r5, Object r10) {
        if (r5 != r10) goto L5;
        return true;
    L5:
        return false;
    }
}
