package com.larus.bot.impl.feature.edit.feature.avatar.avatarchoose;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.bean.BotGenAvatarByPromptResult;
import com.larus.bot.impl.repository.UgcBotRepo;
import com.larus.network.http.w;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\tR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R'\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/avatar/avatarchoose/BotAvatarChooserViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "repo", "Lcom/larus/bot/impl/repository/UgcBotRepo;", "avatarListLoadingState", "", "avatarTopLeftLoadFinish", "avatarTopRightLoadFinish", "avatarBottomLeftLoadFinish", "avatarBottomRightLoadFinish", "genBotAvatarList", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/network/http/Async;", "Lcom/larus/bot/impl/bean/BotGenAvatarByPromptResult;", "getGenBotAvatarList", "()Landroidx/lifecycle/MutableLiveData;", "genBotAvatarList$delegate", "Lkotlin/Lazy;", "_avatarImgLoadingState", "avatarImgLoadingState", "Landroidx/lifecycle/LiveData;", "getAvatarImgLoadingState", "()Landroidx/lifecycle/LiveData;", "requireBotAvatarList", "Lkotlinx/coroutines/Job;", "prompt", "", "updateAvatarListLoadingState", "", "index", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotAvatarChooserViewModel extends AndroidViewModel {
    private static final int AVATAR_NUM = 4;
    public static final a Companion = null;
    private static final String TAG = "BotAvatarChooserViewModel";
    private final MutableLiveData<Integer> _avatarImgLoadingState;
    private int avatarBottomLeftLoadFinish;
    private int avatarBottomRightLoadFinish;
    private final LiveData<Integer> avatarImgLoadingState;
    private int avatarListLoadingState;
    private int avatarTopLeftLoadFinish;
    private int avatarTopRightLoadFinish;
    private final Lazy genBotAvatarList$delegate;
    private final UgcBotRepo repo;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.avatar.avatarchoose.BotAvatarChooserViewModel$requireBotAvatarList$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.avatar.avatarchoose.BotAvatarChooserViewModel$requireBotAvatarList$1", f = "BotAvatarChooserViewModel.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $prompt;
        int label;
        final /* synthetic */ BotAvatarChooserViewModel this$0;

        public AnonymousClass1(BotAvatarChooserViewModel r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$prompt = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$prompt, r4);
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
            boolean r2 = false;
            ArrayList<BotAvatarIconData> r3 = null;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L11:
            y r9 = (com.larus.network.http.a) r8;
            if ((r9 instanceof y) == false) goto L24;
            BotGenAvatarByPromptResult r4 = (BotGenAvatarByPromptResult) ((com.larus.network.http.a) r9).b;
            if (r4 == null) goto L16;
            r3 = r4.getAvatarList();
        L16:
            if (r3 != null) goto L18;
        L19:
            r2 = true;
        L20:
            if (r2 == true) goto L22;
            qu8.b.d("gen_icon_by_prompt", 0);
        L26:
            this.this$0.getGenBotAvatarList().postValue(r9);
            return Unit.INSTANCE;
        L22:
            qu8.b.d("gen_icon_by_prompt", 10011);
            goto L26
        L18:
            if (r3.isEmpty() == false) goto L20;
        L24:
            if ((r9 instanceof com.larus.network.http.f) == false) goto L26;
            qu8.b.d("gen_icon_by_prompt", ((com.larus.network.http.f) r9).d.getCode());
            goto L26
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            this.this$0.getGenBotAvatarList().postValue(new w(null));
            qu8.b.e("gen_icon_by_prompt", "bot_create/avatar_setting", false);
            UgcBotRepo r10 = BotAvatarChooserViewModel.access$getRepo$p(this.this$0);
            UgcBotRepo.b r5 = new UgcBotRepo.b(this.$prompt);
            this.label = 1;
            r10.getClass();
            r8 = UgcBotRepo.i(r5, this);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ MutableLiveData yo() {
        return genBotAvatarList_delegate$lambda$0();
    }

    private static final MutableLiveData genBotAvatarList_delegate$lambda$0() {
        return new MutableLiveData();
    }

    public final MutableLiveData<com.larus.network.http.a<BotGenAvatarByPromptResult>> getGenBotAvatarList() {
        return (MutableLiveData) this.genBotAvatarList$delegate.getValue();
    }

    public final LiveData<Integer> getAvatarImgLoadingState() {
        return this.avatarImgLoadingState;
    }

    public BotAvatarChooserViewModel(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        super(r2);
        Lazy<UgcBotRepo> r3 = UgcBotRepo.d;
        this.repo = UgcBotRepo.a.a();
        this.avatarTopLeftLoadFinish = 1;
        this.avatarTopRightLoadFinish = 2;
        this.avatarBottomLeftLoadFinish = 4;
        this.avatarBottomRightLoadFinish = 8;
        this.genBotAvatarList$delegate = LazyKt.lazy(new q());
        MutableLiveData<Integer> r4 = new MutableLiveData(0);
        this._avatarImgLoadingState = r4;
        this.avatarImgLoadingState = r4;
    }

    public static final /* synthetic */ UgcBotRepo access$getRepo$p(BotAvatarChooserViewModel r0) {
        return r0.repo;
    }

    public final Job requireBotAvatarList(String r8) {
        Intrinsics.checkNotNullParameter(r8, "prompt");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r8, null), 3, null);
    }

    public final void updateAvatarListLoadingState(int r4) {
        FLogger r0 = FLogger.a;
        r0.i(TAG, "updateAvatarListLoadingState, index=" + r4);
        if (r4 != 0) goto L5;
        this.avatarListLoadingState ^= this.avatarTopLeftLoadFinish;
    L15:
        r0.i(TAG, "updateAvatarListLoadingState, end avatarListLoadingState=" + this.avatarListLoadingState);
        this._avatarImgLoadingState.postValue(Integer.valueOf(this.avatarListLoadingState));
        return;
    L5:
        if (r4 != 1) goto L7;
        this.avatarListLoadingState ^= this.avatarTopRightLoadFinish;
        goto L15
    L7:
        if (r4 != 2) goto L9;
        this.avatarListLoadingState ^= this.avatarBottomLeftLoadFinish;
        goto L15
    L9:
        if (r4 != 3) goto L15;
        this.avatarListLoadingState ^= this.avatarBottomRightLoadFinish;
        goto L15
    }
}
