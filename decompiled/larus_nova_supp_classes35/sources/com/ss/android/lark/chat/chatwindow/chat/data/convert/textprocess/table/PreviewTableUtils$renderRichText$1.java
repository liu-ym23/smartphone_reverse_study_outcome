package com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.table;

import android.content.Context;
import com.ss.android.lark.widget.light.viewstub.e;
import com.ss.android.lark.widget.light.viewstub.f;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/widget/light/viewstub/SpanViewCoordinator;", "it", "Landroid/content/Context;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class PreviewTableUtils$renderRichText$1 extends Lambda implements Function1<Context, f> {
    final /* synthetic */ Context $context;

    public PreviewTableUtils$renderRichText$1(Context r1) {
        this.$context = r1;
        super(1);
    }

    public final f invoke(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        f.a r3 = f.a;
        Context r0 = this.$context;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r0, "context");
        return new e(r0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Context) r1);
    }
}
