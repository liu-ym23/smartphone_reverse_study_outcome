package com.obric.memorydata.recommend.feature;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.recommend.settings.t;
import com.obric.memorydata.utils.af;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.an;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0014J\u0016\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u0016\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019J\b\u0010\u001e\u001a\u00020\u0014H\u0002J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0005H\u0002J\u0006\u0010!\u001a\u00020\bJ\u0006\u0010\"\u001a\u00020\u0005J\b\u0010#\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/memorydata/recommend/feature/ScreenObservationControl;", "", "<init>", "()V", "TAG", "", "screenObservationEnabled", "Lkotlinx/coroutines/flow/StateFlow;", "", "getScreenObservationEnabled", "()Lkotlinx/coroutines/flow/StateFlow;", "_isAppSecure", "Lkotlinx/coroutines/flow/MutableStateFlow;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isSecure", "restoreTime", "", "lastForegroundPackageName", "addAppSwitchListener", "", "enableScreenObservation", "disableScreenObservation", "disableScreenObservationUntil", "delayHours", "", "delayMinutes", "disableScreenObservationUntilTimeOfDay", "targetHour", "targetMinute", "refreshSecureStateFromTopApp", "isPackageSecure", ObricMemoryConstants.KEY_PACKAGE_NAME, "isTemporarilyDisabled", "getRestoreTimeText", "restoreScheduledTaskIfNeeded", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12505a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ar<Boolean> f12506b = null;
    private static final ae<Boolean> c = null;
    private static final al d = null;
    private static final ar<Boolean> e = null;
    private static long f;
    private static volatile String g;

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.feature.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class C0669a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12507a = null;

        static {
            int[] r0 = new int[ScreenObservationRestoreAction.values().length];
            r0[ScreenObservationRestoreAction.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ScreenObservationRestoreAction.RESCHEDULE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ScreenObservationRestoreAction.RESTORE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f12507a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/recommend/feature/ScreenObservationControl$addAppSwitchListener$1", "Lcom/obric/memorydata/utils/MemoryAppStateListener$AppSwitchListener;", "onAppOpen", "", "appName", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "onAppClose", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements af.a {
        b() {
        }

        @Override // com.obric.memorydata.utils.af.a
        public void a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "appName");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            a r1 = a.f12505a;
            a.a(r3);
            if (((Boolean) ZeusTransformUtils.preCheckCast(a.f12505a.a().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L6;
            a.g().b(Boolean.valueOf(a.a(a.f12505a, r3)));
            return;
        }

        @Override // com.obric.memorydata.utils.af.a
        public void b(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "appName");
            Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        }
    }

    static {
        a r0 = new a();
        f12505a = r0;
        f12506b = t.f12630a.e();
        ae<Boolean> r2 = at.a(false);
        c = r2;
        al r3 = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin"));
        d = r3;
        e = k.a(k.b((i) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.e.a.f13206a.a(), i.class, "com.obric.memorydata.plugin"), (i) ZeusTransformUtils.preCheckCast(r2, i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.preCheckCast(new ScreenObservationControl$isSecure$1(null), Function3.class, "com.obric.memorydata.plugin")), r3, an.a.a(an.f17422a, 0, 0, 3, null), false);
        r0.j();
        if (UserSettings.INSTANCE.hasAgreePrivacy() == false) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationControl", "hasAgreePrivacy: true", false, 4, null);
        r0.h();
        return;
    L5:
        UserSettings.INSTANCE.registerAgreePrivacyListener((com.obric.memorydata.middleware.api.app.a) ZeusTransformUtils.preCheckCast(new AnonymousClass1(), com.obric.memorydata.middleware.api.app.a.class, "com.obric.memorydata.plugin"));
    }

    private a() {
    }

    public static final /* synthetic */ void a(a r0) {
        r0.h();
    }

    public static final /* synthetic */ void a(String r0) {
        g = r0;
    }

    public static final /* synthetic */ boolean a(a r0, String r1) {
        return r0.b(r1);
    }

    private final boolean b(String r5) {
        if (((Set) ZeusTransformUtils.preCheckCast(t.f12630a.a().c(), Set.class, "com.obric.memorydata.plugin")).contains(r5) == false) goto L6;
    L11:
        return false;
    L6:
        if (((Set) ZeusTransformUtils.preCheckCast(t.f12630a.b().c(), Set.class, "com.obric.memorydata.plugin")).contains(r5) == false) goto L9;
        return true;
    L9:
        if (t.f12630a.d().contains(r5) == true) goto L11;
        return true;
    }

    public static final /* synthetic */ ae g() {
        return c;
    }

    private final void h() {
        af.f13160a.a((af.a) ZeusTransformUtils.preCheckCast(new b(), af.a.class, "com.obric.memorydata.plugin"));
    }

    private final void i() {
        String r0 = g;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationControl", "refreshSecureStateFromTopApp: cached package empty", false, 4, null);
        c.b(false);
        return;
    L12:
        boolean r10 = b(r0);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationControl", "refreshSecureStateFromTopApp: pkg=" + r0 + " secure=" + r10, false, 4, null);
        c.b(Boolean.valueOf(r10));
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    private final void j() {
        long r0 = t.f12630a.l();
        long r2 = System.currentTimeMillis();
        int r4 = C0669a.f12507a[com.obric.memorydata.recommend.feature.b.a(r0, r2).ordinal()];
        if (r4 != 1) goto L5;
        return;
    L5:
        if (r4 != 2) goto L7;
        f = r0;
        ScreenObservationRestoreTask.Companion.a(r0 - r2);
        return;
    L7:
        if (r4 != 3) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationControl", "restore expired screen observation, overdueMillis: " + (r2 - r0), false, 4, null);
        c();
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final ar<Boolean> a() {
        return f12506b;
    }

    public final void a(int r12, int r13) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationControl", "Disabling screen observation until " + r12 + " hours " + r13 + " minutes", false, 4, null);
        Calendar r11 = Calendar.getInstance();
        r11.add(11, r12);
        r11.add(12, r13);
        r11.set(13, 0);
        r11.set(14, 0);
        long r3 = r11.getTimeInMillis();
        f = r3;
        long r4 = r3 - System.currentTimeMillis();
        if (r4 <= 0) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationControl", "Disabling screen observation delayHours " + r12 + " delayMinutes " + r13, false, 4, null);
        t.f12630a.a(f);
        ScreenObservationRestoreTask.Companion.a(r4);
    L6:
        t.f12630a.a(false);
        c.b(false);
        return;
    L5:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationControl", " disableScreenObservationUntil Invalid delay time, must be positive", null, 4, null);
        goto L6
    }

    public final ar<Boolean> b() {
        return e;
    }

    public final void b(int r19, int r20) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationControl", "Disabling screen observation until " + r19 + ':' + r20, false, 4, null);
        Calendar r2 = Calendar.getInstance();
        Calendar r5 = Calendar.getInstance();
        r5.set(11, r19);
        r5.set(12, r20);
        r5.set(13, 0);
        r5.set(14, 0);
        if (r5.getTimeInMillis() > r2.getTimeInMillis()) goto L5;
        r5.add(6, 1);
    L5:
        long r8 = r5.getTimeInMillis() - r2.getTimeInMillis();
        if (r8 <= 0) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationControl", "Disabling screen observation until " + r19 + ':' + r20 + ", delayMillis: " + r8, false, 4, null);
        f = r5.getTimeInMillis();
        t.f12630a.a(f);
        ScreenObservationRestoreTask.Companion.a(r8);
    L9:
        t.f12630a.a(false);
        c.b(false);
        return;
    L8:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationControl", " disableScreenObservationUntilTimeOfDay Invalid delay time, must be positive", null, 4, null);
        goto L9
    }

    public final void c() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationControl", "Enabling screen observation", false, 4, null);
        ScreenObservationRestoreTask.Companion.a();
        f = 0;
        t.f12630a.m();
        t.f12630a.a(true);
        if (((Boolean) ZeusTransformUtils.preCheckCast(t.f12630a.e().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L6;
        i();
        return;
    }

    public final void d() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationControl", "Disabling screen observation", false, 4, null);
        f = 0;
        t.f12630a.m();
        ScreenObservationRestoreTask.Companion.a();
        c.b(false);
        t.f12630a.a(false);
    }

    public final boolean e() {
        if (f > System.currentTimeMillis()) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(t.f12630a.e().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L7;
        return true;
    }

    public final String f() {
        if (e() == true) goto L6;
        return "";
    L6:
        if ((f - System.currentTimeMillis()) > 0) goto L9;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationControl", "restoreTime is in the past: " + f, null, 4, null);
        return "";
    L9:
        Calendar r7 = Calendar.getInstance();
        r7.setTimeInMillis(f);
        String r8 = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(r7.getTime());
        Intrinsics.checkNotNullExpressionValue(r8, "format(...)");
        return r8;
    }
}
