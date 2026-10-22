package com.bytedance.ies.abmock.datacenter.precise;

import android.text.TextUtils;
import com.bytedance.crash.Npth;
import com.bytedance.ies.abmock.ConfigItem;
import com.bytedance.ies.abmock.SaveConfigType;
import com.bytedance.ies.abmock.datacenter.f;
import com.bytedance.ies.abmock.datacenter.g;
import com.bytedance.ies.abmock.datacenter.k;
import com.bytedance.ies.abmock.datacenter.storage.e;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020\nJ\u001e\u0010&\u001a\u00020'2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010*2\u0006\u0010)\u001a\u00020\nJ\u000e\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\u0004J\u0010\u0010-\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u0006\u0010.\u001a\u00020'J\u000e\u0010/\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0004J\u0006\u00100\u001a\u00020'J\u000e\u00101\u001a\u00020'2\u0006\u0010,\u001a\u00020\u0004J\u0016\u00102\u001a\u00020'2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\nJ\u0006\u00103\u001a\u00020'J\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018J\u0011\u00105\u001a\b\u0012\u0004\u0012\u00020\u000406¢\u0006\u0002\u00107J\u0006\u00108\u001a\u00020\u0004J\r\u00109\u001a\u00020\u0004H\u0000¢\u0006\u0002\b:J\u0011\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000406¢\u0006\u0002\u00107J\u0011\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000406¢\u0006\u0002\u00107J\u0011\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000406¢\u0006\u0002\u00107J%\u0010>\u001a\u00020'2\u0006\u0010?\u001a\u00020\n2\u0010\b\u0002\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000106¢\u0006\u0002\u0010AJ\b\u0010B\u001a\u00020'H\u0002J\b\u0010C\u001a\u00020'H\u0002J\u000e\u0010D\u001a\u00020'2\u0006\u0010,\u001a\u00020\u0004J\u001a\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010G\u001a\u00020'J\u000e\u0010H\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J\u001d\u0010I\u001a\u00020'2\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000106H\u0002¢\u0006\u0002\u0010JJ\u0018\u0010K\u001a\u00020'2\u0006\u0010L\u001a\u00020M2\u0006\u0010,\u001a\u00020\u0004H\u0002J\u0018\u0010N\u001a\u00020'2\u0006\u0010L\u001a\u00020M2\u0006\u0010,\u001a\u00020\u0004H\u0002J\u0018\u0010O\u001a\u00020'2\u0006\u0010L\u001a\u00020M2\u0006\u0010,\u001a\u00020\u0004H\u0002J\u0018\u0010P\u001a\u00020'2\u0006\u0010L\u001a\u00020M2\u0006\u0010,\u001a\u00020\u0004H\u0002J\u0018\u0010Q\u001a\u00020'2\u0006\u0010L\u001a\u00020M2\u0006\u0010,\u001a\u00020\u0004H\u0002J\u0010\u0010R\u001a\u00020'2\u0006\u0010L\u001a\u00020MH\u0002J\u0018\u0010S\u001a\u00020'2\u0006\u0010L\u001a\u00020M2\u0006\u0010,\u001a\u00020\u0004H\u0002J\u0018\u0010T\u001a\u00020'2\u0006\u0010L\u001a\u00020M2\u0006\u0010,\u001a\u00020\u0004H\u0002J\u0018\u0010U\u001a\u00020'2\u0006\u0010L\u001a\u00020M2\u0006\u0010,\u001a\u00020\u0004H\u0002J\u0018\u0010V\u001a\u00020'2\u0006\u0010L\u001a\u00020M2\u0006\u0010,\u001a\u00020\u0004H\u0002J%\u0010W\u001a\u00020'2\u0006\u0010L\u001a\u00020M2\u0010\b\u0002\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000106¢\u0006\u0002\u0010XJ*\u0010Y\u001a\u00020'2\u0006\u0010,\u001a\u00020\u00042\b\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020M2\b\u0010]\u001a\u0004\u0018\u00010\u0004J\b\u0010^\u001a\u00020_H\u0002J\u000e\u0010`\u001a\u00020'2\u0006\u0010,\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R?\u0010\u0015\u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00040\u0004 \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00180\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/bytedance/ies/abmock/datacenter/precise/PreciseExposureManager;", "", "()V", "KEY_CLIENT_EXP_VIDS", "", "KEY_EXPOSED_VIDS", "KEY_EXPOSED_VIDS_FOR_CURRENT_USER", "KEY_EXTRA_EXPOSED_VIDS", "TAG", "enableContainOpt", "", "extraExposureHandler", "Lcom/bytedance/ies/abmock/datacenter/precise/VidExposureDelegate;", "getExtraExposureHandler", "()Lcom/bytedance/ies/abmock/datacenter/precise/VidExposureDelegate;", "extraExposureHandler$delegate", "Lkotlin/Lazy;", "isVidCheckEnabled", "()Z", "setVidCheckEnabled", "(Z)V", "keySet", "", "kotlin.jvm.PlatformType", "", "getKeySet", "()Ljava/util/Set;", "keySet$delegate", "preciseExposureRepo", "Lcom/bytedance/ies/abmock/datacenter/storage/IDataStorage;", "registeredUserScopeKeyInitLock", "registeredUserScopeKeyInitialized", "tryExposeStateMap", "Ljava/util/concurrent/ConcurrentHashMap;", "userScopeKeyList", "", "vidKeyMap", "", "appendExtraVids", "", "vids", "isUid", "", "checkIfNeedTryExpose", "key", "clearExposureVids", "clearTryExpose", "containsKey", "disableTryExpose", "eraseKey", "exposeKey", "exposedVids", "getAllKey", "getClientExposeVid", "", "()[Ljava/lang/String;", "getCombinedVids", "getCurrentUid", "getCurrentUid$data_center_release", "getExposuredVids", "getExposuredVidsForCurrentUser", "getExtraExposureVids", "handleVids", "isFirstLaunch", "extraOutOfVids", "(Z[Ljava/lang/String;)V", "initRegisteredUserScopeKeyListIfNeeded", "initUserScopeKeyList", "insertUserScopeKeyList", "isValidVidFormat", AILabCheckPermissionTask.KEY_SOURCE, "load", "refreshClientExposeVid", "removeOutOfDateVid", "([Ljava/lang/String;)V", "saveBooleanValue", "jsonObject", "Lcom/google/gson/JsonObject;", "saveCustomTypeValue", "saveDoubleValue", "saveFloatValue", "saveIntValue", "saveKeyValue", "saveKeyVid", "saveLongValue", "saveStringArrayValue", "saveStringValue", "saveValue", "(Lcom/google/gson/JsonObject;[Ljava/lang/String;)V", "storeValue", "configItem", "Lcom/bytedance/ies/abmock/ConfigItem;", "data", "vid", "threadAsKey", "", "tryExposeKey", "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f2698a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f2699b;
    private static e c;
    private static boolean d;
    private static final List<String> e = null;
    private static volatile boolean f;
    private static final Object g = null;
    private static final Map<String, String> h = null;
    private static final ConcurrentHashMap<Object, Boolean> i = null;
    private static final Lazy j = null;
    private static final Lazy k = null;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2700a = null;

        static {
            int[] r0 = new int[SaveConfigType.ConfigType.values().length];
            r0[SaveConfigType.ConfigType.BOOLEAN.ordinal()] = 1;
            r0[SaveConfigType.ConfigType.INT.ordinal()] = 2;
            r0[SaveConfigType.ConfigType.LONG.ordinal()] = 3;
            r0[SaveConfigType.ConfigType.DOUBLE.ordinal()] = 4;
            r0[SaveConfigType.ConfigType.FLOAT.ordinal()] = 5;
            r0[SaveConfigType.ConfigType.STRING.ordinal()] = 6;
            r0[SaveConfigType.ConfigType.STRING_ARRAY.ordinal()] = 7;
            r0[SaveConfigType.ConfigType.OBJECT.ordinal()] = 8;
            f2700a = r0;
        }
    }

    static {
        f2698a = new c();
        e r0 = com.bytedance.ies.abmock.datacenter.e.a().c().d();
        if (ZeusTransformUtils.instanceOf(r0, f.class) == true) goto L5;
        Intrinsics.checkNotNullExpressionValue(r0, "repo");
        r0 = (e) ZeusTransformUtils.preCheckCast(new g(r0), e.class, "com.obric.memorydata.plugin");
    L6:
        c = r0;
        d = com.bytedance.ies.abmock.datacenter.e.a().b();
        List<String> r1 = Collections.synchronizedList((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r1, "synchronizedList(mutableListOf())");
        e = r1;
        g = new Object();
        h = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        i = new ConcurrentHashMap();
        j = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(PreciseExposureManager$extraExposureHandler$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        k = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(PreciseExposureManager$keySet$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        Intrinsics.checkNotNullExpressionValue(r0, "{\n            repo\n        }");
        goto L6
    }

    private c() {
    }

    public static /* synthetic */ void a(c r0, JsonObject r1, String[] r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.a(r1, r2);
    }

    private final void a(JsonObject r7) {
        Map<String, ConfigItem> r6 = com.bytedance.ies.abmock.c.b();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
        SaveConfigType.ConfigType r2 = ((ConfigItem) ZeusTransformUtils.preCheckCast(r1.getValue(), ConfigItem.class, "com.obric.memorydata.plugin")).type;
        if (r2 != null) goto L8;
        int r3 = -1;
    L9:
        switch(r3) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            default: goto L10;
        };
    L11:
        c r5 = f2698a;
        Intrinsics.checkNotNullExpressionValue(r4, "key");
        r5.h(r7, r4);
        goto L4
    L12:
        c r8 = f2698a;
        Intrinsics.checkNotNullExpressionValue(r4, "key");
        r8.d(r7, r4);
        goto L4
    L13:
        c r9 = f2698a;
        Intrinsics.checkNotNullExpressionValue(r4, "key");
        r9.g(r7, r4);
        goto L4
    L14:
        c r10 = f2698a;
        Intrinsics.checkNotNullExpressionValue(r4, "key");
        r10.f(r7, r4);
        goto L4
    L15:
        c r11 = f2698a;
        Intrinsics.checkNotNullExpressionValue(r4, "key");
        r11.e(r7, r4);
        goto L4
    L16:
        c r12 = f2698a;
        Intrinsics.checkNotNullExpressionValue(r4, "key");
        r12.b(r7, r4);
        goto L4
    L17:
        c r13 = f2698a;
        Intrinsics.checkNotNullExpressionValue(r4, "key");
        r13.c(r7, r4);
        goto L4
    L10:
        c r14 = f2698a;
        Intrinsics.checkNotNullExpressionValue(r4, "key");
        r14.i(r7, r4);
        goto L4
    L8:
        r3 = a.f2700a[r2.ordinal()];
        goto L9
    L18:
        Set<String> r15 = r7.keySet();
        Intrinsics.checkNotNullExpressionValue(r15, "jsonObject.keySet()");
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r16.hasNext() == false) goto L32;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");
        JsonObject r18 = r7.getAsJsonObject(r17);
        if (r18 == null) goto L26;
        JsonPrimitive r19 = r18.getAsJsonPrimitive("type");
        if (r19 == null) goto L26;
        String r20 = r19.getAsString();
    L28:
        if (Intrinsics.areEqual(r20, "1") == false) goto L20;
        Intrinsics.checkNotNullExpressionValue(r6, "preciseConfigMap");
        if (r6.containsKey(r17) == true) goto L20;
        c r21 = f2698a;
        Intrinsics.checkNotNullExpressionValue(r17, "key");
        r21.a(r7, r17);
    L26:
        r20 = null;
        goto L28
    }

    private final void a(final JsonObject r5, final String r6) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r4 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        String r0 = "key:" + r6;
        new $$Lambda$c$EBOM7uAQ57HeEzHfjV_4dEWnJDQ(r5, r6).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r4.a(new Throwable("cause: " + th + "--message: " + r0, th), r6);
    }

    private final void a(final String[] r4) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r3 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        new $$Lambda$c$757qGh0cxy5uGep4XZUzJbZdPM(r4).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r3.a(new Throwable("cause: " + th + "--message: ", th), "PreciseExposureManager");
    }

    private final boolean a(String r4, String r5) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        return true;
    L11:
        boolean r7 = new Regex("^[0-9, ]+$").matches((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r7 == true) goto L14;
        Npth.reportBizException("ABMock", new Throwable("exposure vid is invalid, source: " + r4 + ", vids: " + StringsKt.take(r5, 50)), "PreciseExposureManager", null);
    L14:
        return r7;
    L5:
        if (r3.length() == 0) goto L8;
        r6 = false;
        goto L9
    }

    private static final Unit b(String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r14, "$key");
        c r0 = f2698a;
        r0.l();
        if (r0.c(r14) == false) goto L44;
        String r1 = r0.a();
        boolean r3 = true;
        e r7 = null;
        if (r15 == false) goto L24;
        e r16 = c;
        if (r16 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("preciseExposureRepo");
        r16 = null;
    L9:
        String[] r17 = r16.a("{__exposed_vids_for_current_user}_{" + r1 + '}', new String[0]);
        e r10 = c;
        if (r10 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("preciseExposureRepo");
        r10 = null;
    L12:
        String r18 = r10.a(r14, "");
        Intrinsics.checkNotNullExpressionValue(r18, "element");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L16;
        r3 = false;
    L16:
        if (r3 == false) goto L44;
        Intrinsics.checkNotNullExpressionValue(r17, "exposedVidsForCurrentUser");
        if (ArraysKt.contains(r17, r18) == true) goto L44;
        List r19 = ArraysKt.toMutableList(r17);
        r19.add(r18);
        e r110 = c;
        if (r110 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("preciseExposureRepo");
    L23:
        Object[] r111 = ((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        r7.b("{__exposed_vids_for_current_user}_{" + r1 + '}', (String[]) ZeusTransformUtils.preCheckCast(r111, String[].class, "com.obric.memorydata.plugin"));
    L42:
        r0.e();
        goto L44
    L22:
        r7 = r110;
        goto L23
    L24:
        e r112 = c;
        if (r112 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("preciseExposureRepo");
        r112 = null;
    L27:
        String[] r113 = r112.a("__exposed_vids", new String[0]);
        e r2 = c;
        if (r2 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("preciseExposureRepo");
        r2 = null;
    L30:
        String r114 = r2.a(r14, "");
        Intrinsics.checkNotNullExpressionValue(r114, "element");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r114, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L34;
        r3 = false;
    L34:
        if (r3 == false) goto L44;
        Intrinsics.checkNotNullExpressionValue(r113, "exposedVids");
        if (ArraysKt.contains(r113, r114) == true) goto L44;
        List r115 = ArraysKt.toMutableList(r113);
        r115.add(r114);
        e r116 = c;
        if (r116 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("preciseExposureRepo");
    L41:
        Object[] r117 = ((Collection) ZeusTransformUtils.preCheckCast(r115, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        r7.b("__exposed_vids", (String[]) ZeusTransformUtils.preCheckCast(r117, String[].class, "com.obric.memorydata.plugin"));
        goto L42
    L40:
        r7 = r116;
    L44:
        return Unit.INSTANCE;
    }

    private static final Unit b(String[] r15) {
        e r0 = c;
        String r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("preciseExposureRepo");
        r0 = null;
    L5:
        String[] r1 = r0.a("__exposed_vids", new String[0]);
        Intrinsics.checkNotNullExpressionValue(r1, "exposedVids");
        List r3 = ArraysKt.toMutableList(r1);
        Iterator r4 = r3.iterator();
        boolean r7 = false;
    L7:
        if (r4.hasNext() == false) goto L11;
        if (h.containsKey((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin")) == true) goto L7;
        r4.remove();
        r7 = true;
        goto L7
    L11:
        String r5 = f2698a.a();
        e r8 = c;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("preciseExposureRepo");
        r8 = null;
    L14:
        String[] r9 = r8.a("{__exposed_vids_for_current_user}_{" + r5 + '}', new String[0]);
        Intrinsics.checkNotNullExpressionValue(r9, "exposedVidsForCurrentUser");
        List r10 = ArraysKt.toMutableList(r9);
        Iterator r11 = r10.iterator();
    L16:
        if (r11.hasNext() == false) goto L20;
        if (h.containsKey((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin")) == true) goto L16;
        r11.remove();
        r7 = true;
        goto L16
    L20:
        if (r7 == false) goto L28;
        e r6 = c;
        if (r6 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("preciseExposureRepo");
        r6 = null;
    L24:
        Object[] r12 = ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        r6.b("__exposed_vids", (String[]) ZeusTransformUtils.preCheckCast(r12, String[].class, "com.obric.memorydata.plugin"));
        e r13 = c;
        if (r13 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("preciseExposureRepo");
        r13 = null;
    L27:
        Object[] r14 = ((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        r13.b("{__exposed_vids_for_current_user}_{" + r5 + '}', (String[]) ZeusTransformUtils.preCheckCast(r14, String[].class, "com.obric.memorydata.plugin"));
    L28:
        d r16 = f2698a.i();
        if (r15 == null) goto L31;
        r2 = ArraysKt.joinToString$default(r15, (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L31:
        r16.a(r2);
        return Unit.INSTANCE;
    }

    private final void b(final JsonObject r4, final String r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r3 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        String r0 = "key: " + r5;
        new $$Lambda$c$zZRb7IEYe1X2GDi2fMGTOMgj58(r4, r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r3.a(new Throwable("cause: " + th + "--message: " + r0, th), "PreciseExposureManager");
    }

    private final void c(final JsonObject r4, final String r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r3 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        String r0 = "key: " + r5;
        new $$Lambda$c$tBH4wI0FR6ntAxclsFSFIWPYFeE(r4, r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r3.a(new Throwable("cause: " + th + "--message: " + r0, th), "PreciseExposureManager");
    }

    private final void d(final JsonObject r4, final String r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r3 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        String r0 = "key: " + r5;
        new $$Lambda$c$aPT22h2rbl0vGMWPYGBY0PG8MyU(r4, r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r3.a(new Throwable("cause: " + th + "--message: " + r0, th), "PreciseExposureManager");
    }

    private static final Unit e(String r3) {
        Intrinsics.checkNotNullParameter(r3, "$key");
        ConcurrentHashMap<Object, Boolean> r0 = i;
        c r1 = f2698a;
        if (r0.containsKey(Integer.valueOf(r1.m())) == true) goto L10;
        if (r0.containsKey(r3) == false) goto L10;
        r0.remove(r3);
        r1.b(r3);
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    private final void e(final JsonObject r4, final String r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r3 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        String r0 = "key: " + r5;
        new $$Lambda$c$6GytJ3D5BDyYXed7WdQhS54bCU(r4, r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r3.a(new Throwable("cause: " + th + "--message: " + r0, th), "PreciseExposureManager");
    }

    private static final Unit f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "$key");
        c r0 = f2698a;
        r0.l();
        ConcurrentHashMap<Object, Boolean> r1 = i;
        if (r1.containsKey(Integer.valueOf(r0.m())) == true) goto L5;
        r0.a(r3, e.contains(r3));
        return Unit.INSTANCE;
    L5:
        if (com.bytedance.ies.abmock.c.b().containsKey(r3) == false) goto L8;
        ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.memorydata.plugin")).put(r3, true);
    L8:
        return Unit.INSTANCE;
    }

    private final void f(final JsonObject r4, final String r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r3 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        String r0 = "key: " + r5;
        new $$Lambda$c$QXG6A7Zz10lYC3r9xC7Dbglggc(r4, r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r3.a(new Throwable("cause: " + th + "--message: " + r0, th), "PreciseExposureManager");
    }

    private final void g(final JsonObject r4, final String r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r3 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        String r0 = "key: " + r5;
        new $$Lambda$c$GZl3qACqzA6fM6eiYxkeD6Tw_58(r4, r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r3.a(new Throwable("cause: " + th + "--message: " + r0, th), "PreciseExposureManager");
    }

    public static final /* synthetic */ e h() {
        return c;
    }

    private final void h(final JsonObject r4, final String r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r3 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        String r0 = "key: " + r5;
        new $$Lambda$c$GVRVosXvejWSuBpUkkTUea30ML4(r4, r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r3.a(new Throwable("cause: " + th + "--message: " + r0, th), "PreciseExposureManager");
    }

    private final d i() {
        return (d) ZeusTransformUtils.preCheckCast(j.getValue(), d.class, "com.obric.memorydata.plugin");
    }

    private final void i(final JsonObject r4, final String r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r3 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        String r0 = "key: " + r5;
        new $$Lambda$c$Lg3u76x_BtyaV1u_M45KHTfKPdE(r4, r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r3.a(new Throwable("cause: " + th + "--message: " + r0, th), "PreciseExposureManager");
    }

    private final Set<String> j() {
        return (Set) ZeusTransformUtils.preCheckCast(k.getValue(), Set.class, "com.obric.memorydata.plugin");
    }

    private static final Unit j(JsonObject r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "$jsonObject");
        Intrinsics.checkNotNullParameter(r5, "$key");
        if (r4.getAsJsonObject(r5) == null) goto L5;
        JsonObject r0 = r4.getAsJsonObject(r5);
        e r1 = null;
        if (r0 == null) goto L11;
        JsonPrimitive r2 = r0.getAsJsonPrimitive("vid");
        if (r2 == null) goto L11;
        String r3 = r2.getAsString();
    L12:
        JsonObject r6 = r4.getAsJsonObject(r5);
        if (r6 == null) goto L17;
        JsonPrimitive r7 = r6.getAsJsonPrimitive("type");
        if (r7 == null) goto L17;
        String r8 = r7.getAsString();
    L19:
        if (r3 == null) goto L31;
        if (r8 == null) goto L31;
        if (Intrinsics.areEqual("1", r8) == false) goto L31;
        e r9 = c;
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("preciseExposureRepo");
    L27:
        r1.b(r5, r3);
        if (d == false) goto L30;
        f2698a.j().add(r5);
    L30:
        h.put(r3, r5);
    L44:
        return Unit.INSTANCE;
    L26:
        r1 = r9;
    L31:
        e r10 = c;
        if (r10 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("preciseExposureRepo");
        r10 = null;
    L35:
        if (r10.a(r5) == false) goto L44;
        e r11 = c;
        if (r11 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("preciseExposureRepo");
    L40:
        r1.c(r5);
        if (d == false) goto L44;
        f2698a.j().remove(r5);
        goto L44
    L39:
        r1 = r11;
    L17:
        r8 = null;
    L11:
        r3 = null;
        goto L12
    L5:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Unit k(JsonObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$jsonObject");
        Intrinsics.checkNotNullParameter(r2, "$key");
        f2698a.a(r1, r2);
        JsonObject r3 = r1.getAsJsonObject(r2);
        if (r3 == null) goto L5;
        JsonPrimitive r4 = r3.getAsJsonPrimitive("val");
    L6:
        if (r4 != null) goto L8;
        com.bytedance.ies.abmock.datacenter.storage.a.f2706b.d(r2);
    L14:
        return Unit.INSTANCE;
    L8:
        if (r4.isBoolean() == false) goto L10;
        com.bytedance.ies.abmock.datacenter.storage.a r0 = com.bytedance.ies.abmock.datacenter.storage.a.f2706b;
        com.bytedance.ies.abmock.datacenter.storage.a r5 = r0;
        int r6 = r4.getAsBoolean();
    L11:
        r5.b(r2, r6);
        goto L14
    L10:
        com.bytedance.ies.abmock.datacenter.storage.a r7 = com.bytedance.ies.abmock.datacenter.storage.a.f2706b;
        r5 = r7;
        r6 = r4.getAsInt();
        goto L11
    L5:
        r4 = null;
        goto L6
    }

    private final void k() {
    }

    private static final Unit l(JsonObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$jsonObject");
        Intrinsics.checkNotNullParameter(r2, "$key");
        f2698a.a(r1, r2);
        JsonObject r3 = r1.getAsJsonObject(r2);
        if (r3 == null) goto L5;
        JsonPrimitive r4 = r3.getAsJsonPrimitive("val");
    L6:
        if (r4 != null) goto L8;
        com.bytedance.ies.abmock.datacenter.storage.a.f2706b.d(r2);
    L17:
        return Unit.INSTANCE;
    L8:
        if (r4.isNumber() == false) goto L13;
        com.bytedance.ies.abmock.datacenter.storage.a r0 = com.bytedance.ies.abmock.datacenter.storage.a.f2706b;
        if (r4.getAsInt() == 0) goto L12;
        boolean r5 = true;
    L14:
        r0.b(r2, r5);
        goto L17
    L12:
        r5 = false;
        goto L14
    L13:
        r0 = com.bytedance.ies.abmock.datacenter.storage.a.f2706b;
        r5 = r4.getAsBoolean();
        goto L14
    L5:
        r4 = null;
        goto L6
    }

    private final void l() {
        if (f == false) goto L5;
        return;
    L5:
        Object r1 = g;
        monitor-enter(r1);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (f == false) goto L11;
        monitor-exit(r1);
        return;
    L11:
        f2698a.k();     // Catch: Throwable -> L14
        f = true;     // Catch: Throwable -> L14
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r1);
    }

    public static /* synthetic */ Unit lambda$110_7TXJcMLx6FIDWAzr4t8mwCo(String r0) {
        return f(r0);
    }

    /* JADX INFO: renamed from: lambda$6Gy-tJ3D5BDyYXed7WdQhS54bCU, reason: not valid java name */
    public static /* synthetic */ Unit m109lambda$6GytJ3D5BDyYXed7WdQhS54bCU(JsonObject r0, String r1) {
        return n(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$757qGh0cxy5-uGep4XZUzJbZdPM, reason: not valid java name */
    public static /* synthetic */ Unit m110lambda$757qGh0cxy5uGep4XZUzJbZdPM(String[] r0) {
        return b(r0);
    }

    public static /* synthetic */ Unit lambda$EBOM7uAQ57HeEzHfjV_4dEWnJDQ(JsonObject r0, String r1) {
        return j(r0, r1);
    }

    public static /* synthetic */ Unit lambda$FLVvbL30IHuItaRIuT03DZ37B9M(String r0) {
        return e(r0);
    }

    public static /* synthetic */ Unit lambda$GVRVosXvejWSuBpUkkTUea30ML4(JsonObject r0, String r1) {
        return q(r0, r1);
    }

    public static /* synthetic */ Unit lambda$GZl3qACqzA6fM6eiYxkeD6Tw_58(JsonObject r0, String r1) {
        return p(r0, r1);
    }

    public static /* synthetic */ Unit lambda$Lg3u76x_BtyaV1u_M45KHTfKPdE(JsonObject r0, String r1) {
        return r(r0, r1);
    }

    public static /* synthetic */ Unit lambda$PDNI96mmUAaV23tR0lBBqMii93I(String r0, boolean r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$QXG6A7Z-z10lYC3r9xC7Dbglggc, reason: not valid java name */
    public static /* synthetic */ Unit m111lambda$QXG6A7Zz10lYC3r9xC7Dbglggc(JsonObject r0, String r1) {
        return o(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$_XuHMxdCeltE8q7fyOgjGDoB-6s, reason: not valid java name */
    public static /* synthetic */ String m112lambda$_XuHMxdCeltE8q7fyOgjGDoB6s() {
        return n();
    }

    public static /* synthetic */ Unit lambda$aPT22h2rbl0vGMWPYGBY0PG8MyU(JsonObject r0, String r1) {
        return m(r0, r1);
    }

    public static /* synthetic */ Unit lambda$tBH4wI0FR6ntAxclsFSFIWPYFeE(JsonObject r0, String r1) {
        return l(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$zZRb7IEYe1X-2GDi2fMGTOMgj58, reason: not valid java name */
    public static /* synthetic */ Unit m113lambda$zZRb7IEYe1X2GDi2fMGTOMgj58(JsonObject r0, String r1) {
        return k(r0, r1);
    }

    private final int m() {
        return Thread.currentThread().hashCode();
    }

    private static final Unit m(JsonObject r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "$jsonObject");
        Intrinsics.checkNotNullParameter(r4, "$key");
        f2698a.a(r3, r4);
        JsonObject r0 = r3.getAsJsonObject(r4);
        if (r0 == null) goto L5;
        JsonElement r1 = r0.get("val");
    L6:
        if (r1 == null) goto L9;
        com.bytedance.ies.abmock.datacenter.storage.a.f2706b.b(r4, r1.getAsString());
    L13:
        return Unit.INSTANCE;
    L9:
        if (r3.has(r4) == false) goto L11;
        com.bytedance.ies.abmock.datacenter.storage.a.f2706b.b(r4, null);
        goto L13
    L11:
        com.bytedance.ies.abmock.datacenter.storage.a.f2706b.d(r4);
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    private static final String n() {
        String[] r0 = f2698a.b();
        if (f2699b == false) goto L11;
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r5 = r0.length;
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L10;
        String r7 = r0[r6];
        if (f2698a.a("client_expose_vid", r7) == false) goto L9;
        r1.add(r7);
    L9:
        r6 = r6 + 1;
        goto L5
    L10:
        Object[] r2 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        r0 = (String[]) ZeusTransformUtils.preCheckCast(r2, String[].class, "com.obric.memorydata.plugin");
    L11:
        String[] r3 = f2698a.c();
        if (f2699b == false) goto L20;
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r9 = r3.length;
        int r10 = 0;
    L14:
        if (r10 >= r9) goto L19;
        String r11 = r3[r10];
        if (f2698a.a("normal_expose_vid", r11) == false) goto L18;
        r8.add(r11);
    L18:
        r10 = r10 + 1;
        goto L14
    L19:
        Object[] r4 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        r3 = (String[]) ZeusTransformUtils.preCheckCast(r4, String[].class, "com.obric.memorydata.plugin");
    L20:
        List r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin"), r0);
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin"), r3);
        if (com.bytedance.ies.abmock.datacenter.d.a().c() == null) goto L32;
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin");
        String[] r14 = f2698a.d();
        if (f2699b == false) goto L31;
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r16 = r14.length;
        int r17 = 0;
    L25:
        if (r17 >= r16) goto L30;
        String r18 = r14[r17];
        if (f2698a.a("current_user_expose_vid", r18) == false) goto L29;
        r15.add(r18);
    L29:
        r17 = r17 + 1;
        goto L25
    L30:
        Object[] r19 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        r14 = (String[]) ZeusTransformUtils.preCheckCast(r19, String[].class, "com.obric.memorydata.plugin");
    L31:
        CollectionsKt.addAll(r13, (Object[]) ZeusTransformUtils.preCheckCast(r14, Object[].class, "com.obric.memorydata.plugin"));
    L32:
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin");
        String[] r21 = f2698a.g();
        if (f2699b == false) goto L41;
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r23 = r21.length;
        int r24 = 0;
    L35:
        if (r24 >= r23) goto L40;
        String r25 = r21[r24];
        if (f2698a.a("extra_expose_vid", r25) == false) goto L39;
        r22.add(r25);
    L39:
        r24 = r24 + 1;
        goto L35
    L40:
        Object[] r26 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        r21 = (String[]) ZeusTransformUtils.preCheckCast(r26, String[].class, "com.obric.memorydata.plugin");
    L41:
        CollectionsKt.addAll(r20, (Object[]) ZeusTransformUtils.preCheckCast(r21, Object[].class, "com.obric.memorydata.plugin"));
        Object r27 = b.f2695a.b();
        if (f2699b == false) goto L50;
        Iterable r28 = (Iterable) ZeusTransformUtils.preCheckCast(r27, Iterable.class, "com.obric.memorydata.plugin");
        Collection r29 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r30 = r28.iterator();
    L45:
        if (r30.hasNext() == false) goto L49;
        Object r31 = r30.next();
        if (f2698a.a("combine_expose_vid", (String) ZeusTransformUtils.preCheckCast(r31, String.class, "com.obric.memorydata.plugin")) == false) goto L45;
        r29.add(r31);
        goto L45
    L49:
        r27 = (List) ZeusTransformUtils.preCheckCast(r29, List.class, "com.obric.memorydata.plugin");
    L50:
        r12.addAll((Collection) ZeusTransformUtils.preCheckCast(r27, Collection.class, "com.obric.memorydata.plugin"));
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(new HashSet((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    }

    private static final Unit n(JsonObject r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "$jsonObject");
        Intrinsics.checkNotNullParameter(r4, "$key");
        f2698a.a(r3, r4);
        JsonObject r5 = r3.getAsJsonObject(r4);
        if (r5 == null) goto L5;
        JsonElement r6 = r5.get("val");
    L6:
        if (r6 == null) goto L8;
        com.bytedance.ies.abmock.datacenter.storage.a.f2706b.b(r4, r6.getAsLong());
    L10:
        return Unit.INSTANCE;
    L8:
        com.bytedance.ies.abmock.datacenter.storage.a.f2706b.d(r4);
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    private static final Unit o(JsonObject r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "$jsonObject");
        Intrinsics.checkNotNullParameter(r4, "$key");
        f2698a.a(r3, r4);
        JsonObject r5 = r3.getAsJsonObject(r4);
        if (r5 == null) goto L5;
        JsonElement r6 = r5.get("val");
    L6:
        if (r6 == null) goto L8;
        com.bytedance.ies.abmock.datacenter.storage.a.f2706b.b(r4, r6.getAsDouble());
    L10:
        return Unit.INSTANCE;
    L8:
        com.bytedance.ies.abmock.datacenter.storage.a.f2706b.d(r4);
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    private static final Unit p(JsonObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$jsonObject");
        Intrinsics.checkNotNullParameter(r2, "$key");
        f2698a.a(r1, r2);
        JsonObject r3 = r1.getAsJsonObject(r2);
        if (r3 == null) goto L5;
        JsonElement r4 = r3.get("val");
    L6:
        if (r4 == null) goto L8;
        com.bytedance.ies.abmock.datacenter.storage.a.f2706b.b(r2, r4.getAsFloat());
    L10:
        return Unit.INSTANCE;
    L8:
        com.bytedance.ies.abmock.datacenter.storage.a.f2706b.d(r2);
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    private static final Unit q(JsonObject r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "$jsonObject");
        Intrinsics.checkNotNullParameter(r4, "$key");
        f2698a.a(r3, r4);
        JsonObject r0 = r3.getAsJsonObject(r4);
        if (r0 == null) goto L5;
        JsonElement r1 = r0.get("val");
    L6:
        if (r1 == null) goto L9;
        com.bytedance.ies.abmock.datacenter.storage.a.f2706b.a(r4, (String[]) ZeusTransformUtils.preCheckCast(com.bytedance.ies.abmock.datacenter.storage.a.f2706b.a().fromJson(r1, String[].class), String[].class, "com.obric.memorydata.plugin"));
    L13:
        return Unit.INSTANCE;
    L9:
        if (r3.has(r4) == false) goto L11;
        com.bytedance.ies.abmock.datacenter.storage.a.f2706b.a(r4, null);
        goto L13
    L11:
        com.bytedance.ies.abmock.datacenter.storage.a.f2706b.d(r4);
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    private static final Unit r(JsonObject r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "$jsonObject");
        Intrinsics.checkNotNullParameter(r4, "$key");
        f2698a.a(r3, r4);
        JsonObject r0 = r3.getAsJsonObject(r4);
        if (r0 == null) goto L5;
        JsonElement r1 = r0.get("val");
    L6:
        if (r1 == null) goto L9;
        com.bytedance.ies.abmock.datacenter.storage.a.f2706b.b(r4, r1.toString());
    L13:
        return Unit.INSTANCE;
    L9:
        if (r3.has(r4) == false) goto L11;
        com.bytedance.ies.abmock.datacenter.storage.a.f2706b.b(r4, null);
        goto L13
    L11:
        com.bytedance.ies.abmock.datacenter.storage.a.f2706b.d(r4);
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final String a() {
        k r3 = com.bytedance.ies.abmock.datacenter.d.a().c();
        if (r3 == null) goto L5;
        String r4 = r3.c();
    L7:
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L12;
        return "";
    L12:
        if (Intrinsics.areEqual("0", r4) == false) goto L15;
        return "";
    L15:
        return r4;
    L5:
        r4 = null;
        goto L7
    }

    public final void a(JsonObject r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r2, "jsonObject");
        if (r2.size() != 0) goto L5;
        return;
    L5:
        l();
        a(r2);
        a(r3);
        e();
    }

    public final void a(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "key");
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r4 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        String r0 = "key: " + r5;
        new $$Lambda$c$FLVvbL30IHuItaRIuT03DZ37B9M(r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r4.a(new Throwable("cause: " + th + "--message: " + r0, th), "PreciseExposureManager");
    }

    public final void a(final String r4, final boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r3 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        String r0 = "key: " + r4;
        new $$Lambda$c$PDNI96mmUAaV23tR0lBBqMii93I(r4, r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r3.a(new Throwable("cause: " + th + "--message: " + r0, th), "PreciseExposureManager");
    }

    public final void b(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "key");
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r4 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        String r0 = "key: " + r5;
        new $$Lambda$c$110_7TXJcMLx6FIDWAzr4t8mwCo(r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r4.a(new Throwable("cause: " + th + "--message: " + r0, th), "PreciseExposureManager");
    }

    public final String[] b() {
        e r2 = c;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("preciseExposureRepo");
        r2 = null;
    L5:
        String[] r3 = r2.a("__client_exp_vids", new String[0]);
        Intrinsics.checkNotNullExpressionValue(r3, "preciseExposureRepo.getS…_VIDS, arrayOf<String>())");
        return r3;
    }

    public final boolean c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (d == true) goto L10;
        e r1 = c;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("preciseExposureRepo");
        r1 = null;
    L9:
        return r1.a(r2);
    L10:
        return j().contains(r2);
    }

    public final String[] c() {
        e r2 = c;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("preciseExposureRepo");
        r2 = null;
    L5:
        String[] r3 = r2.a("__exposed_vids", new String[0]);
        Intrinsics.checkNotNullExpressionValue(r3, "preciseExposureRepo.getS…_VIDS, arrayOf<String>())");
        return r3;
    }

    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        List<String> r1 = e;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r1.contains(r2) == true) goto L7;
        r1.add(r2);     // Catch: Throwable -> L10
    L7:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r1);
    }

    public final String[] d() {
        if (com.bytedance.ies.abmock.datacenter.d.a().c() == null) goto L10;
        String r4 = a();
        e r0 = c;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("preciseExposureRepo");
        r0 = null;
    L7:
        String[] r5 = r0.a("{__exposed_vids_for_current_user}_{" + r4 + '}', new String[0]);
        Intrinsics.checkNotNullExpressionValue(r5, "preciseExposureRepo.getS…ring>()\n                )");
        return r5;
    L10:
        return new String[0];
    }

    public final void e() {
        String r1 = f();
        k r0 = com.bytedance.ies.abmock.datacenter.d.a().c();
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public final String f() {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        Object r1 = $$Lambda$c$_XuHMxdCeltE8q7fyOgjGDoB6s.INSTANCE.call();     // Catch: Throwable -> L5
    L7:
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L11;
        return "";
    L11:
        return r2;
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: ", th), "PreciseExposureManager");
        r1 = null;
        goto L7
    }

    public final String[] g() {
        return i().a();
    }
}
