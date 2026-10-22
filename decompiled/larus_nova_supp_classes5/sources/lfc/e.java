package lfc;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e implements kfc.a {
    public e() {
    }

    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"me.everything.launcher"});
    }

    public static void c(ContentResolver r18, Uri r19, ContentValues r20) throws RedBadgerException {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240017);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(240017, "android/content/ContentResolver", "insert", r18, r1, "android.net.Uri", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L20;
        Uri r5 = (Uri) r4.b;
        return;
    L20:
        r18.insert(r19, r20);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    @Override // kfc.a
    public final void a(Context r4, ComponentName r5, int r6) throws RedBadgerException {
        if (r4 == null) goto L13;
        if (r5 == null) goto L16;
        if (r6 >= 0) goto L7;
        r6 = 0;
    L7:
        ContentValues r0 = new ContentValues();
        r0.put("package_name", r5.getPackageName());
        r0.put("activity_name", r5.getClassName());
        r0.put(EffectConfiguration.KEY_COUNT, Integer.valueOf(r6));
        c(r4.getContentResolver(), UriProtector.parse("content://me.everything.badger/apps"), r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L16:
        return;
    }
}
