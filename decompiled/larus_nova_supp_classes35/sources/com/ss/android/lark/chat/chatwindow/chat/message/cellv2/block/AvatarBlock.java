package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.larksuite.component.decoration.avatar.DecoratedAvatar;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.entity.chatter.AvatarMedal;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class AvatarBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {
    public static final /* synthetic */ int j = 0;
    public final IMMessageKeys$Blocks g;
    public final Lazy h;
    public final Lazy i;

    public static class a implements com.ss.android.lark.blueprint.k<View> {
        public final View a;
        public final DecoratedAvatar b;
        public final LarkAvatarView c;
        public String d;

        public View getView() {
            return this.a;
        }

        public a(View r2, DecoratedAvatar r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "decoratedAvatar");
            this.a = r2;
            this.b = r3;
            LarkAvatarView r4 = r3.getAvatarView();
            if ((r4 instanceof LarkAvatarView) == false) goto L5;
            LarkAvatarView r5 = r4;
        L6:
            this.c = r5;
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class b {
        /* JADX WARN: Type inference failed for: r0v1, types: [v5b.a] */
        public static y6b.b a(y6b.a r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            T r0 = r2.b().a;
            if ((r0 instanceof SystemContent) == false) goto L7;
            ChatChatter r1 = ((SystemContent) r0).getFromChatter();
            if (r1 == null) goto L7;
            y6b.b r3 = u2b.d.a(r1);
        L8:
            if (r3 == null) goto L10;
            return r3;
        L10:
            return r2.a();
        L7:
            r3 = null;
            goto L8
        }
    }

    static {
    }

    public int i() {
        return 2131559290;
    }

    public void j(a r2, y6b.a<?> r3) {
        Intrinsics.checkNotNullParameter(r2, "blockView");
        Intrinsics.checkNotNullParameter(r3, "item");
    }

    public void k(a r2, y6b.a<?> r3) {
        Intrinsics.checkNotNullParameter(r2, "blockView");
        Intrinsics.checkNotNullParameter(r3, "item");
    }

    public void l(a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockView");
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public AvatarBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.AVATAR;
        LazyThreadSafetyMode r3 = LazyThreadSafetyMode.NONE;
        this.h = LazyKt.lazy(r3, AvatarBlock$loginTenantId$2.INSTANCE);
        this.i = LazyKt.lazy(r3, new AvatarBlock$avatarPlaceholder$2(this));
    }

    public a h(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        DecoratedAvatar r3 = (DecoratedAvatar) r2;
        return new a(r3, r3);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r4, com.ss.android.lark.blueprint.q<y6b.a<?>> r5) {
        Intrinsics.checkNotNullParameter(r4, "cell");
        Intrinsics.checkNotNullParameter(r5, "layout");
        com.ss.android.lark.blueprint.i.a.a(r4, r5);
        IMMessageKeys$Blocks r6 = this.g;
        IMMessageKeys$Slots r0 = IMMessageKeys$Slots.AVATAR;
        com.ss.android.lark.blueprint.k r7 = r5.f(r6, r0);
        a r2 = null;
        if ((r7 instanceof a) == false) goto L5;
        a r8 = (a) r7;
    L6:
        if (r8 != null) goto L8;
        return;
    L8:
        Rect r1 = com.larksuite.framework.ui.a.b;
        com.larksuite.framework.ui.a.a.b(r8.b);
        l(r8);
        com.ss.android.lark.blueprint.k r9 = r5.o(this.g, r0);
        if ((r9 instanceof a) == false) goto L11;
        r2 = (a) r9;
    L11:
        if (r2 == null) goto L14;
        this.a.d.b(this.g, a.class, r2);
        return;
    L14:
        return;
    L5:
        r8 = null;
        goto L6
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<?>> r9, com.ss.android.lark.blueprint.q<y6b.a<?>> r10, y6b.a<?> r11) {
        Intrinsics.checkNotNullParameter(r9, "cell");
        Intrinsics.checkNotNullParameter(r10, "layout");
        Intrinsics.checkNotNullParameter(r11, Keys.API_RETURN_KEY_DATA);
        a r12 = (a) r10.c(this.g, IMMessageKeys$Slots.AVATAR, new AvatarBlock$update$blockView$1(this));
        View r0 = r12.getView();
        String r2 = null;
        if (this.c.s8() == false) goto L13;
        com.ss.android.lark.biz.im.api.message.params.q r1 = this.c.d0(com.ss.android.lark.biz.im.api.message.params.q.class);
        if (r1 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == true) goto L13;
    L26:
        int r4 = 4;
    L27:
        r0.setVisibility(r4);
        ViewGroup.LayoutParams r5 = r12.b.getLayoutParams();
        v4b.c r6 = this.f;
        int r7 = this.c.H8().a();
        if (r6 != null) goto L30;
    L34:
        int r8 = zz7.b.g(getContext(), r7);
        r5.width = r8;
        r5.height = r8;
        ImageView r13 = r12.b.a;
        if (r13 == null) goto L37;
        r13.setImageDrawable(null);
    L37:
        y6b.b r14 = b.a(r11);
        if (r14 != null) goto L44;
        r12.d = null;
        LarkAvatarView r15 = r12.c;
        if (r15 == null) goto L42;
        r15.setImageResource(0);
    L42:
        Rect r16 = com.larksuite.framework.ui.a.b;
        com.larksuite.framework.ui.a.a.b(r12.b);
        k(r12, r11);
        return;
    L44:
        if (r14.q == true) goto L57;
        if (Intrinsics.areEqual((String) this.h.getValue(), r14.w) == false) goto L57;
        AvatarMedal r17 = r14.z;
        if (r17 == null) goto L51;
        r2 = r17.getKey();
    L51:
        if (TextUtils.isEmpty(r2) == true) goto L57;
        if (r17 == null) goto L57;
        if (r17.getShowSwitch() == false) goto L57;
        r12.b.b(r2);
    L57:
        if (this.c.r() == false) goto L59;
        Scene r18 = Scene.Thread;
    L60:
        uz7.a.a r19 = new uz7.a.a();
        r19.k = r14.a;
        r19.b(r14.k);
        r19.f(r14.a);
        r19.a(true);
        r19.h(AvatarModel.Size.SMALL);
        r19.c(Biz.Messenger);
        r19.g(r18);
        uz7.a r20 = new uz7.a(r19);
        StringBuilder r21 = new StringBuilder();
        r21.append(r14.a);
        r21.append('|');
        String r22 = r14.k;
        if (r22 != null) goto L63;
        r22 = BuildConfig.FLAVOR;
    L63:
        r21.append(r22);
        r21.append('|');
        r21.append(r18.name());
        r21.append("|SMALL");
        String r23 = r21.toString();
        LarkAvatarView r24 = r12.c;
        if (r24 != null) goto L66;
    L69:
        Rect r25 = com.larksuite.framework.ui.a.b;
        com.larksuite.framework.ui.a.a.a(r12.b, UIUtils.dp2px(getContext(), 4.0f));
        j(r12, r11);
        r12.b.setOnClickListener(new h(this, r9, r11, r14, r12));
        r12.b.setOnLongClickListener(new i(r12, this, r9, r11, r14));
        return;
    L66:
        if (Intrinsics.areEqual(r12.d, r23) == true) goto L68;
        r24.setImageDrawable((GradientDrawable) this.i.getValue());
        r12.d = r23;
    L68:
        r24.j(r20);
        goto L69
    L59:
        r18 = Scene.Chat;
        goto L60
    L30:
        if (r6.b < 0.0f) goto L34;
        int r26 = r6.c;
        if (r26 <= 0) goto L34;
        r7 = r26;
        goto L34
    L7:
        if (r1.a != true) goto L9;
        r3 = true;
    L13:
        if ((r11 instanceof y6b.c) == false) goto L15;
        y6b.c r27 = (y6b.c) r11;
    L16:
        if (r27 != null) goto L18;
    L20:
        boolean r28 = false;
    L21:
        if (r28 == true) goto L24;
    L25:
        r4 = 0;
        goto L27
    L24:
        if (this.c.m() == false) goto L26;
    L18:
        if (r27.Q2 != true) goto L20;
        r28 = true;
        goto L21
    L15:
        r27 = null;
        goto L16
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, com.ss.android.lark.blueprint.q<y6b.a<?>> r2, y6b.a<?> r3) {
        update2(r1, r2, r3);
    }
}
