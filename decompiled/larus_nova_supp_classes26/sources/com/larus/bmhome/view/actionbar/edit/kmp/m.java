package com.larus.bmhome.view.actionbar.edit.kmp;

import com.larus.bmhome.actionbar.model.m0;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.component.cvs.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m implements dq8.h {
    public final /* synthetic */ KmpInstructionEditorViewFactory a;
    public final /* synthetic */ com.larus.bmhome.view.actionbar.edit.c b;

    public final String a() {
        com.larus.bmhome.view.actionbar.edit.c r0 = this.b;
        if (r0 == null) goto L7;
        z0 r1 = r0.getCurrentCustomActionBarItem();
        if (r1 == null) goto L7;
        return r1.b;
    L7:
        return null;
    }

    public final String b() {
        com.larus.bmhome.view.actionbar.edit.c r0 = this.b;
        if (r0 == null) goto L7;
        ChatParam r1 = r0.getChatParam();
        if (r1 == null) goto L7;
        return r1.c;
    L7:
        return null;
    }

    public final String c() {
        com.larus.bmhome.view.actionbar.edit.c r0 = this.b;
        if (r0 == null) goto L7;
        z0 r1 = r0.getCurrentCustomActionBarItem();
        if (r1 == null) goto L7;
        Long r2 = r1.a;
    L9:
        return String.valueOf(r2);
    L7:
        r2 = null;
        goto L9
    }

    public final String d() {
        com.larus.bmhome.view.actionbar.edit.c r0 = this.b;
        if (r0 == null) goto L9;
        z0 r1 = r0.getCurrentCustomActionBarItem();
        if (r1 == null) goto L9;
        m0 r2 = r1.u;
        if (r2 == null) goto L9;
        return r2.v;
    L9:
        return null;
    }

    public final String getBotId() {
        y r0 = KmpInstructionEditorViewFactory.n(this.a);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBotId();
    }

    public final String getChatType() {
        y r0 = KmpInstructionEditorViewFactory.n(this.a);
        if (r0 == null) goto L7;
        wc9.e r1 = r0.h();
        if (r1 == null) goto L7;
        return ic8.n.f(r1);
    L7:
        return null;
    }

    public final String getConversationId() {
        y r0 = KmpInstructionEditorViewFactory.n(this.a);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Y1();
    }

    public final Integer getInstructionType() {
        com.larus.bmhome.view.actionbar.edit.c r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getInstructionType();
    }

    public final String getTemplateType() {
        com.larus.bmhome.view.actionbar.edit.c r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTemplateType();
    }

    public final Boolean isCreationActionBar() {
        com.larus.bmhome.view.actionbar.edit.c r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.isCreationActionBar();
    }

    public m(KmpInstructionEditorViewFactory r1, com.larus.bmhome.view.actionbar.edit.c r2) {
        this.a = r1;
        this.b = r2;
    }
}
