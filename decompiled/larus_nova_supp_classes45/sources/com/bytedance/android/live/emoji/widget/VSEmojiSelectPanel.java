package com.bytedance.android.live.emoji.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.emoji.adapter.EmojiPanelWaterfallAdapter;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.interactivity.api.expression.k;
import t90.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class VSEmojiSelectPanel extends VSEmojiSelectBasePanel implements a {
    public RecyclerView a;
    public View b;
    public EmojiPanelWaterfallAdapter c;
    public View d;
    public k e;
    public int f;
    public int g;
    public final int h;

    private int getLayoutResource() {
        return 2131567989;
    }

    @Override // com.bytedance.android.live.emoji.widget.VSEmojiSelectBasePanel
    public void setOnEmojiSelectListener(k r1) {
        this.e = r1;
    }

    @Override // t90.a
    public final void w(BaseEmoji r2) {
        if (r2 == null) goto L8;
        k r0 = this.e;
        if (r0 == null) goto L9;
        r0.b(r2);
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VSEmojiSelectPanel(Context r1, int r2) {
        super(r1);
        this.h = r2;
        LayoutInflater.from(r1).inflate(getLayoutResource(), this);
    }
}
