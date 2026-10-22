package com.bytedance.android.livesdk.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/common/GameNetStateView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameNetStateView extends LinearLayout {
    public GameNetStateView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GameNetStateView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public GameNetStateView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        setOrientation(0);
        setBackground(s1.m(2131249710));
        setPadding(UtilityKotlinExtentionsKt.i(8), 0, UtilityKotlinExtentionsKt.i(8), 0);
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-2, -1);
        r7.gravity = 16;
        TextView r0 = new TextView(r4);
        r0.setGravity(17);
        r0.setTextSize(10.0f);
        r0.setTextColor(s1.h(2131109391));
        r0.setLayoutParams(r7);
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(s1.f(16.0f), s1.f(16.0f));
        r8.gravity = 16;
        ImageView r9 = new ImageView(r4);
        r9.setLayoutParams(r8);
        r9.setImageResource(2131252846);
        addView(r9);
        addView(r0);
    }

    public /* synthetic */ GameNetStateView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
