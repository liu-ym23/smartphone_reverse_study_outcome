package com.obric.miniapp.view;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Icons;
import com.bytedance.ai.resource.AppletResourceTool;
import com.obric.miniapp.databinding.MiniAppFragmentAboutBinding;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.view.MiniAppAboutFragment$initView$1$1$1", f = "MiniAppAboutFragment.kt", i = {0, 0}, l = {71}, m = "invokeSuspend", n = {"$this$withContext", "defaultDrawableId"}, s = {"L$0", "I$0"})
public final class MiniAppAboutFragment$initView$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Applet $applet;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MiniAppAboutFragment this$0;

    public MiniAppAboutFragment$initView$1$1$1(MiniAppAboutFragment r1, Applet r2, Continuation<? super MiniAppAboutFragment$initView$1$1$1> r3) {
        this.this$0 = r1;
        this.$applet = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MiniAppAboutFragment$initView$1$1$1 r0 = new MiniAppAboutFragment$initView$1$1$1(this.this$0, this.$applet, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        MiniAppFragmentAboutBinding r5 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$0;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r13);
    L30:
        Bitmap r14 = (Bitmap) r13;
        if (r14 == null) goto L36;
        MiniAppFragmentAboutBinding r4 = this.this$0.d;
        if (r4 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L35:
        r4.c.setImageBitmap(r14);
    L44:
        StringCompanionObject r15 = StringCompanionObject.INSTANCE;
        final String r16 = String.format("aweme://webview/?url=https://os.obriccloud.com/agreement/%s/privacy", Arrays.copyOf(new Object[]{StringsKt.replace$default(this.$applet.K, ".", "_", false, 4, null)}, 1));
        MiniAppFragmentAboutBinding r6 = this.this$0.d;
        if (r6 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L47:
        LinearLayout r7 = r6.d;
        final MiniAppAboutFragment r8 = this.this$0;
        r7.setOnClickListener(new a(r16, r8));
        MiniAppFragmentAboutBinding r17 = this.this$0.d;
        if (r17 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L51:
        ImageView r18 = r5.b;
        final MiniAppAboutFragment r9 = this.this$0;
        r18.setOnClickListener(new b(r9));
        return Unit.INSTANCE;
    L50:
        r5 = r17;
        goto L51
    L36:
        MiniAppFragmentAboutBinding r19 = this.this$0.d;
        if (r19 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L39:
        r19.c.setImageResource(r2);
        goto L44
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        CoroutineScope r110 = (CoroutineScope) this.L$0;
        MiniAppFragmentAboutBinding r10 = this.this$0.d;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L11:
        r10.e.setText(((AIPackage) this.$applet).a);
        MiniAppFragmentAboutBinding r11 = this.this$0.d;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L14:
        r11.f.setText(((AIPackage) this.$applet).e);
        Icons r12 = ((AIPackage) this.$applet).g;
        if (r12 == null) goto L17;
        String r20 = r12.get3x();
    L18:
        if (r20 != null) goto L20;
    L23:
        boolean r21 = true;
    L25:
        if (r21 == true) goto L40;
        AppletResourceTool r22 = AppletResourceTool.a;
        String r23 = ((AIPackage) this.$applet).x;
        this.L$0 = r110;
        this.I$0 = 2131243976;
        this.label = 1;
        r22.getClass();
        r13 = AppletResourceTool.r(r23, r20, this);
        if (r13 != r0) goto L29;
        return r0;
    L29:
        r2 = 2131243976;
        goto L30
    L40:
        MiniAppFragmentAboutBinding r111 = this.this$0.d;
        if (r111 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L43:
        r111.c.setImageResource(2131243976);
        goto L44
    L20:
        if (r20.length() == 0) goto L23;
        r21 = false;
        goto L25
    L17:
        r20 = null;
        goto L18
    }
}
