package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "list", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/MmSubtitleItem;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.MmSubtitleFragment$subscribeData$4", f = "MmSubtitleFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmSubtitleFragment$subscribeData$4 extends SuspendLambda implements Function2<List<? extends com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmSubtitleFragment this$0;

    public static final class a implements Runnable {
        public final /* synthetic */ MmSubtitleFragment a;

        public a(MmSubtitleFragment r1) {
            this.a = r1;
        }

        public final void a() {
            MmSubtitleFragment r0 = this.a;
            MmSubtitleScrollHelper r1 = r0.w;
            MmSubtitleAdapter r2 = null;
            if (r1 != null) goto L5;
        L11:
            MmSubtitleFragment r3 = this.a;
            if (r3.z == false) goto L14;
            return;
        L14:
            if (r3.o == null) goto L37;
            MmSubtitleAdapter r4 = r3.n;
            if (r4 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("subtitleAdapter");
        L21:
            if (r2.getItemCount() <= 0) goto L38;
            mwb.i r5 = r3.m;
            if (r5 == null) goto L36;
            RecyclerView r6 = r5.b;
            if (r6 == null) goto L39;
            ViewTreeObserver.OnPreDrawListener r7 = r3.A;
            if (r7 != null) goto L31;
        L33:
            o r8 = new o(r6, r3);
            r3.A = r8;
            r6.getViewTreeObserver().addOnPreDrawListener(r8);
            return;
        L31:
            if (r6.getViewTreeObserver().isAlive() == false) goto L33;
            r6.getViewTreeObserver().removeOnPreDrawListener(r7);
            goto L33
        L39:
            return;
        L36:
            return;
        L38:
            return;
        L19:
            r2 = r4;
            goto L21
        L37:
            return;
        L5:
            if (r0.x == true) goto L11;
            if (r1.b.getItemCount() != 0) goto L9;
            int r9 = bwb.b.a;
            bwb.b.g(MmUiLogScene.SUBTITLE, "scrollToBottomOnInitialized", "no data, skip", null, 8);
        L10:
            this.a.x = true;
            goto L11
        L9:
            r1.a.post(new v(r1));
            goto L10
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public MmSubtitleFragment$subscribeData$4(MmSubtitleFragment r1, Continuation<? super MmSubtitleFragment$subscribeData$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmSubtitleFragment$subscribeData$4 r0 = new MmSubtitleFragment$subscribeData$4(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((List) r1, (Continuation) r2);
    }

    public final Object invoke(List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        List r5 = (List) this.L$0;
        MmSubtitleAdapter r0 = this.this$0.n;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("subtitleAdapter");
        r0 = null;
    L7:
        a r1 = new a(this.this$0);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "list");
        if (r0.h.getCurrentList() != r5) goto L10;
        r1.run();
    L12:
        return Unit.INSTANCE;
    L10:
        r0.h.submitList(r5, r1);
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
