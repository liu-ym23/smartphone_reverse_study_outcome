package q9b;

import android.view.View;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.contact.impl.group.ContactsMyGroupView;
import com.ss.android.lark.ui.IActionTitlebar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h extends IActionTitlebar.TextAction {
    public final /* synthetic */ ContactsMyGroupView a;

    public final void performAction(View r2) {
        super/*com.ss.android.lark.ui.IActionTitlebar.BaseAction*/.performAction(r2);
        ContactBaseModuleDependency.b.openCreateGroupChat(this.a.a);
    }

    public h(ContactsMyGroupView r1, String r2) {
        this.a = r1;
        super(r2, 2131106616);
    }
}
