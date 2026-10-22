package xdb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.feed.cardcomponent.titleright.TitleRightView;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends FeedCardComponent<b, TitleRightView> {
    public final int c;
    public final int d;

    /* JADX INFO: renamed from: xdb.a$a, reason: collision with other inner class name */
    public static final class C0319a {
    }

    public static final class b {
        public final String a;
        public final Drawable b;

        public b(String r3, Drawable r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 2) == 0) goto L8;
            r4 = null;
        L8:
            this.a = r3;
            this.b = r4;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        return new TitleRightView(getContext());
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = 2131101980;
        this.d = 12;
    }

    public final void d(b r8) {
        Intrinsics.checkNotNullParameter(r8, Keys.API_RETURN_KEY_DATA);
        TitleRightView r0 = c();
        String r1 = r8.a;
        Drawable r9 = r8.b;
        TextView r6 = null;
        if (r9 == null) goto L15;
        AppCompatImageView r2 = r0.b;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("flagView");
        r2 = null;
    L7:
        r2.setImageDrawable(r9);
        ImageView r10 = r0.b;
        if (r10 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("flagView");
        r10 = null;
    L10:
        r10.setVisibility(0);
        TextView r11 = r0.a;
        if (r11 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L14:
        r6.setVisibility(8);
    L38:
        c().setTextViewColorRes(this.c);
        c().setTextViewTextSize(this.d);
        return;
    L13:
        r6 = r11;
        goto L14
    L15:
        ImageView r12 = r0.b;
        if (r12 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("flagView");
        r12 = null;
    L18:
        r12.setVisibility(8);
        TextView r13 = r0.a;
        if (r13 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r13 = null;
    L21:
        r13.setVisibility(0);
        TextView r14 = r0.a;
        if (r14 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r14 = null;
    L24:
        r14.setText(null);
        if (r1 == null) goto L33;
        TextView r15 = r0.a;
        if (r15 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r15 = null;
    L29:
        r15.setText(r1);
        TextView r16 = r0.a;
        if (r16 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r16 = null;
    L32:
        r16.setBackground(null);
        goto L38
    L33:
        TextView r17 = r0.a;
        if (r17 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L37:
        r6.setVisibility(8);
        goto L38
    L36:
        r6 = r17;
        goto L37
    }
}
