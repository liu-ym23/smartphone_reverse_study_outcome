package i78;

import com.bytedance.flow_audio.api.service.KmpTtsEventEnum;
import com.bytedance.flow_audio.api.service.KmpTtsLifeState;
import com.larus.audio.audiov3.task.tts.TtsLifeState;
import com.larus.audio.flow.client.kmp_com.FlowTtsClientKmpManagerDelegate;
import com.larus.audio.flow.client.kmp_com.FlowTtsClientKmpManagerDelegate$b;
import com.larus.audio.ttsV2.TtsClientManager$e;
import fa9.e;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import m58.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements ww5.b {
    public final /* synthetic */ l68.b a;
    public final /* synthetic */ FlowTtsClientKmpManagerDelegate b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public final void a(byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        l68.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.b(r3, false);
        return;
    }

    public final void c(KmpTtsLifeState r5, String r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r5, "lifeState");
        TtsLifeState r8 = f.a(r5);
        l68.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.e(r8, r6, r7);
    L5:
        FlowTtsClientKmpManagerDelegate r9 = this.b;
        String r1 = this.c;
        int r2 = FlowTtsClientKmpManagerDelegate.d;
        r9.getClass();
        int r10 = FlowTtsClientKmpManagerDelegate$b.a[r8.ordinal()];
        boolean r3 = true;
        if (r10 != 1) goto L8;
        e.a.f("tts", r1);
    L12:
        m58.b r11 = h.k;
        if (r11 != null) goto L15;
    L17:
        r3 = false;
    L18:
        if (r3 == false) goto L24;
        FlowTtsClientKmpManagerDelegate r12 = this.b;
        if (r6 != null) goto L22;
        r6 = "";
    L22:
        FlowTtsClientKmpManagerDelegate.E(r12, r8, r6, this.d, this.e);
        return;
    L24:
        return;
    L15:
        if (r11.a() != true) goto L17;
    L8:
        if (r10 != 2) goto L12;
        e.a.f("tts", r1);
        goto L12
    }

    public c(TtsClientManager$e r1, FlowTtsClientKmpManagerDelegate r2, String r3, String r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void b(KmpTtsEventEnum r9, String r10, int r11, String r12, Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r9, "event");
        Intrinsics.checkNotNullParameter(r10, "customErrorMsg");
        Intrinsics.checkNotNullParameter(r12, "ext");
        Intrinsics.checkNotNullParameter(r13, "extMap");
        FlowTtsClientKmpManagerDelegate.D(this.b, this.a, r9, r10, r11, r12, r13);
    }
}
