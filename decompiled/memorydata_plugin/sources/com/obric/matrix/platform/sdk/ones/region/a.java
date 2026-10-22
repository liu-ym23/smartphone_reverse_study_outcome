package com.obric.matrix.platform.sdk.ones.region;

import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.product.platform.api.rom.IRomInfoKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/region/RegionUtil;", "", "()V", "REGION_KEY", "", "TARGET_NON_EEA", "getRegion", "Lcom/obric/matrix/platform/sdk/ones/region/Region;", "getSystemProperty", "key", "isCN", "", "isHK", "isNonEeaRegion", EventBody.KEY_VALUE, "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8122a = null;

    static {
        f8122a = new a();
    }

    private a() {
    }

    private final boolean a(String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        return false;
    L11:
        if (StringsKt.equals(r4, IRomInfoKt.REGION_HK, true) == true) goto L13;
        return false;
    L13:
        return true;
    L8:
        r0 = false;
        goto L9
    }

    private final String b(String r9) {
        Object[] r2 = {r9, ""};     // Catch: Exception -> L10
        String r10 = null;
        Object r1 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.memorydata.plugin").getMethod("get", new Class[]{String.class, String.class}).invoke(null, r2);     // Catch: Exception -> L10
        if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L6;
        r10 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L10
    L6:
        if (r10 != null) goto L9;
        return "";
    L9:
        return r10;
    L14:
        return "";
    }

    public final Region a() {
        if (a(b("ro.vendor.feature.zte_feature_abroad")) == false) goto L6;
        return Region.HK;
    L6:
        return Region.CN;
    }

    public final boolean b() {
        if (a() != Region.CN) goto L5;
        return true;
    L5:
        return false;
    }
}
