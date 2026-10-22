package eb8;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.im.bean.message.block.BizMergeForwardBlock;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k extends jc8.b<fb8.b> {
    public fb8.b d;
    public TextView e;
    public TextView f;

    public static final class a {
    }

    static {
    }

    @Override // jc8.b
    public final String c() {
        return "BizMergeForwardBlockHolder";
    }

    public k() {
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r5) {
        Intrinsics.checkNotNullParameter((fb8.b) r5, "blockModel");
        return new jc8.d(c7.b(16), c7.b(8), 0, c7.b(8));
    }

    @Override // jc8.b
    public final void g(jc8.a r12) {
        fb8.b r13 = (fb8.b) r12;
        Intrinsics.checkNotNullParameter(r13, "blockModel");
        this.d = r13;
        kc8.b r0 = (kc8.b) jc8.c.a(this, kc8.b.class);
        if (r0 == null) goto L12;
        kc8.y r1 = r0.a;
        if (r1 == null) goto L12;
        Function1<Boolean, Unit> r2 = r1.B;
        if (r2 == null) goto L9;
        r2.invoke(Boolean.FALSE);
    L9:
        Function0<Unit> r3 = r1.C;
        if (r3 == null) goto L12;
        r3.invoke();
    L12:
        BlockContent r4 = r13.a.getContent();
        String r5 = null;
        if (r4 == null) goto L15;
        BizMergeForwardBlock r6 = r4.getBizMergeForwardBlock();
    L16:
        TextView r7 = this.e;
        if (r7 == null) goto L20;
        Context r8 = r7.getContext();
        if (r8 == null) goto L20;
    L24:
        String r9 = "";
        if (r6 == null) goto L33;
        String r10 = r6.getBrief();
        if (r10 == null) goto L33;
        if ((!StringsKt.isBlank(r10)) == true) goto L32;
        r10 = null;
    L32:
        if (r10 == null) goto L33;
    L46:
        if (r6 == null) goto L50;
        Long r11 = r6.getBizMessageCount();
        if (r11 == null) goto L50;
        int r14 = (int) r11.longValue();
    L55:
        FLogger r15 = FLogger.a;
        StringBuilder r16 = new StringBuilder("bind merge forward card, msgId=");
        r16.append(r13.j().getMessageId());
        r16.append(", blockCount=");
        r16.append(r14);
        r16.append(", hasBlock=");
        if (r6 == null) goto L58;
        boolean r17 = true;
    L59:
        r16.append(r17);
        r15.d("BizMergeForwardBlockHolder", r16.toString());
        TextView r18 = this.e;
        if (r18 == null) goto L62;
        r18.setText(r10);
    L62:
        TextView r19 = this.f;
        if (r19 == null) goto L78;
        if (r14 <= 0) goto L71;
        if (r8 == null) goto L69;
        Resources r20 = r8.getResources();
        if (r20 == null) goto L69;
        r5 = r20.getQuantityString(2131755091, r14, new Object[]{Integer.valueOf(r14)});
    L69:
        if (r5 == null) goto L76;
    L75:
        r9 = r5;
    L76:
        r19.setText(r9);
        return;
    L71:
        if (r8 == null) goto L73;
        r5 = r8.getString(2131898271);
    L73:
        if (r5 != null) goto L75;
    L78:
        return;
    L58:
        r17 = false;
    L50:
        if (r6 == null) goto L54;
        List r21 = r6.getBizMessageIds();
        if (r21 == null) goto L54;
        r14 = r21.size();
    L54:
        r14 = 0;
    L33:
        r10 = r13.j().getBrief();
        if (r10 != null) goto L36;
    L38:
        r10 = null;
    L39:
        if (r10 != null) goto L46;
        if (r8 == null) goto L42;
        r10 = r8.getString(2131900194);
    L43:
        if (r10 != null) goto L46;
        r10 = "";
        goto L46
    L42:
        r10 = null;
        goto L43
    L36:
        if ((!StringsKt.isBlank(r10)) == false) goto L38;
    L20:
        TextView r22 = this.f;
        if (r22 == null) goto L23;
        r8 = r22.getContext();
        goto L24
    L23:
        r8 = null;
        goto L24
    L15:
        r6 = null;
        goto L16
    }

    @Override // jc8.b
    public final View h(ViewGroup r11) {
        Intrinsics.checkNotNullParameter(r11, "viewGroup");
        FrameLayout r0 = new FrameLayout(r11.getContext());
        Context r12 = r0.getContext();
        GradientDrawable r1 = new GradientDrawable();
        r1.setShape(0);
        r1.setCornerRadius(c7.b(8));
        r1.setColor(v19.c.a(2130970529, r12, 2131102529));
        r1.setStroke(c7.b(1), v19.c.a(2130972087, r12, 2131103162));
        IFlowThemeConfigProvider r13 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r13 == null) goto L5;
        IFlowThemeConfigProvider.a.a(r13, r1, ThemeColorKey.MESSAGE_BUBBLE_COLOR, ThemeConfigScene.CHAT, AdaptThemeFeatureKey.SEND_MESSAGE_BUBBLE);
    L5:
        r0.setBackground(r1);
        r0.setLayoutParams(new ViewGroup.LayoutParams(c7.b(190), c7.b(84)));
        r0.setClickable(true);
        r0.setOnClickListener(new i(this));
        r0.setOnLongClickListener(new j(this));
        TextView r14 = new TextView(r0.getContext());
        r14.setTextColor(v19.c.a(2130972079, r14.getContext(), 2131103136));
        IFlowThemeConfigProvider r2 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r2 == null) goto L8;
        r2.d(r14, ThemeColorKey.MESSAGE_SEND_TEXT_COLOR, ThemeConfigScene.CHAT, AdaptThemeFeatureKey.SEND_MESSAGE_TEXT);
    L8:
        r14.setTextSize(0, r14.getResources().getDimension(v19.c.b(2130972273, null, 2131167616)));
        r14.setMaxLines(2);
        r14.setEllipsize(TextUtils.TruncateAt.END);
        r14.setIncludeFontPadding(false);
        r14.setLineSpacing(0.0f, 1.2f);
        this.e = r14;
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-1, c7.b(46));
        r4.leftMargin = c7.b(9);
        r4.rightMargin = c7.b(9);
        r4.topMargin = c7.b(9);
        Unit r6 = Unit.INSTANCE;
        r0.addView(r14, r4);
        LinearLayout r15 = new LinearLayout(r0.getContext());
        r15.setOrientation(0);
        r15.setGravity(16);
        ImageView r5 = new ImageView(r15.getContext());
        r5.setImageResource(2131241531);
        r5.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r15.addView(r5, new LinearLayout.LayoutParams(c7.b(14), c7.b(14)));
        TextView r7 = new TextView(r15.getContext());
        r7.setTextColor(v19.c.a(2130972082, r7.getContext(), 2131103146));
        IFlowThemeConfigProvider r8 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r8 == null) goto L11;
        r8.d(r7, ThemeColorKey.MESSAGE_SEND_TEXT_COLOR, ThemeConfigScene.CHAT, AdaptThemeFeatureKey.SEND_MESSAGE_TEXT);
    L11:
        r7.setTextSize(0, r7.getResources().getDimension(v19.c.b(2130972270, null, 2131167610)));
        r7.setMaxLines(1);
        r7.setEllipsize(TextUtils.TruncateAt.END);
        r7.setIncludeFontPadding(false);
        r7.setLineSpacing(0.0f, 1.0f);
        this.f = r7;
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-2, -2);
        r3.leftMargin = c7.b(4);
        r15.addView(r7, r3);
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-2, -2, 8388691);
        r9.leftMargin = c7.b(7);
        r9.bottomMargin = c7.b(7);
        r0.addView(r15, r9);
        return r0;
    }
}
