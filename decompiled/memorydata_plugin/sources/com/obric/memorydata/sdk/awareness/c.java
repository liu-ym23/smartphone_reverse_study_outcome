package com.obric.memorydata.sdk.awareness;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.memorydata.sdk.MemoryResponse;

/* JADX INFO: loaded from: classes5.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {
        public a() {
            attachInterface(this, "com.obric.memorydata.sdk.awareness.IContextAwarenessService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r11, Parcel r12, Parcel r13, int r14) {
            if (r11 != 1598968902) goto L5;
            r13.writeString("com.obric.memorydata.sdk.awareness.IContextAwarenessService");
            return true;
        L5:
            switch(r11) {
                case 1: goto L56;
                case 2: goto L51;
                case 3: goto L46;
                case 4: goto L41;
                case 5: goto L36;
                case 6: goto L27;
                case 7: goto L18;
                case 8: goto L13;
                case 9: goto L8;
                default: goto L7;
            };
        L8:
            r12.enforceInterface("com.obric.memorydata.sdk.awareness.IContextAwarenessService");
            MemoryResponse r10 = c(r12.readString());
            r13.writeNoException();
            if (r10 == null) goto L11;
            r13.writeInt(1);
            r10.writeToParcel(r13, 1);
        L12:
            return true;
        L11:
            r13.writeInt(0);
            goto L12
        L13:
            r12.enforceInterface("com.obric.memorydata.sdk.awareness.IContextAwarenessService");
            MemoryResponse r15 = a(r12.readString(), r12.readDouble(), r12.readDouble(), r12.readString(), r12.readString());
            r13.writeNoException();
            if (r15 == null) goto L16;
            r13.writeInt(1);
            r15.writeToParcel(r13, 1);
        L17:
            return true;
        L16:
            r13.writeInt(0);
            goto L17
        L18:
            r12.enforceInterface("com.obric.memorydata.sdk.awareness.IContextAwarenessService");
            String r3 = r12.readString();
            String r4 = r12.readString();
            long r5 = r12.readLong();
            if (r12.readInt() == 0) goto L21;
            boolean r7 = true;
        L22:
            MemoryResponse r16 = b(r3, r4, r5, r7, f.a.a(r12.readStrongBinder()));
            r13.writeNoException();
            if (r16 == null) goto L25;
            r13.writeInt(1);
            r16.writeToParcel(r13, 1);
        L26:
            return true;
        L25:
            r13.writeInt(0);
            goto L26
        L21:
            r7 = false;
            goto L22
        L27:
            r12.enforceInterface("com.obric.memorydata.sdk.awareness.IContextAwarenessService");
            String r6 = r12.readString();
            String r8 = r12.readString();
            long r9 = r12.readLong();
            if (r12.readInt() == 0) goto L30;
            boolean r17 = true;
        L31:
            MemoryResponse r18 = a(r6, r8, r9, r17, f.a.a(r12.readStrongBinder()));
            r13.writeNoException();
            if (r18 == null) goto L34;
            r13.writeInt(1);
            r18.writeToParcel(r13, 1);
        L35:
            return true;
        L34:
            r13.writeInt(0);
            goto L35
        L30:
            r17 = false;
            goto L31
        L36:
            r12.enforceInterface("com.obric.memorydata.sdk.awareness.IContextAwarenessService");
            MemoryResponse r19 = a(r12.readString(), d.a.a(r12.readStrongBinder()));
            r13.writeNoException();
            if (r19 == null) goto L39;
            r13.writeInt(1);
            r19.writeToParcel(r13, 1);
        L40:
            return true;
        L39:
            r13.writeInt(0);
            goto L40
        L41:
            r12.enforceInterface("com.obric.memorydata.sdk.awareness.IContextAwarenessService");
            MemoryResponse r110 = b(r12.readString());
            r13.writeNoException();
            if (r110 == null) goto L44;
            r13.writeInt(1);
            r110.writeToParcel(r13, 1);
        L45:
            return true;
        L44:
            r13.writeInt(0);
            goto L45
        L46:
            r12.enforceInterface("com.obric.memorydata.sdk.awareness.IContextAwarenessService");
            MemoryResponse r111 = b(r12.readString(), e.a.a(r12.readStrongBinder()));
            r13.writeNoException();
            if (r111 == null) goto L49;
            r13.writeInt(1);
            r111.writeToParcel(r13, 1);
        L50:
            return true;
        L49:
            r13.writeInt(0);
            goto L50
        L51:
            r12.enforceInterface("com.obric.memorydata.sdk.awareness.IContextAwarenessService");
            MemoryResponse r112 = a(r12.readString(), e.a.a(r12.readStrongBinder()));
            r13.writeNoException();
            if (r112 == null) goto L54;
            r13.writeInt(1);
            r112.writeToParcel(r13, 1);
        L55:
            return true;
        L54:
            r13.writeInt(0);
            goto L55
        L56:
            r12.enforceInterface("com.obric.memorydata.sdk.awareness.IContextAwarenessService");
            MemoryResponse r113 = a(r12.readString());
            r13.writeNoException();
            if (r113 == null) goto L59;
            r13.writeInt(1);
            r113.writeToParcel(r13, 1);
        L60:
            return true;
        L59:
            r13.writeInt(0);
            goto L60
        L7:
            return super.onTransact(r11, r12, r13, r14);
        }
    }

    MemoryResponse a(String r1);

    MemoryResponse a(String r1, double r2, double r4, String r6, String r7);

    MemoryResponse a(String r1, d r2);

    MemoryResponse a(String r1, e r2);

    MemoryResponse a(String r1, String r2, long r3, boolean r5, f r6);

    MemoryResponse b(String r1);

    MemoryResponse b(String r1, e r2);

    MemoryResponse b(String r1, String r2, long r3, boolean r5, f r6);

    MemoryResponse c(String r1);
}
