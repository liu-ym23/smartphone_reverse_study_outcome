package com.bytedance.forest.chain.fetchers;

import android.annotation.SuppressLint;
import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.FetcherType;
import com.bytedance.forest.model.ForestEnvData;
import com.bytedance.forest.model.ForestEnvType;
import com.bytedance.forest.model.GeckoSource;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.w;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.iesgurd.IESGurdResFrom;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.ui.image.f0;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00150\u00152\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0019\u0010\fJ\u001d\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJO\u0010)\u001a\u00020'2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001c2\u0006\u0010$\u001a\u00020#2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%H\u0007¢\u0006\u0004\b)\u0010*J\u001d\u0010+\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\"\u00104\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\n038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00109\u001a\u0004\b:\u0010;R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010<¨\u0006>"}, d2 = {"Lcom/bytedance/forest/chain/fetchers/GeckoXAdapter;", "", "Landroid/app/Application;", "app", "Lcom/bytedance/forest/Forest;", "forest", "<init>", "(Landroid/app/Application;Lcom/bytedance/forest/Forest;)V", "", "accessKey", "Lcom/bytedance/geckox/g;", "initGeckoXMultiClient", "(Ljava/lang/String;)Lcom/bytedance/geckox/g;", "Landroid/net/Uri;", LynxResourceModule.URI_KEY, "url", "Lcom/bytedance/forest/model/Request;", "request", "", "isGeckoCDNAndMergeConfig", "(Landroid/net/Uri;Ljava/lang/String;Lcom/bytedance/forest/model/Request;)Z", "", "getCustomParams$forest_release", "(Ljava/lang/String;)Ljava/util/Map;", "getCustomParams", "getNormalGeckoXClient$forest_release", "getNormalGeckoXClient", LynxMonitorService.KEY_CHANNEL, "", "getChannelVersion", "(Ljava/lang/String;Ljava/lang/String;)J", "Lcom/bytedance/forest/model/w;", "response", "bundle", "channelVersion", "Lcom/bytedance/forest/model/l;", "loaderConfig", "Lkotlin/Function1;", "Lcom/bytedance/iesgurd/d;", "", "callback", "getGeckoResourceData", "(Lcom/bytedance/forest/model/w;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/bytedance/forest/model/l;Lkotlin/jvm/functions/Function1;)V", "checkChannelExists", "(Ljava/lang/String;Ljava/lang/String;)Z", "Lcom/bytedance/forest/model/k;", "forestConfig", "Lcom/bytedance/forest/model/k;", "Ljava/io/File;", "appFileDir", "Ljava/io/File;", "Ljava/util/HashMap;", "geckoClients", "Ljava/util/HashMap;", "Lya/a;", "mStatisticMonitor", "Lya/a;", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "Lcom/bytedance/forest/Forest;", "Companion", "forest_release"}, k = 1, mv = {1, 4, 0})
public final class GeckoXAdapter {
    private static Map<String, String> CDNMultiVersionCommonParamsDelegate = null;
    public static final Companion Companion = null;
    private static final String DEFAULT_BUCKET_ID = "9";
    private static final String INVALID_BUCKET_ID = "-1";
    public static final String TAG = "GeckoXAdapter";
    private static final List<String> fallbackCDNMultiVersionDomains = null;
    private static String geckoBucketId;
    private final Application app;
    private File appFileDir;
    private final Forest forest;
    private final com.bytedance.forest.model.k forestConfig;
    private final HashMap<String, com.bytedance.geckox.g> geckoClients;
    private final ya.a mStatisticMonitor;

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0007J\u0014\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005J\u0012\u0010!\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0007R\u001f\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/forest/chain/fetchers/GeckoXAdapter$Companion;", "", "()V", "CDNMultiVersionCommonParams", "", "", "getCDNMultiVersionCommonParams", "()Ljava/util/Map;", "CDNMultiVersionCommonParamsDelegate", "DEFAULT_BUCKET_ID", "INVALID_BUCKET_ID", "TAG", "fallbackCDNMultiVersionDomains", "", "geckoBucketId", "addCommonParamsForCDNMultiVersionURL", "url", "addDefaultCDNMultiVersionDomains", "", "domains", "", "canParsed", "", LynxResourceModule.URI_KEY, "Landroid/net/Uri;", "dealWithBoeDomainIfNeed", "host", "getGeckoBucketId", "deviceId", "", "(Ljava/lang/Long;)Ljava/lang/String;", "getPrefixAsGeckoCDN", SVGRenderEngine.PATH, "isCDNMultiVersionResource", "forest_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Map access$getCDNMultiVersionCommonParamsDelegate$li(Companion r5) {
            return GeckoXAdapter.access$getCDNMultiVersionCommonParamsDelegate$cp();
        }

