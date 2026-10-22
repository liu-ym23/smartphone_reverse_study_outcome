package com.ss.android.lark.keyboard.biz.mention;

import android.text.Editable;
import android.widget.EditText;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.keyboard.editor.FlowChatKeyboardEditor;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionPanelView;
import com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel;
import java.util.Collection;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements DoubaoMentionPanelView.c {
    public final /* synthetic */ d a;

    @Override // com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionPanelView.c
    public final void c() {
        this.a.d(false, false);
    }

    public e(d r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionPanelView.c
    public final void a(Map<String, ChatChatter> r13) {
        d r0 = this.a;
        r0.getClass();
        if (r13 == null) goto L25;
        Collection<ChatChatter> r14 = r13.values();
        if (r14 != null) goto L7;
        return;
    L7:
        if (r14.isEmpty() == true) goto L28;
        ChatterNameDisplayRule r1 = ChatterNameDisplayRule.ALIAS_NICKNAME_NAME;
        Chatter r15 = ((ChatChatter) CollectionsKt.first(r14)).getChatter();
        String r6 = com.ss.android.lark.chat.utils.m.b(r15, r1, true);
        String r2 = r15.getLocalizedName();
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        String r4 = r15.getId();
        Chatter.ChatterType r5 = r15.getType();
        Intrinsics.checkNotNull(r6);
        com.ss.android.lark.keyboard.plugin.tool.at.a.b r3 = new com.ss.android.lark.keyboard.plugin.tool.at.a.b(r4, r5, r6, r2, false, r15.isAnonymous());
        Chatter r7 = ((DoubaoMentionViewModel) r0.j.getValue()).getDoubaoChatter();
        EditText r8 = null;
        if (r7 == null) goto L15;
        String r9 = r7.getId();
    L16:
        r0.d(false, true);
        com.ss.android.lark.keyboard.b r10 = r0.d;
        if (r10 == null) goto L21;
        com.ss.android.lark.keyboard.keyboard2.b r11 = r10.L();
        if (r11 == null) goto L21;
        r8 = r11.c();
    L21:
        EditText r12 = r8;
        if (r12 == null) goto L27;
        r0.b(r12, r3);
        ExtensionEditTextCompatKt.j(r12, r3.a, r3.c, r3.d, r3.e, r3.f, Intrinsics.areEqual(r15.getId(), r9));
        return;
    L27:
        return;
    L15:
        r9 = null;
        goto L16
    L28:
        return;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionPanelView.c
    public final void d(boolean r7) {
        com.ss.android.lark.keyboard.b r0 = this.a.d;
        FlowChatKeyboardEditor r1 = null;
        if (r0 == null) goto L9;
        com.ss.android.lark.keyboard.keyboard2.b r2 = r0.L();
        if (r2 == null) goto L9;
        EditText r3 = r2.c();
        if (r3 == null) goto L9;
        Editable r4 = r3.getEditableText();
    L10:
        if (r7 == true) goto L12;
    L19:
        com.ss.android.lark.keyboard.b r5 = this.a.d;
        if (r5 == null) goto L22;
        com.ss.android.lark.keyboard.keyboard2.b r6 = r5.L();
    L24:
        if ((r6 instanceof FlowChatKeyboardEditor) == false) goto L26;
        r1 = (FlowChatKeyboardEditor) r6;
    L26:
        if (r1 == null) goto L30;
        com.ss.android.lark.keyboard.biz.mention.inject.h.a r8 = com.ss.android.lark.keyboard.biz.mention.inject.h.d;
        r1.P(r7);
        return;
    L30:
        return;
    L22:
        r6 = null;
        goto L24
    L12:
        if (r4 != null) goto L14;
    L16:
        boolean r9 = false;
    L17:
        if (r9 == true) goto L19;
        this.a.d(false, true);
        return;
    L14:
        if (StringsKt.contains$default(r4, '@', false, 2, null) != true) goto L16;
        r9 = true;
    L9:
        r4 = null;
        goto L10
    }
}
