package com.obric.aiagent.product.platform.api.rom;

import android.content.Context;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.feature.b.a;
import com.obric.aiagent.product.platform.impl.rom.PacificRomInfoImpl;
import com.obric.aiagent.product.platform.impl.rom.PublicRomInfoImpl;
import com.ss.android.ugc.aweme.framework.services.f;
import com.ss.android.ugc.aweme.framework.services.g;
import com.ss.android.ugc.aweme.framework.services.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0010\u001a\u00020\b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/aiagent/product/platform/api/rom/RomInfo;", "Lcom/obric/aiagent/product/platform/api/rom/IRomInfo;", "<init>", "()V", "TAG", "", "instance", "tryInit", "", "getDeviceBrand", "getDeviceModel", "getOSVersion", "getShortOSVersion", "getOSReleaseDate", "", "getOSDeviceIdFromCache", "getOSDeviceIdAsync", "callback", "Lkotlin/Function1;", "getFwkApiVersion", "useAssistantApi", "", "getRomReleaseRegion", "getRomBuildType", "isOautoModelPreinstalled", "context", "Landroid/content/Context;", "isUTRom", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RomInfo implements IRomInfo {
    public static final RomInfo INSTANCE = null;
    private static final String TAG = "RomInfo";
    private static IRomInfo instance;

    static {
        INSTANCE = new RomInfo();
    L17:
        th = move-exception;
        d.f5954a.b(TAG, "init RomInfo failed", th);
    L19:
        instance = (IRomInfo) ZeusTransformUtils.preCheckCast(f.a().a(IRomInfo.class, false), IRomInfo.class, "com.obric.memorydata.plugin");
        d.f5954a.b(TAG, "RomInfo instance: " + instance);
        return;
    L4:
        if (a.f5977b.a().e() == false) goto L25;
        f.a().a(IRomInfo.class, (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$RomInfo$mNXahUFfLBK_xENFxMbaVJPvCs.INSTANCE), g.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
    L15:
        d.f5954a.b(TAG, "bind RomInfo isOs=" + a.f5977b.a().e());     // Catch: Throwable -> L17
        goto L19
    L7:
        th = move-exception;
        d.f5954a.b(TAG, "bind PacificRomInfoImpl failed", th);     // Catch: Throwable -> L17
    L9:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L17
        goto L15
    L25:
        f.a().a(IRomInfo.class, (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$RomInfo$zxxmJweAoXxU56xQPXlqsCVQIM.INSTANCE), g.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        d.f5954a.b(TAG, "bind PublicRomInfoImpl failed", th);     // Catch: Throwable -> L17
        goto L9
    }

    private RomInfo() {
    }

    private static final Object _init_$lambda$0() {
        return new PacificRomInfoImpl();
    }

    private static final Object _init_$lambda$1() {
        return new PublicRomInfoImpl();
    }

    /* JADX INFO: renamed from: lambda$-mNXahUFfLBK_xENFxMbaVJPvCs, reason: not valid java name */
    public static /* synthetic */ Object m169lambda$mNXahUFfLBK_xENFxMbaVJPvCs() {
        return _init_$lambda$0();
    }

    /* JADX INFO: renamed from: lambda$zxxmJweAoXxU56x-QPXlqsCVQIM, reason: not valid java name */
    public static /* synthetic */ Object m170lambda$zxxmJweAoXxU56xQPXlqsCVQIM() {
        return _init_$lambda$1();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getDeviceBrand() {
        IRomInfo r0 = instance;
        if (r0 == null) goto L6;
        String r1 = r0.getDeviceBrand();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getDeviceModel() {
        IRomInfo r0 = instance;
        if (r0 == null) goto L6;
        String r1 = r0.getDeviceModel();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public int getFwkApiVersion() {
        IRomInfo r0 = instance;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getFwkApiVersion();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public void getOSDeviceIdAsync(Function1<? super String, Unit> r2) {
        Function1<? super String, Unit> r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "callback");
        IRomInfo r3 = instance;
        if (r3 == null) goto L5;
        r3.getOSDeviceIdAsync(r1);
        return;
    L5:
        r1.invoke("");
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getOSDeviceIdFromCache() {
        IRomInfo r0 = instance;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getOSDeviceIdFromCache();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public int getOSReleaseDate() {
        IRomInfo r0 = instance;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getOSReleaseDate();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getOSVersion() {
        IRomInfo r0 = instance;
        if (r0 == null) goto L6;
        String r1 = r0.getOSVersion();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getRomBuildType() {
        IRomInfo r0 = instance;
        if (r0 == null) goto L6;
        String r1 = r0.getRomBuildType();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getRomReleaseRegion() {
        IRomInfo r0 = instance;
        if (r0 == null) goto L6;
        String r1 = r0.getRomReleaseRegion();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getShortOSVersion() {
        IRomInfo r0 = instance;
        if (r0 == null) goto L6;
        String r1 = r0.getShortOSVersion();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean isOautoModelPreinstalled(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        IRomInfo r3 = instance;
        if (r3 != null) goto L7;
        return false;
    L7:
        return r3.isOautoModelPreinstalled(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean isUTRom() {
        IRomInfo r0 = instance;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isUTRom();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public void tryInit() {
        IRomInfo r0 = instance;
        if (r0 == null) goto L6;
        r0.tryInit();
        return;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean useAssistantApi() {
        IRomInfo r0 = instance;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.useAssistantApi();
    }
}
