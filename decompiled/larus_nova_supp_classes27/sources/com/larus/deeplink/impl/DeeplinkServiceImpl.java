package com.larus.deeplink.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import b39.b;
import b39.d;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.applog.api.IApplog;
import com.larus.deeplink.api.IDeeplinkService;
import com.larus.platform.api.ExternalRouteEntry;
import com.larus.platform.api.ExternalRouteLaunchMode;
import com.larus.platform.api.q;
import com.larus.platform.service.i;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0016\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020!0#H\u0016¨\u0006%"}, d2 = {"Lcom/larus/deeplink/impl/DeeplinkServiceImpl;", "Lcom/larus/deeplink/api/IDeeplinkService;", "<init>", "()V", "isPushIntentUri", "", "uri", "Landroid/net/Uri;", "isFromShortcut", "isOuterUri", "isShareBotUri", "isInviteFriendUri", "getQueryParameterSafely", "", "key", "deeplink", "context", "Landroid/content/Context;", "deeplinkFromPush", "routerFromXOpen", "deeplinkOuterLink", "onHandleDeeplinkStartEvent", "", "intent", "Landroid/content/Intent;", "prepareRoute", "startRoute", "Lcom/larus/platform/api/ExternalRouteSession;", "entry", "Lcom/larus/platform/api/ExternalRouteEntry;", "onHandleDeeplinkSuccEvent", "handleIntent", "activity", "Landroid/app/Activity;", "getDeepLinkHandleActivityClazz", "Ljava/lang/Class;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeeplinkServiceImpl implements IDeeplinkService {

    public static final class a {
    }

    static {
    }

    public DeeplinkServiceImpl() {
    }

    @Override // com.larus.deeplink.api.IDeeplinkService
    public final Class<? extends Activity> e() {
        return DeepLinkHandleActivity.class;
    }

    @Override // com.larus.deeplink.api.IDeeplinkService
    public final boolean a(Uri r2) {
        if (r2 == null) goto L4;
        String r3 = l(r2, "bot_token");
    L6:
        return o0.d(r3);
    L4:
        r3 = null;
        goto L6
    }

    @Override // com.larus.deeplink.api.IDeeplinkService
    public final boolean b(Uri r5) {
        return CollectionsKt.contains(CollectionsKt.listOf(new String[]{"long_press_icon_camera", "long_press_icon_call", "shortcut", "shortcuts"}), l(r5, "open_method"));
    }

    @Override // com.larus.deeplink.api.IDeeplinkService
    public final void d(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        com.larus.deeplink.impl.a.a(r2);
    }

    @Override // com.larus.deeplink.api.IDeeplinkService
    public final boolean f(Uri r4) {
        String r1 = null;
        if (r4 == null) goto L5;
        String r2 = l(r4, "invite_token");
    L7:
        if (o0.d(r2) == true) goto L17;
        String r5 = Uri.decode(String.valueOf(r4));
        if (r5 == null) goto L14;
        Uri r6 = UriProtector.parse(r5);
        if (r6 == null) goto L14;
        r1 = l(r6, "invite_token");
    L14:
        if (o0.d(r1) == true) goto L17;
        return false;
    L17:
        return true;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.larus.deeplink.api.IDeeplinkService
    public final boolean g(Uri r2) {
        if (r2 == null) goto L4;
        String r3 = l(r2, "is_from_outer");
    L6:
        return Intrinsics.areEqual(r3, "true");
    L4:
        r3 = null;
        goto L6
    }

    @Override // com.larus.deeplink.api.IDeeplinkService
    public final void j(Uri r1) {
        b.c(r1);
    }

    @Override // com.larus.deeplink.api.IDeeplinkService
    public final boolean k(Uri r2) {
        if (r2 == null) goto L4;
        String r3 = l(r2, "is_from_push");
    L6:
        return Intrinsics.areEqual(r3, "true");
    L4:
        r3 = null;
        goto L6
    }

    public static String l(Uri r2, String r3) {
        if (r2 != null) goto L10;
        return null;
    L10:
        return UriProtector.getQueryParameter(r2, r3);
    L5:
        e = move-exception;
        FLogger.a.e("getQueryParameterSafely", "getQueryParameterSafely error e=" + e.getMessage());
        return "";
    }

    @Override // com.larus.deeplink.api.IDeeplinkService
    public final boolean c(Context r10, Uri r11) {
        Intrinsics.checkNotNullParameter(r11, "uri");
        List r2 = null;
        if (k(r11) == false) goto L19;
        String[] r1 = d.a;
        Intrinsics.checkNotNullParameter(r11, "uri");
        FLogger.a.i("DeeplinkGate", "routerFromPush: " + r11);
        e10 r0 = e10.a;
        List r3 = e10.m0().k();
        if (r3 == null) goto L7;
        List r4 = CollectionsKt.filterNotNull(r3);
    L9:
        if (e10.m0().d() == false) goto L12;
        if (r4 == null) goto L12;
    L13:
        List r5 = e10.m0().j();
        if (r5 == null) goto L16;
        r2 = CollectionsKt.filterNotNull(r5);
    L16:
        if (r2 != null) goto L43;
        r2 = CollectionsKt.listOf("");
    L43:
        return d.b(r10, r11, r2, null, true, false);
    L12:
        ArraysKt.toList(d.a);
        goto L13
    L7:
        r4 = null;
        goto L9
    L19:
        String[] r6 = d.a;
        Intrinsics.checkNotNullParameter(r11, "uri");
        FLogger.a.i("DeeplinkGate", "routerFromOuterLink: " + r11);
        e10 r7 = e10.a;
        List r8 = e10.m0().i();
        if (r8 == null) goto L22;
        List r9 = CollectionsKt.filterNotNull(r8);
    L24:
        if (e10.m0().b() == false) goto L27;
        if (r9 == null) goto L27;
    L28:
        List r12 = e10.m0().g();
        if (r12 == null) goto L31;
        List r13 = CollectionsKt.filterNotNull(r12);
    L32:
        if (r13 != null) goto L34;
        r13 = CollectionsKt.emptyList();
    L34:
        List r14 = r13;
        List r15 = e10.m0().h();
        if (r15 == null) goto L37;
        r2 = CollectionsKt.filterNotNull(r15);
    L37:
        List r16 = CollectionsKt.listOf(new String[]{"auto_send_text", "open_voice_call"});
        if (r2 != null) goto L40;
        List r17 = r16;
    L42:
        return d.b(r10, r11, r14, r17, true, true);
    L40:
        r17 = r2;
        goto L42
    L31:
        r13 = null;
    L27:
        ArraysKt.toList(d.a);
        goto L28
    L22:
        r9 = null;
        goto L24
    }

    @Override // com.larus.deeplink.api.IDeeplinkService
    public final q h(Intent r10, ExternalRouteEntry r11) {
        Intrinsics.checkNotNullParameter(r10, "intent");
        Intrinsics.checkNotNullParameter(r11, "entry");
        AtomicLong r2 = com.larus.deeplink.impl.a.a;
        Intrinsics.checkNotNullParameter(r10, "intent");
        Intrinsics.checkNotNullParameter(r11, "entry");
        q r1 = com.larus.deeplink.impl.a.a(r10);
        boolean r3 = true;
        String r4 = null;
        if (r1 != null) goto L5;
        com.larus.deeplink.impl.a.C0023a r5 = null;
    L23:
        if (r5 != null) goto L26;
        return null;
    L26:
        if (r5.b == false) goto L44;
        int r12 = b.a;
        Intrinsics.checkNotNullParameter(r10, "intent");
        Uri r13 = r10.getData();
        if (r13 == null) goto L44;
        Bundle r14 = r10.getExtras();
        if (r14 == null) goto L34;
        r4 = r14.getString("come_from_login");
    L34:
        if (o0.d(r4) == true) goto L44;
        String r15 = b.a(r13);
        if (r15.length() == 0) goto L40;
        r3 = false;
    L40:
        if (r3 == true) goto L44;
        IApplog.Companion r0 = IApplog.a;
        JSONObject r6 = new JSONObject();
        r6.put("source_type", r15);
        r6.put("absolute_schema", r13.toString());
        r6.put("schema_host", r13.getHost());
        r6.put("schema_path", r13.getPath());
        r6.put("schema_queries", String.valueOf(UriProtector.getQueryParameterNames(r13)));
        Unit r16 = Unit.INSTANCE;
        r0.reportEvent("rd_external_schema_will_handle", r6);
    L44:
        return r5.a;
    L5:
        boolean r7 = !r10.getBooleanExtra("com.larus.deeplink.extra.ROUTE_SESSION_STARTED", false);
        r10.putExtra("com.larus.deeplink.extra.ROUTE_SESSION_STARTED", true);
        int r17 = com.larus.deeplink.impl.a.b.a[r11.ordinal()];
        if (r17 != 1) goto L8;
    L21:
        ExternalRouteLaunchMode r18 = ExternalRouteLaunchMode.HOT;
    L22:
        String r8 = r1.a;
        String r9 = r1.c;
        Intrinsics.checkNotNullParameter(r8, "id");
        Intrinsics.checkNotNullParameter(r18, "launchMode");
        Intrinsics.checkNotNullParameter(r9, "schema");
        r5 = new com.larus.deeplink.impl.a.C0023a(new q(r8, r18, r9), r7);
        goto L23
    L8:
        if (r17 == 2) goto L21;
        if (r17 != 3) goto L20;
        int r110 = i.a.b();
        if (r110 == 0) goto L18;
        if (r110 == 1) goto L17;
        if (r110 == 2) goto L16;
        r18 = ExternalRouteLaunchMode.UNKNOWN;
        goto L22
    L16:
        r18 = ExternalRouteLaunchMode.WARM;
        goto L22
    L17:
        r18 = ExternalRouteLaunchMode.HOT;
        goto L22
    L18:
        r18 = ExternalRouteLaunchMode.COLD;
        goto L22
    L20:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.deeplink.api.IDeeplinkService
    public final boolean i(Context r9, Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        String[] r1 = d.a;
        Intrinsics.checkNotNullParameter(r10, "uri");
        FLogger.a.i("DeeplinkGate", "routerFromXbridge: " + r10);
        e10 r0 = e10.a;
        List r2 = e10.m0().m();
        List r3 = null;
        if (r2 == null) goto L5;
        List r4 = CollectionsKt.filterNotNull(r2);
    L7:
        if (e10.m0().e() == false) goto L10;
        if (r4 == null) goto L10;
    L11:
        List r5 = e10.m0().l();
        if (r5 == null) goto L14;
        r3 = CollectionsKt.filterNotNull(r5);
    L14:
        if (r3 != null) goto L17;
        r3 = CollectionsKt.emptyList();
    L17:
        return d.b(r9, r10, r3, null, false, false);
    L10:
        ArraysKt.toList(d.a);
        goto L11
    L5:
        r4 = null;
        goto L7
    }
}
