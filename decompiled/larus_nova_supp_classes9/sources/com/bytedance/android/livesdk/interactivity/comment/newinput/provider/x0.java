package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.business.depend.highlight.PublishHighlightVideoData;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x0 implements Action {
    public final /* synthetic */ MarkHighlightController a;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.highlight.b b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Activity d;

    public static final class a implements IMiddlewareHostBusiness.OnLiveHighlightPublish {
        public final /* synthetic */ x0 a;

        public a(x0 r1) {
            this.a = r1;
        }

        public final void onPublish(int r3) {
            if (r3 != 1) goto L6;
            com.bytedance.android.live.core.utils.f2.c("发布失败", 0);
        L6:
            MarkHighlightController.g(this.a.a, false);
            int r4 = e72.c.a;
            e72.c.a(this.a.a.t);
        }
    }

    public x0(MarkHighlightController r1, com.bytedance.android.livesdk.interactivity.comment.highlight.b r2, String r3, Activity r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void run() {
        IBaseUser r1 = this.a.h();
        String r2 = BuildConfig.FLAVOR;
        if (r1 == null) goto L8;
        String r3 = r1.getNickName();
        if (r3 == null) goto L8;
        String r9 = r3;
    L9:
        ALogger.d("HighlightBacktrackUtil", "下载完成，正在吊起编辑页");
        boolean r4 = true;
        MarkHighlightController.g(this.a, true);
        String r5 = this.b.b();
        String r6 = null;
        if (r5 != null) goto L12;
    L19:
        r5 = r9.concat("的高光瞬间");
    L20:
        String r13 = r5;
        String r7 = this.c;
        Activity r8 = this.d;
        String r10 = this.a.i();
        String r11 = String.valueOf(this.a.b.Z());
        String r14 = String.valueOf(this.b.e());
        IMiddlewareUserService r15 = jc1.k.f(IMiddlewareUserService.class);
        if (r15 == null) goto L27;
        com.bytedance.android.livesdk.user.e r16 = r15.user();
        if (r16 == null) goto L27;
        IBaseUser r17 = r16.b();
        if (r17 == null) goto L27;
        r6 = r17.getIdString();
    L27:
        String r18 = String.valueOf(r6);
        String r19 = this.b.a();
        if (r19 == null) goto L31;
        r2 = r19;
    L31:
        PublishHighlightVideoData r20 = new PublishHighlightVideoData(r7, r8, "live_detail", "live_detail", r10, r9, r14, r11, r18, r13, r2, new a(this));
        IMiddlewareHostBusiness r21 = jc1.k.f(IMiddlewareHostBusiness.class);
        if (r21 == null) goto L34;
        r21.openEditAndPublishPage(r20);
    L34:
        this.a.j(false);
        return;
    L12:
        if (r5.length() > 0) goto L15;
        r4 = false;
    L15:
        if (r4 == true) goto L18;
        r5 = null;
    L18:
        if (r5 != null) goto L20;
    L8:
        r9 = BuildConfig.FLAVOR;
        goto L9
    }
}
