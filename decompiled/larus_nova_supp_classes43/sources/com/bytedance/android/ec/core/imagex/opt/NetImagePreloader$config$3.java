package com.bytedance.android.ec.core.imagex.opt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lyl/c;", "p1", "", "invoke", "(Lyl/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class NetImagePreloader$config$3 extends AdaptedFunctionReference implements Function2<yl.c, Continuation<? super Unit>, Object>, SuspendFunction {
    public NetImagePreloader$config$3(NetImagePreloader r10) {
        super(2, r10, NetImagePreloader.class, "onConfigInit", "onConfigInit(Lcom/bytedance/android/ec/opt/config/NetImagePreloadConfig;)V", 4);
    }

    public final Object invoke(yl.c r29, Continuation<? super Unit> r30) {
        NetImagePreloader r1 = (NetImagePreloader) ((AdaptedFunctionReference) this).receiver;
        KProperty[] r10 = NetImagePreloader.b;
        r1.getClass();
        HashMap r11 = new HashMap();
        HashMap r12 = r29.a();
        if (r12 == null) goto L158;
        Iterator r13 = r12.entrySet().iterator();
    L7:
        if (r13.hasNext() == false) goto L156;
        Map.Entry r14 = (Map.Entry) r13.next();
        String r15 = (String) r14.getKey();
        yl.d r16 = (yl.d) r14.getValue();
        List r17 = r16.b();
        if (r17 != null) goto L11;
        Iterator r23 = r13;
    L155:
        r13 = r23;
        goto L7
    L11:
        ArrayList r18 = new ArrayList();
        Iterator r19 = r17.iterator();
    L12:
        int r20 = 1;
        int r21 = 0;
        if (r19.hasNext() == false) goto L143;
        yl.f r22 = (yl.f) r19.next();
        String r110 = r22.b();
        if (r110 != null) goto L17;
        HashMap r26 = r11;
        Iterator r24 = r13;
        String r27 = r15;
        Iterator r25 = r19;
    L142:
        r13 = r24;
        r19 = r25;
        r11 = r26;
        r15 = r27;
        goto L12
    L17:
        Iterator r111 = StringsKt.split$default(r110, new String[]{"/"}, false, 0, 6, null).iterator();
        EditableNode r112 = null;
    L19:
        if (r111.hasNext() == false) goto L133;
        List r113 = StringsKt.split$default((String) r111.next(), new String[]{":"}, false, 0, 6, null);
        String r114 = (String) CollectionsKt.getOrNull(r113, r21);
        if (r114 == null) goto L22;
        String r28 = (String) CollectionsKt.getOrNull(r113, r20);
        String r115 = (String) CollectionsKt.getOrNull(r113, 2);
        NetImagePreloader.h.getClass();
        p0[] r31 = (p0[]) NetImagePreloader.c.getValue();
        int r116 = r31.length;
        int r0 = 0;
    L24:
        if (r0 >= r116) goto L35;
        r24 = r13;
        p0 r32 = r31[r0];
        if (r28 == null) goto L30;
        r25 = r19;
        p0[] r117 = r31;
        Iterator r210 = r111;
        int r118 = r116;
        if (StringsKt.startsWith$default(r28, r32.a, false, 2, null) == false) goto L31;
        boolean r33 = true;
    L32:
        if (r33 == true) goto L36;
        r0 = r0 + 1;
        r31 = r117;
        r116 = r118;
        r13 = r24;
        r19 = r25;
        r111 = r210;
    L36:
        if (r32 != null) goto L38;
        r32 = p0.d.b;
    L38:
        ArrayList r34 = new ArrayList();
        if (r28 == null) goto L41;
        String r35 = StringsKt.replaceFirst$default(r28, r32.a, "", false, 4, null);
    L42:
        if (r35 != null) goto L44;
    L47:
        boolean r36 = true;
    L48:
        if (r36 == true) goto L111;
        int r37 = 0;
    L50:
        int r38 = StringsKt.indexOf$default(r35, "[", r37, false, 4, null);
        if (r38 < 0) goto L53;
        int r39 = StringsKt.indexOf$default(r35, "]", r37, false, 4, null);
    L54:
        if (r38 < 0) goto L62;
        if (r39 < 0) goto L62;
        int r40 = r38 + 1;
        if (r40 > r39) goto L62;
        if (r35 == null) goto L61;
        String r41 = r35.substring(r40, r39);
    L63:
        r37 = r39 + 1;
        if (r41 == null) goto L65;
        r26 = r11;
        r27 = r15;
        if (StringsKt.contains$default(r41, "..", false, 2, null) == false) goto L95;
        List r42 = StringsKt.split$default(r41, new String[]{".."}, false, 0, 6, null);
        if (r42.size() != 2) goto L99;
        String r43 = (String) CollectionsKt.getOrNull(r42, 0);
        if (r43 != null) goto L73;
        int r44 = 1;
        Integer r119 = null;
    L81:
        String r45 = (String) CollectionsKt.getOrNull(r42, r44);
        if (r45 != null) goto L84;
        Integer r46 = null;
    L91:
        if (r119 == null) goto L99;
        if (r46 == null) goto L99;
        r119.intValue();
        r46.intValue();
        r34.add(new a());
        goto L99
    L84:
        if (r45.length() != 0) goto L86;
        boolean r47 = true;
    L87:
        if (r47 == false) goto L89;
        r46 = -1;
        goto L91
    L89:
        r46 = StringsKt.toIntOrNull(r45);
        goto L91
    L86:
        r47 = false;
        goto L87
    L73:
        if (r43.length() != 0) goto L75;
        boolean r120 = true;
    L76:
        if (r120 == false) goto L78;
        r119 = -1;
    L79:
        r44 = 1;
        goto L81
    L78:
        r119 = StringsKt.toIntOrNull(r43);
        goto L79
    L75:
        r120 = false;
    L99:
        if (r37 >= r35.length()) goto L101;
        r11 = r26;
        r15 = r27;
    L101:
        if (r37 < r35.length()) goto L103;
    L112:
        Pair r48 = new Pair(r32, r34);
        p0 r49 = (p0) r48.component1();
        List r50 = (List) r48.component2();
        if (r115 == null) goto L119;
        HashMap r51 = r22.a();
        if (r51 == null) goto L118;
        yl.e r121 = (yl.e) r51.get(r115);
        if (r121 == null) goto L118;
    L120:
        EditableNode r52 = new EditableNode(r114, r121, r49, r50);
        Intrinsics.checkNotNullParameter(r22, "settingsConfig");
        if (r112 != null) goto L127;
        if (Intrinsics.areEqual(r52.c, "$") == false) goto L125;
        r52.b = r52;
        goto L127
    L125:
        r112 = new EditableNode("$", null, p0.d.b, CollectionsKt.emptyList());
        r112.b = r112;
    L127:
        if (r112 == null) goto L132;
        EditableNode r53 = r112.b;
        if (r53 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("headNode");
    L131:
        r52.b = r53;
    L132:
        r112 = r52;
        r13 = r24;
        r19 = r25;
        r111 = r210;
        r11 = r26;
        r15 = r27;
        r20 = 1;
        r21 = 0;
    L118:
        EditableNode r122 = null;
    L139:
        if (r122 == null) goto L142;
        r18.add(r122);
        goto L142
    L119:
        r121 = null;
        goto L120
    L103:
        if (StringsKt.indexOf$default(r35, "<json>", r37, false, 4, null) == (-1)) goto L112;
        if (Intrinsics.areEqual(r32, p0.c.b) == false) goto L108;
        r32 = p0.a.b.b;
        goto L112
    L108:
        if (Intrinsics.areEqual(r32, p0.b.b) == false) goto L112;
        r32 = p0.a.C0138a.b;
        goto L112
    L95:
        Integer r54 = StringsKt.toIntOrNull(r41);
        if (r54 == null) goto L99;
        r54.intValue();
        r54.intValue();
        r34.add(new a());
        goto L99
    L65:
        r26 = r11;
        r27 = r15;
        goto L101
    L61:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L62:
        r41 = null;
        goto L63
    L53:
        r39 = -1;
        goto L54
    L111:
        r26 = r11;
        r27 = r15;
        goto L112
    L44:
        if (r35.length() == 0) goto L47;
        r36 = false;
        goto L48
    L41:
        r35 = null;
    L31:
        r33 = false;
        goto L32
    L30:
        r25 = r19;
        r117 = r31;
        r210 = r111;
        r118 = r116;
        r32.getClass();
        goto L31
    L35:
        r24 = r13;
        r25 = r19;
        r210 = r111;
        r32 = null;
        goto L36
    L22:
        r26 = r11;
        r24 = r13;
        r27 = r15;
        r25 = r19;
        goto L118
    L133:
        r26 = r11;
        r24 = r13;
        r27 = r15;
        r25 = r19;
        if (r112 == null) goto L138;
        r122 = r112.b;
        if (r122 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("headNode");
        goto L139
    L138:
        r122 = null;
        goto L139
    L143:
        HashMap r211 = r11;
        r23 = r13;
        String r212 = r15;
        if ((!r18.isEmpty()) == false) goto L154;
        Integer r55 = r16.a();
        if (r55 == null) goto L148;
        int r56 = r55.intValue();
    L149:
        Integer r57 = Integer.valueOf(r56);
        Boolean r58 = r16.c();
        if (r58 == null) goto L152;
        boolean r59 = r58.booleanValue();
    L153:
        Triple r60 = new Triple(r57, Boolean.valueOf(r59), r18);
        r11 = r211;
        r11.put(r212, r60);
        goto L155
    L152:
        r59 = false;
        goto L153
    L148:
        r56 = Integer.MAX_VALUE;
        goto L149
    L154:
        r11 = r211;
        goto L155
    L156:
        r11.isEmpty();
    L158:
        return Unit.INSTANCE;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((yl.c) r1, (Continuation) r10);
    }
}
