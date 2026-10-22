package com.obric.flow.cardlistpage.data;

import androidx.room.CoroutinesRoom;
import androidx.room.RoomSQLiteQuery;
import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.base.CardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.x;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f11499a = null;

    static {
        f11499a = new m();
    }

    /* JADX WARN: Type inference failed for: r6v6, types: [com.obric.flow.cardlistpage.data.j[], java.io.Serializable] */
    public static Object b(List r10, SuspendLambda r11) {
        ArrayList r5 = new ArrayList();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if ((((BaseCardModel) r13) instanceof HeaderWidgetCardModel) == true) goto L4;
        r5.add(r13);
        goto L4
    L8:
        ArrayList r14 = new ArrayList(CollectionsKt.h(r5));
        Iterator r15 = r5.iterator();
        int r16 = 0;
    L9:
        CardDatabase r17 = null;
        if (r15.hasNext() == false) goto L15;
        Object r18 = r15.next();
        int r19 = r16 + 1;
        if (r16 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        BaseCardModel r20 = (BaseCardModel) r18;
        r20.setSortIndex(Boxing.boxInt(r19));
        r14.add(l.a(r20, null, 3));
        r16 = r19;
        goto L9
    L15:
        CardDatabase r21 = n.f11500a;
        if (r21 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("db");
    L19:
        a r22 = r17.a();
        j[] r23 = (j[]) r14.toArray(new j[0]);
        ?? r24 = (j[]) Arrays.copyOf(r23, r23.length);
        h r25 = (h) r22;
        r25.getClass();
        Object r26 = CoroutinesRoom.execute(r25.f11479a, true, new com.bytedance.android.anniex.ui.a(r25, r24, 7), r11);
        if (r26 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        return r26;
    L23:
        return Unit.INSTANCE;
    L18:
        r17 = r21;
        goto L19
    }

    public final Object a(ContinuationImpl r49) {
        int r5 = 2;
        int r10 = 3;
        int r11 = 0;
        if ((r49 instanceof CardSortUtils$getSortedCards$1) == false) goto L7;
        CardSortUtils$getSortedCards$1 r12 = (CardSortUtils$getSortedCards$1) r49;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L20:
        List r17 = CollectionsKt.sortedWith((List) r14, ComparisonsKt.compareBy(new Function1[]{CardSortUtils$getSortedCards$2.INSTANCE, CardSortUtils$getSortedCards$3.INSTANCE, CardSortUtils$getSortedCards$4.INSTANCE}));
        ArrayList r18 = new ArrayList(CollectionsKt.h(r17));
        Iterator r19 = r17.iterator();
    L22:
        if (r19.hasNext() == false) goto L64;
        j r20 = (j) r19.next();
        kotlinx.serialization.json.p r21 = l.f11498a;
        Intrinsics.checkNotNullParameter(r20, "<this>");
        int r22 = k.f11497a[CardType.valueOf(r20.f11485c).ordinal()];
        if (r22 == 1) goto L62;
        String r23 = r20.f11484b;
        if (r22 == r5) goto L34;
        if (r22 != r10) goto L33;
        if (Intrinsics.areEqual(r23, TravelCardModel.ORIGINAL_ID) == false) goto L31;
        Object r24 = new TravelCardModel(r20.f11483a, null, r20.f, r20.g, r20.d, r20.e, r20.f11486h, r20.f11487i, r20.f11488j, r20.f11489k, 2, null);
    L63:
        r18.add(r24);
        r5 = 2;
        r10 = 3;
        goto L22
    L31:
        r24 = new BaseCardModel(r20.f11483a, r20.f11484b, CardType.valueOf(r20.f11485c), r20.f, r20.g, r20.d, r20.e, r20.f11486h, r20.f11487i, r20.f11488j, r20.f11489k);
        goto L63
    L33:
        throw new NoWhenBranchMatchedException();
    L34:
        String r25 = r20.f11494p;
        if (r25 == null) goto L37;
        x r26 = l.b(r25);
    L38:
        String r27 = r20.f11495q;
        if (r27 == null) goto L41;
        x r28 = l.b(r27);
    L42:
        Integer r29 = r20.f11490l;
        if (r29 == null) goto L48;
        String r30 = r29.toString();
        if (r30 == null) goto L48;
        String r31 = r30;
    L49:
        String r32 = r20.f11491m;
        if (r32 != null) goto L52;
        String r33 = "";
    L53:
        String r34 = r20.f11492n;
        if (r34 != null) goto L56;
        String r35 = "";
    L57:
        String r36 = r20.f11493o;
        if (r36 != null) goto L60;
        String r37 = "";
    L61:
        r24 = new MiniAppWidgetCardModel(r20.f11483a, r20.f, r20.g, r20.d, r20.e, r20.f11487i, r20.f11488j, r20.f11489k, r31, r33, r35, r37, l.d(r26), l.d(r28));
        goto L63
    L60:
        r37 = r36;
        goto L61
    L56:
        r35 = r34;
        goto L57
    L52:
        r33 = r32;
    L48:
        r31 = r23;
        goto L49
    L41:
        r28 = null;
        goto L42
    L37:
        r26 = null;
        goto L38
    L62:
        r24 = new WidgetCardModel(r20.f11483a, r20.f11484b, r20.f, r20.g, r20.d, r20.e, r20.f11486h, r20.f11487i, r20.f11488j, r20.f11489k);
        goto L63
    L64:
        return r18;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        CardDatabase r38 = n.f11500a;
        if (r38 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("db");
        r38 = null;
    L17:
        h r39 = (h) r38.a();
        r39.getClass();
        kotlinx.coroutines.flow.g r40 = CoroutinesRoom.createFlow(r39.f11479a, false, new String[]{"cards"}, new c(r39, RoomSQLiteQuery.acquire("SELECT * FROM cards ORDER BY `sortIndex` ASC", 0), r11));
        r12.label = 1;
        r14 = kotlinx.coroutines.flow.i.k(r40, r12);
        if (r14 != r15) goto L20;
        return r15;
    L7:
        r12 = new CardSortUtils$getSortedCards$1(this, r49);
        goto L8
    }
}
