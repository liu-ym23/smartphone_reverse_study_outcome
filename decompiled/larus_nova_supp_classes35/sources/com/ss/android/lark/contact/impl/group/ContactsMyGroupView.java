package com.ss.android.lark.contact.impl.group;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import q9b.f;
import q9b.g;
import q9b.h;
import q9b.i;
import q9b.j;
import q9b.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ContactsMyGroupView implements IView {
    public Context a;
    public a b;
    public final FragmentManager c;
    public final List<com.ss.android.lark.base.fragment.a> d;

    @BindView(8939)
    UDTabLayout mIndicator;

    @BindView(8854)
    ViewPager mMyGroupVP;

    @BindView(9526)
    CommonTitleBar mTitleBar;

    public interface a {
    }

    public final void destroy() {
        this.b = null;
    }

    public final void create() {
        ButterKnife.bind(this, ((ContactsMyGroupFragment.a) this.b).a.f);
        this.a = this.mTitleBar.getContext();
        this.mTitleBar.setTitle(2131892004);
        this.mTitleBar.setDividerVisible(false);
        this.mTitleBar.setVisibility(0);
        this.mTitleBar.setImmersive(true);
        this.mTitleBar.setLeftClickListener(new c(this));
        int r0 = com.ss.android.lark.contact.base.service.a.a;
        Intrinsics.checkNotNullParameter("contact.mygroup.redesign", "featureName");
        boolean r1 = FeatureGatingModule.getFeatureGatingService().isEnable("contact.mygroup.redesign");
        if (((ContactsMyGroupFragment.a) this.b).a.d == false) goto L6;
        if (r1 == false) goto L6;
        this.mTitleBar.addAction(new h(this, UIHelper.getString(2131891816)));
        this.mTitleBar.getRightText().setPadding(0, 0, UIUtils.dp2px(this.a, 16.0f), 0);
    L6:
        this.mMyGroupVP.setAdapter(new i(this, this.c));
        this.mMyGroupVP.addOnPageChangeListener(new j());
        new UDTabLayoutCoordinator(this.mIndicator, this.mMyGroupVP).attach();
        this.mIndicator.getTabAt(0).e.setOnClickListener(new f(this));
        this.mIndicator.getTabAt(1).e.setOnClickListener(new g(this));
    }

    public final /* bridge */ /* synthetic */ void setViewDelegate(IView.IViewDelegate r1) {
        l r2 = (l) r1;
    }

    public ContactsMyGroupView(List r1, ContactsMyGroupFragment.a r2, FragmentManager r3) {
        this.b = r2;
        this.d = r1;
        this.c = r3;
    }
}
