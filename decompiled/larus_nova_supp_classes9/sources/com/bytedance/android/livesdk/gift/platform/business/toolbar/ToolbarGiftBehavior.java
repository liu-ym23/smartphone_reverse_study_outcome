package com.bytedance.android.livesdk.gift.platform.business.toolbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.LiveData;
import ca0.p;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.n0;
import com.bytedance.android.live.core.utils.n2;
import com.bytedance.android.live.core.utils.o2;
import com.bytedance.android.live.core.utils.p2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.common.i0;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.live.revenue.model.extension.IMainRoom;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.config.yo0;
import com.bytedance.android.livesdk.gift.configmodel.h0;
import com.bytedance.android.livesdk.gift.configmodel.h2;
import com.bytedance.android.livesdk.gift.configmodel.k2;
import com.bytedance.android.livesdk.gift.platform.business.anchor.AnchorGiftPanelSource;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPanelViewPreloadService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.GiftPreloadManager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.GiftPreloadResType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftListCacheRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftListRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.w0;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftListPreLoadService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.OpenDialogService;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.core.utils.w;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdk.gift.util.FetchOpenGiftPanelFrom;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.toolbar.RevRedDot;
import com.bytedance.android.livesdk.revenue.toolbar.RevResKeyEnum;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarButton;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarConstants;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData;
import com.bytedance.android.livesdkapi.room.handler.enterroom.EnterKey;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomCallback;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomParams;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomScene;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessBridge;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessSession;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.jato.views.JatoOptDrawableCache;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import ev1.q;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u00020\u00062\u00020\u0007R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/toolbar/ToolbarGiftBehavior;", "Lzr2/k;", BuildConfig.FLAVOR, "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "Lcom/bytedance/android/live/core/utils/n0;", "Lcom/bytedance/android/scope/o;", "Landroid/content/Context;", "J", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarGiftBehavior extends zr2.k implements Observer<KVData>, n0, o {
    public long A;
    public long B;
    public int C;
    public long D;
    public long E;
    public py.k F;
    public final NextLiveData<Pair<Integer, Integer>> G;
    public ILivePreviewBusinessBridge H;
    public final c I;
    public final Context J;
    public final com.bytedance.android.livesdk.revenue.service.toolbar.d K;
    public final h01.a L;
    public final GiftListPreLoadService M;
    public final GiftPanelViewPreloadService N;
    public final OpenDialogService O;
    public final com.bytedance.android.livesdk.gift.platform.business.anchor.a P;
    public boolean b;
    public View c;
    public View d;
    public HSImageView e;
    public AbstractDraweeController f;
    public AnimatedDrawable2 g;
    public View h;
    public View i;
    public DataCenter j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public final int o;
    public final CompositeDisposable p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public long u;
    public Disposable v;
    public Disposable w;
    public boolean x;
    public m y;
    public long z;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ ToolbarGiftBehavior b;

        public a(long r1, ToolbarGiftBehavior r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r7) {
            Bitmap r8 = (Bitmap) r7;
            View r0 = this.b.d;
            if (r0 == null) goto L6;
            ViewUtilsKt.f(r0);
        L6:
            if (r8 != null) goto L8;
        L16:
            jy0.b.c("VS_TOOLBAR", "gift dynamic Icon load error", null, 4);
            this.b.K();
            this.b.G.setValue(new Pair(5, 1));
            return;
        L8:
            if (r8.isRecycled() == true) goto L16;
            View r2 = this.b.d;
            if (r2 == null) goto L12;
            r2.setBackground(new BitmapDrawable(s1.getResources(), r8));
        L12:
            View r9 = this.b.i;
            if (r9 == null) goto L15;
            r9.setVisibility(8);
        L15:
            this.b.G.setValue(new Pair(5, 0));
            jy0.b.a("VS_TOOLBAR", "gift dynamic Icon LoadSuccess,cost: " + (System.currentTimeMillis() - this.a));
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ToolbarGiftBehavior a;

        public b(ToolbarGiftBehavior r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            jy0.b.c("VS_TOOLBAR", "gift dynamic Icon load error:" + ((Throwable) r4), null, 4);
            this.a.K();
            this.a.G.setValue(new Pair(5, 1));
        }
    }

    public static final class c implements ILiveEnterRoomCallback {
        public final /* synthetic */ ToolbarGiftBehavior a;

        public static final class a implements ILiveEnterRoomParams {
            public final EnterKey.PreviewToolbar.Gift a;
            public final Bundle b;
            public final String c;
            public final Map<String, String> d;

            public final Bundle getFirstRoomLogParams() {
                return null;
            }

            public a() {
                this.a = EnterKey.PreviewToolbar.Gift.INSTANCE;
                this.b = new Bundle();
                this.c = "send_gift_btn";
                this.d = MapsKt.emptyMap();
            }

            public final Bundle getBusinessBundle() {
                return this.b;
            }

            public final String getClickMethod() {
                return this.c;
            }

            public final Map<String, String> getCommonLogParams() {
                return this.d;
            }

            public final EnterKey getEnterKey() {
                return this.a;
            }
        }

        public c(ToolbarGiftBehavior r1) {
            this.a = r1;
        }

        public final ILiveEnterRoomParams getEnterParams(ILivePreviewBusinessSession r2) {
            Intrinsics.checkNotNullParameter(r2, "session");
            return new a();
        }

        public final void onBeforeEnterRoom(ILivePreviewBusinessSession r4) {
            Intrinsics.checkNotNullParameter(r4, "session");
            HashMap r0 = new HashMap();
            r0.put("module_name", "send_gift_btn");
            ILivePreviewBusinessBridge r1 = this.a.H;
            if (r1 == null) goto L5;
            r1.sendLogger("livesdk_preview_guide_click", r0);
        L5:
            ILiveEnterRoomCallback.DefaultImpls.onBeforeEnterRoom(this, r4);
        }
    }

    public static final class d implements View.OnTouchListener {
        public final /* synthetic */ ToolbarGiftBehavior a;

        public d(ToolbarGiftBehavior r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r50, MotionEvent r51) {
            if (r51 != null) goto L5;
            return false;
        L5:
            if (r51.getAction() != 0) goto L77;
            ToolbarGiftBehavior r2 = this.a;
            r2.getClass();
            if (com.bytedance.android.livesdk.gift.platform.core.h.n().p() == false) goto L69;
            r2.D = System.currentTimeMillis();
            if (r2.O.f(FetchOpenGiftPanelFrom.TOUCH_DOWN) == true) goto L69;
            GiftListPreLoadService r3 = r2.M;
            ReadOnlyProperty r5 = GiftListPreLoadService.i;
            Boolean r6 = (Boolean) r3.g.get("data_is_anchor", Boolean.FALSE);
            if (r6 == null) goto L13;
            boolean r33 = r6.booleanValue();
        L14:
            IRoom r7 = x.a();
            if (r7 == null) goto L69;
            y r8 = r3.f;
            IBaseUser r9 = r8.i();
            if (r9 != null) goto L20;
            r9 = r3.e.a();
        L20:
            int r31 = u.c(r8.h(r9));
            GiftContext r10 = com.bytedance.android.livesdk.gift.util.b.b();
            if (r10 == null) goto L27;
            com.bytedance.live.datacontext.m<GiftContext.a> r11 = r10.getLastSendGiftId();
            if (r11 == null) goto L27;
            GiftContext.a r13 = (GiftContext.a) r11.getValue();
            if (r13 == null) goto L27;
            long r14 = r13.a;
        L28:
            IBaseUser r15 = r3.f.i();
            if (r15 != null) goto L32;
            r15 = r3.e.a();
        L32:
            if (r7.getId() == 0) goto L69;
            if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.m(r15) == false) goto L46;
            w0.c(r7.getId(), r15.getIdString(), 4, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r15));
            long r27 = r7.getId();
            long r29 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r15);
            if (r7.getOwner() == null) goto L39;
            IBaseUser r4 = r7.getOwner();
            Intrinsics.checkNotNull(r4);
            String r34 = com.bytedance.android.live.base.model.user.o.a(r4);
        L40:
            Intrinsics.checkNotNullParameter(r15, "$this$secUidExt");
            String r35 = r15.getCastSecUid();
            n01.a r16 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
            if (r16 == null) goto L43;
            IEpisode r36 = r16.jf();
        L44:
            GiftListRepo.k(null, r27, r29, r31, 3, r33, r34, r35, r36, 0, (int) r7.getRoomLayout(), null, Long.valueOf(r14), null, 0, null, null, false, 190464);
            goto L69
        L43:
            r36 = null;
            goto L44
        L39:
            r34 = BuildConfig.FLAVOR;
            goto L40
        L46:
            if (r7.getOwner() == null) goto L48;
            IBaseUser r17 = r7.getOwner();
            Intrinsics.checkNotNull(r17);
            String r28 = com.bytedance.android.live.base.model.user.o.a(r17);
        L50:
            if (CollectionsKt.listOf(new Integer[]{512, 1024}).contains(Integer.valueOf(r31)) == true) goto L62;
            long r18 = r7.getId();
            if (com.bytedance.android.livesdk.gift.platform.business.i.g() == false) goto L57;
            IBaseUser r19 = r3.f.i();
            if (r19 != null) goto L56;
            r19 = r3.e.a();
        L56:
            String r20 = String.valueOf(r19.getUserId());
        L60:
            w0.c(r18, r20, r31, r7.getId());
            goto L62
        L57:
            r20 = r7.getAnchorId();
            if (r20 != null) goto L60;
            r20 = BuildConfig.FLAVOR;
        L62:
            long r110 = r7.getId();
            long r111 = r7.getId();
            Intrinsics.checkNotNullParameter(r15, "$this$secUidExt");
            String r21 = r15.getCastSecUid();
            n01.a r23 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
            if (r23 == null) goto L65;
            Episode r210 = r23.jf();
        L66:
            GiftListRepo.k(null, r110, r111, r31, 3, r33, r28, r21, r210, 0, (int) r7.getRoomLayout(), null, Long.valueOf(r14), null, 0, null, null, false, 190464);
            goto L69
        L65:
            r210 = null;
            goto L66
        L48:
            r28 = BuildConfig.FLAVOR;
        L27:
            r14 = -1;
            goto L28
        L13:
            r33 = false;
        L69:
            if (com.bytedance.android.livesdk.gift.platform.core.h.n().e() == false) goto L73;
            com.bytedance.android.live.profit.privilege.a r0 = yt0.c.i();
            if (r0 == null) goto L73;
            r0.k0(1);
        L73:
            GiftPanelViewPreloadService r1 = r2.N;
            GiftPanelViewPreloadService.PreloadSource r24 = GiftPanelViewPreloadService.PreloadSource.CLICK_ACTION_DOWN;
            r1.a(r24);
            r2.N.c(r24);
            HashMap<GiftPreloadResType, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k<?>> r25 = GiftPreloadManager.a;
            GiftPreloadManager.b(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.new.h.i.a);
            return false;
        L77:
            return false;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ToolbarGiftBehavior a;

        public e(ToolbarGiftBehavior r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Unit r4 = (Unit) r3;
            ILivePreviewBusinessBridge r5 = this.a.H;
            if (r5 == null) goto L7;
            ILivePreviewBusinessSession r6 = r5.getSession();
            if (r6 == null) goto L7;
            ILiveEnterRoomScene r7 = r6.getScene();
        L9:
            if (Intrinsics.areEqual(r7, ILiveEnterRoomScene.PreviewToolbar.INSTANCE) == false) goto L14;
            HashMap r8 = new HashMap();
            r8.put("module_name", "send_gift_btn");
            ILivePreviewBusinessBridge r0 = this.a.H;
            if (r0 == null) goto L15;
            r0.sendLogger("livesdk_preview_guide_show", r8);
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r7 = null;
            goto L9
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ ToolbarGiftBehavior a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ com.bytedance.android.livesdk.revenue.service.vs.b c;

        public f(ToolbarGiftBehavior r1, Ref.ObjectRef r2, com.bytedance.android.livesdk.revenue.service.vs.b r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            py.k r4 = this.a.A();
            String r0 = null;
            if (r4 == null) goto L5;
            String r5 = r4.getUri();
        L7:
            if (Intrinsics.areEqual(r5, (String) this.b.element) == false) goto L10;
            jy0.b.a("VS_TOOLBAR", "gift dynamic Icon configDynamicView vsInteractionDataPrepared same, skip");
            return;
        L10:
            jy0.b.a("VS_TOOLBAR", "gift dynamic Icon configDynamicView on vsInteractionDataPrepared");
            this.a.y();
            ToolbarGiftBehavior r6 = this.a;
            Episode r1 = this.c.getEpisode();
            if (r1 == null) goto L13;
            r0 = r1.seasonId;
        L13:
            r6.I(r0);
            return;
        L5:
            r5 = null;
            goto L7
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ DraweeController a;

        public g(AbstractDraweeController r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            DraweeController r3 = this.a;
            if (r3 == null) goto L8;
            Animatable r4 = r3.getAnimatable();
            if (r4 == null) goto L9;
            r4.start();
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.toolbar.ToolbarGiftBehavior$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lh01/d;", BuildConfig.FLAVOR, "invoke", "(Lh01/d;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function1<h01.d, Unit> {
        final /* synthetic */ ToolbarGiftBehavior this$0;

        public AnonymousClass1(ToolbarGiftBehavior r1) {
            this.this$0 = r1;
            super(1);
        }

        public final void invoke(h01.d r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            r2.a(C00641.INSTANCE);
            r2.b(new AnonymousClass2(this));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((h01.d) r1);
            return Unit.INSTANCE;
        }
    }

    public final yz0.k E() {
        return com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
    }

    public final void F() {
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.experience.b.class).qf() == false) goto L5;
        return;
    L5:
        this.q = false;
        DataCenter r1 = this.j;
        String r2 = null;
        if (r1 == null) goto L8;
        IRoom r3 = (IRoom) r1.get("data_room", null);
    L10:
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getCurrentScene() != 10) goto L13;
        ToastUtil.a(2131911887, 0);
        return;
    L13:
        boolean r4 = true;
        if (r3 == null) goto L42;
        IRoomAuthStatus r5 = r3.getRoomAuthStatus();
        if (r5 == null) goto L42;
        if (r5.getEnableGift() == true) goto L42;
        IRoomAuthStatus r6 = r3.getRoomAuthStatus();
        if (r6 == null) goto L24;
        IRoomAuthStatus.IOffReason r7 = r6.getOffReason();
        if (r7 == null) goto L24;
        String r8 = r7.getGift();
    L26:
        if (TextUtils.isEmpty(r8) == true) goto L33;
        int r9 = ToastUtil.a;
        IRoomAuthStatus r10 = r3.getRoomAuthStatus();
        if (r10 == null) goto L32;
        IRoomAuthStatus.IOffReason r11 = r10.getOffReason();
        if (r11 == null) goto L32;
        r2 = r11.getGift();
    L32:
        ToastUtil.b(r2, 0);
    L34:
        HashMap r0 = new HashMap();
        yz0.k r13 = E();
        if (r13 != null) goto L37;
    L39:
        String r14 = "0";
    L40:
        r0.put("is_sale", r14);
        LiveMode r15 = r3.getStreamType();
        int r16 = h1.a;
        r0.put("live_type", i1.a(r15));
        n r17 = new n();
        Map r18 = r17.a;
        Intrinsics.checkNotNullParameter(r18, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r18.putAll(r0);
        mz0.m r19 = new mz0.m();
        r19.b(LogCommon.ROOM);
        r19.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r17.b).addAll(r19.a);
        cy0.e.a.getClass();
        cy0.j r20 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r21 = com.bytedance.android.scope.m.b(r20).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r21);
        ((f80.a) r21).w3("close_gift_toast_show", r17.a, r17.b);
        return;
    L37:
        if (r13.getHasCommerceEntrance() != true) goto L39;
        r14 = "1";
        goto L40
    L33:
        ToastUtil.a(2131916225, 0);
    L24:
        r8 = null;
    L42:
        lr2.a r23 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), lr2.a.class);
        if (r23 == null) goto L48;
        if (r23.Pe(PaidInteractEntry.CONTROL_ENTRY_GIFT) == true) goto L48;
        return;
    L48:
        if (this.j == null) goto L66;
        com.bytedance.android.live.revenue.core.a r24 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r24 == null) goto L55;
        yz0.k r25 = com.bytedance.android.live.revenue.core.util.f.c(r24, yz0.k.class);
        if (r25 == null) goto L55;
        boolean r26 = r25.isAnchor();
    L56:
        if (r26 == false) goto L66;
        yz0.k r27 = E();
        if (r27 == null) goto L62;
        ILiveMode r28 = r27.getLiveMode();
        if (r28 == null) goto L62;
        String r29 = r28.getSceneName();
    L64:
        if (Intrinsics.areEqual(r29, "video") == false) goto L66;
        boolean r30 = true;
    L67:
        if (r30 == false) goto L69;
    L85:
        HashMap r31 = new HashMap();
        n r33 = new n();
        Map r34 = r33.a;
        Intrinsics.checkNotNullParameter(r34, "map");
        Intrinsics.checkNotNullParameter(r31, "map");
        r34.putAll(r31);
        mz0.m r35 = new mz0.m();
        r35.b(LogCommon.ROOM);
        r35.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r33.b).addAll(r35.a);
        cy0.e.a.getClass();
        cy0.j r36 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r37 = com.bytedance.android.scope.m.b(r36).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r37);
        ((f80.a) r37).w3("livesdk_anchor_gift_click", r33.a, r33.b);
    L87:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.anchor.b.b.getValue(null, com.bytedance.android.livesdk.gift.platform.business.anchor.b.a[0])).booleanValue() == false) goto L105;
        boolean r38 = this.k;
        if (r38 == false) goto L91;
        this.P.a(this.J, AnchorGiftPanelSource.MoreFunction, AnonymousClass3.INSTANCE, new AnonymousClass4(this));
    L106:
        GiftContext r39 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r39 == null) goto L109;
        r2 = r39.getToolbarGiftAnimController();
    L109:
        if (r2 == null) goto L114;
        com.bytedance.android.live.revenue.common.n r40 = (com.bytedance.android.live.revenue.common.n) r2.getValue();
        if (r40 == null) goto L115;
        r40.s();
        return;
    L115:
        return;
    L114:
        return;
    L91:
        if (r38 == true) goto L104;
        yz0.k r41 = E();
        if (r41 == null) goto L97;
        IBaseUser r43 = r41.getUser();
        if (r43 == null) goto L97;
        String r44 = r43.getIdString();
    L98:
        if (r3 == null) goto L100;
        String r45 = r3.getAnchorId();
    L102:
        if (Intrinsics.areEqual(r44, r45) == false) goto L104;
        this.P.a(this.J, AnchorGiftPanelSource.UserGiftTabIcon, AnonymousClass5.INSTANCE, new AnonymousClass6(this));
        goto L106
    L100:
        r45 = null;
    L97:
        r44 = null;
    L104:
        J();
        goto L106
    L105:
        J();
        goto L106
    L69:
        if (this.j == null) goto L83;
        com.bytedance.android.live.revenue.core.a r46 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r46 == null) goto L76;
        yz0.k r47 = com.bytedance.android.live.revenue.core.util.f.c(r46, yz0.k.class);
        if (r47 == null) goto L76;
        boolean r48 = r47.isAnchor();
    L77:
        if (r48 == false) goto L83;
        yz0.k r49 = E();
        if (r49 == null) goto L83;
        if (r49.isAudioRoom() != true) goto L83;
    L84:
        if (r4 == false) goto L87;
    L76:
        r48 = false;
    L83:
        r4 = false;
    L62:
        r29 = null;
    L55:
        r26 = false;
    L66:
        r30 = false;
        goto L67
    L8:
        r3 = null;
        goto L10
    }

    public final void J() {
        Bundle r6 = new Bundle();
        r6.putString("gift_show_from", "bottom_tab");
        com.bytedance.tools.kcp.spongepreference.runtime.a r1 = ay1.b.N;
        KProperty[] r2 = ay1.b.a;
        Map r3 = (Map) r1.getValue(null, r2[48]);
        if (r3 == null) goto L15;
        String r4 = (String) r3.get("meta_id");
        if (r4 == null) goto L7;
        Long r5 = StringsKt.toLongOrNull(r4);
    L8:
        String r7 = (String) r3.get("gift_id");
        if (r7 == null) goto L11;
        Long r8 = StringsKt.toLongOrNull(r7);
    L12:
        if (r5 == null) goto L15;
        if (r8 == null) goto L15;
        long r9 = r8.longValue();
    L16:
        int r10 = ((Number) com.bytedance.android.livesdk.gift.platform.business.toolbar.a.f.getValue(null, com.bytedance.android.livesdk.gift.platform.business.toolbar.a.a[4])).intValue();
        if (this.m == false) goto L23;
        Context r11 = this.J;
        if (r11 == null) goto L21;
        com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(r11, this.n);
    L21:
        this.m = false;
        this.n = BuildConfig.FLAVOR;
        return;
    L23:
        if (r9 > 0) goto L25;
    L31:
        LocateGiftInfo.Companion.getClass();
        LocateGiftInfo r13 = LocateGiftInfo.a.a();
        com.bytedance.tools.kcp.spongepreference.runtime.a r14 = ay1.b.e0;
        long r15 = ((Number) r14.getValue(null, r2[68])).longValue();
        if (this.k == true) goto L34;
    L36:
        HashSet r16 = da0.a.a;
        Iterator r17 = da0.a.a.iterator();
    L38:
        if (r17.hasNext() == false) goto L40;
        ((p) r17.next()).r();
        goto L38
    L40:
        OpenDialogService.h(this.O, 0, r13.getTargetGiftId(), BuildConfig.FLAVOR, r6, r13.getBuffLevel(), null, BuildConfig.FLAVOR, com.bytedance.android.livesdk.gift.platform.core.h.n().n(), null, 0, 768);
        return;
    L34:
        if (r15 < 0) goto L36;
        r13.setTargetGiftId(((Number) ay1.b.f0.getValue(null, r2[69])).longValue());
        r14.setValue(null, r2[68], -1L);
        goto L36
    L25:
        if (r10 != 1) goto L31;
        HashSet r18 = da0.a.a;
        Iterator r19 = da0.a.a.iterator();
    L28:
        if (r19.hasNext() == false) goto L30;
        ((p) r19.next()).r();
        goto L28
    L30:
        OpenDialogService.h(this.O, 0, r9, BuildConfig.FLAVOR, r6, 0, null, BuildConfig.FLAVOR, false, null, 0, 896);
        return;
    L11:
        r8 = null;
        goto L12
    L7:
        r5 = null;
    L15:
        r9 = -1;
        goto L16
    }

    public final void K() {
        View r0 = this.d;
        if (r0 == null) goto L5;
        ViewUtilsKt.f(r0);
    L5:
        View r1 = this.d;
        if (r1 != null) goto L8;
        return;
    L8:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k() == false) goto L10;
        int r2 = 2131253369;
    L11:
        r1.setBackground(s1.m(r2));
        return;
    L10:
        r2 = 2131253370;
        goto L11
    }

    public final boolean N() {
        if (this.r == false) goto L5;
    L10:
        return true;
    L5:
        if (this.s == true) goto L10;
        if (this.t == true) goto L10;
        return false;
    }

    public final RevRedDot h7() {
        if (this.k == true) goto L7;
        return null;
    L7:
        return RevRedDot.AnchorMoreGift;
    }

    public final void onStart() {
        StringBuilder r0 = new StringBuilder("onStart:");
        r0.append(hashCode());
        r0.append(" id:");
        DataCenter r1 = this.j;
        if (r1 == null) goto L7;
        IRoom r2 = gb2.a.e(r1);
        if (r2 == null) goto L7;
        Long r3 = Long.valueOf(r2.getRoomId());
    L8:
        r0.append(r3);
        ALogger.i("ToolbarGiftBehavior", r0.toString());
        this.b = false;
        if (com.bytedance.android.livesdk.gift.platform.business.toolbar.c.c() == false) goto L11;
        this.L.Ye(RevToolbarConstants.Gift, this, new AnonymousClass1(this));
    L11:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).tg(this.j).e(RevToolbarButton.BroadCastGift, this);
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final void onStop() {
        StringBuilder r0 = new StringBuilder("onStop:");
        r0.append(hashCode());
        r0.append(" id:");
        DataCenter r1 = this.j;
        if (r1 == null) goto L7;
        IRoom r2 = gb2.a.e(r1);
        if (r2 == null) goto L7;
        Long r3 = Long.valueOf(r2.getRoomId());
    L8:
        r0.append(r3);
        ALogger.i("ToolbarGiftBehavior", r0.toString());
        this.b = true;
        this.L.f5(RevToolbarConstants.Gift, this);
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).tg(this.j).c(RevToolbarButton.BroadCastGift, this);
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final boolean showRedDot() {
        if (this.k == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) yo0.a.getValue()).booleanValue() == true) goto L7;
        return this.q;
    }

    public final void w() {
        DataCenter r0 = this.j;
        IRoom r1 = null;
        if (r0 == null) goto L5;
        IRoom r2 = (IRoom) r0.get("data_enter_room", null);
    L6:
        if (r2 != null) goto L12;
        DataCenter r3 = this.j;
        if (r3 == null) goto L10;
        r1 = (IRoom) r3.get("data_room", null);
    L10:
        r2 = r1;
    L12:
        if (this.k == false) goto L14;
        return;
    L14:
        if (L(r2) == true) goto L40;
        KmpEnv r4 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L25;
        if (r2 == null) goto L25;
        if (r2.isD3Room() != true) goto L25;
        if (this.l == true) goto L25;
        View r5 = this.d;
        if (r5 == null) goto L41;
        r5.setBackgroundResource(2131248561);
        return;
    L41:
        return;
    L25:
        View r6 = this.d;
        if (r6 != null) goto L28;
        return;
    L28:
        if (this.l == true) goto L34;
        if (((Boolean) q.d.getValue()).booleanValue() == false) goto L32;
        int r7 = 2131252955;
    L37:
        r6.setBackgroundResource(r7);
        return;
    L32:
        r7 = 2131252954;
        goto L37
    L34:
        if (((Boolean) q.d.getValue()).booleanValue() == false) goto L36;
        r7 = 2131243763;
        goto L37
    L36:
        r7 = 2131251576;
        goto L37
    L40:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final py.k A() {
        com.bytedance.android.live.revenue.core.a r0 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r0 == null) goto L9;
        n01.a r1 = com.bytedance.android.live.revenue.core.util.f.c(r0, n01.a.class);
        if (r1 == null) goto L9;
        IEpisode r2 = r1.Xc();
        if (r2 == null) goto L9;
        List r3 = r2.getPannelToolbarList();
    L11:
        if (r3 == null) goto L15;
        if (r3.isEmpty() == true) goto L15;
    L31:
        if (r3 == null) goto L42;
        Iterator r4 = r3.iterator();
    L34:
        if (r4.hasNext() == false) goto L42;
        IVSToolbarConfigData r5 = (IVSToolbarConfigData) r4.next();
        if (r5.getToolbarType() != 5) goto L34;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k() == false) goto L41;
        return r5.getVerticalIcon();
    L41:
        return r5.getIcon();
    L42:
        return null;
    L15:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k() == false) goto L31;
        DataCenter r6 = this.j;
        String r7 = BuildConfig.FLAVOR;
        if (r6 == null) goto L22;
        String r8 = (String) r6.get("live.intent.extra.VS_SEASON_ID", BuildConfig.FLAVOR);
        if (r8 == null) goto L22;
        r7 = r8;
    L22:
        LinkedHashMap r9 = p2.a;
        Intrinsics.checkNotNullParameter(r7, "seasonId");
        Map r10 = (Map) ((LinkedHashMap) p2.b).get(r7);
        if (r10 == null) goto L25;
        py.k r11 = (py.k) r10.get(5);
    L27:
        if ((r11 instanceof py.k) == true) goto L30;
        return null;
    L30:
        return r11;
    L25:
        r11 = null;
    L9:
        r3 = null;
        goto L11
    }

    public final void y() {
        py.k r0 = A();
        if (r0 == null) goto L29;
        long r1 = System.currentTimeMillis();
        LinkedHashMap r3 = p2.a;
        Context r4 = this.J;
        if (r0.getUrls().isEmpty() == false) goto L7;
        Observable r2 = Observable.create(o2.a);
    L25:
        r2.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r1, this), new b(this));
        return;
    L7:
        String r5 = r0.getUri();
        if (r5 != null) goto L10;
        r5 = "-1";
    L10:
        Intrinsics.checkNotNullParameter(r5, "urlKey");
        ImageRequest r6 = (ImageRequest) p2.a.get(r5);
        List r7 = r0.getUrls();
        if (r7 == null) goto L14;
        String r8 = (String) ListProtector.get(r7, 0);
        if (r8 == null) goto L14;
    L15:
        ALogger.w("VSPortraitToolBarIconLoader", "isUrl [" + r8 + "] InBitmapMemoryCache: " + ImagePipelineFactory.getInstance().getImagePipeline().isInBitmapMemoryCache(UriProtector.parse(r8)));
        if (r6 == null) goto L24;
        DataSource r9 = ImagePipelineFactory.getInstance().getImagePipeline().fetchImageFromBitmapCache(r6, r4);
    L22:
        e = move-exception;
        ALogger.e("VSPortraitToolBarIconLoader", e);
        goto L24
    L19:
        if (((CloseableReference) r9.getResult()) == null) goto L24;
        ALogger.w("VSPortraitToolBarIconLoader", "has cache for " + r5 + "! yeah");     // Catch: Exception -> L22
        r2 = Observable.create(new n2(r9, r0));     // Catch: Exception -> L22
    L24:
        ALogger.e("VSPortraitToolBarIconLoader", "no imagePipeline cache for " + r5 + ", fall back load");
        r2 = a1.k(r0);
    L14:
        r8 = BuildConfig.FLAVOR;
        goto L15
    }

    public final Context getContext() {
        return this.J;
    }

    public final NextLiveData<Pair<Integer, Integer>> q() {
        return this.G;
    }

    public final void I(String r5) {
        py.k r0 = A();
        if (r0 == null) goto L11;
        if (r5 != null) goto L6;
        r5 = "-1";
    L6:
        LinkedHashMap r1 = p2.a;
        Intrinsics.checkNotNullParameter(r5, "seasonId");
        Intrinsics.checkNotNullParameter(r0, "imageModel");
        Map r2 = p2.b;
        Map r3 = (Map) ((LinkedHashMap) r2).get(r5);
        if (r3 != null) goto L9;
        r3 = new LinkedHashMap();
    L9:
        r3.put(5, r0);
        r2.put(r5, r3);
        jy0.b.a("VS_TOOLBAR", "gift dynamic Icon put season cache for ".concat(r5));
        return;
    }

    public final boolean L(IRoom r5) {
        if (r5 == null) goto L12;
        h01.a r0 = this.L;
        RevToolbarConstants r1 = RevToolbarConstants.Gift;
        boolean r2 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k();
        RevResKeyEnum r3 = RevResKeyEnum.STATIC_ICON;
        if (r0.wk(r1, r5, r2, r3) == false) goto L7;
        return true;
    L7:
        if (u.p() == true) goto L9;
        return false;
    L9:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k() == false) goto L11;
        return false;
    L11:
        return this.L.wk(r1, r5, true, r3);
    L12:
        return false;
    }

    public final void a(final zr2.n r13) {
        Intrinsics.checkNotNullParameter(r13, "command");
        if (this.b == false) goto L5;
        return;
    L5:
        boolean r1 = true;
        IRoom r2 = null;
        char r3 = 0;
        if ((r13 instanceof zr2.e) == false) goto L67;
        DataCenter r0 = this.j;
        if (r0 == null) goto L10;
        IRoom r4 = (IRoom) r0.get("data_room", null);
    L12:
        if (com.bytedance.android.livesdk.gift.platform.business.a.c() == 1) goto L14;
    L16:
        if (r4 == null) goto L22;
        IMainRoom r5 = r4.castToOrNull(IMainRoom.class);
        if (r5 == null) goto L22;
        Map r6 = r5.getAnchorAbMap();
        if (r6 == null) goto L22;
        String r7 = (String) r6.get("gift_hide_tip");
    L24:
        if (Intrinsics.areEqual(r7, "2") == true) goto L26;
    L28:
        zr2.e r8 = (zr2.e) r13;
        int r9 = r8.g;
        String r10 = BuildConfig.FLAVOR;
        if (r9 != 2) goto L36;
        this.m = true;
        String r11 = r8.c;
        if (r11 == null) goto L34;
        r10 = r11;
    L34:
        this.n = r10;
    L63:
        View r14 = this.d;
        if (r14 == null) goto L119;
        this.K.wf(r8, r8.j, this.J, r14, new ToolbarGiftBehavior$onCommand$$inlined$let$lambda$1(this, r13));
        return;
    L119:
        return;
    L36:
        if (r8.h != 10) goto L63;
        if (r9 != 3) goto L63;
        int r15 = com.bytedance.android.annie.param.b.a;
        String r16 = r8.c;
        List r17 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r17, "excludeList");
        HashMap r18 = new HashMap();
        if (r16 != null) goto L42;
    L43:
        r3 = 1;
    L44:
        if (r3 != 0) goto L62;
        Uri r19 = UriProtector.parse(r16);
        Set r20 = UriProtector.getQueryParameterNames(r19);
        if (r20 == null) goto L62;
        ArrayList r21 = new ArrayList();
        Iterator r23 = r20.iterator();
    L51:
        if (r23.hasNext() == false) goto L55;
        Object r24 = r23.next();
        if ((!r17.contains((String) r24)) == false) goto L51;
        r21.add(r24);
        goto L51
    L55:
        Iterator r25 = r21.iterator();
    L57:
        if (r25.hasNext() == false) goto L62;
        String r26 = (String) r25.next();
        String r27 = UriProtector.getQueryParameter(r19, r26);
        if (r27 != null) goto L61;
        r27 = BuildConfig.FLAVOR;
    L61:
        r18.put(r26, r27);
    L62:
        ay1.b.N.setValue(null, ay1.b.a[48], r18);
        goto L63
    L42:
        if (r16.length() != 0) goto L44;
    L26:
        if (this.x == true) goto L28;
        return;
    L22:
        r7 = null;
        goto L24
    L14:
        if (this.x == true) goto L16;
        return;
    L10:
        r4 = null;
        goto L12
    L67:
        if ((r13 instanceof zr2.f) == false) goto L83;
        DataCenter r110 = this.j;
        if (r110 == null) goto L72;
        r2 = (IRoom) r110.get("data_room", null);
    L72:
        if (x.b() == true) goto L81;
        if (r2 == null) goto L80;
        IRoomAuthStatus r111 = r2.getRoomAuthStatus();
        if (r111 == null) goto L80;
        if (r111.getEnableGift() == true) goto L81;
    L80:
        r1 = false;
    L81:
        this.x = r1;
        return;
    L83:
        if ((r13 instanceof zr2.j) == false) goto L92;
        if (N() == true) goto L122;
        GiftContext r112 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r112 == null) goto L89;
        r2 = r112.getToolbarGiftAnimController();
    L89:
        if (r2 == null) goto L123;
        r2.c(ToolbarGiftBehavior$onCommand$2.INSTANCE);
        return;
    L123:
        return;
    L122:
        return;
    L92:
        if ((r13 instanceof zr2.i) == false) goto L106;
        View r28 = this.h;
        zr2.i r113 = (zr2.i) r13;
        if (r113.a == false) goto L96;
        int r29 = 0;
    L97:
        UIUtils.setViewVisibility(r28, r29);
        if (r113.b == true) goto L100;
        return;
    L100:
        if (r113.a == true) goto L103;
        r3 = '\b';
    L103:
        if (r3 != 0) goto L126;
        this.q = true;
        return;
    L126:
        return;
    L96:
        r29 = 8;
        goto L97
    L106:
        if ((r13 instanceof zr2.q) == true) goto L108;
        return;
    L108:
        if (N() == true) goto L129;
        this.L.s0(RevToolbarConstants.Gift);
        return;
    }

    public final void d(zr2.h r4) {
        Intrinsics.checkNotNullParameter(r4, "button");
        py.k r5 = r4.a;
        if (r5 == null) goto L15;
        this.F = r5;
        DataCenter r6 = this.j;
        IRoom r1 = null;
        if (r6 == null) goto L7;
        r1 = (IRoom) r6.get("data_room", null);
    L7:
        if (r1 == null) goto L11;
        IRoomAuthStatus r7 = r1.getRoomAuthStatus();
        if (r7 == null) goto L11;
        r7.setEnableGift(true);
    L11:
        DataCenter r8 = this.j;
        if (r8 == null) goto L16;
        r8.put("data_room", r1);
        return;
    L16:
        return;
    }

    public final ILiveEnterRoomCallback k(ILivePreviewBusinessBridge r2) {
        Intrinsics.checkNotNullParameter(r2, "bridge");
        this.H = r2;
        return this.I;
    }

    public final void onChanged(Object r13) {
        KVData r14 = (KVData) r13;
        if (r14 == null) goto L5;
        String r1 = r14.getKey();
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.hashCode() == (-1570991504)) goto L12;
        return;
    L12:
        if (r1.equals("data_is_followed") == false) goto L36;
        Boolean r15 = (Boolean) r14.getData();
        if (r15 == null) goto L37;
        int r2 = k2.b;
        int r0 = ((Number) com.bytedance.android.livesdk.gift.platform.business.b.n.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[12])).intValue();
        boolean r3 = false;
        if (r0 != 2) goto L18;
    L21:
        boolean r4 = true;
    L22:
        if (r4 == true) goto L24;
        return;
    L24:
        if (Intrinsics.areEqual(r15, Boolean.TRUE) == true) goto L26;
    L28:
        if (r3 == true) goto L30;
        this.L.Za(RevToolbarConstants.Gift);
        return;
    L30:
        long r5 = System.currentTimeMillis();
        long r6 = (r5 - this.B) / ((long) this.o);
        long r7 = com.bytedance.android.livesdk.gift.platform.business.a.e().b();
        long r8 = this.o;
        long r9 = r7 / r8;
        this.z = r9;
        if (r9 < (u0.j.a / u0.b)) goto L33;
        return;
    L33:
        if (r6 >= r9) goto L41;
        this.A = r5 + ((r9 - r6) * r8);
        return;
    L41:
        return;
    L26:
        if (N() == true) goto L28;
        r3 = true;
        goto L28
    L18:
        if (r0 == 4) goto L21;
        r4 = false;
        goto L22
    L37:
        return;
    L36:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onClick(View r7) {
        Intrinsics.checkNotNullParameter(r7, "v");
        if (this.b == false) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
        if ((r0 - this.E) < 300) goto L8;
    L10:
        this.E = r0;
        F();
        return;
    L8:
        if (com.bytedance.android.livesdk.gift.platform.core.h.n().h() == false) goto L10;
    }

    public final void R9(View r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        if ((System.currentTimeMillis() - this.u) <= 3000) goto L10;
        View r7 = this.c;
        if (r7 != null) goto L7;
    L9:
        d0.c(1);
        goto L10
    L7:
        if (r7.getVisibility() != 0) goto L9;
        d0.c(0);
    L10:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.d.class).unregisterPerformanceStrategyTask(550);
        this.l = false;
        HSImageView r8 = this.e;
        if (r8 == null) goto L13;
        r8.setController(null);
    L13:
        AnimatedDrawable2 r9 = this.g;
        if (r9 == null) goto L16;
        r9.stop();
    L16:
        this.g = null;
        this.p.clear();
        DataCenter r10 = this.j;
        if (r10 == null) goto L19;
        r10.removeObserver(this);
    L19:
        this.j = null;
        Disposable r11 = this.v;
        if (r11 == null) goto L22;
        r11.dispose();
    L22:
        Disposable r13 = this.w;
        if (r13 == null) goto L26;
        r13.dispose();
        return;
    }

    public final void p4(View r19, final DataCenter r20) {
        Intrinsics.checkNotNullParameter(r19, "view");
        Intrinsics.checkNotNullParameter(r20, "dataCenter");
        if (this.b == false) goto L5;
        return;
    L5:
        long r3 = System.currentTimeMillis();
        this.u = r3;
        this.A = r3;
        this.c = r19;
        this.d = r19.findViewById(2131387276);
        if (com.bytedance.android.livesdk.gift.platform.core.h.n().f() == false) goto L8;
    L9:
        r19.setOnTouchListener(new d(this));
    L10:
        this.e = r19.findViewById(2131362952);
        this.i = r19.findViewById(2131377125);
        this.h = r19.findViewById(2131392581);
        this.j = r20;
        if (r20 == null) goto L13;
        r20.observe("data_is_followed", this);
    L13:
        ILivePreviewBusinessBridge r4 = this.H;
        if (r4 == null) goto L20;
        Observable r5 = r4.observeVHSelect();
        if (r5 == null) goto L20;
        Disposable r6 = r5.subscribe(new e(this));
        if (r6 == null) goto L20;
        RxUtilKt.c(r6, this.p);
    L20:
        ViewParent r7 = null;
        if (u.n() == false) goto L109;
        com.bytedance.android.livesdk.revenue.service.vs.b r1 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.vs.b.class);
        if (r1 != null) goto L25;
        return;
    L25:
        r1.ee();
        View r2 = this.d;
        if (r2 == null) goto L28;
        Intrinsics.checkNotNullParameter(r2, "$this$setVisibilityInVisible");
        UIUtils.setViewVisibility(r2, 4);
    L28:
        HSImageView r8 = this.e;
        if (r8 == null) goto L32;
        r8.setVisibility(8);
    L32:
        if (r1.Lo() == true) goto L34;
    L40:
        Ref.ObjectRef r9 = new Ref.ObjectRef();
        String r10 = BuildConfig.FLAVOR;
        r9.element = BuildConfig.FLAVOR;
        if (A() == null) goto L49;
        jy0.b.a("VS_TOOLBAR", "gift dynamic Icon configDynamicView on cache mIcon");
        py.k r11 = A();
        if (r11 == null) goto L48;
        String r13 = r11.getUri();
        if (r13 == null) goto L48;
        r10 = r13;
    L48:
        r9.element = r10;
        y();
    L50:
        Observable r14 = r1.Pn();
        if (r14 == null) goto L53;
        Disposable r15 = r14.subscribe(new f(this, r9, r1));
    L54:
        this.w = r15;
    L55:
        int r16 = (int) s1.getResources().getDimension(2131169178);
        View r17 = this.d;
        if (r17 == null) goto L58;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
    L59:
        if (r18 == null) goto L61;
        r18.width = r16;
    L61:
        if (r18 == null) goto L63;
        r18.height = r16;
    L63:
        View r21 = this.d;
        if (r21 == null) goto L66;
        r21.setLayoutParams(r18);
    L66:
        View r23 = this.i;
        if (r23 == null) goto L69;
        ViewGroup.LayoutParams r24 = r23.getLayoutParams();
    L70:
        if (r24 == null) goto L72;
        r24.width = r16;
    L72:
        if (r24 == null) goto L74;
        r24.height = r16;
    L74:
        View r25 = this.i;
        if (r25 == null) goto L77;
        r25.setLayoutParams(r24);
    L77:
        View r26 = this.d;
        if (r26 == null) goto L80;
        ViewParent r27 = r26.getParent();
    L82:
        if ((r27 instanceof ViewGroup) == false) goto L364;
        View r28 = this.d;
        if (r28 == null) goto L86;
        ViewParent r29 = r28.getParent();
    L88:
        if ((r29 instanceof ViewGroup) == true) goto L90;
        r29 = null;
    L90:
        ViewGroup r30 = (ViewGroup) r29;
        if (r30 == null) goto L93;
        ViewGroup.LayoutParams r31 = r30.getLayoutParams();
    L94:
        if (r31 == null) goto L96;
        r31.width = r16;
    L96:
        if (r31 == null) goto L365;
        View r33 = this.d;
        if (r33 == null) goto L100;
        ViewParent r34 = r33.getParent();
    L102:
        if ((r34 instanceof ViewGroup) == false) goto L105;
        r7 = r34;
    L105:
        ViewGroup r35 = (ViewGroup) r7;
        if (r35 == null) goto L366;
        r35.setLayoutParams(r31);
        return;
    L366:
        return;
    L100:
        r34 = null;
        goto L102
    L365:
        return;
    L93:
        r31 = null;
        goto L94
    L86:
        r29 = null;
        goto L88
    L364:
        return;
    L80:
        r27 = null;
        goto L82
    L69:
        r24 = null;
        goto L70
    L58:
        r18 = null;
        goto L59
    L53:
        r15 = null;
        goto L54
    L49:
        K();
        goto L50
    L34:
        if (A() == null) goto L40;
        jy0.b.a("VS_TOOLBAR", "gift dynamic Icon configDynamicView direct");
        y();
        Episode r36 = r1.getEpisode();
        if (r36 == null) goto L38;
        String r37 = r36.seasonId;
    L39:
        I(r37);
        goto L55
    L38:
        r37 = null;
        goto L39
    L109:
        com.bytedance.android.live.revenue.core.a r38 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r38 == null) goto L114;
        yz0.k r39 = com.bytedance.android.live.revenue.core.util.f.c(r38, yz0.k.class);
        if (r39 == null) goto L114;
        boolean r40 = r39.isAnchor();
    L115:
        this.k = r40;
        this.L.k1(r40, this.d);
        View r41 = this.d;
        if (r41 == null) goto L118;
        r41.setBackgroundResource(2131252954);
    L118:
        this.L.k1(this.k, this.i);
        if (this.k == true) goto L123;
        ViewUtilsKt.d(r19, com.bytedance.android.live.revenue.common.i.b(38));
        HSImageView r43 = this.e;
        if (r43 == null) goto L123;
        ViewUtilsKt.b(r43, s1.f(-14.0f));
    L123:
        int r44 = i0.a;
        ReadOnlyProperty r45 = com.bytedance.android.livesdk.gift.platform.business.toolbar.a.b;
        KProperty[] r110 = com.bytedance.android.livesdk.gift.platform.business.toolbar.a.a;
        h0 r46 = (h0) r45.getValue(null, r110[0]);
        double r111 = 8.5f;
        if (r111 >= r46.b()) goto L126;
    L130:
        boolean r47 = false;
    L131:
        KmpEnv r112 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L142;
        LiveData r113 = vh6.c.b(tr2.a.class).Ki("live_ui_degrade", new LinkedHashMap());
        if (r113 == null) goto L136;
        Map r114 = (Map) r113.getValue();
    L137:
        if (r114 == null) goto L142;
        Boolean r115 = (Boolean) r114.get("gift_icon_hide");
        if (r115 == null) goto L142;
        r47 = r115.booleanValue();
        goto L142
    L136:
        r114 = null;
    L142:
        if (this.k == true) goto L145;
        if (r47 == false) goto L145;
        boolean r48 = true;
    L146:
        this.r = r48;
        yz0.k r49 = E();
        if (r49 == null) goto L149;
        IRoom r50 = r49.getRoom();
    L151:
        if (r50 != null) goto L154;
        r50 = (IRoom) r20.get("data_room", null);
    L154:
        if (x.b() == true) goto L161;
        if (r50 == null) goto L162;
        IRoomAuthStatus r116 = r50.getRoomAuthStatus();
        if (r116 == null) goto L162;
        if (r116.getEnableGift() == true) goto L161;
    L162:
        boolean r117 = false;
    L163:
        this.x = r117;
        final boolean r118 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k();
        int r119 = 2131248561;
        if (L(r50) == false) goto L222;
        h01.a r120 = this.L;
        RevToolbarConstants r51 = RevToolbarConstants.Gift;
        if (r50 != null) goto L168;
        IRoom r53 = (IRoom) vh7.f.c(IRoom.class);
    L169:
        String r54 = r120.W6(r51, r53, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k(), RevResKeyEnum.STATIC_ICON);
        HSImageView r55 = this.e;
        Function0<Unit> r56 = new ToolbarGiftBehavior$onLoad$controller$1(this, r118, r20);
        if (r50 == null) goto L214;
        if (r55 == null) goto L214;
        yz0.k r57 = u.h();
        if (r57 == null) goto L214;
        if (r57.getActivityRoomSkinInfo() == null) goto L214;
        PipelineDraweeControllerBuilder r58 = Fresco.newDraweeControllerBuilder();
        if (TextUtils.isEmpty(r54) == false) goto L213;
        if (r118 == false) goto L188;
        yz0.k r59 = u.h();
        if (r59 == null) goto L193;
        dq2.a r60 = r59.getActivityRoomSkinInfo();
        if (r60 == null) goto L193;
        Map r61 = r60.b();
    L195:
        if (r61 == null) goto L197;
        py.k r63 = (py.k) r61.get(3);
    L198:
        if (r63 != null) goto L208;
        if (r118 == true) goto L208;
        yz0.k r64 = u.h();
        if (r64 == null) goto L207;
        dq2.a r65 = r64.getActivityRoomSkinInfo();
        if (r65 == null) goto L207;
        Map r66 = r65.b();
        if (r66 == null) goto L207;
        r63 = (py.k) r66.get(3);
    L207:
        r63 = null;
    L208:
        if (r63 == null) goto L212;
        List r67 = r63.getUrls();
        if (r67 == null) goto L212;
        r54 = (String) CollectionsKt.firstOrNull(r67);
    L212:
        r54 = null;
        goto L213
    L197:
        r63 = null;
    L193:
        r61 = null;
        goto L195
    L188:
        yz0.k r68 = u.h();
        if (r68 == null) goto L193;
        dq2.a r69 = r68.getActivityRoomSkinInfo();
        if (r69 == null) goto L193;
        r61 = r69.a();
    L213:
        AbstractDraweeController r70 = r58.setUri(r54).setControllerListener(new j(r56)).build();
        r55.setController(r70);
    L215:
        long r71 = ((Number) com.bytedance.android.livesdk.gift.platform.business.toolbar.a.c.getValue(null, r110[1])).longValue();
        if (r71 <= 0) goto L231;
        Disposable r73 = this.v;
        if (r73 == null) goto L220;
        r73.dispose();
    L220:
        com.bytedance.android.live.core.utils.rxutils.j.a r74 = com.bytedance.android.live.core.utils.rxutils.j.a;
        this.v = com.bytedance.android.live.core.utils.rxutils.j.a(r71, r71, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(r70));
    L231:
        boolean r75 = this.k;
        if (r75 == true) goto L289;
        int r76 = ((Number) com.bytedance.android.livesdk.gift.platform.business.toolbar.a.d.getValue(null, r110[2])).intValue();
        k2 r77 = com.bytedance.android.livesdk.gift.platform.business.a.e();
        if (r76 <= 0) goto L304;
        if (L(r50) == true) goto L304;
        if (r50 == null) goto L243;
        IBaseUser r78 = r50.getOwner();
        if (r78 == null) goto L243;
        if (r78.isFollowing() != true) goto L243;
        long r79 = r77.d() / ((long) this.o);
    L244:
        this.z = r79;
        int r80 = k2.b;
        int r81 = ((Number) com.bytedance.android.livesdk.gift.platform.business.b.n.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[12])).intValue();
        if (r81 != 2) goto L247;
    L250:
        boolean r83 = true;
    L251:
        if (r83 == false) goto L260;
        yz0.k r84 = E();
        if (r84 == null) goto L255;
        boolean r85 = r84.e4();
    L256:
        if (r85 == false) goto L258;
        int r86 = 1;
    L259:
        this.C = r86;
    L261:
        Context r87 = this.J;
        if (r87 == null) goto L285;
        Resources r88 = r87.getResources();
        if (r88 == null) goto L285;
        if (KmpEnv.a() == false) goto L274;
        if (r50 == null) goto L274;
        if (r50.isD3Room() != true) goto L274;
        if (this.x == false) goto L274;
    L284:
        Drawable r89 = r88.getDrawable(r119);
    L286:
        View r90 = this.d;
        if (r90 == null) goto L304;
        r90.setBackgroundDrawable(r89);
    L274:
        if (this.x == false) goto L281;
        if (((Boolean) q.d.getValue()).booleanValue() == false) goto L278;
        int r91 = 2131252955;
    L279:
        r119 = r91;
        goto L284
    L278:
        r91 = 2131252954;
        goto L279
    L281:
        if (((Boolean) q.d.getValue()).booleanValue() == false) goto L283;
        r119 = 2131243763;
        goto L284
    L283:
        r119 = 2131251576;
    L285:
        r89 = null;
        goto L286
    L258:
        r86 = r77.f();
        goto L259
    L255:
        r85 = false;
        goto L256
    L260:
        this.C = -1;
        goto L261
    L247:
        if (r81 == 4) goto L250;
        r83 = false;
    L243:
        r79 = r77.g() / ((long) this.o);
    L304:
        if (this.k == true) goto L345;
        if (com.bytedance.android.livesdk.gift.platform.business.toolbar.c.c() == false) goto L308;
        w();
        goto L345
    L308:
        this.l = !this.x;
        DataCenter r93 = this.j;
        if (r93 == null) goto L311;
        IRoom r94 = (IRoom) r93.get("data_enter_room", null);
    L312:
        if (r94 != null) goto L318;
        DataCenter r95 = this.j;
        if (r95 == null) goto L316;
        r94 = (IRoom) r95.get("data_room", null);
        goto L318
    L316:
        r94 = null;
    L318:
        if (com.bytedance.android.livesdk.gift.platform.business.a.c() == 1) goto L320;
    L322:
        if (r94 != null) goto L324;
    L328:
        if (r94 == null) goto L334;
        IMainRoom r96 = r94.castToOrNull(IMainRoom.class);
        if (r96 == null) goto L334;
        Map r97 = r96.getAnchorAbMap();
        if (r97 == null) goto L334;
        String r98 = (String) r97.get("gift_hide_tip");
    L336:
        if (Intrinsics.areEqual(r98, "2") == true) goto L338;
    L340:
        View r99 = this.c;
        if (r99 == null) goto L343;
        r99.setVisibility(0);
    L343:
        w();
        goto L345
    L338:
        if (this.l == false) goto L340;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(this.j).d(RevToolbarButton.Gift);
    L334:
        r98 = null;
        goto L336
    L324:
        if (r94.isMediaRoom() != true) goto L328;
        if (this.l == false) goto L328;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(this.j).d(RevToolbarButton.Gift);
        goto L345
    L320:
        if (this.l == false) goto L322;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(this.j).d(RevToolbarButton.Gift);
        goto L345
    L311:
        r94 = null;
    L345:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.g.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[5])).booleanValue() == false) goto L350;
        this.y = new m(new WeakReference(this));
        com.bytedance.android.livesdk.revenue.service.performance.d r100 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.d.class);
        m r101 = this.y;
        if (r101 != null) goto L349;
        Intrinsics.throwUninitializedPropertyAccessException("mToolbarDegradeTask");
    L349:
        r100.e6(550, r101);
    L350:
        RxUtilKt.c(w.a("EVENT_WEB_SHOW", new ToolbarGiftBehavior$onLoad$6(this, r20)), this.p);
        RxUtilKt.c(w.a("EVENT_WEB_CLOSE", new ToolbarGiftBehavior$onLoad$7(this, r20)), this.p);
        if (((h2) com.bytedance.android.livesdk.gift.platform.business.a.j.getValue(null, com.bytedance.android.livesdk.gift.platform.business.a.a[8])).a() == true) goto L362;
    L356:
        GiftContext r102 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r102 == null) goto L367;
        com.bytedance.live.datacontext.n<View> r103 = r102.getGiftIcon();
        if (r103 == null) goto L368;
        r103.setValue(r19);
        return;
    L368:
        return;
    L367:
        return;
    L362:
        JatoOptDrawableCache.preloadDrawableCache(s1.getResources(), new int[]{2131251043, 2131251037});     // Catch: Exception -> L355
        goto L356
    L289:
        if (r75 == false) goto L304;
        View r104 = r19.findViewById(2131374718);
        float r105 = 0.5f;
        if (r104 != null) goto L293;
    L297:
        View r106 = r19.findViewById(2131380593);
        if (r106 == null) goto L304;
        if (this.x == false) goto L302;
        r105 = 1.0f;
    L302:
        r106.setAlpha(r105);
        goto L304
    L293:
        if (this.x == false) goto L295;
        float r107 = 1.0f;
    L296:
        r104.setAlpha(r107);
        goto L297
    L295:
        r107 = 0.5f;
    L214:
        r70 = null;
        goto L215
    L168:
        r53 = r50;
        goto L169
    L222:
        if (KmpEnv.a() == false) goto L231;
        if (r50 == null) goto L231;
        if (r50.isD3Room() != true) goto L231;
        if (this.x == false) goto L231;
        View r108 = this.d;
        if (r108 == null) goto L231;
        r108.setBackgroundResource(2131248561);
    L161:
        r117 = true;
        goto L163
    L149:
        r50 = null;
    L145:
        r48 = false;
        goto L146
    L126:
        if (r111 > r46.a()) goto L130;
        if (r46.c() == false) goto L130;
        r47 = true;
    L114:
        r40 = false;
        goto L115
    L8:
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().c() != 2) goto L10;
        goto L9
    }

    public ToolbarGiftBehavior(Context r2, com.bytedance.android.livesdk.revenue.service.toolbar.d r3, h01.a r4, GiftListPreLoadService r5, GiftPanelViewPreloadService r6, GiftListCacheRepo r7, OpenDialogService r8, com.bytedance.android.livesdk.gift.platform.business.anchor.a r9) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bubbleService");
        Intrinsics.checkNotNullParameter(r4, "toolbarService");
        Intrinsics.checkNotNullParameter(r5, "giftListPreLoadService");
        Intrinsics.checkNotNullParameter(r6, "giftPanelViewPreloadService");
        Intrinsics.checkNotNullParameter(r7, "listGlobalCacheRepo");
        Intrinsics.checkNotNullParameter(r8, "openDialogService");
        Intrinsics.checkNotNullParameter(r9, "anchorGiftPanelProviderService");
        this.J = r2;
        this.K = r3;
        this.L = r4;
        this.M = r5;
        this.N = r6;
        this.O = r8;
        this.P = r9;
        this.b = true;
        this.n = BuildConfig.FLAVOR;
        this.o = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        this.p = new CompositeDisposable();
        this.x = true;
        this.z = -1;
        this.A = System.currentTimeMillis();
        this.C = -1;
        NextLiveData<Pair<Integer, Integer>> r10 = new NextLiveData();
        r10.setValue(new Pair(5, -1));
        Unit r11 = Unit.INSTANCE;
        this.G = r10;
        this.I = new c(this);
    }
}
