package com.bytedance.android.livesdk.feed.context;

import com.bytedance.android.livehostapi.IBaseHostServiceForSaas;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.IHostCheckLive;
import com.bytedance.android.livehostapi.business.IHostDouyinIm;
import com.bytedance.android.livehostapi.business.IHostEmoji;
import com.bytedance.android.livehostapi.business.IHostFeed;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.IHostGameCpConfig;
import com.bytedance.android.livehostapi.business.IHostHSFunc;
import com.bytedance.android.livehostapi.business.IHostLiveAd;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import com.bytedance.android.livehostapi.business.IHostMiniApp;
import com.bytedance.android.livehostapi.business.IHostMiniAppCard;
import com.bytedance.android.livehostapi.business.IHostPad;
import com.bytedance.android.livehostapi.business.IHostProfile;
import com.bytedance.android.livehostapi.business.IHostRealNameAuthorization;
import com.bytedance.android.livehostapi.business.IHostSchemaHandler;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.android.livehostapi.business.IHostVerify;
import com.bytedance.android.livehostapi.business.IHostWMiniGameInitializer;
import com.bytedance.android.livehostapi.business.IHostWallet;
import com.bytedance.android.livehostapi.business.base.IBaseHostBusiness;
import com.bytedance.android.livehostapi.business.base.IBaseHostHSFunc;
import com.bytedance.android.livehostapi.business.base.IBaseHostLiveAd;
import com.bytedance.android.livehostapi.business.base.IBaseHostProfile;
import com.bytedance.android.livehostapi.business.base.IBaseHostShare;
import com.bytedance.android.livehostapi.business.base.IBaseHostVerify;
import com.bytedance.android.livehostapi.business.base.IBaseHostWallet;
import com.bytedance.android.livehostapi.business.base.IBaseLiveHostByteCast;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.foundation.IHostCommerceMonitor;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.IVideoContext;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostApp;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostContext;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostFrescoHelper;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostNetwork;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostPlugin;
import com.bytedance.android.livehostapi.foundation.player.IHostLivePlayerOptions;
import com.bytedance.android.livehostapi.platform.IHostAccountAuth;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livehostapi.platform.IHostCoinState;
import com.bytedance.android.livehostapi.platform.IHostConfig;
import com.bytedance.android.livehostapi.platform.IHostDouyinOpenSDKAuth;
import com.bytedance.android.livehostapi.platform.IHostLog;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import com.bytedance.android.livehostapi.platform.IHostPerformanceHelper;
import com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor;
import com.bytedance.android.livehostapi.platform.IHostSessionAuth;
import com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth;
import com.bytedance.android.livehostapi.platform.IHostUser;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostConfig;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostUser;
import com.bytedance.android.livehostapi.platform.base.IBaseHostAction;
import com.bytedance.android.livehostapi.platform.base.IBaseHostConfig;
import com.bytedance.android.livehostapi.platform.base.IBaseHostLog;
import com.bytedance.android.livehostapi.platform.base.IBaseHostMonitor;
import com.bytedance.android.livehostapi.platform.base.IBaseHostPerformanceMonitor;
import com.bytedance.android.livehostapi.platform.base.IBaseHostUser;
import com.bytedance.android.livehostapi.platform.base.IBaseHostWebView;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import ry.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FeedHostServiceWrapper implements IHostService {
    IHostService impl;

    public final /* synthetic */ IHostAccountAuth account() {
        return IBaseHostServiceForSaas.-CC.$default$account(this);
    }

    public final /* synthetic */ IHostCoinState coinState() {
        return IBaseHostServiceForSaas.-CC.$default$coinState(this);
    }

    public final /* synthetic */ IHostDouyinOpenSDKAuth douyinOpenSDKAuth() {
        return IBaseHostServiceForSaas.-CC.$default$douyinOpenSDKAuth(this);
    }

    public final /* synthetic */ IBaseLiveHostByteCast hostByteCast() {
        return IBaseHostServiceForSaas.-CC.$default$hostByteCast(this);
    }

    public final /* synthetic */ IHostDouyinIm hostDouyinIm() {
        return IBaseHostServiceForSaas.-CC.$default$hostDouyinIm(this);
    }

    public final /* synthetic */ IHostGameCpConfig hostGameCpConfig() {
        return IBaseHostServiceForSaas.-CC.$default$hostGameCpConfig(this);
    }

    public final /* synthetic */ IHostLivePlayerOptions hostLivePlayerOptions() {
        return IBaseHostServiceForSaas.-CC.$default$hostLivePlayerOptions(this);
    }

    public final /* synthetic */ IHostMiniApp hostMiniApp() {
        return IBaseHostServiceForSaas.-CC.$default$hostMiniApp(this);
    }

    public final /* synthetic */ IHostRealNameAuthorization hostRealNameAuthorization() {
        return IBaseHostServiceForSaas.-CC.$default$hostRealNameAuthorization(this);
    }

    public final /* synthetic */ IHostSchemaHandler hostSchemaHandler() {
        return IBaseHostServiceForSaas.-CC.$default$hostSchemaHandler(this);
    }

    public final /* synthetic */ IHostTokenInjectionAuth injectAccount() {
        return IBaseHostServiceForSaas.-CC.$default$injectAccount(this);
    }

    public final /* synthetic */ o methodChannel() {
        return IBaseHostServiceForSaas.-CC.$default$methodChannel(this);
    }

    public IHostNetwork network() {
        LocalTestManager.a(new Class[]{wy.a.class});
        return this.impl.network();
    }

    public final /* synthetic */ IHostSessionAuth sessionAuth() {
        return IBaseHostServiceForSaas.-CC.$default$sessionAuth(this);
    }

    public final /* synthetic */ IVideoContext videoContext() {
        return IBaseHostServiceForSaas.-CC.$default$videoContext(this);
    }

    public IHostWallet wallet() {
        LocalTestManager.a(new Class[]{wy.a.class});
        return this.impl.wallet();
    }

    public IHostAction action() {
        return this.impl.action();
    }

    public IHostContext appContext() {
        return this.impl.appContext();
    }

    public IHostConfig config() {
        return this.impl.config();
    }

    public IHostFrescoHelper frescoHelper() {
        return this.impl.frescoHelper();
    }

    public IHostApp hostApp() {
        return this.impl.hostApp();
    }

    public IHostBusiness hostBusiness() {
        return this.impl.hostBusiness();
    }

    public IHostCheckLive hostCheckLive() {
        return this.impl.hostCheckLive();
    }

    public IHostCommerceMonitor hostCommerceMonitor() {
        return this.impl.hostCommerceMonitor();
    }

    public IHostEmoji hostEmoji() {
        return this.impl.hostEmoji();
    }

    public IHostFeed hostFeed() {
        return this.impl.hostFeed();
    }

    public IHostGameCP hostGameCP() {
        return this.impl.hostGameCP();
    }

    public IHostLiveAd hostLiveAd() {
        return this.impl.hostLiveAd();
    }

    public IHostLiveLocalLife hostLiveLocalLife() {
        return this.impl.hostLiveLocalLife();
    }

    public IHostMiniAppCard hostMiniAppCard() {
        return this.impl.hostMiniAppCard();
    }

    public IHostLiveOpenPlatform hostOpenPlatform() {
        return this.impl.hostOpenPlatform();
    }

    public IHostPad hostPad() {
        return this.impl.hostPad();
    }

    public IHostPerformanceHelper hostPerformanceHelper() {
        return this.impl.hostPerformanceHelper();
    }

    public IHostPerformanceMonitor hostPerformanceMonitor() {
        return this.impl.hostPerformanceMonitor();
    }

    public IHostWMiniGameInitializer hostWMiniGameInitializer() {
        return this.impl.hostWMiniGameInitializer();
    }

    public IHostHSFunc hsHostFunc() {
        return this.impl.hsHostFunc();
    }

    public IHostLog log() {
        return this.impl.log();
    }

    public IHostMonitor monitor() {
        return this.impl.monitor();
    }

    public IHostPlugin plugin() {
        return this.impl.plugin();
    }

    public IHostProfile profile() {
        return this.impl.profile();
    }

    public IHostShare share() {
        return this.impl.share();
    }

    public IHostUser user() {
        return this.impl.user();
    }

    public IHostVerify verify() {
        return this.impl.verify();
    }

    public IHostWebView webView() {
        return this.impl.webView();
    }

    /* JADX INFO: renamed from: action, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IMiddlewareHostAction m1198action() {
        return action();
    }

    /* JADX INFO: renamed from: appContext, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IMiddleWareHostContext m1200appContext() {
        return appContext();
    }

    /* JADX INFO: renamed from: config, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IMiddlewareHostConfig m1202config() {
        return config();
    }

    /* JADX INFO: renamed from: frescoHelper, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IBaseHostFrescoHelper m1204frescoHelper() {
        return frescoHelper();
    }

    /* JADX INFO: renamed from: hostApp, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IBaseHostApp m1205hostApp() {
        return hostApp();
    }

    /* JADX INFO: renamed from: hostBusiness, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IBaseHostBusiness m1206hostBusiness() {
        return hostBusiness();
    }

    /* JADX INFO: renamed from: hostLiveAd, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IBaseHostLiveAd m1207hostLiveAd() {
        return hostLiveAd();
    }

    /* JADX INFO: renamed from: hostPerformanceMonitor, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IBaseHostPerformanceMonitor m1208hostPerformanceMonitor() {
        return hostPerformanceMonitor();
    }

    /* JADX INFO: renamed from: hsHostFunc, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IBaseHostHSFunc m1209hsHostFunc() {
        return hsHostFunc();
    }

    /* JADX INFO: renamed from: log, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IBaseHostLog m1210log() {
        return log();
    }

    /* JADX INFO: renamed from: monitor, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IBaseHostMonitor m1211monitor() {
        return monitor();
    }

    /* JADX INFO: renamed from: network, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IBaseHostNetwork m1212network() {
        return network();
    }

    /* JADX INFO: renamed from: plugin, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IBaseHostPlugin m1213plugin() {
        return plugin();
    }

    /* JADX INFO: renamed from: profile, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IBaseHostProfile m1214profile() {
        return profile();
    }

    /* JADX INFO: renamed from: share, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IBaseHostShare m1215share() {
        return share();
    }

    /* JADX INFO: renamed from: user, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IMiddlewareHostUser m1216user() {
        return user();
    }

    /* JADX INFO: renamed from: verify, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IBaseHostVerify m1218verify() {
        return verify();
    }

    /* JADX INFO: renamed from: wallet, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IBaseHostWallet m1219wallet() {
        return wallet();
    }

    /* JADX INFO: renamed from: webView, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IBaseHostWebView m1220webView() {
        return webView();
    }

    /* JADX INFO: renamed from: action, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IBaseHostAction m1199action() {
        return action();
    }

    /* JADX INFO: renamed from: appContext, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IBaseHostContext m1201appContext() {
        return appContext();
    }

    /* JADX INFO: renamed from: config, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IBaseHostConfig m1203config() {
        return config();
    }

    /* JADX INFO: renamed from: user, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IBaseHostUser m1217user() {
        return user();
    }

    public FeedHostServiceWrapper(IHostService r1) {
        this.impl = r1;
    }
}
