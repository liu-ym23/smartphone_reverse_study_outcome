package com.obric.aikernel.request;

import android.os.Bundle;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class RequestParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f4837a;

    public RequestParser(a r10) {
        Intrinsics.checkNotNullParameter(r10, "decor");
        this.f4837a = r10;
    }

    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.os.Bundle, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:121:0x032e -> B:122:0x0333). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0141 -> B:36:0x0146). Please report as a decompilation issue!!! */
    public final Object a(RequestParams r19, com.obric.aikernel.b r20, Continuation<? super Boolean> r21) {
        RequestParser r10 = this;
        RequestParams r11 = r19;
        com.obric.aikernel.b r12 = r20;
        if ((r21 instanceof RequestParser$handelRequest$1) == false) goto L7;
        RequestParser$handelRequest$1 r13 = (RequestParser$handelRequest$1) r21;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r17 = 0;
        switch(r13.label) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L15;
            case 8: goto L15;
            case 9: goto L13;
            case 10: goto L12;
            default: goto L11;
        };
    L12:
        com.obric.aikernel.b r18 = (com.obric.aikernel.b) r13.L$0;
        ResultKt.throwOnFailure(r15);
    L81:
        b r22 = (b) r15;
        e8.a.r(r18, r22.g());
    L59:
        boolean r23 = r22.f();
    L152:
        return Boxing.boxBoolean(r23);
    L13:
        RequestParams r24 = (RequestParams) r13.L$0;
        ResultKt.throwOnFailure(r15);
    L67:
        r22 = (b) r15;
        CallerActionLogger.f4835a.c(r24, r22.g());
        goto L59
    L14:
        RequestParams r25 = (RequestParams) r13.L$0;
        ResultKt.throwOnFailure(r15);
    L143:
        r23 = ((b) r15).f();
        CallerActionLogger.f4835a.f(r25);
        goto L152
    L15:
        ResultKt.throwOnFailure(r15);
    L58:
        r22 = (b) r15;
        goto L59
    L16:
        int r26 = r13.I$3;
        int r27 = r13.I$2;
        int r28 = r13.I$1;
        final int r29 = r13.I$0;
        String[] r30 = (String[]) r13.L$2;
        com.obric.aikernel.b r110 = (com.obric.aikernel.b) r13.L$1;
        RequestParser r111 = (RequestParser) r13.L$0;
        ResultKt.throwOnFailure(r15);
        int r31 = r26;
        r10 = r111;
        final int r112 = r28;
        r12 = r110;
    L122:
        String[] r113 = r30;
        int r32 = r27 + 1;
        String[] r33 = r113;
    L117:
        if (r32 < r31) goto L118;
    L37:
        e8.a.r(r12, b.f4839c.e());
        r23 = true;
        goto L152
    L118:
        String r34 = r33[r32];
        a r114 = r10.f4837a;
        Intrinsics.checkNotNullExpressionValue(r34, ActivityLifecycle.NAME);
        RequestParams r115 = new RequestParams(null, new RequestParser$handelRequest$4$1(r29, r112), 1, null);
        com.obric.aikernel.b.a r116 = b.f4839c.c();
        r13.L$0 = r10;
        r13.L$1 = r12;
        r13.L$2 = r33;
        r13.I$0 = r29;
        r13.I$1 = r112;
        r13.I$2 = r32;
        r13.I$3 = r31;
        r13.label = 4;
        if (r114.d(r34, r115, r116, r13) != r16) goto L121;
        return r16;
    L121:
        int r117 = r32;
        r30 = r33;
        r27 = r117;
        goto L122
    L17:
        int r35 = r13.I$3;
        int r36 = r13.I$2;
        int r37 = r13.I$1;
        final int r38 = r13.I$0;
        String[] r39 = (String[]) r13.L$2;
        com.obric.aikernel.b r118 = (com.obric.aikernel.b) r13.L$1;
        RequestParser r119 = (RequestParser) r13.L$0;
        ResultKt.throwOnFailure(r15);
        int r40 = r35;
        r10 = r119;
        r112 = r37;
        r12 = r118;
    L36:
        r17 = 0;
        String[] r120 = r39;
        int r41 = r36 + 1;
        String[] r42 = r120;
    L31:
        if (r41 >= r40) goto L37;
        String r121 = r42[r41];
        a r122 = r10.f4837a;
        Intrinsics.checkNotNullExpressionValue(r121, ActivityLifecycle.NAME);
        RequestParams r123 = new RequestParams(r17, new RequestParser$handelRequest$3$1(r38, r112), 1, r17);
        com.obric.aikernel.b.a r124 = b.f4839c.c();
        r13.L$0 = r10;
        r13.L$1 = r12;
        r13.L$2 = r42;
        r13.I$0 = r38;
        r13.I$1 = r112;
        r13.I$2 = r41;
        r13.I$3 = r40;
        r13.label = 3;
        if (r122.h(r121, r123, r124, r13) != r16) goto L35;
        return r16;
    L35:
        int r125 = r41;
        r39 = r42;
        r36 = r125;
        goto L36
    L18:
        String r43 = (String) r13.L$2;
        com.obric.aikernel.b r44 = (com.obric.aikernel.b) r13.L$1;
        RequestParams r45 = (RequestParams) r13.L$0;
        ResultKt.throwOnFailure(r15);
    L100:
        PackageResource r46 = (PackageResource) r15;
        RequestParams r126 = r45;
        r12 = r44;
        r11 = r126;
    L102:
        Bundle r127 = new Bundle();
        if (r46.isAvailable() == true) goto L105;
        e8.a.B(r127, 109, r46.toString(), false, 4, null);
    L110:
        e8.a.r(r12, r127);
        AIKLog.INSTANCE.d("InferEntry", "compat _DownloadBiz " + r43 + " ret " + r127);
    L54:
        return Boxing.boxBoolean(true);
    L105:
        if (e8.a.k(r11.getBackend()) < 1002007) goto L107;
        JSONObject r47 = new JSONObject();
        r47.put(IdlKeys.Args_BizName, r43);
        r47.put(IdlKeys.Args_TraceId, r11.getTraceIdStr());
        r47.put(IdlKeys.Args_TraceEventKey, "_finish");
        r47.put(IdlKeys.Args_TraceEventArgs, new JSONObject());
        String r48 = r47.toString();
        int r49 = 0;
        String r50 = null;
        int r51 = 6;
        Object r52 = null;
    L108:
        e8.a.w(r127, r48, r49, r50, r51, r52);
        goto L110
    L107:
        r49 = 0;
        r50 = null;
        r51 = 6;
        r52 = null;
        r48 = r43;
        goto L108
    L19:
        String r53 = (String) r13.L$3;
        com.obric.aikernel.b r54 = (com.obric.aikernel.b) r13.L$2;
        RequestParams r55 = (RequestParams) r13.L$1;
        RequestParser r56 = (RequestParser) r13.L$0;
        ResultKt.throwOnFailure(r15);
        String r57 = r53;
        r10 = r56;
        r12 = r54;
        r11 = r55;
    L94:
        r46 = (PackageResource) r15;
        if (r46.isAvailable() == true) goto L101;
        a r58 = r10.f4837a;
        r13.L$0 = r11;
        r13.L$1 = r12;
        r13.L$2 = r57;
        r13.L$3 = null;
        r13.label = 2;
        r15 = r58.b(r57, r11, r13);
        if (r15 != r16) goto L99;
        return r16;
    L99:
        r43 = r57;
        com.obric.aikernel.b r128 = r12;
        r45 = r11;
        r44 = r128;
        goto L100
    L101:
        r43 = r57;
        goto L102
    L20:
        ResultKt.throwOnFailure(r15);
        String r59 = e8.a.h(r19.getBackend());
        r57 = e8.a.e(r19.getBackend());
        int r129 = r19.getBackend().getInt(RequestParams.Args_Pid);
        r112 = r19.getBackend().getInt(RequestParams.Args_Uid);
        if (r59 != null) goto L23;
    L150:
        AIKLog.INSTANCE.w("RequestParser", "not impl method " + r59);
        r23 = false;
        goto L152
    L23:
        switch(r59.hashCode()) {
            case -1731485522: goto L145;
            case -1509238193: goto L124;
            case -1297660426: goto L112;
            case -165341812: goto L83;
            case 10602578: goto L75;
            case 64536999: goto L69;
            case 872489927: goto L61;
            case 1224534155: goto L39;
            case 2105464316: goto L26;
            default: goto L150;
        };
    L26:
        if (r59.equals(IdlKeys.Method_PreLoadPackage) == false) goto L150;
        r42 = r19.getBackend().getStringArray(IdlKeys.Args_PACKAGE_ARR);
        if (r42 == null) goto L37;
        r40 = r42.length;
        r38 = r129;
        r41 = 0;
        goto L31
    L39:
        if (r59.equals(IdlKeys.Method_GetPackageRes) == false) goto L150;
        String[] r60 = r19.getBackend().getStringArray(IdlKeys.Args_Pkgs);
        if (r60 != null) goto L44;
    L50:
        boolean r61 = true;
    L51:
        if (r61 == false) goto L55;
    L52:
        e8.a.c(r12, 101, "IllegalArgument package names.");
        goto L54
    L55:
        a r62 = r10.f4837a;
        List<String> r63 = ArraysKt.toList(r60);
        r13.label = 5;
        r15 = r62.c(r63, r11, r12, r13);
        if (r15 != r16) goto L58;
        return r16;
    L44:
        if (r60.length != 0) goto L46;
        boolean r64 = true;
    L47:
        if (r64 == true) goto L50;
        r61 = false;
        goto L51
    L46:
        r64 = false;
        goto L47
    L61:
        if (r59.equals(IdlKeys.Method_RunBiz) == false) goto L150;
        CallerActionLogger.f4835a.e(r11);
        a r65 = r10.f4837a;
        r13.L$0 = r11;
        r13.label = 9;
        r15 = r65.g(r57, r11, r12, r13);
        if (r15 != r16) goto L66;
        return r16;
    L66:
        r24 = r11;
        goto L67
    L69:
        if (r59.equals(IdlKeys.Method_LoadPackage) == false) goto L150;
        a r66 = r10.f4837a;
        r13.label = 7;
        r15 = r66.h(r57, r11, r12, r13);
        if (r15 != r16) goto L58;
        return r16;
    L75:
        if (r59.equals("_GetBizUpdateProgress") == false) goto L150;
        String r67 = e8.a.e(r19.getBackend());
        a r68 = r10.f4837a;
        r13.L$0 = r12;
        r13.label = 10;
        r15 = r68.a(r67, r11, r13);
        if (r15 != r16) goto L80;
        return r16;
    L80:
        r18 = r12;
        goto L81
    L83:
        if (r59.equals(IdlKeys.Method_DownloadBiz) == false) goto L150;
        if (r57.length() != 0) goto L88;
        boolean r69 = true;
    L89:
        if (r69 == true) goto L52;
        a r70 = r10.f4837a;
        r13.L$0 = r10;
        r13.L$1 = r11;
        r13.L$2 = r12;
        r13.L$3 = r57;
        r13.label = 1;
        r15 = r70.e(r57, r11, r13);
        if (r15 != r16) goto L94;
        return r16;
    L88:
        r69 = false;
        goto L89
    L112:
        if (r59.equals(IdlKeys.Method_CancelPreLoadPackage) == false) goto L150;
        r33 = r19.getBackend().getStringArray(IdlKeys.Args_PACKAGE_ARR);
        if (r33 == null) goto L37;
        r31 = r33.length;
        r29 = r129;
        r32 = 0;
        goto L117
    L124:
        if (r59.equals(IdlKeys.Method_UpdatePackages) == false) goto L150;
        List<PackageResource> r71 = e8.a.i(r19.getBackend());
        if (r71 != null) goto L129;
    L132:
        boolean r72 = true;
    L133:
        if (r72 == true) goto L52;
        CallerActionLogger.f4835a.g(r11);
        a r73 = r10.f4837a;
        ArrayList r74 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r71, 10));
        Iterator<T> r75 = r71.iterator();
    L137:
        if (r75.hasNext() == false) goto L139;
        r74.add(((PackageResource) r75.next()).getName());
        goto L137
    L139:
        r13.L$0 = r11;
        r13.label = 6;
        r15 = r73.f(r74, r11, r12, r13);
        if (r15 != r16) goto L142;
        return r16;
    L142:
        r25 = r11;
        goto L143
    L129:
        if (r71.isEmpty() == true) goto L132;
        r72 = false;
        goto L133
    L145:
        if (r59.equals(IdlKeys.Method_UnloadPackage) == false) goto L150;
        a r76 = r10.f4837a;
        r13.label = 8;
        r15 = r76.d(r57, r11, r12, r13);
        if (r15 != r16) goto L58;
        return r16;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r13 = new RequestParser$handelRequest$1(r10, r21);
        goto L8
    }
}
