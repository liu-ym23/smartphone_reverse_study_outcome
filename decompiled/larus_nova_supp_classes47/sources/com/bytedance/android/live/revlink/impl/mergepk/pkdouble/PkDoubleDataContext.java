package com.bytedance.android.live.revlink.impl.mergepk.pkdouble;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ca0.v;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.jsb.h0;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PKBizType;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkStateMachineController;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseResult;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.vm.pk.PkContributorDataContext;
import com.bytedance.android.live.revlink.impl.pk.vm.pk.PkLynxInfoViewModel;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.live.revlink.link.biz.service.j;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.a5;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.bridge.a0;
import com.bytedance.android.livesdk.link.model.bridge.o0;
import com.bytedance.android.livesdk.link.model.bridge.u0;
import com.bytedance.android.livesdk.link.model.bridge.z;
import com.bytedance.android.livesdk.link.model.c5;
import com.bytedance.android.livesdk.link.model.f1;
import com.bytedance.android.livesdk.link.model.g1;
import com.bytedance.android.livesdk.link.model.g5;
import com.bytedance.android.livesdk.link.model.h7;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.t2;
import com.bytedance.android.livesdk.link.model.u1;
import com.bytedance.android.livesdk.link.model.y4;
import com.bytedance.android.livesdk.link.model.z4;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.scope.m;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.o;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
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
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.n;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000ô\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b*\u0004ë\u0001î\u0001\u0018\u0000 Ö\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0004×\u0002Ø\u0002B\u009b\u0001\u0012\b\u0010ñ\u0001\u001a\u00030\u0090\u0001\u0012\t\u0010ô\u0001\u001a\u0004\u0018\u00010\u0018\u0012\u0007\u0010¸\u0002\u001a\u00020\u001b\u0012\n\u0010ø\u0001\u001a\u0005\u0018\u00010÷\u0001\u0012\n\u0010û\u0001\u001a\u0005\u0018\u00010ú\u0001\u0012\n\u0010þ\u0001\u001a\u0005\u0018\u00010ý\u0001\u0012\n\u0010\u0081\u0002\u001a\u0005\u0018\u00010\u0080\u0002\u0012\n\u0010\u0084\u0002\u001a\u0005\u0018\u00010\u0083\u0002\u0012\n\u0010\u0087\u0002\u001a\u0005\u0018\u00010\u0086\u0002\u0012\n\u0010Ò\u0002\u001a\u0005\u0018\u00010Ñ\u0002\u0012\b\u0010\u008a\u0002\u001a\u00030\u0089\u0002\u0012\u0007\u0010\u008e\u0002\u001a\u00020\u0003\u0012\u000b\b\u0002\u0010Ó\u0002\u001a\u0004\u0018\u00010R¢\u0006\u0006\bÔ\u0002\u0010Õ\u0002J\u001e\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\u0018\u0010\u0014\u001a\u00020\r2\u000e\u0010\u0013\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\"\u0010\u001d\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\rH\u0002J:\u0010)\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J \u0010*\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020!H\u0016J,\u0010-\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010#\u001a\u0004\u0018\u00010!2\u0006\u0010,\u001a\u00020\u001bH\u0016J$\u00103\u001a\u00020\r2\u0006\u0010.\u001a\u00020$2\b\u00100\u001a\u0004\u0018\u00010/2\b\u00102\u001a\u0004\u0018\u000101H\u0016J\u0010\u00105\u001a\u00020\r2\u0006\u0010\u0016\u001a\u000204H\u0016J\u0010\u00107\u001a\u00020\r2\u0006\u0010\u0016\u001a\u000206H\u0016J\b\u00108\u001a\u00020\u001bH\u0016J \u0010;\u001a\u00020\r2\u0006\u00109\u001a\u00020\u001b2\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\bH\u0016J\b\u0010<\u001a\u00020\rH\u0016J\b\u0010=\u001a\u00020\rH\u0016J\u0006\u0010>\u001a\u00020\rJ\u0006\u0010?\u001a\u00020\rJ\u0010\u0010A\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u001bH\u0016J\b\u0010B\u001a\u00020\rH\u0016J\u0010\u0010D\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020CH\u0016J\b\u0010E\u001a\u00020\u001bH\u0016J\b\u0010F\u001a\u00020\u001bH\u0016J\n\u0010H\u001a\u0004\u0018\u00010GH\u0016J\b\u0010I\u001a\u00020\u001bH\u0016J\u0006\u0010J\u001a\u00020\rJ\t\u0010K\u001a\u00020\rH\u0096\u0001J\t\u0010L\u001a\u00020\rH\u0096\u0001J\t\u0010M\u001a\u00020\rH\u0096\u0001R\u0018\u0010P\u001a\u00060Nj\u0002`O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0017\u0010S\u001a\u00020R8\u0006¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\"\u0010W\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010]\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b]\u0010X\u001a\u0004\b^\u0010Z\"\u0004\b_\u0010\\R\"\u0010`\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b`\u0010X\u001a\u0004\ba\u0010Z\"\u0004\bb\u0010\\R\"\u0010c\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bc\u0010X\u001a\u0004\bd\u0010Z\"\u0004\be\u0010\\R:\u0010j\u001a\u001a\u0012\b\u0012\u00060gj\u0002`h0fj\f\u0012\b\u0012\u00060gj\u0002`h`i8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR*\u0010p\u001a\u0012\u0012\u0004\u0012\u00020\u00180fj\b\u0012\u0004\u0012\u00020\u0018`i8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bp\u0010k\u001a\u0004\bq\u0010mR\u0016\u0010r\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010t\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010sR\u001c\u0010v\u001a\u0004\u0018\u00010u8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010yR\u001a\u0010{\u001a\u00020z8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R%\u0010\u007f\u001a\u00020\u001b8\u0004@\u0004X\u0084\u000e¢\u0006\u0015\n\u0004\b\u007f\u0010s\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R3\u0010\u0083\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\b8\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R%\u0010\u001c\u001a\u00020\u001b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0004\b\u001c\u0010s\u001a\u0005\b\u001c\u0010\u0080\u0001\"\u0006\b\u0089\u0001\u0010\u0082\u0001R(\u0010\u008a\u0001\u001a\u00020\u001b8\u0016@\u0016X\u0096\u000e¢\u0006\u0017\n\u0005\b\u008a\u0001\u0010s\u001a\u0006\b\u008a\u0001\u0010\u0080\u0001\"\u0006\b\u008b\u0001\u0010\u0082\u0001R(\u0010\u008c\u0001\u001a\u00020\u001b8\u0016@\u0016X\u0096\u000e¢\u0006\u0017\n\u0005\b\u008c\u0001\u0010s\u001a\u0006\b\u008c\u0001\u0010\u0080\u0001\"\u0006\b\u008d\u0001\u0010\u0082\u0001R(\u0010\u008e\u0001\u001a\u00020\u001b8\u0016@\u0016X\u0096\u000e¢\u0006\u0017\n\u0005\b\u008e\u0001\u0010s\u001a\u0006\b\u008e\u0001\u0010\u0080\u0001\"\u0006\b\u008f\u0001\u0010\u0082\u0001R*\u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R(\u0010\u0097\u0001\u001a\u00020\u001b8\u0016@\u0016X\u0096\u000e¢\u0006\u0017\n\u0005\b\u0097\u0001\u0010s\u001a\u0006\b\u0097\u0001\u0010\u0080\u0001\"\u0006\b\u0098\u0001\u0010\u0082\u0001R)\u0010\u0099\u0001\u001a\u00020\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R)\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0017\n\u0005\b\u001a\u0010\u009f\u0001\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R)\u0010¤\u0001\u001a\u00020\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b¤\u0001\u0010\u009a\u0001\u001a\u0006\b¥\u0001\u0010\u009c\u0001\"\u0006\b¦\u0001\u0010\u009e\u0001R+\u0010§\u0001\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b§\u0001\u0010\u009a\u0001\u001a\u0006\b§\u0001\u0010\u009c\u0001\"\u0006\b¨\u0001\u0010\u009e\u0001R&\u0010©\u0001\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b©\u0001\u0010X\u001a\u0005\bª\u0001\u0010Z\"\u0005\b«\u0001\u0010\\R?\u0010¯\u0001\u001a\"\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00ad\u00010\b0¬\u0001j\u0010\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00ad\u00010\b`®\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b¯\u0001\u0010°\u0001\u001a\u0006\b±\u0001\u0010²\u0001R?\u0010³\u0001\u001a\"\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00ad\u00010\b0¬\u0001j\u0010\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00ad\u00010\b`®\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b³\u0001\u0010°\u0001\u001a\u0006\b´\u0001\u0010²\u0001R8\u0010¶\u0001\u001a\u0014\u0012\u0005\u0012\u00030µ\u00010fj\t\u0012\u0005\u0012\u00030µ\u0001`i8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b¶\u0001\u0010k\u001a\u0005\b·\u0001\u0010m\"\u0005\b¸\u0001\u0010oR3\u0010¹\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0090\u00010¬\u0001j\n\u0012\u0005\u0012\u00030\u0090\u0001`®\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b¹\u0001\u0010°\u0001\u001a\u0006\bº\u0001\u0010²\u0001R-\u0010»\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001b0fj\b\u0012\u0004\u0012\u00020\u001b`i8\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b»\u0001\u0010k\u001a\u0005\b¼\u0001\u0010mR6\u0010½\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001b0fj\b\u0012\u0004\u0012\u00020\u001b`i8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b½\u0001\u0010k\u001a\u0005\b¾\u0001\u0010m\"\u0005\b¿\u0001\u0010oR6\u0010À\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001b0fj\b\u0012\u0004\u0012\u00020\u001b`i8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÀ\u0001\u0010k\u001a\u0005\bÁ\u0001\u0010m\"\u0005\bÂ\u0001\u0010oR8\u0010Ä\u0001\u001a\u0014\u0012\u0005\u0012\u00030Ã\u00010fj\t\u0012\u0005\u0012\u00030Ã\u0001`i8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÄ\u0001\u0010k\u001a\u0005\bÅ\u0001\u0010m\"\u0005\bÆ\u0001\u0010oR6\u0010Ç\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u000b0fj\b\u0012\u0004\u0012\u00020\u000b`i8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÇ\u0001\u0010k\u001a\u0005\bÈ\u0001\u0010m\"\u0005\bÉ\u0001\u0010oR1\u0010Ì\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u001b0Ê\u0001j\t\u0012\u0004\u0012\u00020\u001b`Ë\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÌ\u0001\u0010Í\u0001\u001a\u0006\bÎ\u0001\u0010Ï\u0001R-\u0010Ð\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001b0fj\b\u0012\u0004\u0012\u00020\u001b`i8\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\bÐ\u0001\u0010k\u001a\u0005\bÑ\u0001\u0010mR&\u0010Ò\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001b0fj\b\u0012\u0004\u0012\u00020\u001b`i8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bÒ\u0001\u0010kR1\u0010Ó\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u001b0¬\u0001j\t\u0012\u0004\u0012\u00020\u001b`®\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÓ\u0001\u0010°\u0001\u001a\u0006\bÔ\u0001\u0010²\u0001R-\u0010Õ\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001b0fj\b\u0012\u0004\u0012\u00020\u001b`i8\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\bÕ\u0001\u0010k\u001a\u0005\bÖ\u0001\u0010mR\u0018\u0010Ø\u0001\u001a\u00030×\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bØ\u0001\u0010Ù\u0001R)\u0010Ú\u0001\u001a\u00020\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bÚ\u0001\u0010\u009a\u0001\u001a\u0006\bÛ\u0001\u0010\u009c\u0001\"\u0006\bÜ\u0001\u0010\u009e\u0001R\u0016\u0010E\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010sR&\u0010Ý\u0001\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÝ\u0001\u0010X\u001a\u0005\bÝ\u0001\u0010Z\"\u0005\bÞ\u0001\u0010\\R\u0018\u0010à\u0001\u001a\u00030ß\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bà\u0001\u0010á\u0001R6\u0010â\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001b0fj\b\u0012\u0004\u0012\u00020\u001b`i8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bâ\u0001\u0010k\u001a\u0005\bã\u0001\u0010m\"\u0005\bä\u0001\u0010oR6\u0010å\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001b0fj\b\u0012\u0004\u0012\u00020\u001b`i8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bå\u0001\u0010k\u001a\u0005\bæ\u0001\u0010m\"\u0005\bç\u0001\u0010oRG\u0010é\u0001\u001a,\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\t0è\u00010\b0fj\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\t0è\u00010\b`i8\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\bé\u0001\u0010k\u001a\u0005\bê\u0001\u0010mR\u0018\u0010ì\u0001\u001a\u00030ë\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bì\u0001\u0010í\u0001R\u0018\u0010ï\u0001\u001a\u00030î\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bï\u0001\u0010ð\u0001R*\u0010ñ\u0001\u001a\u00030\u0090\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bñ\u0001\u0010\u0092\u0001\u001a\u0006\bò\u0001\u0010\u0094\u0001\"\u0006\bó\u0001\u0010\u0096\u0001R+\u0010ô\u0001\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bô\u0001\u0010\u009a\u0001\u001a\u0006\bõ\u0001\u0010\u009c\u0001\"\u0006\bö\u0001\u0010\u009e\u0001R\u001a\u0010ø\u0001\u001a\u0005\u0018\u00010÷\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bø\u0001\u0010ù\u0001R\u001a\u0010û\u0001\u001a\u0005\u0018\u00010ú\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bû\u0001\u0010ü\u0001R\u001a\u0010þ\u0001\u001a\u0005\u0018\u00010ý\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bþ\u0001\u0010ÿ\u0001R\u001a\u0010\u0081\u0002\u001a\u0005\u0018\u00010\u0080\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0002\u0010\u0082\u0002R\u001a\u0010\u0084\u0002\u001a\u0005\u0018\u00010\u0083\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0002\u0010\u0085\u0002R\u001a\u0010\u0087\u0002\u001a\u0005\u0018\u00010\u0086\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0002\u0010\u0088\u0002R \u0010\u008a\u0002\u001a\u00030\u0089\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u008a\u0002\u0010\u008b\u0002\u001a\u0006\b\u008c\u0002\u0010\u008d\u0002R\u0017\u0010\u008e\u0002\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0002\u0010\u008f\u0002R\u001a\u0010\u0093\u0002\u001a\u0005\u0018\u00010\u0090\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0091\u0002\u0010\u0092\u0002R\u001a\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0094\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0095\u0002\u0010\u0096\u0002R\u001a\u0010\u009b\u0002\u001a\u0005\u0018\u00010\u0098\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0099\u0002\u0010\u009a\u0002R\u001a\u0010\u009f\u0002\u001a\u0005\u0018\u00010\u009c\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009d\u0002\u0010\u009e\u0002R\u001a\u0010£\u0002\u001a\u0005\u0018\u00010 \u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b¡\u0002\u0010¢\u0002R\u001a\u0010§\u0002\u001a\u0005\u0018\u00010¤\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b¥\u0002\u0010¦\u0002R\u001a\u0010«\u0002\u001a\u0005\u0018\u00010¨\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b©\u0002\u0010ª\u0002R\u001a\u0010¯\u0002\u001a\u0005\u0018\u00010¬\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u00ad\u0002\u0010®\u0002R\u001a\u0010³\u0002\u001a\u0005\u0018\u00010°\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b±\u0002\u0010²\u0002R\u001a\u0010·\u0002\u001a\u0005\u0018\u00010´\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\bµ\u0002\u0010¶\u0002R\u0017\u0010¸\u0002\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\b\u001a\u0006\b¸\u0002\u0010\u0080\u0001R\u001a\u0010¼\u0002\u001a\u0005\u0018\u00010¹\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\bº\u0002\u0010»\u0002R\u001a\u0010À\u0002\u001a\u0005\u0018\u00010½\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b¾\u0002\u0010¿\u0002R\u001a\u0010Ä\u0002\u001a\u0005\u0018\u00010Á\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\bÂ\u0002\u0010Ã\u0002R\u001a\u0010È\u0002\u001a\u0005\u0018\u00010Å\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\bÆ\u0002\u0010Ç\u0002R\u001e\u0010Í\u0002\u001a\f\u0018\u00010É\u0002j\u0005\u0018\u0001`Ê\u00028F¢\u0006\b\u001a\u0006\bË\u0002\u0010Ì\u0002R\u0018\u0010Ð\u0002\u001a\u00030ß\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÎ\u0002\u0010Ï\u0002¨\u0006Ù\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/d;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/a;", "Lca0/v;", "", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/c;", "Lcom/bytedance/android/live/revlink/link/biz/service/j;", "", "Lcom/bytedance/android/livesdk/link/model/p;", "onlineList", "", "scene", "", "onOnlineListChange", "initLynxGuestData", "updateGuestUserInfo", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "onMessage", "Lcom/bytedance/android/livesdk/link/model/bridge/o0;", "message", "onLinkMicBattleFrontRankMessage", "", "activeAnchorId", "endType", "", "isFinisher", "setPkEndData", "setIsPlayModeInviter", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/a;", "pkInfo", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;", "fromState", "toState", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$Source;", "source", "isOnceMore", "Lcom/bytedance/android/live/revlink/impl/multianchor/constants/PlayMode;", "playMode", "onBizPK", "onBizPenal", "skippedPenal", "isRealPkFinish", "onBizFinished", "stateSource", "Lcom/bytedance/android/livesdk/link/model/f1;", Constants.Keys.DATA, "", "throwable", "onBizFinishCallback", "Lcom/bytedance/android/livesdk/link/model/a5;", "onBizReceiveBattleFinishMsg", "Lcom/bytedance/android/livesdk/link/model/y4;", "onBizReceiveBattleEndPunishMsg", "isInContributor", "isFeedBack", "selectTag", "onFeedBackInfoUpdate", "onEnterRoom", "onExitRoom", "onToLinkInPeak", "onToLinkInOpenGame", "isCloseRoom", "handlePkEnd", "recordGuestRtcLeave", "Lcom/bytedance/android/livesdk/link/model/c5;", "onBizReceiveBattleMsg", "canSwitchMulti", "isInVote", "Lcom/bytedance/android/livesdk/link/model/bridge/a0;", "getShellConfig", "isInBreakThrough", "resetData", "attach", "reportUiFirstLoad", "resetPeakData", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/PkBaseDataContext;", "basePKContext", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/PkBaseDataContext;", "getBasePKContext", "()Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/PkBaseDataContext;", "durationField", "I", "getDurationField", "()I", "setDurationField", "(I)V", "matchTypeField", "getMatchTypeField", "setMatchTypeField", "inviteType", "getInviteType", "setInviteType", "currentMatchType", "getCurrentMatchType", "setCurrentMatchType", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/MutableLiveData;", "guestUser", "Landroidx/lifecycle/MutableLiveData;", "getGuestUser", "()Landroidx/lifecycle/MutableLiveData;", "setGuestUser", "(Landroidx/lifecycle/MutableLiveData;)V", "pkGuestListStr", "getPkGuestListStr", "isFirstPk", "Z", "isFirstGame", "Lcom/bytedance/android/livesdk/revenue/room/a;", "roomContext", "Lcom/bytedance/android/livesdk/revenue/room/a;", "getRoomContext", "()Lcom/bytedance/android/livesdk/revenue/room/a;", "Lh41/e;", "pkLogger", "Lh41/e;", "getPkLogger", "()Lh41/e;", "isFeedback", "()Z", "setFeedback", "(Z)V", "feedbackSelectTags", "Ljava/util/List;", "getFeedbackSelectTags", "()Ljava/util/List;", "setFeedbackSelectTags", "(Ljava/util/List;)V", "setFinisher", "isRealOrgnizer", "setRealOrgnizer", "isRoomCloser", "setRoomCloser", "isGuestRtcLeave", "setGuestRtcLeave", "", "linkStartTime", "J", "getLinkStartTime", "()J", "setLinkStartTime", "(J)V", "isPlayModeInviter", "setPlayModeInviter", "connectionType", "Ljava/lang/String;", "getConnectionType", "()Ljava/lang/String;", "setConnectionType", "(Ljava/lang/String;)V", "Ljava/lang/Integer;", "getEndType", "()Ljava/lang/Integer;", "setEndType", "(Ljava/lang/Integer;)V", "endReason", "getEndReason", "setEndReason", "isManager", "setManager", "curAuraType", "getCurAuraType", "setCurAuraType", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/android/livesdk/link/model/h7$b;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/LiveData;", "leftMvpRankList", "Landroidx/lifecycle/LiveData;", "getLeftMvpRankList", "()Landroidx/lifecycle/LiveData;", "rightMvpRankList", "getRightMvpRankList", "Lcom/bytedance/android/livesdk/link/model/t2;", "pkSeasonResult", "getPkSeasonResult", "setPkSeasonResult", "pkStarCount", "getPkStarCount", "pkLynxInfoIsShowing", "getPkLynxInfoIsShowing", "pkProgressBarSecKillLine", "getPkProgressBarSecKillLine", "setPkProgressBarSecKillLine", "pkProgressBarAdditionAnim", "getPkProgressBarAdditionAnim", "setPkProgressBarAdditionAnim", "Lcom/bytedance/android/live/revlink/impl/jsb/h0;", "teamTaskOptAddition", "getTeamTaskOptAddition", "setTeamTaskOptAddition", "contributionListAlphaEvent", "getContributionListAlphaEvent", "setContributionListAlphaEvent", "Lio/reactivex/subjects/PublishSubject;", "Lcom/bytedance/revenue/platform/api/core/rx/PublishSubject;", "installKillMsgEvent", "Lio/reactivex/subjects/PublishSubject;", "getInstallKillMsgEvent", "()Lio/reactivex/subjects/PublishSubject;", "lastBattleResultShow", "getLastBattleResultShow", "_pkScoreForceUpdateEvent", "pkScoreForceUpdateEvent", "getPkScoreForceUpdateEvent", "scoreFirstUpdateEvent", "getScoreFirstUpdateEvent", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/PkContributorDataContext;", "contributorDataContext", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/PkContributorDataContext;", "audienceConnectCnt", "getAudienceConnectCnt", "setAudienceConnectCnt", "isBattleStatsObtained", "setBattleStatsObtained", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/PkLynxInfoViewModel;", "pkLynxInfoViewModel", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/PkLynxInfoViewModel;", "oppoIsUsingPropCard", "getOppoIsUsingPropCard", "setOppoIsUsingPropCard", "selfIsUsingPropCard", "getSelfIsUsingPropCard", "setSelfIsUsingPropCard", "Lcom/bytedance/android/live/revlink/impl/multianchor/dynamic/f;", "linkAnchorInfo", "getLinkAnchorInfo", "com/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleDataContext$guestLinkLynxInfoObservable$1", "guestLinkLynxInfoObservable", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleDataContext$guestLinkLynxInfoObservable$1;", "com/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleDataContext$h", "userCenterCallback", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleDataContext$h;", "channelIdField", "getChannelIdField", "setChannelIdField", "guestUid", "getGuestUid", "setGuestUid", "Lld/a;", "linkDataSet", "Lld/a;", "Lwq2/f;", "dataCenterService", "Lwq2/f;", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "roomService", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lyz0/f;", "messageService", "Lyz0/f;", "Lcom/bytedance/android/livesdk/revenue/service/message/d;", "messageManagerService", "Lcom/bytedance/android/livesdk/revenue/service/message/d;", "Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/d;", "context", "Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/d;", "getContext", "()Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/d;", "bizHandler", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/a;", "Lcom/bytedance/android/live/revlink/impl/multianchor/utils/v;", "getMultiLinkMonitor", "()Lcom/bytedance/android/live/revlink/impl/multianchor/utils/v;", "multiLinkMonitor", "Lcom/bytedance/android/live/revlink/impl/monitor/LiveFullLinkPKMonitor;", "getLiveFullLinkPKMonitor", "()Lcom/bytedance/android/live/revlink/impl/monitor/LiveFullLinkPKMonitor;", "liveFullLinkPKMonitor", "Ld31/d;", "getRevLinkLogHelper", "()Ld31/d;", "revLinkLogHelper", "Lw31/c;", "getPkLinkUtils", "()Lw31/c;", "pkLinkUtils", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/e;", "getLinkOptLogContext", "()Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/e;", "linkOptLogContext", "Lcom/bytedance/android/live/revlink/impl/pk/service/f;", "getPkAudienceDataService", "()Lcom/bytedance/android/live/revlink/impl/pk/service/f;", "pkAudienceDataService", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/e;", "getPkBaseResultDataContextObj", "()Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/e;", "pkBaseResultDataContextObj", "Lcom/bytedance/android/live/revlink/impl/pk/service/IPKLinkBizDataService;", "getPKLinkBizDataService", "()Lcom/bytedance/android/live/revlink/impl/pk/service/IPKLinkBizDataService;", "pKLinkBizDataService", "Lcom/bytedance/android/live/revlink/impl/pk/service/e;", "getPKPrecisionMatchService", "()Lcom/bytedance/android/live/revlink/impl/pk/service/e;", "pKPrecisionMatchService", "Lcom/bytedance/android/live/revlink/impl/pk/service/h;", "getPkService", "()Lcom/bytedance/android/live/revlink/impl/pk/service/h;", "pkService", "isAnchor", "La21/a;", "getPkBaseLogger", "()La21/a;", "pkBaseLogger", "Ld21/d;", "getMergePkHelper", "()Ld21/d;", "mergePkHelper", "Lcom/bytedance/android/live/revlink/impl/utils/s;", "getRevLinkCommonUtil", "()Lcom/bytedance/android/live/revlink/impl/utils/s;", "revLinkCommonUtil", "Li11/b;", "getAnchorLinkUserCenter", "()Li11/b;", "anchorLinkUserCenter", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "getTeamTaskService", "()Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/PkLynxInfoViewModel;", "teamTaskService", "Lx11/a;", "internalLinkService", "extraBaseDataContext", "<init>", "(JLjava/lang/String;ZLld/a;Lwq2/f;Lcom/bytedance/android/livesdk/revenue/service/room/c;Lcom/bytedance/android/live/revlink/impl/global/c;Lyz0/f;Lcom/bytedance/android/livesdk/revenue/service/message/d;Lx11/a;Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/d;Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/a;Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/PkBaseDataContext;)V", "Companion", "BattleType", "d", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkDoubleDataContext extends DataContext implements com.bytedance.android.live.revlink.impl.mergepk.pkbase.d, com.bytedance.android.live.revlink.impl.mergepk.pkdouble.a, v, com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c, j {
    public static final d Companion = null;
    public static final String LOG_TAG = "ttlive_PkDoubleDataContext";
    public static final String TAG = "PkDoubleDataContext";
    private final MutableLiveData<Boolean> _pkScoreForceUpdateEvent;
    private String audienceConnectCnt;
    private final PkBaseDataContext basePKContext;
    private final com.bytedance.android.live.revlink.impl.mergepk.pkdouble.a bizHandler;
    private boolean canSwitchMulti;
    private final CompositeDisposable cd;
    private long channelIdField;
    private String connectionType;
    private final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d context;
    private MutableLiveData<Integer> contributionListAlphaEvent;
    private final PkContributorDataContext contributorDataContext;
    private int curAuraType;
    private int currentMatchType;
    private final wq2.f dataCenterService;
    private int durationField;
    private String endReason;
    private Integer endType;
    private List<String> feedbackSelectTags;
    private final PkDoubleDataContext$guestLinkLynxInfoObservable$1 guestLinkLynxInfoObservable;
    private String guestUid;
    private MutableLiveData<IBaseUser> guestUser;
    private final PublishSubject<Boolean> installKillMsgEvent;
    private int inviteType;
    private int isBattleStatsObtained;
    private boolean isFeedback;
    private boolean isFinisher;
    private boolean isFirstGame;
    private boolean isFirstPk;
    private boolean isGuestRtcLeave;
    private String isManager;
    private boolean isPlayModeInviter;
    private boolean isRealOrgnizer;
    private boolean isRoomCloser;
    private final MutableLiveData<Boolean> lastBattleResultShow;
    private final LiveData<List<h7.b>> leftMvpRankList;
    private final MutableLiveData<List<com.bytedance.android.live.revlink.impl.multianchor.dynamic.f<p>>> linkAnchorInfo;
    private final ld.a linkDataSet;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private long linkStartTime;
    private int matchTypeField;
    private final com.bytedance.android.livesdk.revenue.service.message.d messageManagerService;
    private final yz0.f messageService;
    private MutableLiveData<Boolean> oppoIsUsingPropCard;
    private final MutableLiveData<String> pkGuestListStr;
    private final h41.e pkLogger;
    private final MutableLiveData<Boolean> pkLynxInfoIsShowing;
    private final PkLynxInfoViewModel pkLynxInfoViewModel;
    private MutableLiveData<Boolean> pkProgressBarAdditionAnim;
    private MutableLiveData<Boolean> pkProgressBarSecKillLine;
    private final LiveData<Boolean> pkScoreForceUpdateEvent;
    private MutableLiveData<t2> pkSeasonResult;
    private final LiveData<Long> pkStarCount;
    private final LiveData<List<h7.b>> rightMvpRankList;
    private final com.bytedance.android.livesdk.revenue.room.a roomContext;
    private final com.bytedance.android.livesdk.revenue.service.room.c roomService;
    private final MutableLiveData<Boolean> scoreFirstUpdateEvent;
    private MutableLiveData<Boolean> selfIsUsingPropCard;
    private MutableLiveData<h0> teamTaskOptAddition;
    private final h userCenterCallback;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleDataContext$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(PkDoubleDataContext r8) {
            super(1, r8, PkDoubleDataContext.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(yh6.c r2) {
            PkDoubleDataContext.access$onMessage((PkDoubleDataContext) ((CallableReference) this).receiver, r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleDataContext$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass2(PkDoubleDataContext r8) {
            super(1, r8, PkDoubleDataContext.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(yh6.c r2) {
            PkDoubleDataContext.access$onMessage((PkDoubleDataContext) ((CallableReference) this).receiver, r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleDataContext$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass3(PkDoubleDataContext r8) {
            super(1, r8, PkDoubleDataContext.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(yh6.c r2) {
            PkDoubleDataContext.access$onMessage((PkDoubleDataContext) ((CallableReference) this).receiver, r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleDataContext$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/bytedance/android/livesdk/link/model/p;", "p1", "", "p2", "", "invoke", "(Ljava/util/List;I)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function2<List<? extends p>, Integer, Unit> {
        public AnonymousClass7(PkDoubleDataContext r8) {
            super(2, r8, PkDoubleDataContext.class, "onOnlineListChange", "onOnlineListChange(Ljava/util/List;I)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((List) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(List<? extends p> r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            PkDoubleDataContext.access$onOnlineListChange((PkDoubleDataContext) ((CallableReference) this).receiver, r2, r3);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleDataContext$BattleType;", "", "NORMAL_PK", "AGAIN_PK", "PLAYBOE3ROUND_PK", "ACTIVITY_PK", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum BattleType extends Enum<BattleType> {
        public static final BattleType ACTIVITY_PK = null;
        public static final BattleType AGAIN_PK = null;
        public static final BattleType NORMAL_PK = null;
        public static final BattleType PLAYBOE3ROUND_PK = null;
        public static final /* synthetic */ BattleType[] a = null;

        static {
            BattleType r1 = new BattleType("NORMAL_PK", 0);
            NORMAL_PK = r1;
            BattleType r2 = new BattleType("AGAIN_PK", 1);
            AGAIN_PK = r2;
            BattleType r3 = new BattleType("PLAYBOE3ROUND_PK", 2);
            PLAYBOE3ROUND_PK = r3;
            BattleType r4 = new BattleType("ACTIVITY_PK", 3);
            ACTIVITY_PK = r4;
            a = new BattleType[]{r1, r2, r3, r4};
        }

        public static BattleType valueOf(String r1) {
            return (BattleType) r27.a.a(BattleType.class, r1);
        }

        public static BattleType[] values() {
            return (BattleType[]) a.clone();
        }

        public BattleType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements Action {
        public final /* synthetic */ PkDoubleDataContext a;

        public a(PkDoubleDataContext r1) {
            this.a = r1;
        }

        public final void run() {
            AnchorLinkUserCenterV2 r0 = this.a.getBasePKContext().getUserCenter();
            if (r0 == null) goto L5;
            r0.l(PkDoubleDataContext.access$getUserCenterCallback$p(this.a));
        L5:
            PkDoubleDataContext.access$getPkLynxInfoViewModel$p(this.a).clearIt();
            PkDoubleDataContext.access$getContributorDataContext$p(this.a).clearIt();
            PkDoubleDataContext$guestLinkLynxInfoObservable$1 r1 = PkDoubleDataContext.access$getGuestLinkLynxInfoObservable$p(this.a);
            Intrinsics.checkNotNullParameter(r1, "newObserver");
            vh6.c.b(qr2.c.class).unRegisterPkGuestLynxDataObserver(r1);
            cy0.e.a.getClass();
            cy0.j r2 = cy0.e.a.a;
            m.e.getClass();
            Object r3 = m.b(r2).b(com.bytedance.android.livesdk.revenue.service.gift.a.class);
            Intrinsics.checkNotNull(r3);
            ((com.bytedance.live.kmp.core.c) r3).L9(this.a);
            this.a.getBasePKContext().m590getLeftMvpRankList().setValue(null);
            this.a.getBasePKContext().m594getRightMvpRankList().setValue(null);
            this.a.getBasePKContext().m593getPkGuestListStr().setValue(null);
            PkDoubleDataContext.access$getCd$p(this.a).dispose();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PkDoubleDataContext a;

        public b(PkDoubleDataContext r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.getBasePKContext().m590getLeftMvpRankList().setValue(sh6.c.b((sh6.b) r2));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PkDoubleDataContext a;

        public c(PkDoubleDataContext r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.getBasePKContext().m594getRightMvpRankList().setValue(sh6.c.b((sh6.b) r2));
        }
    }

    public static final class d {
        public d() {
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ PkDoubleDataContext a;
        public final /* synthetic */ a5 b;

        public e(PkDoubleDataContext r1, a5 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            Long r8 = (Long) r7;
            this.a.getInstallKillMsgEvent().onNext(Boolean.TRUE);
            PkStateMachineController r9 = this.a.getBasePKContext().getStateMachineController();
            a5 r0 = this.b;
            r9.getClass();
            Intrinsics.checkNotNullParameter(r0, "message");
            com.bytedance.android.live.revlink.impl.global.c r1 = r9.k;
            if (r1 == null) goto L5;
            d21.d r2 = r1.getMergePkHelper();
        L6:
            if (r2 == null) goto L8;
            PkBaseStateMachine.Source r3 = d21.d.b(r0.getEndReason());
        L9:
            if (r3 == null) goto L29;
            PkBaseStateMachine.c r4 = (PkBaseStateMachine.c) r9.j.a.a.get();
            int r5 = com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a.p;
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r6 = r4.a;
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r10 = com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a.C0134a.b(r0, r6.f, r6.g);
            if ((r4 instanceof PkBaseStateMachine.c.C0130c) == false) goto L24;
            r9.j.a(new PkBaseStateMachine.a.C0128a(r10, r3));
            u1 r12 = r0.getBattleSetting();
            if (r12 != null) goto L16;
            return;
        L16:
            if (af2.d.d(r12) == true) goto L18;
            return;
        L18:
            if (r9.n == false) goto L27;
            jy0.b.c("ttlive_PkStateMachine", "anchor call finishPk after getBattleState", null, 4);
            if (d51.c.A0.i() == false) goto L22;
            r9.j();
            return;
        L22:
            r9.c(PkBaseStateMachine.Source.PunishTimeUp);
            return;
        L27:
            return;
        L24:
            return;
        L29:
            return;
        L8:
            r3 = null;
            goto L9
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ PkDoubleDataContext a;

        public f(PkDoubleDataContext r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IBaseUser r3 = (IBaseUser) r2;
            this.a.m605getGuestUser().setValue(r3);
            this.a.setGuestUid(r3.getIdString());
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ PkDoubleDataContext a;

        public g(PkDoubleDataContext r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.m605getGuestUser().setValue(vh7.f.c(IBaseUser.class));
        }
    }

    public static final class h extends i11.c.a {
        public final /* synthetic */ PkDoubleDataContext a;

        public h(PkDoubleDataContext r1) {
            this.a = r1;
        }

        @Override // i11.c.a, i11.c.b
        public final void d(int r4, List<? extends p> r5) {
            Intrinsics.checkNotNullParameter(r5, "list");
            Intrinsics.checkNotNullParameter(r5, "list");
            MutableLiveData<List<com.bytedance.android.live.revlink.impl.multianchor.dynamic.f<p>>> r6 = this.a.m606getLinkAnchorInfo();
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
            Iterator<T> r7 = r5.iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            r0.add(new com.bytedance.android.live.revlink.impl.multianchor.dynamic.f((p) r7.next()));
            goto L4
        L6:
            r6.setValue(r0);
        }
    }

    static {
        Companion = new d();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.a
    public void attach() {
        this.bizHandler.attach();
    }

    public void onEnterRoom() {
    }

    public void onExitRoom() {
        setFinisher(true);
    }

    public void recordGuestRtcLeave() {
        setGuestRtcLeave(true);
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.a
    public void reportUiFirstLoad() {
        this.bizHandler.reportUiFirstLoad();
    }

    public final void resetData() {
        setCurrentMatchType(0);
        setFinisher(false);
        setRealOrgnizer(false);
        setRoomCloser(false);
        setGuestRtcLeave(false);
        setLinkStartTime(0);
        setPlayModeInviter(false);
        setManager(DataType.FALSE);
        setCurAuraType(0);
        this.isFirstPk = true;
        this.isFirstGame = true;
        this.isFeedback = false;
        this.feedbackSelectTags = new ArrayList();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.a
    public void resetPeakData() {
        this.bizHandler.resetPeakData();
    }

    private final i11.b getAnchorLinkUserCenter() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c8();
    }

    private final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e getLinkOptLogContext() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkOptLogContext();
    }

    private final LiveFullLinkPKMonitor getLiveFullLinkPKMonitor() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLiveFullLinkPKMonitor();
    }

    private final d21.d getMergePkHelper() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMergePkHelper();
    }

    private final com.bytedance.android.live.revlink.impl.multianchor.utils.v getMultiLinkMonitor() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiLinkMonitor();
    }

    private final IPKLinkBizDataService getPKLinkBizDataService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mk();
    }

    private final com.bytedance.android.live.revlink.impl.pk.service.e getPKPrecisionMatchService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.lo();
    }

    private final com.bytedance.android.live.revlink.impl.pk.service.f getPkAudienceDataService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Aa();
    }

    private final a21.a getPkBaseLogger() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkBaseLogger();
    }

    private final com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.e getPkBaseResultDataContextObj() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkBaseResultDataContextObj();
    }

    private final w31.c getPkLinkUtils() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkLinkUtils();
    }

    private final com.bytedance.android.live.revlink.impl.pk.service.h getPkService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.V0();
    }

    private final s getRevLinkCommonUtil() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRevLinkCommonUtil();
    }

    private final d31.d getRevLinkLogHelper() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRevLinkLogHelper();
    }

    private final boolean isAnchor() {
        com.bytedance.android.livesdk.revenue.room.a r0 = this.roomContext;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getCommonIsAnchor() != true) goto L7;
        return true;
    }

    private final void setIsPlayModeInviter() {
        boolean r1 = false;
        if (this.isFirstPk == false) goto L25;
        w31.c r0 = getPkLinkUtils();
        if (r0 == null) goto L14;
        if (r0.q() != true) goto L14;
        w31.c r2 = getPkLinkUtils();
        if (r2 != null) goto L11;
    L12:
        r1 = true;
    L28:
        setPlayModeInviter(r1);
        return;
    L11:
        if (r2.e() == true) goto L28;
    L14:
        if (getInviteType() != 13) goto L20;
        w31.c r3 = getPkLinkUtils();
        if (r3 == null) goto L12;
        if (r3.e() == true) goto L28;
    L20:
        w31.c r4 = getPkLinkUtils();
        if (r4 == null) goto L28;
        if (r4.e() != true) goto L28;
    L25:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r5 = this.basePKContext.getPkAnchorLauncher();
        if (r5 == null) goto L28;
        r1 = r5.p();
        goto L28
    }

    private final void updateGuestUserInfo() {
        String r0 = this.guestUid;
        if (r0 != null) goto L5;
    L17:
        jy0.b.a("PkGuestInfoWidget", "Not query, uid: " + this.guestUid);
        return;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 != true) goto L17;
        cy0.e.a.getClass();
        cy0.j r2 = cy0.e.a.a;
        m.e.getClass();
        Object r3 = m.b(r2).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r3);
        com.bytedance.android.livesdk.revenue.service.user.a r4 = (com.bytedance.live.kmp.core.c) r3;
        String r5 = this.guestUid;
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        Single r6 = r4.tm(r5);
        if (r6 == null) goto L19;
        Disposable r7 = r6.subscribe(new f(this), new g(this));
        if (r7 == null) goto L20;
        com.bytedance.revenue.platform.api.core.rx.f.a(r7, this.cd);
        return;
    L20:
        return;
    L19:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final IRoom getRoom() {
        com.bytedance.android.livesdk.revenue.service.room.c r0 = this.roomService;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L7;
        IRoomBase r2 = r1.getCommonRoom();
    L9:
        return (IRoom) r2;
    L7:
        r2 = null;
        goto L9
    }

    public a0 getShellConfig() {
        return this.basePKContext.getShellConfig();
    }

    public boolean isInBreakThrough() {
        return this.basePKContext.isInBreakThrough();
    }

    public boolean isInVote() {
        return this.basePKContext.isInVote();
    }

    public final void onToLinkInOpenGame() {
        if (this.isFirstGame == false) goto L33;
        w31.c r0 = getPkLinkUtils();
        String r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.r();
    L9:
        if (r2 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == false) goto L17;
        return;
    L17:
        if ((this instanceof PkDoubleAnchorDataContext) == true) goto L19;
        Object r4 = null;
    L20:
        PkDoubleAnchorDataContext r5 = (PkDoubleAnchorDataContext) r4;
        if (r5 == null) goto L23;
        com.bytedance.android.live.revlink.impl.control.launchcontext.c r6 = r5.getPkAnchorLaunchContext();
    L24:
        h41.e r7 = this.pkLogger;
        if (r6 == null) goto L27;
        p0 r8 = r6.e;
    L28:
        PkBaseDataContext r9 = this.basePKContext;
        if (r9 == null) goto L31;
        r1 = r9.getEventTrackingInfo();
    L31:
        r7.s("game", r8, r1);
        this.isFirstGame = false;
        return;
    L27:
        r8 = null;
        goto L28
    L23:
        r6 = null;
        goto L24
    L19:
        r4 = this;
        goto L20
    L11:
        if (r2.length() == 0) goto L14;
        r3 = false;
        goto L15
    L7:
        r2 = null;
        goto L9
    }

    public final void onToLinkInPeak() {
        if (this.isFirstPk == false) goto L21;
        String r1 = null;
        if ((this instanceof PkDoubleAnchorDataContext) == true) goto L7;
        Object r0 = null;
    L8:
        PkDoubleAnchorDataContext r2 = (PkDoubleAnchorDataContext) r0;
        if (r2 == null) goto L11;
        com.bytedance.android.live.revlink.impl.control.launchcontext.c r3 = r2.getPkAnchorLaunchContext();
    L12:
        h41.e r4 = this.pkLogger;
        if (r3 == null) goto L15;
        p0 r5 = r3.e;
    L16:
        PkBaseDataContext r6 = this.basePKContext;
        if (r6 == null) goto L19;
        r1 = r6.getEventTrackingInfo();
    L19:
        r4.s("connection", r5, r1);
        this.isFirstPk = false;
        return;
    L15:
        r5 = null;
        goto L16
    L11:
        r3 = null;
        goto L12
    L7:
        r0 = this;
        goto L8
    }

    private final void initLynxGuestData() {
        String r1 = null;
        if (isAnchor() == false) goto L7;
        s r0 = getRevLinkCommonUtil();
        if (r0 == null) goto L12;
        r1 = r0.e();
    L12:
        String r2 = this.guestUid;
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L33
        boolean r4 = false;
        if (r1 != null) goto L16;
    L19:
        boolean r5 = true;
    L20:
        if (r5 == true) goto L22;
        r3.put(r1, new JSONArray());     // Catch: Throwable -> L33
    L22:
        if (r2 != null) goto L24;
    L25:
        r4 = true;
    L26:
        if (r4 == true) goto L28;
        r3.put(r2, new JSONArray());     // Catch: Throwable -> L33
    L28:
        MutableLiveData<String> r6 = m607getPkGuestListStr();     // Catch: Throwable -> L33
        if (r6 == null) goto L31;
        r6.setValue(r3.toString());     // Catch: Throwable -> L33
        goto L31
    L24:
        if (r2.length() != 0) goto L26;
    L16:
        if (r1.length() == 0) goto L19;
        r5 = false;
    L31:
        PkDoubleDataContext$guestLinkLynxInfoObservable$1 r7 = this.guestLinkLynxInfoObservable;
        Intrinsics.checkNotNullParameter(r7, "newObserver");
        vh6.c.b(qr2.c.class).registerPkGuestLynxDataObserver(r7);
        return;
    L7:
        IRoom r8 = getRoom();
        if (r8 == null) goto L12;
        IBaseUser r9 = r8.getOwnerKt();
        if (r9 == null) goto L12;
        r1 = r9.getIdString();
        goto L12
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public /* bridge */ /* synthetic */ LiveData getGuestUser() {
        return m605getGuestUser();
    }

    public /* bridge */ /* synthetic */ LiveData getLinkAnchorInfo() {
        return m606getLinkAnchorInfo();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public /* bridge */ /* synthetic */ LiveData getPkGuestListStr() {
        return m607getPkGuestListStr();
    }

    public /* bridge */ /* synthetic */ LiveData getPkSeasonResult() {
        return m608getPkSeasonResult();
    }

    public /* bridge */ /* synthetic */ LiveData getScoreFirstUpdateEvent() {
        return m609getScoreFirstUpdateEvent();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.impl.pk.vm.pk.e getTeamTaskService() {
        return getTeamTaskService();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public boolean isInContributor() {
        Collection r0 = (Collection) getLeftMvpRankList().getValue();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        List r2 = (List) getLeftMvpRankList().getValue();
        if (r2 == null) goto L14;
        int r3 = r2.size();
    L15:
        int r4 = 0;
    L16:
        if (r4 >= r3) goto L30;
        s r5 = getRevLinkCommonUtil();
        String r6 = null;
        if (r5 == null) goto L20;
        String r7 = r5.e();
    L21:
        List r8 = (List) getLeftMvpRankList().getValue();
        if (r8 == null) goto L27;
        h7.b r9 = (h7.b) ListProtector.get(r8, r4);
        if (r9 == null) goto L27;
        r6 = r9.getUserId();
    L27:
        if (Intrinsics.areEqual(r7, r6) == true) goto L28;
        r4 = r4 + 1;
        goto L16
    L28:
        return true;
    L20:
        r7 = null;
        goto L21
    L30:
        return false;
    L14:
        r3 = 0;
        goto L15
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public boolean canSwitchMulti() {
        return this.canSwitchMulti;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public String getAudienceConnectCnt() {
        return this.audienceConnectCnt;
    }

    public final PkBaseDataContext getBasePKContext() {
        return this.basePKContext;
    }

    public final long getChannelIdField() {
        return this.channelIdField;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public String getConnectionType() {
        return this.connectionType;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return this.context;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public MutableLiveData<Integer> getContributionListAlphaEvent() {
        return this.contributionListAlphaEvent;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public int getCurAuraType() {
        return this.curAuraType;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public int getCurrentMatchType() {
        return this.currentMatchType;
    }

    public final int getDurationField() {
        return this.durationField;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public String getEndReason() {
        return this.endReason;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public Integer getEndType() {
        return this.endType;
    }

    public final List<String> getFeedbackSelectTags() {
        return this.feedbackSelectTags;
    }

    public final String getGuestUid() {
        return this.guestUid;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public PublishSubject<Boolean> getInstallKillMsgEvent() {
        return this.installKillMsgEvent;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public int getInviteType() {
        return this.inviteType;
    }

    public MutableLiveData<Boolean> getLastBattleResultShow() {
        return this.lastBattleResultShow;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public LiveData<List<h7.b>> getLeftMvpRankList() {
        return this.leftMvpRankList;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public long getLinkStartTime() {
        return this.linkStartTime;
    }

    public int getMatchTypeField() {
        return this.matchTypeField;
    }

    public MutableLiveData<Boolean> getOppoIsUsingPropCard() {
        return this.oppoIsUsingPropCard;
    }

    public final h41.e getPkLogger() {
        return this.pkLogger;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public MutableLiveData<Boolean> getPkLynxInfoIsShowing() {
        return this.pkLynxInfoIsShowing;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public MutableLiveData<Boolean> getPkProgressBarAdditionAnim() {
        return this.pkProgressBarAdditionAnim;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public MutableLiveData<Boolean> getPkProgressBarSecKillLine() {
        return this.pkProgressBarSecKillLine;
    }

    public LiveData<Boolean> getPkScoreForceUpdateEvent() {
        return this.pkScoreForceUpdateEvent;
    }

    public LiveData<Long> getPkStarCount() {
        return this.pkStarCount;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public LiveData<List<h7.b>> getRightMvpRankList() {
        return this.rightMvpRankList;
    }

    public final com.bytedance.android.livesdk.revenue.room.a getRoomContext() {
        return this.roomContext;
    }

    public MutableLiveData<Boolean> getSelfIsUsingPropCard() {
        return this.selfIsUsingPropCard;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public MutableLiveData<h0> getTeamTaskOptAddition() {
        return this.teamTaskOptAddition;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public int isBattleStatsObtained() {
        return this.isBattleStatsObtained;
    }

    public final boolean isFeedback() {
        return this.isFeedback;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public boolean isFinisher() {
        return this.isFinisher;
    }

    public boolean isGuestRtcLeave() {
        return this.isGuestRtcLeave;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public String isManager() {
        return this.isManager;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public boolean isPlayModeInviter() {
        return this.isPlayModeInviter;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public boolean isRealOrgnizer() {
        return this.isRealOrgnizer;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public boolean isRoomCloser() {
        return this.isRoomCloser;
    }

    /* JADX INFO: renamed from: getGuestUser, reason: collision with other method in class */
    public MutableLiveData<IBaseUser> m605getGuestUser() {
        return this.guestUser;
    }

    /* JADX INFO: renamed from: getLinkAnchorInfo, reason: collision with other method in class */
    public MutableLiveData<List<com.bytedance.android.live.revlink.impl.multianchor.dynamic.f<p>>> m606getLinkAnchorInfo() {
        return this.linkAnchorInfo;
    }

    /* JADX INFO: renamed from: getPkGuestListStr, reason: collision with other method in class */
    public MutableLiveData<String> m607getPkGuestListStr() {
        return this.pkGuestListStr;
    }

    /* JADX INFO: renamed from: getPkSeasonResult, reason: collision with other method in class */
    public MutableLiveData<t2> m608getPkSeasonResult() {
        return this.pkSeasonResult;
    }

    /* JADX INFO: renamed from: getScoreFirstUpdateEvent, reason: collision with other method in class */
    public MutableLiveData<Boolean> m609getScoreFirstUpdateEvent() {
        return this.scoreFirstUpdateEvent;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public PkLynxInfoViewModel getTeamTaskService() {
        return this.pkLynxInfoViewModel;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(PkDoubleDataContext r0) {
        return r0.cd;
    }

    public static final /* synthetic */ PkContributorDataContext access$getContributorDataContext$p(PkDoubleDataContext r0) {
        return r0.contributorDataContext;
    }

    public static final /* synthetic */ PkDoubleDataContext$guestLinkLynxInfoObservable$1 access$getGuestLinkLynxInfoObservable$p(PkDoubleDataContext r0) {
        return r0.guestLinkLynxInfoObservable;
    }

    public static final /* synthetic */ PkLynxInfoViewModel access$getPkLynxInfoViewModel$p(PkDoubleDataContext r0) {
        return r0.pkLynxInfoViewModel;
    }

    public static final /* synthetic */ h access$getUserCenterCallback$p(PkDoubleDataContext r0) {
        return r0.userCenterCallback;
    }

    private final void onLinkMicBattleFrontRankMessage(o0 r2) {
        ld.a r3 = this.linkDataSet;
        if (r3 == null) goto L7;
        NextLiveData r4 = r3.Lc();
        if (r4 == null) goto L7;
        r4.setValue(Boolean.TRUE);
    L7:
        this._pkScoreForceUpdateEvent.setValue(Boolean.TRUE);
    }

    private final void onMessage(yh6.c r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if ((r2 instanceof o0) == false) goto L8;
        onLinkMicBattleFrontRankMessage((o0) r2);
        return;
    L8:
        if ((r2 instanceof z) == false) goto L11;
        t2 r3 = ((vh7.c) r2).castTo(t2.class);
        m608getPkSeasonResult().postValue(r3);
        return;
    L11:
        if ((r2 instanceof u0) == false) goto L16;
        g5 r4 = ((vh7.c) r2).castTo(g5.class);
        return;
    }

    public String getLinkerID(String r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$linkerID");
        return j.a.a(this, r2);
    }

    public String getUid(String r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$uid");
        return j.a.b(this, r2);
    }

    public void handlePkEnd(boolean r2) {
        setFinisher(true);
        setRoomCloser(r2);
        setEndReason("active");
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.d
    public void onBizReceiveBattleEndPunishMsg(y4 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        resetPeakData();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.d
    public void onBizReceiveBattleFinishMsg(a5 r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        resetPeakData();
        u1 r0 = r6.getBattleSetting();
        Map<String, PkBaseResult> r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getInitiatorId();
    L6:
        setPkEndData(r2, r6.getEndReason(), isFinisher());
        int r3 = r6.getEndReason();
        if (r3 == 0) goto L45;
        if (r3 == 1) goto L40;
        if (r3 != 4) goto L13;
    L36:
        setIsPlayModeInviter();
        if (isAnchor() == false) goto L64;
        this.pkLogger.d();
        return;
    L64:
        return;
    L13:
        if (r3 != 5) goto L15;
    L35:
        this.pkLogger.d();
        return;
    L15:
        if (r3 == 6) goto L24;
        if (r3 == 8) goto L40;
        if (r3 == 16) goto L36;
        switch(r3) {
            case 11: goto L40;
            case 12: goto L22;
            case 13: goto L35;
            case 14: goto L36;
            default: goto L72;
        };
    L22:
        resetData();
        return;
    L72:
        return;
    L24:
        if (isAnchor() == true) goto L26;
    L28:
        MutableLiveData<Map<String, PkBaseResult>> r4 = this.basePKContext.m592getPkBaseResult();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.e r5 = getPkBaseResultDataContextObj();
        if (r5 == null) goto L34;
        Map r7 = r6.getBattleUserInfoMap();
        if (r7 == null) goto L33;
        r1 = MapsKt.toMap(r7);
    L33:
        r1 = r5.a(r1);
    L34:
        r4.setValue(r1);
        this.basePKContext.setSetResultByInstallKill(true);
        l r8 = l.a;
        int r9 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(Observable.timer(3000, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r6)), this.cd);
        return;
    L26:
        if (isFinisher() == true) goto L28;
        h41.e r10 = this.pkLogger;
        r6.getEndReason();
        r6.getKillFinishType();
        r10.t();
    L40:
        if (isAnchor() == true) goto L42;
        return;
    L42:
        if (isFinisher() == true) goto L67;
        h41.e r12 = this.pkLogger;
        r6.getEndReason();
        r6.getKillFinishType();
        r12.t();
        return;
    L67:
        return;
    L45:
        if (isAnchor() == false) goto L69;
        PkBaseStateMachine.c r13 = this.basePKContext.getCurPKBaseState();
        r13.getClass();
        if ((r13 instanceof PkBaseStateMachine.c.C0130c) == true) goto L49;
        return;
    L49:
        if (isFinisher() == true) goto L71;
        h41.e r14 = this.pkLogger;
        LinkedHashMap r15 = new LinkedHashMap();
        if (this.isFeedback == false) goto L53;
        String r16 = DataType.TRUE;
    L54:
        r15.put("is_feedback", r16);
        List<String> r17 = this.feedbackSelectTags;
        if (r17 == null) goto L58;
        String r18 = r17.toString();
        if (r18 == null) goto L58;
    L59:
        r15.put("in_advance_reason", r18);
        Unit r19 = Unit.INSTANCE;
        isRoomCloser();
        r14.f(false, false, r15);
        return;
    L58:
        r18 = "";
        goto L59
    L53:
        r16 = DataType.FALSE;
        goto L54
    L71:
        return;
    L69:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.d
    public void onBizReceiveBattleMsg(c5 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.canSwitchMulti = r2.getCanSwitchMulti();
    }

    public void setAudienceConnectCnt(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.audienceConnectCnt = r2;
    }

    public void setBattleStatsObtained(int r1) {
        this.isBattleStatsObtained = r1;
    }

    public final void setChannelIdField(long r1) {
        this.channelIdField = r1;
    }

    public void setConnectionType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.connectionType = r2;
    }

    public void setContributionListAlphaEvent(MutableLiveData<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.contributionListAlphaEvent = r2;
    }

    public void setCurAuraType(int r1) {
        this.curAuraType = r1;
    }

    public void setCurrentMatchType(int r1) {
        this.currentMatchType = r1;
    }

    public final void setDurationField(int r1) {
        this.durationField = r1;
    }

    public void setEndReason(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.endReason = r2;
    }

    public void setEndType(Integer r1) {
        this.endType = r1;
    }

    public final void setFeedback(boolean r1) {
        this.isFeedback = r1;
    }

    public final void setFeedbackSelectTags(List<String> r1) {
        this.feedbackSelectTags = r1;
    }

    public void setFinisher(boolean r1) {
        this.isFinisher = r1;
    }

    public void setGuestRtcLeave(boolean r1) {
        this.isGuestRtcLeave = r1;
    }

    public final void setGuestUid(String r1) {
        this.guestUid = r1;
    }

    public void setGuestUser(MutableLiveData<IBaseUser> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.guestUser = r2;
    }

    public void setInviteType(int r1) {
        this.inviteType = r1;
    }

    public void setLinkStartTime(long r1) {
        this.linkStartTime = r1;
    }

    public void setManager(String r1) {
        this.isManager = r1;
    }

    public void setMatchTypeField(int r1) {
        this.matchTypeField = r1;
    }

    public void setOppoIsUsingPropCard(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.oppoIsUsingPropCard = r2;
    }

    public void setPkProgressBarAdditionAnim(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.pkProgressBarAdditionAnim = r2;
    }

    public void setPkProgressBarSecKillLine(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.pkProgressBarSecKillLine = r2;
    }

    public void setPkSeasonResult(MutableLiveData<t2> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.pkSeasonResult = r2;
    }

    public void setPlayModeInviter(boolean r1) {
        this.isPlayModeInviter = r1;
    }

    public void setRealOrgnizer(boolean r1) {
        this.isRealOrgnizer = r1;
    }

    public void setRoomCloser(boolean r1) {
        this.isRoomCloser = r1;
    }

    public void setSelfIsUsingPropCard(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.selfIsUsingPropCard = r2;
    }

    public void setTeamTaskOptAddition(MutableLiveData<h0> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.teamTaskOptAddition = r2;
    }

    public static final /* synthetic */ void access$onMessage(PkDoubleDataContext r0, yh6.c r1) {
        r0.onMessage(r1);
    }

    private final void onOnlineListChange(List<? extends p> r4, int r5) {
        Iterator<T> r6 = r4.iterator();
    L3:
        Object r0 = null;
        if (r6.hasNext() == false) goto L11;
        Object r7 = r6.next();
        String r1 = iz.a.a(((p) r7).getUser());
        IRoom r2 = getRoom();
        if (r2 == null) goto L9;
        r0 = IRoomKt_androidKt.getOwnerUserIdString(r2);
    L9:
        if ((!Intrinsics.areEqual(r1, r0)) == false) goto L3;
        r0 = r7;
    L11:
        p r3 = (p) r0;
        if (r3 == null) goto L20;
        String r8 = iz.a.a(r3.getUser());
        if ((!Intrinsics.areEqual(r8, this.guestUid)) == false) goto L21;
        this.guestUid = r8;
        updateGuestUserInfo();
        return;
    L21:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public void onFeedBackInfoUpdate(boolean r1, List<String> r2) {
        this.isFeedback = r1;
        this.feedbackSelectTags = r2;
    }

    public static final /* synthetic */ void access$onOnlineListChange(PkDoubleDataContext r0, List r1, int r2) {
        r0.onOnlineListChange(r1, r2);
    }

    private final void setPkEndData(String r5, int r6, boolean r7) {
        d31.d r0 = getRevLinkLogHelper();
        String r1 = "";
        if (r0 == null) goto L5;
        String r2 = r0.c();
    L6:
        setConnectionType(r2);
        com.bytedance.android.livesdk.revenue.service.room.c r3 = this.roomService;
        if (r3 == null) goto L18;
        com.bytedance.android.livesdk.revenue.room.a r4 = r3.getRoomContext();
        if (r4 == null) goto L18;
        IRoom r8 = r4.getCommonRoom();
        if (r8 == null) goto L18;
        String r9 = IRoomKt_androidKt.getOwnerUserIdString(r8);
        if (r9 == null) goto L18;
        if (Intrinsics.areEqual(r9, r5) == false) goto L17;
        r1 = "active";
        goto L18
    L17:
        r1 = "passive";
    L18:
        setEndReason(r1);
        if (r6 == 14) goto L25;
        if (r6 == 16) goto L25;
        if (r6 == 4) goto L25;
    L28:
        setEndType(Integer.valueOf(r6));
        if (r7 == false) goto L31;
        setEndReason("active");
    L31:
        w31.c r10 = getPkLinkUtils();
        Integer r12 = null;
        if (r10 != null) goto L34;
    L40:
        w31.c r13 = getPkLinkUtils();
        if (r13 != null) goto L43;
    L46:
        if (getRevLinkLogHelper() == null) goto L48;
        r12 = Integer.valueOf(n41.a.b());
    L48:
        setAudienceConnectCnt(String.valueOf(r12));
        return;
    L43:
        if (r13.e() != true) goto L46;
        setManager(DataType.TRUE);
        goto L46
    L34:
        if (r10.q() != true) goto L40;
        d31.d r14 = getRevLinkLogHelper();
        if (r14 == null) goto L38;
        String r15 = r14.o();
    L39:
        setManager(r15);
        goto L46
    L38:
        r15 = null;
    L25:
        if (Intrinsics.areEqual(getEndReason(), "active") == false) goto L27;
        setEndReason("passive");
        goto L28
    L27:
        setEndReason("active");
        goto L28
    L5:
        r2 = "";
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.d
    public void onBizFinishCallback(PkBaseStateMachine.Source r6, f1 r7, Throwable r8) {
        Intrinsics.checkNotNullParameter(r6, "stateSource");
        if (isAnchor() == false) goto L75;
        PkBaseStateMachine.Source r0 = null;
        if (r7 == null) goto L13;
        g1 r1 = r7.getFinishInfo();
        if (r1 == null) goto L13;
        u1 r2 = r1.getBattleSetting();
        if (r2 == null) goto L11;
        String r3 = r2.getInitiatorId();
    L12:
        setPkEndData(r3, r1.getEndReason(), isFinisher());
        goto L13
    L11:
        r3 = null;
    L13:
        PkBaseStateMachine.Source r4 = PkBaseStateMachine.Source.CutShort;
        boolean r5 = false;
        if (r6 == r4) goto L16;
    L27:
        if (r7 != null) goto L30;
        r0 = r6;
    L36:
        if (r0 != r4) goto L38;
    L47:
        com.bytedance.android.live.revlink.impl.pk.service.h r9 = getPkService();
        if (r9 == null) goto L51;
        r9.finish("finish_pk");
    L51:
        if (r6 != PkBaseStateMachine.Source.PKTimeUp) goto L53;
    L55:
        boolean r10 = false;
    L57:
        if (r6 == PkBaseStateMachine.Source.PunishTimeUp) goto L76;
        PkBaseStateMachine.c r12 = this.basePKContext.getCurPKBaseState();
        r12.getClass();
        if ((r12 instanceof PkBaseStateMachine.c.C0130c) == false) goto L77;
        h41.e r13 = this.pkLogger;
        if (r0 != PkBaseStateMachine.Source.RtcLinkerLeave) goto L63;
        r5 = true;
    L63:
        LinkedHashMap r14 = new LinkedHashMap();
        if (this.isFeedback == false) goto L66;
        String r15 = DataType.TRUE;
    L67:
        r14.put("is_feedback", r15);
        List<String> r16 = this.feedbackSelectTags;
        if (r16 == null) goto L71;
        String r17 = r16.toString();
        if (r17 == null) goto L71;
    L72:
        r14.put("in_advance_reason", r17);
        Unit r18 = Unit.INSTANCE;
        isRoomCloser();
        r13.f(r10, r5, r14);
        return;
    L71:
        r17 = "";
        goto L72
    L66:
        r15 = DataType.FALSE;
        goto L67
    L77:
        return;
    L76:
        return;
    L53:
        if (r6 == PkBaseStateMachine.Source.PunishTimeUp) goto L55;
        r10 = true;
        goto L57
    L38:
        if (r0 == PkBaseStateMachine.Source.RoomClose) goto L47;
        if (r0 == PkBaseStateMachine.Source.NormalToMultiple) goto L47;
        if (r0 != PkBaseStateMachine.Source.RtcLinkerLeave) goto L51;
        com.bytedance.android.live.revlink.impl.pk.service.h r19 = getPkService();
        if (r19 == null) goto L51;
        r19.finish("rtc_user_leaved_callback");
        goto L51
    L30:
        if (getMergePkHelper() == null) goto L36;
        g1 r20 = r7.getFinishInfo();
        if (r20 == null) goto L34;
        int r22 = r20.getEndReason();
    L35:
        r0 = d21.d.b(r22);
        goto L36
    L34:
        r22 = 0;
        goto L35
    L16:
        if ((r8 instanceof ApiServerException) == true) goto L18;
        Throwable r23 = null;
    L19:
        ApiServerException r24 = (ApiServerException) r23;
        if (r24 == null) goto L27;
        if (r24.getErrorCode() != 4004266) goto L27;
        int r25 = ToastUtil.a;
        ToastUtil.b(((ApiServerException) r8).getPrompt(), 0);
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r26 = getMultiLinkMonitor();
        if (r26 == null) goto L74;
        Intrinsics.checkNotNullParameter((Exception) r8, "exception");
        LinkedHashMap r27 = new LinkedHashMap();
        r26.f(r27);
        int r28 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.b("ttlive_anchor_link", "finish_pk_failed_when_inviting: " + r27, null);
        return;
    L74:
        return;
    L18:
        r23 = r8;
        goto L19
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.d
    public void onBizPenal(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r9, PkBaseStateMachine.Source r10, PkBaseStateMachine.c r12) {
        Intrinsics.checkNotNullParameter(r9, "pkInfo");
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r12, "toState");
        if (r10 != PkBaseStateMachine.Source.MetaUpdate) goto L10;
        PkBaseDataContext r13 = this.basePKContext;
        com.bytedance.android.live.revlink.impl.pk.service.f r14 = getPkAudienceDataService();
        if (r14 == null) goto L8;
        String r15 = r14.getConnectSource();
        if (r15 == null) goto L8;
    L9:
        r13.setPkSource(r15);
    L8:
        r15 = DataType.Normal;
    L10:
        IBaseBattleSetting r16 = r9.a;
        if (r16 == null) goto L25;
        setCurrentMatchType((int) r16.getMatchType());
        if (r16.getPunishStartTimeMs() == 0) goto L16;
        long r0 = r16.getPunishStartTimeMs() - com.bytedance.live.kmp.util.e.b();
    L20:
        if (r16.getPunishDuration() == 0) goto L22;
        long r2 = r16.getPunishDuration();
    L23:
        StringBuilder r17 = new StringBuilder("penal start count down ");
        long r4 = WebcastRedirectException.UNKNOWN;
        long r3 = (r2 * r4) + r0;
        r17.append(String.valueOf(r3));
        jy0.b.d("ttlive_PkDoubleDataContext", r17.toString());
        long r5 = r3 / r4;
        goto L25
    L22:
        r2 = af2.d.a(r16);
        goto L23
    L16:
        if (r16.getStartTimeMs() == 0) goto L18;
        r0 = (r16.getStartTimeMs() - com.bytedance.live.kmp.util.e.b()) + (r16.getDuration() * ((long) WebcastRedirectException.UNKNOWN));
        goto L20
    L18:
        r0 = 0;
    L25:
        if (isAnchor() == true) goto L27;
        cy0.e.a.getClass();
        cy0.j r18 = cy0.e.a.a;
        m.e.getClass();
        Object r19 = m.b(r18).b(com.bytedance.android.livesdk.revenue.service.gift.a.class);
        Intrinsics.checkNotNull(r19);
        ((com.bytedance.live.kmp.core.c) r19).setNeedShowGiftEffectSwitch(true);
        return;
    L27:
        z4 r20 = r9.n;
        String r110 = "";
        if (r20 == null) goto L35;
        Map r22 = r20.getFollowLeadMap();
        if (r22 == null) goto L35;
        String r111 = this.guestUid;
        if (r111 != null) goto L34;
        r111 = "";
    L34:
        Boolean r23 = (Boolean) r22.get(r111);
    L37:
        if (Intrinsics.areEqual(r23, Boolean.TRUE) == false) goto L47;
        IPKLinkBizDataService r24 = getPKLinkBizDataService();
        if (r24 == null) goto L48;
        String r112 = this.guestUid;
        if (r112 == null) goto L44;
        r110 = r112;
    L44:
        r24.setFollowPromotedUID(r110);
        return;
    L48:
        return;
    L47:
        return;
    L35:
        r23 = null;
        goto L37
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.d
    public void onBizFinished(boolean r1, PkBaseStateMachine.c r2, PkBaseStateMachine.c r3, boolean r4) {
        if (isAnchor() == true) goto L5;
        cy0.e.a.getClass();
        cy0.j r5 = cy0.e.a.a;
        m.e.getClass();
        Object r6 = m.b(r5).b(com.bytedance.android.livesdk.revenue.service.gift.a.class);
        Intrinsics.checkNotNull(r6);
        ((com.bytedance.live.kmp.core.c) r6).setNeedShowGiftEffectSwitch(true);
    L5:
        resetPeakData();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.d
    public void onBizPK(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r8, PkBaseStateMachine.c r9, PkBaseStateMachine.c r10, PkBaseStateMachine.Source r12, boolean r13, PlayMode r14) {
        Intrinsics.checkNotNullParameter(r8, "pkInfo");
        Intrinsics.checkNotNullParameter(r9, "fromState");
        Intrinsics.checkNotNullParameter(r10, "toState");
        Intrinsics.checkNotNullParameter(r12, "source");
        if (r12 != PkBaseStateMachine.Source.MetaUpdate) goto L10;
        PkBaseDataContext r15 = this.basePKContext;
        com.bytedance.android.live.revlink.impl.pk.service.f r16 = getPkAudienceDataService();
        if (r16 == null) goto L8;
        String r17 = r16.getConnectSource();
        if (r17 == null) goto L8;
    L9:
        r15.setPkSource(r17);
    L8:
        r17 = DataType.Normal;
    L10:
        a21.a r18 = getPkBaseLogger();
        if (r18 == null) goto L17;
        long r19 = this.basePKContext.getPkId();
        String r110 = this.basePKContext.getPkSource();
        c21.f r111 = this.basePKContext.getCurBattlePlayMode();
        if (r111 == null) goto L15;
        String r112 = r111.b();
    L16:
        r18.c(r19, r110, r112);
        goto L17
    L15:
        r112 = "routine";
    L17:
        IBaseBattleSetting r20 = r8.a;
        if (r20 == null) goto L20;
        long r113 = r20.getMatchType();
    L21:
        setCurrentMatchType((int) r113);
        if (this.isFirstPk == false) goto L25;
        setIsPlayModeInviter();
    L25:
        if (r8.a == null) goto L29;
        wq2.f r22 = this.dataCenterService;
        if (r22 == null) goto L29;
        r22.Mj();
    L29:
        getPkLynxInfoIsShowing().postValue(Boolean.FALSE);
        com.bytedance.android.live.revlink.impl.pk.service.e r23 = getPKPrecisionMatchService();
        if (r23 == null) goto L32;
        r23.resetPrecisionMatch();
    L32:
        setEndReason("");
        setCurAuraType(0);
        gt1.d r114 = new gt1.d(5);
        ld.a r115 = this.linkDataSet;
        if (r115 == null) goto L37;
        NextLiveData r116 = r115.Y1();
        if (r116 == null) goto L37;
        r116.setValue(r114);
    L37:
        wq2.f r117 = this.dataCenterService;
        if (r117 == null) goto L40;
        r117.S1(r114);
    L40:
        LiveFullLinkPKMonitor r118 = getLiveFullLinkPKMonitor();
        if (r118 == null) goto L43;
        int r119 = BattleType.NORMAL_PK.ordinal();
        i97.a r0 = i97.a.a;
        r118.j = System.currentTimeMillis();
        r118.k = r119;
    L43:
        y11.d r120 = null;
        if (isAnchor() == false) goto L48;
        LiveFullLinkPKMonitor r121 = getLiveFullLinkPKMonitor();
        if (r121 == null) goto L48;
        LiveFullLinkPKMonitor.t(r121, "live_pk_score_bar_load", null, null, 6);
    L48:
        boolean r122 = this instanceof PkDoubleAnchorDataContext;
        if (r122 == true) goto L51;
        Object r1 = null;
    L52:
        PkDoubleAnchorDataContext r2 = (PkDoubleAnchorDataContext) r1;
        if (r2 == null) goto L55;
        r2.getPkAnchorLaunchContext();
    L55:
        if (r122 == true) goto L57;
        Object r123 = null;
    L58:
        PkDoubleAnchorDataContext r124 = (PkDoubleAnchorDataContext) r123;
        if (r124 == null) goto L63;
        com.bytedance.android.live.revlink.impl.control.launchcontext.c r125 = r124.getPkAnchorLaunchContext();
        if (r125 == null) goto L63;
        p0 r126 = r125.e;
    L64:
        h41.e r3 = this.pkLogger;
        PkBaseDataContext r4 = this.basePKContext;
        q11.b.d r5 = q11.b.d.b;
        r3.w(r4, this, r4.isBaseOnceMore(), this.isFirstPk);
        if (this.isFirstPk == false) goto L108;
        w31.c r6 = getPkLinkUtils();
        if (r6 == null) goto L73;
        IPKLinkBizDataService r7 = r6.g();
        if (r7 == null) goto L73;
        if (r7.getIsSwitchFromLink() == true) goto L73;
        this.pkLogger.s("pk", r126, this.basePKContext.getEventTrackingInfo());
    L73:
        h41.e r127 = this.pkLogger;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r24 = r127.l();
        if (r127.e == true) goto L107;
        long r25 = 0;
        LinkCrossRoomDataHolder r26 = r127.b;
        if (r26 != null) goto L78;
    L80:
        LinkedHashMap r27 = new LinkedHashMap();
        if (r24 != null) goto L83;
    L92:
        r27.put("anchor_connect_status", "2");
        x11.a r28 = r127.f;
        if (r28 == null) goto L95;
        r120 = r28.getPkService();
    L95:
        if (r120 != null) goto L97;
    L102:
        String r128 = "routine_pk";
    L103:
        r27.put("invite_mode", r128);
        n r129 = new n();
        Map<String, String> r29 = r129.a;
        Intrinsics.checkNotNullParameter(r29, "map");
        Intrinsics.checkNotNullParameter(r27, "map");
        r29.putAll(r27);
        mz0.m r30 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r32 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r32, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live_function", "belong");
        r32.a("live_function");
        Intrinsics.checkNotNullParameter("live_detail", "page");
        r32.c("live_detail");
        ((ArrayList) r30.a).add(r32.a);
        com.bytedance.android.livesdk.revenue.log.h r33 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r33, "linkInfoLog");
        r33.c(r25);
        ((ArrayList) r30.a).add(r33.a);
        LinkCrossRoomDataHolder r130 = r127.g();
        if (r130 == null) goto L106;
        r130.m(r30);
    L106:
        r30.b(LogCommon.ROOM);
        ((ArrayList) r129.b).addAll(r30.a);
        cy0.e.a.getClass();
        cy0.j r131 = cy0.e.a.a;
        m.e.getClass();
        Object r132 = m.b(r131).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r132);
        ((mz0.i) ((f80.a) r132)).w3("pk_transform", r129.a, r129.b);
        goto L107
    L97:
        if (r120.getInviteMode().length() <= 0) goto L99;
        boolean r34 = true;
    L100:
        if (r34 != true) goto L102;
        r128 = r120.getInviteMode();
        goto L103
    L99:
        r34 = false;
        goto L100
    L83:
        if (r24.modType() != PkBaseDataContext.PKModType.Vote) goto L92;
        r27.put("invite_mode", "vote");
        if (r24.getVoteSetting() == null) goto L92;
        aa r35 = r24.getVoteSetting();
        if (r35 == null) goto L90;
        String r36 = r35.getVoteDes();
        if (r36 == null) goto L90;
    L91:
        r27.put(FileUtils.PICTURE_THEME, r36);
    L90:
        r36 = "";
        goto L91
    L78:
        if (r26.i() != 0) goto L80;
        r25 = r127.b.f();
    L107:
        this.isFirstPk = false;
    L108:
        w31.c r133 = getPkLinkUtils();
        if (r133 == null) goto L118;
        IPKLinkBizDataService r134 = r133.g();
        if (r134 == null) goto L118;
        if (getLinkStartTime() != 0) goto L118;
        if (r134.getLinkStartTime() <= 0) goto L117;
        setLinkStartTime(r134.getLinkStartTime());
        goto L118
    L117:
        i97.a r135 = i97.a.a;
        setLinkStartTime(System.currentTimeMillis());
    L118:
        d31.d r136 = getRevLinkLogHelper();
        if (r136 == null) goto L121;
        String r137 = r136.c();
    L122:
        setConnectionType(r137);
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r138 = getLinkOptLogContext();
        if (r138 == null) goto L125;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r138.c = "";
    L125:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r139 = getLinkOptLogContext();
        if (r139 == null) goto L128;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r139.d = "";
    L128:
        getTeamTaskOptAddition().setValue(new h0(0, 0, 0, 0));
        return;
    L121:
        r137 = "";
    L63:
        r126 = null;
        goto L64
    L57:
        r123 = this;
        goto L58
    L51:
        r1 = this;
        goto L52
    L20:
        r113 = 0;
        goto L21
    }

    /* JADX WARN: Type inference failed for: r1v35, types: [com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleDataContext$guestLinkLynxInfoObservable$1] */
    public PkDoubleDataContext(long r18, String r20, boolean r22, ld.a r23, wq2.f r24, com.bytedance.android.livesdk.revenue.service.room.c r25, com.bytedance.android.live.revlink.impl.global.c r26, yz0.f r27, com.bytedance.android.livesdk.revenue.service.message.d r28, x11.a r29, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r210, com.bytedance.android.live.revlink.impl.mergepk.pkdouble.a r30, PkBaseDataContext r32) {
        Intrinsics.checkNotNullParameter(r210, "context");
        Intrinsics.checkNotNullParameter(r30, "bizHandler");
        this.channelIdField = r18;
        this.guestUid = r20;
        this.linkDataSet = r23;
        this.dataCenterService = r24;
        this.roomService = r25;
        this.linkFakeGlobalService = r26;
        this.messageService = r27;
        this.messageManagerService = r28;
        this.context = r210;
        this.bizHandler = r30;
        CompositeDisposable r15 = new CompositeDisposable();
        this.cd = r15;
        if (r32 != null) goto L8;
        final PkBaseDataContext r14 = r10;
        PkBaseDataContext r10 = new PkBaseDataContext(PkDoubleDataContext$basePKContext$1.INSTANCE, r22, r23, r24, r25, r26, r27, r29, getContext());
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) com.bytedance.live.datacontext.d.a(new PkDoubleDataContext$basePKContext$2$1(r14)).getSecond(), r15);
        if (r26 == null) goto L7;
        PkBaseDataContext r1 = (PkBaseDataContext) r26.T6(PkBaseDataContext.TAG, r14);
    L7:
        Unit r2 = Unit.INSTANCE;
    L9:
        com.bytedance.revenue.platform.api.core.rx.f.a(r14.registerBiz(this, PKBizType.ClassicDouble), r15);
        Unit r3 = Unit.INSTANCE;
        this.basePKContext = r14;
        IPKLinkBizDataService r4 = getPKLinkBizDataService();
        if (r4 == null) goto L14;
        IPKLinkBizDataService.d r5 = r4.getLinkTypeParams();
        if (r5 == null) goto L14;
        int r6 = r5.a;
    L15:
        this.matchTypeField = r6;
        IPKLinkBizDataService r7 = getPKLinkBizDataService();
        if (r7 == null) goto L20;
        IPKLinkBizDataService.d r8 = r7.getLinkTypeParams();
        if (r8 == null) goto L20;
        int r9 = r8.b;
    L21:
        this.inviteType = r9;
        this.guestUser = new MutableLiveData();
        this.pkGuestListStr = r14.m593getPkGuestListStr();
        this.isFirstPk = true;
        this.isFirstGame = true;
        Integer r12 = null;
        if (r25 == null) goto L24;
        com.bytedance.android.livesdk.revenue.room.a r13 = r25.getRoomContext();
    L25:
        this.roomContext = r13;
        this.pkLogger = new h41.e(r26, r22, getRoom(), r29);
        this.feedbackSelectTags = new ArrayList();
        this.connectionType = "";
        if (d51.c.A0.m() == true) goto L29;
        r12 = 0;
    L29:
        this.endType = r12;
        this.endReason = "";
        this.isManager = DataType.FALSE;
        this.leftMvpRankList = r14.m590getLeftMvpRankList();
        this.rightMvpRankList = r14.m594getRightMvpRankList();
        this.pkSeasonResult = new MutableLiveData();
        this.pkStarCount = r14.getResultDataContext().getPkStarCount();
        this.pkLynxInfoIsShowing = new MutableLiveData();
        this.pkProgressBarSecKillLine = new MutableLiveData();
        this.pkProgressBarAdditionAnim = new MutableLiveData();
        this.teamTaskOptAddition = new MutableLiveData();
        this.contributionListAlphaEvent = new MutableLiveData();
        int r16 = o.a;
        this.installKillMsgEvent = PublishSubject.create();
        this.lastBattleResultShow = new MutableLiveData();
        MutableLiveData<Boolean> r17 = new MutableLiveData();
        this._pkScoreForceUpdateEvent = r17;
        this.pkScoreForceUpdateEvent = r17;
        this.scoreFirstUpdateEvent = r14.getScoreDataContext().getScoreFirstUpdate();
        PkContributorDataContext r19 = new PkContributorDataContext(r14.m592getPkBaseResult(), r14.m589getBattleStatsMeta(), r25, r26, r27, r28);
        this.contributorDataContext = r19;
        this.audienceConnectCnt = DataType.FALSE;
        this.canSwitchMulti = true;
        this.pkLynxInfoViewModel = new PkLynxInfoViewModel(r14, this, r25, r26, r27);
        this.oppoIsUsingPropCard = new MutableLiveData();
        this.selfIsUsingPropCard = new MutableLiveData();
        this.linkAnchorInfo = new MutableLiveData();
        this.guestLinkLynxInfoObservable = new PkDoubleDataContext$guestLinkLynxInfoObservable$1(this);
        h r33 = new h(this);
        this.userCenterCallback = r33;
        if (r27 == null) goto L36;
        com.bytedance.android.live.revenue.common.message.a r34 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r35 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r34, "$this$LINK_MIC_BATTLE_FRONT_RANK");
        Observable r36 = yz0.h.a.a(r27, (yh6.b) CommonMessageTypeKt.l.getValue(), false, 6);
        if (r36 == null) goto L36;
        final AnonymousClass1 r37 = new AnonymousClass1(this);
        Disposable r38 = r36.subscribe(new i(r37));
        if (r38 == null) goto L36;
        com.bytedance.revenue.platform.api.core.rx.f.a(r38, r15);
    L36:
        if (r27 == null) goto L42;
        com.bytedance.android.live.revenue.common.message.a r39 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r40 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r39, "$this$BATTLE_SEASON_PK_RESULT_MESSAGE");
        Observable r42 = yz0.h.a.a(r27, (yh6.b) CommonMessageTypeKt.s.getValue(), false, 6);
        if (r42 == null) goto L42;
        final AnonymousClass2 r43 = new AnonymousClass2(this);
        Disposable r44 = r42.subscribe(new i(r43));
        if (r44 == null) goto L42;
        com.bytedance.revenue.platform.api.core.rx.f.a(r44, r15);
    L42:
        if (r27 == null) goto L48;
        Observable r45 = yz0.h.a.a(r27, CommonMessageTypeKt.c(com.bytedance.android.live.revenue.common.message.a.g), false, 6);
        if (r45 == null) goto L48;
        final AnonymousClass3 r46 = new AnonymousClass3(this);
        Disposable r47 = r45.subscribe(new i(r46));
        if (r47 == null) goto L48;
        com.bytedance.revenue.platform.api.core.rx.f.a(r47, r15);
    L48:
        cy0.e.a.getClass();
        cy0.j r48 = cy0.e.a.a;
        m.e.getClass();
        Object r49 = m.b(r48).b(com.bytedance.android.livesdk.revenue.service.gift.a.class);
        Intrinsics.checkNotNull(r49);
        ((com.bytedance.live.kmp.core.c) r49).C3(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(getOnCleared().subscribe(new a(this)), r15);
        AnchorLinkUserCenterV2 r50 = r14.getUserCenter();
        if (r50 == null) goto L51;
        r50.i(r33);
    L51:
        com.bytedance.revenue.platform.api.core.rx.f.a(r19.getLeftMvpRankList().a().subscribe(new b(this)), r15);
        com.bytedance.revenue.platform.api.core.rx.f.a(r19.getRightMvpRankList().a().subscribe(new c(this)), r15);
        initLynxGuestData();
        updateGuestUserInfo();
        i11.b r52 = getAnchorLinkUserCenter();
        if (r52 == null) goto L56;
        Disposable r53 = r52.m(new AnonymousClass7(this));
        if (r53 == null) goto L56;
        com.bytedance.revenue.platform.api.core.rx.f.a(r53, r15);
    L56:
        i11.b r54 = getAnchorLinkUserCenter();
        if (r54 == null) goto L60;
        List<p> r55 = r54.getOnlineUserList();
        if (r55 == null) goto L60;
    L61:
        onOnlineListChange(r55, 1);
        return;
    L60:
        r55 = CollectionsKt.emptyList();
        goto L61
    L24:
        r13 = null;
    L20:
        r9 = 0;
    L14:
        r6 = 0;
        goto L15
    L8:
        r14 = r32;
        goto L9
    }

    public /* synthetic */ PkDoubleDataContext(long r17, String r19, boolean r20, ld.a r22, wq2.f r23, com.bytedance.android.livesdk.revenue.service.room.c r24, com.bytedance.android.live.revlink.impl.global.c r25, yz0.f r26, com.bytedance.android.livesdk.revenue.service.message.d r27, x11.a r28, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r29, com.bytedance.android.live.revlink.impl.mergepk.pkdouble.a r210, PkBaseDataContext r30, int r32, DefaultConstructorMarker r33) {
        if ((r32 & 4096) == 0) goto L5;
        PkBaseDataContext r15 = null;
    L6:
        this(r17, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r210, r15);
        return;
    L5:
        r15 = r30;
        goto L6
    }
}
