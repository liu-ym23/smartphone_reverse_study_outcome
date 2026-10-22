package com.larus.setting.impl;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.kunminx.architecture.domain.message.MutableResult;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.SpeechLanguage;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020$J\u000e\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020$R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\rR!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017¨\u0006*"}, d2 = {"Lcom/larus/setting/impl/SpeechLanguageViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "launchInfo", "Lcom/larus/bmhome/auth/LaunchInfo;", "repo", "Lcom/larus/bmhome/chat/model/repo/ISettingRepoService;", "speechLanguageList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/bmhome/auth/SpeechLanguage;", "getSpeechLanguageList", "()Landroidx/lifecycle/MutableLiveData;", "speechLanguageList$delegate", "Lkotlin/Lazy;", "currentSpeechLanguage", "getCurrentSpeechLanguage", "currentSpeechLanguage$delegate", "voiceUpdate", "Lcom/kunminx/architecture/domain/message/MutableResult;", "Lcom/larus/bmhome/bot/bean/VoiceUpdateResult;", "getVoiceUpdate", "()Lcom/kunminx/architecture/domain/message/MutableResult;", "voiceUpdate$delegate", "launchSpeechLanguageList", "", "updateCurrentSpeechLanguage", "idx", "", "saveCurrentSpeechLanguage", "updateTtsVoice", "Lkotlinx/coroutines/Job;", "oldBotInfo", "Lcom/larus/im/bean/bot/BotModel;", "voiceId", "", "updateAsrLanguage", "asrLanguage", "updateLanguageCode", "language", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SpeechLanguageViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "SpeechLanguageViewModel";
    private final Lazy currentSpeechLanguage$delegate;
    private final LaunchInfo launchInfo;
    private final ISettingRepoService repo;
    private final Lazy speechLanguageList$delegate;
    private final Lazy voiceUpdate$delegate;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SpeechLanguageViewModel$updateAsrLanguage$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SpeechLanguageViewModel$updateAsrLanguage$1", f = "SpeechLanguageViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $asrLanguage;
        int label;
        final /* synthetic */ SpeechLanguageViewModel this$0;

        public AnonymousClass1(SpeechLanguageViewModel r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$asrLanguage = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$asrLanguage, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            SpeechLanguageViewModel.access$getRepo$p(this.this$0).C0(this.$asrLanguage);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SpeechLanguageViewModel$updateLanguageCode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SpeechLanguageViewModel$updateLanguageCode$1", f = "SpeechLanguageViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $language;
        int label;
        final /* synthetic */ SpeechLanguageViewModel this$0;

        public C01401(SpeechLanguageViewModel r1, String r2, Continuation<? super C01401> r3) {
            this.this$0 = r1;
            this.$language = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01401(this.this$0, this.$language, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            SpeechLanguageViewModel.access$getRepo$p(this.this$0).u(this.$language);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SpeechLanguageViewModel$updateTtsVoice$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SpeechLanguageViewModel$updateTtsVoice$1", f = "SpeechLanguageViewModel.kt", i = {0, 0, 0}, l = {92}, m = "invokeSuspend", n = {"valid", "speakerVoice", "repo"}, s = {"L$0", "L$5", "L$6"})
    public static final class C01411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BotModel $oldBotInfo;
        final /* synthetic */ String $voiceId;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        final /* synthetic */ SpeechLanguageViewModel this$0;

        public C01411(SpeechLanguageViewModel r1, String r2, BotModel r3, Continuation<? super C01411> r4) {
            this.this$0 = r1;
            this.$voiceId = r2;
            this.$oldBotInfo = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01411(this.this$0, this.$voiceId, this.$oldBotInfo, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00b6 -> B:31:0x00f3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00e0 -> B:30:0x00ea). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r42) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            MutableResult<ub8.h> r3 = (MutableResult) this.L$7;
            IBotRepoService r5 = (IBotRepoService) this.L$6;
            SpeakerVoice r6 = (SpeakerVoice) this.L$5;
            Iterator r7 = (Iterator) this.L$4;
            BotModel r8 = (BotModel) this.L$3;
            SpeechLanguageViewModel r9 = (SpeechLanguageViewModel) this.L$2;
            String r10 = (String) this.L$1;
            Ref.BooleanRef r11 = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(r42);
            IBotRepoService r12 = r5;
            Ref.BooleanRef r13 = r11;
            Object r14 = r42;
            String r15 = r10;
            SpeechLanguageViewModel r16 = r9;
            BotModel r17 = r8;
            Iterator r18 = r7;
            C01411 r19 = this;
        L30:
            r3.postValue(r14);
            C01411 r4 = r19;
            Iterator r20 = r18;
            BotModel r21 = r17;
            SpeechLanguageViewModel r22 = r16;
            String r23 = r15;
            Ref.BooleanRef r110 = r13;
        L31:
            r12.h1();
        L20:
            if (r20.hasNext() == false) goto L32;
            SpeakerVoice r24 = (SpeakerVoice) r20.next();
            if (Intrinsics.areEqual(r24.getId(), r23) == false) goto L20;
            r110.element = true;
            r12 = RepoDispatcherDelegate.b.b();
            if (AppHost.a.isOversea() == false) goto L26;
            r22.getVoiceUpdate().postValue(new ub8.h(true, r24, null, null));
            goto L31
        L26:
            MutableResult<ub8.h> r111 = r22.getVoiceUpdate();
            r4.L$0 = r110;
            r4.L$1 = r23;
            r4.L$2 = r22;
            r4.L$3 = r21;
            r4.L$4 = r20;
            r4.L$5 = r24;
            r4.L$6 = r12;
            r4.L$7 = r111;
            r4.label = 1;
            r14 = r12.t1(r21, r24, r4);
            if (r14 != r1) goto L29;
            return r1;
        L29:
            Iterator r40 = r20;
            r19 = r4;
            r3 = r111;
            r13 = r110;
            r15 = r23;
            r16 = r22;
            r17 = r21;
            r18 = r40;
            goto L30
        L32:
            C01411 r25 = r4;
            Ref.BooleanRef r26 = r110;
        L35:
            if (r26.element == true) goto L38;
            FLogger.a.i(SpeechLanguageViewModel.TAG, "updateTtsVoice: called");
            r25.this$0.getVoiceUpdate().postValue(new ub8.h(false, new SpeakerVoice(null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, false, 0, 0, null, null, false, null, 0, null, 0, 0, 0.0f, 0.0f, null, false, null, null, Integer.MAX_VALUE, null), null, null));
        L38:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r42);
            r26 = new Ref.BooleanRef();
            if (FeatureKitDelegate.b.w0().b() == false) goto L13;
            AudioUserConfig r27 = (AudioUserConfig) AudioServiceDelegate.a.p().getValue();
            if (r27 == null) goto L16;
            List r28 = r27.getNewVoiceList();
        L17:
            if (r28 == null) goto L33;
            String r29 = this.$voiceId;
            SpeechLanguageViewModel r30 = this.this$0;
            BotModel r31 = this.$oldBotInfo;
            r110 = r26;
            r23 = r29;
            r4 = this;
            r20 = r28.iterator();
            r22 = r30;
            r21 = r31;
            goto L20
        L33:
            r25 = this;
        L16:
            r28 = null;
            goto L17
        L13:
            LaunchInfo r32 = SpeechLanguageViewModel.access$getLaunchInfo$p(this.this$0);
            if (r32 == null) goto L16;
            r28 = r32.T0();
            goto L17
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ MutableLiveData Mo() {
        return currentSpeechLanguage_delegate$lambda$1();
    }

    public static /* synthetic */ MutableLiveData No() {
        return speechLanguageList_delegate$lambda$0();
    }

    public static /* synthetic */ MutableResult yo() {
        return voiceUpdate_delegate$lambda$2();
    }

    private static final MutableLiveData currentSpeechLanguage_delegate$lambda$1() {
        return new MutableLiveData();
    }

    private static final MutableLiveData speechLanguageList_delegate$lambda$0() {
        return new MutableLiveData();
    }

    private static final MutableResult voiceUpdate_delegate$lambda$2() {
        return new MutableResult();
    }

    public final MutableLiveData<SpeechLanguage> getCurrentSpeechLanguage() {
        return (MutableLiveData) this.currentSpeechLanguage$delegate.getValue();
    }

    public final MutableLiveData<List<SpeechLanguage>> getSpeechLanguageList() {
        return (MutableLiveData) this.speechLanguageList$delegate.getValue();
    }

    public final MutableResult<ub8.h> getVoiceUpdate() {
        return (MutableResult) this.voiceUpdate$delegate.getValue();
    }

    public final void launchSpeechLanguageList() {
        LaunchInfo r0 = this.launchInfo;
        if (r0 == null) goto L5;
        List r1 = r0.g1();
    L6:
        List r2 = r1;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L16;
        getSpeechLanguageList().postValue(r1);
        return;
    L16:
        return;
    L9:
        if (r2.isEmpty() == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public SpeechLanguageViewModel() {
        com.larus.bmhome.chat.api.e0 r0 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L5;
        LaunchInfo r1 = r0.a;
    L6:
        this.launchInfo = r1;
        this.repo = RepoDispatcherDelegate.b.c();
        this.speechLanguageList$delegate = LazyKt.lazy(new q3());
        this.currentSpeechLanguage$delegate = LazyKt.lazy(new r3());
        this.voiceUpdate$delegate = LazyKt.lazy(new s3());
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final /* synthetic */ LaunchInfo access$getLaunchInfo$p(SpeechLanguageViewModel r0) {
        return r0.launchInfo;
    }

    public static final /* synthetic */ ISettingRepoService access$getRepo$p(SpeechLanguageViewModel r0) {
        return r0.repo;
    }

    public final void saveCurrentSpeechLanguage(int r2) {
        this.repo.r(r2);
    }

    public final Job updateAsrLanguage(String r8) {
        Intrinsics.checkNotNullParameter(r8, "asrLanguage");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r8, null), 3, null);
    }

    public final void updateCurrentSpeechLanguage(int r4) {
        List r0 = (List) getSpeechLanguageList().getValue();
        if (r0 == null) goto L10;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        SpeechLanguage r2 = (SpeechLanguage) r1.next();
        if (r4 != r2.b()) goto L6;
        getCurrentSpeechLanguage().postValue(r2);
        goto L6
    L16:
        return;
    }

    public final Job updateLanguageCode(String r8) {
        Intrinsics.checkNotNullParameter(r8, "language");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01401(this, r8, null), 3, null);
    }

    public final Job updateTtsVoice(BotModel r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "oldBotInfo");
        Intrinsics.checkNotNullParameter(r9, "voiceId");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01411(this, r9, r8, null), 3, null);
    }
}
