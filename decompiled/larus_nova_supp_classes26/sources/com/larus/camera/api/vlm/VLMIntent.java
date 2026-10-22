package com.larus.camera.api.vlm;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/camera/api/vlm/VLMIntent;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "COMMON", "EDU", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VLMIntent extends Enum<VLMIntent> {
    public static final VLMIntent COMMON = null;
    public static final a Companion = null;
    public static final VLMIntent EDU = null;
    public static final /* synthetic */ VLMIntent[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<VLMIntent> getEntries() {
        return b;
    }

    static {
        VLMIntent r0 = new VLMIntent("COMMON", 0, 1);
        COMMON = r0;
        VLMIntent r1 = new VLMIntent("EDU", 1, 2);
        EDU = r1;
        VLMIntent[] r4 = {r0, r1};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
        Companion = new a();
    }

    public static VLMIntent[] values() {
        return (VLMIntent[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static VLMIntent valueOf(String r1) {
        return (VLMIntent) r27.a.a(VLMIntent.class, r1);
    }

    public VLMIntent(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
