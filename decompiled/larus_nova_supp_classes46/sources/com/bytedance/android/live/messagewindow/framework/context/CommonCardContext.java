package com.bytedance.android.live.messagewindow.framework.context;

import am2.n;
import am2.x;
import android.os.SystemClock;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService;
import com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService;
import com.bytedance.android.live.room.api.messagewindow.anim.CardAnimState;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardInitScene;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.service.dependenceproxy.IMsgWindowProxyService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.i3;
import com.bytedance.android.livesdk.message.model.j3;
import com.bytedance.android.livesdk.message.model.m1;
import com.bytedance.android.livesdk.message.model.u1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveDSLModel;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.android.livesdkapi.service.ILiveUxTracer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 e2\u00020\u00012\u00020\u0002:\u0001fB\u0017\u0012\u0006\u0010Z\u001a\u00020\u0001\u0012\u0006\u0010_\u001a\u00020^¢\u0006\u0004\bc\u0010dJ;\u0010\f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003H\u0002J&\u0010\u000e\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0002J;\u0010\u0010\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\u0003H\u0002J;\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\u0003H\u0002J(\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J \u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016JG\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n0\u001d2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003H\u0016J2\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n0\u001d2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0016JG\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n0\u001d2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\u0003H\u0016JG\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n0\u001d2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\u0003H\u0016J\u0014\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\"0\u001dH\u0016J\"\u0010)\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010$2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&H\u0016J \u00101\u001a\u0002002\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.H\u0016J\u0018\u00105\u001a\u00020\b2\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u000200H\u0016R\u0014\u00104\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00106R0\u00108\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0012\u0018\u0001078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R0\u0010>\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u001a\u0018\u0001078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b>\u00109\u001a\u0004\b?\u0010;\"\u0004\b@\u0010=R:\u0010B\u001a\u001a\u0012\u0004\u0012\u00020,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020A0\u001d078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bB\u00109\u001a\u0004\bC\u0010;\"\u0004\bD\u0010=RF\u0010F\u001a&\u0012\u0004\u0012\u00020E\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020A0\u001d07078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bF\u00109\u001a\u0004\bG\u0010;\"\u0004\bH\u0010=RF\u0010J\u001a&\u0012\u0004\u0012\u00020I\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020A0\u001d07078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bJ\u00109\u001a\u0004\bK\u0010;\"\u0004\bL\u0010=R0\u0010M\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0006\u0012\u0004\u0018\u000102078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bM\u00109\u001a\u0004\bN\u0010;\"\u0004\bO\u0010=R0\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0006\u0012\u0004\u0018\u00010P078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bQ\u00109\u001a\u0004\bR\u0010;\"\u0004\bS\u0010=R\"\u0010T\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001a\u0010Z\u001a\u00020\u00018\u0016X\u0096\u0004¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u001a\u0010_\u001a\u00020^8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b¨\u0006g"}, d2 = {"Lcom/bytedance/android/live/messagewindow/framework/context/CommonCardContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Ly61/a;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "canShow", "", "execute", "Lcom/bytedance/ies/web/jsbridge2/g;", "Lorg/json/JSONObject;", "preLoadedJsEvent", "Lkotlin/Function0;", "showJsEvent", "activeClose", "hideJsEvent", "closeJsEvent", "Lcom/bytedance/android/livesdk/message/model/m1;", "bottomRightCardArea", "Lcom/bytedance/android/live/room/api/messagewindow/model/CommonCardInitScene;", "initScene", "", "", "", "generateCardData", "Lcom/bytedance/android/livesdk/message/model/i3;", "commonCardArea", "generateTopRightCardData", "Lkotlin/Pair;", "providePreLoadedJsMethod", "provideShowJsMethod", "provideHideJsMethod", "provideCloseJsMethod", "Lcom/bytedance/ies/web/jsbridge2/f$b;", "provideWRDSJsMethod", "Lcom/bytedance/android/annie/api/card/HybridCard;", "hybridCard", "Lio/reactivex/Observable;", "Lp71/a;", "showFailureObservable", "registerJsEvent", "Lv61/a;", "card", "", "cardType", "Lz61/a;", "commonCardEvent", "Lio/reactivex/disposables/CompositeDisposable;", "registerCardCallback", "Lcom/bytedance/android/live/room/api/messagewindow/builder/card/b;", "commonCard", "cd", "unRegisterCardCallback", "Lio/reactivex/disposables/CompositeDisposable;", "", "bottomRightCardData", "Ljava/util/Map;", "getBottomRightCardData", "()Ljava/util/Map;", "setBottomRightCardData", "(Ljava/util/Map;)V", "topRightCardData", "getTopRightCardData", "setTopRightCardData", "Lg71/b;", "cardMap", "getCardMap", "setCardMap", "Lcom/bytedance/android/live/room/api/messagewindow/container/MsgWindowPosition;", "cardMapV2", "getCardMapV2", "setCardMapV2", "Lw61/b;", "cardMapV3", "getCardMapV3", "setCardMapV3", "cardLifecycleMap", "getCardLifecycleMap", "setCardLifecycleMap", "Lcom/bytedance/android/live/room/api/messagewindow/builder/card/c;", "commonCardWrapperMap", "getCommonCardWrapperMap", "setCommonCardWrapperMap", "hasInitialized", "Z", "getHasInitialized", "()Z", "setHasInitialized", "(Z)V", "roomContext", "Lcom/bytedance/live/datacontext/DataContext;", "getRoomContext", "()Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "<init>", "(Lcom/bytedance/live/datacontext/DataContext;Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Companion", "b", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonCardContext extends DataContext implements y61.a {
    public static final b Companion = null;
    public static final String TAG = "CommonCardContext";
    private Map<Integer, m1> bottomRightCardData;
    private Map<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b> cardLifecycleMap;
    private Map<Integer, Pair<v61.a, g71.b>> cardMap;
    private Map<MsgWindowPosition, Map<Integer, Pair<v61.a, g71.b>>> cardMapV2;
    private Map<w61.b, Map<Integer, Pair<v61.a, g71.b>>> cardMapV3;
    private final CompositeDisposable cd;
    private Map<Integer, com.bytedance.android.live.room.api.messagewindow.builder.card.c> commonCardWrapperMap;
    private final DataCenter dataCenter;
    private boolean hasInitialized;
    private final DataContext roomContext;
    private Map<Integer, i3> topRightCardData;

    public static final class a implements Action {
        public final /* synthetic */ CommonCardContext a;

        public a(CommonCardContext r1) {
            this.a = r1;
        }

        public final void run() {
            Map<Integer, m1> r0 = this.a.getBottomRightCardData();
            if (r0 == null) goto L5;
            r0.clear();
        L5:
            Iterator<Map.Entry<Integer, Pair<v61.a, g71.b>>> r1 = this.a.getCardMap().entrySet().iterator();
        L7:
            if (r1.hasNext() == false) goto L9;
            Map.Entry<Integer, Pair<v61.a, g71.b>> r2 = r1.next();
            ((v61.a) r2.getValue().getFirst()).dismiss();
            ((g71.b) r2.getValue().getSecond()).reset();
            goto L7
        L9:
            this.a.getCardMap().clear();
            Iterator<Map.Entry<MsgWindowPosition, Map<Integer, Pair<v61.a, g71.b>>>> r3 = this.a.getCardMapV2().entrySet().iterator();
        L11:
            if (r3.hasNext() == false) goto L16;
            Iterator<Map.Entry<Integer, Pair<v61.a, g71.b>>> r4 = r3.next().getValue().entrySet().iterator();
        L14:
            if (r4.hasNext() == false) goto L11;
            Map.Entry<Integer, Pair<v61.a, g71.b>> r5 = r4.next();
            ((v61.a) r5.getValue().getFirst()).dismiss();
            ((g71.b) r5.getValue().getSecond()).reset();
            goto L14
        L16:
            this.a.getCardMapV2().clear();
            Iterator<Map.Entry<w61.b, Map<Integer, Pair<v61.a, g71.b>>>> r6 = this.a.getCardMapV3().entrySet().iterator();
        L18:
            if (r6.hasNext() == false) goto L23;
            Iterator<Map.Entry<Integer, Pair<v61.a, g71.b>>> r7 = r6.next().getValue().entrySet().iterator();
        L21:
            if (r7.hasNext() == false) goto L18;
            Map.Entry<Integer, Pair<v61.a, g71.b>> r8 = r7.next();
            ((v61.a) r8.getValue().getFirst()).dismiss();
            ((g71.b) r8.getValue().getSecond()).reset();
            goto L21
        L23:
            this.a.getCardMapV3().clear();
            Map<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b> r9 = this.a.getCardLifecycleMap();
            if (r9 == null) goto L26;
            r9.clear();
        L26:
            Map<Integer, com.bytedance.android.live.room.api.messagewindow.builder.card.c> r10 = this.a.getCommonCardWrapperMap();
            if (r10 == null) goto L29;
            r10.clear();
        L29:
            this.a.setHasInitialized(false);
            com.bytedance.android.live.room.api.messagewindow.monitor.i r11 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r11 == null) goto L33;
            CardAlogParamsBuilder r12 = new CardAlogParamsBuilder();
            r12.d(CommonCardContext.TAG);
            r12.c("CommonCardContext onClear");
            Unit r13 = Unit.INSTANCE;
            r11.d(r12.b());
        L33:
            CommonCardContext.access$getCd$p(this.a).clear();
        }
    }

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static y61.a b(DataCenter r4) {
            DataContext r1 = com.bytedance.live.datacontext.d.d(a(r4, CommonCardContext.TAG));
            y61.a r3 = null;
            if ((r1 instanceof y61.a) == true) goto L5;
            r1 = null;
        L5:
            y61.a r2 = (y61.a) r1;
            if (r2 != null) goto L12;
            CardContext.Companion.getClass();
            com.bytedance.android.live.messagewindow.framework.context.c r5 = CardContext.a.a(r4);
            if (r5 == null) goto L13;
            com.bytedance.live.datacontext.j<y61.a> r6 = r5.getCommonCardContext();
            if (r6 == null) goto L13;
            r3 = (y61.a) r6.getValue();
        L13:
            if (r3 != null) goto L18;
            com.bytedance.android.live.room.api.messagewindow.monitor.i r7 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r7 == null) goto L18;
            CardAlogParamsBuilder r8 = new CardAlogParamsBuilder();
            r8.d(CommonCardContext.TAG);
            r8.c("CommonCardContext is null");
            Unit r0 = Unit.INSTANCE;
            r7.d(r8.b());
        L18:
            return r3;
        L12:
            r3 = r2;
            goto L13
        }

        public static String a(DataCenter r1, String r2) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            StringBuilder r0 = new StringBuilder();
            r0.append(r2);
            r0.append('_');
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            r0.append(r3);
            return r0.toString();
        L5:
            r3 = 0;
            goto L6
        }
    }

    public static final class c extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
        public final /* synthetic */ Function1 a;

        public c(Function1 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2, CallContext r3) {
            JSONObject r4 = (JSONObject) r2;
            Intrinsics.checkNotNullParameter(r4, "params");
            Intrinsics.checkNotNullParameter(r3, "context");
            boolean r5 = r4.optBoolean("activeClose");
            this.a.invoke(Boolean.valueOf(r5));
            JSONObject r6 = new JSONObject();
            r6.put("code", 1);
            return r6;
        }
    }

    public static final class d extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
        public final /* synthetic */ Function1 a;

        public d(Function1 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2, CallContext r3) {
            JSONObject r4 = (JSONObject) r2;
            Intrinsics.checkNotNullParameter(r4, "params");
            Intrinsics.checkNotNullParameter(r3, "context");
            boolean r5 = r4.optBoolean("activeClose");
            this.a.invoke(Boolean.valueOf(r5));
            JSONObject r6 = new JSONObject();
            r6.put("code", 1);
            return r6;
        }
    }

    public static final class e extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
        public final /* synthetic */ Function1 a;

        public e(Function1 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2, CallContext r3) {
            JSONObject r4 = (JSONObject) r2;
            Intrinsics.checkNotNullParameter(r4, "params");
            Intrinsics.checkNotNullParameter(r3, "context");
            boolean r5 = r4.optBoolean("result");
            this.a.invoke(Boolean.valueOf(r5));
            JSONObject r6 = new JSONObject();
            r6.put("code", 1);
            return r6;
        }
    }

    public static final class f implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ CommonCardContext a;

        public f(CommonCardContext r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return jc1.k.n(IBaseBrowserService.class).provideRegisterWRDSMethod(this.a.getDataCenter());
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ z61.a a;

        public g(z61.a r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            ICardLifecycle.State r6 = (ICardLifecycle.State) r5;
            if (r6 != null) goto L6;
            return;
        L6:
            switch(com.bytedance.android.live.messagewindow.framework.context.b.a[r6.ordinal()]) {
                case 1: goto L40;
                case 2: goto L36;
                case 3: goto L29;
                case 4: goto L22;
                case 5: goto L15;
                case 6: goto L8;
                default: goto L54;
            };
        L8:
            Function0 r7 = this.a.b.e.e;
            if (r7 == null) goto L11;
            Unit r8 = (Unit) r7.invoke();
        L11:
            com.bytedance.android.live.room.api.messagewindow.monitor.i r9 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r9 == null) goto L55;
            CardAlogParamsBuilder r3 = new CardAlogParamsBuilder();
            r3.d(CommonCardContext.TAG);
            r3.c("cardCallback");
            r3.a("state", "destroyed");
            Unit r0 = Unit.INSTANCE;
            r9.d(r3.b());
            return;
        L55:
            return;
        L15:
            Function0 r10 = this.a.b.e.d;
            if (r10 == null) goto L18;
            Unit r11 = (Unit) r10.invoke();
        L18:
            com.bytedance.android.live.room.api.messagewindow.monitor.i r12 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r12 == null) goto L56;
            CardAlogParamsBuilder r4 = new CardAlogParamsBuilder();
            r4.d(CommonCardContext.TAG);
            r4.c("cardCallback");
            r4.a("state", "hidden");
            Unit r1 = Unit.INSTANCE;
            r12.d(r4.b());
            return;
        L56:
            return;
        L22:
            Function0 r13 = this.a.b.e.c;
            if (r13 == null) goto L25;
            Unit r14 = (Unit) r13.invoke();
        L25:
            com.bytedance.android.live.room.api.messagewindow.monitor.i r15 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r15 == null) goto L57;
            CardAlogParamsBuilder r16 = new CardAlogParamsBuilder();
            r16.d(CommonCardContext.TAG);
            r16.c("cardCallback");
            r16.a("state", "showed");
            Unit r2 = Unit.INSTANCE;
            r15.d(r16.b());
            return;
        L57:
            return;
        L29:
            Function0 r17 = this.a.b.e.b;
            if (r17 == null) goto L32;
            Unit r18 = (Unit) r17.invoke();
        L32:
            com.bytedance.android.live.room.api.messagewindow.monitor.i r19 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r19 == null) goto L58;
            CardAlogParamsBuilder r20 = new CardAlogParamsBuilder();
            r20.d(CommonCardContext.TAG);
            r20.c("cardCallback");
            r20.a("state", "started");
            Unit r21 = Unit.INSTANCE;
            r19.d(r20.b());
            return;
        L58:
            return;
        L36:
            this.a.b.e.getClass();
            com.bytedance.android.live.room.api.messagewindow.monitor.i r22 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r22 == null) goto L59;
            CardAlogParamsBuilder r23 = new CardAlogParamsBuilder();
            r23.d(CommonCardContext.TAG);
            r23.c("cardCallback");
            r23.a("state", "stored");
            Unit r24 = Unit.INSTANCE;
            r22.d(r23.b());
            return;
        L59:
            return;
        L40:
            Function0 r25 = this.a.b.e.a;
            if (r25 == null) goto L43;
            Unit r26 = (Unit) r25.invoke();
        L43:
            com.bytedance.android.live.room.api.messagewindow.monitor.i r27 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r27 == null) goto L60;
            CardAlogParamsBuilder r28 = new CardAlogParamsBuilder();
            r28.d(CommonCardContext.TAG);
            r28.c("cardCallback");
            r28.a("state", "created");
            Unit r29 = Unit.INSTANCE;
            r27.d(r28.b());
            return;
        L60:
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ z61.a a;

        public h(z61.a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            p71.a r5 = (p71.a) r4;
            Function1 r0 = this.a.b.c.a;
            if (r0 == null) goto L5;
            Unit r6 = (Unit) r0.invoke(r5);
        L5:
            com.bytedance.android.live.room.api.messagewindow.monitor.i r7 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r7 == null) goto L10;
            CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
            r1.d(CommonCardContext.TAG);
            r1.c("showFailObserver");
            r1.a("state", "onFail");
            Unit r2 = Unit.INSTANCE;
            r7.d(r1.b());
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ z61.a a;

        public i(z61.a r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            CardAnimState r8 = (CardAnimState) r7;
            CardAnimState.State r0 = r8.a;
            int r1 = com.bytedance.android.live.messagewindow.framework.context.b.b[r0.ordinal()];
            if (r1 != 1) goto L5;
            Function1 r2 = this.a.b.d.a;
            if (r2 == null) goto L17;
            Unit r3 = (Unit) r2.invoke(r8.b);
        L17:
            com.bytedance.android.live.room.api.messagewindow.monitor.i r4 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r4 == null) goto L25;
            CardAlogParamsBuilder r5 = new CardAlogParamsBuilder();
            r5.d(CommonCardContext.TAG);
            r5.c("animStateObserver");
            r5.a("state", "onAnimStart");
            r5.a("anim_type", r8.b.name());
            Unit r9 = Unit.INSTANCE;
            r4.d(r5.b());
            return;
        L25:
            return;
        L5:
            if (r1 != 2) goto L23;
            Function1 r6 = this.a.b.d.b;
            if (r6 == null) goto L10;
            Unit r10 = (Unit) r6.invoke(r8.b);
        L10:
            com.bytedance.android.live.room.api.messagewindow.monitor.i r11 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r11 == null) goto L24;
            CardAlogParamsBuilder r12 = new CardAlogParamsBuilder();
            r12.d(CommonCardContext.TAG);
            r12.c("animStateObserver");
            r12.a("state", "onAnimEnd");
            r12.a("anim_type", r8.b.name());
            Unit r13 = Unit.INSTANCE;
            r11.d(r12.b());
            return;
        L24:
            return;
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ z61.a a;

        public j(z61.a r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            b71.a r6 = (b71.a) r5;
            Function1 r0 = this.a.b.f.a;
            if (r0 == null) goto L5;
            Unit r1 = (Unit) r0.invoke(r6);
        L5:
            com.bytedance.android.live.room.api.messagewindow.monitor.i r2 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r2 == null) goto L10;
            CardAlogParamsBuilder r3 = new CardAlogParamsBuilder();
            r3.d(CommonCardContext.TAG);
            r3.c("hideReasonObserver");
            r3.a("state", "onHide");
            r3.a("reason", Integer.valueOf(r6.a));
            r3.a("msg", r6.b);
            Unit r7 = Unit.INSTANCE;
            r2.d(r3.b());
            return;
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ HybridCard a;

        public k(HybridCard r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            IFollowPair r10 = (IFollowPair) r9;
            if (r10 == null) goto L22;
            int r11 = r10.getFollowStatus();
            com.bytedance.android.live.room.api.messagewindow.monitor.i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            boolean r1 = false;
            if (r0 == null) goto L14;
            CardAlogParamsBuilder r5 = new CardAlogParamsBuilder();
            r5.d(CommonCardContext.TAG);
            r5.c("handleJsEvent");
            r5.a("eventType", "followCardStatusChangeEvent");
            StringBuilder r6 = new StringBuilder("follow_status: ");
            if (r11 == 2) goto L12;
            if (r11 == 1) goto L12;
            boolean r7 = false;
        L13:
            r6.append(r7);
            r5.a("params", r6.toString());
            Unit r8 = Unit.INSTANCE;
            r0.d(r5.b());
        L12:
            r7 = true;
        L14:
            HybridCard r2 = this.a;
            if (r2 == null) goto L23;
            JSONObject r12 = new JSONObject();
            if (r11 == 2) goto L19;
            if (r11 == 1) goto L19;
        L20:
            r12.put("follow_status", r1);
            Unit r13 = Unit.INSTANCE;
            r2.sendJsEvent("followCardStatusChangeEvent", r12);
            return;
        L19:
            r1 = true;
            goto L20
        L23:
            return;
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ HybridCard a;

        public l(HybridCard r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            p71.a r7 = (p71.a) r6;
            com.bytedance.android.live.room.api.messagewindow.monitor.i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r0 == null) goto L6;
            CardAlogParamsBuilder r2 = new CardAlogParamsBuilder();
            r2.d(CommonCardContext.TAG);
            r2.c("handleJsEvent");
            r2.a("eventType", "commonCardShowFailureEvent");
            r2.a("params", r7.a + ": " + r7.b);
            Unit r3 = Unit.INSTANCE;
            r0.d(r2.b());
        L6:
            HybridCard r1 = this.a;
            if (r1 == null) goto L10;
            JSONObject r4 = new JSONObject();
            r4.put("code", r7.a);
            r4.put("msg", r7.b);
            Unit r8 = Unit.INSTANCE;
            r1.sendJsEvent("commonCardShowFailureEvent", r4);
            return;
        }
    }

    public static final class m extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
        public final /* synthetic */ Function0 a;

        public m(Function0 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2, CallContext r3) {
            Intrinsics.checkNotNullParameter((JSONObject) r2, "params");
            Intrinsics.checkNotNullParameter(r3, "context");
            this.a.invoke();
            JSONObject r4 = new JSONObject();
            r4.put("code", 1);
            return r4;
        }
    }

    @JvmStatic
    public static final y61.a share(DataCenter r1) {
        Companion.getClass();
        return b.b(r1);
    }

    static {
        Companion = new b();
    }

    public Pair<String, com.bytedance.ies.web.jsbridge2.f.b> provideWRDSJsMethod() {
        return TuplesKt.to("registerWrds", new f(this));
    }

    public Map<Integer, m1> getBottomRightCardData() {
        return this.bottomRightCardData;
    }

    public Map<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b> getCardLifecycleMap() {
        return this.cardLifecycleMap;
    }

    public Map<Integer, Pair<v61.a, g71.b>> getCardMap() {
        return this.cardMap;
    }

    public Map<MsgWindowPosition, Map<Integer, Pair<v61.a, g71.b>>> getCardMapV2() {
        return this.cardMapV2;
    }

    public Map<w61.b, Map<Integer, Pair<v61.a, g71.b>>> getCardMapV3() {
        return this.cardMapV3;
    }

    public Map<Integer, com.bytedance.android.live.room.api.messagewindow.builder.card.c> getCommonCardWrapperMap() {
        return this.commonCardWrapperMap;
    }

    public DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public boolean getHasInitialized() {
        return this.hasInitialized;
    }

    public DataContext getRoomContext() {
        return this.roomContext;
    }

    public Map<Integer, i3> getTopRightCardData() {
        return this.topRightCardData;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(CommonCardContext r0) {
        return r0.cd;
    }

    private final com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> closeJsEvent(Function1<? super Boolean, Unit> r2) {
        return new c(r2);
    }

    private final com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> hideJsEvent(Function1<? super Boolean, Unit> r2) {
        return new d(r2);
    }

    private final com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> preLoadedJsEvent(Function1<? super Boolean, Unit> r2) {
        return new e(r2);
    }

    private final com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> showJsEvent(Function0<Unit> r2) {
        return new m(r2);
    }

    public Map<String, Object> generateTopRightCardData(i3 r10) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r10 == null) goto L9;
        j3 r2 = r10.cardDisplayInfo;
        if (r2 == null) goto L9;
        LiveDSLModel r3 = r2.dslDetail;
        if (r3 == null) goto L9;
        String r4 = r3.getDslData();
    L10:
        r0.put("container_payload", r4);
        DataCenter r5 = getDataCenter();
        int r6 = mm0.c.a;
        String r7 = "";
        if (r5 != null) goto L121;
        IRoom r8 = null;
    L16:
        IMsgWindowProxyService r9 = jc1.k.f(IMsgWindowProxyService.class);     // Catch: Exception -> L13
        if (r9 == null) goto L19;
        l71.e r11 = r9.getLiveRoomEventParamUtils();     // Catch: Exception -> L13
    L20:
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L13
        r12.put("request_page", "bottom_right");     // Catch: Exception -> L13
        if (r11 == null) goto L24;
        String r13 = r11.c();     // Catch: Exception -> L13
        if (r13 == null) goto L24;
    L25:
        r12.put("enter_from_merge", r13);     // Catch: Exception -> L13
        if (r11 == null) goto L29;
        String r14 = r11.d();     // Catch: Exception -> L13
        if (r14 == null) goto L29;
    L30:
        r12.put("enter_method", r14);     // Catch: Exception -> L13
        if (r11 == null) goto L34;
        String r15 = r11.a();     // Catch: Exception -> L13
        if (r15 == null) goto L34;
    L35:
        r12.put("action_type", r15);     // Catch: Exception -> L13
        if (r5 == null) goto L42;
        IRoom r16 = a0.n(r5);     // Catch: Exception -> L13
        if (r16 == null) goto L42;
        String r17 = r16.getRequestId();     // Catch: Exception -> L13
        if (r17 == null) goto L42;
    L43:
        r12.put("request_id", r17);     // Catch: Exception -> L13
        if (r5 == null) goto L49;
        IRoom r18 = a0.n(r5);     // Catch: Exception -> L13
        if (r18 == null) goto L49;
        String r19 = String.valueOf(r18.getId());     // Catch: Exception -> L13
        if (r19 == null) goto L49;
    L50:
        r12.put("room_id", r19);     // Catch: Exception -> L13
        if (r5 == null) goto L58;
        IRoom r20 = a0.n(r5);     // Catch: Exception -> L13
        if (r20 == null) goto L58;
        IBaseUser r21 = r20.getOwner();     // Catch: Exception -> L13
        if (r21 == null) goto L58;
        String r22 = r21.getIdString();     // Catch: Exception -> L13
        if (r22 == null) goto L58;
    L59:
        r12.put("anchor_id", r22);     // Catch: Exception -> L13
        IMiddlewareUserService r23 = jc1.k.f(IMiddlewareUserService.class);     // Catch: Exception -> L13
        if (r23 == null) goto L65;
        com.bytedance.android.livesdk.user.e r24 = r23.user();     // Catch: Exception -> L13
        if (r24 == null) goto L65;
        String r25 = r24.n();     // Catch: Exception -> L13
        if (r25 == null) goto L65;
    L66:
        r12.put("user_id", r25);     // Catch: Exception -> L13
        if (r10 == null) goto L69;
        Integer r110 = r10.type;     // Catch: Exception -> L13
    L70:
        r12.put("card_type", r110);     // Catch: Exception -> L13
        n r26 = n.f();     // Catch: Exception -> L13
        if (r26 == null) goto L73;
        String r27 = r26.a();     // Catch: Exception -> L13
    L74:
        r12.put("ad_id", r27);     // Catch: Exception -> L13
        JSONObject r28 = mm0.c.b();     // Catch: Exception -> L13
        if (r28 == null) goto L77;
        String r29 = r28.optString("clickid");     // Catch: Exception -> L13
    L78:
        r12.put("click_id", r29);     // Catch: Exception -> L13
        Map r111 = j0.l().c(x.class).getMap();     // Catch: Exception -> L13
        if (r111 == null) goto L84;
        Iterator r112 = r111.entrySet().iterator();     // Catch: Exception -> L13
    L82:
        if (r112.hasNext() == false) goto L84;
        Map.Entry r30 = (Map.Entry) r112.next();     // Catch: Exception -> L13
        r12.put((String) r30.getKey(), r30.getValue());     // Catch: Exception -> L13
    L84:
        Map r113 = j0.l().c(IRoom.class).getMap();     // Catch: Exception -> L13
        if (r113 == null) goto L90;
        Iterator r114 = r113.entrySet().iterator();     // Catch: Exception -> L13
    L88:
        if (r114.hasNext() == false) goto L90;
        Map.Entry r31 = (Map.Entry) r114.next();     // Catch: Exception -> L13
        r12.put((String) r31.getKey(), r31.getValue());     // Catch: Exception -> L13
    L90:
        if (r8 == null) goto L101;
        IMsgWindowProxyService r115 = jc1.k.f(IMsgWindowProxyService.class);     // Catch: Exception -> L13
        if (r115 == null) goto L101;
        l71.g r116 = r115.getVSRoomLog();     // Catch: Exception -> L13
        if (r116 == null) goto L101;
        Map r117 = r116.a(r8);     // Catch: Exception -> L13
        if (r117 == null) goto L101;
        Iterator r118 = r117.entrySet().iterator();     // Catch: Exception -> L13
    L99:
        if (r118.hasNext() == false) goto L101;
        Map.Entry r32 = (Map.Entry) r118.next();     // Catch: Exception -> L13
        r12.put((String) r32.getKey(), r32.getValue());     // Catch: Exception -> L13
    L101:
        JSONObject r119 = mm0.c.b();     // Catch: Exception -> L13
        if (r119 == null) goto L107;
        Iterator r120 = ((HashMap) mm0.c.e(r119)).entrySet().iterator();     // Catch: Exception -> L13
    L105:
        if (r120.hasNext() == false) goto L107;
        Map.Entry r33 = (Map.Entry) r120.next();     // Catch: Exception -> L13
        r12.put((String) r33.getKey(), r33.getValue());     // Catch: Exception -> L13
    L107:
        Map r121 = j0.l().c(n.class).getMap();     // Catch: Exception -> L13
        if (r121 == null) goto L113;
        Iterator r122 = r121.entrySet().iterator();     // Catch: Exception -> L13
    L111:
        if (r122.hasNext() == false) goto L113;
        Map.Entry r34 = (Map.Entry) r122.next();     // Catch: Exception -> L13
        r12.put((String) r34.getKey(), r34.getValue());     // Catch: Exception -> L13
    L113:
        r7 = r12.toString();     // Catch: Exception -> L13
    L116:
        r0.put("extra", r7);
        com.bytedance.android.live.room.api.messagewindow.monitor.i r123 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r123 == null) goto L120;
        CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
        r1.d(TAG);
        r1.c("generateTopRightCardData");
        r1.a("cardData", r0.toString());
        Unit r35 = Unit.INSTANCE;
        r123.d(r1.b());
    L120:
        return r0;
    L13:
        e = move-exception;
        SafetyGuard.a(null, e, null);
        goto L116
    L77:
        r29 = null;
        goto L78
    L73:
        r27 = null;
        goto L74
    L69:
        r110 = null;
    L65:
        r25 = "";
    L58:
        r22 = "";
    L49:
        r19 = "";
    L42:
        r17 = "";
    L34:
        r15 = "";
    L29:
        r14 = "";
    L24:
        r13 = "";
        goto L25
    L19:
        r11 = null;
        goto L20
    L121:
        r8 = (IRoom) r5.get("data_room", null);     // Catch: Exception -> L13
    L9:
        r4 = null;
        goto L10
    }

    public Pair<String, com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject>> provideCloseJsMethod(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "execute");
        return TuplesKt.to("commonCardClose", closeJsEvent(r2));
    }

    public Pair<String, com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject>> provideHideJsMethod(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "execute");
        return TuplesKt.to("commonCardHide", hideJsEvent(r2));
    }

    public Pair<String, com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject>> providePreLoadedJsMethod(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "execute");
        return TuplesKt.to("preLoadingResult", preLoadedJsEvent(r2));
    }

    public Pair<String, com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject>> provideShowJsMethod(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "execute");
        return TuplesKt.to("commonCardShow", showJsEvent(r2));
    }

    public void setBottomRightCardData(Map<Integer, m1> r1) {
        this.bottomRightCardData = r1;
    }

    public void setCardLifecycleMap(Map<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.cardLifecycleMap = r2;
    }

    public void setCardMap(Map<Integer, Pair<v61.a, g71.b>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.cardMap = r2;
    }

    public void setCardMapV2(Map<MsgWindowPosition, Map<Integer, Pair<v61.a, g71.b>>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.cardMapV2 = r2;
    }

    public void setCardMapV3(Map<w61.b, Map<Integer, Pair<v61.a, g71.b>>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.cardMapV3 = r2;
    }

    public void setCommonCardWrapperMap(Map<Integer, com.bytedance.android.live.room.api.messagewindow.builder.card.c> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.commonCardWrapperMap = r2;
    }

    public void setHasInitialized(boolean r1) {
        this.hasInitialized = r1;
    }

    public void setTopRightCardData(Map<Integer, i3> r1) {
        this.topRightCardData = r1;
    }

    public CommonCardContext(DataContext r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.roomContext = r2;
        this.dataCenter = r3;
        CompositeDisposable r4 = new CompositeDisposable();
        this.cd = r4;
        this.bottomRightCardData = new LinkedHashMap();
        this.topRightCardData = new LinkedHashMap();
        this.cardMap = new LinkedHashMap();
        this.cardMapV2 = new LinkedHashMap();
        this.cardMapV3 = new LinkedHashMap();
        this.cardLifecycleMap = new LinkedHashMap();
        this.commonCardWrapperMap = new LinkedHashMap();
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), r4);
    }

    public Map<String, Object> generateCardData(m1 r22, CommonCardInitScene r23) {
        Intrinsics.checkNotNullParameter(r23, "initScene");
        LinkedHashMap r3 = new LinkedHashMap();
        if (r22 == null) goto L7;
        u1 r5 = r22.cardDisplayInfo;
        if (r5 == null) goto L7;
        String r6 = r5.containerPayload;
    L8:
        r3.put("container_payload", r6);
        if (r22 == null) goto L11;
        Integer r7 = r22.type;
    L12:
        DataCenter r8 = getDataCenter();
        int r9 = mm0.c.a;
        Intrinsics.checkNotNullParameter(r23, "initScene");
        ILiveUxTracer r2 = jc1.k.f(ILiveUxTracer.class);
        long r10 = 0;
        if (r2 == null) goto L15;
        long r11 = r2.getTimeStamp("enter_room", "start");
    L16:
        String r4 = "";
        if (r8 != null) goto L191;
        IRoom r12 = null;
    L22:
        IMsgWindowProxyService r13 = jc1.k.f(IMsgWindowProxyService.class);     // Catch: Exception -> L19
        if (r13 == null) goto L25;
        l71.e r14 = r13.getLiveRoomEventParamUtils();     // Catch: Exception -> L19
    L26:
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L19
        r15.put("request_page", "bottom_right");     // Catch: Exception -> L19
        if (r14 == null) goto L30;
        String r16 = r14.c();     // Catch: Exception -> L19
        if (r16 == null) goto L30;
    L31:
        r15.put("enter_from_merge", r16);     // Catch: Exception -> L19
        if (r14 == null) goto L35;
        String r17 = r14.d();     // Catch: Exception -> L19
        if (r17 == null) goto L35;
    L36:
        r15.put("enter_method", r17);     // Catch: Exception -> L19
        if (r14 == null) goto L40;
        String r18 = r14.a();     // Catch: Exception -> L19
        if (r18 == null) goto L40;
    L41:
        r15.put("action_type", r18);     // Catch: Exception -> L19
        if (r8 == null) goto L48;
        IRoom r19 = a0.n(r8);     // Catch: Exception -> L19
        if (r19 == null) goto L48;
        String r110 = r19.getRequestId();     // Catch: Exception -> L19
        if (r110 == null) goto L48;
    L49:
        r15.put("request_id", r110);     // Catch: Exception -> L19
        if (r8 == null) goto L55;
        IRoom r111 = a0.n(r8);     // Catch: Exception -> L19
        if (r111 == null) goto L55;
        String r112 = String.valueOf(r111.getId());     // Catch: Exception -> L19
        if (r112 == null) goto L55;
    L56:
        r15.put("room_id", r112);     // Catch: Exception -> L19
        if (r8 == null) goto L64;
        IRoom r113 = a0.n(r8);     // Catch: Exception -> L19
        if (r113 == null) goto L64;
        IBaseUser r114 = r113.getOwner();     // Catch: Exception -> L19
        if (r114 == null) goto L64;
        String r115 = r114.getIdString();     // Catch: Exception -> L19
        if (r115 == null) goto L64;
    L65:
        r15.put("anchor_id", r115);     // Catch: Exception -> L19
        IMiddlewareUserService r116 = jc1.k.f(IMiddlewareUserService.class);     // Catch: Exception -> L19
        if (r116 == null) goto L71;
        com.bytedance.android.livesdk.user.e r117 = r116.user();     // Catch: Exception -> L19
        if (r117 == null) goto L71;
        String r118 = r117.n();     // Catch: Exception -> L19
        if (r118 == null) goto L71;
    L72:
        r15.put("user_id", r118);     // Catch: Exception -> L19
        if (r22 == null) goto L77;
        u1 r119 = r22.cardDisplayInfo;     // Catch: Exception -> L19
        if (r119 == null) goto L77;
        Long r120 = r119.durationMs;     // Catch: Exception -> L19
    L78:
        r15.put("duration_ms", String.valueOf(r120));     // Catch: Exception -> L19
        if (r22 == null) goto L83;
        Boolean r121 = r22.isPreloadingNeeded;     // Catch: Exception -> L19
        if (r121 == null) goto L83;
        boolean r122 = r121.booleanValue();     // Catch: Exception -> L19
    L84:
        r15.put("is_preloading", r122);     // Catch: Exception -> L19
        if (r22 == null) goto L87;
        Integer r123 = r22.type;     // Catch: Exception -> L19
    L88:
        r15.put("card_type", r123);     // Catch: Exception -> L19
        n r124 = n.f();     // Catch: Exception -> L19
        if (r124 == null) goto L91;
        String r125 = r124.a();     // Catch: Exception -> L19
    L92:
        r15.put("ad_id", r125);     // Catch: Exception -> L19
        n r126 = n.f();     // Catch: Exception -> L19
        if (r126 == null) goto L95;
        String r127 = r126.c();     // Catch: Exception -> L19
    L96:
        r15.put("cid", r127);     // Catch: Exception -> L19
        JSONObject r128 = mm0.c.b();     // Catch: Exception -> L19
        if (r128 == null) goto L99;
        String r20 = r128.optString("clickid");     // Catch: Exception -> L19
    L100:
        r15.put("click_id", r20);     // Catch: Exception -> L19
        n r129 = n.f();     // Catch: Exception -> L19
        if (r129 == null) goto L103;
        String r130 = r129.d();     // Catch: Exception -> L19
    L104:
        r15.put("log_extra", r130);     // Catch: Exception -> L19
        if (r23 != CommonCardInitScene.ROOM_ENTER) goto L107;
        boolean r1 = true;
    L108:
        r15.put("is_enter_room_scene", r1);     // Catch: Exception -> L19
        if (r14 == null) goto L111;
        String r21 = r14.b();     // Catch: Exception -> L19
    L112:
        r15.put("is_ad_channel", r21);     // Catch: Exception -> L19
        if (r11 <= 0) goto L115;
        r10 = (System.currentTimeMillis() - SystemClock.uptimeMillis()) + r11;     // Catch: Exception -> L19
    L115:
        r15.put("enter_room_timestamp", r10);     // Catch: Exception -> L19
        if (r11 <= 0) goto L118;
        long r24 = SystemClock.uptimeMillis() - r11;     // Catch: Exception -> L19
    L119:
        r15.put("enter_room_duration", r24);     // Catch: Exception -> L19
        Map r25 = j0.l().c(x.class).getMap();     // Catch: Exception -> L19
        if (r25 == null) goto L125;
        Iterator r26 = r25.entrySet().iterator();     // Catch: Exception -> L19
    L123:
        if (r26.hasNext() == false) goto L125;
        Map.Entry r27 = (Map.Entry) r26.next();     // Catch: Exception -> L19
        r15.put((String) r27.getKey(), r27.getValue());     // Catch: Exception -> L19
    L125:
        Map r28 = j0.l().c(IRoom.class).getMap();     // Catch: Exception -> L19
        if (r28 == null) goto L131;
        Iterator r29 = r28.entrySet().iterator();     // Catch: Exception -> L19
    L129:
        if (r29.hasNext() == false) goto L131;
        Map.Entry r30 = (Map.Entry) r29.next();     // Catch: Exception -> L19
        r15.put((String) r30.getKey(), r30.getValue());     // Catch: Exception -> L19
    L131:
        if (r12 == null) goto L142;
        IMsgWindowProxyService r31 = jc1.k.f(IMsgWindowProxyService.class);     // Catch: Exception -> L19
        if (r31 == null) goto L142;
        l71.g r32 = r31.getVSRoomLog();     // Catch: Exception -> L19
        if (r32 == null) goto L142;
        Map r33 = r32.a(r12);     // Catch: Exception -> L19
        if (r33 == null) goto L142;
        Iterator r34 = r33.entrySet().iterator();     // Catch: Exception -> L19
    L140:
        if (r34.hasNext() == false) goto L142;
        Map.Entry r35 = (Map.Entry) r34.next();     // Catch: Exception -> L19
        r15.put((String) r35.getKey(), r35.getValue());     // Catch: Exception -> L19
    L142:
        JSONObject r36 = mm0.c.b();     // Catch: Exception -> L19
        if (r36 == null) goto L148;
        Iterator r37 = ((HashMap) mm0.c.e(r36)).entrySet().iterator();     // Catch: Exception -> L19
    L146:
        if (r37.hasNext() == false) goto L148;
        Map.Entry r38 = (Map.Entry) r37.next();     // Catch: Exception -> L19
        r15.put((String) r38.getKey(), r38.getValue());     // Catch: Exception -> L19
    L148:
        Map r39 = j0.l().c(n.class).getMap();     // Catch: Exception -> L19
        if (r39 == null) goto L154;
        Iterator r40 = r39.entrySet().iterator();     // Catch: Exception -> L19
    L152:
        if (r40.hasNext() == false) goto L154;
        Map.Entry r41 = (Map.Entry) r40.next();     // Catch: Exception -> L19
        r15.put((String) r41.getKey(), r41.getValue());     // Catch: Exception -> L19
    L154:
        if (r7 != null) goto L157;
    L159:
        if (r7 != null) goto L162;
    L171:
        if (r7 != null) goto L174;
    L183:
        r4 = r15.toString();     // Catch: Exception -> L19
    L186:
        r3.put("extra", r4);
        com.bytedance.android.live.room.api.messagewindow.monitor.i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L190;
        CardAlogParamsBuilder r42 = new CardAlogParamsBuilder();
        r42.d(TAG);
        r42.c("generateCardData");
        r42.a("cardData", r3.toString());
        Unit r43 = Unit.INSTANCE;
        r0.d(r42.b());
    L190:
        return r3;
    L19:
        e = move-exception;
        SafetyGuard.a(null, e, null);
        goto L186
    L174:
        if (r7.intValue() != 10) goto L183;
        IMiddlewareOpenPlatformAudienceService r44 = (IMiddlewareOpenPlatformAudienceService) jc1.k.f(IMiddlewareOpenPlatformAudienceService.class);     // Catch: Exception -> L19
        if (r44 == null) goto L183;
        Map<String, Object> r45 = r44.getMiniAppCommonCardExtraParams(r7.intValue());     // Catch: Exception -> L19
        if (r45 == null) goto L183;
        Iterator<Map.Entry<String, Object>> r46 = r45.entrySet().iterator();     // Catch: Exception -> L19
    L181:
        if (r46.hasNext() == false) goto L183;
        Map.Entry<String, Object> r47 = r46.next();     // Catch: Exception -> L19
        r15.put(r47.getKey(), r47.getValue());     // Catch: Exception -> L19
        goto L181
    L162:
        if (r7.intValue() != 9) goto L171;
        IMiddlewareOpenPlatformAnchorService r48 = (IMiddlewareOpenPlatformAnchorService) jc1.k.f(IMiddlewareOpenPlatformAnchorService.class);     // Catch: Exception -> L19
        if (r48 == null) goto L183;
        Map<String, Object> r49 = r48.getMiniAppCommonCardExtraParams(r7.intValue());     // Catch: Exception -> L19
        if (r49 == null) goto L183;
        Iterator<Map.Entry<String, Object>> r50 = r49.entrySet().iterator();     // Catch: Exception -> L19
    L169:
        if (r50.hasNext() == false) goto L183;
        Map.Entry<String, Object> r51 = r50.next();     // Catch: Exception -> L19
        r15.put(r51.getKey(), r51.getValue());     // Catch: Exception -> L19
        goto L169
    L157:
        if (r7.intValue() != 1) goto L159;
        mm0.c.a(r8, r22, r15);     // Catch: Exception -> L19
        goto L183
    L118:
        r24 = 0;
        goto L119
    L111:
        r21 = null;
        goto L112
    L107:
        r1 = false;
        goto L108
    L103:
        r130 = null;
        goto L104
    L99:
        r20 = null;
        goto L100
    L95:
        r127 = null;
        goto L96
    L91:
        r125 = null;
        goto L92
    L87:
        r123 = null;
    L83:
        r122 = false;
    L77:
        r120 = null;
    L71:
        r118 = "";
    L64:
        r115 = "";
    L55:
        r112 = "";
    L48:
        r110 = "";
    L40:
        r18 = "";
    L35:
        r17 = "";
    L30:
        r16 = "";
        goto L31
    L25:
        r14 = null;
        goto L26
    L191:
        r12 = (IRoom) r8.get("data_room", null);     // Catch: Exception -> L19
        goto L22
    L15:
        r11 = 0;
        goto L16
    L11:
        r7 = null;
    L7:
        r6 = null;
        goto L8
    }

    public void registerJsEvent(HybridCard r5, Observable<p71.a> r6) {
        com.bytedance.android.livesdk.user.e r0 = jc1.k.n(IMiddlewareUserService.class).user();
        DataCenter r1 = getDataCenter();
        if (r1 == null) goto L8;
        IRoom r2 = (IRoom) r1.get("data_room", null);
        if (r2 == null) goto L8;
        String r3 = r2.getOwnerUserIdString();
        if (r3 == null) goto L8;
    L9:
        Disposable r4 = r0.u0(r3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(r5));
        if (r4 == null) goto L12;
        RxUtilKt.c(r4, this.cd);
    L12:
        if (r6 == null) goto L17;
        Disposable r7 = r6.subscribe(new l(r5));
        if (r7 == null) goto L18;
        RxUtilKt.c(r7, this.cd);
        return;
    L18:
        return;
    L17:
        return;
    L8:
        r3 = "0";
        goto L9
    }

    public void unRegisterCardCallback(com.bytedance.android.live.room.api.messagewindow.builder.card.b r3, CompositeDisposable r4) {
        Intrinsics.checkNotNullParameter(r3, "commonCard");
        Intrinsics.checkNotNullParameter(r4, "cd");
        r4.clear();
        com.bytedance.android.live.room.api.messagewindow.monitor.i r5 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r5 == null) goto L7;
        CardAlogParamsBuilder r0 = new CardAlogParamsBuilder();
        r0.d(TAG);
        r0.c("commonCard release");
        r0.a("type", Integer.valueOf(r3.getType()));
        Unit r6 = Unit.INSTANCE;
        r5.d(r0.b());
        return;
    }

    public CompositeDisposable registerCardCallback(v61.a r3, int r4, z61.a r5) {
        Intrinsics.checkNotNullParameter(r3, "card");
        Intrinsics.checkNotNullParameter(r5, "commonCardEvent");
        CompositeDisposable r6 = new CompositeDisposable();
        Disposable r0 = r3.v().subscribe(new g(r5));
        RxUtilKt.c(r0, this.cd);
        r6.add(r0);
        Disposable r1 = r3.w().subscribe(new h(r5));
        RxUtilKt.c(r1, this.cd);
        r6.add(r1);
        r6.add(r3.f().subscribe(new i(r5)));
        r6.add(r3.l().subscribe(new j(r5)));
        return r6;
    }
}
