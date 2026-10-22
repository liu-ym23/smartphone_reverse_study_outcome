package com.ss.android.lark.chat.preview.components;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.ss.android.lark.chat.preview.components.view.FlowLayout;
import com.ss.android.lark.export.entity.preview.KeyTag;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b0 extends FlowLayout.a<FlowLayout.c> {
    public final ArrayList<KeyTag> a;
    public final /* synthetic */ a0 b;

    @Override // com.ss.android.lark.chat.preview.components.view.FlowLayout.a
    public final int a() {
        return this.a.size();
    }

    public b0(a0 r3) {
        this.b = r3;
        r3.getClass();
        ArrayList<KeyTag> r0 = new ArrayList();
        if (r3.f.getMixedTags() == null) goto L5;
        List<KeyTag> r4 = r3.f.getMixedTags();
        Intrinsics.checkNotNull(r4);
        r0.addAll(r4);
    L5:
        this.a = r0;
    }

    @Override // com.ss.android.lark.chat.preview.components.view.FlowLayout.a
    public final a0.a c(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        TextView r0 = new TextView(r5.getContext());
        ViewGroup.MarginLayoutParams r1 = new ViewGroup.MarginLayoutParams(-2, -2);
        int r2 = (int) h18.d.b(r5.getContext(), 2);
        r1.setMargins(0, r2, (int) h18.d.b(r5.getContext(), 6), r2);
        r0.setLayoutParams(r1);
        return new a0.a(r0);
    }

    @Override // com.ss.android.lark.chat.preview.components.view.FlowLayout.a
    public final void b(FlowLayout.c r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        Context r0 = r6.a.getContext();
        KeyTag r9 = (KeyTag) ListProtector.get(this.a, r7);
        Intrinsics.checkNotNull(r0);
        UDTagsDrawable.d.a r1 = new UDTagsDrawable.d.a(r0);
        r1.c = r9.getTag();
        a0 r2 = this.b;
        ThemeColor r3 = r9.getBackgroundColor();
        r2.getClass();
        if (r3 == null) goto L5;
        int r4 = com.ss.android.lark.export.entity.preview.a.a(r3, r0, null);
    L6:
        r1.a(r4);
        a0 r5 = this.b;
        ThemeColor r10 = r9.getTextColor();
        r5.getClass();
        if (r10 == null) goto L9;
        int r11 = com.ss.android.lark.export.entity.preview.a.a(r10, r0, null);
    L10:
        r1.d = r11;
        UDTagsDrawable.d r12 = r1.b();
        UDTagsDrawable.a r13 = new UDTagsDrawable.a(r0);
        r13.a(r12);
        if (r8 <= 0) goto L13;
        r13.f = r8;
    L13:
        r6.a.setBackground(r13.b());
        return;
    L9:
        r11 = r0.getResources().getColor(2131108724);
        goto L10
    L5:
        r4 = r0.getResources().getColor(2131109109);
        goto L6
    }
}
