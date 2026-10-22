package com.obric.memorydata.middleware.database;

import android.content.Context;
import android.os.Bundle;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.aiassistant.security.secretdata.AddResult;
import com.aiassistant.security.secretdata.QueryResult;
import com.aiassistant.security.secretdata.SecretData;
import com.aiassistant.security.secretdata.SecretDataManager;
import com.bytedance.crash.util.RomUtils;
import com.bytedance.security.dbcipher.RoomCipherDBImpl;
import com.bytedance.security.dbcipher.SqliteCipherDBImpl;
import com.bytedance.security.dbcipher.utils.CipherConfig;
import com.bytedance.security.dbcipher.utils.CipherConst;
import com.bytedance.security.dbcipher.utils.DBCipherUtils;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.am;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J\u0016\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00050\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/middleware/database/EncryptHelper;", "", "<init>", "()V", "TAG", "", "KDF_ITERATIONS", "", "ENCRYPT_PAGE_SIZE", "serviceStatusProperty", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "getSQLOpenHelperFactory", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "dbName", "getEncryptDb", "Lnet/zetetic/database/sqlcipher/SQLiteDatabase;", "getOrCreatePassPhrase", "savePassPhrase", "", "passPhrase", "updatePassPhrase", "updateAssistantPassPhrase", "updateObricPassPhrase", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f11652a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f11653b;

    static {
        f11652a = new d();
        f11653b = RomUtils.getSystemProperty("vendor.km.rpmb.status");
    }

    private d() {
    }

    public final SupportSQLiteOpenHelper.Factory a(String r9) {
        Intrinsics.checkNotNullParameter(r9, "dbName");
        CipherConfig r0 = new CipherConfig(false, CipherConst.PBKDF2_HMAC_SHA256, 10000, CipherConst.HMAC_SHA256, 8192, "NONE");
        SupportSQLiteOpenHelper.Factory r8 = new RoomCipherDBImpl().preOpenOrCreateDb((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r9, c(r9), r0);
        Intrinsics.checkNotNullExpressionValue(r8, "preOpenOrCreateDb(...)");
        return r8;
    }

    public final void a(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "dbName");
        Intrinsics.checkNotNullParameter(r11, "passPhrase");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EncryptHelper", "save passPhrase for " + r10, false, 4, null);
        if (am.f13169a.c() == false) goto L9;
        SecretData r9 = new SecretData();
        r9.alias = r10;
        r9.dataType = "DBKey";
        r9.secretData = r11;
        AddResult r12 = SecretDataManager.getInstance().addData((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r9, new Bundle());
        if (r12.getResultCode() == 0) goto L14;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EncryptHelper", "save passPhrase failed, code: " + r12.getResultCode(), null, 4, null);
        throw new RuntimeException("save passPhrase failed, code: " + r12.getResultCode());
    L14:
        return;
    L9:
        com.obric.security.secretdata.SecretData r13 = new com.obric.security.secretdata.SecretData();
        r13.alias = r10;
        r13.dataType = "DBKey";
        r13.secretData = r11;
        com.obric.security.secretdata.AddResult r14 = com.obric.security.secretdata.SecretDataManager.getInstance().addData((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r13, new Bundle());
        if (r14.getResultCode() != 0) goto L12;
        return;
    L12:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EncryptHelper", "save passPhrase failed, code: " + r14.getResultCode(), null, 4, null);
        throw new RuntimeException("save passPhrase failed, code: " + r14.getResultCode());
    }

    public final SQLiteDatabase b(String r9) {
        Intrinsics.checkNotNullParameter(r9, "dbName");
        CipherConfig r0 = new CipherConfig(false, CipherConst.PBKDF2_HMAC_SHA256, 10000, CipherConst.HMAC_SHA256, 8192, "NONE");
        return new SqliteCipherDBImpl().openOrCreateDatabase((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r9, c(r9), r0);
    }

    public final String c(String r14) {
        Intrinsics.checkNotNullParameter(r14, "dbName");
        Bundle r0 = new Bundle();
        r0.putInt("query_mode", 2);
        com.obric.security.secretdata.SecretData r6 = null;
        SecretData r7 = null;
        r7 = null;
        r6 = null;
        if (am.f13169a.c() == false) goto L16;
        QueryResult r1 = SecretDataManager.getInstance().queryData((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r14, r0);
        if (r1 == null) goto L9;
        List<SecretData> r2 = r1.getDataList();
        if (r2 == null) goto L9;
        r7 = (SecretData) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r2), SecretData.class, "com.obric.memorydata.plugin");
    L9:
        if (r7 != null) goto L13;
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = new StringBuilder();
    L11:
        IRunLog.a.a(r4, "EncryptHelper", r3.append("generate and save passPhrase for ").append(r14).toString(), false, 4, null);
        String r5 = DBCipherUtils.generateRandomPassPhrase(32);
        Intrinsics.checkNotNull(r5);
        a(r14, r5);
        return r5;
    L13:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EncryptHelper", "get passPhrase from SecretManager for " + r14, false, 4, null);
        String r13 = r7.secretData;
    L14:
        Intrinsics.checkNotNullExpressionValue(r13, "secretData");
        return r13;
    L16:
        com.obric.security.secretdata.QueryResult r8 = com.obric.security.secretdata.SecretDataManager.getInstance().queryData((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r14, r0);
        if (r8 == null) goto L21;
        List<com.obric.security.secretdata.SecretData> r9 = r8.getDataList();
        if (r9 == null) goto L21;
        r6 = (com.obric.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r9), com.obric.security.secretdata.SecretData.class, "com.obric.memorydata.plugin");
    L21:
        if (r6 != null) goto L23;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r3 = new StringBuilder();
        goto L11
    L23:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EncryptHelper", "get passPhrase from SecretManager for " + r14, false, 4, null);
        r13 = r6.secretData;
        goto L14
    }
}
