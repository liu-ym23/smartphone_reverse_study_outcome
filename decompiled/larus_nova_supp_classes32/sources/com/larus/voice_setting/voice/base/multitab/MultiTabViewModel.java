package com.larus.voice_setting.voice.base.multitab;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import com.larus.audio.bean.VoiceListTabInfo;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.voice_setting.voice.bean.CacheStatus;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0082@¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/larus/voice_setting/voice/base/multitab/MultiTabViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "PAGE_SIZE", NameKeys.UnloadStrategy_No_Strategy, "index", "botId", NameKeys.UnloadStrategy_No_Strategy, "languageCode", "tab", "Lcom/larus/audio/bean/VoiceListTabInfo;", "setupViewModel", NameKeys.UnloadStrategy_No_Strategy, "tabVoiceLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/voice_setting/voice/bean/RecommendVoiceCache;", "getTabVoiceLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setTabVoiceLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "queryMoreTabVoice", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "queryTabVoiceList", "queryMultiTabVoiceList", "Lcom/larus/network/http/Async;", "Lcom/larus/voice_setting/voice/bean/UgcVoiceResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiTabViewModel extends AndroidViewModel {
    private final int PAGE_SIZE;
    private String botId;
    private int index;
    private String languageCode;
    private VoiceListTabInfo tab;
    private MutableLiveData<r2a.e> tabVoiceLiveData;

    /* JADX INFO: renamed from: com.larus.voice_setting.voice.base.multitab.MultiTabViewModel$queryMoreTabVoice$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voice_setting.voice.base.multitab.MultiTabViewModel$queryMoreTabVoice$1", f = "MultiTabViewModel.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MultiTabViewModel this$0;

        public AnonymousClass1(MultiTabViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            y r7 = (com.larus.network.http.a) r6;
            if ((r7 instanceof y) == false) goto L33;
            y r8 = r7;
            r2a.g r2 = (r2a.g) ((com.larus.network.http.a) r8).b;
            if (r2 == null) goto L43;
            List<SpeakerVoice> r3 = r2.b();
            if (r3 == null) goto L43;
            MultiTabViewModel r4 = this.this$0;
            r2a.e r5 = (r2a.e) r4.getTabVoiceLiveData().getValue();
            if (r5 == null) goto L23;
            List<SpeakerVoice> r9 = r5.a;
            if (r9 == null) goto L23;
            List r10 = CollectionsKt.toMutableList(r9);
            if (r10 == null) goto L23;
        L24:
            r10.addAll(r3);
            r2a.g r11 = (r2a.g) ((com.larus.network.http.a) r8).b;
            int r12 = 0;
            if (r11 == null) goto L27;
            boolean r13 = Intrinsics.areEqual(r11.a(), Boxing.boxBoolean(true));
        L28:
            if (r13 == true) goto L31;
            r12 = 2;
        L31:
            MutableLiveData<r2a.e> r14 = r4.getTabVoiceLiveData();
            MultiTabViewModel.access$getIndex$p(r4);
            r14.postValue(new r2a.e(r10, Boxing.boxInt(r12), Boxing.boxInt(3), 16));
            goto L43
        L27:
            r13 = false;
        L23:
            r10 = new ArrayList();
        L43:
            return Unit.INSTANCE;
        L33:
            if ((r7 instanceof com.larus.network.http.f) == false) goto L43;
            r2a.e r15 = (r2a.e) this.this$0.getTabVoiceLiveData().getValue();
            if (r15 == null) goto L40;
            List<SpeakerVoice> r16 = r15.a;
            if (r16 == null) goto L40;
            List r17 = CollectionsKt.toMutableList(r16);
            if (r17 == null) goto L40;
        L41:
            MutableLiveData<r2a.e> r18 = this.this$0.getTabVoiceLiveData();
            MultiTabViewModel.access$getIndex$p(this.this$0);
            r18.postValue(new r2a.e(r17, Boxing.boxInt(1), Boxing.boxInt(1), 16));
        L40:
            r17 = new ArrayList();
            goto L41
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            int r19 = MultiTabViewModel.access$getIndex$p(this.this$0);
            MultiTabViewModel.access$setIndex$p(this.this$0, r19 + 1);
            MultiTabViewModel r20 = this.this$0;
            this.label = 1;
            r6 = MultiTabViewModel.access$queryMultiTabVoiceList(r20, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.voice_setting.voice.base.multitab.MultiTabViewModel$queryMultiTabVoiceList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voice_setting.voice.base.multitab.MultiTabViewModel", f = "MultiTabViewModel.kt", i = {}, l = {103}, m = "queryMultiTabVoiceList", n = {}, s = {})
    public static final class C01361 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MultiTabViewModel this$0;

        public C01361(MultiTabViewModel r1, Continuation<? super C01361> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return MultiTabViewModel.access$queryMultiTabVoiceList(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.voice_setting.voice.base.multitab.MultiTabViewModel$queryTabVoiceList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voice_setting.voice.base.multitab.MultiTabViewModel$queryTabVoiceList$1", f = "MultiTabViewModel.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MultiTabViewModel this$0;

        public C01371(MultiTabViewModel r1, Continuation<? super C01371> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01371(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L11:
            y r8 = (com.larus.network.http.a) r7;
            List<SpeakerVoice> r3 = null;
            if ((r8 instanceof y) == false) goto L36;
            y r9 = r8;
            r2a.g r4 = (r2a.g) ((com.larus.network.http.a) r9).b;
            if (r4 == null) goto L16;
            boolean r5 = Intrinsics.areEqual(r4.a(), Boxing.boxBoolean(true));
        L17:
            if (r5 == false) goto L19;
            int r6 = 0;
        L20:
            r2a.g r10 = (r2a.g) ((com.larus.network.http.a) r9).b;
            if (r10 == null) goto L27;
            List<SpeakerVoice> r11 = r10.b();
            if (r11 == null) goto L27;
            if ((!r11.isEmpty()) != true) goto L27;
        L28:
            if (r2 == false) goto L30;
            CacheStatus r12 = CacheStatus.EMPTY;
        L31:
            MutableLiveData<r2a.e> r13 = this.this$0.getTabVoiceLiveData();
            r2a.g r14 = (r2a.g) ((com.larus.network.http.a) r9).b;
            if (r14 == null) goto L34;
            r3 = r14.b();
        L34:
            r13.postValue(new r2a.e(r3, Boxing.boxInt(r6), Boxing.boxInt(3), 16));
        L39:
            return Unit.INSTANCE;
        L30:
            CacheStatus r15 = CacheStatus.EMPTY;
        L27:
            r2 = false;
            goto L28
        L19:
            r6 = 2;
            goto L20
        L16:
            r5 = false;
            goto L17
        L36:
            if ((r8 instanceof com.larus.network.http.f) == false) goto L39;
            this.this$0.getTabVoiceLiveData().postValue(new r2a.e(null, Boxing.boxInt(1), Boxing.boxInt(1), 16));
            goto L39
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            MultiTabViewModel r16 = this.this$0;
            this.label = 1;
            r7 = MultiTabViewModel.access$queryMultiTabVoiceList(r16, this);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    public final MutableLiveData<r2a.e> getTabVoiceLiveData() {
        return this.tabVoiceLiveData;
    }

    public MultiTabViewModel(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        super(r2);
        this.PAGE_SIZE = 20;
        this.index = 1;
        this.botId = NameKeys.UnloadStrategy_No_Strategy;
        this.languageCode = NameKeys.UnloadStrategy_No_Strategy;
        this.tabVoiceLiveData = new MutableLiveData();
    }

    public static final /* synthetic */ int access$getIndex$p(MultiTabViewModel r0) {
        return r0.index;
    }

    private final Object queryMultiTabVoiceList(Continuation<? super com.larus.network.http.a<r2a.g>> r14) {
        if ((r14 instanceof C01361) == false) goto L7;
        C01361 r0 = (C01361) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        C01361 r11 = r0;
        Object r15 = r11.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r11.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
    L25:
        return (com.larus.network.http.a) r15;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        JSONObject r4 = new JSONObject();
        r4.put("page_index", this.index);
        r4.put("page_size", this.PAGE_SIZE);
        VoiceListTabInfo r5 = this.tab;
        String r6 = null;
        if (r5 == null) goto L17;
        Integer r7 = Boxing.boxInt(r5.a());
    L18:
        r4.put("recommend_type", r7);
        VoiceListTabInfo r8 = this.tab;
        if (r8 == null) goto L21;
        r6 = r8.b();
    L21:
        r4.put("tab_key", r6);
        r4.put("language_code", this.languageCode);
        r4.put("bot_id", this.botId);
        Unit r9 = Unit.INSTANCE;
        r11.label = 1;
        r15 = HttpExtKt.k("Social", r2a.g.class, "/alice/user_voice/recommend", r4, null, null, false, null, null, null, r11, 1008);
        if (r15 != r2) goto L25;
        return r2;
    L17:
        r7 = null;
    L7:
        r0 = new C01361(this, r14);
        goto L8
    }

    public final void queryMoreTabVoice(LifecycleOwner r8) {
        Intrinsics.checkNotNullParameter(r8, "lifecycleOwner");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r8), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
    }

    public final void queryTabVoiceList(LifecycleOwner r8) {
        Intrinsics.checkNotNullParameter(r8, "lifecycleOwner");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r8), Dispatchers.getIO(), null, new C01371(this, null), 2, null);
    }

    public final void setTabVoiceLiveData(MutableLiveData<r2a.e> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.tabVoiceLiveData = r2;
    }

    public static final /* synthetic */ Object access$queryMultiTabVoiceList(MultiTabViewModel r0, Continuation r1) {
        return r0.queryMultiTabVoiceList(r1);
    }

    public static final /* synthetic */ void access$setIndex$p(MultiTabViewModel r0, int r1) {
        r0.index = r1;
    }

    public final void setupViewModel(String r2, String r3, VoiceListTabInfo r4) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        Intrinsics.checkNotNullParameter(r3, "languageCode");
        Intrinsics.checkNotNullParameter(r4, "tab");
        this.index = 1;
        this.botId = r2;
        this.languageCode = r3;
        this.tab = r4;
    }
}
