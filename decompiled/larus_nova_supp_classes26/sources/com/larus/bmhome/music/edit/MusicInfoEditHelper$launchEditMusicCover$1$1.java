package com.larus.bmhome.music.edit;

import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import com.larus.platform.api.g3;
import com.larus.platform.service.k2;
import com.larus.utils.o0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.edit.MusicInfoEditHelper$launchEditMusicCover$1$1", f = "MusicInfoEditHelper.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
final class MusicInfoEditHelper$launchEditMusicCover$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $callback;
    final /* synthetic */ ActivityResultLauncher<String> $editCoverLauncher;
    final /* synthetic */ ActivityResultLauncher<Intent> $editCoverNewLauncher;
    final /* synthetic */ Fragment $host;
    final /* synthetic */ Fragment $this_run;
    int label;

    public MusicInfoEditHelper$launchEditMusicCover$1$1(a r1, Fragment r2, Fragment r3, ActivityResultLauncher<Intent> r4, ActivityResultLauncher<String> r5, Continuation<? super MusicInfoEditHelper$launchEditMusicCover$1$1> r6) {
        this.$callback = r1;
        this.$host = r2;
        this.$this_run = r3;
        this.$editCoverNewLauncher = r4;
        this.$editCoverLauncher = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MusicInfoEditHelper$launchEditMusicCover$1$1(this.$callback, this.$host, this.$this_run, this.$editCoverNewLauncher, this.$editCoverLauncher, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.bmhome.music.edit.p] */
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L16:
        if (((Boolean) r8).booleanValue() == true) goto L19;
        String r9 = this.$host.getString(2131907943);
        this.$callback.a(new v.a(r9));
        return Unit.INSTANCE;
    L19:
        MusicInfoEditHelper r10 = MusicInfoEditHelper.a;
        final Fragment r2 = this.$this_run;
        final ActivityResultLauncher<Intent> r11 = this.$editCoverNewLauncher;
        final ActivityResultLauncher<String> r3 = this.$editCoverLauncher;
        final ?? r4 = new p(r2, r11, r3);
        k2 r12 = k2.a;
        g3.a.a(r2, null, false, null, false, new o(r4), 30);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        if (this.$callback.c().b != null) goto L19;
        if (o0.d(this.$callback.c().a) == false) goto L19;
        MusicInfoEditHelper r13 = MusicInfoEditHelper.a;
        String r5 = this.$callback.c().a;
        this.label = 1;
        r8 = MusicInfoEditHelper.c(r13, r5, this);
        if (r8 != r0) goto L16;
        return r0;
    }
}
