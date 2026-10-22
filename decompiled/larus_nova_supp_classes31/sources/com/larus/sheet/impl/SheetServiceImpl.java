package com.larus.sheet.impl;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.router.SmartRouter;
import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.larus.office.OfficeInputParam;
import com.larus.sheet.api.ISheetService;
import com.larus.sheet.sdk.api.ISheetSdkProxyService;
import com.larus.sheet.sdk.api.ISheetSdkServiceV2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import va8.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010\b\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\tJ \u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016JO\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001c2!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00070\u001eH\u0096@¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010&\u001a\u00020\u0007H\u0016J\b\u0010'\u001a\u00020(H\u0016J\u0018\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u0018\u0010.\u001a\u00020\u00072\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u000f\u0010/\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0002\u00101J\"\u00102\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00103\u001a\u00020\u00102\b\u00104\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0010H\u0016J\u0016\u00106\u001a\u00020\u00052\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001008H\u0002J\u0010\u00109\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010:\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010;\u001a\u00020<2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/larus/sheet/impl/SheetServiceImpl;", "Lcom/larus/sheet/api/ISheetService;", "<init>", "()V", "isColdLaunch", "", "preloadWebViewIfNeeded", "", "initSdkIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openSheet", "context", "Landroid/content/Context;", "params", "Landroid/os/Bundle;", "page", "", "tryPrefetchData", "openSheetAndChat", "switchConversationParams", "Lcom/larus/bmhome/chat/resp/SwitchConversationParams;", "triggerInnerNotification", "inAppBannerNotify", "Lcom/larus/im/bean/InAppBannerNotify;", "setSheetPermission", "slidesToken", "public", "onSuccess", "Lkotlin/Function0;", "onError", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSheetPermission", "getSheetPermissionLiveData", "Landroidx/lifecycle/LiveData;", "clearReference", "getSheetTrackInfo", "Lorg/json/JSONObject;", "showSheetDownloadFragment", "fragment", "Landroidx/fragment/app/Fragment;", "downloadParams", "Lcom/larus/share/bean/SheetDownloadParams;", "showSheetDownloadSimple", "getFloatChatShowPercent", "", "()Ljava/lang/Integer;", "doubaoSheetUrlJump", "url", "enterMethod", "isDoubaoSheetUrl", "pathValid", "path", "", "tryPreloadSheetDataIfSdkReady", "tryPrefetchSheetDataIfSdkReady", "buildSheetOfficeInputParam", "Lcom/larus/office/OfficeInputParam;", "resourceId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SheetServiceImpl implements ISheetService {
    public static final /* synthetic */ int b = 0;
    public boolean a;

    public static final class a {
    }

    public static final class b implements by7.e {
        public final /* synthetic */ String a;

        public final by7.e parentTrackNode() {
            return by7.i.c(this);
        }

        public final by7.e referrerTrackNode() {
            return by7.e.a.a(this);
        }

        public b(String r1) {
            this.a = r1;
        }

        public final void fillTrackParams(TrackParams r3) {
            Intrinsics.checkNotNullParameter(r3, "params");
            r3.put("current_page", this.a);
        }
    }

    static {
    }

    @Override // com.larus.sheet.api.ISheetService
    public final void clearReference() {
        ISheetSdkProxyService r0 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r0 == null) goto L6;
        r0.clearReference();
        return;
    }

    @Override // com.larus.sheet.api.ISheetService
    public final JSONObject f() {
        AppCompatActivity r0 = AppHost.a.a().getCurrentActivity();
        SheetFragment r2 = null;
        if ((r0 instanceof AppCompatActivity) == false) goto L5;
        AppCompatActivity r1 = r0;
    L7:
        if ((r1 instanceof SheetActivity) == false) goto L11;
        Fragment r3 = ((SheetActivity) r1).getSupportFragmentManager().findFragmentByTag("aisheet_detail");
        if ((r3 instanceof SheetFragment) == false) goto L11;
        r2 = (SheetFragment) r3;
    L11:
        if (r2 == null) goto L14;
        return r2.t9();
    L14:
        return new JSONObject();
    L5:
        r1 = null;
        goto L7
    }

    public SheetServiceImpl() {
        this.a = true;
    }

    @Override // com.larus.sheet.api.ISheetService
    public final Integer A() {
        Fragment r0 = com.larus.sheet.impl.chat.a.a();
        if (r0 == null) goto L7;
        t1a.b r1 = s1a.a.g(r0);
        if (r1 == null) goto L7;
        g0 r2 = (g0) r1.getAbility(g0.class);
    L8:
        if (r2 != null) goto L10;
        return null;
    L10:
        return Integer.valueOf(r2.Gt());
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.larus.sheet.api.ISheetService
    public final Object a(Continuation<? super Unit> r3) {
        ISheetSdkServiceV2 r0 = (ISheetSdkServiceV2) ServiceManager.get().getService(ISheetSdkServiceV2.class);
        if (r0 == null) goto L10;
        Object r4 = r0.a(r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r4;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    @Override // com.larus.sheet.api.ISheetService
    public final boolean c(final Bundle r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        String r1 = r6.getString("resource_id");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L21;
        FLogger.a.i("SheetServiceImpl", "tryPrefetchData skipped, resourceId is empty");
        return false;
    L21:
        final String r0 = r6.getString("resource_id");     // Catch: Exception -> L18
        if (r0 != null) goto L16;
        r0 = "";
    L16:
        return com.larus.office.base.service.d.a("SheetServiceImpl", r0, new x(this, r6, r0));
    L18:
        e = move-exception;
        FLogger.a.e("SheetServiceImpl", "tryPrefetchSheetDataIfSdkReady, e = " + e);
        return false;
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L10
    }

    @Override // com.larus.sheet.api.ISheetService
    public final MutableLiveData g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "slidesToken");
        HashMap<String, MutableLiveData<Boolean>> r0 = com.larus.sheet.operation.f.a;
        Intrinsics.checkNotNullParameter(r2, "sheetToken");
        return com.larus.sheet.operation.f.b(r2);
    }

    @Override // com.larus.sheet.api.ISheetService
    public final boolean h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "slidesToken");
        HashMap<String, MutableLiveData<Boolean>> r0 = com.larus.sheet.operation.f.a;
        Intrinsics.checkNotNullParameter(r2, "sheetToken");
        Intrinsics.checkNotNullParameter(r2, "sheetToken");
        return Intrinsics.areEqual(com.larus.sheet.operation.f.b(r2).getValue(), Boolean.TRUE);
    }

    public static OfficeInputParam i(Bundle r4, String r5) {
        OfficeInputParam r0 = new OfficeInputParam();
        r0.setResourceId(r5);
        String r6 = r4.getString("sheets_token");
        String r1 = "";
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r0.setSlidesToken(r6);
        r0.setResourceType(12);
        r0.setResourceVersion(r4.getInt("resource_version", -1));
        String r7 = r4.getString("conversation_id");
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        r0.setConversationId(r7);
        String r8 = r4.getString("artifact_meta_id");
        if (r8 != null) goto L11;
        r8 = "";
    L11:
        r0.setArtifactMetaId(r8);
        String r9 = r4.getString("enter_method");
        if (r9 != null) goto L14;
        r9 = "";
    L14:
        r0.setEnterMethod(r9);
        r0.setClickTimestamp(r4.getLong("click_timestamp", System.currentTimeMillis()));
        String r10 = r4.getString("enter_from", "");
        if (r10 != null) goto L17;
        r10 = "";
    L17:
        r0.setEnterFrom(r10);
        String r11 = r4.getString("sheet");
        if (r11 == null) goto L21;
        r1 = r11;
    L21:
        r0.setSheet(r1);
        r0.setObjType(3);
        r0.setSourceUrlForParams(r4.getString("key_source_url_for_params"));
        return r0;
    }

    @Override // com.larus.sheet.api.ISheetService
    public final void b(Fragment r2, kw9.e r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "downloadParams");
        HashMap<String, MutableLiveData<Boolean>> r0 = com.larus.sheet.operation.f.a;
        com.larus.sheet.operation.f.f(r2, r3);
    }

    @Override // com.larus.sheet.api.ISheetService
    public final void d(Context r8, final Bundle r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r10, "page");
        FLogger.a.i("SheetServiceImpl", "Open sheet: " + r9.getString("sheets_token"));
        b r0 = new b(r10);
        r9.putBoolean("is_cold_start", this.a);
        boolean r3 = false;
        if (this.a == false) goto L14;
        this.a = false;
    L14:
        final String r1 = r9.getString("resource_id");     // Catch: Exception -> L10
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        r3 = com.larus.office.base.service.d.b("SheetServiceImpl", r1, new w(this, r9, r1));     // Catch: Exception -> L10
    L12:
        r9.putBoolean("key_office_preloaded", r3);
        com.bytedance.router.i r11 = SmartRouter.buildRoute(r8, "//flow/sheet_detail");
        by7.h.k(r9, r0);
        r9.putString("argPreviousPage", r10);
        r11.c.putExtras(r9);
        r11.d = 2130772401;
        r11.e = 2130772399;
        r11.d();
        return;
    L10:
        e = move-exception;
        FLogger.a.e("SheetServiceImpl", "tryPreloadSheetDataIfSdkReady, e = " + e);
        goto L12
    }

    @Override // com.larus.sheet.api.ISheetService
    public final Unit e(String r2, boolean r3, Function0 r4, Function1 r5) {
        HashMap<String, MutableLiveData<Boolean>> r0 = com.larus.sheet.operation.f.a;
        com.larus.sheet.operation.f.e(r2, r3, r4, r5);
        return Unit.INSTANCE;
    }
}
