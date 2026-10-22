package com.larus.bmhome.music.edit;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.larus.bmhome.music.edit.MusicInfoEditHelper$launchEditMusicName$1", f = "MusicInfoEditHelper.kt", i = {0}, l = {298}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class MusicInfoEditHelper$launchEditMusicName$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $callback;
    final /* synthetic */ FragmentActivity $host;
    final /* synthetic */ boolean $isMusicAppletScene;
    final /* synthetic */ kr8.o $musicAppletMobContext;
    private /* synthetic */ Object L$0;
    int label;

    public MusicInfoEditHelper$launchEditMusicName$1(a r1, FragmentActivity r2, boolean r3, kr8.o r4, Continuation<? super MusicInfoEditHelper$launchEditMusicName$1> r5) {
        this.$callback = r1;
        this.$host = r2;
        this.$isMusicAppletScene = r3;
        this.$musicAppletMobContext = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        MusicInfoEditHelper$launchEditMusicName$1 r6 = new MusicInfoEditHelper$launchEditMusicName$1(this.$callback, this.$host, this.$isMusicAppletScene, this.$musicAppletMobContext, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r11);
    L22:
        if (((Boolean) r11).booleanValue() == true) goto L25;
        this.$callback.a(new v.a(this.$host.getString(2131907943)));
        return Unit.INSTANCE;
    L25:
        MusicCreationContent r3 = this.$callback.c().c;
        if (r3 != null) goto L29;
        FLogger.a.e("MusicInfoEditHelper", "[launchEditMusicName] musicContent is null");
        return Unit.INSTANCE;
    L29:
        String r4 = this.$callback.c().a;
        String r5 = this.$callback.c().b;
        String r6 = r3.getTitle();
        if (r6 != null) goto L32;
        r6 = "";
    L32:
        String r7 = r6;
        boolean r8 = this.$isMusicAppletScene;
        kr8.o r9 = this.$musicAppletMobContext;
        final a r10 = this.$callback;
        MusicNameEditSheetDialogFragment r12 = new MusicNameEditSheetDialogFragment(r3, r4, r5, r7, "music_detail", r8, r9, new q(r10));
        final a r13 = this.$callback;
        r12.n = new r(r13);
        if (this.$host.getSupportFragmentManager().isStateSaved() == true) goto L43;
        FragmentActivity r14 = this.$host;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L37
        INVOKEVIRTUAL_com_larus_bmhome_music_edit_MusicInfoEditHelper$launchEditMusicName$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r12, r14.getSupportFragmentManager(), "musicNameEditSheetDialog");     // Catch: Throwable -> L37
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L37
    L39:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L42;
        FLogger.a.e("MusicInfoEditHelper", "[launchEditMusicName] showing dialog, e:" + r17);
    L42:
        Result.box-impl(r16);
    L45:
        return Unit.INSTANCE;
    L37:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L43:
        FLogger.a.e("MusicInfoEditHelper", "[launchEditMusicName] supportFragmentManager.isStateSaved, abandon showing dialog");
        goto L45
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        CoroutineScope r19 = (CoroutineScope) this.L$0;
        String r20 = this.$callback.c().b;
        if (r20 != null) goto L11;
    L14:
        boolean r21 = true;
    L15:
        if (r21 == false) goto L25;
        if (o0.d(this.$callback.c().a) == false) goto L25;
        MusicInfoEditHelper r22 = MusicInfoEditHelper.a;
        String r23 = this.$callback.c().a;
        this.L$0 = r19;
        this.label = 1;
        r11 = MusicInfoEditHelper.c(r22, r23, this);
        if (r11 != r0) goto L22;
        return r0;
    L11:
        if (r20.length() == 0) goto L14;
        r21 = false;
        goto L15
    }

    public static void INVOKEVIRTUAL_com_larus_bmhome_music_edit_MusicInfoEditHelper$launchEditMusicName$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(MusicNameEditSheetDialogFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        MusicNameEditSheetDialogFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
