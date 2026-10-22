package com.larus.uaigc.applet;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.platform.api.creation.UserCreation;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ny8.e;
import ny9.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\u0010H\u0016J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J \u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0014H\u0016J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#H\u0016J \u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J.\u0010)\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010-\u001a\u0004\u0018\u00010+H\u0016J4\u0010.\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00072\u0006\u0010/\u001a\u0002002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000502H\u0016J$\u00103\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000502H\u0016J\b\u00104\u001a\u00020\u0007H\u0016J\u0010\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020#H\u0016J\u001a\u00107\u001a\u00020\u00072\u0006\u00106\u001a\u00020#2\b\u00108\u001a\u0004\u0018\u00010+H\u0016J \u00109\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010:\u001a\u00020+2\u0006\u0010-\u001a\u00020+H\u0016J\u0012\u0010;\u001a\u00020\u00072\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0012\u0010>\u001a\u00020\u00072\b\u0010?\u001a\u0004\u0018\u00010\u0016H\u0016¨\u0006@"}, d2 = {"Lcom/larus/uaigc/applet/IAICreationAppletHostServiceNoop;", "Lcom/larus/uaigc/applet/IAICreationAppletHostService;", "<init>", "()V", "prewarmCreatePageApplet", "", "shouldOpenFromBottomTab", "", "openCreatePage", "config", "Lcom/larus/uaigc/bean/createpage/ICreatePageConfig;", "allowNativeFallback", "createCreatePageIntent", "Landroid/content/Intent;", "Lcom/larus/uaigc/bean/createpage/CreatePageConfig;", "openCanvasPage", "Lcom/larus/canvas/service/bean/ICanvasInitConfig;", "createCanvasPageIntent", "openDetailPage", "context", "Landroid/content/Context;", "payload", "Landroid/os/Bundle;", "asRoot", "openImageRemovePage", "openProfilePage", "openNativeMineProfilePage", "notifyPublishSuccess", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "shouldRouteResultToChatAfterApplet", "getNativeRouteContextBelowApplet", "currentContext", "navigateBack", "delta", "", "onRouteFailure", "Lkotlin/Function0;", "closeApplet", "clearAICreationHomeMemory", "clearAICreationHomeMemoryForNextOpen", "openHomeFromDoubaoAppsSchemaIfNeeded", "appId", "", "pageUrl", "routeMode", "routeNativeBelowApplet", "closeDelayMs", "", "routeAction", "Lkotlin/Function1;", "routeNativeBelowAppletAndMoveToBack", "finishNativeHostBelowApplet", "setEmptyResultAndFinishCamera", "resultCode", "completeCameraCreationMessageSent", "conversationId", "openPreparedAppletUrl", "url", "isAICreationAppletActivity", "activity", "Landroid/app/Activity;", "isFromAICreationApplet", "args", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class IAICreationAppletHostServiceNoop implements IAICreationAppletHostService {
    public IAICreationAppletHostServiceNoop() {
    }

    public final boolean a(e r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return false;
    }

    public final boolean b(String r1) {
        return false;
    }

    public final void c() {
    }

    public final void d() {
    }

    public final boolean e(c r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return false;
    }

    public final boolean f(c r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "config");
        return false;
    }

    public final void g(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    public final boolean h(int r1) {
        return false;
    }

    public final boolean i(boolean r1) {
        return false;
    }

    public final boolean j() {
        return false;
    }

    public final boolean k(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return false;
    }

    public final boolean l(Context r2, Function1<? super Context, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "routeAction");
        return false;
    }

    public final boolean m(Context r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "payload");
        return false;
    }

    public final boolean o(Context r1, Bundle r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "payload");
        return false;
    }

    public final boolean p(Context r1, boolean r2, long r3, Function1<? super Context, Unit> r5) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r5, "routeAction");
        return false;
    }

    public final boolean q() {
        return false;
    }

    public final boolean r(Context r1, Bundle r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "payload");
        return false;
    }

    public final boolean s(FragmentActivity r1) {
        return false;
    }

    public final boolean t(Bundle r1) {
        return false;
    }

    public final boolean u(Context r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        return false;
    }

    public final Context v(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "currentContext");
        return r2;
    }

    public final boolean n(int r1, Function0<Unit> r2) {
        r2.invoke();
        return false;
    }
}
