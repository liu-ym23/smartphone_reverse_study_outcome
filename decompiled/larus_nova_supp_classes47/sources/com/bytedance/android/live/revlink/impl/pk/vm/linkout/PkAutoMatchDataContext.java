package com.bytedance.android.live.revlink.impl.pk.vm.linkout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revlink.aio.impl.AutoMatchService;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.service.RingDrawable;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.chatroom.interact.model.h0;
import com.bytedance.android.livesdk.link.model.BattleNotifyMessageType;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.RandomMatchStrategy;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.link.model.bridge.r;
import com.bytedance.android.livesdk.link.model.bridge.s;
import com.bytedance.android.livesdk.link.model.bridge.u;
import com.bytedance.android.livesdk.link.model.c0;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.o1;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.p1;
import com.bytedance.android.livesdk.link.model.r1;
import com.bytedance.android.livesdk.link.model.r4;
import com.bytedance.android.livesdk.link.model.s0;
import com.bytedance.android.livesdk.link.model.s1;
import com.bytedance.android.livesdk.link.model.s4;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.link.model.v4;
import com.bytedance.android.livesdk.link.model.z1;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.service.broadcast.IRevBroadcastService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import dq2.w;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
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
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000²\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000  \u00022\u00020\u0001:\u0004¡\u0002¢\u0002B9\u0012\n\u0010×\u0001\u001a\u0005\u0018\u00010Ö\u0001\u0012\n\u0010Ú\u0001\u001a\u0005\u0018\u00010Ù\u0001\u0012\n\u0010Ý\u0001\u001a\u0005\u0018\u00010Ü\u0001\u0012\n\u0010à\u0001\u001a\u0005\u0018\u00010ß\u0001¢\u0006\u0006\b\u009e\u0002\u0010\u009f\u0002J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\"\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J/\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010 \u001a\u00020\u0002J\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!Jk\u00101\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00142\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001a2\b\b\u0002\u0010*\u001a\u00020\r2\b\b\u0002\u0010+\u001a\u00020\r2%\b\u0002\u00100\u001a\u001f\u0012\u0013\u0012\u00110-¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u0002\u0018\u00010,J\u000e\u00102\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004JL\u0010=\u001a\u00020\u00022\n\u00105\u001a\u000603j\u0002`42\u0006\u00106\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001a2\b\u00108\u001a\u0004\u0018\u0001072\u0006\u00109\u001a\u00020\u001a2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020:0!2\b\u0010<\u001a\u0004\u0018\u00010\rJ\u0016\u0010A\u001a\u00020\u00022\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020\rJ4\u0010E\u001a\u00020\u00022\u0006\u0010C\u001a\u00020B2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020\r2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\r2\b\u0010D\u001a\u0004\u0018\u00010-J\u0006\u0010F\u001a\u00020\u0002J\u0010\u0010I\u001a\u00020\u00022\b\u0010H\u001a\u0004\u0018\u00010GJ\u0006\u0010J\u001a\u00020\u0014J\u0006\u0010K\u001a\u00020\u0014J\b\u0010M\u001a\u0004\u0018\u00010LJ\u0016\u0010Q\u001a\u00020\u00022\u000e\u0010P\u001a\n\u0018\u00010Nj\u0004\u0018\u0001`OR\u0018\u0010T\u001a\u00060Rj\u0002`S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010W\u001a\u0004\u0018\u00010V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010Y\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010]\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u001e\u0010a\u001a\n\u0018\u000103j\u0004\u0018\u0001`48\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u001e\u0010e\u001a\n\u0018\u00010cj\u0004\u0018\u0001`d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u001e\u0010g\u001a\n\u0018\u00010cj\u0004\u0018\u0001`d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010fR\u0016\u0010h\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010j\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010\\R\u0016\u0010k\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010\\R\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010lR\u0016\u0010m\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010\\R*\u0010n\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR6\u0010w\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010u0tj\n\u0012\u0006\u0012\u0004\u0018\u00010u`v8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R'\u0010}\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R)\u0010C\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bC\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R)\u0010D\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bD\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R \u0010\u008d\u0001\u001a\n\u0018\u00010cj\u0004\u0018\u0001`d8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010fR)\u0010\u008e\u0001\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R+\u0010\u0097\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0095\u00010\u0094\u0001j\n\u0012\u0005\u0012\u00030\u0095\u0001`\u0096\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R0\u0010\u009b\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0095\u00010\u0099\u0001j\n\u0012\u0005\u0012\u00030\u0095\u0001`\u009a\u00018\u0006¢\u0006\u0010\n\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R)\u0010\u009f\u0001\u001a\u0014\u0012\u0004\u0012\u00020\t0\u0094\u0001j\t\u0012\u0004\u0012\u00020\t`\u0096\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009f\u0001\u0010\u0098\u0001R.\u0010 \u0001\u001a\u0014\u0012\u0004\u0012\u00020\t0\u0099\u0001j\t\u0012\u0004\u0012\u00020\t`\u009a\u00018\u0006¢\u0006\u0010\n\u0006\b \u0001\u0010\u009c\u0001\u001a\u0006\b¡\u0001\u0010\u009e\u0001R)\u0010¢\u0001\u001a\u0014\u0012\u0004\u0012\u00020\t0\u0094\u0001j\t\u0012\u0004\u0012\u00020\t`\u0096\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010\u0098\u0001R.\u0010£\u0001\u001a\u0014\u0012\u0004\u0012\u00020\t0\u0099\u0001j\t\u0012\u0004\u0012\u00020\t`\u009a\u00018\u0006¢\u0006\u0010\n\u0006\b£\u0001\u0010\u009c\u0001\u001a\u0006\b¤\u0001\u0010\u009e\u0001R(\u0010¥\u0001\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b¥\u0001\u0010\\\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R'\u0010®\u0001\u001a\t\u0012\u0004\u0012\u00020\r0©\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\bª\u0001\u0010«\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001R'\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020\u00140©\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b¯\u0001\u0010«\u0001\u001a\u0006\b°\u0001\u0010\u00ad\u0001R(\u0010µ\u0001\u001a\n\u0012\u0005\u0012\u00030²\u00010©\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b³\u0001\u0010«\u0001\u001a\u0006\b´\u0001\u0010\u00ad\u0001R'\u0010¸\u0001\u001a\t\u0012\u0004\u0012\u00020\u00140©\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b¶\u0001\u0010«\u0001\u001a\u0006\b·\u0001\u0010\u00ad\u0001R(\u0010¹\u0001\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b¹\u0001\u0010\\\u001a\u0006\b¹\u0001\u0010¦\u0001\"\u0006\bº\u0001\u0010¨\u0001R(\u0010»\u0001\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b»\u0001\u0010i\u001a\u0006\b¼\u0001\u0010½\u0001\"\u0006\b¾\u0001\u0010¿\u0001R+\u0010À\u0001\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÀ\u0001\u0010\u008f\u0001\u001a\u0006\bÁ\u0001\u0010\u0091\u0001\"\u0006\bÂ\u0001\u0010\u0093\u0001R(\u0010Ã\u0001\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bÃ\u0001\u0010i\u001a\u0006\bÄ\u0001\u0010½\u0001\"\u0006\bÅ\u0001\u0010¿\u0001R,\u0010Ç\u0001\u001a\u0005\u0018\u00010Æ\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÇ\u0001\u0010È\u0001\u001a\u0006\bÉ\u0001\u0010Ê\u0001\"\u0006\bË\u0001\u0010Ì\u0001R \u0010Í\u0001\u001a\n\u0018\u00010cj\u0004\u0018\u0001`d8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÍ\u0001\u0010fR\u001a\u0010Ï\u0001\u001a\u0005\u0018\u00010Î\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001R\u0018\u0010Ò\u0001\u001a\u00030Ñ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R\u0017\u0010Ô\u0001\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R\u001a\u0010×\u0001\u001a\u0005\u0018\u00010Ö\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001R\u001a\u0010Ú\u0001\u001a\u0005\u0018\u00010Ù\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÚ\u0001\u0010Û\u0001R\u001a\u0010Ý\u0001\u001a\u0005\u0018\u00010Ü\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÝ\u0001\u0010Þ\u0001R\u001a\u0010à\u0001\u001a\u0005\u0018\u00010ß\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bà\u0001\u0010á\u0001R\u001a\u0010ä\u0001\u001a\u0005\u0018\u00010Î\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bâ\u0001\u0010ã\u0001R\u001a\u0010è\u0001\u001a\u0005\u0018\u00010å\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bæ\u0001\u0010ç\u0001R\u001a\u0010ì\u0001\u001a\u0005\u0018\u00010é\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bê\u0001\u0010ë\u0001R\u001a\u0010ð\u0001\u001a\u0005\u0018\u00010í\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bî\u0001\u0010ï\u0001R\u001a\u0010ô\u0001\u001a\u0005\u0018\u00010ñ\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bò\u0001\u0010ó\u0001R\u001a\u0010ø\u0001\u001a\u0005\u0018\u00010õ\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bö\u0001\u0010÷\u0001R\u001a\u0010ü\u0001\u001a\u0005\u0018\u00010ù\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bú\u0001\u0010û\u0001R\u001a\u0010\u0080\u0002\u001a\u0005\u0018\u00010ý\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bþ\u0001\u0010ÿ\u0001R\u001a\u0010\u0084\u0002\u001a\u0005\u0018\u00010\u0081\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0082\u0002\u0010\u0083\u0002R\u001a\u0010\u0088\u0002\u001a\u0005\u0018\u00010\u0085\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0086\u0002\u0010\u0087\u0002R\u001a\u0010\u008c\u0002\u001a\u0005\u0018\u00010\u0089\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008a\u0002\u0010\u008b\u0002R\u001a\u0010\u0090\u0002\u001a\u0005\u0018\u00010\u008d\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008e\u0002\u0010\u008f\u0002R\u001a\u0010\u0094\u0002\u001a\u0005\u0018\u00010\u0091\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0092\u0002\u0010\u0093\u0002R\u001a\u0010\u0098\u0002\u001a\u0005\u0018\u00010\u0095\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0096\u0002\u0010\u0097\u0002R\u0014\u0010\u009b\u0002\u001a\u00020\t8F¢\u0006\b\u001a\u0006\b\u0099\u0002\u0010\u009a\u0002R\u0014\u0010\u009c\u0002\u001a\u00020\u00148F¢\u0006\b\u001a\u0006\b\u009c\u0002\u0010¦\u0001R\u0014\u0010\u009d\u0002\u001a\u00020\u00148F¢\u0006\b\u001a\u0006\b\u009d\u0002\u0010¦\u0001¨\u0006£\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/PkAutoMatchDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "matchLinkAfterCancel", "Lcom/bytedance/android/live/revlink/impl/pk/utils/AutoMatchSource;", "source", "logMatchFailedForEnd", "logFailedToastShow", "showPopup", "", "timeLeft", "showServerControlPopup", "clearInvitingStatus", "", "action", "logInviteSuccess", "Lcom/bytedance/android/livesdk/link/model/z1;", Constants.OperatorKey.MSG, "onBattleNotifyPointMsg", "logLargeMatchInvited", "", "isLargeMatch", "battleAttachedInfoStr", "isFailToSwitch", "logLargeStrategyLifeCycle", "anchorType", "", "inviteType", "Lcom/bytedance/android/livesdk/link/model/p0;", "battleAttachedInfo", "logMatchSuccess", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/livesdk/link/model/p0;)V", "clearIt", "", "Li41/p;", "getListeners", "roomId", "flash", "Lcom/bytedance/android/livesdk/link/model/b0;", "matchInfo", "matchType", "matchStyleType", "activityType", "gameAppId", "Lkotlin/Function1;", "Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/p;", "Lkotlin/ParameterName;", "name", "notifyMatchInfo", "startMatch", "endMatch", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "room", "enableRank", "Lcom/bytedance/android/livesdk/link/model/m2;", "battleRival", "mAnchorLayer", "", "binderDataList", "imprId", "inviteWhenMatching", "Lcom/bytedance/android/livesdk/link/model/r4;", "autoMatch", "activityName", "startMatchCountDown", "Laf2/e;", "autoMatchModel", "randomMatchInfo", "handleAutoMatchInvite", "endMatchAndClear", "Lcom/bytedance/android/livesdk/link/model/i6;", "linkerMessage", "cancelInvite", "isInviting", "getCanHighWayRandom", "Lcom/bytedance/android/livesdk/chatroom/interact/model/h0;", "pkAutoMatchLogInfo", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "message", "onMessage", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/livesdk/revenue/room/a;", "roomContext", "Lcom/bytedance/android/livesdk/revenue/room/a;", "mInviteMessage", "Lcom/bytedance/android/livesdk/link/model/i6;", "mMatchSuccessNotInvite", "Z", "mIsInviting", "Lcom/bytedance/android/live/revenuelink/connect/n;", "linkOutManager", "Lcom/bytedance/android/live/revenuelink/connect/n;", "mRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lio/reactivex/disposables/Disposable;", "Lcom/bytedance/revenue/platform/api/core/rx/Disposable;", "mCountDownDisposable", "Lio/reactivex/disposables/Disposable;", "mUserAvatarDisposable", "avatarCount", "I", "mSpeedUpNotSuccess", "canHighWayRandom", "Lcom/bytedance/android/livesdk/chatroom/interact/model/h0;", "isListenMessage", "mUserListWhenInvite", "Ljava/util/List;", "getMUserListWhenInvite", "()Ljava/util/List;", "setMUserListWhenInvite", "(Ljava/util/List;)V", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Ly31/k;", "Lcom/bytedance/android/live/revenue/common/NextLiveData;", "mInvitingUserData", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getMInvitingUserData", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "setMInvitingUserData", "(Lcom/bytedance/ies/sdk/widgets/NextLiveData;)V", "autoMatchInfo", "Lcom/bytedance/android/livesdk/link/model/b0;", "getAutoMatchInfo", "()Lcom/bytedance/android/livesdk/link/model/b0;", "setAutoMatchInfo", "(Lcom/bytedance/android/livesdk/link/model/b0;)V", "Laf2/e;", "getAutoMatchModel", "()Laf2/e;", "setAutoMatchModel", "(Laf2/e;)V", "Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/p;", "getRandomMatchInfo", "()Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/p;", "setRandomMatchInfo", "(Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/p;)V", "messageDisposable", "mActivityName", "Ljava/lang/String;", "getMActivityName", "()Ljava/lang/String;", "setMActivityName", "(Ljava/lang/String;)V", "Landroidx/lifecycle/MutableLiveData;", "Ll41/a;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/MutableLiveData;", "_pkMatchState", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/LiveData;", "pkMatchState", "Landroidx/lifecycle/LiveData;", "getPkMatchState", "()Landroidx/lifecycle/LiveData;", "_waitedTime", "waitedTime", "getWaitedTime", "_leftTime", "leftTime", "getLeftTime", "isSpeedUp", "()Z", "setSpeedUp", "(Z)V", "Lcom/bytedance/live/datacontext/k;", "showPopupEvent$delegate", "Lcom/bytedance/live/datacontext/p;", "getShowPopupEvent", "()Lcom/bytedance/live/datacontext/k;", "showPopupEvent", "dismissDialogEvent$delegate", "getDismissDialogEvent", "dismissDialogEvent", "Lcom/bytedance/android/livesdk/link/model/bridge/s;", "showMatchInviteDialogEvent$delegate", "getShowMatchInviteDialogEvent", "showMatchInviteDialogEvent", "dismissMatchInviteDialogEvent$delegate", "getDismissMatchInviteDialogEvent", "dismissMatchInviteDialogEvent", "isMatchSuccess", "setMatchSuccess", "currentMatchType", "getCurrentMatchType", "()I", "setCurrentMatchType", "(I)V", "currentGameId", "getCurrentGameId", "setCurrentGameId", "currentMatchStyleType", "getCurrentMatchStyleType", "setCurrentMatchStyleType", "Lf41/a;", "jsbInvitePkCallback", "Lf41/a;", "getJsbInvitePkCallback", "()Lf41/a;", "setJsbInvitePkCallback", "(Lf41/a;)V", "autoInviteDisposable", "Lcom/bytedance/android/live/revenuelink/connect/f;", "connectService", "Lcom/bytedance/android/live/revenuelink/connect/f;", "Lcom/bytedance/android/live/revenuelink/connect/d;", "baseLinkOutListener", "Lcom/bytedance/android/live/revenuelink/connect/d;", "mAutoMatchListener", "Li41/p;", "Lld/a;", "linkDataSet", "Lld/a;", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "roomService", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lyz0/f;", "messageService", "Lyz0/f;", "getAnchorConnectService", "()Lcom/bytedance/android/live/revenuelink/connect/f;", "anchorConnectService", "Li41/a;", "getAutoMatchManager", "()Li41/a;", "autoMatchManager", "Lh41/c;", "getLiveInviteLogger", "()Lh41/c;", "liveInviteLogger", "Lcom/bytedance/android/live/revlink/impl/LinkCrossRoomDataHolder;", "getLinkCrossRoomDataHolder", "()Lcom/bytedance/android/live/revlink/impl/LinkCrossRoomDataHolder;", "linkCrossRoomDataHolder", "Le21/b;", "getClientAttachedInfoObj", "()Le21/b;", "clientAttachedInfoObj", "Lw31/c;", "getPkLinkUtils", "()Lw31/c;", "pkLinkUtils", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/e;", "getLinkOptLogContext", "()Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/e;", "linkOptLogContext", "Lr31/a;", "getLinkNetwork", "()Lr31/a;", "linkNetwork", "Lcom/bytedance/android/live/revlink/impl/utils/s;", "getRevLinkCommonUtil", "()Lcom/bytedance/android/live/revlink/impl/utils/s;", "revLinkCommonUtil", "Lcom/bytedance/android/live/revlink/impl/control/d;", "getAnchorLogParamsService", "()Lcom/bytedance/android/live/revlink/impl/control/d;", "anchorLogParamsService", "Lm41/a;", "getMatchInviteRefuseUtils", "()Lm41/a;", "matchInviteRefuseUtils", "Lcom/bytedance/android/live/revlink/impl/service/internal/a;", "getLinkRevInternalService", "()Lcom/bytedance/android/live/revlink/impl/service/internal/a;", "linkRevInternalService", "Lcom/bytedance/android/live/revlink/impl/pk/service/IPKLinkBizDataService;", "getPKLinkBizDataService", "()Lcom/bytedance/android/live/revlink/impl/pk/service/IPKLinkBizDataService;", "pKLinkBizDataService", "Lcom/bytedance/android/live/revlink/impl/pk/service/i;", "getToolbarPkService", "()Lcom/bytedance/android/live/revlink/impl/pk/service/i;", "toolbarPkService", "getExpectTime", "()J", "expectTime", "isShowNewTip", "isRankRandom", "<init>", "(Lld/a;Lcom/bytedance/android/livesdk/revenue/service/room/c;Lcom/bytedance/android/live/revlink/impl/global/c;Lyz0/f;)V", "Companion", "b", "PKAutoMatchType", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkAutoMatchDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final b Companion = null;
    public static final int SPEED_UP_LEVEL_1 = 1;
    public static final String TAG = "PkAutoMatchDataContext";
    private final MutableLiveData<Long> _leftTime;
    private final MutableLiveData<l41.a> _pkMatchState;
    private final MutableLiveData<Long> _waitedTime;
    private Disposable autoInviteDisposable;
    private b0 autoMatchInfo;
    private af2.e autoMatchModel;
    private int avatarCount;
    private final com.bytedance.android.live.revenuelink.connect.d baseLinkOutListener;
    private boolean canHighWayRandom;
    private final CompositeDisposable cd;
    private final com.bytedance.android.live.revenuelink.connect.f connectService;
    private String currentGameId;
    private int currentMatchStyleType;
    private int currentMatchType;
    private final com.bytedance.live.datacontext.p dismissDialogEvent$delegate;
    private final com.bytedance.live.datacontext.p dismissMatchInviteDialogEvent$delegate;
    private boolean isListenMessage;
    private boolean isMatchSuccess;
    private boolean isSpeedUp;
    private f41.a jsbInvitePkCallback;
    private final LiveData<Long> leftTime;
    private final ld.a linkDataSet;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private com.bytedance.android.live.revenuelink.connect.n linkOutManager;
    private String mActivityName;
    private final i41.p mAutoMatchListener;
    private Disposable mCountDownDisposable;
    private i6 mInviteMessage;
    private NextLiveData<y31.k> mInvitingUserData;
    private boolean mIsInviting;
    private boolean mMatchSuccessNotInvite;
    private IRoom mRoom;
    private boolean mSpeedUpNotSuccess;
    private Disposable mUserAvatarDisposable;
    private List<Object> mUserListWhenInvite;
    private Disposable messageDisposable;
    private final yz0.f messageService;
    private h0 pkAutoMatchLogInfo;
    private final LiveData<l41.a> pkMatchState;
    private p randomMatchInfo;
    private final com.bytedance.android.livesdk.revenue.room.a roomContext;
    private final com.bytedance.android.livesdk.revenue.service.room.c roomService;
    private final com.bytedance.live.datacontext.p showMatchInviteDialogEvent$delegate;
    private final com.bytedance.live.datacontext.p showPopupEvent$delegate;
    private final LiveData<Long> waitedTime;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchDataContext$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass2(PkAutoMatchDataContext r8) {
            super(1, r8, PkAutoMatchDataContext.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(yh6.c r2) {
            ((PkAutoMatchDataContext) ((CallableReference) this).receiver).onMessage(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchDataContext$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass3(PkAutoMatchDataContext r8) {
            super(1, r8, PkAutoMatchDataContext.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(yh6.c r2) {
            ((PkAutoMatchDataContext) ((CallableReference) this).receiver).onMessage(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchDataContext$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass4(PkAutoMatchDataContext r8) {
            super(1, r8, PkAutoMatchDataContext.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(yh6.c r2) {
            ((PkAutoMatchDataContext) ((CallableReference) this).receiver).onMessage(r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/PkAutoMatchDataContext$PKAutoMatchType;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "AUTO_MATCH_TYPE_FAST", "AUTO_MATCH_TYPE_MIDDLE", "AUTO_MATCH_TYPE_SLOW", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum PKAutoMatchType extends Enum<PKAutoMatchType> {
        public static final PKAutoMatchType AUTO_MATCH_TYPE_FAST = null;
        public static final PKAutoMatchType AUTO_MATCH_TYPE_MIDDLE = null;
        public static final PKAutoMatchType AUTO_MATCH_TYPE_SLOW = null;
        public static final /* synthetic */ PKAutoMatchType[] a = null;
        private int value;

        static {
            PKAutoMatchType r2 = new PKAutoMatchType("AUTO_MATCH_TYPE_FAST", 0, 1);
            AUTO_MATCH_TYPE_FAST = r2;
            PKAutoMatchType r3 = new PKAutoMatchType("AUTO_MATCH_TYPE_MIDDLE", 1, 2);
            AUTO_MATCH_TYPE_MIDDLE = r3;
            PKAutoMatchType r4 = new PKAutoMatchType("AUTO_MATCH_TYPE_SLOW", 2, 3);
            AUTO_MATCH_TYPE_SLOW = r4;
            a = new PKAutoMatchType[]{r2, r3, r4};
        }

        public static PKAutoMatchType valueOf(String r1) {
            return (PKAutoMatchType) r27.a.a(PKAutoMatchType.class, r1);
        }

        public static PKAutoMatchType[] values() {
            return (PKAutoMatchType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public final void setValue(int r1) {
            this.value = r1;
        }

        public PKAutoMatchType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a implements Action {
        public final /* synthetic */ PkAutoMatchDataContext a;

        public a(PkAutoMatchDataContext r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.endMatch(AutoMatchSource.Manual);
            this.a.endMatchAndClear();
            com.bytedance.android.live.revenuelink.connect.f r0 = PkAutoMatchDataContext.access$getConnectService$p(this.a);
            if (r0 == null) goto L5;
            r0.removeLinkOutListener(1, PkAutoMatchDataContext.access$getBaseLinkOutListener$p(this.a));
        L5:
            i41.a r1 = PkAutoMatchDataContext.access$getAutoMatchManager$p(this.a);
            if (r1 == null) goto L11;
            i41.p r2 = PkAutoMatchDataContext.access$getMAutoMatchListener$p(this.a);
            Intrinsics.checkNotNullParameter(r2, "listener");
            if (((ArrayList) r1.a).contains(r2) == false) goto L11;
            ((ArrayList) r1.a).remove(r2);
        L11:
            PkAutoMatchDataContext.access$getCd$p(this.a).dispose();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c extends com.bytedance.android.live.revenuelink.connect.d {
        public final /* synthetic */ PkAutoMatchDataContext a;

        public c(PkAutoMatchDataContext r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void Je(int r1, i6 r2, ey.l r3) {
            Intrinsics.checkNotNullParameter(r2, "linkerMessage");
            this.a.getDismissDialogEvent().post(Boolean.TRUE);
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void Tg(int r4, i6 r5, ey.l r6) {
            Intrinsics.checkNotNullParameter(r5, "_linkerMessage");
            i6 r7 = r5.castTo(i6.class);
            k6 r8 = r7.getReply();
            if (r8 != null) goto L5;
            return;
        L5:
            if (e21.a.a(r8.getToBizType()) != true) goto L43;
            k6 r9 = r7.getReply();
            String r0 = null;
            if (r9 == null) goto L10;
            String r10 = r9.getToUid();
        L11:
            y31.k r1 = (y31.k) this.a.getMInvitingUserData().getValue();
            if (r1 == null) goto L18;
            IRoom r2 = r1.b;
            if (r2 == null) goto L18;
            IBaseUser r3 = r2.getOwnerKt();
            if (r3 == null) goto L18;
            String r12 = r3.getIdString();
        L20:
            if (Intrinsics.areEqual(r10, r12) == false) goto L29;
            PkAutoMatchDataContext.access$clearInvitingStatus(this.a);
            k6 r13 = r7.getReply();
            if (r13 == null) goto L29;
            if (((int) r13.getReplyStatus()) != 1) goto L29;
            i41.a r14 = PkAutoMatchDataContext.access$getAutoMatchManager$p(this.a);
            if (r14 == null) goto L28;
            r14.b(AutoMatchSource.ReceiveReplyWhenMatching);
        L28:
            PkAutoMatchDataContext.access$setCanHighWayRandom$p(this.a, false);
        L29:
            k6 r15 = r7.getReply();
            if (r15 != null) goto L32;
            return;
        L32:
            if (((int) r15.getReplyStatus()) != 1) goto L41;
            w31.c r16 = PkAutoMatchDataContext.access$getPkLinkUtils$p(this.a);
            if (r16 == null) goto L36;
            r0 = r16.c();
        L36:
            if (r0 == null) goto L42;
            this.a.getDismissDialogEvent().post(Boolean.TRUE);
            return;
        L42:
            return;
        L41:
            return;
        L18:
            r12 = null;
            goto L20
        L10:
            r10 = null;
            goto L11
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void q9(d11.c r1, long r2, ey.l r4) {
            Intrinsics.checkNotNullParameter(r1, "params");
            Intrinsics.checkNotNullParameter(r1, "params");
            PkAutoMatchDataContext.access$matchLinkAfterCancel(this.a);
            PkAutoMatchDataContext.access$clearInvitingStatus(this.a);
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void hl(d11.d r3, long r4, v4 r6, ey.l r7) {
            Intrinsics.checkNotNullParameter(r3, "params");
            Intrinsics.checkNotNullParameter(r6, "inviteResult");
            if (e21.a.a(r3.i) == true) goto L5;
            return;
        L5:
            super.hl(r3, r4, r6, r7);
            List<Object> r5 = this.a.getMUserListWhenInvite();
            String r8 = null;
            if (r5 == null) goto L27;
            Iterator<T> r9 = r5.iterator();
        L9:
            if (r9.hasNext() == false) goto L27;
            Object r10 = r9.next();
            if ((r10 instanceof y31.k) == true) goto L13;
            Object r12 = null;
        L14:
            y31.k r13 = (y31.k) r12;
            if (r13 == null) goto L19;
            IRoomBase r14 = r13.b;
            if (r14 == null) goto L19;
            Long r15 = Long.valueOf(IRoomKtKt.getId(r14));
        L20:
            IRoomBase r0 = r3.h;
            if (r0 == null) goto L23;
            Long r1 = Long.valueOf(IRoomKtKt.getId(r0));
        L25:
            if (Intrinsics.areEqual(r15, r1) == false) goto L9;
        L29:
            if ((r10 instanceof y31.k) == true) goto L31;
            r10 = null;
        L31:
            y31.k r16 = (y31.k) r10;
            boolean r17 = true;
            if (r16 == null) goto L34;
            r16.m = true;
        L34:
            this.a.getMInvitingUserData().setValue(r16);
            PkAutoMatchDataContext.access$setMIsInviting$p(this.a, false);
            if (r16 == null) goto L55;
            int r18 = r3.d;
            if (r18 != 101) goto L40;
            String r19 = "invite_follow";
        L44:
            if (r19.length() > 0) goto L47;
            r17 = false;
        L47:
            if (r17 == false) goto L49;
            r8 = r19;
        L49:
            if (r8 == null) goto L56;
            PkAutoMatchDataContext.access$logInviteSuccess(this.a, r8);
            return;
        L56:
            return;
        L40:
            if (r18 != 102) goto L42;
            r19 = "invite_recommend";
            goto L44
        L42:
            r19 = "";
            goto L44
        L55:
            return;
        L23:
            r1 = null;
        L19:
            r15 = null;
            goto L20
        L13:
            r12 = r10;
        L27:
            r10 = null;
            goto L29
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void rp(d11.d r1, Throwable r2, long r3, ey.l.b r5) {
            Intrinsics.checkNotNullParameter(r1, "params");
            if (e21.a.a(r1.i) == true) goto L5;
            return;
        L5:
            Intrinsics.checkNotNullParameter(r1, "params");
            if (PkAutoMatchDataContext.access$getMIsInviting$p(this.a) == false) goto L8;
        L18:
            this.a.setMUserListWhenInvite(null);
            PkAutoMatchDataContext.access$setMIsInviting$p(this.a, false);
            return;
        L8:
            if (r1.a != 1) goto L18;
            com.bytedance.android.live.revlink.impl.service.internal.a r4 = PkAutoMatchDataContext.access$getLinkRevInternalService$p(this.a);
            if (r4 == null) goto L18;
            if (com.bytedance.android.live.utils.c.a(r4.getCurrentMode(), 4) == true) goto L18;
            ld.a r6 = PkAutoMatchDataContext.access$getLinkDataSet$p(this.a);
            if (r6 == null) goto L18;
            NextLiveData r7 = r6.ke();
            if (r7 == null) goto L18;
            r7.setValue(0);
            goto L18
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void wh(d11.c r1, Throwable r2, long r3, ey.l r5) {
            Intrinsics.checkNotNullParameter(r1, "params");
            Intrinsics.checkNotNullParameter(r1, "params");
            PkAutoMatchDataContext.access$matchLinkAfterCancel(this.a);
            PkAutoMatchDataContext.access$clearInvitingStatus(this.a);
        }
    }

    public static final class d implements i41.p {
        public final /* synthetic */ PkAutoMatchDataContext a;

        @Override // i41.p
        public final void Bl() {
        }

        @Override // i41.p
        public final void aq() {
            com.bytedance.android.live.revlink.impl.service.internal.a r0 = PkAutoMatchDataContext.access$getLinkRevInternalService$p(this.a);
            if (r0 == null) goto L6;
            r0.Pg();
            return;
        }

        public d(PkAutoMatchDataContext r1) {
            this.a = r1;
        }

        @Override // i41.p
        public final void F8(AutoMatchSource r7) {
            Intrinsics.checkNotNullParameter("", "activityName");
            Intrinsics.checkNotNullParameter(r7, "source");
            com.bytedance.android.live.revlink.impl.service.internal.a r0 = PkAutoMatchDataContext.access$getLinkRevInternalService$p(this.a);
            if (r0 == null) goto L5;
            int r2 = w11.a.a;
            r0.Rg(String.valueOf(2131918016));
        L5:
            PkAutoMatchDataContext.access$logMatchFailedForEnd(this.a, r7);
            this.a.getDismissDialogEvent().post(Boolean.TRUE);
            this.a.setAutoMatchModel(null);
            this.a.setRandomMatchInfo(null);
            this.a.endMatchAndClear();
            LinkCrossRoomDataHolder r8 = PkAutoMatchDataContext.access$getLinkCrossRoomDataHolder$p(this.a);
            if (r8 != null) goto L8;
        L23:
            this.a.setSpeedUp(false);
            this.a.setMatchSuccess(false);
            return;
        L8:
            if (r8.c() != 0) goto L23;
            if (this.a.isMatchSuccess() == true) goto L23;
            com.bytedance.android.live.revlink.impl.pk.service.i r9 = PkAutoMatchDataContext.access$getToolbarPkService$p(this.a);
            if (r9 == null) goto L14;
            r9.W2(0);
        L14:
            com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r10 = PkAutoMatchDataContext.access$getLinkOptLogContext$p(this.a);
            if (r10 == null) goto L17;
            Intrinsics.checkNotNullParameter("", "<set-?>");
            r10.c = "";
        L17:
            com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r12 = PkAutoMatchDataContext.access$getLinkOptLogContext$p(this.a);
            if (r12 == null) goto L20;
            Intrinsics.checkNotNullParameter("", "<set-?>");
            r12.d = "";
        L20:
            i41.a r13 = PkAutoMatchDataContext.access$getAutoMatchManager$p(this.a);
            if (r13 == null) goto L23;
            r13.g = "";
            goto L23
        }

        @Override // i41.p
        public final void x9(i6 r5) {
            Intrinsics.checkNotNullParameter(r5, "message");
            IBattleLinkerInviteMessageExtra r0 = j6.a(r5);
            Integer r1 = null;
            if (r0 != null) goto L5;
        L10:
            PkAutoMatchDataContext r2 = this.a;
            IBattleLinkerInviteMessageExtra r3 = j6.a(r5);
            if (r3 == null) goto L13;
            r1 = Integer.valueOf((int) r3.getInviteType());
        L13:
            PkAutoMatchDataContext.access$logMatchSuccess(r2, "invitee", r1, e21.c.a(r5));
            return;
        L5:
            if (((int) r0.getInviteType()) != 13) goto L10;
            PkAutoMatchDataContext r4 = this.a;
            IBattleLinkerInviteMessageExtra r6 = j6.a(r5);
            if (r6 == null) goto L9;
            r1 = Integer.valueOf((int) r6.getInviteType());
        L9:
            PkAutoMatchDataContext.access$logMatchSuccess(r4, "inviter", r1, e21.c.a(r5));
        }

        @Override // i41.p
        public final void z1(int r2, int r3) {
            if (r2 != AutoMatchService.AutoMatchEvent.START.ordinal()) goto L13;
            i41.a r4 = PkAutoMatchDataContext.access$getAutoMatchManager$p(this.a);
            if (r4 == null) goto L7;
            r4.f = true;
        L7:
            com.bytedance.android.live.revlink.impl.pk.service.i r5 = PkAutoMatchDataContext.access$getToolbarPkService$p(this.a);
            if (r5 == null) goto L10;
            r5.P2(RingDrawable.ttlive_ic_pk_random_normal_circle);
        L10:
            com.bytedance.android.live.revlink.impl.service.internal.a r6 = PkAutoMatchDataContext.access$getLinkRevInternalService$p(this.a);
            if (r6 == null) goto L20;
            r6.Pg();
            return;
        L20:
            return;
        L13:
            i41.a r7 = PkAutoMatchDataContext.access$getAutoMatchManager$p(this.a);
            if (r7 == null) goto L16;
            r7.f = false;
        L16:
            com.bytedance.android.live.revlink.impl.pk.service.i r8 = PkAutoMatchDataContext.access$getToolbarPkService$p(this.a);
            if (r8 == null) goto L22;
            r8.n3(true);
            return;
        }

        @Override // i41.p
        public final void Nh(af2.e r12, String r13, p r14) {
            Intrinsics.checkNotNullParameter(r12, "autoMatch");
            Intrinsics.checkNotNullParameter(r13, "activityName");
            this.a.setAutoMatchModel(r12);
            this.a.setRandomMatchInfo(r14);
            PkAutoMatchDataContext.access$setMMatchSuccessNotInvite$p(this.a, true);
            PkAutoMatchDataContext.access$setCanHighWayRandom$p(this.a, false);
            this.a.setMatchSuccess(true);
            i41.a r0 = PkAutoMatchDataContext.access$getAutoMatchManager$p(this.a);
            if (r0 == null) goto L5;
            r0.b(AutoMatchSource.MatchSuccess);
        L5:
            this.a.endMatchAndClear();
            PkAutoMatchDataContext r3 = this.a;
            if (r14 == null) goto L8;
            p0 r6 = r14.a;
        L9:
            PkAutoMatchDataContext.logMatchSuccess$default(r3, "inviter", null, r6, 2, null);
            if (this.a.getMInvitingUserData().getValue() == null) goto L16;
            y31.k r15 = (y31.k) this.a.getMInvitingUserData().getValue();
            if (r15 != null) goto L14;
            return;
        L14:
            if (r15.b == null) goto L19;
            this.a.cancelInvite(null);
            mz0.n r16 = new mz0.n();
            mz0.m r17 = new mz0.m();
            r17.b(LogCommon.ROOM);
            ((ArrayList) r16.b).addAll(r17.a);
            cy0.e.a.getClass();
            cy0.j r18 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r19 = com.bytedance.android.scope.m.b(r18).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r19);
            ((mz0.i) ((f80.a) r19)).w3("livesdk_random_instead_invite", r16.a, r16.b);
            return;
        L19:
            return;
        L16:
            this.a.setAutoMatchModel(null);
            this.a.setRandomMatchInfo(null);
            PkAutoMatchDataContext r4 = this.a;
            r4.handleAutoMatchInvite(r12, r4.getCurrentMatchType(), r13, this.a.getCurrentGameId(), r14);
            this.a.setCurrentMatchType(1);
            this.a.setCurrentMatchStyleType(0);
            return;
        L8:
            r6 = null;
            goto L9
        }

        @Override // i41.p
        public final void Ug(r4 r3, boolean r4, String r5) {
            Intrinsics.checkNotNullParameter(r5, "activityName");
            i41.a r0 = PkAutoMatchDataContext.access$getAutoMatchManager$p(this.a);
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.f != true) goto L21;
            f41.a r1 = this.a.getJsbInvitePkCallback();
            if (r1 == null) goto L13;
            com.bytedance.android.live.revlink.impl.service.internal.a r2 = PkAutoMatchDataContext.access$getLinkRevInternalService$p(this.a);
            if (r2 == null) goto L12;
            r2.m();
        L12:
            r1.a();
            this.a.setJsbInvitePkCallback(null);
        L13:
            if (r4 == false) goto L16;
            this.a.setAutoMatchModel(r3);
            PkAutoMatchDataContext.access$setCanHighWayRandom$p(this.a, r3.getCanHighWay());
            this.a.startMatchCountDown(r3, r5);
        L16:
            if (PkAutoMatchDataContext.access$getMSpeedUpNotSuccess$p(this.a) == false) goto L20;
            LinkedHashMap r6 = new LinkedHashMap();
            r6.put("action", "search");
            mz0.n r7 = new mz0.n();
            Map<String, String> r8 = r7.a;
            Intrinsics.checkNotNullParameter(r8, "map");
            Intrinsics.checkNotNullParameter(r6, "map");
            r8.putAll(r6);
            mz0.m r9 = new mz0.m();
            r9.b(LogCommon.ROOM);
            List<Object> r10 = r7.b;
            ArrayList r12 = (ArrayList) r10;
            r12.addAll(r9.a);
            cy0.e.a.getClass();
            cy0.j r13 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r14);
            ((mz0.i) ((f80.a) r14)).w3("livesdk_pk_search_banner_click_success", r7.a, r7.b);
            PkAutoMatchDataContext.access$setMSpeedUpNotSuccess$p(this.a, false);
            return;
        L20:
            return;
        }

        @Override // i41.p
        public final void qn(boolean r5, boolean r6, AutoMatchSource r7) {
            Intrinsics.checkNotNullParameter(r7, "source");
            if (r5 == false) goto L10;
            if (r6 == true) goto L6;
        L9:
            this.a.endMatch(r7);
        L17:
            com.bytedance.android.live.revlink.impl.pk.service.i r8 = PkAutoMatchDataContext.access$getToolbarPkService$p(this.a);
            if (r8 == null) goto L20;
            r8.W2(0);
        L20:
            this.a.setAutoMatchModel(null);
            this.a.setRandomMatchInfo(null);
            this.a.setCurrentMatchStyleType(0);
            PkAutoMatchDataContext.access$setCanHighWayRandom$p(this.a, false);
            PkAutoMatchDataContext.access$logFailedToastShow(this.a, r7);
            this.a.setCurrentGameId(null);
            this.a.setCurrentMatchType(1);
            return;
        L6:
            if (this.a.getCurrentMatchType() != 12) goto L8;
            int r9 = ToastUtil.a;
            int r10 = w11.a.a;
            ToastUtil.a(2131921527, 1);
            goto L9
        L8:
            int r12 = ToastUtil.a;
            int r13 = w11.a.a;
            ToastUtil.a(2131921528, 1);
            goto L9
        L10:
            this.a.endMatchAndClear();
            if (r6 == true) goto L13;
        L16:
            this.a.endMatch(r7);
            this.a.getDismissDialogEvent().post(Boolean.TRUE);
            goto L17
        L13:
            if (this.a.getCurrentMatchType() != 12) goto L15;
            int r14 = ToastUtil.a;
            int r15 = w11.a.a;
            ToastUtil.a(2131921527, 1);
            goto L16
        L15:
            int r16 = ToastUtil.a;
            int r17 = w11.a.a;
            ToastUtil.a(2131921528, 1);
            goto L16
        }

        @Override // i41.p
        public final void r4(long r3, long r5, com.bytedance.android.livesdk.link.model.h0 r7) {
            Intrinsics.checkNotNullParameter(r7, "previewUser");
            PkAutoMatchDataContext.access$get_waitedTime$p(this.a).setValue(Long.valueOf(r5));
            MutableLiveData r0 = PkAutoMatchDataContext.access$get_leftTime$p(this.a);
            long r4 = r3 - r5;
            if (r4 < 0) goto L5;
            long r6 = Long.valueOf(r4);
        L6:
            r0.setValue(r6);
            com.bytedance.android.live.revlink.impl.pk.service.i r8 = PkAutoMatchDataContext.access$getToolbarPkService$p(this.a);
            if (r8 == null) goto L10;
            r8.e3(r7.getAvatar());
            return;
        L10:
            return;
        L5:
            r6 = 0L;
            goto L6
        }
    }

    public final /* synthetic */ class e implements Consumer {
        public final /* synthetic */ Function1 a;

        public e(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ PkAutoMatchDataContext a;
        public final /* synthetic */ r4 b;

        public f(PkAutoMatchDataContext r1, r4 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            Long r8 = (Long) r7;
            Long r9 = (Long) PkAutoMatchDataContext.access$get_waitedTime$p(this.a).getValue();
            if (r9 == null) goto L5;
            PkAutoMatchDataContext.access$get_waitedTime$p(this.a).setValue(Long.valueOf(r9.longValue() + 1));
        L5:
            long r0 = this.a.getExpectTime();
            Long r10 = (Long) PkAutoMatchDataContext.access$get_waitedTime$p(this.a).getValue();
            long r2 = 0;
            if (r10 != null) goto L8;
            r10 = 0L;
        L8:
            long r1 = r0 - r10.longValue();
            if (r1 < 0) goto L13;
            r2 = r1;
        L13:
            if (this.b.getShowNewTips() == true) goto L15;
        L24:
            PkAutoMatchDataContext.access$get_leftTime$p(this.a).setValue(Long.valueOf(r2));
            return;
        L15:
            if (this.a.isRankRandom() == false) goto L24;
            if (this.b.getShowNewTips() == false) goto L24;
            Long r12 = (Long) PkAutoMatchDataContext.access$get_leftTime$p(this.a).getValue();
            if (r12 != null) goto L22;
        L23:
            PkAutoMatchDataContext.access$showServerControlPopup(this.a, r2);
            goto L24
        L22:
            if (r2 == r12.longValue()) goto L24;
            goto L23
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ PkAutoMatchDataContext a;
        public final /* synthetic */ r4 b;

        public g(PkAutoMatchDataContext r1, r4 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            PkAutoMatchDataContext r6 = this.a;
            PkAutoMatchDataContext.access$setAvatarCount$p(r6, PkAutoMatchDataContext.access$getAvatarCount$p(r6) + 1);
            if ((!this.b.getPreviewUserList().isEmpty()) == false) goto L8;
            List r7 = this.b.getPreviewUserList();
            com.bytedance.android.live.revlink.impl.pk.service.i r0 = PkAutoMatchDataContext.access$getToolbarPkService$p(this.a);
            if (r0 == null) goto L9;
            r0.e3(((com.bytedance.android.livesdk.link.model.h0) ListProtector.get(r7, PkAutoMatchDataContext.access$getAvatarCount$p(this.a) % r7.size())).getAvatar());
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchDataContext$startMatch$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class C03681 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public C03681(PkAutoMatchDataContext r8) {
            super(1, r8, PkAutoMatchDataContext.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(yh6.c r2) {
            ((PkAutoMatchDataContext) ((CallableReference) this).receiver).onMessage(r2);
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(PkAutoMatchDataContext.class, "showPopupEvent", "getShowPopupEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(PkAutoMatchDataContext.class, "dismissDialogEvent", "getDismissDialogEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(PkAutoMatchDataContext.class, "showMatchInviteDialogEvent", "getShowMatchInviteDialogEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(PkAutoMatchDataContext.class, "dismissMatchInviteDialogEvent", "getDismissMatchInviteDialogEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
        Companion = new b();
    }

    public final void endMatchAndClear() {
        this.autoMatchInfo = null;
        getDismissDialogEvent().post(Boolean.TRUE);
        Disposable r1 = this.mCountDownDisposable;
        if (r1 != null) goto L5;
    L10:
        Disposable r2 = this.mUserAvatarDisposable;
        if (r2 != null) goto L13;
    L18:
        this.currentMatchStyleType = 0;
        this.mUserListWhenInvite = null;
        this.mIsInviting = false;
        this._pkMatchState.setValue(l41.a.C0265a.a);
        Disposable r0 = this.messageDisposable;
        if (r0 == null) goto L21;
        r0.dispose();
    L21:
        this.isListenMessage = false;
        Disposable r3 = this.autoInviteDisposable;
        if (r3 == null) goto L25;
        r3.dispose();
        return;
    L25:
        return;
    L13:
        if ((!r2.isDisposed()) == true) goto L16;
        r2 = null;
    L16:
        if (r2 == null) goto L18;
        r2.dispose();
        this.mUserAvatarDisposable = null;
        goto L18
    L5:
        if ((!r1.isDisposed()) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L10;
        r1.dispose();
        this.mCountDownDisposable = null;
        goto L10
    }

    public final com.bytedance.live.datacontext.k<Boolean> getDismissDialogEvent() {
        return (com.bytedance.live.datacontext.k) this.dismissDialogEvent$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.k<Boolean> getDismissMatchInviteDialogEvent() {
        return (com.bytedance.live.datacontext.k) this.dismissMatchInviteDialogEvent$delegate.a(this, $$delegatedProperties[3]);
    }

    public final com.bytedance.live.datacontext.k<s> getShowMatchInviteDialogEvent() {
        return (com.bytedance.live.datacontext.k) this.showMatchInviteDialogEvent$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.live.datacontext.k<String> getShowPopupEvent() {
        return (com.bytedance.live.datacontext.k) this.showPopupEvent$delegate.a(this, $$delegatedProperties[0]);
    }

    private final void clearInvitingStatus() {
        y31.k r0 = (y31.k) this.mInvitingUserData.getValue();
        if (r0 == null) goto L5;
        r0.m = false;
    L5:
        this.mInvitingUserData.setValue(null);
        this.mUserListWhenInvite = null;
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

    private final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e getLinkOptLogContext() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkOptLogContext();
    }

    private final com.bytedance.android.live.revlink.impl.service.internal.a getLinkRevInternalService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Do();
    }

    private final h41.c getLiveInviteLogger() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLiveInviteLogger();
    }

    private final m41.a getMatchInviteRefuseUtils() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMatchInviteRefuseUtils();
    }

    private final IPKLinkBizDataService getPKLinkBizDataService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mk();
    }

    private final w31.c getPkLinkUtils() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkLinkUtils();
    }

    private final com.bytedance.android.live.revlink.impl.utils.s getRevLinkCommonUtil() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRevLinkCommonUtil();
    }

    private final com.bytedance.android.live.revlink.impl.pk.service.i getToolbarPkService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Hg();
    }

    private final void matchLinkAfterCancel() {
        if (this.mMatchSuccessNotInvite == false) goto L11;
        af2.e r4 = this.autoMatchModel;
        if (r4 == null) goto L7;
        handleAutoMatchInvite$default(this, r4, 1, "", null, this.randomMatchInfo, 8, null);
        this.autoMatchModel = null;
    L7:
        this.mMatchSuccessNotInvite = false;
        y31.k r0 = (y31.k) this.mInvitingUserData.getValue();
        if (r0 == null) goto L10;
        r0.m = false;
    L10:
        this.mInvitingUserData.setValue(null);
    L11:
        i6 r1 = this.mInviteMessage;
        if (r1 == null) goto L31;
        IBattleLinkerInviteMessageExtra r3 = j6.a(r1);
        if (r3 == null) goto L18;
        int r5 = (int) r3.getMatchType();
        boolean r6 = true;
        if (r5 != 1) goto L18;
    L19:
        if (r6 == true) goto L22;
        r1 = null;
    L22:
        if (r1 == null) goto L32;
        y31.k r7 = (y31.k) this.mInvitingUserData.getValue();
        if (r7 == null) goto L26;
        r7.m = false;
    L26:
        this.mInvitingUserData.setValue(null);
        com.bytedance.android.live.revenuelink.connect.n r2 = this.linkOutManager;
        if (r2 == null) goto L29;
        r2.c(r1);
    L29:
        this.mInviteMessage = null;
        return;
    L32:
        return;
    L18:
        r6 = false;
        goto L19
    }

    private final void showPopup() {
        b0 r0 = this.autoMatchInfo;
        if (r0 == null) goto L10;
        c0 r1 = r0.getConfig();
        if (r1 == null) goto L10;
        if (((int) r1.getPkAutoMatchIndex()) != PKAutoMatchType.AUTO_MATCH_TYPE_SLOW.getValue()) goto L10;
        com.bytedance.live.datacontext.k<String> r2 = getShowPopupEvent();
        x41.a r3 = x41.a.f;
        r3.getClass();
        r2.post(((r11.m) x41.a.c.getValue(r3, x41.a.a[1])).I7());
        return;
    L10:
        if (this.currentMatchType != 12) goto L12;
        com.bytedance.live.datacontext.k<String> r4 = getShowPopupEvent();
        x41.a r5 = x41.a.f;
        r5.getClass();
        r4.post(((r11.m) x41.a.c.getValue(r5, x41.a.a[1])).C8());
        return;
    L12:
        com.bytedance.live.datacontext.k<String> r6 = getShowPopupEvent();
        x41.a r7 = x41.a.f;
        r7.getClass();
        r6.post(((r11.m) x41.a.c.getValue(r7, x41.a.a[1])).i8());
    }

    public final long getExpectTime() {
        af2.e r0 = this.autoMatchModel;
        if ((r0 instanceof r4) == true) goto L5;
        r0 = null;
    L5:
        r4 r1 = (r4) r0;
        if (r1 != null) goto L8;
    L12:
        b0 r2 = this.autoMatchInfo;
        if (r2 != null) goto L15;
        return 60;
    L15:
        return r2.getWaitSec();
    L8:
        if (r1.getShowNewTips() != true) goto L12;
        af2.e r3 = this.autoMatchModel;
        if (r3 != null) goto L17;
        return 60;
    L17:
        return r3.getExpectTime();
    }

    public final boolean isInviting() {
        if (this.mIsInviting == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mInvitingUserData.getValue() != null) goto L8;
        return false;
    }

    public final boolean isRankRandom() {
        if (this.currentMatchType != 13) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isShowNewTip() {
        af2.e r0 = this.autoMatchModel;
        if ((r0 instanceof r4) == true) goto L5;
        r0 = null;
    L5:
        r4 r1 = (r4) r0;
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.getShowNewTips() != true) goto L10;
        return true;
    }

    public final List<i41.p> getListeners() {
        i41.a r0 = getAutoMatchManager();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public final void clearIt() {
        onCleared();
    }

    public final b0 getAutoMatchInfo() {
        return this.autoMatchInfo;
    }

    public final af2.e getAutoMatchModel() {
        return this.autoMatchModel;
    }

    public final boolean getCanHighWayRandom() {
        return this.canHighWayRandom;
    }

    public final String getCurrentGameId() {
        return this.currentGameId;
    }

    public final int getCurrentMatchStyleType() {
        return this.currentMatchStyleType;
    }

    public final int getCurrentMatchType() {
        return this.currentMatchType;
    }

    public final f41.a getJsbInvitePkCallback() {
        return this.jsbInvitePkCallback;
    }

    public final LiveData<Long> getLeftTime() {
        return this.leftTime;
    }

    public final String getMActivityName() {
        return this.mActivityName;
    }

    public final NextLiveData<y31.k> getMInvitingUserData() {
        return this.mInvitingUserData;
    }

    public final List<Object> getMUserListWhenInvite() {
        return this.mUserListWhenInvite;
    }

    public final LiveData<l41.a> getPkMatchState() {
        return this.pkMatchState;
    }

    public final p getRandomMatchInfo() {
        return this.randomMatchInfo;
    }

    public final LiveData<Long> getWaitedTime() {
        return this.waitedTime;
    }

    public final boolean isMatchSuccess() {
        return this.isMatchSuccess;
    }

    public final boolean isSpeedUp() {
        return this.isSpeedUp;
    }

    public final h0 pkAutoMatchLogInfo() {
        return this.pkAutoMatchLogInfo;
    }

    public static final /* synthetic */ void access$clearInvitingStatus(PkAutoMatchDataContext r0) {
        r0.clearInvitingStatus();
    }

    public static final /* synthetic */ i41.a access$getAutoMatchManager$p(PkAutoMatchDataContext r0) {
        return r0.getAutoMatchManager();
    }

    public static final /* synthetic */ int access$getAvatarCount$p(PkAutoMatchDataContext r0) {
        return r0.avatarCount;
    }

    public static final /* synthetic */ com.bytedance.android.live.revenuelink.connect.d access$getBaseLinkOutListener$p(PkAutoMatchDataContext r0) {
        return r0.baseLinkOutListener;
    }

    public static final /* synthetic */ boolean access$getCanHighWayRandom$p(PkAutoMatchDataContext r0) {
        return r0.canHighWayRandom;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(PkAutoMatchDataContext r0) {
        return r0.cd;
    }

    public static final /* synthetic */ com.bytedance.android.live.revenuelink.connect.f access$getConnectService$p(PkAutoMatchDataContext r0) {
        return r0.connectService;
    }

    public static final /* synthetic */ LinkCrossRoomDataHolder access$getLinkCrossRoomDataHolder$p(PkAutoMatchDataContext r0) {
        return r0.getLinkCrossRoomDataHolder();
    }

    public static final /* synthetic */ ld.a access$getLinkDataSet$p(PkAutoMatchDataContext r0) {
        return r0.linkDataSet;
    }

    public static final /* synthetic */ com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e access$getLinkOptLogContext$p(PkAutoMatchDataContext r0) {
        return r0.getLinkOptLogContext();
    }

    public static final /* synthetic */ com.bytedance.android.live.revlink.impl.service.internal.a access$getLinkRevInternalService$p(PkAutoMatchDataContext r0) {
        return r0.getLinkRevInternalService();
    }

    public static final /* synthetic */ i41.p access$getMAutoMatchListener$p(PkAutoMatchDataContext r0) {
        return r0.mAutoMatchListener;
    }

    public static final /* synthetic */ boolean access$getMIsInviting$p(PkAutoMatchDataContext r0) {
        return r0.mIsInviting;
    }

    public static final /* synthetic */ boolean access$getMMatchSuccessNotInvite$p(PkAutoMatchDataContext r0) {
        return r0.mMatchSuccessNotInvite;
    }

    public static final /* synthetic */ IRoom access$getMRoom$p(PkAutoMatchDataContext r0) {
        return r0.mRoom;
    }

    public static final /* synthetic */ boolean access$getMSpeedUpNotSuccess$p(PkAutoMatchDataContext r0) {
        return r0.mSpeedUpNotSuccess;
    }

    public static final /* synthetic */ h0 access$getPkAutoMatchLogInfo$p(PkAutoMatchDataContext r0) {
        return r0.pkAutoMatchLogInfo;
    }

    public static final /* synthetic */ w31.c access$getPkLinkUtils$p(PkAutoMatchDataContext r0) {
        return r0.getPkLinkUtils();
    }

    public static final /* synthetic */ com.bytedance.android.live.revlink.impl.pk.service.i access$getToolbarPkService$p(PkAutoMatchDataContext r0) {
        return r0.getToolbarPkService();
    }

    public static final /* synthetic */ MutableLiveData access$get_leftTime$p(PkAutoMatchDataContext r0) {
        return r0._leftTime;
    }

    public static final /* synthetic */ MutableLiveData access$get_waitedTime$p(PkAutoMatchDataContext r0) {
        return r0._waitedTime;
    }

    public static final /* synthetic */ void access$matchLinkAfterCancel(PkAutoMatchDataContext r0) {
        r0.matchLinkAfterCancel();
    }

    private final void logFailedToastShow(AutoMatchSource r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (this.currentMatchType != 12) goto L5;
        String r1 = "game_matching";
    L6:
        r0.put("match_type", r1);
        r0.put("room_status", "live");
        String r3 = DataType.FALSE;
        r0.put("anchor_connect_status", DataType.FALSE);
        IPKLinkBizDataService r2 = getPKLinkBizDataService();
        if (r2 != null) goto L9;
    L11:
        r0.put("is_rematch", r3);
        r0.put("reason", com.bytedance.android.live.revlink.impl.pk.utils.b.a(r6));
        if (this.currentMatchType != 12) goto L17;
        String r7 = this.currentGameId;
        if (r7 != null) goto L16;
        r7 = "";
    L16:
        r0.put("open_game_app_id", r7);
    L17:
        this.pkAutoMatchLogInfo.a(r0);
        mz0.n r8 = new mz0.n();
        Map<String, String> r4 = r8.a;
        Intrinsics.checkNotNullParameter(r4, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r4.putAll(r0);
        mz0.m r5 = new mz0.m();
        r5.b(LogCommon.ROOM);
        List<Object> r9 = r8.b;
        ArrayList r10 = (ArrayList) r9;
        r10.addAll(r5.a);
        cy0.e.a.getClass();
        cy0.j r12 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r12).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r13);
        ((mz0.i) ((f80.a) r13)).w3("livesdk_pk_match_fail_toast_show", r8.a, r8.b);
        return;
    L9:
        if (r2.getIsRandomReMatch() != true) goto L11;
        r3 = DataType.TRUE;
        goto L11
    L5:
        r1 = "single";
        goto L6
    }

    private final void logInviteSuccess(String r8) {
        LinkedHashMap r0 = new LinkedHashMap();
        Long r1 = (Long) this._leftTime.getValue();
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = (int) r1.longValue();
    L6:
        if (r3 <= 0) goto L17;
        long r4 = r3;
        b0 r5 = this.autoMatchInfo;
        if (r5 == null) goto L12;
        c0 r6 = r5.getConfig();
        if (r6 == null) goto L12;
        long r7 = r6.getInviteLimitSec();
    L14:
        if (r4 > r7) goto L17;
    L20:
        r0.put("speedup_status", String.valueOf(r2));
        b0 r9 = this.autoMatchInfo;
        if (r9 == null) goto L25;
        c0 r10 = r9.getConfig();
        if (r10 == null) goto L25;
        long r12 = r10.getPkAutoMatchIndex();
    L26:
        r0.put("pk_automatch_type", String.valueOf(r12));
        r0.put("action", r8);
        mz0.n r13 = new mz0.n();
        Map<String, String> r14 = r13.a;
        Intrinsics.checkNotNullParameter(r14, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r14.putAll(r0);
        mz0.m r15 = new mz0.m();
        r15.b(LogCommon.ROOM);
        ((ArrayList) r13.b).addAll(r15.a);
        cy0.e.a.getClass();
        cy0.j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r17);
        ((mz0.i) ((f80.a) r17)).w3("livesdk_pk_match_banner_click_success", r13.a, r13.b);
        return;
    L25:
        r12 = 0;
    L12:
        r7 = 10;
    L17:
        if (this.isSpeedUp == false) goto L19;
        r2 = 2;
        goto L20
    L19:
        r2 = 1;
        goto L20
    L5:
        r3 = 0;
        goto L6
    }

    private final void logLargeMatchInvited(z1 r12) {
        o1 r0 = e21.d.a(r12);
        if (r0 == null) goto L44;
        List r1 = r0.getInviteUsers();
        if (r1 == null) goto L55;
        List r2 = CollectionsKt.toList(r1);
        if (r2 == null) goto L56;
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L25;
        Object r5 = r4.next();
        p1 r6 = (p1) r5;
        if (r6 != null) goto L14;
    L22:
        boolean r7 = false;
    L23:
        if (r7 == false) goto L10;
        r3.add(r5);
        goto L10
    L14:
        if (r6.getUserID() == null) goto L22;
        if (r6.getRoomID() == null) goto L22;
        Long r8 = r6.getUserID();
        Intrinsics.checkNotNull(r8);
        if (r8.longValue() == 0) goto L22;
        Long r9 = r6.getRoomID();
        Intrinsics.checkNotNull(r9);
        if (r9.longValue() == 0) goto L22;
        r7 = true;
        goto L23
    L25:
        Iterator r10 = r3.iterator();
    L27:
        if (r10.hasNext() == false) goto L57;
        p1 r13 = (p1) r10.next();
        mz0.n r14 = new mz0.n();
        mz0.o r15 = new mz0.o(r14.a);
        r15.a("invite_type", "anchor");
        r15.a("source", "pk_banner");
        r15.a("connection_type", "random_pk");
        r15.a("anchor_connection_type", "invite");
        r15.a("if_strategy_invite", DataType.TRUE);
        r15.a("invite_mode", "routine_pk");
        r15.a("room_status", "live");
        String r16 = "";
        r15.a("connection_sub_type", "");
        r15.a("is_oncemore", DataType.FALSE);
        r15.a("anchor_connect_status", DataType.FALSE);
        r15.a("audience_connect_cnt", String.valueOf(n41.a.b()));
        r15.a("is_random_match", DataType.TRUE);
        r15.a("is_random_link_match", DataType.FALSE);
        if (r13 == null) goto L34;
        Long r17 = r13.getRoomID();
        if (r17 == null) goto L34;
        String r18 = String.valueOf(r17.longValue());
        if (r18 == null) goto L34;
    L35:
        r15.a("invitee_room_id", r18);
        r15.a("list_num", DataType.FALSE);
        if (r13 == null) goto L43;
        Long r19 = r13.getUserID();
        if (r19 == null) goto L43;
        String r20 = String.valueOf(r19.longValue());
        if (r20 == null) goto L43;
        r16 = r20;
    L43:
        r15.a("invitee_id", r16);
        r15.a("invitee_list", "strategy_invite");
        r15.a("invitee_room_status", "live");
        r15.a("invitee_connect_cnt", DataType.FALSE);
        e21.c.e(r15, e21.c.c(p0.Companion, r12.getBattleAttachedInfoStr()));
        cy0.e.a.getClass();
        cy0.j r22 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r23 = com.bytedance.android.scope.m.b(r22).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r23);
        ((mz0.i) ((f80.a) r23)).w3("livesdk_connection_invite", r14.a, r14.b);
    L34:
        r18 = "";
        goto L35
    L57:
        return;
    L56:
        return;
    L55:
        return;
    }

    private final void logLargeStrategyLifeCycle(z1 r9) {
        boolean r4 = true;
        if (r9.getType() != BattleNotifyMessageType.LargeMatchStart.ordinal()) goto L5;
        boolean r0 = true;
    L6:
        String r1 = r9.getBattleAttachedInfoStr();
        if (r9.getType() == BattleNotifyMessageType.LargeMatchEnd.ordinal()) goto L10;
        r4 = false;
    L10:
        logLargeStrategyLifeCycle(r0, r1, r4);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void logMatchFailedForEnd(AutoMatchSource r4) {
        if (CollectionsKt.listOf(new AutoMatchSource[]{AutoMatchSource.ReceiveReplyWhenMatching, AutoMatchSource.ReceiveMultiInviteWhenMatching, AutoMatchSource.ReceiveDoubleInviteWhenMatching, AutoMatchSource.ReceivePrecisionMatchMsg}).contains(r4) == true) goto L5;
        return;
    L5:
        logFailedToastShow(r4);
    }

    private final void onBattleNotifyPointMsg(z1 r9) {
        Intrinsics.checkNotNullParameter(r9, "$this$isDoubleMsg");
        o1 r0 = e21.d.a(r9);
        boolean r2 = false;
        if (r0 == null) goto L5;
        r2 = CollectionsKt.listOf(new Integer[]{1, 3, 8, 8, 13}).contains(Integer.valueOf((int) r0.getMatchType()));
    L5:
        if (r2 == true) goto L7;
        return;
    L7:
        long r3 = r9.getType();
        if (r3 != BattleNotifyMessageType.LargeMatchStart.ordinal()) goto L11;
        this.pkAutoMatchLogInfo.e = true;
        logLargeStrategyLifeCycle(r9);
        logLargeMatchInvited(r9);
        return;
    L11:
        if (r3 != BattleNotifyMessageType.LargeMatchEnd.ordinal()) goto L15;
        logLargeStrategyLifeCycle(r9);
        return;
    }

    private final void showServerControlPopup(long r12) {
        af2.e r0 = this.autoMatchModel;
        if (r0 == null) goto L26;
        long r1 = r0.getExpectTime();
        if (r1 > 0) goto L8;
        return;
    L8:
        if (r12 != (r1 / ((long) 2))) goto L14;
        com.bytedance.live.datacontext.k<String> r13 = getShowPopupEvent();
        x41.a r14 = x41.a.f;
        r14.getClass();
        String r15 = (String) ((Map) x41.a.d.getValue(r14, x41.a.a[2])).get(Float.valueOf(0.5f));
        if (r15 != null) goto L12;
        com.bytedance.live.kmp.util.c r16 = com.bytedance.live.kmp.util.c.a;
        int r17 = w11.a.a;
        r15 = com.bytedance.live.kmp.util.c.a(2131921512, new Object[0]);
    L12:
        r13.post(r15);
        return;
    L14:
        if (r12 != 0) goto L20;
        com.bytedance.live.datacontext.k<String> r18 = getShowPopupEvent();
        x41.a r19 = x41.a.f;
        r19.getClass();
        String r110 = (String) ((Map) x41.a.d.getValue(r19, x41.a.a[2])).get(Float.valueOf(0.5f));
        if (r110 != null) goto L18;
        com.bytedance.live.kmp.util.c r111 = com.bytedance.live.kmp.util.c.a;
        int r112 = w11.a.a;
        r110 = com.bytedance.live.kmp.util.c.a(2131921513, new Object[0]);
    L18:
        r18.post(r110);
        return;
    L20:
        if (r12 != r1) goto L29;
        com.bytedance.live.datacontext.k<String> r113 = getShowPopupEvent();
        x41.a r114 = x41.a.f;
        r114.getClass();
        String r115 = (String) ((Map) x41.a.d.getValue(r114, x41.a.a[2])).get(Float.valueOf(0.5f));
        if (r115 != null) goto L24;
        com.bytedance.live.kmp.util.c r116 = com.bytedance.live.kmp.util.c.a;
        int r117 = w11.a.a;
        r115 = com.bytedance.live.kmp.util.c.a(2131921511, new Object[0]);
    L24:
        r113.post(r115);
        return;
    L29:
        return;
    }

    public final void cancelInvite(i6 r15) {
        this.mInviteMessage = r15;
        y31.k r0 = (y31.k) this.mInvitingUserData.getValue();
        if (r0 == null) goto L5;
        IRoom r1 = r0.b;
    L6:
        if (r1 == null) goto L22;
        com.bytedance.android.live.revenuelink.connect.n r2 = this.linkOutManager;
        if (r2 == null) goto L22;
        LinkCrossRoomDataHolder r3 = getLinkCrossRoomDataHolder();
        if (r3 == null) goto L12;
        long r5 = r3.c();
    L13:
        long r7 = IRoomKtKt.getId((IRoomBase) r1);
        IBaseUser r4 = r1.getOwnerKt();
        if (r4 == null) goto L16;
        String r9 = r4.getIdString();
    L17:
        IBaseUser r6 = r1.getOwnerKt();
        if (r6 == null) goto L20;
        Intrinsics.checkNotNullParameter(r6, "$this$secUidExt");
        String r10 = r6.getCastSecUid();
    L21:
        r2.e(new d11.c(1, r5, r7, r9, r10, 0, "click_cancel_auto_match"), null);
        goto L22
    L20:
        r10 = null;
        goto L21
    L16:
        r9 = null;
        goto L17
    L12:
        r5 = 0;
    L22:
        if (r15 == null) goto L25;
        mz0.n r16 = new mz0.n();
        mz0.m r8 = new mz0.m();
        r8.b(LogCommon.ROOM);
        ((ArrayList) r16.b).addAll(r8.a);
        cy0.e.a.getClass();
        cy0.j r12 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r12).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r13);
        ((mz0.i) ((f80.a) r13)).w3("livesdk_random_instead_invite", r16.a, r16.b);
        return;
    L25:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void endMatch(AutoMatchSource r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        this.canHighWayRandom = false;
        i41.a r1 = getAutoMatchManager();
        if (r1 == null) goto L6;
        r1.b(r3);
    L6:
        if (((y31.k) this.mInvitingUserData.getValue()) == null) goto L8;
        cancelInvite(null);
    L8:
        Disposable r4 = this.messageDisposable;
        if (r4 == null) goto L11;
        r4.dispose();
    L11:
        this.isListenMessage = false;
        Disposable r5 = this.autoInviteDisposable;
        if (r5 == null) goto L15;
        r5.dispose();
        return;
    }

    public final void onMessage(yh6.c r12) {
        if (r41.b.a == false) goto L5;
        return;
    L5:
        boolean r1 = true;
        int r2 = 0;
        s4 r4 = null;
        if ((r12 instanceof com.bytedance.android.livesdk.link.model.bridge.n) == false) goto L38;
        s0 r13 = ((vh7.c) r12).castTo(s0.class);
        if ((!Intrinsics.areEqual((l41.a) this.pkMatchState.getValue(), l41.a.b.a)) == true) goto L36;
        if (r13 == null) goto L16;
        s4 r0 = r13.getData();
        if (r0 == null) goto L16;
        if (x.a((int) r0.getMatchType()) != true) goto L16;
        return;
    L16:
        if (r13 == null) goto L20;
        s4 r5 = r13.getData();
        if (r5 == null) goto L20;
        String r6 = r5.getBattleAttachedInfo();
    L21:
        long r7 = RandomMatchStrategy.Normal.ordinal();
        if (r13 == null) goto L28;
        s4 r8 = r13.getData();
        if (r8 == null) goto L28;
        if (((int) r8.getMatchType()) != 13) goto L28;
    L29:
        p r3 = new p(r6, r7, r1);
        this.randomMatchInfo = r3;
        this.pkAutoMatchLogInfo.d = r3;
        i41.p r9 = this.mAutoMatchListener;
        if (r13 == null) goto L32;
        r4 = r13.getData();
    L32:
        if (r4 == null) goto L35;
        r9.Nh(r4, "", this.randomMatchInfo);
        return;
    L35:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.link.model.api.IBaseLinkAutoMatchModel");
    L28:
        r1 = false;
    L20:
        r6 = null;
        goto L21
    L36:
        return;
    L38:
        if ((r12 instanceof s) == false) goto L117;
        m41.a r10 = getMatchInviteRefuseUtils();
        if (r10 == null) goto L88;
        com.bytedance.android.live.revlink.impl.global.c r14 = r10.a;
        if (r14 == null) goto L44;
        com.bytedance.android.live.revenuelink.connect.f r15 = r14.Z0();
    L45:
        if (r15 == null) goto L87;
        LiveData<ey.f> r16 = r15.connectState();
        if (r16 == null) goto L87;
        ey.f r17 = (ey.f) r16.getValue();
        if (r17 == null) goto L87;
        if (r17.d != 0) goto L87;
        cy0.e.a.getClass();
        cy0.j r18 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r19 = com.bytedance.android.scope.m.b(r18).b(IRevBroadcastService.class);
        Intrinsics.checkNotNull(r19);
        if (((com.bytedance.live.kmp.core.c) r19).isPlayingGame() == false) goto L56;
        r2 = 9;
        goto L88
    L56:
        com.bytedance.android.live.revlink.impl.global.c r20 = r10.a;
        if (r20 == null) goto L59;
        ox0.a r22 = r20.getModeMerge();
    L60:
        if (r22 == null) goto L62;
        int r23 = r22.a();
    L64:
        if (com.bytedance.android.live.utils.c.a(r23, 8) == true) goto L77;
        Object r24 = com.bytedance.android.scope.m.b(r18).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r24);
        boolean r25 = ((com.bytedance.live.kmp.core.c) r24).dynamicFromAudience();
        Object r26 = com.bytedance.android.scope.m.b(r18).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r26);
        w r27 = ((com.bytedance.live.kmp.core.c) r26).M1();
        if (r27 == null) goto L69;
        int r28 = r27.w();
    L70:
        if (r28 > 0) goto L74;
        r1 = false;
    L74:
        if (com.bytedance.android.live.utils.c.a(r23, 32) == false) goto L78;
        if (r25 == false) goto L77;
        if (r1 == true) goto L77;
    L78:
        com.bytedance.android.live.revlink.impl.global.c r29 = r10.a;
        if (r29 == null) goto L86;
        com.bytedance.android.live.revlink.impl.pk.service.g r30 = r29.jo();
        if (r30 == null) goto L86;
        LiveData<PkReserveBattleDataContext.b> r32 = r30.getBattleReserveState();
        if (r32 == null) goto L86;
        r4 = (PkReserveBattleDataContext.b) r32.getValue();
    L86:
        if (Intrinsics.areEqual(r4, PkReserveBattleDataContext.b.C0178b.a) == false) goto L88;
    L69:
        r28 = 0;
    L77:
        r2 = 6;
        goto L88
    L62:
        r23 = 0;
        goto L64
    L59:
        r22 = null;
    L87:
        r2 = 4;
        goto L88
    L44:
        r15 = null;
    L88:
        if (r2 == 0) goto L115;
        r31.a r33 = getLinkNetwork();
        if (r33 == null) goto L135;
        long r34 = r2;
        com.bytedance.android.live.revlink.impl.utils.s r35 = getRevLinkCommonUtil();
        if (r35 == null) goto L94;
        long r36 = r35.d();
    L95:
        long r37 = r36;
        s r38 = (s) r12;
        Intrinsics.checkNotNullParameter(r38, "$this$fromUid");
        String r39 = r38.get_fromUid();
        if (r39 != null) goto L98;
        String r40 = "";
    L99:
        s1 r110 = ((vh7.c) r12).castTo(s1.class);
        if (r110 == null) goto L105;
        String r111 = r110.getClientInfo();
        if (r111 == null) goto L105;
        String r112 = r111;
    L106:
        Observable<ExtraResponse<Object, Extra>> r113 = r33.o(r34, r37, r40, r112);
        if (r113 == null) goto L136;
        int r42 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r114 = r113.subscribeOn(Schedulers.io());
        if (r114 == null) goto L137;
        Observable r115 = r114.observeOn(AndroidSchedulers.mainThread());
        if (r115 == null) goto L138;
        Disposable r116 = r115.subscribe();
        if (r116 == null) goto L139;
        com.bytedance.revenue.platform.api.core.rx.f.a(r116, this.cd);
        return;
    L139:
        return;
    L138:
        return;
    L137:
        return;
    L136:
        return;
    L105:
        r112 = "";
        goto L106
    L98:
        r40 = r39;
        goto L99
    L94:
        r36 = 0;
        goto L95
    L135:
        return;
    L115:
        getShowMatchInviteDialogEvent().post(r12);
        return;
    L117:
        if ((r12 instanceof r) == false) goto L128;
        r1 r117 = ((vh7.c) r12).castTo(r1.class);
        String r43 = r117.getToast();
        if (r43 != null) goto L121;
    L126:
        getDismissMatchInviteDialogEvent().post(Boolean.TRUE);
        return;
    L121:
        if (r43.length() <= 0) goto L123;
        boolean r44 = true;
    L124:
        if (r44 != true) goto L126;
        int r45 = ToastUtil.a;
        ToastUtil.b(r117.getToast(), 0);
        goto L126
    L123:
        r44 = false;
        goto L124
    L128:
        if ((r12 instanceof u) == false) goto L143;
        z1 r118 = (z1) ((vh7.c) r12).castTo(z1.class);
        if (r118 == null) goto L144;
        onBattleNotifyPointMsg(r118);
        return;
    L144:
        return;
    }

    public final void setAutoMatchInfo(b0 r1) {
        this.autoMatchInfo = r1;
    }

    public final void setAutoMatchModel(af2.e r1) {
        this.autoMatchModel = r1;
    }

    public final void setCurrentGameId(String r1) {
        this.currentGameId = r1;
    }

    public final void setCurrentMatchStyleType(int r1) {
        this.currentMatchStyleType = r1;
    }

    public final void setCurrentMatchType(int r1) {
        this.currentMatchType = r1;
    }

    public final void setJsbInvitePkCallback(f41.a r1) {
        this.jsbInvitePkCallback = r1;
    }

    public final void setMActivityName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mActivityName = r2;
    }

    public final void setMInvitingUserData(NextLiveData<y31.k> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mInvitingUserData = r2;
    }

    public final void setMUserListWhenInvite(List<Object> r1) {
        this.mUserListWhenInvite = r1;
    }

    public final void setMatchSuccess(boolean r1) {
        this.isMatchSuccess = r1;
    }

    public final void setRandomMatchInfo(p r1) {
        this.randomMatchInfo = r1;
    }

    public final void setSpeedUp(boolean r1) {
        this.isSpeedUp = r1;
    }

    public static final /* synthetic */ void access$logFailedToastShow(PkAutoMatchDataContext r0, AutoMatchSource r1) {
        r0.logFailedToastShow(r1);
    }

    public static final /* synthetic */ void access$logInviteSuccess(PkAutoMatchDataContext r0, String r1) {
        r0.logInviteSuccess(r1);
    }

    public static final /* synthetic */ void access$logMatchFailedForEnd(PkAutoMatchDataContext r0, AutoMatchSource r1) {
        r0.logMatchFailedForEnd(r1);
    }

    public static final /* synthetic */ void access$setAvatarCount$p(PkAutoMatchDataContext r0, int r1) {
        r0.avatarCount = r1;
    }

    public static final /* synthetic */ void access$setCanHighWayRandom$p(PkAutoMatchDataContext r0, boolean r1) {
        r0.canHighWayRandom = r1;
    }

    public static final /* synthetic */ void access$setMIsInviting$p(PkAutoMatchDataContext r0, boolean r1) {
        r0.mIsInviting = r1;
    }

    public static final /* synthetic */ void access$setMMatchSuccessNotInvite$p(PkAutoMatchDataContext r0, boolean r1) {
        r0.mMatchSuccessNotInvite = r1;
    }

    public static final /* synthetic */ void access$setMRoom$p(PkAutoMatchDataContext r0, IRoom r1) {
        r0.mRoom = r1;
    }

    public static final /* synthetic */ void access$setMSpeedUpNotSuccess$p(PkAutoMatchDataContext r0, boolean r1) {
        r0.mSpeedUpNotSuccess = r1;
    }

    public static final /* synthetic */ void access$setPkAutoMatchLogInfo$p(PkAutoMatchDataContext r0, h0 r1) {
        r0.pkAutoMatchLogInfo = r1;
    }

    public static final /* synthetic */ void access$showServerControlPopup(PkAutoMatchDataContext r0, long r1) {
        r0.showServerControlPopup(r1);
    }

    public final void startMatchCountDown(r4 r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "autoMatch");
        Intrinsics.checkNotNullParameter(r8, "activityName");
        this._waitedTime.setValue(0L);
        if (r7.getShowNewTips() == true) goto L5;
    L8:
        showPopup();
    L9:
        this._waitedTime.setValue(0L);
        this._leftTime.setValue(Long.valueOf(getExpectTime()));
        this.mActivityName = r8;
        this._pkMatchState.setValue(l41.a.b.a);
        if (this.mCountDownDisposable != null) goto L13;
        com.bytedance.revenue.platform.api.core.rx.l r9 = com.bytedance.revenue.platform.api.core.rx.l.a;
        long r2 = WebcastRedirectException.UNKNOWN;
        int r10 = com.bytedance.revenue.platform.api.core.rx.p.a;
        this.mCountDownDisposable = Observable.interval(r2, r2, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, r7));
    L13:
        if (this.mUserAvatarDisposable == null) goto L15;
        return;
    L15:
        if ((!r7.getPreviewUserList().isEmpty()) == false) goto L19;
        com.bytedance.android.live.revlink.impl.pk.service.i r12 = getToolbarPkService();
        if (r12 == null) goto L19;
        r12.e3(((com.bytedance.android.livesdk.link.model.h0) ListProtector.get(r7.getPreviewUserList(), 0)).getAvatar());
    L19:
        com.bytedance.revenue.platform.api.core.rx.l r13 = com.bytedance.revenue.platform.api.core.rx.l.a;
        long r3 = 2300;
        int r14 = com.bytedance.revenue.platform.api.core.rx.p.a;
        this.mUserAvatarDisposable = Observable.interval(r3, r3, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this, r7));
        return;
    L5:
        if (isRankRandom() == false) goto L8;
        showServerControlPopup(r7.getExpectTime());
        goto L9
    }

    private final void logLargeStrategyLifeCycle(boolean r6, String r7, boolean r8) {
        mz0.n r0 = new mz0.n();
        mz0.o r1 = new mz0.o(r0.a);
        r1.a("match_type", "single");
        cy0.e.a.getClass();
        cy0.j r3 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r2 = com.bytedance.android.scope.m.b(r3).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r2);
        w r4 = ((com.bytedance.live.kmp.core.c) r2).M1();
        if (r4 == null) goto L5;
        int r5 = r4.o();
    L6:
        if (r5 <= 0) goto L8;
        String r9 = "audience_connection";
    L9:
        r1.a("room_status", r9);
        if (r6 == false) goto L12;
        String r10 = "strategy_invite";
    L13:
        r1.a("strategy_type", r10);
        if (r8 == false) goto L16;
        String r12 = DataType.TRUE;
    L17:
        r1.a("if_faild_to_switch", r12);
        e21.c.e(r1, e21.c.c(p0.Companion, r7));
        Object r13 = com.bytedance.android.scope.m.b(r3).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r13);
        ((mz0.i) ((f80.a) r13)).w3("livesdk_random_match_strategy_result", r0.a, r0.b);
        return;
    L16:
        r12 = DataType.FALSE;
        goto L17
    L12:
        r10 = "in_poll";
        goto L13
    L8:
        r9 = "live";
        goto L9
    L5:
        r5 = 0;
        goto L6
    }

    private final void logMatchSuccess(String r9, Integer r10, p0 r12) {
        LinkedHashMap r0 = new LinkedHashMap();
        this.pkAutoMatchLogInfo.a(r0);
        if (this.currentMatchType != 8) goto L5;
    L8:
        r0.put("pk_activity_type", "pk_season");
    L9:
        String r1 = DataType.TRUE;
        if (r10 != null) goto L13;
    L15:
        r0.put("if_strategy_invite", DataType.FALSE);
    L17:
        if (this.currentMatchType != 12) goto L22;
        String r13 = this.currentGameId;
        if (r13 != null) goto L21;
        r13 = "";
    L21:
        r0.put("open_game_app_id", r13);
    L22:
        mz0.n r14 = new mz0.n();
        mz0.o r4 = new mz0.o(r14.a);
        r4.a("from_room_status", "live");
        r4.a("anchor_type", r9);
        IPKLinkBizDataService r15 = getPKLinkBizDataService();
        if (r15 != null) goto L25;
    L27:
        r1 = DataType.FALSE;
    L28:
        r4.a("is_rematch", r1);
        if (this.currentMatchType != 12) goto L31;
        String r16 = "game_matching";
    L32:
        r4.a("match_type", r16);
        r4.a("connection_type", "random_pk");
        r4.a("connection_sub_type", "");
        r4.a("invite_mode", "routine_pk");
        LinkCrossRoomDataHolder r17 = getLinkCrossRoomDataHolder();
        if (r17 == null) goto L35;
        Long r18 = Long.valueOf(r17.c());
    L36:
        r4.a("channel_id", String.valueOf(r18));
        r4.a("anchor_connect_status", "2");
        r4.a("room_status", "live");
        com.bytedance.android.live.revlink.impl.control.d r19 = getAnchorLogParamsService();
        if (r19 == null) goto L41;
        String r20 = r19.getRequestId();
        if (r20 == null) goto L41;
        r4.a("request_id", r20);
    L41:
        r4.b(r0);
        e21.c.e(r4, r12);
        mz0.m r22 = new mz0.m();
        r22.b(LogCommon.ROOM);
        List<Object> r110 = r14.b;
        ArrayList r111 = (ArrayList) r110;
        r111.addAll(r22.a);
        cy0.e.a.getClass();
        cy0.j r23 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r24 = com.bytedance.android.scope.m.b(r23).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r24);
        ((mz0.i) ((f80.a) r24)).w3("livesdk_random_match_success", r14.a, r14.b);
        return;
    L35:
        r18 = null;
        goto L36
    L31:
        r16 = "single";
        goto L32
    L25:
        if (r15.getIsRandomReMatch() != true) goto L27;
    L13:
        if (r10.intValue() != 13) goto L15;
        r0.put("if_strategy_invite", DataType.TRUE);
        goto L17
    L5:
        if (this.currentMatchStyleType == 13) goto L8;
        r0.put("pk_activity_type", "");
        goto L9
    }

    public PkAutoMatchDataContext(ld.a r8, com.bytedance.android.livesdk.revenue.service.room.c r9, com.bytedance.android.live.revlink.impl.global.c r10, yz0.f r12) {
        this.linkDataSet = r8;
        this.roomService = r9;
        this.linkFakeGlobalService = r10;
        this.messageService = r12;
        CompositeDisposable r13 = new CompositeDisposable();
        this.cd = r13;
        IRoomBase r14 = null;
        if (r9 == null) goto L5;
        com.bytedance.android.livesdk.revenue.room.a r15 = r9.getRoomContext();
    L6:
        this.roomContext = r15;
        this.pkAutoMatchLogInfo = new h0();
        this.mInvitingUserData = new NextLiveData();
        this.mActivityName = "";
        MutableLiveData<l41.a> r0 = new MutableLiveData();
        this._pkMatchState = r0;
        this.pkMatchState = r0;
        MutableLiveData<Long> r1 = new MutableLiveData();
        this._waitedTime = r1;
        this.waitedTime = r1;
        MutableLiveData<Long> r2 = new MutableLiveData();
        this._leftTime = r2;
        this.leftTime = r2;
        this.showPopupEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.dismissDialogEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.showMatchInviteDialogEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.dismissMatchInviteDialogEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.currentMatchType = 1;
        this.connectService = getAnchorConnectService();
        this.baseLinkOutListener = new c(this);
        d r3 = new d(this);
        this.mAutoMatchListener = r3;
        com.bytedance.revenue.platform.api.core.rx.f.a(getOnCleared().subscribe(new a(this)), r13);
        if (r12 == null) goto L13;
        com.bytedance.android.live.revenue.common.message.a r4 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r5 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r4, "$this$BATTLE_MATCH_INVITE");
        Observable r6 = yz0.h.a.a(r12, (yh6.b) CommonMessageTypeKt.w.getValue(), false, 6);
        if (r6 == null) goto L13;
        Disposable r7 = r6.subscribe(new e(new AnonymousClass2(this)));
        if (r7 == null) goto L13;
        com.bytedance.revenue.platform.api.core.rx.f.a(r7, r13);
    L13:
        if (r12 == null) goto L19;
        com.bytedance.android.live.revenue.common.message.a r16 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r17 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r16, "$this$BATTLE_MATCH_CANCEL");
        Observable r18 = yz0.h.a.a(r12, (yh6.b) CommonMessageTypeKt.x.getValue(), false, 6);
        if (r18 == null) goto L19;
        Disposable r19 = r18.subscribe(new e(new AnonymousClass3(this)));
        if (r19 == null) goto L19;
        com.bytedance.revenue.platform.api.core.rx.f.a(r19, r13);
    L19:
        if (r12 == null) goto L25;
        com.bytedance.android.live.revenue.common.message.a r20 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r22 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r20, "$this$BATTLE_NOTIFY_POINT");
        Observable r110 = yz0.h.a.a(r12, (yh6.b) CommonMessageTypeKt.v.getValue(), false, 6);
        if (r110 == null) goto L25;
        Disposable r111 = r110.subscribe(new e(new AnonymousClass4(this)));
        if (r111 == null) goto L25;
        com.bytedance.revenue.platform.api.core.rx.f.a(r111, r13);
    L25:
        if (r15 == null) goto L27;
        r14 = r15.getCommonRoom();
    L27:
        this.mRoom = (IRoom) r14;
        i41.a r23 = getAutoMatchManager();
        if (r23 == null) goto L30;
        r23.a(r3);
    L30:
        r0.setValue(l41.a.C0265a.a);
        return;
    L5:
        r15 = null;
        goto L6
    }

    public static final /* synthetic */ void access$logLargeStrategyLifeCycle(PkAutoMatchDataContext r0, boolean r1, String r2, boolean r3) {
        r0.logLargeStrategyLifeCycle(r1, r2, r3);
    }

    public static final /* synthetic */ void access$logMatchSuccess(PkAutoMatchDataContext r0, String r1, Integer r2, p0 r3) {
        r0.logMatchSuccess(r1, r2, r3);
    }

    public final void handleAutoMatchInvite(af2.e r34, int r35, String r36, String r37, p r38) {
        Intrinsics.checkNotNullParameter(r34, "autoMatchModel");
        Intrinsics.checkNotNullParameter(r36, "activityName");
        this.mMatchSuccessNotInvite = false;
        if (r34.getRivalRoom() == null) goto L49;
        IRoom r3 = r34.getRivalRoom();
        Disposable r4 = null;
        if (r3 == null) goto L7;
        IBaseUser r5 = r3.getOwnerKt();
    L8:
        if (r5 == null) goto L49;
        if (this.mRoom == null) goto L49;
        Disposable r6 = this.autoInviteDisposable;
        if (r6 == null) goto L16;
        r6.dispose();
    L16:
        if (r35 != 13) goto L18;
        IBattleConfigSetting r7 = (IBattleConfigSetting) vh7.f.c(IBattleConfigSetting.class);
        r7.setModType(PkBaseDataContext.PKModType.SeasonRank.getType());
        IBattleConfigSetting r8 = r7;
    L19:
        IPKLinkBizDataService r17 = getPKLinkBizDataService();
        if (r17 == null) goto L47;
        IRoom r18 = r34.getRivalRoom();
        IRoomBase r9 = r34.getRivalRoom();
        if (r9 == null) goto L24;
        long r10 = IRoomKtKt.getId(r9);
    L25:
        long r19 = r10;
        IRoom r12 = r34.getRivalRoom();
        if (r12 == null) goto L30;
        IBaseUser r13 = r12.getOwnerKt();
        if (r13 == null) goto L30;
        String r22 = r13.getIdString();
    L31:
        IRoom r14 = r34.getRivalRoom();
        if (r14 == null) goto L36;
        IBaseUser r15 = r14.getOwnerKt();
        if (r15 == null) goto L36;
        Intrinsics.checkNotNullParameter(r15, "$this$secUidExt");
        String r23 = r15.getCastSecUid();
    L37:
        com.bytedance.live.kmp.util.c r16 = com.bytedance.live.kmp.util.c.a;
        int r20 = w11.a.a;
        String r1 = com.bytedance.live.kmp.util.c.a(2131919635, new Object[0]);
        String r24 = r34.getBattleAttachedInfo();
        e21.b r25 = getClientAttachedInfoObj();
        if (r25 == null) goto L45;
        com.bytedance.android.live.revlink.impl.pk.utils.l.g r26 = com.bytedance.android.live.revlink.impl.pk.utils.l.g.c;
        com.bytedance.android.live.revlink.impl.control.d r2 = getAnchorLogParamsService();
        if (r2 == null) goto L43;
        String r27 = r2.getRequestId();
        if (r27 == null) goto L43;
    L44:
        v3 r110 = e21.b.b(r25, r26, null, r27, null, null, null, 104);
    L46:
        r4 = r17.invite(r18, r19, r22, r23, r35, 0, new com.bytedance.android.live.revlink.impl.mergepk.pkdouble.f(null, r1, 300, r36, 0, r8, r24, 0, 0, r110, r37, null, 4913), null, AnonymousClass1.INSTANCE, new C03672(this));
    L43:
        r27 = "";
        goto L44
    L45:
        r110 = null;
    L36:
        r23 = null;
    L30:
        r22 = null;
        goto L31
    L24:
        r10 = 0;
    L47:
        this.autoInviteDisposable = r4;
        return;
    L18:
        r8 = null;
        goto L19
    L7:
        r5 = null;
    L49:
        logFailedToastShow(AutoMatchSource.ConnectionInfoInvalid);
    }

    public static /* synthetic */ void logMatchSuccess$default(PkAutoMatchDataContext r0, String r1, Integer r2, p0 r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        r0.logMatchSuccess(r1, r2, r3);
    }

    public final void inviteWhenMatching(IRoom r29, boolean r30, int r32, m2 r33, int r34, List<Object> r35, String r36) {
        Intrinsics.checkNotNullParameter(r29, "room");
        Intrinsics.checkNotNullParameter(r35, "binderDataList");
        if (this.mUserListWhenInvite == null) goto L5;
        return;
    L5:
        this.mIsInviting = true;
        this.mUserListWhenInvite = r35;
        if (r30 == false) goto L8;
        IBattleConfigSetting r1 = (IBattleConfigSetting) vh7.f.c(IBattleConfigSetting.class);
        r1.setModType(PkBaseDataContext.PKModType.SeasonRank.getType());
        IBattleConfigSetting r18 = r1;
    L9:
        IPKLinkBizDataService r2 = getPKLinkBizDataService();
        if (r2 == null) goto L28;
        long r3 = IRoomKtKt.getId((IRoomBase) r29);
        IBaseUser r4 = r29.getOwnerKt();
        if (r4 == null) goto L14;
        String r5 = r4.getIdString();
    L15:
        IBaseUser r6 = r29.getOwnerKt();
        if (r6 == null) goto L18;
        Intrinsics.checkNotNullParameter(r6, "$this$secUidExt");
        String r7 = r6.getCastSecUid();
    L20:
        if (r33 == null) goto L22;
        String r19 = r33.getBattleAttachedInfo();
    L23:
        e21.b r20 = getClientAttachedInfoObj();
        if (r20 == null) goto L26;
        v3 r23 = e21.b.b(r20, com.bytedance.android.live.revlink.impl.pk.utils.l.g.c, null, r36, null, null, null, 120);
    L27:
        IPKLinkBizDataService.b.b(r2, r29, r3, r5, r7, 0, r32, new com.bytedance.android.live.revlink.impl.mergepk.pkdouble.f(null, null, 0, null, 0, r18, r19, 0, 0, r23, null, null, 6975));
        goto L28
    L26:
        r23 = null;
        goto L27
    L22:
        r19 = null;
        goto L23
    L18:
        r7 = null;
        goto L20
    L14:
        r5 = null;
    L28:
        h41.c r8 = getLiveInviteLogger();
        if (r8 != null) goto L31;
        return;
    L31:
        if (r33 == null) goto L33;
        IRivalExtraInfo r9 = r33.getRivalExtraInfo();
    L34:
        int r10 = h41.c.d;
        r8.d(r29, r34, null, r9, null, 0, 0, null);
        return;
    L33:
        r9 = null;
        goto L34
    L8:
        r18 = null;
        goto L9
    }

    public static /* synthetic */ void handleAutoMatchInvite$default(PkAutoMatchDataContext r6, af2.e r7, int r8, String r9, String r10, p r12, int r13, Object r14) {
        if ((r13 & 8) == 0) goto L5;
        r10 = null;
    L5:
        r6.handleAutoMatchInvite(r7, r8, r9, r10, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.Number] */
    /* JADX WARN: Type inference failed for: r13v3 */
    public final void startMatch(long r19, boolean r22, b0 r23, int r24, int r25, String r26, String r27, final Function1<? super p, Unit> r28) {
        Intrinsics.checkNotNullParameter(r26, "activityType");
        Intrinsics.checkNotNullParameter(r27, "gameAppId");
        boolean r12 = false;
        if (this.isListenMessage == true) goto L13;
        this.isListenMessage = true;
        yz0.f r2 = this.messageService;
        if (r2 == null) goto L11;
        com.bytedance.android.live.revenue.common.message.a r3 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r4 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r3, "$this$BATTLE_AUTO_MATCH");
        Observable r5 = yz0.h.a.a(r2, (yh6.b) CommonMessageTypeKt.u.getValue(), false, 6);
        if (r5 == null) goto L11;
        Disposable r6 = r5.subscribe(new e(new C03681(this)));
        if (r6 == null) goto L11;
        this.cd.add(r6);
        Unit r7 = Unit.INSTANCE;
    L12:
        this.messageDisposable = r6;
    L11:
        r6 = null;
    L13:
        IPKLinkBizDataService r8 = getPKLinkBizDataService();
        if (r8 == null) goto L16;
        q11.c r9 = r8.mo747getPkLinkState();
    L18:
        if (Intrinsics.areEqual(r9, q11.c.C0296c.b) == true) goto L95;
        IPKLinkBizDataService r10 = getPKLinkBizDataService();
        if (r10 == null) goto L22;
        q11.c r13 = r10.mo747getPkLinkState();
    L24:
        if (Intrinsics.areEqual(r13, q11.c.a.b) == true) goto L95;
        if (this.linkOutManager != null) goto L35;
        com.bytedance.android.live.revenuelink.connect.f r14 = this.connectService;
        if (r14 == null) goto L31;
        com.bytedance.android.live.revenuelink.connect.n r15 = r14.linkOutManager();
    L32:
        this.linkOutManager = r15;
        com.bytedance.android.live.revenuelink.connect.f r16 = this.connectService;
        if (r16 == null) goto L35;
        r16.addLinkOutListener(1, this.baseLinkOutListener);
        r16.addLinkOutListener(7, this.baseLinkOutListener);
        goto L35
    L31:
        r15 = null;
    L35:
        h0 r17 = this.pkAutoMatchLogInfo;
        r17.a = 0;
        r17.b = 0;
        r17.c = 0;
        r17.d = null;
        r17.e = false;
        if (r23 == null) goto L40;
        c0 r18 = r23.getConfig();
        if (r18 == null) goto L40;
        int r20 = (int) r18.getPkAutoMatchIndex();
    L41:
        r17.a = r20;
        h0 r29 = this.pkAutoMatchLogInfo;
        r29.c = 0;
        i97.a r30 = i97.a.a;
        r29.b = System.currentTimeMillis();
        this.autoMatchInfo = r23;
        if (r23 == null) goto L52;
        Long r1 = Long.valueOf(r23.getWaitSec());
        if (r1.longValue() <= 0) goto L46;
        boolean r32 = true;
    L47:
        if (r32 == true) goto L50;
        r1 = null;
    L50:
        if (r1 == null) goto L52;
        this._leftTime.setValue(Long.valueOf(r1.longValue()));
        goto L52
    L46:
        r32 = false;
    L52:
        this.isSpeedUp = false;
        clearInvitingStatus();
        if (r24 == 0) goto L57;
        this.currentMatchType = r24;
        this.currentMatchStyleType = r25;
    L57:
        if (r27.length() != 0) goto L59;
        boolean r33 = true;
    L60:
        if (r33 == true) goto L62;
        this.currentGameId = r27;
        Boolean r110 = null;
    L63:
        i41.a r34 = getAutoMatchManager();
        if (r34 == null) goto L67;
        r34.d(r19, false, true, r24, r25, r26, r27, new AnonymousClass6(this, r28));
    L67:
        StringBuilder r35 = new StringBuilder("AutoMatchManager startMatch");
        i41.a r36 = getAutoMatchManager();
        if (r36 == null) goto L70;
        Boolean r37 = Boolean.valueOf(r36.f);
    L71:
        r35.append(r37);
        jy0.b.d(TAG, r35.toString());
        b0 r38 = this.autoMatchInfo;
        if (r38 == null) goto L104;
        Long r39 = Long.valueOf(r38.getDefaultWaitLimit());
        if (r39.longValue() <= 0) goto L76;
        r12 = true;
    L76:
        if (r12 == false) goto L78;
        ?? r111 = r39;
    L79:
        if (r111 == 0) goto L105;
        long r40 = r111.longValue();
        i41.a r42 = getAutoMatchManager();
        if (r42 == null) goto L106;
        b0 r43 = this.autoMatchInfo;
        if (r43 == null) goto L85;
        long r44 = r43.getWaitSec();
    L86:
        int r45 = (int) (r40 + r44);
        Disposable r46 = r42.i;
        if (r46 != null) goto L89;
    L93:
        long r47 = (((long) r45) + 1) * ((long) WebcastRedirectException.UNKNOWN);
        com.bytedance.revenue.platform.api.core.rx.l r48 = com.bytedance.revenue.platform.api.core.rx.l.a;
        int r49 = com.bytedance.revenue.platform.api.core.rx.p.a;
        r42.i = Observable.timer(r47, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i41.g(r42));
        return;
    L89:
        if (r46.isDisposed() == true) goto L93;
        Disposable r50 = r42.i;
        if (r50 == null) goto L93;
        r50.dispose();
        goto L93
    L85:
        r44 = 60;
        goto L86
    L106:
        return;
    L105:
        return;
    L78:
        r111 = r110;
        goto L79
    L104:
        return;
    L70:
        r37 = r110;
        goto L71
    L62:
        r110 = null;
        this.currentGameId = null;
        goto L63
    L59:
        r33 = false;
    L40:
        r20 = 0;
        goto L41
    L22:
        r13 = null;
    L95:
        IPKLinkBizDataService r52 = getPKLinkBizDataService();
        if (r52 == null) goto L101;
        q11.c r53 = r52.mo747getPkLinkState();
        if (r53 == null) goto L101;
        String r54 = r53.a;
        if (r54 == null) goto L101;
    L102:
        jy0.b.d(TAG, "startMatch when linking".concat(r54));
        return;
    L101:
        r54 = "";
        goto L102
    L16:
        r9 = null;
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startMatch$default(PkAutoMatchDataContext r13, long r14, boolean r16, b0 r17, int r18, int r19, String r20, String r22, Function1 r23, int r24, Object r25) {
        if ((r24 & 32) == 0) goto L5;
        String r10 = "";
    L7:
        if ((r24 & 64) == 0) goto L9;
        String r12 = "";
    L11:
        if ((r24 & 128) == 0) goto L13;
        Function1 r15 = null;
    L14:
        r13.startMatch(r14, r16, r17, r18, r19, r10, r12, r15);
        return;
    L13:
        r15 = r23;
        goto L14
    L9:
        r12 = r22;
        goto L11
    L5:
        r10 = r20;
        goto L7
    }
}
