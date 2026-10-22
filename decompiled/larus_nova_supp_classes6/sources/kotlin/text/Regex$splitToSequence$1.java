package kotlin.text;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {1, 1, 1}, l = {275, 283, 287}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "splitCount"}, s = {"L$0", "L$1", "I$0"})
public final class Regex$splitToSequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ CharSequence $input;
    final /* synthetic */ int $limit;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Regex this$0;

    public Regex$splitToSequence$1(Regex r1, CharSequence r2, int r3, Continuation<? super Regex$splitToSequence$1> r4) {
        this.this$0 = r1;
        this.$input = r2;
        this.$limit = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Regex$splitToSequence$1 r0 = new Regex$splitToSequence$1(this.this$0, this.$input, this.$limit, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((SequenceScope) r1, (Continuation) r2);
    }

    public final Object invoke(SequenceScope<? super String> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0070 -> B:21:0x0073). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r11);
    L29:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        int r2 = this.I$0;
        Matcher r5 = (Matcher) this.L$1;
        SequenceScope r6 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r11);
        Regex$splitToSequence$1 r7 = this;
        Matcher r12 = r5;
    L21:
        int r8 = r12.end();
        r2 = r2 + 1;
        if (r2 != (r7.$limit - 1)) goto L24;
    L25:
        CharSequence r13 = r7.$input;
        String r14 = r13.subSequence(r8, r13.length()).toString();
        r7.L$0 = null;
        r7.L$1 = null;
        r7.label = 3;
        if (r6.yield(r14, r7) != r0) goto L29;
        return r0;
    L24:
        if (r12.find() == false) goto L25;
    L18:
        String r9 = r7.$input.subSequence(r8, r12.start()).toString();
        r7.L$0 = r6;
        r7.L$1 = r12;
        r7.I$0 = r2;
        r7.label = 2;
        if (r6.yield(r9, r7) != r0) goto L21;
        return r0;
    L11:
        ResultKt.throwOnFailure(r11);
    L34:
        return Unit.INSTANCE;
    L12:
        ResultKt.throwOnFailure(r11);
        SequenceScope r15 = (SequenceScope) this.L$0;
        Matcher r3 = Regex.access$getNativePattern$p(this.this$0).matcher(this.$input);
        if (this.$limit != 1) goto L15;
    L30:
        String r4 = this.$input.toString();
        this.label = 1;
        if (r15.yield(r4, this) != r0) goto L34;
        return r0;
    L15:
        if (r3.find() == false) goto L30;
        r8 = 0;
        r7 = this;
        r6 = r15;
        r12 = r3;
        r2 = 0;
        goto L18
    }
}
