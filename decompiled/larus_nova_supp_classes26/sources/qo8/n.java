package qo8;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.larus.bmhome.chat.model.MessageShareViewModel;
import com.larus.bmhome.chat.view.share.MessageListMaskView;
import com.larus.bmhome.databinding.LarusLayoutSelectedMessageShareBinding;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.IFlowChatThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n extends c {
    public ConstraintLayout k;
    public LarusLayoutSelectedMessageShareBinding l;

    public static final class a {
    }

    static {
    }

    @Override // qo8.c
    public final void e() {
    }

    @Override // qo8.e
    public final int a() {
        return ((Number) this.j.getValue()).intValue();
    }

    @Override // qo8.c
    public final void g() {
        LarusLayoutSelectedMessageShareBinding r0 = this.l;
        if (r0 == null) goto L8;
        MessageListMaskView r1 = r0.b;
        if (r1 == null) goto L9;
        r1.a = false;
        r1.b = null;
        return;
    L9:
        return;
    }

    @Override // qo8.e
    public final ConstraintLayout b() {
        return this.k;
    }

    @Override // qo8.c
    public final void c(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        ConstraintLayout r5 = LayoutInflater.from(r4).inflate(2131562883, null, false);
        int r0 = 2131364451;
        if (ViewBindings.findChildViewById(r5, 2131364451) == null) goto L25;
        r0 = 2131373142;
        if (ViewBindings.findChildViewById(r5, 2131373142) == null) goto L25;
        r0 = 2131374278;
        if (((ImageView) ViewBindings.findChildViewById(r5, 2131374278)) == null) goto L25;
        r0 = 2131374285;
        if (((LinearLayout) ViewBindings.findChildViewById(r5, 2131374285)) == null) goto L25;
        r0 = 2131374290;
        if (ViewBindings.findChildViewById(r5, 2131374290) == null) goto L25;
        r0 = 2131379672;
        MessageListMaskView r1 = (MessageListMaskView) ViewBindings.findChildViewById(r5, 2131379672);
        if (r1 == null) goto L25;
        r0 = 2131379973;
        if (ViewBindings.findChildViewById(r5, 2131379973) == null) goto L25;
        r0 = 2131379998;
        if (ViewBindings.findChildViewById(r5, 2131379998) == null) goto L25;
        r0 = 2131388772;
        if (((TextView) ViewBindings.findChildViewById(r5, 2131388772)) == null) goto L25;
        r0 = 2131389226;
        View r2 = ViewBindings.findChildViewById(r5, 2131389226);
        if (r2 == null) goto L25;
        ConstraintLayout r6 = r5;
        this.l = new LarusLayoutSelectedMessageShareBinding(r6, r1, r2);
        this.k = r6;
        return;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r0)));
    }

    @Override // qo8.c
    public final void f(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        z2 r0 = z2.a;
        if (r0.u0().b() == false) goto L6;
        FLogger.a.i("NormalShareCvsMsgListView", "disable share QRCode");
        return;
    L6:
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        r6.put(EncodeHintType.MARGIN, 1);
        String r2 = this.b;
        if (r2 == null) goto L17;
        Bitmap r10 = o19.a.a(r2, d(), d(), ContextCompat.getColor(r9, v19.c.b(2130972079, r9, 2131103136)), r6, r0.shareQrCodeUseCustomStyle());
        ConstraintLayout r1 = this.k;
        if (r1 == null) goto L13;
        ImageView r3 = (ImageView) r1.findViewById(2131373149);
        if (r3 == null) goto L13;
        r3.setImageBitmap(r10);
    L13:
        Function0 r11 = new m(this);
        r0.w3();
        IFlowChatThemeConfigProvider r4 = (IFlowChatThemeConfigProvider) ServiceManager.get().getService(IFlowChatThemeConfigProvider.class);
        if (r4 == null) goto L18;
        r4.e(r11, AdaptThemeFeatureKey.CHAT_SHARE_IMAGE_FOOTER_AVATAR_AND_TITLE);
        return;
    L18:
        return;
    }

    public n(Context r11, List<Message> r12, String r13, Bitmap r14, wc9.e r15, MessageShareViewModel.b r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "messageList");
        Intrinsics.checkNotNullParameter(r16, "provider");
        super(r11, r12, r13, r14, r15, r16, null, r17);
    }
}
