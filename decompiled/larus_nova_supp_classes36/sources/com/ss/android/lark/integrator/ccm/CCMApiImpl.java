package com.ss.android.lark.integrator.ccm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bytedance.ee.bear.attachment.filereader.FileClickData;
import com.bytedance.ee.bear.attachment.filereader.x;
import com.bytedance.ee.bear.basesdk.apisupport.q;
import com.bytedance.ee.bear.basesdk.apisupport.w;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.lark.SpaceRouteBean;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.document.associated.QuickLaunchBarItemType;
import com.bytedance.ee.bear.facade.common.ExtensionActivityImpl;
import com.bytedance.ee.bear.integrator.dto.FileClickModel;
import com.bytedance.ee.bear.lark.selector.DocModuleInner;
import com.bytedance.ee.bear.lark.selector.DocSelectorActivity;
import com.bytedance.ee.bear.lark.selector.auth.DocAuthSelectorDialog;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.bear.screenshot.FastPngEncoder;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Doc;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.space.doc.v1.CreateDocFeedRequest;
import com.bytedance.lark.pb.space.doc.v1.MGetDocFeedsRequest;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.ccm_api.ICCMApi;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.doc.entity.DocCard;
import com.ss.android.lark.doc.entity.DocFeed;
import com.ss.android.lark.doc.entity.DocPermPair;
import com.ss.android.lark.doc.entity.DocResult;
import com.ss.android.lark.doc.entity.DocType;
import com.ss.android.lark.doc.entity.Extra;
import com.ss.android.lark.doc.entity.Icon;
import com.ss.android.lark.doc.entity.ThumbnailDetail;
import com.ss.android.lark.integrator.ccm.config.viewbinder.DocCardViewBinder;
import com.ss.android.lark.integrator.ccm.im.PreloadDocConfig;
import com.ss.android.lark.integrator.ccm.spacekit.SpacekitSdkWrapper;
import com.ss.android.lark.integrator.ccm.spacekit.j;
import com.ss.android.lark.integrator.ccm.spacekit.l;
import com.ss.android.lark.integrator.ccm.spacekit.m;
import com.ss.android.lark.integrator.ccm.spacekit.n;
import com.ss.android.lark.integrator.ccm.spacekit.o;
import com.ss.android.lark.integrator.ccm.spacekit.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.preload.moment.PreloadMoment;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.l0;
import com.ss.android.lark.utils.o0;
import com.ss.android.lark.utils.rxjava.LarkRxSchedulers;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import h0b.g;
import io.reactivex.Flowable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import pn4.i;
import pn4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(ICCMApi.class)
public class CCMApiImpl implements ICCMApi {
    private static final String TAG = "CCMApiImpl";
    private static final Map<j5b.a, g> sPushSaveToNutStateListenerMap = null;
    private static final Map<j5b.a, g> sPushSaveToSpaceStateListenerMap = null;
    private FastPngEncoder fastPngEncoder;
    private hz4.b mScreenshotWrapper;

    public class a implements RequestListener {
        public final /* synthetic */ WeakReference a;

        public final boolean onResourceReady(Object r1, Object r2, Target r3, DataSource r4, boolean r5) {
            return false;
        }

        public a(WeakReference r1) {
            this.a = r1;
        }

        public final boolean onLoadFailed(GlideException r1, Object r2, Target r3, boolean r4) {
            tt5.a.f(CCMApiImpl.TAG, r1, false);
            ((ImageView) this.a.get()).setImageResource(2131233586);
            return true;
        }
    }

    public class b implements i5b.a {
        public b() {
        }
    }

    public class c implements com.bytedance.ee.bear.lark.selector.auth.c {
        public c() {
        }
    }

    public class d implements DocAuthSelectorDialog.d {
        public final /* synthetic */ Map a;

        public final void a(Map<String, DocPermPair.PermType> r1) {
        }

        public final void b() {
        }

        public final void onCanceled() {
        }

        public d(Map r1) {
            this.a = r1;
        }
    }

    public class e implements g {
        public final /* synthetic */ j5b.a a;

        public e(j5b.a r1) {
            this.a = r1;
        }

        public final void a(String r2, int r3) {
            this.a.a(r2, r3);
        }
    }

    public class f implements com.bytedance.ee.bear.templates.dto.c {
        public final /* synthetic */ IGetDataCallback a;

        public f(IGetDataCallback r1) {
            this.a = r1;
        }
    }

    public CCMApiImpl() {
    }

    public static /* synthetic */ void a(NetService r1, String r2, Context r3, e05.c r4) {
        lambda$getQuickLaunchBarItemForWebContainer$2(null, r1, r2, r3, r4);
    }

    public static /* synthetic */ void b(int r1) {
        lambda$showAdjustExternalPanel$0(null, r1);
    }

    public int getImportTextRes(int r2) {
        if (r2 != 102) goto L5;
        return 2131887762;
    L5:
        if (r2 == 103) goto L7;
        return 2131887760;
    L7:
        return 2131887761;
    }

    public boolean isP0MergeToMainProc() {
        return true;
    }

    public void reloadTabPageSpecUrl(wqb.b r1, boolean r2) {
    }

    public void setupServices(Context r1) {
    }

    static {
        sPushSaveToNutStateListenerMap = new ConcurrentHashMap();
        sPushSaveToSpaceStateListenerMap = new ConcurrentHashMap();
    }

    public void destroyTtsSession() {
        SpacekitSdkWrapper.b.a.c();     // Catch: Exception -> L11
        if (((mo5.e) org.koin.java.a.a(mo5.e.class)).isEnable() == true) goto L7;
        tt5.a.h(TAG, "isTtsSessionActive, TTS FG not enabled.");     // Catch: Exception -> L11
        return;
    L7:
        mo5.f r2 = ((mo5.e) org.koin.java.a.a(mo5.e.class)).V6(false);     // Catch: Exception -> L11
        if (r2 == null) goto L15;
        tt5.a.h(TAG, "destroyTtsSession");     // Catch: Exception -> L11
        r2.j();     // Catch: Exception -> L11
        return;
    L15:
        return;
    L11:
        e = move-exception;
        tt5.a.e(TAG, "destroyTtsSession, get session error:", e, false);
    }

