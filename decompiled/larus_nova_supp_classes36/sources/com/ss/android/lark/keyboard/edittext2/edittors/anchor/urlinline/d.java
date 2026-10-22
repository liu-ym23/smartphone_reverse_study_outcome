package com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.larksuite.rucket.job.compat.f;
import com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.edittext2.span.e;
import com.ss.android.lark.keyboard.edittext2.span.m;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import hob.j;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class d extends fob.b<j> {
    public final j b;
    public final UrlInlinePreviewConfig c;
    public final String d;

    public static final class a {
    }

    static {
    }

    public void j() {
    }

    public /* synthetic */ d(j r2) {
        int r0 = UrlInlinePreviewConfig.b;
        this(r2, UrlInlinePreviewConfig.a.a());
    }

    public void g(UrlInlinePreviewEntity r5) {
        Intrinsics.checkNotNullParameter(r5, "entity");
        j r0 = this.b;
        boolean r1 = true;
        r0.g = true;
        String r2 = StringsKt.trim(r5.b).toString();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.e = r2;
        String r3 = r5.g;
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L14;
        if (r5.m == false) goto L14;
        j.a r6 = this.b.f;
        r6.c = r5.g;
        r6.e = true;
        return;
    L14:
        if (r5.h != 0) goto L16;
    L22:
        String r7 = r5.j;
        if (r7 != null) goto L25;
    L28:
        boolean r8 = true;
    L29:
        if (r8 == false) goto L31;
    L33:
        String r9 = r5.k;
        if (r9 != null) goto L36;
    L39:
        boolean r10 = true;
    L40:
        if (r10 == false) goto L42;
    L44:
        String r11 = r5.f;
        if (r11 != null) goto L47;
    L50:
        if (r1 == true) goto L52;
        this.b.f.c = r5.f;
        return;
    L52:
        int r12 = r5.d;
        if (r12 == 0) goto L58;
        j.a r13 = this.b.f;
        r13.a = r12;
        int r14 = r5.e;
        if (r14 != 0) goto L57;
        r13.f = UIHelper.getColor(2131106616);
        return;
    L57:
        r13.f = r14;
        return;
    L58:
        j.a r15 = this.b.f;
        String r16 = r5.c;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r15.b = r16;
        this.b.f.f = UIHelper.getColor(2131106616);
        return;
    L47:
        if (r11.length() == 0) goto L50;
        r1 = false;
        goto L50
    L42:
        if (r5.m == false) goto L44;
        j.a r17 = this.b.f;
        r17.d = r5.k;
        r17.f = r5.l;
        r17.e = true;
        return;
    L36:
        if (r9.length() == 0) goto L39;
        r10 = false;
        goto L40
    L31:
        if (r5.m == false) goto L33;
        j.a r18 = this.b.f;
        String r19 = r5.j;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r18.b = r19;
        j.a r20 = this.b.f;
        r20.f = r5.l;
        r20.e = true;
        return;
    L25:
        if (r7.length() == 0) goto L28;
        r8 = false;
        goto L29
    L16:
        if (r5.m == false) goto L22;
        j.a r21 = this.b.f;
        if ((!com.ss.android.lark.keyboard.edittext2.utils.d.a("messenger.im.disable_doubao_url_inline_icon_fix")) == false) goto L20;
        int r22 = r5.h;
    L21:
        r21.a = r22;
        j.a r23 = this.b.f;
        r23.f = r5.i;
        r23.e = true;
        return;
    L20:
        r22 = r5.d;
        goto L21
    L5:
        if (r3.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    public final boolean h(Editable r10) {
        Intrinsics.checkNotNullParameter(r10, "editable");
        Intrinsics.checkNotNullParameter(r10, "editable");
        Pair<Integer, Integer> r1 = b(r10);
        int r2 = ((Number) r1.component1()).intValue();
        int r3 = ((Number) r1.component2()).intValue();
        if (r2 == (-1)) goto L7;
        if (r3 == (-1)) goto L7;
        boolean r5 = false;
    L8:
        if (r3 >= r2) goto L10;
        boolean r6 = true;
    L11:
        if (r2 >= 0) goto L13;
    L15:
        boolean r7 = false;
    L16:
        if (r7 == false) goto L24;
        if (r3 >= 0) goto L19;
    L21:
        boolean r8 = false;
    L22:
        if (r8 == false) goto L24;
        boolean r9 = true;
    L26:
        if (r5 == true) goto L31;
        if (r6 == true) goto L31;
        if (r9 == false) goto L31;
        boolean r4 = Intrinsics.areEqual(r10.subSequence(r2, r3), this.d);
    L32:
        if (r4 == false) goto L35;
        Log.i("AnchorEditor", "prepareSpan: this url has been modified by user. now return");
        Intrinsics.checkNotNullParameter(r10, "editable");
        r10.removeSpan(this);
        return true;
    L35:
        return false;
    L31:
        Log.i("AnchorEditor", "checkUrlChanged: url has been changed.");
        r4 = true;
        goto L32
    L19:
        if (r3 > r10.length()) goto L21;
        r8 = true;
    L24:
        r9 = false;
        goto L26
    L13:
        if (r2 > r10.length()) goto L15;
        r7 = true;
        goto L16
    L10:
        r6 = false;
    L7:
        r5 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void k(final FunctionEditText r21) {
        Intrinsics.checkNotNullParameter(r21, "targetView");
        Editable r3 = r21.getEditableText();
        Log.d("AnchorEditor", "prepareSpan called");
        Intrinsics.checkNotNull(r3);
        if (h(r3) == false) goto L5;
        return;
    L5:
        boolean r5 = !com.ss.android.lark.keyboard.edittext2.utils.d.a("messenger.im.disable_doubao_url_inline_layout_fix");
        if (r5 == false) goto L15;
        Pair<Integer, Integer> r8 = b(r3);
        int r9 = ((Number) r8.component1()).intValue();
        int r10 = ((Number) r8.component2()).intValue();
        int r11 = r21.getSelectionEnd();
        if (r21.getSelectionStart() != r11) goto L15;
        if (r9 > r11) goto L12;
        if (r11 > r10) goto L12;
        boolean r12 = true;
    L13:
        if (r12 == false) goto L15;
        boolean r13 = true;
    L16:
        Log.d("AnchorEditor", "prepareSpannableString: start");
        Intrinsics.checkNotNullParameter(r21, "targetView");
        Log.i("AnchorEditor", "prepareURLPreviewSpanString");
        j r2 = this.b;
        j.a r14 = r2.f;
        Object r4 = ((HashMap) r2.c).get(e.class.getName());
        if ((r4 instanceof e) == false) goto L19;
        e r6 = (e) r4;
    L21:
        if (r14.e == false) goto L23;
    L25:
        if (r6 != null) goto L27;
        r6 = new e((int) r21.getTextSize(), r14.f, 4);
    L27:
        boolean r19 = r13;
        m.a r15 = new m.a(r21.getContext(), this.b.e, this.d, r14.a, r14.b, r14.c, r14.d, r14.e);
        r15.a = r6.c;
        r15.c = r6.a;
        r15.b = r6.b;
        final m r7 = new m(r15);
        Drawable.Callback r16 = new UrlInlineSpanHolder$getDrawableCallback$1(r21, this, r7);
        Intrinsics.checkNotNullParameter(r16, "callback");
        r7.f.setCallback(r16);
        r7.f.invalidateSelf();
        SpannableStringBuilder r17 = r7.e;
        if (r17 == null) goto L44;
        Log.d("AnchorEditor", "prepareSpannableString: end");
        i(r17, this.b, r17.length());
        f(r3, r17, true);
        if (r5 == false) goto L45;
        r21.requestLayout();
        int r18 = r21.getSelectionEnd();
        if (r19 == true) goto L34;
        return;
    L34:
        if (r21.getSelectionStart() != r18) goto L47;
        if (r18 >= 0) goto L37;
    L39:
        boolean r20 = false;
    L40:
        if (r20 == false) goto L48;
        r21.bringPointIntoView(r18);
        return;
    L48:
        return;
    L37:
        if (r18 > r21.length()) goto L39;
        r20 = true;
        goto L40
    L47:
        return;
    L45:
        return;
    L44:
        throw new IllegalArgumentException("Required value was null.".toString());
    L23:
        if (r14.f != 0) goto L25;
        r14.f = UIHelper.getColor(2131106616);
        goto L25
    L19:
        r6 = null;
    L12:
        r12 = false;
    L15:
        r13 = false;
        goto L16
    }

    public d(j r3, UrlInlinePreviewConfig r4) {
        Intrinsics.checkNotNullParameter(r3, "anchorInfo");
        Intrinsics.checkNotNullParameter(r4, "urlPreviewConfig");
        this.b = r3;
        this.c = r4;
        this.d = r3.a;
        if (r3.d == false) goto L5;
        f.a(new UrlInlineSpanHolder$loadUrlPreviewFormMiddlePlatform$1(this)).then(Dispatchers.getMain(), new UrlInlineSpanHolder$loadUrlPreviewFormMiddlePlatform$2(this, null)).error(Dispatchers.getMain(), new UrlInlineSpanHolder$loadUrlPreviewFormMiddlePlatform$3(this, null));
        Log.i("AnchorEditor", "init: anchor info parsed form net");
        return;
    L5:
        a(new UrlInlineSpanHolder$schedulePrepareSpan$1(this));
    }

    public void i(SpannableStringBuilder r5, j r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "text");
        Intrinsics.checkNotNullParameter(r6, "data");
        RichTextElement.AnchorProperty r0 = RichTextElementCreator.a(r6.e, r6.a);
        r0.setLocalIconRes(r6.f.a);
        r0.setIconKey(r6.f.b);
        r0.setUnicode(r6.f.c);
        r0.setFaviconUrl(r6.f.d);
        r0.setIconColor(r6.f.f);
        r0.setColorIcon(r6.f.e);
        r0.setDisplayTitle(r6.e);
        r0.setUrlPreview(r6.g);
        r0.setScene(r0.getScene());
        RichTextElement r1 = RichTextElementCreator.h(r0);
        r5.setSpan(new p(r1, r5.subSequence(0, r7).toString()), 0, r7, 33);
        d(r5, r6, r7, r1);
    }
}
