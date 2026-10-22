package com.obric.aikernel.res.metadata.config;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonObject;
import com.obric.aikernel.res.PrmContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J2\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u0003H\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001aH\u0016J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0017J\u0010\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u0003H\u0016R\u001b\u0010\b\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u001b\u0010\u0011\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0012\u0010\n¨\u0006*"}, d2 = {"Lcom/obric/aikernel/res/metadata/config/DistConfig;", "", "type", "", ActivityLifecycle.NAME, "json", "Lcom/google/gson/JsonObject;", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "from", "getFrom", "()Ljava/lang/String;", "from$delegate", "Lkotlin/Lazy;", "getJson", "()Lcom/google/gson/JsonObject;", "getName", "getType", "version", "getVersion", "version$delegate", "generateCheckFile", "", "downloadRoot", "Ljava/io/File;", "targetRoot", "getDownloadFiles", "", "Lcom/obric/aikernel/res/downloader/DownloadTask$FileInfo;", "savePath", "tmpPath", "downloadType", "", "resourceType", "getDownloads", "Lcom/obric/aikernel/res/metadata/config/Downloadable;", "isAllDownloadableExist", "", "root", "needDownload", "context", "Lcom/obric/aikernel/res/PrmContext;", "toString", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6063b;
    private final JsonObject c;
    private final Lazy d;
    private final Lazy e;

    public a(String r2, String r3, JsonObject r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r4, "json");
        this.f6062a = r2;
        this.f6063b = r3;
        this.c = r4;
        this.d = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new DistConfig$version$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.e = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new DistConfig$from$2(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ List a(a r0, String r1, String r2, int r3, String r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 4) == 0) goto L7;
        r3 = 0;
    L7:
        if ((r5 & 8) == 0) goto L10;
        r4 = r0.f6062a;
    L10:
        return r0.a(r1, r2, r3, r4);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDownloadFiles");
    }

    public final String a() {
        return this.f6063b;
    }

    public List<com.obric.aikernel.res.downloader.j.b> a(String r5, String r6, int r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, "savePath");
        Intrinsics.checkNotNullParameter(r6, "tmpPath");
        Intrinsics.checkNotNullParameter(r8, "resourceType");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(e(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r4.iterator();
    L4:
        if (r9.hasNext() == false) goto L7;
        CollectionsKt.addAll(r0, (Iterable) ZeusTransformUtils.preCheckCast(((c) ZeusTransformUtils.preCheckCast(r9.next(), c.class, "com.obric.memorydata.plugin")).a(r5, r6, r7, r8), Iterable.class, "com.obric.memorydata.plugin"));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    public void a(File r1, File r2) {
        Intrinsics.checkNotNullParameter(r1, "downloadRoot");
        Intrinsics.checkNotNullParameter(r2, "targetRoot");
    }

    public boolean a(PrmContext r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return true;
    }

    public final JsonObject b() {
        return this.c;
    }

    public String c() {
        return (String) ZeusTransformUtils.preCheckCast(this.d.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    public final String d() {
        return (String) ZeusTransformUtils.preCheckCast(this.e.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    public List<c> e() {
        return CollectionsKt.emptyList();
    }

    public final String getType() {
        return this.f6062a;
    }

    public String toString() {
        return '[' + this.f6062a + ':' + this.f6063b + '@' + c() + ']';
    }
}
