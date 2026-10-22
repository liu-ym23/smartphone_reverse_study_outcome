package eq;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f16854a;

    public a(Looper r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "looper");
        super(r5);
        this.f16854a = r10;
        if (r10 == false) goto L9;
        Intrinsics.checkNotNullParameter("MetricsHandler", "tag");
        Intrinsics.checkNotNullParameter("WorkHandler onCreated", "msg");
        org.koin.core.a r11 = su.a.f22013b;
        if (r11 == null) goto L8;
        ((ju.b) r11.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).d("MetricsHandler", "WorkHandler onCreated");
        return;
    L8:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r13) {
        Intrinsics.checkNotNullParameter(r13, "msg");
        int r5 = r13.what;
        if (r5 != 2) goto L5;
        Object r14 = r13.obj;
        if ((r14 instanceof iq.a) == false) goto L18;
        iq.a r15 = (iq.a) r14;
    L20:
        if (r15 == null) goto L50;
        JSONObject r10 = r15.f18210b;     // Catch: Exception -> L27
        MatrixTeaManager.Companion.getClass();     // Catch: Exception -> L27
        if (MatrixTeaManager.access$getInstance$cp() == null) goto L39;
        MatrixTeaManager r11 = MatrixTeaManager.access$getInstance$cp();     // Catch: Exception -> L27
        Intrinsics.checkNotNull(r11);     // Catch: Exception -> L27
        String r12 = r11.getDeviceId();     // Catch: Exception -> L27
        if (TextUtils.isEmpty(r12) == false) goto L29;
        r12 = "0";
    L29:
        r10.put("did", r12);     // Catch: Exception -> L27
        boolean r16 = this.f16854a;     // Catch: Exception -> L27
        String r17 = r15.f18209a;
        if (r16 == false) goto L37;
        String r18 = "onEvent:" + r17 + ", eventData:" + r10;     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter("MetricsHandler", "tag");     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter(r18, "msg");     // Catch: Exception -> L27
        org.koin.core.a r19 = su.a.f22013b;     // Catch: Exception -> L27
        if (r19 == null) goto L36;
        ((ju.b) r19.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).d("MetricsHandler", r18);     // Catch: Exception -> L27
        goto L37
    L36:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Exception -> L27
    L37:
        r11.onEvent("flow_" + r17, r10);     // Catch: Exception -> L27
        return;
    L39:
        throw new IllegalStateException("MatrixTeaManager还没初始化，请先调用init方法进行初始化~~~");     // Catch: Exception -> L27
    L27:
        e = move-exception;
        Intrinsics.checkNotNullParameter("MetricsHandler", "tag");
        Intrinsics.checkNotNullParameter("onEvent error", "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r20 = su.a.f22013b;
        if (r20 == null) goto L45;
        ((ju.b) r20.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("MetricsHandler", "onEvent error", e);
        return;
    L45:
        throw new IllegalStateException("KoinApplication has not been started");
    L50:
        return;
    L18:
        r15 = null;
        goto L20
    L5:
        if (r5 == 4) goto L8;
        return;
    L8:
        if (this.f16854a == false) goto L14;
        Intrinsics.checkNotNullParameter("MetricsHandler", "tag");
        Intrinsics.checkNotNullParameter("Handler onExit...", "msg");
        org.koin.core.a r110 = su.a.f22013b;
        if (r110 == null) goto L13;
        ((ju.b) r110.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MetricsHandler", "Handler onExit...");
        goto L14
    L13:
        throw new IllegalStateException("KoinApplication has not been started");
    L14:
        b.d = null;
    }
}
