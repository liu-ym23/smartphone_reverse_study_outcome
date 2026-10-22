package ny9;

import android.os.Bundle;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class u implements t1a.c, zs8.a {
    public final s a;
    public final long b;
    public final Bundle c;

    public u() {
        this(null);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof u) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((u) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        s r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "InstructionHitPointData(instructionArgumentData=" + this.a + ')';
    }

    public final String Y1() {
        cy9.a r0 = cy9.a.a;
        s r1 = this.a;
        if (r1 == null) goto L5;
        Bundle r2 = r1.a;
    L6:
        Bundle r3 = r0.c(r2);
        if (r3 == null) goto L9;
        Bundle r4 = r3.getBundle("instruction_hit_point_params");
    L10:
        if (r4 != null) goto L12;
        r4 = this.c;
    L12:
        if (r4 != null) goto L14;
        return null;
    L14:
        return r4.getString("conversation_id");
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final String a() {
        Bundle r0 = this.c;
        if (r0 == null) goto L6;
        String r1 = r0.getString("action_bar_key");
        if (r1 == null) goto L6;
        return r1;
    L6:
        s r2 = this.a;
        if (r2 == null) goto L13;
        z0 r3 = r2.f();
        if (r3 == null) goto L13;
        String r4 = r3.b;
        if (r4 == null) goto L13;
        return r4;
    L13:
        return null;
    }

    public final String b() {
        Bundle r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("previous_page");
    }

    public final String c() {
        cy9.a r0 = cy9.a.a;
        s r1 = this.a;
        if (r1 == null) goto L5;
        Bundle r2 = r1.a;
    L6:
        Bundle r3 = r0.c(r2);
        if (r3 == null) goto L9;
        Bundle r4 = r3.getBundle("instruction_hit_point_params");
    L11:
        if (r4 != null) goto L13;
        Bundle r5 = this.c;
        if (r5 == null) goto L20;
        String r6 = r5.getString("action_bar_item_id");
        if (r6 == null) goto L20;
        return r6;
    L20:
        s r7 = this.a;
        if (r7 == null) goto L29;
        z0 r8 = r7.f();
        if (r8 == null) goto L30;
        Long r9 = r8.a;
        if (r9 != null) goto L27;
        return null;
    L27:
        return r9.toString();
    L30:
        return null;
    L29:
        return null;
    L13:
        return r4.getString("action_bar_item_id");
    L9:
        r4 = null;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public final String d() {
        Bundle r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("bundle_template_sub_type");
    }

    public final String e() {
        Bundle r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("prompt_type");
    }

    public final String f() {
        Bundle r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("ai_generate_tab_id");
    }

    public final String g() {
        Bundle r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("tag_code");
    }

    public final String getBotId() {
        cy9.a r0 = cy9.a.a;
        s r1 = this.a;
        if (r1 == null) goto L5;
        Bundle r2 = r1.a;
    L6:
        Bundle r3 = r0.c(r2);
        if (r3 == null) goto L9;
        Bundle r4 = r3.getBundle("instruction_hit_point_params");
    L10:
        if (r4 != null) goto L12;
        r4 = this.c;
    L12:
        if (r4 != null) goto L14;
        return null;
    L14:
        return r4.getString("bot_id");
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final String getChatType() {
        cy9.a r0 = cy9.a.a;
        s r1 = this.a;
        if (r1 == null) goto L5;
        Bundle r2 = r1.a;
    L6:
        Bundle r3 = r0.c(r2);
        if (r3 == null) goto L9;
        Bundle r4 = r3.getBundle("instruction_hit_point_params");
    L10:
        if (r4 != null) goto L12;
        r4 = this.c;
    L12:
        if (r4 != null) goto L14;
        return null;
    L14:
        return r4.getString("chat_type");
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final String getClickFrom() {
        Bundle r0 = this.c;
        if (r0 == null) goto L5;
        String r1 = r0.getString("click_from");
    L6:
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        if (r1.length() != 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L15;
        return "ai_generate_feed_image";
    L15:
        return r1;
    L11:
        r2 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final String getEnterMethod() {
        cy9.a r0 = cy9.a.a;
        s r1 = this.a;
        String r2 = null;
        if (r1 == null) goto L5;
        Bundle r3 = r1.a;
    L6:
        Bundle r4 = r0.c(r3);
        if (r4 == null) goto L9;
        Bundle r5 = r4.getBundle("instruction_hit_point_params");
    L10:
        if (r5 != null) goto L12;
        r5 = this.c;
    L12:
        if (r5 == null) goto L14;
        r2 = r5.getString("enter_method");
    L14:
        if (r2 != null) goto L17;
        return "";
    L17:
        return r2;
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final String getTemplateType() {
        Bundle r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("bundle_template_type");
    }

    public final String h() {
        Bundle r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("ai_creation_recommend_from");
    }

    public final String i() {
        Bundle r0 = this.c;
        if (r0 == null) goto L6;
        String r1 = r0.getString("action_bar_template_type");
        if (r1 == null) goto L6;
        return r1;
    L6:
        s r2 = this.a;
        if (r2 == null) goto L11;
        com.larus.bmhome.actionbar.model.r r3 = r2.k();
        if (r3 == null) goto L11;
        return r3.g;
    L11:
        return null;
    }

    public final String j() {
        Bundle r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("ai_generate_tab_type");
    }

    public final String k() {
        Bundle r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("visual_size");
    }

    public final boolean l() {
        Bundle r0 = this.c;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getBoolean("enable_show_update_dialog");
    }

    public final String m() {
        Bundle r0 = this.c;
        if (r0 == null) goto L6;
        String r1 = r0.getString("action_bar_template_id");
        if (r1 == null) goto L6;
        return r1;
    L6:
        s r2 = this.a;
        if (r2 == null) goto L13;
        com.larus.bmhome.actionbar.model.r r3 = r2.k();
        if (r3 == null) goto L13;
        Integer r4 = r3.a;
        if (r4 == null) goto L13;
        return r4.toString();
    L13:
        return null;
    }

    public final String n() {
        Bundle r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("prompt_from");
    }

    public final String o() {
        Bundle r0 = this.c;
        if (r0 == null) goto L6;
        String r1 = r0.getString("reference_image_scene");
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final String p() {
        Bundle r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("ai_generate_tab_name");
    }

    public final String q() {
        s r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L5;
        com.larus.bmhome.actionbar.model.r r2 = r0.k();
    L6:
        if (r2 == null) goto L8;
        Integer r3 = r2.a;
    L9:
        if (r3 != null) goto L12;
    L13:
        if (r3 != null) goto L16;
    L18:
        if (r3 != null) goto L21;
    L22:
        if (r3 != null) goto L25;
    L27:
        if (r3 != null) goto L30;
    L32:
        Bundle r4 = this.c;
        if (r4 == null) goto L35;
        r1 = r4.getString("current_page");
    L35:
        if (r1 != null) goto L43;
        return "";
    L43:
        return r1;
    L30:
        if (r3.intValue() != 28) goto L32;
        return "ai_generate_feed";
    L25:
        if (r3.intValue() != 24) goto L27;
    L38:
        return "video_generate";
    L21:
        if (r3.intValue() == 18) goto L38;
    L16:
        if (r3.intValue() != 16) goto L18;
    L39:
        return "image_generate";
    L12:
        if (r3.intValue() == 4) goto L39;
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public final String r() {
        s r0 = this.a;
        Integer r1 = null;
        if (r0 == null) goto L5;
        com.larus.bmhome.actionbar.model.r r2 = r0.k();
    L6:
        if (r2 == null) goto L9;
        r1 = r2.a;
    L9:
        if (r1 != null) goto L12;
    L13:
        if (r1 != null) goto L16;
    L18:
        if (r1 != null) goto L21;
        return "ai_generate_feed_image";
    L21:
        if (r1.intValue() != 18) goto L25;
        return "ai_generate_feed_video";
    L25:
        return "ai_generate_feed_image";
    L16:
        if (r1.intValue() != 16) goto L18;
        return "ai_generate_feed_image";
    L12:
        if (r1.intValue() != 4) goto L13;
        return "ai_generate_feed_image";
    L5:
        r2 = null;
        goto L6
    }

    public u(s r3) {
        this.a = r3;
        this.b = System.currentTimeMillis();
        if (r3 == null) goto L7;
        Bundle r4 = r3.a;
        if (r4 == null) goto L7;
        Bundle r5 = r4.getBundle("instruction_hit_point_params");
    L8:
        this.c = r5;
        return;
    L7:
        r5 = null;
        goto L8
    }

    public final void s(UserCreation r5) {
        Bundle r0 = this.c;
        String r1 = null;
        if (r0 == null) goto L10;
        if (r5 == null) goto L8;
        UserCreationTrackParams r2 = r5.n;
        if (r2 == null) goto L8;
        String r3 = r2.d;
    L9:
        r0.putString("ai_generate_tab_id", r3);
    L8:
        r3 = null;
    L10:
        Bundle r4 = this.c;
        if (r4 == null) goto L18;
        if (r5 == null) goto L16;
        UserCreationTrackParams r6 = r5.n;
        if (r6 == null) goto L16;
        String r7 = r6.e;
    L17:
        r4.putString("ai_generate_tab_name", r7);
    L16:
        r7 = null;
    L18:
        Bundle r8 = this.c;
        if (r8 == null) goto L26;
        if (r5 == null) goto L24;
        UserCreationTrackParams r9 = r5.n;
        if (r9 == null) goto L24;
        String r10 = r9.f;
    L25:
        r8.putString("ai_generate_tab_type", r10);
    L24:
        r10 = null;
    L26:
        Bundle r11 = this.c;
        if (r11 == null) goto L32;
        if (r5 == null) goto L30;
        String r12 = zp9.d.d(r5);
    L31:
        r11.putString("bundle_template_type", r12);
        goto L32
    L30:
        r12 = null;
    L32:
        Bundle r13 = this.c;
        if (r13 == null) goto L38;
        if (r5 == null) goto L36;
        r1 = zp9.d.c(r5);
    L36:
        r13.putString("bundle_template_sub_type", r1);
        return;
    }
}
