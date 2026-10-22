package com.larus.bmhome.chat.layout.holder.helper;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.api.SelectionRangeType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.reference.entity.RefEntranceType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.MessageMenu;
import com.larus.bmhome.view.actionbar.api.ChatUIBlockConfig;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.bmhome.view.y3;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.trace.CopyContentTypeString;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MarkDownSelectHelper implements com.larus.bmhome.chat.api.z {
    public static final MarkDownSelectHelper a = null;
    public static final int[] b = null;
    public static final int[] c = null;
    public static WeakReference<MessageMenu> d;
    public static final Lazy e = null;

    public static final class a implements com.larus.bmhome.chat.api.d0 {
        public final /* synthetic */ com.larus.bmhome.chat.api.d0 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Ref.ObjectRef<String> d;
        public final /* synthetic */ Ref.ObjectRef<SelectionRangeType> e;
        public final /* synthetic */ Message f;
        public final /* synthetic */ by7.e g;
        public final /* synthetic */ long h;
        public final /* synthetic */ String i;

        @Override // com.larus.bmhome.chat.api.d0
        public final void a(View r2, int r3, int r4) {
            com.larus.bmhome.chat.api.d0 r0 = this.a;
            if (r0 == null) goto L6;
            r0.a(r2, r3, r4);
            return;
        }

        @Override // com.larus.bmhome.chat.api.d0
        public final void b(final SelectionRangeType r14, int r15, int r16, boolean r17, boolean r18, Rect r19, String r20) {
            Intrinsics.checkNotNullParameter(r14, "rangeType");
            Intrinsics.checkNotNullParameter(r20, "selectedText");
            CustomMarkdownTextView r1 = this.b;
            String r8 = st8.b.a.a((st8.b) r1, r1.getMarkdownContent());
            com.larus.bmhome.chat.api.d0 r2 = this.a;
            if (r2 == null) goto L5;
            r2.b(r14, r15, r16, r17, r18, r19, r8);
        L5:
            if (r17 == false) goto L9;
            if (r18 == false) goto L8;
            String r3 = "drag_select_forward";
        L10:
            final String r10 = r3;
            this.d.element = r10;
            this.e.element = r14;
            final Message r4 = this.f;
            final by7.e r5 = this.g;
            final long r6 = this.h;
            final String r9 = this.i;
            final View r11 = this.b;
            Runnable r12 = new j1(r10, r14, r4, r5, r6, r9, r11);
            if (Intrinsics.areEqual(r10, "double_click_text") == false) goto L14;
            ((Handler) MarkDownSelectHelper.e.getValue()).postDelayed(r12, 600);
            return;
        L14:
            if (Intrinsics.areEqual(r10, "triple_click_text") == false) goto L16;
            ((Handler) MarkDownSelectHelper.e.getValue()).removeCallbacksAndMessages(null);
            r12.run();
            return;
        L16:
            r12.run();
            return;
        L8:
            r3 = "drag_select_backward";
            goto L10
        L9:
            r3 = this.c;
            goto L10
        }

        public a(com.larus.bmhome.chat.api.d0 r1, View r2, String r3, Ref.ObjectRef<String> r4, Ref.ObjectRef<SelectionRangeType> r5, Message r6, by7.e r7, long r8, String r10) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r10;
        }
    }

    public static final class b implements com.larus.bmhome.chat.api.d0 {
        public final /* synthetic */ com.larus.bmhome.chat.api.d0 a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ Ref.IntRef c;
        public final /* synthetic */ View d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Ref.ObjectRef<String> f;
        public final /* synthetic */ Ref.ObjectRef<SelectionRangeType> g;
        public final /* synthetic */ Message h;
        public final /* synthetic */ Fragment i;
        public final /* synthetic */ long j;

        @Override // com.larus.bmhome.chat.api.d0
        public final void a(View r2, int r3, int r4) {
            com.larus.bmhome.chat.api.d0 r0 = this.a;
            if (r0 == null) goto L6;
            r0.a(r2, r3, r4);
            return;
        }

        @Override // com.larus.bmhome.chat.api.d0
        public final void b(final SelectionRangeType r9, int r10, int r11, boolean r12, boolean r13, Rect r14, String r15) {
            Intrinsics.checkNotNullParameter(r9, "rangeType");
            Intrinsics.checkNotNullParameter(r15, "selectedText");
            this.b.element = r10;
            this.c.element = r11;
            com.larus.bmhome.chat.api.d0 r0 = this.a;
            if (r0 == null) goto L6;
            CustomMarkdownTextView r16 = this.d;
            r0.b(r9, r10, r11, r12, r13, r14, st8.b.a.a((st8.b) r16, r16.getMarkdownContent()));
        L6:
            if (r12 == false) goto L10;
            if (r13 == false) goto L9;
            String r17 = "drag_select_forward";
        L13:
            this.f.element = r17;
            this.g.element = r9;
            final Message r3 = this.h;
            final Fragment r4 = this.i;
            final long r5 = this.j;
            final View r7 = this.d;
            final String r1 = r17;
            Runnable r18 = new k1(r1, r9, r3, r4, r5, r7);
            if (Intrinsics.areEqual(r17, "double_click_text") == false) goto L17;
            ((Handler) MarkDownSelectHelper.e.getValue()).postDelayed(r18, 600);
            return;
        L17:
            if (Intrinsics.areEqual(r17, "triple_click_text") == false) goto L19;
            ((Handler) MarkDownSelectHelper.e.getValue()).removeCallbacksAndMessages(null);
            r18.run();
            return;
        L19:
            r18.run();
            return;
        L9:
            r17 = "drag_select_backward";
            goto L13
        L10:
            r17 = this.e;
            if (r17 != null) goto L13;
            r17 = "double_click_text";
            goto L13
        }

        public b(com.larus.bmhome.chat.api.d0 r1, Ref.IntRef r2, Ref.IntRef r3, View r4, String r5, Ref.ObjectRef<String> r6, Ref.ObjectRef<SelectionRangeType> r7, Message r8, Fragment r9, long r10) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
        }
    }

    public static final class c implements qt8.a {
        public final /* synthetic */ com.larus.bmhome.chat.api.q0 a;
        public final /* synthetic */ com.larus.bmhome.chat.api.b0 b;
        public final /* synthetic */ View c;
        public final /* synthetic */ Message d;

        public c(com.larus.bmhome.chat.api.q0 r1, com.larus.bmhome.chat.api.b0 r2, View r3, Message r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a(ut8.i r10, boolean r11, int r12, int r13) {
            Intrinsics.checkNotNullParameter(r10, "selector");
            boolean r14 = false;
            if (r12 <= r13) goto L5;
            boolean r1 = true;
        L6:
            com.larus.bmhome.chat.api.q0 r2 = this.a;
            if ((r2 instanceof MessageAdapter) == false) goto L9;
            MessageAdapter r3 = (MessageAdapter) r2;
        L10:
            if (r3 == null) goto L14;
            ChatMessageList r4 = r3.u;
            if (r4 == null) goto L14;
            y3 r5 = r4.getAutoPollTask();
        L15:
            ChatMessageList r6 = this.a.B7();
            if (r6 == null) goto L18;
            r6.getLocationOnScreen(MarkDownSelectHelper.c);
        L18:
            if (r11 == true) goto L23;
            if (r5 == null) goto L21;
            r5.c("callback is not move");
        L21:
            MarkDownSelectHelper r15 = MarkDownSelectHelper.a;
            this.b.m();
            MarkDownSelectHelper.f(this.a, this.c, this.d, null);
            return;
        L23:
            CustomMarkdownTextView r16 = this.c;
            r16.getClass();
            int[] r7 = MarkDownSelectHelper.b;
            r16.getLocationOnScreen(r7);
            int r17 = r7[1];
            int[] r8 = MarkDownSelectHelper.c;
            int r9 = r8[1];
            if ((r17 - r9) <= 0) goto L26;
            boolean r18 = true;
        L28:
            if ((((r9 + this.b.m().getHeight()) - r7[1]) - this.c.getHeight()) <= 0) goto L30;
            boolean r19 = true;
        L32:
            if (r18 == false) goto L44;
            if (r19 == false) goto L44;
            if (r5 == null) goto L39;
            if (r5.b != true) goto L39;
            r14 = true;
        L39:
            if (r14 == false) goto L41;
            r5.c("holder is total in screen!");
            return;
        L41:
            FLogger.a.i("MarkDownSelectHelper", "holder is total in screen!");
            return;
        L44:
            if (r1 == false) goto L46;
        L50:
            ChatMessageList r20 = this.a.B7();
            if (r20 == null) goto L53;
            int r21 = r20.getHeight();
        L54:
            if (r1 == true) goto L56;
        L60:
            int r22 = r7[1] + this.c.getHeight();
            if (r1 == false) goto L78;
            if (r5 != null) goto L64;
        L66:
            boolean r23 = false;
        L67:
            if (r23 == false) goto L78;
            if (r5.d == false) goto L78;
            int r24 = r8[1];
            if (r22 >= (r21 + r24)) goto L74;
            if (r24 > r22) goto L74;
            boolean r25 = true;
        L75:
            if (r25 == false) goto L78;
            r5.c("holder bottom in Screen, so stop scroll");
            return;
        L74:
            r25 = false;
            goto L75
        L64:
            if (r5.b != true) goto L66;
            r23 = true;
        L78:
            if (r1 == true) goto L90;
            if (r5 != null) goto L81;
        L83:
            boolean r26 = false;
        L84:
            if (r26 == false) goto L90;
            if (r5.d == true) goto L90;
            if (r18 == false) goto L90;
            r5.c("holder top in Screen, so stop scroll");
            return;
        L81:
            if (r5.b != true) goto L83;
            r26 = true;
        L90:
            if (r12 != r13) goto L99;
            if (r5 != null) goto L93;
        L95:
            boolean r110 = false;
        L96:
            if (r110 == false) goto L99;
            FLogger.a.i("MarkDownSelectHelper", "dul is same,do nothing!");
            return;
        L93:
            if (r5.b != true) goto L95;
            r110 = true;
        L99:
            if (r1 == false) goto L116;
            if (r5 != null) goto L102;
        L104:
            boolean r111 = false;
        L105:
            if (r111 == true) goto L107;
        L108:
            MarkDownSelectHelper r112 = MarkDownSelectHelper.a;
            View r113 = MarkDownSelectHelper.c(this.c);
            if (r113 == null) goto L138;
            com.larus.bmhome.chat.api.b0 r114 = this.b;
            final View r115 = this.c;
            int[] r27 = new int[2];
            int[] r116 = new int[2];
            r113.getLocationOnScreen(r27);
            r114.m().getLocationOnScreen(r116);
            int r117 = (r116[1] + r114.m().getHeight()) - (r27[1] + r113.getHeight());
            if (r117 >= 0) goto L114;
            if (r5 == null) goto L139;
            r5.b(true, r117, new l1(r115));
            return;
        L139:
            return;
        L114:
            if (r5 == null) goto L141;
            r5.c("holder is screen to bottom!");
            return;
        L141:
            return;
        L138:
            return;
        L107:
            if (r5.b == true) goto L116;
        L102:
            if (r5.d != true) goto L104;
            r111 = true;
        L116:
            if (r1 == true) goto L143;
            if (r5 != null) goto L119;
        L121:
            boolean r118 = false;
        L122:
            if (r118 == false) goto L126;
            if (r5.b == false) goto L126;
            return;
        L126:
            if (r18 == true) goto L132;
            MarkDownSelectHelper r119 = MarkDownSelectHelper.a;
            if (MarkDownSelectHelper.c(this.c) == null) goto L145;
            final View r120 = this.c;
            if (r5 == null) goto L146;
            r5.b(false, r7[1], new m1(r120));
            return;
        L146:
            return;
        L145:
            return;
        L132:
            if (r5 == null) goto L148;
            r5.c("holder is screen to top!");
            return;
        L148:
            return;
        L119:
            if (r5.d == true) goto L121;
            r118 = true;
            goto L122
        L143:
            return;
        L56:
            if (((r8[1] + r21) - r12) < 200) goto L60;
            if (r5 == null) goto L137;
            r5.c("The distance from bottom is not enough");
            return;
        L137:
            return;
        L53:
            r21 = 0;
            goto L54
        L46:
            if ((r12 - r8[1]) < 200) goto L50;
            if (r5 == null) goto L136;
            r5.c("The distance from above is not enough");
            return;
        L136:
            return;
        L30:
            r19 = false;
            goto L32
        L26:
            r18 = false;
        L14:
            r5 = null;
            goto L15
        L9:
            r3 = null;
            goto L10
        L5:
            r1 = false;
            goto L6
        }
    }

    public MarkDownSelectHelper() {
    }

    static {
        a = new MarkDownSelectHelper();
        b = new int[2];
        c = new int[2];
        e = LazyKt.lazy(new e1());
    }

    public static View c(View r2) {
        Object r0 = r2.getParent();
        if ((r0 instanceof RecyclerView) == false) goto L6;
        return r2;
    L6:
        if ((r0 instanceof View) == true) goto L8;
        return null;
    L8:
        return c((View) r0);
    }

    public static final void d(View r2) {
        t19.s r0 = t19.s.a;
        CustomMarkdownTextView r3 = (CustomMarkdownTextView) r2;
        r3.getClass();
        Context r4 = r3.getContext();
        r0.getClass();
        t19.s.o(r4, 2131910467, false);
    }

    public static Message e(Message r90, String r91) {
        Intrinsics.checkNotNullParameter(r90, "<this>");
        Intrinsics.checkNotNullParameter(r91, "selectedText");
        if (com.larus.im.bean.message.a.b0(r90) == false) goto L10;
        Block r12 = new Block(BlockType.BLOCK_TYPE_TEXT.getValue(), "mock-reference-id", null, new BlockContent(new TextBlock(r91, null, null, null, 0, 30, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, -1, 31, null), false, null, null, null, 240, null);
        if (r90.isNewBlockType() == false) goto L8;
        return Message.copy$default(r90, null, null, null, 0, 0, null, 0, false, null, null, CollectionsKt.listOf(r12), null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1025, 31, null);
    L8:
        return Message.copy$default(r90, null, null, null, 0, 0, null, 0, false, null, GsonProtectorUtils.toJson(new Gson(), CollectionsKt.listOf(r12)), null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -513, 31, null);
    L10:
        return Message.copy$default(r90, null, null, null, 0, 0, null, 0, false, null, new JSONObject().put(ChatDraftItem.TYPE_TEXT, r91).toString(), null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -513, 31, null);
    }

    public static void f(com.larus.bmhome.chat.api.q0 r6, CustomMarkdownTextView r7, Message r8, RefEntranceType r9) {
        com.larus.bmhome.chat.component.cvs.y r0 = (com.larus.bmhome.chat.component.cvs.y) r6.M7().invoke();
        boolean r1 = false;
        boolean r2 = true;
        if (r0 == null) goto L12;
        BotModel r3 = r0.j0();
        if (r3 == null) goto L12;
        Integer r4 = r3.getBotType();
        if (r4 == null) goto L12;
        if (r4.intValue() != 1) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L15;
        return;
    L15:
        ICoreInputAbility r10 = r6.getProvider().v0();
        if (r10 != null) goto L18;
    L20:
        if (r1 == true) goto L23;
        return;
    L23:
        if (ce8.c.a() == false) goto L26;
        FLogger.a.w("MarkDownSelectHelper", "can not trigger reference input mode., because of continue talk.");
        return;
    L26:
        if (r10 == null) goto L28;
        r2 = r10.EK();
    L28:
        Message r11 = e(r8, st8.b.a.a(r7, r7.getMarkdownContent()));
        if (r2 == false) goto L39;
        com.larus.bmhome.chat.component.bottom.reference.a r12 = (com.larus.bmhome.chat.component.bottom.reference.a) r6.P7().invoke();
        if (r12 == null) goto L43;
        com.larus.bmhome.chat.component.cvs.y r13 = (com.larus.bmhome.chat.component.cvs.y) r6.M7().invoke();
        if (r13 == null) goto L37;
        BotModel r14 = r13.j0();
        if (r14 == null) goto L37;
        Integer r15 = r14.getBotType();
    L38:
        r12.Vu(r11, r15, "auto_cite", false, r9);
        return;
    L37:
        r15 = null;
        goto L38
    L43:
        return;
    L39:
        com.larus.bmhome.chat.component.bottom.reference.a r16 = (com.larus.bmhome.chat.component.bottom.reference.a) r6.P7().invoke();
        if (r16 == null) goto L45;
        r16.CN(r11);
        return;
    L45:
        return;
    L18:
        if (r10.Wz() != true) goto L20;
        r1 = true;
    L12:
        r5 = false;
        goto L13
    }

    @Override // com.larus.bmhome.chat.api.z
    public final void b(final com.larus.bmhome.chat.api.q0 r34, final View r35, final Message r36, boolean r37, final String r38, final String r39, int r40, boolean r41, com.larus.bmhome.chat.api.d0 r42) {
        Intrinsics.checkNotNullParameter(r34, "adapter");
        Intrinsics.checkNotNullParameter(r35, "markdownView");
        Intrinsics.checkNotNullParameter(r36, "data");
        if ((r35 instanceof CustomMarkdownTextView) == true) goto L5;
        return;
    L5:
        final Fragment r17 = (Fragment) r34.getHostFragment().invoke();
        final ChatMessageList r12 = r34.B7();
        if (r12 != null) goto L8;
        return;
    L8:
        Long r0 = r12.getChatUniqueKey();
        if (r0 == null) goto L11;
        long r1 = r0.longValue();
    L12:
        final long r18 = r1;
        final com.larus.bmhome.chat.component.bottom.reference.a r11 = (com.larus.bmhome.chat.component.bottom.reference.a) r34.P7().invoke();
        va8.o r9 = r34.getProvider().w0();
        com.larus.bmhome.chat.component.cvs.y r2 = (com.larus.bmhome.chat.component.cvs.y) r34.M7().invoke();
        MessageMenu r20 = null;
        if (r2 == null) goto L15;
        BotModel r21 = r2.j0();
    L16:
        final Ref.ObjectRef r10 = new Ref.ObjectRef();
        r10.element = r38;
        final Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = SelectionRangeType.CUSTOM_RANGE;
        final Ref.IntRef r6 = new Ref.IntRef();
        r6.element = -1;
        final Ref.IntRef r5 = new Ref.IntRef();
        r5.element = -1;
        boolean r3 = true;
        if (r17 == null) goto L25;
        t1a.b r4 = s1a.a.g(r17);
        if (r4 == null) goto L25;
        ss8.g r8 = r4.getAbility(ss8.g.class);
        if (r8 == null) goto L25;
        if (r8.bc(ChatUIBlockConfig.DISABLE_MESSAGE_INTERACTION) != true) goto L25;
        boolean r13 = true;
    L26:
        CustomMarkdownTextView r22 = (CustomMarkdownTextView) r35;
        if (r21 == null) goto L29;
        List r14 = r21.getSelectTextActions();
    L30:
        if (r14 == null) goto L43;
        com.larus.bmhome.chat.component.collection.o r15 = (com.larus.bmhome.chat.component.collection.o) r34.i2().invoke();
        if (r15 != null) goto L34;
    L36:
        boolean r16 = false;
    L37:
        if (r16 == true) goto L43;
        if (Intrinsics.areEqual(r36.getBizContentType(), "deep_search_card") == true) goto L43;
        if (Build.VERSION.SDK_INT < 24) goto L43;
        boolean r19 = true;
    L44:
        if (r37 == false) goto L47;
        if (r13 == true) goto L47;
    L48:
        final BotModel r23 = r21;
        MessageMenu r24 = new MessageMenu(r22, r21, r36, Boolean.valueOf(r19), Boolean.valueOf(r3), new f1(r34, r36, r23, r34, r10, r6, r5, r17, r18, r35, r39, r7, r11, r12, r38), 96);
        r24.u = r40;
        r24.t = r41;
        r24.s = new b(r42, r6, r5, r35, r38, r10, r7, r36, r17, r18);
        r24.i = new c(r34, r12, r35, r36);
        WeakReference<MessageMenu> r25 = d;
        if (r25 == null) goto L51;
        r20 = r25.get();
    L51:
        r35.post(new i1(r20));
        d = new WeakReference(r24);
        r24.f(r12, r9, r11);
        f(r34, (CustomMarkdownTextView) r35, r36, RefEntranceType.ChooseTextAutoCite);
        r12.setBottomReached(false);
        return;
    L47:
        r3 = false;
        goto L48
    L34:
        if (r15.i0() != true) goto L36;
        r16 = true;
    L43:
        r19 = false;
        goto L44
    L29:
        r14 = null;
    L25:
        r13 = false;
        goto L26
    L15:
        r21 = null;
        goto L16
    L11:
        r1 = 0;
        goto L12
    }

    @Override // com.larus.bmhome.chat.api.z
    public final void a(final by7.e r25, final BotModel r26, final String r27, final long r28, final View r30, final Message r31, final String r32, final String r33, RecyclerView r34, boolean r35, int r36, boolean r37, @CopyContentTypeString final String r38, com.larus.bmhome.chat.api.d0 r39, boolean r40, Boolean r41, final String r42, final Function3<? super Message, ? super SelectionRangeType, ? super String, Unit> r43, final Function0<Boolean> r44) {
        Intrinsics.checkNotNullParameter(r32, "clickFrom");
        if (r31 == null) goto L30;
        if (r30 != null) goto L7;
        return;
    L7:
        if ((r30 instanceof CustomMarkdownTextView) == true) goto L9;
        return;
    L9:
        final Ref.ObjectRef r13 = new Ref.ObjectRef();
        r13.element = r32;
        final Ref.ObjectRef r12 = new Ref.ObjectRef();
        r12.element = SelectionRangeType.CUSTOM_RANGE;
        CustomMarkdownTextView r16 = (CustomMarkdownTextView) r30;
        if (r26 == null) goto L12;
        List r0 = r26.getSelectTextActions();
    L13:
        boolean r1 = false;
        boolean r2 = true;
        if (r0 != null) goto L17;
        if (r40 == true) goto L17;
    L19:
        boolean r3 = false;
    L20:
        if (r43 == null) goto L22;
        r1 = true;
    L22:
        if (r41 == null) goto L24;
        r2 = r41.booleanValue();
    L24:
        MessageMenu r10 = new MessageMenu(r16, r26, r31, Boolean.valueOf(r3), Boolean.valueOf(r1), Boolean.valueOf(r35), Boolean.valueOf(r2), new g1(r44, r43, r31, r30, r12, r13, r25, r28, r33, r38, r26, r27, r42, r32));
        r10.u = r36;
        r10.t = r37;
        r10.s = new a(r39, r30, r32, r13, r12, r31, r25, r28, r33);
        WeakReference<MessageMenu> r4 = d;
        if (r4 == null) goto L27;
        MessageMenu r5 = r4.get();
    L28:
        r30.post(new i1(r5));
        d = new WeakReference(r10);
        r10.f(r34, null, null);
        return;
    L27:
        r5 = null;
    L17:
        if (Build.VERSION.SDK_INT < 24) goto L19;
        r3 = true;
        goto L20
    L12:
        r0 = null;
        goto L13
    }
}
