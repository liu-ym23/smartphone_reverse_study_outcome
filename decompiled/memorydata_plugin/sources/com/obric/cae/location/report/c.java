package com.obric.cae.location.report;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.cae.userAware.UserAwareManager;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes3.dex */
public class c extends com.obric.cae.location.report.a {
    public static volatile c j;

    public class a extends com.obric.cae.location.report.a.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f7274a;

        public a(c r1) {
            this.f7274a = r1;
        }

        @Override // com.obric.cae.location.report.a.g
        public final void a() {
            Object r0 = this.f7274a.d;
            monitor-enter(r0);
        L30:
            th = move-exception;
            throw th;
        L5:
            if (this.f7274a.e.isEmpty() == true) goto L7;
        L10:
            ArrayList r1 = new ArrayList(this.f7274a.e);     // Catch: Throwable -> L30
            this.f7274a.e.clear();     // Catch: Throwable -> L30
            ArrayList r2 = new ArrayList(this.f7274a.f.values());     // Catch: Throwable -> L30
            this.f7274a.f.clear();     // Catch: Throwable -> L30
            monitor-exit(r0);     // Catch: Throwable -> L30
            JsonObject r3 = new JsonObject();
            JsonArray r4 = new JsonArray();
            Iterator r5 = r1.iterator();
        L14:
            if (r5.hasNext() == false) goto L16;
            com.obric.cae.location.report.a.d r6 = (com.obric.cae.location.report.a.d) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.cae.location.report.a.d.class, "com.obric.memorydata.plugin");
            JsonObject r7 = new JsonObject();
            r7.addProperty("geofenceId", r6.f7266b.getGeofenceId());
            r7.addProperty(ObricMemoryConstants.KEY_PACKAGE_NAME, r6.f7266b.getPackageName());
            r7.addProperty("latitude", Double.valueOf(r6.f7266b.getLatitude()));
            r7.addProperty("longitude", Double.valueOf(r6.f7266b.getLongitude()));
            r7.addProperty("radius", Integer.valueOf(r6.f7266b.getRadius()));
            r7.addProperty("geoType", Integer.valueOf(r6.f7266b.getGeoType().getValue()));
            r7.addProperty("operation", Integer.valueOf(r6.c));
            r7.addProperty("timestamp", Long.valueOf(r6.f7265a));
            r4.add(r7);
            goto L14
        L16:
            r3.add("geofences", r4);
            JsonArray r8 = new JsonArray();
            Iterator r9 = r2.iterator();
        L18:
            if (r9.hasNext() == false) goto L28;
            com.obric.cae.location.report.a.C0358a r10 = (com.obric.cae.location.report.a.C0358a) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.cae.location.report.a.C0358a.class, "com.obric.memorydata.plugin");
            JsonObject r11 = new JsonObject();
            r11.addProperty("timestamp", Long.valueOf(r10.f7259a));
            r11.addProperty("latitude", Double.valueOf(r10.f7260b));
            r11.addProperty("longitude", Double.valueOf(r10.c));
            r11.addProperty("hacc", Float.valueOf(r10.d));
            r11.addProperty("provider", r10.e);
            r11.addProperty(AILabCheckPermissionTask.KEY_SOURCE, Integer.valueOf(r10.f));
            r11.addProperty("simCardStatus", Integer.valueOf(r10.g));
            JsonArray r12 = new JsonArray();
            Iterator<String> r13 = r10.h.iterator();
        L21:
            if (r13.hasNext() == false) goto L23;
            r12.add((String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin"));
            goto L21
        L23:
            r11.add("geofenceIds", r12);
            JsonArray r14 = new JsonArray();
            Iterator<Integer> r15 = r10.i.iterator();
        L25:
            if (r15.hasNext() == false) goto L27;
            r14.add((Integer) ZeusTransformUtils.preCheckCast(r15.next(), Integer.class, "com.obric.memorydata.plugin"));
            goto L25
        L27:
            r11.add("events", r14);
            r8.add(r11);
            goto L18
        L28:
            r3.add("breachEvents", r8);
            c r16 = this.f7274a;
            String r17 = new Gson().toJson(r3);
            r16.getClass();
            c.a("useraware_star_geofence_info", r17);
            return;
        L7:
            if (this.f7274a.f.isEmpty() == false) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L30
        }
    }

    public class b extends com.obric.cae.location.report.a.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f7275a;

        public b(c r1) {
            this.f7275a = r1;
        }

        @Override // com.obric.cae.location.report.a.g
        public final void a() {
            Object r0 = this.f7275a.g;
            monitor-enter(r0);
        L33:
            th = move-exception;
            throw th;
        L5:
            if (this.f7275a.h.isEmpty() == false) goto L8;
            monitor-exit(r0);     // Catch: Throwable -> L33
            return;
        L8:
            ArrayList r1 = new ArrayList(this.f7275a.h);     // Catch: Throwable -> L33
            this.f7275a.h.clear();     // Catch: Throwable -> L33
            monitor-exit(r0);     // Catch: Throwable -> L33
            Iterator r2 = r1.iterator();
        L12:
            if (r2.hasNext() == false) goto L32;
            com.obric.cae.location.report.a.b r3 = (com.obric.cae.location.report.a.b) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.cae.location.report.a.b.class, "com.obric.memorydata.plugin");
            JsonObject r4 = new JsonObject();
            r4.addProperty(ObricMemoryConstants.KEY_SESSION_ID, r3.f7261a);
            r4.addProperty("businessName", r3.f7262b);
            r4.addProperty("businessVersion", r3.c);
            r4.addProperty("finalLabel", r3.d);
            r4.addProperty("finalProbIndoor", Double.valueOf(r3.e));
            r4.addProperty("correct", Boolean.valueOf(r3.f));
            r4.addProperty(AILabCheckPermissionTask.KEY_SOURCE, Integer.valueOf(r3.g));
            JsonArray r5 = new JsonArray();
            Iterator<com.obric.cae.location.report.a.c> r6 = r3.h.iterator();
        L15:
            if (r6.hasNext() == false) goto L31;
            com.obric.cae.location.report.a.c r7 = (com.obric.cae.location.report.a.c) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.cae.location.report.a.c.class, "com.obric.memorydata.plugin");
            JsonObject r8 = new JsonObject();
            r8.addProperty("timestampSec", Long.valueOf(r7.f7263a));
            r8.addProperty("rawFrame", r7.f7264b);
            r8.addProperty("inputState", r7.c);
            r8.addProperty("outputState", r7.d);
            String r9 = r7.e;
            if (r9 == null) goto L20;
            r8.addProperty(AnnotatedPrivateKey.LABEL, r9);
        L20:
            if (Double.isFinite(r7.f) == false) goto L22;
            r8.addProperty("probIndoor", Double.valueOf(r7.f));
        L22:
            JsonArray r10 = new JsonArray();
            Iterator<Double> r11 = r7.g.iterator();
        L24:
            if (r11.hasNext() == false) goto L26;
            r10.add((Double) ZeusTransformUtils.preCheckCast(r11.next(), Double.class, "com.obric.memorydata.plugin"));
            goto L24
        L26:
            r8.add("baseFeatures", r10);
            JsonArray r12 = new JsonArray();
            Iterator<Double> r13 = r7.h.iterator();
        L28:
            if (r13.hasNext() == false) goto L30;
            r12.add((Double) ZeusTransformUtils.preCheckCast(r13.next(), Double.class, "com.obric.memorydata.plugin"));
            goto L28
        L30:
            r8.add("hmmState", r12);
            r5.add(r8);
            goto L15
        L31:
            r4.add("frames", r5);
            c r14 = this.f7275a;
            String r15 = new Gson().toJson(r4);
            r14.getClass();
            c.a("user_aware_star_indoor_check_feedback", r15);
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.obric.cae.location.report.c$c, reason: collision with other inner class name */
    public class C0359c extends com.obric.cae.location.report.a.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f7276a;

        public C0359c(c r1) {
            this.f7276a = r1;
        }

        @Override // com.obric.cae.location.report.a.g
        public final void a() {
            Object r0 = this.f7276a.f7258b;
            monitor-enter(r0);
        L31:
            th = move-exception;
            throw th;
        L5:
            if (this.f7276a.c.isEmpty() == false) goto L8;
            monitor-exit(r0);     // Catch: Throwable -> L31
            return;
        L8:
            ArrayList r1 = new ArrayList(this.f7276a.c);     // Catch: Throwable -> L31
            this.f7276a.c.clear();     // Catch: Throwable -> L31
            monitor-exit(r0);     // Catch: Throwable -> L31
            Iterator r2 = r1.iterator();
        L12:
            if (r2.hasNext() == false) goto L30;
            com.obric.cae.location.report.a.e r3 = (com.obric.cae.location.report.a.e) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.cae.location.report.a.e.class, "com.obric.memorydata.plugin");
            JsonObject r4 = new JsonObject();
            r4.addProperty("modelVersion", r3.f7267a);
            JsonArray r5 = new JsonArray();
            Iterator<Long> r6 = r3.f7268b.iterator();
        L15:
            if (r6.hasNext() == false) goto L17;
            r5.add((Long) ZeusTransformUtils.preCheckCast(r6.next(), Long.class, "com.obric.memorydata.plugin"));
            goto L15
        L17:
            r4.add("timestamps", r5);
            JsonArray r7 = new JsonArray();
            Iterator<Float> r8 = r3.c.iterator();
        L19:
            if (r8.hasNext() == false) goto L21;
            r7.add((Float) ZeusTransformUtils.preCheckCast(r8.next(), Float.class, "com.obric.memorydata.plugin"));
            goto L19
        L21:
            r4.add("confidences", r7);
            JsonArray r9 = new JsonArray();
            Iterator<Float> r10 = r3.d.iterator();
        L23:
            if (r10.hasNext() == false) goto L25;
            r9.add((Float) ZeusTransformUtils.preCheckCast(r10.next(), Float.class, "com.obric.memorydata.plugin"));
            goto L23
        L25:
            r4.add("featureArrays", r9);
            JsonArray r11 = new JsonArray();
            Iterator<Float> r12 = r3.e.iterator();
        L27:
            if (r12.hasNext() == false) goto L29;
            r11.add((Float) ZeusTransformUtils.preCheckCast(r12.next(), Float.class, "com.obric.memorydata.plugin"));
            goto L27
        L29:
            r4.add("evals", r11);
            r4.addProperty("zppStrategy", Integer.valueOf(r3.f));
            c r13 = this.f7276a;
            String r14 = new Gson().toJson(r4);
            r13.getClass();
            c.a("useraware_star_zpp_info", r14);
            goto L12
        }
    }

    public c(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    public static c a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (j != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (j != null) goto L9;
        j = new c(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return j;
    }

    public static void a(final String r3, final String r4) {
        com.obric.cae.log.a.c("StarLocation-ReportJson", "notifyCallback: eventName -- " + r3 + ", jsonData -- " + r4);     // Catch: Exception -> L5
        UserAwareManager.getInstance().notifyCallbacks(new $$Lambda$zBTs5qNvcpmats53D8i2h_Wl90(r3, r4), null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-ReportJson", "Error calling user aware report callback", e);
    }

    public static /* synthetic */ void a(String r1, String r2, com.obric.cae.libs.useraware.d r3, Object r4) {
        ((com.obric.cae.libs.useraware.d) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.cae.libs.useraware.d.class, "com.obric.memorydata.plugin")).a(r1, r2);
    }

    @Override // com.obric.cae.location.report.a
    public final void a() {
    }

    @Override // com.obric.cae.location.report.a
    public final C0359c b() {
        return new C0359c(this);
    }

    @Override // com.obric.cae.location.report.a
    public final a c() {
        return new a(this);
    }

    @Override // com.obric.cae.location.report.a
    public final b d() {
        return new b(this);
    }
}
