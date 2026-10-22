package com.obric.memorydata.datatransport.a;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/datatransport/entity/ConstructedAppEntity;", "", OaidModel.KEY_ID, "", "createTime", "", "lastModifiedTime", "type", "", "_version", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;II)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLastModifiedTime", "setLastModifiedTime", "getType", "()I", "get_version", "toOriginalAppEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "generateEvaluationId", "Companion", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0468a f9716a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9717b;
    private Long c;
    private Long d;
    private final int e;

    /* JADX INFO: renamed from: com.obric.memorydata.datatransport.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/datatransport/entity/ConstructedAppEntity$Companion;", "", "<init>", "()V", "TAG", "", "getConstructAppEntityByString", "Lcom/obric/memorydata/datatransport/entity/ConstructedAppEntity;", "jsonString", "type", "", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/memorydata/datatransport/entity/ConstructedAppEntity;", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0468a {
        private C0468a() {
        }

        public /* synthetic */ C0468a(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ a a(C0468a r0, String r1, Integer r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = null;
        L6:
            return r0.a(r1, r2);
        }

        public final a a(String r3, Integer r4) {
            Intrinsics.checkNotNullParameter(r3, "jsonString");
            com.obric.memorydata.datatransport.excel.b.h r0 = (com.obric.memorydata.datatransport.excel.b.h) ZeusTransformUtils.preCheckCast(ab.a().fromJson(r3, com.obric.memorydata.datatransport.excel.b.h.class), com.obric.memorydata.datatransport.excel.b.h.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L22
            if (r4 == null) goto L7;
            r0.a(r4.intValue());     // Catch: Exception -> L22
        L7:
            if (r0.getType() != 201) goto L11;
            Object r5 = ab.a().fromJson(r3, c.class);     // Catch: Exception -> L22
            Class<a> r1 = a.class;
        L9:
            return (a) ZeusTransformUtils.preCheckCast(r5, r1, "com.obric.memorydata.plugin");
        L11:
            if (r0.getType() != 101) goto L14;
            r5 = ab.a().fromJson(r3, d.class);     // Catch: Exception -> L22
            r1 = a.class;
            goto L9
        L14:
            if (r0.getType() != 202) goto L17;
            r5 = ab.a().fromJson(r3, b.class);     // Catch: Exception -> L22
            r1 = a.class;
            goto L9
        L17:
            if (r0.getType() != 601) goto L19;
            r5 = ab.a().fromJson(r3, e.class);     // Catch: Exception -> L22
            r1 = a.class;
            goto L9
        L19:
            r5 = ab.a().fromJson(r3, a.class);     // Catch: Exception -> L22
            r1 = a.class;
        L22:
            RunLog.INSTANCE.debug("ConstructedAppEntity", "getConstructAppEntityByString parse json string failed: " + r3);
            return null;
        }
    }

    static {
        f9716a = new C0468a(null);
    }

    public final String a() {
        return this.f9717b;
    }

    public final Long b() {
        return this.c;
    }

    public final Long c() {
        return this.d;
    }

    public AppEntity d() {
        return null;
    }

    public final int getType() {
        return this.e;
    }
}
