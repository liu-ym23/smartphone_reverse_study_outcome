package com.obric.aikernel.res.metadata.config;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonObject;
import com.obric.aikernel.res.PrmContext;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/aikernel/res/metadata/config/PyHandlerConfig;", "Lcom/obric/aikernel/res/metadata/config/DistConfig;", ActivityLifecycle.NAME, "", "json", "Lcom/google/gson/JsonObject;", "packageVersion", "(Ljava/lang/String;Lcom/google/gson/JsonObject;Ljava/lang/String;)V", "generateCheckFile", "", "downloadRoot", "Ljava/io/File;", "targetRoot", "getDownloads", "", "Lcom/obric/aikernel/res/metadata/config/Downloadable;", "needDownload", "", "context", "Lcom/obric/aikernel/res/PrmContext;", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class j extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6074a;

    public j(String r2, JsonObject r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r3, "json");
        Intrinsics.checkNotNullParameter(r4, "packageVersion");
        super("package", r2, r3);
        this.f6074a = r4;
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
    public boolean a(PrmContext r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (Intrinsics.areEqual(this.f6074a, "debug") == false) goto L5;
    L8:
        return true;
    L5:
        if (new com.obric.aikernel.res.metadata.data.b(a(), this.f6074a, r3.getConfig()).E() == true) goto L8;
        return false;
    }

    @Override // com.obric.aikernel.res.metadata.config.a
    public List<c> e() {
        return CollectionsKt.listOf(new c(a(), b(), 0, false, 12, null));
    }
}
