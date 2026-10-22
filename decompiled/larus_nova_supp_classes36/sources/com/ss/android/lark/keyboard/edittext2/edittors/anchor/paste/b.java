package com.ss.android.lark.keyboard.edittext2.edittors.anchor.paste;

import android.text.Editable;
import com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.edittext2.edittors.anchor.customlink.CustomLinkSpanHolder;
import com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.d;
import hob.j;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends d {
    public static final /* synthetic */ int f = 0;
    public final j e;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.d
    public final void j() {
        a(new PasteDefaultAnchorSpanHolder$prepareCustomLinkSpan$1(this));
    }

    public b(j r2) {
        Intrinsics.checkNotNullParameter(r2, "urlInline");
        super(r2);
        this.e = r2;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.d
    public final void g(UrlInlinePreviewEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "entity");
        if (Intrinsics.areEqual(StringsKt.trim(r3.b).toString(), this.e.e) == true) goto L6;
        Map<String, Object> r4 = this.e.c;
        HashMap r5 = (HashMap) r4;
        r5.put("key_downgrade_to_custom_link", Boolean.TRUE);
        return;
    L6:
        super.g(r3);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.d
    public final void k(FunctionEditText r3) {
        Intrinsics.checkNotNullParameter(r3, "targetView");
        if (Intrinsics.areEqual(((HashMap) this.e.c).get("key_downgrade_to_custom_link"), Boolean.TRUE) == false) goto L5;
        l(r3);
        return;
    L5:
        super.k(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l(FunctionEditText r8) {
        Editable r0 = r8.getEditableText();
        Intrinsics.checkNotNull(r0);
        if (h(r0) == false) goto L5;
        return;
    L5:
        Pair<Integer, Integer> r1 = b(r0);
        int r2 = ((Number) r1.component1()).intValue();
        int r3 = ((Number) r1.component2()).intValue();
        j r5 = this.e;
        CustomLinkSpanHolder r4 = new CustomLinkSpanHolder(new hob.a(r5.a, r5.e));
        r0.setSpan(r4, r2, r3, 33);
        Intrinsics.checkNotNullParameter(r0, "editable");
        r0.removeSpan(this);
        r4.c(r8);
    }
}
