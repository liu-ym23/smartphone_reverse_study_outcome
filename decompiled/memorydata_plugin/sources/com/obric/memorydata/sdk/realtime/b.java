package com.obric.memorydata.sdk.realtime;

import android.app.assist.AssistStructure;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.obric.memorydata.sdk.realtime.IRealTimeContextService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            AssistStructure r1 = null;
            AssistStructure r2 = null;
            Bitmap r3 = null;
            if (r6 != 1) goto L5;
            r7.enforceInterface("com.obric.memorydata.sdk.realtime.IRealTimeContextService");
            if (r7.readInt() == 0) goto L34;
            r1 = (AssistStructure) ZeusTransformUtils.preCheckCast(AssistStructure.CREATOR.createFromParcel(r7), AssistStructure.class, "com.obric.memorydata.plugin");
        L34:
            a(r1, r7.createTypedArrayList(AppEntity.CREATOR));
            return true;
        L5:
            if (r6 != 2) goto L7;
            r7.enforceInterface("com.obric.memorydata.sdk.realtime.IRealTimeContextService");
            if (r7.readInt() == 0) goto L29;
            r3 = (Bitmap) ZeusTransformUtils.preCheckCast(Bitmap.CREATOR.createFromParcel(r7), Bitmap.class, "com.obric.memorydata.plugin");
        L29:
            a(r3);
            return true;
        L7:
            if (r6 != 3) goto L9;
            r7.enforceInterface("com.obric.memorydata.sdk.realtime.IRealTimeContextService");
            RealTimeContextResult r5 = a(r7.readString(), r7.readString(), r7.readString());
            r8.writeNoException();
            if (r5 == null) goto L24;
            r8.writeInt(1);
            r5.writeToParcel(r8, 1);
        L25:
            return true;
        L24:
            r8.writeInt(0);
            goto L25
        L9:
            if (r6 != 4) goto L11;
            r7.enforceInterface("com.obric.memorydata.sdk.realtime.IRealTimeContextService");
            if (r7.readInt() == 0) goto L19;
            r2 = (AssistStructure) ZeusTransformUtils.preCheckCast(AssistStructure.CREATOR.createFromParcel(r7), AssistStructure.class, "com.obric.memorydata.plugin");
        L19:
            a(r2, r7.createTypedArrayList(AppEntity.CREATOR), com.obric.memorydata.sdk.realtime.a.AbstractBinderC0698a.a(r7.readStrongBinder()));
            return true;
        L11:
            if (r6 != 1598968902) goto L13;
            r8.writeString("com.obric.memorydata.sdk.realtime.IRealTimeContextService");
            return true;
        L13:
            return super.onTransact(r6, r7, r8, r9);
        }
    }

    RealTimeContextResult a(String r1, String r2, String r3);

    void a(AssistStructure r1, List<AppEntity> r2);

    void a(AssistStructure r1, List<AppEntity> r2, com.obric.memorydata.sdk.realtime.a r3);

    void a(Bitmap r1);
}