        public static final /* synthetic */ void access$setCDNMultiVersionCommonParamsDelegate$li(Companion r5, Map r10) {
            GeckoXAdapter.access$setCDNMultiVersionCommonParamsDelegate$cp(r10);
        }

        private final String dealWithBoeDomainIfNeed(String r5) {
            ForestEnvData r10 = Forest.Companion.getEnvData$forest_release();
            if (r10 == null) goto L5;
            ForestEnvType r11 = r10.getType();
        L7:
            if (r11 == ForestEnvType.BOE) goto L9;
        L12:
            return r5;
        L9:
            if (StringsKt.g(r5, ".boe-gateway.byted.org") == true) goto L12;
            return io.reactivex.internal.observers.h.b(r5, ".boe-gateway.byted.org");
        L5:
            r11 = null;
            goto L7
        }

        public static /* synthetic */ String getGeckoBucketId$default(Companion r5, Long r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = null;
        L6:
            return r5.getGeckoBucketId(r10);
        }

        @Keep
        public final String addCommonParamsForCDNMultiVersionURL(String r12) {
            if (isCDNMultiVersionResource(r12) == true) goto L6;
            f0.h(GeckoXAdapter.TAG, 60, r12 + " is not a cdn-multiple-version url", false);
            return r12;
        L6:
            Map<String, String> r5 = getCDNMultiVersionCommonParams();
            if (r5.isEmpty() == false) goto L43;
            f0.h(GeckoXAdapter.TAG, 60, "no cdn-multiple-version params need to add on " + r12, false);
        L43:
            Uri r10 = Uri.parse(r12);     // Catch: Throwable -> L16
            Uri.Builder r11 = r10.buildUpon();     // Catch: Throwable -> L16
            Iterator<Map.Entry<String, String>> r13 = r5.entrySet().iterator();     // Catch: Throwable -> L16
        L12:
            if (r13.hasNext() == false) goto L19;
            Map.Entry<String, String> r14 = r13.next();     // Catch: Throwable -> L16
            if (r10.getQueryParameter(r14.getKey()) == null) goto L15;
            f0.h(GeckoXAdapter.TAG, 60, "Parameter " + r14.getKey() + " of cdn-multiple-version already exists, value is:" + r14.getValue() + '.', false);     // Catch: Throwable -> L16
            goto L12
        L15:
            r11.appendQueryParameter(r14.getKey(), r14.getValue());     // Catch: Throwable -> L16
            goto L12
        L19:
            ForestEnvData r15 = Forest.Companion.getEnvData$forest_release();     // Catch: Throwable -> L16
            if (r15 != null) goto L22;
        L32:
            String r16 = r10.getHost();     // Catch: Throwable -> L16
            if (r16 != null) goto L35;
            Intrinsics.throwNpe();     // Catch: Throwable -> L16
        L35:
            String r17 = dealWithBoeDomainIfNeed(r16);     // Catch: Throwable -> L16
            if (Intrinsics.areEqual(r17, r16) == false) goto L40;
            return StringsKt.F(r11.build().toString(), r16, r17);
        L40:
            return r11.build().toString();
        L22:
            if (r15.getType() != ForestEnvType.PPE) goto L24;
            String r18 = "x-use-ppe";
        L25:
            Iterator r19 = MapsKt.mapOf(new Pair[]{TuplesKt.to(r18, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST), TuplesKt.to("x-tt-env", r15.getName())}).entrySet().iterator();     // Catch: Throwable -> L16
        L27:
            if (r19.hasNext() == false) goto L32;
            Map.Entry r20 = (Map.Entry) r19.next();     // Catch: Throwable -> L16
            if (r10.getQueryParameter((String) r20.getKey()) == null) goto L30;
            f0.h(GeckoXAdapter.TAG, 60, "Parameter " + ((String) r20.getKey()) + " of cdn-multiple-version already exists for " + r12 + ", except:" + ((String) r20.getValue()) + ", current:" + r10.getQueryParameter((String) r20.getKey()) + '.', false);     // Catch: Throwable -> L16
            goto L27
        L30:
            r11.appendQueryParameter((String) r20.getKey(), (String) r20.getValue());     // Catch: Throwable -> L16
            goto L27
        L24:
            r18 = "x-use-boe";
        L16:
            th = move-exception;
            StringBuilder r21 = com.lynx.tasm.utils.e.b("build cdn-multiple-version for ", r12, " failed, error: ");
            r21.append(th.getMessage());
            f0.n(4, GeckoXAdapter.TAG, r21.toString());
            return r12;
        }

