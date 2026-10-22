package com.ss.android.lark.conditional.access.auth.v2.service;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CCMFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CalendarFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.VCFileEntity;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import i8b.o;
import i8b.q;
import i8b.r;
import i8b.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends i8b.a {
    public String b;
    public String c;
    public final long d;
    public Timer e;
    public b f;
    public List<PolicyModel> g;
    public final ScheduledExecutorService h;

    /* JADX INFO: renamed from: com.ss.android.lark.conditional.access.auth.v2.service.a$a, reason: collision with other inner class name */
    public static final class C0153a {
    }

    public final class b extends TimerTask {
        public final FileAuthMonitor.UpdateTrigger a;
        public final List<PolicyModel> b;
        public final /* synthetic */ a c;

        public final void a() {
            ScsLogger.d("SecurityPolicy_BatchValidateService", "ValidateTask run().");
            a r1 = this.c;
            FileAuthMonitor.UpdateTrigger r2 = this.a;
            List<PolicyModel> r3 = this.b;
            if (r1.b.length() <= 0) goto L5;
            boolean r4 = true;
        L7:
            if (r4 == true) goto L26;
            ScsLogger.d("SecurityPolicy_BatchValidateService", "mUserId.isEmpty");
        L22:
            r1.e = null;
            return;
        L26:
            qqb.a.h("start batchValidate");     // Catch: Throwable -> L18
            r1.c(new i8b.c(new i8b.b(new FileAuthMonitor.a(r2, null), r3)));     // Catch: Throwable -> L18
            qqb.a.a();
            if (ArraysKt.contains(new FileAuthMonitor.UpdateTrigger[]{FileAuthMonitor.UpdateTrigger.UIdChange, FileAuthMonitor.UpdateTrigger.ColdBoot, FileAuthMonitor.UpdateTrigger.PushNotification}, r2) == false) goto L22;
            qqb.a.h("start batchValidate factor check");     // Catch: Throwable -> L15
            ScsLogger.d("SecurityPolicy_BatchValidateService", "[start control check]");     // Catch: Throwable -> L15
            r1.c(new o(new i8b.b(new FileAuthMonitor.a(r2, null), r1.g)));     // Catch: Throwable -> L15
            r1.c(new i8b.k(new i8b.b(new FileAuthMonitor.a(r2, null), r1.g)));     // Catch: Throwable -> L15
            r1.c(new u(new i8b.b(new FileAuthMonitor.a(r2, null), r1.g)));     // Catch: Throwable -> L15
            qqb.a.a();
        L15:
            th = move-exception;
            qqb.a.a();
            throw th;
        L18:
            th = move-exception;
            qqb.a.a();
            throw th;
        L5:
            r4 = false;
            goto L7
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(a r2, FileAuthMonitor.UpdateTrigger r3, List<PolicyModel> r4) {
            Intrinsics.checkNotNullParameter(r3, "validateFrom");
            Intrinsics.checkNotNullParameter(r4, "validateModels");
            this.c = r2;
            this.a = r3;
            this.b = r4;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Timer r0 = this.a.e;     // Catch: Throwable -> L10
            if (r0 == null) goto L5;
            r0.cancel();     // Catch: Throwable -> L10
        L5:
            b r1 = this.a.f;     // Catch: Throwable -> L10
            if (r1 == null) goto L8;
            r1.cancel();     // Catch: Throwable -> L10
        L8:
            a r2 = this.a;     // Catch: Throwable -> L10
            r2.e = null;     // Catch: Throwable -> L10
            r2.f = null;     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }
    }

    static {
    }

    @Override // i8b.a
    public final void a() {
        this.b = BuildConfig.FLAVOR;
        this.c = BuildConfig.FLAVOR;
        this.h.execute(new c(this));
    }

    public final List<PolicyModel> e() {
        ArrayList r1 = new ArrayList();
        r1.addAll(com.ss.android.lark.conditional.access.auth.v2.b.f.values());
        if (w4c.c.a().L() == false) goto L6;
        r1.add(new PolicyModel("PointKey_VC_MM_CONTENT_COPY", new VCFileEntity("MeetingMinutes", EntityDomain.EntityDomainVC, "VC_MM_CONTENT_COPY", com.ss.android.lark.security.compliance.infra.util.h.a(), com.ss.android.lark.security.compliance.infra.util.h.b(), FileBizDomain.FileBizDomainMeetingMinutes, null, null, null, 0, 512, null), null, 4, null));
    L6:
        if (w4c.c.a().z() == false) goto L8;
        long r7 = com.ss.android.lark.security.compliance.infra.util.h.a();
        long r9 = com.ss.android.lark.security.compliance.infra.util.h.b();
        EntityDomain r37 = EntityDomain.EntityDomainCCM;
        FileBizDomain r38 = FileBizDomain.FileBizDomainCALENDAR;
        r1.add(new PolicyModel("PointKey_CALENDAR_CONTENT_COPY", new CalendarFileEntity("FILE", r37, "CCM_CONTENT_COPY", r7, r9, r38, null, null, null, 448, null), null, 4, null));
        r1.add(new PolicyModel("PointKey_CALENDAR_FILE_PREVIEW", new CalendarFileEntity("FILE", r37, "CCM_FILE_PREVIEW", com.ss.android.lark.security.compliance.infra.util.h.a(), com.ss.android.lark.security.compliance.infra.util.h.b(), r38, null, null, Integer.valueOf(sbb.e.l.b), 128, null), null, 4, null));
        r1.add(new PolicyModel("PointKey_CCM_FILE_DOWNLOAD", new CalendarFileEntity("FILE", r37, "CCM_FILE_DOWNLOAD", com.ss.android.lark.security.compliance.infra.util.h.a(), com.ss.android.lark.security.compliance.infra.util.h.b(), r38, null, null, 12, 128, null), null, 4, null));
        r1.add(new PolicyModel("PointKey_CCM_CONTENT_COPY", new CCMFileEntity("FILE", r37, "CCM_CONTENT_COPY", com.ss.android.lark.security.compliance.infra.util.h.a(), com.ss.android.lark.security.compliance.infra.util.h.b(), r38, null, null, null, null, null, null, null, null, 16320, null), null, 4, null));
    L8:
        Iterator<Map.Entry<String, PolicyModel>> r2 = com.ss.android.lark.conditional.access.auth.v2.b.g.entrySet().iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        PolicyModel r3 = r2.next().getValue();
        if (Intrinsics.areEqual(r3.getEntity().getEntityOperate(), "CCM_EXPORT") == true) goto L10;
        String r6 = r3.getPointKey();
        String r8 = r3.getEntity().getEntityType();
        EntityDomain r10 = r3.getEntity().getEntityDomain();
        String r11 = r3.getEntity().getEntityOperate();
        CCMFileEntity r5 = r3.getEntity();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.security.compliance.api.model.filepolicy.CCMFileEntity");
        PolicyModel r4 = new PolicyModel(r6, new CCMFileEntity(r8, r10, r11, r3.getEntity().getOperatorTenantId(), r3.getEntity().getOperatorUid(), r5.getFileBizDomain(), null, null, null, null, null, null, null, null, 16320, null), null, 4, null);
        r4.getEntity().setEntityType("FILE");
        r1.add(r4);
        goto L10
    L14:
        r1.addAll(com.ss.android.lark.conditional.access.auth.v2.b.g.values());
        Iterator r12 = r1.iterator();
    L16:
        if (r12.hasNext() == false) goto L24;
        PolicyModel r13 = (PolicyModel) r12.next();
        PolicyEntity r14 = r13.getEntity();
        long r15 = 0;
        long r16 = CastLongProtector.parseLong(this.b);     // Catch: Exception -> L20
    L21:
        r14.setOperatorUid(r16);
        PolicyEntity r17 = r13.getEntity();
        r15 = CastLongProtector.parseLong(this.c);     // Catch: Exception -> L26
    L23:
        r17.setOperatorTenantId(r15);
    L20:
        r16 = 0;
        goto L21
    L24:
        this.g = r1;
        return r1;
    }

    public a(q r5) {
        Intrinsics.checkNotNullParameter(r5, "mManager");
        super(r5);
        this.b = BuildConfig.FLAVOR;
        this.c = BuildConfig.FLAVOR;
        this.d = ((long) w4c.c.a().f0()) * ((long) 1000);
        this.g = new ArrayList();
        this.h = CoreThreadPool.getDefault().getSingleScheduledThreadPool("security full validate");
    }

    @Override // i8b.a
    public final void b(com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if ((r2 instanceof r) == true) goto L5;
        return;
    L5:
        if (((com.ss.android.lark.security.compliance.api.model.filepolicy.k) ((r) r2)).a != FileAuthMonitor.UpdateTrigger.NetworkChange) goto L9;
        this.h.execute(new com.ss.android.lark.conditional.access.auth.v2.service.c(this));
        return;
    }

    @Override // i8b.a
    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "tenantId");
        this.b = r2;
        this.c = r3;
        e();
    }
}
