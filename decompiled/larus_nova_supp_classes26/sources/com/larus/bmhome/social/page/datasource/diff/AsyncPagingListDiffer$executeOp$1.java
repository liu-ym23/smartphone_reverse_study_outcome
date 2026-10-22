package com.larus.bmhome.social.page.datasource.diff;

import androidx.recyclerview.widget.DiffUtil;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.FakeMessageType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.page.datasource.diff.AsyncPagingListDiffer", f = "PagingListDiffer.kt", i = {0, 0, 1, 1, 1, 3, 3, 3, 5, 5, 5, 7, 7, 7, 9, 9, 9, 9, 11, 11, 11, 11, FakeMessageType.AI_DISCLAIMER, FakeMessageType.AI_DISCLAIMER, FakeMessageType.AI_DISCLAIMER, FakeMessageType.DEVICE_OR_RUNTIME_CHANGED, FakeMessageType.DEVICE_OR_RUNTIME_CHANGED, FakeMessageType.DEVICE_OR_RUNTIME_CHANGED, FakeMessageType.DEVICE_OR_RUNTIME_CHANGED, FakeMessageType.DEVICE_OR_RUNTIME_CHANGED, FakeMessageType.DEVICE_OR_RUNTIME_CHANGED, 17, 17, 17, 17, 19, 19}, l = {463, 473, 310, 483, 317, 493, 324, 503, 334, 513, 342, 523, 352, 533, 361, 543, 388, 553, 404, 563, 415}, m = "executeOp", n = {"op", "$this$withLock_u24default$iv", MusicAppletPage.KEY_SOURCE, "$this$withLock_u24default$iv", "itemCount", "oldList", MusicAppletPage.KEY_SOURCE, "$this$withLock_u24default$iv", MusicAppletPage.KEY_SOURCE, "$this$withLock_u24default$iv", "itemCount", MusicAppletPage.KEY_SOURCE, "$this$withLock_u24default$iv", "itemCount", "oldList", MusicAppletPage.KEY_SOURCE, "$this$withLock_u24default$iv", "itemCount", MusicAppletPage.KEY_SOURCE, "$this$withLock_u24default$iv", "start", "itemCount", MusicAppletPage.KEY_SOURCE, "$this$withLock_u24default$iv", "itemCount", MusicAppletPage.KEY_SOURCE, "payloads", "needUpdate", "$this$withLock_u24default$iv", "start", "end", "subList", "$this$withLock_u24default$iv", "startIndex", "count", "$this$withLock_u24default$iv", "count"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "I$0"})
final class AsyncPagingListDiffer$executeOp$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsyncPagingListDiffer<Object> this$0;

    public AsyncPagingListDiffer$executeOp$1(AsyncPagingListDiffer<Object> r1, Continuation<? super AsyncPagingListDiffer$executeOp$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r15) {
        this.result = r15;
        this.label |= Integer.MIN_VALUE;
        AsyncPagingListDiffer<Object> r3 = this.this$0;
        int r16 = AsyncPagingListDiffer.e;
        r3.getClass();
        int r17 = this.label;
        if ((r17 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r17 - Integer.MIN_VALUE;
        AsyncPagingListDiffer$executeOp$1 r18 = this;
    L6:
        Object r0 = r18.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r2 = true;
        switch(r18.label) {
            case 0: goto L182;
            case 1: goto L110;
            case 2: goto L101;
            case 3: goto L100;
            case 4: goto L92;
            case 5: goto L91;
            case 6: goto L82;
            case 7: goto L81;
            case 8: goto L73;
            case 9: goto L91;
            case 10: goto L65;
            case 11: goto L91;
            case 12: goto L57;
            case 13: goto L91;
            case 14: goto L48;
            case 15: goto L47;
            case 16: goto L26;
            case 17: goto L91;
            case 18: goto L18;
            case 19: goto L91;
            case 20: goto L10;
            case 21: goto L91;
            default: goto L9;
        };
    L10:
        int r1 = r18.I$0;
        kotlinx.coroutines.sync.a r4 = (kotlinx.coroutines.sync.a) r18.L$0;
        ResultKt.throwOnFailure(r0);
        r3.j(CollectionsKt.emptyList());     // Catch: Throwable -> L15
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r4.unlock(null);
        MainCoroutineDispatcher r6 = Dispatchers.getMain().getImmediate();
        AsyncPagingListDiffer$executeOp$21 r8 = new AsyncPagingListDiffer$executeOp$21(r3, r1, null);
        r18.L$0 = null;
        r18.label = 21;
        if (BuildersKt.withContext(r6, r8, r18) != r7) goto L215;
        return r7;
    L215:
        return Unit.INSTANCE;
    L15:
        th = move-exception;
        r4.unlock(null);
        throw th;
    L18:
        int r9 = r18.I$1;
        int r10 = r18.I$0;
        kotlinx.coroutines.sync.a r11 = (kotlinx.coroutines.sync.a) r18.L$1;
        List r12 = (List) r18.L$0;
        ResultKt.throwOnFailure(r0);
        r3.j(com.larus.utils.h.d(r12));     // Catch: Throwable -> L23
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L23
        r11.unlock(null);
        MainCoroutineDispatcher r14 = Dispatchers.getMain().getImmediate();
        AsyncPagingListDiffer$executeOp$19 r19 = new AsyncPagingListDiffer$executeOp$19(r3, r10, r9, null);
        r18.L$0 = null;
        r18.L$1 = null;
        r18.label = 19;
        if (BuildersKt.withContext(r14, r19, r18) != r7) goto L215;
        return r7;
    L23:
        th = move-exception;
        r11.unlock(null);
        throw th;
    L26:
        int r20 = r18.I$1;
        int r21 = r18.I$0;
        kotlinx.coroutines.sync.a r22 = (kotlinx.coroutines.sync.a) r18.L$3;
        Ref.BooleanRef r23 = (Ref.BooleanRef) r18.L$2;
        List r24 = (List) r18.L$1;
        List r110 = (List) r18.L$0;
        ResultKt.throwOnFailure(r0);
    L44:
        th = move-exception;
        r22.unlock(null);
        throw th;
    L28:
        if (com.larus.utils.h.a(r3.d, r21) == true) goto L30;
    L38:
        Unit r25 = Unit.INSTANCE;     // Catch: Throwable -> L44
        r22.unlock(null);
        if (r23.element == false) goto L215;
        MainCoroutineDispatcher r26 = Dispatchers.getMain().getImmediate();
        AsyncPagingListDiffer$executeOp$17 r111 = new AsyncPagingListDiffer$executeOp$17(r24, r3, r21, r20, null);
        r18.L$0 = null;
        r18.L$1 = null;
        r18.L$2 = null;
        r18.L$3 = null;
        r18.label = 17;
        if (BuildersKt.withContext(r26, r111, r18) != r7) goto L215;
        return r7;
    L30:
        if (com.larus.utils.h.a(r3.d, r20) == false) goto L38;
        r23.element = true;     // Catch: Throwable -> L44
        List<? extends Object> r27 = CollectionsKt.toMutableList(r3.d);     // Catch: Throwable -> L44
        int r28 = r21;
    L32:
        if (r28 >= r20) goto L37;
        Object r112 = r27.get(r28);     // Catch: Throwable -> L44
        Object r113 = r110.get(r28 - r21);     // Catch: Throwable -> L44
        DiffUtil.ItemCallback<Item> r114 = r3.a;     // Catch: Throwable -> L44
        Intrinsics.checkNotNull(r113);     // Catch: Throwable -> L44
        Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L44
        Object r115 = r114.getChangePayload(r113, r112);     // Catch: Throwable -> L44
        if (r115 == null) goto L36;
        r24.add(r115);     // Catch: Throwable -> L44
    L36:
        r28 = r28 + 1;     // Catch: Throwable -> L44
        goto L32
    L37:
        r3.j(r27);     // Catch: Throwable -> L44
        goto L38
    L47:
        ResultKt.throwOnFailure(r0);
    L209:
        return Unit.INSTANCE;
    L48:
        int r29 = r18.I$0;
        kotlinx.coroutines.sync.a r30 = (kotlinx.coroutines.sync.a) r18.L$1;
        List r31 = (List) r18.L$0;
        ResultKt.throwOnFailure(r0);
        r3.j(com.larus.utils.h.d(r31));     // Catch: Throwable -> L54
        Unit r32 = Unit.INSTANCE;     // Catch: Throwable -> L54
        r30.unlock(null);
        MainCoroutineDispatcher r33 = Dispatchers.getMain().getImmediate();
        AsyncPagingListDiffer$executeOp$15 r34 = new AsyncPagingListDiffer$executeOp$15(r3, r29, null);
        r18.L$0 = null;
        r18.L$1 = null;
        r18.label = 15;
        if (BuildersKt.withContext(r33, r34, r18) != r7) goto L209;
        return r7;
    L54:
        th = move-exception;
        r30.unlock(null);
        throw th;
    L57:
        int r35 = r18.I$1;
        int r36 = r18.I$0;
        kotlinx.coroutines.sync.a r37 = (kotlinx.coroutines.sync.a) r18.L$1;
        List r38 = (List) r18.L$0;
        ResultKt.throwOnFailure(r0);
        List r39 = CollectionsKt.toMutableList(r3.d);     // Catch: Throwable -> L62
        r39.addAll(r36, r38);     // Catch: Throwable -> L62
        Intrinsics.checkNotNullParameter(r39, "<this>");     // Catch: Throwable -> L62
        r3.j(Collections.unmodifiableList(r39));     // Catch: Throwable -> L62
        Unit r40 = Unit.INSTANCE;     // Catch: Throwable -> L62
        r37.unlock(null);
        MainCoroutineDispatcher r41 = Dispatchers.getMain().getImmediate();
        AsyncPagingListDiffer$executeOp$13 r42 = new AsyncPagingListDiffer$executeOp$13(r3, r36, r35, null);
        r18.L$0 = null;
        r18.L$1 = null;
        r18.label = 13;
        if (BuildersKt.withContext(r41, r42, r18) != r7) goto L215;
        return r7;
    L62:
        th = move-exception;
        r37.unlock(null);
        throw th;
    L65:
        int r43 = r18.I$0;
        kotlinx.coroutines.sync.a r44 = (kotlinx.coroutines.sync.a) r18.L$2;
        List r45 = (List) r18.L$1;
        List r46 = (List) r18.L$0;
        ResultKt.throwOnFailure(r0);
        r3.j(com.larus.utils.h.d(CollectionsKt.plus(r3.d, r45)));     // Catch: Throwable -> L70
        Unit r47 = Unit.INSTANCE;     // Catch: Throwable -> L70
        r44.unlock(null);
        MainCoroutineDispatcher r48 = Dispatchers.getMain().getImmediate();
        AsyncPagingListDiffer$executeOp$11 r49 = new AsyncPagingListDiffer$executeOp$11(r3, r46, r43, null);
        r18.L$0 = null;
        r18.L$1 = null;
        r18.L$2 = null;
        r18.label = 11;
        if (BuildersKt.withContext(r48, r49, r18) != r7) goto L215;
        return r7;
    L70:
        th = move-exception;
        r44.unlock(null);
        throw th;
    L73:
        int r50 = r18.I$0;
        kotlinx.coroutines.sync.a r51 = (kotlinx.coroutines.sync.a) r18.L$1;
        List r52 = (List) r18.L$0;
        ResultKt.throwOnFailure(r0);
        r3.j(com.larus.utils.h.d(CollectionsKt.plus(r52, r3.d)));     // Catch: Throwable -> L78
        Unit r53 = Unit.INSTANCE;     // Catch: Throwable -> L78
        r51.unlock(null);
        MainCoroutineDispatcher r54 = Dispatchers.getMain().getImmediate();
        AsyncPagingListDiffer$executeOp$9 r55 = new AsyncPagingListDiffer$executeOp$9(r3, r50, null);
        r18.L$0 = null;
        r18.L$1 = null;
        r18.label = 9;
        if (BuildersKt.withContext(r54, r55, r18) != r7) goto L215;
        return r7;
    L78:
        th = move-exception;
        r51.unlock(null);
        throw th;
    L81:
        ResultKt.throwOnFailure(r0);
    L210:
        return Unit.INSTANCE;
    L82:
        int r56 = r18.I$0;
        kotlinx.coroutines.sync.a r57 = (kotlinx.coroutines.sync.a) r18.L$1;
        List r58 = (List) r18.L$0;
        ResultKt.throwOnFailure(r0);
        r3.j(com.larus.utils.h.d(r58));     // Catch: Throwable -> L88
        Unit r59 = Unit.INSTANCE;     // Catch: Throwable -> L88
        r57.unlock(null);
        MainCoroutineDispatcher r60 = Dispatchers.getMain().getImmediate();
        AsyncPagingListDiffer$executeOp$7 r61 = new AsyncPagingListDiffer$executeOp$7(r3, r56, null);
        r18.L$0 = null;
        r18.L$1 = null;
        r18.label = 7;
        if (BuildersKt.withContext(r60, r61, r18) != r7) goto L210;
        return r7;
    L88:
        th = move-exception;
        r57.unlock(null);
        throw th;
    L91:
        ResultKt.throwOnFailure(r0);
        goto L215
    L92:
        kotlinx.coroutines.sync.a r62 = (kotlinx.coroutines.sync.a) r18.L$2;
        List r63 = (List) r18.L$1;
        List r64 = (List) r18.L$0;
        ResultKt.throwOnFailure(r0);
        r3.j(com.larus.utils.h.d(r63));     // Catch: Throwable -> L97
        Unit r65 = Unit.INSTANCE;     // Catch: Throwable -> L97
        r62.unlock(null);
        DiffUtil.DiffResult r66 = DiffUtil.calculateDiff(r3.a(r64, r63));
        MainCoroutineDispatcher r67 = Dispatchers.getMain().getImmediate();
        AsyncPagingListDiffer$executeOp$5 r68 = new AsyncPagingListDiffer$executeOp$5(r66, r3, null);
        r18.L$0 = null;
        r18.L$1 = null;
        r18.L$2 = null;
        r18.label = 5;
        if (BuildersKt.withContext(r67, r68, r18) != r7) goto L215;
        return r7;
    L97:
        th = move-exception;
        r62.unlock(null);
        throw th;
    L100:
        ResultKt.throwOnFailure(r0);
    L211:
        return Unit.INSTANCE;
    L101:
        int r69 = r18.I$0;
        kotlinx.coroutines.sync.a r70 = (kotlinx.coroutines.sync.a) r18.L$1;
        List r71 = (List) r18.L$0;
        ResultKt.throwOnFailure(r0);
        r3.j(com.larus.utils.h.d(r71));     // Catch: Throwable -> L107
        Unit r72 = Unit.INSTANCE;     // Catch: Throwable -> L107
        r70.unlock(null);
        MainCoroutineDispatcher r73 = Dispatchers.getMain().getImmediate();
        AsyncPagingListDiffer$executeOp$3 r74 = new AsyncPagingListDiffer$executeOp$3(r3, r69, null);
        r18.L$0 = null;
        r18.L$1 = null;
        r18.label = 3;
        if (BuildersKt.withContext(r73, r74, r18) != r7) goto L211;
        return r7;
    L107:
        th = move-exception;
        r70.unlock(null);
        throw th;
    L110:
        kotlinx.coroutines.sync.a r75 = (kotlinx.coroutines.sync.a) r18.L$1;
        AsyncPagingListDiffer.b r76 = (AsyncPagingListDiffer.b) r18.L$0;
        ResultKt.throwOnFailure(r0);
        List r77 = com.larus.utils.h.d(r3.d);     // Catch: Throwable -> L179
        r75.unlock(null);
        List r78 = com.larus.utils.h.d(r76.d);
        int r79 = r76.b;
        int r80 = r76.c;
        if (r76.a != 3) goto L115;
    L117:
        int r81 = r76.a;
        if (r81 == 0) goto L174;
        if (r81 == 1) goto L161;
        if (r81 == 2) goto L149;
        if (r81 == 3) goto L130;
        if (r81 != 4) goto L215;
        if (r77.isEmpty() == true) goto L213;
        int r82 = r3.d.size();
        r18.L$0 = null;
        r18.L$1 = null;
        r18.I$0 = r82;
        r18.label = 20;
        throw null;
    L213:
        return Unit.INSTANCE;
    L130:
        if (r77.isEmpty() == true) goto L214;
        int r83 = com.larus.utils.h.f(r77, r79);
        int r84 = r80 + r83;
        Intrinsics.checkNotNullParameter(r77, "<this>");
        if (r84 >= 0) goto L135;
    L137:
        r2 = false;
    L138:
        if (r2 == true) goto L143;
        if (r84 >= 0) goto L142;
        r84 = 0;
        goto L143
    L142:
        r84 = r77.size();
    L143:
        List r85 = r77.subList(r83, r84);
        int r86 = r77.size() - r85.size();
        if (r86 <= 0) goto L215;
        r18.L$0 = r85;
        r18.L$1 = null;
        r18.I$0 = r83;
        r18.I$1 = r86;
        r18.label = 18;
        throw null;
    L135:
        if (r84 > r77.size()) goto L137;
    L214:
        return Unit.INSTANCE;
    L149:
        if (r77.isEmpty() == true) goto L158;
        int r87 = r80 + r79;
        if (r87 <= r77.size()) goto L153;
        r87 = r77.size();
    L153:
        if (r87 < r79) goto L155;
        ArrayList r88 = new ArrayList();
        Ref.BooleanRef r89 = new Ref.BooleanRef();
        r18.L$0 = r78;
        r18.L$1 = r88;
        r18.L$2 = r89;
        r18.L$3 = null;
        r18.I$0 = r79;
        r18.I$1 = r87;
        r18.label = 16;
        throw null;
    L155:
        return Unit.INSTANCE;
    L158:
        r18.L$0 = r78;
        r18.L$1 = null;
        r18.I$0 = r80;
        r18.label = 14;
        throw null;
    L161:
        if (r77.isEmpty() == true) goto L171;
        if (r79 > 0) goto L164;
        r18.L$0 = r78;
        r18.L$1 = null;
        r18.I$0 = r80;
        r18.label = 8;
        throw null;
    L164:
        if (r79 < r77.size()) goto L167;
        r18.L$0 = r77;
        r18.L$1 = r78;
        r18.L$2 = null;
        r18.I$0 = r80;
        r18.label = 10;
        throw null;
    L167:
        r18.L$0 = r78;
        r18.L$1 = null;
        r18.I$0 = r79;
        r18.I$1 = r80;
        r18.label = 12;
        throw null;
    L171:
        r18.L$0 = r78;
        r18.L$1 = null;
        r18.I$0 = r80;
        r18.label = 6;
        throw null;
    L174:
        if (r77.isEmpty() == false) goto L177;
        r18.L$0 = r78;
        r18.L$1 = null;
        r18.I$0 = r80;
        r18.label = 2;
        throw null;
    L177:
        r18.L$0 = r77;
        r18.L$1 = r78;
        r18.L$2 = null;
        r18.label = 4;
        throw null;
    L115:
        if (r78.isEmpty() == false) goto L117;
        return Unit.INSTANCE;
    L179:
        th = move-exception;
        r75.unlock(null);
        throw th;
    L182:
        ResultKt.throwOnFailure(r0);
        r18.L$0 = null;
        r18.L$1 = null;
        r18.label = 1;
        throw null;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r18 = new AsyncPagingListDiffer$executeOp$1(r3, this);
        goto L6
    }
}
