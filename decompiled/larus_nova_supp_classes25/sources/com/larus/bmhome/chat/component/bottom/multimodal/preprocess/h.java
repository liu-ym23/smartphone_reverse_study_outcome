package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import android.graphics.Bitmap;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.platform.service.z2;
import hq9.w1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ProcessFileResultCode.values().length];
            r0[ProcessFileResultCode.PREPARE_COMPRESSED_SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[ProcessFileResultCode.PREPARE_GIF_PROCESS_SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[ProcessFileResultCode.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[ProcessFileResultCode.PREPARE_ORIGINAL_RES_CLONE_SUCCESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[ProcessFileResultCode.PREPARE_CLONE_SUCCESS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
    }

    public static boolean b(String r3) {
        Object r1 = null;
        if (r3 == null) goto L19;
        if ((!StringsKt.isBlank(r3)) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L19;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        Object r4 = Result.constructor-impl(UriProtector.parse(r3).getScheme());     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r4) == true) goto L17;
        r1 = r4;
    L17:
        r1 = (String) r1;
    L11:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L19:
        if (Intrinsics.areEqual(r1, "content") == false) goto L21;
        return true;
    L21:
        if (Intrinsics.areEqual(r1, "file") == true) goto L28;
        return false;
    L28:
        return true;
    }

    public static mr9.c a(ns8.a r16, ProcessFileResultCode r17, boolean r18, ns8.b r19) {
        if (r17 != null) goto L5;
        int r2 = -1;
    L7:
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L14;
        if (r2 == 3) goto L13;
        if (r2 == 4) goto L13;
        if (r2 == 5) goto L13;
        return null;
    L13:
        Object r3 = "identity";
    L17:
        if (Intrinsics.areEqual(r3, "identity") == false) goto L19;
        LinkedHashMap r0 = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("data_type", UploadDataType.IMAGE.getType()), TuplesKt.to("transform", "identity")});
    L136:
        if (Intrinsics.areEqual(r3, "identity") == false) goto L138;
        String r4 = "image_identity";
    L140:
        return new mr9.c(r4, 1, r0);
    L138:
        r4 = "image_chat";
        goto L140
    L19:
        String r6 = "jpeg";
        if (Intrinsics.areEqual(r3, "gif_first_frame") == false) goto L26;
        Pair[] r1 = new Pair[5];
        r1[0] = TuplesKt.to("data_type", UploadDataType.IMAGE.getType());
        r1[1] = TuplesKt.to("transform", "gif_first_frame");
        r1[2] = TuplesKt.to("output_format", "jpeg");
        r1[3] = TuplesKt.to("quality", "100");
        if (r17 == null) goto L24;
        String r8 = r17.getValue();
    L25:
        r1[4] = TuplesKt.to("result_code", r8);
        r0 = MapsKt.linkedMapOf(r1);
        goto L136
    L24:
        r8 = null;
        goto L25
    L26:
        if (r18 == false) goto L29;
        if (r16 != null) goto L29;
        w1 r10 = z2.a.imageUploadOptConfig();
    L30:
        if (r16 == null) goto L34;
        Integer r12 = r16.c;
        if (r12 == null) goto L34;
    L45:
        int r5 = r12.intValue();
    L47:
        if (r16 == null) goto L50;
        Integer r7 = r16.a;
        if (r7 == null) goto L50;
    L53:
        if (r7 != null) goto L55;
    L60:
        r7 = null;
    L61:
        Pair[] r11 = new Pair[12];
        r11[0] = TuplesKt.to("data_type", UploadDataType.IMAGE.getType());
        r11[1] = TuplesKt.to("transform", "compress");
        if (r17 == null) goto L64;
        String r9 = r17.getValue();
    L65:
        r11[2] = TuplesKt.to("result_code", r9);
        if (r7 == null) goto L68;
        String r13 = r7.toString();
    L69:
        r11[3] = TuplesKt.to("opt_short_size", r13);
        if (r16 == null) goto L74;
        Integer r14 = r16.b;
        if (r14 == null) goto L74;
        String r15 = r14.toString();
    L75:
        r11[4] = TuplesKt.to("opt_long_size", r15);
        if (r19 == null) goto L83;
        Boolean r20 = Boolean.valueOf(r19.g);
        if (r20.booleanValue() == true) goto L81;
        r20 = null;
    L81:
        if (r20 == null) goto L83;
        String r21 = r20.toString();
    L84:
        r11[5] = TuplesKt.to("skip_downscale", r21);
        r11[6] = TuplesKt.to("quality", String.valueOf(r5));
        if (r16 == null) goto L87;
        Bitmap.CompressFormat r22 = r16.d;
    L88:
        String r23 = String.valueOf(r22);
        if ((!StringsKt.isBlank(r23)) == true) goto L92;
        r23 = null;
    L92:
        if (r23 == null) goto L94;
        String r24 = r23.toLowerCase(Locale.ROOT);
    L95:
        if (r24 != null) goto L97;
        r24 = "jpeg";
    L97:
        r11[7] = TuplesKt.to("output_format", r24);
        if (r16 == null) goto L100;
        boolean r25 = r16.e;
    L101:
        r11[8] = TuplesKt.to("keep_exif", String.valueOf(r25));
        if (r16 == null) goto L106;
        Integer r26 = r16.f;
        if (r26 == null) goto L106;
        String r27 = r26.toString();
    L107:
        r11[9] = TuplesKt.to("quality_with_alpha", r27);
        if (r16 == null) goto L110;
        Bitmap.CompressFormat r28 = r16.g;
    L111:
        String r29 = String.valueOf(r28);
        if ((!StringsKt.isBlank(r29)) == true) goto L115;
        r29 = null;
    L115:
        if (r29 == null) goto L117;
        String r30 = r29.toLowerCase(Locale.ROOT);
    L118:
        if (r30 == null) goto L121;
        r6 = r30;
    L121:
        r11[10] = TuplesKt.to("format_with_alpha", r6);
        if (r16 == null) goto L124;
        int r31 = r16.h;
    L125:
        r11[11] = TuplesKt.to("min_size_to_compress", String.valueOf(r31));
        LinkedHashMap r32 = MapsKt.linkedMapOf(r11);
        LinkedHashMap r33 = new LinkedHashMap();
        Iterator r34 = r32.entrySet().iterator();
    L127:
        if (r34.hasNext() == false) goto L134;
        Map.Entry r35 = (Map.Entry) r34.next();
        if (((String) r35.getValue()) == null) goto L131;
        boolean r110 = true;
    L132:
        if (r110 == false) goto L127;
        r33.put(r35.getKey(), r35.getValue());
        goto L127
    L131:
        r110 = false;
        goto L132
    L134:
        r0 = r33;
        goto L136
    L124:
        r31 = 0;
        goto L125
    L117:
        r30 = null;
        goto L118
    L110:
        r28 = null;
    L106:
        r27 = null;
        goto L107
    L100:
        r25 = false;
        goto L101
    L94:
        r24 = null;
        goto L95
    L87:
        r22 = null;
    L83:
        r21 = null;
    L74:
        r15 = null;
        goto L75
    L68:
        r13 = null;
        goto L69
    L64:
        r9 = null;
        goto L65
    L55:
        if (r7.intValue() <= 0) goto L57;
        boolean r111 = true;
    L58:
        if (r111 == false) goto L60;
    L57:
        r111 = false;
    L50:
        if (r10 == null) goto L52;
        r7 = Integer.valueOf(r10.a);
        goto L53
    L52:
        r7 = null;
    L34:
        if (r10 == null) goto L43;
        r12 = Integer.valueOf(r10.b);
        int r36 = r12.intValue();
        if (1 <= r36) goto L38;
    L40:
        boolean r37 = false;
    L41:
        if (r37 == false) goto L43;
    L44:
        if (r12 != null) goto L45;
        r5 = 100;
        goto L47
    L38:
        if (r36 >= 101) goto L40;
        r37 = true;
    L43:
        r12 = null;
    L29:
        r10 = null;
        goto L30
    L14:
        r3 = "gif_first_frame";
        goto L17
    L15:
        r3 = "compress";
        goto L17
    L5:
        r2 = a.a[r17.ordinal()];
        goto L7
    }
}
