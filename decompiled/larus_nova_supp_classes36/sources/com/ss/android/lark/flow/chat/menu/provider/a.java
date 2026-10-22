package com.ss.android.lark.flow.chat.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.y;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.biz.officesdk.im.message.menu.IDoubaoTextSelectService;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.utils.ReplyActionUtils;
import com.ss.android.lark.keyboard.plugin.tool.face.Conf$StickerSetManagerPosition;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements yya.m {

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.menu.provider.a$a, reason: collision with other inner class name */
    public static final class C0023a {
    }

    public final class b implements yya.i, y {
        public final yya.a a;
        public final Lazy b;

        public final Map<String, Object> R4() {
            return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click", "ask_doubao"), TuplesKt.to("target", "none")});
        }

        public final boolean c() {
            return false;
        }

        public final Integer e() {
            return null;
        }

        public final boolean f() {
            return false;
        }

        public final s5c.d g() {
            return null;
        }

        public final boolean isEnable() {
            return true;
        }

        public final boolean isVisible() {
            return true;
        }

        public final void onHide() {
        }

        public final void onShow() {
        }

        public final void h() {
            ggb.a r0 = (ggb.a) this.a.j(ggb.a.class);
            if (r0 == null) goto L6;
            r0.m();
            return;
        }

        public MessageActionType getType() {
            return MessageActionType.FLOW_ASK_DOUBAO;
        }

        public b(yya.a r2) {
            Intrinsics.checkNotNullParameter(r2, "actionContext");
            this.a = r2;
            this.b = LazyKt.lazy(FlowAskDoubaoActionProvider$FlowAskDoubaoAction$brandName$2.INSTANCE);
        }

        public final void d(com.ss.android.lark.chat.message.menu.c r2) {
            Intrinsics.checkNotNullParameter(r2, "actionControl");
        }

        public final Drawable getIcon(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return UDIconUtils.getIconDrawable(r3, 2131235461, UDColorUtils.getColor(r3, 2131100799));
        }

        public final String getLabel(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            if (this.a.l() != Message.Type.DOUBAO) goto L5;
            String r4 = UIUtils.getString(r3, 2131890156);
            Intrinsics.checkNotNull(r4);
            return r4;
        L5:
            ICUUtils.FormatArgsBuilder r5 = new ICUUtils.FormatArgsBuilder();
            r5.b("brandName", (String) this.b.getValue());
            List r6 = r5.a;
            String r7 = ICUUtils.icuFormat(UIHelper.getString(2131890152), r6);
            Intrinsics.checkNotNull(r7);
            return r7;
        }

        public final View getView(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return null;
        }

        public final void b(View r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "view");
            a(false, false, true);
        }

        public final void a(boolean r9, boolean r10, boolean r11) {
            yya.g r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            String r2 = r0.m().getId();
            int r3 = this.a.d.b();
            CharSequence r4 = null;
            if (this.a.l() != Message.Type.DOUBAO) goto L20;
            IDoubaoTextSelectService r1 = OfficeSDKManager.getHostUserService(((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d(), IDoubaoTextSelectService.class);
            y6b.a r5 = this.a.m();
            if ((r5 instanceof y6b.a) == false) goto L10;
            y6b.a r6 = r5;
        L11:
            if (r6 == null) goto L19;
            if (r1 == null) goto L14;
            r4 = r1.O0(r6, this.a.a);
        L14:
            if (r4 == null) goto L31;
            RichText r7 = new RichText();
            RichTextElement r8 = new RichTextElement();
            r8.setTag(RichTextElement.RichTextTag.TEXT);
            RichTextElement.TextProperty r12 = new RichTextElement.TextProperty();
            r12.setContent(r4.toString());
            r8.setProperty(r12);
            r7.getElements().getDictionary().put(Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL, r8);
            r7.getElementIds().add(Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL);
            r7.setInnerText(r4.toString());
            PartialReplyInfo r13 = new PartialReplyInfo(r7, PartialReplyInfo.PartialContentRelativePosition.UNKNOWN);
            ggb.a r14 = (ggb.a) this.a.j(ggb.a.class);
            if (r14 == null) goto L32;
            r14.q(r2, r3, r13, r9, r10, r11);
            return;
        L32:
            return;
        L31:
            return;
        L19:
            return;
        L10:
            r6 = null;
            goto L11
        L20:
            Log.i("ChatReplyActionProvider", "current select mode is partial.");
            y6b.a r15 = this.a.m();
            if ((r15 instanceof y6b.a) == false) goto L23;
            y6b.a r16 = r15;
        L24:
            Message.Type r17 = this.a.m().getType();
            if (r16 == null) goto L27;
            r4 = ReplyActionUtils.d(r16, r17);
        L27:
            ggb.a r18 = (ggb.a) this.a.j(ggb.a.class);
            if (r18 == null) goto L34;
            r18.q(r2, r3, r4, r9, r10, r11);
            return;
        L34:
            return;
        L23:
            r16 = null;
            goto L24
        }
    }

    static {
    }

    public a() {
    }

    public final List<PageType> b() {
        return CollectionsKt.listOf(new PageType[]{PageType.CHAT_WINDOW, PageType.REPLY_IN_THREAD, PageType.MERGE_FORWARD, PageType.THREAD_FORWARD, PageType.THREAD_WINDOW});
    }

    public final String getTAG() {
        return "FlowAskDoubaoActionProvider";
    }

    public final yya.i c(yya.a r2) {
        Intrinsics.checkNotNullParameter(r2, "actionContext");
        return new b(r2);
    }
}
