package com.obric.aiproactive.ui.entry;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\fJ=\u0010\u0017\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00050\u0019J)\u0010\u001d\u001a\u00020\u00142!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00050\u0019J\u0006\u0010\u001e\u001a\u00020\u0014J\u000e\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0005J\u0018\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\f2\b\b\u0002\u0010#\u001a\u00020\u0005J\u0016\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\fJ9\u0010&\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00052!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00050\u0019J\u000e\u0010'\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0001J\r\u0010(\u001a\u00020\fH\u0000¢\u0006\u0002\b)J\r\u0010*\u001a\u00020\fH\u0000¢\u0006\u0002\b+J\u001c\u0010,\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010-\u001a\u00020\u0014H\u0002J+\u0010.\u001a\u00020\u00142!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00050\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006/"}, d2 = {"Lcom/obric/aiproactive/ui/entry/HomeEnterPageExposureCoordinator;", "", "<init>", "()V", "initialized", "", "hostResumed", "resumeStartsNextExposure", "exposureVersion", "", "reportedExposureVersion", "sessionEnterFrom", "", "nextPreviousPage", "pendingStartupInspirationId", "coveringSheets", "", "isHomeContentVisible", "()Z", "initializeLaunch", "", "rawEnterFrom", "startupInspirationId", "onNewIntent", "report", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "enterFrom", "onHostResumed", "onHostPaused", "onHostStopped", "isChangingConfigurations", "onChildPageOpened", "previousPage", "releasesStartupDetailSuppression", "onCoveringSheetShown", "sheetToken", "onCoveringSheetDismissed", "onCoveringSheetAbandoned", "currentEnterFrom", "currentEnterFrom$ai_proactive_ui_obricRelease", "currentPreviousPage", "currentPreviousPage$ai_proactive_ui_obricRelease", "updateLaunchContext", "beginNextExposure", "reportIfEligible", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6619b;
    private boolean c;
    private long d;
    private long e;
    private String f;
    private String g;
    private String h;
    private final Map<Object, String> i;

    public h() {
        this.e = -1;
        this.f = "desktop_icon";
        this.g = "";
        this.i = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private final void b(String r1, String r2) {
        this.f = com.obric.aiproactive.ui.util.n.a(r1, r2);
        this.h = r2;
    }

    private final void b(Function1<? super String, Boolean> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        if (this.f6619b == true) goto L5;
        return;
    L5:
        if ((!this.i.isEmpty()) == false) goto L7;
        return;
    L7:
        if (com.obric.aiproactive.ui.util.n.b(this.f, this.h) == true) goto L10;
        return;
    L10:
        if (this.e != this.d) goto L13;
        return;
    L13:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.invoke(this.f), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L18;
        this.e = this.d;
        this.g = "";
        return;
    }

    private final void e() {
        this.d++;
    }

    public final void a(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "sheetToken");
        this.i.remove(r2);
    }

    public final void a(Object r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "sheetToken");
        Intrinsics.checkNotNullParameter(r3, "previousPage");
        this.i.put(r2, r3);
    }

    public final void a(Object r3, boolean r4, Function1<? super String, Boolean> r5) {
        Function1<? super String, Boolean> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "sheetToken");
        Intrinsics.checkNotNullParameter(r6, "report");
        String r7 = (String) ZeusTransformUtils.preCheckCast(this.i.remove(r3), String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        this.g = r7;
        if (r4 == false) goto L8;
        this.h = null;
    L8:
        e();
        b(r6);
    }

    public final void a(String r2, String r3) {
        if (this.f6618a == false) goto L5;
        return;
    L5:
        this.f6618a = true;
        b(r2, r3);
    }

    public final void a(String r3, String r4, Function1<? super String, Boolean> r5) {
        Function1<? super String, Boolean> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "report");
        this.f6618a = true;
        b(r3, r4);
        this.g = "";
        e();
        b(r6);
    }

    public final void a(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "previousPage");
        this.g = r2;
        if (r3 == false) goto L6;
        this.h = null;
        return;
    }

    public final void a(Function1<? super String, Boolean> r3) {
        Function1<? super String, Boolean> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "report");
        if (this.c == false) goto L5;
        this.c = false;
        e();
    L5:
        this.f6619b = true;
        b(r4);
    }

    public final void a(boolean r2) {
        this.f6619b = false;
        if (r2 == false) goto L6;
        this.c = false;
        return;
    }

    public final boolean a() {
        if (this.f6619b == false) goto L16;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.h, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L16;
        if (this.i.isEmpty() == false) goto L16;
        return true;
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r1 = false;
    L16:
        return false;
    }

    public final void b() {
        if (this.f6619b == false) goto L5;
        this.c = true;
    L5:
        this.f6619b = false;
    }

    public final String c() {
        return this.f;
    }

    public final String d() {
        return this.g;
    }
}
