package com.larus.account.base.impl;

import com.google.gson.Gson;
import com.larus.account.base.multi.d;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import ua7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class MultiAccountServiceImpl$d extends a<xa7.c> {
    public final /* synthetic */ MultiAccountServiceImpl a;
    public final /* synthetic */ Function4<Boolean, String, Integer, String, Unit> b;

    /* JADX WARN: Type inference failed for: r4v1, types: [com.larus.account.base.impl.a0, kotlin.jvm.functions.Function0] */
    public final void onResponse(ua7.b r27) {
        xa7.c r0 = (xa7.c) r27;
        if (r0 != null) goto L5;
    L7:
        final boolean r8 = false;
    L8:
        if (r0 == null) goto L10;
        final int r10 = ((ua7.b) r0).g;
    L11:
        if (r0 == null) goto L13;
        final String r11 = ((ua7.b) r0).i;
    L14:
        if (r0 == null) goto L18;
        JSONObject r1 = ((ua7.b) r0).m;
        if (r1 == null) goto L18;
        final String r9 = r1.toString();
    L19:
        if (r8 == true) goto L21;
        FLogger.a.e("MultiAccountServiceImpl", "fetchServerAccountList fail, code=" + r10 + ", msg=" + r11);
        MultiAccountServiceImpl r2 = this.a;
        final Function4<Boolean, String, Integer, String, Unit> r6 = this.b;
        final boolean r7 = r8;
        final String r12 = r9;
        final int r13 = r10;
        final String r14 = r11;
        Function0 r3 = new z(r6, r7, r12, r13, r14);
        int r4 = MultiAccountServiceImpl.f;
        r2.getClass();
        com.larus.utils.y.c(new y(r3));
        return;
    L21:
        MultiAccountServiceImpl r5 = this.a;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L24
        Object r16 = Result.constructor-impl((com.larus.account.base.multi.m) r5.b.fromJson(r9, com.larus.account.base.multi.m.class));     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r16) == false) goto L29;
        r16 = null;
    L29:
        com.larus.account.base.multi.m r17 = (com.larus.account.base.multi.m) r16;
        if (r17 == null) goto L36;
        com.larus.account.base.multi.l r19 = r17.a();
        if (r19 == null) goto L36;
        List<com.larus.account.base.multi.n> r20 = r19.a();
        if (r20 == null) goto L36;
        List r21 = CollectionsKt.filterNotNull(r20);
    L37:
        Gson r22 = d.a;
        List r23 = r21;
        if (r23 != null) goto L40;
    L43:
        boolean r24 = true;
    L44:
        if (r24 == true) goto L107;
        Object r25 = d.c;
        monitor-enter(r25);
        List r26 = d.d;     // Catch: Throwable -> L129
        ArrayList r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));     // Catch: Throwable -> L129
        Iterator r30 = r26.iterator();     // Catch: Throwable -> L129
        int r110 = 0;
    L50:
        if (r30.hasNext() == false) goto L102;
        q38.b r111 = (q38.b) r30.next();     // Catch: Throwable -> L129
        Iterator r112 = r21.iterator();     // Catch: Throwable -> L129
    L53:
        if (r112.hasNext() == false) goto L57;
        Object r113 = r112.next();     // Catch: Throwable -> L129
        if (Intrinsics.areEqual(((com.larus.account.base.multi.n) r113).e(), r111.g()) == false) goto L53;
    L58:
        com.larus.account.base.multi.n r114 = (com.larus.account.base.multi.n) r113;     // Catch: Throwable -> L129
        if (r114 == null) goto L101;
        Integer r31 = r114.d();     // Catch: Throwable -> L129
        if (r31 == null) goto L64;
        int r32 = r31.intValue();     // Catch: Throwable -> L129
    L65:
        if (r32 <= 0) goto L67;
        boolean r115 = true;
    L68:
        com.larus.account.base.multi.f r33 = r114.b();     // Catch: Throwable -> L129
        if (r33 == null) goto L82;
        String r34 = r33.a();     // Catch: Throwable -> L129
        if (r34 == null) goto L82;
        if ((!StringsKt.isBlank(r34)) == true) goto L76;
        r34 = null;
    L76:
        if (r34 == null) goto L82;
        q38.b.a r116 = r111.i();     // Catch: Throwable -> L129
        if (r116 == null) goto L80;
        String r117 = r116.a();     // Catch: Throwable -> L129
    L81:
        q38.b.a r35 = new q38.b.a(r117, r34);     // Catch: Throwable -> L129
    L83:
        String r36 = r114.c();     // Catch: Throwable -> L129
        if (r36 != null) goto L86;
    L90:
        r36 = r111.c();     // Catch: Throwable -> L129
    L91:
        String r118 = r114.a();     // Catch: Throwable -> L129
        if (r118 != null) goto L94;
        r118 = r111.b();     // Catch: Throwable -> L129
    L94:
        String r119 = r118;
        if (r35 != null) goto L97;
        r35 = r111.i();     // Catch: Throwable -> L129
    L97:
        q38.b r37 = q38.b.a(r111, r36, r119, r35, r115, 0, false, null, null, false, 1987);     // Catch: Throwable -> L129
        if (Intrinsics.areEqual(r37, r111) == true) goto L100;
        r110 = r110 + 1;     // Catch: Throwable -> L129
    L100:
        r111 = r37;
        goto L101
    L86:
        if ((!StringsKt.isBlank(r36)) == true) goto L89;
        r36 = null;
    L89:
        if (r36 != null) goto L91;
    L80:
        r117 = null;
    L82:
        r35 = null;
        goto L83
    L67:
        r115 = false;
        goto L68
    L64:
        r32 = 0;
    L101:
        r29.add(r111);     // Catch: Throwable -> L129
        goto L50
    L57:
        r113 = null;
        goto L58
    L102:
        d.d = CollectionsKt.toMutableList(r29);     // Catch: Throwable -> L129
        if (r110 <= 0) goto L105;
        d.d();     // Catch: Throwable -> L129
    L105:
        Unit r38 = Unit.INSTANCE;     // Catch: Throwable -> L129
        monitor-exit(r25);
    L129:
        th = move-exception;
        throw th;
    L107:
        final MultiAccountServiceImpl r39 = this.a;
        final Function4<Boolean, String, Integer, String, Unit> r40 = this.b;
        ?? r41 = new a0(r39, r40, r8, r9, r10, r11);
        int r42 = MultiAccountServiceImpl.f;
        r39.getClass();
        if (r21 == null) goto L121;
        ArrayList r43 = new ArrayList();
        Iterator r44 = r21.iterator();
    L111:
        if (r44.hasNext() == false) goto L120;
        String r45 = ((com.larus.account.base.multi.n) r44.next()).e();
        if (r45 != null) goto L115;
    L117:
        r45 = null;
    L118:
        if (r45 == null) goto L111;
        r43.add(r45);
        goto L111
    L115:
        if ((!StringsKt.isBlank(r45)) == false) goto L117;
    L120:
        List r46 = CollectionsKt.distinct(r43);
    L122:
        if (r46 != null) goto L125;
        r46 = CollectionsKt.emptyList();
    L125:
        if (r46.isEmpty() == false) goto L127;
        r41.invoke();
        return;
    L127:
        BuildersKt.launch$default(r39.d, null, null, new MultiAccountServiceImpl$refreshMembershipInfoFromProfileMulti$1(r41, r46, null), 3, null);
        return;
    L121:
        r46 = null;
        goto L122
    L40:
        if (r23.isEmpty() == true) goto L43;
        r24 = false;
    L36:
        r21 = null;
    L24:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L18:
        r9 = null;
        goto L19
    L13:
        r11 = null;
        goto L14
    L10:
        r10 = -1;
        goto L11
    L5:
        if (((ua7.b) r0).c != true) goto L7;
        r8 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MultiAccountServiceImpl$d(MultiAccountServiceImpl r1, Function4<? super Boolean, ? super String, ? super Integer, ? super String, Unit> r2) {
        this.a = r1;
        this.b = r2;
    }
}
