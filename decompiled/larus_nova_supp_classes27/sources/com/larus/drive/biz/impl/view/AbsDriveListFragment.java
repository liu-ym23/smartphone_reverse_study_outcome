package com.larus.drive.biz.impl.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.screenmenu.x0;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.impl.activity.DriveFolderActivity;
import com.larus.drive.biz.impl.adapter.DriveFileListAdapter;
import com.larus.drive.biz.impl.adapter.DriveFileListAdapterFooterState;
import com.larus.drive.biz.impl.databinding.LarusDriveFileListBinding;
import com.larus.drive.biz.impl.dialog.DriveDownloadingDialog;
import com.larus.drive.biz.impl.sdk.DriveSdkService;
import com.larus.drive.biz.impl.view.fileselect.DriveSelectActionType;
import com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel;
import com.larus.drive.biz.impl.viewmodel.DriveFolderListViewModel;
import com.larus.drive.biz.impl.viewmodel.DriveRecentListViewModel;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.meta.PreviewFromPage;
import com.larus.home.api.main.HomeService;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.u0;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000³\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010*\u0001A\b&\u0018\u0000 \u0087\u00012\u00020\u0001:\u0002\u0087\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u000101J\u0006\u0010-\u001a\u00020>J&\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u001a\u0010K\u001a\u00020>2\u0006\u0010L\u001a\u00020D2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u0010\u0010M\u001a\u00020>2\u0006\u0010N\u001a\u00020OH\u0016J\b\u0010P\u001a\u00020>H\u0004J\b\u0010Q\u001a\u00020>H\u0016J\b\u0010R\u001a\u00020>H\u0016J\b\u0010S\u001a\u00020>H\u0002J\u0010\u0010T\u001a\u00020>2\b\b\u0002\u0010U\u001a\u00020\u000bJ\b\u0010V\u001a\u00020>H\u0002J\b\u0010W\u001a\u00020>H\u0014J\"\u0010X\u001a\u00020>2\u0010\b\u0002\u0010Y\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010Z2\b\b\u0002\u0010U\u001a\u00020\u000bJ\u0006\u0010]\u001a\u00020>J\u0010\u0010^\u001a\u00020>2\u0006\u0010$\u001a\u00020\u000bH\u0002J\b\u0010_\u001a\u00020>H\u0002J\b\u0010`\u001a\u00020>H\u0002J\b\u0010a\u001a\u00020>H\u0014J\b\u0010b\u001a\u00020>H\u0014J\u0016\u0010c\u001a\u00020>2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020408H\u0004J\u001c\u0010e\u001a\u00020>2\u0006\u0010f\u001a\u0002042\n\b\u0002\u0010g\u001a\u0004\u0018\u00010DH\u0014J\u0014\u0010h\u001a\u0004\u0018\u00010D2\b\u0010g\u001a\u0004\u0018\u00010DH\u0002J\u0018\u0010i\u001a\u00020\u000b2\u0006\u0010f\u001a\u0002042\u0006\u0010L\u001a\u00020DH\u0014J\b\u0010j\u001a\u00020\u000bH\u0004J\u000e\u0010k\u001a\u00020>2\u0006\u0010l\u001a\u000204J\u0006\u0010m\u001a\u00020>J\u0010\u0010n\u001a\u00020>2\u0006\u0010.\u001a\u00020\u000bH\u0002J\u0010\u0010o\u001a\u00020>2\u0006\u0010f\u001a\u000204H\u0002J\b\u0010p\u001a\u00020>H\u0002J\u000e\u0010q\u001a\u00020>2\u0006\u0010r\u001a\u00020sJ\u0006\u0010t\u001a\u00020>J\u0010\u0010u\u001a\u00020\u000b2\u0006\u0010r\u001a\u00020sH\u0002J\u0016\u0010v\u001a\u00020>2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020408H\u0002J\n\u0010w\u001a\u0004\u0018\u00010xH\u0002J\u0018\u0010y\u001a\u00020>2\u0006\u0010f\u001a\u0002042\u0006\u0010z\u001a\u00020DH\u0002J\u0010\u0010{\u001a\u00020>2\u0006\u0010|\u001a\u000201H\u0014J\b\u0010}\u001a\u00020>H\u0016J\b\u0010~\u001a\u00020>H\u0016J\b\u0010\u007f\u001a\u000201H\u0014J\t\u0010\u0080\u0001\u001a\u00020\u000bH\u0014J\t\u0010\u0081\u0001\u001a\u00020\u000bH\u0014J\u000b\u0010\u0082\u0001\u001a\u0004\u0018\u00010DH\u0014J\u000b\u0010\u0083\u0001\u001a\u0004\u0018\u00010)H\u0004J\u000b\u0010\u0084\u0001\u001a\u0004\u0018\u00010)H\u0002J\u000f\u0010\u0085\u0001\u001a\u00020AH\u0002¢\u0006\u0003\u0010\u0086\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010\u001bR\u000e\u0010!\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010#R\u000e\u0010$\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0004\n\u0002\u0010,R\u000e\u0010-\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020100X\u0082\u0004¢\u0006\u0002\n\u0000R*\u00102\u001a\u001e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020403j\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000204`5X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R#\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u000101088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b9\u0010:R\u0010\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0004\n\u0002\u0010BR\u000e\u0010[\u001a\u00020\\X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0088\u0001"}, d2 = {"Lcom/larus/drive/biz/impl/view/AbsDriveListFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/drive/biz/impl/databinding/LarusDriveFileListBinding;", "getBinding", "()Lcom/larus/drive/biz/impl/databinding/LarusDriveFileListBinding;", "setBinding", "(Lcom/larus/drive/biz/impl/databinding/LarusDriveFileListBinding;)V", "isViewModelSetup", "", "viewModel", "Lcom/larus/drive/biz/impl/viewmodel/AbsDriveListViewModel;", "getViewModel", "()Lcom/larus/drive/biz/impl/viewmodel/AbsDriveListViewModel;", "setViewModel", "(Lcom/larus/drive/biz/impl/viewmodel/AbsDriveListViewModel;)V", "adapter", "Lcom/larus/drive/biz/impl/adapter/DriveFileListAdapter;", "getAdapter", "()Lcom/larus/drive/biz/impl/adapter/DriveFileListAdapter;", "setAdapter", "(Lcom/larus/drive/biz/impl/adapter/DriveFileListAdapter;)V", "isLoadingMoreState", "()Z", "setLoadingMoreState", "(Z)V", "hasMoreState", "getHasMoreState", "setHasMoreState", "isOnStart", "setOnStart", "hasTriggeredFirstVisibleLoad", "pendingHostTabActivationForbidLoadingAnim", "Ljava/lang/Boolean;", "isDownloading", "driveDownloadingDialog", "Lcom/larus/drive/biz/impl/dialog/DriveDownloadingDialog;", "parentMainFragmentRef", "Ljava/lang/ref/WeakReference;", "Lcom/larus/drive/biz/impl/view/DriveMainFragment;", "recyclerViewOriginalPaddingBottom", "", "Ljava/lang/Integer;", "forbidLoadingPullAnimOnce", "inSelectMode", "selectedTokens", "Ljava/util/LinkedHashSet;", "", "selectedFilesByToken", "Ljava/util/LinkedHashMap;", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "Lkotlin/collections/LinkedHashMap;", "tempEventShowFromParam", "fileCanNotSupportPreview", "", "getFileCanNotSupportPreview", "()Ljava/util/List;", "fileCanNotSupportPreview$delegate", "Lkotlin/Lazy;", "setEventShowFromParam", "", "showFrom", "driveFileListAdapterEventCallback", "com/larus/drive/biz/impl/view/AbsDriveListFragment$getDriveFileListAdapterEventCallback$1", "Lcom/larus/drive/biz/impl/view/AbsDriveListFragment$getDriveFileListAdapterEventCallback$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onAttach", "context", "Landroid/content/Context;", "loadLocalInitialData", "onStart", "onStop", "initDriveSdk", "onHostTabActivated", "forbidLoadingAnim", "consumePendingHostTabActivationIfNeeded", "setupViewModel", "refreshFiles", "onRefreshTriggered", "Lkotlin/Function0;", "lastScrollToTopAndReloadTime", "", "scrollToTopAndReload", "handleDownloadingState", "setupRecyclerView", "setupSwipeRefresh", "setupUploadBanner", "loadInitialData", "updateFileList", "files", "onFileClick", "file", "itemView", "getDrivePreviewStartView", "onFileLongClick", "isInSelectMode", "enterSelectMode", "initial", "exitSelectMode", "updateRecyclerViewBottomPadding", "toggleSelected", "notifySelectedFilesChanged", "handleSelectPanelAction", "actionType", "Lcom/larus/drive/biz/impl/view/fileselect/DriveSelectActionType;", "exitSelectModeAfterActionConfirmed", "shouldExitSelectModeImmediately", "syncSelectedFileCacheFromList", "getSelectModeHost", "Lcom/larus/drive/biz/impl/view/fileselect/IDrivePageSelectMode;", "showDriveLongClickMenu", "anchorView", "showErrorState", "errorMessage", "onDestroyView", "onDetach", "getTagName", "provideIsDialogMode", "showUploadBanner", "getEmptyView", "getDriveMainFragment", "resolveDriveMainFragment", "getDriveFileListAdapterEventCallback", "()Lcom/larus/drive/biz/impl/view/AbsDriveListFragment$getDriveFileListAdapterEventCallback$1;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsDriveListFragment extends Fragment {
    public static final /* synthetic */ int y = 0;
    public LarusDriveFileListBinding d;
    public boolean e;
    public AbsDriveListViewModel f;
    public DriveFileListAdapter g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public Boolean l;
    public boolean m;
    public DriveDownloadingDialog n;
    public WeakReference<DriveMainFragment> o;
    public Integer p;
    public boolean q;
    public boolean r;
    public final LinkedHashSet<String> s;
    public final LinkedHashMap<String, DriveFileItem> t;
    public String u;
    public final Lazy v;
    public final t w;
    public long x;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[DriveFileListAdapterFooterState.values().length];
            r0[DriveFileListAdapterFooterState.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[DriveFileListAdapterFooterState.FAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L6:
            a = r0;
            int[] r1 = new int[DriveSelectActionType.values().length];
            r1[DriveSelectActionType.DELETE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L37:
            r1[DriveSelectActionType.RENAME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L29:
            r1[DriveSelectActionType.ASK_AI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L31:
            r1[DriveSelectActionType.SHARE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L23:
            r1[DriveSelectActionType.DOWNLOAD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L33:
            r1[DriveSelectActionType.MOVE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L13:
            b = r1;
        }
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(Function1 r2) {
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

    public static final class d implements s79.a {
        public d() {
        }

        @Override // s79.a
        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "fileToken");
            com.larus.drive.biz.impl.utils.f.a(r2);
        }

        @Override // s79.a
        public final void b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "fileToken");
            Intrinsics.checkNotNullParameter(r3, "newFileName");
            com.larus.drive.biz.impl.utils.f.b(r2, r3);
        }
    }

    static {
    }

    public String V90() {
        return "AbsDriveFragment";
    }

    public boolean ca0() {
        return false;
    }

    public final DriveMainFragment S90() {
        WeakReference<DriveMainFragment> r0 = this.o;
        WeakReference<DriveMainFragment> r1 = null;
        if (r0 == null) goto L5;
        DriveMainFragment r2 = r0.get();
    L6:
        if (r2 != null) goto L8;
    L10:
        Fragment r3 = getParentFragment();
    L11:
        if (r3 == null) goto L16;
        if ((r3 instanceof DriveMainFragment) == true) goto L14;
        r3 = r3.getParentFragment();
        goto L11
    L14:
        DriveMainFragment r4 = (DriveMainFragment) r3;
    L17:
        if (r4 != null) goto L19;
        WeakReference<DriveMainFragment> r5 = DriveMainFragment.w;
        r4 = DriveMainFragment.a.a();
    L19:
        if (r4 == null) goto L21;
        r1 = new WeakReference(r4);
    L21:
        this.o = r1;
        return r4;
    L16:
        r4 = null;
        goto L17
    L8:
        if (r2.isAdded() == false) goto L10;
        return r2;
    L5:
        r2 = null;
        goto L6
    }

    public View T90() {
        LarusDriveFileListBinding r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public final AbsDriveListViewModel W90() {
        AbsDriveListViewModel r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final void ea0() {
        if (this.e == true) goto L5;
        return;
    L5:
        long r0 = SystemClock.elapsedRealtime();
        if ((r0 - this.x) >= 1000) goto L8;
        return;
    L8:
        this.x = r0;
        LarusDriveFileListBinding r1 = this.d;
        if (r1 == null) goto L11;
        RecyclerView r2 = r1.e;
    L12:
        if (r2 == null) goto L14;
        r2.stopScroll();
    L14:
        if (r2 == null) goto L16;
        RecyclerView.LayoutManager r3 = r2.getLayoutManager();
    L18:
        if ((r3 instanceof LinearLayoutManager) == false) goto L20;
        LinearLayoutManager r4 = (LinearLayoutManager) r3;
    L22:
        if (r4 == null) goto L24;
        r4.scrollToPositionWithOffset(0, 0);
    L24:
        AbsDriveListViewModel.loadFiles$default(W90(), null, false, 3, null);
        return;
    L20:
        r4 = null;
        goto L22
    L16:
        r3 = null;
        goto L18
    L11:
        r2 = null;
        goto L12
    }

    public void fa0() {
        if ((!(this instanceof DriveMoveListFragment)) == true) goto L5;
        return;
    L5:
        com.larus.drive.biz.impl.file.t.f.observe(getViewLifecycleOwner(), new c(new s(this)));
    }

    public final void j() {
        if (this.r == true) goto L5;
        return;
    L5:
        this.r = false;
        this.s.clear();
        this.t.clear();
        DriveFileListAdapter r1 = this.g;
        if (r1 == null) goto L8;
        r1.C0(SetsKt.emptySet());
    L8:
        DriveFileListAdapter r2 = this.g;
        if (r2 == null) goto L11;
        r2.t0(false);
    L11:
        ha0(false);
        Y90();
    }

    public AbsDriveListFragment() {
        this.i = true;
        this.s = new LinkedHashSet();
        this.t = new LinkedHashMap();
        this.v = LazyKt.lazy(new q());
        this.w = new t(this);
    }

    public final o79.g U90() {
        o79.g r0 = getParentFragment();
        if ((r0 instanceof o79.g) == true) goto L5;
        o79.g r1 = getActivity();
        if ((r1 instanceof o79.g) == true) goto L9;
        WeakReference<DriveMainFragment> r2 = DriveMainFragment.w;
        return DriveMainFragment.a.a();
    L9:
        return r1;
    L5:
        return r0;
    }

    public final void Y90() {
        o79.g r0 = U90();
        if (r0 == null) goto L6;
        r0.F70(CollectionsKt.toList(this.t.values()));
        return;
    }

    public void ga0() {
        W90().setForbidLoadingAnimFunc(new com.larus.drive.biz.impl.view.a(this));
        W90().getFiles().observe(getViewLifecycleOwner(), new c(new k(this)));
        W90().isLoading().observe(getViewLifecycleOwner(), new c(new l(this)));
        W90().getLoadMoreState().observe(getViewLifecycleOwner(), new c(new m(this)));
        W90().getHasMore().observe(getViewLifecycleOwner(), new c(new n(this)));
        W90().isDownloading().observe(getViewLifecycleOwner(), new c(new o(this)));
        W90().getErrorMessage().observe(getViewLifecycleOwner(), new c(new p(this)));
        DriveSdkService.a.k(new d());
        this.e = true;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        FLogger.a.i(V90(), "[onDestroyView] Cleaning up");
        this.k = false;
        LarusDriveFileListBinding r1 = this.d;
        if (r1 == null) goto L7;
        RecyclerView r2 = r1.e;
        if (r2 == null) goto L7;
        r2.setAdapter(null);
    L7:
        this.s.clear();
        this.t.clear();
        this.r = false;
        this.p = null;
        this.d = null;
        this.g = null;
    }

    public final void onDetach() {
        super.onDetach();
        this.o = null;
    }

    public final void onStart() {
        super.onStart();
        this.j = true;
        Boolean r0 = this.l;
        if (r0 == null) goto L9;
        boolean r1 = r0.booleanValue();
        if (this.e == false) goto L10;
        this.l = null;
        ba0(r1);
        return;
    L10:
        return;
    }

    public final void onStop() {
        super.onStop();
        this.j = false;
    }

    public final void X90(DriveSelectActionType r4) {
        Intrinsics.checkNotNullParameter(r4, "actionType");
        List<DriveFileItem> r0 = CollectionsKt.toList(this.t.values());
        if (r0.isEmpty() == false) goto L6;
        return;
    L6:
        switch(b.b[r4.ordinal()]) {
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            default: goto L8;
        };
    L9:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L15;
        o79.g r2 = U90();
        if (r2 == null) goto L15;
        r2.j();
    L15:
        W90().handleSelectPanelAction(r4, this, r0);
        return;
    L10:
        r1 = false;
        goto L11
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void ba0(boolean r5) {
        if (this.e == true) goto L6;
        this.l = Boolean.valueOf(r5);
        return;
    L6:
        this.l = null;
        if (this.k == true) goto L13;
        this.k = true;
        IOfficeSdkServiceV2 r6 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r6 == null) goto L11;
        IOfficeSdkServiceV2.a.b(r6, false, "drive_list", 5);
    L11:
        AbsDriveListViewModel.loadFiles$default(W90(), null, false, 3, null);
        return;
    L13:
        da0(this, r5, 1);
    }

    public final void ha0(boolean r5) {
        LarusDriveFileListBinding r0 = this.d;
        if (r0 == null) goto L21;
        RecyclerView r1 = r0.e;
        if (r1 == null) goto L22;
        Integer r2 = this.p;
        if (r2 == null) goto L10;
        int r3 = r2.intValue();
    L11:
        if (r5 == true) goto L13;
    L19:
        r1.setPaddingRelative(r1.getPaddingStart(), r1.getPaddingTop(), r1.getPaddingEnd(), r3);
        return;
    L13:
        if ((W90() instanceof DriveFolderListViewModel) == false) goto L15;
    L18:
        r3 = ((Number) i5.L0.getValue()).intValue();
        goto L19
    L15:
        if (HomeService.a.o() == true) goto L18;
        r3 = i5.l0();
        goto L19
    L10:
        r3 = r1.getPaddingBottom();
        this.p = Integer.valueOf(r3);
        goto L11
    L22:
        return;
    }

    public final void onAttach(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.onAttach(r3);
        Fragment r4 = getParentFragment();
    L3:
        WeakReference<DriveMainFragment> r0 = null;
        if (r4 == null) goto L9;
        if ((r4 instanceof DriveMainFragment) == true) goto L7;
        r4 = r4.getParentFragment();
        goto L3
    L7:
        DriveMainFragment r5 = (DriveMainFragment) r4;
    L10:
        if (r5 == null) goto L12;
        r0 = new WeakReference(r5);
    L12:
        this.o = r0;
        return;
    L9:
        r5 = null;
        goto L10
    }

    public void Z90(DriveFileItem r13, View r14) {
        Intrinsics.checkNotNullParameter(r13, "file");
        if (this.r == false) goto L16;
        String r15 = r13.b;
        if (StringsKt.isBlank(r15) == false) goto L8;
        return;
    L8:
        if (this.s.contains(r15) == false) goto L10;
        this.s.remove(r15);
        this.t.remove(r15);
    L11:
        DriveFileListAdapter r16 = this.g;
        if (r16 == null) goto L14;
        r16.C0(new HashSet(this.s));
    L14:
        Y90();
        return;
    L10:
        this.s.add(r15);
        this.t.put(r15, r13);
        goto L11
    L16:
        FLogger.a.i(V90(), "File clicked: " + r13.a + " (token: " + r13.b + ')');
        String r2 = null;
        if (r13.j != DriveFileType.FOLDER) goto L28;
        int r17 = DriveFolderActivity.g;
        Context r18 = getContext();
        String r0 = r13.b;
        String r1 = r13.c;
        String r110 = r13.a;
        JSONObject r3 = new JSONObject();
        DriveMainFragment r4 = S90();
        if (r4 == null) goto L23;
        Bundle r5 = r4.getArguments();
        if (r5 == null) goto L23;
        String r6 = r5.getString(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE);
    L24:
        r3.put(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, r6);
        if (S90() == null) goto L27;
        r2 = "ai_space_list";
    L27:
        r3.put("current_page", r2);
        Unit r7 = Unit.INSTANCE;
        DriveFolderActivity.a.a(r18, r0, r1, r110, r3);
        return;
    L23:
        r6 = null;
        goto L24
    L28:
        Context r8 = getContext();
        if (r8 != null) goto L31;
        return;
    L31:
        if ((this instanceof DriveRecentListFragment) == false) goto L35;
        PreviewFromPage r9 = PreviewFromPage.RECENT;
    L33:
        PreviewFromPage r10 = r9;
        DriveSdkService r11 = DriveSdkService.a;
        LifecycleCoroutineScope r12 = LifecycleOwnerKt.getLifecycleScope(this);
        DriveFileListAdapter r20 = this.g;
        boolean r21 = true;
        if (r20 == null) goto L52;
        List r22 = r20.getCurrentList();
        if (r22 == null) goto L52;
        ArrayList r23 = new ArrayList();
        Iterator r24 = r22.iterator();
    L47:
        if (r24.hasNext() == false) goto L51;
        Object r25 = r24.next();
        if ((!((List) this.v.getValue()).contains(((DriveFileItem) r25).d(true).toLowerCase(Locale.ROOT))) == false) goto L47;
        r23.add(r25);
        goto L47
    L51:
        ArrayList r26 = r23;
    L53:
        AbsDriveListViewModel r111 = W90();
        if (r14 == null) goto L56;
        View r27 = r14.findViewById(2131377281);
    L57:
        if (r27 != null) goto L59;
    L61:
        r21 = false;
    L62:
        if (r21 == false) goto L64;
        View r112 = r27;
    L68:
        r11.m(new z79.b(r8, r13, r12, r26, r10, r111, r112), null);
        return;
    L64:
        if (r14 == null) goto L66;
        View r113 = r14.findViewById(2131377278);
    L67:
        r112 = r113;
        goto L68
    L66:
        r113 = null;
        goto L67
    L59:
        if (r27.getVisibility() != 0) goto L61;
    L56:
        r27 = null;
    L52:
        r26 = null;
        goto L53
    L35:
        if ((this instanceof DriveMineListFragment) == false) goto L37;
    L40:
        r9 = PreviewFromPage.MINE;
        goto L33
    L37:
        if ((this instanceof DriveFolderListFragment) == true) goto L40;
        r9 = PreviewFromPage.UNKNOWN;
        goto L33
    }

    public boolean aa0(final DriveFileItem r27, View r28) {
        Intrinsics.checkNotNullParameter(r27, "file");
        Intrinsics.checkNotNullParameter(r28, "view");
        if (this.r == false) goto L5;
        return true;
    L5:
        FLogger.a.i(V90(), "File long clicked: " + r27.a + " (token: " + r27.b + ')');
        View r1 = r28.findViewById(2131377279);
        if (r1 != null) goto L8;
        final View r9 = r28;
    L9:
        r9.setPressed(false);
        r9.invalidate();
        final Drawable r0 = r9.getBackground();
        r9.setBackgroundResource(2131239034);
        r9.draw(new Canvas(Bitmap.createBitmap(r9.getWidth(), r9.getHeight(), Bitmap.Config.ARGB_8888)));
        r9.post(new f(r9, r0));
        final x0 r11 = new x0();
        r11.d(this);
        r11.i(new g());
        final View r2 = r9;
        Function0 r12 = new h(r2, this, r27, this, r11);
        Intrinsics.checkNotNullParameter(r9, "anchor");
        Intrinsics.checkNotNullParameter(r12, "menuViewHolder");
        Bitmap r3 = Bitmap.createBitmap(r9.getWidth(), r9.getHeight(), Bitmap.Config.ARGB_8888);
        r9.draw(new Canvas(r3));
        r11.j(r9, false, r3, r12);
        String r4 = r27.b;
        String r5 = r27.a;
        String r6 = com.larus.drive.biz.impl.utils.e.a;
        u0.e("long_press", null, null, null, null, null, r4, r5, com.larus.drive.biz.impl.utils.e.c(r27.j), com.larus.drive.biz.impl.utils.e.b(r27), null, S90(), 1086);
        return true;
    L8:
        r9 = r1;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.drive.biz.impl.view.b] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.drive.biz.impl.view.c] */
    public void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        FLogger.a.i(V90(), "[onViewCreated] Initialize");
        ga0();
        DriveFileListAdapter r12 = new DriveFileListAdapter(W90(), new com.larus.drive.biz.impl.view.b(this), new com.larus.drive.biz.impl.view.c(this), ca0(), W90() instanceof DriveRecentListViewModel, getViewLifecycleOwner(), this.w);
        String r13 = this.u;
        SimpleItemAnimator r0 = null;
        if (r13 == null) goto L5;
        r12.k = r13;
        this.u = null;
    L5:
        this.g = r12;
        LarusDriveFileListBinding r14 = this.d;
        if (r14 == null) goto L15;
        RecyclerView r15 = r14.e;
        if (r15 == null) goto L15;
        r15.setLayoutManager(new LinearLayoutManager(r15.getContext()));
        r15.setAdapter(this.g);
        RecyclerView.ItemAnimator r1 = r15.getItemAnimator();
        if ((r1 instanceof SimpleItemAnimator) == false) goto L12;
        r0 = (SimpleItemAnimator) r1;
    L12:
        if (r0 == null) goto L14;
        r0.setSupportsChangeAnimations(false);
    L14:
        this.p = Integer.valueOf(r15.getPaddingBottom());
        r15.addOnScrollListener(new AbsDriveListFragment$setupRecyclerView$4$1(this));
    L15:
        LarusDriveFileListBinding r16 = this.d;
        if (r16 == null) goto L20;
        SwipeRefreshLayout r17 = r16.d;
        if (r17 == null) goto L20;
        r17.setColorSchemeColors(new int[]{ContextCompat.getColor(r17.getContext(), v19.c.b(2130972123, r17.getContext(), 2131103203))});
        r17.setOnRefreshListener(new r(this));
    L20:
        fa0();
    }

    public static void da0(AbsDriveListFragment r0, boolean r1, int r2) {
        if ((r2 & 2) == 0) goto L6;
        r1 = false;
    L6:
        if (r0.e == false) goto L10;
        r0.W90().refreshFiles(null, r1);
        return;
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        ConstraintLayout r16 = r13.inflate(2131562322, r14, false);
        int r17 = 2131377277;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r16, 2131377277);
        if (r2 == null) goto L25;
        r17 = 2131377295;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r16, 2131377295);
        if (r3 == null) goto L25;
        r17 = 2131377302;
        SwipeRefreshLayout r4 = ViewBindings.findChildViewById(r16, 2131377302);
        if (r4 == null) goto L25;
        r17 = 2131377303;
        RecyclerView r5 = ViewBindings.findChildViewById(r16, 2131377303);
        if (r5 == null) goto L25;
        r17 = 2131377310;
        CardView r6 = ViewBindings.findChildViewById(r16, 2131377310);
        if (r6 == null) goto L25;
        r17 = 2131377311;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r16, 2131377311);
        if (r7 == null) goto L25;
        r17 = 2131377312;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r16, 2131377312);
        if (r8 == null) goto L25;
        r17 = 2131377313;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r16, 2131377313);
        if (r9 == null) goto L25;
        r17 = 2131377314;
        ProgressBar r10 = (ProgressBar) ViewBindings.findChildViewById(r16, 2131377314);
        if (r10 == null) goto L25;
        r17 = 2131377315;
        ImageView r11 = (ImageView) ViewBindings.findChildViewById(r16, 2131377315);
        if (r11 == null) goto L25;
        ConstraintLayout r18 = r16;
        this.d = new LarusDriveFileListBinding(r18, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        return r18;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r17)));
    }
}
