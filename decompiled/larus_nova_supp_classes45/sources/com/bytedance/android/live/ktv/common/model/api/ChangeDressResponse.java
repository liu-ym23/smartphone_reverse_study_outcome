package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/ChangeDressResponse;", "", "midiSkinInfo", "Lcom/bytedance/android/livesdkapi/depend/message/MidiSkinDressInfo;", "(Lcom/bytedance/android/livesdkapi/depend/message/MidiSkinDressInfo;)V", "getMidiSkinInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/MidiSkinDressInfo;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChangeDressResponse implements vh7.h {

    @SerializedName("midi_skin_info")
    protected MidiSkinDressInfo midiSkinInfo;

    public ChangeDressResponse(MidiSkinDressInfo r1) {
        this.midiSkinInfo = r1;
    }

    public static /* synthetic */ ChangeDressResponse copy$default(ChangeDressResponse r0, MidiSkinDressInfo r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.midiSkinInfo;
    L6:
        return r0.copy(r1);
    }

    public final MidiSkinDressInfo component1() {
        return this.midiSkinInfo;
    }

    public final ChangeDressResponse copy(MidiSkinDressInfo r2) {
        return new ChangeDressResponse(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof ChangeDressResponse) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.midiSkinInfo, ((ChangeDressResponse) r2).midiSkinInfo) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        MidiSkinDressInfo r0 = this.midiSkinInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "ChangeDressResponse(midiSkinInfo=" + this.midiSkinInfo + ")";
    }

    public ChangeDressResponse() {
        this.midiSkinInfo = null;
    }

    public final MidiSkinDressInfo getMidiSkinInfo() {
        return this.midiSkinInfo;
    }

    public ChangeDressResponse(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.midiSkinInfo = new MidiSkinDressInfo(r5);
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
        if (this.midiSkinInfo != null) goto L19;
        this.midiSkinInfo = null;
        return;
    }

    public /* synthetic */ ChangeDressResponse(MidiSkinDressInfo r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
