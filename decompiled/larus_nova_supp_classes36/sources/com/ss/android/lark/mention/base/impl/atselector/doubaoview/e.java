package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.atselector.IItemContainer;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements IItemContainer.a {
    public final /* synthetic */ DoubaoMentionPanelView a;

    @Override // com.ss.android.lark.mention.base.impl.atselector.IItemContainer.a
    public final void a(BaseAtBean r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.IItemContainer.a
    public final void b(BaseAtBean r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    public e(DoubaoMentionPanelView r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.IItemContainer.a
    public final void c(BaseAtBean r5) {
        Intrinsics.checkNotNullParameter(r5, "item");
        Log.i("DoubaoMentionPanelView", "onSinglePick itemClass=" + r5.getClass().getSimpleName() + ", viewHash=" + System.identityHashCode(this.a));
        DoubaoMentionPanelView r0 = this.a;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L20
        DoubaoMentionViewModel r3 = r0.e;     // Catch: Throwable -> L20
        boolean r4 = false;
        if (r3 != null) goto L6;
    L8:
        if (r4 == true) goto L10;
        Log.i("DoubaoMentionPanelView", "onSinglePick ignored by Doubao mention policy");     // Catch: Throwable -> L20
    L18:
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L28;
        Log.e("DoubaoMentionPanelView", "onSinglePick failed", r7);
        return;
    L28:
        return;
    L10:
        DoubaoMentionPanelView.c r8 = r0.d;     // Catch: Throwable -> L20
        if (r8 == null) goto L17;
        DoubaoMentionViewModel r9 = r0.e;     // Catch: Throwable -> L20
        if (r9 == null) goto L15;
        Map<String, ChatChatter> r10 = r9.getSelectedResult();     // Catch: Throwable -> L20
    L16:
        r8.a(r10);     // Catch: Throwable -> L20
        goto L17
    L15:
        r10 = null;
    L17:
        r0.b();     // Catch: Throwable -> L20
        goto L18
    L6:
        if (r3.setSelectedResult(r5) != true) goto L8;
        r4 = true;
    L20:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }
}
