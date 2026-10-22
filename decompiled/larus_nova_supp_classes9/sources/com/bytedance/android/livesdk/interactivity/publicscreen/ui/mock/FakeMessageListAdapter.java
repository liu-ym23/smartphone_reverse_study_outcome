package com.bytedance.android.livesdk.interactivity.publicscreen.ui.mock;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Spannable;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenAccessibilityUtil;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.x;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.widget.a;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import g52.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/ui/mock/FakeMessageListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/ui/mock/FakeTextMessageViewHolder;", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FakeMessageListAdapter extends RecyclerView.Adapter<FakeTextMessageViewHolder> {
    public List<? extends Spannable> a;
    public e b;
    public float c;

    public final int getItemCount() {
        return this.a.size();
    }

    public FakeMessageListAdapter() {
        this.a = CollectionsKt.emptyList();
        this.c = UtilityKotlinExtentionsKt.h(12);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        FakeTextMessageViewHolder r11 = (FakeTextMessageViewHolder) r9;
        Intrinsics.checkNotNullParameter(r11, "holder");
        Spannable r13 = (Spannable) ListProtector.get(this.a, r10);
        Drawable r0 = r11.a.getBackground();
        if ((r0 instanceof GradientDrawable) == true) goto L5;
        r0 = null;
    L5:
        GradientDrawable r1 = (GradientDrawable) r0;
        if (r1 == null) goto L8;
        r1.setCornerRadius(this.c);
    L8:
        e r2 = this.b;
        TextView r3 = r11.a;
        String r4 = BuildConfig.FLAVOR;
        if (r13 == null) goto L11;
        CharSequence r5 = r13;
    L12:
        r3.setText(r5);
        if (r2 == null) goto L15;
        TextView r6 = r11.a;
        int r7 = e.j;
        r2.a(r6, true);
    L15:
        r11.a.setAlpha(1.0f);
        PublicScreenAccessibilityUtil r8 = PublicScreenAccessibilityUtil.a;
        TextView r14 = r11.a;
        r8.getClass();
        if (r14 == null) goto L53;
        if (r13 == null) goto L54;
        a[] r15 = (a[]) x.a(r13, r13.length(), a.class);
        if (r15 == null) goto L43;
        int r16 = 0;
        if (r15.length != 0) goto L25;
        boolean r17 = true;
    L27:
        if ((true ^ r17) == false) goto L43;
        String r18 = BuildConfig.FLAVOR;
        int r19 = 0;
        int r20 = 0;
        int r21 = 0;
    L30:
        if (r16 >= r13.length()) goto L44;
        if (r19 >= r15.length) goto L34;
        r20 = r13.getSpanStart(r15[r19]);
        r21 = r13.getSpanEnd(r15[r19]);
    L34:
        if (r20 > r16) goto L42;
        if (r21 < r16) goto L42;
        String r23 = r15[r19].a;
        if (r23 == null) goto L40;
        r4 = r4 + r23;
    L41:
        r16 = r21 + 1;
        r19 = r19 + 1;
        goto L30
    L40:
        r18 = r18 + r13.subSequence(r20, r21);
    L42:
        r18 = r18 + r13.charAt(r16);
        r16 = r16 + 1;
    L44:
        r3.a(r14, r18 + r4);
        return;
    L25:
        r17 = false;
    L43:
        r18 = String.valueOf(r14.getText());
        goto L44
    L54:
        return;
    L53:
        return;
    L11:
        r5 = BuildConfig.FLAVOR;
        goto L12
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        NoMoreSpaceTextView r8 = new NoMoreSpaceTextView(r6.getContext());
        r8.setId(2131388367);
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        r0.setCornerRadius(UtilityKotlinExtentionsKt.h(12));
        r0.setColor(l.b);
        Unit r2 = Unit.INSTANCE;
        r8.setBackground(r0);
        r8.setMinimumHeight(UtilityKotlinExtentionsKt.i(24));
        r8.setLineSpacing(PublicScreenStyleHelper.g, r8.getLineSpacingMultiplier());
        r8.setPadding(UtilityKotlinExtentionsKt.i(8), UtilityKotlinExtentionsKt.i(3), UtilityKotlinExtentionsKt.i(8), UtilityKotlinExtentionsKt.i(3));
        r8.setTextIsSelectable(false);
        r8.setTextAlignment(5);
        r8.setGravity(16);
        r8.setTypeface(Typeface.DEFAULT_BOLD);
        RelativeLayout r1 = new RelativeLayout(r6.getContext());
        r1.setId(2131377403);
        r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r1.setFocusable(true);
        r1.setFocusableInTouchMode(true);
        r1.setImportantForAccessibility(2);
        r1.addView(r8);
        return new FakeTextMessageViewHolder(r1);
    }
}
