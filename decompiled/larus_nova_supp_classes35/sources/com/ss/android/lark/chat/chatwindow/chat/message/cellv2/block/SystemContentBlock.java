package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.extension.message.system.SystemMessageConfig;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.SystemContentUtilV2;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.chat.export.entity.message.content.ContentValue;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageType;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SystemContentBlock implements com.ss.android.lark.blueprint.i<y6b.a<?>, com.ss.android.lark.chat.base.view.vo.message.d> {
    public final com.ss.android.lark.blueprint.g a;
    public final IMMessageKeys$Blocks b;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.blueprint.k<View> {
        public final View a;
        public final TextView b;
        public final TextView c;

        public final View getView() {
            return this.a;
        }

        public b(View r4) {
            Intrinsics.checkNotNullParameter(r4, "view");
            this.a = r4;
            TextView r0 = (TextView) r4.findViewById(2131387971);
            this.b = r0;
            this.c = (TextView) r4.findViewById(2131387972);
            r0.setHighlightColor(UIUtils.getColor(r4.getContext(), 2131101106));
            r0.setTextSize(0, zz7.b.h(r4.getContext(), 14));
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ Context a;
        public final /* synthetic */ y6b.b b;
        public final /* synthetic */ Chat c;

        public c(Context r1, y6b.b r2, Chat r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            w4b.c r5 = ChatCoreModule.a();
            if (r5 == null) goto L8;
            w4b.b0 r6 = r5.getProfileDependency();
            if (r6 == null) goto L9;
            r6.b(this.a, this.b, this.c);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final Class<com.ss.android.lark.chat.base.view.vo.message.d> b() {
        return null;
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.b;
    }

    public SystemContentBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        this.a = r2;
        this.b = IMMessageKeys$Blocks.SYSTEM_CONTENT;
    }

    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, com.ss.android.lark.blueprint.q<y6b.a<?>> r2) {
        com.ss.android.lark.blueprint.i.a.a(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v52, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13, types: [m2b.a] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r8v25, types: [android.text.SpannableStringBuilder, java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v31 */
    public void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r27, com.ss.android.lark.blueprint.q<y6b.a<?>> r28, y6b.a<?> r29) {
        Intrinsics.checkNotNullParameter(r27, "cell");
        Intrinsics.checkNotNullParameter(r28, "layout");
        Intrinsics.checkNotNullParameter(r29, Keys.API_RETURN_KEY_DATA);
        b r1 = (b) r28.c(this.b, IMMessageKeys$Slots.CONTENT, SystemContentBlock$update$itemView$1.INSTANCE);
        Context r3 = this.a.getContext();
        i3b.d r4 = (i3b.d) this.a.c.a(i3b.d.class);
        if (r4 == null) goto L269;
        m2b.a r5 = r4.a();
        if (r5 != null) goto L8;
        return;
    L8:
        if ((r29 instanceof v5b.c) == false) goto L10;
        y6b.a<?> r6 = r29;
    L11:
        if (r6 != null) goto L13;
        return;
    L13:
        SystemContentUtilV2.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "chatContext");
        com.ss.android.lark.chat.base.view.vo.message.d r7 = (com.ss.android.lark.chat.base.view.vo.message.d) r6.b();
        String r10 = BuildConfig.FLAVOR;
        if (r7 == null) goto L191;
        SystemContent r8 = (SystemContent) r7.a;
        if (r8 == null) goto L191;
        Lazy r11 = SystemContentUtilV2.b;
        List r12 = (List) ((Pair) r11.getValue()).getFirst();
        List r13 = (List) ((Pair) r11.getValue()).getSecond();
        com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.c r14 = new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.c(r8, r6, r5);
        if (r8.getType() != SystemMessageType.LOCAL_MENTION_BOTS_NOT_IN_CHAT) goto L151;
        String r9 = r14.context().getString(2131891330);
        Intrinsics.checkNotNullParameter(r9, "template");
        Intrinsics.checkNotNullParameter(r8, "systemContent");
        Intrinsics.checkNotNullParameter(r12, "contentProcessorList");
        Intrinsics.checkNotNullParameter(r13, "extraProcessorList");
        Intrinsics.checkNotNullParameter(r14, "systemActionContext");
        int r15 = 0;
        int r19 = 0;
    L21:
        int r16 = StringsKt.indexOf$default(r9, "{add}", r19, false, 4, null);
        if (r16 < 0) goto L25;
        r15 = r15 + 1;
        r19 = r16 + 5;
        goto L21
    L25:
        if (r8.getType() != SystemMessageType.LOCAL_MENTION_BOTS_NOT_IN_CHAT) goto L147;
        int r17 = StringsKt.indexOf$default(r9, "{agent}", 0, false, 6, null);
        if (r17 >= 0) goto L29;
    L31:
        boolean r18 = false;
    L32:
        if (r18 == false) goto L147;
        if (r15 > 1) goto L147;
        ArrayList<String> r20 = r8.getLocalMentionAgentIds();
        Iterator r21 = r8.getSystemContents().entrySet().iterator();
    L38:
        if (r21.hasNext() == false) goto L43;
        Object r110 = r21.next();
        Iterator r111 = r21;
        if (Intrinsics.areEqual(((Map.Entry) r110).getKey(), "agent") == true) goto L44;
        r21 = r111;
    L44:
        Map.Entry r2 = (Map.Entry) r110;
        if (r2 == null) goto L51;
        List r22 = (List) r2.getValue();
        if (r20.isEmpty() == true) goto L51;
        if (r20.size() != r22.size()) goto L51;
        HashSet r23 = new HashSet(r20.size());
        IntIterator r112 = CollectionsKt.getIndices(r20).iterator();
    L54:
        if (r112.hasNext() == false) goto L83;
        String r113 = r10;
        int r114 = r112.nextInt();
        Long r115 = StringsKt.toLongOrNull((String) ListProtector.get(r20, r114));
        if (r115 == null) goto L84;
        if (r115.longValue() <= 0) goto L60;
        boolean r24 = true;
    L61:
        if (r24 == true) goto L64;
        r115 = null;
    L64:
        if (r115 == null) goto L84;
        ArrayList<String> r25 = r20;
        String r26 = r115.toString();
        if (r26 == null) goto L84;
        ContentValue r116 = (ContentValue) ListProtector.get(r22, r114);
        if (r23.add(r26) == false) goto L84;
        HashSet r117 = r23;
        if (Intrinsics.areEqual(r116.getId(), r26) == false) goto L84;
        if (SystemContentUtilV2.c.contains(r116.getContentValueType()) == false) goto L84;
        String r30 = r116.getValue();
        if (r30 != null) goto L76;
    L79:
        boolean r31 = true;
    L80:
        if (r31 == true) goto L84;
        r23 = r117;
        r10 = r113;
        r20 = r25;
        goto L54
    L76:
        if (StringsKt.isBlank(r30) == true) goto L79;
        r31 = false;
        goto L80
    L60:
        r24 = false;
    L84:
        Map.Entry r32 = null;
    L85:
        if (r32 != null) goto L87;
        Log.e("SystemContentUtilV2", "local mention-bot raw and resolved agents do not match");
    L148:
        CharSequence r118 = r113;
    L149:
        CharSequence r33 = r118;
        ContentValue r119 = null;
    L192:
        com.ss.android.lark.biz.im.api.message.params.x r34 = r5.d0(com.ss.android.lark.biz.im.api.message.params.x.class);
        int r35 = UIUtils.dp2px(r3, 30.0f);
        if (r34 == null) goto L197;
        int r36 = r34.f;
        if (r36 <= 0) goto L197;
        float r37 = r36;
    L198:
        int r38 = UIUtils.dp2px(r3, r37);
        r1.a.setPadding(r35, r38, r35, r38);
        ChatThemeInfo r39 = r5.r8();
        if (r39 != null) goto L201;
    L209:
        r1.b.setTextColor(UIUtils.getColor(r3, 2131106620));
        r1.b.setBackgroundColor(UIUtils.getColor(r3, 2131106784));
    L210:
        com.ss.android.lark.biz.im.api.message.params.x r40 = r5.d0(com.ss.android.lark.biz.im.api.message.params.x.class);
        if (r40 == null) goto L240;
        int r41 = r40.a;
        if (r41 <= 0) goto L215;
        r1.b.setTextSize(0, r41);
    L215:
        i3b.d r42 = (i3b.d) this.a.c.a(i3b.d.class);
        if (r42 == null) goto L218;
        ?? r43 = r42.a();
    L220:
        if (r40.c == false) goto L239;
        if (r43 == 0) goto L239;
        Object r44 = r29.b();
        if (r44 == null) goto L229;
        Object r45 = ((com.ss.android.lark.chat.base.view.vo.message.d) r44).a;
        if (r45 == null) goto L229;
        if (((SystemContent) r45).getSystemTypeValue() != 175) goto L229;
        boolean r46 = true;
    L230:
        if (r46 == false) goto L239;
        Chat r47 = r43.getChat();
        y6b.b r48 = r43.x8();
        String r49 = UIUtils.getString(r3, r40.e);
        if (r48 == null) goto L240;
        if (r47 == null) goto L240;
        if (com.ss.android.lark.message.lynxcard.message.r.a(r49) == false) goto L240;
        r1.c.setText(r49);
        r1.c.setTextColor(r40.d);
        r1.c.setVisibility(0);
        r1.c.setOnClickListener(new c(r3, r48, r47));
        int r50 = r40.a;
        if (r50 <= 0) goto L240;
        r1.c.setTextSize(0, r50);
    L229:
        r46 = false;
    L239:
        r1.c.setVisibility(8);
        goto L240
    L218:
        r43 = r119;
    L240:
        r1.b.setText(r33);
        if ((r33 instanceof SpannableStringBuilder) == false) goto L270;
        r1.b.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    L270:
        return;
    L201:
        if (com.ss.android.lark.chat.utils.p.g(r39.getComponentScene()) == false) goto L209;
        if (r33.length() != 0) goto L205;
        boolean r51 = true;
    L206:
        if (r51 == true) goto L209;
        r1.b.setTextColor(com.ss.android.lark.chat.utils.p.c(r3));
        r1.b.setBackground(UIUtils.getDrawable(r3, 2131232172));
        goto L210
    L205:
        r51 = false;
    L197:
        r37 = 12.0f;
        goto L198
    L87:
        SpannableStringBuilder r52 = SystemContentUtilV2.a(r32, r12, r14);
        if (r52.length() != 0) goto L90;
        boolean r53 = true;
    L91:
        if (r53 == false) goto L94;
        Log.e("SystemContentUtilV2", "local mention-bot resolved agent text is empty");
        goto L148
    L94:
        SpannableStringBuilder r54 = SystemContentUtilV2.b(new SpannableStringBuilder(r9), "{agent}", r52);
        Iterator r55 = r13.iterator();
    L96:
        if (r55.hasNext() == false) goto L100;
        Object r56 = r55.next();
        ContentValue r57 = null;
        if (((com.ss.android.lark.biz.im.api.extension.message.system.c) r56).a(null, r14) == false) goto L96;
        Object r120 = r56;
    L101:
        com.ss.android.lark.biz.im.api.extension.message.system.c r58 = (com.ss.android.lark.biz.im.api.extension.message.system.c) r120;
        ?? r59 = r57;
        if (r58 == null) goto L111;
        SpannableStringBuilder r60 = new SpannableStringBuilder();
        r58.c(r60, r57, r14);
        r60.append(r58.b(r57, r14));
        if (r60.length() <= 0) goto L107;
        boolean r61 = true;
    L108:
        if (r61 == false) goto L110;
        r60.setSpan(new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.b(r58, r14, r57, r14.context()), 0, r60.length(), 33);
    L110:
        r59 = r60;
        goto L111
    L107:
        r61 = false;
    L111:
        if (r59 != 0) goto L113;
    L116:
        boolean r62 = true;
    L117:
        if (r62 == true) goto L119;
    L134:
        if (r59 != 0) goto L136;
    L139:
        boolean r63 = true;
    L140:
        if (r63 == false) goto L143;
    L141:
        r118 = r54;
        goto L149
    L143:
        if (r15 != 1) goto L145;
        SpannableStringBuilder r64 = SystemContentUtilV2.b(r54, "{add}", r59);
    L146:
        r118 = r64;
        goto L149
    L145:
        r64 = r54.append(" ").append(r59);
        Intrinsics.checkNotNull(r64);
        goto L146
    L136:
        if (r59.length() == 0) goto L139;
        r63 = false;
        goto L140
    L119:
        if (r15 != 1) goto L134;
        int r65 = StringsKt.indexOf$default(r54, "{add}", 0, false, 6, null);
        if (r65 < 0) goto L141;
        int r66 = r65 + 5;
        if (r65 <= 0) goto L129;
        int r67 = r65 - 1;
        if (CharsKt.isWhitespace(r54.charAt(r67)) == false) goto L129;
        r65 = r67;
    L133:
        r54.delete(r65, r66);
    L129:
        if (r66 >= r54.length()) goto L133;
        if (CharsKt.isWhitespace(r54.charAt(r66)) == false) goto L133;
        r66 = r66 + 1;
        goto L133
    L113:
        if (r59.length() == 0) goto L116;
        r62 = false;
        goto L117
    L100:
        r57 = null;
        r120 = null;
        goto L101
    L90:
        r53 = false;
        goto L91
    L83:
        r113 = r10;
        r32 = r2;
    L51:
        r113 = BuildConfig.FLAVOR;
        goto L84
    L43:
        r110 = null;
        goto L44
    L29:
        if (r17 != StringsKt.lastIndexOf$default(r9, "{agent}", 0, false, 6, null)) goto L31;
        r18 = true;
    L147:
        r113 = BuildConfig.FLAVOR;
        Log.e("SystemContentUtilV2", "invalid local mention-bot template or system type");
        goto L148
    L151:
        if (r8.getVersion() != 0) goto L154;
        boolean r68 = ((EnumSet) SystemMessageConfig.a.getValue()).contains(r8.getType());
    L160:
        if (((EnumSet) SystemMessageConfig.b.getValue()).contains(r8.getType()) == false) goto L162;
        r68 = true;
    L162:
        if (r68 == false) goto L190;
        Intrinsics.checkNotNullParameter(r8, "systemContent");
        Intrinsics.checkNotNullParameter(r12, "processorList");
        Intrinsics.checkNotNullParameter(r14, "systemActionContext");
        SpannableStringBuilder r69 = new SpannableStringBuilder();
        Intrinsics.checkNotNullParameter(r8, "systemContent");
        String r70 = r8.getMessageTemplate();
        Set<String> r121 = r8.getSystemContents().keySet();
        Iterator<Map.Entry<String, String>> r122 = r8.getContents().entrySet().iterator();
        String r210 = r70;
    L165:
        if (r122.hasNext() == false) goto L172;
        Map.Entry<String, String> r71 = r122.next();
        if (r121.contains(r71.getKey()) == true) goto L165;
        if (r210 == null) goto L170;
        r210 = StringsKt.replace$default(r210, "{" + r71.getKey() + '}', Matcher.quoteReplacement(r71.getValue()), false, 4, null);
        goto L165
    L170:
        r210 = null;
        goto L165
    L172:
        if (r210 != null) goto L174;
        String r123 = BuildConfig.FLAVOR;
    L175:
        SpannableStringBuilder r72 = r69.append(r123);
        Iterator<Map.Entry<String, List<ContentValue>>> r73 = r8.getSystemContents().entrySet().iterator();
        SpannableStringBuilder r74 = r72;
    L177:
        if (r73.hasNext() == false) goto L179;
        Map.Entry<String, List<ContentValue>> r75 = r73.next();
        Intrinsics.checkNotNull(r74);
        r74 = SystemContentUtilV2.b(r74, "{" + r75.getKey() + '}', SystemContentUtilV2.a(r75, r12, r14));
        goto L177
    L179:
        Intrinsics.checkNotNull(r74);
        Intrinsics.checkNotNullParameter(r74, ChameleonOpenTracker.ParamKey.RESULT);
        Intrinsics.checkNotNullParameter(r13, "processorList");
        Intrinsics.checkNotNullParameter(r14, "actionContext");
        Iterator r76 = r13.iterator();
    L181:
        if (r76.hasNext() == false) goto L185;
        Object r77 = r76.next();
        r119 = null;
        if (((com.ss.android.lark.biz.im.api.extension.message.system.c) r77).a(null, r14) == false) goto L181;
    L186:
        com.ss.android.lark.biz.im.api.extension.message.system.c r78 = (com.ss.android.lark.biz.im.api.extension.message.system.c) r77;
        r33 = r74;
        if (r78 == null) goto L192;
        int r79 = r74.length();
        r74.append(" ");
        r78.c(r74, r119, r14);
        r74.append(r78.b(r119, r14));
        r74.setSpan(new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.b(r78, r14, r119, r14.context()), r79, r74.length(), 33);
        r33 = r74;
        goto L192
    L185:
        r119 = null;
        r77 = null;
        goto L186
    L174:
        r123 = r210;
        goto L175
    L190:
        r119 = null;
        r33 = r8.getFormattedContent();
        goto L192
    L154:
        if (r8.getVersion() > 0) goto L156;
    L158:
        r68 = false;
        goto L160
    L156:
        if (r8.isMsgClickable() == false) goto L158;
        r68 = true;
    L191:
        r119 = null;
        r33 = BuildConfig.FLAVOR;
        goto L192
    L10:
        r6 = null;
        goto L11
    }

    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r1, com.ss.android.lark.blueprint.q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }

    public final void c(BlueprintCell r1, com.ss.android.lark.blueprint.q r2, Object r3, Object r4) {
        com.ss.android.lark.blueprint.i.a.b(this, r1, r2, (y6b.a) r3, (com.ss.android.lark.chat.base.view.vo.message.d) r4);
    }
}
