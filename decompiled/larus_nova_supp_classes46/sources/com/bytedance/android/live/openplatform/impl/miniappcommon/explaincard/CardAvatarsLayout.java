package com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdk.utils.t6;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/explaincard/CardAvatarsLayout;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardAvatarsLayout extends RelativeLayout {
    public CardAvatarsLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CardAvatarsLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(List<? extends ImageModel> r8) {
        removeAllViews();
        if (r8 == null) goto L29;
        Iterator<T> r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L40;
        List r0 = ((ImageModel) r9.next()).getUrls();
        if (r0 == null) goto L6;
        Iterator r1 = r0.iterator();
    L11:
        if (r1.hasNext() == false) goto L22;
        Object r2 = r1.next();
        String r3 = (String) r2;
        if (r3 != null) goto L15;
    L18:
        boolean r4 = true;
    L20:
        if ((!r4) == false) goto L11;
    L23:
        String r5 = (String) r2;
        if (r5 == null) goto L6;
        Intrinsics.checkNotNullParameter(r5, "url");
        SimpleDraweeView r6 = new SimpleDraweeView(getContext());
        r6.setId(ViewCompat.generateViewId());
        RelativeLayout.LayoutParams r7 = new RelativeLayout.LayoutParams((int) t6.a(r6.getContext(), 13.0f), (int) t6.a(r6.getContext(), 13.0f));
        if (getChildCount() == 0) goto L28;
        r7.addRule(1, getChildAt(getChildCount() - 1).getId());
        r7.leftMargin = (int) t6.a(r6.getContext(), -5.0f);
    L28:
        Unit r10 = Unit.INSTANCE;
        r6.setLayoutParams(r7);
        r6.getHierarchy().setRoundingParams(RoundingParams.asCircle().setBorder(-1, t6.a(r6.getContext(), 0.5f)));
        r6.setImageURI(r5);
        addView(r6);
        goto L6
    L15:
        if (r3.length() == 0) goto L18;
        r4 = false;
        goto L20
    L22:
        r2 = null;
        goto L23
    L40:
        return;
    }

    public CardAvatarsLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ CardAvatarsLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
