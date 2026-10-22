package rm8;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.standarduikit.interaction.assembler.InteractionQuickReplyAssembler;
import com.larus.bmhome.chat.standarduikit.interaction.view.InteractionQuickReplyView;
import com.larus.bmhome.chat.standarduikit.interaction.viewmodel.e;
import com.larus.bmhome.chat.standarduikit.interaction.viewmodel.g;
import com.larus.bmhome.chat.standarduikit.interaction.viewmodel.j;
import com.larus.bmhome.chat.standarduikit.interaction.viewmodel.m;
import com.larus.bmhome.interactionpanel.w;
import com.larus.bmhome.interactionpanel.x;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.taskskill.service.l;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ActionType;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyDecisionContext;
import com.larus.im.bean.message.block.QuickReplyItem;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import jc8.c;
import jc8.d;
import kc8.y;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tp8.f;
import tp8.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends jc8.b<rm8.a> {
    public InteractionQuickReplyAssembler d;

    public static final class a {
    }

    static {
    }

    public final String c() {
        return "QuickReplyInputPanelBlockHolder";
    }

    public final void i() {
        InteractionQuickReplyAssembler r0 = this.d;
        if (r0 == null) goto L11;
        m r1 = (m) r0.b.getValue();
        r1.h++;
        l r2 = r1.i;
        if (r2 == null) goto L7;
        r2.dispose();
    L7:
        r1.i = null;
        r1.j.b();
        g r3 = r1.c;
        if (r3 == null) goto L10;
        r3.dispose();
    L10:
        r1.c = null;
        r1.b = null;
        r1.d = CollectionsKt.emptyList();
        r1.e = null;
        r1.f = false;
        r1.g = true;
        r1.k = false;
    L11:
        this.d = null;
    }

    public b() {
    }

    public final d f(jc8.a r2) {
        Intrinsics.checkNotNullParameter((rm8.a) r2, "blockModel");
        return new d(0, 0, 0, 0);
    }

    public final void g(jc8.a r35) {
        rm8.a r0 = (rm8.a) r35;
        Intrinsics.checkNotNullParameter(r0, "blockModel");
        h r2 = (h) c.a(this, h.class);
        f r3 = (f) c.a(this, f.class);
        View r4 = ((jc8.b) this).c;
        if (r4 == null) goto L5;
        Context r5 = r4.getContext();
    L7:
        if ((r5 instanceof ContextWrapper) == false) goto L12;
        if ((r5 instanceof FragmentActivity) == true) goto L10;
        r5 = ((ContextWrapper) r5).getBaseContext();
        goto L7
    L10:
        FragmentActivity r6 = (FragmentActivity) r5;
    L13:
        boolean r7 = true;
        if (r6 == null) goto L22;
        if (r3 == null) goto L22;
        if (r2 == null) goto L22;
        BlockContent r8 = ((jc8.a) r0).a.getContent();
        if (r8 == null) goto L20;
        QuickReplyBlock r9 = r8.getQuickReplyBlock();
    L21:
        if (r9 == null) goto L22;
    L42:
        j r10 = new j(r6, r2, r3);
        kc8.b r11 = c.a(this, kc8.b.class);
        InteractionQuickReplyAssembler r12 = this.d;
        if (r12 == null) goto L342;
        BlockContent r13 = ((jc8.a) r0).a.getContent();
        if (r13 == null) goto L69;
        QuickReplyBlock r19 = r13.getQuickReplyBlock();
        if (r19 == null) goto L69;
        Message r14 = r0.j();
        if (r11 == null) goto L52;
        y r15 = r11.a;
    L53:
        jc8.a r16 = r0.k();
        if (r16 == null) goto L56;
        long r17 = r16.c;
    L57:
        String r18 = r14.getMessageId();
        String r110 = ((jc8.a) r0).g;
        if (r15 == null) goto L63;
        Function0 r20 = r15.f;
        if (r20 == null) goto L63;
        String r21 = (String) r20.invoke();
        if (r21 == null) goto L63;
    L64:
        String r111 = r21;
        String r112 = r14.getSenderId();
        Map r113 = r14.getExt();
        w r22 = (w) c.a(this, w.class);
        if (r22 != null) goto L67;
        w r23 = x.b(r14, ((jc8.a) r0).a);
    L68:
        com.larus.bmhome.chat.standarduikit.interaction.viewmodel.f r24 = new com.larus.bmhome.chat.standarduikit.interaction.viewmodel.f(r18, r110, r111, r112, r113, r17, r19, r23, 16);
    L70:
        com.larus.bmhome.chat.standarduikit.interaction.viewmodel.f r25 = r24;
        Intrinsics.checkNotNullParameter(r25, "vmData");
        m r26 = (m) r12.b.getValue();
        r26.getClass();
        Intrinsics.checkNotNullParameter(r25, "vmData");
        r26.h++;
        l r114 = r26.i;
        if (r114 == null) goto L73;
        r114.dispose();
    L73:
        g r115 = r26.c;
        if (r115 == null) goto L76;
        r115.dispose();
    L76:
        r26.i = null;
        r26.e = null;
        r26.f = false;
        r26.g = false;
        r26.b = r25;
        r26.c = r10;
        QuickReplyBlock r27 = r25.h;
        if (r27 == null) goto L79;
        List r28 = r27.getItems();
    L80:
        if (r28 != null) goto L82;
        r28 = CollectionsKt.emptyList();
    L82:
        ArrayList r116 = new ArrayList();
        Iterator r29 = r28.iterator();
    L84:
        if (r29.hasNext() == false) goto L95;
        Object r117 = r29.next();
        String r118 = ((QuickReplyItem) r117).getText();
        if (r118 != null) goto L88;
    L91:
        boolean r119 = true;
    L93:
        if ((!r119) == false) goto L84;
        r116.add(r117);
        goto L84
    L88:
        if (StringsKt.isBlank(r118) == true) goto L91;
        r119 = false;
        goto L93
    L95:
        r26.d = r116;
        r26.l = null;
        e r30 = r26.j;
        e.g.getClass();
        Intrinsics.checkNotNullParameter(r25, "vmData");
        String r1 = r25.b;
        if (r1 != null) goto L98;
    L301:
        e.b r31 = null;
    L302:
        e.b r32 = r30.d;
        if (r32 == null) goto L305;
        com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a.b r33 = e.e(r32);
    L306:
        if (r31 == null) goto L308;
        com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a.b r34 = e.e(r31);
    L310:
        if (Intrinsics.areEqual(r33, r34) == false) goto L312;
        r30.d = r31;
    L314:
        if (r26.k == false) goto L316;
        r26.j.d();
    L316:
        r12.a();
        return;
    L312:
        r30.b();
        r30.d = r31;
        r30.e = null;
        r30.f = false;
        goto L314
    L308:
        r34 = null;
        goto L310
    L305:
        r33 = null;
        goto L306
    L98:
        if ((!StringsKt.isBlank(r1)) == false) goto L100;
        String r120 = r1;
    L101:
        if (r120 == null) goto L301;
        String r36 = r25.a;
        if (r36 == null) goto L301;
        if ((!StringsKt.isBlank(r36)) == false) goto L108;
        String r121 = r36;
    L109:
        if (r121 == null) goto L301;
        QuickReplyBlock r37 = r25.h;
        if (r37 == null) goto L118;
        Integer r122 = r37.getInteractionType();
        if (r122 == null) goto L301;
        int r123 = r122.intValue();
        if (e.h.contains(Integer.valueOf(r123)) == false) goto L118;
        List r124 = r37.getItems();
        if (r124 != null) goto L122;
        r124 = CollectionsKt.emptyList();
    L122:
        Map r125 = (Map) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(r124), new com.larus.bmhome.chat.standarduikit.interaction.viewmodel.d()));
        QuickReplyDecisionContext r126 = r37.getDecisionContext();
        if (r126 == null) goto L125;
        List r127 = r126.getSuggestedFolderPath();
    L126:
        if (r127 != null) goto L128;
        r127 = CollectionsKt.emptyList();
    L128:
        List r128 = r127;
        if ((r128 instanceof Collection) == true) goto L131;
    L133:
        Iterator r38 = r128.iterator();
    L135:
        if (r38.hasNext() == false) goto L146;
        String r129 = (String) r38.next();
        if (r129 != null) goto L139;
    L142:
        boolean r130 = true;
    L144:
        if ((!r130) == false) goto L135;
        boolean r131 = true;
    L147:
        String r39 = r25.e;
        if (r39 != null) goto L150;
    L154:
        r39 = "chat";
    L155:
        String r132 = r39;
        w r40 = r25.i;
        if (r125 == null) goto L158;
        String r133 = (String) r125.get("display_type");
    L159:
        String r134 = e.a.a(r133);
        if (r40 == null) goto L162;
        String r41 = r40.a;
    L163:
        String r42 = e.a.a(r41);
        if (r134 != null) goto L167;
        r134 = r42;
    L167:
        if (r134 != null) goto L169;
    L184:
        String r135 = "organizer";
    L185:
        w r43 = r25.i;
        if (r125 == null) goto L188;
        String r44 = (String) r125.get("agent_type");
    L189:
        String r45 = e.a.a(r44);
        if (r43 == null) goto L192;
        String r46 = r43.b;
    L193:
        String r47 = e.a.a(r46);
        if (r45 != null) goto L197;
        r45 = r47;
    L197:
        if (Intrinsics.areEqual(r45, "cua") == false) goto L199;
    L204:
        String r136 = "computer_use_agent";
    L205:
        w r48 = r25.i;
        List r49 = r37.getItems();
        if (r49 != null) goto L208;
        r49 = CollectionsKt.emptyList();
    L208:
        Iterator r50 = r49.iterator();
    L210:
        if (r50.hasNext() == false) goto L228;
        Object r51 = r50.next();
        QuickReplyItem r137 = (QuickReplyItem) r51;
        Integer r138 = r137.getActionType();
        int r52 = ActionType.CUA_REQUEST_ACTION_BROWSER_OPERATION.getValue();
        if (r138 != null) goto L215;
    L225:
        boolean r53 = false;
    L226:
        if (r53 == false) goto L210;
    L229:
        QuickReplyItem r54 = (QuickReplyItem) r51;
        if (r54 == null) goto L296;
        String r55 = r54.getSchemaPayload();
        if (r55 == null) goto L296;
        if ((!StringsKt.isBlank(r55)) == true) goto L238;
        r55 = null;
    L238:
        if (r55 == null) goto L296;
        Result.Companion r56 = Result.Companion;     // Catch: Throwable -> L242
        Object r57 = Result.constructor-impl(new JSONObject(r55).opt("is_vm"));     // Catch: Throwable -> L242
    L245:
        if (Result.isFailure-impl(r57) == false) goto L248;
        r57 = null;
    L248:
        if ((r57 instanceof Boolean) == false) goto L251;
        Boolean r58 = (Boolean) r57;
    L290:
        if (r58 == null) goto L296;
        if (r58.booleanValue() == false) goto L294;
        String r59 = "cloud_browser_use";
    L295:
        String r210 = r59;
    L297:
        String r60 = r25.c;
        if (r60 != null) goto L300;
        r60 = "";
    L300:
        r31 = new e.b(r120, r121, r123, r131, r132, r135, r136, r48, r210, r60, AccountService.a.getUserId());
        goto L302
    L294:
        r59 = "local_browser_use";
        goto L295
    L251:
        if ((r57 instanceof Number) == false) goto L265;
    L258:
        th = move-exception;
        Result.Companion r61 = Result.Companion;
        Object r62 = Result.constructor-impl(ResultKt.createFailure(th));
    L261:
        if (Result.isFailure-impl(r62) == false) goto L263;
        r62 = null;
    L263:
        r58 = (Boolean) r62;
        goto L290
    L253:
        if (new BigDecimal(((Number) r57).toString()).longValueExact() != 0) goto L256;
        r7 = false;
    L256:
        r62 = Result.constructor-impl(Boolean.valueOf(r7));     // Catch: Throwable -> L258
        goto L261
    L265:
        if ((r57 instanceof String) == false) goto L289;
        String r63 = StringsKt.trim((String) r57).toString().toLowerCase(Locale.ROOT);
        int r64 = r63.hashCode();
        if (r64 == 48) goto L286;
        if (r64 == 49) goto L282;
        if (r64 == 3569038) goto L279;
        if (r64 != 97196323) goto L289;
        if (r63.equals("false") == false) goto L289;
    L288:
        r58 = Boolean.FALSE;
        goto L290
    L279:
        if (r63.equals("true") == false) goto L289;
    L284:
        r58 = Boolean.TRUE;
        goto L290
    L282:
        if (r63.equals("1") == true) goto L284;
    L286:
        if (r63.equals(TriggerSendLoading.NO_LOADING) == true) goto L288;
    L289:
        r58 = null;
    L242:
        th = move-exception;
        Result.Companion r65 = Result.Companion;
        r57 = Result.constructor-impl(ResultKt.createFailure(th));
    L296:
        r210 = null;
        goto L297
    L215:
        if (r138.intValue() != r52) goto L225;
        String r66 = r137.getText();
        if (r66 != null) goto L219;
    L222:
        boolean r67 = true;
    L223:
        if (r67 == true) goto L225;
        r53 = true;
        goto L226
    L219:
        if (StringsKt.isBlank(r66) == true) goto L222;
        r67 = false;
        goto L223
    L228:
        r51 = null;
        goto L229
    L199:
        if (Intrinsics.areEqual(r45, "computer_use_agent") == true) goto L204;
        if (r45 == null) goto L204;
        r136 = r45;
        goto L205
    L192:
        r46 = null;
        goto L193
    L188:
        r44 = null;
        goto L189
    L169:
        switch(r134.hashCode()) {
            case -2141605073: goto L182;
            case -2078118715: goto L178;
            case -874443254: goto L175;
            case -59919290: goto L172;
            default: goto L338;
        };
    L338:
        r135 = r134;
        goto L185
    L172:
        if (r134.equals("sub_agent") == false) goto L339;
    L180:
        r135 = "sub_agent";
        goto L185
    L339:
        r135 = r134;
        goto L185
    L175:
        if (r134.equals("thread") == true) goto L184;
        r135 = r134;
        goto L185
    L178:
        if (r134.equals("subagent") == true) goto L180;
        r135 = r134;
        goto L185
    L182:
        if (r134.equals("organizer") == true) goto L184;
        r135 = r134;
        goto L185
    L162:
        r41 = null;
        goto L163
    L158:
        r133 = null;
        goto L159
    L150:
        if ((!StringsKt.isBlank(r39)) == true) goto L153;
        r39 = null;
    L153:
        if (r39 != null) goto L155;
    L139:
        if (StringsKt.isBlank(r129) == true) goto L142;
        r130 = false;
    L146:
        r131 = false;
        goto L147
    L131:
        if (r128.isEmpty() == false) goto L133;
    L125:
        r127 = null;
    L118:
        r31 = null;
        goto L302
    L108:
        r121 = null;
        goto L109
    L100:
        r120 = null;
        goto L101
    L79:
        r28 = null;
        goto L80
    L67:
        r23 = r22;
    L63:
        r21 = r14.getConversationId();
        goto L64
    L56:
        r17 = 0;
        goto L57
    L52:
        r15 = null;
    L69:
        r24 = new com.larus.bmhome.chat.standarduikit.interaction.viewmodel.f(null, null, null, null, null, 0, null, null, 511);
        goto L70
    L342:
        return;
    L20:
        r9 = null;
    L22:
        FLogger r68 = FLogger.a;
        StringBuilder r69 = new StringBuilder("[bind] incomplete dependency, hasActivity=");
        if (r6 == null) goto L25;
        boolean r139 = true;
    L26:
        r69.append(r139);
        r69.append(", hasHostPassData=");
        if (r3 == null) goto L29;
        boolean r140 = true;
    L30:
        r69.append(r140);
        r69.append(", hasResultPassData=");
        if (r2 == null) goto L33;
        boolean r141 = true;
    L34:
        r69.append(r141);
        r69.append(", hasQuickReplyBlock=");
        BlockContent r142 = ((jc8.a) r0).a.getContent();
        if (r142 == null) goto L37;
        QuickReplyBlock r143 = r142.getQuickReplyBlock();
    L38:
        if (r143 == null) goto L40;
        boolean r144 = true;
    L41:
        r69.append(r144);
        r68.w("QuickReplyInputPanelHolder", r69.toString());
        goto L42
    L40:
        r144 = false;
        goto L41
    L37:
        r143 = null;
        goto L38
    L33:
        r141 = false;
        goto L34
    L29:
        r140 = false;
        goto L30
    L25:
        r139 = false;
        goto L26
    L12:
        r6 = null;
        goto L13
    L5:
        r5 = null;
        goto L7
    }

    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        InteractionQuickReplyAssembler r0 = this.d;
        if (r0 != null) goto L6;
        r0 = new InteractionQuickReplyAssembler(r2.getContext());
        this.d = r0;
    L6:
        return (InteractionQuickReplyView) r0.a.getValue();
    }
}
