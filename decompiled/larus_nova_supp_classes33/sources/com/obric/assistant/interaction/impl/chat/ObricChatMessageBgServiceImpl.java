package com.obric.assistant.interaction.impl.chat;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.bmhome.chat.layout.item.i;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.obric.assistant.spi.chat.IObricChatMessageBgService;
import fea.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/assistant/interaction/impl/chat/ObricChatMessageBgServiceImpl;", "Lcom/obric/assistant/spi/chat/IObricChatMessageBgService;", "<init>", "()V", "configNestedFileViewBackground", "", "nestedFileView", "Landroid/view/View;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatMessageBgServiceImpl implements IObricChatMessageBgService {
    public ObricChatMessageBgServiceImpl() {
    }

    public static /* synthetic */ void a(View r0) {
        configNestedFileViewBackground$lambda$0(r0);
    }

    private static final void configNestedFileViewBackground$lambda$0(View r3) {
        r3.setBackgroundResource(0);
        i r4 = r3.getParent();
        if ((r4 instanceof ViewGroup) == false) goto L5;
        ViewGroup r5 = (ViewGroup) r4;
    L6:
        if (r5 == null) goto L23;
        if ((r5 instanceof i) == true) goto L9;
        ViewParent r6 = r5.getParent();
        if ((r6 instanceof ViewGroup) == false) goto L5;
        r5 = (ViewGroup) r6;
        goto L6
    L5:
        r5 = null;
        goto L6
    L9:
        ((i) r5).setBackgroundResource(0);
        return;
    L23:
        return;
    L14:
        r5 = null;
        goto L6
    }

    @Override // com.obric.assistant.spi.chat.IObricChatMessageBgService
    public void configNestedFileViewBackground(final View r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (IWindowContextKt.isWindowContext(r2.getContext()) == false) goto L8;
        r2.post(new a(r2));
        return;
    }
}
