package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.live.livelink.kmp.impl.extend.chorus.ChorusManager;
import io.reactivex.functions.Consumer;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f0<T> implements Consumer {
    public final /* synthetic */ HamletAvatarWidget a;

    public f0(HamletAvatarWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        HamletAvatarContext r7 = this.a.f;
        Integer r0 = null;
        if (r7 == null) goto L7;
        com.bytedance.live.datacontext.n<Integer> r8 = r7.getVADState();
        if (r8 == null) goto L7;
        Integer r9 = (Integer) r8.getValue();
    L8:
        HamletAvatarContext r1 = this.a.f;
        if (r1 == null) goto L13;
        com.bytedance.live.datacontext.n<Integer> r2 = r1.getAEDState();
        if (r2 == null) goto L13;
        r0 = (Integer) r2.getValue();
    L13:
        HamletAvatarWidget r3 = this.a;
        r3.getClass();
        int r4 = 0;
        if (r9 != null) goto L30;
        int r10 = 0;
    L17:
        if (r0 == null) goto L19;
        r4 = r0.intValue();     // Catch: Exception -> L29
    L19:
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L29
        r11.put("vad", r10);     // Catch: Exception -> L29
        r11.put("aed", r4);     // Catch: Exception -> L29
        String r12 = r11.toString();     // Catch: Exception -> L29
        cg6.a r13 = r3.Eq();     // Catch: Exception -> L29
        if (r13 == null) goto L32;
        hg6.g r14 = r13.getRtcManager();     // Catch: Exception -> L29
        if (r14 == null) goto L33;
        ei6.a r15 = r14.V0();     // Catch: Exception -> L29
        if (r15 == null) goto L34;
        ChorusManager r16 = r15.i();     // Catch: Exception -> L29
        if (r16 == null) goto L35;
        r16.s(StringsKt.encodeToByteArray(r12), r3.y);     // Catch: Exception -> L29
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L30:
        r10 = r9.intValue();     // Catch: Exception -> L29
    L7:
        r9 = null;
        goto L8
    }
}
