package oo1;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.nio.ByteBuffer;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g extends PthreadThreadV2 implements d.a {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public String G;
    public final j H;
    public final AtomicBoolean v;
    public Context w;
    public final CopyOnWriteArrayList<b> x;
    public String y;
    public int z;

    public static final class a {
    }

    static {
    }

    @Override // oo1.d.a
    public final void b(int r1) {
    }

    @Override // oo1.d.a
    public final void d(int r1) {
    }

    public final void l() {
        StringBuilder r0 = new StringBuilder("init 是否可以init音频数据:");
        boolean r3 = true;
        r0.append(!this.v.get());
        ALogger.d("VSAudioDataPushThread", r0.toString());
    L4:
        if (this.v.get() == true) goto L9;
        d r1 = f.a;     // Catch: Exception -> L7
        f.b = this.w;     // Catch: Exception -> L7
        f.d = this;     // Catch: Exception -> L7
        f.b(this.A, this.B, this.C, this.D, this.E);     // Catch: Exception -> L7
        this.v.set(true);     // Catch: Exception -> L7
        ALogger.d("VSAudioDataPushThread", "初始化成功");     // Catch: Exception -> L7
    L7:
        e = move-exception;
        ALogger.d("VSAudioDataPushThread", "startRecord Fail:" + e.getMessage());
        this.v.set(false);
        goto L4
    L9:
        ALogger.d("VSAudioDataPushThread", "push 是否可以push音频数据:" + e.f.get());
    L10:
        AtomicBoolean r2 = e.f;
        String r6 = "QuickInsideRecordManager";
        if (r2.get() == false) goto L52;
        ALogger.d("VSAudioDataPushThread", "push 是否有可push的音频数据:" + (CollectionUtils.isEmpty(this.x) ^ r3));
    L14:
        if (CollectionUtils.isEmpty(this.x) == true) goto L10;
        b r4 = (b) CollectionsKt.first(this.x);     // Catch: Exception -> L17
    L18:
        if (r4 == null) goto L47;
        d r5 = f.a;
        byte[] r7 = r4.a;
        int r8 = r4.b;
        int r9 = this.D;
        int r10 = this.E;
        ALogger.d(r6, "pushAudioFrame samples:" + r8 + " channel:" + r9 + " audioFormat:" + r10);
        if (r7 == null) goto L45;
        int r11 = r8 * (r9 * (r10 / 8));
        d r12 = f.a;
        if (r12 == null) goto L45;
        if (r12.c == null) goto L45;
        if (e.d.get() == true) goto L45;
        if (e.e.get() == true) goto L45;
        int r13 = r12.c.dequeueInputBuffer(0);     // Catch: Exception -> L42
        if (r13 >= 0) goto L33;
        ALogger.d("MediaEncodeManager", "return  buffIndex 为:" + r13);     // Catch: Exception -> L42
        goto L45
    L33:
        ByteBuffer r14 = r12.c.getInputBuffer(r13);     // Catch: Exception -> L42
        if (r14 == null) goto L45;
        r14.clear();     // Catch: Exception -> L42
        r14.put(r7);     // Catch: Exception -> L42
        String r16 = r6;
        r12.k = r12.k + ((long) (((((double) r11) * 1.0d) / ((r12.h * ((long) r12.i)) * ((long) (r12.j / 8)))) * 1000000.0d));     // Catch: Exception -> L40
        ALogger.d("MediaEncodeManager", "pcm一帧时间戳 = " + (r12.k / 1000000.0f));     // Catch: Exception -> L40
        r12.c.queueInputBuffer(r13, 0, r11, r12.k, 0);     // Catch: Exception -> L40
    L46:
        ALogger.d("VSAudioDataPushThread", "pushFrame");
    L57:
        this.x.remove(0);     // Catch: Exception -> L50
    L51:
        r6 = r16;
        r3 = true;
    L40:
        e = e;
    L44:
        ALogger.d("MediaEncodeManager", "setPcmSource: MediaCodec对象已释放 msg:" + e.getMessage());
    L42:
        e = e;
        r16 = r6;
    L45:
        r16 = r6;
        goto L46
    L47:
        r16 = r6;
    L17:
        r4 = null;
        goto L18
    L52:
        ALogger.d("VSAudioDataPushThread", "stop pushFrame");
        r2.set(false);
        d r15 = f.a;
        ALogger.i("QuickInsideRecordManager", "stopRecord");
        d r17 = f.a;
        if (r17 == null) goto L55;
        r17.a();
    L55:
        this.y = f.c;
        ALogger.i("QuickInsideRecordManager", "releaseRecorder");
        f.c = "";
    }

    public final void run() {
        l();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public final Context getContext() {
        return this.w;
    }

    public g(j r2) {
        super("VSAudioDataPushThread");
        this.H = r2;
        this.v = new AtomicBoolean(false);
        this.x = new CopyOnWriteArrayList();
        this.y = "";
        this.G = "";
    }

    @Override // oo1.d.a
    public final void c(String r2, String r3, int r4) {
        this.z++;
        ALogger.i("VSAudioDataPushThread", "processFinish threadFinishNum:" + this.z);
        if (TextUtils.isEmpty(r3) == false) goto L5;
        if (r4 > 0) goto L5;
    L7:
        if (this.z != 2) goto L13;
        j r5 = this.H;
        if (r5 == null) goto L11;
        r5.b(this.y, this.G, this.F);
    L11:
        this.G = "";
        this.F = 0;
        return;
    L13:
        return;
    L5:
        this.G = r3;
        this.F = r4;
        goto L7
    }
}
