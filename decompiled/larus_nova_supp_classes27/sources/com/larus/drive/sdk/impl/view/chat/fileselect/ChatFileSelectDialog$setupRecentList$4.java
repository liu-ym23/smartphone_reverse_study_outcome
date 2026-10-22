package com.larus.drive.sdk.impl.view.chat.fileselect;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.larus.drive.sdk.impl.databinding.LarusDialogChatFileSelectBinding;
import com.larus.drive.sdk.impl.view.chat.fileselect.adapter.ChatRecentFileSelectAdapter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.view.chat.fileselect.ChatFileSelectDialog$setupRecentList$4", f = "ChatFileSelectDialog.kt", i = {}, l = {356}, m = "invokeSuspend", n = {}, s = {})
final class ChatFileSelectDialog$setupRecentList$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LarusDialogChatFileSelectBinding $binding;
    int label;
    final /* synthetic */ ChatFileSelectDialog this$0;

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.view.chat.fileselect.ChatFileSelectDialog$setupRecentList$4$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.view.chat.fileselect.ChatFileSelectDialog$setupRecentList$4$1", f = "ChatFileSelectDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LarusDialogChatFileSelectBinding $binding;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ChatFileSelectDialog this$0;

        /* JADX INFO: renamed from: com.larus.drive.sdk.impl.view.chat.fileselect.ChatFileSelectDialog$setupRecentList$4$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.drive.sdk.impl.view.chat.fileselect.ChatFileSelectDialog$setupRecentList$4$1$1", f = "ChatFileSelectDialog.kt", i = {}, l = {358}, m = "invokeSuspend", n = {}, s = {})
        public static final class C01141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ LarusDialogChatFileSelectBinding $binding;
            int label;
            final /* synthetic */ ChatFileSelectDialog this$0;

            /* JADX INFO: renamed from: com.larus.drive.sdk.impl.view.chat.fileselect.ChatFileSelectDialog$setupRecentList$4$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006H\n"}, d2 = {"<anonymous>", "", "map", "Ljava/util/LinkedHashMap;", "", "Lcom/larus/platform/api/FlowSelectedFileItem;", "Lkotlin/collections/LinkedHashMap;"}, k = 3, mv = {2, 1, 0}, xi = 48)
            @DebugMetadata(c = "com.larus.drive.sdk.impl.view.chat.fileselect.ChatFileSelectDialog$setupRecentList$4$1$1$1", f = "ChatFileSelectDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C01151 extends SuspendLambda implements Function2<LinkedHashMap<String, com.larus.platform.api.u>, Continuation<? super Unit>, Object> {
                final /* synthetic */ LarusDialogChatFileSelectBinding $binding;
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ ChatFileSelectDialog this$0;

                public C01151(LarusDialogChatFileSelectBinding r1, ChatFileSelectDialog r2, Continuation<? super C01151> r3) {
                    this.$binding = r1;
                    this.this$0 = r2;
                    super(2, r3);
                }

                public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                    C01151 r0 = new C01151(this.$binding, this.this$0, r5);
                    r0.L$0 = r4;
                    return r0;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                    return invoke((LinkedHashMap) r1, (Continuation) r2);
                }

                public final Object invoke(LinkedHashMap<String, com.larus.platform.api.u> r1, Continuation<? super Unit> r2) {
                    return create(r1, r2).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object r6) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L25;
                    ResultKt.throwOnFailure(r6);
                    LinkedHashMap r7 = (LinkedHashMap) this.L$0;
                    this.$binding.f.setSelectedList(CollectionsKt.toList(r7.values()));
                    ChatRecentFileSelectAdapter r0 = this.this$0.k;
                    if (r0 == null) goto L23;
                    Set r8 = r7.keySet();
                    Intrinsics.checkNotNullParameter(r8, "newSelectedIds");
                    LinkedHashSet r1 = new LinkedHashSet();
                    r1.addAll(r0.a);
                    Set r2 = r8;
                    r1.addAll(r2);
                    r1.removeAll(CollectionsKt.intersect(r0.a, r8));
                    if (r1.isEmpty() == true) goto L23;
                    r0.a.clear();
                    r0.a.addAll(r2);
                    Iterator r9 = r1.iterator();
                L11:
                    if (r9.hasNext() == false) goto L23;
                    String r3 = (String) r9.next();
                    Iterator r4 = r0.getCurrentList().iterator();
                    int r5 = 0;
                L14:
                    if (r4.hasNext() == false) goto L19;
                    if (Intrinsics.areEqual(((x79.a) r4.next()).a, r3) == true) goto L20;
                    r5 = r5 + 1;
                L20:
                    if (r5 < 0) goto L11;
                    r0.notifyItemChanged(r5);
                    goto L11
                L19:
                    r5 = -1;
                L23:
                    return Unit.INSTANCE;
                L25:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            public C01141(ChatFileSelectDialog r1, LarusDialogChatFileSelectBinding r2, Continuation<? super C01141> r3) {
                this.this$0 = r1;
                this.$binding = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C01141(this.this$0, this.$binding, r4);
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
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r7);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r7);
                ChatFileSelectDialog r8 = this.this$0;
                StateFlowImpl r2 = r8.l.e;
                C01151 r3 = new C01151(this.$binding, r8, null);
                this.label = 1;
                if (kotlinx.coroutines.flow.e.i(r2, r3, this) != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: renamed from: com.larus.drive.sdk.impl.view.chat.fileselect.ChatFileSelectDialog$setupRecentList$4$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.drive.sdk.impl.view.chat.fileselect.ChatFileSelectDialog$setupRecentList$4$1$2", f = "ChatFileSelectDialog.kt", i = {}, l = {364}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ChatFileSelectDialog this$0;

            /* JADX INFO: renamed from: com.larus.drive.sdk.impl.view.chat.fileselect.ChatFileSelectDialog$setupRecentList$4$1$2$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "flags", "Lcom/larus/platform/api/fileselect/SelectionFlags;"}, k = 3, mv = {2, 1, 0}, xi = 48)
            @DebugMetadata(c = "com.larus.drive.sdk.impl.view.chat.fileselect.ChatFileSelectDialog$setupRecentList$4$1$2$1", f = "ChatFileSelectDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C01161 extends SuspendLambda implements Function2<aq9.e, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ ChatFileSelectDialog this$0;

                public C01161(ChatFileSelectDialog r1, Continuation<? super C01161> r2) {
                    this.this$0 = r1;
                    super(2, r2);
                }

                public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                    C01161 r0 = new C01161(this.this$0, r4);
                    r0.L$0 = r3;
                    return r0;
                }

                public final Object invoke(aq9.e r1, Continuation<? super Unit> r2) {
                    return create(r1, r2).invokeSuspend(Unit.INSTANCE);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                    return invoke((aq9.e) r1, (Continuation) r2);
                }

                public final Object invokeSuspend(Object r3) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L17;
                    ResultKt.throwOnFailure(r3);
                    aq9.e r4 = (aq9.e) this.L$0;
                    Boolean r0 = this.this$0.m;
                    if (r0 != null) goto L7;
                L8:
                    ChatFileSelectDialog r1 = this.this$0;
                    r1.m = Boxing.boxBoolean(r4.b);
                    ChatRecentFileSelectAdapter r5 = this.this$0.k;
                    if (r5 == null) goto L15;
                    int r2 = r5.getItemCount();
                    if (r2 <= 0) goto L15;
                    r5.notifyItemRangeChanged(0, r2);
                L15:
                    return Unit.INSTANCE;
                L7:
                    if (Intrinsics.areEqual(r0, Boxing.boxBoolean(r4.b)) == true) goto L15;
                L17:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            public AnonymousClass2(ChatFileSelectDialog r1, Continuation<? super AnonymousClass2> r2) {
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

            public final Object invokeSuspend(Object r6) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r6);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r6);
                ChatFileSelectDialog r7 = this.this$0;
                StateFlowImpl r2 = r7.l.f;
                C01161 r3 = new C01161(r7, null);
                this.label = 1;
                if (kotlinx.coroutines.flow.e.i(r2, r3, this) != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass1(ChatFileSelectDialog r1, LarusDialogChatFileSelectBinding r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$binding = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$binding, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r8);
            CoroutineScope r9 = (CoroutineScope) this.L$0;
            BuildersKt.launch$default(r9, null, null, new C01141(this.this$0, this.$binding, null), 3, null);
            BuildersKt.launch$default(r9, null, null, new AnonymousClass2(this.this$0, null), 3, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatFileSelectDialog$setupRecentList$4(ChatFileSelectDialog r1, LarusDialogChatFileSelectBinding r2, Continuation<? super ChatFileSelectDialog$setupRecentList$4> r3) {
        this.this$0 = r1;
        this.$binding = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatFileSelectDialog$setupRecentList$4(this.this$0, this.$binding, r4);
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
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        LifecycleOwner r9 = this.this$0.getViewLifecycleOwner();
        Lifecycle.State r2 = Lifecycle.State.STARTED;
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, this.$binding, null);
        this.label = 1;
        if (RepeatOnLifecycleKt.repeatOnLifecycle(r9, r2, r3, this) != r0) goto L12;
        return r0;
    }
}
