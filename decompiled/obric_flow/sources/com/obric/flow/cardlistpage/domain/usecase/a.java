package com.obric.flow.cardlistpage.domain.usecase;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.base.CardType;
import com.obric.flow.cardlistpage.data.MiniAppWidgetCardModel;
import com.obric.flow.cardlistpage.data.WidgetCardModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.obric.flow.cardlistpage.domain.repository.b f11514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fq.a f11515b;

    public a(com.obric.flow.cardlistpage.domain.repository.b r5, fq.a r10) {
        this.f11514a = r5;
        this.f11515b = r10;
    }

    public static Object a(a r28, obric.flow.miniappwidget.f r29, ArrayList r30, Integer r31, ContinuationImpl r32) {
        if ((r32 instanceof AddCardUseCase$addMiniAppCard$1) == false) goto L7;
        AddCardUseCase$addMiniAppCard$1 r5 = (AddCardUseCase$addMiniAppCard$1) r32;
        int r10 = r5.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r11 = r5.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r5.label;
        int r14 = 1;
        if (r13 == 0) goto L18;
        if (r13 == 1) goto L17;
        if (r13 == 2) goto L16;
        if (r13 != 3) goto L15;
        List r15 = (List) r5.L$0;
        ResultKt.throwOnFailure(r11);
        return r15;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        MiniAppWidgetCardModel r16 = (MiniAppWidgetCardModel) r5.L$3;
        Integer r17 = (Integer) r5.L$2;
        List r18 = (List) r5.L$1;
        a r19 = (a) r5.L$0;
        ResultKt.throwOnFailure(r11);
    L76:
        MiniAppWidgetCardModel r20 = r16;
        List r110 = r18;
    L77:
        List r21 = CollectionsKt.toMutableList(r110);
        if (r17 != null) goto L80;
    L84:
        int r22 = r21.size();
    L85:
        r21.add(r22, r20);
        r5.L$0 = r21;
        r5.L$1 = null;
        r5.L$2 = null;
        r5.L$3 = null;
        r5.L$4 = null;
        r5.label = 3;
        if (r19.c(r21, r5) != r12) goto L97;
        return r12;
    L97:
        return r21;
    L80:
        if (r17.intValue() < 0) goto L84;
        if (r17.intValue() > r21.size()) goto L84;
        r22 = r17.intValue();
        goto L85
    L17:
        String r23 = (String) r5.L$4;
        r17 = (Integer) r5.L$3;
        List r24 = (List) r5.L$2;
        obric.flow.miniappwidget.f r111 = (obric.flow.miniappwidget.f) r5.L$1;
        a r112 = (a) r5.L$0;
        ResultKt.throwOnFailure(r11);
        r110 = r24;
        obric.flow.miniappwidget.f r25 = r111;
    L24:
        String r26 = Boxing.boxInt(((Number) r11).intValue()).toString();
        if (r26 != null) goto L27;
        String r27 = r23;
    L30:
        r112.getClass();
        ArrayList r33 = new ArrayList();
        Iterator r113 = r110.iterator();
    L32:
        if (r113.hasNext() == false) goto L44;
        BaseCardModel r114 = (BaseCardModel) r113.next();
        if ((r114 instanceof MiniAppWidgetCardModel) == false) goto L36;
        MiniAppWidgetCardModel r115 = (MiniAppWidgetCardModel) r114;
    L37:
        if (r115 == null) goto L41;
        String r116 = r115.getInstanceId();
        if (r116 == null) goto L41;
        Integer r117 = StringsKt.toIntOrNull(r116);
    L42:
        if (r117 == null) goto L32;
        r33.add(r117);
    L41:
        r117 = null;
        goto L42
    L36:
        r115 = null;
        goto L37
    L44:
        Integer r34 = (Integer) CollectionsKt.s(r33);
        if (r34 == null) goto L47;
        r14 = 1 + r34.intValue();
    L47:
        String r210 = String.valueOf(r14);
        String r118 = r27;
    L28:
        r19 = r112;
        String r35 = r25.f20475a;
        String r119 = r25.f20479i;
        if (r119 != null) goto L51;
        String r211 = "";
    L52:
        String r120 = r25.f20476b;
        String r121 = r25.f20477c;
        if (r121 != null) goto L55;
        String r122 = r120;
    L56:
        String r123 = r25.f20480j;
        if (r123 != null) goto L59;
        String r124 = "";
    L60:
        r19.getClass();
        Map r125 = r25.f20482l;
        LinkedHashMap r126 = new LinkedHashMap(MapsKt.mapCapacity(r125.size()));
        Iterator r127 = r125.entrySet().iterator();
    L62:
        if (r127.hasNext() == false) goto L70;
        Map.Entry r128 = (Map.Entry) r127.next();
        Object r36 = r128.getKey();
        Object r129 = r128.getValue();
        if (r129 == null) goto L66;
        String r130 = r129.toString();
    L67:
        if (r130 != null) goto L69;
        r130 = "";
    L69:
        r126.put(r36, r130);
        goto L62
    L66:
        r130 = null;
        goto L67
    L70:
        r20 = new MiniAppWidgetCardModel(r118, r25.d, r25.e, r122, r124, null, Boxing.boxLong(System.currentTimeMillis()), null, r210, r35, r120, r211, r25.f20481k, r126);
        com.obric.flow.cardlistpage.domain.repository.b r37 = r19.f11514a;
        if (r37 == null) goto L77;
        r5.L$0 = r19;
        r5.L$1 = r110;
        r5.L$2 = r17;
        r5.L$3 = r20;
        r5.L$4 = null;
        r5.label = 2;
        if (r37.a(r20, r5) != r12) goto L75;
        return r12;
    L75:
        r16 = r20;
        r18 = r110;
        goto L76
    L59:
        r124 = r123;
        goto L60
    L55:
        r122 = r121;
        goto L56
    L51:
        r211 = r119;
        goto L52
    L27:
        r118 = r23;
        r210 = r26;
        goto L28
    L18:
        ResultKt.throwOnFailure(r11);
        r27 = td.d.c();
        com.obric.flow.cardlistpage.domain.repository.b r38 = r28.f11514a;
        if (r38 == null) goto L29;
        r5.L$0 = r28;
        r25 = r29;
        r5.L$1 = r25;
        r110 = r30;
        r5.L$2 = r110;
        r5.L$3 = r31;
        r5.L$4 = r27;
        r5.label = 1;
        Object r39 = r38.b(r5);
        if (r39 != r12) goto L23;
        return r12;
    L23:
        r112 = r28;
        r23 = r27;
        r11 = r39;
        r17 = r31;
        goto L24
    L29:
        r25 = r29;
        r110 = r30;
        r17 = r31;
        r112 = r28;
    L7:
        r5 = new AddCardUseCase$addMiniAppCard$1(r28, r32);
        goto L8
    }

    public final Object b(int r22, int r23, int r24, int r25, ArrayList r26, Integer r27, ContinuationImpl r28) {
        if ((r28 instanceof AddCardUseCase$invoke$1) == false) goto L7;
        AddCardUseCase$invoke$1 r5 = (AddCardUseCase$invoke$1) r28;
        int r10 = r5.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r11 = r5.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r5.label;
        if (r13 == 0) goto L16;
        if (r13 == 1) goto L15;
        if (r13 != 2) goto L14;
        List r14 = (List) r5.L$0;
        ResultKt.throwOnFailure(r11);
        return r14;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r15 = r5.I$0;
        WidgetCardModel r16 = (WidgetCardModel) r5.L$3;
        Integer r17 = (Integer) r5.L$2;
        List r18 = (List) r5.L$1;
        a r19 = (a) r5.L$0;
        ResultKt.throwOnFailure(r11);
        Integer r110 = r17;
        List r111 = r18;
    L46:
        int r20 = r15;
    L47:
        WidgetCardModel r112 = r16;
        List r21 = CollectionsKt.toMutableList(r111);
        if (r110 != null) goto L52;
    L56:
        Intrinsics.checkNotNullParameter(r21, "currentCards");
        int r29 = 0;
        if (r21.isEmpty() == false) goto L59;
    L58:
        int r30 = r29;
    L72:
        r21.add(r30, r112);
        r5.L$0 = r21;
        r5.L$1 = null;
        r5.L$2 = null;
        r5.L$3 = null;
        r5.label = 2;
        if (r19.c(r21, r5) != r12) goto L81;
        return r12;
    L81:
        return r21;
    L59:
        if (r20 != 4) goto L61;
        r30 = r21.size();
        goto L72
    L61:
        int r31 = r21.size();
        int r32 = 0;
    L62:
        if (r29 >= r31) goto L71;
        int r113 = ((BaseCardModel) r21.get(r29)).getSpanX();
        int r114 = r32 + r113;
        if (r114 > 4) goto L66;
        r32 = r114;
    L70:
        r29 = r29 + 1;
        goto L62
    L66:
        if (r20 <= (4 - r32)) goto L58;
        r32 = r113;
        goto L70
    L71:
        r30 = r21.size();
        goto L72
    L52:
        if (r110.intValue() < 0) goto L56;
        if (r110.intValue() > r21.size()) goto L56;
        r30 = r110.intValue();
        goto L72
    L16:
        ResultKt.throwOnFailure(r11);
        fq.a r33 = this.f11515b;
        if (r33 == null) goto L76;
        AppWidgetManager r34 = r33.f16973a;
        AppWidgetProviderInfo r35 = r34.getAppWidgetInfo(r22);
        if (r35 == null) goto L21;
        String r115 = r35.label;
    L22:
        if (r115 == null) goto L76;
        AppWidgetProviderInfo r36 = r34.getAppWidgetInfo(r22);
        if (r36 != null) goto L27;
        Pair r37 = null;
    L28:
        if (r37 != null) goto L30;
        return null;
    L30:
        int r38 = ((Number) r37.component1()).intValue();
        int r39 = ((Number) r37.component2()).intValue();
        int r40 = Math.max(1, (int) Math.ceil(r38 / r23));
        int r41 = Math.max(1, (int) Math.ceil(r39 / (r24 + r25)));
        if (r40 <= 4) goto L33;
        r40 = 4;
    L33:
        if (r40 != 2) goto L35;
        if (r41 != 2) goto L35;
    L40:
        Pair r116 = new Pair(Integer.valueOf(r40), Integer.valueOf(r41));
        r20 = ((Number) r116.component1()).intValue();
        int r42 = ((Number) r116.component2()).intValue();
        r16 = r14;
        WidgetCardModel r117 = new WidgetCardModel(td.d.c(), String.valueOf(r22), r20, r42, r115, "", true, null, Boxing.boxLong(System.currentTimeMillis()), null);
        com.obric.flow.cardlistpage.domain.repository.b r118 = this.f11514a;
        if (r118 == null) goto L48;
        r5.L$0 = this;
        r111 = r26;
        r5.L$1 = r111;
        r110 = r27;
        r5.L$2 = r110;
        r5.L$3 = r16;
        r5.I$0 = r20;
        r5.I$1 = r42;
        r5.label = 1;
        if (r118.a(r16, r5) != r12) goto L45;
        return r12;
    L45:
        r19 = this;
        r15 = r20;
        goto L46
    L48:
        r111 = r26;
        r110 = r27;
        r19 = this;
    L35:
        if (r40 != 4) goto L39;
        if (r41 > 2) goto L38;
        r41 = 2;
        goto L40
    L38:
        r41 = 4;
        goto L40
    L39:
        r40 = 2;
        r41 = 2;
        goto L40
    L27:
        r37 = new Pair(Integer.valueOf(r36.minWidth), Integer.valueOf(r36.minHeight));
        goto L28
    L21:
        r115 = null;
    L76:
        return null;
    L7:
        r5 = new AddCardUseCase$invoke$1(this, r28);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0069 -> B:41:0x011f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0075 -> B:41:0x011f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0082 -> B:41:0x011f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0104 -> B:41:0x011f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0117 -> B:40:0x011b). Please report as a decompilation issue!!! */
    public final Object c(List r25, ContinuationImpl r26) {
        if ((r26 instanceof AddCardUseCase$persistSortIndexes$1) == false) goto L7;
        AddCardUseCase$persistSortIndexes$1 r5 = (AddCardUseCase$persistSortIndexes$1) r26;
        int r10 = r5.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r10 - Integer.MIN_VALUE;
        a r11 = this;
    L8:
        Object r12 = r5.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r5.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        int r15 = r5.I$1;
        int r16 = r5.I$0;
        List r17 = (List) r5.L$1;
        a r18 = (a) r5.L$0;
        ResultKt.throwOnFailure(r12);
    L40:
        List r19 = r17;
        int r20 = r16;
        int r21 = r15;
        r11 = r18;
    L41:
        r20 = r20 + 1;
    L15:
        if (r20 >= r21) goto L43;
        BaseCardModel r22 = (BaseCardModel) r19.get(r20);
        r11.getClass();
        if (r22.getType() == CardType.WIDGET) goto L21;
        if (r22.getType() != CardType.MINI_APP) goto L41;
    L21:
        if (Intrinsics.areEqual(r22.getOriginalId(), "-100") == true) goto L41;
        Integer r23 = r22.getSortIndex();
        if (r23 == null) goto L29;
        if (r23.intValue() == r20) goto L41;
    L29:
        if ((r22 instanceof WidgetCardModel) == false) goto L32;
        r22 = new WidgetCardModel(r22.getId(), r22.getOriginalId(), r22.getSpanX(), r22.getSpanY(), r22.getTitle(), r22.getDescription(), r22.isVisible(), Integer.valueOf(r20), r22.getCreateTime(), r22.getModifyTime());
    L34:
        r19.set(r20, r22);
        com.obric.flow.cardlistpage.domain.repository.b r24 = r11.f11514a;
        if (r24 == null) goto L41;
        r5.L$0 = r11;
        r5.L$1 = r19;
        r5.I$0 = r20;
        r5.I$1 = r21;
        r5.label = 1;
        if (r24.f(r22, r5) != r13) goto L39;
        return r13;
    L39:
        r18 = r11;
        r15 = r21;
        r16 = r20;
        r17 = r19;
        goto L40
    L32:
        if ((r22 instanceof MiniAppWidgetCardModel) == false) goto L34;
        String r110 = r22.getId();
        MiniAppWidgetCardModel r27 = (MiniAppWidgetCardModel) r22;
        String r111 = r27.getInstanceId();
        String r112 = r27.getAppletId();
        String r28 = r27.getWidgetId();
        String r29 = r27.getDefinitionId();
        int r113 = r22.getSpanX();
        int r114 = r22.getSpanY();
        String r115 = r22.getTitle();
        String r116 = r22.getDescription();
        Map<String, String> r210 = r27.getConfig();
        Map<String, String> r211 = r27.getExtras();
        r22 = new MiniAppWidgetCardModel(r110, r113, r114, r115, r116, Integer.valueOf(r20), r22.getCreateTime(), r22.getModifyTime(), r111, r112, r28, r29, r210, r211);
        goto L34
    L43:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        r20 = 0;
        r21 = r25.size();
        r19 = r25;
    L7:
        r11 = this;
        r5 = new AddCardUseCase$persistSortIndexes$1(r11, r26);
        goto L8
    }
}
