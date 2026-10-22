package com.ss.android.lark.contact.base.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.suite.lark.platform.component.widget_biz_tenantname.TenantNameTextView;
import com.suite.lark.platform.component.widget_biz_userstatus.UserStatusLinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ContactsHomeItemViewHolder_ViewBinding implements Unbinder {
    public ContactsHomeItemViewHolder a;

    public final void unbind() {
        ContactsHomeItemViewHolder r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.userInfoLayoutWrapper = null;
        r0.contactLayout = null;
        r0.contactAvatar = null;
        r0.contactNameTV = null;
        r0.contactTenantTV = null;
        r0.contactUserStatus = null;
        r0.checkBox = null;
        r0.btnLayout = null;
        r0.deleteBtn = null;
        r0.specialFocusView = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public ContactsHomeItemViewHolder_ViewBinding(ContactsHomeItemViewHolder r4, View r5) {
        this.a = r4;
        r4.userInfoLayoutWrapper = (LinearLayout) Utils.findRequiredViewAsType(r5, 2131377670, "field 'userInfoLayoutWrapper'", LinearLayout.class);
        r4.contactLayout = (RelativeLayout) Utils.findRequiredViewAsType(r5, 2131367717, "field 'contactLayout'", RelativeLayout.class);
        r4.contactAvatar = (LKUIRoundedImageView2) Utils.findRequiredViewAsType(r5, 2131367709, "field 'contactAvatar'", LKUIRoundedImageView2.class);
        r4.contactNameTV = (TextView) Utils.findRequiredViewAsType(r5, 2131367719, "field 'contactNameTV'", TextView.class);
        r4.contactTenantTV = (TenantNameTextView) Utils.findRequiredViewAsType(r5, 2131367726, "field 'contactTenantTV'", TenantNameTextView.class);
        r4.contactUserStatus = (UserStatusLinearLayout) Utils.findRequiredViewAsType(r5, 2131367727, "field 'contactUserStatus'", UserStatusLinearLayout.class);
        r4.checkBox = (UDCheckBox) Utils.findRequiredViewAsType(r5, 2131385785, "field 'checkBox'", UDCheckBox.class);
        r4.btnLayout = Utils.findRequiredView(r5, 2131364748, "field 'btnLayout'");
        r4.deleteBtn = Utils.findRequiredView(r5, 2131368785, "field 'deleteBtn'");
        r4.specialFocusView = Utils.findRequiredView(r5, 2131376626, "field 'specialFocusView'");
    }
}
