package com.ss.android.lark.chat.video;

import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.player.entity.DataSource;
import com.ss.android.lark.player.widget.VideoView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements Runnable {
    public final /* synthetic */ InnerVideoPreviewFragment a;
    public final /* synthetic */ VideoView b;

    public b(InnerVideoPreviewFragment r1, VideoView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        FragmentActivity r0 = this.a.getActivity();
        if (r0 == null) goto L14;
        InnerVideoPreviewFragment r1 = this.a;
        VideoView r2 = this.b;
        if (r0.isFinishing() == false) goto L7;
        return;
    L7:
        if (r0.isDestroyed() == true) goto L16;
        DataSource r3 = new DataSource();
        r3.setData(r1.f);
        String r4 = ChatCoreModule.a().getPassportDependency().userId();
        if (r4 != null) goto L12;
        r4 = BuildConfig.FLAVOR;
    L12:
        r2.d(r4);
        r2.setDataSource(r3);
        r2.h();
        r2.a.e(0);
        return;
    L16:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
