package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.blueprint.recyclerview.BlueprintCellViewHolder;
import com.ss.android.lark.chat.message.menu.v2.MessageActionPanelManager;
import com.ss.android.lark.widget.recyclerview.hive.HiveViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.e<y6b.c<?>> {
    public final /* synthetic */ MessageListMenuFeature a;

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.e
    public final boolean b() {
        s2b.c r0 = this.a.c;
        if (r0 == null) goto L10;
        MessageActionPanelManager<y6b.c<?>> r1 = r0.f;
        if (r1.h != null) goto L9;
        if (r1.i != null) goto L9;
        return false;
    L9:
        return true;
    L10:
        return false;
    }

    public c(MessageListMenuFeature r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.e
    public final View a(RecyclerView.ViewHolder r2, y6b.c r3) {
        Intrinsics.checkNotNullParameter(r2, "viewHolder");
        Intrinsics.checkNotNullParameter(r3, "item");
        if ((r2 instanceof BlueprintCellViewHolder) == false) goto L20;
        h3b.b r4 = ((BlueprintCellViewHolder) r2).a;
        if ((r4 instanceof h3b.b) == false) goto L7;
        h3b.b r5 = r4;
    L8:
        if (r5 == null) goto L26;
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.c r6 = r5.l();
        if ((r6 instanceof com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.c) == false) goto L13;
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.c r7 = r6;
    L14:
        if (r7 == null) goto L23;
        ViewGroup r8 = r7.k();
        if (r8 != null) goto L24;
        return null;
    L24:
        return r8;
    L23:
        return null;
    L13:
        r7 = null;
        goto L14
    L26:
        return null;
    L7:
        r5 = null;
        goto L8
    L20:
        if ((r2 instanceof HiveViewHolder) == true) goto L22;
        return null;
    L22:
        return r2.itemView.findViewById(2131365572);
    }
}
