package com.ss.android.lark.movable;

import android.os.Looper;
import com.bytedance.lark.lark_markdown_render_android.Lark_markdown_renderKt;
import com.bytedance.lark.lark_markdown_render_android.MovableDocumentInfo;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderUrlPreviewInlines;
import com.ss.android.lark.movable.attatchment.l;
import com.ss.android.lark.movable.attatchment.m;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MovableMarkdownDocumentParser {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public MovableMarkdownDocumentParser() {
    }

    public static h a(String r1, float r2, MovableRenderConfig r3, MovableRenderUrlPreviewInlines r4, Function2 r5) {
        float r6 = RangesKt.coerceAtLeast(r2, 0.0f);
        CopyOnWriteArrayList<Function2<String, Float, m>> r0 = l.a;
        if (r5 == null) goto L20;
        l.a.addIfAbsent(r5);
    L20:
        MovableDocumentInfo r7 = Lark_markdown_renderKt.ffiParseMarkdownForClient(r1, r6, r3, r4);     // Catch: Throwable -> L14
        if (r5 == null) goto L10;
        l.a.remove(r5);
    L10:
        if (r7 != null) goto L22;
        return null;
    L22:
        return new h(r7, new d(r7.getDocumentId-pVg5ArA()));
    L14:
        th = move-exception;
        CopyOnWriteArrayList<Function2<String, Float, m>> r8 = l.a;
        if (r5 == null) goto L19;
        l.a.remove(r5);
    L19:
        throw th;
    }

    public static Object b(String r9, float r10, MovableRenderConfig r11, MovableRenderUrlPreviewInlines r12, Function2 r13, Continuation r14) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L7;
        return BuildersKt.withContext(Dispatchers.getIO(), new MovableMarkdownDocumentParser$parseMarkdownForClient$2(r9, r10, r11, r12, r13, null), r14);
    L7:
        return a(r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Object c(String r8, float r9, MovableRenderConfig r10, MovableRenderUrlPreviewInlines r11, Continuation r12, int r13) {
        if ((r13 & 4) == 0) goto L5;
        MovableRenderConfig r4 = null;
    L7:
        if ((r13 & 8) == 0) goto L9;
        MovableRenderUrlPreviewInlines r5 = null;
    L11:
        return b(r8, r9, r4, r5, null, r12);
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }
}
