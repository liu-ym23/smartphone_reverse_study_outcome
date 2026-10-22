package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.MyLiveTab;
import com.bytedance.android.live.core.setting.n0;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.utils.TabDataHelper;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.q;
import com.bytedance.android.livesdk.dsl.util.DSLActionEnum;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposables;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yt1.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/descriptioncomponent/mylive/TabAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/profile/ui/component/descriptioncomponent/mylive/TabAdapter$TabViewHolder;", "a", "b", "TabViewHolder", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabAdapter extends RecyclerView.Adapter<TabViewHolder> {
    public final List<TabDataHelper> a;
    public Function1<? super String, Unit> b;
    public final DataCenter c;
    public final com.bytedance.android.live.profile.ui.base.h d;
    public final ProfileTabsComponent e;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/descriptioncomponent/mylive/TabAdapter$TabViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TabViewHolder extends RecyclerView.ViewHolder {
        public final Lazy a;
        public final View b;

        public TabViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemContainer");
            super(r2);
            this.b = r2;
            this.a = LazyKt.lazy(new TabAdapter$TabViewHolder$recyclerView$2(this));
        }
    }

    public static final class a {
    }

    public static final class b extends RecyclerView.OnScrollListener {
        public final TabDataHelper a;

        public b(TabDataHelper r2) {
            Intrinsics.checkNotNullParameter(r2, "tabDataHelper");
            this.a = r2;
        }

        public final void onScrolled(RecyclerView r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "recyclerView");
            super.onScrolled(r2, r3, r4);
            RecyclerView.LayoutManager r5 = r2.getLayoutManager();
            if ((r5 instanceof LinearLayoutManager) == true) goto L5;
            r5 = null;
        L5:
            LinearLayoutManager r6 = (LinearLayoutManager) r5;
            if (r6 != null) goto L9;
            return;
        L9:
            if (r6.getItemCount() > ((r6.findLastVisibleItemPosition() + 1) + 2)) goto L12;
            this.a.c();
            return;
        }
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r12, final int r13) {
        TabViewHolder r14 = (TabViewHolder) r12;
        Intrinsics.checkNotNullParameter(r14, "holder");
        TabDataHelper r0 = (TabDataHelper) CollectionsKt.getOrNull(this.a, r13);
        if (r0 == null) goto L48;
        RecyclerView r1 = (RecyclerView) r14.a.getValue();
        boolean r2 = false;
        if (r1 == null) goto L28;
        TabItemAdapter r9 = new TabItemAdapter();
        Intrinsics.checkNotNullParameter(r9, "tabItemAdapter");
        r0.a = r9;
        r9.a = r0;
        ((ArrayList) r0.e).clear();
        com.bytedance.android.livesdk.dsl.recyclerview.c r5 = null;
        ((ArrayList) r0.e).addAll(r0.b(r0.a(null, r0.f.getItems()), 0));
        r9.setData(r0.e);
        r9.notifyDataSetChanged();
        RecyclerView r6 = (RecyclerView) r14.a.getValue();
        IRoomContextService r3 = jc1.k.f(IRoomContextService.class);
        if (r3 == null) goto L14;
        q r4 = IRoomContextService.a.b(r3, this.c, 2);
        if (r4 == null) goto L14;
        com.bytedance.live.datacontext.j r7 = r4.E1();
        if (r7 == null) goto L14;
        n r8 = (n) r7.getValue();
    L15:
        com.bytedance.android.livesdk.dsl.recyclerview.f r10 = (com.bytedance.android.livesdk.dsl.recyclerview.f) r0.b.getValue();
        if (r6 == null) goto L18;
        Context r15 = r6.getContext();
    L19:
        Activity r16 = ContextUtil.contextToActivity(r15);
        if (r6 == null) goto L27;
        if (r8 == null) goto L27;
        if (r16 == null) goto L27;
        com.bytedance.android.livesdk.dsl.recyclerview.c r17 = new com.bytedance.android.livesdk.dsl.recyclerview.c(r16, r6, r9, r8, r10);
        r17.b = new TabAdapter$generateDSLAdapterContext$$inlined$apply$lambda$1(this, r13);
        bu1.c r18 = new bu1.c(this.b);
        Intrinsics.checkNotNullParameter(r18, "action");
        r17.a.put(DSLActionEnum.CustomProfileCardDismiss.getText(), r18);
        if (((Boolean) n0.a.getValue()).booleanValue() == false) goto L26;
        RxUtilKt.c(Disposables.fromAction(new k(r17)), this.e.i);
    L26:
        r5 = r17;
    L27:
        r9.c = r5;
        Unit r19 = Unit.INSTANCE;
        r1.setAdapter(r9);
        goto L28
    L18:
        r15 = null;
    L14:
        r8 = null;
    L28:
        RecyclerView r20 = (RecyclerView) r14.a.getValue();
        if (r20 == null) goto L31;
        LinearLayoutManager r22 = new LinearLayoutManager(r14.b.getContext());
        r22.setOrientation(1);
        Unit r23 = Unit.INSTANCE;
        r20.setLayoutManager(r22);
    L31:
        MyLiveTab.Extra r24 = r0.c;
        if (r24 != null) goto L34;
    L36:
        if (r2 == false) goto L40;
        RecyclerView r25 = (RecyclerView) r14.a.getValue();
        if (r25 == null) goto L40;
        r25.addOnScrollListener(new b(r0));
    L40:
        ProfileTabsComponent r26 = this.e;
        com.bytedance.android.live.profile.ui.base.h r27 = this.d;
        Intrinsics.checkNotNullParameter(r26, "component");
        Intrinsics.checkNotNullParameter(r27, "profileContext");
        j r28 = new j(r14, r13, r27);
        r26.getClass();
        Intrinsics.checkNotNullParameter(r28, "listener");
        if (r26.b != null) goto L43;
        r26.b = new ArrayList();
    L43:
        List<ProfileTabsComponent.b> r110 = r26.b;
        if (r110 == null) goto L47;
        ((ArrayList) r110).add(r28);
        return;
    L47:
        return;
    L34:
        if (r24.getHasMore() != true) goto L36;
        r2 = true;
        goto L36
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new TabViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131567195, r3, false));
    }

    public TabAdapter(DataCenter r2, com.bytedance.android.live.profile.ui.base.h r3, ProfileTabsComponent r4) {
        Intrinsics.checkNotNullParameter(r3, "profileContext");
        Intrinsics.checkNotNullParameter(r4, "component");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = new ArrayList();
    }
}
