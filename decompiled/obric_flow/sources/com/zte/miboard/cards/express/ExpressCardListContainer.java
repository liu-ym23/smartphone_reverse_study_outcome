package com.zte.miboard.cards.express;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zte.miboard.cards.R;
import com.zte.miboard.cards.express.data.ExpressNode;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class ExpressCardListContainer extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewGroup f16286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<ExpressNode> f16287b;

    public ExpressCardListContainer(Context r5) {
        this(r5, null);
    }

    public void a(@NonNull ArrayList<ExpressNode> r5) {
        this.f16287b.clear();
        this.f16287b.addAll(r5);
        int r10 = 0;
    L4:
        if (r10 >= this.f16286a.getChildCount()) goto L13;
        View r11 = this.f16286a.getChildAt(r10);
        if (r10 < this.f16287b.size()) goto L8;
        r11.setVisibility(8);
    L12:
        r10 = r10 + 1;
        goto L4
    L8:
        if ((r11 instanceof ExpressListItem) == false) goto L10;
        ((ExpressListItem) r11).a(this.f16287b.get(r10), false);
    L10:
        r11.setVisibility(0);
        goto L12
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f16286a = this;
        int r5 = 0;
    L4:
        if (r5 >= 2) goto L6;
        LayoutInflater.from(getContext()).inflate(R.layout.express_list_item, this.f16286a, true);
        r5 = r5 + 1;
        goto L4
    }

    public ExpressCardListContainer(Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    public ExpressCardListContainer(Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f16287b = new ArrayList();
    }
}
