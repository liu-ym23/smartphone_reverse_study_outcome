package com.bytedance.android.annie.debug.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.annie.debug.AnnieDebugTool;
import com.bytedance.android.annie.debug.AnnieDebugTool$defaultImplNew$2;
import com.bytedance.android.annie.service.debug.DebugTatPosition;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends com.bytedance.android.annie.debug.ui.a {

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ d b;

        public a(View r1, d r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            AnnieDebugTool r11 = AnnieDebugTool.a;
            Context r12 = this.a.getContext();
            AnnieCard r0 = this.b.b;
            DebugTatPosition r1 = DebugTatPosition.TOP_RIGHT;
            Intrinsics.checkNotNullParameter(r12, "context");
            Intrinsics.checkNotNullParameter(r0, "annieCard");
            Intrinsics.checkNotNullParameter(r1, "position");
            Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L11
            List<c9.c> r14 = AnnieDebugTool.c.get(r1);     // Catch: Throwable -> L11
            if (r14 != null) goto L6;
        L8:
            ((AnnieDebugTool$defaultImplNew$2.a) AnnieDebugTool.d.getValue()).d(r12, r0);     // Catch: Throwable -> L11
        L9:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
            return;
        L6:
            if (r14.size() <= 0) goto L8;
            ((c9.c) ListProtector.get(r14, 0)).d(r12, r0);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    @Override // com.bytedance.android.annie.debug.ui.a
    public final FrameLayout.LayoutParams a() {
        FrameLayout.LayoutParams r0 = super.a();
        r0.gravity = 8388661;
        return r0;
    }

    @Override // com.bytedance.android.annie.debug.ui.a
    public final View c() {
        View r0 = super.c();
        r0.setOnClickListener(new a(r0, this));
        return r0;
    }

    public d(Context r10, AnnieCard r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "annieCard");
        super(r10, r11);
    }
}
