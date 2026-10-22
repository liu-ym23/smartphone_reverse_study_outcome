package com.ss.android.lark.contact.impl.group;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.ss.android.lark.ui.CommonTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ContactsMyGroupView_ViewBinding implements Unbinder {
    public ContactsMyGroupView a;

    public final void unbind() {
        ContactsMyGroupView r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mTitleBar = null;
        r0.mMyGroupVP = null;
        r0.mIndicator = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public ContactsMyGroupView_ViewBinding(ContactsMyGroupView r4, View r5) {
        this.a = r4;
        r4.mTitleBar = (CommonTitleBar) Utils.findRequiredViewAsType(r5, 2131388928, "field 'mTitleBar'", CommonTitleBar.class);
        r4.mMyGroupVP = (ViewPager) Utils.findRequiredViewAsType(r5, 2131374020, "field 'mMyGroupVP'", ViewPager.class);
        r4.mIndicator = (UDTabLayout) Utils.findRequiredViewAsType(r5, 2131375226, "field 'mIndicator'", UDTabLayout.class);
    }
}
