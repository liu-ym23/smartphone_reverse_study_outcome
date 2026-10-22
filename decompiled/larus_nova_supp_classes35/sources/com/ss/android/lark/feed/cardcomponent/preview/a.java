package com.ss.android.lark.feed.cardcomponent.preview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.feed.app.entity.DigestElement;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends FeedCardComponent<b, FeedDigestTextView> {
    public static final int c = 0;
    public static final int d = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.feed.cardcomponent.preview.a$a, reason: collision with other inner class name */
    public static final class C0200a {
    }

    public static final class b {
        public final List<DigestElement> a;
        public final String b;
        public final String c;
        public int d;
        public int e;

        public b(List r1, int r2) {
            this.a = r1;
            this.b = null;
            this.c = null;
            this.d = r2;
            this.e = 16;
        }
    }

    static {
        UIHelper.dp2px(16.0f);
        c = UIHelper.dp2px(20.0f);
        d = UIHelper.dp2px(16.0f);
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        AppCompatTextView r0 = new FeedDigestTextView(getContext());
        r0.setLineHeight(c);
        r0.setSingleLine(true);
        r0.setGravity(16);
        r0.setMinHeight(d);
        r0.setEllipsize(TextUtils.TruncateAt.END);
        r0.setIncludeFontPadding(true);
        r0.setTextColor(UDColorUtils.getColor(r0.getContext(), 2131106620));
        r0.setTextSize(0, zz7.b.h(r0.getContext(), 14));
        return r0;
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final ViewGroup.MarginLayoutParams b() {
        return super.b();
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }
}
