package com.bytedance.ai.bridge.method.hybridmonitor;

import a1.a;
import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.hybridMonitor.AbsInitConfigMethodIDL;
import com.bytedance.pia.core.utils.i;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import o1.f;
import oo.j;
import org.json.JSONObject;
import z1.b;
import z1.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/bridge/method/hybridmonitor/InitConfigMethod;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsInitConfigMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsInitConfigMethodIDL$SlardarConfigModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsInitConfigMethodIDL$EmptyMessageModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/hybridMonitor/AbsInitConfigMethodIDL$SlardarConfigModel;Lo1/f;)V", "Companion", "z1/c", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInitConfigMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InitConfigMethod.kt\ncom/bytedance/ai/bridge/method/hybridmonitor/InitConfigMethod\n+ 2 AIBridgeContextExt.kt\ncom/bytedance/ai/bridge/context/AIBridgeContextExtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,36:1\n13#2:37\n10#2:38\n3#2:39\n5#2:41\n1#3:40\n*S KotlinDebug\n*F\n+ 1 InitConfigMethod.kt\ncom/bytedance/ai/bridge/method/hybridmonitor/InitConfigMethod\n*L\n26#1:37\n26#1:38\n26#1:39\n26#1:41\n26#1:40\n*E\n"})
public final class InitConfigMethod extends AbsInitConfigMethodIDL {
    public static final c Companion = null;
    private static final String TAG = "HybridMonitor";

    static {
        Companion = new c();
    }

    public InitConfigMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, f r11) {
        handle(r5, (AbsInitConfigMethodIDL.SlardarConfigModel) r10, r11);
    }

    public void handle(n1.c r10, AbsInitConfigMethodIDL.SlardarConfigModel r11, f r12) {
        String r13 = "";
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        Intrinsics.checkNotNullParameter(TAG, "tag");     // Catch: Exception -> L8
        Intrinsics.checkNotNullParameter("init config", "msg");     // Catch: Exception -> L8
        a.f43a.i(TAG, "init config");     // Catch: Exception -> L8
        JSONObject r14 = j.f(i.d(r11.toJson()));     // Catch: Exception -> L8
        RefType r5 = RefType.f1803a;     // Catch: Exception -> L8
        n1.a r15 = (n1.a) r10;     // Catch: Exception -> L8
        Object r16 = r15.b(b.class);     // Catch: Exception -> L8
        if (r16 != null) goto L12;
        Intrinsics.checkNotNullParameter(TAG, "tag");     // Catch: Exception -> L8
        Intrinsics.checkNotNullParameter("creating event reporter", "msg");     // Catch: Exception -> L8
        a.f43a.i(TAG, "creating event reporter");     // Catch: Exception -> L8
        m1.j r17 = (m1.j) r15.b(m1.j.class);     // Catch: Exception -> L8
        if (r17 == null) goto L10;
        String r18 = r17.e();     // Catch: Exception -> L8
    L11:
        r16 = new b(r18);     // Catch: Exception -> L8
        r15.c(b.class, r16, r5);     // Catch: Exception -> L8
        goto L12
    L10:
        r18 = null;
    L12:
        b r19 = (b) r16;     // Catch: Exception -> L8
        Intrinsics.checkNotNullParameter(r14, "value");     // Catch: Exception -> L8
        if (StringsKt.isBlank(r19.f23360a) == false) goto L15;
        String r20 = r14.optString("bid");     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r20);     // Catch: Exception -> L8
        r19.f23360a = r20;     // Catch: Exception -> L8
    L15:
        r19.f23362c = qo.a.q(r19.f23362c, r14);     // Catch: Exception -> L8
        Intrinsics.checkNotNullParameter(AbsInitConfigMethodIDL.EmptyMessageModel.class, "<this>");     // Catch: Exception -> L8
        r12.b((ResultModel) e.c(AbsInitConfigMethodIDL.EmptyMessageModel.class), "");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        Intrinsics.checkNotNullParameter("init config failed", "msg");
        a.f43a.e(TAG, "init config failed", e);
        String r21 = e.getMessage();
        if (r21 == null) goto L21;
        r13 = r21;
    L21:
        r12.a(r13);
    }
}
