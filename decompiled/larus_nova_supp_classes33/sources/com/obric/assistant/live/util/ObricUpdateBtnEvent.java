package com.obric.assistant.live.util;

import com.google.gson.annotations.SerializedName;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.livecard.api.entity.Text;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sea.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/live/util/ObricUpdateBtnEvent;", "", "id", "", "disabled", "", "text", "Lcom/obric/livecard/api/entity/Text;", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/obric/livecard/api/entity/Text;)V", "getId", "()Ljava/lang/String;", "getDisabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getText", "()Lcom/obric/livecard/api/entity/Text;", "btnId", "getBtnId", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/obric/livecard/api/entity/Text;)Lcom/obric/assistant/live/util/ObricUpdateBtnEvent;", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricUpdateBtnEvent {

    @SerializedName("btnId")
    private final String btnId;

    @SerializedName("disabled")
    private final Boolean disabled;
    private final transient String id;

    @SerializedName("text")
    private final Text text;

    public ObricUpdateBtnEvent() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ObricUpdateBtnEvent copy$default(ObricUpdateBtnEvent r0, String r1, Boolean r2, Text r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.disabled;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.text;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.id;
    }

    public final Boolean component2() {
        return this.disabled;
    }

    public final Text component3() {
        return this.text;
    }

    public final ObricUpdateBtnEvent copy(String r2, Boolean r3, Text r4) {
        return new ObricUpdateBtnEvent(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricUpdateBtnEvent) == true) goto L8;
        return false;
    L8:
        ObricUpdateBtnEvent r6 = (ObricUpdateBtnEvent) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.disabled, r6.disabled) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.disabled;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Text r7 = this.text;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricUpdateBtnEvent(id=" + this.id + ", disabled=" + this.disabled + ", text=" + this.text + ')';
    }

    public final String getBtnId() {
        return this.btnId;
    }

    public final Boolean getDisabled() {
        return this.disabled;
    }

    public final String getId() {
        return this.id;
    }

    public final Text getText() {
        return this.text;
    }

    public ObricUpdateBtnEvent(String r1, Boolean r2, Text r3) {
        this.id = r1;
        this.disabled = r2;
        this.text = r3;
        if (r1 != null) goto L5;
        r1 = "actionBtn";
    L5:
        this.btnId = r1;
    }

    public /* synthetic */ ObricUpdateBtnEvent(String r15, Boolean r16, Text r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Boolean r1 = Boolean.FALSE;
    L11:
        if ((r18 & 4) != 0) goto L13;
        Text r2 = r17;
    L22:
        this(r0, r1, r2);
        return;
    L13:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L15;
        String r3 = AppHost.a.getApplication().getString(2131912330);
    L16:
        String r4 = r3;
        Intrinsics.checkNotNull(r4);
        if (r0 == null) goto L19;
        String r5 = "#E5FFFFFF";
    L20:
        r2 = new Text(r4, 14, r5, null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null);
        goto L22
    L19:
        r5 = "var:ai-gradient-a3";
        goto L20
    L15:
        r3 = AppHost.a.getApplication().getString(2131912331);
        goto L16
    L9:
        r1 = r16;
        goto L11
    L5:
        r0 = r15;
        goto L7
    }
}
