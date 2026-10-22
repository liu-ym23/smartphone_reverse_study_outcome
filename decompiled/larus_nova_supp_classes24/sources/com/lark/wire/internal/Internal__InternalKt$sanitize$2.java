package com.lark.wire.internal;

import com.larksuite.component.blockit.sub_process.IP0SubProcess;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final /* synthetic */ class Internal__InternalKt$sanitize$2 extends FunctionReferenceImpl implements Function1<String, String> {
    public static final Internal__InternalKt$sanitize$2 INSTANCE = null;

    static {
        INSTANCE = new Internal__InternalKt$sanitize$2();
    }

    public Internal__InternalKt$sanitize$2() {
        super(1, b.class, "sanitize", "sanitize(Ljava/lang/String;)Ljava/lang/String;", 1);
    }

    public final String invoke(String r8) {
        Intrinsics.checkNotNullParameter(r8, IP0SubProcess.P0_PROCESS_NAME);
        Intrinsics.checkNotNullParameter(r8, "value");
        StringBuilder r1 = new StringBuilder(r8.length());
        int r2 = 0;
    L4:
        if (r2 >= r8.length()) goto L10;
        char r3 = r8.charAt(r2);
        if (StringsKt.contains$default(",[]{}\\", r3, false, 2, null) == false) goto L8;
        r1.append('\\');
    L8:
        r1.append(r3);
        r2 = r2 + 1;
        goto L4
    L10:
        return r1.toString();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