    public Map<String, String> getDocArgsMessage() {
        HashMap r0 = new HashMap();
        j0b.a.a(r0, "from", INotificationHitPoint.NoticeType.MESSAGE);
        j0b.a.a(r0, "chat_type", INotificationHitPoint.ChatType.CHAT_TYPE_SINGLE);
        j0b.a.a(r0, "message_type", "text");
        j0b.a.a(r0, "botId", null);
        return r0;
    }

    public Map<String, String> getDocArgsMessageCard() {
        HashMap r0 = new HashMap();
        j0b.a.a(r0, "from", "message_card");
        j0b.a.a(r0, "chat_type", INotificationHitPoint.ChatType.CHAT_TYPE_SINGLE);
        j0b.a.a(r0, "message_type", "text");
        j0b.a.a(r0, "botId", null);
        return r0;
    }

    public Map<String, String> getDocArgsOther() {
        HashMap r0 = new HashMap();
        j0b.a.a(r0, "from", "lark_other");
        j0b.a.a(r0, "chat_type", INotificationHitPoint.ChatType.CHAT_TYPE_SINGLE);
        j0b.a.a(r0, "message_type", "text");
        j0b.a.a(r0, "botId", null);
        return r0;
    }

    public boolean hasLeader() {
        return qa5.b.a.a.a.providePermissionProvider().hasLeader();
    }

    public boolean isTtsSessionActive() {
    L14:
        e = move-exception;
        tt5.a.e(TAG, "isTtsSessionActive, get session error:", e, false);
        return false;
    L4:
        if (w.c() == true) goto L6;
        return false;
    L6:
        SpacekitSdkWrapper.b.a.c();     // Catch: Exception -> L14
        mo5.e r2 = (mo5.e) org.koin.java.a.a(mo5.e.class);     // Catch: Exception -> L14
        if (r2.isEnable() == true) goto L11;
        tt5.a.h(TAG, "isTtsSessionActive, TTS FG not enabled.");     // Catch: Exception -> L14
        return false;
    L11:
        if (r2.V6(false) == null) goto L18;
        return true;
    L18:
        return false;
    }

    public i provideFollowSdk() {
        return qa5.b.a.a.a.provideFollowSdk();
    }

    public k providePermissionProvider() {
        return qa5.b.a.a.a.providePermissionProvider();
    }

    public void stopWebScreenShot() {
        hz4.b r0 = this.mScreenshotWrapper;
        if (r0 == null) goto L6;
        r0.stop();
        this.mScreenshotWrapper = null;
        return;
    }

    public void stopWriteBitmapToFastPNG() {
        FastPngEncoder r0 = this.fastPngEncoder;
        if (r0 == null) goto L6;
        r0.a();
        this.fastPngEncoder = null;
        return;
    }

    public void unregisterLeaderShare() {
        SpacekitSdkWrapper.b.a.c();
        qa5.b.a.a.a.providePermissionProvider().a();
    }

    public q apiGroups() {
        cmb.f.a().getClass();
        return qa5.b.a.a.a;
    }

    public void checkAndInit() {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.c();
    }

    public String getDocPageName() {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        return "space";
    }

    public pn4.g getDriveSdkWrapper() {
        cmb.f.a().getClass();
        return qa5.b.a.a.a.a();
    }

    public void injectSessionCookies() {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        Log.i("SpacekitSdkWrapper", "DocsImpl.injectSessionCookies ");
        if (((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).isLogin() == false) goto L10;
        String r0 = jl5.a.a();
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return;
    L7:
        if (qa5.b.a() == false) goto L12;
        qa5.b.a.a.a.h().b(r0);
        return;
    L12:
        return;
    }

    public boolean isEnableWikiTab() {
        WikiModuleProvider.a().getClass();
        int r0 = WikiModuleProvider.a.a;
        return true;
    }

    public Map<String, String> getAutoInitModuleConfigMap() {
        return wrb.a.a;
    }

    public Map<Integer, Integer> getLayoutResIdMap() {
        return jmb.b.a;
    }

    public Map<String, String> getThirdPartyModuleConfigMap() {
        return wrb.a.b;
    }

    public Map<String, String> getThirdPartyPrefixModuleConfigMap() {
        return wrb.a.c;
    }

    public void addListenerToDriveSaveStateEventPush(g r4) {
        int r0 = com.ss.android.lark.integrator.ccm.a.a;
        new l0();
        if (r4 == null) goto L7;
        acb.e r1 = acb.e.a.a;
        com.ss.android.lark.sdk.f.a(r1.a, r4, new acb.a(r1));
        return;
    }

    public boolean canImImport(int r3) {
        checkAndInit();
        boolean r0 = ((BenefitManagerAPI) org.koin.java.a.a(BenefitManagerAPI.class)).n1().hasBenefit("ccm_convert_to_doc");
        if (r3 != 101) goto L5;
    L6:
        if (r0 == false) goto L8;
        return true;
    L8:
        return false;
    L5:
        if (r3 != 102) goto L8;
        goto L6
    }

    public boolean canOpen(String r2) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        return SpacekitSdkWrapper.b(r2);
    }

