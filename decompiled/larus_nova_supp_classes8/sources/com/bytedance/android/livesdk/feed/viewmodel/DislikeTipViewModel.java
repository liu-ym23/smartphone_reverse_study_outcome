package com.bytedance.android.livesdk.feed.viewmodel;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.live.core.utils.rxutils.RxViewModel;
import com.bytedance.ies.utility.SharedPrefHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class DislikeTipViewModel extends RxViewModel {
    private static final String KEY_SHOW_DISLIKE_GUIDE = "HAVE_SHOW_DISLIKE_GUIDE";
    private static final int SHOW_DISLIKE_GUIDE_TIME = 10;
    private boolean allowShowDislike;
    private Context appContext;
    private boolean haveShowDislikeGuide;
    private int scrollStartPos;

    public void onLeave() {
        this.scrollStartPos = -1;
    }

    private void init() {
        this.haveShowDislikeGuide = SharedPrefHelper.c(this.appContext, "ttlive_live_user").f(KEY_SHOW_DISLIKE_GUIDE, false);
    }

    public void onScrollStart(RecyclerView r3) {
        if (this.allowShowDislike == false) goto L17;
        if (r3 != null) goto L6;
        return;
    L6:
        if (this.haveShowDislikeGuide == false) goto L9;
        return;
    L9:
        if (this.scrollStartPos != (-1)) goto L19;
        StaggeredGridLayoutManager r4 = r3.getLayoutManager();
        if ((r4 instanceof StaggeredGridLayoutManager) == false) goto L14;
        this.scrollStartPos = r4.findLastVisibleItemPositions(null)[0];
        return;
    L14:
        if ((r4 instanceof GridLayoutManager) == false) goto L21;
        this.scrollStartPos = ((GridLayoutManager) r4).findLastVisibleItemPosition();
        return;
    L21:
        return;
    L19:
        return;
    }

    public boolean onScrollStop(RecyclerView r4) {
        if (this.allowShowDislike == false) goto L24;
        if (r4 != null) goto L6;
        return false;
    L6:
        if (this.haveShowDislikeGuide == false) goto L9;
        return false;
    L9:
        if (this.scrollStartPos == (-1)) goto L27;
        StaggeredGridLayoutManager r5 = r4.getLayoutManager();
        if ((r5 instanceof StaggeredGridLayoutManager) == false) goto L16;
        int[] r6 = r5.findLastVisibleItemPositions(null);
        if (r6.length <= 1) goto L18;
        int r7 = r6[1];
    L19:
        if (r7 >= 0) goto L21;
        return false;
    L21:
        if ((r7 - this.scrollStartPos) <= SHOW_DISLIKE_GUIDE_TIME) goto L29;
        this.scrollStartPos = -1;
        SharedPrefHelper r8 = SharedPrefHelper.c(this.appContext, "ttlive_live_user");
        r8.l(KEY_SHOW_DISLIKE_GUIDE, Boolean.TRUE);
        r8.a();
        this.haveShowDislikeGuide = true;
        return true;
    L29:
        return false;
    L18:
        r7 = -1;
        goto L19
    L16:
        if ((r5 instanceof GridLayoutManager) == false) goto L18;
        r7 = ((GridLayoutManager) r5).findLastVisibleItemPosition();
        goto L19
    L27:
        return false;
    L24:
        return false;
    }

    public DislikeTipViewModel(com.bytedance.android.livesdk.feed.j r1, long r2, Context r4) {
        r1.d(r2);
        this.allowShowDislike = false;
        this.appContext = r4;
        init();
    }
}
