package com.bytedance.android.live.emoji.online;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.bytedance.android.live.emoji.online.model.OnlineSmallEmojiResInfo;
import com.bytedance.common.utility.BitmapUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class OnlineSmallEmojiCache {
    public static final /* synthetic */ int d = 0;
    public final Lazy a;
    public final Lazy b;
    public final OnlineSmallEmojiResInfo c;

    public static final class a {
    }

    static {
    }

    public OnlineSmallEmojiCache(OnlineSmallEmojiResInfo r1) {
        this.c = r1;
        this.a = LazyKt.lazy(OnlineSmallEmojiCache$lruCache$2.INSTANCE);
        this.b = LazyKt.lazy(OnlineSmallEmojiCache$weakRefCache$2.INSTANCE);
    }

    public final Bitmap a(String r11) {
        String r0 = c.a;
        String r1 = this.c.getPicFileDirPath();
        Intrinsics.checkNotNullParameter(r1, "picFileDirPath");
        Intrinsics.checkNotNullParameter(r11, "picFileName");
        boolean r2 = true;
        List r3 = CollectionsKt.mutableListOf(new String[]{r11});
        Bitmap r5 = null;
        if (r3.isEmpty() == false) goto L5;
        r3.toString();
    L30:
        LinkedHashMap r4 = null;
    L31:
        if (r4 != null) goto L33;
    L45:
        if (r5 == null) goto L53;
        monitor-enter(this);
        ((LruCache) this.a.getValue()).put(r11, r5);     // Catch: Throwable -> L50
        monitor-exit(this);
    L50:
        th = move-exception;
        throw th;
    L53:
        return r5;
    L33:
        if (r4.size() == 1) goto L36;
        r2 = false;
    L36:
        if (r2 == true) goto L39;
        r4 = null;
    L39:
        if (r4 == null) goto L45;
        ArrayList r6 = new ArrayList(r4.size());
        Iterator r7 = r4.entrySet().iterator();
    L42:
        if (r7.hasNext() == false) goto L44;
        r6.add((Bitmap) ((Map.Entry) r7.next()).getValue());
        goto L42
    L44:
        r5 = (Bitmap) ListProtector.get(r6, 0);
        goto L45
    L5:
        PolarisFileWrapper r8 = new PolarisFileWrapper(r1);
        if (r8.exists() == true) goto L8;
    L29:
        r3.toString();
        goto L30
    L8:
        if (r8.isDirectory() == false) goto L29;
        File[] r9 = r8.listFiles(new d(r3));
        if (r9 != null) goto L13;
    L19:
        boolean r12 = true;
    L20:
        if (r12 == false) goto L22;
        r3.toString();
        goto L30
    L22:
        r4 = new LinkedHashMap();
        int r13 = r9.length;
        int r14 = 0;
    L23:
        if (r14 >= r13) goto L31;
        File r15 = r9[r14];
        Bitmap r16 = BitmapUtils.decodeBitmap(r15, c.b);
        if (r16 == null) goto L27;
        r4.put(r15.getName(), r16);
    L28:
        r14 = r14 + 1;
        goto L23
    L27:
        r15.getName();
        r3.toString();
        goto L28
    L13:
        if (r9.length != 0) goto L15;
        boolean r17 = true;
    L16:
        if (r17 == true) goto L19;
        r12 = false;
        goto L20
    L15:
        r17 = false;
        goto L16
    }
}
