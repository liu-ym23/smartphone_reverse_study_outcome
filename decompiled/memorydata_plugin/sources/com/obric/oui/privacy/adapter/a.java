package com.obric.oui.privacy.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.privacy.d;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/oui/privacy/adapter/PrivacyPermissionViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "cardListItem", "Lcom/obric/oui/lisitem/OCardListItem;", "(Lcom/obric/oui/lisitem/OCardListItem;)V", "contentContainer", "Landroid/widget/LinearLayout;", "bind", "", "item", "Lcom/obric/oui/privacy/PrivacyItem$PermissionItem;", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a extends RecyclerView.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0770a f14385a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OCardListItem f14386b;
    private final LinearLayout t;

    /* JADX INFO: renamed from: com.obric.oui.privacy.adapter.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/privacy/adapter/PrivacyPermissionViewHolder$Companion;", "", "()V", "create", "Lcom/obric/oui/privacy/adapter/PrivacyPermissionViewHolder;", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0770a {
        private C0770a() {
        }

        public /* synthetic */ C0770a(DefaultConstructorMarker r1) {
            this();
        }

        public final a a(Context r7) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "context");
            OCardListItem r6 = new OCardListItem(r1, null, 0, 6, null);
            r6.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            r6.b(false);
            r6.g(false);
            r6.e(false);
            return new a(r6);
        }
    }

    static {
        f14385a = new C0770a(null);
    }

    public a(OCardListItem r7) {
        Intrinsics.checkNotNullParameter(r7, "cardListItem");
        super((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"));
        this.f14386b = r7;
        r7.setCardType(2);
        OCardListItem.a(r7, 0, false, 2, null);
        LinearLayout r0 = new LinearLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r0.setOrientation(1);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.t = r0;
        r7.setCustomStartView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"));
        r7.a(true);
    }

    public final void a(d.a r24) {
        Intrinsics.checkNotNullParameter(r24, "item");
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f14386b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.t.removeAllViews();
        OTextView r4 = new OTextView((Context) ZeusTransformUtils.preCheckCast(new ContextThemeWrapper(r1, ZeusTransformUtils.mapRes(R.style.Body_1_Regular, "style", "Body_1_Regular")), Context.class, "com.obric.memorydata.plugin"), null, 0, null, 14, null);
        r4.setIncludeFontPadding(true);
        r4.setTextColor(ContextCompat.getColor(r1, ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1")));
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(r24.a(), CharSequence.class, "com.obric.memorydata.plugin"));
        int r8 = -1;
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-1, -2);
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        r6.setMargins(h.a(r1, 12), h.a(r1, 8), h.a(r1, 12), h.a(r1, 8));
        r4.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        this.t.addView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"));
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r24.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        LinearLayout r7 = new LinearLayout(r1);
        r7.setOrientation(0);
        r7.setGravity(48);
        r7.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(r8, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        LinearLayout r11 = new LinearLayout(r1);
        r11.setPadding(h.a((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"), 4), h.a((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"), 4), 0, 0);
        r11.setGravity(17);
        r11.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(h.a((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"), 24), h.a((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"), 20)), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        View r9 = new View(r1);
        int r13 = h.a(r9, 3.43d);
        r9.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(r13, r13), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        GradientDrawable r14 = new GradientDrawable();
        r14.setShape(1);
        r14.setColor(ContextCompat.getColor(r1, ZeusTransformUtils.mapRes(R.color.oui_basic_text_3b, TypedValues.Custom.S_COLOR, "oui_basic_text_3b")));
        r9.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r14, Drawable.class, "com.obric.memorydata.plugin"));
        r11.addView(r9);
        r7.addView((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"));
        OTextView r10 = new OTextView((Context) ZeusTransformUtils.preCheckCast(new ContextThemeWrapper(r1, ZeusTransformUtils.mapRes(R.style.Subtitle_2_Regular, "style", "Subtitle_2_Regular")), Context.class, "com.obric.memorydata.plugin"), null, 0, null, 14, null);
        r10.setIncludeFontPadding(true);
        r10.setTextColor(ContextCompat.getColor(r1, ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, TypedValues.Custom.S_COLOR, "oui_basic_text_3")));
        r10.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"));
        r10.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(0, -2, 1.0f), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r10.setPadding(0, h.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"), 4), 0, h.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"), 4));
        r7.addView((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"));
        this.t.addView((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"));
        r8 = -1;
        goto L4
    }
}
