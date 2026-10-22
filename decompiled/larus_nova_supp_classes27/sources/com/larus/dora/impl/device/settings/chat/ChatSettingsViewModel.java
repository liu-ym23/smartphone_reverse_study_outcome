package com.larus.dora.impl.device.settings.chat;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import pk4.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/larus/dora/impl/device/settings/chat/ChatSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_chatSettingsStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/device/settings/chat/ChatSettingsViewModel$ChatSettingsState;", "chatSettingsStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getChatSettingsStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "loadCameraSettings", "", "updateCameraSettings", "mode", "", "ChatSettingsState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatSettingsViewModel extends ViewModel {
    private final z0<a> _chatSettingsStateFlow;
    private final i1<a> chatSettingsStateFlow;

    public static final class a {
        public final boolean a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == true) goto L11;
            r1 = 1237;
        L11:
            return r2 + r1;
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "ChatSettingsState(isBurstTakeImageEnabled=" + this.a + ", isPreTakeImageEnabled=" + this.b + ')';
        }

        public a(boolean r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.chat.ChatSettingsViewModel$loadCameraSettings$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.chat.ChatSettingsViewModel$loadCameraSettings$1", f = "ChatSettingsViewModel.kt", i = {}, l = {21}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatSettingsViewModel this$0;

        public AnonymousClass1(ChatSettingsViewModel r1, Continuation<? super AnonymousClass1> r2) {
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
        L21:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            if (kj4.a.g().c() == null) goto L21;
            boolean r2 = false;
            if (kj4.a.g().d.l() != 1) goto L13;
            boolean r11 = true;
        L14:
            kj4.a.g().d.getClass();
            Long r6 = 1L;
            if (i.a.a.a.getLong("tag_speak_then_take_photo", r6.longValue()) != 1) goto L17;
            r2 = true;
        L17:
            z0 r3 = ChatSettingsViewModel.access$get_chatSettingsStateFlow$p(this.this$0);
            a r4 = new a(r11, r2);
            this.label = 1;
            if (r3.emit(r4, this) != r0) goto L21;
            return r0;
        L13:
            r11 = false;
            goto L14
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.chat.ChatSettingsViewModel$updateCameraSettings$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.chat.ChatSettingsViewModel$updateCameraSettings$1", f = "ChatSettingsViewModel.kt", i = {}, l = {35, 41}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isBurstTakeImageEnabled;
        final /* synthetic */ boolean $isPreTakeImageEnabled;
        final /* synthetic */ a $originalState;
        int label;
        final /* synthetic */ ChatSettingsViewModel this$0;

        public C02521(ChatSettingsViewModel r1, boolean r2, boolean r3, a r4, Continuation<? super C02521> r5) {
            this.this$0 = r1;
            this.$isBurstTakeImageEnabled = r2;
            this.$isPreTakeImageEnabled = r3;
            this.$originalState = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C02521(this.this$0, this.$isBurstTakeImageEnabled, this.$isPreTakeImageEnabled, this.$originalState, r8);
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r7);
        L24:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
        L13:
            kj4.a r8 = kj4.a.g();
            boolean r2 = this.$isBurstTakeImageEnabled;
            if (r8.d.f(r2 ? 1 : 0) != 0) goto L20;
            kj4.a r9 = kj4.a.g();
            boolean r3 = this.$isPreTakeImageEnabled;
            r9.d.getClass();
            i r10 = i.a.a;
            if (r3 == false) goto L18;
            long r4 = 1;
        L19:
            r10.a.storeLong("tag_speak_then_take_photo", r4);
            Boxing.boxInt(1);
            goto L24
        L18:
            r4 = 0;
            goto L19
        L20:
            z0 r11 = ChatSettingsViewModel.access$get_chatSettingsStateFlow$p(this.this$0);
            a r5 = this.$originalState;
            this.label = 2;
            if (r11.emit(r5, this) != r0) goto L24;
            return r0;
        L10:
            ResultKt.throwOnFailure(r7);
            z0 r12 = ChatSettingsViewModel.access$get_chatSettingsStateFlow$p(this.this$0);
            a r6 = new a(this.$isBurstTakeImageEnabled, this.$isPreTakeImageEnabled);
            this.label = 1;
            if (r12.emit(r6, this) != r0) goto L13;
            return r0;
        }
    }

    public ChatSettingsViewModel() {
        StateFlowImpl r0 = j1.a(new a(false, true));
        this._chatSettingsStateFlow = r0;
        this.chatSettingsStateFlow = r0;
    }

    public final void loadCameraSettings() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
    }

    public final i1<a> getChatSettingsStateFlow() {
        return this.chatSettingsStateFlow;
    }

    public static final /* synthetic */ z0 access$get_chatSettingsStateFlow$p(ChatSettingsViewModel r0) {
        return r0._chatSettingsStateFlow;
    }

    public final void updateCameraSettings(int r13) {
        a r5 = (a) this._chatSettingsStateFlow.getValue();
        if (r13 != 3) goto L5;
        boolean r3 = true;
    L6:
        if (r13 != 1) goto L8;
        boolean r4 = true;
    L12:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02521(this, r3, r4, r5, null), 2, null);
        return;
    L8:
        if (r13 == 2) goto L10;
        r4 = r5.b;
        goto L12
    L10:
        r4 = false;
        goto L12
    L5:
        r3 = false;
        goto L6
    }
}
