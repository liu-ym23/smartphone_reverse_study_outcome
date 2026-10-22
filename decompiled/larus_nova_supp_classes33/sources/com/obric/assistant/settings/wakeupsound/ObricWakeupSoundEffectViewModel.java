package com.obric.assistant.settings.wakeupsound;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.im.FlowRuntime;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ObricWakeupSoundConfig;
import com.obric.assistant.ObricWakeupSoundOption;
import com.obric.assistant.WakeupSoundEffectSettings;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.t1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u000eH\u0014J\u0012\u0010\u0013\u001a\u00020\u000e2\b\b\u0001\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u000e2\b\b\u0001\u0010\u0017\u001a\u00020\u0015H\u0002J.\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0017\u001a\u00020\u00152\u0010\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0019H\u0002J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0019H\u0002J \u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0015H\u0002J\u0017\u0010%\u001a\u0004\u0018\u00010\"2\u0006\u0010$\u001a\u00020\u0015H\u0002¢\u0006\u0002\u0010&J$\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u001b2\b\b\u0001\u0010)\u001a\u00020\u00152\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u0015H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006,"}, d2 = {"Lcom/obric/assistant/settings/wakeupsound/ObricWakeupSoundEffectViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "playingStateJob", "Lkotlinx/coroutines/Job;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/assistant/settings/wakeupsound/ObricWakeupSoundEffectUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "refresh", "", "onWakeupSoundEffectSelected", "item", "Lcom/obric/assistant/settings/wakeupsound/WakeupSoundEffectItemUiModel;", "onCleared", "clearPlayingState", "value", "", "playPreviewWakeupSound", "selectedSoundId", "resolveWakeupSoundOption", "Lcom/obric/assistant/ObricWakeupSoundOption;", "options", "", "defaultSoundId", "playPreviewRawWakeupSound", "option", "playPreviewRawPoolWakeupSound", "playResolvedPreviewRaw", "rawResId", "", "optionId", "audio", "resolveWakeupRawResId", "(Ljava/lang/String;)Ljava/lang/Integer;", "buildRows", "Lcom/obric/assistant/settings/wakeupsound/WakeupSoundEffectRowUiModel;", "selectedValue", "playingValue", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricWakeupSoundEffectViewModel extends ViewModel {
    public static final a Companion = null;
    private static final long PLAYING_STATE_DURATION_MS = 1200;
    private static final String RAW_AUDIO_PREFIX = "raw:";
    private static final String TAG = "ObricWakeupSoundEffectViewModel";
    private final z0<d> _uiState;
    private Job playingStateJob;
    private final i1<d> uiState;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.settings.wakeupsound.ObricWakeupSoundEffectViewModel$onWakeupSoundEffectSelected$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.wakeupsound.ObricWakeupSoundEffectViewModel$onWakeupSoundEffectSelected$1", f = "ObricWakeupSoundEffectViewModel.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ g $item;
        int label;
        final /* synthetic */ ObricWakeupSoundEffectViewModel this$0;

        public AnonymousClass1(ObricWakeupSoundEffectViewModel r1, g r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$item = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$item, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            ObricWakeupSoundEffectViewModel.access$clearPlayingState(this.this$0, this.$item.a);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            this.label = 1;
            if (DelayKt.delay(ObricWakeupSoundEffectViewModel.PLAYING_STATE_DURATION_MS, this) != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public void onCleared() {
        Job r0 = this.playingStateJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        super.onCleared();
    }

    public final void refresh() {
        String r0 = ((d) this._uiState.getValue()).c;
        z0<d> r1 = this._uiState;
        r1.setValue(d.a((d) r1.getValue(), buildRows(e.a(), r0), null, 5));
    }

    public ObricWakeupSoundEffectViewModel() {
        StateFlowImpl r0 = j1.a(new d(FlowRuntime.a().getApplication().getString(2131912594), buildRows$default(this, e.a(), null, 2, null), null));
        this._uiState = r0;
        this.uiState = kotlinx.coroutines.flow.e.b(r0);
    }

    public final i1<d> getUiState() {
        return this.uiState;
    }

    private final void clearPlayingState(@WakeupSoundEffectSettings String r5) {
        if (Intrinsics.areEqual(((d) this._uiState.getValue()).c, r5) == true) goto L5;
        return;
    L5:
        z0<d> r6 = this._uiState;
        r6.setValue(d.a((d) r6.getValue(), buildRows(e.a(), null), null, 1));
    }

    private final void playPreviewRawPoolWakeupSound(ObricWakeupSoundOption r7) {
        if (Intrinsics.areEqual(r7.getResourceSource(), "raw_builtin") == true) goto L6;
        FLogger.a.w(TAG, "playPreviewRawPoolWakeupSound unsupported resourceSource=" + r7.getResourceSource() + ", id=" + r7.getId());
        SoundEffectHelper.INSTANCE.playActivate();
        return;
    L6:
        List r0 = r7.getAudioPool();
        if (r0 == null) goto L17;
        List r1 = CollectionsKt.filterNotNull(r0);
        if (r1 == null) goto L17;
        ArrayList r3 = new ArrayList();
        Iterator r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L16;
        Object r4 = r2.next();
        if ((!StringsKt.isBlank((String) r4)) == false) goto L12;
        r3.add(r4);
        goto L12
    L16:
        String r5 = (String) CollectionsKt.randomOrNull(r3, Random.Default);
    L18:
        if (r5 != null) goto L21;
        FLogger.a.w(TAG, "playPreviewRawPoolWakeupSound empty audioPool, id=" + r7.getId());
        SoundEffectHelper.INSTANCE.playActivate();
        return;
    L21:
        Integer r6 = resolveWakeupRawResId(r5);
        if (r6 != null) goto L25;
        FLogger.a.w(TAG, "playPreviewRawPoolWakeupSound unsupported audio=" + r5 + ", id=" + r7.getId());
        SoundEffectHelper.INSTANCE.playActivate();
        return;
    L25:
        int r8 = r6.intValue();
        String r9 = r7.getId();
        if (r9 != null) goto L28;
        r9 = "";
    L28:
        playResolvedPreviewRaw(r8, r9, r5);
        return;
    L17:
        r5 = null;
        goto L18
    }

    private final void playPreviewRawWakeupSound(ObricWakeupSoundOption r5) {
        String r0 = r5.getAudio();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        Integer r2 = resolveWakeupRawResId(r0);
        if (r2 == null) goto L13;
        int r3 = r2.intValue();
        String r6 = r5.getId();
        if (r6 == null) goto L11;
        r1 = r6;
    L11:
        playResolvedPreviewRaw(r3, r1, r0);
        return;
    L13:
        FLogger.a.w(TAG, "playPreviewRawWakeupSound unsupported audio=" + r0 + ", id=" + r5.getId());
        SoundEffectHelper.INSTANCE.playActivate();
    }

    private final void playPreviewWakeupSound(@WakeupSoundEffectSettings String r5) {
        ObricWakeupSoundConfig r0 = t1.a.x1();
        ObricWakeupSoundOption r1 = resolveWakeupSoundOption(r5, r0.getOptions(), r0.getDefaultSoundId());
        if (r1 != null) goto L6;
        FLogger.a.w(TAG, "playPreviewWakeupSound fallback, option not found, selectedSoundId=" + r5);
        SoundEffectHelper.INSTANCE.playActivate();
        return;
    L6:
        String r6 = r1.getType();
        if (Intrinsics.areEqual(r6, "raw") == false) goto L10;
        playPreviewRawWakeupSound(r1);
        return;
    L10:
        if (Intrinsics.areEqual(r6, "raw_pool") == false) goto L12;
        playPreviewRawPoolWakeupSound(r1);
        return;
    L12:
        FLogger.a.w(TAG, "playPreviewWakeupSound fallback, unknown type=" + r1.getType() + ", id=" + r1.getId());
        SoundEffectHelper.INSTANCE.playActivate();
    }

    private final Integer resolveWakeupRawResId(String r6) {
        String r1 = StringsKt.removePrefix(r6, RAW_AUDIO_PREFIX);
        if (StringsKt.startsWith$default(r6, RAW_AUDIO_PREFIX, false, 2, null) == true) goto L6;
        r1 = null;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        int r7 = r1.hashCode();
        if (r7 == (-1621433828)) goto L47;
        if (r7 == (-612322121)) goto L43;
        switch(r7) {
            case -935579990: goto L39;
            case -935579989: goto L35;
            case -935579988: goto L31;
            case -935579987: goto L27;
            case -935579986: goto L23;
            case -935579985: goto L19;
            case -935579984: goto L15;
            default: goto L59;
        };
    L59:
        return null;
    L15:
        if (r1.equals("sound_effect_doubao_peach_07") == true) goto L51;
        return null;
    L51:
        return 2131820654;
    L19:
        if (r1.equals("sound_effect_doubao_peach_06") == true) goto L52;
        return null;
    L52:
        return 2131820653;
    L23:
        if (r1.equals("sound_effect_doubao_peach_05") == true) goto L53;
        return null;
    L53:
        return 2131820652;
    L27:
        if (r1.equals("sound_effect_doubao_peach_04") == true) goto L54;
        return null;
    L54:
        return 2131820651;
    L31:
        if (r1.equals("sound_effect_doubao_peach_03") == true) goto L55;
        return null;
    L55:
        return 2131820650;
    L35:
        if (r1.equals("sound_effect_doubao_peach_02") == true) goto L56;
        return null;
    L56:
        return 2131820649;
    L39:
        if (r1.equals("sound_effect_doubao_peach_01") == true) goto L57;
        return null;
    L57:
        return 2131820648;
    L43:
        if (r1.equals("sound_effect_assistant_wake_up") == true) goto L58;
        return null;
    L58:
        return 2131820645;
    L47:
        if (r1.equals("sound_effect_assistant_listening") == true) goto L50;
        return null;
    L50:
        return 2131820641;
    }

    public final void onWakeupSoundEffectSelected(g r13) {
        Intrinsics.checkNotNullParameter(r13, "item");
        t1.a.t1(r13.a);
        playPreviewWakeupSound(r13.a);
        Job r0 = this.playingStateJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        z0<d> r1 = this._uiState;
        d r3 = (d) r1.getValue();
        String r4 = r13.a;
        r1.setValue(d.a(r3, buildRows(r4, r4), r13.a, 1));
        this.playingStateJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r13, null), 3, null);
    }

    public static final /* synthetic */ void access$clearPlayingState(ObricWakeupSoundEffectViewModel r0, String r1) {
        r0.clearPlayingState(r1);
    }

    private final List<h> buildRows(@WakeupSoundEffectSettings String r11, @WakeupSoundEffectSettings String r12) {
        Application r0 = FlowRuntime.a().getApplication();
        return CollectionsKt.listOf(new h.a[]{new h.a(new g("classic", r0.getString(2131912595), Intrinsics.areEqual(r11, "classic"), Intrinsics.areEqual(r12, "classic"), 1)), new h.a(new g("smart", r0.getString(2131912596), Intrinsics.areEqual(r11, "smart"), Intrinsics.areEqual(r12, "smart"), 2)), new h.a(new g("doubao_same_voice", r0.getString(2131912597), Intrinsics.areEqual(r11, "doubao_same_voice"), Intrinsics.areEqual(r12, "doubao_same_voice"), 3))});
    }

    private final void playResolvedPreviewRaw(int r7, String r8, String r9) {
        SoundEffectHelper r0 = SoundEffectHelper.INSTANCE;
        if (r0.playWakeupRaw(r7) == true) goto L5;
        FLogger.a.w(TAG, "playResolvedPreviewRaw failed, fallback playActivate, id=" + r8 + ", audio=" + r9);
        r0.playActivate();
    L5:
        FLogger.a.i(TAG, "playResolvedPreviewRaw, id=" + r8 + ", audio=" + r9 + ", rawResId=" + r7);
    }

    private final ObricWakeupSoundOption resolveWakeupSoundOption(String r5, List<ObricWakeupSoundOption> r6, String r7) {
        Object r0 = null;
        if (r6 == null) goto L5;
        List r8 = CollectionsKt.filterNotNull(r6);
    L6:
        if (r8 != null) goto L9;
        r8 = CollectionsKt.emptyList();
    L9:
        if (r8.isEmpty() == false) goto L11;
        return null;
    L11:
        List r9 = r8;
        Iterator r1 = r9.iterator();
    L13:
        if (r1.hasNext() == false) goto L17;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((ObricWakeupSoundOption) r2).getId(), r5) == false) goto L13;
    L18:
        ObricWakeupSoundOption r3 = (ObricWakeupSoundOption) r2;
        if (r3 != null) goto L34;
        Iterator r10 = r9.iterator();
    L22:
        if (r10.hasNext() == false) goto L27;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((ObricWakeupSoundOption) r11).getId(), r7) == false) goto L22;
        r0 = r11;
    L27:
        return (ObricWakeupSoundOption) r0;
    L34:
        return r3;
    L17:
        r2 = null;
        goto L18
    L5:
        r8 = null;
        goto L6
    }

    public static /* synthetic */ List buildRows$default(ObricWakeupSoundEffectViewModel r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.buildRows(r1, r2);
    }
}
