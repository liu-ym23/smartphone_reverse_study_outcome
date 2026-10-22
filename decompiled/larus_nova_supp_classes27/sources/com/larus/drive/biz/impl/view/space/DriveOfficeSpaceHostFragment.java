package com.larus.drive.biz.impl.view.space;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceUploadSelection;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.BaseHomeTabFragment;
import com.larus.bmhome.z;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.drive.biz.impl.databinding.LarusFragmentDriveOfficeSpaceHostBinding;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import tx9.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u0084\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0006\u0084\u0001\u0085\u0001\u0086\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J$\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001a\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020/2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u00106\u001a\u00020+H\u0016J\b\u00107\u001a\u00020+H\u0016J\b\u00108\u001a\u00020\u000bH\u0016J\b\u00109\u001a\u00020+H\u0016J\b\u0010:\u001a\u00020\tH\u0016J\u0010\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020?H\u0016J\u0012\u0010@\u001a\u00020+2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010A\u001a\u00020+2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010B\u001a\u00020+H\u0016J \u0010C\u001a\u00020+2\u0006\u0010D\u001a\u00020\u000b2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010FH\u0016J\u0012\u0010G\u001a\u00020+2\b\u0010H\u001a\u0004\u0018\u00010-H\u0016J\b\u0010I\u001a\u0004\u0018\u00010\tJ\b\u0010J\u001a\u00020+H\u0002J\b\u0010K\u001a\u00020\u000bH\u0002J\b\u0010L\u001a\u00020+H\u0002J\b\u0010M\u001a\u00020+H\u0002J\u0010\u0010N\u001a\u00020+2\u0006\u0010O\u001a\u00020\u000bH\u0002J\u0010\u0010P\u001a\u00020+2\u0006\u0010Q\u001a\u00020\u001aH\u0002J\b\u0010R\u001a\u00020\u0013H\u0002J\u0018\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010E\u001a\u00020\u0018H\u0002J\u0018\u0010W\u001a\u00020+2\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\u0016H\u0002J\b\u0010Z\u001a\u00020[H\u0002J\u001a\u0010\\\u001a\u00020+2\u0006\u0010]\u001a\u00020?2\b\u0010^\u001a\u0004\u0018\u00010(H\u0002J\u0018\u0010_\u001a\b\u0012\u0004\u0012\u00020a0`2\b\u0010^\u001a\u0004\u0018\u00010(H\u0002J\u0018\u0010b\u001a\b\u0012\u0004\u0012\u00020a0`2\b\u0010^\u001a\u0004\u0018\u00010(H\u0002J3\u0010c\u001a\u00020a2\u0006\u0010d\u001a\u00020e2\b\u0010f\u001a\u0004\u0018\u00010\t2\b\u0010g\u001a\u0004\u0018\u00010\t2\b\u0010h\u001a\u0004\u0018\u00010iH\u0002¢\u0006\u0002\u0010jJ\u0010\u0010k\u001a\u00020l2\u0006\u0010d\u001a\u00020eH\u0002J\u0010\u0010m\u001a\u00020+2\u0006\u0010d\u001a\u00020eH\u0002J\u001e\u0010n\u001a\u00020+2\u0006\u0010X\u001a\u00020\t2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020a0`H\u0002J\u0010\u0010p\u001a\u00020+2\u0006\u0010X\u001a\u00020\tH\u0002J\u0018\u0010q\u001a\u00020+2\u0006\u0010X\u001a\u00020\t2\u0006\u0010r\u001a\u00020\tH\u0002J\u0012\u0010s\u001a\u0004\u0018\u00010\u00182\u0006\u0010X\u001a\u00020\tH\u0002J\b\u0010t\u001a\u00020+H\u0002J\b\u0010u\u001a\u00020?H\u0002J\b\u0010v\u001a\u00020(H\u0002J\u0018\u0010w\u001a\u00020T2\u0006\u0010Y\u001a\u00020\u00162\u0006\u0010x\u001a\u00020yH\u0002J\u0012\u0010z\u001a\u00020+2\b\u0010{\u001a\u0004\u0018\u00010|H\u0002J\u0010\u0010}\u001a\u00020+2\u0006\u0010x\u001a\u00020yH\u0002J\b\u0010~\u001a\u00020+H\u0002J\b\u0010\u007f\u001a\u00020+H\u0002J\t\u0010\u0080\u0001\u001a\u00020+H\u0002J\u0012\u0010\u0081\u0001\u001a\u00020+2\u0007\u0010\u0082\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u0083\u0001\u001a\u00020\tH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u0010\u0012\f\u0012\n )*\u0004\u0018\u00010(0(0'X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0087\u0001"}, d2 = {"Lcom/larus/drive/biz/impl/view/space/DriveOfficeSpaceHostFragment;", "Lcom/larus/bmhome/BaseHomeTabFragment;", "Lcom/larus/common_ui/tab/TabChildFragment;", "Lcom/larus/bmhome/ISideBarChildFragment;", "<init>", "()V", "binding", "Lcom/larus/drive/biz/impl/databinding/LarusFragmentDriveOfficeSpaceHostBinding;", "previousPage", "", "isDriveTabActive", "", "pendingLoadAfterViewReady", "hasContentFragment", "loadJob", "Lkotlinx/coroutines/Job;", "officeSpaceLoadState", "Lcom/larus/drive/biz/impl/view/space/DriveOfficeSpaceHostFragment$OfficeSpaceLoadState;", "spaceEventListener", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEventListener;", "pendingUploadRequestId", "pendingUploadAction", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderAction;", "pendingUploadCallback", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelectionCallback;", "hostFragment", "Landroidx/fragment/app/Fragment;", "getHostFragment", "()Landroidx/fragment/app/Fragment;", "isSideBar", "()Z", "isSideBar$delegate", "Lkotlin/Lazy;", "driveEnterContext", "Lcom/larus/drive/biz/api/DriveEnterContext;", "getDriveEnterContext", "()Lcom/larus/drive/biz/api/DriveEnterContext;", "driveEnterContext$delegate", "officeSpacePickerLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "onDestroy", "autoLogEnterPage", "logEnterPage", "getCurrentPageName", "fillTrackParams", "params", "Lcom/ixigua/lib/track/TrackParams;", "tabIndex", "", "onEnterTab", "onFirstEnterTab", "onLeaveTab", "onTabClick", "doubleClick", "callback", "Lkotlin/Function0;", "onNewIntent", "bundle", "getPreviousPage", "requestLoadIfNeeded", "refreshCurrentOfficeTabWithoutScroll", "setupRetryAction", "restoreExistingChildIfNeeded", "loadOfficeSpaceFragment", "forceReload", "attachContentFragment", "fragment", "buildOfficeSpaceEventListener", "handleOpenUploadSelector", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceActionResult;", "request", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelectionRequest;", "openUploadSelectorAfterGuard", "requestId", "action", "buildOfficeSpaceAlbumConfig", "Lcom/larus/platform/model/album/AlbumSettingConfig;", "handleUploadPickerResult", "resultCode", "data", "parseAlbumSelections", "", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelection;", "parseFileSelections", "buildUploadSelection", "uri", "Landroid/net/Uri;", "displayName", "mimeType", "size", "", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelection;", "queryUploadMeta", "Lcom/larus/drive/biz/impl/view/space/DriveOfficeSpaceHostFragment$UploadMeta;", "persistReadPermission", "notifyUploadSelected", "selections", "notifyUploadCancel", "notifyUploadError", "message", "uploadCallbackFor", "clearPendingUpload", "getOfficeSpaceMaxSelectCount", "buildOfficeSpaceFileSelectIntent", "handleCreateOfficeDocument", "source", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderEventSource;", "reportAiDocCreateIfNeeded", "createdFile", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "notifyOfficeDocumentCreated", "showLoadingState", "showRetryState", "showContentState", "updateOfficeSpaceLoadState", "state", "getEnterFrom", "Companion", "UploadMeta", "OfficeSpaceLoadState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveOfficeSpaceHostFragment extends BaseHomeTabFragment implements s19.a, z {
    public static WeakReference<DriveOfficeSpaceHostFragment> w;
    public LarusFragmentDriveOfficeSpaceHostBinding j;
    public String k;
    public boolean l;
    public boolean m;
    public Job n;
    public OfficeSpaceLoadState o;
    public com.bytedance.ee.bear.office.export.space.h p;
    public String q;
    public OfficeSpaceHeaderAction r;
    public com.bytedance.ee.bear.office.export.space.n s;
    public final Lazy t;
    public final Lazy u;
    public final ActivityResultLauncher<Intent> v;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/drive/biz/impl/view/space/DriveOfficeSpaceHostFragment$OfficeSpaceLoadState;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "SUCCESS", "FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum OfficeSpaceLoadState extends Enum<OfficeSpaceLoadState> {
        public static final OfficeSpaceLoadState FAILED = null;
        public static final OfficeSpaceLoadState LOADING = null;
        public static final OfficeSpaceLoadState SUCCESS = null;
        public static final /* synthetic */ OfficeSpaceLoadState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<OfficeSpaceLoadState> getEntries() {
            return b;
        }

        static {
            OfficeSpaceLoadState r0 = new OfficeSpaceLoadState("LOADING", 0);
            LOADING = r0;
            OfficeSpaceLoadState r1 = new OfficeSpaceLoadState("SUCCESS", 1);
            SUCCESS = r1;
            OfficeSpaceLoadState r3 = new OfficeSpaceLoadState("FAILED", 2);
            FAILED = r3;
            OfficeSpaceLoadState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static OfficeSpaceLoadState[] values() {
            return (OfficeSpaceLoadState[]) a.clone();
        }

        public static OfficeSpaceLoadState valueOf(String r1) {
            return (OfficeSpaceLoadState) r27.a.a(OfficeSpaceLoadState.class, r1);
        }

        public OfficeSpaceLoadState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public final Long c;

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
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Long r7 = this.c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "UploadMeta(displayName=" + this.a + ", mimeType=" + this.b + ", size=" + this.c + ')';
        }

        public b(String r1, String r2, Long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeSpaceHeaderAction.values().length];
            r0[OfficeSpaceHeaderAction.UPLOAD_IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[OfficeSpaceHeaderAction.UPLOAD_FILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[OfficeSpaceHeaderAction.CREATE_DOC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[OfficeSpaceHeaderAction.CREATE_PPT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[OfficeSpaceHeaderAction.CREATE_BITABLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[OfficeSpaceHeaderAction.CREATE_SHEET.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    static {
    }

    public DriveOfficeSpaceHostFragment() {
        super(false);
        this.o = OfficeSpaceLoadState.LOADING;
        this.t = LazyKt.lazy(new k(this));
        this.u = LazyKt.lazy(new l(this));
        this.v = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new m(this));
    }

    public final boolean S90() {
        return false;
    }

    @Override // s19.a
    public final void a2(Bundle r1) {
    }

    public final String k() {
        return "ai_space_list";
    }

    public final void T90() {
        if (aa0() == false) goto L5;
        String r0 = "click_navigation_cell";
    L6:
        a1.c(null, null, null, null, null, null, null, null, r0, null, null, null, null, null, null, "ai_space_list", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, this, null, null, null, null, null, null, null, -525313, -16777217, 7);
        return;
    L5:
        r0 = "click_tab";
        goto L6
    }

    public final boolean aa0() {
        return ((Boolean) this.t.getValue()).booleanValue();
    }

    public final String b() {
        String r0 = this.k;
        if (r0 != null) goto L9;
        Bundle r1 = getArguments();
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getString(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE);
    L9:
        return r0;
    }

    public final void fa0() {
        boolean r1 = false;
        if (this.m == false) goto L18;
        com.bytedance.ee.bear.office.export.space.l r0 = getChildFragmentManager().findFragmentByTag("drive_office_space_child");
        String r4 = null;
        if ((r0 instanceof com.bytedance.ee.bear.office.export.space.l) == false) goto L7;
        com.bytedance.ee.bear.office.export.space.l r3 = r0;
    L8:
        if (r3 != null) goto L10;
    L12:
        FLogger r2 = FLogger.a;
        StringBuilder r5 = new StringBuilder("refreshCurrentOfficeTabWithoutScroll refreshed[");
        r5.append(r1);
        r5.append("] child[");
        if (r0 == null) goto L15;
        r4 = r0.getClass().getName();
    L15:
        r5.append(r4);
        r5.append(']');
        r2.i("DriveOfficeSpaceHost", r5.toString());
        return;
    L10:
        if (r3.Ei() != true) goto L12;
        r1 = true;
        goto L12
    L7:
        r3 = null;
        goto L8
    L18:
        if (getView() != null) goto L21;
        this.l = true;
        return;
    L21:
        ba0(false);
    }

    public final void onDestroyView() {
        String r0 = this.q;
        if (r0 == null) goto L5;
        ca0(r0);
    L5:
        Job r1 = this.n;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        this.n = null;
        this.j = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    @Override // s19.a
    public final int sb() {
        return BaseHomeTabFragment.MainTab.Drive.getIndex();
    }

    @Override // s19.a
    public final void t1() {
        FLogger.a.i("DriveOfficeSpaceHost", "onLeaveTab");
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        WeakReference<DriveOfficeSpaceHostFragment> r0 = w;
        if (r0 == null) goto L5;
        DriveOfficeSpaceHostFragment r1 = r0.get();
    L7:
        if (Intrinsics.areEqual(r1, this) == false) goto L10;
        w = null;
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void ba0(boolean r15) {
        boolean r1 = true;
        if (isAdded() == true) goto L7;
        this.l = true;
        return;
    L7:
        if (this.m == false) goto L10;
        if (r15 == true) goto L10;
        return;
    L10:
        Job r0 = this.n;
        if (r0 != null) goto L13;
    L15:
        r1 = false;
    L16:
        if (r1 == false) goto L18;
        return;
    L18:
        if (r15 == false) goto L20;
        long r2 = SystemClock.uptimeMillis();
    L21:
        long r6 = r2;
        this.l = false;
        ga0(OfficeSpaceLoadState.LOADING);
        this.n = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DriveOfficeSpaceHostFragment$loadOfficeSpaceFragment$1(this, r15, r6, null), 3, null);
        return;
    L20:
        r2 = 0;
        goto L21
    L13:
        if (r0.isActive() != true) goto L15;
        goto L15
    }

    public final void ca0(String r2) {
        com.bytedance.ee.bear.office.export.space.n r0 = ha0(r2);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.onCancel(r2);
        this.q = null;
        this.r = null;
        this.s = null;
    }

    public final b ea0(Uri r8) {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        Context r2 = getContext();
        Unit r3 = null;
        if (r2 == null) goto L55;
        ContentResolver r4 = r2.getContentResolver();
        if (r4 == null) goto L55;
        String r5 = r4.getType(r8);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L46
        Cursor r9 = Z90(r4, r8, new String[]{"_display_name", "_size"});     // Catch: Throwable -> L46
        if (r9 == null) goto L41;
        Cursor r10 = r9;     // Catch: Throwable -> L46
        Cursor r7 = r10;     // Catch: Throwable -> L32
        if (r7.moveToFirst() == false) goto L26;
        int r1 = r7.getColumnIndex("_display_name");     // Catch: Throwable -> L32
        int r0 = r7.getColumnIndex("_size");     // Catch: Throwable -> L32
        if (r1 < 0) goto L17;
        Unit r11 = r7.getString(r1);     // Catch: Throwable -> L32
    L18:
        if (r0 >= 0) goto L58;
    L25:
        Unit r12 = null;
    L56:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L30
        CloseableKt.closeFinally(r10, null);     // Catch: Throwable -> L44
        r3 = Unit.INSTANCE;     // Catch: Throwable -> L44
    L42:
        Object r14 = Result.constructor-impl(r3);     // Catch: Throwable -> L44
    L49:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L53;
        FLogger.a.e("DriveOfficeSpaceHost", "query upload uri meta failed", r15);
    L53:
        return new b(r11, r5, r12);
    L44:
        th = th;
    L40:
        r3 = r11;
    L48:
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        r11 = r3;
    L30:
        th = move-exception;
        r3 = r12;
        th = th;
    L62:
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L38:
        th = th;
        r12 = r3;
        goto L40
    L58:
    L23:
        th = th;
        goto L62
    L20:
        if (r7.getType(r0) == 0) goto L25;
        r12 = Long.valueOf(r7.getLong(r0));     // Catch: Throwable -> L23
        goto L56
    L17:
        r11 = null;
        goto L18
    L26:
        r12 = null;
        r11 = null;
    L32:
        th = th;
        r11 = null;
        goto L62
    L41:
        r12 = null;
        r11 = null;
    L46:
        th = th;
        r12 = null;
    L55:
        return new b(null, null, null);
    }

    public final void fillTrackParams(TrackParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        com.larus.trace.tracknode.a.a.a(this, r3);
        String r0 = b();
        if (r0 == null) goto L6;
        r3.put(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, r0);
        return;
    }

    public final void ga0(OfficeSpaceLoadState r7) {
        if (this.o == r7) goto L5;
    L7:
        this.o = r7;
        LarusFragmentDriveOfficeSpaceHostBinding r0 = this.j;
        if (r0 != null) goto L10;
        return;
    L10:
        OfficeSpaceLoadState r1 = OfficeSpaceLoadState.FAILED;
        int r2 = 0;
        if (r7 == r1) goto L13;
    L17:
        FrameLayout r3 = r0.b;
        if (r7 != OfficeSpaceLoadState.SUCCESS) goto L20;
    L19:
        int r4 = 0;
    L25:
        r3.setVisibility(r4);
        LinearLayout r5 = r0.c;
        if (r7 != OfficeSpaceLoadState.LOADING) goto L28;
        int r6 = 0;
    L29:
        r5.setVisibility(r6);
        LinearLayout r8 = r0.d;
        if (r7 == r1) goto L32;
    L34:
        r2 = 8;
    L35:
        r8.setVisibility(r2);
        return;
    L32:
        if (this.m == true) goto L34;
    L28:
        r6 = 8;
        goto L29
    L20:
        if (r7 == r1) goto L22;
    L24:
        r4 = 8;
        goto L25
    L22:
        if (this.m == false) goto L24;
    L13:
        if (getChildFragmentManager().findFragmentByTag("drive_office_space_child") == null) goto L15;
        boolean r9 = true;
    L16:
        this.m = r9;
        goto L17
    L15:
        r9 = false;
        goto L16
    L5:
        if (this.j != null) goto L7;
    }

    public final com.bytedance.ee.bear.office.export.space.n ha0(String r4) {
        if (Intrinsics.areEqual(this.q, r4) == true) goto L7;
        FLogger.a.i("DriveOfficeSpaceHost", "ignore stale upload callback, requestId=" + r4 + ", pending=" + this.q);
        return null;
    L7:
        return this.s;
    }

    public final void onCreate(Bundle r8) {
        int r0 = com.larus.office.base.utils.c.a;
        Intrinsics.checkNotNullParameter("DriveOfficeSpaceHost", "source");
        boolean r1 = false;
        if (r8 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r8 == null) goto L10;
        r8.remove("android:support:fragments");
    L10:
        FLogger r3 = FLogger.a;
        StringBuilder r5 = new StringBuilder("removeFragmentChildState: source=DriveOfficeSpaceHost, hasSavedInstanceState=");
        if (r8 == null) goto L13;
        r1 = true;
    L13:
        r5.append(r1);
        r5.append(", removed=");
        r5.append(r4);
        r3.i("OfficeFragmentUtil", r5.toString());
        if (r4 == false) goto L16;
        r3.i("DriveOfficeSpaceHost", "request reload because restored office space child state removed");
        this.l = true;
    L16:
        super/*com.larus.trace.tracknode.TraceFragment*/.onCreate(r8);
        w = new WeakReference(this);
        return;
    L5:
        if (r8.containsKey("android:support:fragments") != true) goto L7;
        r4 = true;
        goto L8
    }

    public final void pp(String r4) {
        FLogger.a.i("DriveOfficeSpaceHost", "onFirstEnterTab");
        this.k = r4;
        fa0();
    }

    @Override // s19.a
    public final void y2(String r4) {
        FLogger.a.i("DriveOfficeSpaceHost", "onEnterTab");
        if (r4 == null) goto L5;
        this.k = r4;
    L5:
        fa0();
    }

    @Override // s19.a
    public final void KC(boolean r4, Function0<Unit> r5) {
        FLogger.a.i("DriveOfficeSpaceHost", "onTabClick doubleClick[" + r4 + ']');
        if (this.m == true) goto L5;
        ba0(true);
    L5:
        if (r5 == null) goto L8;
        r5.invoke();
        return;
    }

    public final void da0(String r2, String r3) {
        com.bytedance.ee.bear.office.export.space.n r0 = ha0(r2);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.onError(r2, r3);
        this.q = null;
        this.r = null;
        this.s = null;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        LarusFragmentDriveOfficeSpaceHostBinding r10 = this.j;
        if (r10 == null) goto L7;
        LinearLayout r11 = r10.d;
        if (r11 == null) goto L7;
        r11.setOnClickListener(new h(this));
    L7:
        Fragment r12 = getChildFragmentManager().findFragmentByTag("drive_office_space_child");
        boolean r0 = true;
        if (r12 != null) goto L10;
    L12:
        if (r12 != null) goto L15;
        r0 = false;
    L15:
        this.m = r0;
        if (r12 == null) goto L18;
        ga0(OfficeSpaceLoadState.SUCCESS);
    L20:
        if (aa0() == false) goto L40;
        LarusFragmentDriveOfficeSpaceHostBinding r13 = this.j;
        if (r13 == null) goto L40;
        FrameLayout r14 = r13.a;
        if (r14 == null) goto L40;
        FragmentActivity r1 = getContext();
        FragmentActivity r2 = null;
        if ((r1 instanceof FragmentActivity) == false) goto L28;
        FragmentActivity r3 = r1;
    L29:
        if (r3 == null) goto L31;
        int r4 = u.c(r3);
    L32:
        Context r5 = getContext();
        if ((r5 instanceof FragmentActivity) == false) goto L35;
        r2 = (FragmentActivity) r5;
    L35:
        if (r2 == null) goto L37;
        int r6 = u.b(r2);
    L38:
        int r7 = r14.getPaddingStart();
        int r15 = r14.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r14.getClass().getSimpleName() + ",source:,start:" + r7 + ",top:" + r4 + ",end:" + r15 + ",bottom:" + r6);
        r14.setPaddingRelative(r7, r4, r15, r6);
        goto L40
    L37:
        r6 = 0;
        goto L38
    L31:
        r4 = 0;
        goto L32
    L28:
        r3 = null;
    L40:
        if (this.l == true) goto L42;
        return;
    L42:
        if (this.m == true) goto L46;
        ba0(false);
        return;
    L46:
        return;
    L18:
        ga0(OfficeSpaceLoadState.LOADING);
        goto L20
    L10:
        if (this.p != null) goto L12;
        FLogger.a.i("DriveOfficeSpaceHost", "remove restored office space child because listener missing");
        getChildFragmentManager().beginTransaction().remove(r12).commitNowAllowingStateLoss();
        this.m = false;
        this.l = true;
        ga0(OfficeSpaceLoadState.LOADING);
        goto L20
    }

    public static Cursor Z90(ContentResolver r12, Uri r13, String[] r14) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, r14, null, null, null};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r15 = r12.query(r13, r14, null, null, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r15, r10, true);
        return r15;
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r6 = r3.inflate(2131562385, r4, false);
        int r7 = 2131370287;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(r6, 2131370287);
        if (r8 == null) goto L11;
        r7 = 2131370288;
        LinearLayout r0 = (LinearLayout) ViewBindings.findChildViewById(r6, 2131370288);
        if (r0 == null) goto L11;
        r7 = 2131370289;
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r6, 2131370289);
        if (r1 == null) goto L11;
        FrameLayout r9 = (FrameLayout) r6;
        LarusFragmentDriveOfficeSpaceHostBinding r10 = new LarusFragmentDriveOfficeSpaceHostBinding(r9, r8, r0, r1);
        this.j = r10;
        Intrinsics.checkNotNull(r10);
        return r9;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }

    public final OfficeSpaceUploadSelection Y90(Uri r7, String r8, String r9, Long r10) {
        String r1 = r7.toString();
        String r0 = null;
        if (r8 != null) goto L5;
    L11:
        String r11 = r7.getLastPathSegment();
        if (r11 != null) goto L14;
    L16:
        if (r0 != null) goto L18;
        String r3 = "未命名文件";
    L20:
        return new OfficeSpaceUploadSelection(r1, true, r3, r9, r10);
    L18:
        r3 = r0;
        goto L20
    L14:
        if ((!StringsKt.isBlank(r11)) == false) goto L16;
        r0 = r11;
        goto L16
    L5:
        if ((!StringsKt.isBlank(r8)) == true) goto L8;
        r8 = null;
    L8:
        if (r8 == null) goto L11;
        r3 = r8;
        goto L20
    }
}
