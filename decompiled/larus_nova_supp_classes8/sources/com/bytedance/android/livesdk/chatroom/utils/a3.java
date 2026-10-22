package com.bytedance.android.livesdk.chatroom.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.fresco.ImageNetworkRequestsMonitor;
import com.bytedance.android.livesdk.chatroom.utils.pngloader.FlexData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a3 {
    public static final /* synthetic */ int d = 0;
    public FlexData a;
    public Rect b;
    public String c;

    public static final class a {
        public static void a(View r5, py.k r6, b r7, float r8) {
            a3 r0 = new a3();
            if (r6 != null) goto L5;
            return;
        L5:
            if (r6.getUrls().isEmpty() == true) goto L19;
            r0.c = (String) ListProtector.get(r6.getUrls(), 0);
            ImagePipeline r1 = Fresco.getImagePipeline();
            List r9 = r6.getUrls();
            if (r9 != null) goto L10;
        L15:
            String r10 = null;
        L16:
            ImageRequestBuilder r11 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r10));
            new ImageNetworkRequestsMonitor().monitor(r11);
            Unit r2 = Unit.INSTANCE;
            r1.fetchEncodedImage(r11.build(), null).subscribe(new b3(r0, r7, r5, r8), UiThreadImmediateExecutorService.getInstance());
            return;
        L10:
            if ((!r9.isEmpty()) == true) goto L13;
            r9 = null;
        L13:
            if (r9 == null) goto L15;
            r10 = (String) ListProtector.get(r9, 0);
            goto L16
        }
    }

    public interface b {
        void a(NinePatchDrawable r1);

        void onFail();
    }

    static {
    }

    public static int c(int r0, int r1) {
        if (r0 >= 0) goto L4;
        return 0;
    L4:
        if (r0 > r1) goto L6;
        return r0;
    L6:
        return r1;
    }

    public a3() {
        this.b = new Rect(0, 0, 0, 0);
    }

    public final void d(InputStream r3) {
        po1.d r0 = new po1.d(r3);     // Catch: Exception -> L4
        this.a = r0.b();     // Catch: Exception -> L4
        r0.close();     // Catch: Exception -> L4
        r3.close();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        StringBuilder r1 = new StringBuilder("getXmpChunkFlexData PngLoader exception ");
        e.printStackTrace();
        r1.append(Unit.INSTANCE);
        e(r1.toString());
    }

    public final void e(String r7) {
        JSONObject r5 = new JSONObject();
        r5.put("errorMsg", r7);
        r5.put("image_url", this.c);
        LiveTracingMonitor.EventModule r1 = LiveTracingMonitor.EventModule.common;
        SettingKey r8 = LiveTracingMonitor.a;
        LiveTracingMonitor.e("ttlive_resizable_load_fail", r1, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, null, null, r5);
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0060: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:50331744), block:B:31:0x0060 */
    public final Pair b(String r6, float r7, boolean r8) {
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        InputStream r3 = null;
        if (r2 == false) goto L13;
        e("loadLocalResizableImg path is empty");
        return null;
    L13:
        this.c = r6;
        PolarisFileInputStreamWrapper r4 = new PolarisFileInputStreamWrapper(r6);     // Catch: Throwable -> L34 Exception -> L36
        d(r4);     // Catch: Throwable -> L30 Exception -> L32
        Bitmap r9 = BitmapFactory.decodeFile(r6);     // Catch: Throwable -> L30 Exception -> L32
        if (r9 == null) goto L24;
        NinePatchDrawable r10 = a(r9, null, r7, r8);     // Catch: Throwable -> L30 Exception -> L32
        if (r10 == null) goto L22;
        Pair r11 = new Pair(r10, r9);     // Catch: Throwable -> L30 Exception -> L32
        r4.close();
        return r11;
    L22:
        r4.close();
        return null;
    L24:
        e("loadLocalResizableImg srcBitmap is null");     // Catch: Throwable -> L30 Exception -> L32
        r4.close();     // Catch: IOException -> L27
    L29:
        return null;
    L27:
        e = move-exception;
        e("loadLocalResizableImg " + e.getMessage() + '}');
    L32:
        e = e;
    L38:
        e("loadLocalResizableImg getImageFilePath " + e.getMessage());     // Catch: Throwable -> L30
        if (r4 != null) goto L53;
    L44:
        return null;
    L53:
        r4.close();     // Catch: IOException -> L42
    L42:
        e = move-exception;
        e("loadLocalResizableImg " + e.getMessage() + '}');
        goto L44
    L30:
        th = th;
        r3 = r4;
    L45:
        if (r3 != null) goto L55;
    L50:
        throw th;
    L55:
        r3.close();     // Catch: IOException -> L48
    L48:
        e = move-exception;
        e("loadLocalResizableImg " + e.getMessage() + '}');
    L36:
        e = e;
        r4 = null;
    L34:
        th = th;
        goto L45
    L5:
        if (r6.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final NinePatchDrawable a(Bitmap r25, View r26, float r27, boolean r28) {
        Intrinsics.checkNotNullParameter(r25, "srcBitmap");
        if (r27 <= 0) goto L5;
        float r1 = r27;
    L11:
        FlexData r2 = this.a;
        if (r2 != null) goto L14;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == true) goto L20;
        r2 = null;
    L20:
        if (r2 == null) goto L67;
        int r4 = (int) (r25.getWidth() * r1);
        int r5 = (int) (r25.getHeight() * r1);
        ArrayList r6 = new ArrayList();
        ArrayList r7 = new ArrayList();
        float[] r12 = r2.textSetting;
        float r8 = r4;
        this.b.left = c((int) ((r12[2] / 100.0f) * r8), r4);
        this.b.right = c((int) ((r12[3] / 100.0f) * r8), r4);
        float r10 = r5;
        this.b.top = c((int) ((r12[0] / 100.0f) * r10), r5);
        this.b.bottom = c((int) ((r12[1] / 100.0f) * r10), r5);
        float[] r9 = r2.flexSetting;
        float r13 = (r9[2] / 100.0f) * r8;
        float r11 = r8 - ((r9[3] / 100.0f) * r8);
        r6.add(Integer.valueOf((int) r13));
        r6.add(Integer.valueOf((int) r11));
        float r14 = (r9[0] / 100.0f) * r10;
        float r15 = r10 - ((r9[1] / 100.0f) * r10);
        r7.add(Integer.valueOf((int) r14));
        r7.add(Integer.valueOf((int) r15));
        if (r7.isEmpty() == false) goto L24;
    L26:
        boolean r16 = false;
    L27:
        if (r16 == false) goto L65;
        int r17 = r6.size();
        int r18 = r7.size();
        Integer r19 = (Integer) ListProtector.get(r6, 0);
        if (r19 != null) goto L32;
    L34:
        Integer r110 = (Integer) ListProtector.get(r6, r6.size() - 1);
        if (r110 != null) goto L38;
    L40:
        Integer r111 = (Integer) ListProtector.get(r7, 0);
        if (r111 != null) goto L44;
    L46:
        Integer r112 = (Integer) ListProtector.get(r7, r7.size() - 1);
        if (r112 != null) goto L50;
    L52:
        int r20 = r17 * r18;
        ByteBuffer r21 = ByteBuffer.allocate((((r6.size() + 8) + r7.size()) + r20) * 4).order(ByteOrder.nativeOrder());
        r21.put((byte) 1);
        r21.put((byte) r6.size());
        r21.put((byte) r7.size());
        r21.put((byte) r20);
        r21.putInt(0);
        r21.putInt(0);
        r21.putInt(this.b.left);
        r21.putInt(this.b.right);
        r21.putInt(this.b.top);
        r21.putInt(this.b.bottom);
        r21.putInt(0);
        Iterator r22 = r6.iterator();
    L54:
        if (r22.hasNext() == false) goto L56;
        r21.putInt(c(((Integer) r22.next()).intValue(), r4));
        goto L54
    L56:
        Iterator r23 = r7.iterator();
    L58:
        if (r23.hasNext() == false) goto L60;
        r21.putInt(c(((Integer) r23.next()).intValue(), r5));
        goto L58
    L60:
        int r24 = 0;
    L61:
        if (r24 >= r20) goto L63;
        r21.putInt(1);
        r24 = r24 + 1;
        goto L61
    L63:
        byte[] r29 = r21.array();
    L80:
        if (r29 == null) goto L82;
        boolean r30 = true;
    L83:
        if (r30 == false) goto L85;
        byte[] r210 = r29;
    L86:
        if (r210 == null) goto L95;
        int r31 = r25.getWidth();
        int r32 = r25.getHeight();
        Matrix r33 = new Matrix();
        r33.postScale(r1, r1);
        Unit r34 = Unit.INSTANCE;
        Bitmap r35 = Bitmap.createBitmap(r25, 0, 0, r31, r32, r33, true);
        if ((!Intrinsics.areEqual(r35, r25)) == false) goto L91;
        if (r28 == false) goto L91;
        r25.recycle();
    L91:
        NinePatchDrawable r36 = new NinePatchDrawable(com.bytedance.android.live.core.utils.s1.getResources(), r35, r210, this.b, null);
        r36.setBounds(0, 0, r36.getIntrinsicWidth(), r36.getIntrinsicHeight());
        if (r26 == null) goto L94;
        r26.setBackground(r36);
        Rect r37 = this.b;
        r26.setPadding(r37.left, r37.top, r37.right, r37.bottom);
    L94:
        return r36;
    L95:
        return null;
    L85:
        r210 = null;
        goto L86
    L82:
        r30 = false;
        goto L83
    L50:
        if (r112.intValue() != r5) goto L52;
        r18 = r18 - 1;
        goto L52
    L44:
        if (r111.intValue() != 0) goto L46;
        r18 = r18 - 1;
        goto L46
    L38:
        if (r110.intValue() != r4) goto L40;
        r17 = r17 - 1;
        goto L40
    L32:
        if (r19.intValue() != 0) goto L34;
        r17 = r17 - 1;
        goto L34
    L65:
        throw new IllegalArgumentException("Regions must not be empty!".toString());
    L24:
        if (r6.isEmpty() == true) goto L26;
        r16 = true;
        goto L27
    L67:
        if (r25.getNinePatchChunk() == null) goto L79;
        ByteBuffer r38 = ByteBuffer.wrap(r25.getNinePatchChunk()).order(ByteOrder.nativeOrder());
        if (r38 != null) goto L71;
    L73:
        boolean r39 = false;
    L74:
        if (r39 == true) goto L77;
        r38 = null;
    L77:
        if (r38 == null) goto L79;
        r38.get();
        r38.get();
        r38.get();
        r38.getInt();
        r38.getInt();
        this.b.left = (int) (r38.getInt() * r1);
        this.b.right = (int) (r38.getInt() * r1);
        this.b.top = (int) (r38.getInt() * r1);
        this.b.bottom = (int) (r38.getInt() * r1);
        goto L79
    L71:
        if (r38.get() == 0) goto L73;
        r39 = true;
    L79:
        r29 = a1.f(r25.getNinePatchChunk(), r1, false, false);
        goto L80
    L14:
        if (Build.VERSION.SDK_INT < 28) goto L16;
        r3 = true;
        goto L17
    L5:
        Resources r40 = com.bytedance.android.live.core.utils.s1.getResources();
        if (r40 == null) goto L10;
        DisplayMetrics r41 = WindowDisplayMetricsOverride.apply(r40, r40.getDisplayMetrics());
        if (r41 == null) goto L10;
        r1 = r41.density / 3.0f;
    L10:
        r1 = 1.0f;
        goto L11
    }
}
