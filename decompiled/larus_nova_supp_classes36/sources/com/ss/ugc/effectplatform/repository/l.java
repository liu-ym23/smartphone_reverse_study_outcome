package com.ss.ugc.effectplatform.repository;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.task.WriteUpdateTagTask;
import com.ss.ugc.effectplatform.task.q1;
import com.ss.ugc.effectplatform.util.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l {
    public final a0.b<z.b<String, String>> a;
    public final EffectConfig b;

    public static abstract class a implements IEffectPlatformBaseListener<String> {
        public a() {
        }
    }

    public static final class b extends a {
        public final /* synthetic */ hlc.f a;

        public b(hlc.f r1) {
            this.a = r1;
        }

        public final void onSuccess(Object r1) {
            String r2 = (String) r1;
            hlc.f r3 = this.a;
            if (r3 == null) goto L6;
            r3.onFinally();
            return;
        }

        public final /* bridge */ /* synthetic */ void onFail(Object r1, ExceptionResult r2) {
            String r3 = (String) r1;
        }
    }

    public l(EffectConfig r2) {
        this.b = r2;
        this.a = new a0.b(null);
    }

    public final void a(String r8, String r9, IEffectPlatformBaseListener<Boolean> r10) {
        if (this.a.a != null) goto L6;
        if (r10 == null) goto L6;
        r10.onSuccess(Boolean.TRUE);
    L6:
        z.b r0 = (z.b) this.a.a;
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.containsKey(r8) == false) goto L36;
        int r1 = u.a;
        boolean r2 = true;
        long r3 = -1;
        if (r9 != null) goto L13;
    L20:
        long r5 = -1;
    L21:
        String r11 = (String) r0.get(r8);
        if (r11 == null) goto L31;
        if (r11.length() == 0) goto L27;
        r2 = false;
    L27:
        if (r2 == true) goto L31;
        r3 = CastLongProtector.parseLong(r11);     // Catch: Exception -> L39
    L31:
        if (r5 <= r3) goto L34;
        if (r10 == null) goto L46;
        r10.onSuccess(Boolean.TRUE);
        return;
    L46:
        return;
    L34:
        if (r10 == null) goto L48;
        r10.onSuccess(Boolean.FALSE);
        return;
    L48:
        return;
    L13:
        if (r9.length() != 0) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == true) goto L20;
        r5 = CastLongProtector.parseLong(r9);     // Catch: Exception -> L40
    L15:
        r6 = false;
        goto L16
    L36:
        if (r10 == null) goto L50;
        r10.onSuccess(Boolean.TRUE);
        return;
    }

    public final void b(String r2, String r3, String r4, hlc.f r5) {
        if (this.a.a != null) goto L6;
        if (r5 == null) goto L6;
        r5.onFinally();
    L6:
        z.b r0 = (z.b) this.a.a;
        if (r0 == null) goto L12;
        r0.put(r3, r4);
        b r6 = new b(r5);
        this.b.N.b(r2, r6);
        EffectConfig r7 = this.b;
        WriteUpdateTagTask r8 = new WriteUpdateTagTask(r7, r2, r0);
        q1 r9 = r7.D;
        if (r9 == null) goto L13;
        r9.a(r8);
        return;
    L13:
        return;
    }
}
