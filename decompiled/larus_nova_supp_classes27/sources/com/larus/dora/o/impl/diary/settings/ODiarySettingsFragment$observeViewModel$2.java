package com.larus.dora.o.impl.diary.settings;

import com.larus.dora.o.impl.databinding.DoraOFragmentDiarySettingsBinding;
import com.obric.oui.lisitem.OCardListItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.o.impl.diary.settings.ODiarySettingsFragment$observeViewModel$2", f = "ODiarySettingsFragment.kt", i = {}, l = {141}, m = "invokeSuspend", n = {}, s = {})
final class ODiarySettingsFragment$observeViewModel$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ODiarySettingsFragment this$0;

    /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.settings.ODiarySettingsFragment$observeViewModel$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "name", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.diary.settings.ODiarySettingsFragment$observeViewModel$2$1", f = "ODiarySettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ODiarySettingsFragment this$0;

        public AnonymousClass1(ODiarySettingsFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((String) r1, (Continuation) r2);
        }

        public final Object invoke(String r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L22;
            ResultKt.throwOnFailure(r5);
            String r6 = (String) this.L$0;
            DoraOFragmentDiarySettingsBinding r0 = this.this$0.d;
            if (r0 == null) goto L20;
            OCardListItem r1 = r0.e;
            if (r1 == null) goto L20;
            if (r6 != null) goto L11;
        L14:
            boolean r3 = true;
        L15:
            if (r3 == false) goto L17;
            String r7 = "";
        L18:
            int r2 = OCardListItem.I;
            r1.k(r7, -1);
            goto L20
        L17:
            r7 = this.this$0.getString(2131903412, new Object[]{r6});
            Intrinsics.checkNotNull(r7);
            goto L18
        L11:
            if (r6.length() == 0) goto L14;
            r3 = false;
        L20:
            return Unit.INSTANCE;
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ODiarySettingsFragment$observeViewModel$2(ODiarySettingsFragment r1, Continuation<? super ODiarySettingsFragment$observeViewModel$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ODiarySettingsFragment$observeViewModel$2(this.this$0, r3);
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
        ODiarySettingsFragment r7 = this.this$0;
        int r2 = ODiarySettingsFragment.g;
        i1<String> r8 = r7.S90().getStyleName();
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r8, r3, this) != r0) goto L12;
        return r0;
    }
}
