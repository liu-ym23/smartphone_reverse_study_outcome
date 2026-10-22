package com.ss.android.lark.coremd.facade.mdeditor.plugins;

import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.facade.bizext.props.IMMediaExtend;
import eab.f;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/coremd/facade/mdeditor/media/DraftMediaUploadSpan;", "Lcom/ss/android/lark/coremd/facade/bizext/props/IMMediaExtend;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IMEditorMediaPlugin$configureSpanFactory$1$draftMediaUploadSpan$1 extends Lambda implements Function1<IMMediaExtend, com.ss.android.lark.coremd.facade.mdeditor.media.a> {
    final /* synthetic */ f $node;

    public IMEditorMediaPlugin$configureSpanFactory$1$draftMediaUploadSpan$1(f r1) {
        this.$node = r1;
        super(1);
    }

    public final com.ss.android.lark.coremd.facade.mdeditor.media.a invoke(IMMediaExtend r7) {
        Intrinsics.checkNotNullParameter(r7, "$this$IMMediaExtend");
        f r1 = this.$node;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        c r3 = r7.n;
        KProperty<Object>[] r4 = IMMediaExtend.r;
        String r2 = (String) r3.getValue(r1, r4[11]);
        f r5 = this.$node;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new com.ss.android.lark.coremd.facade.mdeditor.media.a(r2, (String) r7.o.getValue(r5, r4[12]));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((IMMediaExtend) r1);
    }
}
