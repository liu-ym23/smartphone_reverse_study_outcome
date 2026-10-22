package com.ss.android.lark.contact.base.contact_new.mvp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bytedance.lark.pb.basic.v1.CertificateStatus;
import com.bytedance.lark.pb.basic.v1.CertificationInfo;
import com.bytedance.lark.pb.basic.v1.TenantNameStatus;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.framework.callback.CallbackManager;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.utils.UIHelper;
import com.suite.lark.platform.component.widget_biz_tenantname.TenantNameTextView;
import com.suite.lark.platform.component.widget_biz_tenantname.data.TenantCertificationData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class NewContactAdapter extends LarkRecyclerViewBaseAdapter<NewContactViewHolder, NewContactView.a> {
    public Context a;
    public a b;
    public final CallbackManager c;

    public class NewContactViewHolder extends RecyclerView.ViewHolder {

        @BindView(8699)
        TextView confirmBtn;

        @BindView(8702)
        LKUIRoundedImageView2 newContactAvatar;

        @BindView(8703)
        TextView newContactExtraMessageTV;

        @BindView(8705)
        LinearLayout newContactLayout;

        @BindView(8706)
        TextView newContactNameTV;

        @BindView(8708)
        TenantNameTextView newContactTenantTV;

        public NewContactViewHolder(View r1) {
            super(r1);
            ButterKnife.bind(this, r1);
        }
    }

    public class NewContactViewHolder_ViewBinding implements Unbinder {
        public NewContactViewHolder a;

        public final void unbind() {
            NewContactViewHolder r0 = this.a;
            if (r0 == null) goto L7;
            this.a = null;
            r0.newContactLayout = null;
            r0.newContactAvatar = null;
            r0.newContactNameTV = null;
            r0.newContactTenantTV = null;
            r0.newContactExtraMessageTV = null;
            r0.confirmBtn = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public NewContactViewHolder_ViewBinding(NewContactViewHolder r4, View r5) {
            this.a = r4;
            r4.newContactLayout = (LinearLayout) Utils.findRequiredViewAsType(r5, 2131367717, "field 'newContactLayout'", LinearLayout.class);
            r4.newContactAvatar = (LKUIRoundedImageView2) Utils.findRequiredViewAsType(r5, 2131367709, "field 'newContactAvatar'", LKUIRoundedImageView2.class);
            r4.newContactNameTV = (TextView) Utils.findRequiredViewAsType(r5, 2131367719, "field 'newContactNameTV'", TextView.class);
            r4.newContactTenantTV = (TenantNameTextView) Utils.findRequiredViewAsType(r5, 2131367726, "field 'newContactTenantTV'", TenantNameTextView.class);
            r4.newContactExtraMessageTV = (TextView) Utils.findRequiredViewAsType(r5, 2131367714, "field 'newContactExtraMessageTV'", TextView.class);
            r4.confirmBtn = (TextView) Utils.findRequiredViewAsType(r5, 2131367647, "field 'confirmBtn'", TextView.class);
        }
    }

    public interface a {
    }

    public NewContactAdapter() {
        this.c = new CallbackManager();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r11, int r12) {
        NewContactViewHolder r13 = (NewContactViewHolder) r11;
        final NewContactView.a r0 = (NewContactView.a) getItem(r12);
        String r1 = r0.d;
        String r2 = r0.e;
        r13.newContactNameTV.setText(r1);
        TenantNameTextView r3 = r13.newContactTenantTV;
        TenantNameStatus r4 = r0.f;
        ChatApplication.Status r5 = r0.h;
        ChatApplication.Status r6 = ChatApplication.Status.AGREED;
        if (r5 != r6) goto L5;
        boolean r7 = true;
    L6:
        r3.setTenantNameData(new gpc.a(r2, r4, r7, r0.b));
        CertificationInfo r8 = r0.i;
        if (r8 == null) goto L11;
        CertificateStatus r9 = r8.certificate_status;
        if (r9 == null) goto L11;
        r13.newContactTenantTV.setTenantCertificationData(new TenantCertificationData(r8.is_show_cert_sign, TenantCertificationData.CertificateStatus.fromValue(Integer.valueOf(r9.getValue())), null));
    L12:
        int r10 = UIHelper.dp2px(40.0f);
        Context r14 = this.a;
        LKUIRoundedImageView2 r15 = r13.newContactAvatar;
        String r16 = r0.c;
        String r17 = r0.b;
        LoadParams r18 = new LoadParams();
        r18.a = r10;
        r18.b = r10;
        ImageModule.a(r14, r15, r16, r17, r18);
        ChatApplication.Status r19 = r0.h;
        if (r19 != ChatApplication.Status.PEDING) goto L15;
        r13.confirmBtn.setVisibility(0);
        r13.confirmBtn.setTextColor(UIHelper.getColor(2131105548));
        r13.confirmBtn.setBackground(UIHelper.getDrawable(2131233650));
        r13.confirmBtn.setText(UIHelper.getString(2131891504));
    L25:
        if (r19 != ChatApplication.Status.DELETED) goto L27;
        r13.newContactLayout.setVisibility(8);
    L27:
        r13.newContactExtraMessageTV.setText(r0.g);
        r13.confirmBtn.setOnClickListener(new d(this, r19, r0, r12));
        r13.newContactLayout.setOnClickListener(new e(this, r0));
        r13.newContactLayout.setOnLongClickListener(new c(this, r0));
        return;
    L15:
        if (r19 != r6) goto L17;
    L20:
        r13.confirmBtn.setVisibility(0);
        r13.confirmBtn.setBackground(null);
        r13.confirmBtn.setTextColor(UIHelper.getColor(2131106620));
        if (r19 != r6) goto L23;
        r13.confirmBtn.setText(UIHelper.getString(2131892427));
        goto L25
    L23:
        r13.confirmBtn.setText(UIHelper.getString(2131891780));
        goto L25
    L17:
        if (r19 == ChatApplication.Status.EXPIRED) goto L20;
        r13.confirmBtn.setVisibility(8);
    L11:
        r13.newContactTenantTV.setTenantCertificationData(null);
        goto L12
    L5:
        r7 = false;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Context r5 = r3.getContext();
        this.a = r5;
        return new NewContactViewHolder(LayoutInflater.from(r5).inflate(2131561628, r3, false));
    }
}
