package com.ss.ugc.effectplatform.task;

import bytekn.foundation.logger.Logger;
import c0.e;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.UrlModel;
import com.ss.ugc.effectplatform.util.h;
import hlc.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import z.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class DownloadEffectTask extends BaseTask {
    public final List<String> g;
    public final a0.b<o1<nlc.a>> h;
    public final c0.a i;
    public int j;
    public long k;
    public final Effect l;
    public final EffectConfig m;
    public final String n;
    public final com.ss.ugc.effectplatform.model.a o;

    public static final class a {
    }

    public static final class b implements d {
        public final /* synthetic */ d a;
        public final /* synthetic */ DownloadEffectTask b;

        @Override // hlc.d
        public final void onStart(Effect r1) {
        }

        @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
        public final void onSuccess(Effect r2) {
            d r0 = this.a;
            r0.onSuccess(r2);
            DownloadEffectTask r3 = this.b;
            r3.m.N.c(r3.n);
        }

        public b(d r1, DownloadEffectTask r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
        public final void onFail(Effect r2, ExceptionResult r3) {
            d r0 = this.a;
            r0.onFail(r2, r3);
            DownloadEffectTask r4 = this.b;
            r4.m.N.c(r4.n);
        }

        @Override // hlc.d
        public final void onProgress(Effect r2, int r3, long r4) {
            this.a.onProgress(r2, r3, r4);
        }
    }

    static {
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void a() {
        if (this.i.a() == false) goto L14;
        Effect r1 = this.l;
        List<String> r2 = this.g;
        EffectConfig r3 = this.m;
        blc.b r0 = new blc.b(r1, r2, r3.i);
        Object r4 = r3.z.a;
        if (r4 != null) goto L7;
        e(new downloadEffect.1(this));
        return;
    L7:
        a0.b<o1<nlc.a>> r5 = this.h;
        r5.a = ((blc.a) r4).a(r0);
        a0.b<o1<nlc.a>> r6 = this.h;
        o1 r7 = (o1) r6.a;
        if (r7 == null) goto L10;
        r7.a.a = new DownloadEffectTask$downloadEffect$2(this);
    L10:
        o1 r8 = (o1) r6.a;
        if (r8 == null) goto L16;
        r8.b();
        return;
    L16:
        return;
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void b() {
        if (this.d == true) goto L12;
        IEffectPlatformBaseListener r0 = this.m.N.a(this.n);
        if ((r0 instanceof d) == true) goto L7;
        r0 = null;
    L7:
        d r1 = (d) r0;
        if (r1 == null) goto L10;
        r1.onFail(this.l, new ExceptionResult(10001, new Exception(String.valueOf(10001))));
    L10:
        e(new onCancel.1(this));
        return;
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void c() {
        if (this.d == true) goto L11;
        IEffectPlatformBaseListener r0 = this.m.N.a(this.n);
        if ((r0 instanceof d) == true) goto L7;
        r0 = null;
    L7:
        d r1 = (d) r0;
        if (r1 == null) goto L12;
        r1.onFail(this.l, new ExceptionResult(10019, new Exception(String.valueOf(10019))));
        return;
    L12:
        return;
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void cancel() {
        o1 r0 = (o1) this.h.a;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        super.cancel();
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void d() {
        e r3 = w.a;
        r3.a();
        Effect r4 = this.l;     // Catch: Throwable -> L36
        r4.setId(StringsKt.replace$default(StringsKt.replace$default(r4.getId(), "\"", "_", false, 4, null), "/", "_", false, 4, null));     // Catch: Throwable -> L36
        com.ss.ugc.effectplatform.repository.d r5 = this.m.M;     // Catch: Throwable -> L36
        String r6 = com.ss.ugc.effectplatform.model.b.a(this.l);     // Catch: Throwable -> L36
        r5.getClass();     // Catch: Throwable -> L36
        if (com.ss.ugc.effectplatform.repository.d.c(r6) == false) goto L27;
        Logger.INSTANCE.d("DownloadEffectTask", "[特效][已经在下载][特效ID:" + this.l.getEffect_id() + "][" + getId() + "][MD5:" + com.ss.ugc.effectplatform.model.b.a(this.l) + ']');     // Catch: Throwable -> L36
        IEffectPlatformBaseListener r0 = this.m.N.a(this.n);     // Catch: Throwable -> L36
        String r7 = null;
        if ((r0 instanceof d) == true) goto L9;
        r0 = null;
    L9:
        d r1 = (d) r0;     // Catch: Throwable -> L36
        if (r1 == null) goto L26;
        r1.onStart(this.l);     // Catch: Throwable -> L36
        com.ss.ugc.effectplatform.repository.d r8 = this.m.M;     // Catch: Throwable -> L36
        Effect r9 = this.l;     // Catch: Throwable -> L36
        b r10 = new b(r1, this);     // Catch: Throwable -> L36
        if (r9 == null) goto L14;
        r8.getClass();     // Catch: Throwable -> L36
        r7 = com.ss.ugc.effectplatform.model.b.a(r9);     // Catch: Throwable -> L36
    L14:
        r8.getClass();     // Catch: Throwable -> L36
        if (com.ss.ugc.effectplatform.repository.d.c(r7) == false) goto L17;
        if (r9 == null) goto L26;
        String r2 = com.ss.ugc.effectplatform.model.b.a(r9);     // Catch: Throwable -> L36
        if (r2 == null) goto L26;
        z.b<String, c<d>> r11 = com.ss.ugc.effectplatform.repository.d.b;     // Catch: Throwable -> L36
        Object r12 = r11.get(r2);     // Catch: Throwable -> L36
        if (r12 != null) goto L25;
        r12 = new c(true);     // Catch: Throwable -> L36
        r11.put(r2, r12);     // Catch: Throwable -> L36
    L25:
        ((c) r12).add(r10);     // Catch: Throwable -> L36
        goto L26
    L17:
        if (com.ss.ugc.effectplatform.repository.d.b(r9, false, Boolean.FALSE) == false) goto L26;
        r10.onSuccess(r9);     // Catch: Throwable -> L36
    L26:
        this.i.b(false);     // Catch: Throwable -> L36
    L33:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L36
        r3.b();
        return;
    L27:
        this.i.b(true);     // Catch: Throwable -> L36
        com.ss.ugc.effectplatform.repository.d r14 = this.m.M;     // Catch: Throwable -> L36
        Effect r15 = this.l;     // Catch: Throwable -> L36
        r14.getClass();     // Catch: Throwable -> L36
        if (r15 == null) goto L32;
        String r16 = com.ss.ugc.effectplatform.model.b.a(r15);     // Catch: Throwable -> L36
        if (r16 == null) goto L32;
        com.ss.ugc.effectplatform.repository.d.a.put(r16, r15);     // Catch: Throwable -> L36
    L32:
        Logger.INSTANCE.d("DownloadEffectTask", "[特效][开始下载][特效ID:" + this.l.getEffect_id() + "][" + getId() + "][MD5:" + com.ss.ugc.effectplatform.model.b.a(this.l) + ']');     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r3.b();
        throw th;
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void pause() {
        super.pause();
        o1 r0 = (o1) this.h.a;
        if (r0 == null) goto L6;
        r0.j();
        return;
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final int getLevel() {
        return this.j;
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final long getModifyTime() {
        return this.k;
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void setModifyTime(long r1) {
        this.k = r1;
    }

    public static final void f(DownloadEffectTask r6, boolean r7, ExceptionResult r8) {
        if (r6.m.v.a == null) goto L43;
        com.ss.ugc.effectplatform.model.a r0 = r6.o;
        if (r0 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual("beautify", r0.getPanel()) == false) goto L9;
    L10:
        int r9 = !r7 ? 1 : 0;
        StringBuilder r1 = new StringBuilder();
        List<String> r2 = r6.g;
        if (r2 == null) goto L16;
        Iterator<String> r3 = r2.iterator();
    L14:
        if (r3.hasNext() == false) goto L16;
        r1.append(r3.next());
        r1.append(",");
    L16:
        klc.a r4 = (klc.a) r6.m.v.a;
        if (r4 == null) goto L46;
        HashMap r5 = new HashMap();
        r5.put("effect_id", r6.l.getEffect_id());
        r5.put("effect_name", r6.l.getName());
        String r10 = r6.m.m;
        String r11 = "";
        if (r10 != null) goto L22;
        r10 = "";
    L22:
        r5.put("app_id", r10);
        String r12 = r6.m.a;
        if (r12 != null) goto L26;
        r12 = "";
    L26:
        r5.put(EffectConfiguration.KEY_ACCESS_KEY, r12);
        r5.put("download_urls", r1.toString());
        String r13 = r6.o.getPanel();
        if (r13 != null) goto L30;
        r13 = "";
    L30:
        r5.put(EffectConfiguration.KEY_PANEL, r13);
        if (r8 != null) goto L33;
        String r14 = "";
    L34:
        r5.put("error_code", r14);
        if (r8 == null) goto L40;
        String r15 = r8.getMsg();
        if (r15 == null) goto L40;
        r11 = r15;
    L40:
        r5.put("error_msg", r11);
        r4.monitorStatusRate("effect_resource_download_success_rate", r9, r5);
        return;
    L33:
        r14 = "" + r8.getErrorCode();
        goto L34
    L46:
        return;
    L9:
        if (Intrinsics.areEqual("beautifynew", r6.o.getPanel()) == true) goto L10;
        return;
    }

    public DownloadEffectTask(Effect r2, EffectConfig r3, String r4, com.ss.ugc.effectplatform.model.a r5) {
        super(r4, null);
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.o = r5;
        h r6 = h.a;
        UrlModel r7 = r2.getFile_url();
        r6.getClass();
        if (r7 != null) goto L5;
    L8:
        List<String> r8 = new ArrayList();
    L9:
        this.g = r8;
        this.h = new a0.b(null);
        this.i = new c0.a(true);
        return;
    L5:
        if (h.c(r7) == true) goto L8;
        r8 = r7.getUrl_list();
        goto L9
    }
}
