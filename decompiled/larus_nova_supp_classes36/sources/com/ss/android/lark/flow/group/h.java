package com.ss.android.lark.flow.group;

import android.content.Context;
import android.text.InputFilter;
import android.widget.TextView;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.framework.utils.UIUtils;
import com.suite.lark.emm.design.edittext.SCEditText;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h extends com.larksuite.component.ui.dialog.d.a<LKUIDialog> {
    public final /* synthetic */ Ref.ObjectRef<SCEditText> a;
    public final /* synthetic */ Context b;

    public final void b(LKUIDialog r6) {
        Ref.ObjectRef<SCEditText> r0 = this.a;
        TextView r1 = null;
        if (r6 == null) goto L5;
        SCEditText r2 = (SCEditText) r6.findViewById(2131379374);
    L6:
        r0.element = r2;
        SCEditText r3 = (SCEditText) this.a.element;
        if (r3 == null) goto L9;
        r3.setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
    L9:
        if (r6 == null) goto L11;
        r1 = (TextView) r6.findViewById(2131379346);
    L11:
        if (r1 == null) goto L14;
        r1.setText(UIUtils.getString(this.b, 2131891906));
        return;
    L14:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public h(Ref.ObjectRef<SCEditText> r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }
}
