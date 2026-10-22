package com.obric.assistant.omnidetailpage.localmedia;

import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.im.bean.message.block.AttachmentExtra;
import com.larus.im.bean.message.block.AttachmentItem;
import com.larus.nova.NovaApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class OmniDetailInputFileCache {
    public static final OmniDetailInputFileCache a = null;
    public static final Lazy b = null;
    public static final CoroutineScope c = null;
    public static final AtomicBoolean d = null;
    public static volatile long e;

    public OmniDetailInputFileCache() {
    }

    static {
        a = new OmniDetailInputFileCache();
        b = LazyKt.lazy(new m());
        c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        d = new AtomicBoolean(false);
    }

    public static List b() {
        gd9.i r0 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r0);
        NovaApplication r1 = r0.getApplication();
        List r2 = CollectionsKt.listOfNotNull(new File[]{r1.getFilesDir(), r1.getCacheDir(), r1.getExternalFilesDir(null), r1.getExternalCacheDir()});
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L16;
        File r5 = (File) r4.next();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L8
        Object r7 = Result.constructor-impl(r5.getCanonicalFile());     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r7) == false) goto L13;
        r7 = null;
    L13:
        File r8 = (File) r7;
        if (r8 == null) goto L4;
        r3.add(r8);
    L8:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L16:
        return r3;
    }

    public static Keva d() {
        return (Keva) b.getValue();
    }

    public static void e() {
        long r0 = System.currentTimeMillis();
        AtomicBoolean r2 = d;
        if (r2.get() == false) goto L5;
        return;
    L5:
        if (r0 < e) goto L25;
        long r3 = d().getLong("__o_omni_detail_page_file_cache_last_cleanup_started_at", 0);
        if (r3 > 0) goto L10;
    L15:
        boolean r1 = true;
    L16:
        if (r1 == true) goto L20;
        e = r3 + 432000000;
        return;
    L20:
        if (r2.compareAndSet(false, true) == true) goto L22;
        return;
    L22:
        BuildersKt.launch$default(c, null, null, new OmniDetailInputFileCache$scheduleCleanupIfNeeded$1(null), 3, null);
        return;
    L10:
        if (r0 < r3) goto L15;
        if ((r0 - r3) >= 432000000) goto L15;
        r1 = false;
        goto L16
    }

    public static final int a(OmniDetailInputFileCache r8) {
        r8.getClass();
        HashMap r9 = new HashMap(d().getAll());
        if (r9.isEmpty() == true) goto L51;
        List r0 = b();
        Iterator r10 = r9.entrySet().iterator();
        int r2 = 0;
    L7:
        if (r10.hasNext() == false) goto L37;
        Map.Entry r3 = (Map.Entry) r10.next();
        String r4 = (String) r3.getKey();
        Object r5 = r3.getValue();
        Intrinsics.checkNotNull(r4);
        if (StringsKt.startsWith$default(r4, "__o_omni_detail_page_file_cache_", false, 2, null) == true) goto L7;
        if ((r5 instanceof String) == false) goto L14;
        String r6 = (String) r5;
    L15:
        if (r6 == null) goto L7;
        OmniDetailInputFileCache r7 = a;
        r7.getClass();
        if (f(r6, r0) != null) goto L7;
        monitor-enter(r7);
        String r11 = d().getString(r4, null);     // Catch: Throwable -> L33
        if (Intrinsics.areEqual(r11, r6) == true) goto L24;
    L29:
        monitor-exit(r7);
        boolean r12 = false;
    L31:
        if (r12 == false) goto L7;
        r2 = r2 + 1;
        goto L7
    L24:
        if (f(r11, r0) != null) goto L29;
        d().erase(r4);     // Catch: Throwable -> L33
        monitor-exit(r7);
        r12 = true;
    L33:
        th = move-exception;
        throw th;
    L14:
        r6 = null;
        goto L15
    L37:
        return r2;
    L51:
        return 0;
    }

    public final synchronized String c(String r3) {
        monitor-enter(this);
        if (r3 != null) goto L22;
    L9:
        r3 = null;
    L10:
        if (r3 != null) goto L13;
        monitor-exit(this);
        return null;
    L13:
        String r0 = d().getString(r3, null);     // Catch: Throwable -> L19
        String r1 = f(r0, b());     // Catch: Throwable -> L19
        if (r0 == null) goto L17;
        if (r1 != null) goto L17;
        a.getClass();     // Catch: Throwable -> L19
        d().erase(r3);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L17:
        monitor-exit(this);
        return r1;
    L22:
        if ((!StringsKt.isBlank(r3)) == false) goto L9;
        goto L9
    }

    public static String f(String r6, List r7) {
        if (r6 == null) goto L51;
        boolean r2 = true;
        if ((!StringsKt.isBlank(r6)) == true) goto L8;
        r6 = null;
    L8:
        if (r6 == null) goto L52;
        File r1 = new PolarisFileWrapper(r6);
        if (r1.isFile() == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L53;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L16
        Object r9 = Result.constructor-impl(r1.getCanonicalFile());     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r9) == false) goto L21;
        r9 = null;
    L21:
        File r10 = (File) r9;
        if (r10 != null) goto L25;
        return null;
    L25:
        if (r7.isEmpty() == true) goto L39;
        Iterator r11 = r7.iterator();
    L29:
        if (r11.hasNext() == false) goto L39;
        File r3 = (File) r11.next();
        if (Intrinsics.areEqual(r10.getPath(), r3.getPath()) == false) goto L33;
    L36:
        boolean r4 = true;
    L37:
        if (r4 == false) goto L29;
    L40:
        String r12 = r10.getPath();
        if (r2 == true) goto L43;
        return null;
    L43:
        return r12;
    L33:
        if (StringsKt.startsWith$default(r10.getPath(), r3.getPath() + File.separator, false, 2, null) == true) goto L36;
        r4 = false;
    L39:
        r2 = false;
    L16:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L53:
        return null;
    L52:
        return null;
    L51:
        return null;
    }

    public static AttachmentItem g(AttachmentItem r18, String r19) {
        Intrinsics.checkNotNullParameter(r18, "item");
        Intrinsics.checkNotNullParameter(r19, "path");
        AttachmentExtra r1 = r18.getExtra();
        if (r1 != null) goto L5;
        r1 = new AttachmentExtra(null, 1, null);
    L5:
        Map r3 = r1.getExtra();
        if (r3 != null) goto L8;
        r3 = MapsKt.emptyMap();
    L8:
        Map r4 = MapsKt.toMutableMap(r3);
        r4.put("o_omni_local_single_file_path", r19);
        return AttachmentItem.copy$default(r18, 0, null, null, null, null, null, null, 0, 0, 0, 0, null, r1.copy(r4), 4095, null);
    }
}
