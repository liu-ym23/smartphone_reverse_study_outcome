package com.larus.uaigc.music.template;

import com.larus.utils.logger.FLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class MusicTemplateRepository {
    public static final MusicTemplateRepository a = null;
    public static final MutableSharedFlow<Integer> b = null;
    public static boolean c;
    public static MusicTemplateModel d;

    public MusicTemplateRepository() {
    }

    static {
        a = new MusicTemplateRepository();
        b = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    public static void a(long r6) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new MusicTemplateRepository$countMusicTemplateUse$1(r6, null), 3, null);
    }

    public final Object c(Continuation<? super Unit> r6) {
        if ((r6 instanceof MusicTemplateRepository$prefetch$1) == false) goto L7;
        MusicTemplateRepository$prefetch$1 r0 = (MusicTemplateRepository$prefetch$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        MusicTemplateModel r4 = (MusicTemplateModel) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L22:
        d = r4;
        c = false;
    L24:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        FLogger.a.i("MusicTemplateRepository", "try preFetch template list ");
        if (c == false) goto L17;
    L18:
        MusicTemplateModel r8 = new MusicTemplateModel();
        r0.L$0 = r8;
        r0.label = 1;
        if (r8.b(r0) != r2) goto L21;
        return r2;
    L21:
        r4 = r8;
        goto L22
    L17:
        if (d != null) goto L24;
    L7:
        r0 = new MusicTemplateRepository$prefetch$1(this, r6);
        goto L8
    }

    public final Object b(boolean r5, Continuation<? super MusicTemplateModel> r6) {
        if ((r6 instanceof MusicTemplateRepository$obtain$1) == false) goto L7;
        MusicTemplateRepository$obtain$1 r0 = (MusicTemplateRepository$obtain$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r5 = r0.Z$0;
        MusicTemplateModel r4 = (MusicTemplateModel) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L20:
        d = r4;
        MusicTemplateModel r8 = r4;
    L21:
        if (r5 == false) goto L23;
        c = true;
    L23:
        return r8;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        r8 = d;
        if (r8 != null) goto L21;
        MusicTemplateModel r9 = new MusicTemplateModel();
        r0.L$0 = r9;
        r0.Z$0 = r5;
        r0.label = 1;
        if (r9.b(r0) != r2) goto L19;
        return r2;
    L19:
        r4 = r9;
    L7:
        r0 = new MusicTemplateRepository$obtain$1(this, r6);
        goto L8
    }
}
