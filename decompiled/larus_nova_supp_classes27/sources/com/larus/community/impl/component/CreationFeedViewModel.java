package com.larus.community.impl.component;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.community.impl.cache.CreationListCacheDataSource;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AiBeautifyUserContent;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.CreationPublishExtra;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.UnwatermarkedVideoInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.api.creation.UserCreationMusic;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import com.larus.platform.api.creation.VideoInfo;
import com.larus.platform.api.creation.VideoUserContent;
import com.larus.platform.service.z2;
import com.larus.profile.api.bean.UserCreationModel;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.RandomKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u008a\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u008a\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010'\u001a\u00020(2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u000e\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020!J\u0006\u0010+\u001a\u00020\u000eJ\u000e\u0010,\u001a\u00020(2\u0006\u0010*\u001a\u00020!J\b\u0010-\u001a\u00020(H\u0002J\u0018\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\f2\b\b\u0002\u00100\u001a\u00020\u000eJ\u000e\u00101\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\fJ$\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e2\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020\u000eJ\u0006\u00106\u001a\u00020(J\u0018\u00107\u001a\u00020\u000e2\b\b\u0002\u00108\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u00109J\u001e\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\nH\u0002J8\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0016\u0010?\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0019\u0018\u00010\u00192\u0006\u0010=\u001a\u00020\n2\b\u0010@\u001a\u0004\u0018\u00010\fH\u0002J\u001a\u0010A\u001a\u00020B2\u0006\u0010=\u001a\u00020\n2\b\u0010@\u001a\u0004\u0018\u00010\fH\u0002J\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J$\u0010E\u001a\u00020\u000e2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J$\u0010H\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020\u000e2\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020\u000eH\u0002J\u0010\u0010J\u001a\u0004\u0018\u00010<*\u0004\u0018\u00010<H\u0002J\u0012\u0010K\u001a\u00020(2\b\u0010L\u001a\u0004\u0018\u00010MH\u0002J\b\u0010N\u001a\u00020(H\u0002J\u0006\u0010O\u001a\u00020\u000eJ\u0010\u0010P\u001a\u00020(2\b\b\u0002\u0010Q\u001a\u00020\u000eJ0\u0010R\u001a\u00020(2\u0006\u0010=\u001a\u00020\n2\u0006\u0010;\u001a\u00020<2\u0006\u0010S\u001a\u00020\u000e2\b\b\u0002\u0010T\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010UJ \u0010V\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\n2\u0006\u0010;\u001a\u00020<2\u0006\u0010S\u001a\u00020\u000eH\u0002J4\u0010W\u001a\u00020(2\u0006\u0010=\u001a\u00020\n2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020!0\u00192\u0006\u0010S\u001a\u00020\u000eH\u0002J\u0018\u0010Z\u001a\u00020(2\u0006\u0010[\u001a\u00020!2\u0006\u0010\\\u001a\u00020\u0002H\u0002J.\u0010]\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010=\u001a\u00020\n2\u0006\u0010;\u001a\u00020<2\u0006\u0010S\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020\u0002H\u0002J\u0012\u0010^\u001a\b\u0012\u0004\u0012\u00020!0\u0019*\u00020<H\u0002J6\u0010_\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\n2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010S\u001a\u00020\u000e2\u0006\u0010T\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020\u0002H\u0002J8\u0010a\u001a\u00020(2\u0006\u0010=\u001a\u00020\n2\u0006\u0010;\u001a\u00020<2\u0006\u0010S\u001a\u00020\u000e2\b\b\u0002\u0010T\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020\u0002H\u0082@¢\u0006\u0002\u0010bJ@\u0010c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020!0\u00192\u0006\u0010=\u001a\u00020\n2\u0006\u0010S\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010dJ\u001c\u0010e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0016\u0010f\u001a\u00020\u000e2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u001c\u0010g\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0016\u0010h\u001a\u00020\u000e2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0012\u0010i\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\b\u0010j\u001a\u00020\u000eH\u0002J\u0018\u0010k\u001a\u00020\f2\u0006\u0010=\u001a\u00020\n2\u0006\u0010S\u001a\u00020\u000eH\u0002J\u0010\u0010l\u001a\u00020!2\u0006\u0010m\u001a\u00020!H\u0002J\f\u0010n\u001a\u00020\u000e*\u00020!H\u0002J0\u0010o\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\b\u0010@\u001a\u0004\u0018\u00010\f2\u0006\u0010=\u001a\u00020\n2\u000e\u0010p\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0019H\u0002J\f\u0010q\u001a\u00020\u000e*\u00020<H\u0002J*\u0010r\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019*\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010=\u001a\u00020\n2\b\u0010@\u001a\u0004\u0018\u00010\fH\u0002J\"\u0010s\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019*\b\u0012\u0004\u0012\u00020\u001a0\u00192\b\u0010t\u001a\u0004\u0018\u00010\fH\u0002J\u0014\u0010u\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190vH\u0016J\u0010\u0010w\u001a\u00020(2\u0006\u0010*\u001a\u00020!H\u0016J\u0018\u0010x\u001a\u00020(2\u0006\u0010t\u001a\u00020\f2\u0006\u0010y\u001a\u00020\u000eH\u0016J.\u0010z\u001a\u00020\u000e2\f\u0010{\u001a\b\u0012\u0004\u0012\u00020!0\u00192\f\u0010G\u001a\b\u0012\u0004\u0012\u00020!0\u00192\b\b\u0002\u0010|\u001a\u00020\u000eH\u0002J\"\u0010}\u001a\u00020\u000e2\u0006\u0010~\u001a\u00020!2\u0006\u0010\u007f\u001a\u00020!2\b\b\u0002\u0010|\u001a\u00020\u000eH\u0002J\r\u0010\u0080\u0001\u001a\u00020\f*\u00020!H\u0002J\u0010\u0010\u0081\u0001\u001a\u00020\f*\u0005\u0018\u00010\u0082\u0001H\u0002J\u0010\u0010\u0081\u0001\u001a\u00020\f*\u0005\u0018\u00010\u0083\u0001H\u0002J\u000f\u0010\u0084\u0001\u001a\u00020\f*\u0004\u0018\u00010\fH\u0002J+\u0010\u0085\u0001\u001a\u00020(2\u0007\u0010\u0086\u0001\u001a\u00020\n2\u0007\u0010\u0087\u0001\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020!2\u0006\u0010y\u001a\u00020\u000eH\u0016J\u000f\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u001c0vH\u0016J\t\u0010\u0089\u0001\u001a\u00020(H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010#R\u000e\u0010$\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u008b\u0001"}, d2 = {"Lcom/larus/community/impl/component/CreationFeedViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/community/impl/component/CreationFeedComponentState;", "Lcom/larus/profile/api/model/ICreationFeedDataViewModel;", "<init>", "()V", "eventCount", "", "mRandomSeed", "pageIndex", "", "nextCursor", "", "hasMore", "", "repository", "Lcom/larus/platform/api/creation/ICreationFeedDataRepository;", "loadMoreJob", "Lkotlinx/coroutines/Job;", "refreshJob", "hasRequestOffset", "", "hasInitData", "internalFeedLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/profile/api/bean/UserCreationModel;", "internalMoreState", "Lcom/larus/profile/api/model/MoreState;", "hasInitObserve", "initParams", "Lcom/larus/platform/api/creation/CreationFeedInitParams;", "mockUserCreation", "Lcom/larus/platform/api/creation/UserCreation;", "lastProfileNoWatermarkEnabled", "Ljava/lang/Boolean;", "forceApplyNextRefresh", "profileCachePreparationId", "Ljava/util/concurrent/atomic/AtomicLong;", "initialize", "", "setMockUserCreation", "userCreation", "hasFeedData", "onSetPublicSuccess", "initObserve", "refresh", "sceneTag", "clearMock", "refreshProfileNoWatermarkIfSwitchChanged", "fetchFirstScreenData", "isInit", "isRetry", "isMainBottomEnter", "cancelRefresh", "checkCurrentData", "isHotLaunch", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertResponseToCreationModels", "response", "Lcom/larus/platform/api/creation/CommonCreationFeedData;", "requestIndex", "convertCreationGroupsToModels", "creationGroupList", "logId", "createTrackParams", "Lcom/larus/platform/api/creation/UserCreationTrackParams;", "processAndDeduplicateModels", "models", "hasDataChanged", "currentList", "newList", "requestFirstRecommendList", "isRefresh", "tryInsertReplicaEntrance", "handleFirstScreenCache", "cache", "Lcom/larus/platform/api/creation/CreationFeedCacheEntity;", "loadMoreRecommendList", "preCheckCanLoadMore", "tryLoadMore", "force", "updateDataList", "isAppend", "useCache", "(ILcom/larus/platform/api/creation/CommonCreationFeedData;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDataListFromCache", "prepareAndApplyProfileCache", "modelList", "requestCreations", "insertMockUserCreation", "creation", "currentState", "buildFinalModelList", "creationListForNoWatermark", "applyFinalDataList", "finalDisplayList", "updateDataListByState", "(ILcom/larus/platform/api/creation/CommonCreationFeedData;ZZLcom/larus/community/impl/component/CreationFeedComponentState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareProfileNoWatermarkModelList", "(Ljava/util/List;Ljava/util/List;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectProfileNoWatermarkModelListIfReady", "shouldHoldProfileCacheForNoWatermark", "selectProfileNoWatermarkModelListForFeed", "shouldPrepareProfileNoWatermark", "hasProfileNoWatermarkCreation", "shouldHandleProfileNoWatermarkFeed", "profileNoWatermarkFeedScene", "selectProfileNoWatermarkUserCreationForFeed", "data", "isVideoCreation", "transformToCreationModelList", "creationList", "hasDisplayData", "withMockUserCreation", "withoutCreation", "creationId", "getFeedDataLiveData", "Landroidx/lifecycle/LiveData;", "updateCreationContent", "deleteUserCreation", "modelAllDeleted", "deepEqualsUserCreationList", "oldList", "compareMedia", "deepEqualsUserCreation", "oldItem", "newItem", "mediaContentSignature", "mediaSignature", "Lcom/larus/platform/api/ImageInfo;", "Lcom/larus/platform/api/Image;", "stableMediaUrl", "updateCreationModelPrivacy", "privacy", "splitMode", "getMoreState", "checkLoadMore", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationFeedViewModel extends ComponentViewModel<CreationFeedComponentState> implements gs9.e {
    public static final a Companion = null;
    private static final int START_INDEX = 1;
    private static final String TAG = "CreationFeedViewModel";
    private long eventCount;
    private boolean forceApplyNextRefresh;
    private volatile boolean hasInitData;
    private volatile boolean hasInitObserve;
    private volatile boolean hasMore;
    private Map<Integer, Boolean> hasRequestOffset;
    private zp9.f initParams;
    private final MutableLiveData<List<UserCreationModel>> internalFeedLiveData;
    private final MutableLiveData<gs9.i> internalMoreState;
    private Boolean lastProfileNoWatermarkEnabled;
    private Job loadMoreJob;
    private volatile long mRandomSeed;
    private volatile UserCreation mockUserCreation;
    private volatile String nextCursor;
    private volatile int pageIndex;
    private final AtomicLong profileCachePreparationId;
    private Job refreshJob;
    private zp9.n repository;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.community.impl.component.CreationFeedViewModel$checkCurrentData$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.component.CreationFeedViewModel", f = "CreationFeedViewModel.kt", i = {0}, l = {225}, m = "checkCurrentData", n = {"requestIndex"}, s = {"I$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CreationFeedViewModel this$0;

        public AnonymousClass1(CreationFeedViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.checkCurrentData(false, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.community.impl.component.CreationFeedViewModel$initObserve$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n"}, d2 = {"<anonymous>", "", "creationModelList", "", "Lcom/larus/profile/api/bean/UserCreationModel;", "moreState", "Lcom/larus/profile/api/model/MoreState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.component.CreationFeedViewModel$initObserve$3", f = "CreationFeedViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<List<? extends UserCreationModel>, gs9.i, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ CreationFeedViewModel this$0;

        public AnonymousClass3(CreationFeedViewModel r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(3, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((List) r1, (gs9.i) r2, (Continuation) r3);
        }

        public final Object invoke(List<UserCreationModel> r3, gs9.i r4, Continuation<? super Unit> r5) {
            AnonymousClass3 r0 = new AnonymousClass3(this.this$0, r5);
            r0.L$0 = r3;
            r0.L$1 = r4;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            List r4 = (List) this.L$0;
            gs9.i r0 = (gs9.i) this.L$1;
            CreationFeedViewModel.access$getInternalFeedLiveData$p(this.this$0).setValue(r4);
            CreationFeedViewModel.access$getInternalMoreState$p(this.this$0).setValue(r0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.community.impl.component.CreationFeedViewModel$loadMoreRecommendList$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.component.CreationFeedViewModel$loadMoreRecommendList$2", f = "CreationFeedViewModel.kt", i = {0, 0, 1, 1, 1, 2}, l = {501, 509, 514, 526, 532}, m = "invokeSuspend", n = {"$this$launch", "requestIndex", "$this$launch", "result", "it", "result"}, s = {"L$0", "I$0", "L$0", "L$1", "L$4", "L$0"})
    public static final class C01542 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ CreationFeedViewModel this$0;

        /* JADX INFO: renamed from: com.larus.community.impl.component.CreationFeedViewModel$loadMoreRecommendList$2$5, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.community.impl.component.CreationFeedViewModel$loadMoreRecommendList$2$5", f = "CreationFeedViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
            int label;
            final /* synthetic */ CreationFeedViewModel this$0;

            public AnonymousClass5(CreationFeedViewModel r1, Continuation<? super AnonymousClass5> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass5(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return CreationFeedViewModel.access$getHasRequestOffset$p(this.this$0).remove(Boxing.boxInt(CreationFeedViewModel.access$getPageIndex$p(this.this$0)));
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.larus.community.impl.component.CreationFeedViewModel$loadMoreRecommendList$2$6, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.community.impl.component.CreationFeedViewModel$loadMoreRecommendList$2$6", f = "CreationFeedViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
            int label;
            final /* synthetic */ CreationFeedViewModel this$0;

            public AnonymousClass6(CreationFeedViewModel r1, Continuation<? super AnonymousClass6> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass6(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return CreationFeedViewModel.access$getHasRequestOffset$p(this.this$0).remove(Boxing.boxInt(CreationFeedViewModel.access$getPageIndex$p(this.this$0)));
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C01542(CreationFeedViewModel r1, Continuation<? super C01542> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C01542 r0 = new C01542(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r22) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L23;
            if (r0 == 1) goto L19;
            if (r0 == 2) goto L16;
            if (r0 == 3) goto L13;
            if (r0 == 4) goto L12;
            if (r0 != 5) goto L11;
            ResultKt.throwOnFailure(r22);
        L74:
            CreationFeedViewModel.access$setState(this.this$0, new f1());
        L81:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r22);
            goto L81
        L13:
            CreationFeedViewModel r1 = (CreationFeedViewModel) this.L$2;
            CoroutineScope r2 = (CoroutineScope) this.L$1;
            Pair r3 = (Pair) this.L$0;
            ResultKt.throwOnFailure(r22);     // Catch: CancellationException -> L22 Exception -> L69
            Continuation r14 = null;
        L53:
            if (r3 == null) goto L55;
            Continuation r8 = (dm9.a) r3.getSecond();     // Catch: Exception -> L47 CancellationException -> L82
        L57:
            if ((r8 instanceof dm9.a.a) == false) goto L59;
            Continuation r9 = (dm9.a.a) r8;     // Catch: Exception -> L47 CancellationException -> L82
        L60:
            if (r9 != null) goto L62;
        L64:
            boolean r4 = false;
        L65:
            if (r4 == false) goto L67;
            m29.a.a(CreationFeedViewModel.TAG, new d1());     // Catch: Exception -> L47 CancellationException -> L82
            goto L81
        L67:
            CreationFeedViewModel.access$setState(r1, new e1());     // Catch: Exception -> L47 CancellationException -> L82
            goto L81
        L62:
            if (((dm9.a.a) r9).a != (-1001)) goto L64;
            r4 = true;
            goto L65
        L59:
            r9 = r14;
            goto L60
        L55:
            r8 = r14;
            goto L57
        L16:
            final zp9.c r5 = (zp9.c) this.L$4;
            CreationFeedViewModel r6 = (CreationFeedViewModel) this.L$3;
            zp9.c r7 = (zp9.c) this.L$2;
            Pair r11 = (Pair) this.L$1;
            CoroutineScope r12 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r22);     // Catch: CancellationException -> L22 Exception -> L69
            r14 = null;
        L44:
            CreationFeedViewModel.access$setState(r6, new b1());     // Catch: Exception -> L47 CancellationException -> L82
            m29.a.a(CreationFeedViewModel.TAG, new c1(r5));     // Catch: Exception -> L47 CancellationException -> L82
            if (r7 != null) goto L81;
            r3 = r11;
            CoroutineScope r13 = r12;
        L50:
            r1 = this.this$0;     // Catch: Exception -> L47 CancellationException -> L82
            MainCoroutineDispatcher r15 = Dispatchers.getMain();     // Catch: Exception -> L47 CancellationException -> L82
            CreationFeedViewModel$loadMoreRecommendList$2$3$1 r16 = new CreationFeedViewModel$loadMoreRecommendList$2$3$1(r1, r14);     // Catch: Exception -> L47 CancellationException -> L82
            this.L$0 = r3;     // Catch: Exception -> L47 CancellationException -> L82
            this.L$1 = r13;     // Catch: Exception -> L47 CancellationException -> L82
            this.L$2 = r1;     // Catch: Exception -> L47 CancellationException -> L82
            this.L$3 = r14;     // Catch: Exception -> L47 CancellationException -> L82
            this.L$4 = r14;     // Catch: Exception -> L47 CancellationException -> L82
            this.label = 3;     // Catch: Exception -> L47 CancellationException -> L82
            if (BuildersKt.withContext(r15, r16, this) != r10) goto L53;
            return r10;
        L19:
            int r17 = this.I$0;
            CoroutineScope r18 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r22);     // Catch: CancellationException -> L22 Exception -> L69
            CoroutineScope r20 = r18;
            Object r21 = r22;
        L31:
            CoroutineScope r23 = r20;
            int r24 = r17;
            final Pair r25 = (Pair) r21;     // Catch: CancellationException -> L22 Exception -> L69
        L34:
            m29.a.a(CreationFeedViewModel.TAG, new a1(r25));     // Catch: Exception -> L69 CancellationException -> L75
            if (r25 == null) goto L49;
            zp9.c r26 = (zp9.c) r25.getFirst();     // Catch: Exception -> L69 CancellationException -> L75
            if (r26 == null) goto L49;
            CreationFeedViewModel r27 = this.this$0;     // Catch: Exception -> L69 CancellationException -> L75
            CreationFeedViewModel.access$setPageIndex$p(r27, CreationFeedViewModel.access$getPageIndex$p(r27) + 1);     // Catch: Exception -> L69 CancellationException -> L75
            CreationFeedViewModel.access$setNextCursor$p(r27, r26.e());     // Catch: Exception -> L69 CancellationException -> L75
            this.L$0 = r23;     // Catch: Exception -> L69 CancellationException -> L75
            this.L$1 = r25;     // Catch: Exception -> L69 CancellationException -> L75
            this.L$2 = r26;     // Catch: Exception -> L69 CancellationException -> L75
            this.L$3 = r27;     // Catch: Exception -> L69 CancellationException -> L75
            this.L$4 = r26;     // Catch: Exception -> L69 CancellationException -> L75
            this.label = 2;     // Catch: Exception -> L69 CancellationException -> L75
            CoroutineScope r110 = r23;
            r14 = null;
        L47:
            e = e;
        L71:
            boolean r28 = m29.a.a;
            m29.a.b(CreationFeedViewModel.TAG, "loadMoreRecommendList timeout, " + e);
            MainCoroutineDispatcher r30 = Dispatchers.getMain();
            AnonymousClass6 r31 = new AnonymousClass6(this.this$0, r14);
            this.L$0 = r14;
            this.L$1 = r14;
            this.L$2 = r14;
            this.L$3 = r14;
            this.L$4 = r14;
            this.label = 5;
            if (BuildersKt.withContext(r30, r31, this) != r10) goto L74;
            return r10;
        L41:
            if (CreationFeedViewModel.updateDataList$default(r27, r24, r26, true, false, this, 8, null) != r10) goto L43;
            return r10;
        L43:
            r11 = r25;
            r5 = r26;
            r7 = r5;
            r12 = r110;
            r6 = r27;
        L77:
            m29.a.a(CreationFeedViewModel.TAG, new d1());
            MainCoroutineDispatcher r32 = Dispatchers.getMain();
            AnonymousClass5 r33 = new AnonymousClass5(this.this$0, r14);
            this.L$0 = r14;
            this.L$1 = r14;
            this.L$2 = r14;
            this.L$3 = r14;
            this.L$4 = r14;
            this.label = 4;
            if (BuildersKt.withContext(r32, r33, this) != r10) goto L81;
            return r10;
        L75:
            r14 = null;
        L49:
            r14 = null;
            r3 = r25;
            r13 = r23;
            goto L50
        L23:
            ResultKt.throwOnFailure(r22);
            CoroutineScope r34 = (CoroutineScope) this.L$0;
            int r35 = CreationFeedViewModel.access$getPageIndex$p(this.this$0);
            boolean r36 = m29.a.a;
            m29.a.c(CreationFeedViewModel.TAG, "start loadMoreRecommendList," + CreationFeedViewModel.access$getPageIndex$p(this.this$0));
            zp9.n r37 = CreationFeedViewModel.access$getRepository$p(this.this$0);     // Catch: Exception -> L69 CancellationException -> L75
            if (r37 == null) goto L33;
            int r38 = CreationFeedViewModel.access$getPageIndex$p(this.this$0);     // Catch: CancellationException -> L22 Exception -> L69
            String r40 = CreationFeedViewModel.access$getNextCursor$p(this.this$0);     // Catch: CancellationException -> L22 Exception -> L69
            Long r41 = Boxing.boxLong(CreationFeedViewModel.access$getMRandomSeed$p(this.this$0));     // Catch: CancellationException -> L22 Exception -> L69
            String r42 = DowngradeSource.LOAD_MORE.getValue();     // Catch: CancellationException -> L22 Exception -> L69
            this.L$0 = r34;     // Catch: CancellationException -> L22 Exception -> L69
            this.I$0 = r35;     // Catch: CancellationException -> L22 Exception -> L69
            this.label = 1;     // Catch: CancellationException -> L22 Exception -> L69
            r21 = r37.a(r38, r40, r41, r42, this);     // Catch: CancellationException -> L22 Exception -> L69
            if (r21 != r10) goto L29;
            return r10;
        L29:
            r20 = r34;
            r17 = r35;
            goto L31
        L33:
            r23 = r34;
            r25 = null;
            r24 = r35;
        L69:
            e = e;
            r14 = null;
            goto L71
        L32:
            r14 = null;
            goto L77
        }
    }

    /* JADX INFO: renamed from: com.larus.community.impl.component.CreationFeedViewModel$prepareAndApplyProfileCache$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.component.CreationFeedViewModel$prepareAndApplyProfileCache$1", f = "CreationFeedViewModel.kt", i = {}, l = {633}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isAppend;
        final /* synthetic */ List<UserCreationModel> $modelList;
        final /* synthetic */ long $preparationId;
        final /* synthetic */ List<UserCreation> $requestCreations;
        final /* synthetic */ int $requestIndex;
        int label;
        final /* synthetic */ CreationFeedViewModel this$0;

        public C01551(CreationFeedViewModel r1, List<UserCreationModel> r2, List<UserCreation> r3, int r4, boolean r5, long r6, Continuation<? super C01551> r8) {
            this.this$0 = r1;
            this.$modelList = r2;
            this.$requestCreations = r3;
            this.$requestIndex = r4;
            this.$isAppend = r5;
            this.$preparationId = r6;
            super(2, r8);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new C01551(this.this$0, this.$modelList, this.$requestCreations, this.$requestIndex, this.$isAppend, this.$preparationId, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L11:
            final List r9 = (List) r8;
            if (CreationFeedViewModel.access$getProfileCachePreparationId$p(this.this$0).get() == this.$preparationId) goto L15;
            m29.a.c(CreationFeedViewModel.TAG, "skip stale profile cache preparation");
            return Unit.INSTANCE;
        L15:
            CreationFeedViewModel r2 = this.this$0;
            CreationFeedViewModel.access$applyFinalDataList(r2, this.$requestIndex, r9, this.$isAppend, true, (CreationFeedComponentState) r2.getState());
            CreationFeedViewModel.access$setState(this.this$0, new g1(r9));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            CreationFeedViewModel r3 = this.this$0;
            List<UserCreationModel> r10 = this.$modelList;
            List<UserCreation> r4 = this.$requestCreations;
            int r5 = this.$requestIndex;
            boolean r6 = this.$isAppend;
            this.label = 1;
            r8 = CreationFeedViewModel.access$prepareProfileNoWatermarkModelList(r3, r10, r4, r5, r6, this);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.community.impl.component.CreationFeedViewModel$prepareProfileNoWatermarkModelList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.component.CreationFeedViewModel", f = "CreationFeedViewModel.kt", i = {0, 0, 0, 0, 1}, l = {823, 838}, m = "prepareProfileNoWatermarkModelList", n = {"modelList", "requestCreations", "requestIndex", "isAppend", "modelList"}, s = {"L$0", "L$1", "I$0", "Z$0", "L$0"})
    public static final class C01561 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CreationFeedViewModel this$0;

        public C01561(CreationFeedViewModel r1, Continuation<? super C01561> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return CreationFeedViewModel.access$prepareProfileNoWatermarkModelList(this.this$0, null, null, 0, false, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.community.impl.component.CreationFeedViewModel$requestFirstRecommendList$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.component.CreationFeedViewModel$requestFirstRecommendList$3", f = "CreationFeedViewModel.kt", i = {0, 0, 0, 0, 1, 1, 1, 2}, l = {353, 374, 409, 418}, m = "invokeSuspend", n = {"$this$launch", "resultData", "requestIndex", "requestRandomSeed", "$this$launch", "it", "requestRandomSeed", "$this$launch"}, s = {"L$0", "L$1", "I$0", "J$0", "L$0", "L$3", "J$0", "L$0"})
    public static final class C01573 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isMainBottomEnter;
        final /* synthetic */ boolean $isRefresh;
        final /* synthetic */ boolean $isRetry;
        int I$0;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        final /* synthetic */ CreationFeedViewModel this$0;

        public C01573(CreationFeedViewModel r1, boolean r2, boolean r3, boolean r4, Continuation<? super C01573> r5) {
            this.this$0 = r1;
            this.$isMainBottomEnter = r2;
            this.$isRefresh = r3;
            this.$isRetry = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            C01573 r6 = new C01573(this.this$0, this.$isMainBottomEnter, this.$isRefresh, this.$isRetry, r9);
            r6.L$0 = r8;
            return r6;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r24) {
            Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L14;
            if (r0 == 1) goto L13;
            if (r0 == 2) goto L12;
            if (r0 == 3) goto L11;
            if (r0 != 4) goto L10;
            CoroutineScope r1 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r24);
        L82:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            zp9.c r2 = (zp9.c) this.L$1;
            CoroutineScope r3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r24);
        L70:
            zp9.c r5 = r2;
        L71:
            if (r5 != null) goto L82;
            CoroutineScope r6 = r3;
        L74:
            boolean r4 = this.$isRefresh;
            CreationFeedViewModel r8 = this.this$0;
            if (r4 == false) goto L77;
            CreationFeedViewModel.access$setState(r8, new n1());
        L78:
            MainCoroutineDispatcher r9 = Dispatchers.getMain();
            CreationFeedViewModel$requestFirstRecommendList$3$3$3 r10 = new CreationFeedViewModel$requestFirstRecommendList$3$3$3(r8, null);
            this.L$0 = r6;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 4;
            if (BuildersKt.withContext(r9, r10, this) != r7) goto L82;
            return r7;
        L77:
            CreationFeedViewModel.access$setState(r8, new o1());
            goto L78
        L12:
            boolean r11 = this.Z$0;
            long r12 = this.J$0;
            final zp9.c r13 = (zp9.c) this.L$3;
            CreationFeedViewModel r14 = (CreationFeedViewModel) this.L$2;
            r5 = (zp9.c) this.L$1;
            CoroutineScope r15 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r24);
            long r16 = r12;
            r3 = r15;
        L53:
            if (r11 == false) goto L59;
            if (CreationFeedViewModel.access$hasDisplayData(r14, r13) == true) goto L57;
            CreationFeedViewModel.access$setState(r14, new i1());
        L62:
            m29.a.a(CreationFeedViewModel.TAG, new m1(r13));
            zp9.f r17 = CreationFeedViewModel.access$getInitParams$p(r14);
            if (r17 == null) goto L71;
            String r18 = r17.q;
            if (r18 == null) goto L71;
            CreationFeedCacheEntity r20 = new CreationFeedCacheEntity(r18, r13, Boxing.boxLong(r16), Boxing.boxLong(System.currentTimeMillis()));
            CreationListCacheDataSource r21 = CreationListCacheDataSource.a;
            this.L$0 = r3;
            this.L$1 = r5;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 3;
            if (r21.e(r18, r20, this) != r7) goto L69;
            return r7;
        L69:
            r2 = r5;
            goto L70
        L57:
            CreationFeedViewModel.access$setState(r14, new j1());
            goto L62
        L59:
            if (CreationFeedViewModel.access$hasDisplayData(r14, r13) == true) goto L61;
            CreationFeedViewModel.access$setState(r14, new k1());
            goto L62
        L61:
            CreationFeedViewModel.access$setState(r14, new l1());
            goto L62
        L13:
            long r22 = this.J$0;
            int r23 = this.I$0;
            Ref.ObjectRef r25 = (Ref.ObjectRef) this.L$2;
            final Ref.ObjectRef r26 = (Ref.ObjectRef) this.L$1;
            r6 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r24);
            long r110 = r22;
            Object r27 = r24;
        L31:
            Pair r28 = (Pair) r27;
            if (r28 == null) goto L34;
            zp9.c r30 = (zp9.c) r28.getFirst();
            int r31 = r23;
            r16 = r110;
        L37:
            r25.element = r30;
            zp9.f r32 = CreationFeedViewModel.access$getInitParams$p(this.this$0);
            if (r32 == null) goto L40;
            boolean r33 = Intrinsics.areEqual(r32.x, Boxing.boxBoolean(true));
        L41:
            if (r33 == false) goto L47;
            zp9.c r34 = (zp9.c) r26.element;
            if (r34 == null) goto L45;
            zp9.c r35 = CreationFeedViewModel.access$tryInsertReplicaEntrance(this.this$0, r34);
        L46:
            r26.element = r35;
            goto L47
        L45:
            r35 = null;
        L47:
            m29.a.a(CreationFeedViewModel.TAG, new h1(r26));
            zp9.c r36 = (zp9.c) r26.element;
            if (r36 == null) goto L74;
            CreationFeedViewModel r37 = this.this$0;
            boolean r38 = this.$isRefresh;
            CreationFeedViewModel.access$setPageIndex$p(r37, CreationFeedViewModel.access$getPageIndex$p(r37) + 1);
            CreationFeedViewModel.access$setMRandomSeed$p(r37, r16);
            CreationFeedViewModel.access$setNextCursor$p(r37, r36.e());
            this.L$0 = r6;
            this.L$1 = r36;
            this.L$2 = r37;
            this.L$3 = r36;
            this.J$0 = r16;
            this.Z$0 = r38;
            this.label = 2;
            CoroutineScope r111 = r6;
            if (CreationFeedViewModel.access$updateDataList(r37, r31, r36, false, false, this) != r7) goto L52;
            return r7;
        L52:
            r11 = r38;
            r13 = r36;
            r5 = r13;
            r3 = r111;
            r14 = r37;
            goto L53
        L40:
            r33 = false;
            goto L41
        L34:
            int r112 = r23;
            Ref.ObjectRef r113 = r25;
            Ref.ObjectRef r40 = r26;
            CoroutineScope r114 = r6;
            long r41 = r110;
        L36:
            r30 = null;
            r31 = r112;
            long r210 = r41;
            r26 = r40;
            r6 = r114;
            r25 = r113;
            r16 = r210;
            goto L37
        L14:
            ResultKt.throwOnFailure(r24);
            r114 = (CoroutineScope) this.L$0;
            r112 = CreationFeedViewModel.access$getPageIndex$p(this.this$0);
            boolean r42 = m29.a.a;
            m29.a.c(CreationFeedViewModel.TAG, "start requestFirstRecommendList:" + r112);
            r41 = RandomKt.Random(System.currentTimeMillis()).nextLong();
            r40 = new Ref.ObjectRef();
            zp9.n r43 = CreationFeedViewModel.access$getRepository$p(this.this$0);
            if (r43 == null) goto L35;
            String r44 = CreationFeedViewModel.access$getNextCursor$p(this.this$0);
            Long r115 = Boxing.boxLong(r41);
            if (this.$isMainBottomEnter == false) goto L21;
            String r45 = DowngradeSource.ENTER_CONVERSATION_LIST.getValue();
        L19:
            String r116 = r45;
            this.L$0 = r114;
            this.L$1 = r40;
            this.L$2 = r40;
            this.I$0 = r112;
            this.J$0 = r41;
            this.label = 1;
            r110 = r41;
            r27 = r43.a(r112, r44, r115, r116, this);
            if (r27 != r7) goto L30;
            return r7;
        L30:
            r6 = r114;
            r23 = r112;
            r25 = r40;
            r26 = r25;
            goto L31
        L21:
            if (this.$isRefresh == false) goto L24;
            r45 = DowngradeSource.REFRESH.getValue();
            goto L19
        L24:
            if (this.$isRetry == false) goto L26;
            r45 = DowngradeSource.RETRY.getValue();
            goto L19
        L26:
            r45 = DowngradeSource.ENTER_PAGE.getValue();
            goto L19
        L35:
            r113 = r40;
            goto L36
        }
    }

    /* JADX INFO: renamed from: com.larus.community.impl.component.CreationFeedViewModel$updateDataListByState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.component.CreationFeedViewModel", f = "CreationFeedViewModel.kt", i = {0, 0, 0, 0}, l = {799}, m = "updateDataListByState", n = {"currentState", "requestIndex", "isAppend", "useCache"}, s = {"L$0", "I$0", "Z$0", "Z$1"})
    public static final class C01581 extends ContinuationImpl {
        int I$0;
        Object L$0;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CreationFeedViewModel this$0;

        public C01581(CreationFeedViewModel r1, Continuation<? super C01581> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r8) {
            this.result = r8;
            this.label |= Integer.MIN_VALUE;
            return CreationFeedViewModel.access$updateDataListByState(this.this$0, 0, null, false, false, null, this);
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit No(CreationFeedViewModel r0, UserCreation r1, CreationFeedComponentState r2) {
        return updateCreationContent$lambda$65(r0, r1, r2);
    }

    public static /* synthetic */ Pair Oo(CreationFeedViewModel r0) {
        return preCheckCanLoadMore$lambda$26(r0);
    }

    public static /* synthetic */ CreationFeedComponentState Po(List r0, long r1, CreationFeedComponentState r3) {
        return updateCreationContent$lambda$65$lambda$64(r0, r1, r3);
    }

    public static /* synthetic */ CreationFeedComponentState Qo(int r0, CreationFeedViewModel r1, CreationFeedComponentState r2, List r3, CreationFeedComponentState r4) {
        return applyFinalDataList$lambda$45(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Pair So(CreationFeedViewModel r0) {
        return preCheckCanLoadMore$lambda$25(r0);
    }

    public static /* synthetic */ CreationFeedComponentState To(CreationFeedComponentState r0) {
        return requestFirstRecommendList$lambda$18(r0);
    }

    public static /* synthetic */ CreationFeedComponentState Wo(int r0, CreationFeedViewModel r1, CreationFeedComponentState r2, List r3, CreationFeedComponentState r4) {
        return applyFinalDataList$lambda$44(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ CreationFeedComponentState Yo(List r0, long r1, CreationFeedComponentState r3) {
        return deleteUserCreation$lambda$73$lambda$72(r0, r1, r3);
    }

    public static /* synthetic */ CreationFeedComponentState Zo(CreationFeedComponentState r0) {
        return cancelRefresh$lambda$3(r0);
    }

    public static /* synthetic */ CreationFeedComponentState ap(CreationFeedComponentState r0) {
        return loadMoreRecommendList$lambda$22(r0);
    }

    public static /* synthetic */ Unit bp(UserCreation r0, CreationFeedComponentState r1) {
        return onSetPublicSuccess$lambda$2(r0, r1);
    }

    public static /* synthetic */ CreationFeedComponentState cp(CreationFeedComponentState r0) {
        return handleFirstScreenCache$lambda$20(r0);
    }

    public static /* synthetic */ Unit dp(String r0, CreationFeedViewModel r1, boolean r2, CreationFeedComponentState r3) {
        return deleteUserCreation$lambda$73(r0, r1, r2, r3);
    }

    public static /* synthetic */ Pair ep(CreationFeedViewModel r0) {
        return preCheckCanLoadMore$lambda$23(r0);
    }

    public static /* synthetic */ Pair hp(CreationFeedViewModel r0) {
        return preCheckCanLoadMore$lambda$24(r0);
    }

    public static /* synthetic */ CreationFeedComponentState ip(List r0, CreationFeedComponentState r1) {
        return insertMockUserCreation$lambda$31(r0, r1);
    }

    public static /* synthetic */ CreationFeedComponentState kp(CreationFeedComponentState r0) {
        return handleFirstScreenCache$lambda$21(r0);
    }

    public static /* synthetic */ CreationFeedComponentState lp(CreationFeedComponentState r0) {
        return requestFirstRecommendList$lambda$17(r0);
    }

    private final boolean shouldHandleProfileNoWatermarkFeed() {
        List r0 = CollectionsKt.listOf(new Integer[]{1, 2});
        zp9.f r1 = this.initParams;
        if (r1 == null) goto L5;
        Integer r2 = r1.f;
    L7:
        return CollectionsKt.contains(r0, r2);
    L5:
        r2 = null;
        goto L7
    }

    private final void initObserve() {
        if (this.hasInitObserve == false) goto L5;
        return;
    L5:
        this.hasInitObserve = true;
        ComponentViewModel.onEach$default(this, C01531.INSTANCE, AnonymousClass2.INSTANCE, null, new AnonymousClass3(this, null), 4, null);
        this.internalFeedLiveData.setValue(((CreationFeedComponentState) getState()).getCreationModelList());
        this.internalMoreState.setValue(((CreationFeedComponentState) getState()).getMoreState());
    }

    private final void loadMoreRecommendList() {
        this.hasRequestOffset.put(Integer.valueOf(this.pageIndex), Boolean.TRUE);
        setState(new j0());
        this.loadMoreJob = BuildersKt.launch$default(getViewModelScope(), Dispatchers.getIO(), null, new C01542(this, null), 2, null);
    }

    public final void cancelRefresh() {
        Job r0 = this.refreshJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        setState(new w0());
    }

    public void checkLoadMore() {
        boolean r0 = m29.a.a;
        m29.a.c(TAG, "internal invoke loadMore:" + this.pageIndex);
        tryLoadMore$default(this, false, 1, null);
    }

    public final boolean preCheckCanLoadMore() {
        boolean r0 = m29.a.a;
        Function0[] r1 = {new m0(this), new n0(this), new o0(this), new p0(this)};
        Intrinsics.checkNotNullParameter(TAG, "tag");
        Intrinsics.checkNotNullParameter(r1, "msg");
        if (m29.a.a == false) goto L15;
        int r2 = 0;
    L6:
        if (r2 >= 4) goto L15;
        Function0 r6 = r1[r2];     // Catch: Exception -> L12
        Pair r7 = (Pair) r6.invoke();     // Catch: Exception -> L12
        if (((Boolean) ((Pair) r6.invoke()).getFirst()).booleanValue() == false) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        FLogger.a.d("community_log_" + TAG, (String) r7.getSecond());     // Catch: Exception -> L12
    L12:
        e = move-exception;
        com.larus.platform.service.g.a.ensureNotReachHere(e);
    L15:
        if (this.hasMore == true) goto L17;
        return false;
    L17:
        if (this.hasRequestOffset.containsKey(Integer.valueOf(this.pageIndex)) == false) goto L19;
        return false;
    L19:
        if ((((CreationFeedComponentState) getState()).getRefreshState() instanceof r29.l.b) == false) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(((CreationFeedComponentState) getState()).getMoreState(), gs9.i.b.a) == true) goto L31;
        return true;
    L31:
        return false;
    }

    public CreationFeedViewModel() {
        this.mRandomSeed = RandomKt.Random(System.currentTimeMillis()).nextLong();
        this.pageIndex = 1;
        this.hasRequestOffset = new LinkedHashMap();
        this.internalFeedLiveData = new MutableLiveData();
        this.internalMoreState = new MutableLiveData();
        this.profileCachePreparationId = new AtomicLong(0);
    }

    public LiveData<List<UserCreationModel>> getFeedDataLiveData() {
        initObserve();
        return this.internalFeedLiveData;
    }

    public LiveData<gs9.i> getMoreState() {
        initObserve();
        return this.internalMoreState;
    }

    public final boolean hasFeedData() {
        return !((CreationFeedComponentState) getState()).getCreationModelList().isEmpty();
    }

    public static final /* synthetic */ Map access$getHasRequestOffset$p(CreationFeedViewModel r0) {
        return r0.hasRequestOffset;
    }

    public static final /* synthetic */ zp9.f access$getInitParams$p(CreationFeedViewModel r0) {
        return r0.initParams;
    }

    public static final /* synthetic */ MutableLiveData access$getInternalFeedLiveData$p(CreationFeedViewModel r0) {
        return r0.internalFeedLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$getInternalMoreState$p(CreationFeedViewModel r0) {
        return r0.internalMoreState;
    }

    public static final /* synthetic */ long access$getMRandomSeed$p(CreationFeedViewModel r2) {
        return r2.mRandomSeed;
    }

    public static final /* synthetic */ String access$getNextCursor$p(CreationFeedViewModel r0) {
        return r0.nextCursor;
    }

    public static final /* synthetic */ int access$getPageIndex$p(CreationFeedViewModel r0) {
        return r0.pageIndex;
    }

    public static final /* synthetic */ AtomicLong access$getProfileCachePreparationId$p(CreationFeedViewModel r0) {
        return r0.profileCachePreparationId;
    }

    public static final /* synthetic */ zp9.n access$getRepository$p(CreationFeedViewModel r0) {
        return r0.repository;
    }

    private static final CreationFeedComponentState cancelRefresh$lambda$3(CreationFeedComponentState r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$setState");
        return CreationFeedComponentState.copy$default(r10, null, null, r29.l.c.a, null, null, null, 59, null);
    }

    private final List<UserCreation> creationListForNoWatermark(zp9.c r3) {
        List<UserCreation> r0 = r3.c();
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        List<UserCreation> r1 = r0;
        if (r1.isEmpty() == false) goto L12;
        List r4 = r3.b();
        if (r4 != null) goto L10;
        r4 = CollectionsKt.emptyList();
    L10:
        r1 = CollectionsKt.flatten(r4);
    L12:
        return r1;
    }

    private final void handleFirstScreenCache(CreationFeedCacheEntity r5) {
        if (r5 == null) goto L18;
        zp9.c r0 = r5.getListData();
        if (r0 == null) goto L20;
        int r1 = this.pageIndex;
        this.pageIndex++;
        Long r6 = r5.getRandomSeed();
        if (r6 == null) goto L9;
        long r2 = r6.longValue();
    L10:
        this.mRandomSeed = r2;
        this.nextCursor = r0.e();
        if (updateDataListFromCache(r1, r0, false) == true) goto L14;
        return;
    L14:
        if (hasDisplayData(r0) == true) goto L16;
        setStateImmediate(new k0());
        return;
    L16:
        setStateImmediate(new l0());
        return;
    L9:
        r2 = 0;
        goto L10
    L20:
        return;
    }

    private static final CreationFeedComponentState handleFirstScreenCache$lambda$20(CreationFeedComponentState r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$setStateImmediate");
        r29.l.c r4 = r29.l.c.a;
        return CreationFeedComponentState.copy$default(r10, null, r29.k.a.a, r4, null, null, null, 57, null);
    }

    private static final CreationFeedComponentState handleFirstScreenCache$lambda$21(CreationFeedComponentState r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$setStateImmediate");
        r29.l.c r4 = r29.l.c.a;
        return CreationFeedComponentState.copy$default(r10, null, r29.k.e.a, r4, null, null, null, 57, null);
    }

    private final boolean hasDisplayData(zp9.c r4) {
        List r0 = r4.c();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L20;
        List r5 = r4.b();
        if (r5 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == false) goto L20;
        if (this.mockUserCreation != null) goto L20;
        return false;
    L13:
        if (r5.isEmpty() == true) goto L16;
        r6 = false;
    L20:
        return true;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    private final boolean hasProfileNoWatermarkCreation(List<UserCreationModel> r5) {
        List<UserCreationModel> r6 = r5;
        if ((r6 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L41;
        List r0 = ((UserCreationModel) r7.next()).b();
        if (r0 != null) goto L13;
        r0 = CollectionsKt.emptyList();
    L13:
        List r1 = r0;
        if ((r1 instanceof Collection) == true) goto L16;
    L18:
        Iterator r2 = r1.iterator();
    L20:
        if (r2.hasNext() == false) goto L17;
        if (((UserCreation) r2.next()).b == 1) goto L24;
        boolean r3 = true;
    L25:
        if (r3 == false) goto L20;
        boolean r4 = true;
    L27:
        if (r4 == false) goto L9;
        return true;
    L24:
        r3 = false;
    L17:
        r4 = false;
        goto L27
    L16:
        if (r1.isEmpty() == false) goto L18;
    L41:
        return false;
    L5:
        if (r6.isEmpty() == false) goto L7;
        return false;
    }

    private final boolean isVideoCreation(UserCreation r6) {
        return CollectionsKt.listOf(new Integer[]{6, 7, 8, 9, 10, 11, 12}).contains(Integer.valueOf(r6.b));
    }

    private static final CreationFeedComponentState loadMoreRecommendList$lambda$22(CreationFeedComponentState r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$setState");
        return CreationFeedComponentState.copy$default(r10, null, null, null, gs9.i.c.a, null, null, 55, null);
    }

    private final String mediaContentSignature(UserCreation r10) {
        UserCreationContent r0 = r10.e;
        String r1 = null;
        if (r0 == null) goto L5;
        VideoUserContent r2 = r0.e;
    L6:
        int r11 = r10.b;
        if (r11 == 2) goto L21;
        if (r11 == 3) goto L17;
        if (r11 == 4) goto L13;
        if (r11 == 5) goto L21;
        if (r2 == null) goto L25;
        ImageInfo r12 = r2.b;
    L26:
        String[] r3 = new String[5];
        r3[0] = mediaSignature(r12);
        if (r2 == null) goto L31;
        VideoInfo r13 = r2.a;
        if (r13 == null) goto L31;
        String r14 = r13.a;
    L32:
        String r4 = "";
        if (r14 != null) goto L35;
        r14 = "";
    L35:
        r3[1] = r14;
        if (r2 == null) goto L40;
        VideoInfo r15 = r2.a;
        if (r15 == null) goto L40;
        String r16 = r15.b;
    L41:
        r3[2] = stableMediaUrl(r16);
        if (r2 == null) goto L48;
        UnwatermarkedVideoInfo r17 = r2.f;
        if (r17 == null) goto L48;
        VideoInfo r18 = r17.a;
        if (r18 == null) goto L48;
        String r110 = r18.a;
    L49:
        if (r110 == null) goto L52;
        r4 = r110;
    L52:
        r3[3] = r4;
        if (r2 == null) goto L57;
        UnwatermarkedVideoInfo r111 = r2.f;
        if (r111 == null) goto L57;
        r1 = r111.b;
    L57:
        r3[4] = stableMediaUrl(r1);
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(r3), "|", null, null, 0, null, null, 62, null);
    L48:
        r110 = null;
    L40:
        r16 = null;
    L31:
        r14 = null;
    L25:
        r12 = null;
        goto L26
    L13:
        if (r0 == null) goto L25;
        AiBeautifyUserContent r112 = r0.d;
        if (r112 == null) goto L25;
        r12 = r112.a;
        goto L26
    L17:
        if (r0 == null) goto L25;
        UserCreationUserAvatar r113 = r0.c;
        if (r113 == null) goto L25;
        r12 = r113.a;
    L21:
        if (r0 == null) goto L25;
        UserCreationImage r114 = r0.a;
        if (r114 == null) goto L25;
        r12 = r114.a;
        goto L26
    L5:
        r2 = null;
        goto L6
    }

    private final String mediaSignature(ImageInfo r10) {
        if (r10 != null) goto L6;
        return "";
    L6:
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{mediaSignature(r10.a), mediaSignature(r10.c), mediaSignature(r10.b), mediaSignature(r10.i), mediaSignature(r10.j)}), "#", null, null, 0, null, null, 62, null);
    }

    private static final Pair preCheckCanLoadMore$lambda$23(CreationFeedViewModel r1) {
        return TuplesKt.to(Boolean.valueOf(r1.hasMore), "preCheckCanLoadMore, hasMore is false");
    }

    private static final Pair preCheckCanLoadMore$lambda$24(CreationFeedViewModel r3) {
        return TuplesKt.to(Boolean.valueOf(!r3.hasRequestOffset.containsKey(Integer.valueOf(r3.pageIndex))), "preCheckCanLoadMore, hasRequestOffset pageIndex:" + r3.pageIndex + ' ');
    }

    private static final Pair preCheckCanLoadMore$lambda$25(CreationFeedViewModel r3) {
        TuplesKt.to(Boolean.valueOf(!(((CreationFeedComponentState) r3.getState()).getRefreshState() instanceof r29.l.b)), "preCheckCanLoadMore, refreshState:" + ((CreationFeedComponentState) r3.getState()).getRefreshState());
        return TuplesKt.to(Boolean.valueOf(Intrinsics.areEqual(((CreationFeedComponentState) r3.getState()).getMoreState(), gs9.i.b.a) ^ true), "preCheckCanLoadMore, moreState:" + ((CreationFeedComponentState) r3.getState()).getMoreState());
    }

    private static final Pair preCheckCanLoadMore$lambda$26(CreationFeedViewModel r3) {
        TuplesKt.to(Boolean.valueOf(!(((CreationFeedComponentState) r3.getState()).getRefreshState() instanceof r29.l.b)), "preCheckCanLoadMore, refreshState:" + ((CreationFeedComponentState) r3.getState()).getRefreshState());
        return TuplesKt.to(Boolean.valueOf(Intrinsics.areEqual(((CreationFeedComponentState) r3.getState()).getMoreState(), gs9.i.b.a) ^ true), "preCheckCanLoadMore, moreState:" + ((CreationFeedComponentState) r3.getState()).getMoreState());
    }

    private final List<UserCreationModel> processAndDeduplicateModels(List<UserCreationModel> r8) {
        HashSet r0 = new HashSet();
        ArrayList r1 = new ArrayList();
        Iterator<T> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L8;
        Object r2 = r9.next();
        if (r0.add(((UserCreationModel) r2).d()) == false) goto L4;
        r1.add(r2);
        goto L4
    L8:
        Iterator r10 = r1.iterator();
        int r3 = 0;
    L10:
        if (r10.hasNext() == false) goto L24;
        Object r4 = r10.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        List r6 = ((UserCreationModel) r4).b();
        if (r6 == null) goto L23;
        Iterator r7 = r6.iterator();
    L18:
        if (r7.hasNext() == false) goto L23;
        UserCreation r11 = (UserCreation) r7.next();
        UserCreationTrackParams r12 = r11.n;
        if (r12 != null) goto L22;
        r12 = new UserCreationTrackParams(null, null, 127);
    L22:
        r12.c = Integer.valueOf(r5);
        r11.n = r12;
    L23:
        r3 = r5;
        goto L10
    L24:
        return r1;
    }

    private static final CreationFeedComponentState requestFirstRecommendList$lambda$17(CreationFeedComponentState r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$setState");
        return CreationFeedComponentState.copy$default(r10, null, null, r29.l.b.a, null, null, null, 59, null);
    }

    private static final CreationFeedComponentState requestFirstRecommendList$lambda$18(CreationFeedComponentState r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$setState");
        return CreationFeedComponentState.copy$default(r10, null, r29.k.d.a, null, null, null, null, 61, null);
    }

    private final List<UserCreationModel> selectProfileNoWatermarkModelListForFeed(List<UserCreationModel> r7) {
        List<UserCreationModel> r8 = r7;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L13;
        UserCreationModel r2 = (UserCreationModel) r9.next();
        List r3 = r2.b();
        if (r3 != null) goto L8;
        r3 = CollectionsKt.emptyList();
    L8:
        List r4 = r3;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r6 = r4.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        r5.add(selectProfileNoWatermarkUserCreationForFeed((UserCreation) r6.next()));
        goto L10
    L12:
        UserCreationModel r10 = UserCreationModel.a(r2, CollectionsKt.toMutableList(r5));
        fs9.a0.c(r10);
        r0.add(r10);
        goto L4
    L13:
        return r0;
    }

    private final List<UserCreationModel> selectProfileNoWatermarkModelListIfReady(List<UserCreationModel> r3) {
        if (shouldPrepareProfileNoWatermark(r3) == true) goto L5;
        return r3;
    L5:
        boolean r0 = CreationNoWatermarkManager.a.D();
        this.lastProfileNoWatermarkEnabled = Boolean.valueOf(r0);
        if (r0 == true) goto L9;
        return r3;
    L9:
        return selectProfileNoWatermarkModelListForFeed(r3);
    }

    private final UserCreation selectProfileNoWatermarkUserCreationForFeed(UserCreation r12) {
        if (r12.b != 1) goto L5;
        return r12;
    L5:
        CreationNoWatermarkManager r0 = CreationNoWatermarkManager.a;
        UserCreation r1 = r0.f0(r12, false);
        if (r1 != null) goto L8;
        UserCreation r2 = r12;
    L10:
        if (isVideoCreation(r12) == false) goto L12;
        return r2;
    L12:
        if (r0.D() == false) goto L42;
        UserCreationContent r3 = r2.e;
        if (r3 == null) goto L43;
        int r13 = r2.b;
        if (r13 != 2) goto L20;
    L34:
        UserCreationImage r14 = r3.a;
        if (r14 != null) goto L38;
        return r2;
    L38:
        return UserCreation.c(r2, null, UserCreationContent.a(r3, UserCreationImage.a(r14, CreationNoWatermarkManager.d0(r14.a)), null, null, null, 62), null, null, null, null, 131055);
    L20:
        if (r13 != 3) goto L22;
        UserCreationUserAvatar r15 = r3.c;
        if (r15 != null) goto L41;
        return r2;
    L41:
        return UserCreation.c(r2, null, UserCreationContent.a(r3, null, UserCreationUserAvatar.a(r15, CreationNoWatermarkManager.d0(r15.a)), null, null, 59), null, null, null, null, 131055);
    L22:
        if (r13 != 4) goto L24;
        AiBeautifyUserContent r16 = r3.d;
        if (r16 != null) goto L40;
        return r2;
    L40:
        return UserCreation.c(r2, null, UserCreationContent.a(r3, null, null, AiBeautifyUserContent.a(r16, CreationNoWatermarkManager.d0(r16.a)), null, 55), null, null, null, null, 131055);
    L24:
        if (r13 == 5) goto L34;
        return r2;
    L43:
        return r2;
    L42:
        return r2;
    L8:
        r2 = r1;
        goto L10
    }

    private final boolean shouldHoldProfileCacheForNoWatermark(List<UserCreationModel> r6) {
        if (shouldPrepareProfileNoWatermark(r6) == true) goto L5;
        return false;
    L5:
        if (CreationNoWatermarkManager.a.j0() == false) goto L45;
        ArrayList r0 = new ArrayList();
        Iterator<T> r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L14;
        List r2 = ((UserCreationModel) r7.next()).b();
        if (r2 != null) goto L13;
        r2 = CollectionsKt.emptyList();
    L13:
        CollectionsKt.addAll(r0, r2);
        goto L9
    L14:
        ArrayList r8 = new ArrayList();
        Iterator r1 = r0.iterator();
    L15:
        boolean r3 = true;
        if (r1.hasNext() == false) goto L24;
        Object r4 = r1.next();
        if (((UserCreation) r4).b != 1) goto L21;
        r3 = false;
    L21:
        if (r3 == false) goto L15;
        r8.add(r4);
        goto L15
    L24:
        if (r8.isEmpty() == true) goto L46;
        Iterator r9 = r8.iterator();
    L28:
        if (r9.hasNext() == false) goto L47;
        UserCreation r5 = (UserCreation) r9.next();
        CreationNoWatermarkManager.a.getClass();
        if (CreationNoWatermarkManager.l0(r5) == false) goto L28;
        return true;
    L47:
        return false;
    L46:
        return false;
    L45:
        return false;
    }

    private final boolean shouldPrepareProfileNoWatermark(List<UserCreationModel> r2) {
        if (shouldHandleProfileNoWatermarkFeed() == true) goto L5;
        return false;
    L5:
        if (z2.a.creationNoWatermarkConfig().a() == true) goto L8;
        return false;
    L8:
        return hasProfileNoWatermarkCreation(r2);
    }

    private final String stableMediaUrl(String r4) {
        String r0 = null;
        if (r4 == null) goto L5;
        r0 = StringsKt.substringBefore$default(r4, '?', null, 2, null);
    L5:
        if (r0 != null) goto L8;
        return "";
    L8:
        return r0;
    }

    private final zp9.c tryInsertReplicaEntrance(zp9.c r8) {
        UserCreation r6 = new UserCreation(UUID.randomUUID().toString(), 0, 100, null, 131066);
        List r0 = null;
        if (r8 == null) goto L5;
        List r1 = r8.b();
    L6:
        List r2 = r1;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L16;
        if (r8 != null) goto L25;
        return null;
    L25:
        return zp9.c.a(r8, CollectionsKt.mutableListOf(new List[]{CollectionsKt.listOf(r6)}));
    L16:
        if (r8 == null) goto L26;
        List r4 = r8.b();
        if (r4 == null) goto L23;
        List r5 = CollectionsKt.toMutableList(r4);
        if (r5 == null) goto L23;
        ListProtector.add(r5, 0, CollectionsKt.listOf(r6));
        Unit r7 = Unit.INSTANCE;
        r0 = r5;
    L23:
        return zp9.c.a(r8, r0);
    L26:
        return null;
    L9:
        if (r2.isEmpty() == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void onSetPublicSuccess(final UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
        withState(new z0(r2));
    }

    public final boolean refreshProfileNoWatermarkIfSwitchChanged(String r8) {
        Intrinsics.checkNotNullParameter(r8, "sceneTag");
        if (shouldHandleProfileNoWatermarkFeed() == true) goto L5;
    L20:
        return false;
    L5:
        if (z2.a.creationNoWatermarkConfig().a() == false) goto L20;
        if (hasProfileNoWatermarkCreation(((CreationFeedComponentState) getState()).getCreationModelList()) == true) goto L10;
        return false;
    L10:
        boolean r0 = CreationNoWatermarkManager.a.D();
        Boolean r2 = this.lastProfileNoWatermarkEnabled;
        if (r2 != null) goto L15;
        this.lastProfileNoWatermarkEnabled = Boolean.valueOf(r0);
        boolean r3 = m29.a.a;
        m29.a.c(TAG, "record profile no watermark switch on " + r8 + ", enabled:" + r0);
        return false;
    L15:
        if (Intrinsics.areEqual(r2, Boolean.valueOf(r0)) == false) goto L18;
        boolean r9 = m29.a.a;
        m29.a.c(TAG, "skip profile no watermark refresh, switch not changed, enabled:" + r0);
        return false;
    L18:
        this.lastProfileNoWatermarkEnabled = Boolean.valueOf(r0);
        this.forceApplyNextRefresh = true;
        boolean r5 = m29.a.a;
        m29.a.c(TAG, "profile no watermark switch changed on " + r8 + ", previous:" + r2 + ", current:" + r0);
        StringBuilder r1 = new StringBuilder("profile no watermark switch changed:");
        r1.append(r8);
        refresh(r1.toString(), false);
        return true;
    }

    public final void setMockUserCreation(UserCreation r4) {
        Intrinsics.checkNotNullParameter(r4, "userCreation");
        CreationFeedComponentState r0 = (CreationFeedComponentState) getState();
        this.mockUserCreation = r4;
        boolean r1 = m29.a.a;
        m29.a.c(TAG, "setMockUserCreation:" + r4.a + ", currentSize:" + r0.getCreationModelList().size() + ", pageState:" + r0.getPageState());
        insertMockUserCreation(r4, r0);
    }

    public final void tryLoadMore(boolean r5) {
        if (preCheckCanLoadMore() == true) goto L7;
        if (r5 == true) goto L7;
        boolean r0 = m29.a.a;
        m29.a.c(TAG, "tryLoadMore refused, pageIndex:" + this.pageIndex + ", isForce:" + r5);
        return;
    L7:
        boolean r1 = m29.a.a;
        m29.a.c(TAG, "loadMore:" + this.pageIndex + ", isForce:" + r5);
        if (r5 == false) goto L12;
        Job r6 = this.loadMoreJob;
        if (r6 == null) goto L12;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L12:
        loadMoreRecommendList();
    }

    public void updateCreationContent(final UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
        withState(new q0(this, r2));
    }

    private final String mediaSignature(Image r4) {
        String r0 = "";
        if (r4 != null) goto L5;
        return "";
    L5:
        StringBuilder r1 = new StringBuilder();
        String r2 = r4.e;
        if (r2 == null) goto L9;
        r0 = r2;
    L9:
        r1.append(r0);
        r1.append(',');
        r1.append(stableMediaUrl(r4.a));
        r1.append(',');
        r1.append(stableMediaUrl(r4.b));
        return r1.toString();
    }

    public static final /* synthetic */ boolean access$hasDisplayData(CreationFeedViewModel r0, zp9.c r1) {
        return r0.hasDisplayData(r1);
    }

    public static final /* synthetic */ void access$setMRandomSeed$p(CreationFeedViewModel r0, long r1) {
        r0.mRandomSeed = r1;
    }

    public static final /* synthetic */ void access$setNextCursor$p(CreationFeedViewModel r0, String r1) {
        r0.nextCursor = r1;
    }

    public static final /* synthetic */ void access$setPageIndex$p(CreationFeedViewModel r0, int r1) {
        r0.pageIndex = r1;
    }

    public static final /* synthetic */ void access$setState(CreationFeedViewModel r0, Function1 r1) {
        r0.setState(r1);
    }

    public static final /* synthetic */ zp9.c access$tryInsertReplicaEntrance(CreationFeedViewModel r0, zp9.c r1) {
        return r0.tryInsertReplicaEntrance(r1);
    }

    private final List<UserCreationModel> convertResponseToCreationModels(zp9.c r3, int r4) {
        Map r0 = r3.f();
        if (r0 == null) goto L5;
        String r1 = (String) r0.get("request_id");
    L6:
        List r2 = r3.c();
        if (r2 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == true) goto L16;
        return transformToCreationModelList(r1, r4, r3.c());
    L16:
        return convertCreationGroupsToModels(r3.b(), r4, r1);
    L9:
        if (r2.isEmpty() == true) goto L12;
        r5 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    private final UserCreationTrackParams createTrackParams(int r4, String r5) {
        String r2 = null;
        UserCreationTrackParams r0 = new UserCreationTrackParams(null, null, 127);
        r0.a = r5;
        r0.b = Integer.valueOf(r4);
        zp9.f r6 = this.initParams;
        if (r6 == null) goto L7;
        TabItemInfo r7 = r6.j;
        if (r7 == null) goto L7;
        String r8 = r7.getId();
    L8:
        r0.d = r8;
        zp9.f r9 = this.initParams;
        if (r9 == null) goto L13;
        TabItemInfo r10 = r9.j;
        if (r10 == null) goto L13;
        String r11 = r10.b();
    L14:
        r0.e = r11;
        zp9.f r12 = this.initParams;
        r0.f = null;
        if (r12 == null) goto L19;
        zp9.g r13 = r12.e;
        if (r13 == null) goto L19;
        r2 = r13.c;
    L19:
        r0.g = r2;
        return r0;
    L13:
        r11 = null;
    L7:
        r8 = null;
        goto L8
    }

    private final boolean hasDataChanged(List<UserCreationModel> r12, List<UserCreationModel> r13) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L9;
        List r1 = ((UserCreationModel) r14.next()).b();
        if (r1 != null) goto L8;
        r1 = CollectionsKt.emptyList();
    L8:
        CollectionsKt.addAll(r0, r1);
        goto L4
    L9:
        ArrayList r15 = new ArrayList();
        Iterator r2 = r0.iterator();
    L10:
        boolean r3 = false;
        if (r2.hasNext() == false) goto L20;
        Object r4 = r2.next();
        Integer r5 = ((UserCreation) r4).c;
        if (r5 != null) goto L16;
    L18:
        if (r3 == true) goto L10;
        r15.add(r4);
        goto L10
    L16:
        if (r5.intValue() != 100) goto L18;
        r3 = true;
        goto L18
    L20:
        ArrayList r6 = new ArrayList();
        Iterator<T> r16 = r13.iterator();
    L22:
        if (r16.hasNext() == false) goto L27;
        List r7 = ((UserCreationModel) r16.next()).b();
        if (r7 != null) goto L26;
        r7 = CollectionsKt.emptyList();
    L26:
        CollectionsKt.addAll(r6, r7);
        goto L22
    L27:
        ArrayList r8 = new ArrayList();
        Iterator r17 = r6.iterator();
    L29:
        if (r17.hasNext() == false) goto L40;
        Object r9 = r17.next();
        Integer r10 = ((UserCreation) r9).c;
        if (r10 != null) goto L34;
    L36:
        boolean r11 = false;
    L37:
        if (r11 == true) goto L29;
        r8.add(r9);
        goto L29
    L34:
        if (r10.intValue() != 100) goto L36;
        r11 = true;
        goto L37
    L40:
        return !deepEqualsUserCreationList$default(this, CollectionsKt.take(r15, r8.size()), r8, false, 4, null);
    }

    private final void insertMockUserCreation(UserCreation r8, CreationFeedComponentState r9) {
        final ArrayList r0 = new ArrayList();
        r0.addAll(transformToCreationModelList("publish", 1, CollectionsKt.listOf(r8)));
        List<UserCreationModel> r10 = withoutCreation(r9.getCreationModelList(), r8.a);
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L17;
        List r1 = ((UserCreationModel) r11.next()).b();
        if (r1 == null) goto L4;
        Iterator r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L4;
        UserCreation r3 = (UserCreation) r2.next();
        UserCreationTrackParams r4 = r3.n;
        Integer r5 = null;
        if (r4 != null) goto L13;
        r4 = new UserCreationTrackParams(null, null, 127);
    L13:
        Integer r6 = r4.c;
        if (r6 == null) goto L16;
        r5 = Integer.valueOf(r6.intValue() + 1);
    L16:
        r4.c = r5;
        r3.n = r4;
        goto L9
    L17:
        r0.addAll(r10);
        setState(new t0(r0));
    }

    private static final CreationFeedComponentState insertMockUserCreation$lambda$31(List r10, CreationFeedComponentState r11) {
        Intrinsics.checkNotNullParameter(r11, "$this$setState");
        HashSet r0 = new HashSet();
        ArrayList r2 = new ArrayList();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Object r1 = r12.next();
        if (r0.add(((UserCreationModel) r1).d()) == false) goto L4;
        r2.add(r1);
        goto L4
    L9:
        return CreationFeedComponentState.copy$default(r11, r2, r29.k.e.a, r29.l.c.a, null, new p1(1), null, 40, null);
    }

    private static final Unit onSetPublicSuccess$lambda$2(UserCreation r6, CreationFeedComponentState r7) {
        Intrinsics.checkNotNullParameter(r7, "currentState");
        Iterator<T> r8 = r7.getCreationModelList().iterator();
    L4:
        if (r8.hasNext() == false) goto L18;
        List r0 = ((UserCreationModel) r8.next()).b();
        if (r0 == null) goto L4;
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L4;
        UserCreation r2 = (UserCreation) r1.next();
        if (Intrinsics.areEqual(r2.a, r6.a) == false) goto L9;
        boolean r3 = m29.a.a;
        m29.a.c(TAG, "onSetPublicSuccess:" + r2.a);
        CreationPublishExtra r4 = r2.p;
        if (r4 == null) goto L15;
        CreationPublishExtra r5 = new CreationPublishExtra(r4.a, Boolean.TRUE, r4.c);
    L16:
        r2.p = r5;
        goto L9
    L15:
        r5 = new CreationPublishExtra(Boolean.TRUE, 5);
        goto L16
    L18:
        return Unit.INSTANCE;
    }

    private final String profileNoWatermarkFeedScene(int r3, boolean r4) {
        zp9.f r0 = this.initParams;
        if (r0 == null) goto L5;
        Integer r1 = r0.f;
    L6:
        if (r1 != null) goto L9;
    L11:
        String r2 = "profile_public";
    L12:
        if (r4 == false) goto L14;
        String r5 = "load_more";
    L16:
        return r2 + "_feed_" + r5 + '_' + r3;
    L14:
        r5 = "refresh";
        goto L16
    L9:
        if (r1.intValue() != 2) goto L11;
        r2 = "profile_private";
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    private final List<UserCreationModel> withoutCreation(List<UserCreationModel> r10, String r11) {
        if (r11 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return r10;
    L11:
        ArrayList r3 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L13:
        if (r12.hasNext() == false) goto L36;
        UserCreationModel r4 = (UserCreationModel) r12.next();
        List r5 = r4.b();
        UserCreationModel r6 = null;
        if (r5 == null) goto L23;
        ArrayList r7 = new ArrayList();
        Iterator r8 = r5.iterator();
    L18:
        if (r8.hasNext() == false) goto L22;
        Object r9 = r8.next();
        if (Intrinsics.areEqual(((UserCreation) r9).a, r11) == true) goto L18;
        r7.add(r9);
        goto L18
    L22:
        List r13 = CollectionsKt.toMutableList(r7);
    L24:
        List r14 = r13;
        if (r14 != null) goto L27;
    L30:
        boolean r15 = true;
    L31:
        if (r15 == true) goto L34;
        r6 = UserCreationModel.a(r4, r13);
        fs9.a0.c(r6);
    L34:
        if (r6 == null) goto L13;
        r3.add(r6);
        goto L13
    L27:
        if (r14.isEmpty() == true) goto L30;
        r15 = false;
        goto L31
    L23:
        r13 = null;
        goto L24
    L36:
        return r3;
    L5:
        if (r11.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final Object checkCurrentData(boolean r10, Continuation<? super Boolean> r11) {
        if ((r11 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        AnonymousClass1 r6 = r0;
        Object r12 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        int r7 = 1;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = r6.I$0;
        ResultKt.throwOnFailure(r12);
    L23:
        Pair r13 = (Pair) r12;
        if (r13 == null) goto L31;
        zp9.c r14 = (zp9.c) r13.getFirst();
        if (r14 == null) goto L31;
        List<UserCreationModel> r15 = convertResponseToCreationModels(r14, r7);
        boolean r16 = m29.a.a;
        m29.a.c(TAG, "New data size: " + r15.size());
        List<UserCreationModel> r17 = processAndDeduplicateModels(r15);
        m29.a.c(TAG, "Processed data size: " + r17.size());
        boolean r18 = hasDataChanged(((CreationFeedComponentState) getState()).getCreationModelList(), r17);
        m29.a.c(TAG, "Data changed: " + r18);
        return Boxing.boxBoolean(r18);
    L31:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        boolean r110 = m29.a.a;
        m29.a.c(TAG, "Start checking current data, request index: 1, isHotLaunch: " + r10);
        long r4 = RandomKt.Random(System.currentTimeMillis()).nextLong();
        zp9.n r111 = this.repository;
        if (r111 == null) goto L31;
        Long r5 = Boxing.boxLong(r4);
        if (r10 == false) goto L19;
        DowngradeSource r112 = DowngradeSource.HOT_LAUNCH;
    L20:
        String r8 = r112.getValue();
        r6.I$0 = 1;
        r6.label = 1;
        r12 = r111.a(1, null, r5, r8, r6);
        if (r12 != r2) goto L23;
        return r2;
    L19:
        r112 = DowngradeSource.REFRESH;
    L7:
        r0 = new AnonymousClass1(this, r11);
        goto L8
    }

    public void deleteUserCreation(final String r2, final boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "creationId");
        withState(new u0(r2, this, r3));
    }

    public final void initialize(zp9.n r2, zp9.f r3) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        this.repository = r2;
        this.initParams = r3;
    }

    public final void refresh(String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "sceneTag");
        boolean r0 = m29.a.a;
        m29.a.c(TAG, r8 + ",refresh");
        if (r9 == false) goto L5;
        this.mockUserCreation = null;
        m29.a.c(TAG, "clearMock");
    L5:
        requestFirstRecommendList$default(this, true, false, false, 6, null);
    }

    private final List<UserCreationModel> convertCreationGroupsToModels(List<? extends List<UserCreation>> r8, int r9, String r10) {
        if (r8 == null) goto L22;
        List<? extends List<UserCreation>> r11 = r8;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r12 = r11.iterator();
        int r1 = 0;
    L5:
        if (r12.hasNext() == false) goto L27;
        Object r2 = r12.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        List r4 = (List) r2;
        if (r4 == null) goto L16;
        Iterator r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L16;
        UserCreation r6 = (UserCreation) r5.next();
        r6.n = createTrackParams(r9, r10);
    L16:
        if (r4 == null) goto L19;
        List r7 = CollectionsKt.toMutableList(r4);
        if (r7 == null) goto L19;
    L20:
        UserCreationModel r13 = new UserCreationModel(2, r7, null, 4);
        fs9.a0.c(r13);
        r0.add(r13);
        r1 = r3;
    L19:
        r7 = new ArrayList();
        goto L20
    L27:
        return r0;
    L22:
        return CollectionsKt.emptyList();
    }

    private final boolean deepEqualsUserCreation(UserCreation r6, UserCreation r7, boolean r8) {
        if (r7.b != 1) goto L41;
        if (Intrinsics.areEqual(r7.a, r6.a) == true) goto L7;
    L49:
        boolean r0 = false;
    L50:
        if (r0 == false) goto L56;
        if (r8 == true) goto L53;
    L54:
        return true;
    L53:
        if (Intrinsics.areEqual(mediaContentSignature(r6), mediaContentSignature(r7)) == true) goto L54;
        return false;
    L56:
        return false;
    L7:
        if (Intrinsics.areEqual(r7.d, r6.d) == false) goto L49;
        if (Intrinsics.areEqual(r7.c, r6.c) == false) goto L49;
        if (r7.b != r6.b) goto L49;
        UserCreationContent r1 = r7.e;
        String r3 = null;
        if (r1 == null) goto L17;
        UserCreationMusic r2 = r1.b;
        if (r2 == null) goto L17;
        ImageInfo r4 = r2.d;
    L18:
        UserCreationContent r5 = r6.e;
        if (r5 == null) goto L23;
        UserCreationMusic r9 = r5.b;
        if (r9 == null) goto L23;
        ImageInfo r10 = r9.d;
    L25:
        if (Intrinsics.areEqual(r4, r10) == false) goto L49;
        UserCreationContent r11 = r7.e;
        if (r11 == null) goto L31;
        UserCreationMusic r12 = r11.b;
        if (r12 == null) goto L31;
        String r13 = r12.b;
    L32:
        UserCreationContent r14 = r6.e;
        if (r14 == null) goto L38;
        UserCreationMusic r15 = r14.b;
        if (r15 == null) goto L38;
        r3 = r15.b;
    L38:
        if (Intrinsics.areEqual(r13, r3) == false) goto L49;
    L48:
        r0 = true;
    L31:
        r13 = null;
    L23:
        r10 = null;
    L17:
        r4 = null;
        goto L18
    L41:
        if (Intrinsics.areEqual(r7.a, r6.a) == false) goto L49;
        if (Intrinsics.areEqual(r7.d, r6.d) == false) goto L49;
        if (Intrinsics.areEqual(r7.c, r6.c) == false) goto L49;
        if (r7.b != r6.b) goto L49;
        goto L48
    }

    private final boolean deepEqualsUserCreationList(List<UserCreation> r4, List<UserCreation> r5, boolean r6) {
        if (r4.size() == r5.size()) goto L5;
        return false;
    L5:
        List r7 = CollectionsKt.zip(r4, r5);
        if ((r7 instanceof Collection) == true) goto L8;
    L10:
        Iterator r8 = r7.iterator();
    L12:
        if (r8.hasNext() == false) goto L9;
        Pair r9 = (Pair) r8.next();
        if (deepEqualsUserCreation((UserCreation) r9.component1(), (UserCreation) r9.component2(), r6) == true) goto L12;
        return false;
    L9:
        return true;
    L8:
        if (r7.isEmpty() == false) goto L10;
        goto L9
    }

    private static final CreationFeedComponentState deleteUserCreation$lambda$73$lambda$72(List r10, long r11, CreationFeedComponentState r13) {
        Intrinsics.checkNotNullParameter(r13, "$this$setState");
        if (r10.isEmpty() == false) goto L5;
        r29.k r0 = r29.k.a.a;
    L7:
        return CreationFeedComponentState.copy$default(r13, r10, r0, null, null, null, new q1(r11), 28, null);
    L5:
        r0 = r29.k.e.a;
        goto L7
    }

    private final boolean requestFirstRecommendList(boolean r13, boolean r14, boolean r15) {
        this.hasRequestOffset.clear();
        this.pageIndex = 1;
        this.nextCursor = null;
        Job r2 = this.loadMoreJob;
        if (r2 == null) goto L5;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L5:
        this.hasRequestOffset.put(Integer.valueOf(this.pageIndex), Boolean.TRUE);
        if (r13 == true) goto L10;
        zp9.n r3 = this.repository;
        if (r3 == null) goto L10;
        CreationFeedCacheEntity r4 = r3.b();
    L11:
        if (r4 == null) goto L14;
        handleFirstScreenCache(r4);
        return true;
    L14:
        if (r13 == false) goto L17;
        setState(new x0());
    L19:
        Job r5 = this.refreshJob;
        if (r5 == null) goto L22;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L22:
        this.refreshJob = BuildersKt.launch$default(getViewModelScope(), Dispatchers.getIO(), null, new C01573(this, r15, r13, r14, null), 2, null);
        return false;
    L17:
        if (((CreationFeedComponentState) getState()).getCreationModelList().isEmpty() == false) goto L19;
        setState(new y0());
    L10:
        r4 = null;
        goto L11
    }

    private final List<UserCreationModel> transformToCreationModelList(String r9, int r10, List<UserCreation> r11) {
        if (r11 == null) goto L31;
        List r12 = CollectionsKt.filterNotNull(r11);
        if (r12 == null) goto L31;
        List r13 = r12;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r14 = r13.iterator();
        int r2 = 0;
    L7:
        if (r14.hasNext() == false) goto L35;
        Object r3 = r14.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        UserCreation r5 = (UserCreation) r3;
        UserCreationTrackParams r6 = new UserCreationTrackParams(null, null, 127);
        r6.a = r9;
        r6.b = Integer.valueOf(r10);
        zp9.f r7 = this.initParams;
        if (r7 == null) goto L16;
        TabItemInfo r8 = r7.j;
        if (r8 == null) goto L16;
        String r15 = r8.getId();
    L17:
        r6.d = r15;
        zp9.f r16 = this.initParams;
        if (r16 == null) goto L22;
        TabItemInfo r17 = r16.j;
        if (r17 == null) goto L22;
        String r18 = r17.b();
    L23:
        r6.e = r18;
        zp9.f r20 = this.initParams;
        r6.f = null;
        if (r20 == null) goto L28;
        zp9.g r21 = r20.e;
        if (r21 == null) goto L28;
        String r22 = r21.c;
    L29:
        r6.g = r22;
        r5.n = r6;
        UserCreationModel r23 = new UserCreationModel(1, CollectionsKt.arrayListOf(new UserCreation[]{r5}), null, 4);
        fs9.a0.c(r23);
        r0.add(r23);
        r2 = r4;
    L28:
        r22 = null;
    L22:
        r18 = null;
    L16:
        r15 = null;
        goto L17
    L35:
        return r0;
    L31:
        return CollectionsKt.emptyList();
    }

    private static final Unit updateCreationContent$lambda$65(CreationFeedViewModel r7, UserCreation r8, CreationFeedComponentState r9) {
        Intrinsics.checkNotNullParameter(r9, "lastState");
        final ArrayList r0 = new ArrayList();
        Iterator<T> r10 = r9.getCreationModelList().iterator();
    L4:
        if (r10.hasNext() == false) goto L17;
        UserCreationModel r1 = (UserCreationModel) r10.next();
        List r2 = r1.b();
        if (r2 == null) goto L15;
        List r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L14;
        UserCreation r6 = (UserCreation) r5.next();
        if (Intrinsics.areEqual(r6.a, r8.a) == false) goto L13;
        r6 = r8;
    L13:
        r4.add(r6);
        goto L9
    L14:
        List r11 = CollectionsKt.toMutableList(r4);
    L16:
        r1.e(r11);
        r0.add(r1);
        goto L4
    L15:
        r11 = null;
        goto L16
    L17:
        final long r12 = r7.eventCount;
        r7.eventCount = 1 + r12;
        r7.setState(new i0(r0, r12));
        return Unit.INSTANCE;
    }

    private static final CreationFeedComponentState updateCreationContent$lambda$65$lambda$64(List r10, long r11, CreationFeedComponentState r13) {
        Intrinsics.checkNotNullParameter(r13, "$this$setState");
        if (r10.isEmpty() == false) goto L5;
        r29.k r0 = r29.k.a.a;
    L7:
        return CreationFeedComponentState.copy$default(r13, r10, r0, null, null, null, new q1(r11), 28, null);
    L5:
        r0 = r29.k.e.a;
        goto L7
    }

    private final boolean updateDataListFromCache(int r8, zp9.c r9, boolean r10) {
        this.hasMore = r9.d();
        CreationFeedComponentState r6 = (CreationFeedComponentState) getState();
        List<UserCreationModel> r0 = buildFinalModelList(r8, r9, r10, r6);
        if (shouldHoldProfileCacheForNoWatermark(r0) == false) goto L6;
        m29.a.c(TAG, "hold profile cache until no watermark resource is ready");
        prepareAndApplyProfileCache(r8, r0, creationListForNoWatermark(r9), r10);
        return false;
    L6:
        applyFinalDataList(r8, selectProfileNoWatermarkModelListIfReady(r0), r10, true, r6);
        return true;
    }

    private final List<UserCreationModel> withMockUserCreation(List<UserCreationModel> r4, int r5, String r6) {
        UserCreation r0 = this.mockUserCreation;
        if (r0 != null) goto L5;
        return r4;
    L5:
        ArrayList r1 = new ArrayList();
        if (r6 != null) goto L8;
        r6 = "publish";
    L8:
        r1.addAll(transformToCreationModelList(r6, r5, CollectionsKt.listOf(r0)));
        r1.addAll(withoutCreation(r4, r0.a));
        return r1;
    }

    public final boolean fetchFirstScreenData(boolean r3, boolean r4, boolean r5) {
        if (r3 == true) goto L5;
    L13:
        this.hasInitData = true;
        return requestFirstRecommendList(false, r4, r5);
    L5:
        if (this.hasInitData == false) goto L13;
        m29.a.c(TAG, "viewModel has init so return");
        zp9.n r6 = this.repository;
        if (r6 == null) goto L9;
        CreationFeedCacheEntity r7 = r6.b();
    L10:
        if (r7 == null) goto L15;
        return true;
    L15:
        return false;
    L9:
        r7 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.community.impl.component.CreationFeedViewModel] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.ArrayList] */
    private final List<UserCreationModel> buildFinalModelList(int r11, zp9.c r12, boolean r13, CreationFeedComponentState r14) {
        ArrayList r0 = new ArrayList();
        if (r13 == false) goto L5;
        r0.addAll(r14.getCreationModelList());
    L5:
        Map r15 = r12.f();
        if (r15 == null) goto L8;
        String r16 = (String) r15.get("request_id");
    L9:
        List r1 = r12.c();
        int r2 = 0;
        if (r1 != null) goto L12;
    L15:
        boolean r3 = true;
    L17:
        if (r3 == true) goto L19;
        r0.addAll(transformToCreationModelList(r16, r11, r12.c()));
    L59:
        List<UserCreationModel> r17 = withMockUserCreation(r0, r11, r16);
        boolean r18 = m29.a.a;
        m29.a.c(TAG, "origin size: " + r0.size() + ", display size: " + r17.size());
        HashSet r110 = new HashSet();
        ArrayList r111 = new ArrayList();
        Iterator r112 = r17.iterator();
    L61:
        if (r112.hasNext() == false) goto L65;
        Object r4 = r112.next();
        if (r110.add(((UserCreationModel) r4).d()) == false) goto L61;
        r111.add(r4);
        goto L61
    L65:
        Iterator r113 = r111.iterator();
    L67:
        if (r113.hasNext() == false) goto L81;
        Object r114 = r113.next();
        int r5 = r2 + 1;
        if (r2 >= 0) goto L71;
        CollectionsKt.throwIndexOverflow();
    L71:
        List r115 = ((UserCreationModel) r114).b();
        if (r115 == null) goto L80;
        Iterator r116 = r115.iterator();
    L75:
        if (r116.hasNext() == false) goto L80;
        UserCreation r6 = (UserCreation) r116.next();
        UserCreationTrackParams r7 = r6.n;
        if (r7 != null) goto L79;
        r7 = new UserCreationTrackParams(null, null, 127);
    L79:
        r7.c = Integer.valueOf(r5);
        r6.n = r7;
    L80:
        r2 = r5;
        goto L67
    L81:
        return r111;
    L19:
        List r117 = r12.b();
        if (r117 == null) goto L57;
        List r118 = r117;
        ?? r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r118, 10));
        Iterator r119 = r118.iterator();
        int r9 = 0;
    L23:
        if (r119.hasNext() == false) goto L58;
        Object r10 = r119.next();
        int r20 = r9 + 1;
        if (r9 >= 0) goto L27;
        CollectionsKt.throwIndexOverflow();
    L27:
        List r21 = (List) r10;
        if (r21 == null) goto L52;
        Iterator r22 = r21.iterator();
    L31:
        if (r22.hasNext() == false) goto L52;
        UserCreation r23 = (UserCreation) r22.next();
        UserCreationTrackParams r24 = new UserCreationTrackParams(null, null, 127);
        r24.a = r16;
        r24.b = Integer.valueOf(r11);
        zp9.f r25 = this.initParams;
        if (r25 == null) goto L37;
        TabItemInfo r26 = r25.j;
        if (r26 == null) goto L37;
        String r27 = r26.getId();
    L38:
        r24.d = r27;
        zp9.f r28 = this.initParams;
        if (r28 == null) goto L43;
        TabItemInfo r30 = r28.j;
        if (r30 == null) goto L43;
        String r31 = r30.b();
    L44:
        r24.e = r31;
        zp9.f r32 = this.initParams;
        r24.f = null;
        if (r32 == null) goto L49;
        zp9.g r33 = r32.e;
        if (r33 == null) goto L49;
        String r34 = r33.c;
    L50:
        r24.g = r34;
        r23.n = r24;
    L49:
        r34 = null;
    L43:
        r31 = null;
    L37:
        r27 = null;
    L52:
        if (r21 == null) goto L55;
        List r35 = CollectionsKt.toMutableList(r21);
        if (r35 == null) goto L55;
    L56:
        UserCreationModel r36 = new UserCreationModel(2, r35, null, 4);
        fs9.a0.c(r36);
        r8.add(r36);
        r9 = r20;
    L55:
        r35 = new ArrayList();
    L58:
        r0.addAll((Collection) r8);
        goto L59
    L57:
        r8 = CollectionsKt.emptyList();
        goto L58
    L12:
        if (r1.isEmpty() == true) goto L15;
        r3 = false;
        goto L17
    L8:
        r16 = null;
        goto L9
    }

    private static final Unit deleteUserCreation$lambda$73(String r12, CreationFeedViewModel r13, boolean r14, CreationFeedComponentState r15) {
        Intrinsics.checkNotNullParameter(r15, "lastState");
        final ArrayList r0 = new ArrayList();
        Iterator<T> r16 = r15.getCreationModelList().iterator();
        boolean r3 = false;
        int r4 = 1;
    L4:
        if (r16.hasNext() == false) goto L66;
        UserCreationModel r5 = (UserCreationModel) r16.next();
        if (r14 == true) goto L7;
        List r7 = r5.b();
        if (r7 == null) goto L49;
        ArrayList r8 = new ArrayList();
        Iterator r9 = r7.iterator();
    L41:
        if (r9.hasNext() == false) goto L48;
        Object r10 = r9.next();
        boolean r11 = Intrinsics.areEqual(((UserCreation) r10).a, r12);
        if (r11 == false) goto L46;
        boolean r6 = m29.a.a;
        m29.a.c(TAG, "delete creationId:" + r12);
        r3 = true;
    L46:
        if ((!r11) == false) goto L41;
        r8.add(r10);
        goto L41
    L48:
        List r17 = CollectionsKt.toMutableList(r8);
    L50:
        List r18 = r17;
        if (r18 != null) goto L53;
    L56:
        boolean r20 = true;
    L57:
        if (r20 == true) goto L4;
        Iterator r21 = r17.iterator();
    L60:
        if (r21.hasNext() == false) goto L64;
        UserCreationTrackParams r22 = ((UserCreation) r21.next()).n;
        if (r22 == null) goto L60;
        r22.c = Integer.valueOf(r4);
        goto L60
    L64:
        UserCreationModel r23 = UserCreationModel.a(r5, r17);
        fs9.a0.c(r23);
        r0.add(r23);
    L65:
        r4 = r4 + 1;
        goto L4
    L53:
        if (r18.isEmpty() == true) goto L56;
        r20 = false;
        goto L57
    L49:
        r17 = null;
        goto L50
    L7:
        List r24 = r5.b();
        if (r24 == null) goto L25;
        List r25 = r24;
        if ((r25 instanceof Collection) == true) goto L12;
    L14:
        Iterator r26 = r25.iterator();
    L16:
        if (r26.hasNext() == false) goto L22;
        boolean r27 = Intrinsics.areEqual(((UserCreation) r26.next()).a, r12);
        if (r27 == false) goto L20;
        boolean r28 = m29.a.a;
        m29.a.c(TAG, "delete creationList:" + r12);
    L20:
        if (r27 == false) goto L16;
        boolean r30 = true;
    L23:
        if (r30 != true) goto L25;
        boolean r31 = true;
    L26:
        if (r31 == false) goto L27;
        r3 = true;
        goto L4
    L27:
        List r32 = r5.b();
        if (r32 == null) goto L35;
        Iterator r33 = r32.iterator();
    L31:
        if (r33.hasNext() == false) goto L35;
        UserCreationTrackParams r34 = ((UserCreation) r33.next()).n;
        if (r34 == null) goto L31;
        r34.c = Integer.valueOf(r4);
    L35:
        r0.add(r5);
    L22:
        r30 = false;
        goto L23
    L12:
        if (r25.isEmpty() == false) goto L14;
    L25:
        r31 = false;
        goto L26
    L66:
        if (r3 == false) goto L69;
        boolean r110 = m29.a.a;
        m29.a.c(TAG, "deleteUserCreation:" + r12);
        final long r111 = r13.eventCount;
        r13.eventCount = 1 + r111;
        r13.setState(new v0(r0, r111));
    L69:
        return Unit.INSTANCE;
    }

    private final void prepareAndApplyProfileCache(int r15, List<UserCreationModel> r16, List<UserCreation> r17, boolean r18) {
        long r6 = this.profileCachePreparationId.incrementAndGet();
        BuildersKt.launch$default(getViewModelScope(), Dispatchers.getIO(), null, new C01551(this, r16, r17, r15, r18, r6, null), 2, null);
    }

    public static /* synthetic */ void tryLoadMore$default(CreationFeedViewModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.tryLoadMore(r1);
    }

    public void updateCreationModelPrivacy(int r1, boolean r2, UserCreation r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "userCreation");
        String r5 = r3.a;
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        deleteUserCreation(r5, r4);
    }

    private final boolean applyFinalDataList(final int r7, final List<UserCreationModel> r8, boolean r9, boolean r10, final CreationFeedComponentState r11) {
        boolean r0 = m29.a.a;
        m29.a.c(TAG, "final size: " + r8.size());
        if (r10 == true) goto L6;
        this.profileCachePreparationId.incrementAndGet();
    L6:
        if (this.forceApplyNextRefresh == true) goto L36;
        if (r9 == true) goto L36;
        if (r10 == true) goto L36;
        if ((!r11.getCreationModelList().isEmpty()) == false) goto L36;
        if ((!r8.isEmpty()) == false) goto L36;
        List r12 = CollectionsKt.take(r11.getCreationModelList(), r8.size());
        ArrayList r1 = new ArrayList();
        Iterator r13 = r12.iterator();
    L15:
        if (r13.hasNext() == false) goto L20;
        List r4 = ((UserCreationModel) r13.next()).b();
        if (r4 != null) goto L19;
        r4 = CollectionsKt.emptyList();
    L19:
        CollectionsKt.addAll(r1, r4);
        goto L15
    L20:
        ArrayList r5 = new ArrayList();
        Iterator<T> r14 = r8.iterator();
    L22:
        if (r14.hasNext() == false) goto L28;
        List r6 = ((UserCreationModel) r14.next()).b();
        if (r6 != null) goto L26;
        r6 = CollectionsKt.emptyList();
    L26:
        CollectionsKt.addAll(r5, r6);
        goto L22
    L28:
        if (shouldHandleProfileNoWatermarkFeed() == true) goto L30;
    L32:
        boolean r15 = false;
    L33:
        boolean r16 = deepEqualsUserCreationList(r1, r5, r15);
        boolean r2 = m29.a.a;
        m29.a.c(TAG, "blockRefresh: " + r16);
        if (r16 == false) goto L36;
        return false;
    L30:
        if (CreationNoWatermarkManager.a.D() == false) goto L32;
        r15 = true;
    L36:
        this.forceApplyNextRefresh = false;
        if (r10 == false) goto L39;
        setStateImmediate(new r0(r7, this, r11, r8));
    L40:
        return true;
    L39:
        setState(new s0(r7, this, r11, r8));
        goto L40
    }

    private static final CreationFeedComponentState applyFinalDataList$lambda$44(int r10, CreationFeedViewModel r11, CreationFeedComponentState r12, List r13, CreationFeedComponentState r14) {
        Intrinsics.checkNotNullParameter(r14, "$this$setStateImmediate");
        p1 r6 = new p1(r10);
        if (r11.hasMore == true) goto L5;
        gs9.i.a r15 = gs9.i.a.a;
    L7:
        return CreationFeedComponentState.copy$default(r14, r13, null, null, r15, r6, null, 38, null);
    L5:
        r15 = r12.getMoreState();
        goto L7
    }

    private static final CreationFeedComponentState applyFinalDataList$lambda$45(int r10, CreationFeedViewModel r11, CreationFeedComponentState r12, List r13, CreationFeedComponentState r14) {
        Intrinsics.checkNotNullParameter(r14, "$this$setState");
        p1 r6 = new p1(r10);
        if (r11.hasMore == true) goto L5;
        gs9.i.a r15 = gs9.i.a.a;
    L7:
        return CreationFeedComponentState.copy$default(r14, r13, null, null, r15, r6, null, 38, null);
    L5:
        r15 = r12.getMoreState();
        goto L7
    }

    public static /* synthetic */ Object checkCurrentData$default(CreationFeedViewModel r0, boolean r1, Continuation r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.checkCurrentData(r1, r2);
    }

    private final Object prepareProfileNoWatermarkModelList(List<UserCreationModel> r8, List<UserCreation> r9, int r10, boolean r11, Continuation<? super List<UserCreationModel>> r12) {
        if ((r12 instanceof C01561) == false) goto L7;
        C01561 r0 = (C01561) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        r8 = (List) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L46:
        return selectProfileNoWatermarkModelListForFeed(r8);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = r0.Z$0;
        r10 = r0.I$0;
        r9 = (List) r0.L$1;
        r8 = (List) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L22:
        boolean r14 = ((Boolean) r13).booleanValue();
        this.lastProfileNoWatermarkEnabled = Boxing.boxBoolean(r14);
        boolean r4 = m29.a.a;
        m29.a.c(TAG, "prepare profile no watermark feed, enabled:" + r14 + ", requestIndex:" + r10 + ", isAppend:" + r11);
        if (r14 == true) goto L25;
        return r8;
    L25:
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r9.iterator();
    L27:
        if (r16.hasNext() == false) goto L34;
        Object r5 = r16.next();
        if (((UserCreation) r5).b == 1) goto L31;
        boolean r6 = true;
    L32:
        if (r6 == false) goto L27;
        r15.add(r5);
        goto L27
    L31:
        r6 = false;
        goto L32
    L34:
        ArrayList r17 = new ArrayList();
        Iterator r18 = r15.iterator();
    L36:
        if (r18.hasNext() == false) goto L41;
        Object r7 = r18.next();
        CreationNoWatermarkManager.a.getClass();
        if (CreationNoWatermarkManager.l0((UserCreation) r7) == false) goto L36;
        r17.add(r7);
        goto L36
    L41:
        if ((!r17.isEmpty()) == false) goto L46;
        CreationNoWatermarkManager r110 = CreationNoWatermarkManager.a;
        String r111 = profileNoWatermarkFeedScene(r10, r11);
        r0.L$0 = r8;
        r0.L$1 = null;
        r0.label = 2;
        if (r110.s(r17, r111, r0) != r2) goto L46;
        return r2;
    L16:
        ResultKt.throwOnFailure(r13);
        if (shouldPrepareProfileNoWatermark(r8) == true) goto L19;
        return r8;
    L19:
        CreationNoWatermarkManager r112 = CreationNoWatermarkManager.a;
        r0.L$0 = r8;
        r0.L$1 = r9;
        r0.I$0 = r10;
        r0.Z$0 = r11;
        r0.label = 1;
        r13 = r112.P(r0);
        if (r13 != r2) goto L22;
        return r2;
    L7:
        r0 = new C01561(this, r12);
        goto L8
    }

    public static /* synthetic */ void refresh$default(CreationFeedViewModel r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.refresh(r1, r2);
    }

    private final Object updateDataList(int r9, zp9.c r10, boolean r11, boolean r12, Continuation<? super Unit> r13) {
        this.hasMore = r10.d();
        Object r14 = updateDataListByState(r9, r10, r11, r12, (CreationFeedComponentState) getState(), r13);
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r14;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ boolean access$applyFinalDataList(CreationFeedViewModel r0, int r1, List r2, boolean r3, boolean r4, CreationFeedComponentState r5) {
        return r0.applyFinalDataList(r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ Object access$prepareProfileNoWatermarkModelList(CreationFeedViewModel r0, List r1, List r2, int r3, boolean r4, Continuation r5) {
        return r0.prepareProfileNoWatermarkModelList(r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ Object access$updateDataList(CreationFeedViewModel r0, int r1, zp9.c r2, boolean r3, boolean r4, Continuation r5) {
        return r0.updateDataList(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ boolean deepEqualsUserCreation$default(CreationFeedViewModel r0, UserCreation r1, UserCreation r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return r0.deepEqualsUserCreation(r1, r2, r3);
    }

    public static /* synthetic */ boolean deepEqualsUserCreationList$default(CreationFeedViewModel r0, List r1, List r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return r0.deepEqualsUserCreationList(r1, r2, r3);
    }

    public static /* synthetic */ boolean fetchFirstScreenData$default(CreationFeedViewModel r1, boolean r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = false;
    L12:
        return r1.fetchFirstScreenData(r2, r3, r4);
    }

    public static /* synthetic */ boolean requestFirstRecommendList$default(CreationFeedViewModel r1, boolean r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return r1.requestFirstRecommendList(r2, r3, r4);
    }

    private final Object updateDataListByState(int r8, zp9.c r9, boolean r10, boolean r11, CreationFeedComponentState r12, Continuation<? super Unit> r13) {
        if ((r13 instanceof C01581) == false) goto L7;
        C01581 r0 = (C01581) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        C01581 r6 = r0;
        Object r14 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        r11 = r6.Z$1;
        r10 = r6.Z$0;
        r8 = r6.I$0;
        r12 = (CreationFeedComponentState) r6.L$0;
        ResultKt.throwOnFailure(r14);
    L18:
        applyFinalDataList(r8, (List) r14, r10, r11, r12);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
        List<UserCreationModel> r15 = buildFinalModelList(r8, r9, r10, r12);
        List<UserCreation> r4 = creationListForNoWatermark(r9);
        r6.L$0 = r12;
        r6.I$0 = r8;
        r6.Z$0 = r10;
        r6.Z$1 = r11;
        r6.label = 1;
        r14 = prepareProfileNoWatermarkModelList(r15, r4, r8, r10, r6);
        if (r14 != r2) goto L18;
        return r2;
    L7:
        r0 = new C01581(this, r13);
        goto L8
    }

    public static final /* synthetic */ Object access$updateDataListByState(CreationFeedViewModel r0, int r1, zp9.c r2, boolean r3, boolean r4, CreationFeedComponentState r5, Continuation r6) {
        return r0.updateDataListByState(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Object updateDataList$default(CreationFeedViewModel r6, int r7, zp9.c r8, boolean r9, boolean r10, Continuation r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        boolean r4 = false;
    L7:
        return r6.updateDataList(r7, r8, r9, r4, r11);
    L5:
        r4 = r10;
        goto L7
    }

    public static /* synthetic */ Object updateDataListByState$default(CreationFeedViewModel r7, int r8, zp9.c r9, boolean r10, boolean r11, CreationFeedComponentState r12, Continuation r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L5;
        boolean r4 = false;
    L7:
        return r7.updateDataListByState(r8, r9, r10, r4, r12, r13);
    L5:
        r4 = r11;
        goto L7
    }
}
