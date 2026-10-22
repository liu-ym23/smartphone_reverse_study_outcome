package com.ss.android.lark.compose.chatsetting.main.viewmodel;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lark.kmp.pb.basic.v1.Chatter;
import com.lark.kmp.pb.basic.v1.DeniedReason;
import com.lark.kmp.rustclient.api.d;
import com.ss.android.lark.compose.chatsetting.common.platform.AndroidChatSettingPlatformEffects;
import com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepository;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016¢\u0006\u0002\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/compose/chatsetting/main/viewmodel/P2PInfoViewModel;", "Landroidx/lifecycle/ViewModel;", "p2pChatId", BuildConfig.FLAVOR, "p2pChatterId", "rustClient", "Lcom/lark/kmp/rustclient/api/IRustClient;", "platformEffects", "Lcom/ss/android/lark/compose/chatsetting/common/platform/ChatSettingPlatformEffects;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/lark/kmp/rustclient/api/IRustClient;Lcom/ss/android/lark/compose/chatsetting/common/platform/ChatSettingPlatformEffects;)V", "repository", "Lcom/ss/android/lark/compose/chatsetting/common/repository/ChatSettingRepository;", "p2pChatter", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/lark/kmp/pb/basic/v1/Chatter;", "getP2pChatter", "()Lkotlinx/coroutines/flow/StateFlow;", "routeToProfile", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "Lcom/ss/android/lark/compose/chatsetting/common/router/PlatformContext;", "(Landroid/content/Context;)V", "createGroup", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class P2PInfoViewModel extends ViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    private final String p2pChatId;
    private final i1<Chatter> p2pChatter;
    private final String p2pChatterId;
    private final com.ss.android.lark.compose.chatsetting.common.platform.b platformEffects;
    private final ChatSettingRepository repository;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.main.viewmodel.P2PInfoViewModel$createGroup$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.main.viewmodel.P2PInfoViewModel$createGroup$1", f = "P2PInfoViewModel.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ P2PInfoViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.main.viewmodel.P2PInfoViewModel$createGroup$1$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[DeniedReason.values().length];
                r0[DeniedReason.BLOCKED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[DeniedReason.BE_BLOCKED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[DeniedReason.NO_FRIENDSHIP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public AnonymousClass1(P2PInfoViewModel r1, Context r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$context = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$context, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
            Object r6 = ((Result) r5).unbox-impl();
        L11:
            P2PInfoViewModel r2 = this.this$0;
            Context r3 = this.$context;
            if (Result.exceptionOrNull-impl(r6) != null) goto L35;
            DeniedReason r7 = (DeniedReason) r6;
            if (r7 != null) goto L19;
            Object r8 = P2PInfoViewModel.access$getPlatformEffects$p(this.this$0).c(this.$context, P2PInfoViewModel.access$getP2pChatId$p(this.this$0));
            P2PInfoViewModel r4 = this.this$0;
            Context r9 = this.$context;
            Throwable r10 = Result.exceptionOrNull-impl(r8);
            if (r10 == null) goto L18;
            P2PInfoViewModel.access$getPlatformEffects$p(r4).m(r9, r10);
        L18:
            Result.box-impl(r8);
        L34:
            return Unit.INSTANCE;
        L19:
            int r11 = a.a[r7.ordinal()];
            if (r11 != 1) goto L22;
            P2PInfoViewModel.access$getPlatformEffects$p(this.this$0).n(this.$context, com.ss.android.lark.compose.chatsetting.common.platform.c.b.a);
            goto L34
        L22:
            if (r11 != 2) goto L24;
            P2PInfoViewModel.access$getPlatformEffects$p(this.this$0).n(this.$context, com.ss.android.lark.compose.chatsetting.common.platform.c.a.a);
            goto L34
        L24:
            if (r11 == 3) goto L26;
            int r12 = c8b.a.a;
            c8b.a.b("[P2PInfoViewModel.createGroup] reason: " + r7);
            P2PInfoViewModel.access$getPlatformEffects$p(this.this$0).n(this.$context, com.ss.android.lark.compose.chatsetting.common.platform.c.i.a);
            goto L34
        L26:
            Chatter r13 = (Chatter) this.this$0.getP2pChatter().getValue();
            if (r13 == null) goto L34;
            String r14 = r13.getName();
            if (r14 == null) goto L34;
            P2PInfoViewModel r15 = this.this$0;
            P2PInfoViewModel.access$getPlatformEffects$p(r15).n(this.$context, new com.ss.android.lark.compose.chatsetting.common.platform.c.h(r14));
            goto L34
        L35:
            P2PInfoViewModel.access$getPlatformEffects$p(r2).n(r3, com.ss.android.lark.compose.chatsetting.common.platform.c.d.a);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            ChatSettingRepository r16 = P2PInfoViewModel.access$getRepository$p(this.this$0);
            String r17 = P2PInfoViewModel.access$getP2pChatterId$p(this.this$0);
            String r18 = P2PInfoViewModel.access$getP2pChatId$p(this.this$0);
            this.label = 1;
            r6 = r16.b(r17, r18, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public final i1<Chatter> getP2pChatter() {
        return this.p2pChatter;
    }

    public static final /* synthetic */ String access$getP2pChatId$p(P2PInfoViewModel r0) {
        return r0.p2pChatId;
    }

    public static final /* synthetic */ String access$getP2pChatterId$p(P2PInfoViewModel r0) {
        return r0.p2pChatterId;
    }

    public static final /* synthetic */ com.ss.android.lark.compose.chatsetting.common.platform.b access$getPlatformEffects$p(P2PInfoViewModel r0) {
        return r0.platformEffects;
    }

    public static final /* synthetic */ ChatSettingRepository access$getRepository$p(P2PInfoViewModel r0) {
        return r0.repository;
    }

    public final void createGroup(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        if (this.platformEffects.g(r8) == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r8, null), 3, null);
    }

    public final void routeToProfile(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        int r0 = d8b.a.a;
        d8b.a.c(r3, this.p2pChatId, this.p2pChatterId);
    }

    public P2PInfoViewModel(String r2, String r3, d r4, com.ss.android.lark.compose.chatsetting.common.platform.b r5) {
        Intrinsics.checkNotNullParameter(r2, "p2pChatId");
        Intrinsics.checkNotNullParameter(r3, "p2pChatterId");
        Intrinsics.checkNotNullParameter(r4, "rustClient");
        Intrinsics.checkNotNullParameter(r5, "platformEffects");
        this.p2pChatId = r2;
        this.p2pChatterId = r3;
        this.platformEffects = r5;
        this.repository = new ChatSettingRepository(r4);
        c1 r6 = new c1(new P2PInfoViewModel$p2pChatter$1(this, null));
        CoroutineScope r7 = ViewModelKt.getViewModelScope(this);
        g1.a.getClass();
        this.p2pChatter = e.F(r6, r7, g1.a.b, null);
    }

    public P2PInfoViewModel(String r1, String r2, d r3, com.ss.android.lark.compose.chatsetting.common.platform.b r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = new AndroidChatSettingPlatformEffects(null);
    L5:
        this(r1, r2, r3, r4);
    }
}
