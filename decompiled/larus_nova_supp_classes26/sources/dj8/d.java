package dj8;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.block.base.config.ToolBlockInitStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInteractType;
import com.larus.bmhome.chat.standarduikit.browsercontrol.view.BrowserControlView;
import com.larus.bmhome.chat.standarduikit.browsercontrol.view.ButtonStatus;
import com.larus.bmhome.chat.standarduikit.browsercontrol.vm.BrowserControlViewModel;
import com.larus.bmhome.chat.standarduikit.browsercontrol.vm.BrowserControlViewModel$browserControlBlockOutput$2$1;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BrowserControlBlock;
import com.larus.im.bean.message.block.BrowserControlUserAction;
import com.larus.im.bean.message.block.DisplayHeader;
import jc8.e;
import kc8.w0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends jc8.b<dj8.a> {
    public cj8.c d;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ToolBlockInitStatus.values().length];
            r0[ToolBlockInitStatus.Fold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ToolBlockInitStatus.Expand.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ToolBlockInitStatus.Default.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public final String c() {
        return "BrowserControlBlockHolder";
    }

    public d() {
    }

    public final jc8.d f(jc8.a r2) {
        dj8.a r3 = (dj8.a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return e.d(r3);
    }

    public final /* bridge */ /* synthetic */ void g(jc8.a r1) {
        j((dj8.a) r1);
    }

    public final View h(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        cj8.c r0 = new cj8.c(r3.getContext());
        this.d = r0;
        ConstraintLayout r1 = (BrowserControlView) r0.a.getValue();
        if (r1 == null) goto L5;
        return r1;
    L5:
        return new View(r3.getContext());
    }

    /* JADX WARN: Type inference failed for: r6v15, types: [dj8.b] */
    /* JADX WARN: Type inference failed for: r6v19, types: [dj8.c] */
    public final void j(final dj8.a r21) {
        Intrinsics.checkNotNullParameter(r21, "blockModel");
        BlockContent r2 = ((jc8.a) r21).a.getContent();
        if (r2 == null) goto L5;
        BrowserControlBlock r3 = r2.getBrowserControlBlock();
    L6:
        kc8.b r4 = jc8.c.a(this, kc8.b.class);
        if (r4 == null) goto L9;
        final w0 r5 = r4.v;
    L10:
        cj8.c r6 = this.d;
        if (r6 == null) goto L158;
        String r7 = ((jc8.a) r21).a.getBlockId();
        if (r7 != null) goto L15;
        String r9 = "";
    L16:
        if (r3 == null) goto L20;
        DisplayHeader r8 = r3.displayHeader;
        if (r8 == null) goto L20;
        String r10 = r8.getSummary();
    L21:
        if (r10 != null) goto L23;
        String r12 = "";
    L24:
        if (r3 == null) goto L28;
        DisplayHeader r11 = r3.displayHeader;
        if (r11 == null) goto L28;
        String r13 = r11.getIconUrlDark();
    L29:
        if (r13 != null) goto L31;
        String r14 = "";
    L32:
        if (r3 == null) goto L36;
        DisplayHeader r15 = r3.displayHeader;
        if (r15 == null) goto L36;
        String r16 = r15.getIconUrl();
    L37:
        if (r16 != null) goto L39;
        String r17 = "";
    L40:
        if (r3 == null) goto L42;
        String r18 = r3.snapshotUrl;
    L43:
        if (r18 != null) goto L45;
        String r19 = "";
    L46:
        if (r3 == null) goto L48;
        String r20 = r3.toolCallId;
    L49:
        if (r20 != null) goto L51;
        String r110 = "";
    L52:
        BrowserControlUserAction.a r22 = BrowserControlUserAction.Companion;
        if (r3 == null) goto L55;
        Integer r23 = r3.action;
    L56:
        r22.getClass();
        BrowserControlUserAction[] r24 = BrowserControlUserAction.values();
        int r25 = r24.length;
        int r26 = 0;
    L57:
        if (r26 >= r25) goto L68;
        BrowserControlUserAction r111 = r24[r26];
        int r112 = r111.getValue();
        if (r23 != null) goto L62;
    L64:
        boolean r27 = false;
    L65:
        if (r27 == true) goto L69;
        r26 = r26 + 1;
    L69:
        if (r111 != null) goto L71;
        BrowserControlUserAction r113 = BrowserControlUserAction.DONE;
    L72:
        if (r5 == null) goto L74;
        ToolBlockInteractType r28 = r5.a;
    L76:
        if (r28 != ToolBlockInteractType.DisableHeaderInteract) goto L78;
        boolean r114 = true;
    L79:
        if (r5 == null) goto L81;
        ToolBlockInitStatus r29 = r5.b;
    L83:
        if (r29 != null) goto L85;
        int r30 = -1;
    L86:
        if (r30 != (-1)) goto L88;
    L99:
        Boolean r31 = null;
    L100:
        com.larus.bmhome.chat.standarduikit.browsercontrol.vm.a r32 = new com.larus.bmhome.chat.standarduikit.browsercontrol.vm.a(r9, r113, r110, r12, r19, r14, r17, new b(r5, this, r21), r114, r31);
        kc8.b r33 = jc8.c.a(this, kc8.b.class);
        com.larus.bmhome.chat.standarduikit.browsercontrol.vm.c r34 = new com.larus.bmhome.chat.standarduikit.browsercontrol.vm.c(new c(this, r21));
        Intrinsics.checkNotNullParameter(r32, "vmData");
        BrowserControlViewModel r35 = (BrowserControlViewModel) r6.b.getValue();
        r35.getClass();
        Intrinsics.checkNotNullParameter(r32, "vmData");
        r35.a = r32;
        r35.b = r34;
        if (Intrinsics.areEqual(r35.f, r32.a) == true) goto L108;
        Boolean r1 = r32.j;
        if (r1 == null) goto L105;
        boolean r115 = r1.booleanValue();
    L106:
        r35.e = r115;
        r35.f = r32.a;
        r35.d = false;
        goto L108
    L105:
        r115 = false;
    L108:
        if (r35.e == false) goto L111;
        r35.c = ButtonStatus.HIDE;
    L117:
        BrowserControlViewModel r36 = (BrowserControlViewModel) r6.b.getValue();
        com.larus.bmhome.chat.standarduikit.browsercontrol.vm.a r37 = r36.a;
        if (r37 == null) goto L123;
        String r38 = r37.d;
        if (r38 == null) goto L123;
        String r116 = r38;
    L124:
        if (r37 == null) goto L129;
        String r39 = r37.f;
        if (r39 == null) goto L129;
        String r117 = r39;
    L130:
        if (r37 == null) goto L135;
        String r40 = r37.g;
        if (r40 == null) goto L135;
        String r118 = r40;
    L136:
        if (r37 == null) goto L141;
        String r41 = r37.e;
        if (r41 == null) goto L141;
        String r119 = r41;
    L142:
        ButtonStatus r120 = r36.c;
        boolean r42 = r36.e;
        if (r37 == null) goto L147;
        boolean r43 = true;
        if (r37.i != true) goto L148;
        boolean r44 = true;
    L149:
        if (r37 != null) goto L151;
    L153:
        boolean r45 = false;
    L154:
        fj8.a r46 = new fj8.a(r42, r44, r45, r120, r116, r119, r117, r118);
        BrowserControlViewModel$browserControlBlockOutput$2$1 r47 = (BrowserControlViewModel$browserControlBlockOutput$2$1) ((BrowserControlViewModel) r6.b.getValue()).g.getValue();
        ((BrowserControlView) r6.a.getValue()).U5(r46, r47);
        return;
    L151:
        if (r37.i != r43) goto L153;
        r45 = true;
    L148:
        r44 = false;
        goto L149
    L147:
        r43 = true;
    L141:
        r119 = "";
    L135:
        r118 = "";
    L129:
        r117 = "";
    L123:
        r116 = "";
        goto L124
    L111:
        if (r32.b == BrowserControlUserAction.WAIT) goto L113;
        r35.c = ButtonStatus.HIDE;
        goto L117
    L113:
        if (r35.d == false) goto L115;
        r35.c = ButtonStatus.DISABLED;
        goto L117
    L115:
        r35.c = ButtonStatus.ENABLED;
        goto L117
    L88:
        if (r30 != 1) goto L90;
        Boolean r48 = Boolean.TRUE;
    L98:
        r31 = r48;
        goto L100
    L90:
        if (r30 != 2) goto L92;
        r48 = Boolean.FALSE;
        goto L98
    L92:
        if (r30 == 3) goto L99;
        throw new NoWhenBranchMatchedException();
    L85:
        r30 = a.a[r29.ordinal()];
        goto L86
    L81:
        r29 = null;
        goto L83
    L78:
        r114 = false;
        goto L79
    L74:
        r28 = null;
        goto L76
    L71:
        r113 = r111;
        goto L72
    L62:
        if (r112 != r23.intValue()) goto L64;
        r27 = true;
        goto L65
    L68:
        r111 = null;
        goto L69
    L55:
        r23 = null;
        goto L56
    L51:
        r110 = r20;
        goto L52
    L48:
        r20 = null;
        goto L49
    L45:
        r19 = r18;
        goto L46
    L42:
        r18 = null;
        goto L43
    L39:
        r17 = r16;
    L36:
        r16 = null;
        goto L37
    L31:
        r14 = r13;
    L28:
        r13 = null;
        goto L29
    L23:
        r12 = r10;
    L20:
        r10 = null;
        goto L21
    L15:
        r9 = r7;
        goto L16
    L158:
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
