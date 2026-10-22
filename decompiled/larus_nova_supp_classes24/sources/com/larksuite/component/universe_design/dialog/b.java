package com.larksuite.component.universe_design.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends UDDialogController {
    public boolean a;
    public CharSequence b;
    public UDCheckBox.c c;

    public static final class a implements UDCheckBox.c {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // com.larksuite.component.universe_design.checkbox.UDCheckBox.c
        public final void a(UDCheckBox r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "buttonView");
            b r0 = this.a;
            r0.a = r3;
            r0.getClass();
            UDCheckBox.c r1 = this.a.c;
            if (r1 == null) goto L6;
            r1.a(r2, r3);
            return;
        }
    }

    /* JADX INFO: renamed from: com.larksuite.component.universe_design.dialog.b$b, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0039b implements View.OnClickListener {
        public final /* synthetic */ UDCheckBox a;

        public ViewOnClickListenerC0039b(UDCheckBox r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            UDCheckBox r2 = this.a;
            if (r2 == null) goto L6;
            r2.toggle();
            return;
        }
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final int getDefaultContentRes() {
        return 2131568081;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateContent() {
        View r0 = super.onCreateContent();
        if (r0 != null) goto L7;
        return null;
    L7:
        if (TextUtils.isEmpty(getMMessage()) == false) goto L11;
        TextView r1 = (TextView) r0.findViewById(2131391794);
        if (r1 == null) goto L11;
        r1.setVisibility(8);
    L11:
        UDCheckBox r2 = (UDCheckBox) r0.findViewById(2131391781);
        if (r2 == null) goto L14;
        r2.setChecked(this.a);
        r2.setOnCheckedChangeListener(new a(this));
    L14:
        TextView r3 = (TextView) r0.findViewById(2131391782);
        if (r3 == null) goto L17;
        r3.setText(this.b);
        r3.setOnClickListener(new ViewOnClickListenerC0039b(r2));
    L17:
        return r0;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateFooter() {
        View r0 = super.onCreateFooter();
        if (r0 != null) goto L6;
        return null;
    L6:
        r0.findViewById(2131391777);
        return r0;
    }

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = "";
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r2, UDDialog r3) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        if ((r2 instanceof com.larksuite.component.universe_design.dialog.a) == false) goto L7;
        super.apply(r2, r3);
        com.larksuite.component.universe_design.dialog.a r4 = (com.larksuite.component.universe_design.dialog.a) r2;
        r4.getClass();
        this.a = false;
        this.b = r4.a;
        this.c = r4.b;
        return;
    L7:
        throw new IllegalArgumentException("builder should be UDCheckBoxDialogBuilder, but actually ".concat(r2.getClass().getSimpleName()).toString());
    }
}
