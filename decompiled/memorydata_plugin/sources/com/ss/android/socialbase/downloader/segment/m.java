package com.ss.android.socialbase.downloader.segment;

import com.obric.cae.userAware.WifiScanStateMachine;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f15631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15632b;

    private m(JSONObject r1) {
        this.f15631a = r1;
    }

    public static m a(JSONObject r1) {
        return new m(r1);
    }

    private int b(int r4) {
        int r0 = this.f15631a.optInt("thread_count", 4);
        if (r0 <= 16) goto L5;
        r0 = 16;
    L5:
        int r3 = p();
        if (r0 > 0) goto L10;
        if (r3 <= 0) goto L9;
        return r4;
    L9:
        return 1;
    L10:
        if (r3 == 1) goto L12;
        return r0;
    L12:
        return Math.min(r0, r4);
    }

    private int p() {
        return this.f15631a.optInt("url_balance", 2);
    }

    public int a() {
        return this.f15632b;
    }

    public void a(int r1) {
        this.f15632b = b(r1);
    }

    public boolean b() {
        if (p() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean c() {
        if (p() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public int d() {
        return this.f15631a.optInt("buffer_count", 512);
    }

    public int e() {
        return this.f15631a.optInt("buffer_size", 8192);
    }

    public boolean f() {
        if (this.f15631a.optInt("segment_mode", 1) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public long g() {
        long r0 = ((long) this.f15631a.optInt("segment_min_kb", 512)) * 1024;
        if (r0 < 65536) goto L5;
        return r0;
    L5:
        return 65536;
    }

    public long h() {
        long r0 = ((long) this.f15631a.optInt("segment_min_init_mb", 10)) * 1048576;
        if (r0 < 5242880) goto L5;
        return r0;
    L5:
        return 5242880;
    }

    public long i() {
        long r0 = ((long) this.f15631a.optInt("segment_max_kb", 0)) * 1048576;
        if (r0 >= g()) goto L6;
        return -1;
    L6:
        return r0;
    }

    public long j() {
        long r0 = this.f15631a.optInt("connect_timeout", -1);
        if (r0 < 2000) goto L5;
        return r0;
    L5:
        return -1;
    }

    public long k() {
        long r0 = this.f15631a.optInt("read_timeout", -1);
        if (r0 < WifiScanStateMachine.SCAN_INTERVAL_WITH_THROTTLE_LEVEL_2_MS) goto L5;
        return r0;
    L5:
        return -1;
    }

    public int l() {
        return this.f15631a.optInt("ip_strategy", 0);
    }

    public float m() {
        return (float) this.f15631a.optDouble("main_ratio", 0.0d);
    }

    public int n() {
        return this.f15631a.optInt("ratio_segment", 0);
    }

    public float o() {
        return Math.min(Math.max(0.0f, (float) this.f15631a.optDouble("poor_speed_ratio", 0.0d)), 1.0f);
    }
}
