package com.ss.android.lark.feed.shared.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ss.android.lark.feed.shared.page.FeedRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FragmentRefactorFeedListBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final FeedRecyclerView b;

    public final View getRoot() {
        return this.a;
    }

    public FragmentRefactorFeedListBinding(ConstraintLayout r1, FeedRecyclerView r2) {
        this.a = r1;
        this.b = r2;
    }

    public static FragmentRefactorFeedListBinding a(LayoutInflater r2, ViewGroup r3) {
        ConstraintLayout r4 = r2.inflate(2131561239, r3, false);
        FeedRecyclerView r0 = (FeedRecyclerView) ViewBindings.findChildViewById(r4, 2131384966);
        if (r0 == null) goto L7;
        return new FragmentRefactorFeedListBinding(r4, r0);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(2131384966)));
    }
}
