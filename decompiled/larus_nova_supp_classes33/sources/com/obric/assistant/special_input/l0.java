package com.obric.assistant.special_input;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\b\u0018\u0000 (2\u00020\u0001:\u0001(BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0018JR\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006)"}, d2 = {"Lcom/obric/assistant/special_input/PhoneOperationAttachmentDraftRecord;", "", "hasAttachment", "", "localMsgId", "", "fileIdentifiers", "", "specialPanel", "Lcom/obric/assistant/special_input/PhoneOperationSpecialPanelDraftRecord;", "updatedAt", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Lcom/obric/assistant/special_input/PhoneOperationSpecialPanelDraftRecord;Ljava/lang/Long;)V", "getHasAttachment", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLocalMsgId", "()Ljava/lang/String;", "getFileIdentifiers", "()Ljava/util/List;", "getSpecialPanel", "()Lcom/obric/assistant/special_input/PhoneOperationSpecialPanelDraftRecord;", "getUpdatedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "toContextOrNull", "Lcom/obric/assistant/special_input/PhoneOperationAttachmentDraftContext;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Lcom/obric/assistant/special_input/PhoneOperationSpecialPanelDraftRecord;Ljava/lang/Long;)Lcom/obric/assistant/special_input/PhoneOperationAttachmentDraftRecord;", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class l0 {
    public static final /* synthetic */ int a = 0;

    @SerializedName("file_identifiers")
    private final List<String> fileIdentifiers;

    @SerializedName("o_omni_has_attachment")
    private final Boolean hasAttachment;

    @SerializedName("local_msg_id")
    private final String localMsgId;

    @SerializedName("special_panel")
    private final r0 specialPanel;

    @SerializedName("updated_at")
    private final Long updatedAt;

    public static final class a {
        public static l0 a(k0 r13) {
            Intrinsics.checkNotNullParameter(r13, "context");
            Boolean r3 = Boolean.valueOf(r13.a);
            String r4 = r13.b;
            List<String> r5 = r13.c;
            q0 r1 = r13.d;
            if (r1 == null) goto L5;
            int r2 = r0.a;
            Intrinsics.checkNotNullParameter(r1, "context");
            r0 r6 = new r0(Integer.valueOf(r1.a), r1.b, r1.c, r1.d, r1.e, r1.f);
        L7:
            return new l0(r3, r4, r5, r6, Long.valueOf(r13.e));
        L5:
            r6 = null;
            goto L7
        }
    }

    static {
    }

    public l0() {
        this(null, null, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r6 = (l0) r5;
        if (Intrinsics.areEqual(this.hasAttachment, r6.hasAttachment) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.localMsgId, r6.localMsgId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fileIdentifiers, r6.fileIdentifiers) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.specialPanel, r6.specialPanel) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.updatedAt, r6.updatedAt) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.hasAttachment;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.localMsgId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.fileIdentifiers;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        r0 r10 = this.specialPanel;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.updatedAt;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
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
        return "PhoneOperationAttachmentDraftRecord(hasAttachment=" + this.hasAttachment + ", localMsgId=" + this.localMsgId + ", fileIdentifiers=" + this.fileIdentifiers + ", specialPanel=" + this.specialPanel + ", updatedAt=" + this.updatedAt + ')';
    }

    public final k0 a() {
        if (Intrinsics.areEqual(this.hasAttachment, Boolean.FALSE) == false) goto L5;
        return null;
    L5:
        String r0 = this.localMsgId;
        if (r0 == null) goto L49;
        boolean r3 = true;
        if ((!StringsKt.isBlank(r0)) == false) goto L10;
        String r6 = r0;
    L11:
        if (r6 == null) goto L49;
        List<String> r1 = this.fileIdentifiers;
        if (r1 != null) goto L16;
        r1 = CollectionsKt.emptyList();
    L16:
        ArrayList r2 = new ArrayList();
        Iterator<T> r4 = r1.iterator();
    L18:
        if (r4.hasNext() == false) goto L27;
        String r5 = (String) r4.next();
        if (r5 != null) goto L22;
    L24:
        r5 = null;
    L25:
        if (r5 == null) goto L18;
        r2.add(r5);
        goto L18
    L22:
        if ((!StringsKt.isBlank(r5)) == false) goto L24;
    L27:
        List r7 = CollectionsKt.distinct(r2);
        if (r7.isEmpty() == false) goto L30;
        return null;
    L30:
        Long r8 = this.updatedAt;
        if (r8 == null) goto L49;
        if (r8.longValue() > 0) goto L36;
        r3 = false;
    L36:
        if (r3 == true) goto L39;
        r8 = null;
    L39:
        if (r8 == null) goto L49;
        long r9 = r8.longValue();
        r0 r10 = this.specialPanel;
        if (r10 == null) goto L43;
        q0 r11 = r10.a();
    L44:
        if (r10 == null) goto L48;
        if (r11 != null) goto L48;
        return null;
    L48:
        return new k0(true, r6, r7, r11, r9);
    L43:
        r11 = null;
        goto L44
    L10:
        r6 = null;
    L49:
        return null;
    }

    public l0(Boolean r1, String r2, List<String> r3, r0 r4, Long r5) {
        this.hasAttachment = r1;
        this.localMsgId = r2;
        this.fileIdentifiers = r3;
        this.specialPanel = r4;
        this.updatedAt = r5;
    }
}
