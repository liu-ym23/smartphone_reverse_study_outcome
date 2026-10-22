package n2c;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class o extends FragmentPagerAdapter {
    public final /* synthetic */ com.ss.android.lark.reaction.widget.detailwindow.a a;

    public final int getItemPosition(Object r1) {
        return -2;
    }

    public final int getCount() {
        return this.a.o.size();
    }

    public final Fragment getItem(int r2) {
        return ((o2c.a) ListProtector.get(this.a.o, r2)).a;
    }

    public final long getItemId(int r3) {
        return ((o2c.a) ListProtector.get(this.a.o, r3)).hashCode();
    }

    public o(com.ss.android.lark.reaction.widget.detailwindow.a r1, FragmentManager r2) {
        this.a = r1;
        super(r2);
    }
}
