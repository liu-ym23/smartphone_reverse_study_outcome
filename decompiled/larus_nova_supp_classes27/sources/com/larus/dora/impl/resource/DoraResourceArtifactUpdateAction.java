package com.larus.dora.impl.resource;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/impl/resource/DoraResourceArtifactUpdateAction;", "", "<init>", "(Ljava/lang/String;I)V", "INSTALL", "UNCHANGED", "KEEP_ACTIVE", "INVALID", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraResourceArtifactUpdateAction extends Enum<DoraResourceArtifactUpdateAction> {
    public static final DoraResourceArtifactUpdateAction INSTALL = null;
    public static final DoraResourceArtifactUpdateAction INVALID = null;
    public static final DoraResourceArtifactUpdateAction KEEP_ACTIVE = null;
    public static final DoraResourceArtifactUpdateAction UNCHANGED = null;
    public static final /* synthetic */ DoraResourceArtifactUpdateAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraResourceArtifactUpdateAction> getEntries() {
        return b;
    }

    static {
        DoraResourceArtifactUpdateAction r0 = new DoraResourceArtifactUpdateAction("INSTALL", 0);
        INSTALL = r0;
        DoraResourceArtifactUpdateAction r1 = new DoraResourceArtifactUpdateAction("UNCHANGED", 1);
        UNCHANGED = r1;
        DoraResourceArtifactUpdateAction r3 = new DoraResourceArtifactUpdateAction("KEEP_ACTIVE", 2);
        KEEP_ACTIVE = r3;
        DoraResourceArtifactUpdateAction r5 = new DoraResourceArtifactUpdateAction("INVALID", 3);
        INVALID = r5;
        DoraResourceArtifactUpdateAction[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static DoraResourceArtifactUpdateAction[] values() {
        return (DoraResourceArtifactUpdateAction[]) a.clone();
    }

    public static DoraResourceArtifactUpdateAction valueOf(String r1) {
        return (DoraResourceArtifactUpdateAction) a.a(DoraResourceArtifactUpdateAction.class, r1);
    }

    public DoraResourceArtifactUpdateAction(String r1, int r2) {
        super(r1, r2);
    }
}
