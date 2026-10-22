package com.bytedance.android.live.liveinteract.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/liveinteract/view/MicSeatSponsorView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/live/core/widget/HSImageView;", "a", "Lcom/bytedance/android/live/core/widget/HSImageView;", "getImgAvatar", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "setImgAvatar", "(Lcom/bytedance/android/live/core/widget/HSImageView;)V", "imgAvatar", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MicSeatSponsorView extends LinearLayout {
    public HSImageView a;

    public MicSeatSponsorView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MicSeatSponsorView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final HSImageView getImgAvatar() {
        return this.a;
    }

    public final void setImgAvatar(HSImageView r1) {
        this.a = r1;
    }

    public final void a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "avatarUrl");
        if (r4 == null) goto L8;
        GradientDrawable r0 = new GradientDrawable();
        r0.setColor(Color.parseColor(r4));     // Catch: Exception -> L7
        r0.setStroke(UtilityKotlinExtentionsKt.i(1), Color.parseColor("#99FFFFFF"));     // Catch: Exception -> L7
        r0.setCornerRadius(UtilityKotlinExtentionsKt.i(9));     // Catch: Exception -> L7
        setBackground(r0);     // Catch: Exception -> L7
    L8:
        HSImageView r5 = this.a;
        if (r5 == null) goto L14;
        r5.setImageURI(r3);
        return;
    }

    public MicSeatSponsorView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131566931, this);
        setLayoutParams(new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.i(40), UtilityKotlinExtentionsKt.i(18)));
        setGravity(16);
        setOrientation(0);
        this.a = findViewById(2131375156);
    }

    public /* synthetic */ MicSeatSponsorView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
