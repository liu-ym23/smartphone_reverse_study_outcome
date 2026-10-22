package com.lark.kmp.storage.file;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class CommonFile$toStoragePath$subPath$1 extends Lambda implements Function1<String, Boolean> {
    public static final CommonFile$toStoragePath$subPath$1 INSTANCE = null;

    static {
        INSTANCE = new CommonFile$toStoragePath$subPath$1();
    }

    public CommonFile$toStoragePath$subPath$1() {
        super(1);
    }

    public final Boolean invoke(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        if (r2.length() <= 0) goto L5;
        boolean r3 = true;
    L7:
        return Boolean.valueOf(r3);
    L5:
        r3 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
