package u0a;

import com.ixigua.lib.track.TrackParams;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationCommunityInfo;
import com.larus.platform.api.creation.CreationLikeInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.uaigc.service.IUgcAIGCService;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import l0a.b;
import l0a.c;
import org.json.JSONObject;
import tx9.u3;
import zp9.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements l0a.a {

    /* JADX INFO: renamed from: u0a.a$a, reason: collision with other inner class name */
    public static final class C0077a {
    }

    static {
    }

    public a() {
    }

    @Override // l0a.a
    public final void a(b r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        UserCreation r0 = r5.a;
        JSONObject r1 = new JSONObject();
        r1.putOpt("bot_id", r5.b);
        r1.putOpt("recommend_from", r5.c);
        r1.putOpt("enter_method", r5.d);
        r1.putOpt("current_page", r5.e);
        r1.putOpt("previous_page", r5.f);
        r1.putOpt("chat_type", r5.g);
        r1.putOpt("conversation_id", r5.h);
        Integer r6 = null;
        if (r0 == null) goto L5;
        String r2 = r0.a;
    L6:
        r1.putOpt("template_id", r2);
        if (r0 == null) goto L11;
        UserCreationTrackParams r3 = r0.n;
        if (r3 == null) goto L11;
        String r4 = r3.a;
    L12:
        r1.putOpt("template_rec_req_id", r4);
        if (r0 == null) goto L15;
        String r7 = d.c(r0);
    L16:
        r1.putOpt("template_sub_type", r7);
        if (r0 == null) goto L19;
        String r8 = d.b(r0);
    L20:
        if (r8 != null) goto L22;
    L25:
        boolean r9 = true;
    L26:
        if (r9 == false) goto L28;
        r8 = "default";
    L28:
        r1.putOpt("template_source", r8);
        if (r0 == null) goto L33;
        Long r10 = r0.f;
        if (r10 == null) goto L33;
        Integer r11 = Integer.valueOf((int) r10.longValue());
    L34:
        r1.putOpt("use_template_uv", r11);
        if (r0 == null) goto L41;
        CreationCommunityInfo r12 = r0.k;
        if (r12 == null) goto L41;
        CreationLikeInfo r13 = r12.a;
        if (r13 == null) goto L41;
        Long r14 = r13.a;
    L42:
        r1.putOpt("like_template_cnt", r14);
        if (r0 == null) goto L47;
        CreationCommunityInfo r15 = r0.k;
        if (r15 == null) goto L47;
        Long r16 = r15.b;
    L48:
        r1.putOpt("comment_template_cnt", r16);
        if (r0 == null) goto L53;
        AuthorInfo r17 = r0.g;
        if (r17 == null) goto L53;
        String r18 = r17.b;
    L54:
        r1.putOpt("creator_id", r18);
        if (r0 == null) goto L59;
        UserCreationTrackParams r19 = r0.n;
        if (r19 == null) goto L59;
        r6 = r19.b;
    L59:
        r1.putOpt("page_index", r6);
        by7.a r20 = new by7.a("click_comment_ai_creation_entrance");
        r20.a.merge(new TrackParams().merge(r1));
        r20.b();
        return;
    L53:
        r18 = null;
    L47:
        r16 = null;
    L41:
        r14 = null;
    L33:
        r11 = null;
        goto L34
    L22:
        if (r8.length() == 0) goto L25;
        r9 = false;
        goto L26
    L19:
        r8 = null;
        goto L20
    L15:
        r7 = null;
    L11:
        r4 = null;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    @Override // l0a.a
    public final void b(l0a.d r7) {
        Intrinsics.checkNotNullParameter(r7, "params");
        UserCreation r0 = r7.c;
        if (r7.b == false) goto L5;
        String r1 = "double_tap";
    L6:
        JSONObject r2 = new JSONObject();
        String r3 = null;
        if (r0 == null) goto L9;
        String r4 = d.c(r0);
    L10:
        r2.putOpt("template_sub_type", r4);
        r2.putOpt("template_show_enter_method", r7.j);
        if (r0 == null) goto L15;
        AuthorInfo r5 = r0.g;
        if (r5 == null) goto L15;
        String r6 = r5.b;
    L16:
        r2.putOpt("creator_id", r6);
        if (r0 == null) goto L21;
        UserCreationTrackParams r8 = r0.n;
        if (r8 == null) goto L21;
        Integer r9 = r8.b;
    L22:
        r2.putOpt("page_index", r9);
        if (r0 == null) goto L27;
        UserCreationTrackParams r10 = r0.n;
        if (r10 == null) goto L27;
        String r11 = r10.a;
    L28:
        r2.putOpt("template_rec_req_id", r11);
        r2.putOpt("recommend_from", r7.e);
        r2.putOpt("bot_id", r7.d);
        if (r0 == null) goto L31;
        String r12 = r0.a;
    L32:
        r2.putOpt("template_id", r12);
        r2.putOpt("chat_type", r7.h);
        if (r0 == null) goto L35;
        String r13 = d.d(r0);
    L36:
        r2.putOpt("template_type", r13);
        r2.putOpt("current_page", r7.f);
        r2.putOpt("previous_page", r7.g);
        if (r0 == null) goto L41;
        Long r14 = r0.f;
        if (r14 == null) goto L41;
        Integer r15 = Integer.valueOf((int) r14.longValue());
    L42:
        r2.putOpt("use_template_uv", r15);
        r2.putOpt("conversation_id", r7.i);
        r2.putOpt("enter_method", r1);
        if (r0 == null) goto L45;
        r3 = d.b(r0);
    L45:
        if (r3 != null) goto L47;
    L50:
        boolean r16 = true;
    L51:
        if (r16 == false) goto L53;
        r3 = "default";
    L53:
        r2.putOpt("template_source", r3);
        if (r7.a == false) goto L56;
        String r17 = "unlike_ai_creation";
    L57:
        by7.a r18 = new by7.a(r17);
        r18.a.merge(new TrackParams().merge(r2));
        r18.b();
        return;
    L56:
        r17 = "like_ai_creation";
        goto L57
    L47:
        if (r3.length() == 0) goto L50;
        r16 = false;
    L41:
        r15 = null;
        goto L42
    L35:
        r13 = null;
        goto L36
    L31:
        r12 = null;
    L27:
        r11 = null;
    L21:
        r9 = null;
    L15:
        r6 = null;
        goto L16
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = "click_button";
        goto L6
    }

    @Override // l0a.a
    public final void c(c r41) {
        Intrinsics.checkNotNullParameter(r41, "params");
        UserCreation r1 = r41.a;
        String r2 = r41.e;
        if (r1 == null) goto L5;
        String r4 = r1.a;
    L6:
        if (r1 == null) goto L8;
        String r6 = d.d(r1);
    L9:
        if (r1 == null) goto L11;
        String r7 = d.c(r1);
    L12:
        if (r1 == null) goto L16;
        UserCreationTrackParams r5 = r1.n;
        if (r5 == null) goto L16;
        String r12 = r5.a;
    L17:
        if (r1 == null) goto L19;
        String r8 = d.b(r1);
    L20:
        String r9 = r41.b;
        if (r9 != null) goto L24;
        r9 = "";
    L24:
        if (r9.length() != 0) goto L26;
        boolean r10 = true;
    L27:
        if (r10 == false) goto L29;
        r9 = "template_detail_button";
    L29:
        String r11 = r9;
        if (r1 == null) goto L34;
        UserCreationTrackParams r13 = r1.n;
        if (r13 == null) goto L34;
        Integer r14 = r13.b;
    L35:
        if (r1 == null) goto L37;
        Long r20 = r1.f;
    L38:
        if (r1 == null) goto L42;
        AuthorInfo r15 = r1.g;
        if (r15 == null) goto L42;
        String r16 = r15.b;
    L43:
        if (r1 == null) goto L47;
        UserCreationTrackParams r17 = r1.n;
        if (r17 == null) goto L47;
        String r18 = r17.f;
    L48:
        if (r1 == null) goto L52;
        UserCreationTrackParams r19 = r1.n;
        if (r19 == null) goto L52;
        String r110 = r19.d;
    L53:
        if (r1 == null) goto L57;
        UserCreationTrackParams r21 = r1.n;
        if (r21 == null) goto L57;
        String r111 = r21.e;
    L58:
        if (r1 == null) goto L60;
        String r22 = r1.i;
    L61:
        if (r1 == null) goto L63;
        String r23 = d.c(r1);
    L64:
        if (r1 == null) goto L66;
        Boolean r26 = Boolean.valueOf(r1.z());
    L67:
        if (r1 == null) goto L69;
        Boolean r24 = Boolean.valueOf(r1.D());
    L70:
        if (r1 == null) goto L76;
        UserCreationRefContent r25 = r1.o;
        if (r25 == null) goto L76;
        List<ImageInfo> r27 = r25.a();
        if (r27 == null) goto L76;
        Integer r28 = Integer.valueOf(r27.size());
    L77:
        String r29 = r41.l;
        String r112 = r41.m;
        String r210 = r18;
        String r113 = r41.n;
        String r114 = r41.o;
        if (r41.d == false) goto L80;
        String r3 = "use_prompt";
    L82:
        String r30 = r3;
    L84:
        if (r1 == null) goto L86;
        String r32 = d.e(r1);
    L87:
        boolean r31 = IUgcAIGCService.a.v();
        if (r1 == null) goto L92;
        UserCreationTrackParams r33 = r1.n;
        if (r33 == null) goto L92;
        Integer r34 = r33.c;
    L93:
        Integer r35 = r41.k;
        String r36 = r41.i;
        String r115 = r41.f;
        String r116 = r41.g;
        String r117 = r41.h;
        String r118 = r41.j;
        String r119 = r41.p;
        String r0 = r41.q;
        Boolean r37 = Boolean.valueOf(r31);
        u3.l(r2, r4, r11, r36, r6, r7, r8, r16, r34, r14, r12, r35, r110, r210, r111, r115, r116, r117, r20, r118, r22, r23, r24, r28, r26, r29, null, r32, r30, r37, r112, r113, r114, r119, r0, 268435840, 0);
        return;
    L92:
        r34 = null;
        goto L93
    L86:
        r32 = null;
        goto L87
    L80:
        if (r1 == null) goto L83;
        r3 = d.a(r1, r41.c);
        goto L82
    L83:
        r30 = null;
    L76:
        r28 = null;
        goto L77
    L69:
        r24 = null;
        goto L70
    L66:
        r26 = null;
        goto L67
    L63:
        r23 = null;
        goto L64
    L60:
        r22 = null;
    L57:
        r111 = null;
    L52:
        r110 = null;
    L47:
        r18 = null;
    L42:
        r16 = null;
        goto L43
    L37:
        r20 = null;
    L34:
        r14 = null;
        goto L35
    L26:
        r10 = false;
        goto L27
    L19:
        r8 = null;
    L16:
        r12 = null;
        goto L17
    L11:
        r7 = null;
        goto L12
    L8:
        r6 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }
}
