package ac8;

import com.larus.bmhome.chat.ab.InputMultilineScene;
import com.larus.bmhome.chat.ab.InputRowCollapseStyle;
import com.larus.platform.service.z2;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public static volatile d a;

    static {
    }

    public static g a(InputMultilineScene r12) {
        int r0 = e.a;
        d r1 = a;
        boolean r2 = false;
        if (r1 != null) goto L34;
        z2 r3 = z2.a;
        JSONObject r4 = r3.d3();
        if (r4 == null) goto L7;
        JSONObject r5 = r4.optJSONObject("double_line_input_config");
    L9:
        if (r5 == null) goto L11;
        boolean r6 = r5.optBoolean("double_line_input_view", false);
    L12:
        if (r5 == null) goto L14;
        int r7 = r5.optInt("input_view_shrink_type", 0);
    L15:
        if (r5 == null) goto L17;
        boolean r8 = r5.optBoolean("hide_sug_index_with_text", false);
    L18:
        JSONObject r9 = r3.d3();
        if (r9 == null) goto L32;
        JSONArray r10 = r9.optJSONArray("input_multiline_blocked_scenes");
        if (r10 == null) goto L32;
        List r11 = CollectionsKt.createListBuilder();
        int r13 = r10.length();
        int r14 = 0;
    L23:
        if (r14 >= r13) goto L31;
        Object r15 = r10.opt(r14);
        if ((r15 instanceof String) == false) goto L27;
        String r16 = (String) r15;
    L28:
        if (r16 == null) goto L30;
        r11.add(r16);
    L30:
        r14 = r14 + 1;
        goto L23
    L27:
        r16 = null;
        goto L28
    L31:
        List r17 = CollectionsKt.build(r11);
    L33:
        d r18 = new d(r6, r7, r8, r17);
        a = r18;
        r1 = r18;
    L32:
        r17 = CollectionsKt.emptyList();
        goto L33
    L17:
        r8 = false;
        goto L18
    L14:
        r7 = 0;
        goto L15
    L11:
        r6 = false;
        goto L12
    L7:
        r5 = null;
    L34:
        Intrinsics.checkNotNullParameter(r1, "config");
        List<String> r19 = r1.d;
        Intrinsics.checkNotNullParameter(r19, "blockedScenes");
        if (r19.contains("all") == false) goto L37;
        boolean r20 = true;
    L43:
        if (r20 == false) goto L46;
        return g.d;
    L46:
        if (r1.a == false) goto L66;
        int r21 = r1.b;
        if (r21 != 1) goto L51;
        InputRowCollapseStyle r22 = InputRowCollapseStyle.ONE_LINE;
    L56:
        if (r1.c == false) goto L61;
        if (r12 == InputMultilineScene.CREATION) goto L61;
        r2 = true;
    L61:
        return new g(true, r22, r2);
    L51:
        if (r21 == 2) goto L53;
        r22 = InputRowCollapseStyle.NONE;
        goto L56
    L53:
        r22 = InputRowCollapseStyle.TWO_LINE;
        goto L56
    L66:
        return g.d;
    L37:
        if (r12 == null) goto L42;
        String r23 = r12.getSceneKey();
        if (r23 == null) goto L42;
        r20 = r19.contains(r23);
    L42:
        r20 = false;
        goto L43
    }
}
