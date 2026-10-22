package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.bridge.Message;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.e0;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmEndWindowWebHelper$updateTheme$1", f = "MmEndWindowWebHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmEndWindowWebHelper$updateTheme$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isDarkMode;
    int label;
    final /* synthetic */ MmEndWindowWebHelper this$0;

    public MmEndWindowWebHelper$updateTheme$1(MmEndWindowWebHelper r1, boolean r2, Continuation<? super MmEndWindowWebHelper$updateTheme$1> r3) {
        this.this$0 = r1;
        this.$isDarkMode = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmEndWindowWebHelper$updateTheme$1(this.this$0, this.$isDarkMode, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r6);
        MmEndWindowWebHelper r7 = this.this$0;
        boolean r0 = this.$isDarkMode;
        r7.getClass();
        if (r0 == false) goto L7;
        String r1 = "dark";
    L8:
        MmThemeToJS r2 = new MmThemeToJS(r1);
        Message r3 = new Message();
        r3.setCallbackID("common.changeTheme");
        r3.setData(e0.c(r2));
        String r4 = e0.c(r3);
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        String r8 = String.format("LarkWebViewJavaScriptBridge.nativeCallBack(%s);", Arrays.copyOf(new Object[]{r4}, 1));
        int r9 = bwb.b.a;
        bwb.b.f(MmUiLogScene.WEB, "notifyWebThemeChanged", "script=" + r8, r7.f());
        OfficeWebView r10 = r7.g;
        if (r10 == null) goto L12;
        r10.evaluateJavascript(r8, null);
    L12:
        return Unit.INSTANCE;
    L7:
        r1 = "light";
        goto L8
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
