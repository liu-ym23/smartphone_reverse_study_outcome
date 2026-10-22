package com.ss.android.lark.filedetail.impl;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.ui.loading.LKUIStatus;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.ApkUtil;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.eventbus.EventBus;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.biz.im.api.j0;
import com.ss.android.lark.chameleon.bridge.BridgeReport;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.entity.favorite.FavoriteMessageInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.filedetail.FileDetailModule;
import com.ss.android.lark.filedetail.dto.FileDetailLaunchParams;
import com.ss.android.lark.filedetail.dto.FileState;
import com.ss.android.lark.filedetail.dto.NetworkTypeListener;
import com.ss.android.lark.filedetail.impl.detail.FileDownloadState;
import com.ss.android.lark.filedetail.impl.detail.FileHitPointUtil;
import com.ss.android.lark.filedetail.impl.detail.FileTransmissionPresenter;
import com.ss.android.lark.filedetail.impl.detail.z;
import com.ss.android.lark.filedetail.impl.open.FileOpenMenu$2;
import com.ss.android.lark.filedetail.impl.open.FileOpenMenu$4;
import com.ss.android.lark.filedetail.impl.open.OpenFileInfo;
import com.ss.android.lark.filedetail.impl.open.OpenFileParams;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.integrator.mock.FileDetailModuleDependencyMock;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.a0;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class FileDetailFragment extends BaseFragment implements z {
    public static final /* synthetic */ int N = 0;
    public NetworkTypeListener A;
    public OpenFileParams B;
    public b C;
    public final hfb.b D;
    public final hfb.b.e E;
    public final hfb.b.d F;
    public Disposable G;
    public boolean H;
    public boolean I;
    public final com.ss.android.lark.filedetail.impl.c J;
    public LKUIStatus K;
    public final com.ss.android.lark.filedetail.impl.d L;
    public d M;
    public UDLoadingDrawable d;
    public int e;
    public FileTransmissionPresenter f;
    public Message g;
    public FavoriteMessageInfo h;
    public FileContent i;
    public String j;
    public boolean k;
    public String l;
    public int m;

    @BindView(9076)
    ImageView mCloseIv;

    @BindView(9242)
    ImageView mDecryptLoadingIV;

    @BindView(9243)
    TextView mDecryptTipsTV;

    @BindView(BridgeReport.CODE_NO_API_HANDLER)
    ViewGroup mRootView;

    @BindView(10238)
    TextView mTipsTv;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public String s;
    public String t;
    public boolean u;
    public boolean v;

    @BindView(9075)
    TextView vBtnFunction;

    @BindView(9467)
    ImageView vImageFileIcon;

    @BindView(9586)
    Group vLayoutProgress;

    @BindView(9936)
    ProgressBar vProgressBar;

    @BindView(10211)
    TextView vTextFileName;

    @BindView(10212)
    TextView vTextFileSize;

    @BindView(10213)
    TextView vTextFileSpeed;

    @BindView(10252)
    CommonTitleBar vTitleBar;
    public hfb.b.f w;
    public FileDownloadState x;
    public OpenFileInfo y;
    public FileDetailModule.NetworkType z;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FileDownloadState.values().length];
            a = r0;
            r0[FileDownloadState.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L34:
            a[FileDownloadState.PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L40:
            a[FileDownloadState.DOWNLOADING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L54:
            a[FileDownloadState.DONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L36:
            a[FileDownloadState.STOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L42:
            a[FileDownloadState.DOWNLOAD_FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L46:
            a[FileDownloadState.BURNED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L50:
            a[FileDownloadState.RECALL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L32:
            a[FileDownloadState.DECRYPT_START.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L38:
            a[FileDownloadState.DECRYPT_FAILED.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L44:
            a[FileDownloadState.DLP_BLOCKED.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L48:
            a[FileDownloadState.DOWNLOAD_NETWORK.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L30:
            a[FileDownloadState.UNKNOWN.ordinal()] = 13;     // Catch: NoSuchFieldError -> L29
            return;
        }
    }

    public class b implements j0 {
        public b() {
        }
    }

    public class c implements FileTransmissionPresenter.b {
        public final /* synthetic */ FileDetailFragment a;

        public c(FileDetailFragment r1) {
            this.a = r1;
        }
    }

    public interface d {
        void l();
    }

    static {
        com.ss.android.lark.storage.a r0 = FileDetailModule.a;
        FileDetailModule.a.a().getDownloadFileMonitorDependency().getClass();
        Log.w("FileDetailModuleDependencyMock", "getMaxAutoDownloadSize mocked");
    }

    @Override // com.ss.android.lark.filedetail.impl.detail.z
    public final void HF() {
        UIUtils.hide(this.vLayoutProgress);
        FileDownloadState r0 = this.x;
        if (r0 != FileDownloadState.PAUSE) goto L5;
        return;
    L5:
        if (r0 != FileDownloadState.STOP) goto L7;
        return;
    L7:
        if (r0 == FileDownloadState.DOWNLOAD_NETWORK) goto L12;
        V90(FileDownloadState.DOWNLOAD_FAILED);
        W90();
        return;
    }

    @Override // com.ss.android.lark.filedetail.impl.detail.z
    public final void Ie() {
        FileDownloadState r0 = this.x;
        if (r0 != FileDownloadState.PAUSE) goto L5;
        return;
    L5:
        if (r0 == FileDownloadState.STOP) goto L9;
        V90(FileDownloadState.DECRYPT_FAILED);
        return;
    }

    public final void W90() {
        Message r0 = this.g;
        if (r0 != null) goto L6;
        V90(FileDownloadState.DONE);
        ba0();
        return;
    L6:
        r0.getSourceId();
        this.g.getSourceType().getNumber();
        IGetDataCallback<FileState> r1 = new AnonymousClass10(this);
        UICallbackExecutor.executeDelayed(this.J, 300);
        if (this.H == false) goto L9;
        r1.onSuccess(FileState.NORMAL);
        return;
    L9:
        FileDetailModuleDependencyMock.b r2 = this.E;
        this.B.getDownloadFileScene();
        getCallbackManager().wrapAndAddGetDataCallback(r1);
        r2.getClass();
        Log.w("FileDetailModuleDependencyMock", "checkFileState mocked");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<com.ss.android.lark.widget.menu.b.a> X90() {
        final com.ss.android.lark.filedetail.impl.open.j r0 = new com.ss.android.lark.filedetail.impl.open.j(getContext(), this.y);
        ArrayList r1 = new ArrayList();
        OpenFileInfo r2 = r0.d;
        if (r2.mShowOpenWith3rdPartyApp == true) goto L5;
    L11:
        boolean r3 = TextUtils.isEmpty(r0.d.previewId);
        OpenFileInfo r4 = r0.d;
        if (r4.mIsSecret == true) goto L40;
        FileContent r5 = r4.mFileContent;
        if (r5 != null) goto L16;
    L18:
        boolean r6 = false;
    L20:
        if (TextUtils.isEmpty(r0.d.mMessageId) == true) goto L40;
        OpenFileInfo r7 = r0.d;
        if (r7.mShowDownload == true) goto L24;
    L30:
        OpenFileInfo r8 = r0.d;
        if (r8.mShowForward == false) goto L37;
        if ((r8.mMenuFlag & 2) <= 0) goto L37;
        if (r3 == false) goto L37;
        r1.add(new com.ss.android.lark.widget.menu.b.a(UIHelper.getString(2131891777), new com.ss.android.lark.filedetail.impl.open.g(r0)));
    L37:
        if ((r0.d.mMenuFlag & 4) <= 0) goto L40;
        r1.add(new com.ss.android.lark.widget.menu.b.a(UIHelper.getString(2131891503), new FileOpenMenu$4(r0)));
        goto L40
    L24:
        if (r7.mIsCrossWithKA == true) goto L30;
        if (r6 == true) goto L30;
        if ((r7.mMenuFlag & 1) <= 0) goto L30;
        if (r3 == false) goto L30;
        r1.add(new com.ss.android.lark.widget.menu.b.a(UIHelper.getString(2131892144), new FileOpenMenu$2(r0)));
        goto L30
    L16:
        if (r5.isFromDrive() == false) goto L18;
        r6 = true;
    L40:
        if (r0.d.mJumpPosition == (-1)) goto L43;
        if (r3 == false) goto L43;
        r1.add(new com.ss.android.lark.widget.menu.b.a(UIHelper.getString(2131892317), new com.ss.android.lark.filedetail.impl.open.h(r0)));
    L43:
        r0.d.mFileContent.getMime();
        if (CollectionUtils.isEmpty(r1) == true) goto L46;
        com.ss.android.lark.widget.menu.b.a r9 = new com.ss.android.lark.widget.menu.b.a(UIHelper.getString(2131891541), new com.ss.android.lark.filedetail.impl.open.i());
        r9.c = 2131102096;
        r9.e = true;
        r1.add(r9);
    L46:
        Iterator r10 = r1.iterator();
    L48:
        if (r10.hasNext() == false) goto L50;
        ((com.ss.android.lark.widget.menu.b.a) r10.next()).d = 2131106521;
        goto L48
    L50:
        return r1;
    L5:
        if (r0.f == true) goto L11;
        FileContent r11 = r2.mFileContent;
        if (r11 != null) goto L9;
        String r12 = BuildConfig.FLAVOR;
    L10:
        r1.add(new com.ss.android.lark.widget.menu.b.a(UIHelper.getString(2131892047), new com.ss.android.lark.filedetail.impl.open.e(r0, r12)));
        goto L11
    L9:
        r12 = r11.getKey();
        goto L10
    }

    public final void Y90() {
        if (this.B.isSecret() == true) goto L5;
        return;
    L5:
        UICallbackExecutor.executeDelayed(new e(this), 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void aa0() {
        if (this.i.getFileState() != com.ss.android.lark.chat.entity.message.content.FileState.DONE) goto L19;
        int r0 = pfb.a.a;
        String r1 = this.i.getMime();
        Intrinsics.checkNotNullParameter(r1, "fileType");
        Statistics.sendEvent("click_open_local_attach", new JSONObject().put("file_type", r1));
        if (com.ss.android.lark.filedetail.impl.open.c.a(this.B) == true) goto L12;
        Message r2 = this.g;
        if (r2 == null) goto L9;
        String r3 = r2.getChatId();
    L10:
        FileContent r4 = this.i;
        Lazy r7 = FileHitPointUtil.a;
        Intrinsics.checkNotNullParameter(r4, "fileContent");
        Intrinsics.checkNotNullParameter("button", "source");
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new com.ss.android.lark.filedetail.impl.detail.f(r3, r4, "button"));
        goto L12
    L9:
        r3 = this.s;
    L12:
        if (this.u == false) goto L14;
        int r5 = pfb.c.a;
        String r6 = this.t;
        Statistics.sendEvent("click_chat_history_results", new JSONObject().put("category", "files").put("is_search", r6).put(Keys.API_PARAM_KEY_ACTION, "open_file"));
    L14:
        Message r8 = this.g;
        if (r8 == null) goto L17;
        this.f.i(r8, this.i, getContext(), this.B, null);
        return;
    L17:
        this.f.g(this.i, this.l, getContext(), this.B);
        return;
    L19:
        if (getContext() != null) goto L21;
    L26:
        Message r9 = this.g;
        if (r9 == null) goto L29;
        this.f.b(r9, this.i, getContext(), this.B);
    L31:
        if (this.u == false) goto L36;
        int r10 = pfb.c.a;
        String r11 = this.t;
        Statistics.sendEvent("click_chat_history_results", new JSONObject().put("category", "files").put("is_search", r11).put(Keys.API_PARAM_KEY_ACTION, "download_file"));
        return;
    L36:
        return;
    L29:
        this.f.c(this.i, this.l, getContext(), this.B);
        goto L31
    L21:
        if (StoragePermissionUtils.e(getContext()) == false) goto L26;
        Message r12 = this.g;
        if (r12 == null) goto L25;
        this.f.i(r12, this.i, getContext(), this.B, null);
        goto L31
    L25:
        this.f.g(this.i, this.l, getContext(), this.B);
        goto L31
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void ba0() {
        if (this.k == false) goto L8;
        String r0 = this.i.getFilePath();
        this.i.getName();
        Drawable r1 = ApkUtil.getApkIcon(sfb.c.a(r0), getContext());
        if (r1 == null) goto L9;
        this.vImageFileIcon.setImageDrawable(r1);
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.filedetail.impl.detail.z
    public final void cK() {
        FileDownloadState r0 = this.x;
        if (r0 != FileDownloadState.PAUSE) goto L5;
        return;
    L5:
        if (r0 == FileDownloadState.STOP) goto L9;
        V90(FileDownloadState.DECRYPT_START);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.filedetail.impl.detail.z
    public final void fM() {
        com.larksuite.component.ui.dialog.d r0 = new com.larksuite.component.ui.dialog.d(getContext());
        r0.j(2131891825);
        r0.c.titleBold(true);
        r0.c.message(2131891742);
        r0.a(2131378551, 2131891628, null);
        LKUIDialog r1 = r0.c();
        r1.setOnDismissListener(new g(this));
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.filedetail.impl.c] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.ss.android.lark.filedetail.impl.d] */
    public FileDetailFragment() {
        this.m = -1;
        this.n = false;
        this.o = true;
        this.p = true;
        this.q = true;
        this.r = true;
        this.x = FileDownloadState.NORMAL;
        com.ss.android.lark.storage.a r1 = FileDetailModule.a;
        hfb.b r2 = FileDetailModule.a.a();
        this.D = r2;
        this.E = r2.getDownloadDependency();
        this.F = r2.getChatDependency();
        r2.getAuditDependency();
        new com.bytedance.creativex.mediaimport.preview.internal.main.g();
        this.G = null;
        this.H = false;
        this.I = false;
        this.J = new com.ss.android.lark.filedetail.impl.c(this);
        this.L = new com.ss.android.lark.filedetail.impl.d(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        UDLoadingDrawable r0 = this.d;
        if (r0 == null) goto L5;
        r0.stop();
    L5:
        UICallbackExecutor.removeCallbacks(this.L);
        LKUIStatus r1 = this.K;
        if (r1 != null) goto L8;
    L13:
        EventBus.getDefault().unregister(this);
        b r2 = this.C;
        if (r2 != null) goto L16;
    L18:
        FileTransmissionPresenter r3 = this.f;
        if (r3 == null) goto L22;
        r3.b.cancelCallbacks();
    L22:
        if (this.g != null) goto L24;
    L28:
        NetworkTypeListener r4 = this.A;
        if (r4 == null) goto L31;
        this.D.removeListenerToNetworkTypeDispatcher(r4);
    L31:
        Disposable r5 = this.G;
        if (r5 != null) goto L34;
    L36:
        int r6 = com.ss.android.lark.filedetail.impl.open.d.b;
        com.ss.android.lark.filedetail.impl.open.d.b.a.a = null;
        return;
    L34:
        if (r5.isDisposed() == true) goto L36;
        this.G.dispose();
        goto L36
    L24:
        if (this.H == true) goto L28;
        if (this.e == 6) goto L28;
        FileDetailModuleDependencyMock.a r7 = this.D.getPushDependency();
        String.valueOf(hashCode());
        this.g.getChatId();
        r7.getClass();
        Log.w("FileDetailModuleDependencyMock", "unregisterPushChatRelationListener mocked");
        goto L28
    L16:
        if (this.H == true) goto L18;
        this.D.removeListenerToDriveSaveStateEventPush(r2);
        goto L18
    L8:
        if (r1.i != 2) goto L10;
        boolean r8 = true;
    L11:
        if (r8 == false) goto L13;
        r1.b();
        goto L13
    L10:
        r8 = false;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        this.i.setFileState(com.ss.android.lark.chat.entity.message.content.FileState.DOWNLOAD);
        FileDetailModule.NetworkType.a r0 = FileDetailModule.NetworkType.Companion;
        FileDetailModuleDependencyMock.c r1 = this.w;
        getContext();
        r1.getClass();
        Log.w("FileDetailModuleDependencyMock", "getCurrentNetworkType mocked");
        r0.getClass();
        this.z = FileDetailModule.NetworkType.a.a(0);
        if (TextUtils.isEmpty(this.i.getFilePath()) == true) goto L8;
        String r2 = this.i.getFilePath();
        this.i.getName();
        if (sfb.c.c(r2) == false) goto L8;
        W90();
        return;
    L8:
        RxScheduledExecutor.execInIO(new n(this), new o(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.filedetail.impl.detail.z
    public final void y() {
        finish();
    }

    public static /* synthetic */ void S90(FileDetailFragment r1) {
        if (r1.I == true) goto L7;
        LKUIToast.showLoading(((BaseFragment) r1).mContext, BuildConfig.FLAVOR);
        return;
    }

    public static void U90(FileDetailFragment r3) {
        OpenFileInfo r0 = r3.y;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.mFileContent == null) goto L13;
        List<com.ss.android.lark.widget.menu.b.a> r1 = r3.X90();
        if (CollectionUtils.isEmpty(r1) == true) goto L14;
        Context r4 = ((BaseFragment) r3).mContext;
        com.ss.android.lark.widget.menu.b.c r2 = new com.ss.android.lark.widget.menu.b.c(r4, r1);
        r2.c.setVisibility(8);
        r2.d = null;
        com.ss.android.lark.widget.menu.b.a(r4, r2.a);
        return;
    L14:
        return;
    }

    @Override // com.ss.android.lark.filedetail.impl.detail.z
    public final void CW(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        LKUIToast.show(((BaseFragment) this).mContext, r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V90(FileDownloadState r23) {
        Log.i("FileDetailFragment", "change download state :" + r23);
        FileTransmissionPresenter r2 = this.f;
        r2.k = r23;
        String r4 = r2.q;
        boolean r11 = true;
        if (r4 == null) goto L14;
        int r3 = FileTransmissionPresenter.a.b[r23.ordinal()];
        if (r3 != 1) goto L8;
        int r5 = rfb.a.a;
        Intrinsics.checkNotNullParameter(r4, "key");
        AppreciableKit.pause$default(AppreciableKit.Companion.getInstance(), r4, MapsKt.mapOf(TuplesKt.to("had_been_paused", Boolean.TRUE)), null, null, null, 28, null);
        goto L14
    L8:
        if (r3 == 2) goto L12;
        if (r3 != 3) goto L14;
        int r6 = rfb.a.a;
        Intrinsics.checkNotNullParameter(r4, "key");
        AppreciableKit.resume$default(AppreciableKit.Companion.getInstance(), r4, null, null, null, null, 30, null);
        goto L14
    L12:
        boolean r7 = r2.p;
        int r8 = rfb.a.a;
        rfb.a.a(r7, ErrorType.Other, 3, "no permission");
    L14:
        UIUtils.hide(this.mDecryptLoadingIV);
        UIUtils.hide(this.mDecryptTipsTV);
        Message.SourceType r9 = null;
        switch(a.a[r23.ordinal()]) {
            case 1: goto L79;
            case 2: goto L78;
            case 3: goto L68;
            case 4: goto L36;
            case 5: goto L35;
            case 6: goto L34;
            case 7: goto L29;
            case 8: goto L28;
            case 9: goto L24;
            case 10: goto L20;
            case 11: goto L19;
            case 12: goto L18;
            case 13: goto L17;
            default: goto L80;
        };
    L17:
        Y90();
        this.i.setFileState(com.ss.android.lark.chat.entity.message.content.FileState.DOWNLOAD);
        UIUtils.hide(this.vBtnFunction);
        UIUtils.hide(this.vLayoutProgress);
        UIUtils.hide(this.vTextFileSpeed);
        goto L80
    L18:
        Y90();
        UIUtils.hide(this.vLayoutProgress);
        UIUtils.hide(this.vTextFileSpeed);
        UIUtils.show(this.mDecryptTipsTV);
        this.f.j();
        ProgressBar r10 = this.vProgressBar;
        r10.setSecondaryProgress(r10.getProgress());
        Z90(this.mDecryptTipsTV, 0, 2131102093, UIUtils.getString(getContext(), 2131891736));
        Z90(this.vBtnFunction, 2131235380, 2131106521, UIUtils.getString(getContext(), 2131892115));
        goto L80
    L19:
        Y90();
        UIUtils.hide(this.vLayoutProgress);
        UIUtils.hide(this.vTextFileSpeed);
        UIUtils.show(this.mDecryptTipsTV);
        this.f.j();
        ProgressBar r12 = this.vProgressBar;
        r12.setSecondaryProgress(r12.getProgress());
        Z90(this.mDecryptTipsTV, 0, 2131102093, UIUtils.getString(getContext(), 2131891053));
        Z90(this.vBtnFunction, 2131235380, 2131106521, UIUtils.getString(getContext(), 2131892115));
        goto L80
    L20:
        Y90();
        UDLoadingDrawable r13 = this.d;
        if (r13 == null) goto L23;
        r13.stop();
    L23:
        UIUtils.hide(this.vLayoutProgress);
        UIUtils.show(this.vTextFileSpeed);
        UIUtils.show(this.vTextFileSize);
        UIUtils.hide(this.mDecryptLoadingIV);
        UIUtils.show(this.vBtnFunction);
        UIUtils.show(this.mDecryptTipsTV);
        Z90(this.vBtnFunction, 2131235380, 2131106521, UIUtils.getString(getContext(), 2131891327));
        Z90(this.mDecryptTipsTV, 0, 2131102093, UIUtils.getString(getContext(), 2131891326));
        this.vTextFileSize.setText(FileUtils.h(this.i.getSize()));
        goto L80
    L24:
        this.vImageFileIcon.setVisibility(0);
        this.vTextFileName.setVisibility(0);
        UIUtils.hide(this.vLayoutProgress);
        UIUtils.hide(this.vTextFileSpeed);
        UIUtils.show(this.vTextFileSize);
        UIUtils.show(this.mDecryptLoadingIV);
        UIUtils.hide(this.vBtnFunction);
        this.mDecryptLoadingIV.setImageDrawable(this.d);
        UDLoadingDrawable r14 = this.d;
        if (r14 == null) goto L27;
        r14.start();
    L27:
        this.vTextFileSize.setText(2131891325);
        goto L80
    L28:
        Y90();
        this.f.j();
        fM();
        goto L80
    L29:
        Y90();
        this.f.j();
        com.larksuite.component.ui.dialog.d r15 = new com.larksuite.component.ui.dialog.d(getContext());
        r15.j(2131891825);
        r15.c.titleBold(true);
        r15.c.message(2131891741);
        r15.a(2131378551, 2131891628, null);
        LKUIDialog r16 = r15.c();
        r16.setOnDismissListener(new com.ss.android.lark.filedetail.impl.b(this));
        if (DialogLancet.shouldBlockDialogShow(r16) == false) goto L83;
        DialogLancet.handleBlockedDialogShow(r16);
        goto L80
    L83:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L82
    L33:
        DialogLancet.beforeDialogShow(r16);
        r16.show();
        DialogLancet.afterDialogShow(r16);
        goto L80
    L34:
        Y90();
        UIUtils.hide(this.vLayoutProgress);
        UIUtils.hide(this.vTextFileSpeed);
        UIUtils.hide(this.mDecryptTipsTV);
        UIUtils.hide(this.vBtnFunction);
        this.f.j();
        ProgressBar r17 = this.vProgressBar;
        r17.setSecondaryProgress(r17.getProgress());
        Z90(this.mDecryptTipsTV, 0, 2131102093, UIUtils.getString(getContext(), 2131891741));
        goto L80
    L35:
        Y90();
        UIUtils.hide(this.vLayoutProgress);
        UIUtils.hide(this.vTextFileSpeed);
        this.i.setFileState(com.ss.android.lark.chat.entity.message.content.FileState.DOWNLOAD);
        this.f.j();
        UIUtils.hide(this.mTipsTv);
        Z90(this.vBtnFunction, 2131235380, 2131106521, UIUtils.getString(getContext(), 2131891694) + String.format("(%s)", new Object[]{FileUtils.h(this.i.getSize())}));
        FileDetailModuleDependencyMock.c r18 = this.w;
        this.i.getKey();
        r18.getClass();
        Log.w("FileDetailModuleDependencyMock", "removeTask mocked");
        goto L80
    L36:
        this.i.setFileState(com.ss.android.lark.chat.entity.message.content.FileState.DONE);
        UDLoadingDrawable r19 = this.d;
        if (r19 == null) goto L40;
        r19.stop();
    L40:
        if (this.B.isSecret() == false) goto L43;
        this.f.i(this.g, this.i, getContext(), this.B, new c(this));
        FileDetailModuleDependencyMock.c r1 = this.w;
        this.i.getKey();
        r1.getClass();
        Log.w("FileDetailModuleDependencyMock", "removeTask mocked");
        return;
    L43:
        Y90();
        ba0();
        UIUtils.show(this.vLayoutProgress);
        UIUtils.hide(this.vTextFileSpeed);
        this.vProgressBar.setProgress(100);
        this.vProgressBar.setSecondaryProgress(0);
        ImageView r20 = this.mCloseIv;
        r20.setImageDrawable(UIUtils.getCompatDrawable(r20.getContext(), 2131235378));
        if (com.ss.android.lark.filedetail.impl.open.c.a(this.B) == false) goto L46;
        com.ss.android.lark.filedetail.impl.open.c.b(this, getContext(), this.i, this.B);
        boolean r21 = true;
    L47:
        if (r21 == true) goto L66;
        String r22 = com.ss.android.lark.diskmanage.storage.d.i(((BaseFragment) this).mContext);
        if (TextUtils.isEmpty(r22) == false) goto L52;
    L57:
        if (r11 == false) goto L66;
        TextView r24 = this.vBtnFunction;
        Context r25 = r24.getContext();
        if (this.k == false) goto L62;
        int r26 = 2131891744;
    L65:
        Z90(r24, 2131235380, 2131106521, UIUtils.getString(r25, r26));
        Z90(this.mTipsTv, 0, 2131105548, UIUtils.getString(getContext(), 2131892304));
    L67:
        FileDetailModuleDependencyMock.c r27 = this.w;
        this.i.getKey();
        r27.getClass();
        Log.w("FileDetailModuleDependencyMock", "removeTask mocked");
        goto L80
    L62:
        if (com.ss.android.lark.filedetail.impl.open.c.a(this.B) == false) goto L64;
        r26 = 2131892046;
        goto L65
    L64:
        r26 = 2131892047;
        goto L65
    L52:
        if (this.i.getFilePath() != null) goto L54;
    L56:
        r11 = false;
        goto L57
    L54:
        if (this.i.getFilePath().startsWith(r22) == true) goto L56;
    L66:
        UIUtils.hide(this.vBtnFunction);
        goto L67
    L46:
        r21 = false;
        goto L47
    L68:
        Y90();
        UIUtils.show(this.vLayoutProgress);
        UIUtils.show(this.vTextFileSpeed);
        Z90(this.vBtnFunction, 2131235381, 2131105548, UIUtils.getString(getContext(), 2131891758));
        UIUtils.hide(this.mTipsTv);
        this.vProgressBar.setSecondaryProgress(0);
        aa0();
        Message r28 = this.g;
        if (r28 == null) goto L71;
        r28.getSourceId();
    L71:
        Message r29 = this.g;
        if (r29 == null) goto L74;
        r9 = r29.getSourceType();
    L74:
        com.ss.android.lark.filedetail.impl.a.a(((BaseFragment) this).mContext, this.i.getName());
        this.i.getKey();
        this.i.getSize();
        if (r9 == null) goto L77;
        r9.getNumber();
    L77:
        this.w.getClass();
        Log.w("FileDetailModuleDependencyMock", "addTask mocked");
        goto L80
    L78:
        Y90();
        Z90(this.vBtnFunction, 2131235380, 2131106521, UIUtils.getString(getContext(), 2131891749) + String.format("(%s)", new Object[]{FileUtils.h(this.i.getSize() - ((this.i.getSize() * ((long) this.vProgressBar.getProgress())) / 100))}));
        this.vProgressBar.setSecondaryProgress(0);
        UIUtils.hide(this.mTipsTv);
        UIUtils.show(this.vLayoutProgress);
        UIUtils.hide(this.vTextFileSpeed);
        this.f.j();
        goto L80
    L79:
        Y90();
        Z90(this.vBtnFunction, 2131235380, 2131106521, UIUtils.getString(getContext(), 2131891694) + String.format("(%s)", new Object[]{FileUtils.h(this.i.getSize())}));
        this.vProgressBar.setSecondaryProgress(0);
        UIUtils.hide(this.vLayoutProgress);
        UIUtils.hide(this.vTextFileSpeed);
        this.f.j();
    L80:
        this.x = r23;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.filedetail.impl.detail.z
    public final void dX(int r8) {
        if (getContext() != null) goto L5;
        return;
    L5:
        this.vProgressBar.setMax(100);
        this.vProgressBar.setProgress(r8);
        if (this.g != null) goto L8;
    L10:
        String r9 = "local";
    L11:
        Context r1 = ((BaseFragment) this).mContext;
        FileContent r2 = this.i;
        StringBuilder r3 = new StringBuilder(" ");
        if (r2.getFileState().getFileStateType() != 3) goto L15;
        r3.append(" ");
        r3.append(UIUtils.getString(r1, 2131892307));
    L17:
        boolean r4 = true;
    L19:
        if (r4 == false) goto L21;
        r3.append(" ");
        r3.append(FileUtils.h(r2.getSpeed()));
        r3.append("/s");
    L21:
        this.vTextFileSpeed.setText(r3);
        String r5 = this.i.getFilePath();
        this.i.getName();
        if (sfb.c.c(r5) == false) goto L25;
        V90(FileDownloadState.DONE);
        int r6 = pfb.a.a;
        String r7 = this.i.getMime();
        long r10 = this.i.getSize();
        Intrinsics.checkNotNullParameter(r7, "fileType");
        Intrinsics.checkNotNullParameter(ChameleonOpenTracker.OpenResult.SUCCESS, "status");
        Intrinsics.checkNotNullParameter(r9, "source");
        JSONObject r0 = new JSONObject();
        r0.put("file_type", r7);
        r0.put("status", ChameleonOpenTracker.OpenResult.SUCCESS);
        r0.put("file_source", r9);
        r0.put("file_size", r10);
        Statistics.sendEvent("download_local_finish", r0);
        return;
    L25:
        return;
    L15:
        if (r2.getFileState().getFileStateType() != 2) goto L18;
        r3.append(" ");
        r3.append(UIUtils.getString(r1, 2131891738));
        goto L17
    L18:
        r4 = false;
        goto L19
    L8:
        if (this.i.isFromDrive() == false) goto L10;
        r9 = "source";
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onActivityCreated(Bundle r11) {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onActivityCreated(r11);
        ButterKnife.bind(this, getView());
        this.D.getDriveDependency();
        this.w = this.D.getDownloadFileMonitorDependency();
        if (getArguments() == null) goto L5;
        ((FileDetailLaunchParams) getArguments().getSerializable("extra.launch.params")).getPreviewId();
    L5:
        this.C = new b();
        Bundle r12 = getArguments();
        boolean r2 = true;
        if (r12 == null) goto L85;
        FileDetailLaunchParams r13 = (FileDetailLaunchParams) r12.getSerializable("extra.launch.params");
        if (r13 == null) goto L85;
        this.e = (int) r13.getFrom();
        this.g = r13.getMessage();
        this.h = r13.getFavoriteMessage();
        if (this.g != null) goto L14;
        hfb.b.d r0 = this.F;
        r13.getMessageId();
        r0.d();
        this.g = null;
    L14:
        Message r1 = this.g;
        if (r1 != null) goto L17;
    L21:
        boolean r3 = false;
    L22:
        Message r5 = this.g;
        if (r5 != null) goto L25;
    L30:
        this.i = r13.getFileContent();
        this.l = r13.getMessageId();
        if (this.i != null) goto L37;
        Message r4 = this.g;
        if (r4 == null) goto L37;
        if (r4.getType() != Message.Type.FILE) goto L37;
        this.i = (FileContent) this.g.getContent();
    L37:
        FileContent r6 = this.i;
        if (r6 == null) goto L85;
        if (TextUtils.isEmpty(r6.getName()) == true) goto L85;
        this.H = r13.isFromFolderManager();
        OpenFileInfo r7 = new OpenFileInfo();
        this.y = r7;
        r7.mFileContent = this.i;
        r7.mMessageId = this.l;
        r7.mMessage = this.g;
        r7.mMenuFlag = r13.getMenuFlag();
        OpenFileInfo r8 = this.y;
        int r9 = this.e;
        if (r9 == 5) goto L57;
        if (r9 != 6) goto L46;
        FavoriteMessageInfo r10 = this.h;
        if (r10 == null) goto L58;
        r8.mSourceType = Message.SourceType.TYPE_FROM_FAVORITE;
        r8.mSourceId = r10.getId();
    L58:
        OpenFileInfo r14 = this.y;
        r14.mFavoriteMessage = this.h;
        r14.threadId = r13.getThreadId();
        this.y.isFromFolderManage = r13.isFromFolderManager();
        this.y.forwardAsFile = r13.getForwardAsFile();
        OpenFileInfo r15 = this.y;
        int r16 = r13.getJumpPosition();
        r15.mJumpPosition = r16;
        this.m = r16;
        this.n = r13.isSecret();
        this.o = r13.getShowDownload();
        if (r13.getShowForward() == true) goto L61;
    L63:
        boolean r17 = false;
    L64:
        this.p = r17;
        this.r = r13.getShowMenuAndFuncButton();
        OpenFileInfo r18 = this.y;
        String r19 = r13.getChatId();
        r18.mChatId = r19;
        this.s = r19;
        if (TextUtils.isEmpty(this.y.mChatId) == false) goto L69;
        Message r20 = this.g;
        if (r20 == null) goto L69;
        this.y.mChatId = r20.getChatId();
    L69:
        int r21 = com.ss.android.lark.filedetail.impl.open.d.b;
        com.ss.android.lark.filedetail.impl.open.d r22 = com.ss.android.lark.filedetail.impl.open.d.b.a;
        String r23 = this.s;
        r22.getClass();
        Intrinsics.checkNotNullParameter(r23, "chatId");
        r22.a = r23;
        if (r13.isSearch() == false) goto L72;
        String r24 = "y";
    L73:
        this.t = r24;
        this.u = r13.getNeedHitPoint();
        OpenFileInfo r25 = this.y;
        r25.mIsSecret = this.n;
        r25.mIsCrossWithKA = r13.isCrossWithKA();
        OpenFileInfo r26 = this.y;
        boolean r27 = this.o;
        r26.mShowDownload = r27;
        r26.mShowForward = this.p;
        r26.mShowOpenWith3rdPartyApp = r27;
        r26.previewId = r13.getPreviewId();
        this.y.authFileKey = r13.getAuthFileKey();
        this.y.msgLinkToken = r13.getMsgLinkToken();
        if (r13.getShowMenuAndFuncButton() == true) goto L76;
    L78:
        boolean r28 = false;
    L79:
        this.q = r28;
        OpenFileParams.Companion.getClass();
        OpenFileParams.a r29 = new OpenFileParams.a();
        FileContent r30 = this.i;
        Intrinsics.checkNotNullParameter(r30, "fileContent");
        Intrinsics.checkNotNullParameter(r30, "<set-?>");
        r29.a = r30;
        String r31 = this.l;
        Intrinsics.checkNotNullParameter(r31, "messageId");
        Intrinsics.checkNotNullParameter(r31, "<set-?>");
        r29.b = r31;
        String r32 = this.s;
        Intrinsics.checkNotNullParameter(r32, "chatId");
        r29.d = r32;
        r29.c = this.m;
        r29.e = this.n;
        r29.f = r13.isCrossWithKA();
        r29.g = this.o;
        r29.h = this.p;
        r29.i = this.y.mMenuFlag;
        String r33 = r13.getMergeMsgChatId();
        Intrinsics.checkNotNullParameter(r33, "mergeMsgChatId");
        r29.j = r33;
        r29.k = r13.getDownloadFileScene();
        r29.l = r13.getPreviewId();
        r29.m = r13.getAuthFileKey();
        r29.n = r13.getMsgLinkToken();
        this.B = r29.a();
        String r110 = this.i.getName();
        this.j = r110;
        if (r110 != null) goto L82;
    L84:
        FileTransmissionPresenter r111 = new FileTransmissionPresenter(this.n);
        this.f = r111;
        r111.a = new WeakReference(this);
        boolean r112 = true;
    L86:
        if (r112 == true) goto L89;
        finish();
        return;
    L89:
        this.K = new LKUIStatus(new LKUIStatus.b(this.mRootView));
        DesktopUtil.a(getActivity());
        this.vTitleBar.setTitle(this.j);
        boolean r113 = this.n;
        if (r113 == false) goto L94;
        if (r113 == true) goto L93;
        boolean r114 = true;
    L95:
        if (r114 == false) goto L97;
        this.vTitleBar.addAction(new j(this));
    L97:
        TextView r115 = this.vBtnFunction;
        if (this.r == false) goto L100;
        int r34 = 0;
    L101:
        r115.setVisibility(r34);
        this.vTitleBar.setLeftClickListener(new k(this));
        this.G = RxScheduledExecutor.execInIO(new h(this), new i(this));
        this.vTextFileName.setText(this.j);
        this.vImageFileIcon.setImageResource(a0.b(this.i.getMime(), this.i.getName(), 1));
        this.vTextFileSize.setText(FileUtils.h(this.i.getSize()));
        this.mCloseIv.setOnClickListener(new l(this));
        this.vBtnFunction.setOnClickListener(new m(this));
        if (this.B.isSecret() == false) goto L105;
        this.vBtnFunction.setVisibility(8);
        this.vImageFileIcon.setVisibility(4);
        this.vTextFileName.setVisibility(4);
    L105:
        UDLoadingDrawable r116 = new UDLoadingDrawable(((BaseFragment) this).mContext);
        this.d = r116;
        r116.setColorSchemeColors(new int[]{UIUtils.getColor(((BaseFragment) this).mContext, 2131105548)});
        boolean r117 = !this.n;
        if (getActivity() == null) goto L112;
        Window r35 = getActivity().getWindow();
        if (r117 == false) goto L111;
        r35.clearFlags(8192);
        goto L112
    L111:
        r35.setFlags(8192, 8192);
    L112:
        hfb.b r118 = this.D;
        if (r118 != null) goto L115;
    L117:
        FileDetailModule.NetworkType.a r119 = FileDetailModule.NetworkType.Companion;
        FileDetailModuleDependencyMock.c r36 = this.w;
        getContext();
        r36.getClass();
        Log.w("FileDetailModuleDependencyMock", "getCurrentNetworkType mocked");
        r119.getClass();
        this.z = FileDetailModule.NetworkType.a.a(0);
        NetworkTypeListener r120 = new AnonymousClass2(this);
        this.A = r120;
        this.D.addListenerToNetworkTypeDispatcher(r120);
        EventBus.getDefault().register(this);
        if (this.H == true) goto L121;
        this.D.addListenerToDriveSaveStateEventPush(this.C);
    L121:
        if (this.g == null) goto L128;
        if (this.H == true) goto L128;
        if (this.e == 6) goto L128;
        FileDetailModuleDependencyMock.a r121 = this.D.getPushDependency();
        String.valueOf(hashCode());
        this.g.getChatId();
        r121.getClass();
        Log.w("FileDetailModuleDependencyMock", "registerPushChatRelationListener mocked");
    L128:
        if (this.e == 1) goto L130;
        return;
    L130:
        if (this.z != FileDetailModule.NetworkType.WIFI) goto L132;
        boolean r122 = true;
    L134:
        if ((this.i.getSize() - ((this.i.getSize() * ((long) this.vProgressBar.getProgress())) / 100)) <= 0) goto L137;
        r2 = false;
    L137:
        boolean r123 = r122 & r2;
        String r37 = this.s;
        FileContent r38 = this.i;
        Lazy r39 = FileHitPointUtil.a;
        Intrinsics.checkNotNullParameter(r38, "fileContent");
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new com.ss.android.lark.filedetail.impl.detail.c(r37, r38, r123));
        return;
    L132:
        r122 = false;
        goto L134
    L115:
        if (this.i == null) goto L117;
        FileDetailModuleDependencyMock.e r124 = r118.getAuditDependency();
        this.i.getMime();
        this.i.getKey();
        r124.getClass();
        Log.w("FileDetailModuleDependencyMock", "auditFilePreview mocked");
        goto L117
    L100:
        r34 = 8;
        goto L101
    L93:
        r114 = false;
        goto L95
    L94:
        r114 = this.q;
        goto L95
    L82:
        if (r110.endsWith(".apk") == false) goto L84;
        this.k = true;
        goto L84
    L76:
        if (CollectionUtils.isEmpty(X90()) == true) goto L78;
        r28 = true;
        goto L79
    L72:
        r24 = "n";
        goto L73
    L61:
        if (TextUtils.isEmpty(r13.getPreviewId()) == false) goto L63;
        r17 = true;
        goto L64
    L46:
        if (r9 == 7) goto L50;
        Message r40 = this.g;
        if (r40 == null) goto L58;
        r8.mSourceType = r40.getSourceType();
        r8.mSourceId = this.g.getSourceId();
        goto L58
    L50:
        r8.mSourceType = Message.SourceType.TYPE_FROM_TODO_REFER_RESOURCE;
        Message r41 = this.g;
        if (r41 == null) goto L53;
        r8.mSourceId = r41.getSourceId();
        goto L58
    L53:
        Log.e("FileDetailFragment", "todo file message=null，messageId=" + this.l);
        goto L58
    L57:
        r8.mSourceType = Message.SourceType.TYPE_FROM_CHAT_PIN;
        r8.mSourceId = this.l;
        goto L58
    L25:
        if (r5.getType() == Message.Type.FILE) goto L30;
        if (this.g.getType() == Message.Type.FOLDER) goto L30;
        if (r3 == true) goto L30;
    L17:
        if (r1.getType() != Message.Type.POST) goto L21;
        if (r13.getFileContent() == null) goto L21;
        r3 = true;
    L85:
        r112 = false;
        goto L86
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttach(Context r2) {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onAttach(r2);
        if ((r2 instanceof d) == false) goto L6;
        this.M = (d) r2;
        return;
    }

    @Override // com.ss.android.lark.filedetail.impl.detail.z
    public final void vy(List r6) {
        ArrayList r0 = new ArrayList();
        Iterator r7 = r6.iterator();
    L3:
        boolean r2 = true;
        if (r7.hasNext() == false) goto L17;
        String r1 = (String) r7.next();
        String[] r4 = FileUtils.a;
        if (TextUtils.isEmpty(r1) == false) goto L9;
    L13:
        r2 = false;
    L14:
        if (r2 == true) goto L15;
        r0.add(new PhotoItem().setImageKey(r1).setPaths(Collections.singletonList(r1)).setLoadModel(new EncryptImage(r1)));
        goto L3
    L15:
        r0.add(new PhotoItem().setLoadModel(r1).setPaths(Collections.singletonList(r1)));
        goto L3
    L9:
        if (URLUtil.isNetworkUrl(r1) == true) goto L14;
        if (FileUtils.s(r1) == false) goto L13;
    L17:
        FragmentActivity r8 = getActivity();
        if (r8 == null) goto L27;
        TextView r3 = this.vBtnFunction;
        int r5 = com.ss.android.lark.widget.photo.preview.k.a;
        com.ss.android.lark.widget.photo.preview.k.c r9 = com.ss.android.lark.widget.photo.preview.k.a.a(r0, 0, r3);
        r9.l(true);
        r9.j(true);
        r9.h(true);
        r9.n(true);
        r9.r(r8);
        return;
    }

    public static void T90(final FileDetailFragment r2, boolean r3) {
        p.a(((BaseFragment) r2).mContext, r3, new f(r2));
    }

    @Override // com.ss.android.lark.filedetail.impl.detail.z
    public final void ht(Fragment r4, String r5) {
        FragmentTransaction r6 = ((BaseFragment) this).mContext.getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r6, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.content) == true) goto L6;
        r6 = r6.replace(R.id.content, r4);
    L6:
        r6.commitAllowingStateLoss();
        d r7 = this.M;
        if (r7 == null) goto L10;
        r7.l();
        return;
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r3, r4, r5);
        if (r4 != (-1)) goto L18;
        boolean r6 = true;
        if (r3 != 1) goto L19;
        FileTransmissionPresenter r7 = this.f;
        if (this.g == null) goto L10;
        r6 = false;
    L10:
        File r8 = r7.m;
        if (r8 == null) goto L20;
        Context r0 = r7.l;
        String r1 = r7.n;
        if (r6 == false) goto L15;
        String r9 = r7.j;
    L16:
        r7.f(r0, r8, r1, r9);
        return;
    L15:
        r9 = r7.i;
        goto L16
    L20:
        return;
    L19:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131558479, r3, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z90(TextView r2, int r3, int r4, String r5) {
        if (r2 == this.vBtnFunction) goto L5;
        UIUtils.show(r2);
    L8:
        r2.setText(r5);
        r2.setTextColor(UIUtils.getColor(getContext(), r4));
        r2.setBackgroundResource(r3);
        return;
    L5:
        if (this.r == false) goto L8;
        UIUtils.show(r2);
        goto L8
    }
}
