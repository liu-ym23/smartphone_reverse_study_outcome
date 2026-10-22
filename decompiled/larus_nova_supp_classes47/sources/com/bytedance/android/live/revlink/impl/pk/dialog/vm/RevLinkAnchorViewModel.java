package com.bytedance.android.live.revlink.impl.pk.dialog.vm;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.control.dialog.LinkRevPanelDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.p;
import com.bytedance.android.live.revlink.impl.pk.randompkcheck.RandomCheckDataContext;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.live.revlink.impl.pk.utils.k;
import com.bytedance.android.live.revlink.impl.pk.utils.t;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchManager;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.chatroom.interact.model.h0;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.IGroupRivals;
import com.bytedance.android.livesdk.link.model.IPanelArea;
import com.bytedance.android.livesdk.link.model.IPkSubTabKey;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j8;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdk.link.model.k8;
import com.bytedance.android.livesdk.link.model.l8;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.r8;
import com.bytedance.android.livesdk.link.model.s2;
import com.bytedance.android.livesdk.link.model.s8;
import com.bytedance.android.livesdk.link.model.t8;
import com.bytedance.android.livesdk.link.model.u8;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.link.model.v4;
import com.bytedance.android.livesdk.link.model.y7;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import cy0.j;
import dq2.w;
import gd0.v;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.CompletableSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;
import mz0.m;
import mz0.n;
import org.json.JSONObject;
import x31.l;
import y31.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000¤\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 ò\u00012\u00020\u00012\u00020\u0002:\u0002ó\u0001B\t¢\u0006\u0006\bð\u0001\u0010ñ\u0001J\u001e\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002JP\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\bH\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0002J\u001c\u0010\"\u001a\u00020\u00112\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\rH\u0002J\u001c\u0010'\u001a\u00020\u00112\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u001a\u0010+\u001a\u00020*2\b\u0010(\u001a\u0004\u0018\u00010\u00032\u0006\u0010)\u001a\u00020\u0003H\u0002J\u0018\u0010-\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\bH\u0002J\u0010\u0010.\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010/\u001a\u00020\u0011H\u0002J\u001c\u00100\u001a\u00020\u00112\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u001e\u00104\u001a\b\u0012\u0004\u0012\u000202012\u000e\u00103\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101H\u0002J\u0010\u00105\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u00106\u001a\u00020\u0011H\u0002J\b\u00107\u001a\u00020\u0011H\u0002J\u0012\u0010:\u001a\u00020\u00112\b\u00109\u001a\u0004\u0018\u000108H\u0002J\u001c\u0010>\u001a\u00020\u00112\b\u0010<\u001a\u0004\u0018\u00010;2\b\u0010=\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010?\u001a\u00020\u0003H\u0016J@\u0010E\u001a\u00020\u00112\b\u0010A\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010B\u001a\u00020\u00032\b\b\u0002\u0010C\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\u0019J:\u0010J\u001a\u0004\u0018\u00010I2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u0003J\b\u0010K\u001a\u00020\u0011H\u0016J\u0006\u0010L\u001a\u00020\u0011J\u0006\u0010M\u001a\u00020\u0011J\u0010\u0010N\u001a\u00020\u00112\b\b\u0002\u0010\u0007\u001a\u00020\u0003J\u001e\u0010S\u001a\u00020\u00112\u0006\u0010O\u001a\u00020\r2\u0006\u0010P\u001a\u00020\r2\u0006\u0010R\u001a\u00020QJ¬\u0001\u0010d\u001a\u00020\u00112\u0006\u0010R\u001a\u00020Q2\u0006\u0010T\u001a\u00020\r2\b\u0010U\u001a\u0004\u0018\u00010\u00032\u0006\u0010V\u001a\u00020\b2\u0006\u0010W\u001a\u00020\b2\b\u0010Y\u001a\u0004\u0018\u00010X2\u0006\u0010Z\u001a\u00020\b2\b\u0010[\u001a\u0004\u0018\u00010\u00032\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u0001012\b\u0010^\u001a\u0004\u0018\u00010\u00032\u0006\u0010_\u001a\u00020\b2\u0006\u0010`\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010\u00032\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030aj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`b2\u0006\u0010c\u001a\u00020\u0019J|\u0010j\u001a\u00020\u00112\b\u0010e\u001a\u0004\u0018\u00010Q2\u0006\u0010W\u001a\u00020\b2\b\u0010Y\u001a\u0004\u0018\u00010X2\u0006\u0010Z\u001a\u00020\b2\b\u0010g\u001a\u0004\u0018\u00010f2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010h2\u0006\u0010i\u001a\u00020\b2\u0006\u0010_\u001a\u00020\b2\b\u0010=\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030a2\u0006\u0010c\u001a\u00020\u0019H\u0016J\u0012\u0010k\u001a\u00020\u00112\b\u0010R\u001a\u0004\u0018\u00010QH\u0016J\u0006\u0010l\u001a\u00020\u0019J\u0012\u0010m\u001a\u00020\u00192\b\u0010R\u001a\u0004\u0018\u00010QH\u0016J\u0012\u0010p\u001a\u0004\u0018\u00010o2\u0006\u0010n\u001a\u00020\u0019H\u0016J\b\u0010q\u001a\u00020\u0011H\u0014J\u0006\u0010r\u001a\u00020\u0019J\u000e\u0010s\u001a\u00020\u00112\u0006\u0010i\u001a\u00020\bR\u0016\u0010B\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010tR\u0016\u0010C\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010tR\u0016\u0010\u0007\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010tR\"\u0010u\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010t\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\"\u0010%\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u0017\u0010\u007f\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001b\u0010\u0081\u0001\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001b\u0010\u0083\u0001\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0019\u0010\u0085\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0080\u0001R\u001a\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010tR\u0018\u0010\u0087\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010zR!\u0010\u008d\u0001\u001a\u00030\u0088\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R \u0010\u008f\u0001\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b\u008e\u0001\u0010\u008a\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R \u0010\u0092\u0001\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b\u0091\u0001\u0010\u008a\u0001\u001a\u0006\b\u0092\u0001\u0010\u0090\u0001R\u0017\u0010\u0093\u0001\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0080\u0001R)\u0010\u0094\u0001\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0094\u0001\u0010\u0080\u0001\u001a\u0006\b\u0094\u0001\u0010\u0090\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R,\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0019\u0010\u009e\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u0080\u0001R\u0019\u0010\u009f\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010\u0080\u0001R\u0019\u0010 \u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010\u0080\u0001R.\u0010¢\u0001\u001a\u0004\u0018\u00010;2\t\u0010¡\u0001\u001a\u0004\u0018\u00010;8\u0002@BX\u0082\u000e¢\u0006\u0010\n\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001R&\u0010¦\u0001\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¦\u0001\u0010t\u001a\u0005\b§\u0001\u0010w\"\u0005\b¨\u0001\u0010yR\u0019\u0010©\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010\u0080\u0001R\u001b\u0010ª\u0001\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R\u0019\u0010¬\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u0019\u0010®\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010\u00ad\u0001R!\u0010¯\u0001\u001a\n\u0012\u0004\u0012\u000202\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R0\u0010´\u0001\u001a\u0016\u0012\u0005\u0012\u00030²\u00010±\u0001j\n\u0012\u0005\u0012\u00030²\u0001`³\u00018\u0006¢\u0006\u0010\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001R$\u0010º\u0001\u001a\n\u0012\u0005\u0012\u00030¹\u00010¸\u00018\u0006¢\u0006\u0010\n\u0006\bº\u0001\u0010»\u0001\u001a\u0006\b¼\u0001\u0010½\u0001R#\u0010¾\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190¸\u00018\u0006¢\u0006\u0010\n\u0006\b¾\u0001\u0010»\u0001\u001a\u0006\b¿\u0001\u0010½\u0001R\u001d\u0010Á\u0001\u001a\u00030À\u00018\u0006¢\u0006\u0010\n\u0006\bÁ\u0001\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001R\u001b\u0010Å\u0001\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\u001b\u0010Ç\u0001\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R*\u0010Ê\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030É\u00010h0¸\u00018\u0006¢\u0006\u0010\n\u0006\bÊ\u0001\u0010»\u0001\u001a\u0006\bË\u0001\u0010½\u0001R)\u0010Ì\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u000202010¸\u00018\u0006¢\u0006\u0010\n\u0006\bÌ\u0001\u0010»\u0001\u001a\u0006\bÍ\u0001\u0010½\u0001R#\u0010Î\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190¸\u00018\u0006¢\u0006\u0010\n\u0006\bÎ\u0001\u0010»\u0001\u001a\u0006\bÏ\u0001\u0010½\u0001R#\u0010Ð\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190¸\u00018\u0006¢\u0006\u0010\n\u0006\bÐ\u0001\u0010»\u0001\u001a\u0006\bÑ\u0001\u0010½\u0001R$\u0010Ò\u0001\u001a\n\u0012\u0005\u0012\u00030²\u00010¸\u00018\u0006¢\u0006\u0010\n\u0006\bÒ\u0001\u0010»\u0001\u001a\u0006\bÓ\u0001\u0010½\u0001R0\u0010Õ\u0001\u001a\u0016\u0012\u0005\u0012\u00030Ô\u00010±\u0001j\n\u0012\u0005\u0012\u00030Ô\u0001`³\u00018\u0006¢\u0006\u0010\n\u0006\bÕ\u0001\u0010µ\u0001\u001a\u0006\bÖ\u0001\u0010·\u0001R0\u0010Ø\u0001\u001a\u0016\u0012\u0005\u0012\u00030×\u00010±\u0001j\n\u0012\u0005\u0012\u00030×\u0001`³\u00018\u0006¢\u0006\u0010\n\u0006\bØ\u0001\u0010µ\u0001\u001a\u0006\bÙ\u0001\u0010·\u0001R#\u0010Ú\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190¸\u00018\u0006¢\u0006\u0010\n\u0006\bÚ\u0001\u0010»\u0001\u001a\u0006\bÚ\u0001\u0010½\u0001R#\u0010Û\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190¸\u00018\u0006¢\u0006\u0010\n\u0006\bÛ\u0001\u0010»\u0001\u001a\u0006\bÛ\u0001\u0010½\u0001R#\u0010Ü\u0001\u001a\t\u0012\u0004\u0012\u00020*0¸\u00018\u0006¢\u0006\u0010\n\u0006\bÜ\u0001\u0010»\u0001\u001a\u0006\bÝ\u0001\u0010½\u0001R/\u0010Þ\u0001\u001a\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 0\u001f0¸\u00018\u0006¢\u0006\u0010\n\u0006\bÞ\u0001\u0010»\u0001\u001a\u0006\bß\u0001\u0010½\u0001R#\u0010à\u0001\u001a\t\u0012\u0004\u0012\u00020\b0¸\u00018\u0006¢\u0006\u0010\n\u0006\bà\u0001\u0010»\u0001\u001a\u0006\bá\u0001\u0010½\u0001R#\u0010â\u0001\u001a\t\u0012\u0004\u0012\u00020\u00110¸\u00018\u0006¢\u0006\u0010\n\u0006\bâ\u0001\u0010»\u0001\u001a\u0006\bã\u0001\u0010½\u0001R.\u0010ä\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000b0±\u0001j\t\u0012\u0004\u0012\u00020\u000b`³\u00018\u0006¢\u0006\u0010\n\u0006\bä\u0001\u0010µ\u0001\u001a\u0006\bå\u0001\u0010·\u0001R#\u0010ê\u0001\u001a\u0005\u0018\u00010æ\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bç\u0001\u0010\u008a\u0001\u001a\u0006\bè\u0001\u0010é\u0001R\u0018\u0010ë\u0001\u001a\u00030\u0088\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bë\u0001\u0010ì\u0001R\u0018\u0010î\u0001\u001a\u00030í\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bî\u0001\u0010ï\u0001¨\u0006ô\u0001"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/vm/RevLinkAnchorViewModel;", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/vm/RevLinkAnchorBaseViewModel;", "Lx31/l;", "", "trackingInfo", "", "parseLogInfo", "source", "", "loadType", "activityID", "Lcom/bytedance/android/livesdk/link/model/IRivalRankRecommendResponse;", "resp", "", "startTS", "endTS", "logMap", "", "onRankResp", "initFollow", "initDefaultRandomPkData", "posStr", "initOther", "Lcom/bytedance/android/livesdk/link/model/b0;", "createDefaultAutoMatchInfo", "", "needAdd", "toggleListener", "hasFolow", "getLinkAudienceCount", "checkSelectedPos", "Lkotlin/Pair;", "Lcom/bytedance/android/live/revlink/impl/control/dialog/e;", "pair", "onDataFollowLoaded", "Lcom/bytedance/android/livesdk/link/model/IGroupRivals;", "groupRivals", "skinType", "updateFollowList", "onRecDataLoaded", "impId", "titleName", "Ly31/s$a;", "createRecTitleItem", "flag", "checkDataNeedNotify", "checkTab", "checkDataLoadFinish", "onDataLoaded", "", "Lcom/bytedance/android/livesdk/link/model/y7;", "origin", "removeInValidTab", "onRandomDataUpdate", "notifyList", "dismiss", "", "throwable", "logThrowable", "Lcom/bytedance/android/livesdk/link/model/IPkSubTabKey;", "key", "imprId", "logSubTabShow", "getTag", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "guideType", "toUserGroup", "forRank", "doInit", "entranceType", "selectType", "activityId", "Lio/reactivex/disposables/Disposable;", "fetchUserListDataWithLoadType", "toggleExpand", "onTabIn", "onTabOut", "doRandom", "roomId", "channelId", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "targetRoom", "cancel", "currentRoomId", FileUtils.PICTURE_THEME, Constants.Keys.duration, "inviteType", "Lcom/bytedance/android/livesdk/link/model/IRivalExtraInfo;", "rivalExtraInfo", "mAnchorLayer", "activityName", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTag;", "tags", "battleAttachedInfo", "inviteIndex", "decideDuration", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "fromRank", "invite", "room", "Lcom/bytedance/android/livesdk/link/model/m2;", "battleRival", "", "pos", "onInvite", "onCancel", "isAudioRoom", "isRequesting", "isCurExpand", "Ly31/i$a;", "createExpandItem", "onCleared", "isInviteRequesting", "onPageSelected", "Ljava/lang/String;", "searchHintStr", "getSearchHintStr", "()Ljava/lang/String;", "setSearchHintStr", "(Ljava/lang/String;)V", "J", "getSkinType", "()J", "setSkinType", "(J)V", "mIsShow", "Z", "mDataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "mToRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "mInvitation", "mRequestingUserId", "mPageShowTime", "Li11/c$a;", "anchorCallback$delegate", "Lkotlin/Lazy;", "getAnchorCallback", "()Li11/c$a;", "anchorCallback", "isRandomOpt$delegate", "isRandomOpt", "()Z", "isListOpt$delegate", "isListOpt", "isSpeedUpOpt", "isEnableCheckPos", "setEnableCheckPos", "(Z)V", "Lcom/bytedance/android/livesdk/link/model/u8;", "invalidExtra", "Lcom/bytedance/android/livesdk/link/model/u8;", "getInvalidExtra", "()Lcom/bytedance/android/livesdk/link/model/u8;", "setInvalidExtra", "(Lcom/bytedance/android/livesdk/link/model/u8;)V", "hasRecCache", "hasFollowCache", "hasOtherCache", "value", "recordSelectTabKey", "Lcom/bytedance/android/livesdk/link/model/IPkSubTabKey;", "setRecordSelectTabKey", "(Lcom/bytedance/android/livesdk/link/model/IPkSubTabKey;)V", "subTabAction", "getSubTabAction", "setSubTabAction", "enableRank", "extraInfo", "Lcom/bytedance/android/livesdk/link/model/IRivalExtraInfo;", "anchorLayer", "I", "loadFlag", "subTabList", "Ljava/util/List;", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/vm/a;", "Lcom/bytedance/android/live/revenue/common/NextLiveData;", "defaultRandomPkData", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getDefaultRandomPkData", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/revlink/impl/control/dialog/f;", "errorData", "Landroidx/lifecycle/MutableLiveData;", "getErrorData", "()Landroidx/lifecycle/MutableLiveData;", "notifyListEvent", "getNotifyListEvent", "Lio/reactivex/subjects/CompletableSubject;", "onDismissEvent", "Lio/reactivex/subjects/CompletableSubject;", "getOnDismissEvent", "()Lio/reactivex/subjects/CompletableSubject;", "autoMatchInfo", "Lcom/bytedance/android/livesdk/link/model/b0;", "followGroupRival", "Lcom/bytedance/android/livesdk/link/model/IGroupRivals;", "", "followListData", "getFollowListData", "tabs", "getTabs", "stopRefreshEvent", "getStopRefreshEvent", "dataLoadFinish", "getDataLoadFinish", "randomData", "getRandomData", "Lcom/bytedance/android/livesdk/link/model/s8;", "rankSeasonInfo", "getRankSeasonInfo", "Lcom/bytedance/android/livesdk/link/model/r8;", "popInfo", "getPopInfo", "isSeasonUnlock", "isSeasonTabEnable", "recTitleData", "getRecTitleData", Constants.Keys.DATA, "getData", "selectedPos", "getSelectedPos", "showRandomCheckDialogEvent", "getShowRandomCheckDialogEvent", "rankRecommendResponse", "getRankRecommendResponse", "Li11/b;", "anchorLinkUserCenter$delegate", "getAnchorLinkUserCenter", "()Li11/b;", "anchorLinkUserCenter", "mCallback", "Li11/c$a;", "Lcom/bytedance/android/live/revenuelink/connect/d;", "baseLinkOutListener", "Lcom/bytedance/android/live/revenuelink/connect/d;", "<init>", "()V", "Companion", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkAnchorViewModel extends RevLinkAnchorBaseViewModel implements l {
    public static final a Companion = null;
    public static final int FLAG_LOAD_FOLLOW = 2;
    public static final int FLAG_LOAD_OTHER = 1;
    public static final int FLAG_LOAD_REC = 4;
    private final Lazy anchorCallback$delegate;
    private int anchorLayer;
    private final Lazy anchorLinkUserCenter$delegate;
    private b0 autoMatchInfo;
    private final com.bytedance.android.live.revenuelink.connect.d baseLinkOutListener;
    private final MutableLiveData<Pair<String, com.bytedance.android.live.revlink.impl.control.dialog.e>> data;
    private final MutableLiveData<Boolean> dataLoadFinish;
    private final NextLiveData<com.bytedance.android.live.revlink.impl.pk.dialog.vm.a> defaultRandomPkData;
    private boolean enableRank;
    private final MutableLiveData<com.bytedance.android.live.revlink.impl.control.dialog.f> errorData;
    private IRivalExtraInfo extraInfo;
    private IGroupRivals followGroupRival;
    private final MutableLiveData<List<Object>> followListData;
    private String guideType;
    private boolean hasFollowCache;
    private boolean hasOtherCache;
    private boolean hasRecCache;
    private u8 invalidExtra;
    private boolean isEnableCheckPos;
    private final Lazy isListOpt$delegate;
    private final Lazy isRandomOpt$delegate;
    private final MutableLiveData<Boolean> isSeasonTabEnable;
    private final MutableLiveData<Boolean> isSeasonUnlock;
    private final boolean isSpeedUpOpt;
    private int loadFlag;
    private final i11.c.a mCallback;
    private DataCenter mDataCenter;
    private boolean mInvitation;
    private boolean mIsShow;
    private long mPageShowTime;
    private String mRequestingUserId;
    private IRoom mToRoom;
    private final MutableLiveData<Boolean> notifyListEvent;
    private final CompletableSubject onDismissEvent;
    private final NextLiveData<r8> popInfo;
    private final MutableLiveData<com.bytedance.android.live.revlink.impl.pk.dialog.vm.a> randomData;
    private final NextLiveData<IRivalRankRecommendResponse> rankRecommendResponse;
    private final NextLiveData<s8> rankSeasonInfo;
    private final MutableLiveData<s.a> recTitleData;
    private IPkSubTabKey recordSelectTabKey;
    private String searchHintStr;
    private final MutableLiveData<Integer> selectedPos;
    private final MutableLiveData<Unit> showRandomCheckDialogEvent;
    private long skinType;
    private String source;
    private final MutableLiveData<Boolean> stopRefreshEvent;
    private String subTabAction;
    private List<? extends y7> subTabList;
    private final MutableLiveData<List<y7>> tabs;
    private String toUserGroup;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends com.bytedance.android.live.revenuelink.connect.d {
        public final /* synthetic */ RevLinkAnchorViewModel a;

        public b(RevLinkAnchorViewModel r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void Tg(int r1, i6 r2, ey.l r3) {
            Intrinsics.checkNotNullParameter(r2, "_linkerMessage");
            Intrinsics.checkNotNullParameter(r2, "linkerMessage");
            k6 r4 = r2.castTo(i6.class).getReply();
            if (r4 != null) goto L5;
            return;
        L5:
            if (((int) r4.getReplyStatus()) != 1) goto L9;
            RevLinkAnchorViewModel.access$dismiss(this.a);
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void hl(d11.d r12, long r13, v4 r14, ey.l r15) {
            Intrinsics.checkNotNullParameter(r12, "params");
            Intrinsics.checkNotNullParameter(r14, "_inviteResult");
            if (e21.a.a(r12.i) == true) goto L5;
            return;
        L5:
            super.hl(r12, r13, r14, r15);
            v4 r16 = r14.castTo(v4.class);
            IRoom r1 = r12.h;
            com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r17 = com.bytedance.android.live.revlink.impl.global.b.l();
            if (r17 == null) goto L8;
            Intrinsics.checkNotNullParameter("pk_banner", "<set-?>");
            r17.c = "pk_banner";
        L8:
            com.bytedance.android.live.revlink.impl.global.c r18 = com.bytedance.android.live.revlink.impl.global.b.k();
            if (r18 == null) goto L11;
            h41.c r0 = r18.getLiveInviteLogger();
        L12:
            if (r0 == null) goto L18;
            int r2 = RevLinkAnchorViewModel.access$getAnchorLayer$p(this.a);
            IRivalExtraInfo r4 = RevLinkAnchorViewModel.access$getExtraInfo$p(this.a);
            HashMap<String, String> r5 = r12.B;
            int r6 = r12.v;
            long r7 = r12.w;
            if (r16 == null) goto L16;
            String r9 = r16.getEventTrackingInfo();
        L17:
            r0.d(r1, r2, null, r4, r5, r6, r7, r9);
            goto L18
        L16:
            r9 = null;
        L18:
            RevLinkAnchorViewModel.access$setMInvitation$p(this.a, false);
            RevLinkAnchorViewModel.access$setMRequestingUserId$p(this.a, null);
            RevLinkAnchorViewModel.access$notifyList(this.a);
            if (r16.getSupportMultiInvite() == true) goto L22;
            RevLinkAnchorViewModel.access$dismiss(this.a);
            return;
        L22:
            return;
        L11:
            r0 = null;
            goto L12
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void rp(d11.d r12, Throwable r13, long r14, ey.l.b r15) {
            Intrinsics.checkNotNullParameter(r12, "params");
            Intrinsics.checkNotNullParameter(r12, "params");
            RevLinkAnchorViewModel.access$logThrowable(this.a, r13);
            com.bytedance.android.live.revlink.impl.global.c r16 = com.bytedance.android.live.revlink.impl.global.b.k();
            if (r16 == null) goto L5;
            h41.c r0 = r16.getLiveInviteLogger();
        L6:
            if (r0 == null) goto L8;
            IRoom r1 = RevLinkAnchorViewModel.access$getMToRoom$p(this.a);
            int r2 = RevLinkAnchorViewModel.access$getAnchorLayer$p(this.a);
            IRivalExtraInfo r4 = RevLinkAnchorViewModel.access$getExtraInfo$p(this.a);
            HashMap<String, String> r5 = r12.B;
            int r6 = r12.v;
            long r7 = r12.w;
            int r17 = h41.c.d;
            r0.d(r1, r2, r13, r4, r5, r6, r7, null);
        L8:
            RevLinkAnchorViewModel.access$setMInvitation$p(this.a, false);
            RevLinkAnchorViewModel.access$setMRequestingUserId$p(this.a, null);
            RevLinkAnchorViewModel.access$notifyList(this.a);
            if ((r13 instanceof ApiServerException) == true) goto L11;
            r13 = null;
        L11:
            ApiServerException r18 = (ApiServerException) r13;
            if (r18 != null) goto L14;
            return;
        L14:
            if (r18.getErrorCode() != 31012) goto L18;
            RevLinkAnchorViewModel.access$dismiss(this.a);
            return;
        L18:
            return;
        L5:
            r0 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ RevLinkAnchorViewModel a;

        public c(RevLinkAnchorViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            String r3 = (String) r2;
            Intrinsics.checkNotNullParameter(r3, "source");
            if (r3.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L9;
            this.a.doRandom(r3);
            return;
        L9:
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ RevLinkAnchorViewModel a;
        public final /* synthetic */ String b;

        public d(RevLinkAnchorViewModel r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r6) {
            ExtraResponse r7 = (ExtraResponse) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            RevLinkAnchorViewModel r0 = this.a;
            List r1 = ((IRivalRankRecommendResponse) r7.data).getSubTabs();
            if (r1 == null) goto L17;
            Iterator<T> r2 = r1.iterator();
        L5:
            Object r3 = null;
            if (r2.hasNext() == false) goto L13;
            T r4 = r2.next();
            IPkSubTabKey r5 = ((y7) r4).getKey();
            if (r5 == null) goto L11;
            r3 = r5.getActivityId();
        L11:
            if (Intrinsics.areEqual(r3, this.b) == false) goto L5;
            r3 = r4;
        L13:
            y7 r8 = (y7) r3;
            if (r8 == null) goto L17;
            String r9 = r8.getTrackingInfo();
            if (r9 == null) goto L17;
        L19:
            return new Pair(r7, RevLinkAnchorViewModel.access$parseLogInfo(r0, r9));
        L17:
            r9 = "";
            goto L19
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ RevLinkAnchorViewModel a;
        public final /* synthetic */ long b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public e(RevLinkAnchorViewModel r1, long r2, int r4, int r5, String r6, String r7) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }

        public final void accept(Object r13) {
            Pair r14 = (Pair) r13;
            LiveFullLinkPKMonitor r0 = com.bytedance.android.live.revlink.impl.global.b.q();
            if (r0 == null) goto L5;
            LiveFullLinkPKMonitor.s(r0, "battle/rivals/recommend", System.currentTimeMillis() - this.b, this.c, 0, null, 24);
        L5:
            if (r14 == null) goto L14;
            ExtraResponse r15 = (ExtraResponse) r14.getFirst();
            if (r15 == null) goto L15;
            IRivalRankRecommendResponse r4 = (IRivalRankRecommendResponse) r15.data;
            if (r4 == null) goto L16;
            this.a.getRankRecommendResponse().setValue(r4);
            if (this.d != 5) goto L17;
            RevLinkAnchorViewModel.onRankResp$default(this.a, this.e, this.c, this.f, r4, this.b, System.currentTimeMillis(), null, 64, null);
            return;
        L17:
            return;
        L16:
            return;
        L15:
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ int b;

        public f(long r1, int r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r10) {
            Throwable r2 = (Throwable) r10;
            LiveFullLinkPKMonitor r0 = com.bytedance.android.live.revlink.impl.global.b.q();
            if (r0 == null) goto L6;
            LiveFullLinkPKMonitor.r(r0, "battle/rivals/recommend", r2, System.currentTimeMillis() - this.a, this.b, 0, null, 48);
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ RevLinkAnchorViewModel a;

        public g(RevLinkAnchorViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            Pair r10 = (Pair) r9;
            if (r10 == null) goto L67;
            int r0 = ((com.bytedance.android.live.revlink.impl.control.dialog.e) r10.getSecond()).a;
            IPkSubTabKey r1 = RevLinkAnchorViewModel.access$getRecordSelectTabKey$p(this.a);
            if (r1 == null) goto L43;
            if (r1.getInviteType() != 110) goto L43;
            com.bytedance.android.live.revlink.impl.control.dialog.e r2 = (com.bytedance.android.live.revlink.impl.control.dialog.e) r10.getSecond();
            String r5 = null;
            if (r2 == null) goto L27;
            IRivalRankRecommendResponse r3 = r2.c;
            if (r3 == null) goto L27;
            List r4 = r3.getSubTabs();
            if (r4 == null) goto L27;
            Iterator<T> r6 = r4.iterator();
        L16:
            if (r6.hasNext() == false) goto L25;
            T r7 = r6.next();
            IPkSubTabKey r8 = ((y7) r7).getKey();
            if (r8 != null) goto L20;
        L22:
            boolean r12 = false;
        L23:
            if (r12 == false) goto L16;
        L26:
            y7 r13 = (y7) r7;
        L28:
            if (r13 == null) goto L43;
            List r14 = r13.getAreas();
            if (r14 == null) goto L32;
            int r15 = r14.size();
        L33:
            if (r15 <= 0) goto L43;
            RevLinkAnchorViewModel r16 = this.a;
            IPkSubTabKey r17 = RevLinkAnchorViewModel.access$getRecordSelectTabKey$p(r16);
            List r18 = r13.getAreas();
            if (r18 == null) goto L41;
            IPanelArea r19 = (IPanelArea) ListProtector.get(r18, 0);
            if (r19 == null) goto L41;
            t8 r20 = r19.getRivals();
            if (r20 == null) goto L41;
            r5 = r20.getImprId();
        L41:
            RevLinkAnchorViewModel.access$logSubTabShow(r16, r17, r5);
            goto L43
        L32:
            r15 = 0;
            goto L33
        L20:
            if (r8.getInviteType() != 110) goto L22;
            r12 = true;
            goto L23
        L25:
            r7 = null;
        L27:
            r13 = null;
        L43:
            if (r0 != IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal()) goto L46;
            RevLinkAnchorViewModel.access$onDataFollowLoaded(this.a, r10);
            return;
        L46:
            if (r0 != IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal()) goto L49;
            RevLinkAnchorViewModel.access$onRecDataLoaded(this.a, r10);
            return;
        L49:
            if (r0 != IRivalRankRecommendResponse.LoadType.Other.ordinal()) goto L52;
            RevLinkAnchorViewModel.access$onDataLoaded(this.a, r10);
            return;
        L52:
            if (r0 != IRivalRankRecommendResponse.LoadType.OnlyCommonPanel.ordinal()) goto L55;
            this.a.getStopRefreshEvent().setValue(Boolean.TRUE);
            return;
        L55:
            if ((!StringsKt.isBlank(((com.bytedance.android.live.revlink.impl.control.dialog.e) r10.getSecond()).b)) == true) goto L57;
            return;
        L57:
            if ((!Intrinsics.areEqual(((com.bytedance.android.live.revlink.impl.control.dialog.e) r10.getSecond()).b, DataType.FALSE)) == true) goto L59;
            return;
        L59:
            if (r0 != IRivalRankRecommendResponse.LoadType.All.ordinal()) goto L74;
            this.a.getStopRefreshEvent().setValue(Boolean.TRUE);
            RevLinkAnchorViewModel.access$checkTab(this.a, ((com.bytedance.android.live.revlink.impl.control.dialog.e) r10.getSecond()).c);
            this.a.getTabs().setValue(RevLinkAnchorViewModel.access$removeInValidTab(this.a, ((com.bytedance.android.live.revlink.impl.control.dialog.e) r10.getSecond()).c.getSubTabs()));
            return;
        L74:
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ RevLinkAnchorViewModel a;

        public h(RevLinkAnchorViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Pair r4 = (Pair) r3;
            if (r4 == null) goto L5;
            String r0 = (String) r4.getFirst();
        L7:
            if (Intrinsics.areEqual(r0, "init") == false) goto L20;
            if (r4 == null) goto L13;
            com.bytedance.android.live.revlink.impl.control.dialog.f r1 = (com.bytedance.android.live.revlink.impl.control.dialog.f) r4.getSecond();
            if (r1 == null) goto L13;
            if (r1.a != IRivalRankRecommendResponse.LoadType.Other.ordinal()) goto L13;
        L18:
            this.a.getErrorData().setValue((com.bytedance.android.live.revlink.impl.control.dialog.f) r4.getSecond());
            return;
        L13:
            if (r4 == null) goto L21;
            com.bytedance.android.live.revlink.impl.control.dialog.f r2 = (com.bytedance.android.live.revlink.impl.control.dialog.f) r4.getSecond();
            if (r2 != null) goto L17;
            return;
        L17:
            if (r2.a == IRivalRankRecommendResponse.LoadType.All.ordinal()) goto L18;
            return;
        L21:
            return;
        L20:
            return;
        L5:
            r0 = null;
            goto L7
        }
    }

    public static final class i extends i11.c.a {
        public final /* synthetic */ RevLinkAnchorViewModel a;

        public i(RevLinkAnchorViewModel r1) {
            this.a = r1;
        }

        @Override // i11.c.a, i11.c.b
        public final void c(int r1, List<? extends IBaseUser> r2) {
            RevLinkAnchorViewModel.access$notifyList(this.a);
        }
    }

    static {
        Companion = new a();
    }

    private final i11.c.a getAnchorCallback() {
        return (i11.c.a) this.anchorCallback$delegate.getValue();
    }

    private final i11.b getAnchorLinkUserCenter() {
        return (i11.b) this.anchorLinkUserCenter$delegate.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.vm.RevLinkAnchorBaseViewModel
    public String getTag() {
        return "RevLinkAnchor";
    }

    public final boolean isListOpt() {
        return ((Boolean) this.isListOpt$delegate.getValue()).booleanValue();
    }

    public final boolean isRandomOpt() {
        return ((Boolean) this.isRandomOpt$delegate.getValue()).booleanValue();
    }

    private final void checkDataLoadFinish() {
        if (this.isSpeedUpOpt == false) goto L11;
        MutableLiveData<Boolean> r0 = this.dataLoadFinish;
        int r2 = this.loadFlag;
        if ((r2 & 1) == 1) goto L7;
    L9:
        boolean r3 = false;
    L10:
        r0.setValue(Boolean.valueOf(r3));
    L13:
        if (Intrinsics.areEqual((Boolean) this.dataLoadFinish.getValue(), Boolean.TRUE) == true) goto L15;
        return;
    L15:
        if (this.mIsShow == true) goto L27;
        this.mIsShow = true;
        p r4 = getReporter();
        if (r4 == null) goto L28;
        Pair r1 = (Pair) this.data.getValue();
        if (r1 == null) goto L23;
        com.bytedance.android.live.revlink.impl.control.dialog.e r5 = (com.bytedance.android.live.revlink.impl.control.dialog.e) r1.getSecond();
        if (r5 == null) goto L23;
        IRivalRankRecommendResponse r6 = r5.c;
    L24:
        r4.a(r6, false, getLinkAudienceCount(), this.guideType, this.toUserGroup, hasFolow(), this.source, this.enableRank);
        return;
    L23:
        r6 = null;
        goto L24
    L28:
        return;
    L27:
        return;
    L7:
        if ((r2 & 2) != 2) goto L9;
        r3 = true;
        goto L10
    L11:
        this.dataLoadFinish.setValue(Boolean.TRUE);
        goto L13
    }

    private final void checkSelectedPos() {
        List<? extends y7> r0 = this.subTabList;
        IPkSubTabKey r1 = this.recordSelectTabKey;
        boolean r2 = true;
        int r3 = 0;
        if (r1 == null) goto L26;
        int r4 = -1;
        if (r0 == null) goto L22;
        Iterator<? extends y7> r5 = r0.iterator();
        int r6 = 0;
    L8:
        if (r5.hasNext() == false) goto L22;
        y7 r7 = r5.next();
        int r8 = r1.getGroupRivalsType();
        IPkSubTabKey r9 = r7.getKey();
        if (r9 != null) goto L12;
    L18:
        boolean r10 = false;
    L19:
        if (r10 == true) goto L20;
        r6 = r6 + 1;
        goto L8
    L20:
        r4 = r6;
        goto L22
    L12:
        if (r8 != r9.getGroupRivalsType()) goto L18;
        long r12 = r1.getFlexActivityId();
        IPkSubTabKey r13 = r7.getKey();
        if (r13 == null) goto L18;
        if (r12 != r13.getFlexActivityId()) goto L18;
        r10 = true;
    L22:
        if (r4 < 0) goto L26;
        this.selectedPos.setValue(Integer.valueOf(r4));
        return;
    L26:
        if (this.isEnableCheckPos == true) goto L28;
        return;
    L28:
        IGroupRivals r14 = this.followGroupRival;
        List<? extends y7> r15 = r0;
        if (r15 != null) goto L31;
    L34:
        if (r2 == true) goto L75;
        if (r14 == null) goto L76;
        this.isEnableCheckPos = false;
        Iterator<T> r16 = r0.iterator();
        IPkSubTabKey r17 = null;
        y7 r18 = null;
        int r19 = 0;
        int r20 = 0;
    L39:
        if (r16.hasNext() == false) goto L52;
        y7 r22 = (y7) r16.next();
        if (r18 == null) goto L43;
    L45:
        if (r22 == null) goto L51;
        IPkSubTabKey r23 = r22.getKey();
        if (r23 == null) goto L51;
        if (r23.getGroupRivalsType() != IGroupRivals.GroupType.GroupFeedRecommend.ordinal()) goto L51;
        r19 = r3;
    L51:
        r3 = r3 + 1;
        goto L39
    L43:
        if (r22.getSelected() == false) goto L45;
        r20 = r3;
        r18 = r22;
        goto L45
    L52:
        if (r18 == null) goto L60;
        IPkSubTabKey r24 = r18.getKey();
        if (r24 == null) goto L60;
        if (r24.getGroupRivalsType() != IGroupRivals.GroupType.GroupFeedFollowed.ordinal()) goto L60;
        if (getMExpandPosition() > 0) goto L60;
    L61:
        this.selectedPos.setValue(Integer.valueOf(r19));
        if (r0 == null) goto L66;
        y7 r25 = (y7) CollectionsKt.getOrNull(r0, r19);
        if (r25 == null) goto L66;
        r17 = r25.getKey();
    L66:
        setRecordSelectTabKey(r17);
        return;
    L60:
        r19 = r20;
        goto L61
    L76:
        return;
    L75:
        return;
    L31:
        if (r15.isEmpty() == true) goto L34;
        r2 = false;
        goto L34
    }

    private final b0 createDefaultAutoMatchInfo() {
        b0 r0 = vh7.f.c(j8.class);
        j8 r1 = (j8) r0;
        r1.set_matchText((a5) GsonProtectorUtils.fromJson(l97.a.a, s1.B(2131921464), TypesJVMKt.getJavaType(Reflection.typeOf(Text.class))));
        r1.setAccelerateLimit(15);
        r1.setDefaultWaitLimit(60);
        r1.setMainTitle("随机PK");
        r1.setSubTitle("为你寻找PK值相近对手");
        r1.setWaitSec(9);
        k8 r2 = vh7.f.c(k8.class);
        r2.setInviteLimitSec(10);
        r2.setPkAutoMatchIndex(1);
        Unit r3 = Unit.INSTANCE;
        r1.setConfig(r2);
        return r0;
    }

    private final void dismiss() {
        this.onDismissEvent.onComplete();
    }

    private final int getLinkAudienceCount() {
        int r0 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).getMultiInteractMode();
        w r1 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).M1();
        if (v.a(r0, 32) == false) goto L6;
        if (r1 == null) goto L6;
        return r1.w();
    L6:
        return 0;
    }

    private final boolean hasFolow() {
        IGroupRivals r0 = this.followGroupRival;
        if (r0 == null) goto L9;
        List r1 = r0.getRivals();
        if (r1 == null) goto L9;
        if ((!r1.isEmpty()) != true) goto L9;
        return true;
    L9:
        return false;
    }

    private final void notifyList() {
        this.notifyListEvent.setValue(Boolean.TRUE);
    }

    public final boolean isInviteRequesting() {
        if (this.mInvitation == true) goto L11;
        w31.c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r0 != null) goto L7;
    L9:
        return false;
    L7:
        if (r0.p() != true) goto L9;
        return true;
    L11:
        return true;
    }

    public RevLinkAnchorViewModel() {
        this.guideType = "";
        this.toUserGroup = "";
        this.source = "";
        this.searchHintStr = "";
        this.anchorCallback$delegate = LazyKt.lazy(new RevLinkAnchorViewModel$anchorCallback$2(this));
        this.isRandomOpt$delegate = LazyKt.lazy(new C03642(this));
        this.isListOpt$delegate = LazyKt.lazy(new C03632(this));
        b51.b r0 = b51.b.c0;
        r0.getClass();
        this.isSpeedUpOpt = ((Boolean) b51.b.p.getValue(r0, b51.b.a[14])).booleanValue();
        this.isEnableCheckPos = true;
        this.subTabAction = "default";
        this.defaultRandomPkData = new NextLiveData();
        this.errorData = new MutableLiveData();
        this.notifyListEvent = new MutableLiveData();
        this.onDismissEvent = new CompletableSubject();
        this.followListData = new MutableLiveData();
        this.tabs = new MutableLiveData();
        this.stopRefreshEvent = new MutableLiveData();
        this.dataLoadFinish = new MutableLiveData();
        this.randomData = new MutableLiveData();
        this.rankSeasonInfo = new NextLiveData();
        this.popInfo = new NextLiveData();
        this.isSeasonUnlock = new MutableLiveData();
        this.isSeasonTabEnable = new MutableLiveData();
        this.recTitleData = new MutableLiveData();
        this.data = new MutableLiveData();
        this.selectedPos = new MutableLiveData();
        this.showRandomCheckDialogEvent = new MutableLiveData();
        this.rankRecommendResponse = new NextLiveData();
        this.anchorLinkUserCenter$delegate = LazyKt.lazy(RevLinkAnchorViewModel$anchorLinkUserCenter$2.INSTANCE);
        this.mCallback = new i(this);
        this.baseLinkOutListener = new b(this);
        toggleListener(true);
    }

    private final void initDefaultRandomPkData() {
        b0 r0 = createDefaultAutoMatchInfo();
        this.autoMatchInfo = r0;
        this.defaultRandomPkData.setValue(new com.bytedance.android.live.revlink.impl.pk.dialog.vm.a(r0, false));
    }

    private final void initFollow() {
        com.bytedance.android.live.revlink.impl.control.dialog.b r0 = getLoader();
        Pair<String, com.bytedance.android.live.revlink.impl.control.dialog.e> r2 = null;
        if (r0 == null) goto L5;
        int r3 = IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal();
        int r4 = com.bytedance.android.live.revlink.impl.control.dialog.b.r;
        final Pair<String, com.bytedance.android.live.revlink.impl.control.dialog.e> r1 = r0.e(r3, DataType.FALSE);
    L7:
        if (r1 == null) goto L9;
        this.hasFollowCache = true;
        lazyTask(IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal(), new C03611(this, r1));
    L14:
        com.bytedance.android.live.revlink.impl.control.dialog.b r5 = getLoader();
        if (r5 == null) goto L17;
        int r6 = IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal();
        int r7 = com.bytedance.android.live.revlink.impl.control.dialog.b.r;
        r2 = r5.e(r6, DataType.FALSE);
    L17:
        if (r2 == null) goto L19;
        this.hasRecCache = true;
        onRecDataLoaded(r2);
        return;
    L19:
        com.bytedance.android.live.revlink.impl.control.dialog.b r8 = getLoader();
        if (r8 == null) goto L23;
        int r9 = IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal();
        int r10 = com.bytedance.android.live.revlink.impl.control.dialog.b.r;
        if (r8.i(r9, DataType.FALSE) != true) goto L23;
        return;
    L23:
        RevLinkAnchorBaseViewModel.fetchPiece$default(this, IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal(), "init", null, null, 12, null);
        return;
    L9:
        com.bytedance.android.live.revlink.impl.control.dialog.b r12 = getLoader();
        if (r12 == null) goto L13;
        int r13 = IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal();
        int r14 = com.bytedance.android.live.revlink.impl.control.dialog.b.r;
        if (r12.i(r13, DataType.FALSE) == true) goto L14;
    L13:
        RevLinkAnchorBaseViewModel.fetchPiece$default(this, IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal(), "init", null, null, 12, null);
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    public final boolean isAudioRoom() {
        IRoom r0 = getCurRoom();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isLiveTypeAudio() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.vm.RevLinkAnchorBaseViewModel
    public void onCleared() {
        super.onCleared();
        d31.e r0 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r0 != null) goto L5;
    L13:
        com.bytedance.android.live.revlink.impl.pk.service.b r1 = com.bytedance.android.live.revlink.impl.global.b.N();
        if (r1 == null) goto L18;
        i11.b r2 = r1.getLinkUserCenter();
        if (r2 == null) goto L18;
        r2.l(getAnchorCallback());
    L18:
        toggleListener(false);
        k r3 = getMetricUtil();
        if (r3 == null) goto L21;
        r3.c();
    L21:
        k r4 = getMetricUtil();
        if (r4 == null) goto L24;
        r4.b();
    L24:
        i11.b r5 = getAnchorLinkUserCenter();
        if (r5 == null) goto L28;
        r5.l(this.mCallback);
    L28:
        if (this.mIsShow == true) goto L30;
    L32:
        int r6 = com.bytedance.android.live.revlink.impl.pk.utils.e.a;
        IPerformanceManager r7 = jc1.k.f(IPerformanceManager.class);
        if (r7 == null) goto L35;
        r7.onModuleStop("revlink_main_panel");
    L35:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r8 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r8 == null) goto L39;
        Intrinsics.checkNotNullParameter("live_pk_icon", "<set-?>");
        r8.b = "live_pk_icon";
        return;
    L39:
        return;
    L30:
        if (getReporter() == null) goto L32;
        p.b(this.mPageShowTime);
        goto L32
    L5:
        if (this.hasOtherCache == true) goto L7;
    L11:
        boolean r9 = false;
    L12:
        r0.h = r9;
        goto L13
    L7:
        if (this.hasFollowCache == false) goto L11;
        if (this.hasRecCache == false) goto L11;
        r9 = true;
        goto L12
    }

    public final void onTabIn() {
        this.mPageShowTime = System.currentTimeMillis();
        this.mIsShow = true;
        p r1 = getReporter();
        if (r1 == null) goto L12;
        Pair r0 = (Pair) this.data.getValue();
        if (r0 == null) goto L9;
        com.bytedance.android.live.revlink.impl.control.dialog.e r2 = (com.bytedance.android.live.revlink.impl.control.dialog.e) r0.getSecond();
        if (r2 == null) goto L9;
        IRivalRankRecommendResponse r3 = r2.c;
    L10:
        r1.a(r3, true, getLinkAudienceCount(), this.guideType, this.toUserGroup, hasFolow(), this.source, this.enableRank);
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final void onTabOut() {
        if (getReporter() == null) goto L5;
        p.b(this.mPageShowTime);
    L5:
        this.mIsShow = false;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.vm.RevLinkAnchorBaseViewModel
    public void toggleExpand() {
        super.toggleExpand();
        IGroupRivals r0 = this.followGroupRival;
        if (r0 == null) goto L6;
        updateFollowList(r0, this.skinType);
    L6:
        if (getReporter() == null) goto L21;
        boolean r1 = isFollowExpand();
        if (this.enableRank == false) goto L10;
        String r2 = "season_rank";
    L11:
        Intrinsics.checkNotNullParameter(r2, "source");
        HashMap r3 = new HashMap();
        r3.put("source", r2);
        r3.put("anchor_connect_status", DataType.FALSE);
        d31.d r4 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r4 == null) goto L14;
        String r5 = r4.s();
    L15:
        r3.put("room_status", r5);
        if (r1 == false) goto L18;
        String r6 = "more";
    L19:
        r3.put("click_type", r6);
        n r7 = new n();
        Map<String, String> r8 = r7.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        Intrinsics.checkNotNullParameter(r3, "map");
        r8.putAll(r3);
        m r9 = new m();
        r9.b(LogCommon.ROOM);
        r9.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r10 = r7.b;
        ArrayList r12 = (ArrayList) r10;
        r12.addAll(r9.a);
        cy0.e.a.getClass();
        j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r14);
        ((mz0.i) ((f80.a) r14)).w3("livesdk_pk_more_mutual_click", r7.a, r7.b);
        return;
    L18:
        r6 = "close";
        goto L19
    L14:
        r5 = "";
        goto L15
    L10:
        r2 = "pk";
        goto L11
    }

    public final MutableLiveData<Pair<String, com.bytedance.android.live.revlink.impl.control.dialog.e>> getData() {
        return this.data;
    }

    public final MutableLiveData<Boolean> getDataLoadFinish() {
        return this.dataLoadFinish;
    }

    public final NextLiveData<com.bytedance.android.live.revlink.impl.pk.dialog.vm.a> getDefaultRandomPkData() {
        return this.defaultRandomPkData;
    }

    public final MutableLiveData<com.bytedance.android.live.revlink.impl.control.dialog.f> getErrorData() {
        return this.errorData;
    }

    public final MutableLiveData<List<Object>> getFollowListData() {
        return this.followListData;
    }

    public final u8 getInvalidExtra() {
        return this.invalidExtra;
    }

    public final MutableLiveData<Boolean> getNotifyListEvent() {
        return this.notifyListEvent;
    }

    public final CompletableSubject getOnDismissEvent() {
        return this.onDismissEvent;
    }

    public final NextLiveData<r8> getPopInfo() {
        return this.popInfo;
    }

    public final MutableLiveData<com.bytedance.android.live.revlink.impl.pk.dialog.vm.a> getRandomData() {
        return this.randomData;
    }

    public final NextLiveData<IRivalRankRecommendResponse> getRankRecommendResponse() {
        return this.rankRecommendResponse;
    }

    public final NextLiveData<s8> getRankSeasonInfo() {
        return this.rankSeasonInfo;
    }

    public final MutableLiveData<s.a> getRecTitleData() {
        return this.recTitleData;
    }

    public final String getSearchHintStr() {
        return this.searchHintStr;
    }

    public final MutableLiveData<Integer> getSelectedPos() {
        return this.selectedPos;
    }

    public final MutableLiveData<Unit> getShowRandomCheckDialogEvent() {
        return this.showRandomCheckDialogEvent;
    }

    public final long getSkinType() {
        return this.skinType;
    }

    public final MutableLiveData<Boolean> getStopRefreshEvent() {
        return this.stopRefreshEvent;
    }

    public final String getSubTabAction() {
        return this.subTabAction;
    }

    public final MutableLiveData<List<y7>> getTabs() {
        return this.tabs;
    }

    public final boolean isEnableCheckPos() {
        return this.isEnableCheckPos;
    }

    public final MutableLiveData<Boolean> isSeasonTabEnable() {
        return this.isSeasonTabEnable;
    }

    public final MutableLiveData<Boolean> isSeasonUnlock() {
        return this.isSeasonUnlock;
    }

    public static final /* synthetic */ void access$dismiss(RevLinkAnchorViewModel r0) {
        r0.dismiss();
    }

    public static final /* synthetic */ int access$getAnchorLayer$p(RevLinkAnchorViewModel r0) {
        return r0.anchorLayer;
    }

    public static final /* synthetic */ b0 access$getAutoMatchInfo$p(RevLinkAnchorViewModel r0) {
        return r0.autoMatchInfo;
    }

    public static final /* synthetic */ IRivalExtraInfo access$getExtraInfo$p(RevLinkAnchorViewModel r0) {
        return r0.extraInfo;
    }

    public static final /* synthetic */ int access$getLinkAudienceCount(RevLinkAnchorViewModel r0) {
        return r0.getLinkAudienceCount();
    }

    public static final /* synthetic */ boolean access$getMInvitation$p(RevLinkAnchorViewModel r0) {
        return r0.mInvitation;
    }

    public static final /* synthetic */ String access$getMRequestingUserId$p(RevLinkAnchorViewModel r0) {
        return r0.mRequestingUserId;
    }

    public static final /* synthetic */ IRoom access$getMToRoom$p(RevLinkAnchorViewModel r0) {
        return r0.mToRoom;
    }

    public static final /* synthetic */ IPkSubTabKey access$getRecordSelectTabKey$p(RevLinkAnchorViewModel r0) {
        return r0.recordSelectTabKey;
    }

    public static final /* synthetic */ boolean access$hasFolow(RevLinkAnchorViewModel r0) {
        return r0.hasFolow();
    }

    public static final /* synthetic */ void access$notifyList(RevLinkAnchorViewModel r0) {
        r0.notifyList();
    }

    private final void checkTab(IRivalRankRecommendResponse r6) {
        List r0 = r6.getSubTabs();
        ArrayList r1 = new ArrayList();
        if (r0 == null) goto L14;
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L14;
        y7 r3 = (y7) r2.next();
        if (r3 == null) goto L13;
        IPkSubTabKey r4 = r3.getKey();
        if (r4 == null) goto L13;
        if (r4.getGroupRivalsType() == IGroupRivals.GroupType.GroupFeedFollowed.ordinal()) goto L6;
    L13:
        r1.add(r3);
    L14:
        r6.setSubTabs(r1);
        this.subTabList = r1;
    }

    private final void initOther(String r9) {
        LinkRevPanelDataContext r0 = LinkRevPanelDataContext.Companion.getContext();
        if (r0 == null) goto L15;
        Disposable r1 = r0.getLoadCompleteEvent().onEvent().subscribe(new g(this));
        if (r1 == null) goto L7;
        getCd().add(r1);
    L7:
        com.bytedance.live.datacontext.k<Pair<String, com.bytedance.android.live.revlink.impl.control.dialog.f>> r2 = r0.getLoadFailEvent();
        if (r2 == null) goto L15;
        PublishSubject r3 = r2.onEvent();
        if (r3 == null) goto L15;
        Disposable r4 = r3.subscribe(new h(this));
        if (r4 == null) goto L15;
        getCd().add(r4);
    L15:
        if (r9 != null) goto L17;
    L20:
        boolean r5 = true;
    L21:
        if (r5 == false) goto L33;
        com.bytedance.android.live.revlink.impl.control.dialog.b r10 = getLoader();
        if (r10 == null) goto L25;
        int r6 = IRivalRankRecommendResponse.LoadType.Other.ordinal();
        int r7 = com.bytedance.android.live.revlink.impl.control.dialog.b.r;
        final Pair<String, com.bytedance.android.live.revlink.impl.control.dialog.e> r12 = r10.e(r6, DataType.FALSE);
    L26:
        if (r12 == null) goto L28;
        this.hasOtherCache = true;
        lazyTask(IRivalRankRecommendResponse.LoadType.Other.ordinal(), new C03622(this, r12));
        return;
    L28:
        com.bytedance.android.live.revlink.impl.control.dialog.b r13 = getLoader();
        if (r13 == null) goto L32;
        int r8 = IRivalRankRecommendResponse.LoadType.Other.ordinal();
        int r14 = com.bytedance.android.live.revlink.impl.control.dialog.b.r;
        if (r13.i(r8, DataType.FALSE) != true) goto L32;
        return;
    L32:
        RevLinkAnchorBaseViewModel.fetchPiece$default(this, IRivalRankRecommendResponse.LoadType.Other.ordinal(), "init", null, null, 12, null);
        return;
    L25:
        r12 = null;
        goto L26
    L33:
        RevLinkAnchorBaseViewModel.fetchPiece$default(this, IRivalRankRecommendResponse.LoadType.Other.ordinal(), "init", r9, null, 8, null);
        return;
    L17:
        if (StringsKt.isBlank(r9) == true) goto L20;
        r5 = false;
        goto L21
    }

    private final void logThrowable(Throwable r3) {
        String r0 = getTag();
        if (r3 == null) goto L5;
        StackTraceElement[] r4 = r3.getStackTrace();
    L6:
        jy0.d.a(6, r0, r4);
        return;
    L5:
        r4 = null;
        goto L6
    }

    private final void onDataFollowLoaded(Pair<String, com.bytedance.android.live.revlink.impl.control.dialog.e> r7) {
        if (checkDataNeedNotify((String) r7.getFirst(), 2) == true) goto L5;
        return;
    L5:
        this.loadFlag |= 2;
        s2 r0 = ((com.bytedance.android.live.revlink.impl.control.dialog.e) r7.getSecond()).c.getTabRivals();
        if (r0 == null) goto L51;
        Map r1 = r0.getGroupRivals();
        if (r1 == null) goto L51;
        IGroupRivals r2 = (IGroupRivals) r1.get(Long.valueOf(IGroupRivals.GroupType.GroupFeedFollowed.ordinal()));
        if (r2 == null) goto L51;
        this.followGroupRival = r2;
        this.skinType = ((com.bytedance.android.live.revlink.impl.control.dialog.e) r7.getSecond()).c.getSkinType();
        l8 r3 = ((com.bytedance.android.live.revlink.impl.control.dialog.e) r7.getSecond()).c.getSearchBar();
        String r4 = null;
        if (r3 == null) goto L14;
        String r5 = r3.getContent();
    L16:
        if (r5 != null) goto L18;
    L21:
        boolean r6 = true;
    L22:
        if (r6 == true) goto L30;
        DataCenter r8 = this.mDataCenter;
        if (r8 == null) goto L30;
        if (com.bytedance.android.live.revlink.impl.pk.utils.c.a(r8) != true) goto L30;
        KmpEnv r9 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L30;
    L31:
        this.searchHintStr = r5;
        findExpandPosition(r2);
        checkSelectedPos();
        LinkRevPanelDataContext r10 = getDataContext();
        if (r10 == null) goto L39;
        com.bytedance.live.datacontext.m<Boolean> r12 = r10.isOftenLinkList();
        if (r12 == null) goto L39;
        Map r13 = ((com.bytedance.android.live.revlink.impl.control.dialog.e) r7.getSecond()).c.getListAbValueMap();
        if (r13 == null) goto L38;
        r4 = (String) r13.get("is_often_link_list");
    L38:
        r12.setValue(Boolean.valueOf(Intrinsics.areEqual(r4, DataType.TRUE)));
    L39:
        updateFollowList(r2, this.skinType);
        checkDataLoadFinish();
        if (getReporter() == null) goto L42;
        p.c((String) r7.getFirst(), IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal(), ((com.bytedance.android.live.revlink.impl.control.dialog.e) r7.getSecond()).d);
    L42:
        com.bytedance.android.live.revlink.impl.control.dialog.b r14 = getLoader();
        if (r14 == null) goto L45;
        com.bytedance.android.live.revlink.impl.control.dialog.b.l(r14, (String) r7.getFirst(), IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal());
    L45:
        d31.e r15 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r15 == null) goto L48;
        r15.c();
    L48:
        k r16 = getMetricUtil();
        if (r16 == null) goto L51;
        int r17 = getMExpandPosition();
        int r18 = t.c(((com.bytedance.android.live.revlink.impl.control.dialog.e) r7.getSecond()).c);
        String r19 = t.b(((com.bytedance.android.live.revlink.impl.control.dialog.e) r7.getSecond()).c);
        String r20 = (String) r7.getFirst();
        Intrinsics.checkNotNullParameter(r20, "$this$isFromRefresh");
        r16.f(new com.bytedance.android.live.revlink.impl.pk.utils.i(r17, r18, r19, Intrinsics.areEqual(r20, "refresh")));
    L30:
        r5 = s1.B(2131917946);
        goto L31
    L18:
        if (StringsKt.isBlank(r5) == true) goto L21;
        r6 = false;
        goto L22
    L14:
        r5 = null;
    L51:
        com.bytedance.android.live.revlink.impl.control.dialog.b r22 = getLoader();
        if (r22 == null) goto L55;
        r22.n("open");
        return;
    }

    private final void onDataLoaded(Pair<String, com.bytedance.android.live.revlink.impl.control.dialog.e> r8) {
        boolean r1 = true;
        if (checkDataNeedNotify((String) r8.getFirst(), 1) == true) goto L5;
        return;
    L5:
        IRivalRankRecommendResponse r0 = ((com.bytedance.android.live.revlink.impl.control.dialog.e) r8.getSecond()).c;
        this.invalidExtra = r0.getRivalsExtra();
        this.loadFlag |= 1;
        this.autoMatchInfo = r0.getAutoMatchInfo();
        checkTab(((com.bytedance.android.live.revlink.impl.control.dialog.e) r8.getSecond()).c);
        onRandomDataUpdate(((com.bytedance.android.live.revlink.impl.control.dialog.e) r8.getSecond()).c);
        this.data.setValue(r8);
        this.tabs.setValue(removeInValidTab(r0.getSubTabs()));
        checkSelectedPos();
        checkDataLoadFinish();
        if (this.enableRank == true) goto L21;
        s8 r2 = r0.getRankSeasonInfo();
        if (r2 == null) goto L10;
        boolean r3 = r2.getEnableTab();
    L11:
        this.isSeasonTabEnable.setValue(Boolean.valueOf(r3));
        MutableLiveData<Boolean> r4 = this.isSeasonUnlock;
        if (r3 == false) goto L19;
        s8 r5 = r0.getRankSeasonInfo();
        if (r5 == null) goto L16;
        boolean r6 = r5.isUnlockedRank();
    L17:
        if (r6 == false) goto L19;
    L20:
        r4.setValue(Boolean.valueOf(r1));
    L23:
        if (getReporter() == null) goto L31;
        com.bytedance.android.live.revlink.impl.control.dialog.b r7 = getLoader();
        if (r7 == null) goto L27;
        long r9 = r7.c;
    L29:
        if (r9 <= 0) goto L31;
        long r10 = System.currentTimeMillis() - r9;
        HashMap r12 = new HashMap();
        r12.put("pk_load_duration", String.valueOf(r10));
        n r13 = new n();
        Map<String, String> r14 = r13.a;
        Intrinsics.checkNotNullParameter(r14, "map");
        Intrinsics.checkNotNullParameter(r12, "map");
        r14.putAll(r12);
        m r15 = new m();
        r15.b(LogCommon.ROOM);
        ((ArrayList) r13.b).addAll(r15.a);
        cy0.e.a.getClass();
        j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r17);
        ((mz0.i) ((f80.a) r17)).w3("livesdk_pk_panel_time", r13.a, r13.b);
        goto L31
    L27:
        r9 = 0;
    L31:
        com.bytedance.android.live.revlink.impl.control.dialog.b r18 = getLoader();
        if (r18 == null) goto L35;
        r18.c = 0;
    L35:
        if (getReporter() == null) goto L37;
        p.c((String) r8.getFirst(), IRivalRankRecommendResponse.LoadType.Other.ordinal(), ((com.bytedance.android.live.revlink.impl.control.dialog.e) r8.getSecond()).d);
    L37:
        com.bytedance.android.live.revlink.impl.control.dialog.b r19 = getLoader();
        if (r19 == null) goto L41;
        com.bytedance.android.live.revlink.impl.control.dialog.b.l(r19, (String) r8.getFirst(), IRivalRankRecommendResponse.LoadType.Other.ordinal());
        return;
    L41:
        return;
    L16:
        r6 = false;
    L19:
        r1 = false;
        goto L20
    L10:
        r3 = false;
        goto L11
    L21:
        this.popInfo.setValue(r0.getPopInfo());
        goto L23
    }

    private final void onRandomDataUpdate(IRivalRankRecommendResponse r4) {
        this.randomData.setValue(new com.bytedance.android.live.revlink.impl.pk.dialog.vm.a(r4.getAutoMatchInfo(), r4.isNewPkAnchor()));
    }

    private final void onRecDataLoaded(Pair<String, com.bytedance.android.live.revlink.impl.control.dialog.e> r5) {
        if (checkDataNeedNotify((String) r5.getFirst(), 4) == true) goto L5;
        return;
    L5:
        this.loadFlag |= 4;
        s2 r0 = ((com.bytedance.android.live.revlink.impl.control.dialog.e) r5.getSecond()).c.getTabRivals();
        if (r0 == null) goto L41;
        Map r1 = r0.getGroupRivals();
        if (r1 == null) goto L42;
        IGroupRivals r2 = (IGroupRivals) r1.get(Long.valueOf(IGroupRivals.GroupType.GroupFeedRecommend.ordinal()));
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.getRivals() == null) goto L44;
        IGroupRivals r3 = this.followGroupRival;
        if (r3 == null) goto L17;
        List r4 = r3.getSortRivals();
        if (r4 == null) goto L17;
    L19:
        if (TextUtils.isEmpty(r2.getGroupName()) == false) goto L30;
        List r6 = r4;
        if (r6 != null) goto L23;
    L26:
        boolean r7 = true;
    L27:
        if (r7 == false) goto L29;
        String r8 = s1.B(2131917923);
    L31:
        LinkRevPanelDataContext r9 = getDataContext();
        if (r9 == null) goto L35;
        r9.setSelectType(r2.getSelectType());
    L35:
        if (isListOpt() == true) goto L38;
        this.recTitleData.setValue(createRecTitleItem(r2.getImprId(), r8));
    L38:
        if (getReporter() == null) goto L45;
        p.c((String) r5.getFirst(), IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals.ordinal(), ((com.bytedance.android.live.revlink.impl.control.dialog.e) r5.getSecond()).d);
        return;
    L45:
        return;
    L29:
        r8 = s1.B(2131917922);
        goto L31
    L23:
        if (r6.isEmpty() == true) goto L26;
        r7 = false;
        goto L27
    L30:
        r8 = r2.getGroupName();
    L17:
        r4 = r2.getRivals();
        goto L19
    L44:
        return;
    L42:
        return;
    }

    private final Map<String, String> parseLogInfo(String r2) {
        return JsonUtil.jsonObjectToMap(new JSONObject(r2));
    L4:
        return null;
    }

    private final List<y7> removeInValidTab(List<? extends y7> r5) {
        if (r5 == null) goto L4;
        ArrayList r0 = new ArrayList();
        Iterator<? extends y7> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L30;
        y7 r1 = r6.next();
        IPkSubTabKey r2 = r1.getKey();
        if (r2 == null) goto L29;
        if (r2.getType() != IPkSubTabKey.TabType.FlexActivity.ordinal()) goto L29;
        IPkSubTabKey r3 = r1.getKey();
        String r4 = null;
        if (r3 == null) goto L15;
        String r7 = r3.getActivityId();
    L16:
        if (r7 != null) goto L18;
    L21:
        boolean r8 = true;
    L22:
        if (r8 == true) goto L7;
        IPkSubTabKey r9 = r1.getKey();
        if (r9 == null) goto L27;
        r4 = r9.getActivityId();
    L27:
        if (Intrinsics.areEqual(r4, DataType.FALSE) == false) goto L29;
    L18:
        if (StringsKt.isBlank(r7) == true) goto L21;
        r8 = false;
        goto L22
    L15:
        r7 = null;
    L29:
        r0.add(r1);
        goto L7
    L30:
        return r0;
    L4:
        return CollectionsKt.emptyList();
    }

    private final void setRecordSelectTabKey(IPkSubTabKey r5) {
        IPkSubTabKey r0 = this.recordSelectTabKey;
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.getGroupRivalsType());
    L6:
        if (r5 == null) goto L8;
        Integer r2 = Integer.valueOf(r5.getGroupRivalsType());
    L10:
        if ((!Intrinsics.areEqual(r1, r2)) == true) goto L20;
        IPkSubTabKey r3 = this.recordSelectTabKey;
        if (r3 == null) goto L14;
        Long r4 = Long.valueOf(r3.getFlexActivityId());
    L15:
        if (r5 == null) goto L17;
        Long r6 = Long.valueOf(r5.getFlexActivityId());
    L19:
        if ((!Intrinsics.areEqual(r4, r6)) == true) goto L20;
    L24:
        this.recordSelectTabKey = r5;
        return;
    L17:
        r6 = null;
        goto L19
    L14:
        r4 = null;
    L20:
        if (r5 != null) goto L22;
    L23:
        logSubTabShow(r5, null);
        goto L24
    L22:
        if (r5.getInviteType() == 110) goto L24;
    L8:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    private final void toggleListener(boolean r3) {
        if (r3 == false) goto L7;
        com.bytedance.android.live.revenuelink.connect.f r4 = com.bytedance.android.live.revlink.impl.global.b.a();
        if (r4 == null) goto L11;
        r4.addLinkOutListener(7, this.baseLinkOutListener);
        return;
    L11:
        return;
    L7:
        com.bytedance.android.live.revenuelink.connect.f r5 = com.bytedance.android.live.revlink.impl.global.b.a();
        if (r5 == null) goto L13;
        r5.removeLinkOutListener(7, this.baseLinkOutListener);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.vm.RevLinkAnchorBaseViewModel
    public y31.i.a createExpandItem(boolean r6) {
        if (isListOpt() == false) goto L16;
        y31.i.a r0 = new y31.i.a();
        if (r6 == true) goto L13;
        Intrinsics.checkNotNullParameter("更多好友", "<set-?>");
        r0.a = "更多好友";
        if (getReporter() == null) goto L13;
        HashMap r1 = new HashMap();
        r1.put("source", "live_pk_icon");
        r1.put("anchor_connect_status", DataType.FALSE);
        d31.d r2 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r2 == null) goto L11;
        String r3 = r2.s();
    L12:
        r1.put("room_status", r3);
        n r4 = new n();
        Map<String, String> r5 = r4.a;
        Intrinsics.checkNotNullParameter(r5, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r5.putAll(r1);
        m r7 = new m();
        r7.b(LogCommon.ROOM);
        r7.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r8 = r4.b;
        ArrayList r9 = (ArrayList) r8;
        r9.addAll(r7.a);
        cy0.e.a.getClass();
        j r10 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r12 = com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r12);
        ((mz0.i) ((f80.a) r12)).w3("livesdk_pk_more_mutual_show", r4.a, r4.b);
        goto L13
    L11:
        r3 = "";
    L13:
        r0.b = r6;
        return r0;
    L16:
        return super.createExpandItem(r6);
    }

    public final void doRandom(String r9) {
        Intrinsics.checkNotNullParameter(r9, "source");
        DataCenter r1 = this.mDataCenter;
        boolean r2 = false;
        if (r1 == null) goto L7;
        Integer r3 = (Integer) r1.get("data_link_state", 0);
        if (r3 == null) goto L7;
        int r4 = r3.intValue();
    L9:
        if (v.a(r4, 32) == false) goto L13;
        if (e51.b.d.a() == true) goto L13;
    L14:
        ToastUtil.a(2131917956, 0);
        return;
    L13:
        if (v.a(r4, 8) == true) goto L14;
        if (Intrinsics.areEqual(r9, "season_rank") == false) goto L24;
        d51.c r5 = d51.c.A0;
        r5.getClass();
        if (((Boolean) d51.c.y0.getValue(r5, d51.c.a[75])).booleanValue() == false) goto L24;
        if (RandomCheckDataContext.Companion.b() == true) goto L24;
        this.showRandomCheckDialogEvent.setValue(Unit.INSTANCE);
        return;
    L24:
        final Ref.ObjectRef r6 = new Ref.ObjectRef();
        r6.element = r9;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r10 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r10 == null) goto L27;
        String r7 = (String) r6.element;
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r10.c = r7;
    L27:
        String r12 = getTag();
        StringBuilder r8 = new StringBuilder("doRandom:");
        r8.append((String) r6.element);
        r8.append(",");
        i41.a r13 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r13 != null) goto L30;
    L32:
        r8.append(r2);
        jy0.b.d(r12, r8.toString());
        i41.a r14 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r14 != null) goto L35;
    L45:
        com.bytedance.android.live.revlink.impl.pk.utils.j r15 = com.bytedance.android.live.revlink.impl.global.b.O();
        if (r15 == null) goto L59;
        IRoom r16 = null;
        if (r15.c(-1, null, 1) != true) goto L59;
        w31.c r17 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r17 == null) goto L52;
        r16 = r17.k();
    L52:
        onCancel(r16);
        if (this.enableRank == false) goto L55;
        PkAutoMatchManager.AutoMatchRequestSource r18 = PkAutoMatchManager.AutoMatchRequestSource.FromSeasonRank;
    L56:
        PkAutoMatchManager.AutoMatchRequestSource r19 = r18;
        com.bytedance.android.live.revlink.impl.pk.service.a r20 = com.bytedance.android.live.revlink.impl.global.b.M();
        if (r20 == null) goto L59;
        r20.e(getCurRoomId(), this.autoMatchInfo, r19, new AnonymousClass2(this, r6));
        goto L59
    L55:
        r18 = PkAutoMatchManager.AutoMatchRequestSource.FromPkList;
    L59:
        dismiss();
        return;
    L35:
        if (r14.f != true) goto L45;
        HashMap r22 = new HashMap();
        r22.put("pk_description", "routine");
        r22.put("match_type", "single");
        r22.put("source", "pk_banner");
        r22.put("anchor_connect_status", DataType.FALSE);
        r22.put("room_status", "live");
        com.bytedance.android.live.revlink.impl.pk.service.a r0 = com.bytedance.android.live.revlink.impl.global.b.M();
        if (r0 == null) goto L41;
        h0 r23 = r0.d();
        if (r23 == null) goto L41;
        r23.a(r22);
    L41:
        i41.a r24 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r24 == null) goto L44;
        r24.b(AutoMatchSource.Manual);
    L44:
        n r25 = new n();
        Map<String, String> r26 = r25.a;
        Intrinsics.checkNotNullParameter(r26, "map");
        Intrinsics.checkNotNullParameter(r22, "map");
        r26.putAll(r22);
        m r27 = new m();
        LinkCrossRoomDataHolder.a r28 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r27);
        r27.b(LogCommon.ROOM);
        List<Object> r29 = r25.b;
        ArrayList r30 = (ArrayList) r29;
        r30.addAll(r27.a);
        cy0.e.a.getClass();
        j r32 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r33 = com.bytedance.android.scope.m.b(r32).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r33);
        ((mz0.i) ((f80.a) r33)).w3("match_cancel_click", r25.a, r25.b);
        return;
    L30:
        if (r13.f != true) goto L32;
        r2 = true;
    L7:
        r4 = 0;
        goto L9
    }

    @Override // x31.l
    public boolean isRequesting(IRoom r2) {
        String r0 = this.mRequestingUserId;
        if (r0 == null) goto L10;
        if (r2 == null) goto L6;
        String r3 = r2.getOwnerUserIdString();
    L8:
        if (Intrinsics.areEqual(r0, r3) == false) goto L10;
        return true;
    L6:
        r3 = null;
    L10:
        return false;
    }

    @Override // x31.l
    public void onCancel(IRoom r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        long r1 = getCurRoomId();
        LinkCrossRoomDataHolder r0 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r0 == null) goto L7;
        long r3 = r0.c();
    L8:
        cancel(r1, r3, r7);
        ld.a r8 = ld.d.a();
        if (r8 == null) goto L14;
        NextLiveData r9 = r8.ke();
        if (r9 == null) goto L15;
        r9.setValue(0);
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r3 = 0;
        goto L8
    }

    public final void onPageSelected(int r2) {
        List<? extends y7> r0 = this.subTabList;
        if (r0 == null) goto L7;
        y7 r3 = (y7) CollectionsKt.getOrNull(r0, r2);
        if (r3 == null) goto L7;
        IPkSubTabKey r4 = r3.getKey();
    L8:
        setRecordSelectTabKey(r4);
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final void setEnableCheckPos(boolean r1) {
        this.isEnableCheckPos = r1;
    }

    public final void setInvalidExtra(u8 r1) {
        this.invalidExtra = r1;
    }

    public final void setSearchHintStr(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.searchHintStr = r2;
    }

    public final void setSkinType(long r1) {
        this.skinType = r1;
    }

    public final void setSubTabAction(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.subTabAction = r2;
    }

    public static final /* synthetic */ void access$checkTab(RevLinkAnchorViewModel r0, IRivalRankRecommendResponse r1) {
        r0.checkTab(r1);
    }

    public static final /* synthetic */ void access$logThrowable(RevLinkAnchorViewModel r0, Throwable r1) {
        r0.logThrowable(r1);
    }

    public static final /* synthetic */ void access$onDataFollowLoaded(RevLinkAnchorViewModel r0, Pair r1) {
        r0.onDataFollowLoaded(r1);
    }

    public static final /* synthetic */ void access$onDataLoaded(RevLinkAnchorViewModel r0, Pair r1) {
        r0.onDataLoaded(r1);
    }

    public static final /* synthetic */ void access$onRecDataLoaded(RevLinkAnchorViewModel r0, Pair r1) {
        r0.onRecDataLoaded(r1);
    }

    public static final /* synthetic */ Map access$parseLogInfo(RevLinkAnchorViewModel r0, String r1) {
        return r0.parseLogInfo(r1);
    }

    public static final /* synthetic */ List access$removeInValidTab(RevLinkAnchorViewModel r0, List r1) {
        return r0.removeInValidTab(r1);
    }

    public static final /* synthetic */ void access$setAnchorLayer$p(RevLinkAnchorViewModel r0, int r1) {
        r0.anchorLayer = r1;
    }

    public static final /* synthetic */ void access$setAutoMatchInfo$p(RevLinkAnchorViewModel r0, b0 r1) {
        r0.autoMatchInfo = r1;
    }

    public static final /* synthetic */ void access$setExtraInfo$p(RevLinkAnchorViewModel r0, IRivalExtraInfo r1) {
        r0.extraInfo = r1;
    }

    public static final /* synthetic */ void access$setMInvitation$p(RevLinkAnchorViewModel r0, boolean r1) {
        r0.mInvitation = r1;
    }

    public static final /* synthetic */ void access$setMRequestingUserId$p(RevLinkAnchorViewModel r0, String r1) {
        r0.mRequestingUserId = r1;
    }

    public static final /* synthetic */ void access$setMToRoom$p(RevLinkAnchorViewModel r0, IRoom r1) {
        r0.mToRoom = r1;
    }

    public static final /* synthetic */ void access$setRecordSelectTabKey$p(RevLinkAnchorViewModel r0, IPkSubTabKey r1) {
        r0.setRecordSelectTabKey(r1);
    }

    private final boolean checkDataNeedNotify(String r5, int r6) {
        if ((this.loadFlag & r6) == r6) goto L6;
        return true;
    L6:
        if (r6 != 2) goto L13;
        if ((!Intrinsics.areEqual(r5, "init")) == false) goto L13;
        if ((!Intrinsics.areEqual(r5, "cache")) == false) goto L13;
        return true;
    L13:
        if ((!Intrinsics.areEqual(r5, "timer")) == true) goto L15;
    L19:
        return false;
    L15:
        if ((!Intrinsics.areEqual(r5, "init")) == false) goto L19;
        if ((!Intrinsics.areEqual(r5, "cache")) == false) goto L19;
        return true;
    }

    private final s.a createRecTitleItem(String r3, String r4) {
        s.a r0 = new s.a();
        r0.a = r4;
        r0.b = false;
        LinkRevPanelDataContext r1 = getDataContext();
        if (r1 == null) goto L5;
        int r2 = r1.getSelectType();
    L6:
        r0.e = r2;
        r0.c = false;
        r0.d = false;
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.f = r3;
        return r0;
    L5:
        r2 = 0;
        goto L6
    }

    private final void logSubTabShow(IPkSubTabKey r9, String r10) {
        if (r9 != null) goto L5;
        return;
    L5:
        if (getReporter() == null) goto L49;
        boolean r2 = true;
        if (r9.getInviteType() != 110) goto L10;
        String r12 = "custom_preference";
    L26:
        String r0 = this.guideType;
        IRoom r1 = getCurRoom();
        if (r1 == null) goto L29;
        LiveMode r3 = r1.getStreamType();
    L30:
        int r4 = h1.a;
        String r5 = i1.a(r3);
        String r6 = this.subTabAction;
        Intrinsics.checkNotNullParameter(r12, "subTabKey");
        Intrinsics.checkNotNullParameter(r0, "guideType");
        Intrinsics.checkNotNullParameter(r5, "liveType");
        Intrinsics.checkNotNullParameter(r6, "subTabAction");
        HashMap r7 = new HashMap();
        String r8 = "";
        if (r10 != null) goto L38;
        com.bytedance.android.live.revlink.impl.control.d r13 = com.bytedance.android.live.revlink.impl.global.b.f();
        if (r13 == null) goto L37;
        r10 = r13.getRequestId();
        if (r10 != null) goto L38;
    L37:
        r10 = "";
    L38:
        r7.put("request_id", r10);
        r7.put("event_page", "live_detail");
        r7.put("live_type", r5);
        r7.put("source", "live_pk_icon");
        if (r0.length() > 0) goto L42;
        r2 = false;
    L42:
        if (r2 == false) goto L44;
        r7.put("guide_type", r0);
        r7.put("source", "guide");
    L44:
        r7.put("subtab_type", r12);
        r7.put("subtab_action", r6);
        r7.put("anchor_connect_status", DataType.FALSE);
        d31.d r14 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r14 == null) goto L47;
        r8 = r14.s();
    L47:
        r7.put("room_status", r8);
        n r15 = new n();
        Map<String, String> r16 = r15.a;
        Intrinsics.checkNotNullParameter(r16, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r16.putAll(r7);
        m r17 = new m();
        LogCommon r18 = LogCommon.ROOM;
        r17.b(r18);
        LogCommon r19 = LogCommon.PAGE_SOURCE_LOG;
        r17.b(r19);
        List<Object> r20 = r15.b;
        ArrayList r22 = (ArrayList) r20;
        r22.addAll(r17.a);
        cy0.e.a.getClass();
        j r110 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r23 = com.bytedance.android.scope.m.b(r110).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r23);
        ((mz0.i) ((f80.a) r23)).w3("livesdk_pk_subtab_show", r15.a, r15.b);
        n r24 = new n();
        Map<String, String> r25 = r24.a;
        Intrinsics.checkNotNullParameter(r25, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r25.putAll(r7);
        m r26 = new m();
        r26.b(r18);
        r26.b(r19);
        List<Object> r27 = r24.b;
        ArrayList r28 = (ArrayList) r27;
        r28.addAll(r26.a);
        Object r111 = com.bytedance.android.scope.m.b(r110).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r111);
        ((mz0.i) ((f80.a) r111)).w3("livesdk_pk_subtab1_show", r24.a, r24.b);
        return;
    L29:
        r3 = null;
        goto L30
    L10:
        if (r9.getType() != IPkSubTabKey.TabType.FlexActivity.ordinal()) goto L12;
    L13:
        String r29 = r9.getActivityId();
        if (r29 != null) goto L16;
    L19:
        boolean r30 = true;
    L20:
        if (r30 == true) goto L23;
        r12 = "flex_activity";
    L23:
        if (r9.getGroupRivalsType() != IGroupRivals.GroupType.GroupFeedFollowed.ordinal()) goto L25;
        r12 = "mutual_follow";
        goto L26
    L25:
        r12 = "recommend";
        goto L26
    L16:
        if (StringsKt.isBlank(r29) == true) goto L19;
        r30 = false;
        goto L20
    L12:
        if (r9.getType() != IPkSubTabKey.TabType.CommonPanel.ordinal()) goto L23;
    }

    private final void updateFollowList(IGroupRivals r16, long r17) {
        List r0 = r16.getSortRivals();
        if (r0 != null) goto L5;
        r0 = r16.getRivals();
    L5:
        List r1 = r0;
        if (r1 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r16.getGroupName()) == false) goto L10;
        CharSequence r2 = s1.B(2131917858);
    L11:
        boolean r12 = false;
        if (isListOpt() == false) goto L21;
        a5 r3 = r16.getGroupInfo();
        if (r3 == null) goto L18;
        r2 = vh6.c.b(ur2.a.class).Q9(r3);
        if (r2 != null) goto L18;
        r2 = "";
    L18:
        if (r3 == null) goto L20;
        if (r2 != null) goto L21;
    L20:
        String r4 = String.valueOf(r1.size());
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        SpannableStringBuilder r6 = new SpannableStringBuilder(String.format(s1.B(2131921435), Arrays.copyOf(new Object[]{r4}, 1)));
        r6.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#FE2C55")), 6, r4.length() + 6, 17);
        CharSequence r7 = r6;
    L22:
        MutableLiveData<List<Object>> r14 = this.followListData;
        String r8 = r16.getImprId();
        if (isListOpt() == false) goto L26;
    L24:
        boolean r9 = true;
    L29:
        List r10 = RevLinkAnchorBaseViewModel.createFollowItemList$default(this, r1, r8, r7, r17, r9, true, null, 64, null);
        s.a r13 = (s.a) this.recTitleData.getValue();
        if (r13 == null) goto L44;
        IGroupRivals r15 = this.followGroupRival;
        if (r15 == null) goto L35;
        List r18 = r15.getSortRivals();
        if (r18 == null) goto L35;
    L36:
        List r19 = r18;
        if (r19 != null) goto L39;
    L40:
        r12 = true;
    L41:
        if (r12 == true) goto L43;
        r13.a = s1.B(2131917922);
    L43:
        r10.add(r13);
        goto L44
    L39:
        if (r19.isEmpty() == false) goto L41;
    L35:
        r18 = r16.getRivals();
    L44:
        Unit r20 = Unit.INSTANCE;
        r14.setValue(r10);
        return;
    L26:
        if (r1.isEmpty() == false) goto L24;
        r9 = false;
    L21:
        r7 = r2;
        goto L22
    L10:
        r2 = r16.getGroupName();
        goto L11
    }

    public static final /* synthetic */ void access$logSubTabShow(RevLinkAnchorViewModel r0, IPkSubTabKey r1, String r2) {
        r0.logSubTabShow(r1, r2);
    }

    public final void cancel(long r17, long r19, IRoom r22) {
        Intrinsics.checkNotNullParameter(r22, "targetRoom");
        IBaseUser r0 = r22.getOwner();
        String r3 = "";
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r0, "$this$secUidExt");
        String r1 = r0.getCastSecUid();
        if (r1 == null) goto L6;
    L8:
        if (TextUtils.isEmpty(r1) == false) goto L17;
        IBaseUser r2 = r22.getOwner();
        if (r2 == null) goto L12;
        Intrinsics.checkNotNullParameter(r2, "$this$secUidExt");
        String r4 = r2.getCastSecUid();
    L13:
        if (r4 == null) goto L16;
        r3 = r4;
    L16:
        String r13 = r3;
    L18:
        com.bytedance.android.live.revlink.impl.pk.service.b r5 = com.bytedance.android.live.revlink.impl.global.b.N();
        if (r5 == null) goto L24;
        com.bytedance.android.live.revenuelink.connect.n r6 = r5.getLinkOutManagerFn();
        if (r6 == null) goto L25;
        r6.e(new d11.c(1, r19, r22.getId(), r22.getOwnerUserIdString(), r13, 0, "click_item_cancel"), null);
        return;
    L25:
        return;
    L24:
        return;
    L12:
        r4 = null;
        goto L13
    L17:
        r13 = r1;
    L6:
        r1 = "";
        goto L8
    }

    public static /* synthetic */ void doRandom$default(RevLinkAnchorViewModel r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "pk_banner";
    L5:
        r0.doRandom(r1);
    }

    public final void doInit(DataCenter r10, String r12, String r13, String r14, String r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r12, "posStr");
        Intrinsics.checkNotNullParameter(r13, "guideType");
        Intrinsics.checkNotNullParameter(r14, "toUserGroup");
        Intrinsics.checkNotNullParameter(r15, "source");
        this.mPageShowTime = System.currentTimeMillis();
        this.mDataCenter = r10;
        this.guideType = r13;
        this.toUserGroup = r14;
        this.source = r15;
        LinkRevPanelDataContext r17 = getDataContext();
        if (r17 == null) goto L5;
        r17.setReporter(new p(r10));
    L5:
        com.bytedance.android.live.revlink.impl.pk.service.b r18 = com.bytedance.android.live.revlink.impl.global.b.N();
        if (r18 == null) goto L10;
        i11.b r19 = r18.getLinkUserCenter();
        if (r19 == null) goto L10;
        r19.i(getAnchorCallback());
    L10:
        this.enableRank = r16;
        Pair r110 = com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE);
        RandomCheckDataContext r111 = (RandomCheckDataContext) r110.component1();
        Disposable r112 = (Disposable) r110.component2();
        r111.getRandomChecked().setValue(Boolean.valueOf(l51.a.d()));
        com.bytedance.live.datacontext.b.a(r111, RandomCheckDataContext.TAG);
        getCd().add(r112);
        getCd().add(r111.getStartRandomMatch().onEvent().subscribe(new c(this)));
        if (r16 == false) goto L13;
        fetchUserListDataWithLoadType$default(this, 5, 0, DataType.FALSE, "init", IRivalRankRecommendResponse.LoadType.All.ordinal(), null, 32, null);
        return;
    L13:
        initDefaultRandomPkData();
        initOther(r12);
        initFollow();
        int r113 = com.bytedance.android.live.revlink.impl.pk.utils.e.a;
        d51.c r114 = d51.c.A0;
        r114.getClass();
        if (((Boolean) d51.c.A.getValue(r114, d51.c.a[25])).booleanValue() == false) goto L22;
        IPerformanceManager r115 = jc1.k.f(IPerformanceManager.class);
        if (r115 == null) goto L21;
        r115.monitorPerformance("revlink_main_panel_open");
        r115.onModuleStart("revlink_main_panel", null);
        return;
    L21:
        return;
    }

    public final Disposable fetchUserListDataWithLoadType(int r19, int r20, String r22, String r23, int r24, String r25) {
        Intrinsics.checkNotNullParameter(r22, "activityId");
        Intrinsics.checkNotNullParameter(r23, "source");
        Intrinsics.checkNotNullParameter(r25, "posStr");
        long r4 = System.currentTimeMillis();
        boolean r15 = Intrinsics.areEqual(r23, "init");
        if (Intrinsics.areEqual(r23, "init") == false) goto L5;
        String r10 = "";
    L6:
        r31.a r8 = r31.b.a(r31.a.a);
        String r12 = r22.toString();
        int r0 = com.bytedance.android.live.revlink.impl.pk.flexactivity.b.a;
        int r13 = e51.a.c.a();
        int r1 = r23.hashCode();
        if (r1 != 3112) goto L9;
        String r2 = "ai";
        if (r23.equals("ai") == false) goto L17;
    L16:
        String r17 = r2;
    L18:
        Observable r3 = r8.D(r19, r10, r12, r13, r20, r24, r15 ? 1 : 0, r25, r17);
        if (r3 == null) goto L26;
        Observable r5 = r3.map(new d(this, r22));
        if (r5 == null) goto L26;
        Observable r9 = r5.compose(RxUtil.rxSchedulerHelper());
        if (r9 == null) goto L26;
        return r9.subscribe(new e(this, r4, r24, r19, r23, r22), new f(r4, r24));
    L26:
        return null;
    L17:
        r17 = "";
        goto L18
    L9:
        if (r1 != 110364485) goto L17;
        if (r23.equals("timer") == false) goto L17;
        r2 = "cache";
        goto L16
    L5:
        r10 = "common_pk";
        goto L6
    }

    private final void onRankResp(String r12, int r13, String r14, IRivalRankRecommendResponse r15, long r16, long r18, Map<String, String> r20) {
        Pair<String, com.bytedance.android.live.revlink.impl.control.dialog.e> r1 = TuplesKt.to(r12, new com.bytedance.android.live.revlink.impl.control.dialog.e(r13, r14, r15, r16, r18, r20));
        onDataFollowLoaded(r1);
        onRecDataLoaded(r1);
        onDataLoaded(r1);
        this.stopRefreshEvent.setValue(Boolean.TRUE);
        this.rankSeasonInfo.setValue(r15.getRankSeasonInfo());
        LinkRevPanelDataContext r2 = getDataContext();
        if (r2 == null) goto L8;
        com.bytedance.live.datacontext.n<Pair<String, com.bytedance.android.live.revlink.impl.control.dialog.e>> r3 = r2.getLoadCompleteRankEvent();
        if (r3 == null) goto L9;
        r3.setValue(r1);
        return;
    L9:
        return;
    }

    public static /* synthetic */ void doInit$default(RevLinkAnchorViewModel r9, DataCenter r10, String r12, String r13, String r14, String r15, boolean r16, int r17, Object r18) {
        if ((r17 & 2) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r17 & 4) == 0) goto L9;
        String r5 = "";
    L11:
        if ((r17 & 8) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r17 & 16) == 0) goto L17;
        String r7 = "";
    L18:
        r9.doInit(r10, r4, r5, r6, r7, r16);
        return;
    L17:
        r7 = r15;
        goto L18
    L13:
        r6 = r14;
        goto L15
    L9:
        r5 = r13;
        goto L11
    L5:
        r4 = r12;
        goto L7
    }

    public static /* synthetic */ Disposable fetchUserListDataWithLoadType$default(RevLinkAnchorViewModel r7, int r8, int r9, String r10, String r12, int r13, String r14, int r15, Object r16) {
        if ((r15 & 32) == 0) goto L6;
        r14 = "";
    L6:
        return r7.fetchUserListDataWithLoadType(r8, r9, r10, r12, r13, r14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onRankResp$default(RevLinkAnchorViewModel r12, String r13, int r14, String r15, IRivalRankRecommendResponse r16, long r17, long r18, Map r20, int r22, Object r23) {
        if ((r22 & 64) == 0) goto L5;
        Map r10 = null;
    L6:
        r12.onRankResp(r13, r14, r15, r16, r17, r18, r10);
        return;
    L5:
        r10 = r20;
        goto L6
    }

    public void onInvite(IRoom r19, int r20, IRivalExtraInfo r22, int r23, m2 r24, List<IBattleRivalTag> r25, int r26, int r27, String r28, HashMap<String, String> r29, boolean r210) {
        Intrinsics.checkNotNullParameter(r29, "logMap");
        if (this.mInvitation == false) goto L5;
        return;
    L5:
        IRoom r0 = getCurRoom();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r19 != null) goto L11;
        return;
    L11:
        if (r41.f.a == false) goto L15;
        com.bytedance.tools.kcp.spongepreference.runtime.a r1 = l51.a.l0;
        KProperty[] r5 = l51.a.a;
        if (((Boolean) r1.getValue(null, r5[73])).booleanValue() == true) goto L28;
        ToastUtil.a(2131914800, 0);
        r1.setValue(null, r5[73], Boolean.TRUE);
    L28:
        com.bytedance.android.live.revlink.impl.pk.utils.j r2 = com.bytedance.android.live.revlink.impl.global.b.O();
        if (r2 != null) goto L31;
        return;
    L31:
        if (r2.c(r20, r19.getOwnerUserIdString(), 0) != true) goto L60;
        com.bytedance.android.live.revlink.impl.pk.utils.j r3 = com.bytedance.android.live.revlink.impl.global.b.O();
        if (r3 != null) goto L36;
        return;
    L36:
        if (r3.a(r19.getOwnerUserIdString(), r20) != true) goto L61;
        i41.a r4 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r4 != null) goto L41;
    L45:
        long r6 = r0.getId();
        String r7 = l51.a.m();
        int r8 = l51.a.j();
        if (r24 != null) goto L48;
        String r9 = "";
    L49:
        String r12 = r9;
        k r10 = getMetricUtil();
        if (r10 == null) goto L52;
        long r13 = r10.a();
    L53:
        invite(r19, r6, r7, r8, r20, r22, r23, "", r25, r12, r27, r13, r28, r29, r210);
        d31.e r14 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r14 == null) goto L59;
        r14.b(r26);
        return;
    L59:
        return;
    L52:
        r13 = 0;
        goto L53
    L48:
        r9 = r24.getBattleAttachedInfo();
        goto L49
    L41:
        if (r4.f != true) goto L45;
        i41.a r15 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r15 == null) goto L45;
        r15.b(AutoMatchSource.Manual);
        goto L45
    L61:
        return;
    L60:
        return;
    L15:
        w31.c r16 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r16 == null) goto L28;
        if (r16.p() != true) goto L28;
        i11.b r17 = getAnchorLinkUserCenter();
        if (r17 == null) goto L28;
        List<IBaseUser> r18 = r17.getInviteeList();
        if (r18 == null) goto L28;
        if (r18.size() != 1) goto L28;
        com.bytedance.tools.kcp.spongepreference.runtime.a r30 = l51.a.c0;
        KProperty[] r32 = l51.a.a;
        int r33 = ((Number) r30.getValue(null, r32[62])).intValue();
        if (r33 >= 2) goto L28;
        ToastUtil.a(2131921465, 0);
        r30.setValue(null, r32[62], Integer.valueOf(r33 + 1));
        goto L28
    }

    @Override // x31.l
    public /* bridge */ /* synthetic */ void onInvite(IRoom r13, int r14, IRivalExtraInfo r15, int r16, m2 r17, List r18, int r19, int r20, String r22, HashMap r23, Boolean r24) {
        onInvite(r13, r14, r15, r16, r17, r18, r19, r20, r22, r23, r24.booleanValue());
    }

    public final void invite(IRoom r34, long r35, String r37, int r38, int r39, IRivalExtraInfo r40, int r42, String r43, List<? extends IBattleRivalTag> r44, String r45, int r46, long r47, String r48, HashMap<String, String> r49, boolean r50) {
        Intrinsics.checkNotNullParameter(r34, "targetRoom");
        Intrinsics.checkNotNullParameter(r49, "logMap");
        if (this.mInvitation == false) goto L5;
        return;
    L5:
        this.mToRoom = r34;
        this.mInvitation = true;
        this.mRequestingUserId = r34.getOwnerUserIdString();
        this.extraInfo = r40;
        this.anchorLayer = r42;
        notifyList();
        v3 r2 = null;
        if (r50 == false) goto L8;
        IBattleConfigSetting r3 = (IBattleConfigSetting) vh7.f.c(IBattleConfigSetting.class);
        r3.setModType(PkBaseDataContext.PKModType.SeasonRank.getType());
        IBattleConfigSetting r9 = r3;
    L9:
        IPKLinkBizDataService r18 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r18 == null) goto L30;
        long r19 = r34.getId();
        IBaseUser r4 = r34.getOwner();
        if (r4 == null) goto L17;
        String r5 = iz.a.a(r4);
        if (r5 == null) goto L17;
        String r22 = r5;
    L18:
        IBaseUser r6 = r34.getOwner();
        if (r6 == null) goto L24;
        Intrinsics.checkNotNullParameter(r6, "$this$secUidExt");
        String r7 = r6.getCastSecUid();
        if (r7 == null) goto L24;
        String r23 = r7;
    L25:
        String r8 = l51.a.m();
        int r10 = l51.a.j();
        Intrinsics.checkNotNull(r43);
        e21.b r25 = com.bytedance.android.live.revlink.impl.global.b.h();
        if (r25 == null) goto L28;
        int r12 = com.bytedance.android.live.revlink.impl.pk.utils.l.b;
        r2 = e21.b.b(r25, com.bytedance.android.live.revlink.impl.pk.utils.l.g.c, null, r48, String.valueOf(r46 + 1), null, null, 112);
    L28:
        IPKLinkBizDataService.b.b(r18, r34, r19, r22, r23, 0, r39, new com.bytedance.android.live.revlink.impl.mergepk.pkdouble.f(r44, r8, r10, r43, 0, r9, r45, r46, r47, r2, null, r49, 2048));
        return;
    L24:
        r23 = "";
    L17:
        r22 = "";
        goto L18
    L30:
        return;
    L8:
        r9 = null;
        goto L9
    }
}
