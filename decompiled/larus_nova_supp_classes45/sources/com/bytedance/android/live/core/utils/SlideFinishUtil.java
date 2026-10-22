package com.bytedance.android.live.core.utils;

import android.app.Activity;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.setting.SettingKey;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class SlideFinishUtil {
    public static SettingKey<Boolean> enableSlideFinish;
    static Set<Class<? extends Activity>> list;

    public static class SlideFinishPageChangeListener extends ViewPager.SimpleOnPageChangeListener {
        public final void onPageScrolled(int r1, float r2, int r3) {
        }
    }

    static {
        enableSlideFinish = new SettingKey("enable_slide_finish", Boolean.FALSE, "右滑退出页面");
        list = new HashSet();
    }

    private SlideFinishUtil() {
    }

    public static void disable(Activity r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        Class<?> r2 = r1.getClass();
        list.add((Class<? extends Activity>) r2);
    }
}
