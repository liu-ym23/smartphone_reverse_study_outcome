package oj8;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerLinearLayout;
import com.larus.bmhome.chat.markdown.code.ClickableMarkdownCodeView;
import com.larus.bmhome.chat.markdown.code.p0;
import com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view.FlowMarkdownCodeView;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import com.larus.im.bean.message.Message;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusFlowMarkdownCodeViewHeaderBinding;
import com.larus.mainbot.impl.databinding.MarkdownRenderCodeViewLayoutBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import qj8.e;
import qj8.f;
import qj8.g;
import qj8.h;
import qj8.m;
import rj8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final Context a;
    public final Lazy b;
    public final Lazy c;

    public final FlowMarkdownCodeView b() {
        return (FlowMarkdownCodeView) this.b.getValue();
    }

    public final void c() {
        FlowMarkdownCodeView r0 = b();
        ClickableMarkdownCodeView r1 = r0.a;
        if (r1 == null) goto L5;
        r1.p();
    L5:
        LarusFlowMarkdownCodeViewHeaderBinding r2 = r0.b;
        if (r2 == null) goto L10;
        ShimmerLinearLayout r3 = r2.a;
        if (r3 == null) goto L10;
        ExposeXTrackerExtKt.e(r3);
    L10:
        ClickableMarkdownCodeView r4 = r0.a;
        if (r4 == null) goto L13;
        ExposeXTrackerExtKt.e(r4);
    L13:
        g r5 = r0.f;
        if (r5 == null) goto L22;
        ClickableMarkdownCodeView r6 = r0.a;
        if (r6 == null) goto L20;
        Handler r7 = r6.getHandler();
        if (r7 == null) goto L20;
        r7.removeCallbacks(r5);
    L20:
        r0.f = null;
        return;
    }

    public final Context getContext() {
        return this.a;
    }

    public c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new a(this));
        this.c = LazyKt.lazy(new b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v29, types: [qj8.d] */
    /* JADX WARN: Type inference failed for: r3v30, types: [qj8.e] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Runnable, qj8.g] */
    public final void a(rj8.a r33, p0 r34) {
        Intrinsics.checkNotNullParameter(r33, "vmData");
        d r3 = (d) this.c.getValue();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r33, "vmData");
        r3.a = r33;
        r3.b = r34;
        final m r1 = ((d) this.c.getValue()).a();
        d r2 = (d) this.c.getValue();
        r2.getClass();
        final rj8.c r5 = new rj8.c(r2);
        final FlowMarkdownCodeView r8 = b();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r1, "input");
        Intrinsics.checkNotNullParameter(r5, "output");
        ClickableMarkdownCodeView r9 = r8.a;
        boolean r4 = false;
        if (r9 == null) goto L5;
        String r10 = r1.a;
        Message r11 = r1.b;
        boolean r12 = r1.c;
        Long r13 = r1.d;
        RecyclerView r15 = r1.g;
        ClickableMarkdownCodeView.n(r9, r10, r11, r12, r13, r1.f, r15, new qj8.a(r5, r8), r1.h, r1.i, new qj8.d(r5), new e(r8, r1, r5), null, FlowMarkdownCodeView.b(r1, false), r1.j, r1.k, r1.l, r1.t, r1.u, r1.v, r1.B, r1.y, 2048);
    L5:
        String r6 = r1.o;
        Intrinsics.checkNotNullParameter(r6, "info");
        List r7 = new Regex("\\s+").split(StringsKt.trim(r6).toString(), 2);
        String r14 = (String) ListProtector.get(r7, 0);
        String r16 = (String) CollectionsKt.getOrNull(r7, 1);
        if (r16 == null) goto L13;
        Sequence r17 = Regex.findAll$default(new Regex("(\\w+)=\"([^\"]*)\""), r16, 0, 2, null);
        if (r17 == null) goto L13;
        Map r18 = new LinkedHashMap();
        Iterator r19 = r17.iterator();
    L11:
        if (r19.hasNext() == false) goto L14;
        MatchResult r110 = (MatchResult) r19.next();
        Pair r111 = TuplesKt.to((String) ListProtector.get(r110.getGroupValues(), 1), (String) ListProtector.get(r110.getGroupValues(), 2));
        r18.put(r111.getFirst(), r111.getSecond());
    L14:
        Map r20 = r18;
        Intrinsics.checkNotNullParameter(r14, "realLanguage");
        Intrinsics.checkNotNullParameter(r20, "extraMap");
        ClickableMarkdownCodeView r21 = r8.a;
        if (r21 == null) goto L48;
        String r22 = r1.m;
        boolean r112 = r1.p;
        String r113 = r1.w;
        Integer r114 = r1.z;
        Integer r115 = r1.A;
        Intrinsics.checkNotNullParameter(r22, "code");
        Intrinsics.checkNotNullParameter(r14, "language");
        if (ClickableMarkdownCodeView.f(r14, r20) == 0) goto L32;
        Boolean r116 = r21.h;
        MarkdownRenderCodeViewLayoutBinding r23 = r21.Q;
        if (r23 == null) goto L27;
        FrameLayout r24 = r23.p;
        if (r24 == null) goto L27;
        if (r24.getVisibility() != 0) goto L25;
        boolean r25 = true;
    L26:
        Boolean r26 = Boolean.valueOf(r25);
    L29:
        if (Intrinsics.areEqual(r116, r26) == true) goto L32;
    L45:
        boolean r27 = true;
    L46:
        if (r27 == true) goto L48;
        boolean r28 = true;
    L49:
        if (r28 == true) goto L161;
        String r29 = r1.m;
        String r30 = r1.n;
        boolean r31 = r1.p;
        if (Intrinsics.areEqual(r20.get("type"), "interpreter") == true) goto L59;
        LarusFlowMarkdownCodeViewHeaderBinding r32 = r8.b;
        if (r32 == null) goto L127;
        ShimmerLinearLayout r35 = r32.a;
        if (r35 == null) goto L127;
        r35.setVisibility(8);
    L127:
        String r117 = r1.m;
        boolean r118 = r1.p;
        String r119 = r1.w;
        boolean r36 = r1.x;
        Integer r37 = r1.z;
        Integer r120 = r1.A;
        ClickableMarkdownCodeView r38 = r8.a;
        if (r38 == null) goto L133;
        r38.c(r117, r14, r118, r20, r119, r36, r37, r120);
        if (r8.d() == false) goto L132;
        r38.setVisibility(0);
        goto L133
    L132:
        r38.setVisibility(8);
    L133:
        r8.e();
        ?? r39 = new g(r8, r1, r5);
        r8.f = r39;
        r8.post(r39);
        ClickableMarkdownCodeView r40 = r8.a;
        if (r40 == null) goto L141;
        String r41 = r40.getLanguage();
        if (r41 != null) goto L139;
        r41 = "";
    L139:
        if (ClickableMarkdownCodeView.f(r41, r20) != 0) goto L141;
        r4 = true;
    L141:
        if (r4 == true) goto L143;
    L147:
        Integer r42 = r1.r;
        if (r42 == null) goto L152;
        int r43 = r42.intValue();
        ClickableMarkdownCodeView r44 = r8.a;
        if (r44 == null) goto L152;
        r44.setupMarkdownCodeLinearLayoutRes(Integer.valueOf(r43));
    L152:
        Integer r45 = r1.s;
        if (r45 == null) goto L159;
        int r46 = r45.intValue();
        ClickableMarkdownCodeView r47 = r8.a;
        if (r47 == null) goto L160;
        r47.setupExpandAllBackgroundResult(Integer.valueOf(r46));
        return;
    L160:
        return;
    L159:
        return;
    L143:
        if (r1.p == false) goto L147;
        FLogger.a.d("FlowMarkdownCodeView", "FlowMarkdownCodeView bindData can not show render tab, language: " + r1.o);
        ClickableMarkdownCodeView r48 = r8.a;
        if (r48 == null) goto L147;
        ExposeXTrackerExtKt.b(r48, new h(r8, r1, r5, null, 0 == true ? 1 : 0));
        goto L147
    L59:
        if (r8.d == true) goto L62;
        r8.c = true;
    L62:
        if (r8.b != null) goto L81;
        View r121 = LayoutInflater.from(r8.getContext()).inflate(2131562337, r8, false);
        ShimmerLinearLayout r122 = (ShimmerLinearLayout) r121;
        int r123 = 2131373016;
        AppCompatImageView r124 = ViewBindings.findChildViewById(r121, 2131373016);
        if (r124 == null) goto L80;
        r123 = 2131373017;
        SimpleDraweeView r210 = ViewBindings.findChildViewById(r121, 2131373017);
        if (r210 == null) goto L80;
        r123 = 2131373018;
        TextView r211 = (TextView) ViewBindings.findChildViewById(r121, 2131373018);
        if (r211 == null) goto L80;
        r8.b = new LarusFlowMarkdownCodeViewHeaderBinding(r122, r122, r124, r210, r211);
        r8.addView(r122, 0);
        LarusFlowMarkdownCodeViewHeaderBinding r125 = r8.b;
        if (r125 == null) goto L74;
        TextView r126 = r125.e;
        if (r126 == null) goto L74;
        we8.a.b(r126, MarkdownDimensExtKt.d(), false, null, null, 12);
    L74:
        LarusFlowMarkdownCodeViewHeaderBinding r127 = r8.b;
        if (r127 == null) goto L81;
        ShimmerLinearLayout r128 = r127.b;
        if (r128 == null) goto L81;
        r128.setOnClickListener(new f(r8, r5, r1));
    L80:
        throw new NullPointerException("Missing required view with ID: ".concat(r121.getResources().getResourceName(r123)));
    L81:
        LarusFlowMarkdownCodeViewHeaderBinding r129 = r8.b;
        if (r129 == null) goto L86;
        ShimmerLinearLayout r130 = r129.a;
        if (r130 == null) goto L86;
        r130.setVisibility(0);
    L86:
        LarusFlowMarkdownCodeViewHeaderBinding r131 = r8.b;
        if (r131 != null) goto L89;
    L110:
        r8.f(false, r8.c);
        if (o0.d(r30) == false) goto L122;
        LarusFlowMarkdownCodeViewHeaderBinding r49 = r8.b;
        if (r49 == null) goto L117;
        SimpleDraweeView r50 = r49.d;
        if (r50 == null) goto L117;
        e1.x(r50);
    L117:
        LarusFlowMarkdownCodeViewHeaderBinding r51 = r8.b;
        if (r51 == null) goto L127;
        SimpleDraweeView r52 = r51.d;
        if (r52 == null) goto L127;
        ImageLoaderKt.u(r52, r30, "general_internet_code_header_icon");
        goto L127
    L122:
        LarusFlowMarkdownCodeViewHeaderBinding r53 = r8.b;
        if (r53 == null) goto L127;
        SimpleDraweeView r54 = r53.d;
        if (r54 == null) goto L127;
        e1.o(r54);
        goto L127
    L89:
        if (r29.length() != 0) goto L91;
        boolean r55 = true;
    L93:
        if (r55 == false) goto L99;
        TextView r56 = r131.e;
        Context r57 = r8.getContext();
        if (r57 == null) goto L97;
        CharSequence r58 = r57.getString(2131900891);
    L98:
        r56.setText(r58);
        r131.c.setVisibility(8);
        r131.a.b();
        goto L110
    L97:
        r58 = null;
        goto L98
    L99:
        if (r31 == false) goto L105;
        r131.a.a();
        TextView r59 = r131.e;
        Context r60 = r8.getContext();
        if (r60 == null) goto L103;
        CharSequence r61 = r60.getString(2131900890);
    L104:
        r59.setText(r61);
        r131.c.setVisibility(0);
        goto L110
    L103:
        r61 = null;
        goto L104
    L105:
        r131.a.b();
        TextView r62 = r131.e;
        Context r63 = r8.getContext();
        if (r63 == null) goto L108;
        CharSequence r64 = r63.getString(2131900891);
    L109:
        r62.setText(r64);
        r131.c.setVisibility(0);
        goto L110
    L108:
        r64 = null;
        goto L109
    L91:
        r55 = false;
        goto L93
    L161:
        return;
    L25:
        r25 = false;
    L27:
        r26 = null;
    L32:
        if (Intrinsics.areEqual(r21.i, r22) == false) goto L45;
        if (Intrinsics.areEqual(r21.j, r14) == false) goto L45;
        if (r21.q != r112) goto L45;
        if (Intrinsics.areEqual(r21.l, r113) == false) goto L45;
        if (Intrinsics.areEqual(r21.o, r114) == false) goto L45;
        if (Intrinsics.areEqual(r21.p, r115) == false) goto L45;
        r27 = false;
    L48:
        r28 = false;
    L13:
        r18 = MapsKt.emptyMap();
        goto L14
    }
}
