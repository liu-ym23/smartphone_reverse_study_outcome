package com.bytedance.android.live.emoji.widget;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.emoji.adapter.EmojiPanelAdapter;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.chatroom.ui.RtlViewPagerShower;
import com.bytedance.android.livesdk.interactivity.api.expression.k;
import t90.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class EmojiSelectPanel extends ConstraintLayout implements a {
    public RecyclerView a;
    public EmojiPanelAdapter b;
    public RtlViewPagerShower c;
    public k d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;

    private int getLayoutResource() {
        return 2131567654;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EmojiSelectPanel(Context r2) {
        super(r2);
        LayoutInflater.from(r2).inflate(getLayoutResource(), this);
    }

    public void setOnEmojiSelectListener(k r1) {
        this.d = r1;
    }

    @Override // t90.a
    public final void w(BaseEmoji r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.d != null) goto L7;
        return;
    L7:
        if (r3.getIconId() != 2131250529) goto L9;
        this.d.a();
        return;
    L9:
        this.d.b(r3);
    }

    public static void R5(EmojiSelectPanel r1, int r2) {
        int r3 = r2 / r1.j;
        if (r3 >= 0) goto L5;
        return;
    L5:
        if (r3 >= r1.g) goto L10;
        r1.e = r3;
        r1.c.b(r3);
        return;
    }
}
