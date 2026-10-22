package com.obric.widget.host.runtime;

import ai.j0;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.os.ConfigurationCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.sync.e;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001:\u00014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJL\u0010\"\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u001c\u0010!\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000 \u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001fH\u0086@¢\u0006\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010%R\u0014\u0010(\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010%R\u0014\u0010)\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010%R\u0014\u0010*\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010+R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/obric/widget/host/runtime/CalendarWidgetLocaleRestoreRenderGate;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/obric/widget/host/runtime/CalendarWidgetLocaleRestoreRenderGate$Window;", "resolveWindow", "(Landroid/content/Context;)Lcom/obric/widget/host/runtime/CalendarWidgetLocaleRestoreRenderGate$Window;", "", "rememberInitialLocaleFingerprint", "(Landroid/content/Context;)V", "", "appletId", "", "isCalendarApplet", "(Ljava/lang/String;)Z", "buildLocaleFingerprint", "(Landroid/content/Context;)Ljava/lang/String;", "renderReason", "shouldGate$widget_host_sdk_release", "(Ljava/lang/String;Ljava/lang/String;)Z", "shouldGate", "previousLocaleFingerprint", "currentLocaleFingerprint", "", "nowElapsed", "calculateWindow$widget_host_sdk_release", "(Ljava/lang/String;Ljava/lang/String;J)Lcom/obric/widget/host/runtime/CalendarWidgetLocaleRestoreRenderGate$Window;", "calculateWindow", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "create", "runIfNeeded", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "CALENDAR_APPLET_ID", "CALENDAR2_APPLET_ID", "PREFERENCES_NAME", "LAST_LOCALE_FINGERPRINT_KEY", "RESTORE_COHORT_ADMISSION_MS", "J", "RESTORE_RENDER_STAGGER_MS", "Lkotlinx/coroutines/sync/a;", "renderMutex", "Lkotlinx/coroutines/sync/a;", "stateLock", "Ljava/lang/Object;", "activeWindow", "Lcom/obric/widget/host/runtime/CalendarWidgetLocaleRestoreRenderGate$Window;", "Window", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCalendarWidgetLocaleRestoreRenderGate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CalendarWidgetLocaleRestoreRenderGate.kt\ncom/obric/widget/host/runtime/CalendarWidgetLocaleRestoreRenderGate\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,136:1\n116#2,11:137\n1#3:148\n*S KotlinDebug\n*F\n+ 1 CalendarWidgetLocaleRestoreRenderGate.kt\ncom/obric/widget/host/runtime/CalendarWidgetLocaleRestoreRenderGate\n*L\n72#1:137,11\n*E\n"})
public final class CalendarWidgetLocaleRestoreRenderGate {
    private static final String CALENDAR2_APPLET_ID = "com.flow.calendar2";
    private static final String CALENDAR_APPLET_ID = "com.flow.calendar";
    public static final CalendarWidgetLocaleRestoreRenderGate INSTANCE = null;
    private static final String LAST_LOCALE_FINGERPRINT_KEY = "last_locale_fingerprint";
    private static final String PREFERENCES_NAME = "calendar_widget_render_state";
    private static final long RESTORE_COHORT_ADMISSION_MS = 1500;
    private static final long RESTORE_RENDER_STAGGER_MS = 120;
    private static final String TAG = "CalendarWidgetRestoreGate";
    private static Window activeWindow;
    private static final kotlinx.coroutines.sync.a renderMutex = null;
    private static final Object stateLock = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/widget/host/runtime/CalendarWidgetLocaleRestoreRenderGate$Window;", "", "renderNotBeforeElapsed", "", "admissionEndsElapsed", "<init>", "(JJ)V", "getRenderNotBeforeElapsed", "()J", "getAdmissionEndsElapsed", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Window {
        private final long admissionEndsElapsed;
        private final long renderNotBeforeElapsed;

        public Window(long r5, long r10) {
            this.renderNotBeforeElapsed = r5;
            this.admissionEndsElapsed = r10;
        }

        public static /* synthetic */ Window copy$default(Window r5, long r10, long r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = r5.renderNotBeforeElapsed;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r11 = r5.admissionEndsElapsed;
        L9:
            return r5.copy(r10, r11);
        }

        public final long component1() {
            return this.renderNotBeforeElapsed;
        }

        public final long component2() {
            return this.admissionEndsElapsed;
        }