        public final void addDefaultCDNMultiVersionDomains(List<String> r5) {
            GeckoXAdapter.access$getFallbackCDNMultiVersionDomains$cp().addAll(r5);
        }

        public final boolean canParsed(Uri r5) {
            if (Intrinsics.areEqual(r5.getScheme(), "http") == false) goto L5;
        L8:
            GlobalConfigSettings r10 = df.c.f16652i.d();
            String r11 = null;
            if (r10 == null) goto L11;
            GlobalConfigSettings.ResourceMeta r12 = r10.getResourceMeta();
        L13:
            if (r12 != null) goto L16;
            f0.n(5, null, "could not get any valid resource meta");
            return false;
        L16:
            String r13 = r5.getPath();
            if (r13 != null) goto L20;
            r13 = "";
        L20:
            String r14 = getPrefixAsGeckoCDN(r13);
            if (r14.length() != 0) goto L23;
            return false;
        L23:
            GlobalConfigSettings.CurrentLevelConfig r15 = r12.getConfig();
            if (r15 != null) goto L27;
            f0.n(5, null, "could not get any valid config");
            return false;
        L27:
            Map<String, String> r16 = r15.getPrefix2AccessKey();
            if (r16 == null) goto L31;
            r11 = r16.get(r14);
        L31:
            return com.lynx.tasm.behavior.utils.d.g(r11);
        L11:
            r12 = null;
            goto L13
        L5:
            if (Intrinsics.areEqual(r5.getScheme(), IIvyAIPackageResourceService.SCHEMA) == true) goto L8;
            return false;
        }

        public final Map<String, String> getCDNMultiVersionCommonParams() {
            Companion r10 = GeckoXAdapter.Companion;
            if (access$getCDNMultiVersionCommonParamsDelegate$li(r10) == null) goto L8;
            Map<String, String> r11 = GeckoXAdapter.access$getCDNMultiVersionCommonParamsDelegate$cp();
            if (r11 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("CDNMultiVersionCommonParamsDelegate");
        L7:
            return r11;
        L8:
            df.c r5 = df.c.f16652i;
            r5.a();
            if (df.c.f == null) goto L23;
            r5.a();
            GeckoGlobalConfig r12 = df.c.f;
            if (r12 == null) goto L13;
            String r13 = r12.getAppVersion();
        L14:
            Pair r14 = TuplesKt.to("version_name", r13);
            Pair r15 = TuplesKt.to("device_platform", "android");
            Pair r16 = TuplesKt.to("os", "android");
            r5.a();
            GeckoGlobalConfig r17 = df.c.f;
            if (r17 == null) goto L17;
            String r18 = String.valueOf(r17.getAppId());
        L18:
            GeckoXAdapter.access$setCDNMultiVersionCommonParamsDelegate$cp(MapsKt.mapOf(new Pair[]{r14, r15, r16, TuplesKt.to(WsConstants.KEY_APP_ID, r18), TuplesKt.to("gecko_bkt", getGeckoBucketId$default(r10, null, 1, null))}));
            Map<String, String> r19 = GeckoXAdapter.access$getCDNMultiVersionCommonParamsDelegate$cp();
            if (r19 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("CDNMultiVersionCommonParamsDelegate");
        L21:
            return r19;
        L17:
            r18 = null;
            goto L18
        L13:
            r13 = null;
            goto L14
        L23:
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("version_name", ""), TuplesKt.to("device_platform", "android"), TuplesKt.to("os", "android"), TuplesKt.to(WsConstants.KEY_APP_ID, ""), TuplesKt.to("gecko_bkt", GeckoXAdapter.DEFAULT_BUCKET_ID)});
        }

