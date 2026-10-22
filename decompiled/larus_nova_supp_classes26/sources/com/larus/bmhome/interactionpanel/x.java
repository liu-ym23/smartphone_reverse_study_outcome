package com.larus.bmhome.interactionpanel;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.ComplexTaskBlock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x {
    public static final w d(ComplexTaskBlock r3) {
        String r0 = r3.displayType;
        if (r0 != null) goto L5;
    L7:
        r0 = null;
    L8:
        String r4 = r3.agentType;
        if (r4 != null) goto L11;
    L13:
        r4 = null;
    L14:
        if (r0 != null) goto L18;
        if (r4 != null) goto L18;
        return null;
    L18:
        return new w(r0, r4);
    L11:
        if ((!StringsKt.isBlank(r4)) == false) goto L13;
    L5:
        if ((!StringsKt.isBlank(r0)) == false) goto L7;
        goto L7
    }

    public static final void a(JSONObject r3, w r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Object r0 = null;
        if (r4 == null) goto L12;
        String r1 = r4.a;
        if (r1 == null) goto L12;
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        r3.put("display_type", r1);
    L12:
        if (r4 == null) goto L21;
        String r5 = r4.b;
        if (r5 != null) goto L16;
        return;
    L16:
        if ((!StringsKt.isBlank(r5)) == false) goto L18;
        r0 = r5;
    L18:
        if (r0 == null) goto L23;
        r3.put("agent_type", r0);
        return;
    L23:
        return;
    }

    public static final w b(Message r1, Block r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        List r0 = r1.getContentBlock();
        if (r0 != null) goto L6;
        r0 = CollectionsKt.emptyList();
    L6:
        return c(r0, r1.getThreadId(), r2);
    }

    public static final w c(List<Block> r7, String r8, Block r9) {
        Intrinsics.checkNotNullParameter(r7, "blocks");
        if (r9 == null) goto L11;
        BlockContent r0 = r9.getContent();
        if (r0 == null) goto L11;
        ComplexTaskBlock r1 = r0.getComplexTaskBlock();
        if (r1 == null) goto L11;
        w r2 = d(r1);
        if (r2 == null) goto L11;
        return r2;
    L11:
        List<Block> r10 = r7;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r10.iterator();
    L12:
        Pair r5 = null;
        if (r4.hasNext() == false) goto L24;
        Block r6 = (Block) r4.next();
        String r11 = r6.getBlockId();
        if (r11 != null) goto L17;
    L22:
        if (r5 == null) goto L12;
        r3.add(r5);
        goto L12
    L17:
        if ((true ^ StringsKt.isBlank(r11)) == true) goto L20;
        r11 = null;
    L20:
        if (r11 == null) goto L22;
        r5 = TuplesKt.to(r11, r6);
        goto L22
    L24:
        Map r12 = MapsKt.toMap(r3);
        if (r9 == null) goto L27;
        String r13 = r9.getParentId();
    L28:
        LinkedHashSet r14 = new LinkedHashSet();
    L29:
        if (r13 != null) goto L31;
    L34:
        boolean r15 = true;
    L35:
        if (r15 == true) goto L49;
        if (r14.add(r13) == false) goto L49;
        Block r16 = (Block) r12.get(r13);
        if (r16 == null) goto L49;
        BlockContent r17 = r16.getContent();
        if (r17 == null) goto L48;
        ComplexTaskBlock r18 = r17.getComplexTaskBlock();
        if (r18 == null) goto L48;
        w r19 = d(r18);
        if (r19 == null) goto L48;
        return r19;
    L48:
        r13 = r16.getParentId();
    L49:
        ArrayList r20 = new ArrayList();
        Iterator<T> r21 = r10.iterator();
    L51:
        if (r21.hasNext() == false) goto L58;
        BlockContent r22 = ((Block) r21.next()).getContent();
        if (r22 == null) goto L55;
        ComplexTaskBlock r23 = r22.getComplexTaskBlock();
    L56:
        if (r23 == null) goto L51;
        r20.add(r23);
        goto L51
    L55:
        r23 = null;
        goto L56
    L58:
        if (r8 != null) goto L60;
    L72:
        ComplexTaskBlock r24 = null;
    L73:
        if (r24 != null) goto L75;
        r24 = (ComplexTaskBlock) CollectionsKt.singleOrNull(r20);
    L75:
        if (r24 != null) goto L77;
        return null;
    L77:
        return d(r24);
    L60:
        if ((!StringsKt.isBlank(r8)) == true) goto L63;
        r8 = null;
    L63:
        if (r8 == null) goto L72;
        Iterator r25 = r20.iterator();
    L66:
        if (r25.hasNext() == false) goto L70;
        Object r26 = r25.next();
        if (Intrinsics.areEqual(((ComplexTaskBlock) r26).threadId, r8) == false) goto L66;
    L71:
        r24 = (ComplexTaskBlock) r26;
        goto L73
    L70:
        r26 = null;
        goto L71
    L31:
        if (StringsKt.isBlank(r13) == true) goto L34;
        r15 = false;
        goto L35
    L27:
        r13 = null;
        goto L28
    }
}
