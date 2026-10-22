package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.inputtext.InputReferenceType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBW\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003HÆ\u0003JY\u0010\u0016\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00032\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionRecommendSnapshot;", "", "contacts", "", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/ContactSnapshot;", "groups", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/ReferenceSnapshot;", "drives", "conversations", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getContacts", "()Ljava/util/List;", "getGroups", "getDrives", "getConversations", "toRemoteData", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionPanelRemoteData;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final class z0 {
    public static final /* synthetic */ int a = 0;

    @SerializedName("contacts")
    private final List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.a> contacts;

    @SerializedName("conversations")
    private final List<e1> conversations;

    @SerializedName("drives")
    private final List<e1> drives;

    @SerializedName("groups")
    private final List<e1> groups;

    public static final class a {
    }

    static {
    }

    public z0() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof z0) == true) goto L8;
        return false;
    L8:
        z0 r6 = (z0) r5;
        if (Intrinsics.areEqual(this.contacts, r6.contacts) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.groups, r6.groups) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.drives, r6.drives) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.conversations, r6.conversations) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.a> r0 = this.contacts;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<e1> r4 = this.groups;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<e1> r7 = this.drives;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<e1> r10 = this.conversations;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MentionRecommendSnapshot(contacts=" + this.contacts + ", groups=" + this.groups + ", drives=" + this.drives + ", conversations=" + this.conversations + ')';
    }

    public final f0 a() {
        List<e1> r0 = this.drives;
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        ArrayList r2 = new ArrayList();
        Iterator<T> r1 = r0.iterator();
    L6:
        c1 r3 = null;
        if (r1.hasNext() == false) goto L13;
        e1 r4 = (e1) r1.next();
        if (r4 == null) goto L11;
        r3 = r4.a(InputReferenceType.DRIVE);
    L11:
        if (r3 == null) goto L6;
        r2.add(r3);
        goto L6
    L13:
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.a> r5 = this.contacts;
        if (r5 != null) goto L16;
        r5 = CollectionsKt.emptyList();
    L16:
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L18:
        if (r7.hasNext() == false) goto L25;
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.a r8 = (com.larus.bmhome.chat.component.bottom.core.inputtext.mention.a) r7.next();
        if (r8 == null) goto L22;
        qp8.c r9 = r8.a();
    L23:
        if (r9 == null) goto L18;
        r6.add(r9);
        goto L18
    L22:
        r9 = null;
        goto L23
    L25:
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r11 = r6.iterator();
    L27:
        if (r11.hasNext() == false) goto L29;
        r10.add(new c((qp8.c) r11.next(), null));
        goto L27
    L29:
        List<e1> r12 = this.groups;
        if (r12 != null) goto L32;
        r12 = CollectionsKt.emptyList();
    L32:
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L34:
        if (r14.hasNext() == false) goto L41;
        e1 r15 = (e1) r14.next();
        if (r15 == null) goto L38;
        c1 r16 = r15.a(InputReferenceType.GROUP);
    L39:
        if (r16 == null) goto L34;
        r13.add(r16);
        goto L34
    L38:
        r16 = null;
        goto L39
    L41:
        List<e1> r17 = this.conversations;
        if (r17 != null) goto L44;
        r17 = CollectionsKt.emptyList();
    L44:
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r17.iterator();
    L46:
        if (r19.hasNext() == false) goto L54;
        e1 r20 = (e1) r19.next();
        if (r20 == null) goto L50;
        c1 r21 = r20.a(InputReferenceType.CONVERSATION);
    L51:
        if (r21 == null) goto L46;
        r18.add(r21);
        goto L46
    L50:
        r21 = null;
        goto L51
    L54:
        return new f0(r2, r10, r13, r18, 16);
    }

    public z0(List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.a> r1, List<e1> r2, List<e1> r3, List<e1> r4) {
        this.contacts = r1;
        this.groups = r2;
        this.drives = r3;
        this.conversations = r4;
    }
}
