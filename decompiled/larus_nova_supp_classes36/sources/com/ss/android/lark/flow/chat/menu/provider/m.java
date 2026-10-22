package com.ss.android.lark.flow.chat.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.biz.officesdk.im.message.menu.IDoubaoTextSelectService;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.utils.ReplyActionUtils;
import com.ss.android.lark.keyboard.plugin.tool.face.Conf$StickerSetManagerPosition;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m implements yya.m {

    public static final class a {
    }

    public final class b implements yya.i {
        public final yya.a a;

        public final Map<String, Object> R4() {
            return null;
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

        public final void onHide() {
        }

        public final void onShow() {
        }

        public final boolean isVisible() {
            if (this.a.l() != Message.Type.DOUBAO) goto L5;
            return true;
        L5:
            return false;
        }

        public MessageActionType getType() {
            return MessageActionType.FOLLOW_UP_QUESTION;
        }

        public b(yya.a r2) {
            Intrinsics.checkNotNullParameter(r2, "actionContext");
            this.a = r2;
        }

        public final void d(com.ss.android.lark.chat.message.menu.c r2) {
            Intrinsics.checkNotNullParameter(r2, "actionControl");
        }

        public final Drawable getIcon(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return UDIconUtils.getIconDrawable(r3, 2131235461, UDColorUtils.getColor(r3, 2131100799));
        }

        public final String getLabel(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return UIUtils.getString(r2, 2131890156);
        }

        public final View getView(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return null;
        }

        public final void b(View r8, boolean r9) {
            Intrinsics.checkNotNullParameter(r8, "view");
            yya.g r10 = this.a;
            if (r10 != null) goto L5;
            return;
        L5:
            String r1 = r10.m().getId();
            int r2 = this.a.d.b();
            y6b.a r11 = this.a.m();
            if ((r11 instanceof y6b.a) == false) goto L8;
            y6b.a r12 = r11;
        L9:
            Message.Type r13 = this.a.m().getType();
            IDoubaoTextSelectService r3 = OfficeSDKManager.getHostUserService(((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d(), IDoubaoTextSelectService.class);
            if (r12 == null) goto L15;
            if (r3 == null) goto L13;
            CharSequence r4 = r3.G1(r12, this.a.a);
        L14:
            if (r4 == null) goto L15;
        L17:
            if (r13 != Message.Type.DOUBAO) goto L19;
            RichText r14 = new RichText();
            RichTextElement r15 = new RichTextElement();
            r15.setTag(RichTextElement.RichTextTag.TEXT);
            RichTextElement.TextProperty r0 = new RichTextElement.TextProperty();
            r0.setContent(r4.toString());
            r15.setProperty(r0);
            r14.getElements().getDictionary().put(Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL, r15);
            r14.getElementIds().add(Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL);
            r14.setInnerText(r4.toString());
            PartialReplyInfo r5 = new PartialReplyInfo(r14, PartialReplyInfo.PartialContentRelativePosition.UNKNOWN);
        L22:
            ggb.a r6 = (ggb.a) this.a.j(ggb.a.class);
            if (r6 == null) goto L26;
            r6.q(r1, r2, r5, false, false, true);
            return;
        L26:
            return;
        L19:
            if (r12 == null) goto L21;
            r5 = ReplyActionUtils.d(r12, r13);
            goto L22
        L21:
            r5 = null;
            goto L22
        L13:
            r4 = null;
        L15:
            r4 = "";
            goto L17
        L8:
            r12 = null;
            goto L9
        }
    }

    static {
    }

    public m() {
    }

    public final List<PageType> b() {
        return CollectionsKt.listOf(new PageType[]{PageType.CHAT_WINDOW, PageType.REPLY_IN_THREAD, PageType.MERGE_FORWARD, PageType.THREAD_FORWARD});
    }

    public final String getTAG() {
        return "FlowFollowUpQuestionActionProvider";
    }

    public final yya.i c(yya.a r2) {
        Intrinsics.checkNotNullParameter(r2, "actionContext");
        return new b(r2);
    }
}
