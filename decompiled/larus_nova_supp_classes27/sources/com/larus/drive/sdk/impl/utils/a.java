package com.larus.drive.sdk.impl.utils;

import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final Integer a(DriveFileItem r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        String r4 = r3.l;     // Catch: Throwable -> L7
        if (r4 != null) goto L5;
        r4 = "{}";
    L5:
        Object r5 = Result.constructor-impl(new JSONObject(r4));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r5) == false) goto L12;
        r5 = null;
    L12:
        JSONObject r6 = (JSONObject) r5;
        if (r6 != null) goto L15;
        return null;
    L15:
        if (r6.has("originBaseBizType") == false) goto L28;
        Object r7 = r6.opt("originBaseBizType");
        if (r7 == null) goto L26;
        String r8 = r7.toString();
        if (r8 != null) goto L22;
        return null;
    L22:
        return StringsKt.toIntOrNull(r8);
    L26:
        return null;
    L28:
        return null;
    L7:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static final Integer b(DriveFileItem r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.d != 8) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == true) goto L12;
        return null;
    L12:
        Integer r1 = a(r3);
        if (r1 != null) goto L18;
        int r2 = bq9.b.a;
        if (bq9.b.b(r3.e) == true) goto L20;
        return null;
    L20:
        return 1;
    L18:
        return r1;
    L5:
        if (r3.j == DriveFileType.BITABLE) goto L8;
        r0 = false;
        goto L10
    }
}
