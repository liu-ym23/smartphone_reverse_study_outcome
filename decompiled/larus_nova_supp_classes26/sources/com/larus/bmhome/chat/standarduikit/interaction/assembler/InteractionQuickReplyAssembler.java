package com.larus.bmhome.chat.standarduikit.interaction.assembler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.standarduikit.interaction.view.InteractionQuickReplyView;
import com.larus.bmhome.chat.standarduikit.interaction.view.InteractionQuickReplyViewInput;
import com.larus.bmhome.chat.standarduikit.interaction.viewmodel.f;
import com.larus.bmhome.chat.standarduikit.interaction.viewmodel.m;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyDecisionContext;
import com.larus.im.bean.message.block.QuickReplyEnvironment;
import com.larus.im.bean.message.block.QuickReplyHighlightType;
import com.larus.im.bean.message.block.QuickReplyIcon;
import com.larus.im.bean.message.block.QuickReplyItem;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class InteractionQuickReplyAssembler {
    public final Lazy a;
    public final Lazy b;

    public final void a() {
        InteractionQuickReplyView r1 = (InteractionQuickReplyView) this.a.getValue();
        m r2 = (m) this.b.getValue();
        f r3 = r2.b;
        if (r3 == null) goto L5;
        QuickReplyBlock r5 = r3.h;
    L7:
        if (r5 != null) goto L9;
        InteractionQuickReplyViewInput r4 = new InteractionQuickReplyViewInput(null, null, null, null, null, null, null, null, 511);
    L96:
        final m.b r6 = ((m) this.b.getValue()).m;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "input");
        Intrinsics.checkNotNullParameter(r6, "output");
        boolean r7 = h.a;
        if (h.a(null) == false) goto L99;
        String r8 = r4.b;
    L100:
        if (r8 != null) goto L102;
    L105:
        boolean r9 = true;
    L106:
        if (r9 == true) goto L109;
        e1.x(r1.a.h);
        ImageLoaderKt.u(r1.a.g, r8, "block_button_icon");
    L111:
        boolean r10 = true;
    L113:
        CharSequence r11 = r4.d;
        if (r11 != null) goto L116;
    L119:
        boolean r22 = true;
    L120:
        boolean r12 = !r22;
        if (r10 == true) goto L125;
        if (r12 == true) goto L125;
        boolean r13 = false;
    L126:
        LinearLayout r14 = r1.a.j;
        if (r13 == false) goto L129;
        int r15 = 0;
    L130:
        r14.setVisibility(r15);
        AppCompatTextView r16 = r1.a.i;
        if (r12 == false) goto L133;
        int r17 = 0;
    L134:
        r16.setVisibility(r17);
        r1.a.i.setText(r4.d);
        CharSequence r18 = r4.e;
        if (r18 != null) goto L137;
    L140:
        boolean r23 = true;
    L141:
        boolean r19 = !r23;
        AppCompatTextView r20 = r1.a.p;
        if (r19 == false) goto L144;
        int r21 = 0;
    L145:
        r20.setVisibility(r21);
        r1.a.p.setText(r4.e);
        CharSequence r24 = r4.f;
        if (r24 != null) goto L148;
    L151:
        boolean r25 = true;
    L152:
        boolean r26 = !r25;
        AppCompatTextView r27 = r1.a.f;
        if (r26 == false) goto L155;
        int r28 = 0;
    L156:
        r27.setVisibility(r28);
        r1.a.f.setText(r4.f);
        CharSequence r29 = r4.g;
        if (r29 != null) goto L159;
    L162:
        boolean r210 = true;
    L163:
        boolean r30 = !r210;
        LinearLayout r31 = r1.a.n;
        if (r30 == false) goto L166;
        int r110 = 0;
    L167:
        r31.setVisibility(r110);
        r1.a.m.setText(r4.g);
        Space r32 = r1.a.k;
        if (r13 == false) goto L172;
        if (r19 == true) goto L171;
        if (r26 == false) goto L172;
    L171:
        boolean r111 = true;
    L173:
        if (r111 == false) goto L175;
        int r112 = 0;
    L176:
        r32.setVisibility(r112);
        Space r33 = r1.a.o;
        if (r19 == false) goto L180;
        if (r26 == false) goto L180;
        boolean r113 = true;
    L181:
        if (r113 == false) goto L183;
        int r114 = 0;
    L184:
        r33.setVisibility(r114);
        Space r34 = r1.a.l;
        if (r30 == false) goto L190;
        if (r13 == true) goto L189;
        if (r19 == true) goto L189;
        if (r26 == false) goto L190;
    L189:
        boolean r115 = true;
    L191:
        if (r115 == false) goto L193;
        int r116 = 0;
    L194:
        r34.setVisibility(r116);
        LinearLayout r35 = r1.a.d;
        if (r13 == true) goto L201;
        if (r19 == true) goto L201;
        if (r26 == true) goto L201;
        if (r30 == true) goto L201;
        boolean r36 = false;
    L202:
        if (r36 == false) goto L204;
        int r37 = 0;
    L205:
        r35.setVisibility(r37);
        ScrollView r38 = r1.a.e;
        if (r26 == true) goto L210;
        if (r30 == true) goto L210;
        boolean r39 = false;
    L211:
        if (r39 == false) goto L213;
        int r40 = 0;
    L214:
        r38.setVisibility(r40);
        List<InteractionQuickReplyViewInput.Button> r41 = r4.h;
        Integer r42 = r4.i;
        r1.a.c.removeAllViews();
        if (r41.isEmpty() == false) goto L217;
        e1.o(r1.a.c);
        e1.o(r1.a.b);
    L287:
        if (r1.b == true) goto L303;
        r1.b = true;
        r6.b();
        return;
    L303:
        return;
    L217:
        e1.x(r1.a.c);
        e1.x(r1.a.b);
        if (r41.size() != 2) goto L220;
        int r43 = 1;
    L221:
        r1.a.c.setOrientation(r43 ^ 1);
        Iterator<T> r44 = r41.iterator();
        final int r45 = 0;
    L223:
        if (r44.hasNext() == false) goto L287;
        Object r46 = r44.next();
        int r47 = r45 + 1;
        if (r45 >= 0) goto L227;
        CollectionsKt.throwIndexOverflow();
    L227:
        InteractionQuickReplyViewInput.Button r48 = (InteractionQuickReplyViewInput.Button) r46;
        if (r42 != null) goto L231;
    L233:
        boolean r117 = false;
    L234:
        if (r42 == null) goto L237;
        if (r117 == true) goto L237;
        boolean r118 = true;
    L238:
        LinearLayout r119 = r1.a.c;
        if (r48.b != InteractionQuickReplyViewInput.Button.Style.PRIMARY) goto L241;
        boolean r120 = true;
    L243:
        if (r43 == 0) goto L253;
        View r0 = LayoutInflater.from(r1.getContext()).inflate(2131562469, r1.a.c, false);
        TextView r121 = (TextView) ViewBindings.findChildViewById(r0, 2131365025);
        if (r121 == null) goto L250;
        FrameLayout r49 = (FrameLayout) r0;
        FrameLayout r122 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131379011);
        if (r122 == null) goto L249;
        InteractionQuickReplyView.a r50 = new InteractionQuickReplyView.a(r49, r121, r122);
    L258:
        FrameLayout r51 = r50.a;
        r51.setSelected(r120);
        r51.setActivated(r118);
        r50.b.setText(r48.a);
        TextView r52 = r50.b;
        if ((!r117) == false) goto L261;
        int r123 = 0;
    L262:
        r52.setVisibility(r123);
        FrameLayout r53 = r50.c;
        if (r117 == false) goto L265;
        int r124 = 0;
    L266:
        r53.setVisibility(r124);
        if (r117 == false) goto L269;
        FrameLayout r54 = r50.c;
        com.larus.common_ui.dbx.component.b r125 = new com.larus.common_ui.dbx.component.b(r1.getContext());
        r125.setRingColor(r50.b.getCurrentTextColor());
        r125.d = true;
        r125.a();
        r54.addView(r125, new FrameLayout.LayoutParams(-1, -1));
    L269:
        r51.setAlpha(1.0f);
        if (r48.c == true) goto L272;
        r51.setAlpha(0.3f);
    L275:
        if (r118 == true) goto L280;
        if (r117 == true) goto L280;
        if (r48.c == false) goto L280;
        e1.d(r51, new sl8.a(r6, r45));
    L281:
        r119.addView(r51);
        r45 = r47;
        r42 = r42;
    L280:
        r51.setClickable(false);
        r51.setFocusable(false);
        goto L281
    L272:
        if (r120 == false) goto L275;
        if (r118 == false) goto L275;
        r51.setAlpha(0.2f);
        goto L275
    L265:
        r124 = 8;
        goto L266
    L261:
        r123 = 8;
        goto L262
    L249:
        int r126 = 2131379011;
    L252:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r126)));
    L250:
        r126 = 2131365025;
        goto L252
    L253:
        View r55 = LayoutInflater.from(r1.getContext()).inflate(2131562470, r1.a.c, false);
        TextView r127 = (TextView) ViewBindings.findChildViewById(r55, 2131365025);
        if (r127 == null) goto L283;
        FrameLayout r56 = (FrameLayout) r55;
        FrameLayout r128 = (FrameLayout) ViewBindings.findChildViewById(r55, 2131379011);
        if (r128 == null) goto L282;
        r50 = new InteractionQuickReplyView.a(r56, r127, r128);
        goto L258
    L282:
        int r129 = 2131379011;
    L285:
        throw new NullPointerException("Missing required view with ID: ".concat(r55.getResources().getResourceName(r129)));
    L283:
        r129 = 2131365025;
        goto L285
    L241:
        r120 = false;
    L237:
        r118 = false;
        goto L238
    L231:
        if (r42.intValue() != r45) goto L233;
        r117 = true;
        goto L234
    L220:
        r43 = 0;
        goto L221
    L213:
        r40 = 8;
    L210:
        r39 = true;
        goto L211
    L204:
        r37 = 8;
    L201:
        r36 = true;
        goto L202
    L193:
        r116 = 8;
    L190:
        r115 = false;
        goto L191
    L183:
        r114 = 8;
    L180:
        r113 = false;
        goto L181
    L175:
        r112 = 8;
    L172:
        r111 = false;
        goto L173
    L166:
        r110 = 8;
        goto L167
    L159:
        if (StringsKt.isBlank(r29) == true) goto L162;
        r210 = false;
        goto L163
    L155:
        r28 = 8;
        goto L156
    L148:
        if (StringsKt.isBlank(r24) == true) goto L151;
        r25 = false;
        goto L152
    L144:
        r21 = 8;
        goto L145
    L137:
        if (StringsKt.isBlank(r18) == true) goto L140;
        r23 = false;
        goto L141
    L133:
        r17 = 8;
        goto L134
    L129:
        r15 = 8;
    L125:
        r13 = true;
        goto L126
    L116:
        if (StringsKt.isBlank(r11) == true) goto L119;
        r22 = false;
        goto L120
    L109:
        if (r4.c == null) goto L112;
        e1.x(r1.a.h);
        r1.a.g.setActualImageResource(r4.c.intValue());
        goto L111
    L112:
        e1.o(r1.a.h);
        r10 = false;
        goto L113
    L102:
        if (r8.length() == 0) goto L105;
        r9 = false;
        goto L106
    L99:
        r8 = r4.a;
        goto L100
    L9:
        if (r3 == null) goto L11;
        QuickReplyBlock r57 = r3.h;
    L12:
        if (r57 == null) goto L14;
        QuickReplyDecisionContext r58 = r57.getDecisionContext();
    L15:
        if (r58 == null) goto L17;
        QuickReplyEnvironment r59 = r58.getEnvironment();
    L18:
        if (r59 == null) goto L22;
        QuickReplyIcon r60 = r59.getIcon();
        if (r60 == null) goto L22;
        String r130 = r60.getUrlLight();
    L23:
        if (r59 == null) goto L27;
        QuickReplyIcon r61 = r59.getIcon();
        if (r61 == null) goto L27;
        String r131 = r61.getUrlDark();
    L28:
        if (r59 == null) goto L30;
        String r132 = r59.getTitle();
    L31:
        if (r58 == null) goto L37;
        String r62 = r58.getTitle();
        if (r62 == null) goto L37;
        if ((!StringsKt.isBlank(r62)) == false) goto L37;
        String r133 = r62;
    L38:
        if (r58 == null) goto L44;
        String r63 = r58.getContent();
        if (r63 == null) goto L44;
        if ((!StringsKt.isBlank(r63)) == false) goto L44;
        String r134 = r63;
    L46:
        if (r58 == null) goto L79;
        List r64 = r58.getSuggestedFolderPath();
        if (r64 == null) goto L79;
        Iterator r65 = r64.iterator();
    L51:
        if (r65.hasNext() == false) goto L62;
        Object r66 = r65.next();
        String r135 = (String) r66;
        if (r135 != null) goto L55;
    L58:
        boolean r136 = true;
    L60:
        if ((!r136) == false) goto L51;
    L63:
        String r67 = (String) r66;
        if (r67 == null) goto L79;
        if (r67.length() != 0) goto L68;
        boolean r68 = true;
    L69:
        if (r68 == false) goto L71;
        String r137 = "";
    L80:
        List<QuickReplyItem> r69 = r2.d;
        ArrayList r70 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r69, 10));
        Iterator<T> r71 = r69.iterator();
    L82:
        if (r71.hasNext() == false) goto L95;
        QuickReplyItem r138 = (QuickReplyItem) r71.next();
        String r139 = r138.getText();
        if (r139 != null) goto L86;
        String r72 = "";
    L87:
        Integer r140 = r138.getHighlightType();
        int r73 = QuickReplyHighlightType.HIGHLIGHT_TYPE_CONFIRM.getValue();
        if (r140 != null) goto L91;
    L93:
        InteractionQuickReplyViewInput.Button.Style r74 = InteractionQuickReplyViewInput.Button.Style.SECONDARY;
    L94:
        r70.add(new InteractionQuickReplyViewInput.Button(r72, r74));
        goto L82
    L91:
        if (r140.intValue() != r73) goto L93;
        r74 = InteractionQuickReplyViewInput.Button.Style.PRIMARY;
        goto L94
    L86:
        r72 = r139;
        goto L87
    L95:
        r4 = new InteractionQuickReplyViewInput(r130, r131, r132, r133, r134, r137, r70, r2.e, 4);
        goto L96
    L71:
        String r75 = StringsKt.trimEnd(r67, new char[]{'/', '\\'});
        if (r75.length() != 0) goto L74;
        boolean r141 = true;
    L75:
        if (r141 == false) goto L77;
        String r76 = StringsKt.take(r67, 1);
    L78:
        r137 = r76;
        goto L80
    L77:
        r76 = r75.substring(StringsKt.lastIndexOfAny$default(r75, new char[]{'/', '\\'}, 0, false, 6, null) + 1);
        goto L78
    L74:
        r141 = false;
        goto L75
    L68:
        r68 = false;
        goto L69
    L55:
        if (StringsKt.isBlank(r135) == true) goto L58;
        r136 = false;
        goto L60
    L62:
        r66 = null;
    L79:
        r137 = null;
    L44:
        r134 = null;
    L37:
        r133 = null;
        goto L38
    L30:
        r132 = null;
    L27:
        r131 = null;
    L22:
        r130 = null;
        goto L23
    L17:
        r59 = null;
        goto L18
    L14:
        r58 = null;
        goto L15
    L11:
        r57 = null;
        goto L12
    L5:
        r5 = null;
        goto L7
    }

    public InteractionQuickReplyAssembler(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = LazyKt.lazy(new a(r2));
        this.b = LazyKt.lazy(new b(this));
    }
}
