package com.ss.android.lark.keyboard.plugin.tool.aa;

import android.content.Context;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import oob.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/keyboard/plugin/tool/aa/widget/AaStylePluginContainer;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class AaStyleKBPlugin$subPluginContainer$2 extends Lambda implements Function0<b> {
    final /* synthetic */ AaStyleKBPlugin this$0;

    public AaStyleKBPlugin$subPluginContainer$2(AaStyleKBPlugin r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final b m1127invoke() {
        Context r1 = this.this$0.c;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r1 = null;
    L5:
        this.this$0.getClass();
        final AaStyleKBPlugin r4 = this.this$0;
        new b(r1, new AnonymousClass1(r4));
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1127invoke();
    }
}
