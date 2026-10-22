package com.larus.avlink.env.diary.settings;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.env.diary.settings.DiaryImageSwitchManager$getInsertPhotoEnabled$3", f = "DiaryImageSwitchManager.kt", i = {}, l = {64, 75}, m = "invokeSuspend", n = {}, s = {})
public final class DiaryImageSwitchManager$getInsertPhotoEnabled$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.settings.DiaryImageSwitchManager$getInsertPhotoEnabled$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.diary.settings.DiaryImageSwitchManager$getInsertPhotoEnabled$3$1", f = "DiaryImageSwitchManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Function1<Boolean, Unit>> $callbacks;
        final /* synthetic */ boolean $result;
        int label;

        public AnonymousClass1(List<? extends Function1<? super Boolean, Unit>> r1, boolean r2, Continuation<? super AnonymousClass1> r3) {
            this.$callbacks = r1;
            this.$result = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$callbacks, this.$result, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r4);
            List<Function1<Boolean, Unit>> r5 = this.$callbacks;
            boolean r0 = this.$result;
            Iterator<T> r6 = r5.iterator();
        L6:
            if (r6.hasNext() == false) goto L9;
            ((Function1) r6.next()).invoke(Boxing.boxBoolean(r0));
            goto L6
        L9:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DiaryImageSwitchManager$getInsertPhotoEnabled$3(Continuation<? super DiaryImageSwitchManager$getInsertPhotoEnabled$3> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DiaryImageSwitchManager$getInsertPhotoEnabled$3(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L22:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        boolean r8 = ((Boolean) r7).booleanValue();
        DiaryImageSwitchManager r2 = DiaryImageSwitchManager.a;
        DiaryImageSwitchManager.b = Boxing.boxBoolean(r8);
        DiaryImageSwitchManager r3 = DiaryImageSwitchManager.a;
        monitor-enter(r3);
        DiaryImageSwitchManager.c = false;     // Catch: Throwable -> L23
        List<Function1<Boolean, Unit>> r4 = DiaryImageSwitchManager.d;     // Catch: Throwable -> L23
        List r5 = CollectionsKt.toList(r4);     // Catch: Throwable -> L23
        ((ArrayList) r4).clear();     // Catch: Throwable -> L23
        monitor-exit(r3);
        MainCoroutineDispatcher r6 = Dispatchers.getMain();
        AnonymousClass1 r9 = new AnonymousClass1(r5, r8, null);
        this.label = 2;
        if (BuildersKt.withContext(r6, r9, this) != r0) goto L22;
        return r0;
    L23:
        th = move-exception;
        throw th;
    L10:
        ResultKt.throwOnFailure(r7);
        DiaryImageSwitchManager r10 = DiaryImageSwitchManager.a;
        this.label = 1;
        r7 = DiaryImageSwitchManager.a(r10, this);
        if (r7 != r0) goto L13;
        return r0;
    }
}
