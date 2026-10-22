package com.larus.video.impl;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.r2;
import com.larus.platform.api.z3;
import com.larus.utils.logger.FLogger;
import com.larus.video.api.IVideoApi;
import com.larus.video.impl.sdk.TTVideoEngineStaticServiceImpl;
import com.larus.video.impl.sdk.f;
import com.larus.video.impl.sdk.o;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.spi.launch.ObricLazyInitSettingsServiceDelegate;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.TTVideoEngine;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import l2a.x;
import n2a.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001f\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\rH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0010H\u0002¨\u0006#"}, d2 = {"Lcom/larus/video/impl/VideoServiceImpl;", "Lcom/larus/video/api/IVideoApi;", "<init>", "()V", "getAudioPlayController", "Lcom/larus/platform/api/IAudioPlayController;", "getISdkHolderHandler", "Lcom/larus/platform/api/ISdkHolderHanlder;", "getNewInstance", "Lcom/larus/platform/api/IVideoController;", "tag", NameKeys.UnloadStrategy_No_Strategy, "enableUseSR", NameKeys.UnloadStrategy_No_Strategy, "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/platform/api/IVideoController;", "clearAllCaches", NameKeys.UnloadStrategy_No_Strategy, "getAllCacheSize", NameKeys.UnloadStrategy_No_Strategy, "getExpiredCacheSize", "expireBeforeMs", "clearExpiredCaches", "accessExpiredCache", "shouldClear", "readyDataLoader", "Lcom/ss/ttvideoengine/DataLoaderHelper;", "listCacheFiles", NameKeys.UnloadStrategy_No_Strategy, "Ljava/io/File;", "cacheDir", "isDouyinVideoActivityInStack", "getTTVideoEngineStaticService", "Lcom/larus/platform/api/ITTVideoEngineStaticService;", "ensureVideoEngineInitializedForExperiment", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoServiceImpl implements IVideoApi {
    public static final Set<String> a = null;

    public static final class a {
    }

    public VideoServiceImpl() {
    }

    static {
        a = SetsKt.setOf(new String[]{"mdl", "mdlnodeconf"});
    }

    public static void i() {
        if (ObricLazyInitSettingsServiceDelegate.a.b() == false) goto L6;
        FLogger.a.i("BackgroundLazyInit", "event=component_init_request, component=VideoEngine, trigger=first_use");
        c.a.getClass();
        c.a();
        return;
    }

    public static DataLoaderHelper k() {
        DataLoaderHelper r0 = DataLoaderHelper.getDataLoader();
        if (r0.isRunning() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L12;
        Intrinsics.checkNotNull(r0);
        return r0;
    L12:
        throw new IllegalStateException("TTVideo data loader is unavailable".toString());
    L5:
        if (r0.getMdlInitializeState() != 2) goto L7;
        r1 = true;
        goto L8
    }

    public final z3 c() {
        i();
        return new TTVideoEngineStaticServiceImpl();
    }

    public final long d() {
        long r0 = k().getAllCacheSize();
        if (r0 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return r0;
    L9:
        throw new IllegalStateException("TTVideo data loader is unavailable".toString());
    L5:
        r2 = false;
        goto L6
    }

    public final void e() {
        i();
        DataLoaderHelper r0 = k();
        String r2 = r0.getStringValue(0);
        File[] r3 = new File[2];
        PolarisFileWrapper r4 = null;
        if (r2 != null) goto L5;
    L10:
        r3[0] = r4;
        r3[1] = new PolarisFileWrapper(AppHost.a.getApplication().getCacheDir(), "videoCache");
        List r5 = CollectionsKt.listOfNotNull(r3);
        HashSet r6 = new HashSet();
        ArrayList r7 = new ArrayList();
        Iterator r8 = r5.iterator();
    L12:
        if (r8.hasNext() == false) goto L16;
        Object r9 = r8.next();
        if (r6.add(((File) r9).getAbsolutePath()) == false) goto L12;
        r7.add(r9);
        goto L12
    L16:
        ArrayList r10 = new ArrayList();
        Iterator r11 = r7.iterator();
    L18:
        if (r11.hasNext() == false) goto L20;
        CollectionsKt.addAll(r10, j((File) r11.next()));
        goto L18
    L20:
        TTVideoEngine.cancelAllPreloadTasks();
        Iterator r12 = SequencesKt.filter(CollectionsKt.asSequence(r10), new x()).iterator();
    L22:
        if (r12.hasNext() == false) goto L24;
        File r13 = (File) r12.next();
        TTVideoEngine.cancelPreloadTaskByFilePath(r13.getAbsolutePath());
        TTVideoEngine.forceRemoveCacheFile(FilesKt.getNameWithoutExtension(r13));
        goto L22
    L24:
        r0.clearAllCaches(true);
        Iterator r14 = r7.iterator();
    L26:
        if (r14.hasNext() == false) goto L28;
        r0.cleanSpecifiedCacheDir(((File) r14.next()).getAbsolutePath(), 1);
        goto L26
    L28:
        ArrayList r1 = new ArrayList();
        Iterator r15 = r7.iterator();
    L30:
        if (r15.hasNext() == false) goto L32;
        CollectionsKt.addAll(r1, j((File) r15.next()));
        goto L30
    L32:
        ArrayList r16 = new ArrayList();
        Iterator r17 = r1.iterator();
    L34:
        if (r17.hasNext() == false) goto L46;
        Object r18 = r17.next();
        File r19 = (File) r18;
        if (r19.exists() == true) goto L38;
    L42:
        boolean r20 = false;
    L43:
        if (r20 == false) goto L34;
        r16.add(r18);
        goto L34
    L38:
        if (r19.delete() == true) goto L42;
        if (r19.exists() == false) goto L42;
        r20 = true;
        goto L43
    L46:
        if (r16.isEmpty() == false) goto L49;
        return;
    L49:
        throw new IllegalStateException("TTVideo cache files could not be deleted".toString());
    L5:
        if ((!StringsKt.isBlank(r2)) == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L10;
        r4 = new PolarisFileWrapper(r2);
        goto L10
    }

    public final r2 g() {
        return f.a;
    }

    public static List j(File r7) {
        File[] r8 = r7.listFiles();
        if (r8 == null) goto L15;
        ArrayList r0 = new ArrayList();
        int r1 = r8.length;
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L16;
        File r4 = r8[r3];
        if (r4.isFile() == false) goto L11;
        Set<String> r5 = a;
        Intrinsics.checkNotNull(r4);
        if (r5.contains(FilesKt.getExtension(r4)) == false) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L14;
        r0.add(r4);
    L14:
        r3 = r3 + 1;
    L11:
        r6 = false;
    L16:
        if (r0 == null) goto L18;
        return r0;
    L18:
        return CollectionsKt.emptyList();
    L15:
        r0 = null;
        goto L16
    }

    public final long a(long r2) {
        return h(r2, false);
    }

    public final long b(long r2) {
        return h(r2, true);
    }

    public static long h(long r5, boolean r7) {
        boolean r0 = false;
        if (r5 <= 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L15;
        long r6 = k().tryToClearAndGetCachesByUsedTime(r5, r7);
        if (r6 < 0) goto L10;
        r0 = true;
    L10:
        if (r0 == false) goto L13;
        return r6;
    L13:
        throw new IllegalStateException("TTVideo data loader is unavailable".toString());
    L15:
        throw new IllegalArgumentException("expireBeforeMs must be positive".toString());
    L5:
        r4 = false;
        goto L6
    }

    public final IVideoController f(String r4, Boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        i();
        List<o> r1 = o.l;
        if (r5 == null) goto L5;
        boolean r6 = r5.booleanValue();
    L6:
        Intrinsics.checkNotNullParameter(r4, "tag");
        o r2 = new o(null);
        Intrinsics.checkNotNullParameter(r4, "tag");
        r2.d.setTag(r4);
        r2.y(r6, "getNewInstance");
        return r2;
    L5:
        r6 = false;
        goto L6
    }
}
