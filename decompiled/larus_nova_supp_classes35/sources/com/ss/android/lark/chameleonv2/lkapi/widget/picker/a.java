package com.ss.android.lark.chameleonv2.lkapi.widget.picker;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.android.file.picker.lib.FilePickerParams;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$FilePickerShowOptions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends AbsChameleonHandler<IWidget$FilePickerShowOptions> {
    public Callback a;
    public final String b;

    /* JADX INFO: renamed from: com.ss.android.lark.chameleonv2.lkapi.widget.picker.a$a, reason: collision with other inner class name */
    public static final class C0026a {
    }

    static {
    }

    public a() {
        this.b = LKAPIModules.Widget.ShowFilePicker.getValue();
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final String getName() {
        return this.b;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final void handle(IWidget$FilePickerShowOptions r21, Callback r22) {
        IWidget$FilePickerShowOptions r1 = r21;
        Intrinsics.checkNotNullParameter(r1, "req");
        Intrinsics.checkNotNullParameter(r22, "callback");
        IChameleonHandlerContext r2 = getContext();
        if (r2 == null) goto L13;
        Fragment r3 = r2.getFragment();
        if (r3 == null) goto L13;
        com.bytedance.ee.android.file.picker.lib.b r4 = new com.bytedance.ee.android.file.picker.lib.b();
        if (r1.getTitle() == null) goto L10;
        String r5 = r1.getTitle();
        Intrinsics.checkNotNullParameter(r5, "value");
        r4.d = r5;
    L10:
        if (r1.getConfirmText() == null) goto L12;
        String r6 = r1.getConfirmText();
        Intrinsics.checkNotNullParameter(r6, "value");
        r4.e = r6;
    L12:
        r4.c = r1.getMaxSelectedCount();
        r4.f = r1.getShowSystemPicker();
        this.a = r22;
        com.bytedance.ee.android.file.picker.lib.a.c(r3, 96, new FilePickerParams(r4.a, r4.b, r4.c, null, null, r4.d, r4.e, r4.f, r4.g, null, false, null, null));
        return;
    L13:
        r22.error(new LKAPIError(-1, "fragment is null"));
    }
}
