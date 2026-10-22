package com.ss.android.lark.keyboard.edittext2.span;

import com.ss.android.lark.widget.richtext.LingoLocalExtraData;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements j {
    public ArrayList<String> a;
    public HashMap<String, String> b;

    public g() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.j
    public final void a(RichTextExtraInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "richTextExtraInfo");
        r4.setLingoLocalExtraData(new LingoLocalExtraData(this.a, this.b));
    }
}
