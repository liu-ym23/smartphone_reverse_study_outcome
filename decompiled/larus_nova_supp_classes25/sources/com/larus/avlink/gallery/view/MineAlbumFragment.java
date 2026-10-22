package com.larus.avlink.gallery.view;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.api.DoraGResourceServiceDelegate;
import com.larus.avlink.gallery.coordinator.MediaSyncCoordinator;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.executor.MediaSyncExecutor;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.share.AlbumDeleteDialog;
import com.larus.avlink.gallery.storage.GalleryStoragePolicyManager;
import com.larus.avlink.gallery.thumbnail.GalleryThumbnailFragment;
import com.larus.avlink.gallery.viewmodel.GalleryViewModel;
import com.larus.avlink.impl.databinding.LarusFragmentMineAlbumListBinding;
import com.larus.avlink.impl.databinding.LarusPageAlbumListEmptyBinding;
import com.larus.bmhome.bigimg.BigImageLocalPhotoViewerDialog;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;
import com.larus.common.apphost.AppHost;
import com.larus.common_res.common_ui.databinding.LarusAccountDialogBinding;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.base.AppBarLayoutStateListener;
import com.larus.voice_setting.voice.base.ProfileInfoBaseFragment;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import v19.i5;
import v19.m5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0002+.\b\u0007\u0018\u0000 \u008e\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\b\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\b\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u0002012\u0006\u00103\u001a\u000204H\u0016J\n\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u000201H\u0016J\b\u00108\u001a\u000201H\u0016J\b\u00109\u001a\u000201H\u0002J&\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u001a\u0010B\u001a\u0002012\u0006\u0010C\u001a\u00020;2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010D\u001a\u000201H\u0002J\b\u0010E\u001a\u000201H\u0002J\b\u0010F\u001a\u000201H\u0002J\b\u0010G\u001a\u000201H\u0002J\u001c\u0010H\u001a\u0002012\f\u0010I\u001a\b\u0012\u0004\u0012\u00020K0JH\u0082@¢\u0006\u0002\u0010LJ\u0014\u0010M\u001a\u0004\u0018\u00010N2\b\u0010O\u001a\u0004\u0018\u00010NH\u0002J\u0016\u0010P\u001a\u0002012\u0006\u0010O\u001a\u00020NH\u0082@¢\u0006\u0002\u0010QJ\u0018\u0010R\u001a\u0002012\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0002J\b\u0010W\u001a\u000201H\u0002J\b\u0010X\u001a\u00020\u0018H\u0002J\b\u0010Y\u001a\u000201H\u0002J\b\u0010Z\u001a\u000201H\u0002J\b\u0010[\u001a\u000201H\u0016J\b\u0010\\\u001a\u000201H\u0002J\u0010\u0010]\u001a\u0002012\u0006\u0010^\u001a\u00020_H\u0002J\u0018\u0010`\u001a\u0002012\u0006\u0010^\u001a\u00020_2\u0006\u0010a\u001a\u00020_H\u0002J\u0016\u0010b\u001a\u0002012\f\u0010c\u001a\b\u0012\u0004\u0012\u00020\n0JH\u0016J\b\u0010d\u001a\u000201H\u0002J\b\u0010e\u001a\u000201H\u0002J\b\u0010f\u001a\u000201H\u0002J\b\u0010g\u001a\u000201H\u0002J\b\u0010h\u001a\u000201H\u0002J&\u0010i\u001a\u0002012\u001c\b\u0002\u0010j\u001a\u0016\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u000201\u0018\u00010kH\u0002J\b\u0010l\u001a\u000201H\u0016J&\u0010m\u001a\u0002012\u001c\b\u0002\u0010j\u001a\u0016\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u000201\u0018\u00010kH\u0002J\b\u0010n\u001a\u000201H\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010o\u001a\u000201H\u0016J!\u0010p\u001a\u0002012\b\u0010q\u001a\u0004\u0018\u00010_2\b\u0010r\u001a\u0004\u0018\u00010_H\u0016¢\u0006\u0002\u0010sJ\b\u0010t\u001a\u000201H\u0016J\b\u0010u\u001a\u000201H\u0016J\u0010\u0010v\u001a\u0002012\u0006\u0010w\u001a\u00020_H\u0016J\b\u0010x\u001a\u000201H\u0016J\u0010\u0010y\u001a\u0002012\u0006\u0010z\u001a\u00020\nH\u0016J\b\u0010{\u001a\u000201H\u0016J\b\u0010|\u001a\u000201H\u0016J\b\u0010}\u001a\u000201H\u0016J\b\u0010~\u001a\u000201H\u0016J\u0013\u0010\u007f\u001a\u0002012\t\u00103\u001a\u0005\u0018\u00010\u0080\u0001H\u0016J\t\u0010\u0081\u0001\u001a\u000201H\u0016J\t\u0010\u0082\u0001\u001a\u000201H\u0016J\t\u0010\u0083\u0001\u001a\u000201H\u0016J\t\u0010\u0084\u0001\u001a\u000201H\u0016J!\u0010\u0085\u0001\u001a\u0002012\u0016\u0010\u0086\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u000201\u0018\u00010\u0087\u0001H\u0016J\u0012\u0010\u0088\u0001\u001a\u0002012\u0007\u0010\u0089\u0001\u001a\u00020_H\u0016J\u001b\u0010\u008a\u0001\u001a\u0002012\u0007\u0010\u008b\u0001\u001a\u00020\n2\u0007\u0010\u008c\u0001\u001a\u00020\nH\u0016J\t\u0010\u008d\u0001\u001a\u000201H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0004\n\u0002\u0010,R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/¨\u0006\u0092\u0001"}, d2 = {"Lcom/larus/avlink/gallery/view/MineAlbumFragment;", "Lcom/larus/voice_setting/voice/base/ProfileInfoBaseFragment;", "Lcom/larus/platform/api/IMineAlbumFragment;", "Lcom/larus/avlink/api/AlbumItemDeleteListener;", "Lcom/larus/avlink/gallery/view/AlbumSyncBanner$SyncActionHandler;", "Lcom/larus/avlink/gallery/service/MediaSyncStateListener;", "Lcom/larus/avlink/gallery/thumbnail/GalleryThumbnailListener;", "<init>", "()V", "tag", "", "binding", "Lcom/larus/avlink/impl/databinding/LarusFragmentMineAlbumListBinding;", "sharePop", "Landroid/widget/PopupWindow;", "listAdapter", "Lcom/larus/avlink/gallery/view/AlbumListAdapter;", "swipeMultiSelectHelper", "Lcom/larus/avlink/gallery/view/RecyclerViewSwipeMultiSelectHelper;", "selectedPaths", "", "swipeSelectionState", "Lcom/larus/avlink/gallery/view/MineAlbumFragment$SwipeSelectionState;", "forceAddOnNextSwipeSelection", "", "isSelectMode", "syncBanner", "Lcom/larus/avlink/gallery/view/AlbumSyncBanner;", "model", "Lcom/larus/avlink/gallery/viewmodel/GalleryViewModel;", "shouldAutoStartSync", "currentPhotoViewerDialog", "Lcom/larus/bmhome/bigimg/BigImageLocalPhotoViewerDialog;", "photoViewerUpdateCallback", "Lcom/larus/avlink/gallery/view/MineAlbumFragment$PhotoViewerUpdateCallback;", "runOnceRecover", "isDoraMediaAlbum", "checkJob", "Lkotlinx/coroutines/Job;", "sharePanelLayoutController", "Lcom/larus/avlink/gallery/share/AlbumSharePanelLayoutController;", "skipNextOnResumeCheck", "doralink", "com/larus/avlink/gallery/view/MineAlbumFragment$doralink$1", "Lcom/larus/avlink/gallery/view/MineAlbumFragment$doralink$1;", "albumListCallback", "com/larus/avlink/gallery/view/MineAlbumFragment$albumListCallback$1", "Lcom/larus/avlink/gallery/view/MineAlbumFragment$albumListCallback$1;", "uploadFeedback", "", "onStateChange", "state", "Lcom/larus/voice_setting/voice/base/AppBarLayoutStateListener$State;", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onPause", "onResume", "exitSelectMode", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "checkStartSync", "enterPageTrace", "startFileMigration", "initViewModel", "checkAndSyncUnsynchronizedMedia", "mediaList", "", "Lcom/larus/bmhome/bigimg/MediaItem;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getValidMetadata", "Lcom/larus/avlink/gallery/model/MediaMetadata;", "metadata", "syncMediaToAlbum", "(Lcom/larus/avlink/gallery/model/MediaMetadata;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFileExifDateTime", "file", "Ljava/io/File;", "timestamp", "", "showEmptyView", "isSaveToGalleryEnabled", "showSharePanel", "updateSharePopupTitle", "onDestroyView", "setupSwipeMultiSelection", "beginSwipeSelection", "anchorPosition", "", "applySwipeSelection", "currentPosition", "onDelete", "map", "initView", "loadData", "setupInjectEntry", "refreshInjectEntry", "updateCalendarIndicator", "checkAndUpdateUI", "onDiff", "Lkotlin/Function2;", "showMediaDiff", "showDiffInternal", "showPermissionGuide", "onDefaultLanding", "onStartWifiRequested", "photoCnt", "videoCnt", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "onWifiConnecting", "onTransferStarted", "onProgressUpdated", "progress", "onTransferCompleted", "onError", "error", "onNoData", "onLowPower", "onRecording", "onNoSpace", "updateSyncBannerState", "Lcom/larus/avlink/model/BannerEvent;", "onSyncClicked", "openThumbDetailPage", "onWifiSettingRequested", "onTransferComplete", "onRequestPermission", "callback", "Lkotlin/Function1;", "onRecoveryStarted", "fileCount", "onRecoveryFailed", "mediaId", "reason", "onRecoveryCompleted", "Companion", "PhotoViewerUpdateCallback", "SwipeSelectionState", "SwipeSelectionMode", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MineAlbumFragment extends ProfileInfoBaseFragment implements com.larus.platform.api.x0, w88.a, AlbumSyncBanner.b, u98.a, com.larus.avlink.gallery.thumbnail.h0 {
    public static final /* synthetic */ int D = 0;
    public boolean A;
    public final f B;
    public final e C;
    public final String j;
    public LarusFragmentMineAlbumListBinding k;
    public PopupWindow l;
    public AlbumListAdapter m;
    public RecyclerViewSwipeMultiSelectHelper n;
    public final Set<String> o;
    public c p;
    public boolean q;
    public boolean r;
    public AlbumSyncBanner s;
    public GalleryViewModel t;
    public boolean u;
    public BigImageLocalPhotoViewerDialog v;
    public b w;
    public boolean x;
    public Job y;
    public v98.d z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/avlink/gallery/view/MineAlbumFragment$SwipeSelectionMode;", "", "<init>", "(Ljava/lang/String;I)V", "ADD", "REMOVE", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum SwipeSelectionMode extends Enum<SwipeSelectionMode> {
        public static final SwipeSelectionMode ADD = null;
        public static final SwipeSelectionMode REMOVE = null;
        public static final /* synthetic */ SwipeSelectionMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<SwipeSelectionMode> getEntries() {
            return b;
        }

        static {
            SwipeSelectionMode r0 = new SwipeSelectionMode("ADD", 0);
            ADD = r0;
            SwipeSelectionMode r1 = new SwipeSelectionMode("REMOVE", 1);
            REMOVE = r1;
            SwipeSelectionMode[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static SwipeSelectionMode[] values() {
            return (SwipeSelectionMode[]) a.clone();
        }

        public static SwipeSelectionMode valueOf(String r1) {
            return (SwipeSelectionMode) r27.a.a(SwipeSelectionMode.class, r1);
        }

        public SwipeSelectionMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(String r1, String r2, com.larus.bmhome.bigimg.t1 r3);
    }

    public static final class c {
        public final int a;
        public final Set<String> b;
        public final SwipeSelectionMode c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "SwipeSelectionState(anchorPosition=" + this.a + ", initialSelectedPaths=" + this.b + ", mode=" + this.c + ')';
        }

        public c(int r2, Set<String> r3, SwipeSelectionMode r4) {
            Intrinsics.checkNotNullParameter(r3, "initialSelectedPaths");
            Intrinsics.checkNotNullParameter(r4, "mode");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SwipeSelectionMode.values().length];
            r0[SwipeSelectionMode.ADD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[SwipeSelectionMode.REMOVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class e implements com.larus.avlink.gallery.view.f {
        public final /* synthetic */ MineAlbumFragment a;

        public static final class a implements com.larus.bmhome.bigimg.l1 {
            public final /* synthetic */ MineAlbumFragment a;
            public final /* synthetic */ Context b;

            public a(MineAlbumFragment r1, Context r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.larus.bmhome.bigimg.l1
            public final void a(Function0<Unit> r4, String r5) {
                Intrinsics.checkNotNullParameter(r4, "confirmCallback");
                Intrinsics.checkNotNullParameter(r5, "path");
                GalleryViewModel r0 = this.a.t;
                if (r0 == null) goto L6;
                r0.deleteSingleFile(this.b, StringsKt.removePrefix(r5, "file://"), r4);
                return;
            }
        }

        public static final class b implements b {
            public final /* synthetic */ MineAlbumFragment a;

            public b(MineAlbumFragment r1) {
                this.a = r1;
            }

            @Override // com.larus.avlink.gallery.view.MineAlbumFragment.b
            public final void a(String r2, String r3, com.larus.bmhome.bigimg.t1 r4) {
                Intrinsics.checkNotNullParameter(r2, "mediaId");
                Intrinsics.checkNotNullParameter(r3, "newPath");
                BigImageLocalPhotoViewerDialog r0 = this.a.v;
                if (r0 == null) goto L6;
                r0.m(r2, r3, r4);
                return;
            }
        }

        public e(MineAlbumFragment r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.avlink.gallery.view.p1] */
        public final void c(Context r13, int r14) {
            AlbumListAdapter r0 = this.a.m;
            if (r0 == null) goto L5;
            List r1 = r0.getCurrentList();
        L6:
            if (r1 != null) goto L8;
            return;
        L8:
            List r2 = r1;
            ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
            Iterator r4 = r2.iterator();
        L9:
            int r5 = 0;
            if (r4.hasNext() == false) goto L12;
            com.larus.bmhome.bigimg.t1 r6 = (com.larus.bmhome.bigimg.t1) r4.next();
            r3.add(com.larus.bmhome.bigimg.t1.a.a(r6, "file://" + r6.getPath(), false, false, 1021));
            goto L9
        L12:
            ArrayList r7 = new ArrayList();
            LarusFragmentMineAlbumListBinding r8 = this.a.k;
            if (r8 == null) goto L17;
            RecyclerView r9 = r8.d;
            if (r9 == null) goto L17;
            RecyclerView.LayoutManager r10 = r9.getLayoutManager();
        L18:
            if (r10 == null) goto L27;
            int r11 = r10.getChildCount();
        L20:
            if (r5 >= r11) goto L27;
            View r12 = r10.getChildAt(r5);
            if (r12 == null) goto L26;
            int r15 = r10.getPosition(r12);
            ImageViewWithLastMotion r16 = (ImageViewWithLastMotion) r12.findViewById(2131374931);
            if (r16 == null) goto L26;
            r7.add(new Pair(Integer.valueOf(r15), r16));
        L26:
            r5 = r5 + 1;
        L27:
            MineAlbumFragment r17 = this.a;
            List r18 = CollectionsKt.toList(r3);
            uo8.k r19 = new uo8.k(MapsKt.emptyMap(), null);
            final MineAlbumFragment r20 = this.a;
            r17.v = com.larus.bmhome.bigimg.k.d(r13, r7, r18, r14, r19, new a(r20, r13), new p1(r20), 32);
            MineAlbumFragment r110 = this.a;
            r110.w = new b(r110);
            return;
        L17:
            r10 = null;
            goto L18
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.larus.avlink.gallery.view.f
        public final void a(com.larus.bmhome.bigimg.t1 r3, int r4, View r5) {
            Intrinsics.checkNotNullParameter(r3, "item");
            Intrinsics.checkNotNullParameter(r5, "v");
            MineAlbumFragment r6 = this.a;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L17
            Context r1 = r6.getContext();     // Catch: Throwable -> L17
            if (r1 != null) goto L7;
        L15:
            Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
        L19:
            Throwable r8 = Result.exceptionOrNull-impl(r7);
            if (r8 == null) goto L25;
            FLogger.a.e("MineAlbumFragment", "Error occurred.", r8);
            return;
        L25:
            return;
        L7:
            if (r6.r == true) goto L9;
            c(r1, r4);     // Catch: Throwable -> L17
            goto L15
        L9:
            if (r3.d() == false) goto L11;
            return;
        L11:
            GalleryViewModel r9 = r6.t;     // Catch: Throwable -> L17
            if (r9 == null) goto L15;
            r9.toggleItemSelection(r3);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            r7 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L19
        }

        @Override // com.larus.avlink.gallery.view.f
        public final void b(com.larus.bmhome.bigimg.t1 r8, int r9, View r10, float r11, float r12) {
            Intrinsics.checkNotNullParameter(r8, "item");
            Intrinsics.checkNotNullParameter(r10, "v");
            if (AppHost.a.isTestChannel() == false) goto L6;
            t19.s.j(t19.s.a, r10.getContext(), "Current item: " + r8.g() + ", " + r8.getName(), null, false, 28);
        L6:
            if (r8.d() == false) goto L8;
            return;
        L8:
            MineAlbumFragment r0 = this.a;
            if (r0.r == true) goto L12;
            if (r9 == (-1)) goto L12;
            boolean r1 = true;
        L13:
            r0.q = r1;
            GalleryViewModel r2 = r0.t;
            if (r2 == null) goto L16;
            r2.handleLongClick(r8);
        L16:
            if (r1 == true) goto L18;
            return;
        L18:
            RecyclerViewSwipeMultiSelectHelper r13 = this.a.n;
            if (r13 == null) goto L25;
            float r3 = r10.getLeft() + r11;
            float r14 = r10.getTop() + r12;
            if (r9 == (-1)) goto L26;
            r13.b();
            r13.a();
            r13.m = r9;
            r13.n = r9;
            r13.o = r3;
            r13.p = r14;
            r13.q = r3;
            r13.r = r14;
            r13.t = true;
            return;
        L26:
            return;
        L25:
            return;
        L12:
            r1 = false;
            goto L13
        }
    }

    public static final class f implements t39.n {
        public final /* synthetic */ MineAlbumFragment a;

        public f(MineAlbumFragment r1) {
            this.a = r1;
        }

        public final void e(int r1, int r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "productName");
            FLogger.a.i("MineAlbumFragment", "onDoraLinkChanged: state=" + r1);
            if (r1 == (-1)) goto L9;
            if (r1 == 0) goto L9;
            if (r1 != 2) goto L15;
            MineAlbumFragment r5 = this.a;
            int r6 = MineAlbumFragment.D;
            r5.ba0(null);
            return;
        L15:
            return;
        L9:
            AlbumSyncBanner r7 = this.a.s;
            if (r7 == null) goto L14;
            r7.T5(z98.a.d.b);
            return;
        }
    }

    public static final class g implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public g(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.gallery.view.MineAlbumFragment$onViewCreated$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.view.MineAlbumFragment$onViewCreated$2", f = "MineAlbumFragment.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass2(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            GalleryStoragePolicyManager r5 = GalleryStoragePolicyManager.a;
            this.label = 1;
            r5.getClass();
            if (GalleryStoragePolicyManager.j(this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    @Override // u98.a
    public final void A10() {
        FLogger.a.i("MineAlbumFragment", "Hardware media sync: No new data");
        N30();
        Context r0 = getContext();
        if (r0 == null) goto L8;
        String r4 = r0.getString(2131902148);
        if (r4 == null) goto L9;
        t19.s.j(t19.s.a, getContext(), r4, null, false, 28);
        return;
    L9:
        return;
    }

    @Override // u98.a
    public final void Ff() {
        FLogger.a.i("MineAlbumFragment", "Hardware media sync: No new data");
    }

    @Override // u98.a
    public final void Mv() {
        FLogger.a.d("MineAlbumFragment", "Hardware media load: Transfer started");
        AlbumSyncBanner r0 = this.s;
        if (r0 == null) goto L6;
        r0.T5(z98.a.j.b);
        return;
    }

    @Override // u98.a
    public final void Po() {
        FLogger.a.i("MineAlbumFragment", "Hardware media load: Transfer completed");
        AlbumSyncBanner r0 = this.s;
        if (r0 == null) goto L5;
        r0.T5(z98.a.i.b);
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MineAlbumFragment$onTransferCompleted$1(this, null), 3, null);
    }

    @Override // u98.a
    public final void QR() {
        GalleryViewModel r0 = this.t;
        if (r0 == null) goto L6;
        r0.onRecoveryCompleted();
        return;
    }

    @Override // u98.a
    public final void V00() {
        FLogger.a.i("MineAlbumFragment", "Hardware media sync: Low power");
        AlbumSyncBanner r0 = this.s;
        if (r0 == null) goto L6;
        r0.T5(z98.a.e.b);
        return;
    }

    @Override // u98.a
    public final void WQ() {
        FLogger.a.i("MineAlbumFragment", "Hardware media sync: Recording");
        AlbumSyncBanner r0 = this.s;
        if (r0 == null) goto L6;
        r0.T5(z98.a.g.b);
        return;
    }

    @Override // com.larus.avlink.gallery.thumbnail.h0
    public final void ZA() {
        com.larus.avlink.gallery.l.a r0 = com.larus.avlink.gallery.l.a.get();
        if (r0 == null) goto L6;
        FLogger.a.i("MineAlbumFragment", "Found pending sync request from GalleryThumbnailFragment: photos=" + r0.a + ", videos=" + r0.b);
        da0(Integer.valueOf(r0.a), Integer.valueOf(r0.b));
        return;
    }

    public final void ca0() {
        if (this.u == false) goto L5;
        this.u = false;
        FLogger.a.i("MineAlbumFragment", "onResume: shouldAutoStartSync = true, check and auto start sync");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new MineAlbumFragment$checkStartSync$1(this, null), 2, null);
        return;
    L5:
        FLogger.a.i("MineAlbumFragment", "onResume: shouldAutoStartSync = false, normal check and update UI");
        ba0(null);
    }

    public final void ea0() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Boolean.valueOf(Keva.getRepo("dora_kv_env", 0).getBoolean("key_dataset_inject_enabled", false)));     // Catch: Throwable -> L4
    L6:
        Boolean r2 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = r2;
    L9:
        boolean r3 = ((Boolean) r1).booleanValue();
        LarusFragmentMineAlbumListBinding r4 = this.k;
        if (r4 == null) goto L19;
        AppCompatTextView r5 = r4.c;
        if (r5 == null) goto L20;
        if (r3 == false) goto L15;
        com.larus.utils.e1.x(r5);
        return;
    L15:
        com.larus.utils.e1.o(r5);
        return;
    L20:
        return;
    L19:
        return;
    L4:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public final RecyclerView getRecyclerView() {
        LarusFragmentMineAlbumListBinding r0 = this.k;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    public final void ha0() {
        AlbumSyncBanner r0 = this.s;
        if (r0 == null) goto L5;
        r0.T5(z98.a.f.b);
    L5:
        LarusFragmentMineAlbumListBinding r1 = this.k;
        ViewGroup.MarginLayoutParams r2 = null;
        if (r1 == null) goto L10;
        RecyclerView r3 = r1.d;
        if (r3 == null) goto L10;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
    L12:
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        r2 = (ViewGroup.MarginLayoutParams) r4;
    L14:
        if (r2 == null) goto L17;
        r2.topMargin = 0;
        return;
    L17:
        return;
    L10:
        r4 = null;
        goto L12
    }

    @Override // com.larus.avlink.gallery.view.AlbumSyncBanner.b
    public final void ib() {
        GalleryThumbnailFragment r0 = new GalleryThumbnailFragment();
        Intrinsics.checkNotNullParameter(this, "listener");
        r0.r = this;
        FragmentManager r1 = getChildFragmentManager();
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "AlbumBottomSheetDialog", r2);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r1, r0, r2) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r0.show(r1, "AlbumBottomSheetDialog");
        return;
    }

    public final void ja0() {
        PopupWindow r0 = this.l;
        if (r0 == null) goto L40;
        GalleryViewModel r1 = this.t;
        if (r1 == null) goto L7;
        int r2 = r1.getSelectedCount();
    L8:
        GalleryViewModel r3 = this.t;
        if (r3 == null) goto L13;
        LiveData<Boolean> r4 = r3.getHasSelectAll();
        if (r4 == null) goto L13;
        boolean r5 = Intrinsics.areEqual(r4.getValue(), Boolean.TRUE);
    L14:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        View r6 = r0.getContentView();
        TextView r7 = null;
        if (r6 == null) goto L17;
        FrameLayout r8 = (FrameLayout) r6.findViewById(2131362481);
    L18:
        View r9 = r0.getContentView();
        if (r9 == null) goto L21;
        r7 = (TextView) r9.findViewById(2131362482);
    L21:
        if (r2 != 0) goto L26;
        if (r8 == null) goto L24;
        r8.setAlpha(0.3f);
    L24:
        if (r7 == null) goto L31;
        r7.setText(AppHost.a.getApplication().getString(2131902451));
    L31:
        View r10 = r0.getContentView();
        if (r10 == null) goto L41;
        TextView r11 = (TextView) r10.findViewById(2131362478);
        if (r11 == null) goto L42;
        if (r5 == true) goto L37;
        String r12 = AppHost.a.getApplication().getString(2131902133);
    L38:
        r11.setText(r12);
        return;
    L37:
        r12 = AppHost.a.getApplication().getString(2131902104);
        goto L38
    L42:
        return;
    L41:
        return;
    L26:
        if (r2 <= 0) goto L31;
        if (r8 == null) goto L29;
        r8.setAlpha(1.0f);
    L29:
        if (r7 == null) goto L31;
        r7.setText(AppHost.a.getApplication().getString(2131902136, new Object[]{Integer.valueOf(r2)}));
        goto L31
    L17:
        r8 = null;
    L13:
        r5 = false;
        goto L14
    L7:
        r2 = 0;
        goto L8
    }

    public final void k00() {
        FLogger.a.i("MineAlbumFragment", "onDefaultLanding, isResumed=" + isResumed());
        this.u = true;
    }

    public final void onPause() {
        PopupWindow r0 = this.l;
        if (r0 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    L5:
        super.onPause();
        GalleryViewModel r1 = this.t;
        if (r1 == null) goto L8;
        r1.exitSelectMode();
    L8:
        this.A = false;
    }

    public final void showEmptyView() {
        LarusFragmentMineAlbumListBinding r0 = this.k;
        if (r0 == null) goto L9;
        LarusPageAlbumListEmptyBinding r1 = r0.b;
        if (r1 == null) goto L9;
        AppCompatImageView r2 = r1.b;
        if (r2 == null) goto L9;
        r2.setImageResource(DoraGResourceServiceDelegate.b.h());
    L9:
        IDoraService r3 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        boolean r4 = false;
        if (r3 == null) goto L16;
        VisionService r5 = r3.V();
        if (r5 == null) goto L16;
        if (r5.q() != true) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L21;
        String r7 = ia8.b.a;
        if (ia8.b.a(AppHost.a.getApplication()) == true) goto L21;
        r4 = true;
    L21:
        if (r4 == true) goto L29;
        LarusFragmentMineAlbumListBinding r8 = this.k;
        if (r8 == null) goto L36;
        LarusPageAlbumListEmptyBinding r9 = r8.b;
        if (r9 == null) goto L36;
        AppCompatTextView r10 = r9.c;
        if (r10 == null) goto L36;
        int r11 = com.larus.utils.j0.a;
        r10.setText(com.larus.utils.j0.d(2131902106));
    L36:
        LarusFragmentMineAlbumListBinding r12 = this.k;
        if (r12 == null) goto L44;
        LarusPageAlbumListEmptyBinding r13 = r12.b;
        if (r13 == null) goto L45;
        ConstraintLayout r14 = r13.a;
        if (r14 == null) goto L46;
        com.larus.utils.e1.x(r14);
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L29:
        LarusFragmentMineAlbumListBinding r15 = this.k;
        if (r15 == null) goto L36;
        LarusPageAlbumListEmptyBinding r16 = r15.b;
        if (r16 == null) goto L36;
        AppCompatTextView r17 = r16.c;
        if (r17 == null) goto L36;
        int r18 = com.larus.utils.j0.a;
        r17.setText(com.larus.utils.j0.d(2131902155));
    L16:
        r6 = false;
        goto L17
    }

    public MineAlbumFragment() {
        this.j = "MineAlbumFragment" + hashCode();
        this.o = new LinkedHashSet();
        this.A = true;
        this.B = new f(this);
        this.C = new e(this);
    }

    @Override // u98.a
    public final void N30() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), Dispatchers.getMain().getImmediate(), null, new MineAlbumFragment$showMediaDiff$1(this, null), 2, null);
    }

    @Override // com.larus.avlink.gallery.view.AlbumSyncBanner.b
    public final void TF() {
        Context r0 = getContext();
        if (r0 == null) goto L36;
        int r1 = ja8.g.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        boolean r2 = false;
        Intent r5 = new Intent("android.settings.WIFI_SETTINGS");     // Catch: Exception -> L7
        r5.setFlags(268435456);     // Catch: Exception -> L7
        r0.startActivity(r5);     // Catch: Exception -> L7
        boolean r6 = true;
    L9:
        if (r6 == false) goto L32;
        FLogger.a.i("WiFiSettingsUtil", "Successfully opened WiFi settings directly");     // Catch: Exception -> L27
        return;
    L32:
        Intent r7 = new Intent("android.settings.WIRELESS_SETTINGS");     // Catch: Exception -> L14
        r7.setFlags(268435456);     // Catch: Exception -> L14
        r0.startActivity(r7);     // Catch: Exception -> L14
        boolean r8 = true;
    L16:
        if (r8 == false) goto L30;
        FLogger.a.i("WiFiSettingsUtil", "Successfully opened wireless settings");     // Catch: Exception -> L27
        return;
    L30:
        Intent r9 = new Intent("android.settings.SETTINGS");     // Catch: Exception -> L21
        r9.setFlags(268435456);     // Catch: Exception -> L21
        r0.startActivity(r9);     // Catch: Exception -> L21
        r2 = true;
    L23:
        if (r2 == false) goto L25;
        FLogger.a.i("WiFiSettingsUtil", "Successfully opened general settings as fallback");     // Catch: Exception -> L27
        return;
    L25:
        FLogger.a.e("WiFiSettingsUtil", "Failed to open any settings page");     // Catch: Exception -> L27
        return;
    L21:
        e = move-exception;
        FLogger.a.w("WiFiSettingsUtil", "Failed to open general settings: " + e.getMessage());     // Catch: Exception -> L27
        goto L23
    L14:
        e = move-exception;
        FLogger.a.w("WiFiSettingsUtil", "Failed to open wireless settings: " + e.getMessage());     // Catch: Exception -> L27
        r8 = false;
        goto L16
    L7:
        e = move-exception;
        FLogger.a.w("WiFiSettingsUtil", "Failed to open WiFi settings directly: " + e.getMessage());     // Catch: Exception -> L27
        r6 = false;
    L27:
        e = move-exception;
        FLogger.a.e("WiFiSettingsUtil", "Exception when opening WiFi settings: " + e.getMessage());
        return;
    }

    public final void onDestroyView() {
        com.larus.voice_setting.voice.base.a r0 = getParentFragment();
        if ((r0 instanceof com.larus.voice_setting.voice.base.a) == false) goto L5;
        com.larus.voice_setting.voice.base.a r1 = r0;
    L7:
        if (r1 == null) goto L9;
        r1.n40(true);
    L9:
        PopupWindow r2 = this.l;
        if (r2 == null) goto L12;
        PopupWindowLancet.handleDismissBeforeOrigin(r2);
        r2.dismiss();
    L12:
        v98.d r3 = this.z;
        if (r3 == null) goto L15;
        r3.d = null;
        r3.a(0);
    L15:
        super.onDestroyView();
        RecyclerViewSwipeMultiSelectHelper r4 = this.n;
        if (r4 == null) goto L18;
        r4.b();
        r4.a.removeOnItemTouchListener(r4);
        r4.a();
    L18:
        this.n = null;
        this.z = null;
        this.p = null;
        Job r5 = this.y;
        if (r5 == null) goto L21;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L21:
        this.y = null;
        MediaSyncExecutor.i = null;
        FLogger.a.d("MediaSyncExecutor", "Removed delete listener");
        IDoraService r6 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r6 == null) goto L24;
        r6.q0(this.B);
    L24:
        MediaSyncCoordinator r7 = MediaSyncCoordinator.a;
        MediaSyncCoordinator.x(this);
        GalleryViewModel r8 = this.t;
        if (r8 == null) goto L28;
        r8.unregisterMediaLifecycleListener();
        return;
    L28:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void onResume() {
        super.onResume();
        GalleryViewModel r0 = this.t;
        if (r0 == null) goto L5;
        String r1 = ia8.b.a;
        r0.updatePermissionState(ia8.b.a(getContext()));
    L5:
        GalleryViewModel r2 = this.t;
        if (r2 == null) goto L9;
        r2.loadLocalMedia();
    L9:
        if (this.A == true) goto L11;
        ca0();
    L11:
        MediaSyncExecutor r3 = MediaSyncExecutor.a;
        MediaSyncExecutor.c(null);
        ea0();
    }

    public final String tag() {
        return this.j;
    }

    @Override // u98.a
    public final void RK(int r4) {
        FLogger.a.d("MineAlbumFragment", "Hardware media load: Progress " + r4 + '%');
        AlbumSyncBanner r0 = this.s;
        if (r0 == null) goto L5;
        r0.T5(z98.a.j.b);
    L5:
        GalleryViewModel r1 = this.t;
        if (r1 == null) goto L9;
        r1.updateSyncProgress(r4);
        return;
    }

    public final void U90(AppBarLayoutStateListener.State r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        if (r2 != AppBarLayoutStateListener.State.COLLAPSED) goto L9;
        LarusFragmentMineAlbumListBinding r3 = this.k;
        if (r3 == null) goto L15;
        AppCompatTextView r4 = r3.h;
        if (r4 == null) goto L16;
        com.larus.utils.e1.x(r4);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        LarusFragmentMineAlbumListBinding r5 = this.k;
        if (r5 == null) goto L18;
        AppCompatTextView r6 = r5.h;
        if (r6 == null) goto L19;
        com.larus.utils.e1.o(r6);
        return;
    L19:
        return;
    }

    @Override // u98.a
    public final void VD(int r2) {
        GalleryViewModel r0 = this.t;
        if (r0 == null) goto L6;
        r0.onRecoveryStarted(r2);
        return;
    }

    public final void ba0(Function2<? super Integer, ? super Integer, Unit> r8) {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        boolean r1 = false;
        if (r0 == null) goto L9;
        DeviceService r2 = r0.device();
        if (r2 == null) goto L9;
        if (r2.u() != 2) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L26;
        AlbumSyncBanner r4 = this.s;
        if (r4 != null) goto L14;
    L16:
        if (r1 == false) goto L24;
        AlbumSyncBanner r9 = this.s;
        if (r9 == null) goto L27;
        LifecycleOwner r5 = r9.c;
        if (r5 == null) goto L28;
        LifecycleCoroutineScope r6 = LifecycleOwnerKt.getLifecycleScope(r5);
        if (r6 == null) goto L29;
        BuildersKt.launch$default(r6, null, null, new AlbumSyncBanner$eraseError$1(r9, null), 3, null);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L24:
        ga0(r8);
        return;
    L14:
        if (r4.V5() != true) goto L16;
        r1 = true;
        goto L16
    L26:
        return;
    L9:
        r3 = false;
        goto L10
    }

    @Override // com.larus.avlink.gallery.view.AlbumSyncBanner.b
    public final void bj(final Function1<? super Boolean, Unit> r2) {
        ia8.b.b(this, new h1(this, r2));
    }

    public final void ga0(Function2<? super Integer, ? super Integer, Unit> r5) {
        LarusFragmentMineAlbumListBinding r0 = this.k;
        Pair r1 = null;
        if (r0 == null) goto L7;
        RecyclerView r2 = r0.d;
        if (r2 == null) goto L7;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
    L9:
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
    L12:
        boolean r6 = false;
        if (r4 == null) goto L40;
        r4.topMargin = 0;
    L40:
        IDoraService r7 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L37
        if (r7 == null) goto L20;
        VisionService r8 = r7.V();     // Catch: Exception -> L37
        if (r8 == null) goto L20;
        r1 = r8.l();     // Catch: Exception -> L37
    L20:
        if (r1 != null) goto L22;
    L28:
        GalleryViewModel r9 = this.t;     // Catch: Exception -> L37
        if (r9 != null) goto L31;
    L33:
        if (r6 == false) goto L35;
        ha0();     // Catch: Exception -> L37
        return;
    L35:
        m40(z98.a.c.b);     // Catch: Exception -> L37
        return;
    L31:
        if (r9.shouldShowPermissionGuide() != true) goto L33;
        r6 = true;
        goto L33
    L22:
        if (((Number) r1.getSecond()).intValue() == 0) goto L24;
    L25:
        m40(new z98.a.h(((Number) r1.getFirst()).intValue(), ((Number) r1.getSecond()).intValue()));     // Catch: Exception -> L37
        if (r5 == null) goto L41;
        r5.invoke(r1.getFirst(), r1.getSecond());     // Catch: Exception -> L37
        return;
    L41:
        return;
    L24:
        if (((Number) r1.getFirst()).intValue() == 0) goto L28;
    L37:
        e = move-exception;
        FLogger.a.e(GalleryViewModel.TAG, "Error getting media diff: " + e.getMessage(), e);
        return;
    L11:
        r4 = null;
    L7:
        r3 = null;
        goto L9
    }

    @Override // u98.a
    public final void m40(z98.a r7) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new MineAlbumFragment$updateSyncBannerState$1(r7, this, null), 2, null);
    }

    @Override // u98.a
    public final void onError(String r3) {
        Intrinsics.checkNotNullParameter(r3, "error");
        FLogger.a.e("MineAlbumFragment", "Hardware media sync: Error - ".concat(r3));
        AlbumSyncBanner r4 = this.s;
        if (r4 == null) goto L6;
        r4.T5(z98.a.n.b);
        return;
    }

    public final void qU(final List<String> r14) {
        Intrinsics.checkNotNullParameter(r14, "map");
        ArrayList r0 = (ArrayList) r14;
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        FLogger r1 = FLogger.a;
        r1.i("MineAlbumFragment", "onDelete received " + r0.size() + " paths");
        StringBuilder r2 = new StringBuilder("onDelete paths: ");
        r2.append(CollectionsKt.joinToString$default(r14, "\n  ", null, null, 0, null, null, 62, null));
        r1.d("MineAlbumFragment", r2.toString());
        com.larus.utils.y.c(new x0(this, r14));
    }

    public static void fa0(PolarisFileWrapper r9, long r10) {
        String r3 = FilesKt.getExtension(r9);     // Catch: Exception -> L26
        Locale r4 = Locale.ROOT;     // Catch: Exception -> L26
        if (CollectionsKt.listOf(new String[]{"jpg", "jpeg", "png", "webp"}).contains(r3.toLowerCase(r4)) == true) goto L7;
        return;
    L7:
        if (r9.exists() == true) goto L9;
    L24:
        FLogger.a.w("MineAlbumFragment", "Skip EXIF write, file not writable: " + r9.getAbsolutePath());     // Catch: Exception -> L26
        return;
    L9:
        if (r9.canWrite() == false) goto L24;
        RandomAccessFile r2 = new RandomAccessFile(r9, "rw");     // Catch: Exception -> L26
        ExifInterface r5 = new ExifInterface(r2.getFD());     // Catch: Throwable -> L19
        String r11 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", r4).format(new Date(r10 * ((long) 1000)));     // Catch: Throwable -> L19
        r5.setAttribute("DateTime", r11);     // Catch: Throwable -> L19
        if (Build.VERSION.SDK_INT < 24) goto L15;
        r5.setAttribute("DateTimeOriginal", r11);     // Catch: Throwable -> L19
        r5.setAttribute("DateTimeDigitized", r11);     // Catch: Throwable -> L19
    L15:
        r5.saveAttributes();     // Catch: Throwable -> L19
        FLogger.a.d("MineAlbumFragment", "Successfully set EXIF date for " + r9.getName() + " to: " + r11);     // Catch: Throwable -> L19
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        CloseableKt.closeFinally(r2, null);     // Catch: Exception -> L26
        return;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Exception -> L26
        throw th;     // Catch: Exception -> L26
    L26:
        e = move-exception;
        FLogger.a.e("MineAlbumFragment", "Failed to set EXIF date for " + r9.getName() + ": " + e.getMessage(), e);
    }

    public final void aa0(int r6, int r7) {
        c r0 = this.p;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.a == r6) goto L8;
        return;
    L8:
        AlbumListAdapter r8 = this.m;
        if (r8 == null) goto L46;
        List r9 = r8.getCurrentList();
        if (r9 != null) goto L14;
        return;
    L14:
        if (r9.isEmpty() == false) goto L16;
        return;
    L16:
        int r1 = Math.min(r0.a, r7);
        int r10 = Math.max(r0.a, r7);
        boolean r3 = false;
        if (r1 >= 0) goto L19;
    L21:
        boolean r4 = false;
    L22:
        if (r4 == false) goto L47;
        if (r10 >= 0) goto L25;
    L27:
        if (r3 == false) goto L50;
        List r11 = r9.subList(r1, r10 + 1);
        LinkedHashSet r12 = new LinkedHashSet();
        Iterator r13 = r11.iterator();
    L31:
        if (r13.hasNext() == false) goto L33;
        r12.add(((com.larus.bmhome.bigimg.t1) r13.next()).getPath());
        goto L31
    L33:
        Set<String> r14 = CollectionsKt.toMutableSet(r0.b);
        SwipeSelectionMode r2 = r0.c;
        int r5 = d.a[r2.ordinal()];
        if (r5 != 1) goto L36;
        r14.addAll(r12);
    L41:
        GalleryViewModel r15 = this.t;
        if (r15 == null) goto L48;
        r15.applySelectedPaths(r14);
        return;
    L48:
        return;
    L36:
        if (r5 != 2) goto L39;
        r14.removeAll(r12);
        goto L41
    L39:
        throw new NoWhenBranchMatchedException();
    L50:
        return;
    L25:
        if (r10 >= r9.size()) goto L27;
        r3 = true;
        goto L27
    L47:
        return;
    L19:
        if (r1 >= r9.size()) goto L21;
        r4 = true;
        goto L22
    }

    public final void da0(Integer r4, Integer r5) {
        FLogger r0 = FLogger.a;
        r0.i("MineAlbumFragment", "Starting UI sync via HardwareMediaLoadService");
        if (com.larus.avlink.gallery.f.a() == false) goto L7;
        m40(z98.a.e.b);
        r0.i("MineAlbumFragment", "Low battery mode, skipping sync");
        return;
    L7:
        if (b98.b.b(3) == false) goto L10;
        m40(z98.a.g.b);
        r0.i("MineAlbumFragment", "Video recording, skipping sync");
        return;
    L10:
        MediaSyncCoordinator.a.u(MediaSyncCoordinator.SyncMode.MANUAL, true, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object ia0(MediaMetadata r46, Continuation<? super Unit> r47) {
        if ((r47 instanceof MineAlbumFragment$syncMediaToAlbum$1) == false) goto L7;
        MineAlbumFragment$syncMediaToAlbum$1 r6 = (MineAlbumFragment$syncMediaToAlbum$1) r47;
        int r7 = r6.label;
        if ((r7 & Integer.MIN_VALUE) == 0) goto L7;
        r6.label = r7 - Integer.MIN_VALUE;
    L8:
        Object r0 = r6.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r9 = r6.label;
        if (r9 == 0) goto L18;
        if (r9 != 1) goto L17;
        String r10 = (String) r6.L$2;
        ContentResolver r11 = (ContentResolver) r6.L$1;
        MediaMetadata r12 = (MediaMetadata) r6.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L14
        MediaMetadata r13 = r12;
    L25:
        MediaMetadata r1 = (MediaMetadata) r0;     // Catch: Exception -> L73
        if (r1 != null) goto L28;
        MediaMetadata r14 = r13;
    L29:
        Long r2 = r14.getSystemGalleryId();     // Catch: Exception -> L73
        String r15 = r14.getFinalFilePath();     // Catch: Exception -> L73
        if (r15 != null) goto L33;
        r15 = r14.getFilePath();     // Catch: Exception -> L73
    L33:
        if (r15.length() != 0) goto L35;
        boolean r16 = true;
    L85:
        if (r16 == false) goto L38;
    L71:
        FLogger.a.e("MineAlbumFragment", "File not found: ".concat(r15));     // Catch: Exception -> L59
        return Unit.INSTANCE;
    L38:
        if (m5.c(r15) == false) goto L71;
        long r17 = 0;
        if (r2 == null) goto L51;
        if (r2.longValue() <= 0) goto L51;
        Intrinsics.checkNotNull(r11);     // Catch: Exception -> L73
        if (com.larus.avlink.gallery.c.i(r11, r2.toString()) == false) goto L48;
        FLogger.a.d("MineAlbumFragment", "Media already synced: " + r10 + ", systemGalleryId: " + r2);     // Catch: Exception -> L73
        return Unit.INSTANCE;
    L48:
        FLogger.a.i("MineAlbumFragment", "Media was deleted from album, re-syncing: " + r10);     // Catch: Exception -> L73
    L51:
        long r4 = r14.getCreateTime() / ((long) 1000);     // Catch: Exception -> L59
        PolarisFileWrapper r3 = new PolarisFileWrapper(r15);     // Catch: Exception -> L59
        String r18 = r14.getMediaType();     // Catch: Exception -> L59
        if (r18 != null) goto L54;
    L56:
        boolean r19 = false;
    L57:
        if (r19 == false) goto L61;
        fa0(r3, r4);     // Catch: Exception -> L59
    L61:
        Intrinsics.checkNotNull(r11);     // Catch: Exception -> L59
        Uri r5 = com.larus.avlink.gallery.c.f(r11, r3.getName(), r3.getAbsolutePath(), r14);     // Catch: Exception -> L59
        if (r5 != null) goto L65;
        FLogger.a.e("MineAlbumFragment", "Failed to insert media file: " + r3.getName());     // Catch: Exception -> L59
        return Unit.INSTANCE;
    L65:
        String r20 = r5.getLastPathSegment();     // Catch: Exception -> L59
        if (r20 == null) goto L70;
        Long r21 = StringsKt.toLongOrNull(r20);     // Catch: Exception -> L59
        if (r21 == null) goto L70;
        r17 = r21.longValue();     // Catch: Exception -> L59
    L70:
        long r22 = r17;
        AlbumDataBaseHelper r23 = AlbumDataBaseHelper.a;     // Catch: Exception -> L59
        MediaMetadata r24 = MediaMetadata.copy$default(r14, null, 0, Boxing.boxLong(r22), null, null, null, 0, 0, 0, 0, 0, 0.0d, 0, null, null, null, null, null, null, null, null, null, null, 0, 16777211, null);     // Catch: Exception -> L59
        r23.getClass();     // Catch: Exception -> L59
        AlbumDataBaseHelper.A(r24);     // Catch: Exception -> L59
        FLogger.a.i("MineAlbumFragment", "Successfully synced media: " + r10 + ", uri=" + r5 + ", systemGalleryId: " + r22);     // Catch: Exception -> L59
    L79:
        return Unit.INSTANCE;
    L54:
        if (StringsKt.contains$default(r18, "image", false, 2, null) != true) goto L56;
        r19 = true;
    L59:
        e = e;
        String r110 = r16;
    L77:
        FLogger.a.e(r110, "Exception syncing media " + r13.getUniqId() + ": " + e.getMessage(), e);
        goto L79
    L35:
        r16 = false;
        goto L85
    L28:
        r14 = r1;
    L14:
        e = e;
        r13 = r12;
    L74:
        r110 = "MineAlbumFragment";
        goto L77
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        r11 = AppHost.a.getApplication().getContentResolver();     // Catch: Exception -> L75
        String r25 = r46.getUniqId();     // Catch: Exception -> L75
        AlbumDataBaseHelper r111 = AlbumDataBaseHelper.a;     // Catch: Exception -> L75
        r13 = r46;
        r6.L$0 = r13;     // Catch: Exception -> L73
        r6.L$1 = r11;     // Catch: Exception -> L73
        r6.L$2 = r25;     // Catch: Exception -> L73
        r6.label = 1;     // Catch: Exception -> L73
        Object r26 = r111.o(r25, r6);     // Catch: Exception -> L73
        if (r26 != r8) goto L24;
        return r8;
    L24:
        r10 = r25;
        r0 = r26;
    L73:
        e = e;
    L75:
        e = e;
        r13 = r46;
    L7:
        r6 = new MineAlbumFragment$syncMediaToAlbum$1(this, r47);
        goto L8
    }

    public final void onViewCreated(View r18, Bundle r19) {
        Intrinsics.checkNotNullParameter(r18, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r18, r19);
        r18.getViewTreeObserver().addOnWindowFocusChangeListener(new m0(this));
        MediaSyncExecutor r1 = MediaSyncExecutor.a;
        Intrinsics.checkNotNullParameter(this, "listener");
        MediaSyncExecutor.i = this;
        FLogger r2 = FLogger.a;
        r2.d("MediaSyncExecutor", "Registered delete listener");
        IDoraService r3 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r3 == null) goto L5;
        r3.G(this.B);
    L5:
        MediaSyncCoordinator r4 = MediaSyncCoordinator.a;
        MediaSyncCoordinator.p(this);
        MediaSyncCoordinator.f = MediaSyncCoordinator.SyncMode.MANUAL;
        OnBackPressedCallback r5 = new MineAlbumFragment$initView$callback$1(this);
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L10;
        OnBackPressedDispatcher r7 = r6.getOnBackPressedDispatcher();
        if (r7 == null) goto L10;
        r7.addCallback(getViewLifecycleOwner(), r5);
    L10:
        LarusFragmentMineAlbumListBinding r8 = this.k;
        if (r8 == null) goto L15;
        RecyclerView r9 = r8.d;
        if (r9 == null) goto L15;
        this.z = new v98.d(r9, i5.h0());
        r9.setLayoutManager(new GridLayoutManager(r9.getContext(), 3));
        r9.setItemAnimator(null);
        AlbumListAdapter r10 = new AlbumListAdapter(LifecycleOwnerKt.getLifecycleScope(this), this.C);
        this.m = r10;
        r9.setAdapter(r10);
        r9.setItemViewCacheSize(10);
        r9.addItemDecoration(new GridSpacingItemDecoration(i5.z(), Boolean.FALSE));
    L15:
        LarusFragmentMineAlbumListBinding r11 = this.k;
        if (r11 == null) goto L24;
        RecyclerView r12 = r11.d;
        if (r12 == null) goto L24;
        RecyclerViewSwipeMultiSelectHelper r13 = this.n;
        if (r13 == null) goto L23;
        r13.b();
        r13.a.removeOnItemTouchListener(r13);
        r13.a();
    L23:
        Function0 r14 = new c1(this);
        MineAlbumFragment$setupSwipeMultiSelection$2 r15 = new MineAlbumFragment$setupSwipeMultiSelection$2(this);
        MineAlbumFragment$setupSwipeMultiSelection$3 r16 = new MineAlbumFragment$setupSwipeMultiSelection$3(this);
        Function0 r17 = new d1(this);
        Function0 r110 = new e1(this);
        Resources r20 = r12.getResources();
        this.n = new RecyclerViewSwipeMultiSelectHelper(r12, r14, r15, r16, r17, r110, Float.valueOf(WindowDisplayMetricsOverride.apply(r20, r20.getDisplayMetrics()).density * 32.0f));
    L24:
        LarusFragmentMineAlbumListBinding r21 = this.k;
        if (r21 == null) goto L29;
        RecyclerView r22 = r21.d;
        if (r22 == null) goto L29;
        r22.addOnScrollListener(new MineAlbumFragment$initView$2(this));
    L29:
        X90();
        LarusFragmentMineAlbumListBinding r23 = this.k;
        if (r23 == null) goto L32;
        AlbumSyncBanner r24 = r23.f;
    L33:
        this.s = r24;
        if (r24 == null) goto L36;
        r24.setSyncActionHandler(this);
    L36:
        AlbumSyncBanner r25 = this.s;
        if (r25 == null) goto L40;
        r25.setLifecycleOwner(this);
    L40:
        if (getParentFragment() != null) goto L42;
        this.x = true;
    L42:
        LarusFragmentMineAlbumListBinding r26 = this.k;
        if (r26 == null) goto L47;
        AppCompatTextView r27 = r26.c;
        if (r27 == null) goto L47;
        com.larus.utils.e1.d(r27, new g1(this));
    L47:
        ea0();
        Bundle r28 = getArguments();
        if (r28 == null) goto L56;
        String r29 = r28.getString("auto_sync");
        if (r29 == null) goto L56;
        if (Intrinsics.areEqual(r29, "true") == false) goto L56;
        View r30 = getView();
        if (r30 == null) goto L56;
        r30.postDelayed(new t0(this), 500);
    L56:
        GalleryViewModel r31 = (GalleryViewModel) new ViewModelProvider(this).get(GalleryViewModel.class);
        this.t = r31;
        if (r31 == null) goto L59;
        r31.registerMediaLifecycleListener();
    L59:
        GalleryViewModel r32 = this.t;
        if (r32 == null) goto L64;
        LiveData<List<com.larus.bmhome.bigimg.t1>> r33 = r32.getLocalMediaList();
        if (r33 == null) goto L64;
        r33.observe(getViewLifecycleOwner(), new g(new i1(this)));
    L64:
        GalleryViewModel r34 = this.t;
        if (r34 == null) goto L69;
        LiveData<Boolean> r35 = r34.getLocalMediaLoadResult$dora_avlink_impl_release();
        if (r35 == null) goto L69;
        r35.observe(getViewLifecycleOwner(), new g(new m1(this)));
    L69:
        GalleryViewModel r36 = this.t;
        if (r36 == null) goto L74;
        LiveData<Boolean> r37 = r36.getShowEmpty();
        if (r37 == null) goto L74;
        r37.observe(getViewLifecycleOwner(), new g(new n1(this)));
    L74:
        GalleryViewModel r38 = this.t;
        if (r38 == null) goto L79;
        LiveData<Set<String>> r39 = r38.getSelectedItems();
        if (r39 == null) goto L79;
        r39.observe(getViewLifecycleOwner(), new g(new o1(this)));
    L79:
        GalleryViewModel r40 = this.t;
        if (r40 == null) goto L84;
        LiveData<Boolean> r41 = r40.getHasSelectAll();
        if (r41 == null) goto L84;
        r41.observe(getViewLifecycleOwner(), new g(new n0(this)));
    L84:
        GalleryViewModel r42 = this.t;
        if (r42 == null) goto L89;
        LiveData<Boolean> r43 = r42.isSelectMode();
        if (r43 == null) goto L89;
        r43.observe(getViewLifecycleOwner(), new g(new o0(this)));
    L89:
        GalleryViewModel r44 = this.t;
        if (r44 == null) goto L94;
        LiveData<Integer> r45 = r44.getSyncProgress();
        if (r45 == null) goto L94;
        r45.observe(getViewLifecycleOwner(), new g(new p0(this)));
    L94:
        GalleryViewModel r46 = this.t;
        if (r46 == null) goto L99;
        LiveData<Boolean> r47 = r46.getPermissionGranted();
        if (r47 == null) goto L99;
        r47.observe(getViewLifecycleOwner(), new g(new q0(this)));
    L99:
        GalleryViewModel r48 = this.t;
        if (r48 == null) goto L104;
        LiveData<AlbumDeleteDialog> r49 = r48.getDeleteDialogEvent();
        if (r49 == null) goto L104;
        r49.observe(getViewLifecycleOwner(), new g(new r0(this)));
    L104:
        GalleryViewModel r50 = this.t;
        if (r50 == null) goto L109;
        LiveData<CommonDialog> r51 = r50.getSimpleDialogEvent();
        if (r51 == null) goto L109;
        r51.observe(getViewLifecycleOwner(), new g(new s0(this)));
    L109:
        GalleryViewModel r52 = this.t;
        if (r52 == null) goto L114;
        LiveData<Boolean> r53 = r52.getShowSharePanelEvent();
        if (r53 == null) goto L114;
        r53.observe(getViewLifecycleOwner(), new g(new j1(this)));
    L114:
        GalleryViewModel r54 = this.t;
        if (r54 == null) goto L119;
        LiveData<GalleryViewModel.b> r55 = r54.getMediaReplaceEvent();
        if (r55 == null) goto L119;
        r55.observe(getViewLifecycleOwner(), new g(new k1(this)));
    L119:
        GalleryViewModel r56 = this.t;
        if (r56 == null) goto L124;
        LiveData<String> r57 = r56.getSingleFileDeletedEvent();
        if (r57 == null) goto L124;
        r57.observe(getViewLifecycleOwner(), new g(new l1(this)));
    L124:
        r2.i(this.j, "[loadData] - delegating to ViewModel");
        LarusFragmentMineAlbumListBinding r58 = this.k;
        if (r58 == null) goto L131;
        LarusAccountDialogBinding r59 = r58.e;
        if (r59 == null) goto L131;
        ConstraintLayout r60 = r59.a;
        if (r60 == null) goto L131;
        com.larus.utils.e1.x(r60);
    L131:
        GalleryViewModel r61 = this.t;
        if (r61 == null) goto L134;
        r61.loadLocalMedia();
    L134:
        com.larus.avlink.gallery.e.a.getClass();
        com.larus.avlink.gallery.e.a();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass2(null), 2, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new MineAlbumFragment$startFileMigration$1(null), 2, null);
        Bundle r62 = getArguments();
        if (r62 == null) goto L141;
        String r63 = r62.getString("previous_page");
        if (r63 == null) goto L141;
        Map r64 = MapsKt.mapOf(new Pair[]{TuplesKt.to("previous_page", r63), TuplesKt.to("current_page", "dora_album")});
        IDoraService r65 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r65 == null) goto L141;
        r65.A0("enter_page", r64);
    L141:
        ca0();
        return;
    L32:
        r24 = null;
        goto L33
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x009e -> B:32:0x00a3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x0192 -> B:86:0x0196). Please report as a decompilation issue!!! */
    public static final Object Z90(MineAlbumFragment r18, List r19, Continuation r20) {
        r18.getClass();
        if ((r20 instanceof MineAlbumFragment$checkAndSyncUnsynchronizedMedia$1) == false) goto L7;
        MineAlbumFragment$checkAndSyncUnsynchronizedMedia$1 r1 = (MineAlbumFragment$checkAndSyncUnsynchronizedMedia$1) r20;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
        MineAlbumFragment r3 = r18;
    L8:
        Object r0 = r1.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r1.label;
        boolean r9 = false;
        if (r5 == 0) goto L22;
        if (r5 == 1) goto L19;
        if (r5 != 2) goto L18;
        MediaMetadata r6 = (MediaMetadata) r1.L$2;
        Iterator r10 = (Iterator) r1.L$1;
        List r11 = (List) r1.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L15
    L86:
        FLogger.a.d("MineAlbumFragment", "Synced media: " + r6.getUniqId());     // Catch: Exception -> L15
    L77:
        if (r10.hasNext() == false) goto L93;
        r6 = (MediaMetadata) r10.next();     // Catch: Exception -> L96 CancellationException -> L98
        JobKt.ensureActive(r1.getContext());     // Catch: Exception -> L96 CancellationException -> L98
        Long r7 = r6.getSystemGalleryId();     // Catch: Exception -> L15
        if (r7 == null) goto L83;
        if (r7.longValue() > 0) goto L77;
    L83:
        r1.L$0 = r11;     // Catch: Exception -> L15
        r1.L$1 = r10;     // Catch: Exception -> L15
        r1.L$2 = r6;     // Catch: Exception -> L15
        r1.label = 2;     // Catch: Exception -> L15
        if (r3.ia0(r6, r1) != r4) goto L86;
    L115:
        return r4;
    L93:
        FLogger.a.i("MineAlbumFragment", "Completed syncing " + r11.size() + " media to system gallery");     // Catch: Exception -> L96 CancellationException -> L98
    L100:
        return Unit.INSTANCE;
    L15:
        e = move-exception;
        FLogger r12 = FLogger.a;     // Catch: Exception -> L96 CancellationException -> L98
        StringBuilder r13 = new StringBuilder();     // Catch: Exception -> L96 CancellationException -> L98
        r13.append("Failed to sync media ");     // Catch: Exception -> L96 CancellationException -> L98
        if (r6 == null) goto L91;
        String r8 = r6.getUniqId();     // Catch: Exception -> L96 CancellationException -> L98
    L92:
        r13.append(r8);     // Catch: Exception -> L96 CancellationException -> L98
        r13.append(": ");     // Catch: Exception -> L96 CancellationException -> L98
        r13.append(e.getMessage());     // Catch: Exception -> L96 CancellationException -> L98
        r12.e("MineAlbumFragment", r13.toString(), e);     // Catch: Exception -> L96 CancellationException -> L98
        goto L77
    L91:
        r8 = null;
        goto L92
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        Iterator r14 = (Iterator) r1.L$1;
        Collection r15 = (Collection) r1.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L96 CancellationException -> L98
    L32:
        MediaMetadata r16 = (MediaMetadata) r0;     // Catch: Exception -> L96 CancellationException -> L98
        if (r16 == null) goto L35;
        Long r17 = r16.getSystemGalleryId();     // Catch: Exception -> L96 CancellationException -> L98
    L36:
        if (r16 != null) goto L38;
    L40:
        boolean r110 = false;
    L41:
        if (r110 == false) goto L53;
        if (r17 != null) goto L45;
    L50:
        boolean r111 = true;
    L51:
        if (r111 == false) goto L53;
    L54:
        if (r16 == null) goto L28;
        r15.add(r16);     // Catch: Exception -> L96 CancellationException -> L98
    L28:
        if (r14.hasNext() == false) goto L56;
        com.larus.bmhome.bigimg.t1 r21 = (com.larus.bmhome.bigimg.t1) r14.next();     // Catch: Exception -> L96 CancellationException -> L98
        AlbumDataBaseHelper r112 = AlbumDataBaseHelper.a;     // Catch: Exception -> L96 CancellationException -> L98
        String r22 = r21.g();     // Catch: Exception -> L96 CancellationException -> L98
        r1.L$0 = r15;     // Catch: Exception -> L96 CancellationException -> L98
        r1.L$1 = r14;     // Catch: Exception -> L96 CancellationException -> L98
        r1.label = 1;     // Catch: Exception -> L96 CancellationException -> L98
        r0 = r112.o(r22, r1);     // Catch: Exception -> L96 CancellationException -> L98
        if (r0 != r4) goto L32;
    L56:
        ArrayList r23 = new ArrayList();     // Catch: Exception -> L96 CancellationException -> L98
        Iterator r24 = ((List) r15).iterator();     // Catch: Exception -> L96 CancellationException -> L98
    L58:
        if (r24.hasNext() == false) goto L63;
        Object r113 = r24.next();     // Catch: Exception -> L96 CancellationException -> L98
        if (((MediaMetadata) r113).isCompleted() == false) goto L58;
        r23.add(r113);     // Catch: Exception -> L96 CancellationException -> L98
        goto L58
    L63:
        if (r23.isEmpty() == false) goto L65;
        FLogger.a.d("MineAlbumFragment", "No unsynchronized media found");     // Catch: Exception -> L96 CancellationException -> L98
        return Unit.INSTANCE;
    L65:
        FLogger r25 = FLogger.a;     // Catch: Exception -> L96 CancellationException -> L98
        r25.i("MineAlbumFragment", "Found " + r23.size() + " unsynchronized media, starting sync");     // Catch: Exception -> L96 CancellationException -> L98
        String r114 = ia8.b.a;     // Catch: Exception -> L96 CancellationException -> L98
        boolean r115 = ia8.b.a(AppHost.a.getApplication());     // Catch: Exception -> L96 CancellationException -> L98
        IDoraService r116 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L96 CancellationException -> L98
        if (r116 == null) goto L72;
        VisionService r117 = r116.V();     // Catch: Exception -> L96 CancellationException -> L98
        if (r117 == null) goto L72;
        if (r117.q() != true) goto L72;
        r9 = true;
    L72:
        if (r115 == false) goto L94;
        if (r9 == false) goto L94;
        r11 = r23;
        r10 = r23.iterator();     // Catch: Exception -> L96 CancellationException -> L98
    L94:
        r25.w("MineAlbumFragment", "Skip sync: hasPermission=" + r115 + ", isSaveEnabled=" + r9);     // Catch: Exception -> L96 CancellationException -> L98
        return Unit.INSTANCE;
    L45:
        if (r17.longValue() == 0) goto L50;
        if (r17.longValue() == (-1)) goto L50;
        r111 = false;
    L53:
        r16 = null;
        goto L54
    L38:
        if (r16.isCompleted() != true) goto L40;
        r110 = true;
        goto L41
    L35:
        r17 = null;
        goto L36
    L22:
        ResultKt.throwOnFailure(r0);
        if (r19.isEmpty() == false) goto L26;
        FLogger.a.d("MineAlbumFragment", "No media found");     // Catch: Exception -> L96 CancellationException -> L98
        return Unit.INSTANCE;
    L26:
        r15 = new ArrayList();     // Catch: Exception -> L96 CancellationException -> L98
        r14 = r19.iterator();     // Catch: Exception -> L96 CancellationException -> L98
    L98:
        FLogger.a.i("MineAlbumFragment", "checkAndSyncUnsynchronizedMedia cancelled");
    L96:
        e = move-exception;
        FLogger.a.e("MineAlbumFragment", "Error checking unsynchronized media: " + e.getMessage(), e);
    L7:
        r3 = r18;
        r1 = new MineAlbumFragment$checkAndSyncUnsynchronizedMedia$1(r3, r20);
        goto L8
    }

    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r19) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        ConstraintLayout r0 = r17.inflate(2131562404, r18, false);
        int r1 = 2131362458;
        ConstraintLayout r2 = ViewBindings.findChildViewById(r0, 2131362458);
        if (r2 == null) goto L39;
        ConstraintLayout r3 = r2;
        int r4 = 2131375135;
        AppCompatImageView r5 = ViewBindings.findChildViewById(r2, 2131375135);
        if (r5 == null) goto L37;
        r4 = 2131390331;
        AppCompatTextView r6 = ViewBindings.findChildViewById(r2, 2131390331);
        if (r6 == null) goto L37;
        LarusPageAlbumListEmptyBinding r9 = new LarusPageAlbumListEmptyBinding(r3, r5, r6);
        r1 = 2131362459;
        ConstraintLayout r7 = ViewBindings.findChildViewById(r0, 2131362459);
        if (r7 == null) goto L39;
        int r8 = 2131383232;
        if (ViewBindings.findChildViewById(r7, 2131383232) == null) goto L35;
        r8 = 2131383234;
        if (ViewBindings.findChildViewById(r7, 2131383234) == null) goto L35;
        r1 = 2131362466;
        AppCompatTextView r10 = ViewBindings.findChildViewById(r0, 2131362466);
        if (r10 == null) goto L39;
        r1 = 2131362469;
        RecyclerView r11 = ViewBindings.findChildViewById(r0, 2131362469);
        if (r11 == null) goto L39;
        r1 = 2131362470;
        ConstraintLayout r12 = ViewBindings.findChildViewById(r0, 2131362470);
        if (r12 == null) goto L39;
        ConstraintLayout r13 = r12;
        int r14 = 2131373867;
        FrameLayout r15 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131373867);
        if (r15 == null) goto L33;
        r14 = 2131379051;
        if (((ProgressBar) ViewBindings.findChildViewById(r12, 2131379051)) == null) goto L33;
        LarusAccountDialogBinding r16 = new LarusAccountDialogBinding(r13, r15);
        r1 = 2131362483;
        AlbumSyncBanner r110 = (AlbumSyncBanner) ViewBindings.findChildViewById(r0, 2131362483);
        if (r110 == null) goto L39;
        r1 = 2131362494;
        View r111 = ViewBindings.findChildViewById(r0, 2131362494);
        if (r111 == null) goto L39;
        r1 = 2131365083;
        AppCompatTextView r112 = ViewBindings.findChildViewById(r0, 2131365083);
        if (r112 == null) goto L39;
        ConstraintLayout r20 = r0;
        this.k = new LarusFragmentMineAlbumListBinding(r20, r9, r10, r11, r16, r110, r111, r112);
        return r20;
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r14)));
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r8)));
    L37:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(r4)));
    L39:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
