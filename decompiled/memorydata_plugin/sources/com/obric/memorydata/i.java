package com.obric.memorydata;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.common.utility.NetworkUtils;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.memory.x;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.utils.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/ShortcutMemoryManager;", "", "<init>", "()V", "TAG", "", "generateMemory", "", "productType", "", "bitmap", "Landroid/graphics/Bitmap;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, ObricMemoryConstants.KEY_PACKAGE_NAME, "realBeginTs", "", "sourceImageInfo", "Lcom/obric/memorydata/memory/memoryentity/MemorySourceImageInfo;", "logContext", "Lcom/obric/memorydata/middleware/api/logging/LogContext;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f9874a = null;

    static {
        f9874a = new i();
    }

    private i() {
    }

    private static final Unit a(int r1, com.obric.memorydata.middleware.api.logging.g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$errorTrace");
        r2.a("product_type", Integer.valueOf(r1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void a(i r10, int r11, Bitmap r12, String r13, String r14, long r15, com.obric.memorydata.memory.memoryentity.e r17, com.obric.memorydata.middleware.api.logging.e r18, int r19, Object r20) {
        if ((r19 & 32) == 0) goto L5;
        com.obric.memorydata.memory.memoryentity.e r8 = null;
    L6:
        r10.a(r11, r12, r13, r14, r15, r8, r18);
        return;
    L5:
        r8 = r17;
        goto L6
    }

    private static final Unit b(int r1, com.obric.memorydata.middleware.api.logging.g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$errorTrace");
        r2.a("product_type", Integer.valueOf(r1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$R725QmmwjuzOVP657KhBIw_7mtY(int r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$l76oFrp5W6h9zgrbBky9MNeA25Y(int r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return b(r0, r1);
    }

    public final void a(final int r31, Bitmap r32, String r33, String r34, long r35, com.obric.memorydata.memory.memoryentity.e r37, com.obric.memorydata.middleware.api.logging.e r38) {
        Intrinsics.checkNotNullParameter(r38, "logContext");
        if (r32 != null) goto L10;
        if (r31 != 9) goto L6;
    L7:
        o.a((o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, o.class, "com.obric.memorydata.plugin"), "系统主动记忆因截图为空而终止", "input_prepare_failed", "screenshot_unavailable", null, com.obric.memorydata.middleware.api.logging.e.a(r38, null, null, "route", 3, null), new $$Lambda$i$R725QmmwjuzOVP657KhBIw_7mtY(r31), 8, null);
        x.f11587a.a();
        return;
    L6:
        if (r31 == 10) goto L7;
    L10:
        if (Intrinsics.areEqual(DeviceInfoState.INSTANCE.getDeviceModel(), "Genesis-R") == true) goto L12;
    L18:
        ComponentName r17 = ba.b();
        if (r34 != null) goto L23;
        if (r17 == null) goto L22;
        String r2 = r17.getPackageName();
    L24:
        if (r2 == null) goto L32;
        com.obric.memorydata.utils.c r3 = com.obric.memorydata.utils.c.f13193a;
        if (r17 == null) goto L28;
        String r6 = r17.getClassName();
    L29:
        com.obric.memorydata.utils.c.a r4 = r3.b(r2, r6);
        if (r4 == null) goto L32;
        String r5 = r4.a();
    L34:
        if (r2 != null) goto L36;
        r2 = "";
    L36:
        if (r5 != null) goto L38;
        r5 = "";
    L38:
        if (r33 == null) goto L40;
        String r22 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r33, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L41:
        if (r37 == null) goto L43;
        float r0 = 1.0f;
    L44:
        com.obric.memorydata.memory.e.a.b.a(com.obric.memorydata.memory.e.a.f10116b.a(0), (com.obric.memorydata.memory.e.b) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.memory.tracker.g.b(r31, false, r35), com.obric.memorydata.memory.e.b.class, "com.obric.memorydata.plugin"), new com.obric.memorydata.memory.memoryentity.f(r31, r2, r5, r32, r22, null, null, r17, null, false, null, null, null, null, null, null, r38, true, null, null, null, r37, r0, 0, 10288896, null), false, 4, null);
        return;
    L43:
        r0 = 0.5f;
        goto L44
    L40:
        r22 = null;
        goto L41
    L28:
        r6 = null;
    L32:
        r5 = null;
        goto L34
    L22:
        r2 = null;
        goto L24
    L23:
        r2 = r34;
        goto L24
    L12:
        if (NetworkUtils.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L18;
        if (r31 != 9) goto L15;
    L16:
        o.a((o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, o.class, "com.obric.memorydata.plugin"), "系统主动记忆因网络不可用而终止", "build_blocked", "network_unavailable", null, com.obric.memorydata.middleware.api.logging.e.a(r38, null, null, "route", 3, null), new $$Lambda$i$l76oFrp5W6h9zgrbBky9MNeA25Y(r31), 8, null);
        x.f11587a.b();
        return;
    L15:
        if (r31 != 8) goto L18;
        goto L16
    }
}
