package com.obric.memorydata.personalcontext.external;

import android.content.Context;
import android.provider.MediaStore;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007J.\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/MediaStoreVersionSyncPolicy;", "", "<init>", "()V", "evaluate", "Lcom/obric/memorydata/personalcontext/external/MediaStoreVersionSyncPolicy$Result;", "savedVersion", "", "currentVersion", "hasGenerationBaseline", "", "saveCurrentVersion", "", "context", "Landroid/content/Context;", "versionKey", "logTag", "checkMediaStoreVersion", "generationModifiedKey", "logScene", "Result", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f12142a = null;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/MediaStoreVersionSyncPolicy$Result;", "", "shouldResetGeneration", "", "shouldSaveVersion", "<init>", "(ZZ)V", "getShouldResetGeneration", "()Z", "getShouldSaveVersion", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f12143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f12144b;

        public a(boolean r1, boolean r2) {
            this.f12143a = r1;
            this.f12144b = r2;
        }

        public final boolean a() {
            return this.f12143a;
        }

        public final boolean b() {
            return this.f12144b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f12143a == r6.f12143a) goto L12;
            return false;
        L12:
            if (this.f12144b == r6.f12144b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f12143a) * 31) + Boolean.hashCode(this.f12144b);
        }

        public String toString() {
            return "Result(shouldResetGeneration=" + this.f12143a + ", shouldSaveVersion=" + this.f12144b + ')';
        }
    }

    static {
        f12142a = new j();
    }

    private j() {
    }

    public final a a(String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "currentVersion");
        boolean r2 = false;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L8;
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L12;
    L13:
        r2 = true;
    L14:
        if (r2 == true) goto L16;
        boolean r8 = !Intrinsics.areEqual(r4, r5);
        return new a(r8, r8);
    L16:
        return new a(r6, true);
    L12:
        if (r7.length() != 0) goto L14;
    L8:
        return new a(false, false);
    L5:
        r3 = false;
        goto L6
    }

    public final void a(Context r5, String r6, String r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r6, "versionKey");
        Intrinsics.checkNotNullParameter(r7, "logTag");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        j r4 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        String r9 = MediaStore.getVersion(r8, "external_primary");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullExpressionValue(r9, "getVersion(...)");     // Catch: Throwable -> L11
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L6;
        boolean r10 = true;
    L7:
        if (r10 == false) goto L9;
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save(r6, r9);     // Catch: Throwable -> L11
    L9:
        Object r11 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r12 = Result.m1424exceptionOrNullimpl(r11);
        if (r12 == null) goto L19;
        c.f12108a.a(r7, "saveCurrentVersion failed", r12);
        return;
    L19:
        return;
    L6:
        r10 = false;
    L11:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public final void a(Context r8, String r9, String r10, String r11, String r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r9, "versionKey");
        Intrinsics.checkNotNullParameter(r10, "generationModifiedKey");
        Intrinsics.checkNotNullParameter(r11, "logTag");
        Intrinsics.checkNotNullParameter(r12, "logScene");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        j r7 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        boolean r4 = false;
        IStore r1 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);     // Catch: Throwable -> L14
        String r14 = MediaStore.getVersion(r13, "external_primary");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r14, "getVersion(...)");     // Catch: Throwable -> L14
        String r2 = r1.getString(r9, "");     // Catch: Throwable -> L14
        if (r1.getLong(r10, 0) <= 0) goto L6;
        r4 = true;
    L6:
        a r15 = r7.a(r2, r14, r4);     // Catch: Throwable -> L14
        if (r15.a() == false) goto L10;
        c.f12108a.b(r11, "MediaStore version changed, reset " + r12 + " generation_modified.");     // Catch: Throwable -> L14
        r1.save(r10, 0);     // Catch: Throwable -> L14
    L10:
        if (r15.b() == false) goto L12;
        r1.save(r9, r14);     // Catch: Throwable -> L14
    L12:
        Object r16 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r17 = Result.m1424exceptionOrNullimpl(r16);
        if (r17 == null) goto L22;
        c.f12108a.a(r11, "checkMediaStoreVersion failed", r17);
        return;
    L22:
        return;
    L14:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    }
}
