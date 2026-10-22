package com.obric.memorydata.screencapture.accessibility;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.provider.Settings;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.obric.assist.service.MemoryAccessibilityService;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.k;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0002\u001a\u001d\bÆ\u0002\u0018\u00002\u00020\u0001:\u00018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010$\u001a\u00020#J\u0006\u0010%\u001a\u00020#J\u0012\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u0016H\u0002J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050*2\u0006\u0010(\u001a\u00020\u0016H\u0002J\u0010\u0010+\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0016H\u0002J\u0018\u0010,\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\bH\u0002J\b\u0010.\u001a\u00020#H\u0002J\u0016\u0010/\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\bJ\u0016\u00100\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\bJ\u000e\u00101\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0016J\u000e\u00102\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0016J\u0016\u00103\u001a\u00020#2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u001e\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013¨\u00069"}, d2 = {"Lcom/obric/memorydata/screencapture/accessibility/AccessibilityUtil;", "", "<init>", "()V", "TAG", "", "LEGACY_SERVICE_CLASS_NAME", "hasTurnedOnAccessibilityService", "", "ENABLED_ACCESSIBILITY_MEMORY_SERVICES", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/screencapture/accessibility/AccessibilityUtil$AccessibilityState;", "lastLoggedState", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "isMasterEnabled", "()Z", "isServiceEnabled", "appContext", "Landroid/content/Context;", "mainHandler", "Landroid/os/Handler;", "masterSwitchObserver", "com/obric/memorydata/screencapture/accessibility/AccessibilityUtil$masterSwitchObserver$1", "Lcom/obric/memorydata/screencapture/accessibility/AccessibilityUtil$masterSwitchObserver$1;", "serviceSwitchObserver", "com/obric/memorydata/screencapture/accessibility/AccessibilityUtil$serviceSwitchObserver$1", "Lcom/obric/memorydata/screencapture/accessibility/AccessibilityUtil$serviceSwitchObserver$1;", EventBody.KEY_VALUE, "hasToggleAccessibilityActivity", "getHasToggleAccessibilityActivity", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "refreshState", "onAppTerminate", "getServiceComponentName", "Landroid/content/ComponentName;", "context", "getEnabledServicesList", "", "isServiceInEnabledList", "setAccessibilityServiceInternal", "enabled", "ensureInternalAccessibilityDelegateRegistered", "setMasterSwitch", "setAccessibilityService", "jumpToAccessibilitySettings", "jumpToAppAccessibilitySettings", "jumpToToggleAccessibilityService", "activity", "Landroid/app/Activity;", "requestCode", "", "AccessibilityState", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f12773a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f12774b;
    private static final ae<a> c = null;
    private static a d;
    private static final ar<a> e = null;
    private static Context f;
    private static final Handler g = null;
    private static final b h = null;
    private static final C0689c i = null;
    private static boolean j;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/screencapture/accessibility/AccessibilityUtil$AccessibilityState;", "", "isMasterEnabled", "", "isServiceEnabled", "<init>", "(ZZ)V", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f12775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f12776b;

        public a() {
            boolean r0 = false;
            this(r0, r0, 3, null);
        }

        public a(boolean r1, boolean r2) {
            this.f12775a = r1;
            this.f12776b = r2;
        }

        public /* synthetic */ a(boolean r2, boolean r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = false;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = false;
        L8:
            this(r2, r3);
        }

        public final boolean a() {
            return this.f12775a;
        }

        public final boolean b() {
            return this.f12776b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f12775a == r6.f12775a) goto L12;
            return false;
        L12:
            if (this.f12776b == r6.f12776b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f12775a) * 31) + Boolean.hashCode(this.f12776b);
        }

        public String toString() {
            return "AccessibilityState(isMasterEnabled=" + this.f12775a + ", isServiceEnabled=" + this.f12776b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/screencapture/accessibility/AccessibilityUtil$masterSwitchObserver$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends ContentObserver {
        b(Handler r1) {
            super(r1);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r1) {
            c.f12773a.c();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.screencapture.accessibility.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/screencapture/accessibility/AccessibilityUtil$serviceSwitchObserver$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0689c extends ContentObserver {
        C0689c(Handler r1) {
            super(r1);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r1) {
            c.f12773a.c();
        }
    }

    static {
        f12773a = new c();
        boolean r1 = false;
        ae<a> r0 = at.a(new a(r1, r1, 3, null));
        c = r0;
        e = k.a(r0);
        Handler r2 = new Handler(Looper.getMainLooper());
        g = r2;
        h = new b(r2);
        i = new C0689c(r2);
    }

    private c() {
    }

    private static final boolean a(ComponentName r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return Intrinsics.areEqual(ComponentName.unflattenFromString(r2), r1);
    }

    private final ComponentName b(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        String r3 = MemoryAccessibilityService.class.getCanonicalName();
        if (r3 != null) goto L7;
        return null;
    L7:
        return new ComponentName(r1.getPackageName(), r3);
    }

    private static final boolean b(ComponentName r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return Intrinsics.areEqual(ComponentName.unflattenFromString(r2), r1);
    }

    private final List<String> c(Context r9) {
        String r8 = Settings.Secure.getString(((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "enabled_accessibility_services");     // Catch: Exception -> L23
        if (r8 == null) goto L34;
        List r10 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{':'}, false, 0, 6, null);     // Catch: Exception -> L23
        if (r10 == null) goto L34;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L23
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L23
        Iterator r12 = r11.iterator();     // Catch: Exception -> L23
    L9:
        if (r12.hasNext() == false) goto L11;
        r1.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());     // Catch: Exception -> L23
        goto L9
    L11:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L23
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L23
        Iterator r14 = r13.iterator();     // Catch: Exception -> L23
    L13:
        if (r14.hasNext() == false) goto L33;
        Object r3 = r14.next();     // Catch: Exception -> L23
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L13;
        r2.add(r3);     // Catch: Exception -> L23
        goto L13
    L17:
        r4 = false;
        goto L18
    L33:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    L34:
        return CollectionsKt.emptyList();
    L23:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityUtil", "Failed to get enabled services: " + e.getMessage(), null, 4, null);
        return CollectionsKt.emptyList();
    }

    private final boolean c(Context r13, boolean r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        final ComponentName r2 = b(r15);     // Catch: Exception -> L30
        if (r2 != null) goto L7;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityUtil", "Cannot resolve service ComponentName", null, 4, null);     // Catch: Exception -> L30
        return false;
    L7:
        String r3 = r2.flattenToString();     // Catch: Exception -> L30
        Intrinsics.checkNotNullExpressionValue(r3, "flattenToString(...)");     // Catch: Exception -> L30
        List r4 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(c(r15), Collection.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L30
        final ComponentName r5 = new ComponentName(r15.getPackageName(), "com.obric.memorydata.screencapture.service.MemoryAccessibilityService");     // Catch: Exception -> L30
        boolean r6 = CollectionsKt.removeAll(r4, new $$Lambda$c$5cNAmqORxZFHNhZPrvNq0LjrJc(r5));     // Catch: Exception -> L30
        if (r14 == true) goto L10;
        boolean r7 = CollectionsKt.removeAll(r4, new $$Lambda$c$bhTcqklvGGY2DmkI5_MoHVT6ldI(r2));     // Catch: Exception -> L30
    L14:
        if (r7 == true) goto L20;
        if (r6 == true) goto L20;
        if (r14 == false) goto L35;
        d();     // Catch: Exception -> L30
        return true;
    L35:
        return true;
    L20:
        boolean r12 = Settings.Secure.putString(r15.getContentResolver(), "enabled_accessibility_services", CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(ParameterizedMessage.ERROR_MSG_SEPARATOR, CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));     // Catch: Exception -> L30
        if (r12 == false) goto L24;
        if (r14 == false) goto L24;
        f12773a.d();     // Catch: Exception -> L30
    L34:
        return r12;
    L24:
        if (r12 == false) goto L34;
        if (r14 == true) goto L34;
        if (f12774b == false) goto L34;
        com.obric.memorydata.screencapture.service.b.f12812a.b();     // Catch: Exception -> L30
        f12774b = false;     // Catch: Exception -> L30
        goto L34
    L10:
        if (r4.contains(r3) == false) goto L12;
        r7 = false;
        goto L14
    L12:
        r7 = r4.add(r3);     // Catch: Exception -> L30
    L30:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityUtil", "setServiceInternal(" + r14 + ") Exception: " + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), null, 4, null);
        return false;
    }

    private final void d() {
        if (f12774b == true) goto L6;
        com.obric.memorydata.screencapture.service.b.f12812a.a();
        f12774b = true;
        return;
    }

    private final boolean d(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        ComponentName r0 = b(r4);
        if (r0 == null) goto L9;
        String r1 = r0.flattenToString();
        if (r1 != null) goto L8;
        return false;
    L8:
        return c(r4).contains(r1);
    L9:
        return false;
    }

    /* JADX INFO: renamed from: lambda$5cNAmqORxZFHNhZPrvN-q0LjrJc, reason: not valid java name */
    public static /* synthetic */ boolean m1170lambda$5cNAmqORxZFHNhZPrvNq0LjrJc(ComponentName r0, String r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$bhTcqklvGGY2DmkI5_MoHVT6ldI(ComponentName r0, String r1) {
        return b(r0, r1);
    }

    public final ar<a> a() {
        return e;
    }

    public final void a(Activity r8, int r9) {
        Activity r10 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "activity");
        if (j == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityUtil", "jumpToToggleAccessibilityService: no ToggleActivity, skip jump", false, 4, null);
        return;
    L6:
        ComponentName r1 = b((Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.memorydata.plugin"));
        if (r1 != null) goto L10;
        c r7 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityUtil", "Cannot resolve service ComponentName for jump", null, 4, null);
        return;
    L10:
        Intent r3 = new Intent();
        r3.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$ToggleAccessibilityServiceActivity"));
        r3.putExtra("component_name", (Parcelable) ZeusTransformUtils.preCheckCast(r1, Parcelable.class, "com.obric.memorydata.plugin"));
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        c r11 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        ZeusTransformUtils.startActivityForResult(r10, r3, r9, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Object r12 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r13 = Result.m1424exceptionOrNullimpl(r12);
        if (r13 == null) goto L21;
        RunLog.INSTANCE.error("AccessibilityUtil", "jumpToToggleAccessibilityService, startActivityForResult failed", r13);
        return;
    L21:
        return;
    L13:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public final void a(Context r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "appContext");
        if (f == null) goto L5;
        return;
    L5:
        f = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
        c r4 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        Intent r5 = new Intent();     // Catch: Throwable -> L12
        r5.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$ToggleAccessibilityServiceActivity"));     // Catch: Throwable -> L12
        if (r12.getPackageManager().resolveActivity(r5, 0) == null) goto L9;
        boolean r6 = true;
    L10:
        Object r7 = Result.m1421constructorimpl(Boolean.valueOf(r6));     // Catch: Throwable -> L12
    L15:
        if (Result.m1427isFailureimpl(r7) == false) goto L17;
        r7 = false;
    L17:
        j = ((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityUtil", "init: hasToggleAccessibilityActivity=" + j, false, 4, null);
        if (j == true) goto L20;
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r13, "getApplicationContext(...)");
        a(r13, true);
    L20:
        Context r14 = f;
        Intrinsics.checkNotNull(r14);
        ContentResolver r15 = r14.getContentResolver();
        ZeusProviderTransform.registerContentObserver(r15, Settings.Secure.getUriFor("enabled_accessibility_memory_services"), false, (ContentObserver) ZeusTransformUtils.preCheckCast(h, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        ZeusProviderTransform.registerContentObserver(r15, Settings.Secure.getUriFor("enabled_accessibility_services"), false, (ContentObserver) ZeusTransformUtils.preCheckCast(i, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        c();
        return;
    L9:
        r6 = false;
    L12:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public final synchronized boolean a(Context r11, boolean r12) {
        monitor-enter(this);
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r13, "context");     // Catch: Throwable -> L28
        if (r12 == false) goto L6;
        String r0 = "turnOn";
    L7:
        boolean r1 = false;
        if (r12 == false) goto L31;
    L14:
        ContentResolver r14 = r13.getContentResolver();     // Catch: Exception -> L24 Throwable -> L28
        if (r12 == false) goto L17;
        int r15 = 1;
    L18:
        boolean r16 = Settings.Secure.putInt(r14, "enabled_accessibility_memory_services", r15);     // Catch: Exception -> L24 Throwable -> L28
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L24 Throwable -> L28
        StringBuilder r17 = new StringBuilder().append(r0).append(" MasterSwitch ");     // Catch: Exception -> L24 Throwable -> L28
        if (r16 == false) goto L21;
        String r4 = "SUCCESS";
    L22:
        IRunLog.a.a(r2, "AccessibilityUtil", r17.append(r4).toString(), false, 4, null);     // Catch: Exception -> L24 Throwable -> L28
        c();     // Catch: Exception -> L24 Throwable -> L28
        r1 = r16;
    L26:
        monitor-exit(this);
        return r1;
    L24:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityUtil", r0 + " MasterSwitch Exception: " + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), null, 4, null);     // Catch: Throwable -> L28
        goto L26
    L21:
        r4 = "FAIL";
        goto L22
    L17:
        r15 = 0;
        goto L18
    L31:
        boolean r3 = c(r13, false);     // Catch: Exception -> L24 Throwable -> L28
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L24 Throwable -> L28
        StringBuilder r6 = new StringBuilder().append(r0).append(" MasterSwitch -> sub-service ");     // Catch: Exception -> L24 Throwable -> L28
        if (r3 == false) goto L12;
        String r7 = "SUCCESS";
    L13:
        IRunLog.a.a(r5, "AccessibilityUtil", r6.append(r7).toString(), false, 4, null);     // Catch: Exception -> L24 Throwable -> L28
        goto L14
    L12:
        r7 = "FAIL";
        goto L13
    L6:
        r0 = "turnOff";
    L28:
        th = move-exception;
        throw th;
    }

    public final boolean b() {
        return ((a) ZeusTransformUtils.preCheckCast(c.c(), a.class, "com.obric.memorydata.plugin")).a();
    }

    public final synchronized boolean b(Context r9, boolean r10) {
        monitor-enter(this);
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        Intrinsics.checkNotNullParameter(r11, "context");     // Catch: Throwable -> L27
        if (r10 == false) goto L6;
        String r0 = "turnOn";
    L7:
        boolean r1 = false;
        if (r10 == true) goto L30;
    L14:
        boolean r12 = c(r11, r10);     // Catch: Exception -> L23 Throwable -> L27
        if (r12 == false) goto L17;
        c();     // Catch: Exception -> L23 Throwable -> L27
    L17:
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L23 Throwable -> L27
        StringBuilder r13 = new StringBuilder().append(r0).append(" AccessibilityService ");     // Catch: Exception -> L23 Throwable -> L27
        if (r12 == false) goto L20;
        String r4 = "SUCCESS";
    L21:
        IRunLog.a.a(r2, "AccessibilityUtil", r13.append(r4).toString(), false, 4, null);     // Catch: Exception -> L23 Throwable -> L27
        r1 = r12;
    L25:
        monitor-exit(this);
        return r1;
    L20:
        r4 = "FAIL";
        goto L21
    L30:
        c();     // Catch: Exception -> L23 Throwable -> L27
        if (b() == true) goto L14;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityUtil", r0 + " AccessibilityService REJECTED: master switch is OFF", null, 4, null);     // Catch: Exception -> L23 Throwable -> L27
        monitor-exit(this);
        return false;
    L23:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityUtil", r0 + " AccessibilityService Exception: " + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), null, 4, null);     // Catch: Throwable -> L27
        goto L25
    L6:
        r0 = "turnOff";
    L27:
        th = move-exception;
        throw th;
    }

    public final void c() {
        Context r0 = f;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r1 = false;
        if (Settings.Secure.getInt(r0.getContentResolver(), "enabled_accessibility_memory_services", 0) != 1) goto L10;
        r1 = true;
    L10:
        boolean r9 = d(r0);
        a r2 = new a(r1, r9);
        c.b(r2);
        if (Intrinsics.areEqual(d, r2) == true) goto L17;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityUtil", "refreshState: master=" + r1 + ", service=" + r9, false, 4, null);
        d = r2;
        return;
    }
}
