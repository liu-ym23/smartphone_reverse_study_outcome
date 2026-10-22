package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.utils.q1;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
    public static final h a = null;

    public static final class a<T> implements SingleOnSubscribe {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void subscribe(SingleEmitter<Object> r6) {
            Intrinsics.checkNotNullParameter(r6, "it");
            h r7 = h.a;
            monitor-enter(r7);
            int r1 = v.a;     // Catch: Throwable -> L31
            PolarisFileWrapper r0 = new PolarisFileWrapper(v.a.a());     // Catch: Throwable -> L31
            if (r0.exists() == true) goto L7;
        L28:
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L31
            monitor-exit(r7);
            return;
        L7:
            if (r0.isDirectory() == false) goto L28;
            List r3 = ArraysKt.toList(r0.listFiles());     // Catch: Throwable -> L31
            int r4 = r3.size();     // Catch: Throwable -> L31
            if (r4 > 100) goto L13;
            monitor-exit(r7);
            return;
        L13:
            int r5 = r4 - 100;
            if ((!r3.isEmpty()) == false) goto L28;
            List r8 = CollectionsKt.sortedWith(r3, new g());     // Catch: Throwable -> L31
            if (r5 <= r3.size()) goto L20;
            monitor-exit(r7);
            return;
        L20:
            int r9 = 0;
        L21:
            if (r9 >= r5) goto L28;
            File r11 = (File) r8.get(r9);     // Catch: Throwable -> L31
            if (r11 == null) goto L27;
            if (r11.exists() == false) goto L27;
            q1.a(r11);     // Catch: Throwable -> L31
        L27:
            r9 = r9 + 1;     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            throw th;
        }
    }

    public h() {
    }

    static {
        a = new h();
    }

    @JvmStatic
    public static final void a() {
        Single.create(a.a).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
    }

    @JvmStatic
    public static final String b(long r3) {
        StringBuilder r0 = new StringBuilder(KtvCommonConfigParams.a());
        String r1 = File.separator;
        r0.append(r1);
        r0.append("musicPack");
        r0.append(r1);
        r0.append(r3);
        r0.append(r1);
        return r0.toString();
    }

    @JvmStatic
    public static final String c(String r7) {
        Intrinsics.checkNotNullParameter(r7, "filePath");
        int r0 = StringsKt.lastIndexOf$default(r7, "/", 0, false, 6, null);
        if (r0 != (-1)) goto L7;
        return null;
    L7:
        return r7.substring(r0);
    }

    @JvmStatic
    public static final String f(String r7) {
        Intrinsics.checkNotNullParameter(r7, "filePath");
        int r0 = StringsKt.lastIndexOf$default(r7, "/", 0, false, 6, null);
        if (r0 != (-1)) goto L7;
        return null;
    L7:
        return r7.substring(0, r0);
    }

    public static String d(String r4, long r5) {
        int r0 = t.b;
        String r1 = t.a.a(r5);
        PolarisFileWrapper r2 = new PolarisFileWrapper(r1);
        if (r2.exists() == true) goto L9;
        if (r2.mkdirs() == false) goto L7;
        a();
        goto L9
    L7:
        ALogger.e("KtvFileUtil", "mkdirs return false, dir=" + r2);
    L9:
        return r1 + t.a.b(r4, r5);
    }

    public static String e(String r6, long r7) {
        int r0 = u.b;
        StringBuilder r1 = new StringBuilder(KtvCommonConfigParams.a());
        String r2 = File.separator;
        r1.append(r2);
        r1.append("musicPack");
        r1.append(r2);
        r1.append(r7);
        r1.append(r2);
        r1.append(KtvSubElement.MIDI);
        r1.append(r2);
        String r8 = r1.toString();
        PolarisFileWrapper r9 = new PolarisFileWrapper(r8);
        if (r9.exists() == false) goto L5;
    L8:
        StringBuilder r11 = new StringBuilder();
        r11.append(r8);
        if (r6 == null) goto L23;
        Integer r12 = Integer.valueOf(StringsKt.lastIndexOf$default(r6, "/", 0, false, 6, null));
        int r3 = r12.intValue();
        if (r3 > (-1)) goto L13;
    L15:
        boolean r4 = false;
    L16:
        String r5 = null;
        if (r4 == true) goto L20;
        r12 = null;
    L20:
        if (r12 == null) goto L22;
        r5 = r6.substring(r12.intValue() + 1);
    L22:
        if (r5 == null) goto L23;
    L24:
        r11.append(r5);
        return r11.toString();
    L13:
        if (r3 >= r6.length()) goto L15;
        r4 = true;
    L23:
        r5 = "";
        goto L24
    L5:
        if (r9.mkdirs() == false) goto L7;
        a();
        goto L8
    L7:
        ALogger.e("KtvFileUtil", "mkdirs return false, dir=" + r9);
        goto L8
    }
}
