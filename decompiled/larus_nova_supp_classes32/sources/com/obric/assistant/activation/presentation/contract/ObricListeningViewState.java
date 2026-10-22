package com.obric.assistant.activation.presentation.contract;

import android.os.Parcel;
import android.os.Parcelable;
import com.lynx.xelement.overlay.LynxUIOverlay;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\r¨\u0006$"}, d2 = {"Lcom/obric/assistant/activation/presentation/contract/ObricListeningViewState;", "Landroid/os/Parcelable;", "mode", "Lcom/obric/assistant/activation/presentation/contract/ObricListeningVisualMode;", LynxUIOverlay.PROP_VISIBLE, NameKeys.UnloadStrategy_No_Strategy, "amplitude", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Lcom/obric/assistant/activation/presentation/contract/ObricListeningVisualMode;ZF)V", "getMode", "()Lcom/obric/assistant/activation/presentation/contract/ObricListeningVisualMode;", "getVisible", "()Z", "getAmplitude", "()F", "shouldRender", "getShouldRender", "component1", "component2", "component3", "copy", "describeContents", NameKeys.UnloadStrategy_No_Strategy, "equals", "other", NameKeys.UnloadStrategy_No_Strategy, "hashCode", "toString", NameKeys.UnloadStrategy_No_Strategy, "writeToParcel", NameKeys.UnloadStrategy_No_Strategy, "dest", "Landroid/os/Parcel;", "flags", "Companion", "contract_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricListeningViewState implements Parcelable {
    public static final Parcelable.Creator<ObricListeningViewState> CREATOR = null;
    public static final ObricListeningViewState d = null;
    public final ObricListeningVisualMode a;
    public final boolean b;
    public final float c;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<ObricListeningViewState> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ObricListeningViewState createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            ObricListeningVisualMode r1 = ObricListeningVisualMode.valueOf(r4.readString());
            if (r4.readInt() == 0) goto L5;
            boolean r2 = true;
        L7:
            return new ObricListeningViewState(r1, r2, r4.readFloat());
        L5:
            r2 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ObricListeningViewState[] newArray(int r1) {
            return new ObricListeningViewState[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricListeningViewState) == true) goto L8;
        return false;
    L8:
        ObricListeningViewState r6 = (ObricListeningViewState) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Float.compare(this.c, r6.c) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + Float.floatToIntBits(this.c);
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "ObricListeningViewState(mode=" + this.a + ", visible=" + this.b + ", amplitude=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.a.name());
        r1.writeInt(this.b ? 1 : 0);
        r1.writeFloat(this.c);
    }

    static {
        CREATOR = new b();
        d = new ObricListeningViewState(ObricListeningVisualMode.HIDDEN, false, 0.0f);
    }

    public final boolean b() {
        if (this.a != ObricListeningVisualMode.HIDDEN) goto L5;
    L7:
        return false;
    L5:
        if (this.b == false) goto L7;
        return true;
    }

    public ObricListeningViewState(ObricListeningVisualMode r2, boolean r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static ObricListeningViewState a(ObricListeningViewState r1, ObricListeningVisualMode r2, float r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.a;
    L6:
        if ((r4 & 2) == 0) goto L8;
        boolean r0 = r1.b;
    L10:
        if ((r4 & 4) == 0) goto L12;
        r3 = r1.c;
    L12:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "mode");
        return new ObricListeningViewState(r2, r0, r3);
    L8:
        r0 = false;
        goto L10
    }
}
