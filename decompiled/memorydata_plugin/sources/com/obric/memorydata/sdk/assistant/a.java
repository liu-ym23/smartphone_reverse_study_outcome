package com.obric.memorydata.sdk.assistant;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes5.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.obric.memorydata.sdk.assistant.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0691a extends Binder implements a {
        public AbstractBinderC0691a() {
            attachInterface(this, "com.obric.memorydata.sdk.assistant.IAssistantStateService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.memorydata.sdk.assistant.IAssistantStateService");
            if (r5.readInt() == 0) goto L17;
            QueryContext r8 = QueryContext.CREATOR.a(r5);
        L18:
            a(r8);
            return true;
        L17:
            r8 = null;
            goto L18
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface("com.obric.memorydata.sdk.assistant.IAssistantStateService");
            a();
            return true;
        L7:
            if (r4 != 1598968902) goto L9;
            r6.writeString("com.obric.memorydata.sdk.assistant.IAssistantStateService");
            return true;
        L9:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a();

    void a(QueryContext r1);
}
