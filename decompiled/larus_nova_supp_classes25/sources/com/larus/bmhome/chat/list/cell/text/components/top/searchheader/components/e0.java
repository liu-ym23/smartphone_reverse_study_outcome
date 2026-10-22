package com.larus.bmhome.chat.list.cell.text.components.top.searchheader.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.chat.common.databinding.LarusComponentSearchReferenceBinding;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.Reference;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.VideoCard;
import com.larus.utils.e1;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e0 extends bd8.b implements hg8.z {
    public final Lazy l;
    public final wg8.f m;
    public final Lazy n;
    public boolean o;
    public LarusComponentSearchReferenceBinding p;
    public Message q;
    public final Lazy r;

    public static final class a {
    }

    static {
    }

    public e0() {
        super(false, -1);
        this.l = LazyKt.lazy(new z(this));
        this.m = new wg8.f();
        this.n = LazyKt.lazy(new a0(this));
        this.r = LazyKt.lazy(new b0(this));
    }

    @Override // bd8.b
    public final void C() {
        this.q = null;
    }

    @Override // hg8.z
    public final void i(int r1) {
    }

    @Override // hg8.z
    public final void j() {
        J(this.o);
    }

    @Override // bd8.b
    public final void z() {
        J(this.o);
    }

    public final void J(boolean r2) {
        if (r2 == false) goto L8;
        LarusComponentSearchReferenceBinding r3 = this.p;
        if (r3 == null) goto L14;
        AppCompatImageView r4 = r3.b;
        if (r4 == null) goto L15;
        r4.setRotation(0.0f);
        return;
    L15:
        return;
    L14:
        return;
    L8:
        LarusComponentSearchReferenceBinding r5 = this.p;
        if (r5 == null) goto L17;
        AppCompatImageView r6 = r5.b;
        if (r6 == null) goto L18;
        r6.setRotation(270.0f);
        return;
    L18:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    @Override // bd8.b
    public final void w(Message r17, int r18, ec8.b r19) {
        Intrinsics.checkNotNullParameter(r17, "message");
        Intrinsics.checkNotNullParameter(r17, "message");
        List r2 = com.larus.im.bean.message.a.G(r17);
        LarusComponentSearchReferenceBinding r3 = this.p;
        if (r3 == null) goto L8;
        LinearLayout r4 = r3.a;
        if (r4 == null) goto L8;
        r4.setAlpha(1.0f);
    L8:
        if (com.larus.bmhome.chat.bean.d.I0(r17) == false) goto L10;
        return;
    L10:
        if (com.larus.im.bean.message.a.v(r17) == true) goto L14;
        if ((!r2.isEmpty()) == false) goto L14;
    L15:
        this.q = r17;
        J(this.o);
        Message r1 = this.q;
        if (r1 == null) goto L95;
        LarusComponentSearchReferenceBinding r5 = this.p;
        LinearLayout r6 = null;
        if (r5 != null) goto L21;
    L77:
        LarusComponentSearchReferenceBinding r7 = this.p;
        if (r7 == null) goto L80;
        r6 = r7.c;
    L80:
        e1.d(r6, new x(this));
        LarusComponentSearchReferenceBinding r8 = this.p;
        if (r8 == null) goto L93;
        LinearLayout r9 = r8.c;
        if (r9 == null) goto L94;
        r9.setOnLongClickListener(new y(this));
        return;
    L94:
        return;
    L93:
        return;
    L21:
        if (com.larus.im.bean.message.a.f0(r1) == true) goto L23;
        Map r10 = r1.getExt();
        if (r10 == null) goto L44;
        String r11 = (String) r10.get("loading_text");
        if (r11 == null) goto L44;
    L50:
        List r12 = com.larus.im.bean.message.a.G(r1);
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L52:
        if (r14.hasNext() == false) goto L59;
        Reference r15 = (Reference) r14.next();
        TextCard r16 = r15.getTextCard();
        if (r16 == null) goto L56;
        r13.add(r16);
    L56:
        VideoCard r20 = r15.getVideoCard();
        if (r20 == null) goto L52;
        r13.add(r20);
        goto L52
    L59:
        int r110 = r13.size();
        if (com.larus.im.bean.message.a.C0(r1) == false) goto L65;
        List r21 = StringsKt.split$default(r11, new String[]{"%s"}, false, 0, 6, null);
        AppCompatTextView r22 = r5.e;
        if (r21.size() != 2) goto L64;
        r11 = StringsKt.replace$default(r11, "%s", String.valueOf(r110), false, 4, null);
    L64:
        r22.setText(r11);
    L73:
        we8.a.b(r5.e, i5.t(), false, null, null, 12);
        if (com.larus.bmhome.chat.bean.d.f0(r1) == false) goto L76;
        r5.e.z(false);
        goto L77
    L76:
        r5.e.x();
        goto L77
    L65:
        List r23 = StringsKt.split$default(r11, new String[]{"%s"}, false, 0, 6, null);
        ShimmerTextView r111 = r5.e;
        if (r23.size() != 2) goto L68;
        String r24 = r11;
        ?? r25 = r111;
        String r26 = StringsKt.replace$default(r24, "%s", String.valueOf(r110), false, 4, null);
    L72:
        r25.setText(r26);
        goto L73
    L68:
        ShimmerTextView r27 = r111;
        Context r28 = getContext();
        if (r28 == null) goto L71;
        r26 = r28.getString(2131900977, new Object[]{String.valueOf(r110)});
        r25 = r27;
        goto L72
    L71:
        r26 = null;
        r25 = r27;
    L44:
        Context r29 = getContext();
        if (r29 == null) goto L47;
        r11 = r29.getString(2131900977);
    L48:
        if (r11 != null) goto L50;
    L49:
        r11 = "";
        goto L50
    L47:
        r11 = null;
        goto L48
    L23:
        if (com.larus.bmhome.chat.bean.d.f0(r1) == false) goto L27;
        Map r30 = r1.getExt();
        if (r30 == null) goto L30;
        r11 = (String) r30.get("loading_inprocess_text");
    L32:
        if (o0.d(r11) == false) goto L35;
        if (r11 != null) goto L50;
    L35:
        Context r31 = getContext();
        if (r31 == null) goto L49;
        r11 = r31.getString(2131901490);
        if (r11 != null) goto L50;
    L30:
        r11 = null;
        goto L32
    L27:
        Map r32 = r1.getExt();
        if (r32 == null) goto L30;
        r11 = (String) r32.get("loading_text");
        goto L32
    L95:
        return;
    L14:
        if (com.larus.im.bean.message.a.f0(r17) == true) goto L15;
    }

    @Override // bd8.b
    public final List<View> x(int r7, Context r8, BaseMessageListCell<?> r9, com.larus.bmhome.chat.layout.item.i r10, q0 r11, Fragment r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        if (r10 == null) goto L5;
        View r13 = LayoutInflater.from(r8).inflate(2131561983, r10, false);
        int r14 = 2131375994;
        AppCompatImageView r2 = ViewBindings.findChildViewById(r13, 2131375994);
        if (r2 == null) goto L19;
        r14 = 2131378820;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r13, 2131378820);
        if (r3 == null) goto L19;
        LinearLayout r15 = (LinearLayout) r13;
        View r4 = ViewBindings.findChildViewById(r13, 2131379669);
        if (r4 == null) goto L17;
        ShimmerTextView r5 = (ShimmerTextView) ViewBindings.findChildViewById(r13, 2131391266);
        if (r5 == null) goto L16;
        LarusComponentSearchReferenceBinding r16 = new LarusComponentSearchReferenceBinding(r15, r2, r3, r4, r5);
        r10.addView(r15, r7, new LinearLayout.LayoutParams(-1, -1));
        this.m.a = r9;
        this.p = r16;
        return CollectionsKt.listOf(r15);
    L16:
        r14 = 2131391266;
        goto L19
    L17:
        r14 = 2131379669;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    L5:
        return CollectionsKt.emptyList();
    }
}
