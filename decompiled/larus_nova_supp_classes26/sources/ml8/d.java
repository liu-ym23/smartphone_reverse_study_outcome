package ml8;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.block.base.config.ToolBlockInitStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInteractType;
import com.larus.bmhome.chat.standarduikit.browsercontrol.view.BrowserControlView;
import com.larus.bmhome.chat.standarduikit.browsercontrol.view.ButtonStatus;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.DisplayHeader;
import com.larus.im.bean.message.block.GUIToolBlock;
import com.larus.utils.o0;
import jc8.e;
import kc8.w0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends jc8.b<ml8.a> {
    public ll8.b d;

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
        return "GuiToolBlockHolder";
    }

    public d() {
    }

    public final jc8.d f(jc8.a r2) {
        ml8.a r3 = (ml8.a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return e.d(r3);
    }

    public final /* bridge */ /* synthetic */ void g(jc8.a r1) {
        j((ml8.a) r1);
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [android.view.View, com.larus.bmhome.chat.standarduikit.browsercontrol.view.BrowserControlView] */
    public final View h(ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        ll8.b r0 = new ll8.b(r6.getContext());
        this.d = r0;
        AttributeSet r4 = null;
        ?? r7 = new BrowserControlView(r0.a, r4, 6, 0);
        r0.c = r7;
        return r7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v8, types: [ml8.b] */
    public final void j(final ml8.a r28) {
        Intrinsics.checkNotNullParameter(r28, "blockModel");
        ll8.b r2 = this.d;
        if (r2 == null) goto L136;
        BlockContent r3 = ((jc8.a) r28).a.getContent();
        Boolean r4 = null;
        if (r3 == null) goto L7;
        GUIToolBlock r5 = r3.getGuiToolBlock();
    L8:
        kc8.b r6 = jc8.c.a(this, kc8.b.class);
        if (r6 == null) goto L11;
        w0 r7 = r6.v;
    L12:
        String r8 = ((jc8.a) r28).a.getBlockId();
        if (r8 != null) goto L15;
        String r9 = "";
    L16:
        if (r5 == null) goto L23;
        DisplayHeader r10 = r5.header;
        if (r10 == null) goto L23;
        String r11 = r10.getSummary();
        if (r11 == null) goto L23;
        String r12 = r11;
    L24:
        if (r5 == null) goto L29;
        String r13 = r5.snapshotUrl;
        if (r13 == null) goto L29;
        String r14 = r13;
    L30:
        if (r5 == null) goto L32;
        String r15 = r5.snapshotUrl;
    L33:
        boolean r16 = o0.d(r15);
        if (r5 == null) goto L41;
        DisplayHeader r17 = r5.header;
        if (r17 == null) goto L41;
        String r18 = r17.getIconUrlDark();
        if (r18 == null) goto L41;
        String r19 = r18;
    L42:
        if (r5 == null) goto L49;
        DisplayHeader r20 = r5.header;
        if (r20 == null) goto L49;
        String r21 = r20.getIconUrl();
        if (r21 == null) goto L49;
        String r110 = r21;
    L50:
        if (r7 == null) goto L52;
        ToolBlockInteractType r22 = r7.a;
    L54:
        if (r22 != ToolBlockInteractType.OpenFloatingPage) goto L56;
        c r111 = new c(this, r28);
    L57:
        if (r7 == null) goto L59;
        ToolBlockInteractType r23 = r7.a;
    L60:
        boolean r112 = false;
        if (r23 != ToolBlockInteractType.DisableHeaderInteract) goto L63;
        boolean r24 = true;
    L64:
        if (r7 == null) goto L66;
        ToolBlockInitStatus r25 = r7.b;
    L68:
        if (r25 != null) goto L70;
        int r26 = -1;
    L71:
        if (r26 == (-1)) goto L82;
        if (r26 != 1) goto L74;
        r4 = Boolean.TRUE;
        goto L82
    L74:
        if (r26 != 2) goto L76;
        r4 = Boolean.FALSE;
        goto L82
    L76:
        if (r26 == 3) goto L82;
        throw new NoWhenBranchMatchedException();
    L82:
        nl8.a r113 = new nl8.a(r9, r12, r14, r16, r19, r110, r111, r24, r4);
        nl8.c r27 = new nl8.c(new b(this, r28));
        Intrinsics.checkNotNullParameter(r113, "vmData");
        nl8.e r29 = (nl8.e) r2.b.getValue();
        r29.getClass();
        Intrinsics.checkNotNullParameter(r113, "vmData");
        r29.b = r113;
        r29.d = r27;
        if (Intrinsics.areEqual(r29.e, r113.a) == true) goto L89;
        Boolean r1 = r113.i;
        if (r1 == null) goto L87;
        boolean r30 = r1.booleanValue();
    L88:
        r29.a = r30;
        r29.e = r113.a;
        goto L89
    L87:
        r30 = false;
    L89:
        BrowserControlView r31 = r2.c;
        if (r31 == null) goto L137;
        nl8.e r32 = (nl8.e) r2.b.getValue();
        nl8.a r33 = r32.b;
        if (r33 != null) goto L94;
    L96:
        boolean r114 = false;
    L97:
        if (r114 == false) goto L106;
        if (r33 != null) goto L100;
    L102:
        boolean r34 = false;
    L103:
        if (r34 == true) goto L106;
        r112 = true;
        goto L106
    L100:
        if (r33.h != true) goto L102;
        r34 = true;
    L106:
        if (r114 == true) goto L108;
        boolean r115 = true;
    L109:
        boolean r210 = !r112;
        ButtonStatus r35 = r32.c;
        if (r33 == null) goto L115;
        String r36 = r33.b;
        if (r36 == null) goto L115;
        String r211 = r36;
    L116:
        if (r33 == null) goto L121;
        String r37 = r33.c;
        if (r37 == null) goto L121;
        String r212 = r37;
    L122:
        if (r33 == null) goto L127;
        String r38 = r33.e;
        if (r38 == null) goto L127;
        String r213 = r38;
    L128:
        if (r33 == null) goto L133;
        String r39 = r33.f;
        if (r39 == null) goto L133;
        String r214 = r39;
    L134:
        r31.U5(new fj8.a(r115, r210, r210, r35, r211, r212, r213, r214), (nl8.e.a) ((nl8.e) r2.b.getValue()).f.getValue());
        return;
    L133:
        r214 = "";
    L127:
        r213 = "";
    L121:
        r212 = "";
    L115:
        r211 = "";
        goto L116
    L108:
        r115 = r32.a;
        goto L109
    L94:
        if (r33.d != true) goto L96;
        r114 = true;
        goto L97
    L137:
        return;
    L70:
        r26 = a.a[r25.ordinal()];
        goto L71
    L66:
        r25 = null;
        goto L68
    L63:
        r24 = false;
        goto L64
    L59:
        r23 = null;
        goto L60
    L56:
        r111 = 0;
        goto L57
    L52:
        r22 = null;
    L49:
        r110 = "";
    L41:
        r19 = "";
        goto L42
    L32:
        r15 = null;
    L29:
        r14 = "";
    L23:
        r12 = "";
        goto L24
    L15:
        r9 = r8;
        goto L16
    L11:
        r7 = null;
        goto L12
    L7:
        r5 = null;
        goto L8
    }
}
