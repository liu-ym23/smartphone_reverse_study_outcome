package com.ss.ugc.effectplatform.preload;

import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.PreloadResourceList;
import com.ss.ugc.effectplatform.model.net.PreloadResponse;
import com.ss.ugc.effectplatform.model.net.PreloadResponseModel;
import com.ss.ugc.effectplatform.task.PreloadDeleteTask;
import com.ss.ugc.effectplatform.task.q1;
import com.ss.ugc.effectplatform.util.q;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements IEffectPlatformBaseListener<PreloadResponse> {
    public final e a;
    public final /* synthetic */ String b;
    public final /* synthetic */ EffectConfig c;

    public final void onSuccess(Object r6) {
        z.b<String, Long> r0 = h.b;
        String r1 = this.b;
        int r2 = b0.a.a;
        r0.put(r1, Long.valueOf(System.currentTimeMillis()));
        PreloadResponseModel r7 = ((PreloadResponse) r6).getData();
        if (r7 == null) goto L19;
        List<PreloadResourceList> r3 = r7.getPreload_resource_list();
        if (r3 == null) goto L7;
        e r4 = this.a;
        int r5 = r3.size();
        r4.getClass();
        r4.d = new c0.b(r5);
    L7:
        Long r8 = r7.getProtection_period();
        if (r8 == null) goto L10;
        long r9 = r8.longValue();
    L12:
        if (r9 <= 0) goto L14;
        long r10 = r9 * ((long) AudioViewModel.ASR_SESSION_IDLE);
    L15:
        h.c = r10;
        PreloadDeleteTask r11 = new PreloadDeleteTask(this.c, r7.getDelete_cmd(), q.a(), new f(r7, this));
        q1 r12 = this.c.D;
        if (r12 == null) goto L20;
        r12.a(r11);
        return;
    L20:
        return;
    L14:
        r10 = 3600000;
        goto L15
    L10:
        r9 = 0;
        goto L12
    }

    public g(String r2, EffectConfig r3) {
        this.b = r2;
        this.c = r3;
        this.a = new e(r3, r2);
    }

    public final /* bridge */ /* synthetic */ void onFail(Object r1, ExceptionResult r2) {
        PreloadResponse r3 = (PreloadResponse) r1;
    }
}
