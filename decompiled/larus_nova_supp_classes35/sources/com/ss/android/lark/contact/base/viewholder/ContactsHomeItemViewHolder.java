package com.ss.android.lark.contact.base.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.suite.lark.platform.component.widget_biz_tenantname.TenantNameTextView;
import com.suite.lark.platform.component.widget_biz_userstatus.UserStatusLinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ContactsHomeItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(8636)
    public View btnLayout;

    @BindView(9380)
    public UDCheckBox checkBox;

    @BindView(8702)
    public LKUIRoundedImageView2 contactAvatar;

    @BindView(8705)
    public RelativeLayout contactLayout;

    @BindView(8706)
    public TextView contactNameTV;

    @BindView(8708)
    public TenantNameTextView contactTenantTV;

    @BindView(8709)
    public UserStatusLinearLayout contactUserStatus;

    @BindView(8738)
    public View deleteBtn;

    @BindView(8985)
    public View specialFocusView;

    @BindView(9019)
    public LinearLayout userInfoLayoutWrapper;

    public ContactsHomeItemViewHolder(View r1) {
        super(r1);
        ButterKnife.bind(this, r1);
    }
}
