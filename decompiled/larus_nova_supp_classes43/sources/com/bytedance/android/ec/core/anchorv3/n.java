package com.bytedance.android.ec.core.anchorv3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001a\u0010\u001c\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001a\u0010 \u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001a\u0010#\u001a\u00020\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/bytedance/android/ec/core/anchorv3/n;", "", "", "optImage", "Z", "g", "()Z", "optMainThread", "i", "optPreloadLayout", "j", "optDelayTopNavEvent", "e", "", "headImagePreloadNum", "I", "d", "()I", "detailImagePreloadNum", "b", "detailImagePreloadStrategy", "c", "detailImagePreloadAsync", "a", "optResponseParse", "k", "optEnterPerf25Q3", "f", "optEnterPerf25Q4", "getOptEnterPerf25Q4", "optImageFlicker", "h", "optWireframeBitmap", "l", "", "delayInitDuration", "J", "getDelayInitDuration", "()J", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("delay_init_duration")
    private final long delayInitDuration;

    @SerializedName("detail_image_preload_async")
    private final boolean detailImagePreloadAsync;

    @SerializedName("detail_image_preload_num")
    private final int detailImagePreloadNum;

    @SerializedName("detail_image_preload_strategy")
    private final int detailImagePreloadStrategy;

    @SerializedName("head_image_preload_num")
    private final int headImagePreloadNum;

    @SerializedName("opt_delay_top_nav_event")
    private final boolean optDelayTopNavEvent;

    @SerializedName("opt_enter_perf_25_q3")
    private final boolean optEnterPerf25Q3;

    @SerializedName("opt_enter_perf_25_q4")
    private final int optEnterPerf25Q4;

    @SerializedName("opt_image")
    private final boolean optImage;

    @SerializedName("opt_image_flicker")
    private final boolean optImageFlicker;

    @SerializedName("opt_main_thread_v2")
    private final boolean optMainThread;

    @SerializedName("opt_preload_layout")
    private final boolean optPreloadLayout;

    @SerializedName("opt_response_parse")
    private final int optResponseParse;

    @SerializedName("opt_wireframe_bitmap")
    private final boolean optWireframeBitmap;

    public static final class a {
    }

    static {
    }

    public n() {
        this(false, false, false, 0, 0, false, 0, false, 0, 16383);
    }

    public final boolean a() {
        return this.detailImagePreloadAsync;
    }

    public final int b() {
        return this.detailImagePreloadNum;
    }

    public final int c() {
        return this.detailImagePreloadStrategy;
    }

    public final int d() {
        return this.headImagePreloadNum;
    }

    public final boolean e() {
        return this.optDelayTopNavEvent;
    }

    public final boolean f() {
        return this.optEnterPerf25Q3;
    }

    public final boolean g() {
        return this.optImage;
    }

    public final boolean h() {
        return this.optImageFlicker;
    }

    public final boolean i() {
        return this.optMainThread;
    }

    public final boolean j() {
        return this.optPreloadLayout;
    }

    public final int k() {
        return this.optResponseParse;
    }

    public final boolean l() {
        return this.optWireframeBitmap;
    }

    public final boolean m(int r10) {
        if ((this.optEnterPerf25Q4 & r10) != r10) goto L5;
        return true;
    L5:
        return false;
    }

    public n(boolean r20, boolean r21, boolean r22, int r23, int r24, boolean r25, int r26, boolean r27, int r28, int r29) {
        if ((r29 & 1) == 0) goto L5;
        boolean r10 = false;
    L7:
        if ((r29 & 2) == 0) goto L9;
        boolean r11 = false;
    L11:
        if ((r29 & 4) == 0) goto L13;
        boolean r12 = false;
    L14:
        boolean r13 = true;
        if ((r29 & 8) == 0) goto L17;
        boolean r14 = true;
    L19:
        if ((r29 & 16) == 0) goto L21;
        int r15 = 0;
    L23:
        if ((r29 & 32) == 0) goto L25;
        int r16 = 0;
    L27:
        if ((r29 & 128) == 0) goto L29;
        boolean r17 = false;
    L31:
        if ((r29 & 256) == 0) goto L33;
        int r18 = 0;
    L35:
        if ((r29 & 512) == 0) goto L37;
        boolean r19 = false;
    L39:
        if ((r29 & 1024) == 0) goto L41;
        int r110 = 0;
    L43:
        if ((r29 & 2048) == 0) goto L45;
        boolean r111 = true;
    L47:
        if ((r29 & 4096) != 0) goto L51;
        r13 = false;
    L51:
        if ((r29 & 8192) == 0) goto L53;
        long r112 = 5000;
    L54:
        this.optImage = r10;
        this.optMainThread = r11;
        this.optPreloadLayout = r12;
        this.optDelayTopNavEvent = r14;
        this.headImagePreloadNum = r15;
        this.detailImagePreloadNum = r16;
        this.detailImagePreloadStrategy = 0;
        this.detailImagePreloadAsync = r17;
        this.optResponseParse = r18;
        this.optEnterPerf25Q3 = r19;
        this.optEnterPerf25Q4 = r110;
        this.optImageFlicker = r111;
        this.optWireframeBitmap = r13;
        this.delayInitDuration = r112;
        return;
    L53:
        r112 = 0;
        goto L54
    L45:
        r111 = false;
        goto L47
    L41:
        r110 = r28;
        goto L43
    L37:
        r19 = r27;
        goto L39
    L33:
        r18 = r26;
        goto L35
    L29:
        r17 = r25;
        goto L31
    L25:
        r16 = r24;
        goto L27
    L21:
        r15 = r23;
        goto L23
    L17:
        r14 = false;
        goto L19
    L13:
        r12 = r22;
        goto L14
    L9:
        r11 = r21;
        goto L11
    L5:
        r10 = r20;
        goto L7
    }
}
