package is9;

import aq8.g;
import aq8.h;
import aq8.i;
import com.google.gson.Gson;
import com.larus.bmhome.music.protocol.e;
import com.larus.im.bean.message.ImageObj;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.Image;
import com.larus.platform.api.creation.AiBeautifyUserContent;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.OptionItem;
import com.larus.platform.api.creation.TplDetail;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.api.creation.UserCreationMusic;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import com.larus.platform.api.creation.VideoUserContent;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import xt7.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final ImageObj a(Image r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        return new ImageObj(r9.a, (int) r9.c, (int) r9.d, null, null, 24, null);
    }

    public static final String b(UserCreation r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        int r0 = r9.b;
        Object r2 = null;
        Object r3 = null;
        Object r4 = null;
        String r5 = null;
        r5 = null;
        r5 = null;
        r5 = null;
        Object r6 = null;
        String r7 = null;
        r7 = null;
        r7 = null;
        r7 = null;
        if (r0 != 2) goto L5;
    L167:
        UserCreationContent r1 = r9.e;
        if (r1 == null) goto L176;
        UserCreationImage r8 = r1.a;
        if (r8 == null) goto L176;
        OptionItem r10 = r8.e;
        if (r10 == null) goto L176;
        Long r11 = r10.a;
        if (r11 == null) goto L176;
        String r12 = r11.toString();
    L177:
        UserCreationContent r13 = r9.e;
        if (r13 == null) goto L186;
        UserCreationImage r14 = r13.a;
        if (r14 == null) goto L186;
        OptionItem r15 = r14.d;
        if (r15 == null) goto L186;
        Long r16 = r15.a;
        if (r16 == null) goto L186;
        String r17 = r16.toString();
    L187:
        UserCreationContent r18 = r9.e;
        if (r18 == null) goto L196;
        UserCreationImage r19 = r18.a;
        if (r19 == null) goto L196;
        OptionItem r20 = r19.f;
        if (r20 == null) goto L196;
        Long r21 = r20.a;
        if (r21 == null) goto L196;
        String r22 = r21.toString();
    L197:
        g r23 = new g(r12, r17, null, r22, 4);
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L200
        Object r25 = Result.constructor-impl(d.b.a(g.Companion.serializer(), r23));     // Catch: Throwable -> L200
    L203:
        if (Result.isFailure-impl(r25) == true) goto L206;
        r2 = r25;
    L206:
        r7 = (String) r2;
        if (r7 != null) goto L209;
    L208:
        r7 = "";
    L209:
        FLogger.a.i("toInstructionDefaultParams", "defaultParams:" + r7);
        return r7;
    L200:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
    L196:
        r22 = null;
    L186:
        r17 = null;
    L176:
        r12 = null;
        goto L177
    L5:
        if (r0 == 5) goto L167;
        if (CollectionsKt.listOf(new Integer[]{6, 7, 9, 8, 10, 11, 12}).contains(Integer.valueOf(r9.b)) == false) goto L42;
        UserCreationContent r27 = r9.e;
        if (r27 == null) goto L18;
        VideoUserContent r28 = r27.e;
        if (r28 == null) goto L18;
        OptionItem r29 = r28.e;
        if (r29 == null) goto L18;
        Long r30 = r29.a;
        if (r30 == null) goto L18;
        String r31 = r30.toString();
    L19:
        UserCreationContent r32 = r9.e;
        if (r32 == null) goto L28;
        VideoUserContent r33 = r32.e;
        if (r33 == null) goto L28;
        OptionItem r34 = r33.g;
        if (r34 == null) goto L28;
        Long r35 = r34.a;
        if (r35 == null) goto L28;
        String r36 = r35.toString();
    L29:
        i r37 = new i(r31, r36);
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L32
        Object r39 = Result.constructor-impl(d.b.a(i.Companion.serializer(), r37));     // Catch: Throwable -> L32
    L35:
        if (Result.isFailure-impl(r39) == true) goto L38;
        r3 = r39;
    L38:
        r7 = (String) r3;
        if (r7 != null) goto L209;
    L32:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r39 = Result.constructor-impl(ResultKt.createFailure(th));
    L28:
        r36 = null;
    L18:
        r31 = null;
        goto L19
    L42:
        if (r9.b != 1) goto L98;
        UserCreationContent r41 = r9.e;
        if (r41 == null) goto L48;
        UserCreationMusic r42 = r41.b;
        if (r42 == null) goto L48;
        String r43 = r42.j;
    L50:
        if (o0.d(r43) == false) goto L98;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L59
        Gson r45 = HttpExtKt.f;     // Catch: Throwable -> L59
        UserCreationContent r46 = r9.e;     // Catch: Throwable -> L59
        if (r46 == null) goto L56;
        UserCreationMusic r47 = r46.b;     // Catch: Throwable -> L59
        if (r47 == null) goto L56;
        String r48 = r47.j;     // Catch: Throwable -> L59
    L57:
        Object r49 = Result.constructor-impl((e) r45.fromJson(r48, e.class));     // Catch: Throwable -> L59
    L62:
        if (Result.isFailure-impl(r49) == false) goto L64;
        r49 = null;
    L64:
        e r50 = (e) r49;
        if (r50 == null) goto L71;
        bq8.d r51 = r50.c();
        if (r51 == null) goto L71;
        bq8.e r52 = r51.a;
        if (r52 == null) goto L71;
        String r53 = Long.valueOf(r52.a).toString();
    L72:
        if (r50 == null) goto L78;
        bq8.d r54 = r50.c();
        if (r54 == null) goto L78;
        bq8.e r55 = r54.b;
        if (r55 == null) goto L78;
        String r56 = Long.valueOf(r55.a).toString();
    L79:
        if (r50 == null) goto L85;
        bq8.d r57 = r50.c();
        if (r57 == null) goto L85;
        bq8.e r58 = r57.c;
        if (r58 == null) goto L85;
        String r59 = Long.valueOf(r58.a).toString();
    L213:
        Object r60 = Result.constructor-impl(d.b.a(h.Companion.serializer(), new h(r53, r56, r59)));     // Catch: Throwable -> L89
    L92:
        if (Result.isFailure-impl(r60) == true) goto L95;
        r4 = r60;
    L95:
        r7 = (String) r4;
        if (r7 != null) goto L209;
    L89:
        th = move-exception;
        Result.Companion r61 = Result.Companion;
        r60 = Result.constructor-impl(ResultKt.createFailure(th));
    L85:
        r59 = null;
    L78:
        r56 = null;
    L71:
        r53 = null;
    L56:
        r48 = null;
    L59:
        th = move-exception;
        Result.Companion r62 = Result.Companion;
        r49 = Result.constructor-impl(ResultKt.createFailure(th));
    L48:
        r43 = null;
    L98:
        int r63 = r9.b;
        if (r63 != 10) goto L120;
        UserCreationContent r64 = r9.e;
        if (r64 == null) goto L109;
        VideoUserContent r65 = r64.e;
        if (r65 == null) goto L109;
        OptionItem r66 = r65.e;
        if (r66 == null) goto L109;
        Long r67 = r66.a;
        if (r67 == null) goto L109;
        String r68 = r67.toString();
    L110:
        UserCreationContent r69 = r9.e;
        if (r69 == null) goto L119;
        VideoUserContent r70 = r69.e;
        if (r70 == null) goto L119;
        OptionItem r71 = r70.g;
        if (r71 == null) goto L119;
        Long r72 = r71.a;
        if (r72 == null) goto L119;
        r5 = r72.toString();
    L119:
        r7 = HttpExtKt.p(new i(r68, r5));
    L109:
        r68 = null;
        goto L110
    L120:
        if (r63 != 3) goto L153;
        UserCreationContent r73 = r9.e;
        if (r73 == null) goto L130;
        UserCreationUserAvatar r74 = r73.c;
        if (r74 == null) goto L130;
        OptionItem r75 = r74.d;
        if (r75 == null) goto L130;
        Long r76 = r75.a;
        if (r76 == null) goto L130;
        String r77 = r76.toString();
    L131:
        UserCreationContent r78 = r9.e;
        if (r78 == null) goto L140;
        UserCreationUserAvatar r79 = r78.c;
        if (r79 == null) goto L140;
        OptionItem r80 = r79.e;
        if (r80 == null) goto L140;
        Long r81 = r80.a;
        if (r81 == null) goto L140;
        String r82 = r81.toString();
    L141:
        g r83 = new g(null, r77, null, r82, 5);
        Result.Companion r84 = Result.Companion;     // Catch: Throwable -> L144
        Object r85 = Result.constructor-impl(d.b.a(g.Companion.serializer(), r83));     // Catch: Throwable -> L144
    L147:
        if (Result.isFailure-impl(r85) == true) goto L150;
        r6 = r85;
    L150:
        r7 = (String) r6;
        if (r7 != null) goto L209;
    L144:
        th = move-exception;
        Result.Companion r86 = Result.Companion;
        r85 = Result.constructor-impl(ResultKt.createFailure(th));
    L140:
        r82 = null;
    L130:
        r77 = null;
        goto L131
    L153:
        if (r63 != 4) goto L209;
        UserCreationContent r87 = r9.e;
        if (r87 == null) goto L159;
        AiBeautifyUserContent r88 = r87.d;
        if (r88 == null) goto L159;
        String r89 = r88.b;
    L161:
        if (o0.d(r89) == false) goto L209;
        UserCreationContent r90 = r9.e;
        if (r90 == null) goto L209;
        AiBeautifyUserContent r91 = r90.d;
        if (r91 == null) goto L209;
        r7 = r91.b;
    L159:
        r89 = null;
        goto L161
    }

    public static final TplDetail c(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (IUgcAIGCService.a.v() == false) goto L9;
        CreationDynamicInfo r3 = r2.h;
        if (r3 == null) goto L15;
        TplInfo r4 = r3.e;
        if (r4 != null) goto L17;
        return null;
    L17:
        return r4.c;
    L15:
        return null;
    L9:
        CreationDynamicInfo r5 = r2.h;
        if (r5 == null) goto L18;
        TplInfo r6 = r5.e;
        if (r6 != null) goto L14;
        return null;
    L14:
        return r6.b;
    L18:
        return null;
    }
}
