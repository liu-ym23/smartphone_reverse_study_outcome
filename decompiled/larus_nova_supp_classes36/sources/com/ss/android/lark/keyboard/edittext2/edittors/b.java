package com.ss.android.lark.keyboard.edittext2.edittors;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import com.ss.android.lark.widget.span.AtUserGroupInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class b extends BaseFunctionEditor<hob.d> implements com.ss.android.lark.keyboard.edittext2.base.c {
    public static final a d = null;
    public final C0140b c;

    public static final class a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a<b> {
        public final /* synthetic */ com.ss.android.lark.keyboard.edittext2.base.d a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a
        public final Class<b> a() {
            return this.a.a;
        }

        public a() {
            this.a = new com.ss.android.lark.keyboard.edittext2.base.d(b.class);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.edittors.b$b, reason: collision with other inner class name */
    public static final class C0140b {
        public C0140b() {
        }
    }

    static {
        d = new a();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor, com.ss.android.lark.keyboard.edittext2.base.a
    public final void d() {
    }

    public b() {
        this.c = new C0140b();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public /* bridge */ /* synthetic */ void S(SpannableStringBuilder r1, hob.d r2, int r3) {
        U(r1, r2, r3);
    }

    public void U(SpannableStringBuilder r9, hob.d r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "data");
        Context r0 = context();
        String r1 = "@" + r10.b;
        boolean r3 = true;
        if (r10.c == 1) goto L6;
        r3 = false;
    L6:
        r9.append(r1);
        if (r3 == false) goto L10;
        int r2 = UIUtils.getColor(r0, 2131102465);
        C0140b r4 = this.c;
        AtUserGroupInfo r5 = new AtUserGroupInfo(r10.a, r10.b, r10.c);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "spanInfo");
        r9.setSpan(new com.ss.android.lark.widget.light.span.c(r5, r2), r11, r1.length() + r11, 33);
        r9.setSpan(new com.ss.android.lark.keyboard.edittext2.span.b(), r11, r1.length() + r11, 33);
    L10:
        if (r10.d == false) goto L12;
        r9.append(" ");
    L12:
        int r12 = com.ss.android.lark.keyboard.edittext2.utils.e.c(com.ss.android.lark.keyboard.edittext2.base.c.a.a(this));
        if (r12 < 0) goto L16;
        com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getEditableText().delete(r12, r12 + 1);
        return;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void T(hob.d r6, SpannableStringBuilder r7, int r8, int r9) {
        hob.d r10 = r6;
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r7, "text");
        long r0 = r10.a;
        String r2 = r10.b;
        int r3 = r10.c;
        Map r4 = RichTextElementCreator.a;
        Intrinsics.checkNotNullParameter(r2, "userGroupName");
        Intrinsics.checkNotNullParameter(r2, "userGroupName");
        RichTextElement.AtUserGroupProperty r5 = new RichTextElement.AtUserGroupProperty();
        r5.setUserGroupId(r0);
        r5.setDisplayName(r2);
        r5.setDefaultGroupName(r2);
        r5.setPermissionStatus(r3);
        RichTextElement r1 = RichTextElementCreator.h(r5);
        if (r10.d == true) goto L5;
    L7:
        r7.setSpan(new p(r1, r7.subSequence(r8, r9).toString()), r8, r9, 33);
        r7.setSpan(new gob.a(), r8, r9, 33);
        return;
    L5:
        if (StringsKt.endsWith$default(r7, " ", false, 2, null) == false) goto L7;
        r9 = r9 - 1;
        goto L7
    }
}
