package com.ss.android.lark.contact.base.contact_search;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.profile.entity.Profile;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.ViewUtils;
import com.ss.android.lark.widget.recyclerview.item.ItemViewHolder;
import com.suite.lark.platform.component.widget_biz_tenantname.TenantNameTextView;
import com.suite.lark.platform.component.widget_biz_tenantname.data.TenantCertificationData;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class v extends bec.a<v> {
    public static boolean h;
    public final Profile e;
    public final WeakReference<Fragment> f;
    public int g;

    public class a implements View.OnClickListener {
        public final /* synthetic */ v a;

        public a(v r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            ContactBaseModuleDependency r0 = ContactBaseModuleDependency.b;
            Activity r1 = ViewUtils.getActivityByView(r7);
            WeakReference<Fragment> r8 = this.a.f;
            if (r8 != null) goto L5;
            Fragment r9 = null;
        L6:
            Fragment r2 = r9;
            Profile r3 = this.a.e;
            w r10 = w.a.a;
            if (TextUtils.isEmpty(r10.a) == false) goto L10;
            int r4 = 0;
        L13:
            r0.jumpProfilePageForResult(r1, r2, r3, r4, 273);
            Statistics.sendEvent("invite_people_external_search_add", InvHitPoint.a());
            return;
        L10:
            if (r10.a.contains("@") == false) goto L12;
            r4 = 9;
            goto L13
        L12:
            r4 = 8;
            goto L13
        L5:
            r9 = r8.get();
            goto L6
        }
    }

    public v(WeakReference<Fragment> r2, Profile r3) {
        super(2131561568);
        this.g = -1;
        this.e = r3;
        this.f = r2;
    }

    public static void b(TextView r1, boolean r2) {
        if (r2 == false) goto L4;
        r1.setBackgroundResource(2131238313);
        r1.setTextColor(ContextCompat.getColor(r1.getContext(), 2131106521));
        return;
    L4:
        r1.setBackground(null);
        r1.setTextColor(ContextCompat.getColor(r1.getContext(), 2131106620));
    }

    public final void a(ItemViewHolder r11, int r12) {
        this.g = r12;
        ImageView r13 = (ImageView) r11.T3(2131375629);
        TextView r0 = (TextView) r11.T3(2131375632);
        TextView r1 = (TextView) r11.T3(2131375634);
        TenantNameTextView r2 = r11.T3(2131375633);
        com.ss.android.lark.utils.q.a(((RecyclerView.ViewHolder) r11).itemView);
        ((RecyclerView.ViewHolder) r11).itemView.setOnClickListener(new a(this));
        Context r14 = ((RecyclerView.ViewHolder) r11).itemView.getContext();
        String r3 = this.e.getAvatarKey();
        String r4 = this.e.getId();
        LoadParams r5 = new LoadParams();
        r5.a = UIHelper.dp2px(48.0f);
        r5.b = UIHelper.dp2px(48.0f);
        ListenerParams.a r6 = new ListenerParams.a();
        r6.d(Scene.Contact);
        r6.c(ListenerParams.FromType.AVATAR);
        r5.l = r6.b();
        ImageModule.a(r14, r13, r3, r4, r5);
        if (this.e.isFriend() == false) goto L6;
        b(r0, false);
        r0.setText(UIHelper.getString(2131892807));
    L12:
        r1.setText(com.ss.android.lark.chat.utils.m.d(this.e.getName(), this.e.getEnName(), this.e.getLocalizedName(), null, this.e.getAlias(), BuildConfig.FLAVOR, ChatterNameDisplayRule.ALIAS_NICKNAME_NAME));
        r2.setTenantNameData(new gpc.a(this.e.getTenant(), this.e.getTenantNameStatus(), this.e.isFriend(), this.e.getId()));
        if (this.e.getCertificationInfo() != null) goto L15;
        return;
    L15:
        if (this.e.getCertificationInfo().certificate_status == null) goto L19;
        r2.setTenantCertificationData(new TenantCertificationData(this.e.getCertificationInfo().is_show_cert_sign, TenantCertificationData.CertificateStatus.fromValue(Integer.valueOf(this.e.getCertificationInfo().certificate_status.getValue())), this.e.getCertificationInfo().tenant_certification_url));
        return;
    L19:
        return;
    L6:
        if (this.e.isRequestUserApplied() == false) goto L9;
        b(r0, false);
        r0.setText(UIHelper.getString(2131890559));
        goto L12
    L9:
        if (this.e.isTargetUserApplied() == false) goto L11;
        b(r0, true);
        r0.setText(UIHelper.getString(2131891504));
        goto L12
    L11:
        b(r0, true);
        r0.setText(UIHelper.getString(2131892806));
        goto L12
    }
}
