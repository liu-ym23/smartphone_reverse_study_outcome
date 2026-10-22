package com.larus.avlink.gallery.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.social.utils.RepeatOnLifecycleKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.view.AlbumSyncBanner$observeStateChanges$1", f = "GallerySyncBanner.kt", i = {}, l = {743}, m = "invokeSuspend", n = {}, s = {})
final class AlbumSyncBanner$observeStateChanges$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AlbumSyncBanner this$0;

    /* JADX INFO: renamed from: com.larus.avlink.gallery.view.AlbumSyncBanner$observeStateChanges$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.view.AlbumSyncBanner$observeStateChanges$1$1", f = "GallerySyncBanner.kt", i = {}, l = {744}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AlbumSyncBanner this$0;

        /* JADX INFO: renamed from: com.larus.avlink.gallery.view.AlbumSyncBanner$observeStateChanges$1$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ AlbumSyncBanner a;

            public a(AlbumSyncBanner r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                AlbumSyncBanner r3 = this.a;
                AlbumSyncBanner.S5(r3, (y) r1);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(AlbumSyncBanner r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            AlbumSyncBanner r6 = this.this$0;
            kotlinx.coroutines.flow.b1 r2 = r6.b.b;
            a r3 = new a(r6);
            this.label = 1;
            if (r2.collect(r3, this) != r0) goto L12;
            return r0;
        }
    }

    public AlbumSyncBanner$observeStateChanges$1(AlbumSyncBanner r1, Continuation<? super AlbumSyncBanner$observeStateChanges$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AlbumSyncBanner$observeStateChanges$1(this.this$0, r3);
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
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        AlbumSyncBanner r8 = this.this$0;
        LifecycleOwner r2 = r8.c;
        if (r2 == null) goto L14;
        Lifecycle.State r3 = Lifecycle.State.STARTED;
        AnonymousClass1 r4 = new AnonymousClass1(r8, null);
        this.label = 1;
        if (RepeatOnLifecycleKt.b(r2, r3, r4, this) != r0) goto L14;
        return r0;
    }
}
