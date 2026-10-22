package com.larus.bmhome.bigimg;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.api.RenderLiteDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.photoviewer.PhotoViewerDialog;
import com.larus.platform.api.e4;
import com.larus.platform.api.u2;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f1 implements j19.g {
    public final /* synthetic */ BigImagePhotoViewerDialog a;
    public final /* synthetic */ List<n1> b;

    public final void S80(int r1) {
    }

    public final void onPageSelected(int r11) {
        BigImagePhotoViewerDialog r0 = this.a;
        int r1 = BigImagePhotoViewerDialog.V0;
        r0.x(r11);
        BigImagePhotoViewerDialog r2 = this.a;
        r2.getClass();
        AppHost.Companion r3 = AppHost.a;
        View r4 = null;
        if (r3.isOversea() == true) goto L25;
        k1 r5 = r2.k0;
        if (r5 == null) goto L8;
        l r6 = r5.a(r11);
    L9:
        if (r6 == null) goto L22;
        String r7 = r6.i;
        if (r7 != null) goto L13;
    L16:
        boolean r8 = true;
    L17:
        if (r8 == true) goto L22;
        ImageView r9 = r2.G;
        if (r9 == null) goto L25;
        com.larus.utils.e1.x(r9);
        goto L25
    L13:
        if (r7.length() == 0) goto L16;
        r8 = false;
    L22:
        ImageView r10 = r2.G;
        if (r10 == null) goto L25;
        com.larus.utils.e1.q(r10);
        goto L25
    L8:
        r6 = null;
    L25:
        final BigImagePhotoViewerDialog r12 = this.a;
        r12.getClass();
        if (r3.isOversea() == false) goto L83;
        k1 r13 = r12.k0;
        if (r13 == null) goto L31;
        l r14 = r13.a(r11);
    L32:
        if (r14 == null) goto L34;
        String r15 = r14.i;
    L35:
        if (r15 != null) goto L37;
    L40:
        boolean r16 = true;
    L41:
        if (r16 == false) goto L45;
        ViewGroup r17 = r12.H;
        if (r17 == null) goto L83;
        com.larus.utils.e1.o(r17);
        goto L83
    L45:
        if (r15 != null) goto L47;
    L50:
        boolean r18 = true;
    L51:
        if (r18 == false) goto L169;
    L57:
        String r19 = null;
    L58:
        if (r19 != null) goto L60;
    L63:
        boolean r20 = true;
    L64:
        if (r20 == false) goto L71;
        TextView r21 = r12.K;
        if (r21 == null) goto L68;
        r21.setTypeface(null, 0);
    L68:
        ViewGroup r22 = r12.H;
        if (r22 == null) goto L83;
        com.larus.utils.e1.o(r22);
        goto L83
    L71:
        TextView r23 = r12.K;
        if (r23 == null) goto L74;
        r23.setTypeface(null, 1);
    L74:
        ViewGroup r24 = r12.H;
        if (r24 == null) goto L77;
        com.larus.utils.e1.x(r24);
    L77:
        TextView r25 = r12.I;
        if (r25 == null) goto L80;
        r25.setText(r19);
    L80:
        ViewGroup r26 = r12.H;
        if (r26 == null) goto L83;
        com.larus.utils.e1.d(r26, new n0(r12));
        goto L83
    L60:
        if (r19.length() == 0) goto L63;
        r20 = false;
        goto L64
    L169:
        r19 = UriProtector.parse(r15).getHost();     // Catch: Exception -> L55
    L55:
        e = move-exception;
        FLogger.a.e("BigImagePhotoViewer", "Failed to extract domain from url: " + r15 + ", error: " + e.getMessage());
        goto L57
    L47:
        if (r15.length() == 0) goto L50;
        r18 = false;
        goto L51
    L37:
        if (r15.length() == 0) goto L40;
        r16 = false;
        goto L41
    L34:
        r15 = null;
        goto L35
    L31:
        r14 = null;
    L83:
        BigImagePhotoViewerDialog r27 = this.a;
        List<String> r28 = r27.x;
        if (r28 != null) goto L86;
    L101:
        Function1<? super Integer, Unit> r29 = this.a.L0;
        if (r29 == null) goto L104;
        r29.invoke(Integer.valueOf(r11));
    L104:
        BigImagePhotoViewerDialog r30 = this.a;
        r30.getClass();
        r30.p(0);
        BigImagePhotoViewerDialog r31 = this.a;
        r31.getClass();
        FLogger.a.d("BigImagePhotoViewer", "inflateLynxView pos = " + r11 + " lynxFooterView =" + r31.Q + "  templateURLs = " + r31.u);
        if (r31.u == null) goto L151;
        boolean r32 = !AppHost.a.isOversea();
        if (r31.Q != null) goto L122;
        if (r32 == true) goto L122;
        String r33 = (String) CollectionsKt.getOrNull(r31.u, r11);
        if (r33 == null) goto L146;
        com.larus.platform.service.c1 r34 = com.larus.platform.service.c1.a;
        r31.Q = u2.a.a(r31.q, r33, null, 12);
        r31.y(r11);
        FrameLayout r35 = r31.S;
        if (r35 == null) goto L118;
        e4 r36 = r31.Q;
        if (r36 == null) goto L117;
        r4 = r36.getView();
    L117:
        r35.addView(r4, -1, -2);
    L118:
        ConstraintLayout r37 = r31.P;
        if (r37 == null) goto L146;
        com.larus.utils.e1.o(r37);
    L146:
        List<String> r38 = r31.w;
        if (r38 == null) goto L151;
        String r39 = (String) CollectionsKt.getOrNull(r38, r11);
        if (r39 == null) goto L151;
        com.larus.platform.service.o.a.reportEvent("poi_fullscreen_show", new JSONObject(r39));
    L122:
        if (r31.R != null) goto L145;
        if (r32 == false) goto L145;
        String r40 = (String) CollectionsKt.getOrNull(r31.u, r11);
        if (r40 == null) goto L146;
        Ref.ObjectRef r41 = new Ref.ObjectRef();
        List<String> r42 = r31.v;
        if (r42 == null) goto L139;
        String r43 = (String) CollectionsKt.getOrNull(r42, r11);
        if (r43 == null) goto L139;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L132
        Object r45 = Result.constructor-impl(JSONObjectProtectorUtils.getString(new JSONObject(r43), "data"));     // Catch: Throwable -> L132
    L135:
        if (Result.exceptionOrNull-impl(r45) == null) goto L138;
        r45 = "";
    L138:
        r41.element = r45;
    L132:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
    L139:
        View r47 = RenderLiteDelegate.a.c(r31.q, r40, (String) r41.element);
        r31.R = r47;
        FrameLayout r48 = r31.S;
        if (r48 == null) goto L142;
        r48.addView(r47, -1, -2);
    L142:
        ConstraintLayout r49 = r31.P;
        if (r49 == null) goto L146;
        com.larus.utils.e1.o(r49);
    L145:
        r31.y(r11);
    L151:
        BigImagePhotoViewerDialog r50 = this.a;
        if (r50.r == false) goto L156;
        TextView r51 = r50.J;
        if (r51 == null) goto L156;
        StringBuilder r52 = new StringBuilder();
        r52.append(r11 + 1);
        r52.append('/');
        r52.append(this.b.size());
        r51.setText(r52.toString());
    L156:
        BigImagePhotoViewerDialog r53 = this.a;
        int r54 = r53.T;
        if (r54 == r11) goto L165;
        if (r54 == (-1)) goto L165;
        if (r11 <= r54) goto L162;
        String r55 = "next";
    L163:
        com.larus.platform.service.o r56 = com.larus.platform.service.o.a;
        JSONObject r57 = r53.h(((PhotoViewerDialog) r53).f);
        r57.put("status", r55);
        Unit r58 = Unit.INSTANCE;
        r56.reportEvent("slide", r57);
        this.a.T = r11;
        return;
    L162:
        r55 = "previous";
    L165:
        r53.T = r11;
        return;
    L86:
        if (r11 >= r28.size()) goto L98;
        String r59 = (String) ListProtector.get(r28, r11);
        if (com.larus.utils.o0.d(r59) == false) goto L95;
        TextView r60 = r27.K;
        if (r60 == null) goto L92;
        r60.setText(r59);
    L92:
        TextView r61 = r27.K;
        if (r61 == null) goto L101;
        r61.setVisibility(0);
        goto L101
    L95:
        TextView r62 = r27.K;
        if (r62 == null) goto L101;
        r62.setVisibility(8);
        goto L101
    L98:
        TextView r63 = r27.K;
        if (r63 == null) goto L101;
        r63.setVisibility(8);
        goto L101
    }

    public f1(BigImagePhotoViewerDialog r1, List<n1> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onPageSelected(int r2, boolean r3) {
        if (r3 == false) goto L7;
        BigImagePhotoViewerDialog r4 = this.a;
        int r0 = BigImagePhotoViewerDialog.V0;
        r4.q(r2, "slide");
        e r5 = this.a.p0;
        if (r5 == null) goto L8;
        r5.b(r2, null);
        return;
    L8:
        return;
    }
}
