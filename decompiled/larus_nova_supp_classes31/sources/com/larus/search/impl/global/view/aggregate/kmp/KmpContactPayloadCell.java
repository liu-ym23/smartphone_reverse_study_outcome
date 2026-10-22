package com.larus.search.impl.global.view.aggregate.kmp;

import android.content.res.TypedArray;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.flow.search.kmp.api.model.FlowQuery;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.ContactPayload;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.extension.aggregate_search_ui.api.BaseSearchListCell;
import com.larus.extension.aggregate_search_ui.api.ILarkAvatarView;
import com.larus.extension.aggregate_search_ui.api.ILarkAvatarViewProvider;
import com.larus.image.loader.ImageLoaderKt;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0013H\u0002J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0013H\u0002J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0006H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/search/impl/global/view/aggregate/kmp/KmpContactPayloadCell;", "Lcom/larus/extension/aggregate_search_ui/api/BaseSearchListCell;", "Lcom/larus/search/impl/global/view/aggregate/kmp/KmpContactSearchCellState;", "<init>", "()V", "layoutId", "", "getLayoutId", "()I", "avatarContainer", "Landroid/widget/FrameLayout;", "avatarView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "larkAvatarView", "Lcom/larus/extension/aggregate_search_ui/api/ILarkAvatarView;", "titleView", "Landroid/widget/TextView;", "subtitleView", "boundData", "Lcom/bytedance/flow/search/kmp/api/model/payload/ContactPayload;", "onViewCreated", "", "view", "Landroid/view/View;", "onBindView", "state", "position", "buildDisplayContent", "Lcom/larus/search/impl/global/view/aggregate/kmp/ContactDisplayContent;", "payload", "bindAvatar", "renderHighlightedText", "", "content", "", "highlightColor", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class KmpContactPayloadCell extends BaseSearchListCell<i> {
    public final int a;
    public FrameLayout b;
    public SimpleDraweeView c;
    public ILarkAvatarView d;
    public TextView e;
    public TextView f;
    public ContactPayload g;

    public KmpContactPayloadCell() {
        this.a = 2131562645;
    }

    public final int getLayoutId() {
        return this.a;
    }

    public final void onViewCreated(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        this.b = (FrameLayout) r6.findViewById(2131363653);
        this.c = r6.findViewById(2131375057);
        this.e = (TextView) r6.findViewById(2131388498);
        this.f = (TextView) r6.findViewById(2131388497);
        ILarkAvatarViewProvider r0 = (ILarkAvatarViewProvider) ServiceManager.get().getService(ILarkAvatarViewProvider.class);
        if (r0 == null) goto L19;
        FrameLayout r1 = this.b;
        FrameLayout r3 = null;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
        r1 = null;
    L7:
        ILarkAvatarView r2 = r0.getView(r1.getContext());
        if (r2 == null) goto L19;
        this.d = r2;
        if ((r2 instanceof View) == false) goto L12;
        View r4 = (View) r2;
    L13:
        if (r4 == null) goto L19;
        r4.setVisibility(8);
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        FrameLayout r5 = this.b;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
    L18:
        r3.addView(r4);
        goto L19
    L17:
        r3 = r5;
        goto L18
    L12:
        r4 = null;
    L19:
        r6.setOnClickListener(new g(this));
    }

    public static CharSequence b(String r9, int r10) {
        if (StringsKt.isBlank(r9) == false) goto L6;
        return "";
    L6:
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        int r1 = 0;
    L8:
        if (r1 >= r9.length()) goto L18;
        int r2 = StringsKt.indexOf$default(r9, "<h>", r1, false, 4, null);
        if (r2 < 0) goto L11;
        if (r2 <= r1) goto L14;
        r0.append(r9.substring(r1, r2));
    L14:
        int r3 = r2 + 3;
        int r4 = StringsKt.indexOf$default(r9, "</h>", r3, false, 4, null);
        if (r4 < 0) goto L16;
        String r5 = r9.substring(r3, r4);
        int r6 = r0.length();
        r0.append(r5);
        r0.setSpan(new ForegroundColorSpan(r10), r6, r0.length(), 33);
        r1 = r4 + 4;
        goto L8
    L16:
        r0.append(r9.substring(r3));
        goto L18
    L11:
        r0.append(r9.substring(r1));
    L18:
        return r0;
    }

    public final void onBindView(View r28, ei9.f r29, int r30) {
        i r1 = (i) r29;
        Intrinsics.checkNotNullParameter(r28, "view");
        Intrinsics.checkNotNullParameter(r1, "state");
        ContactPayload r2 = r1.a;
        this.g = r2;
        TypedArray r3 = r28.getContext().obtainStyledAttributes(new int[]{2130972123});
        int r5 = r3.getColor(0, 0);
        r3.recycle();
        String r4 = r2.l;
        if (StringsKt.isBlank(r4) == false) goto L5;
        r4 = r2.c();
    L5:
        View r14 = null;
        if (StringsKt.endsWith$default(r4, ")", false, 2, null) == false) goto L9;
        Pair r7 = TuplesKt.to('(', ')');
    L11:
        char r8 = ((Character) r7.component1()).charValue();
        char r15 = ((Character) r7.component2()).charValue();
        String r9 = r4;
        int r12 = StringsKt.lastIndexOf$default(r9, r8, 0, false, 6, null);
        int r10 = StringsKt.lastIndexOf$default(r9, r15, 0, false, 6, null);
        if (r12 <= 0) goto L24;
        int r13 = r12 + 1;
        if (r10 <= r13) goto L24;
        if (r10 != StringsKt.getLastIndex(r4)) goto L24;
        String r11 = StringsKt.trim(r4.substring(0, r12)).toString();
        String r16 = StringsKt.trim(r4.substring(r13, r10)).toString();
        if (StringsKt.isBlank(r11) == true) goto L24;
        if (StringsKt.isBlank(r16) == true) goto L24;
        Pair r17 = TuplesKt.to(r11, r16);
    L25:
        if (r17 == null) goto L34;
        String r18 = (String) r17.getFirst();
        if (r18 == null) goto L34;
        if (StringsKt.isBlank(r18) == false) goto L31;
        r18 = r4;
    L31:
        if (r18 == null) goto L34;
        r4 = r18;
    L34:
        String r19 = StringsKt.trim(r2.m).toString();
        int r20 = r2.i;
        if (r20 == 1) goto L47;
        if (r20 != 2) goto L38;
    L46:
        boolean r21 = true;
    L49:
        if (r21 == false) goto L52;
        a r6 = new a(r4, r19);
    L102:
        TextView r22 = this.e;
        if (r22 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r22 = null;
    L105:
        r22.setText(b(r6.a, r5));
        if (StringsKt.isBlank(r6.b) == false) goto L114;
        TextView r23 = this.f;
        if (r23 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("subtitleView");
        r23 = null;
    L110:
        r23.setVisibility(8);
        TextView r24 = this.f;
        if (r24 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("subtitleView");
        r24 = null;
    L113:
        r24.setText("");
    L121:
        String r25 = r2.c();
        if ((!StringsKt.isBlank(r2.n)) == true) goto L124;
    L139:
        View r26 = this.d;
        if ((r26 instanceof View) == false) goto L142;
        View r27 = r26;
    L143:
        if (r27 == null) goto L145;
        r27.setVisibility(8);
    L145:
        ILarkAvatarView r31 = this.d;
        if (r31 == null) goto L148;
        r31.clearDrawable();
    L148:
        ImageView r32 = this.c;
        if (r32 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        r32 = null;
    L151:
        r32.setVisibility(0);
        Uri r33 = new Uri.Builder().scheme("res").path(String.valueOf(2131240119)).build();
        View r34 = this.c;
        if (r34 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
    L155:
        ImageLoaderKt.s(r14, r33, "aggregate_search_contact");
        return;
    L154:
        r14 = r34;
        goto L155
    L142:
        r27 = null;
        goto L143
    L124:
        if ((!StringsKt.isBlank(r25)) == false) goto L139;
        ImageView r35 = this.c;
        if (r35 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        r35 = null;
    L128:
        r35.setVisibility(8);
        SimpleDraweeView r36 = this.c;
        if (r36 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        r36 = null;
    L131:
        ImageLoaderKt.e(r36);
        View r37 = this.d;
        if ((r37 instanceof View) == false) goto L134;
        r14 = r37;
    L134:
        if (r14 == null) goto L136;
        r14.setVisibility(0);
    L136:
        ILarkAvatarView r38 = this.d;
        if (r38 == null) goto L157;
        r38.bind(r2.n, r25);
        return;
    L157:
        return;
    L114:
        TextView r39 = this.f;
        if (r39 != null) goto L117;
        Intrinsics.throwUninitializedPropertyAccessException("subtitleView");
        r39 = null;
    L117:
        r39.setVisibility(0);
        TextView r40 = this.f;
        if (r40 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("subtitleView");
        r40 = null;
    L120:
        r40.setText(b(r6.b, r5));
        goto L121
    L52:
        if (r2.i == 2) goto L79;
        String r41 = StringsKt.trim(r2.m).toString();
        FlowQuery r42 = ((ISearchDataPayload) r2).e;
        if (r42 == null) goto L57;
        String r43 = r42.a;
    L58:
        if (r43 != null) goto L60;
        r43 = "";
    L60:
        String r44 = StringsKt.trim(r43).toString();
        String r110 = h.b(r41);
        if (r110 == null) goto L69;
        if (Intrinsics.areEqual(r44, r110) == false) goto L69;
        if (h.a(r41) == true) goto L80;
        r41 = r28.getContext().getString(2131898078, new Object[]{r41});
    L80:
        if (r41 == null) goto L83;
        r6 = new a(r4, r41);
        goto L102
    L83:
        if (h.a(r19) == false) goto L86;
        r6 = new a(r4, "");
        goto L102
    L86:
        if (StringsKt.isBlank(r19) == false) goto L89;
        r6 = new a(r4, "");
        goto L102
    L89:
        if (StringsKt.contains$default(r19, "昵称:", false, 2, null) == false) goto L91;
    L98:
        boolean r45 = true;
    L99:
        if (r45 == false) goto L101;
        r19 = StringsKt.replace$default(StringsKt.replace$default(r19, "昵称:", "昵称：", false, 4, null), "暱稱:", "暱稱：", false, 4, null);
    L101:
        r6 = new a(r4, r19);
        goto L102
    L91:
        if (StringsKt.contains$default(r19, "昵称：", false, 2, null) == true) goto L98;
        if (StringsKt.contains$default(r19, "暱稱:", false, 2, null) == true) goto L98;
        if (StringsKt.contains$default(r19, "暱稱：", false, 2, null) == true) goto L98;
        r45 = false;
    L69:
        if (h.a(r19) == false) goto L71;
        String r46 = r19;
    L72:
        if (r46 == null) goto L74;
        String r47 = h.b(r46);
    L75:
        if (r47 == null) goto L79;
        if (Intrinsics.areEqual(r44, r47) == false) goto L79;
        r41 = r19;
        goto L80
    L74:
        r47 = null;
        goto L75
    L71:
        r46 = null;
        goto L72
    L57:
        r43 = null;
    L79:
        r41 = null;
        goto L80
    L38:
        if (StringsKt.isBlank(r2.o) == true) goto L47;
        if (StringsKt.startsWith(r19, "includes", true) == true) goto L46;
        if (StringsKt.startsWith$default(r19, "包含", false, 2, null) == true) goto L46;
        if (StringsKt.contains(r19, "includes:", true) == true) goto L46;
    L47:
        r21 = false;
    L24:
        r17 = null;
        goto L25
    L9:
        if (StringsKt.endsWith$default(r4, "）", false, 2, null) == false) goto L24;
        r7 = TuplesKt.to((char) 65288, (char) 65289);
        goto L11
    }
}
