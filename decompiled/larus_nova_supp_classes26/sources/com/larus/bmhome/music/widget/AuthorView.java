package com.larus.bmhome.music.widget;

import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.bmhome.share.panel.ShareType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tJ\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/music/widget/AuthorView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "fullText", "", "tailText", "setContent", "", "fullContent", "tail", "onMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "adjustContent", "width", "preCalculateLayout", "Landroid/text/StaticLayout;", "Landroid/widget/TextView;", ShareType.TEXT, "tvWidth", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthorView extends AppCompatTextView {
    public String a;
    public String b;

    public AuthorView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public AuthorView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = "";
        this.b = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r13, int r14) {
        int r0 = (View.MeasureSpec.getSize(r13) - getPaddingStart()) - getPaddingEnd();
        String r3 = this.a;
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 23) goto L8;
        StaticLayout.Builder r2 = StaticLayout.Builder.obtain(r3, 0, r3.length(), getPaint(), r0);
        if (r1 < 28) goto L7;
        r2.setUseLineSpacingFromFallbacks(true);
    L7:
        StaticLayout r4 = r2.build();
    L9:
        Intrinsics.checkNotNull(r4);
        if (r4.getLineCount() <= getMaxLines()) goto L19;
        int r5 = getMaxLines() - 1;
        int r6 = r4.getLineStart(r5);
        String r7 = this.a.substring(0, r6);
        CharSequence r8 = TextUtils.ellipsize(this.a.substring(r6), getPaint(), r0 - getPaint().measureText(this.b), TextUtils.TruncateAt.END);
        if (r5 != 0) goto L15;
        String r9 = r7 + r8 + this.b;
    L17:
        if (Intrinsics.areEqual(getText(), r9) == true) goto L19;
        setText(r9);
        goto L19
    L15:
        r9 = r7 + '\n' + r8 + this.b;
    L19:
        super.onMeasure(r13, r14);
        return;
    L8:
        r4 = new StaticLayout(r3, getPaint(), r0, Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), getIncludeFontPadding());
        goto L9
    }
}
