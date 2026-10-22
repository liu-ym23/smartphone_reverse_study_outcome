package mh;

import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.bytedance.pia.core.bridge.protocol.ProtocolMessage;
import com.bytedance.pia.core.plugins.BootPlugin;
import com.google.gson.JsonObject;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements fh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JsonObject f20089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f20090c;
    public final /* synthetic */ BootPlugin d;

    public /* synthetic */ a(BootPlugin r5, JsonObject r10, String r11, int r12) {
        this.f20088a = r12;
        this.d = r5;
        this.f20089b = r10;
        this.f20090c = r11;
    }

    @Override // fh.a
    public final void accept(Object r5) {
        switch(this.f20088a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        PiaMethod$Error r10 = (PiaMethod$Error) r5;
        JsonObject r11 = ProtocolMessage.b(new l9.g(1, r10.f6951a, null, r10.getMessage()));
        JsonObject r12 = this.f20089b;
        r12.add("result", r11);
        BootPlugin r13 = this.d;
        r13.f7042c.add(r12);
        ArrayList r14 = r13.d;
        r14.remove(this.f20090c);
        if (r14.isEmpty() == false) goto L12;
        r13.f20236b.f20250v.c("pia.internal.boot.onFinish", new com.bytedance.pia.core.bridge.methods.d(r13.f7042c));
        return;
    L12:
        return;
    L8:
        JsonObject r15 = ProtocolMessage.b(new l9.g(1, 1, (JsonObject) r5, null));
        JsonObject r16 = this.f20089b;
        r16.add("result", r15);
        BootPlugin r17 = this.d;
        r17.f7042c.add(r16);
        ArrayList r18 = r17.d;
        r18.remove(this.f20090c);
        if (r18.isEmpty() == false) goto L13;
        r17.f20236b.f20250v.c("pia.internal.boot.onFinish", new com.bytedance.pia.core.bridge.methods.d(r17.f7042c));
        return;
    }
}
