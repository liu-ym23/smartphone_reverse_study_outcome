package com.larus.bmhome.bot;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$iconEditItemLoad$1$1", f = "CommonSettingFragment.kt", i = {}, l = {4228, 4236}, m = "invokeSuspend", n = {}, s = {})
public final class CommonSettingFragment$iconEditItemLoad$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.setting.c $this_run;
    final /* synthetic */ String $url;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.bot.CommonSettingFragment$iconEditItemLoad$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$iconEditItemLoad$1$1$1", f = "CommonSettingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ com.larus.bmhome.setting.c $this_run;
        int label;

        public AnonymousClass1(com.larus.bmhome.setting.c r1, Bitmap r2, Continuation<? super AnonymousClass1> r3) {
            this.$this_run = r1;
            this.$bitmap = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$this_run, this.$bitmap, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r2);
            this.$this_run.X().getImageView().setScaleType(ImageView.ScaleType.FIT_XY);
            if (this.$bitmap == null) goto L7;
            this.$this_run.X().getImageView().setImageBitmap(this.$bitmap);
        L9:
            return Unit.INSTANCE;
        L7:
            this.$this_run.X().getImageView().setImageResource(2131240119);
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CommonSettingFragment$iconEditItemLoad$1$1(String r1, com.larus.bmhome.setting.c r2, Continuation<? super CommonSettingFragment$iconEditItemLoad$1$1> r3) {
        this.$url = r1;
        this.$this_run = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CommonSettingFragment$iconEditItemLoad$1$1(this.$url, this.$this_run, r4);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L13:
        Bitmap r11 = (Bitmap) r10;
        if (r11 == null) goto L16;
        int r2 = r11.getHeight();
    L17:
        Bitmap r12 = com.larus.bmhome.chat.map.c.a(r11, r2 / 2.0f);
        MainCoroutineDispatcher r3 = Dispatchers.getMain().getImmediate();
        AnonymousClass1 r4 = new AnonymousClass1(this.$this_run, r12, null);
        this.label = 2;
        if (BuildersKt.withContext(r3, r4, this) != r0) goto L21;
        return r0;
    L16:
        r2 = c7.b(Boxing.boxInt(32));
        goto L17
    L10:
        ResultKt.throwOnFailure(r10);
        String r13 = this.$url;
        Bitmap.Config r5 = Bitmap.Config.ARGB_8888;
        Function1 r6 = new c5();
        this.label = 1;
        r10 = ImageLoaderKt.n(r13, "change_app_icon", r5, r6, this, 28);
        if (r10 != r0) goto L13;
        return r0;
    }
}
