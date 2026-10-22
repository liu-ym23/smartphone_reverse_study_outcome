package com.larus.community.impl.adapter;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.MessageQueue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
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
import com.larus.bmhome.bigimg.download.d;
import com.larus.bmhome.chat.api.IMusicService;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;
import com.larus.bmhome.utils.u;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.common_ui.widget.CommonAuthorInfoLayout;
import com.larus.community.impl.viewholder.CommonViewHolder;
import com.larus.community.impl.viewholder.CreationAIBeautifyViewHolder;
import com.larus.community.impl.viewholder.CreationAvatarEntranceViewHolder;
import com.larus.community.impl.viewholder.CreationAvatarViewHolder;
import com.larus.community.impl.viewholder.CreationBannedViewHolder;
import com.larus.community.impl.viewholder.CreationImageToImageViewHolder;
import com.larus.community.impl.viewholder.CreationImageViewHolder;
import com.larus.community.impl.viewholder.CreationLoadingAndRetryViewHolder;
import com.larus.community.impl.viewholder.CreationMoreViewHolder;
import com.larus.community.impl.viewholder.CreationMusicViewHolder;
import com.larus.community.impl.viewholder.CreationVideoViewHolder;
import com.larus.community.impl.viewholder.b0;
import com.larus.community.impl.viewholder.c0;
import com.larus.community.impl.viewholder.d0;
import com.larus.community.impl.viewholder.f0;
import com.larus.community.impl.viewholder.g0;
import com.larus.community.impl.viewholder.h0;
import com.larus.community.impl.viewholder.i0;
import com.larus.community.impl.viewholder.k0;
import com.larus.community.impl.viewholder.p0;
import com.larus.community.impl.viewholder.r0;
import com.larus.community.impl.viewholder.selfprivate.CreationSelfPrivateViewHolder;
import com.larus.community.impl.viewholder.x;
import com.larus.community.impl.viewholder.y;
import com.larus.community.impl.viewholder.z;
import com.larus.community.impl.widget.CreationLoadingAndRetryView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AbsCreationFeedHeaderViewHolder;
import com.larus.platform.api.creation.AiBeautifyUserContent;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.CreationFeedType;
import com.larus.platform.api.creation.UnwatermarkedVideoInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.api.creation.UserCreationMusic;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import com.larus.platform.api.creation.VideoInfo;
import com.larus.platform.api.creation.VideoUserContent;
import com.larus.platform.service.z2;
import com.larus.profile.api.bean.UserCreationModel;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import fs9.a0;
import g29.h;
import g29.i;
import i29.c;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import r29.k;
import tx9.n0;
import v19.c7;
import v19.i5;
import zp9.f;
import zp9.g;
import zp9.p;
import zp9.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003abcB\u008b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u00020,J\b\u00102\u001a\u00020,H\u0002J\b\u0010<\u001a\u00020\u0011H\u0002J\u0010\u0010=\u001a\u00020\u00112\u0006\u0010>\u001a\u00020\u0011H\u0002J\u0010\u0010A\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010B\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\u000e\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020\u0004J\u001a\u0010E\u001a\u00020,2\u0006\u0010F\u001a\u00020\u00042\b\b\u0002\u0010D\u001a\u00020\u0004H\u0007J\u0018\u0010G\u001a\u00020,2\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010IH\u0007J\u000e\u0010J\u001a\u00020,2\u0006\u0010\"\u001a\u00020#J\u0018\u0010K\u001a\u00020\u00022\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u0004H\u0016J&\u0010O\u001a\u00020,2\u0006\u0010P\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020\u00042\f\u0010R\u001a\b\u0012\u0004\u0012\u00020S0\u0006H\u0016J\u0018\u0010O\u001a\u00020,2\u0006\u0010P\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020\u0004H\u0016J\b\u0010T\u001a\u00020\u0004H\u0016J\u000e\u0010U\u001a\u00020,2\u0006\u0010&\u001a\u00020'J\u000e\u0010V\u001a\u00020,2\u0006\u0010(\u001a\u00020)J\u0010\u0010W\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u0004H\u0016J\u0012\u0010X\u001a\u00020\u00042\b\u0010Y\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010Z\u001a\u00020\u00042\b\u0010[\u001a\u0004\u0018\u00010\\H\u0002J\u0010\u0010]\u001a\u00020,2\u0006\u0010P\u001a\u00020\u0002H\u0016J\u001a\u0010^\u001a\u00020\u00112\u0006\u0010_\u001a\u00020\u00042\b\u0010`\u001a\u0004\u0018\u00010\u0002H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00106\u001a\n\u0012\u0004\u0012\u00020.\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/larus/community/impl/adapter/CreationListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "spanCount", "", "dataList", "", "Lcom/larus/profile/api/bean/UserCreationModel;", "lifeCycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "headCreator", "Lcom/larus/platform/api/creation/ICreationFeedHeaderCreator;", "emptyViewCreator", "Lkotlin/Function0;", "Landroid/view/View;", "creationFeedType", "disableEndView", "", "tag", "", "initParams", "Lcom/larus/platform/api/creation/CreationFeedInitParams;", "focusHelper", "Lcom/larus/community/impl/component/focus/CreationFeedRVFocusHelper;", "recyclerPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "feedVideoReportHelper", "Lcom/larus/community/impl/tracker/CreationFeedVideoReportHelper;", "<init>", "(ILjava/util/List;Landroidx/lifecycle/LifecycleCoroutineScope;Lcom/larus/platform/api/creation/ICreationFeedHeaderCreator;Lkotlin/jvm/functions/Function0;IZLjava/lang/String;Lcom/larus/platform/api/creation/CreationFeedInitParams;Lcom/larus/community/impl/component/focus/CreationFeedRVFocusHelper;Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;Lcom/larus/community/impl/tracker/CreationFeedVideoReportHelper;)V", "getDataList", "()Ljava/util/List;", "getCreationFeedType", "()I", "creationClickCallBack", "Lcom/larus/community/impl/adapter/ICreationClickCallBack;", "itemWidth", "lastParentWidth", "moreState", "Lcom/larus/profile/api/model/MoreState;", "state", "Lcom/larus/community/impl/view/PageState;", "isShowHeader", "preload", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "destroy", "cleanupIdleHandler", "idleHandlerRegistered", "preloadPendingTasks", "Lkotlin/collections/ArrayDeque;", "preloadRecyclerViewRef", "Ljava/lang/ref/WeakReference;", "idleMessageQueue", "Landroid/os/MessageQueue;", "idleHandler", "Lcom/larus/community/impl/adapter/CreationListAdapter$PreloadIdleHandler;", "onPreloadQueueIdle", "keepPreloadIdleHandler", "hasMoreTasks", "onLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "calculateWidth", "parentWidth", "updateSpanCount", "newSpanCount", "setDataList", "newList", "", "setCreationClickCallBack", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "payloads", "", "getItemCount", "updateMoreState", "updateState", "getItemViewType", "userCreationModelToViewType", "userCreationModel", "userCreationTypeToViewType", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "onViewRecycled", "checkFillColumn", "itemType", "viewHolder", "Companion", "PreloadIdleHandler", "DiffCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Integer[] y = null;
    public int a;
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
    public final p29.b l;
    public i m;
    public int n;
    public int o;
    public gs9.i p;
    public k q;
    public final boolean r;
    public boolean s;
    public ArrayDeque<Integer> t;
    public WeakReference<RecyclerView> u;
    public MessageQueue v;
    public final b w;
    public final g29.f x;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0014\u0010\u0011\u001a\u00020\u0007*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0012H\u0002J\u000e\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u00020\u0012H\u0002J\u000e\u0010\u0018\u001a\u00020\u0015*\u0004\u0018\u00010\u0017H\u0002J\u000e\u0010\u0019\u001a\u00020\u0015*\u0004\u0018\u00010\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u0015*\u0004\u0018\u00010\u001cH\u0002J\u000e\u0010\u001d\u001a\u00020\u0015*\u0004\u0018\u00010\u0015H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/community/impl/adapter/CreationListAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/larus/profile/api/bean/UserCreationModel;", "newItems", "compareMedia", "", "<init>", "(Ljava/util/List;Ljava/util/List;Z)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "oldItemPosition", "newItemPosition", "areContentsTheSame", "hasSameLegacyContent", "Lcom/larus/platform/api/creation/UserCreation;", "oldItem", "contentSignature", "", "displayImageInfo", "Lcom/larus/platform/api/ImageInfo;", "imageInfoSignature", "imageSignature", "Lcom/larus/platform/api/Image;", "videoInfoSignature", "Lcom/larus/platform/api/creation/VideoInfo;", "stableMediaUrl", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.Callback {
        public final List<UserCreationModel> a;
        public final List<UserCreationModel> b;
        public final boolean c;

        public final int getNewListSize() {
            return this.b.size();
        }

        public final int getOldListSize() {
            return this.a.size();
        }

        public static String a(UserCreation r9) {
            UserCreationContent r0 = r9.e;
            String r1 = null;
            if (r0 == null) goto L5;
            VideoUserContent r2 = r0.e;
        L6:
            String[] r3 = new String[11];
            String r4 = r9.a;
            String r5 = "";
            if (r4 != null) goto L9;
            r4 = "";
        L9:
            r3[0] = r4;
            Integer r6 = r9.d;
            if (r6 == null) goto L12;
            String r7 = r6.toString();
        L13:
            if (r7 != null) goto L15;
            r7 = "";
        L15:
            r3[1] = r7;
            Integer r8 = r9.c;
            if (r8 == null) goto L18;
            String r10 = r8.toString();
        L19:
            if (r10 != null) goto L21;
            r10 = "";
        L21:
            r3[2] = r10;
            r3[3] = String.valueOf(r9.b);
            UserCreationContent r11 = r9.e;
            if (r11 == null) goto L26;
            UserCreationMusic r12 = r11.b;
            if (r12 == null) goto L26;
            String r13 = r12.b;
        L27:
            if (r13 == null) goto L30;
            r5 = r13;
        L30:
            r3[4] = r5;
            if (r11 == null) goto L35;
            UserCreationMusic r14 = r11.b;
            if (r14 == null) goto L35;
            ImageInfo r15 = r14.d;
        L36:
            r3[5] = b(r15);
            switch(r9.b) {
                case 2: goto L54;
                case 3: goto L49;
                case 4: goto L44;
                case 5: goto L54;
                case 6: goto L39;
                case 7: goto L39;
                case 8: goto L39;
                case 9: goto L39;
                case 10: goto L39;
                case 11: goto L39;
                case 12: goto L39;
                default: goto L88;
            };
        L39:
            UserCreationContent r16 = r9.e;
            if (r16 == null) goto L59;
            VideoUserContent r17 = r16.e;
            if (r17 == null) goto L81;
            ImageInfo r18 = r17.b;
        L60:
            r3[6] = b(r18);
            if (r2 == null) goto L63;
            VideoInfo r20 = r2.a;
        L64:
            r3[7] = e(r20);
            if (r2 == null) goto L67;
            ImageInfo r21 = r2.b;
        L68:
            r3[8] = b(r21);
            if (r2 == null) goto L73;
            UnwatermarkedVideoInfo r22 = r2.f;
            if (r22 == null) goto L73;
            VideoInfo r23 = r22.a;
        L74:
            r3[9] = e(r23);
            if (r2 == null) goto L79;
            UnwatermarkedVideoInfo r24 = r2.f;
            if (r24 == null) goto L79;
            r1 = r24.b;
        L79:
            r3[10] = d(r1);
            return CollectionsKt.joinToString$default(CollectionsKt.listOf(r3), "|", null, null, 0, null, null, 62, null);
        L73:
            r23 = null;
            goto L74
        L67:
            r21 = null;
            goto L68
        L63:
            r20 = null;
            goto L64
        L81:
            r18 = null;
            goto L60
        L59:
            r18 = null;
            goto L60
        L44:
            UserCreationContent r25 = r9.e;
            if (r25 == null) goto L82;
            AiBeautifyUserContent r26 = r25.d;
            if (r26 == null) goto L83;
            r18 = r26.a;
            goto L60
        L83:
            r18 = null;
            goto L60
        L82:
            r18 = null;
            goto L60
        L49:
            UserCreationContent r27 = r9.e;
            if (r27 == null) goto L84;
            UserCreationUserAvatar r28 = r27.c;
            if (r28 == null) goto L85;
            r18 = r28.a;
            goto L60
        L85:
            r18 = null;
            goto L60
        L84:
            r18 = null;
            goto L60
        L54:
            UserCreationContent r30 = r9.e;
            if (r30 == null) goto L86;
            UserCreationImage r31 = r30.a;
            if (r31 == null) goto L87;
            r18 = r31.a;
            goto L60
        L87:
            r18 = null;
            goto L60
        L86:
            r18 = null;
            goto L60
        L88:
            r18 = null;
        L35:
            r15 = null;
        L26:
            r13 = null;
            goto L27
        L18:
            r10 = null;
            goto L19
        L12:
            r7 = null;
            goto L13
        L5:
            r2 = null;
            goto L6
        }

        public static String b(ImageInfo r9) {
            String r0 = "";
            if (r9 != null) goto L5;
            return "";
        L5:
            String[] r1 = new String[6];
            String r2 = r9.e;
            if (r2 == null) goto L9;
            r0 = r2;
        L9:
            r1[0] = r0;
            r1[1] = c(r9.a);
            r1[2] = c(r9.b);
            r1[3] = c(r9.c);
            r1[4] = c(r9.i);
            r1[5] = c(r9.j);
            return CollectionsKt.joinToString$default(CollectionsKt.listOf(r1), "#", null, null, 0, null, null, 62, null);
        }

        public static String c(Image r9) {
            String r0 = "";
            if (r9 != null) goto L5;
            return "";
        L5:
            String[] r1 = new String[5];
            String r2 = r9.e;
            if (r2 == null) goto L9;
            r0 = r2;
        L9:
            r1[0] = r0;
            r1[1] = d(r9.a);
            r1[2] = d(r9.b);
            r1[3] = String.valueOf(r9.c);
            r1[4] = String.valueOf(r9.d);
            return CollectionsKt.joinToString$default(CollectionsKt.listOf(r1), ",", null, null, 0, null, null, 62, null);
        }

        public static String d(String r3) {
            String r0 = null;
            if (r3 == null) goto L5;
            r0 = StringsKt.substringBefore$default(r3, '?', null, 2, null);
        L5:
            if (r0 != null) goto L8;
            return "";
        L8:
            return r0;
        }

        public static String e(VideoInfo r9) {
            String r0 = "";
            if (r9 != null) goto L5;
            return "";
        L5:
            String[] r1 = new String[5];
            String r2 = r9.a;
            if (r2 != null) goto L8;
            r2 = "";
        L8:
            r1[0] = r2;
            r1[1] = d(r9.b);
            String r3 = r9.c;
            if (r3 != null) goto L11;
            r3 = "";
        L11:
            r1[2] = r3;
            Double r4 = r9.d;
            if (r4 == null) goto L14;
            String r5 = r4.toString();
        L15:
            if (r5 != null) goto L17;
            r5 = "";
        L17:
            r1[3] = r5;
            String r10 = r9.e;
            if (r10 == null) goto L21;
            r0 = r10;
        L21:
            r1[4] = r0;
            return CollectionsKt.joinToString$default(CollectionsKt.listOf(r1), ",", null, null, 0, null, null, 62, null);
        L14:
            r5 = null;
            goto L15
        }

        public final boolean areContentsTheSame(int r6, int r7) {
            List r8 = ((UserCreationModel) ListProtector.get(this.b, r7)).b();
            if (r8 != null) goto L5;
            r8 = CollectionsKt.emptyList();
        L5:
            List r9 = ((UserCreationModel) ListProtector.get(this.a, r6)).b();
            if (r9 != null) goto L9;
            r9 = CollectionsKt.emptyList();
        L9:
            if (this.c == true) goto L61;
            UserCreation r10 = (UserCreation) CollectionsKt.firstOrNull(r8);
            if (r10 != null) goto L13;
            return false;
        L13:
            UserCreation r11 = (UserCreation) CollectionsKt.firstOrNull(r9);
            if (r11 != null) goto L17;
            return false;
        L17:
            if (Intrinsics.areEqual(r10.a, r11.a) == true) goto L19;
        L25:
            boolean r0 = false;
        L27:
            if (r10.b != 1) goto L59;
            if (r0 == false) goto L57;
            UserCreationContent r1 = r10.e;
            String r3 = null;
            if (r1 == null) goto L34;
            UserCreationMusic r2 = r1.b;
            if (r2 == null) goto L34;
            ImageInfo r4 = r2.d;
        L35:
            UserCreationContent r5 = r11.e;
            if (r5 == null) goto L40;
            UserCreationMusic r12 = r5.b;
            if (r12 == null) goto L40;
            ImageInfo r13 = r12.d;
        L42:
            if (Intrinsics.areEqual(r4, r13) == false) goto L57;
            UserCreationContent r14 = r10.e;
            if (r14 == null) goto L48;
            UserCreationMusic r15 = r14.b;
            if (r15 == null) goto L48;
            String r16 = r15.b;
        L49:
            UserCreationContent r17 = r11.e;
            if (r17 == null) goto L55;
            UserCreationMusic r18 = r17.b;
            if (r18 == null) goto L55;
            r3 = r18.b;
        L55:
            if (Intrinsics.areEqual(r16, r3) == false) goto L57;
            return true;
        L48:
            r16 = null;
        L40:
            r13 = null;
        L34:
            r4 = null;
        L57:
            return false;
        L59:
            return r0;
        L19:
            if (Intrinsics.areEqual(r10.d, r11.d) == false) goto L25;
            if (Intrinsics.areEqual(r10.c, r11.c) == false) goto L25;
            if (r10.b != r11.b) goto L25;
            r0 = true;
            goto L27
        L61:
            if (r8.size() == r9.size()) goto L63;
            return false;
        L63:
            List r20 = CollectionsKt.zip(r8, r9);
            if ((r20 instanceof Collection) == true) goto L66;
        L68:
            Iterator r21 = r20.iterator();
        L70:
            if (r21.hasNext() == false) goto L81;
            Pair r22 = (Pair) r21.next();
            if (Intrinsics.areEqual(a((UserCreation) r22.component1()), a((UserCreation) r22.component2())) == true) goto L70;
            return false;
        L81:
            return true;
        L66:
            if (r20.isEmpty() == false) goto L68;
            return true;
        }

        public final boolean areItemsTheSame(int r3, int r4) {
            if (Intrinsics.areEqual(((UserCreationModel) ListProtector.get(this.a, r3)).d(), ((UserCreationModel) ListProtector.get(this.b, r4)).d()) == false) goto L15;
            if (r4 != r3) goto L15;
            List r5 = ((UserCreationModel) ListProtector.get(this.a, r3)).b();
            Integer r0 = null;
            if (r5 == null) goto L8;
            Integer r6 = Integer.valueOf(r5.size());
        L9:
            List r7 = ((UserCreationModel) ListProtector.get(this.b, r4)).b();
            if (r7 == null) goto L13;
            r0 = Integer.valueOf(r7.size());
        L13:
            if (Intrinsics.areEqual(r6, r0) == false) goto L15;
            return true;
        L8:
            r6 = null;
        L15:
            return false;
        }

        public DiffCallback(List<UserCreationModel> r2, List<UserCreationModel> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "oldItems");
            Intrinsics.checkNotNullParameter(r3, "newItems");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class a {
        public static RecyclerView.RecycledViewPool a() {
            RecyclerView.RecycledViewPool r0 = new RecyclerView.RecycledViewPool();
            Integer[] r1 = CreationListAdapter.y;
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

    public static final class b implements MessageQueue.IdleHandler {
        public final WeakReference<CreationListAdapter> a;

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            CreationListAdapter r0 = this.a.get();
            boolean r1 = false;
            if (r0 == null) goto L33;
            ArrayDeque<Integer> r2 = r0.t;
            if (r2 != null) goto L7;
        L10:
            boolean r4 = true;
        L11:
            if (r4 == false) goto L13;
            r0.A2();
            goto L33
        L13:
            WeakReference<RecyclerView> r5 = r0.u;
            if (r5 == null) goto L16;
            RecyclerView r6 = r5.get();
        L17:
            if (r6 != null) goto L19;
            r0.A2();
            goto L33
        L19:
            RecyclerView.RecycledViewPool r3 = r0.k;
            if (r3 != null) goto L22;
            r3 = r6.getRecycledViewPool();
        L22:
            int r7 = ((Number) r2.removeFirst()).intValue();
            if (r3.getRecycledViewCount(r7) < 12) goto L34;
            r1 = !r2.isEmpty();
            if (r1 == true) goto L33;
            r0.A2();
            goto L33
        L34:
            r3.putRecycledView(r0.createViewHolder(r6, r7));     // Catch: Exception -> L29
        L30:
            r1 = !r2.isEmpty();
            if (r1 == true) goto L33;
            r0.A2();
            goto L33
        L16:
            r6 = null;
            goto L17
        L7:
            if (r2.isEmpty() == true) goto L10;
            r4 = false;
        L33:
            return r1;
        }

        public b(CreationListAdapter r2) {
            Intrinsics.checkNotNullParameter(r2, "adapter");
            this.a = new WeakReference(r2);
        }
    }

    static {
        y = new Integer[]{0, 1, 5, 6, 8, 9};
    }

    public final void A2() {
        if (this.s == false) goto L8;
        MessageQueue r0 = this.v;
        if (r0 == null) goto L7;
        r0.removeIdleHandler(this.w);
    L7:
        this.s = false;
        boolean r1 = m29.a.a;
        m29.a.c("CreationListAdapter", this.h + " cleaned up IdleHandler.");
    L8:
        this.t = null;
        this.u = null;
        this.v = null;
    }

    public final int getItemCount() {
        if (Intrinsics.areEqual(this.q, k.e.a) == true) goto L12;
        if (Intrinsics.areEqual(this.q, k.a.a) == true) goto L12;
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

    public final void B2(final gs9.i r3) {
        Intrinsics.checkNotNullParameter(r3, "moreState");
        this.p = r3;
        m29.a.a("CreationListAdapter", new g29.b(this, r3));
        notifyItemChanged(getItemCount() - 1, this.h + "moreState changed");
    }

    public final int C2(UserCreationModel r11) {
        boolean r2 = true;
        if (this.f != 2) goto L11;
        if (r11 != null) goto L6;
    L8:
        boolean r0 = false;
    L9:
        if (r0 == false) goto L11;
        return 10;
    L6:
        if (a0.b(r11) != true) goto L8;
        r0 = true;
    L11:
        Integer r1 = null;
        if (r11 == null) goto L16;
        List r12 = r11.b();
        if (r12 == null) goto L16;
        UserCreation r13 = (UserCreation) CollectionsKt.firstOrNull(r12);
    L18:
        if (this.f != 2) goto L31;
        if (r13 == null) goto L26;
        Integer r14 = r13.c;
        if (r14 == null) goto L26;
        if (r14.intValue() != 100) goto L26;
    L27:
        if (r2 == false) goto L29;
        return 11;
    L29:
        return 7;
    L26:
        r2 = false;
        goto L27
    L31:
        if (r13 == null) goto L38;
        Integer r8 = r13.c;
        if (r8 == null) goto L38;
        if (r8.intValue() != 5) goto L38;
        boolean r9 = true;
    L39:
        if (r9 == true) goto L110;
        if (r13 == null) goto L43;
        r1 = Integer.valueOf(r13.b);
    L43:
        if (r1 == null) goto L49;
        if (r1.intValue() != 2) goto L49;
    L100:
        return 0;
    L49:
        if (r1 == null) goto L55;
        if (r1.intValue() != 5) goto L55;
        return 9;
    L55:
        if (r1 != null) goto L58;
    L60:
        if (r1 != null) goto L63;
    L65:
        if (r1 == null) goto L71;
        if (r1.intValue() != 1) goto L71;
        return 5;
    L71:
        if (r1 != null) goto L74;
    L75:
        if (r1 != null) goto L78;
    L79:
        if (r1 != null) goto L82;
    L83:
        if (r1 != null) goto L86;
    L87:
        if (r1 != null) goto L90;
    L91:
        if (r1 != null) goto L94;
    L95:
        if (r1 == null) goto L100;
        if (r1.intValue() != 12) goto L100;
    L101:
        return 8;
    L94:
        if (r1.intValue() == 11) goto L101;
    L90:
        if (r1.intValue() == 10) goto L101;
    L86:
        if (r1.intValue() == 8) goto L101;
    L82:
        if (r1.intValue() == 9) goto L101;
    L78:
        if (r1.intValue() == 6) goto L101;
    L74:
        if (r1.intValue() == 7) goto L101;
    L63:
        if (r1.intValue() != 3) goto L65;
        return 1;
    L58:
        if (r1.intValue() != 4) goto L60;
        return 6;
    L110:
        return 10;
    L38:
        r9 = false;
    L16:
        r13 = null;
        goto L18
    }

    public final int getItemViewType(int r6) {
        if (this.r == false) goto L19;
        if (r6 != 0) goto L8;
        return 3;
    L8:
        if (r6 != 1) goto L13;
        if (Intrinsics.areEqual(this.q, k.e.a) == true) goto L13;
        return 4;
    L13:
        if (r6 == (this.b.size() + 1)) goto L15;
    L17:
        List<UserCreationModel> r0 = this.b;
        return C2((UserCreationModel) ListProtector.get(r0, r6 - 1));
    L15:
        if (Intrinsics.areEqual(this.q, k.e.a) == false) goto L17;
        return 2;
    L19:
        if (r6 != 0) goto L24;
        if (Intrinsics.areEqual(this.q, k.e.a) == true) goto L24;
        return 4;
    L24:
        if (r6 != this.b.size()) goto L27;
        return 2;
    L27:
        return C2((UserCreationModel) ListProtector.get(this.b, r6));
    }

    public final void onAttachedToRecyclerView(RecyclerView r4) {
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        final GridLayoutManager r0 = r4.getLayoutManager();
        if ((r0 instanceof GridLayoutManager) == false) goto L5;
        r0.setSpanSizeLookup(new AnonymousClass1(this, r0));
    L5:
        super.onAttachedToRecyclerView(r4);
        r4.removeOnLayoutChangeListener(this.x);
        r4.addOnLayoutChangeListener(this.x);
    }

    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onDetachedFromRecyclerView(r2);
        r2.removeOnLayoutChangeListener(this.x);
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
        h.a("recycle", r3, r10.getItemViewType(), r10.getAdapterPosition(), System.nanoTime() - r0);
        return;
    L9:
        r3 = "";
        goto L10
    }

    public final void y2(int r6) {
        int r0 = this.n;
        if (r6 <= 0) goto L5;
        this.n = ((r6 - i5.e0()) - ((this.a - 1) * i5.e0())) / this.a;
    L5:
        boolean r1 = m29.a.a;
        m29.a.c("CreationListAdapter", this.h + "screenWidth is " + r6 + " itemWidth is " + this.n);
        if (r0 == this.n) goto L9;
        m29.a.c("CreationListAdapter", this.h + "notifyDataSetChanged screenWidth is " + r6 + " itemWidth is " + this.n + " lastItemWidth is " + r0);
        notifyDataSetChanged();
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r36, int r37) {
        int r4 = r37;
        Intrinsics.checkNotNullParameter(r36, "holder");
        long r2 = System.nanoTime();
        if (this.r == false) goto L5;
        final int r7 = r4 - 1;
    L7:
        if ((r36 instanceof CreationAvatarEntranceViewHolder) == false) goto L10;
        ((CreationAvatarEntranceViewHolder) r36).T3(this.n, this.c, this.i);
    L106:
        CreationListAdapter r8 = this;
        RecyclerView.ViewHolder r0 = r36;
        r2 = r2;
        String r1 = "";
    L518:
        r8.z2(r8.getItemViewType(r4), r0);
        f r3 = r8.i;
        if (r3 == null) goto L522;
        String r5 = r3.c;
        if (r5 == null) goto L522;
    L523:
        h.a("bind", r5, r8.getItemViewType(r4), r37, System.nanoTime() - r2);
        return;
    L522:
        r5 = r1;
        goto L523
    L10:
        if ((r36 instanceof CreationSelfPrivateViewHolder) == false) goto L77;
        final CreationSelfPrivateViewHolder r6 = (CreationSelfPrivateViewHolder) r36;
        UserCreationModel r15 = (UserCreationModel) ListProtector.get(this.b, r7);
        int r9 = this.n;
        final i r10 = this.m;
        r6.getClass();
        if (r15 == null) goto L106;
        List r18 = r15.b();
        if (r18 == null) goto L106;
        UserCreation r11 = (UserCreation) CollectionsKt.firstOrNull(r18);
        if (r11 == null) goto L106;
        switch(r11.b) {
            case 1: goto L42;
            case 2: goto L50;
            case 3: goto L35;
            case 4: goto L28;
            case 5: goto L50;
            case 6: goto L21;
            case 7: goto L21;
            case 8: goto L21;
            case 9: goto L21;
            case 10: goto L21;
            case 11: goto L21;
            case 12: goto L21;
            default: goto L50;
        };
    L21:
        UserCreationContent r12 = r11.e;
        if (r12 == null) goto L26;
        VideoUserContent r13 = r12.e;
        if (r13 == null) goto L26;
        ImageInfo r14 = r13.b;
    L27:
        Image r16 = CreationSelfPrivateViewHolder.U3(r14);
    L58:
        if (r11.b != 1) goto L60;
        e1.x(r6.b);
    L62:
        if (CollectionsKt.listOf(new Integer[]{7, 6, 8, 9, 10, 11, 12}).contains(Integer.valueOf(r11.b)) == false) goto L64;
        e1.x(r6.d);
    L65:
        SimpleDraweeView r17 = r6.a;
        ViewGroup.LayoutParams r110 = r17.getLayoutParams();
        r110.height = r9;
        r17.setLayoutParams(r110);
        ImageLoaderKt.y(r6.a, CreationSelfPrivateViewHolder.T3(r16), "community_creation_photo", new s29.a(r6), 4);
        e1.d(r6.a, new s29.b(r10, r7));
        r6.a.setOnLongClickListener(new s29.c(r10, r6, r7));
        List r20 = r15.b();
        if (r20 == null) goto L68;
        int r111 = r20.size();
        int r21 = 1;
    L69:
        if (r111 < r21) goto L75;
        TextView r22 = r6.c;
        List r23 = r15.b();
        if (r23 == null) goto L73;
        Integer r112 = Integer.valueOf(r23.size());
    L74:
        r22.setText(String.valueOf(r112));
        e1.x(r6.c);
        goto L106
    L73:
        r112 = null;
        goto L74
    L75:
        e1.o(r6.c);
        goto L106
    L68:
        r21 = 1;
        r111 = 0;
        goto L69
    L64:
        e1.o(r6.d);
        goto L65
    L60:
        e1.o(r6.b);
    L26:
        r14 = null;
        goto L27
    L28:
        UserCreationContent r24 = r11.e;
        if (r24 == null) goto L33;
        AiBeautifyUserContent r25 = r24.d;
        if (r25 == null) goto L33;
        ImageInfo r26 = r25.a;
    L34:
        r16 = CreationSelfPrivateViewHolder.U3(r26);
    L33:
        r26 = null;
        goto L34
    L35:
        UserCreationContent r27 = r11.e;
        if (r27 == null) goto L40;
        UserCreationUserAvatar r28 = r27.c;
        if (r28 == null) goto L40;
        ImageInfo r30 = r28.a;
    L41:
        r16 = CreationSelfPrivateViewHolder.U3(r30);
    L40:
        r30 = null;
        goto L41
    L42:
        UserCreationContent r31 = r11.e;
        if (r31 == null) goto L49;
        UserCreationMusic r32 = r31.b;
        if (r32 == null) goto L49;
        ImageInfo r33 = r32.d;
        if (r33 == null) goto L49;
        r16 = r33.b;
    L49:
        r16 = null;
        goto L58
    L50:
        UserCreationContent r34 = r11.e;
        if (r34 == null) goto L55;
        UserCreationImage r35 = r34.a;
        if (r35 == null) goto L55;
        ImageInfo r38 = r35.a;
    L56:
        r16 = CreationSelfPrivateViewHolder.U3(r38);
    L55:
        r38 = null;
        goto L56
    L77:
        if ((r36 instanceof CreationBannedViewHolder) == false) goto L108;
        final CreationBannedViewHolder r40 = (CreationBannedViewHolder) r36;
        List r41 = ((UserCreationModel) ListProtector.get(this.b, r7)).b();
        if (r41 == null) goto L81;
        UserCreation r42 = (UserCreation) CollectionsKt.firstOrNull(r41);
    L82:
        int r113 = this.n;
        final i r114 = this.m;
        f r115 = this.i;
        if (r42 != null) goto L85;
        r40.getClass();
        goto L106
    L85:
        r40.b.setText(2131901224);
        r40.b.setShadowLayer(c7.c(2), 0.0f, 0.0f, ColorProtector.parseColor("#80000000"));
        AuthorInfo r43 = r42.g;
        View r44 = r40.c;
        ViewGroup.LayoutParams r116 = r44.getLayoutParams();
        r116.height = r113;
        r44.setLayoutParams(r116);
        ((RecyclerView.ViewHolder) r40).itemView.setOnLongClickListener(new com.larus.community.impl.viewholder.i(r114, r40, r7));
        if (r115 == null) goto L105;
        boolean r45 = r115.p;
        Long r46 = r42.f;
        if (r46 == null) goto L90;
        long r47 = r46.longValue();
    L91:
        CommonAuthorInfoLayout r48 = r40.a;
        if (r45 == false) goto L94;
        int r50 = 0;
    L95:
        r48.setVisibility(r50);
        CommonAuthorInfoLayout r51 = r40.a;
        if (r43 == null) goto L98;
        String r117 = r43.c;
    L99:
        r51.a(r117, r0.a());
        CommonAuthorInfoLayout r52 = r40.a;
        if (r43 == null) goto L103;
        String r53 = r43.a;
        if (r53 == null) goto L103;
    L104:
        r52.setAuthorName(r53);
        r40.a.setUseCount(r47);
    L103:
        r53 = "";
        goto L104
    L98:
        r117 = null;
        goto L99
    L94:
        r50 = 8;
        goto L95
    L90:
        r47 = 0;
        goto L91
    L105:
        e1.o(r40.a);
        goto L106
    L81:
        r42 = null;
        goto L82
    L108:
        if ((r36 instanceof CreationVideoViewHolder) == false) goto L306;
        final CreationVideoViewHolder r54 = (CreationVideoViewHolder) r36;
        List r55 = ((UserCreationModel) ListProtector.get(this.b, r7)).b();
        if (r55 == null) goto L112;
        final UserCreation r56 = (UserCreation) CollectionsKt.firstOrNull(r55);
    L113:
        int r118 = this.n;
        final i r119 = this.m;
        LifecycleCoroutineScope r120 = this.c;
        int r121 = this.f;
        f r122 = this.i;
        c r57 = this.j;
        p29.b r58 = this.l;
        if (r56 != null) goto L116;
        r54.getClass();
        r2 = r2;
        String r210 = "";
    L334:
        r4 = r37;
        r8 = this;
        r0 = r36;
        r1 = r210;
        goto L518
    L116:
        r54.n = r56;
        if (r122 == null) goto L119;
        g r60 = r122.e;
    L120:
        r54.o = r60;
        r54.c = r57;
        r54.d = r58;
        if (r54.e == true) goto L123;
    L125:
        r54.e = false;
        r54.f = 0;
        r54.g = 0;
        r54.h = 0;
        r54.i = false;
    L126:
        int r61 = 1;
        if (r121 == 1) goto L129;
    L132:
        if (r121 != r61) goto L134;
    L136:
        e1.o(r54.a);
        e1.o(r54.k);
    L137:
        UserCreationContent r62 = r56.e;
        if (r62 == null) goto L140;
        VideoUserContent r63 = r62.e;
    L141:
        if (r63 == null) goto L143;
        nr9.g r64 = os8.c.d(r63);
        int r65 = 2;
    L144:
        Integer[] r66 = new Integer[r65];
        r66[0] = 1;
        r66[1] = Integer.valueOf(r65);
        if (CollectionsKt.listOf(r66).contains(Integer.valueOf(r121)) == true) goto L147;
    L149:
        boolean r67 = false;
    L150:
        if (r67 == false) goto L161;
        CreationNoWatermarkManager r68 = CreationNoWatermarkManager.a;
        if (r63 == null) goto L154;
        ImageInfo r70 = r63.b;
    L156:
        if (r68.D() == true) goto L158;
        boolean r71 = false;
    L159:
        if (r71 == false) goto L161;
        boolean r72 = true;
    L162:
        r54.p = r72;
        if (r54.a.getVisibility() != 0) goto L165;
        boolean r73 = true;
    L166:
        if (r73 == false) goto L174;
        if (r120 == null) goto L174;
        UserCreationContent r74 = r56.e;
        if (r74 == null) goto L174;
        VideoUserContent r75 = r74.e;
        if (r75 == null) goto L174;
        r54.a.S5(r120, new d.c(os8.c.d(r75)));
    L174:
        z2 r76 = z2.a;
        if (r76.m() == true) goto L177;
    L200:
        e1.o(r54.k);
    L201:
        e1.o(r54.b);
        r54.b.setImageDrawable(null);
        Ref.ObjectRef r77 = new Ref.ObjectRef();
        AuthorInfo r78 = r56.g;
        if (r64 == null) goto L206;
        nr9.f r123 = r64.g;
        if (r123 == null) goto L206;
        Integer r124 = r123.d;
    L207:
        if (r64 == null) goto L211;
        nr9.f r125 = r64.g;
        if (r125 == null) goto L211;
        Integer r126 = r125.e;
    L212:
        boolean r127 = r0.a;
        r210 = "";
        int r80 = r0.b(r126, r124, r118, "CreationVideoViewHolder" + r7);
        if (r0.a == false) goto L233;
        float r128 = r118;
        if ((r128 / r80) <= 1.3f) goto L221;
        ImageView r129 = r54.b;
        ViewGroup.LayoutParams r130 = r129.getLayoutParams();
        if (r130 == null) goto L219;
        r130.width = (int) (r128 / 6.0f);
    L220:
        r129.setLayoutParams(r130);
    L227:
        if (r76.u3() == false) goto L229;
        Integer r131 = 2131240170;
    L230:
        r77.element = r131;
        if (r131 == null) goto L233;
        r54.b.setImageResource(r131.intValue());
        e1.q(r54.b);
        goto L233
    L229:
        r131 = null;
        goto L230
    L219:
        r130 = null;
        goto L220
    L221:
        ImageView r132 = r54.b;
        ViewGroup.LayoutParams r133 = r132.getLayoutParams();
        if (r133 == null) goto L224;
        r133.width = (int) (r128 / 5.0f);
    L225:
        r132.setLayoutParams(r133);
        goto L227
    L224:
        r133 = null;
    L233:
        VideoPlayView r134 = r54.j;
        ViewGroup.LayoutParams r135 = r134.getLayoutParams();
        if (r135 == null) goto L236;
        r135.height = r80;
    L237:
        r134.setLayoutParams(r135);
        VideoPlayView r81 = r54.j;
        r81.setBackgroundColor(ContextCompat.getColor(r81.getContext(), 2131103159));
        r81.setBanInnerDismiss(true);
        r81.setIgnoreClick(true);
        r81.setEnableCreationPreviewCoverLoadOpt(true);
        r81.E();
        r81.setIsMuted(true);
        if (r64 == null) goto L240;
        String r211 = r64.b;
    L241:
        if (r64 == null) goto L243;
        String r212 = r64.h;
    L244:
        VideoPlayView.e(r81, null, r211, r212, null, null, null, 56);
        if (r64 == null) goto L249;
        nr9.f r136 = r64.g;
        if (r136 == null) goto L249;
        String r213 = r136.a;
    L250:
        if (r64 == null) goto L254;
        nr9.f r137 = r64.g;
        if (r137 == null) goto L254;
        String r214 = r137.b;
    L255:
        if (r64 == null) goto L259;
        nr9.f r138 = r64.g;
        if (r138 == null) goto L259;
        String r215 = r138.c;
    L260:
        if (r64 == null) goto L264;
        nr9.f r139 = r64.g;
        if (r139 == null) goto L264;
        Integer r216 = r139.d;
    L265:
        if (r64 == null) goto L269;
        nr9.f r140 = r64.g;
        if (r140 == null) goto L269;
        Integer r310 = r140.e;
    L270:
        if (r64 == null) goto L274;
        nr9.f r82 = r64.g;
        if (r82 == null) goto L274;
        Bitmap r311 = r82.f;
    L275:
        VideoPlayView.p(r81, r213, r214, r215, r216, r310, r311, new p0(r54, r77), null, 128);
        if (r122 == null) goto L295;
        boolean r83 = r122.p;
        Long r84 = r56.f;
        if (r84 == null) goto L280;
        long r141 = r84.longValue();
    L281:
        CommonAuthorInfoLayout r85 = r54.m;
        if (r83 == false) goto L284;
        int r86 = 0;
    L285:
        r85.setVisibility(r86);
        CommonAuthorInfoLayout r87 = r54.m;
        if (r78 == null) goto L288;
        String r88 = r78.c;
    L289:
        r87.a(r88, r0.a());
        CommonAuthorInfoLayout r90 = r54.m;
        if (r78 == null) goto L293;
        String r91 = r78.a;
        if (r91 == null) goto L293;
    L294:
        r90.setAuthorName(r91);
        r54.m.setUseCount(r141);
        e1.d(r54.m, new f0(r119, r7));
        r54.m.setOnLongClickListener(new g0(r119, r54, r7));
        VideoPlayView r92 = r54.j;
        StringCompanionObject r93 = StringCompanionObject.INSTANCE;
        int r94 = j0.a;
        boolean r142 = true;
        r92.setContentDescription(String.format(j0.d(2131898798), Arrays.copyOf(new Object[]{r54.m.getAuthorName(), r54.m.getUseCount()}, 2)));
    L296:
        ((RecyclerView.ViewHolder) r54).itemView.setClickable(r142);
        e1.d(r54.j, new h0(r119, r7));
        e1.d(r54.k, new i0(r119, r7));
        e1.d(r54.a, new com.larus.community.impl.viewholder.j0(r119, r56));
        r54.j.setOnLongClickListener(new k0(r119, r54, r7));
        if (r54.q == true) goto L334;
        List r95 = CollectionsKt.listOf(new Integer[]{7, 9});
        UserCreation r96 = r54.n;
        if (r96 == null) goto L302;
        Integer r143 = Integer.valueOf(r96.b);
    L304:
        if (CollectionsKt.contains(r95, r143) == false) goto L334;
        r76.getCreationMakeSameConfig();
        goto L334
    L302:
        r143 = null;
    L293:
        r91 = r210;
        goto L294
    L288:
        r88 = null;
        goto L289
    L284:
        r86 = 8;
        goto L285
    L280:
        r141 = 0;
        goto L281
    L295:
        r142 = true;
        e1.o(r54.m);
    L274:
        r311 = null;
    L269:
        r310 = null;
    L264:
        r216 = null;
    L259:
        r215 = null;
    L254:
        r214 = null;
    L249:
        r213 = null;
        goto L250
    L243:
        r212 = null;
        goto L244
    L240:
        r211 = null;
        goto L241
    L236:
        r135 = null;
    L211:
        r126 = null;
    L206:
        r124 = null;
        goto L207
    L177:
        if (r76.getCreationMakeSameConfigV2().b() == true) goto L200;
        if (r54.k.getVisibility() != 0) goto L182;
        boolean r97 = true;
    L183:
        if (r97 == false) goto L201;
        if (r56.b() == false) goto L188;
        r54.l.setText(2131901253);
        goto L201
    L188:
        CreationDynamicInfo r98 = r56.h;
        if (r98 == null) goto L191;
        String r100 = r98.c;
    L193:
        if (o0.d(r100) == false) goto L199;
        TextView r101 = r54.l;
        CreationDynamicInfo r102 = r56.h;
        if (r102 == null) goto L197;
        String r103 = r102.c;
    L198:
        r101.setText(r103);
        goto L201
    L197:
        r103 = null;
        goto L198
    L199:
        r54.l.setText(2131901659);
        goto L201
    L191:
        r100 = null;
        goto L193
    L182:
        r97 = false;
        goto L183
    L165:
        r73 = false;
        goto L166
    L158:
        r71 = r68.y(CreationNoWatermarkManager.u0(r70));
        goto L159
    L154:
        r70 = null;
    L161:
        r72 = false;
        goto L162
    L147:
        if (CreationNoWatermarkManager.a.D() == false) goto L149;
        r67 = true;
        goto L150
    L143:
        r65 = 2;
        r64 = null;
        goto L144
    L140:
        r63 = null;
        goto L141
    L134:
        if (r121 == 2) goto L136;
        e1.x(r54.k);
        e1.o(r54.a);
        goto L137
    L129:
        if (u.b() == false) goto L131;
        e1.x(r54.a);
        r54.a.setDownloadIcon(2131240149);
        e1.o(r54.k);
        goto L137
    L131:
        r61 = 1;
        goto L132
    L123:
        if (r54.i == true) goto L125;
    L119:
        r60 = null;
        goto L120
    L112:
        r56 = null;
        goto L113
    L306:
        r2 = r2;
        r210 = "";
        if ((r36 instanceof CreationImageToImageViewHolder) == false) goto L314;
        CreationImageToImageViewHolder r104 = (CreationImageToImageViewHolder) r36;
        List r105 = ((UserCreationModel) ListProtector.get(this.b, r7)).b();
        if (r105 == null) goto L311;
        UserCreation r106 = (UserCreation) CollectionsKt.firstOrNull(r105);
    L312:
        r104.U3(r7, r106, this.n, this.m, this.c, this.f, this.i);
        goto L334
    L311:
        r106 = null;
        goto L312
    L314:
        if ((r36 instanceof CreationAIBeautifyViewHolder) == false) goto L321;
        CreationAIBeautifyViewHolder r107 = (CreationAIBeautifyViewHolder) r36;
        List r108 = ((UserCreationModel) ListProtector.get(this.b, r7)).b();
        if (r108 == null) goto L318;
        UserCreation r109 = (UserCreation) CollectionsKt.firstOrNull(r108);
    L319:
        r107.U3(r7, r109, this.n, this.m, this.c, this.f, this.i);
        goto L334
    L318:
        r109 = null;
        goto L319
    L321:
        if ((r36 instanceof CreationAvatarViewHolder) == false) goto L328;
        CreationAvatarViewHolder r144 = (CreationAvatarViewHolder) r36;
        List r145 = ((UserCreationModel) ListProtector.get(this.b, r7)).b();
        if (r145 == null) goto L325;
        UserCreation r146 = (UserCreation) CollectionsKt.firstOrNull(r145);
    L326:
        r144.U3(r7, r146, this.n, this.m, this.c, this.f, this.i);
        goto L334
    L325:
        r146 = null;
        goto L326
    L328:
        if ((r36 instanceof CreationImageViewHolder) == false) goto L336;
        CreationImageViewHolder r147 = (CreationImageViewHolder) r36;
        List r148 = ((UserCreationModel) ListProtector.get(this.b, r7)).b();
        if (r148 == null) goto L332;
        UserCreation r149 = (UserCreation) CollectionsKt.firstOrNull(r148);
    L333:
        r147.U3(r7, r149, this.n, this.m, this.c, this.f, this.i);
        goto L334
    L332:
        r149 = null;
        goto L333
    L336:
        if ((r36 instanceof CreationMusicViewHolder) == false) goto L496;
        final CreationMusicViewHolder r150 = (CreationMusicViewHolder) r36;
        List r151 = ((UserCreationModel) ListProtector.get(this.b, r7)).b();
        if (r151 == null) goto L340;
        final UserCreation r152 = (UserCreation) CollectionsKt.firstOrNull(r151);
    L341:
        int r153 = this.n;
        final i r154 = this.m;
        LifecycleCoroutineScope r155 = this.c;
        final int r156 = this.f;
        f r157 = this.i;
        r150.getClass();
        if (r156 == 1) goto L344;
    L349:
        if (r152 != null) goto L351;
        r1 = r210;
    L495:
        r8 = this;
        r0 = r36;
    L508:
        r4 = r37;
        goto L518
    L351:
        final Integer r158 = r152.c;
        Integer r159 = r152.d;
        UserCreationContent r160 = r152.e;
        if (r160 == null) goto L356;
        UserCreationMusic r161 = r160.b;
        if (r161 == null) goto L356;
        ImageInfo r162 = r161.d;
    L357:
        if (r162 == null) goto L361;
        Image r163 = r162.b;
        if (r163 == null) goto L361;
        Long r164 = Long.valueOf(r163.d);
    L362:
        if (r162 == null) goto L366;
        Image r165 = r162.b;
        if (r165 == null) goto L366;
        Long r166 = Long.valueOf(r165.c);
    L367:
        int r167 = (r153 * 16) / 9;
        if (r166 == null) goto L390;
        if (r164 == null) goto L390;
        if (((int) r166.longValue()) == 0) goto L390;
        if (r153 == (-1)) goto L390;
        int r168 = (int) ((((long) r153) * r164.longValue()) / r166.longValue());
        if (r168 > r167) goto L381;
        r167 = (r153 * 9) / 16;
        if (r168 < r167) goto L381;
        r167 = r168;
    L381:
        boolean r169 = m29.a.a;
        StringBuilder r170 = new StringBuilder("position is ");
        r170.append(r150.getPosition());
        r170.append(" ; template width is ");
        Image r171 = r162.b;
        if (r171 == null) goto L384;
        Long r172 = Long.valueOf(r171.c);
    L385:
        r170.append(r172);
        r170.append(" height is ");
        Image r173 = r162.b;
        if (r173 == null) goto L388;
        Long r174 = Long.valueOf(r173.d);
    L389:
        r170.append(r174);
        r170.append(" ; itemWidth is ");
        r170.append(r153);
        r170.append(" height is ");
        r170.append(r150.a.getLayoutParams().height);
        m29.a.c("CreationMusicViewHolder", r170.toString());
        goto L390
    L388:
        r174 = null;
        goto L389
    L384:
        r172 = null;
    L390:
        ImageViewWithLastMotion r175 = r150.a;
        ViewGroup.LayoutParams r176 = r175.getLayoutParams();
        r176.height = r167;
        r175.setLayoutParams(r176);
        if (r150.h.getVisibility() != 0) goto L393;
        boolean r177 = true;
    L394:
        if (r177 == false) goto L412;
        if (r155 == null) goto L412;
        UserCreationContent r178 = r152.e;
        if (r178 == null) goto L412;
        UserCreationMusic r179 = r178.b;
        if (r179 == null) goto L412;
        String r180 = r179.h;
        if (r180 == null) goto L412;
        if (r180.length() <= 0) goto L406;
        boolean r181 = true;
    L407:
        if (r181 == true) goto L410;
        r180 = null;
    L410:
        if (r180 == null) goto L412;
        r150.h.S5(r155, new d.b(r180));
        goto L412
    L406:
        r181 = false;
    L412:
        AuthorInfo r182 = r152.g;
        if (r182 == null) goto L431;
        if (r157 != null) goto L416;
    L418:
        boolean r183 = false;
    L419:
        if (r183 == true) goto L422;
        r182 = null;
    L422:
        if (r182 == null) goto L431;
        Long r184 = r152.f;
        if (r184 == null) goto L426;
        long r185 = r184.longValue();
    L427:
        r150.b.setVisibility(0);
        r150.b.a(r182.c, r0.a());
        CommonAuthorInfoLayout r186 = r150.b;
        String r187 = r182.a;
        if (r187 != null) goto L430;
        r187 = r210;
    L430:
        r186.setAuthorName(r187);
        r150.b.setUseCount(r185);
    L432:
        if (r159 != null) goto L435;
    L439:
        FrameLayout r188 = r150.f;
        if (r188 == null) goto L442;
        e1.x(r188);
    L442:
        r1 = r210;
        r150.U3(r1, r150.g);
        UserCreationContent r189 = r152.e;
        if (r189 == null) goto L449;
        UserCreationMusic r190 = r189.b;
        if (r190 == null) goto L449;
        ImageInfo r191 = r190.d;
        if (r191 == null) goto L449;
        Image r192 = r191.b;
    L450:
        ImageViewWithLastMotion r193 = r150.a;
        if (r158 != null) goto L454;
    L456:
        if (r192 == null) goto L461;
        String r194 = r192.a;
        if (r194 == null) goto L461;
        Uri r195 = UriProtector.parse(r194);
    L460:
        Uri r217 = r195;
    L462:
        ImageLoaderKt.x(r193, r217, "template_item_photo", null, new x(r150, r156, r158, r152), 4);
        TextView r196 = r150.d;
        UserCreationContent r197 = r152.e;
        if (r197 == null) goto L467;
        UserCreationMusic r198 = r197.b;
        if (r198 == null) goto L467;
        String r199 = r198.b;
    L468:
        r196.setText(r199);
        TextView r200 = r150.e;
        UserCreationContent r201 = r152.e;
        if (r201 == null) goto L473;
        UserCreationMusic r202 = r201.b;
        if (r202 == null) goto L473;
        String r203 = r202.i;
    L474:
        r200.setText(r203);
        FrameLayout r204 = r150.f;
        if (r204 == null) goto L489;
        IMusicService r205 = (IMusicService) ServiceManager.get().getService(IMusicService.class);
        if (r205 == null) goto L489;
        Gson r206 = n0.a;
        UserCreationContent r207 = r152.e;
        if (r207 == null) goto L481;
        UserCreationMusic r208 = r207.b;
    L482:
        String r209 = GsonProtectorUtils.toJson(r206, r208);
        if (r156 != 1) goto L485;
    L487:
        String r218 = "creation_list";
    L488:
        r205.b(r204, r209, r7, r218);
        goto L489
    L485:
        if (r156 == 2) goto L487;
        r218 = "creation_others";
        goto L488
    L481:
        r208 = null;
    L489:
        e1.d(r150.a, new y(r154, r7));
        e1.d(r150.b, new z(r154, r7));
        e1.d(r150.c, new com.larus.community.impl.viewholder.a0(r154, r7));
        e1.d(r150.h, new b0(r154, r152));
        r150.a.setOnLongClickListener(new c0(r154, r150, r7));
        r150.b.setOnLongClickListener(new d0(r154, r150, r7));
        Integer r219 = r152.c;
        if (r219 == null) goto L495;
        if (r219.intValue() != 5) goto L495;
        r150.a.setOnClickListener(null);
        r150.b.setOnClickListener(null);
        r150.c.setOnClickListener(null);
        r150.h.setOnClickListener(null);
        r150.a.setOnLongClickListener(null);
        r150.b.setOnClickListener(null);
        r150.c.setOnClickListener(null);
        r150.h.setOnClickListener(null);
    L473:
        r203 = null;
    L467:
        r199 = null;
    L461:
        r217 = null;
        goto L462
    L454:
        if (r158.intValue() != 5) goto L456;
        r195 = UriProtector.parse("res://" + AppHost.a.getApplication().getPackageName() + "/2131240129");
    L449:
        r192 = null;
        goto L450
    L435:
        if (r159.intValue() != 2) goto L439;
        FrameLayout r220 = r150.f;
        if (r220 == null) goto L442;
        e1.x(r220);
        goto L442
    L426:
        r185 = 0;
        goto L427
    L416:
        if (r157.p != true) goto L418;
        r183 = true;
    L431:
        e1.o(r150.b);
        goto L432
    L393:
        r177 = false;
    L366:
        r166 = null;
    L361:
        r164 = null;
    L356:
        r162 = null;
        goto L357
    L344:
        if (u.b() == false) goto L349;
        CommonDownLoadLayout r1100 = r150.h;
        if (r1100 == null) goto L348;
        r1100.setDownloadIcon(2131240149);
    L348:
        e1.x(r150.h);
        goto L349
    L340:
        r152 = null;
        goto L341
    L496:
        r0 = r36;
        r1 = r210;
        if ((r0 instanceof CreationMoreViewHolder) == false) goto L505;
        CreationMoreViewHolder r221 = (CreationMoreViewHolder) r0;
        r8 = this;
        gs9.i r222 = r8.p;
        boolean r223 = r8.g;
        f r224 = r8.i;
        if (r224 == null) goto L503;
        Integer r225 = r224.g;
        if (r225 == null) goto L503;
        int r1101 = r225.intValue();
    L504:
        r221.T3(r222, r223, r1101);
    L503:
        r1101 = 0;
        goto L504
    L505:
        r8 = this;
        if ((r0 instanceof AbsCreationFeedHeaderViewHolder) == false) goto L510;
        ((AbsCreationFeedHeaderViewHolder) r0).T3();
        goto L508
    L510:
        if ((r0 instanceof CreationLoadingAndRetryViewHolder) == false) goto L512;
        CreationLoadingAndRetryViewHolder r226 = (CreationLoadingAndRetryViewHolder) r0;
        r226.T3(r8.a);
        k r227 = r8.q;
        Intrinsics.checkNotNullParameter(r227, "state");
        r226.a.R5(r227);
        goto L508
    L512:
        StaggeredGridLayoutManager.LayoutParams r228 = r0.itemView.getLayoutParams();
        if ((r228 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L515;
        StaggeredGridLayoutManager.LayoutParams r1102 = r228;
    L516:
        if (r1102 == null) goto L508;
        r1102.setFullSpan(true);
        goto L508
    L515:
        r1102 = null;
        goto L516
    L5:
        r7 = r4;
        goto L7
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        long r0 = System.nanoTime();
        switch(r11) {
            case 0: goto L29;
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L21;
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
        q r2 = new CommonViewHolder(new View(r10.getContext()));
    L30:
        f r12 = this.i;
        if (r12 == null) goto L34;
        String r13 = r12.c;
        if (r13 == null) goto L34;
    L35:
        h.a("create", r13, r11, r2.getAdapterPosition(), System.nanoTime() - r0);
        return r2;
    L34:
        r13 = "";
        goto L35
    L5:
        View r14 = LayoutInflater.from(r10.getContext()).inflate(2131561947, r10, false);
        Intrinsics.checkNotNull(r14);
        r2 = new CreationAvatarEntranceViewHolder(r14);
        goto L30
    L6:
        View r15 = LayoutInflater.from(r10.getContext()).inflate(2131561950, r10, false);
        Intrinsics.checkNotNull(r15);
        r2 = new CreationBannedViewHolder(r15);
        goto L30
    L7:
        View r16 = LayoutInflater.from(r10.getContext()).inflate(2131561944, r10, false);
        Intrinsics.checkNotNull(r16);
        r2 = new CreationImageToImageViewHolder(r16);
        goto L30
    L8:
        View r17 = LayoutInflater.from(r10.getContext()).inflate(2131561954, r10, false);
        Intrinsics.checkNotNull(r17);
        r2 = new CreationVideoViewHolder(r17);
        goto L30
    L9:
        r2 = new CreationSelfPrivateViewHolder(r10);
        goto L30
    L10:
        View r18 = LayoutInflater.from(r10.getContext()).inflate(2131561944, r10, false);
        Intrinsics.checkNotNull(r18);
        r2 = new CreationAIBeautifyViewHolder(r18);
        goto L30
    L11:
        View r110 = LayoutInflater.from(r10.getContext()).inflate(2131561972, r10, false);
        Intrinsics.checkNotNull(r110);
        r2 = new CreationMusicViewHolder(r110);
        goto L30
    L12:
        View r111 = LayoutInflater.from(r10.getContext()).inflate(2131561958, r10, false);
        Intrinsics.checkNotNull(r111);
        r2 = new CreationLoadingAndRetryViewHolder(r111);
        Function0<Unit> r112 = new g29.d(this);
        r2.a.setOnRetryClickListener(r112);
        r2.T3(this.a);
        f r113 = this.i;
        if (r113 == null) goto L16;
        RecyclerView.ItemDecoration r114 = r113.t;
        if (r114 == null) goto L16;
    L17:
        Intrinsics.checkNotNullParameter(r114, "itemDecoration");
        CreationLoadingAndRetryView r4 = r2.a;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r114, "itemDecoration");
        RecyclerView.ItemDecoration r3 = r4.e;
        if (r3 == null) goto L20;
        r4.a.b.removeItemDecoration(r3);
    L20:
        r4.e = r114;
        r4.a.b.addItemDecoration(r114);
        Function0<View> r115 = this.e;
        r2.a.setEmptyCreator(r115);
    L16:
        r114 = new LoadingItemDecoration(this.a, i5.e0());
        goto L17
    L21:
        p r5 = this.d;
        if (r5 == null) goto L26;
        r2 = r5.a(r10);
        if (r2 != null) goto L30;
    L26:
        r2 = new CommonViewHolder(new View(r10.getContext()));
        goto L30
    L27:
        View r116 = LayoutInflater.from(r10.getContext()).inflate(2131561962, r10, false);
        Intrinsics.checkNotNull(r116);
        r2 = new CreationMoreViewHolder(r116);
        Function0<Unit> r117 = new g29.c(this);
        r2.a.setOnErrorClickListener(r117);
        goto L30
    L28:
        View r118 = LayoutInflater.from(r10.getContext()).inflate(2131561944, r10, false);
        Intrinsics.checkNotNull(r118);
        r2 = new CreationAvatarViewHolder(r118);
        goto L30
    L29:
        View r119 = LayoutInflater.from(r10.getContext()).inflate(2131561944, r10, false);
        Intrinsics.checkNotNull(r119);
        r2 = new CreationImageViewHolder(r119);
        goto L30
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
        gs9.i r6 = this.p;
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
    /* JADX WARN: Type inference failed for: r2v7, types: [g29.f] */
    public CreationListAdapter(int r2, List<UserCreationModel> r3, LifecycleCoroutineScope r4, p r5, Function0<? extends View> r6, @CreationFeedType int r7, boolean r8, String r9, f r10, c r11, RecyclerView.RecycledViewPool r12, p29.b r13) {
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
        this.l = r13;
        this.n = -1;
        this.o = -1;
        this.p = gs9.i.c.a;
        this.q = k.c.a;
        if (r5 == null) goto L5;
        boolean r14 = true;
    L6:
        this.r = r14;
        this.w = new b(this);
        this.x = new g29.f(this);
        return;
    L5:
        r14 = false;
        goto L6
    }
}