        public final String getGeckoBucketId(Long r5) {
            if (Intrinsics.areEqual(GeckoXAdapter.access$getGeckoBucketId$cp(), GeckoXAdapter.INVALID_BUCKET_ID) == false) goto L5;
            if (r5 != null) goto L14;
            df.c.f16652i.a();
            GeckoGlobalConfig r10 = df.c.f;
            if (r10 == null) goto L13;
            String r11 = r10.getDeviceId();
            if (r11 == null) goto L13;
            r5 = StringsKt.toLongOrNull(r11);
        L13:
            r5 = null;
        L14:
            if (r5 == null) goto L33;
            int r12 = (int) (r5.longValue() % ((long) 100));
            if (r12 != 0) goto L19;
            String r13 = "s01";
        L31:
            GeckoXAdapter.access$setGeckoBucketId$cp(r13);
            return GeckoXAdapter.access$getGeckoBucketId$cp();
        L19:
            if (1 > r12) goto L25;
            if (4 < r12) goto L25;
            r13 = "s05";
        L25:
            if (5 <= r12) goto L28;
        L30:
            r13 = String.valueOf(r12 / 10);
            goto L31
        L28:
            if (9 < r12) goto L30;
            r13 = "0";
            goto L31
        L33:
            return GeckoXAdapter.DEFAULT_BUCKET_ID;
        L5:
            return GeckoXAdapter.access$getGeckoBucketId$cp();
        }

        public final String getPrefixAsGeckoCDN(String r5) {
            List r10 = StringsKt.K(r5, new String[]{"/"}, 0, 6);
            if (r10.isEmpty() == false) goto L5;
            return "";
        L5:
            if (r10.size() >= 6) goto L8;
            return "";
        L8:
            return "/" + ((String) r10.get(1)) + '/' + ((String) r10.get(2)) + '/' + ((String) r10.get(3)) + '/' + ((String) r10.get(4)) + '/' + ((String) r10.get(5));
        }

        @SuppressLint({"[ByDesign4.2]BadDomainNameVerifier"})
        public final boolean isCDNMultiVersionResource(String r5) {
            if (r5 != null) goto L5;
            return false;
        L5:
            if (StringsKt.isBlank(r5) == true) goto L38;
            GlobalConfigSettings r10 = df.c.f16652i.d();
            Object r11 = null;
            if (r10 == null) goto L12;
            GlobalConfigSettings.ResourceMeta r12 = r10.getResourceMeta();
            if (r12 == null) goto L12;
            GlobalConfigSettings.CurrentLevelConfig r13 = r12.getConfig();
        L13:
            if (r13 == null) goto L19;
            GlobalConfigSettings.CDNMultiVersion r14 = r13.getCDNMultiVersion();
            if (r14 == null) goto L19;
            List<String> r15 = r14.getDomains();
            if (r15 == null) goto L19;
        L21:
            if (r15.isEmpty() == true) goto L23;
            Iterator<T> r16 = r15.iterator();
        L26:
            if (r16.hasNext() == false) goto L30;
            Object r17 = r16.next();
            if (StringsKt.g(r5, (String) r17) == false) goto L26;
            r11 = r17;
        L30:
            if (r11 == null) goto L37;
            return true;
        L37:
            return false;
        L23:
            return StringsKt.g(r5, "gr-sourcecdn.bytegecko.com");
        L19:
            r15 = GeckoXAdapter.access$getFallbackCDNMultiVersionDomains$cp();
        L12:
            r13 = null;
            goto L13
        L38:
            return false;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final boolean canParsed(String r5) {
            if (r5.length() != 0) goto L17;
            return false;
        L17:
            Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
            Object r11 = Result.m124constructorimpl(Uri.parse(r5));     // Catch: Throwable -> L7
        L10:
            if (Result.m130isFailureimpl(r11) == false) goto L12;
            r11 = null;
        L12:
            Uri r12 = (Uri) r11;
            if (r12 != null) goto L15;
            return false;
        L15:
            return canParsed(r12);
        L7:
            th = move-exception;
            Result.Companion r13 = Result.Companion;
            r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
            goto L10
        }
    }

