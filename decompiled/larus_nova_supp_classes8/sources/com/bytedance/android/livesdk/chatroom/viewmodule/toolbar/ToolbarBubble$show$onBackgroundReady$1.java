package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.config.gi1;
import com.bytedance.android.livesdk.config.ru0;
import com.bytedance.android.livesdk.config.uu0;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message.TextFormat;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "bgDrawable", "Landroid/graphics/drawable/Drawable;", "isSetDefaultBg", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ToolbarBubble$show$onBackgroundReady$1 extends Lambda implements Function2<Drawable, Boolean, Unit> {
    final /* synthetic */ ImageView $bubbleArrow;
    final /* synthetic */ TextView $bubbleTv;
    final /* synthetic */ w $clickCallback;
    final /* synthetic */ pp1.c $command;
    final /* synthetic */ View $contentView;
    final /* synthetic */ long $displayTime;
    final /* synthetic */ View $giftIconClickView;
    final /* synthetic */ Ref.IntRef $horizontalPadding;
    final /* synthetic */ com.bytedance.android.livesdk.popup.manager.c $livePopupCallback;
    final /* synthetic */ Ref.IntRef $verticalPadding;
    final /* synthetic */ q2 this$0;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ToolbarBubble$show$onBackgroundReady$1 a;

        public a(ToolbarBubble$show$onBackgroundReady$1 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            ToolbarBubble$show$onBackgroundReady$1 r5 = this.a;
            q2 r0 = r5.this$0;
            pp1.c r6 = r5.$command;
            q2.b(r0, r6.j, r6.i, "click");
            this.a.$clickCallback.b();
            this.a.this$0.dismiss();
        }
    }

    public static final class b implements PopupWindow.OnDismissListener {
        public final /* synthetic */ ToolbarBubble$show$onBackgroundReady$1 a;

        public b(ToolbarBubble$show$onBackgroundReady$1 r1) {
            this.a = r1;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            this.a.this$0.dismiss();
        }
    }

    public static final class c implements yo2.e.a {
        public final /* synthetic */ ToolbarBubble$show$onBackgroundReady$1 a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ c a;
            public final /* synthetic */ View b;

            public a(c r1, View r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r9) {
                ToolbarBubble$show$onBackgroundReady$1 r10 = this.a.a;
                q2 r0 = r10.this$0;
                pp1.c r11 = r10.$command;
                q2.b(r0, r11.j, r11.i, "click");
                if (this.a.c.length() <= 0) goto L5;
                boolean r12 = true;
            L6:
                if (r12 == true) goto L8;
            L26:
                ToolbarBubble$show$onBackgroundReady$1 r13 = this.a.a;
                if (r13.$command.h != 1001) goto L30;
                r13.$clickCallback.a();
            L30:
                if ((!Intrinsics.areEqual(this.b, this.a.a.$bubbleTv)) == true) goto L32;
                return;
            L32:
                if ((!Intrinsics.areEqual(this.b, this.a.a.$giftIconClickView)) == false) goto L36;
                this.a.a.this$0.dismiss();
                return;
            L36:
                return;
            L8:
                if (this.a.b == true) goto L26;
                com.bytedance.android.livesdk.sharedpref.e r14 = com.bytedance.android.livesdk.sharedpref.g.a;
                if (((Long) r14.getValue()).longValue() < 0) goto L23;
                String r2 = UriProtector.getQueryParameter(UriProtector.parse(this.a.c), "gift_id");
                if (r2 == null) goto L14;
                long r5 = CastLongProtector.parseLong(r2);
            L15:
                List r3 = (List) com.bytedance.android.livesdk.sharedpref.g.d.getValue();
                if (r5 == (-1)) goto L23;
                if (r3 == null) goto L23;
                if ((!r3.isEmpty()) == false) goto L23;
                if (r3.contains(Long.valueOf(r5)) == false) goto L23;
                r14.getClass();
                com.bytedance.android.livesdk.sharedpref.f.d(r14, -1L);
                y3.m(this.a.a.this$0.d).b(ToolbarButton.MORE, new pp1.j(false));
                goto L23
            L14:
                r5 = -1;
            L23:
                ILiveActionHandler r15 = jc1.k.f(ILiveActionHandler.class);
                if (r15 == null) goto L26;
                c r1 = this.a;
                r15.handle(r1.a.this$0.e, r1.c);
                goto L26
            L5:
                r12 = false;
                goto L6
            }
        }

        public c(ToolbarBubble$show$onBackgroundReady$1 r1, boolean r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a(View r1, yo2.e r2) {
            r1.setOnClickListener(new a(this, r1));
        }
    }

    public ToolbarBubble$show$onBackgroundReady$1(q2 r1, TextView r2, Ref.IntRef r3, Ref.IntRef r4, pp1.c r5, ImageView r6, View r7, w r8, View r9, long r10, com.bytedance.android.livesdk.popup.manager.c r12) {
        this.this$0 = r1;
        this.$bubbleTv = r2;
        this.$verticalPadding = r3;
        this.$horizontalPadding = r4;
        this.$command = r5;
        this.$bubbleArrow = r6;
        this.$giftIconClickView = r7;
        this.$clickCallback = r8;
        this.$contentView = r9;
        this.$displayTime = r10;
        this.$livePopupCallback = r12;
        super(2);
    }

    /* JADX WARN: Type inference failed for: r15v7, types: [com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarBubble$show$onBackgroundReady$1$4$1] */
    /* JADX WARN: Type inference failed for: r8v22, types: [com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarBubble$show$onBackgroundReady$1$4$2] */
    public final void invoke(Drawable r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r18, "bgDrawable");
        int r2 = q2.g;
        View r3 = this.this$0.f;
        Intrinsics.checkNotNullParameter(r3, "view");
        int r4 = 1;
        if (r3.getParent() != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == true) goto L11;
        this.this$0.dismiss();
        return;
    L11:
        if (r19 == false) goto L13;
        TextView r6 = this.$bubbleTv;
        int r7 = this.$verticalPadding.element;
        int r8 = this.$horizontalPadding.element;
        r6.setPadding(r7, r8, r7, r8);
        com.bytedance.android.live.core.utils.s1.H(this.$bubbleTv, r18);
    L13:
        Map<String, String> r1 = this.$command.j;
        Object r9 = null;
        if (r1 == null) goto L16;
        String r10 = r1.get("message_type");
    L18:
        if (Intrinsics.areEqual(r10, "101") == false) goto L20;
        yb2.a r11 = new yb2.a();
        r11.d = ColorProtector.parseColor("#b44100");
    L21:
        pp1.c r12 = this.$command;
        Spannable r13 = r12.a;
        if (r13 == null) goto L24;
        this.$bubbleTv.setText(r13);
    L28:
        py.k r14 = this.$command.g;
        if (r14 != null) goto L31;
    L33:
        this.$bubbleArrow.setImageDrawable(this.this$0.e.getResources().getDrawable(2131251350));
    L34:
        int r15 = this.$command.h;
        if (r15 != 2) goto L37;
        boolean r16 = true;
    L39:
        if (r15 != 3) goto L41;
        boolean r17 = true;
    L42:
        if (r16 == true) goto L44;
        if (r17 == true) goto L44;
    L45:
        pp1.c r20 = this.$command;
        String r21 = r20.d;
        if (r21 != null) goto L48;
        r21 = "";
    L48:
        q2 r110 = this.this$0;
        yo2.e r111 = new yo2.e(r110.e);
        ((yo2.d) r111).d = this.$contentView;
        ((yo2.d) r111).e = 0;
        ((yo2.d) r111).l = true;
        ((yo2.d) r111).m = this.$displayTime;
        ((yo2.d) r111).n = true;
        ((yo2.d) r111).o = r20.k;
        ((yo2.d) r111).b = this.$livePopupCallback;
        ((yo2.d) r111).k = new b(this);
        r111.x = new c(this, r17, r21);
        r111.a();
        r110.b = r111;
        yo2.e r22 = this.this$0.b;
        if (r22 == null) goto L135;
        TextView r23 = this.$bubbleTv;
        if (r23 == null) goto L53;
        int r24 = r23.getMeasuredWidth();
    L54:
        final float r112 = UIUtils.dip2Px(this.this$0.e, 8.0f);
        int[] r113 = new int[2];
        this.this$0.f.getLocationOnScreen(r113);
        int r114 = r113[0];
        final float r115 = ((com.bytedance.android.live.core.utils.s1.q(this.this$0.e).widthPixels - r112) - r114) - (this.this$0.f.getWidth() / 2);
        float r25 = r24;
        float r116 = 2;
        if (r25 <= (r115 * r116)) goto L62;
        ?? r117 = new ToolbarBubble$show$onBackgroundReady$1$4$1(r115, r112);
        r117.invoke(this.$bubbleArrow);
        if (r16 == true) goto L59;
        if (r17 == true) goto L59;
    L60:
        UIUtils.updateLayoutMargin(this.$bubbleTv, -3, -3, com.bytedance.android.live.core.utils.s1.f(8.0f), -3);
    L59:
        r117.invoke(this.$giftIconClickView);
    L62:
        if (((Boolean) uu0.a.getValue()).booleanValue() == false) goto L70;
        final float r26 = (r114 + (this.this$0.f.getMeasuredWidth() / 2)) - UIUtils.dip2Px(this.this$0.e, 8.0f);
        if (r25 <= (r116 * r26)) goto L70;
        ?? r27 = new ToolbarBubble$show$onBackgroundReady$1$4$2(r26);
        r27.invoke(this.$bubbleArrow);
        if (r16 == true) goto L68;
        if (r17 == true) goto L68;
    L69:
        UIUtils.updateLayoutMargin(this.$bubbleTv, -3, -3, com.bytedance.android.live.core.utils.s1.f(8.0f), -3);
    L68:
        r27.invoke(this.$giftIconClickView);
    L70:
        float r28 = -2.0f;
        if (r16 == true) goto L82;
        if (r17 == true) goto L82;
        RoomContext r29 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r29 == null) goto L81;
        com.bytedance.live.datacontext.i r30 = r29.isAnchor();
        if (r30 == null) goto L81;
        if (((Boolean) r30.getValue()).booleanValue() != true) goto L81;
        r28 = -4.0f;
    L81:
        r22.i(this.this$0.f, 1, 0, 0, com.bytedance.android.live.core.utils.s1.f(r28));
    L83:
        q2 r31 = this.this$0;
        int r32 = this.$command.i;
        r31.getClass();
        Map r33 = (Map) com.bytedance.android.livesdk.sharedpref.b.S2.getValue();
        RoomContext r34 = RoomContext.a.c(RoomContext.Companion, null, r14, 3);
        if (r34 == null) goto L90;
        com.bytedance.live.datacontext.m r35 = r34.getUser();
        if (r35 == null) goto L90;
        User r36 = (User) r35.getValue();
        if (r36 == null) goto L90;
        String r37 = r36.getIdStr();
    L91:
        String r38 = r37 + '&' + r32;
        long r39 = System.currentTimeMillis() / ((long) BubbleId.PadCast);
        Type r118 = new r2().getType();
        if (r33.containsKey(r38) == false) goto L111;
        Object r119 = r33.get(r38);
        if ((r119 instanceof Pair) == false) goto L97;
        r9 = r119;
    L97:
        Pair r40 = (Pair) r9;
        if (r40 != null) goto L100;
        r40 = (Pair) GsonProtectorUtils.fromJson(GsonHelper.get(), String.valueOf(r33.get(r38)), r118);
    L100:
        if (r40 == null) goto L104;
        Long r120 = (Long) r40.getFirst();
        if (r120 == null) goto L104;
        long r121 = r120.longValue();
    L105:
        if (r40 == null) goto L109;
        Integer r41 = (Integer) r40.getSecond();
        if (r41 == null) goto L109;
        int r42 = r41.intValue();
    L110:
        r31.c = r42;
    L112:
        List<? extends gi1> r43 = ru0.a.getValue();
        if (r43 != null) goto L115;
    L122:
        long r122 = -1;
    L124:
        if (r122 >= 0) goto L126;
    L129:
        r4 = 1 + r31.c;
    L130:
        r31.c = r4;
        r33.put(r38, new Pair(Long.valueOf(r39), Integer.valueOf(r31.c)));
        com.bytedance.android.livesdk.sharedpref.e r44 = com.bytedance.android.livesdk.sharedpref.b.S2;
        r44.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r44, r33);
        q2 r45 = this.this$0;
        pp1.c r46 = this.$command;
        q2.b(r45, r46.j, r46.i, "show");
        return;
    L126:
        if (r39 <= r122) goto L129;
        if (r121 < r122) goto L130;
    L115:
        if (r43.size() <= 0) goto L122;
        Iterator<? extends gi1> r47 = r43.iterator();
    L118:
        if (r47.hasNext() == false) goto L122;
        gi1 r123 = r47.next();
        if (r123.b().intValue() != r32) goto L118;
        r122 = r123.a().longValue();
    L109:
        r42 = 0;
    L104:
        r121 = -1;
        goto L105
    L111:
        r121 = -1;
    L90:
        r37 = null;
    L82:
        r22.i(this.this$0.f, 1, 0, com.bytedance.android.live.core.utils.s1.f(-2.0f), com.bytedance.android.live.core.utils.s1.f(38.0f));
        goto L83
    L53:
        r24 = 0;
        goto L54
    L135:
        return;
    L44:
        UIUtils.setViewVisibility(this.$giftIconClickView, 0);
        this.$giftIconClickView.setOnClickListener(new a(this));
        goto L45
    L41:
        r17 = false;
        goto L42
    L37:
        r16 = false;
        goto L39
    L31:
        if (r14.isValid() != true) goto L33;
        ImageUtil.loadImage(this.$bubbleArrow, this.$command.g, 0);
        goto L34
    L24:
        Text r48 = r12.c;
        if (r48 != null) goto L27;
        r48 = new Text();
        r48.setDefaultPattern(this.$command.b);
        TextFormat r49 = new TextFormat();
        StringCompanionObject r50 = StringCompanionObject.INSTANCE;
        r49.setColor(String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(this.this$0.e.getResources().getColor(2131107070))}, 1)));
        Unit r51 = Unit.INSTANCE;
        r48.setDefaultFormat(r49);
    L27:
        this.$bubbleTv.setText(sb2.a.f((a5) com.bytedance.android.live.base.model.m.b(r48, Text.class), r11).a);
        goto L28
    L20:
        r11 = null;
        goto L21
    L16:
        r10 = null;
        goto L18
    L5:
        if (r3.getApplicationWindowToken() == null) goto L7;
        r5 = true;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Drawable) r1, ((Boolean) r2).booleanValue());
        return Unit.INSTANCE;
    }
}
