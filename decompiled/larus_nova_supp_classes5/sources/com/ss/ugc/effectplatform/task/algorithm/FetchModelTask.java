package com.ss.ugc.effectplatform.task.algorithm;

import android.util.Log;
import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import c0.e;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import com.ss.ugc.effectplatform.exception.NetException;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel;
import com.ss.ugc.effectplatform.model.algorithm.FetchModelType;
import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;
import com.ss.ugc.effectplatform.task.BaseTask;
import com.ss.ugc.effectplatform.task.x0;
import com.ss.ugc.effectplatform.util.PlatformType;
import com.ss.ugc.effectplatform.util.i;
import com.ss.ugc.effectplatform.util.k;
import com.ss.ugc.effectplatform.util.l;
import com.ss.ugc.effectplatform.util.n;
import com.ss.ugc.effectplatform.util.r;
import com.ss.ugc.effectplatform.util.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class FetchModelTask extends BaseTask {
    public final a0.b<Long> g;
    public final a0.b<Long> h;
    public final a0.b<Integer> i;
    public final a0.b<Integer> j;
    public h k;
    public final c0.b l;
    public final c0.b m;
    public final z.a<a> n;
    public final EffectConfig o;
    public final x0 p;
    public final com.ss.ugc.effectplatform.algorithm.d q;
    public final com.ss.ugc.effectplatform.cache.a r;
    public final String[] s;
    public final int t;
    public final String u;
    public final com.ss.ugc.effectplatform.a v;
    public final f w;
    public final bytekn.foundation.concurrent.executor.a x;
    public final Effect y;

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void b() {
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void a() {
        String r1 = null;
        if (this.o.V == false) goto L43;
        c0.a r0 = g.b;
        if (r0.a() == true) goto L43;
        e r5 = g.a;
        r5.a();
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L40
        r6.append(this.o.K);     // Catch: Throwable -> L40
        String r7 = FileManager.a;     // Catch: Throwable -> L40
        r6.append(FileManager.a);     // Catch: Throwable -> L40
        r6.append("model_mapping.txt");     // Catch: Throwable -> L40
        String r8 = r6.toString();     // Catch: Throwable -> L40
        boolean r9 = FileManager.d(r8);     // Catch: Throwable -> L40
        if (r9 == false) goto L11;
        r0.b(r9);     // Catch: Throwable -> L40
    L39:
        r5.b();
        goto L43
    L11:
        int r2 = b0.a.a;     // Catch: Throwable -> L40
        long r10 = System.currentTimeMillis();     // Catch: Throwable -> L40
        List r3 = FileManager.f(this.o.K);     // Catch: Exception -> L32 Throwable -> L40
        if (r3 == null) goto L69;
        Iterator r4 = r3.iterator();     // Catch: Exception -> L32 Throwable -> L40
    L15:
        if (r4.hasNext() == false) goto L69;
        String r11 = (String) r4.next();     // Catch: Exception -> L32 Throwable -> L40
        i r12 = i.a;     // Catch: Exception -> L32 Throwable -> L40
        String r13 = i.e(r11);     // Catch: Exception -> L32 Throwable -> L40
        if (r13 == null) goto L15;
        boolean r14 = false;
        if (StringsKt.startsWith$default(r13, "algo_", false, 2, null) == true) goto L15;
        if (StringsKt.endsWith$default(r13, "_model", false, 2, null) == false) goto L15;
        String r15 = i.g(r11);     // Catch: Exception -> L32 Throwable -> L40
        if (r15 == null) goto L30;
        if (r15.length() != 0) goto L28;
        r14 = true;
    L28:
        if (r14 == true) goto L15;
    L30:
        String r16 = k.d(r13);     // Catch: Exception -> L32 Throwable -> L40
        String r17 = bytekn.foundation.utils.c.a(r16);     // Catch: Exception -> L32 Throwable -> L40
        String r18 = r13.substring(r16.length(), r13.length());     // Catch: Exception -> L32 Throwable -> L40
        com.ss.ugc.effectplatform.cache.disklrucache.a.w.getClass();     // Catch: Exception -> L32 Throwable -> L40
        String r19 = com.ss.ugc.effectplatform.cache.disklrucache.a.C0011a.c(r17 + r18);     // Catch: Exception -> L32 Throwable -> L40
        String r110 = FileManager.a;     // Catch: Exception -> L32 Throwable -> L40
        bytekn.foundation.io.file.b r111 = FileManager.j(r11);     // Catch: Exception -> L32 Throwable -> L40
        this.r.b(r19, r111);     // Catch: Exception -> L32 Throwable -> L40
        r111.close();     // Catch: Exception -> L32 Throwable -> L40
        this.r.remove(r13);     // Catch: Exception -> L32 Throwable -> L40
        FileManager.o(r11);     // Catch: Exception -> L32 Throwable -> L40
        goto L15
    L69:
        FileManager.u(r8, "MappingFile");     // Catch: Exception -> L36 Throwable -> L40
    L38:
        g.b.b(true);     // Catch: Throwable -> L40
        Logger r20 = Logger.INSTANCE;     // Catch: Throwable -> L40
        StringBuilder r21 = new StringBuilder();     // Catch: Throwable -> L40
        r21.append("[Model][Mapping][cost:");     // Catch: Throwable -> L40
        int r22 = b0.a.a;     // Catch: Throwable -> L40
        r21.append(System.currentTimeMillis() - r10);     // Catch: Throwable -> L40
        r21.append(']');     // Catch: Throwable -> L40
        r20.w("JKL", r21.toString());     // Catch: Throwable -> L40
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L40
        goto L39
    L36:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L40
    L32:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L40
        Logger.e$default(Logger.INSTANCE, "JKL", "[Model][Mapping][Rename][" + Log.getStackTraceString(e) + ']', null, 4, null);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        r5.b();
        throw th;
    L43:
        String[] r24 = this.s;
        com.ss.ugc.effectplatform.a r25 = this.v;
        if (r25 != null) goto L46;
    L51:
        if (r24 == null) goto L66;
        Logger r26 = Logger.INSTANCE;
        StringBuilder r27 = new StringBuilder("[模型][依赖][Effect_ID:");
        Effect r28 = this.y;
        if (r28 == null) goto L55;
        r1 = r28.getEffect_id();
    L55:
        r27.append(r1);
        r27.append("][");
        r27.append(this.u);
        r27.append("][");
        r27.append(s.a(r24));
        r27.append("][数量:");
        r27.append(r24.length);
        r27.append(']');
        r26.w("JKL", r27.toString());
        this.i.a = Integer.valueOf(r24.length);
        com.ss.ugc.effectplatform.a r29 = this.v;
        if (r29 != null) goto L58;
    L60:
        e r30 = g.a;
        r30.a();
        l(r24);     // Catch: Throwable -> L63
        Unit r31 = Unit.INSTANCE;     // Catch: Throwable -> L63
        r30.b();
        return;
    L63:
        th = move-exception;
        r30.b();
        throw th;
    L58:
        if (r29.a(this.y) != true) goto L60;
        l(r24);
        return;
    L66:
        return;
    L46:
        if (r25.a(this.y) != true) goto L51;
        if (r24 != null) goto L51;
        f r32 = this.w;
        if (r32 == null) goto L51;
        r32.a(new fetchModels.1(this));
        goto L51
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void cancel() {
        Effect r0 = this.y;
        if (r0 == null) goto L15;
        com.ss.ugc.effectplatform.a r3 = this.v;
        if (r3 == null) goto L15;
        if (ArraysKt.contains(r3.e, r0.getPanel()) == true) goto L9;
    L13:
        boolean r1 = false;
    L14:
        Boolean r2 = Boolean.valueOf(r1);
    L17:
        if ((!Intrinsics.areEqual(r2, Boolean.TRUE)) == false) goto L33;
        return;
    L33:
        Iterator r4 = this.n.iterator();     // Catch: Exception -> L29
    L21:
        if (r4.hasNext() == false) goto L31;
        com.ss.ugc.effectplatform.download.a r5 = ((a) r4.next()).b;     // Catch: Exception -> L29
        com.ss.ugc.effectplatform.download.f r6 = r5.d;     // Catch: Exception -> L29
        String r7 = r5.c;     // Catch: Exception -> L29
        INetworkClient r8 = r6.a;     // Catch: Exception -> L29
        if ((r8 instanceof com.ss.ugc.effectplatform.bridge.network.b) == true) goto L25;
        r8 = null;
    L25:
        com.ss.ugc.effectplatform.bridge.network.b r9 = (com.ss.ugc.effectplatform.bridge.network.b) r8;     // Catch: Exception -> L29
        if (r9 == null) goto L21;
        r9.cancel(r7);     // Catch: Exception -> L29
    L31:
        super.cancel();
        return;
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    L9:
        if (r3.b == false) goto L13;
        if (r3.d == false) goto L13;
        r1 = true;
    L15:
        r2 = null;
        goto L17
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void pause() {
        Effect r0 = this.y;
        int r1 = 0;
        if (r0 == null) goto L15;
        com.ss.ugc.effectplatform.a r4 = this.v;
        if (r4 == null) goto L15;
        if (ArraysKt.contains(r4.e, r0.getPanel()) == true) goto L9;
    L13:
        boolean r2 = false;
    L14:
        Boolean r3 = Boolean.valueOf(r2);
    L17:
        if ((!Intrinsics.areEqual(r3, Boolean.TRUE)) == false) goto L19;
        return;
    L19:
        super.pause();
        int r5 = this.l.b();
    L20:
        if (r1 >= r5) goto L23;
        this.m.a();
        r1 = r1 + 1;
        goto L20
    L23:
        if (this.m.b() != 0) goto L40;
        f r6 = this.w;
        if (r6 == null) goto L40;
        r6.a(new pause.2(this));
    L40:
        Iterator r7 = this.n.iterator();     // Catch: Exception -> L37
    L29:
        if (r7.hasNext() == false) goto L48;
        a r8 = (a) r7.next();     // Catch: Exception -> L37
        Logger.e$default(Logger.INSTANCE, "JKL", "[模型][暂停][正在下载的任务][" + r8.a.getName() + "][" + ilc.b.a(r8.a) + ']', null, 4, null);     // Catch: Exception -> L37
        com.ss.ugc.effectplatform.download.a r9 = r8.b;     // Catch: Exception -> L37
        com.ss.ugc.effectplatform.download.f r10 = r9.d;     // Catch: Exception -> L37
        String r11 = r9.c;     // Catch: Exception -> L37
        INetworkClient r12 = r10.a;     // Catch: Exception -> L37
        if ((r12 instanceof com.ss.ugc.effectplatform.bridge.network.b) == true) goto L33;
        r12 = null;
    L33:
        com.ss.ugc.effectplatform.bridge.network.b r13 = (com.ss.ugc.effectplatform.bridge.network.b) r12;     // Catch: Exception -> L37
        if (r13 == null) goto L29;
        r13.pause(r11);     // Catch: Exception -> L37
        goto L29
    L48:
        return;
    L37:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        if (r4.b == false) goto L13;
        if (r4.d == false) goto L13;
        r2 = true;
    L15:
        r3 = null;
        goto L17
    }

    public final void l(String[] r11) {
        boolean r1 = true;
        ArrayList<ModelInfo> r2 = f(this.t, r11, true);     // Catch: Exception -> L25
        String r4 = null;
        if ((!r2.isEmpty()) != true) goto L14;
        StringBuilder r3 = new StringBuilder();     // Catch: Exception -> L25
        Iterator<ModelInfo> r7 = r2.iterator();     // Catch: Exception -> L25
    L8:
        if (r7.hasNext() == false) goto L10;
        r3.append(r7.next().getName() + ", ");     // Catch: Exception -> L25
        goto L8
    L10:
        this.j.a = Integer.valueOf(r2.size());     // Catch: Exception -> L25
        Logger r8 = Logger.INSTANCE;     // Catch: Exception -> L25
        StringBuilder r9 = new StringBuilder();     // Catch: Exception -> L25
        r9.append("[模型][下载][Effect_ID:");     // Catch: Exception -> L25
        Effect r6 = this.y;     // Catch: Exception -> L25
        if (r6 == null) goto L13;
        r4 = r6.getEffect_id();     // Catch: Exception -> L25
    L13:
        r9.append(r4);     // Catch: Exception -> L25
        r9.append("][");     // Catch: Exception -> L25
        r9.append(this.u);     // Catch: Exception -> L25
        r9.append("][");     // Catch: Exception -> L25
        r9.append(r3);     // Catch: Exception -> L25
        r9.append("][数量:");     // Catch: Exception -> L25
        r9.append(r2.size());     // Catch: Exception -> L25
        r9.append(']');     // Catch: Exception -> L25
        r8.w("JKL", r9.toString());     // Catch: Exception -> L25
    L18:
        com.ss.ugc.effectplatform.a r5 = this.v;     // Catch: Exception -> L25
        if (r5 != null) goto L21;
    L23:
        int r10 = b0.a.a;     // Catch: Exception -> L25
        long r12 = System.currentTimeMillis();     // Catch: Exception -> L25
        i(this.y, r2);     // Catch: Exception -> L25
        this.g.a = Long.valueOf(System.currentTimeMillis() - r12);     // Catch: Exception -> L25
        return;
    L21:
        if (r5.a(this.y) != true) goto L23;
        j(this.y, r2);     // Catch: Exception -> L25
        return;
    L14:
        Logger r13 = Logger.INSTANCE;     // Catch: Exception -> L25
        StringBuilder r14 = new StringBuilder("[模型][下载][Effect_ID:");     // Catch: Exception -> L25
        Effect r15 = this.y;     // Catch: Exception -> L25
        if (r15 == null) goto L17;
        r4 = r15.getEffect_id();     // Catch: Exception -> L25
    L17:
        r14.append(r4);     // Catch: Exception -> L25
        r14.append("][");     // Catch: Exception -> L25
        r14.append(this.u);     // Catch: Exception -> L25
        r14.append("][均下载完毕]");     // Catch: Exception -> L25
        r13.w("JKL", r14.toString());     // Catch: Exception -> L25
    L25:
        e = move-exception;
        Logger.INSTANCE.e("JKL", "[Model][Error]" + ArraysKt.toList(r11) + " exception happens!", e);
        f r0 = this.w;
        if (r0 == null) goto L29;
        r0.a(new fetchModel.3(this));
    L29:
        int r16 = r11.length;
        int r17 = 0;
    L30:
        if (r17 >= r16) goto L35;
        if (m(r11[r17]) == false) goto L33;
        r17 = r17 + 1;
        goto L30
    L33:
        r1 = false;
    L35:
        if (r1 == true) goto L42;
        throw e;
    }

    public final boolean m(String r5) {
        boolean r0 = this.q.b(r5);
        if (r0 == false) goto L5;
        Logger.INSTANCE.d("effect_platform", "model: " + r5 + " is built in resource");
    L5:
        return r0;
    }

    public static Effect q(Effect r81, ModelInfo r82) {
        if (r81 != null) goto L6;
        Effect r15 = new Effect(null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, false, null, false, null, null, 0, null, null, 0, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, null, 0, null, null, 0, null, null, 0, 0, 0, -1, -1, 15, null);
        r15.setName(r82.getName());
        return r15;
    L6:
        return r81;
    }

    public final long h(ModelInfo r19, FetchModelType r20) {
        INetworkClient r3 = (INetworkClient) this.o.u.a;
        if (r3 == null) goto L103;
        com.ss.ugc.effectplatform.cache.a r5 = this.r;
        com.ss.ugc.effectplatform.download.a r4 = new com.ss.ugc.effectplatform.download.a(r5, r3);
        com.ss.ugc.effectplatform.a r6 = this.v;
        boolean r7 = false;
        if (r6 != null) goto L7;
    L67:
        r4.a = r19;
        ExtendedUrlModel r8 = r19.getFile_url();
        r4.b = r20;
        if (r8 == null) goto L74;
        List<String> r9 = r8.getUrl_list();
        if (r9 == null) goto L74;
        if (r9.isEmpty() != true) goto L74;
        r4.b = FetchModelType.ZIP;
    L74:
        if (r8 == null) goto L80;
        List<String> r10 = r8.getZip_url_list();
        if (r10 == null) goto L80;
        if (r10.isEmpty() != true) goto L80;
        r4.b = FetchModelType.ORIGIN;
    L80:
        ExtendedUrlModel r11 = r19.getFile_url();
        if (r11 == null) goto L83;
        List<String> r12 = r11.getUrl(r20);
    L84:
        List<String> r13 = r12;
        if (r13 != null) goto L87;
    L88:
        r7 = true;
    L89:
        if (r7 == true) goto L102;
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        r1.element = null;
        Iterator<String> r2 = r12.iterator();
    L92:
        if (r2.hasNext() == false) goto L96;
        long r14 = r4.d.a(r2.next(), new com.ss.ugc.effectplatform.download.b(r1));
        if (r14 <= 0) goto L92;
        return r14;
    L96:
        Exception r15 = (Exception) r1.element;
        if (r15 != null) goto L100;
    L98:
        return -1;
    L100:
        throw r15;
    L102:
        throw new RuntimeException("model " + r19.getName() + " download url is empty! type: " + r20);
    L87:
        if (r13.isEmpty() == false) goto L89;
    L83:
        r12 = null;
        goto L84
    L7:
        if (r6.a(this.y) != true) goto L67;
        this.n.add(new a(r19, r4));
        Logger.INSTANCE.d("JKL", "[请求下载][模型][" + this.u + "][" + ilc.b.a(r19) + "][" + r19.getName() + ']');
        StringBuilder r16 = new StringBuilder();
        r16.append(this.u);
        r16.append('-');
        r16.append(r19.getName());
        String r17 = r16.toString();
        r4.a = r19;
        ExtendedUrlModel r18 = r19.getFile_url();
        r4.b = r20;
        if (r18 == null) goto L15;
        List<String> r110 = r18.getUrl_list();
        if (r110 == null) goto L15;
        if (r110.isEmpty() != true) goto L15;
        r4.b = FetchModelType.ZIP;
    L15:
        if (r18 == null) goto L21;
        List<String> r21 = r18.getZip_url_list();
        if (r21 == null) goto L21;
        if (r21.isEmpty() != true) goto L21;
        r4.b = FetchModelType.ORIGIN;
    L21:
        ExtendedUrlModel r22 = r19.getFile_url();
        if (r22 == null) goto L24;
        List<String> r23 = r22.getUrl(r20);
    L25:
        List<String> r24 = r23;
        if (r24 != null) goto L28;
    L31:
        boolean r111 = true;
    L32:
        if (r111 == true) goto L66;
        Ref.ObjectRef r25 = new Ref.ObjectRef();
        r25.element = null;
        ArrayList r112 = new ArrayList();
        r112.addAll(r24);
        r4.c = (String) ListProtector.remove(r112, 0);
        FetchModelType r26 = r4.b;
        if (r26 == null) goto L64;
        ModelInfo r27 = r4.a;
        if (r27 == null) goto L62;
        r5.getClass();
        String r28 = r27.getName();
        if (r5.k.V == false) goto L40;
        r28 = bytekn.foundation.utils.c.a(r28);
    L40:
        r27.setName(r28);
        String r29 = k.a(r27);
        com.ss.ugc.effectplatform.cache.disklrucache.a.w.getClass();
        String r30 = com.ss.ugc.effectplatform.cache.disklrucache.a.C0011a.c(r29);
        int r31 = com.ss.ugc.effectplatform.cache.b.b[r26.ordinal()];
        if (r31 != 1) goto L43;
        String r32 = r5.c + FileManager.a + r30;
    L48:
        NetResponse r33 = r4.d.b(r4.c, r32, r112, r17, new com.ss.ugc.effectplatform.download.c(r25));
        if (r33.getStatusCode() != 200) goto L52;
        return r33.getContentLength();
    L52:
        if (r33.getStatusCode() != 206) goto L55;
        return -2;
    L55:
        if (r33.getStatusCode() != 600) goto L57;
        return -3;
    L57:
        Exception r34 = (Exception) r25.element;
        if (r34 == null) goto L98;
        throw r34;
    L43:
        if (r31 != 2) goto L46;
        r32 = r5.c + FileManager.a + r30;
        goto L48
    L46:
        throw new NoWhenBranchMatchedException();
    L62:
        throw new IllegalArgumentException("modelInfo is required!");
    L64:
        throw new IllegalArgumentException("fetchModelType is required!");
    L66:
        throw new RuntimeException("model " + r19.getName() + " download url is empty! type: " + r20);
    L28:
        if (r24.isEmpty() == true) goto L31;
        r111 = false;
        goto L32
    L24:
        r23 = null;
        goto L25
    L103:
        return -4;
    }

    public final void i(Effect r19, ArrayList<ModelInfo> r20) {
        String r10 = "";
        int r0 = l.a;
        boolean r11 = true;
        if (l.a(this.o.G) == false) goto L5;
    L9:
        Iterator<ModelInfo> r12 = r20.iterator();
    L11:
        if (r12.hasNext() == false) goto L59;
        ModelInfo r13 = r12.next();
        Logger.INSTANCE.d("effect_platform", "download model: " + r13.getName() + ", version: " + r13.getVersion());
        b0.a.a();
        boolean r1 = false;
        this.o.getClass();     // Catch: Throwable -> L37 Exception -> L39
        long r4 = b0.a.a();     // Catch: Throwable -> L37 Exception -> L39
        String r2 = ilc.b.a(r13);     // Catch: Throwable -> L21 Exception -> L35
    L15:
        if (r2 == null) goto L24;
        ConcurrentHashMap<String, Pair<c0.b, Object>> r3 = llc.a.a;     // Catch: Throwable -> L21 Exception -> L35
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L21 Exception -> L35
        String r6 = this.u;     // Catch: Throwable -> L21 Exception -> L35
        if (r6 != null) goto L20;
        r6 = "";
    L20:
        r5.append(r6);     // Catch: Throwable -> L21 Exception -> L35
        r5.append(r13.getName());     // Catch: Throwable -> L21 Exception -> L35
        llc.a.b(r2, r5.toString());     // Catch: Throwable -> L21 Exception -> L35
    L24:
        if ((!f(this.t, new String[]{r13.getName()}, false).isEmpty()) != true) goto L29;
        long r7 = h(r13, this.o.H);     // Catch: Throwable -> L21 Exception -> L35
        if (r7 <= 0) goto L28;
        a0.b<Long> r8 = this.h;     // Catch: Throwable -> L21 Exception -> L35
        long r9 = ((Number) r8.a).longValue();     // Catch: Throwable -> L21 Exception -> L35
        int r14 = elc.a.a;     // Catch: Throwable -> L21 Exception -> L35
        long r15 = 1024;
        r8.a = Long.valueOf(r9 + (r7 / r15));     // Catch: Throwable -> L21 Exception -> L35
        o(q(r19, r13), r13, r4, r7 / r15);     // Catch: Throwable -> L21 Exception -> L35
    L30:
        String r16 = ilc.b.a(r13);
        if (r16 == null) goto L11;
        ConcurrentHashMap<String, Pair<c0.b, Object>> r17 = llc.a.a;
        StringBuilder r18 = new StringBuilder();
        String r21 = this.u;
        if (r21 != null) goto L48;
    L47:
        r21 = "";
    L48:
        r18.append(r21);
        r18.append(r13.getName());
        llc.a.a(r16, r18.toString());
        goto L11
    L28:
        RuntimeException r22 = new RuntimeException("download model fail, downloadFileSize = " + r7);     // Catch: Throwable -> L21 Exception -> L35
        n(q(r19, r13), r13, r22);     // Catch: Throwable -> L21 Exception -> L35
        p(r13, r22);     // Catch: Throwable -> L21 Exception -> L35
        goto L30
    L29:
        o(q(r19, r13), r13, r4, 0);     // Catch: Throwable -> L21 Exception -> L35
    L35:
        e = e;
        r1 = true;
    L60:
        n(q(r19, r13), r13, e);     // Catch: Throwable -> L49
        p(r13, e);     // Catch: Throwable -> L49
        if (r1 == false) goto L11;
        r16 = ilc.b.a(r13);
        if (r16 == null) goto L11;
        ConcurrentHashMap<String, Pair<c0.b, Object>> r23 = llc.a.a;
        r18 = new StringBuilder();
        r21 = this.u;
        if (r21 == null) goto L47;
    L49:
        th = th;
        r11 = r1;
    L51:
        if (r11 == false) goto L58;
        String r24 = ilc.b.a(r13);
        if (r24 == null) goto L58;
        ConcurrentHashMap<String, Pair<c0.b, Object>> r25 = llc.a.a;
        StringBuilder r26 = new StringBuilder();
        String r27 = this.u;
        if (r27 == null) goto L57;
        r10 = r27;
    L57:
        r26.append(r10);
        r26.append(r13.getName());
        llc.a.a(r24, r26.toString());
    L58:
        throw th;
    L21:
        th = th;
        goto L51
    L39:
        e = e;
    L37:
        th = th;
        r11 = false;
        goto L51
    L59:
        return;
    L5:
        if ((!r20.isEmpty()) == false) goto L9;
        Logger.e$default(Logger.INSTANCE, "effect_platform", "download " + CollectionsKt.toList(r20) + " failed!, network unavailable!", null, 4, null);
        throw new NetException(10011, "network unavailable");
    }

    public final void j(Effect r12, ArrayList<ModelInfo> r13) {
        int r0 = b0.a.a;
        long r7 = System.currentTimeMillis();
        int r1 = l.a;
        if (l.a(this.o.G) == true) goto L10;
        if ((!r13.isEmpty()) == false) goto L10;
        Logger.e$default(Logger.INSTANCE, "effect_platform", "download " + CollectionsKt.toList(r13) + " failed!, network unavailable!", null, 4, null);
        throw new NetException(10011, "network unavailable");
    L10:
        if (r13.size() != 0) goto L15;
        f r14 = this.w;
        if (r14 == null) goto L39;
        r14.a(new downloadAndUpdateModelList2.1(this));
        return;
    L39:
        return;
    L15:
        this.m.c(r13.size());
        bytekn.foundation.concurrent.executor.a r2 = this.x;
        if (r2 != null) goto L19;
        r2 = glc.a.a(5, 15000);
    L19:
        h r3 = this.k;
        if (r3 == null) goto L22;
        r3.a = null;
    L22:
        Iterator<ModelInfo> r15 = r13.iterator();
    L24:
        if (r15.hasNext() == false) goto L31;
        ModelInfo r4 = r15.next();
        com.ss.ugc.effectplatform.a r5 = this.v;
        if (r5 == null) goto L30;
        if (r5.a != true) goto L30;
        k(r4, r12, r7);
    L30:
        r2.execute(new b(this, r4, r12, r7));
        goto L24
    }

    public final void p(ModelInfo r10, Exception r11) {
        Logger.INSTANCE.e("effect_platform", "model::" + r10.getName() + ",info.getVersion() = " + r10.getVersion() + ", size = " + String.valueOf(r10.getType()) + " download failure", r11);
        com.ss.ugc.effectplatform.model.d r0 = this.r.i(r10.getName());
        if (r0 == null) goto L21;
        boolean r1 = k.a;
        String r2 = r0.d();
        if (r2 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        String r12 = r10.getVersion();
        boolean r8 = false;
        if (r.b(r2) == false) goto L10;
    L18:
        if (r8 == false) goto L20;
        return;
    L20:
        throw r11;
    L10:
        if (r.b(r12) == true) goto L18;
        if (r.a(r2, r12) == false) goto L22;
        r8 = true;
        goto L18
    L22:
        r8 = r.a(r2.substring(0, StringsKt.indexOf$default(r2, ".", 0, false, 6, null)), r12.substring(0, StringsKt.indexOf$default(r2, ".", 0, false, 6, null)));     // Catch: Exception -> L17
        goto L18
    L21:
        throw r11;
    }

    public final ArrayList<ModelInfo> f(int r2, String[] r3, boolean r4) {
        x0 r0 = this.p;
        if (r0 == null) goto L9;
        com.ss.ugc.effectplatform.model.c r5 = r0.a(r2, r4);
        if (r5 == null) goto L9;
        return g(r2, r3, r5);
    L9:
        throw new RuntimeException("model list with " + r2 + " not found!");
    }

    public final ArrayList<ModelInfo> g(int r33, String[] r34, com.ss.ugc.effectplatform.model.c r35) {
        ArrayList<ModelInfo> r5 = new ArrayList();
        int r6 = r34.length;
        boolean r7 = false;
        int r8 = 0;
    L3:
        if (r8 >= r6) goto L87;
        String r9 = r34[r8];
        String r10 = k.d(r9);
        if (this.o.V == false) goto L8;
        String r0 = bytekn.foundation.utils.c.a(r10);     // Catch: Exception -> L26
    L9:
        x0 r12 = this.p;     // Catch: Exception -> L26
        if (r12 == null) goto L12;
        z.b<String, com.ss.ugc.effectplatform.model.c> r13 = x0.h;     // Catch: Exception -> L26
        com.ss.ugc.effectplatform.model.c r14 = r12.a(r33, r7);     // Catch: Exception -> L26
    L13:
        if (r14 == null) goto L17;
        bytekn.foundation.utils.d<String, com.ss.ugc.effectplatform.model.c.a> r15 = r14.a;     // Catch: Exception -> L26
        if (r15 == null) goto L17;
        Collection r16 = r15.b();     // Catch: Exception -> L26
    L18:
        if (r16 == null) goto L28;
        Iterator r17 = r16.iterator();     // Catch: Exception -> L26
    L21:
        if (r17.hasNext() == false) goto L28;
        com.ss.ugc.effectplatform.model.c.a r18 = (com.ss.ugc.effectplatform.model.c.a) r17.next();     // Catch: Exception -> L26
        if (Intrinsics.areEqual(r18.a.getName(), r0) == false) goto L21;
        ModelInfo r1 = r18.a;     // Catch: Exception -> L26
    L30:
        if (r1 != null) goto L45;
        Logger r19 = Logger.INSTANCE;
        r19.d("effect_platform", r10 + " not exist in server");
        x0 r11 = this.p;
        if (r11 == null) goto L34;
        ModelInfo r110 = r11.d(r33, r10, r7);
    L35:
        if (r110 == null) goto L37;
    L42:
        if (r110 != null) goto L44;
        Logger.e$default(r19, "effect_platform", "model: " + r10 + " fetched failed!", null, 4, null);
        goto L45
    L44:
        r1 = r110;
        boolean r20 = true;
    L46:
        if (r1 == null) goto L86;
        String r111 = r1.getVersion();
        int r112 = r1.getType();
        if (m(r9) == false) goto L59;
        float r113 = CastFloatProtector.parseFloat(k.f(r9));
        float r114 = CastFloatProtector.parseFloat(r111);
        int r21 = k.e(r9);
        if (Float.compare(r113, r114) != 0) goto L52;
        boolean r115 = true;
    L53:
        if (r21 != r112) goto L55;
        boolean r22 = true;
    L56:
        if (r115 == false) goto L59;
        if (r22 == false) goto L59;
    L84:
        r8 = r8 + 1;
        r7 = false;
        goto L3
    L55:
        r22 = false;
        goto L56
    L52:
        r115 = false;
    L59:
        com.ss.ugc.effectplatform.model.d r23 = this.r.i(r10);
        if (r23 != null) goto L62;
        Logger.INSTANCE.d("effect_platform", "local model is null with name: " + r10);
    L62:
        if (r23 == null) goto L73;
        int r116 = r.a;
        if (r.a(r23.d(), r1.getVersion()) == true) goto L68;
        Logger.INSTANCE.d("effect_platform", "model " + r23.b() + " version not equals, local model version:" + r23.d() + ", lastest model: " + r1.getVersion());
        goto L73
    L68:
        if (r23.c() == r1.getType()) goto L71;
        Logger.INSTANCE.d("effect_platform", "model " + r23.b() + " size not equals, local model size:" + r23.c() + ", lastest model: " + r1.getType());
        goto L73
    L71:
        if (r.a(r23.a(), ilc.b.a(r1)) == true) goto L74;
        Logger.INSTANCE.d("effect_platform", "model " + r23.b() + " md5 not equals, local model size:" + r23.a() + ", lastest model: " + ilc.b.a(r1));
        goto L73
    L74:
        boolean r117 = false;
    L75:
        if (r117 == false) goto L84;
        if (this.o.V == false) goto L79;
        r10 = bytekn.foundation.utils.c.a(r10);
    L79:
        if (r20 == false) goto L81;
        ExtendedUrlModel r2 = r1.getFile_url();
    L82:
        ModelInfo r24 = new ModelInfo(null, null, null, null, 0, 0, 0, 127, null);
        r24.setName(r10);
        r24.setVersion(r111);
        r24.setFile_url(r2);
        r24.setType(r112);
        r5.add(r24);
        goto L84
    L81:
        r2 = r35.a(r10);
    L73:
        r117 = true;
        goto L75
    L86:
        throw new RuntimeException("model: " + r9 + " - " + r10 + " not exist in server");
    L37:
        if (a0.a.a() == true) goto L42;
        r19.w("JKL", "[Model][not in server list][fetch single model][" + r9 + "][" + r10 + ']');
        x0 r25 = this.p;
        if (r25 == null) goto L41;
        r110 = r25.c(r33, r10);
        goto L42
    L41:
        r110 = null;
        goto L42
    L34:
        r110 = null;
    L45:
        r20 = false;
    L28:
        r1 = null;
    L17:
        r16 = null;
        goto L18
    L12:
        r14 = null;
        goto L13
    L8:
        r0 = r10;
    L26:
        e = move-exception;
        Logger.INSTANCE.e("effect_platform", "exception happens in getLatestModelInfo", e);
        goto L28
    L87:
        return r5;
    }

    public final void k(ModelInfo r28, Effect r29, long r30) {
        String r12 = "";
        Logger r15 = Logger.INSTANCE;
        r15.d("effect_platform", "download model: " + r28.getName() + ", version: " + r28.getVersion());
    L113:
        e = e;
        String r16 = "";
        boolean r2 = false;
    L170:
        Logger.e$default(Logger.INSTANCE, "LLL", "[报错][" + this.u + "][" + ilc.b.a(r28) + "][模型" + r28.getName() + "][Msg:" + e.getMessage() + ']', null, 4, null);     // Catch: Throwable -> L140
        n(q(r29, r28), r28, e);     // Catch: Throwable -> L138
        h r3 = this.k;     // Catch: Throwable -> L138
        if (r3 == null) goto L122;
        r3.a = e;     // Catch: Throwable -> L138
    L122:
        if (r2 == false) goto L130;
        String r0 = ilc.b.a(r28);
        if (r0 == null) goto L130;
        ConcurrentHashMap<String, Pair<c0.b, Object>> r4 = llc.a.a;
        StringBuilder r5 = new StringBuilder();
        String r6 = this.u;
        if (r6 == null) goto L128;
        String r13 = r6;
    L129:
        r5.append(r13);
        r5.append(r28.getName());
        llc.a.a(r0, r5.toString());
        goto L130
    L128:
        r13 = r16;
    L130:
        this.m.a();
        if (this.m.b() != 0) goto L182;
        f r1 = this.w;
        if (r1 == null) goto L135;
        r1.a(new downloadModel.3(this));
    L135:
        a0.b<Long> r7 = this.g;
        int r8 = b0.a.a;
    L136:
        r7.a = Long.valueOf(System.currentTimeMillis() - r30);
        return;
    L182:
        return;
    L138:
        th = th;
    L142:
        if (r2 == false) goto L150;
        String r9 = ilc.b.a(r28);
        if (r9 == null) goto L150;
        ConcurrentHashMap<String, Pair<c0.b, Object>> r10 = llc.a.a;
        StringBuilder r11 = new StringBuilder();
        String r14 = this.u;
        if (r14 == null) goto L148;
        String r17 = r14;
    L149:
        r11.append(r17);
        r11.append(r28.getName());
        llc.a.a(r9, r11.toString());
        goto L150
    L148:
        r17 = r16;
    L150:
        this.m.a();
        if (this.m.b() != 0) goto L156;
        f r18 = this.w;
        if (r18 == null) goto L155;
        r18.a(new downloadModel.3(this));
    L155:
        a0.b<Long> r19 = this.g;
        int r20 = b0.a.a;
        r19.a = Long.valueOf(System.currentTimeMillis() - r30);
    L156:
        throw th;
    L140:
        th = th;
    L111:
        th = th;
        r16 = "";
        r2 = false;
        goto L142
    L5:
        if (this.b == false) goto L16;
        r15.w("JKL", "[模型][暂停][" + this.u + "][" + r28.getName() + "][任务已被标注为暂停/取消,无需继续执行]");     // Catch: Throwable -> L111 Exception -> L113
        this.m.a();
        if (this.m.b() != 0) goto L179;
        f r21 = this.w;
        if (r21 == null) goto L12;
        r21.a(new downloadModel.3(this));
    L12:
        a0.b<Long> r22 = this.g;
        int r23 = b0.a.a;
        r22.a = Long.valueOf(System.currentTimeMillis() - r30);
        return;
    L179:
        return;
    L16:
        b0.a.a();     // Catch: Throwable -> L111 Exception -> L113
        this.o.getClass();     // Catch: Throwable -> L111 Exception -> L113
        long r110 = b0.a.a();     // Catch: Throwable -> L111 Exception -> L113
        this.l.a.incrementAndGet();     // Catch: Throwable -> L105 Exception -> L107
        String r24 = ilc.b.a(r28);     // Catch: Throwable -> L105 Exception -> L107
        if (r24 == null) goto L25;
        ConcurrentHashMap<String, Pair<c0.b, Object>> r111 = llc.a.a;     // Catch: Throwable -> L105 Exception -> L107
        StringBuilder r25 = new StringBuilder();     // Catch: Throwable -> L105 Exception -> L107
        String r26 = this.u;     // Catch: Throwable -> L76 Exception -> L107
        if (r26 != null) goto L24;
        r26 = "";
    L24:
        r25.append(r26);     // Catch: Throwable -> L76 Exception -> L107
        r25.append(r28.getName());     // Catch: Throwable -> L76 Exception -> L107
        llc.a.b(r24, r25.toString());     // Catch: Throwable -> L76 Exception -> L107
    L76:
        th = th;
    L102:
        r16 = "";
    L109:
        r2 = true;
    L25:
        this.l.a();     // Catch: Throwable -> L105 Exception -> L107
        long r27 = System.currentTimeMillis();     // Catch: Throwable -> L105 Exception -> L107
        if (this.b == false) goto L41;
        r15.w("JKL", "[模型][暂停][" + this.u + "][" + r28.getName() + "][任务已被标注为暂停/取消,无需继续执行]");     // Catch: Throwable -> L76 Exception -> L107
        String r31 = ilc.b.a(r28);
        if (r31 == null) goto L34;
        ConcurrentHashMap<String, Pair<c0.b, Object>> r32 = llc.a.a;
        StringBuilder r33 = new StringBuilder();
        String r34 = this.u;
        if (r34 == null) goto L33;
        r12 = r34;
    L33:
        r33.append(r12);
        r33.append(r28.getName());
        llc.a.a(r31, r33.toString());
    L34:
        this.m.a();
        if (this.m.b() != 0) goto L180;
        f r35 = this.w;
        if (r35 == null) goto L39;
        r35.a(new downloadModel.3(this));
    L39:
        this.g.a = Long.valueOf(System.currentTimeMillis() - r30);
        return;
    L180:
        return;
    L41:
        if ((!f(this.t, new String[]{r28.getName()}, false).isEmpty()) != true) goto L82;
    L78:
        e = e;
    L80:
        r16 = "";
    L110:
        r2 = true;
        goto L170
    L164:
    L74:
        e = e;
        goto L80
    L47:
        long r36 = h(r28, this.o.H);     // Catch: Throwable -> L76 Exception -> L78
        StringBuilder r37 = new StringBuilder("[下载成功][");     // Catch: Throwable -> L76 Exception -> L78
        r37.append(this.u);     // Catch: Throwable -> L76 Exception -> L78
        r37.append("][");     // Catch: Throwable -> L76 Exception -> L78
        r37.append(ilc.b.a(r28));     // Catch: Throwable -> L76 Exception -> L78
        r37.append("][模型");     // Catch: Throwable -> L76 Exception -> L78
        r37.append(r28.getName());     // Catch: Throwable -> L76 Exception -> L78
        r37.append("][耗时:");     // Catch: Throwable -> L76 Exception -> L78
        r37.append(System.currentTimeMillis() - r27);     // Catch: Throwable -> L76 Exception -> L78
        r37.append("][");     // Catch: Throwable -> L76 Exception -> L78
        r37.append(r36);     // Catch: Throwable -> L76 Exception -> L78
        r37.append(']');     // Catch: Throwable -> L76 Exception -> L78
        r15.d("LLL", r37.toString());     // Catch: Throwable -> L76 Exception -> L78
        if (r36 <= 0) goto L65;
        a0.b<Long> r38 = this.h;     // Catch: Exception -> L62 Throwable -> L76
    L60:
        e = e;
        goto L80
    L55:
        long r39 = ((Number) r38.a).longValue();     // Catch: Exception -> L62 Throwable -> L76
        int r40 = elc.a.a;     // Catch: Exception -> L62 Throwable -> L76
        long r41 = 1024;
        r38.a = Long.valueOf(r39 + (r36 / r41));     // Catch: Exception -> L60 Throwable -> L76
        o(q(r29, r28), r28, r110, r36 / r41);     // Catch: Exception -> L71 Throwable -> L101
    L158:
    L73:
        r16 = "";
    L84:
        String r42 = ilc.b.a(r28);
        if (r42 == null) goto L91;
        ConcurrentHashMap<String, Pair<c0.b, Object>> r43 = llc.a.a;
        StringBuilder r44 = new StringBuilder();
        String r45 = this.u;
        if (r45 == null) goto L89;
        String r112 = r45;
    L90:
        r44.append(r112);
        r44.append(r28.getName());
        llc.a.a(r42, r44.toString());
        goto L91
    L89:
        r112 = r16;
    L91:
        this.m.a();
        if (this.m.b() != 0) goto L181;
        f r46 = this.w;
        if (r46 == null) goto L96;
        r46.a(new downloadModel.3(this));
    L96:
        r7 = this.g;
        goto L136
    L181:
        return;
    L62:
        e = e;
        goto L80
    L65:
        if (r36 == (-2)) goto L73;
        if (r36 == (-3)) goto L73;
        Logger.e$default(r15, "JKL", "[Model][Error][FileSize : " + r36 + ']', null, 4, null);     // Catch: Throwable -> L101 Exception -> L103
        RuntimeException r47 = new RuntimeException("download model fail, downloadFileSize = " + r36);     // Catch: Throwable -> L101 Exception -> L103
        n(q(r29, r28), r28, r47);     // Catch: Throwable -> L101 Exception -> L103
        p(r28, r47);     // Catch: Throwable -> L101 Exception -> L103
    L71:
        e = e;
        goto L80
    L82:
        r16 = "";
        o(q(r29, r28), r28, r110, 0);     // Catch: Exception -> L97 Throwable -> L99
        r15.w("LLL", "[下载成功][" + this.u + "][" + ilc.b.a(r28) + "][模型" + r28.getName() + "][耗时:" + (System.currentTimeMillis() - r27) + "][不重复下载了!]");     // Catch: Exception -> L97 Throwable -> L99
    L97:
        e = e;
    L99:
        th = th;
    L103:
        e = e;
    L101:
        th = th;
    L107:
        e = e;
        r16 = "";
    L105:
        th = th;
        r16 = "";
        goto L109
    }

    public final void n(Effect r17, ModelInfo r18, Exception r19) {
        ExceptionResult r1 = new ExceptionResult(r19);
        ExtendedUrlModel r3 = r18.getFile_url();
        String r4 = null;
        boolean r5 = true;
        if (r3 == null) goto L12;
        List<String> r6 = r3.getUrl_list();
        if (r6 == null) goto L12;
        if ((!r6.isEmpty()) == true) goto L10;
        r6 = null;
    L10:
        if (r6 == null) goto L12;
        r4 = (String) ListProtector.get(r6, 0);
    L12:
        EffectConfig r9 = this.o;
        klc.a r7 = (klc.a) r9.v.a;
        if (r7 == null) goto L28;
        String r11 = r18.getName();
        String r12 = r18.getVersion();
        String r13 = this.o.H.toString();
        Pair[] r8 = new Pair[2];
        r8[0] = TuplesKt.to("error_code", Integer.valueOf(r1.getErrorCode()));
        if (r4 != null) goto L18;
        r4 = "";
    L18:
        r8[1] = TuplesKt.to("download_url", r4);
        Map r14 = MapsKt.mapOf(r8);
        String r2 = r19.getMessage();
        if (r2 != null) goto L21;
    L24:
        if (r5 == false) goto L26;
        String r10 = Reflection.getOrCreateKotlinClass(r19.getClass()).getQualifiedName();
    L27:
        klc.b.i(r7, false, r9, r17, r11, r12, r13, r14, r10);
        goto L28
    L26:
        r10 = r19.getMessage();
        goto L27
    L21:
        if (StringsKt.isBlank(r2) == true) goto L24;
        r5 = false;
    L28:
        this.o.getClass();
    }

    public final void o(Effect r16, ModelInfo r17, long r18, long r20) {
        Logger r2 = Logger.INSTANCE;
        r2.d("effect_platform", "model::" + r17.getName() + ",version = " + r17.getVersion() + ",size = " + String.valueOf(r17.getType()) + " download success!");
        long r3 = b0.a.a() - r18;
        EffectConfig r7 = this.o;
        klc.a r5 = (klc.a) r7.v.a;
        if (r5 == null) goto L5;
        klc.b.i(r5, true, r7, r16, r17.getName(), r17.getVersion(), this.o.H.toString(), MapsKt.mapOf(new Pair[]{TuplesKt.to("size", Long.valueOf(r20)), TuplesKt.to("duration", Long.valueOf(r3))}), "");
    L5:
        int r4 = elc.a.a;
        r17.setTotalSize(r20 / ((long) 1024));
        this.o.getClass();
        e r6 = com.ss.ugc.effectplatform.algorithm.c.a;
        int r8 = n.a;
        if (PlatformType.ANDROID == PlatformType.PC) goto L20;
        String r9 = r17.getName();
        String r10 = "";
        com.ss.ugc.effectplatform.model.d r11 = new com.ss.ugc.effectplatform.model.d("");
        r11.a = r9;
        String r12 = ilc.b.a(r17);
        if (r12 == null) goto L11;
        r10 = r12;
    L11:
        r11.c = r10;
        r11.d = r17.getType();
        r11.b = r17.getVersion();
        r11.e = false;
        com.ss.ugc.effectplatform.algorithm.h r13 = new com.ss.ugc.effectplatform.algorithm.h(r11, r17);
        e r14 = com.ss.ugc.effectplatform.algorithm.c.a;
        r14.a();
        r2.d("AlgorithmModelInfoMemoryCache", "model: " + r9 + " write in cache!");     // Catch: Throwable -> L15
        com.ss.ugc.effectplatform.algorithm.c.b.put(r9, r13);     // Catch: Throwable -> L15
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r14.b();
        return;
    L15:
        th = move-exception;
        r14.b();
        throw th;
    }

    public /* synthetic */ FetchModelTask(EffectConfig r16, x0 r17, com.ss.ugc.effectplatform.algorithm.d r18, com.ss.ugc.effectplatform.cache.a r19, String[] r20, int r21, String r22, com.ss.ugc.effectplatform.a r23, Effect r24, int r25) {
        if ((r25 & 16) == 0) goto L5;
        String[] r8 = null;
    L7:
        if ((r25 & 32) == 0) goto L9;
        int r9 = 0;
    L11:
        if ((r25 & 64) == 0) goto L13;
        String r10 = null;
    L15:
        if ((r25 & 128) == 0) goto L17;
        com.ss.ugc.effectplatform.a r11 = null;
    L19:
        if ((r25 & 1024) == 0) goto L21;
        Effect r14 = null;
    L22:
        this(r16, r17, r18, r19, r8, r9, r10, r11, null, null, r14);
        return;
    L21:
        r14 = r24;
        goto L22
    L17:
        r11 = r23;
        goto L19
    L13:
        r10 = r22;
        goto L15
    L9:
        r9 = r21;
        goto L11
    L5:
        r8 = r20;
        goto L7
    }

    public FetchModelTask(EffectConfig r2, x0 r3, com.ss.ugc.effectplatform.algorithm.d r4, com.ss.ugc.effectplatform.cache.a r5, String[] r6, int r7, String r8, com.ss.ugc.effectplatform.a r9, f r10, bytekn.foundation.concurrent.executor.a r11, Effect r12) {
        super(r8, r2.N);
        this.o = r2;
        this.p = r3;
        this.q = r4;
        this.r = r5;
        this.s = r6;
        this.t = r7;
        this.u = r8;
        this.v = r9;
        this.w = r10;
        this.x = r11;
        this.y = r12;
        this.g = new a0.b(0L);
        this.h = new a0.b(0L);
        this.i = new a0.b(0);
        this.j = new a0.b(0);
        this.l = new c0.b(0);
        this.m = new c0.b(0);
        this.n = new z.a(true);
    }
}