    static {
        Companion = new Companion(null);
        fallbackCDNMultiVersionDomains = new ArrayList();
        geckoBucketId = INVALID_BUCKET_ID;
    }

    public GeckoXAdapter(Application r5, Forest r10) {
        this.app = r5;
        this.forest = r10;
        this.forestConfig = r10.getConfig();
        this.geckoClients = new HashMap();
        this.mStatisticMonitor = i.f4298a;
    }

    public static final /* synthetic */ Map access$getCDNMultiVersionCommonParamsDelegate$cp() {
        return CDNMultiVersionCommonParamsDelegate;
    }

    public static final /* synthetic */ List access$getFallbackCDNMultiVersionDomains$cp() {
        return fallbackCDNMultiVersionDomains;
    }

    public static final /* synthetic */ String access$getGeckoBucketId$cp() {
        return geckoBucketId;
    }

    public static final /* synthetic */ void access$setCDNMultiVersionCommonParamsDelegate$cp(Map r5) {
        CDNMultiVersionCommonParamsDelegate = r5;
    }

    public static final /* synthetic */ void access$setGeckoBucketId$cp(String r5) {
        geckoBucketId = r5;
    }

    public static /* synthetic */ void getGeckoResourceData$default(GeckoXAdapter r10, w r11, String r12, String r13, Long r14, com.bytedance.forest.model.l r15, Function1 r16, int r17, Object r18) {
        if ((r17 & 8) == 0) goto L5;
        r14 = null;
    L5:
        r10.getGeckoResourceData(r11, r12, r13, r14, r15, r16);
    }

    private final com.bytedance.geckox.g initGeckoXMultiClient(String r10) {
        com.bytedance.geckox.g r5 = com.bytedance.geckox.h.a(r10);
        if (r5 == null) goto L5;
        return r5;
    L5:
        com.bytedance.forest.model.l r11 = this.forestConfig.a(r10);
        if (r11 == null) goto L12;
        String r12 = r11.f;
        File r13 = r11.a(this.app);
        com.bytedance.geckox.i r14 = new com.bytedance.geckox.i(this.app).c(this.forestConfig.f4381h).a(r11.d);     // Catch: Exception -> L10
        r14.getClass();     // Catch: Exception -> L10
        r14.f4752a = Arrays.asList(new String[]{r10});     // Catch: Exception -> L10
        com.bytedance.geckox.i r15 = r14.b(r12);     // Catch: Exception -> L10
        r15.f4753b = r13;     // Catch: Exception -> L10
        return com.bytedance.geckox.g.a(new com.bytedance.geckox.j(r15));
    L10:
        e = move-exception;
        f0.i(TAG, "GeckoClient.create error", e);
    L12:
        return null;
    }

