package com.larus.bmhome.chat.standarduikit.localfileblock.blockadapter;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.standarduikit.localfileblock.view.LocalFileCardView;
import com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.LocalFileCardVMDependencyImpl;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.ClickActionType;
import com.larus.im.bean.message.block.InconImg;
import com.larus.im.bean.message.block.LocalFileBlock;
import java.util.Locale;
import kc8.w;
import kc8.y;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends jc8.b<a> {
    public ul8.b d;

    public final String c() {
        return "LocalFileBlockHolder";
    }

    public b() {
    }

    public final jc8.d f(jc8.a r2) {
        a r3 = (a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return jc8.e.d(r3);
    }

    public final void g(jc8.a r29) {
        a r1 = (a) r29;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        kc8.b r2 = jc8.c.a(this, kc8.b.class);
        BlockContent r3 = ((jc8.a) r1).a.getContent();
        Integer r4 = null;
        if (r3 == null) goto L5;
        LocalFileBlock r5 = r3.getLocalFileBlock();
    L6:
        ul8.b r6 = this.d;
        if (r6 != null) goto L9;
        return;
    L9:
        if (r5 == null) goto L13;
        InconImg r7 = r5.icon;
        if (r7 == null) goto L13;
        String r8 = r7.iconUrlDark;
    L15:
        if (r8 != null) goto L17;
        String r9 = "";
    L18:
        if (r5 == null) goto L22;
        InconImg r10 = r5.icon;
        if (r10 == null) goto L22;
        String r11 = r10.iconUrl;
    L23:
        if (r11 != null) goto L25;
        String r12 = "";
    L26:
        if (r5 == null) goto L28;
        String r13 = r5.name;
    L29:
        if (r13 != null) goto L31;
        String r14 = "";
    L32:
        if (r5 == null) goto L34;
        String r15 = r5.type;
    L35:
        if (r15 != null) goto L37;
        String r16 = "";
    L38:
        if (r5 == null) goto L40;
        String r17 = r5.path;
    L41:
        if (r17 != null) goto L43;
        String r18 = "";
    L45:
        if (r5 == null) goto L52;
        Integer r19 = r5.clickActionType;
        int r20 = ClickActionType.CLICK_ACTION_TYPE_PLAY_AUDIO_BUTTON.getValue();
        if (r19 == null) goto L52;
        if (r19.intValue() != r20) goto L52;
        boolean r110 = true;
    L53:
        if (r2 == null) goto L57;
        w r21 = r2.j;
        if (r21 == null) goto L57;
        Integer r111 = r21.a;
    L58:
        Message r22 = r1.j();
        if (r2 == null) goto L65;
        y r23 = r2.a;
        if (r23 == null) goto L65;
        Function0 r24 = r23.f;
        if (r24 == null) goto L65;
        String r25 = (String) r24.invoke();
    L66:
        com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.a r112 = new com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.a(r9, r12, r14, r16, r18, r110, r111, r22, r25);
        LocalFileCardVMDependencyImpl r26 = new LocalFileCardVMDependencyImpl();
        Intrinsics.checkNotNullParameter(r112, "vmData");
        com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.h r27 = r6.b;
        r27.getClass();
        Intrinsics.checkNotNullParameter(r112, "vmData");
        r27.a = r112;
        r27.b = r26;
        LocalFileCardView r28 = (LocalFileCardView) r6.a.getValue();
        com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.h r30 = r6.b;
        com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.a r31 = r30.a;
        if (r31 == null) goto L69;
        String r32 = r31.a;
    L70:
        if (r32 != null) goto L72;
        String r113 = "";
    L73:
        if (r31 == null) goto L75;
        String r33 = r31.b;
    L76:
        if (r33 != null) goto L78;
        String r210 = "";
    L79:
        if (r31 == null) goto L81;
        String r34 = r31.c;
    L82:
        if (r34 != null) goto L84;
        String r211 = "";
    L85:
        if (r31 == null) goto L87;
        String r35 = r31.d;
    L88:
        if (r35 != null) goto L90;
        r35 = "";
    L90:
        String r212 = r35.toUpperCase(Locale.ROOT);
        com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.a r36 = r30.a;
        if (r36 != null) goto L93;
    L95:
        boolean r213 = false;
    L96:
        if (r36 != null) goto L98;
    L100:
        boolean r214 = false;
    L101:
        if (r36 == null) goto L103;
        String r37 = r36.e;
    L104:
        if (r37 != null) goto L106;
        String r215 = "";
    L107:
        if (r36 == null) goto L113;
        com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.b r38 = r30.b;
        if (r38 == null) goto L111;
        vl8.g r39 = r38.a(r36);
    L112:
        if (r39 == null) goto L113;
    L114:
        vl8.g r216 = r39;
        com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.a r40 = r30.a;
        if (r40 == null) goto L117;
        r4 = r40.h;
    L117:
        vl8.e r41 = new vl8.e(r113, r210, r211, r212, r213, r214, r215, r216, r4);
        com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.h r42 = r6.b;
        r42.getClass();
        r28.S5(r41, new com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.g(r42));
        return;
    L111:
        r39 = null;
    L113:
        r39 = new vl8.g(false, false, false, 0.0f, 15);
        goto L114
    L106:
        r215 = r37;
        goto L107
    L103:
        r37 = null;
        goto L104
    L98:
        if (r36.g != true) goto L100;
        r214 = true;
        goto L101
    L93:
        if (r36.f != true) goto L95;
        r213 = true;
        goto L96
    L87:
        r35 = null;
        goto L88
    L84:
        r211 = r34;
        goto L85
    L81:
        r34 = null;
        goto L82
    L78:
        r210 = r33;
        goto L79
    L75:
        r33 = null;
        goto L76
    L72:
        r113 = r32;
        goto L73
    L69:
        r32 = null;
    L65:
        r25 = null;
    L57:
        r111 = null;
    L52:
        r110 = false;
        goto L53
    L43:
        r18 = r17;
        goto L45
    L40:
        r17 = null;
        goto L41
    L37:
        r16 = r15;
        goto L38
    L34:
        r15 = null;
        goto L35
    L31:
        r14 = r13;
        goto L32
    L28:
        r13 = null;
        goto L29
    L25:
        r12 = r11;
    L22:
        r11 = null;
        goto L23
    L17:
        r9 = r8;
    L13:
        r8 = null;
        goto L15
    L5:
        r5 = null;
        goto L6
    }

    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        ul8.b r0 = this.d;
        if (r0 != null) goto L5;
        r0 = new ul8.b(r2.getContext());
    L5:
        this.d = r0;
        return (LocalFileCardView) r0.a.getValue();
    }
}
