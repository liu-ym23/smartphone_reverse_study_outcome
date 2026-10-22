package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterCustomStatus;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.chat.entity.chatter.TagInfo;
import com.ss.android.lark.chat.entity.chatter.UserPrivateDescription;
import com.ss.android.lark.chat.entity.chatter.WorkStatus;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.UserStatusParseUrlPreViewUtils;
import com.ss.android.lark.chat.utils.o1;
import com.ss.android.lark.chat.vo.SenderStatusDisplayHelper;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams;
import com.ss.android.lark.time.format.entity.DisplayPattern;
import com.ss.android.lark.time.format.entity.LengthType;
import com.ss.android.lark.time.format.entity.TimePreciseness;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import com.suite.lark.platform.component.widget_biz_userstatus.UserStatusLinearLayout;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class UsernameBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.c<?>, com.ss.android.lark.biz.im.api.message.params.c0> implements e6b.a {
    public static final e6b.c q = null;
    public static final e6b.c r = null;
    public static final e6b.c s = null;
    public final IMMessageKeys$Blocks g;
    public final IMMessageKeys$Slots h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public boolean n;
    public boolean o;
    public final List<com.ss.android.lark.blueprint.j> p;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/message/cellv2/block/UsernameBlock$BotTagType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "NONE", "BOT", "AGENT", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BotTagType extends Enum<BotTagType> {
        public static final BotTagType AGENT = null;
        public static final BotTagType BOT = null;
        public static final BotTagType NONE = null;
        public static final /* synthetic */ BotTagType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<BotTagType> getEntries() {
            return b;
        }

        static {
            BotTagType r0 = new BotTagType("NONE", 0);
            NONE = r0;
            BotTagType r1 = new BotTagType("BOT", 1);
            BOT = r1;
            BotTagType r3 = new BotTagType("AGENT", 2);
            AGENT = r3;
            BotTagType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static BotTagType[] values() {
            return (BotTagType[]) a.clone();
        }

        public static BotTagType valueOf(String r1) {
            return (BotTagType) r27.a.a(BotTagType.class, r1);
        }

        public BotTagType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[BotTagType.values().length];
            r0[BotTagType.BOT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r0[BotTagType.AGENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[BotTagType.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            a = r0;
            int[] r1 = new int[SenderStatusDisplayHelper.Type.values().length];
            r1[SenderStatusDisplayHelper.Type.PRIVATE_DESCRIPTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r1[SenderStatusDisplayHelper.Type.PUBLIC_DESCRIPTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r1[SenderStatusDisplayHelper.Type.HIDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            b = r1;
        }
    }

    static {
        q = new e6b.c(null);
        r = new e6b.c(null);
        s = new e6b.c(null);
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public UsernameBlock(com.ss.android.lark.blueprint.g r3) {
        Intrinsics.checkNotNullParameter(r3, "ctx");
        super(r3);
        IMMessageKeys$Blocks r4 = IMMessageKeys$Blocks.USERNAME;
        this.g = r4;
        this.h = IMMessageKeys$Slots.TOP;
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        this.i = LazyKt.lazy(r0, UsernameBlock$monitorModule$2.INSTANCE);
        this.j = LazyKt.lazy(r0, UsernameBlock$phoneDependency$2.INSTANCE);
        this.k = LazyKt.lazy(r0, UsernameBlock$browserModule$2.INSTANCE);
        this.l = LazyKt.lazy(r0, UsernameBlock$settingDependency$2.INSTANCE);
        this.m = LazyKt.lazy(r0, UsernameBlock$loginDependency$2.INSTANCE);
        this.p = CollectionsKt.listOf(new com.ss.android.lark.blueprint.j[]{r4, q, r, s});
    }

    @Override // e6b.a
    public final e6b.a.C0216a e(com.ss.android.lark.blueprint.j r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        return new e6b.a.C0216a(this.p.indexOf(r3), this.p.size());
    }

    public final String h(long r13) {
        c7c.a r11 = new c7c.a(null, null, null, null, null, false, false, false, false, 2047);
        r11.b(DisplayPattern.RELATIVE);
        r11.c(LengthType.LONG);
        ChatCoreModule.a().getTimeFormatDependency().a();
        r11.h = false;
        com.ss.android.lark.biz.im.api.message.params.c0 r0 = this.c.d0(com.ss.android.lark.biz.im.api.message.params.c0.class);
        if (r0 == null) goto L6;
        TimePreciseness r1 = r0.e;
        if (r1 == null) goto L6;
    L7:
        r11.d(r1);
        r11.j = true;
        return c7c.b.c(UIHelper.getContext(), new Date(r13), r11);
    L6:
        r1 = TimePreciseness.SECOND;
        goto L7
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public final void a(com.ss.android.lark.blueprint.m<y6b.c<?>> r2, com.ss.android.lark.blueprint.q<y6b.c<?>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        com.ss.android.lark.blueprint.i.a.a(r2, r3);
        g(r3, this.g, this.h);
        g(r3, q, this.h);
        g(r3, r, this.h);
        g(r3, s, this.h);
    }

    public void j(com.ss.android.lark.blueprint.q<y6b.c<?>> r10, y6b.c<?> r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "layout");
        Intrinsics.checkNotNullParameter(r11, Keys.API_RETURN_KEY_DATA);
        TextView r13 = (TextView) r10.c(this.g, this.h, new UsernameBlock$renderUsername$nameTv$1(this)).getView();
        com.ss.android.lark.biz.im.api.message.params.c0 r0 = this.c.d0(com.ss.android.lark.biz.im.api.message.params.c0.class);
        if (r0 == null) goto L6;
        r13.setPadding(UIUtils.dp2px(getContext(), r0.b), r13.getPaddingTop(), r13.getPaddingRight(), r13.getPaddingBottom());
    L6:
        if (r12 == false) goto L13;
        if (r0 == null) goto L11;
        Integer r14 = r0.a;
        if (r14 == null) goto L11;
        int r15 = r14.intValue();
    L12:
        r13.setTextColor(UDColorUtils.getColor(getContext(), r15));
        i3b.c.b(r13, this.a, 14.0f);
        r13.getPaint().setFakeBoldText(true);
    L19:
        int r16 = AvatarBlock.j;
        y6b.b r17 = AvatarBlock.b.a(r11);
        if (r17 != null) goto L22;
        r13.setText(getContext().getString(2131892298));
        r13.setTextColor(UIUtils.getColor(getContext(), 2131106620));
    L30:
        y6b.b r18 = r11.t;
        T r1 = r11.o.a;
        if ((r1 instanceof SystemContent) == false) goto L35;
        ChatChatter r2 = ((SystemContent) r1).getFromChatter();
        if (r2 == null) goto L35;
        y6b.b r3 = u2b.d.a(r2);
    L36:
        if (r3 != null) goto L38;
        r3 = r11.t;
    L38:
        Chat r19 = this.c.getChat();
        if (r19 == null) goto L44;
        if (Chat.Type.GROUP == r19.getType()) goto L44;
        BotTagType r110 = BotTagType.NONE;
    L73:
        v4b.c r4 = this.f;
        if (r4 != null) goto L76;
    L78:
        boolean r5 = false;
    L79:
        if (r5 == false) goto L81;
    L86:
        boolean r6 = false;
    L87:
        if (r5 == false) goto L89;
    L94:
        boolean r7 = false;
    L95:
        if (r5 == true) goto L102;
        if (r18 == null) goto L102;
        if (r18.q == true) goto L102;
        if (r18.m == false) goto L102;
        boolean r8 = true;
    L103:
        if (r5 == true) goto L116;
        if (r18 == null) goto L106;
        List<TagInfo> r9 = r18.y;
    L107:
        List<TagInfo> r20 = r9;
        if (r20 != null) goto L110;
    L113:
        boolean r21 = true;
    L114:
        if (r21 == true) goto L116;
        boolean r22 = true;
    L117:
        if (r5 == false) goto L119;
    L126:
        boolean r23 = false;
    L128:
        if (r110 != BotTagType.NONE) goto L135;
        if (r6 == true) goto L135;
        if (r7 == true) goto L135;
        if (r8 == true) goto L135;
        if (r22 == true) goto L135;
        if (r23 == true) goto L135;
        r13.setCompoundDrawables(null, null, null, null);
        return;
    L135:
        int r24 = LarkNameTag.d;
        Context r25 = getContext();
        Intrinsics.checkNotNullParameter(r25, "context");
        LarkNameTag.e r26 = new LarkNameTag.e(r25);
        r26.c(((LarkNameTag.c) r26).b.v, r23);
        r26.c(((LarkNameTag.c) r26).b.j, r6);
        int r111 = b.a[r110.ordinal()];
        if (r111 == 1) goto L144;
        if (r111 != 2) goto L139;
        r26.e(((LarkNameTag.c) r26).b.b, true);
    L145:
        if (r7 == false) goto L148;
        if (r18 == null) goto L148;
        int r112 = com.larksuite.component.ui.tag.f.g;
        com.larksuite.component.ui.tag.f.a r113 = new com.larksuite.component.ui.tag.f.a();
        r113.d = r18.l.getDisplayTextNoDuration(getContext());
        r113.e = 2131102093;
        r113.g = 2131102098;
        r26.e(new com.larksuite.component.ui.tag.f(r113), true);
    L148:
        if (r8 == false) goto L150;
        r26.e(((LarkNameTag.c) r26).b.k, true);
    L150:
        if (r18 == null) goto L152;
        TagInfo.a r114 = TagInfo.Companion;
        List<TagInfo> r115 = r18.y;
        List r27 = CollectionsKt.listOf(new com.ss.android.lark.chat.entity.chatter.b[]{com.ss.android.lark.chat.entity.chatter.c.a, com.ss.android.lark.chat.entity.chatter.c.b});
        r114.getClass();
        TagInfo.a.a(r26, r115, r27);
    L152:
        ((LarkNameTag.c) r26).g = zz7.b.h(getContext(), 12);
        ((LarkNameTag.c) r26).h = zz7.b.g(getContext(), 12);
        r26.f().c(r13);
        return;
    L139:
        if (r111 != 3) goto L142;
        r26.e(((LarkNameTag.c) r26).b.a, false);
        r26.e(((LarkNameTag.c) r26).b.b, false);
        goto L145
    L142:
        throw new NoWhenBranchMatchedException();
    L144:
        r26.e(((LarkNameTag.c) r26).b.a, true);
        goto L145
    L119:
        if (this.c.isGroup() == false) goto L126;
        if (r18 == null) goto L126;
        if (Intrinsics.areEqual(((w4b.u) this.m.getValue()).getUserId(), r18.a) == true) goto L126;
        if (r18.A == false) goto L126;
        r23 = true;
        goto L128
    L110:
        if (r20.isEmpty() == true) goto L113;
        r21 = false;
        goto L114
    L106:
        r9 = null;
    L116:
        r22 = false;
    L102:
        r8 = false;
        goto L103
    L89:
        if (this.c.isGroup() == false) goto L94;
        if (r18 == null) goto L94;
        if (WorkStatus.isInvalid(r18.l) == true) goto L94;
        r7 = true;
        goto L95
    L81:
        if (this.c.isGroup() == false) goto L86;
        if (r18 == null) goto L86;
        if (((w4b.d0) this.l.getValue()).isInZenMode(r18.n) == false) goto L86;
        r6 = true;
        goto L87
    L76:
        if (r4.f != true) goto L78;
        r5 = true;
    L44:
        if (r3 != null) goto L46;
    L55:
        boolean r28 = false;
    L56:
        if (r28 == false) goto L58;
        r110 = BotTagType.AGENT;
        goto L73
    L58:
        if (r3 != null) goto L60;
    L69:
        boolean r116 = false;
    L70:
        if (r116 == false) goto L72;
        r110 = BotTagType.BOT;
        goto L73
    L72:
        r110 = BotTagType.NONE;
        goto L73
    L60:
        if (r3.j == Chatter.ChatterType.BOT) goto L62;
    L66:
        boolean r117 = false;
    L67:
        if (r117 != true) goto L69;
        r116 = true;
        goto L70
    L62:
        if (Chatter.BOT_TAG.equals(r3.s) == false) goto L66;
        if (r3.t == true) goto L66;
        r117 = true;
        goto L67
    L46:
        if (r3.j == Chatter.ChatterType.BOT) goto L48;
    L52:
        boolean r29 = false;
    L53:
        if (r29 != true) goto L55;
        r28 = true;
        goto L56
    L48:
        if (Chatter.BOT_TAG.equals(r3.s) == false) goto L52;
        if (r3.t == false) goto L52;
        r29 = true;
    L35:
        r3 = null;
        goto L36
    L22:
        r13.setText(r17.i);
        if (this.o == false) goto L30;
        if ((!h18.f.a(getContext())) == true) goto L27;
        r13.setTextColor(com.ss.android.lark.chat.utils.p.e(getContext()));
        goto L30
    L27:
        if (this.n == false) goto L30;
        r13.setTextColor(com.ss.android.lark.chat.utils.p.b(getContext()));
    L11:
        r15 = 2131106622;
        goto L12
    L13:
        if (r0 == null) goto L17;
        Integer r118 = r0.a;
        if (r118 == null) goto L17;
        int r119 = r118.intValue();
    L18:
        r13.setTextColor(UDColorUtils.getColor(getContext(), r119));
        i3b.c.b(r13, this.a, 12.0f);
        r13.getPaint().setFakeBoldText(false);
    L17:
        r119 = 2131106620;
        goto L18
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.c<?>> r16, com.ss.android.lark.blueprint.q<y6b.c<?>> r17, y6b.c<?> r18) {
        Intrinsics.checkNotNullParameter(r16, "cell");
        Intrinsics.checkNotNullParameter(r17, "layout");
        Intrinsics.checkNotNullParameter(r18, Keys.API_RETURN_KEY_DATA);
        Chat r0 = this.c.getChat();
        if (r0 != null) goto L5;
        return;
    L5:
        com.ss.android.lark.biz.im.api.message.params.c0 r1 = this.c.d0(com.ss.android.lark.biz.im.api.message.params.c0.class);
        boolean r9 = true;
        if (r18.k1 == false) goto L14;
        if (r1 != null) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == true) goto L14;
        return;
    L9:
        if (r1.f == true) goto L11;
        r2 = true;
    L14:
        ChatThemeInfo r3 = this.c.r8();
        if (r3 != null) goto L17;
        this.o = false;
    L21:
        v4b.c r4 = this.f;
        if (r4 == null) goto L24;
        boolean r11 = r4.e;
    L26:
        if (r18.Q2 == false) goto L29;
        if (r11 == true) goto L29;
    L31:
        if (this.c.m() == false) goto L33;
    L36:
        if (r1 == null) goto L42;
        Function1 r5 = r1.c;
        if (r5 == null) goto L42;
        if (((Boolean) r5.invoke(Boolean.valueOf(r18.Q2))).booleanValue() == true) goto L42;
        boolean r6 = true;
    L43:
        if (r6 == true) goto L45;
        boolean r7 = true;
    L46:
        e6b.c r8 = r;
        e6b.c r10 = q;
        e6b.c r12 = s;
        if (r7 == true) goto L49;
        g(r17, this.g, this.h);
        g(r17, r10, this.h);
        g(r17, r8, this.h);
        g(r17, r12, this.h);
        return;
    L49:
        j(r17, r18, r11);
        v4b.c r13 = this.f;
        if (r13 != null) goto L52;
    L54:
        boolean r14 = false;
    L55:
        String r15 = null;
        if (r14 == false) goto L58;
        g(r17, r10, this.h);
    L78:
        v4b.c r19 = this.f;
        if (r19 != null) goto L81;
    L83:
        boolean r20 = false;
    L84:
        if (r20 == false) goto L86;
        g(r17, r8, this.h);
    L161:
        if (r11 == false) goto L184;
        TextView r21 = (TextView) r17.c(r12, this.h, new UsernameBlock$renderMessageTime$messageTimeView$1(this)).getView();
        com.ss.android.lark.biz.im.api.message.params.c0 r22 = this.c.d0(com.ss.android.lark.biz.im.api.message.params.c0.class);
        StringBuilder r23 = new StringBuilder();
        MessageEditInfo r24 = r18.C;
        if (r22 != null) goto L165;
    L167:
        boolean r25 = false;
    L168:
        if (r25 == false) goto L170;
        r23.append("· ");
    L170:
        r23.append(h(r18.m * ((long) 1000)));
        if (r24 != null) goto L173;
    L183:
        r21.setText(r23);
        return;
    L173:
        if (r24.isEdited() == false) goto L183;
        if (r24.getLastEditTime() <= 0) goto L183;
        if (r22 != null) goto L178;
    L180:
        r9 = false;
    L181:
        if (r9 == true) goto L183;
        r23.append(UIHelper.mustacheFormat(2131891077, "Time", h(r24.getLastEditTime())));
        goto L183
    L178:
        if (r22.d == true) goto L180;
    L165:
        if (r22.g != true) goto L167;
        r25 = true;
        goto L168
    L184:
        g(r17, r12, this.h);
        return;
    L86:
        y6b.b r26 = r18.t;
        boolean r27 = com.ss.android.lark.chat.chatwindow.chat.v2.push.w.a(this.c).C().isEnable("im.signature.visibility.view");
        String r28 = com.ss.android.lark.chat.chatwindow.chat.v2.push.w.a(this.c).getUserId();
        SenderStatusDisplayHelper r29 = SenderStatusDisplayHelper.a;
        y6b.b r30 = r18.t;
        if (r30 == null) goto L89;
        ChatterDescription r31 = r30.o;
    L90:
        if (r27 == true) goto L92;
    L109:
        SenderStatusDisplayHelper.a.getClass();
        SenderStatusDisplayHelper.a r32 = SenderStatusDisplayHelper.a(r31);
    L110:
        UserStatusLinearLayout r33 = (UserStatusLinearLayout) r17.c(r8, this.h, new UsernameBlock$renderUserStatus$userStatusView$1(this)).getView();
        r33.setVisibility(0);
        if (this.o == true) goto L113;
        r33.setUrlOrPhoneColor(com.ss.android.lark.chat.utils.p.d(getContext()));
    L119:
        int r34 = b.b[r32.getType().ordinal()];
        if (r34 != 1) goto L122;
        if (r26 != null) goto L149;
        g(r17, r8, this.h);
        goto L161
    L149:
        UserPrivateDescription r35 = r32.b;
        if (r35 == null) goto L152;
        r15 = r35.getContent();
    L152:
        if (r15 != null) goto L154;
    L157:
        boolean r36 = true;
    L158:
        if (r36 == false) goto L160;
        r33.setVisibility(8);
        goto L161
    L160:
        Context r37 = getContext();
        hpc.b r38 = hpc.b.b();
        ChatterDescription.Type.DEFAULT.getNumber();
        r38.getClass();
        i(r33, r26.a, r15, UDIconUtils.getIconDrawable(r37, 2131238071), r35.getDescriptionId());
        goto L161
    L154:
        if (r15.length() == 0) goto L157;
        r36 = false;
        goto L158
    L122:
        if (r34 != 2) goto L124;
        ChatterDescription r39 = r32.c;
        if (r26 == null) goto L146;
        if (r39 == null) goto L146;
        w4b.d0 r40 = h7b.l.a;
        String r41 = r39.description;
        if (r41 != null) goto L134;
    L137:
        boolean r42 = true;
    L138:
        if (r42 == true) goto L140;
    L142:
        boolean r43 = false;
    L143:
        if (r43 == true) goto L146;
        r33.setVisibility(0);
        r33.setTextColor(UIUtils.getColor(getContext(), 2131106620));
        Context r44 = getContext();
        hpc.b r45 = hpc.b.b();
        r39.type.getNumber();
        r45.getClass();
        i(r33, r26.a, r39.description, UDIconUtils.getIconDrawable(r44, 2131238071), null);
        goto L161
    L140:
        if (r39.type != ChatterDescription.Type.DEFAULT) goto L142;
        r43 = true;
        goto L143
    L134:
        if (TextUtils.isEmpty(r41.trim()) == true) goto L137;
        r42 = false;
    L146:
        g(r17, r8, this.h);
        goto L161
    L124:
        if (r34 != 3) goto L127;
        g(r17, r8, this.h);
        goto L161
    L127:
        throw new NoWhenBranchMatchedException();
    L113:
        if ((!h18.f.a(getContext())) == true) goto L115;
    L117:
        r33.setTextColor(com.ss.android.lark.chat.utils.p.e(getContext()));
        r33.setUrlOrPhoneColor(com.ss.android.lark.chat.utils.p.d(getContext()));
        r33.setDividerDrawableColor(2131103353);
        goto L119
    L115:
        if (this.n == false) goto L117;
        r33.setTextColor(com.ss.android.lark.chat.utils.p.b(getContext()));
        Context r46 = getContext();
        Intrinsics.checkNotNullParameter(r46, "context");
        r33.setUrlOrPhoneColor(UIUtils.getColor(r46, 2131106617));
        r33.setDividerDrawableColor(2131101327);
        goto L119
    L92:
        if (TextUtils.equals(r28, r18.g) == true) goto L109;
        y6b.b r47 = r18.t;
        if (r47 == null) goto L97;
        UserPrivateDescription r48 = r47.p;
    L98:
        if (r48 != null) goto L100;
    L108:
        SenderStatusDisplayHelper.a.getClass();
        r32 = SenderStatusDisplayHelper.a(r31);
        goto L110
    L100:
        if (r48.isClearMarker() == false) goto L102;
    L107:
        SenderStatusDisplayHelper.a.getClass();
        r32 = SenderStatusDisplayHelper.a(r31);
        goto L110
    L102:
        if (r48.isFailedMarker() == true) goto L107;
        if (r48.hasContent() == false) goto L108;
        int r49 = SenderStatusDisplayHelper.a.d;
        Intrinsics.checkNotNullParameter(r48, "privateDescription");
        r32 = new SenderStatusDisplayHelper.a(SenderStatusDisplayHelper.Type.PRIVATE_DESCRIPTION, r48, null);
        goto L110
    L97:
        r48 = null;
        goto L98
    L89:
        r31 = null;
        goto L90
    L81:
        if (r19.j != true) goto L83;
        r20 = true;
        goto L84
    L58:
        y6b.b r50 = r18.t;
        if (r50 != null) goto L61;
        g(r17, r10, this.h);
        goto L78
    L61:
        ChatterCustomStatus r51 = r50.B;
        if (r51 != null) goto L64;
        List r52 = null;
    L65:
        List r53 = r52;
        if (r53 != null) goto L68;
    L71:
        boolean r54 = true;
    L72:
        if (r54 == false) goto L74;
        g(r17, r10, this.h);
        goto L78
    L74:
        w4b.c r55 = ChatCoreModule.a();
        Context r56 = getContext();
        ChatterCustomStatus.Companion.getClass();
        Drawable r57 = r55.getOpenedUserStatusSmallDrawable(r56, ChatterCustomStatus.a.c(r52), true);
        if (r57 != null) goto L77;
        g(r17, r10, this.h);
        goto L78
    L77:
        AppCompatImageView r58 = r17.c(r10, this.h, new UsernameBlock$renderStatusIcon$statusIconView$1(this)).getView();
        r58.setVisibility(0);
        r58.setImageDrawable(r57);
        goto L78
    L68:
        if (r53.isEmpty() == true) goto L71;
        r54 = false;
        goto L72
    L64:
        r52 = CollectionsKt.listOf(r51);
        goto L65
    L52:
        if (r13.j != true) goto L54;
        r14 = true;
    L45:
        r7 = false;
    L42:
        r6 = false;
        goto L43
    L33:
        if (this.c.Y() == true) goto L36;
        if (this.c.e0() == false) goto L45;
    L29:
        if (r0.getType() == Chat.Type.GROUP) goto L36;
    L24:
        r11 = false;
        goto L26
    L17:
        if (com.ss.android.lark.chat.utils.p.g(r3.getComponentScene()) == true) goto L19;
        this.o = false;
        goto L21
    L19:
        this.o = true;
        this.n = com.ss.android.lark.chat.utils.p.f(r3.getComponentScene());
        goto L21
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.c<?>> r1, com.ss.android.lark.blueprint.q<y6b.c<?>> r2, y6b.c<?> r3) {
        update2(r1, r2, r3);
    }

    public final void i(UserStatusLinearLayout r10, String r11, String r12, Drawable r13, Long r14) {
        r10.setVisibility(0);
        r10.setTextColor(UIUtils.getColor(getContext(), 2131106620));
        int r0 = UserStatusParseUrlPreViewUtils.a;
        String r1 = k6b.c.a(r11, r12, r14);
        com.ss.android.lark.widget.span.f0 r2 = com.ss.android.lark.widget.span.f0.a.a;
        if (r2.a(r1) == null) goto L5;
        r10.b(r12, r11, r13, true, ChatHitPointExtraParams.UrlAnalysisScene.CHAT_STATUS.getValue(), r14);
    L8:
        r10.setOnURLClickListener(new a1(this));
        r10.setOnPhoneClickListener(new b1(this));
        return;
    L5:
        ConcurrentHashMap<Integer, Long> r3 = o1.a;
        o1.d(r11, Long.valueOf(System.currentTimeMillis()));
        RecogniseSpansResult r4 = r2.a(r12);
        r10.a.setImageDrawable(r13);
        r10.b.G(r12, r4);
        r10.c = r12;
        b3b.f r15 = this.d;
        if (r15 == null) goto L8;
        r15.w(r12, r11, r14);
        goto L8
    }
}
