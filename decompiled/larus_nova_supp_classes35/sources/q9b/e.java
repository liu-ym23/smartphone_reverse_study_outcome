package q9b;

import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.mvp.BaseModel;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.contact.impl.group.join.MyJoinGroupFragment;
import com.ss.android.lark.contact.impl.group.manage.MyManageGroupFragment;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends BaseModel implements k {
    public final m a;

    public e(d r1) {
        this.a = r1;
    }

    @Override // q9b.k
    public final List B7(FragmentActivity r6) {
        ArrayList r0 = new ArrayList();
        MyManageGroupFragment r1 = new MyManageGroupFragment();
        r1.g = this.a;
        MyJoinGroupFragment r2 = new MyJoinGroupFragment();
        r2.e = this.a;
        r0.add(new com.ss.android.lark.base.fragment.a(r1, UIUtils.getString(r6, 2131890859)));
        r0.add(new com.ss.android.lark.base.fragment.a(r2, UIUtils.getString(r6, 2131891796)));
        return r0;
    }
}
