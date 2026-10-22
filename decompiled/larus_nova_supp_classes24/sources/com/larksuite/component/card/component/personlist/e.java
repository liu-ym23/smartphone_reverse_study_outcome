package com.larksuite.component.card.component.personlist;

import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e implements com.larksuite.component.card.component.personlist.avatar.b {
    public final /* synthetic */ PersonListLynxUI a;

    @Override // com.larksuite.component.card.component.personlist.avatar.b
    public final void a() {
        AppCompatTextView r0 = (PersonListTextView) PersonListLynxUI.M(this.a);
        if (r0 == null) goto L6;
        r0.postInvalidate();
        return;
    }

    public e(PersonListLynxUI r1) {
        this.a = r1;
    }
}
