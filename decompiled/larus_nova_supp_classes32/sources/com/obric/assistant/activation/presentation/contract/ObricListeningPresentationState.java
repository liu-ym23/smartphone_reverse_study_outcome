package com.obric.assistant.activation.presentation.contract;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0001-B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0019\u001a\u00020\u000bJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003JE\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0006\u0010!\u001a\u00020\u0006J\u0013\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017¨\u0006."}, d2 = {"Lcom/obric/assistant/activation/presentation/contract/ObricListeningPresentationState;", "Landroid/os/Parcelable;", "revision", NameKeys.UnloadStrategy_No_Strategy, "heartbeatSequence", "renderer", NameKeys.UnloadStrategy_No_Strategy, "dataSource", "viewState", "Lcom/obric/assistant/activation/presentation/contract/ObricListeningViewState;", "childFeedbackPlayed", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(JJIILcom/obric/assistant/activation/presentation/contract/ObricListeningViewState;Z)V", "getRevision", "()J", "getHeartbeatSequence", "getRenderer", "()I", "getDataSource", "getViewState", "()Lcom/obric/assistant/activation/presentation/contract/ObricListeningViewState;", "getChildFeedbackPlayed", "()Z", "isActive", "isValid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", NameKeys.UnloadStrategy_No_Strategy, "hashCode", "toString", NameKeys.UnloadStrategy_No_Strategy, "writeToParcel", NameKeys.UnloadStrategy_No_Strategy, "dest", "Landroid/os/Parcel;", "flags", "Companion", "contract_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricListeningPresentationState implements Parcelable {
    public static final Parcelable.Creator<ObricListeningPresentationState> CREATOR = null;
    public static final ObricListeningPresentationState g = null;
    public final long a;
    public final long b;
    public final int c;
    public final int d;
    public final ObricListeningViewState e;
    public final boolean f;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<ObricListeningPresentationState> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ObricListeningPresentationState createFromParcel(Parcel r11) {
            Intrinsics.checkNotNullParameter(r11, "parcel");
            long r2 = r11.readLong();
            long r4 = r11.readLong();
            int r6 = r11.readInt();
            int r7 = r11.readInt();
            ObricListeningViewState r8 = ObricListeningViewState.CREATOR.createFromParcel(r11);
            if (r11.readInt() == 0) goto L5;
            boolean r9 = true;
        L7:
            return new ObricListeningPresentationState(r2, r4, r6, r7, r8, r9);
        L5:
            r9 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ObricListeningPresentationState[] newArray(int r1) {
            return new ObricListeningPresentationState[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ObricListeningPresentationState) == true) goto L8;
        return false;
    L8:
        ObricListeningPresentationState r9 = (ObricListeningPresentationState) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (((((((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.c) * 31) + this.d) * 31) + this.e.hashCode()) * 31;
        if (this.f == false) goto L5;
        int r4 = 1231;
    L7:
        return r2 + r4;
    L5:
        r4 = 1237;
        goto L7
    }

    public final String toString() {
        return "ObricListeningPresentationState(revision=" + this.a + ", heartbeatSequence=" + this.b + ", renderer=" + this.c + ", dataSource=" + this.d + ", viewState=" + this.e + ", childFeedbackPlayed=" + this.f + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeLong(this.a);
        r3.writeLong(this.b);
        r3.writeInt(this.c);
        r3.writeInt(this.d);
        this.e.writeToParcel(r3, r4);
        r3.writeInt(this.f ? 1 : 0);
    }

    static {
        CREATOR = new b();
        g = new ObricListeningPresentationState(0, 0, 0, 0, ObricListeningViewState.d, false);
    }

    public final boolean b() {
        return this.e.b();
    }

    public final boolean isValid() {
        if (this.a >= 0) goto L5;
        return false;
    L5:
        if (this.b < 0) goto L31;
        int r0 = this.c;
        if (r0 == 0) goto L11;
        if (r0 == 1) goto L11;
        boolean r3 = false;
    L12:
        if (r3 == false) goto L32;
        if (r0 == 0) goto L33;
        int r1 = this.d;
        if (r1 >= 0) goto L17;
    L19:
        boolean r2 = false;
    L20:
        if (r2 == false) goto L34;
        float r4 = this.e.c;
        if (Float.isInfinite(r4) == false) goto L24;
    L26:
        boolean r5 = false;
    L27:
        if (r5 == false) goto L35;
        return true;
    L35:
        return false;
    L24:
        if (Float.isNaN(r4) == true) goto L26;
        r5 = true;
        goto L27
    L34:
        return false;
    L17:
        if (r1 >= 2) goto L19;
        r2 = true;
        goto L20
    L33:
        return false;
    L32:
        return false;
    L11:
        r3 = true;
        goto L12
    L31:
        return false;
    }

    public ObricListeningPresentationState(long r2, long r4, int r6, int r7, ObricListeningViewState r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "viewState");
        this.a = r2;
        this.b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
    }

    public static ObricListeningPresentationState a(ObricListeningPresentationState r9, long r10, long r12, int r14, ObricListeningViewState r15, boolean r16, int r17) {
        if ((r17 & 1) == 0) goto L5;
        long r1 = r9.a;
    L7:
        if ((r17 & 2) == 0) goto L9;
        long r3 = r9.b;
    L11:
        if ((r17 & 4) == 0) goto L13;
        int r5 = r9.c;
    L15:
        if ((r17 & 8) == 0) goto L17;
        int r6 = r9.d;
    L19:
        if ((r17 & 16) == 0) goto L21;
        ObricListeningViewState r7 = r9.e;
    L23:
        if ((r17 & 32) == 0) goto L25;
        boolean r8 = r9.f;
    L26:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r7, "viewState");
        return new ObricListeningPresentationState(r1, r3, r5, r6, r7, r8);
    L25:
        r8 = r16;
        goto L26
    L21:
        r7 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = 0;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
