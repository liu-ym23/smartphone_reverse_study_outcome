package lfc;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class p implements kfc.a {
    public final Uri a;
    public a b;

    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"com.sonyericsson.home", "com.sonymobile.home"});
    }

    public p() {
        this.a = UriProtector.parse("content://com.sonymobile.home.resourceprovider/badge");
    }

    public static void c(Context r3, ComponentName r4, int r5) {
        Intent r0 = new Intent("com.sonyericsson.home.action.UPDATE_BADGE");
        r0.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", r4.getPackageName());
        r0.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", r4.getClassName());
        r0.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(r5));
        if (r5 <= 0) goto L5;
        boolean r6 = true;
    L6:
        r0.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", r6);
        r3.sendBroadcast(r0);
        return;
    L5:
        r6 = false;
        goto L6
    }

    @Override // kfc.a
    public final void a(Context r4, ComponentName r5, int r6) throws RedBadgerException {
        if (r4 == null) goto L18;
        if (r5 == null) goto L21;
        boolean r0 = false;
        if (r6 >= 0) goto L19;
        r6 = 0;
    L19:
    L15:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L9:
        if (r4.getPackageManager().resolveContentProvider("com.sonymobile.home.resourceprovider", 0) == null) goto L11;
        r0 = true;
    L11:
        if (r0 == false) goto L13;
        d(r4, r5, r6);     // Catch: Throwable -> L15
        return;
    L13:
        c(r4, r5, r6);     // Catch: Throwable -> L15
        return;
    L21:
        return;
    }

    public final void d(Context r3, ComponentName r4, int r5) {
        if (r5 >= 0) goto L5;
        return;
    L5:
        if (this.b != null) goto L7;
        this.b = new a(r3.getApplicationContext().getContentResolver());
    L7:
        String r6 = r4.getPackageName();
        String r7 = r4.getClassName();
        ContentValues r0 = new ContentValues();
        r0.put("badge_count", Integer.valueOf(r5));
        r0.put("package_name", r6);
        r0.put("activity_name", r7);
        this.b.startInsert(0, null, this.a, r0);
    }
}
