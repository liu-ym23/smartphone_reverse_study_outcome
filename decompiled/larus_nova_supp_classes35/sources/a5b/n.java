package a5b;

import com.ss.android.lark.chat.cot.CotViewBlock;
import com.ss.android.lark.chat.cot.CotViewBlockType;
import com.ss.android.lark.chat.cot.ToolCallCodeResultArea;
import com.ss.android.lark.chat.cot.ToolCallExtra;
import com.ss.android.lark.chat.cot.ToolCallListResultArea;
import com.ss.android.lark.chat.cot.ToolCallResultArea;
import com.ss.android.lark.chat.cot.ToolCallTextResultArea;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n extends h {
    public final boolean g;
    public String h;
    public String i;
    public final StringBuilder j;
    public String k;
    public String l;
    public String m;
    public String n;

    @Override // a5b.h
    public final CotViewBlock a() {
        StringBuilder r1 = this.j;
        if (r1.length() <= 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        String r9 = r1.toString();
    L13:
        String r3 = this.c;
        if (r3 != null) goto L26;
        r3 = this.h;
        if (r3 == null) goto L25;
        if (r9 != null) goto L19;
    L22:
        boolean r4 = true;
    L23:
        if (r4 == true) goto L26;
        r3 = r3 + " (" + r9 + ')';
        goto L26
    L19:
        if (r9.length() == 0) goto L22;
        r4 = false;
        goto L23
    L25:
        r3 = null;
    L26:
        CotViewBlock r5 = super.a();
        String r7 = this.h;
        String r8 = this.i;
        String r10 = this.k;
        String r11 = this.l;
        String r12 = this.m;
        String r13 = this.n;
        int r6 = com.ss.android.lark.chat.cot.i.a;
        if (r12 != null) goto L29;
    L33:
        if (r11 != null) goto L35;
    L37:
        String r14 = null;
    L38:
        if (r14 != null) goto L100;
        String r23 = r3;
        ArrayList r15 = new ArrayList();
    L92:
        return CotViewBlock.copy$default(r5, null, null, r23, null, null, false, new ToolCallExtra(r7, r8, r9, r10, r11, r12, r13, r15, this.g, false, false), 59, null);
    L100:
        if (StringsKt.startsWith$default(StringsKt.trimStart(r14).toString(), "{", false, 2, null) == false) goto L45;
        Object r16 = new JSONObject(r14);     // Catch: Throwable -> L48
    L50:
        if (r16 != null) goto L52;
        r23 = r3;
        ArrayList r17 = CollectionsKt.arrayListOf(new ToolCallResultArea[]{new ToolCallTextResultArea(r14)});
    L90:
        r15 = r17;
        goto L92
    L52:
        if ((r16 instanceof JSONObject) == false) goto L62;
        JSONObject r18 = (JSONObject) r16;
        ToolCallResultArea r19 = com.ss.android.lark.chat.cot.i.b(r18);
        r23 = r3;
        if (r19 == null) goto L56;
        r17 = CollectionsKt.arrayListOf(new ToolCallResultArea[]{r19});
    L57:
        if (r17 != null) goto L90;
        ToolCallResultArea[] r20 = new ToolCallResultArea[1];
        String r21 = r18.toString(2);     // Catch: Throwable -> L93
        Intrinsics.checkNotNull(r21);     // Catch: Throwable -> L93
        r14 = r21;
    L61:
        r20[0] = new ToolCallCodeResultArea(r14, "json");
        r17 = CollectionsKt.arrayListOf(r20);
        goto L90
    L56:
        r17 = null;
        goto L57
    L62:
        r23 = r3;
        if ((r16 instanceof JSONArray) == false) goto L88;
        JSONArray r22 = (JSONArray) r16;
        if (r22.length() != 0) goto L70;
        ToolCallResultArea[] r24 = new ToolCallResultArea[1];
        String r25 = r22.toString(2);     // Catch: Throwable -> L94
        Intrinsics.checkNotNull(r25);     // Catch: Throwable -> L94
        r14 = r25;
    L69:
        r24[0] = new ToolCallCodeResultArea(r14, "json");
        r17 = CollectionsKt.arrayListOf(r24);
        goto L90
    L70:
        ArrayList r26 = new ArrayList(r22.length());
        int r110 = r22.length();
        int r111 = 0;
    L71:
        if (r111 >= r110) goto L79;
        JSONObject r27 = r22.optJSONObject(r111);
        if (r27 == null) goto L77;
        ToolCallResultArea r28 = com.ss.android.lark.chat.cot.i.b(r27);
        if (r28 == null) goto L77;
        r26.add(r28);
        r111 = r111 + 1;
    L77:
        r26 = null;
    L79:
        if (r26 == null) goto L81;
        r17 = r26;
        goto L90
    L81:
        ToolCallListResultArea r29 = com.ss.android.lark.chat.cot.i.a(r22);
        if (r29 == null) goto L84;
        r17 = CollectionsKt.arrayListOf(new ToolCallResultArea[]{r29});
        goto L90
    L84:
        ToolCallResultArea[] r30 = new ToolCallResultArea[1];
        String r31 = r22.toString(2);     // Catch: Throwable -> L95
        Intrinsics.checkNotNull(r31);     // Catch: Throwable -> L95
        r14 = r31;
    L87:
        r30[0] = new ToolCallCodeResultArea(r14, "json");
        r17 = CollectionsKt.arrayListOf(r30);
        goto L90
    L88:
        r17 = CollectionsKt.arrayListOf(new ToolCallResultArea[]{new ToolCallTextResultArea(r14)});
        goto L90
    L45:
        if (StringsKt.startsWith$default(StringsKt.trimStart(r14).toString(), "[", false, 2, null) == false) goto L49;
        r16 = new JSONArray(r14);     // Catch: Throwable -> L48
        goto L50
    L104:
        r16 = null;
    L49:
        r16 = null;
        goto L50
    L35:
        if ((!StringsKt.isBlank(r11)) == false) goto L37;
        r14 = r11;
        goto L38
    L29:
        if ((!StringsKt.isBlank(r12)) == false) goto L31;
        r14 = r12;
    L32:
        if (r14 != null) goto L100;
    L31:
        r14 = null;
        goto L32
    L12:
        r9 = null;
        goto L13
    L5:
        r2 = false;
        goto L7
    }

    public n(String r2) {
        Intrinsics.checkNotNullParameter(r2, "stableId");
        super(r2, CotViewBlockType.TOOL_CALL);
        this.g = true;
        this.j = new StringBuilder();
    }

    public final void setResult(String r1) {
        this.l = r1;
    }
}
