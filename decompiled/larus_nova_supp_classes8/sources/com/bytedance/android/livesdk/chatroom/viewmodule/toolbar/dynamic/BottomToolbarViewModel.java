package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.AnchorMainPostOptUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.chatroom.utils.SkinLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarBroadcastFunction;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.stats.ToolbarLoadTimeStatsVM;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.f3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.sq;
import com.bytedance.android.livesdk.config.wh1;
import com.bytedance.android.livesdk.config.xh1;
import com.bytedance.android.livesdk.message.model.dm;
import com.bytedance.android.livesdk.toolbarservice.api.IToolbarService;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.toolbar.ToolbarExtraInfo;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveOpenFeatureChooseConfig;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 n2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001oB!\u0012\b\u00100\u001a\u0004\u0018\u00010/\u0012\u0006\u0010h\u001a\u00020g\u0012\u0006\u0010j\u001a\u00020&¢\u0006\u0004\bl\u0010mJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001a\u0010\u000e\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0002J,\u0010\u0012\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00050\u000fH\u0002J\u001a\u0010\u0013\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0003J\n\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0014J\u0018\u0010%\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010#J\u000e\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)H\u0016J\u0012\u0010.\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J(\u00107\u001a\u00020\u00052\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u0002032\b\u00106\u001a\u0004\u0018\u000105J(\u00107\u001a\u00020\u00052\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u00020)2\b\u00106\u001a\u0004\u0018\u000105J\u001f\u0010;\u001a\b\u0012\u0004\u0012\u00020:092\b\u00108\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b;\u0010<J\u0012\u0010=\u001a\u0004\u0018\u00010\u001e2\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u0010?\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u001cH\u0016J\u0010\u0010B\u001a\u00020\u00052\u0006\u0010A\u001a\u00020@H\u0016J\u0012\u0010C\u001a\u0004\u0018\u00010@2\u0006\u0010*\u001a\u00020)H\u0016J\u0018\u0010H\u001a\u00020\u00052\u0006\u0010E\u001a\u00020D2\b\u0010G\u001a\u0004\u0018\u00010FJ\u000e\u0010I\u001a\b\u0012\u0004\u0012\u00020)09H\u0016J\u0010\u0010J\u001a\u00020&2\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u0010L\u001a\u00020)2\u0006\u0010K\u001a\u00020)H\u0016J\u0010\u0010M\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016R\u0018\u0010N\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010Q\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u001b\u0010U\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u0018\u0010X\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010^\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010`R\u0018\u0010b\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0014\u0010d\u001a\u0002018\u0002X\u0082D¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010fR\u0014\u0010h\u001a\u00020g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0017\u0010j\u001a\u00020&8\u0006¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bj\u0010V¨\u0006p"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/BottomToolbarViewModel;", "Landroidx/lifecycle/ViewModel;", "Lvlc/l;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/m;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/o;", "", "registerPlaceHold", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "verifyEnterToolbarData", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveToolbarData;", "toolbarData", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/ToolbarOperateManager;", "toolbarOperateManager", "startCountDownVerify", "Lkotlin/Function2;", "", "onSuccess", "doubleCheckToolbarData", "updateToolbarDataInRoom", "it", "updateCommerceData", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/r$a;", "event", "onToolbarEvent", "Lcom/bytedance/android/livesdk/message/model/dm;", "msg", "logMsgDebugInfo", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/NewToolbarButtonConstants;", "constant", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/s;", "createButtonModel", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/n;", "getCheckManager", "onCleared", "Lot2/e;", "toolbarInitLoadListener", "onRoomUiLoadFinished", "", "skipClearForReload", "onRoomUiDestory", "", "id", "refreshExistComponent", "Ltlc/d;", "message", "onMessage", "Landroid/content/Context;", "context", "", "roomId", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarBroadcastFunction;", "to", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/i;", "actionCallback", "openChangeDialog", "curIsAnchor", "", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarButton;", "getFoldButtons", "(Ljava/lang/Boolean;)Ljava/util/List;", "findContainButtonById", "type", "compactLoadFromSei", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/a0;", "config", "register", "getToolbarConfig", "Lot2/a;", "container", "Lot2/d;", "viewContainer", "initContainer", "getAllShowedDataListIds", "isComponentShowing", "groupId", "getComponentByGroupId", "getComponentIndex", "mRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/d;", "replaceManager", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/d;", "isAnchor$delegate", "Lkotlin/Lazy;", "isAnchor", "()Z", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/r;", "dataManager", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/r;", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/k;", "componentConfigManager", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/k;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/ToolbarOperateManager;", "Lot2/c;", "implProxy", "Lot2/c;", "VERIFY_DELAY_TIME", "J", "Landroid/content/Context;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "isAnchorFromInit", "Z", "<init>", "(Landroid/content/Context;Lcom/bytedance/ies/sdk/widgets/DataCenter;Z)V", "Companion", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomToolbarViewModel extends ViewModel implements vlc.l, m, o {
    public static final a Companion = null;
    private final long VERIFY_DELAY_TIME;
    private CompositeDisposable cd;
    private final k componentConfigManager;
    private Context context;
    private final DataCenter dataCenter;
    private r dataManager;
    private ot2.c implProxy;
    private final Lazy isAnchor$delegate;
    private final boolean isAnchorFromInit;
    private Room mRoom;
    private final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.d replaceManager;
    private final ToolbarOperateManager toolbarOperateManager;

    public static final class a {
        public a() {
        }

        public static BottomToolbarViewModel a(DataCenter r5) {
            ViewModel r0 = null;
            if (r5 != null) goto L5;
            return null;
        L5:
            RoomContext r6 = RoomContext.a.c(RoomContext.Companion, r5, 0, 2);
            if (r6 == null) goto L10;
            com.bytedance.live.datacontext.j r7 = r6.getCommonSlotViewModel();
            if (r7 == null) goto L10;
            ViewModel r8 = (ViewModel) r7.getValue();
        L12:
            if ((r8 instanceof BottomToolbarViewModel) == false) goto L16;
            r0 = r8;
        L16:
            return (BottomToolbarViewModel) r0;
        L10:
            r8 = null;
            goto L12
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ BottomToolbarViewModel a;
        public final /* synthetic */ Room b;
        public final /* synthetic */ Function2 c;

        public b(BottomToolbarViewModel r1, Room r2, Function2 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            Response r5 = (Response) r4;
            if (r5 == null) goto L8;
            Room r6 = (Room) ((BaseResponse) r5).data;
            if (r6 == null) goto L9;
            BottomToolbarViewModel.access$updateCommerceData(this.a, r6);
            BottomToolbarViewModel.access$updateToolbarDataInRoom(this.a, this.b, r6.getToolbarData());
            BottomToolbarViewModel.access$getDataCenter$p(this.a).put("cmd_new_toolbar_double_check", "commerce");
            this.c.invoke("Double check Success", r6.getToolbarData());
            return;
        L9:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Function2 a;
        public final /* synthetic */ Room b;

        public c(Function2 r1, Room r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            ALogger.i("NewToolbarLog", "Double Check Toolbar Data Error: " + ((Throwable) r3));
            this.a.invoke("Double Check Error", this.b.getToolbarData());
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ BottomToolbarViewModel a;

        public d(BottomToolbarViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            r.a r3 = (r.a) r2;
            if (r3 == null) goto L7;
            q.c = -1;
            BottomToolbarViewModel.access$onToolbarEvent(this.a, r3);
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            if (com.bytedance.android.live.core.utils.v.a() == true) goto L9;
            ALogger.e("NewToolbarLog", "Action Event Crash.");
            q.b("Action Event Crash.");
            if (r4 != null) goto L7;
            r4 = new Throwable("NewToolbarLog");
        L7:
            SafetyGuard.a(null, r4, "NewToolbarLog Action Crash");
            return;
        L9:
            throw r4;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ BottomToolbarViewModel a;
        public final /* synthetic */ ToolbarOperateManager b;

        public f(BottomToolbarViewModel r1, ToolbarOperateManager r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r17) {
            Long r1 = (Long) r17;
            ToolbarLoadTimeStatsVM.a r2 = ToolbarLoadTimeStatsVM.Companion;
            RoomContext.a r3 = RoomContext.Companion;
            RoomContext r4 = RoomContext.a.c(r3, BottomToolbarViewModel.access$getDataCenter$p(this.a), 0, 2);
            r2.getClass();
            ToolbarLoadTimeStatsVM.a.b(r4).printStatsTime(BottomToolbarViewModel.access$isAnchor$p(this.a));
            RoomContext r5 = RoomContext.a.c(r3, BottomToolbarViewModel.access$getDataCenter$p(this.a), 0, 2);
            if (r5 == null) goto L14;
            com.bytedance.live.datacontext.n r6 = r5.getCurToolbarList();
            if (r6 == null) goto L14;
            List r7 = (List) r6.getValue();
            if (r7 == null) goto L14;
            ArrayList r8 = new ArrayList();
            Iterator<T> r9 = r7.iterator();
        L10:
            if (r9.hasNext() == false) goto L15;
            T r10 = r9.next();
            if ((!((s) r10).l.b) == false) goto L10;
            r8.add(r10);
        L15:
            ArrayList<s> r11 = this.b.c;
            HashSet r12 = new HashSet();
            if (r8 == null) goto L34;
            Iterator<T> r13 = r8.iterator();
        L19:
            if (r13.hasNext() == false) goto L34;
            s r14 = (s) r13.next();
            ToolbarButton r15 = f3.b(r14, BottomToolbarViewModel.access$isAnchor$p(this.a), false);
            Iterator<s> r16 = r11.iterator();
        L22:
            if (r16.hasNext() == false) goto L29;
            s r18 = r16.next();
            if (r18.a != r14.a) goto L26;
            boolean r19 = true;
        L27:
            if (r19 == false) goto L22;
        L30:
            s r110 = r18;
            if (r15 == null) goto L19;
            if (r110 != null) goto L19;
            r12.add(Integer.valueOf(r14.a));
            goto L19
        L26:
            r19 = false;
            goto L27
        L29:
            r18 = null;
        L34:
            HashSet r20 = new HashSet();
            Iterator<s> r21 = r11.iterator();
        L36:
            if (r21.hasNext() == false) goto L40;
            s r111 = r21.next();
            if (y3.m(BottomToolbarViewModel.access$getDataCenter$p(this.a)).n(f3.b(r111, BottomToolbarViewModel.access$isAnchor$p(this.a), false)) == true) goto L36;
            r20.add(Integer.valueOf(r111.a));
            goto L36
        L40:
            RoomContext r22 = RoomContext.a.c(RoomContext.Companion, BottomToolbarViewModel.access$getDataCenter$p(this.a), 0, 2);
            if (r22 == null) goto L47;
            com.bytedance.live.datacontext.m r23 = r22.isCleanMode();
            if (r23 == null) goto L47;
            if (((Boolean) r23.getValue()).booleanValue() != true) goto L47;
            r20.clear();
            ALogger.i("NewToolbarLog", "check when is in clear mode");
        L47:
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.b r24 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.b.b;
            boolean r25 = BottomToolbarViewModel.access$isAnchor$p(this.a);
            Intrinsics.checkNotNullParameter(r12, "loadErrorIds");
            Intrinsics.checkNotNullParameter(r20, "showErrorIds");
            if (r8 == null) goto L67;
            ArrayList r26 = new ArrayList();
            Iterator<T> r27 = r8.iterator();
        L51:
            if (r27.hasNext() == false) goto L58;
            T r28 = r27.next();
            if (((s) r28).f != 0) goto L55;
            boolean r112 = true;
        L56:
            if (r112 == false) goto L51;
            r26.add(r28);
            goto L51
        L55:
            r112 = false;
            goto L56
        L58:
            Iterator r29 = r26.iterator();
        L60:
            if (r29.hasNext() == false) goto L67;
            s r30 = (s) r29.next();
            if (r12.contains(Integer.valueOf(r30.a)) == true) goto L60;
            if (r20.contains(Integer.valueOf(r30.a)) == true) goto L60;
            r24.a(r30.a, "Success", r25);
        L67:
            if (r12.isEmpty() == true) goto L69;
        L71:
            Iterator r31 = r12.iterator();
        L73:
            if (r31.hasNext() == false) goto L75;
            r24.a(((Number) r31.next()).intValue(), "LoadError", r25);
            goto L73
        L75:
            Iterator r32 = r20.iterator();
        L77:
            if (r32.hasNext() == false) goto L79;
            r24.a(((Number) r32.next()).intValue(), "ShowError", r25);
            goto L77
        L79:
            q.a.clear();
            return;
        L69:
            if (r20.isEmpty() == false) goto L71;
            return;
        L14:
            r8 = null;
            goto L15
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    static {
        Companion = new a();
    }

    private final boolean isAnchor() {
        return ((Boolean) this.isAnchor$delegate.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m
    public List<Integer> getAllShowedDataListIds() {
        ot2.c r0 = this.implProxy;
        if (r0 == null) goto L9;
        List<Integer> r1 = r0.p5(ot2.a.a.a);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ArrayList();
    L9:
        return new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m
    public n getCheckManager() {
        ot2.c r0 = this.implProxy;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCheckManager();
    }

    public void onCleared() {
        ot2.c r0 = this.implProxy;
        if (r0 == null) goto L7;
        if (r0 == null) goto L9;
        r0.onCleared();
        return;
    L9:
        return;
    L7:
        super.onCleared();
        this.cd.dispose();
        this.context = null;
        ALogger.i("NewToolbarLog", "vm clear finish this is :" + hashCode());
    }

    private final void registerPlaceHold() {
        if (isAnchor() == false) goto L5;
    L8:
        Lazy r0 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.f(this.dataCenter, NewToolbarButtonConstants.LittleGame.INSTANCE);
        ToolbarComponentCheckManager.f(this.dataCenter, NewToolbarButtonConstants.GamePromote.INSTANCE);
        ToolbarComponentCheckManager.f(this.dataCenter, NewToolbarButtonConstants.MiniApp.INSTANCE);
        return;
    L5:
        if (xh1.a.getValue().booleanValue() == false) goto L7;
        Lazy r1 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.f(this.dataCenter, NewToolbarButtonConstants.CommerceCart.INSTANCE);
        ToolbarComponentCheckManager.f(this.dataCenter, NewToolbarButtonConstants.ToolbarCommerceIM.INSTANCE);
        ToolbarComponentCheckManager.f(this.dataCenter, NewToolbarButtonConstants.TransformWidget.INSTANCE);
    L7:
        Lazy r2 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.f(this.dataCenter, NewToolbarButtonConstants.MiniGame.INSTANCE);
        ToolbarComponentCheckManager.f(this.dataCenter, NewToolbarButtonConstants.ToolbarShare.INSTANCE);
        ToolbarComponentCheckManager.f(this.dataCenter, NewToolbarButtonConstants.ToolbarIM.INSTANCE);
        ToolbarComponentCheckManager.f(this.dataCenter, NewToolbarButtonConstants.LifeGroupon.INSTANCE);
        goto L8
    }

    public final boolean isAnchorFromInit() {
        return this.isAnchorFromInit;
    }

    public static final /* synthetic */ DataCenter access$getDataCenter$p(BottomToolbarViewModel r0) {
        return r0.dataCenter;
    }

    public static final /* synthetic */ r access$getDataManager$p(BottomToolbarViewModel r0) {
        return r0.dataManager;
    }

    public static final /* synthetic */ ToolbarOperateManager access$getToolbarOperateManager$p(BottomToolbarViewModel r0) {
        return r0.toolbarOperateManager;
    }

    public static final /* synthetic */ boolean access$isAnchor$p(BottomToolbarViewModel r0) {
        return r0.isAnchor();
    }

    @Deprecated(message = "compact")
    private final s createButtonModel(NewToolbarButtonConstants r4) {
        s r0 = new s();
        r0.a = r4.getId();
        r0.f = r4.getGroupId();
        r0.l.b = false;
        if (Intrinsics.areEqual(r4, NewToolbarButtonConstants.MiniGame.INSTANCE) == false) goto L5;
        String r5 = "小游戏";
    L6:
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r0.b = r5;
        return r0;
    L5:
        r5 = "小程序";
        goto L6
    }

    private final void logMsgDebugInfo(dm r6) {
        StringBuilder r0 = new StringBuilder("Receive msg:");
        r0.append(r6.getComponentType());
        r0.append(" ");
        r0.append(r6.getText());
        r0.append(" ");
        int r2 = r6.getEventType();
        if (r2 != 1) goto L5;
        String r3 = "UP";
    L18:
        r0.append(r3);
        r0.append(" ");
        int r4 = r6.getOpType();
        if (r4 == 0) goto L23;
        if (r4 == 1) goto L22;
        String r5 = String.valueOf(r6.getOpType());
    L24:
        r0.append(r5);
        r0.append(" ");
        CommonMessageData r7 = ((BaseMessage) r6).baseMessage;
        if (r7 == null) goto L28;
        String r8 = r7.logId;
        if (r8 == null) goto L28;
    L29:
        r0.append(r8);
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L32;
        r0.append(" ");
        r0.append(r6.getExtraData());
    L32:
        ALogger.i("NewToolbarLog", r0.toString());
        return;
    L28:
        r8 = "";
        goto L29
    L22:
        r5 = "toMore";
        goto L24
    L23:
        r5 = "toToolbar";
        goto L24
    L5:
        if (r2 != 2) goto L7;
        r3 = "DOWN";
        goto L18
    L7:
        if (r2 != 3) goto L9;
        r3 = "HasPermission";
        goto L18
    L9:
        if (r2 != 4) goto L11;
        r3 = "NoPermission";
        goto L18
    L11:
        if (r2 == 5) goto L13;
        r3 = "unknown action：" + String.valueOf(r6.getEventType());
        goto L18
    L13:
        r3 = "UPDATE";
        goto L18
    }

    private final void onToolbarEvent(final r.a r6) {
        if ((r6 instanceof r.b) == false) goto L37;
        StringBuilder r0 = new StringBuilder("onToolbarEvent:");
        r.b r1 = (r.b) r6;
        s r4 = r1.c;
        if (r4 == null) goto L7;
        String r5 = r4.toString();
    L8:
        r0.append(r5);
        r0.append("-");
        r0.append(r1.d.toString());
        r0.append("-");
        r0.append(r6.a);
        r0.append("-");
        r0.append(r6.b);
        ALogger.i("NewToolbarLog", r0.toString());
        switch(r6.a) {
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L15;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L69;
        };
    L11:
        final ToolbarOperateManager r2 = this.toolbarOperateManager;
        final s r7 = ((r.b) r6).d;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r7, "model");
        r2.d("refresh", r7, new ToolbarOperateManager$refreshComponent$1(r2, r7));
        return;
    L12:
        r.b r3 = (r.b) r6;
        s r8 = r3.c;
        if (r8 == null) goto L58;
        this.toolbarOperateManager.h(r8);
        this.toolbarOperateManager.a(r3.c);
        this.toolbarOperateManager.d("switch", r3.d, new BottomToolbarViewModel$onToolbarEvent$$inlined$let$lambda$1(this, r6));
        return;
    L58:
        return;
    L15:
        ToolbarOperateManager r9 = this.toolbarOperateManager;
        s r10 = ((r.b) r6).d;
        Integer r11 = r6.b;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "toolbarButton");
        if (r11 == null) goto L21;
        boolean r12 = true;
        if (r11.intValue() != 1) goto L21;
    L22:
        DataCenter r13 = r9.d;
        if (r12 == false) goto L25;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r14 = y3.f(r13);
    L26:
        k r15 = r9.b;
        if (r15 == null) goto L31;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r16 = r15.a(r10, r12, r9.e());
        if (r16 == null) goto L31;
        r14.e(r10, r16);
        ALogger.i("NewToolbarLog", r10.toString() + " updating " + r16.getClass().getSimpleName());
        return;
    L31:
        ALogger.e("NewToolbarLog", "error, updating an unload behavior.");
        return;
    L25:
        r14 = y3.m(r13);
    L21:
        r12 = false;
        goto L22
    L32:
        r.b r17 = (r.b) r6;
        this.toolbarOperateManager.h(r17.d);
        this.toolbarOperateManager.g(r17.d);
        return;
    L33:
        this.toolbarOperateManager.h(((r.b) r6).d);
        return;
    L34:
        r.b r18 = (r.b) r6;
        this.toolbarOperateManager.h(r18.d);
        this.toolbarOperateManager.a(r18.d);
        return;
    L35:
        this.toolbarOperateManager.d("up", ((r.b) r6).d, new C04421(this));
        return;
    L69:
        return;
    L7:
        r5 = null;
        goto L8
    L37:
        if ((r6 instanceof r.c) == false) goto L66;
        ALogger.i("NewToolbarLog", "onToolbarEvent:" + r6.a + "-" + r6.b);
        int r19 = r6.a;
        if (r19 != 100) goto L41;
        final ToolbarOperateManager r20 = this.toolbarOperateManager;
        List<s> r21 = ((r.c) r6).c;
        r20.c.clear();
        if (r21 == null) goto L68;
        Iterator<T> r22 = r21.iterator();
    L53:
        if (r22.hasNext() == false) goto L72;
        final s r23 = (s) r22.next();
        AnchorMainPostOptUtils.b("toolbar " + r23.b, new ToolbarOperateManager$initToolbarData$$inlined$forEach$lambda$1(r23, r20));
        goto L53
    L72:
        return;
    L68:
        return;
    L41:
        if (r19 != 101) goto L70;
        ToolbarOperateManager r24 = this.toolbarOperateManager;
        List<s> r25 = ((r.c) r6).c;
        r24.getClass();
        if (r25 == null) goto L67;
        Iterator<T> r26 = r25.iterator();
    L47:
        if (r26.hasNext() == false) goto L71;
        s r27 = (s) r26.next();
        AnchorMainPostOptUtils.b("more " + r27.b, new h0(r27, r24));
        goto L47
    L71:
        return;
    L67:
        return;
    L70:
        return;
    }

    private final void updateCommerceData(Room r7) {
        RoomContext.a r0 = RoomContext.Companion;
        RoomContext r1 = RoomContext.a.c(r0, this.dataCenter, 0, 2);
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L9;
        Room r3 = (Room) r2.getValue();
        if (r3 == null) goto L9;
        r3.setRoomCart(r7.getRoomCart());
    L9:
        RoomContext r4 = RoomContext.a.c(r0, this.dataCenter, 0, 2);
        if (r4 == null) goto L17;
        com.bytedance.live.datacontext.m r5 = r4.getRoom();
        if (r5 == null) goto L18;
        Room r6 = (Room) r5.getValue();
        if (r6 == null) goto L19;
        r6.setHasCommerceGoods(r7.isHasCommerceGoods());
        return;
    L19:
        return;
    L18:
        return;
    }

    private final void verifyEnterToolbarData(Room r17) {
        if (r17.getRoomCart() == null) goto L5;
        boolean r1 = true;
    L6:
        boolean r4 = r17.isHasCommerceGoods();
        if (r1 == true) goto L10;
        if (r4 == false) goto L10;
        boolean r2 = true;
    L11:
        String r5 = r17.getOwnerUserIdString();
        IUserService r6 = jc1.k.f(IUserService.class);
        Object r7 = null;
        if (r6 == null) goto L16;
        com.bytedance.android.livesdk.user.f r8 = r6.user();
        if (r8 == null) goto L16;
        String r9 = r8.n();
    L17:
        boolean r10 = Intrinsics.areEqual(r5, r9);
        if (isAnchor() == true) goto L107;
        if (r2 == true) goto L108;
        if (r10 == true) goto L109;
        com.bytedance.android.livesdk.sharedpref.e<Long> r3 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.b.a;
        Intrinsics.checkNotNullParameter(r17, "room");
        LiveToolbarData r11 = r17.getToolbarData();
        if (r11 == null) goto L36;
        List r12 = r11.getToolbarDataList();
        if (r12 == null) goto L36;
        Iterator r13 = r12.iterator();
    L27:
        if (r13.hasNext() == false) goto L34;
        Object r14 = r13.next();
        if (((IToolbarComponentData) r14).getGroupId() != 0) goto L31;
        boolean r15 = true;
    L32:
        if (r15 == false) goto L27;
    L35:
        IToolbarComponentData r16 = (IToolbarComponentData) r14;
    L37:
        ArrayList r18 = new ArrayList();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.c r19 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.c(BottomToolbarLogUtil$configList$1.INSTANCE, String.valueOf(NewToolbarButtonConstants.CommerceCart.INSTANCE.getId()));
        Intrinsics.checkNotNullParameter(r18, "list");
        r18.add(r19);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.c r20 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.c(BottomToolbarLogUtil$configList$2.INSTANCE, String.valueOf(NewToolbarButtonConstants.MiniApp.INSTANCE.getId()));
        Intrinsics.checkNotNullParameter(r18, "list");
        r18.add(r20);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.c r21 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.c(BottomToolbarLogUtil$configList$3.INSTANCE, String.valueOf(NewToolbarButtonConstants.GamePromote.INSTANCE.getId()));
        Intrinsics.checkNotNullParameter(r18, "list");
        r18.add(r21);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.c r22 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.c(BottomToolbarLogUtil$configList$4.INSTANCE, String.valueOf(NewToolbarButtonConstants.Welfare.INSTANCE.getId()));
        Intrinsics.checkNotNullParameter(r18, "list");
        r18.add(r22);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.c r23 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.c(BottomToolbarLogUtil$configList$5.INSTANCE, String.valueOf(NewToolbarButtonConstants.LifeGroupon.INSTANCE.getId()));
        Intrinsics.checkNotNullParameter(r18, "list");
        r18.add(r23);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.c r24 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.c(BottomToolbarLogUtil$configList$6.INSTANCE, String.valueOf(NewToolbarButtonConstants.TicketSale.INSTANCE.getId()));
        Intrinsics.checkNotNullParameter(r18, "list");
        r18.add(r24);
        String r25 = String.valueOf(r17.getRoomId());
        StringBuilder r26 = new StringBuilder("OldDataCheck: ");
        int r27 = -1;
        if (r16 != null) goto L65;
        r26.append("new data is Error, ");
        Iterator r28 = r18.iterator();
        String r110 = "";
        boolean r29 = false;
    L41:
        if (r28.hasNext() == false) goto L51;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.b.a r111 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.b.a) r28.next();
        if (r111.a(r17) == false) goto L41;
        if (r110.length() != 0) goto L47;
        boolean r30 = true;
    L48:
        if (r30 == false) goto L50;
        r110 = r111.getName();
    L50:
        r26.append(r111.getName());
        r26.append(" ");
        r29 = true;
        goto L41
    L47:
        r30 = false;
        goto L48
    L51:
        if (r29 == false) goto L110;
        r26.append(" has data.");
        xs2.b.a().post(new zg1.h("ToolbarCheck", r26.toString()));
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L55
        Object r31 = Result.constructor-impl(Integer.valueOf(CastIntegerProtector.parseInt(r110)));     // Catch: Throwable -> L55
    L58:
        if (Result.isFailure-impl(r31) == true) goto L61;
        r7 = r31;
    L61:
        Integer r32 = (Integer) r7;
        if (r32 == null) goto L64;
        r27 = r32.intValue();
    L64:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.b.b(r27, "ServerError", false, "", r25);
        ALogger.i("NewToolbarLog", "ToolbarCheck : " + r26.toString());
        return;
    L55:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r31 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L110:
        return;
    L65:
        Iterator r34 = r18.iterator();
    L67:
        if (r34.hasNext() == false) goto L71;
        Object r35 = r34.next();
        if (Intrinsics.areEqual(((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.b.a) r35).getName(), String.valueOf(r16.getId())) == false) goto L67;
    L72:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.b.a r36 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.b.a) r35;
        if (r36 != null) goto L75;
        return;
    L75:
        if (r36.a(r17) == true) goto L113;
        r26.append("old data is Error--");
        r26.append(r36.getName());
        xs2.b.a().post(new zg1.h("ToolbarCheck", r26.toString()));
        com.bytedance.android.livesdk.sharedpref.e<Long> r37 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.b.a;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L79
        Object r39 = Result.constructor-impl(Integer.valueOf(r16.getId()));     // Catch: Throwable -> L79
    L82:
        if (Result.isFailure-impl(r39) == true) goto L85;
        r7 = r39;
    L85:
        Integer r40 = (Integer) r7;
        if (r40 == null) goto L88;
        r27 = r40.intValue();
    L88:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.b.b(r27, "OldServerError", false, "", r25);
        ALogger.i("NewToolbarLog", "ToolbarCheck : " + r26.toString());
        return;
    L79:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r39 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L82
    L113:
        return;
    L71:
        r35 = null;
        goto L72
    L31:
        r15 = false;
        goto L32
    L34:
        r14 = null;
    L36:
        r16 = null;
        goto L37
    L109:
        return;
    L108:
        return;
    L107:
        return;
    L16:
        r9 = null;
    L10:
        r2 = false;
        goto L11
    L5:
        r1 = false;
        goto L6
    }

    public void compactLoadFromSei(NewToolbarButtonConstants r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        ALogger.e("NewToolbarLog", "compactLoadFromSei:" + r3);
        ALogger.e("NewToolbarLog", "stop loading from sei.");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        f2.c("Load from SEI!", 0);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m
    public s findContainButtonById(int r5) {
        ot2.c r0 = this.implProxy;
        if (r0 != null) goto L5;
        r r1 = this.dataManager;
        Object r2 = null;
        if (r1 == null) goto L40;
        Collection r3 = r1.d;
        if (r3 != null) goto L12;
        r3 = CollectionsKt.emptyList();
    L12:
        if (r3 == null) goto L41;
        Collection r4 = r3;
        r r6 = this.dataManager;
        if (r6 == null) goto L21;
        List r7 = r6.c;
        if (r7 != null) goto L19;
        r7 = CollectionsKt.emptyList();
    L19:
        if (r7 == null) goto L21;
    L22:
        List r8 = CollectionsKt.plus(r4, r7);
        if (r8 == null) goto L42;
        Iterator r9 = r8.iterator();
    L26:
        if (r9.hasNext() == false) goto L34;
        Object r10 = r9.next();
        if (((s) r10).a != r5) goto L30;
        boolean r11 = true;
    L31:
        if (r11 == false) goto L26;
        r2 = r10;
        goto L34
    L30:
        r11 = false;
    L34:
        return (s) r2;
    L42:
        return null;
    L21:
        r7 = CollectionsKt.emptyList();
        goto L22
    L41:
        return null;
    L40:
        return null;
    L5:
        return r0.findContainButtonById(r5);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m
    public int getComponentByGroupId(int r4) {
        ot2.c r0 = this.implProxy;
        if (r0 != null) goto L5;
        r r1 = this.dataManager;
        if (r1 == null) goto L26;
        Iterable r2 = r1.c;
        if (r2 != null) goto L12;
        r2 = CollectionsKt.emptyList();
    L12:
        if (r2 == null) goto L26;
        Iterator r3 = r2.iterator();
    L15:
        if (r3.hasNext() == false) goto L22;
        Object r5 = r3.next();
        if (((s) r5).f != r4) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == false) goto L15;
    L23:
        s r7 = (s) r5;
        if (r7 == null) goto L26;
        return r7.a;
    L19:
        r6 = false;
        goto L20
    L22:
        r5 = null;
    L26:
        return -1;
    L5:
        return r0.getComponentByGroupId(r4);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m
    public int getComponentIndex(int r3) {
        ot2.c r0 = this.implProxy;
        if (r0 == null) goto L7;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.getComponentIndex(r3);
    L7:
        return -1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m
    public List<ToolbarButton> getFoldButtons(Boolean r6) {
        ot2.c r0 = this.implProxy;
        if (r0 == null) goto L8;
        List<ToolbarButton> r7 = r0.getFoldButtons(r6);
        if (r7 == null) goto L7;
        return r7;
    L7:
        return new ArrayList();
    L8:
        r r1 = this.dataManager;
        if (r1 == null) goto L26;
        Iterable r2 = r1.d;
        if (r2 != null) goto L14;
        r2 = CollectionsKt.emptyList();
    L14:
        if (r2 == null) goto L26;
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L17:
        if (r4.hasNext() == false) goto L33;
        s r5 = (s) r4.next();
        if (r6 == null) goto L21;
        boolean r8 = r6.booleanValue();
    L22:
        ToolbarButton r9 = f3.b(r5, r8, true);
        if (r9 == null) goto L17;
        r3.add(r9);
        goto L17
    L21:
        r8 = isAnchor();
        goto L22
    L33:
        return r3;
    L26:
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o
    public a0 getToolbarConfig(int r2) {
        ot2.c r0 = this.implProxy;
        if (r0 == null) goto L9;
        if (r0 != null) goto L10;
        return null;
    L10:
        return r0.getToolbarConfig(r2);
    L9:
        return this.componentConfigManager.getToolbarConfig(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m
    public boolean isComponentShowing(int r7) {
        ot2.c r0 = this.implProxy;
        if (r0 != null) goto L5;
        r r1 = this.dataManager;
        Object r3 = null;
        if (r1 == null) goto L23;
        Iterable r2 = r1.c;
        if (r2 != null) goto L12;
        r2 = CollectionsKt.emptyList();
    L12:
        if (r2 == null) goto L23;
        Iterator r4 = r2.iterator();
    L15:
        if (r4.hasNext() == false) goto L22;
        Object r5 = r4.next();
        if (((s) r5).a != r7) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == false) goto L15;
        r3 = r5;
        goto L22
    L19:
        r6 = false;
    L22:
        r3 = (s) r3;
    L23:
        if (r3 != null) goto L32;
        return false;
    L32:
        return true;
    L5:
        return r0.isComponentShowing(r7);
    }

    public void onMessage(tlc.d r7) {
        if (this.implProxy == null) goto L7;
        ALogger.i("NewToolbarLog", "onMessage by impl");
        return;
    L7:
        if ((r7 instanceof dm) == true) goto L10;
        return;
    L10:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L12;
    L13:
        logMsgDebugInfo((dm) r7);
    L14:
        this.dataCenter.put("data_toolbar_control_message", r7);
        final r r0 = this.dataManager;
        if (r0 == null) goto L62;
        dm r8 = (dm) r7;
        Intrinsics.checkNotNullParameter(r8, "message");
        final s r2 = c0.a(r8);
        if (((Boolean) wh1.a.getValue()).booleanValue() == true) goto L19;
    L25:
        SkinLoader.c.getClass();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.b.a(Boolean.valueOf(SkinLoader.a.b()), new NewToolbarDataManager$onMessage$1(r0, r2));
        int r1 = r8.getEventType();
        if (r1 == 1) goto L58;
        if (r1 != 2) goto L30;
        r0.g(r2, r8.getOpType());
        return;
    L30:
        if (r1 == 3) goto L53;
        if (r1 != 4) goto L34;
        Lazy r9 = ToolbarComponentCheckManager.a;
        DataCenter r10 = r0.i;
        Intrinsics.checkNotNullParameter(r2, "model");
        ToolbarComponentCheckManager.h(r10, new ToolbarComponentCheckManager$removeDelayTaskByRemoveMsg$1(r2), new ToolbarComponentCheckManager$removeDelayTaskByRemoveMsg$2(r2));
        r0.h(r2);
        ArrayList<s> r11 = r0.d;
        if (r11 == null) goto L51;
        r11.remove(r2);
    L51:
        r0.g.a(new r.b(r2, 4, null));
        return;
    L34:
        if (r1 != 5) goto L68;
        int r12 = r8.getOpType();
        List<String> r3 = r0.f;
        if (r3 != null) goto L39;
    L47:
        r0.g.a(new r.b(r2, 5, Integer.valueOf(r12)));
        return;
    L39:
        if (r3.contains(String.valueOf(r2.a)) != true) goto L47;
        ArrayList<s> r4 = r0.c;
        if (r4 == null) goto L47;
        if (r4.remove(r2) != true) goto L47;
        r2.l.b = true;
        ArrayList<s> r5 = r0.c;
        if (r5 == null) goto L47;
        r5.add(r2);
        goto L47
    L68:
        return;
    L53:
        if (r0.f(r8) == true) goto L69;
        r0.j(r8);
        r0.b(r2, r8.getOpType());
        return;
    L69:
        return;
    L58:
        if (r0.f(r8) == true) goto L70;
        r0.j(r8);
        r0.b(r2, r8.getOpType());
        return;
    L70:
        return;
    L19:
        if (g0.a(r2) == false) goto L25;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L23;
        String r13 = r2.toString() + r2.d;
    L24:
        ALogger.i("NewToolbarLog", "filter msg " + r13);
        return;
    L23:
        r13 = r2.toString();
        goto L24
    L62:
        return;
    L12:
        if (u40.a.b() == false) goto L14;
        goto L13
    }

    public final void onRoomUiDestory(boolean r5) {
        this.cd.dispose();
        if (r5 == true) goto L8;
        k r0 = this.componentConfigManager;
        int r1 = r0.a.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        r0.a.valueAt(r2).p();
        r2 = r2 + 1;
        goto L5
    L7:
        r0.a.clear();
        Lazy r3 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.c(this.dataCenter);
    L8:
        ALogger.i("NewToolbarLog", "onRoomExit");
        ot2.c r4 = this.implProxy;
        if (r4 == null) goto L13;
        r4.onRoomUiDestory(r5);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m
    public void refreshExistComponent(int r6) {
        ot2.c r0 = this.implProxy;
        if (r0 == null) goto L7;
        if (r0 == null) goto L32;
        r0.refreshExistComponent(r6);
        return;
    L32:
        return;
    L7:
        r r1 = this.dataManager;
        if (r1 == null) goto L33;
        ArrayList<s> r2 = r1.c;
        if (r2 == null) goto L22;
        Iterator<T> r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L20;
        Object r4 = r3.next();
        if (((s) r4).a != r6) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == false) goto L13;
    L21:
        s r7 = (s) r4;
    L23:
        if (r7 != null) goto L25;
        ALogger.i("NewToolbarLog", "refresh data is null - " + r6);
        return;
    L25:
        r1.g.a(new r.b(r7, r7, 7, null));
        return;
    L17:
        r5 = false;
        goto L18
    L20:
        r4 = null;
        goto L21
    L22:
        r7 = null;
        goto L23
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o
    public void register(a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        ot2.c r0 = this.implProxy;
        if (r0 == null) goto L7;
        if (r0 == null) goto L9;
        r0.register(r2);
        return;
    L9:
        return;
    L7:
        this.componentConfigManager.f(r2);
    }

    public static final /* synthetic */ void access$onToolbarEvent(BottomToolbarViewModel r0, r.a r1) {
        r0.onToolbarEvent(r1);
    }

    public static final /* synthetic */ void access$setDataManager$p(BottomToolbarViewModel r0, r r1) {
        r0.dataManager = r1;
    }

    public static final /* synthetic */ void access$updateCommerceData(BottomToolbarViewModel r0, Room r1) {
        r0.updateCommerceData(r1);
    }

    public static final /* synthetic */ void access$verifyEnterToolbarData(BottomToolbarViewModel r0, Room r1) {
        r0.verifyEnterToolbarData(r1);
    }

    private final void doubleCheckToolbarData(Room r5, Function2<? super String, ? super LiveToolbarData, Unit> r6) {
        boolean r1 = true;
        boolean r2 = false;
        if (r5.getRoomCart() == null) goto L5;
        boolean r0 = true;
    L6:
        boolean r3 = r5.isHasCommerceGoods();
        if (r0 == true) goto L10;
        if (r3 == false) goto L10;
    L12:
        if (((Boolean) sq.a.getValue()).booleanValue() == true) goto L14;
    L16:
        r2 = r1;
    L17:
        if (r2 == false) goto L31;
        com.bytedance.android.livesdk.service.l.d().getClass();
        com.bytedance.android.live.network.c r4 = com.bytedance.android.live.network.c.b();
        if (r4 == null) goto L33;
        RoomRetrofitApi r7 = (RoomRetrofitApi) r4.e(RoomRetrofitApi.class);
        if (r7 == null) goto L34;
        Observable r8 = r7.getRoomInfoByScene(r5.id, "check_toolbar");
        if (r8 == null) goto L35;
        Observable r9 = r8.observeOn(AndroidSchedulers.mainThread());
        if (r9 == null) goto L36;
        Observable r10 = r9.subscribeOn(Schedulers.io());
        if (r10 == null) goto L37;
        Disposable r11 = r10.subscribe(new b(this, r5, r6), new c(r6, r5));
        if (r11 == null) goto L38;
        RxUtilKt.c(r11, this.cd);
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L31:
        r6.invoke("Direct Load", r5.getToolbarData());
        return;
    L14:
        if (isAnchor() == false) goto L16;
    L10:
        r1 = false;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    private final void startCountDownVerify(LiveToolbarData r3, ToolbarOperateManager r4) {
        RxUtilKt.c(Observable.timer(this.VERIFY_DELAY_TIME, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, r4), g.a), this.cd);
    }

    private final void updateToolbarDataInRoom(Room r5, LiveToolbarData r6) {
        if (r6 == null) goto L11;
        r5.setToolbarData(r6);
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2);
        if (r7 == null) goto L12;
        com.bytedance.live.datacontext.m r8 = r7.getRoom();
        if (r8 == null) goto L13;
        Room r9 = (Room) r8.getValue();
        if (r9 == null) goto L14;
        r9.setToolbarData(r6);
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    }

    public final void initContainer(ot2.a r2, ot2.d r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        ot2.c r0 = this.implProxy;
        if (r0 == null) goto L7;
        if (r0 == null) goto L8;
        r0.initContainer(r2, r3);
        return;
    L8:
        return;
    }

    public final void onRoomUiLoadFinished(final Room r7, ot2.e r8) {
        Intrinsics.checkNotNullParameter(r7, "room");
        ALogger.i("NewToolbarLog", "onRoomEnter");
        ToolbarLoadTimeStatsVM.a r0 = ToolbarLoadTimeStatsVM.Companion;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2);
        r0.getClass();
        ToolbarLoadTimeStatsVM.a.b(r1).recordTime(ToolbarLoadTimeStatsVM.TOOLBAR_TRUE_LOAD);
        o r2 = this.implProxy;
        if (r2 != null) goto L5;
        registerPlaceHold();
        this.mRoom = r7;
        if (this.cd.isDisposed() == true) goto L17;
        this.cd.dispose();
    L17:
        this.cd = new CompositeDisposable();
        r r9 = new r(this.dataCenter);
        this.dataManager = r9;
        this.replaceManager.c = r9;
        k r10 = this.componentConfigManager;
        DataCenter r3 = this.dataCenter;
        Context r4 = this.context;
        if (r4 != null) goto L20;
        r4 = s1.getContext();
    L20:
        r10.e(r3, r4, null);
        ToolbarOperateManager r11 = this.toolbarOperateManager;
        k r5 = this.componentConfigManager;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r5, "componentConfigManager");
        r11.b = r5;
        r r12 = this.dataManager;
        if (r12 == null) goto L27;
        PropertyOwner r13 = r12.h;
        if (r13 == null) goto L27;
        Disposable r14 = r13.subscribe(new d(this), e.a);
        if (r14 == null) goto L27;
        RxUtilKt.c(r14, this.cd);
    L27:
        q.a.clear();
        doubleCheckToolbarData(r7, new AnonymousClass4(this, r7));
        return;
    L5:
        if (r2.getCompositeDisposable() == null) goto L10;
        k r6 = this.componentConfigManager;
        DataCenter r15 = this.dataCenter;
        Context r16 = this.context;
        if (r16 != null) goto L9;
        r16 = s1.getContext();
    L9:
        r6.e(r15, r16, r2);
    L10:
        ot2.c r17 = this.implProxy;
        if (r17 == null) goto L29;
        r17.Kl(r7, r8);
        return;
    }

    public BottomToolbarViewModel(Context r3, DataCenter r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.context = r3;
        this.dataCenter = r4;
        this.isAnchorFromInit = r5;
        this.replaceManager = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.d(r4);
        this.isAnchor$delegate = LazyKt.lazy(new C04412(this));
        this.cd = new CompositeDisposable();
        this.componentConfigManager = new k();
        this.toolbarOperateManager = new ToolbarOperateManager(r4);
        SkinLoader.c.getClass();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.b.a(Boolean.valueOf(SkinLoader.a.b()), AnonymousClass1.INSTANCE);
        Lazy r6 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.b(r4);
        if (u40.a.c(r5) == false) goto L9;
        IToolbarService r7 = jc1.k.f(IToolbarService.class);
        if (r7 == null) goto L7;
        ot2.c r8 = r7.createBottomToolbarViewModelImpl(this.context, r4);
    L8:
        this.implProxy = r8;
    L14:
        ALogger.i("NewToolbarLog", "ViewModel init finish");
        this.VERIFY_DELAY_TIME = 5;
        return;
    L7:
        r8 = null;
        goto L8
    L9:
        RoomContext r9 = RoomContext.a.c(RoomContext.Companion, r4, 0, 2);
        if (r9 == null) goto L14;
        com.bytedance.live.datacontext.j r10 = r9.getMessageManager();
        if (r10 == null) goto L14;
        r10.c(new AnonymousClass2(this));
        goto L14
    }

    public static final /* synthetic */ void access$startCountDownVerify(BottomToolbarViewModel r0, LiveToolbarData r1, ToolbarOperateManager r2) {
        r0.startCountDownVerify(r1, r2);
    }

    public static final /* synthetic */ void access$updateToolbarDataInRoom(BottomToolbarViewModel r0, Room r1, LiveToolbarData r2) {
        r0.updateToolbarDataInRoom(r1, r2);
    }

    public final void openChangeDialog(Context r17, long r18, int r20, i r21) {
        i r7 = r21;
        Intrinsics.checkNotNullParameter(r17, "context");
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.d r3 = this.replaceManager;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r17, "context");
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, r3.f, 0, 2);
        if (r2 == null) goto L20;
        com.bytedance.live.datacontext.n r4 = r2.getCurToolbarList();
        if (r4 == null) goto L20;
        List r5 = (List) r4.getValue();
        if (r5 == null) goto L20;
        Iterator r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L17;
        Object r12 = r6.next();
        if (((s) r12).a != r20) goto L14;
        boolean r13 = true;
    L15:
        if (r13 == false) goto L10;
    L18:
        s r14 = (s) r12;
        if (r14 == null) goto L20;
    L38:
        if (r14 == null) goto L40;
        int r8 = r14.f;
    L41:
        RoomContext r15 = RoomContext.a.c(RoomContext.Companion, r3.f, 0, 2);
        if (r15 == null) goto L58;
        com.bytedance.live.datacontext.n r16 = r15.getCurToolbarList();
        if (r16 == null) goto L58;
        List r19 = (List) r16.getValue();
        if (r19 == null) goto L58;
        Iterator r110 = r19.iterator();
    L49:
        if (r110.hasNext() == false) goto L56;
        Object r111 = r110.next();
        if (((s) r111).f != r8) goto L53;
        boolean r112 = true;
    L54:
        if (r112 == false) goto L49;
    L57:
        s r113 = (s) r111;
    L60:
        if (r14 == null) goto L62;
        if (r113 != null) goto L92;
        ALogger.i("NewToolbarLog", "from is ".concat(String.valueOf(r113)));
        r3.b(r18, new s(), r14, r21);
        if (r7 == null) goto L183;
        r21.onConfirmClick();
        return;
    L183:
        return;
    L92:
        if (Intrinsics.areEqual(r113, r14) == false) goto L96;
        ALogger.i("NewToolbarLog", "from == to : " + r14.toString());
        if (r7 == null) goto L185;
        r7.b(r113, r14, true);
        return;
    L185:
        return;
    L96:
        RoomContext.a r1 = RoomContext.Companion;
        RoomContext r114 = RoomContext.a.c(r1, r3.f, 0, 2);
        if (r114 == null) goto L107;
        com.bytedance.live.datacontext.m r9 = r114.getRoom();
        if (r9 == null) goto L107;
        Room r10 = (Room) r9.getValue();
        if (r10 == null) goto L107;
        LiveToolbarData r11 = r10.getToolbarData();
        if (r11 == null) goto L107;
        ToolbarExtraInfo r22 = r11.getExtraInfo();
        if (r22 == null) goto L107;
        Integer r23 = r22.getGamePromotionCoexist();
    L108:
        if (r23 != null) goto L111;
    L113:
        boolean r24 = false;
    L115:
        if (((Boolean) r3.e.getValue()).booleanValue() == false) goto L140;
        if (r24 == false) goto L140;
        RoomContext r25 = RoomContext.a.c(r1, r3.f, 0, 2);
        if (r25 == null) goto L122;
        com.bytedance.live.datacontext.n r26 = r25.getCurToolbarList();
        if (r26 == null) goto L122;
        List r27 = (List) r26.getValue();
    L124:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.d.a(5, r27) == false) goto L138;
        RoomContext r28 = RoomContext.a.c(r1, r3.f, 0, 2);
        if (r28 == null) goto L130;
        com.bytedance.live.datacontext.n r29 = r28.getCurToolbarList();
        if (r29 == null) goto L130;
        List r30 = (List) r29.getValue();
    L132:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.d.a(1, r30) == false) goto L134;
    L135:
        r3.b(r18, r113, r14, r21);
        if (r21 == null) goto L187;
        r21.onConfirmClick();
        return;
    L187:
        return;
    L134:
        if (r14.a != 1) goto L138;
    L130:
        r30 = null;
    L138:
        r7 = r21;
    L122:
        r27 = null;
    L140:
        if (LiveOpenFeatureChooseConfig.useV3() == false) goto L153;
        int r31 = r113.a;
        if (r31 == 6) goto L144;
    L145:
        if (r31 == 9) goto L147;
    L149:
        boolean r32 = false;
    L150:
        if (r32 == false) goto L153;
        r3.b(r18, r113, r14, r21);
        return;
    L147:
        if (r14.a != 6) goto L149;
    L148:
        r32 = true;
        goto L150
    L144:
        if (r14.a == 9) goto L148;
    L153:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.d.c(r14) == false) goto L155;
        int r33 = 2131917970;
        String r34 = s1.B(2131917970);
    L157:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.d.c(r113) == false) goto L159;
        String r35 = s1.B(r33);
    L160:
        String r36 = r17.getString(2131922670, new Object[]{r34});
        String r37 = r17.getString(2131914513, new Object[]{r34, r35});
        if (r7 == null) goto L163;
        r21.a();
    L163:
        x0.b r38 = new x0.b(r17, 4);
        x0.d r39 = r38.a;
        r39.l = false;
        r39.c = r36;
        r39.d = r37;
        r38.j(0, r17.getString(2131914512), new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.e(r3, r18, r113, r14, r21));
        r38.i(1, 2131915442, new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.f(r7));
        r38.n();
        return;
    L159:
        r35 = r113.b;
        goto L160
    L155:
        r33 = 2131917970;
        r34 = r14.b;
        goto L157
    L111:
        if (r23.intValue() != 1) goto L113;
        r24 = true;
    L107:
        r23 = null;
        goto L108
    L62:
        if (LiveOpenFeatureChooseConfig.useV3() == false) goto L77;
        if (r20 != CastIntegerProtector.parseInt(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.b(ToolbarBroadcastFunction.LITTLE_GAME))) goto L77;
        if (r113 != null) goto L67;
    L73:
        if (r113 != null) goto L75;
        r113 = new s();
    L75:
        s r40 = new s();
        r40.a = r20;
        Unit r0 = Unit.INSTANCE;
        r3.b(r18, r113, r40, r21);
        return;
    L67:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.d.c(r113) == true) goto L73;
        s r115 = new s();
        r115.a = r20;
        Unit r41 = Unit.INSTANCE;
        String r42 = s1.B(2131917970);
        String r43 = r17.getString(2131922670, new Object[]{r42});
        String r44 = r17.getString(2131914513, new Object[]{r42, r113.b});
        if (r7 == null) goto L72;
        r21.a();
    L72:
        x0.b r45 = new x0.b(r17, 4);
        x0.d r46 = r45.a;
        r46.l = false;
        r46.c = r43;
        r46.d = r44;
        r45.j(0, r17.getString(2131914512), new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.g(r3, r18, r113, r115, r21));
        r45.i(1, 2131915442, new h(r7));
        r45.n();
        return;
    L77:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L79;
        f2.c("replace component error!", 0);
    L79:
        int r47 = com.bytedance.android.livesdk.config.setting.s.a;
        if (((com.bytedance.android.livesdk.config.setting.u) LiveInfraSettingKeys.LIVE_NEW_TOOLBAR_FUNCTION_CHANGE.getValue()).a() == false) goto L86;
        if (r113 != null) goto L83;
        r113 = new s();
    L83:
        s r48 = new s();
        r48.a = r20;
        Unit r49 = Unit.INSTANCE;
        r3.b(r18, r113, r48, r21);
        if (r7 == null) goto L86;
        r21.onConfirmClick();
    L86:
        ALogger.e("NewToolbarLog", "replace component error!");
        return;
    L53:
        r112 = false;
        goto L54
    L56:
        r111 = null;
    L58:
        r113 = null;
        goto L60
    L40:
        r8 = r3.g;
        goto L41
    L14:
        r13 = false;
        goto L15
    L17:
        r12 = null;
    L20:
        RoomContext r50 = RoomContext.a.c(RoomContext.Companion, r3.f, 0, 2);
        if (r50 == null) goto L37;
        com.bytedance.live.datacontext.n r51 = r50.getCurMorePanelList();
        if (r51 == null) goto L37;
        List r52 = (List) r51.getValue();
        if (r52 == null) goto L37;
        Iterator r53 = r52.iterator();
    L28:
        if (r53.hasNext() == false) goto L35;
        Object r116 = r53.next();
        if (((s) r116).a != r20) goto L32;
        boolean r117 = true;
    L33:
        if (r117 == false) goto L28;
    L36:
        r14 = (s) r116;
        goto L38
    L32:
        r117 = false;
        goto L33
    L35:
        r116 = null;
    L37:
        r14 = null;
        goto L38
    }

    public final void openChangeDialog(Context r8, long r9, ToolbarBroadcastFunction r11, i r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r11, "to");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(Integer.valueOf(CastIntegerProtector.parseInt(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.b(r11))));     // Catch: Throwable -> L5
    L8:
        if (Result.exceptionOrNull-impl(r1) == null) goto L11;
        ALogger.e("NewToolbarLog", "id:" + com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.b(r11) + " error when open change dialog.");
    L11:
        if (Result.isFailure-impl(r1) == false) goto L13;
        r1 = null;
    L13:
        Integer r2 = (Integer) r1;
        if (r2 == null) goto L19;
        openChangeDialog(r8, r9, r2.intValue(), r12);
        return;
    L19:
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
