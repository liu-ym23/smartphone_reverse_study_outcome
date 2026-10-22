package com.larus.drive.sdk.impl.utils;

import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.drive.sdk.api.file.DriveFileItem;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.utils.MorePanelHelper$refreshShareMenuItem$1", f = "MorePanelHelper.kt", i = {}, l = {198, 205}, m = "invokeSuspend", n = {}, s = {})
public final class MorePanelHelper$refreshShareMenuItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DriveFileItem $driveFile;
    final /* synthetic */ CommonMenu $menu;
    final /* synthetic */ l0 $shareItem;
    int label;

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.utils.MorePanelHelper$refreshShareMenuItem$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.utils.MorePanelHelper$refreshShareMenuItem$1$1", f = "MorePanelHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CommonMenu $menu;
        final /* synthetic */ l0 $shareItem;
        int label;

        public AnonymousClass1(CommonMenu r1, l0 r2, Continuation<? super AnonymousClass1> r3) {
            this.$menu = r1;
            this.$shareItem = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$menu, this.$shareItem, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r6);
            this.$menu.update(l0.b(this.$shareItem, 0, null, true, -65537));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MorePanelHelper$refreshShareMenuItem$1(DriveFileItem r1, CommonMenu r2, l0 r3, Continuation<? super MorePanelHelper$refreshShareMenuItem$1> r4) {
        this.$driveFile = r1;
        this.$menu = r2;
        this.$shareItem = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MorePanelHelper$refreshShareMenuItem$1(this.$driveFile, this.$menu, this.$shareItem, r5);
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
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L14:
        if (((Boolean) r7).booleanValue() == true) goto L16;
        MainCoroutineDispatcher r8 = Dispatchers.getMain().getImmediate();
        AnonymousClass1 r2 = new AnonymousClass1(this.$menu, this.$shareItem, null);
        this.label = 2;
        if (BuildersKt.withContext(r8, r2, this) != r0) goto L21;
        return r0;
    L16:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r7);
        Lazy r9 = MorePanelHelper.a;
        e89.c r10 = MorePanelHelper.c();
        DriveFileItem r3 = this.$driveFile;
        String r4 = r3.b;
        int r5 = r3.d;
        this.label = 1;
        r7 = r10.n(r4, r5, this);
        if (r7 != r0) goto L14;
        return r0;
    }
}
