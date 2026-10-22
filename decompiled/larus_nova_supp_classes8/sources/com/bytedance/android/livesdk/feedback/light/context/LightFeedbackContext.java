package com.bytedance.android.livesdk.feedback.light.context;

import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.ClientImpression;
import com.bytedance.android.live.base.model.feedback.Condition;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.browser.jsbridge.base.CloseFeedbackPageResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.d0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.feedback.light.help.FeedbackIntervalHelper;
import com.bytedance.android.livesdk.feedback.service.FeedbackHideCode;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.keva.Keva;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.l;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import w20.e8;
import w20.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 \u008d\u00012\u00020\u00012\u00020\u0002:\u0002\u008e\u0001B\t¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016JG\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072.\u0010\f\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n0\t\"\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001a\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\n0\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J'\u0010 \u001a\u00020\u0005\"\u0004\b\u0000\u0010\u001d*\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010\u001f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b \u0010!J+\u0010 \u001a\u00020\u0005\"\b\b\u0000\u0010\u001d*\u00020\u000b*\b\u0012\u0004\u0012\u00028\u00000\"2\u0006\u0010\u001f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b \u0010#R!\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0$8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0$8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010*\u001a\u0004\b+\u0010(R!\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050\"8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b,\u0010&\u001a\u0004\b-\u0010.R \u00101\u001a\b\u0012\u0004\u0012\u00020\u0005008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R!\u00109\u001a\b\u0012\u0004\u0012\u00020\u0015058DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b6\u0010&\u001a\u0004\b7\u00108R,\u0010;\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u001505j\b\u0012\u0004\u0012\u00020\u0015`:8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u00108R!\u0010A\u001a\b\u0012\u0004\u0012\u00020>0\"8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b?\u0010&\u001a\u0004\b@\u0010.R!\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00050\"8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\bB\u0010&\u001a\u0004\bC\u0010.R \u0010E\u001a\b\u0012\u0004\u0012\u00020\u0005008\u0016X\u0096\u0004¢\u0006\f\n\u0004\bE\u00102\u001a\u0004\bF\u00104R!\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00050\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010&\u001a\u0004\bH\u0010.R!\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00050\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010&\u001a\u0004\bK\u0010.R!\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00050\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010&\u001a\u0004\bN\u0010.R!\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00050\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010&\u001a\u0004\bQ\u0010.R \u0010S\u001a\b\u0012\u0004\u0012\u00020\u0005008\u0016X\u0096\u0004¢\u0006\f\n\u0004\bS\u00102\u001a\u0004\bT\u00104R \u0010U\u001a\b\u0012\u0004\u0012\u00020\u0005008\u0016X\u0096\u0004¢\u0006\f\n\u0004\bU\u00102\u001a\u0004\bV\u00104R \u0010W\u001a\b\u0012\u0004\u0012\u00020\u0005008\u0016X\u0096\u0004¢\u0006\f\n\u0004\bW\u00102\u001a\u0004\bX\u00104R \u0010Y\u001a\b\u0012\u0004\u0012\u00020\u0005008\u0016X\u0096\u0004¢\u0006\f\n\u0004\bY\u00102\u001a\u0004\bZ\u00104R!\u0010]\u001a\b\u0012\u0004\u0012\u00020\u0015058DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b[\u0010&\u001a\u0004\b\\\u00108R,\u0010^\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u001505j\b\u0012\u0004\u0012\u00020\u0015`:8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b^\u0010<\u001a\u0004\b^\u00108R\"\u0010_\u001a\u00020\u00158\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\b_\u0010a\"\u0004\bb\u0010cR\u001a\u0010e\u001a\u00020d8\u0004X\u0084\u0004¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\"\u0010i\u001a\u00020\u00158\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bi\u0010`\u001a\u0004\bj\u0010a\"\u0004\bk\u0010cR\"\u0010l\u001a\u00020\u00158\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bl\u0010`\u001a\u0004\bm\u0010a\"\u0004\bn\u0010cR!\u0010t\u001a\b\u0012\u0004\u0012\u00020p0o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bq\u0010&\u001a\u0004\br\u0010sR \u0010u\u001a\b\u0012\u0004\u0012\u00020p0o8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010sR$\u0010x\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R#\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020~0$8VX\u0096\u0084\u0002¢\u0006\r\n\u0004\b\u007f\u0010&\u001a\u0005\b\u0080\u0001\u0010(R.\u0010\u0088\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0005\u0012\u00030\u0083\u00010\u0082\u00018VX\u0096\u0084\u0002¢\u0006\u0010\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020>008VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0089\u0001\u00104¨\u0006\u008f\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/light/context/LightFeedbackContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdk/feedback/light/context/a;", "Lw20/e8;", "params", "", "relaxCallback", "", "msg", "", "Lkotlin/Pair;", "", "args", "monitor", "(Ljava/lang/String;[Lkotlin/Pair;)V", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "feedItem", "showRoomFeedback", "", "Lcom/bytedance/ies/web/jsbridge2/f$b;", "provideJsMethods", "", "showing", "updateFeedbackCardShowingStatus", "showFeedbackCardWithAnim", "Lcom/bytedance/android/livesdk/feedback/service/FeedbackHideCode;", "code", "dismissFeedbackWithAnim", "reqFeedbackShow", "T", "Lcom/bytedance/live/datacontext/l;", "data", "setOnAlive", "(Lcom/bytedance/live/datacontext/l;Ljava/lang/Object;)V", "Lcom/bytedance/live/datacontext/k;", "(Lcom/bytedance/live/datacontext/k;Ljava/lang/Object;)V", "Lcom/bytedance/live/datacontext/n;", "_showRoomFeedbackEvent$delegate", "Lcom/bytedance/live/datacontext/p;", "get_showRoomFeedbackEvent", "()Lcom/bytedance/live/datacontext/n;", "_showRoomFeedbackEvent", "Lcom/bytedance/live/datacontext/n;", "getShowRoomFeedback", "_onJsCloseEvent$delegate", "get_onJsCloseEvent", "()Lcom/bytedance/live/datacontext/k;", "_onJsCloseEvent", "Lio/reactivex/Observable;", "onJsCloseEvent", "Lio/reactivex/Observable;", "getOnJsCloseEvent", "()Lio/reactivex/Observable;", "Lcom/bytedance/live/datacontext/m;", "_onJsAutoCloseEvent$delegate", "get_onJsAutoCloseEvent", "()Lcom/bytedance/live/datacontext/m;", "_onJsAutoCloseEvent", "Lcom/bytedance/android/live/core/utils/IReadonlyNonNull;", "onJsAutoCloseEvent", "Lcom/bytedance/live/datacontext/m;", "getOnJsAutoCloseEvent", "", "_onJsCloseClickEvent$delegate", "get_onJsCloseClickEvent", "_onJsCloseClickEvent", "_dismissFeedback$delegate", "get_dismissFeedback", "_dismissFeedback", "dismissFeedbackEvent", "getDismissFeedbackEvent", "_onShowStartEvent$delegate", "get_onShowStartEvent", "_onShowStartEvent", "_onShowEndEvent$delegate", "get_onShowEndEvent", "_onShowEndEvent", "_onHideStartEvent$delegate", "get_onHideStartEvent", "_onHideStartEvent", "_onHideEndEvent$delegate", "get_onHideEndEvent", "_onHideEndEvent", "onShowStartEvent", "getOnShowStartEvent", "onShowEndEvent", "getOnShowEndEvent", "onHideStartEvent", "getOnHideStartEvent", "onHideEndEvent", "getOnHideEndEvent", "_isFeedbackCardShowing$delegate", "get_isFeedbackCardShowing", "_isFeedbackCardShowing", "isFeedbackCardShowing", "isAlive", "Z", "()Z", "setAlive", "(Z)V", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "closeFeedbackByH5", "getCloseFeedbackByH5", "setCloseFeedbackByH5", "closeFeedbackByH5Auto", "getCloseFeedbackByH5Auto", "setCloseFeedbackByH5Auto", "Lcom/bytedance/live/datacontext/i;", "Lcom/bytedance/android/livesdk/feedback/light/context/b;", "_feedbackRepository$delegate", "get_feedbackRepository", "()Lcom/bytedance/live/datacontext/i;", "_feedbackRepository", "feedbackRepository", "Lcom/bytedance/live/datacontext/i;", "getFeedbackRepository", "dismissCode", "Lcom/bytedance/android/livesdk/feedback/service/FeedbackHideCode;", "getDismissCode", "()Lcom/bytedance/android/livesdk/feedback/service/FeedbackHideCode;", "setDismissCode", "(Lcom/bytedance/android/livesdk/feedback/service/FeedbackHideCode;)V", "Lhx1/b;", "feedbackAnimService$delegate", "getFeedbackAnimService", "feedbackAnimService", "Lw20/w;", "Lcom/bytedance/android/live/browser/jsbridge/base/CloseFeedbackPageResultModel;", "feedbackCloseJs$delegate", "Lkotlin/Lazy;", "getFeedbackCloseJs", "()Lw20/w;", "feedbackCloseJs", "getOnJsCloseClickEvent", "onJsCloseClickEvent", "<init>", "()V", "Companion", "c", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class LightFeedbackContext extends DataContext implements com.bytedance.android.livesdk.feedback.light.context.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final c Companion = null;
    private static final String TAG = "LightFeedbackManager";
    private final p _dismissFeedback$delegate;
    private final p _feedbackRepository$delegate;
    private final p _isFeedbackCardShowing$delegate;
    private final p _onHideEndEvent$delegate;
    private final p _onHideStartEvent$delegate;
    private final p _onJsAutoCloseEvent$delegate;
    private final p _onJsCloseClickEvent$delegate;
    private final p _onJsCloseEvent$delegate;
    private final p _onShowEndEvent$delegate;
    private final p _onShowStartEvent$delegate;
    private final p _showRoomFeedbackEvent$delegate;
    private boolean closeFeedbackByH5;
    private boolean closeFeedbackByH5Auto;
    private final CompositeDisposable compositeDisposable;
    private FeedbackHideCode dismissCode;
    private final Observable<Unit> dismissFeedbackEvent;
    private final p feedbackAnimService$delegate;
    private final Lazy feedbackCloseJs$delegate;
    private final i<com.bytedance.android.livesdk.feedback.light.context.b> feedbackRepository;
    private boolean isAlive;
    private final m<? extends Boolean> isFeedbackCardShowing;
    private final Observable<Unit> onHideEndEvent;
    private final Observable<Unit> onHideStartEvent;
    private final m<? extends Boolean> onJsAutoCloseEvent;
    private final Observable<Unit> onJsCloseEvent;
    private final Observable<Unit> onShowEndEvent;
    private final Observable<Unit> onShowStartEvent;
    private final n<FeedItem> showRoomFeedback;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ LightFeedbackContext a;

        public a(LightFeedbackContext r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            hx1.b r4 = (hx1.b) sh6.c.b((sh6.b) r3);
            if (r4 == null) goto L6;
            d0.b(r4.c(), LightFeedbackContext.access$get_onShowStartEvent$p(this.a));
            d0.b(r4.d(), LightFeedbackContext.access$get_onShowEndEvent$p(this.a));
            d0.b(r4.b(), LightFeedbackContext.access$get_onHideStartEvent$p(this.a));
            d0.b(r4.a(), LightFeedbackContext.access$get_onHideEndEvent$p(this.a));
            return;
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ LightFeedbackContext a;

        public b(LightFeedbackContext r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.setAlive(false);
            this.a.setDismissCode(null);
            this.a.getCompositeDisposable().dispose();
            i<com.bytedance.android.livesdk.feedback.light.context.b> r0 = this.a.getFeedbackRepository();
            if (r0 == null) goto L7;
            com.bytedance.android.livesdk.feedback.light.context.b r1 = (com.bytedance.android.livesdk.feedback.light.context.b) r0.getValue();
            if (r1 == null) goto L7;
            r1.release();
        L7:
            n<hx1.b> r2 = this.a.getFeedbackAnimService();
            if (r2 == null) goto L13;
            hx1.b r3 = (hx1.b) r2.getValue();
            if (r3 == null) goto L14;
            r3.cancel();
            return;
        L14:
            return;
        }
    }

    public static final class c {
        public c() {
        }
    }

    public static final class d implements f.b {
        public final /* synthetic */ LightFeedbackContext a;

        public d(LightFeedbackContext r1) {
            this.a = r1;
        }

        public final f<Object, Object> a() {
            return this.a.getFeedbackCloseJs();
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LightFeedbackContext.class, "_showRoomFeedbackEvent", "get_showRoomFeedbackEvent()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(LightFeedbackContext.class, "_onJsCloseEvent", "get_onJsCloseEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LightFeedbackContext.class, "_onJsAutoCloseEvent", "get_onJsAutoCloseEvent()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LightFeedbackContext.class, "_onJsCloseClickEvent", "get_onJsCloseClickEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LightFeedbackContext.class, "_dismissFeedback", "get_dismissFeedback()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LightFeedbackContext.class, "_onShowStartEvent", "get_onShowStartEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LightFeedbackContext.class, "_onShowEndEvent", "get_onShowEndEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LightFeedbackContext.class, "_onHideStartEvent", "get_onHideStartEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LightFeedbackContext.class, "_onHideEndEvent", "get_onHideEndEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LightFeedbackContext.class, "_isFeedbackCardShowing", "get_isFeedbackCardShowing()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LightFeedbackContext.class, "_feedbackRepository", "get_feedbackRepository()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LightFeedbackContext.class, "feedbackAnimService", "getFeedbackAnimService()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new c();
    }

    private final i<com.bytedance.android.livesdk.feedback.light.context.b> get_feedbackRepository() {
        return (i) this._feedbackRepository$delegate.a(this, $$delegatedProperties[10]);
    }

    private final k<Unit> get_onHideEndEvent() {
        return (k) this._onHideEndEvent$delegate.a(this, $$delegatedProperties[8]);
    }

    private final k<Unit> get_onHideStartEvent() {
        return (k) this._onHideStartEvent$delegate.a(this, $$delegatedProperties[7]);
    }

    private final k<Unit> get_onShowEndEvent() {
        return (k) this._onShowEndEvent$delegate.a(this, $$delegatedProperties[6]);
    }

    private final k<Unit> get_onShowStartEvent() {
        return (k) this._onShowStartEvent$delegate.a(this, $$delegatedProperties[5]);
    }

    public abstract /* synthetic */ long getAutoDismissFeedbackTime();

    public n<hx1.b> getFeedbackAnimService() {
        return (n) this.feedbackAnimService$delegate.a(this, $$delegatedProperties[11]);
    }

    public w<e8, CloseFeedbackPageResultModel> getFeedbackCloseJs() {
        return (w) this.feedbackCloseJs$delegate.getValue();
    }

    public abstract /* synthetic */ i<ix1.a> getFeedbackConfigService();

    public abstract /* synthetic */ String getLynxUrl();

    public abstract /* synthetic */ String getWebUrl();

    public final k<Unit> get_dismissFeedback() {
        return (k) this._dismissFeedback$delegate.a(this, $$delegatedProperties[4]);
    }

    public final m<Boolean> get_isFeedbackCardShowing() {
        return (m) this._isFeedbackCardShowing$delegate.a(this, $$delegatedProperties[9]);
    }

    public final m<Boolean> get_onJsAutoCloseEvent() {
        return (m) this._onJsAutoCloseEvent$delegate.a(this, $$delegatedProperties[2]);
    }

    public final k<Integer> get_onJsCloseClickEvent() {
        return (k) this._onJsCloseClickEvent$delegate.a(this, $$delegatedProperties[3]);
    }

    public final k<Unit> get_onJsCloseEvent() {
        return (k) this._onJsCloseEvent$delegate.a(this, $$delegatedProperties[1]);
    }

    public final n<FeedItem> get_showRoomFeedbackEvent() {
        return (n) this._showRoomFeedbackEvent$delegate.a(this, $$delegatedProperties[0]);
    }

    public abstract /* synthetic */ void initFeedbackConfig(DataCenter r1);

    @Override // com.bytedance.android.livesdk.feedback.light.context.a
    public void showFeedbackCardWithAnim() {
        monitor("showFeedbackCardWithAnim", new Pair[]{TuplesKt.to("isShowing", get_isFeedbackCardShowing().getValue())});
        if (((Boolean) get_isFeedbackCardShowing().getValue()).booleanValue() == true) goto L9;
        n<hx1.b> r0 = getFeedbackAnimService();
        if (r0 == null) goto L11;
        hx1.b r1 = (hx1.b) r0.getValue();
        if (r1 == null) goto L12;
        r1.show();
        return;
    L12:
        return;
    L11:
        return;
    L9:
        ALogger.e(TAG, "the feedback is showing");
    }

    public LightFeedbackContext() {
        this._showRoomFeedbackEvent$delegate = q.c(this);
        this.showRoomFeedback = get_showRoomFeedbackEvent();
        this._onJsCloseEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.onJsCloseEvent = get_onJsCloseEvent().onEvent();
        Boolean r0 = Boolean.FALSE;
        this._onJsAutoCloseEvent$delegate = q.d(this, r0);
        this.onJsAutoCloseEvent = get_onJsAutoCloseEvent();
        this._onJsCloseClickEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this._dismissFeedback$delegate = com.bytedance.live.datacontext.e.b(this);
        this.dismissFeedbackEvent = get_dismissFeedback().onEvent();
        this._onShowStartEvent$delegate = com.bytedance.live.datacontext.e.a(this, LightFeedbackContext$_onShowStartEvent$2.INSTANCE);
        this._onShowEndEvent$delegate = com.bytedance.live.datacontext.e.a(this, LightFeedbackContext$_onShowEndEvent$2.INSTANCE);
        this._onHideStartEvent$delegate = com.bytedance.live.datacontext.e.a(this, LightFeedbackContext$_onHideStartEvent$2.INSTANCE);
        this._onHideEndEvent$delegate = com.bytedance.live.datacontext.e.a(this, LightFeedbackContext$_onHideEndEvent$2.INSTANCE);
        this.onShowStartEvent = get_onShowStartEvent().onEvent();
        this.onShowEndEvent = get_onShowEndEvent().onEvent();
        this.onHideStartEvent = get_onHideStartEvent().onEvent();
        this.onHideEndEvent = get_onHideEndEvent().onEvent();
        this._isFeedbackCardShowing$delegate = q.d(this, r0);
        this.isFeedbackCardShowing = get_isFeedbackCardShowing();
        this.isAlive = true;
        CompositeDisposable r1 = new CompositeDisposable();
        this.compositeDisposable = r1;
        this._feedbackRepository$delegate = ConstantKt.d(this, new e());
        this.feedbackRepository = get_feedbackRepository();
        this.feedbackAnimService$delegate = q.b(this, LightFeedbackContext$feedbackAnimService$2.INSTANCE);
        this.feedbackCloseJs$delegate = LazyKt.lazy(new LightFeedbackContext$feedbackCloseJs$2(this));
        RxUtilKt.c(getFeedbackAnimService().a().subscribe(new a(this)), r1);
        RxUtilKt.c(getOnCleared().subscribe(new b(this)), r1);
    }

    @Override // com.bytedance.android.livesdk.feedback.light.context.a
    public Observable<Integer> getOnJsCloseClickEvent() {
        return get_onJsCloseClickEvent().onEvent();
    }

    @Override // com.bytedance.android.livesdk.feedback.light.context.a
    public List<Pair<String, f.b>> provideJsMethods() {
        return CollectionsKt.listOf(TuplesKt.to(getFeedbackCloseJs().a, new d(this)));
    }

    @Override // com.bytedance.android.livesdk.feedback.light.context.a
    public void reqFeedbackShow() {
        FeedItem r0 = (FeedItem) getShowRoomFeedback().getValue();
        if (r0 == null) goto L10;
        com.bytedance.android.livesdk.feedback.light.context.b r1 = (com.bytedance.android.livesdk.feedback.light.context.b) getFeedbackRepository().getValue();
        Room r2 = r0.getRoom();
        if (r2 == null) goto L7;
        FeedbackCard r3 = r2.mFeedbackCard;
    L8:
        r1.a(r3, r0.getRoom());
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final boolean getCloseFeedbackByH5() {
        return this.closeFeedbackByH5;
    }

    public final boolean getCloseFeedbackByH5Auto() {
        return this.closeFeedbackByH5Auto;
    }

    public final CompositeDisposable getCompositeDisposable() {
        return this.compositeDisposable;
    }

    @Override // com.bytedance.android.livesdk.feedback.light.context.a
    public FeedbackHideCode getDismissCode() {
        return this.dismissCode;
    }

    public Observable<Unit> getDismissFeedbackEvent() {
        return this.dismissFeedbackEvent;
    }

    public i<com.bytedance.android.livesdk.feedback.light.context.b> getFeedbackRepository() {
        return this.feedbackRepository;
    }

    @Override // com.bytedance.android.livesdk.feedback.light.context.a
    public Observable<Unit> getOnHideEndEvent() {
        return this.onHideEndEvent;
    }

    public Observable<Unit> getOnHideStartEvent() {
        return this.onHideStartEvent;
    }

    @Override // com.bytedance.android.livesdk.feedback.light.context.a
    public m<? extends Boolean> getOnJsAutoCloseEvent() {
        return this.onJsAutoCloseEvent;
    }

    @Override // com.bytedance.android.livesdk.feedback.light.context.a
    public Observable<Unit> getOnJsCloseEvent() {
        return this.onJsCloseEvent;
    }

    public Observable<Unit> getOnShowEndEvent() {
        return this.onShowEndEvent;
    }

    @Override // com.bytedance.android.livesdk.feedback.light.context.a
    public Observable<Unit> getOnShowStartEvent() {
        return this.onShowStartEvent;
    }

    @Override // com.bytedance.android.livesdk.feedback.light.context.a
    public n<FeedItem> getShowRoomFeedback() {
        return this.showRoomFeedback;
    }

    public final boolean isAlive() {
        return this.isAlive;
    }

    @Override // com.bytedance.android.livesdk.feedback.light.context.a
    public m<? extends Boolean> isFeedbackCardShowing() {
        return this.isFeedbackCardShowing;
    }

    public static final /* synthetic */ k access$get_onHideEndEvent$p(LightFeedbackContext r0) {
        return r0.get_onHideEndEvent();
    }

    public static final /* synthetic */ k access$get_onHideStartEvent$p(LightFeedbackContext r0) {
        return r0.get_onHideStartEvent();
    }

    public static final /* synthetic */ k access$get_onShowEndEvent$p(LightFeedbackContext r0) {
        return r0.get_onShowEndEvent();
    }

    public static final /* synthetic */ k access$get_onShowStartEvent$p(LightFeedbackContext r0) {
        return r0.get_onShowStartEvent();
    }

    @Override // com.bytedance.android.livesdk.feedback.light.context.a
    public void dismissFeedbackWithAnim(FeedbackHideCode r4) {
        Intrinsics.checkNotNullParameter(r4, "code");
        monitor("dismissFeedbackWithAnim", new Pair[]{TuplesKt.to("isShowing", get_isFeedbackCardShowing().getValue())});
        if (((Boolean) get_isFeedbackCardShowing().getValue()).booleanValue() == false) goto L9;
        setDismissCode(r4);
        n<hx1.b> r5 = getFeedbackAnimService();
        if (r5 == null) goto L11;
        hx1.b r6 = (hx1.b) r5.getValue();
        if (r6 == null) goto L12;
        r6.hide();
        return;
    L12:
        return;
    L11:
        return;
    L9:
        ALogger.e(TAG, "the feedback haven't shown");
    }

    public void relaxCallback(e8 r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        Integer r0 = r6.a();
        if (r0 != null) goto L6;
    L8:
        boolean r1 = false;
    L9:
        this.closeFeedbackByH5Auto = r1;
        Integer r7 = r6.a();
        if (r7 == null) goto L12;
        int r8 = r7.intValue();
    L13:
        FeedbackCard r4 = null;
        if (r8 == (-1)) goto L62;
        if (r8 == 0) goto L54;
        if (r8 == 1) goto L46;
        if (r8 != 2) goto L19;
        this.closeFeedbackByH5 = true;
        Keva r9 = FeedbackIntervalHelper.a;
        n<FeedItem> r10 = getShowRoomFeedback();
        if (r10 == null) goto L45;
        FeedItem r11 = (FeedItem) r10.getValue();
        if (r11 == null) goto L45;
        Room r12 = r11.getRoom();
        if (r12 == null) goto L45;
        r4 = r12.mFeedbackCard;
    L45:
        FeedbackIntervalHelper.d(r4);
        setOnAlive(get_onJsAutoCloseEvent(), Boolean.TRUE);
        monitor("auto dismiss", new Pair[0]);
        return;
    L19:
        if (r8 != 3) goto L75;
        Keva r13 = FeedbackIntervalHelper.a;
        n<FeedItem> r14 = getShowRoomFeedback();
        if (r14 == null) goto L28;
        FeedItem r15 = (FeedItem) r14.getValue();
        if (r15 == null) goto L28;
        Room r16 = r15.getRoom();
        if (r16 == null) goto L28;
        r4 = r16.mFeedbackCard;
    L28:
        FeedbackIntervalHelper.c(r4);
        n<FeedItem> r17 = getShowRoomFeedback();
        if (r17 == null) goto L37;
        FeedItem r18 = (FeedItem) r17.getValue();
        if (r18 == null) goto L37;
        Room r19 = r18.getRoom();
        if (r19 == null) goto L37;
        FeedbackCard r20 = r19.mFeedbackCard;
        if (r20 == null) goto L37;
        r20.updateFeedbackStatus(FeedbackCard.FeedbackStatus.COMPLETE);
    L37:
        monitor("mark feedback submit", new Pair[0]);
        return;
    L75:
        return;
    L46:
        this.closeFeedbackByH5 = true;
        Keva r21 = FeedbackIntervalHelper.a;
        n<FeedItem> r22 = getShowRoomFeedback();
        if (r22 == null) goto L53;
        FeedItem r23 = (FeedItem) r22.getValue();
        if (r23 == null) goto L53;
        Room r24 = r23.getRoom();
        if (r24 == null) goto L53;
        r4 = r24.mFeedbackCard;
    L53:
        FeedbackIntervalHelper.c(r4);
        setOnAlive(get_onJsCloseEvent(), Unit.INSTANCE);
        monitor("submit_positive", new Pair[0]);
        return;
    L54:
        this.closeFeedbackByH5 = true;
        Keva r25 = FeedbackIntervalHelper.a;
        n<FeedItem> r26 = getShowRoomFeedback();
        if (r26 == null) goto L61;
        FeedItem r27 = (FeedItem) r26.getValue();
        if (r27 == null) goto L61;
        Room r28 = r27.getRoom();
        if (r28 == null) goto L61;
        r4 = r28.mFeedbackCard;
    L61:
        FeedbackIntervalHelper.d(r4);
        setOnAlive(get_onJsCloseEvent(), Unit.INSTANCE);
        monitor("close", new Pair[0]);
        return;
    L62:
        this.closeFeedbackByH5 = true;
        Keva r29 = FeedbackIntervalHelper.a;
        n<FeedItem> r30 = getShowRoomFeedback();
        if (r30 == null) goto L69;
        FeedItem r31 = (FeedItem) r30.getValue();
        if (r31 == null) goto L69;
        Room r32 = r31.getRoom();
        if (r32 == null) goto L69;
        r4 = r32.mFeedbackCard;
    L69:
        FeedbackIntervalHelper.c(r4);
        setOnAlive(get_onJsCloseEvent(), Unit.INSTANCE);
        setOnAlive(get_onJsCloseClickEvent(), -1);
        monitor("submit_negative", new Pair[0]);
        return;
    L12:
        r8 = 0;
        goto L13
    L6:
        if (r0.intValue() != 2) goto L8;
        r1 = true;
        goto L9
    }

    public final void setAlive(boolean r1) {
        this.isAlive = r1;
    }

    public final void setCloseFeedbackByH5(boolean r1) {
        this.closeFeedbackByH5 = r1;
    }

    public final void setCloseFeedbackByH5Auto(boolean r1) {
        this.closeFeedbackByH5Auto = r1;
    }

    public void setDismissCode(FeedbackHideCode r1) {
        this.dismissCode = r1;
    }

    @Override // com.bytedance.android.livesdk.feedback.light.context.a
    public void showRoomFeedback(FeedItem r13) {
        Intrinsics.checkNotNullParameter(r13, "feedItem");
        monitor("showRoomFeedback", new Pair[]{TuplesKt.to("isShowing", get_isFeedbackCardShowing().getValue())});
        if (((Boolean) get_isFeedbackCardShowing().getValue()).booleanValue() == true) goto L39;
        monitor("show feed", new Pair[0]);
        Keva r1 = FeedbackIntervalHelper.a;
        Room r2 = r13.getRoom();
        FeedbackIntervalHelper.a.C0317a r3 = null;
        if (r2 == null) goto L7;
        FeedbackCard r4 = r2.mFeedbackCard;
    L8:
        if (r4 != null) goto L10;
    L38:
        setOnAlive(get_showRoomFeedbackEvent(), r13);
        return;
    L10:
        if (r4.shouldRecordIgnoreAction() == false) goto L12;
        FeedbackCard r5 = r4;
    L13:
        if (r5 == null) goto L38;
        Condition r6 = r5.condition;
        if (r6 == null) goto L38;
        ClientImpression r7 = r6.clientImpression;
        if (r7 == null) goto L38;
        Long r8 = r7.ignoreCounts;
        if (r8 == null) goto L21;
        long r9 = r8.longValue();
    L22:
        Long r10 = r7.ignoreInterval;
        if (r10 == null) goto L25;
        long r11 = r10.longValue();
    L26:
        long r12 = r11 * 86400000;
        FeedbackIntervalHelper.a.C0317a r14 = FeedbackIntervalHelper.a().a().get(r4.feedbackId);
        if (r14 == null) goto L38;
        if (r14.a() >= r9) goto L31;
    L33:
        boolean r15 = false;
    L34:
        if (r15 == false) goto L36;
        r3 = r14;
    L36:
        if (r3 == null) goto L38;
        int r16 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r17 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("FeedbackIntervalHelper", "page");
        r17.a = "FeedbackIntervalHelper";
        r17.c("问卷忽略的展示间隔超过频率间隔控制，重置忽略次数");
        r17.b(new Pair[]{TuplesKt.to("feedbackId", r4.feedbackId)});
        r17.d();
        FeedbackIntervalHelper.e(r4);
        goto L38
    L31:
        if ((System.currentTimeMillis() - r14.b()) <= r12) goto L33;
        r15 = true;
        goto L34
    L25:
        r11 = 30;
        goto L26
    L21:
        r9 = 3;
        goto L22
    L12:
        r5 = null;
        goto L13
    L7:
        r4 = null;
        goto L8
    L39:
        ALogger.e(TAG, "the feedback is showing");
    }

    @Override // com.bytedance.android.livesdk.feedback.light.context.a
    public void updateFeedbackCardShowingStatus(boolean r2) {
        setOnAlive(get_isFeedbackCardShowing(), Boolean.valueOf(r2));
    }

    public final void monitor(String r5, Pair<String, ? extends Object>... r6) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        Intrinsics.checkNotNullParameter(r6, "args");
        int r0 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r1 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LightFeedbackContext", "page");
        r1.a = "LightFeedbackContext";
        r1.c(r5);
        int r7 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r7) goto L8;
        Pair<String, ? extends Object> r3 = r6[r2];
        Object r4 = r3.getSecond();
        if (r4 == null) goto L7;
        r1.a((String) r3.getFirst(), r4);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        r1.d();
    }

    public final <T> void setOnAlive(k<T> r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$setOnAlive");
        Intrinsics.checkNotNullParameter(r3, "data");
        if (this.isAlive == false) goto L5;
        r2.post(r3);
        return;
    L5:
        ALogger.e(TAG, "the LightFeedbackManager is not alive.data is " + r3);
    }

    public final <T> void setOnAlive(l<T> r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$setOnAlive");
        if (this.isAlive == false) goto L5;
        r2.setValue(r3);
        return;
    L5:
        ALogger.e(TAG, "the LightFeedbackManager is not alive.data is " + r3);
    }
}
