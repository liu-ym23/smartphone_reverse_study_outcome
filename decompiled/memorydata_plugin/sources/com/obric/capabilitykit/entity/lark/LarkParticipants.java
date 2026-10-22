package com.obric.capabilitykit.entity.lark;

import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.GroupChatEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/obric/capabilitykit/entity/lark/LarkParticipants;", "", "contacts", "", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "groups", "Lcom/obric/capabilitykit/entity/app/GroupChatEntity;", "(Ljava/util/List;Ljava/util/List;)V", "getContacts", "()Ljava/util/List;", "getGroups", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LarkParticipants {
    private final List<ContactEntity> contacts;
    private final List<GroupChatEntity> groups;

    public LarkParticipants(List<ContactEntity> r3, List<GroupChatEntity> r4) {
        List<ContactEntity> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<GroupChatEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.contacts = r5;
        this.groups = r6;
    }

    public static /* synthetic */ LarkParticipants copy$default(LarkParticipants r1, List r2, List r3, int r4, Object r5) {
        List<ContactEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List<GroupChatEntity> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.contacts;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r7 = r1.groups;
    L9:
        return r1.copy(r6, r7);
    }

    public final List<ContactEntity> component1() {
        return this.contacts;
    }

    public final List<GroupChatEntity> component2() {
        return this.groups;
    }

    public final LarkParticipants copy(List<ContactEntity> r2, List<GroupChatEntity> r3) {
        return new LarkParticipants((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, LarkParticipants.class) == true) goto L8;
        return false;
    L8:
        LarkParticipants r6 = (LarkParticipants) ZeusTransformUtils.preCheckCast(r5, LarkParticipants.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.contacts, r6.contacts) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.groups, r6.groups) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final List<ContactEntity> getContacts() {
        return this.contacts;
    }

    public final List<GroupChatEntity> getGroups() {
        return this.groups;
    }

    public int hashCode() {
        List<ContactEntity> r0 = this.contacts;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<GroupChatEntity> r4 = this.groups;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "LarkParticipants(contacts=" + this.contacts + ", groups=" + this.groups + ')';
    }
}
