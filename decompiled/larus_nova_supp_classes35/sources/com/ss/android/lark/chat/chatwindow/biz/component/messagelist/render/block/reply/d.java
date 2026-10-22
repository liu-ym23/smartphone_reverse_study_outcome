package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.biz.im.api.message.params.o;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ReplyBlock;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chat.utils.ReplyActionUtils;
import com.ss.android.lark.coremd.utils.MessageStyleHelper;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.i;
import com.ss.android.lark.widget.span.i0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class d extends CommonReplyContentRender implements c {
    public final m2b.a b;
    public final c.a c;
    public c.a d;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[Message.Type.RED_PACKET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L6:
            a = r0;
            int[] r1 = new int[ReplyActionUtils.ReplyStyle.values().length];
            r1[ReplyActionUtils.ReplyStyle.PARTIAL_REPLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r1[ReplyActionUtils.ReplyStyle.FULL_REPLY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L9:
            b = r1;
        }
    }

    public c.a d() {
        return this.c;
    }

    public m2b.a e() {
        return this.b;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.c
    public final void a(ReplyBlock.b r1) {
        this.d = r1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.c
    public final String b(y6b.b r2) {
        Intrinsics.checkNotNullParameter(r2, "chatterVO");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return r2.i;
    }

    public final void g(ReplyBlock.a r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        r3.f.setImageResource(2131232612);
        r3.g.setRadius(6.0f);
        r3.g.setBorderWidth(1.0f);
        r3.g.setBorderColor(UDColorUtils.getColor(e().getContext(), 2131103351));
    }

    public d(m2b.a r2, c.a r3) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        Intrinsics.checkNotNullParameter(r3, "callbackHub");
        this.b = r2;
        this.c = r3;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.c
    public final void c(y6b.c r13, y6b.c r14, ReplyBlock.a r15) {
        u5b.b r0 = u5b.b.e;
        Intrinsics.checkNotNullParameter(r13, "replyMessageVO");
        Intrinsics.checkNotNullParameter(r14, "item");
        Intrinsics.checkNotNullParameter(r15, "holder");
        Intrinsics.checkNotNullParameter(r0, "replyStyle");
        r15.d.setVisibility(0);
        r15.f.setVisibility(8);
        r15.g.setVisibility(8);
        boolean r6 = true;
        if (r13.j() == false) goto L10;
        if (Message.RecallerIdentity.ENTERPRISE_ADMINISTRATOR != r13.x) goto L7;
        String r3 = UIHelper.getString(2131891218);
    L8:
        Function2<String, b, Unit> r7 = this.a;
        Intrinsics.checkNotNull(r3);
        r7.invoke(r3, r15);
    L20:
        boolean r4 = true;
    L22:
        if (r4 == false) goto L24;
        return;
    L24:
        r15.d.setVisibility(8);
        r15.f.setVisibility(0);
        r15.g.setVisibility(0);
        int r5 = a.a[r13.getType().ordinal()];
        if (r5 == 1) goto L29;
        if (r5 == 2) goto L28;
        boolean r8 = false;
    L31:
        if (r8 == false) goto L33;
        return;
    L33:
        r15.d.setVisibility(0);
        r15.f.setVisibility(8);
        r15.g.setVisibility(8);
        r15.d.setTranslateEmojiCode(false);
        EllipsizedEmojiconTextView r9 = r15.d;
        int r10 = h18.e.a;
        r9.setTypeface(h18.e.b(e().getContext(), 0));
        Message.Type r11 = r13.getType();
        int r12 = ReplyActionUtils.a;
        Intrinsics.checkNotNullParameter(r14, "<this>");
        Intrinsics.checkNotNullParameter(r11, "replyMsgType");
        Message.Type r16 = Message.Type.DOUBAO;
        if (r11 != r16) goto L41;
        if (ReplyActionUtils.c() == false) goto L41;
        if (r14.x1 == null) goto L41;
        ReplyActionUtils.ReplyStyle r17 = ReplyActionUtils.ReplyStyle.PARTIAL_REPLY;
    L48:
        int r18 = a.b[r17.ordinal()];
        if (r18 == 1) goto L78;
        if (r18 != 2) goto L77;
        Intrinsics.checkNotNullParameter(r13, "<this>");
        CharSequence r19 = r13.H0;
        if (TextUtils.isEmpty(r19) == true) goto L54;
    L58:
        if (r19 == null) goto L96;
        MessageEditInfo r110 = r13.C;
        if (r110 != null) goto L62;
    L64:
        r6 = false;
    L65:
        if (r6 == false) goto L97;
        String r111 = e().getContext().getString(2131891078);
        com.ss.android.lark.biz.im.api.message.params.e r20 = e().d0(com.ss.android.lark.biz.im.api.message.params.e.class);
        if (r20 == null) goto L74;
        o r21 = r20.b;
        if (r21 == null) goto L74;
        if (MessageStyleHelper.b(r14) == false) goto L73;
        int r112 = r21.a;
    L75:
        SpannableStringBuilder r22 = new SpannableStringBuilder(r111);
        r22.setSpan(new i0(r111, UDColorUtils.getColor(e().getContext(), r112), UIUtils.dp2px(e().getContext(), 12.0f)), 0, r22.length(), 33);
        CharSequence r113 = r22.insert(0, r19);
    L95:
        r19 = r113;
        goto L97
    L73:
        r112 = r21.b;
    L74:
        r112 = 2131106607;
    L97:
        if (r19 != null) goto L99;
        r15.a.setVisibility(8);
        return;
    L99:
        SpannableStringBuilder r114 = new SpannableStringBuilder(r19);
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("im.message.replay_content.icon_span.enable") == false) goto L115;
        Log.i("MessageReplyContentRender", "enable icon span");
        Iterator r115 = ArrayIteratorKt.iterator((ncc.e[]) r114.getSpans(0, r114.length(), ncc.e.class));
    L103:
        if (r115.hasNext() == false) goto L116;
        ncc.e r23 = (ncc.e) r115.next();
        Intrinsics.checkNotNull(r23);
        Intrinsics.checkNotNullParameter(r23, "span");
        Intrinsics.checkNotNullParameter(r0, "replyStyle");
        Intrinsics.checkNotNullParameter(r15, "holder");
        if (r23.e == false) goto L109;
        if (r23.f == 0) goto L103;
    L109:
        Drawable r24 = r23.c;
        if (r24 == null) goto L112;
        r24.mutate();
        r24.setTint(r0.b);
    L112:
        r23.a(new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.a(r15.d));
        if (r23.b == null) goto L103;
        Paint r25 = new Paint();
        r25.setColorFilter(new PorterDuffColorFilter(r0.b, PorterDuff.Mode.SRC_IN));
        Bitmap r26 = Bitmap.createBitmap(r23.b.getWidth(), r23.b.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(r26).drawBitmap(r23.b, 0.0f, 0.0f, r25);
        r23.b = r26;
    L116:
        r15.d.setText(r114);
        return;
    L115:
        Log.i("MessageReplyContentRender", "disable icon span");
        goto L116
    L62:
        if (r110.isEdited() != true) goto L64;
    L96:
        r19 = null;
        goto L97
    L54:
        if (r13.L0 == null) goto L58;
        Log.d("CommonReplyContentRender", "generator displayText");
        y6b.c.b r27 = r13.L0;
        if (r27 == null) goto L58;
        u2b.b r28 = (u2b.b) r27;
        r19 = r28.a.d(r28.b);
        goto L58
    L77:
        throw new NoWhenBranchMatchedException();
    L78:
        Message.Type r116 = r13.getType();
        Intrinsics.checkNotNullParameter(r14, "<this>");
        Intrinsics.checkNotNullParameter(r116, "partialReplyMessageType");
        y6b.c.b r117 = r14.L0;
        if (r117 == null) goto L96;
        u2b.b r118 = (u2b.b) r117;
        if (r116 != r16) goto L89;
        PartialReplyInfo r119 = r118.b.getMessage().getPartialReplyInfo();
        if (r119 == null) goto L96;
        RichText r120 = r119.getContent();     // Catch: Exception -> L87
        ReplyActionUtils.a(r120);     // Catch: Exception -> L87
        r113 = i.j(r120);     // Catch: Exception -> L87
    L87:
        e = move-exception;
        Log.e("ChatMessageDataMapper", "generatePartialDisplayText error", e);
        goto L96
    L89:
        List r121 = (List) ((HashMap) r118.c.p).get(r116);
        if (r121 == null) goto L94;
        Iterator r122 = r121.iterator();
        if (r122.hasNext() == false) goto L94;
        r113 = ((y6b.d) r122.next()).b(r118.b);
    L94:
        r113 = r118.a.b(r118.b);
    L41:
        if (ReplyActionUtils.c() == false) goto L47;
        PartialReplyInfo r29 = r14.x1;
        if (r29 == null) goto L47;
        if (r29.getPosition() == PartialReplyInfo.PartialContentRelativePosition.UNKNOWN) goto L47;
        r17 = ReplyActionUtils.ReplyStyle.PARTIAL_REPLY;
    L47:
        r17 = ReplyActionUtils.ReplyStyle.FULL_REPLY;
        goto L48
    L28:
        r15.g.setBorderColor(UDColorUtils.getColor(e().getContext(), 2131106784));
        r15.g.setBorderWidth(0.0f);
        r15.g.setRadius(3.0f);
        ViewGroup.LayoutParams r30 = r15.f.getLayoutParams();
        r30.width = -2;
        r30.height = -2;
        r15.f.setLayoutParams(r30);
        r15.f.setImageResource(2131238046);
        r15.f.setOnClickListener(new g(this, r15, r14));
    L30:
        r8 = true;
        goto L31
    L29:
        f(r15, r13, r14);
        goto L30
    L7:
        r3 = UIHelper.getString(2131891918);
        goto L8
    L10:
        if (r13.j == false) goto L13;
        String r31 = UIHelper.getString(2131891925);
        Function2<String, b, Unit> r32 = this.a;
        Intrinsics.checkNotNull(r31);
        r32.invoke(r31, r15);
        goto L20
    L13:
        if (r13.y == false) goto L16;
        String r33 = UIHelper.getString(2131890914);
        Function2<String, b, Unit> r34 = this.a;
        Intrinsics.checkNotNull(r33);
        r34.invoke(r33, r15);
        goto L20
    L16:
        if (r13.Y == true) goto L18;
    L21:
        r4 = false;
        goto L22
    L18:
        if (r13.p0 == false) goto L21;
        String r35 = UIHelper.getString(2131891227);
        Function2<String, b, Unit> r36 = this.a;
        Intrinsics.checkNotNull(r35);
        r36.invoke(r35, r15);
        goto L20
    }

    public void f(ReplyBlock.a r12, y6b.c r13, y6b.c r14) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r13, "replyMessageVO");
        Intrinsics.checkNotNullParameter(r14, "item");
        LKUIRoundableLayout r0 = r12.g;
        boolean r1 = r14.i;
        int r2 = p3b.a.W;
        if (r1 == false) goto L5;
        int r3 = v4b.a.h;
    L6:
        r0.setBorderColor(r3);
        ViewGroup.LayoutParams r4 = r12.f.getLayoutParams();
        int r5 = r4.width;
        if (r5 <= 0) goto L11;
        int r6 = r4.height;
        if (r6 <= 0) goto L11;
        int r7 = Math.min(r5, r6);
    L13:
        if (r4.width == r7) goto L15;
    L16:
        r4.width = r7;
        r4.height = r7;
        r12.f.setLayoutParams(r4);
    L17:
        ValidateResult r8 = MessagePermissionUtil.b();
        boolean r9 = MessagePermissionUtil.f(r13, e().getChat(), r8);
        ValidateIMFileResult r10 = r13.F;
        if (r10 == null) goto L20;
        IMFileResult r11 = r10.getResultType();
    L21:
        MessagePermissionUtil.ReceiveAuthorizationState r15 = MessagePermissionUtil.h(r11);
        r12.f.setOnClickListener(new e(r13, this, r15, r9, r8, r12));
        r12.f.setOnLongClickListener(new f(this, r12, r14));
        ResourceCleanScene r16 = lpc.a.b(r13);
        if (r16 == null) goto L26;
        boolean r17 = true;
        if (r16.isCSAMDelete() != true) goto L26;
    L27:
        if (r17 == false) goto L29;
        g(r12);
        return;
    L29:
        if (r9 == true) goto L31;
    L33:
        g(r12);
        return;
    L31:
        if (MessagePermissionUtil.g(r15) == true) goto L33;
        FragmentActivity r18 = e().getContext();
        ImageView r19 = r12.f;
        T r110 = r13.o;
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.ImageContentVO");
        h7b.i.e(r18, r19, (ImageContentVO) r110);
        return;
    L26:
        r17 = false;
        goto L27
    L20:
        r11 = null;
        goto L21
    L15:
        if (r4.height == r7) goto L17;
    L11:
        r7 = UIHelper.dp2px(40.0f);
        goto L13
    L5:
        r3 = v4b.a.G;
        goto L6
    }
}
