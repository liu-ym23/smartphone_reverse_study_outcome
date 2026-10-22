package com.ss.android.lark.contact.impl.group.join;

import android.content.Context;
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
public class MyJoinGroupView implements b {
    public Context a;
    public b.a b;
    public a c;
    public ContactsMyGroupAdapter d;
    public final m e;

    @BindView(8790)
    View mEmptyLayout;

    @BindView(9182)
    RecyclerView mMyJoinGroupRV;

    @BindView(9181)
    LKUIPtrClassicFrameLayout mPtrFrame;

    public interface a {
    }

    public final void destroy() {
        this.c = null;
    }

    public final void create() {
        ButterKnife.bind(this, ((MyJoinGroupFragment.a) this.c).a.getView());
        this.a = this.mMyJoinGroupRV.getContext();
        h.a(this.mMyJoinGroupRV);
        this.mMyJoinGroupRV.setLayoutManager(new LinearLayoutManager(this.a));
        ContactsMyGroupAdapter r0 = new ContactsMyGroupAdapter();
        this.d = r0;
        ContactsMyGroupAdapter.b r1 = new d(this);
        Intrinsics.checkNotNullParameter(r1, "onItemClickListener");
        r0.d = r1;
        this.mMyJoinGroupRV.setAdapter(this.d);
        int r2 = DesktopUtil.a;
        ChatWindowPtrLoadingHeader r3 = new ChatWindowPtrLoadingHeader(this.a);
        this.mPtrFrame.setKeepHeaderWhenRefresh(true);
        this.mPtrFrame.setFooterView(r3);
        this.mPtrFrame.addPtrUIHandler(r3);
        this.mPtrFrame.disableWhenHorizontalMove(true);
        this.mPtrFrame.setPtrHandler(new e(this));
    }

    @Override // com.ss.android.lark.contact.impl.group.join.b
    public final void n() {
        this.mPtrFrame.refreshComplete();
    }

    @Override // com.ss.android.lark.contact.impl.group.join.b
    public final void refresh() {
        ContactsMyGroupAdapter r0 = this.d;
        if (r0 == null) goto L6;
        r0.notifyDataSetChanged();
        return;
    }

    @Override // com.ss.android.lark.contact.impl.group.join.b
    public final void D6(List<Chat> r2) {
        this.d.diff(r2);
    }

    @Override // com.ss.android.lark.contact.impl.group.join.b
    public final void X7(List<Chat> r4) {
        if (CollectionUtils.isEmpty(r4) == false) goto L5;
        this.mMyJoinGroupRV.setVisibility(8);
        this.mEmptyLayout.setVisibility(0);
        y9c.d.k(this.mEmptyLayout);
        return;
    L5:
        this.mMyJoinGroupRV.setVisibility(0);
        this.mEmptyLayout.setVisibility(8);
        this.d.diff(r4);
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.b = (b.a) r1;
    }

    public MyJoinGroupView(MyJoinGroupFragment.a r1, m r2) {
        this.c = r1;
        this.e = r2;
    }
}
