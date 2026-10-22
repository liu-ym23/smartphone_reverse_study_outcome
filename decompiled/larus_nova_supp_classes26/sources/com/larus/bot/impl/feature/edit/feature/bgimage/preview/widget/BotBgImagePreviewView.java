package com.larus.bot.impl.feature.edit.feature.bgimage.preview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bot.impl.databinding.LarusLayoutBotBgImagePreviewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJA\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112%\b\u0002\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0013J\u0006\u0010\u0017\u001a\u00020\rJ\u0006\u0010\u0018\u001a\u00020\rJ\u0012\u0010\u0019\u001a\u00020\r2\b\b\u0001\u0010\u001a\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/preview/widget/BotBgImagePreviewView;", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/preview/widget/FixedAspectRatioConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bot/impl/databinding/LarusLayoutBotBgImagePreviewBinding;", "setBgImage", "", "uri", "Landroid/net/Uri;", "disableCache", "", "onFinalImageSet", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "setCurBitmapAsPlaceholder", "showColorPicking", "refreshShading", "color", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotBgImagePreviewView extends FixedAspectRatioConstraintLayout {
    public static final /* synthetic */ int e = 0;
    public final LarusLayoutBotBgImagePreviewBinding d;

    public static final class a {
    }

    static {
    }

    public BotBgImagePreviewView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BotBgImagePreviewView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BotBgImagePreviewView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        LayoutInflater.from(r8).inflate(2131562750, this);
        int r11 = 2131364882;
        FixedAspectRatioConstraintLayout r2 = (FixedAspectRatioConstraintLayout) ViewBindings.findChildViewById(this, 2131364882);
        if (r2 == null) goto L19;
        r11 = 2131364883;
        FixedAspectRatioConstraintLayout r3 = (FixedAspectRatioConstraintLayout) ViewBindings.findChildViewById(this, 2131364883);
        if (r3 == null) goto L19;
        r11 = 2131364884;
        FixedAspectRatioConstraintLayout r4 = (FixedAspectRatioConstraintLayout) ViewBindings.findChildViewById(this, 2131364884);
        if (r4 == null) goto L19;
        r11 = 2131374931;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(this, 2131374931);
        if (r5 == null) goto L19;
        r11 = 2131386030;
        View r6 = ViewBindings.findChildViewById(this, 2131386030);
        if (r6 == null) goto L19;
        r11 = 2131387036;
        if (ViewBindings.findChildViewById(this, 2131387036) == null) goto L19;
        r11 = 2131387038;
        if (ViewBindings.findChildViewById(this, 2131387038) == null) goto L19;
        this.d = new LarusLayoutBotBgImagePreviewBinding(this, r2, r3, r4, r5, r6);
        setAspectRatio(0.5f);
        setRadiusHeightRatio(0.0625f);
        setBackgroundColor(r8.getResources().getColor(2131103159));
        return;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r11)));
    }

    public /* synthetic */ BotBgImagePreviewView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
