package com.larus.bot.impl.feature.edit.feature.firstmet.tts;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.bot.impl.databinding.LarusWidgetBotCreateTtsPlayerBinding;
import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/firstmet/tts/BotCreateTtsPlayerView;", "Landroid/widget/LinearLayout;", "Lcom/larus/bot/impl/feature/edit/feature/firstmet/tts/IBotCreateTtsPlayerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bot/impl/databinding/LarusWidgetBotCreateTtsPlayerBinding;", "disable", "", "playing", "loading", "static", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotCreateTtsPlayerView extends LinearLayout {
    public final LarusWidgetBotCreateTtsPlayerBinding a;

    public static final class a {
    }

    static {
    }

    public BotCreateTtsPlayerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BotCreateTtsPlayerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public BotCreateTtsPlayerView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        LayoutInflater.from(r5).inflate(2131563239, this);
        int r0 = 2131389950;
        LottieAdapterView r1 = ViewBindings.findChildViewById(this, 2131389950);
        if (r1 == null) goto L12;
        r0 = 2131389960;
        TextView r2 = (TextView) ViewBindings.findChildViewById(this, 2131389960);
        if (r2 == null) goto L12;
        this.a = new LarusWidgetBotCreateTtsPlayerBinding(this, r1, r2);
        TypedArray r8 = r5.obtainStyledAttributes(r6, new int[]{R.attr.text}, r7, r7);
        String r9 = r8.getString(0);
        if (r9 != null) goto L9;
        r9 = "";
    L9:
        r2.setText(r9);
        r8.recycle();
        return;
    L12:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r0)));
    }

    public /* synthetic */ BotCreateTtsPlayerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
