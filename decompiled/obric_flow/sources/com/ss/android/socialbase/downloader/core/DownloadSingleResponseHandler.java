package com.ss.android.socialbase.downloader.core;

import ai.j0;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckWifiTaskValidModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.NetworkRetryStrategy;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.RandomAccessOutputStream;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.throttle.SmartThrottleInputStream;
import com.ss.android.socialbase.downloader.network.throttle.ThrottleInputStream;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadFileRandomAccess;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadListenerUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.collections.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadSingleResponseHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DownloadInfo f15297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDownloadCache f15298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NetworkRetryStrategy f15299c;
    public final IDownloadHttpConnection d;
    public final DownloadSetting e;
    public long f;
    public final long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BaseDownloadNetworkModule f15300h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f15301i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f15302j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f15303k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f15304l;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.core.DownloadSingleResponseHandler$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadSingleResponseHandler f15305a;

        public AnonymousClass1(DownloadSingleResponseHandler r5) {
            this.f15305a = r5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f15305a.d.c();
        }
    }

    public DownloadSingleResponseHandler(DownloadCommonParams r5, IDownloadHttpConnection r10, long r11, long r12, BaseDownloadNetworkModule r13) {
        this.f15301i = true;
        this.f15297a = r5.f15310c;
        this.f15298b = r5.f15308a;
        this.f15299c = r5.f15316m;
        this.e = r5.d;
        this.d = r10;
        this.f = r11;
        this.g = r12;
        this.f15300h = r13;
    }

    public final void a() {
        if (this.f15303k == true) goto L10;
        this.f15303k = true;
        if (this.d != null) goto L8;
        return;
    L8:
        DownloadComponentManager.a(new AnonymousClass1(this), true);
        return;
    }

    public final void b() {
        String r10 = "Exception:";
        long r11 = DownloadUtils.a(this.d);
        if (r11 == 0) goto L268;
        long r14 = this.f;
        DownloadInfo r5 = this.f15297a;
        String r16 = " isFirstRead:";
        long r12 = r5.L0;
        RandomAccessOutputStream r18 = null;
        if (r12 <= 0) goto L27;
        int r13 = (int) (r12 - r5.i());
        FileInputStream r15 = new FileInputStream(new File(this.f15297a.q(), this.f15297a.p()));     // Catch: Throwable -> L16
        DownloadFileRandomAccess r17 = new DownloadFileRandomAccess(r15);     // Catch: Throwable -> L16
        r17.f16131b.position(this.f15297a.i());     // Catch: Throwable -> L14
        byte[] r19 = new byte[r13];     // Catch: Throwable -> L14
        if (r17.a(r19, r13) == r13) goto L283;
        DownloadUtils.a(new Closeable[]{r17.f16131b, r15});     // Catch: Throwable -> L275
    L315:
        goto L21
    L283:
        DownloadUtils.a(new Closeable[]{r17.f16131b, r15});     // Catch: Throwable -> L270
    L28:
        IDownloadHttpConnection r20 = this.d;
        if ((r20 instanceof AbsDownloadHttpConnection) == false) goto L31;
        AbsDownloadHttpConnection r21 = (AbsDownloadHttpConnection) r20;
    L285:
        DownloadInfo r22 = this.f15297a;     // Catch: Throwable -> L200 BaseException -> L229
        String r23 = "handleResponse";
        r18 = DownloadHelper.a(r22, r22.q(), this.f15297a.p(), -1, true);     // Catch: Throwable -> L194 BaseException -> L197
        DownloadInfo r24 = this.f15297a;     // Catch: Throwable -> L42 IOException -> L49 BaseException -> L185
        String r110 = "start_offset";
        if (r24.b1 == true) goto L52;
        long r111 = this.f;     // Catch: Throwable -> L42 BaseException -> L46 IOException -> L49
        r24.d();     // Catch: Throwable -> L42 BaseException -> L46 IOException -> L49
        r18.a(r111 - r24.T0.optLong("start_offset"));     // Catch: Throwable -> L42 BaseException -> L46 IOException -> L49
    L46:
        e = e;
        String r25 = "Exception:";
        String r112 = "DownloadSingleResponseHandler";
    L48:
        int r26 = 0;
        r18 = r18;
        InputStream r27 = null;
    L293:
        Logger.a(r112, this.f15297a.l(), r23, r25 + e.toString() + r16 + this.f15301i);     // Catch: Throwable -> L237
        if (this.f15302j == false) goto L234;
    L239:
        if (r26 > 0) goto L305;
    L241:
        if (r18 != null) goto L243;
    L245:
        this.d.c();
        DownloadUtils.a(new Closeable[]{r27});
        DownloadUtils.a(new Closeable[]{r18});
        if (r21 != null) goto L248;
        return;
    L248:
        if (TextUtils.isEmpty("") == true) goto L346;
        DownloadInfo r28 = this.f15297a;
        r28.E0 = "";
        if (r28.f15812c1 == false) goto L347;
        DownloadStatusHandler r29 = this.f15300h.e;
    L252:
        DownloadListenerUtils.a(3, r29.f15552h, r29.f15551c, 0, null, "");
        return;
    L347:
        return;
    L346:
        return;
    L243:
        if (this.f15303k == true) goto L245;
        d();
        goto L245
    L305:
        this.f15300h.a(r26);     // Catch: Throwable -> L271
        goto L241
    L234:
        if (this.f15303k == true) goto L239;
        throw e;     // Catch: Throwable -> L237
    L237:
        th = th;
        int r113 = r26;
        InputStream r30 = r27;
        r18 = r18;
    L254:
        if (r113 > 0) goto L311;
    L256:
        if (r18 != null) goto L258;
    L260:
        this.d.c();
        DownloadUtils.a(new Closeable[]{r30});
        DownloadUtils.a(new Closeable[]{r18});
        if (r21 != null) goto L263;
        throw th;
    L263:
        if (TextUtils.isEmpty("") == true) goto L351;
        DownloadInfo r31 = this.f15297a;
        r31.E0 = "";
        if (r31.f15812c1 == false) goto L352;
        DownloadStatusHandler r32 = this.f15300h.e;
        DownloadListenerUtils.a(3, r32.f15552h, r32.f15551c, 0, null, "");
        throw th;
    L352:
        throw th;
    L351:
        throw th;
    L258:
        if (this.f15303k == true) goto L260;
        d();
        goto L260
    L311:
        this.f15300h.a(r113);     // Catch: Throwable -> L272
    L52:
        r30 = this.d.a();     // Catch: Throwable -> L42 BaseException -> L185
        DownloadInfo r114 = this.f15297a;     // Catch: Throwable -> L58 BaseException -> L183
        if (r114.f15836s0 == 0) goto L307;
    L63:
        boolean r115 = this.f15297a.I;     // Catch: Throwable -> L58 BaseException -> L183
        if (this.e.a("use_default_throttle_speed", 1) != 1) goto L70;
        long r116 = this.f15297a.I0;     // Catch: Throwable -> L58 BaseException -> L60
        if (r116 != (-1)) goto L68;
    L69:
        this.f15304l = true;     // Catch: Throwable -> L58 BaseException -> L60
        goto L70
    L68:
        if (r116 > 0) goto L69;
    L70:
        int r33 = DownloadComponentManager.C;     // Catch: Throwable -> L58 BaseException -> L183
        if (r21 == null) goto L79;
        String r34 = DownloadConstants.f15275a;     // Catch: Throwable -> L58 BaseException -> L60
        ArrayList r210 = r21.d();     // Catch: Throwable -> L58 BaseException -> L60
        if (r210 == null) goto L76;
        this.f15297a.D0 = r210.toString();     // Catch: Throwable -> L58 BaseException -> L60
    L76:
        if (this.f15297a.f15812c1 == false) goto L78;
        DownloadStatusHandler r35 = this.f15300h.e;     // Catch: Throwable -> L58 BaseException -> L60
        DownloadListenerUtils.a(2, r35.f15552h, r35.f15551c, 0, r210, null);     // Catch: Throwable -> L58 BaseException -> L60
    L60:
        e = e;
        r18 = r18;
        r27 = r30;
        r25 = "Exception:";
        r112 = "DownloadSingleResponseHandler";
        r16 = r16;
        r23 = r23;
    L62:
        r26 = 0;
    L78:
        r33 = 8192;
    L79:
        byte[] r117 = new byte[r33];     // Catch: Throwable -> L58 BaseException -> L183
        String r211 = "DownloadSingleResponseHandler";
        r113 = 0;
        long r212 = 0;
    L302:
        if (this.f15304l == true) goto L313;
    L90:
        SparseArray r36 = DownloadHelper.f16133a;     // Catch: Throwable -> L86 BaseException -> L181
        int r37 = r30.read(r117);     // Catch: Throwable -> L86 BaseException -> L181
        r10 = r10;
        if (r37 == (-1)) goto L93;
        if (r115 == true) goto L107;
        int r213 = r33;
        long r38 = this.g;     // Catch: Throwable -> L102 BaseException -> L104
        long r39 = r11;
        long r118 = this.f - r14;     // Catch: Throwable -> L102 BaseException -> L104
        if (r38 <= r118) goto L101;
        String r310 = r110;
        boolean r311 = r115;
        if (r38 >= (((long) r37) + r118)) goto L109;
        r37 = (int) (r38 - r118);     // Catch: Throwable -> L102 BaseException -> L104
    L109:
        if (this.f15301i == false) goto L125;
        this.f15301i = false;     // Catch: Throwable -> L102 BaseException -> L104
        this.f15299c.b();     // Catch: Throwable -> L102 BaseException -> L104
        if (this.f15297a.L0 <= 0) goto L125;
        if (r19 == null) goto L125;
        if (r19.length < r13) goto L125;
        r33 = r213;
        if (r33 < r13) goto L126;
        int r40 = 0;
    L119:
        if (r40 >= r13) goto L126;
        if (r19[r40] != r117[r40]) goto L124;
        r40 = r40 + 1;     // Catch: Throwable -> L102 BaseException -> L104
        goto L119
    L124:
        throw new BaseException(1051, "Fail to verify data");     // Catch: Throwable -> L102 BaseException -> L104
    L126:
        r18.a(r117, r37);     // Catch: Throwable -> L102 BaseException -> L104
        this.f += (long) r37;     // Catch: Throwable -> L102 BaseException -> L104
        int r41 = r113 + r37;
        if (this.f15297a.f15812c1 == false) goto L135;
        DownloadStatusHandler r119 = this.f15300h.e;     // Catch: Throwable -> L131 BaseException -> L133
        DownloadListenerUtils.a(1, r119.f15552h, r119.f15551c, r37, null, null);     // Catch: Throwable -> L131 BaseException -> L133
    L135:
        long r120 = SystemClock.uptimeMillis();     // Catch: Throwable -> L131 BaseException -> L133
        if ((r120 - r212) > 1000) goto L138;
        r113 = r41;
    L150:
        if (r311 == true) goto L180;
        long r121 = this.g;     // Catch: Throwable -> L102 BaseException -> L104
        if (r121 < 0) goto L180;
        if (r121 > (this.f - r14)) goto L180;
    L156:
        if (r113 <= 0) goto L159;
        this.f15300h.a(r113);     // Catch: Throwable -> L273
    L159:
        if (this.f15303k == true) goto L161;
        d();
    L161:
        this.d.c();
        DownloadUtils.a(new Closeable[]{r30});
        DownloadUtils.a(new Closeable[]{r18});
        if (r21 == null) goto L169;
        if (TextUtils.isEmpty("") == true) goto L169;
        DownloadInfo r42 = this.f15297a;
        r42.E0 = "";
        if (r42.f15812c1 == false) goto L169;
        DownloadStatusHandler r43 = this.f15300h.e;
        DownloadListenerUtils.a(3, r43.f15552h, r43.f15551c, 0, null, "");
    L169:
        if (this.f15297a.I == true) goto L348;
        long r44 = this.f - r14;
        if (r44 < 0) goto L340;
        long r45 = this.g;
        if (r45 >= 0) goto L176;
        return;
    L176:
        if (r45 == r44) goto L349;
        Locale r46 = Locale.US;
        long r47 = this.g;
        DownloadInfo r48 = this.f15297a;
        r48.d();
        long r49 = r48.T0.optLong(r310);
        long r50 = this.f15297a.k();
        long r122 = this.f;
        StringBuilder r51 = j0.t(r44, "handle data length[", "] != content length[");
        r51.append(r39);
        a.o(r51, "] downloadChunkContentLen[", r47, "], range[");
        r51.append(r49);
        a.o(r51, ", ", r50, ") , current offset[");
        r51.append(r122);
        r51.append("] , handle start from ");
        r51.append(r14);
        throw new BaseException(1051, r51.toString());
    L349:
        return;
    L340:
        return;
    L348:
        return;
    L180:
        r11 = r39;
        r14 = r14;
        r10 = r10;
        r115 = r311;
        r110 = r310;
        goto L302
    L138:
        if (this.f15300h.a(r41) == true) goto L323;
    L147:
        DownloadCheckWifiTaskValidModule.a(this.f15297a);     // Catch: Throwable -> L142 BaseException -> L144
        r212 = r120;
        r113 = 0;
        goto L150
    L323:
        if (this.f15303k == true) goto L147;
        d();     // Catch: Throwable -> L142 BaseException -> L144
        goto L147
    L144:
        e = e;
    L145:
        r18 = r18;
        r27 = r30;
    L146:
        r23 = r23;
        r112 = r211;
        r25 = r10;
    L142:
        th = th;
    L45:
        r113 = 0;
    L298:
        String r123 = r211;
        Logger.a(r123, this.f15297a.l(), r23, r10 + th.toString() + r16 + this.f15301i);     // Catch: Throwable -> L211
        if (this.f15302j == false) goto L207;
    L216:
        if (r113 > 0) goto L309;
    L218:
        if (r18 != null) goto L220;
    L222:
        this.d.c();
        DownloadUtils.a(new Closeable[]{r30});
        DownloadUtils.a(new Closeable[]{r18});
        if (r21 != null) goto L225;
        return;
    L225:
        if (TextUtils.isEmpty("") == true) goto L343;
        DownloadInfo r52 = this.f15297a;
        r52.E0 = "";
        if (r52.f15812c1 == false) goto L344;
        r29 = this.f15300h.e;
        goto L252
    L344:
        return;
    L343:
        return;
    L220:
        if (this.f15303k == true) goto L222;
        d();
        goto L222
    L309:
        this.f15300h.a(r113);     // Catch: Throwable -> L274
        goto L218
    L207:
        if (this.f15303k == true) goto L216;
        DownloadHelper.a(th, "ResponseHandler");     // Catch: Throwable -> L211 BaseException -> L213
        throw null;     // Catch: Throwable -> L211 BaseException -> L213
    L213:
        e = move-exception;
        DownloadHelper.a(this.d, e);     // Catch: Throwable -> L211
        throw e;     // Catch: Throwable -> L211
    L211:
        th = th;
        goto L254
    L133:
        e = e;
        r27 = r30;
        r26 = r41;
    L106:
        r16 = r16;
        r23 = r23;
        r112 = r211;
        r25 = r10;
    L131:
        th = th;
        r113 = r41;
    L125:
        r33 = r213;
    L101:
        r310 = r110;
        r311 = r115;
    L104:
        e = e;
    L105:
        r27 = r30;
        r26 = r113;
    L102:
        th = th;
        goto L298
    L107:
        r213 = r33;
        r39 = r11;
        goto L101
    L93:
        r39 = r11;
        r310 = r110;
        goto L156
    L313:
        this.f15304l = false;     // Catch: Throwable -> L86 BaseException -> L88
        r30 = a(r30);     // Catch: Throwable -> L86 BaseException -> L88
    L88:
        e = e;
        r18 = r18;
        r27 = r30;
        r25 = r10;
        r26 = r113;
        r16 = r16;
        r23 = r23;
        r112 = r211;
    L181:
        e = e;
        r10 = r10;
    L86:
        th = th;
        r10 = r10;
        goto L298
    L307:
        r114.f15836s0 = System.nanoTime();     // Catch: Throwable -> L58 BaseException -> L60
    L58:
        th = th;
        r10 = "Exception:";
        r211 = "DownloadSingleResponseHandler";
    L183:
        e = e;
        r10 = "Exception:";
        r211 = "DownloadSingleResponseHandler";
        goto L145
    L42:
        th = th;
        r10 = "Exception:";
        r211 = "DownloadSingleResponseHandler";
    L44:
        r30 = null;
    L49:
        e = move-exception;
        r10 = "Exception:";
        r211 = "DownloadSingleResponseHandler";
    L192:
        e = e;
    L187:
        r112 = r211;
        r25 = r10;
    L190:
        th = th;
        goto L44
    L189:
        throw new BaseException(1054, DownloadUtils.a(e));     // Catch: Throwable -> L190 BaseException -> L192
    L185:
        e = e;
        r10 = "Exception:";
        r211 = "DownloadSingleResponseHandler";
        goto L187
    L197:
        e = e;
    L199:
        r211 = "DownloadSingleResponseHandler";
        r27 = null;
    L194:
        th = th;
    L196:
        r211 = "DownloadSingleResponseHandler";
        r18 = null;
        r30 = null;
        goto L45
    L202:
        e = e;
        r23 = "handleResponse";
    L229:
        e = e;
        r23 = "handleResponse";
        r112 = "DownloadSingleResponseHandler";
        r16 = r16;
        r25 = "Exception:";
        r27 = null;
    L200:
        th = th;
        r23 = "handleResponse";
        goto L196
    L31:
        r21 = null;
    L14:
        th = th;
    L318:
        th.printStackTrace();     // Catch: Throwable -> L22
        if (r17 == null) goto L21;
        DownloadUtils.a(new Closeable[]{r17.f16131b, r17.f16130a});     // Catch: Throwable -> L275
    L22:
        th = move-exception;
        if (r17 == null) goto L338;
        DownloadUtils.a(new Closeable[]{r17.f16131b, r17.f16130a});     // Catch: Throwable -> L276
        throw th;
    L339:
        throw th;
    L338:
        throw th;
    L16:
        th = th;
        r17 = null;
    L21:
        r19 = null;
        goto L28
    L27:
        r19 = null;
        r13 = 0;
        goto L28
    L268:
        this.d.c();
        throw new DownloadRetryNeedlessException(PointerIconCompat.TYPE_WAIT, "the content-length is 0");
    }

    public final void c() {
        if (this.f15302j == true) goto L10;
        this.f15302j = true;
        if (this.d != null) goto L8;
        return;
    L8:
        DownloadComponentManager.a(new AnonymousClass1(this), true);
        return;
    }

    public final void d() {
        this.f15297a.a(true);     // Catch: Exception -> L4
        this.f15298b.a(this.f15297a);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public final ThrottleInputStream a(InputStream r10) {
        if ((r10 instanceof ThrottleInputStream) == false) goto L5;
        ThrottleInputStream r11 = (ThrottleInputStream) r10;
    L22:
        DownloadInfo r12 = this.f15297a;
        long r5 = r12.I0;
        int r13 = r12.J0;
        r11.f15990b = r5;
        if (r13 >= 1) goto L25;
    L27:
        r11.d = 1000 / r11.f15991c;
        r11.e = r5 / ((long) r11.f15991c);
        return r11;
    L25:
        if (r13 > 100) goto L27;
        r11.f15991c = r13;
        goto L27
    L5:
        DownloadSetting r14 = this.e;
        JSONObject r15 = r14.f16108a;
        if (r15 != null) goto L8;
    L12:
        double r16 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optDouble("throttle_factor_min", 0.10000000149011612d);
    L13:
        float r17 = (float) r16;
        DownloadSetting r18 = this.e;
        JSONObject r19 = r18.f16108a;
        if (r19 != null) goto L16;
    L20:
        double r20 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optDouble("throttle_factor_max", 0.699999988079071d);
    L21:
        r11 = new SmartThrottleInputStream(r10, r17, (float) r20);
        goto L22
    L16:
        if (r19.has("throttle_factor_max") == false) goto L20;
        if (DownloadSetting.a("throttle_factor_max") == true) goto L20;
        r20 = r18.f16108a.optDouble("throttle_factor_max", 0.699999988079071d);
        goto L21
    L8:
        if (r15.has("throttle_factor_min") == false) goto L12;
        if (DownloadSetting.a("throttle_factor_min") == true) goto L12;
        r16 = r14.f16108a.optDouble("throttle_factor_min", 0.10000000149011612d);
        goto L13
    }
}
