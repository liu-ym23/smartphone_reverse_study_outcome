package com.ss.android.lark.discretescrollview;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DiscreteScrollViewOptions {
    private static final int TRANSITION_TIME = 100;
    private static DiscreteScrollViewOptions instance;
    private final String KEY_TRANSITION_TIME;

    public class a implements PopupMenu.OnMenuItemClickListener {
        public final /* synthetic */ RecyclerView.Adapter a;
        public final /* synthetic */ DiscreteScrollView b;

        public final boolean onMenuItemClick(MenuItem r4) {
            int r5 = CastIntegerProtector.parseInt(String.valueOf(r4.getTitle())) - 1;
            RecyclerView.Adapter r1 = this.a;
            if ((r1 instanceof InfiniteScrollAdapter) == true) goto L6;
            this.b.smoothScrollToPosition(r5);
            return true;
        L6:
            ((InfiniteScrollAdapter) r1).getClass();
            throw null;
        }

        public a(RecyclerView.Adapter r1, DiscreteScrollView r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static void configureTransitionTime(DiscreteScrollView r0) {
    }

    public static int getTransitionTime() {
        return 100;
    }

    private DiscreteScrollViewOptions(Context r1) {
        this.KEY_TRANSITION_TIME = "pref_key_transition_time";
    }

    public static void init(Context r1) {
        instance = new DiscreteScrollViewOptions(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void smoothScrollToUserSelectedPosition(DiscreteScrollView r5, View r6) {
        PopupMenu r0 = new PopupMenu(r5.getContext(), r6, 8388611);
        Menu r7 = r0.getMenu();
        RecyclerView.Adapter r1 = r5.getAdapter();
        if ((r1 instanceof InfiniteScrollAdapter) == true) goto L12;
        int r2 = 0;
        if (r1 == null) goto L7;
        int r3 = r1.getItemCount();
    L8:
        if (r2 >= r3) goto L10;
        r2 = r2 + 1;
        r7.add(String.valueOf(r2));
        goto L8
    L10:
        r0.setOnMenuItemClickListener(new a(r1, r5));
        r0.show();
        return;
    L7:
        r3 = 0;
        goto L8
    L12:
        ((InfiniteScrollAdapter) r1).getClass();
        throw null;
    }
}
