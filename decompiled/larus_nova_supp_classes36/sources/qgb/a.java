package qgb;

import android.content.Context;
import b3b.q;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.utils.r0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements q {
    public final v a;
    public final Context b;
    public final IMessageListViewModel c;
    public final m2b.a d;
    public final IMessageListComponent.f e;

    public final Context getContext() {
        return this.b;
    }

    public final void t(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "messageId");
        IMessageListViewModel r0 = this.c;
        if (r0 == null) goto L5;
        MessageInfo r5 = r0.getMessageInfoById(r3);
    L6:
        if (r5 != null) goto L9;
        return;
    L9:
        if (r0.e(this.a.f0(), r5.getMessage()) == false) goto L14;
        IMessageListComponent.f r1 = this.e;
        if (r1 == null) goto L15;
        r1.a(r5, r4);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public a(v r2, Context r3, IMessageListViewModel r4, m2b.a r5, IMessageListComponent.f r6) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
