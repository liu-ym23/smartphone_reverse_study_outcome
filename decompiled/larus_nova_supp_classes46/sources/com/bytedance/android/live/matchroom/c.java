package com.bytedance.android.live.matchroom;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface c {

    public static final class a {
        public static void b(c r24, Paint r25, float r26, float r27, String r28) {
            Intrinsics.checkNotNullParameter(r25, "paint");
            Intrinsics.checkNotNullParameter(r28, "logTag");
            if (r25.getShader() != null) goto L20;
            List r4 = StringsKt.split$default(r24.getInputColors(), new char[]{','}, false, 0, 6, null);     // Catch: Exception -> L14
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));     // Catch: Exception -> L14
            Iterator r6 = r4.iterator();     // Catch: Exception -> L14
        L6:
            if (r6.hasNext() == false) goto L8;
            r5.add(Integer.valueOf(Color.parseColor((String) r6.next())));     // Catch: Exception -> L14
            goto L6
        L8:
            int[] r17 = CollectionsKt.toIntArray(r5);     // Catch: Exception -> L14
            List r3 = StringsKt.split$default(r24.getInputPositions(), new char[]{','}, false, 0, 6, null);     // Catch: Exception -> L14
            ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));     // Catch: Exception -> L14
            Iterator r8 = r3.iterator();     // Catch: Exception -> L14
        L10:
            if (r8.hasNext() == false) goto L12;
            r7.add(Float.valueOf(CastFloatProtector.parseFloat((String) r8.next())));     // Catch: Exception -> L14
            goto L10
        L12:
            r25.setShader(new LinearGradient(0.0f, r26, r27, r26, r17, CollectionsKt.toFloatArray(r7), Shader.TileMode.CLAMP));     // Catch: Exception -> L14
            return;
        L14:
            ALogger.e(r28, "parse error for " + r24.getInputColors() + '-' + r24.getInputPositions());
            r24.setInputColors("#00000000,#26000000,#4D000000,#73000000,#99000000,#B2000000,#C7000000,#D9000000,#E5000000");
            r24.setInputPositions("0.0,0.11,0.21,0.32,0.45,0.58,0.7,0.84,1.0");
            return;
        }

        public static void a(c r7, Canvas r8, Paint r9, float r10, float r11, String r12) {
            Intrinsics.checkNotNullParameter(r9, "paint");
            Intrinsics.checkNotNullParameter(r12, "logTag");
            if (r7.getEnableShader() == false) goto L8;
            r7.Y0(r9, r10, r11, r12);
            if (r8 == null) goto L9;
            r8.drawRect(0.0f, 0.0f, r11, r10, r9);
            return;
        L9:
            return;
        }
    }

    void Y0(Paint r1, float r2, float r3, String r4);

    boolean getEnableShader();

    String getInputColors();

    String getInputPositions();

    void setInputColors(String r1);

    void setInputPositions(String r1);
}
