package com.ss.android.lark.contact.customized.department;

import com.alibaba.fastjson.JSON;
import com.bytedance.lark.pb.contact.v2.GetUserProfileResponse;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class DepartmentUserDisplayFormatter$formatProfileFields$1 extends FunctionReferenceImpl implements Function1<GetUserProfileResponse.Field, String> {
    public DepartmentUserDisplayFormatter$formatProfileFields$1(Object r8) {
        super(1, r8, DepartmentUserDisplayFormatter.class, "formatProfileField", "formatProfileField(Lcom/bytedance/lark/pb/contact/v2/GetUserProfileResponse$Field;)Ljava/lang/String;", 0);
    }

    public final String invoke(GetUserProfileResponse.Field r4) {
        Intrinsics.checkNotNullParameter(r4, "p0");
        DepartmentUserDisplayFormatter r0 = (DepartmentUserDisplayFormatter) ((CallableReference) this).receiver;
        DepartmentUserDisplayFormatter r1 = DepartmentUserDisplayFormatter.a;
        r0.getClass();
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L19
        GetUserProfileResponse.Field.FieldType r5 = r4.field_type;     // Catch: Throwable -> L19
        if (r5 != null) goto L6;
        int r6 = -1;
    L8:
        if (r6 != 1) goto L10;
    L15:
        DepartmentUserDisplayFormatter.b r7 = (DepartmentUserDisplayFormatter.b) JSON.parseObject(r4.json_field_val, DepartmentUserDisplayFormatter.b.class);     // Catch: Throwable -> L19
        DepartmentUserDisplayFormatter.c();     // Catch: Throwable -> L19
    L16:
        String r8 = BuildConfig.FLAVOR;
    L17:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r9) == true) goto L26;
        r2 = r9;
    L26:
        return (String) r2;
    L10:
        if (r6 == 2) goto L15;
        if (r6 == 3) goto L14;
        r8 = null;
        goto L17
    L14:
        DepartmentUserDisplayFormatter.a r10 = (DepartmentUserDisplayFormatter.a) JSON.parseObject(r4.json_field_val, DepartmentUserDisplayFormatter.a.class);     // Catch: Throwable -> L19
        DepartmentUserDisplayFormatter.c();     // Catch: Throwable -> L19
        goto L16
    L6:
        r6 = DepartmentUserDisplayFormatter.c.b[r5.ordinal()];     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((GetUserProfileResponse.Field) r1);
    }
}
