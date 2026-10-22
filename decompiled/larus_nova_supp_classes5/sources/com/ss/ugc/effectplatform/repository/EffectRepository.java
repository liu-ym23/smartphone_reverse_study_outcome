package com.ss.ugc.effectplatform.repository;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.cache.g;
import com.ss.ugc.effectplatform.cache.j;
import com.ss.ugc.effectplatform.cache.k;
import com.ss.ugc.effectplatform.cache.l;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.task.BaseTask;
import com.ss.ugc.effectplatform.task.DownloadEffectTask;
import com.ss.ugc.effectplatform.task.FetchEffectFromCacheTask;
import com.ss.ugc.effectplatform.task.StrategyCacheClearTask;
import com.ss.ugc.effectplatform.task.i1;
import com.ss.ugc.effectplatform.task.l1;
import com.ss.ugc.effectplatform.task.q;
import com.ss.ugc.effectplatform.task.q1;
import com.ss.ugc.effectplatform.task.r;
import com.ss.ugc.effectplatform.task.r1;
import com.ss.ugc.effectplatform.task.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;
import z.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class EffectRepository {
    public final b<String, String> a;
    public final Lazy b;
    public final a c;
    public final EffectConfig d;

    public static final class a implements q {
        public final /* synthetic */ EffectRepository a;

        public a(EffectRepository r1) {
            this.a = r1;
        }

        @Override // com.ss.ugc.effectplatform.task.q
        public final void a(List<? extends Effect> r5, r r6) {
            LinkedHashMap r0 = new LinkedHashMap();
            Iterator<T> r7 = r5.iterator();
        L4:
            if (r7.hasNext() == false) goto L13;
            Effect r1 = (Effect) r7.next();
            Integer r2 = r1.getIcon_url().getUrl_type();
            if (r2 == null) goto L4;
            if (r2.intValue() != 1) goto L4;
            String r3 = r1.getIcon_url().getUri();
            if (r3 == null) goto L4;
            Effect r4 = (Effect) r0.put(r3, r1);
            goto L4
        L13:
            this.a.d.getClass();
            this.a.d.getClass();
            r6.onSuccess();
        }
    }

    public EffectRepository(EffectConfig r2) {
        this.d = r2;
        this.a = new b(true);
        this.b = LazyKt.lazy(new EffectRepository$effectCacheCleaner$2(this));
        this.c = new a(this);
    }

    public final void e(long r3) {
        j r0 = (j) this.d.A.a;
        if (r0 == null) goto L6;
        r0.a(r3, new removeUnused.1(this));
        return;
    }

    public final void d(String r4, IEffectPlatformBaseListener r5) {
        String r0 = com.ss.ugc.effectplatform.util.q.a();
        if (r5 == null) goto L5;
        this.d.N.b(r0, r5);
    L5:
        EffectConfig r6 = this.d;
        q1 r1 = r6.D;
        if (r1 == null) goto L9;
        r1.a(new i1(r6, r4, r0));
        return;
    }

    public final void c(List r8, Map r9, IEffectPlatformBaseListener r10) {
        String r3 = com.ss.ugc.effectplatform.util.q.a();
        if (r10 == null) goto L5;
        this.d.N.b(r3, r10);
    L5:
        EffectConfig r1 = this.d;
        q1 r11 = r1.D;
        if (r11 == null) goto L9;
        r11.a(new t(r1, r8, r3, r9, this.c));
        return;
    }

    public final void a(List<String> r11, List<String> r12, List<String> r13, Function3<? super Boolean, ? super Integer, ? super String, Unit> r14) {
        l.a r0 = l.c;
        Object r1 = this.d.G;
        r0.getClass();
        l r2 = l.a.a(r1);
        if (r2 == null) goto L11;
        Pair r3 = l.a();
        Logger.INSTANCE.d("JKL", "[cleanResourcesByServerStrategyWithAllowList][数据库][清理前]: 总数量:" + ((Number) r3.getFirst()).intValue() + " 总大小:" + ((Number) r3.getSecond()).longValue());
        Iterator r4 = CollectionsKt.emptyList().iterator();
        int r5 = 0;
    L6:
        if (r4.hasNext() == false) goto L11;
        Object r6 = r4.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        Logger.INSTANCE.d("JKL", "[cleanResourcesByServerStrategyWithAllowList][数据库][清理前][第" + r5 + "条]:" + ((k) r6));
        r5 = r7;
    L11:
        g r8 = (g) this.b.getValue();
        cleanResourcesByServerStrategyWithAllowList.2 r9 = new cleanResourcesByServerStrategyWithAllowList.2(r2, r14);
        r8.getClass();
        l.a r15 = l.c;
        Object r10 = r8.a.G;
        r15.getClass();
        l r16 = l.a.a(r10);
        boolean r17 = true;
        if (r16 == null) goto L47;
        ArrayList r18 = new ArrayList();
        ArrayList r19 = new ArrayList();
        Iterator r110 = r18.iterator();
    L15:
        if (r110.hasNext() == false) goto L40;
        Object r20 = r110.next();
        k r21 = (k) r20;
        if (r11 != null) goto L19;
    L21:
        if (r12 != null) goto L23;
    L25:
        List<String> r22 = r13;
        if (r22 != null) goto L28;
    L31:
        boolean r23 = true;
    L32:
        if (r23 == false) goto L35;
    L36:
        boolean r24 = true;
    L38:
        if (r24 == false) goto L15;
        r19.add(r20);
        goto L15
    L35:
        if (r13.contains(r21.d) == true) goto L36;
    L37:
        r24 = false;
        goto L38
    L28:
        if (r22.isEmpty() == true) goto L31;
        r23 = false;
        goto L32
    L23:
        if (r12.contains(r21.a) != true) goto L25;
    L19:
        if (r11.contains(r21.d) != true) goto L21;
    L40:
        List r111 = CollectionsKt.sortedWith(r19, new com.ss.ugc.effectplatform.cache.d());
        if (r111 == null) goto L47;
        List r112 = r111;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator r114 = r112.iterator();
    L44:
        if (r114.hasNext() == false) goto L46;
        k r115 = (k) r114.next();
        r113.add(new StrategyCacheClearTask.a(r115.c, r115.d, r115.h));
        goto L44
    L46:
        List r116 = r113.subList(0, Math.min(100, r113.size()));
    L48:
        List r117 = r116;
        if (r117 != null) goto L51;
    L54:
        if (r17 == false) goto L56;
        Unit r118 = (Unit) r9.invoke(Boolean.TRUE, 0, "no effect should be cleared");
        return;
    L56:
        com.ss.ugc.effectplatform.cache.e r119 = new com.ss.ugc.effectplatform.cache.e(r8, r9);
        String r120 = com.ss.ugc.effectplatform.util.q.a();
        r8.a.N.b(r120, r119);
        EffectConfig r121 = r8.a;
        q1 r122 = r121.D;
        if (r122 == null) goto L70;
        r122.a(new StrategyCacheClearTask(r121, r116, r120));
        return;
    L70:
        return;
    L51:
        if (r117.isEmpty() == true) goto L54;
        r17 = false;
    L47:
        r116 = null;
        goto L48
    }

    public final String b(Effect r21, boolean r22, boolean r23, boolean r24, hlc.d r25) {
        StringBuilder r3 = new StringBuilder();
        r3.append(com.ss.ugc.effectplatform.util.q.a());
        r3.append(" - ");
        r3.append(r21.getName());
        if (r22 == false) goto L5;
        String r4 = " - Ready";
    L6:
        r3.append(r4);
        String r5 = r3.toString();
        if (StringsKt.isBlank(r21.getId()) == false) goto L11;
        if (r25 == null) goto L10;
        r25.onFail(r21, new ExceptionResult(10014));
    L10:
        return r5;
    L11:
        if (r25 == null) goto L13;
        this.d.N.b(r5, r25);
    L13:
        if (r22 == false) goto L18;
        EffectConfig r2 = this.d;
        q1 r6 = r2.D;
        if (r6 == null) goto L17;
        r6.a(new FetchEffectFromCacheTask(r2, r21, r5));
    L17:
        return r5;
    L18:
        this.d.getClass();
        this.d.getClass();
        String r7 = r21.getFile_url().getUri();
        Integer r8 = r21.getFile_url().getUrl_type();
        if (r8 != null) goto L22;
    L25:
        e0.c r9 = null;
        DownloadEffectTask r10 = new DownloadEffectTask(r21, this.d, r5, null);
        if (ArraysKt.contains(this.d.S, r21.getPanel()) == true) goto L28;
    L78:
        q1 r1 = this.d.D;
        if (r1 == null) goto L81;
        r1.a(r10);
    L81:
        return r5;
    L28:
        if (this.d.R == false) goto L78;
        String r11 = com.ss.ugc.effectplatform.model.b.a(r21);
        if (r11 == null) goto L32;
        this.a.put(r11, r5);
    L32:
        q1 r12 = this.d.D;
        if (r12 == null) goto L81;
        if (r23 == false) goto L37;
        r10.j = 1;
        int r13 = b0.a.a;
        r10.k = System.currentTimeMillis();
        r12.c.add(0, r10);
        Logger.INSTANCE.d("JKL", "[TaskManager][加入队头][" + r10.getId() + ']');
    L38:
        Iterator r14 = r12.a.values().iterator();
        boolean r15 = false;
    L40:
        if (r14.hasNext() == false) goto L44;
        if (((e0.a) r14.next()).a() == false) goto L40;
        r15 = true;
        goto L40
    L44:
        r10.d();
        if (r15 == true) goto L81;
        if (r24 == true) goto L48;
    L77:
        r12.i.execute(new r1(r12));
        goto L81
    L48:
        if (r10.d == false) goto L51;
        Logger.INSTANCE.d("JKL", "[暂停][TaskManager][不停][插入任务:" + r10.getId() + " 已运行]");
        goto L77
    L51:
        if ((r12.b.size() + r12.f.b()) >= r12.h) goto L53;
        Logger.INSTANCE.d("JKL", "[暂停][TaskManager][不停][" + r12.b.keySet() + "][插入任务:" + r10.getId() + ']');
        goto L77
    L53:
        Logger.e$default(Logger.INSTANCE, "JKL", "[暂停][TaskManager][停][" + r12.b.keySet() + "][插入任务:" + r10.getId() + ']', null, 4, null);
        r12.f.a.incrementAndGet();
        Iterator r16 = r12.b.values().iterator();
    L55:
        if (r16.hasNext() == false) goto L72;
        e0.c r17 = (e0.c) r16.next();
        if ((r17 instanceof BaseTask) == false) goto L61;
        BaseTask r18 = (BaseTask) r17;
        r18.getClass();
        if ((r18 instanceof DownloadEffectTask) == false) goto L61;
        boolean r19 = true;
    L62:
        if (r19 == false) goto L55;
        if (r9 == null) goto L71;
        if (r9.getLevel() > r17.getLevel()) goto L71;
        if (r9.getModifyTime() <= r17.getModifyTime()) goto L55;
    L71:
        r9 = r17;
    L61:
        r19 = false;
        goto L62
    L72:
        if (r9 == null) goto L77;
        Logger r20 = Logger.INSTANCE;
        Logger.e$default(r20, "JKL", "[暂停][TaskManager][执行-Star][任务 - " + r9.getId() + ']', null, 4, null);
        r12.d.add(r9);
        r9.pause();
        r12.b.remove(r9.getId());
        int r26 = b0.a.a;
        r9.setModifyTime(System.currentTimeMillis());
        if ((r9 instanceof BaseTask) == false) goto L76;
        ((BaseTask) r9).b = false;
    L76:
        Logger.e$default(r20, "JKL", "[暂停][TaskManager][执行-End][任务 - " + r9.getId() + ']', null, 4, null);
        goto L77
    L37:
        r10.j = 0;
        int r27 = b0.a.a;
        r10.k = System.currentTimeMillis();
        r12.c.add(r10);
        Logger.INSTANCE.d("JKL", "[TaskManager][加入队尾][" + r10.getId() + ']');
        goto L38
    L22:
        if (r8.intValue() != 1) goto L25;
        if (r7 == null) goto L25;
        StringsKt.isBlank(r7);
        goto L25
    L5:
        r4 = "";
        goto L6
    }

    public final void f(String r13, String r14, int r15, int r16, String r17, Map r18, IEffectPlatformBaseListener r19) {
        String r9 = com.ss.ugc.effectplatform.util.q.a();
        if (r19 == null) goto L5;
        this.d.N.b(r9, r19);
    L5:
        EffectConfig r2 = this.d;
        q1 r10 = r2.D;
        if (r10 == null) goto L9;
        r10.a(new l1(r2, r13, r14, r15, r16, r17, r18, r9));
        return;
    }
}
