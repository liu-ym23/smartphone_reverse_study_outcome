package com.bytedance.android.live.revlink.impl.mergepk.pkbase;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.PkAnchorLauncher;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.k;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkStateMachineController;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseModeDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseResult;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseResultDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseScoreDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subplaymode.BaseBreakThroughDataContext;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkCustomizePlayDataContext;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.impl.service.internal.LinkRevInternalServiceContext;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.biz.service.j;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.IBattleBarConfig;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.IPropInfoNotifyResponse;
import com.bytedance.android.livesdk.link.model.a5;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.bridge.u0;
import com.bytedance.android.livesdk.link.model.bridge.y1;
import com.bytedance.android.livesdk.link.model.c1;
import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.c5;
import com.bytedance.android.livesdk.link.model.ca;
import com.bytedance.android.livesdk.link.model.d1;
import com.bytedance.android.livesdk.link.model.e1;
import com.bytedance.android.livesdk.link.model.f1;
import com.bytedance.android.livesdk.link.model.f4;
import com.bytedance.android.livesdk.link.model.g1;
import com.bytedance.android.livesdk.link.model.g5;
import com.bytedance.android.livesdk.link.model.h3;
import com.bytedance.android.livesdk.link.model.h7;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.m3;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.r;
import com.bytedance.android.livesdk.link.model.s5;
import com.bytedance.android.livesdk.link.model.u1;
import com.bytedance.android.livesdk.link.model.v0;
import com.bytedance.android.livesdk.link.model.v2;
import com.bytedance.android.livesdk.link.model.w0;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.android.livesdk.link.model.y3;
import com.bytedance.android.livesdk.link.model.y4;
import com.bytedance.android.livesdk.link.model.z;
import com.bytedance.android.livesdk.link.model.z2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.scope.m;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.revenue.platform.api.core.rx.h;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.o;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000´\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Í\u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004Î\u0003Ï\u0003Bt\u0012\u000e\u0010Ò\u0002\u001a\t\u0012\u0004\u0012\u00020A0Ñ\u0002\u0012\u0007\u0010Ö\u0002\u001a\u00020\b\u0012\n\u0010Ø\u0002\u001a\u0005\u0018\u00010×\u0002\u0012\n\u0010Ý\u0002\u001a\u0005\u0018\u00010Ü\u0002\u0012\n\u0010â\u0002\u001a\u0005\u0018\u00010á\u0002\u0012\n\u0010ç\u0002\u001a\u0005\u0018\u00010æ\u0002\u0012\n\u0010ì\u0002\u001a\u0005\u0018\u00010ë\u0002\u0012\n\u0010ñ\u0002\u001a\u0005\u0018\u00010ð\u0002\u0012\b\u0010ö\u0002\u001a\u00030õ\u0002¢\u0006\u0006\bË\u0003\u0010Ì\u0003J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002J\u001c\u0010\r\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J(\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J(\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J4\u0010 \u001a\u00020\u00102\b\b\u0002\u0010\u001e\u001a\u00020\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u001f\u001a\u00020\bH\u0002J\u0012\u0010!\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010\"\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010#\u001a\u00020\u0010H\u0002J\b\u0010$\u001a\u00020\bH\u0002J\u001e\u0010(\u001a\u00020\b2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0002J\u0018\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+2\b\u0010*\u001a\u0004\u0018\u00010)H\u0002J\u001a\u00101\u001a\u00060/j\u0002`02\u0006\u0010.\u001a\u00020,2\u0006\u0010*\u001a\u00020)J\u0006\u00102\u001a\u00020\u000eJ\u0012\u00104\u001a\u00020\u00102\b\u00103\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u00107\u001a\u00020\u00102\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u000205\u0018\u00010%J\b\u00108\u001a\u000205H\u0016J\b\u00109\u001a\u00020\bH\u0016J\n\u0010;\u001a\u0004\u0018\u00010:H\u0016J\u0006\u0010<\u001a\u00020\bJ\b\u0010=\u001a\u00020\bH\u0016J\b\u0010>\u001a\u00020\u0010H\u0016J\b\u0010?\u001a\u00020\u0010H\u0016J\b\u0010@\u001a\u0004\u0018\u00010\u000eJ\b\u0010B\u001a\u00020AH\u0016J\u0016\u0010F\u001a\u00020\u00102\u000e\u0010E\u001a\n\u0018\u00010Cj\u0004\u0018\u0001`DJ\u0010\u0010I\u001a\u00020\u00102\u0006\u0010H\u001a\u00020GH\u0016J\u001a\u0010L\u001a\u00020\u00102\b\u0010H\u001a\u0004\u0018\u00010G2\u0006\u0010K\u001a\u00020JH\u0016J\u0010\u0010O\u001a\u00020\u00102\u0006\u0010N\u001a\u00020MH\u0016J\u0010\u0010Q\u001a\u00020\u00102\u0006\u0010N\u001a\u00020PH\u0016J\u0010\u0010S\u001a\u00020\u00102\u0006\u0010N\u001a\u00020RH\u0016J\u001a\u0010W\u001a\u00020\u00102\b\u0010U\u001a\u0004\u0018\u00010T2\u0006\u0010V\u001a\u00020\bH\u0016J\b\u0010Y\u001a\u00020XH\u0016J\u0016\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020Z\u0018\u00010%H\u0016J\n\u0010]\u001a\u0004\u0018\u00010\\H\u0016J\n\u0010^\u001a\u0004\u0018\u00010\\H\u0016J\b\u0010_\u001a\u000205H\u0016J\b\u0010`\u001a\u000205H\u0016J\b\u0010a\u001a\u000205H\u0016J\b\u0010b\u001a\u00020AH\u0016J\b\u0010c\u001a\u00020\bH\u0016J\b\u0010d\u001a\u00020AH\u0016J\b\u0010e\u001a\u00020\bH\u0016J\b\u0010f\u001a\u00020\bH\u0016J\b\u0010g\u001a\u00020\bH\u0016J\b\u0010h\u001a\u00020\bH\u0016J\b\u0010i\u001a\u00020\bH\u0016J\b\u0010j\u001a\u00020\bH\u0016J\b\u0010k\u001a\u00020\bH\u0016J\b\u0010l\u001a\u00020\bH\u0016J\b\u0010m\u001a\u00020\bH\u0016J\u0010\u0010o\u001a\u00020\b2\u0006\u0010n\u001a\u00020\u000eH\u0016J\u0010\u0010q\u001a\u00020\b2\u0006\u0010p\u001a\u00020\bH\u0016J\n\u0010s\u001a\u0004\u0018\u00010rH\u0016J\b\u0010t\u001a\u00020AH\u0016J\b\u0010u\u001a\u00020\u000eH\u0016J\n\u0010w\u001a\u0004\u0018\u00010vH\u0016J\n\u0010y\u001a\u0004\u0018\u00010xH\u0016J\n\u0010{\u001a\u0004\u0018\u00010zH\u0016J\n\u0010}\u001a\u0004\u0018\u00010|H\u0016J\b\u0010~\u001a\u000205H\u0016J\u0016\u0010\u007f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0016J\t\u0010\u0080\u0001\u001a\u00020\u000eH\u0016J\u0018\u0010\u0082\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u000e\u0012\u0005\u0012\u00030\u0081\u0001\u0018\u00010%H\u0016J\f\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0016J\n\u0010\u0086\u0001\u001a\u00030\u0085\u0001H\u0016J\u000b\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J\t\u0010\u0088\u0001\u001a\u00020AH\u0016J\u000b\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J\f\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u0001H\u0016J\f\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0016J\t\u0010\u008e\u0001\u001a\u00020\bH\u0016J\f\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0016J\u0012\u0010\u0092\u0001\u001a\u00020A2\u0007\u0010\u0091\u0001\u001a\u00020\u000eH\u0016J\t\u0010\u0093\u0001\u001a\u00020\bH\u0016J\t\u0010\u0094\u0001\u001a\u00020\u0010H\u0016J\u0007\u0010\u0095\u0001\u001a\u00020\u0010J\t\u0010\u0096\u0001\u001a\u00020\u000eH\u0016J*\u0010\u009c\u0001\u001a\u00020\u00102\u0007\u0010\u0097\u0001\u001a\u00020\u001a2\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0098\u00012\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0016J&\u0010\u009e\u0001\u001a\u001f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0%j\u000f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`\u009d\u0001H\u0016J\f\u0010 \u0001\u001a\u0005\u0018\u00010\u009f\u0001H\u0016J\u001f\u0010¥\u0001\u001a\u00020\u00102\b\u0010¢\u0001\u001a\u00030¡\u00012\n\u0010¤\u0001\u001a\u0005\u0018\u00010£\u0001H\u0016J\u0013\u0010¨\u0001\u001a\u00020\u00102\b\u0010§\u0001\u001a\u00030¦\u0001H\u0016J\u0017\u0010«\u0001\u001a\u00020\u00102\f\u0010ª\u0001\u001a\u000705j\u0003`©\u0001H\u0016R+\u0010®\u0001\u001a\u0016\u0012\u0004\u0012\u00020)\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020,0\u00ad\u00010¬\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u001c\u0010±\u0001\u001a\u0005\u0018\u00010°\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u001c\u0010´\u0001\u001a\u0005\u0018\u00010³\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u001f\u0010·\u0001\u001a\u0005\u0018\u00010¶\u00018\u0006¢\u0006\u0010\n\u0006\b·\u0001\u0010¸\u0001\u001a\u0006\b¹\u0001\u0010º\u0001R&\u0010»\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0\u00ad\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b»\u0001\u0010¼\u0001\u001a\u0006\b½\u0001\u0010¾\u0001R\u001d\u0010À\u0001\u001a\u00030¿\u00018\u0006¢\u0006\u0010\n\u0006\bÀ\u0001\u0010Á\u0001\u001a\u0006\bÂ\u0001\u0010Ã\u0001R)\u0010Ä\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÄ\u0001\u0010Å\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R3\u0010Í\u0001\u001a\u0016\u0012\u0005\u0012\u00030Ë\u00010Ê\u0001j\n\u0012\u0005\u0012\u00030Ë\u0001`Ì\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÍ\u0001\u0010Î\u0001\u001a\u0006\bÏ\u0001\u0010Ð\u0001R?\u0010Ô\u0001\u001a\"\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ò\u00010+0Ñ\u0001j\u0010\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ò\u00010+`Ó\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÔ\u0001\u0010Õ\u0001\u001a\u0006\bÖ\u0001\u0010×\u0001RI\u0010Ø\u0001\u001a,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020&0%0Ñ\u0001j\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020&0%`Ó\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bØ\u0001\u0010Õ\u0001\u001a\u0006\bÙ\u0001\u0010×\u0001R/\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u000e0Ñ\u0001j\t\u0012\u0004\u0012\u00020\u000e`Ó\u00018\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b$\u0010Õ\u0001\u001a\u0006\bÚ\u0001\u0010×\u0001R1\u0010Û\u0001\u001a\u0014\u0012\u0004\u0012\u00020\b0Ñ\u0001j\t\u0012\u0004\u0012\u00020\b`Ó\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÛ\u0001\u0010Õ\u0001\u001a\u0006\bÜ\u0001\u0010×\u0001R3\u0010Þ\u0001\u001a\u0016\u0012\u0005\u0012\u00030Ý\u00010Ñ\u0001j\n\u0012\u0005\u0012\u00030Ý\u0001`Ó\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÞ\u0001\u0010Õ\u0001\u001a\u0006\bß\u0001\u0010×\u0001R)\u0010à\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00170Ñ\u0001j\t\u0012\u0004\u0012\u00020\u0017`Ó\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bà\u0001\u0010Õ\u0001R1\u0010á\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00170Ê\u0001j\t\u0012\u0004\u0012\u00020\u0017`Ì\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bá\u0001\u0010Î\u0001\u001a\u0006\bâ\u0001\u0010Ð\u0001R?\u0010ä\u0001\u001a\"\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ã\u00010+0Ñ\u0001j\u0010\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ã\u00010+`Ó\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bä\u0001\u0010Õ\u0001\u001a\u0006\bå\u0001\u0010×\u0001R?\u0010æ\u0001\u001a\"\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ã\u00010+0Ñ\u0001j\u0010\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ã\u00010+`Ó\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bæ\u0001\u0010Õ\u0001\u001a\u0006\bç\u0001\u0010×\u0001R1\u0010è\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000e0Ñ\u0001j\t\u0012\u0004\u0012\u00020\u000e`Ó\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bè\u0001\u0010Õ\u0001\u001a\u0006\bé\u0001\u0010×\u0001R\u0018\u0010ë\u0001\u001a\u00030ê\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bë\u0001\u0010ì\u0001R\u001d\u0010î\u0001\u001a\u00030í\u00018\u0006¢\u0006\u0010\n\u0006\bî\u0001\u0010ï\u0001\u001a\u0006\bð\u0001\u0010ñ\u0001R\u001d\u0010ó\u0001\u001a\u00030ò\u00018\u0006¢\u0006\u0010\n\u0006\bó\u0001\u0010ô\u0001\u001a\u0006\bõ\u0001\u0010ö\u0001R\u0018\u0010ø\u0001\u001a\u00030÷\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bø\u0001\u0010ù\u0001R)\u0010ú\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000e0Ñ\u0001j\t\u0012\u0004\u0012\u00020\u000e`Ó\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bú\u0001\u0010Õ\u0001R\u0017\u0010(\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b(\u0010Å\u0001R\u0019\u0010û\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bû\u0001\u0010ü\u0001R\u0019\u0010ý\u0001\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bý\u0001\u0010þ\u0001R\u001b\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÿ\u0001\u0010ü\u0001R.\u0010\u0080\u0002\u001a\u0014\u0012\u0004\u0012\u00020\b0Ñ\u0001j\t\u0012\u0004\u0012\u00020\b`Ó\u00018\u0006¢\u0006\u0010\n\u0006\b\u0080\u0002\u0010Õ\u0001\u001a\u0006\b\u0081\u0002\u0010×\u0001R1\u0010\u0082\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u000e0Ñ\u0001j\t\u0012\u0004\u0012\u00020\u000e`Ó\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0082\u0002\u0010Õ\u0001\u001a\u0006\b\u0083\u0002\u0010×\u0001R7\u0010\u0084\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u000205\u0018\u00010%8\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u0084\u0002\u0010¯\u0001\u001a\u0006\b\u0085\u0002\u0010\u0086\u0002\"\u0006\b\u0087\u0002\u0010\u0088\u0002R1\u0010\u0089\u0002\u001a\u0014\u0012\u0004\u0012\u00020\b0Ñ\u0001j\t\u0012\u0004\u0012\u00020\b`Ó\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0089\u0002\u0010Õ\u0001\u001a\u0006\b\u008a\u0002\u0010×\u0001R\u001f\u0010\u008c\u0002\u001a\n\u0012\u0005\u0012\u00030Ë\u00010\u008b\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0002\u0010\u008d\u0002R\u001e\u0010\u008e\u0002\u001a\t\u0012\u0004\u0012\u0002050\u008b\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0002\u0010\u008d\u0002R/\u0010H\u001a\u0014\u0012\u0004\u0012\u00020G0Ñ\u0001j\t\u0012\u0004\u0012\u00020G`Ó\u00018\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\bH\u0010Õ\u0001\u001a\u0006\b\u008f\u0002\u0010×\u0001R)\u0010\u0090\u0002\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0090\u0002\u0010\u0091\u0002\u001a\u0006\b\u0092\u0002\u0010\u0093\u0002\"\u0006\b\u0094\u0002\u0010\u0095\u0002R\u0019\u0010\u0096\u0002\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0002\u0010\u0091\u0002R\u0019\u0010\u0097\u0002\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0002\u0010\u0091\u0002R\u0019\u0010\u0098\u0002\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0002\u0010Å\u0001R\u001b\u0010\u0099\u0002\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0002\u0010\u009a\u0002R)\u0010\u009b\u0002\u001a\u00020\b8\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u009b\u0002\u0010Å\u0001\u001a\u0006\b\u009b\u0002\u0010Ç\u0001\"\u0006\b\u009c\u0002\u0010É\u0001R6\u0010\u009e\u0002\u001a\u0004\u0018\u00010\u00052\t\u0010\u009d\u0002\u001a\u0004\u0018\u00010\u00058\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u009e\u0002\u0010\u009a\u0002\u001a\u0006\b\u009f\u0002\u0010 \u0002\"\u0006\b¡\u0002\u0010¢\u0002R+\u0010£\u0002\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b£\u0002\u0010¤\u0002\u001a\u0006\b¥\u0002\u0010¦\u0002\"\u0006\b§\u0002\u0010¨\u0002R\u001c\u0010©\u0002\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0002\u0010ª\u0002R\u001b\u0010«\u0002\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0002\u0010\u009a\u0002R\u0018\u0010\u00ad\u0002\u001a\u00030¬\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u00ad\u0002\u0010®\u0002R\u0019\u0010¯\u0002\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0002\u0010\u0091\u0002R1\u0010²\u0002\u001a\u0014\u0012\u0004\u0012\u00020\b0°\u0002j\t\u0012\u0004\u0012\u00020\b`±\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b²\u0002\u0010³\u0002\u001a\u0006\b´\u0002\u0010µ\u0002R\u001d\u0010¸\u0002\u001a\b0¶\u0002j\u0003`·\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¸\u0002\u0010¹\u0002R\u0019\u0010º\u0002\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0002\u0010þ\u0001R\u0019\u0010»\u0002\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0002\u0010þ\u0001R\u0019\u0010¼\u0002\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0002\u0010\u0091\u0002R)\u0010½\u0002\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b½\u0002\u0010ü\u0001\u001a\u0006\b¾\u0002\u0010¿\u0002\"\u0006\bÀ\u0002\u0010Á\u0002R\u0019\u0010Â\u0002\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0002\u0010Å\u0001R\u001b\u0010Ã\u0002\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0002\u0010Ä\u0002R\u001b\u0010Å\u0002\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0002\u0010Æ\u0002R\u0019\u0010Ç\u0002\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0002\u0010Å\u0001R\u0019\u0010È\u0002\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0002\u0010\u0091\u0002R\u0019\u0010É\u0002\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0002\u0010\u0091\u0002R1\u0010Ê\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u000e0Ñ\u0001j\t\u0012\u0004\u0012\u00020\u000e`Ó\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÊ\u0002\u0010Õ\u0001\u001a\u0006\bË\u0002\u0010×\u0001R3\u0010Í\u0002\u001a\u0016\u0012\u0005\u0012\u00030Ì\u00020Ñ\u0001j\n\u0012\u0005\u0012\u00030Ì\u0002`Ó\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÍ\u0002\u0010Õ\u0001\u001a\u0006\bÎ\u0002\u0010×\u0001R1\u0010Ï\u0002\u001a\u0014\u0012\u0004\u0012\u0002050Ñ\u0001j\t\u0012\u0004\u0012\u000205`Ó\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÏ\u0002\u0010Õ\u0001\u001a\u0006\bÐ\u0002\u0010×\u0001R#\u0010Ò\u0002\u001a\t\u0012\u0004\u0012\u00020A0Ñ\u00028\u0006¢\u0006\u0010\n\u0006\bÒ\u0002\u0010Ó\u0002\u001a\u0006\bÔ\u0002\u0010Õ\u0002R\u001c\u0010Ö\u0002\u001a\u00020\b8\u0006¢\u0006\u0010\n\u0006\bÖ\u0002\u0010Å\u0001\u001a\u0006\bÖ\u0002\u0010Ç\u0001R\"\u0010Ø\u0002\u001a\u0005\u0018\u00010×\u00028\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bØ\u0002\u0010Ù\u0002\u001a\u0006\bÚ\u0002\u0010Û\u0002R\"\u0010Ý\u0002\u001a\u0005\u0018\u00010Ü\u00028\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bÝ\u0002\u0010Þ\u0002\u001a\u0006\bß\u0002\u0010à\u0002R\"\u0010â\u0002\u001a\u0005\u0018\u00010á\u00028\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bâ\u0002\u0010ã\u0002\u001a\u0006\bä\u0002\u0010å\u0002R\"\u0010ç\u0002\u001a\u0005\u0018\u00010æ\u00028\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bç\u0002\u0010è\u0002\u001a\u0006\bé\u0002\u0010ê\u0002R\"\u0010ì\u0002\u001a\u0005\u0018\u00010ë\u00028\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bì\u0002\u0010í\u0002\u001a\u0006\bî\u0002\u0010ï\u0002R\"\u0010ñ\u0002\u001a\u0005\u0018\u00010ð\u00028\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bñ\u0002\u0010ò\u0002\u001a\u0006\bó\u0002\u0010ô\u0002R \u0010ö\u0002\u001a\u00030õ\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bö\u0002\u0010÷\u0002\u001a\u0006\bø\u0002\u0010ù\u0002R\u0017\u0010ü\u0002\u001a\u00020\u00178BX\u0082\u0004¢\u0006\b\u001a\u0006\bú\u0002\u0010û\u0002R\u001a\u0010ÿ\u0002\u001a\u0005\u0018\u00010Ý\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bý\u0002\u0010þ\u0002R%\u0010\u0081\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020&\u0018\u00010%8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0080\u0003\u0010\u0086\u0002R \u0010\u0083\u0003\u001a\u000b\u0012\u0005\u0012\u00030Ò\u0001\u0018\u00010+8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0082\u0003\u0010¾\u0001R\u0017\u0010\u0085\u0003\u001a\u0002058BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0084\u0003\u0010\u0093\u0002R\u001a\u0010\u0089\u0003\u001a\u0005\u0018\u00010\u0086\u00038DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u0087\u0003\u0010\u0088\u0003R\u001a\u0010\u008d\u0003\u001a\u0005\u0018\u00010\u008a\u00038DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u008b\u0003\u0010\u008c\u0003R\u001a\u0010\u0091\u0003\u001a\u0005\u0018\u00010\u008e\u00038DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u008f\u0003\u0010\u0090\u0003R\u001a\u0010\u0095\u0003\u001a\u0005\u0018\u00010\u0092\u00038DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u0093\u0003\u0010\u0094\u0003R\u001a\u0010\u0099\u0003\u001a\u0005\u0018\u00010\u0096\u00038DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u0097\u0003\u0010\u0098\u0003R\u001a\u0010\u009d\u0003\u001a\u0005\u0018\u00010\u009a\u00038DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u009b\u0003\u0010\u009c\u0003R\u001a\u0010¡\u0003\u001a\u0005\u0018\u00010\u009e\u00038DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u009f\u0003\u0010 \u0003R\u001e\u0010¦\u0003\u001a\f\u0018\u00010¢\u0003j\u0005\u0018\u0001`£\u00038F¢\u0006\b\u001a\u0006\b¤\u0003\u0010¥\u0003R)\u0010¨\u0003\u001a\u0014\u0012\u0004\u0012\u0002050Ê\u0001j\t\u0012\u0004\u0012\u000205`Ì\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b§\u0003\u0010Ð\u0001R\u0017\u0010ª\u0003\u001a\u00020\u00178VX\u0096\u0004¢\u0006\b\u001a\u0006\b©\u0003\u0010û\u0002R+\u0010\u00ad\u0003\u001a\u0016\u0012\u0005\u0012\u00030«\u00030Ê\u0001j\n\u0012\u0005\u0012\u00030«\u0003`Ì\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¬\u0003\u0010Ð\u0001R\u0018\u0010±\u0003\u001a\u00030®\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\b¯\u0003\u0010°\u0003R\u0016\u0010\u0016\u001a\u00020\u00158DX\u0084\u0004¢\u0006\b\u001a\u0006\b²\u0003\u0010³\u0003R\u0017\u0010¶\u0003\u001a\u0005\u0018\u00010\u008a\u00018F¢\u0006\b\u001a\u0006\b´\u0003\u0010µ\u0003R\u001a\u0010¹\u0003\u001a\u0005\u0018\u00010\u008f\u00018DX\u0084\u0004¢\u0006\b\u001a\u0006\b·\u0003\u0010¸\u0003R\u0014\u0010¼\u0003\u001a\u00020A8F¢\u0006\b\u001a\u0006\bº\u0003\u0010»\u0003R\u0017\u0010¾\u0003\u001a\u0002058DX\u0084\u0004¢\u0006\b\u001a\u0006\b½\u0003\u0010\u0093\u0002R\u0018\u0010Á\u0003\u001a\u00030\u0085\u00018DX\u0084\u0004¢\u0006\b\u001a\u0006\b¿\u0003\u0010À\u0003R\u0017\u0010Ã\u0003\u001a\u00020A8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÂ\u0003\u0010»\u0003R\u001a\u0010Ç\u0003\u001a\u0005\u0018\u00010Ä\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\bÅ\u0003\u0010Æ\u0003R5\u0010Ê\u0003\u001a \u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0¬\u0001j\u000f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`È\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\bÉ\u0003\u0010\u0086\u0002¨\u0006Ð\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/PkBaseDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/e;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkStateMachineController$a;", "Lcom/bytedance/android/live/revlink/link/biz/service/j;", "Lc21/f;", "fromBattlePlayMode", "toBattlePlayMode", "", "updateIsOnceMore", "Lcom/bytedance/android/livesdk/link/model/v2;", "from", "to", "isSameCustomizePlay", "", "reqSrc", "", "logPKWatchDuration", "Lcom/bytedance/android/livesdk/link/model/bridge/u0;", Constants.OperatorKey.MSG, "onBattleTeamTaskMsg", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/a;", "pkInfo", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;", "fromState", "toState", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$Source;", "source", "onShowPK", "onShowPenal", "skippedPenal", "isRealPkFinish", "onFinish", "isBattleInterrupt", "isConnectInterrupt", "resetBattle", "needShowLastResult", "", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/PkBaseResult;", "battleResult", "needShowLastBattleResult", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/PKBizType;", "pkBizType", "", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/d;", "getBizHandlerList", "bizHandler", "Lio/reactivex/disposables/Disposable;", "Lcom/bytedance/revenue/platform/api/core/rx/Disposable;", "registerBiz", "getStartSource", "lynxData", "notifyTeamTaskLynxDataUpdate", "", "map", "setUserIdToTeamIdExtra", "getPkId", "getPkScoreTextEnable", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/a;", "getPkAnchorLauncher", "isBaseOnceMore", "inClassicDoublePK", "onPause", "onResume", "getEventTrackingInfo", "", "queryLaunchToBizTypeAndReset", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "onBaseMessage", "Lcom/bytedance/android/livesdk/link/model/c3;", "battleStatsMeta", "updateBattleStatsMeta", "Lcom/bytedance/android/livesdk/link/model/r$b;", "bizExtra", "updateBizExtra", "Lcom/bytedance/android/livesdk/link/model/c5;", "message", "onReceiveBattleMsg", "Lcom/bytedance/android/livesdk/link/model/a5;", "onReceiveBattleFinishMsg", "Lcom/bytedance/android/livesdk/link/model/y4;", "onReceiveBattleEndPunishMsg", "Lcom/bytedance/android/livesdk/link/model/r;", "anchorLinkList", "forceUpdate", "notifyPkContext", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/b;", "getPkSkinConfig", "Lcom/bytedance/android/livesdk/link/model/IBattleUserInfo;", "getUserInfoMap", "Lcom/bytedance/android/livesdk/link/model/h3;", "getPkTitleConfig", "getPunishTitleConfig", "getPkStartTimeMs", "getStartPenaltyTimeMs", "startTimeMs", "getPkPlayTimes", "isNormalPk", "getThroneFightEvenCount", "isInSpecifyGiftPk", "isInSpecifyGiftPkBySelf", "isInCompetition", "isInVote", "isInBreakThrough", "isCustomizePkPlay", "isInRobC", "isInCloudCollaborate", "isInInteractPk", "linkmicId", "isInAudioPunish", "inSelf", "isCustomPKPlay", "Lcom/bytedance/android/livesdk/link/model/h9;", "getSpecifyGiftConfig", "getCustomizePlayType", "getFlexActivityId", "Lcom/bytedance/android/livesdk/link/model/w2;", "getShellConfig", "Lcom/bytedance/android/livesdk/link/model/m3;", "getBreakThoughConfig", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subplaymode/a;", "getBreakThroughService", "Lcom/bytedance/android/livesdk/link/model/n3;", "getBreakThroughInfo", "getBreakThroughStage", "getCurPkResultMap", "getShortPlayName", "Lcom/bytedance/android/livesdk/link/model/z2;", "getGradeChanges", "Lcom/bytedance/android/livesdk/link/model/ca;", "getInteractPkInfo", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/PkBaseDataContext$PKModType;", "modType", "getBattlePlayMode", "getCloudCollaboratePanelType", "getLastBattlePlayMode", "Lcom/bytedance/android/livesdk/link/model/api/IBaseBattleSetting;", "getBattleSettings", "Lcom/bytedance/android/livesdk/link/model/IBattleBarConfig;", "getBarConfig", "isOnceMoreBattle", "Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;", "getConfigSetting", "uid", "getPropCardEffectType", "isBattleShow", "resetPkState", "resetDataForSwitch", "getTeamModeStr", "stateSource", "Lcom/bytedance/android/livesdk/link/model/f1;", Constants.Keys.DATA, "", "throwable", "onFinishCallback", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getServerEventTrackingInfo", "Lcom/bytedance/android/livesdk/link/model/p0;", "getServerBattleAttachedInfo", "Lc21/j;", "bizInviteParams", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/a$b;", "callback", "startBizInvite", "Lc21/i;", "bizEndParam", "startBizEnd", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/RoomId;", "roomId", "sharedWithRoomId", "", "", "bizHandlerMap", "Ljava/util/Map;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/PkAnchorLauncher;", "pkAnchorLauncher", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/PkAnchorLauncher;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/j;", "pkAudienceRequest", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/j;", "Lcom/bytedance/android/live/revlink/impl/plantform/AnchorLinkUserCenterV2;", "userCenter", "Lcom/bytedance/android/live/revlink/impl/plantform/AnchorLinkUserCenterV2;", "getUserCenter", "()Lcom/bytedance/android/live/revlink/impl/plantform/AnchorLinkUserCenterV2;", "audioPunishUserIds", "Ljava/util/List;", "getAudioPunishUserIds", "()Ljava/util/List;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkStateMachineController;", "stateMachineController", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkStateMachineController;", "getStateMachineController", "()Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkStateMachineController;", "setResultByInstallKill", "Z", "getSetResultByInstallKill", "()Z", "setSetResultByInstallKill", "(Z)V", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$b;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/LiveData;", "pkSideEffect", "Landroidx/lifecycle/LiveData;", "getPkSideEffect", "()Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/MutableLiveData;", "Lcf2/a;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/MutableLiveData;", "baseScoreState", "Landroidx/lifecycle/MutableLiveData;", "getBaseScoreState", "()Landroidx/lifecycle/MutableLiveData;", "pkBaseResult", "getPkBaseResult", "getNeedShowLastResult", "lastBattleResultVisible", "getLastBattleResultVisible", "Lcom/bytedance/android/live/revlink/impl/multianchor/constants/PlayMode;", "teamMode", "getTeamMode", "_pkState", "pkBaseState", "getPkBaseState", "Lcom/bytedance/android/livesdk/link/model/h7$b;", "leftMvpRankList", "getLeftMvpRankList", "rightMvpRankList", "getRightMvpRankList", "pkGuestListStr", "getPkGuestListStr", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/PkBaseModeDataContext;", "modeDataContext", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/PkBaseModeDataContext;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/PkBaseResultDataContext;", "resultDataContext", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/PkBaseResultDataContext;", "getResultDataContext", "()Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/PkBaseResultDataContext;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/PkBaseScoreDataContext;", "scoreDataContext", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/PkBaseScoreDataContext;", "getScoreDataContext", "()Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/PkBaseScoreDataContext;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subplaymode/BaseBreakThroughDataContext;", "breakThroughDataContext", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subplaymode/BaseBreakThroughDataContext;", "propCardEffectInfo", "startSource", "Ljava/lang/String;", "toBizTypeForMonitor", "I", "eventTrackingInfo", "extraResultAnim", "getExtraResultAnim", "teamTaskLynxData", "getTeamTaskLynxData", "userIdToTeamId", "getUserIdToTeamId", "()Ljava/util/Map;", "setUserIdToTeamId", "(Ljava/util/Map;)V", "showLastBattleResult", "getShowLastBattleResult", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "sideEffectObserver", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "timeObserver", "getBattleStatsMeta", "startTimeMsField", "J", "getStartTimeMsField", "()J", "setStartTimeMsField", "(J)V", "onShowPkTime", "onShowPenalTime", "isFirstPk", "lastBattlePlayMode", "Lc21/f;", "isBaseOnceMoreBattle", "setBaseOnceMoreBattle", "value", "curBattlePlayMode", "getCurBattlePlayMode", "()Lc21/f;", "setCurBattlePlayMode", "(Lc21/f;)V", "curCloudCollaboratePanelType", "Ljava/lang/Integer;", "getCurCloudCollaboratePanelType", "()Ljava/lang/Integer;", "setCurCloudCollaboratePanelType", "(Ljava/lang/Integer;)V", "battleSettingCache", "Lcom/bytedance/android/livesdk/link/model/api/IBaseBattleSetting;", "battlePlayModeCache", "Lb21/c;", "commonLogger", "Lb21/c;", "channelIDForPkLog", "Lio/reactivex/subjects/PublishSubject;", "Lcom/bytedance/revenue/platform/api/core/rx/PublishSubject;", "pkStartEvent", "Lio/reactivex/subjects/PublishSubject;", "getPkStartEvent", "()Lio/reactivex/subjects/PublishSubject;", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "pkBeginCount", "pkCompleteCount", "pkStartTimeMs", "pkSource", "getPkSource", "()Ljava/lang/String;", "setPkSource", "(Ljava/lang/String;)V", "isFirstCreate", "curPkStateInfo", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/a;", "compatSkinConfig", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/b;", "isInBack", "onPkPauseTimeMs", "pkBackDuration", "battleEffectInfo", "getBattleEffectInfo", "Lcom/bytedance/android/livesdk/link/model/z;", "audioPunishInfo", "getAudioPunishInfo", "audioPunishRemainTime", "getAudioPunishRemainTime", "Lkotlin/Function0;", "scene", "Lkotlin/jvm/functions/Function0;", "getScene", "()Lkotlin/jvm/functions/Function0;", "isAnchor", "Lld/a;", "linkDataSet", "Lld/a;", "getLinkDataSet", "()Lld/a;", "Lwq2/f;", "dataCenterService", "Lwq2/f;", "getDataCenterService", "()Lwq2/f;", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "roomService", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "getRoomService", "()Lcom/bytedance/android/livesdk/revenue/service/room/c;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "getLinkFakeGlobalService", "()Lcom/bytedance/android/live/revlink/impl/global/c;", "Lyz0/f;", "messageService", "Lyz0/f;", "getMessageService", "()Lyz0/f;", "Lx11/a;", "internalLinkService", "Lx11/a;", "getInternalLinkService", "()Lx11/a;", "Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/d;", "context", "Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/d;", "getContext", "()Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/d;", "getCurrentPkState", "()Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;", "currentPkState", "getCurrentPlayMode", "()Lcom/bytedance/android/live/revlink/impl/multianchor/constants/PlayMode;", "currentPlayMode", "getCurPkResult", "curPkResult", "getCurScoreState", "curScoreState", "getPkWatchDuration", "pkWatchDuration", "La21/a;", "getPkBaseLogger", "()La21/a;", "pkBaseLogger", "Lcom/bytedance/android/live/revlink/impl/pk/utils/q;", "getPkUtils", "()Lcom/bytedance/android/live/revlink/impl/pk/utils/q;", "pkUtils", "Lcom/bytedance/android/live/revlink/impl/LinkCrossRoomDataHolder;", "getLinkCrossRoomDataHolder", "()Lcom/bytedance/android/live/revlink/impl/LinkCrossRoomDataHolder;", "linkCrossRoomDataHolder", "Lcom/bytedance/android/live/revlink/impl/utils/s;", "getRevLinkCommonUtil", "()Lcom/bytedance/android/live/revlink/impl/utils/s;", "revLinkCommonUtil", "Ld21/d;", "getMergePkHelper", "()Ld21/d;", "mergePkHelper", "Lcom/bytedance/android/live/revlink/impl/service/internal/LinkRevInternalServiceContext;", "getLinkRevInternalServiceContext", "()Lcom/bytedance/android/live/revlink/impl/service/internal/LinkRevInternalServiceContext;", "linkRevInternalServiceContext", "Lcom/bytedance/android/live/revlink/impl/utils/b;", "getClearScreenLinkUtils", "()Lcom/bytedance/android/live/revlink/impl/utils/b;", "clearScreenLinkUtils", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "getBaseTimeLeft", "baseTimeLeft", "getCurPKBaseState", "curPKBaseState", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/a;", "getBattleScoreData", "battleScoreData", "Li31/c;", "getTitleConfig", "()Li31/c;", "titleConfig", "getPkInfo", "()Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/a;", "getCurBattleSetting", "()Lcom/bytedance/android/livesdk/link/model/api/IBaseBattleSetting;", "curBattleSetting", "getCurConfigSetting", "()Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;", "curConfigSetting", "getCurDuration", "()I", "curDuration", "getBattleId", "battleId", "getPkModeType", "()Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/PkBaseDataContext$PKModType;", "pkModeType", "getCompletePkCount", "completePkCount", "Lcom/bytedance/android/livesdk/link/model/aa;", "getVoteSetting", "()Lcom/bytedance/android/livesdk/link/model/aa;", "voteSetting", "Lcom/bytedance/revenue/platform/api/core/KmpMutableMap;", "getCommonLogParams", "commonLogParams", "<init>", "(Lkotlin/jvm/functions/Function0;ZLld/a;Lwq2/f;Lcom/bytedance/android/livesdk/revenue/service/room/c;Lcom/bytedance/android/live/revlink/impl/global/c;Lyz0/f;Lx11/a;Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/d;)V", "Companion", "b", "PKModType", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkBaseDataContext extends DataContext implements com.bytedance.android.live.revlink.impl.mergepk.pkbase.e, PkStateMachineController.a, j {
    public static final b Companion = null;
    public static final String LOG_TAG = "ttlive_PkBaseDataContext";
    public static final long PK_INSTANT_KILL_DELAY_SECONDS = 3;
    public static final String TAG = "PkBaseDataContext";
    private final MutableLiveData<PkBaseStateMachine.c> _pkState;
    private final MutableLiveData<z> audioPunishInfo;
    private final MutableLiveData<Long> audioPunishRemainTime;
    private final List<String> audioPunishUserIds;
    private final MutableLiveData<List<cf2.a>> baseScoreState;
    private final MutableLiveData<String> battleEffectInfo;
    private c21.f battlePlayModeCache;
    private IBaseBattleSetting battleSettingCache;
    private final MutableLiveData<c3> battleStatsMeta;
    private final Map<PKBizType, List<com.bytedance.android.live.revlink.impl.mergepk.pkbase.d>> bizHandlerMap;
    private final BaseBreakThroughDataContext breakThroughDataContext;
    private final CompositeDisposable cd;
    private long channelIDForPkLog;
    private final b21.c commonLogger;
    private com.bytedance.android.live.revlink.impl.mergepk.pkbase.b compatSkinConfig;
    private final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d context;
    private c21.f curBattlePlayMode;
    private Integer curCloudCollaboratePanelType;
    private com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a curPkStateInfo;
    private final wq2.f dataCenterService;
    private String eventTrackingInfo;
    private final MutableLiveData<Boolean> extraResultAnim;
    private final x11.a internalLinkService;
    private final boolean isAnchor;
    private boolean isBaseOnceMoreBattle;
    private boolean isFirstCreate;
    private boolean isFirstPk;
    private boolean isInBack;
    private c21.f lastBattlePlayMode;
    private final MutableLiveData<Boolean> lastBattleResultVisible;
    private final MutableLiveData<List<h7.b>> leftMvpRankList;
    private final ld.a linkDataSet;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private final yz0.f messageService;
    private final PkBaseModeDataContext modeDataContext;
    private boolean needShowLastBattleResult;
    private final MutableLiveData<String> needShowLastResult;
    private long onPkPauseTimeMs;
    private long onShowPenalTime;
    private long onShowPkTime;
    private PkAnchorLauncher pkAnchorLauncher;
    private com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.j pkAudienceRequest;
    private long pkBackDuration;
    private final MutableLiveData<Map<String, PkBaseResult>> pkBaseResult;
    private final LiveData<PkBaseStateMachine.c> pkBaseState;
    private int pkBeginCount;
    private int pkCompleteCount;
    private final MutableLiveData<String> pkGuestListStr;
    private final LiveData<PkBaseStateMachine.b> pkSideEffect;
    private String pkSource;
    private final PublishSubject<Boolean> pkStartEvent;
    private long pkStartTimeMs;
    private final MutableLiveData<String> propCardEffectInfo;
    private final PkBaseResultDataContext resultDataContext;
    private final MutableLiveData<List<h7.b>> rightMvpRankList;
    private final com.bytedance.android.livesdk.revenue.service.room.c roomService;
    private final Function0<Integer> scene;
    private final PkBaseScoreDataContext scoreDataContext;
    private boolean setResultByInstallKill;
    private final MutableLiveData<Boolean> showLastBattleResult;
    private final Observer<PkBaseStateMachine.b> sideEffectObserver;
    private String startSource;
    private long startTimeMsField;
    private final PkStateMachineController stateMachineController;
    private final MutableLiveData<PlayMode> teamMode;
    private final MutableLiveData<String> teamTaskLynxData;
    private final Observer<Long> timeObserver;
    private int toBizTypeForMonitor;
    private final AnchorLinkUserCenterV2 userCenter;
    private Map<String, Long> userIdToTeamId;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass3(PkBaseDataContext r8) {
            super(1, r8, PkBaseDataContext.class, "onBaseMessage", "onBaseMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(yh6.c r2) {
            ((PkBaseDataContext) ((CallableReference) this).receiver).onBaseMessage(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/u0;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/bridge/u0;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<u0, Unit> {
        public AnonymousClass4(PkBaseDataContext r8) {
            super(1, r8, PkBaseDataContext.class, "onBattleTeamTaskMsg", "onBattleTeamTaskMsg(Lcom/bytedance/android/livesdk/link/model/bridge/ILinkMicBattleTeamTaskMessageBridge;)V", 0);
        }

        public final void invoke(u0 r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            PkBaseDataContext.access$onBattleTeamTaskMsg((PkBaseDataContext) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((u0) r1);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/PkBaseDataContext$PKModType;", "", "", "type", "I", "getType", "()I", "setType", "(I)V", "Default", "Vote", "BreakThrough", "Custom", "SeasonRank", "RobC", "CloudCollaborate", "InteractPk", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Deprecated(message = "逐步弃用，用BattlePlayMode判断玩法")
    public static final enum PKModType extends Enum<PKModType> {
        public static final PKModType BreakThrough = null;
        public static final PKModType CloudCollaborate = null;
        public static final PKModType Custom = null;
        public static final PKModType Default = null;
        public static final PKModType InteractPk = null;
        public static final PKModType RobC = null;
        public static final PKModType SeasonRank = null;
        public static final PKModType Vote = null;
        public static final /* synthetic */ PKModType[] a = null;
        private int type;

        public static PKModType valueOf(String r1) {
            return (PKModType) r27.a.a(PKModType.class, r1);
        }

        public static PKModType[] values() {
            return (PKModType[]) a.clone();
        }

        static {
            PKModType r2 = new PKModType("Default", 0, 0);
            Default = r2;
            PKModType r3 = new PKModType("Vote", 1, 1);
            Vote = r3;
            PKModType r4 = new PKModType("BreakThrough", 2, 2);
            BreakThrough = r4;
            PKModType r5 = new PKModType("Custom", 3, 4);
            Custom = r5;
            PKModType r6 = new PKModType("SeasonRank", 4, 5);
            SeasonRank = r6;
            PKModType r7 = new PKModType("RobC", 5, 6);
            RobC = r7;
            PKModType r8 = new PKModType("CloudCollaborate", 6, 7);
            CloudCollaborate = r8;
            PKModType r9 = new PKModType("InteractPk", 7, 8);
            InteractPk = r9;
            a = new PKModType[]{r2, r3, r4, r5, r6, r7, r8, r9};
        }

        public final int getType() {
            return this.type;
        }

        public final void setType(int r1) {
            this.type = r1;
        }

        public PKModType(String r1, int r2, int r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    public static final class a implements Action {
        public final /* synthetic */ PkBaseDataContext a;

        public a(PkBaseDataContext r1) {
            this.a = r1;
        }

        public final void run() {
            PkBaseStateMachine.c r0 = PkBaseDataContext.access$getCurrentPkState$p(this.a);
            r0.getClass();
            if ((r0 instanceof PkBaseStateMachine.c.C0130c) == true) goto L5;
        L7:
            PkStateMachineController r1 = this.a.getStateMachineController();
            r1.c.getTimeLeft().removeObserver(r1.e);
            r1.c.clearIt();
            r1.g.dispose();
            r1.d = null;
            PkAnchorLauncher r2 = PkBaseDataContext.access$getPkAnchorLauncher$p(this.a);
            if (r2 == null) goto L10;
            r2.b.dispose();
        L10:
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.j r3 = PkBaseDataContext.access$getPkAudienceRequest$p(this.a);
            if (r3 == null) goto L13;
            r3.a.dispose();
        L13:
            this.a.getPkSideEffect().removeObserver(PkBaseDataContext.access$getSideEffectObserver$p(this.a));
            this.a.getBaseTimeLeft().removeObserver(PkBaseDataContext.access$getTimeObserver$p(this.a));
            PkBaseDataContext.access$getBreakThroughDataContext$p(this.a).clearIt();
            this.a.getScoreDataContext().clearIt();
            this.a.getResultDataContext().clearIt();
            PkBaseDataContext.access$getModeDataContext$p(this.a).clearIt();
            PkBaseDataContext.access$getCd$p(this.a).dispose();
            PkBaseDataContext.access$getPropCardEffectInfo$p(this.a).setValue("");
            if (this.a.isAnchor() == true) goto L17;
            cy0.e.a.getClass();
            cy0.j r4 = cy0.e.a.a;
            m.e.getClass();
            Object r5 = m.b(r4).b(com.bytedance.android.livesdk.revenue.service.gift.a.class);
            Intrinsics.checkNotNull(r5);
            ((com.bytedance.live.kmp.core.c) r5).clearBattlePropCardMessageQueue();
            return;
        L17:
            return;
        L5:
            if (this.a.isAnchor() == true) goto L7;
            PkBaseDataContext.access$logPKWatchDuration(this.a, "left");
            goto L7
        }
    }

    public static final class b {
        public b() {
        }

        public static boolean a(c1 r7) {
            if (r7.getPunishStartTimeMs() == 0) goto L6;
            return true;
        L6:
            if ((com.bytedance.live.kmp.util.e.b() - r7.getStartTimeMs()) > (r7.getDuration() * ((long) WebcastRedirectException.UNKNOWN))) goto L10;
            return false;
        L10:
            return true;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ PkBaseDataContext a;

        public c(PkBaseDataContext r1) {
            this.a = r1;
        }

        public final void onChanged(Object r12) {
            PkBaseStateMachine.b r13 = (PkBaseStateMachine.b) r12;
            jy0.b.f(PkBaseDataContext.LOG_TAG, "sideEffectObserver " + r13, null, 4);
            boolean r0 = r13 instanceof PkBaseStateMachine.b.c;
            String r1 = DataType.FALSE;
            if (r0 == false) goto L9;
            PkBaseStateMachine.c r2 = r13.b;
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r3 = r2.a;
            PkBaseStateMachine.Source r4 = r2.b;
            PkBaseDataContext.access$onShowPK(this.a, r3, r13.a, r2, r4);
            this.a.m587getBaseScoreState().setValue(PkBaseDataContext.access$getCurScoreState$p(this.a));
            this.a.m592getPkBaseResult().setValue(PkBaseDataContext.access$getCurPkResult$p(this.a));
            this.a.m596getTeamMode().setValue(PkBaseDataContext.access$getCurrentPlayMode$p(this.a));
            PkBaseDataContext.access$get_pkState$p(this.a).setValue(r13.b);
            if (r4 == PkBaseStateMachine.Source.MetaUpdate) goto L7;
            this.a.getPkStartEvent().onNext(Boolean.TRUE);
        L7:
            this.a.setSetResultByInstallKill(false);
            this.a.m591getNeedShowLastResult().setValue(DataType.FALSE);
            return;
        L9:
            if ((r13 instanceof PkBaseStateMachine.b.d) == false) goto L17;
            PkBaseDataContext r5 = this.a;
            PkBaseStateMachine.c r6 = r13.a;
            PkBaseStateMachine.c r7 = r13.b;
            PkBaseDataContext.access$onShowPenal(r5, r6, r7.a, r7.b, r7);
            this.a.m587getBaseScoreState().setValue(PkBaseDataContext.access$getCurScoreState$p(this.a));
            if (((Number) this.a.getScene().invoke()).intValue() == 1) goto L13;
        L14:
            this.a.m592getPkBaseResult().setValue(PkBaseDataContext.access$getCurPkResult$p(this.a));
        L15:
            this.a.setSetResultByInstallKill(false);
            this.a.m596getTeamMode().setValue(PkBaseDataContext.access$getCurrentPlayMode$p(this.a));
            PkBaseDataContext.access$get_pkState$p(this.a).setValue(r13.b);
            this.a.m591getNeedShowLastResult().setValue(DataType.FALSE);
            return;
        L13:
            if (this.a.getSetResultByInstallKill() == true) goto L15;
        L17:
            if ((r13 instanceof PkBaseStateMachine.b.a) == false) goto L31;
            PkBaseStateMachine.b.a r8 = (PkBaseStateMachine.b.a) r13;
            PkBaseDataContext.access$onFinish(this.a, r8.d, r13.a, r13.b, r13.a.a());
            this.a.m587getBaseScoreState().setValue(PkBaseDataContext.access$getCurScoreState$p(this.a));
            if (r8.d == true) goto L21;
        L26:
            this.a.m596getTeamMode().setValue(null);
            PkBaseDataContext.access$get_pkState$p(this.a).setValue(r13.b);
            MutableLiveData<String> r14 = this.a.m591getNeedShowLastResult();
            if (PkBaseDataContext.access$needShowLastResult(this.a) == false) goto L29;
            r1 = DataType.TRUE;
        L29:
            r14.setValue(r1);
            return;
        L21:
            if (((Number) this.a.getScene().invoke()).intValue() == 1) goto L23;
        L24:
            this.a.m592getPkBaseResult().setValue(PkBaseDataContext.access$getCurPkResult$p(this.a));
        L25:
            this.a.setSetResultByInstallKill(false);
            this.a.getExtraResultAnim().setValue(Boolean.TRUE);
            goto L26
        L23:
            if (this.a.getSetResultByInstallKill() == true) goto L25;
        L31:
            if ((r13 instanceof PkBaseStateMachine.b.C0129b) == false) goto L37;
            PkBaseDataContext.onFinish$default(this.a, false, r13.a, r13.b, false, 9, null);
            this.a.m587getBaseScoreState().setValue(PkBaseDataContext.access$getCurScoreState$p(this.a));
            this.a.m596getTeamMode().setValue(null);
            PkBaseDataContext.access$get_pkState$p(this.a).setValue(PkBaseStateMachine.c.a.d);
            this.a.setSetResultByInstallKill(false);
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ PkBaseDataContext a;

        public d(PkBaseDataContext r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Long r6 = (Long) r5;
            d51.c r0 = d51.c.A0;
            r0.getClass();
            long r1 = ((Number) d51.c.f0.getValue(r0, d51.c.a[56])).longValue();
            if (r6 != null) goto L6;
            return;
        L6:
            if (r6.longValue() != r1) goto L17;
            PkBaseStateMachine.c r7 = (PkBaseStateMachine.c) this.a.getPkBaseState().getValue();
            if (r7 != null) goto L10;
            return;
        L10:
            if ((r7 instanceof PkBaseStateMachine.c.C0130c) == true) goto L12;
            return;
        L12:
            if (this.a.isNormalPk() == false) goto L20;
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.j r8 = PkBaseDataContext.access$getPkAudienceRequest$p(this.a);
            if (r8 == null) goto L21;
            r8.a(IPropInfoNotifyResponse.RequestPropCardNotifyType.TypeExpired.ordinal());
            return;
        L21:
            return;
        L20:
            return;
        }
    }

    public void onPause() {
        this.isInBack = true;
        if (getCurrentPkState().a() == false) goto L6;
        i97.a r0 = i97.a.a;
        this.onPkPauseTimeMs = System.currentTimeMillis();
        return;
    }

    public void onResume() {
        this.isInBack = false;
        if (getCurrentPkState().a() == true) goto L5;
        return;
    L5:
        if (this.onPkPauseTimeMs <= 0) goto L9;
        long r0 = this.pkBackDuration;
        i97.a r2 = i97.a.a;
        this.pkBackDuration = r0 + (System.currentTimeMillis() - this.onPkPauseTimeMs);
        return;
    }

    public final void resetDataForSwitch() {
        this.isBaseOnceMoreBattle = false;
        this.startSource = "";
        i97.a r2 = i97.a.a;
        this.startTimeMsField = System.currentTimeMillis();
        this.lastBattlePlayMode = null;
        setCurBattlePlayMode(null);
        this.curCloudCollaboratePanelType = null;
        this.battleSettingCache = null;
        this.battlePlayModeCache = null;
        this.channelIDForPkLog = 0;
        this.pkBeginCount = 0;
        this.pkCompleteCount = 0;
        this.pkStartTimeMs = 0;
        this.pkSource = "";
        this.onPkPauseTimeMs = 0;
        this.pkBackDuration = 0;
        PkBaseStateMachine.c r0 = getCurrentPkState();
        r0.getClass();
        if ((r0 instanceof PkBaseStateMachine.c.C0130c) == true) goto L5;
    L7:
        resetBattle();
        return;
    L5:
        if (this.isAnchor == true) goto L7;
        logPKWatchDuration("left");
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkStateMachineController.a
    public void updateBizExtra(c3 r1, r.b r2) {
        Intrinsics.checkNotNullParameter(r2, "bizExtra");
    }

    static {
        Companion = new b();
    }

    private final Map<String, PkBaseResult> getCurPkResult() {
        return (Map) this.resultDataContext.getPkResult().getValue();
    }

    private final List<cf2.a> getCurScoreState() {
        return (List) this.scoreDataContext.getScoreState().getValue();
    }

    private final PkBaseStateMachine.c getCurrentPkState() {
        return this.stateMachineController.f();
    }

    private final PlayMode getCurrentPlayMode() {
        return (PlayMode) this.modeDataContext.getPkMode().getValue();
    }

    private final long getPkWatchDuration() {
        if (this.pkStartTimeMs == 0) goto L11;
        i97.a r0 = i97.a.a;
        if (System.currentTimeMillis() < this.pkStartTimeMs) goto L11;
        long r1 = System.currentTimeMillis() - this.pkStartTimeMs;
        long r2 = this.pkBackDuration;
        if (r1 > r2) goto L10;
        return r1;
    L10:
        return r1 - r2;
    L11:
        jy0.b.c(TAG, "get watch duration error pkStartTimeMs:" + this.pkStartTimeMs, null, 4);
        return 0;
    }

    private final void resetBattle() {
        jy0.b.c(LOG_TAG, "resetBattle, currentPkState=" + this.curPkStateInfo, null, 4);
        this.propCardEffectInfo.setValue("");
        if (this.isAnchor == true) goto L6;
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        m.e.getClass();
        Object r0 = m.b(r1).b(com.bytedance.android.livesdk.revenue.service.gift.a.class);
        Intrinsics.checkNotNull(r0);
        ((com.bytedance.live.kmp.core.c) r0).clearBattlePropCardMessageQueue();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public LiveData<Long> getBaseTimeLeft() {
        return this.stateMachineController.c.getTimeLeft();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public LiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> getBattleScoreData() {
        return this.scoreDataContext.getBattleScoreData();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public m3 getBreakThoughConfig() {
        c21.f r0 = this.curBattlePlayMode;
        if ((r0 instanceof c21.f.a) == true) goto L5;
        r0 = null;
    L5:
        c21.f.a r1 = (c21.f.a) r0;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.b;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public n3 getBreakThroughInfo() {
        return (n3) this.breakThroughDataContext.getBreakthroughInfo().getValue();
    }

    public final com.bytedance.android.live.revlink.impl.utils.b getClearScreenLinkUtils() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getClearScreenLinkUtils();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public int getCloudCollaboratePanelType() {
        Integer r0 = this.curCloudCollaboratePanelType;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public Map<String, String> getCommonLogParams() {
        b21.c r0 = this.commonLogger;
        r0.getClass();
        LinkedHashMap r1 = new LinkedHashMap();
        if (r0.a.isBaseOnceMore() == false) goto L13;
        String r2 = r0.a.getStartSource();
        if (r2.length() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L13;
        r1.put("oncemore_source", r2);
        goto L13
    L7:
        r3 = false;
    L13:
        return r1;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public int getCustomizePlayType() {
        c21.f r0 = this.curBattlePlayMode;
        if ((r0 instanceof c21.f.d) == true) goto L5;
        r0 = null;
    L5:
        c21.f.d r1 = (c21.f.d) r0;
        if (r1 == null) goto L10;
        v2 r2 = r1.c;
        if (r2 == null) goto L10;
        return (int) r2.getPkValueType();
    L10:
        return 0;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public String getFlexActivityId() {
        c21.f r0 = this.curBattlePlayMode;
        if ((r0 instanceof c21.f.e) == true) goto L5;
        r0 = null;
    L5:
        c21.f.e r1 = (c21.f.e) r0;
        if (r1 == null) goto L9;
        String r2 = r1.b;
        if (r2 == null) goto L9;
        return r2;
    L9:
        return "";
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public ca getInteractPkInfo() {
        c21.f r0 = this.curBattlePlayMode;
        if ((r0 instanceof c21.f.C0009f) == true) goto L5;
        r0 = null;
    L5:
        c21.f.C0009f r1 = (c21.f.C0009f) r0;
        if (r1 == null) goto L11;
        IBattleConfigSetting r2 = r1.b;
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.getInteractConfig();
    L11:
        return null;
    }

    public final LinkCrossRoomDataHolder getLinkCrossRoomDataHolder() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkCrossRoomDataHolder();
    }

    public final LinkRevInternalServiceContext getLinkRevInternalServiceContext() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Cj();
    }

    public final d21.d getMergePkHelper() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMergePkHelper();
    }

    public final a21.a getPkBaseLogger() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkBaseLogger();
    }

    public boolean getPkScoreTextEnable() {
        Boolean r0 = (Boolean) this.scoreDataContext.getScoreTextEnable().getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public com.bytedance.android.live.revlink.impl.mergepk.pkbase.b getPkSkinConfig() {
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r0 = this.compatSkinConfig;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new com.bytedance.android.live.revlink.impl.mergepk.pkbase.b(0);
    }

    public final q getPkUtils() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkUtils();
    }

    public final s getRevLinkCommonUtil() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRevLinkCommonUtil();
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

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public w2 getShellConfig() {
        c21.f r0 = this.curBattlePlayMode;
        if ((r0 instanceof c21.f.k) == true) goto L5;
        r0 = null;
    L5:
        c21.f.k r1 = (c21.f.k) r0;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.b;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public String getShortPlayName() {
        c21.f r0 = this.curBattlePlayMode;
        if ((r0 instanceof c21.f.k) == true) goto L5;
        r0 = null;
    L5:
        c21.f.k r1 = (c21.f.k) r0;
        if (r1 == null) goto L18;
        w2 r2 = r1.b;
        if (r2 == null) goto L18;
        String r3 = r2.getName();
        if (r3 == null) goto L18;
        if (r3.length() <= 0) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L18;
        return r3;
    L14:
        r4 = false;
    L18:
        if (isInVote() == false) goto L21;
        return "投票";
    L21:
        return "PK";
    }

    public h9 getSpecifyGiftConfig() {
        c21.f r0 = this.curBattlePlayMode;
        if ((r0 instanceof c21.f.l) == true) goto L5;
        r0 = null;
    L5:
        c21.f.l r1 = (c21.f.l) r0;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.b;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public i31.c getTitleConfig() {
        i31.c r0 = new i31.c();
        IBaseBattleSetting r1 = getCurBattleSetting();
        h3 r2 = null;
        if (r1 == null) goto L5;
        h3 r3 = r1.getTitleConfig();
    L6:
        r0.a = r3;
        IBaseBattleSetting r4 = getCurBattleSetting();
        if (r4 == null) goto L9;
        r2 = r4.getPunishConfig();
    L9:
        r0.b = r2;
        return r0;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public aa getVoteSetting() {
        c21.f r0 = this.curBattlePlayMode;
        if ((r0 instanceof c21.f.m) == true) goto L5;
        r0 = null;
    L5:
        c21.f.m r1 = (c21.f.m) r0;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.b;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public boolean isCustomizePkPlay() {
        return this.curBattlePlayMode instanceof c21.f.d;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public boolean isInBreakThrough() {
        return this.curBattlePlayMode instanceof c21.f.a;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public boolean isInCloudCollaborate() {
        return this.curBattlePlayMode instanceof c21.f.b;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public boolean isInCompetition() {
        return this.curBattlePlayMode instanceof c21.f.k;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public boolean isInInteractPk() {
        return this.curBattlePlayMode instanceof c21.f.C0009f;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public boolean isInRobC() {
        return this.curBattlePlayMode instanceof c21.f.i;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public boolean isInSpecifyGiftPk() {
        return this.curBattlePlayMode instanceof c21.f.l;
    }

    public boolean isInSpecifyGiftPkBySelf() {
        c21.f r0 = this.curBattlePlayMode;
        if ((r0 instanceof c21.f.l) == false) goto L17;
        if (r0 == null) goto L16;
        h9 r1 = ((c21.f.l) r0).b;
        String r2 = null;
        if (r1 == null) goto L8;
        String r3 = r1.getSetUid();
    L9:
        s r4 = getRevLinkCommonUtil();
        if (r4 == null) goto L13;
        r2 = r4.e();
    L13:
        if (Intrinsics.areEqual(r3, r2) == false) goto L17;
        return true;
    L8:
        r3 = null;
        goto L9
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.mergepk.params.BattlePlayMode.SpecifyGiftPk");
    L17:
        return false;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public boolean isInVote() {
        return this.curBattlePlayMode instanceof c21.f.m;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public boolean isNormalPk() {
        return this.curBattlePlayMode instanceof c21.f.h;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public int queryLaunchToBizTypeAndReset() {
        int r0 = this.toBizTypeForMonitor;
        this.toBizTypeForMonitor = BizType.None.ordinal();
        return r0;
    }

    public void resetPkState() {
        this.stateMachineController.j.a(PkBaseStateMachine.a.b.c);
    }

    private final boolean needShowLastResult() {
        IBaseBattleSetting r0 = getBattleSettings();
        if (getCurPKBaseState().b() == false) goto L14;
        if (r0 == null) goto L14;
        if (af2.d.c(r0) != true) goto L14;
        com.bytedance.android.live.revlink.impl.utils.b r1 = getClearScreenLinkUtils();
        if (r1 == null) goto L12;
        if (r1.b() == true) goto L14;
    L12:
        if ((getLastBattlePlayMode() instanceof c21.f.a) == true) goto L14;
        return true;
    L14:
        return false;
    }

    public IBattleBarConfig getBarConfig() {
        IBaseBattleSetting r0 = getCurBattleSetting();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBarConfig();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public /* bridge */ /* synthetic */ LiveData getBaseScoreState() {
        return m587getBaseScoreState();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public /* bridge */ /* synthetic */ LiveData getBattleEffectInfo() {
        return m588getBattleEffectInfo();
    }

    public final long getBattleId() {
        IBaseBattleSetting r0 = getCurBattleSetting();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getBattleId();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public IBaseBattleSetting getBattleSettings() {
        if (getCurrentPkState().b() == false) goto L6;
        return this.battleSettingCache;
    L6:
        return getCurBattleSetting();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public /* bridge */ /* synthetic */ LiveData getBattleStatsMeta() {
        return m589getBattleStatsMeta();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public long getBreakThroughStage() {
        n3 r0 = getBreakThroughInfo();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getStage();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public IBattleConfigSetting getConfigSetting() {
        return getCurConfigSetting();
    }

    public final IBaseBattleSetting getCurBattleSetting() {
        return getPkInfo().a;
    }

    public final IBattleConfigSetting getCurConfigSetting() {
        IBaseBattleSetting r0 = getCurBattleSetting();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBattleConfigSetting();
    }

    public final int getCurDuration() {
        IBaseBattleSetting r0 = getCurBattleSetting();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return (int) r0.getDuration();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public PkBaseStateMachine.c getCurPKBaseState() {
        PkBaseStateMachine.c r0 = (PkBaseStateMachine.c) getPkBaseState().getValue();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return PkBaseStateMachine.c.a.d;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public Map<String, PkBaseResult> getCurPkResultMap() {
        return getCurPkResult();
    }

    public Map<String, z2> getGradeChanges() {
        return getPkInfo().h;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public /* bridge */ /* synthetic */ LiveData getLeftMvpRankList() {
        return m590getLeftMvpRankList();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public /* bridge */ /* synthetic */ LiveData getNeedShowLastResult() {
        return m591getNeedShowLastResult();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public /* bridge */ /* synthetic */ LiveData getPkBaseResult() {
        return m592getPkBaseResult();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public /* bridge */ /* synthetic */ LiveData getPkGuestListStr() {
        return m593getPkGuestListStr();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public long getPkId() {
        return getBattleId();
    }

    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a getPkInfo() {
        return getCurrentPkState().a;
    }

    public final PKModType getPkModeType() {
        IBattleConfigSetting r0 = getCurConfigSetting();
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.getModType());
    L6:
        if (r1 != null) goto L9;
    L11:
        if (r1 != null) goto L14;
    L16:
        if (r1 != null) goto L19;
    L21:
        if (r1 != null) goto L24;
    L26:
        if (r1 == null) goto L32;
        if (r1.intValue() != 8) goto L32;
        return PKModType.InteractPk;
    L32:
        return PKModType.Default;
    L24:
        if (r1.intValue() != 7) goto L26;
        return PKModType.CloudCollaborate;
    L19:
        if (r1.intValue() != 5) goto L21;
        return PKModType.SeasonRank;
    L14:
        if (r1.intValue() != 2) goto L16;
        return PKModType.BreakThrough;
    L9:
        if (r1.intValue() != 1) goto L11;
        return PKModType.Vote;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public h3 getPkTitleConfig() {
        IBaseBattleSetting r0 = getCurBattleSetting();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTitleConfig();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public h3 getPunishTitleConfig() {
        IBaseBattleSetting r0 = getCurBattleSetting();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPunishConfig();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public /* bridge */ /* synthetic */ LiveData getRightMvpRankList() {
        return m594getRightMvpRankList();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public p0 getServerBattleAttachedInfo() {
        return getPkInfo().o;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public Map<String, String> getServerEventTrackingInfo() {
        Map<String, String> r0 = getPkInfo().m;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new LinkedHashMap();
    }

    public /* bridge */ /* synthetic */ LiveData getShowLastBattleResult() {
        return m595getShowLastBattleResult();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public /* bridge */ /* synthetic */ LiveData getTeamMode() {
        return m596getTeamMode();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public String getTeamModeStr() {
        PlayMode r0 = (PlayMode) m596getTeamMode().getValue();
        if (r0 == null) goto L9;
        int r1 = g.a[r0.ordinal()];
        if (r1 != 1) goto L8;
        return "individual_pk";
    L8:
        if (r1 != 2) goto L9;
        return "team_pk";
    L9:
        return "";
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public /* bridge */ /* synthetic */ LiveData getTeamTaskLynxData() {
        return m597getTeamTaskLynxData();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public int getThroneFightEvenCount() {
        IBaseBattleSetting r0 = getCurBattleSetting();
        Unit r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.getLynxData();
        if (r2 == null) goto L7;
        JSONObject r3 = new JSONObject(r2);
    L8:
        int r4 = 0;
        if (r3 == null) goto L44;
        String r5 = r3.optString("cloud_collaborate_config");
        if (r5 == null) goto L44;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L40
        y3 r7 = (y3) l97.a.a.fromJson(r5, TypesJVMKt.getJavaType(Reflection.typeOf(y3.class)));     // Catch: Throwable -> L40
        if (r7 == null) goto L45;
        w0 r8 = r7.getThroneFightInfo();     // Catch: Throwable -> L40
        if (r8 == null) goto L45;
        w0.b r9 = r8.getOddStageInfo();     // Catch: Throwable -> L40
        if (r9 == null) goto L45;
        List r10 = r9.getUsers();     // Catch: Throwable -> L40
        if (r10 == null) goto L45;
        Iterator r12 = r10.iterator();     // Catch: Throwable -> L40
        int r13 = 0;
    L49:
    L34:
        Throwable th = th;
    L42:
        Result.Companion r14 = Result.Companion;
        Object r15 = Result.constructor-impl(ResultKt.createFailure(th));
        r4 = r13;
    L43:
        Result.box-impl(r15);
        goto L44
    L23:
        if (r12.hasNext() == false) goto L32;
        w0.c r16 = (w0.c) r12.next();     // Catch: Throwable -> L34
        if (r16.getUserId().length() != 0) goto L27;
        boolean r17 = true;
    L28:
        if (r17 == true) goto L31;
        if (Intrinsics.areEqual(r16.getUserId(), DataType.FALSE) == false) goto L49;
    L31:
        r13 = r13 + 1;     // Catch: Throwable -> L34
        goto L49
    L27:
        r17 = false;
        goto L28
    L32:
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L34
        r4 = r13;
    L45:
        r15 = Result.constructor-impl(r1);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        r13 = r4;
        th = th;
    L40:
        th = move-exception;
        th = th;
        r13 = 0;
    L44:
        return r4;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public Map<String, IBattleUserInfo> getUserInfoMap() {
        return getPkInfo().b;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public boolean inClassicDoublePK() {
        PkBaseStateMachine.c r0 = (PkBaseStateMachine.c) getPkBaseState().getValue();
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.a() != true) goto L9;
        if (com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.c.a(getPkInfo()) != PKBizType.ClassicDouble) goto L9;
        return true;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public boolean isBattleShow() {
        PkBaseStateMachine.c r0 = (PkBaseStateMachine.c) getPkBaseState().getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public PKModType modType() {
        return getPkModeType();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public MutableLiveData<z> getAudioPunishInfo() {
        return this.audioPunishInfo;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public MutableLiveData<Long> getAudioPunishRemainTime() {
        return this.audioPunishRemainTime;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public List<String> getAudioPunishUserIds() {
        return this.audioPunishUserIds;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public c21.f getBattlePlayMode() {
        return this.curBattlePlayMode;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public com.bytedance.android.live.revlink.impl.mergepk.pkbase.subplaymode.a getBreakThroughService() {
        return this.breakThroughDataContext;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public int getCompletePkCount() {
        return this.pkCompleteCount;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return this.context;
    }

    public final c21.f getCurBattlePlayMode() {
        return this.curBattlePlayMode;
    }

    public final Integer getCurCloudCollaboratePanelType() {
        return this.curCloudCollaboratePanelType;
    }

    public final wq2.f getDataCenterService() {
        return this.dataCenterService;
    }

    public final String getEventTrackingInfo() {
        return this.eventTrackingInfo;
    }

    public final MutableLiveData<Boolean> getExtraResultAnim() {
        return this.extraResultAnim;
    }

    public final x11.a getInternalLinkService() {
        return this.internalLinkService;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public c21.f getLastBattlePlayMode() {
        return this.lastBattlePlayMode;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public MutableLiveData<Boolean> getLastBattleResultVisible() {
        return this.lastBattleResultVisible;
    }

    public final ld.a getLinkDataSet() {
        return this.linkDataSet;
    }

    public final com.bytedance.android.live.revlink.impl.global.c getLinkFakeGlobalService() {
        return this.linkFakeGlobalService;
    }

    public final yz0.f getMessageService() {
        return this.messageService;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a getPkAnchorLauncher() {
        return this.pkAnchorLauncher;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public LiveData<PkBaseStateMachine.c> getPkBaseState() {
        return this.pkBaseState;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public int getPkPlayTimes() {
        return this.pkBeginCount;
    }

    public LiveData<PkBaseStateMachine.b> getPkSideEffect() {
        return this.pkSideEffect;
    }

    public final String getPkSource() {
        return this.pkSource;
    }

    public PublishSubject<Boolean> getPkStartEvent() {
        return this.pkStartEvent;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public long getPkStartTimeMs() {
        return this.onShowPkTime;
    }

    public final PkBaseResultDataContext getResultDataContext() {
        return this.resultDataContext;
    }

    public final com.bytedance.android.livesdk.revenue.service.room.c getRoomService() {
        return this.roomService;
    }

    public final Function0<Integer> getScene() {
        return this.scene;
    }

    public final PkBaseScoreDataContext getScoreDataContext() {
        return this.scoreDataContext;
    }

    public final boolean getSetResultByInstallKill() {
        return this.setResultByInstallKill;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public long getStartPenaltyTimeMs() {
        return this.onShowPenalTime;
    }

    public final String getStartSource() {
        return this.startSource;
    }

    public final long getStartTimeMsField() {
        return this.startTimeMsField;
    }

    public final PkStateMachineController getStateMachineController() {
        return this.stateMachineController;
    }

    public final AnchorLinkUserCenterV2 getUserCenter() {
        return this.userCenter;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public Map<String, Long> getUserIdToTeamId() {
        return this.userIdToTeamId;
    }

    public final boolean isAnchor() {
        return this.isAnchor;
    }

    public final boolean isBaseOnceMore() {
        return this.isBaseOnceMoreBattle;
    }

    public final boolean isBaseOnceMoreBattle() {
        return this.isBaseOnceMoreBattle;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public boolean isOnceMoreBattle() {
        return this.isBaseOnceMoreBattle;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public long startTimeMs() {
        return this.startTimeMsField;
    }

    /* JADX INFO: renamed from: getBaseScoreState, reason: collision with other method in class */
    public MutableLiveData<List<cf2.a>> m587getBaseScoreState() {
        return this.baseScoreState;
    }

    /* JADX INFO: renamed from: getBattleEffectInfo, reason: collision with other method in class */
    public MutableLiveData<String> m588getBattleEffectInfo() {
        return this.battleEffectInfo;
    }

    /* JADX INFO: renamed from: getBattleStatsMeta, reason: collision with other method in class */
    public MutableLiveData<c3> m589getBattleStatsMeta() {
        return this.battleStatsMeta;
    }

    /* JADX INFO: renamed from: getLeftMvpRankList, reason: collision with other method in class */
    public MutableLiveData<List<h7.b>> m590getLeftMvpRankList() {
        return this.leftMvpRankList;
    }

    /* JADX INFO: renamed from: getNeedShowLastResult, reason: collision with other method in class */
    public MutableLiveData<String> m591getNeedShowLastResult() {
        return this.needShowLastResult;
    }

    /* JADX INFO: renamed from: getPkBaseResult, reason: collision with other method in class */
    public MutableLiveData<Map<String, PkBaseResult>> m592getPkBaseResult() {
        return this.pkBaseResult;
    }

    /* JADX INFO: renamed from: getPkGuestListStr, reason: collision with other method in class */
    public MutableLiveData<String> m593getPkGuestListStr() {
        return this.pkGuestListStr;
    }

    /* JADX INFO: renamed from: getRightMvpRankList, reason: collision with other method in class */
    public MutableLiveData<List<h7.b>> m594getRightMvpRankList() {
        return this.rightMvpRankList;
    }

    /* JADX INFO: renamed from: getShowLastBattleResult, reason: collision with other method in class */
    public MutableLiveData<Boolean> m595getShowLastBattleResult() {
        return this.showLastBattleResult;
    }

    /* JADX INFO: renamed from: getTeamMode, reason: collision with other method in class */
    public MutableLiveData<PlayMode> m596getTeamMode() {
        return this.teamMode;
    }

    /* JADX INFO: renamed from: getTeamTaskLynxData, reason: collision with other method in class */
    public MutableLiveData<String> m597getTeamTaskLynxData() {
        return this.teamTaskLynxData;
    }

    public static final /* synthetic */ BaseBreakThroughDataContext access$getBreakThroughDataContext$p(PkBaseDataContext r0) {
        return r0.breakThroughDataContext;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(PkBaseDataContext r0) {
        return r0.cd;
    }

    public static final /* synthetic */ Map access$getCurPkResult$p(PkBaseDataContext r0) {
        return r0.getCurPkResult();
    }

    public static final /* synthetic */ List access$getCurScoreState$p(PkBaseDataContext r0) {
        return r0.getCurScoreState();
    }

    public static final /* synthetic */ PkBaseStateMachine.c access$getCurrentPkState$p(PkBaseDataContext r0) {
        return r0.getCurrentPkState();
    }

    public static final /* synthetic */ PlayMode access$getCurrentPlayMode$p(PkBaseDataContext r0) {
        return r0.getCurrentPlayMode();
    }

    public static final /* synthetic */ String access$getEventTrackingInfo$p(PkBaseDataContext r0) {
        return r0.eventTrackingInfo;
    }

    public static final /* synthetic */ PkBaseModeDataContext access$getModeDataContext$p(PkBaseDataContext r0) {
        return r0.modeDataContext;
    }

    public static final /* synthetic */ PkAnchorLauncher access$getPkAnchorLauncher$p(PkBaseDataContext r0) {
        return r0.pkAnchorLauncher;
    }

    public static final /* synthetic */ com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.j access$getPkAudienceRequest$p(PkBaseDataContext r0) {
        return r0.pkAudienceRequest;
    }

    public static final /* synthetic */ MutableLiveData access$getPropCardEffectInfo$p(PkBaseDataContext r0) {
        return r0.propCardEffectInfo;
    }

    public static final /* synthetic */ Observer access$getSideEffectObserver$p(PkBaseDataContext r0) {
        return r0.sideEffectObserver;
    }

    public static final /* synthetic */ Observer access$getTimeObserver$p(PkBaseDataContext r0) {
        return r0.timeObserver;
    }

    public static final /* synthetic */ int access$getToBizTypeForMonitor$p(PkBaseDataContext r0) {
        return r0.toBizTypeForMonitor;
    }

    public static final /* synthetic */ MutableLiveData access$get_pkState$p(PkBaseDataContext r0) {
        return r0._pkState;
    }

    public static final /* synthetic */ boolean access$needShowLastResult(PkBaseDataContext r0) {
        return r0.needShowLastResult();
    }

    private final List<com.bytedance.android.live.revlink.impl.mergepk.pkbase.d> getBizHandlerList(PKBizType r2) {
        List<com.bytedance.android.live.revlink.impl.mergepk.pkbase.d> r3 = this.bizHandlerMap.get(r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return CollectionsKt.emptyList();
    }

    private final boolean isBattleInterrupt(PkBaseStateMachine.Source r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3 != PkBaseStateMachine.Source.MultipleInvite) goto L8;
    L17:
        return true;
    L8:
        if (r3 == PkBaseStateMachine.Source.CutShort) goto L17;
        if (r3 == PkBaseStateMachine.Source.RoomClose) goto L17;
        if (r3 == PkBaseStateMachine.Source.NormalToMultiple) goto L17;
        if (r3 == PkBaseStateMachine.Source.RtcLinkerLeave) goto L17;
        if (r3 == PkBaseStateMachine.Source.LinkerLeave) goto L17;
        return false;
    }

    private final boolean isConnectInterrupt(PkBaseStateMachine.Source r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3 != PkBaseStateMachine.Source.RtcLinkerLeave) goto L8;
    L13:
        return true;
    L8:
        if (r3 == PkBaseStateMachine.Source.CutShort) goto L13;
        if (r3 == PkBaseStateMachine.Source.RoomClose) goto L13;
        if (r3 == PkBaseStateMachine.Source.NormalToMultiple) goto L13;
        return false;
    }

    private final void logPKWatchDuration(String r12) {
        if (this.isAnchor == false) goto L6;
        return;
    L6:
        if (this.isInBack == true) goto L8;
    L10:
        a21.a r2 = getPkBaseLogger();
        if (r2 == null) goto L18;
        c21.f r13 = this.curBattlePlayMode;
        if (r13 == null) goto L15;
        String r14 = r13.b();
    L16:
        r2.d(r14, getPkWatchDuration(), this.channelIDForPkLog, this.pkSource, ((Number) this.scene.invoke()).intValue());
        return;
    L15:
        r14 = "routine";
        goto L16
    L18:
        return;
    L8:
        if (this.onPkPauseTimeMs <= 0) goto L10;
        long r0 = this.pkBackDuration;
        i97.a r15 = i97.a.a;
        this.pkBackDuration = r0 + (System.currentTimeMillis() - this.onPkPauseTimeMs);
        goto L10
    }

    private final boolean needShowLastBattleResult(Map<String, ? extends PkBaseResult> r4) {
        IBaseBattleSetting r0 = this.battleSettingCache;
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (af2.d.c(r0) != true) goto L11;
        if (r4 != null) goto L10;
        return false;
    L10:
        return !r4.isEmpty();
    }

    private final void onBattleTeamTaskMsg(u0 r2) {
        notifyTeamTaskLynxDataUpdate(r2.castTo(g5.class).getTeamTaskJson());
    }

    public String getLinkerID(String r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$linkerID");
        return j.a.a(this, r2);
    }

    public int getPropCardEffectType(String r10) {
        Intrinsics.checkNotNullParameter(r10, "uid");
        String r0 = (String) this.propCardEffectInfo.getValue();
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return 0;
    L11:
        e1 r1 = (e1) GsonProtectorUtils.fromJson(l97.a.a, r0, TypesJVMKt.getJavaType(Reflection.typeOf(e1.class)));
        long r3 = com.bytedance.live.kmp.util.e.b();
        Map r4 = r1.getAnchorEffectMap();
        if (r4 == null) goto L30;
        Iterator r5 = MapsKt.toMap(r4).entrySet().iterator();
    L15:
        if (r5.hasNext() == false) goto L30;
        Map.Entry r6 = (Map.Entry) r5.next();
        String r7 = (String) r6.getKey();
        com.bytedance.android.livesdk.link.model.j r8 = (com.bytedance.android.livesdk.link.model.j) r6.getValue();
        if (Intrinsics.areEqual(r7.toString(), r10) == false) goto L15;
        if (r8 == null) goto L15;
        List r9 = r8.getEffectList();
        if (r9 == null) goto L15;
        Iterator r12 = r9.iterator();
    L23:
        if (r12.hasNext() == false) goto L15;
        f4 r13 = (f4) r12.next();
        if (r3 < r13.getStartTime()) goto L23;
        if (r3 > r13.getEndTime()) goto L23;
        return r13.getEffectType();
    L30:
        return 0;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public String getUid(String r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$uid");
        return j.a.b(this, r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public boolean isCustomPKPlay(boolean r3) {
        if (r3 == false) goto L19;
        if ((this.curBattlePlayMode instanceof c21.f.g) == false) goto L17;
        IBaseBattleSetting r4 = getCurBattleSetting();
        String r0 = null;
        if (r4 == null) goto L10;
        IBattleConfigSetting r5 = r4.getBattleConfigSetting();
        if (r5 == null) goto L10;
        String r6 = r5.getFromAnchorID();
    L11:
        s r1 = getRevLinkCommonUtil();
        if (r1 == null) goto L15;
        r0 = r1.e();
    L15:
        if (Intrinsics.areEqual(r6, r0) == false) goto L17;
        return true;
    L10:
        r6 = null;
    L17:
        return false;
    L19:
        return this.curBattlePlayMode instanceof c21.f.g;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public boolean isInAudioPunish(String r2) {
        Intrinsics.checkNotNullParameter(r2, "linkmicId");
        return getAudioPunishUserIds().contains(r2);
    }

    public void notifyTeamTaskLynxDataUpdate(String r2) {
        m597getTeamTaskLynxData().setValue(r2);
    }

    public final void onBaseMessage(yh6.c r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        if ((r6 instanceof com.bytedance.android.livesdk.link.model.bridge.q) == false) goto L10;
        d1 r7 = ((vh7.c) r6).castTo(d1.class);
        if (getBattleId() != r7.getBattleId()) goto L11;
        String r8 = r7.getBattleEffectInfo();
        this.propCardEffectInfo.setValue(r8);
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkStateMachineController.a
    public void onReceiveBattleEndPunishMsg(y4 r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        StringBuilder r0 = new StringBuilder("onReceiveBattleEndPunishMsg ");
        u1 r1 = r5.getBattleSetting();
        PKBizType r2 = null;
        if (r1 == null) goto L5;
        PKBizType r3 = com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.c.b(r1);
    L6:
        r0.append(r3);
        jy0.b.c("pk_biz_handler", r0.toString(), null, 4);
        u1 r4 = r5.getBattleSetting();
        if (r4 == null) goto L9;
        r2 = com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.c.b(r4);
    L9:
        Iterator<T> r6 = getBizHandlerList(r2).iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        ((com.bytedance.android.live.revlink.impl.mergepk.pkbase.d) r6.next()).onBizReceiveBattleEndPunishMsg(r5);
        goto L11
    L13:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkStateMachineController.a
    public void onReceiveBattleFinishMsg(a5 r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        PKBizType r1 = null;
        if (getMergePkHelper() == null) goto L5;
        PkBaseStateMachine.Source r0 = d21.d.b(r5.getEndReason());
    L7:
        if (this.isAnchor == false) goto L9;
    L13:
        StringBuilder r2 = new StringBuilder("onReceiveBattleFinishMsg ");
        u1 r3 = r5.getBattleSetting();
        if (r3 == null) goto L16;
        PKBizType r4 = com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.c.b(r3);
    L17:
        r2.append(r4);
        jy0.b.c("pk_biz_handler", r2.toString(), null, 4);
        u1 r6 = r5.getBattleSetting();
        if (r6 == null) goto L20;
        r1 = com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.c.b(r6);
    L20:
        Iterator<T> r7 = getBizHandlerList(r1).iterator();
    L22:
        if (r7.hasNext() == false) goto L24;
        ((com.bytedance.android.live.revlink.impl.mergepk.pkbase.d) r7.next()).onBizReceiveBattleFinishMsg(r5);
        goto L22
    L24:
        return;
    L16:
        r4 = null;
        goto L17
    L9:
        if (r0 != PkBaseStateMachine.Source.ChangeMode) goto L11;
    L12:
        logPKWatchDuration("interrupt");
        goto L13
    L11:
        if (isBattleInterrupt(r0) == false) goto L13;
    L5:
        r0 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkStateMachineController.a
    public void onReceiveBattleMsg(c5 r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        String r0 = r5.getRequestSource();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this.startSource = r0;
        StringBuilder r1 = new StringBuilder("onReceiveBattleMsg ");
        u1 r2 = r5.getBattleSetting();
        PKBizType r3 = null;
        if (r2 == null) goto L8;
        PKBizType r4 = com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.c.b(r2);
    L9:
        r1.append(r4);
        jy0.b.c("pk_biz_handler", r1.toString(), null, 4);
        u1 r6 = r5.getBattleSetting();
        if (r6 == null) goto L12;
        r3 = com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.c.b(r6);
    L12:
        Iterator<T> r7 = getBizHandlerList(r3).iterator();
    L14:
        if (r7.hasNext() == false) goto L16;
        ((com.bytedance.android.live.revlink.impl.mergepk.pkbase.d) r7.next()).onBizReceiveBattleMsg(r5);
        goto L14
    L16:
        return;
    L8:
        r4 = null;
        goto L9
    }

    public final void setBaseOnceMoreBattle(boolean r1) {
        this.isBaseOnceMoreBattle = r1;
    }

    public final void setCurBattlePlayMode(c21.f r2) {
        if ((!Intrinsics.areEqual(r2, this.curBattlePlayMode)) == false) goto L14;
        this.curBattlePlayMode = r2;
        RevLinkWindowRegionContext r0 = i.c0(this);
        if (r0 == null) goto L15;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r1 = r0.getPartnerService();
        if (r1 == null) goto L16;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r3 = (com.bytedance.android.live.revlink.impl.multianchor.service.g) r1.getValue();
        if (r3 == null) goto L17;
        NextLiveData<Boolean> r4 = r3.getBattleStatus();
        if (r4 == null) goto L18;
        r4.postValue(Boolean.valueOf(r2 instanceof c21.f.b));
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

    public final void setCurCloudCollaboratePanelType(Integer r1) {
        this.curCloudCollaboratePanelType = r1;
    }

    public final void setPkSource(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.pkSource = r2;
    }

    public final void setSetResultByInstallKill(boolean r1) {
        this.setResultByInstallKill = r1;
    }

    public final void setStartTimeMsField(long r1) {
        this.startTimeMsField = r1;
    }

    public void setUserIdToTeamId(Map<String, Long> r1) {
        this.userIdToTeamId = r1;
    }

    public final void setUserIdToTeamIdExtra(Map<String, Long> r1) {
        setUserIdToTeamId(r1);
    }

    public void sharedWithRoomId(long r4) {
        if (r4 != 0) goto L5;
        return;
    L5:
        com.bytedance.android.live.revlink.impl.global.d.a(this, "PkBaseDataContext_" + r4, this.linkFakeGlobalService);
    }

    public void startBizEnd(c21.i r3) {
        Intrinsics.checkNotNullParameter(r3, "bizEndParam");
        PkAnchorLauncher r0 = this.pkAnchorLauncher;
        if (r0 == null) goto L6;
        r0.i(r3, null);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkStateMachineController.a
    public void updateBattleStatsMeta(c3 r5) {
        Intrinsics.checkNotNullParameter(r5, "battleStatsMeta");
        jy0.b.c("testRank", "updateBattleStatsMeta " + r5, null, 4);
        m589getBattleStatsMeta().setValue(r5);
        String r0 = r5.getBattleEffectInfo();
        if (r0 != null) goto L5;
    L10:
        notifyTeamTaskLynxDataUpdate(r5.getTeamTaskJson());
        return;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 != true) goto L10;
        this.propCardEffectInfo.setValue(r5.getBattleEffectInfo());
        goto L10
    L7:
        r1 = false;
        goto L8
    }

    public static final /* synthetic */ void access$logPKWatchDuration(PkBaseDataContext r0, String r1) {
        r0.logPKWatchDuration(r1);
    }

    public static final /* synthetic */ void access$onBattleTeamTaskMsg(PkBaseDataContext r0, u0 r1) {
        r0.onBattleTeamTaskMsg(r1);
    }

    public static final /* synthetic */ void access$setEventTrackingInfo$p(PkBaseDataContext r0, String r1) {
        r0.eventTrackingInfo = r1;
    }

    public static final /* synthetic */ void access$setPkAnchorLauncher$p(PkBaseDataContext r0, PkAnchorLauncher r1) {
        r0.pkAnchorLauncher = r1;
    }

    public static final /* synthetic */ void access$setPkAudienceRequest$p(PkBaseDataContext r0, com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.j r1) {
        r0.pkAudienceRequest = r1;
    }

    public static final /* synthetic */ void access$setToBizTypeForMonitor$p(PkBaseDataContext r0, int r1) {
        r0.toBizTypeForMonitor = r1;
    }

    private final boolean isSameCustomizePlay(v2 r8, v2 r9) {
        if (r9 != null) goto L5;
        return false;
    L5:
        if (((int) r9.getPkValueType()) == 3) goto L12;
        long r1 = r9.getPkValueType();
        if (r8 != null) goto L9;
        return false;
    L9:
        if (r1 != r8.getPkValueType()) goto L28;
    L10:
        return true;
    L28:
        return false;
    L12:
        if (r9.getPkGiftRate() <= 0) goto L19;
        if (r8 == null) goto L15;
        long r2 = r8.getPkGiftRate();
    L17:
        if (r2 > 0) goto L10;
    L15:
        r2 = 0;
    L19:
        if (r9.getPkUVRate() <= 0) goto L30;
        if (r8 == null) goto L22;
        long r10 = r8.getPkUVRate();
    L24:
        if (r10 > 0) goto L10;
        return false;
    L22:
        r10 = 0;
        goto L24
    L30:
        return false;
    }

    private final boolean updateIsOnceMore(c21.f r2, c21.f r3) {
        if ((r2 instanceof c21.f.d) == true) goto L5;
    L8:
        if (r2 != null) goto L12;
        return false;
    L12:
        return r2.a(r3);
    L5:
        if ((r3 instanceof c21.f.d) == false) goto L8;
        return isSameCustomizePlay(((c21.f.d) r2).c, ((c21.f.d) r3).c);
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.e
    public void notifyPkContext(r r17, boolean r18) {
        boolean r2 = false;
        if (this.isAnchor == true) goto L110;
        y41.f r1 = y41.f.N;
        r1.getClass();
        String r4 = null;
        if (((Boolean) y41.f.K.getValue(r1, y41.f.a[35])).booleanValue() == false) goto L12;
        if (r17 == null) goto L10;
        c3 r3 = r17.getBattleStatsMeta();
        if (r3 == null) goto L10;
        String r5 = r3.getTeamTaskJson();
    L11:
        notifyTeamTaskLynxDataUpdate(r5);
    L10:
        r5 = null;
    L12:
        PkStateMachineController r6 = this.stateMachineController;
        if (r17 == null) goto L15;
        c3 r7 = r17.getBattleStatsMeta();
    L16:
        if (r17 == null) goto L18;
        r.b r8 = r17.getBizExtra();
    L19:
        r6.getClass();
        if (r7 == null) goto L22;
        c1 r9 = r7.getBattleSetting();
    L24:
        if (r9 != null) goto L26;
    L79:
        jy0.b.c("ttlive_PkStateMachine", "force reset for battle setting error", null, 4);
        r6.j.a(PkBaseStateMachine.a.b.c);
    L80:
        StringBuilder r10 = new StringBuilder("notifyPkContext ");
        if (r17 == null) goto L83;
        c3 r12 = r17.getBattleStatsMeta();
    L84:
        r10.append(r12);
        jy0.b.c("testRank", r10.toString(), null, 4);
        MutableLiveData<c3> r13 = m589getBattleStatsMeta();
        if (r17 == null) goto L87;
        c3 r14 = r17.getBattleStatsMeta();
    L88:
        r13.setValue(r14);
        y41.f r15 = y41.f.N;
        r15.getClass();
        if (((Boolean) y41.f.K.getValue(r15, y41.f.a[35])).booleanValue() == true) goto L95;
        if (r17 == null) goto L94;
        c3 r16 = r17.getBattleStatsMeta();
        if (r16 == null) goto L94;
        r4 = r16.getTeamTaskJson();
    L94:
        notifyTeamTaskLynxDataUpdate(r4);
    L95:
        c3 r19 = (c3) m589getBattleStatsMeta().getValue();
        if (r19 == null) goto L110;
        String r20 = r19.getBattleEffectInfo();
        if (r20 == null) goto L110;
        if (r20.length() <= 0) goto L102;
        boolean r22 = true;
    L103:
        if (r22 != true) goto L110;
        MutableLiveData<String> r23 = this.propCardEffectInfo;
        c3 r24 = (c3) m589getBattleStatsMeta().getValue();
        if (r24 == null) goto L108;
        String r25 = r24.getBattleEffectInfo();
        if (r25 == null) goto L108;
    L109:
        r23.setValue(r25);
    L108:
        r25 = "";
        goto L109
    L102:
        r22 = false;
        goto L103
    L87:
        r14 = null;
        goto L88
    L83:
        r12 = null;
        goto L84
    L26:
        if (r9.getBattleId() == 0) goto L79;
        long r110 = r9.getBattleId();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r111 = r6.h;
        if (r111 == null) goto L35;
        IBaseBattleSetting r112 = r111.a;
        if (r112 == null) goto L35;
        if (r110 != r112.getBattleId()) goto L35;
        jy0.b.c("ttlive_PkStateMachine", "repeat for same battle_id", null, 4);
    L35:
        if (r18 == false) goto L43;
        StringBuilder r113 = new StringBuilder("force reset for old: ");
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r114 = r6.h;
        if (r114 == null) goto L41;
        IBaseBattleSetting r115 = r114.a;
        if (r115 == null) goto L41;
        Long r116 = Long.valueOf(r115.getBattleId());
    L42:
        r113.append(r116);
        r113.append("   new: ");
        r113.append(r9.getBattleId());
        jy0.b.c("ttlive_PkStateMachine", r113.toString(), null, 4);
        r6.j.a(PkBaseStateMachine.a.b.c);
    L41:
        r116 = null;
    L43:
        jy0.b.c("ttlive_PkStateMachine", "battle meta update bizExtra = " + r8, null, 4);
        if (r8 == null) goto L48;
        PkStateMachineController.a r26 = r6.d;
        if (r26 == null) goto L48;
        r26.updateBizExtra(r7, r8);
    L48:
        int r27 = com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a.p;
        if (((Number) r6.m.invoke()).intValue() != 7) goto L64;
        i11.b r28 = r6.l;
        if (r28 == null) goto L53;
        List<p> r29 = r28.getOnlineUserList();
    L54:
        HashMap r117 = new HashMap();
        if (r29 == null) goto L64;
        Iterator<T> r30 = r29.iterator();
    L58:
        if (r30.hasNext() == false) goto L64;
        p r118 = (p) r30.next();
        IBattleUserInfo r119 = vh7.f.c(IBattleUserInfo.class);
        r119.setPkRole(com.bytedance.android.livesdk.link.model.q.d(r118));
        IBaseUser r120 = r118.getUser();
        if (r120 == null) goto L58;
        String r121 = r120.getIdString();
        if (r121 == null) goto L58;
        r117.put(r121, r119);
        goto L58
    L53:
        r29 = null;
    L64:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r32 = com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a.C0134a.a(r7);
        if (r8 == null) goto L69;
        y1 r33 = r8.getOpenGameInfo();
        if (r33 == null) goto L69;
        String r34 = r33.getAppId();
    L70:
        if (r34 != null) goto L72;
    L75:
        boolean r35 = true;
    L76:
        if (r35 == true) goto L78;
        r6.j.a(PkBaseStateMachine.a.j.c);
        goto L80
    L78:
        r6.j.a(new PkBaseStateMachine.a.e(r32));
        goto L80
    L72:
        if (r34.length() == 0) goto L75;
        r35 = false;
    L69:
        r34 = null;
        goto L70
    L22:
        r9 = null;
        goto L24
    L18:
        r8 = null;
        goto L19
    L15:
        r7 = null;
    L110:
        MutableLiveData<Boolean> r36 = m595getShowLastBattleResult();
        if (r17 == null) goto L117;
        s5 r37 = r17.getLinkStatsMeta();
        if (r37 == null) goto L117;
        if (r37.getBattleDisplayEntrance() != true) goto L117;
        r2 = true;
    L117:
        r36.setValue(Boolean.valueOf(r2));
    }

    public final Disposable registerBiz(final com.bytedance.android.live.revlink.impl.mergepk.pkbase.d r3, PKBizType r4) {
        Intrinsics.checkNotNullParameter(r3, "bizHandler");
        Intrinsics.checkNotNullParameter(r4, "pkBizType");
        final List<com.bytedance.android.live.revlink.impl.mergepk.pkbase.d> r0 = this.bizHandlerMap.get(r4);
        if (r0 != null) goto L5;
        r0 = new ArrayList();
        this.bizHandlerMap.put(r4, r0);
    L5:
        r0.add(r3);
        int r5 = h.a;
        return h.a(new AnonymousClass1(r0, r3));
    }

    public void startBizInvite(c21.j r2, com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.b r3) {
        Intrinsics.checkNotNullParameter(r2, "bizInviteParams");
        PkAnchorLauncher r4 = this.pkAnchorLauncher;
        if (r4 == null) goto L6;
        r4.o(r2, null);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkStateMachineController.a
    public void onFinishCallback(PkBaseStateMachine.Source r5, f1 r6, Throwable r7) {
        Intrinsics.checkNotNullParameter(r5, "stateSource");
        PKBizType r2 = null;
        jy0.b.c("pk_biz_handler", "onFinishCallback " + com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.c.a(getPkInfo()), null, 4);
        if (r6 == null) goto L9;
        g1 r0 = r6.getFinishInfo();
        if (r0 == null) goto L9;
        u1 r1 = r0.getBattleSetting();
        if (r1 == null) goto L9;
        r2 = com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.c.b(r1);
    L9:
        Iterator<T> r3 = getBizHandlerList(r2).iterator();
    L11:
        if (r3.hasNext() == false) goto L13;
        ((com.bytedance.android.live.revlink.impl.mergepk.pkbase.d) r3.next()).onBizFinishCallback(r5, r6, r7);
        goto L11
    }

    private final void onFinish(boolean r8, PkBaseStateMachine.c r9, PkBaseStateMachine.c r10, boolean r12) {
        PKBizType r0 = null;
        if (r9 == null) goto L5;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r1 = r9.a;
    L6:
        if (r10 == null) goto L8;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2 = r10.a;
    L9:
        if (r2 == null) goto L14;
        IBaseBattleSetting r3 = r2.a;
        if (r3 == null) goto L14;
        this.battleSettingCache = r3;
    L14:
        if (r8 == false) goto L21;
        if (r2 == null) goto L21;
        StringBuilder r5 = new StringBuilder("skip peanl ");
        IBaseBattleSetting r6 = r2.a;
        if (r6 == null) goto L19;
        String r7 = af2.d.e(r6);
    L20:
        r5.append(r7);
        jy0.b.c(LOG_TAG, r5.toString(), null, 4);
        goto L21
    L19:
        r7 = null;
    L21:
        resetBattle();
        this.compatSkinConfig = null;
        if (r12 == false) goto L30;
        StringBuilder r13 = new StringBuilder("post multiPkFinishEvent ");
        if (r1 == null) goto L28;
        IBaseBattleSetting r4 = r1.a;
        if (r4 == null) goto L28;
        String r14 = af2.d.e(r4);
    L29:
        r13.append(r14);
        jy0.b.f(LOG_TAG, r13.toString(), null, 4);
    L28:
        r14 = null;
    L30:
        this.needShowLastBattleResult = needShowLastBattleResult((Map) m592getPkBaseResult().getValue());
        this.lastBattlePlayMode = this.curBattlePlayMode;
        StringBuilder r15 = new StringBuilder("onFinish isConnectInterrupt=");
        if (r10 == null) goto L33;
        PkBaseStateMachine.Source r16 = r10.b;
    L34:
        r15.append(isConnectInterrupt(r16));
        r15.append(", src = ");
        if (r10 == null) goto L37;
        PkBaseStateMachine.Source r17 = r10.b;
    L38:
        r15.append(r17);
        r15.append(", curBattlePlayMode = ");
        r15.append(this.curBattlePlayMode);
        r15.append(", curCloudCollaboratePanelType = ");
        r15.append(this.curCloudCollaboratePanelType);
        jy0.b.c(LOG_TAG, r15.toString(), null, 4);
        if (r10 == null) goto L41;
        PkBaseStateMachine.Source r18 = r10.b;
    L43:
        if (isConnectInterrupt(r18) == true) goto L46;
        setCurBattlePlayMode(null);
        this.curCloudCollaboratePanelType = null;
    L56:
        StringBuilder r19 = new StringBuilder("onFinish ");
        if (r2 == null) goto L59;
        PKBizType r20 = com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.c.a(r2);
    L60:
        r19.append(r20);
        jy0.b.c("pk_biz_handler", r19.toString(), null, 4);
        if (r2 == null) goto L63;
        r0 = com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.c.a(r2);
    L63:
        Iterator<T> r22 = getBizHandlerList(r0).iterator();
    L65:
        if (r22.hasNext() == false) goto L67;
        ((com.bytedance.android.live.revlink.impl.mergepk.pkbase.d) r22.next()).onBizFinished(r8, r9, r10, r12);
        goto L65
    L67:
        return;
    L59:
        r20 = null;
        goto L60
    L46:
        if ((this.curBattlePlayMode instanceof c21.f.b) == false) goto L56;
        RevLinkWindowRegionContext r23 = i.c0(this);
        if (r23 == null) goto L56;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r24 = r23.getPartnerService();
        if (r24 == null) goto L56;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r25 = (com.bytedance.android.live.revlink.impl.multianchor.service.g) r24.getValue();
        if (r25 == null) goto L56;
        NextLiveData<Boolean> r26 = r25.getBattleStatus();
        if (r26 == null) goto L56;
        r26.postValue(Boolean.FALSE);
        goto L56
    L41:
        r18 = null;
        goto L43
    L37:
        r17 = null;
        goto L38
    L33:
        r16 = null;
        goto L34
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    private final void onShowPK(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r12, PkBaseStateMachine.c r13, PkBaseStateMachine.c r14, PkBaseStateMachine.Source r15) {
        LinkCrossRoomDataHolder r0 = getLinkCrossRoomDataHolder();
        if (r0 == null) goto L5;
        long r3 = r0.c();
    L6:
        this.channelIDForPkLog = r3;
        IBaseBattleSetting r1 = r12.a;
        if (r1 == null) goto L9;
        long r4 = r1.getStartTimeMs();
    L10:
        this.startTimeMsField = r4;
        i97.a r2 = i97.a.a;
        this.pkStartTimeMs = System.currentTimeMillis();
        this.pkBackDuration = 0;
        if (this.isInBack == false) goto L13;
        this.onPkPauseTimeMs = System.currentTimeMillis();
    L13:
        this.battleSettingCache = r12.a;
        this.onShowPkTime = System.currentTimeMillis();
        if ((r13 instanceof PkBaseStateMachine.c.C0130c) == false) goto L16;
    L17:
        m596getTeamMode().setValue(null);
        resetBattle();
    L18:
        this.curPkStateInfo = r12;
        this.compatSkinConfig = r12.g;
        this.pkBeginCount++;
        if (this.isAnchor == false) goto L23;
        r13.getClass();
        if ((r13 instanceof PkBaseStateMachine.c.C0130c) == false) goto L23;
        this.pkCompleteCount++;
    L23:
        PkAnchorLauncher r5 = this.pkAnchorLauncher;
        if (r5 == null) goto L29;
        Disposable r6 = r5.g;
        if (r6 == null) goto L28;
        r6.dispose();
    L28:
        r5.h.setValue(c21.c.C0008c.a);
    L29:
        this.lastBattlePlayMode = this.curBattlePlayMode;
        d21.d r7 = getMergePkHelper();
        if (r7 == null) goto L40;
        IBaseBattleSetting r8 = r12.a;
        if (r8 == null) goto L34;
        IBattleConfigSetting r9 = r8.getBattleConfigSetting();
    L35:
        PlayMode r10 = getCurrentPlayMode();
        if (r10 == null) goto L38;
        int r16 = r10.toNetFormat();
    L39:
        c21.f r17 = d21.d.a(r7, r9, r16, ((Number) this.scene.invoke()).intValue());
    L41:
        this.isBaseOnceMoreBattle = updateIsOnceMore(this.lastBattlePlayMode, r17);
        if (r13.a() == false) goto L44;
    L49:
        this.pkSource = "switch";
    L50:
        setCurBattlePlayMode(r17);
        this.battlePlayModeCache = r17;
        if ((this.curBattlePlayMode instanceof c21.f.b) == false) goto L61;
        IBaseBattleSetting r18 = r12.a;
        if (r18 == null) goto L59;
        IBattleConfigSetting r19 = r18.getBattleConfigSetting();
        if (r19 == null) goto L59;
        v0 r20 = r19.getCloudCollaborateConfig();
        if (r20 == null) goto L59;
        Integer r22 = Integer.valueOf(r20.getPanelType());
    L60:
        this.curCloudCollaboratePanelType = r22;
    L59:
        r22 = null;
    L61:
        this.needShowLastBattleResult = false;
        jy0.b.c(LOG_TAG, "onShowPK fromState " + r13 + " toState " + r14 + " source=" + r15 + " isOnceMore=" + this.isBaseOnceMoreBattle + " pkMode=" + getCurrentPlayMode(), null, 4);
        q r23 = getPkUtils();
        if (r23 == null) goto L66;
        PkCustomizePlayDataContext r24 = r23.f();
        if (r24 == null) goto L66;
        r24.setBattleSelfData(null);
    L66:
        q r25 = getPkUtils();
        if (r25 == null) goto L75;
        PkCustomizePlayDataContext r26 = r25.f();
        if (r26 == null) goto L75;
        IBaseBattleSetting r27 = r12.a;
        if (r27 == null) goto L73;
        IBattleConfigSetting r28 = r27.getBattleConfigSetting();
    L74:
        r26.setBattleConfigSetting(r28);
        goto L75
    L73:
        r28 = null;
    L75:
        q r29 = getPkUtils();
        if (r29 == null) goto L82;
        PkCustomizePlayDataContext r30 = r29.f();
        if (r30 == null) goto L82;
        MutableLiveData<Integer> r32 = r30.getBackOperationType();
        if (r32 == null) goto L82;
        r32.setValue(0);
    L82:
        q r33 = getPkUtils();
        if (r33 == null) goto L87;
        PkCustomizePlayDataContext r34 = r33.f();
        if (r34 == null) goto L87;
        r34.setBackOperationType4Log(0);
    L87:
        jy0.b.c("pk_biz_handler", "onShowPK " + com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.c.a(r12), null, 4);
        Iterator<T> r35 = getBizHandlerList(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.c.a(r12)).iterator();
    L89:
        if (r35.hasNext() == false) goto L91;
        ((com.bytedance.android.live.revlink.impl.mergepk.pkbase.d) r35.next()).onBizPK(r12, r13, r14, r15, this.isBaseOnceMoreBattle, getCurrentPlayMode());
        goto L89
    L91:
        this.isFirstPk = false;
        if (this.isAnchor == false) goto L94;
        return;
    L94:
        if (isNormalPk() == false) goto L106;
        Long r110 = (Long) getBaseTimeLeft().getValue();
        if (r110 == null) goto L107;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.j r111 = this.pkAudienceRequest;
        if (r111 == null) goto L108;
        long r112 = r110.longValue();
        Disposable r113 = r111.b;
        if (r113 == null) goto L102;
        r113.dispose();
    L102:
        l r114 = l.a;
        int r115 = com.bytedance.revenue.platform.api.core.rx.p.a;
        r111.b = Observable.timer(3000, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(r111, r112), com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.l.a);
        return;
    L108:
        return;
    L107:
        return;
    L106:
        return;
    L44:
        if (this.isBaseOnceMoreBattle == true) goto L49;
        if (r15 == PkBaseStateMachine.Source.MetaUpdate) goto L50;
        this.pkSource = "transform";
        goto L50
    L38:
        r16 = 0;
        goto L39
    L34:
        r9 = null;
        goto L35
    L40:
        r17 = null;
        goto L41
    L16:
        if ((r13 instanceof PkBaseStateMachine.c.d) == false) goto L18;
    L9:
        r4 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    private final void onShowPenal(PkBaseStateMachine.c r6, com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r7, PkBaseStateMachine.Source r8, PkBaseStateMachine.c r9) {
        r6.getClass();
        if ((r6 instanceof PkBaseStateMachine.c.C0130c) == false) goto L5;
        logPKWatchDuration("routine");
    L5:
        this.battleSettingCache = r7.a;
        i97.a r0 = i97.a.a;
        this.onShowPenalTime = System.currentTimeMillis();
        this.curPkStateInfo = r7;
        this.pkCompleteCount++;
        this.compatSkinConfig = r7.g;
        int r1 = 0;
        this.needShowLastBattleResult = false;
        if (this.curBattlePlayMode != null) goto L29;
        d21.d r2 = getMergePkHelper();
        if (r2 == null) goto L17;
        IBaseBattleSetting r3 = r7.a;
        if (r3 == null) goto L12;
        IBattleConfigSetting r4 = r3.getBattleConfigSetting();
    L13:
        PlayMode r5 = getCurrentPlayMode();
        if (r5 == null) goto L16;
        r1 = r5.toNetFormat();
    L16:
        c21.f r10 = d21.d.a(r2, r4, r1, ((Number) this.scene.invoke()).intValue());
    L18:
        setCurBattlePlayMode(r10);
        if ((this.curBattlePlayMode instanceof c21.f.b) == false) goto L29;
        IBaseBattleSetting r12 = r7.a;
        if (r12 == null) goto L27;
        IBattleConfigSetting r13 = r12.getBattleConfigSetting();
        if (r13 == null) goto L27;
        v0 r14 = r13.getCloudCollaborateConfig();
        if (r14 == null) goto L27;
        Integer r15 = Integer.valueOf(r14.getPanelType());
    L28:
        this.curCloudCollaboratePanelType = r15;
    L27:
        r15 = null;
        goto L28
    L12:
        r4 = null;
        goto L13
    L17:
        r10 = null;
    L29:
        jy0.b.d(LOG_TAG, "onShowPanel fromState " + r6 + " toState " + r9 + " source=" + r8 + " isOnceMore=" + this.isBaseOnceMoreBattle + " pkMode=" + getCurrentPlayMode());
        StringBuilder r16 = new StringBuilder("onShowPenal ");
        r16.append(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.c.a(r7));
        jy0.b.c("pk_biz_handler", r16.toString(), null, 4);
        Iterator<T> r17 = getBizHandlerList(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.c.a(r7)).iterator();
    L31:
        if (r17.hasNext() == false) goto L33;
        ((com.bytedance.android.live.revlink.impl.mergepk.pkbase.d) r17.next()).onBizPenal(r7, r8, r9);
        goto L31
    }

    public static final /* synthetic */ void access$onFinish(PkBaseDataContext r0, boolean r1, PkBaseStateMachine.c r2, PkBaseStateMachine.c r3, boolean r4) {
        r0.onFinish(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void access$onShowPK(PkBaseDataContext r0, com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r1, PkBaseStateMachine.c r2, PkBaseStateMachine.c r3, PkBaseStateMachine.Source r4) {
        r0.onShowPK(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void access$onShowPenal(PkBaseDataContext r0, PkBaseStateMachine.c r1, com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2, PkBaseStateMachine.Source r3, PkBaseStateMachine.c r4) {
        r0.onShowPenal(r1, r2, r3, r4);
    }

    public static /* synthetic */ void onFinish$default(PkBaseDataContext r2, boolean r3, PkBaseStateMachine.c r4, PkBaseStateMachine.c r5, boolean r6, int r7, Object r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = false;
    L14:
        r2.onFinish(r3, r4, r5, r6);
    }

    public PkBaseDataContext(Function0<Integer> r17, boolean r18, ld.a r19, wq2.f r20, com.bytedance.android.livesdk.revenue.service.room.c r22, com.bytedance.android.live.revlink.impl.global.c r23, yz0.f r24, x11.a r25, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r26) {
        Intrinsics.checkNotNullParameter(r17, "scene");
        Intrinsics.checkNotNullParameter(r26, "context");
        this.scene = r17;
        this.isAnchor = r18;
        this.linkDataSet = r19;
        this.dataCenterService = r20;
        this.roomService = r22;
        this.linkFakeGlobalService = r23;
        this.messageService = r24;
        this.internalLinkService = r25;
        this.context = r26;
        this.bizHandlerMap = new LinkedHashMap();
        LinkRevInternalServiceContext r0 = getLinkRevInternalServiceContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j<AnchorLinkUserCenterV2> r1 = r0.getLinkUserCenter();
        if (r1 == null) goto L7;
        AnchorLinkUserCenterV2 r2 = (AnchorLinkUserCenterV2) r1.getValue();
    L8:
        AnchorLinkUserCenterV2 r3 = r2;
        this.userCenter = r3;
        this.audioPunishUserIds = new ArrayList();
        PkStateMachineController r15 = new PkStateMachineController(r23, r3, r17, r18, getRoom(), r24);
        this.stateMachineController = r15;
        this.pkSideEffect = r15.b;
        this.baseScoreState = new MutableLiveData();
        this.pkBaseResult = new MutableLiveData();
        this.needShowLastResult = new MutableLiveData();
        this.lastBattleResultVisible = new MutableLiveData();
        this.teamMode = new MutableLiveData();
        MutableLiveData<PkBaseStateMachine.c> r4 = new MutableLiveData();
        this._pkState = r4;
        this.pkBaseState = r4;
        this.leftMvpRankList = new MutableLiveData();
        this.rightMvpRankList = new MutableLiveData();
        this.pkGuestListStr = new MutableLiveData();
        this.modeDataContext = new PkBaseModeDataContext(getPkSideEffect());
        this.resultDataContext = new PkBaseResultDataContext(new PkBaseDataContext$resultDataContext$1(this), getPkSideEffect(), r17, r22, r23);
        PkBaseScoreDataContext r6 = new PkBaseScoreDataContext(getPkSideEffect(), m587getBaseScoreState(), r19, r23, r24);
        this.scoreDataContext = r6;
        BaseBreakThroughDataContext r12 = new BaseBreakThroughDataContext(r6.getBattleScoreData(), r6.getBattleScoreUpdateByMsg(), new PkBaseDataContext$breakThroughDataContext$1(this), getPkSideEffect());
        this.breakThroughDataContext = r12;
        MutableLiveData<String> r7 = new MutableLiveData();
        this.propCardEffectInfo = r7;
        this.startSource = "";
        this.toBizTypeForMonitor = BizType.None.ordinal();
        this.eventTrackingInfo = "";
        this.extraResultAnim = new MutableLiveData();
        this.teamTaskLynxData = new MutableLiveData();
        this.showLastBattleResult = new MutableLiveData();
        androidx.lifecycle.Observer r5 = new c(this);
        this.sideEffectObserver = r5;
        d r8 = new d(this);
        this.timeObserver = r8;
        this.battleStatsMeta = new MutableLiveData();
        this.isFirstPk = true;
        this.commonLogger = new b21.c(this);
        int r9 = o.a;
        this.pkStartEvent = PublishSubject.create();
        CompositeDisposable r10 = new CompositeDisposable();
        this.cd = r10;
        this.pkSource = "";
        this.isFirstCreate = true;
        com.bytedance.revenue.platform.api.core.rx.f.a(getOnCleared().subscribe(new a(this)), r10);
        i97.a r13 = i97.a.a;
        this.startTimeMsField = System.currentTimeMillis();
        r15.b();
        Intrinsics.checkNotNullParameter(this, "cb");
        r15.d = this;
        if (r18 == false) goto L11;
        androidx.lifecycle.Observer r14 = r5;
        PkAnchorLauncher r16 = new PkAnchorLauncher(r17, getPkBaseState(), this, getRoom(), r22, r23, r24, r25);
        this.pkAnchorLauncher = r16;
        r16.u();
        CompositeDisposable r27 = r10;
    L12:
        getPkSideEffect().observeForever(r14);
        r12.attach();
        Function1<com.bytedance.android.live.revlink.link.biz.service.a, Unit> r28 = new AnonymousClass2(this);
        Intrinsics.checkNotNullParameter(this, "$this$anchor");
        Intrinsics.checkNotNullParameter(r28, "scope");
        com.bytedance.android.live.revlink.link.biz.service.f r29 = i.a(this);
        if (r29 == null) goto L17;
        r28.invoke(r29);
    L17:
        if (r24 == null) goto L23;
        com.bytedance.android.live.revenue.common.message.a r30 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r32 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r30, "$this$BATTLE_EFFECT_CONTAINER_MESSAGE");
        Observable r33 = yz0.h.a.a(r24, (yh6.b) CommonMessageTypeKt.q.getValue(), false, 6);
        if (r33 == null) goto L23;
        final AnonymousClass3 r34 = new AnonymousClass3(this);
        Disposable r35 = r33.subscribe(new e(r34));
        if (r35 == null) goto L23;
        com.bytedance.revenue.platform.api.core.rx.f.a(r35, r27);
    L23:
        if (r24 == null) goto L29;
        Observable r36 = yz0.h.a.a(r24, CommonMessageTypeKt.c(com.bytedance.android.live.revenue.common.message.a.g), false, 6);
        if (r36 == null) goto L29;
        final AnonymousClass4 r37 = new AnonymousClass4(this);
        Disposable r38 = r36.subscribe(new e(r37));
        if (r38 == null) goto L29;
        com.bytedance.revenue.platform.api.core.rx.f.a(r38, r27);
    L29:
        this.battleEffectInfo = r7;
        this.audioPunishInfo = new MutableLiveData();
        this.audioPunishRemainTime = new MutableLiveData();
        return;
    L11:
        r27 = r10;
        r14 = r5;
        this.pkAudienceRequest = new com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.j(r23, r17, getRoom(), this);
        getBaseTimeLeft().observeForever(r8);
    L7:
        r2 = null;
        goto L8
    }
}
