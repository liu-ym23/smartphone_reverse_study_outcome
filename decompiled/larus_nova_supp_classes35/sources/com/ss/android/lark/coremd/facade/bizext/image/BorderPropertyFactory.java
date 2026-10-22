package com.ss.android.lark.coremd.facade.bizext.image;

import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.parse.i;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.span.BorderProperty;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class BorderPropertyFactory {
    public static final BorderPropertyFactory a = null;

    static {
        a = new BorderPropertyFactory();
    }

    public BorderPropertyFactory() {
    }

    public static BorderProperty a(final i r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (((Boolean) IMContextExtend.A.b(new BorderPropertyFactory$imageThread$isGroupAnnouncement$1(r3))).booleanValue() == false) goto L7;
        return new BorderProperty(0, 0, 0);
    L7:
        return new BorderProperty(UIUtils.getColor(r3.getContext(), 2131103352), UIHelper.dp2px(0.5f), UIHelper.dp2px(4.0f));
    }
}
