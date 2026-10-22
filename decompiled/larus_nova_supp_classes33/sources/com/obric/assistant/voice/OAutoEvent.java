package com.obric.assistant.voice;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/voice/OAutoEvent;", "Landroid/os/Parcelable;", "id", "", "content", "stateInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Parcelable;)V", "()V", "getId", "()Ljava/lang/String;", "getContent", "getStateInfo", "()Landroid/os/Parcelable;", "toString", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OAutoEvent implements Parcelable {
    public static final Parcelable.Creator<OAutoEvent> CREATOR = null;

    @SerializedName("content")
    private final String content;

    @SerializedName("id")
    private final String id;

    @SerializedName("stateInfo")
    private final Parcelable stateInfo;

    public static final class a implements Parcelable.Creator<OAutoEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OAutoEvent createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            return new OAutoEvent(r5.readString(), r5.readString(), r5.readParcelable(OAutoEvent.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final OAutoEvent[] newArray(int r1) {
            return new OAutoEvent[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public OAutoEvent() {
        this(null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OAutoEvent) == true) goto L8;
        return false;
    L8:
        OAutoEvent r6 = (OAutoEvent) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.stateInfo, r6.stateInfo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.content;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Parcelable r7 = this.stateInfo;
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

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeString(this.id);
        r2.writeString(this.content);
        r2.writeParcelable(this.stateInfo, r3);
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("id ");
        r0.append(this.id);
        r0.append(" content.length ");
        String r1 = this.content;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.length());
    L6:
        r0.append(r2);
        r0.append(" stateInfo ");
        if (this.stateInfo == null) goto L9;
        boolean r3 = true;
    L10:
        r0.append(r3);
        return r0.toString();
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final String a() {
        return this.content;
    }

    public OAutoEvent(String r1, String r2, Parcelable r3) {
        this.id = r1;
        this.content = r2;
        this.stateInfo = r3;
    }
}
