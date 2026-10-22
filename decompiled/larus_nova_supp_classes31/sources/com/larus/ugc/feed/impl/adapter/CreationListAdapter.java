package com.larus.ugc.feed.impl.adapter;

import android.net.Uri;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.chat.api.IMusicService;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.CommonAuthorInfoLayout;
import com.larus.community.impl.detail.header.CreationDetailHeadInspirationViewHolder;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AbsCreationFeedHeaderViewHolder;
import com.larus.platform.api.creation.AiBeautifyUserContent;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationFeedType;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.api.creation.UserCreationMusic;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import com.larus.platform.api.creation.VideoUserContent;
import com.larus.profile.api.bean.UserCreationModel;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ugc.feed.impl.viewholder.CommonViewHolder;
import com.larus.ugc.feed.impl.viewholder.CreationAIBeautifyViewHolder;
import com.larus.ugc.feed.impl.viewholder.CreationAvatarEntranceViewHolder;
import com.larus.ugc.feed.impl.viewholder.CreationAvatarViewHolder;
import com.larus.ugc.feed.impl.viewholder.CreationBannedViewHolder;
import com.larus.ugc.feed.impl.viewholder.CreationImageToImageViewHolder;
import com.larus.ugc.feed.impl.viewholder.CreationImageViewHolder;
import com.larus.ugc.feed.impl.viewholder.CreationLoadingAndRetryViewHolder;
import com.larus.ugc.feed.impl.viewholder.CreationMoreViewHolder;
import com.larus.ugc.feed.impl.viewholder.CreationMusicViewHolder;
import com.larus.ugc.feed.impl.viewholder.CreationVideoViewHolder;
import com.larus.ugc.feed.impl.viewholder.h;
import com.larus.ugc.feed.impl.viewholder.m0;
import com.larus.ugc.feed.impl.viewholder.selfprivate.CreationSelfPrivateViewHolder;
import com.larus.ugc.feed.impl.viewholder.t;
import com.larus.ugc.feed.impl.viewholder.u;
import com.larus.ugc.feed.impl.viewholder.v;
import com.larus.ugc.feed.impl.viewholder.w;
import com.larus.ugc.feed.impl.viewholder.x;
import com.larus.ugc.feed.impl.viewholder.y;
import com.larus.ugc.feed.impl.viewholder.z;
import com.larus.ugc.feed.impl.widget.CreationLoadingAndRetryView;
import com.larus.utils.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.IdentityHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import n0a.b;
import n0a.d;
import p0a.e;
import p0a.g;
import p0a.j;
import p0a.k;
import q0a.c;
import tx9.n0;
import v19.c7;
import v19.i5;
import zp9.f;
import zp9.p;
import zp9.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\r\b\u0007\u0018\u0000 `2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002`aB\u0081\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\f\u0010)\u001a\u00020(*\u00020'H\u0002J\u000e\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020'J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u000202J\b\u00108\u001a\u000202H\u0002J\u0010\u0010E\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\u0010\u0010F\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\u000e\u0010G\u001a\u0002022\u0006\u0010H\u001a\u00020\u0004J\u0018\u0010I\u001a\u0002022\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010KH\u0007J\u000e\u0010L\u001a\u0002022\u0006\u0010!\u001a\u00020\"J\u0018\u0010M\u001a\u00020\u00022\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u0004H\u0016J&\u0010Q\u001a\u0002022\u0006\u0010R\u001a\u00020\u00022\u0006\u0010S\u001a\u00020\u00042\f\u0010T\u001a\b\u0012\u0004\u0012\u00020U0\u0006H\u0016J\u0018\u0010Q\u001a\u0002022\u0006\u0010R\u001a\u00020\u00022\u0006\u0010S\u001a\u00020\u0004H\u0016J\b\u0010V\u001a\u00020\u0004H\u0016J\u000e\u0010W\u001a\u0002022\u0006\u0010,\u001a\u00020-J\u000e\u0010X\u001a\u0002022\u0006\u0010.\u001a\u00020/J\u0010\u0010Y\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u0004H\u0016J\u0012\u0010Z\u001a\u00020\u00042\b\u0010[\u001a\u0004\u0018\u00010'H\u0002J\u0010\u0010\\\u001a\u0002022\u0006\u0010R\u001a\u00020\u0002H\u0016J\u001a\u0010]\u001a\u00020\u00112\u0006\u0010^\u001a\u00020\u00042\b\u0010_\u001a\u0004\u0018\u00010\u0002H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010=\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\b?\u0010@R\u000e\u0010C\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/larus/ugc/feed/impl/adapter/CreationListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "spanCount", "", "dataList", "", "Lcom/larus/profile/api/bean/UserCreationModel;", "lifeCycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "headCreator", "Lcom/larus/platform/api/creation/ICreationFeedHeaderCreator;", "emptyViewCreator", "Lkotlin/Function0;", "Landroid/view/View;", "creationFeedType", "disableEndView", "", "tag", "", "initParams", "Lcom/larus/platform/api/creation/CreationFeedInitParams;", "focusHelper", "Lcom/larus/ugc/feed/impl/component/focus/CreationFeedRVFocusHelper;", "recyclerPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "<init>", "(ILjava/util/List;Landroidx/lifecycle/LifecycleCoroutineScope;Lcom/larus/platform/api/creation/ICreationFeedHeaderCreator;Lkotlin/jvm/functions/Function0;IZLjava/lang/String;Lcom/larus/platform/api/creation/CreationFeedInitParams;Lcom/larus/ugc/feed/impl/component/focus/CreationFeedRVFocusHelper;Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;)V", "getSpanCount", "()I", "getDataList", "()Ljava/util/List;", "getCreationFeedType", "creationClickCallBack", "Lcom/larus/ugc/feed/impl/adapter/ICreationClickCallBack;", "itemWidth", "lastParentWidth", "kmpCache", "Ljava/util/IdentityHashMap;", "Lcom/larus/platform/api/creation/UserCreation;", "Lcom/larus/ugc/feed/api/model/UserCreationKmp;", "toKmpCached", "cachedKmp", "creation", "moreState", "Lcom/larus/ugc/feed/api/state/LoadMoreState;", "state", "Lcom/larus/ugc/feed/api/state/PageState;", "isShowHeader", "preload", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "destroy", "cleanupIdleHandler", "idleHandlerRegistered", "preloadPendingTasks", "Lkotlin/collections/ArrayDeque;", "preloadRecyclerView", "idleHandler", "Landroid/os/MessageQueue$IdleHandler;", "getIdleHandler", "()Landroid/os/MessageQueue$IdleHandler;", "idleHandler$delegate", "Lkotlin/Lazy;", "onLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "calculateWidth", "parentWidth", "setDataList", "newList", "", "setCreationClickCallBack", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "payloads", "", "getItemCount", "updateMoreState", "updateState", "getItemViewType", "userCreationTypeToViewType", "userCreation", "onViewRecycled", "checkFillColumn", "itemType", "viewHolder", "Companion", "DiffCallback", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Integer[] x = null;
    public final int a;
    public final List<UserCreationModel> b;
    public final LifecycleCoroutineScope c;
    public final p d;
    public final Function0<View> e;
    public final int f;
    public final boolean g;
    public final String h;
    public final f i;
    public final c j;
    public final RecyclerView.RecycledViewPool k;
    public k l;
    public int m;
    public int n;
    public final IdentityHashMap<UserCreation, UserCreationKmp> o;
    public b p;
    public d q;
    public final boolean r;
    public boolean s;
    public ArrayDeque<Integer> t;
    public RecyclerView u;
    public final Lazy v;
    public final g w;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/ugc/feed/impl/adapter/CreationListAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/larus/profile/api/bean/UserCreationModel;", "newItems", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class DiffCallback extends DiffUtil.Callback {
        public final List<UserCreationModel> a;
        public final List<UserCreationModel> b;

        public final int getNewListSize() {
            return this.b.size();
        }

        public final int getOldListSize() {
            return this.a.size();
        }

        public DiffCallback(List<UserCreationModel> r2, List<UserCreationModel> r3) {
            Intrinsics.checkNotNullParameter(r2, "oldItems");
            Intrinsics.checkNotNullParameter(r3, "newItems");
            this.a = r2;
            this.b = r3;
        }

        public final boolean areContentsTheSame(int r6, int r7) {
            List<UserCreation> r8 = ((UserCreationModel) ListProtector.get(this.b, r7)).b();
            if (r8 == null) goto L55;
            UserCreation r9 = (UserCreation) CollectionsKt.firstOrNull(r8);
            if (r9 == null) goto L59;
            List<UserCreation> r10 = ((UserCreationModel) ListProtector.get(this.a, r6)).b();
            if (r10 == null) goto L56;
            UserCreation r11 = (UserCreation) CollectionsKt.firstOrNull(r10);
            if (r11 != null) goto L13;
            return false;
        L13:
            if (Intrinsics.areEqual(r9.a, r11.a) == true) goto L15;
        L21:
            boolean r1 = false;
        L22:
            if (r1 == true) goto L25;
            return false;
        L25:
            if (r9.b != 1) goto L53;
            UserCreationContent r2 = r9.e;
            String r3 = null;
            if (r2 == null) goto L31;
            UserCreationMusic r4 = r2.b;
            if (r4 == null) goto L31;
            ImageInfo r5 = r4.d;
        L32:
            UserCreationContent r12 = r11.e;
            if (r12 == null) goto L37;
            UserCreationMusic r13 = r12.b;
            if (r13 == null) goto L37;
            ImageInfo r14 = r13.d;
        L39:
            if (Intrinsics.areEqual(r5, r14) == false) goto L57;
            UserCreationContent r15 = r9.e;
            if (r15 == null) goto L45;
            UserCreationMusic r16 = r15.b;
            if (r16 == null) goto L45;
            String r17 = r16.b;
        L46:
            UserCreationContent r18 = r11.e;
            if (r18 == null) goto L52;
            UserCreationMusic r19 = r18.b;
            if (r19 == null) goto L52;
            r3 = r19.b;
        L52:
            if (Intrinsics.areEqual(r17, r3) == true) goto L53;
            return false;
        L45:
            r17 = null;
            goto L46
        L57:
            return false;
        L37:
            r14 = null;
        L31:
            r5 = null;
        L53:
            return true;
        L15:
            if (Intrinsics.areEqual(r9.d, r11.d) == false) goto L21;
            if (Intrinsics.areEqual(r9.c, r11.c) == false) goto L21;
            if (r9.b != r11.b) goto L21;
            r1 = true;
            goto L22
        L56:
            return false;
        L59:
            return false;
        L55:
            return false;
        }

        public final boolean areItemsTheSame(int r6, int r7) {
            UserCreationModel r0 = (UserCreationModel) ListProtector.get(this.a, r6);
            UserCreationModel r1 = (UserCreationModel) ListProtector.get(this.b, r7);
            String r2 = r0.d();
            String r3 = r1.d();
            if (r2 == null) goto L7;
            if (r3 == null) goto L7;
            boolean r4 = Intrinsics.areEqual(r2, r3);
        L8:
            if (r4 == false) goto L21;
            if (r7 != r6) goto L22;
            List<UserCreation> r8 = r0.b();
            Integer r9 = null;
            if (r8 == null) goto L13;
            Integer r10 = Integer.valueOf(r8.size());
        L14:
            List<UserCreation> r5 = r1.b();
            if (r5 == null) goto L18;
            r9 = Integer.valueOf(r5.size());
        L18:
            if (Intrinsics.areEqual(r10, r9) == false) goto L23;
            return true;
        L23:
            return false;
        L13:
            r10 = null;
            goto L14
        L22:
            return false;
        L21:
            return false;
        L7:
            r4 = false;
            goto L8
        }
    }

    public static final class a {
        public static RecyclerView.RecycledViewPool a() {
            RecyclerView.RecycledViewPool r0 = new RecyclerView.RecycledViewPool();
            Integer[] r1 = CreationListAdapter.x;
            int r2 = 0;
        L4:
            if (r2 >= 6) goto L6;
            r0.setMaxRecycledViews(r1[r2].intValue(), 12);
            r2 = r2 + 1;
            goto L4
        L6:
            return r0;
        }
    }

    static {
        x = new Integer[]{0, 1, 5, 6, 8, 9};
    }

    public final void A2() {
        if (this.s == false) goto L5;
        Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler) this.v.getValue());
        this.s = false;
        boolean r0 = w0a.a.a;
        w0a.a.c("CreationListAdapter", this.h + " cleaned up IdleHandler.");
    L5:
        this.t = null;
        this.u = null;
    }

    public final int getItemCount() {
        if (Intrinsics.areEqual(this.q, d.f.a) == true) goto L12;
        if (Intrinsics.areEqual(this.q, d.b.a) == true) goto L12;
        if (this.r == true) goto L18;
        return 1;
    L18:
        return 2;
    L12:
        if (this.r == false) goto L15;
        return 2 + this.b.size();
    L15:
        return this.b.size() + 1;
    }

    public final UserCreationKmp B2(UserCreation r3) {
        IdentityHashMap<UserCreation, UserCreationKmp> r0 = this.o;
        UserCreationKmp r1 = r0.get(r3);
        if (r1 != null) goto L6;
        r1 = com.larus.ugc.feed.impl.mapper.c.b(r3);
        r0.put(r3, r1);
    L6:
        return r1;
    }

    public final void C2(final b r3) {
        Intrinsics.checkNotNullParameter(r3, "moreState");
        this.p = r3;
        w0a.a.a("CreationListAdapter", new e(this, r3));
        notifyItemChanged(getItemCount() - 1, this.h + "moreState changed");
    }

    public final int D2(UserCreation r10) {
        Integer r0 = Integer.valueOf(this.f);
        Integer r1 = null;
        if (r10 == null) goto L5;
        Integer r2 = r10.c;
    L6:
        if (r10 == null) goto L9;
        r1 = Integer.valueOf(r10.b);
    L9:
        if (r0 == null) goto L20;
        if (r0.intValue() != 2) goto L20;
        if (r2 != null) goto L16;
    L18:
        return 7;
    L16:
        if (r2.intValue() != 100) goto L18;
        return 11;
    L20:
        if (r2 != null) goto L23;
    L25:
        if (r1 == null) goto L31;
        if (r1.intValue() != 2) goto L31;
    L83:
        return 0;
    L31:
        if (r1 == null) goto L37;
        if (r1.intValue() != 5) goto L37;
        return 9;
    L37:
        if (r1 == null) goto L43;
        if (r1.intValue() != 4) goto L43;
        return 6;
    L43:
        if (r1 != null) goto L46;
    L48:
        if (r1 == null) goto L54;
        if (r1.intValue() != 1) goto L54;
        return 5;
    L54:
        if (r1 != null) goto L57;
    L58:
        if (r1 != null) goto L61;
    L62:
        if (r1 != null) goto L65;
    L66:
        if (r1 != null) goto L69;
    L70:
        if (r1 != null) goto L73;
    L74:
        if (r1 != null) goto L77;
    L78:
        if (r1 == null) goto L83;
        if (r1.intValue() != 12) goto L83;
    L84:
        return 8;
    L77:
        if (r1.intValue() == 11) goto L84;
    L73:
        if (r1.intValue() == 10) goto L84;
    L69:
        if (r1.intValue() == 8) goto L84;
    L65:
        if (r1.intValue() == 9) goto L84;
    L61:
        if (r1.intValue() == 6) goto L84;
    L57:
        if (r1.intValue() == 7) goto L84;
    L46:
        if (r1.intValue() != 3) goto L48;
        return 1;
    L23:
        if (r2.intValue() != 5) goto L25;
        return 10;
    L5:
        r2 = null;
        goto L6
    }

    public final int getItemViewType(int r7) {
        UserCreation r1 = null;
        if (this.r == false) goto L22;
        if (r7 != 0) goto L8;
        return 3;
    L8:
        if (r7 != 1) goto L13;
        if (Intrinsics.areEqual(this.q, d.f.a) == true) goto L13;
        return 4;
    L13:
        if (r7 == (this.b.size() + 1)) goto L15;
    L17:
        List<UserCreationModel> r0 = this.b;
        List<UserCreation> r8 = ((UserCreationModel) ListProtector.get(r0, r7 - 1)).b();
        if (r8 == null) goto L21;
        r1 = (UserCreation) CollectionsKt.firstOrNull(r8);
    L21:
        return D2(r1);
    L15:
        if (Intrinsics.areEqual(this.q, d.f.a) == false) goto L17;
        return 2;
    L22:
        if (r7 != 0) goto L27;
        if (Intrinsics.areEqual(this.q, d.f.a) == true) goto L27;
        return 4;
    L27:
        if (r7 != this.b.size()) goto L29;
        return 2;
    L29:
        List<UserCreation> r9 = ((UserCreationModel) ListProtector.get(this.b, r7)).b();
        if (r9 == null) goto L33;
        r1 = (UserCreation) CollectionsKt.firstOrNull(r9);
    L33:
        return D2(r1);
    }

    public final void onAttachedToRecyclerView(RecyclerView r4) {
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        final GridLayoutManager r0 = r4.getLayoutManager();
        if ((r0 instanceof GridLayoutManager) == false) goto L5;
        r0.setSpanSizeLookup(new AnonymousClass1(this, r0));
    L5:
        super.onAttachedToRecyclerView(r4);
        r4.removeOnLayoutChangeListener(this.w);
        r4.addOnLayoutChangeListener(this.w);
    }

    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onDetachedFromRecyclerView(r2);
        r2.removeOnLayoutChangeListener(this.w);
        A2();
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r10) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        super.onViewRecycled(r10);
        long r0 = System.nanoTime();
        if ((r10 instanceof q) == false) goto L5;
        ((q) r10).onViewRecycled();
    L5:
        f r2 = this.i;
        if (r2 == null) goto L9;
        String r3 = r2.c;
        if (r3 == null) goto L9;
    L10:
        j.a("recycle", r3, r10.getItemViewType(), r10.getBindingAdapterPosition(), System.nanoTime() - r0);
        return;
    L9:
        r3 = "";
        goto L10
    }

    public final void y2(int r6) {
        int r0 = this.m;
        if (r6 <= 0) goto L5;
        this.m = ((r6 - i5.e0()) - ((this.a - 1) * i5.e0())) / this.a;
    L5:
        boolean r1 = w0a.a.a;
        w0a.a.c("CreationListAdapter", this.h + "screenWidth is " + r6 + " itemWidth is " + this.m);
        if (r0 == this.m) goto L9;
        w0a.a.c("CreationListAdapter", this.h + "notifyDataSetChanged screenWidth is " + r6 + " itemWidth is " + this.m + " lastItemWidth is " + r0);
        notifyDataSetChanged();
        return;
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [android.view.ViewGroup, com.larus.ugc.feed.impl.widget.CreationLoadingAndRetryView, java.lang.Object] */
    public final void onBindViewHolder(RecyclerView.ViewHolder r31, int r32) {
        int r4 = r32;
        Intrinsics.checkNotNullParameter(r31, "holder");
        long r2 = System.nanoTime();
        if (this.r == false) goto L5;
        final int r7 = r4 - 1;
    L7:
        if ((r31 instanceof CreationAvatarEntranceViewHolder) == false) goto L10;
        ((CreationAvatarEntranceViewHolder) r31).T3(this.m, this.c, this.i);
    L79:
        CreationListAdapter r8 = this;
        RecyclerView.ViewHolder r0 = r31;
        long r22 = r2;
        String r3 = "";
    L384:
        r8.z2(r8.getItemViewType(r4), r0);
        f r1 = r8.i;
        if (r1 == null) goto L390;
        String r5 = r1.c;
        if (r5 == null) goto L390;
        r3 = r5;
    L390:
        j.a("bind", r3, r8.getItemViewType(r4), r32, System.nanoTime() - r22);
        return;
    L10:
        if ((r31 instanceof CreationSelfPrivateViewHolder) == false) goto L81;
        final CreationSelfPrivateViewHolder r6 = (CreationSelfPrivateViewHolder) r31;
        UserCreationModel r14 = (UserCreationModel) ListProtector.get(this.b, r7);
        int r13 = this.m;
        final k r9 = this.l;
        r6.getClass();
        if (r14 == null) goto L79;
        List<UserCreation> r17 = r14.b();
        if (r17 == null) goto L79;
        UserCreation r10 = (UserCreation) CollectionsKt.firstOrNull(r17);
        if (r10 == null) goto L79;
        int r11 = r10.b;
        switch(r11) {
            case 1: goto L42;
            case 2: goto L49;
            case 3: goto L35;
            case 4: goto L28;
            case 5: goto L49;
            case 6: goto L21;
            case 7: goto L21;
            case 8: goto L21;
            case 9: goto L21;
            case 10: goto L21;
            case 11: goto L21;
            case 12: goto L21;
            default: goto L49;
        };
    L21:
        UserCreationContent r12 = r10.e;
        if (r12 == null) goto L56;
        VideoUserContent r15 = r12.e;
        if (r15 == null) goto L56;
        ImageInfo r16 = r15.b;
        if (r16 == null) goto L56;
        Image r18 = r16.b;
    L57:
        if (r11 != 1) goto L59;
        e1.x(r6.b);
    L61:
        if (CollectionsKt.listOf(new Integer[]{7, 6, 8, 9, 10, 11, 12}).contains(Integer.valueOf(r10.b)) == false) goto L63;
        e1.x(r6.d);
    L64:
        SimpleDraweeView r19 = r6.a;
        ViewGroup.LayoutParams r110 = r19.getLayoutParams();
        r110.height = r13;
        r19.setLayoutParams(r110);
        SimpleDraweeView r20 = r6.a;
        if (r18 == null) goto L67;
        String r21 = r18.a;
    L68:
        ImageLoaderKt.y(r20, r21, "community_creation_photo", new d1a.a(r6), 4);
        e1.d(r6.a, new d1a.b(r9, r7));
        r6.a.setOnLongClickListener(new d1a.c(r9, r6, r7));
        List<UserCreation> r23 = r14.b();
        if (r23 == null) goto L71;
        int r111 = r23.size();
        int r24 = 1;
    L72:
        if (r111 < r24) goto L78;
        TextView r25 = r6.c;
        List<UserCreation> r26 = r14.b();
        if (r26 == null) goto L76;
        Integer r112 = Integer.valueOf(r26.size());
    L77:
        r25.setText(String.valueOf(r112));
        e1.x(r6.c);
        goto L79
    L76:
        r112 = null;
        goto L77
    L78:
        e1.o(r6.c);
        goto L79
    L71:
        r24 = 1;
        r111 = 0;
        goto L72
    L67:
        r21 = null;
        goto L68
    L63:
        e1.o(r6.d);
        goto L64
    L59:
        e1.o(r6.b);
    L56:
        r18 = null;
        goto L57
    L28:
        UserCreationContent r27 = r10.e;
        if (r27 == null) goto L56;
        AiBeautifyUserContent r28 = r27.d;
        if (r28 == null) goto L56;
        ImageInfo r29 = r28.a;
        if (r29 == null) goto L56;
        r18 = r29.b;
        goto L57
    L35:
        UserCreationContent r30 = r10.e;
        if (r30 == null) goto L56;
        UserCreationUserAvatar r33 = r30.c;
        if (r33 == null) goto L56;
        ImageInfo r34 = r33.a;
        if (r34 == null) goto L56;
        r18 = r34.b;
        goto L57
    L42:
        UserCreationContent r35 = r10.e;
        if (r35 == null) goto L56;
        UserCreationMusic r36 = r35.b;
        if (r36 == null) goto L56;
        ImageInfo r37 = r36.d;
        if (r37 == null) goto L56;
        r18 = r37.b;
        goto L57
    L49:
        UserCreationContent r38 = r10.e;
        if (r38 == null) goto L56;
        UserCreationImage r39 = r38.a;
        if (r39 == null) goto L56;
        ImageInfo r40 = r39.a;
        if (r40 == null) goto L56;
        r18 = r40.b;
        goto L57
    L81:
        if ((r31 instanceof CreationBannedViewHolder) == false) goto L111;
        final CreationBannedViewHolder r41 = (CreationBannedViewHolder) r31;
        List<UserCreation> r42 = ((UserCreationModel) ListProtector.get(this.b, r7)).b();
        if (r42 == null) goto L85;
        UserCreation r43 = (UserCreation) CollectionsKt.firstOrNull(r42);
    L86:
        int r113 = this.m;
        final k r114 = this.l;
        f r115 = this.i;
        if (r43 != null) goto L89;
        r41.getClass();
        goto L79
    L89:
        r41.b.setText(2131901224);
        r41.b.setShadowLayer(c7.c(2), 0.0f, 0.0f, ColorProtector.parseColor("#80000000"));
        AuthorInfo r44 = r43.g;
        View r45 = r41.c;
        ViewGroup.LayoutParams r116 = r45.getLayoutParams();
        r116.height = r113;
        r45.setLayoutParams(r116);
        ((RecyclerView.ViewHolder) r41).itemView.setOnLongClickListener(new h(r114, r41, r7));
        if (r115 == null) goto L109;
        boolean r46 = r115.p;
        Long r47 = r43.f;
        if (r47 == null) goto L94;
        long r48 = r47.longValue();
    L95:
        CommonAuthorInfoLayout r49 = r41.a;
        if (r46 == false) goto L98;
        int r50 = 0;
    L99:
        r49.setVisibility(r50);
        CommonAuthorInfoLayout r51 = r41.a;
        if (r44 == null) goto L102;
        String r117 = r44.c;
    L103:
        r51.a(r117, m0.a());
        CommonAuthorInfoLayout r52 = r41.a;
        if (r44 == null) goto L107;
        String r53 = r44.a;
        if (r53 == null) goto L107;
    L108:
        r52.setAuthorName(r53);
        r41.a.setUseCount(r48);
    L107:
        r53 = "";
        goto L108
    L102:
        r117 = null;
        goto L103
    L98:
        r50 = 8;
        goto L99
    L94:
        r48 = 0;
        goto L95
    L109:
        e1.o(r41.a);
        goto L79
    L85:
        r43 = null;
        goto L86
    L111:
        if ((r31 instanceof CreationVideoViewHolder) == false) goto L121;
        List<UserCreation> r54 = ((UserCreationModel) ListProtector.get(this.b, r7)).b();
        if (r54 == null) goto L115;
        UserCreation r55 = (UserCreation) CollectionsKt.firstOrNull(r54);
    L116:
        CreationVideoViewHolder r56 = (CreationVideoViewHolder) r31;
        if (r55 == null) goto L119;
        UserCreationKmp r57 = B2(r55);
    L120:
        r22 = r2;
        r3 = "";
        r56.U3(r7, r57, this.m, this.l, this.c, this.f, this.i, this.j, r55);
    L157:
        r8 = this;
        r0 = r31;
        goto L384
    L119:
        r57 = null;
        goto L120
    L115:
        r55 = null;
        goto L116
    L121:
        r22 = r2;
        r3 = "";
        if ((r31 instanceof CreationImageToImageViewHolder) == false) goto L131;
        CreationImageToImageViewHolder r58 = (CreationImageToImageViewHolder) r31;
        List<UserCreation> r59 = ((UserCreationModel) ListProtector.get(this.b, r7)).b();
        if (r59 == null) goto L128;
        UserCreation r60 = (UserCreation) CollectionsKt.firstOrNull(r59);
        if (r60 == null) goto L128;
        UserCreationKmp r61 = B2(r60);
    L129:
        r58.T3(r7, r61, this.m, this.l, this.c, this.f, this.i);
    L128:
        r61 = null;
        goto L129
    L131:
        if ((r31 instanceof CreationAIBeautifyViewHolder) == false) goto L140;
        CreationAIBeautifyViewHolder r62 = (CreationAIBeautifyViewHolder) r31;
        List<UserCreation> r63 = ((UserCreationModel) ListProtector.get(this.b, r7)).b();
        if (r63 == null) goto L137;
        UserCreation r64 = (UserCreation) CollectionsKt.firstOrNull(r63);
        if (r64 == null) goto L137;
        UserCreationKmp r65 = B2(r64);
    L138:
        r62.T3(r7, r65, this.m, this.l, this.c, this.f, this.i);
    L137:
        r65 = null;
        goto L138
    L140:
        if ((r31 instanceof CreationAvatarViewHolder) == false) goto L149;
        CreationAvatarViewHolder r66 = (CreationAvatarViewHolder) r31;
        List<UserCreation> r67 = ((UserCreationModel) ListProtector.get(this.b, r7)).b();
        if (r67 == null) goto L146;
        UserCreation r68 = (UserCreation) CollectionsKt.firstOrNull(r67);
        if (r68 == null) goto L146;
        UserCreationKmp r69 = B2(r68);
    L147:
        r66.T3(r7, r69, this.m, this.l, this.c, this.f, this.i);
    L146:
        r69 = null;
        goto L147
    L149:
        if ((r31 instanceof CreationImageViewHolder) == false) goto L159;
        CreationImageViewHolder r70 = (CreationImageViewHolder) r31;
        List<UserCreation> r71 = ((UserCreationModel) ListProtector.get(this.b, r7)).b();
        if (r71 == null) goto L155;
        UserCreation r72 = (UserCreation) CollectionsKt.firstOrNull(r71);
        if (r72 == null) goto L155;
        UserCreationKmp r73 = B2(r72);
    L156:
        r70.T3(r7, r73, this.m, this.l, this.c, this.f, this.i);
    L155:
        r73 = null;
        goto L156
    L159:
        if ((r31 instanceof CreationMusicViewHolder) == false) goto L320;
        final CreationMusicViewHolder r74 = (CreationMusicViewHolder) r31;
        List<UserCreation> r75 = ((UserCreationModel) ListProtector.get(this.b, r7)).b();
        if (r75 == null) goto L163;
        final UserCreation r76 = (UserCreation) CollectionsKt.firstOrNull(r75);
    L164:
        int r77 = this.m;
        final k r78 = this.l;
        LifecycleCoroutineScope r118 = this.c;
        final int r119 = this.f;
        f r120 = this.i;
        r74.getClass();
        if (r119 == 1) goto L167;
    L172:
        if (r76 == null) goto L319;
        Integer r121 = r76.c;
        Integer r122 = r76.d;
        UserCreationContent r123 = r76.e;
        if (r123 == null) goto L179;
        UserCreationMusic r124 = r123.b;
        if (r124 == null) goto L179;
        ImageInfo r125 = r124.d;
    L180:
        if (r125 == null) goto L184;
        Image r79 = r125.b;
        if (r79 == null) goto L184;
        Long r80 = Long.valueOf(r79.d);
    L185:
        if (r125 == null) goto L189;
        Image r81 = r125.b;
        if (r81 == null) goto L189;
        Long r82 = Long.valueOf(r81.c);
    L190:
        int r83 = (r77 * 16) / 9;
        if (r82 == null) goto L213;
        if (r80 == null) goto L213;
        final Integer r84 = r121;
        Integer r126 = r122;
        if (((int) r82.longValue()) != 0) goto L196;
    L214:
        ImageViewWithLastMotion r85 = r74.a;
        ViewGroup.LayoutParams r86 = r85.getLayoutParams();
        r86.height = r83;
        r85.setLayoutParams(r86);
        if (r74.h.getVisibility() != 0) goto L217;
        boolean r87 = true;
    L218:
        if (r87 == false) goto L236;
        if (r118 == null) goto L236;
        UserCreationContent r88 = r76.e;
        if (r88 == null) goto L236;
        UserCreationMusic r89 = r88.b;
        if (r89 == null) goto L236;
        String r90 = r89.h;
        if (r90 == null) goto L236;
        if (r90.length() <= 0) goto L230;
        boolean r91 = true;
    L231:
        if (r91 == true) goto L234;
        r90 = null;
    L234:
        if (r90 == null) goto L236;
        r74.h.S5(r118, new com.larus.bmhome.bigimg.download.d.b(r90));
        goto L236
    L230:
        r91 = false;
    L236:
        AuthorInfo r92 = r76.g;
        if (r92 == null) goto L255;
        if (r120 != null) goto L240;
    L242:
        boolean r93 = false;
    L243:
        if (r93 == true) goto L246;
        r92 = null;
    L246:
        if (r92 == null) goto L255;
        Long r94 = r76.f;
        if (r94 == null) goto L250;
        long r127 = r94.longValue();
    L251:
        r74.b.setVisibility(0);
        r74.b.a(r92.c, m0.a());
        CommonAuthorInfoLayout r95 = r74.b;
        String r128 = r92.a;
        if (r128 != null) goto L254;
        r128 = r3;
    L254:
        r95.setAuthorName(r128);
        r74.b.setUseCount(r127);
    L256:
        if (r126 != null) goto L259;
    L263:
        FrameLayout r96 = r74.f;
        if (r96 == null) goto L266;
        e1.x(r96);
    L266:
        r74.U3(r3, r74.g);
        UserCreationContent r97 = r76.e;
        if (r97 == null) goto L273;
        UserCreationMusic r98 = r97.b;
        if (r98 == null) goto L273;
        ImageInfo r99 = r98.d;
        if (r99 == null) goto L273;
        Image r100 = r99.b;
    L274:
        ImageViewWithLastMotion r101 = r74.a;
        if (r84 != null) goto L278;
    L280:
        if (r100 == null) goto L285;
        String r102 = r100.a;
        if (r102 == null) goto L285;
        Uri r103 = UriProtector.parse(r102);
    L284:
        Uri r210 = r103;
    L286:
        ImageLoaderKt.x(r101, r210, "template_item_photo", null, new t(r74, r119, r84, r76), 4);
        TextView r104 = r74.d;
        UserCreationContent r105 = r76.e;
        if (r105 == null) goto L291;
        UserCreationMusic r106 = r105.b;
        if (r106 == null) goto L291;
        String r107 = r106.b;
    L292:
        r104.setText(r107);
        TextView r108 = r74.e;
        UserCreationContent r109 = r76.e;
        if (r109 == null) goto L297;
        UserCreationMusic r129 = r109.b;
        if (r129 == null) goto L297;
        String r130 = r129.i;
    L298:
        r108.setText(r130);
        FrameLayout r131 = r74.f;
        if (r131 == null) goto L313;
        IMusicService r132 = (IMusicService) ServiceManager.get().getService(IMusicService.class);
        if (r132 == null) goto L313;
        Gson r133 = n0.a;
        UserCreationContent r134 = r76.e;
        if (r134 == null) goto L305;
        UserCreationMusic r135 = r134.b;
    L306:
        String r136 = GsonProtectorUtils.toJson(r133, r135);
        if (r119 != 1) goto L309;
    L311:
        String r137 = "creation_list";
    L312:
        r132.b(r131, r136, r7, r137);
        goto L313
    L309:
        if (r119 == 2) goto L311;
        r137 = "creation_others";
        goto L312
    L305:
        r135 = null;
    L313:
        e1.d(r74.a, new u(r78, r7));
        e1.d(r74.b, new v(r78, r7));
        e1.d(r74.c, new w(r78, r7));
        e1.d(r74.h, new x(r78, r76));
        r74.a.setOnLongClickListener(new y(r78, r74, r7));
        r74.b.setOnLongClickListener(new z(r78, r74, r7));
        Integer r138 = r76.c;
        if (r138 == null) goto L319;
        if (r138.intValue() != 5) goto L319;
        r74.a.setOnClickListener(null);
        r74.b.setOnClickListener(null);
        r74.c.setOnClickListener(null);
        r74.h.setOnClickListener(null);
        r74.a.setOnLongClickListener(null);
        r74.b.setOnClickListener(null);
        r74.c.setOnClickListener(null);
        r74.h.setOnClickListener(null);
    L297:
        r130 = null;
    L291:
        r107 = null;
    L285:
        r210 = null;
        goto L286
    L278:
        if (r84.intValue() != 5) goto L280;
        r103 = UriProtector.parse("res://" + AppHost.a.getApplication().getPackageName() + "/2131240130");
    L273:
        r100 = null;
        goto L274
    L259:
        if (r126.intValue() != 2) goto L263;
        FrameLayout r139 = r74.f;
        if (r139 == null) goto L266;
        e1.x(r139);
        goto L266
    L250:
        r127 = 0;
        goto L251
    L240:
        if (r120.p != true) goto L242;
        r93 = true;
    L255:
        e1.o(r74.b);
        goto L256
    L217:
        r87 = false;
        goto L218
    L196:
        if (r77 == (-1)) goto L214;
        int r140 = (int) ((((long) r77) * r80.longValue()) / r82.longValue());
        if (r140 > r83) goto L204;
        r83 = (r77 * 9) / 16;
        if (r140 < r83) goto L204;
        r83 = r140;
    L204:
        boolean r141 = w0a.a.a;
        StringBuilder r142 = new StringBuilder("position is ");
        r142.append(r74.getPosition());
        r142.append(" ; template width is ");
        Image r143 = r125.b;
        if (r143 == null) goto L207;
        Long r144 = Long.valueOf(r143.c);
    L208:
        r142.append(r144);
        r142.append(" height is ");
        Image r145 = r125.b;
        if (r145 == null) goto L211;
        Long r146 = Long.valueOf(r145.d);
    L212:
        r142.append(r146);
        r142.append(" ; itemWidth is ");
        r142.append(r77);
        r142.append(" height is ");
        r142.append(r74.a.getLayoutParams().height);
        w0a.a.c("CreationMusicViewHolder", r142.toString());
        goto L214
    L211:
        r146 = null;
        goto L212
    L207:
        r144 = null;
    L213:
        r84 = r121;
        r126 = r122;
    L189:
        r82 = null;
    L184:
        r80 = null;
    L179:
        r125 = null;
    L319:
        r8 = this;
        r0 = r31;
    L332:
        r4 = r32;
        goto L384
    L167:
        if (com.larus.bmhome.utils.u.b() == false) goto L172;
        CommonDownLoadLayout r147 = r74.h;
        if (r147 == null) goto L171;
        r147.setDownloadIcon(2131240150);
    L171:
        e1.x(r74.h);
        goto L172
    L163:
        r76 = null;
        goto L164
    L320:
        r0 = r31;
        if ((r0 instanceof CreationMoreViewHolder) == false) goto L329;
        CreationMoreViewHolder r148 = (CreationMoreViewHolder) r0;
        r8 = this;
        b r149 = r8.p;
        boolean r150 = r8.g;
        f r151 = r8.i;
        if (r151 == null) goto L327;
        Integer r152 = r151.g;
        if (r152 == null) goto L327;
        int r153 = r152.intValue();
    L328:
        r148.T3(r149, r150, r153);
    L327:
        r153 = 0;
        goto L328
    L329:
        r8 = this;
        if ((r0 instanceof AbsCreationFeedHeaderViewHolder) == false) goto L334;
        ((AbsCreationFeedHeaderViewHolder) r0).T3();
        goto L332
    L334:
        if ((r0 instanceof CreationLoadingAndRetryViewHolder) == false) goto L378;
        CreationLoadingAndRetryViewHolder r154 = (CreationLoadingAndRetryViewHolder) r0;
        d r155 = r8.q;
        r154.getClass();
        Intrinsics.checkNotNullParameter(r155, "state");
        ?? r156 = r154.a;
        r156.getClass();
        Intrinsics.checkNotNullParameter(r155, "state");
        if (Intrinsics.areEqual(r155, d.e.a) == false) goto L338;
    L375:
        e1.x(r156.a.b);
        e1.o(r156.a.c);
        View r157 = r156.d;
        if (r157 == null) goto L332;
        e1.o(r157);
        goto L332
    L338:
        if (Intrinsics.areEqual(r155, d.C0068d.a) == true) goto L375;
        if ((r155 instanceof d.c) == false) goto L343;
    L372:
        e1.o(r156.a.b);
        e1.x(r156.a.c);
        View r158 = r156.d;
        if (r158 == null) goto L332;
        e1.o(r158);
        goto L332
    L343:
        if (Intrinsics.areEqual(r155, d.a.a) == true) goto L372;
        if (Intrinsics.areEqual(r155, d.f.a) == false) goto L349;
        e1.o(r156.a.b);
        e1.o(r156.a.c);
        goto L332
    L349:
        if (Intrinsics.areEqual(r155, d.b.a) == false) goto L368;
        e1.o(r156.a.b);
        e1.o(r156.a.c);
        if (r156.d != null) goto L365;
        Function0<? extends View> r159 = r156.c;
        if (r159 == null) goto L365;
        View r160 = (View) r159.invoke();
        if (r160 == null) goto L365;
        if (r156.d != null) goto L365;
        ViewParent r161 = r160.getParent();
        if ((r161 instanceof ViewGroup) == false) goto L361;
        ViewGroup r162 = (ViewGroup) r161;
    L362:
        if (r162 == null) goto L364;
        r162.removeView(r160);
    L364:
        ConstraintLayout.LayoutParams r163 = new ConstraintLayout.LayoutParams(-1, -2);
        r163.startToStart = 0;
        r163.endToEnd = 0;
        r163.topToTop = 0;
        Unit r164 = Unit.INSTANCE;
        r156.addView(r160, r163);
        r156.d = r160;
        e1.o(r160);
        goto L365
    L361:
        r162 = null;
    L365:
        View r165 = r156.d;
        if (r165 == null) goto L332;
        e1.x(r165);
        goto L332
    L368:
        View r166 = r156.d;
        if (r166 == null) goto L371;
        e1.o(r166);
    L371:
        e1.o(r156.a.b);
        e1.o(r156.a.c);
        goto L332
    L378:
        StaggeredGridLayoutManager.LayoutParams r167 = r0.itemView.getLayoutParams();
        if ((r167 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L381;
        StaggeredGridLayoutManager.LayoutParams r168 = r167;
    L382:
        if (r168 == null) goto L332;
        r168.setFullSpan(true);
        goto L332
    L381:
        r168 = null;
        goto L382
    L5:
        r7 = r4;
        goto L7
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        long r0 = System.nanoTime();
        switch(r11) {
            case 0: goto L26;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L18;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L4;
        };
    L4:
        CreationDetailHeadInspirationViewHolder r2 = new CommonViewHolder(new View(r10.getContext()));
    L27:
        f r12 = this.i;
        if (r12 == null) goto L31;
        String r13 = r12.c;
        if (r13 == null) goto L31;
    L32:
        j.a("create", r13, r11, r2.getBindingAdapterPosition(), System.nanoTime() - r0);
        return r2;
    L31:
        r13 = "";
        goto L32
    L5:
        View r14 = LayoutInflater.from(r10.getContext()).inflate(2131561948, r10, false);
        Intrinsics.checkNotNull(r14);
        r2 = new CreationAvatarEntranceViewHolder(r14);
        goto L27
    L6:
        View r15 = LayoutInflater.from(r10.getContext()).inflate(2131561951, r10, false);
        Intrinsics.checkNotNull(r15);
        r2 = new CreationBannedViewHolder(r15);
        goto L27
    L7:
        View r16 = LayoutInflater.from(r10.getContext()).inflate(2131561945, r10, false);
        Intrinsics.checkNotNull(r16);
        r2 = new CreationImageToImageViewHolder(r16);
        goto L27
    L8:
        View r17 = LayoutInflater.from(r10.getContext()).inflate(2131561955, r10, false);
        Intrinsics.checkNotNull(r17);
        r2 = new CreationVideoViewHolder(r17);
        goto L27
    L9:
        r2 = new CreationSelfPrivateViewHolder(r10);
        goto L27
    L10:
        View r18 = LayoutInflater.from(r10.getContext()).inflate(2131561945, r10, false);
        Intrinsics.checkNotNull(r18);
        r2 = new CreationAIBeautifyViewHolder(r18);
        goto L27
    L11:
        View r19 = LayoutInflater.from(r10.getContext()).inflate(2131561973, r10, false);
        Intrinsics.checkNotNull(r19);
        r2 = new CreationMusicViewHolder(r19);
        goto L27
    L12:
        View r110 = LayoutInflater.from(r10.getContext()).inflate(2131561959, r10, false);
        Intrinsics.checkNotNull(r110);
        r2 = new CreationLoadingAndRetryViewHolder(r110);
        Function0<Unit> r111 = new p0a.d(this);
        r2.a.setOnRetryClickListener(r111);
        f r112 = this.i;
        if (r112 == null) goto L16;
        RecyclerView.ItemDecoration r113 = r112.t;
        if (r113 == null) goto L16;
    L17:
        Intrinsics.checkNotNullParameter(r113, "itemDecoration");
        CreationLoadingAndRetryView r4 = r2.a;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r113, "itemDecoration");
        r4.a.b.addItemDecoration(r113);
        Function0<View> r114 = this.e;
        r2.a.setEmptyCreator(r114);
    L16:
        r113 = new LoadingItemDecoration(this.a, i5.e0());
        goto L17
    L18:
        p r3 = this.d;
        if (r3 == null) goto L23;
        r2 = r3.a(r10);
        if (r2 != null) goto L27;
    L23:
        r2 = new CommonViewHolder(new View(r10.getContext()));
        goto L27
    L24:
        View r115 = LayoutInflater.from(r10.getContext()).inflate(2131561963, r10, false);
        Intrinsics.checkNotNull(r115);
        r2 = new CreationMoreViewHolder(r115);
        Function0<Unit> r116 = new p0a.c(this);
        r2.a.setOnErrorClickListener(r116);
        goto L27
    L25:
        View r117 = LayoutInflater.from(r10.getContext()).inflate(2131561945, r10, false);
        Intrinsics.checkNotNull(r117);
        r2 = new CreationAvatarViewHolder(r117);
        goto L27
    L26:
        View r118 = LayoutInflater.from(r10.getContext()).inflate(2131561945, r10, false);
        Intrinsics.checkNotNull(r118);
        r2 = new CreationImageViewHolder(r118);
        goto L27
    }

    public final boolean z2(int r2, RecyclerView.ViewHolder r3) {
        if (r2 != 2) goto L5;
    L10:
        StaggeredGridLayoutManager.LayoutParams r4 = null;
        if (r3 == null) goto L15;
        View r5 = r3.itemView;
        if (r5 == null) goto L15;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
    L17:
        if ((r6 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L20;
        r4 = (StaggeredGridLayoutManager.LayoutParams) r6;
    L20:
        if (r4 == null) goto L22;
        r4.setFullSpan(true);
    L22:
        return true;
    L15:
        r6 = null;
        goto L17
    L5:
        if (r2 == 3) goto L10;
        if (r2 == 4) goto L10;
        return false;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List<Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        if ((!r4.isEmpty()) == true) goto L5;
    L13:
        super.onBindViewHolder(r2, r3, r4);
        return;
    L5:
        if ((r2 instanceof CreationMoreViewHolder) == false) goto L13;
        CreationMoreViewHolder r5 = (CreationMoreViewHolder) r2;
        b r6 = this.p;
        boolean r7 = this.g;
        f r0 = this.i;
        if (r0 == null) goto L11;
        Integer r1 = r0.g;
        if (r1 == null) goto L11;
        int r8 = r1.intValue();
    L12:
        r5.T3(r6, r7, r8);
        return;
    L11:
        r8 = 0;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v9, types: [p0a.g] */
    public CreationListAdapter(int r2, List<UserCreationModel> r3, LifecycleCoroutineScope r4, p r5, Function0<? extends View> r6, @CreationFeedType int r7, boolean r8, String r9, f r10, c r11, RecyclerView.RecycledViewPool r12) {
        Intrinsics.checkNotNullParameter(r3, "dataList");
        Intrinsics.checkNotNullParameter(r4, "lifeCycleScope");
        Intrinsics.checkNotNullParameter(r9, "tag");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.m = -1;
        this.n = -1;
        this.o = new IdentityHashMap();
        this.p = b.d.a;
        this.q = d.C0068d.a;
        if (r5 == null) goto L5;
        boolean r13 = true;
    L6:
        this.r = r13;
        this.v = LazyKt.lazy(new p0a.f(this));
        this.w = new g(this);
        return;
    L5:
        r13 = false;
        goto L6
    }
}
