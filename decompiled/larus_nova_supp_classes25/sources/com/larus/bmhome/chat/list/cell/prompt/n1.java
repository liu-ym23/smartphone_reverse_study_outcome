package com.larus.bmhome.chat.list.cell.prompt;

import android.text.SpannableStringBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.bmhome.chat.bean.PromptContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n1 {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final Integer e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            String r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.d;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            Integer r8 = this.e;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "SelectedSkillPayload(commandName=" + this.a + ", displayName=" + this.b + ", skillId=" + this.c + ", path=" + this.d + ", skillType=" + this.e + ')';
        }

        public a(String r2, String r3, String r4, String r5, Integer r6) {
            Intrinsics.checkNotNullParameter(r2, "commandName");
            Intrinsics.checkNotNullParameter(r3, "displayName");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    static {
    }

    public static k1 a(PromptContent.SuggestItem r22) {
        Intrinsics.checkNotNullParameter(r22, "suggestItem");
        JsonObject r0 = r22.getSendRichTextContent();
        String r3 = null;
        if (r0 == null) goto L7;
        JsonArray r1 = c(r0, "rich_contents");
        if (r1 == null) goto L7;
        List r2 = e(r1);
    L8:
        if (r2 != null) goto L10;
        r2 = CollectionsKt.emptyList();
    L10:
        ArrayList r4 = new ArrayList();
        Iterator r5 = r2.iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        String r6 = d((a) r5.next());
        if (r6 == null) goto L12;
        r4.add(r6);
        goto L12
    L16:
        String r7 = CollectionsKt.joinToString$default(r4, "", null, null, 0, null, null, 62, null);
        boolean r8 = true;
        if ((!StringsKt.isBlank(r7)) == true) goto L20;
        r7 = null;
    L20:
        JsonObject r9 = r22.getSendRichTextContent();
        if (r9 == null) goto L27;
        JsonArray r10 = c(r9, "rich_contents");
        if (r10 == null) goto L27;
        String r11 = StringsKt.replace$default(CollectionsKt.joinToString$default(r10, "", null, null, 0, null, new l1(), 30, null), "￼", "", false, 4, null);
        if (r11 == null) goto L27;
    L33:
        if (r11.length() <= 0) goto L35;
        boolean r12 = true;
    L36:
        if (r12 == false) goto L38;
        String r13 = r11;
    L39:
        if (r13 != null) goto L54;
        lw8.l r14 = r22.getMarkdownContent();
        if (r14 == null) goto L50;
        SpannableStringBuilder r15 = r14.e();
        if (r15 == null) goto L50;
        r13 = r15.toString();
        if (r13 == null) goto L50;
        if (r22.isRichText() == false) goto L50;
    L51:
        if (r13 != null) goto L54;
        r13 = r22.getSendingContent();
    L50:
        r13 = null;
    L54:
        Map r16 = MapsKt.toMutableMap(r22.getSendMsgExtra());
        r16.remove("task_skill_local_temp_selected_skills");
        r16.remove("task_skill_local_temp_local_selected_skills");
        JsonObject r17 = r22.getSendRichTextContent();
        if (r17 == null) goto L59;
        JsonArray r18 = c(r17, "rich_contents");
        if (r18 == null) goto L59;
        List r19 = e(r18);
    L60:
        if (r19 != null) goto L62;
        r19 = CollectionsKt.emptyList();
    L62:
        List r20 = r19;
        if ((r20 instanceof Collection) == true) goto L65;
    L67:
        Iterator r21 = r20.iterator();
    L69:
        if (r21.hasNext() == false) goto L76;
        a r23 = (a) r21.next();
        Set<Integer> r110 = com.larus.bmhome.chat.markdown.richtext.s.a;
        if (com.larus.bmhome.chat.markdown.richtext.s.a(r23.a, r23.e, r23.c, r23.d) == null) goto L73;
        boolean r24 = true;
    L74:
        if (r24 == false) goto L69;
        r8 = false;
        goto L76
    L73:
        r24 = false;
    L76:
        if (r8 == false) goto L78;
        LinkedHashMap r25 = null;
    L79:
        if (r25 == null) goto L81;
        r16.putAll(r25);
    L81:
        if (r7 == null) goto L86;
        if (StringsKt.startsWith$default(r11, r7, false, 2, null) == false) goto L86;
        r3 = r7;
    L86:
        return new k1(r13, r11, r16, r3);
    L78:
        r25 = new LinkedHashMap();
        r25.put("task_skill_local_temp_runtime_type", "1");
        JSONObject r26 = new JSONObject();
        r26.put("preinstall_skill_path", "");
        Unit r27 = Unit.INSTANCE;
        r25.put("task_skill_local_temp_client_options", r26.toString());
        goto L79
    L65:
        if (r20.isEmpty() == false) goto L67;
    L59:
        r19 = null;
        goto L60
    L38:
        r13 = null;
        goto L39
    L35:
        r12 = false;
    L27:
        String r28 = r22.getSendingContent();
        if (r28 != null) goto L30;
        String r29 = "";
    L31:
        r11 = StringsKt.replace$default(r29, "￼", "", false, 4, null);
        goto L33
    L30:
        r29 = r28;
    L7:
        r2 = null;
        goto L8
    }

    public static j1 b(PromptContent.SuggestItem r2) {
        Intrinsics.checkNotNullParameter(r2, "suggestItem");
        JsonObject r3 = r2.getSendRichTextContent();
        if (r3 == null) goto L7;
        JsonArray r4 = c(r3, "rich_contents");
        if (r4 == null) goto L7;
        List r5 = e(r4);
    L8:
        if (r5 != null) goto L10;
        r5 = CollectionsKt.emptyList();
    L10:
        a r6 = (a) CollectionsKt.firstOrNull(r5);
        if (r6 != null) goto L14;
        return null;
    L14:
        return new j1(r6.c, r6.a);
    L7:
        r5 = null;
        goto L8
    }

    public static String d(a r4) {
        Set<Integer> r0 = com.larus.bmhome.chat.markdown.richtext.s.a;
        String r1 = com.larus.bmhome.chat.markdown.richtext.s.a(r4.a, r4.e, r4.c, r4.d);
        if (r1 != null) goto L7;
        return null;
    L7:
        return "[" + r4.b + "](" + r1 + ") ";
    }

    public static List e(JsonArray r6) {
        ArrayList r0 = new ArrayList();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        CollectionsKt.addAll(r0, f(((JsonElement) r7.next()).getAsJsonObject()));
        goto L4
    L6:
        HashSet r8 = new HashSet();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L15;
        Object r3 = r2.next();
        a r4 = (a) r3;
        StringBuilder r5 = new StringBuilder();
        r5.append(r4.a);
        r5.append('_');
        String r9 = r4.c;
        if (r9 != null) goto L12;
        r9 = "";
    L12:
        r5.append(r9);
        if (r8.add(r5.toString()) == false) goto L8;
        r1.add(r3);
        goto L8
    L15:
        return r1;
    }

    public static List f(JsonObject r11) {
        JsonElement r12 = r11.get("skill_conf");
        if (r12 == null) goto L64;
        if (r12.isJsonObject() == true) goto L8;
        r12 = null;
    L8:
        if (r12 == null) goto L64;
        JsonObject r13 = r12.getAsJsonObject();
        if (r13 == null) goto L64;
        JsonArray r14 = c(r13, "skills");
        if (r14 == null) goto L64;
        ArrayList r0 = new ArrayList();
        Iterator r15 = r14.iterator();
    L15:
        if (r15.hasNext() == false) goto L62;
        JsonObject r2 = ((JsonElement) r15.next()).getAsJsonObject();
        JsonElement r3 = r2.get("name");
        if (r3 == null) goto L22;
        String r4 = r3.getAsString();
        if (r4 == null) goto L22;
    L21:
        String r6 = r4;
        if (StringsKt.isBlank(r6) == false) goto L31;
    L30:
        a r5 = null;
    L60:
        if (r5 == null) goto L15;
        r0.add(r5);
        goto L15
    L31:
        JsonElement r7 = r2.get("display_name");
        if (r7 == null) goto L37;
        String r8 = r7.getAsString();
        if (r8 == null) goto L37;
        String r9 = r8;
    L38:
        JsonElement r10 = r2.get("external_skill_id");
        if (r10 == null) goto L42;
        String r16 = r10.getAsString();
        if (r16 == null) goto L42;
    L45:
        String r17 = r16;
    L47:
        JsonElement r18 = r2.get("path");
        if (r18 == null) goto L50;
        String r19 = r18.getAsString();
    L51:
        JsonElement r20 = r2.get("skill_type");
        if (r20 == null) goto L54;
        Integer r21 = Integer.valueOf(r20.getAsInt());
    L57:
        Integer r110 = r21;
    L59:
        r5 = new a(r6, r9, r17, r19, r110);
        goto L60
    L54:
        JsonElement r22 = r2.get("type");
        if (r22 == null) goto L58;
        r21 = Integer.valueOf(r22.getAsInt());
        goto L57
    L58:
        r110 = null;
        goto L59
    L50:
        r19 = null;
    L42:
        JsonElement r23 = r2.get("skill_id");
        if (r23 == null) goto L46;
        r16 = r23.getAsString();
        goto L45
    L46:
        r17 = null;
    L37:
        r9 = r6;
    L22:
        JsonElement r24 = r2.get("display_name");
        if (r24 == null) goto L25;
        r4 = r24.getAsString();
    L26:
        if (r4 != null) goto L21;
    L25:
        r4 = null;
        goto L26
    L62:
        return r0;
    L64:
        return CollectionsKt.emptyList();
    }

    public static JsonArray c(JsonObject r1, String r2) {
        JsonElement r3 = r1.get(r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.isJsonArray() == true) goto L8;
        r3 = null;
    L8:
        if (r3 != null) goto L10;
        return null;
    L10:
        return r3.getAsJsonArray();
    }
}
