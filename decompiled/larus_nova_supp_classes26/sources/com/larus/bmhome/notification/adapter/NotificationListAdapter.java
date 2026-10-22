package com.larus.bmhome.notification.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import bb8.i;
import bb8.j;
import by7.e;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.banner.BannerAdapter;
import com.larus.bmhome.banner.BannerItemViewHolder;
import com.larus.bmhome.chat.resp.Button;
import com.larus.bmhome.chat.resp.CommonNoticeData;
import com.larus.bmhome.chat.resp.Notice;
import com.larus.bmhome.chat.resp.NoticeButtonStyle;
import com.larus.bmhome.notification.viewholder.CommonNotificationItemViewHolder;
import com.larus.bmhome.notification.viewholder.EmptyNotificationItemViewHolder;
import com.larus.bmhome.notification.viewholder.LoadMoreNotificationItemViewHolder;
import com.larus.bmhome.notification.viewholder.NetworkErrorNotificationItemViewHolder;
import com.larus.bmhome.notification.viewholder.PlaceHolderNotificationItemViewHolder;
import com.larus.bmhome.notification.viewholder.RightArrowIconNotificationItemViewHolder;
import com.larus.bmhome.notification.viewholder.RightImageNotificationItemViewHolder;
import com.larus.bmhome.notification.viewholder.RightJsonNotificationItemViewHolder;
import com.larus.bmhome.notification.viewholder.RightTextNotificationItemViewHolder;
import com.larus.business.banner.databinding.LarusItemBannerBinding;
import com.larus.common_res.common_ui.databinding.LarusItemLoadMoreBinding;
import com.larus.common_ui.paging.FPagingAdapter;
import com.larus.notify.impl.databinding.LarusItemNotificationDefaultBinding;
import com.larus.notify.impl.databinding.LarusItemNotificationEmptyBinding;
import com.larus.notify.impl.databinding.LarusItemNotificationNetworkErrorBinding;
import com.larus.notify.impl.databinding.LarusItemNotificationPlaceholderBinding;
import com.larus.utils.e1;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import or8.l;
import or8.m;
import or8.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 Q2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001QB\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010.\u001a\u00020\u0004H\u0016J\u0018\u0010/\u001a\u00020\u00152\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J/\u00101\u001a\u00020\u00152'\b\u0002\u00100\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017JD\u00102\u001a\u00020\u00152<\b\u0002\u00100\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001cJ\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0012H\u0002J\u0010\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u0012H\u0016J \u00108\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0012H\u0016J\u0018\u0010;\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0012H\u0016J\b\u0010>\u001a\u00020\u0015H\u0016J\u000e\u0010?\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u0012J\u0006\u0010A\u001a\u00020\u0015J\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010J\u0016\u0010C\u001a\u00020\u00152\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010J\u0010\u0010E\u001a\u00020\u00152\b\u0010F\u001a\u0004\u0018\u00010\u0002J\u0006\u0010G\u001a\u000204J\u0006\u0010H\u001a\u000204J\b\u0010I\u001a\u000204H\u0002J\u0014\u0010J\u001a\u00020\u00152\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u0006\u0010L\u001a\u000204J\u0006\u0010M\u001a\u00020\u0015J\u0006\u0010N\u001a\u00020\u0015J\u0006\u0010O\u001a\u00020\u0012Jn\u0010P\u001a\u00020\u00152f\u00100\u001ab\u0012\u0015\u0012\u0013\u0018\u00010!¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b($\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u0015\u0018\u00010 R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\u0016\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010\u001b\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000Rn\u0010\u001f\u001ab\u0012\u0015\u0012\u0013\u0018\u00010!¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b($\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u0015\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006R"}, d2 = {"Lcom/larus/bmhome/notification/adapter/NotificationListAdapter;", "Lcom/larus/common_ui/paging/FPagingAdapter;", "Lcom/larus/bmhome/chat/resp/Notice;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/ixigua/lib/track/ITrackNode;", "config", "Lcom/larus/common_ui/paging/FPagingAdapter$Config;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "parent", "<init>", "(Lcom/larus/common_ui/paging/FPagingAdapter$Config;Landroidx/lifecycle/Lifecycle;Lcom/ixigua/lib/track/ITrackNode;)V", "loadMoreItem", "emptyItem", "networkErrorItem", "placeHolders", "", "loadMoreStatus", "", "loadMoreListener", "Lkotlin/Function0;", "", "onUnreadChangeListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "notice", "itemClickListener", "Lkotlin/Function2;", "", "clickFrom", "itemLongClickListener", "Lkotlin/Function4;", "Landroid/view/View;", "anchor", "", "x", "y", "networkRefreshListener", "bannerViewHolder", "Lcom/larus/bmhome/banner/BannerItemViewHolder;", "refreshCount", "getRefreshCount", "()I", "setRefreshCount", "(I)V", "parentTrackNode", "setLoadMoreRetryListener", "listener", "setUnreadChangeListener", "setItemOnClickListener", "isSpecialNoticeType", "", "noticeType", "getItemViewType", "position", "onBindViewHolder", "holder", "data", "onCreateViewHolder", "Landroid/view/ViewGroup;", "viewType", "distinctDatas", "updateLoadMoreStatus", "status", "updatePageError", "getNoticeListWithoutBanner", "refreshNotice", "noticeList", "refreshBanner", "banner", "isNetworkErrorItemShow", "isEmptyItemShow", "hasValidNoticeBanner", "setNetworkRetryClickListener", "callback", "isPlaceHolderShow", "showPlaceHolder", "localMarkTotalReadAndRefresh", "getUnreadItemCount", "setItemLongClickListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationListAdapter extends FPagingAdapter<Notice, RecyclerView.ViewHolder> implements e {
    public static final /* synthetic */ int t = 0;
    public final Lifecycle f;
    public final e g;
    public final Notice h;
    public final Notice i;
    public final Notice j;
    public final List<Notice> k;
    public int l;
    public Function0<Unit> m;
    public Function1<? super Notice, Unit> n;
    public Function2<? super Notice, ? super String, Unit> o;
    public Function4<? super View, ? super Notice, ? super Float, ? super Float, Unit> p;
    public Function0<Unit> q;
    public BannerItemViewHolder r;
    public int s;

    public static final class a {
    }

    static {
    }

    public final void fillTrackParams(TrackParams r1) {
    }

    public final boolean H2() {
        if (((ArrayList) ((FPagingAdapter) this).b).isEmpty() == false) goto L5;
        return false;
    L5:
        Notice r0 = (Notice) A2(0);
        if (r0 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L23;
        Iterator r1 = r0.getBannerModels().iterator();
    L15:
        if (r1.hasNext() == false) goto L24;
        if (j.a((i) r1.next()) == true) goto L15;
        return true;
    L24:
        return false;
    L23:
        return false;
    L8:
        if (r0.getNoticeType() != (-3)) goto L10;
        r3 = true;
        goto L11
    }

    public final void z2() {
        if (((ArrayList) ((FPagingAdapter) this).b).isEmpty() == false) goto L5;
        return;
    L5:
        HashSet r0 = new HashSet();
        HashSet r1 = new HashSet();
        ArrayList r2 = new ArrayList();
        HashSet r3 = new HashSet();
        Iterator r4 = ((ArrayList) ((FPagingAdapter) this).b).iterator();
    L7:
        if (r4.hasNext() == false) goto L41;
        Notice r5 = (Notice) r4.next();
        if (r5 == null) goto L7;
        if (r5.getNoticeType() == (-3)) goto L13;
        int r6 = r5.getNoticeType();
        if (r6 != (-5)) goto L18;
    L25:
        boolean r7 = true;
    L26:
        if (r7 == true) goto L27;
        if (r0.add(Long.valueOf(r5.getNoticeId())) == true) goto L30;
        if (r5.getNoticeId() > 0) goto L7;
        if (o0.d(r5.getUniqId()) == false) goto L7;
        String r8 = r5.getUniqId();
        if (r8 != null) goto L39;
        r8 = "";
    L39:
        if (r1.add(r8) == false) goto L7;
        r2.add(r5);
        goto L7
    L30:
        r2.add(r5);
        goto L7
    L27:
        r2.add(r5);
        goto L7
    L18:
        if (r6 == (-4)) goto L25;
        if (r6 == (-3)) goto L25;
        if (r6 == (-2)) goto L25;
        if (r6 == (-1)) goto L25;
        r7 = false;
        goto L26
    L13:
        if (r3.add(Integer.valueOf(r5.getNoticeType())) == false) goto L7;
        r2.add(r5);
        goto L7
    L41:
        ((ArrayList) ((FPagingAdapter) this).b).clear();
        ((ArrayList) ((FPagingAdapter) this).b).addAll(r2);
    }

    public final e referrerTrackNode() {
        return e.a.a(this);
    }

    public final e parentTrackNode() {
        return this.g;
    }

    public final void I2(Notice r4) {
        if (H2() == false) goto L7;
        if (r4 != null) goto L6;
        F2(0);
        return;
    L6:
        G2(0, r4);
        return;
    L7:
        if (r4 == null) goto L18;
        List r0 = ((FPagingAdapter) this).b;
        ArrayList r1 = (ArrayList) r0;
        if (r1.contains(this.j) == true) goto L14;
        List r2 = ((FPagingAdapter) this).b;
        ArrayList r3 = (ArrayList) r2;
        if (r3.contains(this.i) == true) goto L14;
        B2(0, CollectionsKt.listOf(r4));
        return;
    L14:
        ArrayList r5 = new ArrayList();
        r5.add(r4);
        r5.addAll(((FPagingAdapter) this).b);
        E2(r5);
        return;
    }

    public final void J2(List<Notice> r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r3 = CollectionsKt.listOf(this.i);
    L12:
        if (H2() == false) goto L17;
        ArrayList r2 = new ArrayList();
        Notice r0 = (Notice) A2(0);
        if (r0 == null) goto L16;
        r2.add(r0);
    L16:
        r2.addAll(r3);
        E2(r2);
        return;
    L17:
        E2(r3);
        return;
    L5:
        if (r3.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void K2(int r4) {
        if (this.l != r4) goto L5;
        return;
    L5:
        this.l = r4;
        boolean r0 = Intrinsics.areEqual(A2(getItemCount() - 1), this.h);
        if (r4 != 1) goto L8;
    L14:
        if (r0 == false) goto L16;
        notifyItemChanged(getItemCount() - 1);
        return;
    L16:
        y2(CollectionsKt.listOf(this.h));
        return;
    L8:
        if (r4 != 2) goto L10;
        if (r0 == false) goto L18;
        F2(getItemCount() - 1);
        return;
    L18:
        return;
    L10:
        if (r4 == 3) goto L14;
    }

    public final int getItemViewType(int r5) {
        Notice r6 = (Notice) A2(r5);
        if (r6 != null) goto L5;
        return -1;
    L5:
        int r1 = r6.getNoticeType();
        if (r1 != (-5)) goto L8;
    L15:
        boolean r0 = true;
    L16:
        if (r0 == true) goto L18;
        CommonNoticeData r7 = r6.getCommonNoticeData();
        if (r7 == null) goto L25;
        Button r8 = r7.getRightButton();
        if (r8 != null) goto L24;
        return 0;
    L24:
        return r8.getStyle();
    L25:
        return 0;
    L18:
        return r6.getNoticeType();
    L8:
        if (r1 == (-4)) goto L15;
        if (r1 == (-3)) goto L15;
        if (r1 == (-2)) goto L15;
        if (r1 == (-1)) goto L15;
        r0 = false;
        goto L16
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        LayoutInflater r0 = LayoutInflater.from(r5.getContext());
        if (r6 != NoticeButtonStyle.TEXT.getStyle()) goto L6;
        return new RightTextNotificationItemViewHolder(LarusItemNotificationDefaultBinding.a(r0, r5));
    L6:
        if (r6 != NoticeButtonStyle.JSON.getStyle()) goto L9;
        return new RightJsonNotificationItemViewHolder(LarusItemNotificationDefaultBinding.a(r0, r5));
    L9:
        if (r6 != NoticeButtonStyle.IMAGE.getStyle()) goto L12;
        return new RightImageNotificationItemViewHolder(LarusItemNotificationDefaultBinding.a(r0, r5));
    L12:
        if (r6 != NoticeButtonStyle.RIGHT_ARROW.getStyle()) goto L15;
        return new RightArrowIconNotificationItemViewHolder(LarusItemNotificationDefaultBinding.a(r0, r5));
    L15:
        if (r6 != (-1)) goto L24;
        View r7 = r0.inflate(2131562601, r5, false);
        int r1 = 2131363623;
        View r2 = ViewBindings.findChildViewById(r7, 2131363623);
        if (r2 == null) goto L22;
        r1 = 2131388462;
        if (((LinearLayout) ViewBindings.findChildViewById(r7, 2131388462)) == null) goto L22;
        return new PlaceHolderNotificationItemViewHolder(new LarusItemNotificationPlaceholderBinding((RelativeLayout) r7, r2));
    L22:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r1)));
    L24:
        if (r6 != (-2)) goto L27;
        return new LoadMoreNotificationItemViewHolder(LarusItemLoadMoreBinding.a(r0, r5));
    L27:
        if (r6 != (-3)) goto L35;
        if (this.r != null) goto L31;
        this.r = new BannerItemViewHolder(LarusItemBannerBinding.a(r0, r5), this.f, this);
    L31:
        BannerItemViewHolder r8 = this.r;
        if (r8 == null) goto L60;
        return r8;
    L60:
        return new BannerItemViewHolder(LarusItemBannerBinding.a(r0, r5), this.f, this);
    L35:
        if (r6 != (-4)) goto L42;
        View r9 = r0.inflate(2131562599, r5, false);
        if (r9 == null) goto L40;
        return new EmptyNotificationItemViewHolder(new LarusItemNotificationEmptyBinding((LinearLayout) r9));
    L40:
        throw new NullPointerException("rootView");
    L42:
        if (r6 != (-5)) goto L49;
        View r10 = r0.inflate(2131562600, r5, false);
        LinearLayout r3 = (LinearLayout) r10;
        if (((TextView) ViewBindings.findChildViewById(r10, 2131384145)) == null) goto L47;
        return new NetworkErrorNotificationItemViewHolder(new LarusItemNotificationNetworkErrorBinding(r3, r3));
    L47:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(2131384145)));
    L49:
        if (r6 != NoticeButtonStyle.None.getStyle()) goto L52;
        return new CommonNotificationItemViewHolder(LarusItemNotificationDefaultBinding.a(r0, r5));
    L52:
        return new CommonNotificationItemViewHolder(LarusItemNotificationDefaultBinding.a(r0, r5));
    }

    public NotificationListAdapter(FPagingAdapter.a r41, Lifecycle r42, e r43) {
        Intrinsics.checkNotNullParameter(r41, "config");
        Intrinsics.checkNotNullParameter(r42, "lifecycle");
        Intrinsics.checkNotNullParameter(r43, "parent");
        super(r41);
        this.f = r42;
        this.g = r43;
        this.h = new Notice(0, 0, 0, -2, null, false, null, null, null, null, 1015, null);
        this.i = new Notice(0, 0, 0, -4, null, false, null, null, null, null, 1015, null);
        this.j = new Notice(0, 0, 0, -5, null, false, null, null, null, null, 1015, null);
        Notice[] r2 = new Notice[6];
        int r3 = 0;
    L3:
        if (r3 >= 6) goto L5;
        r2[r3] = new Notice(0, 0, 0, -1, null, false, null, null, null, null, 1015, null);
        r3 = r3 + 1;
        goto L3
    L5:
        this.k = ArraysKt.toList(r2);
        this.l = 2;
    }

    public final void D2(final RecyclerView.ViewHolder r5, Object r6, int r7) {
        Notice r8 = (Notice) r6;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r8, "data");
        if ((r5 instanceof l) == false) goto L6;
        l r9 = (l) r5;
        r9.g2(r8);
        r9.T0(this.n);
        r9.K1(this.o);
        r9.a3(this.p);
        return;
    L6:
        if ((r5 instanceof LoadMoreNotificationItemViewHolder) == false) goto L19;
        LoadMoreNotificationItemViewHolder r10 = (LoadMoreNotificationItemViewHolder) r5;
        int r11 = this.l;
        if (r11 != 1) goto L10;
        r10.a.c.setVisibility(8);
        r10.a.b.setVisibility(0);
    L17:
        final Function0<Unit> r12 = this.m;
        e1.d(r10.a.b, new m(r12));
        return;
    L10:
        if (r11 != 2) goto L12;
        r10.a.c.setVisibility(8);
        r10.a.b.setVisibility(8);
        goto L17
    L12:
        if (r11 == 3) goto L14;
        r10.getClass();
        goto L17
    L14:
        r10.a.c.setVisibility(0);
        r10.a.b.setVisibility(8);
        goto L17
    L19:
        if ((r5 instanceof BannerItemViewHolder) == false) goto L25;
        if (H2() == false) goto L23;
        ((BannerItemViewHolder) r5).T3(r8.getBannerModels());
        return;
    L23:
        r5.itemView.post(new mr8.a(r5, this));
        return;
    L25:
        if ((r5 instanceof EmptyNotificationItemViewHolder) == false) goto L32;
        boolean r13 = H2();
        RecyclerView.LayoutParams r14 = ((RecyclerView.ViewHolder) ((EmptyNotificationItemViewHolder) r5)).itemView.getLayoutParams();
        if (r14 == null) goto L44;
        if (r13 == false) goto L30;
        r14.setMargins(((ViewGroup.MarginLayoutParams) r14).leftMargin, EmptyNotificationItemViewHolder.a - BannerAdapter.i, ((ViewGroup.MarginLayoutParams) r14).rightMargin, ((ViewGroup.MarginLayoutParams) r14).bottomMargin);
        return;
    L30:
        r14.setMargins(((ViewGroup.MarginLayoutParams) r14).leftMargin, EmptyNotificationItemViewHolder.a, ((ViewGroup.MarginLayoutParams) r14).rightMargin, ((ViewGroup.MarginLayoutParams) r14).bottomMargin);
        return;
    L44:
        return;
    L32:
        if ((r5 instanceof NetworkErrorNotificationItemViewHolder) == false) goto L47;
        NetworkErrorNotificationItemViewHolder r15 = (NetworkErrorNotificationItemViewHolder) r5;
        boolean r16 = H2();
        final Function0<Unit> r17 = this.q;
        RecyclerView.LayoutParams r0 = ((RecyclerView.ViewHolder) r15).itemView.getLayoutParams();
        if (r0 == null) goto L38;
        if (r16 == false) goto L37;
        r0.setMargins(((ViewGroup.MarginLayoutParams) r0).leftMargin, EmptyNotificationItemViewHolder.a - BannerAdapter.i, ((ViewGroup.MarginLayoutParams) r0).rightMargin, ((ViewGroup.MarginLayoutParams) r0).bottomMargin);
        goto L38
    L37:
        r0.setMargins(((ViewGroup.MarginLayoutParams) r0).leftMargin, EmptyNotificationItemViewHolder.a, ((ViewGroup.MarginLayoutParams) r0).rightMargin, ((ViewGroup.MarginLayoutParams) r0).bottomMargin);
    L38:
        e1.d(r15.a.b, new n(r17));
        return;
    }
}
