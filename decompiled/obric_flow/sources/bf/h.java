package bf;

import android.content.Context;
import com.bytedance.ies.xelement.viewpager.viewpager.CustomViewPagerNG;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import xe.i;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends i {
    public Boolean H;

    public h(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        new LinkedHashMap();
        super(new CustomViewPagerNG(r5), r5);
        this.H = Boolean.FALSE;
    }

    public final void setForceCanScroll(boolean r5) {
        ((CustomViewPagerNG) getMViewPager()).setMForceCanScroll(r5);
    }

    public final void setPagerChangeAnimation(boolean r5) {
        ((CustomViewPagerNG) getMViewPager()).setMPagerChangeAnimation(r5);
    }

    @Override // xe.i
    public void setTabBarElementAdded(boolean r5) {
        this.H = Boolean.valueOf(r5);
    }

    public final void setViewPagerOverScrollMode(boolean r5) {
        if (r5 == false) goto L5;
        ((CustomViewPagerNG) getMViewPager()).setOverScrollMode(0);
        return;
    L5:
        ((CustomViewPagerNG) getMViewPager()).setOverScrollMode(2);
    }
}
