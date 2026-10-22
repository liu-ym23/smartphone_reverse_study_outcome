package e4b;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.select.MessageListMultiSelectFeature$initMultiSelector$multiSelector$1;
import com.ss.android.lark.widget.recyclerview.MultiSelector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements MultiSelector.a {
    public final /* synthetic */ b a;
    public final /* synthetic */ MessageListMultiSelectFeature$initMultiSelector$multiSelector$1 b;

    public final void onStatusChanged(boolean r1) {
    }

    public final void a() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.a.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L5:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r1 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a) r0.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.class);
        if (r1 == null) goto L9;
        r1.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.c0(((MultiSelector) this.b).b.size()));
        return;
    }

    public c(b r1, MessageListMultiSelectFeature$initMultiSelector$multiSelector$1 r2) {
        this.a = r1;
        this.b = r2;
    }
}
