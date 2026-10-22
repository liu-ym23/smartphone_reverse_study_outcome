package com.ss.android.lark.officesdk.integrator.im;

import android.content.Context;
import android.text.Layout;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public final /* synthetic */ InitChatPreviewTask a;

    public e(InitChatPreviewTask r1) {
        this.a = r1;
    }

    public final RichText b(com.bytedance.lark.pb.basic.v1.RichText r2) {
        IIMApi r0 = InitChatPreviewTask.j(this.a);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRichText(r2);
    }

    public final HashMap<String, HashMap<Integer, Layout>> a(Context r2, RichText r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        IIMApi r0 = InitChatPreviewTask.j(this.a);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.calculatePreviewTableCellsLayout(r2, r3);
    }

    public final void c(RichText r2, Map<String, PreviewHangPoint> r3) {
        Intrinsics.checkNotNullParameter(r2, "richText");
        Intrinsics.checkNotNullParameter(r3, "previews");
        IIMApi r0 = InitChatPreviewTask.j(this.a);
        if (r0 == null) goto L6;
        r0.transformRichTextByPreview(r2, r3);
        return;
    }
}
