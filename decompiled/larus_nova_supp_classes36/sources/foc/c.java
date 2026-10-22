package foc;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.ss.android.lark.image.ImageLoader;
import com.suite.lark.platform.component.cta.databinding.CtaDialogContentBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends UDDialogController {
    public String a;
    public List<goc.b.l> b;
    public e c;
    public int d;

    public final int getDefaultContentRes() {
        return 2131559972;
    }

    public final View onCreateContent() {
        View r1 = LayoutInflater.from(getContext()).inflate(2131559972, null, false);
        int r2 = 2131368308;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r1, 2131368308);
        if (r5 == null) goto L65;
        r2 = 2131391794;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r1, 2131391794);
        if (r6 == null) goto L65;
        CtaDialogContentBinding r3 = new CtaDialogContentBinding((LinearLayout) r1, r5, r6);
        String r4 = this.a;
        if (r4 != null) goto L9;
    L12:
        boolean r7 = true;
    L14:
        if (r7 == false) goto L16;
        r5.setImageResource(2131238213);
    L17:
        List<goc.b.l> r8 = this.b;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        SpannableStringBuilder r9 = new SpannableStringBuilder();
        Iterator r10 = r8.iterator();
        int r11 = 0;
    L19:
        if (r10.hasNext() == false) goto L62;
        Object r12 = r10.next();
        int r13 = r11 + 1;
        if (r11 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        goc.b.l r14 = (goc.b.l) r12;
        String r15 = r14.a();
        if (r15 != null) goto L26;
        r15 = "";
    L26:
        SpannableStringBuilder r16 = new SpannableStringBuilder(d.a(r15));
        List<goc.b.i> r17 = r14.b();
        if (r17 != null) goto L29;
        r17 = CollectionsKt.emptyList();
    L29:
        Iterator r18 = CollectionsKt.filterNotNull(r17).iterator();
    L31:
        if (r18.hasNext() == false) goto L58;
        goc.b.i r19 = (goc.b.i) r18.next();
        String r110 = r19.getType();
        if (Intrinsics.areEqual(r110, "user") == false) goto L44;
        String r20 = r19.c();
        if (r20 != null) goto L37;
        r20 = "";
    L37:
        Iterator r111 = r10;
        MatchResult r21 = Regex.find$default(new Regex("\\{\\{" + r20 + "\\}\\}"), r16, 0, 2, null);
        if (r21 == null) goto L56;
        String r22 = r19.b();
        if (r22 != null) goto L43;
        r22 = "";
    L43:
        String r23 = "@".concat(r22);
        r16.replace(r21.getRange().getFirst(), r21.getRange().getLast() + 1, r23);
        r16.setSpan(new b18.a(this.d, new b(this, r20)), r21.getRange().getFirst(), r21.getRange().getFirst() + r23.length(), 17);
    L56:
        r10 = r111;
        goto L31
    L44:
        r111 = r10;
        if (Intrinsics.areEqual(r110, "plain_text") == false) goto L56;
        String r24 = r19.c();
        if (r24 != null) goto L49;
        r24 = "";
    L49:
        MatchResult r25 = Regex.find$default(new Regex("\\{\\{" + r24 + "\\}\\}"), r16, 0, 2, null);
        if (r25 != null) goto L52;
    L51:
        r10 = r111;
        goto L31
    L52:
        int r26 = r25.getRange().getFirst();
        int r27 = r25.getRange().getLast() + 1;
        String r112 = r19.b();
        if (r112 != null) goto L55;
        r112 = "";
    L55:
        r16.replace(r26, r27, r112);
        goto L51
    L58:
        Iterator r113 = r10;
        r9.append(r16);
        if (r11 == CollectionsKt.getLastIndex(r8)) goto L61;
        r9.append('\n');
    L61:
        r11 = r13;
        r10 = r113;
        goto L19
    L62:
        r6.setText(r9);
        r6.setMovementMethod(LinkMovementMethod.getInstance());
        return r3.a;
    L16:
        ImageLoader.with(getContext()).load(this.a).error(2131238213).into(r5);
        goto L17
    L9:
        if (StringsKt.isBlank(r4) == true) goto L12;
        r7 = false;
    L65:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }

    public c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = CollectionsKt.emptyList();
    }

    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r2, UDDialog r3) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        super.apply(r2, r3);
        if ((r2 instanceof a) == false) goto L7;
        a r4 = (a) r2;
        this.a = r4.a;
        this.b = new ArrayList(r4.b);
        this.c = r4.c;
        this.d = r4.d;
        return;
    L7:
        throw new IllegalArgumentException("builder should be CTADialogBuilder, but actually ".concat(r2.getClass().getSimpleName()).toString());
    }
}
