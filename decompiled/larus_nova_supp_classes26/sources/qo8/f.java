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
import com.larus.bmhome.bot.share.ImmerseBgBitmapImageView;
import com.larus.bmhome.chat.immerse.k0;
import com.larus.bmhome.chat.model.MessageShareViewModel;
import com.larus.bmhome.chat.view.share.MessageListMaskView;
import com.larus.bmhome.databinding.LarusLayoutSelectedMessageShareImmersiveBinding;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f extends c {
    public ConstraintLayout k;
    public LarusLayoutSelectedMessageShareImmersiveBinding l;
    public Integer m;

    public static final class a {
    }

    static {
    }

    @Override // qo8.e
    public final int a() {
        return ((Number) this.j.getValue()).intValue();
    }

    @Override // qo8.c
    public final void e() {
        LarusLayoutSelectedMessageShareImmersiveBinding r0 = this.l;
        if (r0 == null) goto L8;
        ImmerseBgBitmapImageView r1 = r0.d;
        if (r1 == null) goto L9;
        ImmerseBgBitmapImageView.a(r1, this.f, this.e.g().m());
        return;
    L9:
        return;
    }

    @Override // qo8.c
    public final void g() {
        LarusLayoutSelectedMessageShareImmersiveBinding r0 = this.l;
        if (r0 == null) goto L8;
        MessageListMaskView r1 = r0.e;
        if (r1 == null) goto L9;
        Integer r2 = this.m;
        r1.a = true;
        r1.b = r2;
        return;
    L9:
        return;
    }

    @Override // qo8.e
    public final ConstraintLayout b() {
        return this.k;
    }

    @Override // qo8.c
    public final void c(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        ConstraintLayout r11 = LayoutInflater.from(r10).inflate(2131562884, null, false);
        int r0 = 2131373142;
        ConstraintLayout r4 = ViewBindings.findChildViewById(r11, 2131373142);
        if (r4 == null) goto L27;
        r0 = 2131374278;
        if (((ImageView) ViewBindings.findChildViewById(r11, 2131374278)) == null) goto L27;
        r0 = 2131374285;
        if (((LinearLayout) ViewBindings.findChildViewById(r11, 2131374285)) == null) goto L27;
        r0 = 2131374306;
        View r5 = ViewBindings.findChildViewById(r11, 2131374306);
        if (r5 == null) goto L27;
        r0 = 2131375181;
        ImmerseBgBitmapImageView r6 = ViewBindings.findChildViewById(r11, 2131375181);
        if (r6 == null) goto L27;
        r0 = 2131379672;
        MessageListMaskView r7 = (MessageListMaskView) ViewBindings.findChildViewById(r11, 2131379672);
        if (r7 == null) goto L27;
        r0 = 2131379973;
        if (ViewBindings.findChildViewById(r11, 2131379973) == null) goto L27;
        r0 = 2131379998;
        if (ViewBindings.findChildViewById(r11, 2131379998) == null) goto L27;
        r0 = 2131388772;
        if (((TextView) ViewBindings.findChildViewById(r11, 2131388772)) == null) goto L27;
        r0 = 2131389226;
        View r8 = ViewBindings.findChildViewById(r11, 2131389226);
        if (r8 == null) goto L27;
        ConstraintLayout r12 = r11;
        this.l = new LarusLayoutSelectedMessageShareImmersiveBinding(r12, r4, r5, r6, r7, r8);
        this.k = r12;
        Integer r13 = this.e.g().m();
        if (r13 == null) goto L28;
        this.m = Integer.valueOf(k0.a(r13.intValue(), 0.4f, 0.15f));
        return;
    L28:
        return;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }

    @Override // qo8.c
    public final void f(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        ConstraintLayout r0 = this.k;
        if (r0 == null) goto L18;
        TextView r1 = (TextView) r0.findViewById(2131373154);
        if (r1 == null) goto L7;
        r1.setTextColor(ContextCompat.getColor(r9, 2131103298));
    L7:
        TextView r2 = (TextView) r0.findViewById(2131373152);
        if (r2 == null) goto L10;
        r2.setTextColor(ContextCompat.getColor(r9, 2131103298));
    L10:
        z2 r10 = z2.a;
        if (r10.u0().b() == true) goto L17;
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        r6.put(EncodeHintType.MARGIN, 1);
        String r3 = this.b;
        if (r3 == null) goto L18;
        Bitmap r11 = o19.a.a(r3, d(), d(), -1, r6, r10.shareQrCodeUseCustomStyle());
        ImageView r4 = (ImageView) r0.findViewById(2131373149);
        if (r4 == null) goto L18;
        r4.setImageBitmap(r11);
        goto L18
    L17:
        FLogger.a.i("ImmersiveShareCvsMsgListView", "disable share QRCode");
    L18:
        Integer r12 = this.m;
        if (r12 == null) goto L26;
        int r13 = r12.intValue();
        LarusLayoutSelectedMessageShareImmersiveBinding r5 = this.l;
        if (r5 == null) goto L27;
        ConstraintLayout r7 = r5.b;
        if (r7 == null) goto L28;
        r7.setBackgroundColor(r13);
        return;
    L28:
        return;
    L27:
        return;
    }

    public f(Context r11, List<Message> r12, String r13, Bitmap r14, Bitmap r15, wc9.e r16, MessageShareViewModel.b r17) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "messageList");
        Intrinsics.checkNotNullParameter(r17, "provider");
        super(r11, r12, r13, r14, r16, r17, r15, false);
    }
}
