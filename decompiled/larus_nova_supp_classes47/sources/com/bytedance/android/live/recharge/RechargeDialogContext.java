package com.bytedance.android.live.recharge;

import android.content.Context;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.service.PayMsg;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.deal.DealSetApiDataSource;
import com.bytedance.android.live.recharge.deal.Entrance;
import com.bytedance.android.live.recharge.deal.FetchFrom;
import com.bytedance.android.live.recharge.nopassword.NoPasswordScene;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.panel.RechargeBizScene;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdkapi.depend.model.IChargeDeal;
import com.bytedance.android.livesdkapi.depend.model.IDiamondRenderDataInfo;
import com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo;
import com.bytedance.android.livesdkapi.depend.model.IQueryPrePayCashierData;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 ²\u00012\u00020\u0001:\u0002³\u0001B\t¢\u0006\u0006\b°\u0001\u0010±\u0001J\u001c\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005J\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u00112\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u001d\u001a\u00020\u0005J\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u001e2\u0006\u0010\b\u001a\u00020\u001aR\u0017\u0010!\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b&\u0010(\"\u0004\b)\u0010*R&\u0010,\u001a\u00060\fj\u0002`+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00103\u001a\b\u0012\u0004\u0012\u00020%028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b3\u00105\"\u0004\b6\u00107R\"\u00108\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010'\u001a\u0004\b8\u0010(\"\u0004\b9\u0010*R\u0017\u0010;\u001a\u00020:8\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R%\u0010A\u001a\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010%0%0?8\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR%\u0010E\u001a\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010\u00050\u00050?8\u0006¢\u0006\f\n\u0004\bE\u0010B\u001a\u0004\bF\u0010DR%\u0010G\u001a\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010\u00050\u00050?8\u0006¢\u0006\f\n\u0004\bG\u0010B\u001a\u0004\bH\u0010DR%\u0010I\u001a\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010\u00050\u00050?8\u0006¢\u0006\f\n\u0004\bI\u0010B\u001a\u0004\bJ\u0010DR%\u0010K\u001a\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010\u00050\u00050?8\u0006¢\u0006\f\n\u0004\bK\u0010B\u001a\u0004\bL\u0010DR%\u0010M\u001a\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010\u00050\u00050?8\u0006¢\u0006\f\n\u0004\bM\u0010B\u001a\u0004\bN\u0010DR$\u0010O\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010U\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010[\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R!\u0010g\u001a\b\u0012\u0004\u0012\u00020b0a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR4\u0010i\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020h\u0012\u0004\u0012\u00020\u001a0\u001e028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u00104\u001a\u0004\bj\u00105\"\u0004\bk\u00107R\"\u0010l\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010'\u001a\u0004\bl\u0010(\"\u0004\bm\u0010*R\u001d\u0010n\u001a\b\u0012\u0004\u0012\u00020%028\u0006¢\u0006\f\n\u0004\bn\u00104\u001a\u0004\bn\u00105R%\u0010o\u001a\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010\u00050\u00050?8\u0006¢\u0006\f\n\u0004\bo\u0010B\u001a\u0004\bp\u0010DR!\u0010t\u001a\b\u0012\u0004\u0012\u00020q0a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\br\u0010d\u001a\u0004\bs\u0010fR\"\u0010u\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010'\u001a\u0004\bu\u0010(\"\u0004\bv\u0010*R\"\u0010w\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010'\u001a\u0004\bx\u0010(\"\u0004\by\u0010*R#\u0010{\u001a\u00020z8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R(\u0010\u0081\u0001\u001a\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010\u00050\u00050?8\u0006¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010B\u001a\u0005\b\u0082\u0001\u0010DR&\u0010\u0083\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0083\u0001\u0010-\u001a\u0005\b\u0084\u0001\u0010/\"\u0005\b\u0085\u0001\u00101R,\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020%028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0086\u0001\u00104\u001a\u0005\b\u0086\u0001\u00105\"\u0005\b\u0087\u0001\u00107R(\u0010\u0088\u0001\u001a\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010%0%0?8\u0006¢\u0006\u000e\n\u0005\b\u0088\u0001\u0010B\u001a\u0005\b\u0089\u0001\u0010DR&\u0010\u008a\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008a\u0001\u0010\\\u001a\u0005\b\u008b\u0001\u0010^\"\u0005\b\u008c\u0001\u0010`R+\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R \u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u00020\f028\u0006¢\u0006\u000e\n\u0005\b\u0093\u0001\u00104\u001a\u0005\b\u0094\u0001\u00105R\u001d\u0010\u0096\u0001\u001a\u00030\u0095\u00018\u0006¢\u0006\u0010\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001d\u0010\u009b\u0001\u001a\u00030\u009a\u00018\u0006¢\u0006\u0010\n\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R'\u0010¤\u0001\u001a\n\u0012\u0005\u0012\u00030 \u00010\u009f\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\b¡\u0001\u0010d\u001a\u0006\b¢\u0001\u0010£\u0001R)\u0010¥\u0001\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¥\u0001\u0010\u008e\u0001\u001a\u0006\b¦\u0001\u0010\u0090\u0001\"\u0006\b§\u0001\u0010\u0092\u0001R3\u0010ª\u0001\u001a\f\u0012\u0005\u0012\u00030©\u0001\u0018\u00010¨\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bª\u0001\u0010«\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001\"\u0006\b®\u0001\u0010¯\u0001¨\u0006´\u0001"}, d2 = {"Lcom/bytedance/android/live/recharge/RechargeDialogContext;", "Lcom/bytedance/live/datacontext/DataContext;", "T", "Ljava/lang/Class;", "clazz", "", "registerRxBus", "Lcom/bytedance/android/livesdk/event/o;", "event", "onEvent", "getCurrentDiamond", "getExchangeInfo", "", "lackMoney", "Lcom/bytedance/android/live/recharge/model/d;", "entranceParams", "getDiamondList", "", "priceList", "", "requestFrom", "Lio/reactivex/Single;", "Lcom/bytedance/android/livesdkapi/depend/model/IQueryPrePayCashierData;", "getPrePayCashierInfoParams", "Lcom/bytedance/android/live/recharge/deal/f;", "deal", "", "getDescription", "initLocalData", "getDiamondBuySignInfo", "", "getReportExtraInfo", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "getCd", "()Lio/reactivex/disposables/CompositeDisposable;", "", "isVertical", "Z", "()Z", "setVertical", "(Z)V", "Lcom/bytedance/android/live/recharge/utils/Fen;", "defaultSelectPrize", "J", "getDefaultSelectPrize", "()J", "setDefaultSelectPrize", "(J)V", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "isPreQueryInfo", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "()Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "setPreQueryInfo", "(Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;)V", "isDiamondDataAvailable", "setDiamondDataAvailable", "Lcom/bytedance/android/live/recharge/a0;", "repository", "Lcom/bytedance/android/live/recharge/a0;", "getRepository", "()Lcom/bytedance/android/live/recharge/a0;", "Lio/reactivex/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "popUpOrHideRechargePageEvent", "Lio/reactivex/subjects/PublishSubject;", "getPopUpOrHideRechargePageEvent", "()Lio/reactivex/subjects/PublishSubject;", "customRechargePageHideEvent", "getCustomRechargePageHideEvent", "dealsSelectedEvent", "getDealsSelectedEvent", "dismissEvent", "getDismissEvent", "updateEvent", "getUpdateEvent", "closeNoticeEvent", "getCloseNoticeEvent", "selectedDeal", "Lcom/bytedance/android/live/recharge/deal/f;", "getSelectedDeal", "()Lcom/bytedance/android/live/recharge/deal/f;", "setSelectedDeal", "(Lcom/bytedance/android/live/recharge/deal/f;)V", "mDialogEntranceParams", "Lcom/bytedance/android/live/recharge/model/d;", "getMDialogEntranceParams", "()Lcom/bytedance/android/live/recharge/model/d;", "setMDialogEntranceParams", "(Lcom/bytedance/android/live/recharge/model/d;)V", "dialogHeight", "I", "getDialogHeight", "()I", "setDialogHeight", "(I)V", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/live/recharge/order/Order;", "order$delegate", "Lcom/bytedance/live/datacontext/p;", "getOrder", "()Lcom/bytedance/live/datacontext/n;", "order", "Lcom/android/ttcjpaysdk/base/service/PayMsg;", "btnContent", "getBtnContent", "setBtnContent", "isComponentLoad", "setComponentLoad", "isBatchQueryLoading", "clickRechargeBtn", "getClickRechargeBtn", "Lex0/a;", "rechargePanelScope$delegate", "getRechargePanelScope", "rechargePanelScope", "isAllowBack", "setAllowBack", "supportNoPassword", "getSupportNoPassword", "setSupportNoPassword", "Lcom/bytedance/android/live/recharge/nopassword/NoPasswordScene;", "noPasswordScene", "Lcom/bytedance/android/live/recharge/nopassword/NoPasswordScene;", "getNoPasswordScene", "()Lcom/bytedance/android/live/recharge/nopassword/NoPasswordScene;", "setNoPasswordScene", "(Lcom/bytedance/android/live/recharge/nopassword/NoPasswordScene;)V", "pkLoadCjComponentFailed", "getPkLoadCjComponentFailed", "pkLeftTime", "getPkLeftTime", "setPkLeftTime", "isAcceptAgreement", "setAcceptAgreement", "closeNoPasswordPayMethodDialog", "getCloseNoPasswordPayMethodDialog", "noPasswordDialogHeight", "getNoPasswordDialogHeight", "setNoPasswordDialogHeight", "twoFactoryAuthVerifyInfo", "Ljava/lang/String;", "getTwoFactoryAuthVerifyInfo", "()Ljava/lang/String;", "setTwoFactoryAuthVerifyInfo", "(Ljava/lang/String;)V", "customPrice", "getCustomPrice", "Lcom/bytedance/android/live/recharge/panel/f;", "dialogContextProxy", "Lcom/bytedance/android/live/recharge/panel/f;", "getDialogContextProxy", "()Lcom/bytedance/android/live/recharge/panel/f;", "Lcom/bytedance/android/live/recharge/panel/h;", "panelPropertiesProvider", "Lcom/bytedance/android/live/recharge/panel/h;", "getPanelPropertiesProvider", "()Lcom/bytedance/android/live/recharge/panel/h;", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/recharge/trace/session/a;", "session$delegate", "getSession", "()Lcom/bytedance/live/datacontext/j;", "session", "promotionId", "getPromotionId", "setPromotionId", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "outerContext", "Ljava/lang/ref/WeakReference;", "getOuterContext", "()Ljava/lang/ref/WeakReference;", "setOuterContext", "(Ljava/lang/ref/WeakReference;)V", "<init>", "()V", "Companion", "a", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeDialogContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private PropertyOwner<Map<PayMsg, String>> btnContent;
    private final CompositeDisposable cd;
    private final PublishSubject<Unit> clickRechargeBtn;
    private final PublishSubject<Boolean> closeNoPasswordPayMethodDialog;
    private final PublishSubject<Unit> closeNoticeEvent;
    private final PropertyOwner<Long> customPrice;
    private final PublishSubject<Unit> customRechargePageHideEvent;
    private final PublishSubject<Unit> dealsSelectedEvent;
    private long defaultSelectPrize;
    private final com.bytedance.android.live.recharge.panel.f dialogContextProxy;
    private int dialogHeight;
    private final PublishSubject<Unit> dismissEvent;
    private PropertyOwner<Boolean> isAcceptAgreement;
    private boolean isAllowBack;
    private final PropertyOwner<Boolean> isBatchQueryLoading;
    private boolean isComponentLoad;
    private boolean isDiamondDataAvailable;
    private PropertyOwner<Boolean> isPreQueryInfo;
    private boolean isVertical;
    private com.bytedance.android.live.recharge.model.d mDialogEntranceParams;
    private int noPasswordDialogHeight;
    private NoPasswordScene noPasswordScene;
    private final com.bytedance.live.datacontext.p order$delegate;
    private WeakReference<Context> outerContext;
    private final com.bytedance.android.live.recharge.panel.h panelPropertiesProvider;
    private long pkLeftTime;
    private final PublishSubject<Unit> pkLoadCjComponentFailed;
    private final PublishSubject<Boolean> popUpOrHideRechargePageEvent;
    private String promotionId;
    private final com.bytedance.live.datacontext.p rechargePanelScope$delegate;
    private final a0 repository;
    private com.bytedance.android.live.recharge.deal.f selectedDeal;
    private final com.bytedance.live.datacontext.p session$delegate;
    private boolean supportNoPassword;
    private String twoFactoryAuthVerifyInfo;
    private final PublishSubject<Unit> updateEvent;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RechargeDialogContext a;

        public b(RechargeDialogContext r1) {
            this.a = r1;
        }

        public final void accept(T r2) {
            if ((r2 instanceof com.bytedance.android.livesdk.event.o) == false) goto L6;
            RechargeDialogContext.access$onEvent(this.a, (com.bytedance.android.livesdk.event.o) r2);
            return;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(RechargeDialogContext.class, "order", "getOrder()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RechargeDialogContext.class, "rechargePanelScope", "getRechargePanelScope()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RechargeDialogContext.class, "session", "getSession()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    public final com.bytedance.live.datacontext.n<Order> getOrder() {
        return (com.bytedance.live.datacontext.n) this.order$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.n<ex0.a> getRechargePanelScope() {
        return (com.bytedance.live.datacontext.n) this.rechargePanelScope$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.j<com.bytedance.android.live.recharge.trace.session.a> getSession() {
        return (com.bytedance.live.datacontext.j) this.session$delegate.a(this, $$delegatedProperties[2]);
    }

    public final void getCurrentDiamond() {
        a0 r0 = this.repository;
        r0.a.add(((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().observeWallet().compose(RxUtil.rxSchedulerHelper()).subscribe(new b0(r0), c0.a));
        ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().sync("recharge_panel");
    }

    public final void getDiamondBuySignInfo() {
        com.bytedance.android.live.recharge.model.d r0 = this.mDialogEntranceParams;
        long r1 = r0.d;
        long r3 = com.bytedance.android.live.recharge.nopassword.d.a.b;
        RechargeBizScene r2 = com.bytedance.android.live.recharge.panel.b.a(r0);
        a0 r5 = this.repository;
        if (r1 >= r3) goto L5;
        r1 = r3;
    L5:
        r5.getClass();
        Intrinsics.checkNotNullParameter(r2, "bizScene");
        RxUtilKt.c(com.bytedance.android.live.recharge.core.f.g(RechargeServices.b()).b0(r1, r2).subscribe(new d0(r5), new e0(r5)), r5.a);
    }

    public final void getExchangeInfo() {
        a0 r0 = this.repository;
        r0.a.add(((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().observeExchangeInfo().compose(RxUtil.rxSchedulerHelper()).subscribe(new k0(r0), l0.a));
        ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().syncExchangeInfo();
    }

    public RechargeDialogContext() {
        CompositeDisposable r0 = new CompositeDisposable();
        this.cd = r0;
        this.isVertical = true;
        Boolean r3 = Boolean.FALSE;
        this.isPreQueryInfo = new PropertyOwner(r3);
        a0 r2 = new a0();
        this.repository = r2;
        this.popUpOrHideRechargePageEvent = PublishSubject.create();
        this.customRechargePageHideEvent = PublishSubject.create();
        this.dealsSelectedEvent = PublishSubject.create();
        this.dismissEvent = PublishSubject.create();
        this.updateEvent = PublishSubject.create();
        this.closeNoticeEvent = PublishSubject.create();
        this.mDialogEntranceParams = com.bytedance.android.live.recharge.model.d.p;
        this.order$delegate = com.bytedance.live.datacontext.q.c(this);
        this.btnContent = new PropertyOwner(MapsKt.emptyMap());
        this.isBatchQueryLoading = new PropertyOwner(r3);
        this.clickRechargeBtn = PublishSubject.create();
        this.rechargePanelScope$delegate = com.bytedance.live.datacontext.q.c(this);
        this.isAllowBack = true;
        this.noPasswordScene = NoPasswordScene.SCENE_UNKNOWN;
        this.pkLoadCjComponentFailed = PublishSubject.create();
        this.pkLeftTime = Long.MAX_VALUE;
        this.isAcceptAgreement = new PropertyOwner(r3);
        this.closeNoPasswordPayMethodDialog = PublishSubject.create();
        this.customPrice = new PropertyOwner(0L, RechargeDialogContext$customPrice$1.INSTANCE);
        this.dialogContextProxy = new com.bytedance.android.live.recharge.panel.f(this);
        this.panelPropertiesProvider = new com.bytedance.android.live.recharge.panel.h(this);
        this.session$delegate = ConstantKt.b(this, RechargeDialogContext$session$2.INSTANCE);
        this.promotionId = "";
        registerRxBus(com.bytedance.android.livesdk.event.o.class);
        r0.add(r2.a);
    }

    public final PropertyOwner<Map<PayMsg, String>> getBtnContent() {
        return this.btnContent;
    }

    public final CompositeDisposable getCd() {
        return this.cd;
    }

    public final PublishSubject<Unit> getClickRechargeBtn() {
        return this.clickRechargeBtn;
    }

    public final PublishSubject<Boolean> getCloseNoPasswordPayMethodDialog() {
        return this.closeNoPasswordPayMethodDialog;
    }

    public final PublishSubject<Unit> getCloseNoticeEvent() {
        return this.closeNoticeEvent;
    }

    public final PropertyOwner<Long> getCustomPrice() {
        return this.customPrice;
    }

    public final PublishSubject<Unit> getCustomRechargePageHideEvent() {
        return this.customRechargePageHideEvent;
    }

    public final PublishSubject<Unit> getDealsSelectedEvent() {
        return this.dealsSelectedEvent;
    }

    public final long getDefaultSelectPrize() {
        return this.defaultSelectPrize;
    }

    public final com.bytedance.android.live.recharge.panel.f getDialogContextProxy() {
        return this.dialogContextProxy;
    }

    public final int getDialogHeight() {
        return this.dialogHeight;
    }

    public final PublishSubject<Unit> getDismissEvent() {
        return this.dismissEvent;
    }

    public final com.bytedance.android.live.recharge.model.d getMDialogEntranceParams() {
        return this.mDialogEntranceParams;
    }

    public final int getNoPasswordDialogHeight() {
        return this.noPasswordDialogHeight;
    }

    public final NoPasswordScene getNoPasswordScene() {
        return this.noPasswordScene;
    }

    public final WeakReference<Context> getOuterContext() {
        return this.outerContext;
    }

    public final com.bytedance.android.live.recharge.panel.h getPanelPropertiesProvider() {
        return this.panelPropertiesProvider;
    }

    public final long getPkLeftTime() {
        return this.pkLeftTime;
    }

    public final PublishSubject<Unit> getPkLoadCjComponentFailed() {
        return this.pkLoadCjComponentFailed;
    }

    public final PublishSubject<Boolean> getPopUpOrHideRechargePageEvent() {
        return this.popUpOrHideRechargePageEvent;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final a0 getRepository() {
        return this.repository;
    }

    public final com.bytedance.android.live.recharge.deal.f getSelectedDeal() {
        return this.selectedDeal;
    }

    public final boolean getSupportNoPassword() {
        return this.supportNoPassword;
    }

    public final String getTwoFactoryAuthVerifyInfo() {
        return this.twoFactoryAuthVerifyInfo;
    }

    public final PublishSubject<Unit> getUpdateEvent() {
        return this.updateEvent;
    }

    public final PropertyOwner<Boolean> isAcceptAgreement() {
        return this.isAcceptAgreement;
    }

    public final boolean isAllowBack() {
        return this.isAllowBack;
    }

    public final PropertyOwner<Boolean> isBatchQueryLoading() {
        return this.isBatchQueryLoading;
    }

    public final boolean isComponentLoad() {
        return this.isComponentLoad;
    }

    public final boolean isDiamondDataAvailable() {
        return this.isDiamondDataAvailable;
    }

    public final PropertyOwner<Boolean> isPreQueryInfo() {
        return this.isPreQueryInfo;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    private final void onEvent(com.bytedance.android.livesdk.event.o r4) {
        if (r4 == null) goto L16;
        JSONObject r5 = r4.a;
        if (r5 == null) goto L17;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        if (TextUtils.equals("exchangeClose", r5.optString("eventName", "")) == true) goto L8;
        return;
    L8:
        if (JSONObjectProtectorUtils.getBoolean(JSONObjectProtectorUtils.getJSONObject(r5, Constants.Keys.DATA), "exchangeSuccess") == false) goto L19;
        ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().sync("exchange");     // Catch: JSONException -> L11
        this.repository.R.onNext(5);     // Catch: JSONException -> L11
        return;
    L19:
        return;
    L17:
        return;
    }

    private final <T> void registerRxBus(Class<T> r2) {
        RxUtilKt.c(xs2.b.a().b(r2).subscribe(new b(this)), this.cd);
    }

    public final String getDescription(com.bytedance.android.live.recharge.deal.f r4) {
        Intrinsics.checkNotNullParameter(r4, "deal");
        com.bytedance.android.live.recharge.platform.business.model.diamond.g r0 = (com.bytedance.android.live.recharge.platform.business.model.diamond.g) ((Map) this.repository.N.a).get(Long.valueOf(r4.g()));
        if (r0 == null) goto L6;
        String r1 = r0.getDiamondDesc();
        if (r1 == null) goto L6;
    L7:
        String r5 = r4.d();
        if (mz.c.b(r1) == true) goto L11;
        return r1;
    L11:
        return r5;
    L6:
        r1 = "";
        goto L7
    }

    public final Map<String, String> getReportExtraInfo(String r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        com.bytedance.android.live.recharge.deal.f r0 = this.selectedDeal;
        Map<String, String> r1 = null;
        if (r0 == null) goto L5;
        Long r2 = Long.valueOf(r0.g());
    L19:
        com.bytedance.android.live.recharge.platform.business.model.diamond.g r3 = (com.bytedance.android.live.recharge.platform.business.model.diamond.g) ((Map) this.repository.N.a).get(r2);
        if (r3 == null) goto L33;
        com.bytedance.android.live.recharge.platform.business.model.diamond.i r10 = r3.getEventMap().get(r9);
        if (r10 == null) goto L31;
        Map<String, String> r12 = r10.getMetrics();
        if (r12 == null) goto L31;
        Map<String, String> r13 = MapsKt.toMutableMap(r12);
        if (r13 == null) goto L31;
        String r4 = r3.getPreCalcInfo();
        if (r4 != null) goto L30;
        r4 = "";
    L30:
        r13.put("recharge_json", r4);
        r1 = r13;
    L31:
        if (r1 == null) goto L33;
        return r1;
    L33:
        return MapsKt.emptyMap();
    L5:
        Iterator r5 = ((Iterable) this.repository.k.a).iterator();
    L7:
        if (r5.hasNext() == false) goto L14;
        Object r6 = r5.next();
        if (((com.bytedance.android.live.recharge.deal.f) r6).b() != ((Number) this.repository.c.a).longValue()) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == false) goto L7;
    L15:
        com.bytedance.android.live.recharge.deal.f r8 = (com.bytedance.android.live.recharge.deal.f) r6;
        if (r8 == null) goto L18;
        r2 = Long.valueOf(r8.g());
        goto L19
    L18:
        r2 = null;
        goto L19
    L11:
        r7 = false;
        goto L12
    L14:
        r6 = null;
        goto L15
    }

    public final void initLocalData(long r19) {
        a0 r2 = this.repository;
        r2.getClass();
        if (com.bytedance.android.live.recharge.utils.j.d().enableCacheWithStrategy() == true) goto L5;
        return;
    L5:
        if (r0.a().isEmpty() == true) goto L97;
        long r3 = System.currentTimeMillis();
        String r0 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId();
        boolean r6 = false;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L34
        Gson r12 = GsonHelper.get();     // Catch: Throwable -> L34
        String r1 = r0.a().get(r0);     // Catch: Throwable -> L34
        if (r1 != null) goto L12;
        r1 = "";
    L12:
        com.bytedance.android.live.recharge.platform.business.model.diamond.h r4 = (com.bytedance.android.live.recharge.platform.business.model.diamond.h) r12.fromJson(r1, com.bytedance.android.live.recharge.platform.business.model.diamond.h.class);     // Catch: Throwable -> L34
        if (r4 != null) goto L15;
    L31:
        int r5 = com.bytedance.android.live.recharge.utils.m.a;     // Catch: Throwable -> L34
        com.bytedance.android.live.recharge.utils.m.i(1, System.currentTimeMillis() - r3);     // Catch: Throwable -> L34
        r4 = null;
    L32:
        Object r7 = Result.constructor-impl(r4);     // Catch: Throwable -> L34
    L37:
        if (Result.exceptionOrNull-impl(r7) == null) goto L40;
        int r13 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.i(1, System.currentTimeMillis() - r3);
    L40:
        if (Result.isFailure-impl(r7) == false) goto L42;
        r7 = null;
    L42:
        com.bytedance.android.live.recharge.platform.business.model.diamond.h r8 = (com.bytedance.android.live.recharge.platform.business.model.diamond.h) r7;
        if (r8 == null) goto L89;
        r2.R.onNext(2);
        if (r19 <= 0) goto L82;
        List<IChargeDeal> r9 = r8.a();
        long r14 = 100;
        if (r19 > 100) goto L50;
    L56:
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r9.iterator();
    L58:
        if (r16.hasNext() == false) goto L66;
        Object r17 = r16.next();
        if (((IChargeDeal) r17).getPrice() != r14) goto L62;
        boolean r18 = true;
    L63:
        if (r18 == false) goto L58;
    L67:
        IChargeDeal r20 = (IChargeDeal) r17;
        if (r20 == null) goto L70;
        r15.add(com.bytedance.android.live.recharge.platform.model.b.a(r20.getId(), r20.getPrice(), false));
        r9.remove(r20);
    L71:
        r15.addAll(r9);
        r8.d(r15);
        IPrePayCashierInfo r22 = r8.b().e();
        if (r22 == null) goto L82;
        if (r22.getOneStepPay() != 1) goto L76;
        boolean r23 = true;
    L77:
        if (r23 == false) goto L79;
        IPrePayCashierInfo r24 = r22;
    L80:
        if (r24 == null) goto L82;
        Long r25 = Long.valueOf(r14);
        IDiamondRenderDataInfo r26 = vh7.f.c(IDiamondRenderDataInfo.class);
        r26.setRenderData(com.bytedance.android.live.recharge.utils.j.d().getRenderData());
        Unit r27 = Unit.INSTANCE;
        r24.setRenderDataMap(MapsKt.mapOf(TuplesKt.to(r25, r26)));
        goto L82
    L79:
        r24 = null;
        goto L80
    L76:
        r23 = false;
        goto L77
    L70:
        r15.add(com.bytedance.android.live.recharge.platform.model.b.a(666666, (int) r14, true));
        IChargeDeal r28 = (IChargeDeal) ListProtector.remove(r9, r9.size() - 1);
        goto L71
    L62:
        r18 = false;
        goto L63
    L66:
        r17 = null;
        goto L67
    L50:
        if (101 > r19) goto L55;
        r14 = 600;
        if (600 >= r19) goto L56;
    L55:
        long r29 = 100;
        r14 = (((r19 - 1) / r29) + 1) * r29;
    L82:
        if (r19 <= 0) goto L84;
        r6 = true;
    L84:
        Intrinsics.checkNotNullParameter(r8, "$this$createDealSet");
        int r30 = com.bytedance.android.live.recharge.deal.k.a;
        List<IChargeDeal> r32 = r8.a();
        com.bytedance.android.live.recharge.model.diamond.a r33 = r8.b();
        Intrinsics.checkNotNullParameter(r32, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r33, "extra");
        com.bytedance.android.live.recharge.deal.i r34 = new com.bytedance.android.live.recharge.deal.t(r32, r33);
        if (r6 == false) goto L88;
        r34 = com.bytedance.android.live.recharge.deal.k.a(r34, null, 666666L, 666666L, null, null, 102);
    L88:
        r2.e(r34, true);
        r2.E.onNext(r34);
        r2.S = true;
        return;
    L89:
        r2.R.onNext(1);
        return;
    L15:
        if ((!r4.a().isEmpty()) == false) goto L25;
        long r110 = com.bytedance.android.live.revenue.common.s0.b(new u0(r4.c()));     // Catch: Throwable -> L34
        String r111 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId();     // Catch: Throwable -> L34
        if (r110 >= 0) goto L19;
    L22:
        r0.a().put(r111, "");     // Catch: Throwable -> L34
        boolean r112 = false;
    L23:
        if (r112 == false) goto L25;
        boolean r113 = true;
    L26:
        if (r113 == true) goto L29;
        r4 = null;
    L29:
        if (r4 == null) goto L31;
        int r114 = com.bytedance.android.live.recharge.utils.m.a;     // Catch: Throwable -> L34
        com.bytedance.android.live.recharge.utils.m.i(0, System.currentTimeMillis() - r3);     // Catch: Throwable -> L34
        goto L32
    L19:
        if (r110 > com.bytedance.android.live.recharge.utils.j.d().getDiamondCacheGapDay()) goto L22;
        r112 = true;
    L25:
        r113 = false;
    L34:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L37
    }

    public final void setAcceptAgreement(PropertyOwner<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.isAcceptAgreement = r2;
    }

    public final void setAllowBack(boolean r1) {
        this.isAllowBack = r1;
    }

    public final void setBtnContent(PropertyOwner<Map<PayMsg, String>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.btnContent = r2;
    }

    public final void setComponentLoad(boolean r1) {
        this.isComponentLoad = r1;
    }

    public final void setDefaultSelectPrize(long r1) {
        this.defaultSelectPrize = r1;
    }

    public final void setDialogHeight(int r1) {
        this.dialogHeight = r1;
    }

    public final void setDiamondDataAvailable(boolean r1) {
        this.isDiamondDataAvailable = r1;
    }

    public final void setMDialogEntranceParams(com.bytedance.android.live.recharge.model.d r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mDialogEntranceParams = r2;
    }

    public final void setNoPasswordDialogHeight(int r1) {
        this.noPasswordDialogHeight = r1;
    }

    public final void setNoPasswordScene(NoPasswordScene r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.noPasswordScene = r2;
    }

    public final void setOuterContext(WeakReference<Context> r1) {
        this.outerContext = r1;
    }

    public final void setPkLeftTime(long r1) {
        this.pkLeftTime = r1;
    }

    public final void setPreQueryInfo(PropertyOwner<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.isPreQueryInfo = r2;
    }

    public final void setPromotionId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.promotionId = r2;
    }

    public final void setSelectedDeal(com.bytedance.android.live.recharge.deal.f r1) {
        this.selectedDeal = r1;
    }

    public final void setSupportNoPassword(boolean r1) {
        this.supportNoPassword = r1;
    }

    public final void setTwoFactoryAuthVerifyInfo(String r1) {
        this.twoFactoryAuthVerifyInfo = r1;
    }

    public final void setVertical(boolean r1) {
        this.isVertical = r1;
    }

    public static final /* synthetic */ void access$onEvent(RechargeDialogContext r0, com.bytedance.android.livesdk.event.o r1) {
        r0.onEvent(r1);
    }

    public final void getDiamondList(long r8, com.bytedance.android.live.recharge.model.d r10) {
        Intrinsics.checkNotNullParameter(r10, "entranceParams");
        a0 r1 = this.repository;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "entranceParams");
        r1.R.onNext(1);
        long r2 = System.currentTimeMillis();
        com.bytedance.android.live.recharge.platform.service.h r0 = com.bytedance.android.live.recharge.core.f.d(RechargeServices.b());
        com.bytedance.android.live.recharge.deal.m r4 = new com.bytedance.android.live.recharge.deal.m(r8, Entrance.Recharge, FetchFrom.RechargePanel);
        cw0.a.a(r4, r10);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "requestParams");
        RxUtilKt.c(DealSetApiDataSource.d(r4).map(new com.bytedance.android.live.recharge.platform.service.d(r0, r4)).map(com.bytedance.android.live.recharge.platform.service.e.a).subscribe(new h0(r1, r2, r10), new i0(r1, r2)), r1.a);
        if (com.bytedance.android.live.recharge.utils.j.d().enableCacheWithStrategy() == true) goto L5;
        return;
    L5:
        if (com.bytedance.android.live.recharge.utils.j.d().getDiamondWeakNetworkOptDelay() <= 0) goto L15;
        Observable r9 = Observable.timer(com.bytedance.android.live.recharge.utils.j.d().getDiamondWeakNetworkOptDelay(), TimeUnit.MILLISECONDS);
        if (r9 == null) goto L16;
        Observable r12 = RxUtilKt.h(r9);
        if (r12 == null) goto L17;
        Disposable r13 = r12.subscribe(new j0(r1));
        if (r13 == null) goto L18;
        RxUtilKt.c(r13, r1.a);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public final Single<IQueryPrePayCashierData> getPrePayCashierInfoParams(List<Long> r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "priceList");
        a0 r1 = this.repository;
        com.bytedance.android.live.recharge.deal.f r0 = this.selectedDeal;
        if (r0 == null) goto L5;
        long r2 = r0.g();
    L7:
        return r1.c(r2, r8, this.mDialogEntranceParams, r9);
    L5:
        r2 = 0;
        goto L7
    }
}
