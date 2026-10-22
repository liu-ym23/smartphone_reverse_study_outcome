package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ThreadReplyBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {
    public final IMMessageKeys$Blocks g;
    public final IMMessageKeys$Slots h;
    public final Lazy i;

    public static final class a implements com.ss.android.lark.blueprint.k<View>, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.b {
        public final View a;
        public final View b;
        public final TextView c;
        public final EllipsizedEmojiconTextView d;
        public final ImageView e;
        public final LKUIRoundableLayout f;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ThreadReplyBlock$a$a, reason: collision with other inner class name */
        public static final class C0043a {
        }

        static {
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.b
        public final LKUIRoundableLayout a() {
            return this.f;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.b
        public final EllipsizedEmojiconTextView b() {
            return this.d;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.b
        public final ImageView c() {
            return this.e;
        }

        public final View getView() {
            return this.a;
        }

        public a(View r5) {
            Intrinsics.checkNotNullParameter(r5, "view");
            this.a = r5;
            this.b = r5.findViewById(2131388590);
            TextView r0 = (TextView) r5.findViewById(2131388599);
            this.c = r0;
            EllipsizedEmojiconTextView r1 = r5.findViewById(2131388593);
            this.d = r1;
            this.e = (ImageView) r5.findViewById(2131388592);
            LKUIRoundableLayout r2 = r5.findViewById(2131388597);
            this.f = r2;
            r2.setRadius(4.0f);
            r2.setBorderWidth(1.0f);
            Context r6 = r5.getContext();
            LarkFont r3 = LarkFont.BODY1;
            zz7.a.d(r0, r3);
            zz7.a.d(r1, r3);
            r1.setEmojiconSize(zz7.b.g(r6, 16));
            r1.setEmojiconTextSize((int) zz7.b.i(r6, r3));
        }
    }

    public static final class b implements com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.c {
        public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<?>> a;
        public final /* synthetic */ ThreadReplyBlock b;

        public b(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, ThreadReplyBlock r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.c
        public final void a(com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.b r2, y6b.c<?> r3) {
            Intrinsics.checkNotNullParameter(r2, "holder");
            Intrinsics.checkNotNullParameter(r3, "item");
            e6b.b r4 = this.a;
            if ((r4 instanceof e6b.b) == false) goto L5;
            e6b.b r5 = r4;
        L6:
            if (r5 == null) goto L9;
            r5.j(this.b, r3);
            return;
        L9:
            return;
        L5:
            r5 = null;
            goto L6
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.c
        public final boolean b(com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.b r2, y6b.c<?> r3) {
            Intrinsics.checkNotNullParameter(r2, "holder");
            Intrinsics.checkNotNullParameter(r3, "item");
            e6b.b r4 = this.a;
            if ((r4 instanceof e6b.b) == false) goto L5;
            e6b.b r5 = r4;
        L6:
            if (r5 != null) goto L10;
            return false;
        L10:
            return r5.e(this.b, r3);
        L5:
            r5 = null;
            goto L6
        }
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public ThreadReplyBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.THREAD_REPLY;
        this.h = IMMessageKeys$Slots.HEADER;
        this.i = LazyKt.lazy(new ThreadReplyBlock$threadReplyContentRender$2(this));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r2, com.ss.android.lark.blueprint.q<y6b.a<?>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        com.ss.android.lark.blueprint.i.a.a(r2, r3);
        g(r3, this.g, this.h);
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<?>> r21, com.ss.android.lark.blueprint.q<y6b.a<?>> r22, y6b.a<?> r23) {
        Intrinsics.checkNotNullParameter(r21, "cell");
        Intrinsics.checkNotNullParameter(r22, "layout");
        Intrinsics.checkNotNullParameter(r23, Keys.API_RETURN_KEY_DATA);
        if ((r23 instanceof y6b.c) == false) goto L5;
        y6b.c r3 = (y6b.c) r23;
    L6:
        if (r3 != null) goto L10;
        g(r22, this.g, this.h);
        return;
    L10:
        if (r3.G1 == 0) goto L163;
        int r4 = com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.h.a;
        m2b.a r5 = this.c;
        Intrinsics.checkNotNullParameter(r5, "chatContext");
        Intrinsics.checkNotNullParameter(r3, "item");
        Chat r6 = r5.getChat();
        boolean r14 = true;
        boolean r15 = false;
        if (r6 != null) goto L15;
        Log.w("ThreadReplyBlockRender", "stop binding for chat is null.");
    L26:
        boolean r7 = false;
    L28:
        if (r7 == false) goto L163;
        a r8 = (a) r22.c(this.g, this.h, new ThreadReplyBlock$update$blockView$1(this));
        if ((r22 instanceof l3b.a) == false) goto L33;
        l3b.a r2 = (l3b.a) r22;
    L34:
        if (r2 == null) goto L37;
        u5b.c r9 = r2.j();
        if (r9 == null) goto L37;
    L48:
        Intrinsics.checkNotNull(r9);
        int[] r10 = r9.d;
        r8.a.setPadding(r10[0], r10[1], r10[2], r10[3]);
        r8.b.setVisibility(0);
        r8.b.setBackground(r9.c);
        r8.c.setTextColor(r9.a);
        r8.d.setTextColor(r9.b);
        y6b.c r13 = r3.y1;
        if (r13 == null) goto L168;
        y6b.b r11 = r13.t;
        if (r11 == null) goto L53;
        TextView r12 = r8.c;
        StringCompanionObject r16 = StringCompanionObject.INSTANCE;
        ((com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.d) this.i.getValue()).getClass();
        Intrinsics.checkNotNullParameter(r11, "chatterVO");
        r12.setText(String.format("%s: ", Arrays.copyOf(new Object[]{UIHelper.mustacheFormat(2131892132, IPortraitService.NAME, UIHelper.mustacheFormat(2131890794, IPortraitService.NAME, r11.i))}, 1)));
    L53:
        TextView r17 = r8.c;
        if (r11 == null) goto L56;
        boolean r18 = true;
    L58:
        if (r18 == false) goto L60;
        int r19 = 0;
    L61:
        r17.setVisibility(r19);
        ((com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.d) this.i.getValue()).c = new b(r21, this);
        com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.d r1 = (com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.d) this.i.getValue();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r13, "threadReplyMessageVO");
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r8, "holder");
        Intrinsics.checkNotNullParameter(r9, "threadReplyStyle");
        r8.d.setVisibility(0);
        r8.e.setVisibility(8);
        r8.f.setVisibility(8);
        if (r13.j() == false) goto L69;
        if (r13.x != Message.RecallerIdentity.ENTERPRISE_ADMINISTRATOR) goto L66;
        String r20 = UIHelper.getString(2131891218);
    L67:
        Function2<String, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.b, Unit> r24 = r1.a;
        Intrinsics.checkNotNull(r20);
        r24.invoke(r20, r8);
    L79:
        boolean r25 = true;
    L81:
        if (r25 == true) goto L169;
        r8.d.setVisibility(8);
        r8.e.setVisibility(0);
        r8.f.setVisibility(0);
        int r26 = com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.d.b.a[r13.getType().ordinal()];
        if (r26 == 1) goto L88;
        if (r26 == 2) goto L87;
        String r110 = "threadReplyStyle";
        y6b.c r27 = r13;
    L119:
        if (r15 == true) goto L170;
        r8.d.setVisibility(0);
        r8.e.setVisibility(8);
        r8.f.setVisibility(8);
        r8.d.setTranslateEmojiCode(false);
        EllipsizedEmojiconTextView r28 = r8.d;
        int r29 = h18.e.a;
        FragmentActivity r30 = r1.b.getContext();
        if (r27.getType() != Message.Type.POST) goto L124;
        int r31 = 1;
    L125:
        r28.setTypeface(h18.e.b(r30, r31));
        Intrinsics.checkNotNullParameter(r27, "<this>");
        CharSequence r32 = r27.H0;
        if (r32 != null) goto L128;
    L131:
        boolean r33 = true;
    L132:
        if (r33 == true) goto L134;
    L138:
        if (r32 == null) goto L148;
        MessageEditInfo r34 = r27.C;
        if (r34 != null) goto L142;
    L144:
        r14 = false;
    L145:
        if (r14 == false) goto L147;
        String r35 = UIHelper.getString(2131891078);
        SpannableStringBuilder r36 = new SpannableStringBuilder(r35);
        Intrinsics.checkNotNull(r35);
        int r37 = 0;
        r36.setSpan(new com.ss.android.lark.widget.span.i0(r35, UIHelper.getColor(2131106607), h18.d.a(r1.b.getContext(), 12.0f)), 0, r36.length(), 33);
        SpannableStringBuilder r111 = r36.insert(0, r32);
    L149:
        r32 = r111;
    L150:
        SpannableStringBuilder r38 = new SpannableStringBuilder(r32);
        Iterator r39 = ArrayIteratorKt.iterator((ncc.e[]) r38.getSpans(r37, r38.length(), ncc.e.class));
    L152:
        if (r39.hasNext() == false) goto L161;
        ncc.e r40 = (ncc.e) r39.next();
        Intrinsics.checkNotNull(r40);
        Intrinsics.checkNotNullParameter(r40, "span");
        String r41 = r110;
        Intrinsics.checkNotNullParameter(r9, r41);
        Intrinsics.checkNotNullParameter(r8, "holder");
        Drawable r42 = r40.c;
        if (r42 == null) goto L156;
        r42.mutate();
        r42.setTint(r9.b);
    L156:
        r40.a(new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.a(r9, r8.d));
        if (r40.b == null) goto L160;
        Paint r43 = new Paint();
        r43.setColorFilter(new PorterDuffColorFilter(r9.b, PorterDuff.Mode.SRC_IN));
        Bitmap r44 = Bitmap.createBitmap(r40.b.getWidth(), r40.b.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(r44).drawBitmap(r40.b, 0.0f, 0.0f, r43);
        r40.b = r44;
    L160:
        r110 = r41;
        goto L152
    L161:
        r8.d.setText(r38);
        return;
    L147:
        r37 = 0;
        goto L150
    L142:
        if (r34.isEdited() != true) goto L144;
    L148:
        r37 = 0;
        r111 = null;
        goto L149
    L134:
        if (r27.L0 == null) goto L138;
        Log.d("CommonThreadReplyContentRender", "generator displayText.");
        y6b.c.b r45 = r27.L0;
        if (r45 == null) goto L138;
        u2b.b r46 = (u2b.b) r45;
        r32 = r46.a.d(r46.b);
        goto L138
    L128:
        if (r32.length() == 0) goto L131;
        r33 = false;
        goto L132
    L124:
        r31 = 0;
        goto L125
    L170:
        return;
    L87:
        r8.f.setBorderColor(UIHelper.getColor(2131106784));
        r8.f.setBorderWidth(0.0f);
        r8.f.setRadius(3.0f);
        ViewGroup.LayoutParams r47 = r8.e.getLayoutParams();
        r47.width = -2;
        r47.height = -2;
        r8.e.setLayoutParams(r47);
        r8.e.setImageResource(2131238046);
        r8.e.setOnClickListener(new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.g(r1, r8, r3));
        r110 = "threadReplyStyle";
        r27 = r13;
    L118:
        r15 = true;
        goto L119
    L88:
        LKUIRoundableLayout r48 = r8.f;
        boolean r49 = r3.i;
        int r50 = p3b.a.W;
        if (r49 == false) goto L91;
        int r51 = v4b.a.h;
    L92:
        r48.setBorderColor(r51);
        ViewGroup.LayoutParams r52 = r8.e.getLayoutParams();
        int r53 = UIHelper.dp2px(40.0f);
        if (r52.width == r53) goto L95;
    L96:
        r52.width = r53;
        r52.height = r53;
        r8.e.setLayoutParams(r52);
    L97:
        ValidateResult r112 = MessagePermissionUtil.b();
        boolean r113 = MessagePermissionUtil.f(r13, r1.b.getChat(), r112);
        ValidateIMFileResult r54 = r13.F;
        if (r54 == null) goto L100;
        IMFileResult r55 = r54.getResultType();
    L101:
        MessagePermissionUtil.ReceiveAuthorizationState r114 = MessagePermissionUtil.h(r55);
        ImageView r56 = r8.e;
        r110 = "threadReplyStyle";
        r56.setOnClickListener(new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.e(r13, r1, r114, r113, r112, r3, r56));
        r8.e.setOnLongClickListener(new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.f(r1, r8, r3));
        ResourceCleanScene r57 = lpc.a.b(r13);
        if (r57 != null) goto L104;
    L106:
        boolean r58 = false;
    L107:
        if (r58 == false) goto L109;
        com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.d.a(r8);
        r27 = r13;
        goto L118
    L109:
        if (r113 == true) goto L111;
    L117:
        r27 = r13;
        com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.d.a(r8);
        goto L118
    L111:
        if (MessagePermissionUtil.g(r114) == true) goto L117;
        FragmentActivity r59 = r1.b.getContext();
        ImageView r60 = r8.e;
        r27 = r13;
        T r61 = r27.o;
        if ((r61 instanceof ImageContentVO) == false) goto L115;
        ImageContentVO r62 = (ImageContentVO) r61;
    L116:
        h7b.i.e(r59, r60, r62);
        goto L118
    L115:
        r62 = null;
        goto L116
    L104:
        if (r57.isCSAMDelete() != true) goto L106;
        r58 = true;
        goto L107
    L100:
        r55 = null;
        goto L101
    L95:
        if (r52.height == r53) goto L97;
    L91:
        r51 = v4b.a.G;
        goto L92
    L169:
        return;
    L66:
        r20 = UIHelper.getString(2131891918);
        goto L67
    L69:
        if (r13.j == false) goto L72;
        String r63 = UIHelper.getString(2131891925);
        Function2<String, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.b, Unit> r64 = r1.a;
        Intrinsics.checkNotNull(r63);
        r64.invoke(r63, r8);
        goto L79
    L72:
        if (r13.y == false) goto L75;
        String r65 = UIHelper.getString(2131890914);
        Function2<String, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.b, Unit> r66 = r1.a;
        Intrinsics.checkNotNull(r65);
        r66.invoke(r65, r8);
        goto L79
    L75:
        if (r13.Y == true) goto L77;
    L80:
        r25 = false;
        goto L81
    L77:
        if (r13.p0 == false) goto L80;
        String r67 = UIHelper.getString(2131891227);
        Function2<String, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.b, Unit> r68 = r1.a;
        Intrinsics.checkNotNull(r67);
        r68.invoke(r67, r8);
        goto L79
    L60:
        r19 = 8;
        goto L61
    L56:
        r18 = false;
        goto L58
    L168:
        return;
    L37:
        boolean r69 = r3.i;
        int r70 = p3b.a.W;
        if (r69 == false) goto L40;
        int r71 = v4b.a.i;
    L41:
        if (r69 == false) goto L43;
        int r72 = v4b.a.i;
    L44:
        if (r69 == false) goto L46;
        int r73 = v4b.a.x;
    L47:
        Drawable r74 = UIHelper.getDrawable(r73);
        u5b.c r75 = u5b.c.e;
        r9 = u5b.c.a.a(r71, r72, r74, null);
        goto L48
    L46:
        r73 = v4b.a.T;
        goto L47
    L43:
        r72 = v4b.a.H;
        goto L44
    L40:
        r71 = v4b.a.H;
        goto L41
    L33:
        r2 = null;
        goto L34
    L15:
        if (r3.n >= (r6.getFirstMessagePosition() + 1)) goto L17;
        boolean r76 = true;
    L18:
        if (r76 == false) goto L20;
        Log.w("ThreadReplyBlockRender", "stop binding for thread message is preMsg.");
        goto L26
    L20:
        y6b.c<T> r77 = r3.y1;
        if (r77 != 0) goto L24;
        Log.w("ThreadReplyBlockRender", "stop binding for thread reply messageVO is null.");
        goto L26
    L24:
        if (r77.k == true) goto L27;
        Log.w("ThreadReplyBlockRender", "stop binding for thread reply message is invisible, its id is " + r77.c);
        goto L26
    L27:
        r7 = true;
        goto L28
    L17:
        r76 = false;
    L163:
        g(r22, this.g, this.h);
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, com.ss.android.lark.blueprint.q<y6b.a<?>> r2, y6b.a<?> r3) {
        update2(r1, r2, r3);
    }
}
