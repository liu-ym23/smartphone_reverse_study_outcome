package com.bytedance.android.live.revlink.impl.region;

import android.graphics.RectF;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenuelink.rtc.f;
import com.bytedance.android.live.revlink.impl.multianchor.service.g;
import com.bytedance.android.live.revlink.impl.pk.utils.h;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.scope.m;
import com.bytedance.badger.collect.impl.BuildConfig;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.p;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import dq2.r;
import fr2.i0;
import fr2.j1;
import fr2.s;
import fr2.w;
import fr2.w1;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import p11.i;
import rc0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u008a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ¥\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002¦\u0001B+\u0012\b\u0010\u007f\u001a\u0004\u0018\u00010~\u0012\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u0001\u0012\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u0001¢\u0006\u0006\b£\u0001\u0010¤\u0001J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J \u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0016\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017J\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001bJ\u0014\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001bH\u0016J\u0018\u0010\"\u001a\n\u0018\u00010 j\u0004\u0018\u0001`!2\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\u0014\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001bH\u0016J\u0010\u0010$\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u0006J\b\u0010%\u001a\u00020\nH\u0016J\u001c\u0010'\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00062\n\u0010&\u001a\u00060 j\u0002`!H\u0016J\u0016\u0010'\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u001dJ\u001a\u0010*\u001a\u00020\n2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001bJ\u0016\u0010+\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u001dJ\u0006\u0010,\u001a\u00020\nJ\b\u0010-\u001a\u00020\nH\u0016J\b\u0010.\u001a\u00020\nH\u0016J\u0014\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001bH\u0016J \u00100\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0014\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001701H\u0016J\u0014\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002030\u001bH\u0016J\u0014\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002030\u001bH\u0016J8\u00109\u001a\u00020\n2.\u00108\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002030\u001b06j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002030\u001b`7H\u0016J8\u0010:\u001a\u00020\n2.\u00108\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002030\u001b06j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002030\u001b`7H\u0016J8\u0010;\u001a\u00020\n2.\u00108\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002030\u001b06j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002030\u001b`7H\u0016J8\u0010<\u001a\u00020\n2.\u00108\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002030\u001b06j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002030\u001b`7H\u0016J8\u0010=\u001a\u00020\n2.\u00108\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001b06j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001b`7H\u0016J8\u0010>\u001a\u00020\n2.\u00108\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001b06j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001b`7H\u0016J8\u0010?\u001a\u00020\n2.\u00108\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001b06j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001b`7H\u0016J8\u0010@\u001a\u00020\n2.\u00108\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001b06j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001b`7H\u0016J\u0006\u0010A\u001a\u00020\nR\u0018\u0010D\u001a\u00060Bj\u0002`C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010GR\u0016\u0010I\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR!\u0010Q\u001a\b\u0012\u0004\u0012\u00020L0K8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\"\u0010S\u001a\u00020R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XRp\u0010Z\u001a^\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002030\u001b06j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002030\u001b`7\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001b06j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001b`70Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[Rc\u0010d\u001aJ\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0]j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d`^0\\j$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0]j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d`^`_8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cRp\u0010e\u001a^\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002030\u001b06j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002030\u001b`7\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001b06j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001b`70Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010[Rc\u0010h\u001aJ\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0]j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d`^0\\j$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0]j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d`^`_8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010a\u001a\u0004\bg\u0010cR\u0018\u0010i\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010k\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR0\u0010m\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0]j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d`^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR0\u0010o\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0]j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d`^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010nRe\u0010u\u001aL\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001b060pj0\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001b06j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001b`7`q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u0010a\u001a\u0004\bs\u0010tRe\u0010x\u001aL\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001b060pj0\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001b06j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001b`7`q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bv\u0010a\u001a\u0004\bw\u0010tR\u0016\u0010y\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010JR\u0016\u0010z\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010JR\u0016\u0010{\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010JR\u0016\u0010|\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010JR\u0016\u0010}\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010JR\u0017\u0010\u007f\u001a\u0004\u0018\u00010~8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001a\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001a\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001a\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0087\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001a\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008b\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001a\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u008f\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001a\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0093\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001a\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0097\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001a\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009b\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0018\u0010¢\u0001\u001a\u00030\u009f\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b \u0001\u0010¡\u0001¨\u0006§\u0001"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/region/RevLinkWindowRegionContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lp11/i;", "Lkc0/i;", "Lfr2/s;", "getRenderFilter", "", "scene", "", "isForce", "", "disableRenderFilterForLiveCore", "disableRenderFilterForPlayer", "releaseRenderFilterForLiveCore", "releaseRenderFilterForPlayer", "enable", "enableRenderFilterForPlayer", "enableRenderFilterForLiveCore", BuildConfig.BUILD_TYPE, "Lcom/bytedance/android/live/revlink/impl/region/d;", "getRevUiRegionUpdater", "Lcom/bytedance/android/live/revlink/impl/region/c;", "getRevStreamRegionUpdater", "", "width", "height", "updateRenderSize", "", "getLogParams", "Lpc0/c;", "getRegions", "key", "Landroid/graphics/RectF;", "Lcom/bytedance/live/platform/api/graphics/RectF;", "getStreamRegionRect", "getStreamRegions", "getRegion", "clearStreamRegion", "rect", "updateStreamRegion", "region", "dataMap", "updateRegions", "updateRegion", "notifyRegionUpdate", "notifyStreamRegionUpdate", "initRenderFilter", "getUidToStreamRegionKeyMap", "enableRenderFilter", "Lkotlin/Pair;", "getSurfaceSize", "Ldq2/r;", "getRevRegions", "getRevStreamRegions", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "newObserver", "registerRevRegionObserver", "unRegisterRevRegionObserver", "registerRevStreamRegionObserver", "unRegisterRevStreamRegionObserver", "registerRegionObserver", "unRegisterRegionObserver", "registerStreamRegionObserver", "unRegisterStreamRegionObserver", "onLinkDestroy", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "renderW", "I", "renderH", "mIsAnchor", "Z", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/revlink/impl/multianchor/service/g;", "partnerService$delegate", "Lcom/bytedance/live/datacontext/p;", "getPartnerService", "()Lcom/bytedance/live/datacontext/j;", "partnerService", "Lo51/e;", "uiLayout", "Lo51/e;", "getUiLayout", "()Lo51/e;", "setUiLayout", "(Lo51/e;)V", "", "regionObMap", "Ljava/util/Map;", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/revenue/platform/api/core/ConcurrentHashMap;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/MutableLiveData;", "recordRegionsLiveData$delegate", "Lkotlin/Lazy;", "getRecordRegionsLiveData", "()Landroidx/lifecycle/MutableLiveData;", "recordRegionsLiveData", "streamRegionObMap", "recordStreamRegionsLiveData$delegate", "getRecordStreamRegionsLiveData", "recordStreamRegionsLiveData", "uiRegionUpdater", "Lcom/bytedance/android/live/revlink/impl/region/d;", "streamRegionUpdater", "Lcom/bytedance/android/live/revlink/impl/region/c;", "uiRegions", "Ljava/util/concurrent/ConcurrentHashMap;", "streamRegions", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "uiObsSet$delegate", "getUiObsSet", "()Ljava/util/HashSet;", "uiObsSet", "streamObsSet$delegate", "getStreamObsSet", "streamObsSet", "calledLiveCoreInit", "calledPlayerInit", "calledLiveCoreEnable", "calledPlayerEnable", "calledRenderFilterEnable", "Lld/a;", "linkDataSet", "Lld/a;", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "roomService", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lcom/bytedance/android/live/revenuelink/rtc/f;", "getAnchorLinkRtcService", "()Lcom/bytedance/android/live/revenuelink/rtc/f;", "anchorLinkRtcService", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/f;", "getLinkPlayHelper", "()Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/f;", "linkPlayHelper", "Lw31/c;", "getPkLinkUtils", "()Lw31/c;", "pkLinkUtils", "Lcom/bytedance/android/live/revlink/impl/pk/utils/h;", "getLinkStreamRegionUtils", "()Lcom/bytedance/android/live/revlink/impl/pk/utils/h;", "linkStreamRegionUtils", "Lcom/bytedance/android/live/revlink/impl/service/internal/a;", "getLinkRevInternalService", "()Lcom/bytedance/android/live/revlink/impl/service/internal/a;", "linkRevInternalService", "Lcom/bytedance/android/live/revlink/impl/multianchor/service/d;", "getMultiAnchorService", "()Lcom/bytedance/android/live/revlink/impl/multianchor/service/d;", "multiAnchorService", "Lor2/d;", "getKmpPlayerService", "()Lor2/d;", "kmpPlayerService", "<init>", "(Lld/a;Lcom/bytedance/android/livesdk/revenue/service/room/c;Lcom/bytedance/android/live/revlink/impl/global/c;)V", "Companion", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkWindowRegionContext extends DataContext implements i, kc0.i {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final b Companion = null;
    public static final String TAG = "RevLinkWindowRegionContext";
    private boolean calledLiveCoreEnable;
    private boolean calledLiveCoreInit;
    private boolean calledPlayerEnable;
    private boolean calledPlayerInit;
    private boolean calledRenderFilterEnable;
    private final CompositeDisposable cd;
    private final ld.a linkDataSet;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private boolean mIsAnchor;
    private final p partnerService$delegate;
    private final Lazy recordRegionsLiveData$delegate;
    private final Lazy recordStreamRegionsLiveData$delegate;
    private final Map<Observer<Map<String, r>>, Observer<Map<String, pc0.c>>> regionObMap;
    private int renderH;
    private int renderW;
    private final com.bytedance.android.livesdk.revenue.service.room.c roomService;
    private final Lazy streamObsSet$delegate;
    private final Map<Observer<Map<String, r>>, Observer<Map<String, pc0.c>>> streamRegionObMap;
    private c streamRegionUpdater;
    private final ConcurrentHashMap<String, pc0.c> streamRegions;
    private o51.e uiLayout;
    private final Lazy uiObsSet$delegate;
    private d uiRegionUpdater;
    private final ConcurrentHashMap<String, pc0.c> uiRegions;

    public static final class a implements Action {
        public final /* synthetic */ RevLinkWindowRegionContext a;

        public a(RevLinkWindowRegionContext r1) {
            this.a = r1;
        }

        public final void run() {
            RevLinkWindowRegionContext.access$getCd$p(this.a).clear();
            RevLinkWindowRegionContext.access$release(this.a);
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(RevLinkWindowRegionContext.class, "partnerService", "getPartnerService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new b();
    }

    private final MutableLiveData<ConcurrentHashMap<String, pc0.c>> getRecordRegionsLiveData() {
        return (MutableLiveData) this.recordRegionsLiveData$delegate.getValue();
    }

    private final MutableLiveData<ConcurrentHashMap<String, pc0.c>> getRecordStreamRegionsLiveData() {
        return (MutableLiveData) this.recordStreamRegionsLiveData$delegate.getValue();
    }

    private final HashSet<Observer<Map<String, pc0.c>>> getStreamObsSet() {
        return (HashSet) this.streamObsSet$delegate.getValue();
    }

    private final HashSet<Observer<Map<String, pc0.c>>> getUiObsSet() {
        return (HashSet) this.uiObsSet$delegate.getValue();
    }

    public final Map<String, String> getLogParams() {
        Pair[] r0 = new Pair[6];
        r0[0] = TuplesKt.to("renderW", String.valueOf(this.renderW));
        r0[1] = TuplesKt.to("renderH", String.valueOf(this.renderH));
        b03.a r1 = b03.a.a;
        r0[2] = TuplesKt.to("screenW", String.valueOf(s1.y()));
        r0[3] = TuplesKt.to("screenH", String.valueOf(s1.w()));
        if (this.calledRenderFilterEnable == false) goto L5;
        String r2 = DataType.TRUE;
    L6:
        r0[4] = TuplesKt.to("enableRender", r2);
        if (getLinkStreamRegionUtils() == null) goto L10;
        String r3 = h.c(this.streamRegions);
        if (r3 == null) goto L10;
    L11:
        r0[5] = TuplesKt.to("layerP", r3);
        return MapsKt.mapOf(r0);
    L10:
        r3 = "";
        goto L11
    L5:
        r2 = DataType.FALSE;
        goto L6
    }

    public final j<g> getPartnerService() {
        return (j) this.partnerService$delegate.a(this, $$delegatedProperties[0]);
    }

    private final f getAnchorLinkRtcService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m0();
    }

    private final or2.d getKmpPlayerService() {
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        m.e.getClass();
        Object r0 = m.b(r1).b(or2.d.class);
        Intrinsics.checkNotNull(r0);
        return (com.bytedance.live.kmp.core.c) r0;
    }

    private final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f getLinkPlayHelper() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkPlayHelper();
    }

    private final com.bytedance.android.live.revlink.impl.service.internal.a getLinkRevInternalService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Do();
    }

    private final h getLinkStreamRegionUtils() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkStreamRegionUtils();
    }

    private final com.bytedance.android.live.revlink.impl.multianchor.service.d getMultiAnchorService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.R8();
    }

    private final w31.c getPkLinkUtils() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkLinkUtils();
    }

    private final s getRenderFilter() {
        com.bytedance.android.livesdk.revenue.service.room.c r0 = this.roomService;
        if (r0 == null) goto L12;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L12;
        com.bytedance.android.livesdk.revenue.pushstream.a r2 = r1.getCommonLiveStream();
        if (r2 == null) goto L12;
        j1 r3 = r2.j();
        if (r3 == null) goto L12;
        w1 r4 = r3.E();
        if (r4 == null) goto L12;
        return r4;
    L12:
        f r5 = getAnchorLinkRtcService();
        if (r5 == null) goto L21;
        com.bytedance.android.live.revenuelink.rtc.i r6 = r5.getRtcManager();
        if (r6 == null) goto L21;
        vc0.a r7 = r6.getLiveCore();
        if (r7 == null) goto L21;
        fr2.p r8 = i0.a(r7);
        if (r8 == null) goto L21;
        return r8.E();
    L21:
        return null;
    }

    private final void release() {
        jy0.b.d(TAG, BuildConfig.BUILD_TYPE);
        disableRenderFilterForPlayer("", true);
        disableRenderFilterForLiveCore("", true);
        releaseRenderFilterForPlayer();
        releaseRenderFilterForLiveCore();
        this.uiRegions.clear();
        getRecordRegionsLiveData().setValue(null);
        getRecordStreamRegionsLiveData().setValue(null);
        this.streamRegions.clear();
        Iterator<T> r0 = getUiObsSet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Observer r1 = (Observer) r0.next();
        getRecordRegionsLiveData().removeObserver(r1);
        goto L4
    L6:
        getUiObsSet().clear();
        this.regionObMap.clear();
        Iterator<T> r2 = getStreamObsSet().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        Observer r3 = (Observer) r2.next();
        getRecordStreamRegionsLiveData().removeObserver(r3);
        goto L8
    L10:
        getStreamObsSet().clear();
        this.streamRegionObMap.clear();
        j<g> r4 = getPartnerService();
        if (r4 == null) goto L18;
        g r5 = (g) r4.getValue();
        if (r5 == null) goto L19;
        r5.reset();
        return;
    L19:
        return;
    }

    private final void releaseRenderFilterForLiveCore() {
        if (this.calledLiveCoreInit == true) goto L5;
        return;
    L5:
        s r0 = getRenderFilter();
        if (r0 == null) goto L9;
        jy0.b.d(TAG, "releaseRenderFilterForLiveCore");
        r0.release();
        this.calledLiveCoreInit = false;
        return;
    }

    private final void releaseRenderFilterForPlayer() {
        if (this.calledPlayerInit == true) goto L5;
        return;
    L5:
        jy0.b.d(TAG, "releaseRenderFilterForPlayer");
        getKmpPlayerService().releaseEffect();
        this.calledPlayerInit = false;
    }

    public void clearStreamRegion() {
        this.streamRegions.clear();
    }

    public Map<String, pc0.c> getRegions() {
        ConcurrentHashMap<String, pc0.c> r0 = this.uiRegions;
        pc0.c r1 = r0.get("left");
        com.bytedance.android.livesdk.revenue.service.room.c r2 = this.roomService;
        String r3 = null;
        if (r2 == null) goto L11;
        com.bytedance.android.livesdk.revenue.room.a r4 = r2.getRoomContext();
        if (r4 == null) goto L11;
        IRoomBase r5 = r4.getCommonRoom();
        if (r5 == null) goto L11;
        IBaseUser r6 = r5.getOwnerKt();
        if (r6 == null) goto L11;
        String r7 = r6.getIdString();
    L12:
        boolean r8 = false;
        if (r1 == null) goto L22;
        if (r7 != null) goto L16;
    L19:
        boolean r9 = true;
    L20:
        if (r9 == true) goto L22;
        r0.put(r7, r1);
        goto L22
    L16:
        if (StringsKt.isBlank(r7) == true) goto L19;
        r9 = false;
    L22:
        pc0.c r10 = r0.get("right");
        w31.c r12 = getPkLinkUtils();
        if (r12 == null) goto L25;
        r3 = r12.c();
    L25:
        if (r10 == null) goto L32;
        if (r3 != null) goto L28;
    L29:
        r8 = true;
    L30:
        if (r8 == true) goto L32;
        r0.put(r3, r10);
        goto L32
    L28:
        if (StringsKt.isBlank(r3) == false) goto L30;
    L32:
        return r0;
    L11:
        r7 = null;
        goto L12
    }

    @Override // p11.i
    public Map<String, r> getRevRegions() {
        LinkedHashMap r0 = new LinkedHashMap();
        Map<String, pc0.c> r1 = getRegions();
        if (r1 == null) goto L8;
        Iterator<Map.Entry<String, pc0.c>> r2 = r1.entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        Map.Entry<String, pc0.c> r3 = r2.next();
        r0.put(r3.getKey(), com.bytedance.android.live.revlink.impl.region.b.a(r3.getValue()));
    L8:
        return r0;
    }

    public final c getRevStreamRegionUpdater() {
        if (this.streamRegionUpdater != null) goto L6;
        this.streamRegionUpdater = new c(this.linkDataSet, this.roomService, this.linkFakeGlobalService);
    L6:
        return this.streamRegionUpdater;
    }

    @Override // p11.i
    public Map<String, r> getRevStreamRegions() {
        LinkedHashMap r0 = new LinkedHashMap();
        Map<String, pc0.c> r1 = getStreamRegions();
        if (r1 == null) goto L8;
        Iterator<Map.Entry<String, pc0.c>> r2 = r1.entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        Map.Entry<String, pc0.c> r3 = r2.next();
        r0.put(r3.getKey(), com.bytedance.android.live.revlink.impl.region.b.a(r3.getValue()));
    L8:
        return r0;
    }

    public final d getRevUiRegionUpdater() {
        if (this.uiRegionUpdater != null) goto L6;
        this.uiRegionUpdater = new d(this.roomService, this.linkFakeGlobalService);
    L6:
        return this.uiRegionUpdater;
    }

    public Map<String, String> getUidToStreamRegionKeyMap() {
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.livesdk.revenue.service.room.c r1 = this.roomService;
        String r4 = null;
        int r5 = 0;
        String r7 = "";
        if (r1 == null) goto L46;
        com.bytedance.android.livesdk.revenue.room.a r2 = r1.getRoomContext();
        if (r2 == null) goto L46;
        if (r2.getCommonIsAnchor() != true) goto L46;
        com.bytedance.android.live.revlink.impl.service.internal.a r3 = getLinkRevInternalService();
        if (r3 == null) goto L11;
        int r6 = r3.getCurrentMode();
    L13:
        if (com.bytedance.android.live.utils.c.a(r6, 64) == false) goto L22;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r8 = getMultiAnchorService();
        if (r8 == null) goto L33;
        i11.b r9 = r8.getLinkUserCenter();
        if (r9 == null) goto L33;
        Map<String, String> r10 = r9.g();
        if (r10 == null) goto L33;
        r0.putAll(r10);
    L33:
        cy0.e.a.getClass();
        cy0.j r12 = cy0.e.a.a;
        m.e.getClass();
        Object r13 = m.b(r12).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r13);
        IBaseUser r14 = ((com.bytedance.live.kmp.core.c) r13).b();
        if (r14 == null) goto L37;
        String r15 = r14.getIdString();
        if (r15 == null) goto L37;
    L39:
        if (r15.length() <= 0) goto L41;
        r5 = 1;
    L41:
        if (r5 == 0) goto L102;
        h r16 = getLinkStreamRegionUtils();
        if (r16 == null) goto L45;
        r7 = r16.a();
    L45:
        r0.put(r15, r7);
    L102:
        return r0;
    L37:
        r15 = "";
        goto L39
    L22:
        if (com.bytedance.android.live.utils.c.a(r6, 4) == false) goto L33;
        w31.c r17 = getPkLinkUtils();
        if (r17 == null) goto L26;
        r4 = r17.c();
    L26:
        w31.c r18 = getPkLinkUtils();
        if (r18 == null) goto L30;
        String r19 = r18.b();
        if (r19 == null) goto L30;
    L31:
        if (r4 == null) goto L33;
        r0.put(r4, r19);
    L30:
        r19 = "";
        goto L31
    L11:
        r6 = 0;
    L46:
        com.bytedance.android.live.revlink.impl.service.internal.a r20 = getLinkRevInternalService();
        if (r20 == null) goto L50;
        r5 = r20.getCurrentMode();
    L50:
        if (com.bytedance.android.live.utils.c.a(r5, 64) == false) goto L59;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r22 = getMultiAnchorService();
        if (r22 == null) goto L102;
        i11.b r23 = r22.getLinkUserCenter();
        if (r23 == null) goto L102;
        Map<String, String> r24 = r23.g();
        if (r24 == null) goto L102;
        r0.putAll(r24);
        goto L102
    L59:
        if (com.bytedance.android.live.utils.c.a(r5, 4) == false) goto L102;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r25 = getLinkPlayHelper();
        if (r25 != null) goto L63;
    L86:
        com.bytedance.android.livesdk.revenue.service.room.c r26 = this.roomService;
        if (r26 == null) goto L97;
        com.bytedance.android.livesdk.revenue.room.a r27 = r26.getRoomContext();
        if (r27 == null) goto L97;
        IRoomBase r28 = r27.getCommonRoom();
        if (r28 == null) goto L97;
        IBaseUser r29 = r28.getOwnerKt();
        if (r29 == null) goto L97;
        String r30 = r29.getIdString();
        if (r30 == null) goto L97;
        r0.put(r30, r30);
    L97:
        w31.c r32 = getPkLinkUtils();
        if (r32 == null) goto L100;
        r4 = r32.c();
    L100:
        if (r4 == null) goto L102;
        r0.put(r4, r4);
        goto L102
    L63:
        if (r25.b() != true) goto L86;
        com.bytedance.android.livesdk.revenue.service.room.c r33 = this.roomService;
        if (r33 == null) goto L75;
        com.bytedance.android.livesdk.revenue.room.a r34 = r33.getRoomContext();
        if (r34 == null) goto L75;
        IRoomBase r35 = r34.getCommonRoom();
        if (r35 == null) goto L75;
        IBaseUser r36 = r35.getOwnerKt();
        if (r36 == null) goto L75;
        String r37 = r36.getIdString();
        if (r37 == null) goto L75;
        r0.put(r37, vh6.c.b(qr2.c.class).getSelfAnchorLinkMicId());
    L75:
        w31.c r38 = getPkLinkUtils();
        if (r38 == null) goto L78;
        r4 = r38.c();
    L78:
        w31.c r39 = getPkLinkUtils();
        if (r39 == null) goto L84;
        String r40 = r39.b();
        if (r40 == null) goto L84;
        r7 = r40;
    L84:
        if (r4 == null) goto L102;
        r0.put(r4, r7);
        goto L102
    }

    public void initRenderFilter() {
        if (this.mIsAnchor == true) goto L10;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r0 = getLinkPlayHelper();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L11:
        jy0.b.d(TAG, "initRenderFilter isInLink=" + r1);
        if (r1 == false) goto L14;
        this.calledLiveCoreInit = true;
        return;
    L14:
        this.calledPlayerInit = true;
        return;
    L7:
        if (r0.b() != true) goto L9;
    L10:
        r1 = true;
        goto L11
    }

    public final void onLinkDestroy() {
        jy0.b.d(TAG, "onLinkDestroy");
        this.renderW = 0;
        this.renderH = 0;
        this.uiLayout = o51.e.f.e;
        this.calledRenderFilterEnable = false;
        String r0 = "";
        disableRenderFilterForPlayer("", true);
        disableRenderFilterForLiveCore("", true);
        releaseRenderFilterForPlayer();
        releaseRenderFilterForLiveCore();
        this.uiRegions.clear();
        this.streamRegions.clear();
        if (this.mIsAnchor == false) goto L8;
        h r1 = getLinkStreamRegionUtils();
        if (r1 == null) goto L7;
        r0 = r1.a();
    L7:
        updateStreamRegion(r0, new RectF(0.0f, 0.0f, 1.0f, 1.0f));
    L8:
        d r2 = this.uiRegionUpdater;
        if (r2 == null) goto L11;
        ((LinkedHashMap) r2.a).clear();
        r2.b = null;
        r2.c = null;
        r2.d = null;
    L11:
        c r3 = this.streamRegionUpdater;
        if (r3 == null) goto L14;
        r3.a = null;
    L14:
        notifyStreamRegionUpdate();
        notifyRegionUpdate();
        j<g> r4 = getPartnerService();
        if (r4 == null) goto L20;
        g r5 = (g) r4.getValue();
        if (r5 == null) goto L21;
        r5.reset();
        return;
    L21:
        return;
    }

    @Override // p11.i
    public Pair<Integer, Integer> getSurfaceSize() {
        h r0 = getLinkStreamRegionUtils();
        if (r0 == null) goto L7;
        Pair<Integer, Integer> r1 = r0.b(this.uiLayout);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return TuplesKt.to(0, 0);
    }

    public final void notifyRegionUpdate() {
        getRecordRegionsLiveData().setValue(this.uiRegions);
    }

    public void notifyStreamRegionUpdate() {
        getRecordStreamRegionsLiveData().setValue(this.streamRegions);
    }

    public Map<String, pc0.c> getStreamRegions() {
        return this.streamRegions;
    }

    public final o51.e getUiLayout() {
        return this.uiLayout;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(RevLinkWindowRegionContext r0) {
        return r0.cd;
    }

    public static final /* synthetic */ h access$getLinkStreamRegionUtils$p(RevLinkWindowRegionContext r0) {
        return r0.getLinkStreamRegionUtils();
    }

    public static final /* synthetic */ s access$getRenderFilter(RevLinkWindowRegionContext r0) {
        return r0.getRenderFilter();
    }

    public static final /* synthetic */ void access$release(RevLinkWindowRegionContext r0) {
        r0.release();
    }

    public final pc0.c getRegion(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.uiRegions.get(r2);
    }

    public RectF getStreamRegionRect(String r5) {
        Intrinsics.checkNotNullParameter(r5, "key");
        pc0.c r6 = this.streamRegions.get(r5);
        if (r6 == null) goto L5;
        Intrinsics.checkNotNullParameter(r6, "$this$toRectF");
        float r1 = r6.b;
        float r2 = r6.c;
        return new RectF(r1, r2, r6.d + r1, r6.e + r2);
    L5:
        return null;
    }

    public void registerRegionObserver(Observer<Map<String, pc0.c>> r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        if (getUiObsSet().contains(r2) == false) goto L5;
        return;
    L5:
        getUiObsSet().add(r2);
        getRecordRegionsLiveData().observeForever(r2);
    }

    public void registerRevRegionObserver(final Observer<Map<String, r>> r3) {
        Intrinsics.checkNotNullParameter(r3, "newObserver");
        Observer<Map<String, pc0.c>> r0 = new RevLinkWindowRegionContext$registerRevRegionObserver$wrapper$1(this, r3);
        registerRegionObserver(r0);
        this.regionObMap.put(r3, r0);
    }

    public void registerRevStreamRegionObserver(final Observer<Map<String, r>> r3) {
        Intrinsics.checkNotNullParameter(r3, "newObserver");
        Observer<Map<String, pc0.c>> r0 = new RevLinkWindowRegionContext$registerRevStreamRegionObserver$wrapper$1(this, r3);
        registerStreamRegionObserver(r0);
        this.streamRegionObMap.put(r3, r0);
    }

    public void registerStreamRegionObserver(Observer<Map<String, pc0.c>> r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        if (getStreamObsSet().contains(r2) == false) goto L5;
        return;
    L5:
        getStreamObsSet().add(r2);
        getRecordStreamRegionsLiveData().observeForever(r2);
    }

    public final void setUiLayout(o51.e r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.uiLayout = r2;
    }

    public void unRegisterRegionObserver(Observer<Map<String, pc0.c>> r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        if (getUiObsSet().contains(r2) == true) goto L5;
        return;
    L5:
        getUiObsSet().remove(r2);
        getRecordRegionsLiveData().removeObserver(r2);
    }

    public void unRegisterRevRegionObserver(Observer<Map<String, r>> r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        Observer<Map<String, pc0.c>> r0 = this.regionObMap.get(r2);
        if (r0 != null) goto L5;
        return;
    L5:
        unRegisterRegionObserver(r0);
        this.regionObMap.remove(r2);
    }

    public void unRegisterRevStreamRegionObserver(Observer<Map<String, r>> r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        Observer<Map<String, pc0.c>> r0 = this.streamRegionObMap.get(r2);
        if (r0 != null) goto L5;
        return;
    L5:
        unRegisterStreamRegionObserver(r0);
        this.streamRegionObMap.remove(r2);
    }

    public void unRegisterStreamRegionObserver(Observer<Map<String, pc0.c>> r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        if (getStreamObsSet().contains(r2) == true) goto L5;
        return;
    L5:
        getStreamObsSet().remove(r2);
        getRecordStreamRegionsLiveData().removeObserver(r2);
    }

    public final void updateRegions(Map<String, pc0.c> r3) {
        Intrinsics.checkNotNullParameter(r3, "dataMap");
        jy0.b.d(TAG, "updateRegions " + r3);
        this.uiRegions.clear();
        this.uiRegions.putAll(r3);
    }

    private final void disableRenderFilterForLiveCore(String r5, boolean r6) {
        if (this.calledLiveCoreEnable == true) goto L5;
        return;
    L5:
        s r0 = getRenderFilter();
        if (r0 == null) goto L12;
        boolean r1 = r0.isEnable();
        jy0.b.d(TAG, "disableRenderFilterForLiveCore curEnable=" + r1 + " isSingle=" + r0.y0());
        if (r1 == false) goto L10;
        this.calledLiveCoreEnable = false;
        com.bytedance.android.live.revlink.impl.pk.utils.e.b();
    L10:
        l.a(true, false, r5, r6);
        return;
    }

    private final void disableRenderFilterForPlayer(String r4, boolean r5) {
        if (this.calledPlayerEnable == true) goto L5;
        return;
    L5:
        boolean r0 = getKmpPlayerService().M();
        jy0.b.d(TAG, "disableRenderFilterForPlayer curEnable=" + r0);
        if (r0 == false) goto L9;
        l.a(false, false, r4, r5);
        this.calledPlayerEnable = false;
        com.bytedance.android.live.revlink.impl.pk.utils.e.b();
        return;
    }

    public final boolean updateRegion(String r4, pc0.c r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "region");
        pc0.c r0 = this.uiRegions.get(r4);
        if (r0 != null) goto L5;
    L8:
        this.uiRegions.put(r4, r5);
        jy0.b.d(TAG, "uiRegions key=" + r4 + " region=" + r5);
        return true;
    L5:
        if (r0.equals(r5) != true) goto L8;
        return false;
    }

    public final void updateRenderSize(int r1, int r2) {
        this.renderW = r1;
        this.renderH = r2;
    }

    public boolean updateStreamRegion(String r12, RectF r13) {
        Intrinsics.checkNotNullParameter(r12, "key");
        Intrinsics.checkNotNullParameter(r13, "rect");
        pc0.c r1 = this.streamRegions.get(r12);
        if (r1 == null) goto L16;
        Intrinsics.checkNotNullParameter(r1, "$this$isSame");
        Intrinsics.checkNotNullParameter(r13, "rectF");
        if (Float.compare(r1.b, r13.left) == 0) goto L7;
    L13:
        boolean r2 = false;
    L14:
        if (r2 != true) goto L16;
        return false;
    L7:
        if (Float.compare(r1.c, r13.top) != 0) goto L13;
        if (Float.compare(r1.d, r13.right - r13.left) != 0) goto L13;
        if (Float.compare(r1.e, r13.bottom - r13.top) != 0) goto L13;
        r2 = true;
    L16:
        ConcurrentHashMap<String, pc0.c> r3 = this.streamRegions;
        Intrinsics.checkNotNullParameter(r13, "$this$toLinkRegion");
        Intrinsics.checkNotNullParameter(r12, "key");
        float r6 = r13.left;
        float r7 = r13.top;
        r3.put(r12, new pc0.c(r12, r6, r7, r13.right - r6, r13.bottom - r7));
        jy0.b.d(TAG, "updateStreamRegion key=" + r12 + " rect=" + r13);
        return true;
    }

    public final boolean updateStreamRegion(String r4, pc0.c r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "region");
        pc0.c r0 = this.streamRegions.get(r4);
        if (r0 != null) goto L5;
    L8:
        this.streamRegions.put(r4, r5);
        jy0.b.d(TAG, "updateStreamRegion key=" + r4 + " region=" + r5);
        return true;
    L5:
        if (r0.equals(r5) != true) goto L8;
        return false;
    }

    public RevLinkWindowRegionContext(ld.a r3, com.bytedance.android.livesdk.revenue.service.room.c r4, com.bytedance.android.live.revlink.impl.global.c r5) {
        this.linkDataSet = r3;
        this.roomService = r4;
        this.linkFakeGlobalService = r5;
        CompositeDisposable r6 = new CompositeDisposable();
        this.cd = r6;
        this.partnerService$delegate = ConstantKt.c(this);
        this.uiLayout = o51.e.f.e;
        this.regionObMap = new HashMap();
        this.recordRegionsLiveData$delegate = LazyKt.lazy(RevLinkWindowRegionContext$recordRegionsLiveData$2.INSTANCE);
        this.streamRegionObMap = new HashMap();
        this.recordStreamRegionsLiveData$delegate = LazyKt.lazy(RevLinkWindowRegionContext$recordStreamRegionsLiveData$2.INSTANCE);
        this.uiRegions = new ConcurrentHashMap();
        this.streamRegions = new ConcurrentHashMap();
        this.uiObsSet$delegate = LazyKt.lazy(RevLinkWindowRegionContext$uiObsSet$2.INSTANCE);
        this.streamObsSet$delegate = LazyKt.lazy(RevLinkWindowRegionContext$streamObsSet$2.INSTANCE);
        if (r4 == null) goto L7;
        com.bytedance.android.livesdk.revenue.room.a r7 = r4.getRoomContext();
        if (r7 == null) goto L7;
        boolean r8 = r7.getCommonIsAnchor();
    L8:
        this.mIsAnchor = r8;
        registerStreamRegionObserver(new AnonymousClass1(this));
        if (this.mIsAnchor == false) goto L15;
        h r9 = getLinkStreamRegionUtils();
        if (r9 == null) goto L13;
        String r10 = r9.a();
    L14:
        updateStreamRegion(r10, new RectF(0.0f, 0.0f, 1.0f, 1.0f));
        goto L15
    L13:
        r10 = "";
    L15:
        com.bytedance.revenue.platform.api.core.rx.f.a(getOnCleared().subscribe(new a(this)), r6);
        return;
    L7:
        r8 = false;
        goto L8
    }

    private final void enableRenderFilterForLiveCore(String r5, boolean r6, boolean r7) {
        s r0 = getRenderFilter();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEnable() == r6) goto L12;
        jy0.b.d(TAG, "enableRenderFilterForLiveCore enable:" + r6);
        l.a(true, r6, r5, r7);
        this.calledLiveCoreEnable = r6;
        if (r6 == false) goto L11;
        int r8 = com.bytedance.android.live.revlink.impl.pk.utils.e.a;
        IPerformanceManager r9 = k.f(IPerformanceManager.class);
        if (r9 == null) goto L12;
        r9.monitorPerformance("revlink_gift_show");
        r9.onModuleStart("revlink_gift_show", com.bytedance.android.live.revlink.impl.pk.utils.e.a());
        goto L12
    L11:
        com.bytedance.android.live.revlink.impl.pk.utils.e.b();
    L12:
        if (r6 == false) goto L31;
        h r10 = getLinkStreamRegionUtils();
        if (r10 == null) goto L32;
        Pair<Integer, Integer> r12 = r10.b(this.uiLayout);
        if (r12 == null) goto L35;
        r0.M3(((Number) r12.getFirst()).intValue(), ((Number) r12.getSecond()).intValue());
        ConcurrentHashMap<String, pc0.c> r13 = this.streamRegions;
        if (r13 != null) goto L21;
        return;
    L21:
        if (getLinkStreamRegionUtils() == null) goto L34;
        String r14 = h.c(r13);
        if (r14 == null) goto L36;
        w r15 = r0.j0();
        if (r15 == null) goto L28;
        r15.e0("LiveGrids", r14);
    L28:
        jy0.b.d(TAG, "enableRenderFilter notifyStreamRegionUpdate:".concat(r14));
        return;
    L36:
        return;
    L34:
        return;
    L35:
        return;
    L32:
        return;
    }

    private final void enableRenderFilterForPlayer(String r5, boolean r6, boolean r7) {
        or2.d r0 = getKmpPlayerService();
        if (r0.M() == r6) goto L10;
        jy0.b.d(TAG, "enableRenderFilterForPlayer enable:" + r6);
        l.a(false, r6, r5, r7);
        this.calledPlayerEnable = r6;
        if (r6 == false) goto L9;
        int r8 = com.bytedance.android.live.revlink.impl.pk.utils.e.a;
        IPerformanceManager r9 = k.f(IPerformanceManager.class);
        if (r9 == null) goto L10;
        r9.monitorPerformance("revlink_gift_show");
        r9.onModuleStart("revlink_gift_show", com.bytedance.android.live.revlink.impl.pk.utils.e.a());
        goto L10
    L9:
        com.bytedance.android.live.revlink.impl.pk.utils.e.b();
    L10:
        if (r6 == false) goto L20;
        ConcurrentHashMap<String, pc0.c> r10 = this.streamRegions;
        if (r10 != null) goto L14;
        return;
    L14:
        if (getLinkStreamRegionUtils() == null) goto L17;
        String r12 = h.c(r10);
        if (r12 == null) goto L17;
    L18:
        jy0.b.d(TAG, "enableRenderFilter notifyStreamRegionUpdate:".concat(r12));
        r0.eb(r12);
        return;
    L17:
        r12 = "";
        goto L18
    }

    public void enableRenderFilter(String r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        boolean r1 = true;
        if (this.mIsAnchor == true) goto L10;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r0 = getLinkPlayHelper();
        if (r0 != null) goto L7;
    L9:
        r1 = false;
        goto L10
    L7:
        if (r0.b() != true) goto L9;
    L10:
        jy0.b.a(TAG, "enableRenderFilter isInLink=" + r1 + " enable=" + r5);
        if (r1 == false) goto L13;
        enableRenderFilterForLiveCore(r4, r5, r6);
        return;
    L13:
        enableRenderFilterForPlayer(r4, r5, r6);
    }
}
