package com.obric.aiproactive.api;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/obric/aiproactive/api/AiProactiveArtifactType;", "", "wireValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getWireValue", "()Ljava/lang/String;", "IMAGE", "VIDEO", "AUDIO", "FILE", "LINK", "Companion", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AiProactiveArtifactType extends Enum<AiProactiveArtifactType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AiProactiveArtifactType[] $VALUES = null;
    public static final AiProactiveArtifactType AUDIO = null;
    public static final a Companion = null;
    public static final AiProactiveArtifactType FILE = null;
    public static final AiProactiveArtifactType IMAGE = null;
    public static final AiProactiveArtifactType LINK = null;
    public static final AiProactiveArtifactType VIDEO = null;
    private final String wireValue;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aiproactive/api/AiProactiveArtifactType$Companion;", "", "<init>", "()V", "fromWireValue", "Lcom/obric/aiproactive/api/AiProactiveArtifactType;", EventBody.KEY_VALUE, "", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final AiProactiveArtifactType a(String r4) {
            Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(AiProactiveArtifactType.getEntries(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r3.hasNext() == false) goto L8;
            Object r0 = r3.next();
            if (Intrinsics.areEqual(((AiProactiveArtifactType) ZeusTransformUtils.preCheckCast(r0, AiProactiveArtifactType.class, "com.obric.memorydata.plugin")).getWireValue(), r4) == false) goto L4;
        L10:
            return (AiProactiveArtifactType) ZeusTransformUtils.preCheckCast(r0, AiProactiveArtifactType.class, "com.obric.memorydata.plugin");
        L8:
            r0 = null;
            goto L10
        }
    }

    private static final /* synthetic */ AiProactiveArtifactType[] $values() {
        return new AiProactiveArtifactType[]{IMAGE, VIDEO, AUDIO, FILE, LINK};
    }

    static {
        IMAGE = new AiProactiveArtifactType("IMAGE", 0, "image");
        VIDEO = new AiProactiveArtifactType("VIDEO", 1, "video");
        AUDIO = new AiProactiveArtifactType("AUDIO", 2, "audio");
        FILE = new AiProactiveArtifactType("FILE", 3, "file");
        LINK = new AiProactiveArtifactType("LINK", 4, "link");
        AiProactiveArtifactType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private AiProactiveArtifactType(String r1, int r2, String r3) {
        super(r1, r2);
        this.wireValue = r3;
    }

    public static EnumEntries<AiProactiveArtifactType> getEntries() {
        return $ENTRIES;
    }

    public static AiProactiveArtifactType valueOf(String r2) {
        return (AiProactiveArtifactType) ZeusTransformUtils.preCheckCast(Enum.valueOf(AiProactiveArtifactType.class, r2), AiProactiveArtifactType.class, "com.obric.memorydata.plugin");
    }

    public static AiProactiveArtifactType[] values() {
        return (AiProactiveArtifactType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AiProactiveArtifactType[].class, "com.obric.memorydata.plugin");
    }

    public final String getWireValue() {
        return this.wireValue;
    }
}
