package j4;

import ai.p;
import android.view.View;
import com.bytedance.sdk.xbridge.cn.platform.lynx.c;
import com.bytedance.sdk.xbridge.cn.protocol.e;
import com.lynx.tasm.LynxView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ug.d;
import x4.f;
import x4.g;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.sdk.xbridge.cn.platform.lynx.b f18232c;
    public final /* synthetic */ d d;
    public final /* synthetic */ p e;

    public a(com.bytedance.sdk.xbridge.cn.platform.lynx.b r5, d r10, p r11) {
        this.f18232c = r5;
        this.d = r10;
        this.e = r11;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall<kotlin.Any>");
        super(r5);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.e
    public final JSONObject a() {
        return new JSONObject();
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.e
    public final void b(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Map r11 = (Map) r10;
        if (Intrinsics.areEqual(r11.get("code"), 1) == true) goto L13;
        Object r5 = r11.get("__jsb2__data__");
        if ((r5 instanceof JSONObject) == false) goto L7;
        JSONObject r12 = (JSONObject) r5;
    L8:
        boolean r13 = false;
        if (r12 == null) goto L11;
        boolean r14 = Intrinsics.areEqual(r12.get("code"), 1);
    L12:
        if (r14 == true) goto L13;
    L14:
        com.bytedance.sdk.xbridge.cn.platform.lynx.b r15 = this.f18232c;
        d r16 = this.d;
        if (r13 == false) goto L19;
        Intrinsics.checkNotNullParameter(r11, "result");
        ((ConcurrentHashMap) ((i4.a) ((d) r16.f22357b).d).d).put((String) r16.d, r11);
        l4.b r17 = (l4.b) r16.f22358c;
        if (r17 == null) goto L20;
        ((p) r16.e).l((Map) r16.f, r17, (d) r16.f22357b);
    L20:
        c r18 = ((com.bytedance.sdk.xbridge.cn.platform.lynx.a) this.e.f288c).t();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall<kotlin.Any>");
        LynxView r19 = (LynxView) ((View) r18.e.get());
        if (r19 == null) goto L35;
        int r20 = r15.f938k;
        String r21 = r15.f932a;
        if (r20 != 1) goto L26;
        com.bytedance.android.monitorV2.lynx.d r22 = com.bytedance.android.monitorV2.lynx.d.f3638a;
        g r23 = new g();
        r23.f22971b = r21;
        r23.f22972c = System.currentTimeMillis() - r15.f;
        Unit r24 = Unit.INSTANCE;
        r22.getClass();
        com.bytedance.android.monitorV2.lynx.d.i(r19, r23);
        return;
    L26:
        com.bytedance.android.monitorV2.lynx.d r25 = com.bytedance.android.monitorV2.lynx.d.f3638a;
        f r26 = new f();
        r26.d = r21;
        r26.f22969b = r20;
        String r27 = r15.f939l;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L29
        r27 = new JSONObject().putOpt("message", r27).putOpt("code", Integer.valueOf(r20)).toString();     // Catch: Throwable -> L29
    L31:
        r26.f22970c = r27;
        Unit r29 = Unit.INSTANCE;
        r25.getClass();
        com.bytedance.android.monitorV2.lynx.d.h(r19, r26);
        return;
    L29:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L31
    L35:
        return;
    L19:
        String r31 = r15.f939l;
        Intrinsics.checkNotNullParameter(r31, "reason");
        int r32 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("AirSolution_ActionDispatcher", f4.b.b(new StringBuilder("jsb action failed, bridge name: "), (String) r16.g, ", reason: ", r31), null, 12);
        goto L20
    L11:
        r14 = false;
        goto L12
    L7:
        r12 = null;
    L13:
        r13 = true;
        goto L14
    }
}
