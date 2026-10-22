package com.obric.memorydata.personalcontext.impl;

import com.obric.memorydata.middleware.api.bridge.IDbBridgeAPI;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.database.DatabaseException;
import com.obric.memorydata.middleware.database.c;
import com.obric.memorydata.middleware.database.e;
import com.obric.memorydata.middleware.database.k;
import com.obric.memorydata.middleware.database.m;
import com.obric.memorydata.middleware.database.n;
import com.obric.memorydata.personalcontext.bridge.d;
import com.obric.memorydata.personalcontext.vectordb.PersonalVectorDbFileMigrator;
import com.obric.memorydata.personalcontext.vectordb.f;
import com.obric.memorydata.utils.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/DbBridgeImpl;", "Lcom/obric/memorydata/middleware/api/bridge/IDbBridgeAPI;", "<init>", "()V", "getInst", "initSqlDatabase", "", "dbSchemaJson", "Lorg/json/JSONObject;", "initVectorDatabase", "initInvertedIndexDatabase", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DbBridgeImpl implements IDbBridgeAPI {
    public static final DbBridgeImpl INSTANCE = null;

    static {
        INSTANCE = new DbBridgeImpl();
    }

    private DbBridgeImpl() {
    }

    @JvmStatic
    public static final DbBridgeImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IDbBridgeAPI
    public void initInvertedIndexDatabase(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "dbSchemaJson");
        RunLog.INSTANCE.debug("DbBridgeImpl", "initInvertedIndexDatabase " + r3);
        e r2 = (e) ZeusTransformUtils.preCheckCast(ab.a().fromJson(r3.toString(), e.class), e.class, "com.obric.memorydata.plugin");
        r2.f();     // Catch: Throwable -> L5
        d r4 = d.f12043a;     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L5
        r4.a(r2);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        throw new DatabaseException(r2.e(), th);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IDbBridgeAPI
    public void initSqlDatabase(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "dbSchemaJson");
        k r1 = (k) ZeusTransformUtils.preCheckCast(ab.a().fromJson(r2.toString(), k.class), k.class, "com.obric.memorydata.plugin");
        r1.e();
        c r3 = c.f11648a;
        Intrinsics.checkNotNull(r1);
        r3.a(r1);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IDbBridgeAPI
    public void initVectorDatabase(JSONObject r7) {
        Intrinsics.checkNotNullParameter(r7, "dbSchemaJson");
        m r6 = (m) ZeusTransformUtils.preCheckCast(ab.a().fromJson(r7.toString(), m.class), m.class, "com.obric.memorydata.plugin");
        n.a r0 = n.f11672a;
        Intrinsics.checkNotNull(r6);
        n r1 = r0.a(r6);
        com.obric.dejavu.library.d r2 = r1.a();
        com.obric.dejavu.library.d r3 = r1.b();
        if (r6.b() == false) goto L5;
        PersonalVectorDbFileMigrator.f12393a.a(r6.a(), r2.a(), r3.a());
    L5:
        f.f12411a.a(r6.a(), r2, r3);
        f.f12411a.a(r2, false);
        f.f12411a.a(r3, true);
        RunLog.INSTANCE.debug("DbBridgeImpl", "initVectorDatabase " + r7);
    }
}
