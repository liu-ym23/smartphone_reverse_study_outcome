package com.ss.android.lark.chat.cot.detail.blueprint.block;

import android.view.View;
import com.bytedance.lark.lark_markdown_render_android.CodeBlockConfig;
import com.bytedance.lark.lark_markdown_render_android.DocumentConfig;
import com.bytedance.lark.lark_markdown_render_android.ListConfig;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import com.bytedance.lark.lark_markdown_render_android.TableConfig;
import com.ss.android.lark.movable.MarkdownMovableView;
import com.ss.android.lark.movable.MovableGlobalManager;
import com.ss.android.lark.movable.attatchment.l;
import com.ss.android.lark.movable.attatchment.m;
import com.ss.android.lark.vfs.VFSFiles;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CotMovableSetup {
    public static final CotMovableSetup a = null;
    public static final Regex b = null;
    public static final Function2<String, Float, m> c = null;
    public static volatile boolean d;

    public CotMovableSetup() {
    }

    static {
        a = new CotMovableSetup();
        b = new Regex("^[a-zA-Z][a-zA-Z0-9+.-]*:");
        c = CotMovableSetup$defaultImageMeasureSizeResolver$1.INSTANCE;
    }

    public static boolean a(com.ss.android.lark.chat.cot.a r3) {
        Intrinsics.checkNotNullParameter(r3, "cotFeatureGate");
        if (r3.a.isEnable("lark.im.agent.cot_message") == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L13;
        MovableGlobalManager.b r5 = MovableGlobalManager.d;
        if (VFSFiles.b.i("/system/etc/fonts.xml").exists() == false) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L5:
        if (r3.a.isEnable("lark.im.agent.cot_message.markdown_render") == false) goto L7;
        r4 = true;
        goto L8
    }

    public static String b(String r2) {
        if (r2 == null) goto L5;
        String r3 = StringsKt.trim(r2).toString();
    L6:
        if (r3 != null) goto L9;
        r3 = BuildConfig.FLAVOR;
    L9:
        if (r3.length() != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L15;
        return null;
    L15:
        if (b.containsMatchIn(r3) == false) goto L18;
        return r3;
    L18:
        return "https://".concat(r3);
    L11:
        r1 = false;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    public static float c(View r1) {
        Intrinsics.checkNotNullParameter(r1, "view");
        if (r1.getWidth() > 0) goto L7;
        return 0.0f;
    L7:
        return com.ss.android.lark.movable.utils.b.f(r1.getWidth(), r1.getContext());
    }

    public static c d(CotMovableSetup r62, MarkdownMovableView r63, String r64, int r65) {
        if ((r65 & 2) == 0) goto L5;
        String r12 = "text-title";
    L6:
        r62.getClass();
        Intrinsics.checkNotNullParameter(r63, "view");
        Intrinsics.checkNotNullParameter(r12, "fontColor");
        Object r2 = r63.getTag(2131367989);
        final Function1 r15 = null;
        if ((r2 instanceof c) == false) goto L9;
        c r3 = (c) r2;
    L10:
        if (r3 == null) goto L13;
        return r3;
    L13:
        if (d == true) goto L28;
        monitor-enter(r62);
    L25:
        th = move-exception;
        throw th;
    L16:
        if (d == true) goto L22;
        CopyOnWriteArrayList r4 = l.a;     // Catch: Throwable -> L25
        Function2<String, Float, m> r5 = c;     // Catch: Throwable -> L25
        if (r5 == null) goto L21;
        l.a.addIfAbsent(r5);     // Catch: Throwable -> L25
    L21:
        d = true;     // Catch: Throwable -> L25
    L22:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r62);
    L28:
        final MovableRenderConfig r7 = MovableRenderConfig.copy$default(com.ss.android.lark.movable.utils.a.c(), DocumentConfig.copy$default(com.ss.android.lark.movable.utils.a.b(), Float.valueOf(16.0f), null, null, null, null, null, null, null, null, r12, null, null, 3582, null), null, CodeBlockConfig.copy$default(com.ss.android.lark.movable.utils.a.a(), Float.valueOf(16.0f), null, null, "N900-80", "bg-body", null, null, "bg-content-base", null, null, "line-border-card", null, null, 7014, null), null, null, ListConfig.copy$default(new ListConfig(null, null, null, null, null, null, null), "function-info-content-default", Float.valueOf(16.0f), "function-info-content-default", null, null, null, null, 120, null), TableConfig.copy$default(com.ss.android.lark.movable.utils.a.d(), "bg-float-overlay", "bg-body", "line-border-card", Float.valueOf(16.0f), null, null, null, null, null, null, null, 2032, null), null, null, 410, null);
        final CotMovableRenderState r8 = new CotMovableRenderState();
        r63.setupMarkdown(new CotMovableSetup$setupForCotDetail$3(r15, r7, r8));
        c r9 = new c(r63, r8);
        r63.setTag(2131367989, r9);
        return r9;
    L9:
        r3 = null;
        goto L10
    L5:
        r12 = r64;
        goto L6
    }
}
