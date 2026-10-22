package com.ss.android.socialbase.downloader.segment;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f8305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8306b;

    private m(JSONObject r10) {
        this.f8305a = r10;
    }

    private int a(int r10) {
        int r11 = this.f8305a.optInt("thread_count", 4);
        if (r11 <= 16) goto L5;
        r11 = 16;
    L5:
        int r12 = o();
        if (r11 > 0) goto L10;
        if (r12 <= 0) goto L9;
        return r10;
    L9:
        return 1;
    L10:
        if (r12 == 1) goto L12;
        return r11;
    L12:
        return Math.min(r11, r10);
    }

    @NonNull
    public static m b(@NonNull JSONObject r10) {
        return new m(r10);
    }

    private int o() {
        return this.f8305a.optInt("url_balance", 2);
    }

    public int c() {
        return this.f8305a.optInt("buffer_count", 512);
    }

    public int d() {
        return this.f8305a.optInt("buffer_size", 8192);
    }

    public long e() {
        long r10 = this.f8305a.optInt("connect_timeout", -1);
        if (r10 < 2000) goto L5;
        return r10;
    L5:
        return -1;
    }

    public int f() {
        return this.f8305a.optInt("ip_strategy", 0);
    }

    public float g() {
        return (float) this.f8305a.optDouble("main_ratio", 0.0d);
    }

    public float h() {
        return Math.min(Math.max(0.0f, (float) this.f8305a.optDouble("poor_speed_ratio", 0.0d)), 1.0f);
    }

    public int i() {
        return this.f8305a.optInt("ratio_segment", 0);
    }

    public long j() {
        long r10 = this.f8305a.optInt("read_timeout", -1);
        if (r10 < 4000) goto L5;
        return r10;
    L5:
        return -1;
    }

    public long k() {
        long r10 = ((long) this.f8305a.optInt("segment_max_kb", 0)) * 1048576;
        if (r10 >= m()) goto L6;
        return -1;
    L6:
        return r10;
    }

    public long l() {
        long r10 = ((long) this.f8305a.optInt("segment_min_init_mb", 10)) * 1048576;
        if (r10 < 5242880) goto L5;
        return r10;
    L5:
        return 5242880;
    }

    public long m() {
        long r10 = ((long) this.f8305a.optInt("segment_min_kb", 512)) * 1024;
        if (r10 < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) goto L5;
        return r10;
    L5:
        return PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
    }

    public int n() {
        return this.f8306b;
    }

    public boolean p() {
        if (this.f8305a.optInt("segment_mode", 1) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public void q(int r10) {
        this.f8306b = a(r10);
    }

    public boolean r() {
        if (o() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean s() {
        if (o() == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
