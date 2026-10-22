package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img;

import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.auth.BgImageConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.bean.BotGenBgImageResponse;
import com.larus.bot.impl.bean.GenBotImageRequest;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.AIGenBgImageRepository;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.w;
import com.larus.network.http.y;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0016J\u0012\u00108\u001a\u0002052\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0010\u0010;\u001a\u0002032\u0006\u0010<\u001a\u00020\rH\u0002J\u0010\u0010=\u001a\u0002052\u0006\u0010<\u001a\u00020\rH\u0002J\b\u0010>\u001a\u000205H\u0002J\u0017\u0010?\u001a\u0002052\b\u0010<\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010@J\u0010\u0010A\u001a\u0002052\u0006\u0010<\u001a\u00020\rH\u0002J\u0018\u0010B\u001a\u0002052\u0006\u0010<\u001a\u00020\r2\u0006\u0010C\u001a\u00020\rH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020)0+X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020/X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/text2img/AIGenBgImageViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/text2img/IAIGenBgImageViewModel;", "<init>", "()V", "prompt", "", "promptEn", "botName", "botDescription", "userBotGender", "userBotType", "bgCategoryType", "", "Ljava/lang/Integer;", "needUpdateBotInfo", "", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "bgImgOpen", "Ljava/lang/Boolean;", "repo", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/AIGenBgImageRepository;", "showBgImgCnt", "showBgImgMaxCnt", "isTowRow", "maxPageNum", "curPageIndex", "genSuccessPageIndexMap", "Ljava/util/concurrent/ConcurrentHashMap;", "curSelectedImg", "Lcom/larus/bot/impl/bean/BotAvatarIconData;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/text2img/AIGenBgImageUIState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "_uiEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/text2img/AIGenBgImageUIEvent;", "uiEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "botCreateTrace", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/BotCreateBgGenTrace;", "getBotCreateTrace", "()Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/BotCreateBgGenTrace;", "observeFinishPreAiGenBgProcessFlowJob", "Lkotlinx/coroutines/Job;", "dispatchUIAction", "", "uiAction", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/text2img/AIGenBgImageUIAction;", "init", "bundle", "Landroid/os/Bundle;", "genBgImageByPrompt", "pageIndex", "showLoadError", "onClickConfirm", "onClickRetry", "(Ljava/lang/Integer;)V", "onPageSelected", "onImageChosen", "selectedIndex", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIGenBgImageViewModel extends ViewModel implements d {
    public static final a Companion = null;
    private static final String TAG = "AIGenBgImageViewModel";
    private final MutableSharedFlow<b> _uiEvent;
    private final z0<c> _uiState;
    private Integer bgCategoryType;
    private Boolean bgImgOpen;
    private final com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.h botCreateTrace;
    private String botDescription;
    private BotModel botInfo;
    private String botName;
    private int curPageIndex;
    private BotAvatarIconData curSelectedImg;
    private final ConcurrentHashMap<Integer, Boolean> genSuccessPageIndexMap;
    private boolean isTowRow;
    private int maxPageNum;
    private boolean needUpdateBotInfo;
    private Job observeFinishPreAiGenBgProcessFlowJob;
    private String prompt;
    private String promptEn;
    private final AIGenBgImageRepository repo;
    private final int showBgImgCnt;
    private final int showBgImgMaxCnt;
    private final d1<b> uiEvent;
    private final i1<c> uiState;
    private String userBotGender;
    private String userBotType;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.AIGenBgImageViewModel$genBgImageByPrompt$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.AIGenBgImageViewModel$genBgImageByPrompt$1", f = "Text2BgImageViewModel.kt", i = {0}, l = {128, 164, 165, 166}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $pageIndex;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AIGenBgImageViewModel this$0;

        public AnonymousClass1(AIGenBgImageViewModel r1, int r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$pageIndex = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$pageIndex, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r30) {
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L14;
            if (r0 == 1) goto L13;
            if (r0 == 2) goto L12;
            if (r0 == 3) goto L11;
            if (r0 != 4) goto L10;
            ResultKt.throwOnFailure(r30);
        L72:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            AIGenBgImageViewModel r1 = (AIGenBgImageViewModel) this.L$0;
            ResultKt.throwOnFailure(r30);
        L67:
            MutableSharedFlow r2 = AIGenBgImageViewModel.access$get_uiEvent$p(r1);
            b.a r3 = b.a.a;
            this.L$0 = null;
            this.label = 4;
            if (r2.emit(r3, this) != r8) goto L72;
            return r8;
        L12:
            r1 = (AIGenBgImageViewModel) this.L$0;
            ResultKt.throwOnFailure(r30);
        L64:
            this.L$0 = r1;
            this.label = 3;
            if (DelayKt.delay(500, this) != r8) goto L67;
            return r8;
        L13:
            CoroutineScope r4 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r30);
            Object r5 = r30;
            boolean r9 = true;
        L21:
            com.larus.network.http.f r6 = (com.larus.network.http.a) r5;
            BotGenBgImageResponse r7 = (BotGenBgImageResponse) ((com.larus.network.http.a) r6).b;
            long r10 = 0;
            if (r7 == null) goto L43;
            AIGenBgImageViewModel r11 = this.this$0;
            int r12 = this.$pageIndex;
            qu8.b.d("gen_icon_by_prompt", 0);
            AIGenBgImageViewModel.access$setBgImgOpen$p(r11, r7.getBgImgOpen());
            AIGenBgImageViewModel.access$setBgCategoryType$p(r11, r7.getBgCategoryType());
            AIGenBgImageViewModel.access$getGenSuccessPageIndexMap$p(r11).put(Boxing.boxInt(r12), Boxing.boxBoolean(r9));
            ArrayList r13 = new ArrayList();
            Iterator<T> r14 = ((c) r11.getUiState().getValue()).c.iterator();
            int r15 = 0;
        L25:
            if (r14.hasNext() == false) goto L42;
            Object r16 = r14.next();
            int r17 = r15 + 1;
            if (r15 >= 0) goto L29;
            CollectionsKt.throwIndexOverflow();
        L29:
            Text2BgImageBindingViewHolder.a r18 = (Text2BgImageBindingViewHolder.a) r16;
            if (r15 != r12) goto L40;
            List<BotAvatarIconData> r19 = r7.getBgImgList();
            if (r19 == null) goto L38;
            List<BotAvatarIconData> r20 = r19;
            if (AIGenBgImageViewModel.access$isTowRow$p(r11) == false) goto L36;
            int r110 = 6;
        L37:
            List r21 = CollectionsKt.take(r20, r110);
        L39:
            ListProtector.add(r13, r12, new Text2BgImageBindingViewHolder.a(new y(r21, null, 14), AIGenBgImageViewModel.access$isTowRow$p(r11), r12, null));
        L41:
            r15 = r17;
            goto L25
        L36:
            r110 = 3;
            goto L37
        L38:
            r21 = null;
            goto L39
        L40:
            ListProtector.add(r13, r15, r18);
            goto L41
        L42:
            AIGenBgImageViewModel.access$get_uiState$p(r11).setValue(c.a((c) r11.getUiState().getValue(), false, r13, 3));
            goto L72
        L43:
            AIGenBgImageViewModel r22 = this.this$0;
            int r23 = this.$pageIndex;
            BizResponse.Companion.getClass();
            long[] r24 = BizResponse.access$getCODE_RISK_CONTROL$cp();
            boolean r25 = r6 instanceof com.larus.network.http.f;
            if (r25 == false) goto L46;
            com.larus.network.http.f r26 = r6;
        L47:
            if (r26 == null) goto L51;
            AsyncThrowable r27 = r26.d;
            if (r27 == null) goto L51;
            r10 = r27.getCode();
        L51:
            long r111 = -2;
            if (ArraysKt.contains(r24, r10) == false) goto L70;
            if (r25 == false) goto L55;
            com.larus.network.http.f r28 = r6;
        L56:
            if (r28 == null) goto L60;
            AsyncThrowable r29 = r28.d;
            if (r29 == null) goto L60;
            r111 = r29.getCode();
        L60:
            qu8.b.d("gen_icon_by_prompt", r111);
            MutableSharedFlow r31 = AIGenBgImageViewModel.access$get_uiEvent$p(r22);
            b.e r32 = new b.e(new TextRes.StringResId(2131897429));
            this.L$0 = r22;
            this.label = 2;
            if (r31.emit(r32, this) != r8) goto L63;
            return r8;
        L63:
            r1 = r22;
            goto L64
        L55:
            r28 = null;
            goto L56
        L70:
            qu8.b.d("gen_icon_by_prompt", -2);
            AIGenBgImageViewModel.access$showLoadError(r22, r23);
            goto L72
        L46:
            r26 = null;
            goto L47
        L14:
            ResultKt.throwOnFailure(r30);
            CoroutineScope r33 = (CoroutineScope) this.L$0;
            qu8.b.e("gen_icon_by_prompt", "bot_create/bg_setting/ai", false);
            AIGenBgImageViewModel.access$getGenSuccessPageIndexMap$p(this.this$0).put(Boxing.boxInt(this.$pageIndex), Boxing.boxBoolean(false));
            AIGenBgImageRepository r34 = AIGenBgImageViewModel.access$getRepo$p(this.this$0);
            String r35 = AIGenBgImageViewModel.access$getPrompt$p(this.this$0);
            if (AIGenBgImageViewModel.access$isTowRow$p(this.this$0) == false) goto L17;
            int r36 = 6;
        L18:
            GenBotImageRequest r37 = new GenBotImageRequest(AIGenBgImageViewModel.access$getBotName$p(this.this$0), AIGenBgImageViewModel.access$getBotDescription$p(this.this$0), null, null, null, null, null, AIGenBgImageViewModel.access$getUserBotGender$p(this.this$0), AIGenBgImageViewModel.access$getUserBotType$p(this.this$0), null, 636, null);
            String r38 = this.this$0.getBotCreateTrace().c();
            this.L$0 = r33;
            this.label = 1;
            r9 = true;
            r5 = r34.b(r35, r36, r37, "text_to_image", r38, this);
            if (r5 != r8) goto L21;
            return r8;
        L17:
            r36 = 3;
            goto L18
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.AIGenBgImageViewModel$onClickConfirm$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.AIGenBgImageViewModel$onClickConfirm$1", f = "Text2BgImageViewModel.kt", i = {}, l = {190}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ AIGenBgImageViewModel this$0;

        public C02101(AIGenBgImageViewModel r1, Continuation<? super C02101> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02101(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r29) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            AIGenBgImageViewModel r3 = (AIGenBgImageViewModel) this.L$0;
            ResultKt.throwOnFailure(r29);
            int r4 = 1;
        L14:
            Job r5 = AIGenBgImageViewModel.access$getObserveFinishPreAiGenBgProcessFlowJob$p(r3);
            if (r5 == null) goto L17;
            Job.DefaultImpls.cancel$default(r5, null, r4, null);
        L17:
            AIGenBgImageViewModel.access$setObserveFinishPreAiGenBgProcessFlowJob$p(r3, BuildersKt.launch$default(ViewModelKt.getViewModelScope(r3), null, null, new AIGenBgImageViewModel$onClickConfirm$1$1$1(r3, null), 3, null));
        L19:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r29);
            BotAvatarIconData r6 = AIGenBgImageViewModel.access$getCurSelectedImg$p(this.this$0);
            if (r6 == null) goto L19;
            AIGenBgImageViewModel r7 = this.this$0;
            String r8 = r6.getIconUri();
            String r9 = r6.getIconUrl();
            String r19 = r6.getPrompt();
            MutableSharedFlow r15 = AIGenBgImageViewModel.access$get_uiEvent$p(r7);
            b.C0063b r14 = new b.C0063b(r6, new BgImage(r8, r9, null, new BgImageInfo(AIGenBgImageViewModel.access$getPrompt$p(r7), null, Boxing.boxBoolean(true), null, AIGenBgImageViewModel.access$getBgImgOpen$p(r7), null, null, null, null, AIGenBgImageViewModel.access$getBgCategoryType$p(r7), r19, 488, null)), AIGenBgImageViewModel.access$getBotName$p(r7), AIGenBgImageViewModel.access$getBotDescription$p(r7), AIGenBgImageViewModel.access$getUserBotGender$p(r7), AIGenBgImageViewModel.access$getUserBotType$p(r7), Boxing.boxBoolean(AIGenBgImageViewModel.access$getNeedUpdateBotInfo$p(r7)), AIGenBgImageViewModel.access$getBotInfo$p(r7), r7.getBotCreateTrace().c(), r7.getBotCreateTrace().b(), r7.getBotCreateTrace().a.getBoolean("has_origin_avatar", false));
            this.L$0 = r7;
            r4 = 1;
            this.label = 1;
            if (r15.emit(r14, this) != r1) goto L13;
            return r1;
        L13:
            r3 = r7;
            goto L14
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.AIGenBgImageViewModel$onClickRetry$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.AIGenBgImageViewModel$onClickRetry$2", f = "Text2BgImageViewModel.kt", i = {}, l = {239}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AIGenBgImageViewModel this$0;

        public AnonymousClass2(AIGenBgImageViewModel r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            MutableSharedFlow r5 = AIGenBgImageViewModel.access$get_uiEvent$p(this.this$0);
            b.d r2 = new b.d();
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public AIGenBgImageViewModel() {
        this.prompt = "";
        this.promptEn = "";
        this.repo = new AIGenBgImageRepository();
        AuthModelDelegate r0 = AuthModelDelegate.b;
        LaunchInfo r1 = (LaunchInfo) r0.x().getValue();
        if (r1 == null) goto L9;
        BgImageConfig r2 = r1.h();
        if (r2 == null) goto L9;
        Integer r3 = r2.c();
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L10:
        this.showBgImgCnt = r4;
        LaunchInfo r5 = (LaunchInfo) r0.x().getValue();
        if (r5 == null) goto L17;
        BgImageConfig r6 = r5.h();
        if (r6 == null) goto L17;
        Integer r7 = r6.d();
        if (r7 == null) goto L17;
        int r8 = r7.intValue();
    L18:
        this.showBgImgMaxCnt = r8;
        if (r4 == 3) goto L21;
        boolean r9 = true;
    L22:
        this.isTowRow = r9;
        this.maxPageNum = RangesKt.coerceAtLeast(3, r8 / RangesKt.coerceAtLeast(1, r4));
        this.genSuccessPageIndexMap = new ConcurrentHashMap();
        int r10 = this.maxPageNum;
        ArrayList r11 = new ArrayList(r10);
        int r12 = 0;
    L24:
        if (r12 >= r10) goto L26;
        r11.add(new Text2BgImageBindingViewHolder.a(new w(CollectionsKt.emptyList()), this.isTowRow, r12, null));
        r12 = r12 + 1;
        goto L24
    L26:
        StateFlowImpl r13 = j1.a(new c(false, false, r11));
        this._uiState = r13;
        this.uiState = kotlinx.coroutines.flow.e.b(r13);
        MutableSharedFlow<b> r14 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._uiEvent = r14;
        this.uiEvent = kotlinx.coroutines.flow.e.a(r14);
        this.botCreateTrace = new com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.h();
        return;
    L21:
        r9 = false;
    L17:
        r8 = 18;
    L9:
        r4 = 6;
        goto L10
    }

    private final void onClickConfirm() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02101(this, null), 3, null);
    }

    public com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.h getBotCreateTrace() {
        return this.botCreateTrace;
    }

    @Override // uu8.b
    public d1<b> getUiEvent() {
        return this.uiEvent;
    }

    @Override // uu8.b
    public i1<c> getUiState() {
        return this.uiState;
    }

    public static final /* synthetic */ Integer access$getBgCategoryType$p(AIGenBgImageViewModel r0) {
        return r0.bgCategoryType;
    }

    public static final /* synthetic */ Boolean access$getBgImgOpen$p(AIGenBgImageViewModel r0) {
        return r0.bgImgOpen;
    }

    public static final /* synthetic */ String access$getBotDescription$p(AIGenBgImageViewModel r0) {
        return r0.botDescription;
    }

    public static final /* synthetic */ BotModel access$getBotInfo$p(AIGenBgImageViewModel r0) {
        return r0.botInfo;
    }

    public static final /* synthetic */ String access$getBotName$p(AIGenBgImageViewModel r0) {
        return r0.botName;
    }

    public static final /* synthetic */ BotAvatarIconData access$getCurSelectedImg$p(AIGenBgImageViewModel r0) {
        return r0.curSelectedImg;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getGenSuccessPageIndexMap$p(AIGenBgImageViewModel r0) {
        return r0.genSuccessPageIndexMap;
    }

    public static final /* synthetic */ boolean access$getNeedUpdateBotInfo$p(AIGenBgImageViewModel r0) {
        return r0.needUpdateBotInfo;
    }

    public static final /* synthetic */ Job access$getObserveFinishPreAiGenBgProcessFlowJob$p(AIGenBgImageViewModel r0) {
        return r0.observeFinishPreAiGenBgProcessFlowJob;
    }

    public static final /* synthetic */ String access$getPrompt$p(AIGenBgImageViewModel r0) {
        return r0.prompt;
    }

    public static final /* synthetic */ AIGenBgImageRepository access$getRepo$p(AIGenBgImageViewModel r0) {
        return r0.repo;
    }

    public static final /* synthetic */ String access$getUserBotGender$p(AIGenBgImageViewModel r0) {
        return r0.userBotGender;
    }

    public static final /* synthetic */ String access$getUserBotType$p(AIGenBgImageViewModel r0) {
        return r0.userBotType;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_uiEvent$p(AIGenBgImageViewModel r0) {
        return r0._uiEvent;
    }

    public static final /* synthetic */ z0 access$get_uiState$p(AIGenBgImageViewModel r0) {
        return r0._uiState;
    }

    public static final /* synthetic */ boolean access$isTowRow$p(AIGenBgImageViewModel r0) {
        return r0.isTowRow;
    }

    private final Job genBgImageByPrompt(int r7) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r7, null), 3, null);
    }

    private final void init(Bundle r4) {
        if (r4 == null) goto L4;
        getBotCreateTrace().a.putAll(r4);
    L4:
        BotModel r0 = null;
        if (r4 == null) goto L7;
        String r1 = r4.getString("prompt");
    L8:
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        this.prompt = r1;
        if (r4 == null) goto L14;
        String r2 = r4.getString("bot_name");
        if (r2 == null) goto L14;
    L15:
        this.botName = r2;
        if (r4 == null) goto L19;
        String r3 = r4.getString("bot_description");
        if (r3 == null) goto L19;
    L20:
        this.botDescription = r3;
        if (r4 == null) goto L24;
        String r5 = r4.getString("user_bot_gender");
        if (r5 == null) goto L24;
    L25:
        this.userBotGender = r5;
        if (r4 == null) goto L29;
        String r6 = r4.getString("user_bot_type");
        if (r6 == null) goto L29;
    L30:
        this.userBotType = r6;
        if (r4 == null) goto L33;
        boolean r7 = r4.getBoolean("need_update_bot_info");
    L34:
        this.needUpdateBotInfo = r7;
        if (r4 == null) goto L37;
        Serializable r8 = r4.getSerializable("bot_update_bot_argument");
    L39:
        if ((r8 instanceof BotModel) == false) goto L41;
        r0 = (BotModel) r8;
    L41:
        this.botInfo = r0;
        genBgImageByPrompt(0);
        return;
    L37:
        r8 = null;
        goto L39
    L33:
        r7 = false;
    L29:
        r6 = this.userBotType;
    L24:
        r5 = this.userBotGender;
    L19:
        r3 = this.botDescription;
    L14:
        r2 = this.botName;
        goto L15
    L7:
        r1 = null;
        goto L8
    }

    private final void onClickRetry(Integer r12) {
        int r1 = 0;
        if (r12 != null) goto L8;
        z0<c> r2 = this._uiState;
        int r3 = this.maxPageNum;
        ArrayList r4 = new ArrayList(r3);
        int r5 = 0;
    L5:
        if (r5 >= r3) goto L7;
        r4.add(new Text2BgImageBindingViewHolder.a(new w(CollectionsKt.emptyList()), this.isTowRow, r5, null));
        r5 = r5 + 1;
        goto L5
    L7:
        r2.setValue(new c(false, false, r4));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(this, null), 3, null);
    L12:
        if (r12 == null) goto L14;
        r1 = r12.intValue();
    L14:
        genBgImageByPrompt(r1);
        return;
    L8:
        z0<c> r6 = this._uiState;
        c r7 = (c) getUiState().getValue();
        List r8 = CollectionsKt.toMutableList(((c) getUiState().getValue()).c);
        if (((Text2BgImageBindingViewHolder.a) CollectionsKt.getOrNull(((c) getUiState().getValue()).c, r12.intValue())) == null) goto L11;
        w r9 = new w(CollectionsKt.emptyList());
        boolean r10 = this.isTowRow;
        int r11 = r12.intValue();
        Intrinsics.checkNotNullParameter(r9, "state");
        Text2BgImageBindingViewHolder.a r13 = new Text2BgImageBindingViewHolder.a(r9, r10, r11, null);
        ListProtector.set(r8, r12.intValue(), r13);
    L11:
        Unit r0 = Unit.INSTANCE;
        r6.setValue(c.a(r7, false, r8, 3));
        goto L12
    }

    private final void onPageSelected(int r3) {
        this.curPageIndex = r3;
        if (this.genSuccessPageIndexMap.containsKey(Integer.valueOf(r3)) == true) goto L6;
        genBgImageByPrompt(r3);
        return;
    }

    private final void showLoadError(int r8) {
        z0<c> r0 = this._uiState;
        c r1 = (c) getUiState().getValue();
        List r2 = CollectionsKt.toMutableList(((c) getUiState().getValue()).c);
        Text2BgImageBindingViewHolder.a r3 = (Text2BgImageBindingViewHolder.a) CollectionsKt.getOrNull(((c) getUiState().getValue()).c, r8);
        if (r3 == null) goto L5;
        AsyncThrowable.Companion.getClass();
        ListProtector.set(r2, r8, Text2BgImageBindingViewHolder.a.a(r3, new com.larus.network.http.f(AsyncThrowable.access$getDEFAULT$cp(), null), null, 14));
    L5:
        Unit r9 = Unit.INSTANCE;
        r0.setValue(c.a(r1, false, r2, 3));
    }

    /* JADX INFO: renamed from: dispatchUIAction, reason: avoid collision after fix types in other method */
    public void dispatchUIAction2(com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.a r2) {
        Intrinsics.checkNotNullParameter(r2, "uiAction");
        if ((r2 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.a.c) == false) goto L6;
        init(((com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.a.c) r2).a);
        return;
    L6:
        if ((r2 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.a.d) == false) goto L9;
        com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.a.d r3 = (com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.a.d) r2;
        onImageChosen(r3.a, r3.b);
        return;
    L9:
        if ((r2 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.a.e) == false) goto L12;
        onPageSelected(((com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.a.e) r2).a);
        return;
    L12:
        if ((r2 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.a.b) == false) goto L15;
        onClickRetry(((com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.a.b) r2).a);
        return;
    L15:
        if (Intrinsics.areEqual(r2, com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.a.C0062a.a) == false) goto L19;
        onClickConfirm();
        return;
    L19:
        throw new NoWhenBranchMatchedException();
    }

    @Override // uu8.b
    public /* bridge */ /* synthetic */ void dispatchUIAction(com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.a r1) {
        dispatchUIAction2(r1);
    }

    public static final /* synthetic */ void access$setBgCategoryType$p(AIGenBgImageViewModel r0, Integer r1) {
        r0.bgCategoryType = r1;
    }

    public static final /* synthetic */ void access$setBgImgOpen$p(AIGenBgImageViewModel r0, Boolean r1) {
        r0.bgImgOpen = r1;
    }

    public static final /* synthetic */ void access$setObserveFinishPreAiGenBgProcessFlowJob$p(AIGenBgImageViewModel r0, Job r1) {
        r0.observeFinishPreAiGenBgProcessFlowJob = r1;
    }

    public static final /* synthetic */ void access$showLoadError(AIGenBgImageViewModel r0, int r1) {
        r0.showLoadError(r1);
    }

    private final void onImageChosen(int r10, int r11) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = ((c) getUiState().getValue()).c.iterator();
        boolean r2 = false;
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L22;
        Object r4 = r1.next();
        int r6 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        Text2BgImageBindingViewHolder.a r5 = (Text2BgImageBindingViewHolder.a) r4;
        BotAvatarIconData r8 = null;
        if (r3 == r10) goto L11;
        r0.add(Text2BgImageBindingViewHolder.a.a(r5, null, null, 7));
    L21:
        r3 = r6;
        goto L4
    L11:
        Integer r7 = r5.d;
        if (r7 != null) goto L15;
    L17:
        r0.add(Text2BgImageBindingViewHolder.a.a(r5, null, Integer.valueOf(r11), 7));
        List r9 = (List) r5.a.b;
        if (r9 == null) goto L20;
        r8 = (BotAvatarIconData) CollectionsKt.getOrNull(r9, r11);
    L20:
        this.curSelectedImg = r8;
        r2 = true;
        goto L21
    L15:
        if (r7.intValue() != r11) goto L17;
        r0.add(Text2BgImageBindingViewHolder.a.a(r5, null, null, 7));
        goto L21
    L22:
        this._uiState.setValue(c.a((c) getUiState().getValue(), r2, r0, 1));
    }
}
