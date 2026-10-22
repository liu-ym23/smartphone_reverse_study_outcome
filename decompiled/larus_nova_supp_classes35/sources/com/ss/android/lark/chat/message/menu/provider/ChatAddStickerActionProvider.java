package com.ss.android.lark.chat.message.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.base.view.vo.message.StickerContentVO;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.n;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.chat.message.menu.c;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.statistics.reaction.ReactionHitPoint;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import u2b.o;
import yya.i;
import yya.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChatAddStickerActionProvider implements m {
    public final Lazy a;
    public final Lazy b;

    public final class a implements i {
        public final yya.a a;
        public final /* synthetic */ ChatAddStickerActionProvider b;

        public final Map<String, Object> R4() {
            return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click", "add_sticker"), TuplesKt.to("target", "none")});
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

        public final d g() {
            return null;
        }

        public final void onHide() {
        }

        public final void onShow() {
        }

        public final boolean isVisible() {
            if (this.a.m().getType() == Message.Type.STICKER) goto L6;
            return false;
        L6:
            v5b.a r0 = this.a.m().b();
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.StickerContentVO");
            return !((StickerContentVO) r0).h();
        }

        public final boolean isEnable() {
            return owa.a.c().isAuthorizationPassed((ValidateResult) this.b.b.getValue());
        }

        public MessageActionType getType() {
            return MessageActionType.ADD_STICKER;
        }

        public final void d(c r2) {
            Intrinsics.checkNotNullParameter(r2, "actionControl");
        }

        public final Drawable getIcon(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this.b.getClass();
            return UDIconUtils.getIconDrawable(r3, 2131235438, UDColorUtils.getColor(r3, 2131100799));
        }

        public final String getLabel(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return UIHelper.getString(2131891500);
        }

        public final View getView(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return null;
        }

        public a(ChatAddStickerActionProvider r2, yya.a r3) {
            Intrinsics.checkNotNullParameter(r3, "actionContext");
            this.b = r2;
            this.a = r3;
        }

        public final void b(View r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            if (owa.a.c().isAuthorizationPassed((ValidateResult) this.b.b.getValue()) == true) goto L6;
            UDToast.show(LarkContext.getApplication(), 2131890928);
            return;
        L6:
            if (r3 == true) goto L8;
            return;
        L8:
            n r4 = this.a;
            if ((r4 instanceof n) == false) goto L11;
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.menu.handler.IStickerMenuHandler");
            r4.h(this.a.m().getId());
        L21:
            LarkAppContext.Companion.getClass();
            if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L25;
            ReactionHitPoint.a.getClass();
            ReactionHitPoint.c();
            return;
        L25:
            return;
        L11:
            p5b.c r5 = r4.k();
            if ((r5 instanceof MessageInfo) == false) goto L14;
            MessageInfo r6 = (MessageInfo) r5;
        L15:
            if (r6 == null) goto L21;
            StickerContent r7 = (StickerContent) r6.getMessage().getContent();
            if (r7.isPaid() == true) goto L20;
            UDToast.show(LarkContext.getApplication(), 2131890423);
            goto L21
        L20:
            Sticker r8 = o.a(r7);
            IGetDataCallback<Boolean> r9 = new ChatAddStickerActionProvider$AddStickerMessageAction$defaultAddSticker$callback$1();
            ChatCoreModule.a().getStickerDependency().n0(CollectionsKt.listOf(r8), r9);
            goto L21
        L14:
            r6 = null;
            goto L15
        }
    }

    public static final class b {
    }

    static {
    }

    public final String getTAG() {
        return "ChatAddStickerActionProvider";
    }

    public final List<PageType> b() {
        return (List) this.a.getValue();
    }

    public ChatAddStickerActionProvider() {
        this.a = LazyKt.lazy(ChatAddStickerActionProvider$supportedPageTypes$2.INSTANCE);
        this.b = LazyKt.lazy(ChatAddStickerActionProvider$validateResult$2.INSTANCE);
    }

    public final i c(yya.a r2) {
        Intrinsics.checkNotNullParameter(r2, "actionContext");
        return new a(this, r2);
    }
}
