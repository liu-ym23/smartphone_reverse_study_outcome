package wk8;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.block.base.renderer.FileCardVMData;
import com.larus.bmhome.chat.standarduikit.fileblock.view.FileCardView;
import com.larus.common_ui.icon.CommonFileIconType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.ClickActionType;
import com.larus.im.bean.message.block.FileBlock;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.platform.model.office.AiFilePreviewScene;
import java.util.Map;
import kc8.w;
import kc8.y;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tx9.h1;
import zk8.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e extends jc8.b<a> {
    public vk8.b d;
    public FileCardView e;

    public final String c() {
        return "FileBlockHolder";
    }

    public final void i() {
        ConstraintLayout r0 = this.e;
        if (r0 == null) goto L6;
        ExposeXTrackerExtKt.e(r0);
        return;
    }

    public e() {
    }

    public final jc8.d f(jc8.a r2) {
        a r3 = (a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return jc8.e.d(r3);
    }

    public final void g(jc8.a r28) {
        final a r1 = (a) r28;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        kc8.b r2 = jc8.c.a(this, kc8.b.class);
        if (r2 == null) goto L7;
        y r4 = r2.a;
        if (r4 == null) goto L7;
        Fragment r5 = r4.a;
    L8:
        BlockContent r6 = ((jc8.a) r1).a.getContent();
        if (r6 == null) goto L11;
        FileBlock r7 = r6.getFileBlock();
    L12:
        if (r7 == null) goto L14;
        String r8 = r7.name;
    L16:
        if (r8 != null) goto L18;
        String r12 = "";
    L19:
        BlockContent r9 = ((jc8.a) r1).a.getContent();
        if (r9 == null) goto L22;
        ArtifactBlock r10 = r9.getDocBlock();
    L23:
        boolean r24 = false;
        if (r10 == null) goto L31;
        Integer r11 = r10.getResourceType();
        if (r11 == null) goto L31;
        if (r11.intValue() != 17) goto L31;
        boolean r13 = true;
    L32:
        FileCardVMData r14 = r1.i;
        if (r14 == null) goto L64;
        if (r2 == null) goto L38;
        w r15 = r2.j;
        if (r15 == null) goto L38;
        Integer r17 = r15.a;
    L39:
        String r18 = r1.j().getMessageId();
        Map r19 = r1.j().getExt();
        String r16 = r1.j().getConversationId();
        if (r16 != null) goto L42;
    L46:
        if (r2 == null) goto L53;
        y r20 = r2.a;
        if (r20 == null) goto L53;
        Function0 r21 = r20.f;
        if (r21 == null) goto L53;
        r16 = (String) r21.invoke();
    L52:
        String r22 = r16;
    L54:
        if (r2 == null) goto L62;
        y r23 = r2.a;
        if (r23 == null) goto L62;
        Function0 r25 = r23.l;
        if (r25 == null) goto L62;
        BotModel r26 = (BotModel) r25.invoke();
        if (r26 == null) goto L62;
        String r27 = r26.getBotId();
    L63:
        final FileCardVMData r29 = FileCardVMData.a(r14, r17, r18, r19, r22, r27);
    L142:
        if (r2 == null) goto L147;
        y r3 = r2.a;
        if (r3 == null) goto L147;
        final by7.e r30 = r3.c;
        if (r30 == null) goto L147;
    L156:
        vk8.b r31 = this.d;
        if (r31 == null) goto L179;
        if (r13 == false) goto L161;
        lc8.a r32 = new f(r1, r30);
    L178:
        r31.a(r29, r32);
        goto L179
    L161:
        if (r7 == null) goto L163;
        String r33 = r7.uri;
    L164:
        if (r2 == null) goto L174;
        y r34 = r2.a;
        if (r34 == null) goto L174;
        Function0 r35 = r34.e;
        if (r35 == null) goto L174;
        wc9.e r36 = (wc9.e) r35.invoke();
        if (r36 == null) goto L174;
        if (ve8.c.a(r36) != true) goto L174;
        r24 = true;
    L174:
        if (r24 == false) goto L176;
        AiFilePreviewScene r37 = AiFilePreviewScene.P2P_CHAT;
    L177:
        r32 = new u(r5, r33, r37, r30);
        goto L178
    L176:
        r37 = AiFilePreviewScene.AI_CHAT;
        goto L177
    L163:
        r33 = null;
    L179:
        ConstraintLayout r38 = this.e;
        if (r38 == null) goto L182;
        ExposeXTrackerExtKt.e(r38);
    L182:
        final String r39 = h1.b(r29.getType());
        if (r39 == null) goto L190;
        ConstraintLayout r40 = this.e;
        if (r40 == null) goto L189;
        ExposeXTrackerExtKt.b(r40, new b(r1, r29, r39, r30));
        return;
    L189:
        return;
    L190:
        return;
    L147:
        if (r2 == null) goto L151;
        y r41 = r2.a;
        if (r41 == null) goto L151;
        Fragment r42 = r41.a;
    L153:
        if ((r42 instanceof by7.e) == false) goto L155;
        r30 = (by7.e) r42;
        goto L156
    L155:
        r30 = null;
    L151:
        r42 = null;
    L62:
        r27 = null;
    L53:
        r22 = null;
        goto L54
    L42:
        if ((!StringsKt.isBlank(r16)) == true) goto L45;
        r16 = null;
    L45:
        if (r16 != null) goto L52;
    L38:
        r17 = null;
        goto L39
    L64:
        if (r7 == null) goto L66;
        String r43 = r7.type;
    L67:
        h19.b.a.getClass();
        CommonFileIconType r44 = h19.b.c(r12);
        if (r43 != null) goto L70;
        r43 = "";
    L70:
        CommonFileIconType r45 = h19.b.d(StringsKt.substringAfterLast$default(StringsKt.substringAfterLast$default(StringsKt.trim(r43).toString(), '/', null, 2, null), '.', null, 2, null));
        CommonFileIconType r110 = CommonFileIconType.UNKNOWN;
        if (r44 != r110) goto L76;
        if (r45 == r110) goto L75;
        r44 = r45;
        goto L76
    L75:
        r44 = r110;
    L76:
        Integer r46 = Integer.valueOf(h19.b.a(r44));
        if (r7 == null) goto L79;
        String r47 = r7.url;
    L80:
        if (r47 != null) goto L82;
        String r111 = "";
    L83:
        if (r7 == null) goto L85;
        String r48 = r7.type;
    L86:
        if (r48 != null) goto L88;
        String r112 = "";
    L89:
        if (r2 == null) goto L93;
        w r49 = r2.j;
        if (r49 == null) goto L93;
        Integer r50 = r49.a;
    L94:
        String r113 = r1.j().getMessageId();
        Map r114 = r1.j().getExt();
        String r51 = r1.j().getConversationId();
        if (r51 != null) goto L97;
    L101:
        if (r2 == null) goto L108;
        y r52 = r2.a;
        if (r52 == null) goto L108;
        Function0 r53 = r52.f;
        if (r53 == null) goto L108;
        r51 = (String) r53.invoke();
    L107:
        String r115 = r51;
    L109:
        if (r2 == null) goto L117;
        y r54 = r2.a;
        if (r54 == null) goto L117;
        Function0 r55 = r54.l;
        if (r55 == null) goto L117;
        BotModel r56 = (BotModel) r55.invoke();
        if (r56 == null) goto L117;
        String r116 = r56.getBotId();
    L118:
        if (r7 == null) goto L125;
        Integer r57 = r7.clickActionType;
        int r58 = ClickActionType.CLICK_ACTION_TYPE_PLAY_AUDIO_BUTTON.getValue();
        if (r57 == null) goto L125;
        if (r57.intValue() != r58) goto L125;
        boolean r210 = true;
    L126:
        if (r7 == null) goto L137;
        String r59 = r7.size;
        if (r59 == null) goto L137;
        Long r60 = StringsKt.toLongOrNull(r59);
        if (r60 == null) goto L137;
        if (r60.longValue() <= 0) goto L134;
        boolean r61 = true;
    L135:
        if (r61 == false) goto L137;
        Long r211 = r60;
    L138:
        if (r7 == null) goto L140;
        boolean r212 = true;
    L141:
        r29 = new FileCardVMData(r46, null, null, r12, r111, r112, r50, r113, r114, r115, r116, r210, r211, r212, 70);
        goto L142
    L140:
        r212 = false;
        goto L141
    L134:
        r61 = false;
    L137:
        r211 = null;
    L125:
        r210 = false;
    L117:
        r116 = null;
    L108:
        r115 = null;
        goto L109
    L97:
        if ((!StringsKt.isBlank(r51)) == true) goto L100;
        r51 = null;
    L100:
        if (r51 != null) goto L107;
    L93:
        r50 = null;
        goto L94
    L88:
        r112 = r48;
        goto L89
    L85:
        r48 = null;
        goto L86
    L82:
        r111 = r47;
        goto L83
    L79:
        r47 = null;
        goto L80
    L66:
        r43 = null;
    L31:
        r13 = false;
        goto L32
    L22:
        r10 = null;
        goto L23
    L18:
        r12 = r8;
        goto L19
    L14:
        r8 = null;
        goto L16
    L11:
        r7 = null;
    L7:
        r5 = null;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [android.view.View, com.larus.bmhome.chat.standarduikit.fileblock.view.FileCardView] */
    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        vk8.b r0 = this.d;
        if (r0 != null) goto L5;
        r0 = new vk8.b(r2.getContext());
    L5:
        this.d = r0;
        ?? r3 = (FileCardView) r0.b.getValue();
        this.e = r3;
        return r3;
    }
}
