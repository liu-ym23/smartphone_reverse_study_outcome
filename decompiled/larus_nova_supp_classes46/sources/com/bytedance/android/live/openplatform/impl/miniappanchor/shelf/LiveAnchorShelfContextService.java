package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.base.utils.o;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.ShelfApi;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.k;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorShelfAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.cast.AnchorCastContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.LiveMiniAppChooseDialog;
import com.bytedance.android.live.openplatform.impl.miniappanchor.debug.MiniAppAnchorDebugContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.explaincard.AnchorExplainCardContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.launch.LiveAnchorLaunchContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.memory.MemoryContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.live.LiveShelfManagementActivityV2;
import com.bytedance.android.live.openplatform.impl.miniappcommon.monitor.MiniAppMonitor;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.ud0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomStampInfo;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.google.gson.reflect.TypeToken;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import mh1.p;
import org.json.JSONException;
import org.json.JSONObject;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001;B\u000f\u0012\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J4\u0010\n\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\"\u0010\u0015\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u001b\u001a\u00020\u0005H\u0016J\"\u0010 \u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u001c\u0010\"\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010!\u001a\u0004\u0018\u00010\bH\u0016J@\u0010%\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0016\u0010#\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J0\u0010&\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010#\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0016J \u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\b2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\u0018\u0010)\u001a\u00020\u00052\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\u0006\u0010*\u001a\u00020\u0005R\u0016\u0010+\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010,R\u0016\u00101\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010,R\u0016\u00102\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010,R\u0018\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105¨\u0006<"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/LiveAnchorShelfContextService;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/AnchorShelfContextService;", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomStampInfo;", "stampInfo", "Lkotlin/Function0;", "", "loadButton", "Lkotlin/Function1;", "", "stopLoadCallback", "checkOnRoomEnter", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "shelfInfo", "", "isBeforeStart", "", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfCardInfo;", "buildCardInfoList", "buildClientExtra", "prevShelfInfo", "currShelfInfo", "afterOnModifyShelfSuccess", "updateAnchorCustomTitle", "tryToStartFirstCardExplain", "showExplainGuideOnToolbar", "stopLinkCastIfNeed", "initShelfInfo", "clickAnchorToolbarMiniApp", "clickSource", "liveType", "Lmh1/p;", "miniAppOuterHelper", "openChoosePage", "source", "openShelfManagementPage", "onSuccess", "onFail", "modifyShelf", "onModifyShelfSuccess", "exitSource", "offShelf", "onOffShelfSuccess", "startFirstCardExplain", "isFirstMount", "Z", "Lio/reactivex/disposables/Disposable;", "explainGuideOnToolbarDisposable", "Lio/reactivex/disposables/Disposable;", "hasMountedBeforeStart", "isMountedBeforeStart", "isTalentMountBeforeStart", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/LiveMiniAppChooseDialog;", "chooseDialog", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/LiveMiniAppChooseDialog;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "Companion", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAnchorShelfContextService extends AnchorShelfContextService {
    public static final a Companion = null;
    private static final String TAG = "LiveAnchorShelfContextService";
    private LiveMiniAppChooseDialog chooseDialog;
    private Disposable explainGuideOnToolbarDisposable;
    private boolean hasMountedBeforeStart;
    private boolean isFirstMount;
    private boolean isMountedBeforeStart;
    private boolean isTalentMountBeforeStart;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements ToolbarComponentCheckInterface {
        public final /* synthetic */ LiveAnchorShelfContextService a;

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/openplatform/impl/miniappanchor/shelf/LiveAnchorShelfContextService$b$a", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomStampInfo;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class a extends TypeToken<List<? extends RoomStampInfo>> {
            public a() {
            }
        }

        public b(LiveAnchorShelfContextService r1) {
            this.a = r1;
        }

        public final boolean checkThenLoad(ToolbarMatchInterface r5, Function0<Unit> r6, Function1<? super String, Unit> r7) {
            Intrinsics.checkNotNullParameter(r5, "model");
            Intrinsics.checkNotNullParameter(r6, "loadButton");
            Intrinsics.checkNotNullParameter(r7, "stopLoadCallback");
            String r0 = r5.getComponentExtra();
            int r1 = r5.getSource();
            ShelfInfo r3 = null;
            if (r1 == 0) goto L30;
            if (r1 == 1) goto L47;
        L42:
            return true;
        L47:
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
            Object r8 = Result.constructor-impl((com.bytedance.android.live.openplatform.api.model.shelf.c) GsonHelper.get().fromJson(r5.getComponentExtra(), com.bytedance.android.live.openplatform.api.model.shelf.c.class));     // Catch: Throwable -> L8
        L11:
            if (Result.isFailure-impl(r8) == false) goto L13;
            r8 = null;
        L13:
            com.bytedance.android.live.openplatform.api.model.shelf.c r9 = (com.bytedance.android.live.openplatform.api.model.shelf.c) r8;
            if (r9 == null) goto L16;
            r3 = r9.shelfInfo;
        L16:
            qo0.a.c(LiveAnchorShelfContextService.TAG, "receive toolbar im");
            if (r3 != null) goto L19;
            qo0.a.c(LiveAnchorShelfContextService.TAG, "shelf info is null, stop load button");
            r7.invoke("shelf info is null");
            goto L42
        L19:
            qo0.a.c(LiveAnchorShelfContextService.TAG, "shelf info is not null, load button");
            if (y3.m(LiveAnchorShelfContextService.access$getOpenPlatformContext$p(this.a).getDataCenter()).n(ToolbarButton.OPEN_PLATFORM_MINI_APP) == true) goto L29;
            HashMap<String, zo0.f> r10 = zo0.g.a;
            zo0.f r11 = h.b(PerformanceScene.SNOW_FLAKE);
            r11.o();
            r11.m("is_from_enter", false);
            long r4 = r3.source;
            monitor-enter(r11);
            Intrinsics.checkNotNullParameter("anchor_data_source", "key");     // Catch: Throwable -> L26
            r11.b.putLong("anchor_data_source", r4);     // Catch: Throwable -> L26
            monitor-exit(r11);
        L26:
            th = move-exception;
            throw th;
        L29:
            r6.invoke();
        L8:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L11
        L30:
            Type r13 = new a().getType();
            Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L33
            Object r15 = Result.constructor-impl((List) GsonHelper.get().fromJson(r0, r13));     // Catch: Throwable -> L33
        L36:
            if (Result.isFailure-impl(r15) == false) goto L38;
            r15 = null;
        L38:
            List r16 = (List) r15;
            if (r16 == null) goto L41;
            r3 = (RoomStampInfo) CollectionsKt.lastOrNull(r16);
        L41:
            LiveAnchorShelfContextService.access$checkOnRoomEnter(this.a, r3, r6, r7);
        L33:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            r15 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L36
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LiveAnchorShelfContextService a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Ref.ObjectRef c;
        public final /* synthetic */ Function0 d;
        public final /* synthetic */ Function1 e;

        public c(LiveAnchorShelfContextService r1, boolean r2, Ref.ObjectRef r3, Function0 r4, Function1 r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r11) {
            com.bytedance.android.live.network.response.e r12 = (com.bytedance.android.live.network.response.e) r11;
            qo0.a.c(LiveAnchorShelfContextService.TAG, "request shelf/modify success");
            HashMap<String, zo0.f> r1 = zo0.g.a;
            zo0.f r2 = h.b(PerformanceScene.SHELF_REQUEST);
            r2.b();
            boolean r3 = this.b;
            monitor-enter(r2);
            Intrinsics.checkNotNullParameter("anchor_request_source", "key");     // Catch: Throwable -> L16
            r2.b.putInt("anchor_request_source", r3 ? 1 : 0);     // Catch: Throwable -> L16
            monitor-exit(r2);
            ShelfInfo r4 = ((k) r12.data).a();
            if (r4 == null) goto L9;
            ShelfInfo r5 = (ShelfInfo) this.c.element;
            ShelfInfo r6 = ShelfInfo.a(r4, null, null, r5.isAutoMount, r5.openExtra, r5.entryPagePath, r5.mpLiveChannel, 65535);
        L10:
            if (r6 != null) goto L14;
            qo0.a.b(LiveAnchorShelfContextService.TAG, "shelf/modify return null, logId: " + r12.logId, null);
            Function0 r13 = this.d;
            if (r13 == null) goto L21;
            Unit r14 = (Unit) r13.invoke();
            return;
        L21:
            return;
        L14:
            ((AnchorShelfAppLogContextService) LiveAnchorShelfContextService.access$getOpenPlatformContext$p(this.a).getService(AnchorShelfAppLogContextService.class)).reportAddShelfPageSuccess(this.b, r6);
            this.a.onModifyShelfSuccess(r6, this.e, this.b);
            return;
        L9:
            r6 = null;
        L16:
            th = move-exception;
            throw th;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public d(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            qo0.a.b(LiveAnchorShelfContextService.TAG, "request shelf/modify fail", (Throwable) r3);
            Function0 r4 = this.a;
            if (r4 == null) goto L5;
            Unit r5 = (Unit) r4.invoke();
        L5:
            int r6 = MiniAppMonitor.a;
            MiniAppMonitor.a(MiniAppMonitor.ExceptionType.Mount, "request shelf/modify fail");
            HashMap<String, zo0.f> r7 = zo0.g.a;
            h.b(PerformanceScene.SHELF_REQUEST).n();
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ LiveAnchorShelfContextService a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function0 c;

        public e(LiveAnchorShelfContextService r1, String r2, Function0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
            qo0.a.c(LiveAnchorShelfContextService.TAG, "request shelf/remove success");
            AnchorMiniAppAppLogContextService r7 = (AnchorMiniAppAppLogContextService) LiveAnchorShelfContextService.access$getOpenPlatformContext$p(this.a).getService(AnchorMiniAppAppLogContextService.class);
            AnchorMiniAppDataContext.Companion.getClass();
            AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
            String r1 = "";
            if (r0 == null) goto L12;
            n<ShelfInfo> r2 = r0.m618getShelfInfo();
            if (r2 == null) goto L12;
            ShelfInfo r3 = (ShelfInfo) r2.getValue();
            if (r3 == null) goto L12;
            ShelfMicroAppInfo r4 = r3.appInfo;
            if (r4 == null) goto L12;
            String r8 = r4.appId;
            if (r8 == null) goto L12;
        L13:
            AnchorMiniAppDataContext r9 = AnchorMiniAppDataContext.a.a();
            if (r9 == null) goto L20;
            n<ShelfInfo> r10 = r9.m618getShelfInfo();
            if (r10 == null) goto L20;
            ShelfInfo r11 = (ShelfInfo) r10.getValue();
            if (r11 == null) goto L20;
            r1 = r11.c();
        L20:
            r7.reportAnchorExitBindSuccess(r8, r1, this.b, "app");
            this.a.onOffShelfSuccess(this.c);
            return;
        L12:
            r8 = "";
            goto L13
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r3) {
            qo0.a.b(LiveAnchorShelfContextService.TAG, "request shelf/remove fail", (Throwable) r3);
            int r4 = MiniAppMonitor.a;
            MiniAppMonitor.a(MiniAppMonitor.ExceptionType.Unmount, "request shelf/remove fail");
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ LiveAnchorShelfContextService a;

        public g(LiveAnchorShelfContextService r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            Long r9 = (Long) r8;
            qo0.a.c(LiveAnchorShelfContextService.TAG, "real show explain card guide");
            DataCenter r10 = LiveAnchorShelfContextService.access$getOpenPlatformContext$p(this.a).getDataCenter();
            if (r10 == null) goto L5;
            r10.put("open_platform_toolbar_show_tips", new ko0.f(s1.B(2131921111), 0, 2, 2));
        L5:
            AnchorMiniAppAppLogContextService r11 = (AnchorMiniAppAppLogContextService) LiveAnchorShelfContextService.access$getOpenPlatformContext$p(this.a).getService(AnchorMiniAppAppLogContextService.class);
            ShelfInfo r0 = this.a.getCurShelfInfo();
            if (r0 == null) goto L11;
            ShelfMicroAppInfo r1 = r0.appInfo;
            if (r1 == null) goto L11;
            String r2 = r1.appId;
            if (r2 == null) goto L11;
        L12:
            r11.reportPageShelfBubblePush(r2, "in_live_guide_card_click");
            return;
        L11:
            r2 = "";
            goto L12
        }
    }

    static {
        Companion = new a();
    }

    private final String buildClientExtra() {
        JSONObject r0 = new JSONObject();
        r0.put("live_miniapp_shelf_optimize", 2);     // Catch: JSONException -> L6
    L5:
        return r0.toString();
    }

    private final void showExplainGuideOnToolbar() {
        qo0.a.c(TAG, "start to show explain card guide on toolbar");
        Disposable r0 = RxUtilKt.h(Observable.timer(5, TimeUnit.MINUTES)).subscribe(new g(this));
        this.explainGuideOnToolbarDisposable = r0;
        if (r0 == null) goto L6;
        autoDispose(r0);
        return;
    }

    private final void stopLinkCastIfNeed() {
        boolean r0 = ((IInteractService) jc1.k.n(IInteractService.class)).isLinkCasting();
        AnchorCastContextService r1 = (AnchorCastContextService) getOpenPlatformContext().getService(AnchorCastContextService.class);
        r1.getClass();
        boolean r2 = cp0.d.a();
        int r3 = qo0.a.a;
        qo0.a.c(TAG, "stopLinkCastIfNeed linkCasting:" + r0 + " switching:" + r2);
        if (r0 == true) goto L6;
        if (r2 == true) goto L6;
        return;
    L6:
        if (cp0.d.a() == false) goto L8;
        AnchorCastContextService.f();
    L8:
        ShelfInfo r4 = getCurShelfInfo();
        if (r4 == null) goto L13;
        ShelfMicroAppInfo r5 = r4.appInfo;
        if (r5 == null) goto L13;
        String r6 = r5.appId;
    L14:
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        r1.i(r6, LinkScreenCastType.CAST_TYPE_MINI_APP, "MiniApp offShelf");
        return;
    L13:
        r6 = null;
        goto L14
    }

    public final void startFirstCardExplain() {
        qo0.a.c(TAG, "start first card explain");
        ShelfInfo r0 = getCurShelfInfo();
        if (r0 == null) goto L10;
        List<ShelfCardInfo> r1 = r0.cardInfoList;
        if (r1 == null) goto L11;
        ShelfCardInfo r2 = (ShelfCardInfo) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L12;
        AnchorExplainCardContextService r3 = (AnchorExplainCardContextService) getOpenPlatformContext().getService(AnchorExplainCardContextService.class);
        long r4 = r2.getCardId();
        LiveAnchorShelfContextService$startFirstCardExplain$1$1 r7 = LiveAnchorShelfContextService$startFirstCardExplain$1$1.INSTANCE;
        LiveAnchorShelfContextService$startFirstCardExplain$1$2 r8 = LiveAnchorShelfContextService$startFirstCardExplain$1$2.INSTANCE;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r7, "onSuccess");
        Intrinsics.checkNotNullParameter(r8, "onFail");
        r3.g(r4, 1, r7, r8);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService
    public void clickAnchorToolbarMiniApp() {
        if (isMounted() == false) goto L5;
        HashMap<String, zo0.f> r0 = zo0.g.a;
        zo0.f r1 = h.b(PerformanceScene.SHELF_DIALOG);
        r1.o();
        h.a(r1, "snow_flake");
        MiniAppDataContext.Companion.getClass();
        openShelfDisplayPage(MiniAppDataContext.a.b(), "snow_icon");
        return;
    L5:
        LiveMode r5 = null;
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r2 == null) goto L12;
        m r3 = r2.getRoom();
        if (r3 == null) goto L12;
        Room r4 = (Room) r3.getValue();
        if (r4 == null) goto L12;
        r5 = r4.getStreamType();
    L12:
        int r6 = h1.a;
        AnchorShelfContextService.openChoosePage$default(this, "snow_icon", i1.a(r5), null, 4, null);
    }

    public LiveAnchorShelfContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.isFirstMount = true;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r3 = AnchorMiniAppDataContext.a.a();
        if (r3 == null) goto L8;
        n<ShelfInfo> r4 = r3.m618getShelfInfo();
        if (r4 == null) goto L9;
        i80.a.b(r4, new AnonymousClass1(this));
        return;
    L9:
        return;
    }

    public static final /* synthetic */ Disposable access$getExplainGuideOnToolbarDisposable$p(LiveAnchorShelfContextService r0) {
        return r0.explainGuideOnToolbarDisposable;
    }

    public static final /* synthetic */ OpenPlatformContext access$getOpenPlatformContext$p(LiveAnchorShelfContextService r0) {
        return r0.getOpenPlatformContext();
    }

    private final void tryToStartFirstCardExplain(ShelfInfo r9) {
        qo0.a.c(TAG, "try to start first card explain on mount");
        if (com.bytedance.android.live.openplatform.api.model.shelf.g.c(r9) == true) goto L35;
        List<ShelfCardInfo> r10 = r9.cardInfoList;
        Object r3 = null;
        if (r10 == null) goto L16;
        Iterator<T> r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L15;
        Object r4 = r11.next();
        if (((ShelfCardInfo) r4).getStatus() != 1) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L8;
        r3 = r4;
        goto L15
    L12:
        r5 = false;
    L15:
        r3 = (ShelfCardInfo) r3;
    L16:
        if (r3 == null) goto L19;
        return;
    L19:
        if (((MemoryContextService) getOpenPlatformContext().getService(MemoryContextService.class)).a.b() == false) goto L36;
        qo0.a.c(TAG, "default open first explain card switch is open");
        ShelfInfo r12 = getCurShelfInfo();
        if (r12 == null) goto L28;
        List<ShelfCardInfo> r13 = r12.cardInfoList;
        if (r13 == null) goto L28;
        ShelfCardInfo r14 = (ShelfCardInfo) CollectionsKt.firstOrNull(r13);
        if (r14 == null) goto L28;
        if (r14.getStatus() != 1) goto L28;
        return;
    L28:
        startFirstCardExplain();
        return;
    L36:
        return;
    }

    private final ShelfInfo updateAnchorCustomTitle(ShelfInfo r29) {
        List<ShelfCardInfo> r2 = r29.cardInfoList;
        if (r2 == null) goto L20;
        List<ShelfCardInfo> r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L6:
        if (r5.hasNext() == false) goto L19;
        ShelfCardInfo r6 = (ShelfCardInfo) r5.next();
        if (r6.H0(2) == false) goto L18;
        String r7 = r6.Z();
        if (r7 != null) goto L12;
    L15:
        boolean r8 = true;
    L16:
        if (r8 == true) goto L18;
        r6 = ShelfCardInfo.g(r6, null, null, null, r6.Z(), false, null, 0, 0, null, null, null, 0, null, null, null, null, null, 0, 0, -33, 7);
        goto L18
    L12:
        if (StringsKt.isBlank(r7) == true) goto L15;
        r8 = false;
    L18:
        r4.add(r6);
        goto L6
    L19:
        ArrayList r9 = r4;
    L22:
        return ShelfInfo.a(r29, null, r9, false, null, null, null, 1048573);
    L20:
        r9 = null;
        goto L22
    }

    public final void initShelfInfo(final boolean r3) {
        if (r3 == true) goto L4;
        HashMap<String, zo0.f> r0 = zo0.g.a;
        h.b(PerformanceScene.SHELF_REQUEST).o();
    L4:
        requestShelfInfo(new C03231(this, r3), C03242.INSTANCE);
        Lazy r4 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.e(getOpenPlatformContext().getDataCenter(), NewToolbarButtonConstants.MiniApp.INSTANCE, new b(this));
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService
    public void onOffShelfSuccess(Function0<Unit> r5) {
        this.isMountedBeforeStart = false;
        AnchorShelfAppLogContextService r0 = (AnchorShelfAppLogContextService) getOpenPlatformContext().getService(AnchorShelfAppLogContextService.class);
        MiniAppDataContext.Companion.getClass();
        r0.tryReportCoexistStatusChanged(MiniAppDataContext.a.b(), null, this.isMountedBeforeStart);
        super.onOffShelfSuccess(r5);
        Disposable r6 = this.explainGuideOnToolbarDisposable;
        if (r6 == null) goto L5;
        r6.dispose();
    L5:
        HashMap<String, zo0.f> r7 = zo0.g.a;
        h.b(PerformanceScene.SHELF_REQUEST).n();
    }

    public static final /* synthetic */ void access$setExplainGuideOnToolbarDisposable$p(LiveAnchorShelfContextService r0, Disposable r1) {
        r0.explainGuideOnToolbarDisposable = r1;
    }

    private final List<ShelfCardInfo> buildCardInfoList(ShelfInfo r27, boolean r28) {
        if (r28 == false) goto L25;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r1 = AnchorMiniAppDataContext.a.a();
        if (r1 == null) goto L11;
        m<Integer> r2 = r1.getCoexistComponentBeforeStart();
        if (r2 == null) goto L11;
        Integer r3 = (Integer) r2.getValue();
        if (r3 == null) goto L11;
        int r4 = r3.intValue();
    L12:
        if (r4 == 0) goto L23;
        if (r27 == null) goto L27;
        List<ShelfCardInfo> r0 = r27.cardInfoList;
        if (r0 == null) goto L27;
        List<ShelfCardInfo> r5 = r0;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r7 = r5.iterator();
    L18:
        if (r7.hasNext() == false) goto L34;
        ShelfCardInfo r8 = (ShelfCardInfo) r7.next();
        if (r8.getStatus() != 1) goto L22;
        r8 = ShelfCardInfo.g(r8, null, null, null, null, false, null, 0, 0, null, null, null, 0, null, null, null, null, null, 0, 0, -8193, 7);
    L22:
        r6.add(r8);
        goto L18
    L34:
        return r6;
    L27:
        return null;
    L23:
        if (r27 == null) goto L27;
        return r27.cardInfoList;
    L11:
        r4 = 0;
        goto L12
    L25:
        if (r27 == null) goto L27;
        return r27.cardInfoList;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService
    public void offShelf(String r9, Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r9, "exitSource");
        stopLinkCastIfNeed();
        qo0.a.c(TAG, "request shelf/remove begin");
        Lazy r0 = LiveOpenPlatformClient.c;
        ShelfApi r1 = (ShelfApi) LiveOpenPlatformClient.a.a().a(ShelfApi.class);
        ShelfInfo r2 = getCurShelfInfo();
        if (r2 == null) goto L7;
        ShelfMicroAppInfo r3 = r2.appInfo;
        if (r3 == null) goto L7;
        String r4 = r3.appId;
    L8:
        String r5 = r4;
        long r6 = getOpenPlatformContext().getRoomId();
        ShelfInfo r7 = getCurShelfInfo();
        if (r7 == null) goto L11;
        long r8 = r7.startId;
    L12:
        autoDispose(r1.removeShelf(r5, r6, r8, null).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(this, r9, r10), f.a));
        return;
    L11:
        r8 = -1;
    L7:
        r4 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService
    public void openShelfManagementPage(ShelfInfo r3, String r4) {
        int r5 = LiveShelfManagementActivityV2.i;
        Context r6 = getOpenPlatformContext().getContext();
        Intrinsics.checkNotNullParameter(r6, "context");
        Intent r0 = new Intent(r6, LiveShelfManagementActivityV2.class);
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.putExtra("click_source", r4);
        Unit r7 = Unit.INSTANCE;
        r6.startActivity(r0);
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_openplatform_impl_miniappanchor_shelf_LiveAnchorShelfContextService_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_showNow(LiveMiniAppChooseDialog r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        LiveMiniAppChooseDialog r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.showNow(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    private final void afterOnModifyShelfSuccess(ShelfInfo r3, ShelfInfo r4, boolean r5) {
        if (r3 != null) goto L5;
        tryToStartFirstCardExplain(r4);
    L5:
        if (this.isFirstMount == false) goto L11;
        qo0.a.c(TAG, "mount miniapp for the first time");
        this.isFirstMount = false;
        if (com.bytedance.android.live.openplatform.api.model.shelf.g.c(r4) == true) goto L11;
        if (((AnchorExplainCardContextService) getOpenPlatformContext().getService(AnchorExplainCardContextService.class)).a == true) goto L11;
        showExplainGuideOnToolbar();
    L11:
        if (r5 == false) goto L13;
        this.isTalentMountBeforeStart = r4.e();
    L13:
        ((AnchorShelfAppLogContextService) getOpenPlatformContext().getService(AnchorShelfAppLogContextService.class)).tryReportCoexistStatusChanged(r3, r4, this.isMountedBeforeStart);
    }

    private final void checkOnRoomEnter(RoomStampInfo r5, final Function0<Unit> r6, final Function1<? super String, Unit> r7) {
        if (r5 != null) goto L11;
        qo0.a.c(TAG, "receive enter im, stamp info is null");
        if (((Boolean) ud0.a.getValue()).booleanValue() == true) goto L7;
        qo0.a.c(TAG, "no mount before start, old path, stop load button");
        r7.invoke("stamps is empty");
        return;
    L7:
        if (this.hasMountedBeforeStart == false) goto L9;
        qo0.a.c(TAG, "has mounted before start, new path, wait until the toolbar im is received, stop load button");
        r7.invoke("has mounted before start");
        return;
    L9:
        HashMap<String, zo0.f> r8 = zo0.g.a;
        zo0.f r9 = h.b(PerformanceScene.SNOW_FLAKE);
        r9.o();
        r9.m("is_from_enter", true);
        qo0.a.c(TAG, "no mount before start, new path, load button");
        r6.invoke();
        return;
    L11:
        qo0.a.c(TAG, "receive enter im, stamp info is not null");
        if (r5.getStatus() == 0) goto L16;
        if (r5.getStatus() == 1) goto L16;
        return;
    L16:
        if (r5.getType() != 4) goto L23;
        HashMap<String, zo0.f> r10 = zo0.g.a;
        zo0.f r11 = h.b(PerformanceScene.SNOW_FLAKE);
        r11.o();
        r11.m("is_from_enter", true);
        qo0.a.c(TAG, "the type of stamp info is mini app, start to request shelf info");
        h.b(PerformanceScene.SHELF_REQUEST).o();
        requestShelfInfo(new C03221(this, r7, r6), new AnonymousClass2(r7));
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService
    public void onModifyShelfSuccess(ShelfInfo r3, Function1<? super ShelfInfo, Unit> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "shelfInfo");
        ShelfInfo r0 = getCurShelfInfo();
        super.onModifyShelfSuccess(updateAnchorCustomTitle(updateAnchorLiveStatus(!r5 ? 1 : 0, r3)), r4, r5);
        ShelfInfo r6 = getCurShelfInfo();
        Intrinsics.checkNotNull(r6);
        afterOnModifyShelfSuccess(r0, r6, r5);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService
    public void openChoosePage(String r6, String r7, p r8) {
        Intrinsics.checkNotNullParameter(r6, "clickSource");
        Intrinsics.checkNotNullParameter(r7, "liveType");
        HashMap<String, zo0.f> r0 = zo0.g.a;
        PerformanceScene r1 = PerformanceScene.CHOOSE_PAGE;
        h.b(r1).o();
        zo0.a.a(r1).a();
        if (this.chooseDialog != null) goto L6;
        LiveMiniAppChooseDialog r2 = new LiveMiniAppChooseDialog();
        r2.setNoTitleAndCancelOutside(true);
        r2.setBottomSheetSlideProcessor(new com.bytedance.android.live.openplatform.impl.miniappanchor.choose.b());
        this.chooseDialog = r2;
    L6:
        if ((getOpenPlatformContext().getContext() instanceof FragmentActivity) == false) goto L16;
        FragmentManager r3 = getOpenPlatformContext().getContext().getSupportFragmentManager();
        if (r3.findFragmentByTag("LiveMiniAppChooseDialog") != null) goto L17;
        LiveMiniAppChooseDialog r4 = this.chooseDialog;
        if (r4 == null) goto L12;
        r4.e = new com.bytedance.android.live.openplatform.impl.miniappanchor.choose.c(r6, r7, this.isTalentMountBeforeStart, r8);
    L12:
        LiveMiniAppChooseDialog r9 = this.chooseDialog;
        if (r9 == null) goto L18;
        INVOKEVIRTUAL_com_bytedance_android_live_openplatform_impl_miniappanchor_shelf_LiveAnchorShelfContextService_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_showNow(r9, r3, "LiveMiniAppChooseDialog");
        return;
    L18:
        return;
    L17:
        return;
    }

    public static final /* synthetic */ void access$checkOnRoomEnter(LiveAnchorShelfContextService r0, RoomStampInfo r1, Function0 r2, Function1 r3) {
        r0.checkOnRoomEnter(r1, r2, r3);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService
    public void modifyShelf(ShelfInfo r34, boolean r35, Function1<? super ShelfInfo, Unit> r36, Function0<Unit> r37) {
        Intrinsics.checkNotNullParameter(r34, "shelfInfo");
        HashMap<String, zo0.f> r1 = zo0.g.a;
        h.b(PerformanceScene.SHELF_REQUEST).o();
        if (r35 == false) goto L5;
        this.hasMountedBeforeStart = true;
        this.isMountedBeforeStart = true;
    L5:
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        r3.element = r34;
        MiniAppAnchorDebugContextService r2 = (MiniAppAnchorDebugContextService) getOpenPlatformContext().getService(MiniAppAnchorDebugContextService.class);
        ShelfMicroAppInfo r4 = r34.appInfo;
        if (r4 == null) goto L10;
        String r5 = r4.schema;
        if (r5 == null) goto L10;
        String r6 = com.bytedance.android.live.openplatform.api.utils.h.a(r5);
    L11:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "appId");
        if (Intrinsics.areEqual(r2.b, r6) == false) goto L34;
        ShelfMicroAppInfo r7 = r34.appInfo;
        if (r7 == null) goto L21;
        MiniAppAnchorDebugContextService r8 = (MiniAppAnchorDebugContextService) getOpenPlatformContext().getService(MiniAppAnchorDebugContextService.class);
        ShelfMicroAppInfo r9 = r34.appInfo;
        if (r9 == null) goto L19;
        String r10 = r9.schema;
        if (r10 == null) goto L19;
    L20:
        ShelfMicroAppInfo r11 = ShelfMicroAppInfo.a(r7, r8.h(r10), 0, 55);
    L22:
        List<ShelfCardInfo> r12 = r34.cardInfoList;
        if (r12 == null) goto L32;
        List<ShelfCardInfo> r13 = r12;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r15 = r13.iterator();
    L26:
        if (r15.hasNext() == false) goto L31;
        ShelfCardInfo r16 = (ShelfCardInfo) r15.next();
        MiniAppAnchorDebugContextService r17 = (MiniAppAnchorDebugContextService) getOpenPlatformContext().getService(MiniAppAnchorDebugContextService.class);
        String r18 = r16.a0();
        if (r18 != null) goto L30;
        r18 = "";
    L30:
        r14.add(ShelfCardInfo.g(r16, r17.h(r18), null, null, null, false, null, 0, 0, null, null, null, 0, null, null, null, null, null, 0, 0, -5, 7));
        goto L26
    L31:
        ArrayList r19 = r14;
    L33:
        r3.element = ShelfInfo.a(r34, r11, r19, false, null, null, null, 1048572);
        goto L34
    L32:
        r19 = null;
    L19:
        r10 = "";
        goto L20
    L21:
        r11 = null;
    L34:
        ((AnchorShelfAppLogContextService) getOpenPlatformContext().getService(AnchorShelfAppLogContextService.class)).reportPageShelfSubmitAudit((ShelfInfo) r3.element);
        qo0.a.c(TAG, "request shelf/modify begin");
        Lazy r0 = LiveOpenPlatformClient.c;
        ShelfApi r20 = (ShelfApi) LiveOpenPlatformClient.a.a().a(ShelfApi.class);
        ShelfMicroAppInfo r21 = ((ShelfInfo) r3.element).appInfo;
        if (r21 == null) goto L37;
        String r22 = r21.appId;
    L38:
        long r23 = getOpenPlatformContext().getRoomId();
        long r110 = ((ShelfInfo) r3.element).startId;
        long r111 = ((LiveAnchorLaunchContextService) getOpenPlatformContext().getService(LiveAnchorLaunchContextService.class)).getLaunchSource().getValue();
        ShelfInfo r24 = (ShelfInfo) r3.element;
        ShelfMicroAppInfo r25 = r24.appInfo;
        if (r25 == null) goto L41;
        String r112 = r25.schema;
    L42:
        List<ShelfCardInfo> r113 = buildCardInfoList(r24, r35);
        ShelfInfo r26 = (ShelfInfo) r3.element;
        int r27 = r26.mountType;
        String r28 = r26.openExtra;
        String r29 = buildClientExtra();
        String r30 = ((ShelfInfo) r3.element).mpLiveChannel;
        if (r30 != null) goto L45;
        r30 = "bind";
    L45:
        autoDispose(r20.modifyShelf(new com.bytedance.android.live.openplatform.impl.miniappanchor.api.request.b(r22, r23, r110, r111, r112, r35, r113, r27, r30, r28, r29)).compose(RxUtil.rxSchedulerHelper()).doOnError(new o(null)).subscribe(new c(this, r35, r3, r37, r36), new d(r37)));
        return;
    L41:
        r112 = null;
        goto L42
    L37:
        r22 = null;
    L10:
        r6 = "";
        goto L11
    }
}
