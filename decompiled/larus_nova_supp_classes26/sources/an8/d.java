package an8;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import cb8.x1;
import cn8.e;
import com.larus.bmhome.chat.layout.widget.ShimmerLinearLayout;
import com.larus.bmhome.chat.layout.widget.ThreeLoadingIndicator;
import com.larus.bmhome.chat.layout.widget.v0;
import com.larus.bmhome.chat.standarduikit.replytextloading.view.ReplyTextLoadingView;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.LoadingBlock;
import com.larus.im.bean.message.block.MessageReplyTextLoading;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import java.util.Iterator;
import jc8.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends jc8.b<a> {
    public final Lazy d;
    public final Lazy e;
    public zm8.c f;

    public final String c() {
        return "ReplyTextLoadingBlockHolder";
    }

    public final void i() {
        zm8.c r0 = this.f;
        if (r0 == null) goto L9;
        ReplyTextLoadingView r1 = (ReplyTextLoadingView) r0.b.getValue();
        ThreeLoadingIndicator r2 = r1.l;
        if (r2 == null) goto L7;
        r2.a();
    L7:
        r1.k.c.setText(null);
        r1.k.c.setOnClickListener(null);
        e1.o(r1.k.b);
        r1.a();
        r1.m = null;
        return;
    }

    public d() {
        this.d = LazyKt.lazy(new b(this));
        this.e = LazyKt.lazy(new c(this));
    }

    public final jc8.d f(jc8.a r2) {
        Intrinsics.checkNotNullParameter((a) r2, "blockModel");
        return new jc8.d(0, 0, 0, 0);
    }

    public final void g(jc8.a r26) {
        a r1 = (a) r26;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        BlockContent r2 = ((jc8.a) r1).a.getContent();
        if (r2 == null) goto L5;
        LoadingBlock r3 = r2.getLoadingBlock();
    L6:
        boolean r4 = true;
        if (r3 == null) goto L14;
        Integer r6 = r3.scene;
        if (r6 == null) goto L14;
        if (r6.intValue() != 4) goto L14;
        boolean r7 = true;
    L15:
        if (r3 == null) goto L22;
        Integer r8 = r3.scene;
        if (r8 == null) goto L22;
        if (r8.intValue() != 2) goto L22;
        boolean r9 = true;
    L24:
        if (r3 == null) goto L28;
        MessageReplyTextLoading r10 = r3.getTextLoading();
        if (r10 == null) goto L28;
        String r11 = r10.getText();
    L29:
        String r12 = r1.j().getMessageId();
        k r13 = ((jc8.b) this).a;
        if (r13 == null) goto L32;
        Integer r14 = Integer.valueOf(x1.b(r13, r1, a.class));
    L33:
        if (r3 == null) goto L37;
        MessageReplyTextLoading r5 = r3.getTextLoading();
        if (r5 == null) goto L37;
        String r15 = r5.getIconUrl();
    L38:
        if (r3 == null) goto L42;
        MessageReplyTextLoading r16 = r3.getTextLoading();
        if (r16 == null) goto L42;
        String r17 = r16.getIconUrlDark();
    L43:
        cn8.a r18 = new cn8.a(r11, r12, r14, r15, r17, Boolean.valueOf(r7), Boolean.valueOf(r9));
        zm8.c r19 = this.f;
        if (r19 == null) goto L156;
        cn8.c r20 = (cn8.c) this.e.getValue();
        Intrinsics.checkNotNullParameter(r18, "vmData");
        e r21 = (e) r19.c.getValue();
        r21.getClass();
        Intrinsics.checkNotNullParameter(r18, "vmData");
        r21.a = r18;
        r21.b = r20;
        r21.c = new cn8.d();
        e r22 = (e) r19.c.getValue();
        cn8.a r23 = r22.a;
        if (r23 != null) goto L48;
        bn8.a r24 = new bn8.a(null, null, "", 1.0f, false, "", false, true);
    L71:
        cn8.d r25 = ((e) r19.c.getValue()).c;
        if (r25 != null) goto L74;
        r25 = new cn8.d();
    L74:
        ReplyTextLoadingView r27 = (ReplyTextLoadingView) r19.b.getValue();
        r27.getClass();
        Intrinsics.checkNotNullParameter(r24, "input");
        Intrinsics.checkNotNullParameter(r25, "output");
        Integer r28 = r24.a;
        if (r28 == null) goto L77;
        Integer r29 = Integer.valueOf(ContextCompat.getColor(r27.k.a.getContext(), r28.intValue()));
    L79:
        if (r24.h == false) goto L121;
        SpannableStringBuilder r30 = new SpannableStringBuilder();
        String r31 = r24.c;
        if (r31 != null) goto L83;
        r31 = "\u200b";
    L83:
        SpannableStringBuilder r32 = r30.append(r31);
        Intrinsics.checkNotNull(r32);
        boolean r33 = r24.e;
        float r34 = r24.d;
        if (r33 == false) goto L86;
        int r110 = 2131240674;
    L87:
        ThreeLoadingIndicator r111 = r27.l;
        if (r111 != null) goto L90;
    L94:
        TextView r112 = r27.k.c;
        r111 = new ThreeLoadingIndicator(r112, r110, r112.getContext(), null);
    L95:
        r27.l = r111;
        Iterator r113 = r111.b.iterator();
    L97:
        if (r113.hasNext() == false) goto L104;
        v0 r114 = (v0) r113.next();
        r114.c = r29;
        Drawable r115 = r114.b;
        if (r115 == null) goto L97;
        if (r29 != null) goto L102;
        DrawableCompat.setTintList(r115, null);
        goto L97
    L102:
        DrawableCompat.setTint(r115, r29.intValue());
        goto L97
    L104:
        Iterator r35 = r111.b.iterator();
    L106:
        if (r35.hasNext() == false) goto L120;
        v0 r116 = (v0) r35.next();
        if (r116 == null) goto L116;
        Drawable r117 = r116.getDrawable();
        if (r117 == null) goto L116;
        if (r33 == false) goto L113;
        float r118 = 1.0f;
    L114:
        int r119 = (int) (i5.r0() * r118);
        r117.setBounds(0, 0, r119, r119);
        goto L116
    L113:
        r118 = r34;
    L116:
        if (r32.length() != 0) goto L118;
        boolean r120 = true;
    L119:
        r116.f = r120;
        r32.append("⚫", r116, 17);
        goto L106
    L118:
        r120 = false;
        goto L119
    L120:
        r111.b(true);
        r111.d();
    L125:
        Intrinsics.checkNotNull(r32);
        Float r36 = r24.b;
        r27.k.c.setText(r32);
        if (r29 == null) goto L128;
        r27.k.c.setTextColor(r29.intValue());
    L128:
        if (r36 == null) goto L130;
        r27.k.c.setTextSize(0, r36.floatValue());
    L130:
        String r37 = r24.f;
        if (r37 != null) goto L133;
    L136:
        if (r4 == false) goto L138;
        e1.o(r27.k.b);
    L140:
        if (r24.g == false) goto L142;
        r27.b();
    L143:
        r27.m = Boolean.valueOf(r24.e);
        return;
    L142:
        r27.a();
        goto L143
    L138:
        e1.x(r27.k.b);
        ImageLoaderKt.u(r27.k.b, r37, "general_internet_search_icon");
        goto L140
    L133:
        if (r37.length() == 0) goto L136;
        r4 = false;
        goto L136
    L90:
        if (Intrinsics.areEqual(r27.m, Boolean.valueOf(r33)) == true) goto L93;
        r111 = null;
    L93:
        if (r111 != null) goto L95;
    L86:
        r110 = 2131240017;
        goto L87
    L121:
        SpannableStringBuilder r38 = new SpannableStringBuilder();
        String r39 = r24.c;
        if (r39 != null) goto L124;
        r39 = "";
    L124:
        r32 = r38.append(r39);
        goto L125
    L77:
        r29 = null;
        goto L79
    L48:
        cn8.b r40 = r22.b;
        if (r40 != null) goto L51;
        r24 = new bn8.a(null, null, "", 1.0f, false, "", false, true);
        goto L71
    L51:
        float r210 = r40.getFontScale();
        Boolean r41 = r23.f;
        Boolean r42 = Boolean.TRUE;
        if (Intrinsics.areEqual(r41, r42) == false) goto L55;
        int r43 = v19.c.b(2130972082, null, 2131103146);
    L59:
        if (r40.c() == false) goto L61;
        float r44 = we8.a.a(i5.o(), true);
    L63:
        if (Intrinsics.areEqual(r23.f, r42) == true) goto L65;
        String r211 = null;
    L70:
        r24 = new bn8.a(Integer.valueOf(r43), Float.valueOf(r44), r23.a, r210, r40.c(), r211, Intrinsics.areEqual(r23.f, r42), Intrinsics.areEqual(r23.g, r42));
        goto L71
    L65:
        if (r40.isDarkMode() == false) goto L67;
        String r121 = r23.e;
    L68:
        r211 = r121;
        goto L70
    L67:
        r121 = r23.d;
        goto L68
    L61:
        r44 = we8.a.a(i5.t(), false);
        goto L63
    L55:
        if (r40.c() == false) goto L57;
        r43 = 2131103298;
        goto L59
    L57:
        r43 = v19.c.b(2130972079, null, 2131103136);
        goto L59
    L156:
        return;
    L42:
        r17 = null;
    L37:
        r15 = null;
        goto L38
    L32:
        r14 = null;
    L28:
        r11 = null;
    L22:
        r9 = false;
    L14:
        r7 = false;
        goto L15
    L5:
        r3 = null;
        goto L6
    }

    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        zm8.c r0 = new zm8.c(r2.getContext());
        this.f = r0;
        ShimmerLinearLayout r3 = (ReplyTextLoadingView) r0.b.getValue();
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("standardView");
        return null;
    L6:
        return r3;
    }
}
