package com.ss.android.lark.contact.base.contact_list.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.basic.v1.CertificateStatus;
import com.bytedance.lark.pb.basic.v1.CertificationInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.contact.base.viewholder.ContactsHomeItemViewHolder;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.utils.UIHelper;
import com.suite.lark.platform.component.widget_biz_tenantname.data.TenantCertificationData;
import com.suite.lark.platform.component.widget_biz_userstatus.UserStatusLinearLayout;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ExternalContactAdapter2 extends IndexRecyclerViewAdapter<ContactsHomeItemViewHolder, w8b.a> {
    public Context d;
    public a e;

    public interface a {
    }

    public ExternalContactAdapter2() {
    }

    public final void onAttachedToRecyclerView(RecyclerView r1) {
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onAttachedToRecyclerView(r1);
        this.d = r1.getContext();
    }

    @Override // com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter
    public final Map<Integer, String> z2(List<? extends w8b.a> r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r6.size() == 0) goto L5;
        r0.put(0, ((w8b.a) ListProtector.get(r6, 0)).b());
        int r1 = 1;
    L8:
        if (r1 >= r6.size()) goto L13;
        w8b.a r2 = (w8b.a) ListProtector.get(r6, r1 - 1);
        w8b.a r3 = (w8b.a) ListProtector.get(r6, r1);
        if (r2.b().equalsIgnoreCase(r3.b()) == true) goto L12;
        r0.put(Integer.valueOf(r1), r3.b());
    L12:
        r1 = r1 + 1;
        goto L8
    L13:
        return r0;
    L5:
        return new HashMap();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        ContactsHomeItemViewHolder r10 = (ContactsHomeItemViewHolder) r8;
        final w8b.a r11 = (w8b.a) getItem(r9);
        if (TextUtils.isEmpty(r11.m) == false) goto L5;
        String r0 = r11.a;
    L6:
        String r1 = r11.i;
        if (TextUtils.isEmpty(r1) == true) goto L9;
        r10.contactNameTV.setText(r1);
    L10:
        String r2 = r11.c;
        r10.contactNameTV.setMaxLines(1);
        r10.contactNameTV.setEllipsize(TextUtils.TruncateAt.END);
        r10.contactTenantTV.setTenantNameData(new gpc.a(r2, r11.g, true, r11.e));
        CertificationInfo r3 = r11.n;
        if (r3 == null) goto L15;
        CertificateStatus r4 = r3.certificate_status;
        if (r4 == null) goto L15;
        r10.contactTenantTV.setTenantCertificationData(new TenantCertificationData(r3.is_show_cert_sign, TenantCertificationData.CertificateStatus.fromValue(Integer.valueOf(r4.getValue())), null));
    L16:
        int r5 = UIHelper.dp2px(48.0f);
        Context r6 = this.d;
        LKUIRoundedImageView2 r7 = r10.contactAvatar;
        String r12 = r11.d;
        String r13 = r11.e;
        LoadParams r14 = new LoadParams();
        r14.a = r5;
        r14.b = r5;
        ImageModule.a(r6, r7, r12, r13, r14);
        r10.checkBox.setVisibility(8);
        ChatterDescription r15 = r11.h;
        if (r15 != null) goto L19;
    L22:
        r10.contactUserStatus.setVisibility(8);
    L23:
        r10.contactLayout.setOnClickListener(new b(this, r11));
        r10.contactLayout.setOnLongClickListener(new com.ss.android.lark.contact.base.contact_list.view.a(this, r11));
        r10.deleteBtn.setOnClickListener(new c(this, r11));
        UIUtils.display(r10.specialFocusView, r11.l);
        return;
    L19:
        if (TextUtils.isEmpty(r15.description) == true) goto L22;
        r10.contactUserStatus.setVisibility(0);
        r10.contactUserStatus.setTextColor(this.d.getResources().getColor(2131106620));
        UserStatusLinearLayout r16 = r10.contactUserStatus;
        String r17 = r11.h.description;
        Context r18 = this.d;
        hpc.b r19 = hpc.b.b();
        r11.h.type.getNumber();
        r19.getClass();
        Drawable r20 = UIUtils.getDrawable(r18, 2131238071);
        r16.a.setImageDrawable(r20);
        r16.b.G(r17, null);
        r16.c = r17;
    L15:
        r10.contactTenantTV.setTenantCertificationData(null);
        goto L16
    L9:
        r10.contactNameTV.setText(r0);
        goto L10
    L5:
        r0 = r11.m;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        View r5 = LayoutInflater.from(this.d).inflate(2131558471, r3, false);
        if ((r5.findViewById(2131367717).getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r5.findViewById(2131367717).getLayoutParams()).setMarginEnd(UIUtils.dp2px(this.d, 27.0f));
    L6:
        return new ContactsHomeItemViewHolder(r5);
    }
}
