package com.ss.android.lark.coremd.nonimbiz.calendar;

import com.ss.android.lark.coremd.base.parse.r;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lcom/ss/android/lark/coremd/nonimbiz/calendar/CalendarContextExtend;", "invoke", "(Lcom/ss/android/lark/coremd/nonimbiz/calendar/CalendarContextExtend;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class CalendarTextMarkdownPlugin$configureVisitor$1$showAbbrev$1 extends Lambda implements Function1<CalendarContextExtend, Boolean> {
    final /* synthetic */ r<a> $this_on;

    public CalendarTextMarkdownPlugin$configureVisitor$1$showAbbrev$1(r<a> r1) {
        this.$this_on = r1;
        super(1);
    }

    public final Boolean invoke(CalendarContextExtend r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$withExtend");
        r<a> r0 = this.$this_on;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "<this>");
        return Boolean.valueOf(((Boolean) r4.c.getValue(r0, CalendarContextExtend.d[0])).booleanValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((CalendarContextExtend) r1);
    }
}
