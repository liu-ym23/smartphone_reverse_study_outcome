package com.ss.ugc.effectplatform.task;

import a0.b;
import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import com.ss.ugc.effectplatform.cache.j;
import com.ss.ugc.effectplatform.cache.k;
import com.ss.ugc.effectplatform.exception.CurrentEditingException;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.UrlModel;
import com.ss.ugc.effectplatform.preload.c;
import com.ss.ugc.effectplatform.repository.d;
import com.ss.ugc.effectplatform.task.algorithm.f;
import com.ss.ugc.effectplatform.task.algorithm.h;
import com.ss.ugc.effectplatform.util.i;
import com.ss.ugc.effectplatform.util.l;
import com.ss.ugc.effectplatform.util.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class y extends o1<nlc.a> {
    public final b<String> d;
    public final b<Long> e;
    public final b<Long> f;
    public final b<Long> g;
    public final Effect h;
    public f i;
    public h j;
    public final blc.b k;
    public final com.ss.ugc.effectplatform.download.f l;
    public final EffectConfig m;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.ugc.effectplatform.task.o1
    public final void a() {
        this.b = true;
        String r1 = (String) this.d.a;
        if (r1 == null) goto L24;
        com.ss.ugc.effectplatform.a r2 = this.k.d;
        if (r2 == null) goto L25;
        Effect r3 = this.h;
        boolean r4 = false;
        if (r3 != null) goto L9;
        boolean r5 = false;
    L10:
        if (r5 == true) goto L12;
    L14:
        if (r4 != true) goto L26;
        com.ss.ugc.effectplatform.download.f r0 = this.l;
        if (r0 == null) goto L27;
        INetworkClient r6 = r0.a;
        if ((r6 instanceof com.ss.ugc.effectplatform.bridge.network.b) == true) goto L20;
        r6 = null;
    L20:
        com.ss.ugc.effectplatform.bridge.network.b r7 = (com.ss.ugc.effectplatform.bridge.network.b) r6;
        if (r7 == null) goto L28;
        r7.cancel(r1);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L12:
        if (r2.b == false) goto L14;
        r4 = true;
        goto L14
    L9:
        r5 = ArraysKt.contains(r2.e, r3.getPanel());
        goto L10
    L25:
        return;
    }

    @Override // com.ss.ugc.effectplatform.task.o1
    public final void j() {
        this.c = true;
        String r1 = (String) this.d.a;
        if (r1 == null) goto L24;
        com.ss.ugc.effectplatform.a r2 = this.k.d;
        if (r2 == null) goto L25;
        Effect r3 = this.h;
        boolean r4 = false;
        if (r3 != null) goto L9;
        boolean r5 = false;
    L10:
        if (r5 == true) goto L12;
    L14:
        if (r4 != true) goto L26;
        com.ss.ugc.effectplatform.download.f r0 = this.l;
        if (r0 == null) goto L27;
        INetworkClient r6 = r0.a;
        if ((r6 instanceof com.ss.ugc.effectplatform.bridge.network.b) == true) goto L20;
        r6 = null;
    L20:
        com.ss.ugc.effectplatform.bridge.network.b r7 = (com.ss.ugc.effectplatform.bridge.network.b) r6;
        if (r7 == null) goto L28;
        r7.pause(r1);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L12:
        if (r2.b == false) goto L14;
        r4 = true;
        goto L14
    L9:
        r5 = ArraysKt.contains(r2.e, r3.getPanel());
        goto L10
    L25:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v14, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.String] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.ugc.effectplatform.task.o1
    public final void b() {
        String r0 = com.ss.ugc.effectplatform.model.b.a(this.h);
        if (r0 == null) goto L5;
        llc.a.b(r0, r0);
    L5:
        Logger r2 = Logger.INSTANCE;
        r2.w("JKL", "[流程][开始][" + this.h.getName() + ']');
        com.ss.ugc.effectplatform.a r1 = this.k.d;
        String r14 = "download: ";
        String r3 = "EffectFetcherTask";
        String r16 = "editor in currently editing!";
        if (r1 == null) goto L143;
        Effect r13 = this.h;
        if (r13 != null) goto L10;
        boolean r15 = false;
    L11:
        if (r15 == true) goto L13;
    L15:
        boolean r4 = false;
    L17:
        if (r4 != true) goto L142;
        int r20 = r.a;
        if (r.b(this.h.getZipPath()) == false) goto L21;
    L24:
        Effect r5 = this.h;
        StringBuilder r17 = new StringBuilder();
        r17.append(this.k.c);
        String r18 = FileManager.a;
        r17.append(r18);
        r17.append(this.h.getId());
        r17.append(".zip");
        r5.setZipPath(r17.toString());
        this.h.setUnzipPath(this.k.c + r18 + this.h.getId());
    L26:
        if (this.m.T == false) goto L44;
        StringBuilder r6 = new StringBuilder();
        r6.append(this.m.j);
        String r8 = FileManager.a;
        r6.append(FileManager.a);
        r6.append(this.h.getId());
        String r7 = r6.toString();
        if (FileManager.d(r7) == false) goto L44;
        r2.w("JKL", "[预加载][读取][特效][检测到已有预加载资源!][" + this.h.getId() + ']');
        this.h.setUnzipPath(r7);
        com.ss.ugc.effectplatform.a r9 = this.k.d;
        if (r9 != null) goto L32;
    L36:
        l(this, new nlc.a(this.h));
        com.ss.ugc.effectplatform.preload.b.a r10 = com.ss.ugc.effectplatform.preload.b.d;
        Object r11 = this.m.G;
        r10.getClass();
        com.ss.ugc.effectplatform.preload.b r12 = com.ss.ugc.effectplatform.preload.b.a.a(r11);
        if (r12 == null) goto L39;
        c r19 = r12.e(this.h.getId());
    L40:
        if (r19 == null) goto L216;
        klc.a r21 = (klc.a) this.m.v.a;
        if (r21 == null) goto L216;
        String r22 = r19.f;
        String r23 = r19.b;
        i r24 = i.a;
        klc.b.l(r21, r22, r23, i.f(r7) / ((long) 1024));
    L216:
        String r25 = com.ss.ugc.effectplatform.model.b.a(this.h);
        if (r25 == null) goto L233;
        llc.a.a(r25, r25);
        return;
    L233:
        return;
    L39:
        r19 = null;
        goto L40
    L32:
        if (r9.a(this.h) != true) goto L36;
        f r26 = this.i;
        if (r26 == null) goto L36;
        r26.b(new EffectFetcherTask.executeImp2.1(this));
    L44:
        k();
        d r27 = this.m.M;
        Effect r28 = this.h;
        int r110 = com.ss.ugc.effectplatform.h.a;
        Boolean r111 = Boolean.TRUE;
        r27.getClass();
        if (d.b(r28, false, r111) == false) goto L60;
        r2.d("EffectFetcherTask", "fetchEffect: " + this.h.getEffect_id() + " name: " + this.h.getName() + " already exists!");
        com.ss.ugc.effectplatform.a r29 = this.k.d;
        if (r29 != null) goto L49;
    L59:
        l(this, new nlc.a(this.h));
        goto L216
    L49:
        if (r29.a(this.h) != true) goto L59;
        f r30 = this.i;
        if (r30 == null) goto L53;
        r30.b(new EffectFetcherTask.executeImp2.3(this));
    L53:
        h r31 = this.j;
        if (r31 == null) goto L56;
        Exception r112 = r31.a;
    L57:
        if (r112 == null) goto L59;
    L56:
        r112 = null;
        goto L57
    L60:
        i(this);
        r2.d("EffectFetcherTask", "download effect: " + this.h.getEffect_id() + ", name: " + this.h.getName() + ", uri: " + this.h.getFile_url().getUri() + " start");
        Ref.ObjectRef r32 = new Ref.ObjectRef();
        r32.element = null;
        int r33 = l.a;
        if (l.a(this.m.G) == true) goto L63;
        d(this, new ExceptionResult(10011));
        goto L216
    L63:
        List<String> r34 = this.k.b;
        if (r34 != null) goto L66;
    L69:
        boolean r35 = true;
    L70:
        if (r35 == true) goto L141;
        com.ss.ugc.effectplatform.util.h r36 = com.ss.ugc.effectplatform.util.h.a;
        UrlModel r37 = this.h.getFile_url();
        r36.getClass();
        if (com.ss.ugc.effectplatform.util.h.c(r37) == true) goto L141;
        if (this.b == false) goto L78;
        d(this, new ExceptionResult(10001, new Exception(String.valueOf(10001))));
        goto L216
    L78:
        if (this.c == false) goto L80;
        d(this, new ExceptionResult(10019, new Exception(String.valueOf(10019))));
        goto L216
    L80:
        r3 = new ArrayList();
        r3.addAll(r34);
        String r113 = (String) ListProtector.remove(r3, 0);
        this.d.a = r113;     // Catch: Exception -> L129
        if (r113 == null) goto L216;
        int r38 = b0.a.a;     // Catch: Exception -> L129
        long r39 = System.currentTimeMillis();     // Catch: Exception -> L129
        r2.d("JKL", "[请求下载][特效][" + this.h.getName() + ']');     // Catch: Exception -> L129
        com.ss.ugc.effectplatform.download.f r114 = this.l;     // Catch: Exception -> L129
        if (r114 == 0) goto L86;
        NetResponse r40 = r114.b(r113, this.h.getZipPath(), r3, this.h.getName() + "-特效", new a0(this, r32));     // Catch: Exception -> L129
    L87:
        StringBuilder r41 = new StringBuilder("[下载成功][特效][");     // Catch: Exception -> L129
        r41.append(this.h.getName());     // Catch: Exception -> L129
        r41.append("][耗时:");     // Catch: Exception -> L129
        r41.append(System.currentTimeMillis() - r39);     // Catch: Exception -> L129
        r41.append("][");     // Catch: Exception -> L129
        if (r40 == null) goto L90;
        Long r42 = Long.valueOf(r40.getContentLength());     // Catch: Exception -> L129
    L91:
        r41.append(r42);     // Catch: Exception -> L129
        r41.append(']');     // Catch: Exception -> L129
        r2.d("JKL", r41.toString());     // Catch: Exception -> L129
        com.ss.ugc.effectplatform.a r43 = this.k.d;     // Catch: Exception -> L129
        if (r43 == null) goto L221;
        if (r43.a(this.h) != true) goto L221;
        f r44 = this.i;     // Catch: Exception -> L129
        if (r44 == null) goto L98;
        r44.b(new EffectFetcherTask.executeImp2.4(this));     // Catch: Exception -> L129
    L98:
        h r45 = this.j;     // Catch: Exception -> L129
        if (r45 == null) goto L101;
        Exception r115 = r45.a;     // Catch: Exception -> L129
    L102:
        if (r115 == null) goto L221;
    L101:
        r115 = null;
    L221:
        if (this.c == true) goto L125;
        if (r40 == null) goto L111;
        if (r40.getStatusCode() == 206) goto L125;
    L111:
        if (this.b == true) goto L124;
        if (r40 != null) goto L114;
    L116:
        if (r40 != null) goto L118;
    L121:
        d(this, new ExceptionResult((Exception) r32.element));
        goto L216
    L118:
        if (r40.getStatusCode() != 200) goto L121;
        l(this, new nlc.a(this.h));     // Catch: Exception -> L129
        goto L216
    L114:
        if (r40.getStatusCode() != 600) goto L116;
    L124:
        Logger.e$default(r2, "JKL", "[流程][结束][取消][" + this.h.getName() + ']', null, 4, null);     // Catch: Exception -> L127
        c(this);     // Catch: Exception -> L127
    L220:
    L125:
        Logger.e$default(r2, "JKL", "[流程][结束][暂停][" + this.h.getName() + ']', null, 4, null);     // Catch: Exception -> L127
        f(this);     // Catch: Exception -> L127
    L127:
        e = e;
    L131:
        Logger.INSTANCE.e(r3, "download: " + this.h.getEffect_id() + ", name: " + this.h.getName() + " failed", e);
        ExceptionResult r46 = new ExceptionResult(e);
        r46.setTrackParams((String) this.d.a, "", "");
        if ((e instanceof CurrentEditingException) == true) goto L139;
        i r47 = i.a;
        String r48 = i.g(this.h.getZipPath());
        if (r48 == null) goto L140;
        j r49 = com.ss.ugc.effectplatform.cache.h.a(r48);
        if ((r49 instanceof com.ss.ugc.effectplatform.cache.i) == false) goto L138;
        ((com.ss.ugc.effectplatform.cache.i) r49).h(this.h);
        goto L140
    L138:
        String r50 = FileManager.a;
        FileManager.o(this.h.getUnzipPath());
        FileManager.o(this.h.getZipPath());
    L140:
        d(this, r46);
        goto L216
    L139:
        r46.setMsg(r16);
        goto L140
    L90:
        r42 = null;
        goto L91
    L86:
        r40 = null;
    L129:
        e = e;
        r3 = "EffectFetcherTask";
    L141:
        d(this, new ExceptionResult(10003));
        goto L216
    L66:
        if (r34.isEmpty() == true) goto L69;
        r35 = false;
        goto L70
    L21:
        if (r.b(this.h.getUnzipPath()) == false) goto L26;
    L142:
        String r51 = "";
        r14 = r14;
    L144:
        int r52 = r.a;
        if (r.b(this.h.getZipPath()) == false) goto L147;
    L150:
        Effect r53 = this.h;
        StringBuilder r54 = new StringBuilder();
        r54.append(this.k.c);
        String r116 = FileManager.a;
        r54.append(r116);
        r54.append(this.h.getId());
        r54.append(".zip");
        r53.setZipPath(r54.toString());
        this.h.setUnzipPath(this.k.c + r116 + this.h.getId());
    L152:
        if (this.m.T == false) goto L163;
        StringBuilder r55 = new StringBuilder();
        r55.append(this.m.j);
        String r56 = FileManager.a;
        r55.append(FileManager.a);
        r55.append(this.h.getId());
        String r57 = r55.toString();
        if (FileManager.d(r57) == false) goto L163;
        r2.w("JKL", "[预加载][读取][特效][检测到已有预加载资源!][" + this.h.getId() + ']');
        this.h.setUnzipPath(r57);
        l(this, new nlc.a(this.h));
        com.ss.ugc.effectplatform.preload.b.a r58 = com.ss.ugc.effectplatform.preload.b.d;
        Object r59 = this.m.G;
        r58.getClass();
        com.ss.ugc.effectplatform.preload.b r60 = com.ss.ugc.effectplatform.preload.b.a.a(r59);
        if (r60 == null) goto L158;
        c r117 = r60.e(this.h.getId());
    L159:
        if (r117 == null) goto L216;
        klc.a r61 = (klc.a) this.m.v.a;
        if (r61 == null) goto L216;
        String r62 = r117.f;
        String r63 = r117.b;
        i r64 = i.a;
        klc.b.l(r61, r62, r63, i.f(r57) / ((long) 1024));
        goto L216
    L158:
        r117 = null;
    L163:
        k();
        d r65 = this.m.M;
        Effect r66 = this.h;
        int r67 = com.ss.ugc.effectplatform.h.a;
        Boolean r68 = Boolean.TRUE;
        r65.getClass();
        if (d.b(r66, false, r68) == false) goto L166;
        r2.d("EffectFetcherTask", "fetchEffect: " + this.h.getEffect_id() + " name: " + this.h.getName() + " already exists!");
        l(this, new nlc.a(this.h));
        goto L216
    L166:
        i(this);
        r2.d(r3, "download effect: " + this.h.getEffect_id() + ", name: " + this.h.getName() + ", uri: " + this.h.getFile_url().getUri() + " start");
        Ref.ObjectRef r69 = new Ref.ObjectRef();
        r69.element = null;
        int r70 = l.a;
        if (l.a(this.m.G) == true) goto L169;
        d(this, new ExceptionResult(10011));
        goto L216
    L169:
        List<String> r71 = this.k.b;
        List<String> r72 = r71;
        if (r72 != null) goto L172;
    L175:
        boolean r73 = true;
    L176:
        if (r73 == true) goto L215;
        com.ss.ugc.effectplatform.util.h r74 = com.ss.ugc.effectplatform.util.h.a;
        UrlModel r75 = this.h.getFile_url();
        r74.getClass();
        if (com.ss.ugc.effectplatform.util.h.c(r75) == true) goto L215;
        int r76 = r72.size();
        int r77 = 0;
    L181:
        if (r77 >= r76) goto L214;
        if (this.b == true) goto L184;
        this.d.a = ListProtector.get(r71, r77);     // Catch: Exception -> L197
        String r78 = (String) this.d.a;     // Catch: Exception -> L197
        if (r78 == null) goto L214;
        com.ss.ugc.effectplatform.download.f r79 = this.l;     // Catch: Exception -> L197
        if (r79 == null) goto L191;
        Long r80 = Long.valueOf(r79.a(r78, new z(this, r69)));     // Catch: Exception -> L197
    L192:
        if (r80 != null) goto L194;
    L199:
        String r118 = r14;
    L213:
        r77 = r77 + 1;
        r51 = r51;
        r14 = r118;
        r16 = r16;
        goto L181
    L194:
        if (r80.longValue() <= 0) goto L199;
        l(this, new nlc.a(this.h));     // Catch: Exception -> L197
        goto L216
    L191:
        r80 = null;
    L197:
        e = move-exception;
        r118 = r14;
        Logger.INSTANCE.e(r3, r118 + this.h.getEffect_id() + ", name: " + this.h.getName() + " failed, count: " + r77, e);
        if (r77 != (r71.size() - 1)) goto L213;
        ExceptionResult r81 = new ExceptionResult(e);
        String r82 = r51;
        r81.setTrackParams((String) this.d.a, r82, r82);
        if ((e instanceof CurrentEditingException) == true) goto L210;
        i r83 = i.a;
        String r84 = i.g(this.h.getZipPath());
        if (r84 == null) goto L211;
        j r85 = com.ss.ugc.effectplatform.cache.h.a(r84);
        if ((r85 instanceof com.ss.ugc.effectplatform.cache.i) == false) goto L209;
        ((com.ss.ugc.effectplatform.cache.i) r85).h(this.h);
        goto L211
    L209:
        String r86 = FileManager.a;
        FileManager.o(this.h.getUnzipPath());
        FileManager.o(this.h.getZipPath());
    L211:
        d(this, r81);
        goto L216
    L210:
        r81.setMsg(r16);
        goto L211
    L184:
        d(this, new ExceptionResult(10001, new Exception(String.valueOf(10001))));
    L214:
        d(this, new ExceptionResult((Exception) r69.element));
    L215:
        d(this, new ExceptionResult(10003));
        goto L216
    L172:
        if (r72.isEmpty() == true) goto L175;
        r73 = false;
        goto L176
    L147:
        if (r.b(this.h.getUnzipPath()) == false) goto L152;
    L13:
        if (r1.b == false) goto L15;
        r4 = true;
        goto L17
    L10:
        r15 = ArraysKt.contains(r1.e, r13.getPanel());
        goto L11
    L143:
        r51 = "";
        goto L144
    }

    public final void k() {
        EffectConfig r0 = this.m;
        if (r0.b0 == true) goto L5;
        return;
    L5:
        Object r1 = r0.G;
        if (r1 == null) goto L8;
        com.ss.ugc.effectplatform.cache.l.c.getClass();
        com.ss.ugc.effectplatform.cache.l r2 = com.ss.ugc.effectplatform.cache.l.a.a(r1);
    L9:
        if (r2 == null) goto L12;
        new k(this.h);
        return;
    L12:
        return;
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.ss.ugc.effectplatform.task.o1
    public final void d(o1<nlc.a> r11, ExceptionResult r12) {
        Logger.e$default(Logger.INSTANCE, "JKL", "[流程][结束][失败][特效][" + this.h.getName() + "][" + this.h.getEffect_id() + "][错误码：" + r12.getErrorCode() + "][错误信息：" + r12.getMsg() + ']', null, 4, null);
        super.d(r11, r12);
        Effect r13 = this.h;
        if (r12.getErrorCode() != 10001) goto L5;
    L14:
        boolean r14 = false;
    L15:
        if (r14 == false) goto L28;
        EffectConfig r6 = this.m;
        klc.a r4 = (klc.a) r6.v.a;
        if (r4 == null) goto L29;
        Effect r7 = this.h;
        Pair[] r15 = new Pair[2];
        r15[0] = TuplesKt.to("error_code", Integer.valueOf(r12.getErrorCode()));
        String r0 = (String) this.d.a;
        if (r0 != null) goto L22;
        r0 = "";
    L22:
        r15[1] = TuplesKt.to("download_url", r0);
        Map r8 = MapsKt.mapOf(r15);
        String r16 = r12.getMsg();
        if (r16 == null) goto L25;
        String r9 = r16;
    L26:
        klc.b.d(r4, false, r6, r7, r8, r9);
        return;
    L25:
        r9 = "";
        goto L26
    L29:
        return;
    L28:
        return;
    L5:
        if (r12.getErrorCode() == 10019) goto L14;
        if (r13 != null) goto L9;
    L13:
        r14 = true;
        goto L15
    L9:
        if (r12.getErrorCode() != 10003) goto L13;
        if (r13.getEffect_type() != 1) goto L13;
        goto L13
    }

    public final void l(o1<nlc.a> r8, nlc.a r9) {
        h(r8, r9);
        Logger.INSTANCE.w("JKL", "[流程][结束][成功][" + this.h.getName() + "][" + this.h.getEffect_id() + ']');
        EffectConfig r3 = this.m;
        klc.a r1 = (klc.a) r3.v.a;
        if (r1 == null) goto L10;
        Effect r4 = this.h;
        Pair[] r10 = new Pair[4];
        r10[0] = TuplesKt.to("duration", this.e.a);
        r10[1] = TuplesKt.to("unzip_time", this.f.a);
        r10[2] = TuplesKt.to("size", this.g.a);
        String r11 = (String) this.d.a;
        if (r11 != null) goto L8;
        r11 = "";
    L8:
        r10[3] = TuplesKt.to("download_url", r11);
        klc.b.d(r1, true, r3, r4, MapsKt.mapOf(r10), "");
        return;
    }

    public y(blc.b r3, com.ss.ugc.effectplatform.download.f r4, EffectConfig r5) {
        this.k = r3;
        this.l = r4;
        this.m = r5;
        this.d = new b(null);
        this.e = new b(0L);
        this.f = new b(0L);
        this.g = new b(0L);
        this.h = r3.a;
    }
}
