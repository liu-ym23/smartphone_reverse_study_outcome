package com.obric.miniapp.view;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.resource.AppletResourceTool;
import com.obric.miniapp.utils.MiniAppUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.view.MiniAppActionBar$onMiniAppShortcutClick$2", f = "MiniAppActionBar.kt", i = {0}, l = {240}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class MiniAppActionBar$onMiniAppShortcutClick$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ int $defaultDrawableId;
    final /* synthetic */ String $iconUrl;
    final /* synthetic */ Applet $targetApplet;
    private /* synthetic */ Object L$0;
    int label;

    public MiniAppActionBar$onMiniAppShortcutClick$2(Applet r1, String r2, Context r3, int r4, Continuation<? super MiniAppActionBar$onMiniAppShortcutClick$2> r5) {
        this.$targetApplet = r1;
        this.$iconUrl = r2;
        this.$context = r3;
        this.$defaultDrawableId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        MiniAppActionBar$onMiniAppShortcutClick$2 r6 = new MiniAppActionBar$onMiniAppShortcutClick$2(this.$targetApplet, this.$iconUrl, this.$context, this.$defaultDrawableId, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r20);
        Object r4 = r20;
    L11:
        Bitmap r9 = (Bitmap) r4;
        if (r9 == null) goto L14;
        Context r5 = this.$context;
        Applet r6 = this.$targetApplet;
        MiniAppUtils.b(MiniAppUtils.a, r5, r6.o(), 0, ((AIPackage) r6).a, 0, r9, 20);
    L16:
        return Unit.INSTANCE;
    L14:
        Context r12 = this.$context;
        Applet r7 = this.$targetApplet;
        int r8 = this.$defaultDrawableId;
        MiniAppUtils.b(MiniAppUtils.a, r12, r7.o(), 0, ((AIPackage) r7).a, r8, null, 36);
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        AppletResourceTool r11 = AppletResourceTool.a;
        String r13 = ((AIPackage) this.$targetApplet).x;
        String r14 = this.$iconUrl;
        this.L$0 = r10;
        this.label = 1;
        r11.getClass();
        r4 = AppletResourceTool.r(r13, r14, this);
        if (r4 != r1) goto L11;
        return r1;
    }
}
