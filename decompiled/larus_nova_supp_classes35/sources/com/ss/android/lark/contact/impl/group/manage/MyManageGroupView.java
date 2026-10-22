package com.ss.android.lark.contact.impl.group.manage;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.contact.impl.group.ContactsMyGroupAdapter;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.widget.ChatWindowPtrLoadingHeader;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import q9b.m;
import zdc.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class MyManageGroupView implements b {
    public Context a;
    public a b;
    public b.a c;
    public ContactsMyGroupAdapter d;
    public final List<String> e;
    public final m f;
    public boolean g;

    @BindView(8790)
    View mEmptyLayout;

    @BindView(9182)
    RecyclerView mMyManageGroupRV;

    @BindView(9181)
    LKUIPtrClassicFrameLayout mPtrFrame;

    public interface a {
    }

    public final void destroy() {
        this.b = null;
    }

    public final void create() {
        MyManageGroupFragment r0 = ((c) this.b).a;
        int r1 = MyManageGroupFragment.i;
        ButterKnife.bind(this, r0.getView());
        this.a = this.mMyManageGroupRV.getContext();
        h.a(this.mMyManageGroupRV);
        this.mMyManageGroupRV.setLayoutManager(new LinearLayoutManager(this.a));
        this.d = new ContactsMyGroupAdapter();
        this.mMyManageGroupRV.setItemAnimator(null);
        this.mMyManageGroupRV.setAdapter(this.d);
        int r2 = DesktopUtil.a;
        ContactsMyGroupAdapter r3 = this.d;
        ContactsMyGroupAdapter.b r4 = new e(this);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "onItemClickListener");
        r3.d = r4;
        this.d.getClass();
        ContactsMyGroupAdapter r5 = this.d;
        r5.e = this.g;
        r5.f = null;
        ChatWindowPtrLoadingHeader r6 = new ChatWindowPtrLoadingHeader(this.a);
        this.mPtrFrame.setKeepHeaderWhenRefresh(true);
        this.mPtrFrame.setFooterView(r6);
        this.mPtrFrame.addPtrUIHandler(r6);
        this.mPtrFrame.disableWhenHorizontalMove(true);
        this.mPtrFrame.setPtrHandler(new g(this));
    }

    @Override // com.ss.android.lark.contact.impl.group.manage.b
    public final void n() {
        this.mPtrFrame.refreshComplete();
    }

    @Override // com.ss.android.lark.contact.impl.group.manage.b
    public final void refresh() {
        ContactsMyGroupAdapter r0 = this.d;
        if (r0 == null) goto L6;
        r0.notifyDataSetChanged();
        return;
    }

    @Override // com.ss.android.lark.contact.impl.group.manage.b
    public final void B5(List<Chat> r4) {
        if (CollectionUtils.isEmpty(r4) == false) goto L5;
        this.mMyManageGroupRV.setVisibility(8);
        this.mEmptyLayout.setVisibility(0);
        y9c.d.k(this.mEmptyLayout);
    L6:
        fsb.f.b().f(this.mMyManageGroupRV);
        return;
    L5:
        this.mMyManageGroupRV.setVisibility(0);
        this.mEmptyLayout.setVisibility(8);
        this.d.diff(r4);
        goto L6
    }

    @Override // com.ss.android.lark.contact.impl.group.manage.b
    public final void i8(List<Chat> r2) {
        this.d.diff(r2);
        this.mMyManageGroupRV.getRootView().requestLayout();
    }

    @Override // com.ss.android.lark.contact.impl.group.manage.b
    public final void setEnableChatPreview(boolean r2) {
        this.g = false;
        this.d.e = false;
    }

    @Override // com.ss.android.lark.contact.impl.group.manage.b
    public final void setExtras(Bundle r2) {
        this.d.f = null;
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.c = (b.a) r1;
    }

    public MyManageGroupView(c r2, List r3, m r4) {
        this.g = false;
        this.b = r2;
        this.e = r3;
        this.f = r4;
    }
}
