package com.larus.uaigc.helper;

import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.platform.model.upload.UploadDataType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ProcessFileResultCode.values().length];
            r0[ProcessFileResultCode.PREPARE_COMPRESSED_SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[ProcessFileResultCode.PREPARE_GIF_PROCESS_SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[ProcessFileResultCode.PREPARE_ORIGINAL_RES_CLONE_SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[ProcessFileResultCode.PREPARE_CLONE_SUCCESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[ProcessFileResultCode.SUCCESS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
    }

    public static Map a(ProcessFileResultCode r5) {
        Pair[] r0 = new Pair[3];
        r0[0] = TuplesKt.to("data_type", UploadDataType.IMAGE.getType());
        r0[1] = TuplesKt.to("transform", "identity");
        if (r5 == null) goto L5;
        String r6 = r5.getValue();
    L6:
        r0[2] = TuplesKt.to("result_code", r6);
        LinkedHashMap r7 = MapsKt.linkedMapOf(r0);
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r8 = r7.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L15;
        Map.Entry r2 = (Map.Entry) r8.next();
        if (((String) r2.getValue()) == null) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L8;
        r1.put(r2.getKey(), r2.getValue());
        goto L8
    L12:
        r4 = false;
        goto L13
    L15:
        return r1;
    L5:
        r6 = null;
        goto L6
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
}
