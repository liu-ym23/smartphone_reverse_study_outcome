package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.content.Context;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.table.entity.TableInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements com.ss.android.lark.coremd.base.parse.n.b<eab.h> {
    public final /* synthetic */ i a;

    public f(i r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.coremd.base.parse.n.b
    public final void a(final com.ss.android.lark.coremd.impl.parse.f r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        com.ss.android.lark.coremdbiz.facade.table.a r0 = (com.ss.android.lark.coremdbiz.facade.table.a) IMContextExtend.A.b(new MessageFullScreenClickPlugin$configureClick$1$5$factory$1(r5));
        if (r0 == null) goto L7;
        int r1 = com.ss.android.lark.coremdbiz.facade.table.d.a;
        TableInfo r6 = com.ss.android.lark.coremdbiz.facade.table.d.a(r5.h.getContext(), r0, (eab.h) r5.d);
        w4b.g r2 = ChatCoreModule.a().getChatDependency();
        Context r3 = this.a.a.getContext();
        i r4 = this.a;
        RichText r7 = r4.b;
        r4.a.d.getId();
        r2.y(r3, r6);
        return;
    }
}
