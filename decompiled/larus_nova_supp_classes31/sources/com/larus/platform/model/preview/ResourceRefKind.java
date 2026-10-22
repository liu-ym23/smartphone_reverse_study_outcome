package com.larus.platform.model.preview;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/platform/model/preview/ResourceRefKind;", "", "<init>", "(Ljava/lang/String;I)V", "LOCAL_URI", "REMOTE_URL", "CLOUD_TOKEN", "UPLOADING", "REMOTE_KEY", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum ResourceRefKind extends Enum<ResourceRefKind> {
    public static final ResourceRefKind CLOUD_TOKEN = null;
    public static final ResourceRefKind LOCAL_URI = null;
    public static final ResourceRefKind REMOTE_KEY = null;
    public static final ResourceRefKind REMOTE_URL = null;
    public static final ResourceRefKind UPLOADING = null;
    public static final /* synthetic */ ResourceRefKind[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ResourceRefKind> getEntries() {
        return b;
    }

    static {
        ResourceRefKind r0 = new ResourceRefKind("LOCAL_URI", 0);
        LOCAL_URI = r0;
        ResourceRefKind r1 = new ResourceRefKind("REMOTE_URL", 1);
        REMOTE_URL = r1;
        ResourceRefKind r3 = new ResourceRefKind("CLOUD_TOKEN", 2);
        CLOUD_TOKEN = r3;
        ResourceRefKind r5 = new ResourceRefKind("UPLOADING", 3);
        UPLOADING = r5;
        ResourceRefKind r7 = new ResourceRefKind("REMOTE_KEY", 4);
        REMOTE_KEY = r7;
        ResourceRefKind[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static ResourceRefKind[] values() {
        return (ResourceRefKind[]) a.clone();
    }

    public static ResourceRefKind valueOf(String r1) {
        return (ResourceRefKind) a.a(ResourceRefKind.class, r1);
    }

    public ResourceRefKind(String r1, int r2) {
        super(r1, r2);
    }
}
