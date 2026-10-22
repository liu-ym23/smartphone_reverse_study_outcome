package com.larus.bmhome.taskskill;

import com.larus.bmhome.chat.markdown.richtext.s;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.taskskill.model.TaskSkill;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h2 {
    public static final Set<String> a = null;

    static {
        a = SetsKt.setOf(new String[]{"task_skill_local_temp_runtime_type", "task_skill_local_temp_selected_skills", "task_skill_local_temp_local_selected_skills"});
    }

    public static String a(List r7) {
        Intrinsics.checkNotNullParameter(r7, "selectedSkills");
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.iterator();
    L3:
        boolean r2 = true;
        if (r8.hasNext() == false) goto L26;
        Object r1 = r8.next();
        TaskSkill r3 = (TaskSkill) r1;
        String r4 = r3.getName();
        if (r4 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L23;
        String r6 = r3.e();
        if (r6 != null) goto L16;
    L19:
        boolean r9 = true;
    L20:
        if (r9 == false) goto L23;
        r2 = false;
        goto L23
    L16:
        if (StringsKt.isBlank(r6) == true) goto L19;
        r9 = false;
    L23:
        if (r2 == false) goto L3;
        r0.add(r1);
        goto L3
    L8:
        if (StringsKt.isBlank(r4) == true) goto L11;
        r5 = false;
        goto L12
    L26:
        if (r0.isEmpty() == false) goto L28;
        return null;
    L28:
        JSONArray r10 = new JSONArray();
        Iterator r11 = r0.iterator();
    L30:
        if (r11.hasNext() == false) goto L57;
        TaskSkill r12 = (TaskSkill) r11.next();
        JSONObject r13 = new JSONObject();
        String r14 = r12.getName();
        if (r14 != null) goto L34;
    L39:
        String r15 = r12.d();
        if (r15 != null) goto L42;
    L47:
        r13.put("skill_type", r12.getType());
        String r16 = r12.e();
        if (r16 == null) goto L55;
        if ((!StringsKt.isBlank(r16)) == true) goto L53;
        r16 = null;
    L53:
        if (r16 == null) goto L55;
        r13.put(MusicAppletPage.KEY_PATH, r16);
    L55:
        r10.put(r13);
        goto L30
    L42:
        if ((!StringsKt.isBlank(r15)) == true) goto L45;
        r15 = null;
    L45:
        if (r15 == null) goto L47;
        r13.put("skill_id", r15);
        goto L47
    L34:
        if ((!StringsKt.isBlank(r14)) == true) goto L37;
        r14 = null;
    L37:
        if (r14 == null) goto L39;
        r13.put("name", r14);
        goto L39
    L57:
        return r10.toString();
    }

    public static String b(TaskSkill r3) {
        Intrinsics.checkNotNullParameter(r3, "skill");
        Set r0 = s.a;
        String r1 = r3.getName();
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        return s.a(r1, Integer.valueOf(r3.getType()), r3.d(), r3.e());
    }

    public static String c(List r9) {
        ArrayList r0 = new ArrayList();
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L12;
        TaskSkill r1 = (TaskSkill) r10.next();
        String r2 = b(r1);
        if (r2 != null) goto L8;
        String r3 = null;
    L9:
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L8:
        r3 = "[" + r1.c() + "](" + r2 + ") ";
        goto L9
    L12:
        return CollectionsKt.joinToString$default(r0, "", null, null, 0, null, null, 62, null);
    }

    public static boolean d(Map r4) {
        Set<String> r0 = a;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L25;
        String r2 = (String) r1.next();
        if (r4 != null) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == true) goto L9;
        return false;
    L13:
        if (r4.containsKey(r2) != true) goto L15;
        r3 = true;
        goto L16
    L25:
        return true;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return true;
    }
}
