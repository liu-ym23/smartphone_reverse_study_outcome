package g4;

import ai.p;
import com.bytedance.android.anniex.solutions.card.AirActionConstant$AirSolutionLifecycle;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.TemplateData;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import l4.b;
import l4.e;
import ug.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnnieXLynxView f17029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f17030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f17031c;
    public e d;
    public volatile boolean e;

    public a(AnnieXLynxView r5, com.bytedance.sdk.xbridge.cn.platform.lynx.a r10) {
        Intrinsics.checkNotNullParameter(r5, "lynxView");
        Intrinsics.checkNotNullParameter(r10, "lynxBDXBridge");
        this.f17029a = r5;
        this.f17030b = new d(5);
        this.f17031c = new p(r5, r10);
    }

    public final void a(AirActionConstant$AirSolutionLifecycle r5) {
        Intrinsics.checkNotNullParameter(r5, "lifecycle");
        k5.d.e(this.f17029a, this);
        int r10 = r5.ordinal();
        if (r10 != 0) goto L5;
        e r11 = this.d;
        if (r11 == null) goto L19;
        b r12 = r11.e();
    L20:
        if (r12 == null) goto L23;
        this.f17031c.l(null, r12, this.f17030b);
        return;
    L23:
        return;
    L19:
        r12 = null;
        goto L20
    L5:
        if (r10 != 1) goto L7;
        e r13 = this.d;
        if (r13 == null) goto L19;
        r12 = r13.d();
        goto L20
    L7:
        if (r10 != 2) goto L12;
        e r14 = this.d;
        if (r14 == null) goto L19;
        r12 = r14.f();
        goto L20
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final void b(TemplateData r10, boolean r11) {
        if (r10 != null) goto L5;
    L7:
        HashMap r5 = null;
        if (r10 != null) goto L10;
    L18:
        HashMap r12 = null;
    L19:
        if (r12 == null) goto L21;
        r5 = r12;
    L21:
        if (r5 == null) goto L26;
        if (r11 == false) goto L24;
        ((LinkedHashMap) ((i4.a) this.f17030b.d).f17502b).clear();
    L24:
        ((LinkedHashMap) ((i4.a) this.f17030b.d).f17502b).putAll(r5);
        return;
    L26:
        return;
    L10:
        if (LynxEnv.inst().isNativeLibraryLoaded() == true) goto L12;
        LynxLog.b(3, "LynxTemplateData", "toMap failed since env not ready.");
        goto L18
    L12:
        r10.k();
        if (r10.f10054a != 0) goto L15;
        LynxLog.b(3, "LynxTemplateData", "toMap failed since mNativeData == 0.");
        goto L18
    L15:
        Object r13 = TemplateData.nativeGetData(r10.f10054a);
        r12 = new HashMap();
        if ((r13 instanceof Map) == false) goto L19;
        r12.putAll((Map) r13);
        goto L19
    L5:
        if (r10.f10054a != 0) goto L7;
    }
}
