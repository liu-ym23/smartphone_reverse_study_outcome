package com.ss.android.lark.compose.chatterselector;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lark.kmp.logger.LarkLogger;
import com.lark.kmp.pb.basic.v1.Chatter;
import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.contact.v1.MGetChattersRequest;
import com.lark.kmp.pb.contact.v1.MGetChattersResponse;
import com.lark.kmp.rustclient.api.model.RustOutputKt$errorAsException$;
import com.lark.kmp.rustclient.api.model.i;
import com.ss.android.lark.compose.chat_member_list.ChatMemberStatusTag_androidKt;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B7\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004J\u0016\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\nJ\b\u0010\u001c\u001a\u00020\u0017H\u0002J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0014\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00030\u001fH\u0002J\f\u0010 \u001a\u00020\u0015*\u00020!H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ss/android/lark/compose/chatterselector/FixedChatterSelectorViewModel;", "Landroidx/lifecycle/ViewModel;", "chatterIds", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "rustClient", "Lcom/lark/kmp/rustclient/api/IRustClient;", "initiallySelectedIds", BuildConfig.FLAVOR, "singleSelect", BuildConfig.FLAVOR, "<init>", "(Ljava/util/List;Lcom/lark/kmp/rustclient/api/IRustClient;Ljava/util/Set;Z)V", "uiFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ss/android/lark/compose/chatterselector/ChatterSelectorUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "allChatters", "Lcom/ss/android/lark/compose/chatterselector/ChatterSelectorChatter;", "updateQuery", BuildConfig.FLAVOR, "query", "toggleSelected", "chatterId", "selected", "loadChatters", "filterChatters", "fetchChattersFlow", "Lkotlinx/coroutines/flow/Flow;", "toSelectorChatter", "Lcom/lark/kmp/pb/basic/v1/Chatter;", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FixedChatterSelectorViewModel extends ViewModel {
    public static final int $stable = 0;
    private static final a Companion = null;
    public static final String TAG = "FixedChatterSelectorVM";
    private List<com.ss.android.lark.compose.chatterselector.a> allChatters;
    private final List<String> chatterIds;
    private final com.lark.kmp.rustclient.api.d rustClient;
    private final boolean singleSelect;
    private final z0<b> uiFlow;
    private final i1<b> uiState;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatterselector.FixedChatterSelectorViewModel$loadChatters$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatterselector.FixedChatterSelectorViewModel$loadChatters$1", f = "FixedChatterSelectorViewModel.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FixedChatterSelectorViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chatterselector.FixedChatterSelectorViewModel$loadChatters$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/flow/FlowCollector;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/compose/chatterselector/ChatterSelectorChatter;", Keys.API_RETURN_KEY_ERROR, BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.ss.android.lark.compose.chatterselector.FixedChatterSelectorViewModel$loadChatters$1$2", f = "FixedChatterSelectorViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends com.ss.android.lark.compose.chatterselector.a>>, Throwable, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;

            public AnonymousClass2(Continuation<? super AnonymousClass2> r2) {
                super(3, r2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
                return invoke((FlowCollector) r1, (Throwable) r2, (Continuation) r3);
            }

            public final Object invoke(FlowCollector<? super List<com.ss.android.lark.compose.chatterselector.a>> r1, Throwable r2, Continuation<? super Unit> r3) {
                AnonymousClass2 r4 = new AnonymousClass2(r3);
                r4.L$0 = r2;
                return r4.invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r3);
                Throwable r4 = (Throwable) this.L$0;
                LarkLogger r0 = LarkLogger.a;
                LarkLogger.b(FixedChatterSelectorViewModel.TAG, "loadChatters failed: " + r4.getMessage());
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chatterselector.FixedChatterSelectorViewModel$loadChatters$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ FixedChatterSelectorViewModel a;

            public a(FixedChatterSelectorViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r8, Continuation r9) {
                FixedChatterSelectorViewModel r10 = this.a;
                FixedChatterSelectorViewModel.access$setAllChatters$p(r10, (List) r8);
                z0 r11 = FixedChatterSelectorViewModel.access$getUiFlow$p(this.a);
                FixedChatterSelectorViewModel r12 = this.a;
            L3:
                Object r0 = r11.getValue();
                b r1 = (b) r0;
                if (r11.compareAndSet(r0, b.a(r1, null, FixedChatterSelectorViewModel.access$filterChatters(r12, r1.a), null, false, 125)) == false) goto L3;
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(FixedChatterSelectorViewModel r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L14:
            z0 r2 = FixedChatterSelectorViewModel.access$getUiFlow$p(this.this$0);
        L15:
            Object r11 = r2.getValue();
            if (r2.compareAndSet(r11, b.a((b) r11, null, null, null, false, 119)) == false) goto L15;
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            z0 r12 = FixedChatterSelectorViewModel.access$getUiFlow$p(this.this$0);
        L9:
            Object r3 = r12.getValue();
            if (r12.compareAndSet(r3, b.a((b) r3, null, null, null, true, 119)) == false) goto L9;
            FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1 r4 = new FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1(FixedChatterSelectorViewModel.access$fetchChattersFlow(this.this$0), new AnonymousClass2(null));
            a r13 = new a(this.this$0);
            this.label = 1;
            if (r4.collect(r13, this) != r0) goto L14;
            return r0;
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    private final Flow<List<com.ss.android.lark.compose.chatterselector.a>> fetchChattersFlow() {
        com.lark.kmp.rustclient.api.d r0 = this.rustClient;
        MGetChattersRequest.a r2 = new MGetChattersRequest.a();
        List<String> r1 = this.chatterIds;
        Intrinsics.checkNotNullParameter(r1, "chatter_ids");
        com.lark.wire.internal.a.a(r1);
        r2.d = r1;
        r2.e = Boolean.TRUE;
        final RustOutputKt$errorAsException$.inlined.map.1 r3 = i.a(r0.b(new com.lark.kmp.rustclient.api.model.c(r2, MGetChattersResponse.ADAPTER, Command.MGET_CHATTERS, null, 120)).a());
        return new FixedChatterSelectorViewModel$fetchChattersFlow$$inlined$map$1(r3, this);
    }

    private final void loadChatters() {
        if (this.chatterIds.isEmpty() == false) goto L5;
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final i1<b> getUiState() {
        return this.uiState;
    }

    public static final /* synthetic */ Flow access$fetchChattersFlow(FixedChatterSelectorViewModel r0) {
        return r0.fetchChattersFlow();
    }

    public static final /* synthetic */ List access$getChatterIds$p(FixedChatterSelectorViewModel r0) {
        return r0.chatterIds;
    }

    public static final /* synthetic */ z0 access$getUiFlow$p(FixedChatterSelectorViewModel r0) {
        return r0.uiFlow;
    }

    private final List<com.ss.android.lark.compose.chatterselector.a> filterChatters(String r8) {
        String r9 = StringsKt.trim(r8).toString();
        if (r9.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        List<com.ss.android.lark.compose.chatterselector.a> r1 = this.allChatters;
        ArrayList r3 = new ArrayList();
        Iterator<T> r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L23;
        Object r4 = r2.next();
        com.ss.android.lark.compose.chatterselector.a r5 = (com.ss.android.lark.compose.chatterselector.a) r4;
        if (StringsKt.contains(r5.b, r9, true) == false) goto L15;
    L20:
        boolean r6 = true;
    L21:
        if (r6 == false) goto L11;
        r3.add(r4);
        goto L11
    L15:
        if (StringsKt.contains(r5.c, r9, true) == true) goto L20;
        if (StringsKt.contains(r5.a, r9, true) == true) goto L20;
        r6 = false;
        goto L21
    L23:
        return r3;
    L8:
        return this.allChatters;
    L5:
        r0 = false;
        goto L6
    }

    private final com.ss.android.lark.compose.chatterselector.a toSelectorChatter(Chatter r9) {
        String r1 = r9.getId();
        String r0 = r9.getAlias();
        boolean r2 = true;
        if (r0 != null) goto L5;
    L9:
        r0 = r9.getName();
    L10:
        String r3 = r0;
        String r4 = r9.getAlias();
        if (r4 == null) goto L17;
        if (StringsKt.isBlank(r4) == true) goto L17;
        r2 = false;
    L17:
        if (r2 == false) goto L19;
    L21:
        String r5 = r9.getAlias();
        if (r5 != null) goto L24;
        String r6 = BuildConfig.FLAVOR;
    L25:
        String r7 = r9.getAvatar_key();
        if (r7 != null) goto L28;
        String r8 = BuildConfig.FLAVOR;
    L30:
        return new com.ss.android.lark.compose.chatterselector.a(r1, r3, r6, r8, CollectionsKt.emptyList(), ChatMemberStatusTag_androidKt.b(r9));
    L28:
        r8 = r7;
    L24:
        r6 = r5;
        goto L25
    L19:
        if (Intrinsics.areEqual(r9.getAlias(), r9.getName()) == true) goto L21;
        r5 = r9.getName();
        goto L24
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 != null) goto L10;
        goto L9
    }

    public final void updateQuery(String r9) {
        Intrinsics.checkNotNullParameter(r9, "query");
        if (Intrinsics.areEqual(r9, ((b) this.uiFlow.getValue()).a) == false) goto L5;
        return;
    L5:
        z0<b> r0 = this.uiFlow;
    L6:
        Object r1 = r0.getValue();
        if (r0.compareAndSet(r1, b.a((b) r1, r9, filterChatters(r9), null, false, 124)) == false) goto L6;
    }

    public static final /* synthetic */ List access$filterChatters(FixedChatterSelectorViewModel r0, String r1) {
        return r0.filterChatters(r1);
    }

    public static final /* synthetic */ void access$setAllChatters$p(FixedChatterSelectorViewModel r0, List r1) {
        r0.allChatters = r1;
    }

    public static final /* synthetic */ com.ss.android.lark.compose.chatterselector.a access$toSelectorChatter(FixedChatterSelectorViewModel r0, Chatter r1) {
        return r0.toSelectorChatter(r1);
    }

    public final void toggleSelected(String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "chatterId");
        z0<b> r0 = this.uiFlow;
    L3:
        Object r1 = r0.getValue();
        b r2 = (b) r1;
        if (this.singleSelect == false) goto L8;
        if (r10 == false) goto L7;
        Set r3 = SetsKt.setOf(r9);
    L12:
        if (r0.compareAndSet(r1, b.a(r2, null, null, r3, false, 123)) == false) goto L3;
        return;
    L7:
        r3 = SetsKt.emptySet();
        goto L12
    L8:
        if (r10 == false) goto L10;
        r3 = SetsKt.plus(r2.c, r9);
        goto L12
    L10:
        r3 = SetsKt.minus(r2.c, r9);
        goto L12
    }

    public FixedChatterSelectorViewModel(List<String> r2, com.lark.kmp.rustclient.api.d r3, Set<String> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "chatterIds");
        Intrinsics.checkNotNullParameter(r3, "rustClient");
        Intrinsics.checkNotNullParameter(r4, "initiallySelectedIds");
        this.chatterIds = r2;
        this.rustClient = r3;
        this.singleSelect = r5;
        StateFlowImpl r6 = j1.a(new b(r4, 123));
        this.uiFlow = r6;
        this.uiState = e.b(r6);
        this.allChatters = CollectionsKt.emptyList();
        loadChatters();
    }

    public /* synthetic */ FixedChatterSelectorViewModel(List r1, com.lark.kmp.rustclient.api.d r2, Set r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = SetsKt.emptySet();
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = false;
    L8:
        this(r1, r2, r3, r4);
    }
}
