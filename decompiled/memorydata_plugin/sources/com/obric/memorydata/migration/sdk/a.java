package com.obric.memorydata.migration.sdk;

import android.content.Context;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096A¢\u0006\u0002\u0010\u0012J,\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096A¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0003X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/migration/sdk/AiAgentMigrationAddon;", "Lcom/obric/memorydata/migration/sdk/MigrationAddon;", "providerAuthority", "", "exportMethod", "restoreMethod", "displayName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onBackup", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "", "context", "Landroid/content/Context;", "addonDir", "Ljava/io/File;", "callback", "Lcom/obric/memorydata/migration/sdk/MigrationCallback;", "(Landroid/content/Context;Ljava/io/File;Lcom/obric/memorydata/migration/sdk/MigrationCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onRestore", "getDisplayName", "()Ljava/lang/String;", OaidModel.KEY_ID, "getId", "Companion", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0642a f11878a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ad f11879b;

    /* JADX INFO: renamed from: com.obric.memorydata.migration.sdk.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/migration/sdk/AiAgentMigrationAddon$Companion;", "", "<init>", "()V", "ID", "", "DEFAULT_DISPLAY_NAME", "DEFAULT_PROVIDER_AUTHORITY", "METHOD_EXPORT", "METHOD_RESTORE", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0642a {
        private C0642a() {
        }

        public /* synthetic */ C0642a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f11878a = new C0642a(null);
    }

    public a() {
        this(null, null, null, null, 15, null);
    }

    public a(String r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "providerAuthority");
        Intrinsics.checkNotNullParameter(r9, "exportMethod");
        Intrinsics.checkNotNullParameter(r10, "restoreMethod");
        Intrinsics.checkNotNullParameter(r11, "displayName");
        this.f11879b = new ad("aiagent", r11, r8, r9, r10);
    }

    public /* synthetic */ a(String r1, String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = "com.larus.nova.zeus.aiagent.migration";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = "method_migration_export";
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = "method_migration_restore";
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = "操作手机任务数据";
    L14:
        this(r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.migration.sdk.k
    public Object a(Context r3, File r4, m r5, Continuation<? super z<Unit>> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        m r8 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.memorydata.plugin");
        Continuation<? super z<Unit>> r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return this.f11879b.a(r7, r4, r8, r9);
    }

    @Override // com.obric.memorydata.migration.sdk.k
    public String a() {
        return this.f11879b.a();
    }

    @Override // com.obric.memorydata.migration.sdk.k
    public Object b(Context r3, File r4, m r5, Continuation<? super z<Unit>> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        m r8 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.memorydata.plugin");
        Continuation<? super z<Unit>> r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return this.f11879b.b(r7, r4, r8, r9);
    }
}
