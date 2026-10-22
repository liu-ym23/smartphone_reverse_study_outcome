package com.obric.memorydata.migration.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\b\u0010\r\u001a\u00020\u000eH\u0002J,\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J,\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J.\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/migration/sdk/ProviderCallMigrationAddon;", "Lcom/obric/memorydata/migration/sdk/MigrationAddon;", OaidModel.KEY_ID, "", "displayName", "providerAuthority", "exportMethod", "restoreMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getDisplayName", "providerUri", "Landroid/net/Uri;", "onBackup", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "", "context", "Landroid/content/Context;", "addonDir", "Ljava/io/File;", "callback", "Lcom/obric/memorydata/migration/sdk/MigrationCallback;", "(Landroid/content/Context;Ljava/io/File;Lcom/obric/memorydata/migration/sdk/MigrationCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onRestore", "callAndMapResult", "method", "args", "Landroid/os/Bundle;", TypedValues.CycleType.S_WAVE_PHASE, "Companion", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ad implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11881a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11882b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/migration/sdk/ProviderCallMigrationAddon$Companion;", "", "<init>", "()V", "KEY_ADDON_DIR", "", "KEY_OK", "KEY_MESSAGE", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f11881a = new a(null);
    }

    public ad(String r2, String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "displayName");
        Intrinsics.checkNotNullParameter(r4, "providerAuthority");
        Intrinsics.checkNotNullParameter(r5, "exportMethod");
        Intrinsics.checkNotNullParameter(r6, "restoreMethod");
        this.f11882b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    private final z<Unit> a(Context r10, String r11, Bundle r12, String r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r15 = Result.m1421constructorimpl(ZeusProviderTransform.call(r14.getContentResolver(), ((ad) ZeusTransformUtils.preCheckCast(this, ad.class, "com.obric.memorydata.plugin")).b(), r11, null, r12, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r15) == false) goto L10;
        r15 = null;
    L10:
        Bundle r16 = (Bundle) ZeusTransformUtils.preCheckCast(r15, Bundle.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L16;
        Object r9 = ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.OTHER, "addon(" + a() + ") " + r13 + "失败：Provider.call 返回空（authority=" + this.d + " method=" + r11 + 65289, null, 4, null)), z.class, "com.obric.memorydata.plugin");
    L14:
        return (z) r9;
    L16:
        if (r16.getBoolean("ok", false) == false) goto L18;
        r9 = ZeusTransformUtils.preCheckCast(new z.b(Unit.INSTANCE), z.class, "com.obric.memorydata.plugin");
        goto L14
    L18:
        String r17 = r16.getString("message");
        if (r17 != null) goto L21;
        r17 = "";
    L21:
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r18) == false) goto L24;
        r18 = "unknown";
    L24:
        r9 = ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.OTHER, "addon(" + a() + ") " + r13 + "失败：" + ((String) ZeusTransformUtils.preCheckCast(r18, String.class, "com.obric.memorydata.plugin")), null, 4, null)), z.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final Uri b() {
        Uri r2 = Uri.parse("content://" + this.d);
        Intrinsics.checkNotNullExpressionValue(r2, "parse(...)");
        return r2;
    }

    @Override // com.obric.memorydata.migration.sdk.k
    public Object a(Context r3, File r4, m r5, Continuation<? super z<Unit>> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        m r8 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        r4.mkdirs();
        Bundle r10 = new Bundle();
        r10.putString("addon_dir", r4.getAbsolutePath());
        return a(r7, this.e, r10, "备份");
    }

    @Override // com.obric.memorydata.migration.sdk.k
    public String a() {
        return this.f11882b;
    }

    @Override // com.obric.memorydata.migration.sdk.k
    public Object b(Context r3, File r4, m r5, Continuation<? super z<Unit>> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        m r8 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        Bundle r10 = new Bundle();
        r10.putString("addon_dir", r4.getAbsolutePath());
        return a(r7, this.f, r10, "恢复");
    }
}
