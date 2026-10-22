package com.larus.bmhome.chat.standarduikit.localfileblock.blockadapter;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.InconImg;
import com.larus.im.bean.message.block.LocalFileBlock;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c extends jc8.a implements jc8.j {
    public final int i;

    public final String c() {
        return "";
    }

    public final String g() {
        return "PcLocalFileBlockBizModel";
    }

    public final com.larus.bmhome.chat.standarduikit.localfileblock.remote.g o() {
        BlockContent r0 = ((jc8.a) this).a.getContent();
        String r1 = null;
        if (r0 == null) goto L28;
        LocalFileBlock r2 = r0.getLocalFileBlock();
        if (r2 == null) goto L28;
        Map r3 = j().getExt();
        if (r3 == null) goto L11;
        r1 = (String) r3.get("inner_did");
    L11:
        if (r1 != null) goto L13;
        String r4 = "";
    L14:
        Map r5 = j().getExt();
        if (r5 == null) goto L21;
        String r6 = (String) r5.get("inner_app_id");
        if (r6 == null) goto L21;
        Integer r7 = StringsKt.toIntOrNull(r6);
        if (r7 == null) goto L21;
        int r8 = r7.intValue();
    L22:
        String r9 = r2.path;
        if (r9 != null) goto L25;
        String r10 = "";
    L27:
        return new com.larus.bmhome.chat.standarduikit.localfileblock.remote.g(r4, r8, r10, r2.name, r2.type);
    L25:
        r10 = r9;
    L21:
        r8 = 0;
        goto L22
    L13:
        r4 = r1;
    L28:
        return null;
    }

    public final int l() {
        return this.i;
    }

    public final String a(boolean r4) {
        BlockContent r0 = ((jc8.a) this).a.getContent();
        String r1 = null;
        if (r0 == null) goto L7;
        LocalFileBlock r2 = r0.getLocalFileBlock();
        if (r2 == null) goto L7;
        InconImg r3 = r2.icon;
    L9:
        if (r4 == false) goto L14;
        if (r3 == null) goto L12;
        r1 = r3.iconUrlDark;
    L12:
        if (r1 != null) goto L19;
        return "";
    L19:
        return r1;
    L14:
        if (r3 == null) goto L16;
        r1 = r3.iconUrl;
    L16:
        if (r1 != null) goto L19;
        return "";
    L7:
        r3 = null;
        goto L9
    }

    public final boolean e(jc8.a r6) {
        if ((r6 instanceof c) == true) goto L5;
        return false;
    L5:
        BlockContent r0 = ((jc8.a) this).a.getContent();
        String r2 = null;
        if (r0 == null) goto L8;
        LocalFileBlock r1 = r0.getLocalFileBlock();
    L9:
        c r7 = (c) r6;
        BlockContent r3 = ((jc8.a) r7).a.getContent();
        if (r3 == null) goto L12;
        LocalFileBlock r4 = r3.getLocalFileBlock();
    L14:
        if (Intrinsics.areEqual(r1, r4) == false) goto L36;
        Map r5 = j().getExt();
        if (r5 == null) goto L18;
        String r8 = (String) r5.get("inner_did");
    L19:
        Map r9 = r7.j().getExt();
        if (r9 == null) goto L22;
        String r10 = (String) r9.get("inner_did");
    L24:
        if (Intrinsics.areEqual(r8, r10) == false) goto L37;
        Map r11 = j().getExt();
        if (r11 == null) goto L28;
        String r12 = (String) r11.get("inner_app_id");
    L29:
        Map r13 = r7.j().getExt();
        if (r13 == null) goto L33;
        r2 = (String) r13.get("inner_app_id");
    L33:
        if (Intrinsics.areEqual(r12, r2) == false) goto L38;
        return true;
    L38:
        return false;
    L28:
        r12 = null;
        goto L29
    L37:
        return false;
    L22:
        r10 = null;
        goto L24
    L18:
        r8 = null;
        goto L19
    L36:
        return false;
    L12:
        r4 = null;
        goto L14
    L8:
        r1 = null;
        goto L9
    }

    public c(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
        this.i = com.larus.bmhome.chat.deepresearch.view.j.i0;
    }
}
