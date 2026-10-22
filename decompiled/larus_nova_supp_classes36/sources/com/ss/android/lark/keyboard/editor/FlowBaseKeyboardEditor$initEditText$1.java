package com.ss.android.lark.keyboard.editor;

import com.ss.android.lark.biz.im.api.j1;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.keyboard.edittext.FlowKeyboardFunctionEditText;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class FlowBaseKeyboardEditor$initEditText$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ b this$0;

    public FlowBaseKeyboardEditor$initEditText$1(b r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1049invoke() {
        Object r0 = this.this$0.c();
        RichText r2 = null;
        if ((r0 instanceof FlowKeyboardFunctionEditText) == false) goto L5;
        FlowKeyboardFunctionEditText r1 = (FlowKeyboardFunctionEditText) r0;
    L6:
        if (r1 == null) goto L9;
        r2 = FlowKeyboardFunctionEditText.i(r1);
    L9:
        if (com.ss.android.lark.widget.richtext.i.l(r2) == false) goto L12;
        Log.i("FlowBaseKeyboardEditor", "content is null, failed to send.");
        return;
    L12:
        b r3 = this.this$0;
        r3.getClass();
        r3.getClass();
        j1.a r4 = new j1.a();
        this.this$0.getClass();
        ((MessageParams.a) r4).c = null;
        r4.A = r2;
        ((MessageParams.a) r4).d = UUID.randomUUID().toString();
        Log.d("FlowBaseKeyboardEditor", "position is null, failed to send.");
        ImSdkService.f().sendMessage(r4.b(), new AnonymousClass1());
        this.this$0.c().setText("");
        return;
    L5:
        r1 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1049invoke();
        return Unit.INSTANCE;
    }
}
