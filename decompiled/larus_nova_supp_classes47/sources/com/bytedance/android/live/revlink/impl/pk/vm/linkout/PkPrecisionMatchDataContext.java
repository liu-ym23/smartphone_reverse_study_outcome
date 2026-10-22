package com.bytedance.android.live.revlink.impl.pk.vm.linkout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattlePrecisionMatcher;
import com.bytedance.android.livesdk.link.model.bridge.s0;
import com.bytedance.android.livesdk.link.model.d2;
import com.bytedance.android.livesdk.link.model.d5;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.link.model.w;
import com.bytedance.android.livesdk.link.model.w3;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import i41.q;
import i41.r;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000×\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0001m\u0018\u0000 È\u00012\u00020\u00012\u00020\u0002:\u0006É\u0001Ê\u0001Ë\u0001BE\u0012\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u0001\u0012\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u0001\u0012\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u0001\u0012\n\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u0001\u0012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u0001¢\u0006\u0006\bÆ\u0001\u0010Ç\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\n\u001a\u00020\u00032\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0003H\u0002J(\u0010 \u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\u0011\u0010!\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b!\u0010\"J\u0006\u0010#\u001a\u00020\u0003J\u0006\u0010$\u001a\u00020\u0003J\u0018\u0010(\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u001bH\u0016J\b\u0010+\u001a\u0004\u0018\u00010\u0013J\b\u0010,\u001a\u00020\u0005H\u0016J\n\u0010-\u001a\u0004\u0018\u00010\u0017H\u0016J\n\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u0014\u00101\u001a\u00020\u00032\f\u00100\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0006\u00102\u001a\u00020\u0017J\u0006\u00103\u001a\u00020\u0017J\u0006\u00104\u001a\u00020\u0017J\u0016\u00107\u001a\u0012\u0012\u0004\u0012\u00020\f05j\b\u0012\u0004\u0012\u00020\f`6J\u0006\u00108\u001a\u00020\u0010J\b\u00109\u001a\u00020\u0003H\u0016J\u0010\u0010;\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u001bH\u0016R\u0018\u0010>\u001a\u00060<j\u0002`=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010A\u001a\u0004\u0018\u00010@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u001e\u0010G\u001a\n\u0018\u00010Ej\u0004\u0018\u0001`F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u001e\u0010K\u001a\n\u0018\u00010Ij\u0004\u0018\u0001`J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010M\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010DR\u0018\u0010N\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR*\u0010P\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u000105j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`68\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010T\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\"\u0010V\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010D\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010[\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010a\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010S\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0016\u0010f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010DR\u0018\u0010g\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010i\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010SR\u0016\u0010k\u001a\u0004\u0018\u00010j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010n\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR'\u0010r\u001a\u0012\u0012\u0004\u0012\u00020\u00130pj\b\u0012\u0004\u0012\u00020\u0013`q8\u0006¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR'\u0010v\u001a\u0012\u0012\u0004\u0012\u00020\u00130pj\b\u0012\u0004\u0012\u00020\u0013`q8\u0006¢\u0006\f\n\u0004\bv\u0010s\u001a\u0004\bw\u0010uR$\u0010x\u001a\u0012\u0012\u0004\u0012\u00020&0pj\b\u0012\u0004\u0012\u00020&`q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010sR'\u0010y\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'8\u0006¢\u0006\f\n\u0004\by\u0010z\u001a\u0004\b{\u0010|R\u0014\u0010~\u001a\u00020}8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001a\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001a\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001a\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001a\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001a\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001a\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u008f\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0019\u0010\u0095\u0001\u001a\u0004\u0018\u00010j8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001a\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0096\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001a\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009a\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001a\u0010¡\u0001\u001a\u0005\u0018\u00010\u009e\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009f\u0001\u0010 \u0001R\u001a\u0010¥\u0001\u001a\u0005\u0018\u00010¢\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b£\u0001\u0010¤\u0001R\u001a\u0010©\u0001\u001a\u0005\u0018\u00010¦\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b§\u0001\u0010¨\u0001R\u001a\u0010\u00ad\u0001\u001a\u0005\u0018\u00010ª\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b«\u0001\u0010¬\u0001R\u001a\u0010±\u0001\u001a\u0005\u0018\u00010®\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b¯\u0001\u0010°\u0001R\u001a\u0010µ\u0001\u001a\u0005\u0018\u00010²\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b³\u0001\u0010´\u0001R\u001a\u0010¹\u0001\u001a\u0005\u0018\u00010¶\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b·\u0001\u0010¸\u0001R\u001a\u0010½\u0001\u001a\u0005\u0018\u00010º\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b»\u0001\u0010¼\u0001R\u001a\u0010Á\u0001\u001a\u0005\u0018\u00010¾\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b¿\u0001\u0010À\u0001R\u001a\u0010Å\u0001\u001a\u0005\u0018\u00010Â\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bÃ\u0001\u0010Ä\u0001¨\u0006Ì\u0001"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/PkPrecisionMatchDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/pk/service/e;", "", "autoRejectReset", "", "handleAvailable", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "onMessage", "", "Lcom/bytedance/android/livesdk/link/model/IBattlePrecisionMatcher;", "matcherList", "Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/PkPrecisionMatchDataContext$MatchMsgStatus;", "getMatchMsgStatus", "", "resetSeconds", "resetTimerAfterAgree", "Lcom/bytedance/android/livesdk/link/model/d5;", "precisionMatchMessage", "onReceivePrecisionMatchMessage", "matcher", "", "activityName", "handlePrecisionMatchInvite", "cancelPrecisionMatchTimeOut", "", "respondType", "precisionMatchId", "source", "flexActivityId", "replyMatch", "getLinkDuration", "()Ljava/lang/Long;", "replyAgreeSuccess", "clearIt", "Landroidx/lifecycle/LiveData;", "Ll41/b;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/LiveData;", "getMatchState", "isMatchingCount", "getSelfStats", "getMessage", "isMatchWaiting", "getOppoMatcherUserId", "Lcom/bytedance/android/livesdk/link/model/d2;", "getBattlePrecisionMatch", "list", "addPrecisionMatcherList", "getMatchReason", "getActivityName", "getRecommendReason", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPrecisionMatcherList", "getMatchId", "resetPrecisionMatch", "accept", "onPrecisionMatchEvent", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/livesdk/revenue/room/a;", "roomContext", "Lcom/bytedance/android/livesdk/revenue/room/a;", "isAnchor", "Z", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lio/reactivex/disposables/Disposable;", "Lcom/bytedance/revenue/platform/api/core/rx/Disposable;", "mPrecisionMatchTimeOutSubscribe", "Lio/reactivex/disposables/Disposable;", "precisionMatchCountdown", "matchMessage", "Lcom/bytedance/android/livesdk/link/model/d5;", "precisionMatcherList", "Ljava/util/ArrayList;", "curPrecisionMatchId", "J", "mBattlePrecisionMatch", "Lcom/bytedance/android/livesdk/link/model/d2;", "precisionMatchWaiting", "getPrecisionMatchWaiting", "()Z", "setPrecisionMatchWaiting", "(Z)V", "oppoPrecisionMatcher", "Lcom/bytedance/android/livesdk/link/model/IBattlePrecisionMatcher;", "getOppoPrecisionMatcher", "()Lcom/bytedance/android/livesdk/link/model/IBattlePrecisionMatcher;", "setOppoPrecisionMatcher", "(Lcom/bytedance/android/livesdk/link/model/IBattlePrecisionMatcher;)V", "precisionMatchWaitingSeconds", "getPrecisionMatchWaitingSeconds", "()J", "setPrecisionMatchWaitingSeconds", "(J)V", "handleAfterReset", "linkDuration", "Ljava/lang/Long;", "waitSeconds", "Lcom/bytedance/android/live/revenuelink/connect/f;", "connectService", "Lcom/bytedance/android/live/revenuelink/connect/f;", "com/bytedance/android/live/revlink/impl/pk/vm/linkout/PkPrecisionMatchDataContext$connectStateObserver$1", "connectStateObserver", "Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/PkPrecisionMatchDataContext$connectStateObserver$1;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/MutableLiveData;", "showDialogData", "Landroidx/lifecycle/MutableLiveData;", "getShowDialogData", "()Landroidx/lifecycle/MutableLiveData;", "updateLynxMatchUserStatus", "getUpdateLynxMatchUserStatus", "_pkPrecisionMatchState", "pkPrecisionMatchState", "Landroidx/lifecycle/LiveData;", "getPkPrecisionMatchState", "()Landroidx/lifecycle/LiveData;", "Li41/q;", "mPrecisionMatchListener", "Li41/q;", "Lld/a;", "linkDataSet", "Lld/a;", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "roomService", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lyz0/f;", "messageService", "Lyz0/f;", "Lx11/a;", "internalLinkService", "Lx11/a;", "Lw31/e;", "getPrecisionMatchMonitor", "()Lw31/e;", "precisionMatchMonitor", "getAnchorConnectService", "()Lcom/bytedance/android/live/revenuelink/connect/f;", "anchorConnectService", "Li41/a;", "getAutoMatchManager", "()Li41/a;", "autoMatchManager", "Le21/b;", "getClientAttachedInfoObj", "()Le21/b;", "clientAttachedInfoObj", "Lcom/bytedance/android/live/revlink/impl/LinkCrossRoomDataHolder;", "getLinkCrossRoomDataHolder", "()Lcom/bytedance/android/live/revlink/impl/LinkCrossRoomDataHolder;", "linkCrossRoomDataHolder", "Lr31/a;", "getLinkNetwork", "()Lr31/a;", "linkNetwork", "Lcom/bytedance/android/live/revlink/impl/control/d;", "getAnchorLogParamsService", "()Lcom/bytedance/android/live/revlink/impl/control/d;", "anchorLogParamsService", "Lox0/a;", "getModeMerge", "()Lox0/a;", "modeMerge", "Lcom/bytedance/android/live/revlink/impl/service/internal/a;", "getLinkRevInternalService", "()Lcom/bytedance/android/live/revlink/impl/service/internal/a;", "linkRevInternalService", "Lcom/bytedance/android/live/revlink/impl/multianchor/service/d;", "getMultiAnchorService", "()Lcom/bytedance/android/live/revlink/impl/multianchor/service/d;", "multiAnchorService", "Lcom/bytedance/android/live/revlink/impl/pk/service/a;", "getPKAutoMatchService", "()Lcom/bytedance/android/live/revlink/impl/pk/service/a;", "pKAutoMatchService", "Lcom/bytedance/android/live/revlink/impl/pk/service/IPKLinkBizDataService;", "getPKLinkBizDataService", "()Lcom/bytedance/android/live/revlink/impl/pk/service/IPKLinkBizDataService;", "pKLinkBizDataService", "Lcom/bytedance/android/live/revlink/impl/pk/service/d;", "getPkLinkDataService", "()Lcom/bytedance/android/live/revlink/impl/pk/service/d;", "pkLinkDataService", "Lcom/bytedance/android/live/revlink/impl/pk/service/i;", "getToolbarPkService", "()Lcom/bytedance/android/live/revlink/impl/pk/service/i;", "toolbarPkService", "<init>", "(Lld/a;Lcom/bytedance/android/livesdk/revenue/service/room/c;Lcom/bytedance/android/live/revlink/impl/global/c;Lyz0/f;Lx11/a;)V", "Companion", "d", "MatchMsgStatus", "PrecisionMatchSource", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkPrecisionMatchDataContext extends DataContext implements com.bytedance.android.live.revlink.impl.pk.service.e {
    public static final d Companion = null;
    public static final long PRECISION_MATCH_TIME_OUT = 20;
    public static final long PRECISION_MATCH_WAITING_TIME_OUT = 10;
    public static final String TAG = "PkPrecisionMatchDataContext";
    private final MutableLiveData<l41.b> _pkPrecisionMatchState;
    private final CompositeDisposable cd;
    private final com.bytedance.android.live.revenuelink.connect.f connectService;
    private final PkPrecisionMatchDataContext$connectStateObserver$1 connectStateObserver;
    private long curPrecisionMatchId;
    private boolean handleAfterReset;
    private final x11.a internalLinkService;
    private boolean isAnchor;
    private final ld.a linkDataSet;
    private Long linkDuration;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private d2 mBattlePrecisionMatch;
    private final q mPrecisionMatchListener;
    private Disposable mPrecisionMatchTimeOutSubscribe;
    private d5 matchMessage;
    private final yz0.f messageService;
    private IBattlePrecisionMatcher oppoPrecisionMatcher;
    private final LiveData<l41.b> pkPrecisionMatchState;
    private boolean precisionMatchCountdown;
    private boolean precisionMatchWaiting;
    private long precisionMatchWaitingSeconds;
    private ArrayList<IBattlePrecisionMatcher> precisionMatcherList;
    private IRoom room;
    private final com.bytedance.android.livesdk.revenue.room.a roomContext;
    private final com.bytedance.android.livesdk.revenue.service.room.c roomService;
    private final MutableLiveData<d5> showDialogData;
    private final MutableLiveData<d5> updateLynxMatchUserStatus;
    private long waitSeconds;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkPrecisionMatchDataContext$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass2(PkPrecisionMatchDataContext r8) {
            super(1, r8, PkPrecisionMatchDataContext.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            PkPrecisionMatchDataContext.access$onMessage((PkPrecisionMatchDataContext) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/PkPrecisionMatchDataContext$MatchMsgStatus;", "", "UNDEFINED", "START", "ALL_AGREE", "OPPO_REJECT", "OPPP_LATER", "SELF_REJECT", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum MatchMsgStatus extends Enum<MatchMsgStatus> {
        public static final MatchMsgStatus ALL_AGREE = null;
        public static final MatchMsgStatus OPPO_REJECT = null;
        public static final MatchMsgStatus OPPP_LATER = null;
        public static final MatchMsgStatus SELF_REJECT = null;
        public static final MatchMsgStatus START = null;
        public static final MatchMsgStatus UNDEFINED = null;
        public static final /* synthetic */ MatchMsgStatus[] a = null;

        static {
            MatchMsgStatus r1 = new MatchMsgStatus("UNDEFINED", 0);
            UNDEFINED = r1;
            MatchMsgStatus r2 = new MatchMsgStatus("START", 1);
            START = r2;
            MatchMsgStatus r3 = new MatchMsgStatus("ALL_AGREE", 2);
            ALL_AGREE = r3;
            MatchMsgStatus r4 = new MatchMsgStatus("OPPO_REJECT", 3);
            OPPO_REJECT = r4;
            MatchMsgStatus r5 = new MatchMsgStatus("OPPP_LATER", 4);
            OPPP_LATER = r5;
            MatchMsgStatus r6 = new MatchMsgStatus("SELF_REJECT", 5);
            SELF_REJECT = r6;
            a = new MatchMsgStatus[]{r1, r2, r3, r4, r5, r6};
        }

        public static MatchMsgStatus valueOf(String r1) {
            return (MatchMsgStatus) r27.a.a(MatchMsgStatus.class, r1);
        }

        public static MatchMsgStatus[] values() {
            return (MatchMsgStatus[]) a.clone();
        }

        public MatchMsgStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/PkPrecisionMatchDataContext$PrecisionMatchSource;", "", "", "status", "I", "getStatus", "()I", "setStatus", "(I)V", "PrecisionMatchSourceDefault", "PrecisionMatchSourceFlexActivity", "PrecisionMatchSourceGuildActivity", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum PrecisionMatchSource extends Enum<PrecisionMatchSource> {
        public static final PrecisionMatchSource PrecisionMatchSourceDefault = null;
        public static final PrecisionMatchSource PrecisionMatchSourceFlexActivity = null;
        public static final PrecisionMatchSource PrecisionMatchSourceGuildActivity = null;
        public static final /* synthetic */ PrecisionMatchSource[] a = null;
        private int status;

        static {
            PrecisionMatchSource r1 = new PrecisionMatchSource("PrecisionMatchSourceDefault", 0, 0);
            PrecisionMatchSourceDefault = r1;
            PrecisionMatchSource r2 = new PrecisionMatchSource("PrecisionMatchSourceFlexActivity", 1, 1);
            PrecisionMatchSourceFlexActivity = r2;
            PrecisionMatchSource r3 = new PrecisionMatchSource("PrecisionMatchSourceGuildActivity", 2, 2);
            PrecisionMatchSourceGuildActivity = r3;
            a = new PrecisionMatchSource[]{r1, r2, r3};
        }

        public static PrecisionMatchSource valueOf(String r1) {
            return (PrecisionMatchSource) r27.a.a(PrecisionMatchSource.class, r1);
        }

        public static PrecisionMatchSource[] values() {
            return (PrecisionMatchSource[]) a.clone();
        }

        public final int getStatus() {
            return this.status;
        }

        public final void setStatus(int r1) {
            this.status = r1;
        }

        public PrecisionMatchSource(String r1, int r2, int r3) {
            super(r1, r2);
            this.status = r3;
        }
    }

    public static final class a implements Action {
        public final /* synthetic */ PkPrecisionMatchDataContext a;

        public a(PkPrecisionMatchDataContext r1) {
            this.a = r1;
        }

        public final void run() {
            com.bytedance.android.live.revenuelink.connect.f r0 = PkPrecisionMatchDataContext.access$getConnectService$p(this.a);
            if (r0 == null) goto L7;
            LiveData<ey.f> r1 = r0.connectState();
            if (r1 == null) goto L7;
            r1.removeObserver(PkPrecisionMatchDataContext.access$getConnectStateObserver$p(this.a));
        L7:
            r r2 = r.c.a();
            q r3 = PkPrecisionMatchDataContext.access$getMPrecisionMatchListener$p(this.a);
            r2.getClass();
            Intrinsics.checkNotNullParameter(r3, "listener");
            if (((ArrayList) r2.a).contains(r3) == false) goto L11;
            ((ArrayList) r2.a).remove(r3);
        L11:
            this.a.resetPrecisionMatch();
            PkPrecisionMatchDataContext.access$getCd$p(this.a).dispose();
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r6) {
            ExtraResponse r7 = (ExtraResponse) r6;
            if (r7 == null) goto L5;
            com.bytedance.android.livesdk.link.model.g r1 = (com.bytedance.android.livesdk.link.model.g) r7.data;
        L6:
            if (r1 == null) goto L19;
            com.bytedance.android.livesdk.link.model.g r2 = (com.bytedance.android.livesdk.link.model.g) r7.data;
            if (r2 == null) goto L10;
            w r3 = r2.getAnchorPrecisionMatchSettings();
        L11:
            if (r3 == null) goto L20;
            com.bytedance.android.livesdk.link.model.g r8 = (com.bytedance.android.livesdk.link.model.g) r7.data;
            if (r8 == null) goto L15;
            w r9 = r8.getAnchorPrecisionMatchSettings();
        L16:
            if (r9 == null) goto L21;
            boolean r4 = r9.getAcceptPrecisionMatch();
            com.bytedance.tools.kcp.spongepreference.runtime.a r5 = l51.a.Z;
            KProperty[] r10 = l51.a.a;
            r5.setValue(null, r10[59], Boolean.valueOf(r4));
            l51.a.z0.setValue(null, r10[87], Integer.valueOf((int) r9.getPrecisionMatchPreferGender()));
            l51.a.A0.setValue(null, r10[88], Integer.valueOf((int) r9.getPrecisionMatchFrequency()));
            return;
        L21:
            return;
        L15:
            r9 = null;
            goto L16
        L20:
            return;
        L10:
            r3 = null;
            goto L11
        L19:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "obj");
            r3.printStackTrace();
        }
    }

    public static final class d {
        public d() {
        }
    }

    public static final class e implements q {
        public final /* synthetic */ PkPrecisionMatchDataContext a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ e a;
            public final /* synthetic */ int b;
            public final /* synthetic */ long c;

            public a(e r1, int r2, long r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void accept(Object r12) {
                ExtraResponse r13 = (ExtraResponse) r12;
                PkPrecisionMatchDataContext.access$autoRejectReset(this.a.a);
                w31.e r0 = PkPrecisionMatchDataContext.access$getPrecisionMatchMonitor$p(this.a.a);
                if (r0 == null) goto L15;
                int r1 = this.b;
                long r2 = this.c;
                d2 r14 = PkPrecisionMatchDataContext.access$getMBattlePrecisionMatch$p(this.a.a);
                if (r14 == null) goto L7;
                int r4 = r14.getSource();
            L8:
                d2 r15 = PkPrecisionMatchDataContext.access$getMBattlePrecisionMatch$p(this.a.a);
                if (r15 == null) goto L12;
                String r16 = r15.getActivityId();
                if (r16 == null) goto L12;
            L13:
                r0.a(r1, r2, r4, r16, 0, null, "time_out");
                return;
            L12:
                r16 = "";
                goto L13
            L7:
                r4 = 0;
                goto L8
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ e a;
            public final /* synthetic */ int b;
            public final /* synthetic */ long c;

            public b(e r1, int r2, long r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void accept(Object r12) {
                Throwable r8 = (Throwable) r12;
                Intrinsics.checkNotNullParameter(r8, "throwable");
                PkPrecisionMatchDataContext.access$autoRejectReset(this.a.a);
                r8.printStackTrace();
                w31.e r0 = PkPrecisionMatchDataContext.access$getPrecisionMatchMonitor$p(this.a.a);
                if (r0 == null) goto L15;
                int r1 = this.b;
                long r2 = this.c;
                d2 r13 = PkPrecisionMatchDataContext.access$getMBattlePrecisionMatch$p(this.a.a);
                if (r13 == null) goto L7;
                int r4 = r13.getSource();
            L8:
                d2 r14 = PkPrecisionMatchDataContext.access$getMBattlePrecisionMatch$p(this.a.a);
                if (r14 == null) goto L12;
                String r15 = r14.getActivityId();
                if (r15 == null) goto L12;
            L13:
                r0.a(r1, r2, r4, r15, 0, r8, "time_out");
                return;
            L12:
                r15 = "";
                goto L13
            L7:
                r4 = 0;
                goto L8
            }
        }

        @Override // i41.q
        public final void onEnd() {
            com.bytedance.android.live.revlink.impl.pk.service.i r0 = PkPrecisionMatchDataContext.access$getToolbarPkService$p(this.a);
            if (r0 == null) goto L5;
            r0.h3();
        L5:
            PkPrecisionMatchDataContext.access$get_pkPrecisionMatchState$p(this.a).setValue(l41.b.a.a);
        }

        public e(PkPrecisionMatchDataContext r1) {
            this.a = r1;
        }

        @Override // i41.q
        public final void a(long r12) {
            w31.e r0 = PkPrecisionMatchDataContext.access$getPrecisionMatchMonitor$p(this.a);
            String r1 = null;
            if (r0 == null) goto L5;
            Intrinsics.checkNotNullParameter("onAutoReject", "source");
            LinkedHashMap r5 = new LinkedHashMap();
            r5.put("source", "onAutoReject");
            r0.b("precision_match_timeout_reset", r5, 0, null);
        L5:
            d2 r2 = PkPrecisionMatchDataContext.access$getMBattlePrecisionMatch$p(this.a);
            if (r2 != null) goto L8;
        L10:
            int r3 = 2;
        L12:
            if (this.a.getPrecisionMatchWaiting() == false) goto L26;
            d2 r13 = PkPrecisionMatchDataContext.access$getMBattlePrecisionMatch$p(this.a);
            if (r13 != null) goto L16;
        L21:
            int r14 = ToastUtil.a;
            int r15 = w11.a.a;
            ToastUtil.a(2131917912, 0);
        L22:
            com.bytedance.android.live.revlink.impl.pk.service.i r16 = PkPrecisionMatchDataContext.access$getToolbarPkService$p(this.a);
            if (r16 == null) goto L25;
            r16.h3();
        L25:
            PkPrecisionMatchDataContext.access$get_pkPrecisionMatchState$p(this.a).setValue(l41.b.a.a);
            this.a.setPrecisionMatchWaiting(false);
            PkPrecisionMatchDataContext.access$setPrecisionMatchCountdown$p(this.a, false);
            PkPrecisionMatchDataContext.access$cancelPrecisionMatchTimeOut(this.a);
            return;
        L16:
            if (r13.getSource() != PrecisionMatchSource.PrecisionMatchSourceGuildActivity.ordinal()) goto L21;
            int r17 = ToastUtil.a;
            d2 r18 = PkPrecisionMatchDataContext.access$getMBattlePrecisionMatch$p(this.a);
            if (r18 == null) goto L20;
            r1 = r18.getToastContent();
        L20:
            ToastUtil.b(r1, 0);
            goto L22
        L26:
            r31.a r4 = PkPrecisionMatchDataContext.access$getLinkNetwork$p(this.a);
            if (r4 == null) goto L48;
            d2 r6 = PkPrecisionMatchDataContext.access$getMBattlePrecisionMatch$p(this.a);
            if (r6 == null) goto L31;
            int r7 = r6.getSource();
        L32:
            d2 r8 = PkPrecisionMatchDataContext.access$getMBattlePrecisionMatch$p(this.a);
            if (r8 == null) goto L36;
            String r9 = r8.getActivityId();
            if (r9 == null) goto L36;
        L37:
            int r10 = r3;
            Observable<ExtraResponse<Object, Extra>> r19 = r4.a(r10, r12, r7, r9, 0);
            if (r19 == null) goto L49;
            int r20 = com.bytedance.revenue.platform.api.core.rx.p.a;
            Observable r22 = r19.subscribeOn(Schedulers.io());
            if (r22 == null) goto L50;
            Observable r23 = r22.observeOn(AndroidSchedulers.mainThread());
            if (r23 == null) goto L51;
            Disposable r110 = r23.subscribe(new a(this, r3, r12), new b(this, r3, r12));
            if (r110 == null) goto L52;
            com.bytedance.revenue.platform.api.core.rx.f.a(r110, PkPrecisionMatchDataContext.access$getCd$p(this.a));
            return;
        L52:
            return;
        L51:
            return;
        L50:
            return;
        L49:
            return;
        L36:
            r9 = "";
            goto L37
        L31:
            r7 = 0;
            goto L32
        L48:
            return;
        L8:
            if (r2.getSource() != PrecisionMatchSource.PrecisionMatchSourceGuildActivity.ordinal()) goto L10;
            r3 = 3;
            goto L12
        }

        @Override // i41.q
        public final void b(d5 r2) {
            Intrinsics.checkNotNullParameter(r2, "precisionMatchMessage");
            com.bytedance.android.live.revlink.impl.pk.service.i r0 = PkPrecisionMatchDataContext.access$getToolbarPkService$p(this.a);
            if (r0 == null) goto L5;
            r0.m3(r2);
        L5:
            PkPrecisionMatchDataContext.access$get_pkPrecisionMatchState$p(this.a).setValue(l41.b.C0266b.a);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ IBattlePrecisionMatcher a;
        public final /* synthetic */ PkPrecisionMatchDataContext b;
        public final /* synthetic */ Ref.ObjectRef c;

        public f(IBattlePrecisionMatcher r1, PkPrecisionMatchDataContext r2, Ref.ObjectRef r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            PkPrecisionMatchDataContext.access$handlePrecisionMatchInvite(this.b, this.a, (String) this.c.element);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ PkPrecisionMatchDataContext a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;

        public g(PkPrecisionMatchDataContext r1, int r2, long r3, int r5, String r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
        }

        public final void accept(Object r12) {
            ExtraResponse r13 = (ExtraResponse) r12;
            w31.e r0 = PkPrecisionMatchDataContext.access$getPrecisionMatchMonitor$p(this.a);
            if (r0 == null) goto L6;
            r0.a(this.b, this.c, this.d, this.e, 0, null, "un_available");
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ PkPrecisionMatchDataContext a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;

        public h(PkPrecisionMatchDataContext r1, int r2, long r3, int r5, String r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
        }

        public final void accept(Object r12) {
            Throwable r8 = (Throwable) r12;
            w31.e r0 = PkPrecisionMatchDataContext.access$getPrecisionMatchMonitor$p(this.a);
            if (r0 == null) goto L6;
            r0.a(this.b, this.c, this.d, this.e, 0, r8, "un_available");
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ PkPrecisionMatchDataContext a;

        public i(PkPrecisionMatchDataContext r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            if (this.a.getPrecisionMatchWaiting() == false) goto L9;
            this.a.resetPrecisionMatch();
            w31.e r7 = PkPrecisionMatchDataContext.access$getPrecisionMatchMonitor$p(this.a);
            if (r7 == null) goto L7;
            Intrinsics.checkNotNullParameter("resetAfterAgree", "source");
            LinkedHashMap r2 = new LinkedHashMap();
            r2.put("source", "resetAfterAgree");
            r7.b("precision_match_timeout_reset", r2, 0, null);
        L7:
            int r8 = v.a;
            v.e("ttlive_pk", "precision match 20s time out");
            return;
        }
    }

    static {
        Companion = new d();
    }

    public final void replyAgreeSuccess() {
        this.precisionMatchWaiting = true;
        long r0 = this.waitSeconds;
        if (r0 > 0) goto L6;
        r0 = 15;
    L6:
        resetTimerAfterAgree(r0);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.e
    public void resetPrecisionMatch() {
        this.precisionMatchCountdown = false;
        this.precisionMatchWaiting = false;
        this.curPrecisionMatchId = 0;
        this.precisionMatchWaitingSeconds = 0;
        ArrayList<IBattlePrecisionMatcher> r1 = this.precisionMatcherList;
        if (r1 == null) goto L5;
        r1.clear();
    L5:
        this.oppoPrecisionMatcher = null;
        this.matchMessage = null;
        this.handleAfterReset = false;
    }

    private final void cancelPrecisionMatchTimeOut() {
        Disposable r0 = this.mPrecisionMatchTimeOutSubscribe;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    private final com.bytedance.android.live.revenuelink.connect.f getAnchorConnectService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Z0();
    }

    private final com.bytedance.android.live.revlink.impl.control.d getAnchorLogParamsService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Rc();
    }

    private final i41.a getAutoMatchManager() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAutoMatchManager();
    }

    private final e21.b getClientAttachedInfoObj() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getClientAttachedInfoObj();
    }

    private final LinkCrossRoomDataHolder getLinkCrossRoomDataHolder() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkCrossRoomDataHolder();
    }

    private final r31.a getLinkNetwork() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkNetwork();
    }

    private final com.bytedance.android.live.revlink.impl.service.internal.a getLinkRevInternalService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Do();
    }

    private final ox0.a getModeMerge() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getModeMerge();
    }

    private final com.bytedance.android.live.revlink.impl.multianchor.service.d getMultiAnchorService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.R8();
    }

    private final com.bytedance.android.live.revlink.impl.pk.service.a getPKAutoMatchService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.ja();
    }

    private final IPKLinkBizDataService getPKLinkBizDataService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mk();
    }

    private final com.bytedance.android.live.revlink.impl.pk.service.d getPkLinkDataService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.o9();
    }

    private final w31.e getPrecisionMatchMonitor() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPrecisionMatchMonitor();
    }

    private final com.bytedance.android.live.revlink.impl.pk.service.i getToolbarPkService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Hg();
    }

    public final String getActivityName() {
        d5 r0 = this.matchMessage;
        if (r0 == null) goto L8;
        d2 r1 = r0.getPrecisionMatch();
        if (r1 == null) goto L8;
        String r2 = r1.getActivityName();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    public final long getMatchId() {
        d5 r0 = this.matchMessage;
        if (r0 == null) goto L7;
        d2 r1 = r0.getPrecisionMatch();
        if (r1 == null) goto L7;
        return r1.getPrecisionMatchId();
    L7:
        return 0;
    }

    public final String getMatchReason() {
        d5 r0 = this.matchMessage;
        if (r0 == null) goto L8;
        d2 r1 = r0.getPrecisionMatch();
        if (r1 == null) goto L8;
        String r2 = r1.getMatchReason();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    public String getOppoMatcherUserId() {
        IBattlePrecisionMatcher r0 = this.oppoPrecisionMatcher;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getUserId();
    }

    public final ArrayList<IBattlePrecisionMatcher> getPrecisionMatcherList() {
        ArrayList<IBattlePrecisionMatcher> r0 = this.precisionMatcherList;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new ArrayList();
    }

    public final String getRecommendReason() {
        d5 r0 = this.matchMessage;
        if (r0 == null) goto L8;
        d2 r1 = r0.getPrecisionMatch();
        if (r1 == null) goto L8;
        String r2 = r1.getRecommendReason();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    public int getSelfStats() {
        d5 r0 = this.matchMessage;
        if (r0 == null) goto L22;
        d2 r1 = r0.getPrecisionMatch();
        if (r1 == null) goto L22;
        List r2 = r1.getMatcherList();
        if (r2 == null) goto L22;
        Iterator r3 = r2.iterator();
    L9:
        Object r4 = null;
        if (r3.hasNext() == false) goto L19;
        Object r5 = r3.next();
        String r6 = ((IBattlePrecisionMatcher) r5).getUserId();
        IRoom r7 = this.room;
        if (r7 == null) goto L17;
        IBaseUser r8 = r7.getOwnerKt();
        if (r8 == null) goto L17;
        r4 = r8.getIdString();
    L17:
        if (Intrinsics.areEqual(r6, r4) == false) goto L9;
        r4 = r5;
    L19:
        IBattlePrecisionMatcher r9 = (IBattlePrecisionMatcher) r4;
        if (r9 == null) goto L22;
        return r9.getStatus();
    L22:
        return 0;
    }

    private final void autoRejectReset() {
        com.bytedance.android.live.revlink.impl.pk.service.i r0 = getToolbarPkService();
        if (r0 == null) goto L5;
        r0.h3();
    L5:
        this._pkPrecisionMatchState.setValue(l41.b.a.a);
        if (this.precisionMatchWaiting == false) goto L8;
    L19:
        this.precisionMatchWaiting = false;
        this.precisionMatchCountdown = false;
        return;
    L8:
        if (this.precisionMatchCountdown == false) goto L19;
        d2 r1 = this.mBattlePrecisionMatch;
        if (r1 != null) goto L12;
    L18:
        int r2 = ToastUtil.a;
        int r3 = w11.a.a;
        ToastUtil.a(2131917893, 0);
        goto L19
    L12:
        if (r1.getSource() != PrecisionMatchSource.PrecisionMatchSourceGuildActivity.ordinal()) goto L18;
        int r4 = ToastUtil.a;
        d2 r5 = this.mBattlePrecisionMatch;
        if (r5 == null) goto L16;
        String r6 = r5.getToastContent();
    L17:
        ToastUtil.b(r6, 0);
        goto L19
    L16:
        r6 = null;
        goto L17
    }

    private final boolean handleAvailable() {
        ox0.a r0 = getModeMerge();
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.a());
    L6:
        d2 r2 = this.mBattlePrecisionMatch;
        if (r2 != null) goto L9;
    L11:
        boolean r3 = false;
    L13:
        if (r1 != null) goto L16;
    L17:
        if (r1 != null) goto L20;
    L21:
        jy0.b.f(TAG, "auto reject by mode: " + r1, null, 4);
        return false;
    L20:
        if (r1.intValue() != 2) goto L21;
    L23:
        com.bytedance.android.live.revlink.impl.service.internal.a r4 = getLinkRevInternalService();
        if (r4 == null) goto L26;
        int r5 = r4.getCurrentMode();
    L27:
        if (r5 == 0) goto L30;
        jy0.b.f(TAG, "auto reject by mode: " + r5, null, 4);
        return false;
    L30:
        i41.a r6 = getAutoMatchManager();
        if (r6 != null) goto L33;
    L39:
        IPKLinkBizDataService r7 = getPKLinkBizDataService();
        if (r7 == null) goto L43;
        q11.c r8 = r7.mo747getPkLinkState();
        if (r8 == null) goto L43;
    L45:
        if ((r8 instanceof q11.c.C0296c) == false) goto L54;
        if (r3 == false) goto L48;
        return false;
    L48:
        IPKLinkBizDataService r9 = getPKLinkBizDataService();
        if (r9 == null) goto L51;
        r9.cancelCurrentInvite("cancel_in_random");
    L51:
        jy0.b.f(TAG, "show match dialog after cancel current pk invite", null, 4);
        return true;
    L54:
        if ((r8 instanceof q11.c.a) == false) goto L62;
        if (r3 == false) goto L57;
        return false;
    L57:
        IPKLinkBizDataService r10 = getPKLinkBizDataService();
        if (r10 == null) goto L60;
        r10.refuseCurrentInvite(12);
    L60:
        jy0.b.f(TAG, "show match dialog after refuse current pk invite", null, 4);
        return true;
    L62:
        com.bytedance.android.live.revlink.impl.multianchor.service.d r12 = getMultiAnchorService();
        if (r12 == null) goto L70;
        i11.b r13 = r12.getLinkUserCenter();
        if (r13 == null) goto L70;
        List<IBaseUser> r14 = r13.getInviteeList();
        if (r14 == null) goto L70;
        if ((!r14.isEmpty()) != true) goto L70;
    L78:
        jy0.b.f(TAG, "auto reject by link waiting", null, 4);
        return false;
    L70:
        com.bytedance.android.live.revlink.impl.multianchor.service.d r15 = getMultiAnchorService();
        if (r15 == null) goto L80;
        i11.b r16 = r15.getLinkUserCenter();
        if (r16 == null) goto L80;
        List<IBaseUser> r17 = r16.n();
        if (r17 == null) goto L80;
        if ((!r17.isEmpty()) == true) goto L78;
    L80:
        LinkCrossRoomDataHolder r18 = getLinkCrossRoomDataHolder();
        if (r18 != null) goto L83;
    L107:
        jy0.b.f(TAG, "auto reject by link waiting", null, 4);
        return false;
    L83:
        if (r18.c() != 0) goto L107;
        ld.a r19 = this.linkDataSet;
        if (r19 == null) goto L90;
        NextLiveData r20 = r19.ke();
        if (r20 == null) goto L90;
        Integer r22 = (Integer) r20.getValue();
    L91:
        if (r22 != null) goto L94;
    L95:
        if (r22 != null) goto L98;
    L99:
        if (r22 != null) goto L102;
    L104:
        return true;
    L102:
        if (r22.intValue() != 5) goto L104;
    L105:
        jy0.b.f(TAG, "auto reject by link waiting", null, 4);
        return false;
    L98:
        if (r22.intValue() == 2) goto L105;
    L94:
        if (r22.intValue() == 1) goto L105;
    L90:
        r22 = null;
    L43:
        r8 = q11.c.b.b;
        goto L45
    L33:
        if (r6.f != true) goto L39;
        com.bytedance.android.live.revlink.impl.pk.service.a r23 = getPKAutoMatchService();
        if (r23 == null) goto L37;
        r23.f(AutoMatchSource.ReceivePrecisionMatchMsg);
    L37:
        jy0.b.f(TAG, "show match dialog after end pk auto match", null, 4);
        return true;
    L26:
        r5 = 0;
        goto L27
    L16:
        if (r1.intValue() == 0) goto L23;
    L9:
        if (r2.getSource() != PrecisionMatchSource.PrecisionMatchSourceGuildActivity.ordinal()) goto L11;
        r3 = true;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void clearIt() {
        onCleared();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.e
    public d2 getBattlePrecisionMatch() {
        return this.mBattlePrecisionMatch;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.e
    public Long getLinkDuration() {
        return this.linkDuration;
    }

    public LiveData<l41.b> getMatchState() {
        return this.pkPrecisionMatchState;
    }

    public final d5 getMessage() {
        return this.matchMessage;
    }

    public final IBattlePrecisionMatcher getOppoPrecisionMatcher() {
        return this.oppoPrecisionMatcher;
    }

    public final LiveData<l41.b> getPkPrecisionMatchState() {
        return this.pkPrecisionMatchState;
    }

    public final boolean getPrecisionMatchWaiting() {
        return this.precisionMatchWaiting;
    }

    public final long getPrecisionMatchWaitingSeconds() {
        return this.precisionMatchWaitingSeconds;
    }

    public final MutableLiveData<d5> getShowDialogData() {
        return this.showDialogData;
    }

    public final MutableLiveData<d5> getUpdateLynxMatchUserStatus() {
        return this.updateLynxMatchUserStatus;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.e
    public boolean isMatchWaiting() {
        return this.precisionMatchWaiting;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.e
    public boolean isMatchingCount() {
        return this.precisionMatchCountdown;
    }

    public static final /* synthetic */ void access$autoRejectReset(PkPrecisionMatchDataContext r0) {
        r0.autoRejectReset();
    }

    public static final /* synthetic */ void access$cancelPrecisionMatchTimeOut(PkPrecisionMatchDataContext r0) {
        r0.cancelPrecisionMatchTimeOut();
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(PkPrecisionMatchDataContext r0) {
        return r0.cd;
    }

    public static final /* synthetic */ com.bytedance.android.live.revenuelink.connect.f access$getConnectService$p(PkPrecisionMatchDataContext r0) {
        return r0.connectService;
    }

    public static final /* synthetic */ PkPrecisionMatchDataContext$connectStateObserver$1 access$getConnectStateObserver$p(PkPrecisionMatchDataContext r0) {
        return r0.connectStateObserver;
    }

    public static final /* synthetic */ r31.a access$getLinkNetwork$p(PkPrecisionMatchDataContext r0) {
        return r0.getLinkNetwork();
    }

    public static final /* synthetic */ d2 access$getMBattlePrecisionMatch$p(PkPrecisionMatchDataContext r0) {
        return r0.mBattlePrecisionMatch;
    }

    public static final /* synthetic */ q access$getMPrecisionMatchListener$p(PkPrecisionMatchDataContext r0) {
        return r0.mPrecisionMatchListener;
    }

    public static final /* synthetic */ boolean access$getPrecisionMatchCountdown$p(PkPrecisionMatchDataContext r0) {
        return r0.precisionMatchCountdown;
    }

    public static final /* synthetic */ w31.e access$getPrecisionMatchMonitor$p(PkPrecisionMatchDataContext r0) {
        return r0.getPrecisionMatchMonitor();
    }

    public static final /* synthetic */ com.bytedance.android.live.revlink.impl.pk.service.i access$getToolbarPkService$p(PkPrecisionMatchDataContext r0) {
        return r0.getToolbarPkService();
    }

    public static final /* synthetic */ MutableLiveData access$get_pkPrecisionMatchState$p(PkPrecisionMatchDataContext r0) {
        return r0._pkPrecisionMatchState;
    }

    private final MatchMsgStatus getMatchMsgStatus(List<? extends IBattlePrecisionMatcher> r7) {
        if (r7 == null) goto L4;
        List<? extends IBattlePrecisionMatcher> r8 = r7;
        boolean r0 = r8 instanceof Collection;
        boolean r1 = false;
        if (r0 == true) goto L8;
    L10:
        Iterator<T> r3 = r8.iterator();
    L12:
        if (r3.hasNext() == false) goto L9;
        if (((IBattlePrecisionMatcher) r3.next()).getStatus() != IBattlePrecisionMatcher.Status.StatusNotReady.ordinal()) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == true) goto L12;
        boolean r5 = false;
    L19:
        if (r0 == true) goto L21;
    L23:
        Iterator<T> r2 = r8.iterator();
    L25:
        if (r2.hasNext() == false) goto L22;
        if (((IBattlePrecisionMatcher) r2.next()).getStatus() != IBattlePrecisionMatcher.Status.StatusReady.ordinal()) goto L29;
        boolean r6 = true;
    L30:
        if (r6 == true) goto L25;
    L31:
        if (r5 == true) goto L33;
        if (r1 == true) goto L36;
        Iterator<T> r9 = r8.iterator();
    L39:
        if (r9.hasNext() == false) goto L76;
        IBattlePrecisionMatcher r10 = (IBattlePrecisionMatcher) r9.next();
        IRoom r12 = this.room;
        String r13 = null;
        if (r12 == null) goto L45;
        IBaseUser r14 = r12.getOwnerKt();
        if (r14 == null) goto L45;
        String r15 = r14.getIdString();
    L47:
        if (Intrinsics.areEqual(r15, r10.getUserId()) == true) goto L49;
    L52:
        IRoom r16 = this.room;
        if (r16 == null) goto L57;
        IBaseUser r17 = r16.getOwnerKt();
        if (r17 == null) goto L57;
        String r18 = r17.getIdString();
    L59:
        if ((!Intrinsics.areEqual(r18, r10.getUserId())) == true) goto L61;
    L64:
        IRoom r19 = this.room;
        if (r19 == null) goto L70;
        IBaseUser r20 = r19.getOwnerKt();
        if (r20 == null) goto L70;
        r13 = r20.getIdString();
    L70:
        if ((!Intrinsics.areEqual(r13, r10.getUserId())) == false) goto L39;
        if (r10.getStatus() != IBattlePrecisionMatcher.Status.StatusLater.ordinal()) goto L39;
        return MatchMsgStatus.OPPP_LATER;
    L61:
        if (r10.getStatus() != IBattlePrecisionMatcher.Status.StatusRejected.ordinal()) goto L64;
        return MatchMsgStatus.OPPO_REJECT;
    L57:
        r18 = null;
        goto L59
    L49:
        if (r10.getStatus() != IBattlePrecisionMatcher.Status.StatusRejected.ordinal()) goto L52;
        return MatchMsgStatus.SELF_REJECT;
    L45:
        r15 = null;
        goto L47
    L76:
        return MatchMsgStatus.UNDEFINED;
    L36:
        return MatchMsgStatus.ALL_AGREE;
    L33:
        return MatchMsgStatus.START;
    L29:
        r6 = false;
    L22:
        r1 = true;
        goto L31
    L21:
        if (r8.isEmpty() == false) goto L23;
    L16:
        r4 = false;
    L9:
        r5 = true;
        goto L19
    L8:
        if (r8.isEmpty() == false) goto L10;
    L4:
        return MatchMsgStatus.UNDEFINED;
    }

    private final void onMessage(yh6.c r2) {
        if ((r2 instanceof s0) == false) goto L8;
        d5 r3 = (d5) ((vh7.c) r2).castTo(d5.class);
        if (this.isAnchor == false) goto L9;
        onReceivePrecisionMatchMessage(r3);
        return;
    L9:
        return;
    }

    private final void onReceivePrecisionMatchMessage(d5 r20) {
        w31.e r0 = getPrecisionMatchMonitor();
        int r8 = 0;
        String r9 = "";
        if (r0 == null) goto L29;
        d2 r1 = r20.getPrecisionMatch();
        LinkedHashMap r2 = new LinkedHashMap();
        if (r1 == null) goto L26;
        r2.put("matcher_size", Integer.valueOf(r1.getMatcherList().size()));
        Iterator r3 = CollectionsKt.toList(r1.getMatcherList()).iterator();
        int r4 = 0;
    L8:
        if (r3.hasNext() == false) goto L16;
        Object r5 = r3.next();
        int r10 = r4 + 1;
        if (r4 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        IBattlePrecisionMatcher r6 = (IBattlePrecisionMatcher) r5;
        String r12 = "matcher_" + r4 + "_uid";
        String r13 = r6.getUserId();
        if (r13 != null) goto L15;
        r13 = "";
    L15:
        r2.put(r12, r13);
        r2.put("matcher_" + r4 + "_status", Integer.valueOf(r6.getStatus()));
        r4 = r10;
        goto L8
    L16:
        String r7 = r1.getActivityId();
        if (r7 != null) goto L19;
        r7 = "";
    L19:
        r2.put("flex_activity_id", r7);
        String r14 = r1.getActivityId();
        if (r14 != null) goto L22;
        r14 = "";
    L22:
        r2.put("activity_id", r14);
        r2.put("precision_match_id", Long.valueOf(r1.getPrecisionMatchId()));
        r2.put(Constants.Keys.duration, Long.valueOf(r1.getDuration()));
        r2.put("wait_seconds", Long.valueOf(r1.getWaitSeconds()));
        String r15 = r1.getSponsorId();
        if (r15 != null) goto L25;
        r15 = "";
    L25:
        r2.put("sponsor_id", r15);
        String r16 = "";
    L27:
        int r17 = w31.e.b;
        r0.b("precision_match_receive_msg", r2, 0, r16);
        goto L29
    L26:
        r16 = "precisionMatch is null";
    L29:
        if (r20.getPrecisionMatch() != null) goto L31;
        return;
    L31:
        this.matchMessage = r20;
        this.mBattlePrecisionMatch = r20.getPrecisionMatch();
        d2 r18 = r20.getPrecisionMatch();
        String r19 = null;
        if (r18 == null) goto L34;
        Long r22 = Long.valueOf(r18.getDuration());
    L35:
        this.linkDuration = r22;
        d2 r23 = r20.getPrecisionMatch();
        if (r23 == null) goto L38;
        List r24 = r23.getMatcherList();
    L39:
        if (r24 == null) goto L41;
        List<? extends IBattlePrecisionMatcher> r25 = CollectionsKt.toList(r24);
    L42:
        MatchMsgStatus r26 = getMatchMsgStatus(r25);
        d2 r27 = this.mBattlePrecisionMatch;
        if (r27 != null) goto L45;
    L47:
        boolean r28 = false;
    L48:
        if (r28 == false) goto L50;
        int r29 = 3;
    L51:
        long r110 = 0;
        if (handleAvailable() == false) goto L54;
        d2 r30 = r20.getPrecisionMatch();
        if (r30 == null) goto L77;
        long r111 = r30.getPrecisionMatchId();
    L79:
        if (this.precisionMatchCountdown == false) goto L81;
    L82:
        long r32 = this.curPrecisionMatchId;
        if (r32 > 0) goto L85;
    L111:
        if (r26 == MatchMsgStatus.START) goto L113;
        this.updateLynxMatchUserStatus.postValue(r20);
    L113:
        int r33 = o.a[r26.ordinal()];
        if (r33 == 1) goto L195;
        if (r33 == 2) goto L183;
        if (r33 == 3) goto L176;
        if (r33 != 4) goto L260;
        Ref.ObjectRef r34 = new Ref.ObjectRef();
        r34.element = "";
        d2 r35 = r20.getPrecisionMatch();
        if (r35 == null) goto L125;
        String r36 = r35.getActivityName();
    L126:
        if (r36 == null) goto L143;
        d2 r37 = r20.getPrecisionMatch();
        if (r37 == null) goto L143;
        String r38 = r37.getActivityName();
        if (r38 == null) goto L143;
        if (r38.length() <= 0) goto L134;
        boolean r39 = true;
    L135:
        if (r39 != true) goto L143;
        d2 r40 = r20.getPrecisionMatch();
        if (r40 == null) goto L142;
        String r42 = r40.getActivityName();
        if (r42 == null) goto L142;
        r9 = r42;
    L142:
        r34.element = r9;
        goto L143
    L134:
        r39 = false;
    L143:
        r.c.a().a();
        this.precisionMatchCountdown = false;
        resetTimerAfterAgree(10);
        d2 r43 = r20.getPrecisionMatch();
        if (r43 == null) goto L146;
        String r44 = r43.getSponsorId();
    L147:
        IRoom r45 = this.room;
        if (r45 == null) goto L152;
        IBaseUser r46 = r45.getOwnerKt();
        if (r46 == null) goto L152;
        String r47 = r46.getIdString();
    L154:
        if (Intrinsics.areEqual(r44, r47) == false) goto L254;
        if (r24 == null) goto L255;
        ArrayList r48 = new ArrayList();
        Iterator r49 = r24.iterator();
    L158:
        if (r49.hasNext() == false) goto L168;
        Object r50 = r49.next();
        IBattlePrecisionMatcher r52 = (IBattlePrecisionMatcher) r50;
        IRoom r53 = this.room;
        if (r53 == null) goto L164;
        IBaseUser r54 = r53.getOwnerKt();
        if (r54 == null) goto L164;
        String r55 = r54.getIdString();
    L166:
        if ((!Intrinsics.areEqual(r55, r52.getUserId())) == false) goto L158;
        r48.add(r50);
    L164:
        r55 = null;
        goto L166
    L168:
        Iterator r56 = r48.iterator();
    L170:
        if (r56.hasNext() == false) goto L261;
        Object r57 = r56.next();
        int r58 = r8 + 1;
        if (r8 >= 0) goto L174;
        CollectionsKt.throwIndexOverflow();
    L174:
        com.bytedance.revenue.platform.api.core.rx.l r59 = com.bytedance.revenue.platform.api.core.rx.l.a;
        int r60 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(Observable.timer(((long) r8) * 50, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f((IBattlePrecisionMatcher) r57, this, r34)), this.cd);
        r8 = r58;
        goto L170
    L261:
        return;
    L255:
        return;
    L254:
        return;
    L152:
        r47 = null;
        goto L154
    L146:
        r44 = null;
        goto L147
    L125:
        r36 = null;
        goto L126
    L260:
        return;
    L176:
        if (this.precisionMatchCountdown == false) goto L181;
        int r62 = ToastUtil.a;
        d2 r63 = this.mBattlePrecisionMatch;
        if (r63 == null) goto L180;
        r19 = r63.getToastContent();
    L180:
        ToastUtil.b(r19, 0);
    L181:
        resetPrecisionMatch();
        r.c.a().a();
        cancelPrecisionMatchTimeOut();
        return;
    L183:
        if (this.precisionMatchCountdown == false) goto L193;
        d2 r64 = this.mBattlePrecisionMatch;
        if (r64 != null) goto L187;
    L192:
        int r65 = ToastUtil.a;
        int r66 = w11.a.a;
        ToastUtil.a(2131917912, 0);
        goto L193
    L187:
        if (r64.getSource() != PrecisionMatchSource.PrecisionMatchSourceGuildActivity.ordinal()) goto L192;
        int r67 = ToastUtil.a;
        d2 r68 = this.mBattlePrecisionMatch;
        if (r68 == null) goto L191;
        r19 = r68.getToastContent();
    L191:
        ToastUtil.b(r19, 0);
    L193:
        resetPrecisionMatch();
        r.c.a().a();
        cancelPrecisionMatchTimeOut();
        return;
    L195:
        if (this.precisionMatchCountdown == false) goto L197;
        return;
    L197:
        if (this.precisionMatchWaiting == true) goto L259;
        d2 r69 = r20.getPrecisionMatch();
        if (r69 == null) goto L201;
        long r70 = r69.getPrecisionMatchId();
    L202:
        this.curPrecisionMatchId = r70;
        d2 r72 = r20.getPrecisionMatch();
        if (r72 == null) goto L205;
        long r73 = r72.getWaitSeconds();
    L206:
        this.waitSeconds = r73;
        this.precisionMatchCountdown = true;
        this.precisionMatchWaiting = false;
        d2 r74 = this.mBattlePrecisionMatch;
        if (r74 == null) goto L233;
        List r75 = r74.getAutoAcceptAnchorIdList();
        if (r75 == null) goto L233;
        List r76 = r75;
        IRoom r77 = this.room;
        if (r77 == null) goto L216;
        IBaseUser r78 = r77.getOwnerKt();
        if (r78 == null) goto L216;
        r19 = r78.getIdString();
    L216:
        if (CollectionsKt.contains(r76, r19) != true) goto L233;
        d2 r79 = r20.getPrecisionMatch();
        if (r79 == null) goto L220;
        long r80 = r79.getPrecisionMatchId();
    L221:
        d2 r82 = r20.getPrecisionMatch();
        if (r82 == null) goto L224;
        int r83 = r82.getSource();
    L225:
        d2 r84 = r20.getPrecisionMatch();
        if (r84 == null) goto L231;
        String r85 = r84.getActivityId();
        if (r85 == null) goto L231;
        String r86 = r85;
    L232:
        replyMatch(1, r80, r83, r86);
        this.precisionMatchWaiting = true;
    L234:
        r r87 = r.c.a();
        r87.getClass();
        Intrinsics.checkNotNullParameter(r20, "precisionMatchMessage");
        Iterator r88 = ((ArrayList) r87.a).iterator();
    L236:
        if (r88.hasNext() == false) goto L238;
        ((q) r88.next()).b(r20);
        goto L236
    L238:
        cancelPrecisionMatchTimeOut();
        return;
    L231:
        r86 = "";
        goto L232
    L224:
        r83 = 0;
        goto L225
    L220:
        r80 = 0;
    L233:
        this.showDialogData.postValue(r20);
        goto L234
    L205:
        r73 = 0;
        goto L206
    L201:
        r70 = 0;
        goto L202
    L259:
        return;
    L85:
        if (r111 <= 0) goto L111;
        if (r111 == r32) goto L111;
        if (r26 != MatchMsgStatus.START) goto L106;
        d2 r89 = r20.getPrecisionMatch();
        if (r89 == null) goto L93;
        long r90 = r89.getPrecisionMatchId();
    L94:
        d2 r92 = r20.getPrecisionMatch();
        if (r92 == null) goto L97;
        int r93 = r92.getSource();
    L98:
        d2 r94 = r20.getPrecisionMatch();
        if (r94 == null) goto L104;
        String r95 = r94.getActivityId();
        if (r95 == null) goto L104;
        String r96 = r95;
    L105:
        replyMatch(2, r90, r93, r96);
    L104:
        r96 = "";
        goto L105
    L97:
        r93 = 0;
        goto L98
    L93:
        r90 = 0;
    L106:
        w31.e r97 = getPrecisionMatchMonitor();
        if (r97 == null) goto L253;
        Intrinsics.checkNotNullParameter("other_match", "statusMsg");
        r97.b("precision_match_un_available", new LinkedHashMap(), 0, "other_match");
        return;
    L253:
        return;
    L81:
        if (this.precisionMatchWaiting == false) goto L111;
    L77:
        r111 = 0;
        goto L79
    L54:
        if (r26 != MatchMsgStatus.START) goto L70;
        d2 r98 = this.mBattlePrecisionMatch;
        if (r98 == null) goto L58;
        r110 = r98.getPrecisionMatchId();
    L58:
        d2 r99 = this.mBattlePrecisionMatch;
        if (r99 == null) goto L61;
        int r100 = r99.getSource();
    L62:
        d2 r101 = this.mBattlePrecisionMatch;
        if (r101 == null) goto L68;
        String r102 = r101.getActivityId();
        if (r102 == null) goto L68;
        String r103 = r102;
    L69:
        replyMatch(r29, r110, r100, r103);
    L68:
        r103 = "";
        goto L69
    L61:
        r100 = 0;
    L70:
        w31.e r104 = getPrecisionMatchMonitor();
        if (r104 == null) goto L252;
        int r105 = w31.e.b;
        Intrinsics.checkNotNullParameter("", "statusMsg");
        r104.b("precision_match_un_available", new LinkedHashMap(), 0, "");
        return;
    L252:
        return;
    L50:
        r29 = 2;
        goto L51
    L45:
        if (r27.getSource() != PrecisionMatchSource.PrecisionMatchSourceGuildActivity.ordinal()) goto L47;
        r28 = true;
        goto L48
    L41:
        r25 = null;
        goto L42
    L38:
        r24 = null;
        goto L39
    L34:
        r22 = null;
        goto L35
    }

    private final void resetTimerAfterAgree(long r3) {
        Disposable r0 = this.mPrecisionMatchTimeOutSubscribe;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        long r4 = r3 * ((long) WebcastRedirectException.UNKNOWN);
        com.bytedance.revenue.platform.api.core.rx.l r1 = com.bytedance.revenue.platform.api.core.rx.l.a;
        int r2 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Scheduler r5 = Schedulers.computation();
        Disposable r6 = Observable.timer(r4, TimeUnit.MILLISECONDS, r5).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this));
        if (r6 == null) goto L8;
        com.bytedance.revenue.platform.api.core.rx.f.a(r6, this.cd);
    L9:
        this.mPrecisionMatchTimeOutSubscribe = r6;
        return;
    L8:
        r6 = null;
        goto L9
    }

    public final void addPrecisionMatcherList(List<? extends IBattlePrecisionMatcher> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        ArrayList<IBattlePrecisionMatcher> r0 = this.precisionMatcherList;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        ArrayList<IBattlePrecisionMatcher> r1 = this.precisionMatcherList;
        if (r1 == null) goto L9;
        r1.addAll(r2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.e
    public void onPrecisionMatchEvent(int r9) {
        if (r9 != 0) goto L5;
        return;
    L5:
        if (r9 != 1) goto L8;
        this.precisionMatchWaiting = true;
    L8:
        if (r9 != 2) goto L10;
    L11:
        resetPrecisionMatch();
        r.c.a().a();
    L12:
        d2 r0 = this.mBattlePrecisionMatch;
        if (r0 == null) goto L15;
        long r1 = r0.getPrecisionMatchId();
    L16:
        long r4 = r1;
        d2 r2 = this.mBattlePrecisionMatch;
        if (r2 == null) goto L19;
        int r6 = r2.getSource();
    L20:
        d2 r3 = this.mBattlePrecisionMatch;
        if (r3 == null) goto L24;
        String r5 = r3.getActivityId();
        if (r5 == null) goto L24;
    L25:
        replyMatch(r9, r4, r6, r5);
        return;
    L24:
        r5 = "";
        goto L25
    L19:
        r6 = 0;
        goto L20
    L15:
        r1 = 0;
        goto L16
    L10:
        if (r9 != 3) goto L12;
        goto L11
    }

    public final void setOppoPrecisionMatcher(IBattlePrecisionMatcher r1) {
        this.oppoPrecisionMatcher = r1;
    }

    public final void setPrecisionMatchWaiting(boolean r1) {
        this.precisionMatchWaiting = r1;
    }

    public final void setPrecisionMatchWaitingSeconds(long r1) {
        this.precisionMatchWaitingSeconds = r1;
    }

    public static final /* synthetic */ void access$onMessage(PkPrecisionMatchDataContext r0, yh6.c r1) {
        r0.onMessage(r1);
    }

    public static final /* synthetic */ void access$setMBattlePrecisionMatch$p(PkPrecisionMatchDataContext r0, d2 r1) {
        r0.mBattlePrecisionMatch = r1;
    }

    public static final /* synthetic */ void access$setPrecisionMatchCountdown$p(PkPrecisionMatchDataContext r0, boolean r1) {
        r0.precisionMatchCountdown = r1;
    }

    private final void handlePrecisionMatchInvite(IBattlePrecisionMatcher r52, String r53) {
        int r1 = v.a;
        v.e("ttlive_pk", "handle precision match invite, toUserId: " + r52.getUserId());
        d2 r2 = this.mBattlePrecisionMatch;
        boolean r5 = false;
        String r6 = null;
        if (r2 != null) goto L5;
    L7:
        d5 r3 = this.matchMessage;
        if (r3 == null) goto L12;
        d2 r4 = r3.getPrecisionMatch();
        if (r4 == null) goto L12;
        Long r7 = Long.valueOf(r4.getDuration());
    L13:
        if (r7 == null) goto L25;
        d5 r8 = this.matchMessage;
        if (r8 == null) goto L20;
        d2 r9 = r8.getPrecisionMatch();
        if (r9 == null) goto L20;
        if (r9.getDuration() == 0) goto L25;
    L20:
        d5 r10 = this.matchMessage;
        if (r10 == null) goto L25;
        d2 r12 = r10.getPrecisionMatch();
        if (r12 == null) goto L25;
        int r13 = (int) r12.getDuration();
    L26:
        d2 r14 = this.mBattlePrecisionMatch;
        if (r14 == null) goto L36;
        String r15 = r14.getActivityId();
        if (r15 == null) goto L36;
        if (r15.length() <= 0) goto L33;
        boolean r16 = true;
    L34:
        if (r16 != true) goto L36;
        int r23 = 12;
    L42:
        com.bytedance.live.kmp.util.c r17 = com.bytedance.live.kmp.util.c.a;
        int r18 = w11.a.a;
        String r19 = com.bytedance.live.kmp.util.c.a(2131919635, new Object[0]);
        IBattleConfigSetting r110 = vh7.f.c(IBattleConfigSetting.class);
        d2 r20 = this.mBattlePrecisionMatch;
        if (r20 == null) goto L46;
        String r22 = r20.getActivityId();
        if (r22 == null) goto L46;
    L48:
        if (r22.length() <= 0) goto L50;
        boolean r24 = true;
    L51:
        if (r24 == false) goto L53;
        r110.setActivityId(r22);
    L53:
        Unit r25 = Unit.INSTANCE;
        d2 r26 = this.mBattlePrecisionMatch;
        if (r26 == null) goto L56;
        String r111 = r26.getBattleAttachedInfo();
    L57:
        e21.b r27 = getClientAttachedInfoObj();
        if (r27 == null) goto L60;
        v3 r112 = e21.b.b(r27, com.bytedance.android.live.revlink.impl.pk.utils.l.g.c, null, null, null, null, null, 124);
    L61:
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.f r113 = new com.bytedance.android.live.revlink.impl.mergepk.pkdouble.f(null, r19, r13, r53, 0, r110, r111, 0, 0, r112, null, null, 6961);
        if (r52.getRoom() == null) goto L115;
        d2 r28 = this.mBattlePrecisionMatch;
        if (r28 != null) goto L66;
    L96:
        IPKLinkBizDataService r114 = getPKLinkBizDataService();
        if (r114 == null) goto L115;
        IRoom r115 = r52.getRoom();
        IRoomBase r29 = r52.getRoom();
        if (r29 == null) goto L101;
        long r116 = IRoomKtKt.getId(r29);
    L102:
        IRoom r30 = r52.getRoom();
        if (r30 == null) goto L107;
        IBaseUser r32 = r30.getOwnerKt();
        if (r32 == null) goto L107;
        String r210 = r32.getIdString();
    L108:
        IRoom r33 = r52.getRoom();
        if (r33 == null) goto L113;
        IBaseUser r34 = r33.getOwnerKt();
        if (r34 == null) goto L113;
        Intrinsics.checkNotNullParameter(r34, "$this$secUidExt");
        String r211 = r34.getCastSecUid();
    L114:
        IPKLinkBizDataService.b.b(r114, r115, r116, r210, r211, 3, r23, r113);
    L113:
        r211 = null;
    L107:
        r210 = null;
        goto L108
    L101:
        r116 = 0;
        goto L102
    L66:
        if (r28.getSource() != PrecisionMatchSource.PrecisionMatchSourceGuildActivity.ordinal()) goto L96;
        com.bytedance.android.live.revenuelink.connect.f r35 = getAnchorConnectService();
        if (r35 == null) goto L115;
        com.bytedance.android.live.revenuelink.connect.n r36 = r35.linkOutManager();
        if (r36 == null) goto L115;
        IRoomBase r37 = this.room;
        if (r37 == null) goto L74;
        long r117 = IRoomKtKt.getId(r37);
    L75:
        IRoomBase r38 = r52.getRoom();
        if (r38 == null) goto L78;
        long r212 = IRoomKtKt.getId(r38);
    L79:
        IRoom r118 = r52.getRoom();
        if (r118 == null) goto L84;
        IBaseUser r119 = r118.getOwnerKt();
        if (r119 == null) goto L84;
        String r213 = r119.getIdString();
    L85:
        IRoom r120 = r52.getRoom();
        if (r120 == null) goto L90;
        IBaseUser r121 = r120.getOwnerKt();
        if (r121 == null) goto L90;
        Intrinsics.checkNotNullParameter(r121, "$this$secUidExt");
        String r214 = r121.getCastSecUid();
    L91:
        IRoom r215 = r52.getRoom();
        int r216 = BizType.AnchorLink.ordinal();
        String r39 = r113.b;
        int r122 = r113.c;
        int r123 = r113.e;
        String r124 = r113.h;
        int r125 = r113.i;
        long r126 = r113.j;
        v3 r40 = r113.k;
        if (r40 == null) goto L94;
        String r45 = w3.a(r40);
    L95:
        r36.f(new d11.d(7, r117, r212, r23, 3, r213, r214, r215, r216, r39, r122, r53, 0, r123, 0, 0, null, null, null, r124, 0, r125, r126, null, r45, null, r113.m, null, 378929152), PkPrecisionMatchDataContext$handlePrecisionMatchInvite$1$1.INSTANCE, PkPrecisionMatchDataContext$handlePrecisionMatchInvite$1$2.INSTANCE, null);
        goto L115
    L94:
        r45 = "";
    L90:
        r214 = null;
    L84:
        r213 = null;
        goto L85
    L78:
        r212 = 0;
        goto L79
    L74:
        r117 = 0;
    L115:
        x11.a r42 = this.internalLinkService;
        if (r42 == null) goto L118;
        y11.d r43 = r42.getPkService();
    L119:
        LinkedHashMap r44 = new LinkedHashMap();
        r44.put("is_oncemore", DataType.FALSE);
        r44.put("connection_type", "random_pk");
        com.bytedance.android.live.revlink.impl.control.d r46 = getAnchorLogParamsService();
        if (r46 == null) goto L123;
        String r47 = r46.getRequestId();
        if (r47 == null) goto L123;
    L124:
        r44.put("request_id", r47);
        r44.put("pk_description", "routine");
        if (r43 == null) goto L127;
        String r48 = r43.getInviteMode();
    L128:
        if (r48 != null) goto L130;
    L133:
        boolean r127 = true;
    L134:
        if (r127 == false) goto L137;
        r48 = "routine_pk";
    L137:
        r44.put("invite_mode", r48);
        if (r43 == null) goto L140;
        String r49 = r43.getTheme();
    L141:
        if (r49 != null) goto L143;
    L146:
        boolean r128 = true;
    L147:
        if (r128 == true) goto L149;
        r44.put(FileUtils.PICTURE_THEME, r49);
    L149:
        d5 r50 = this.matchMessage;
        if (r50 == null) goto L164;
        d2 r54 = r50.getPrecisionMatch();
        if (r54 == null) goto L164;
        String r55 = r54.getActivityId();
        if (r55 == null) goto L164;
        if (r55.length() <= 0) goto L158;
        boolean r129 = true;
    L159:
        if (r129 == true) goto L162;
        r55 = null;
    L162:
        if (r55 == null) goto L164;
        r44.put("invite_mode", "activity_pk");
        r44.put("pk_activity_type", r55);
        goto L164
    L158:
        r129 = false;
    L164:
        IPKLinkBizDataService r56 = getPKLinkBizDataService();
        if (r56 == null) goto L167;
        r6 = IPKLinkBizDataService.b.a(r56, r52.getUserId());
    L167:
        if (r6 != null) goto L169;
    L170:
        r5 = true;
    L171:
        if (r5 == true) goto L173;
        r44.put("transform_reason", r6);
    L173:
        mz0.n r57 = new mz0.n();
        Map<String, String> r58 = r57.a;
        Intrinsics.checkNotNullParameter(r58, "map");
        Intrinsics.checkNotNullParameter(r44, "map");
        r58.putAll(r44);
        mz0.m r59 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.h r60 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r60, "linkInfoLog");
        am2.m r62 = r60.a;
        r62.i = 300;
        ((ArrayList) r59.a).add(r62);
        LinkCrossRoomDataHolder r63 = getLinkCrossRoomDataHolder();
        if (r63 == null) goto L176;
        r63.m(r59);
    L176:
        r59.b(LogCommon.ROOM);
        ((ArrayList) r57.b).addAll(r59.a);
        cy0.e.a.getClass();
        cy0.j r64 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r65 = com.bytedance.android.scope.m.b(r64).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r65);
        ((mz0.i) ((f80.a) r65)).w3("connection_invite", r57.a, r57.b);
        resetPrecisionMatch();
        return;
    L169:
        if (r6.length() != 0) goto L171;
    L143:
        if (r49.length() == 0) goto L146;
        r128 = false;
        goto L147
    L140:
        r49 = null;
        goto L141
    L130:
        if (r48.length() == 0) goto L133;
        r127 = false;
        goto L134
    L127:
        r48 = null;
    L123:
        r47 = "";
        goto L124
    L118:
        r43 = null;
        goto L119
    L60:
        r112 = null;
        goto L61
    L56:
        r111 = null;
        goto L57
    L50:
        r24 = false;
    L46:
        r22 = "";
        goto L48
    L33:
        r16 = false;
    L36:
        d2 r66 = this.mBattlePrecisionMatch;
        if (r66 != null) goto L39;
    L41:
        r23 = 0;
        goto L42
    L39:
        if (r66.getSource() != PrecisionMatchSource.PrecisionMatchSourceGuildActivity.ordinal()) goto L41;
        r23 = 109;
    L25:
        r13 = 300;
    L12:
        r7 = null;
        goto L13
    L5:
        if (r2.getSource() != PrecisionMatchSource.PrecisionMatchSourceGuildActivity.ordinal()) goto L7;
        r13 = 0;
        goto L26
    }

    public static final /* synthetic */ void access$handlePrecisionMatchInvite(PkPrecisionMatchDataContext r0, IBattlePrecisionMatcher r1, String r2) {
        r0.handlePrecisionMatchInvite(r1, r2);
    }

    private final void replyMatch(int r12, long r13, int r14, String r15) {
        r31.a r0 = getLinkNetwork();
        if (r0 == null) goto L14;
        Observable<ExtraResponse<Object, Extra>> r1 = r0.a(r12, r13, r14, r15, 0);
        if (r1 == null) goto L15;
        int r2 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r3 = r1.subscribeOn(Schedulers.io());
        if (r3 == null) goto L16;
        Observable r4 = r3.observeOn(AndroidSchedulers.mainThread());
        if (r4 == null) goto L17;
        Disposable r16 = r4.subscribe(new g(this, r12, r13, r14, r15), new h(this, r12, r13, r14, r15));
        if (r16 == null) goto L18;
        com.bytedance.revenue.platform.api.core.rx.f.a(r16, this.cd);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public PkPrecisionMatchDataContext(ld.a r5, com.bytedance.android.livesdk.revenue.service.room.c r6, com.bytedance.android.live.revlink.impl.global.c r7, yz0.f r8, x11.a r9) {
        this.linkDataSet = r5;
        this.roomService = r6;
        this.linkFakeGlobalService = r7;
        this.messageService = r8;
        this.internalLinkService = r9;
        CompositeDisposable r10 = new CompositeDisposable();
        this.cd = r10;
        String r12 = null;
        if (r6 == null) goto L5;
        com.bytedance.android.livesdk.revenue.room.a r13 = r6.getRoomContext();
    L6:
        this.roomContext = r13;
        com.bytedance.android.live.revenuelink.connect.f r14 = getAnchorConnectService();
        this.connectService = r14;
        Observer r0 = new PkPrecisionMatchDataContext$connectStateObserver$1(this);
        this.connectStateObserver = r0;
        this.showDialogData = new MutableLiveData();
        this.updateLynxMatchUserStatus = new MutableLiveData();
        MutableLiveData<l41.b> r1 = new MutableLiveData();
        this._pkPrecisionMatchState = r1;
        this.pkPrecisionMatchState = r1;
        e r2 = new e(this);
        this.mPrecisionMatchListener = r2;
        com.bytedance.revenue.platform.api.core.rx.f.a(getOnCleared().subscribe(new a(this)), r10);
        if (r13 == null) goto L9;
        boolean r3 = r13.getCommonIsAnchor();
    L10:
        this.isAnchor = r3;
        if (r13 == null) goto L13;
        IRoomBase r15 = r13.getCommonRoom();
    L14:
        this.room = (IRoom) r15;
        if (r8 == null) goto L21;
        com.bytedance.android.live.revenue.common.message.a r16 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r4 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r16, "$this$LINK_MIC_BATTLE_PRECISION_MATCH");
        Observable r17 = yz0.h.a.a(r8, (yh6.b) CommonMessageTypeKt.n.getValue(), false, 6);
        if (r17 == null) goto L21;
        final AnonymousClass2 r18 = new AnonymousClass2(this);
        Disposable r19 = r17.subscribe(new j(r18));
        if (r19 == null) goto L21;
        com.bytedance.revenue.platform.api.core.rx.f.a(r19, r10);
    L21:
        r r20 = r.c.a();
        r20.getClass();
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) r20.a).add(r2);
        if (r14 == null) goto L27;
        LiveData<ey.f> r22 = r14.connectState();
        if (r22 == null) goto L27;
        r22.observeForever(r0);
    L27:
        if (this.isAnchor == false) goto L48;
        IRoomBase r23 = this.room;
        if (r23 == null) goto L49;
        r31.a r24 = getLinkNetwork();
        if (r24 == null) goto L50;
        long r25 = IRoomKtKt.getId(r23);
        IBaseUser r26 = r23.getOwnerKt();
        if (r26 == null) goto L35;
        Intrinsics.checkNotNullParameter(r26, "$this$secUidExt");
        r26.getCastSecUid();
    L35:
        IBaseUser r27 = r23.getOwnerKt();
        if (r27 == null) goto L38;
        r12 = r27.getIdString();
    L38:
        Observable r28 = r24.i(r25, r12, 1);
        if (r28 == null) goto L51;
        int r29 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r30 = r28.subscribeOn(Schedulers.io());
        if (r30 == null) goto L52;
        Observable r32 = r30.observeOn(AndroidSchedulers.mainThread());
        if (r32 == null) goto L53;
        Disposable r33 = r32.subscribe(b.a, c.a);
        if (r33 == null) goto L54;
        com.bytedance.revenue.platform.api.core.rx.f.a(r33, r10);
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L13:
        r15 = null;
        goto L14
    L9:
        r3 = false;
        goto L10
    L5:
        r13 = null;
        goto L6
    }
}
