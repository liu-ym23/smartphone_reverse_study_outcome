package com.bytedance.apm.c;

import com.bytedance.apm6.cpu.collect.CpuReportEvent;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1245b;
    private long c;
    private boolean d;
    private boolean e;
    private String f;
    private long g;
    private String h;
    private long i;
    private String j;
    private boolean k;
    private String l;
    private boolean m;

    public a(boolean r1, long r2, String r4, boolean r5, long r6, String r8) {
        this.d = r1;
        this.f1244a = r2;
        this.f1245b = r4;
        this.e = r5;
        this.g = r6;
        this.f = r8;
    }

    public a(boolean r1, long r2, String r4, boolean r5, long r6, String r8, String r9) {
        this.d = r1;
        this.f1244a = r2;
        this.f1245b = r4;
        this.e = r5;
        this.g = r6;
        this.f = r8;
        this.h = r9;
    }

    public void a(long r1) {
        this.i = r1;
    }

    public void a(String r1) {
        this.f = r1;
    }

    public void a(boolean r1) {
        this.e = r1;
    }

    public boolean a() {
        return this.d;
    }

    public void b(long r1) {
        this.c = r1;
    }

    public void b(String r1) {
        this.j = r1;
    }

    public void b(boolean r1) {
        this.k = r1;
    }

    public boolean b() {
        return !this.d;
    }

    public void c(String r1) {
        this.l = r1;
    }

    public boolean c() {
        return this.e;
    }

    public long d() {
        return this.g;
    }

    public long e() {
        return this.f1244a;
    }

    public boolean f() {
        return this.e;
    }

    public String g() {
        return this.f;
    }

    public String getType() {
        return this.f1245b;
    }

    public String h() {
        return this.h;
    }

    public long i() {
        return this.i;
    }

    public String j() {
        return this.j;
    }

    public boolean k() {
        return this.k;
    }

    public String l() {
        return this.l;
    }

    public long m() {
        return this.c;
    }

    public JSONObject n() {
        JSONObject r0 = new JSONObject();
        r0.put(CpuReportEvent.VALUE_FRONT, this.d);
        r0.put(OaidModel.KEY_TIME, this.f1244a);
        r0.put("type", this.f1245b);
        r0.put(MemoryInfoSectionEditActivity.KIND_SCENE, this.f);
        r0.put("processName", this.j);
        return r0;
    }

    public String toString() {
        return "BatteryLogEntity{id=" + this.c + ", front=" + this.d + ", time=" + this.f1244a + ", type='" + this.f1245b + "', status=" + this.e + ", scene='" + this.f + "', accumulation=" + this.g + ", source='" + this.h + "', versionId=" + this.i + ", processName='" + this.j + "', mainProcess=" + this.k + ", startUuid='" + this.l + "', deleteFlag=" + this.m + '}';
    }
}
