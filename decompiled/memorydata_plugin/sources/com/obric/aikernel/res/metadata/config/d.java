package com.obric.aikernel.res.metadata.config;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonObject;
import com.obric.aikernel.res.PrmContext;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/obric/aikernel/res/metadata/config/LibConfig;", "Lcom/obric/aikernel/res/metadata/config/DistConfig;", ActivityLifecycle.NAME, "", "json", "Lcom/google/gson/JsonObject;", "(Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "useNative", "", "getUseNative", "()Z", "generateCheckFile", "", "downloadRoot", "Ljava/io/File;", "targetRoot", "getDownloads", "", "Lcom/obric/aikernel/res/metadata/config/Downloadable;", "needDownload", "context", "Lcom/obric/aikernel/res/PrmContext;", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f6066a;

    public d(String r4, JsonObject r5) {
        Intrinsics.checkNotNullParameter(r4, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r5, "json");
        super("lib", r4, r5);
        this.f6066a = StringsKt.startsWith$default(r4, "native_", false, 2, null);
    }

    @Override // com.obric.aikernel.res.metadata.config.a
    public void a(File r11, File r12) {
        Intrinsics.checkNotNullParameter(r11, "downloadRoot");
        Intrinsics.checkNotNullParameter(r12, "targetRoot");
        File r0 = new File(new File(r11, new c(a(), b(), 0, false, 12, null).o()), "checker_v2.json");
        if (r0.exists() == false) goto L6;
        com.obric.aikernel.res.utils.a r13 = com.obric.aikernel.res.utils.a.f6155a;
        String r10 = new File(r12, "checker_v2.json").getPath();
        Intrinsics.checkNotNullExpressionValue(r10, "File(targetRoot, BaseMetadata.CHECKER_FILE).path");
        r13.a(r0, r10);
        return;
    }

    @Override // com.obric.aikernel.res.metadata.config.a
    public boolean a(PrmContext r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        com.obric.aikernel.res.metadata.data.i r0 = new com.obric.aikernel.res.metadata.data.i(a(), c(), r4.getConfig());
        if (r0.E() == false) goto L5;
    L16:
        return true;
    L5:
        if (Intrinsics.areEqual(d(), "debug") == false) goto L15;
        a r5 = r0.J();
        if (r5 == null) goto L11;
        JsonObject r6 = r5.b();
        if (r6 == null) goto L11;
        String r7 = b.b(r6, "md5");
    L13:
        if (Intrinsics.areEqual(r7, b.b(b(), "md5")) == true) goto L15;
    L11:
        r7 = null;
    L15:
        return false;
    }

    @Override // com.obric.aikernel.res.metadata.config.a
    public List<c> e() {
        return CollectionsKt.listOf(new c(a(), b(), 0, false, 12, null));
    }

    public final boolean f() {
        return this.f6066a;
    }
}
