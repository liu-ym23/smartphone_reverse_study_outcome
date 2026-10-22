package com.larus.drive.sdk.impl.plugins.actionbar;

import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.larus.office.f;
import com.larus.office.g;
import com.larus.office.h;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\u0015\u0018\b\u0000\u0018\u0000 K2\u00020\u0001:\u0002JKB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\rH\u0016J\u001c\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001c\u0010!\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010\"\u001a\u00020\u0007H\u0002J\u001a\u0010#\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010$\u001a\u00020\u000fH\u0002J\u001a\u0010%\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010$\u001a\u00020\u000fH\u0002J\u0012\u0010&\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\rH\u0002J%\u0010(\u001a\u00020\u001b\"\u0004\b\u0000\u0010)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u0001H)H\u0002¢\u0006\u0002\u0010-J.\u0010.\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u000f2\b\u0010/\u001a\u0004\u0018\u00010\u000f2\b\u00100\u001a\u0004\u0018\u00010\u000fH\u0002J\u001a\u00101\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u000fH\u0002JB\u00102\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u000f2\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0002J\u0010\u00108\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u000fH\u0002J\u0010\u00109\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u000fH\u0002J\u0018\u0010:\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u000fH\u0002J\u0018\u0010<\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u000fH\u0002J\u0010\u0010=\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u0013H\u0002J\u0018\u0010>\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u000fH\u0002J\u0018\u0010?\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u000fH\u0002J\u0010\u0010@\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u0013H\u0002J\u0010\u0010A\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u0013H\u0002J\u0012\u0010B\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010C\u001a\u00020\u001bH\u0002J\u0010\u0010D\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020\u0007H\u0002J\b\u0010F\u001a\u00020\u001bH\u0002J\u0010\u0010G\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020IH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006L"}, d2 = {"Lcom/larus/drive/sdk/impl/plugins/actionbar/DriveActionBarAdaptationPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "fileTypeDecision", "Lcom/larus/drive/sdk/impl/plugins/actionbar/DriveActionBarAdaptationPlugin$FileTypeDecision;", "fileTypeResolved", "", "adaptationEnabled", "resolvedActionBarWidth", "", "shouldShowLeftIcon", "registeredFileLoaderHost", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "currentHostKey", "", "hostLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "currentTitleBar", "Lcom/bytedance/ee/bear/browser/plugin/TitleBar;", "fileLoadListener", "com/larus/drive/sdk/impl/plugins/actionbar/DriveActionBarAdaptationPlugin$fileLoadListener$1", "Lcom/larus/drive/sdk/impl/plugins/actionbar/DriveActionBarAdaptationPlugin$fileLoadListener$1;", "hostLifecycleObserver", "com/larus/drive/sdk/impl/plugins/actionbar/DriveActionBarAdaptationPlugin$hostLifecycleObserver$1", "Lcom/larus/drive/sdk/impl/plugins/actionbar/DriveActionBarAdaptationPlugin$hostLifecycleObserver$1;", "onAttachToHost", "", "host", "onDetachFromHost", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "shouldAdaptActionBar", "refreshActionBarWidth", "stage", "refreshLeftIconVisibility", "ensureFileTypeResolutionStarted", "resolveFromEntry", "handleFileLoaderInfo", "T", "code", "Lcom/bytedance/ee/bear/drive/loader/model/InfoCode;", "data", "(Lcom/bytedance/ee/bear/drive/loader/model/InfoCode;Ljava/lang/Object;)V", "resolveByTypeInfo", "ext", "mimeType", "resolveAsOthers", "resolveDecision", "decision", "hasExt", "hasMime", "isImage", "isVideo", "syncActionBarAndTitleBar", "applyTitleBarState", "hideTitleBarForUnresolved", "titleBar", "showTitleBarForMedia", "applyMediaBackIcon", "showTitleBarForOthers", "applyActionBarAdaptation", "hideMoreMenu", "applyReservedEndPadding", "bindHostLifecycle", "unbindHostLifecycle", "syncHostActive", "active", "removeFileLoadListener", "buildFragmentKey", "fragment", "Landroidx/fragment/app/Fragment;", "FileTypeDecision", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveActionBarAdaptationPlugin extends AbsDrivePlugin {
    public static final a Companion = null;
    private static final String TAG = "DriveActionBarAdaptationPlugin";
    private boolean adaptationEnabled;
    private String currentHostKey;
    private TitleBar currentTitleBar;
    private final c fileLoadListener;
    private FileTypeDecision fileTypeDecision;
    private boolean fileTypeResolved;
    private final DriveActionBarAdaptationPlugin$hostLifecycleObserver$1 hostLifecycleObserver;
    private LifecycleOwner hostLifecycleOwner;
    private DrivePluginHost registeredFileLoaderHost;
    private int resolvedActionBarWidth;
    private boolean shouldShowLeftIcon;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/drive/sdk/impl/plugins/actionbar/DriveActionBarAdaptationPlugin$FileTypeDecision;", "", "<init>", "(Ljava/lang/String;I)V", "UNRESOLVED", "MEDIA", "OTHERS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FileTypeDecision extends Enum<FileTypeDecision> {
        public static final FileTypeDecision MEDIA = null;
        public static final FileTypeDecision OTHERS = null;
        public static final FileTypeDecision UNRESOLVED = null;
        public static final /* synthetic */ FileTypeDecision[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<FileTypeDecision> getEntries() {
            return b;
        }

        static {
            FileTypeDecision r0 = new FileTypeDecision("UNRESOLVED", 0);
            UNRESOLVED = r0;
            FileTypeDecision r1 = new FileTypeDecision("MEDIA", 1);
            MEDIA = r1;
            FileTypeDecision r3 = new FileTypeDecision("OTHERS", 2);
            OTHERS = r3;
            FileTypeDecision[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static FileTypeDecision[] values() {
            return (FileTypeDecision[]) a.clone();
        }

        public static FileTypeDecision valueOf(String r1) {
            return (FileTypeDecision) r27.a.a(FileTypeDecision.class, r1);
        }

        public FileTypeDecision(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FileTypeDecision.values().length];
            r0[FileTypeDecision.UNRESOLVED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[FileTypeDecision.MEDIA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[FileTypeDecision.OTHERS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c extends u75.b.b {
        public final /* synthetic */ DriveActionBarAdaptationPlugin a;

        public c(DriveActionBarAdaptationPlugin r1) {
            this.a = r1;
        }

        public final void c(ErrCode r3) {
            Intrinsics.checkNotNullParameter(r3, "code");
            DriveActionBarAdaptationPlugin.access$resolveAsOthers(this.a, "load_failed", r3.name());
        }

        public final <T> void a(InfoCode r2, T r3) {
            Intrinsics.checkNotNullParameter(r2, "code");
            DriveActionBarAdaptationPlugin.access$handleFileLoaderInfo(this.a, r2, r3);
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void removeFileLoadListener() {
        DrivePluginHost r0 = this.registeredFileLoaderHost;
        if (r0 == null) goto L7;
        u75.b r1 = r0.c();
        if (r1 == null) goto L7;
        r1.g(this.fileLoadListener);
    L7:
        this.registeredFileLoaderHost = null;
    }

    private final boolean shouldAdaptActionBar() {
        if (this.resolvedActionBarWidth <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final void unbindHostLifecycle() {
        LifecycleOwner r0 = this.hostLifecycleOwner;
        if (r0 == null) goto L7;
        Lifecycle r1 = r0.getLifecycle();
        if (r1 == null) goto L7;
        r1.removeObserver(this.hostLifecycleObserver);
    L7:
        String r2 = this.currentHostKey;
        if (r2 == null) goto L10;
        g r3 = f.a;
        Intrinsics.checkNotNullParameter(r2, "hostKey");
        f.b.remove(r2);
        f.a();
    L10:
        this.hostLifecycleOwner = null;
        this.currentHostKey = null;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.drive.sdk.impl.plugins.actionbar.DriveActionBarAdaptationPlugin$hostLifecycleObserver$1] */
    public DriveActionBarAdaptationPlugin() {
        this.fileTypeDecision = FileTypeDecision.UNRESOLVED;
        this.fileLoadListener = new c(this);
        this.hostLifecycleObserver = new DriveActionBarAdaptationPlugin$hostLifecycleObserver$1(this);
    }

    private final void applyMediaBackIcon(TitleBar r3) {
        r3.getTitleBarLayout().setLeftImageResource(2131243132);
        FLogger.a.i(TAG, "applyMediaBackIcon: applied");
    }

    private final void applyReservedEndPadding(TitleBar r7) {
        int r0 = this.resolvedActionBarWidth;
        if (r0 > 0) goto L6;
        FLogger.a.i(TAG, "applyReservedEndPadding: width missing, skip padding");
        return;
    L6:
        BaseTitleBar r8 = r7.getTitleBarLayout();
        if (r8 != null) goto L9;
        return;
    L9:
        LinearLayout r2 = r8.getRightLayout();
        if (r2 != null) goto L12;
        return;
    L12:
        r2.setPadding(r2.getPaddingLeft(), r2.getPaddingTop(), r0, r2.getPaddingBottom());
        r8.b();
        FLogger.a.i(TAG, "applyReservedEndPadding: hasReservedEnd=true");
    }

    private final void applyTitleBarState(String r4) {
        TitleBar r0 = this.currentTitleBar;
        if (r0 != null) goto L5;
        return;
    L5:
        FileTypeDecision r1 = this.fileTypeDecision;
        int r2 = b.a[r1.ordinal()];
        if (r2 != 1) goto L8;
        hideTitleBarForUnresolved(r0, r4);
        return;
    L8:
        if (r2 != 2) goto L10;
        showTitleBarForMedia(r0, r4);
        return;
    L10:
        if (r2 != 3) goto L13;
        showTitleBarForOthers(r0, r4);
        return;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    private final void bindHostLifecycle(DrivePluginHost r3) {
        if (r3 == null) goto L13;
        Fragment r4 = r3.a;
        if (r4 == null) goto L14;
        this.currentHostKey = buildFragmentKey(r4);
        LifecycleOwner r0 = this.hostLifecycleOwner;
        if (r0 == null) goto L11;
        Lifecycle r1 = r0.getLifecycle();
        if (r1 == null) goto L11;
        r1.removeObserver(this.hostLifecycleObserver);
    L11:
        this.hostLifecycleOwner = r4;
        r4.getLifecycle().addObserver(this.hostLifecycleObserver);
        return;
    L14:
        return;
    }

    private final String buildFragmentKey(Fragment r3) {
        return r3.getClass().getName() + '@' + System.identityHashCode(r3);
    }

    private final void ensureFileTypeResolutionStarted(DrivePluginHost r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (this.fileTypeResolved == false) goto L6;
        return;
    L6:
        if (this.registeredFileLoaderHost != null) goto L12;
        this.registeredFileLoaderHost = r4;
        r4.c().c(this.fileLoadListener);
        FLogger.a.i(TAG, "ensureFileTypeResolutionStarted: register listener");
        resolveFromEntry(r4);
        return;
    }

    private final void hideMoreMenu(TitleBar r5) {
        r5.setHiddenMenus(CollectionsKt.listOf(new MenuItem("ccm_drive_more_menu", null)));
        TitleBar.MenuType r0 = TitleBar.MenuType.Right;
        List r1 = r5.i(r0);
        if (r1.isEmpty() == false) goto L6;
        FLogger.a.i(TAG, "hideMoreMenu: right menu empty");
        return;
    L6:
        r5.j(r1, r0);
        FLogger.a.i(TAG, "hideMoreMenu: reapplied right menus, count=" + r1.size());
    }

    private final void resolveFromEntry(DrivePluginHost r6) {
        BaseOpenEntity r7 = r6.c.getOpenEntity();
        if (r7 == null) goto L5;
        String r1 = r7.getFileExt();
    L6:
        if (r7 == null) goto L8;
        String r8 = r7.getMimeType();
    L9:
        boolean r2 = false;
        if (r1 != null) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == false) goto L24;
        if (r8 != null) goto L19;
    L20:
        r2 = true;
    L21:
        if (r2 == false) goto L24;
        FLogger.a.i(TAG, "resolveFromEntry: wait fileInfo, hasExt=false, hasMime=false");
        syncActionBarAndTitleBar("entry_unresolved");
        return;
    L19:
        if (r8.length() != 0) goto L21;
    L24:
        resolveByTypeInfo("entry", null, r1, r8);
        return;
    L12:
        if (r1.length() == 0) goto L15;
        r4 = false;
        goto L16
    L8:
        r8 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    private final void syncActionBarAndTitleBar(String r3) {
        if (this.adaptationEnabled == true) goto L5;
    L11:
        applyTitleBarState(r3);
        return;
    L5:
        if (this.fileTypeDecision != FileTypeDecision.OTHERS) goto L7;
        boolean r0 = true;
    L8:
        String r1 = this.currentHostKey;
        if (r1 == null) goto L11;
        f.c(r1, r0);
        goto L11
    L7:
        r0 = false;
        goto L8
    }

    private final void syncHostActive(boolean r2) {
        String r0 = this.currentHostKey;
        if (r0 != null) goto L5;
        return;
    L5:
        f.b(r0, r2);
    }

    public void onAttachToHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        refreshActionBarWidth(r3, "attach_host");
        refreshLeftIconVisibility(r3, "attach_host");
        this.adaptationEnabled = shouldAdaptActionBar();
        ensureFileTypeResolutionStarted(r3);
        if (this.adaptationEnabled == true) goto L6;
        FLogger.a.i(TAG, "onAttachToHost: actionBar width missing, skip host adaptation");
        return;
    }

    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        removeFileLoadListener();
        this.adaptationEnabled = false;
        this.resolvedActionBarWidth = 0;
        this.shouldShowLeftIcon = false;
        super.onDetachFromHost(r2);
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$syncHostActive(DriveActionBarAdaptationPlugin r0, boolean r1) {
        r0.syncHostActive(r1);
    }

    private final void applyActionBarAdaptation(TitleBar r3, String r4) {
        r3.setLeftIconVisibility(this.shouldShowLeftIcon);
        hideMoreMenu(r3);
        applyReservedEndPadding(r3);
        r3.show(false);
        FLogger.a.i(TAG, "applyActionBarAdaptation: stage=" + r4);
    }

    private final <T> void handleFileLoaderInfo(InfoCode r4, T r5) {
        if (this.fileTypeResolved == false) goto L6;
        return;
    L6:
        if (r4 != InfoCode.HitCache) goto L8;
    L10:
        String r1 = null;
        if ((r5 instanceof f85.a) == false) goto L13;
        f85.a r6 = (f85.a) r5;
    L14:
        if (r6 != null) goto L17;
        FLogger.a.i(TAG, "handleFileLoaderInfo: fileModel missing, code=" + r4);
        return;
    L17:
        String r7 = r4.name();
        f85.a.a r0 = ((w75.a) r6).a;
        if (r0 == null) goto L20;
        String r2 = ((w75.b) r0).k;
    L21:
        String r3 = ((w75.a) r6).r;
        if (r3 != null) goto L26;
        f85.a.a r8 = ((w75.a) r6).a;
        if (r8 == null) goto L27;
        r1 = ((w75.b) r8).f;
    L27:
        resolveByTypeInfo("file_info", r7, r2, r1);
        return;
    L26:
        r1 = r3;
        goto L27
    L20:
        r2 = null;
        goto L21
    L13:
        r6 = null;
        goto L14
    L8:
        if (r4 == InfoCode.FileInfoSuccess) goto L10;
    }

    private final void hideTitleBarForUnresolved(TitleBar r3, String r4) {
        r3.hide(false);
        FLogger.a.i(TAG, "hideTitleBarForUnresolved: stage=" + r4);
    }

    private final void refreshActionBarWidth(DrivePluginHost r9, String r10) {
        boolean r1 = true;
        if (r9 != null) goto L38;
        FLogger r11 = FLogger.a;
        StringBuilder r4 = new StringBuilder("refreshActionBarWidth: stage=");
        r4.append(r10);
        r4.append(", hasHost=false, hasWidth=");
        if (this.resolvedActionBarWidth > 0) goto L8;
        r1 = false;
    L8:
        r4.append(r1);
        r11.i(TAG, r4.toString());
        return;
    L38:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L24
        h r12 = r9.getHostAbilityOrNull(h.class);     // Catch: Throwable -> L24
        if (r12 == null) goto L21;
        Integer r13 = Integer.valueOf(r12.Y6());     // Catch: Throwable -> L24
        if (r13.intValue() <= 0) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == true) goto L19;
        r13 = null;
    L19:
        if (r13 == null) goto L21;
        int r14 = r13.intValue();     // Catch: Throwable -> L24
    L22:
        Object r15 = Result.constructor-impl(Integer.valueOf(r14));     // Catch: Throwable -> L24
    L26:
        Throwable r7 = Result.exceptionOrNull-impl(r15);
        if (r7 == null) goto L30;
        FLogger.a.e(TAG, "refreshActionBarWidth: get host width failed, stage=" + r10, r7);
    L30:
        if (Result.isFailure-impl(r15) == false) goto L32;
        r15 = 0;
    L32:
        this.resolvedActionBarWidth = ((Number) r15).intValue();
        FLogger r16 = FLogger.a;
        StringBuilder r8 = new StringBuilder("refreshActionBarWidth: stage=");
        r8.append(r10);
        r8.append(", hasHost=true, hasWidth=");
        if (this.resolvedActionBarWidth > 0) goto L36;
        r1 = false;
    L36:
        r8.append(r1);
        r16.i(TAG, r8.toString());
        return;
    L15:
        r6 = false;
    L21:
        r14 = 0;
    L24:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }

    private final void refreshLeftIconVisibility(DrivePluginHost r6, String r7) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
        if (r6 == null) goto L5;
        h r8 = (h) r6.getHostAbilityOrNull(h.class);     // Catch: Throwable -> L13
    L6:
        boolean r1 = false;
        if (r8 != null) goto L9;
    L11:
        Object r9 = Result.constructor-impl(Boolean.valueOf(r1));     // Catch: Throwable -> L13
    L15:
        Throwable r2 = Result.exceptionOrNull-impl(r9);
        if (r2 == null) goto L18;
        FLogger.a.e(TAG, "refreshLeftIconVisibility: get host visibility failed, stage=" + r7, r2);
    L18:
        Boolean r3 = Boolean.FALSE;
        if (Result.isFailure-impl(r9) == false) goto L21;
        r9 = r3;
    L21:
        this.shouldShowLeftIcon = ((Boolean) r9).booleanValue();
        FLogger.a.i(TAG, "refreshLeftIconVisibility: stage=" + r7 + ", visible=" + this.shouldShowLeftIcon);
        return;
    L9:
        if (r8.Ac() != true) goto L11;
        r1 = true;
        goto L11
    L5:
        r8 = null;
    L13:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    private final void resolveAsOthers(String r9, String r10) {
        resolveDecision(r9, r10, FileTypeDecision.OTHERS, false, false, false, false);
    }

    private final void showTitleBarForMedia(TitleBar r3, String r4) {
        applyMediaBackIcon(r3);
        r3.show(false);
        FLogger.a.i(TAG, "showTitleBarForMedia: stage=" + r4);
    }

    private final void showTitleBarForOthers(TitleBar r3, String r4) {
        if (this.adaptationEnabled == false) goto L6;
        applyActionBarAdaptation(r3, r4);
        return;
    L6:
        r3.show(false);
        FLogger.a.i(TAG, "showTitleBarForOthers: skip host adaptation, stage=" + r4);
    }

    public void onAttachToUIContainer(DrivePluginHost r3, t r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r3, r4);
        refreshActionBarWidth(r3, "attach_ui");
        refreshLeftIconVisibility(r3, "attach_ui");
        this.adaptationEnabled = shouldAdaptActionBar();
        if (r4 == null) goto L5;
        TitleBar r5 = r4.getTitleBar();
    L6:
        this.currentTitleBar = r5;
        ensureFileTypeResolutionStarted(r3);
        if (this.adaptationEnabled == false) goto L9;
        bindHostLifecycle(r3);
    L9:
        syncActionBarAndTitleBar("attach_ui");
        if (this.adaptationEnabled == true) goto L13;
        FLogger.a.i(TAG, "onAttachToUIContainer: actionBar width missing, skip host adaptation");
        return;
    L13:
        boolean r6 = false;
        if (r3 == null) goto L24;
        Fragment r7 = r3.a;
        if (r7 == null) goto L24;
        Lifecycle r8 = r7.getLifecycle();
        if (r8 == null) goto L24;
        Lifecycle.State r9 = r8.getCurrentState();
        if (r9 == null) goto L24;
        if (r9.isAtLeast(Lifecycle.State.RESUMED) != true) goto L24;
        r6 = true;
    L24:
        syncHostActive(r6);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public void onDetachFromUIContainer(DrivePluginHost r2, t r3) {
        this.currentTitleBar = null;
        unbindHostLifecycle();
        this.adaptationEnabled = false;
        this.shouldShowLeftIcon = false;
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r2, r3);
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DrivePluginHost) r1, r2);
    }

    public static final /* synthetic */ void access$handleFileLoaderInfo(DriveActionBarAdaptationPlugin r0, InfoCode r1, Object r2) {
        r0.handleFileLoaderInfo(r1, r2);
    }

    public static final /* synthetic */ void access$resolveAsOthers(DriveActionBarAdaptationPlugin r0, String r1, String r2) {
        r0.resolveAsOthers(r1, r2);
    }

    private final void resolveByTypeInfo(String r10, String r11, String r12, String r13) {
        if (this.fileTypeResolved == false) goto L5;
        return;
    L5:
        g85.b r0 = o75.b.a().getMimeTypeManager();
        boolean r7 = r0.j(r12, r13);
        boolean r8 = r0.o(r12, r13);
        if (r7 == true) goto L10;
        if (r8 == true) goto L10;
        FileTypeDecision r1 = FileTypeDecision.OTHERS;
    L11:
        FileTypeDecision r4 = r1;
        boolean r2 = false;
        if (r12 != null) goto L14;
    L17:
        boolean r14 = true;
    L18:
        boolean r5 = !r14;
        if (r13 != null) goto L21;
    L22:
        r2 = true;
    L23:
        resolveDecision(r10, r11, r4, r5, !r2, r7, r8);
        return;
    L21:
        if (r13.length() != 0) goto L23;
    L14:
        if (r12.length() == 0) goto L17;
        r14 = false;
    L10:
        r1 = FileTypeDecision.MEDIA;
        goto L11
    }

    private final void resolveDecision(String r4, String r5, FileTypeDecision r6, boolean r7, boolean r8, boolean r9, boolean r10) {
        if (this.fileTypeResolved == false) goto L5;
        return;
    L5:
        this.fileTypeResolved = true;
        this.fileTypeDecision = r6;
        removeFileLoadListener();
        FLogger.a.i(TAG, "resolveDecision: stage=" + r4 + ", code=" + r5 + ", decision=" + r6 + ", hasExt=" + r7 + ", hasMime=" + r8 + ", isImage=" + r9 + ", isVideo=" + r10);
        syncActionBarAndTitleBar(r4);
    }
}
