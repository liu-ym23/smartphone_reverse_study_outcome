package com.larksuite.component.card.component.personlist;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class PersonListLynxUI$$PropsSetter extends LynxUI$.PropsSetter {
    public PersonListLynxUI$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r3, String r4, x0 r5) {
        PersonListLynxUI r0 = (PersonListLynxUI) r3;
        r4.getClass();
        if (r4.equals("props") == true) goto L6;
        super.setProperty(r3, r4, r5);
        return;
    L6:
        r0.setContent(r5.g(r4));
    }
}
