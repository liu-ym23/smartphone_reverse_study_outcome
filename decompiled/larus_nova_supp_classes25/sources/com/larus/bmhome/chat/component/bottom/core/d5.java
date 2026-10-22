package com.larus.bmhome.chat.component.bottom.core;

import androidx.appcompat.widget.AppCompatImageView;
import com.larus.bmhome.chat.model.ChatDraftItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import oaa.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d5 implements Function1 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ d5(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r7) {
        CoreInputComponent r0 = this.a;
        int r1 = CoreInputComponent.d3;
        Intrinsics.checkNotNullParameter((AppCompatImageView) r7, "it");
        maa.e r8 = (maa.e) r0.S.getValue();
        if (r8 == null) goto L5;
        maa.e.a.a(r8, null, null, false, 7);
        r8.v50("click ime button");
    L5:
        r0.k4().Wy(ChatDraftItem.TYPE_TEXT, de8.d.a(r0.f1()), null);
        r0.k4().BU(false, true, "");
        a r9 = r0.v4();
        if (r9 == null) goto L9;
        r9.V8();
    L9:
        return Unit.INSTANCE;
    }
}
