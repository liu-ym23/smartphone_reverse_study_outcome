package oca;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.im.bean.message.Message;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.assistant.card.databinding.ObricCardDownloadAppV2Binding;
import com.obric.assistant.card.databinding.ObricCardItemDownloadAppV2Binding;
import com.obric.assistant.view.FullWidthLinearlayout;
import com.obric.capabilitykit.entity.app.AppInfoEntity;
import com.obric.oui.button.OButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i extends b {
    public final Lazy x;

    public static final class a {
    }

    static {
    }

    private final ObricCardDownloadAppV2Binding getBinding() {
        return (ObricCardDownloadAppV2Binding) this.x.getValue();
    }

    public i(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.x = LazyKt.lazy(new h(r2, this));
    }

    @Override // oca.b
    public final Map<String, String> q(AppIntentMessage r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("card_type", "app_download_intent"), TuplesKt.to("card_content_type", "app_installed")});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // oca.b
    public final void o(final AppIntentMessage r20, Message r21) {
        Intrinsics.checkNotNullParameter(r20, LynxResourceModule.DATA_KEY);
        Intrinsics.checkNotNullParameter(r21, "message");
        n(getBinding().c, ContextCompat.getColor(getContext(), 2131100492));
        LinearLayout r3 = getBinding().b;
        r3.removeAllViews();
        int r4 = tca.e.c(r20);
        ArrayList r5 = (ArrayList) tca.e.b(r20);
        Iterator r6 = r5.iterator();
        int r7 = 0;
        int r8 = 0;
    L4:
        if (r6.hasNext() == false) goto L58;
        final AppInfoEntity r9 = (AppInfoEntity) r6.next();
        int r10 = tca.e.a(r4, r9);
        if (r10 == 0) goto L4;
        ConstraintLayout r0 = LayoutInflater.from(getContext()).inflate(2131563949, r3, false);
        int r11 = 2131370146;
        OButton r15 = ViewBindings.findChildViewById(r0, 2131370146);
        if (r15 == null) goto L57;
        r11 = 2131370148;
        SimpleDraweeView r16 = ViewBindings.findChildViewById(r0, 2131370148);
        if (r16 == null) goto L57;
        r11 = 2131370150;
        TextView r17 = (TextView) ViewBindings.findChildViewById(r0, 2131370150);
        if (r17 == null) goto L57;
        r11 = 2131370151;
        TextView r18 = (TextView) ViewBindings.findChildViewById(r0, 2131370151);
        if (r18 == null) goto L57;
        ObricCardItemDownloadAppV2Binding r12 = new ObricCardItemDownloadAppV2Binding(r0, r15, r16, r17, r18);
        String r1 = r9.getIcon();
        if (r1 != null) goto L19;
    L22:
        boolean r13 = true;
    L23:
        if (r13 == true) goto L25;
        ImageLoaderKt.u(r12.c, r1, "obric_intent.download_app_intent");
    L39:
        r12.e.setText(StringsKt.trim(r9.getAppName()).toString());
        String r2 = r9.getPackageSize();
        if (r2 != null) goto L42;
    L45:
        boolean r14 = true;
    L46:
        if (r14 == false) goto L48;
        e1.o(r12.d);
    L49:
        if (r10 != 1) goto L51;
        r12.b.setText(2131912023);
        r12.b.setOnClickListener(new f(this, r9, r20));
    L55:
        e1.x(r12.b);
        r3.addView(r12.a);
        r8 = r8 + 1;
        goto L4
    L51:
        if (r10 != 2) goto L55;
        r12.b.setText(2131912012);
        r12.b.setOnClickListener(new g(this, r9, r20));
        goto L55
    L48:
        r12.d.setText(r2);
        e1.x(r12.d);
        goto L49
    L42:
        if (StringsKt.isBlank(r2) == true) goto L45;
        r14 = false;
        goto L46
    L25:
        String r19 = r9.getAppPackageName();
        Drawable r110 = null;
        Object r111 = null;
        if ((!StringsKt.isBlank(r19)) == true) goto L64;
    L36:
        if (r110 == null) goto L38;
        ImageLoaderKt.b(r12.c);
        r12.c.setImageDrawable(r110);
        goto L39
    L38:
        r12.c.setActualImageResource(2131244448);
        goto L39
    L64:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L29
        Object r22 = Result.constructor-impl(getContext().getPackageManager().getApplicationIcon(r19));     // Catch: Throwable -> L29
    L32:
        if (Result.isFailure-impl(r22) == true) goto L35;
        r111 = r22;
    L35:
        r110 = (Drawable) r111;
    L29:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    L19:
        if (r1.length() == 0) goto L22;
        r13 = false;
    L57:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r11)));
    L58:
        FullWidthLinearlayout r23 = getBinding().a;
        if (r8 > 0) goto L62;
        r7 = 8;
    L62:
        r23.setVisibility(r7);
        FLogger.a.i("DownloadAppV2EntityBox", "bindCardData: operateType=" + r4 + ", total=" + r5.size() + ", visible=" + r8);
    }
}
