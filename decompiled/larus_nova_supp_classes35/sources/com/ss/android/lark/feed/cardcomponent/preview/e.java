package com.ss.android.lark.feed.cardcomponent.preview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends FeedCardComponent<b, ImageView> {
    public static final int c = 0;
    public static final int d = 0;

    public static final class a {
    }

    public static final class b {
        public final boolean a;

        public b(boolean r1) {
            this.a = r1;
        }
    }

    static {
        c = UIHelper.dp2px(14.0f);
        d = UIHelper.dp2px(16.0f);
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final ViewGroup.MarginLayoutParams b() {
        int r1 = c;
        ViewGroup.MarginLayoutParams r0 = new ViewGroup.MarginLayoutParams(r1, r1);
        r0.leftMargin = d;
        return r0;
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        Drawable r0 = UDIconUtils.getIconDrawable(getContext(), 2131253620, getContext().getResources().getColor(2131102420));
        ImageView r1 = new ImageView(getContext());
        r1.setBackground(r0);
        return r1;
    }

    public e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final void d(b r2) {
        Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_DATA);
        ImageView r0 = c();
        if (r2.a == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }
}
