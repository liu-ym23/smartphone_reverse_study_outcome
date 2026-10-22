package po8;

import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.view.RiskTipsTextView;
import com.larus.bmhome.utils.c3;
import com.larus.utils.y0;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import tx9.x1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class w extends ClickableSpan {
    public final /* synthetic */ String a;
    public final /* synthetic */ RiskTipsTextView b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r9) {
        Intrinsics.checkNotNullParameter(r9, "widget");
        int r10 = c3.a;
        if (c3.a(this.a) == false) goto L9;
        Uri r11 = y0.j(this.a);
        if (r11 == null) goto L7;
        String r1 = UriProtector.getQueryParameter(r11, "pc_guide_scene");
    L8:
        x1.e(r1, null, null, null, null, null, 126);
        goto L9
    L7:
        r1 = null;
    L9:
        com.larus.platform.service.q.a.e(this.b.getContext(), com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", this.a), TuplesKt.to("enable_bottom_share_style", "1")}), null);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r5) {
        Intrinsics.checkNotNullParameter(r5, "ds");
        super.updateDrawState(r5);
        r5.setUnderlineText(false);
        r5.setColor(ContextCompat.getColor(this.b.getContext(), v19.c.b(2130972125, this.b.getContext(), 2131103209)));
    }

    public w(String r1, RiskTipsTextView r2) {
        this.a = r1;
        this.b = r2;
    }
}
