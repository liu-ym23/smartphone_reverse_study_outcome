package com.bytedance.android.livesdk.feed.live;

import am2.x;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.banner.a;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.utils.rxutils.j;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.feed.ui.NoticeViewSwitcher;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import g60.c;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jc1.k;
import jw1.a0;
import jw1.b0;
import jw1.c0;
import jw1.d0;
import jw1.y;
import jw1.z;
import uv1.e;
import xs2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveNoticeViewHolder extends BaseViewHolder<FeedItem> {
    public static final /* synthetic */ int e = 0;
    public final NoticeViewSwitcher a;
    public Disposable b;
    public List<a> c;
    public int d;

    public final boolean fullSpan() {
        return true;
    }

    public final void U3() {
        j.a r0 = j.a;
        this.b = j.c(5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new y(this), new z());
    }

    public final void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        U3();
    }

    public final void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        Disposable r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        this.b.dispose();
        return;
    }

    public final void T3(a r6) {
        if (TextUtils.isEmpty(r6.d()) == false) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap(1);
        r0.put("notice_id", String.valueOf(r6.getId()));
        if (TTLiveService.getLiveService() == null) goto L11;
        if (TTLiveService.getLiveService().getLiveOntologyRecord() == null) goto L11;
        r0.put("drawer_page", TTLiveService.getLiveService().getLiveOntologyRecord().getEnterFromMerge());
    L11:
        if (e5.n() == false) goto L13;
        String r2 = "landscape";
    L14:
        r0.put("screen_direction", r2);
        u.l().sendLog("livesdk_notice_entrance_click", r0, new Object[]{x.class});
        k.f(IRoomService.class).actionHandler().handle(((RecyclerView.ViewHolder) this).itemView.getContext(), r6.d());
        b.a().post(new e(0));
        return;
    L13:
        r2 = "portrait";
        goto L14
    }

    public final void bind(Object r3, int r4) {
        FeedItem r5 = (FeedItem) r3;
        if (r5 == null) goto L13;
        com.bytedance.android.live.base.model.banner.b r6 = r5.bannerContainer;
        if (r6 == null) goto L16;
        List<a> r7 = r6.a();
        this.c = r7;
        if (r7.isEmpty() == true) goto L14;
        int r8 = this.c.size();
        int r9 = this.d;
        if (r8 <= r9) goto L15;
        NoticeViewSwitcher r10 = this.a;
        List<a> r0 = this.c;
        r10.setCurrentText(((a) ListProtector.get(r0, r9 % r0.size())).f());
        this.a.getCurrentView().setOnClickListener(new d0(this));
        return;
    L15:
        return;
    L14:
        return;
    L16:
        return;
    }

    public LiveNoticeViewHolder(View r2, PublishSubject r3, PublishSubject r4, PublishSubject r5) {
        super(r2);
        this.d = 0;
        this.a = (NoticeViewSwitcher) r2.findViewById(2131387953);
        r5.subscribe(new a0(this), new c());
        r3.subscribe(new b0(this), new c());
        r4.subscribe(new c0(this), new c());
    }
}
