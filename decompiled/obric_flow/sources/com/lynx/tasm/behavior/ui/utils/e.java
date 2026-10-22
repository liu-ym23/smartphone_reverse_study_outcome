package com.lynx.tasm.behavior.ui.utils;

import ai.j0;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.forest.chain.fetchers.BuiltinFetcher;
import com.bytedance.forest.chain.fetchers.CDNFetcher;
import com.bytedance.forest.chain.fetchers.GeckoFetcher;
import com.bytedance.forest.chain.fetchers.MemoryFetcher;
import com.bytedance.forest.chain.fetchers.NewlyBuiltinFetcher;
import com.bytedance.forest.model.FetcherType;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.w;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.ies.xelement.viewpager.LynxTabBarView;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalInputParamException;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.JsonObject;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.v0;
import com.obric.launcher.widget.R$drawable;
import io.reactivex.exceptions.ProtocolViolationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Proxy;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import m.u;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Object f10745a;

    public static int a(int r5, int r10) {
        if (r10 != 255) goto L6;
        return r5;
    L6:
        if (r10 == 0) goto L8;
        int r11 = r10 + (r10 >> 7);
        int r12 = (((r5 >>> 24) * r11) >> 8) << 24;
        return (r5 & ViewCompat.MEASURED_SIZE_MASK) | r12;
    L8:
        return r5 & ViewCompat.MEASURED_SIZE_MASK;
    }

    public static cj.g b(cj.g r13, HashMap r14) {
        if (r13 != null) goto L5;
        return null;
    L5:
        HashMap r5 = r13.f1198b;
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator r11 = r5.entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L13;
        Map.Entry r12 = (Map.Entry) r11.next();
        if (r14.get(r12.getKey()) != null) goto L7;
        if (((cj.i) r12.getValue()).g.f1199a == DefaultType.NONE) goto L7;
        r10.put(r12.getKey(), r12.getValue());
        goto L7
    L13:
        Iterator r15 = r10.entrySet().iterator();
    L15:
        if (r15.hasNext() == false) goto L17;
        Map.Entry r16 = (Map.Entry) r15.next();
        cj.i r17 = (cj.i) r16.getValue();
        r14.put(r16.getKey(), e(r17.f1205h, r17));
        goto L15
    L17:
        Iterator r18 = r5.entrySet().iterator();
    L19:
        if (r18.hasNext() == false) goto L131;
        Map.Entry r19 = (Map.Entry) r18.next();
        String r20 = (String) r19.getKey();
        cj.i r21 = (cj.i) r19.getValue();
        Object r22 = r14.get(r20);
        if (r21.f1202a == false) goto L26;
        if (r22 != null) goto L26;
        throw new IllegalInputParamException(j0.q(new StringBuilder(), (String) r19.getKey(), " param is missing from input"));
    L26:
        Class r23 = r21.f1205h;
        boolean r24 = true;
        if (Intrinsics.areEqual(r23, String.class) == false) goto L35;
        if (r22 != null) goto L30;
    L69:
        if (r22 == null) goto L19;
        if (r21.e == false) goto L19;
        boolean r25 = Intrinsics.areEqual(r23, String.class);
        List r110 = r21.f1206i;
        if (r25 == true) goto L75;
        boolean r26 = Intrinsics.areEqual(r23, Number.class);
        List r27 = r21.f1207j;
        if (r26 == true) goto L82;
        if (Intrinsics.areEqual(r23, Map.class) == false) goto L19;
        if (r110.isEmpty() == false) goto L94;
        if (r27.isEmpty() == true) goto L19;
        Map r28 = (Map) r22;
        if (r28.isEmpty() == true) goto L126;
        Iterator r29 = r28.entrySet().iterator();
    L115:
        if (r29.hasNext() == false) goto L126;
        Object r30 = ((Map.Entry) r29.next()).getValue();
        if ((r30 instanceof Number) == false) goto L121;
        if (r27.contains(Integer.valueOf(((Number) r30).intValue())) == true) goto L115;
    L127:
        if (r24 == false) goto L19;
        throw new IllegalInputParamException(((String) r19.getKey()) + " has wrong value.should be one of " + r27 + " but got " + r22);
    L121:
        if (r30 != null) goto L125;
        throw new IllegalInputParamException("the key is null");
    L125:
        throw new IllegalInputParamException("the key is not a number");
    L126:
        r24 = false;
        goto L127
    L94:
        Map r31 = (Map) r22;
        if (r31.isEmpty() == true) goto L103;
        Iterator r32 = r31.entrySet().iterator();
    L99:
        if (r32.hasNext() == false) goto L103;
        if (CollectionsKt.contains(r110, ((Map.Entry) r32.next()).getValue()) == true) goto L99;
    L104:
        if (r24 == false) goto L19;
        throw new IllegalInputParamException(((String) r19.getKey()) + " has wrong type.should be one of " + r110 + " but got " + r22);
    L103:
        r24 = false;
        goto L104
    L82:
        if ((r22 instanceof Number) == false) goto L89;
        if (r27.contains(Integer.valueOf(((Number) r22).intValue())) == true) goto L19;
        throw new IllegalInputParamException(((String) r19.getKey()) + " has wrong value.should be one of " + r27 + " but got " + r22);
    L89:
        throw new IllegalInputParamException("the key is not a number");
    L75:
        if (CollectionsKt.contains(r110, r22) == true) goto L19;
        throw new IllegalInputParamException(((String) r19.getKey()) + " has wrong type.should be one of " + r110 + " but got " + r22);
    L30:
        if ((r22 instanceof String) == true) goto L69;
        throw new IllegalInputParamException(androidx.room.jarjarred.org.antlr.runtime.a.u(new StringBuilder(), (String) r19.getKey(), " param has wrong declared type. except string,but ", r22));
    L35:
        if (Intrinsics.areEqual(r23, Number.class) == false) goto L43;
        if (r22 == null) goto L69;
        if ((r22 instanceof Number) == true) goto L69;
        throw new IllegalInputParamException(androidx.room.jarjarred.org.antlr.runtime.a.u(new StringBuilder(), (String) r19.getKey(), " param has wrong declared type. except number,but ", r22));
    L43:
        if (Intrinsics.areEqual(r23, Boolean.class) == false) goto L45;
        boolean r33 = true;
    L46:
        if (r33 == false) goto L54;
        if (r22 == null) goto L69;
        if ((r22 instanceof Boolean) == true) goto L69;
        throw new IllegalInputParamException(androidx.room.jarjarred.org.antlr.runtime.a.u(new StringBuilder(), (String) r19.getKey(), " param has wrong declared type. except boolean,but ", r22));
    L54:
        if (Intrinsics.areEqual(r23, List.class) == false) goto L62;
        if (r22 == null) goto L69;
        if ((r22 instanceof List) == true) goto L69;
        throw new IllegalInputParamException(androidx.room.jarjarred.org.antlr.runtime.a.u(new StringBuilder(), (String) r19.getKey(), " param has wrong declared type. except List ,but ", r22));
    L62:
        if (Intrinsics.areEqual(r23, Map.class) == false) goto L69;
        if (r22 == null) goto L69;
        if ((r22 instanceof Map) == true) goto L69;
        throw new IllegalInputParamException(androidx.room.jarjarred.org.antlr.runtime.a.u(new StringBuilder(), (String) r19.getKey(), " param has wrong declared type. except Map ,but ", r22));
    L45:
        r33 = Intrinsics.areEqual(r23, Boolean.TYPE);
        goto L46
    L131:
        return r13;
    }

    public static BaseModel c(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        JsonObject r10 = new JsonObject();
        Object r11 = Proxy.newProxyInstance(r5.getClassLoader(), new Class[]{r5}, new o1.g(r5, r10));
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type T of com.bytedance.ai.bridge.core.utils.ResultModelArguments.createModel");
        return (BaseModel) r11;
    }

    public static com.bytedance.forest.chain.a d(Request r12, w r13, com.bytedance.forest.postprocessor.h r14, com.bytedance.forest.utils.e r15) {
        LinkedList r5 = new LinkedList();
        if (r12.getOnlyOnline() == false) goto L6;
        r12.setFetcherSequence(CollectionsKt.mutableListOf(new FetcherType[]{FetcherType.f4314c}));
    L9:
        if (r12.getFetcherSequence().isEmpty() == false) goto L12;
        com.bytedance.forest.utils.d.b(r15.g, 6, "ResourceFetchScheduler", "Fetcher sequence is empty", true, null, "fetcher_sequence_empty_error", 16);
        r12.setFetcherSequence(CollectionsKt.toMutableList(com.bytedance.forest.model.b.f4359a));
    L12:
        if (r12.getDisableBuiltin() == false) goto L15;
        r12.getFetcherSequence().remove(FetcherType.f4313b);
    L15:
        if (r12.getDisableCdn() == false) goto L18;
        r12.getFetcherSequence().remove(FetcherType.f4314c);
    L18:
        if (r12.getDisableOffline() == false) goto L20;
        r12.getFetcherSequence().remove(FetcherType.f4312a);
    L20:
        Iterator<FetcherType> r10 = r12.getFetcherSequence().iterator();
    L22:
        if (r10.hasNext() == false) goto L41;
        int r11 = r10.next().ordinal();
        if (r11 != 0) goto L26;
        r5.add(GeckoFetcher.class);
        goto L22
    L26:
        if (r11 != 1) goto L28;
        if (r12.getUseGeckoNewlyBuiltin() == false) goto L37;
        GenericDeclaration r16 = NewlyBuiltinFetcher.class;
    L38:
        r5.add(r16);
        goto L22
    L37:
        r16 = BuiltinFetcher.class;
        goto L38
    L28:
        if (r11 != 2) goto L30;
        r5.add(CDNFetcher.class);
        goto L22
    L30:
        if (r11 != 3) goto L22;
        r5.add(MemoryFetcher.class);
        goto L22
    L41:
        return new com.bytedance.forest.chain.a(r12, r13, r5, r14, r15);
    L6:
        if (r12.getEnableMemoryCache() == false) goto L9;
        r12.getFetcherSequence().add(0, FetcherType.d);
        goto L9
    }

    public static Object e(Class r5, cj.i r10) {
        boolean r11 = true;
        if (Intrinsics.areEqual(r5, Number.class) == false) goto L19;
        DefaultType r12 = r10.g.f1199a;
        int r13 = com.bytedance.sdk.xbridge.cn.platform.lynx.e.f7368a[r12.ordinal()];
        cj.h r14 = r10.g;
        if (r13 == 1) goto L17;
        if (r13 == 2) goto L15;
        if (r13 == 3) goto L13;
        return Integer.valueOf(r14.d);
    L13:
        return Integer.valueOf(r14.d);
    L15:
        return Long.valueOf(r14.f);
    L17:
        return Double.valueOf(r14.f1200b);
    L19:
        if (Intrinsics.areEqual(r5, Boolean.TYPE) == true) goto L22;
        r11 = Intrinsics.areEqual(r5, Boolean.class);
    L22:
        if (r11 == false) goto L26;
        return Boolean.valueOf(r10.g.e);
    L26:
        return r10.g.f1201c;
    }

    public static Object f(Object r13, cj.i r14, cj.f r15) {
        boolean r5 = r13 instanceof Map;
        HashMap r10 = r15.e;
        if (r5 == false) goto L23;
        if (r14 == null) goto L6;
        KClass r11 = r14.f1204c;
    L8:
        if (Intrinsics.areEqual(r11, Reflection.getOrCreateKotlinClass(fj.a.class)) == true) goto L23;
        if (r14 == null) goto L13;
        KClass r16 = r14.f1204c;
        if (r16 == null) goto L13;
        Class r12 = JvmClassMappingKt.getJavaClass(r16);
    L14:
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.lynx.react.bridge.ReadableMap");
        HashMap<String, Object> r17 = ((ReadableMap) r13).toHashMap();
        if (r12 != null) goto L17;
        return null;
    L17:
        cj.g r18 = b((cj.g) r10.get(r12), r17);
        if (r18 != null) goto L21;
        return null;
    L21:
        return Proxy.newProxyInstance(r12.getClassLoader(), new Class[]{r12}, new com.bytedance.sdk.xbridge.cn.platform.lynx.f(r17, r15, r12, r18, 0));
    L13:
        r12 = null;
        goto L14
    L6:
        r11 = null;
    L23:
        if ((r13 instanceof List) == false) goto L48;
        if (r14 == null) goto L26;
        KClass r19 = r14.f1204c;
    L28:
        if (Intrinsics.areEqual(r19, Reflection.getOrCreateKotlinClass(fj.a.class)) == true) goto L48;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.collections.List<*>");
        List r110 = (List) r13;
        ArrayList r20 = new ArrayList(CollectionsKt.h(r110));
        Iterator r111 = r110.iterator();
    L31:
        if (r111.hasNext() == false) goto L46;
        Object r21 = r111.next();
        if (r14 == null) goto L37;
        KClass r22 = r14.f1204c;
        if (r22 == null) goto L37;
        Class r23 = JvmClassMappingKt.getJavaClass(r22);
    L38:
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type com.lynx.react.bridge.ReadableMap");
        HashMap<String, Object> r24 = ((ReadableMap) r21).toHashMap();
        if (r23 == null) goto L43;
        cj.g r112 = b((cj.g) r10.get(r23), r24);
        if (r112 == null) goto L43;
        Object r25 = Proxy.newProxyInstance(r23.getClassLoader(), new Class[]{r23}, new com.bytedance.sdk.xbridge.cn.platform.lynx.f(r24, r15, r23, r112, 0));
    L45:
        r20.add(r25);
    L43:
        r25 = null;
    L37:
        r23 = null;
        goto L38
    L46:
        return r20;
    L26:
        r19 = null;
    L48:
        return v0.k(r13);
    }

    public static LinkedHashMap g(HashMap r10, cj.g r11, cj.f r12) {
        if (r11 != null) goto L5;
        return null;
    L5:
        HashMap r13 = r11.f1198b;
        LinkedHashMap r5 = new LinkedHashMap(MapsKt.mapCapacity(r13.size()));
        Iterator r14 = r13.entrySet().iterator();
    L7:
        if (r14.hasNext() == false) goto L29;
        Map.Entry r15 = (Map.Entry) r14.next();
        Object r16 = r15.getKey();
        Object r17 = r10.get(((cj.i) r15.getValue()).f1203b);
        if (r17 == null) goto L11;
    L13:
        boolean r18 = Intrinsics.areEqual(((cj.i) r15.getValue()).f1204c, Reflection.getOrCreateKotlinClass(fj.a.class));
        HashMap r19 = r12.e;
        if (r18 == true) goto L19;
        if ((r17 instanceof ReadableMap) == false) goto L19;
        HashMap<String, Object> r20 = ((ReadableMap) r17).toHashMap();
        Object r21 = r19.get(JvmClassMappingKt.getJavaClass(((cj.i) r15.getValue()).f1204c));
        Intrinsics.checkNotNull(r21);
        Object r22 = g(r20, (cj.g) r21, r12);
    L28:
        r5.put(r16, r22);
    L19:
        if (Intrinsics.areEqual(((cj.i) r15.getValue()).f1204c, Reflection.getOrCreateKotlinClass(fj.a.class)) == false) goto L21;
    L27:
        r22 = r10.get(((cj.i) r15.getValue()).f1203b);
        goto L28
    L21:
        if ((r17 instanceof ReadableArray) == false) goto L27;
        ArrayList<Object> r23 = ((ReadableArray) r17).toArrayList();
        ArrayList r24 = new ArrayList(CollectionsKt.h(r23));
        Iterator<T> r25 = r23.iterator();
    L24:
        if (r25.hasNext() == false) goto L26;
        Object r26 = r25.next();
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type com.lynx.react.bridge.ReadableMap");
        HashMap<String, Object> r27 = ((ReadableMap) r26).toHashMap();
        Object r28 = r19.get(JvmClassMappingKt.getJavaClass(((cj.i) r15.getValue()).f1204c));
        Intrinsics.checkNotNull(r28);
        r24.add(g(r27, (cj.g) r28, r12));
        goto L24
    L26:
        r22 = r24;
        goto L28
    L11:
        if (((cj.i) r15.getValue()).g.f1199a == DefaultType.NONE) goto L13;
        Object r29 = e(((cj.i) r15.getValue()).f1205h, (cj.i) r15.getValue());
        r10.put(((cj.i) r15.getValue()).f1203b, r29);
        goto L13
    L29:
        return r5;
    }

    public static ze.a h(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        ze.a r10 = new ze.a(r5);
        r10.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r10.setTabMode(0);
        r10.setSelectedTabIndicator(R$drawable.lynx_tab_indicator);
        r10.setSelectedTabIndicatorHeight(-1);
        r10.setBackgroundResource(R$drawable.lynx_tab_line_bg);
        r10.getBackground().mutate();
        Drawable r11 = r10.getTabSelectedIndicator();
        if (r11 == null) goto L5;
        r11.mutate();
    L5:
        int r12 = LynxTabBarView.f6512k;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L8
        Field r14 = TabLayout.class.getDeclaredField("tabPaddingStart");     // Catch: Throwable -> L8
        r14.setAccessible(true);     // Catch: Throwable -> L8
        r14.set(r10, 0);     // Catch: Throwable -> L8
        Field r15 = TabLayout.class.getDeclaredField("tabPaddingEnd");     // Catch: Throwable -> L8
        r15.setAccessible(true);     // Catch: Throwable -> L8
        r15.set(r10, 0);     // Catch: Throwable -> L8
        Field r16 = TabLayout.class.getDeclaredField("tabPaddingTop");     // Catch: Throwable -> L8
        r16.setAccessible(true);     // Catch: Throwable -> L8
        r16.set(r10, 0);     // Catch: Throwable -> L8
        Field r17 = TabLayout.class.getDeclaredField("tabPaddingBottom");     // Catch: Throwable -> L8
        r17.setAccessible(true);     // Catch: Throwable -> L8
        r17.set(r10, 0);     // Catch: Throwable -> L8
        Field r18 = TabLayout.class.getDeclaredField("requestedTabMinWidth");     // Catch: Throwable -> L8
        r18.setAccessible(true);     // Catch: Throwable -> L8
        r18.set(r10, 0);     // Catch: Throwable -> L8
        Object r19 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L11:
        if (Result.m127exceptionOrNullimpl(r19) == null) goto L13;
        Log.e("LynxTabBarView", "resetTabPadding error");
    L13:
        return r10;
    L8:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r19 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static void i(StringBuilder r5, String r10, int r11, String r12) {
        r5.append(r10);
        LynxLog.b(r11, r12, r5.toString());
    }

    /* JADX WARN: Type inference failed for: r1v16, types: [java.time.ZonedDateTime] */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.time.ZonedDateTime] */
    /* JADX WARN: Type inference failed for: r1v21, types: [java.time.ZonedDateTime] */
    /* JADX WARN: Type inference failed for: r1v24, types: [java.time.ZonedDateTime] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.time.ZonedDateTime] */
    public static ZonedDateTime j(TemporalAccessor r5) {
        Objects.requireNonNull(r5, "temporal");
        if ((r5 instanceof Instant) == false) goto L7;
        return LocalDateTime.ofInstant((Instant) r5, ZoneId.systemDefault()).atZone(ZoneId.systemDefault());
    L7:
        if ((r5 instanceof LocalDate) == false) goto L11;
        return ((LocalDate) r5).atStartOfDay().atZone(ZoneId.systemDefault());
    L11:
        if ((r5 instanceof LocalDateTime) == false) goto L15;
        return ((LocalDateTime) r5).atZone(ZoneId.systemDefault());
    L15:
        if ((r5 instanceof LocalTime) == false) goto L19;
        LocalDate r10 = LocalDate.now();
        return r10.atTime((LocalTime) r5).atZone(ZoneId.systemDefault());
    L19:
        if ((r5 instanceof ZonedDateTime) == false) goto L23;
        return (ZonedDateTime) r5;
    L23:
        if ((r5 instanceof YearMonth) == false) goto L27;
        return j((YearMonth) r5);
    L27:
        if ((r5 instanceof OffsetDateTime) == false) goto L31;
        return ((OffsetDateTime) r5).toZonedDateTime();
    L31:
        if ((r5 instanceof OffsetTime) == false) goto L35;
        return ((OffsetTime) r5).atDate(LocalDate.now()).toZonedDateTime();
    L35:
        if ((r5 instanceof u) == false) goto L39;
        LocalDate r11 = ((u) r5).a();
        Objects.requireNonNull(r11, "localDate");
        return r11.atStartOfDay().atZone(ZoneId.systemDefault());
    L39:
        return ZonedDateTime.from(r5);
    }

    public static Uri k(String r5, String r10, int r11, String r12, String r13, String r14) {
        StringBuilder r15 = new StringBuilder();
        if (r10 == null) goto L9;
        if (r5 == null) goto L6;
        r15.append(r5);
        r15.append("://");
    L6:
        r15.append(r10);
        if (r11 <= 0) goto L9;
        r15.append(':');
        r15.append(r11);
    L9:
        if (r12 != null) goto L11;
    L12:
        r15.append('/');
    L13:
        if (r12 == null) goto L15;
        r15.append(r12);
    L15:
        if (r13 == null) goto L17;
        r15.append('?');
        r15.append(r13);
    L17:
        if (r14 == null) goto L20;
        r15.append('#');
        r15.append(r14);
    L20:
        return Uri.parse(r15.toString());
    L11:
        if (r12.startsWith("/") == true) goto L13;
        goto L12
    }

    public static String l(String r5) {
        return URLEncoder.encode(r5, "UTF-8");
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String m(LinkedList r5, boolean r10) {
        StringBuilder r11 = new StringBuilder();
        Iterator r12 = r5.iterator();
    L4:
        if (r12.hasNext() == false) goto L25;
        Pair r13 = (Pair) r12.next();
        String r14 = (String) r13.first;
        if (r10 == false) goto L8;
        r14 = l(r14);
    L8:
        List r15 = (List) r13.second;
        if (r15 == null) goto L4;
        if (r15.size() <= 0) goto L4;
        Iterator r16 = r15.iterator();
    L14:
        if (r16.hasNext() == false) goto L4;
        String r17 = (String) r16.next();
        if (r10 == false) goto L21;
        if (r17 == null) goto L19;
        r17 = l(r17);
        goto L21
    L19:
        r17 = "";
    L21:
        if (r11.length() <= 0) goto L23;
        r11.append("&");
    L23:
        r11.append(r14);
        r11.append("=");
        r11.append(r17);
        goto L14
    L25:
        return r11.toString();
    }

    public static String n(Context r5) {
        File r10 = r5.getFilesDir();
        if (r10 == null) goto L9;
        File r11 = new File(r10.getAbsolutePath(), "olog_cache");
        if (r11.exists() == true) goto L8;
        r11.mkdir();
    L8:
        return r11.getAbsolutePath();
    L9:
        return null;
    }

    public static void o(Uri r10, LinkedHashMap r11) {
        if (r10 == null) goto L26;
        String r12 = r10.getEncodedQuery();     // Catch: Throwable -> L14
        if (r12 == null) goto L22;
        String[] r13 = r12.split("&");     // Catch: Throwable -> L14
        int r5 = r13.length;     // Catch: Throwable -> L14
        int r14 = 0;
    L7:
        if (r14 >= r5) goto L32;
        String r15 = r13[r14];     // Catch: Throwable -> L14
        int r16 = r15.indexOf("=");     // Catch: Throwable -> L14
        if (r16 < 0) goto L17;
        String r17 = URLDecoder.decode(r15.substring(0, r16), "UTF-8");     // Catch: Throwable -> L14
        List r18 = (List) r11.get(r17);     // Catch: Throwable -> L14
        if (r18 != null) goto L16;
        r18 = new LinkedList();     // Catch: Throwable -> L14
    L16:
        r18.add(URLDecoder.decode(r15.substring(r16 + 1), "UTF-8"));     // Catch: Throwable -> L14
        r11.put(r17, r18);     // Catch: Throwable -> L14
    L21:
        r14 = r14 + 1;
        goto L7
    L17:
        String r19 = URLDecoder.decode(r15, "UTF-8");     // Catch: Throwable -> L14
        List r20 = (List) r11.get(r19);     // Catch: Throwable -> L14
        if (r20 != null) goto L20;
        r20 = new LinkedList();     // Catch: Throwable -> L14
    L20:
        r20.add("");     // Catch: Throwable -> L14
        r11.put(r19, r20);     // Catch: Throwable -> L14
        goto L21
    L32:
        return;
    L22:
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is null !!!");
    L26:
        throw new IOException("parseUrl url is null !!!");
    }

    public static void p(Class r5) {
        String r10 = r5.getName();
        wn.f.k(new ProtocolViolationException(j0.l("It is not allowed to subscribe with a(n) ", r10, " multiple times. Please create a fresh instance of ", r10, " and subscribe that to the target source instead.")));
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [da.a, java.lang.Object] */
    public static void q(LinkedHashMap r5, LinkedList r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return;
    L6:
        if (r5.containsKey(r11) == false) goto L11;
        r10.add(new Pair(r11, r5.get(r11)));
        if (f10745a.f() == true) goto L12;
        r5.remove(r11);
        return;
    L12:
        return;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [da.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2, types: [da.a, java.lang.Object] */
    public static String r(String r10, LinkedList r11) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return r10;
    L6:
        if (f10745a != null) goto L8;
        return r10;
    L8:
        LinkedHashMap r5 = new LinkedHashMap();
        Uri r12 = Uri.parse(r10);     // Catch: Throwable -> L18
        o(r12, r5);     // Catch: Throwable -> L18
        LinkedList r13 = new LinkedList();     // Catch: Throwable -> L18
        q(r5, r13, WsConstants.KEY_DEVICE_ID);     // Catch: Throwable -> L18
        q(r5, r13, "device_type");     // Catch: Throwable -> L18
        q(r5, r13, "device_brand");     // Catch: Throwable -> L18
        q(r5, r13, "uuid");     // Catch: Throwable -> L18
        q(r5, r13, "openudid");     // Catch: Throwable -> L18
        String r14 = m(r13, false);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r14) == false) goto L12;
        return r10;
    L12:
        byte[] r15 = r14.getBytes();     // Catch: Throwable -> L18
        byte[] r16 = EncryptorUtil.a(r15.length, r15);     // Catch: Throwable -> L18
        if (r16 != null) goto L15;
        return r10;
    L15:
        String r17 = Base64.encodeToString(r16, 2);     // Catch: Throwable -> L18
        LinkedList r18 = new LinkedList();     // Catch: Throwable -> L18
        if (f10745a.c() == false) goto L21;
        LinkedList r19 = new LinkedList();     // Catch: Throwable -> L18
        r19.add(r17);     // Catch: Throwable -> L18
        r18.add(new Pair("ss_queries", r19));     // Catch: Throwable -> L18
    L21:
        if (f10745a.e() == false) goto L24;
        r11.add(new Pair("X-SS-QUERIES", l(r17)));     // Catch: Throwable -> L18
    L24:
        if (r5.isEmpty() == true) goto L32;
        Iterator r110 = r5.entrySet().iterator();     // Catch: Throwable -> L18
    L27:
        if (r110.hasNext() == false) goto L32;
        Map.Entry r20 = (Map.Entry) r110.next();     // Catch: Throwable -> L18
        if (r20 == null) goto L27;
        r18.add(new Pair(r20.getKey(), r20.getValue()));     // Catch: Throwable -> L18
    L32:
        String r21 = m(r18, true);     // Catch: Throwable -> L18
        return k(r12.getScheme(), r12.getHost(), r12.getPort(), r12.getPath(), r21, r12.getFragment()).toString();
    L18:
        th = move-exception;
        th.printStackTrace();
        return r10;
    }
}