    public void clearCache(IGetDataCallback<Boolean> r6) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        boolean[] r0 = {false};
        qa5.b.a.a.a.f().clearCache().observeOn(LarkRxSchedulers.io()).subscribe(new m(r0), new n(r6), new o(r6, r0));
    }

    public void createDoc(Activity r2) {
        cmb.f.a().getClass();
        qa5.b.a.a.a.b().createDoc(r2);
    }

    public void destroyQuickLaunchBarItem(Context r2) {
        cmb.f.a().getClass();
        qa5.b.a.a.a.b().destroyQuickLaunchBarItem(r2);
    }

    public void forceStopKeepAliveService(Context r3) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        r3.stopService(new Intent(r3, xl5.a.class));
    }

    public void getCacheSize(IGetDataCallback<Long> r6) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        if (r6 == null) goto L7;
        long[] r0 = {0};
        qa5.b.a.a.a.f().getCacheSize().observeOn(LarkRxSchedulers.io()).subscribe(new j(r0), new com.ss.android.lark.integrator.ccm.spacekit.k(r6), new l(r6, r0));
        return;
    }

    public Map<String, String> getDocArgs(String r3) {
        HashMap r0 = new HashMap();
        j0b.a.a(r0, "from", r3);
        j0b.a.a(r0, "chat_type", INotificationHitPoint.ChatType.CHAT_TYPE_SINGLE);
        j0b.a.a(r0, "message_type", "text");
        j0b.a.a(r0, "botId", null);
        return r0;
    }

    public ibb.c getDocCardViewBinder(Context r2) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        return new DocCardViewBinder(r2);
    }

    public int getDocFilterIcon(DocType r2) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        int r3 = DocModuleInner.a.a[r2.ordinal()];
        if (r3 != 2) goto L5;
        return 2131237557;
    L5:
        if (r3 != 3) goto L7;
        return 2131237553;
    L7:
        if (r3 != 4) goto L9;
        return 2131237556;
    L9:
        if (r3 != 5) goto L11;
        return 2131237555;
    L11:
        if (r3 == 10) goto L13;
        return 2131237554;
    L13:
        return 2131237558;
    }

    public int getDocInlineBlueIcon(int r2) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r0 = SpacekitSdkWrapper.b.a;
        DocType r3 = DocType.forNumber(r2);
        r0.getClass();
        return SpacekitSdkWrapper.d(r3);
    }

    public int getDocInlineGrayIcon(int r2) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r0 = SpacekitSdkWrapper.b.a;
        DocType r3 = DocType.forNumber(r2);
        r0.getClass();
        return SpacekitSdkWrapper.d(r3);
    }

    public int getDocMiniIcon(DocType r2) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        int r3 = DocModuleInner.a.a[r2.ordinal()];
        if (r3 != 1) goto L5;
        return 2131237794;
    L5:
        if (r3 != 2) goto L7;
        return 2131237796;
    L7:
        if (r3 != 3) goto L9;
        return 2131237793;
    L9:
        if (r3 != 4) goto L11;
        return 2131237795;
    L11:
        if (r3 == 10) goto L13;
        return 0;
    L13:
        return 2131237797;
    }

    public i5b.a getDocPageLoader(String r1) {
        return new b();
    }

    public void getDrivePreviewUrl(pw4.e r4) {
        int r5 = com.ss.android.lark.integrator.ccm.a.a;
        l0 r6 = new l0();
        Object r1 = ((ConcurrentHashMap) r6.a).get(zbb.a.class);
        if (r1 != null) goto L12;
        monitor-enter(r6);
        if (r1 == null) goto L14;
    L7:
        monitor-exit(r6);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L14:
        r1 = new acb.f();     // Catch: Throwable -> L9
        ((ConcurrentHashMap) r6.a).put(zbb.a.class, r1);     // Catch: Throwable -> L9
    L12:
        ((zbb.a) r1).b();
    }

    public int getFolderIcon(boolean r2) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        if (r2 == false) goto L5;
        int r3 = 2131254672;
    L7:
        return kac.a.b(r3);
    L5:
        r3 = 2131254639;
        goto L7
    }

    public int getImportType(String r1) {
        return i55.f.a(r1);
    }

    public boolean getLeaderShareSetting(IGetDataCallback<Boolean> r2) {
        SpacekitSdkWrapper.b.a.c();
        return qa5.b.a.a.a.providePermissionProvider().getLeaderShareSetting(r2);
    }

    public List<d1c.a> getPreloadTasks(PreloadMoment r3) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r0 = SpacekitSdkWrapper.b.a;
        if (r0 == null) goto L12;
        if (DevicePerfManager.b.a.e.h == true) goto L7;
    L9:
        ArrayList r4 = new ArrayList();
        gmb.a r1 = new gmb.a();
        ((CopyOnWriteArrayList) r0.c).add(r1);
        r4.add(r1);
        return r4;
    L7:
        if (r3 != PreloadMoment.IDLE) goto L9;
    L12:
        return new ArrayList();
    }

    public Map<String, String> getUrlParamsMap(String r3) {
        HashMap r0 = new HashMap();
        j0b.a.a(r0, "from", r3);
        j0b.a.a(r0, "chat_type", INotificationHitPoint.ChatType.CHAT_TYPE_SINGLE);
        j0b.a.a(r0, "message_type", "text");
        j0b.a.a(r0, "botId", null);
        return r0;
    }

    public void initDocPlugin(Context r2) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r0 = SpacekitSdkWrapper.b.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (o0.b(r2) == false) goto L7;
        int r3 = 0;
    L8:
        r0.i(r3);
        return;
    L7:
        r3 = 5000;
        goto L8
    }

    public void initProcessorDoInit(String r3) {
        if (r3 == null) goto L27;
        byte r1 = -1;
        switch(r3.hashCode()) {
            case -1131972944: goto L16;
            case -722239547: goto L12;
            case 1873137938: goto L8;
            default: goto L19;
        };
    L19:
        switch(r1) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            default: goto L28;
        };
    L21:
        int r4 = com.ss.android.lark.integrator.ccm.a.a;
        new ConcurrentHashMap();
        return;
    L22:
        WikiModuleProvider.a();
        return;
    L23:
        cmb.f.a();
        return;
    L28:
        return;
    L8:
        if (r3.equals("com.ss.android.lark.drive.DriveModule") == false) goto L19;
        r1 = 2;
        goto L19
    L12:
        if (r3.equals("com.ss.android.lark.integrator.ccm.WikiModuleProvider.WikiModule") == false) goto L19;
        r1 = 1;
        goto L19
    L16:
        if (r3.equals("com.ss.android.lark.integrator.ccm.spacekit.LarkSpacekitModule") == false) goto L19;
        r1 = 0;
        goto L19
    }

    public void loadThumbnail(ec5.a r3) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        Log.i("SpacekitSdkWrapper", "DocsImpl.loadThumbnail ");
        RxScheduledExecutor.justInIO(new com.ss.android.lark.integrator.ccm.spacekit.e(r3));
    }

    public void onLoginStatusChangedEvent(int r2) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r0 = SpacekitSdkWrapper.b.a;
        if (r0 == null) goto L6;
        r0.f(r2);
        return;
    }

    public void openDocs(SpaceRouteBean r2) {
        cmb.f.a().getClass();
        qa5.b.a.a.a.b().f(r2);
    }

    public String[] parseDocUrl(String r4) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        if (TextUtils.isEmpty(r4) == true) goto L5;
        qa5.b r0 = qa5.b.a.a;
        String r1 = r0.a.b().j(r4);
        return new String[]{r0.a.b().l(r4), r1};
    L5:
        return null;
    }

    public void preloadDoc(List<String> r5) {
        if (CollectionUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        Iterator<String> r0 = r5.iterator();
        boolean r1 = false;
    L7:
        if (r0.hasNext() == false) goto L10;
        String r2 = r0.next();
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        r1 = r1 | SpacekitSdkWrapper.b(r2);
        if (r1 == false) goto L7;
    L10:
        if (r1 == false) goto L16;
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        SpacekitSdkWrapper.h(r5);
        return;
    }

    public void preloadDocFromFeed(List<String> r4) {
        ArrayList r0 = new ArrayList();
        Iterator<String> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add(av5.c.a(r5.next(), "from=docs_feed"));
        goto L4
    L6:
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        SpacekitSdkWrapper.h(r0);
    }

    public void preloadWikiTabPageData(Context r1) {
        WikiModuleProvider.a().getClass();
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).a();
    }

    public void registerPushSaveToNutStateListener(j5b.a r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        e r0 = new e(r4);
        sPushSaveToNutStateListenerMap.put(r4, r0);
        int r5 = com.ss.android.lark.integrator.ccm.a.a;
        new ConcurrentHashMap();
        acb.e r6 = acb.e.a.a;
        com.ss.android.lark.sdk.f.a(r6.a, r0, new acb.a(r6));
    }

    public void registerPushSaveToSpaceStateListener(final j5b.a r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Objects.requireNonNull(r4);
        g r0 = new cmb.c(r4);
        sPushSaveToSpaceStateListenerMap.put(r4, r0);
        int r5 = com.ss.android.lark.integrator.ccm.a.a;
        new l0();
        acb.e r6 = acb.e.a.a;
        com.ss.android.lark.sdk.f.a(r6.b, r0, new acb.d(r6));
    }

    public void removeListenerToDriveSaveStateEventPush(g r3) {
        if (r3 == null) goto L24;
        int r0 = com.ss.android.lark.integrator.ccm.a.a;
        new l0();
        if (r3 == null) goto L31;
        List r1 = acb.e.a.a.a;
        monitor-enter(r1);
        r1.remove(r3);     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        if (r1.isEmpty() == false) goto L29;
        monitor-enter(r1);
    L18:
        th = move-exception;
        throw th;
    L14:
        if (r1.isEmpty() == false) goto L16;
        com.ss.android.lark.sdk.g.e.a.c(Command.PUSH_SAVE_TO_NUT_STORE_STATE);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L18
        return;
    L29:
        return;
    L21:
        th = move-exception;
        throw th;
    L31:
        return;
    }

    public void setCCMConfig(String r2) {
        cmb.f.a().getClass();
        qa5.b.a.a.a.e().setCCMConfig(r2);
    }

    public void setIsAppInFront(boolean r2) {
        cmb.f.a().getClass();
        qa5.b.a.a.a.c().setIsAppInFront(r2);
    }

    public void setOnWebViewCreateListener(h0b.f r2) {
        cmb.f.a().getClass();
        if (SpacekitSdkWrapper.b.a == null) goto L6;
        com.bytedance.ee.bear.basesdk.apisupport.f r3 = qa5.b.a.a.a.b();
        com.bytedance.ee.bear.basesdk.apisupport.f r4 = r3;
        r4.h(new com.ss.android.lark.integrator.ccm.spacekit.i());
        return;
    }

    public void startWebScreenShot(i0b.d r1) {
        stopWebScreenShot();
        throw null;
    }

    public void startWriteBitmapToFastPNG(i0b.e r1) {
        stopWriteBitmapToFastPNG();
        throw null;
    }

    public void stopClip(WebView r2) {
        qa5.b.a.a.a.b().stopClip(r2);
    }

    public ibb.a syncPullDocFeedsByIds(List<String> r3) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        MGetDocFeedsRequest.Builder r4 = new MGetDocFeedsRequest.Builder().ids(r3);
        ibb.a r5 = (ibb.a) SdkSender.sendRequest(Command.MGET_DOC_FEEDS, r4, new com.ss.android.lark.integrator.ccm.spacekit.f());
        if (r5 != null) goto L6;
        Log.w("SpacekitSdkWrapper", "syncPullDocFeedsByIds() docFeedsResult is null");
        return new ibb.a(new HashMap(), new HashMap());
    L6:
        return new ibb.a(r5.a, r5.b);
    }

    public void timingCleanData(long r2) {
        cmb.f.a().getClass();
        qa5.b.a.a.a.e().timingCleanData(r2);
    }

    public void unRegisterPushSaveToNutStateListener(j5b.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Map<j5b.a, g> r0 = sPushSaveToNutStateListenerMap;
        g r1 = r0.get(r3);
        if (r1 == null) goto L24;
        r0.remove(r3);
        int r4 = com.ss.android.lark.integrator.ccm.a.a;
        new l0();
        List r5 = acb.e.a.a.a;
        monitor-enter(r5);
        r5.remove(r1);     // Catch: Throwable -> L21
        monitor-exit(r5);     // Catch: Throwable -> L21
        if (r5.isEmpty() == false) goto L29;
        monitor-enter(r5);
    L18:
        th = move-exception;
        throw th;
    L14:
        if (r5.isEmpty() == false) goto L16;
        com.ss.android.lark.sdk.g.e.a.c(Command.PUSH_SAVE_TO_NUT_STORE_STATE);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r5);     // Catch: Throwable -> L18
        return;
    L29:
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public void unRegisterPushSaveToSpaceStateListener(j5b.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        g r4 = sPushSaveToSpaceStateListenerMap.remove(r3);
        int r0 = com.ss.android.lark.integrator.ccm.a.a;
        new l0();
        if (r4 == null) goto L26;
        if (r4 == null) goto L33;
        List r1 = acb.e.a.a.b;
        monitor-enter(r1);
        CopyOnWriteArrayList r2 = (CopyOnWriteArrayList) r1;     // Catch: Throwable -> L23
        r2.remove(r4);     // Catch: Throwable -> L23
        monitor-exit(r1);     // Catch: Throwable -> L23
        if (r2.isEmpty() == false) goto L31;
        monitor-enter(r1);
    L20:
        th = move-exception;
        throw th;
    L16:
        if (r2.isEmpty() == false) goto L18;
        com.ss.android.lark.sdk.g.e.a.c(Command.PUSH_SAVE_TO_SPACE_STORE_STATE);     // Catch: Throwable -> L20
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L20
        return;
    L31:
        return;
    L23:
        th = move-exception;
        throw th;
    L33:
        return;
    }

    public void writeBitmapToFastPNG(i0b.f r1) {
        if (this.fastPngEncoder != null) goto L6;
        return;
    L6:
        throw null;
    }

    public int getDocInlineBlueIcon(DocType r2) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        return SpacekitSdkWrapper.d(r2);
    }

    public int getDocInlineGrayIcon(DocType r2) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        return SpacekitSdkWrapper.d(r2);
    }

    private static /* synthetic */ void lambda$showAdjustExternalPanel$0(ICCMApi.a r0, int r1) {
        r0.a();
    }

    public void clip(WebView r2, String r3) {
        qa5.b.a.a.a.b().clip(r2, r3);
    }

    public Flowable<DocPermission> fetchDocPermission(String r2, int r3) {
        wh5.d r0 = new wh5.d();
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        return r0.b(r2, r3);
    }

    public int getDocIcon(int r2, String r3) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r0 = SpacekitSdkWrapper.b.a;
        DocType r4 = DocType.forNumber(r2);
        r0.getClass();
        return DocModuleInner.a(r4, DocType.UNKNOWN_DOC_TYPE, r3);
    }

    public int getDocInlineIcon(DocType r1, int r2) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        return SpacekitSdkWrapper.d(r1);
    }

    public String getDocUrlWithFromQuery(String r3, String r4) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        HashMap r0 = new HashMap();
        r0.put("from", r4);
        if (r0.isEmpty() == false) goto L6;
        return r3;
    L6:
        return av5.c.b(r3, r0, true);
    }

    public String getDocUrlWithId(String r2, String r3) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        return SpacekitSdkWrapper.e(r2, r3);
    }

    public String getDocUrlWithParams(String r2, Map<String, String> r3) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        return av5.c.b(r2, r3, false);
    }

    public String getDocUrlWithQuerys(String r2, Map<String, String> r3) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        if (r3 != null) goto L5;
        return r2;
    L5:
        if (r3.isEmpty() == false) goto L8;
        return r2;
    L8:
        return av5.c.b(r2, r3, true);
    }

    public String getDocumentDefaultName(Context r2, int r3) {
        return qa5.b.a.a.a.b().getDocumentDefaultName(r2, r3);
    }

    public d5b.a getGroupCollaborationPlusPlugin(Context r1, Chat r2) {
        return new com.ss.android.lark.integrator.ccm.im.a(r2);
    }

    public d5b.a getSendKBPlugin(Context r5, Chat r6) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r0 = SpacekitSdkWrapper.b.a;
        r0.getClass();
        if (r6.isCrossTenant() == false) goto L6;
        return null;
    L6:
        return new xb5.d(r5, r6, null, new com.ss.android.lark.integrator.ccm.spacekit.g(r0));
    }

    public int getWikiIcon(int r2, String r3) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r0 = SpacekitSdkWrapper.b.a;
        DocType r4 = DocType.forNumber(r2);
        r0.getClass();
        return DocModuleInner.b(r4, r3);
    }

    public int getWikiSearchIcon(int r2, String r3) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r0 = SpacekitSdkWrapper.b.a;
        DocType r4 = DocType.forNumber(r2);
        r0.getClass();
        if (r4 != null) goto L6;
        return 2131256268;
    L6:
        switch(DocModuleInner.a.a[r4.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L7:
        int r5 = -1;
    L16:
        String r6 = va5.a.a(r3);
        if (r5 != sbb.e.l.b) goto L20;
        return ua5.a.h(com.bytedance.ee.util.io.a.c(r6));
    L20:
        return ua5.a.i(r5);
    L8:
        r5 = 22;
        goto L16
    L9:
        r5 = 44;
        goto L16
    L10:
        r5 = 30;
        goto L16
    L11:
        r5 = 12;
        goto L16
    L12:
        r5 = 11;
        goto L16
    L13:
        r5 = 8;
        goto L16
    L14:
        r5 = 3;
        goto L16
    L15:
        r5 = 2;
        goto L16
    }

    public void loadDocThumbnail(ImageView r3, i0b.a r4) {
        WeakReference r0 = new WeakReference(r3);
        ec5.a.a r1 = new ec5.a.a();
        r1.a = r3.getContext();
        r1.b = r4.a;
        r1.e = (ImageView) r0.get();
        r1.c = r4.b;
        r1.k = r4.g;
        r1.d = new a(r0);
        r1.j = "chat";
        r1.i = r4.c;
        r1.f = r4.d;
        r1.g = r4.e;
        r1.h = r4.f;
        cmb.f.a().getClass();
        SpacekitSdkWrapper r5 = SpacekitSdkWrapper.b.a;
        ec5.a r6 = new ec5.a(r1);
        r5.getClass();
        Log.i("SpacekitSdkWrapper", "DocsImpl.loadThumbnail ");
        RxScheduledExecutor.justInIO(new com.ss.android.lark.integrator.ccm.spacekit.e(r6));
    }

    public void onConfigurationChanged(String r3, Configuration r4) {
        cmb.f.a().getClass();
        com.ss.android.lark.integrator.ccm.spacekit.a r0 = com.ss.android.lark.integrator.ccm.spacekit.a.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r4, "newConfig");
        ExtensionActivityImpl r5 = (ExtensionActivityImpl) ((ConcurrentHashMap) r0.a).get(r3);
        if (r5 == null) goto L6;
        r5.d(r4);
        return;
    }

    public boolean open(String r2, Map<String, String> r3) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        return SpacekitSdkWrapper.g(r2, r3);
    }

    public void openFileReader(FileClickModel r4, String r5) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        FileClickData r0 = new FileClickData();
        r0.setFile_id(r4.getFile_id());
        r0.setDrive_file_key(r4.getDrive_file_key());
        r0.setFile_mime_type(r4.getFile_mime_type());
        r0.setFile_name(r4.getFile_name());
        r0.setFile_size(r4.getFile_size());
        r0.setMount_node_token(r4.getMount_node_token());
        r0.setMount_point(r4.getMount_point());
        r0.setDownLoadPath(r4.getDownLoadPath());
        r0.setType(r4.getType());
        String r6 = x.a;
        x.a.d(r5, r0);
    }

    public DocResult parseDocResultFromPb(String r17, Entity r18) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        if (r18 == null) goto L57;
        Map r4 = r18.message_id2doc_permission_infos;
        Map r5 = r18.docs;
        Entity.DocPermissionInfo r6 = (Entity.DocPermissionInfo) r4.get(r17);
        if (r6 != null) goto L8;
        return null;
    L8:
        if (r6.token2doc_permissions.size() != 1) goto L55;
        com.bytedance.lark.pb.basic.v1.DocPermission r7 = (com.bytedance.lark.pb.basic.v1.DocPermission) r6.token2doc_permissions.values().iterator().next();
        ThumbnailDetail r8 = yb5.d.a(r18, r17, r6.url2doc_permissions);     // Catch: Exception -> L12
    L14:
        String r9 = r7.key;
        if (TextUtils.isEmpty(r9) == false) goto L17;
    L45:
        tt5.a.h("ModelParserDoc", "docResult return null");
        return null;
    L17:
        if (r5.containsKey(r9) == false) goto L45;
        List r0 = r7.optional_permissions;
        DocCard r3 = new DocCard();
        r3.setMessageId(r17);
        r3.setDocId(r9);
        r3.setGroupId(r7.channel_id);
        r3.setShareInfo(r7.share_text);
        r3.setShouldRender(r7.should_render.booleanValue());
        int r1 = r7.user_perm.intValue();
        com.ss.android.lark.doc.entity.DocPermission r10 = new com.ss.android.lark.doc.entity.DocPermission();
        r10.setIsSet(true);
        r10.setPermCode(r1);
        r3.setUserPermission(r10);
        int r2 = r7.receiver_perm.intValue();
        com.ss.android.lark.doc.entity.DocPermission r11 = new com.ss.android.lark.doc.entity.DocPermission();
        r11.setIsSet(true);
        r11.setPermCode(r2);
        r3.setReceiverPermission(r11);
        r3.setSenderIsExternal(r7.sender_is_external);
        r3.setShareStatus(r7.share_status.longValue());
        ArrayList r12 = new ArrayList();
        if (r0 == null) goto L27;
        int r13 = r7.selected_permission_index.intValue();
        int r14 = r0.size();
        int r15 = 0;
    L21:
        if (r15 >= r14) goto L27;
        com.ss.android.lark.doc.entity.DocPermission r16 = new com.ss.android.lark.doc.entity.DocPermission();
        com.bytedance.lark.pb.basic.v1.DocPermission.Permission r19 = (com.bytedance.lark.pb.basic.v1.DocPermission.Permission) ListProtector.get(r0, r15);
        if (r15 != r13) goto L25;
        boolean r110 = true;
    L26:
        r16.setIsSet(r110);
        r16.setPermCode(r19.code.intValue());
        r16.setPermName(r19.name);
        r12.add(r16);
        r15 = r15 + 1;
        goto L21
    L25:
        r110 = false;
    L27:
        r3.setPermissions(r12);
        String r20 = r7.extra;
        tt5.a.h("ModelParserDoc", "extra = " + r20);
        if (r20 != null) goto L47;
    L33:
        Doc r21 = (Doc) r5.get(r9);
        com.ss.android.lark.doc.entity.Doc r22 = new com.ss.android.lark.doc.entity.Doc();
        if (r21 == null) goto L43;
        r22.setName(r21.name);
        r22.setAbstract(r21.abstract_);
        r22.setOwnerName(r21.owner_name);
        r22.setUrl(r21.url);
        r22.setId(r9);
        r22.setDocType(DocType.forNumber(r21.type.getValue()));
        Long r23 = r21.owner_id;
        if (r23 == null) goto L38;
        String r24 = r23.toString();
    L39:
        r22.setOwnerId(r24);
        r22.setCreateTime(r21.create_time.longValue());
        r22.setUpdateTime(r21.update_time.longValue());
        r22.setIconKey(r21.icon_key);
        r22.setThumbnaimDetail(r8);
        Icon r25 = new Icon();
        com.bytedance.lark.pb.basic.v1.Icon r26 = r21.icon;
        if (r26 == null) goto L42;
        r25.setType(r26.type.getValue());
        r25.setValue(r21.icon.value);
    L42:
        r22.setIcon(r25);
    L56:
        return new DocResult(r22, r3);
    L38:
        r24 = "";
        goto L39
    L43:
        tt5.a.d("ModelParserDoc", "docsMap.get(docId) pbDoc is null");
        goto L56
    L47:
        r3.setExtra((Extra) JSON.parseObject(r20, Extra.class));     // Catch: Exception -> L31
    L31:
        e = move-exception;
        tt5.a.e("ModelParserDoc", "JSON.parseObject(extraStr,Extra.class) fail", e, false);
    L12:
        e = move-exception;
        tt5.a.f("ModelParserDoc", e, false);
        r8 = null;
        goto L14
    L55:
        return null;
    L57:
        return null;
    }

    public void preloadDocFromChat(List<String> r4, int r5) {
        if (((PreloadDocConfig) com.bytedance.ee.bear.appsetting.c.a.a.d("preload_doc_chat_types", new PreloadDocConfig())).supportTypes.contains(Integer.valueOf(r5)) == false) goto L6;
        preloadDoc(r4);
        return;
    }

    public void preloadDocSdk(Context r1, int r2) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r3 = SpacekitSdkWrapper.b.a;
        if (r3 == null) goto L6;
        LarkContext.getApplication();
        r3.i(r2);
        return;
    }

    public void pullDocFeed(String r2, IGetDataCallback<DocFeed> r3) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.j(r2, r3);
    }

    public void saveToNutStore(String r3, pw4.e r4) {
        int r5 = com.ss.android.lark.integrator.ccm.a.a;
        l0 r6 = new l0();
        Object r0 = ((ConcurrentHashMap) r6.a).get(zbb.a.class);
        if (r0 != null) goto L12;
        monitor-enter(r6);
        if (r0 == null) goto L14;
    L7:
        monitor-exit(r6);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L14:
        r0 = new acb.f();     // Catch: Throwable -> L9
        ((ConcurrentHashMap) r6.a).put(zbb.a.class, r0);     // Catch: Throwable -> L9
    L12:
        ((zbb.a) r0).c();
    }

    public boolean startDriveSDKActivity(Context r1, qb5.a r2) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        Log.i("SpacekitSdkWrapper", "params invalid");
        return false;
    }

    public void syncThumbnail(final String r3, final IGetDataCallback<String> r4) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        Log.i("SpacekitSdkWrapper", "DocsImpl.syncThumbnail ");
        RxScheduledExecutor.justInIO(new com.ss.android.lark.integrator.ccm.spacekit.d(r3, r4));
    }

    public void updateLeaderShareSetting(boolean r2, IGetDataCallback<Boolean> r3) {
        SpacekitSdkWrapper.b.a.c();
        qa5.b.a.a.a.providePermissionProvider().updateLeaderShareSetting(r2, r3);
    }

    public int getDocIcon(DocType r2, String r3) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        return DocModuleInner.a(r2, DocType.UNKNOWN_DOC_TYPE, r3);
    }

    public int getWikiIcon(DocType r2, String r3) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        return DocModuleInner.b(r2, r3);
    }

    public boolean open(Context r1, i0b.b r2) {
        cmb.f.a().getClass();
        if (SpacekitSdkWrapper.b.a != null) goto L7;
        return false;
    L7:
        throw null;
    }

    public void createDocFeed(String r2, DocType r3, IGetDataCallback<ibb.a> r4) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        CreateDocFeedRequest.Builder r0 = new CreateDocFeedRequest.Builder();
        if (r3 != null) goto L5;
        Doc.Type r5 = Doc.Type.DOC;
    L6:
        CreateDocFeedRequest.Builder r6 = r0.type(r5).key(r2);
        SdkSender.asynSendRequestNonWrap(Command.CREATE_DOC_FEED, r6, r4, new p());
        return;
    L5:
        r5 = Doc.Type.fromValue(r3.getNumber());
        goto L6
    }

    public void doDocPermAuthBeforeChatP2pToGroup(Activity r2, Map<String, Map<String, DocResult>> r3, ICCMApi.b r4) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r5 = SpacekitSdkWrapper.b.a;
        c r0 = new c();
        r5.getClass();
        com.bytedance.ee.bear.lark.selector.auth.b.a(r2, r3, r0);
    }

    public String getCCMInnerFilePath(Context r2, Biz r3, String r4) {
        int r5 = ay4.c.a;
        return ay4.c.a.f(r3, r4, false, false, 12).getRealPath();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [cmb.a] */
    public void getQuickLaunchBarItemForWebContainer(final String r3, final Context r4, i0b.c r5) {
        SpacekitSdkWrapper.b.a.c();
        final NetService r6 = (NetService) org.koin.java.a.a(NetService.class);
        cmb.f.a().getClass();
        com.bytedance.ee.bear.basesdk.apisupport.f r0 = qa5.b.a.a.a.b();
        com.bytedance.ee.bear.basesdk.apisupport.f r1 = r0;
        r1.k(r6, r4, r3, new cmb.a(r6, r3, r4));
    }

    public d5b.a getSendKBPlugin(Context r4, Chat r5, Object r6) {
        if ((r6 instanceof com.ss.android.lark.keyboard.b) == false) goto L5;
        com.ss.android.lark.keyboard.b r7 = (com.ss.android.lark.keyboard.b) r6;
    L6:
        cmb.f.a().getClass();
        SpacekitSdkWrapper r0 = SpacekitSdkWrapper.b.a;
        r0.getClass();
        if (r5.isCrossTenant() == false) goto L10;
        return null;
    L10:
        return new xb5.d(r4, r5, r7, new com.ss.android.lark.integrator.ccm.spacekit.g(r0));
    L5:
        r7 = null;
        goto L6
    }

    public boolean open(String r2, String r3, Map<String, String> r4) {
        cmb.f.a().getClass();
        if (SpacekitSdkWrapper.b.a != null) goto L5;
        return false;
    L5:
        return SpacekitSdkWrapper.g(SpacekitSdkWrapper.e(r2, r3), r4);
    }

    public void openAINotes(Context r3, String r4, Fragment r5) {
        checkAndInit();
        RouteBean r0 = new RouteBean();
        r0.l = "/list/space/activity";
        if (r5 != null) goto L5;
    L7:
        ((h) org.koin.java.a.a(h.class)).yd("/list/space/activity", r0).j("extra_destination", NavigationEnum.AI_NOTE.id).i("extra_from", r4).e();
        return;
    L5:
        if (ku5.c.k(r3) == false) goto L7;
        r0.q = RouteBean.DestStyle.FULL_SCREEN;
        r0.a = 2130772285;
        r0.b = 2130772285;
        r0.a(r5);
        goto L7
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [cmb.b] */
    public void showAdjustExternalPanel(Activity r2, String r3, ICCMApi.a r4) {
        SpacekitSdkWrapper.b.a.c();
        ?? r5 = new cmb.b();
        qa5.b.a.a.a.providePermissionProvider().b(r2, r3, r5);
    }

    private static Unit lambda$getQuickLaunchBarItemForWebContainer$1(NetService r1, String r2, Context r3, e05.c r4) {
        cmb.f.a().getClass();
        qa5.b.a.a.a.b().d(r1, r2, r3, r4);
        return null;
    }

    public void createDocByTemplate(String r2, String r3, String r4, IGetDataCallback<String> r5) {
        f r0 = new f(r5);
        cmb.f.a().getClass();
        qa5.b.a.a.a.b().b(r2, r3, r4, r0);
    }

    public void doDocPermAuthBeforeChatP2pToGroupNew(Activity r1, List<DocResult> r2, Map<String, Map<String, DocResult>> r3, ICCMApi.b r4) {
        DocAuthSelectorDialog r5 = new DocAuthSelectorDialog();
        r5.e = r2;
        r5.d = new d(r3);
        r5.S90((FragmentActivity) r1);
    }

    public Map<String, String> getDocArgsMessage(boolean r3, boolean r4, boolean r5, String r6) {
        HashMap r7 = new HashMap();
        if (r3 == false) goto L5;
        String r8 = "meeting";
    L6:
        j0b.a.a(r7, "from", INotificationHitPoint.NoticeType.MESSAGE);
        j0b.a.a(r7, "chat_type", r8);
        if (r5 == false) goto L9;
        String r9 = "richtext";
    L10:
        j0b.a.a(r7, "message_type", r9);
        j0b.a.a(r7, "botId", r6);
        return r7;
    L9:
        r9 = "text";
        goto L10
    L5:
        r8 = INotificationHitPoint.ChatType.CHAT_TYPE_SINGLE;
        goto L6
    }

    public boolean open(Context r7, String r8, String r9, Map<String, String> r10) {
        return open(r7, r8, r9, r10, null);
    }

    public void saveToSpaceStore(pw4.e r1, String r2, String r3, String r4) {
        int r5 = com.ss.android.lark.integrator.ccm.a.a;
        l0 r6 = new l0();
        Object r7 = ((ConcurrentHashMap) r6.a).get(zbb.a.class);
        if (r7 != null) goto L12;
        monitor-enter(r6);
        if (r7 == null) goto L14;
    L7:
        monitor-exit(r6);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L14:
        r7 = new acb.f();     // Catch: Throwable -> L9
        ((ConcurrentHashMap) r6.a).put(zbb.a.class, r7);     // Catch: Throwable -> L9
    L12:
        ((zbb.a) r7).a();
    }

    private static void lambda$getQuickLaunchBarItemForWebContainer$2(i0b.c r4, NetService r5, String r6, Context r7, e05.c r8) {
        int r9 = cmb.d.a;
        Intrinsics.checkNotNullParameter(r7, "context");
        if (r8 == null) goto L17;
        new j2c.a.b();
        j2c.a.d.a r10 = new j2c.a.d.a();
        r10.a = kac.a.b(2131254550);
        r10.b = Integer.valueOf(UIUtils.getColor(r7, 2131102419));
        QuickLaunchBarItemType r11 = r8.getType();
        int r12 = cmb.d.a.C0015a.a[r11.ordinal()];
        if (r12 == 1) goto L14;
        if (r12 == 2) goto L14;
        if (r12 != 3) goto L12;
        j2c.a.c.a r13 = new j2c.a.c.a();
        cmb.e r14 = new cmb.e();
        r13.d = r14;
        Intrinsics.checkNotNullParameter(new j2c.a.e.a(new j2c.a.c(r13.a, r13.b, r13.c, r14)), "value");
        goto L14
    L12:
        throw new NoWhenBranchMatchedException();
    L14:
        if (r8.c == false) goto L16;
        j2c.a.a.a r15 = j2c.a.a.a.a;
    L16:
        Intrinsics.checkNotNullParameter(new j2c.a.d(r10.a, r10.b), "value");
    L17:
        r4.a();
    }

    public void goDocsSelector(Context r3, int r4, String r5, int r6, String r7) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        Bundle r0 = new Bundle();
        r0.putString("extra_title", r5);
        r0.putInt("extra_max_num", r6);
        r0.putString("extra_confirm_text", r7);
        com.bytedance.ee.bear.lark.selector.a.a((Activity) r3, r4, r0);
    }

    public boolean open(Context r8, String r9, String r10, Map<String, String> r11, Fragment r12) {
        return open(r8, r9, r10, r11, r12, "");
    }

    public boolean open(Context r7, String r8, String r9, Map<String, String> r10, Fragment r11, String r12) {
        cmb.f.a().getClass();
        if (SpacekitSdkWrapper.b.a == null) goto L7;
        String r13 = SpacekitSdkWrapper.e(r8, r9);
        if (SpacekitSdkWrapper.b(r13) == false) goto L7;
        String r2 = SpacekitSdkWrapper.a(r13);
        return qa5.b.a.a.a.b().i(r7, r2, r10, r11, r12);
    L7:
        return false;
    }

    public boolean open(Context r10, String r11, int r12, int r13, Map<String, String> r14, String r15) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        if (SpacekitSdkWrapper.b(r11) == false) goto L5;
        String r3 = SpacekitSdkWrapper.a(r11);
        return qa5.b.a.a.a.b().e(r10, r3, r12, r13, r14, null, r15);
    L5:
        return false;
    }

    public void goDocsSelector(Activity r3, Fragment r4, int r5, String r6, String r7, String r8, boolean r9) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.a.getClass();
        Bundle r0 = new Bundle();
        if (r6 == null) goto L5;
        r0.putString("chat_id", r6);
    L5:
        r0.putString("extra_title", r7);
        r0.putString("extra_confirm_text", r8);
        r0.putBoolean("extra_disable_new_doc", r9);
        if (r4 == null) goto L8;
        Intent r10 = new Intent(r3, DocSelectorActivity.class);
        r10.putExtras(r0);
        r4.startActivityForResult(r10, r5);
        return;
    L8:
        com.bytedance.ee.bear.lark.selector.a.a(r3, r5, r0);
    }
}
