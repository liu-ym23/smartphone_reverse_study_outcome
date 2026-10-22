package ppc;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.forward.textforward.TextForwardContent;
import com.ss.android.lark.forwardv3.messageforward.SingleMessageForwardContent;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements e {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    @Override // ppc.e
    public final boolean a(g r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        IForwardContent r0 = r3.d.getForwardContent();
        if ((r0 instanceof TextForwardContent) == false) goto L5;
    L14:
        return true;
    L5:
        if ((r0 instanceof SingleMessageForwardContent) == false) goto L13;
        Message r4 = r3.d.getSourceMessage();
        if (r4 == null) goto L9;
        Message.Type r5 = r4.getType();
    L11:
        if (r5 != Message.Type.TEXT) goto L13;
    L9:
        r5 = null;
    L13:
        return false;
    }

    @Override // ppc.e
    public final boolean b(g r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        IForwardContent r0 = r11.d.getForwardContent();
        String r2 = null;
        if ((r0 instanceof TextForwardContent) == false) goto L6;
        String r1 = ((TextForwardContent) r0).b;
    L21:
        if ((!StringsKt.isBlank(r1)) == false) goto L24;
        r2 = r1;
    L24:
        if (r2 != null) goto L26;
        return false;
    L26:
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r2, "text");
        if (StringsKt.isBlank(r2) == false) goto L29;
        return false;
    L29:
        FrameLayout r3 = r11.c;
        GradientDrawable r4 = new GradientDrawable();
        r4.setColor(ContextCompat.getColor(r11.getActivity(), 2131108712));
        r4.setCornerRadius(y9c.d.a(10));
        r3.setBackground(r4);
        LinearLayout r5 = new LinearLayout(r11.getActivity());
        r5.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r5.setGravity(16);
        r5.setMinimumHeight(y9c.d.a(56));
        r5.setOrientation(0);
        r5.setPadding(y9c.d.a(16), y9c.d.a(12), y9c.d.a(16), y9c.d.a(12));
        TextView r6 = new TextView(r11.getActivity());
        r6.setText(r2);
        r6.setEllipsize(TextUtils.TruncateAt.END);
        r6.setMaxLines(2);
        r6.setLineSpacing(y9c.d.a(2), 1.0f);
        r6.setTextColor(ContextCompat.getColor(r11.getActivity(), 2131108724));
        r6.setTextSize(16.0f);
        r5.addView(r6, new LinearLayout.LayoutParams(-1, -2));
        r11.c.addView(r5);
        r11.c.setVisibility(0);
        return true;
    L6:
        if ((r0 instanceof SingleMessageForwardContent) == false) goto L19;
        Message r7 = r11.d.getSourceMessage();
        if (r7 == null) goto L10;
        TextContent r8 = r7.getContent();
    L12:
        if ((r8 instanceof TextContent) == true) goto L15;
        r8 = null;
    L15:
        if (r8 == null) goto L17;
        r1 = r8.getText();
    L18:
        if (r1 != null) goto L21;
    L17:
        r1 = null;
        goto L18
    L10:
        r8 = null;
    L19:
        r1 = "";
        goto L21
    }
}
