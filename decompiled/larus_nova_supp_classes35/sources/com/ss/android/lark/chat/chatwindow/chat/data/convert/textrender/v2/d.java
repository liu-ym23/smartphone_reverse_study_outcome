package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import com.bytedance.lark.lark_markdown_render_android.CodeBlockConfig;
import com.bytedance.lark.lark_markdown_render_android.DocumentConfig;
import com.bytedance.lark.lark_markdown_render_android.EdgeInsets;
import com.bytedance.lark.lark_markdown_render_android.FontWeight;
import com.bytedance.lark.lark_markdown_render_android.HeadingConfig;
import com.bytedance.lark.lark_markdown_render_android.HeadingLevelConfig;
import com.bytedance.lark.lark_markdown_render_android.ListConfig;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import com.bytedance.lark.lark_markdown_render_android.TableConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final MovableRenderConfig a() {
        MovableRenderConfig r0 = com.ss.android.lark.movable.utils.a.c();
        DocumentConfig r1 = com.ss.android.lark.movable.utils.a.b();
        Float r15 = Float.valueOf(17.0f);
        Float r8 = Float.valueOf(8.5f);
        Float r14 = Float.valueOf(22.0f);
        DocumentConfig r2 = DocumentConfig.copy$default(r1, r15, null, null, r15, null, null, r8, r14, null, null, null, null, 3894, null);
        CodeBlockConfig r21 = CodeBlockConfig.copy$default(com.ss.android.lark.movable.utils.a.a(), null, null, null, "N500", "bg-body", null, null, "bg-content-base", null, null, null, null, null, 8039, null);
        TableConfig r13 = TableConfig.copy$default(com.ss.android.lark.movable.utils.a.d(), "bg-content-base", "bg-body", "N900-15", null, null, null, null, null, null, null, null, 2040, null);
        ListConfig r6 = ListConfig.copy$default(new ListConfig(null, null, null, null, null, null, null), null, r15, null, Float.valueOf(21.0f), null, null, null, 117, null);
        HeadingConfig r3 = new HeadingConfig(null, null, null, null, null, null);
        FontWeight r4 = FontWeight.Bold;
        Float r5 = Float.valueOf(28.0f);
        Float r9 = Float.valueOf(8.0f);
        Float r10 = Float.valueOf(6.0f);
        HeadingLevelConfig r7 = new HeadingLevelConfig(r14, r4, r5, new EdgeInsets(r9, null, r10, null));
        HeadingLevelConfig r11 = new HeadingLevelConfig(Float.valueOf(20.0f), r4, Float.valueOf(26.0f), new EdgeInsets(r9, null, r10, null));
        Float r12 = Float.valueOf(4.0f);
        Float r16 = Float.valueOf(2.0f);
        return MovableRenderConfig.copy$default(r0, r2, r3.copy(r7, r11, new HeadingLevelConfig(r15, r4, r14, new EdgeInsets(r12, null, r16, null)), new HeadingLevelConfig(r15, r4, r14, new EdgeInsets(r12, null, r16, null)), new HeadingLevelConfig(r15, r4, r14, new EdgeInsets(r12, null, r16, null)), new HeadingLevelConfig(r15, r4, r14, new EdgeInsets(r12, null, r16, null))), r21, null, null, r6, r13, null, null, 408, null);
    }
}
