package com.obric.widget.host.runtime;

import android.os.Messenger;
import android.util.Log;
import cn.nubia.neopush.commons.Constant;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.e;
import kotlinx.coroutines.channels.i;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.channels.m;
import kotlinx.coroutines.channels.n;
import kotlinx.coroutines.channels.p;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0002\"!B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController;", "", "Lcom/obric/widget/host/runtime/WidgetRuntimeClient;", "runtimeClient", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "tag", "<init>", "(Lcom/obric/widget/host/runtime/WidgetRuntimeClient;Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;)V", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController$Command;", Constant.COMMAND, "", "enqueue", "(Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController$Command;)Z", "", "dispatch", "(Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController$Command;)V", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;", "snapshot", "bind", "(Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;)Z", "unbind", "Landroid/os/Messenger;", "messenger", "registerMessenger", "(Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;Landroid/os/Messenger;)Z", "unregisterMessenger", "Lcom/obric/widget/host/runtime/WidgetRuntimeClient;", "Ljava/lang/String;", "Lkotlinx/coroutines/channels/i;", "commands", "Lkotlinx/coroutines/channels/i;", "Companion", "Command", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetRuntimeBindingController {
    private static final Companion Companion = null;
    private static final String TAG = "OWidgetRuntimeBinding";
    private final i commands;
    private final WidgetRuntimeClient runtimeClient;
    private final String tag;

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetRuntimeBindingController$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetRuntimeBindingController$1", f = "WidgetRuntimeBindingController.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ WidgetRuntimeBindingController this$0;

        public AnonymousClass1(WidgetRuntimeBindingController r5, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            return new AnonymousClass1(this.this$0, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0033 -> B:12:0x0036). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            k r12 = (k) this.L$0;
            ResultKt.throwOnFailure(r5);
            k r13 = r12;
        L13:
            if (((Boolean) r5).booleanValue() == false) goto L16;
            e r14 = (e) r13;
            Command r15 = (Command) r14.d();
            WidgetRuntimeBindingController.access$dispatch(this.this$0, r15);
            Object r16 = r14;
        L9:
            this.L$0 = r16;
            this.label = 1;
            e r17 = (e) r16;
            r5 = r17.c(this);
            r13 = r17;
            if (r5 != r10) goto L13;
            return r10;
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            r16 = WidgetRuntimeBindingController.access$getCommands$p(this.this$0).iterator();
            goto L9
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0004\u0006\u0007\b\tR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0004\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController$Command;", "", "snapshot", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;", "getSnapshot", "()Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;", "Bind", "Unbind", "RegisterMessenger", "UnregisterMessenger", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController$Command$Bind;", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController$Command$RegisterMessenger;", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController$Command$Unbind;", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController$Command$UnregisterMessenger;", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Command {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController$Command$Bind;", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController$Command;", "snapshot", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;", "<init>", "(Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;)V", "getSnapshot", "()Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Bind implements Command {
            private final WidgetRuntimeBindingSnapshot snapshot;

            public Bind(WidgetRuntimeBindingSnapshot r5) {
                Intrinsics.checkNotNullParameter(r5, "snapshot");
                this.snapshot = r5;
            }

            public static /* synthetic */ Bind copy$default(Bind r5, WidgetRuntimeBindingSnapshot r10, int r11, Object r12) {
                if ((r11 & 1) == 0) goto L6;
                r10 = r5.snapshot;
            L6:
                return r5.copy(r10);
            }

            public final WidgetRuntimeBindingSnapshot component1() {
                return this.snapshot;
            }

            public final Bind copy(WidgetRuntimeBindingSnapshot r5) {
                Intrinsics.checkNotNullParameter(r5, "snapshot");
                return new Bind(r5);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof Bind) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.snapshot, ((Bind) r5).snapshot) == true) goto L11;
                return false;
            L11:
                return true;
            }

            @Override // com.obric.widget.host.runtime.WidgetRuntimeBindingController.Command
            public WidgetRuntimeBindingSnapshot getSnapshot() {
                return this.snapshot;
            }

            public int hashCode() {
                return this.snapshot.hashCode();
            }

            public String toString() {
                return "Bind(snapshot=" + this.snapshot + ")";
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController$Command$RegisterMessenger;", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController$Command;", "snapshot", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;", "messenger", "Landroid/os/Messenger;", "<init>", "(Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;Landroid/os/Messenger;)V", "getSnapshot", "()Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;", "getMessenger", "()Landroid/os/Messenger;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class RegisterMessenger implements Command {
            private final Messenger messenger;
            private final WidgetRuntimeBindingSnapshot snapshot;

            public RegisterMessenger(WidgetRuntimeBindingSnapshot r5, Messenger r10) {
                Intrinsics.checkNotNullParameter(r5, "snapshot");
                Intrinsics.checkNotNullParameter(r10, "messenger");
                this.snapshot = r5;
                this.messenger = r10;
            }

            public static /* synthetic */ RegisterMessenger copy$default(RegisterMessenger r5, WidgetRuntimeBindingSnapshot r10, Messenger r11, int r12, Object r13) {
                if ((r12 & 1) == 0) goto L6;
                r10 = r5.snapshot;
            L6:
                if ((r12 & 2) == 0) goto L9;
                r11 = r5.messenger;
            L9:
                return r5.copy(r10, r11);
            }

            public final WidgetRuntimeBindingSnapshot component1() {
                return this.snapshot;
            }

            public final Messenger component2() {
                return this.messenger;
            }

            public final RegisterMessenger copy(WidgetRuntimeBindingSnapshot r5, Messenger r10) {
                Intrinsics.checkNotNullParameter(r5, "snapshot");
                Intrinsics.checkNotNullParameter(r10, "messenger");
                return new RegisterMessenger(r5, r10);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof RegisterMessenger) == true) goto L8;
                return false;
            L8:
                RegisterMessenger r10 = (RegisterMessenger) r5;
                if (Intrinsics.areEqual(this.snapshot, r10.snapshot) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.messenger, r10.messenger) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final Messenger getMessenger() {
                return this.messenger;
            }

            @Override // com.obric.widget.host.runtime.WidgetRuntimeBindingController.Command
            public WidgetRuntimeBindingSnapshot getSnapshot() {
                return this.snapshot;
            }

            public int hashCode() {
                int r5 = this.snapshot.hashCode() * 31;
                return this.messenger.hashCode() + r5;
            }

            public String toString() {
                return "RegisterMessenger(snapshot=" + this.snapshot + ", messenger=" + this.messenger + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController$Command$Unbind;", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController$Command;", "snapshot", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;", "<init>", "(Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;)V", "getSnapshot", "()Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Unbind implements Command {
            private final WidgetRuntimeBindingSnapshot snapshot;

            public Unbind(WidgetRuntimeBindingSnapshot r5) {
                Intrinsics.checkNotNullParameter(r5, "snapshot");
                this.snapshot = r5;
            }

            public static /* synthetic */ Unbind copy$default(Unbind r5, WidgetRuntimeBindingSnapshot r10, int r11, Object r12) {
                if ((r11 & 1) == 0) goto L6;
                r10 = r5.snapshot;
            L6:
                return r5.copy(r10);
            }

            public final WidgetRuntimeBindingSnapshot component1() {
                return this.snapshot;
            }

            public final Unbind copy(WidgetRuntimeBindingSnapshot r5) {
                Intrinsics.checkNotNullParameter(r5, "snapshot");
                return new Unbind(r5);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof Unbind) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.snapshot, ((Unbind) r5).snapshot) == true) goto L11;
                return false;
            L11:
                return true;
            }

            @Override // com.obric.widget.host.runtime.WidgetRuntimeBindingController.Command
            public WidgetRuntimeBindingSnapshot getSnapshot() {
                return this.snapshot;
            }

            public int hashCode() {
                return this.snapshot.hashCode();
            }

            public String toString() {
                return "Unbind(snapshot=" + this.snapshot + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController$Command$UnregisterMessenger;", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController$Command;", "snapshot", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;", "<init>", "(Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;)V", "getSnapshot", "()Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class UnregisterMessenger implements Command {
            private final WidgetRuntimeBindingSnapshot snapshot;

            public UnregisterMessenger(WidgetRuntimeBindingSnapshot r5) {
                Intrinsics.checkNotNullParameter(r5, "snapshot");
                this.snapshot = r5;
            }

            public static /* synthetic */ UnregisterMessenger copy$default(UnregisterMessenger r5, WidgetRuntimeBindingSnapshot r10, int r11, Object r12) {
                if ((r11 & 1) == 0) goto L6;
                r10 = r5.snapshot;
            L6:
                return r5.copy(r10);
            }

            public final WidgetRuntimeBindingSnapshot component1() {
                return this.snapshot;
            }

            public final UnregisterMessenger copy(WidgetRuntimeBindingSnapshot r5) {
                Intrinsics.checkNotNullParameter(r5, "snapshot");
                return new UnregisterMessenger(r5);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof UnregisterMessenger) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.snapshot, ((UnregisterMessenger) r5).snapshot) == true) goto L11;
                return false;
            L11:
                return true;
            }

            @Override // com.obric.widget.host.runtime.WidgetRuntimeBindingController.Command
            public WidgetRuntimeBindingSnapshot getSnapshot() {
                return this.snapshot;
            }

            public int hashCode() {
                return this.snapshot.hashCode();
            }

            public String toString() {
                return "UnregisterMessenger(snapshot=" + this.snapshot + ")";
            }
        }

        WidgetRuntimeBindingSnapshot getSnapshot();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController$Companion;", "", "<init>", "()V", "TAG", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WidgetRuntimeBindingController(WidgetRuntimeClient r10, CoroutineScope r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "runtimeClient");
        Intrinsics.checkNotNullParameter(r11, "scope");
        Intrinsics.checkNotNullParameter(r12, "tag");
        this.runtimeClient = r10;
        this.tag = r12;
        this.commands = p.a(Integer.MAX_VALUE, 6, null);
        BuildersKt.launch$default(r11, Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
    }

    public static final /* synthetic */ void access$dispatch(WidgetRuntimeBindingController r5, Command r10) {
        r5.dispatch(r10);
    }

    public static final /* synthetic */ i access$getCommands$p(WidgetRuntimeBindingController r5) {
        return r5.commands;
    }

    private final void dispatch(Command r10) {
        if ((r10 instanceof Command.Bind) == false) goto L12;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L6
        Object r11 = Result.m124constructorimpl(Boolean.valueOf(WidgetRuntimeClient.dispatchWidgetBind$default(this.runtimeClient, ((Command.Bind) r10).getSnapshot().getAppletId(), ((Command.Bind) r10).getSnapshot().getWidgetId(), ((Command.Bind) r10).getSnapshot().getInstanceId(), null, 8, null)));     // Catch: Throwable -> L6
    L8:
        Throwable r12 = Result.m127exceptionOrNullimpl(r11);
        if (r12 == null) goto L49;
        Log.e(this.tag, "dispatchWidgetBind failed: snapshot=" + ((Command.Bind) r10).getSnapshot(), r12);
        return;
    L49:
        return;
    L6:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L8
    L12:
        if ((r10 instanceof Command.Unbind) == false) goto L21;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L15
        Object r15 = Result.m124constructorimpl(Boolean.valueOf(this.runtimeClient.dispatchWidgetUnbind(((Command.Unbind) r10).getSnapshot().getAppletId(), ((Command.Unbind) r10).getSnapshot().getWidgetId(), ((Command.Unbind) r10).getSnapshot().getInstanceId())));     // Catch: Throwable -> L15
    L17:
        Throwable r16 = Result.m127exceptionOrNullimpl(r15);
        if (r16 == null) goto L51;
        Log.e(this.tag, "dispatchWidgetUnbind failed: snapshot=" + ((Command.Unbind) r10).getSnapshot(), r16);
        return;
    L51:
        return;
    L15:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L17
    L21:
        if ((r10 instanceof Command.RegisterMessenger) == false) goto L30;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L24
        Object r19 = Result.m124constructorimpl(Boolean.valueOf(this.runtimeClient.registerWidgetMessenger(((Command.RegisterMessenger) r10).getSnapshot().getAppletId(), ((Command.RegisterMessenger) r10).getSnapshot().getWidgetId(), ((Command.RegisterMessenger) r10).getSnapshot().getInstanceId(), ((Command.RegisterMessenger) r10).getMessenger())));     // Catch: Throwable -> L24
    L26:
        Throwable r20 = Result.m127exceptionOrNullimpl(r19);
        if (r20 == null) goto L53;
        Log.e(this.tag, "registerWidgetMessenger failed: snapshot=" + ((Command.RegisterMessenger) r10).getSnapshot(), r20);
        return;
    L53:
        return;
    L24:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L26
    L30:
        if ((r10 instanceof Command.UnregisterMessenger) == false) goto L40;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L33
        Object r23 = Result.m124constructorimpl(Boolean.valueOf(this.runtimeClient.unregisterWidgetMessenger(((Command.UnregisterMessenger) r10).getSnapshot().getInstanceId(), ((Command.UnregisterMessenger) r10).getSnapshot().getAppletId(), ((Command.UnregisterMessenger) r10).getSnapshot().getWidgetId())));     // Catch: Throwable -> L33
    L35:
        Throwable r24 = Result.m127exceptionOrNullimpl(r23);
        if (r24 == null) goto L55;
        Log.e(this.tag, "unregisterWidgetMessenger failed: snapshot=" + ((Command.UnregisterMessenger) r10).getSnapshot(), r24);
        return;
    L55:
        return;
    L33:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r23 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L35
    L40:
        throw new NoWhenBranchMatchedException();
    }

    private final boolean enqueue(Command r5) {
        Object r10 = this.commands.g(r5);
        boolean r11 = r10 instanceof m;
        boolean r12 = !r11;
        if (r11 == false) goto L5;
        Log.e(this.tag, "enqueue runtime binding command failed: command=" + r5, n.a(r10));
    L5:
        return r12;
    }

    public final boolean bind(WidgetRuntimeBindingSnapshot r5) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        return enqueue(new Command.Bind(r5));
    }

    public final boolean registerMessenger(WidgetRuntimeBindingSnapshot r5, Messenger r10) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        Intrinsics.checkNotNullParameter(r10, "messenger");
        return enqueue(new Command.RegisterMessenger(r5, r10));
    }

    public final boolean unbind(WidgetRuntimeBindingSnapshot r5) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        return enqueue(new Command.Unbind(r5));
    }

    public final boolean unregisterMessenger(WidgetRuntimeBindingSnapshot r5) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        return enqueue(new Command.UnregisterMessenger(r5));
    }

    public /* synthetic */ WidgetRuntimeBindingController(WidgetRuntimeClient r5, CoroutineScope r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = TAG;
    L5:
        this(r5, r10, r11);
    }
}
