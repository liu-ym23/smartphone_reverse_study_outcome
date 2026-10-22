package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressPageItem;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/h0;", "", "", "Lcom/bytedance/android/livesdkapi/depend/message/MidiSkinDressPageItem;", "midiSkins", "Ljava/util/List;", "a", "()Ljava/util/List;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class h0 implements vh7.h {

    @SerializedName("midi_skins")
    protected List<MidiSkinDressPageItem> midiSkins;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof h0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.midiSkins, ((h0) r2).midiSkins) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<MidiSkinDressPageItem> r0 = this.midiSkins;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "MidiSkinList(midiSkins=" + this.midiSkins + ")";
    }

    public h0() {
        this.midiSkins = null;
    }

    public final List<MidiSkinDressPageItem> a() {
        return this.midiSkins;
    }

    public h0(am3.g r5) {
        this.midiSkins = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.midiSkins.add(new MidiSkinDressPageItem(r5));
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
        if (this.midiSkins.isEmpty() == false) goto L19;
        this.midiSkins = null;
        return;
    }
}
