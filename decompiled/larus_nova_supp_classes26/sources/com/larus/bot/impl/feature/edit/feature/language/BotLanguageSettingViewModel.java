package com.larus.bot.impl.feature.edit.feature.language;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bot.impl.repository.UgcBotRepo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010 J\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u000fJ\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR'\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0015\u0010\u0011R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0019\u0010\u0011R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001c\u0010\u0011¨\u0006&"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/language/BotLanguageSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "repo", "Lcom/larus/bot/impl/repository/UgcBotRepo;", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "getBotInfo", "()Lcom/larus/im/bean/bot/BotModel;", "setBotInfo", "(Lcom/larus/im/bean/bot/BotModel;)V", "languageList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/bmhome/bot/bean/BotLanguage;", "getLanguageList", "()Landroidx/lifecycle/MutableLiveData;", "languageList$delegate", "Lkotlin/Lazy;", "currentLanguage", "getCurrentLanguage", "currentLanguage$delegate", "languageUpdate", "Lcom/larus/bmhome/bot/bean/LanguageUpdateResult;", "getLanguageUpdate", "languageUpdate$delegate", "updatedBotInfo", "getUpdatedBotInfo", "updatedBotInfo$delegate", "getBotLanguageList", "", "()Lkotlin/Unit;", "updateLanguage", "language", "updateBotInfo", "botLanguage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotLanguageSettingViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "BotLanguageSettingViewModel";
    private BotModel botInfo;
    private final Lazy currentLanguage$delegate;
    private final Lazy languageList$delegate;
    private final Lazy languageUpdate$delegate;
    private final UgcBotRepo repo;
    private final Lazy updatedBotInfo$delegate;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.language.BotLanguageSettingViewModel$updateLanguage$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.language.BotLanguageSettingViewModel$updateLanguage$1", f = "BotLanguageSettingViewModel.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BotLanguage $language;
        Object L$0;
        int label;
        final /* synthetic */ BotLanguageSettingViewModel this$0;

        public AnonymousClass1(BotLanguageSettingViewModel r1, BotLanguage r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$language = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$language, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            BotLanguageSettingViewModel r2 = (BotLanguageSettingViewModel) this.L$0;
            ResultKt.throwOnFailure(r8);
        L14:
            MutableLiveData<ub8.f> r3 = r2.getLanguageUpdate();
            r3.setValue((ub8.f) r8);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            BotModel r9 = this.this$0.getBotInfo();
            if (r9 == null) goto L16;
            BotLanguageSettingViewModel r4 = this.this$0;
            BotLanguage r5 = this.$language;
            CoroutineDispatcher r6 = Dispatchers.getIO();
            BotLanguageSettingViewModel$updateLanguage$1$1$updateResult$1 r7 = new BotLanguageSettingViewModel$updateLanguage$1$1$updateResult$1(r4, r9, r5, null);
            this.L$0 = r4;
            this.label = 1;
            r8 = BuildersKt.withContext(r6, r7, this);
            if (r8 != r0) goto L13;
            return r0;
        L13:
            r2 = r4;
            goto L14
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ MutableLiveData Mo() {
        return updatedBotInfo_delegate$lambda$3();
    }

    public static /* synthetic */ MutableLiveData No() {
        return languageUpdate_delegate$lambda$2();
    }

    public static /* synthetic */ MutableLiveData Oo() {
        return currentLanguage_delegate$lambda$1();
    }

    public static /* synthetic */ MutableLiveData yo() {
        return languageList_delegate$lambda$0();
    }

    private static final MutableLiveData currentLanguage_delegate$lambda$1() {
        return new MutableLiveData();
    }

    private static final MutableLiveData languageList_delegate$lambda$0() {
        return new MutableLiveData();
    }

    private static final MutableLiveData languageUpdate_delegate$lambda$2() {
        return new MutableLiveData();
    }

    private static final MutableLiveData updatedBotInfo_delegate$lambda$3() {
        return new MutableLiveData();
    }

    public final Unit getBotLanguageList() {
        e0 r0 = (e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L5;
        LaunchInfo r1 = r0.a;
    L6:
        BotModel r2 = this.botInfo;
        if (r2 == null) goto L37;
        if (r1 == null) goto L15;
        List r3 = r1.j();
        if (r3 == null) goto L15;
        List r4 = r3;
        List r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r6 = r4.iterator();
    L13:
        if (r6.hasNext() == false) goto L16;
        com.larus.im.bean.bot.BotLanguage r7 = (com.larus.im.bean.bot.BotLanguage) r6.next();
        r5.add(new BotLanguage(r7.getLanguageCode(), r7.getLanguage(), r7.getLanguageLocal()));
    L16:
        if (r5 != null) goto L18;
        r5 = CollectionsKt.emptyList();
    L18:
        getLanguageList().setValue(r5);
        Iterator r8 = r5.iterator();
    L20:
        if (r8.hasNext() == false) goto L28;
        Object r9 = r8.next();
        String r10 = ((BotLanguage) r9).c();
        SpeakerVoice r11 = r2.getVoiceType();
        if (r11 == null) goto L24;
        String r12 = r11.getLanguageCode();
    L26:
        if (Intrinsics.areEqual(r10, r12) == false) goto L20;
    L29:
        BotLanguage r13 = (BotLanguage) r9;
        if (r13 == null) goto L38;
        getCurrentLanguage().setValue(r13);
        return Unit.INSTANCE;
    L38:
        return null;
    L24:
        r12 = null;
        goto L26
    L28:
        r9 = null;
    L15:
        r5 = null;
        goto L16
    L37:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    public final MutableLiveData<BotLanguage> getCurrentLanguage() {
        return (MutableLiveData) this.currentLanguage$delegate.getValue();
    }

    public final MutableLiveData<List<BotLanguage>> getLanguageList() {
        return (MutableLiveData) this.languageList$delegate.getValue();
    }

    public final MutableLiveData<ub8.f> getLanguageUpdate() {
        return (MutableLiveData) this.languageUpdate$delegate.getValue();
    }

    public final MutableLiveData<BotModel> getUpdatedBotInfo() {
        return (MutableLiveData) this.updatedBotInfo$delegate.getValue();
    }

    public BotLanguageSettingViewModel() {
        Lazy<UgcBotRepo> r0 = UgcBotRepo.d;
        this.repo = UgcBotRepo.a.a();
        this.languageList$delegate = LazyKt.lazy(new h());
        this.currentLanguage$delegate = LazyKt.lazy(new i());
        this.languageUpdate$delegate = LazyKt.lazy(new j());
        this.updatedBotInfo$delegate = LazyKt.lazy(new k());
    }

    public final BotModel getBotInfo() {
        return this.botInfo;
    }

    public static final /* synthetic */ UgcBotRepo access$getRepo$p(BotLanguageSettingViewModel r0) {
        return r0.repo;
    }

    public final void setBotInfo(BotModel r1) {
        this.botInfo = r1;
    }

    public final void updateLanguage(BotLanguage r8) {
        Intrinsics.checkNotNullParameter(r8, "language");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r8, null), 3, null);
    }

    public final void updateBotInfo(BotLanguage r2, BotModel r3) {
        Intrinsics.checkNotNullParameter(r2, "botLanguage");
        if (r3 != null) goto L5;
        return;
    L5:
        getCurrentLanguage().setValue(r2);
        getUpdatedBotInfo().setValue(r3);
    }
}
