package com.bytedance.android.live.pushstream.mock;

import ca0.j;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.beauty.filter.LiveComposerFilterHelper;
import com.bytedance.android.live.effect.composer.n;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.core.util.h;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.config.hd;
import com.bytedance.android.livesdk.config.id;
import com.bytedance.android.livesdk.config.jd;
import com.bytedance.android.livesdk.config.rb;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.o;
import com.bytedance.android.livesdkapi.api.IUtilsCommonService;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.android.ugc.aweme.debug.tag.global.open.AutomatedTestTag;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import zg1.c2;
import zg1.y1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/pushstream/mock/LiveAnchorPushStreamMockManager;", "", "<init>", "()V", "Companion", "livepushstream-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAnchorPushStreamMockManager {
    public static final Map<String, String> a = null;
    public static final Map<String, String> b = null;
    public static final Map<Long, h1> c = null;
    public static final Companion d = null;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b'\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bP\u0010QJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0007J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0007J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006H\u0007J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0007J(\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007J\b\u0010\u0019\u001a\u00020\u0004H\u0007J\b\u0010\u001a\u001a\u00020\u0004H\u0007J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0006H\u0007J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0007J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0006H\u0007J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0007J\u001a\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\"0!H\u0007J\u001a\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\"0!H\u0007J\b\u0010%\u001a\u00020\u0002H\u0007J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0007J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0007J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006H\u0007J\u0010\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0006H\u0007J\u0018\u0010,\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0007J \u0010.\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0007J(\u0010.\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H\u0007J\u0018\u00100\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0007J\u0018\u00101\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0007J\u0018\u00102\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0007J\u0018\u00103\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0007J\u0010\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u0006H\u0007J\u0010\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0006H\u0007J\u0010\u00108\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0006H\u0007J\u0010\u00109\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0006H\u0007J\u001a\u0010<\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00062\b\b\u0002\u0010;\u001a\u00020\u0002H\u0007J\u0018\u0010=\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u0010\u0010>\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010?\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010A\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0006H\u0007J\u0018\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u0006H\u0007J\b\u0010D\u001a\u00020\u0004H\u0007R\u0014\u0010E\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010G\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\bG\u0010FR\u0014\u0010H\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\bH\u0010FR\u0014\u0010I\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bI\u0010FR \u0010L\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020K0J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR \u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010MR \u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010M¨\u0006R"}, d2 = {"Lcom/bytedance/android/live/pushstream/mock/LiveAnchorPushStreamMockManager$Companion;", "", "", "enable", "", "enableVideoMockPushStream", "", "path", "setMockVideoPath", "", "width", "height", "setMockVideoSize", "", "startDelayTime", "sampleMarginTime", "setPreviewMockConfig", "effectID", "getInteractEffectInfo", "checkInteractEffectInfo", "messageType", "arg1", "arg2", "arg3", "sendEffectMessage", "openLiveEffectPanel", "openLiveBeautyPanel", "panel", "switchPanelOn", "renderEffect", "clearEffect", "effectId", "removeEffectByID", "", "", "getCurrentSelectedEffect", "getCurrentApplyEffect", "checkApplyEffectListValid", "checkEffectRenderStatus", "url", "downloadGiftEffect", "getDownloadedPath", "giftId", "checkGiftResourceExist", "checkGiftEffectResource", Constants.Keys.duration, "renderGiftEffect", "channel", "renderPkEffect", "removePkEffect", "renderTopEffect", "removeTopEffect", "toastText", "showToast", "content", "showCustomToast", "fetchGiftAsset", "sendGift", "giftID", "autoStop", "renderGift", "changeVideoResolutionAndStreamSize", "enableEffectNotice", "replaceMockVideo", "percent", "changeResolution", "widthPercent", "heightPercent", "replayMockVideo", "INTERACT_INFO_FAIL", "Ljava/lang/String;", "RenderStatusFailCommon", "RenderStatusSuccess", "TAG", "", "Lcom/bytedance/android/livesdk/gift/model/h1;", "giftInfoMap", "Ljava/util/Map;", "interactEffectInfoMap", "interactEffectPathMap", "<init>", "()V", "livepushstream-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {

        public static final class a extends o {
            public final /* synthetic */ String a;

            public a(String r1) {
                this.a = r1;
            }

            public final void a(long r3) {
                ALogger.e("LiveAnchorPushStreamMockManager", "downloadGiftEffect, onCancel: resourceId " + r3);
            }

            public final void onFailed(Throwable r3) {
                Intrinsics.checkNotNullParameter(r3, "t");
                ALogger.e("LiveAnchorPushStreamMockManager", "downloadGiftEffect, onFailed:  " + r3.getMessage());
            }

            public final void c(long r3, String r5) {
                Intrinsics.checkNotNullParameter(r5, "path");
                LiveAnchorPushStreamMockManager.b.put(this.a, r5);
                ALogger.e("LiveAnchorPushStreamMockManager", "downloadGiftEffect, onResult: resourceId " + r3 + ", path " + r5);
            }
        }

        public static final class b extends o {
            public final /* synthetic */ String a;

            public b(String r1) {
                this.a = r1;
            }

            public final void a(long r3) {
                ALogger.e("LiveAnchorPushStreamMockManager", "downloadGiftEffect 2, onCancel: resourceId " + r3);
            }

            public final void onFailed(Throwable r3) {
                Intrinsics.checkNotNullParameter(r3, "t");
                ALogger.e("LiveAnchorPushStreamMockManager", "downloadGiftEffect 2, onFailed:  " + r3.getMessage());
            }

            public final void c(long r3, String r5) {
                Intrinsics.checkNotNullParameter(r5, "path");
                LiveAnchorPushStreamMockManager.b.put(this.a, r5);
                ALogger.e("LiveAnchorPushStreamMockManager", "downloadGiftEffect 2, onResult: resourceId " + r3 + ", path " + r5);
            }
        }

        public static final class c<T> implements Consumer {
            public final /* synthetic */ long a;

            public c(long r1) {
                this.a = r1;
            }

            public final void accept(Object r4) {
                h1 r5 = (h1) r4;
                if (r5 == null) goto L6;
                LiveAnchorPushStreamMockManager.d.getClass();
                Companion.a(r5);
                LiveAnchorPushStreamMockManager.c.put(Long.valueOf(this.a), r5);
                return;
            }
        }

        public static final class d extends tv0.a {
            public final /* synthetic */ String a;

            public d(String r1) {
                this.a = r1;
            }

            public final void onSuccess(Object r3) {
                Effect r4 = (Effect) r3;
                if (r4 != null) goto L5;
                LiveAnchorPushStreamMockManager.a.put(this.a, "fail");
                return;
            L5:
                LiveAnchorPushStreamMockManager.a.put(this.a, com.bytedance.android.live.effect.sticker.d.b(r4).getInteractRules());
            }

            public final void onFail(Effect r2, ExceptionResult r3) {
                Intrinsics.checkNotNullParameter(r3, "e");
                LiveAnchorPushStreamMockManager.a.put(this.a, "fail");
            }
        }

        public static final class e extends tv0.a {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ LiveComposerFilterHelper c;
            public final /* synthetic */ com.bytedance.android.live.effect.beauty.makeups.a d;

            public final void onSuccess(Object r9) {
                Effect r10 = (Effect) r9;
                if (r10 != null) goto L5;
                k.n(IUtilsCommonService.class).showCenterToast(this.a + "特效下载失败");
                return;
            L5:
                List r0 = LiveEffectContext.h;
                ILiveEffectComposerManager r1 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).a();
                Sticker r12 = com.bytedance.android.live.effect.sticker.d.b(r10);
                String r2 = this.b;
                if (Intrinsics.areEqual(r2, d0.c) == false) goto L8;
            L20:
                r1.b(this.b, "LiveAnchorPushStreamMockManager_renderEffect");
                r1.a(this.b, r12, "LiveAnchorPushStreamMockManager_renderEffect");
                k.n(IUtilsCommonService.class).showCenterToast(Intrinsics.stringPlus(r12.getName(), " 特效开始渲染"));
                return;
            L8:
                if (Intrinsics.areEqual(r2, d0.b) == true) goto L20;
                if (Intrinsics.areEqual(r2, d0.a) == false) goto L13;
            L19:
                LiveComposerFilterHelper.a(this.c, r12, "LiveAnchorPushStreamMockManager_renderEffect", "", false, false, 56);
                k.n(IUtilsCommonService.class).showCenterToast(Intrinsics.stringPlus(r12.getName(), " 滤镜开始渲染"));
                return;
            L13:
                if (Intrinsics.areEqual(r2, d0.l) == true) goto L19;
                if (Intrinsics.areEqual(r2, d0.k) == false) goto L18;
                com.bytedance.android.live.effect.beauty.makeups.a.a.a(this.d, r12, "ttlive_anchor_effect_LiveMakeupsBeautyFragment_OnSelectItemChange_");
                k.n(IUtilsCommonService.class).showCenterToast(Intrinsics.stringPlus(r12.getName(), " 风格妆开始渲染"));
                return;
            L18:
                r1.a(this.b, r12, "LiveAnchorPushStreamMockManager_renderEffect");
                k.n(IUtilsCommonService.class).showCenterToast(Intrinsics.stringPlus(r12.getName(), " 开始渲染"));
            }

            public final void onFail(Effect r2, ExceptionResult r3) {
                Intrinsics.checkNotNullParameter(r3, "e");
                k.n(IUtilsCommonService.class).showCenterToast(this.a + " 特效下载失败");
            }

            public e(String r1, String r2, LiveComposerFilterHelper r3, com.bytedance.android.live.effect.beauty.makeups.a r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }
        }

        public static final class f extends o {
            public final /* synthetic */ long a;
            public final /* synthetic */ long b;
            public final /* synthetic */ boolean c;

            public final void c(long r4, String r6) {
                Intrinsics.checkNotNullParameter(r6, "path");
                boolean r5 = h.a;
                long r7 = h.d(j.class).findLiteGiftById(this.a).getDuration();
                Companion r0 = LiveAnchorPushStreamMockManager.d;
                long r1 = this.b;
                r0.getClass();
                Companion.e(Companion.b(r1, r6), r7, this.c, 0);
            }

            public f(long r1, long r3, boolean r5) {
                this.a = r1;
                this.b = r3;
                this.c = r5;
            }
        }

        public static final class g implements Runnable {
            public final /* synthetic */ Ref.ObjectRef a;

            public g(Ref.ObjectRef r1) {
                this.a = r1;
            }

            public final void a() {
                ALogger.e("LiveAnchorPushStreamMockManager", "removeCurrentPanelSticker");
                List r0 = LiveEffectContext.h;
                LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).a().b((String) this.a.element, "LiveAnchorPushStreamMockManager_renderGift");
                xs2.b.a().post(new pv0.f("已播放"));
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public Companion() {
        }

        public static boolean d() {
            return LocalTestManager.b(new Class[]{AutomatedTestTag.class});
        }

        @JvmStatic
        public final boolean checkApplyEffectListValid() {
            return true;
        }

        @JvmStatic
        public final Map<String, List<String>> getCurrentApplyEffect() {
            if (d() == false) goto L5;
            List r0 = LiveEffectContext.h;
            List r1 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).a().e();
            LinkedHashMap r2 = new LinkedHashMap();
            Iterator r3 = r1.iterator();
        L8:
            if (r3.hasNext() == false) goto L20;
            n r4 = (n) r3.next();
            if (r4.j == false) goto L8;
            String r5 = r4.a;
            if (Intrinsics.areEqual(r5, d0.a) == false) goto L15;
            r5 = d0.l;
        L15:
            if (r2.containsKey(r5) == true) goto L17;
            r2.put(r5, new ArrayList());
        L17:
            List r6 = (List) r2.get(r5);
            if (r6 == null) goto L8;
            r6.add(r4.b);
            goto L8
        L20:
            return r2;
        L5:
            return MapsKt.emptyMap();
        }

        @JvmStatic
        public final Map<String, List<String>> getCurrentSelectedEffect() {
            if (d() == false) goto L5;
            List r0 = LiveEffectContext.h;
            List r1 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).a().R();
            LinkedHashMap r2 = new LinkedHashMap();
            Iterator r3 = r1.iterator();
        L8:
            if (r3.hasNext() == false) goto L20;
            n r4 = (n) r3.next();
            if (r4.j == false) goto L8;
            String r5 = r4.a;
            if (Intrinsics.areEqual(r5, d0.a) == false) goto L15;
            r5 = d0.l;
        L15:
            if (r2.containsKey(r5) == true) goto L17;
            r2.put(r5, new ArrayList());
        L17:
            List r6 = (List) r2.get(r5);
            if (r6 == null) goto L8;
            r6.add(r4.b);
            goto L8
        L20:
            return r2;
        L5:
            return MapsKt.emptyMap();
        }

        @JvmStatic
        public final void openLiveBeautyPanel() {
            if (d() == true) goto L5;
            return;
        L5:
            xs2.b.a().post(new y1());
        }

        @JvmStatic
        public final void openLiveEffectPanel() {
            if (d() == true) goto L5;
            return;
        L5:
            xs2.b.a().post(new c2(null));
        }

        @JvmStatic
        public final void replayMockVideo() {
            if (d() == true) goto L5;
            return;
        L5:
            xs2.b.a().post(new pv0.h());
        }

        public static void a(h1 r8) {
            if (r8 != null) goto L4;
            return;
        L4:
            LinkedHashSet r0 = new LinkedHashSet();
            r0.add(Long.valueOf(r8.getPrimaryEffectId()));
            List r1 = r8.getRequiredAssets();
            List r2 = null;
            if (r1 != null) goto L7;
        L12:
            List r9 = r8.getAssetIds();
            if (r9 != null) goto L15;
        L19:
            Iterator r10 = r0.iterator();
        L21:
            if (r10.hasNext() == false) goto L23;
            long r3 = ((Number) r10.next()).longValue();
            boolean r4 = h.a;
            h.d(j.class).downloadAssets("test_api", r3, null, WebcastRedirectException.UNKNOWN, AssetDownloadPriority.OPEN_DIY_PAGE);
            goto L21
        L23:
            return;
        L15:
            if ((!r9.isEmpty()) == false) goto L17;
            r2 = r9;
        L17:
            if (r2 == null) goto L19;
            r0.addAll(r2);
            goto L19
        L7:
            if ((!r1.isEmpty()) == true) goto L10;
            r1 = null;
        L10:
            if (r1 == null) goto L12;
            r0.addAll(r1);
            goto L12
        }

        @JvmStatic
        public final void changeResolution(String r4) {
            Intrinsics.checkNotNullParameter(r4, "percent");
            if (d() == true) goto L5;
            return;
        L5:
            Float r0 = StringsKt.toFloatOrNull(r4);
            if (r0 == null) goto L9;
            float r1 = r0.floatValue();
            xs2.b.a().post(new pv0.d(r1, r1));
            k.n(IUtilsCommonService.class).showCenterToast("切换分辨率至原始的 " + r4 + " 倍");
            return;
        }

        @JvmStatic
        public final boolean checkGiftResourceExist(String r5) {
            Intrinsics.checkNotNullParameter(r5, "giftId");
            if (d() == true) goto L5;
            return false;
        L5:
            Long r6 = StringsKt.toLongOrNull(r5);
            if (r6 == null) goto L18;
            long r2 = r6.longValue();
            boolean r7 = h.a;
            h1 r8 = h.d(j.class).findGiftById(r2);
            if (r8 != null) goto L10;
            Map<Long, h1> r9 = LiveAnchorPushStreamMockManager.c;
            LinkedHashMap r10 = (LinkedHashMap) r9;
            r8 = (h1) r10.get(Long.valueOf(r2));
        L10:
            if (r8 != null) goto L12;
            return false;
        L12:
            long r3 = r8.getPrimaryEffectId();
            IGiftServiceExternal r12 = k.f(IGiftServiceExternal.class);
            if (r12 != null) goto L15;
            return false;
        L15:
            if (r12.isAssetsDownloaded("effects", r3) != true) goto L20;
            return true;
        L20:
            return false;
        L18:
            return false;
        }

        @JvmStatic
        public final String checkInteractEffectInfo(String r3) {
            Intrinsics.checkNotNullParameter(r3, "effectID");
            if (d() == true) goto L5;
            return "";
        L5:
            String r4 = (String) ((LinkedHashMap) LiveAnchorPushStreamMockManager.a).get(r3);
            if (r4 != null) goto L9;
            return "";
        L9:
            return r4;
        }

        @JvmStatic
        public final void clearEffect(String r3) {
            Intrinsics.checkNotNullParameter(r3, "panel");
            if (d() == true) goto L5;
            return;
        L5:
            List r0 = LiveEffectContext.h;
            LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).a().b(r3, "LiveAnchorPushStreamMockManager_clearEffect");
        }

        @JvmStatic
        public final void enableEffectNotice(boolean r2) {
            com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.I1;
            Boolean r3 = Boolean.valueOf(r2);
            r0.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r0, r3);
        }

        @JvmStatic
        public final void enableVideoMockPushStream(boolean r2) {
            if (d() == false) goto L6;
            SettingUtil.updateLocal(rb.a, String.valueOf(r2));
            return;
        }

        @JvmStatic
        public final void fetchGiftAsset(String r5) {
            Intrinsics.checkNotNullParameter(r5, "giftId");
            Long r6 = StringsKt.toLongOrNull(r5);
            if (r6 == null) goto L9;
            long r0 = r6.longValue();
            boolean r7 = h.a;
            h.d(j.class).syncAssetsList("test_api", 2);
            h1 r8 = h.d(j.class).findGiftById(r0);
            if (r8 != null) goto L7;
            h.d(ia0.a.class).B2(r0).subscribe(new c(r0));
            return;
        L7:
            a(r8);
            LiveAnchorPushStreamMockManager.c.put(Long.valueOf(r0), r8);
            return;
        }

        @JvmStatic
        public final String getDownloadedPath(String r5) {
            Intrinsics.checkNotNullParameter(r5, "url");
            Map<String, String> r0 = LiveAnchorPushStreamMockManager.b;
            String r1 = (String) ((LinkedHashMap) r0).get(r5);
            String r2 = "";
            if (r1 != null) goto L6;
            r1 = "";
        L6:
            if (r1.length() != 0) goto L8;
            boolean r3 = true;
        L9:
            if (r3 == false) goto L15;
            boolean r4 = h.a;
            String r6 = h.d(ia0.a.class).Nk(r5);
            if (r6 == null) goto L14;
            r2 = r6;
        L14:
            r1 = r2;
        L15:
            ALogger.e("LiveAnchorPushStreamMockManager", r0.toString());
            ALogger.e("LiveAnchorPushStreamMockManager", "getDownloadedPath, url " + r5 + ", ret " + r1);
            return r1;
        L8:
            r3 = false;
            goto L9
        }

        @JvmStatic
        public final void getInteractEffectInfo(String r5) {
            Intrinsics.checkNotNullParameter(r5, "effectID");
            if (d() == true) goto L5;
            return;
        L5:
            Map<String, String> r0 = LiveAnchorPushStreamMockManager.a;
            LinkedHashMap r1 = (LinkedHashMap) r0;
            if (Intrinsics.areEqual((String) r1.get(r5), "fail") == false) goto L8;
            r0.put(r5, "");
        L8:
            String r2 = (String) r1.get(r5);
            if (r2 != null) goto L11;
        L16:
            List r3 = LiveEffectContext.h;
            LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).d().fetchEffect(r5, new d(r5));
            return;
        L11:
            if (r2.length() <= 0) goto L13;
            boolean r4 = true;
        L14:
            if (r4 != true) goto L16;
            return;
        L13:
            r4 = false;
            goto L14
        }

        @JvmStatic
        public final void replaceMockVideo(String r3) {
            Intrinsics.checkNotNullParameter(r3, "path");
            xs2.b.a().post(new pv0.g(r3));
            k.n(IUtilsCommonService.class).showCenterToast("替换视频源");
        }

        @JvmStatic
        public final void sendGift(String r5) {
            Intrinsics.checkNotNullParameter(r5, "giftId");
            Long r6 = StringsKt.toLongOrNull(r5);
            if (r6 == null) goto L6;
            long r0 = r6.longValue();
            boolean r7 = h.a;
            ia0.a r8 = h.d(ia0.a.class);
            Map<Long, h1> r2 = LiveAnchorPushStreamMockManager.c;
            LinkedHashMap r3 = (LinkedHashMap) r2;
            r8.Rg((h1) r3.get(Long.valueOf(r0)), r0);
            return;
        }

        @JvmStatic
        public final void setMockVideoPath(String r2) {
            Intrinsics.checkNotNullParameter(r2, "path");
            if (d() == false) goto L6;
            SettingUtil.updateLocal(hd.a, r2);
            return;
        }

        @JvmStatic
        public final void showCustomToast(String r4) {
            Intrinsics.checkNotNullParameter(r4, "content");
            k.n(IHostApp.class).makeShowCustomToast(r4, 3000, true);
        }

        @JvmStatic
        public final void showToast(String r2) {
            Intrinsics.checkNotNullParameter(r2, "toastText");
            k.n(IUtilsCommonService.class).showCenterToast(r2);
        }

        @JvmStatic
        public final void switchPanelOn(String r4) {
            Intrinsics.checkNotNullParameter(r4, "panel");
            if (d() == true) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual(r4, d0.i) == false) goto L9;
            m90.b.a.e(LiveEffectContextFactoryDelegate.Type.DEFAULT, Boolean.TRUE);
        L11:
            List r0 = LiveEffectContext.h;
            LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).a().T("switchPanelOn:" + r4, false);
            return;
        L9:
            if (Intrinsics.areEqual(r4, "livebody") == false) goto L11;
            m90.b.j.e(LiveEffectContextFactoryDelegate.Type.DEFAULT, Boolean.TRUE);
            goto L11
        }

        public static Sticker b(long r2, String r4) {
            Sticker r0 = new Sticker();
            r0.setId(r2);
            r0.setEffectId(r0.getEffectId());
            r0.setUnzipPath(r4);
            r0.setStickerPanel("effect_gift");
            boolean r5 = h.a;
            com.bytedance.android.live.core.resources.e r3 = h.d(j.class).getAssetsManager().G1(r2);
            if ((r3 instanceof com.bytedance.android.live.core.resources.f) == false) goto L5;
            boolean r6 = r3.isHighCostAsset();
        L6:
            r0.setHighCost(r6);
            return r0;
        L5:
            r6 = false;
            goto L6
        }

        @JvmStatic
        public final void changeResolution(String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "widthPercent");
            Intrinsics.checkNotNullParameter(r5, "heightPercent");
            if (d() == true) goto L5;
            return;
        L5:
            Float r6 = StringsKt.toFloatOrNull(r4);
            if (r6 == null) goto L11;
            float r7 = r6.floatValue();
            Float r8 = StringsKt.toFloatOrNull(r5);
            if (r8 == null) goto L12;
            float r9 = r8.floatValue();
            xs2.b.a().post(new pv0.d(r7, r9));
            k.n(IUtilsCommonService.class).showCenterToast("切换宽度至原始的 " + r7 + " 倍\n切换高度至原始的 " + r9 + " 倍");
            return;
        L12:
            return;
        }

        @JvmStatic
        public final void changeVideoResolutionAndStreamSize(String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "width");
            Intrinsics.checkNotNullParameter(r5, "height");
            if (d() == true) goto L5;
            return;
        L5:
            Integer r6 = StringsKt.toIntOrNull(r4);
            if (r6 == null) goto L11;
            int r7 = r6.intValue();
            Integer r8 = StringsKt.toIntOrNull(r5);
            if (r8 == null) goto L12;
            int r9 = r8.intValue();
            xs2.b.a().post(new pv0.e());
            k.n(IUtilsCommonService.class).showCenterToast("切换宽度至 " + r7 + " \n切换高度至 " + r9 + ' ');
            return;
        L12:
            return;
        }

        @JvmStatic
        public final String checkEffectRenderStatus(String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "panel");
            Intrinsics.checkNotNullParameter(r5, "effectID");
            if (d() == true) goto L6;
            return "";
        L6:
            List r0 = LiveEffectContext.h;
            Iterator r6 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).a().o(r4).iterator();
        L8:
            if (r6.hasNext() == false) goto L12;
            Object r1 = r6.next();
            if (Intrinsics.areEqual(String.valueOf(((Sticker) r1).getId()), r5) == false) goto L8;
        L13:
            if (r1 == null) goto L15;
            boolean r7 = true;
        L16:
            if (r7 == false) goto L18;
            return DataType.FALSE;
        L18:
            return "-1";
        L15:
            r7 = false;
            goto L16
        L12:
            r1 = null;
            goto L13
        }

        @JvmStatic
        public final boolean checkGiftEffectResource(String r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, "url");
            Intrinsics.checkNotNullParameter(r6, "effectId");
            if (r5.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L9;
            boolean r7 = h.a;
            return h.d(ia0.a.class).a7(r5);
        L9:
            Long r8 = StringsKt.toLongOrNull(r6);
            if (r8 == null) goto L18;
            long r9 = r8.longValue();
            IGiftServiceExternal r1 = k.f(IGiftServiceExternal.class);
            if (r1 != null) goto L14;
        L16:
            return false;
        L14:
            if (r1.isAssetsDownloaded("effects", r9) != true) goto L16;
            return true;
        L18:
            return false;
        L5:
            r0 = false;
            goto L6
        }

        @JvmStatic
        public final void downloadGiftEffect(String r8, String r9) {
            Intrinsics.checkNotNullParameter(r8, "url");
            Intrinsics.checkNotNullParameter(r9, "effectId");
            ALogger.e("downloadGiftEffect", "url " + r8 + ", effectId " + r9);
            if (r8.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L9;
            boolean r10 = h.a;
            h.d(ia0.a.class).A5(r8, new a(r8));
            return;
        L9:
            boolean r1 = checkGiftEffectResource("", r9);
            Long r12 = StringsKt.toLongOrNull(r9);
            if (r12 == null) goto L17;
            long r3 = r12.longValue();
            if (r1 == true) goto L18;
            IGiftServiceExternal r2 = k.f(IGiftServiceExternal.class);
            if (r2 == null) goto L19;
            r2.downloadAssets("effects", r3, new b(r8), 4);
            return;
        L19:
            return;
        L18:
            return;
        L17:
            return;
        L5:
            r0 = false;
            goto L6
        }

        @JvmStatic
        public final void removeEffectByID(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "panel");
            Intrinsics.checkNotNullParameter(r4, "effectId");
            if (d() == true) goto L5;
            return;
        L5:
            Sticker r0 = new Sticker();
            r0.setEffectId(r4);
            List r5 = LiveEffectContext.h;
            LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).a().O(r3, r0, "LiveAnchorPushStreamMockManager_clearEffectByID");
        }

        @JvmStatic
        public final boolean removePkEffect(String r6, String r7) {
            Intrinsics.checkNotNullParameter(r6, "url");
            Intrinsics.checkNotNullParameter(r7, "effectId");
            if (r6.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L12;
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-removePkEffect, start render with url");
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-removePkEffect, checkGiftEffectResource " + checkGiftEffectResource(r6, r7));
            boolean r8 = h.a;
            com.bytedance.android.live.core.resources.e r9 = h.d(ia0.a.class).kd(r6);
            if (r9 == null) goto L11;
            r9.getId();
            ALogger.e("LiveAnchorPushStreamMockManager", "removePkEffect");
            List r10 = LiveEffectContext.h;
            LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).a().b("effect_interact_gift_pk_env", "LiveAnchorPushStreamMockManager_removePkEffect");
            xs2.b.a().post(new pv0.f("已播放"));
            return true;
        L11:
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderPkEffect, render failed: target effectId is null");
        L12:
            return false;
        L5:
            r0 = false;
            goto L6
        }

        @JvmStatic
        public final boolean removeTopEffect(String r6, String r7) {
            Intrinsics.checkNotNullParameter(r6, "url");
            Intrinsics.checkNotNullParameter(r7, "effectId");
            if (r6.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L12;
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-removeTopEffect, start render with url");
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-removeTopEffect, checkGiftEffectResource " + checkGiftEffectResource(r6, r7));
            boolean r8 = h.a;
            com.bytedance.android.live.core.resources.e r9 = h.d(ia0.a.class).kd(r6);
            if (r9 == null) goto L11;
            r9.getId();
            ALogger.e("LiveAnchorPushStreamMockManager", "removeTopEffect");
            List r10 = LiveEffectContext.h;
            LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).a().b("effect_gift_top_effect", "LiveAnchorPushStreamMockManager_removeTopEffect");
            xs2.b.a().post(new pv0.f("已播放"));
            return true;
        L11:
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderTopEffect, render failed: target effectId is null");
        L12:
            return false;
        L5:
            r0 = false;
            goto L6
        }

        @JvmStatic
        public final void renderEffect(String r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, "effectID");
            Intrinsics.checkNotNullParameter(r6, "panel");
            if (d() == true) goto L5;
            return;
        L5:
            List r0 = LiveEffectContext.h;
            LiveEffectContextFactoryDelegate.Type r1 = LiveEffectContextFactoryDelegate.Type.DEFAULT;
            LiveEffectContext.a.a(r1).d().fetchEffect(r5, new e(r5, r6, LiveEffectContext.a.a(r1).b().m(), LiveEffectContext.a.a(r1).b().f()));
        }

        @JvmStatic
        public final void renderGift(String r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r12, "giftID");
            if (d() == true) goto L5;
            return;
        L5:
            Long r14 = StringsKt.toLongOrNull(r12);
            if (r14 == null) goto L22;
            long r1 = r14.longValue();
            boolean r15 = h.a;
            h2 r16 = h.d(j.class).findLiteGiftById(r1);
            if (r16 != null) goto L10;
            return;
        L10:
            long r6 = r16.getPrimaryEffectId();
            boolean r4 = true;
            if (h.d(j.class).isAssetsDownloaded("effects", r6) != true) goto L20;
            String r0 = h.d(j.class).getAssetsPath("effects", r6);
            long r2 = r16.getDuration();
            if (r0 != null) goto L15;
        L18:
            if (r4 == true) goto L23;
            e(b(r6, r0), r2, r13, 0);
            return;
        L23:
            return;
        L15:
            if (r0.length() == 0) goto L18;
            r4 = false;
            goto L18
        L20:
            h.d(j.class).downloadAssets("effects", r6, new f(r1, r6, r13), 4);
            return;
        }

        @JvmStatic
        public final boolean renderPkEffect(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, "url");
            Intrinsics.checkNotNullParameter(r8, "effectId");
            if (r7.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L25;
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderPkEffect, start render with url");
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderPkEffect, checkGiftEffectResource " + checkGiftEffectResource(r7, r8));
            if (checkGiftEffectResource(r7, r8) == false) goto L24;
            boolean r9 = h.a;
            String r10 = h.d(ia0.a.class).Nk(r7);
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderPkEffect, get AssetPath " + r10);
            com.bytedance.android.live.core.resources.e r3 = h.d(ia0.a.class).kd(r7);
            if (r3 == null) goto L22;
            long r4 = r3.getId();
            if (r10 != null) goto L14;
        L17:
            boolean r5 = true;
        L18:
            if (r5 == true) goto L21;
            e(c(r4, r10, h.d(ia0.a.class).kd(r7)), 3000, false, 2);
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderPkEffect, render success");
            return true;
        L21:
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderPkEffect, render failed: target asset path is not exists" + r10);
            goto L24
        L14:
            if (r10.length() == 0) goto L17;
            r5 = false;
            goto L18
        L22:
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderPkEffect, render failed: target effectId is null");
            return false;
        L24:
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderPkEffect, render failed: checkGiftEffectResource failed");
        L25:
            return false;
        L5:
            r0 = false;
            goto L6
        }

        @JvmStatic
        public final boolean renderTopEffect(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, "url");
            Intrinsics.checkNotNullParameter(r8, "effectId");
            if (r7.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L25;
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderTopEffect, start render with url");
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderTopEffect, checkGiftEffectResource " + checkGiftEffectResource(r7, r8));
            if (checkGiftEffectResource(r7, r8) == false) goto L24;
            boolean r9 = h.a;
            String r10 = h.d(ia0.a.class).Nk(r7);
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderTopEffect, get AssetPath " + r10);
            com.bytedance.android.live.core.resources.e r3 = h.d(ia0.a.class).kd(r7);
            if (r3 == null) goto L22;
            long r4 = r3.getId();
            if (r10 != null) goto L14;
        L17:
            boolean r5 = true;
        L18:
            if (r5 == true) goto L21;
            e(c(r4, r10, h.d(ia0.a.class).kd(r7)), 3000, false, -1);
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderTopEffect, render success");
            return true;
        L21:
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderTopEffect, render failed: target asset path is not exists" + r10);
            goto L24
        L14:
            if (r10.length() == 0) goto L17;
            r5 = false;
            goto L18
        L22:
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderTopEffect, render failed: target effectId is null");
            return false;
        L24:
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderTopEffect, render failed: checkGiftEffectResource failed");
        L25:
            return false;
        L5:
            r0 = false;
            goto L6
        }

        @JvmStatic
        public final void setMockVideoSize(int r4, int r5) {
            if (d() == false) goto L6;
            jd r0 = jd.a;
            Gson r1 = GsonHelper.get();
            ms1.d r2 = new ms1.d();
            r2.b(r4);
            r2.a(r5);
            Unit r6 = Unit.INSTANCE;
            SettingUtil.updateLocal(r0, GsonProtectorUtils.toJson(r1, r2));
            return;
        }

        @JvmStatic
        public final void setPreviewMockConfig(long r4, long r6) {
            if (d() == false) goto L6;
            id r0 = id.a;
            Gson r1 = GsonHelper.get();
            ms1.c r2 = new ms1.c();
            r2.b(r4);
            r2.a(r6);
            Unit r5 = Unit.INSTANCE;
            SettingUtil.updateLocal(r0, GsonProtectorUtils.toJson(r1, r2));
            return;
        }

        public static Sticker c(long r1, String r3, com.bytedance.android.live.core.resources.e r4) {
            Sticker r0 = new Sticker();
            r0.setId(r1);
            r0.setUnzipPath(r3);
            r0.setStickerPanel("effect_gift");
            if ((r4 instanceof com.bytedance.android.live.core.resources.f) == false) goto L5;
            boolean r2 = r4.isHighCostAsset();
        L6:
            r0.setHighCost(r2);
            return r0;
        L5:
            r2 = false;
            goto L6
        }

        @JvmStatic
        public final boolean renderGiftEffect(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "url");
            Intrinsics.checkNotNullParameter(r3, "effectId");
            Intrinsics.checkNotNullParameter(r4, Constants.Keys.duration);
            return renderGiftEffect(r2, r3, r4, DataType.FALSE);
        }

        public static void e(Sticker r3, long r4, boolean r6, int r7) {
            ALogger.e("LiveAnchorPushStreamMockManager", "startPlayGift duration " + r4 + ", autoStop " + r6 + " channel " + r7);
            Ref.ObjectRef r0 = new Ref.ObjectRef();
            r0.element = "effect_gift";
            if (r7 != (-1)) goto L6;
            r0.element = "effect_gift_top_effect";
        L6:
            if (r7 != 1) goto L9;
            r0.element = "effect_gift_special";
        L9:
            if (r7 != 2) goto L11;
            r0.element = "effect_interact_gift_pk_env";
        L11:
            List r8 = LiveEffectContext.h;
            LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).a().a((String) r0.element, r3, "LiveAnchorPushStreamMockManager_renderGift");
            xs2.b.a().post(new pv0.f("播放中"));
            if (r6 == false) goto L15;
            MainThreadPostUtils.c(new g(r0), r4);
            return;
        }

        @JvmStatic
        public final boolean renderGiftEffect(String r9, String r10, String r12, String r13) {
            Intrinsics.checkNotNullParameter(r9, "url");
            Intrinsics.checkNotNullParameter(r10, "effectId");
            Intrinsics.checkNotNullParameter(r12, Constants.Keys.duration);
            Intrinsics.checkNotNullParameter(r13, "channel");
            int r2 = 0;
            if (r9.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            long r3 = 3000;
            if (r0 == false) goto L34;
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderGiftEffect, start render with url");
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderGiftEffect, checkGiftEffectResource " + checkGiftEffectResource(r9, r10));
            if (checkGiftEffectResource(r9, r10) == false) goto L31;
            boolean r14 = h.a;
            String r15 = h.d(ia0.a.class).Nk(r9);
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderGiftEffect, get AssetPath " + r15);
            com.bytedance.android.live.core.resources.e r5 = h.d(ia0.a.class).kd(r9);
            if (r5 == null) goto L29;
            long r6 = r5.getId();
            if (r15 != null) goto L15;
        L18:
            boolean r7 = true;
        L19:
            if (r7 == true) goto L28;
            Sticker r16 = c(r6, r15, h.d(ia0.a.class).kd(r9));
            Long r17 = StringsKt.toLongOrNull(r12);
            if (r17 == null) goto L23;
            r3 = r17.longValue();
        L23:
            Integer r18 = StringsKt.toIntOrNull(r13);
            if (r18 == null) goto L26;
            r2 = r18.intValue();
        L26:
            e(r16, r3, true, r2);
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderGiftEffect, render success");
            return true;
        L28:
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderGiftEffect, render failed: target asset path is not exists " + r15);
            goto L31
        L15:
            if (r15.length() == 0) goto L18;
            r7 = false;
            goto L19
        L29:
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderGiftEffect, render failed: target effectId is null");
            return false;
        L31:
            ALogger.e("LiveAnchorPushStreamMockManager", "AutoAssetsTest-renderGiftEffect, render failed: checkGiftEffectResource failed");
            return false;
        L34:
            if (checkGiftEffectResource("", r10) == false) goto L56;
            Long r19 = StringsKt.toLongOrNull(r10);
            if (r19 == null) goto L56;
            long r20 = r19.longValue();
            IGiftServiceExternal r1 = k.f(IGiftServiceExternal.class);
            if (r1 == null) goto L40;
            String r4 = r1.getAssetsPath("effects", r20);
        L41:
            if (r4 != null) goto L43;
        L46:
            boolean r8 = true;
        L47:
            if (r8 == true) goto L56;
            Sticker r22 = b(r20, r4);
            Long r110 = StringsKt.toLongOrNull(r12);
            if (r110 == null) goto L51;
            r3 = r110.longValue();
        L51:
            Integer r111 = StringsKt.toIntOrNull(r13);
            if (r111 == null) goto L54;
            r2 = r111.intValue();
        L54:
            e(r22, r3, true, r2);
            return true;
        L43:
            if (r4.length() == 0) goto L46;
            r8 = false;
            goto L47
        L40:
            r4 = null;
        L56:
            return false;
        L5:
            r0 = false;
            goto L6
        }

        @JvmStatic
        public final void sendEffectMessage(String r3, String r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r3, "messageType");
            Intrinsics.checkNotNullParameter(r4, "arg1");
            Intrinsics.checkNotNullParameter(r5, "arg2");
            Intrinsics.checkNotNullParameter(r6, "arg3");
            if (d() == true) goto L5;
            return;
        L5:
            Integer r7 = StringsKt.toIntOrNull(r3);
            int r1 = 0;
            if (r7 == null) goto L8;
            int r8 = r7.intValue();
        L9:
            Integer r9 = StringsKt.toIntOrNull(r4);
            if (r9 == null) goto L12;
            int r10 = r9.intValue();
        L13:
            Integer r12 = StringsKt.toIntOrNull(r5);
            if (r12 == null) goto L16;
            r1 = r12.intValue();
        L16:
            ILiveEffectComposerManager.g r0 = new ILiveEffectComposerManager.g(r8, r10, r1, r6);
            ALogger.e("LiveAnchorPushStreamMockManager", "sendEffectMessage: " + r0);
            List r13 = LiveEffectContext.h;
            LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).a().v(r0, ILiveEffectComposerManager.EffectInstanceType.DEFAULT, "LiveAnchorPushStreamMockManager_sendEffectMessage");
            return;
        L12:
            r10 = 0;
            goto L13
        L8:
            r8 = 0;
            goto L9
        }
    }

    public LiveAnchorPushStreamMockManager() {
    }

    @JvmStatic
    public static final void changeResolution(String r1) {
        d.changeResolution(r1);
    }

    @JvmStatic
    public static final void changeResolution(String r1, String r2) {
        d.changeResolution(r1, r2);
    }

    @JvmStatic
    public static final void changeVideoResolutionAndStreamSize(String r1, String r2) {
        d.changeVideoResolutionAndStreamSize(r1, r2);
    }

    @JvmStatic
    public static final boolean checkApplyEffectListValid() {
        return d.checkApplyEffectListValid();
    }

    @JvmStatic
    public static final String checkEffectRenderStatus(String r1, String r2) {
        return d.checkEffectRenderStatus(r1, r2);
    }

    @JvmStatic
    public static final boolean checkGiftEffectResource(String r1, String r2) {
        return d.checkGiftEffectResource(r1, r2);
    }

    @JvmStatic
    public static final boolean checkGiftResourceExist(String r1) {
        return d.checkGiftResourceExist(r1);
    }

    @JvmStatic
    public static final String checkInteractEffectInfo(String r1) {
        return d.checkInteractEffectInfo(r1);
    }

    @JvmStatic
    public static final void clearEffect(String r1) {
        d.clearEffect(r1);
    }

    @JvmStatic
    public static final void downloadGiftEffect(String r1, String r2) {
        d.downloadGiftEffect(r1, r2);
    }

    @JvmStatic
    public static final void enableEffectNotice(boolean r1) {
        d.enableEffectNotice(r1);
    }

    @JvmStatic
    public static final void enableVideoMockPushStream(boolean r1) {
        d.enableVideoMockPushStream(r1);
    }

    @JvmStatic
    public static final void fetchGiftAsset(String r1) {
        d.fetchGiftAsset(r1);
    }

    @JvmStatic
    public static final Map<String, List<String>> getCurrentApplyEffect() {
        return d.getCurrentApplyEffect();
    }

    @JvmStatic
    public static final Map<String, List<String>> getCurrentSelectedEffect() {
        return d.getCurrentSelectedEffect();
    }

    @JvmStatic
    public static final String getDownloadedPath(String r1) {
        return d.getDownloadedPath(r1);
    }

    @JvmStatic
    public static final void getInteractEffectInfo(String r1) {
        d.getInteractEffectInfo(r1);
    }

    @JvmStatic
    public static final void openLiveBeautyPanel() {
        d.openLiveBeautyPanel();
    }

    @JvmStatic
    public static final void openLiveEffectPanel() {
        d.openLiveEffectPanel();
    }

    @JvmStatic
    public static final void removeEffectByID(String r1, String r2) {
        d.removeEffectByID(r1, r2);
    }

    @JvmStatic
    public static final boolean removePkEffect(String r1, String r2) {
        return d.removePkEffect(r1, r2);
    }

    @JvmStatic
    public static final boolean removeTopEffect(String r1, String r2) {
        return d.removeTopEffect(r1, r2);
    }

    @JvmStatic
    public static final void renderEffect(String r1, String r2) {
        d.renderEffect(r1, r2);
    }

    @JvmStatic
    public static final void renderGift(String r1, boolean r2) {
        d.renderGift(r1, r2);
    }

    @JvmStatic
    public static final boolean renderGiftEffect(String r1, String r2, String r3) {
        return d.renderGiftEffect(r1, r2, r3);
    }

    @JvmStatic
    public static final boolean renderGiftEffect(String r1, String r2, String r3, String r4) {
        return d.renderGiftEffect(r1, r2, r3, r4);
    }

    @JvmStatic
    public static final boolean renderPkEffect(String r1, String r2) {
        return d.renderPkEffect(r1, r2);
    }

    @JvmStatic
    public static final boolean renderTopEffect(String r1, String r2) {
        return d.renderTopEffect(r1, r2);
    }

    @JvmStatic
    public static final void replaceMockVideo(String r1) {
        d.replaceMockVideo(r1);
    }

    @JvmStatic
    public static final void replayMockVideo() {
        d.replayMockVideo();
    }

    @JvmStatic
    public static final void sendEffectMessage(String r1, String r2, String r3, String r4) {
        d.sendEffectMessage(r1, r2, r3, r4);
    }

    @JvmStatic
    public static final void sendGift(String r1) {
        d.sendGift(r1);
    }

    @JvmStatic
    public static final void setMockVideoPath(String r1) {
        d.setMockVideoPath(r1);
    }

    @JvmStatic
    public static final void setMockVideoSize(int r1, int r2) {
        d.setMockVideoSize(r1, r2);
    }

    @JvmStatic
    public static final void setPreviewMockConfig(long r1, long r3) {
        d.setPreviewMockConfig(r1, r3);
    }

    @JvmStatic
    public static final void showCustomToast(String r1) {
        d.showCustomToast(r1);
    }

    @JvmStatic
    public static final void showToast(String r1) {
        d.showToast(r1);
    }

    @JvmStatic
    public static final void switchPanelOn(String r1) {
        d.switchPanelOn(r1);
    }

    static {
        d = new Companion();
        a = new LinkedHashMap();
        b = new LinkedHashMap();
        c = new LinkedHashMap();
    }
}
