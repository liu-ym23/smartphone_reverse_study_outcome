package q9b;

import androidx.viewpager.widget.ViewPager;
import com.ss.android.lark.contact.base.statistics.ContactHitPoint;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Lazy;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements ViewPager.OnPageChangeListener {
    public final void onPageScrollStateChanged(int r1) {
    }

    public final void onPageScrolled(int r1, float r2, int r3) {
    }

    public j() {
    }

    public final void onPageSelected(int r4) {
        if (r4 != 0) goto L6;
        Lazy r5 = ContactHitPoint.a;
        Statistics.sendEvent("contact_groups_category_click", new JSONObject().put("location", "created"));
        return;
    L6:
        if (r4 != 1) goto L10;
        Lazy r6 = ContactHitPoint.a;
        Statistics.sendEvent("contact_groups_category_click", new JSONObject().put("location", "joined"));
        return;
    }
}
