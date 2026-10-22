package com.larus.community.impl.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.larus.chat.gallery.api.IChatGalleryService;
import com.larus.chat.gallery.api.PreviewScene;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.community.api.spi.ICommunityHostBehaviorProvider;
import com.larus.community.api.tracker.CreationFeedBehaviorTracker;
import com.larus.community.impl.adapter.CreationListAdapter;
import com.larus.community.impl.adapter.CreationListAdapter$preload$1;
import com.larus.community.impl.adapter.GridSpacingItemDecoration;
import com.larus.community.impl.cache.CreationListCacheDataSource;
import com.larus.community.impl.component.layoutmanager.CreationFeedStaggeredGridLayoutManager;
import com.larus.community.impl.databinding.LarusCommunityCreationFeedComponentLayoutBinding;
import com.larus.community.impl.databinding.LarusCommunityCreationFeedComponentLayoutNoRefreshBinding;
import com.larus.community.impl.template.TemplateCreationListFragment;
import com.larus.media.focus.OScrollStateHelper;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.m3;
import com.larus.platform.service.z1;
import com.larus.platform.service.z2;
import com.larus.profile.api.bean.UserCreationModel;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import tx9.u3;
import v19.c7;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u00ad\u00012\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0002\u00ad\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010=\u001a\u00020>2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010?\u001a\u00020>H\u0016J\b\u0010@\u001a\u00020>H\u0002J\b\u0010A\u001a\u00020>H\u0016J\b\u0010B\u001a\u00020>H\u0016J\u0010\u0010C\u001a\u00020>2\u0006\u0010D\u001a\u00020\u0012H\u0016J\b\u0010E\u001a\u00020\u0019H\u0002J\b\u0010F\u001a\u00020 H\u0002J\b\u0010G\u001a\u00020>H\u0002J\u0019\u0010H\u001a\u00020 2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0002\u0010JJ\u0018\u0010K\u001a\u00020>2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u0019H\u0002J\u001a\u0010O\u001a\u00020>2\u0006\u0010L\u001a\u00020M2\b\b\u0002\u0010I\u001a\u00020 H\u0002J\u0010\u0010P\u001a\u00020\u00172\u0006\u0010Q\u001a\u00020 H\u0002J\u0010\u0010R\u001a\u00020>2\u0006\u0010Q\u001a\u00020 H\u0002J\b\u0010S\u001a\u00020>H\u0002J\b\u0010T\u001a\u00020>H\u0002J \u0010U\u001a\u00020>2\u0006\u0010L\u001a\u00020M2\u0006\u0010V\u001a\u00020\u00192\u0006\u0010W\u001a\u00020\u0019H\u0002J\u0016\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010Y\u001a\u00020>2\u0006\u0010Z\u001a\u00020\u001eH\u0002J\u0010\u0010[\u001a\u00020>2\u0006\u0010Z\u001a\u00020\u001eH\u0002J\u0018\u0010\\\u001a\u00020>2\u0006\u0010Z\u001a\u00020\u001e2\u0006\u0010]\u001a\u00020^H\u0002J\u0012\u0010_\u001a\u00020>2\b\u0010Z\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010`\u001a\u00020>H\u0002J+\u0010a\u001a\u00020>2\u0006\u0010b\u001a\u00020\u001e2\u0019\u0010c\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0017¢\u0006\u0002\be\u0012\u0004\u0012\u00020>0dH\u0002J\u001e\u0010f\u001a\u00020>2\b\u0010b\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u0017H\u0002J\u0018\u0010j\u001a\u00020>2\u0006\u0010k\u001a\u00020 2\u0006\u0010l\u001a\u00020\u0017H\u0002J \u0010m\u001a\u00020\u00192\u0006\u0010k\u001a\u00020 2\u0006\u0010l\u001a\u00020\u00172\u0006\u0010Z\u001a\u00020\u001eH\u0002J\u0010\u0010n\u001a\u00020\u00192\u0006\u0010Z\u001a\u00020\u001eH\u0002J\u0010\u0010o\u001a\u00020\u00192\u0006\u0010Z\u001a\u00020\u001eH\u0002J\b\u0010p\u001a\u00020\u0017H\u0002J\u0018\u0010q\u001a\u00020\u00172\u0006\u0010k\u001a\u00020 2\u0006\u0010Z\u001a\u00020\u001eH\u0002J\u001e\u0010r\u001a\u00020>2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020t0\u001d2\u0006\u0010u\u001a\u00020\u0017H\u0002J \u0010v\u001a\u00020>2\u0006\u0010k\u001a\u00020 2\u0006\u0010l\u001a\u00020\u00172\u0006\u0010Z\u001a\u00020\u001eH\u0002J\u000e\u0010w\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\u0010\u0010x\u001a\u00020\u001e2\u0006\u0010Z\u001a\u00020\u001eH\u0002J\f\u0010y\u001a\u00020\u0019*\u00020\u001eH\u0002J\b\u0010z\u001a\u00020>H\u0002J\b\u0010{\u001a\u00020>H\u0002J\b\u0010|\u001a\u00020>H\u0002J\u001a\u0010}\u001a\u00020>2\u0006\u0010~\u001a\u00020\u00172\b\u0010L\u001a\u0004\u0018\u00010MH\u0002J\b\u0010\u007f\u001a\u00020>H\u0016J\t\u0010\u0080\u0001\u001a\u00020>H\u0016J\u0011\u0010\u0081\u0001\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0003\u0010\u0082\u0001J\u001c\u0010\u0083\u0001\u001a\u00020>2\u0006\u0010k\u001a\u00020 2\t\b\u0002\u0010\u0084\u0001\u001a\u00020 H\u0002J>\u0010\u0085\u0001\u001a\u00020>2\u0007\u0010\u0086\u0001\u001a\u00020\u00192\u0007\u0010\u0087\u0001\u001a\u00020\u00192\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010^2\u0007\u0010\u0089\u0001\u001a\u00020\u00192\u0007\u0010\u008a\u0001\u001a\u00020\u0019H\u0016¢\u0006\u0003\u0010\u008b\u0001J#\u0010\u008c\u0001\u001a\u00020>2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010^2\u0007\u0010\u008a\u0001\u001a\u00020\u0019H\u0002¢\u0006\u0003\u0010\u008d\u0001J\u001b\u0010\u008e\u0001\u001a\u00020>2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010^H\u0082@¢\u0006\u0003\u0010\u008f\u0001J\u001a\u0010\u0090\u0001\u001a\u00020>2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010^H\u0002¢\u0006\u0003\u0010\u0091\u0001J#\u0010\u0092\u0001\u001a\u00020>2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010^2\u0007\u0010\u0087\u0001\u001a\u00020\u0019H\u0002¢\u0006\u0003\u0010\u008d\u0001J\u001c\u0010\u0093\u0001\u001a\u00020>2\u0006\u0010k\u001a\u00020 2\t\b\u0002\u0010\u0084\u0001\u001a\u00020 H\u0002J\u0013\u0010\u0094\u0001\u001a\u00020>2\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0016J\u0013\u0010\u0097\u0001\u001a\u00020>2\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0016J\u0012\u0010\u0098\u0001\u001a\u00020>2\u0007\u0010\u0099\u0001\u001a\u00020\u000fH\u0016J\u001c\u0010\u009a\u0001\u001a\u00020>2\u0011\u0010\u0099\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011H\u0016J\t\u0010\u009b\u0001\u001a\u00020>H\u0016J\t\u0010\u009c\u0001\u001a\u00020>H\u0016J\u000b\u0010\u009d\u0001\u001a\u0004\u0018\u00010MH\u0016J\u0010\u0010\u009e\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190\u009f\u0001H\u0016J\u001b\u0010 \u0001\u001a\u00020>2\u0007\u0010¡\u0001\u001a\u00020\u00172\u0007\u0010¢\u0001\u001a\u00020\u0019H\u0016J,\u0010£\u0001\u001a\u00020>2\u0007\u0010¤\u0001\u001a\u00020 2\u0007\u0010¥\u0001\u001a\u00020\u00192\u0006\u0010b\u001a\u00020\u001e2\u0007\u0010¢\u0001\u001a\u00020\u0019H\u0016J\u0011\u0010¦\u0001\u001a\u00020>2\u0006\u0010b\u001a\u00020\u001eH\u0016J\u0011\u0010§\u0001\u001a\u00020>2\u0006\u0010b\u001a\u00020\u001eH\u0016J\u0011\u0010¨\u0001\u001a\u00020>2\u0006\u0010b\u001a\u00020\u001eH\u0016J\t\u0010©\u0001\u001a\u00020>H\u0016J\t\u0010ª\u0001\u001a\u00020 H\u0002J\u0013\u0010«\u0001\u001a\u0004\u0018\u00010\u00172\u0006\u0010b\u001a\u00020\u001eH\u0002J\u0019\u0010¬\u0001\u001a\u00020>2\u0006\u0010k\u001a\u00020 2\u0006\u0010l\u001a\u00020\u0017H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000RN\u0010\u0015\u001aB\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u0017\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00190\u0019 \u0018* \u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u0017\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\u00160\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u000e\u00100\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u001e08X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u0004\u0018\u00010iX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006®\u0001"}, d2 = {"Lcom/larus/community/impl/component/CreationFeedComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/platform/api/creation/ICreationFeedAbility;", "<init>", "()V", "viewModel", "Lcom/larus/community/impl/component/CreationFeedViewModel;", "getViewModel", "()Lcom/larus/community/impl/component/CreationFeedViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "creationFeedLayoutViewBinding", "Lcom/larus/community/impl/component/CreationFeedLayoutViewBinding;", "headCreator", "Lcom/larus/platform/api/creation/ICreationFeedHeaderCreator;", "emptyViewCreator", "Lkotlin/Function0;", "Landroid/view/View;", "openLongClickMenuDialogHelper", "Lcom/larus/community/impl/component/OpenLongClickMenuDialogHelper;", "noWatermarkDetailInFlight", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "", "kotlin.jvm.PlatformType", "", "adapter", "Lcom/larus/community/impl/adapter/CreationListAdapter;", "galleryCreationsSnapshot", "", "Lcom/larus/platform/api/creation/UserCreation;", "spanCount", "", "gridSpacingItemDecoration", "Lcom/larus/community/impl/adapter/GridSpacingItemDecoration;", "canExposeItemShow", "initParams", "Lcom/larus/platform/api/creation/CreationFeedInitParams;", "initDependency", "Lcom/larus/platform/api/creation/CreationFeedInitDependency;", "saveMusicFrameLayout", "Landroid/widget/FrameLayout;", "creationDownLoadHelper", "Lcom/larus/community/impl/component/CreationDownLoadHelper;", "getCreationDownLoadHelper", "()Lcom/larus/community/impl/component/CreationDownLoadHelper;", "creationDownLoadHelper$delegate", "Lkotlin/Lazy;", "firstResume", "doSameAbility", "Lcom/larus/platform/model/creation/ICreationDoSameAbility;", "focusHelper", "Lcom/larus/community/impl/component/focus/CreationFeedRVFocusHelper;", "feedVideoReportHelper", "Lcom/larus/community/impl/tracker/CreationFeedVideoReportHelper;", "feedBehaviorTracker", "Lcom/larus/community/api/tracker/CreationFeedBehaviorTracker;", "isUserScrollInProgress", "loadMoreDistance", "feedSpanLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "initialize", "", "onResume", "fetchFirstScreenData", "onPause", "onAttach", "onViewCreated", "view", "shouldFetchFirstScreenOnViewCreated", "getCreationFeedType", "initView", "resolveSpanCount", "parentWidth", "(Ljava/lang/Integer;)I", "initSpanItemDecoration", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isStaggeredGridLayoutManager", "updateSpanCountIfNeeded", "checkItemShowGetter", "index", "reportShow", "checkItemShow", "postUpdateFeedBehavior", "updateFeedBehavior", "allowFirstScreenSlide", "settleDisappeared", "collectVisibleCreations", "trackSessionSlide", "data", "trackSessionClick", "trackFeedStaytime", "durationMs", "", "trackTemplateShow", "initClickAction", "showQuickMenuBeforeDoSame", "userCreation", "doSameLogic", "Lkotlin/Function1;", "Lcom/larus/platform/model/creation/DoSameQuickMenuType;", "goToDoSame", "fileLocalPath", "job", "Lkotlinx/coroutines/Job;", "goCreationDetailPage", "position", "clickEnterMethod", "ensureProfileNoWatermarkBeforeOpen", "shouldPrefetchProfileNoWatermarkBeforeOpen", "shouldEnsureProfileNoWatermarkForDetail", "profileNoWatermarkDetailScene", "buildNoWatermarkDetailOpenKey", "submitCreationModelList", "list", "Lcom/larus/profile/api/bean/UserCreationModel;", "reason", "openCreationDetailPage", "getCurrentDisplayCreationsForGallery", "selectProfileNoWatermarkUserCreation", "isVideoCreation", "initObservers", "initRefreshLayout", "initLoadMore", "checkCanLoadMoreAndTryLoad", "sceneTag", "onFragmentViewDestroyed", "onDestroy", "computeVerticalScrollOffset", "()Ljava/lang/Integer;", "scrollToPositionToFirst", "duration", "scrollToTopAndRefresh", "notScrollToTop", "notRefresh", "smoothScrollDuration", "checkFirstPageData", "isHotLaunch", "(ZZLjava/lang/Long;ZZ)V", "handleDataCheckAndRefresh", "(Ljava/lang/Long;Z)V", "scrollToTopAndPerformRefresh", "(Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performSmoothScrollToTop", "(Ljava/lang/Long;)V", "performNormalScrollToTopAndRefresh", "smoothScrollToPositionToStart", "addOnScrollListener", "listener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "removeOnScrollListener", "setCustomHeaderViewHolder", "creator", "setCustomEmptyViewCreator", "setViewGone", "setViewVisible", "getRecyclerView", "getHasDataLiveData", "Landroidx/lifecycle/LiveData;", "deleteUserCreation", "creationId", "modelAllDeleted", "updateCreationModelPrivacy", "privacy", "splitMode", "setMockUserCreation", "ensureMockUserCreationVisible", "onSetCreationStatus", "invalidateSpanAssignments", "getCreationPageType", "sourceProfileUserIdForDetail", "openMusicOnlyDetailPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationFeedComponent extends BaseContentWidget implements zp9.l {
    public static final int K = 0;
    public final Lazy A;
    public boolean B;
    public sq9.t C;
    public i29.c D;
    public p29.b E;
    public final CreationFeedBehaviorTracker<UserCreation> F;
    public boolean G;
    public int H;
    public final m I;
    public Job J;
    public final com.larus.ui.arch.vm.internal.l m;
    public final h0 n;
    public zp9.p o;
    public Function0<? extends View> p;
    public u1 q;
    public final ConcurrentHashMap.KeySetView<String, Boolean> r;
    public CreationListAdapter s;
    public volatile List<UserCreation> t;
    public int u;
    public GridSpacingItemDecoration v;
    public boolean w;
    public zp9.f x;
    public zp9.e y;
    public FrameLayout z;

    public static final class a {
    }

    public static final class b implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public b(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class c implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public c(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class d implements Function0<ViewModelProvider.Factory> {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    public final void A2() {
    }

    static {
        K = z2.a.getCommunityRecommendRequestConfig().b();
    }

    public final int B3() {
        zp9.f r0 = this.x;
        if (r0 == null) goto L7;
        Integer r1 = r0.f;
        if (r1 == null) goto L7;
        return r1.intValue();
    L7:
        return 4;
    }

    public final CreationFeedViewModel C3() {
        return (CreationFeedViewModel) this.m.getValue();
    }

    public final void G3() {
        RecyclerView r0 = this.n.a();
        if (r0 == null) goto L6;
        r0.post(new u(this));
        return;
    }

    public final Integer computeVerticalScrollOffset() {
        RecyclerView r0 = this.n.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.computeVerticalScrollOffset());
    }

    public final RecyclerView getRecyclerView() {
        return this.n.a();
    }

    public final void onDestroy() {
        RecyclerView r0 = this.n.a();
        if (r0 == null) goto L5;
        r0.removeOnLayoutChangeListener(this.I);
    L5:
        CreationListAdapter r1 = this.s;
        if (r1 == null) goto L8;
        r1.A2();
    L8:
        this.s = null;
        sq9.t r2 = this.C;
        if (r2 == null) goto L12;
        r2.onDestroy();
        return;
    }

    public final void onPause() {
        this.F.a(CreationFeedBehaviorTracker.ExposurePauseReason.PAGE_HIDDEN);
        i29.c r0 = this.D;
        if (r0 == null) goto L9;
        OScrollStateHelper r1 = r0.a;
        if (r1 == null) goto L7;
        r1.h();
    L7:
        r0.a = null;
        r0.b.getClass();
        return;
    }

    public final void onResume() {
        CreationFeedBehaviorTracker<UserCreation> r0 = this.F;
        CreationFeedBehaviorTracker.ExposurePauseReason r1 = CreationFeedBehaviorTracker.ExposurePauseReason.PAGE_HIDDEN;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "reason");
        r0.h.remove(r1);
        G3();
        p3();
        if (this.B == false) goto L40;
        zp9.f r2 = this.x;
        if (r2 == null) goto L11;
        String r3 = r2.q;
        if (r3 == null) goto L11;
        CreationListCacheDataSource.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "creationRecommendType");
        Boolean r4 = CreationListCacheDataSource.c.get(r3);
        if (r4 == null) goto L11;
        boolean r5 = r4.booleanValue();
    L12:
        boolean r6 = CreationFeedViewModel.fetchFirstScreenData$default(C3(), true, false, false, 6, null);
        zp9.f r7 = this.x;
        boolean r8 = true;
        if (r7 != null) goto L15;
    L17:
        boolean r9 = false;
    L18:
        boolean r10 = m29.a.a;
        StringBuilder r11 = new StringBuilder("useCache:");
        r11.append(r6);
        r11.append(", hasRefresh:");
        r11.append(r5);
        r11.append(", forceRefreshIgnoreCache:");
        zp9.f r12 = this.x;
        if (r12 == null) goto L21;
        Boolean r13 = Boolean.valueOf(r12.a);
    L22:
        r11.append(r13);
        r11.append(", disableInitialAutoRefreshOnce:");
        r11.append(r9);
        m29.a.c("CreationFeedComponent", r11.toString());
        if (r6 == false) goto L34;
        if (r9 == true) goto L34;
        if (r5 == false) goto L33;
        zp9.f r14 = this.x;
        if (r14 != null) goto L29;
    L31:
        r8 = false;
    L32:
        if (r8 == false) goto L34;
    L29:
        if (r14.a != true) goto L31;
    L33:
        C3().refresh("onResume", false);
    L34:
        zp9.f r15 = this.x;
        if (r15 == null) goto L39;
        String r16 = r15.q;
        if (r16 == null) goto L39;
        CreationListCacheDataSource.a.getClass();
        Intrinsics.checkNotNullParameter(r16, "creationRecommendType");
        CreationListCacheDataSource.c.put(r16, Boolean.TRUE);
    L39:
        this.B = false;
        goto L40
    L21:
        r13 = null;
        goto L22
    L15:
        if (r7.b != true) goto L17;
        r9 = true;
    L11:
        r5 = false;
    L40:
        final i29.c r17 = this.D;
        if (r17 == null) goto L46;
        final RecyclerView r18 = this.n.a();
        if (r18 == null) goto L46;
        r18.post(new i29.a(r17, r18));
    L46:
        C3().refreshProfileNoWatermarkIfSwitchChanged("resume");
    }

    public final void p3() {
        RecyclerView r0 = this.n.a();
        if (r0 == null) goto L6;
        y6.c(r0, new x(this), new y(this), new z(this));
        return;
    }

    public final void y2() {
        m29.a.a("CreationFeedComponent", new j(this));
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, zp9.l.class);
        m3 r1 = m3.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.C = r1.q(com.larus.ui.arch.component.internal.attach.a.b(this, this));
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.larus.community.impl.component.m] */
    public CreationFeedComponent() {
        this.m = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(CreationFeedViewModel.class), Reflection.getOrCreateKotlinClass(CreationFeedComponentState.class), new b(this), new c(this), d.a);
        this.n = new h0();
        this.r = ConcurrentHashMap.newKeySet();
        this.t = CollectionsKt.emptyList();
        this.u = 2;
        this.w = true;
        this.A = LazyKt.lazy(new k());
        this.B = true;
        this.F = new CreationFeedBehaviorTracker(new l());
        this.H = K;
        this.I = new m(this);
    }

    public final LiveData<Boolean> og() {
        return Transformations.map(C3().getFeedDataLiveData(), new o());
    }

    public final void CO(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
        C3().onSetPublicSuccess(r2);
    }

    public final void E3(Long r7) {
        if (r7 != null) goto L5;
    L13:
        V3(0, 100);
        return;
    L5:
        if (r7.longValue() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r7 = null;
    L11:
        if (r7 == null) goto L13;
        V3(0, (int) r7.longValue());
        r7.longValue();
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void Eo(zp9.p r2) {
        Intrinsics.checkNotNullParameter(r2, "creator");
        this.o = r2;
    }

    public final void H3(int r36) {
        if (this.o == null) goto L5;
        int r1 = r36 - 1;
    L6:
        CreationListAdapter r2 = this.s;
        Integer r3 = null;
        if (r2 == null) goto L15;
        List<UserCreationModel> r4 = r2.b;
        if (r4 == null) goto L15;
        UserCreationModel r5 = (UserCreationModel) CollectionsKt.getOrNull(r4, r1);
        if (r5 == null) goto L15;
        List r6 = r5.b();
        if (r6 == null) goto L15;
        UserCreation r7 = (UserCreation) CollectionsKt.firstOrNull(r6);
    L16:
        if (r7 != null) goto L18;
        m29.a.b("CreationFeedComponent", "data is null");
    L18:
        if (r7 == null) goto L110;
        zp9.e r8 = this.y;
        if (r8 == null) goto L25;
        zp9.m r9 = r8.b;
        if (r9 == null) goto L25;
        r9.i(r7);
    L25:
        String r10 = r7.a;
        String r11 = zp9.d.d(r7);
        String r12 = zp9.d.c(r7);
        AuthorInfo r13 = r7.g;
        if (r13 == null) goto L28;
        String r14 = r13.b;
    L29:
        String r15 = zp9.d.b(r7);
        Long r16 = r7.f;
        zp9.f r17 = this.x;
        if (r17 == null) goto L35;
        zp9.g r18 = r17.e;
        if (r18 == null) goto L35;
        String r20 = r18.a;
        if (r20 == null) goto L35;
    L36:
        String r110 = r20;
        UserCreationTrackParams r21 = r7.n;
        if (r21 == null) goto L41;
        Integer r22 = r21.c;
        if (r22 == null) goto L41;
        String r111 = r22.toString();
    L42:
        UserCreationTrackParams r23 = r7.n;
        if (r23 == null) goto L45;
        Integer r112 = r23.b;
    L46:
        if (r23 == null) goto L48;
        String r113 = r23.a;
    L49:
        zp9.f r24 = this.x;
        if (r24 == null) goto L54;
        zp9.g r25 = r24.e;
        if (r25 == null) goto L54;
        String r114 = r25.j;
    L55:
        if (r24 == null) goto L59;
        TabItemInfo r26 = r24.j;
        if (r26 == null) goto L59;
        String r115 = r26.getId();
    L60:
        zp9.f r27 = this.x;
        if (r27 == null) goto L65;
        TabItemInfo r28 = r27.j;
        if (r28 == null) goto L65;
        String r210 = r28.b();
    L66:
        zp9.f r30 = this.x;
        if (r30 == null) goto L71;
        zp9.g r31 = r30.e;
        if (r31 == null) goto L71;
        String r32 = r31.c;
    L72:
        if (r30 == null) goto L76;
        zp9.g r116 = r30.e;
        if (r116 == null) goto L76;
        Integer r117 = r116.e;
    L77:
        if (r30 == null) goto L81;
        zp9.g r118 = r30.e;
        if (r118 == null) goto L81;
        String r119 = r118.f;
    L82:
        if (r30 == null) goto L86;
        zp9.g r120 = r30.e;
        if (r120 == null) goto L86;
        String r211 = r120.i;
    L87:
        if (r30 == null) goto L91;
        zp9.g r121 = r30.e;
        if (r121 == null) goto L91;
        String r212 = r121.h;
    L92:
        if (r30 == null) goto L96;
        zp9.g r33 = r30.e;
        if (r33 == null) goto L96;
        String r213 = r33.d;
    L97:
        String r34 = r7.i;
        boolean r214 = r7.D();
        zp9.f r122 = this.x;
        if (r122 == null) goto L102;
        zp9.g r123 = r122.e;
        if (r123 == null) goto L102;
        String r215 = r123.l;
    L103:
        UserCreationRefContent r124 = r7.o;
        if (r124 == null) goto L108;
        List r125 = r124.a();
        if (r125 == null) goto L108;
        r3 = Integer.valueOf(r125.size());
    L108:
        u3.k(r32, r10, r11, r12, r14, r15, r16, r113, r114, null, r110, r111, r112, r119, r117, r115, null, r210, r212, r211, r213, r34, zp9.d.c(r7), r214, r3, r215, zp9.d.e(r7), null, null, null, -134217216);
        return;
    L102:
        r215 = null;
    L96:
        r213 = null;
    L91:
        r212 = null;
    L86:
        r211 = null;
    L81:
        r119 = null;
    L76:
        r117 = null;
    L71:
        r32 = null;
    L65:
        r210 = null;
    L59:
        r115 = null;
    L54:
        r114 = null;
        goto L55
    L48:
        r113 = null;
        goto L49
    L45:
        r112 = null;
    L41:
        r111 = null;
    L35:
        r20 = "";
        goto L36
    L28:
        r14 = null;
        goto L29
    L110:
        return;
    L15:
        r7 = null;
        goto L16
    L5:
        r1 = r36;
        goto L6
    }

    public final int Q3(Integer r2) {
        zp9.f r0 = this.x;
        if (r0 == null) goto L8;
        Integer r1 = r0.k;
        if (r1 == null) goto L8;
        return r1.intValue();
    L8:
        if (r2 != null) goto L10;
    L18:
        Context r3 = getContext();
        if (r3 == null) goto L21;
        float r4 = c7.d(Integer.valueOf(com.larus.utils.i.d(r3)));
    L23:
        if (r4 <= 500.0f) goto L25;
        return 3;
    L25:
        return 2;
    L21:
        r4 = 200.0f;
        goto L23
    L10:
        if (r2.intValue() <= 0) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L16;
        r2 = null;
    L16:
        if (r2 == null) goto L18;
        r4 = c7.d(r2);
        goto L23
    L12:
        r5 = false;
        goto L13
    }

    public final void X20(Function0<? extends View> r1) {
        this.p = r1;
    }

    public final void addOnScrollListener(RecyclerView.OnScrollListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        RecyclerView r0 = this.n.a();
        if (r0 == null) goto L6;
        r0.addOnScrollListener(r2);
        return;
    }

    public final void fQ(UserCreation r10) {
        Intrinsics.checkNotNullParameter(r10, "userCreation");
        boolean r0 = C3().hasFeedData();
        C3().setMockUserCreation(r10);
        if (r0 == false) goto L6;
        zp9.l.a.a(this, false, true, null, false, false, 29);
        return;
    }

    public final void onViewCreated(View r33) {
        Intrinsics.checkNotNullParameter(r33, "view");
        zp9.e r1 = this.y;
        if (r1 == null) goto L7;
        zp9.n r2 = r1.a;
        if (r2 == null) goto L7;
        CreationFeedCacheEntity r3 = r2.b();
    L9:
        if (r3 == null) goto L11;
        CreationFeedViewModel r5 = C3();
        Intrinsics.checkNotNullParameter(this, "<this>");
        CreationFeedViewModel.fetchFirstScreenData$default(r5, true, false, !(com.larus.ui.arch.component.internal.attach.a.b(this, this) instanceof TemplateCreationListFragment), 2, null);
    L22:
        View r4 = F2();
        if ((r4 instanceof FrameLayout) == false) goto L25;
        FrameLayout r6 = (FrameLayout) r4;
    L26:
        h0 r7 = this.n;
        LarusCommunityCreationFeedComponentLayoutBinding r8 = r7.a;
        if (r8 == null) goto L31;
        View r9 = r8.a;
        if (r9 == null) goto L31;
    L35:
        boolean r10 = false;
        if (r9 == null) goto L59;
        if (r6 == null) goto L39;
        r6.addView(r9, -1, -1);
    L39:
        ViewGroup.LayoutParams r11 = r9.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L42;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
    L43:
        if (r12 == null) goto L57;
        zp9.f r13 = this.x;
        if (r13 == null) goto L49;
        Integer r14 = r13.n;
        if (r14 == null) goto L49;
        int r15 = r14.intValue();
    L50:
        zp9.f r16 = this.x;
        if (r16 == null) goto L55;
        Integer r17 = r16.o;
        if (r17 == null) goto L55;
        int r18 = r17.intValue();
    L56:
        r12.setMargins(r15, 0, r18, 0);
    L58:
        r9.setLayoutParams(r12);
    L55:
        r18 = i5.M();
    L49:
        r15 = i5.M();
        goto L50
    L57:
        r12 = null;
        goto L58
    L42:
        r12 = null;
    L59:
        RecyclerView r20 = getRecyclerView();
        if (r20 == null) goto L69;
        zp9.f r21 = this.x;
        if (r21 == null) goto L66;
        Integer r22 = r21.h;
        if (r22 == null) goto L66;
        int r23 = r22.intValue();
    L67:
        r20.setPadding(0, r23, 0, 0);
    L66:
        r23 = i5.N() + i5.a();
    L69:
        if (AppHost.a.isDebug() == false) goto L78;
        int r24 = e29.d.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r25 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        Intrinsics.checkNotNullParameter(r25, "fragment");
        ICommunityHostBehaviorProvider r26 = e29.d.c();
        if (r26 == null) goto L73;
        boolean r27 = r26.h(r25);
    L74:
        if (r27 == false) goto L78;
        TextView r28 = new TextView(getContext());
        r28.setTextColor(ContextCompat.getColor(getContext(), 2131103298));
        r28.setText("std-feed");
        r28.setBackgroundColor(ColorProtector.parseColor("#FF6C55"));
        r28.setAlpha(0.5f);
        if (r6 == null) goto L78;
        r6.addView(r28, -2, -2);
        goto L78
    L73:
        r27 = true;
    L78:
        zp9.f r30 = this.x;
        if (r30 != null) goto L81;
    L83:
        boolean r31 = false;
    L84:
        if (r31 == true) goto L86;
    L95:
        int r32 = Q3(null);
        this.u = r32;
        zp9.f r34 = this.x;
        if (r34 != null) goto L98;
    L100:
        boolean r35 = false;
    L102:
        if (r35 == false) goto L104;
        final GridLayoutManager r36 = new GridLayoutManager(getContext(), this.u);
    L114:
        RecyclerView r37 = this.n.a();
        if (r37 == null) goto L130;
        r37.setLayoutManager(r36);
        r37.setSaveEnabled(false);
        boolean r38 = r36 instanceof StaggeredGridLayoutManager;
        zp9.f r40 = this.x;
        if (r40 == null) goto L119;
        RecyclerView.ItemDecoration r110 = r40.s;
    L120:
        if (r110 == null) goto L122;
        r37.addItemDecoration(r110);
    L129:
        r37.setItemAnimator(null);
        r37.removeOnLayoutChangeListener(this.I);
        r37.addOnLayoutChangeListener(this.I);
        goto L130
    L122:
        int r111 = this.u;
        if (r40 == null) goto L127;
        Integer r41 = r40.m;
        if (r41 == null) goto L127;
        int r42 = r41.intValue();
    L128:
        GridSpacingItemDecoration r112 = new GridSpacingItemDecoration(r111, r42, Boolean.valueOf(r38));
        this.v = r112;
        r37.addItemDecoration(r112);
    L127:
        r42 = i5.e0();
        goto L128
    L119:
        r110 = null;
    L130:
        zp9.f r43 = this.x;
        if (r43 == null) goto L134;
        String r44 = r43.c;
        if (r44 == null) goto L134;
    L135:
        final et3.c r45 = new et3.c(r44, false, null);
        RecyclerView r46 = this.n.a();
        if (r46 == null) goto L138;
        r46.addOnScrollListener(new CreationFeedComponent$initView$2(this, r36, r45));
    L138:
        int r113 = this.u;
        ArrayList r114 = new ArrayList();
        LifecycleCoroutineScope r115 = LifecycleOwnerKt.getLifecycleScope(this);
        zp9.p r116 = this.o;
        Function0<? extends View> r47 = this.p;
        if (r47 != null) goto L141;
        Context r48 = getContext();
        Intrinsics.checkNotNullParameter(r48, "context");
        Function0<? extends View> r117 = new r29.g(r48);
    L142:
        int r118 = B3();
        zp9.f r50 = this.x;
        if (r50 == null) goto L145;
        boolean r119 = r50.i;
    L146:
        Intrinsics.checkNotNullParameter(this, "<this>");
        String r120 = com.larus.ui.arch.component.internal.attach.a.b(this, this).toString();
        zp9.f r51 = this.x;
        i29.c r52 = this.D;
        zp9.e r53 = this.y;
        if (r53 == null) goto L149;
        RecyclerView.RecycledViewPool r210 = r53.d;
    L150:
        CreationListAdapter r54 = new CreationListAdapter(r113, r114, r115, r116, r117, r118, r119, r120, r51, r52, r210, this.E);
        this.s = r54;
        d0 r55 = new d0(this);
        Intrinsics.checkNotNullParameter(r55, "creationClickCallBack");
        r54.m = r55;
        RecyclerView r56 = this.n.a();
        if (r56 == null) goto L153;
        y6.f(r56, new a0(this), new h(this), 0.0f, new i(this), 49);
    L153:
        z2 r57 = z2.a;
        if (r57.creationFeedHolderOpt() == false) goto L163;
        zp9.e r58 = this.y;
        if (r58 == null) goto L159;
        RecyclerView.RecycledViewPool r60 = r58.d;
        if (r60 == null) goto L159;
    L160:
        RecyclerView r61 = this.n.a();
        if (r61 == null) goto L163;
        r61.setRecycledViewPool(r60);
    L159:
        r60 = CreationListAdapter.a.a();
    L163:
        RecyclerView r62 = this.n.a();
        if (r62 == null) goto L167;
        r62.setAdapter(this.s);
    L167:
        if (r57.creationFeedHolderOpt() == false) goto L194;
        RecyclerView r63 = this.n.a();
        if (r63 == null) goto L194;
        final CreationListAdapter r64 = this.s;
        if (r64 == null) goto L194;
        Intrinsics.checkNotNullParameter(this, "<this>");
        LifecycleOwner r65 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner();
        Intrinsics.checkNotNullParameter(r63, "recyclerView");
        Intrinsics.checkNotNullParameter(r65, "lifecycleOwner");
        if (r57.creationFeedHolderOpt() == false) goto L194;
        if (r64.s == true) goto L194;
        RecyclerView.RecycledViewPool r66 = r64.k;
        if (r66 != null) goto L181;
        r66 = r63.getRecycledViewPool();
    L181:
        ArrayDeque<Integer> r67 = new ArrayDeque();
        Integer[] r121 = CreationListAdapter.y;
        int r122 = 0;
    L183:
        if (r122 >= 6) goto L191;
        int r123 = r121[r122].intValue();
        int r124 = 12 - r66.getRecycledViewCount(r123);
        if (r124 <= 0) goto L189;
        int r125 = 0;
    L187:
        if (r125 >= r124) goto L189;
        r67.add(Integer.valueOf(r123));
        r125 = r125 + 1;
    L189:
        r122 = r122 + 1;
        goto L183
    L191:
        if (r67.isEmpty() == true) goto L194;
        MessageQueue r68 = Looper.myQueue();
        r64.t = r67;
        r64.u = new WeakReference(r63);
        r64.v = r68;
        r68.addIdleHandler(r64.w);
        r64.s = true;
        r65.getLifecycle().addObserver(new CreationListAdapter$preload$1(r64));
    L194:
        SwipeRefreshLayout r70 = this.n.b();
        if (r70 == null) goto L197;
        r70.setOnRefreshListener(new q(this));
        r70.setColorSchemeColors(new int[]{ContextCompat.getColor(r70.getContext(), 2131103203)});
        r70.setProgressViewOffset(false, (-i5.b()) + r70.getProgressViewStartOffset(), r70.getProgressViewEndOffset() + r70.getProgressViewStartOffset());
    L197:
        RecyclerView r71 = this.n.a();
        if (r71 == null) goto L200;
        r71.addOnScrollListener(new CreationFeedComponent$initLoadMore$1(this));
    L200:
        CreationFeedComponentState r72 = (CreationFeedComponentState) C3().getState();
        if ((!r72.getCreationModelList().isEmpty()) == false) goto L232;
        RecyclerView r73 = this.n.a();
        if (r73 == null) goto L214;
        Integer r74 = Integer.valueOf(r73.getWidth());
        if (r74.intValue() <= 0) goto L207;
        r10 = true;
    L207:
        if (r10 == true) goto L210;
        r74 = null;
    L210:
        if (r74 == null) goto L214;
        int r75 = r74.intValue();
        CreationListAdapter r76 = this.s;
        if (r76 == null) goto L214;
        r76.y2(r75);
    L214:
        W3(r72.getCreationModelList(), "cache");
        boolean r77 = m29.a.a;
        m29.a.c("CreationFeedComponent", "hitCache size:" + r72.getCreationModelList().size());
        RecyclerView r78 = this.n.a();
        if (r78 == null) goto L218;
        r78.post(new n(this));
    L218:
        if ((r72.getPageState() instanceof r29.k.e) == false) goto L220;
    L221:
        SwipeRefreshLayout r80 = this.n.b();
        if (r80 == null) goto L224;
        r80.setEnabled(true);
    L224:
        CreationListAdapter r81 = this.s;
        if (r81 == null) goto L227;
        r29.k r82 = r72.getPageState();
        Intrinsics.checkNotNullParameter(r82, "state");
        r81.q = r82;
        m29.a.a("CreationListAdapter", new g29.a(r82));
        r81.notifyDataSetChanged();
    L227:
        gs9.i r83 = r72.getMoreState();
        if (r83 == null) goto L232;
        CreationListAdapter r84 = this.s;
        if (r84 == null) goto L232;
        r84.B2(r83);
        goto L232
    L220:
        if ((r72.getPageState() instanceof r29.k.a) == false) goto L224;
    L232:
        ComponentViewModel.onEach$default(C3(), CreationFeedComponent$initObservers$2.INSTANCE, null, new CreationFeedComponent$initObservers$3(this, null), 2, null);
        ComponentViewModel.onEach$default(C3(), CreationFeedComponent$initObservers$4.INSTANCE, null, new CreationFeedComponent$initObservers$5(this, null), 2, null);
        ComponentViewModel.onEach$default(C3(), CreationFeedComponent$initObservers$6.INSTANCE, null, new CreationFeedComponent$initObservers$7(this, null), 2, null);
        ComponentViewModel.onEach$default(C3(), CreationFeedComponent$initObservers$8.INSTANCE, null, new CreationFeedComponent$initObservers$9(this, null), 2, null);
        ComponentViewModel.onEach$default(C3(), CreationFeedComponent$initObservers$10.INSTANCE, null, new CreationFeedComponent$initObservers$11(this, null), 2, null);
        ComponentViewModel.onEach$default(C3(), CreationFeedComponent$initObservers$12.INSTANCE, null, new CreationFeedComponent$initObservers$13(this, null), 2, null);
        return;
    L149:
        r210 = null;
        goto L150
    L145:
        r119 = false;
        goto L146
    L141:
        r117 = r47;
    L134:
        Intrinsics.checkNotNullParameter(this, "<this>");
        r44 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getClass().getName();
        goto L135
    L104:
        GridLayoutManager r85 = new CreationFeedStaggeredGridLayoutManager(r32);
        zp9.f r86 = this.x;
        if (r86 != null) goto L107;
    L109:
        boolean r87 = false;
    L110:
        if (r87 == false) goto L112;
        m29.a.b("CreationFeedComponent", "enableGapHandling");
    L113:
        r36 = r85;
        goto L114
    L112:
        r85.setGapStrategy(0);
        goto L113
    L107:
        if (r86.v != true) goto L109;
        r87 = true;
        goto L110
    L98:
        if (r34.l != true) goto L100;
        r35 = true;
        goto L102
    L86:
        if (r30 == null) goto L89;
        String r88 = r30.A;
        if (r88 == null) goto L89;
    L90:
        if (r30 == null) goto L93;
        String r90 = r30.B;
        if (r90 == null) goto L93;
    L94:
        this.D = new i29.c(r88, r90);
        this.E = new p29.b();
    L93:
        r90 = "message_card";
    L89:
        r88 = "ugc_video";
        goto L90
    L81:
        if (r30.u != true) goto L83;
        r31 = true;
    L31:
        LarusCommunityCreationFeedComponentLayoutNoRefreshBinding r91 = r7.b;
        if (r91 == null) goto L34;
        r9 = r91.a;
        goto L35
    L34:
        r9 = null;
        goto L35
    L25:
        r6 = null;
        goto L26
    L11:
        z1 r92 = z1.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r93 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getParentFragment();
        if (r93 == null) goto L14;
        Bundle r94 = r93.getArguments();
    L15:
        Intent r95 = s1a.a.getActivity(this).getIntent();
        if (r95 == null) goto L18;
        Bundle r96 = r95.getExtras();
    L20:
        if (r92.a(r94, r96, B3()) == false) goto L22;
        CreationFeedViewModel r97 = C3();
        Intrinsics.checkNotNullParameter(this, "<this>");
        CreationFeedViewModel.fetchFirstScreenData$default(r97, true, false, !(com.larus.ui.arch.component.internal.attach.a.b(this, this) instanceof TemplateCreationListFragment), 2, null);
        goto L22
    L18:
        r96 = null;
        goto L20
    L14:
        r94 = null;
    L7:
        r3 = null;
        goto L9
    }

    public final void xc(UserCreation r9) {
        Intrinsics.checkNotNullParameter(r9, "userCreation");
        C3().setMockUserCreation(r9);
        zp9.l.a.a(this, false, true, null, false, false, 29);
    }

    public final String z3(int r3) {
        if (this.o == null) goto L5;
        r3 = r3 - 1;
    L5:
        CreationListAdapter r0 = this.s;
        if (r0 == null) goto L14;
        List<UserCreationModel> r1 = r0.b;
        if (r1 == null) goto L14;
        UserCreationModel r4 = (UserCreationModel) CollectionsKt.getOrNull(r1, r3);
        if (r4 == null) goto L14;
        List r5 = r4.b();
        if (r5 == null) goto L14;
        UserCreation r6 = (UserCreation) CollectionsKt.firstOrNull(r5);
    L15:
        StringBuilder r2 = new StringBuilder();
        if (r6 == null) goto L19;
        Object r7 = r6.a;
        if (r7 == null) goto L19;
    L20:
        r2.append(r7);
        r2.append('_');
        if (r6 == null) goto L24;
        Object r8 = r6.f;
        if (r8 == null) goto L24;
    L25:
        r2.append(r8);
        return r2.toString();
    L24:
        r8 = "";
    L19:
        r7 = 0;
    L14:
        r6 = null;
        goto L15
    }

    public final void V3(int r4, final int r5) {
        RecyclerView r0 = this.n.a();
        if (r0 != null) goto L5;
        return;
    L5:
        final Context r1 = getContext();
        LinearSmoothScroller r2 = new CreationFeedComponent$smoothScrollToPositionToStart$linearSmoothScroller$1(r5, r1);
        r2.setTargetPosition(r4);
        RecyclerView.LayoutManager r6 = r0.getLayoutManager();
        if (r6 == null) goto L9;
        r6.startSmoothScroll(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final void W3(final List<UserCreationModel> r8, String r9) {
        FLogger.a.d("CreationFeedComponent", "submit creation model list, reason=" + r9 + ", size=" + r8.size());
        if (B3() != 2) goto L10;
        ?? r1 = new ArrayList();
        Iterator r10 = r8.iterator();
    L6:
        if (r10.hasNext() == false) goto L11;
        Object r2 = r10.next();
        if (fs9.a0.b((UserCreationModel) r2) == true) goto L6;
        r1.add(r2);
    L11:
        ArrayList r11 = new ArrayList();
        Iterator r3 = ((Iterable) r1).iterator();
    L13:
        if (r3.hasNext() == false) goto L18;
        List r4 = ((UserCreationModel) r3.next()).b();
        if (r4 != null) goto L17;
        r4 = CollectionsKt.emptyList();
    L17:
        CollectionsKt.addAll(r11, r4);
        goto L13
    L18:
        this.t = r11;
        final CreationListAdapter r12 = this.s;
        if (r12 != null) goto L21;
        return;
    L21:
        if (r12.b.isEmpty() == false) goto L23;
        r12.b.addAll(r8);
        r12.notifyDataSetChanged();
        return;
    L23:
        List<UserCreationModel> r5 = r12.b;
        boolean r6 = true;
        if (CollectionsKt.listOf(new Integer[]{1, 2}).contains(Integer.valueOf(r12.f)) == true) goto L26;
    L28:
        r6 = false;
    L29:
        DiffUtil.DiffResult r0 = DiffUtil.calculateDiff(new CreationListAdapter.DiffCallback(r5, r8, r6), false);
        r12.b.clear();
        r12.b.addAll(r8);
        r0.dispatchUpdatesTo(r12);
        m29.a.a("CreationListAdapter", new g29.e(r12, r8));
        return;
    L26:
        if (z2.a.creationNoWatermarkConfig().a() == false) goto L28;
    L10:
        r1 = r8;
        goto L11
    }

    public final void deleteUserCreation(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "creationId");
        C3().deleteUserCreation(r2, r3);
    }

    public final void m3(final String r9, RecyclerView r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        m29.a.a("CreationFeedComponent", new g(r9));
        if (C3().preCheckCanLoadMore() == false) goto L38;
        StaggeredGridLayoutManager r11 = r10.getLayoutManager();
        if ((r11 instanceof StaggeredGridLayoutManager) == false) goto L27;
        final int[] r12 = r11.findLastVisibleItemPositions(null);
        CreationListAdapter r0 = this.s;
        if (r0 == null) goto L11;
        final int r1 = r0.getItemCount();
    L12:
        m29.a.a("CreationFeedComponent", new r(r12, r1));
        if (r12 == null) goto L39;
        int r13 = r12.length;
        int r4 = 0;
    L15:
        if (r4 >= r13) goto L23;
        int r5 = r12[r4];
        if ((r1 - r5) >= this.H) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == true) goto L21;
        r4 = r4 + 1;
        goto L15
    L21:
        Integer r14 = Integer.valueOf(r5);
    L24:
        if (r14 == null) goto L40;
        r14.intValue();
        CreationFeedViewModel.tryLoadMore$default(C3(), false, 1, null);
        return;
    L40:
        return;
    L19:
        r6 = false;
        goto L20
    L23:
        r14 = null;
        goto L24
    L39:
        return;
    L11:
        r1 = 0;
        goto L12
    L27:
        if ((r11 instanceof GridLayoutManager) == false) goto L42;
        final int r15 = ((GridLayoutManager) r11).findLastVisibleItemPosition();
        CreationListAdapter r2 = this.s;
        if (r2 == null) goto L31;
        final int r3 = r2.getItemCount();
    L32:
        m29.a.a("CreationFeedComponent", new t(r15, r3));
        if ((r3 - r15) >= this.H) goto L43;
        CreationFeedViewModel.tryLoadMore$default(C3(), false, 1, null);
        return;
    L43:
        return;
    L31:
        r3 = 0;
        goto L32
    L42:
        return;
    }

    public final void nh(zp9.f r6, zp9.e r7) {
        Intrinsics.checkNotNullParameter(r6, "initParams");
        Intrinsics.checkNotNullParameter(r7, "initDependency");
        h0 r0 = this.n;
        Context r1 = getContext();
        boolean r2 = !r6.d;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "context");
        if (r2 == false) goto L9;
        SwipeRefreshLayout r3 = LayoutInflater.from(r1).inflate(2131561936, null, false);
        RecyclerView r4 = ViewBindings.findChildViewById(r3, 2131384076);
        if (r4 == null) goto L8;
        SwipeRefreshLayout r5 = r3;
        r0.a = new LarusCommunityCreationFeedComponentLayoutBinding(r5, r4, r5);
    L12:
        SwipeRefreshLayout r8 = this.n.b();
        if (r8 == null) goto L15;
        r8.setEnabled(false);
    L15:
        this.x = r6;
        Integer r9 = r6.w;
        if (r9 == null) goto L18;
        int r10 = r9.intValue();
    L19:
        this.H = r10;
        boolean r11 = m29.a.a;
        m29.a.c("CreationFeedComponent", "loadMoreDistance:" + this.H);
        this.y = r7;
        C3().initialize(r7.a, r6);
        this.q = new u1(r7);
        return;
    L18:
        r10 = K;
        goto L19
    L8:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(2131384076)));
    L9:
        RecyclerView r12 = LayoutInflater.from(r1).inflate(2131561938, null, false);
        if (r12 == null) goto L22;
        RecyclerView r13 = r12;
        r0.b = new LarusCommunityCreationFeedComponentLayoutNoRefreshBinding(r13, r13);
        goto L12
    L22:
        throw new NullPointerException("rootView");
    }

    public static final void Y2(CreationFeedComponent r13, int r14, String r15) {
        CreationListAdapter r0 = r13.s;
        UserCreation r1 = null;
        if (r0 == null) goto L7;
        List<UserCreationModel> r2 = r0.b;
        if (r2 == null) goto L7;
        UserCreationModel r3 = (UserCreationModel) CollectionsKt.getOrNull(r2, r14);
    L8:
        boolean r4 = false;
        if (r13.B3() != 2) goto L17;
        if (r3 != null) goto L12;
    L14:
        boolean r5 = false;
    L15:
        if (r5 == false) goto L17;
        return;
    L12:
        if (fs9.a0.b(r3) != true) goto L14;
        r5 = true;
    L17:
        if (r3 == null) goto L22;
        List r6 = r3.b();
        if (r6 == null) goto L22;
        r1 = (UserCreation) CollectionsKt.firstOrNull(r6);
    L22:
        if (r1 != null) goto L25;
        m29.a.b("CreationFeedComponent", "data is null");
        return;
    L25:
        if (r1.b == 1) goto L30;
        int r7 = r13.B3();
        if (r7 == 1) goto L31;
        if (r7 != 2) goto L30;
    L31:
        boolean r8 = true;
    L32:
        if (r8 == false) goto L45;
        CreationNoWatermarkManager.a.getClass();
        if (CreationNoWatermarkManager.l0(r1) == false) goto L45;
        StringBuilder r9 = new StringBuilder();
        r9.append(r13.B3());
        r9.append(':');
        String r10 = r1.a;
        if (r10 != null) goto L40;
        r10 = "";
    L40:
        r9.append(r10);
        r9.append(':');
        r9.append(r14);
        String r11 = r9.toString();
        if (r13.r.add(r11) == true) goto L43;
        FLogger.a.i("CreationFeedComponent", "profile detail no watermark opening");
    L44:
        r4 = true;
        goto L45
    L43:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r13), null, null, new CreationFeedComponent$ensureProfileNoWatermarkBeforeOpen$1(r1, r13, r11, r14, r15, null), 3, null);
    L45:
        if (r4 == true) goto L51;
        r13.D3(r14, r15, r1);
        return;
    L51:
        return;
    L30:
        r8 = false;
    L7:
        r3 = null;
        goto L8
    }

    public static final Object h3(CreationFeedComponent r4, Long r5, Continuation r6) {
        r4.getClass();
        if ((r6 instanceof CreationFeedComponent$scrollToTopAndPerformRefresh$1) == false) goto L7;
        CreationFeedComponent$scrollToTopAndPerformRefresh$1 r0 = (CreationFeedComponent$scrollToTopAndPerformRefresh$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L24:
        r4.C3().refresh("scrollToTopAndRefresh2", true);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        RecyclerView r8 = r4.n.a();
        if (r8 != null) goto L18;
        return Unit.INSTANCE;
    L18:
        if (r8.computeVerticalScrollOffset() <= 0) goto L24;
        r4.E3(r5);
        RecyclerView r9 = r4.n.a();
        if (r9 == null) goto L24;
        r0.label = 1;
        if (ViewExtKt.c(r9, r0) != r2) goto L24;
        return r2;
    L7:
        r0 = new CreationFeedComponent$scrollToTopAndPerformRefresh$1(r4, r6);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [com.larus.community.impl.component.v] */
    public final void D3(final int r310, String r40, UserCreation r41) {
        if (r41.b == 1) goto L8;
        int r3 = B3();
        if (r3 == 1) goto L9;
        if (r3 != 2) goto L8;
    L9:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L17;
        CreationNoWatermarkManager r5 = CreationNoWatermarkManager.a;
        if (r5.D() == false) goto L17;
        UserCreation r6 = r5.f0(r41, false);
        if (r6 == null) goto L17;
        UserCreation r7 = r6;
    L18:
        zp9.e r2 = this.y;
        if (r2 == null) goto L25;
        zp9.m r8 = r2.b;
        if (r8 == null) goto L25;
        if (r8.b(r7) != true) goto L25;
        boolean r9 = true;
    L27:
        if (r9 == false) goto L30;
        m29.a.c("CreationFeedComponent", "onClickGoCreationDetail  interceptor");
        return;
    L30:
        C3().cancelRefresh();
        int r10 = e29.d.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r11 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        int r13 = B3();
        Bundle r14 = new Bundle();
        r14.putString("creation", GsonProtectorUtils.toJson(new Gson(), r7));
        Gson r12 = new Gson();
        zp9.f r15 = this.x;
        if (r15 == null) goto L33;
        zp9.g r16 = r15.e;
    L34:
        r14.putString("track_params", GsonProtectorUtils.toJson(r12, r16));
        AuthorInfo r17 = r7.g;
        if (r17 == null) goto L37;
        String r18 = r17.b;
    L38:
        AccountService r110 = AccountService.a;
        boolean r20 = !Intrinsics.areEqual(r18, r110.getUserId());
        if (r20 == true) goto L41;
    L43:
        boolean r111 = false;
    L44:
        r14.putBoolean("is_show_profile", r111);
        zp9.f r112 = this.x;
        if (r112 == null) goto L47;
        boolean r113 = r112.p;
    L48:
        r14.putBoolean("show_usage_count", r113);
        r14.putBoolean("can_show_inspiration_list", r20);
        zp9.e r21 = this.y;
        if (r21 == null) goto L55;
        zp9.m r22 = r21.b;
        if (r22 == null) goto L55;
        if (r22.e() == true) goto L55;
        boolean r23 = true;
    L56:
        r14.putBoolean("ignore_tpl_info", r23);
        zp9.f r24 = this.x;
        if (r24 == null) goto L59;
        r14.putBoolean("open_new_chat_page_on_send", r24.r);
    L59:
        zp9.f r25 = this.x;
        if (r25 == null) goto L64;
        Integer r26 = r25.y;
        if (r26 == null) goto L64;
        r14.putInt("creation_dosame_landing_type", r26.intValue());
    L64:
        zp9.f r27 = this.x;
        if (r27 == null) goto L69;
        Boolean r28 = r27.z;
        if (r28 == null) goto L69;
        boolean r30 = r28.booleanValue();
    L70:
        r14.putBoolean("is_send_from_detail", r30);
        Unit r31 = Unit.INSTANCE;
        if (B3() != 1) goto L75;
        AuthorInfo r32 = r7.g;
        if (r32 == null) goto L75;
        String r33 = r32.b;
    L76:
        Intrinsics.checkNotNullParameter(r11, "fragment");
        Intrinsics.checkNotNullParameter(r7, "userCreation");
        Intrinsics.checkNotNullParameter(r14, "detailArguments");
        ICommunityHostBehaviorProvider r114 = e29.d.c();
        if (r114 == null) goto L81;
        String r210 = "can_show_inspiration_list";
        String r34 = "track_params";
        if (r114.q(r11, r7, r13, r14, r33) != true) goto L82;
        boolean r35 = true;
    L83:
        if (r35 == false) goto L85;
        return;
    L85:
        String r115 = "";
        if (B3() != 2) goto L219;
        int r36 = z2.a.getCreationDetailLayoutConfig().c();
        IChatGalleryService.Companion r116 = IChatGalleryService.a;
        PreviewScene r117 = PreviewScene.PRIVATE_ALBUM;
        if (r116.n(r117, false) == true) goto L97;
        if (1 <= r36) goto L92;
    L94:
        boolean r37 = false;
    L95:
        if (r37 == false) goto L219;
    L92:
        if (r36 >= 7) goto L94;
        r37 = true;
    L97:
        if (r7.b != 1) goto L213;
        s1 r38 = new s1(C3());
        LiveData<List<UserCreationModel>> r42 = r38.getFeedDataLiveData();
        if (r42 == null) goto L102;
        List r43 = (List) r42.getValue();
        if (r43 == null) goto L102;
    L103:
        CreationListAdapter r44 = this.s;
        if (r44 == null) goto L108;
        List<UserCreationModel> r45 = r44.b;
        if (r45 == null) goto L108;
        UserCreationModel r0 = (UserCreationModel) CollectionsKt.getOrNull(r45, r310);
    L109:
        if (r0 == null) goto L115;
        List r1 = r0.b();
        if (r1 == null) goto L115;
        UserCreation r46 = (UserCreation) CollectionsKt.firstOrNull(r1);
        if (r46 == null) goto L115;
        String r47 = r46.a;
    L116:
        Iterator r48 = r43.iterator();
        int r50 = 0;
    L118:
        if (r48.hasNext() == false) goto L140;
        List r51 = ((UserCreationModel) r48.next()).b();
        if (r51 == null) goto L136;
        List r52 = r51;
        if ((r52 instanceof Collection) == true) goto L124;
    L126:
        Iterator r53 = r52.iterator();
    L128:
        if (r53.hasNext() == false) goto L132;
        if (Intrinsics.areEqual(((UserCreation) r53.next()).a, r47) == false) goto L128;
        boolean r54 = true;
    L134:
        if (r54 != true) goto L136;
        boolean r55 = true;
    L137:
        if (r55 == true) goto L141;
        r50 = r50 + 1;
    L141:
        int r56 = RangesKt.coerceAtLeast(r50, 0);
        int r57 = B3();
        if (r57 != 1) goto L144;
        int r211 = 1;
    L148:
        com.larus.platform.service.e0 r58 = com.larus.platform.service.e0.a;
        gs9.c r60 = new gs9.c(new p(this), r56, "", r211, false);
        zp9.f r61 = this.x;
        if (r61 == null) goto L151;
        boolean r62 = r61.p;
    L152:
        if (r61 == null) goto L154;
        boolean r118 = r61.p;
    L155:
        gs9.a r119 = new gs9.a(r62, r118);
        if (r61 == null) goto L163;
        zp9.g r120 = r61.e;
        if (r120 == null) goto L163;
        String r121 = r120.b;
        if (r121 == null) goto L163;
        String r212 = r121;
    L164:
        Boolean r213 = Boolean.FALSE;
        if (r61 == null) goto L169;
        zp9.g r122 = r61.e;
        if (r122 == null) goto L169;
        String r214 = r122.g;
    L170:
        if (r61 == null) goto L174;
        zp9.g r123 = r61.e;
        if (r123 == null) goto L174;
        String r215 = r123.d;
    L175:
        if (r61 == null) goto L179;
        zp9.g r63 = r61.e;
        if (r63 == null) goto L179;
        String r216 = r63.j;
    L180:
        gs9.g r64 = r58.a(r60, new gs9.d(r38, r119, null, new gs9.b("template_detail_button", r212, r213, r40, r214, r215, r216), null, 448));
        if (r64 != null) goto L383;
        UserCreationModel r65 = (UserCreationModel) CollectionsKt.getOrNull(r43, r56);
        if (r65 == null) goto L390;
        List r66 = r65.b();
        if (r66 == null) goto L391;
        UserCreation r67 = (UserCreation) CollectionsKt.firstOrNull(r66);
        if (r67 == null) goto L393;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r68 = com.larus.ui.arch.component.internal.attach.a.b(this, this).requireContext();
        zp9.f r70 = this.x;
        if (r70 == null) goto L192;
        zp9.g r71 = r70.e;
    L193:
        if (r70 == null) goto L195;
        boolean r72 = r70.p;
    L196:
        if (r70 == null) goto L198;
        boolean r124 = r70.r;
    L199:
        if (r70 == null) goto L201;
        Integer r125 = r70.y;
    L202:
        if (r70 == null) goto L206;
        Boolean r73 = r70.z;
        if (r73 == null) goto L206;
        boolean r126 = r73.booleanValue();
    L207:
        q29.a.b(r68, r67, r71, r72, r124, r125, r126, 104);
        return;
    L206:
        r126 = false;
        goto L207
    L201:
        r125 = null;
        goto L202
    L198:
        r124 = true;
        goto L199
    L195:
        r72 = false;
        goto L196
    L192:
        r71 = null;
        goto L193
    L393:
        return;
    L391:
        return;
    L390:
        return;
    L383:
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Exception -> L210
        r64.ax(com.larus.ui.arch.component.internal.attach.a.b(this, this).getChildFragmentManager(), "CreationFeedComponent");     // Catch: Exception -> L210
        this.w = false;     // Catch: Exception -> L210
        return;
    L210:
        e = move-exception;
        FLogger.a.e("CreationFeedComponent", "openMusicOnlyDetailPage error: " + e.getMessage());
        return;
    L179:
        r216 = null;
    L174:
        r215 = null;
    L169:
        r214 = null;
    L163:
        r212 = "create_feed";
        goto L164
    L154:
        r118 = false;
        goto L155
    L151:
        r62 = false;
        goto L152
    L144:
        if (r57 == 2) goto L146;
        r211 = 4;
        goto L148
    L146:
        r211 = 2;
    L132:
        r54 = false;
        goto L134
    L124:
        if (r52.isEmpty() == false) goto L126;
    L136:
        r55 = false;
        goto L137
    L140:
        r50 = -1;
    L115:
        r47 = null;
    L108:
        r0 = null;
    L102:
        r43 = CollectionsKt.emptyList();
        goto L103
    L213:
        g0 r74 = new g0(C3(), new v(this));
        String r75 = r7.a;
        if (r75 == null) goto L217;
        r115 = r75;
    L217:
        Context r76 = getContext();
        Intrinsics.checkNotNullParameter(this, "<this>");
        r116.e(r76, com.larus.ui.arch.component.internal.attach.a.b(this, this).getChildFragmentManager(), r74, r115, r310, r117);
        return;
    L219:
        z2 r77 = z2.a;
        if (r77.f1().d() == true) goto L222;
    L269:
        final Ref.IntRef r78 = new Ref.IntRef();
        int r80 = B3();
        if (r80 != 1) goto L272;
        int r81 = 1;
    L276:
        com.larus.platform.service.e0 r127 = com.larus.platform.service.e0.a;
        if (r81 != 4) goto L285;
        AuthorInfo r82 = r7.g;
        if (r82 == null) goto L282;
        String r83 = r82.b;
        if (r83 == null) goto L282;
    L283:
        r115 = r83;
    L282:
        r83 = "default";
    L285:
        if (r77.f1().d() == true) goto L287;
    L289:
        boolean r128 = false;
    L290:
        int r84 = r81;
        UserCreation r85 = r7;
        gs9.c r129 = new gs9.c(new w(this), r310, r115, r84, r128);
        zp9.e r86 = this.y;
        if (r86 == null) goto L293;
        zp9.m r217 = r86.b;
    L294:
        CreationFeedViewModel r218 = C3();
        zp9.f r87 = this.x;
        if (r87 == null) goto L297;
        boolean r88 = r87.p;
    L298:
        if (r87 == null) goto L300;
        boolean r90 = r87.p;
    L301:
        gs9.a r91 = new gs9.a(r88, r90);
        gs9.f r92 = new CreationFeedComponent$openCreationDetailPage$creationFragment$2(r78, r310, this);
        if (r87 == null) goto L305;
        String r93 = r87.C;
        if (r93 == null) goto L305;
    L306:
        String r219 = r93;
        if (r87 == null) goto L310;
        String r94 = r87.D;
        if (r94 == null) goto L310;
    L311:
        String r220 = r94;
        if (r87 == null) goto L319;
        zp9.g r95 = r87.e;
        if (r95 == null) goto L319;
        String r96 = r95.b;
        if (r96 == null) goto L319;
        String r311 = r96;
    L320:
        Boolean r312 = Boolean.FALSE;
        if (r87 == null) goto L325;
        zp9.g r97 = r87.e;
        if (r97 == null) goto L325;
        String r313 = r97.g;
    L326:
        if (r87 == null) goto L330;
        zp9.g r98 = r87.e;
        if (r98 == null) goto L330;
        String r314 = r98.d;
    L331:
        if (r87 == null) goto L335;
        zp9.g r100 = r87.e;
        if (r100 == null) goto L335;
        String r315 = r100.j;
    L336:
        gs9.g r101 = r127.a(r129, new gs9.d(r218, r91, r92, true, true, new gs9.b("template_detail_button", r311, r312, r40, r313, r314, r315), r217, r219, r220));
        if (r101 != null) goto L381;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r130 = com.larus.ui.arch.component.internal.attach.a.b(this, this).requireContext();
        zp9.f r102 = this.x;
        if (r102 == null) goto L341;
        zp9.g r131 = r102.e;
    L342:
        AuthorInfo r103 = r85.g;
        if (r103 == null) goto L345;
        String r104 = r103.b;
    L346:
        boolean r132 = !Intrinsics.areEqual(r104, r110.getUserId());
        zp9.f r105 = this.x;
        if (r105 == null) goto L349;
        boolean r133 = r105.p;
    L350:
        AuthorInfo r106 = r85.g;
        if (r106 == null) goto L353;
        String r107 = r106.b;
    L354:
        boolean r134 = !Intrinsics.areEqual(r107, r110.getUserId());
        zp9.e r108 = this.y;
        if (r108 == null) goto L361;
        zp9.m r109 = r108.b;
        if (r109 == null) goto L361;
        if (r109.e() == true) goto L361;
        boolean r135 = true;
    L362:
        zp9.f r136 = this.x;
        if (r136 == null) goto L365;
        boolean r137 = r136.r;
    L366:
        if (r136 == null) goto L368;
        Integer r138 = r136.y;
    L369:
        if (r136 == null) goto L373;
        Boolean r139 = r136.z;
        if (r139 == null) goto L373;
        boolean r140 = r139.booleanValue();
    L374:
        q29.a.a(r130, r85, r131, r132, r133, r134, r135, r137, r138, r140);
        return;
    L373:
        r140 = false;
        goto L374
    L368:
        r138 = null;
        goto L369
    L365:
        r137 = true;
    L361:
        r135 = false;
        goto L362
    L353:
        r107 = null;
        goto L354
    L349:
        r133 = false;
        goto L350
    L345:
        r104 = null;
        goto L346
    L341:
        r131 = null;
        goto L342
    L381:
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Exception -> L378
        r101.ax(com.larus.ui.arch.component.internal.attach.a.b(this, this).getChildFragmentManager(), "CreationFeedComponent");     // Catch: Exception -> L378
        this.w = false;     // Catch: Exception -> L378
        return;
    L378:
        e = move-exception;
        FLogger.a.e("CreationFeedComponent", "there have something wrong when show e=" + e.getMessage());
        return;
    L335:
        r315 = null;
    L330:
        r314 = null;
    L325:
        r313 = null;
    L319:
        r311 = "create_feed";
    L310:
        r94 = "immersive_preview";
    L305:
        r93 = "ugc_video";
        goto L306
    L300:
        r90 = false;
        goto L301
    L297:
        r88 = false;
        goto L298
    L293:
        r217 = null;
        goto L294
    L287:
        if (B3() == 2) goto L289;
        r128 = true;
        goto L290
    L272:
        if (r80 == 2) goto L274;
        r81 = 4;
        goto L276
    L274:
        r81 = 2;
        goto L276
    L222:
        if (r7.b == 1) goto L269;
        if (B3() == 2) goto L269;
        AuthorInfo r141 = r7.g;
        if (r141 == null) goto L228;
        String r142 = r141.b;
    L229:
        boolean r143 = !Intrinsics.areEqual(r142, r110.getUserId());
        com.bytedance.router.i r144 = SmartRouter.buildRoute(getContext(), "//flow/creation_detail");
        r144.c.putExtra("creation", GsonProtectorUtils.toJson(new Gson(), r7));
        Gson r145 = new Gson();
        zp9.f r146 = this.x;
        if (r146 == null) goto L232;
        zp9.g r147 = r146.e;
    L233:
        r144.c.putExtra(r34, GsonProtectorUtils.toJson(r145, r147));
        if (r143 == true) goto L236;
    L238:
        boolean r148 = false;
    L239:
        r144.c.putExtra("is_show_profile", r148);
        zp9.f r149 = this.x;
        if (r149 == null) goto L242;
        Boolean r150 = Boolean.valueOf(r149.p);
    L243:
        r144.c.putExtra("show_usage_count", r150);
        AuthorInfo r151 = r7.g;
        if (r151 == null) goto L246;
        String r152 = r151.b;
    L247:
        r144.c.putExtra(r210, !Intrinsics.areEqual(r152, r110.getUserId()));
        zp9.e r153 = this.y;
        if (r153 == null) goto L254;
        zp9.m r154 = r153.b;
        if (r154 == null) goto L254;
        if (r154.e() == true) goto L254;
        boolean r155 = true;
    L255:
        r144.c.putExtra("ignore_tpl_info", r155);
        zp9.f r156 = this.x;
        if (r156 == null) goto L258;
        Boolean r157 = Boolean.valueOf(r156.r);
    L259:
        r144.c.putExtra("open_new_chat_page_on_send", r157);
        zp9.f r158 = this.x;
        if (r158 == null) goto L262;
        Integer r159 = r158.y;
    L263:
        r144.c.putExtra("creation_dosame_landing_type", r159);
        zp9.f r160 = this.x;
        if (r160 == null) goto L266;
        Boolean r161 = r160.z;
    L267:
        r144.c.putExtra("is_send_from_detail", r161);
        r144.e(123);
        return;
    L266:
        r161 = null;
        goto L267
    L262:
        r159 = null;
        goto L263
    L258:
        r157 = null;
    L254:
        r155 = false;
        goto L255
    L246:
        r152 = null;
        goto L247
    L242:
        r150 = null;
        goto L243
    L236:
        if (B3() != 4) goto L238;
        r148 = true;
        goto L239
    L232:
        r147 = null;
        goto L233
    L228:
        r142 = null;
    L82:
        r35 = false;
        goto L83
    L81:
        r210 = "can_show_inspiration_list";
        r34 = "track_params";
    L75:
        r33 = null;
    L69:
        r30 = false;
    L55:
        r23 = false;
        goto L56
    L47:
        r113 = false;
        goto L48
    L41:
        if (B3() != 4) goto L43;
        r111 = true;
        goto L44
    L37:
        r18 = null;
        goto L38
    L33:
        r16 = null;
    L25:
        r9 = false;
    L17:
        r7 = r41;
    L8:
        r4 = false;
        goto L10
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r3v7 java.util.List<? extends com.larus.platform.api.creation.UserCreation>
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    public final void X3(androidx.recyclerview.widget.RecyclerView r23, boolean r24, boolean r25) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r3v7 java.util.List<? extends com.larus.platform.api.creation.UserCreation>
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            Method dump skipped, instruction units count: 481
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.larus.community.impl.component.CreationFeedComponent.X3(androidx.recyclerview.widget.RecyclerView, boolean, boolean):void");
    }

    public final void L90(boolean r15, boolean r16, Long r17, boolean r18, boolean r110) {
        if (r18 == false) goto L7;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationFeedComponent$handleDataCheckAndRefresh$1(this, r110, r17, null), 3, null);
        return;
    L7:
        if (r15 == false) goto L10;
        if (r16 == false) goto L10;
        return;
    L10:
        if (r15 == false) goto L13;
        C3().refresh("scrollToTopAndRefresh", true);
        return;
    L13:
        RecyclerView r1 = this.n.a();
        if (r1 == null) goto L27;
        SwipeRefreshLayout r6 = this.n.b();
        if (r6 != null) goto L20;
        return;
    L20:
        if (r6.isRefreshing() == false) goto L22;
        return;
    L22:
        if (r6.isEnabled() == false) goto L29;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationFeedComponent$performNormalScrollToTopAndRefresh$1(r1, this, r17, r16, r6, null), 3, null);
        return;
    L29:
        return;
    }
}
