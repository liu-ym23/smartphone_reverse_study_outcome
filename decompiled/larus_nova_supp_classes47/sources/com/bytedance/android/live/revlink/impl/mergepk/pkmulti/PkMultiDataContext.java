package com.bytedance.android.live.revlink.impl.mergepk.pkmulti;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revenue.common.p0;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PKBizType;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkStateMachineController;
import com.bytedance.android.live.revlink.impl.multianchor.connect.RelinkDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.pk.datacontext.MultiCommonPkDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.multianchor.utils.z;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.impl.service.internal.LinkRevInternalServiceContext;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleToastMessage;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.ITeamTask;
import com.bytedance.android.livesdk.link.model.a1;
import com.bytedance.android.livesdk.link.model.a5;
import com.bytedance.android.livesdk.link.model.a6;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.b3;
import com.bytedance.android.livesdk.link.model.bridge.b0;
import com.bytedance.android.livesdk.link.model.bridge.d0;
import com.bytedance.android.livesdk.link.model.bridge.u0;
import com.bytedance.android.livesdk.link.model.c2;
import com.bytedance.android.livesdk.link.model.c5;
import com.bytedance.android.livesdk.link.model.f1;
import com.bytedance.android.livesdk.link.model.g5;
import com.bytedance.android.livesdk.link.model.g7;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.i9;
import com.bytedance.android.livesdk.link.model.o9;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.q;
import com.bytedance.android.livesdk.link.model.q9;
import com.bytedance.android.livesdk.link.model.r;
import com.bytedance.android.livesdk.link.model.s5;
import com.bytedance.android.livesdk.link.model.u1;
import com.bytedance.android.livesdk.link.model.v2;
import com.bytedance.android.livesdk.link.model.y4;
import com.bytedance.android.livesdk.message.model.qj;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.scope.m;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.k;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.revenue.platform.api.core.rx.l;
import cy0.j;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kc0.n;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.LongRange;
import kotlin.reflect.KProperty;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import mz0.i;
import org.json.JSONObject;
import w20.v9;
import yz0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000¦\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002¼\u0001\u0018\u0000 \u00ad\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002®\u0002B \u0001\u0012\n\u0010Ç\u0001\u001a\u0005\u0018\u00010Æ\u0001\u0012\n\u0010Ê\u0001\u001a\u0005\u0018\u00010É\u0001\u0012\n\u0010Í\u0001\u001a\u0005\u0018\u00010Ì\u0001\u0012\n\u0010¡\u0002\u001a\u0005\u0018\u00010 \u0002\u0012\n\u0010£\u0002\u001a\u0005\u0018\u00010¢\u0002\u0012\n\u0010Ð\u0001\u001a\u0005\u0018\u00010Ï\u0001\u0012\n\u0010Ó\u0001\u001a\u0005\u0018\u00010Ò\u0001\u0012\n\u0010¥\u0002\u001a\u0005\u0018\u00010¤\u0002\u0012\n\u0010§\u0002\u001a\u0005\u0018\u00010¦\u0002\u0012\b\u0010©\u0002\u001a\u00030¨\u0002\u0012\u000b\b\u0002\u0010ª\u0002\u001a\u0004\u0018\u00010b\u0012\u0012\b\u0002\u0010Ö\u0001\u001a\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010Õ\u0001¢\u0006\u0006\b«\u0002\u0010¬\u0002J\u0018\u0010\n\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0002J\u001e\u0010\u000f\u001a\u00020\t2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bH\u0002J:\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0011`\u00122\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\tH\u0002J\u0006\u0010\u001b\u001a\u00020\tJ\u0006\u0010\u001c\u001a\u00020\tJ\"\u0010\u001f\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0016J$\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0011`\u0012H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010(\u001a\u00020\t2\u0006\u0010%\u001a\u00020'H\u0016J\u0010\u0010*\u001a\u00020\t2\u0006\u0010%\u001a\u00020)H\u0016J\u001a\u0010.\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010-\u001a\u00020!H\u0016J\u0010\u00101\u001a\u00020\t2\u0006\u00100\u001a\u00020/H\u0016J\b\u00102\u001a\u00020\tH\u0016J$\u00105\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f03j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`4H\u0016J\u0010\u00108\u001a\u00020\t2\u0006\u00107\u001a\u000206H\u0016J\u0010\u00109\u001a\u00020\t2\u0006\u00107\u001a\u000206H\u0016J\b\u0010:\u001a\u00020!H\u0016J:\u0010A\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020;2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010>\u001a\u00020!2\b\u0010@\u001a\u0004\u0018\u00010?H\u0016J \u0010B\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010=\u001a\u00020;H\u0016J,\u0010E\u001a\u00020\t2\u0006\u0010C\u001a\u00020!2\b\u0010<\u001a\u0004\u0018\u00010;2\b\u0010=\u001a\u0004\u0018\u00010;2\u0006\u0010D\u001a\u00020!H\u0016J$\u0010K\u001a\u00020\t2\u0006\u0010F\u001a\u00020\u00152\b\u0010H\u001a\u0004\u0018\u00010G2\b\u0010J\u001a\u0004\u0018\u00010IH\u0016J\b\u0010L\u001a\u00020\u0011H\u0016J\b\u0010M\u001a\u00020\tH\u0016J \u0010P\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0O\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0O0NH\u0016J \u0010Q\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0O\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0O0NH\u0016J\u0010\u0010T\u001a\u00020\t2\u0006\u0010S\u001a\u00020RH\u0016J\n\u0010U\u001a\u0004\u0018\u00010RH\u0016J\u0014\u0010Y\u001a\u00020\t2\n\u0010X\u001a\u00060Vj\u0002`WH\u0016J\u0012\u0010]\u001a\u00020\t2\n\u0010\\\u001a\u00060Zj\u0002`[R\u0018\u0010`\u001a\u00060^j\u0002`_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0017\u0010c\u001a\u00020b8\u0006¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u001c\u0010h\u001a\u0004\u0018\u00010g8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR6\u0010o\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020m0O0lj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020m0O`n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010rR*\u0010v\u001a\u0012\u0012\u0004\u0012\u00020t0sj\b\u0012\u0004\u0012\u00020t`u8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010yR%\u0010{\u001a\u0004\u0018\u00010z8\u0016@\u0016X\u0096\u000e¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R5\u0010\u0081\u0001\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0011`\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0019\u0010\u0083\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0019\u0010\u0085\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0084\u0001R\u001e\u0010\u0087\u0001\u001a\t\u0012\u0004\u0012\u0002060\u0086\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R&\u0010>\u001a\u00020!8\u0016@\u0016X\u0096\u000e¢\u0006\u0016\n\u0005\b>\u0010\u0084\u0001\u001a\u0005\b>\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R-\u0010\u008c\u0001\u001a\u0012\u0012\u0004\u0012\u00020!0sj\b\u0012\u0004\u0012\u00020!`u8\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b\u008c\u0001\u0010w\u001a\u0005\b\u008d\u0001\u0010yR-\u0010\u008e\u0001\u001a\u0012\u0012\u0004\u0012\u00020!0sj\b\u0012\u0004\u0012\u00020!`u8\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b\u008e\u0001\u0010w\u001a\u0005\b\u008f\u0001\u0010yR1\u0010\u0092\u0001\u001a\u0014\u0012\u0004\u0012\u00020!0\u0090\u0001j\t\u0012\u0004\u0012\u00020!`\u0091\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R*\u0010\u0097\u0001\u001a\u00030\u0096\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u0097\u0001\u0010\u0098\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R)\u0010\u009d\u0001\u001a\u00020\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R\u0019\u0010£\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010\u009e\u0001R)\u0010¤\u0001\u001a\u00020!8\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b¤\u0001\u0010\u0084\u0001\u001a\u0006\b¤\u0001\u0010\u0089\u0001\"\u0006\b¥\u0001\u0010\u008b\u0001R)\u0010¦\u0001\u001a\u00020!8\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b¦\u0001\u0010\u0084\u0001\u001a\u0006\b¦\u0001\u0010\u0089\u0001\"\u0006\b§\u0001\u0010\u008b\u0001R-\u0010¨\u0001\u001a\u0012\u0012\u0004\u0012\u00020!0sj\b\u0012\u0004\u0012\u00020!`u8\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b¨\u0001\u0010w\u001a\u0005\b©\u0001\u0010yR\u001b\u0010ª\u0001\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R\u0018\u0010\u00ad\u0001\u001a\u00030¬\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R \u0010°\u0001\u001a\u00030¯\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b°\u0001\u0010±\u0001\u001a\u0006\b²\u0001\u0010³\u0001R-\u0010´\u0001\u001a\u0012\u0012\u0004\u0012\u00020\f0sj\b\u0012\u0004\u0012\u00020\f`u8\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b´\u0001\u0010w\u001a\u0005\bµ\u0001\u0010yR\u001c\u0010·\u0001\u001a\u0005\u0018\u00010¶\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R)\u0010¹\u0001\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¹\u0001\u0010\u0084\u0001\u001a\u0006\bº\u0001\u0010\u0089\u0001\"\u0006\b»\u0001\u0010\u008b\u0001R\u0018\u0010½\u0001\u001a\u00030¼\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001RN\u0010À\u0001\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020Z\u0018\u00010\u000b2\u0015\u0010¿\u0001\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020Z\u0018\u00010\u000b8\u0016@VX\u0096\u000e¢\u0006\u0018\n\u0006\bÀ\u0001\u0010Á\u0001\u001a\u0006\bÂ\u0001\u0010Ã\u0001\"\u0006\bÄ\u0001\u0010Å\u0001R\u001a\u0010Ç\u0001\u001a\u0005\u0018\u00010Æ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u001a\u0010Ê\u0001\u001a\u0005\u0018\u00010É\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u001a\u0010Í\u0001\u001a\u0005\u0018\u00010Ì\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÍ\u0001\u0010Î\u0001R\u001a\u0010Ð\u0001\u001a\u0005\u0018\u00010Ï\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÐ\u0001\u0010Ñ\u0001R\u001a\u0010Ó\u0001\u001a\u0005\u0018\u00010Ò\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÓ\u0001\u0010Ô\u0001R \u0010Ö\u0001\u001a\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010Õ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R\u0017\u0010Ø\u0001\u001a\u00020!8BX\u0082\u0004¢\u0006\b\u001a\u0006\bØ\u0001\u0010\u0089\u0001R\u001a\u0010Ü\u0001\u001a\u0005\u0018\u00010Ù\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bÚ\u0001\u0010Û\u0001R\u001a\u0010à\u0001\u001a\u0005\u0018\u00010Ý\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bÞ\u0001\u0010ß\u0001R\u0019\u0010ã\u0001\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\b\u001a\u0006\bá\u0001\u0010â\u0001R\u001a\u0010ç\u0001\u001a\u0005\u0018\u00010ä\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bå\u0001\u0010æ\u0001R\u001a\u0010ë\u0001\u001a\u0005\u0018\u00010è\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bé\u0001\u0010ê\u0001R\u001a\u0010ï\u0001\u001a\u0005\u0018\u00010ì\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bí\u0001\u0010î\u0001R\u001a\u0010ó\u0001\u001a\u0005\u0018\u00010ð\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bñ\u0001\u0010ò\u0001R\u001a\u0010÷\u0001\u001a\u0005\u0018\u00010ô\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bõ\u0001\u0010ö\u0001R\u001a\u0010û\u0001\u001a\u0005\u0018\u00010ø\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bù\u0001\u0010ú\u0001R\u001a\u0010ÿ\u0001\u001a\u0005\u0018\u00010ü\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bý\u0001\u0010þ\u0001R\u001a\u0010\u0083\u0002\u001a\u0005\u0018\u00010\u0080\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0081\u0002\u0010\u0082\u0002R\u001a\u0010\u0087\u0002\u001a\u0005\u0018\u00010\u0084\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0085\u0002\u0010\u0086\u0002R\u001a\u0010\u008b\u0002\u001a\u0005\u0018\u00010\u0088\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002R\u001a\u0010\u008f\u0002\u001a\u0005\u0018\u00010\u008c\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008d\u0002\u0010\u008e\u0002R\u001a\u0010\u0093\u0002\u001a\u0005\u0018\u00010\u0090\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0091\u0002\u0010\u0092\u0002R\u0014\u0010\u0096\u0002\u001a\u00020;8F¢\u0006\b\u001a\u0006\b\u0094\u0002\u0010\u0095\u0002R\u0017\u0010\u0099\u0002\u001a\u00020\u00118VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0097\u0002\u0010\u0098\u0002R\u0017\u0010\u009d\u0002\u001a\u0005\u0018\u00010\u009a\u00028F¢\u0006\b\u001a\u0006\b\u009b\u0002\u0010\u009c\u0002R\u0017\u0010\u009f\u0002\u001a\u00020\f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009e\u0002\u0010 \u0001¨\u0006¯\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkmulti/PkMultiDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/d;", "Lp11/g;", "Lkc0/n;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkmulti/b;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "", "onMessage", "", "", "Lcom/bytedance/android/livesdk/link/model/IBattleUserInfo;", "battleUserInfoMap", "updateBattleUserRoleMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "createBattleRoleMap", "resetBattle", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$Source;", "source", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/a;", "pkInfo", "updateTeamInfo", "resetBgImage", "attach", "detach", "anchorId", "secAnchorId", "launchVoteRulePage", "getUserRoleMap", "", "isMultiBreakThrough", "isVotePk", "Lcom/bytedance/android/livesdk/link/model/a5;", "message", "onBizReceiveBattleFinishMsg", "Lcom/bytedance/android/livesdk/link/model/y4;", "onBizReceiveBattleEndPunishMsg", "Lcom/bytedance/android/livesdk/link/model/c5;", "onBizReceiveBattleMsg", "Lcom/bytedance/android/livesdk/link/model/r;", "anchorLinkList", "forceUpdate", "notifyPkContext", "Lcom/bytedance/android/livesdk/link/model/z;", "audioPunishInfo", "updateAudioPunishInfo", "reCreatePkStartParam", "", "Lcom/bytedance/revenue/platform/api/core/KmpMutableMap;", "getCurrentSceneLogParam", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkmulti/d;", "interceptor", "addRankUpdateInterceptor", "removeRankUpdateInterceptor", "isMultiPk", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;", "fromState", "toState", "isOnceMore", "Lcom/bytedance/android/live/revlink/impl/multianchor/constants/PlayMode;", "playMode", "onBizPK", "onBizPenal", "skippedPenal", "isRealPkFinish", "onBizFinished", "stateSource", "Lcom/bytedance/android/livesdk/link/model/f1;", Constants.Keys.DATA, "", "throwable", "onBizFinishCallback", "getPkUserCnt", "requestUpdateRank", "Lkotlin/Pair;", "", "getTeamPkUids", "getTeamPkUids4Finish", "Lw20/v9;", "params", "handleBattleBgImage", "getBattleBgImage", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "leaveUser", "handleUserLeave", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/RoomId;", "roomId", "sharedWithRoomId", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/PkBaseDataContext;", "basePKContext", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/PkBaseDataContext;", "getBasePKContext", "()Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/PkBaseDataContext;", "Lcom/bytedance/android/live/revlink/impl/plantform/AnchorLinkUserCenterV2;", "userCenter", "Lcom/bytedance/android/live/revlink/impl/plantform/AnchorLinkUserCenterV2;", "getUserCenter", "()Lcom/bytedance/android/live/revlink/impl/plantform/AnchorLinkUserCenterV2;", "Landroidx/lifecycle/LiveData;", "Laf2/b;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/LiveData;", "scoreState", "Landroidx/lifecycle/LiveData;", "getScoreState", "()Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/MutableLiveData;", "Li31/b;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/MutableLiveData;", "multiPkFinishEvent", "Landroidx/lifecycle/MutableLiveData;", "getMultiPkFinishEvent", "()Landroidx/lifecycle/MutableLiveData;", "Li31/a;", "pkBeforeFinishData", "Li31/a;", "getPkBeforeFinishData", "()Li31/a;", "setPkBeforeFinishData", "(Li31/a;)V", "battleUserRoleMap", "Ljava/util/HashMap;", "isRankUpdating", "Z", "needUpdateRank", "", "onRankUpdateInterceptors", "Ljava/util/List;", "()Z", "setOnceMore", "(Z)V", "showExtraResultAnim", "getShowExtraResultAnim", "lastBattleResultVisible", "getLastBattleResultVisible", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Lcom/bytedance/android/live/revenue/common/NextLiveData;", "teamTaskLayoutFocused", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getTeamTaskLayoutFocused", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Lj31/a;", "pkStartParam", "Lj31/a;", "getPkStartParam", "()Lj31/a;", "setPkStartParam", "(Lj31/a;)V", "teamType", "Ljava/lang/String;", "getTeamType", "()Ljava/lang/String;", "setTeamType", "(Ljava/lang/String;)V", "curInviteMode", "isPkLauncher", "setPkLauncher", "isAnchorLinkFinisher", "setAnchorLinkFinisher", "showLastBattleResult", "getShowLastBattleResult", "battleBgParams", "Lw20/v9;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkmulti/a;", "extraPlayManager", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkmulti/a;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/b;", "extraPlayContextManager", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/b;", "getExtraPlayContextManager", "()Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/b;", "battlePowerInfo", "getBattlePowerInfo", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/a;", "anchorAudioPunishManager", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/a;", "enterShowLastResult", "getEnterShowLastResult", "setEnterShowLastResult", "com/bytedance/android/live/revlink/impl/mergepk/pkmulti/PkMultiDataContext$c", "callback", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkmulti/PkMultiDataContext$c;", "value", "userIdToTeamId", "Ljava/util/Map;", "getUserIdToTeamId", "()Ljava/util/Map;", "setUserIdToTeamId", "(Ljava/util/Map;)V", "Lcom/bytedance/android/livesdk/revenue/room/a;", "roomContext", "Lcom/bytedance/android/livesdk/revenue/room/a;", "Lcom/bytedance/android/live/revlink/impl/control/launchcontext/b;", "launchContext", "Lcom/bytedance/android/live/revlink/impl/control/launchcontext/b;", "Lld/a;", "linkDataSet", "Lld/a;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lyz0/f;", "messageService", "Lyz0/f;", "Lkotlin/Function0;", "requestBgRefresh", "Lkotlin/jvm/functions/Function0;", "isAnchor", "Lcom/bytedance/android/live/revlink/impl/service/internal/LinkRevInternalServiceContext;", "getLinkRevInternalServiceContext", "()Lcom/bytedance/android/live/revlink/impl/service/internal/LinkRevInternalServiceContext;", "linkRevInternalServiceContext", "Lcom/bytedance/android/live/revlink/impl/multianchor/connect/RelinkDataContext;", "getRelinkDataContext", "()Lcom/bytedance/android/live/revlink/impl/multianchor/connect/RelinkDataContext;", "relinkDataContext", "getMultiPkService", "()Lcom/bytedance/android/live/revlink/impl/mergepk/pkmulti/b;", "multiPkService", "Lcom/bytedance/android/live/revlink/impl/multianchor/vm/b;", "getMultiAnchorLinkContext", "()Lcom/bytedance/android/live/revlink/impl/multianchor/vm/b;", "multiAnchorLinkContext", "Lcom/bytedance/android/live/revlink/impl/multianchor/utils/z;", "getMultiPkMonitor", "()Lcom/bytedance/android/live/revlink/impl/multianchor/utils/z;", "multiPkMonitor", "Lh41/f;", "getPkSwitchLogger", "()Lh41/f;", "pkSwitchLogger", "Lcom/bytedance/android/live/revlink/impl/multianchor/vm/g;", "getMultiAnchorLinkContextObj", "()Lcom/bytedance/android/live/revlink/impl/multianchor/vm/g;", "multiAnchorLinkContextObj", "Lcom/bytedance/android/live/revlink/impl/multianchor/utils/q;", "getMultiAnchorLinkLogUtils", "()Lcom/bytedance/android/live/revlink/impl/multianchor/utils/q;", "multiAnchorLinkLogUtils", "Ld31/d;", "getRevLinkLogHelper", "()Ld31/d;", "revLinkLogHelper", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/e;", "getLinkOptLogContext", "()Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/e;", "linkOptLogContext", "Ln21/a;", "getMultiAnchorLinkCommonService", "()Ln21/a;", "multiAnchorLinkCommonService", "Lcom/bytedance/android/live/revlink/impl/multianchor/utils/w;", "getMultiLinkUtil", "()Lcom/bytedance/android/live/revlink/impl/multianchor/utils/w;", "multiLinkUtil", "Lcom/bytedance/android/live/revlink/impl/multianchor/pk/datacontext/MultiCommonPkDataContext;", "getMultiCommonPkDataContext", "()Lcom/bytedance/android/live/revlink/impl/multianchor/pk/datacontext/MultiCommonPkDataContext;", "multiCommonPkDataContext", "La21/a;", "getPkBaseLogger", "()La21/a;", "pkBaseLogger", "Lcom/bytedance/android/live/revlink/impl/utils/s;", "getRevLinkCommonUtil", "()Lcom/bytedance/android/live/revlink/impl/utils/s;", "revLinkCommonUtil", "getCurPKBaseState", "()Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;", "curPKBaseState", "getCurrentPkMode", "()I", "currentPkMode", "Lf21/a;", "getConnectionContext", "()Lf21/a;", "connectionContext", "getInviteModeStatus", "inviteModeStatus", "Lwq2/f;", "dataCenterService", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "roomService", "Lcom/bytedance/android/livesdk/revenue/service/message/d;", "messageManagerService", "Lx11/a;", "internalLinkService", "Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/d;", "context", "extraPkContext", "<init>", "(Lcom/bytedance/android/livesdk/revenue/room/a;Lcom/bytedance/android/live/revlink/impl/control/launchcontext/b;Lld/a;Lwq2/f;Lcom/bytedance/android/livesdk/revenue/service/room/c;Lcom/bytedance/android/live/revlink/impl/global/c;Lyz0/f;Lcom/bytedance/android/livesdk/revenue/service/message/d;Lx11/a;Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/d;Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/PkBaseDataContext;Lkotlin/jvm/functions/Function0;)V", "Companion", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkMultiDataContext extends DataContext implements com.bytedance.android.live.revlink.impl.mergepk.pkbase.d, p11.g, n, com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b {
    public static final a Companion = null;
    public static final String TAG = "PkMultiDataContext";
    public static final int VOTE_INTERCEPT_CAUSE_EXIST_UN_SUPPORT_ANCHOR = 4017173;
    private com.bytedance.android.live.revlink.impl.mergepk.pkbase.a anchorAudioPunishManager;
    private final PkBaseDataContext basePKContext;
    private v9 battleBgParams;
    private final MutableLiveData<String> battlePowerInfo;
    private HashMap<String, Integer> battleUserRoleMap;
    private final c callback;
    private final CompositeDisposable cd;
    private String curInviteMode;
    private boolean enterShowLastResult;
    private final com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.b extraPlayContextManager;
    private final com.bytedance.android.live.revlink.impl.mergepk.pkmulti.a extraPlayManager;
    private boolean isAnchorLinkFinisher;
    private boolean isOnceMore;
    private boolean isPkLauncher;
    private boolean isRankUpdating;
    private final MutableLiveData<Boolean> lastBattleResultVisible;
    private final com.bytedance.android.live.revlink.impl.control.launchcontext.b launchContext;
    private final ld.a linkDataSet;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private final yz0.f messageService;
    private final MutableLiveData<i31.b> multiPkFinishEvent;
    private boolean needUpdateRank;
    private final List<com.bytedance.android.live.revlink.impl.mergepk.pkmulti.d> onRankUpdateInterceptors;
    private i31.a pkBeforeFinishData;
    private j31.a pkStartParam;
    private final Function0<Unit> requestBgRefresh;
    private final com.bytedance.android.livesdk.revenue.room.a roomContext;
    private final LiveData<List<af2.b>> scoreState;
    private final MutableLiveData<Boolean> showExtraResultAnim;
    private final MutableLiveData<Boolean> showLastBattleResult;
    private final NextLiveData<Boolean> teamTaskLayoutFocused;
    private String teamType;
    private final AnchorLinkUserCenterV2 userCenter;
    private Map<String, Long> userIdToTeamId;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PkMultiDataContext a;

        public b(PkMultiDataContext r1) {
            this.a = r1;
        }

        public final void accept(Object r23) {
            o9 r0 = (o9) r23;
            PkStateMachineController r1 = this.a.getBasePKContext().getStateMachineController();
            PkBaseStateMachine.c r2 = r1.f();
            r2.getClass();
            if ((r2 instanceof PkBaseStateMachine.c.d) == false) goto L6;
            jy0.b.f("ttlive_PkStateMachine", "relink success in penal, unload pk to link", null, 4);
            r1.j.a(new PkBaseStateMachine.a.c(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a(null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 32767), PkBaseStateMachine.Source.RelinkSuccess));
            return;
        }
    }

    public static final class c extends i11.c.a {
        public final /* synthetic */ PkMultiDataContext a;

        public c(PkMultiDataContext r1) {
            this.a = r1;
        }

        @Override // i11.c.a, i11.c.b
        public final void d(int r3, List<? extends p> r4) {
            Intrinsics.checkNotNullParameter(r4, "list");
            Intrinsics.checkNotNullParameter(r4, "list");
            PkMultiDataContext.access$getBattleUserRoleMap$p(this.a).clear();
            Iterator r5 = ((CopyOnWriteArrayList) r4).iterator();
        L4:
            if (r5.hasNext() == false) goto L10;
            p r6 = (p) r5.next();
            IBaseUser r0 = r6.getUser();
            if (r0 == null) goto L4;
            String r1 = r0.getIdString();
            if (r1 == null) goto L4;
            PkMultiDataContext.access$getBattleUserRoleMap$p(this.a).put(r1, Integer.valueOf(q.d(r6)));
            goto L4
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ PkMultiDataContext a;

        public d(PkMultiDataContext r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            PkMultiDataContext.access$setRankUpdating$p(this.a, false);
            if (PkMultiDataContext.access$getNeedUpdateRank$p(this.a) == false) goto L6;
            this.a.requestUpdateRank();
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.d
    public void onBizFinishCallback(PkBaseStateMachine.Source r1, f1 r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "stateSource");
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.d
    public void onBizReceiveBattleEndPunishMsg(y4 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.d
    public void onBizReceiveBattleMsg(c5 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    private final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e getLinkOptLogContext() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkOptLogContext();
    }

    private final LinkRevInternalServiceContext getLinkRevInternalServiceContext() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Cj();
    }

    private final n21.a getMultiAnchorLinkCommonService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.ll();
    }

    private final com.bytedance.android.live.revlink.impl.multianchor.vm.b getMultiAnchorLinkContext() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.rb();
    }

    private final com.bytedance.android.live.revlink.impl.multianchor.vm.g getMultiAnchorLinkContextObj() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiAnchorLinkContextObj();
    }

    private final com.bytedance.android.live.revlink.impl.multianchor.utils.q getMultiAnchorLinkLogUtils() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiAnchorLinkLogUtils();
    }

    private final MultiCommonPkDataContext getMultiCommonPkDataContext() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.uk();
    }

    private final w getMultiLinkUtil() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiLinkUtil();
    }

    private final z getMultiPkMonitor() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiPkMonitor();
    }

    private final com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b getMultiPkService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Q1();
    }

    private final a21.a getPkBaseLogger() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkBaseLogger();
    }

    private final h41.f getPkSwitchLogger() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkSwitchLogger();
    }

    private final RelinkDataContext getRelinkDataContext() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.ih();
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

    private final void resetBattle() {
        jy0.b.c("ttlive_anchor_link_multi_pk", "resetBattle, currentPkState=" + getCurPKBaseState().c, null, 4);
        this.battleUserRoleMap.clear();
        m613getBattlePowerInfo().setValue("");
    }

    public final void attach() {
        yz0.f r0 = this.messageService;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revenue.common.message.a r1 = com.bytedance.android.live.revenue.common.message.a.g;
        Observable r2 = h.a.a(r0, CommonMessageTypeKt.c(r1), false, 6);
        final PkMultiDataContext$attach$1$1 r5 = new PkMultiDataContext$attach$1$1(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r2.subscribe(new e(r5)), this.cd);
        Intrinsics.checkNotNullParameter(r1, "$this$BATTLE_TOAST_MESSAGE");
        Observable r3 = h.a.a(r0, (yh6.b) CommonMessageTypeKt.p.getValue(), false, 6);
        final PkMultiDataContext$attach$1$2 r6 = new PkMultiDataContext$attach$1$2(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r3.subscribe(new e(r6)), this.cd);
        Intrinsics.checkNotNullParameter(r1, "$this$BATTLE_POWER_CONTAINER_MESSAGE");
        Observable r4 = h.a.a(r0, (yh6.b) CommonMessageTypeKt.o.getValue(), false, 6);
        final PkMultiDataContext$attach$1$3 r7 = new PkMultiDataContext$attach$1$3(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r4.subscribe(new e(r7)), this.cd);
        Observable r8 = h.a.a(r0, com.bytedance.android.live.revenue.common.message.a.f, false, 6);
        final PkMultiDataContext$attach$1$4 r9 = new PkMultiDataContext$attach$1$4(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r8.subscribe(new e(r9)), this.cd);
    L5:
        AnchorLinkUserCenterV2 r10 = this.userCenter;
        if (r10 == null) goto L8;
        r10.i(this.callback);
    L8:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.b r12 = getExtraPlayContextManager();
        PkBaseDataContext r13 = this.basePKContext;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "pkBaseService");
        Intrinsics.checkNotNullParameter(this, "multiPkService");
        r12.a = r13;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.a r14 = this.extraPlayManager;
        r14.getClass();
        Intrinsics.checkNotNullParameter(this, "multiPkService");
        r14.a = true;
        com.bytedance.android.live.revlink.impl.control.launchcontext.b r15 = this.launchContext;
        if (r15 == null) goto L17;
        a6 r16 = r15.d;
        if (r16 == null) goto L17;
        if (r16.getBattleDisplayEntrance() != true) goto L17;
        d51.c r17 = d51.c.A0;
        r17.getClass();
        if (((Boolean) d51.c.e0.getValue(r17, d51.c.a[55])).booleanValue() == false) goto L17;
        m617getShowLastBattleResult().setValue(Boolean.TRUE);
        this.enterShowLastResult = true;
    L17:
        RelinkDataContext r18 = getRelinkDataContext();
        if (r18 == null) goto L27;
        k<o9> r19 = r18.getRelinkSwitchSuccess();
        if (r19 == null) goto L28;
        PublishSubject r20 = r19.onEvent();
        if (r20 == null) goto L29;
        Disposable r22 = r20.subscribe(new b(this));
        if (r22 == null) goto L30;
        com.bytedance.revenue.platform.api.core.rx.f.a(r22, this.cd);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    }

    public final void detach() {
        AnchorLinkUserCenterV2 r0 = this.userCenter;
        if (r0 == null) goto L5;
        r0.l(this.callback);
    L5:
        getExtraPlayContextManager().a = null;
        this.cd.dispose();
        this.extraPlayManager.a = false;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.a r1 = this.anchorAudioPunishManager;
        if (r1 == null) goto L9;
        r1.detach();
        return;
    }

    public final PkBaseStateMachine.c getCurPKBaseState() {
        return this.basePKContext.getCurPKBaseState();
    }

    public int getCurrentPkMode() {
        PlayMode r0 = (PlayMode) this.basePKContext.m596getTeamMode().getValue();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.toJsbPkMode();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public int getPkUserCnt() {
        Iterator<String> r0 = this.battleUserRoleMap.keySet().iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L17;
        String r3 = r0.next();
        int r4 = h21.a.a;
        Integer r5 = this.battleUserRoleMap.get(r3);
        if (r5 != null) goto L8;
        r5 = 0;
    L8:
        int r6 = r5.intValue();
        if (r6 != 3) goto L11;
    L14:
        boolean r7 = true;
    L15:
        if (r7 == true) goto L4;
        r2 = r2 + 1;
        goto L4
    L11:
        if (r6 == 4) goto L14;
        r7 = false;
        goto L15
    L17:
        return r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public Pair<List<String>, List<String>> getTeamPkUids() {
        if (((PlayMode) this.basePKContext.m596getTeamMode().getValue()) != PlayMode.TEAM_PK) goto L14;
        int r0 = com.bytedance.android.live.revlink.impl.multianchor.pk.c.a;
        s r1 = getRevLinkCommonUtil();
        if (r1 == null) goto L7;
        String r2 = r1.c();
    L8:
        Map<String, Long> r3 = getUserIdToTeamId();
        if (r3 != null) goto L12;
        r3 = MapsKt.emptyMap();
    L12:
        return com.bytedance.android.live.revlink.impl.multianchor.pk.c.a(r2, r3);
    L7:
        r2 = null;
        goto L8
    L14:
        return TuplesKt.to(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public Pair<List<String>, List<String>> getTeamPkUids4Finish() {
        int r0 = com.bytedance.android.live.revlink.impl.multianchor.pk.c.a;
        s r1 = getRevLinkCommonUtil();
        if (r1 == null) goto L5;
        String r2 = r1.c();
    L6:
        Map<String, Long> r3 = getUserIdToTeamId();
        if (r3 != null) goto L10;
        r3 = MapsKt.emptyMap();
    L10:
        return com.bytedance.android.live.revlink.impl.multianchor.pk.c.a(r2, r3);
    L5:
        r2 = null;
        goto L6
    }

    public boolean isMultiBreakThrough() {
        return this.basePKContext.isInBreakThrough();
    }

    @Override // p11.g
    public boolean isMultiPk() {
        return this.basePKContext.isBattleShow();
    }

    public boolean isVotePk() {
        return this.basePKContext.isInVote();
    }

    public void reCreatePkStartParam() {
        setPkStartParam(new j31.a(this.linkFakeGlobalService));
    }

    public void requestUpdateRank() {
        if (this.isRankUpdating == false) goto L6;
        this.needUpdateRank = true;
        return;
    L6:
        List r0 = (List) getScoreState().getValue();
        if (r0 == null) goto L9;
        g r2 = new g(r0);
    L10:
        if (r2 == null) goto L16;
        Iterator<com.bytedance.android.live.revlink.impl.mergepk.pkmulti.d> r1 = this.onRankUpdateInterceptors.iterator();
    L13:
        if (r1.hasNext() == false) goto L16;
        r1.next().a();
    L16:
        if (r2 == null) goto L18;
        long r5 = r2.b;
    L20:
        if (r5 != 0) goto L23;
        this.isRankUpdating = false;
        this.needUpdateRank = false;
        return;
    L23:
        l r3 = l.a;
        int r4 = com.bytedance.revenue.platform.api.core.rx.p.a;
        this.cd.add(Observable.timer(r5, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this)));
        this.isRankUpdating = true;
        this.needUpdateRank = false;
        return;
    L18:
        r5 = 0;
        goto L20
    L9:
        r2 = null;
        goto L10
    }

    private final void resetBgImage() {
        if (isAnchor() == false) goto L7;
        Function0<Unit> r0 = this.requestBgRefresh;
        if (r0 == null) goto L13;
        Unit r1 = (Unit) r0.invoke();
        return;
    L13:
        return;
    L7:
        ld.a r2 = this.linkDataSet;
        if (r2 == null) goto L15;
        NextLiveData r3 = r2.Ed();
        if (r3 == null) goto L16;
        d51.c r4 = d51.c.A0;
        r3.setValue(new oq2.a(r4.k(), r4.j(), false));
        return;
    L16:
        return;
    }

    public /* bridge */ /* synthetic */ LiveData getBattlePowerInfo() {
        return m613getBattlePowerInfo();
    }

    public final f21.a getConnectionContext() {
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r0 = getMultiAnchorLinkContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<? extends f21.a> r1 = r0.getConnectionContext();
        if (r1 == null) goto L7;
        return (f21.a) r1.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public Map<String, String> getCurrentSceneLogParam() {
        MultiCommonPkDataContext r0 = getMultiCommonPkDataContext();
        if (r0 != null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r1 = getMultiAnchorLinkContext();
        if (r1 == null) goto L13;
        p21.c r2 = r1.getMultiLinkLogger();
        if (r2 == null) goto L13;
        return r2.a();
    L13:
        return new LinkedHashMap();
    L5:
        return r0.getPlayPkLogParam();
    }

    /* JADX INFO: renamed from: getExtraPlayContextManager, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.c m614getExtraPlayContextManager() {
        return getExtraPlayContextManager();
    }

    public /* bridge */ /* synthetic */ LiveData getMultiPkFinishEvent() {
        return m615getMultiPkFinishEvent();
    }

    public /* bridge */ /* synthetic */ LiveData getShowExtraResultAnim() {
        return m616getShowExtraResultAnim();
    }

    public /* bridge */ /* synthetic */ LiveData getShowLastBattleResult() {
        return m617getShowLastBattleResult();
    }

    public final PkBaseDataContext getBasePKContext() {
        return this.basePKContext;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public v9 getBattleBgImage() {
        return this.battleBgParams;
    }

    public final boolean getEnterShowLastResult() {
        return this.enterShowLastResult;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public String getInviteModeStatus() {
        return this.curInviteMode;
    }

    public MutableLiveData<Boolean> getLastBattleResultVisible() {
        return this.lastBattleResultVisible;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public i31.a getPkBeforeFinishData() {
        return this.pkBeforeFinishData;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public j31.a getPkStartParam() {
        return this.pkStartParam;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public LiveData<List<af2.b>> getScoreState() {
        return this.scoreState;
    }

    public NextLiveData<Boolean> getTeamTaskLayoutFocused() {
        return this.teamTaskLayoutFocused;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public String getTeamType() {
        return this.teamType;
    }

    public final AnchorLinkUserCenterV2 getUserCenter() {
        return this.userCenter;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public Map<String, Long> getUserIdToTeamId() {
        return this.userIdToTeamId;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public HashMap<String, Integer> getUserRoleMap() {
        return this.battleUserRoleMap;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public boolean isAnchorLinkFinisher() {
        return this.isAnchorLinkFinisher;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public boolean isOnceMore() {
        return this.isOnceMore;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public boolean isPkLauncher() {
        return this.isPkLauncher;
    }

    /* JADX INFO: renamed from: getBattlePowerInfo, reason: collision with other method in class */
    public MutableLiveData<String> m613getBattlePowerInfo() {
        return this.battlePowerInfo;
    }

    public com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.b getExtraPlayContextManager() {
        return this.extraPlayContextManager;
    }

    /* JADX INFO: renamed from: getMultiPkFinishEvent, reason: collision with other method in class */
    public MutableLiveData<i31.b> m615getMultiPkFinishEvent() {
        return this.multiPkFinishEvent;
    }

    /* JADX INFO: renamed from: getShowExtraResultAnim, reason: collision with other method in class */
    public MutableLiveData<Boolean> m616getShowExtraResultAnim() {
        return this.showExtraResultAnim;
    }

    /* JADX INFO: renamed from: getShowLastBattleResult, reason: collision with other method in class */
    public MutableLiveData<Boolean> m617getShowLastBattleResult() {
        return this.showLastBattleResult;
    }

    public static final /* synthetic */ HashMap access$getBattleUserRoleMap$p(PkMultiDataContext r0) {
        return r0.battleUserRoleMap;
    }

    public static final /* synthetic */ boolean access$getNeedUpdateRank$p(PkMultiDataContext r0) {
        return r0.needUpdateRank;
    }

    public static final /* synthetic */ boolean access$isRankUpdating$p(PkMultiDataContext r0) {
        return r0.isRankUpdating;
    }

    private final HashMap<String, Integer> createBattleRoleMap(Map<String, ? extends IBattleUserInfo> r5) {
        HashMap<String, Integer> r0 = new HashMap();
        AnchorLinkUserCenterV2 r1 = this.userCenter;
        if (r1 == null) goto L14;
        List<p> r2 = r1.a;
        if (r2 == null) goto L14;
        Iterator<T> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L14;
        p r4 = (p) r3.next();
        IBaseUser r6 = r4.getUser();
        if (r6 == null) goto L8;
        String r7 = r6.getIdString();
        if (r7 == null) goto L8;
        r0.put(r7, Integer.valueOf(q.d(r4)));
    L14:
        if (r5 == null) goto L23;
        Iterator<String> r8 = r5.keySet().iterator();
    L17:
        if (r8.hasNext() == false) goto L23;
        String r9 = r8.next();
        IBattleUserInfo r10 = r5.get(r9);
        if (r10 == null) goto L21;
        int r12 = r10.getPkRole();
    L22:
        r0.put(r9, Integer.valueOf(r12));
        goto L17
    L21:
        r12 = 0;
    L23:
        return r0;
    }

    private final void onMessage(yh6.c r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        IRoomBase r1 = null;
        if ((r9 instanceof u0) == false) goto L34;
        g5 r10 = ((vh7.c) r9).castTo(g5.class);
        ITeamTask r0 = r10.getTeamTask();
        if (r0 == null) goto L84;
        q9 r2 = r0.getTeamTaskConfig();
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.getTaskType() != ITeamTask.Type.TypeSummitInstantKill.ordinal()) goto L86;
        z r3 = getMultiPkMonitor();
        if (r3 == null) goto L30;
        Intrinsics.checkNotNullParameter(r10, Constants.OperatorKey.MSG);
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("msg_id", String.valueOf(qj.a(r10)));
        ITeamTask r12 = r10.getTeamTask();
        if (r12 == null) goto L17;
        String r13 = r12.getBattleId();
    L18:
        r4.put("msg_battle_id", String.valueOf(r13));
        r3.h(r4);
        cy0.e.a.getClass();
        j r5 = cy0.e.a.a;
        m.e.getClass();
        Object r14 = m.b(r5).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r14);
        IBaseUser r15 = ((com.bytedance.live.kmp.core.c) r14).b();
        if (r15 == null) goto L21;
        py.d r16 = r15.getUserHonor();
    L23:
        if (r3.k() == true) goto L29;
        if (r16 == null) goto L28;
        Intrinsics.checkNotNullParameter(r16, "$this$levelKt");
        if (r16.getLevel() > 20) goto L29;
    L28:
        r3.d(r4);
        int r17 = v.a;
        v.e("ttlive_anchor_link_multi_pk", "receive_trigger_instant_kill_msg params=" + r4);
    L29:
        z.y(r3, "receive_trigger_instant_kill_msg", r4, null, 12);
        goto L30
    L21:
        r16 = null;
        goto L23
    L17:
        r13 = null;
    L30:
        MultiCommonPkDataContext r18 = getMultiCommonPkDataContext();
        if (r18 == null) goto L87;
        r18.setTopSecKillTrigger(true);
        return;
    L87:
        return;
    L86:
        return;
    L84:
        return;
    L34:
        if ((r9 instanceof d0) == false) goto L69;
        IBattleToastMessage r19 = ((vh7.c) r9).castTo(IBattleToastMessage.class);
        IBattleToastMessage.b r6 = r19.getUiConfig();
        if (r6 == null) goto L89;
        IBattleToastMessage.b.b r7 = r6.getText();
        if (r7 == null) goto L90;
        String r8 = r7.getContent();
        if (r8 != null) goto L42;
        return;
    L42:
        if (r8.length() <= 0) goto L44;
        boolean r20 = true;
    L45:
        if (r20 == true) goto L47;
        return;
    L47:
        if (r19.getBattleId() != this.basePKContext.getPkId()) goto L93;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.a r22 = this.extraPlayManager;
        IBattleToastMessage.b r23 = r19.getUiConfig();
        if (r23 == null) goto L53;
        IBattleToastMessage.b.b r24 = r23.getText();
        if (r24 == null) goto L53;
        String r25 = r24.getContent();
    L54:
        Intrinsics.checkNotNull(r25);
        int r26 = (int) r19.getDuration();
        int r27 = r19.getNotifyType();
        r22.getClass();
        Intrinsics.checkNotNullParameter(r25, "content");
        ToastUtil.b(r25, r26);
        if (r27 != IBattleToastMessage.NotifyType.TypeProp.ordinal()) goto L94;
        LinkedHashMap r28 = new LinkedHashMap();
        com.bytedance.android.livesdk.revenue.service.room.c r29 = r22.b;
        if (r29 == null) goto L61;
        com.bytedance.android.livesdk.revenue.room.a r30 = r29.getRoomContext();
        if (r30 == null) goto L61;
        r1 = r30.getCommonRoom();
    L61:
        IRoom r32 = (IRoom) r1;
        r22.a(r28);
        MatchResult r33 = new Regex("\\d").matchEntire(r25);
        String r34 = "";
    L62:
        if (r33 == null) goto L64;
        r34 = r34 + r33.getValue();
        r33 = r33.next();
        goto L62
    L64:
        r28.put("buffer_card_num", r34.toString());
        mz0.n r35 = new mz0.n();
        Map<String, String> r36 = r35.a;
        Intrinsics.checkNotNullParameter(r36, "map");
        Intrinsics.checkNotNullParameter(r28, "map");
        r36.putAll(r28);
        mz0.m r37 = new mz0.m();
        if (r32 == null) goto L67;
        r37.d(r32);
    L67:
        r37.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r35.b).addAll(r37.a);
        cy0.e.a.getClass();
        j r38 = cy0.e.a.a;
        m.e.getClass();
        Object r39 = m.b(r38).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r39);
        ((i) ((f80.a) r39)).w3("livesdk_connection_buffer_card_overtime_show", r35.a, r35.b);
        return;
    L94:
        return;
    L53:
        r25 = null;
        goto L54
    L93:
        return;
    L44:
        r20 = false;
        goto L45
    L90:
        return;
    L89:
        return;
    L69:
        if ((r9 instanceof com.bytedance.android.livesdk.link.model.bridge.v) == false) goto L76;
        c2 r40 = ((vh7.c) r9).castTo(c2.class);
        if (r40 == null) goto L96;
        String r42 = r40.getBattlePowerContainerInfo();
        if (r42 == null) goto L97;
        m613getBattlePowerInfo().setValue(r42);
        return;
    L97:
        return;
    L96:
        return;
    L76:
        if ((r9 instanceof b0) == false) goto L99;
        b3 r43 = ((vh7.c) r9).castTo(b3.class);
        StringBuilder r44 = new StringBuilder("IBattleStateSyncMessageBridge message = ");
        u1 r45 = r43.getBattleSettings();
        if (r45 == null) goto L80;
        String r46 = r45.getLynxData();
    L81:
        r44.append(r46);
        jy0.b.c(TAG, r44.toString(), null, 4);
        return;
    L80:
        r46 = null;
        goto L81
    }

    private final void updateBattleUserRoleMap(Map<String, ? extends IBattleUserInfo> r2) {
        this.battleUserRoleMap.clear();
        this.battleUserRoleMap.putAll(createBattleRoleMap(r2));
    }

    public void addRankUpdateInterceptor(com.bytedance.android.live.revlink.impl.mergepk.pkmulti.d r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        this.onRankUpdateInterceptors.add(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public void handleBattleBgImage(v9 r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        if (isAnchor() == false) goto L7;
        this.battleBgParams = r5;
        Function0<Unit> r6 = this.requestBgRefresh;
        if (r6 == null) goto L23;
        Unit r7 = (Unit) r6.invoke();
        return;
    L23:
        return;
    L7:
        ld.a r0 = this.linkDataSet;
        if (r0 == null) goto L25;
        NextLiveData r1 = r0.Ed();
        if (r1 == null) goto L26;
        String r2 = r5.a;
        if (r2 != null) goto L14;
        r2 = d51.c.A0.k();
    L14:
        String r3 = r5.b;
        if (r3 != null) goto L17;
        r3 = d51.c.A0.j();
    L17:
        Boolean r8 = r5.c;
        if (r8 == null) goto L20;
        boolean r9 = r8.booleanValue();
    L21:
        r1.setValue(new oq2.a(r2, r3, r9));
        return;
    L20:
        r9 = false;
        goto L21
    L26:
        return;
    }

    public void handleUserLeave(IBaseUser r6) {
        Intrinsics.checkNotNullParameter(r6, "leaveUser");
        getExtraPlayContextManager().getClass();
        Intrinsics.checkNotNullParameter(r6, "leaveUser");
        PkBaseStateMachine.c r0 = getCurPKBaseState();
        r0.getClass();
        if ((r0 instanceof PkBaseStateMachine.c.a) == true) goto L14;
        PkBaseStateMachine.c r1 = getCurPKBaseState();
        r1.getClass();
        if ((r1 instanceof PkBaseStateMachine.c.b) == true) goto L14;
        int r2 = ToastUtil.a;
        com.bytedance.live.kmp.util.c r3 = com.bytedance.live.kmp.util.c.a;
        int r4 = w11.a.a;
        Object[] r5 = new Object[2];
        String r7 = r6.getNickName();
        if (r7 == null) goto L12;
        Intrinsics.checkNotNullParameter(r7, "$this$truncate");
        if (r7.length() <= 4) goto L13;
        r7 = r7.substring(0, 3) + "...";
    L13:
        r5[0] = r7;
        r5[1] = this.basePKContext.getShortPlayName();
        ToastUtil.b(com.bytedance.live.kmp.util.c.a(2131914786, r5), 0);
        return;
    L12:
        r7 = null;
    L14:
        int r8 = ToastUtil.a;
        com.bytedance.live.kmp.util.c r9 = com.bytedance.live.kmp.util.c.a;
        int r10 = w11.a.a;
        ToastUtil.b(com.bytedance.live.kmp.util.c.a(2131914785, new Object[]{r6.getNickName()}), 0);
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.d
    public void onBizReceiveBattleFinishMsg(a5 r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        MultiCommonPkDataContext r0 = getMultiCommonPkDataContext();
        if (r0 == null) goto L21;
        r0.setEndReason(Integer.valueOf(r3.getEndReason()));
        r0.setKillFinishType(Integer.valueOf(r3.getKillFinishType()));
        u1 r1 = r3.getBattleSetting();
        if (r1 == null) goto L7;
        String r2 = r1.getInitiatorId();
    L8:
        r0.setInitiatorId(r2);
        d31.d r4 = getRevLinkLogHelper();
        if (r4 == null) goto L11;
        String r5 = r4.o();
    L12:
        r0.setPkManager(r5);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L15
        r0.setEventTrackingInfo(MapsKt.toMutableMap(com.bytedance.android.live.revenue.common.q.a(new JSONObject(r3.getEventTrackingInfo()))));     // Catch: Throwable -> L15
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Result.box-impl(r7);
        return;
    L15:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L11:
        r5 = "";
        goto L12
    L7:
        r2 = null;
        goto L8
    }

    public void removeRankUpdateInterceptor(com.bytedance.android.live.revlink.impl.mergepk.pkmulti.d r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        this.onRankUpdateInterceptors.remove(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public void setAnchorLinkFinisher(boolean r1) {
        this.isAnchorLinkFinisher = r1;
    }

    public final void setEnterShowLastResult(boolean r1) {
        this.enterShowLastResult = r1;
    }

    public void setOnceMore(boolean r1) {
        this.isOnceMore = r1;
    }

    public void setPkBeforeFinishData(i31.a r1) {
        this.pkBeforeFinishData = r1;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public void setPkLauncher(boolean r1) {
        this.isPkLauncher = r1;
    }

    public void setPkStartParam(j31.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.pkStartParam = r2;
    }

    public void setTeamType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.teamType = r2;
    }

    public void setUserIdToTeamId(Map<String, Long> r2) {
        this.userIdToTeamId = r2;
        this.basePKContext.setUserIdToTeamIdExtra(r2);
    }

    public final void sharedWithRoomId(long r4) {
        this.basePKContext.sharedWithRoomId(r4);
        if (r4 != 0) goto L5;
        return;
    L5:
        com.bytedance.android.live.revlink.impl.global.d.a(this, "PkMultiDataContext_" + r4, this.linkFakeGlobalService);
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public void updateAudioPunishInfo(com.bytedance.android.livesdk.link.model.z r2) {
        Intrinsics.checkNotNullParameter(r2, "audioPunishInfo");
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.a r0 = this.anchorAudioPunishManager;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public static final /* synthetic */ void access$onMessage(PkMultiDataContext r0, yh6.c r1) {
        r0.onMessage(r1);
    }

    public static final /* synthetic */ void access$setBattleUserRoleMap$p(PkMultiDataContext r0, HashMap r1) {
        r0.battleUserRoleMap = r1;
    }

    public static final /* synthetic */ void access$setNeedUpdateRank$p(PkMultiDataContext r0, boolean r1) {
        r0.needUpdateRank = r1;
    }

    public static final /* synthetic */ void access$setRankUpdating$p(PkMultiDataContext r0, boolean r1) {
        r0.isRankUpdating = r1;
    }

    private final void updateTeamInfo(PkBaseStateMachine.Source r20, com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r22) {
        if (r20 != PkBaseStateMachine.Source.MetaUpdate) goto L7;
        Map<Long, g7> r2 = r22.d;
        if (r2 == null) goto L7;
        com.bytedance.android.live.revlink.impl.multianchor.pk.e r1 = com.bytedance.android.live.revlink.impl.multianchor.pk.e.a;
        setUserIdToTeamId(com.bytedance.android.live.revlink.impl.multianchor.pk.e.b(r2));
    L20:
        w r3 = getMultiLinkUtil();
        if (r3 == null) goto L23;
        UILayout r4 = r3.b();
    L25:
        if (r4 == UILayout.Enlarge) goto L27;
        return;
    L27:
        if ((this.basePKContext.getCurBattlePlayMode() instanceof c21.f.h) == false) goto L54;
        final com.bytedance.android.live.revlink.impl.mergepk.pkmulti.a r5 = this.extraPlayManager;
        if (r5 == null) goto L55;
        int r6 = d21.a.a;
        d51.c r7 = d51.c.A0;
        if (r7.o().G1() == false) goto L49;
        cy0.e.a.getClass();
        j r8 = cy0.e.a.a;
        m.e.getClass();
        Object r9 = m.b(r8).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r9);
        IBaseUser r10 = ((com.bytedance.live.kmp.core.c) r9).b();
        if (r10 == null) goto L36;
        String r12 = r10.getIdString();
    L37:
        String r13 = "show_prop_card_guide_tag_v3 " + r12;
        i97.a r14 = i97.a.a;
        long r15 = System.currentTimeMillis();
        com.bytedance.tools.kcp.spongepreference.runtime.a r16 = l51.a.P;
        KProperty[] r17 = l51.a.a;
        HashMap r18 = (HashMap) r16.getValue(null, r17[44]);
        com.bytedance.tools.kcp.spongepreference.runtime.a r19 = l51.a.Q;
        Long r110 = (Long) ((HashMap) r19.getValue(null, r17[45])).get(r13);
        if (r110 != null) goto L40;
        r110 = 0L;
    L40:
        long r111 = r110.longValue();
        Integer r112 = (Integer) r18.get(r13);
        if (r112 != null) goto L43;
        r112 = 0;
    L43:
        int r113 = r112.intValue();
        long r114 = 86400000;
        if (((r15 / r114) - (r111 / r114)) < 1) goto L49;
        boolean r23 = true;
        if (r113 > (r7.o().t2() - 1)) goto L49;
        HashMap r115 = (HashMap) r16.getValue(null, r17[44]);
        r115.put(r13, Integer.valueOf(r113 + 1));
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r16.setValue(null, r17[44], r115);
        HashMap r24 = (HashMap) r19.getValue(null, r17[45]);
        r24.put(r13, Long.valueOf(r15));
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        r19.setValue(null, r17[45], r24);
    L50:
        if (r23 == false) goto L56;
        p0.a(3000, false, true, new ExtraPlayManager$showPropCardGuideTips$1(r5), 2);
        return;
    L56:
        return;
    L36:
        r12 = null;
    L49:
        r23 = false;
        goto L50
    L55:
        return;
    L54:
        return;
    L23:
        r4 = null;
    L7:
        com.bytedance.android.live.revlink.impl.multianchor.pk.e r25 = com.bytedance.android.live.revlink.impl.multianchor.pk.e.a;
        Map<String, Long> r26 = com.bytedance.android.live.revlink.impl.multianchor.pk.e.a(r22.b);
        String r27 = "";
        if (r26 != null) goto L10;
    L19:
        setTeamType("");
        goto L20
    L10:
        if (((HashMap) r26).isEmpty() == true) goto L19;
        setUserIdToTeamId(r26);
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r28 = getMultiAnchorLinkLogUtils();
        if (r28 == null) goto L18;
        String r29 = r28.n();
        if (r29 == null) goto L18;
        r27 = r29;
    L18:
        setTeamType(r27);
        goto L20
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public void notifyPkContext(r r4, boolean r5) {
        this.basePKContext.notifyPkContext(r4, r5);
        MutableLiveData<Boolean> r6 = m617getShowLastBattleResult();
        boolean r0 = false;
        if (r4 == null) goto L9;
        s5 r2 = r4.getLinkStatsMeta();
        if (r2 == null) goto L9;
        if (r2.getBattleDisplayEntrance() != true) goto L9;
        boolean r3 = true;
    L10:
        r6.setValue(Boolean.valueOf(r3));
        MutableLiveData<Boolean> r7 = getLastBattleResultVisible();
        if (r4 == null) goto L17;
        s5 r8 = r4.getLinkStatsMeta();
        if (r8 == null) goto L17;
        if (r8.getBattleDisplayEntrance() != true) goto L17;
        r0 = true;
    L17:
        r7.setValue(Boolean.valueOf(r0));
        return;
    L9:
        r3 = false;
        goto L10
    }

    public void launchVoteRulePage(String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "secAnchorId");
        Intrinsics.checkNotNullParameter(r7, "source");
        k51.a r0 = k51.a.h;
        r0.getClass();
        String r1 = (String) k51.a.g.getValue(r0, k51.a.a[5]);
        if (r1.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return;
    L8:
        x0 r3 = new x0(r1);
        x0 r4 = r3.d("url");
        r4.b("anchor_id", String.valueOf(r5));
        r4.b("sec_anchor_id", r6);
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r8 = getMultiAnchorLinkContextObj();
        if (r8 == null) goto L11;
        Long r9 = Long.valueOf(r8.a());
    L12:
        r4.b("channel_id", String.valueOf(r9));
        cy0.e.a.getClass();
        j r10 = cy0.e.a.a;
        m.e.getClass();
        Object r12 = m.b(r10).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r12);
        r4.b("user_id", ((com.bytedance.live.kmp.core.c) r12).getCurrentUserId().toString());
        r4.b("is_multi", DataType.TRUE);
        r4.b("request_page", r7);
        Object r13 = m.b(r10).b(pq2.a.class);
        Intrinsics.checkNotNull(r13);
        ((com.bytedance.live.kmp.core.c) r13).g3(r3.c());
        return;
    L11:
        r9 = null;
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.d
    public void onBizPenal(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r4, PkBaseStateMachine.Source r5, PkBaseStateMachine.c r6) {
        Intrinsics.checkNotNullParameter(r4, "pkInfo");
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r6, "toState");
        PkBaseStateMachine.Source r7 = PkBaseStateMachine.Source.MetaUpdate;
        if (r5 != r7) goto L12;
        PkBaseDataContext r0 = this.basePKContext;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r1 = getMultiAnchorLinkContext();
        if (r1 == null) goto L10;
        com.bytedance.live.datacontext.m<String> r2 = r1.getConnectionSource();
        if (r2 == null) goto L10;
        String r3 = (String) r2.getValue();
        if (r3 == null) goto L10;
    L11:
        r0.setPkSource(r3);
    L10:
        r3 = "";
    L12:
        if (r5 != r7) goto L17;
        Map<Long, g7> r8 = r4.d;
        if (r8 == null) goto L17;
        com.bytedance.android.live.revlink.impl.multianchor.pk.e r9 = com.bytedance.android.live.revlink.impl.multianchor.pk.e.a;
        setUserIdToTeamId(com.bytedance.android.live.revlink.impl.multianchor.pk.e.b(r8));
    L17:
        if (isAnchor() == false) goto L36;
        List<a1> r10 = r4.c;
        if (r10 == null) goto L36;
        Iterator<T> r12 = r10.iterator();
    L22:
        if (r12.hasNext() == false) goto L30;
        Object r13 = r12.next();
        String r14 = af2.c.a((a1) r13);
        s r15 = getRevLinkCommonUtil();
        if (r15 == null) goto L26;
        String r16 = r15.e();
    L28:
        if (Intrinsics.areEqual(r14, r16) == false) goto L22;
    L31:
        a1 r17 = (a1) r13;
        if (r17 == null) goto L36;
        if (r17.getScore() <= 300) goto L36;
        l51.a.O.setValue(null, l51.a.a[41], Boolean.TRUE);
        goto L36
    L26:
        r16 = null;
        goto L28
    L30:
        r13 = null;
    L36:
        getPkStartParam().x = r4.m;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.b r18 = getExtraPlayContextManager();
        isOnceMore();
        r18.getClass();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.d
    public void onBizFinished(boolean r3, PkBaseStateMachine.c r4, PkBaseStateMachine.c r5, boolean r6) {
        if (r4 == null) goto L5;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r7 = r4.a;
    L6:
        if (r4 != null) goto L8;
        r4 = PkBaseStateMachine.c.a.d;
    L8:
        resetBattle();
        if (r6 == false) goto L19;
        MutableLiveData<i31.b> r8 = m615getMultiPkFinishEvent();
        if (r7 == null) goto L13;
        IBaseBattleSetting r1 = r7.a;
    L14:
        r8.setValue(new i31.b(r1));
        if (r7 == null) goto L17;
        IBaseBattleSetting r9 = r7.a;
    L18:
        setPkBeforeFinishData(new i31.a(r4, r9));
        goto L19
    L17:
        r9 = null;
        goto L18
    L13:
        r1 = null;
    L19:
        this.curInviteMode = "connection";
        setOnceMore(false);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.b r10 = getExtraPlayContextManager();
        isOnceMore();
        r10.getClass();
        this.battleBgParams = null;
        resetBgImage();
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.d
    public void onBizPK(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r17, PkBaseStateMachine.c r18, PkBaseStateMachine.c r19, PkBaseStateMachine.Source r20, boolean r22, PlayMode r23) {
        Intrinsics.checkNotNullParameter(r17, "pkInfo");
        Intrinsics.checkNotNullParameter(r18, "fromState");
        Intrinsics.checkNotNullParameter(r19, "toState");
        Intrinsics.checkNotNullParameter(r20, "source");
        resetBgImage();
        if (r20 != PkBaseStateMachine.Source.MetaUpdate) goto L12;
        PkBaseDataContext r4 = this.basePKContext;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r6 = getMultiAnchorLinkContext();
        if (r6 == null) goto L10;
        com.bytedance.live.datacontext.m<String> r7 = r6.getConnectionSource();
        if (r7 == null) goto L10;
        String r8 = (String) r7.getValue();
        if (r8 == null) goto L10;
    L11:
        r4.setPkSource(r8);
    L10:
        r8 = "";
    L12:
        a21.a r5 = getPkBaseLogger();
        if (r5 == null) goto L19;
        long r9 = this.basePKContext.getPkId();
        String r10 = this.basePKContext.getPkSource();
        c21.f r12 = this.basePKContext.getCurBattlePlayMode();
        if (r12 == null) goto L17;
        String r13 = r12.b();
    L18:
        r5.c(r9, r10, r13);
        goto L19
    L17:
        r13 = "routine";
    L19:
        setOnceMore(r22);
        updateTeamInfo(r20, r17);
        MultiCommonPkDataContext r2 = getMultiCommonPkDataContext();
        if (r2 == null) goto L22;
        r2.setTopSecKillTrigger(false);
    L22:
        updateBattleUserRoleMap(r17.b);
        j31.a r3 = getPkStartParam();
        boolean r14 = isAnchor();
        f21.a r15 = getConnectionContext();
        IBaseBattleSetting r16 = r17.a;
        Map<String, IBattleUserInfo> r24 = r17.b;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r110 = getLinkOptLogContext();
        if (r110 == null) goto L25;
        String r111 = r110.c;
    L26:
        Map<String, String> r112 = r17.m;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r113 = getMultiAnchorLinkContext();
        if (r113 == null) goto L32;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.link.model.p0> r114 = r113.getLaunchBattleAttachInfo();
        if (r114 == null) goto L32;
        com.bytedance.android.livesdk.link.model.p0 r115 = (com.bytedance.android.livesdk.link.model.p0) r114.getValue();
        if (r115 == null) goto L32;
    L33:
        r3.a = Boolean.valueOf(r14);
        r3.e = r22;
        if (r16 == null) goto L36;
        Long r25 = Long.valueOf(r16.getBattleId());
    L37:
        r3.b = r25;
        if (r16 == null) goto L40;
        Integer r26 = Integer.valueOf((int) r16.getDuration());
    L41:
        r3.f = r26;
        if (r16 == null) goto L44;
        Long r27 = Long.valueOf(r16.getStartTimeMs());
    L45:
        r3.c = r27;
        com.bytedance.android.live.revlink.impl.multianchor.pk.e r28 = com.bytedance.android.live.revlink.impl.multianchor.pk.e.a;
        Map<String, Long> r29 = com.bytedance.android.live.revlink.impl.multianchor.pk.e.a(r24);
        if (r29 != null) goto L48;
        r29 = MapsKt.emptyMap();
    L48:
        r3.j = r29;
        if (r29 != null) goto L51;
    L53:
        boolean r30 = false;
    L54:
        int r116 = f.a;
        if (r16 == null) goto L57;
        IBattleConfigSetting r117 = r16.getBattleConfigSetting();
    L58:
        if (r30 == false) goto L60;
        PlayMode r32 = PlayMode.TEAM_PK;
    L61:
        r3.g = f.a(r117, r32);
        r3.v = r111;
        if (r15 == null) goto L92;
        com.bytedance.android.live.revlink.impl.global.c r33 = r3.z;
        if (r33 == null) goto L66;
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r34 = r33.getMultiAnchorLinkLogUtils();
    L67:
        if (r34 == null) goto L69;
        String r35 = r34.F(r15.l);
    L70:
        r3.k = r35;
        com.bytedance.android.live.revlink.impl.global.c r36 = r3.z;
        if (r36 == null) goto L73;
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r37 = r36.getMultiAnchorLinkLogUtils();
    L74:
        if (r37 == null) goto L83;
        boolean r38 = r15.k;
        com.bytedance.android.live.revlink.impl.global.c r118 = r3.z;
        if (r118 == null) goto L78;
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r119 = r118.getMultiAnchorLinkContextObj();
    L79:
        if (r119 == null) goto L81;
        int r120 = r119.d();
    L82:
        String r39 = com.bytedance.android.live.revlink.impl.multianchor.utils.q.E(r37, r38, r120, 4);
    L84:
        r3.l = r39;
        com.bytedance.android.live.revlink.impl.global.c r40 = r3.z;
        if (r40 == null) goto L87;
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r42 = r40.getMultiAnchorLinkLogUtils();
    L88:
        if (r42 == null) goto L90;
        String r43 = r42.p();
    L91:
        r3.m = r43;
        goto L92
    L90:
        r43 = null;
        goto L91
    L87:
        r42 = null;
        goto L88
    L81:
        r120 = 0;
        goto L82
    L78:
        r119 = null;
        goto L79
    L83:
        r39 = null;
        goto L84
    L73:
        r37 = null;
        goto L74
    L69:
        r35 = null;
        goto L70
    L66:
        r34 = null;
    L92:
        if (r16 == null) goto L98;
        IBattleConfigSetting r44 = r16.getBattleConfigSetting();
        if (r44 == null) goto L98;
        aa r45 = r44.getVoteData();
        if (r45 == null) goto L98;
        String r46 = r45.getVoteDes();
    L99:
        r3.h = r46;
        com.bytedance.android.live.revlink.impl.global.c r47 = r3.z;
        if (r47 == null) goto L102;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r48 = r47.R8();
    L103:
        if (r48 == null) goto L107;
        i11.b r49 = r48.getLinkUserCenter();
        if (r49 == null) goto L107;
        Integer r50 = Integer.valueOf(r49.c());
    L108:
        r3.i = r50;
        HashMap<String, Integer> r52 = new HashMap();
        if (r24 == null) goto L118;
        Iterator<String> r53 = r24.keySet().iterator();
    L112:
        if (r53.hasNext() == false) goto L118;
        String r121 = r53.next();
        IBattleUserInfo r122 = r24.get(r121);
        if (r122 == null) goto L116;
        int r123 = r122.getPkRole();
    L117:
        r52.put(r121, Integer.valueOf(r123));
        goto L112
    L116:
        r123 = 0;
    L118:
        r3.d = r52;
        if (r16 == null) goto L121;
        IBattleConfigSetting r54 = r16.getBattleConfigSetting();
    L122:
        if (r54 == null) goto L126;
        v2 r55 = r54.getSelfSettingRate();
        if (r55 == null) goto L126;
        Number r56 = Long.valueOf(r55.getPkValueType());
    L128:
        if (CollectionsKt.contains(new LongRange(1, 99), r56) == false) goto L160;
        r3.n = r56.toString();
        if (r54 == null) goto L134;
        v2 r57 = r54.getSelfSettingRate();
        if (r57 == null) goto L134;
        String r58 = String.valueOf(r57.getPkGiftRate());
    L135:
        r3.o = r58;
        if (r54 == null) goto L140;
        v2 r59 = r54.getSelfSettingRate();
        if (r59 == null) goto L140;
        String r60 = String.valueOf(r59.getPkUVRate());
    L141:
        r3.p = r60;
        if (r54 == null) goto L146;
        v2 r62 = r54.getSelfSettingRate();
        if (r62 == null) goto L146;
        String r63 = String.valueOf(r62.getPkTicketRate());
    L147:
        r3.q = r63;
        if (r54 == null) goto L152;
        v2 r64 = r54.getSelfSettingRate();
        if (r64 == null) goto L152;
        String r65 = String.valueOf(r64.getPkLikeRate());
    L153:
        r3.r = r65;
        if (r54 == null) goto L158;
        v2 r66 = r54.getSelfSettingRate();
        if (r66 == null) goto L158;
        String r67 = String.valueOf(r66.getPkVIPRate());
    L159:
        r3.s = r67;
    L158:
        r67 = null;
    L152:
        r65 = null;
    L146:
        r63 = null;
    L140:
        r60 = null;
    L134:
        r58 = null;
    L160:
        if (r54 == null) goto L173;
        h9 r68 = r54.getSpecifyGiftConfig();
        if (r68 == null) goto L173;
        List r69 = r68.getGiftIds();
        if (r69 == null) goto L173;
        if ((!r69.isEmpty()) == true) goto L169;
        r69 = null;
    L169:
        if (r69 == null) goto L173;
        Long r70 = (Long) ListProtector.get(r69, 0);
        if (r70 == null) goto L173;
        long r72 = r70.longValue();
    L174:
        r3.t = r72;
        if (r54 == null) goto L189;
        h9 r73 = r54.getSpecifyGiftConfig();
        if (r73 == null) goto L189;
        Map r74 = r73.getGiftMap();
        if (r74 == null) goto L189;
        if ((true ^ r74.isEmpty()) == true) goto L184;
        r74 = null;
    L184:
        if (r74 == null) goto L189;
        i9 r75 = (i9) r74.get(Long.valueOf(r3.t));
        if (r75 == null) goto L189;
        String r76 = r75.getGiftName();
        if (r76 == null) goto L189;
    L190:
        r3.u = r76;
        r3.w = r24;
        r3.x = r112;
        r3.y = r115;
        MultiCommonPkDataContext r77 = getMultiCommonPkDataContext();
        if (r77 == null) goto L193;
        r77.setTopSecKillTrigger(false);
    L193:
        int r78 = f.a;
        IBaseBattleSetting r1 = r17.a;
        if (r1 == null) goto L196;
        IBattleConfigSetting r79 = r1.getBattleConfigSetting();
    L197:
        this.curInviteMode = f.a(r79, r23);
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r80 = getLinkOptLogContext();
        if (r80 == null) goto L200;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r80.c = "";
    L200:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.b r82 = getExtraPlayContextManager();
        isOnceMore();
        r82.getClass();
        this.battleBgParams = null;
        return;
    L196:
        r79 = null;
    L189:
        r76 = "";
    L173:
        r72 = 0;
    L126:
        r56 = 0;
        goto L128
    L121:
        r54 = null;
    L107:
        r50 = null;
        goto L108
    L102:
        r48 = null;
    L98:
        r46 = null;
        goto L99
    L60:
        r32 = PlayMode.PERSONAL_PK;
        goto L61
    L57:
        r117 = null;
        goto L58
    L51:
        if ((!r29.isEmpty()) != true) goto L53;
        r30 = true;
        goto L54
    L44:
        r27 = null;
        goto L45
    L40:
        r26 = null;
        goto L41
    L36:
        r25 = null;
    L32:
        r115 = r17.o;
        goto L33
    L25:
        r111 = null;
        goto L26
    }

    public PkMultiDataContext(com.bytedance.android.livesdk.revenue.room.a r16, com.bytedance.android.live.revlink.impl.control.launchcontext.b r17, ld.a r18, wq2.f r19, com.bytedance.android.livesdk.revenue.service.room.c r20, com.bytedance.android.live.revlink.impl.global.c r22, yz0.f r23, com.bytedance.android.livesdk.revenue.service.message.d r24, x11.a r25, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r26, PkBaseDataContext r27, Function0<Unit> r28) {
        Intrinsics.checkNotNullParameter(r26, "context");
        this.roomContext = r16;
        this.launchContext = r17;
        this.linkDataSet = r18;
        this.linkFakeGlobalService = r22;
        this.messageService = r23;
        this.requestBgRefresh = r28;
        CompositeDisposable r13 = new CompositeDisposable();
        this.cd = r13;
        if (r27 != null) goto L9;
        PkMultiDataContext$basePKContext$1 r2 = PkMultiDataContext$basePKContext$1.INSTANCE;
        if (r16 == null) goto L7;
        boolean r3 = r16.getCommonIsAnchor();
    L8:
        final PkBaseDataContext r14 = new PkBaseDataContext(r2, r3, r18, r19, r20, r22, r23, r25, r26);
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) com.bytedance.live.datacontext.d.a(new PkMultiDataContext$basePKContext$2$1(r14)).getSecond(), r13);
        Unit r1 = Unit.INSTANCE;
    L10:
        com.bytedance.revenue.platform.api.core.rx.f.a(r14.registerBiz(this, PKBizType.ClassicMulti), r13);
        Unit r4 = Unit.INSTANCE;
        this.basePKContext = r14;
        LinkRevInternalServiceContext r5 = getLinkRevInternalServiceContext();
        if (r5 == null) goto L15;
        com.bytedance.live.datacontext.j<AnchorLinkUserCenterV2> r6 = r5.getLinkUserCenter();
        if (r6 == null) goto L15;
        AnchorLinkUserCenterV2 r7 = (AnchorLinkUserCenterV2) r6.getValue();
    L16:
        this.userCenter = r7;
        MutableLiveData<List<cf2.a>> r8 = r14.m587getBaseScoreState();
        Intrinsics.checkNotNullParameter(r8, "$this$convertToScoreList");
        MediatorLiveData r9 = new MediatorLiveData();
        r9.addSource(r8, new com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.g(r9));
        this.scoreState = r9;
        this.multiPkFinishEvent = new MutableLiveData();
        this.battleUserRoleMap = new HashMap();
        this.onRankUpdateInterceptors = new ArrayList();
        this.showExtraResultAnim = r14.getExtraResultAnim();
        this.lastBattleResultVisible = r14.getLastBattleResultVisible();
        this.teamTaskLayoutFocused = new NextLiveData();
        this.pkStartParam = new j31.a(r22);
        this.teamType = "";
        this.curInviteMode = "connection";
        this.showLastBattleResult = r14.m595getShowLastBattleResult();
        this.extraPlayManager = new com.bytedance.android.live.revlink.impl.mergepk.pkmulti.a(r20, r22);
        r14.isAnchor();
        this.extraPlayContextManager = new com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.b(r22, r23);
        this.battlePowerInfo = new MutableLiveData();
        this.callback = new c(this);
        return;
    L15:
        r7 = null;
        goto L16
    L7:
        r3 = false;
        goto L8
    L9:
        r14 = r27;
        goto L10
    }

    public /* synthetic */ PkMultiDataContext(com.bytedance.android.livesdk.revenue.room.a r17, com.bytedance.android.live.revlink.impl.control.launchcontext.b r18, ld.a r19, wq2.f r20, com.bytedance.android.livesdk.revenue.service.room.c r22, com.bytedance.android.live.revlink.impl.global.c r23, yz0.f r24, com.bytedance.android.livesdk.revenue.service.message.d r25, x11.a r26, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r27, PkBaseDataContext r28, Function0 r29, int r210, DefaultConstructorMarker r30) {
        if ((r210 & 1024) == 0) goto L5;
        PkBaseDataContext r14 = null;
    L7:
        if ((r210 & 2048) == 0) goto L9;
        Function0 r15 = null;
    L10:
        this(r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r14, r15);
        return;
    L9:
        r15 = r29;
        goto L10
    L5:
        r14 = r28;
        goto L7
    }
}
