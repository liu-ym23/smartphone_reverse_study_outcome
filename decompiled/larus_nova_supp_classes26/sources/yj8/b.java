package yj8;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.standarduikit.commonbuttonv2.view.CommonButtonV2;
import com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.CommonButtonV2VMDependencyImpl;
import com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.h;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.CommonButtonV2Block;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusBlockItemButtonV2Binding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Map;
import jc8.d;
import jc8.e;
import jc8.f;
import kc8.j;
import kc8.y;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;
import xj8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends jc8.b<a> {
    public c d;
    public CommonButtonV2VMDependencyImpl e;

    public final String c() {
        return "CommonButtonV2BlockHolder";
    }

    public b() {
    }

    public final d f(jc8.a r2) {
        a r3 = (a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return e.d(r3);
    }

    public final void g(jc8.a r26) {
        a r1 = (a) r26;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        if (this.e != null) goto L5;
        this.e = new CommonButtonV2VMDependencyImpl();
    L5:
        BlockContent r2 = ((jc8.a) r1).a.getContent();
        if (r2 == null) goto L8;
        CommonButtonV2Block r3 = r2.getCommonButtonBlock();
    L10:
        if (com.larus.bmhome.chat.bean.d.J0(r1.j()) == true) goto L79;
        if (r3 == null) goto L79;
        String r8 = r3.getDisplayText();
        String r9 = r3.getMessageText();
        String r10 = r3.getIconUrl();
        String r11 = r3.getDarkIconUrl();
        String r12 = r3.getSchemeUrl();
        Integer r13 = r3.getCommand();
        String r14 = r3.getScene();
        Message r16 = r1.j();
        Map r15 = r3.getExtra();
        kc8.b r4 = jc8.c.a(this, kc8.b.class);
        if (r4 == null) goto L22;
        y r5 = r4.a;
        if (r5 == null) goto L22;
        Function0 r6 = r5.m;
        if (r6 == null) goto L22;
        ChatParam r7 = (ChatParam) r6.invoke();
        if (r7 == null) goto L22;
        String r17 = r7.c;
    L23:
        kc8.b r18 = jc8.c.a(this, kc8.b.class);
        if (r18 == null) goto L30;
        y r19 = r18.a;
        if (r19 == null) goto L30;
        Function0 r20 = r19.e;
        if (r20 == null) goto L30;
        wc9.e r110 = (wc9.e) r20.invoke();
    L31:
        kc8.b r21 = jc8.c.a(this, kc8.b.class);
        if (r21 == null) goto L38;
        y r22 = r21.a;
        if (r22 == null) goto L38;
        Function0 r23 = r22.f;
        if (r23 == null) goto L38;
        String r111 = (String) r23.invoke();
    L39:
        f r24 = ((jc8.a) r1).d;
        if (r24 == null) goto L42;
        int r25 = r24.d;
    L43:
        if (r25 <= 1) goto L45;
        boolean r27 = true;
    L46:
        kc8.b r28 = jc8.c.a(this, kc8.b.class);
        if (r28 == null) goto L53;
        y r29 = r28.a;
        if (r29 == null) goto L53;
        j r30 = r29.r;
        if (r30 == null) goto L53;
        Function1 r210 = r30.a;
    L54:
        kc8.b r31 = jc8.c.a(this, kc8.b.class);
        if (r31 == null) goto L61;
        y r32 = r31.a;
        if (r32 == null) goto L61;
        j r33 = r32.r;
        if (r33 == null) goto L61;
        Function0 r211 = r33.b;
    L62:
        kc8.b r34 = jc8.c.a(this, kc8.b.class);
        if (r34 == null) goto L69;
        y r35 = r34.a;
        if (r35 == null) goto L69;
        j r36 = r35.r;
        if (r36 == null) goto L69;
        Function0 r212 = r36.c;
    L70:
        kc8.b r37 = jc8.c.a(this, kc8.b.class);
        if (r37 == null) goto L77;
        y r38 = r37.a;
        if (r38 == null) goto L77;
        Function0 r39 = r38.n;
        if (r39 == null) goto L77;
        ChatPageContext r213 = (ChatPageContext) r39.invoke();
    L78:
        com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r40 = new com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r110, r111, r27, r210, r211, r212, r213);
    L80:
        c r41 = this.d;
        if (r41 == null) goto L126;
        CommonButtonV2VMDependencyImpl r42 = this.e;
        Intrinsics.checkNotNullParameter(r40, "vmData");
        h r43 = (h) r41.b.getValue();
        r43.getClass();
        Intrinsics.checkNotNullParameter(r40, "vmData");
        r43.a = r40;
        r43.b = r42;
        Map<String, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d> r44 = com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.e.a;
        com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d r45 = com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.e.a(r40.g);
        if (r45 == null) goto L85;
        r45.b(r40);
    L85:
        com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r46 = ((h) r41.b.getValue()).a;
        if (r46 != null) goto L88;
        r46 = new com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a(0);
    L88:
        com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d r47 = com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.e.a(r46.g);
        if (r47 == null) goto L91;
        boolean r112 = r47.c(r46);
    L92:
        StringBuilder r113 = new StringBuilder();
        Message r114 = r46.i;
        if (r114 == null) goto L95;
        String r115 = r114.getMessageId();
    L96:
        r113.append(r115);
        r113.append(':');
        r113.append(r46.a);
        r113.append(':');
        r113.append(r46.f);
        String r116 = r113.toString();
        String r117 = r46.a;
        String r118 = r46.c;
        String r119 = r46.d;
        String r120 = r46.e;
        if (r47 == null) goto L99;
        Integer r121 = r47.g(r46);
    L100:
        boolean r122 = r46.m;
        if (r47 == null) goto L103;
        int r123 = r47.e(r46);
    L104:
        final zj8.e r48 = new zj8.e(r116, r117, r118, r119, r120, r112, r121, r122, r123);
        final h.a r49 = ((h) r41.b.getValue()).c;
        CommonButtonV2 r50 = (CommonButtonV2) r41.a.getValue();
        r50.getClass();
        Intrinsics.checkNotNullParameter(r48, "input");
        Intrinsics.checkNotNullParameter(r49, "output");
        e1.y(r50, true ^ r48.f);
        if (r48.f == false) goto L107;
        FLogger.a.i("CommonButtonV2", "bindData, hideButton=" + r48.f);
        goto L126
    L107:
        LarusBlockItemButtonV2Binding r51 = r50.a;
        int r52 = r50.getResources().getDimensionPixelSize(v19.c.b(2130971163, null, 2131166696));
        if (r48.h == false) goto L110;
        LinearLayout r124 = r51.b;
        r124.setGravity(8388627);
        r124.getLayoutParams().width = -2;
        r124.setPadding(r52, r124.getPaddingTop(), r52, r124.getPaddingBottom());
    L111:
        String r53 = r48.b;
        if (o0.d(r53) == false) goto L114;
        r51.e.setVisibility(0);
        r51.e.setText(r53);
    L115:
        boolean r54 = v19.h.a;
        if (v19.h.a(null) == false) goto L118;
        String r55 = r48.d;
    L119:
        Integer r56 = r48.g;
        if (o0.d(r55) == false) goto L122;
        r50.a(r48).setVisibility(0);
        ImageLoaderKt.u(r50.a(r48), r55, "block_button_icon");
    L125:
        ExposeXTrackerExtKt.b(r50, new zj8.b(r48, r49));
        e1.d(r50, new zj8.a(r49));
        goto L126
    L122:
        if (r56 == null) goto L124;
        r50.a(r48).setVisibility(0);
        r50.a(r48).setImageResource(r56.intValue());
        goto L125
    L124:
        r50.a(r48).setVisibility(8);
        goto L125
    L118:
        r55 = r48.c;
        goto L119
    L114:
        r51.e.setVisibility(8);
        goto L115
    L110:
        LinearLayout r125 = r51.b;
        r125.setGravity(17);
        r125.getLayoutParams().width = -1;
        r125.setPadding(r52, r125.getPaddingTop(), r52, r125.getPaddingBottom());
        goto L111
    L103:
        r123 = 2;
        goto L104
    L99:
        r121 = null;
        goto L100
    L95:
        r115 = null;
        goto L96
    L91:
        r112 = true;
    L126:
        FLogger.a.i("CommonButtonV2", "onBindBlockView, vmData: " + r40);
        return;
    L77:
        r213 = null;
    L69:
        r212 = null;
    L61:
        r211 = null;
    L53:
        r210 = null;
        goto L54
    L45:
        r27 = false;
        goto L46
    L42:
        r25 = 1;
    L38:
        r111 = null;
    L30:
        r110 = null;
    L22:
        r17 = null;
    L79:
        r40 = new com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a(0);
        goto L80
    L8:
        r3 = null;
        goto L10
    }

    public final View h(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        c r0 = this.d;
        if (r0 != null) goto L5;
        r0 = new c(r4.getContext());
        this.d = r0;
    L5:
        CommonButtonV2 r5 = (CommonButtonV2) r0.a.getValue();
        r5.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, i5.c0()));
        return r5;
    }
}
