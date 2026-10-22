package com.ss.android.lark.chat.message.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.Image2StickerHandler;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.message.menu.c;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
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
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import yya.i;
import yya.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ImageToStickerActionProvider implements m {
    public static final /* synthetic */ int c = 0;
    public final Lazy a;
    public final Lazy b;

    public static final class a {
    }

    public final class b implements i {
        public final yya.a a;
        public final /* synthetic */ ImageToStickerActionProvider b;

        public final Map<String, Object> R4() {
            return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click", "sticker_save"), TuplesKt.to("target", "im_chat_main_view")});
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
            boolean r2 = false;
            if (this.a.l() == Message.Type.IMAGE) goto L5;
            return false;
        L5:
            ImageToStickerActionProvider r0 = this.b;
            yya.a r1 = this.a;
            int r3 = ImageToStickerActionProvider.c;
            r0.getClass();
            v5b.a r4 = r1.m().b();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.ImageContentVO");
            String r5 = (String) ((ImageContentVO) r4).j.getValue();
            if (r5 != null) goto L8;
        L9:
            r2 = true;
        L11:
            return !r2;
        L8:
            if (r5.length() != 0) goto L11;
            goto L9
        }

        public final boolean isEnable() {
            return owa.a.c().isAuthorizationPassed((ValidateResult) this.b.b.getValue());
        }

        public MessageActionType getType() {
            return MessageActionType.IMAGE_TO_STICKER;
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

        public b(ImageToStickerActionProvider r2, yya.a r3) {
            Intrinsics.checkNotNullParameter(r3, "actionContext");
            this.b = r2;
            this.a = r3;
        }

        public final void b(View r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            if (owa.a.c().isAuthorizationPassed((ValidateResult) this.b.b.getValue()) == true) goto L6;
            UDToast.show(LarkContext.getApplication(), 2131890928);
            return;
        L6:
            if (r4 == true) goto L9;
            return;
        L9:
            if (y0.d(this.a.getChat()) == true) goto L12;
            UDToast.show(this.a.getContext(), 2131891310);
            return;
        L12:
            String r5 = this.a.m().getId();
            v5b.a r6 = this.a.m().b();
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.ImageContentVO");
            String r7 = (String) ((ImageContentVO) r6).j.getValue();
            if (r7 != null) goto L16;
            Log.e("ImageToStickerMenu", "originKey is null for message: " + r5);
            return;
        L16:
            new Image2StickerHandler(this.a.getContext()).a(r7, r5);
            LarkAppContext.Companion.getClass();
            if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L20;
            ReactionHitPoint.a.getClass();
            ReactionHitPoint.c();
            return;
        }
    }

    static {
    }

    public final String getTAG() {
        return "ImageToStickerActionProvider";
    }

    public final List<PageType> b() {
        return (List) this.a.getValue();
    }

    public ImageToStickerActionProvider() {
        this.a = LazyKt.lazy(ImageToStickerActionProvider$supportedPageTypes$2.INSTANCE);
        this.b = LazyKt.lazy(ImageToStickerActionProvider$validateResult$2.INSTANCE);
    }

    public final i c(yya.a r2) {
        Intrinsics.checkNotNullParameter(r2, "actionContext");
        return new b(this, r2);
    }
}