    public final boolean checkChannelExists(String r5, String r10) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L26:
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L26;
        ConcurrentHashMap r11 = com.bytedance.iesgurd.a.f6593a;
        if (r5.length() != 0) goto L11;
    L21:
        long r12 = 0;
    L23:
        if (r12 <= 0) goto L26;
        return true;
    L11:
        if (r10.length() == 0) goto L21;
        ChannelMeta r13 = com.bytedance.iesgurd.meta.e.a(r5, r10);
        if (r13 == null) goto L21;
        if (r13.getForbidden() == true) goto L21;
        Long r14 = com.bytedance.iesgurd.meta.e.c(r5, r10, r13, "");
        if (r14 == null) goto L21;
        r12 = r14.longValue();
        goto L23
    }

    public final Application getApp() {
        return this.app;
    }

    public final long getChannelVersion(String r5, String r10) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L22:
        return 0;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L22;
        ConcurrentHashMap r11 = com.bytedance.iesgurd.a.f6593a;
        if (r5.length() != 0) goto L11;
    L12:
        return 0;
    L11:
        if (r10.length() == 0) goto L12;
        ChannelMeta r12 = com.bytedance.iesgurd.meta.e.a(r5, r10);
        if (r12 == null) goto L22;
        if (r12.getForbidden() == false) goto L18;
        return 0;
    L18:
        Long r13 = com.bytedance.iesgurd.meta.e.c(r5, r10, r12, "");
        if (r13 == null) goto L22;
        return r13.longValue();
    }

    public final Map<String, Map<String, String>> getCustomParams$forest_release(String r5) {
        LinkedHashMap r10 = new LinkedHashMap();
        if (r5 == null) goto L5;
        String r11 = r5;
    L6:
        LinkedHashMap r12 = new LinkedHashMap();
        com.bytedance.forest.model.l r13 = this.forestConfig.a(r5);
        if (r13 == null) goto L9;
        String r14 = (String) r12.put("business_version", r13.e);
    L9:
        r10.put(r11, r12);
        return r10;
    L5:
        r11 = "";
        goto L6
    }

    @JvmOverloads
    public final void getGeckoResourceData(w r10, String r11, String r12, com.bytedance.forest.model.l r13, Function1<? super com.bytedance.iesgurd.d, Unit> r14) {
        getGeckoResourceData$default(this, r10, r11, r12, null, r13, r14, 8, null);
    }

    public final com.bytedance.geckox.g getNormalGeckoXClient$forest_release(String r5) {
        com.bytedance.geckox.g r10 = this.geckoClients.get(r5);
        if (r10 != null) goto L6;
        com.bytedance.geckox.g r11 = initGeckoXMultiClient(r5);
        this.geckoClients.put(r5, r11);
        return r11;
    L6:
        return r10;
    }

    public final boolean isGeckoCDNAndMergeConfig(Uri r10, String r11, Request r12) {
        GlobalConfigSettings r13 = df.c.f16652i.d();
        GlobalConfigSettings.CDNFallBackConfig r5 = null;
        if (r13 == null) goto L5;
        GlobalConfigSettings.ResourceMeta r14 = r13.getResourceMeta();
    L6:
        boolean r15 = false;
        if (r14 != null) goto L10;
        f0.n(5, null, "could not get any valid resource meta");
        return false;
    L10:
        Companion r16 = Companion;
        String r17 = r10.getPath();
        if (r17 != null) goto L14;
        r17 = "";
    L14:
        String r18 = r16.getPrefixAsGeckoCDN(r17);
        GlobalConfigSettings.CurrentLevelConfig r19 = r14.getConfig();
        if (r19 != null) goto L18;
        f0.n(5, null, "could not get any valid config");
        return false;
    L18:
        Map<String, String> r20 = r19.getPrefix2AccessKey();
        if (r20 == null) goto L21;
        String r21 = r20.get(r18);
    L22:
        if (r21 != null) goto L24;
    L103:
        f0.n(5, null, "could not get any valid access key from remote settings");
        return false;
    L24:
        if (r21.length() == 0) goto L103;
        com.bytedance.forest.model.m r22 = r12.getGeckoModel();
        r22.getClass();
        r22.f4389a = r21;
        GlobalConfigSettings.AccessKeyMetaInfo r23 = r14.getAccessKeys().get(r21);
        if (r23 == null) goto L29;
        GlobalConfigSettings.CurrentLevelConfig r24 = r23.getConfig();
    L30:
        com.bytedance.forest.model.m r25 = com.lynx.tasm.utils.a.c(r11, r18);
        if (r25 != null) goto L33;
    L35:
        GlobalConfigSettings.AccessKeyMetaInfo r26 = r14.getAccessKeys().get(r21);
        if (r26 == null) goto L42;
        Map<String, GlobalConfigSettings.ChannelMetaInfo> r27 = r26.getChannels();
        if (r27 == null) goto L42;
        GlobalConfigSettings.ChannelMetaInfo r28 = r27.get(r12.getGeckoModel().f4390b);
        if (r28 == null) goto L42;
        GlobalConfigSettings.CurrentLevelConfig r29 = r28.getConfig();
    L43:
        if (r29 == null) goto L47;
        List<GlobalConfigSettings.PipelineStep> r30 = r29.getPipeline();
        if (r30 == null) goto L47;
    L50:
        if (r30 != null) goto L54;
        r30 = r19.getPipeline();
    L54:
        if (r30 != null) goto L56;
    L82:
        if (r29 == null) goto L86;
        GlobalConfigSettings.CDNFallBackConfig r31 = r29.getCdnFallback();
        if (r31 == null) goto L86;
        r5 = r31;
    L88:
        if (r5 != null) goto L91;
        r5 = r19.getCdnFallback();
    L91:
        if (r5 != null) goto L93;
    L102:
        return true;
    L93:
        if (r5.getDomains() == null) goto L102;
        List<String> r32 = r5.getDomains();
        Iterator<String> r33 = r32.iterator();
    L96:
        if (r33.hasNext() == false) goto L98;
        r12.getRemainedFallbackDomains$forest_release().add(r33.next());
        goto L96
    L98:
        r12.setFallbackDomains(r32);
        r12.setLoadRetryTimes(RangesKt.coerceAtLeast(r5.getMaxAttempts(), 1) - 1);
        if (r5.getShuffle() != 1) goto L101;
        r15 = true;
    L101:
        r12.setSupportShuffle(r15);
    L86:
        if (r24 == null) goto L88;
        r5 = r24.getCdnFallback();
        goto L88
    L56:
        if (r30.isEmpty() == true) goto L82;
        List<FetcherType> r34 = r12.getFetcherSequence();
        r34.clear();
        Iterator<GlobalConfigSettings.PipelineStep> r35 = r30.iterator();
    L59:
        if (r35.hasNext() == false) goto L82;
        GlobalConfigSettings.PipelineStep r36 = r35.next();
        if (r36 == null) goto L59;
        int r37 = r36.getType();
        if (r37 != 1) goto L65;
        r34.add(FetcherType.f4312a);
        int r38 = r36.getUpdate();
        if (r38 == 1) goto L80;
        if (r38 == 2) goto L80;
        boolean r39 = false;
    L81:
        r12.setWaitGeckoUpdate(r39);
    L80:
        r39 = true;
        goto L81
    L65:
        if (r37 != 2) goto L67;
        r34.add(FetcherType.f4314c);
        if (r36.getNoCache() == 1) goto L73;
        boolean r40 = true;
    L74:
        r12.setEnableCDNCache(r40);
        goto L59
    L73:
        r40 = false;
        goto L74
    L67:
        if (r37 != 3) goto L59;
        r34.add(FetcherType.f4313b);
    L47:
        if (r24 == null) goto L49;
        r30 = r24.getPipeline();
        goto L50
    L49:
        r30 = null;
    L42:
        r29 = null;
        goto L43
    L33:
        if (r25.a() == true) goto L35;
        r12.setGeckoSource(GeckoSource.f4321a);
        com.bytedance.forest.model.m r110 = r12.getGeckoModel();
        String r41 = r25.f4390b;
        r110.getClass();
        r110.f4390b = r41;
        com.bytedance.forest.model.m r111 = r12.getGeckoModel();
        String r42 = r25.f4391c;
        r111.getClass();
        r111.f4391c = r42;
        goto L35
    L29:
        r24 = null;
        goto L30
    L21:
        r21 = null;
        goto L22
    L5:
        r14 = null;
        goto L6
    }

    @JvmOverloads
    public final void getGeckoResourceData(w r20, String r21, String r22, Long r23, com.bytedance.forest.model.l r24, Function1<? super com.bytedance.iesgurd.d, Unit> r25) {
        String r5 = r24.f4386b;
        if (r5.length() != 0) goto L6;
    L10:
        r25.invoke(new com.bytedance.iesgurd.d(new com.bytedance.iesgurd.e(Integer.MIN_VALUE, "ak/channel/bundle is empty"), IESGurdResFrom.f6587a, 0, null, 28));
        return;
    L6:
        if (r21.length() == 0) goto L10;
        if (r22.length() == 0) goto L10;
        File r10 = r24.a(this.app);
        Request r11 = r20.f4441q;
        String r12 = r11.getSessionId();
        if (r12 != null) goto L15;
    L50:
        String r13 = r24.f4386b;
        String r14 = r10.getAbsolutePath();
        com.bytedance.iesgurd.f r15 = new com.bytedance.iesgurd.f(r13, r21, r22, false, r14);
        if (r11.getLoadToMemory() == true) goto L53;
    L61:
        ConcurrentHashMap r16 = com.bytedance.iesgurd.a.f6593a;
        com.bytedance.iesgurd.f r17 = new com.bytedance.iesgurd.f(r13, r21, r22, true, r14);
        com.bytedance.iesgurd.loader.a r18 = new com.bytedance.iesgurd.loader.a(r17, r25);
        GeckoLogger.a("getPath: " + r17);
        if (r18.f6634a.length() != 0) goto L65;
    L69:
        com.bytedance.iesgurd.d r19 = new com.bytedance.iesgurd.d(new com.bytedance.iesgurd.e(-1, "invalid params: Forest-" + r18.f6634a + '-' + r18.f6635b + '-' + r18.f6636c), null, 0, null, 30);
    L73:
        com.bytedance.iesgurd.e r26 = r19.f6616a;
        if (r26 != null) goto L76;
    L77:
        r18.f("getPath", r19);
    L78:
        r18.d(r19);
        return;
    L76:
        if (r26.f6619a == (-1)) goto L78;
    L65:
        if (r18.f6635b.length() == 0) goto L69;
        if (r18.f6636c.length() == 0) goto L69;
        r19 = r18.a(false);
        com.bytedance.iesgurd.e r27 = r19.f6616a;
        if (r27 == null) goto L73;
        r27.f6621c = 1;
        r27.d = "only offline";
        goto L73
    L53:
        if (r11.getNeedLocalFile() == true) goto L61;
        if (r11.getOnlyLocal() == true) goto L61;
        if (r11.getDisableCdn() == true) goto L61;
        ConcurrentHashMap r28 = com.bytedance.iesgurd.a.f6593a;
        new com.bytedance.iesgurd.loader.a(r15, r25).b();
        return;
    L15:
        if (r12.length() == 0) goto L50;
        com.bytedance.forest.d r29 = this.forest.getSessionManager$forest_release();
        r29.getClass();
        Pair r30 = TuplesKt.to(r12, r5);
        LinkedHashMap r31 = r29.f4302a;
        monitor-enter(r31);
        LinkedHashMap r110 = r29.f4302a;     // Catch: Throwable -> L47
        qa.b r111 = (qa.b) r110.get(r30);     // Catch: Throwable -> L47
        if (r111 == null) goto L23;
        monitor-exit(r31);
    L84:
        String r112 = r111.a(r21 + File.separator + r22);     // Catch: Throwable -> L34
        if (r112 == null) goto L39;
        IESGurdResFrom r113 = IESGurdResFrom.f6588b;     // Catch: Throwable -> L34
        if (r23 == null) goto L30;
        Long r32 = r23;
    L31:
        if (r32 == null) goto L36;
        long r33 = r32.longValue();     // Catch: Throwable -> L34
    L37:
        com.bytedance.iesgurd.d r34 = new com.bytedance.iesgurd.d(null, r113, r33, r112, 17);     // Catch: Throwable -> L34
    L42:
        r111.b();
        r25.invoke(r34);
        return;
    L36:
        r33 = 0;
        goto L37
    L30:
        r32 = r111.c(r21);     // Catch: Throwable -> L34
        goto L31
    L39:
        throw new IllegalStateException("can not get file path from gecko");     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        f0.i(TAG, "get file data for " + r5 + '/' + r21 + '/' + r22 + " from gecko failed", th);     // Catch: Throwable -> L44
        r34 = new com.bytedance.iesgurd.d(new com.bytedance.iesgurd.e(Integer.MIN_VALUE, th.getMessage()), IESGurdResFrom.f6587a, 0, null, 28);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        r111.b();
        throw th;
    L23:
        r111 = new qa.b(r29.f4303b, r5, r10);     // Catch: Throwable -> L47
        r110.put(r30, r111);     // Catch: Throwable -> L47
        monitor-exit(r31);
    L47:
        th = move-exception;
        throw th;
    }
}
