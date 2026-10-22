package com.ss.android.lark.coremd.nonimbiz.calendar;

import com.ss.android.lark.coremd.base.parse.b;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lcom/ss/android/lark/coremd/nonimbiz/calendar/CalendarContextExtend;", "it", "Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class CalendarRichTextParserFactory$getContextCustomize$1$onConfigureContext$2 extends Lambda implements Function2<CalendarContextExtend, b, Unit> {
    final /* synthetic */ y6b.a<?> $messageVO;

    public CalendarRichTextParserFactory$getContextCustomize$1$onConfigureContext$2(y6b.a<?> r1) {
        this.$messageVO = r1;
        super(2);
    }

    public final void invoke(CalendarContextExtend r4, b r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$markdownContext");
        Intrinsics.checkNotNullParameter(r5, "it");
        if (this.$messageVO.x() == null) goto L5;
        boolean r0 = true;
    L6:
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r4.c.setValue(r5, CalendarContextExtend.d[0], Boolean.valueOf(r0));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((CalendarContextExtend) r1, (b) r2);
        return Unit.INSTANCE;
    }
}
