package u8b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.bytedance.lark.pb.security.v1.CustomDisplayContent;
import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.google.android.flexbox.FlexboxLayout;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonWebViewClient;
import com.ss.android.lark.conditional.access.display.DisplayUtilsKt;
import com.ss.android.lark.conditional.access.nopermission.ui.custom.CustomDisplayPageUiMode;
import com.ss.android.lark.conditional.access.nopermission.ui.custom.h0;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.widget.CustomDisplayLinkTextView;
import h18.d;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends LinearLayout {
    public final int a;

    /* JADX INFO: renamed from: u8b.a$a, reason: collision with other inner class name */
    public static final class C0309a {
    }

    static {
    }

    public final int getBottomMargin() {
        return this.a;
    }

    public a(Context r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, null, 0);
        this.a = r4;
        setOrientation(1);
        setBackground(new ColorDrawable(0));
        LinearLayout.inflate(r3, 2131559977, this);
    }

    public final void a(String r3, CustomDisplayPageUiMode r4) {
        CharSequence r5 = DisplayUtilsKt.g(r3, getContext());
        TextView r0 = (TextView) findViewById(2131368376);
        r0.setMovementMethod(LinkMovementMethod.getInstance());
        Intrinsics.checkNotNull(r0);
        bab.b.a(r0);
        r0.setText(r5);
        if (r4 == CustomDisplayPageUiMode.LARK) goto L6;
        r0.setTextColor(getResources().getColor(2131101392));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.view.View, android.view.View$OnClickListener, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.ss.android.lark.conditional.access.widget.CustomDisplayLinkTextView] */
    public final void b(CustomDisplayContent r12, InternalSecurityAction r13, com.ss.android.lark.conditional.access.nopermission.ui.custom.a r14, CustomDisplayPageUiMode r15) {
        Intrinsics.checkNotNullParameter(r12, "content");
        Intrinsics.checkNotNullParameter(r14, "buttonTypeFunction");
        Intrinsics.checkNotNullParameter(r15, "pageUiMode");
        if (r15 == CustomDisplayPageUiMode.LARK) goto L6;
        TextView r2 = (TextView) findViewById(2131368377);
        Intrinsics.checkNotNull(r2);
        h0.a(r2, ChameleonWebViewClient.DEFAULT_SAFE_TIME);
        r2.setTextSize(2, 15.0f);
        r2.setTextColor(r2.getResources().getColor(2131101391));
        TextView r3 = (TextView) findViewById(2131368376);
        r3.setTextSize(2, 15.0f);
        TextViewCompat.setLineHeight(r3, (int) d.b(r3.getContext(), 22));
        r3.setTextColor(r3.getResources().getColor(2131101392));
    L6:
        ((TextView) findViewById(2131368377)).setText(r12.title);
        if (r12.richText.length() <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
        a(r12.richText, r15);
    L13:
        FlexboxLayout r5 = (FlexboxLayout) findViewById(2131368375);
        Iterator r16 = r12.handler_list.iterator();
    L15:
        if (r16.hasNext() == false) goto L27;
        CustomDisplayHandler r6 = (CustomDisplayHandler) r16.next();
        Intrinsics.checkNotNull(r6);
        if (com.ss.android.lark.conditional.access.utils.b.a(r6) == false) goto L15;
        ?? r7 = new CustomDisplayLinkTextView(getContext());
        Intrinsics.checkNotNullParameter(r6, "handler");
        Intrinsics.checkNotNullParameter(r14, "buttonTypeFunction");
        Intrinsics.checkNotNullParameter(r15, "pageUiMode");
        r7.a = r6;
        r7.b = r13;
        r7.c = r14;
        r7.d = r15;
        r7.setText(r6.name);
        r7.setTag(r6.type);
        Resources r8 = r7.getResources();
        CustomDisplayPageUiMode r9 = r7.d;
        CustomDisplayPageUiMode r10 = CustomDisplayPageUiMode.LARK;
        if (r9 != r10) goto L21;
        int r11 = 2131106614;
    L22:
        r7.setTextColor(r8.getColor(r11));
        r7.setOnClickListener(r7);
        if (r15 == r10) goto L25;
        h0.a(r7, ChameleonWebViewClient.DEFAULT_SAFE_TIME);
        r7.setTextSize(2, 15.0f);
    L25:
        r7.setTag(r6.type);
        r5.addView(r7, new LinearLayout.LayoutParams(-2, -2));
        goto L15
    L21:
        r11 = 2131101385;
        goto L22
    L27:
        if (this.a <= 0) goto L35;
        View r17 = new View(getContext());
        r17.setId(LinearLayout.generateViewId());
        r17.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) d.b(r17.getContext(), this.a)));
        r5.addView(r17);
        return;
    L35:
        return;
    L12:
        a(r12.text, r15);
        goto L13
    L9:
        r4 = false;
        goto L10
    }
}