        public final Window copy(long r5, long r10) {
            return new Window(r5, r10);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof Window) == true) goto L8;
            return false;
        L8:
            Window r11 = (Window) r10;
            if (this.renderNotBeforeElapsed == r11.renderNotBeforeElapsed) goto L12;
            return false;
        L12:
            if (this.admissionEndsElapsed == r11.admissionEndsElapsed) goto L14;
            return false;
        L14:
            return true;
        }

        public final long getAdmissionEndsElapsed() {
            return this.admissionEndsElapsed;
        }

        public final long getRenderNotBeforeElapsed() {
            return this.renderNotBeforeElapsed;
        }

        public int hashCode() {
            int r5 = Long.hashCode(this.renderNotBeforeElapsed) * 31;
            return Long.hashCode(this.admissionEndsElapsed) + r5;
        }

        public String toString() {
            long r5 = this.renderNotBeforeElapsed;
            long r10 = this.admissionEndsElapsed;
            return j0.o(j0.t(r5, "Window(renderNotBeforeElapsed=", ", admissionEndsElapsed="), r10, ")");
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.CalendarWidgetLocaleRestoreRenderGate$runIfNeeded$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.CalendarWidgetLocaleRestoreRenderGate", f = "CalendarWidgetLocaleRestoreRenderGate.kt", i = {3, 3, 3, 4, 4, 5, 6, 6}, l = {65, 69, 71, 142, 75, 77, 79}, m = "runIfNeeded", n = {"create", "window", "$this$withLock_u24default$iv", "create", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "result"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$0", "L$1"})
    public static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CalendarWidgetLocaleRestoreRenderGate this$0;

        public AnonymousClass1(CalendarWidgetLocaleRestoreRenderGate r5, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.runIfNeeded(null, null, null, null, this);
        }
    }

    static {
        INSTANCE = new CalendarWidgetLocaleRestoreRenderGate();
        renderMutex = e.a();
        stateLock = new Object();
    }

    private CalendarWidgetLocaleRestoreRenderGate() {
    }

    private final String buildLocaleFingerprint(Context r5) {
        Configuration r10 = r5.getResources().getConfiguration();
        return ConfigurationCompat.getLocales(r10).toLanguageTags() + "|layoutDirection=" + r10.getLayoutDirection();
    }

    private final boolean isCalendarApplet(String r5) {
        if (Intrinsics.areEqual(r5, "com.flow.calendar") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r5, CALENDAR2_APPLET_ID) == true) goto L8;
        return false;
    }

    private final void rememberInitialLocaleFingerprint(Context r5) {
        Object r10 = stateLock;
        monitor-enter(r10);
        SharedPreferences r11 = r5.getApplicationContext().getSharedPreferences(PREFERENCES_NAME, 0);     // Catch: Throwable -> L9
        String r12 = r11.getString(LAST_LOCALE_FINGERPRINT_KEY, null);     // Catch: Throwable -> L9
        if (r12 != null) goto L7;
    L11:
        r11.edit().putString(LAST_LOCALE_FINGERPRINT_KEY, INSTANCE.buildLocaleFingerprint(r5)).apply();     // Catch: Throwable -> L9
    L12:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r10);
        return;
    L7:
        if (StringsKt.isBlank(r12) == false) goto L12;
    L9:
        th = move-exception;
        throw th;
    }

    private final Window resolveWindow(Context r10) {
        long r5 = SystemClock.elapsedRealtime();
        Object r11 = stateLock;
        monitor-enter(r11);
        SharedPreferences r12 = r10.getApplicationContext().getSharedPreferences(PREFERENCES_NAME, 0);     // Catch: Throwable -> L7
        CalendarWidgetLocaleRestoreRenderGate r13 = INSTANCE;     // Catch: Throwable -> L7
        String r14 = r13.buildLocaleFingerprint(r10);     // Catch: Throwable -> L7
        Window r15 = null;
        String r16 = r12.getString(LAST_LOCALE_FINGERPRINT_KEY, null);     // Catch: Throwable -> L7
        Window r17 = r13.calculateWindow$widget_host_sdk_release(r16, r14, r5);     // Catch: Throwable -> L7
        if (Intrinsics.areEqual(r16, r14) == true) goto L9;
        r12.edit().putString(LAST_LOCALE_FINGERPRINT_KEY, r14).apply();     // Catch: Throwable -> L7
    L9:
        if (r17 == null) goto L11;
        activeWindow = r17;     // Catch: Throwable -> L7
        Log.i(TAG, "calendar locale changed; gate restore render");     // Catch: Throwable -> L7
    L11:
        Window r18 = activeWindow;     // Catch: Throwable -> L7
        if (r18 == null) goto L17;
        if (r5 >= r18.getAdmissionEndsElapsed()) goto L17;
        r15 = r18;
    L17:
        monitor-exit(r11);
        return r15;
    L7:
        th = move-exception;
        throw th;
    }

    public final Window calculateWindow$widget_host_sdk_release(String r5, String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "currentLocaleFingerprint");
        if (r5 != null) goto L5;
        return null;
    L5:
        if (StringsKt.isBlank(r5) == false) goto L8;
        return null;
    L8:
        if (Intrinsics.areEqual(r5, r10) == false) goto L11;
        return null;
    L11:
        return new Window(r11, RESTORE_COHORT_ADMISSION_MS + r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v6 */
    public final <T> Object runIfNeeded(Context r10, String r11, String r12, Function1<? super Continuation<? super T>, ? extends Object> r13, Continuation<? super T> r14) {
        if ((r14 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r5 = (AnonymousClass1) r14;
        int r15 = r5.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r5.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r5.label) {
            case 0: goto L27;
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L20;
            case 6: goto L17;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        Object r18 = r5.L$1;
        kotlinx.coroutines.sync.a r19 = (kotlinx.coroutines.sync.a) r5.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L15
        kotlinx.coroutines.sync.a r20 = r19;
    L65:
        ((kotlinx.coroutines.sync.d) r20).d(null);
        return r18;
    L17:
        kotlinx.coroutines.sync.a r21 = (kotlinx.coroutines.sync.a) r5.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L15
        kotlinx.coroutines.sync.a r22 = r21;
    L61:
        r5.L$0 = r22;     // Catch: Throwable -> L15
        r5.L$1 = r16;     // Catch: Throwable -> L15
        r5.label = 7;     // Catch: Throwable -> L15
        if (DelayKt.delay(RESTORE_RENDER_STAGGER_MS, r5) != r17) goto L64;
        return r17;
    L64:
        r18 = r16;
        r20 = r22;
        goto L65
    L20:
        kotlinx.coroutines.sync.a r23 = (kotlinx.coroutines.sync.a) r5.L$1;
        Function1<? super Continuation<? super T>, ? extends Object> r24 = (Function1) r5.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L15
        kotlinx.coroutines.sync.a r25 = r23;
    L54:
        r13 = r24;
        kotlinx.coroutines.sync.a r26 = r25;
    L58:
        r5.L$0 = r26;     // Catch: Throwable -> L15
        r5.L$1 = null;     // Catch: Throwable -> L15
        r5.L$2 = null;     // Catch: Throwable -> L15
        r5.label = 6;     // Catch: Throwable -> L15
        r16 = r13.invoke(r5);     // Catch: Throwable -> L15
        r22 = r26;
        if (r16 != r17) goto L61;
        return r17;
    L23:
        kotlinx.coroutines.sync.a r27 = (kotlinx.coroutines.sync.a) r5.L$2;
        Window r28 = (Window) r5.L$1;
        r13 = (Function1) r5.L$0;
        ResultKt.throwOnFailure(r16);
        kotlinx.coroutines.sync.a r29 = r27;
    L70:
        long r30 = r28.getRenderNotBeforeElapsed() - SystemClock.elapsedRealtime();     // Catch: Throwable -> L55
        if (r30 <= 0) goto L57;
        r5.L$0 = r13;     // Catch: Throwable -> L55
        r5.L$1 = r29;     // Catch: Throwable -> L55
        r5.L$2 = null;     // Catch: Throwable -> L55
        r5.label = 5;     // Catch: Throwable -> L55
        if (DelayKt.delay(r30, r5) != r17) goto L53;
        return r17;
    L53:
        r25 = r29;
        r24 = r13;
        goto L54
    L57:
        r26 = r29;
    L55:
        th = move-exception;
        r10 = r29;
        th = th;
    L67:
        ((kotlinx.coroutines.sync.d) r10).d(null);
        throw th;
    L24:
        ResultKt.throwOnFailure(r16);
    L44:
        return r16;
    L25:
        ResultKt.throwOnFailure(r16);
    L38:
        return r16;
    L26:
        ResultKt.throwOnFailure(r16);
    L32:
        return r16;
    L27:
        ResultKt.throwOnFailure(r16);
        if (isCalendarApplet(r11) == true) goto L34;
        r5.label = 1;
        r16 = r13.invoke(r5);
        if (r16 != r17) goto L32;
        return r17;
    L34:
        if (shouldGate$widget_host_sdk_release(r11, r12) == true) goto L39;
        rememberInitialLocaleFingerprint(r10);
        r5.label = 2;
        r16 = r13.invoke(r5);
        if (r16 != r17) goto L38;
        return r17;
    L39:
        r28 = resolveWindow(r10);
        if (r28 != null) goto L45;
        r5.label = 3;
        r16 = r13.invoke(r5);
        if (r16 != r17) goto L44;
        return r17;
    L45:
        kotlinx.coroutines.sync.a r31 = renderMutex;
        r5.L$0 = r13;
        r5.L$1 = r28;
        r5.L$2 = r31;
        r5.label = 4;
        kotlinx.coroutines.sync.d r32 = (kotlinx.coroutines.sync.d) r31;
        Object r33 = r32.c(r5);
        r29 = r32;
        if (r33 != r17) goto L70;
        return r17;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        th = th;
    L7:
        r5 = new AnonymousClass1(this, r14);
        goto L8
    }

    public final boolean shouldGate$widget_host_sdk_release(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "renderReason");
        if (isCalendarApplet(r5) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r10, "onRestore") == false) goto L7;
        return true;
    }
}
