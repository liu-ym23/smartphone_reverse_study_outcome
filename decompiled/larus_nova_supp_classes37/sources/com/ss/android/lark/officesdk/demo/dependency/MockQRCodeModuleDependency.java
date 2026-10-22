package com.ss.android.lark.officesdk.demo.dependency;

import android.content.Context;
import android.net.Uri;
import android.util.Patterns;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.biz.core.api.IQRCodeScanResultHandler;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@ClaymoreImpl(a2c.a.class)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 '2\u00020\u0001:\u0003%&'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u001d\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u000fH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006("}, d2 = {"Lcom/ss/android/lark/officesdk/demo/dependency/MockQRCodeModuleDependency;", "Lcom/ss/android/lark/qrcode/dependency/IQRCodeModuleDependency;", "<init>", "()V", "processStartTime", "", "openFeishuQRCodeHandler", "Lcom/ss/android/lark/officesdk/qrcode/impl/OpenFeishuQRCodeHandlerImpl;", "getOpenFeishuQRCodeHandler", "()Lcom/ss/android/lark/officesdk/qrcode/impl/OpenFeishuQRCodeHandlerImpl;", "openFeishuQRCodeHandler$delegate", "Lkotlin/Lazy;", "otherOpenCamera", "", "isInMeeting", "", "isFeatureGatingEnable", "key", "", "canOpenAppLink", "result", "context", "Landroid/content/Context;", "source", "", "canOpenAppBrand", "schema", "isMatchUrl", "preloadLittleApp", "openInviteExternalPage", "from", "isMyQrcode", "getQRCodeHandlers", "", "Lcom/ss/android/lark/biz/core/api/IQRCodeScanResultHandler;", "getQRCodeInterceptHandlers", "getProcessStartTime", "OfficeSDKQRCodeHandler", "WebUrlQRCodeHandler", "Companion", "officesdk-assemble_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MockQRCodeModuleDependency implements a2c.a {
    private static final a Companion = null;
    private static final String MICRO_APP_HOST = "microapp";
    private static final String SCHEME_HTTP = "http";
    private static final String SCHEME_HTTPS = "https";
    private static final String TAG = "MockQRCodeModuleDependency";
    private final Lazy openFeishuQRCodeHandler$delegate;
    private final long processStartTime;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements IQRCodeScanResultHandler {
        public b() {
        }

        public final boolean c(String r5, dxa.b r6) {
            Intrinsics.checkNotNullParameter(r6, "context");
            String r0 = null;
            if (r5 == null) goto L5;
            String r1 = StringsKt.trim(r5).toString();
        L6:
            if (r1 != null) goto L9;
            r1 = "";
        L9:
            if (r1.length() != 0) goto L11;
            boolean r2 = true;
        L12:
            if (r2 == false) goto L15;
            return false;
        L15:
            if (Patterns.WEB_URL.matcher(r1).matches() == true) goto L17;
            return false;
        L17:
            Uri r3 = f.a(r1);
            if (r3 != null) goto L20;
            return false;
        L20:
            String r4 = r3.getScheme();
            if (r4 == null) goto L24;
            r0 = r4.toLowerCase(Locale.ROOT);
        L24:
            if (Intrinsics.areEqual(r0, MockQRCodeModuleDependency.SCHEME_HTTP) == false) goto L26;
        L28:
            int r7 = com.ss.android.lark.router.c.a;
            return com.ss.android.lark.router.c.b(r6.getContext(), r5);
        L26:
            if (Intrinsics.areEqual(r0, MockQRCodeModuleDependency.SCHEME_HTTPS) == true) goto L28;
            return false;
        L11:
            r2 = false;
            goto L12
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // a2c.a
    public List<IQRCodeScanResultHandler> getQRCodeHandlers() {
        return CollectionsKt.arrayListOf(new b[]{new b()});
    }

    @Override // a2c.a
    public boolean isFeatureGatingEnable(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return false;
    }

    @Override // a2c.a
    public boolean isInMeeting() {
        return false;
    }

    private final pwb.a getOpenFeishuQRCodeHandler() {
        return (pwb.a) this.openFeishuQRCodeHandler$delegate.getValue();
    }

    @Override // a2c.a
    public void otherOpenCamera() {
        Log.i(TAG, "otherOpenCamera is ignored in OfficeSDK base-mock");
    }

    public MockQRCodeModuleDependency() {
        this.processStartTime = System.currentTimeMillis();
        this.openFeishuQRCodeHandler$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, MockQRCodeModuleDependency$openFeishuQRCodeHandler$2.INSTANCE);
    }

    @Override // a2c.a
    public List<IQRCodeScanResultHandler> getQRCodeInterceptHandlers() {
        return CollectionsKt.emptyList();
    }

    public long getProcessStartTime() {
        return this.processStartTime;
    }

    @Override // a2c.a
    public boolean canOpenAppBrand(String r3) {
        Intrinsics.checkNotNullParameter(r3, "schema");
        if (StringsKt.isBlank(r3) == false) goto L5;
        return false;
    L5:
        Uri r4 = f.a(StringsKt.trim(r3).toString());
        if (r4 != null) goto L9;
        return false;
    L9:
        return StringsKt.equals(r4.getHost(), "microapp", true);
    }

    @Override // a2c.a
    public boolean isMatchUrl(String r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        String r4 = StringsKt.trim(r3).toString();
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return false;
    L9:
        return Patterns.WEB_URL.matcher(r4).matches();
    L5:
        r0 = false;
        goto L6
    }

    public void preloadLittleApp(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Log.i(TAG, "preloadLittleApp is skipped in OfficeSDK base-mock");
    }

    @Override // a2c.a
    public boolean canOpenAppLink(String r2, Context r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (r2 == null) goto L5;
        String r5 = StringsKt.trim(r2).toString();
    L6:
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        if (r5.length() != 0) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L14;
        return false;
    L14:
        Uri r7 = f.a(r5);
        if (r7 != null) goto L27;
        return false;
    L27:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L19
        Object r8 = Result.constructor-impl(Boolean.valueOf(ova.f.m().h(r3, r7)));     // Catch: Throwable -> L19
    L21:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L26;
        Log.e(TAG, "canOpenAppLink failed: ".concat(r5), r9);
        r8 = Boolean.FALSE;
    L26:
        return ((Boolean) r8).booleanValue();
    L19:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L11:
        r6 = false;
        goto L12
    L5:
        r5 = null;
        goto L6
    }

    @Override // a2c.a
    public void openInviteExternalPage(Context r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "from");
        Log.i(TAG, "openInviteExternalPage is not available in OfficeSDK base-mock, from: " + r2);
    }
}
