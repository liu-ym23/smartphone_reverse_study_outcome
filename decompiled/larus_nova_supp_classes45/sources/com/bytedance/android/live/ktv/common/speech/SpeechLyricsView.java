package com.bytedance.android.live.ktv.common.speech;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.component.lyric.ViewPainter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/ktv/common/speech/SpeechLyricsView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/component/lyric/ViewPainter;", "getLyricsView", "Landroid/widget/TextView;", "getAiTipsTextView", "Landroid/widget/ImageView;", "getAiTagView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SpeechLyricsView extends ConstraintLayout {
    public ViewPainter a;
    public TextView b;
    public ImageView c;

    public SpeechLyricsView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SpeechLyricsView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final ImageView getAiTagView() {
        return this.c;
    }

    public final TextView getAiTipsTextView() {
        return this.b;
    }

    public final ViewPainter getLyricsView() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SpeechLyricsView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131567014, this);
        this.a = findViewById(2131392574);
        this.b = (TextView) findViewById(2131383906);
        this.c = (ImageView) findViewById(2131383905);
    }

    public /* synthetic */ SpeechLyricsView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
