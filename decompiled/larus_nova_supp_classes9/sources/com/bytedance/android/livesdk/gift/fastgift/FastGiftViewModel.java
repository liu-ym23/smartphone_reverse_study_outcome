package com.bytedance.android.livesdk.gift.fastgift;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.l5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.util.GiftToRechargeParamsKey;
import com.bytedance.android.live.revenue.model.extension.IMainRoom;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.j0;
import com.bytedance.android.livesdk.gift.platform.business.sendGift.GiftTransaction;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftStrategy;
import com.bytedance.android.livesdk.message.model.qj;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarButton;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 Ç\u00012\u00020\u0001:\u0004È\u0001É\u0001B\t¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J\u001c\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002J\u001c\u0010\u0007\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0014\u0010\f\u001a\u00020\u00052\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0018\u0010$\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\"J\u0006\u0010%\u001a\u00020\u0005J\u0006\u0010&\u001a\u00020\u0005J\u0006\u0010'\u001a\u00020\u0005J\u0006\u0010(\u001a\u00020\u0005J\u0006\u0010)\u001a\u00020\u001aJ\u0006\u0010*\u001a\u00020\u0005J\u0006\u0010+\u001a\u00020\u0005J\u0019\u0010-\u001a\u00020\u00052\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b-\u0010.J\u0006\u0010/\u001a\u00020\u001aJ\u000e\u00102\u001a\u00020\u001a2\u0006\u00101\u001a\u000200J\u000e\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u001aJ\u0006\u00106\u001a\u000205J\u0006\u00107\u001a\u00020\u001aJ\u0006\u00108\u001a\u00020\u001aJ\b\u00109\u001a\u0004\u0018\u00010\u001eJ\u0006\u0010:\u001a\u00020\u001aJ\u0014\u0010<\u001a\u0010\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000205\u0018\u00010;J\u0006\u0010>\u001a\u00020=J\u0006\u0010@\u001a\u00020?J\u0006\u0010A\u001a\u00020\u0005J\u0006\u0010B\u001a\u00020\u0005J\u0010\u0010D\u001a\u00020\u00052\b\b\u0002\u0010C\u001a\u00020\u001aJ\u0010\u0010E\u001a\u00020\u001a2\b\u0010#\u001a\u0004\u0018\u00010\"J\u0006\u0010F\u001a\u00020\u0005J\b\u0010G\u001a\u00020\u0005H\u0014R$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010R\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bR\u0010T\"\u0004\bU\u0010VR\u001d\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001e0W8\u0006¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u001d\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u001a0W8\u0006¢\u0006\f\n\u0004\b\\\u0010Y\u001a\u0004\b]\u0010[R\u001d\u0010^\u001a\b\u0012\u0004\u0012\u00020\u001a0W8\u0006¢\u0006\f\n\u0004\b^\u0010Y\u001a\u0004\b_\u0010[R\u001d\u0010`\u001a\b\u0012\u0004\u0012\u00020\u001a0W8\u0006¢\u0006\f\n\u0004\b`\u0010Y\u001a\u0004\ba\u0010[R\u001d\u0010b\u001a\b\u0012\u0004\u0012\u00020\u001a0W8\u0006¢\u0006\f\n\u0004\bb\u0010Y\u001a\u0004\bc\u0010[R!\u0010i\u001a\b\u0012\u0004\u0012\u00020\u001a0d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR(\u0010j\u001a\b\u0012\u0004\u0012\u00020=0W8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010Y\u001a\u0004\bk\u0010[\"\u0004\bl\u0010mR\u001d\u0010n\u001a\b\u0012\u0004\u0012\u00020\u001a0W8\u0006¢\u0006\f\n\u0004\bn\u0010Y\u001a\u0004\bo\u0010[R\u001d\u0010p\u001a\b\u0012\u0004\u0012\u00020\u001a0W8\u0006¢\u0006\f\n\u0004\bp\u0010Y\u001a\u0004\bq\u0010[R\u0018\u0010s\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010u\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR$\u0010w\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0019\u0010~\u001a\u00020}8\u0006¢\u0006\u000e\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R1\u0010\u0083\u0001\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u000205\u0018\u00010\u0082\u00010W8\u0006¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010Y\u001a\u0005\b\u0084\u0001\u0010[R+\u0010\u0087\u0001\u001a\u0013\u0012\u000f\u0012\r \u0086\u0001*\u0005\u0018\u00010\u0085\u00010\u0085\u00010W8\u0006¢\u0006\u000e\n\u0005\b\u0087\u0001\u0010Y\u001a\u0005\b\u0088\u0001\u0010[R\u001c\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R'\u0010\u008c\u0001\u001a\u0010\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000205\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0019\u0010\u008e\u0001\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R,\u0010\u0091\u0001\u001a\u0012\u0012\r\u0012\u000b \u0086\u0001*\u0004\u0018\u00010\u001a0\u001a0\u0090\u00018\u0006¢\u0006\u0010\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0018\u0010\u0096\u0001\u001a\u00030\u0095\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0018\u0010\u0098\u0001\u001a\u00030\u0095\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0097\u0001R\u0018\u0010\u0099\u0001\u001a\u00030\u0095\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u0097\u0001R\u001c\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001a\u0010\u009d\u0001\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009d\u0001\u0010xR)\u0010\u009e\u0001\u001a\u00020=8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009e\u0001\u0010\u008f\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R)\u0010£\u0001\u001a\u00020?8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R)\u0010©\u0001\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R)\u0010¯\u0001\u001a\u00020=8F@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¯\u0001\u0010\u008f\u0001\u001a\u0006\b°\u0001\u0010 \u0001\"\u0006\b±\u0001\u0010¢\u0001R)\u0010²\u0001\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b²\u0001\u0010ª\u0001\u001a\u0006\b³\u0001\u0010¬\u0001\"\u0006\b´\u0001\u0010®\u0001R\u0019\u0010µ\u0001\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010ª\u0001R\u001e\u0010¸\u0001\u001a\u00020\u001a8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¶\u0001\u0010f\u001a\u0005\b·\u0001\u0010TR\u001e\u0010»\u0001\u001a\u00020\u001a8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¹\u0001\u0010f\u001a\u0005\bº\u0001\u0010TRN\u0010Ã\u0001\u001a\u0014\u0012\u0004\u0012\u0002050¼\u0001j\t\u0012\u0004\u0012\u000205`½\u00012\u0019\u0010¾\u0001\u001a\u0014\u0012\u0004\u0012\u0002050¼\u0001j\t\u0012\u0004\u0012\u000205`½\u00018B@BX\u0082\u000e¢\u0006\u0010\u001a\u0006\b¿\u0001\u0010À\u0001\"\u0006\bÁ\u0001\u0010Â\u0001R\u0013\u0010Ä\u0001\u001a\u00020\u001a8F¢\u0006\u0007\u001a\u0005\bÄ\u0001\u0010T¨\u0006Ê\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/gift/fastgift/FastGiftViewModel;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "clazz", BuildConfig.FLAVOR, "registerP5RxBus", "registerRxBus", "initRecommendNum", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "msg", "onMessage", "Lmy1/a;", "model", "processFastTaskGiftModel", "Lcom/bytedance/android/livesdk/event/v;", "event", "onRechargeDialogPaySuccessEvent", "Lca0/t;", "onOpenPopupGiftDialogEvent", "Lcom/bytedance/android/livesdk/gift/platform/core/model/a0;", "onRecommendFastGiftEvent", "Lcom/bytedance/android/livesdk/gift/platform/core/model/c;", "onUpdateFastGiftEvent", "onUpdateFastGiftEventForToolbarOptimize", BuildConfig.FLAVOR, "needShowRecommendConfirm", "needShowConfirm", "needShowErrorConfirm", "Lcom/bytedance/android/livesdk/gift/model/h1;", "getFastGiftModelFromExtra", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "bindCurrentRoom", "initMessageObserver", "notifyRecommendTurningFinished", "notifyRecommendCountDownFinished", "notifyRecommendFinished", "disallowSendGiftDurationRecommend", "initFollowStateChanged", "sendGiftTransaction", "refreshUI", "sendGift", "(Ljava/lang/Boolean;)V", "enableGift", "Lcom/bytedance/android/livesdk/gift/platform/core/model/e0;", "info", "shouldShowIconPopUpAnim", "isCheckNotRemind", "updateRecommendConfirmRecord", BuildConfig.FLAVOR, "getToolbarButtonName", "isCombo", "hasGift", "getGift", "currentIsRecommend", BuildConfig.FLAVOR, "getRecommendLog", BuildConfig.FLAVOR, "getRecommendNum", BuildConfig.FLAVOR, "getGiftId", "hideConfirm", "errorConfirm", "transactionFinish", "comboFinish", "isCommerceRoom", "reset", "onCleared", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setDataCenter", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "setRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)V", "isAnchor", "Z", "()Z", "setAnchor", "(Z)V", "Landroidx/lifecycle/MutableLiveData;", "fastGift", "Landroidx/lifecycle/MutableLiveData;", "getFastGift", "()Landroidx/lifecycle/MutableLiveData;", "fastGiftHint", "getFastGiftHint", "needConfirm", "getNeedConfirm", "needRecommendConfirm", "getNeedRecommendConfirm", "needErrorConfirm", "getNeedErrorConfirm", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "openPopupGiftDialog$delegate", "Lkotlin/Lazy;", "getOpenPopupGiftDialog", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "openPopupGiftDialog", "comboCount", "getComboCount", "setComboCount", "(Landroidx/lifecycle/MutableLiveData;)V", "followState", "getFollowState", "behaviorVisible", "getBehaviorVisible", "Lcom/bytedance/android/livesdk/gift/platform/core/model/t;", "transaction", "Lcom/bytedance/android/livesdk/gift/platform/core/model/t;", "roomStructFastGift", "Lcom/bytedance/android/livesdk/gift/model/h1;", "fastTaskGiftModel", "Lmy1/a;", "getFastTaskGiftModel", "()Lmy1/a;", "setFastTaskGiftModel", "(Lmy1/a;)V", "Lcom/bytedance/android/livesdk/gift/platform/core/model/n;", "showInfo", "Lcom/bytedance/android/livesdk/gift/platform/core/model/n;", "getShowInfo", "()Lcom/bytedance/android/livesdk/gift/platform/core/model/n;", "Lkotlin/Pair;", "recommendGift", "getRecommendGift", "Lcom/bytedance/android/livesdk/gift/fastgift/FastGiftViewModel$RecommendFastGiftStatus;", "kotlin.jvm.PlatformType", "recommendStatus", "getRecommendStatus", "Lio/reactivex/disposables/Disposable;", "recommendGiftAnimDisposable", "Lio/reactivex/disposables/Disposable;", "recommendFastGiftLog", "Ljava/util/Map;", "recommendShowTimes", "I", "Lio/reactivex/subjects/BehaviorSubject;", "loadToolbarFastGift", "Lio/reactivex/subjects/BehaviorSubject;", "getLoadToolbarFastGift", "()Lio/reactivex/subjects/BehaviorSubject;", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "rxCompositeDisposable", "taskCompositeDisposable", "Lyz0/l;", "messageManager", "Lyz0/l;", "fastTaskGiftModelCache", "repeatCount", "getRepeatCount", "()I", "setRepeatCount", "(I)V", "preGiftId", "J", "getPreGiftId", "()J", "setPreGiftId", "(J)V", "preRoomOwnerId", "Ljava/lang/String;", "getPreRoomOwnerId", "()Ljava/lang/String;", "setPreRoomOwnerId", "(Ljava/lang/String;)V", "rechargedState", "getRechargedState", "setRechargedState", "popupGiftClickSource", "getPopupGiftClickSource", "setPopupGiftClickSource", "keyOfShownGift", "remindUserByGiftPrice$delegate", "getRemindUserByGiftPrice", "remindUserByGiftPrice", "fastGiftImageFormate$delegate", "getFastGiftImageFormate", "fastGiftImageFormate", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "value", "getLookingForSetCache", "()Ljava/util/HashSet;", "setLookingForSetCache", "(Ljava/util/HashSet;)V", "lookingForSetCache", "isFirstRechargePopupGiftValid", "<init>", "()V", "Companion", "a", "RecommendFastGiftStatus", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FastGiftViewModel extends ViewModel {
    public static final a Companion = null;
    public static final int GIFT_SOURCE = 126;
    public static final int STATE_HAS_RECHARGED = 2;
    public static final int STATE_NOT_RECHARGED = 1;
    public static final int STATE_UNKNOWN = 0;
    public static final String TAG = "FastGiftViewModel";
    public static final long TASK_FAST_GIFT_MESSAGE_DELAY = 1;
    private final MutableLiveData<Boolean> behaviorVisible;
    private MutableLiveData<Integer> comboCount;
    private final CompositeDisposable compositeDisposable;
    private DataCenter dataCenter;
    private final MutableLiveData<h1> fastGift;
    private final MutableLiveData<Boolean> fastGiftHint;
    private final Lazy fastGiftImageFormate$delegate;
    private my1.a fastTaskGiftModel;
    private my1.a fastTaskGiftModelCache;
    private final MutableLiveData<Boolean> followState;
    private boolean isAnchor;
    private String keyOfShownGift;
    private final BehaviorSubject<Boolean> loadToolbarFastGift;
    private yz0.l messageManager;
    private final MutableLiveData<Boolean> needConfirm;
    private final MutableLiveData<Boolean> needErrorConfirm;
    private final MutableLiveData<Boolean> needRecommendConfirm;
    private final Lazy openPopupGiftDialog$delegate;
    private String popupGiftClickSource;
    private long preGiftId;
    private String preRoomOwnerId;
    private int rechargedState;
    private Map<String, String> recommendFastGiftLog;
    private final MutableLiveData<Pair<h1, String>> recommendGift;
    private Disposable recommendGiftAnimDisposable;
    private int recommendShowTimes;
    private final MutableLiveData<RecommendFastGiftStatus> recommendStatus;
    private final Lazy remindUserByGiftPrice$delegate;
    private int repeatCount;
    private IRoom room;
    private h1 roomStructFastGift;
    private final CompositeDisposable rxCompositeDisposable;
    private final com.bytedance.android.livesdk.gift.platform.core.model.n showInfo;
    private final CompositeDisposable taskCompositeDisposable;
    private com.bytedance.android.livesdk.gift.platform.core.model.t transaction;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/fastgift/FastGiftViewModel$RecommendFastGiftStatus;", BuildConfig.FLAVOR, "Idle", "Turning", "CountDown", "Combo", "RecommendFinished", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum RecommendFastGiftStatus extends Enum<RecommendFastGiftStatus> {
        public static final RecommendFastGiftStatus Combo = null;
        public static final RecommendFastGiftStatus CountDown = null;
        public static final RecommendFastGiftStatus Idle = null;
        public static final RecommendFastGiftStatus RecommendFinished = null;
        public static final RecommendFastGiftStatus Turning = null;
        public static final /* synthetic */ RecommendFastGiftStatus[] a = null;

        static {
            RecommendFastGiftStatus r1 = new RecommendFastGiftStatus("Idle", 0);
            Idle = r1;
            RecommendFastGiftStatus r2 = new RecommendFastGiftStatus("Turning", 1);
            Turning = r2;
            RecommendFastGiftStatus r3 = new RecommendFastGiftStatus("CountDown", 2);
            CountDown = r3;
            RecommendFastGiftStatus r4 = new RecommendFastGiftStatus("Combo", 3);
            Combo = r4;
            RecommendFastGiftStatus r5 = new RecommendFastGiftStatus("RecommendFinished", 4);
            RecommendFinished = r5;
            a = new RecommendFastGiftStatus[]{r1, r2, r3, r4, r5};
        }

        public static RecommendFastGiftStatus valueOf(String r1) {
            return (RecommendFastGiftStatus) r27.a.a(RecommendFastGiftStatus.class, r1);
        }

        public static RecommendFastGiftStatus[] values() {
            return (RecommendFastGiftStatus[]) a.clone();
        }

        public RecommendFastGiftStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ FastGiftViewModel a;

        public b(FastGiftViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            IFollowPair r4 = (IFollowPair) r3;
            boolean r0 = vh6.c.b(br2.a.class).nk(this.a.getRoom(), r4);
            if (r4 == null) goto L5;
            Integer r5 = Integer.valueOf(r4.getFollowStatus());
        L6:
            Intrinsics.checkNotNull(r5);
            r5.intValue();
            this.a.getFollowState().postValue(Boolean.valueOf(r0));
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ FastGiftViewModel a;

        public c(FastGiftViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            if (((RecommendFastGiftStatus) this.a.getRecommendStatus().getValue()) != RecommendFastGiftStatus.Turning) goto L6;
            this.a.notifyRecommendTurningFinished();
            return;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ FastGiftViewModel a;

        public d(FastGiftViewModel r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(this.a.getDataCenter()).b(RevToolbarButton.FastGift);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ FastGiftViewModel a;

        public e(FastGiftViewModel r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getLoadToolbarFastGift().onNext(Boolean.TRUE);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ FastGiftViewModel a;

        public f(FastGiftViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Long r7 = (Long) r6;
            my1.a r8 = this.a.getFastTaskGiftModel();
            if (r8 == null) goto L17;
            boolean r2 = true;
            if (r8.b == null) goto L7;
            boolean r1 = true;
        L8:
            if (r1 == true) goto L11;
            r8 = null;
        L11:
            if (r8 == null) goto L17;
            this.a.getLoadToolbarFastGift().onNext(Boolean.TRUE);
            GiftManagerKt r3 = GiftManagerKt.z;
            if (r8.a != null) goto L16;
            r2 = false;
        L16:
            h1 r4 = r8.b;
            Intrinsics.checkNotNull(r4);
            r3.getClass();
            GiftManagerKt.G(r2, r4);
            this.a.getFastGift().postValue(r8.b);
            goto L17
        L7:
            r1 = false;
        L17:
            FastGiftViewModel.access$setFastTaskGiftModelCache$p(this.a, null);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ FastGiftViewModel a;

        public g(FastGiftViewModel r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(T r2) {
            if ((r2 instanceof com.bytedance.android.livesdk.gift.platform.core.model.c) == false) goto L10;
            FastGiftViewModel r0 = this.a;
            if (r2 == 0) goto L8;
            FastGiftViewModel.access$onUpdateFastGiftEvent(r0, (com.bytedance.android.livesdk.gift.platform.core.model.c) r2);
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.core.model.FastGiftUpdateEvent");
        L10:
            if ((r2 instanceof ca0.t) == false) goto L17;
            FastGiftViewModel r1 = this.a;
            if (r2 == 0) goto L15;
            FastGiftViewModel.access$onOpenPopupGiftDialogEvent(r1, (ca0.t) r2);
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.gift.OpenPopupGiftDialogEvent");
        L17:
            if ((r2 instanceof com.bytedance.android.livesdk.event.v) == false) goto L24;
            FastGiftViewModel r3 = this.a;
            if (r2 == 0) goto L22;
            FastGiftViewModel.access$onRechargeDialogPaySuccessEvent(r3, (com.bytedance.android.livesdk.event.v) r2);
            return;
        L22:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.event.RechargeDialogPaySuccessEvent");
        L24:
            if ((r2 instanceof com.bytedance.android.livesdk.gift.platform.core.model.a0) == false) goto L33;
            FastGiftViewModel r4 = this.a;
            if (r2 == 0) goto L29;
            FastGiftViewModel.access$onRecommendFastGiftEvent(r4, (com.bytedance.android.livesdk.gift.platform.core.model.a0) r2);
            return;
        L29:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.core.model.RecommendFastGiftEvent");
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ FastGiftViewModel a;

        public h(FastGiftViewModel r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(T r2) {
            if ((r2 instanceof com.bytedance.android.livesdk.gift.platform.core.model.c) == false) goto L10;
            FastGiftViewModel r0 = this.a;
            if (r2 == 0) goto L8;
            FastGiftViewModel.access$onUpdateFastGiftEvent(r0, (com.bytedance.android.livesdk.gift.platform.core.model.c) r2);
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.core.model.FastGiftUpdateEvent");
        L10:
            if ((r2 instanceof ca0.t) == false) goto L17;
            FastGiftViewModel r1 = this.a;
            if (r2 == 0) goto L15;
            FastGiftViewModel.access$onOpenPopupGiftDialogEvent(r1, (ca0.t) r2);
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.gift.OpenPopupGiftDialogEvent");
        L17:
            if ((r2 instanceof com.bytedance.android.livesdk.event.v) == false) goto L24;
            FastGiftViewModel r3 = this.a;
            if (r2 == 0) goto L22;
            FastGiftViewModel.access$onRechargeDialogPaySuccessEvent(r3, (com.bytedance.android.livesdk.event.v) r2);
            return;
        L22:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.event.RechargeDialogPaySuccessEvent");
        L24:
            if ((r2 instanceof com.bytedance.android.livesdk.gift.platform.core.model.a0) == false) goto L33;
            FastGiftViewModel r4 = this.a;
            if (r2 == 0) goto L29;
            FastGiftViewModel.access$onRecommendFastGiftEvent(r4, (com.bytedance.android.livesdk.gift.platform.core.model.a0) r2);
            return;
        L29:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.core.model.RecommendFastGiftEvent");
        }
    }

    public final class i implements Consumer {
        public final /* synthetic */ Function1 a;

        public i(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static final class j extends com.bytedance.android.livesdk.gift.platform.core.model.c0 {
        public final /* synthetic */ FastGiftViewModel a;

        public j(FastGiftViewModel r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.model.r
        public final void b(com.bytedance.android.livesdk.gift.platform.core.model.t r3, com.bytedance.android.livesdk.gift.platform.core.model.y r4) {
            Intrinsics.checkNotNullParameter(r3, "info");
            Intrinsics.checkNotNullParameter(r4, "response");
            String r5 = r3.i().N;
            if (r5 == null) goto L11;
            if (TextUtils.isEmpty(r5) == false) goto L8;
            r5 = null;
        L8:
            if (r5 == null) goto L11;
            com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(s1.getContext(), r5);
        L11:
            if ((r4 instanceof com.bytedance.android.livesdk.gift.platform.core.model.y.c.a) == false) goto L14;
            this.a.comboFinish(true);
            return;
        }
    }

    static {
        Companion = new a();
    }

    public final boolean getFastGiftImageFormate() {
        return ((Boolean) this.fastGiftImageFormate$delegate.getValue()).booleanValue();
    }

    public final NextLiveData<Boolean> getOpenPopupGiftDialog() {
        return (NextLiveData) this.openPopupGiftDialog$delegate.getValue();
    }

    public final boolean getRemindUserByGiftPrice() {
        return ((Boolean) this.remindUserByGiftPrice$delegate.getValue()).booleanValue();
    }

    private final void initRecommendNum() {
        com.bytedance.tools.kcp.spongepreference.runtime.a r0 = ay1.b.f;
        KProperty[] r1 = ay1.b.a;
        Pair r3 = (Pair) r0.getValue(null, r1[5]);
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.o(((Number) r3.getFirst()).longValue()) == false) goto L5;
        this.recommendShowTimes = ((Number) r3.getSecond()).intValue();
        return;
    L5:
        this.recommendShowTimes = 0;
        Pair r4 = new Pair(Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.recommendShowTimes));
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.setValue(null, r1[5], r4);
    }

    private final boolean needShowErrorConfirm() {
        com.bytedance.tools.kcp.spongepreference.runtime.a r0 = com.bytedance.android.livesdk.gift.fastgift.c.b;
        KProperty[] r1 = com.bytedance.android.livesdk.gift.fastgift.c.a;
        if (((Boolean) r0.getValue(null, r1[0])).booleanValue() == false) goto L5;
        return false;
    L5:
        String r2 = (String) ((HashMap) com.bytedance.android.livesdk.gift.fastgift.c.c.getValue(null, r1[1])).get(getToolbarButtonName());
        boolean r3 = TextUtils.equals(com.bytedance.live.kmp.util.e.a.format(new Date()), r2);
        boolean r4 = ArraysKt.contains(com.bytedance.android.livesdk.gift.fastgift.d.a().b(), ay1.b.u());
        if (com.bytedance.android.livesdk.gift.fastgift.d.a().a() == false) goto L11;
        if (r3 == true) goto L27;
        if (r4 == false) goto L28;
        return true;
    L28:
        return false;
    L27:
        return false;
    L11:
        int[] r5 = com.bytedance.android.livesdk.gift.fastgift.d.a().c();
        int r6 = r5.length;
        int r7 = 0;
    L12:
        if (r7 >= r6) goto L22;
        int r8 = r5[r7];
        com.bytedance.android.livesdk.revenue.service.toolbar.f r9 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.toolbar.f.class);
        if (r9 == null) goto L21;
        if (r9.Db(r8, this.dataCenter) != true) goto L21;
        if (r3 == true) goto L29;
        if (r4 == false) goto L30;
        return true;
    L30:
        return false;
    L29:
        return false;
    L21:
        r7 = r7 + 1;
        goto L12
    L22:
        return false;
    }

    private final boolean needShowRecommendConfirm() {
        Pair r0 = (Pair) this.recommendGift.getValue();
        if (r0 != null) goto L5;
    L13:
        return false;
    L5:
        if (((h1) r0.getFirst()) == null) goto L13;
        com.bytedance.android.livesdk.gift.platform.core.model.t r1 = this.transaction;
        if (r1 == null) goto L12;
        if (r1.isDisposed() == true) goto L12;
        return false;
    L12:
        return !com.bytedance.android.livesdk.gift.platform.core.utils.u.o(((Number) ay1.b.e.getValue(null, ay1.b.a[4])).longValue());
    }

    public final boolean enableGift() {
        IRoom r0 = this.room;
        if (r0 == null) goto L7;
        IRoomAuthStatus r1 = r0.getRoomAuthStatus();
        if (r1 == null) goto L7;
        return r1.getEnableGift();
    L7:
        return false;
    }

    public final void errorConfirm() {
        com.bytedance.android.livesdk.gift.fastgift.c.b.setValue(null, com.bytedance.android.livesdk.gift.fastgift.c.a[0], Boolean.TRUE);
    }

    public final int getRechargedState() {
        int r0 = this.rechargedState;
        if (r0 == 0) goto L6;
        return r0;
    L6:
        if (RechargeServices.a(RechargeServices.b()).h() == true) goto L10;
        return 2;
    L10:
        return 1;
    }

    public final Map<String, String> getRecommendLog() {
        if (((RecommendFastGiftStatus) this.recommendStatus.getValue()) != RecommendFastGiftStatus.Idle) goto L7;
        return null;
    L7:
        return this.recommendFastGiftLog;
    }

    public final void initFollowStateChanged() {
        CompositeDisposable r0 = this.compositeDisposable;
        com.bytedance.android.livesdk.revenue.service.user.a r1 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        IRoom r2 = this.room;
        if (r2 == null) goto L6;
        String r3 = r2.getAnchorId();
        if (r3 == null) goto L6;
    L7:
        r0.add(r1.u0(r3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this)));
        return;
    L6:
        r3 = "0";
        goto L7
    }

    public final void initMessageObserver() {
        if (this.messageManager != null) goto L13;
        yz0.l r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.l.class);
        if (r0 == null) goto L10;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Disposable r1 = yz0.h.a.a(r0, com.bytedance.android.live.revenue.common.message.b.K, false, 6).subscribe(new i(new FastGiftViewModel$initMessageObserver$1$1(this)));
        if (r1 == null) goto L9;
        RxUtilKt.c(r1, this.taskCompositeDisposable);
    L9:
        Unit r2 = Unit.INSTANCE;
    L11:
        this.messageManager = r0;
        return;
    L10:
        r0 = null;
        goto L11
    }

    public final boolean isFirstRechargePopupGiftValid() {
        GiftManagerKt.z.getClass();
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b r0 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b.class);
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L12;
        com.bytedance.android.livesdk.gift.platform.core.model.e0 r1 = r0.g();
        if (r1 != null) goto L7;
    L20:
        return false;
    L7:
        if (r1.a <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L20;
        return true;
    L9:
        r2 = false;
        goto L10
    L12:
        com.bytedance.android.livesdk.gift.platform.core.model.e0 r3 = GiftManagerKt.x();
        if (r3 == null) goto L20;
        if (r3.a <= 0) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L20;
        return true;
    L17:
        r4 = false;
        goto L18
    }

    public final void notifyRecommendCountDownFinished() {
        this.recommendStatus.postValue(RecommendFastGiftStatus.RecommendFinished);
    }

    public final void notifyRecommendFinished() {
        this.recommendStatus.postValue(RecommendFastGiftStatus.Idle);
        this.recommendGift.postValue(null);
        this.recommendFastGiftLog = null;
    }

    public final void notifyRecommendTurningFinished() {
        this.recommendStatus.postValue(RecommendFastGiftStatus.CountDown);
    }

    public void onCleared() {
        this.compositeDisposable.dispose();
        this.rxCompositeDisposable.dispose();
        this.dataCenter = null;
        super.onCleared();
    }

    public final void reset() {
        this.needConfirm.setValue(null);
        this.needErrorConfirm.setValue(null);
        this.needRecommendConfirm.setValue(null);
        this.recommendGift.setValue(null);
        this.recommendStatus.setValue(RecommendFastGiftStatus.Idle);
        Disposable r0 = this.recommendGiftAnimDisposable;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.recommendFastGiftLog = null;
        this.fastGiftHint.setValue(null);
        this.followState.setValue(null);
        this.comboCount.setValue(0);
        if (this.fastTaskGiftModel == null) goto L12;
        this.fastGift.setValue(null);
        this.fastTaskGiftModel = null;
        IRoom r1 = this.room;
        if (r1 == null) goto L10;
        Long r2 = Long.valueOf(r1.getRoomId());
    L11:
        GiftManagerKt.D(r2);
        goto L12
    L10:
        r2 = null;
    L12:
        this.taskCompositeDisposable.clear();
        this.messageManager = null;
        if (com.bytedance.android.livesdk.gift.platform.business.toolbar.c.a() == false) goto L16;
        this.preGiftId = 0;
        this.preRoomOwnerId = BuildConfig.FLAVOR;
        return;
    }

    public FastGiftViewModel() {
        this.fastGift = new MutableLiveData();
        this.fastGiftHint = new MutableLiveData();
        this.needConfirm = new MutableLiveData();
        this.needRecommendConfirm = new MutableLiveData();
        this.needErrorConfirm = new MutableLiveData();
        this.openPopupGiftDialog$delegate = LazyKt.lazy(FastGiftViewModel$openPopupGiftDialog$2.INSTANCE);
        this.comboCount = new MutableLiveData();
        this.followState = new MutableLiveData();
        Boolean r1 = Boolean.FALSE;
        this.behaviorVisible = new MutableLiveData(r1);
        this.showInfo = new com.bytedance.android.livesdk.gift.platform.core.model.n(null, null, 7);
        this.recommendGift = new MutableLiveData();
        this.recommendStatus = new MutableLiveData(RecommendFastGiftStatus.Idle);
        this.loadToolbarFastGift = BehaviorSubject.createDefault(r1);
        this.compositeDisposable = new CompositeDisposable();
        this.rxCompositeDisposable = new CompositeDisposable();
        this.taskCompositeDisposable = new CompositeDisposable();
        this.preRoomOwnerId = BuildConfig.FLAVOR;
        this.popupGiftClickSource = BuildConfig.FLAVOR;
        this.keyOfShownGift = BuildConfig.FLAVOR;
        this.remindUserByGiftPrice$delegate = LazyKt.lazy(FastGiftViewModel$remindUserByGiftPrice$2.INSTANCE);
        this.fastGiftImageFormate$delegate = LazyKt.lazy(FastGiftViewModel$fastGiftImageFormate$2.INSTANCE);
        registerP5RxBus(com.bytedance.android.livesdk.gift.platform.core.model.c.class);
        registerRxBus(com.bytedance.android.livesdk.event.v.class);
        registerRxBus(ca0.t.class);
        registerRxBus(com.bytedance.android.livesdk.gift.platform.core.model.a0.class);
        this.comboCount.setValue(0);
        initMessageObserver();
        initRecommendNum();
    }

    private final h1 getFastGiftModelFromExtra() {
        if (com.bytedance.android.livesdk.gift.platform.business.toolbar.c.b() == true) goto L5;
        return null;
    L5:
        h1 r0 = this.roomStructFastGift;
        if (r0 == null) goto L8;
        return r0;
    L8:
        yz0.k r1 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r1 == null) goto L35;
        List r2 = r1.getToolbarDataList();
        if (r2 == null) goto L35;
        Iterator r3 = r2.iterator();
    L14:
        if (r3.hasNext() == false) goto L21;
        Object r4 = r3.next();
        if (((IToolbarComponentData) r4).getId() != 29) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L14;
    L22:
        IToolbarComponentData r6 = (IToolbarComponentData) r4;
        if (r6 == null) goto L35;
        JsonElement r7 = GsonHelper.parser().parse(r6.getExtraData());     // Catch: Throwable -> L33
        if (r7 == null) goto L27;
        JsonObject r8 = r7.getAsJsonObject();     // Catch: Throwable -> L33
    L28:
        h1 r9 = (h1) GsonHelper.get().fromJson(r8, h1.class);     // Catch: Throwable -> L33
        this.roomStructFastGift = r9;     // Catch: Throwable -> L33
        if (r9 == null) goto L31;
        r9.enableImageFormatOpt(getFastGiftImageFormate());     // Catch: Throwable -> L33
    L31:
        GiftManagerKt r10 = GiftManagerKt.z;     // Catch: Throwable -> L33
        h1 r11 = this.roomStructFastGift;     // Catch: Throwable -> L33
        r10.getClass();     // Catch: Throwable -> L33
        ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).X(r11);     // Catch: Throwable -> L33
        GiftManagerKt.y = r11;     // Catch: Throwable -> L33
        return this.roomStructFastGift;
    L27:
        r8 = null;
    L33:
        th = move-exception;
        jy0.b.b(TAG, "Error parsing json", th);
        goto L35
    L18:
        r5 = false;
        goto L19
    L21:
        r4 = null;
    L35:
        return null;
    }

    private final HashSet<String> getLookingForSetCache() {
        if (getRemindUserByGiftPrice() == false) goto L6;
        return (HashSet) com.bytedance.android.livesdk.gift.fastgift.c.d.getValue(null, com.bytedance.android.livesdk.gift.fastgift.c.a[2]);
    L6:
        return (HashSet) com.bytedance.android.livesdk.gift.fastgift.c.e.getValue(null, com.bytedance.android.livesdk.gift.fastgift.c.a[3]);
    }

    private final boolean needShowConfirm() {
        if (isFirstRechargePopupGiftValid() == false) goto L6;
        return false;
    L6:
        boolean r0 = getRemindUserByGiftPrice();
        String r1 = BuildConfig.FLAVOR;
        if (r0 == false) goto L13;
        h1 r2 = getGift();
        if (r2 == null) goto L19;
        String r3 = String.valueOf(r2.getDiamondCount());
        if (r3 == null) goto L19;
    L18:
        r1 = r3;
    L19:
        this.keyOfShownGift = r1;
        return !getLookingForSetCache().contains(this.keyOfShownGift);
    L13:
        h1 r4 = getGift();
        if (r4 == null) goto L19;
        r3 = String.valueOf(r4.getId());
        if (r3 != null) goto L18;
        goto L18
    }

    public final boolean currentIsRecommend() {
        if (com.bytedance.android.livesdk.gift.platform.business.b.f().d() == false) goto L14;
        Pair r0 = (Pair) this.recommendGift.getValue();
        if (r0 == null) goto L7;
        h1 r1 = (h1) r0.getFirst();
    L8:
        if (r1 == null) goto L14;
        if (((RecommendFastGiftStatus) this.recommendStatus.getValue()) == RecommendFastGiftStatus.Idle) goto L14;
        if (((RecommendFastGiftStatus) this.recommendStatus.getValue()) == RecommendFastGiftStatus.RecommendFinished) goto L14;
        return true;
    L7:
        r1 = null;
    L14:
        return false;
    }

    public final boolean disallowSendGiftDurationRecommend() {
        if (com.bytedance.android.livesdk.gift.platform.business.b.f().d() == true) goto L5;
    L9:
        return false;
    L5:
        if (((RecommendFastGiftStatus) this.recommendStatus.getValue()) != RecommendFastGiftStatus.Turning) goto L7;
    L8:
        return true;
    L7:
        if (((RecommendFastGiftStatus) this.recommendStatus.getValue()) != RecommendFastGiftStatus.RecommendFinished) goto L9;
        goto L8
    }

    public final h1 getGift() {
        if (currentIsRecommend() == false) goto L8;
        Pair r0 = (Pair) this.recommendGift.getValue();
        if (r0 != null) goto L12;
        return null;
    L12:
        return (h1) r0.getFirst();
    L8:
        h1 r1 = GiftManagerKt.p();
        if (r1 == null) goto L11;
        return r1;
    L11:
        return getFastGiftModelFromExtra();
    }

    public final long getGiftId() {
        if (isFirstRechargePopupGiftValid() == false) goto L5;
        GiftManagerKt.z.getClass();
        return GiftManagerKt.r();
    L5:
        h1 r0 = getGift();
        if (r0 != null) goto L11;
        return 0;
    L11:
        return r0.getId();
    }

    public final String getToolbarButtonName() {
        if (com.bytedance.android.livesdk.gift.fastgift.d.a().a() == false) goto L6;
        return "All";
    L6:
        int[] r0 = com.bytedance.android.livesdk.gift.fastgift.d.a().c();
        if (r0.length <= 0) goto L16;
        int r1 = r0[0];
        com.bytedance.android.livesdk.revenue.service.toolbar.f r2 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.toolbar.f.class);
        if (r2 == null) goto L11;
        String r3 = r2.ei(r1);
    L12:
        if (r3 != null) goto L15;
        return BuildConfig.FLAVOR;
    L15:
        return r3;
    L11:
        r3 = null;
        goto L12
    L16:
        return BuildConfig.FLAVOR;
    }

    public final boolean hasGift() {
        if (getGift() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void hideConfirm() {
        HashSet<String> r0 = getLookingForSetCache();
        if (getRemindUserByGiftPrice() == false) goto L5;
        r0.clear();
    L5:
        r0.add(this.keyOfShownGift);
        setLookingForSetCache(r0);
        com.bytedance.tools.kcp.spongepreference.runtime.a r1 = com.bytedance.android.livesdk.gift.fastgift.c.c;
        KProperty[] r2 = com.bytedance.android.livesdk.gift.fastgift.c.a;
        HashMap r3 = (HashMap) r1.getValue(null, r2[1]);
        r3.put(getToolbarButtonName(), com.bytedance.live.kmp.util.e.a.format(new Date()));
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r1.setValue(null, r2[1], r3);
    }

    public final boolean isCombo() {
        if (currentIsRecommend() == false) goto L6;
        return true;
    L6:
        h1 r0 = getGift();
        if (r0 != null) goto L9;
        return false;
    L9:
        return r0.getRepeat();
    }

    public final void sendGiftTransaction() {
        if (currentIsRecommend() == false) goto L10;
        if (needShowRecommendConfirm() == false) goto L8;
        this.needRecommendConfirm.postValue(Boolean.TRUE);
        return;
    L8:
        this.recommendStatus.postValue(RecommendFastGiftStatus.Combo);
    L17:
        sendGift(Boolean.TRUE);
        return;
    L10:
        if (needShowConfirm() == false) goto L14;
        this.needConfirm.postValue(Boolean.TRUE);
        return;
    L14:
        if (needShowErrorConfirm() == false) goto L17;
        this.needErrorConfirm.postValue(Boolean.TRUE);
    }

    public final MutableLiveData<Boolean> getBehaviorVisible() {
        return this.behaviorVisible;
    }

    public final MutableLiveData<Integer> getComboCount() {
        return this.comboCount;
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public final MutableLiveData<h1> getFastGift() {
        return this.fastGift;
    }

    public final MutableLiveData<Boolean> getFastGiftHint() {
        return this.fastGiftHint;
    }

    public final my1.a getFastTaskGiftModel() {
        return this.fastTaskGiftModel;
    }

    public final MutableLiveData<Boolean> getFollowState() {
        return this.followState;
    }

    public final BehaviorSubject<Boolean> getLoadToolbarFastGift() {
        return this.loadToolbarFastGift;
    }

    public final MutableLiveData<Boolean> getNeedConfirm() {
        return this.needConfirm;
    }

    public final MutableLiveData<Boolean> getNeedErrorConfirm() {
        return this.needErrorConfirm;
    }

    public final MutableLiveData<Boolean> getNeedRecommendConfirm() {
        return this.needRecommendConfirm;
    }

    public final String getPopupGiftClickSource() {
        return this.popupGiftClickSource;
    }

    public final long getPreGiftId() {
        return this.preGiftId;
    }

    public final String getPreRoomOwnerId() {
        return this.preRoomOwnerId;
    }

    public final MutableLiveData<Pair<h1, String>> getRecommendGift() {
        return this.recommendGift;
    }

    public final int getRecommendNum() {
        return this.recommendShowTimes;
    }

    public final MutableLiveData<RecommendFastGiftStatus> getRecommendStatus() {
        return this.recommendStatus;
    }

    public final int getRepeatCount() {
        return this.repeatCount;
    }

    public final IRoom getRoom() {
        return this.room;
    }

    public final com.bytedance.android.livesdk.gift.platform.core.model.n getShowInfo() {
        return this.showInfo;
    }

    public final boolean isAnchor() {
        return this.isAnchor;
    }

    public static final /* synthetic */ my1.a access$getFastTaskGiftModelCache$p(FastGiftViewModel r0) {
        return r0.fastTaskGiftModelCache;
    }

    private final void onMessage(yh6.c r5) {
        if ((r5 instanceof l5) == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(((l5) r5).getExtraData()) == false) goto L33;
        return;
    L33:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L27
        if (((RecommendFastGiftStatus) this.recommendStatus.getValue()) == RecommendFastGiftStatus.Idle) goto L10;
        return;
    L10:
        my1.a r2 = (my1.a) GsonHelper.get().fromJson(((l5) r5).getExtraData(), my1.a.class);     // Catch: Throwable -> L27
        Unit r3 = null;
        if (r2 != null) goto L13;
    L25:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L27
    L29:
        Throwable r6 = Result.exceptionOrNull-impl(r4);
        if (r6 == null) goto L36;
        int r7 = x8.a.a;
        x8.a.b(TAG, "onMessage fromJson onFailure msgId=" + qj.a(r5) + " err=" + r6.getMessage(), false);
        return;
    L36:
        return;
    L13:
        if ((!TextUtils.isEmpty(r2.speedyGift)) == true) goto L16;
        r2 = null;
    L16:
        if (r2 == null) goto L25;
        Integer r8 = (Integer) this.comboCount.getValue();     // Catch: Throwable -> L27
        if (r8 != null) goto L21;
        r8 = 0;     // Catch: Throwable -> L27
    L21:
        if (Intrinsics.compare(r8.intValue(), 0) <= 0) goto L24;
        this.fastTaskGiftModelCache = r2;     // Catch: Throwable -> L27
        return;
    L24:
        processFastTaskGiftModel(r2);     // Catch: Throwable -> L27
        r3 = Unit.INSTANCE;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    }

    private final void onOpenPopupGiftDialogEvent(ca0.t r6) {
        this.popupGiftClickSource = r6.a;
        if (getRechargedState() != 2) goto L5;
        boolean r0 = true;
    L6:
        GiftManagerKt.z.getClass();
        long r1 = GiftManagerKt.r();
        String r7 = r6.a;
        int r3 = com.bytedance.android.livesdk.gift.fastgift.a.a;
        Intrinsics.checkNotNullParameter(r7, "clickSource");
        HashMap r4 = new HashMap();
        r4.put("gift_id", String.valueOf(r1));
        r4.put("click_source", r7);
        if (r0 == false) goto L9;
        String r8 = "1";
    L10:
        r4.put("is_charged", r8);
        mz0.n r9 = new mz0.n();
        Map r2 = r9.a;
        Intrinsics.checkNotNullParameter(r2, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r2.putAll(r4);
        mz0.m r5 = new mz0.m();
        r5.b(LogCommon.ROOM);
        r5.b(LogCommon.PAGE_SOURCE_LOG);
        List r10 = r9.b;
        ArrayList r11 = (ArrayList) r10;
        r11.addAll(r5.a);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r14);
        ((f80.a) r14).w3("livesdk_norecharge_gift_guide_show", r9.a, r9.b);
        getOpenPopupGiftDialog().setValue(Boolean.TRUE);
        return;
    L9:
        r8 = "0";
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    private final void onRechargeDialogPaySuccessEvent(com.bytedance.android.livesdk.event.v r1) {
        this.rechargedState = 2;
    }

    private final void onRecommendFastGiftEvent(com.bytedance.android.livesdk.gift.platform.core.model.a0 r23) {
        if (com.bytedance.android.livesdk.gift.platform.business.b.f().d() == true) goto L5;
        return;
    L5:
        if (((RecommendFastGiftStatus) this.recommendStatus.getValue()) != RecommendFastGiftStatus.Idle) goto L48;
        com.bytedance.android.livesdk.gift.platform.core.model.t r1 = this.transaction;
        if (r1 != null) goto L10;
    L12:
        HashMap<String, String> r2 = com.bytedance.android.livesdk.gift.platform.business.b.f().h();
        String r3 = null;
        if (r2 == null) goto L15;
        r23.getClass();
        String r4 = r2.get(null);
    L17:
        if (TextUtils.isEmpty(r4) == false) goto L19;
        return;
    L19:
        r23.getClass();
        long r5 = 0;
        h1 r6 = GiftManagerKt.j(0, null);
        if (r6 != null) goto L22;
        return;
    L22:
        this.recommendGift.postValue(new Pair(r6, null));
        this.recommendFastGiftLog = null;
        this.recommendStatus.postValue(RecommendFastGiftStatus.Turning);
        DataCenter r7 = this.dataCenter;
        if (r7 == null) goto L27;
        Long r8 = (Long) r7.get("room_enter_finish_time", -1L);
        if (r8 == null) goto L27;
        long r13 = r8.longValue();
    L28:
        DataCenter r9 = this.dataCenter;
        if (r9 == null) goto L33;
        Long r10 = (Long) r9.get("room_first_frame_time", -1L);
        if (r10 == null) goto L33;
        r5 = r10.longValue();
    L33:
        long r15 = r5;
        com.bytedance.tools.kcp.spongepreference.runtime.a r11 = ay1.b.f;
        KProperty[] r14 = ay1.b.a;
        Pair r16 = (Pair) r11.getValue(null, r14[5]);
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.o(((Number) r16.getFirst()).longValue()) == false) goto L36;
        this.recommendShowTimes = ((Number) r16.getSecond()).intValue() + 1;
    L37:
        Pair r17 = new Pair(Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.recommendShowTimes));
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r11.setValue(null, r14[5], r17);
        Map<String, String> r18 = this.recommendFastGiftLog;
        int r19 = this.recommendShowTimes;
        IRoom r20 = this.room;
        if (r20 == null) goto L42;
        IBaseUser r21 = r20.getOwner();
        if (r21 == null) goto L42;
        r3 = r21.getIdString();
    L42:
        com.bytedance.android.livesdk.gift.fastgift.a.f(0, null, null, r13, r15, r18, r19, r3, 6);
        Disposable r24 = this.recommendGiftAnimDisposable;
        if (r24 == null) goto L45;
        r24.dispose();
    L45:
        this.recommendGiftAnimDisposable = Observable.timer(3000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
        return;
    L36:
        this.recommendShowTimes = 1;
    L27:
        r13 = 0;
        goto L28
    L15:
        r4 = null;
        goto L17
    L10:
        if (r1.isDisposed() == true) goto L12;
        return;
    }

    private final void onUpdateFastGiftEvent(com.bytedance.android.livesdk.gift.platform.core.model.c r5) {
        String r1 = null;
        if (com.bytedance.android.livesdk.gift.platform.business.toolbar.c.b() == true) goto L5;
    L8:
        h1 r0 = r5.a;
        GiftManagerKt.z.getClass();
        boolean r2 = true;
        if (GiftManagerKt.B() == false) goto L14;
        if (r5.getType() == 1) goto L14;
        return;
    L14:
        if (r5.getType() != 2) goto L16;
    L17:
        this.fastGiftHint.postValue(Boolean.valueOf(r5.c));
    L18:
        this.fastGift.postValue(r5.a);
        if (r5.a != null) goto L22;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(this.dataCenter).d(RevToolbarButton.FastGift);
        return;
    L22:
        if (enableGift() == true) goto L28;
        IRoom r6 = this.room;
        if (r6 != null) goto L26;
    L29:
        if (r2 == false) goto L42;
        IRoom r7 = this.room;
        if (r7 == null) goto L38;
        IMainRoom r8 = r7.castToOrNull(IMainRoom.class);
        if (r8 == null) goto L38;
        Map r9 = r8.getAnchorAbMap();
        if (r9 == null) goto L38;
        r1 = (String) r9.get("gift_hide_tip");
    L38:
        if (Intrinsics.areEqual(r1, "2") == false) goto L42;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(this.dataCenter).d(RevToolbarButton.FastGift);
        return;
    L42:
        if (com.bytedance.android.livesdk.gift.fastgift.d.b().getEnablePreRoomEnter() == true) goto L44;
    L46:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(this.dataCenter).b(RevToolbarButton.FastGift);
        return;
    L44:
        if (com.bytedance.android.livesdk.gift.fastgift.d.b().getDelayFastGift() <= 0) goto L46;
        i0.c().postDelayed(new d(this), com.bytedance.android.livesdk.gift.fastgift.d.b().getDelayFastGift());
        return;
    L26:
        if (r6.isMediaRoom() != true) goto L29;
    L28:
        r2 = false;
        goto L29
    L16:
        if (r5.getType() != 1) goto L18;
    L5:
        if (((Boolean) com.bytedance.android.livesdk.gift.fastgift.d.e.getValue(null, com.bytedance.android.livesdk.gift.fastgift.d.a[3])).booleanValue() == false) goto L8;
        onUpdateFastGiftEventForToolbarOptimize(r5);
    }

    private final void onUpdateFastGiftEventForToolbarOptimize(com.bytedance.android.livesdk.gift.platform.core.model.c r5) {
        if (com.bytedance.android.livesdk.gift.platform.business.toolbar.c.b() == true) goto L5;
        return;
    L5:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.toolbar.a.j.getValue(null, com.bytedance.android.livesdk.gift.platform.business.toolbar.a.a[8])).booleanValue() == false) goto L24;
        GiftManagerKt.z.getClass();
        if (GiftManagerKt.B() == false) goto L13;
        if (r5.getType() == 1) goto L13;
        return;
    L13:
        if (r5.a != null) goto L15;
        return;
    L15:
        if (com.bytedance.android.livesdk.gift.fastgift.d.b().getEnablePreRoomEnter() == true) goto L17;
    L19:
        this.loadToolbarFastGift.onNext(Boolean.TRUE);
        return;
    L17:
        if (com.bytedance.android.livesdk.gift.fastgift.d.b().getDelayFastGift() <= 0) goto L19;
        i0.c().postDelayed(new e(this), com.bytedance.android.livesdk.gift.fastgift.d.b().getDelayFastGift());
        return;
    }

    private final void processFastTaskGiftModel(my1.a r10) {
        String r0 = r10.delay;
        Long r1 = null;
        if (r0 == null) goto L18;
        boolean r4 = true;
        if (r0.length() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L10;
    L12:
        r4 = false;
    L13:
        if (r4 == true) goto L16;
        r0 = null;
    L16:
        if (r0 == null) goto L18;
        long r5 = CastLongProtector.parseLong(r0);
    L36:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L24
        r10.a = (my1.b) GsonHelper.get().fromJson(r10.personalGiftStr, my1.b.class);     // Catch: Throwable -> L24
        h1 r6 = (h1) GsonHelper.get().fromJson(r10.speedyGift, h1.class);     // Catch: Throwable -> L24
        if (r6 == null) goto L22;
        r1 = Long.valueOf(r6.getId());     // Catch: Throwable -> L24
    L22:
        r10.c = r1;     // Catch: Throwable -> L24
        r10.b = r6;     // Catch: Throwable -> L24
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L29;
        int r9 = x8.a.a;
        x8.a.b(TAG, "processFastTaskGiftModel onFailure  " + r8.getMessage(), false);
    L29:
        this.fastTaskGiftModel = r10;
        GiftContext r11 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r11 == null) goto L34;
        com.bytedance.live.datacontext.n<my1.a> r13 = r11.getFastTaskGiftModel();
        if (r13 == null) goto L34;
        r13.setValue(this.fastTaskGiftModel);
    L34:
        this.taskCompositeDisposable.add(Single.timer(r5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this)));
        return;
    L24:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L10:
        if (CastLongProtector.parseLong(r0) <= 0) goto L12;
    L7:
        r3 = false;
    L18:
        r5 = 1;
        goto L36
    }

    private final <T> void registerP5RxBus(Class<T> r3) {
        if (k60.b.d() == false) goto L5;
        this.rxCompositeDisposable.add(xs2.b.a().a.ofType(r3).observeOn(RxUtil.getLiveMainThreadP5Scheduler()).subscribe(new g(this)));
        return;
    L5:
        registerRxBus(r3);
    }

    private final <T> void registerRxBus(Class<T> r3) {
        this.rxCompositeDisposable.add(xs2.b.a().b(r3).subscribe(new h(this)));
    }

    private final void setLookingForSetCache(HashSet<String> r5) {
        if (getRemindUserByGiftPrice() == false) goto L5;
        KProperty[] r0 = com.bytedance.android.livesdk.gift.fastgift.c.a;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        com.bytedance.android.livesdk.gift.fastgift.c.d.setValue(null, com.bytedance.android.livesdk.gift.fastgift.c.a[2], r5);
        return;
    L5:
        KProperty[] r1 = com.bytedance.android.livesdk.gift.fastgift.c.a;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        com.bytedance.android.livesdk.gift.fastgift.c.e.setValue(null, com.bytedance.android.livesdk.gift.fastgift.c.a[3], r5);
    }

    public final void comboFinish(boolean r3) {
        this.comboCount.setValue(0);
        my1.a r0 = this.fastTaskGiftModelCache;
        if (r0 == null) goto L5;
        processFastTaskGiftModel(r0);
    L5:
        com.bytedance.android.livesdk.gift.platform.core.model.t r1 = this.transaction;
        if (r1 == null) goto L8;
        r1.finish();
    L8:
        this.transaction = null;
        if (currentIsRecommend() == false) goto L13;
        if (r3 == true) goto L14;
        notifyRecommendCountDownFinished();
        return;
    L14:
        return;
    }

    public final boolean isCommerceRoom(IRoom r1) {
        yz0.k r2 = com.bytedance.android.livesdk.gift.platform.core.utils.u.h();
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.e4();
    }

    public final void sendGift(Boolean r64) {
        if (Intrinsics.areEqual(r64, Boolean.TRUE) == false) goto L8;
        Integer r0 = (Integer) this.comboCount.getValue();
        if (r0 != null) goto L7;
        r0 = 0;
    L7:
        this.comboCount.setValue(Integer.valueOf(r0.intValue() + 1));
    L8:
        h1 r1 = getGift();
        if (r1 != null) goto L11;
    L13:
        SendGiftStrategy r2 = SendGiftStrategy.REQUEST_AFTER_RESPONSE;
    L14:
        SendGiftStrategy r19 = r2;
        long r3 = getGiftId();
        my1.a r4 = this.fastTaskGiftModel;
        Bundle r60 = null;
        if (r4 == null) goto L17;
        Long r5 = r4.c;
    L18:
        String r6 = BuildConfig.FLAVOR;
        if (r5 != null) goto L22;
    L40:
        String r14 = BuildConfig.FLAVOR;
        String r43 = r14;
    L41:
        Map r53 = MapsKt.mapOf(TuplesKt.to(GiftToRechargeParamsKey.KEY_SEND_GIFT_CHARGE_REASON.getKeyName(), "shortcut_gift"));
        if (this.transaction != null) goto L54;
        HashMap r7 = new HashMap();
        Map<String, String> r8 = this.recommendFastGiftLog;
        if (r8 != null) goto L46;
    L51:
        r7.put("recommend_num", String.valueOf(this.recommendShowTimes));
        GiftTransaction r9 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.p(new com.bytedance.android.livesdk.gift.platform.core.model.b0(getGiftId(), SendGiftSource.FastGift, null, null, 4, GIFT_SOURCE, "convenient", "shortcut", null, r14, 0, null, null, false, r19, 0, false, null, 0, null, false, null, false, 0, null, null, null, this.showInfo, null, null, null, r7, 0, 0, null, r43, false, null, null, null, null, null, null, false, null, null, r53, null, 0, null, null, 2013248780, 8257471));
        this.transaction = r9;
        if (r9 == null) goto L54;
        r9.h(new j(this));
        goto L54
    L46:
        if ((!r8.isEmpty()) == true) goto L49;
        r8 = null;
    L49:
        if (r8 == null) goto L51;
        r7.putAll(r8);
    L54:
        GiftContext r10 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r10 == null) goto L59;
        com.bytedance.live.datacontext.n<Bundle> r11 = r10.getGiftLogExtra();
        if (r11 == null) goto L59;
        r60 = (Bundle) r11.getValue();
    L59:
        if (r60 != null) goto L65;
        GiftContext r13 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r13 == null) goto L65;
        com.bytedance.live.datacontext.n<Bundle> r15 = r13.getGiftLogExtra();
        if (r15 == null) goto L65;
        r15.setValue(new Bundle());
    L65:
        GiftContext r16 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r16 == null) goto L72;
        com.bytedance.live.datacontext.n<Bundle> r17 = r16.getGiftLogExtra();
        if (r17 == null) goto L72;
        Bundle r18 = (Bundle) r17.getValue();
        if (r18 == null) goto L72;
        r18.putString("gift_show_from", "none");
    L72:
        com.bytedance.android.livesdk.gift.platform.core.model.t r20 = this.transaction;
        if (r20 == null) goto L80;
        r20.d(1);
        return;
    L80:
        return;
    L22:
        if (r3 != r5.longValue()) goto L40;
        my1.a r21 = this.fastTaskGiftModel;
        if (r21 == null) goto L40;
        my1.b r23 = r21.a;
        if (r23 == null) goto L40;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L36
        JSONObject r25 = new JSONObject();     // Catch: Throwable -> L36
        JSONObject r26 = new JSONObject();     // Catch: Throwable -> L36
        r26.put("send_source", r23.sendSource);     // Catch: Throwable -> L36
        Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L36
        r25.put("growth_task", r26);     // Catch: Throwable -> L36
        String r28 = r25.toString();     // Catch: Throwable -> L36
        String r29 = r23.taskPanelSchema;     // Catch: Throwable -> L34
        if (r29 == null) goto L32;
        r6 = r29;
    L32:
        Object r30 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L34
    L39:
        Result.box-impl(r30);
        r14 = r28;
        r43 = r6;
    L34:
        th = th;
        String r63 = r6;
        r6 = r28;
        String r31 = r63;
    L38:
        Result.Companion r33 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        String r65 = r6;
        r6 = r31;
        r28 = r65;
    L36:
        th = th;
        r31 = BuildConfig.FLAVOR;
        goto L38
    L17:
        r5 = null;
        goto L18
    L11:
        if (j0.a(r1) != true) goto L13;
        r2 = SendGiftStrategy.ONE_SEND_ONE_REQUEST;
        goto L14
    }

    public final void setAnchor(boolean r1) {
        this.isAnchor = r1;
    }

    public final void setComboCount(MutableLiveData<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.comboCount = r2;
    }

    public final void setDataCenter(DataCenter r1) {
        this.dataCenter = r1;
    }

    public final void setFastTaskGiftModel(my1.a r1) {
        this.fastTaskGiftModel = r1;
    }

    public final void setPopupGiftClickSource(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.popupGiftClickSource = r2;
    }

    public final void setPreGiftId(long r1) {
        this.preGiftId = r1;
    }

    public final void setPreRoomOwnerId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.preRoomOwnerId = r2;
    }

    public final void setRechargedState(int r1) {
        this.rechargedState = r1;
    }

    public final void setRepeatCount(int r1) {
        this.repeatCount = r1;
    }

    public final void setRoom(IRoom r1) {
        this.room = r1;
    }

    public final boolean shouldShowIconPopUpAnim(com.bytedance.android.livesdk.gift.platform.core.model.e0 r10) {
        Intrinsics.checkNotNullParameter(r10, "info");
        if (r10.a <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        String r1 = String.valueOf(Calendar.getInstance().get(6));
        String r2 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId();
        com.bytedance.tools.kcp.spongepreference.runtime.a r3 = com.bytedance.android.livesdk.gift.fastgift.c.f;
        KProperty[] r4 = com.bytedance.android.livesdk.gift.fastgift.c.a;
        HashMap r6 = (HashMap) r3.getValue(null, r4[4]);
        if (r6.containsKey(r2) == true) goto L10;
    L13:
        r6.put(r2, r1);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r3.setValue(null, r4[4], r6);
        goto L14
    L10:
        if ((!Intrinsics.areEqual((String) r6.get(r2), r1)) == true) goto L13;
        return false;
    L14:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public final void updateRecommendConfirmRecord(boolean r5) {
        if (r5 == false) goto L5;
        long r0 = System.currentTimeMillis();
        ay1.b.e.setValue(null, ay1.b.a[4], Long.valueOf(r0));
        return;
    }

    public static final /* synthetic */ void access$onMessage(FastGiftViewModel r0, yh6.c r1) {
        r0.onMessage(r1);
    }

    public static final /* synthetic */ void access$onOpenPopupGiftDialogEvent(FastGiftViewModel r0, ca0.t r1) {
        r0.onOpenPopupGiftDialogEvent(r1);
    }

    public static final /* synthetic */ void access$onRechargeDialogPaySuccessEvent(FastGiftViewModel r0, com.bytedance.android.livesdk.event.v r1) {
        r0.onRechargeDialogPaySuccessEvent(r1);
    }

    public static final /* synthetic */ void access$onRecommendFastGiftEvent(FastGiftViewModel r0, com.bytedance.android.livesdk.gift.platform.core.model.a0 r1) {
        r0.onRecommendFastGiftEvent(r1);
    }

    public static final /* synthetic */ void access$onUpdateFastGiftEvent(FastGiftViewModel r0, com.bytedance.android.livesdk.gift.platform.core.model.c r1) {
        r0.onUpdateFastGiftEvent(r1);
    }

    public static final /* synthetic */ void access$setFastTaskGiftModelCache$p(FastGiftViewModel r0, my1.a r1) {
        r0.fastTaskGiftModelCache = r1;
    }

    public final void bindCurrentRoom(DataCenter r2, IRoom r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.dataCenter = r2;
        this.room = r3;
        this.isAnchor = ((Boolean) r2.get("data_is_anchor", Boolean.FALSE)).booleanValue();
    }

    public static /* synthetic */ void comboFinish$default(FastGiftViewModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.comboFinish(r1);
    }

    public static /* synthetic */ void sendGift$default(FastGiftViewModel r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = Boolean.FALSE;
    L5:
        r0.sendGift(r1);
    }
}
