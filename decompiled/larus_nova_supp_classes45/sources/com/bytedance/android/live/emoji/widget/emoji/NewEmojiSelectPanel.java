package com.bytedance.android.live.emoji.widget.emoji;

import android.graphics.Rect;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.emoji.api.IAwemeEmojiProxy;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.interactivity.api.expression.j;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class NewEmojiSelectPanel extends ConstraintLayout implements t90.a {
    public static final /* synthetic */ int c = 0;
    public j a;
    public int b;

    public class a extends RecyclerView.ItemDecoration {
        public final /* synthetic */ NewEmojiSelectPanel a;

        public a(NewEmojiSelectPanel r1) {
            this.a = r1;
        }

        public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
            int r6 = r4.getChildAdapterPosition(r3);
            NewEmojiSelectPanel r7 = this.a;
            int r8 = NewEmojiSelectPanel.c;
            r7.getClass();
            this.a.getClass();
            this.a.getClass();
            if (r6 != 0) goto L6;
            r2.top = LiveResUtil.dp2Px(12.0f);
            return;
        L6:
            this.a.getClass();
            if (r6 != 0) goto L10;
            r2.top = LiveResUtil.dp2Px(8.0f);
            return;
        L10:
            this.a.getClass();
            if (r6 <= 0) goto L14;
            this.a.getClass();
        L13:
            r6 = r6 - 1;
        L17:
            int r9 = NewEmojiSelectPanel.R5(this.a);
            this.a.getClass();
            r2.left = r9 * (r6 % 0);
            r2.right = 0;
            r2.top = LiveResUtil.dp2Px(12.0f);
            r2.bottom = LiveResUtil.dp2Px(12.0f);
            return;
        L14:
            this.a.getClass();
            if (r6 <= 0) goto L17;
            this.a.getClass();
            goto L13
        }
    }

    private int getLayoutResource() {
        return 2131567787;
    }

    private int getHorSpaceOffset() {
        if (this.b != (-1)) goto L6;
        this.b = ((LiveResUtil.getScreenWidth() - LiveResUtil.dp2Px(32.0f)) - (LiveResUtil.dp2Px(32.0f) * 0)) / 0;
    L6:
        return this.b;
    }

    private RecyclerView.ItemDecoration getItemDecoration() {
        return new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
    }

    public static /* synthetic */ int R5(NewEmojiSelectPanel r0) {
        return r0.getHorSpaceOffset();
    }

    public void setOnEmojiSelectListener(j r1) {
        this.a = r1;
    }

    @Override // t90.a
    public final void w(BaseEmoji r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.a == null) goto L16;
        IAwemeEmojiProxy r0 = (IAwemeEmojiProxy) k.f(IAwemeEmojiProxy.class);
        if (r0 == null) goto L9;
        r0.updateRecentEmoji(r3.getDescription());
    L9:
        j r1 = this.a;
        if (r3.isRecommendEmoji == false) goto L12;
        String r2 = "frequent";
    L13:
        r1.c(r3, r2);
        return;
    L12:
        r2 = "all";
        goto L13
    }
}
