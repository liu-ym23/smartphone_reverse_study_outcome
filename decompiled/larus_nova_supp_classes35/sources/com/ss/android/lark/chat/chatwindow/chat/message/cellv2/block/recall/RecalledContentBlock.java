package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.recall;

import android.R;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import b3b.f;
import com.ss.android.lark.biz.im.api.message.params.u;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.base.view.vo.ThreadMessageVO;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.chat.base.view.vo.message.e;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.coremd.utils.MessageStyleHelper;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.o;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;
import com.ss.android.lark.widget.richtext.i;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import w4b.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class RecalledContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<v5b.a<?>>, Object> {
    public final IMMessageKeys$Blocks g;
    public final Lazy h;

    public static final class a {
    }

    public static final class b implements k<View> {
        public final View a;
        public final LinkEmojiTextView b;
        public final TextView c;
        public final AppCompatImageView d;

        public final View getView() {
            return this.a;
        }

        public b(View r4) {
            Intrinsics.checkNotNullParameter(r4, "view");
            this.a = r4;
            LinkEmojiTextView r0 = r4.findViewById(2131383850);
            this.b = r0;
            TextView r1 = (TextView) r4.findViewById(2131383847);
            this.c = r1;
            AppCompatImageView r5 = r4.findViewById(2131383848);
            this.d = r5;
            zz7.a.c(r0, 17);
            zz7.a.c(r1, 17);
            zz7.a.a(r5, 16);
        }
    }

    static {
    }

    public final j getKey() {
        return this.g;
    }

    public RecalledContentBlock(g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.RECALLED_CONTENT;
        this.h = LazyKt.lazy(LazyThreadSafetyMode.NONE, RecalledContentBlock$ntpService$2.INSTANCE);
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(m<y6b.a<v5b.a<?>>> r8, q<y6b.a<v5b.a<?>>> r9, y6b.a<v5b.a<?>> r10) {
        Intrinsics.checkNotNullParameter(r8, "cell");
        Intrinsics.checkNotNullParameter(r9, "layout");
        Intrinsics.checkNotNullParameter(r10, Keys.API_RETURN_KEY_DATA);
        b r11 = (b) r9.c(this.g, IMMessageKeys$Slots.CONTENT, RecalledContentBlock$update$blockView$1.INSTANCE);
        boolean r12 = MessageStyleHelper.b(r10);
        int r0 = p3b.a.W;
        if (r12 == false) goto L5;
        int r13 = v4b.a.e;
    L6:
        r11.b.setTextColor(r13);
        LinkEmojiTextView r14 = r11.b;
        boolean r1 = MessageStyleHelper.b(r10);
        Context r2 = r14.getContext();
        if (r1 == false) goto L9;
        int r3 = v4b.a.k;
    L10:
        if (r1 == false) goto L12;
        int r4 = v4b.a.j;
    L13:
        if (r1 == false) goto L15;
        int r5 = v4b.a.j;
    L16:
        int r6 = v2c.a.b(r2, 2131105554);
        int r7 = v2c.a.b(r2, 2131102465);
        r14.setAtTextColor(2131102465);
        r14.setAtSelfTextColor(2131106521);
        r14.setAtSelfBgColor(2131105548);
        r14.setAtOtherChatUserTextColor(r3);
        r14.setUrlTextColor(r4);
        r14.setPhoneTextColor(r5);
        r14.setHighlightColor(r6);
        r14.setDefaultAtUserColor(r7);
        if (r1 == false) goto L19;
        int r15 = v4b.a.l;
    L20:
        r14.setDotReadColor(r15);
        if (r1 == false) goto L23;
        int r16 = v4b.a.m;
    L24:
        r14.setDotUnreadColor(r16);
        r14.setIsUrlShowUnderLine(false);
        if (MessageStyleHelper.b(r10) == false) goto L27;
        int r17 = v4b.a.j;
    L28:
        r11.c.getPaint().setFlags(r11.c.getPaint().getFlags() & (-9));
        boolean r18 = true;
        r11.c.getPaint().setAntiAlias(true);
        r11.c.setTextColor(r17);
        TextView r19 = r11.c;
        boolean r20 = MessageStyleHelper.b(r10);
        StateListDrawable r21 = new StateListDrawable();
        ColorDrawable r22 = new ColorDrawable();
        if (r20 == false) goto L31;
        int r23 = v4b.a.n;
    L32:
        r22.setColor(r23);
        ColorDrawable r24 = new ColorDrawable();
        r24.setColor(UIHelper.getColor(2131103546));
        r21.addState(new int[]{R.attr.state_pressed}, r22);
        r21.addState(new int[]{-16842919}, r24);
        r19.setBackground(r21);
        v5b.a<?> r25 = r10.b();
        y6b.b r26 = r10.D();
        if (r10.H() == false) goto L38;
        if ((r25 instanceof e) == false) goto L38;
        String r27 = i.g(((e) r25).g(), false);
    L61:
        r11.b.T(null, r27, false);
        r11.b.setAtStringClickListner(new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.recall.a(this, r10));
        f r28 = this.d;
        u r29 = this.c.d0(u.class);
        if (r29 == null) goto L64;
        boolean r30 = r29.a;
    L66:
        if (r10.R() == true) goto L68;
    L74:
        r11.c.setVisibility(8);
        r11.d.setVisibility(8);
        r11.c.setOnClickListener(null);
    L76:
        if (r10.P() == true) goto L78;
        return;
    L78:
        if (this.c.m() == false) goto L82;
        if (TextUtils.isEmpty(r10.F()) == false) goto L82;
    L87:
        if (r18 == false) goto L91;
        r11.b.setVisibility(0);
        r11.b.setText(2131891925);
        return;
    L91:
        return;
    L82:
        if (this.c.Y() == true) goto L87;
        if (this.c.m() == false) goto L87;
        r18 = false;
        goto L87
    L68:
        if (r10.h() == false) goto L74;
        if (r10.D() != null) goto L74;
        if (r28 == null) goto L74;
        if (r30 == false) goto L74;
        r11.c.setVisibility(0);
        r11.d.setVisibility(0);
        r11.c.setText(UIHelper.getString(2131892126));
        r11.c.setOnClickListener(new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.recall.b(r25, r28, r10));
        goto L76
    L64:
        r30 = true;
    L38:
        if (r10.U() == false) goto L43;
        if (r10.V(((d0) this.h.getValue()).a()) == false) goto L43;
        r27 = UIHelper.getString(2131891912);
    L43:
        if (Message.RecallerIdentity.ENTERPRISE_ADMINISTRATOR != r10.E()) goto L45;
        r27 = UIHelper.getString(2131891218);
        Log.i("RecalledContentBlock", "recallMessage by enterprise_administrator");
        goto L61
    L45:
        if (r26 == null) goto L56;
        String r31 = o.a(r26.a, r26.b);
        if ((r10 instanceof y6b.c) == true) goto L51;
        if ((r10 instanceof ThreadMessageVO) == true) goto L51;
    L53:
        r27 = UIHelper.mustacheFormat(2131891916, "recaller", r31);
    L54:
        Intrinsics.checkNotNull(r27);
        Log.i("RecalledContentBlock", "recallMessage by recaller");
    L51:
        if (r10.S() == false) goto L53;
        r27 = UIHelper.mustacheFormat(2131891787, "GroupAdministrator", r31);
        goto L54
    L56:
        if ((r25 instanceof AudioContentVO) == true) goto L58;
    L60:
        r27 = UIHelper.getString(2131891918);
        Log.i("RecalledContentBlock", "recallMessage by myself");
        goto L61
    L58:
        if (r10.j() == true) goto L60;
        r27 = UIHelper.getString(2131892383);
        goto L61
    L31:
        r23 = v4b.a.M;
        goto L32
    L27:
        r17 = v4b.a.I;
        goto L28
    L23:
        r16 = v4b.a.L;
        goto L24
    L19:
        r15 = v4b.a.K;
        goto L20
    L15:
        r5 = v4b.a.I;
        goto L16
    L12:
        r4 = v4b.a.I;
        goto L13
    L9:
        r3 = v4b.a.J;
        goto L10
    L5:
        r13 = v4b.a.D;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(m<y6b.a<v5b.a<?>>> r1, q<y6b.a<v5b.a<?>>> r2, y6b.a<v5b.a<?>> r3) {
        update2(r1, r2, r3);
    }
}
