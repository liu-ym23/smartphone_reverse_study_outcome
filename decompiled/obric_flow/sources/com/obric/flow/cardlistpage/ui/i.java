package com.obric.flow.cardlistpage.ui;

import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import androidx.recyclerview.widget.RecyclerView;
import com.drakeet.multitype.MultiTypeAdapter;
import com.obric.flow.cardlistpage.R$xml;
import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.base.CardType;
import com.obric.flow.cardlistpage.data.HeaderWidgetCardModel;
import com.obric.flow.cardlistpage.data.TravelCardModel;
import com.obric.flow.cardlistpage.data.m;
import com.obric.flow.cardlistpage.data.o;
import com.obric.flow.cardlistpage.data.r;
import com.obric.flow.cardlistpage.data.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f11777a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f11778b = true;

    static {
        f11777a = new i();
    }

    public static final Object a(i r17, String r18, RecyclerView r19, AppWidgetManager r20, AppWidgetHost r21, int r22, ContinuationImpl r23) {
        AppWidgetManager r5 = r20;
        AppWidgetHost r10 = r21;
        r17.getClass();
        if ((r23 instanceof CardFeedUtils$loadDataWithDB$1) == false) goto L7;
        CardFeedUtils$loadDataWithDB$1 r11 = (CardFeedUtils$loadDataWithDB$1) r23;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L18;
        if (r15 == 1) goto L17;
        if (r15 == 2) goto L16;
        if (r15 != 3) goto L15;
        int r16 = r11.I$0;
        Iterator r24 = (Iterator) r11.L$5;
        List r25 = (List) r11.L$4;
        List<AppWidgetProviderInfo> r26 = (List) r11.L$3;
        AppWidgetHost r27 = (AppWidgetHost) r11.L$2;
        AppWidgetManager r28 = (AppWidgetManager) r11.L$1;
        String r110 = (String) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L30:
        if (r24.hasNext() == false) goto L52;
        BaseCardModel r29 = (BaseCardModel) r24.next();
        if (r29.getType() == CardType.WIDGET) goto L33;
        r25.add(r29);
        goto L30
    L33:
        Integer r111 = StringsKt.toIntOrNull(r29.getOriginalId());
        if (r111 == null) goto L30;
        int r112 = r111.intValue();
        AppWidgetProviderInfo r113 = r28.getAppWidgetInfo(r112);
        if (r113 == null) goto L48;
        Intrinsics.checkNotNull(r26);
        if (r26 != null) goto L40;
    L42:
        Iterator<T> r114 = r26.iterator();
    L44:
        if (r114.hasNext() == false) goto L48;
        if (Intrinsics.areEqual(((AppWidgetProviderInfo) r114.next()).provider, r113.provider) == false) goto L44;
        r25.add(r29);
        goto L30
    L40:
        if (r26.isEmpty() == false) goto L42;
    L48:
        r27.deleteAppWidgetId(r112);
        com.obric.flow.cardlistpage.c r115 = com.obric.flow.cardlistpage.c.f11462b.f();
        String r30 = r29.getId();
        r11.L$0 = r110;
        r11.L$1 = r28;
        r11.L$2 = r27;
        r11.L$3 = r26;
        r11.L$4 = r25;
        r11.L$5 = r24;
        r11.I$0 = r16;
        r11.label = 3;
        if (r115.b(r30, r11) != r14) goto L30;
        return r14;
    L52:
        ju.a r31 = ju.a.f18481a;
        r31.d("CardFeedUtils", "refreshData listSize:" + r25.size() + " desc:" + r110);
        r31.i("MinusOneWidgetInitializer", "loadDataWithDB");
        TravelCardModel.Companion.getClass();
        r25.add(0, s.a());
        r25.add(0, new HeaderWidgetCardModel(4, r16));
        return r25;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r16 = r11.I$0;
        r10 = (AppWidgetHost) r11.L$2;
        AppWidgetManager r32 = (AppWidgetManager) r11.L$1;
        String r33 = (String) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L28:
        List<AppWidgetProviderInfo> r34 = r32.getInstalledProviders();
        ArrayList r35 = new ArrayList();
        r110 = r33;
        r26 = r34;
        r27 = r10;
        r24 = ((List) r13).iterator();
        r28 = r32;
        r25 = r35;
        goto L30
    L17:
        int r36 = r11.I$0;
        r10 = (AppWidgetHost) r11.L$2;
        AppWidgetManager r37 = (AppWidgetManager) r11.L$1;
        String r38 = (String) r11.L$0;
        ResultKt.throwOnFailure(r13);
        int r116 = r36;
        r5 = r37;
        String r39 = r38;
    L24:
        m r40 = m.f11499a;
        r11.L$0 = r39;
        r11.L$1 = r5;
        r11.L$2 = r10;
        r11.I$0 = r116;
        r11.label = 2;
        r13 = r40.a(r11);
        if (r13 == r14) goto L71;
        r32 = r5;
        r33 = r39;
        r16 = r116;
        goto L28
    L71:
        return r14;
    L18:
        ResultKt.throwOnFailure(r13);
        if (Intrinsics.areEqual(td.c.f(r19.getContext()), o.f11501b) == false) goto L23;
        r r41 = new r(r19.getContext(), r5, r10);
        int r42 = R$xml.default_minus_one_widgets;
        r39 = r18;
        r11.L$0 = r39;
        r11.L$1 = r5;
        r11.L$2 = r10;
        r116 = r22;
        r11.I$0 = r116;
        r11.label = 1;
        if (r41.a(r42, r11) != r14) goto L24;
        return r14;
    L23:
        r39 = r18;
        r116 = r22;
    L7:
        r11 = new CardFeedUtils$loadDataWithDB$1(r17, r23);
        goto L8
    }

    public static int b(MultiTypeAdapter r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "adapter");
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L9
        if (r11 >= 0) goto L6;
    L11:
        String r13 = "invalid position: " + r11;     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter("CardFeedUtils", "tag");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r13, "msg");     // Catch: Throwable -> L9
        org.koin.core.a r5 = su.a.f22013b;     // Catch: Throwable -> L9
        if (r5 == null) goto L15;
        ((ju.b) r5.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).w("CardFeedUtils", r13);     // Catch: Throwable -> L9
        Object r14 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L17:
        Throwable r15 = Result.m127exceptionOrNullimpl(r14);
        if (r15 == null) goto L24;
        String r16 = "getCardSpanSize error:" + r11 + " " + r15;
        Intrinsics.checkNotNullParameter("CardFeedUtils", "tag");
        Intrinsics.checkNotNullParameter(r16, "msg");
        Intrinsics.checkNotNullParameter(r15, "t");
        org.koin.core.a r17 = su.a.f22013b;
        if (r17 == null) goto L23;
        ((ju.b) r17.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("CardFeedUtils", r16, r15);
        return 4;
    L23:
        throw new IllegalStateException("KoinApplication has not been started");
    L24:
        return 4;
    L15:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Throwable -> L9
    L6:
        if (r11 >= r10.f7569a.size()) goto L11;
        Object r18 = r10.f7569a.get(r11);     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.obric.flow.cardlistpage.base.BaseCardModel");     // Catch: Throwable -> L9
        return ((BaseCardModel) r18).getSpanX();
    L9:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
