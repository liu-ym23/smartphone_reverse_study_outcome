package com.larus.bmhome.chat.list.cell.nested_file;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.layout.holder.helper.w0;
import com.larus.bmhome.chat.layout.holder.menu.item.AttachmentCiteCopyMenuHandler;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.uaigc.service.ICreationReportService;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ny9.b;
import org.json.JSONObject;
import tx9.t1;
import yc9.l1;
import yc9.n1;
import yc9.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z implements BaseResourceViewHolder.a {
    public final /* synthetic */ int a;
    public final /* synthetic */ NewNestedFileCell b;
    public final /* synthetic */ Message c;
    public final /* synthetic */ NestedFileContent d;

    public final boolean b(String r32, View r33) {
        Intrinsics.checkNotNullParameter(r32, "key");
        Intrinsics.checkNotNullParameter(r33, "v");
        FLogger.a.i("NestedFileCell", "[onLongClick] key:" + r32 + " position:" + this.a);
        NewNestedFileCell r3 = this.b;
        Message r5 = this.c;
        int r4 = NewNestedFileCell.s;
        com.larus.bmhome.chat.component.cvs.y r6 = r3.r();
        if (r6 == null) goto L5;
        r6.h();
    L5:
        ic8.e.a.getClass();
        com.larus.bmhome.chat.layout.holder.helper.f r8 = new com.larus.bmhome.chat.layout.holder.helper.f(ic8.e.b(r5, r32), new b0());
        q0 r7 = lf8.a.b(r3);
        q0 r9 = lf8.a.b(r3);
        Integer r10 = null;
        if (r9 == null) goto L8;
        q0.a r11 = r9.getProvider();
    L9:
        boolean r12 = false;
        List r13 = CollectionsKt.listOf(new com.larus.bmhome.chat.layout.holder.menu.item.a[]{new AttachmentCiteCopyMenuHandler(), new com.larus.bmhome.chat.layout.holder.menu.item.d()});
        JSONObject r14 = new JSONObject();
        if (r32 != null) goto L12;
    L13:
        r12 = true;
    L14:
        if (r12 == true) goto L16;
        r14.put("attachment_target_file_identifier", r32);
    L16:
        NestedFileContent r15 = com.larus.bmhome.chat.bean.d.f(r5);
        Intrinsics.checkNotNullParameter(r15, "<this>");
        UplinkFileEntity r16 = v0.i(r15, r32);
        if (r16 == null) goto L27;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        if (n1.d(r16) == false) goto L23;
        int r17 = 6;
    L26:
        r10 = Integer.valueOf(r17);
        goto L27
    L23:
        if (n1.e(r16) == false) goto L25;
        r17 = 5;
        goto L26
    L25:
        r17 = 7;
    L27:
        if (r10 == null) goto L29;
        r14.put("content_type", r10.intValue());
    L29:
        Unit r18 = Unit.INSTANCE;
        new w0(new com.larus.bmhome.chat.layout.holder.helper.o(r5, r7, r11, r8, r13, r14, null, 64)).onLongClick(r33);
        ic8.u r2 = ic8.u.a;
        Message r19 = this.c;
        r2.getClass();
        UplinkFileEntity r1 = ic8.u.b(r19, r32);
        String r110 = this.c.getMessageId();
        Boolean r111 = Boolean.valueOf(com.larus.bmhome.chat.bean.d.Q0(this.c));
        Boolean r27 = Boolean.FALSE;
        ic8.o.a.getClass();
        t1.a(null, null, "chat", "user", r110, r111, null, null, null, "default", null, "private", null, r27, ic8.o.b(r1), null, 76707);
        return true;
    L12:
        if (StringsKt.isBlank(r32) == false) goto L14;
    L8:
        r11 = null;
        goto L9
    }

    public final void a(String r67, int r68, View r69) {
        Intrinsics.checkNotNullParameter(r67, "key");
        Intrinsics.checkNotNullParameter(r69, "v");
        FLogger.a.i("NestedFileCell", "[onClick] event:" + r68 + ", key:" + r67 + " position:" + this.a);
        String r5 = "";
        Bundle r6 = null;
        String r7 = null;
        r7 = null;
        r7 = null;
        String r8 = null;
        r8 = null;
        r8 = null;
        String r9 = null;
        boolean r10 = false;
        switch(r68) {
            case 103: goto L184;
            case 104: goto L156;
            case 105: goto L153;
            case 106: goto L222;
            case 107: goto L79;
            case 108: goto L5;
            default: goto L222;
        };
    L5:
        NewNestedFileCell r0 = this.b;
        Message r3 = this.c;
        NestedFileContent r11 = this.d;
        int r12 = NewNestedFileCell.s;
        r0.getClass();
        List r13 = r11.getEntities();
        if (r13 == null) goto L15;
        Iterator r14 = r13.iterator();
    L9:
        if (r14.hasNext() == false) goto L13;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((UplinkFileEntity) r15).getFileIdentifier(), r67) == false) goto L9;
    L14:
        UplinkFileEntity r16 = (UplinkFileEntity) r15;
    L16:
        if (r16 == null) goto L23;
        Integer r1 = r16.getFileReviewStatus();
        int r17 = FileReviewState.NOT_COMPLIANT.getValue();
        if (r1 == null) goto L23;
        if (r1.intValue() != r17) goto L23;
        boolean r2 = true;
    L24:
        if (r2 == true) goto L33;
        if (r16 == null) goto L33;
        Image r4 = l1.c(r16);
        if (r4 == null) goto L33;
        String r18 = r16.getFileIdentifier();
        if (r18 == null) goto L32;
        r5 = r18;
    L32:
        r4.localResPath = com.larus.bmhome.chat.sendimage.e.h(r3, r5);
        Image r28 = r4;
    L34:
        Activity r19 = AppHost.a.a().getCurrentActivity();
        if (r19 == null) goto L53;
        Pair r20 = r0.t();
        if (r20 == null) goto L53;
        z0 r110 = (z0) r20.getFirst();
        if (r110 == null) goto L53;
        ICreationWorkflowService.Companion r21 = ICreationWorkflowService.a;
        Pair r22 = r0.t();
        if (r22 != null) goto L43;
    L45:
        boolean r23 = false;
    L46:
        ChatParam r111 = r0.o(r23);
        Pair r24 = r0.t();
        if (r24 != null) goto L49;
    L51:
        boolean r112 = false;
    L52:
        r21.f0(new b(false, r19, r110, r111, r112, false, null, null, null, null, null, null, null, null, r28, null, null, null, null, false, false, new d0(), null, com.larus.utils.f.c(new Pair[]{TuplesKt.to("image_second_edit_scene", "generated_img_edit")}), false, null, null, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, (ChatPageContext) lf8.a.c(r0, ChatPageContext.class), null, lf8.a.d(r0), null, null, false, -10502175, 241663));
        goto L53
    L49:
        if (((Boolean) r24.getSecond()).booleanValue() != true) goto L51;
        r112 = true;
        goto L52
    L43:
        if (((Boolean) r22.getSecond()).booleanValue() != true) goto L45;
        r23 = true;
    L53:
        hy9.d r113 = ICreationReportService.a.j();
        Context r25 = lf8.a.getContext(r0);
        if (r25 == null) goto L56;
        String r114 = r25.getString(2131906331);
    L57:
        BotModel r26 = r0.f;
        if (r26 == null) goto L60;
        String r115 = r26.getBotId();
    L61:
        Pair r27 = r0.t();
        if (r27 == null) goto L70;
        z0 r29 = (z0) r27.getFirst();
        if (r29 == null) goto L70;
        com.larus.bmhome.actionbar.model.r r30 = r29.q;
        if (r30 == null) goto L70;
        Integer r31 = r30.a;
        if (r31 == null) goto L70;
        String r210 = r31.toString();
    L71:
        Pair r32 = r0.t();
        if (r32 == null) goto L78;
        z0 r33 = (z0) r32.getFirst();
        if (r33 == null) goto L78;
        com.larus.bmhome.actionbar.model.r r34 = r33.q;
        if (r34 == null) goto L78;
        r7 = r34.g;
    L78:
        ChatControlTrace r35 = ChatControlTrace.b;
        r35.getClass();
        hy9.d.a.a(r113, r114, null, null, "picture_overview", "single_function", r115, null, r210, r7, r35.bb(ChatControlTrace.y), null, null, null, null, null, null, null, null, null, null, null, 4193350);
        return;
    L70:
        r210 = null;
        goto L71
    L60:
        r115 = null;
        goto L61
    L56:
        r114 = null;
    L33:
        r28 = null;
    L23:
        r2 = false;
        goto L24
    L13:
        r15 = null;
        goto L14
    L15:
        r16 = null;
        goto L16
    L79:
        NewNestedFileCell r36 = this.b;
        Message r37 = this.c;
        NestedFileContent r38 = this.d;
        int r116 = NewNestedFileCell.s;
        r36.getClass();
        List r39 = r38.getEntities();
        if (r39 == null) goto L89;
        Iterator r40 = r39.iterator();
    L83:
        if (r40.hasNext() == false) goto L87;
        Object r117 = r40.next();
        if (Intrinsics.areEqual(((UplinkFileEntity) r117).getFileIdentifier(), r67) == false) goto L83;
    L88:
        UplinkFileEntity r118 = (UplinkFileEntity) r117;
    L90:
        if (r118 == null) goto L97;
        Integer r41 = r118.getFileReviewStatus();
        int r42 = FileReviewState.NOT_COMPLIANT.getValue();
        if (r41 == null) goto L97;
        if (r41.intValue() != r42) goto L97;
        boolean r43 = true;
    L98:
        if (r43 == true) goto L107;
        if (r118 == null) goto L107;
        Image r44 = l1.c(r118);
        if (r44 == null) goto L107;
        String r45 = r118.getFileIdentifier();
        if (r45 == null) goto L106;
        r5 = r45;
    L106:
        r44.localResPath = com.larus.bmhome.chat.sendimage.e.h(r37, r5);
        Image r211 = r44;
    L108:
        Activity r119 = AppHost.a.a().getCurrentActivity();
        if (r119 == null) goto L127;
        Pair r46 = r36.s();
        if (r46 == null) goto L127;
        z0 r120 = (z0) r46.getFirst();
        if (r120 == null) goto L127;
        ICreationWorkflowService.Companion r47 = ICreationWorkflowService.a;
        Pair r48 = r36.s();
        if (r48 != null) goto L117;
    L119:
        boolean r49 = false;
    L120:
        ChatParam r121 = r36.o(r49);
        Pair r50 = r36.s();
        if (r50 != null) goto L123;
    L125:
        boolean r122 = false;
    L126:
        r47.f0(new b(false, r119, r120, r121, r122, false, null, null, null, null, null, null, null, null, r211, null, null, null, null, false, false, new c0(), null, com.larus.utils.f.c(new Pair[]{TuplesKt.to("image_second_edit_scene", "generated_img_edit")}), false, null, null, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, (ChatPageContext) lf8.a.c(r36, ChatPageContext.class), null, lf8.a.d(r36), null, null, false, -10502175, 241663));
        goto L127
    L123:
        if (((Boolean) r50.getSecond()).booleanValue() != true) goto L125;
        r122 = true;
        goto L126
    L117:
        if (((Boolean) r48.getSecond()).booleanValue() != true) goto L119;
        r49 = true;
    L127:
        hy9.d r123 = ICreationReportService.a.j();
        Context r51 = lf8.a.getContext(r36);
        if (r51 == null) goto L130;
        String r124 = r51.getString(2131906324);
    L131:
        BotModel r52 = r36.f;
        if (r52 == null) goto L134;
        String r125 = r52.getBotId();
    L135:
        Pair r53 = r36.s();
        if (r53 == null) goto L144;
        z0 r54 = (z0) r53.getFirst();
        if (r54 == null) goto L144;
        com.larus.bmhome.actionbar.model.r r55 = r54.q;
        if (r55 == null) goto L144;
        Integer r56 = r55.a;
        if (r56 == null) goto L144;
        String r212 = r56.toString();
    L145:
        Pair r57 = r36.s();
        if (r57 == null) goto L152;
        z0 r58 = (z0) r57.getFirst();
        if (r58 == null) goto L152;
        com.larus.bmhome.actionbar.model.r r59 = r58.q;
        if (r59 == null) goto L152;
        r8 = r59.g;
    L152:
        ChatControlTrace r60 = ChatControlTrace.b;
        r60.getClass();
        hy9.d.a.a(r123, r124, null, null, "picture_overview", "edit_entrance", r125, null, r212, r8, r60.bb(ChatControlTrace.y), null, null, null, null, null, null, null, null, null, null, null, 4193350);
        return;
    L144:
        r212 = null;
        goto L145
    L134:
        r125 = null;
        goto L135
    L130:
        r124 = null;
    L107:
        r211 = null;
    L97:
        r43 = false;
        goto L98
    L87:
        r117 = null;
        goto L88
    L89:
        r118 = null;
        goto L90
    L153:
        NewNestedFileCell r61 = this.b;
        Message r62 = this.c;
        int r63 = NewNestedFileCell.s;
        r61.u();
        CoroutineScope r126 = (CoroutineScope) r61.p.getValue();
        if (r126 == null) goto L214;
        BuildersKt.launch$default(r126, Dispatchers.getIO(), null, new NewNestedFileCell$resendMsg$1(r61, r62, null), 2, null);
        return;
    L214:
        return;
    L156:
        NewNestedFileCell r64 = this.b;
        Message r127 = this.c;
        NestedFileContent r65 = this.d;
        int r66 = NewNestedFileCell.s;
        r64.getClass();
        List r128 = r65.getEntities();
        com.larus.bmhome.chat.component.cvs.y r70 = r64.r();
        if (r70 == null) goto L159;
        wc9.e r129 = r70.h();
    L160:
        BotModel r71 = r64.f;
        if (r71 == null) goto L163;
        String r130 = r71.getBotId();
    L164:
        if (r128 == null) goto L216;
        if (r129 == null) goto L217;
        if (r130 == null) goto L218;
        r64.u();
        ICoreInputAbility r72 = (ICoreInputAbility) r64.n.getValue();
        if (r72 != null) goto L170;
    L172:
        boolean r131 = true ^ r10;
        ICoreInputAbility r73 = (ICoreInputAbility) r64.n.getValue();
        if (r73 == null) goto L219;
        com.larus.bmhome.chat.component.bottom.multimodal.sender.f r132 = r73.Lk();
        if (r132 == null) goto L220;
        com.larus.bmhome.chat.component.bottom.reference.a r74 = (com.larus.bmhome.chat.component.bottom.reference.a) r64.o.getValue();
        if (r74 == null) goto L179;
        ReferenceInfo r133 = r74.T6();
    L180:
        com.larus.bmhome.chat.component.bottom.reference.a r75 = (com.larus.bmhome.chat.component.bottom.reference.a) r64.o.getValue();
        if (r75 == null) goto L183;
        r9 = r75.wf();
    L183:
        r132.e(r127, r128, r131, r129, r130, r133, r9, (ChatPageContext) lf8.a.c(r64, ChatPageContext.class));
        return;
    L179:
        r133 = null;
        goto L180
    L220:
        return;
    L219:
        return;
    L170:
        if (r72.gj() != true) goto L172;
        r10 = true;
        goto L172
    L218:
        return;
    L217:
        return;
    L216:
        return;
    L163:
        r130 = null;
        goto L164
    L159:
        r129 = null;
        goto L160
    L184:
        final NewNestedFileCell r76 = this.b;
        Message r77 = this.c;
        NestedFileContent r78 = this.d;
        int r79 = this.a;
        int r80 = NewNestedFileCell.s;
        r76.getClass();
        a0 r134 = new a0(r76, r77, r78, this);
        Function3 r135 = new p(r76);
        de8.c r81 = (de8.c) r76.q.getValue();
        if (r81 == null) goto L187;
        Bundle r82 = r81.b;
    L189:
        if (r76.w(r82) == true) goto L203;
        de8.c r83 = (de8.c) r76.q.getValue();
        if (r83 == null) goto L193;
        Bundle r84 = r83.a;
    L195:
        if (r76.w(r84) == true) goto L203;
        Fragment r85 = lf8.a.d(r76);
        if (r85 == null) goto L200;
        r6 = r85.getArguments();
    L200:
        if (r76.w(r6) == true) goto L203;
        boolean r136 = false;
    L204:
        lr8.f r137 = new lr8.f(r67, r69, r77, r78, r79, this, r134, r135, null, r136, 256);
        NestedFileClickHelper.a.getClass();
        NestedFileClickHelper.i(r137);
        return;
    L193:
        r84 = null;
    L203:
        r136 = true;
        goto L204
    L187:
        r82 = null;
        goto L189
    }

    public z(int r1, NewNestedFileCell r2, Message r3, NestedFileContent r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
