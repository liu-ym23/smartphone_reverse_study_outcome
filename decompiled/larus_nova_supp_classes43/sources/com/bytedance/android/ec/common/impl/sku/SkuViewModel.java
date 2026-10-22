package com.bytedance.android.ec.common.impl.sku;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.common.impl.sku.log.SkuLog;
import com.bytedance.android.ec.common.impl.sku.model.ClothesSizeAssistantStruct;
import com.bytedance.android.ec.common.impl.sku.model.SkuDiscountInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuInstallmentItemInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuLimit;
import com.bytedance.android.ec.common.impl.sku.model.SkuTermInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuTermInfoItem;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfo;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfoItem;
import com.bytedance.android.ec.common.impl.sku.monitor.SkuApiMonitor;
import com.bytedance.android.ec.common.impl.sku.repository.SkuRepository;
import com.bytedance.android.ec.common.impl.sku.repository.dto.APIAction;
import com.bytedance.android.ec.common.impl.sku.repository.dto.AddCartResponse;
import com.bytedance.android.ec.common.impl.sku.repository.dto.CommonSkusUpdateRequest;
import com.bytedance.android.ec.common.impl.sku.repository.dto.CommonSkusUpdateResponse;
import com.bytedance.android.ec.common.impl.sku.repository.dto.PromotionAutoApplyCouponResponse;
import com.bytedance.android.ec.common.impl.sku.repository.dto.SkuAddCartGuideInfo;
import com.bytedance.android.ec.common.impl.sku.repository.dto.SkuAppointmentResponse;
import com.bytedance.android.ec.common.impl.sku.repository.dto.SkuCheckPayNotificationResponse;
import com.bytedance.android.ec.common.impl.sku.repository.dto.SkuInfoResponseDTO;
import com.bytedance.android.ec.common.impl.sku.repository.dto.SkuInstallmentItemResponse;
import com.bytedance.android.ec.common.impl.sku.repository.dto.UpdateActionOption;
import com.bytedance.android.ec.common.impl.sku.repository.dto.UpdateSkuVO;
import com.bytedance.android.ec.common.impl.sku.view.SpecItemGroupLayout;
import com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeGroupLayout;
import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.ec.core.data.LoadingStatus;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.listener.ActionRateListener;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.w0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.api.LogPbData;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.ec.model.sku.ButtonTipComponent;
import com.bytedance.android.ec.model.sku.CarAdaptComponent;
import com.bytedance.android.ec.model.sku.CartNumWithBusinessLine;
import com.bytedance.android.ec.model.sku.DefaultSelect;
import com.bytedance.android.ec.model.sku.SkuBottomButtons;
import com.bytedance.android.ec.model.sku.SkuCartResult;
import com.bytedance.android.ec.model.sku.SkuCheckResult;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ec.model.sku.TradeModeComponent;
import com.bytedance.android.ec.model.sku.TradeModeSelection;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.shopping.api.address.IAddressService;
import com.bytedance.android.shopping.data.api.ChainPoint;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u009a\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u007f\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b¢\u0004\u0010£\u0004J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J.\u0010\u000e\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u001a\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J(\u0010\u0018\u001a\u00020\u00062\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\fH\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\fH\u0002J\u0014\u0010 \u001a\u00020\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u0014\u0010%\u001a\u0004\u0018\u00010\f2\b\b\u0001\u0010$\u001a\u00020#H\u0002J\u0012\u0010'\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010\fH\u0002J\u0014\u0010*\u001a\u0004\u0018\u00010)2\b\u0010(\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010,\u001a\u00020+H\u0002J7\u00101\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\f2\b\u0010/\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00100\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b1\u00102J\b\u00103\u001a\u00020\u0006H\u0002J\u0014\u00106\u001a\u0004\u0018\u0001052\b\u00104\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010:\u001a\u00020\u00062\u0006\u00107\u001a\u00020+2\b\u00108\u001a\u0004\u0018\u00010\u00022\u0006\u00109\u001a\u000205H\u0002J\b\u0010;\u001a\u0004\u0018\u00010\fJ\u0006\u0010<\u001a\u00020!J\u0006\u0010=\u001a\u00020!J\u0006\u0010>\u001a\u00020!J\u0006\u0010?\u001a\u00020!J\u0006\u0010@\u001a\u00020!J\u0006\u0010A\u001a\u00020\u0006J°\u0001\u0010P\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010C\u001a\u0004\u0018\u00010B2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0010\u0010E\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010D2\u001a\u0010G\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u0006\u0018\u00010F2\u0016\u0010I\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010H2\u0016\u0010K\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010J\u0012\u0004\u0012\u00020\u0006\u0018\u00010H2\u0016\b\u0002\u0010M\u001a\u0010\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u0006\u0018\u00010H2\u0016\b\u0002\u0010O\u001a\u0010\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020\u0006\u0018\u00010HJu\u0010Y\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\f2.\u0010T\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0S0R\"\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0S2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010V2\u0016\b\u0002\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\bY\u0010ZJ\u0016\u0010]\u001a\u00020\u00062\u0006\u0010[\u001a\u00020\f2\u0006\u0010\\\u001a\u00020\fJ\u007f\u0010d\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\f2\b\u0010^\u001a\u0004\u0018\u00010\f2\b\u0010_\u001a\u0004\u0018\u00010\f2\u0006\u0010`\u001a\u00020\f2\b\u0010a\u001a\u0004\u0018\u00010\f2\b\u0010b\u001a\u0004\u0018\u00010\f2\b\u0010c\u001a\u0004\u0018\u00010\f2.\u0010T\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0S0R\"\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0S¢\u0006\u0004\bd\u0010eJ\u0006\u0010f\u001a\u00020\u0006J\u0006\u0010g\u001a\u00020\u0006J\u0006\u0010h\u001a\u00020\u0006JX\u0010r\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\f2\u0006\u0010j\u001a\u00020\f2\u0006\u0010k\u001a\u00020\f2\u0006\u0010l\u001a\u00020\f2\u0006\u0010m\u001a\u00020\f2\u0006\u0010n\u001a\u00020\f2\u0006\u0010-\u001a\u00020\f2\u0006\u0010o\u001a\u00020\f2\u0006\u0010p\u001a\u00020#2\b\u0010q\u001a\u0004\u0018\u00010\fJ8\u0010s\u001a\u00020\u00062\u0006\u0010k\u001a\u00020\f2\u0006\u0010l\u001a\u00020\f2\u0006\u0010-\u001a\u00020\f2\u0006\u0010o\u001a\u00020\f2\u0006\u0010p\u001a\u00020#2\b\u0010q\u001a\u0004\u0018\u00010\fJB\u0010{\u001a\u00020\u00062\u0006\u0010u\u001a\u00020t2\b\u0010w\u001a\u0004\u0018\u00010v2\u0006\u0010x\u001a\u00020\f2\b\b\u0002\u0010y\u001a\u00020\f2\u0016\b\u0002\u0010z\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010HJ\u001a\u0010~\u001a\u00020\u00062\u0006\u0010|\u001a\u00020!2\n\b\u0002\u0010}\u001a\u0004\u0018\u00010\fJ\u0011\u0010\u0080\u0001\u001a\u00020\u00062\b\b\u0002\u0010\u007f\u001a\u00020!J\u0011\u0010\u0083\u0001\u001a\u00020\u00062\b\u0010\u0082\u0001\u001a\u00030\u0081\u0001J\u0007\u0010\u0084\u0001\u001a\u00020\u0006J\u001d\u0010\u0086\u0001\u001a\u00020\u00062\u000b\b\u0002\u0010\u0085\u0001\u001a\u0004\u0018\u00010#¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u001a\u0010\u0089\u0001\u001a\u00020\u00062\u0011\b\u0002\u0010\u0088\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010DJ\u0007\u0010\u008a\u0001\u001a\u00020\u0006J\u0007\u0010\u008b\u0001\u001a\u00020+J\u0007\u0010\u008c\u0001\u001a\u00020+J\u0007\u0010\u008d\u0001\u001a\u00020+J\u0007\u0010\u008e\u0001\u001a\u00020+J\u0007\u0010\u008f\u0001\u001a\u00020!J\b\u0010\u0091\u0001\u001a\u00030\u0090\u0001J\u0007\u0010\u0092\u0001\u001a\u00020\fJ\u0010\u0010\u0094\u0001\u001a\u00020!2\u0007\u0010\u0093\u0001\u001a\u00020#J\u0011\u0010\u0097\u0001\u001a\u00020\u00062\b\u0010\u0096\u0001\u001a\u00030\u0095\u0001J\u0007\u0010\u0098\u0001\u001a\u00020\u0006J\u0007\u0010\u0099\u0001\u001a\u00020\u0006J\u0011\u0010\u009c\u0001\u001a\u00020\u00062\b\u0010\u009b\u0001\u001a\u00030\u009a\u0001J\u001f\u0010\u009f\u0001\u001a\u00020\u00062\u0016\u0010\u009e\u0001\u001a\u0011\u0012\u0007\u0012\u0005\u0018\u00010\u009d\u0001\u0012\u0004\u0012\u00020\u00060HJ\t\u0010 \u0001\u001a\u00020\u0006H\u0014R \u0010\u0005\u001a\t\u0012\u0004\u0012\u00020\u00040¡\u00018\u0006¢\u0006\u000e\n\u0005\b\u0005\u0010¢\u0001\u001a\u0005\bf\u0010£\u0001R'\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0011\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R)\u0010C\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bC\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001R)\u0010®\u0001\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b®\u0001\u0010¯\u0001\u001a\u0006\b°\u0001\u0010±\u0001\"\u0006\b²\u0001\u0010³\u0001R#\u0010´\u0001\u001a\t\u0012\u0004\u0012\u00020\f0¡\u00018\u0006¢\u0006\u0010\n\u0006\b´\u0001\u0010¢\u0001\u001a\u0006\bµ\u0001\u0010£\u0001R#\u0010¶\u0001\u001a\t\u0012\u0004\u0012\u00020+0¡\u00018\u0006¢\u0006\u0010\n\u0006\b¶\u0001\u0010¢\u0001\u001a\u0006\b·\u0001\u0010£\u0001R#\u0010¸\u0001\u001a\t\u0012\u0004\u0012\u00020+0¡\u00018\u0006¢\u0006\u0010\n\u0006\b¸\u0001\u0010¢\u0001\u001a\u0006\b\u008e\u0001\u0010£\u0001R#\u0010¹\u0001\u001a\t\u0012\u0004\u0012\u00020!0¡\u00018\u0006¢\u0006\u0010\n\u0006\b¹\u0001\u0010¢\u0001\u001a\u0006\bº\u0001\u0010£\u0001R#\u0010»\u0001\u001a\t\u0012\u0004\u0012\u00020#0¡\u00018\u0006¢\u0006\u0010\n\u0006\b»\u0001\u0010¢\u0001\u001a\u0006\b¼\u0001\u0010£\u0001R)\u0010½\u0001\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b½\u0001\u0010¾\u0001\u001a\u0006\b¿\u0001\u0010À\u0001\"\u0006\bÁ\u0001\u0010Â\u0001R)\u0010Ã\u0001\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÃ\u0001\u0010¾\u0001\u001a\u0006\bÄ\u0001\u0010À\u0001\"\u0006\bÅ\u0001\u0010Â\u0001R)\u0010Æ\u0001\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÆ\u0001\u0010¾\u0001\u001a\u0006\bÇ\u0001\u0010À\u0001\"\u0006\bÈ\u0001\u0010Â\u0001R+\u0010É\u0001\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001\"\u0006\bÍ\u0001\u0010Î\u0001R+\u0010Ï\u0001\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÏ\u0001\u0010Ê\u0001\u001a\u0006\bÐ\u0001\u0010Ì\u0001\"\u0006\bÑ\u0001\u0010Î\u0001R+\u0010Ò\u0001\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÒ\u0001\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001\"\u0006\bÖ\u0001\u0010\u0087\u0001R+\u0010×\u0001\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b×\u0001\u0010Ê\u0001\u001a\u0006\bØ\u0001\u0010Ì\u0001\"\u0006\bÙ\u0001\u0010Î\u0001R#\u0010Ú\u0001\u001a\t\u0012\u0004\u0012\u00020+0¡\u00018\u0006¢\u0006\u0010\n\u0006\bÚ\u0001\u0010¢\u0001\u001a\u0006\b\u008d\u0001\u0010£\u0001R$\u0010Ü\u0001\u001a\n\u0012\u0005\u0012\u00030Û\u00010¡\u00018\u0006¢\u0006\u0010\n\u0006\bÜ\u0001\u0010¢\u0001\u001a\u0006\b\u008b\u0001\u0010£\u0001R$\u0010Ý\u0001\u001a\n\u0012\u0005\u0012\u00030Û\u00010¡\u00018\u0006¢\u0006\u0010\n\u0006\bÝ\u0001\u0010¢\u0001\u001a\u0006\b\u008c\u0001\u0010£\u0001R#\u0010Þ\u0001\u001a\t\u0012\u0004\u0012\u00020\f0¡\u00018\u0006¢\u0006\u0010\n\u0006\bÞ\u0001\u0010¢\u0001\u001a\u0006\bß\u0001\u0010£\u0001R#\u0010à\u0001\u001a\t\u0012\u0004\u0012\u00020\f0¡\u00018\u0006¢\u0006\u0010\n\u0006\bà\u0001\u0010¢\u0001\u001a\u0006\bá\u0001\u0010£\u0001R,\u0010ã\u0001\u001a\u0012\u0012\r\u0012\u000b\u0012\u0005\u0012\u00030â\u0001\u0018\u00010\b0¡\u00018\u0006¢\u0006\u0010\n\u0006\bã\u0001\u0010¢\u0001\u001a\u0006\bä\u0001\u0010£\u0001R&\u0010æ\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010å\u00010¡\u00018\u0006¢\u0006\u0010\n\u0006\bæ\u0001\u0010¢\u0001\u001a\u0006\bç\u0001\u0010£\u0001R#\u0010è\u0001\u001a\t\u0012\u0004\u0012\u00020#0¡\u00018\u0006¢\u0006\u0010\n\u0006\bè\u0001\u0010¢\u0001\u001a\u0006\bé\u0001\u0010£\u0001R)\u0010k\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bk\u0010Ê\u0001\u001a\u0006\bê\u0001\u0010Ì\u0001\"\u0006\bë\u0001\u0010Î\u0001R4\u0010í\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010ì\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bí\u0001\u0010î\u0001\u001a\u0006\bï\u0001\u0010ð\u0001\"\u0006\bñ\u0001\u0010ò\u0001R+\u0010ó\u0001\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bó\u0001\u0010Ê\u0001\u001a\u0006\bô\u0001\u0010Ì\u0001\"\u0006\bõ\u0001\u0010Î\u0001R)\u0010ö\u0001\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bö\u0001\u0010÷\u0001\u001a\u0006\bø\u0001\u0010ù\u0001\"\u0006\bú\u0001\u0010û\u0001R+\u0010ü\u0001\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bü\u0001\u0010ý\u0001\u001a\u0006\bþ\u0001\u0010ÿ\u0001\"\u0006\b\u0080\u0002\u0010\u0081\u0002R%\u0010\u0082\u0002\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0¡\u00018\u0006¢\u0006\u0010\n\u0006\b\u0082\u0002\u0010¢\u0001\u001a\u0006\b\u0083\u0002\u0010£\u0001R2\u0010\u0084\u0002\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0¡\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0084\u0002\u0010¢\u0001\u001a\u0006\b\u0085\u0002\u0010£\u0001\"\u0006\b\u0086\u0002\u0010\u0087\u0002R4\u0010\u0088\u0002\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010ì\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0088\u0002\u0010î\u0001\u001a\u0006\b\u0089\u0002\u0010ð\u0001\"\u0006\b\u008a\u0002\u0010ò\u0001R4\u0010\u008b\u0002\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010ì\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008b\u0002\u0010î\u0001\u001a\u0006\b\u008c\u0002\u0010ð\u0001\"\u0006\b\u008d\u0002\u0010ò\u0001R4\u0010\u008e\u0002\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010ì\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008e\u0002\u0010î\u0001\u001a\u0006\b\u008f\u0002\u0010ð\u0001\"\u0006\b\u0090\u0002\u0010ò\u0001R+\u0010\u0091\u0002\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0091\u0002\u0010ý\u0001\u001a\u0006\b\u0092\u0002\u0010ÿ\u0001\"\u0006\b\u0093\u0002\u0010\u0081\u0002R+\u0010\u0094\u0002\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0094\u0002\u0010Ê\u0001\u001a\u0006\b\u0095\u0002\u0010Ì\u0001\"\u0006\b\u0096\u0002\u0010Î\u0001R2\u0010\u0086\u0001\u001a\u0018\u0012\u0013\u0012\u0011\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010D0\u0097\u00020¡\u00018\u0006¢\u0006\u0010\n\u0006\b\u0086\u0001\u0010¢\u0001\u001a\u0006\b\u0098\u0002\u0010£\u0001R2\u0010\u0089\u0001\u001a\u0018\u0012\u0013\u0012\u0011\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010D0\u0097\u00020¡\u00018\u0006¢\u0006\u0010\n\u0006\b\u0089\u0001\u0010¢\u0001\u001a\u0006\b\u0099\u0002\u0010£\u0001R*\u0010\u009a\u0002\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00060\u0097\u00020¡\u00018\u0006¢\u0006\u0010\n\u0006\b\u009a\u0002\u0010¢\u0001\u001a\u0006\b\u009b\u0002\u0010£\u0001R#\u0010\u009c\u0002\u001a\t\u0012\u0004\u0012\u00020!0¡\u00018\u0006¢\u0006\u0010\n\u0006\b\u009c\u0002\u0010¢\u0001\u001a\u0006\b\u009d\u0002\u0010£\u0001R0\u0010\u009e\u0002\u001a\t\u0012\u0004\u0012\u00020#0ì\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009e\u0002\u0010î\u0001\u001a\u0006\b\u009f\u0002\u0010ð\u0001\"\u0006\b \u0002\u0010ò\u0001R)\u0010¡\u0002\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¡\u0002\u0010¯\u0001\u001a\u0006\b¢\u0002\u0010±\u0001\"\u0006\b£\u0002\u0010³\u0001R)\u0010¤\u0002\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¤\u0002\u0010Ê\u0001\u001a\u0006\b¥\u0002\u0010Ì\u0001\"\u0006\b¦\u0002\u0010Î\u0001R0\u0010§\u0002\u001a\t\u0012\u0004\u0012\u00020\f0ì\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b§\u0002\u0010î\u0001\u001a\u0006\b¨\u0002\u0010ð\u0001\"\u0006\b©\u0002\u0010ò\u0001R+\u0010ª\u0002\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bª\u0002\u0010Ê\u0001\u001a\u0006\b«\u0002\u0010Ì\u0001\"\u0006\b¬\u0002\u0010Î\u0001R&\u0010®\u0002\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u00ad\u00020¡\u00018\u0006¢\u0006\u0010\n\u0006\b®\u0002\u0010¢\u0001\u001a\u0006\b¯\u0002\u0010£\u0001R$\u0010±\u0002\u001a\n\u0012\u0005\u0012\u00030°\u00020¡\u00018\u0006¢\u0006\u0010\n\u0006\b±\u0002\u0010¢\u0001\u001a\u0006\b²\u0002\u0010£\u0001R,\u0010µ\u0002\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0005\u0012\u00030\u00ad\u00020´\u00020³\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bµ\u0002\u0010¶\u0002R)\u0010·\u0002\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b·\u0002\u0010÷\u0001\u001a\u0006\b¸\u0002\u0010ù\u0001\"\u0006\b¹\u0002\u0010û\u0001R0\u0010º\u0002\u001a\t\u0012\u0004\u0012\u00020#0¡\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bº\u0002\u0010¢\u0001\u001a\u0006\b»\u0002\u0010£\u0001\"\u0006\b¼\u0002\u0010\u0087\u0002R$\u0010¾\u0002\u001a\n\u0012\u0005\u0012\u00030½\u00020¡\u00018\u0006¢\u0006\u0010\n\u0006\b¾\u0002\u0010¢\u0001\u001a\u0006\b¿\u0002\u0010£\u0001R&\u0010À\u0002\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u009d\u00010¡\u00018\u0006¢\u0006\u0010\n\u0006\bÀ\u0002\u0010¢\u0001\u001a\u0006\bÁ\u0002\u0010£\u0001R)\u0010Â\u0002\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÂ\u0002\u0010÷\u0001\u001a\u0006\bÃ\u0002\u0010ù\u0001\"\u0006\bÄ\u0002\u0010û\u0001R(\u0010'\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\f0\u0097\u00020¡\u00018\u0006¢\u0006\u000f\n\u0005\b'\u0010¢\u0001\u001a\u0006\bÅ\u0002\u0010£\u0001R$\u0010Ç\u0002\u001a\n\u0012\u0005\u0012\u00030Æ\u00020¡\u00018\u0006¢\u0006\u0010\n\u0006\bÇ\u0002\u0010¢\u0001\u001a\u0006\bÈ\u0002\u0010£\u0001R?\u0010Ê\u0002\u001a%\u0012 \u0012\u001e\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010v\u0012\u0004\u0012\u00020\f0É\u00020\u0097\u00020¡\u00018\u0006¢\u0006\u0010\n\u0006\bÊ\u0002\u0010¢\u0001\u001a\u0006\bË\u0002\u0010£\u0001R+\u0010Ì\u0002\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÌ\u0002\u0010Ê\u0001\u001a\u0006\bÍ\u0002\u0010Ì\u0001\"\u0006\bÎ\u0002\u0010Î\u0001R*\u0010Ï\u0002\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020!0\u0097\u00020¡\u00018\u0006¢\u0006\u0010\n\u0006\bÏ\u0002\u0010¢\u0001\u001a\u0006\bÐ\u0002\u0010£\u0001R,\u0010Ò\u0002\u001a\u0005\u0018\u00010Ñ\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÒ\u0002\u0010Ó\u0002\u001a\u0006\bÔ\u0002\u0010Õ\u0002\"\u0006\bÖ\u0002\u0010×\u0002R1\u0010Ù\u0002\u001a\n\u0012\u0005\u0012\u00030Ø\u00020¡\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÙ\u0002\u0010¢\u0001\u001a\u0006\bÚ\u0002\u0010£\u0001\"\u0006\bÛ\u0002\u0010\u0087\u0002R)\u0010Ü\u0002\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÜ\u0002\u0010Ê\u0001\u001a\u0006\bÝ\u0002\u0010Ì\u0001\"\u0006\bÞ\u0002\u0010Î\u0001R+\u0010G\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u0006\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bG\u0010ß\u0002R7\u0010I\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010H8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bI\u0010à\u0002\u001a\u0006\bá\u0002\u0010â\u0002\"\u0006\bã\u0002\u0010ä\u0002R5\u0010M\u001a\u0010\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u0006\u0018\u00010H8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bM\u0010à\u0002\u001a\u0006\bå\u0002\u0010â\u0002\"\u0006\bæ\u0002\u0010ä\u0002R1\u0010E\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010D8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bE\u0010ç\u0002\u001a\u0006\bè\u0002\u0010é\u0002\"\u0006\bê\u0002\u0010ë\u0002R7\u0010K\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010J\u0012\u0004\u0012\u00020\u0006\u0018\u00010H8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bK\u0010à\u0002\u001a\u0006\bì\u0002\u0010â\u0002\"\u0006\bí\u0002\u0010ä\u0002R)\u0010î\u0002\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bî\u0002\u0010¯\u0001\u001a\u0006\bï\u0002\u0010±\u0001\"\u0006\bð\u0002\u0010³\u0001R+\u0010ñ\u0002\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bñ\u0002\u0010ò\u0002\u001a\u0006\bó\u0002\u0010ô\u0002\"\u0006\bõ\u0002\u0010ö\u0002R+\u0010÷\u0002\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b÷\u0002\u0010Ê\u0001\u001a\u0006\bø\u0002\u0010Ì\u0001\"\u0006\bù\u0002\u0010Î\u0001R+\u0010ú\u0002\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bú\u0002\u0010Ê\u0001\u001a\u0006\bû\u0002\u0010Ì\u0001\"\u0006\bü\u0002\u0010Î\u0001R+\u0010ý\u0002\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bý\u0002\u0010ý\u0001\u001a\u0006\bþ\u0002\u0010ÿ\u0001\"\u0006\bÿ\u0002\u0010\u0081\u0002R+\u0010\u0080\u0003\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0080\u0003\u0010ò\u0002\u001a\u0006\b\u0081\u0003\u0010ô\u0002\"\u0006\b\u0082\u0003\u0010ö\u0002R+\u0010\u0083\u0003\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0083\u0003\u0010Ê\u0001\u001a\u0006\b\u0084\u0003\u0010Ì\u0001\"\u0006\b\u0085\u0003\u0010Î\u0001R+\u0010\u0086\u0003\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0086\u0003\u0010Ê\u0001\u001a\u0006\b\u0087\u0003\u0010Ì\u0001\"\u0006\b\u0088\u0003\u0010Î\u0001R+\u0010\u0089\u0003\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0089\u0003\u0010ý\u0001\u001a\u0006\b\u008a\u0003\u0010ÿ\u0001\"\u0006\b\u008b\u0003\u0010\u0081\u0002R+\u0010\u008c\u0003\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008c\u0003\u0010ý\u0001\u001a\u0006\b\u008d\u0003\u0010ÿ\u0001\"\u0006\b\u008e\u0003\u0010\u0081\u0002R+\u0010\u008f\u0003\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008f\u0003\u0010ò\u0002\u001a\u0006\b\u0090\u0003\u0010ô\u0002\"\u0006\b\u0091\u0003\u0010ö\u0002R+\u0010\u0092\u0003\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0092\u0003\u0010Ê\u0001\u001a\u0006\b\u0093\u0003\u0010Ì\u0001\"\u0006\b\u0094\u0003\u0010Î\u0001R+\u0010\u0095\u0003\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0095\u0003\u0010Ê\u0001\u001a\u0006\b\u0096\u0003\u0010Ì\u0001\"\u0006\b\u0097\u0003\u0010Î\u0001R+\u0010\u0098\u0003\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0098\u0003\u0010ý\u0001\u001a\u0006\b\u0099\u0003\u0010ÿ\u0001\"\u0006\b\u009a\u0003\u0010\u0081\u0002R+\u0010\u009b\u0003\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009b\u0003\u0010ò\u0002\u001a\u0006\b\u009c\u0003\u0010ô\u0002\"\u0006\b\u009d\u0003\u0010ö\u0002R+\u0010\u009e\u0003\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009e\u0003\u0010ò\u0002\u001a\u0006\b\u009f\u0003\u0010ô\u0002\"\u0006\b \u0003\u0010ö\u0002R+\u0010¡\u0003\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¡\u0003\u0010Ê\u0001\u001a\u0006\b¢\u0003\u0010Ì\u0001\"\u0006\b£\u0003\u0010Î\u0001R+\u0010¤\u0003\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¤\u0003\u0010Ê\u0001\u001a\u0006\b¥\u0003\u0010Ì\u0001\"\u0006\b¦\u0003\u0010Î\u0001R+\u0010§\u0003\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b§\u0003\u0010ò\u0002\u001a\u0006\b¨\u0003\u0010ô\u0002\"\u0006\b©\u0003\u0010ö\u0002R+\u0010ª\u0003\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bª\u0003\u0010Ê\u0001\u001a\u0006\b«\u0003\u0010Ì\u0001\"\u0006\b¬\u0003\u0010Î\u0001R+\u0010\u00ad\u0003\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u00ad\u0003\u0010Ê\u0001\u001a\u0006\b®\u0003\u0010Ì\u0001\"\u0006\b¯\u0003\u0010Î\u0001R+\u0010°\u0003\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b°\u0003\u0010Ê\u0001\u001a\u0006\b±\u0003\u0010Ì\u0001\"\u0006\b²\u0003\u0010Î\u0001R+\u0010³\u0003\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b³\u0003\u0010Ê\u0001\u001a\u0006\b´\u0003\u0010Ì\u0001\"\u0006\bµ\u0003\u0010Î\u0001R#\u0010¶\u0003\u001a\t\u0012\u0004\u0012\u00020#0¡\u00018\u0006¢\u0006\u0010\n\u0006\b¶\u0003\u0010¢\u0001\u001a\u0006\b·\u0003\u0010£\u0001R)\u0010¸\u0003\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¸\u0003\u0010¯\u0001\u001a\u0006\b¹\u0003\u0010±\u0001\"\u0006\bº\u0003\u0010³\u0001R)\u0010»\u0003\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b»\u0003\u0010¯\u0001\u001a\u0006\b¼\u0003\u0010±\u0001\"\u0006\b½\u0003\u0010³\u0001R)\u0010¾\u0003\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¾\u0003\u0010¯\u0001\u001a\u0006\b¿\u0003\u0010±\u0001\"\u0006\bÀ\u0003\u0010³\u0001R)\u0010Á\u0003\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÁ\u0003\u0010¯\u0001\u001a\u0006\bÁ\u0003\u0010±\u0001\"\u0006\bÂ\u0003\u0010³\u0001R)\u0010Ã\u0003\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÃ\u0003\u0010¯\u0001\u001a\u0006\bÃ\u0003\u0010±\u0001\"\u0006\bÄ\u0003\u0010³\u0001R)\u0010Å\u0003\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÅ\u0003\u0010¯\u0001\u001a\u0006\bÆ\u0003\u0010±\u0001\"\u0006\bÇ\u0003\u0010³\u0001R+\u0010È\u0003\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÈ\u0003\u0010Ê\u0001\u001a\u0006\bÉ\u0003\u0010Ì\u0001\"\u0006\bÊ\u0003\u0010Î\u0001R+\u0010Ë\u0003\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bË\u0003\u0010Ê\u0001\u001a\u0006\bÌ\u0003\u0010Ì\u0001\"\u0006\bÍ\u0003\u0010Î\u0001R#\u0010Î\u0003\u001a\t\u0012\u0004\u0012\u00020#0¡\u00018\u0006¢\u0006\u0010\n\u0006\bÎ\u0003\u0010¢\u0001\u001a\u0006\bÏ\u0003\u0010£\u0001R0\u0010Ð\u0003\u001a\t\u0012\u0004\u0012\u00020\f0ì\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÐ\u0003\u0010î\u0001\u001a\u0006\bÑ\u0003\u0010ð\u0001\"\u0006\bÒ\u0003\u0010ò\u0001R\u001c\u0010Ó\u0003\u001a\u00020\f8\u0006¢\u0006\u0010\n\u0006\bÓ\u0003\u0010Ê\u0001\u001a\u0006\bÔ\u0003\u0010Ì\u0001R+\u0010Õ\u0003\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÕ\u0003\u0010Ê\u0001\u001a\u0006\bÖ\u0003\u0010Ì\u0001\"\u0006\b×\u0003\u0010Î\u0001R\u001d\u0010Ù\u0003\u001a\u00030Ø\u00038\u0006¢\u0006\u0010\n\u0006\bÙ\u0003\u0010Ú\u0003\u001a\u0006\bÛ\u0003\u0010Ü\u0003R)\u0010Ý\u0003\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÝ\u0003\u0010¯\u0001\u001a\u0006\bÞ\u0003\u0010±\u0001\"\u0006\bß\u0003\u0010³\u0001R)\u0010à\u0003\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bà\u0003\u0010Ê\u0001\u001a\u0006\bá\u0003\u0010Ì\u0001\"\u0006\bâ\u0003\u0010Î\u0001R9\u0010ã\u0003\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bã\u0003\u0010ä\u0003\u001a\u0006\bå\u0003\u0010æ\u0003\"\u0006\bç\u0003\u0010è\u0003R+\u0010é\u0003\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bé\u0003\u0010Ó\u0001\u001a\u0006\bé\u0003\u0010Õ\u0001\"\u0006\bê\u0003\u0010\u0087\u0001R\u001b\u0010ë\u0003\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bë\u0003\u0010Ó\u0001R\u001b\u0010ì\u0003\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bì\u0003\u0010Ó\u0001R\u0019\u0010í\u0003\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bí\u0003\u0010÷\u0001R\u0019\u0010î\u0003\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bî\u0003\u0010÷\u0001R)\u0010ï\u0003\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bï\u0003\u0010Ê\u0001\u001a\u0006\bð\u0003\u0010Ì\u0001\"\u0006\bñ\u0003\u0010Î\u0001R\u001a\u0010~\u001a\u0005\u0018\u00010ò\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b~\u0010ó\u0003R$\u0010ô\u0003\u001a\n\u0012\u0005\u0012\u00030ò\u00030¡\u00018\u0006¢\u0006\u0010\n\u0006\bô\u0003\u0010¢\u0001\u001a\u0006\bõ\u0003\u0010£\u0001R\u0018\u0010÷\u0003\u001a\u00030ö\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b÷\u0003\u0010ø\u0003R)\u0010ù\u0003\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bù\u0003\u0010¯\u0001\u001a\u0006\bú\u0003\u0010±\u0001\"\u0006\bû\u0003\u0010³\u0001R\u0018\u0010ý\u0003\u001a\u00030ü\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bý\u0003\u0010þ\u0003R5\u0010O\u001a\u0010\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020\u0006\u0018\u00010H8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bO\u0010à\u0002\u001a\u0006\bÿ\u0003\u0010â\u0002\"\u0006\b\u0080\u0004\u0010ä\u0002R\u001b\u0010\u0081\u0004\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0004\u0010Ê\u0001R,\u0010\u0082\u0004\u001a\u0012\u0012\r\u0012\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0097\u00020¡\u00018\u0006¢\u0006\u0010\n\u0006\b\u0082\u0004\u0010¢\u0001\u001a\u0006\b\u0083\u0004\u0010£\u0001R\u001c\u0010\u0085\u0004\u001a\u0005\u0018\u00010\u0084\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0004\u0010\u0086\u0004R%\u0010\u0087\u0004\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0ì\u00018\u0006¢\u0006\u0010\n\u0006\b\u0087\u0004\u0010î\u0001\u001a\u0006\b\u0088\u0004\u0010ð\u0001R%\u0010\u0089\u0004\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0ì\u00018\u0006¢\u0006\u0010\n\u0006\b\u0089\u0004\u0010î\u0001\u001a\u0006\b\u008a\u0004\u0010ð\u0001R%\u0010\u008b\u0004\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0ì\u00018\u0006¢\u0006\u0010\n\u0006\b\u008b\u0004\u0010î\u0001\u001a\u0006\b\u008c\u0004\u0010ð\u0001R%\u0010\u008d\u0004\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0ì\u00018\u0006¢\u0006\u0010\n\u0006\b\u008d\u0004\u0010î\u0001\u001a\u0006\b\u008e\u0004\u0010ð\u0001R#\u0010\u008f\u0004\u001a\f\u0012\u0005\u0012\u00030\u009a\u0001\u0018\u00010³\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0004\u0010¶\u0002R\u001d\u0010\u0091\u0004\u001a\u00030\u0090\u00048\u0006¢\u0006\u0010\n\u0006\b\u0091\u0004\u0010\u0092\u0004\u001a\u0006\b\u0093\u0004\u0010\u0094\u0004R\u001d\u0010\u0096\u0004\u001a\u00030\u0095\u00048\u0006¢\u0006\u0010\n\u0006\b\u0096\u0004\u0010\u0097\u0004\u001a\u0006\b\u0098\u0004\u0010\u0099\u0004R+\u0010\u009c\u0004\u001a\u0016\u0012\u0005\u0012\u00030\u0095\u00010\u009a\u0004j\n\u0012\u0005\u0012\u00030\u0095\u0001`\u009b\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009c\u0004\u0010\u009d\u0004R\u001c\u0010\u009f\u0004\u001a\u0005\u0018\u00010\u009e\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0004\u0010 \u0004R\u0019\u0010¡\u0004\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0004\u0010¯\u0001¨\u0006¤\u0004"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/SkuViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuItemInfoVO;", "getSelectSkuInfo", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuInfoVO;", "skuInfo", "", "initSkuStock", "", "Lcom/bytedance/android/ec/common/impl/sku/model/SpecInfo;", "specInfoList", "", "", "picMap", "generateLargeImageUrlList", "initDefaultSelectParams", "Lcom/bytedance/android/ec/model/sku/SkuParams;", "skuParams", "btmPageId", "appendEntranceInfoToSkuParams", "initEventParams", "getSkuPanelModel", "smallPicMap", "specInfo", "initSkuSpecStatus", "Lcom/bytedance/android/ec/model/sku/TradeModeComponent;", "tradeModeComponent", "initSkuTradeModeStatus", "metric", "doPdpStandardMonitor", "getSearchParams", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "showErrorToast", "", "needShowAddCartMotion", "", "resId", "getString", com.bytedance.android.ec.core.event.a.KEY_MSG, "displayToast", "infoStr", "Lorg/json/JSONObject;", "getEntranceInfoJson", "", "getDefaultCountLimit", "extra", "productId", "cartId", "sceneType", "sendAddCartSuccessEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "updateAddress", "skuInfoVO", "Lcom/bytedance/android/ec/common/impl/sku/repository/dto/APIAction;", "itemContainsUpdate", "selectedNum", "itemInfo", "apiAction", "commonSkuUpdate", "getCurrentPromiseType", "isInDepositPresale", "isInSecKill", "isInPreSecKill", "isGroupBuy", "isInActivity", "resetFxhParams", "Lcf/t;", "skuLiveService", "Lkotlin/Function0;", "promotionListEntranceInfo", "Lkotlin/Function2;", "adLogCallBack", "Lkotlin/Function1;", "finishPlaybackPageListener", "Lcom/bytedance/android/ec/model/sku/SkuProductDetailInfo;", "refreshDetailInfoCallback", "Lcom/bytedance/android/ec/model/sku/SkuCartResult;", "cartListener", "Lcom/bytedance/android/ec/model/sku/SkuCheckResult;", "skuCheckResultCallback", "init", "actionName", "", "Lkotlin/Pair;", "params", "btmId", "Lcom/bytedance/android/btm/api/model/PageFinder;", "pageFinder", "trackParams", "doSkuEventAction", "(Ljava/lang/String;[Lkotlin/Pair;Ljava/lang/String;Lcom/bytedance/android/btm/api/model/PageFinder;Ljava/util/Map;)V", "errorType", "errorMsg", "doSkuErrorEventAction", "activityLabel", "activityType", "planNo", "materialNo", "resourceNo", "biztype", "doSkuEventActionNew", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Lkotlin/Pair;)V", "getSkuInfo", "getSkuInstallmentInfo", "appointNoStock", "originType", "originId", "comboId", "comboNum", "specDesc", "deviceId", "channelId", "channelType", "bcmChain", "addShopCart", "addShopCartNew", "Landroid/content/Context;", "context", "Lsc3/b;", "chainMonitor", "orderUrl", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG, "successCallback", "applyCouponAuto", "startTick", MessageIndication.MESSAGE_TYPE_MSG, "checkPayNotification", "needPost", "cancelQueryPromotionCheckPayNotification", "Lul/j;", "updatedSkuPanelInfo", "updateCampaign", "logAdEvent", "closeType", "closeDialogFragment", "(Ljava/lang/Integer;)V", "closeListener", "hideDialogFragment", "logChooseSkuCompleteEvent", "getUpperLimit", "getLowerLimit", "getCurrentCount", "getCurrentPrice", "isSizeTabExist", "Lcg/h;", "getSpecTitleEntryEventStruct", "getPreviousPage", "index", "isPresaleSkuSpec", "Ljava/lang/Runnable;", "runnable", "registerSkuNextChangeCallback", "saveAddCartGuideInfo", "notifySkuChanged", "", "btmNode", "setRegisteredBtmNode", "Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;", "firstCallBack", "updateButtonTip", "onCleared", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lcom/bytedance/android/ec/model/sku/SkuParams;", "getSkuParams", "()Lcom/bytedance/android/ec/model/sku/SkuParams;", "setSkuParams", "(Lcom/bytedance/android/ec/model/sku/SkuParams;)V", "Lcf/t;", "getSkuLiveService", "()Lcf/t;", "setSkuLiveService", "(Lcf/t;)V", "first", "Z", "getFirst", "()Z", "setFirst", "(Z)V", "currentAvatar", "getCurrentAvatar", "currentStock", "getCurrentStock", "currentPrice", "highLightUncheckSpec", "getHighLightUncheckSpec", "firstUnCheckSpecY", "getFirstUnCheckSpecY", "currentPriceWithDefault", "J", "getCurrentPriceWithDefault", "()J", "setCurrentPriceWithDefault", "(J)V", "currentOriginPrice", "getCurrentOriginPrice", "setCurrentOriginPrice", "currentDiscountPrice", "getCurrentDiscountPrice", "setCurrentDiscountPrice", "currentDiscountPriceText", "Ljava/lang/String;", "getCurrentDiscountPriceText", "()Ljava/lang/String;", "setCurrentDiscountPriceText", "(Ljava/lang/String;)V", "currentCampainPriceHeader", "getCurrentCampainPriceHeader", "setCurrentCampainPriceHeader", "currentCampainPriceHeaderStyle", "Ljava/lang/Integer;", "getCurrentCampainPriceHeaderStyle", "()Ljava/lang/Integer;", "setCurrentCampainPriceHeaderStyle", "currentNewBonusText", "getCurrentNewBonusText", "setCurrentNewBonusText", "currentCount", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuLimit;", "upperLimit", "lowerLimit", "limitText", "getLimitText", "stockDesc", "getStockDesc", "Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "currentBenefitLabel", "getCurrentBenefitLabel", "Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;", "currentCarAdaptComponent", "getCurrentCarAdaptComponent", "imageSpecSelectIndex", "getImageSpecSelectIndex", "getComboId", "setComboId", "", "checkedIdArray", "Ljava/util/List;", "getCheckedIdArray", "()Ljava/util/List;", "setCheckedIdArray", "(Ljava/util/List;)V", "selectedSkuId", "getSelectedSkuId", "setSelectedSkuId", "currentPos", "I", "getCurrentPos", "()I", "setCurrentPos", "(I)V", "canAddCart", "Ljava/lang/Boolean;", "getCanAddCart", "()Ljava/lang/Boolean;", "setCanAddCart", "(Ljava/lang/Boolean;)V", "checkedNames", "getCheckedNames", "unCheckedName", "getUnCheckedName", "setUnCheckedName", "(Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;)V", "firstIdList", "getFirstIdList", "setFirstIdList", "imageList", "getImageList", "setImageList", "nameList", "getNameList", "setNameList", "installmentOriginalVisibility", "getInstallmentOriginalVisibility", "setInstallmentOriginalVisibility", "cartSelectedDes", "getCartSelectedDes", "setCartSelectedDes", "Lrg/a;", "getCloseDialogFragment", "getHideDialogFragment", "doAddCartMotionAction", "getDoAddCartMotionAction", "cancelDownTimer", "getCancelDownTimer", "termCountList", "getTermCountList", "setTermCountList", "showFlag", "getShowFlag", "setShowFlag", "recommendTermCount", "getRecommendTermCount", "setRecommendTermCount", "voucherList", "getVoucherList", "setVoucherList", "selectFxhMethod", "getSelectFxhMethod", "setSelectFxhMethod", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuInstallmentItemInfo;", "validInstallmentInfo", "getValidInstallmentInfo", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuTermInfoItem;", "currentDouInstallmentItem", "getCurrentDouInstallmentItem", "Ljava/lang/ref/WeakReference;", "", "installmentInfoMap", "Ljava/lang/ref/WeakReference;", "currentInstallmentIndex", "getCurrentInstallmentIndex", "setCurrentInstallmentIndex", "currentTradeModeIndex", "getCurrentTradeModeIndex", "setCurrentTradeModeIndex", "Lcom/bytedance/android/ec/model/sku/TradeModeSelection;", "currentTradeModeItem", "getCurrentTradeModeItem", "currentButtonTip", "getCurrentButtonTip", "halfCloseSku", "getHalfCloseSku", "setHalfCloseSku", "getDisplayToast", "Lrg/b;", "loadStatus", "getLoadStatus", "Lkotlin/Triple;", "applyCouponSuccess", "getApplyCouponSuccess", "applyCouponIds", "getApplyCouponIds", "setApplyCouponIds", "saveState", "getSaveState", "Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "skuPanelState", "Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "getSkuPanelState", "()Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "setSkuPanelState", "(Lcom/bytedance/android/ec/model/sku/SkuRestoreState;)V", "Lcom/bytedance/android/ec/model/response/ProductSelectPoiInfo;", "selectPoiInfo", "getSelectPoiInfo", "setSelectPoiInfo", "lastBehaviorBeforeDismiss", "getLastBehaviorBeforeDismiss", "setLastBehaviorBeforeDismiss", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "getFinishPlaybackPageListener", "()Lkotlin/jvm/functions/Function1;", "setFinishPlaybackPageListener", "(Lkotlin/jvm/functions/Function1;)V", "getCartListener", "setCartListener", "Lkotlin/jvm/functions/Function0;", "getPromotionListEntranceInfo", "()Lkotlin/jvm/functions/Function0;", "setPromotionListEntranceInfo", "(Lkotlin/jvm/functions/Function0;)V", "getRefreshDetailInfoCallback", "setRefreshDetailInfoCallback", "hasRefreshDetailInfo", "getHasRefreshDetailInfo", "setHasRefreshDetailInfo", "currentFirstPrice", "Ljava/lang/Long;", "getCurrentFirstPrice", "()Ljava/lang/Long;", "setCurrentFirstPrice", "(Ljava/lang/Long;)V", "currentFirstPricePrefix", "getCurrentFirstPricePrefix", "setCurrentFirstPricePrefix", "currentFirstPriceSuffix", "getCurrentFirstPriceSuffix", "setCurrentFirstPriceSuffix", "currentFirstPriceIsUnderline", "getCurrentFirstPriceIsUnderline", "setCurrentFirstPriceIsUnderline", "currentSecondPrice", "getCurrentSecondPrice", "setCurrentSecondPrice", "currentSecondPricePrefix", "getCurrentSecondPricePrefix", "setCurrentSecondPricePrefix", "currentSecondPriceSuffix", "getCurrentSecondPriceSuffix", "setCurrentSecondPriceSuffix", "currentSecondPriceIsUnderline", "getCurrentSecondPriceIsUnderline", "setCurrentSecondPriceIsUnderline", "currentSecondPriceIsReducePrice", "getCurrentSecondPriceIsReducePrice", "setCurrentSecondPriceIsReducePrice", "currentRegularPrice", "getCurrentRegularPrice", "setCurrentRegularPrice", "currentRegularPricePrefix", "getCurrentRegularPricePrefix", "setCurrentRegularPricePrefix", "currentRegularPriceSuffix", "getCurrentRegularPriceSuffix", "setCurrentRegularPriceSuffix", "currentRegularPriceIsUnderline", "getCurrentRegularPriceIsUnderline", "setCurrentRegularPriceIsUnderline", "currentHotMinPrice", "getCurrentHotMinPrice", "setCurrentHotMinPrice", "currentHotMaxPrice", "getCurrentHotMaxPrice", "setCurrentHotMaxPrice", "currentHotPricePrefix", "getCurrentHotPricePrefix", "setCurrentHotPricePrefix", "currentHotPriceSupplement", "getCurrentHotPriceSupplement", "setCurrentHotPriceSupplement", "currentPriceType", "getCurrentPriceType", "setCurrentPriceType", "currentFirstPriceSupplement", "getCurrentFirstPriceSupplement", "setCurrentFirstPriceSupplement", "currentOriginPriceSupplement", "getCurrentOriginPriceSupplement", "setCurrentOriginPriceSupplement", "currentSecondPriceSupplement", "getCurrentSecondPriceSupplement", "setCurrentSecondPriceSupplement", "currentRegularPriceSupplement", "getCurrentRegularPriceSupplement", "setCurrentRegularPriceSupplement", "currentAtmosphereStyle", "getCurrentAtmosphereStyle", "currentSpecShowBigPicMode", "getCurrentSpecShowBigPicMode", "setCurrentSpecShowBigPicMode", "currentSpecHasPrice", "getCurrentSpecHasPrice", "setCurrentSpecHasPrice", "currentSpecHasPic", "getCurrentSpecHasPic", "setCurrentSpecHasPic", "isExistSizeTab", "setExistSizeTab", "isTradeIn", "setTradeIn", "selectTradeIn", "getSelectTradeIn", "setSelectTradeIn", "tradeBenefitId", "getTradeBenefitId", "setTradeBenefitId", "tradeBenefitText", "getTradeBenefitText", "setTradeBenefitText", "scrollViewScrollY", "getScrollViewScrollY", "showServiceCodeList", "getShowServiceCodeList", "setShowServiceCodeList", "skuShowSessionId", "getSkuShowSessionId", "showLogisticsCode", "getShowLogisticsCode", "setShowLogisticsCode", "Lul/f;", "skuPageState", "Lul/f;", "getSkuPageState", "()Lul/f;", "clickCountUnConsumed", "getClickCountUnConsumed", "setClickCountUnConsumed", "currentJumpUrl", "getCurrentJumpUrl", "setCurrentJumpUrl", "showTrackParams", "Ljava/util/Map;", "getShowTrackParams", "()Ljava/util/Map;", "setShowTrackParams", "(Ljava/util/Map;)V", "isDelayedDispatch", "setDelayedDispatch", "presellDelayDay", "deliveryDelayDay", "mCheckPayNotificationNextTick", "mCheckPayNotificationTick", "checkPayNotificationSkuId", "getCheckPayNotificationSkuId", "setCheckPayNotificationSkuId", "Lcom/bytedance/android/ec/model/response/p;", "Lcom/bytedance/android/ec/model/response/p;", "checkPayNotificationAction", "getCheckPayNotificationAction", "Lq83/a;", "checkPayNotificationTickListener", "Lq83/a;", "checkSkuPromotionFailed", "getCheckSkuPromotionFailed", "setCheckSkuPromotionFailed", "Lcom/bytedance/android/ec/common/impl/sku/repository/a;", "repository", "Lcom/bytedance/android/ec/common/impl/sku/repository/a;", "getSkuCheckResultCallback", "setSkuCheckResultCallback", "previousPage", "onItemChange", "getOnItemChange", "Lcg/g;", "skuStock", "Lcg/g;", "imageUrlList", "getImageUrlList", "bigImageUrlList", "getBigImageUrlList", "nameListSpec", "getNameListSpec", "firstSkuIdList", "getFirstSkuIdList", "btmNodeRef", "Lcom/bytedance/android/ec/common/impl/sku/view/SpecItemGroupLayout$c;", "skuStockData", "Lcom/bytedance/android/ec/common/impl/sku/view/SpecItemGroupLayout$c;", "getSkuStockData", "()Lcom/bytedance/android/ec/common/impl/sku/view/SpecItemGroupLayout$c;", "Lcom/bytedance/android/ec/common/impl/sku/view/SpecItemOptimizeGroupLayout$c;", "skuStockDataOptimize", "Lcom/bytedance/android/ec/common/impl/sku/view/SpecItemOptimizeGroupLayout$c;", "getSkuStockDataOptimize", "()Lcom/bytedance/android/ec/common/impl/sku/view/SpecItemOptimizeGroupLayout$c;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "skuNextTimeChangeCallbacks", "Ljava/util/ArrayList;", "Lio/reactivex/disposables/Disposable;", "updateJob", "Lio/reactivex/disposables/Disposable;", "isFirstUpdate", "<init>", "()V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuViewModel extends BaseViewModel {
    private Function2<? super SkuParams, ? super Long, Unit> adLogCallBack;
    private String applyCouponIds;
    private final QLiveData<rg.a<Triple<String, sc3.b, String>>> applyCouponSuccess;
    private final List<String> bigImageUrlList;
    private WeakReference<Object> btmNodeRef;
    private Boolean canAddCart;
    private final QLiveData<Boolean> cancelDownTimer;
    private Function1<? super SkuCartResult, Unit> cartListener;
    private String cartSelectedDes;
    private com.bytedance.android.ec.model.response.p checkPayNotification;
    private final QLiveData<com.bytedance.android.ec.model.response.p> checkPayNotificationAction;
    private String checkPayNotificationSkuId;
    private final q83.a checkPayNotificationTickListener;
    private boolean checkSkuPromotionFailed;
    private List<String> checkedIdArray;
    private final QLiveData<String> checkedNames;
    private volatile boolean clickCountUnConsumed;
    private final QLiveData<rg.a<Function0<Unit>>> closeDialogFragment;
    private String comboId;
    private final QLiveData<Integer> currentAtmosphereStyle;
    private final QLiveData<String> currentAvatar;
    private final QLiveData<List<PromotionBenefitLabel>> currentBenefitLabel;
    private final QLiveData<ButtonTipComponent> currentButtonTip;
    private String currentCampainPriceHeader;
    private Integer currentCampainPriceHeaderStyle;
    private final QLiveData<CarAdaptComponent> currentCarAdaptComponent;
    private final QLiveData<Long> currentCount;
    private long currentDiscountPrice;
    private String currentDiscountPriceText;
    private final QLiveData<SkuTermInfoItem> currentDouInstallmentItem;
    private Long currentFirstPrice;
    private Boolean currentFirstPriceIsUnderline;
    private String currentFirstPricePrefix;
    private String currentFirstPriceSuffix;
    private String currentFirstPriceSupplement;
    private Long currentHotMaxPrice;
    private Long currentHotMinPrice;
    private String currentHotPricePrefix;
    private String currentHotPriceSupplement;
    private int currentInstallmentIndex;
    private String currentJumpUrl;
    private String currentNewBonusText;
    private long currentOriginPrice;
    private String currentOriginPriceSupplement;
    private int currentPos;
    private final QLiveData<Long> currentPrice;
    private Long currentPriceType;
    private long currentPriceWithDefault;
    private Long currentRegularPrice;
    private Boolean currentRegularPriceIsUnderline;
    private String currentRegularPricePrefix;
    private String currentRegularPriceSuffix;
    private String currentRegularPriceSupplement;
    private Long currentSecondPrice;
    private Boolean currentSecondPriceIsReducePrice;
    private Boolean currentSecondPriceIsUnderline;
    private String currentSecondPricePrefix;
    private String currentSecondPriceSuffix;
    private String currentSecondPriceSupplement;
    private boolean currentSpecHasPic;
    private boolean currentSpecHasPrice;
    private boolean currentSpecShowBigPicMode;
    private final QLiveData<Long> currentStock;
    private QLiveData<Integer> currentTradeModeIndex;
    private final QLiveData<TradeModeSelection> currentTradeModeItem;
    private Integer deliveryDelayDay;
    private final QLiveData<rg.a<String>> displayToast;
    private final QLiveData<rg.a<Unit>> doAddCartMotionAction;
    private Function1<? super String, Unit> finishPlaybackPageListener;
    private boolean first;
    private List<String> firstIdList;
    private final List<String> firstSkuIdList;
    private final QLiveData<Integer> firstUnCheckSpecY;
    private int halfCloseSku;
    private boolean hasRefreshDetailInfo;
    private final QLiveData<rg.a<Function0<Unit>>> hideDialogFragment;
    private final QLiveData<Boolean> highLightUncheckSpec;
    private List<String> imageList;
    private final QLiveData<Integer> imageSpecSelectIndex;
    private final List<String> imageUrlList;
    private final WeakReference<Map<String, SkuInstallmentItemInfo>> installmentInfoMap;
    private Boolean installmentOriginalVisibility;
    private Integer isDelayedDispatch;
    private boolean isExistSizeTab;
    private boolean isFirstUpdate;
    private boolean isTradeIn;
    private String lastBehaviorBeforeDismiss;
    private final QLiveData<String> limitText;
    private final QLiveData<rg.b> loadStatus;
    private final QLiveData<SkuLimit> lowerLimit;
    private int mCheckPayNotificationNextTick;
    private int mCheckPayNotificationTick;
    private List<String> nameList;
    private final List<String> nameListSpec;
    private final QLiveData<rg.a<String>> onItemChange;
    private Integer presellDelayDay;
    private String previousPage;
    private Function0<String> promotionListEntranceInfo;
    private String recommendTermCount;
    private Function1<? super SkuProductDetailInfo, Unit> refreshDetailInfoCallback;
    private final com.bytedance.android.ec.common.impl.sku.repository.a repository;
    private final QLiveData<rg.a<Boolean>> saveState;
    private final QLiveData<Integer> scrollViewScrollY;
    private String selectFxhMethod;
    private QLiveData<ProductSelectPoiInfo> selectPoiInfo;
    private boolean selectTradeIn;
    private String selectedSkuId;
    private boolean showFlag;
    private String showLogisticsCode;
    private List<String> showServiceCodeList;
    private Map<String, String> showTrackParams;
    private Function1<? super SkuCheckResult, Unit> skuCheckResultCallback;
    private final QLiveData<SkuInfoVO> skuInfo;
    private cf.t skuLiveService;
    private final ArrayList<Runnable> skuNextTimeChangeCallbacks;
    private final ul.f skuPageState;
    private SkuRestoreState skuPanelState;
    private SkuParams skuParams;
    private final String skuShowSessionId;
    private cg.g skuStock;
    private final SpecItemGroupLayout.c skuStockData;
    private final SpecItemOptimizeGroupLayout.c skuStockDataOptimize;
    private final QLiveData<String> stockDesc;
    private List<Integer> termCountList;
    private String tradeBenefitId;
    private String tradeBenefitText;
    private QLiveData<String> unCheckedName;
    private Disposable updateJob;
    private final QLiveData<SkuLimit> upperLimit;
    private final QLiveData<SkuInstallmentItemInfo> validInstallmentInfo;
    private List<String> voucherList;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ SkuViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public a(SkuViewModel r1, String r10, String r11, String r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }

        public final void accept(Object r28) {
            AddCartResponse r1 = (AddCartResponse) r28;
            boolean r10 = true;
            if (r1.getStatusCode() != 0) goto L28;
            EventBus r11 = EventBus.getDefault();
            int r12 = r1.getCount();
            SkuItemInfoVO r13 = SkuViewModel.access$getSelectSkuInfo(this.a);
            if (r13 == null) goto L7;
            String r14 = r13.getImageUrl();
        L8:
            Integer r15 = Integer.valueOf(this.a.getSkuParams().getSceneType());
            String r16 = this.a.getSkuParams().getProductId();
            if (r16 != null) goto L11;
            r16 = "";
        L11:
            r11.post(new hl.b(r12, r14, r15, r16, r1.getCartNumWithBusinessLine(), this.b, this.c, null, null, null, null, null, r1.getSchema(), null, false, r1.getCartId(), com.bytedance.android.shopping.extensions.k.v(r1.getToastBar()), null, 638848));
            EventBus.getDefault().post(new hl.d(r1.getCount()));
            EventBus.getDefault().post(new hl.g(r1.getCount(), true));
            EventBus r17 = EventBus.getDefault();
            int r18 = r1.getCount();
            SkuItemInfoVO r19 = SkuViewModel.access$getSelectSkuInfo(this.a);
            if (r19 == null) goto L14;
            String r20 = r19.getImageUrl();
        L15:
            r17.post(new hl.h(r18, r20, this.a.getSkuParams().getPromotionId()));
            SkuViewModel r21 = this.a;
            SkuViewModel.access$sendAddCartSuccessEvent(r21, this.d, r21.getSkuParams().getProductId(), r1.getCartId(), Integer.valueOf(this.a.getSkuParams().getSceneType()));
            Function1<SkuCartResult, Unit> r22 = this.a.getCartListener();
            if (r22 == null) goto L19;
            Unit r23 = (Unit) r22.invoke(new SkuCartResult("", "", r1.getCount(), 0, null, null, null, null, 248, null));
        L19:
            if (SkuViewModel.access$needShowAddCartMotion(this.a) == false) goto L21;
            this.a.getDoAddCartMotionAction().g(new rg.a(Unit.INSTANCE));
        L27:
            this.a.closeDialogFragment(3);
            Set<String> r24 = ECProcessMonitor.a;
            ECProcessMonitor.d("ec_sku").g();
            return;
        L21:
            int r25 = this.a.getSkuParams().getAddToastType();
            if (r25 == 0) goto L26;
            if (r25 != 1) goto L27;
            SkuViewModel r26 = this.a;
            SkuViewModel.access$displayToast(r26, SkuViewModel.access$getString(r26, 2131913879));
            goto L27
        L26:
            SkuViewModel r27 = this.a;
            SkuViewModel.access$displayToast(r27, SkuViewModel.access$getString(r27, 2131913777));
            goto L27
        L14:
            r20 = null;
            goto L15
        L7:
            r14 = null;
            goto L8
        L28:
            SkuViewModel r29 = this.a;
            String r30 = r1.getStatusMsg();
            if (r30 != null) goto L31;
        L38:
            r30 = SkuViewModel.access$getString(this.a, 2131913776);
        L39:
            SkuViewModel.access$displayToast(r29, r30);
            Set<String> r31 = ECProcessMonitor.a;
            com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_sku"), r1.getStatusCode(), r1.getStatusMsg(), null, null, 12);
            return;
        L31:
            if (r30.length() > 0) goto L34;
            r10 = false;
        L34:
            if (r10 == true) goto L37;
            r30 = null;
        L37:
            if (r30 != null) goto L39;
            goto L38
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ SkuViewModel a;

        public b(SkuViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            Throwable r11 = (Throwable) r10;
            Set<String> r12 = ECProcessMonitor.a;
            com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_sku"), -5, null, null, null, 14);
            SkuViewModel r13 = this.a;
            SkuViewModel.access$displayToast(r13, SkuViewModel.access$getString(r13, 2131913776));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ SkuViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public c(SkuViewModel r1, String r10, String r11, String r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }

        public final void accept(Object r29) {
            JSONObject r10 = new JSONObject((String) r29);     // Catch: Exception -> L56
            JSONObject r1 = r10.optJSONObject("data");     // Catch: Exception -> L56
            if (r1 == null) goto L6;
            String r11 = r1.optString("cart_id");     // Catch: Exception -> L56
        L7:
            int r12 = r10.optInt("status_code");     // Catch: Exception -> L56
            String r13 = r10.optString(MessageIndication.MESSAGE_TYPE_MSG);     // Catch: Exception -> L56
            if (r1 == null) goto L10;
            JSONObject r14 = r1.optJSONObject("toast_bar");     // Catch: Exception -> L56
        L11:
            int r15 = r10.optInt("cart_num", -1);     // Catch: Exception -> L56
            if (r15 != (-1)) goto L17;
            if (r1 == null) goto L16;
            r15 = r1.optInt("cart_num");     // Catch: Exception -> L56
            goto L17
        L16:
            int r16 = 0;
        L62:
            int r17 = w0.a;     // Catch: Exception -> L24
            CartNumWithBusinessLine[] r18 = (CartNumWithBusinessLine[]) w0.b(r10.optString("cart_num_with_business_line"), CartNumWithBusinessLine[].class);     // Catch: Exception -> L24
            if (r18 == null) goto L22;
            List r19 = ArraysKt.toList(r18);     // Catch: Exception -> L24
        L23:
            List r110 = r19;
        L25:
            if (r12 != 0) goto L51;
            EventBus r111 = EventBus.getDefault();     // Catch: Exception -> L56
            SkuItemInfoVO r20 = SkuViewModel.access$getSelectSkuInfo(this.a);     // Catch: Exception -> L56
            if (r20 == null) goto L29;
            String r112 = r20.getImageUrl();     // Catch: Exception -> L56
        L30:
            Integer r113 = Integer.valueOf(this.a.getSkuParams().getSceneType());     // Catch: Exception -> L56
            String r21 = this.a.getSkuParams().getProductId();     // Catch: Exception -> L56
            if (r21 != null) goto L33;
            r21 = "";
        L33:
            String r114 = r21;
            String r22 = this.b;     // Catch: Exception -> L56
            String r23 = this.c;     // Catch: Exception -> L56
            if (r1 == null) goto L36;
            String r24 = r1.optString("after_add_jump_url");     // Catch: Exception -> L56
        L37:
            Integer r25 = Integer.valueOf(this.a.getSkuParams().getStandardAddCartToastType());     // Catch: Exception -> L56
            if (r14 == null) goto L40;
            JSONObject r26 = com.bytedance.android.ec.hybrid.list.util.k.b(r14);     // Catch: Exception -> L56
        L41:
            r111.post(new hl.b(r16, r112, r113, r114, r110, r22, r23, null, null, null, null, r25, r24, null, false, r11, r26, null, 630656));     // Catch: Exception -> L56
            EventBus.getDefault().post(new hl.d(r16));     // Catch: Exception -> L56
            SkuViewModel r27 = this.a;     // Catch: Exception -> L56
            SkuViewModel.access$sendAddCartSuccessEvent(r27, this.d, r27.getSkuParams().getProductId(), r11, Integer.valueOf(this.a.getSkuParams().getSceneType()));     // Catch: Exception -> L56
            if (jg.g.a(this.a.getSkuParams().getSkuSessionId()) == false) goto L44;
            int r28 = AddCartDirectlyHelper.a;     // Catch: Exception -> L56
            AddCartDirectlyHelper.f(r10, this.a.getSkuParams().getSkuSessionId());     // Catch: Exception -> L56
        L46:
            if (this.a.getSkuParams().getStandardAddCartToastType() != 1) goto L49;
            SkuViewModel r30 = this.a;     // Catch: Exception -> L56
            SkuViewModel.access$displayToast(r30, SkuViewModel.access$getString(r30, 2131913777));     // Catch: Exception -> L56
        L49:
            this.a.closeDialogFragment(3);     // Catch: Exception -> L56
            Set<String> r31 = ECProcessMonitor.a;     // Catch: Exception -> L56
            ECProcessMonitor.d("ec_sku").g();     // Catch: Exception -> L56
            return;
        L44:
            int r32 = AddCartDirectlyHelper.a;     // Catch: Exception -> L56
            AddCartDirectlyHelper.e(r10, Integer.valueOf(this.a.getSkuParams().getSceneType()), this.a.getSkuParams().getProductId(), this.a.getSkuParams().getPromotionId());     // Catch: Exception -> L56
            goto L46
        L40:
            r26 = null;
            goto L41
        L36:
            r24 = null;
            goto L37
        L29:
            r112 = null;
            goto L30
        L51:
            if (jg.g.a(this.a.getSkuParams().getSkuSessionId()) == false) goto L53;
            int r33 = AddCartDirectlyHelper.a;     // Catch: Exception -> L56
            AddCartDirectlyHelper.f(r10, this.a.getSkuParams().getSkuSessionId());     // Catch: Exception -> L56
        L54:
            SkuViewModel.access$showErrorToast(this.a, r13);     // Catch: Exception -> L56
            Set<String> r34 = ECProcessMonitor.a;     // Catch: Exception -> L56
            com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_sku"), r12, r13, null, null, 12);     // Catch: Exception -> L56
            return;
        L53:
            int r35 = AddCartDirectlyHelper.a;     // Catch: Exception -> L56
            AddCartDirectlyHelper.e(r10, Integer.valueOf(this.a.getSkuParams().getSceneType()), this.a.getSkuParams().getProductId(), this.a.getSkuParams().getPromotionId());     // Catch: Exception -> L56
            goto L54
        L22:
            r19 = null;
        L24:
            r110 = null;
        L17:
            r16 = r15;
            goto L62
        L10:
            r14 = null;
            goto L11
        L6:
            r11 = null;
            goto L7
        L57:
            if (jg.g.a(this.a.getSkuParams().getSkuSessionId()) == false) goto L59;
            int r36 = AddCartDirectlyHelper.a;
            AddCartDirectlyHelper.f(null, this.a.getSkuParams().getSkuSessionId());
            String r37 = null;
        L60:
            SkuViewModel.showErrorToast$default(this.a, r37, 1, r37);
            Set<String> r38 = ECProcessMonitor.a;
            com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_sku"), -5, null, null, null, 14);
            return;
        L59:
            int r39 = AddCartDirectlyHelper.a;
            r37 = null;
            AddCartDirectlyHelper.e(null, Integer.valueOf(this.a.getSkuParams().getSceneType()), this.a.getSkuParams().getProductId(), this.a.getSkuParams().getPromotionId());
            goto L60
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ SkuViewModel a;

        public d(SkuViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            Throwable r11 = (Throwable) r10;
            if (jg.g.a(this.a.getSkuParams().getSkuSessionId()) == false) goto L5;
            int r12 = AddCartDirectlyHelper.a;
            AddCartDirectlyHelper.f(null, this.a.getSkuParams().getSkuSessionId());
        L6:
            SkuViewModel.showErrorToast$default(this.a, null, 1, null);
            Set<String> r13 = ECProcessMonitor.a;
            com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_sku"), -5, null, null, null, 14);
            return;
        L5:
            int r14 = AddCartDirectlyHelper.a;
            AddCartDirectlyHelper.e(null, Integer.valueOf(this.a.getSkuParams().getSceneType()), this.a.getSkuParams().getProductId(), this.a.getSkuParams().getPromotionId());
            goto L6
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ SkuViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ sc3.b c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ long e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ Function1 h;

        public e(SkuViewModel r1, String r10, sc3.b r11, Context r12, long r13, String r14, String r15, Function1 r16) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
            this.g = r15;
            this.h = r16;
        }

        public final void accept(Object r10) {
            PromotionAutoApplyCouponResponse r11 = (PromotionAutoApplyCouponResponse) r10;
            Map<String, com.bytedance.android.ec.core.monitor.a> r0 = com.bytedance.android.ec.core.monitor.c.a;
            com.bytedance.android.ec.core.monitor.c.j(this.b, MetricNames.API_DURATION);
            com.bytedance.android.ec.core.monitor.c.d(this.b);
            sc3.b r1 = this.c;
            if (r1 == null) goto L6;
            r1.c(ChainPoint.AUTO_COUPON_END, Long.valueOf(System.currentTimeMillis()));
        L6:
            if (jg.g.a((String) this.a.getUnCheckedName().a()) == false) goto L9;
            Context r12 = this.d;
            UIUtils.displayToast(r12, th.a.h(r12, 2131914030, new Object[]{this.a.getUnCheckedName().a()}));
            return;
        L9:
            if (this.e == (this.a.getCurrentPrice() * this.a.getCurrentCount())) goto L11;
            this.a.applyCouponAuto(this.d, this.c, this.f, this.g, this.h);
            return;
        L11:
            Lazy r13 = ECAppInfoService.a;
            if (ECAppInfoService.j() == false) goto L14;
        L19:
            new Handler(Looper.getMainLooper()).postDelayed(new com.bytedance.android.ec.common.impl.sku.p(r11), 1000);
        L20:
            this.a.setApplyCouponIds(r11.getCouponIds());
            Function1 r14 = this.h;
            if (r14 != null) goto L23;
        L24:
            this.a.getApplyCouponSuccess().g(new rg.a(new Triple(this.f, this.c, this.g)));
            Unit r15 = Unit.INSTANCE;
        L25:
            Set<String> r16 = ECProcessMonitor.a;
            com.bytedance.android.ec.core.monitor.listener.c r17 = ECProcessMonitor.c("ec_sku", "/aweme/v2/shop/coupon/apply/auto/");
            JSONObject r18 = new JSONObject();
            r18.put(com.bytedance.android.ec.core.event.a.VALUE_SHOW_TOAST, r11.getToast());
            r18.put("coupon_ids", r11.getCouponIds());
            Unit r19 = Unit.INSTANCE;
            ActionRateListener.c(r17, r18, null, false, 6);
            if (r11.getStatusCode() != 0) goto L28;
            r17.g();
            return;
        L28:
            int r20 = r11.getStatusCode();
            String r21 = r11.getStatusMsg();
            if (r21 != null) goto L31;
            r21 = "";
        L31:
            Intrinsics.checkNotNullParameter(r21, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
            r17.k(r20, r21, r17.b);
            return;
        L23:
            if (((Unit) r14.invoke(this.f)) != null) goto L25;
        L14:
            if (ECAppInfoService.m() == true) goto L19;
            String r22 = r11.getToast();
            if (r22 == null) goto L20;
            SkuViewModel.access$displayToast(this.a, r22);
            goto L20
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ SkuViewModel a;
        public final /* synthetic */ String b;

        public f(SkuViewModel r1, String r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void accept(Object r10) {
            Throwable r11 = (Throwable) r10;
            Map<String, com.bytedance.android.ec.core.monitor.a> r12 = com.bytedance.android.ec.core.monitor.c.a;
            com.bytedance.android.ec.core.monitor.c.j(this.b, MetricNames.API_DURATION);
            SkuViewModel r13 = this.a;
            SkuViewModel.access$displayToast(r13, SkuViewModel.access$getString(r13, 2131913931));
            com.bytedance.android.ec.core.monitor.c.d(this.b);     // Catch: Exception -> L5
        L7:
            Set<String> r14 = ECProcessMonitor.a;
            com.bytedance.android.ec.core.monitor.listener.c.j(ECProcessMonitor.c("ec_sku", "/aweme/v2/shop/coupon/apply/auto/"), -1);
            return;
        L5:
            e = move-exception;
            ECExceptionMonitor.e(e);
            goto L7
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ SkuViewModel a;

        public g(SkuViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            SkuAppointmentResponse r11 = (SkuAppointmentResponse) r10;
            SkuViewModel r0 = this.a;
            if (r11 == null) goto L6;
            String r12 = r11.getAppointToast();
            if (r12 == null) goto L6;
        L7:
            SkuViewModel.access$displayToast(r0, r12);
            return;
        L6:
            r12 = "";
            goto L7
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ SkuViewModel a;

        public h(SkuViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            Throwable r11 = (Throwable) r10;
            SkuViewModel r12 = this.a;
            SkuViewModel.access$displayToast(r12, SkuViewModel.access$getString(r12, 2131914027));
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ SkuViewModel a;

        public i(SkuViewModel r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            cf.t r0 = this.a.getSkuLiveService();     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.a(SkuViewModel.access$getCheckPayNotificationTickListener$p(this.a));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public j(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            Function1 r0 = this.a;
            r0.invoke((SkuCheckPayNotificationResponse) r10);
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public k(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            Function1 r0 = this.a;
            r0.invoke((SkuCheckPayNotificationResponse) r10);
        }
    }

    public static final class l<T> implements Consumer {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
        }

        public final void accept(Object r10) {
            ECExceptionMonitor.f((Throwable) r10, "sku_check_pay_notification_error");
        }
    }

    public static final class m<T> implements Consumer {
        public static final m a = null;

        static {
            a = new m();
        }

        public m() {
        }

        public final void accept(Object r10) {
            ECExceptionMonitor.f((Throwable) r10, "sku_check_pay_notification_error");
        }
    }

    public static final class n implements q83.a {
        public final /* synthetic */ SkuViewModel a;

        public n(SkuViewModel r1) {
            this.a = r1;
        }

        public final boolean onTick(long r10) {
            SkuViewModel r11 = this.a;
            SkuViewModel.access$setMCheckPayNotificationTick$p(r11, SkuViewModel.access$getMCheckPayNotificationTick$p(r11) + 1);
            if (SkuViewModel.access$getMCheckPayNotificationTick$p(this.a) < SkuViewModel.access$getMCheckPayNotificationNextTick$p(this.a)) goto L5;
            SkuViewModel.access$setMCheckPayNotificationTick$p(this.a, 0);
            SkuViewModel.checkPayNotification$default(this.a, false, null, 2, null);
        L5:
            return true;
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ SkuViewModel a;

        public o(SkuViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            CommonSkusUpdateResponse r11 = (CommonSkusUpdateResponse) r10;
            if (r11.getStatusCode() != 0) goto L31;
            SkuInfoVO r0 = (SkuInfoVO) this.a.getSkuInfo().a();
            Map<String, UpdateSkuVO> r12 = r11.getSkusUpdateInfo();
            if (r12 == null) goto L16;
            Iterator<Map.Entry<String, UpdateSkuVO>> r13 = r12.entrySet().iterator();
        L8:
            if (r13.hasNext() == false) goto L16;
            Map.Entry<String, UpdateSkuVO> r1 = r13.next();
            if (r0 == null) goto L8;
            Map<String, SkuItemInfoVO> r14 = r0.getSkuList();
            if (r14 == null) goto L8;
            SkuItemInfoVO r15 = r14.get(r1.getKey());
            if (r15 == null) goto L8;
            r15.setButtonTip(r1.getValue().getButtonTip());
            r15.setPromiseType(r1.getValue().getPromiseType());
        L16:
            rg.a r16 = (rg.a) this.a.getOnItemChange().a();
            ButtonTipComponent r17 = null;
            if (r16 == null) goto L19;
            String r18 = (String) r16.b;
        L20:
            if (r0 == null) goto L24;
            Map<String, SkuItemInfoVO> r19 = r0.getSkuList();
            if (r19 == null) goto L24;
            SkuItemInfoVO r20 = r19.get(r18);
        L25:
            if (r20 == null) goto L27;
            this.a.getCurrentButtonTip().e(r20.getButtonTip());
            return;
        L27:
            QLiveData<ButtonTipComponent> r21 = this.a.getCurrentButtonTip();
            if (r0 == null) goto L30;
            r17 = r0.getButtonTipComponent();
        L30:
            r21.e(r17);
            return;
        L24:
            r20 = null;
            goto L25
        L19:
            r18 = null;
            goto L20
        L31:
            Lazy r22 = SkuLog.a;
            SkuLog.a("SkuViewModel", "commonSkuUpdate statusCode:" + r11.getStatusCode() + ',' + r11.getStatusMsg());
        }
    }

    public static final class p<T> implements Consumer {
        public static final p a = null;

        static {
            a = new p();
        }

        public p() {
        }

        public final void accept(Object r10) {
            Lazy r0 = SkuLog.a;
            SkuLog.a("SkuViewModel", String.valueOf(((Throwable) r10).getMessage()));
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ SkuViewModel a;

        public q(SkuViewModel r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v11, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r8v12, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r8v35, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r8v45, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r8v8, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r8v9, types: [java.util.Collection] */
        public final void accept(Object r15) {
            SkuInfoResponseDTO r16 = (SkuInfoResponseDTO) r15;
            String r10 = "";
            String r11 = null;
            if (r16.getStatusCode() == 0) goto L5;
        L146:
            this.a.getLoadStatus().g(new rg.b(LoadingStatus.ERROR, r16.getStatusCode()));
            Map<String, com.bytedance.android.ec.common.impl.sku.monitor.a> r0 = com.bytedance.android.ec.common.impl.sku.monitor.a.f;
            com.bytedance.android.ec.common.impl.sku.monitor.a r1 = com.bytedance.android.ec.common.impl.sku.monitor.a.C0119a.a(this.a.getSkuParams().getMonitorId());
            if (r1 == null) goto L173;
            SkuViewModel r12 = this.a;
            Intrinsics.checkNotNullParameter(r12, "viewModel");
            Intrinsics.checkNotNullParameter(r16, "response");
            r1.a.getClass();
            SkuApiMonitor.a(r12, r16, null);
            r1.b.a(false);
            r1.c.a(false);
            r1.d.a(false);
            r1.e.getClass();
            Intrinsics.checkNotNullParameter(r16, "response");
            Set<String> r13 = ECProcessMonitor.a;
            com.bytedance.android.ec.core.monitor.listener.e r14 = ECProcessMonitor.p();
            Pair<String, String>[] r17 = new Pair[1];
            LogPbData r18 = r16.getLogPb();
            if (r18 == null) goto L151;
            r11 = r18.getImprId();
        L151:
            if (r11 == null) goto L154;
            r10 = r11;
        L154:
            r17[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LOG_ID, r10);
            r14.b(r17);
            ECProcessMonitor.p().j(Integer.valueOf(r16.getStatusCode()), r16.getStatusMsg());
            return;
        L173:
            return;
        L5:
            if (r16.getSkus() == null) goto L146;
            SkuViewModel r19 = this.a;
            Map<String, String> r20 = r16.getSmallPic();
            List<SpecInfo> r21 = r16.getSpecList();
            if (r21 == null) goto L9;
            SpecInfo r22 = (SpecInfo) CollectionsKt.first(r21);
        L10:
            SkuViewModel.access$initSkuSpecStatus(r19, r20, r22);
            SkuViewModel.access$initSkuTradeModeStatus(this.a, r16.getTradeModeComponent());
            List r23 = this.a.getSkuParams().getBenefitLabels();
            if (r23 == null) goto L16;
            Iterator<T> r24 = r23.iterator();
        L14:
            if (r24.hasNext() == false) goto L16;
            ((PromotionBenefitLabel) r24.next()).setTextStyle(r16.getBenefitLabelTextStyle());
        L16:
            this.a.getSkuInfo().g(cg.f.d(r16));
            this.a.getLoadStatus().g(new rg.b(LoadingStatus.SUCCESS, 0));
            if (this.a.getInstallmentOriginalVisibility() != null) goto L31;
            SkuViewModel r25 = this.a;
            SkuInstallmentItemInfo r26 = r16.getInstallmentInfo();
            if (r26 == null) goto L29;
            SkuTermInfo r27 = r26.getTermInfo();
            if (r27 == null) goto L29;
            if (Intrinsics.areEqual(r27.getShowFlag(), Boolean.TRUE) == false) goto L29;
            List<SkuTermInfoItem> r28 = r27.getItemList();
            if (r28 == null) goto L29;
            if ((!r28.isEmpty()) != true) goto L29;
            boolean r29 = true;
        L30:
            r25.setInstallmentOriginalVisibility(Boolean.valueOf(r29));
        L29:
            r29 = false;
        L31:
            this.a.getTermCountList().clear();
            List r30 = this.a.getTermCountList();
            SkuInstallmentItemInfo r31 = r16.getInstallmentInfo();
            if (r31 == null) goto L48;
            SkuTermInfo r32 = r31.getTermInfo();
            if (r32 == null) goto L48;
            if (Intrinsics.areEqual(r32.getShowFlag(), Boolean.TRUE) == true) goto L39;
            r32 = null;
        L39:
            if (r32 == null) goto L48;
            List<SkuTermInfoItem> r33 = r32.getItemList();
            if (r33 == null) goto L48;
            List r34 = new ArrayList();
            Iterator<T> r35 = r33.iterator();
        L44:
            if (r35.hasNext() == false) goto L49;
            Integer r36 = ((SkuTermInfoItem) r35.next()).getTermCount();
            if (r36 == null) goto L44;
            r34.add(r36);
        L49:
            r30.addAll(r34);
            SkuViewModel r37 = this.a;
            SkuInstallmentItemInfo r38 = r16.getInstallmentInfo();
            if (r38 == null) goto L70;
            SkuTermInfo r39 = r38.getTermInfo();
            if (r39 == null) goto L70;
            if (Intrinsics.areEqual(r39.getShowFlag(), Boolean.TRUE) == true) goto L57;
            r39 = null;
        L57:
            if (r39 == null) goto L70;
            List<SkuTermInfoItem> r40 = r39.getItemList();
            if (r40 == null) goto L70;
            Iterator<T> r41 = r40.iterator();
        L62:
            if (r41.hasNext() == false) goto L66;
            T r42 = r41.next();
            if (Intrinsics.areEqual(((SkuTermInfoItem) r42).getShowTopTag(), Boolean.TRUE) == false) goto L62;
        L67:
            SkuTermInfoItem r43 = r42;
            if (r43 == null) goto L70;
            Integer r44 = r43.getTermCount();
        L71:
            r37.setRecommendTermCount(String.valueOf(r44));
            this.a.getVoucherList().clear();
            List r45 = this.a.getVoucherList();
            SkuInstallmentItemInfo r46 = r16.getInstallmentInfo();
            if (r46 == null) goto L88;
            SkuTermInfo r47 = r46.getTermInfo();
            if (r47 == null) goto L88;
            if (Intrinsics.areEqual(r47.getShowFlag(), Boolean.TRUE) == true) goto L79;
            r47 = null;
        L79:
            if (r47 == null) goto L88;
            List<SkuTermInfoItem> r48 = r47.getItemList();
            if (r48 == null) goto L88;
            List r49 = new ArrayList();
            Iterator<T> r50 = r48.iterator();
        L84:
            if (r50.hasNext() == false) goto L89;
            SkuTermInfoItem r51 = (SkuTermInfoItem) r50.next();
            String r52 = r51.getTermCount() + ':' + r51.getServiceLabel();
            if (r52 == null) goto L84;
            r49.add(r52);
        L89:
            r45.addAll(r49);
            SkuViewModel r53 = this.a;
            SkuInstallmentItemInfo r54 = r16.getInstallmentInfo();
            if (r54 == null) goto L96;
            SkuTermInfo r55 = r54.getTermInfo();
            if (r55 == null) goto L96;
            Boolean r56 = r55.getShowFlag();
            if (r56 == null) goto L96;
            boolean r57 = r56.booleanValue();
        L97:
            r53.setShowFlag(r57);
            SkuViewModel r58 = this.a;
            Pair<String, String>[] r59 = new Pair[1];
            SkuInfoVO r60 = (SkuInfoVO) r58.getSkuInfo().a();
            if (r60 == null) goto L100;
            Long r61 = r60.getDiscountPrice();
        L101:
            String r62 = "1";
            if (r61 == null) goto L104;
            Object r63 = "1";
        L105:
            r59[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_AVL_DISCOUNT, r63);
            r58.appendEventParams(r59);
            LinkedHashMap r64 = new LinkedHashMap();
            SkuInfoVO r65 = (SkuInfoVO) this.a.getSkuInfo().a();
            if (r65 == null) goto L110;
            SkuInstallmentItemInfo r66 = r65.getInstallmentInfo();
            if (r66 == null) goto L110;
            SkuDiscountInfo r67 = r66.getDiscountInfo();
        L111:
            if (r67 == null) goto L113;
            Boolean r68 = r67.getShowFlag();
        L115:
            if (Intrinsics.areEqual(r68, Boolean.TRUE) == true) goto L117;
        L119:
            r62 = "0";
        L120:
            Pair<String, String> r69 = TuplesKt.to("show_dou_campaign", r62);
            this.a.appendEventParams(new Pair[]{r69});
            r64.put(r69.getFirst(), r69.getSecond());
            String r70 = r16.getLogExtra();
            if (r70 == null) goto L129;
            JSONObject r71 = jg.g.f(r70);
            if (r71 == null) goto L129;
            Iterator<String> r72 = r71.keys();
        L126:
            if (r72.hasNext() == false) goto L129;
            String r73 = r72.next();
            String r110 = r71.optString(r73);
            this.a.appendEventParams(new Pair[]{TuplesKt.to(r73, r110)});
            r64.put(r73, r110);
        L129:
            if ((!r64.isEmpty()) == false) goto L131;
            this.a.getSkuParams().setTransmissibleJson(z1.d(this.a.getSkuParams().getTransmissibleJson(), r64));
        L131:
            SkuParams r74 = this.a.getSkuParams();
            LogPbData r75 = r16.getLogPb();
            if (r75 == null) goto L134;
            String r76 = r75.getImprId();
        L135:
            if (r76 != null) goto L137;
            r76 = "";
        L137:
            r74.setSkuLogId(r76);
            SkuViewModel.access$setPresellDelayDay$p(this.a, r16.getPresellDelayDay());
            SkuViewModel.access$setDeliveryDelayDay$p(this.a, r16.getDeliveryDelayDay());
            Map<String, com.bytedance.android.ec.common.impl.sku.monitor.a> r77 = com.bytedance.android.ec.common.impl.sku.monitor.a.f;
            com.bytedance.android.ec.common.impl.sku.monitor.a r78 = com.bytedance.android.ec.common.impl.sku.monitor.a.C0119a.a(this.a.getSkuParams().getMonitorId());
            if (r78 == null) goto L171;
            Intrinsics.checkNotNullParameter(r16, "response");
            r78.b.a(true);
            r78.c.a(true);
            r78.d.a(true);
            r78.e.getClass();
            Intrinsics.checkNotNullParameter(r16, "response");
            Set<String> r79 = ECProcessMonitor.a;
            com.bytedance.android.ec.core.monitor.listener.e r80 = ECProcessMonitor.p();
            Pair<String, String>[] r81 = new Pair[1];
            LogPbData r111 = r16.getLogPb();
            if (r111 == null) goto L142;
            r11 = r111.getImprId();
        L142:
            if (r11 == null) goto L145;
            r10 = r11;
        L145:
            r81[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LOG_ID, r10);
            r80.b(r81);
            return;
        L171:
            return;
        L134:
            r76 = null;
            goto L135
        L117:
            if (jg.g.a(r67.getDiscountDesc()) == false) goto L119;
        L113:
            r68 = null;
        L110:
            r67 = null;
            goto L111
        L104:
            r63 = "0";
            goto L105
        L100:
            r61 = null;
        L96:
            r57 = false;
        L88:
            r49 = CollectionsKt.emptyList();
            goto L89
        L66:
            r42 = (T) null;
        L70:
            r44 = null;
        L48:
            r34 = CollectionsKt.emptyList();
            goto L49
        L9:
            r22 = null;
            goto L10
        }
    }

    public static final class r<T> implements Consumer {
        public final /* synthetic */ SkuViewModel a;

        public r(SkuViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            Throwable r11 = (Throwable) r10;
            this.a.getLoadStatus().g(new rg.b(LoadingStatus.ERROR, 0));
            ECExceptionMonitor.e(r11);
            Map<String, com.bytedance.android.ec.common.impl.sku.monitor.a> r0 = com.bytedance.android.ec.common.impl.sku.monitor.a.f;
            com.bytedance.android.ec.common.impl.sku.monitor.a r1 = com.bytedance.android.ec.common.impl.sku.monitor.a.C0119a.a(this.a.getSkuParams().getMonitorId());
            if (r1 == null) goto L6;
            SkuViewModel r12 = this.a;
            Intrinsics.checkNotNullParameter(r12, "viewModel");
            Intrinsics.checkNotNullParameter(r11, "throwable");
            r1.a.getClass();
            SkuApiMonitor.a(r12, null, r11);
            r1.b.a(false);
            r1.c.a(false);
            r1.d.a(false);
            r1.e.getClass();
            Intrinsics.checkNotNullParameter(r11, "throwable");
            Set<String> r13 = ECProcessMonitor.a;
            ECProcessMonitor.p().j(-1, r11.getMessage());
            return;
        }
    }

    public static final class s<T> implements Consumer {
        public final /* synthetic */ SkuViewModel a;
        public final /* synthetic */ String b;

        public s(SkuViewModel r1, String r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void accept(Object r10) {
            SkuInstallmentItemResponse r11 = (SkuInstallmentItemResponse) r10;
            if (r11.getStatusCode() != 0) goto L10;
            SkuInstallmentItemInfo r0 = r11.getInstallmentInfo();
            if (r0 == null) goto L9;
            Map r1 = (Map) SkuViewModel.access$getInstallmentInfoMap$p(this.a).get();
            if (r1 == null) goto L9;
            SkuInstallmentItemInfo r12 = (SkuInstallmentItemInfo) r1.put(this.b, r0);
        L9:
            this.a.getValidInstallmentInfo().g(r11.getInstallmentInfo());
            return;
        L10:
            SkuViewModel r13 = this.a;
            SkuViewModel.access$displayToast(r13, SkuViewModel.access$getString(r13, 2131914027));
        }
    }

    public static final class t<T> implements Consumer {
        public final /* synthetic */ SkuViewModel a;

        public t(SkuViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            Throwable r11 = (Throwable) r10;
            SkuViewModel r12 = this.a;
            SkuViewModel.access$displayToast(r12, SkuViewModel.access$getString(r12, 2131914027));
        }
    }

    public static final class u implements SpecItemGroupLayout.c {
        public final /* synthetic */ SkuViewModel a;

        @Override // com.bytedance.android.ec.common.impl.sku.view.SpecItemGroupLayout.c
        public final List<String> L0() {
            return this.a.getImageUrlList();
        }

        @Override // com.bytedance.android.ec.common.impl.sku.view.SpecItemGroupLayout.c
        public final cg.g M0() {
            return SkuViewModel.access$getSkuStock$p(this.a);
        }

        @Override // com.bytedance.android.ec.common.impl.sku.view.SpecItemGroupLayout.c
        public final List<String> N0() {
            return this.a.getFirstSkuIdList();
        }

        @Override // com.bytedance.android.ec.common.impl.sku.view.SpecItemGroupLayout.c
        public final List<String> O0() {
            return this.a.getBigImageUrlList();
        }

        @Override // com.bytedance.android.ec.common.impl.sku.view.SpecItemGroupLayout.c
        public final List<String> getNameList() {
            return this.a.getNameListSpec();
        }

        public u(SkuViewModel r1) {
            this.a = r1;
        }
    }

    public static final class v implements SpecItemOptimizeGroupLayout.c {
        public v() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SkuViewModel() {
        Object[] r1 = 0 == true ? 1 : 0;
        super(null, r1, 3, 0 == true ? 1 : 0);
        this.skuInfo = new QLiveData();
        this.skuParams = new SkuParams(null, null, null, null, null, 0, null, null, null, false, false, null, null, false, "", "", null, false, null, null, null, null, null, null, null, false, 0, 101, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, false, false, null, null, null, null, 0.0f, null, null, null, null, null, null, null, null, null, null, null, null, 0, "SkuViewModel", null, null, null, null, null, false, null, null, null, null, null, null, null, 0, 0, false, null, null, null, false, null, null, null, null, null, null, null, null, -134266881, -1, -257, 31, null);
        this.first = true;
        this.currentAvatar = new QLiveData();
        this.currentStock = new QLiveData();
        this.currentPrice = new QLiveData();
        this.highLightUncheckSpec = new QLiveData();
        this.firstUnCheckSpecY = new QLiveData();
        this.currentCount = new QLiveData();
        this.upperLimit = new QLiveData();
        this.lowerLimit = new QLiveData();
        this.limitText = new QLiveData();
        this.stockDesc = new QLiveData();
        this.currentBenefitLabel = new QLiveData();
        this.currentCarAdaptComponent = new QLiveData();
        this.imageSpecSelectIndex = new QLiveData();
        this.checkedNames = new QLiveData();
        this.unCheckedName = new QLiveData();
        this.closeDialogFragment = new QLiveData();
        this.hideDialogFragment = new QLiveData();
        this.doAddCartMotionAction = new QLiveData();
        this.cancelDownTimer = new QLiveData();
        this.termCountList = new ArrayList();
        this.recommendTermCount = "";
        this.voucherList = new ArrayList();
        this.validInstallmentInfo = new QLiveData();
        this.currentDouInstallmentItem = new QLiveData();
        this.installmentInfoMap = new WeakReference(new HashMap());
        this.currentInstallmentIndex = -1;
        this.currentTradeModeIndex = new QLiveData();
        this.currentTradeModeItem = new QLiveData();
        this.currentButtonTip = new QLiveData();
        this.halfCloseSku = 1;
        this.displayToast = new QLiveData();
        this.loadStatus = new QLiveData();
        this.applyCouponSuccess = new QLiveData();
        this.saveState = new QLiveData();
        this.selectPoiInfo = new QLiveData();
        this.lastBehaviorBeforeDismiss = com.bytedance.android.ec.core.event.a.VALUE_OTHERS;
        this.currentSecondPriceIsReducePrice = Boolean.FALSE;
        this.currentAtmosphereStyle = new QLiveData();
        this.scrollViewScrollY = new QLiveData();
        this.showServiceCodeList = new ArrayList();
        int r10 = o73.a.a;
        this.skuShowSessionId = UUID.randomUUID().toString();
        this.skuPageState = new ul.f();
        this.currentJumpUrl = "";
        this.checkPayNotificationSkuId = "";
        this.checkPayNotificationAction = new QLiveData();
        this.checkPayNotificationTickListener = new n(this);
        this.repository = new SkuRepository();
        this.onItemChange = new QLiveData();
        this.imageUrlList = new ArrayList();
        this.bigImageUrlList = new ArrayList();
        this.nameListSpec = new ArrayList();
        this.firstSkuIdList = new ArrayList();
        this.skuStockData = new u(this);
        this.skuStockDataOptimize = new v();
        this.skuNextTimeChangeCallbacks = new ArrayList();
        this.isFirstUpdate = true;
    }

    private final String getSearchParams() {
        JSONObject r0 = getEntranceInfoJson(this.skuParams.getEntranceInfo());
        if (r0 == null) goto L5;
        String r1 = r0.optString(com.bytedance.android.ec.core.event.a.KEY_SEARCH_PARAM, "");
    L7:
        if (TextUtils.isEmpty(r1) == true) goto L10;
        return r1;
    L10:
        if (this.skuParams.getSearchParams() == null) goto L13;
        return this.skuParams.getSearchParams();
    L13:
        return (String) this.skuParams.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_SEARCH_PARAM);
    L5:
        r1 = null;
        goto L7
    }

    private final SkuItemInfoVO getSelectSkuInfo() {
        SkuInfoVO r0 = (SkuInfoVO) this.skuInfo.a();
        if (r0 == null) goto L26;
        Map<String, SkuItemInfoVO> r1 = r0.getSkuList();
        if (r1 == null) goto L26;
        List<String> r10 = this.checkedIdArray;
        Intrinsics.checkNotNullParameter("0", "placeholder");
        Intrinsics.checkNotNullParameter("_", "linkSymbol");
        StringBuilder r11 = new StringBuilder();
        if (r10 == null) goto L17;
        Iterator<T> r12 = r10.iterator();     // Catch: Exception -> L23
    L10:
        if (r12.hasNext() == false) goto L17;
        Object r13 = r12.next();     // Catch: Exception -> L23
        if (r13 != null) goto L14;
        r11.append("0");     // Catch: Exception -> L23
    L15:
        r11.append("_");     // Catch: Exception -> L23
        goto L10
    L14:
        r11.append(r13.toString());     // Catch: Exception -> L23
    L23:
        e = move-exception;
        ECExceptionMonitor.f(e, IHostStyleUIDepend.TOAST_TYPE_ERROR);
    L33:
        return r1.get(r11.toString());
    L17:
        if (r11.length() <= 0) goto L19;
        boolean r14 = true;
    L20:
        if (r14 == false) goto L33;
        r11.deleteCharAt(r11.length() - 1);     // Catch: Exception -> L23
        goto L33
    L19:
        r14 = false;
    L26:
        return null;
    }

    private final String getSkuPanelModel() {
        if (this.currentSpecShowBigPicMode == false) goto L6;
        return "big_pic_noprice";
    L6:
        if (this.currentSpecHasPic == false) goto L12;
        if (this.currentSpecHasPrice == false) goto L10;
        return "small_pic_price";
    L10:
        return "small_pic_noprice";
    L12:
        if (this.currentSpecHasPrice == false) goto L14;
        return "small_nopic_price";
    L14:
        return "small_nopic_noprice";
    }

    private final void initDefaultSelectParams() {
        SkuRestoreState r0 = this.skuParams.getSkuState();
        Long r1 = null;
        if (r0 == null) goto L5;
        String r10 = r0.getSelectedSkuId();
    L6:
        SkuRestoreState r11 = this.skuParams.getSkuState();
        if (r11 == null) goto L9;
        r1 = Long.valueOf(r11.getProductCount());
    L9:
        if (r10 == null) goto L18;
        if (r1 == null) goto L19;
        long r12 = r1.longValue();
        SkuParams r13 = this.skuParams;
        DefaultSelect r14 = r13.getDefaultSelect();
        if (r14 == null) goto L15;
        DefaultSelect r15 = DefaultSelect.copy$default(r14, null, null, r10, Long.valueOf(r12), false, false, 51, null);
        if (r15 == null) goto L15;
    L16:
        r13.setDefaultSelect(r15);
        return;
    L15:
        r15 = new DefaultSelect(null, null, r10, Long.valueOf(r12), false, false, 51, null);
        goto L16
    L19:
        return;
    L18:
        return;
    L5:
        r10 = null;
        goto L6
    }

    private final void initEventParams() {
        Pair[] r0 = new Pair[19];
        r0[0] = TuplesKt.to("sku_scene_type", String.valueOf(this.skuParams.getSceneType()));
        r0[1] = TuplesKt.to("sku_action_type", String.valueOf(this.skuParams.getActionType()));
        String r10 = "live";
        String r11 = null;
        if (this.skuParams.isLiveSkuCheck() == false) goto L5;
        Object r1 = "live";
    L6:
        r0[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTER_FROM, r1);
        r0[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, this.skuParams.getRoomId());
        r0[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTER_METHOD, this.skuParams.getEnterMethod());
        r0[5] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ANCHOR_ID, this.skuParams.getAuthorId());
        r0[6] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTER_FROM_MERGE, this.skuParams.getEnterFromMerge());
        r0[7] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SOURCE_PAGE, this.skuParams.getSourcePage());
        r0[8] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, this.skuParams.getEcomEntranceForm());
        r0[9] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, this.skuParams.getEcomGroupType());
        if (this.skuParams.isLiveSkuCheck() == true) goto L10;
        r10 = null;
    L10:
        r0[10] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PARAM_LIVE_PLATFROM, r10);
        r0[11] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_GROUP_ID, this.skuParams.getItemId());
        r0[12] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, this.skuParams.getPromotionId());
        r0[13] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID, this.skuParams.getProductId());
        r0[14] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, this.skuParams.getCommodityType());
        r0[15] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SEARCH_PARAM, getSearchParams());
        JSONObject r12 = getEntranceInfoJson(this.skuParams.getEntranceInfo());
        if (r12 == null) goto L13;
        String r13 = r12.optString(com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE, "");
    L14:
        r0[16] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE, r13);
        JSONObject r14 = getEntranceInfoJson(this.skuParams.getEntranceInfo());
        if (r14 == null) goto L17;
        r11 = r14.optString(com.bytedance.android.ec.core.event.a.KEY_IS_PACKAGE_SALE, "");
    L17:
        r0[17] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_PACKAGE_SALE, r11);
        boolean r15 = ECServiceManager.a;
        if (((IECHostService) ECServiceManager.c(IECHostService.class)).getIECHostUserService().isLogin() == false) goto L20;
        String r16 = "1";
    L21:
        r0[18] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_AUTH, r16);
        HashMap r17 = MapsKt.hashMapOf(r0);
        r17.putAll(this.skuParams.getEventParams());
        r17.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, this.skuParams.getEntranceInfo());
        Unit r18 = Unit.INSTANCE;
        initEventContext(r17);
        String r19 = this.skuParams.getTransmissibleJson();
        if (r19 == null) goto L30;
        JSONObject r20 = jg.g.f(r19);
        if (r20 == null) goto L30;
        Map<String, String> r21 = new LinkedHashMap();
        Iterator<String> r22 = r20.keys();
    L27:
        if (r22.hasNext() == false) goto L29;
        String r23 = r22.next();
        r21.put(r23, r20.optString(r23));
        goto L27
    L29:
        appendEventParams(r21);
    L30:
        SkuExtraData r24 = this.skuParams.getSkuExtraData();
        if (r24 == null) goto L44;
        String r25 = r24.getTransitionTrackerData();
        if (r25 == null) goto L45;
        JSONObject r26 = jg.g.f(r25);
        if (r26 == null) goto L46;
        Map<String, String> r27 = new LinkedHashMap();
        Iterator<String> r28 = r26.keys();
    L38:
        if (r28.hasNext() == false) goto L40;
        String r29 = r28.next();
        r27.put(r29, r26.optString(r29));
        goto L38
    L40:
        appendEventParams(r27);
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L20:
        r16 = "0";
        goto L21
    L13:
        r13 = null;
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    private final boolean needShowAddCartMotion() {
        if (this.skuParams.isFromLiveRoom() == false) goto L17;
        int r0 = ECSdk.a;
        cf.l r1 = (cf.l) ECSdk.a(cf.l.class);
        if (r1 == null) goto L7;
        View r10 = r1.Ia();
    L8:
        if (r10 != null) goto L15;
        cf.l r11 = (cf.l) ECSdk.a(cf.l.class);
        if (r11 == null) goto L12;
        float[] r12 = r11.Pa();
    L13:
        if (r12 == null) goto L17;
    L12:
        r12 = null;
    L15:
        if (StringsKt.contains$default(this.skuParams.getMethod(), "live_list_search", false, 2, null) == true) goto L17;
        boolean r13 = true;
    L18:
        if (r13 == false) goto L20;
        return true;
    L20:
        if (this.skuParams.isFromVideoFeed() == false) goto L24;
        if (this.skuParams.getAddToastType() != 0) goto L24;
        return true;
    L24:
        if (this.skuParams.isFromMallFeed() == true) goto L30;
        return false;
    L30:
        return true;
    L7:
        r10 = null;
    L17:
        r13 = false;
        goto L18
    }

    private final void updateAddress() {
        int r0 = ECSdk.a;
        IAddressService r1 = (IAddressService) ECSdk.a(IAddressService.class);
        if (r1 == null) goto L14;
        WeakReference<Object> r10 = this.btmNodeRef;
        if (r10 == null) goto L7;
        Object r11 = r10.get();
    L8:
        o83.a r12 = IAddressService.a.a(r1, r11, "a1.b5267.c0.d0", 4);
        if (r12 == null) goto L15;
        String r13 = r12.a(true, null, null).toString();
        if (r13 == null) goto L16;
        this.skuParams.setAddressDetail(r13);
        return;
    L16:
        return;
    L15:
        return;
    L7:
        r11 = null;
        goto L8
    }

    public final void appointNoStock() {
        com.bytedance.android.ec.common.impl.sku.repository.a r0 = this.repository;
        String r1 = this.skuParams.getProductId();
        String r10 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r11 = com.bytedance.android.ec.sdk.helper.d.b.getIECHostAppInfo().getAppId();
        if (r11 != null) goto L8;
        r11 = "";
    L8:
        SkuInfoVO r12 = (SkuInfoVO) this.skuInfo.a();
        String r13 = null;
        if (r12 == null) goto L11;
        String r14 = r12.getProductExtra();
    L12:
        if (r14 != null) goto L14;
        r14 = "";
    L14:
        SkuItemInfoVO r15 = getSelectSkuInfo();
        if (r15 == null) goto L17;
        r13 = r15.getSkuExtra();
    L17:
        if (r13 == null) goto L20;
        r10 = r13;
    L20:
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(r0.c(r1, r11, r14, r10)).subscribe(new g(this), new h(this)), this);
        return;
    L11:
        r14 = null;
        goto L12
    }

    public final long getCurrentCount() {
        Long r0 = (Long) this.currentCount.a();
        if (r0 == null) goto L6;
        return r0.longValue();
    L6:
        return getDefaultCountLimit();
    }

    public final long getCurrentPrice() {
        Long r0 = (Long) this.currentPrice.a();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.longValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getCurrentPromiseType() {
        SkuInfoVO r0 = (SkuInfoVO) this.skuInfo.a();
        rg.a r1 = (rg.a) this.onItemChange.a();
        if (r1 == null) goto L5;
        String r10 = (String) r1.b;
    L6:
        if (r0 == null) goto L10;
        Map<String, SkuItemInfoVO> r11 = r0.getSkuList();
        if (r11 == null) goto L10;
        SkuItemInfoVO r12 = r11.get(r10);
    L11:
        if (r12 != null) goto L13;
        return null;
    L13:
        return r12.getPromiseType();
    L10:
        r12 = null;
        goto L11
    L5:
        r10 = null;
        goto L6
    }

    public final long getLowerLimit() {
        SkuLimit r0 = (SkuLimit) this.lowerLimit.a();
        if (r0 == null) goto L6;
        return r0.getCount();
    L6:
        return getDefaultCountLimit();
    }

    public final String getPreviousPage() {
        String r0 = this.previousPage;
        if (r0 == null) goto L6;
        if (r0 == null) goto L19;
        return r0;
    L19:
        return "";
    L6:
        String r1 = this.skuParams.getEntranceInfo();
        if (r1 != null) goto L17;
        r1 = null;
    L12:
        this.previousPage = r1;
        if (r1 == null) goto L19;
        return r1;
    L17:
        new JSONObject(r1).optString(com.bytedance.android.ec.core.event.a.KEY_PREVIOUS_PAGE, "");
    L10:
        Unit r10 = Unit.INSTANCE;
        goto L12
    }

    /* JADX INFO: renamed from: getSkuInfo, reason: collision with other method in class */
    public final void m1030getSkuInfo() {
        com.bytedance.android.ec.common.impl.sku.utils.k.a r0 = com.bytedance.android.ec.common.impl.sku.utils.k.a;
        String r1 = this.skuParams.getPromotionId();
        Intrinsics.checkNotNullParameter(r1, "promotionId");
        com.bytedance.android.ec.common.impl.sku.utils.l r10 = com.bytedance.android.ec.common.impl.sku.utils.k.a.get(r1);
        SkuParams r11 = this.skuParams;
        if (r10 != null) goto L5;
    L7:
        int r12 = 2;
    L8:
        r11.setSpecMode(r12);
        SkuParams r13 = this.skuParams;
        if (r10 == null) goto L11;
        long r14 = r10.b;
    L12:
        r13.setSpecModeTime(Long.valueOf(r14 / ((long) IServerListener.WHAT_BYTELINK_SINK_ERROR)));
        updateAddress();
        Map<String, com.bytedance.android.ec.common.impl.sku.monitor.a> r15 = com.bytedance.android.ec.common.impl.sku.monitor.a.f;
        com.bytedance.android.ec.common.impl.sku.monitor.a r16 = com.bytedance.android.ec.common.impl.sku.monitor.a.C0119a.a(this.skuParams.getMonitorId());
        if (r16 == null) goto L15;
        com.bytedance.android.ec.common.impl.sku.monitor.b r17 = r16.b;
        r17.getClass();
        Map<String, com.bytedance.android.ec.core.monitor.a> r18 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.h(r17.b.getMonitorId(), MetricNames.API_DURATION, null);
        r16.c.getClass();
        com.bytedance.android.ec.core.monitor.k.e("request_start");
    L15:
        this.loadStatus.g(new rg.b(LoadingStatus.LOADING, 0));
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(this.repository.d(this.skuParams)).subscribe(new q(this), new r(this)), this);
        return;
    L11:
        r14 = 0;
        goto L12
    L5:
        if (r10.a != true) goto L7;
        r12 = 1;
        goto L8
    }

    public final void getSkuInstallmentInfo() {
        String r1 = this.skuParams.getPromotionId() + "_" + this.skuParams.getProductId() + "_" + this.selectedSkuId + "_" + getCurrentCount() + "_" + getCurrentPrice();
        Map<String, SkuInstallmentItemInfo> r10 = this.installmentInfoMap.get();
        if (r10 == null) goto L7;
        SkuInstallmentItemInfo r11 = r10.get(r1);
        if (r11 == null) goto L7;
        this.validInstallmentInfo.g(r11);
        return;
    L7:
        String r12 = this.skuParams.getRoomId();
        if (r12 != null) goto L10;
    L13:
        boolean r13 = true;
    L14:
        if (r13 == false) goto L16;
        String r14 = "0";
    L17:
        String r15 = r14;
        com.bytedance.android.ec.common.impl.sku.repository.a r16 = this.repository;
        String r17 = this.skuParams.getPromotionId();
        String r18 = this.skuParams.getProductId();
        if (r18 != null) goto L20;
        r18 = "";
    L20:
        String r19 = this.selectedSkuId;
        if (r19 != null) goto L23;
        r19 = "";
    L23:
        long r20 = getCurrentCount();
        long r21 = getCurrentPrice();
        String r110 = this.skuParams.getAuthorId();
        String r111 = this.skuParams.getSecAuthorId();
        SkuExtraData r112 = this.skuParams.getSkuExtraData();
        if (r112 == null) goto L26;
        String r113 = r112.getMarketChannel();
    L27:
        if (r113 != null) goto L29;
        r113 = "";
    L29:
        JSONObject r114 = jg.g.f(this.skuParams.getEntranceInfo());
        if (r114 == null) goto L32;
        String r115 = r114.optString(com.bytedance.android.ec.core.event.a.KEY_ECOM_SCENE_ID);
    L33:
        if (r115 != null) goto L35;
        r115 = "";
    L35:
        this.skuParams.getSceneType();
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(r16.e(r17, r18, r19, r20, r21, r110, r111, r113, r115, r15)).subscribe(new s(this, r1), new t(this)), this);
        return;
    L32:
        r115 = null;
        goto L33
    L26:
        r113 = null;
        goto L27
    L16:
        r14 = this.skuParams.getRoomId();
        Intrinsics.checkNotNull(r14);
        goto L17
    L10:
        if (r12.length() == 0) goto L13;
        r13 = false;
        goto L14
    }

    public final cg.h getSpecTitleEntryEventStruct() {
        SkuInfoVO r0 = (SkuInfoVO) this.skuInfo.a();
        if (r0 == null) goto L26;
        ClothesSizeAssistantStruct r10 = r0.getClothesSizeAssistant();
        Boolean r11 = null;
        if (r10 == null) goto L8;
        Integer r12 = r10.getAbTest();
    L9:
        if (r12 != null) goto L12;
    L13:
        ClothesSizeAssistantStruct r1 = r0.getClothesSizeAssistant();
        if (r1 == null) goto L16;
        r11 = r1.getHasSizeComponent();
    L16:
        cg.h r13 = new cg.h(Intrinsics.areEqual(r11, Boolean.TRUE) ? 1 : 0, 14);
    L27:
        return r13;
    L12:
        if (r12.intValue() != 2) goto L13;
        Boolean r14 = r0.getClothesSizeAssistant().isSupportClothesSizeRecommend();
        Boolean r15 = Boolean.TRUE;
        if (Intrinsics.areEqual(r14, r15) == false) goto L22;
        r13 = new cg.h(0, 1, Intrinsics.areEqual(r0.getClothesSizeAssistant().isFillUserClothesSize(), r15) ? 1 : 0, a2.b(r0.getClothesSizeAssistant().getRecommendClothesSize()) ? 1 : 0);
        goto L27
    L22:
        if (Intrinsics.areEqual(r0.getClothesSizeAssistant().getHasSizeComponent(), r15) == false) goto L25;
        return new cg.h(1, 12);
    L25:
        return new cg.h(0, 15);
    L8:
        r12 = null;
        goto L9
    L26:
        return new cg.h(0, 15);
    }

    public final long getUpperLimit() {
        SkuLimit r0 = (SkuLimit) this.upperLimit.a();
        if (r0 != null) goto L7;
        return Long.MAX_VALUE;
    L7:
        return r0.getCount();
    }

    public final boolean isSizeTabExist() {
        SkuInfoVO r0 = (SkuInfoVO) this.skuInfo.a();
        if (r0 == null) goto L26;
        List<SpecInfo> r1 = r0.getSpecInfoList();
        if (r1 == null) goto L27;
        List<SpecInfo> r10 = r1;
        if ((r10 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r11 = r10.iterator();
    L13:
        if (r11.hasNext() == false) goto L29;
        if (((SpecInfo) r11.next()).getSizeComponent() == null) goto L17;
        boolean r12 = true;
    L18:
        if (r12 == false) goto L13;
        return true;
    L17:
        r12 = false;
        goto L18
    L29:
        return false;
    L9:
        if (r10.isEmpty() == false) goto L11;
        return false;
    L27:
        return false;
    L26:
        return false;
    }

    public final void logAdEvent() {
        Function2<? super SkuParams, ? super Long, Unit> r0 = this.adLogCallBack;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke(this.skuParams, Long.valueOf(getCurrentPrice()));
        return;
    }

    public final void logChooseSkuCompleteEvent() {
        Pair[] r10 = new Pair[4];
        Integer r0 = this.isDelayedDispatch;
        if (r0 != null) goto L6;
    L8:
        String r1 = "0";
    L9:
        r10[0] = TuplesKt.to("is_delayed_dispatch", r1);
        Integer r11 = this.isDelayedDispatch;
        String r12 = "";
        if (r11 != null) goto L13;
    L20:
        if (r11 != null) goto L23;
    L28:
        r10[1] = TuplesKt.to("delayed_dispatch_date", r12);
        SkuItemInfoVO r13 = getSelectSkuInfo();
        if (r13 == null) goto L37;
        List<SkuBottomButtons> r14 = r13.getButtons();
        if (r14 == null) goto L37;
        List<SkuBottomButtons> r15 = r14;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r17 = r15.iterator();
    L34:
        if (r17.hasNext() == false) goto L36;
        r16.add(Integer.valueOf(((SkuBottomButtons) r17.next()).getButtonType()));
        goto L34
    L36:
        String r18 = CollectionsKt.joinToString$default(r16, ",", null, null, 0, null, null, 62, null);
    L38:
        r10[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_STATUS, r18);
        r10[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, this.comboId);
        doSkuEventAction$default(this, "click_product_params_complete", r10, null, null, null, 28, null);
        return;
    L37:
        r18 = null;
        goto L38
    L23:
        if (r11.intValue() != 1) goto L28;
        Integer r19 = this.presellDelayDay;
        if (r19 == null) goto L28;
        String r20 = String.valueOf(r19.intValue());
        if (r20 == null) goto L28;
    L19:
        r12 = r20;
        goto L28
    L13:
        if (r11.intValue() != 0) goto L20;
        Integer r21 = this.deliveryDelayDay;
        if (r21 == null) goto L28;
        r20 = String.valueOf(r21.intValue());
        if (r20 != null) goto L19;
    L6:
        if (r0.intValue() != 1) goto L8;
        r1 = "1";
        goto L9
    }

    public final void notifySkuChanged() {
        if (this.skuNextTimeChangeCallbacks.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.skuNextTimeChangeCallbacks.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((Runnable) r0.next()).run();
        goto L7
    L9:
        this.skuNextTimeChangeCallbacks.clear();
    }

    public final void resetFxhParams() {
        this.termCountList.clear();
        this.voucherList.clear();
        this.recommendTermCount = "";
        this.selectFxhMethod = null;
        this.currentDouInstallmentItem.g(null);
        this.validInstallmentInfo.g(null);
        Map<String, SkuInstallmentItemInfo> r0 = this.installmentInfoMap.get();
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        this.currentInstallmentIndex = -1;
    }

    public final void saveAddCartGuideInfo() {
        SkuInfoVO r0 = (SkuInfoVO) this.skuInfo.a();
        if (r0 == null) goto L5;
        SkuAddCartGuideInfo r1 = r0.getAddCartGuideInfo();
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        Integer r10 = r1.getGuideType();
        int r11 = 1;
        if (r10 != null) goto L12;
    L14:
        SkuLimit r12 = (SkuLimit) this.lowerLimit.a();
        if (r12 == null) goto L17;
        r11 = (int) r12.getCount();
    L17:
        Integer r13 = r1.getCountQuota();
        if (r13 == null) goto L20;
        int r14 = r13.intValue();
    L21:
        if (r11 > r14) goto L26;
        SkuRestoreState r15 = this.skuPanelState;
        if (r15 == null) goto L27;
        r15.saveAddCartGuideInfo(r1.getGuideType(), r1.getGuideText());
        return;
    L27:
        return;
    L26:
        return;
    L20:
        r14 = 0;
        goto L21
    L12:
        if (r10.intValue() != 1) goto L14;
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final long getDefaultCountLimit() {
        if (com.bytedance.android.ec.core.abtest.d.E() == false) goto L5;
        return 0;
    L5:
        return 1;
    }

    public final boolean isGroupBuy() {
        SkuItemInfoVO r0 = getSelectSkuInfo();
        if (r0 != null) goto L12;
        SkuInfoVO r1 = (SkuInfoVO) this.skuInfo.a();
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.isGroupBuyDefault() != true) goto L10;
        return true;
    L12:
        return r0.isGroupBuy();
    }

    public final boolean isInActivity() {
        if (isInSecKill() == false) goto L5;
    L10:
        return true;
    L5:
        if (isInPreSecKill() == true) goto L10;
        if (isGroupBuy() == true) goto L10;
        return false;
    }

    public final boolean isInDepositPresale() {
        SkuItemInfoVO r0 = getSelectSkuInfo();
        if (r0 != null) goto L12;
        SkuInfoVO r1 = (SkuInfoVO) this.skuInfo.a();
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.isInDepositPresaleDefault() != true) goto L10;
        return true;
    L12:
        return r0.isInDepositPresale();
    }

    public final boolean isInPreSecKill() {
        SkuItemInfoVO r0 = getSelectSkuInfo();
        if (r0 != null) goto L12;
        SkuInfoVO r1 = (SkuInfoVO) this.skuInfo.a();
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.isInPreSecKillDefault() != true) goto L10;
        return true;
    L12:
        return r0.isInPreSecKill();
    }

    public final boolean isInSecKill() {
        SkuItemInfoVO r0 = getSelectSkuInfo();
        if (r0 != null) goto L12;
        SkuInfoVO r1 = (SkuInfoVO) this.skuInfo.a();
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.isInSecKillDefault() != true) goto L10;
        return true;
    L12:
        return r0.isInSecKill();
    }

    @Override // com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel
    public void onCleared() {
        super.onCleared();
        Disposable r0 = this.updateJob;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final String getApplyCouponIds() {
        return this.applyCouponIds;
    }

    public final QLiveData<rg.a<Triple<String, sc3.b, String>>> getApplyCouponSuccess() {
        return this.applyCouponSuccess;
    }

    public final List<String> getBigImageUrlList() {
        return this.bigImageUrlList;
    }

    public final Boolean getCanAddCart() {
        return this.canAddCart;
    }

    public final QLiveData<Boolean> getCancelDownTimer() {
        return this.cancelDownTimer;
    }

    public final Function1<SkuCartResult, Unit> getCartListener() {
        return this.cartListener;
    }

    public final String getCartSelectedDes() {
        return this.cartSelectedDes;
    }

    public final QLiveData<com.bytedance.android.ec.model.response.p> getCheckPayNotificationAction() {
        return this.checkPayNotificationAction;
    }

    public final String getCheckPayNotificationSkuId() {
        return this.checkPayNotificationSkuId;
    }

    public final boolean getCheckSkuPromotionFailed() {
        return this.checkSkuPromotionFailed;
    }

    public final List<String> getCheckedIdArray() {
        return this.checkedIdArray;
    }

    public final QLiveData<String> getCheckedNames() {
        return this.checkedNames;
    }

    public final boolean getClickCountUnConsumed() {
        return this.clickCountUnConsumed;
    }

    public final QLiveData<rg.a<Function0<Unit>>> getCloseDialogFragment() {
        return this.closeDialogFragment;
    }

    public final String getComboId() {
        return this.comboId;
    }

    public final QLiveData<Integer> getCurrentAtmosphereStyle() {
        return this.currentAtmosphereStyle;
    }

    public final QLiveData<String> getCurrentAvatar() {
        return this.currentAvatar;
    }

    public final QLiveData<List<PromotionBenefitLabel>> getCurrentBenefitLabel() {
        return this.currentBenefitLabel;
    }

    public final QLiveData<ButtonTipComponent> getCurrentButtonTip() {
        return this.currentButtonTip;
    }

    public final String getCurrentCampainPriceHeader() {
        return this.currentCampainPriceHeader;
    }

    public final Integer getCurrentCampainPriceHeaderStyle() {
        return this.currentCampainPriceHeaderStyle;
    }

    public final QLiveData<CarAdaptComponent> getCurrentCarAdaptComponent() {
        return this.currentCarAdaptComponent;
    }

    public final long getCurrentDiscountPrice() {
        return this.currentDiscountPrice;
    }

    public final String getCurrentDiscountPriceText() {
        return this.currentDiscountPriceText;
    }

    public final QLiveData<SkuTermInfoItem> getCurrentDouInstallmentItem() {
        return this.currentDouInstallmentItem;
    }

    public final Long getCurrentFirstPrice() {
        return this.currentFirstPrice;
    }

    public final Boolean getCurrentFirstPriceIsUnderline() {
        return this.currentFirstPriceIsUnderline;
    }

    public final String getCurrentFirstPricePrefix() {
        return this.currentFirstPricePrefix;
    }

    public final String getCurrentFirstPriceSuffix() {
        return this.currentFirstPriceSuffix;
    }

    public final String getCurrentFirstPriceSupplement() {
        return this.currentFirstPriceSupplement;
    }

    public final Long getCurrentHotMaxPrice() {
        return this.currentHotMaxPrice;
    }

    public final Long getCurrentHotMinPrice() {
        return this.currentHotMinPrice;
    }

    public final String getCurrentHotPricePrefix() {
        return this.currentHotPricePrefix;
    }

    public final String getCurrentHotPriceSupplement() {
        return this.currentHotPriceSupplement;
    }

    public final int getCurrentInstallmentIndex() {
        return this.currentInstallmentIndex;
    }

    public final String getCurrentJumpUrl() {
        return this.currentJumpUrl;
    }

    public final String getCurrentNewBonusText() {
        return this.currentNewBonusText;
    }

    public final long getCurrentOriginPrice() {
        return this.currentOriginPrice;
    }

    public final String getCurrentOriginPriceSupplement() {
        return this.currentOriginPriceSupplement;
    }

    public final int getCurrentPos() {
        return this.currentPos;
    }

    public final Long getCurrentPriceType() {
        return this.currentPriceType;
    }

    public final long getCurrentPriceWithDefault() {
        return this.currentPriceWithDefault;
    }

    public final Long getCurrentRegularPrice() {
        return this.currentRegularPrice;
    }

    public final Boolean getCurrentRegularPriceIsUnderline() {
        return this.currentRegularPriceIsUnderline;
    }

    public final String getCurrentRegularPricePrefix() {
        return this.currentRegularPricePrefix;
    }

    public final String getCurrentRegularPriceSuffix() {
        return this.currentRegularPriceSuffix;
    }

    public final String getCurrentRegularPriceSupplement() {
        return this.currentRegularPriceSupplement;
    }

    public final Long getCurrentSecondPrice() {
        return this.currentSecondPrice;
    }

    public final Boolean getCurrentSecondPriceIsReducePrice() {
        return this.currentSecondPriceIsReducePrice;
    }

    public final Boolean getCurrentSecondPriceIsUnderline() {
        return this.currentSecondPriceIsUnderline;
    }

    public final String getCurrentSecondPricePrefix() {
        return this.currentSecondPricePrefix;
    }

    public final String getCurrentSecondPriceSuffix() {
        return this.currentSecondPriceSuffix;
    }

    public final String getCurrentSecondPriceSupplement() {
        return this.currentSecondPriceSupplement;
    }

    public final boolean getCurrentSpecHasPic() {
        return this.currentSpecHasPic;
    }

    public final boolean getCurrentSpecHasPrice() {
        return this.currentSpecHasPrice;
    }

    public final boolean getCurrentSpecShowBigPicMode() {
        return this.currentSpecShowBigPicMode;
    }

    public final QLiveData<Long> getCurrentStock() {
        return this.currentStock;
    }

    public final QLiveData<Integer> getCurrentTradeModeIndex() {
        return this.currentTradeModeIndex;
    }

    public final QLiveData<TradeModeSelection> getCurrentTradeModeItem() {
        return this.currentTradeModeItem;
    }

    public final QLiveData<rg.a<String>> getDisplayToast() {
        return this.displayToast;
    }

    public final QLiveData<rg.a<Unit>> getDoAddCartMotionAction() {
        return this.doAddCartMotionAction;
    }

    public final Function1<String, Unit> getFinishPlaybackPageListener() {
        return this.finishPlaybackPageListener;
    }

    public final boolean getFirst() {
        return this.first;
    }

    public final List<String> getFirstIdList() {
        return this.firstIdList;
    }

    public final List<String> getFirstSkuIdList() {
        return this.firstSkuIdList;
    }

    public final QLiveData<Integer> getFirstUnCheckSpecY() {
        return this.firstUnCheckSpecY;
    }

    public final int getHalfCloseSku() {
        return this.halfCloseSku;
    }

    public final boolean getHasRefreshDetailInfo() {
        return this.hasRefreshDetailInfo;
    }

    public final QLiveData<rg.a<Function0<Unit>>> getHideDialogFragment() {
        return this.hideDialogFragment;
    }

    public final QLiveData<Boolean> getHighLightUncheckSpec() {
        return this.highLightUncheckSpec;
    }

    public final List<String> getImageList() {
        return this.imageList;
    }

    public final QLiveData<Integer> getImageSpecSelectIndex() {
        return this.imageSpecSelectIndex;
    }

    public final List<String> getImageUrlList() {
        return this.imageUrlList;
    }

    public final Boolean getInstallmentOriginalVisibility() {
        return this.installmentOriginalVisibility;
    }

    public final String getLastBehaviorBeforeDismiss() {
        return this.lastBehaviorBeforeDismiss;
    }

    public final QLiveData<String> getLimitText() {
        return this.limitText;
    }

    public final QLiveData<rg.b> getLoadStatus() {
        return this.loadStatus;
    }

    public final List<String> getNameList() {
        return this.nameList;
    }

    public final List<String> getNameListSpec() {
        return this.nameListSpec;
    }

    public final QLiveData<rg.a<String>> getOnItemChange() {
        return this.onItemChange;
    }

    public final Function0<String> getPromotionListEntranceInfo() {
        return this.promotionListEntranceInfo;
    }

    public final String getRecommendTermCount() {
        return this.recommendTermCount;
    }

    public final Function1<SkuProductDetailInfo, Unit> getRefreshDetailInfoCallback() {
        return this.refreshDetailInfoCallback;
    }

    public final QLiveData<rg.a<Boolean>> getSaveState() {
        return this.saveState;
    }

    public final QLiveData<Integer> getScrollViewScrollY() {
        return this.scrollViewScrollY;
    }

    public final String getSelectFxhMethod() {
        return this.selectFxhMethod;
    }

    public final QLiveData<ProductSelectPoiInfo> getSelectPoiInfo() {
        return this.selectPoiInfo;
    }

    public final boolean getSelectTradeIn() {
        return this.selectTradeIn;
    }

    public final String getSelectedSkuId() {
        return this.selectedSkuId;
    }

    public final boolean getShowFlag() {
        return this.showFlag;
    }

    public final String getShowLogisticsCode() {
        return this.showLogisticsCode;
    }

    public final List<String> getShowServiceCodeList() {
        return this.showServiceCodeList;
    }

    public final Map<String, String> getShowTrackParams() {
        return this.showTrackParams;
    }

    public final Function1<SkuCheckResult, Unit> getSkuCheckResultCallback() {
        return this.skuCheckResultCallback;
    }

    public final cf.t getSkuLiveService() {
        return this.skuLiveService;
    }

    public final ul.f getSkuPageState() {
        return this.skuPageState;
    }

    public final SkuRestoreState getSkuPanelState() {
        return this.skuPanelState;
    }

    public final SkuParams getSkuParams() {
        return this.skuParams;
    }

    public final String getSkuShowSessionId() {
        return this.skuShowSessionId;
    }

    public final SpecItemGroupLayout.c getSkuStockData() {
        return this.skuStockData;
    }

    public final SpecItemOptimizeGroupLayout.c getSkuStockDataOptimize() {
        return this.skuStockDataOptimize;
    }

    public final QLiveData<String> getStockDesc() {
        return this.stockDesc;
    }

    public final List<Integer> getTermCountList() {
        return this.termCountList;
    }

    public final String getTradeBenefitId() {
        return this.tradeBenefitId;
    }

    public final String getTradeBenefitText() {
        return this.tradeBenefitText;
    }

    public final QLiveData<String> getUnCheckedName() {
        return this.unCheckedName;
    }

    public final QLiveData<SkuInstallmentItemInfo> getValidInstallmentInfo() {
        return this.validInstallmentInfo;
    }

    public final List<String> getVoucherList() {
        return this.voucherList;
    }

    public final Integer isDelayedDispatch() {
        return this.isDelayedDispatch;
    }

    public final boolean isExistSizeTab() {
        return this.isExistSizeTab;
    }

    public final boolean isTradeIn() {
        return this.isTradeIn;
    }

    /* JADX INFO: renamed from: getCurrentCount, reason: collision with other method in class */
    public final QLiveData<Long> m1027getCurrentCount() {
        return this.currentCount;
    }

    /* JADX INFO: renamed from: getCurrentPrice, reason: collision with other method in class */
    public final QLiveData<Long> m1028getCurrentPrice() {
        return this.currentPrice;
    }

    /* JADX INFO: renamed from: getLowerLimit, reason: collision with other method in class */
    public final QLiveData<SkuLimit> m1029getLowerLimit() {
        return this.lowerLimit;
    }

    public final QLiveData<SkuInfoVO> getSkuInfo() {
        return this.skuInfo;
    }

    /* JADX INFO: renamed from: getUpperLimit, reason: collision with other method in class */
    public final QLiveData<SkuLimit> m1031getUpperLimit() {
        return this.upperLimit;
    }

    public static final /* synthetic */ com.bytedance.android.ec.model.response.p access$getCheckPayNotification$p(SkuViewModel r0) {
        return r0.checkPayNotification;
    }

    public static final /* synthetic */ q83.a access$getCheckPayNotificationTickListener$p(SkuViewModel r0) {
        return r0.checkPayNotificationTickListener;
    }

    public static final /* synthetic */ Integer access$getDeliveryDelayDay$p(SkuViewModel r0) {
        return r0.deliveryDelayDay;
    }

    public static final /* synthetic */ WeakReference access$getInstallmentInfoMap$p(SkuViewModel r0) {
        return r0.installmentInfoMap;
    }

    public static final /* synthetic */ int access$getMCheckPayNotificationNextTick$p(SkuViewModel r0) {
        return r0.mCheckPayNotificationNextTick;
    }

    public static final /* synthetic */ int access$getMCheckPayNotificationTick$p(SkuViewModel r0) {
        return r0.mCheckPayNotificationTick;
    }

    public static final /* synthetic */ Integer access$getPresellDelayDay$p(SkuViewModel r0) {
        return r0.presellDelayDay;
    }

    public static final /* synthetic */ SkuItemInfoVO access$getSelectSkuInfo(SkuViewModel r0) {
        return r0.getSelectSkuInfo();
    }

    public static final /* synthetic */ cg.g access$getSkuStock$p(SkuViewModel r0) {
        return r0.skuStock;
    }

    public static final /* synthetic */ boolean access$needShowAddCartMotion(SkuViewModel r0) {
        return r0.needShowAddCartMotion();
    }

    private final void displayToast(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r10 = null;
    L10:
        if (r10 == null) goto L14;
        this.displayToast.g(new rg.a(r10));
        return;
    L14:
        return;
    L6:
        r0 = false;
        goto L7
    }

    private final void doPdpStandardMonitor(String r1) {
        com.bytedance.android.ec.core.monitor.k.e(r1);
    }

    private final JSONObject getEntranceInfoJson(String r10) {
        if (r10 == null) goto L10;
        return new JSONObject(r10);
    L11:
        return null;
    L10:
        return null;
    }

    private final String getString(int r10) {
        Activity r0 = ECAppInfoService.e.getCurrentActivity();
        if (r0 != null) goto L7;
        return null;
    L7:
        return th.a.g(r0, r10);
    }

    private final void initSkuStock(SkuInfoVO r10) {
        Map<String, SkuItemInfoVO> r11 = r10.getSkuList();
        Map<String, String> r12 = r10.getPictureMap();
        Intrinsics.checkNotNull(r12);
        this.skuStock = new cg.g(null, r11, r12, r10.getBigPicMap(), r10.getUpperLimit(), r10.getLowerLimit(), r10.getLimitText());
    }

    private final void initSkuTradeModeStatus(TradeModeComponent r10) {
        if (r10 == null) goto L27;
        List r11 = r10.getSelections();
        if (r11 == null) goto L28;
        Iterator r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L17;
        Object r0 = r12.next();
        Integer r13 = ((TradeModeSelection) r0).getType();
        if (r13 != null) goto L12;
    L14:
        boolean r14 = false;
    L15:
        if (r14 == false) goto L7;
    L18:
        TradeModeSelection r1 = (TradeModeSelection) r0;
        if (r1 == null) goto L29;
        this.isTradeIn = true;
        this.tradeBenefitId = String.valueOf(r1.getBenefitType());
        this.tradeBenefitText = r1.getSubContent();
        return;
    L29:
        return;
    L12:
        if (r13.intValue() != 2) goto L14;
        r14 = true;
        goto L15
    L17:
        r0 = null;
        goto L18
    L28:
        return;
    }

    private final APIAction itemContainsUpdate(SkuInfoVO r10) {
        Object r0 = null;
        if (r10 == null) goto L19;
        UpdateActionOption r11 = r10.getUpdateActionOption();
        if (r11 == null) goto L20;
        List<APIAction> r12 = r11.getActions();
        if (r12 == null) goto L21;
        Iterator<T> r13 = r12.iterator();
    L10:
        if (r13.hasNext() == false) goto L15;
        Object r1 = r13.next();
        if (Intrinsics.areEqual(((APIAction) r1).getActionType(), "selectedWithCountChanged") == false) goto L10;
        r0 = r1;
    L15:
        return (APIAction) r0;
    L21:
        return null;
    L20:
        return null;
    L19:
        return null;
    }

    private final void showErrorToast(String r10) {
        boolean r1 = true;
        if (this.skuParams.getEnableAddCartFailToastForSchema() == false) goto L5;
    L6:
        if (r10 != null) goto L8;
    L15:
        r10 = getString(2131913776);
    L16:
        displayToast(r10);
        return;
    L8:
        if (r10.length() > 0) goto L11;
        r1 = false;
    L11:
        if (r1 == true) goto L14;
        r10 = null;
    L14:
        if (r10 != null) goto L16;
    L5:
        if (this.skuParams.getStandardAddCartToastType() == 1) goto L6;
    }

    public final void cancelQueryPromotionCheckPayNotification(boolean r10) {
        this.mCheckPayNotificationTick = 0;
        this.checkPayNotification = null;
        this.checkPayNotificationSkuId = "";
        if (r10 == false) goto L5;
        new Handler().post(new i(this));
        return;
    L5:
        cf.t r11 = this.skuLiveService;
        if (r11 == null) goto L10;
        r11.a(this.checkPayNotificationTickListener);
        return;
    }

    public final void closeDialogFragment(Integer r10) {
        if (r10 == null) goto L4;
        r10.intValue();
        ul.f r0 = this.skuPageState;
        r0.a = r10.intValue();
    L4:
        this.closeDialogFragment.g(new rg.a(null));
        Map<String, SkuInstallmentItemInfo> r11 = this.installmentInfoMap.get();
        if (r11 == null) goto L8;
        r11.clear();
        return;
    }

    public final void hideDialogFragment(Function0<Unit> r10) {
        this.hideDialogFragment.g(new rg.a(r10));
    }

    public final boolean isPresaleSkuSpec(int r10) {
        SkuInfoVO r0 = (SkuInfoVO) this.skuInfo.a();
        if (r0 == null) goto L11;
        List<SpecInfo> r1 = r0.getSpecInfoList();
        if (r1 == null) goto L11;
        SpecInfo r11 = (SpecInfo) CollectionsKt.getOrNull(r1, r10);
        if (r11 == null) goto L11;
        if (r11.getSpecType() != 1) goto L11;
        return true;
    L11:
        return false;
    }

    public final void registerSkuNextChangeCallback(Runnable r10) {
        Intrinsics.checkNotNullParameter(r10, "runnable");
        this.skuNextTimeChangeCallbacks.add(r10);
    }

    public final void setApplyCouponIds(String r1) {
        this.applyCouponIds = r1;
    }

    public final void setCanAddCart(Boolean r1) {
        this.canAddCart = r1;
    }

    public final void setCartListener(Function1<? super SkuCartResult, Unit> r1) {
        this.cartListener = r1;
    }

    public final void setCartSelectedDes(String r1) {
        this.cartSelectedDes = r1;
    }

    public final void setCheckPayNotificationSkuId(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.checkPayNotificationSkuId = r10;
    }

    public final void setCheckSkuPromotionFailed(boolean r1) {
        this.checkSkuPromotionFailed = r1;
    }

    public final void setCheckedIdArray(List<String> r1) {
        this.checkedIdArray = r1;
    }

    public final void setClickCountUnConsumed(boolean r1) {
        this.clickCountUnConsumed = r1;
    }

    public final void setComboId(String r1) {
        this.comboId = r1;
    }

    public final void setCurrentCampainPriceHeader(String r1) {
        this.currentCampainPriceHeader = r1;
    }

    public final void setCurrentCampainPriceHeaderStyle(Integer r1) {
        this.currentCampainPriceHeaderStyle = r1;
    }

    public final void setCurrentDiscountPrice(long r1) {
        this.currentDiscountPrice = r1;
    }

    public final void setCurrentDiscountPriceText(String r1) {
        this.currentDiscountPriceText = r1;
    }

    public final void setCurrentFirstPrice(Long r1) {
        this.currentFirstPrice = r1;
    }

    public final void setCurrentFirstPriceIsUnderline(Boolean r1) {
        this.currentFirstPriceIsUnderline = r1;
    }

    public final void setCurrentFirstPricePrefix(String r1) {
        this.currentFirstPricePrefix = r1;
    }

    public final void setCurrentFirstPriceSuffix(String r1) {
        this.currentFirstPriceSuffix = r1;
    }

    public final void setCurrentFirstPriceSupplement(String r1) {
        this.currentFirstPriceSupplement = r1;
    }

    public final void setCurrentHotMaxPrice(Long r1) {
        this.currentHotMaxPrice = r1;
    }

    public final void setCurrentHotMinPrice(Long r1) {
        this.currentHotMinPrice = r1;
    }

    public final void setCurrentHotPricePrefix(String r1) {
        this.currentHotPricePrefix = r1;
    }

    public final void setCurrentHotPriceSupplement(String r1) {
        this.currentHotPriceSupplement = r1;
    }

    public final void setCurrentInstallmentIndex(int r1) {
        this.currentInstallmentIndex = r1;
    }

    public final void setCurrentJumpUrl(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.currentJumpUrl = r10;
    }

    public final void setCurrentNewBonusText(String r1) {
        this.currentNewBonusText = r1;
    }

    public final void setCurrentOriginPrice(long r1) {
        this.currentOriginPrice = r1;
    }

    public final void setCurrentOriginPriceSupplement(String r1) {
        this.currentOriginPriceSupplement = r1;
    }

    public final void setCurrentPos(int r1) {
        this.currentPos = r1;
    }

    public final void setCurrentPriceType(Long r1) {
        this.currentPriceType = r1;
    }

    public final void setCurrentPriceWithDefault(long r1) {
        this.currentPriceWithDefault = r1;
    }

    public final void setCurrentRegularPrice(Long r1) {
        this.currentRegularPrice = r1;
    }

    public final void setCurrentRegularPriceIsUnderline(Boolean r1) {
        this.currentRegularPriceIsUnderline = r1;
    }

    public final void setCurrentRegularPricePrefix(String r1) {
        this.currentRegularPricePrefix = r1;
    }

    public final void setCurrentRegularPriceSuffix(String r1) {
        this.currentRegularPriceSuffix = r1;
    }

    public final void setCurrentRegularPriceSupplement(String r1) {
        this.currentRegularPriceSupplement = r1;
    }

    public final void setCurrentSecondPrice(Long r1) {
        this.currentSecondPrice = r1;
    }

    public final void setCurrentSecondPriceIsReducePrice(Boolean r1) {
        this.currentSecondPriceIsReducePrice = r1;
    }

    public final void setCurrentSecondPriceIsUnderline(Boolean r1) {
        this.currentSecondPriceIsUnderline = r1;
    }

    public final void setCurrentSecondPricePrefix(String r1) {
        this.currentSecondPricePrefix = r1;
    }

    public final void setCurrentSecondPriceSuffix(String r1) {
        this.currentSecondPriceSuffix = r1;
    }

    public final void setCurrentSecondPriceSupplement(String r1) {
        this.currentSecondPriceSupplement = r1;
    }

    public final void setCurrentSpecHasPic(boolean r1) {
        this.currentSpecHasPic = r1;
    }

    public final void setCurrentSpecHasPrice(boolean r1) {
        this.currentSpecHasPrice = r1;
    }

    public final void setCurrentSpecShowBigPicMode(boolean r1) {
        this.currentSpecShowBigPicMode = r1;
    }

    public final void setCurrentTradeModeIndex(QLiveData<Integer> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.currentTradeModeIndex = r10;
    }

    public final void setDelayedDispatch(Integer r1) {
        this.isDelayedDispatch = r1;
    }

    public final void setExistSizeTab(boolean r1) {
        this.isExistSizeTab = r1;
    }

    public final void setFinishPlaybackPageListener(Function1<? super String, Unit> r1) {
        this.finishPlaybackPageListener = r1;
    }

    public final void setFirst(boolean r1) {
        this.first = r1;
    }

    public final void setFirstIdList(List<String> r1) {
        this.firstIdList = r1;
    }

    public final void setHalfCloseSku(int r1) {
        this.halfCloseSku = r1;
    }

    public final void setHasRefreshDetailInfo(boolean r1) {
        this.hasRefreshDetailInfo = r1;
    }

    public final void setImageList(List<String> r1) {
        this.imageList = r1;
    }

    public final void setInstallmentOriginalVisibility(Boolean r1) {
        this.installmentOriginalVisibility = r1;
    }

    public final void setLastBehaviorBeforeDismiss(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.lastBehaviorBeforeDismiss = r10;
    }

    public final void setNameList(List<String> r1) {
        this.nameList = r1;
    }

    public final void setPromotionListEntranceInfo(Function0<String> r1) {
        this.promotionListEntranceInfo = r1;
    }

    public final void setRecommendTermCount(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.recommendTermCount = r10;
    }

    public final void setRefreshDetailInfoCallback(Function1<? super SkuProductDetailInfo, Unit> r1) {
        this.refreshDetailInfoCallback = r1;
    }

    public final void setRegisteredBtmNode(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "btmNode");
        this.btmNodeRef = new WeakReference(r10);
    }

    public final void setSelectFxhMethod(String r1) {
        this.selectFxhMethod = r1;
    }

    public final void setSelectPoiInfo(QLiveData<ProductSelectPoiInfo> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.selectPoiInfo = r10;
    }

    public final void setSelectTradeIn(boolean r1) {
        this.selectTradeIn = r1;
    }

    public final void setSelectedSkuId(String r1) {
        this.selectedSkuId = r1;
    }

    public final void setShowFlag(boolean r1) {
        this.showFlag = r1;
    }

    public final void setShowLogisticsCode(String r1) {
        this.showLogisticsCode = r1;
    }

    public final void setShowServiceCodeList(List<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.showServiceCodeList = r10;
    }

    public final void setShowTrackParams(Map<String, String> r1) {
        this.showTrackParams = r1;
    }

    public final void setSkuCheckResultCallback(Function1<? super SkuCheckResult, Unit> r1) {
        this.skuCheckResultCallback = r1;
    }

    public final void setSkuLiveService(cf.t r1) {
        this.skuLiveService = r1;
    }

    public final void setSkuPanelState(SkuRestoreState r1) {
        this.skuPanelState = r1;
    }

    public final void setSkuParams(SkuParams r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.skuParams = r10;
    }

    public final void setTermCountList(List<Integer> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.termCountList = r10;
    }

    public final void setTradeBenefitId(String r1) {
        this.tradeBenefitId = r1;
    }

    public final void setTradeBenefitText(String r1) {
        this.tradeBenefitText = r1;
    }

    public final void setTradeIn(boolean r1) {
        this.isTradeIn = r1;
    }

    public final void setUnCheckedName(QLiveData<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.unCheckedName = r10;
    }

    public final void setVoucherList(List<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.voucherList = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateButtonTip(Function1<? super ButtonTipComponent, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "firstCallBack");
        SkuInfoVO r0 = (SkuInfoVO) this.skuInfo.a();
        rg.a r1 = (rg.a) this.onItemChange.a();
        ButtonTipComponent r11 = null;
        if (r1 == null) goto L5;
        String r12 = (String) r1.b;
    L6:
        if (r0 == null) goto L10;
        Map<String, SkuItemInfoVO> r13 = r0.getSkuList();
        if (r13 == null) goto L10;
        SkuItemInfoVO r14 = r13.get(r12);
    L12:
        if (this.isFirstUpdate == false) goto L20;
        if (r14 == null) goto L15;
        r10.invoke(r14.getButtonTip());
    L18:
        this.isFirstUpdate = false;
        return;
    L15:
        if (r0 == null) goto L17;
        r11 = r0.getButtonTipComponent();
    L17:
        r10.invoke(r11);
        goto L18
    L20:
        if (r14 == null) goto L27;
        APIAction r15 = itemContainsUpdate(r0);
        if (r15 != null) goto L24;
    L26:
        this.currentButtonTip.g(r14.getButtonTip());
        return;
    L24:
        if (this.clickCountUnConsumed == false) goto L26;
        this.clickCountUnConsumed = false;
        commonSkuUpdate(getCurrentCount(), r14, r15);
        return;
    L27:
        QLiveData<ButtonTipComponent> r16 = this.currentButtonTip;
        if (r0 == null) goto L30;
        r11 = r0.getButtonTipComponent();
    L30:
        r16.g(r11);
        return;
    L10:
        r14 = null;
        goto L12
    L5:
        r12 = null;
        goto L6
    }

    public final void updateCampaign(ul.j r10) {
        Intrinsics.checkNotNullParameter(r10, "updatedSkuPanelInfo");
        if (((SkuInfoVO) this.skuInfo.a()) != null) goto L6;
        return;
    L6:
        throw null;
    }

    public static final /* synthetic */ void access$displayToast(SkuViewModel r0, String r1) {
        r0.displayToast(r1);
    }

    public static final /* synthetic */ String access$getString(SkuViewModel r0, int r1) {
        return r0.getString(r1);
    }

    public static final /* synthetic */ void access$initSkuTradeModeStatus(SkuViewModel r0, TradeModeComponent r1) {
        r0.initSkuTradeModeStatus(r1);
    }

    public static final /* synthetic */ void access$setCheckPayNotification$p(SkuViewModel r0, com.bytedance.android.ec.model.response.p r1) {
        r0.checkPayNotification = r1;
    }

    public static final /* synthetic */ void access$setDeliveryDelayDay$p(SkuViewModel r0, Integer r1) {
        r0.deliveryDelayDay = r1;
    }

    public static final /* synthetic */ void access$setMCheckPayNotificationNextTick$p(SkuViewModel r0, int r1) {
        r0.mCheckPayNotificationNextTick = r1;
    }

    public static final /* synthetic */ void access$setMCheckPayNotificationTick$p(SkuViewModel r0, int r1) {
        r0.mCheckPayNotificationTick = r1;
    }

    public static final /* synthetic */ void access$setPresellDelayDay$p(SkuViewModel r0, Integer r1) {
        r0.presellDelayDay = r1;
    }

    public static final /* synthetic */ void access$setSkuStock$p(SkuViewModel r0, cg.g r1) {
        r0.skuStock = r1;
    }

    public static final /* synthetic */ void access$showErrorToast(SkuViewModel r0, String r1) {
        r0.showErrorToast(r1);
    }

    private final SkuParams appendEntranceInfoToSkuParams(SkuParams r10, String r11) {
        Map r0 = MapsKt.toMutableMap(r10.getEventParams());
        String r1 = EcomBcmTracker.b(PageFinder.via(r11), (String) r10.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO));
        if (r1 == null) goto L5;
        r0.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r1);
        r10.setEventParams(r0);
    L5:
        r10.setEntranceInfo(EcomBcmTracker.b(PageFinder.via(r11), r10.getEntranceInfo()));
        r10.setAddCartEntranceInfo(EcomBcmTracker.b(PageFinder.via(r11), r10.getAddCartEntranceInfo()));
        return r10;
    }

    private final void generateLargeImageUrlList(List<SpecInfo> r10, Map<String, String> r11) {
        List<SpecInfo> r0 = r10;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        this.firstSkuIdList.clear();
        this.imageUrlList.clear();
        this.bigImageUrlList.clear();
        this.nameListSpec.clear();
        this.nameListSpec.add("默认");
        String[] r12 = new String[r10.size()];
        List<String> r13 = this.imageUrlList;
        cg.g r14 = this.skuStock;
        if (r14 == null) goto L14;
        String r15 = r14.j(r12);
    L15:
        r13.add(r15);
        List<String> r16 = this.bigImageUrlList;
        cg.g r17 = this.skuStock;
        if (r17 == null) goto L18;
        String r18 = r17.h(r12);
    L19:
        r16.add(r18);
        List<SpecInfoItem> r19 = ((SpecInfo) ListProtector.get(r10, 0)).getSpecItems();
        if (r11 != null) goto L22;
    L24:
        Iterator<T> r20 = r19.iterator();
    L26:
        if (r20.hasNext() == false) goto L52;
        SpecInfoItem r21 = (SpecInfoItem) r20.next();
        r12[0] = r21.getId();
        cg.g r22 = this.skuStock;
        if (r22 == null) goto L30;
        boolean r23 = r22.a(r12);
    L31:
        if (r23 == false) goto L38;
        cg.g r24 = this.skuStock;
        if (r24 == null) goto L35;
        String r25 = r24.j(r12);
    L36:
        if (r25 == null) goto L38;
        boolean r26 = true;
    L39:
        if (r26 == false) goto L41;
        String[] r27 = r12;
    L42:
        if (r27 == null) goto L26;
        this.firstSkuIdList.add(r21.getId());
        this.nameListSpec.add(r21.getName());
        List<String> r28 = this.imageUrlList;
        cg.g r29 = this.skuStock;
        if (r29 == null) goto L46;
        String r30 = r29.j(r12);
    L47:
        r28.add(r30);
        List<String> r31 = this.bigImageUrlList;
        cg.g r32 = this.skuStock;
        if (r32 == null) goto L50;
        String r33 = r32.h(r12);
    L51:
        r31.add(r33);
        goto L26
    L50:
        r33 = null;
        goto L51
    L46:
        r30 = null;
        goto L47
    L41:
        r27 = null;
        goto L42
    L35:
        r25 = null;
    L38:
        r26 = false;
        goto L39
    L30:
        r23 = false;
        goto L31
    L52:
        return;
    L22:
        if (r11.size() != 0) goto L24;
        return;
    L18:
        r18 = null;
        goto L19
    L14:
        r15 = null;
        goto L15
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    private final void initSkuSpecStatus(Map<String, String> r10, SpecInfo r11) {
        String r0 = null;
        if (r11 == null) goto L5;
        Integer r1 = r11.getSpecMode();
    L6:
        boolean r12 = true;
        if (r1 != null) goto L10;
    L12:
        boolean r13 = false;
    L13:
        this.currentSpecShowBigPicMode = r13;
        if (r13 == false) goto L16;
    L15:
        r12 = false;
    L19:
        this.currentSpecHasPic = r12;
        if (r11 == null) goto L26;
        List<SpecInfoItem> r14 = r11.getSpecItems();
        if (r14 == null) goto L26;
        SpecInfoItem r15 = (SpecInfoItem) CollectionsKt.first(r14);
        if (r15 == null) goto L26;
        r0 = r15.getPrice();
    L26:
        this.currentSpecHasPrice = jg.g.a(r0);
        return;
    L16:
        if (r10 == null) goto L15;
        if (r10.isEmpty() == true) goto L15;
    L10:
        if (r1.intValue() != 1) goto L12;
        r13 = true;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void checkPayNotification(boolean r10, final String r11) {
        Function1<SkuCheckPayNotificationResponse, Unit> r12 = new SkuViewModel$checkPayNotification$successCallBack$1(this, r11);
        String r13 = this.selectedSkuId;
        if (r13 != null) goto L5;
    L14:
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(this.repository.checkPayNotification(this.skuParams.getPromotionId(), this.skuParams.getAuthorId(), this.skuParams.getSecAuthorId())).subscribe(new k(r12), m.a), this);
        return;
    L5:
        if (r13.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r13 = null;
    L11:
        if (r13 == null) goto L14;
        if (com.bytedance.android.ec.core.async.a.a(bg4.b.b(this.repository.checkSkuPayNotification(this.skuParams.getPromotionId(), r13, this.skuParams.getAuthorId(), this.skuParams.getSecAuthorId())).subscribe(new j(r12), l.a), this) == null) goto L14;
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final void doSkuErrorEventAction(String r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "errorType");
        Intrinsics.checkNotNullParameter(r15, "errorMsg");
        doSkuEventAction$default(this, "sku_error_monitor", new Pair[]{TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "Native_Android"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ERROR_TYPE, r14), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG, r15)}, null, null, null, 28, null);
        ECProcessMonitor.l("native_sku", r14, r14, com.bytedance.android.ec.hybrid.list.util.k.b(getBaseParams()), null, null, null, 228);
    }

    public static final /* synthetic */ void access$initSkuSpecStatus(SkuViewModel r0, Map r1, SpecInfo r10) {
        r0.initSkuSpecStatus(r1, r10);
    }

    private final void commonSkuUpdate(long r10, SkuItemInfoVO r11, APIAction r12) {
        if (r11 == null) goto L8;
        Disposable r13 = this.updateJob;
        if (r13 == null) goto L6;
        r13.dispose();
    L6:
        this.updateJob = this.repository.a(new CommonSkusUpdateRequest(r10, r12.getParam())).subscribeOn(Schedulers.io()).subscribe(new o(this), p.a);
        return;
    }

    public static /* synthetic */ void cancelQueryPromotionCheckPayNotification$default(SkuViewModel r0, boolean r1, int r10, Object r11) {
        if ((r10 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.cancelQueryPromotionCheckPayNotification(r1);
    }

    public static /* synthetic */ void closeDialogFragment$default(SkuViewModel r0, Integer r1, int r10, Object r11) {
        if ((r10 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.closeDialogFragment(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void hideDialogFragment$default(SkuViewModel r0, Function0 r1, int r10, Object r11) {
        if ((r10 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.hideDialogFragment(r1);
    }

    private final void sendAddCartSuccessEvent(String r10, String r11, String r12, Integer r13) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L17
        String r14 = new JSONObject(r10).optString("btm_show_id");     // Catch: Throwable -> L17
        int r1 = AddCartDirectlyHelper.a;     // Catch: Throwable -> L17
        LinkedHashMap r15 = new LinkedHashMap();     // Catch: Throwable -> L17
        String r16 = this.skuParams.getEntranceInfo();     // Catch: Throwable -> L17
        if (r16 == null) goto L5;
        r15.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r16);     // Catch: Throwable -> L17
    L5:
        SkuExtraData r17 = this.skuParams.getSkuExtraData();     // Catch: Throwable -> L17
        if (r17 == null) goto L15;
        Map r18 = r17.getAddCartTrackMeta();     // Catch: Throwable -> L17
        if (r18 == null) goto L15;
        Iterator r19 = r18.entrySet().iterator();     // Catch: Throwable -> L17
    L11:
        if (r19.hasNext() == false) goto L15;
        Map.Entry r20 = (Map.Entry) r19.next();     // Catch: Throwable -> L17
        if (r20.getValue() == null) goto L11;
        r15.put(r20.getKey(), r20.getValue());     // Catch: Throwable -> L17
    L15:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L17
        AddCartDirectlyHelper.h(r11, r14, r12, r13, r15);     // Catch: Throwable -> L17
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static /* synthetic */ void showErrorToast$default(SkuViewModel r0, String r1, int r10, Object r11) {
        if ((r10 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.showErrorToast(r1);
    }

    public static final /* synthetic */ void access$sendAddCartSuccessEvent(SkuViewModel r0, String r1, String r10, String r11, Integer r12) {
        r0.sendAddCartSuccessEvent(r1, r10, r11, r12);
    }

    public static /* synthetic */ void checkPayNotification$default(SkuViewModel r0, boolean r1, String r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        r0.checkPayNotification(r1, r10);
    }

    public final void applyCouponAuto(Context r25, sc3.b r26, String r27, String r28, Function1<? super String, Unit> r29) {
        Intrinsics.checkNotNullParameter(r25, "context");
        Intrinsics.checkNotNullParameter(r27, "orderUrl");
        Intrinsics.checkNotNullParameter(r28, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        if (r26 == null) goto L5;
        r26.c(ChainPoint.AUTO_COUPON_START, Long.valueOf(System.currentTimeMillis()));
    L5:
        Set<String> r0 = ECProcessMonitor.a;
        ECProcessMonitor.c("ec_sku", "/aweme/v2/shop/coupon/apply/auto/").d();
        Map<String, com.bytedance.android.ec.core.monitor.a> r1 = com.bytedance.android.ec.core.monitor.c.a;
        String r10 = null;
        String r11 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.EC_SKU_COUPON_APPLY_API_DURATION, null);
        if (this.skuParams.isLiveSkuCheck() == false) goto L9;
        com.bytedance.android.ec.core.monitor.c.e(r11, "scene", "live");
    L11:
        com.bytedance.android.ec.core.monitor.c.e(r11, "type", "multiple");
        com.bytedance.android.ec.core.monitor.c.e(r11, "path", "coupon/apply/auto/");
        com.bytedance.android.ec.core.monitor.c.h(r11, MetricNames.API_DURATION, null);
        long r12 = getCurrentPrice() * getCurrentCount();
        com.bytedance.android.ec.common.impl.sku.repository.a r14 = this.repository;
        String r13 = this.skuParams.getProductId();
        if (r13 != null) goto L14;
        String r15 = "";
    L15:
        String r16 = this.skuParams.getShopId();
        if (r16 != null) goto L18;
        String r17 = "";
    L19:
        SkuExtraData r18 = this.skuParams.getSkuExtraData();
        if (r18 == null) goto L22;
        r10 = r18.getMarketChannel();
    L22:
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(r14.applyCouponAuto(r15, r17, r12, r10, this.skuParams.getAuthorId(), this.skuParams.getSecAuthorId(), this.skuParams.getChannelId(), this.skuParams.getChannelType())).subscribe(new e(this, r11, r26, r25, r12, r27, r28, r29), new f(this, r11)), this);
        return;
    L18:
        r17 = r16;
        goto L19
    L14:
        r15 = r13;
        goto L15
    L9:
        if (this.skuParams.isFromAnchorV3() == false) goto L11;
        com.bytedance.android.ec.core.monitor.c.e(r11, "scene", "video");
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void doSkuEventAction(String r20, Pair<String, String>[] r21, String r22, PageFinder r23, Map<String, String> r24) {
        String r1 = r20;
        Intrinsics.checkNotNullParameter(r1, "actionName");
        Intrinsics.checkNotNullParameter(r21, "params");
        int r10 = com.bytedance.android.ec.common.impl.sku.utils.e.a;
        String r11 = com.bytedance.android.ec.common.impl.sku.utils.e.a(r1, this.skuParams.getRoomItemType());
        String r12 = null;
        if (this.skuParams.isLiveSkuCheck() == false) goto L5;
    L10:
        r1 = "livesdk_".concat(r11);
    L11:
        rg.a r13 = (rg.a) this.onItemChange.a();
        if (r13 == null) goto L14;
        String r14 = (String) r13.b;
    L15:
        SkuInfoVO r15 = (SkuInfoVO) this.skuInfo.a();
        if (r24 != null) goto L28;
        if (r15 == null) goto L25;
        Map<String, SkuItemInfoVO> r16 = r15.getSkuList();
        if (r16 == null) goto L25;
        SkuItemInfoVO r17 = r16.get(r14);
        if (r17 == null) goto L25;
        Map<String, String> r18 = r17.getShowEventTrack();
        if (r18 == null) goto L25;
    L29:
        SpreadBuilder r19 = new SpreadBuilder(19);
        r19.addSpread(r21);
        if (r18 != null) goto L32;
        r18 = MapsKt.emptyMap();
    L32:
        ArrayList r25 = new ArrayList(r18.size());
        Iterator<Map.Entry<String, String>> r26 = r18.entrySet().iterator();
    L34:
        if (r26.hasNext() == false) goto L36;
        Map.Entry<String, String> r27 = r26.next();
        r25.add(new Pair(r27.getKey(), r27.getValue()));
        goto L34
    L36:
        Object[] r28 = r25.toArray(new Pair[0]);
        if (r28 == null) goto L108;
        r19.addSpread(r28);
        String r29 = a2.d(this.skuParams.getMethod());
        if (r29 != null) goto L41;
        r29 = com.bytedance.android.ec.core.event.a.VALUE_OTHERS;
    L41:
        r19.add(TuplesKt.to("sku_from", r29));
        r19.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD, this.selectFxhMethod));
        r19.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST, ArraysKt.joinToString$default(CollectionsKt.toIntArray(this.termCountList), ",", null, null, 0, null, null, 62, null)));
        r19.add(TuplesKt.to("recommend_fxh_method", this.recommendTermCount.toString()));
        String r30 = "1";
        if (this.showFlag == false) goto L44;
        Object r31 = "1";
    L45:
        r19.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_CREAVAILABLE, r31));
        if (this.hasRefreshDetailInfo == true) goto L49;
        r30 = "0";
    L49:
        r19.add(TuplesKt.to("if_detail_change", r30));
        SkuExtraData r32 = this.skuParams.getSkuExtraData();
        if (r32 == null) goto L57;
        String r33 = r32.getTransitionTrackerData();
        if (r33 == null) goto L57;
        JSONObject r34 = jg.g.f(r33);
        if (r34 == null) goto L57;
        String r35 = r34.optString(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL);
        if (r35 == null) goto L57;
    L63:
        r19.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, r35));
        SkuExtraData r36 = this.skuParams.getSkuExtraData();
        if (r36 == null) goto L70;
        String r37 = r36.getTransitionTrackerData();
        if (r37 == null) goto L70;
        JSONObject r38 = jg.g.f(r37);
        if (r38 == null) goto L70;
        String r39 = r38.optString(com.bytedance.android.ec.core.event.a.KEY_CARRIER_TYPE);
    L71:
        r19.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARRIER_TYPE, r39));
        if (r15 == null) goto L78;
        SkuInstallmentItemInfo r40 = r15.getInstallmentInfo();
        if (r40 == null) goto L78;
        SkuTermInfo r41 = r40.getTermInfo();
        if (r41 == null) goto L78;
        String r42 = r41.getPlanNo();
    L79:
        r19.add(TuplesKt.to("plan_no", jg.g.c(r42)));
        if (r15 == null) goto L86;
        SkuInstallmentItemInfo r43 = r15.getInstallmentInfo();
        if (r43 == null) goto L86;
        SkuTermInfo r44 = r43.getTermInfo();
        if (r44 == null) goto L86;
        String r45 = r44.getMaterialNo();
    L87:
        r19.add(TuplesKt.to("material_no", jg.g.c(r45)));
        if (r15 == null) goto L94;
        SkuInstallmentItemInfo r46 = r15.getInstallmentInfo();
        if (r46 == null) goto L94;
        SkuTermInfo r47 = r46.getTermInfo();
        if (r47 == null) goto L94;
        String r48 = r47.getResourceNo();
    L95:
        r19.add(TuplesKt.to("resource_no", jg.g.c(r48)));
        if (r15 == null) goto L102;
        SkuInstallmentItemInfo r49 = r15.getInstallmentInfo();
        if (r49 == null) goto L102;
        SkuTermInfo r50 = r49.getTermInfo();
        if (r50 == null) goto L102;
        r12 = r50.getBizType();
    L102:
        r19.add(TuplesKt.to("biztype", jg.g.c(r12)));
        r19.add(TuplesKt.to("sku_panel_model", getSkuPanelModel()));
        r19.add(TuplesKt.to("fxh_method_voucher_list", CollectionsKt.joinToString$default(this.voucherList, ",", null, null, 0, null, null, 62, null)));
        r19.add(TuplesKt.to("show_service_code", CollectionsKt.joinToString$default(this.showServiceCodeList, ",", null, null, 0, null, null, 62, null)));
        String r51 = this.showLogisticsCode;
        if (r51 != null) goto L105;
        r51 = "";
    L105:
        r19.add(TuplesKt.to("show_logistics_code", r51));
        r19.add(TuplesKt.to("sku_show_session_id", this.skuShowSessionId));
        doEventAction(r1, r22, r23, (Pair[]) r19.toArray(new Pair[r19.size()]));
        return;
    L94:
        r48 = null;
    L86:
        r45 = null;
    L78:
        r42 = null;
    L70:
        r39 = null;
    L57:
        String r52 = this.skuParams.getEntranceInfo();
        if (r52 == null) goto L62;
        JSONObject r53 = jg.g.f(r52);
        if (r53 == null) goto L62;
        r35 = r53.optString(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL);
    L62:
        r35 = null;
        goto L63
    L44:
        r31 = "0";
        goto L45
    L108:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L25:
        if (r15 == null) goto L27;
        r18 = r15.getShowTrackParams();
        goto L29
    L27:
        r18 = null;
        goto L29
    L28:
        r18 = r24;
        goto L29
    L14:
        r14 = null;
        goto L15
    L5:
        if (this.skuParams.isFromMatchLive() == false) goto L11;
        if (StringsKt.startsWith$default(r11, "livesdk", false, 2, null) == true) goto L11;
        if (StringsKt.startsWith$default(r11, "vs_", false, 2, null) == true) goto L11;
        goto L10
    }

    public final void addShopCartNew(String r10, String r11, String r12, String r13, int r14, String r15) {
        Intrinsics.checkNotNullParameter(r10, "comboId");
        Intrinsics.checkNotNullParameter(r11, "comboNum");
        Intrinsics.checkNotNullParameter(r12, "extra");
        Intrinsics.checkNotNullParameter(r13, "channelId");
        com.bytedance.android.ec.common.impl.sku.repository.a r1 = this.repository;
        String r0 = this.skuParams.getProductId();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(r1.b(r0, r10, r11, r12, r13, r14, r15)).subscribe(new c(this, r10, r11, r12), new d(this)), this);
    }

    public static /* synthetic */ void sendAddCartSuccessEvent$default(SkuViewModel r0, String r1, String r10, String r11, Integer r12, int r13, Object r14) {
        if ((r13 & 8) == 0) goto L5;
        r12 = null;
    L5:
        r0.sendAddCartSuccessEvent(r1, r10, r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void applyCouponAuto$default(SkuViewModel r10, Context r11, sc3.b r12, String r13, String r14, Function1 r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        r14 = "";
    L5:
        String r18 = r14;
        if ((r16 & 16) == 0) goto L8;
        r15 = null;
    L8:
        r10.applyCouponAuto(r11, r12, r13, r18, r15);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void doSkuEventAction$default(SkuViewModel r10, String r11, Pair[] r12, String r13, PageFinder r14, Map r15, int r16, Object r17) {
        if ((r16 & 4) == 0) goto L5;
        String r18 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        PageFinder r19 = null;
    L11:
        if ((r16 & 16) == 0) goto L13;
        Map r20 = null;
    L14:
        r10.doSkuEventAction(r11, r12, r18, r19, r20);
        return;
    L13:
        r20 = r15;
        goto L14
    L9:
        r19 = r14;
        goto L11
    L5:
        r18 = r13;
        goto L7
    }

    public final void doSkuEventActionNew(String r10, String r11, String r12, String r13, String r14, String r15, String r16, Pair<String, String>... r17) {
        Intrinsics.checkNotNullParameter(r10, "actionName");
        Intrinsics.checkNotNullParameter(r13, "planNo");
        Intrinsics.checkNotNullParameter(r17, "params");
        int r0 = com.bytedance.android.ec.common.impl.sku.utils.e.a;
        String r1 = com.bytedance.android.ec.common.impl.sku.utils.e.a(r10, this.skuParams.getRoomItemType());
        String r18 = null;
        if (this.skuParams.isLiveSkuCheck() == false) goto L5;
    L10:
        r10 = "livesdk_".concat(r1);
    L11:
        Map<String, String> r19 = this.showTrackParams;
        if (r19 == null) goto L14;
        appendEventParams(r19);
    L14:
        SpreadBuilder r20 = new SpreadBuilder(16);
        r20.addSpread(r17);
        r20.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ACTIVITY_TYPE, r12));
        r20.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ACTIVITY_LABEL, r11));
        r20.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PARAMS_FOR_SPECIAL, com.bytedance.android.ec.core.event.a.VALUE_PARAMS_FOR_SPECIAL));
        r20.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_APP_ID, com.bytedance.android.ec.sdk.helper.d.b.getIECHostAppInfo().getAppId()));
        String r21 = a2.d(this.skuParams.getMethod());
        if (r21 != null) goto L17;
        r21 = com.bytedance.android.ec.core.event.a.VALUE_OTHERS;
    L17:
        r20.add(TuplesKt.to("sku_from", r21));
        r20.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD, this.selectFxhMethod));
        r20.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FXH_METHOD_LIST, Arrays.toString(CollectionsKt.toIntArray(this.termCountList))));
        String r22 = "1";
        if (this.showFlag == false) goto L20;
        Object r23 = "1";
    L21:
        r20.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_CREAVAILABLE, r23));
        if (this.hasRefreshDetailInfo == true) goto L25;
        r22 = "0";
    L25:
        r20.add(TuplesKt.to("if_detail_change", r22));
        SkuExtraData r24 = this.skuParams.getSkuExtraData();
        if (r24 == null) goto L32;
        String r25 = r24.getTransitionTrackerData();
        if (r25 == null) goto L32;
        JSONObject r26 = jg.g.f(r25);
        if (r26 == null) goto L32;
        String r27 = r26.optString(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL);
    L33:
        r20.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, r27));
        SkuExtraData r28 = this.skuParams.getSkuExtraData();
        if (r28 == null) goto L40;
        String r29 = r28.getTransitionTrackerData();
        if (r29 == null) goto L40;
        JSONObject r30 = jg.g.f(r29);
        if (r30 == null) goto L40;
        r18 = r30.optString(com.bytedance.android.ec.core.event.a.KEY_CARRIER_TYPE);
    L40:
        r20.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARRIER_TYPE, r18));
        r20.add(TuplesKt.to("plan_no", r13));
        r20.add(TuplesKt.to("material_no", r14));
        r20.add(TuplesKt.to("resource_no", r15));
        r20.add(TuplesKt.to("biztype", r16));
        doEventAction(r10, (Pair[]) r20.toArray(new Pair[r20.size()]));
        return;
    L32:
        r27 = null;
        goto L33
    L20:
        r23 = "0";
        goto L21
    L5:
        if (this.skuParams.isFromMatchLive() == false) goto L11;
        if (StringsKt.startsWith$default(r1, "livesdk", false, 2, null) == true) goto L11;
        if (StringsKt.startsWith$default(r1, "vs_", false, 2, null) == true) goto L11;
        goto L10
    }

    public final void init(SkuParams r10, cf.t r11, String r12, Function0<String> r13, Function2<? super SkuParams, ? super Long, Unit> r14, Function1<? super String, Unit> r15, Function1<? super SkuProductDetailInfo, Unit> r16, Function1<? super SkuCartResult, Unit> r17, Function1<? super SkuCheckResult, Unit> r18) {
        Intrinsics.checkNotNullParameter(r10, "skuParams");
        this.skuPanelState = r10.getSkuState();
        this.skuParams = appendEntranceInfoToSkuParams(r10, r12);
        this.skuLiveService = r11;
        this.promotionListEntranceInfo = r13;
        this.adLogCallBack = r14;
        this.finishPlaybackPageListener = r15;
        this.refreshDetailInfoCallback = r16;
        this.cartListener = r17;
        this.skuCheckResultCallback = r18;
        initEventParams();
        initDefaultSelectParams();
    }

    public final void addShopCart(String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, int r26, String r27) {
        Intrinsics.checkNotNullParameter(r18, "originType");
        Intrinsics.checkNotNullParameter(r19, "originId");
        Intrinsics.checkNotNullParameter(r20, "comboId");
        Intrinsics.checkNotNullParameter(r21, "comboNum");
        Intrinsics.checkNotNullParameter(r22, "specDesc");
        Intrinsics.checkNotNullParameter(r23, "deviceId");
        Intrinsics.checkNotNullParameter(r24, "extra");
        Intrinsics.checkNotNullParameter(r25, "channelId");
        com.bytedance.android.ec.common.impl.sku.repository.a r1 = this.repository;
        String r10 = this.skuParams.getPromotionId();
        String r11 = this.skuParams.getProductId();
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(r1.f(r10, r11, r18, r19, r20, r21, r22, r23, r24, this.skuParams.getAuthorId(), this.skuParams.getSecAuthorId(), r25, r26, r27)).subscribe(new a(this, r20, r21, r24), new b(this)), this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void init$default(SkuViewModel r13, SkuParams r14, cf.t r15, String r16, Function0 r17, Function2 r18, Function1 r19, Function1 r20, Function1 r21, Function1 r22, int r23, Object r24) {
        if ((r23 & 128) == 0) goto L5;
        Function1 r11 = null;
    L7:
        if ((r23 & 256) == 0) goto L9;
        Function1 r12 = null;
    L10:
        r13.init(r14, r15, r16, r17, r18, r19, r20, r11, r12);
        return;
    L9:
        r12 = r22;
        goto L10
    L5:
        r11 = r21;
        goto L7
    }
}
