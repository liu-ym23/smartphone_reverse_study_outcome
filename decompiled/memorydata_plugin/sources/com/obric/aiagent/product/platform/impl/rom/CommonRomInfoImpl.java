package com.obric.aiagent.product.platform.impl.rom;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.a.a;
import com.obric.aiagent.product.a.b;
import com.obric.aiagent.product.a.c;
import com.obric.aiagent.product.a.e;
import com.obric.aiagent.product.platform.api.rom.IRomInfo;
import com.obric.aiagent.product.platform.api.rom.IRomInfoKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u000e\u001a\u00020\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0010H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016¨\u0006\u001b"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/rom/CommonRomInfoImpl;", "Lcom/obric/aiagent/product/platform/api/rom/IRomInfo;", "<init>", "()V", "tryInit", "", "getDeviceBrand", "", "getDeviceModel", "getOSVersion", "getShortOSVersion", "getOSReleaseDate", "", "getOSDeviceIdFromCache", "getOSDeviceIdAsync", "callback", "Lkotlin/Function1;", "getFwkApiVersion", "useAssistantApi", "", "getRomReleaseRegion", "getRomBuildType", "isOautoModelPreinstalled", "context", "Landroid/content/Context;", "isUTRom", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CommonRomInfoImpl implements IRomInfo {
    private static final String AIKERNEL_PACKAGE_NAME = "com.obric.aikernel";
    private static final long AIKERNEL_PREINSTALLED_MIN_VERSION_CODE = 500010300;
    private static final Companion Companion = null;
    private static final String TAG = "CommonRomInfoImpl";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/rom/CommonRomInfoImpl$Companion;", "", "<init>", "()V", "TAG", "", "AIKERNEL_PACKAGE_NAME", "AIKERNEL_PREINSTALLED_MIN_VERSION_CODE", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CommonRomInfoImpl() {
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getDeviceBrand() {
        String r1 = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(r1, "BRAND");
        return r1;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getDeviceModel() {
        String r1 = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(r1, "MODEL");
        return r1;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public int getFwkApiVersion() {
        return a.f5964a.c();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public void getOSDeviceIdAsync(Function1<? super String, Unit> r2) {
        Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "callback");
        r1.invoke("");
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getOSDeviceIdFromCache() {
        return null;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public int getOSReleaseDate() {
        Long.parseLong(c.f5967a.a("ro.build.date.utc", "0"));
        int r5 = e.f5973a.a(Build.TIME);
        Integer r0 = e.f5973a.a(c.f5967a.a("ro.build.date", "0"));
        d.f5954a.b(TAG, "getOSReleaseDate: time " + Build.TIME + ", date " + r5 + ", data2 " + r0 + ' ');
        if (r0 != null) goto L5;
        return r5;
    L5:
        return r0.intValue();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getOSVersion() {
        String r1 = Build.VERSION.INCREMENTAL;
        Intrinsics.checkNotNullExpressionValue(r1, "INCREMENTAL");
        return r1;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getRomBuildType() {
        String r4 = c.f5967a.a("ro.build.type", "unknown");
        if (Intrinsics.areEqual(c.f5967a.a("ro.debuggable", "0"), "1") == false) goto L5;
        String r0 = "root";
    L6:
        d.f5954a.b(TAG, "getRomBuildType: buildType " + r4 + ", isRoot " + r0);
        return r4 + r0;
    L5:
        r0 = "";
        goto L6
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getRomReleaseRegion() {
        return c.f5967a.a("ro.vendor.feature.zte_feature_abroad", IRomInfoKt.REGION_CN);
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getShortOSVersion() {
        String r4 = Build.VERSION.INCREMENTAL;
        b r0 = b.f5965a;
        Intrinsics.checkNotNull(r4);
        String r1 = r0.c(r4);
        d.f5954a.b(TAG, "getShortOSVersion: incrementalVersion " + r4 + ", shortVersion " + r1);
        return r1;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean isOautoModelPreinstalled(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "context");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L23
        PackageInfo r11 = r10.getPackageManager().getPackageInfo("com.obric.aikernel", 0);     // Catch: Throwable -> L23
        boolean r3 = true;
        if ((r11.applicationInfo.flags & 1) == 0) goto L6;
    L9:
        boolean r4 = true;
    L10:
        if (r4 == true) goto L14;
        d.f5954a.b(TAG, "isOautoModelPreinstalled: package flags=" + r11.applicationInfo.flags);     // Catch: Throwable -> L23
        return false;
    L14:
        if (Build.VERSION.SDK_INT < 28) goto L16;
        long r5 = r11.getLongVersionCode();     // Catch: Throwable -> L23
    L18:
        if (r5 >= AIKERNEL_PREINSTALLED_MIN_VERSION_CODE) goto L21;
        r3 = false;
    L21:
        d.f5954a.b(TAG, "isOautoModelPreinstalled: package=com.obric.aikernel, versionCode=" + r5 + ", isPreinstalled=" + r3);     // Catch: Throwable -> L23
        Object r12 = Result.m1421constructorimpl(Boolean.valueOf(r3));     // Catch: Throwable -> L23
    L25:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r12);
        if (r6 == null) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, PackageManager.NameNotFoundException.class) == false) goto L31;
        d.f5954a.b(TAG, "isOautoModelPreinstalled: package com.obric.aikernel not found");
    L32:
        r12 = false;
        goto L34
    L31:
        d.f5954a.b(TAG, "isOautoModelPreinstalled failed", r6);
    L34:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L16:
        r5 = r11.versionCode;     // Catch: Throwable -> L23
        goto L18
    L6:
        if ((r11.applicationInfo.flags & 128) != 0) goto L9;
        r4 = false;
    L23:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L25
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean isUTRom() {
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public void tryInit() {
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean useAssistantApi() {
        return a.f5964a.a();
    }
}
