package com.larus.bmhome.chat.outerinput;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class OuterInputEventBus {
    public static final MutableSharedFlow<Integer> a = null;
    public static final MutableSharedFlow<Integer> b = null;
    public static final ConcurrentHashMap<String, MutableSharedFlow<OuterInputEvent>> c = null;
    public static final ConcurrentHashMap<String, MutableSharedFlow<OuterInputEvent>> d = null;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020!H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015¨\u0006#"}, d2 = {"Lcom/larus/bmhome/chat/outerinput/OuterInputEventBus$OuterInputEvent;", "Landroid/os/Parcelable;", "action", "", "x", "", "y", "deltaX", "deltaY", "<init>", "(IFFFF)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAction", "()I", "setAction", "(I)V", "getX", "()F", "setX", "(F)V", "getY", "setY", "getDeltaX", "setDeltaX", "getDeltaY", "setDeltaY", "writeToParcel", "", "flags", "describeContents", "toString", "", "CREATOR", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class OuterInputEvent implements Parcelable {
        public static final a CREATOR = null;
        public final int a;
        public float b;
        public float c;
        public final float d;
        public float e;

        public static final class a implements Parcelable.Creator<OuterInputEvent> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final OuterInputEvent createFromParcel(Parcel r9) {
                Intrinsics.checkNotNullParameter(r9, "parcel");
                Intrinsics.checkNotNullParameter(r9, "parcel");
                return new OuterInputEvent(r9.readInt(), r9.readFloat(), r9.readFloat(), r9.readFloat(), r9.readFloat());
            }

            @Override // android.os.Parcelable.Creator
            public final OuterInputEvent[] newArray(int r1) {
                return new OuterInputEvent[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "action:" + this.a + ",x:" + this.b + ",y:" + this.c + ",deltaX:" + this.d + ",deltaY:" + this.e;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            r1.writeInt(this.a);
            r1.writeFloat(this.b);
            r1.writeFloat(this.c);
            r1.writeFloat(this.d);
            r1.writeFloat(this.e);
        }

        public OuterInputEvent(int r1, float r2, float r3, float r4, float r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    static {
        BufferOverflow r0 = BufferOverflow.DROP_OLDEST;
        a = SharedFlowKt.MutableSharedFlow$default(1, 0, r0, 2, null);
        b = SharedFlowKt.MutableSharedFlow$default(1, 0, r0, 2, null);
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
    }

    public static MutableSharedFlow a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "key");
        ConcurrentHashMap<String, MutableSharedFlow<OuterInputEvent>> r0 = c;
        MutableSharedFlow<OuterInputEvent> r1 = r0.get(r6);
        if (r1 != null) goto L6;
        MutableSharedFlow<OuterInputEvent> r2 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        r0.put(r6, r2);
        return r2;
    L6:
        return r1;
    }

    public static MutableSharedFlow b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "key");
        ConcurrentHashMap<String, MutableSharedFlow<OuterInputEvent>> r0 = d;
        MutableSharedFlow<OuterInputEvent> r1 = r0.get(r6);
        if (r1 != null) goto L6;
        MutableSharedFlow<OuterInputEvent> r2 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        r0.put(r6, r2);
        return r2;
    L6:
        return r1;
    }
}
