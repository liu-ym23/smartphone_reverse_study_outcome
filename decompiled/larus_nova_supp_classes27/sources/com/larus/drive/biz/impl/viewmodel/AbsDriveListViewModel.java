package com.larus.drive.biz.impl.viewmodel;

import android.content.Context;
import android.os.Environment;
import android.os.Parcelable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.room.RoomDatabaseKt;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.bmhome.view.screenmenu.i0;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.api.model.DriveListLoadType;
import com.larus.drive.biz.impl.activity.DriveMoveListActivity;
import com.larus.drive.biz.impl.adapter.DriveFileListAdapter;
import com.larus.drive.biz.impl.adapter.DriveFileListAdapterFooterState;
import com.larus.drive.biz.impl.database.DriveDatabase;
import com.larus.drive.biz.impl.dialog.DriveInputConfirmDialog;
import com.larus.drive.biz.impl.sdk.DriveSdkService;
import com.larus.drive.biz.impl.utils.DriveAskDoubaoChatLauncher;
import com.larus.drive.biz.impl.view.AbsDriveListFragment;
import com.larus.drive.biz.impl.view.DriveMainFragment;
import com.larus.drive.biz.impl.view.fileselect.DriveSelectActionType;
import com.larus.drive.sdk.api.IDriveSdkService;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.file.download.DriveDownloadPriority;
import com.larus.home.impl.sdk.b1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.chat.UploadFilePolicy;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.c2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import tx9.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u009a\u00012\u00020\u00012\u00020\u0002:\u0002\u009a\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010W\u001a\u00020$J\b\u0010X\u001a\u0004\u0018\u00010\rJ\b\u0010Y\u001a\u0004\u0018\u00010\rJ\u0016\u0010Z\u001a\u00020N2\u000e\u0010[\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010TJ\u001a\u0010\\\u001a\u00020N2\b\u0010]\u001a\u0004\u0018\u00010\r2\b\u0010M\u001a\u0004\u0018\u00010\rJ\b\u0010^\u001a\u00020\rH\u0014J\b\u0010c\u001a\u00020NH\u0014J\"\u0010d\u001a\u00020N2\u0010\b\u0002\u0010e\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010T2\b\b\u0002\u0010f\u001a\u00020$J\u0016\u0010g\u001a\u00020N2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020-0\fH\u0002J\u0006\u0010i\u001a\u00020NJ\u000e\u0010j\u001a\u00020N2\u0006\u0010k\u001a\u00020-J\u0010\u0010l\u001a\u00020N2\u0006\u0010k\u001a\u00020-H\u0002J\u0010\u0010m\u001a\u0004\u0018\u00010-2\u0006\u0010n\u001a\u00020\rJ\u000e\u0010o\u001a\u00020N2\u0006\u0010k\u001a\u00020-J\u0010\u0010p\u001a\u00020N2\u0006\u0010k\u001a\u00020-H\u0002J\"\u0010q\u001a\u00020N2\u0010\b\u0002\u0010e\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010T2\b\b\u0002\u0010f\u001a\u00020$J\u0010\u0010r\u001a\u00020N2\b\b\u0002\u0010s\u001a\u00020$J\u001c\u0010t\u001a\b\u0012\u0004\u0012\u00020-0\f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\fH\u0002J\u001c\u0010u\u001a\b\u0012\u0004\u0012\u00020-0\f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\fH\u0002J\u000e\u0010v\u001a\u00020\r2\u0006\u0010w\u001a\u00020\u0012J\u0006\u0010x\u001a\u00020NJ\u001e\u0010y\u001a\b\u0012\u0004\u0012\u00020z0\f2\u0006\u0010{\u001a\u00020|2\u0006\u0010k\u001a\u00020-H\u0016J\u001f\u0010}\u001a\u00020N2\u0006\u0010~\u001a\u00020z2\u0007\u0010\u007f\u001a\u00030\u0080\u00012\u0006\u0010k\u001a\u00020-J)\u0010\u0081\u0001\u001a\u00020N2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u007f\u001a\u00030\u0080\u00012\r\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020-0\fJ7\u0010\u0085\u0001\u001a\u00020N2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u007f\u001a\u00030\u0080\u00012\u0006\u0010k\u001a\u00020-2\u0011\b\u0002\u0010\u0086\u0001\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010TH\u0002J\u001a\u0010\u0087\u0001\u001a\u00020N2\u0007\u0010\u007f\u001a\u00030\u0080\u00012\u0006\u0010k\u001a\u00020-H\u0002J\u001a\u0010\u0088\u0001\u001a\u00020N2\u0007\u0010\u007f\u001a\u00030\u0080\u00012\u0006\u0010k\u001a\u00020-H\u0002J\u001a\u0010\u0089\u0001\u001a\u00020N2\u0007\u0010\u007f\u001a\u00030\u0080\u00012\u0006\u0010k\u001a\u00020-H\u0002J\u0007\u0010\u008a\u0001\u001a\u00020NJ\u001a\u0010\u008b\u0001\u001a\u00020N2\u0007\u0010\u007f\u001a\u00030\u008c\u00012\u0006\u0010k\u001a\u00020-H\u0002J4\u0010\u008d\u0001\u001a\u00020N2\u0007\u0010\u007f\u001a\u00030\u008c\u00012\r\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020-0\f2\u0011\b\u0002\u0010\u008f\u0001\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010TH\u0002J!\u0010\u0090\u0001\u001a\u00020N2\u0007\u0010\u007f\u001a\u00030\u008c\u00012\r\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020-0\fH\u0002J-\u0010\u0091\u0001\u001a\u00020N2\u0007\u0010\u007f\u001a\u00030\u008c\u00012\u0006\u0010k\u001a\u00020-2\u0011\b\u0002\u0010\u008f\u0001\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010TH\u0002J%\u0010\u0092\u0001\u001a\u00020N2\u0006\u0010k\u001a\u00020-2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010|2\u0007\u0010\u0094\u0001\u001a\u00020$H\u0016J\u0012\u0010\u0095\u0001\u001a\u00020N2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\rJ\u001b\u0010\u0097\u0001\u001a\u00020N2\u0006\u0010k\u001a\u00020-2\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR#\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020$X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\f0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\f0/¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020$0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020$0/¢\u0006\b\n\u0000\u001a\u0004\b3\u00101R\u0014\u00104\u001a\b\u0012\u0004\u0012\u0002050,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00106\u001a\b\u0012\u0004\u0012\u0002050/¢\u0006\b\n\u0000\u001a\u0004\b7\u00101R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020$0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020$0/¢\u0006\b\n\u0000\u001a\u0004\b:\u00101R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020$0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020$0/¢\u0006\b\n\u0000\u001a\u0004\b<\u00101R\u0010\u0010=\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0/¢\u0006\b\n\u0000\u001a\u0004\b@\u00101R\u0010\u0010A\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010F\u001a\u0004\u0018\u00010\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001d\"\u0004\bH\u0010\u001fR9\u0010I\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(M\u0012\u0004\u0012\u00020N\u0018\u00010JX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0016\u0010S\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010U\u001a\u000e\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020N0JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010_\u001a\u00020`X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010b¨\u0006\u009b\u0001"}, d2 = {"Lcom/larus/drive/biz/impl/viewmodel/AbsDriveListViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/larus/drive/sdk/api/file/list/IListViewModelCallback;", "<init>", "()V", "larkDriveConfig", "Lcom/larus/platform/model/LarkDriveConfig;", "getLarkDriveConfig", "()Lcom/larus/platform/model/LarkDriveConfig;", "larkDriveConfig$delegate", "Lkotlin/Lazy;", "mediaSupportSaveToAlbum", "", "", "getMediaSupportSaveToAlbum", "()Ljava/util/List;", "mediaSupportSaveToAlbum$delegate", "picMaxSize", "", "getPicMaxSize", "()J", "picMaxSize$delegate", "fileListFetchLength", "", "getFileListFetchLength", "()I", "fileListFetchLength$delegate", "folderToken", "getFolderToken", "()Ljava/lang/String;", "setFolderToken", "(Ljava/lang/String;)V", "folderDriveToken", "getFolderDriveToken", "setFolderDriveToken", "showOnlyFolder", "", "getShowOnlyFolder", "()Z", "setShowOnlyFolder", "(Z)V", "excludeDriveToken", "returnToTopWhenFileListUpdate", "_files", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "files", "Landroidx/lifecycle/LiveData;", "getFiles", "()Landroidx/lifecycle/LiveData;", "_isLoading", "isLoading", "_loadMoreState", "Lcom/larus/drive/biz/impl/adapter/DriveFileListAdapterFooterState;", "loadMoreState", "getLoadMoreState", "_hasMore", "hasMore", "getHasMore", "_isDownloading", "isDownloading", "loadMoreFileListLabel", "_errorMessage", "errorMessage", "getErrorMessage", "latestDownloadingTaskKey", "fileListLoadingCanceller", "Lcom/bytedance/ee/bear/list/callback/ICancelable;", "fileDeleteCanceller", "fileRenameCanceller", "latestRefreshMark", "getLatestRefreshMark", "setLatestRefreshMark", "latestRefreshTask", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "destFolderToken", "", "getLatestRefreshTask", "()Lkotlin/jvm/functions/Function1;", "setLatestRefreshTask", "(Lkotlin/jvm/functions/Function1;)V", "forbidLoadingAnimFunc", "Lkotlin/Function0;", "onUploadSuccessCallback", "Lcom/larus/drive/biz/api/model/DriveUploadItem;", "needsReturningToTopWhenFileListUpdate", "getRefreshMark", "getCurrentFolderToken", "setForbidLoadingAnimFunc", "func", "doRefreshTask", "refreshMark", "getTag", "driveListLoadType", "Lcom/larus/drive/biz/api/model/DriveListLoadType;", "getDriveListLoadType", "()Lcom/larus/drive/biz/api/model/DriveListLoadType;", "onCleared", "loadFiles", "onRefreshTriggered", "forbidLoadingAnim", "saveLocalInitialData", "driveFileList", "loadLocalInitialData", "deleteFile", "file", "doDeleteFile", "getFileFromLocalList", "fileToken", "updateFile", "doUpdateFile", "refreshFiles", "loadMoreFiles", "force", "filterOnlyFolderIfRequired", "removeExcludedFolder", "formatFileTime", "timestamp", "clearError", "getLongClickMenuList", "Lcom/larus/bmhome/view/screenmenu/abs/IMenuItem;", "ctx", "Landroid/content/Context;", "handleMenuClick", "item", "fragment", "Lcom/larus/drive/biz/impl/view/AbsDriveListFragment;", "handleSelectPanelAction", "actionType", "Lcom/larus/drive/biz/impl/view/fileselect/DriveSelectActionType;", "selectedFiles", "handleSingleSelectPanelAction", "onActionConfirmed", "askAI", "doAskAi", "downloadFile", "cancelDownload", "showDeleteConfirmDialog", "Landroidx/fragment/app/Fragment;", "showMultiDeleteConfirmDialog", "fileList", "onConfirmed", "deleteMultiFiles", "showRenameDialog", "startMoveDriveFileTask", "context", "forceRefresh", "setExcludeDriveTokenValue", "token", "shareDriveFile", "param", "Lcom/larus/share/bean/DriveShareEventParam;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsDriveListViewModel extends ViewModel implements u79.a {
    public static final a Companion = null;
    public static final int MENU_ID_ASK = 10001;
    public static final int MENU_ID_DELETE = 10006;
    public static final int MENU_ID_DOWNLOAD = 10003;
    public static final int MENU_ID_MOVE = 10005;
    public static final int MENU_ID_MULTI_SELECT = 10007;
    public static final int MENU_ID_RENAME = 10004;
    public static final int MENU_ID_SHARE = 10002;
    private static final String TAG = "AbsDriveListViewModel";
    private final MutableLiveData<String> _errorMessage;
    private final MutableLiveData<List<DriveFileItem>> _files;
    private final MutableLiveData<Boolean> _hasMore;
    private final MutableLiveData<Boolean> _isDownloading;
    private final MutableLiveData<Boolean> _isLoading;
    private final MutableLiveData<DriveFileListAdapterFooterState> _loadMoreState;
    private final DriveListLoadType driveListLoadType;
    private final LiveData<String> errorMessage;
    private String excludeDriveToken;
    private nc5.b fileDeleteCanceller;
    private final Lazy fileListFetchLength$delegate;
    private nc5.b fileListLoadingCanceller;
    private nc5.b fileRenameCanceller;
    private final LiveData<List<DriveFileItem>> files;
    private String folderDriveToken;
    private String folderToken;
    private Function0<Unit> forbidLoadingAnimFunc;
    private final LiveData<Boolean> hasMore;
    private final LiveData<Boolean> isDownloading;
    private final LiveData<Boolean> isLoading;
    private final Lazy larkDriveConfig$delegate;
    private String latestDownloadingTaskKey;
    private String latestRefreshMark;
    private Function1<? super String, Unit> latestRefreshTask;
    private String loadMoreFileListLabel;
    private final LiveData<DriveFileListAdapterFooterState> loadMoreState;
    private final Lazy mediaSupportSaveToAlbum$delegate;
    private final Function1<com.larus.drive.biz.api.model.a, Unit> onUploadSuccessCallback;
    private final Lazy picMaxSize$delegate;
    private boolean returnToTopWhenFileListUpdate;
    private boolean showOnlyFolder;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DriveSelectActionType.values().length];
            r0[DriveSelectActionType.DELETE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[DriveSelectActionType.RENAME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[DriveSelectActionType.ASK_AI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[DriveSelectActionType.SHARE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[DriveSelectActionType.DOWNLOAD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[DriveSelectActionType.MOVE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public static final class c implements com.larus.common_ui.dialog.u {
        public c() {
        }

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
        }
    }

    public static final class d implements p0 {
        public final /* synthetic */ Function0<Unit> a;
        public final /* synthetic */ AbsDriveListViewModel b;
        public final /* synthetic */ Fragment c;
        public final /* synthetic */ List<DriveFileItem> d;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            Function0<Unit> r0 = this.a;
            if (r0 == null) goto L5;
            r0.invoke();
        L5:
            AbsDriveListViewModel.access$deleteMultiFiles(this.b, this.c, this.d);
        }

        public d(Function0<Unit> r1, AbsDriveListViewModel r2, Fragment r3, List<DriveFileItem> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    /* JADX INFO: renamed from: com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$deleteFile$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$deleteFile$1", f = "AbsDriveListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DriveFileItem $file;
        int label;
        final /* synthetic */ AbsDriveListViewModel this$0;

        public AnonymousClass1(AbsDriveListViewModel r1, DriveFileItem r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$file = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$file, r4);
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
            AbsDriveListViewModel.access$doDeleteFile(this.this$0, this.$file);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$doAskAi$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$doAskAi$1", f = "AbsDriveListViewModel.kt", i = {}, l = {826, 828}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ DriveFileItem $file;
        int label;

        /* JADX INFO: renamed from: com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$doAskAi$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$doAskAi$1$1", f = "AbsDriveListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C01121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $context;
            int label;

            public C01121(Context r1, Continuation<? super C01121> r2) {
                this.$context = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C01121(this.$context, r3);
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
                t19.s r4 = t19.s.a;
                Context r0 = this.$context;
                String r1 = r0.getString(2131905570);
                r4.getClass();
                t19.s.t(r0, r1);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C05361(Context r1, DriveFileItem r2, Continuation<? super C05361> r3) {
            this.$context = r1;
            this.$file = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C05361(this.$context, this.$file, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r6);
        L19:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r6);
        L14:
            if (((Boolean) r6).booleanValue() == true) goto L19;
            MainCoroutineDispatcher r7 = Dispatchers.getMain();
            C01121 r2 = new C01121(this.$context, null);
            this.label = 2;
            if (BuildersKt.withContext(r7, r2, this) != r0) goto L19;
            return r0;
        L10:
            ResultKt.throwOnFailure(r6);
            DriveAskDoubaoChatLauncher r8 = DriveAskDoubaoChatLauncher.a;
            Context r3 = this.$context;
            DriveFileItem r4 = this.$file;
            this.label = 1;
            r6 = r8.b(r3, r4, false, this);
            if (r6 != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$doDeleteFile$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$doDeleteFile$2", f = "AbsDriveListViewModel.kt", i = {}, l = {392, 393}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DriveFileItem $file;
        int label;
        final /* synthetic */ AbsDriveListViewModel this$0;

        public AnonymousClass2(AbsDriveListViewModel r1, DriveFileItem r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$file = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$file, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r6);
        L21:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r6);
            DriveDatabase r7 = DriveDatabase.a.a();
            AbsDriveListViewModel r2 = this.this$0;
            if ((r2 instanceof DriveRecentListViewModel) == false) goto L16;
            l79.h r8 = r7.d();
            String r3 = this.$file.b;
            this.label = 1;
            if (r8.e(r3, this) != r0) goto L21;
            return r0;
        L16:
            if ((r2 instanceof DriveMineListViewModel) == false) goto L21;
            l79.c r9 = r7.c();
            String r4 = this.$file.b;
            this.label = 2;
            if (r9.e(r4, this) != r0) goto L21;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$doUpdateFile$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$doUpdateFile$2", f = "AbsDriveListViewModel.kt", i = {0, 2}, l = {423, 439, 444, 460}, m = "invokeSuspend", n = {"dao", "dao"}, s = {"L$0", "L$0"})
    public static final class C05372 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DriveFileItem $file;
        Object L$0;
        int label;
        final /* synthetic */ AbsDriveListViewModel this$0;

        public C05372(AbsDriveListViewModel r1, DriveFileItem r2, Continuation<? super C05372> r3) {
            this.this$0 = r1;
            this.$file = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C05372(this.this$0, this.$file, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r24) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L14;
            if (r2 == 1) goto L13;
            if (r2 == 2) goto L12;
            if (r2 == 3) goto L11;
            if (r2 == 4) goto L12;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            l79.c r3 = (l79.c) this.L$0;
            ResultKt.throwOnFailure(r24);
            Object r4 = r24;
        L29:
            l79.a r5 = (l79.a) r4;
            if (r5 == null) goto L35;
            DriveFileItem r6 = this.$file;
            List<l79.a> r7 = CollectionsKt.listOf(new l79.a(r6.b, r6.c, r5.c, r6.a, r6.e, r6.f, r6.g, r6.i, r6.j.getValue(), r6.k, r6.d, r6.l));
            this.L$0 = null;
            this.label = 4;
            if (r3.c(r7, this) != r1) goto L35;
            return r1;
        L35:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r24);
            goto L35
        L13:
            l79.h r8 = (l79.h) this.L$0;
            ResultKt.throwOnFailure(r24);
            Object r9 = r24;
        L19:
            l79.b r10 = (l79.b) r9;
            if (r10 == null) goto L35;
            DriveFileItem r11 = this.$file;
            List<l79.b> r12 = CollectionsKt.listOf(new l79.b(r11.b, r11.c, r10.c, r11.a, r11.e, r11.f, r11.g, r11.i, r11.j.getValue(), r11.k, r11.d, r11.l));
            this.L$0 = null;
            this.label = 2;
            if (r8.c(r12, this) != r1) goto L35;
            return r1;
        L14:
            ResultKt.throwOnFailure(r24);
            DriveDatabase r13 = DriveDatabase.a.a();
            AbsDriveListViewModel r14 = this.this$0;
            if ((r14 instanceof DriveRecentListViewModel) == false) goto L25;
            r8 = r13.d();
            String r15 = this.$file.b;
            this.L$0 = r8;
            this.label = 1;
            r9 = r8.b(r15, this);
            if (r9 != r1) goto L19;
            return r1;
        L25:
            if ((r14 instanceof DriveMineListViewModel) == false) goto L35;
            r3 = r13.c();
            String r16 = this.$file.b;
            this.L$0 = r3;
            this.label = 3;
            r4 = r3.b(r16, this);
            if (r4 != r1) goto L29;
            return r1;
        }
    }

    public static final class e implements m79.g {
        public final /* synthetic */ AbsDriveListViewModel a;
        public final /* synthetic */ DriveFileItem b;
        public final /* synthetic */ Fragment c;
        public final /* synthetic */ Function0<Unit> d;

        @Override // m79.g
        public final void d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.drive.biz.impl.viewmodel.q] */
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
        @Override // m79.g
        public final void a(String r8) {
            Intrinsics.checkNotNullParameter(r8, "input");
            StringBuilder r0 = new StringBuilder();
            r0.append(r8);
            DriveFileItem r9 = this.b;
            Parcelable.Creator<DriveFileItem> r1 = DriveFileItem.CREATOR;
            r0.append(r9.d(true));
            final String r4 = r0.toString();
            Function0<Unit> r10 = this.d;
            if (r10 == null) goto L5;
            r10.invoke();
        L5:
            nc5.b r11 = AbsDriveListViewModel.access$getFileRenameCanceller$p(this.a);
            if (r11 == null) goto L8;
            r11.cancel();
        L8:
            final AbsDriveListViewModel r12 = this.a;
            DriveSdkService r2 = DriveSdkService.a;
            final DriveFileItem r3 = this.b;
            AbsDriveListViewModel.access$setFileRenameCanceller$p(r12, r2.Q(r3.b, r3.d, r4, new q(r12, r3, r4), new r(r12, this.c)));
        }

        @Override // m79.g
        public final boolean b(String r4) {
            Intrinsics.checkNotNullParameter(r4, "input");
            int r0 = AbsDriveListViewModel.access$getLarkDriveConfig(this.a).d();
            DriveFileItem r1 = this.b;
            Parcelable.Creator<DriveFileItem> r2 = DriveFileItem.CREATOR;
            int r3 = r0 - r1.d(true).length();
            if (r4.length() <= r3) goto L6;
            t19.s r5 = t19.s.a;
            FragmentActivity r6 = this.c.getActivity();
            String r7 = this.c.getString(2131901079);
            r5.getClass();
            t19.s.t(r6, r7);
            return false;
        L6:
            return true;
        }

        @Override // m79.g
        public final Pair<Boolean, String> c(String r6) {
            Intrinsics.checkNotNullParameter(r6, "input");
            int r0 = AbsDriveListViewModel.access$getLarkDriveConfig(this.a).d();
            DriveFileItem r1 = this.b;
            Parcelable.Creator<DriveFileItem> r2 = DriveFileItem.CREATOR;
            int r3 = r0 - r1.d(true).length();
            if (r6.length() <= r3) goto L7;
            t19.s r4 = t19.s.a;
            FragmentActivity r5 = this.c.getActivity();
            String r7 = this.c.getString(2131901079);
            r4.getClass();
            t19.s.t(r5, r7);
            return TuplesKt.to(Boolean.TRUE, StringsKt.take(r6, r3));
        L7:
            return TuplesKt.to(Boolean.FALSE, r6);
        }

        public e(AbsDriveListViewModel r1, DriveFileItem r2, Fragment r3, Function0<Unit> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    /* JADX INFO: renamed from: com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$loadLocalInitialData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$loadLocalInitialData$1", f = "AbsDriveListViewModel.kt", i = {}, l = {310}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AbsDriveListViewModel this$0;

        public C05401(AbsDriveListViewModel r1, Continuation<? super C05401> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C05401(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            List r7 = (List) r6;
            if ((!r7.isEmpty()) == false) goto L15;
            MutableLiveData r2 = AbsDriveListViewModel.access$get_files$p(this.this$0);
            AbsDriveListViewModel r3 = this.this$0;
            r2.setValue(AbsDriveListViewModel.access$removeExcludedFolder(r3, AbsDriveListViewModel.access$filterOnlyFolderIfRequired(r3, r7)));
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            CoroutineDispatcher r8 = Dispatchers.getIO();
            AbsDriveListViewModel$loadLocalInitialData$1$items$1 r4 = new AbsDriveListViewModel$loadLocalInitialData$1$items$1(this.this$0, null);
            this.label = 1;
            r6 = BuildersKt.withContext(r8, r4, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$saveLocalInitialData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$saveLocalInitialData$1", f = "AbsDriveListViewModel.kt", i = {}, l = {276, 299}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<DriveFileItem> $driveFileList;
        int label;
        final /* synthetic */ AbsDriveListViewModel this$0;

        /* JADX INFO: renamed from: com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$saveLocalInitialData$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$saveLocalInitialData$1$1", f = "AbsDriveListViewModel.kt", i = {}, l = {277, 278}, m = "invokeSuspend", n = {}, s = {})
        public static final class C01131 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ l79.h $dao;
            final /* synthetic */ List<l79.b> $entities;
            int label;

            public C01131(l79.h r1, List<l79.b> r2, Continuation<? super C01131> r3) {
                this.$dao = r1;
                this.$entities = r2;
                super(1, r3);
            }

            public final Continuation<Unit> create(Continuation<?> r4) {
                return new C01131(this.$dao, this.$entities, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1) {
                return invoke((Continuation) r1);
            }

            public final Object invoke(Continuation<? super Unit> r2) {
                return create(r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L9;
                if (r1 != 2) goto L8;
                ResultKt.throwOnFailure(r5);
            L17:
                return Unit.INSTANCE;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                ResultKt.throwOnFailure(r5);
            L13:
                l79.h r6 = this.$dao;
                List<l79.b> r2 = this.$entities;
                this.label = 2;
                if (r6.c(r2, this) != r0) goto L17;
                return r0;
            L10:
                ResultKt.throwOnFailure(r5);
                l79.h r7 = this.$dao;
                this.label = 1;
                if (r7.d(this) != r0) goto L13;
                return r0;
            }
        }

        /* JADX INFO: renamed from: com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$saveLocalInitialData$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$saveLocalInitialData$1$2", f = "AbsDriveListViewModel.kt", i = {}, l = {300, 301}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ l79.c $dao;
            final /* synthetic */ List<l79.a> $entities;
            int label;

            public AnonymousClass2(l79.c r1, List<l79.a> r2, Continuation<? super AnonymousClass2> r3) {
                this.$dao = r1;
                this.$entities = r2;
                super(1, r3);
            }

            public final Continuation<Unit> create(Continuation<?> r4) {
                return new AnonymousClass2(this.$dao, this.$entities, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1) {
                return invoke((Continuation) r1);
            }

            public final Object invoke(Continuation<? super Unit> r2) {
                return create(r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L9;
                if (r1 != 2) goto L8;
                ResultKt.throwOnFailure(r5);
            L17:
                return Unit.INSTANCE;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                ResultKt.throwOnFailure(r5);
            L13:
                l79.c r6 = this.$dao;
                List<l79.a> r2 = this.$entities;
                this.label = 2;
                if (r6.c(r2, this) != r0) goto L17;
                return r0;
            L10:
                ResultKt.throwOnFailure(r5);
                l79.c r7 = this.$dao;
                this.label = 1;
                if (r7.d(this) != r0) goto L13;
                return r0;
            }
        }

        public C05421(AbsDriveListViewModel r1, List<DriveFileItem> r2, Continuation<? super C05421> r3) {
            this.this$0 = r1;
            this.$driveFileList = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C05421(this.this$0, this.$driveFileList, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r30) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r30);
        L35:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r30);
            DriveDatabase r3 = DriveDatabase.a.a();
            AbsDriveListViewModel r5 = this.this$0;
            if ((r5 instanceof DriveRecentListViewModel) == false) goto L22;
            l79.h r4 = r3.d();
            List<DriveFileItem> r6 = this.$driveFileList;
            ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
            Iterator r8 = r6.iterator();
            int r12 = 0;
        L14:
            if (r8.hasNext() == false) goto L19;
            Object r9 = r8.next();
            int r24 = r12 + 1;
            if (r12 >= 0) goto L18;
            CollectionsKt.throwIndexOverflow();
        L18:
            DriveFileItem r10 = (DriveFileItem) r9;
            Object r26 = r1;
            r7.add(new l79.b(r10.b, r10.c, r12, r10.a, r10.e, r10.f, r10.g, r10.i, r10.j.getValue(), r10.k, r10.d, r10.l));
            r8 = r8;
            r12 = r24;
            r1 = r26;
            r3 = r3;
            r4 = r4;
            goto L14
        L19:
            Object r27 = r1;
            C01131 r0 = new C01131(r4, r7, null);
            this.label = 1;
            if (RoomDatabaseKt.withTransaction(r3, r0, this) != r27) goto L35;
            return r27;
        L22:
            Object r11 = r1;
            if ((r5 instanceof DriveMineListViewModel) == false) goto L35;
            l79.c r13 = r3.c();
            List<DriveFileItem> r14 = this.$driveFileList;
            ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
            Iterator r16 = r14.iterator();
            int r17 = 0;
        L26:
            if (r16.hasNext() == false) goto L31;
            Object r18 = r16.next();
            int r20 = r17 + 1;
            if (r17 >= 0) goto L30;
            CollectionsKt.throwIndexOverflow();
        L30:
            DriveFileItem r21 = (DriveFileItem) r18;
            Iterator r31 = r16;
            r15.add(new l79.a(r21.b, r21.c, r17, r21.a, r21.e, r21.f, r21.g, r21.i, r21.j.getValue(), r21.k, r21.d, r21.l));
            r16 = r31;
            r17 = r20;
            r11 = r11;
            r3 = r3;
            r13 = r13;
            goto L26
        L31:
            Object r28 = r11;
            AnonymousClass2 r22 = new AnonymousClass2(r13, r15, null);
            this.label = 2;
            if (RoomDatabaseKt.withTransaction(r3, r22, this) != r28) goto L35;
            return r28;
        }
    }

    /* JADX INFO: renamed from: com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$showDeleteConfirmDialog$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$showDeleteConfirmDialog$1", f = "AbsDriveListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DriveFileItem $file;
        final /* synthetic */ Fragment $fragment;
        int label;
        final /* synthetic */ AbsDriveListViewModel this$0;

        /* JADX INFO: renamed from: com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$showDeleteConfirmDialog$1$a */
        public static final class a implements com.larus.common_ui.dialog.u {
            public a() {
            }

            @Override // com.larus.common_ui.dialog.u
            public final void cancel() {
            }
        }

        /* JADX INFO: renamed from: com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$showDeleteConfirmDialog$1$b */
        public static final class b implements p0 {
            public final /* synthetic */ AbsDriveListViewModel a;
            public final /* synthetic */ Fragment b;
            public final /* synthetic */ DriveFileItem c;

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r14v0, types: [com.larus.drive.biz.impl.viewmodel.o] */
            /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.drive.biz.impl.viewmodel.p] */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.larus.common_ui.dialog.p0
            public final void confirm() {
                nc5.b r0 = AbsDriveListViewModel.access$getFileDeleteCanceller$p(this.a);
                if (r0 == null) goto L5;
                r0.cancel();
            L5:
                AtomicLong r1 = h79.b.a;
                FragmentActivity r2 = this.b.getActivity();
                Fragment r3 = this.b;
                final long r4 = h79.b.b(r2, r3, r3.getString(2131899715));
                AbsDriveListViewModel r5 = this.a;
                DriveSdkService r9 = DriveSdkService.a;
                DriveFileItem r10 = this.c;
                DriveListLoadType r11 = r5.getDriveListLoadType();
                final AbsDriveListViewModel r12 = this.a;
                final Fragment r13 = this.b;
                final DriveFileItem r8 = this.c;
                AbsDriveListViewModel.access$setFileDeleteCanceller$p(r5, r9.O(r10, r11, new o(r12, r4, r13, r8), new p(r12, r4, r13)));
            }

            public b(AbsDriveListViewModel r1, Fragment r2, DriveFileItem r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }
        }

        public C05431(Fragment r1, AbsDriveListViewModel r2, DriveFileItem r3, Continuation<? super C05431> r4) {
            this.$fragment = r1;
            this.this$0 = r2;
            this.$file = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C05431(this.$fragment, this.this$0, this.$file, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r6);
            CommonDialog.a r7 = new CommonDialog.a();
            r7.i(this.$fragment.getString(2131902096));
            r7.b = false;
            CommonDialog.a.e(r7, new a(), this.$fragment.getString(2131899534), 4);
            AbsDriveListViewModel r2 = this.this$0;
            Fragment r3 = this.$fragment;
            CommonDialog.a.f(r7, new b(r2, r3, this.$file), r3.getString(2131899533), false, 12);
            INVOKEVIRTUAL_com_larus_drive_biz_impl_viewmodel_AbsDriveListViewModel$showDeleteConfirmDialog$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r7.a(), this.$fragment.getParentFragmentManager(), "drive_delete_confirm");
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public static void INVOKEVIRTUAL_com_larus_drive_biz_impl_viewmodel_AbsDriveListViewModel$showDeleteConfirmDialog$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(CommonDialog r2, FragmentManager r3, String r4) {
            if ((r2 instanceof Fragment) == false) goto L5;
            CommonDialog r0 = r2;
        L6:
            LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
            return;
        L13:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
        L10:
            r2.show(r3, r4);
            return;
        L5:
            r0 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$updateFile$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$updateFile$1", f = "AbsDriveListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DriveFileItem $file;
        int label;
        final /* synthetic */ AbsDriveListViewModel this$0;

        public C05441(AbsDriveListViewModel r1, DriveFileItem r2, Continuation<? super C05441> r3) {
            this.this$0 = r1;
            this.$file = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C05441(this.this$0, this.$file, r4);
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
            AbsDriveListViewModel.access$doUpdateFile(this.this$0, this.$file);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit Mo(AbsDriveListViewModel r0, DriveFileItem r1, String r2) {
        return startMoveDriveFileTask$lambda$27(r0, r1, r2);
    }

    public static /* synthetic */ Unit No(AbsDriveListViewModel r0, AbsDriveListFragment r1, DriveFileItem r2, String r3) {
        return askAI$lambda$17(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit Oo(AbsDriveListViewModel r0, List r1, long r2, Fragment r4) {
        return deleteMultiFiles$lambda$23(r0, r1, r2, r4);
    }

    public static /* synthetic */ Unit Po() {
        return askAI$lambda$18();
    }

    public static /* synthetic */ CharSequence Qo(DriveFileItem r0) {
        return handleSelectPanelAction$lambda$13(r0);
    }

    public static /* synthetic */ long So(AbsDriveListViewModel r2) {
        return picMaxSize_delegate$lambda$2(r2);
    }

    public static /* synthetic */ Unit To(AbsDriveListViewModel r0, com.larus.drive.biz.api.model.a r1) {
        return onUploadSuccessCallback$lambda$4(r0, r1);
    }

    public static /* synthetic */ Unit Wo(AbsDriveListViewModel r0, List r1, long r2, Fragment r4, Map r5) {
        return deleteMultiFiles$lambda$26(r0, r1, r2, r4, r5);
    }

    public static /* synthetic */ c2 Yo() {
        return larkDriveConfig_delegate$lambda$0();
    }

    public static /* synthetic */ List Zo(AbsDriveListViewModel r0) {
        return mediaSupportSaveToAlbum_delegate$lambda$1(r0);
    }

    public static /* synthetic */ CharSequence ap(DriveFileItem r0) {
        return handleSelectPanelAction$lambda$15(r0);
    }

    public static /* synthetic */ int bp(AbsDriveListViewModel r0) {
        return fileListFetchLength_delegate$lambda$3(r0);
    }

    public static /* synthetic */ CharSequence cp(DriveFileItem r0) {
        return handleSelectPanelAction$lambda$14(r0);
    }

    public static /* synthetic */ CharSequence yo(DriveFileItem r0) {
        return handleSelectPanelAction$lambda$12(r0);
    }

    public String getTag() {
        return TAG;
    }

    private final c2 getLarkDriveConfig() {
        return (c2) this.larkDriveConfig$delegate.getValue();
    }

    private final long getPicMaxSize() {
        return ((Number) this.picMaxSize$delegate.getValue()).longValue();
    }

    private static final c2 larkDriveConfig_delegate$lambda$0() {
        return z2.a.getLarkDriveConfig();
    }

    public final void cancelDownload() {
        String r0 = this.latestDownloadingTaskKey;
        if (r0 == null) goto L6;
        DriveSdkService.a.g(CollectionsKt.listOf(r0));
        return;
    }

    public final void clearError() {
        this._errorMessage.setValue(null);
    }

    public final int getFileListFetchLength() {
        return ((Number) this.fileListFetchLength$delegate.getValue()).intValue();
    }

    public final List<String> getMediaSupportSaveToAlbum() {
        return (List) this.mediaSupportSaveToAlbum$delegate.getValue();
    }

    public AbsDriveListViewModel() {
        this.larkDriveConfig$delegate = LazyKt.lazy(new m());
        this.mediaSupportSaveToAlbum$delegate = LazyKt.lazy(new n(this));
        this.picMaxSize$delegate = LazyKt.lazy(new com.larus.drive.biz.impl.viewmodel.b(this));
        this.fileListFetchLength$delegate = LazyKt.lazy(new com.larus.drive.biz.impl.viewmodel.c(this));
        this.returnToTopWhenFileListUpdate = true;
        MutableLiveData<List<DriveFileItem>> r0 = new MutableLiveData();
        this._files = r0;
        this.files = r0;
        MutableLiveData<Boolean> r1 = new MutableLiveData();
        this._isLoading = r1;
        this.isLoading = r1;
        MutableLiveData<DriveFileListAdapterFooterState> r2 = new MutableLiveData(DriveFileListAdapterFooterState.IDLE);
        this._loadMoreState = r2;
        this.loadMoreState = r2;
        MutableLiveData<Boolean> r3 = new MutableLiveData(Boolean.TRUE);
        this._hasMore = r3;
        this.hasMore = r3;
        MutableLiveData<Boolean> r4 = new MutableLiveData();
        this._isDownloading = r4;
        this.isDownloading = r4;
        MutableLiveData<String> r5 = new MutableLiveData();
        this._errorMessage = r5;
        this.errorMessage = r5;
        this.onUploadSuccessCallback = new com.larus.drive.biz.impl.viewmodel.d(this);
        Lazy r6 = com.larus.drive.biz.impl.file.t.a;
        Function1<com.larus.drive.biz.api.model.a, Unit> r7 = this.onUploadSuccessCallback;
        Intrinsics.checkNotNullParameter(r7, "callback");
        Iterator r8 = com.larus.drive.biz.impl.file.t.d().iterator();
    L3:
        WeakReference<AbsDriveListViewModel> r9 = null;
        if (r8.hasNext() == false) goto L8;
        Object r10 = r8.next();
        if (Intrinsics.areEqual(((WeakReference) r10).get(), r7) == false) goto L3;
    L9:
        if (r10 != null) goto L11;
        com.larus.drive.biz.impl.file.t.d().add(new WeakReference(r7));
    L11:
        CopyOnWriteArrayList<WeakReference<AbsDriveListViewModel>> r11 = com.larus.drive.biz.impl.utils.f.a;
        Intrinsics.checkNotNullParameter(this, "viewModel");
        Iterator<WeakReference<AbsDriveListViewModel>> r12 = com.larus.drive.biz.impl.utils.f.a.iterator();
    L13:
        if (r12.hasNext() == false) goto L17;
        WeakReference<AbsDriveListViewModel> r13 = r12.next();
        if (Intrinsics.areEqual(r13.get(), this) == false) goto L13;
        r9 = r13;
    L17:
        if (r9 != null) goto L20;
        com.larus.drive.biz.impl.utils.f.a.add(new WeakReference(this));
    L20:
        this.driveListLoadType = DriveListLoadType.FOLDER;
        return;
    L8:
        r10 = null;
        goto L9
    }

    public final void loadLocalInitialData() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05401(this, null), 3, null);
    }

    public void onCleared() {
        super.onCleared();
        Lazy r0 = com.larus.drive.biz.impl.file.t.a;
        Function1<com.larus.drive.biz.api.model.a, Unit> r1 = this.onUploadSuccessCallback;
        Intrinsics.checkNotNullParameter(r1, "callback");
        CopyOnWriteArrayList r2 = com.larus.drive.biz.impl.file.t.d();
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((WeakReference) r5).get(), r1) == false) goto L4;
        r3.add(r5);
        goto L4
    L8:
        Iterator r6 = r3.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        WeakReference r7 = (WeakReference) r6.next();
        Lazy r8 = com.larus.drive.biz.impl.file.t.a;
        com.larus.drive.biz.impl.file.t.d().remove(r7);
        goto L10
    L12:
        CopyOnWriteArrayList<WeakReference<AbsDriveListViewModel>> r9 = com.larus.drive.biz.impl.utils.f.a;
        Intrinsics.checkNotNullParameter(this, "viewModel");
        Iterator<WeakReference<AbsDriveListViewModel>> r10 = com.larus.drive.biz.impl.utils.f.a.iterator();
    L14:
        if (r10.hasNext() == false) goto L18;
        WeakReference<AbsDriveListViewModel> r11 = r10.next();
        if (Intrinsics.areEqual(r11.get(), this) == false) goto L14;
    L19:
        WeakReference<AbsDriveListViewModel> r12 = r11;
        if (r12 == null) goto L22;
        com.larus.drive.biz.impl.utils.f.a.remove(r12);
    L22:
        this.latestRefreshTask = null;
        nc5.b r13 = this.fileListLoadingCanceller;
        if (r13 == null) goto L25;
        r13.cancel();
    L25:
        nc5.b r14 = this.fileDeleteCanceller;
        if (r14 == null) goto L28;
        r14.cancel();
    L28:
        nc5.b r15 = this.fileRenameCanceller;
        if (r15 == null) goto L41;
        r15.cancel();
        return;
    L41:
        return;
    L18:
        r11 = null;
        goto L19
    }

    private static final Unit askAI$lambda$18() {
        return Unit.INSTANCE;
    }

    public final String getCurrentFolderToken() {
        return this.folderToken;
    }

    public DriveListLoadType getDriveListLoadType() {
        return this.driveListLoadType;
    }

    public final LiveData<String> getErrorMessage() {
        return this.errorMessage;
    }

    public final LiveData<List<DriveFileItem>> getFiles() {
        return this.files;
    }

    public final String getFolderDriveToken() {
        return this.folderDriveToken;
    }

    public final String getFolderToken() {
        return this.folderToken;
    }

    public final LiveData<Boolean> getHasMore() {
        return this.hasMore;
    }

    public final String getLatestRefreshMark() {
        return this.latestRefreshMark;
    }

    public final Function1<String, Unit> getLatestRefreshTask() {
        return this.latestRefreshTask;
    }

    public final LiveData<DriveFileListAdapterFooterState> getLoadMoreState() {
        return this.loadMoreState;
    }

    public final String getRefreshMark() {
        return this.latestRefreshMark;
    }

    public final boolean getShowOnlyFolder() {
        return this.showOnlyFolder;
    }

    public final LiveData<Boolean> isDownloading() {
        return this.isDownloading;
    }

    public final LiveData<Boolean> isLoading() {
        return this.isLoading;
    }

    public final boolean needsReturningToTopWhenFileListUpdate() {
        return this.returnToTopWhenFileListUpdate;
    }

    public static final /* synthetic */ nc5.b access$getFileDeleteCanceller$p(AbsDriveListViewModel r0) {
        return r0.fileDeleteCanceller;
    }

    public static final /* synthetic */ nc5.b access$getFileRenameCanceller$p(AbsDriveListViewModel r0) {
        return r0.fileRenameCanceller;
    }

    public static final /* synthetic */ c2 access$getLarkDriveConfig(AbsDriveListViewModel r0) {
        return r0.getLarkDriveConfig();
    }

    public static final /* synthetic */ MutableLiveData access$get_files$p(AbsDriveListViewModel r0) {
        return r0._files;
    }

    public static final /* synthetic */ MutableLiveData access$get_hasMore$p(AbsDriveListViewModel r0) {
        return r0._hasMore;
    }

    public static final /* synthetic */ MutableLiveData access$get_isDownloading$p(AbsDriveListViewModel r0) {
        return r0._isDownloading;
    }

    public static final /* synthetic */ MutableLiveData access$get_isLoading$p(AbsDriveListViewModel r0) {
        return r0._isLoading;
    }

    public static final /* synthetic */ MutableLiveData access$get_loadMoreState$p(AbsDriveListViewModel r0) {
        return r0._loadMoreState;
    }

    private final void doDeleteFile(DriveFileItem r12) {
        List r0 = (List) this._files.getValue();
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        MutableLiveData<List<DriveFileItem>> r1 = this._files;
        ArrayList r2 = new ArrayList();
        Iterator r3 = r0.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        Object r4 = r3.next();
        if ((!Intrinsics.areEqual(((DriveFileItem) r4).b, r12.b)) == false) goto L7;
        r2.add(r4);
        goto L7
    L11:
        r1.setValue(r2);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AnonymousClass2(this, r12, null), 2, null);
    }

    private final void doUpdateFile(DriveFileItem r11) {
        List r0 = (List) this._files.getValue();
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        MutableLiveData<List<DriveFileItem>> r1 = this._files;
        List r2 = r0;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        DriveFileItem r5 = (DriveFileItem) r4.next();
        if (Intrinsics.areEqual(r5.b, r11.b) == false) goto L11;
        r5 = r11;
    L11:
        r3.add(r5);
        goto L7
    L12:
        r1.setValue(r3);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C05372(this, r11, null), 2, null);
    }

    private static final int fileListFetchLength_delegate$lambda$3(AbsDriveListViewModel r0) {
        return r0.getLarkDriveConfig().c();
    }

    private final List<DriveFileItem> filterOnlyFolderIfRequired(List<DriveFileItem> r5) {
        if (this.showOnlyFolder == false) goto L20;
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L14;
        Object r1 = r6.next();
        if (((DriveFileItem) r1).j != DriveFileType.FOLDER) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L6;
        r0.add(r1);
        goto L6
    L10:
        r2 = false;
        goto L11
    L14:
        return r0;
    L20:
        return r5;
    }

    private static final CharSequence handleSelectPanelAction$lambda$12(DriveFileItem r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return r1.b;
    }

    private static final CharSequence handleSelectPanelAction$lambda$13(DriveFileItem r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return r1.a;
    }

    private static final CharSequence handleSelectPanelAction$lambda$14(DriveFileItem r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        String r0 = com.larus.drive.biz.impl.utils.e.a;
        return com.larus.drive.biz.impl.utils.e.c(r1.j);
    }

    private static final CharSequence handleSelectPanelAction$lambda$15(DriveFileItem r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return com.larus.drive.biz.impl.utils.e.b(r1);
    }

    private static final List mediaSupportSaveToAlbum_delegate$lambda$1(AbsDriveListViewModel r0) {
        List r1 = r0.getLarkDriveConfig().g();
        if (r1 == null) goto L5;
        return r1;
    L5:
        return CollectionsKt.emptyList();
    }

    private static final long picMaxSize_delegate$lambda$2(AbsDriveListViewModel r4) {
        ImFileUtil.a.getClass();
        return Math.min(ImFileUtil.j(), r4.getLarkDriveConfig().h());
    }

    private final List<DriveFileItem> removeExcludedFolder(List<DriveFileItem> r5) {
        if (this.showOnlyFolder == false) goto L17;
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L11;
        Object r1 = r6.next();
        if ((!Intrinsics.areEqual(((DriveFileItem) r1).c, this.excludeDriveToken)) == false) goto L6;
        r0.add(r1);
        goto L6
    L11:
        return r0;
    L17:
        return r5;
    }

    private final void saveLocalInitialData(List<DriveFileItem> r7) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C05421(this, r7, null), 2, null);
    }

    public final void deleteFile(DriveFileItem r8) {
        Intrinsics.checkNotNullParameter(r8, "file");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new AnonymousClass1(this, r8, null), 2, null);
    }

    public final String formatFileTime(long r2) {
        return DriveSdkService.a.x(r2);
    }

    public final DriveFileItem getFileFromLocalList(String r5) {
        Intrinsics.checkNotNullParameter(r5, "fileToken");
        List r0 = (List) this._files.getValue();
        Object r1 = null;
        if (r0 == null) goto L15;
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((DriveFileItem) r3).b, r5) == false) goto L6;
        r1 = r3;
    L11:
        return (DriveFileItem) r1;
    L15:
        return null;
    }

    public final void loadMoreFiles(boolean r9) {
        if (this._loadMoreState.getValue() != DriveFileListAdapterFooterState.FAIL) goto L7;
        if (r9 == true) goto L7;
        FLogger.a.d(TAG, "loadMoreFiles: already failed, skip auto loadMore");
        return;
    L7:
        Object r10 = this._loadMoreState.getValue();
        DriveFileListAdapterFooterState r0 = DriveFileListAdapterFooterState.LOADING;
        if (r10 != r0) goto L12;
        FLogger.a.d(TAG, "loadMoreFiles: already loading more, skip");
        return;
    L12:
        if (Intrinsics.areEqual(this._hasMore.getValue(), Boolean.TRUE) == true) goto L16;
        FLogger.a.i(TAG, "loadMoreFiles: no more items");
        return;
    L16:
        if (this.loadMoreFileListLabel != null) goto L19;
        FLogger.a.i(TAG, "loadMoreFiles: no loadMoreFileListLabel");
        return;
    L19:
        this._loadMoreState.setValue(r0);
        this._errorMessage.setValue(null);
        this._isLoading.postValue(Boolean.FALSE);
        nc5.b r11 = this.fileListLoadingCanceller;
        if (r11 == null) goto L22;
        r11.cancel();
    L22:
        this.fileListLoadingCanceller = IDriveSdkService.a.c(DriveSdkService.a, getDriveListLoadType(), this.folderToken, this.showOnlyFolder, getFileListFetchLength(), this.loadMoreFileListLabel, new C05411(this), 32);
    }

    public final void setExcludeDriveTokenValue(String r1) {
        this.excludeDriveToken = r1;
    }

    public final void setFolderDriveToken(String r1) {
        this.folderDriveToken = r1;
    }

    public final void setFolderToken(String r1) {
        this.folderToken = r1;
    }

    public final void setForbidLoadingAnimFunc(Function0<Unit> r1) {
        this.forbidLoadingAnimFunc = r1;
    }

    public final void setLatestRefreshMark(String r1) {
        this.latestRefreshMark = r1;
    }

    public final void setLatestRefreshTask(Function1<? super String, Unit> r1) {
        this.latestRefreshTask = r1;
    }

    public final void setShowOnlyFolder(boolean r1) {
        this.showOnlyFolder = r1;
    }

    public final void updateFile(DriveFileItem r8) {
        Intrinsics.checkNotNullParameter(r8, "file");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new C05441(this, r8, null), 2, null);
    }

    public static final /* synthetic */ void access$doDeleteFile(AbsDriveListViewModel r0, DriveFileItem r1) {
        r0.doDeleteFile(r1);
    }

    public static final /* synthetic */ void access$doUpdateFile(AbsDriveListViewModel r0, DriveFileItem r1) {
        r0.doUpdateFile(r1);
    }

    public static final /* synthetic */ List access$filterOnlyFolderIfRequired(AbsDriveListViewModel r0, List r1) {
        return r0.filterOnlyFolderIfRequired(r1);
    }

    public static final /* synthetic */ List access$removeExcludedFolder(AbsDriveListViewModel r0, List r1) {
        return r0.removeExcludedFolder(r1);
    }

    public static final /* synthetic */ void access$saveLocalInitialData(AbsDriveListViewModel r0, List r1) {
        r0.saveLocalInitialData(r1);
    }

    public static final /* synthetic */ void access$setFileDeleteCanceller$p(AbsDriveListViewModel r0, nc5.b r1) {
        r0.fileDeleteCanceller = r1;
    }

    public static final /* synthetic */ void access$setFileListLoadingCanceller$p(AbsDriveListViewModel r0, nc5.b r1) {
        r0.fileListLoadingCanceller = r1;
    }

    public static final /* synthetic */ void access$setFileRenameCanceller$p(AbsDriveListViewModel r0, nc5.b r1) {
        r0.fileRenameCanceller = r1;
    }

    public static final /* synthetic */ void access$setLoadMoreFileListLabel$p(AbsDriveListViewModel r0, String r1) {
        r0.loadMoreFileListLabel = r1;
    }

    public static final /* synthetic */ void access$setReturnToTopWhenFileListUpdate$p(AbsDriveListViewModel r0, boolean r1) {
        r0.returnToTopWhenFileListUpdate = r1;
    }

    private final void askAI(final AbsDriveListFragment r4, final DriveFileItem r5) {
        DriveSdkService.a.C(r5, ViewModelKt.getViewModelScope(this), new i(this, r4, r5), new j());
    }

    private final void deleteMultiFiles(final Fragment r13, final List<DriveFileItem> r14) {
        if (r14.isEmpty() == false) goto L5;
        return;
    L5:
        nc5.b r0 = this.fileDeleteCanceller;
        if (r0 == null) goto L8;
        r0.cancel();
    L8:
        AtomicLong r1 = h79.b.a;
        final long r2 = h79.b.b(r13.getActivity(), r13, r13.getString(2131899715));
        this.fileDeleteCanceller = DriveSdkService.a.q(r14, getDriveListLoadType(), new k(this, r14, r2, r13), new l(this, r14, r2, r13));
    }

    private final void doAskAi(AbsDriveListFragment r8, DriveFileItem r9) {
        Context r0 = r8.getActivity();
        if (r0 != null) goto L8;
        r0 = r8.getContext();
        if (r0 != null) goto L8;
        return;
    L8:
        DriveSdkService.a.z(r9);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C05361(r0, r9, null), 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$downloadFile$1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void downloadFile(final AbsDriveListFragment r5, DriveFileItem r6) {
        FragmentActivity r0 = r5.getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        Object r1 = this._isDownloading.getValue();
        Boolean r2 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r2) == false) goto L8;
        return;
    L8:
        PolarisFileWrapper r3 = new PolarisFileWrapper(r0.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "");
        if (r3.exists() == true) goto L11;
        r3.mkdirs();
    L11:
        this._isDownloading.setValue(r2);
        this.latestDownloadingTaskKey = DriveSdkService.a.r(r6.b, r3.getAbsolutePath(), DriveDownloadPriority.HIGHEST, new C05381(this, r5));
    }

    private static final Unit onUploadSuccessCallback$lambda$4(AbsDriveListViewModel r6, com.larus.drive.biz.api.model.a r7) {
        Intrinsics.checkNotNullParameter(r7, "item");
        if (Intrinsics.areEqual(r7.e, r6.folderDriveToken) == false) goto L5;
    L16:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(r6), Dispatchers.getIO(), null, new AbsDriveListViewModel$onUploadSuccessCallback$1$1(r6, null), 2, null);
    L18:
        return Unit.INSTANCE;
    L5:
        if (StringsKt.isBlank(r7.e) == false) goto L15;
        String r8 = r6.folderDriveToken;
        if (r8 != null) goto L9;
    L12:
        boolean r9 = true;
    L13:
        if (r9 == true) goto L16;
    L9:
        if (StringsKt.isBlank(r8) == true) goto L12;
        r9 = false;
    L15:
        if ((r6 instanceof DriveRecentListViewModel) == false) goto L18;
        goto L16
    }

    private final void shareDriveFile(DriveFileItem r2, kw9.c r3) {
        DriveSdkService.a.P(r2, r3);
    }

    private final void showDeleteConfirmDialog(Fragment r7, DriveFileItem r8) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05431(r7, this, r8, null), 3, null);
    }

    public final void doRefreshTask(String r2, String r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r2, this.latestRefreshMark) == false) goto L12;
        Function1<? super String, Unit> r4 = this.latestRefreshTask;
        if (r4 == null) goto L9;
        r4.invoke(r3);
    L9:
        this.latestRefreshTask = null;
        return;
    }

    public List<ot8.a> getLongClickMenuList(Context r87, DriveFileItem r88) {
        Intrinsics.checkNotNullParameter(r87, "ctx");
        Intrinsics.checkNotNullParameter(r88, "file");
        ArrayList r3 = new ArrayList();
        if (UploadFilePolicy.e(r88.d(false)) == true) goto L5;
    L13:
        r3.add(new l0(MENU_ID_SHARE, 0, r87.getString(2131905331), null, null, null, null, 2131241253, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -134, 127));
        if (r88.j == DriveFileType.FOLDER) goto L24;
        if (CollectionsKt.listOf(new DriveFileType[]{DriveFileType.IMAGE, DriveFileType.VIDEO}).contains(r88.j) == true) goto L18;
        String r10 = r87.getString(2131905327);
    L22:
        r3.add(new l0(MENU_ID_DOWNLOAD, 0, r10, null, null, null, null, 2131241249, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -134, 127));
        goto L24
    L18:
        if (getMediaSupportSaveToAlbum().contains(r88.d(true).toLowerCase(Locale.ROOT)) == false) goto L20;
        r10 = r87.getString(2131905330);
        goto L22
    L20:
        r10 = r87.getString(2131905327);
    L24:
        if (getLarkDriveConfig().a() == false) goto L27;
        r3.add(new l0(MENU_ID_MULTI_SELECT, 0, r87.getString(2131907411), null, null, null, null, 2131241250, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -134, 127));
    L27:
        if (r88.g() == false) goto L29;
    L32:
        r3.add(new i0(2, ContextCompat.getColor(r87, v19.c.b(2130972086, r87, 2131103159))));
        if (CollectionsKt.listOf(new DriveFileType[]{DriveFileType.AI_SLIDES, DriveFileType.AI_DOC, DriveFileType.AI_SHEET}).contains(r88.j) == true) goto L35;
        r3.add(new l0(MENU_ID_RENAME, 0, r87.getString(2131905329), null, null, null, null, 2131241252, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -134, 127));
    L35:
        r3.add(new l0(MENU_ID_MOVE, 0, r87.getString(2131905328), null, null, null, null, 2131241251, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -134, 127));
    L36:
        r3.add(new l0(MENU_ID_DELETE, 0, r87.getString(2131905326), null, null, 2131102650, null, 2131241248, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -166, 127));
        return r3;
    L29:
        if ((this instanceof DriveMineListViewModel) == true) goto L32;
        if ((this instanceof DriveFolderListViewModel) == false) goto L36;
    L5:
        if (CollectionsKt.listOf(new DriveFileType[]{DriveFileType.AI_SLIDES, DriveFileType.AI_DOC, DriveFileType.AI_SHEET}).contains(r88.j) == true) goto L13;
        if (r88.j != DriveFileType.IMAGE) goto L11;
        if (r88.e() > getPicMaxSize()) goto L13;
    L11:
        if (r88.b() == true) goto L13;
        r3.add(new l0(MENU_ID_ASK, 0, StringsKt.replace$default(r87.getString(2131905325), "%s", r87.getString(2131894309), false, 4, null), null, null, null, null, 2131241247, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -134, 127));
        r3.add(new i0(1, ContextCompat.getColor(r87, v19.c.b(2130972086, r87, 2131103159))));
        goto L13
    }

    public final void loadFiles(Function0<Unit> r9, boolean r10) {
        Object r0 = this._isLoading.getValue();
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == false) goto L6;
        FLogger.a.d(TAG, "loadFiles: already loading, skip");
        return;
    L6:
        if (r9 == null) goto L8;
        r9.invoke();
    L8:
        if (r10 == false) goto L12;
        Function0<Unit> r11 = this.forbidLoadingAnimFunc;
        if (r11 == null) goto L12;
        r11.invoke();
    L12:
        this._isLoading.setValue(r1);
        this._errorMessage.setValue(null);
        this._loadMoreState.postValue(DriveFileListAdapterFooterState.IDLE);
        nc5.b r12 = this.fileListLoadingCanceller;
        if (r12 == null) goto L15;
        r12.cancel();
    L15:
        this.fileListLoadingCanceller = IDriveSdkService.a.c(DriveSdkService.a, getDriveListLoadType(), this.folderToken, this.showOnlyFolder, getFileListFetchLength(), null, new C05391(this), 32);
    }

    public final void refreshFiles(Function0<Unit> r1, boolean r2) {
        loadFiles(r1, r2);
    }

    public static void INVOKEVIRTUAL_com_larus_drive_biz_impl_viewmodel_AbsDriveListViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(CommonDialog r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        CommonDialog r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static final /* synthetic */ void access$deleteMultiFiles(AbsDriveListViewModel r0, Fragment r1, List r2) {
        r0.deleteMultiFiles(r1, r2);
    }

    private final void showMultiDeleteConfirmDialog(Fragment r7, List<DriveFileItem> r8, Function0<Unit> r9) {
        List<DriveFileItem> r0 = r8;
        boolean r1 = r0 instanceof Collection;
        if (r1 == true) goto L5;
    L7:
        Iterator<T> r4 = r0.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        if (((DriveFileItem) r4.next()).g() == true) goto L9;
        boolean r5 = false;
    L14:
        if (r5 == false) goto L16;
        int r2 = 2131899714;
    L32:
        CommonDialog.a r3 = new CommonDialog.a();
        r3.i(r7.getString(2131899712));
        r3.g(r7.getString(r2));
        r3.b = true;
        CommonDialog.a.e(r3, new c(), r7.getString(2131899534), 4);
        CommonDialog.a.f(r3, new d(r9, this, r7, r8), r7.getString(2131899533), false, 12);
        INVOKEVIRTUAL_com_larus_drive_biz_impl_viewmodel_AbsDriveListViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r3.a(), r7.getParentFragmentManager(), "drive_multi_delete_confirm");
        return;
    L16:
        if (r1 == true) goto L18;
    L20:
        Iterator<T> r6 = r0.iterator();
    L22:
        if (r6.hasNext() == false) goto L26;
        if (((DriveFileItem) r6.next()).g() == false) goto L22;
        boolean r10 = false;
    L27:
        if (r10 == true) goto L29;
    L31:
        r2 = 2131899710;
        goto L32
    L29:
        if ((this instanceof DriveRecentListViewModel) == false) goto L31;
        r2 = 2131899711;
    L26:
        r10 = true;
        goto L27
    L18:
        if (r0.isEmpty() == false) goto L20;
    L13:
        r5 = true;
        goto L14
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    private final void showRenameDialog(Fragment r3, DriveFileItem r4, Function0<Unit> r5) {
        int r0 = DriveInputConfirmDialog.n;
        DriveInputConfirmDialog.a r1 = new DriveInputConfirmDialog.a();
        r1.a = r3.getString(2131905349);
        r1.d = r3.getString(2131905348);
        r1.e = r3.getString(2131905347);
        r1.b = r4.c();
        r1.f = r3.getString(2131905396);
        e r2 = new e(this, r4, r3, r5);
        Intrinsics.checkNotNullParameter(r2, "callback");
        r1.g = r2;
        INVOKEVIRTUAL_com_larus_drive_biz_impl_viewmodel_AbsDriveListViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r1.a(), r3.getParentFragmentManager(), null);
    }

    private static final Unit startMoveDriveFileTask$lambda$27(AbsDriveListViewModel r1, DriveFileItem r2, String r3) {
        if (Intrinsics.areEqual(r1.folderToken, r3) == true) goto L6;
        r1.deleteFile(r2);
    L6:
        return Unit.INSTANCE;
    }

    public final void handleMenuClick(ot8.a r23, AbsDriveListFragment r24, DriveFileItem r25) {
        Intrinsics.checkNotNullParameter(r23, "item");
        Intrinsics.checkNotNullParameter(r24, "fragment");
        Intrinsics.checkNotNullParameter(r25, "file");
        switch(r23.getId()) {
            case 10001: goto L33;
            case 10002: goto L32;
            case 10003: goto L25;
            case 10004: goto L24;
            case 10005: goto L23;
            case 10006: goto L22;
            case 10007: goto L5;
            default: goto L4;
        };
    L4:
        String r0 = null;
    L34:
        String r8 = r0;
        String r14 = r25.b;
        String r15 = r25.a;
        String r1 = com.larus.drive.biz.impl.utils.e.a;
        String r16 = com.larus.drive.biz.impl.utils.e.c(r25.j);
        String r17 = com.larus.drive.biz.impl.utils.e.b(r25);
        WeakReference<DriveMainFragment> r2 = DriveMainFragment.w;
        u0.d("long_press", r8, null, null, null, null, null, r14, r15, r16, r17, null, null, DriveMainFragment.a.a(), 6268);
        return;
    L5:
        r24.getClass();
        Intrinsics.checkNotNullParameter(r25, "initial");
        String r3 = r25.b;
        if (StringsKt.isBlank(r3) == false) goto L9;
    L21:
        r0 = "multiple_select";
        goto L34
    L9:
        if (r24.r == true) goto L21;
        r24.r = true;
        r24.s.clear();
        r24.s.add(r3);
        r24.t.clear();
        r24.t.put(r3, r25);
        DriveFileListAdapter r4 = r24.g;
        if (r4 == null) goto L14;
        r4.t0(true);
    L14:
        DriveFileListAdapter r5 = r24.g;
        if (r5 == null) goto L17;
        r5.C0(new HashSet(r24.s));
    L17:
        r24.ha0(true);
        o79.g r6 = r24.U90();
        if (r6 == null) goto L20;
        r6.pg(r24);
    L20:
        r24.Y90();
        goto L21
    L22:
        showMultiDeleteConfirmDialog$default(this, r24, CollectionsKt.listOf(r25), null, 4, null);
        r0 = "delete";
        goto L34
    L23:
        startMoveDriveFileTask(r25, r24.getActivity(), false);
        r0 = "move";
        goto L34
    L24:
        showRenameDialog$default(this, r24, r25, null, 4, null);
        r0 = "rename";
        goto L34
    L25:
        FragmentActivity r7 = r24.getActivity();
        if (r7 == null) goto L31;
        IFlowSdkDepend r9 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r9 == null) goto L30;
        r9.D0();
        b1.a.c("office_drive_long_press_download");
    L30:
        IDriveSdkService.a.a(DriveSdkService.a, r25, r7, ViewModelKt.getViewModelScope(this), r24);
    L31:
        r0 = "download";
        goto L34
    L32:
        shareDriveFile(r25, new kw9.c("ai_space_list"));
        r0 = "share";
        goto L34
    L33:
        askAI(r24, r25);
        r0 = "ai_read";
        goto L34
    }

    public final void handleSelectPanelAction(DriveSelectActionType r26, AbsDriveListFragment r27, List<DriveFileItem> r28) {
        Intrinsics.checkNotNullParameter(r26, "actionType");
        Intrinsics.checkNotNullParameter(r27, "fragment");
        Intrinsics.checkNotNullParameter(r28, "selectedFiles");
        if (r28.isEmpty() == false) goto L5;
        return;
    L5:
        int[] r4 = b.a;
        switch(r4[r26.ordinal()]) {
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            default: goto L8;
        };
    L9:
        AbsDriveListViewModel$handleSelectPanelAction$onActionConfirmed$1 r5 = null;
    L12:
        switch(r4[r26.ordinal()]) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            default: goto L14;
        };
    L15:
        String r6 = "move";
    L21:
        String r7 = r6;
        if (r28.size() != 1) goto L25;
        DriveFileItem r8 = (DriveFileItem) CollectionsKt.first(r28);
        String r13 = r8.b;
        String r14 = r8.a;
        String r9 = com.larus.drive.biz.impl.utils.e.a;
        String r15 = com.larus.drive.biz.impl.utils.e.c(r8.j);
        String r16 = com.larus.drive.biz.impl.utils.e.b(r8);
        WeakReference<DriveMainFragment> r10 = DriveMainFragment.w;
        u0.d("long_press", r7, null, null, null, null, null, r13, r14, r15, r16, "TRUE", null, DriveMainFragment.a.a(), 4220);
        handleSingleSelectPanelAction(r26, r27, (DriveFileItem) CollectionsKt.first(r28), r5);
        return;
    L25:
        List<DriveFileItem> r11 = r28;
        String r22 = CollectionsKt.joinToString$default(r11, ",", null, null, 0, null, new com.larus.drive.biz.impl.viewmodel.a(), 30, null);
        String r23 = CollectionsKt.joinToString$default(r11, ",", null, null, 0, null, new f(), 30, null);
        String r24 = CollectionsKt.joinToString$default(r11, ",", null, null, 0, null, new g(), 30, null);
        String r17 = CollectionsKt.joinToString$default(r11, ",", null, null, 0, null, new h(), 30, null);
        WeakReference<DriveMainFragment> r12 = DriveMainFragment.w;
        u0.d("long_press", r7, null, null, null, null, null, r22, r23, r24, r17, "TRUE", null, DriveMainFragment.a.a(), 4220);
        if (r26 != DriveSelectActionType.DELETE) goto L28;
        showMultiDeleteConfirmDialog(r27, r28, r5);
        return;
    L28:
        FLogger.a.i(TAG, "Ignore multi select action[" + r26 + "], count[" + r28.size() + ']');
        return;
    L16:
        r6 = "download";
        goto L21
    L17:
        r6 = "share";
        goto L21
    L18:
        r6 = "ai_read";
        goto L21
    L19:
        r6 = "rename";
        goto L21
    L20:
        r6 = "delete";
        goto L21
    L14:
        throw new NoWhenBranchMatchedException();
    L10:
        r5 = new AbsDriveListViewModel$handleSelectPanelAction$onActionConfirmed$1(r27);
        goto L12
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @Override // u79.a
    public void startMoveDriveFileTask(final DriveFileItem r8, Context r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "file");
        if (r10 == false) goto L5;
        String r11 = "common_refresh_mark_outer";
    L6:
        String r6 = r11;
        this.latestRefreshMark = r6;
        this.latestRefreshTask = new com.larus.drive.biz.impl.viewmodel.e(this, r8);
        int r12 = DriveMoveListActivity.h;
        DriveMoveListActivity.a.a(r9, r8.b, r8.c, r8.d, this.folderToken, this.folderDriveToken, r6);
        return;
    L5:
        r11 = String.valueOf(System.currentTimeMillis());
        goto L6
    }

    public static void INVOKEVIRTUAL_com_larus_drive_biz_impl_viewmodel_AbsDriveListViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(DriveInputConfirmDialog r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        DriveInputConfirmDialog r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    private static final Unit askAI$lambda$17(AbsDriveListViewModel r0, AbsDriveListFragment r1, DriveFileItem r2, String r3) {
        r0.doAskAi(r1, r2);
        return Unit.INSTANCE;
    }

    private static final Unit deleteMultiFiles$lambda$23(AbsDriveListViewModel r2, List r3, long r4, Fragment r6) {
        r2.fileDeleteCanceller = null;
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        DriveFileItem r7 = (DriveFileItem) r5.next();
        CopyOnWriteArrayList<WeakReference<AbsDriveListViewModel>> r0 = com.larus.drive.biz.impl.utils.f.a;
        com.larus.drive.biz.impl.utils.f.a(r7.b);
        goto L4
    L6:
        AtomicLong r8 = h79.b.a;
        FragmentActivity r9 = r6.getActivity();
        String r10 = r6.getString(2131899713);
        Intrinsics.checkNotNullParameter(r10, "text");
        if (h79.b.b != r4) goto L9;
        h79.b.b = 0;
    L9:
        t19.s r11 = t19.s.a;
        r11.a();
        String r12 = r10.toString();
        r11.getClass();
        t19.s.p(r9, r12);
        return Unit.INSTANCE;
    }

    private final void handleSingleSelectPanelAction(DriveSelectActionType r2, AbsDriveListFragment r3, DriveFileItem r4, Function0<Unit> r5) {
        switch(b.a[r2.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        startMoveDriveFileTask(r4, r3.getActivity(), false);
        return;
    L7:
        FragmentActivity r6 = r3.getActivity();
        if (r6 == null) goto L16;
        IDriveSdkService.a.a(DriveSdkService.a, r4, r6, ViewModelKt.getViewModelScope(this), r3);
        return;
    L16:
        return;
    L10:
        shareDriveFile(r4, new kw9.c("ai_space_list"));
        return;
    L11:
        askAI(r3, r4);
        return;
    L12:
        showRenameDialog(r3, r4, r5);
        return;
    L13:
        showMultiDeleteConfirmDialog(r3, CollectionsKt.listOf(r4), r5);
        return;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ void loadMoreFiles$default(AbsDriveListViewModel r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.loadMoreFiles(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadMoreFiles");
    }

    private static final Unit deleteMultiFiles$lambda$26(AbsDriveListViewModel r2, List r3, long r4, Fragment r6, Map r7) {
        Intrinsics.checkNotNullParameter(r7, "failFileWithCode");
        r2.fileDeleteCanceller = null;
        Set r5 = r7.keySet();
        ArrayList r8 = new ArrayList();
        Iterator r9 = r3.iterator();
    L4:
        if (r9.hasNext() == false) goto L8;
        Object r0 = r9.next();
        if (r5.contains(((DriveFileItem) r0).b) == true) goto L4;
        r8.add(r0);
        goto L4
    L8:
        Iterator r10 = r8.iterator();
    L10:
        if (r10.hasNext() == false) goto L12;
        DriveFileItem r11 = (DriveFileItem) r10.next();
        CopyOnWriteArrayList<WeakReference<AbsDriveListViewModel>> r12 = com.larus.drive.biz.impl.utils.f.a;
        com.larus.drive.biz.impl.utils.f.a(r11.b);
        goto L10
    L12:
        AtomicLong r13 = h79.b.a;
        h79.b.c(r4, r6.getActivity(), r6.getString(2131899537));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loadFiles$default(AbsDriveListViewModel r0, Function0 r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L12;
        if ((r3 & 1) == 0) goto L7;
        r1 = null;
    L7:
        if ((r3 & 2) == 0) goto L9;
        r2 = false;
    L9:
        r0.loadFiles(r1, r2);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadFiles");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void refreshFiles$default(AbsDriveListViewModel r0, Function0 r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L12;
        if ((r3 & 1) == 0) goto L7;
        r1 = null;
    L7:
        if ((r3 & 2) == 0) goto L9;
        r2 = false;
    L9:
        r0.refreshFiles(r1, r2);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshFiles");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showMultiDeleteConfirmDialog$default(AbsDriveListViewModel r0, Fragment r1, List r2, Function0 r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        r0.showMultiDeleteConfirmDialog(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMultiDeleteConfirmDialog");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showRenameDialog$default(AbsDriveListViewModel r0, Fragment r1, DriveFileItem r2, Function0 r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        r0.showRenameDialog(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showRenameDialog");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleSingleSelectPanelAction$default(AbsDriveListViewModel r0, DriveSelectActionType r1, AbsDriveListFragment r2, DriveFileItem r3, Function0 r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 8) == 0) goto L6;
        r4 = null;
    L6:
        r0.handleSingleSelectPanelAction(r1, r2, r3, r4);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleSingleSelectPanelAction");
    }
}
