package q9b;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.contact.impl.group.ContactsMyGroupView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i extends FragmentPagerAdapter {
    public final /* synthetic */ ContactsMyGroupView a;

    public final int getCount() {
        return this.a.d.size();
    }

    public final Fragment getItem(int r2) {
        return ((com.ss.android.lark.base.fragment.a) ListProtector.get(this.a.d, r2)).a;
    }

    public final CharSequence getPageTitle(int r2) {
        return ((com.ss.android.lark.base.fragment.a) ListProtector.get(this.a.d, r2)).b;
    }

    public i(ContactsMyGroupView r1, FragmentManager r2) {
        this.a = r1;
        super(r2);
    }
}
