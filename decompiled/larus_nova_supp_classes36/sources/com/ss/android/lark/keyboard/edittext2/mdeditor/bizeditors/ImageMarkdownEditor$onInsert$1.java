package com.ss.android.lark.keyboard.edittext2.mdeditor.bizeditors;

import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkImageExtend;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import hob.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import okio.ByteString;
import v7b.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/coremdbiz/facade/bizext/props/LarkImageExtend;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class ImageMarkdownEditor$onInsert$1 extends Lambda implements Function1<LarkImageExtend, Unit> {
    final /* synthetic */ f $data;
    final /* synthetic */ int $height;
    final /* synthetic */ l $image;
    final /* synthetic */ int $width;

    public ImageMarkdownEditor$onInsert$1(l r1, int r2, int r3, f r4) {
        this.$image = r1;
        this.$width = r2;
        this.$height = r3;
        this.$data = r4;
        super(1);
    }

    public final void invoke(LarkImageExtend r7) {
        Intrinsics.checkNotNullParameter(r7, "$this$LarkImageExtend");
        l r0 = this.$image;
        int r1 = this.$width;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "<this>");
        c r3 = r7.c;
        KProperty[] r4 = LarkImageExtend.h;
        r3.setValue(r0, r4[0], Integer.valueOf(r1));
        l r2 = this.$image;
        int r5 = this.$height;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r7.d.setValue(r2, r4[1], Integer.valueOf(r5));
        com.ss.android.lark.widget.span.b.b.b r6 = this.$data.a;
        if ((r6 instanceof com.ss.android.lark.widget.span.b.b.b) == false) goto L6;
        l r8 = this.$image;
        ByteString r9 = r6.g;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        r7.f.setValue(r8, r4[3], r9);
        l r10 = this.$image;
        String r11 = this.$data.a.f;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r7.e.setValue(r10, r4[2], r11);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((LarkImageExtend) r1);
        return Unit.INSTANCE;
    }
}
