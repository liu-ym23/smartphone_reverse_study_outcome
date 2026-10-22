package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import android.net.Uri;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bot.impl.databinding.LarusPageBotEditAvatarPreviewBinding;
import com.larus.bot.impl.feature.edit.feature.bgimage.preview.widget.BotBgImagePreviewView;
import com.larus.settings.value.e10;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
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
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewFragment$bindObservers$1", f = "BotEditAvatarPreviewFragment.kt", i = {}, l = {513}, m = "invokeSuspend", n = {}, s = {})
final class BotEditAvatarPreviewFragment$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BotEditAvatarPreviewFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ BotEditAvatarPreviewFragment a;

        public a(BotEditAvatarPreviewFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r18, Continuation r19) {
            y r0 = (y) r18;
            final BotEditAvatarPreviewFragment r2 = this.a;
            final LarusPageBotEditAvatarPreviewBinding r3 = r2.e;
            if (r3 == null) goto L43;
            FLogger r4 = FLogger.a;
            StringBuilder r5 = new StringBuilder("disableCache = ");
            Uri r6 = r0.b.a;
            if (r6 != null) goto L7;
        L9:
            boolean r7 = false;
        L10:
            r5.append(r7);
            r4.i("refreshState", r5.toString());
            if (r0.b.a != null) goto L13;
            e1.x(r3.d);
            e1.o(r3.c);
        L14:
            SimpleDraweeView r9 = r3.b;
            Uri r10 = r0.b.a;
            if (r10 != null) goto L17;
        L19:
            boolean r12 = false;
        L20:
            com.larus.bot.impl.common.util.h.b(r9, r10, "bot_edit_avatar_preview_refresh", r12, null, null, new d(r2, r3), 56);
            r4.d("BotEditAvatarPreviewFragment", "disable: " + r0.a);
            BotBgImagePreviewView r8 = r3.e;
            Uri r11 = r0.c.a;
            if (r11 != null) goto L23;
        L25:
            boolean r13 = false;
        L26:
            com.larus.bot.impl.common.util.h.a(r8.d.e, r11, "bot_bg_image_preview", r13, null, null, false, new e(r2, r3));
            boolean r14 = r3.g.isChecked();
            boolean r15 = r0.e;
            if (r14 == r15) goto L30;
            r3.g.setChecked(r15);
        L30:
            if (r0.e == false) goto L33;
            r3.e.setAlpha(1.0f);
        L35:
            r3.f.setEnabled(!r0.a);
            r3.i.setEnabled(!r0.a);
            r3.g.setEnabled(!r0.a);
            r3.h.setEnabled(!r0.a);
            if (r0.a == false) goto L38;
            r3.h.setAlpha(0.3f);
            r3.f.setAlpha(0.3f);
            r3.i.setAlpha(0.3f);
        L39:
            e10 r1 = e10.a;
            if (e10.B0() == false) goto L43;
            e1.o(r3.f);
            goto L43
        L38:
            r3.h.setAlpha(1.0f);
            r3.f.setAlpha(1.0f);
            r3.i.setAlpha(1.0f);
            goto L39
        L33:
            if (r0.a == true) goto L35;
            r3.e.setAlpha(0.3f);
            goto L35
        L23:
            if (true != BotEditAvatarPreviewFragment.Y90(r11)) goto L25;
            r13 = true;
            goto L26
        L17:
            if (true != BotEditAvatarPreviewFragment.Y90(r10)) goto L19;
            r12 = true;
            goto L20
        L13:
            e1.o(r3.d);
            goto L14
        L7:
            if (true != BotEditAvatarPreviewFragment.Y90(r6)) goto L9;
            r7 = true;
        L43:
            return Unit.INSTANCE;
        }
    }

    public BotEditAvatarPreviewFragment$bindObservers$1(BotEditAvatarPreviewFragment r1, Continuation<? super BotEditAvatarPreviewFragment$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotEditAvatarPreviewFragment$bindObservers$1(this.this$0, r3);
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
        BotEditAvatarPreviewFragment r6 = this.this$0;
        int r2 = BotEditAvatarPreviewFragment.p;
        i1<y> r7 = r6.X90().getUiState();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
