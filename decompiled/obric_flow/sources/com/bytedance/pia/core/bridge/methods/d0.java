package com.bytedance.pia.core.bridge.methods;

import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.bytedance.pia.core.bridge.protocol.ProtocolMessage;
import com.google.gson.JsonObject;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d0 implements fh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ gh.c f6972c;
    public final /* synthetic */ Serializable d;

    public /* synthetic */ d0(gh.c r5, com.bytedance.salamander.anniex.b0 r10, AtomicBoolean r11) {
        this.f6970a = 2;
        this.f6972c = r5;
        this.f6971b = r10;
        this.d = r11;
    }

    @Override // fh.a
    public final void accept(Object r10) {
        switch(this.f6970a) {
            case 0: goto L22;
            case 1: goto L17;
            default: goto L4;
        };
    L4:
        PiaMethod$Error r11 = (PiaMethod$Error) r10;
        gh.c r5 = this.f6972c;
        r5.getClass();
        if (r11.getMessage() != null) goto L7;
    L10:
        JsonObject r12 = null;
    L11:
        JsonObject r13 = ProtocolMessage.b(new l9.g(((com.bytedance.salamander.anniex.b0) this.f6971b).f7246b, r11.f6951a, r12, r11.getMessage()));
        if (r13 != null) goto L14;
        return;
    L14:
        if (((AtomicBoolean) this.d).compareAndSet(false, true) == false) goto L51;
        r5.e.c(r13);
        return;
    L51:
        return;
    L7:
        if (r11.getMessage().startsWith("{") == false) goto L10;
        r12 = (JsonObject) com.bytedance.pia.core.utils.i.f7152b.parse(r11.getMessage());     // Catch: Throwable -> L44
    L17:
        String r14 = (String) r10;
        if (r14 == null) goto L52;
        ((nh.d) this.f6971b).s.f7111j = 2;
        h0 r15 = new h0((String) this.d, r14);
        this.f6972c.c("pia.internal.worker.onError", r15);
        return;
    L52:
        return;
    L22:
        JsonObject r16 = (JsonObject) r10;
        if (r16 == null) goto L53;
        com.bytedance.pia.core.tracing.b r17 = ((nh.d) this.f6971b).s;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r16, "jsonObject");
        if (((Boolean) r17.f7106a.getValue()).booleanValue() == false) goto L29;
    L42:
        i0 r18 = new i0((String) this.d, r16);
        this.f6972c.c("pia.internal.worker.onMessage", r18);
        return;
    L29:
        if (r16.has("t") == false) goto L42;
        float r19 = r16.get("t").getAsFloat();
        if (r19 != 10.0f) goto L34;
        r17.b("NBF");
        r17.a(1);
        goto L42
    L34:
        if (r19 != 11.0f) goto L42;
        r17.b("NDF");
        r17.a(2);
    L41:
        r17.f7111j = 8;
        goto L42
    L37:
        if (r16.get(LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME).getAsJsonObject().get("response").getAsJsonObject().get("statusCode").getAsFloat() != 1.0f) goto L39;
        r17.f7111j = 0;     // Catch: Throwable -> L41
    L45:
        goto L42
    L39:
        r17.f7111j = 8;     // Catch: Throwable -> L41
        goto L45
    }

    public /* synthetic */ d0(nh.d r5, gh.c r10, String r11, int r12) {
        this.f6970a = r12;
        this.f6971b = r5;
        this.f6972c = r10;
        this.d = r11;
    }
}
