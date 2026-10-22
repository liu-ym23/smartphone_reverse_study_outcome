package com.larus.bmhome.chat.component.bottom.attachment;

import android.os.SystemClock;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AlbumEduIntentSuggestController$startDetect$1", f = "AlbumEduIntentSuggestController.kt", i = {0}, l = {DoraCallStateCode.ENV_OBSERVE_USER_TIMER_START}, m = "invokeSuspend", n = {"startTime"}, s = {"J$0"})
final class AlbumEduIntentSuggestController$startDetect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<SuggestedAction> $albumEduActions;
    final /* synthetic */ List<SuggestedAction> $baseActions;
    final /* synthetic */ g $snapshot;
    long J$0;
    int label;
    final /* synthetic */ AlbumEduIntentSuggestController this$0;

    public AlbumEduIntentSuggestController$startDetect$1(g r1, AlbumEduIntentSuggestController r2, List<SuggestedAction> r3, List<SuggestedAction> r4, Continuation<? super AlbumEduIntentSuggestController$startDetect$1> r5) {
        this.$snapshot = r1;
        this.this$0 = r2;
        this.$baseActions = r3;
        this.$albumEduActions = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AlbumEduIntentSuggestController$startDetect$1(this.$snapshot, this.this$0, this.$baseActions, this.$albumEduActions, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        long r2 = this.J$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L47 CancellationException -> L59
    L15:
        final ix8.d r11 = (ix8.d) r14;     // Catch: Throwable -> L47 CancellationException -> L59
        if (Intrinsics.areEqual(this.this$0.f, this.$snapshot.b) == false) goto L19;
        AlbumEduIntentSuggestController r15 = this.this$0;
        r15.f = null;
        r15.e = null;
    L19:
        if (r11 != null) goto L22;
        FLogger.a.i("AlbumEduIntentSuggest", "[startDetect] cancelled, durationMs=" + (SystemClock.elapsedRealtime() - r2) + ", " + h.a(this.$snapshot));
        return Unit.INSTANCE;
    L22:
        long r6 = SystemClock.elapsedRealtime() - r2;
        FLogger r16 = FLogger.a;
        StringBuilder r4 = new StringBuilder("[startDetect] finished, status=");
        AlbumEduIntentSuggestController r5 = this.this$0;
        ix8.e r7 = r11.b();
        r5.getClass();
        r4.append(r7.getClass().getSimpleName());
        r4.append(", durationMs=");
        r4.append(r6);
        r4.append(", cached=");
        r4.append(Intrinsics.areEqual(r11.b(), ix8.e.d.a));
        r4.append(", ");
        r4.append(h.a(this.$snapshot));
        r16.i("AlbumEduIntentSuggest", r4.toString());
        final g r8 = (g) this.this$0.c.invoke();
        if (r8 != null) goto L27;
        r16.i("AlbumEduIntentSuggest", "[startDetect] current snapshot unavailable, cache only, " + h.a(this.$snapshot));
        return Unit.INSTANCE;
    L27:
        if (Intrinsics.areEqual(r8.b, this.$snapshot.b) == true) goto L30;
        r16.i("AlbumEduIntentSuggest", "[startDetect] result stale, cache only, detectedImageId=" + this.$snapshot.b + ", currentImageId=" + r8.b);
        return Unit.INSTANCE;
    L30:
        AlbumEduIntentSuggestController r9 = this.this$0;
        g r10 = this.$snapshot;
        r9.getClass();
        if (Intrinsics.areEqual(r8.a, r10.a) == true) goto L33;
    L41:
        r3 = false;
    L42:
        if (r3 == false) goto L45;
        r16.i("AlbumEduIntentSuggest", "[startDetect] reuse loaded actions for result, " + h.a(this.$snapshot));
        this.this$0.j(this.$snapshot, this.$baseActions, this.$albumEduActions, r11, true);
        return Unit.INSTANCE;
    L45:
        r16.i("AlbumEduIntentSuggest", "[startDetect] reload actions for result, " + h.a(r8));
        final AlbumEduIntentSuggestController r17 = this.this$0;
        r17.g(r8, new f(r17, r8, r11));
        return Unit.INSTANCE;
    L33:
        if (Intrinsics.areEqual(r8.b, r10.b) == false) goto L41;
        if (r8.d != r10.d) goto L41;
        if (Intrinsics.areEqual(r8.e, r10.e) == false) goto L41;
        if (r8.g != r10.g) goto L41;
    L50:
        FLogger.a.i("AlbumEduIntentSuggest", "[startDetect] cancelled, durationMs=" + (SystemClock.elapsedRealtime() - r2) + ", " + h.a(this.$snapshot));     // Catch: Throwable -> L47
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L47
        if (Intrinsics.areEqual(this.this$0.f, this.$snapshot.b) == false) goto L54;
        AlbumEduIntentSuggestController r12 = this.this$0;
        r12.f = null;
        r12.e = null;
    L54:
        return r18;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r14);
        long r13 = SystemClock.elapsedRealtime();
        FLogger.a.i("AlbumEduIntentSuggest", "[startDetect] start, " + h.a(this.$snapshot));
        AlbumEduIntentSuggestController r19 = this.this$0;     // Catch: Throwable -> L47 CancellationException -> L49
        g r20 = this.$snapshot;     // Catch: Throwable -> L47 CancellationException -> L49
        this.J$0 = r13;     // Catch: Throwable -> L47 CancellationException -> L49
        this.label = 1;     // Catch: Throwable -> L47 CancellationException -> L49
        r14 = AlbumEduIntentSuggestController.a(r19, r20, this);     // Catch: Throwable -> L47 CancellationException -> L49
        if (r14 != r0) goto L14;
        return r0;
    L14:
        r2 = r13;
    L49:
        r2 = r13;
    L47:
        th = move-exception;
        if (Intrinsics.areEqual(this.this$0.f, this.$snapshot.b) == false) goto L58;
        AlbumEduIntentSuggestController r21 = this.this$0;
        r21.f = null;
        r21.e = null;
    L58:
        throw th;
    }
}
