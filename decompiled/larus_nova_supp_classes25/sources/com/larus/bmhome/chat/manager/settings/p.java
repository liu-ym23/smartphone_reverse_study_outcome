package com.larus.bmhome.chat.manager.settings;

import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.larus.bmhome.bot.m5;
import com.larus.bmhome.bot.n5;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemLongTextArrow;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.bmhome.view.item.ItemTextView;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p {
    public final u a;
    public final o b;

    public p() {
        this.a = new u();
        this.b = new o();
    }

    public final void b(m5 r4, n5 r5) {
        Intrinsics.checkNotNullParameter(r4, "conversationChanged");
        Intrinsics.checkNotNullParameter(r5, "botChanged");
        o r2 = this.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "conversationChanged");
        Intrinsics.checkNotNullParameter(r5, "botChanged");
        r2.e = r4;
        r2.f = r5;
    }

    public final void a(String r12, com.larus.bmhome.setting.c r13, List<? extends List<String>> r14) {
        Intrinsics.checkNotNullParameter(r12, "conversationId");
        Intrinsics.checkNotNullParameter(r13, "binding");
        Intrinsics.checkNotNullParameter(r14, "configGroups");
        if (r14.isEmpty() == false) goto L5;
        return;
    L5:
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r13, "binding");
        Intrinsics.checkNotNullParameter(r14, "groups");
        ArrayList r1 = new ArrayList();
        Iterator<? extends List<String>> r3 = r14.iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        Iterator<String> r4 = r3.next().iterator();
    L10:
        if (r4.hasNext() == false) goto L7;
        r1.add(r4.next());
        goto L10
    L12:
        ItemTextArrow r5 = r13.F();
        int r6 = 8;
        if (r5 != null) goto L15;
    L19:
        ItemGroup r7 = r13.M();
        boolean r8 = true;
        if (r7 == null) goto L31;
        ItemTextArrow r9 = r13.F();
        if (r9 != null) goto L24;
    L26:
        boolean r10 = false;
    L27:
        if (r10 == false) goto L29;
        int r11 = 0;
    L30:
        r7.setVisibility(r11);
        goto L31
    L29:
        r11 = 8;
        goto L30
    L24:
        if (r9.getVisibility() != 0) goto L26;
        r10 = true;
    L31:
        ItemTextArrow r15 = r13.G();
        if (r1.contains("edit_bot") == false) goto L34;
        int r16 = 0;
    L35:
        r15.setVisibility(r16);
        ItemTextArrow r17 = r13.b0();
        if (r1.contains("language") == false) goto L38;
        int r18 = 0;
    L39:
        r17.setVisibility(r18);
        ItemTextArrow r19 = r13.Z0();
        if (r1.contains("tts_voice") == false) goto L42;
        int r20 = 0;
    L43:
        r19.setVisibility(r20);
        ItemTextArrow r21 = r13.j0();
        if (r21 != null) goto L46;
    L50:
        ItemLongTextArrow r22 = r13.b();
        if (r22 != null) goto L53;
    L57:
        ItemGroup r23 = r13.N();
        if (r23 != null) goto L60;
    L101:
        ItemTextArrow r24 = r13.N0();
        if (r1.contains("clear_context") == false) goto L104;
        int r25 = 0;
    L105:
        r24.setVisibility(r25);
        ItemTextView r26 = r13.z();
        if (r26 != null) goto L108;
    L112:
        ItemGroup r2 = r13.Q();
        if (r2 == null) goto L137;
        if (r13.N0().getVisibility() != 0) goto L117;
        boolean r27 = true;
    L118:
        if (r27 == true) goto L131;
        ItemTextView r28 = r13.z();
        if (r28 != null) goto L122;
    L127:
        boolean r29 = false;
    L128:
        if (r29 == true) goto L131;
        boolean r30 = false;
    L132:
        if (r30 == false) goto L134;
        int r31 = 0;
    L135:
        r2.setVisibility(r31);
        goto L137
    L134:
        r31 = 8;
        goto L135
    L122:
        if (r28.getVisibility() != 0) goto L124;
        boolean r32 = true;
    L125:
        if (r32 != true) goto L127;
        r29 = true;
        goto L128
    L124:
        r32 = false;
    L131:
        r30 = true;
        goto L132
    L117:
        r27 = false;
    L137:
        if (r13.b1() == false) goto L369;
        ItemGroup r33 = r13.m0();
        if (r33 != null) goto L141;
    L177:
        ItemGroup r34 = r13.n0();
        if (r34 == null) goto L198;
        List r35 = r13.h1();
        if ((r35 instanceof Collection) == true) goto L182;
    L184:
        Iterator r36 = r35.iterator();
    L186:
        if (r36.hasNext() == false) goto L193;
        if (((View) r36.next()).getVisibility() != 0) goto L190;
        boolean r37 = true;
    L191:
        if (r37 == false) goto L186;
        boolean r38 = true;
    L194:
        if (r38 == false) goto L196;
        int r39 = 0;
    L197:
        r34.setVisibility(r39);
        goto L198
    L196:
        r39 = 8;
        goto L197
    L190:
        r37 = false;
    L193:
        r38 = false;
        goto L194
    L182:
        if (r35.isEmpty() == false) goto L184;
    L198:
        ItemGroup r40 = r13.q0();
        if (r40 != null) goto L201;
    L217:
        ItemGroup r41 = r13.o0();
        if (r41 != null) goto L220;
    L243:
        ItemGroup r42 = r13.p0();
        if (r42 != null) goto L246;
    L283:
        ItemGroup r43 = r13.t0();
        if (r43 != null) goto L286;
    L293:
        ItemGroup r44 = r13.h0();
        if (r44 == null) goto L332;
        ItemTextArrow r45 = r13.i0();
        if (r45 != null) goto L298;
    L303:
        boolean r46 = false;
    L304:
        if (r46 == true) goto L327;
        ItemTextToggle r47 = r13.f1();
        if (r47 != null) goto L308;
    L313:
        boolean r48 = false;
    L314:
        if (r48 == true) goto L327;
        ItemTextToggle r49 = r13.M0();
        if (r49 != null) goto L318;
    L323:
        boolean r50 = false;
    L324:
        if (r50 == true) goto L327;
        boolean r51 = false;
    L328:
        if (r51 == false) goto L330;
        int r52 = 0;
    L331:
        r44.setVisibility(r52);
        goto L332
    L330:
        r52 = 8;
        goto L331
    L318:
        if (r49.getVisibility() != 0) goto L320;
        boolean r53 = true;
    L321:
        if (r53 != true) goto L323;
        r50 = true;
        goto L324
    L320:
        r53 = false;
        goto L321
    L308:
        if (r47.getVisibility() != 0) goto L310;
        boolean r54 = true;
    L311:
        if (r54 != true) goto L313;
        r48 = true;
        goto L314
    L310:
        r54 = false;
    L327:
        r51 = true;
        goto L328
    L298:
        if (r45.getVisibility() != 0) goto L300;
        boolean r55 = true;
    L301:
        if (r55 != true) goto L303;
        r46 = true;
        goto L304
    L300:
        r55 = false;
    L332:
        ItemGroup r56 = r13.i();
        if (r56 == null) goto L347;
        ItemTextArrow r57 = r13.j();
        if (r57 != null) goto L337;
    L342:
        boolean r58 = false;
    L343:
        if (r58 == false) goto L345;
        int r59 = 0;
    L346:
        r56.setVisibility(r59);
        goto L347
    L345:
        r59 = 8;
        goto L346
    L337:
        if (r57.getVisibility() != 0) goto L339;
        boolean r60 = true;
    L340:
        if (r60 != true) goto L342;
        r58 = true;
        goto L343
    L339:
        r60 = false;
    L347:
        ItemGroup r61 = r13.r0();
        if (r61 == null) goto L369;
        ItemGroup r62 = r13.r0();
        if (r62 == null) goto L365;
        Sequence r63 = ViewGroupKt.getChildren(r62);
        if (r63 == null) goto L365;
        Iterator r64 = r63.iterator();
    L355:
        if (r64.hasNext() == false) goto L362;
        if (((View) r64.next()).getVisibility() != 0) goto L359;
        boolean r65 = true;
    L360:
        if (r65 == false) goto L355;
        boolean r66 = true;
    L363:
        if (r66 != true) goto L365;
    L366:
        if (r8 == false) goto L368;
        r6 = 0;
    L368:
        r61.setVisibility(r6);
        goto L369
    L359:
        r65 = false;
        goto L360
    L362:
        r66 = false;
    L365:
        r8 = false;
        goto L366
    L286:
        if (r13.L().getVisibility() != 0) goto L288;
        boolean r67 = true;
    L289:
        if (r67 == false) goto L291;
        int r68 = 0;
    L292:
        r43.setVisibility(r68);
        goto L293
    L291:
        r68 = 8;
        goto L292
    L288:
        r67 = false;
        goto L289
    L246:
        if (AccountService.a.isLogin().booleanValue() == false) goto L278;
        ItemTextArrow r69 = r13.y0();
        if (r69 != null) goto L250;
    L255:
        boolean r70 = false;
    L256:
        if (r70 == true) goto L277;
        ItemTextArrow r71 = r13.B0();
        if (r71 != null) goto L260;
    L265:
        boolean r72 = false;
    L266:
        if (r72 == true) goto L277;
        ItemTextView r73 = r13.d0();
        if (r73 != null) goto L270;
    L275:
        boolean r74 = false;
    L276:
        if (r74 == false) goto L278;
    L270:
        if (r73.getVisibility() != 0) goto L272;
        boolean r75 = true;
    L273:
        if (r75 != true) goto L275;
        r74 = true;
        goto L276
    L272:
        r75 = false;
        goto L273
    L260:
        if (r71.getVisibility() != 0) goto L262;
        boolean r76 = true;
    L263:
        if (r76 != true) goto L265;
        r72 = true;
        goto L266
    L262:
        r76 = false;
    L277:
        boolean r77 = true;
    L279:
        if (r77 == false) goto L281;
        int r78 = 0;
    L282:
        r42.setVisibility(r78);
        goto L283
    L281:
        r78 = 8;
        goto L282
    L250:
        if (r69.getVisibility() != 0) goto L252;
        boolean r79 = true;
    L253:
        if (r79 != true) goto L255;
        r70 = true;
        goto L256
    L252:
        r79 = false;
    L278:
        r77 = false;
        goto L279
    L220:
        if (AccountService.a.isLogin().booleanValue() == false) goto L238;
        List r80 = CollectionsKt.listOfNotNull(new ItemTextView[]{r13.u(), r13.I(), r13.a(), r13.C(), r13.v(), r13.X0(), r13.B(), r13.g1(), r13.A0()});
        if ((r80 instanceof Collection) == true) goto L224;
    L226:
        Iterator r81 = r80.iterator();
    L228:
        if (r81.hasNext() == false) goto L235;
        if (((View) r81.next()).getVisibility() != 0) goto L232;
        boolean r82 = true;
    L233:
        if (r82 == false) goto L228;
        boolean r83 = true;
    L236:
        if (r83 == false) goto L238;
        boolean r84 = true;
    L239:
        if (r84 == false) goto L241;
        int r85 = 0;
    L242:
        r41.setVisibility(r85);
        goto L243
    L241:
        r85 = 8;
        goto L242
    L232:
        r82 = false;
    L235:
        r83 = false;
        goto L236
    L224:
        if (r80.isEmpty() == false) goto L226;
    L238:
        r84 = false;
        goto L239
    L201:
        if (r13.N0().getVisibility() != 0) goto L203;
        boolean r86 = true;
    L204:
        if (r86 != true) goto L206;
    L212:
        boolean r87 = true;
    L213:
        if (r87 == false) goto L215;
        int r88 = 0;
    L216:
        r40.setVisibility(r88);
        goto L217
    L215:
        r88 = 8;
        goto L216
    L206:
        if (r13.S0().getVisibility() != 0) goto L208;
        boolean r89 = true;
    L209:
        if (r89 == true) goto L212;
        r87 = false;
        goto L213
    L208:
        r89 = false;
        goto L209
    L203:
        r86 = false;
        goto L204
    L141:
        if (r13.X().getVisibility() != 0) goto L143;
        boolean r90 = true;
    L144:
        if (r90 == false) goto L146;
    L172:
        boolean r91 = true;
    L173:
        if (r91 == false) goto L175;
        int r92 = 0;
    L176:
        r33.setVisibility(r92);
        goto L177
    L175:
        r92 = 8;
        goto L176
    L146:
        if (r13.G().getVisibility() != 0) goto L148;
        boolean r93 = true;
    L149:
        if (r93 == true) goto L172;
        if (r13.Z0().getVisibility() != 0) goto L153;
        boolean r94 = true;
    L154:
        if (r94 == true) goto L172;
        if (r13.b0().getVisibility() != 0) goto L158;
        boolean r95 = true;
    L159:
        if (r95 == true) goto L172;
        ItemTextArrow r96 = r13.J();
        if (r96 != null) goto L163;
    L168:
        boolean r97 = false;
    L169:
        if (r97 == true) goto L172;
        r91 = false;
        goto L173
    L163:
        if (r96.getVisibility() != 0) goto L165;
        boolean r99 = true;
    L166:
        if (r99 != true) goto L168;
        r97 = true;
        goto L169
    L165:
        r99 = false;
        goto L166
    L158:
        r95 = false;
        goto L159
    L153:
        r94 = false;
        goto L154
    L148:
        r93 = false;
        goto L149
    L143:
        r90 = false;
    L369:
        o r100 = this.b;
        LinearLayout r101 = r13.w();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r12, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "container");
        Intrinsics.checkNotNullParameter(r14, "configGroups");
        if (r14.isEmpty() == true) goto L397;
        z2.a.w3();
        LifecycleOwner r110 = ViewTreeLifecycleOwner.get(r101);
        if (r110 == null) goto L395;
        LifecycleCoroutineScope r0 = LifecycleOwnerKt.getLifecycleScope(r110);
        if (r0 == null) goto L396;
        BuildersKt.launch$default(r0, null, null, new SettingOptionCompose$appendOption$2(r100, r101, r12, r14, null), 3, null);
        return;
    L396:
        return;
    L395:
        return;
    L397:
        return;
    L108:
        if (r1.contains("delete_conversation") == false) goto L110;
        int r102 = 0;
    L111:
        r26.setVisibility(r102);
        goto L112
    L110:
        r102 = 8;
        goto L111
    L104:
        r25 = 8;
        goto L105
    L60:
        if (r13.G().getVisibility() != 0) goto L62;
        boolean r103 = true;
    L63:
        if (r103 == false) goto L65;
    L96:
        boolean r104 = true;
    L97:
        if (r104 == false) goto L99;
        int r105 = 0;
    L100:
        r23.setVisibility(r105);
        goto L101
    L99:
        r105 = 8;
        goto L100
    L65:
        if (r13.b0().getVisibility() != 0) goto L67;
        boolean r106 = true;
    L68:
        if (r106 == true) goto L96;
        if (r13.Z0().getVisibility() != 0) goto L72;
        boolean r107 = true;
    L73:
        if (r107 == true) goto L96;
        ItemTextArrow r108 = r13.j0();
        if (r108 != null) goto L77;
    L82:
        boolean r109 = false;
    L83:
        if (r109 == true) goto L96;
        ItemLongTextArrow r111 = r13.b();
        if (r111 != null) goto L87;
    L92:
        boolean r112 = false;
    L93:
        if (r112 == true) goto L96;
        r104 = false;
        goto L97
    L87:
        if (r111.getVisibility() != 0) goto L89;
        boolean r113 = true;
    L90:
        if (r113 != true) goto L92;
        r112 = true;
        goto L93
    L89:
        r113 = false;
        goto L90
    L77:
        if (r108.getVisibility() != 0) goto L79;
        boolean r114 = true;
    L80:
        if (r114 != true) goto L82;
        r109 = true;
        goto L83
    L79:
        r114 = false;
        goto L80
    L72:
        r107 = false;
        goto L73
    L67:
        r106 = false;
        goto L68
    L62:
        r103 = false;
        goto L63
    L53:
        if (r1.contains("bot_permission") == false) goto L55;
        int r115 = 0;
    L56:
        r22.setVisibility(r115);
        goto L57
    L55:
        r115 = 8;
        goto L56
    L46:
        if (r1.contains("ai_model") == false) goto L48;
        int r116 = 0;
    L49:
        r21.setVisibility(r116);
        goto L50
    L48:
        r116 = 8;
        goto L49
    L42:
        r20 = 8;
        goto L43
    L38:
        r18 = 8;
        goto L39
    L34:
        r16 = 8;
        goto L35
    L15:
        if (r1.contains("edit_conversation_name") == false) goto L17;
        int r117 = 0;
    L18:
        r5.setVisibility(r117);
        goto L19
    L17:
        r117 = 8;
        goto L18
    }
}
