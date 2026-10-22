package com.larus.bmhome.music.widget;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.widget.MusicPlayerDetailFragment", f = "MusicPlayerDetailFragment.kt", i = {}, l = {255}, m = "getLatestCreationId", n = {}, s = {})
final class MusicPlayerDetailFragment$getLatestCreationId$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MusicPlayerDetailFragment this$0;

    public MusicPlayerDetailFragment$getLatestCreationId$1(MusicPlayerDetailFragment r1, Continuation<? super MusicPlayerDetailFragment$getLatestCreationId$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label |= Integer.MIN_VALUE;
        MusicPlayerDetailFragment r6 = this.this$0;
        int r1 = MusicPlayerDetailFragment.O;
        r6.getClass();
        int r2 = this.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r2 - Integer.MIN_VALUE;
        MusicPlayerDetailFragment$getLatestCreationId$1 r0 = this;
    L6:
        Object r3 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 == 0) goto L29;
        boolean r7 = true;
        if (r4 != 1) goto L28;
        ResultKt.throwOnFailure(r3);
        String r8 = (String) r3;
        if (r8 != null) goto L13;
    L16:
        if (r7 == true) goto L33;
        int r9 = MusicDetailPagerFragment.F;
        if (r8 != null) goto L21;
        r8 = "";
    L21:
        Pair r10 = (Pair) ((LinkedHashMap) MusicDetailPagerFragment.a.a(r8)).get(r6.aa0());
        if (r10 == null) goto L31;
        String r11 = (String) r10.getFirst();
        if (r11 != null) goto L32;
        return "";
    L32:
        return r11;
    L31:
        return "";
    L33:
        return "";
    L13:
        if (r8.length() == 0) goto L16;
        r7 = false;
        goto L16
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L29:
        ResultKt.throwOnFailure(r3);
        return "";
    L5:
        r0 = new MusicPlayerDetailFragment$getLatestCreationId$1(r6, this);
        goto L6
    }
}
