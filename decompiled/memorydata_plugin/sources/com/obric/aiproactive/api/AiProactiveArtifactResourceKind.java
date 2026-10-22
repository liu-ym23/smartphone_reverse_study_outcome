package com.obric.aiproactive.api;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/obric/aiproactive/api/AiProactiveArtifactResourceKind;", "", "wireValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getWireValue", "()Ljava/lang/String;", "EXPORTED_FILE", "CONTENT_URI", "HTTPS", "OBJECT_KEY", "Companion", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AiProactiveArtifactResourceKind extends Enum<AiProactiveArtifactResourceKind> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AiProactiveArtifactResourceKind[] $VALUES = null;
    public static final AiProactiveArtifactResourceKind CONTENT_URI = null;
    public static final a Companion = null;
    public static final AiProactiveArtifactResourceKind EXPORTED_FILE = null;
    public static final AiProactiveArtifactResourceKind HTTPS = null;
    public static final AiProactiveArtifactResourceKind OBJECT_KEY = null;
    private final String wireValue;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aiproactive/api/AiProactiveArtifactResourceKind$Companion;", "", "<init>", "()V", "fromWireValue", "Lcom/obric/aiproactive/api/AiProactiveArtifactResourceKind;", EventBody.KEY_VALUE, "", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final AiProactiveArtifactResourceKind a(String r4) {
            Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(AiProactiveArtifactResourceKind.getEntries(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r3.hasNext() == false) goto L8;
            Object r0 = r3.next();
            if (Intrinsics.areEqual(((AiProactiveArtifactResourceKind) ZeusTransformUtils.preCheckCast(r0, AiProactiveArtifactResourceKind.class, "com.obric.memorydata.plugin")).getWireValue(), r4) == false) goto L4;
        L10:
            return (AiProactiveArtifactResourceKind) ZeusTransformUtils.preCheckCast(r0, AiProactiveArtifactResourceKind.class, "com.obric.memorydata.plugin");
        L8:
            r0 = null;
            goto L10
        }
    }

    private static final /* synthetic */ AiProactiveArtifactResourceKind[] $values() {
        return new AiProactiveArtifactResourceKind[]{EXPORTED_FILE, CONTENT_URI, HTTPS, OBJECT_KEY};
    }

    static {
        EXPORTED_FILE = new AiProactiveArtifactResourceKind("EXPORTED_FILE", 0, "exported_file");
        CONTENT_URI = new AiProactiveArtifactResourceKind("CONTENT_URI", 1, "content_uri");
        HTTPS = new AiProactiveArtifactResourceKind("HTTPS", 2, LocationInfoConst.HTTPS);
        OBJECT_KEY = new AiProactiveArtifactResourceKind("OBJECT_KEY", 3, "object_key");
        AiProactiveArtifactResourceKind[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private AiProactiveArtifactResourceKind(String r1, int r2, String r3) {
        super(r1, r2);
        this.wireValue = r3;
    }

    public static EnumEntries<AiProactiveArtifactResourceKind> getEntries() {
        return $ENTRIES;
    }

    public static AiProactiveArtifactResourceKind valueOf(String r2) {
        return (AiProactiveArtifactResourceKind) ZeusTransformUtils.preCheckCast(Enum.valueOf(AiProactiveArtifactResourceKind.class, r2), AiProactiveArtifactResourceKind.class, "com.obric.memorydata.plugin");
    }

    public static AiProactiveArtifactResourceKind[] values() {
        return (AiProactiveArtifactResourceKind[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AiProactiveArtifactResourceKind[].class, "com.obric.memorydata.plugin");
    }

    public final String getWireValue() {
        return this.wireValue;
    }
}
