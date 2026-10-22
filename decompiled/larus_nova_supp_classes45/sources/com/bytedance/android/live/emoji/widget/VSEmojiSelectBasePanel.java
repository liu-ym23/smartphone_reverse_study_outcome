package com.bytedance.android.live.emoji.widget;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.interactivity.api.expression.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class VSEmojiSelectBasePanel extends ConstraintLayout {
    public abstract void setOnEmojiSelectListener(k r1);

    public VSEmojiSelectBasePanel(Context r1) {
        super(r1);
    }
}
