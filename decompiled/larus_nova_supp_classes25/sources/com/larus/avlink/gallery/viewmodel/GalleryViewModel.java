package com.larus.avlink.gallery.viewmodel;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.gallery.AlbumUtils;
import com.larus.avlink.gallery.business.MediaLifecycleStateManager;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.i;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.share.AlbumDeleteDialog;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.bigimg.t1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.dialog.u;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import t19.s;
import yt8.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001t\b\u0007\u0018\u0000 \u0099\u00012\u00020\u0001:\u0004\u0099\u0001\u009a\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010G\u001a\u00020HH\u0002J\b\u0010I\u001a\u00020HH\u0002J\u0006\u0010J\u001a\u00020HJ\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u0015H\u0002J\b\u0010N\u001a\u00020HH\u0002J\u000e\u0010O\u001a\u00020H2\u0006\u0010P\u001a\u00020\u0007J\u0012\u0010Q\u001a\u00020H2\b\u0010M\u001a\u0004\u0018\u00010\u0015H\u0002J\u0014\u0010R\u001a\u00020H2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014J\u0006\u0010T\u001a\u00020HJ\u0006\u0010U\u001a\u00020HJ\u0016\u0010V\u001a\u00020H2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014H\u0002J\b\u0010X\u001a\u00020HH\u0002J\u0006\u0010Y\u001a\u00020HJ\u0010\u0010Z\u001a\u00020H2\u0006\u0010[\u001a\u00020\u000eH\u0002J\u0010\u0010\\\u001a\u00020H2\u0006\u0010[\u001a\u00020\u000eH\u0002J\u0014\u0010]\u001a\u00020H2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u000e\u0010_\u001a\u00020\t2\u0006\u0010`\u001a\u00020\u0015J\u000e\u0010a\u001a\u00020H2\u0006\u0010b\u001a\u00020\tJ\u0018\u0010c\u001a\u00020H2\u0006\u0010[\u001a\u00020\u000e2\u0006\u0010d\u001a\u00020\tH\u0002J\u0006\u0010e\u001a\u00020\u0007J\f\u0010f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014J\u0010\u0010g\u001a\u00020H2\b\b\u0002\u0010h\u001a\u00020\tJ\u0006\u0010i\u001a\u00020HJ\u000e\u0010j\u001a\u00020H2\u0006\u0010k\u001a\u00020lJ\u0010\u0010m\u001a\u00020H2\u0006\u0010k\u001a\u00020lH\u0002J\u0010\u0010n\u001a\u00020H2\u0006\u0010k\u001a\u00020lH\u0002J\u0006\u0010o\u001a\u00020HJ\u000e\u0010p\u001a\u00020H2\u0006\u0010`\u001a\u00020\u0015J\u0006\u0010q\u001a\u00020HJ\u0006\u0010r\u001a\u00020HJ\u0006\u0010v\u001a\u00020HJ\u0006\u0010w\u001a\u00020HJ\b\u0010x\u001a\u00020HH\u0014J*\u0010y\u001a\u00020H2\u0006\u0010z\u001a\u00020\u000e2\u0006\u0010{\u001a\u00020\u000e2\n\b\u0002\u0010|\u001a\u0004\u0018\u00010}H\u0082@¢\u0006\u0002\u0010~J\u0019\u0010\u007f\u001a\u00020H2\u0006\u0010z\u001a\u00020\u000e2\u0007\u0010\u0080\u0001\u001a\u00020LH\u0002J\u0010\u0010\u0081\u0001\u001a\u00020H2\u0007\u0010\u0082\u0001\u001a\u00020\u0007J\r\u0010\u0083\u0001\u001a\u00020\t*\u00020LH\u0002J,\u0010\u0084\u0001\u001a\u00020H2\u0006\u0010k\u001a\u00020l2\u0007\u0010\u0085\u0001\u001a\u00020\u000e2\u0012\b\u0002\u0010\u0086\u0001\u001a\u000b\u0012\u0004\u0012\u00020H\u0018\u00010\u0087\u0001J,\u0010\u0088\u0001\u001a\u00020H2\u0006\u0010k\u001a\u00020l2\u0007\u0010\u0085\u0001\u001a\u00020\u000e2\u0010\u0010\u0086\u0001\u001a\u000b\u0012\u0004\u0012\u00020H\u0018\u00010\u0087\u0001H\u0002J,\u0010\u0089\u0001\u001a\u00020H2\u0006\u0010k\u001a\u00020l2\u0007\u0010\u0085\u0001\u001a\u00020\u000e2\u0010\u0010\u0086\u0001\u001a\u000b\u0012\u0004\u0012\u00020H\u0018\u00010\u0087\u0001H\u0002J:\u0010\u008a\u0001\u001a\u00020H2\u0006\u0010k\u001a\u00020l2\r\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00142\u0006\u0010h\u001a\u00020\t2\u0010\u0010\u0086\u0001\u001a\u000b\u0012\u0004\u0012\u00020H\u0018\u00010\u0087\u0001H\u0002J \u0010\u008c\u0001\u001a\u00020\t2\u0006\u0010k\u001a\u00020l2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0011¢\u0006\u0003\u0010\u008e\u0001J\u0007\u0010\u008f\u0001\u001a\u00020\tJ\u0007\u0010\u0090\u0001\u001a\u00020\tJ\u0007\u0010\u0091\u0001\u001a\u00020HJ\u0010\u0010\u0092\u0001\u001a\u00020H2\u0007\u0010\u0093\u0001\u001a\u00020\tJ\u0010\u0010\u0094\u0001\u001a\u00020H2\u0007\u0010\u0095\u0001\u001a\u00020\u0007J\u0018\u0010\u0096\u0001\u001a\u00020H2\u0006\u0010z\u001a\u00020\u000e2\u0007\u0010\u0097\u0001\u001a\u00020\u000eJ\u0007\u0010\u0098\u0001\u001a\u00020HR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u001c\u0010\u001d\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\t0\t0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u001a\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0017¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u001c\u0010$\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\t0\t0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u001c\u0010&\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\t0\t0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u001c\u0010)\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u00070\u00070\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0019R\u0016\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0017¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0019R\u001c\u00102\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\t0\t0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0019R\u0016\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060\u0017¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0019R\u0016\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:0\u0017¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0019R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020\t0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0019R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010D0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010D0\u0017¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0019R\u0010\u0010s\u001a\u00020tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010u¨\u0006\u009b\u0001"}, d2 = {"Lcom/larus/avlink/gallery/viewmodel/GalleryViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "stateManager", "Lcom/larus/avlink/gallery/business/MediaLifecycleStateManager;", "currentPage", "", "isLoadingMore", "", "hasMoreData", "totalCount", "selectablePaths", "", "", "isSyncing", "lastSyncTime", "", "_localMediaList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/bmhome/bigimg/MediaItem;", "localMediaList", "Landroidx/lifecycle/LiveData;", "getLocalMediaList", "()Landroidx/lifecycle/LiveData;", "_localMediaLoadResult", "localMediaLoadResult", "getLocalMediaLoadResult$dora_avlink_impl_release", "_shouldScrollToTop", "kotlin.jvm.PlatformType", "shouldScrollToTop", "getShouldScrollToTop", "_selectedItems", "selectedItems", "getSelectedItems", "_isSelectMode", "isSelectMode", "_hasSelectAll", "hasSelectAll", "getHasSelectAll", "_syncProgress", "syncProgress", "getSyncProgress", "_permissionGranted", "permissionGranted", "getPermissionGranted", "_singleFileDeletedEvent", "singleFileDeletedEvent", "getSingleFileDeletedEvent", "_showEmpty", "showEmpty", "getShowEmpty", "_deleteDialogEvent", "Lcom/larus/avlink/gallery/share/AlbumDeleteDialog;", "deleteDialogEvent", "getDeleteDialogEvent", "_simpleDialogEvent", "Lcom/larus/common_ui/dialog/CommonDialog;", "simpleDialogEvent", "getSimpleDialogEvent", "_showSharePanelEvent", "showSharePanelEvent", "getShowSharePanelEvent", "loadJob", "Lkotlinx/coroutines/Job;", "isLifecycleListenerRegistered", "_mediaReplaceEvent", "Lcom/larus/avlink/gallery/viewmodel/GalleryViewModel$MediaReplaceEvent;", "mediaReplaceEvent", "getMediaReplaceEvent", "updateHasSelectAll", "", "refreshSelectablePaths", "loadLocalMedia", "createMetadataFromMediaItem", "Lcom/larus/avlink/gallery/model/MediaMetadata;", "mediaItem", "loadMoreMedia", "onScrollPositionChanged", "position", "insertMediaItem", "handleAlbumDeletion", "deletedPaths", "clearMediaReplaceEvent", "clearScrollToTopFlag", "removeMediaItems", "urls", "enterSelectMode", "exitSelectMode", "addSelectedItem", "path", "removeSelectedItem", "applySelectedPaths", "selectedPaths", "toggleItemSelection", "item", "onSelectAllClicked", "isSelectAll", "updateItemSelectionState", "isSelected", "getSelectedCount", "getSelectedPaths", "deleteSelectedFiles", "deleteFromAlbum", "shareSelectedFiles", "showDeleteDialog", "context", "Landroid/content/Context;", "showAlbumDeleteDialog", "showLocalDeleteDialog", "clearDeleteDialogEvent", "handleLongClick", "clearSharePanelEvent", "clearSimpleDialogEvent", "lifecycleListener", "com/larus/avlink/gallery/viewmodel/GalleryViewModel$lifecycleListener$1", "Lcom/larus/avlink/gallery/viewmodel/GalleryViewModel$lifecycleListener$1;", "registerMediaLifecycleListener", "unregisterMediaLifecycleListener", "onCleared", "handleDownloadCompleteInternal", "mediaId", "displayableFilePath", "geoLocationInfo", "Lcom/larus/platform/model/GeoLocationInfo;", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/GeoLocationInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleMediaCompleteInternal", "metadata", "updateSyncProgress", "progress", "canShowInAlbumList", "deleteSingleFile", "filePath", "confirmCallback", "Lkotlin/Function0;", "showSingleFileDeleteDialog", "showSingleFileLocalDeleteDialog", "executeFileDeletion", "filePaths", "needShowDeleteFromAlbum", "systemGalleryId", "(Landroid/content/Context;Ljava/lang/Long;)Z", "shouldShowPermissionGuide", "isSaveToGalleryEnabled", "clearSingleFileDeletedEvent", "updatePermissionState", "granted", "onRecoveryStarted", "fileCount", "onRecoveryFailed", "reason", "onRecoveryCompleted", "Companion", "MediaReplaceEvent", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class GalleryViewModel extends ViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final int PAGE_SIZE = 50;
    private static final int PRELOAD_THRESHOLD = 20;
    public static final String TAG = "GalleryViewModel";
    private final MutableLiveData<AlbumDeleteDialog> _deleteDialogEvent;
    private final MutableLiveData<Boolean> _hasSelectAll;
    private final MutableLiveData<Boolean> _isSelectMode;
    private final MutableLiveData<List<t1>> _localMediaList;
    private final MutableLiveData<Boolean> _localMediaLoadResult;
    private final MutableLiveData<b> _mediaReplaceEvent;
    private final MutableLiveData<Boolean> _permissionGranted;
    private final MutableLiveData<Set<String>> _selectedItems;
    private final MutableLiveData<Boolean> _shouldScrollToTop;
    private final MutableLiveData<Boolean> _showEmpty;
    private final MutableLiveData<Boolean> _showSharePanelEvent;
    private final MutableLiveData<CommonDialog> _simpleDialogEvent;
    private final MutableLiveData<String> _singleFileDeletedEvent;
    private final MutableLiveData<Integer> _syncProgress;
    private int currentPage;
    private final LiveData<AlbumDeleteDialog> deleteDialogEvent;
    private boolean hasMoreData;
    private final LiveData<Boolean> hasSelectAll;
    private volatile boolean isLifecycleListenerRegistered;
    private boolean isLoadingMore;
    private final LiveData<Boolean> isSelectMode;
    private volatile boolean isSyncing;
    private long lastSyncTime;
    private final GalleryViewModel$lifecycleListener$1 lifecycleListener;
    private Job loadJob;
    private final LiveData<List<t1>> localMediaList;
    private final LiveData<Boolean> localMediaLoadResult;
    private final LiveData<b> mediaReplaceEvent;
    private final LiveData<Boolean> permissionGranted;
    private Set<String> selectablePaths;
    private final LiveData<Set<String>> selectedItems;
    private final LiveData<Boolean> shouldScrollToTop;
    private final LiveData<Boolean> showEmpty;
    private final LiveData<Boolean> showSharePanelEvent;
    private final LiveData<CommonDialog> simpleDialogEvent;
    private final LiveData<String> singleFileDeletedEvent;
    private final MediaLifecycleStateManager stateManager;
    private final LiveData<Integer> syncProgress;
    private int totalCount;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final t1 c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            t1 r1 = this.c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + this.d.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "MediaReplaceEvent(mediaId=" + this.a + ", newPath=" + this.b + ", mediaItem=" + this.c + ", originalPath=" + this.d + ')';
        }

        public b(String r2, String r3, t1 r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "mediaId");
            Intrinsics.checkNotNullParameter(r3, "newPath");
            Intrinsics.checkNotNullParameter(r5, "originalPath");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class c implements AlbumDeleteDialog.a {
        public final /* synthetic */ GalleryViewModel a;
        public final /* synthetic */ Context b;

        @Override // com.larus.avlink.gallery.share.AlbumDeleteDialog.a
        public final void onCancelClick() {
        }

        @Override // com.larus.avlink.gallery.share.AlbumDeleteDialog.a
        public final void a() {
            this.a.deleteSelectedFiles(false);
            s r0 = s.a;
            Context r1 = this.b;
            String r2 = r1.getString(2131899737);
            r0.getClass();
            s.p(r1, r2);
        }

        @Override // com.larus.avlink.gallery.share.AlbumDeleteDialog.a
        public final void b() {
            this.a.deleteSelectedFiles(true);
            s r0 = s.a;
            Context r1 = this.b;
            String r2 = r1.getString(2131899737);
            r0.getClass();
            s.p(r1, r2);
        }

        public c(GalleryViewModel r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements p0 {
        public final /* synthetic */ GalleryViewModel a;
        public final /* synthetic */ Context b;

        public final void confirm() {
            this.a.deleteSelectedFiles(false);
            s r0 = s.a;
            Context r1 = this.b;
            String r2 = r1.getString(2131899737);
            r0.getClass();
            s.p(r1, r2);
        }

        public d(GalleryViewModel r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.GalleryViewModel$deleteSelectedFiles$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.GalleryViewModel$deleteSelectedFiles$1", f = "GalleryViewModel.kt", i = {}, l = {584}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $deleteFromAlbum;
        int label;
        final /* synthetic */ GalleryViewModel this$0;

        /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.GalleryViewModel$deleteSelectedFiles$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.GalleryViewModel$deleteSelectedFiles$1$1", f = "GalleryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<String> $selectedPaths;
            int label;
            final /* synthetic */ GalleryViewModel this$0;

            public C00101(GalleryViewModel r1, List<String> r2, Continuation<? super C00101> r3) {
                this.this$0 = r1;
                this.$selectedPaths = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00101(this.this$0, this.$selectedPaths, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                GalleryViewModel.access$removeMediaItems(this.this$0, this.$selectedPaths);
                this.this$0.exitSelectMode();
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(GalleryViewModel r1, boolean r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$deleteFromAlbum = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$deleteFromAlbum, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r7);     // Catch: Exception -> L15
        L19:
        L18:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
            List<String> r8 = this.this$0.getSelectedPaths();     // Catch: Exception -> L15
            if ((!r8.isEmpty()) == false) goto L19;
            int r2 = AlbumUtils.a;     // Catch: Exception -> L15
            AlbumUtils.b(r8, this.$deleteFromAlbum);     // Catch: Exception -> L15
            MainCoroutineDispatcher r3 = Dispatchers.getMain();     // Catch: Exception -> L15
            C00101 r4 = new C00101(this.this$0, r8, null);     // Catch: Exception -> L15
            this.label = 1;     // Catch: Exception -> L15
            if (BuildersKt.withContext(r3, r4, this) != r0) goto L19;
            return r0;
        L15:
            e = move-exception;
            FLogger.a.e(GalleryViewModel.TAG, "Error deleting files: " + e.getMessage(), e);
            goto L18
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.GalleryViewModel$deleteSingleFile$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.GalleryViewModel$deleteSingleFile$1", f = "GalleryViewModel.kt", i = {}, l = {885, 887}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $confirmCallback;
        final /* synthetic */ Context $context;
        final /* synthetic */ String $filePath;
        int label;
        final /* synthetic */ GalleryViewModel this$0;

        /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.GalleryViewModel$deleteSingleFile$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.GalleryViewModel$deleteSingleFile$1$1", f = "GalleryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $canShowDeleteFromAlbum;
            final /* synthetic */ Function0<Unit> $confirmCallback;
            final /* synthetic */ Context $context;
            final /* synthetic */ String $filePath;
            int label;
            final /* synthetic */ GalleryViewModel this$0;

            public C00111(boolean r1, GalleryViewModel r2, Context r3, String r4, Function0<Unit> r5, Continuation<? super C00111> r6) {
                this.$canShowDeleteFromAlbum = r1;
                this.this$0 = r2;
                this.$context = r3;
                this.$filePath = r4;
                this.$confirmCallback = r5;
                super(2, r6);
            }

            public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
                return new C00111(this.$canShowDeleteFromAlbum, this.this$0, this.$context, this.$filePath, this.$confirmCallback, r9);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L11;
                ResultKt.throwOnFailure(r4);
                if (this.$canShowDeleteFromAlbum == false) goto L7;
                GalleryViewModel.access$showSingleFileDeleteDialog(this.this$0, this.$context, this.$filePath, this.$confirmCallback);
            L9:
                return Unit.INSTANCE;
            L7:
                GalleryViewModel.access$showSingleFileLocalDeleteDialog(this.this$0, this.$context, this.$filePath, this.$confirmCallback);
                goto L9
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C01151(String r1, GalleryViewModel r2, Context r3, Function0<Unit> r4, Continuation<? super C01151> r5) {
            this.$filePath = r1;
            this.this$0 = r2;
            this.$context = r3;
            this.$confirmCallback = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C01151(this.$filePath, this.this$0, this.$context, this.$confirmCallback, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r12);
        L21:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r12);
        L13:
            MediaMetadata r13 = (MediaMetadata) r12;
            GalleryViewModel r2 = this.this$0;
            Context r3 = this.$context;
            if (r13 == null) goto L16;
            Long r14 = r13.getSystemGalleryId();
        L17:
            boolean r5 = r2.needShowDeleteFromAlbum(r3, r14);
            MainCoroutineDispatcher r15 = Dispatchers.getMain();
            C00111 r4 = new C00111(r5, this.this$0, this.$context, this.$filePath, this.$confirmCallback, null);
            this.label = 2;
            if (BuildersKt.withContext(r15, r4, this) != r0) goto L21;
            return r0;
        L16:
            r14 = null;
            goto L17
        L10:
            ResultKt.throwOnFailure(r12);
            AlbumDataBaseHelper r16 = AlbumDataBaseHelper.a;
            String r6 = this.$filePath;
            this.label = 1;
            r12 = r16.p(r6, this);
            if (r12 != r0) goto L13;
            return r0;
        }
    }

    public static final class e implements u {
        public e() {
        }

        public final void cancel() {
        }
    }

    public static final class f implements AlbumDeleteDialog.a {
        public final /* synthetic */ GalleryViewModel a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Function0<Unit> d;

        @Override // com.larus.avlink.gallery.share.AlbumDeleteDialog.a
        public final void onCancelClick() {
        }

        @Override // com.larus.avlink.gallery.share.AlbumDeleteDialog.a
        public final void a() {
            GalleryViewModel.access$executeFileDeletion(this.a, this.b, CollectionsKt.listOf(this.c), false, this.d);
        }

        @Override // com.larus.avlink.gallery.share.AlbumDeleteDialog.a
        public final void b() {
            GalleryViewModel.access$executeFileDeletion(this.a, this.b, CollectionsKt.listOf(this.c), true, this.d);
        }

        public f(GalleryViewModel r1, Context r2, String r3, Function0<Unit> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class g implements p0 {
        public final /* synthetic */ GalleryViewModel a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Function0<Unit> d;

        public final void confirm() {
            GalleryViewModel.access$executeFileDeletion(this.a, this.b, CollectionsKt.listOf(this.c), false, this.d);
        }

        public g(GalleryViewModel r1, Context r2, String r3, Function0<Unit> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class h implements u {
        public h() {
        }

        public final void cancel() {
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.GalleryViewModel$handleDownloadCompleteInternal$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.GalleryViewModel", f = "GalleryViewModel.kt", i = {}, l = {789}, m = "handleDownloadCompleteInternal", n = {}, s = {})
    public static final class C01161 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ GalleryViewModel this$0;

        public C01161(GalleryViewModel r1, Continuation<? super C01161> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return GalleryViewModel.access$handleDownloadCompleteInternal(this.this$0, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.GalleryViewModel$loadLocalMedia$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.GalleryViewModel$loadLocalMedia$1", f = "GalleryViewModel.kt", i = {2}, l = {156, 160, 161, 182, 194}, m = "invokeSuspend", n = {"firstPageMetadata"}, s = {"L$0"})
    public static final class C01171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ GalleryViewModel this$0;

        /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.GalleryViewModel$loadLocalMedia$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.GalleryViewModel$loadLocalMedia$1$1", f = "GalleryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<t1> $firstPageItems;
            final /* synthetic */ Set<String> $latestSelectablePaths;
            int label;
            final /* synthetic */ GalleryViewModel this$0;

            /* JADX WARN: Multi-variable type inference failed */
            public C00121(GalleryViewModel r1, Set<String> r2, List<? extends t1> r3, Continuation<? super C00121> r4) {
                this.this$0 = r1;
                this.$latestSelectablePaths = r2;
                this.$firstPageItems = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new C00121(this.this$0, this.$latestSelectablePaths, this.$firstPageItems, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L11;
                ResultKt.throwOnFailure(r3);
                if (GalleryViewModel.access$getTotalCount$p(this.this$0) != 0) goto L7;
                boolean r4 = true;
            L8:
                GalleryViewModel.access$setSelectablePaths$p(this.this$0, this.$latestSelectablePaths);
                GalleryViewModel.access$get_localMediaList$p(this.this$0).setValue(this.$firstPageItems);
                GalleryViewModel.access$get_showEmpty$p(this.this$0).setValue(Boxing.boxBoolean(r4));
                GalleryViewModel.access$get_localMediaLoadResult$p(this.this$0).setValue(Boxing.boxBoolean(r4));
                GalleryViewModel.access$updateHasSelectAll(this.this$0);
                FLogger.a.i(GalleryViewModel.TAG, "✅ First page loaded: " + this.$firstPageItems.size() + '/' + GalleryViewModel.access$getTotalCount$p(this.this$0) + " total, hasMore: " + GalleryViewModel.access$getHasMoreData$p(this.this$0));
                return Unit.INSTANCE;
            L7:
                r4 = false;
                goto L8
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.GalleryViewModel$loadLocalMedia$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.GalleryViewModel$loadLocalMedia$1$2", f = "GalleryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ GalleryViewModel this$0;

            public AnonymousClass2(GalleryViewModel r1, Continuation<? super AnonymousClass2> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass2(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r3);
                GalleryViewModel.access$setSelectablePaths$p(this.this$0, SetsKt.emptySet());
                GalleryViewModel.access$get_localMediaList$p(this.this$0).setValue(CollectionsKt.emptyList());
                GalleryViewModel.access$get_showEmpty$p(this.this$0).setValue(Boxing.boxBoolean(true));
                GalleryViewModel.access$get_localMediaLoadResult$p(this.this$0).setValue(Boxing.boxBoolean(true));
                GalleryViewModel.access$setTotalCount$p(this.this$0, 0);
                GalleryViewModel.access$setHasMoreData$p(this.this$0, false);
                GalleryViewModel.access$updateHasSelectAll(this.this$0);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C01171(GalleryViewModel r1, Continuation<? super C01171> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01171(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r18) {
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = this.label;
            boolean r10 = true;
            if (r3 == 0) goto L21;
            if (r3 == 1) goto L18;
            if (r3 == 2) goto L16;
            if (r3 == 3) goto L14;
            if (r3 == 4) goto L12;
            if (r3 != 5) goto L11;
            ResultKt.throwOnFailure(r18);
        L72:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r18);     // Catch: Exception -> L67
            goto L72
        L14:
            List r0 = (List) this.L$0;
            ResultKt.throwOnFailure(r18);     // Catch: Exception -> L67
            Object r4 = r18;
        L31:
            Iterable r5 = (Iterable) r4;     // Catch: Exception -> L67
            ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));     // Catch: Exception -> L67
            Iterator r6 = r5.iterator();     // Catch: Exception -> L67
        L33:
            if (r6.hasNext() == false) goto L35;
            r7.add(((MediaMetadata) r6.next()).getFilePath());     // Catch: Exception -> L67
            goto L33
        L35:
            Set r8 = CollectionsKt.toSet(r7);     // Catch: Exception -> L67
            Boolean r9 = (Boolean) GalleryViewModel.access$get_isSelectMode$p(this.this$0).getValue();     // Catch: Exception -> L67
            if (r9 == null) goto L38;
            boolean r11 = r9.booleanValue();     // Catch: Exception -> L67
        L39:
            Set r12 = (Set) GalleryViewModel.access$get_selectedItems$p(this.this$0).getValue();     // Catch: Exception -> L67
            GalleryViewModel r13 = this.this$0;     // Catch: Exception -> L67
            ArrayList r14 = new ArrayList();     // Catch: Exception -> L67
            Iterator r1 = r0.iterator();     // Catch: Exception -> L67
        L41:
            if (r1.hasNext() == false) goto L60;
            MediaMetadata r15 = (MediaMetadata) r1.next();     // Catch: Exception -> L67
            if (GalleryViewModel.access$canShowInAlbumList(r13, r15) == true) goto L45;
        L44:
            t1 r16 = null;
        L57:
            if (r16 == null) goto L41;
            r14.add(r16);     // Catch: Exception -> L67
            goto L41
        L45:
            int r17 = i.a;     // Catch: Exception -> L67
            if (r11 == false) goto L48;
            boolean r19 = true;
        L49:
            t1 r20 = i.b(r15, r19, r98.c.a(r15));     // Catch: Exception -> L67
            if (r20 == null) goto L44;
            if (r12 != null) goto L53;
        L55:
            boolean r21 = false;
        L56:
            r16 = t1.a.a(r20, null, false, r21, 959);     // Catch: Exception -> L67
            goto L57
        L53:
            if (r12.contains(r15.getFilePath()) != true) goto L55;
            r21 = true;
            goto L56
        L48:
            r19 = false;
            goto L49
        L60:
            GalleryViewModel.access$setCurrentPage$p(this.this$0, 0);     // Catch: Exception -> L67
            GalleryViewModel r22 = this.this$0;     // Catch: Exception -> L67
            if (GalleryViewModel.access$getTotalCount$p(r22) > 50) goto L64;
            r10 = false;
        L64:
            GalleryViewModel.access$setHasMoreData$p(r22, r10);     // Catch: Exception -> L67
            MainCoroutineDispatcher r23 = Dispatchers.getMain();     // Catch: Exception -> L67
            C00121 r24 = new C00121(this.this$0, r8, r14, null);     // Catch: Exception -> L67
            this.L$0 = null;     // Catch: Exception -> L67
            this.label = 4;     // Catch: Exception -> L67
            if (BuildersKt.withContext(r23, r24, this) != r2) goto L72;
            return r2;
        L38:
            r11 = false;
            goto L39
        L16:
            ResultKt.throwOnFailure(r18);     // Catch: Exception -> L67
            Object r25 = r18;
        L28:
            r0 = (List) r25;     // Catch: Exception -> L67
            AlbumDataBaseHelper r26 = AlbumDataBaseHelper.a;     // Catch: Exception -> L67
            MediaLifecycleState r27 = MediaLifecycleState.COMPLETED;     // Catch: Exception -> L67
            this.L$0 = r0;     // Catch: Exception -> L67
            this.label = 3;     // Catch: Exception -> L67
            r4 = r26.s(r27, this);     // Catch: Exception -> L67
            if (r4 != r2) goto L31;
            return r2;
        L18:
            GalleryViewModel r28 = (GalleryViewModel) this.L$0;
            ResultKt.throwOnFailure(r18);     // Catch: Exception -> L67
            Object r110 = r18;
        L25:
            GalleryViewModel.access$setTotalCount$p(r28, ((Number) r110).intValue());     // Catch: Exception -> L67
            FLogger.a.i(GalleryViewModel.TAG, "[loadLocalMedia] Total count in repository: " + GalleryViewModel.access$getTotalCount$p(this.this$0));     // Catch: Exception -> L67
            AlbumDataBaseHelper r29 = AlbumDataBaseHelper.a;     // Catch: Exception -> L67
            this.L$0 = null;     // Catch: Exception -> L67
            this.label = 2;     // Catch: Exception -> L67
            r25 = r29.u(0, 50, this);     // Catch: Exception -> L67
            if (r25 != r2) goto L28;
            return r2;
        L21:
            ResultKt.throwOnFailure(r18);
            FLogger.a.i(GalleryViewModel.TAG, "[loadLocalMedia] Loading first page from Repository");     // Catch: Exception -> L67
            r28 = this.this$0;     // Catch: Exception -> L67
            AlbumDataBaseHelper r111 = AlbumDataBaseHelper.a;     // Catch: Exception -> L67
            this.L$0 = r28;     // Catch: Exception -> L67
            this.label = 1;     // Catch: Exception -> L67
            r110 = r111.q(this);     // Catch: Exception -> L67
            if (r110 != r2) goto L25;
            return r2;
        L67:
            e = move-exception;
            FLogger.a.e(GalleryViewModel.TAG, "Error loading local media: " + e.getMessage(), e);
            MainCoroutineDispatcher r30 = Dispatchers.getMain();
            AnonymousClass2 r31 = new AnonymousClass2(this.this$0, null);
            this.L$0 = null;
            this.label = 5;
            if (BuildersKt.withContext(r30, r31, this) != r2) goto L72;
            return r2;
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.GalleryViewModel$loadMoreMedia$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.GalleryViewModel$loadMoreMedia$1", f = "GalleryViewModel.kt", i = {0}, l = {273, 296}, m = "invokeSuspend", n = {"nextPage"}, s = {"I$0"})
    public static final class C01181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int label;
        final /* synthetic */ GalleryViewModel this$0;

        /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.GalleryViewModel$loadMoreMedia$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.GalleryViewModel$loadMoreMedia$1$1", f = "GalleryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<t1> $newItems;
            final /* synthetic */ int $nextPage;
            int label;
            final /* synthetic */ GalleryViewModel this$0;

            /* JADX WARN: Multi-variable type inference failed */
            public C00131(GalleryViewModel r1, List<? extends t1> r2, int r3, Continuation<? super C00131> r4) {
                this.this$0 = r1;
                this.$newItems = r2;
                this.$nextPage = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new C00131(this.this$0, this.$newItems, this.$nextPage, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L16;
                ResultKt.throwOnFailure(r4);
                List r5 = (List) GalleryViewModel.access$get_localMediaList$p(this.this$0).getValue();
                if (r5 == null) goto L8;
                List r6 = CollectionsKt.toMutableList(r5);
                if (r6 == null) goto L8;
            L9:
                r6.addAll(this.$newItems);
                GalleryViewModel.access$get_localMediaList$p(this.this$0).setValue(r6);
                GalleryViewModel.access$setCurrentPage$p(this.this$0, this.$nextPage);
                int r7 = r6.size();
                GalleryViewModel r0 = this.this$0;
                if (r7 >= GalleryViewModel.access$getTotalCount$p(r0)) goto L12;
                boolean r1 = true;
            L13:
                GalleryViewModel.access$setHasMoreData$p(r0, r1);
                GalleryViewModel.access$setLoadingMore$p(this.this$0, false);
                FLogger.a.i(GalleryViewModel.TAG, "✅ [loadMoreMedia] Page " + this.$nextPage + " loaded: " + this.$newItems.size() + " items, total: " + r7 + '/' + GalleryViewModel.access$getTotalCount$p(this.this$0) + ", hasMore: " + GalleryViewModel.access$getHasMoreData$p(this.this$0));
                return Unit.INSTANCE;
            L12:
                r1 = false;
            L8:
                r6 = new ArrayList();
                goto L9
            L16:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C01181(GalleryViewModel r1, Continuation<? super C01181> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01181(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L13;
            if (r1 == 1) goto L10;
            if (r1 != 2) goto L9;
            ResultKt.throwOnFailure(r15);     // Catch: Exception -> L48
        L51:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            int r2 = this.I$0;
            ResultKt.throwOnFailure(r15);     // Catch: Exception -> L48
        L17:
            List r16 = (List) r15;     // Catch: Exception -> L48
            if (r16.isEmpty() == false) goto L21;
            GalleryViewModel.access$setHasMoreData$p(this.this$0, false);     // Catch: Exception -> L48
            GalleryViewModel.access$setLoadingMore$p(this.this$0, false);     // Catch: Exception -> L48
            FLogger.a.i(GalleryViewModel.TAG, "[loadMoreMedia] No more data");     // Catch: Exception -> L48
            return Unit.INSTANCE;
        L21:
            Boolean r6 = (Boolean) GalleryViewModel.access$get_isSelectMode$p(this.this$0).getValue();     // Catch: Exception -> L48
            if (r6 == null) goto L24;
            boolean r7 = r6.booleanValue();     // Catch: Exception -> L48
        L25:
            Set r8 = (Set) GalleryViewModel.access$get_selectedItems$p(this.this$0).getValue();     // Catch: Exception -> L48
            GalleryViewModel r9 = this.this$0;     // Catch: Exception -> L48
            ArrayList r10 = new ArrayList();     // Catch: Exception -> L48
            Iterator r17 = r16.iterator();     // Catch: Exception -> L48
        L26:
            t1 r11 = null;
            if (r17.hasNext() == false) goto L45;
            MediaMetadata r12 = (MediaMetadata) r17.next();     // Catch: Exception -> L48
            if (GalleryViewModel.access$canShowInAlbumList(r9, r12) == false) goto L43;
            int r13 = i.a;     // Catch: Exception -> L48
            if (r7 == false) goto L34;
            boolean r14 = true;
        L35:
            t1 r18 = i.b(r12, r14, r98.c.a(r12));     // Catch: Exception -> L48
            if (r18 == null) goto L43;
            if (r8 != null) goto L39;
        L41:
            boolean r19 = false;
        L42:
            r11 = t1.a.a(r18, null, false, r19, 959);     // Catch: Exception -> L48
            goto L43
        L39:
            if (r8.contains(r12.getFilePath()) != true) goto L41;
            r19 = true;
            goto L42
        L34:
            r14 = false;
        L43:
            if (r11 == null) goto L26;
            r10.add(r11);     // Catch: Exception -> L48
            goto L26
        L45:
            MainCoroutineDispatcher r110 = Dispatchers.getMain();     // Catch: Exception -> L48
            C00131 r4 = new C00131(this.this$0, r10, r2, null);     // Catch: Exception -> L48
            this.label = 2;     // Catch: Exception -> L48
            if (BuildersKt.withContext(r110, r4, this) != r0) goto L51;
            return r0;
        L24:
            r7 = false;
            goto L25
        L13:
            ResultKt.throwOnFailure(r15);
            r2 = GalleryViewModel.access$getCurrentPage$p(this.this$0) + 1;     // Catch: Exception -> L48
            AlbumDataBaseHelper r20 = AlbumDataBaseHelper.a;     // Catch: Exception -> L48
            this.I$0 = r2;     // Catch: Exception -> L48
            this.label = 1;     // Catch: Exception -> L48
            r15 = r20.u(r2 * 50, 50, this);     // Catch: Exception -> L48
            if (r15 != r0) goto L17;
            return r0;
        L48:
            e = move-exception;
            FLogger.a.e(GalleryViewModel.TAG, "Error loading more media: " + e.getMessage(), e);
            GalleryViewModel.access$setLoadingMore$p(this.this$0, false);
            goto L51
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.GalleryViewModel$onSelectAllClicked$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.GalleryViewModel$onSelectAllClicked$1", f = "GalleryViewModel.kt", i = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4}, l = {497, 500, 503, 506, 509, 517}, m = "invokeSuspend", n = {"allPaths", "allPaths", "downloadPaths", "allPaths", "downloadPaths", "processPaths", "allPaths", "downloadPaths", "processPaths", "syncPaths"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    public static final class C01191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ GalleryViewModel this$0;

        /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.GalleryViewModel$onSelectAllClicked$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.GalleryViewModel$onSelectAllClicked$1$1", f = "GalleryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<String> $allPaths;
            int label;
            final /* synthetic */ GalleryViewModel this$0;

            public C00141(GalleryViewModel r1, List<String> r2, Continuation<? super C00141> r3) {
                this.this$0 = r1;
                this.$allPaths = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00141(this.this$0, this.$allPaths, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r6) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L16;
                ResultKt.throwOnFailure(r6);
                GalleryViewModel.access$setSelectablePaths$p(this.this$0, CollectionsKt.toSet(this.$allPaths));
                GalleryViewModel.access$get_selectedItems$p(this.this$0).setValue(GalleryViewModel.access$getSelectablePaths$p(this.this$0));
                GalleryViewModel.access$updateHasSelectAll(this.this$0);
                List r7 = (List) GalleryViewModel.access$get_localMediaList$p(this.this$0).getValue();
                ArrayList r0 = null;
                if (r7 == null) goto L11;
                List r8 = r7;
                ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
                Iterator r9 = r8.iterator();
            L8:
                if (r9.hasNext() == false) goto L10;
                r1.add(t1.a.a((t1) r9.next(), null, true, true, 927));
                goto L8
            L10:
                r0 = r1;
            L11:
                if (r0 == null) goto L13;
                GalleryViewModel.access$get_localMediaList$p(this.this$0).setValue(r0);
            L13:
                FLogger.a.i(GalleryViewModel.TAG, "Select all: " + this.$allPaths.size() + " items selected (total in repository)");
                return Unit.INSTANCE;
            L16:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C01191(GalleryViewModel r1, Continuation<? super C01191> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01191(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
                case 0: goto L23;
                case 1: goto L19;
                case 2: goto L17;
                case 3: goto L14;
                case 4: goto L11;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L21
        L66:
            return Unit.INSTANCE;
        L8:
            List r1 = (List) this.L$3;
            List r2 = (List) this.L$2;
            List r4 = (List) this.L$1;
            List r5 = (List) this.L$0;
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L21
        L57:
            Iterable r11 = (Iterable) r10;     // Catch: Exception -> L21
            ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));     // Catch: Exception -> L21
            Iterator r12 = r11.iterator();     // Catch: Exception -> L21
        L59:
            if (r12.hasNext() == false) goto L61;
            r7.add(((MediaMetadata) r12.next()).getFilePath());     // Catch: Exception -> L21
            goto L59
        L61:
            FLogger.a.i(GalleryViewModel.TAG, "Select all: " + r5.size() + " items selected, downloadPaths: " + r4 + ", processPaths: " + r2 + ", syncPaths: " + r1 + ", failedPaths: " + r7);     // Catch: Exception -> L21
            MainCoroutineDispatcher r13 = Dispatchers.getMain();     // Catch: Exception -> L21
            C00141 r3 = new C00141(this.this$0, r5, null);     // Catch: Exception -> L21
            this.L$0 = null;     // Catch: Exception -> L21
            this.L$1 = null;     // Catch: Exception -> L21
            this.L$2 = null;     // Catch: Exception -> L21
            this.L$3 = null;     // Catch: Exception -> L21
            this.label = 6;     // Catch: Exception -> L21
            if (BuildersKt.withContext(r13, r3, this) != r0) goto L66;
            return r0;
        L11:
            List r6 = (List) this.L$2;
            List r8 = (List) this.L$1;
            List r9 = (List) this.L$0;
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L21
            r5 = r9;
            r4 = r8;
            r2 = r6;
        L50:
            Iterable r14 = (Iterable) r10;     // Catch: Exception -> L21
            r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));     // Catch: Exception -> L21
            Iterator r15 = r14.iterator();     // Catch: Exception -> L21
        L52:
            if (r15.hasNext() == false) goto L54;
            r1.add(((MediaMetadata) r15.next()).getFilePath());     // Catch: Exception -> L21
            goto L52
        L54:
            AlbumDataBaseHelper r16 = AlbumDataBaseHelper.a;     // Catch: Exception -> L21
            MediaLifecycleState r17 = MediaLifecycleState.FAILED;     // Catch: Exception -> L21
            this.L$0 = r5;     // Catch: Exception -> L21
            this.L$1 = r4;     // Catch: Exception -> L21
            this.L$2 = r2;     // Catch: Exception -> L21
            this.L$3 = r1;     // Catch: Exception -> L21
            this.label = 5;     // Catch: Exception -> L21
            r10 = r16.s(r17, this);     // Catch: Exception -> L21
            if (r10 != r0) goto L57;
            return r0;
        L14:
            List r18 = (List) this.L$1;
            List r19 = (List) this.L$0;
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L21
        L42:
            Iterable r110 = (Iterable) r10;     // Catch: Exception -> L21
            ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));     // Catch: Exception -> L21
            Iterator r111 = r110.iterator();     // Catch: Exception -> L21
        L44:
            if (r111.hasNext() == false) goto L46;
            r20.add(((MediaMetadata) r111.next()).getFilePath());     // Catch: Exception -> L21
            goto L44
        L46:
            AlbumDataBaseHelper r112 = AlbumDataBaseHelper.a;     // Catch: Exception -> L21
            MediaLifecycleState r21 = MediaLifecycleState.SYNCING_TO_SYSTEM_ALBUM;     // Catch: Exception -> L21
            this.L$0 = r19;     // Catch: Exception -> L21
            this.L$1 = r18;     // Catch: Exception -> L21
            this.L$2 = r20;     // Catch: Exception -> L21
            this.label = 4;     // Catch: Exception -> L21
            r10 = r112.s(r21, this);     // Catch: Exception -> L21
            if (r10 != r0) goto L49;
            return r0;
        L49:
            r5 = r19;
            r2 = r20;
            r4 = r18;
            goto L50
        L17:
            List r22 = (List) this.L$0;
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L21
        L34:
            Iterable r113 = (Iterable) r10;     // Catch: Exception -> L21
            ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));     // Catch: Exception -> L21
            Iterator r114 = r113.iterator();     // Catch: Exception -> L21
        L36:
            if (r114.hasNext() == false) goto L38;
            r23.add(((MediaMetadata) r114.next()).getFilePath());     // Catch: Exception -> L21
            goto L36
        L38:
            AlbumDataBaseHelper r115 = AlbumDataBaseHelper.a;     // Catch: Exception -> L21
            List<? extends MediaLifecycleState> r24 = CollectionsKt.listOf(new MediaLifecycleState[]{MediaLifecycleState.PROCESSING, MediaLifecycleState.PROCESSED});     // Catch: Exception -> L21
            this.L$0 = r22;     // Catch: Exception -> L21
            this.L$1 = r23;     // Catch: Exception -> L21
            this.label = 3;     // Catch: Exception -> L21
            r10 = r115.t(r24, this);     // Catch: Exception -> L21
            if (r10 != r0) goto L41;
            return r0;
        L41:
            r19 = r22;
            r18 = r23;
            goto L42
        L19:
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L21
        L27:
            Iterable r116 = (Iterable) r10;     // Catch: Exception -> L21
            r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));     // Catch: Exception -> L21
            Iterator r117 = r116.iterator();     // Catch: Exception -> L21
        L29:
            if (r117.hasNext() == false) goto L31;
            r22.add(((MediaMetadata) r117.next()).getFilePath());     // Catch: Exception -> L21
            goto L29
        L31:
            AlbumDataBaseHelper r118 = AlbumDataBaseHelper.a;     // Catch: Exception -> L21
            List<? extends MediaLifecycleState> r25 = CollectionsKt.listOf(new MediaLifecycleState[]{MediaLifecycleState.DOWNLOAD, MediaLifecycleState.DOWNLOADED_TEMP});     // Catch: Exception -> L21
            this.L$0 = r22;     // Catch: Exception -> L21
            this.label = 2;     // Catch: Exception -> L21
            r10 = r118.t(r25, this);     // Catch: Exception -> L21
            if (r10 != r0) goto L34;
            return r0;
        L23:
            ResultKt.throwOnFailure(r10);
            AlbumDataBaseHelper r119 = AlbumDataBaseHelper.a;     // Catch: Exception -> L21
            MediaLifecycleState r26 = MediaLifecycleState.COMPLETED;     // Catch: Exception -> L21
            this.label = 1;     // Catch: Exception -> L21
            r10 = r119.s(r26, this);     // Catch: Exception -> L21
            if (r10 != r0) goto L27;
            return r0;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L21:
            e = move-exception;
            FLogger.a.e(GalleryViewModel.TAG, "Error selecting all items: " + e.getMessage(), e);
            goto L66
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.GalleryViewModel$refreshSelectablePaths$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.GalleryViewModel$refreshSelectablePaths$1", f = "GalleryViewModel.kt", i = {}, l = {DoraCallStateCode.DOUBAO_VUI_ERROR, 133}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GalleryViewModel this$0;

        /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.GalleryViewModel$refreshSelectablePaths$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.GalleryViewModel$refreshSelectablePaths$1$1", f = "GalleryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Set<String> $latestSelectablePaths;
            int label;
            final /* synthetic */ GalleryViewModel this$0;

            public C00151(GalleryViewModel r1, Set<String> r2, Continuation<? super C00151> r3) {
                this.this$0 = r1;
                this.$latestSelectablePaths = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00151(this.this$0, this.$latestSelectablePaths, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                GalleryViewModel.access$setSelectablePaths$p(this.this$0, this.$latestSelectablePaths);
                GalleryViewModel.access$updateHasSelectAll(this.this$0);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C01201(GalleryViewModel r1, Continuation<? super C01201> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01201(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r7);
        L21:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
        L13:
            Iterable r8 = (Iterable) r7;
            ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
            Iterator r9 = r8.iterator();
        L15:
            if (r9.hasNext() == false) goto L17;
            r2.add(((MediaMetadata) r9.next()).getFilePath());
            goto L15
        L17:
            Set r10 = CollectionsKt.toSet(r2);
            MainCoroutineDispatcher r3 = Dispatchers.getMain();
            C00151 r4 = new C00151(this.this$0, r10, null);
            this.label = 2;
            if (BuildersKt.withContext(r3, r4, this) != r0) goto L21;
            return r0;
        L10:
            ResultKt.throwOnFailure(r7);
            AlbumDataBaseHelper r11 = AlbumDataBaseHelper.a;
            MediaLifecycleState r5 = MediaLifecycleState.COMPLETED;
            this.label = 1;
            r7 = r11.s(r5, this);
            if (r7 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.GalleryViewModel$showDeleteDialog$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.GalleryViewModel$showDeleteDialog$1", f = "GalleryViewModel.kt", i = {}, l = {609, 613}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ List<String> $selectedPaths;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ GalleryViewModel this$0;

        /* JADX INFO: renamed from: com.larus.avlink.gallery.viewmodel.GalleryViewModel$showDeleteDialog$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.avlink.gallery.viewmodel.GalleryViewModel$showDeleteDialog$1$1", f = "GalleryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $context;
            final /* synthetic */ boolean $hasAnyInSystemGallery;
            int label;
            final /* synthetic */ GalleryViewModel this$0;

            public C00161(boolean r1, GalleryViewModel r2, Context r3, Continuation<? super C00161> r4) {
                this.$hasAnyInSystemGallery = r1;
                this.this$0 = r2;
                this.$context = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new C00161(this.$hasAnyInSystemGallery, this.this$0, this.$context, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L11;
                ResultKt.throwOnFailure(r2);
                if (this.$hasAnyInSystemGallery == false) goto L7;
                GalleryViewModel.access$showAlbumDeleteDialog(this.this$0, this.$context);
            L9:
                return Unit.INSTANCE;
            L7:
                GalleryViewModel.access$showLocalDeleteDialog(this.this$0, this.$context);
                goto L9
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C01211(List<String> r1, GalleryViewModel r2, Context r3, Continuation<? super C01211> r4) {
            this.$selectedPaths = r1;
            this.this$0 = r2;
            this.$context = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01211(this.$selectedPaths, this.this$0, this.$context, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0070 -> B:22:0x0077). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = false;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r12);
        L34:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Iterator r3 = (Iterator) this.L$2;
            Context r6 = (Context) this.L$1;
            GalleryViewModel r7 = (GalleryViewModel) this.L$0;
            ResultKt.throwOnFailure(r12);
            GalleryViewModel r8 = r7;
            Context r9 = r6;
            Iterator r10 = r3;
            Object r4 = r0;
            C01211 r5 = this;
        L22:
            MediaMetadata r13 = (MediaMetadata) r12;
            if (r13 == null) goto L25;
            Long r14 = r13.getSystemGalleryId();
        L27:
            if (r8.needShowDeleteFromAlbum(r9, r14) == false) goto L29;
            C01211 r15 = r5;
            r0 = r4;
            r2 = true;
        L30:
            MainCoroutineDispatcher r11 = Dispatchers.getMain();
            C00161 r16 = new C00161(r2, r15.this$0, r15.$context, null);
            r15.L$0 = null;
            r15.L$1 = null;
            r15.L$2 = null;
            r15.label = 2;
            if (BuildersKt.withContext(r11, r16, r15) != r0) goto L34;
            return r0;
        L29:
            r15 = r5;
            r0 = r4;
            Iterator r17 = r10;
            Context r18 = r9;
            GalleryViewModel r19 = r8;
        L17:
            if (r17.hasNext() == false) goto L30;
            String r20 = (String) r17.next();
            AlbumDataBaseHelper r21 = AlbumDataBaseHelper.a;
            r15.L$0 = r19;
            r15.L$1 = r18;
            r15.L$2 = r17;
            r15.label = 1;
            Object r22 = r21.p(r20, r15);
            if (r22 != r0) goto L21;
            return r0;
        L21:
            Object r110 = r0;
            r5 = r15;
            r12 = r22;
            r8 = r19;
            r9 = r18;
            r10 = r17;
            r4 = r110;
            goto L22
        L25:
            r14 = null;
            goto L27
        L10:
            ResultKt.throwOnFailure(r12);
            List<String> r111 = this.$selectedPaths;
            GalleryViewModel r23 = this.this$0;
            r18 = this.$context;
            if ((r111 instanceof Collection) == true) goto L13;
        L15:
            r19 = r23;
            r17 = r111.iterator();
            r15 = this;
            goto L17
        L13:
            if (r111.isEmpty() == false) goto L15;
            r15 = this;
            goto L30
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public static /* synthetic */ boolean Mo() {
        return showSingleFileLocalDeleteDialog$lambda$16();
    }

    public static /* synthetic */ boolean No(List r0, t1 r1) {
        return removeMediaItems$lambda$3(r0, r1);
    }

    private static final boolean showLocalDeleteDialog$lambda$14() {
        return true;
    }

    private static final boolean showSingleFileLocalDeleteDialog$lambda$16() {
        return true;
    }

    public static /* synthetic */ boolean yo() {
        return showLocalDeleteDialog$lambda$14();
    }

    private final void enterSelectMode() {
        this._isSelectMode.setValue(Boolean.TRUE);
        List r0 = (List) this._localMediaList.getValue();
        ArrayList r1 = null;
        if (r0 == null) goto L9;
        List r2 = r0;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        r3.add(t1.a.a((t1) r4.next(), null, true, false, 991));
        goto L6
    L8:
        r1 = r3;
    L9:
        if (r1 == null) goto L13;
        this._localMediaList.setValue(r1);
        return;
    }

    private final void loadMoreMedia() {
        if (this.isLoadingMore == false) goto L5;
    L9:
        FLogger.a.d(TAG, "[loadMoreMedia] Skip - isLoading: " + this.isLoadingMore + ", hasMore: " + this.hasMoreData);
        return;
    L5:
        if (this.hasMoreData == false) goto L9;
        this.isLoadingMore = true;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01181(this, null), 2, null);
    }

    private final void updateHasSelectAll() {
        Set r0 = (Set) this._selectedItems.getValue();
        if (r0 != null) goto L5;
        r0 = SetsKt.emptySet();
    L5:
        MutableLiveData<Boolean> r1 = this._hasSelectAll;
        boolean r3 = true;
        if ((!this.selectablePaths.isEmpty()) == true) goto L8;
    L10:
        r3 = false;
    L11:
        r1.setValue(Boolean.valueOf(r3));
        return;
    L8:
        if (r0.containsAll(this.selectablePaths) == false) goto L10;
        goto L10
    }

    public final void clearDeleteDialogEvent() {
        this._deleteDialogEvent.setValue(null);
    }

    public final void clearMediaReplaceEvent() {
        this._mediaReplaceEvent.setValue(null);
    }

    public final void clearScrollToTopFlag() {
        this._shouldScrollToTop.setValue(Boolean.FALSE);
    }

    public final void clearSharePanelEvent() {
        this._showSharePanelEvent.setValue(Boolean.FALSE);
    }

    public final void clearSimpleDialogEvent() {
        this._simpleDialogEvent.setValue(null);
    }

    public final void clearSingleFileDeletedEvent() {
        this._singleFileDeletedEvent.setValue(null);
    }

    public final void exitSelectMode() {
        this._selectedItems.setValue(SetsKt.emptySet());
        MutableLiveData<Boolean> r0 = this._isSelectMode;
        Boolean r1 = Boolean.FALSE;
        r0.setValue(r1);
        this._hasSelectAll.setValue(r1);
        List r2 = (List) this._localMediaList.getValue();
        ArrayList r3 = null;
        if (r2 == null) goto L9;
        List r4 = r2;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r6 = r4.iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        r5.add(t1.a.a((t1) r6.next(), null, false, false, 927));
        goto L6
    L8:
        r3 = r5;
    L9:
        if (r3 == null) goto L13;
        this._localMediaList.setValue(r3);
        return;
    }

    public final int getSelectedCount() {
        Set r0 = (Set) this._selectedItems.getValue();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final List<String> getSelectedPaths() {
        Set r0 = (Set) this._selectedItems.getValue();
        if (r0 == null) goto L7;
        List<String> r1 = CollectionsKt.toList(r0);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    public final boolean isSaveToGalleryEnabled() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        VisionService r1 = r0.V();
        if (r1 == null) goto L9;
        if (r1.q() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void loadLocalMedia() {
        Job r0 = this.loadJob;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L10;
        FLogger.a.i(TAG, "[loadLocalMedia] loadLocalMedia is active, skip loading");
        return;
    L10:
        this.loadJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01171(this, null), 2, null);
        return;
    L5:
        if (r0.isActive() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void onRecoveryCompleted() {
        FLogger.a.i(TAG, "All recovery completed");
    }

    public final void registerMediaLifecycleListener() {
        if (this.isLifecycleListenerRegistered == false) goto L5;
        return;
    L5:
        this.stateManager.e(this.lifecycleListener);
        this.isLifecycleListenerRegistered = true;
    }

    public final void unregisterMediaLifecycleListener() {
        if (this.isLifecycleListenerRegistered == true) goto L5;
        return;
    L5:
        this.stateManager.h(this.lifecycleListener);
        this.isLifecycleListenerRegistered = false;
    }

    /* JADX WARN: Type inference failed for: r0v18, types: [com.larus.avlink.gallery.viewmodel.GalleryViewModel$lifecycleListener$1] */
    public GalleryViewModel() {
        this.stateManager = MediaLifecycleStateManager.b.a();
        this.hasMoreData = true;
        this.selectablePaths = SetsKt.emptySet();
        MutableLiveData<List<t1>> r0 = new MutableLiveData();
        this._localMediaList = r0;
        this.localMediaList = r0;
        MutableLiveData<Boolean> r1 = new MutableLiveData();
        this._localMediaLoadResult = r1;
        this.localMediaLoadResult = r1;
        Boolean r2 = Boolean.FALSE;
        MutableLiveData<Boolean> r3 = new MutableLiveData(r2);
        this._shouldScrollToTop = r3;
        this.shouldScrollToTop = r3;
        MutableLiveData<Set<String>> r4 = new MutableLiveData(SetsKt.emptySet());
        this._selectedItems = r4;
        this.selectedItems = r4;
        MutableLiveData<Boolean> r5 = new MutableLiveData(r2);
        this._isSelectMode = r5;
        this.isSelectMode = r5;
        MutableLiveData<Boolean> r6 = new MutableLiveData(r2);
        this._hasSelectAll = r6;
        this.hasSelectAll = r6;
        MutableLiveData<Integer> r7 = new MutableLiveData(0);
        this._syncProgress = r7;
        this.syncProgress = r7;
        MutableLiveData<Boolean> r8 = new MutableLiveData(Boolean.TRUE);
        this._permissionGranted = r8;
        this.permissionGranted = r8;
        MutableLiveData<String> r9 = new MutableLiveData();
        this._singleFileDeletedEvent = r9;
        this.singleFileDeletedEvent = r9;
        MutableLiveData<Boolean> r10 = new MutableLiveData(r2);
        this._showEmpty = r10;
        this.showEmpty = r10;
        MutableLiveData<AlbumDeleteDialog> r11 = new MutableLiveData();
        this._deleteDialogEvent = r11;
        this.deleteDialogEvent = r11;
        MutableLiveData<CommonDialog> r12 = new MutableLiveData();
        this._simpleDialogEvent = r12;
        this.simpleDialogEvent = r12;
        MutableLiveData<Boolean> r13 = new MutableLiveData();
        this._showSharePanelEvent = r13;
        this.showSharePanelEvent = r13;
        MutableLiveData<b> r14 = new MutableLiveData();
        this._mediaReplaceEvent = r14;
        this.mediaReplaceEvent = r14;
        this.lifecycleListener = new GalleryViewModel$lifecycleListener$1(this);
    }

    private final void refreshSelectablePaths() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01201(this, null), 2, null);
    }

    public void onCleared() {
        unregisterMediaLifecycleListener();
        super.onCleared();
    }

    public final void shareSelectedFiles() {
        List<String> r0 = getSelectedPaths();
        if ((!r0.isEmpty()) == false) goto L6;
        ia8.h.c(r0, false);
        return;
    }

    public final boolean shouldShowPermissionGuide() {
        boolean r0 = isSaveToGalleryEnabled();
        boolean r1 = !Intrinsics.areEqual(this._permissionGranted.getValue(), Boolean.TRUE);
        FLogger.a.i(TAG, "shouldShowPermissionGuide, saveToGalleryEnabled:" + r0 + ", permissionGranted:" + r1);
        if (r0 == false) goto L6;
        if (r1 == false) goto L6;
        return true;
    L6:
        return false;
    }

    public final LiveData<AlbumDeleteDialog> getDeleteDialogEvent() {
        return this.deleteDialogEvent;
    }

    public final LiveData<Boolean> getHasSelectAll() {
        return this.hasSelectAll;
    }

    public final LiveData<List<t1>> getLocalMediaList() {
        return this.localMediaList;
    }

    public final LiveData<Boolean> getLocalMediaLoadResult$dora_avlink_impl_release() {
        return this.localMediaLoadResult;
    }

    public final LiveData<b> getMediaReplaceEvent() {
        return this.mediaReplaceEvent;
    }

    public final LiveData<Boolean> getPermissionGranted() {
        return this.permissionGranted;
    }

    public final LiveData<Set<String>> getSelectedItems() {
        return this.selectedItems;
    }

    public final LiveData<Boolean> getShouldScrollToTop() {
        return this.shouldScrollToTop;
    }

    public final LiveData<Boolean> getShowEmpty() {
        return this.showEmpty;
    }

    public final LiveData<Boolean> getShowSharePanelEvent() {
        return this.showSharePanelEvent;
    }

    public final LiveData<CommonDialog> getSimpleDialogEvent() {
        return this.simpleDialogEvent;
    }

    public final LiveData<String> getSingleFileDeletedEvent() {
        return this.singleFileDeletedEvent;
    }

    public final LiveData<Integer> getSyncProgress() {
        return this.syncProgress;
    }

    public final LiveData<Boolean> isSelectMode() {
        return this.isSelectMode;
    }

    public static final /* synthetic */ int access$getCurrentPage$p(GalleryViewModel r0) {
        return r0.currentPage;
    }

    public static final /* synthetic */ boolean access$getHasMoreData$p(GalleryViewModel r0) {
        return r0.hasMoreData;
    }

    public static final /* synthetic */ Set access$getSelectablePaths$p(GalleryViewModel r0) {
        return r0.selectablePaths;
    }

    public static final /* synthetic */ int access$getTotalCount$p(GalleryViewModel r0) {
        return r0.totalCount;
    }

    public static final /* synthetic */ MutableLiveData access$get_isSelectMode$p(GalleryViewModel r0) {
        return r0._isSelectMode;
    }

    public static final /* synthetic */ MutableLiveData access$get_localMediaList$p(GalleryViewModel r0) {
        return r0._localMediaList;
    }

    public static final /* synthetic */ MutableLiveData access$get_localMediaLoadResult$p(GalleryViewModel r0) {
        return r0._localMediaLoadResult;
    }

    public static final /* synthetic */ MutableLiveData access$get_selectedItems$p(GalleryViewModel r0) {
        return r0._selectedItems;
    }

    public static final /* synthetic */ MutableLiveData access$get_showEmpty$p(GalleryViewModel r0) {
        return r0._showEmpty;
    }

    public static final /* synthetic */ void access$updateHasSelectAll(GalleryViewModel r0) {
        r0.updateHasSelectAll();
    }

    private final void addSelectedItem(String r3) {
        Set r0 = (Set) this._selectedItems.getValue();
        if (r0 == null) goto L6;
        Set r1 = CollectionsKt.toMutableSet(r0);
        if (r1 == null) goto L6;
    L7:
        r1.add(r3);
        this._selectedItems.setValue(r1);
        updateHasSelectAll();
        updateItemSelectionState(r3, true);
        return;
    L6:
        r1 = new LinkedHashSet();
        goto L7
    }

    private final boolean canShowInAlbumList(MediaMetadata r3) {
        if (r3.getLifecycleState() != MediaLifecycleState.DOWNLOAD) goto L5;
    L7:
        return false;
    L5:
        if (r3.getLifecycleState() == MediaLifecycleState.FAILED) goto L7;
        return true;
    }

    private final MediaMetadata createMetadataFromMediaItem(t1 r35) {
        PolarisFileWrapper r1 = new PolarisFileWrapper(r35.getPath());
        if ((r35 instanceof p) == false) goto L6;
        p r0 = (p) r35;
        String r3 = r0.d;
        String r7 = r0.a;
        long r8 = r1.length();
        int r10 = r0.l;
        int r11 = r0.m;
        long r12 = (long) r0.k;
        long r14 = r0.c;
        MediaLifecycleState r22 = MediaLifecycleState.COMPLETED;
        GeoLocationInfo r2 = r0.j;
        return new MediaMetadata(r3, 0, null, r7, Long.valueOf(r8), "video", r10, r11, r12, 0, 0, 0.0d, r14, r2, null, r22, null, null, null, null, null, null, null, 0, 16715264, null);
    L6:
        if ((r35 instanceof yt8.a) == false) goto L8;
        yt8.a r4 = (yt8.a) r35;
    L9:
        String r5 = r35.g();
        String r9 = r35.getName();
        long r13 = r1.length();
        if (r4 == null) goto L12;
        int r15 = r4.k;
    L13:
        if (r4 == null) goto L15;
        int r16 = r4.l;
    L16:
        long r19 = r35.e();
        MediaLifecycleState r23 = MediaLifecycleState.COMPLETED;
        GeoLocationInfo r21 = r35.a();
        return new MediaMetadata(r5, 0, null, r9, Long.valueOf(r13), "image", r15, r16, 0, 0, 0, 0.0d, r19, r21, null, r23, null, null, null, null, null, null, null, 0, 16715264, null);
    L15:
        r16 = 0;
        goto L16
    L12:
        r15 = 0;
        goto L13
    L8:
        r4 = null;
        goto L9
    }

    private final void insertMediaItem(t1 r13) {
        if (r13 != null) goto L4;
        return;
    L4:
        FLogger.a.i(TAG, "insertMediaItem: " + r13);
        List r0 = (List) this._localMediaList.getValue();
        if (r0 == null) goto L8;
        List r1 = CollectionsKt.toMutableList(r0);
        if (r1 == null) goto L8;
    L9:
        Iterator r2 = r1.iterator();
        int r4 = 0;
    L11:
        if (r2.hasNext() == false) goto L19;
        if (((t1) r2.next()).e() >= r13.e()) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == true) goto L20;
        r4 = r4 + 1;
    L20:
        if (r4 != (-1)) goto L22;
        r1.add(r13);
        FLogger.a.d(TAG, "insertMediaItem: Inserted at end (oldest), index: " + (r1.size() - 1));
    L23:
        this._shouldScrollToTop.setValue(Boolean.TRUE);
        this._localMediaList.setValue(r1);
        this._showEmpty.setValue(Boolean.FALSE);
        this.totalCount++;
        FLogger.a.d(TAG, "insertMediaItem: UI list size: " + r1.size() + ", total: " + this.totalCount);
        return;
    L22:
        ListProtector.add(r1, r4, r13);
        FLogger.a.d(TAG, "insertMediaItem: Inserted at index: " + r4 + " based on lastModified: " + r13.e());
        goto L23
    L15:
        r5 = false;
        goto L16
    L19:
        r4 = -1;
    L8:
        r1 = new ArrayList();
        goto L9
    }

    private final void removeMediaItems(final List<String> r18) {
        List r2 = (List) this._localMediaList.getValue();
        if (r2 == null) goto L6;
        List r3 = CollectionsKt.toMutableList(r2);
        if (r3 == null) goto L6;
    L7:
        FLogger r4 = FLogger.a;
        r4.i(TAG, "removeMediaItems: trying to remove " + r18.size() + " items");
        StringBuilder r5 = new StringBuilder("removeMediaItems: paths to remove:\n  ");
        r5.append(CollectionsKt.joinToString$default(r18, "\n  ", null, null, 0, null, null, 62, null));
        r4.d(TAG, r5.toString());
        StringBuilder r6 = new StringBuilder("removeMediaItems: current list paths (first 5):\n  ");
        List r7 = r3;
        List r8 = CollectionsKt.take(r7, 5);
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r10 = r8.iterator();
    L9:
        if (r10.hasNext() == false) goto L11;
        r9.add(((t1) r10.next()).getPath());
        goto L9
    L11:
        r6.append(CollectionsKt.joinToString$default(r9, "\n  ", null, null, 0, null, null, 62, null));
        r4.d(TAG, r6.toString());
        int r11 = 0;
        if ((r7 instanceof Collection) == true) goto L14;
    L16:
        Iterator r12 = r7.iterator();
    L18:
        if (r12.hasNext() == false) goto L24;
        if (r18.contains(((t1) r12.next()).getPath()) == false) goto L18;
        r11 = r11 + 1;
        if (r11 >= 0) goto L18;
        CollectionsKt.throwCountOverflow();
    L24:
        FLogger r13 = FLogger.a;
        r13.i(TAG, "removeMediaItems: matched " + r11 + " items for removal");
        CollectionsKt.removeAll(r3, new com.larus.avlink.gallery.viewmodel.b(r18));
        this._localMediaList.setValue(r3);
        this._showEmpty.setValue(Boolean.valueOf(r3.isEmpty()));
        this.totalCount -= r11;
        r13.i(TAG, "removeMediaItems: Removed " + r11 + " items, total now: " + this.totalCount + ", UI list: " + r3.size());
        refreshSelectablePaths();
        return;
    L14:
        if (r7.isEmpty() == false) goto L16;
    L6:
        r3 = new ArrayList();
        goto L7
    }

    private final void removeSelectedItem(String r3) {
        Set r0 = (Set) this._selectedItems.getValue();
        if (r0 == null) goto L6;
        Set r1 = CollectionsKt.toMutableSet(r0);
        if (r1 == null) goto L6;
    L7:
        r1.remove(r3);
        this._selectedItems.setValue(r1);
        updateHasSelectAll();
        updateItemSelectionState(r3, false);
        return;
    L6:
        r1 = new LinkedHashSet();
        goto L7
    }

    private final void showAlbumDeleteDialog(Context r3) {
        if ((r3 instanceof FragmentActivity) == false) goto L6;
        AlbumDeleteDialog r0 = new AlbumDeleteDialog();
        r0.e = new c(this, r3);
        this._deleteDialogEvent.setValue(r0);
        return;
    }

    private final void showLocalDeleteDialog(Context r6) {
        CommonDialog.a r0 = new CommonDialog.a();
        r0.g(r6.getString(2131903913));
        r0.i(r6.getString(2131903914));
        CommonDialog.a.f(r0, new d(this, r6), r6.getString(2131899533), false, 12);
        CommonDialog.a.e(r0, new e(), r6.getString(2131902465), 4);
        r0.z = false;
        Function0 r7 = new com.larus.avlink.gallery.viewmodel.a();
        Intrinsics.checkNotNullParameter(r7, "callback");
        r0.B = r7;
        CommonDialog r8 = r0.a();
        this._simpleDialogEvent.setValue(r8);
    }

    public final void applySelectedPaths(Set<String> r8) {
        Intrinsics.checkNotNullParameter(r8, "selectedPaths");
        this._selectedItems.setValue(r8);
        updateHasSelectAll();
        boolean r0 = Intrinsics.areEqual(this._isSelectMode.getValue(), Boolean.TRUE);
        List r1 = (List) this._localMediaList.getValue();
        ArrayList r2 = null;
        if (r1 == null) goto L9;
        List r3 = r1;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        t1 r6 = (t1) r5.next();
        r4.add(t1.a.a(r6, null, r0, r8.contains(r6.getPath()), 927));
        goto L6
    L8:
        r2 = r4;
    L9:
        if (r2 == null) goto L13;
        this._localMediaList.setValue(r2);
        return;
    }

    public final void deleteSelectedFiles(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, r7, null), 2, null);
    }

    public final void handleAlbumDeletion(List<String> r4) {
        Intrinsics.checkNotNullParameter(r4, "deletedPaths");
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        FLogger.a.i(TAG, "Handling album deletion for " + r4.size() + " files");
        removeMediaItems(r4);
        Set r0 = (Set) this._selectedItems.getValue();
        if (r0 == null) goto L9;
        Set r1 = CollectionsKt.toMutableSet(r0);
        if (r1 == null) goto L9;
    L11:
        if (r1.removeAll(CollectionsKt.toSet(r4)) == false) goto L18;
        this._selectedItems.setValue(r1);
        updateHasSelectAll();
        if (r1.isEmpty() == true) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(this._isSelectMode.getValue(), Boolean.TRUE) == false) goto L20;
        exitSelectMode();
        return;
    L20:
        return;
    L18:
        return;
    L9:
        r1 = new LinkedHashSet();
        goto L11
    }

    public final void handleLongClick(t1 r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Object r0 = this._isSelectMode.getValue();
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == false) goto L5;
        return;
    L5:
        enterSelectMode();
        addSelectedItem(r3.getPath());
        this._showSharePanelEvent.setValue(r1);
    }

    public final void onRecoveryStarted(int r4) {
        FLogger.a.d(TAG, "Recovery started for " + r4 + " files");
    }

    public final void onScrollPositionChanged(int r5) {
        List r0 = (List) this._localMediaList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.size();
        if (r5 >= (r1 - 20)) goto L8;
        return;
    L8:
        if (this.hasMoreData == true) goto L10;
        return;
    L10:
        if (this.isLoadingMore == true) goto L15;
        FLogger.a.d(TAG, "[onScrollPositionChanged] Trigger preload at position " + r5 + " (total: " + r1 + ')');
        loadMoreMedia();
        return;
    }

    public final void onSelectAllClicked(boolean r8) {
        ArrayList r0 = null;
        if (r8 == false) goto L5;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01191(this, null), 2, null);
        return;
    L5:
        this._selectedItems.setValue(SetsKt.emptySet());
        this._hasSelectAll.setValue(Boolean.FALSE);
        List r9 = (List) this._localMediaList.getValue();
        if (r9 == null) goto L12;
        List r10 = r9;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L11;
        r1.add(t1.a.a((t1) r11.next(), null, true, false, 927));
        goto L9
    L11:
        r0 = r1;
    L12:
        if (r0 == null) goto L17;
        this._localMediaList.setValue(r0);
        return;
    }

    public final void showDeleteDialog(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        List<String> r0 = getSelectedPaths();
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01211(r0, this, r9, null), 2, null);
    }

    public final boolean toggleItemSelection(t1 r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        if (r2.isSelected() == false) goto L5;
        removeSelectedItem(r2.getPath());
        return false;
    L5:
        addSelectedItem(r2.getPath());
        return true;
    }

    public final void updatePermissionState(boolean r4) {
        FLogger.a.i(TAG, "updatePermissionState, granted: " + r4);
        this._permissionGranted.setValue(Boolean.valueOf(r4));
    }

    public final void updateSyncProgress(int r2) {
        this._syncProgress.postValue(Integer.valueOf(r2));
    }

    public static final /* synthetic */ boolean access$canShowInAlbumList(GalleryViewModel r0, MediaMetadata r1) {
        return r0.canShowInAlbumList(r1);
    }

    public static final /* synthetic */ void access$removeMediaItems(GalleryViewModel r0, List r1) {
        r0.removeMediaItems(r1);
    }

    public static final /* synthetic */ void access$setCurrentPage$p(GalleryViewModel r0, int r1) {
        r0.currentPage = r1;
    }

    public static final /* synthetic */ void access$setHasMoreData$p(GalleryViewModel r0, boolean r1) {
        r0.hasMoreData = r1;
    }

    public static final /* synthetic */ void access$setLoadingMore$p(GalleryViewModel r0, boolean r1) {
        r0.isLoadingMore = r1;
    }

    public static final /* synthetic */ void access$setSelectablePaths$p(GalleryViewModel r0, Set r1) {
        r0.selectablePaths = r1;
    }

    public static final /* synthetic */ void access$setTotalCount$p(GalleryViewModel r0, int r1) {
        r0.totalCount = r1;
    }

    public static final /* synthetic */ void access$showAlbumDeleteDialog(GalleryViewModel r0, Context r1) {
        r0.showAlbumDeleteDialog(r1);
    }

    public static final /* synthetic */ void access$showLocalDeleteDialog(GalleryViewModel r0, Context r1) {
        r0.showLocalDeleteDialog(r1);
    }

    private final void handleMediaCompleteInternal(String r9, MediaMetadata r10) {
        FLogger r0 = FLogger.a;
        r0.i(TAG, "Media completed, adding/updating UI for: " + r9);
        String r1 = r10.getCurrentFilePath();
        if (new PolarisFileWrapper(r1).exists() == true) goto L6;
        r0.w(TAG, "Final file not found: " + r1);
        return;
    L6:
        int r2 = i.a;
        Boolean r3 = (Boolean) this._isSelectMode.getValue();
        int r4 = 0;
        if (r3 == null) goto L9;
        boolean r5 = r3.booleanValue();
    L10:
        t1 r11 = i.b(r10, r5, false);
        if (r11 != null) goto L14;
        r0.w(TAG, "Failed to create media item from metadata for " + r9);
        return;
    L14:
        List r6 = (List) this._localMediaList.getValue();
        if (r6 == null) goto L18;
        List r7 = CollectionsKt.toMutableList(r6);
        if (r7 == null) goto L18;
    L19:
        Iterator r8 = r7.iterator();
    L21:
        if (r8.hasNext() == false) goto L26;
        if (Intrinsics.areEqual(((t1) r8.next()).g(), r9) == true) goto L27;
        r4 = r4 + 1;
    L27:
        if (r4 < 0) goto L29;
        t1 r12 = (t1) ListProtector.get(r7, r4);
        ListProtector.set(r7, r4, r11);
        this._localMediaList.setValue(r7);
        FLogger r13 = FLogger.a;
        r13.i(TAG, "Updated existing item: " + r12.getPath() + " -> " + r11.getPath());
        this._mediaReplaceEvent.setValue(new b(r9, r11.getPath(), r11, r12.getPath()));
        r13.i(TAG, "MediaReplaceEvent triggered: " + r12.getPath() + " -> " + r11.getPath());
    L30:
        this._showEmpty.setValue(Boolean.FALSE);
        refreshSelectablePaths();
        return;
    L29:
        insertMediaItem(r11);
        FLogger.a.i(TAG, "Added new item via insertMediaItem: " + r11.getPath());
        goto L30
    L26:
        r4 = -1;
    L18:
        r7 = new ArrayList();
        goto L19
    L9:
        r5 = false;
        goto L10
    }

    private static final boolean removeMediaItems$lambda$3(List r1, t1 r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r1.contains(r2.getPath());
    }

    private final void updateItemSelectionState(String r7, boolean r8) {
        List r0 = (List) this._localMediaList.getValue();
        ArrayList r1 = null;
        if (r0 == null) goto L12;
        List r2 = r0;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L11;
        t1 r5 = (t1) r4.next();
        if (Intrinsics.areEqual(r5.getPath(), r7) == false) goto L10;
        r5 = t1.a.a(r5, null, true, r8, 927);
    L10:
        r3.add(r5);
        goto L6
    L11:
        r1 = r3;
    L12:
        if (r1 == null) goto L18;
        this._localMediaList.setValue(r1);
        return;
    }

    public final boolean needShowDeleteFromAlbum(Context r5, Long r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r6 == null) goto L7;
        long r2 = r6.longValue();
        if (com.larus.avlink.gallery.c.i(r5.getContentResolver(), String.valueOf(r2)) != true) goto L7;
        boolean r7 = true;
    L9:
        if (Intrinsics.areEqual(this._permissionGranted.getValue(), Boolean.TRUE) == false) goto L12;
        if (r7 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r7 = false;
        goto L9
    }

    public final void onRecoveryFailed(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "mediaId");
        Intrinsics.checkNotNullParameter(r5, "reason");
        FLogger.a.w(TAG, "Recovery failed for media: " + r4 + ", reason: " + r5);
    }

    public static final /* synthetic */ void access$handleMediaCompleteInternal(GalleryViewModel r0, String r1, MediaMetadata r2) {
        r0.handleMediaCompleteInternal(r1, r2);
    }

    private final void showSingleFileDeleteDialog(Context r3, String r4, Function0<Unit> r5) {
        AlbumDeleteDialog r0 = new AlbumDeleteDialog();
        r0.e = new f(this, r3, r4, r5);
        this._deleteDialogEvent.setValue(r0);
    }

    private final void showSingleFileLocalDeleteDialog(Context r4, String r5, Function0<Unit> r6) {
        CommonDialog.a r0 = new CommonDialog.a();
        r0.g(r4.getString(2131903913));
        r0.i(r4.getString(2131903914));
        CommonDialog.a.f(r0, new g(this, r4, r5, r6), r4.getString(2131899533), false, 12);
        CommonDialog.a.e(r0, new h(), r4.getString(2131902465), 4);
        r0.z = false;
        Function0 r7 = new com.larus.avlink.gallery.viewmodel.c();
        Intrinsics.checkNotNullParameter(r7, "callback");
        r0.B = r7;
        CommonDialog r8 = r0.a();
        this._simpleDialogEvent.setValue(r8);
    }

    public final void deleteSingleFile(Context r11, String r12, Function0<Unit> r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "filePath");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01151(r12, this, r11, r13, null), 2, null);
    }

    public static final /* synthetic */ void access$showSingleFileDeleteDialog(GalleryViewModel r0, Context r1, String r2, Function0 r3) {
        r0.showSingleFileDeleteDialog(r1, r2, r3);
    }

    public static final /* synthetic */ void access$showSingleFileLocalDeleteDialog(GalleryViewModel r0, Context r1, String r2, Function0 r3) {
        r0.showSingleFileLocalDeleteDialog(r1, r2, r3);
    }

    public static /* synthetic */ void deleteSelectedFiles$default(GalleryViewModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.deleteSelectedFiles(r1);
    }

    private final void executeFileDeletion(Context r2, List<String> r3, boolean r4, Function0<Unit> r5) {
        int r0 = AlbumUtils.a;
        AlbumUtils.b(r3, r4);
        if (r5 == null) goto L5;
        r5.invoke();
    L5:
        removeMediaItems(r3);
        s r6 = s.a;
        String r7 = r2.getString(2131899737);
        r6.getClass();
        s.p(r2, r7);
        Set r8 = (Set) this._selectedItems.getValue();
        if (r8 != null) goto L8;
        r8 = SetsKt.emptySet();
    L8:
        boolean r9 = true;
        if ((!r8.isEmpty()) == false) goto L41;
        List<String> r10 = r3;
        if ((r10 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r11 = r10.iterator();
    L17:
        if (r11.hasNext() == false) goto L21;
        if (r8.contains((String) r11.next()) == false) goto L17;
    L22:
        if (r9 == false) goto L42;
        ArrayList r12 = new ArrayList();
        Iterator r13 = r8.iterator();
    L25:
        if (r13.hasNext() == false) goto L29;
        Object r14 = r13.next();
        if (r3.contains((String) r14) == true) goto L25;
        r12.add(r14);
        goto L25
    L29:
        Set r15 = CollectionsKt.toSet(r12);
        this._selectedItems.setValue(r15);
        updateHasSelectAll();
        if (r15.isEmpty() == false) goto L43;
        exitSelectMode();
        return;
    L43:
        return;
    L42:
        return;
    L21:
        r9 = false;
        goto L22
    L13:
        if (r10.isEmpty() == false) goto L15;
    }

    private final Object handleDownloadCompleteInternal(String r12, String r13, GeoLocationInfo r14, Continuation<? super Unit> r15) {
        if ((r15 instanceof C01161) == false) goto L7;
        C01161 r0 = (C01161) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
    L21:
        t1 r17 = (t1) r16;
        FLogger.a.i(TAG, "Media item created: " + r17);
        insertMediaItem(r17);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        FLogger r18 = FLogger.a;
        r18.i(TAG, "Showing preview for media: " + r12 + ", file: " + r13);
        PolarisFileWrapper r6 = new PolarisFileWrapper(r13);
        if (r6.exists() == true) goto L18;
        r18.w(TAG, "Displayable file not found: " + r13);
        return Unit.INSTANCE;
    L18:
        this._showEmpty.setValue(Boxing.boxBoolean(false));
        CoroutineDispatcher r19 = Dispatchers.getIO();
        GalleryViewModel$handleDownloadCompleteInternal$mediaItem$1 r110 = new GalleryViewModel$handleDownloadCompleteInternal$mediaItem$1(r6, r12, this, r14, null);
        r0.label = 1;
        r16 = BuildersKt.withContext(r19, r110, r0);
        if (r16 != r2) goto L21;
        return r2;
    L7:
        r0 = new C01161(this, r15);
        goto L8
    }

    public static final /* synthetic */ void access$executeFileDeletion(GalleryViewModel r0, Context r1, List r2, boolean r3, Function0 r4) {
        r0.executeFileDeletion(r1, r2, r3, r4);
    }

    public static final /* synthetic */ Object access$handleDownloadCompleteInternal(GalleryViewModel r0, String r1, String r2, GeoLocationInfo r3, Continuation r4) {
        return r0.handleDownloadCompleteInternal(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void deleteSingleFile$default(GalleryViewModel r0, Context r1, String r2, Function0 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.deleteSingleFile(r1, r2, r3);
    }

    public static /* synthetic */ Object handleDownloadCompleteInternal$default(GalleryViewModel r0, String r1, String r2, GeoLocationInfo r3, Continuation r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.handleDownloadCompleteInternal(r1, r2, r3, r4);
    }
}
