package com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager;

import com.bytedance.live.datacontext.m;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface a {
    PublishSubject<j> getRedDotStatus();

    m<com.bytedance.android.livesdk.interactivity.api.base.d> getState();

    void resetPage(PublicScreenAreaPageChangeSource r1);

    void tryAutoPositionToPage();

    void tryChangePage(PublicScreenAreaPageType r1, long r2, PublicScreenAreaPageChangeSource r4);
}
