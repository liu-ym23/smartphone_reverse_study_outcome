package com.ss.android.lark.flow.notification.online.type.appfeed;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import atb.c;
import com.bytedance.lark.pb.basic.v1.AppFeedCardData;
import com.bytedance.lark.pb.basic.v1.Image;
import com.bytedance.lark.pb.basic.v1.Notification;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.framework.utils.x;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends atb.b<Notice, phb.a> {
    public String b;
    public String c;

    public static final class a {
    }

    static {
    }

    @Override // atb.b
    public final void e() {
    }

    @Override // atb.b
    public final void f() {
    }

    @Override // atb.b
    public final int i() {
        return 0;
    }

    @Override // atb.b
    public final void k() {
    }

    @Override // atb.b
    public final boolean q() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // atb.b
    public final String c() {
        return ((Notice) this.a).content;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // atb.b
    public final int g() {
        Notice.Extra r0 = ((Notice) this.a).extra;
        if (r0 == null) goto L7;
        String r1 = r0.m;
        if (r1 == null) goto L7;
        int r2 = r1.hashCode();
    L9:
        return (r2 % 21717) * 21717;
    L7:
        r2 = 0;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // atb.b
    public final String h() {
        Notice.Extra r0 = ((Notice) this.a).extra;
        if (r0 == null) goto L5;
        String r1 = r0.m;
    L7:
        return String.valueOf(r1);
    L5:
        r1 = null;
        goto L7
    }

    @Override // atb.b
    public final Uri l() {
        return UriProtector.parse("android.resource://" + getContext().getPackageName() + "/2131820627");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // atb.b
    public final c m() {
        T r0 = this.a;
        Notice.Extra r1 = ((Notice) r0).extra;
        c r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.n;
    L6:
        Notice.Extra r4 = ((Notice) r0).extra;
        if (r4 == null) goto L9;
        String r5 = r4.o;
    L10:
        boolean r6 = false;
        if (r3 != null) goto L13;
    L18:
        if (r6 == true) goto L20;
    L23:
        return r2;
    L20:
        if (r5 != null) goto L22;
        r5 = "";
    L22:
        r2 = new c(r3, r5);
        goto L23
    L13:
        if (r3.length() <= 0) goto L15;
        boolean r7 = true;
    L16:
        if (r7 != true) goto L18;
        r6 = true;
        goto L18
    L15:
        r7 = false;
        goto L16
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // atb.b
    public final String o() {
        return ((Notice) this.a).title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // atb.b
    public final void p() {
        Object r0 = ((Notice) this.a).pbNotification;
        if ((r0 instanceof Notification) == false) goto L11;
        AppFeedCardData r1 = ((Notification) r0).app_feed_card_data;
        Image r2 = r1.avatar;
        if (r2 == null) goto L8;
        String r3 = r2.key;
        if (r3 == null) goto L8;
    L9:
        this.b = r3;
        this.c = r1.link;
        return;
    L8:
        r3 = "";
        goto L9
    }

    public final phb.a r() {
        String r0 = "";
        phb.a r2 = new phb.a();
        a(r2);
    L8:
        th = move-exception;
        int r4 = thb.a.a;
        Intrinsics.checkNotNullParameter("FlowOpenAppFeedNotificationDataPacker", "tag");
        Intrinsics.checkNotNullParameter("getAvatarBitmap error", "msg");
        Log.e("FlowOpenAppFeedNotificationDataPacker", "[FlowNotificationLog] ".concat("getAvatarBitmap error"), th);
        Bitmap r3 = null;
    L10:
        r2.c = r3;
        if (TextUtils.isEmpty(this.c) == true) goto L20;
        String r5 = this.c;
        if (r5 == null) goto L21;
        Uri r6 = UriProtector.parse(r5);
        if (r6 == null) goto L21;
        String r7 = UriProtector.getQueryParameter(r6, "target_id");
        if (r7 == null) goto L21;
        r0 = r7;
    L21:
        r2.d = r0;
        if (r2.c != null) goto L24;
        thb.a.a("FlowOpenAppFeedNotificationDataPacker", "avatar is null");
    L24:
        return r2;
    L20:
        thb.a.a("FlowOpenAppFeedNotificationDataPacker", "getTargetUserId is empty");
        goto L21
    L4:
        if (TextUtils.isEmpty(this.b) == true) goto L6;
        int r8 = UIHelper.dp2px(48.0f);     // Catch: Throwable -> L8
        AvatarImage r9 = AvatarImage.Builder.obtain(this.b, "", r8, r8).build();     // Catch: Throwable -> L8
        r3 = ImageLoader.with(getContext()).load(r9).asBitmap().centerCrop().error(2131237929).getBitmap(r8, r8);     // Catch: Throwable -> L8
    L25:
        goto L10
    L6:
        r3 = BitmapFactory.decodeResource(getContext().getResources(), 2131237929);     // Catch: Throwable -> L8
        goto L25
    }

    private final Application getContext() {
        return LarkContext.getApplication();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // atb.b
    public final String b() {
        if (x.c() == true) goto L5;
        String r0 = null;
    L21:
        thb.a.b("FlowOpenAppFeedNotificationDataPacker", "receive offline notice getChannelId: " + r0);
        return r0;
    L5:
        Notice.Extra r1 = ((Notice) this.a).extra;
        boolean r2 = false;
        if (r1 == null) goto L15;
        String r3 = r1.n;
        if (r3 == null) goto L15;
        if (r3.length() <= 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 != true) goto L15;
        r2 = true;
        goto L15
    L12:
        r4 = false;
    L15:
        if (r2 == false) goto L17;
        r0 = AbstractNotification.CHANNEL_TYPE.APP_NOTIFICATION;
        goto L21
    L17:
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isMempopeApp() == false) goto L20;
        r0 = AbstractNotification.CHANNEL_TYPE.PUSH_OPLUS_CATEGORY_CONTENT;
        goto L21
    L20:
        r0 = AbstractNotification.CHANNEL_TYPE.OPEN_FEED;
        goto L21
    }

    @Override // atb.b
    public final String n() {
        return c();
    }

    public b(Notice r2) {
        Intrinsics.checkNotNullParameter(r2, "oriData");
        super(r2);
    }

    @Override // atb.b
    public final PendingIntent j(Intent r4) {
        int r1 = (int) SystemClock.uptimeMillis();
        if (x.a() == false) goto L5;
        int r0 = 201326592;
    L7:
        return PendingIntent.getActivity(getContext(), r1, r4, r0);
    L5:
        r0 = 134217728;
        goto L7
    }
}
