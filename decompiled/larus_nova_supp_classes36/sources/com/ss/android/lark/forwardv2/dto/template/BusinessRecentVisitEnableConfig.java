package com.ss.android.lark.forwardv2.dto.template;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.forwardv2.dto.template.config.EntityItem;
import com.ss.android.lark.forwardv2.impl.IRemoteForwardDisableTargetHandler;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class BusinessRecentVisitEnableConfig implements Parcelable {
    public static final Parcelable.Creator<BusinessRecentVisitEnableConfig> CREATOR = null;
    public a a;
    public IRemoteForwardDisableTargetHandler b;
    public ArrayList<EntityItem> c;

    /* JADX INFO: renamed from: com.ss.android.lark.forwardv2.dto.template.BusinessRecentVisitEnableConfig$1, reason: invalid class name */
    class AnonymousClass1 extends IRemoteForwardDisableTargetHandler.Stub {
        final /* synthetic */ BusinessRecentVisitEnableConfig this$0;
        final /* synthetic */ com.ss.android.lark.forwardv2.dto.template.a val$mCustomDisableHandler;

        @Override // com.ss.android.lark.forwardv2.impl.IRemoteForwardDisableTargetHandler
        public boolean showSomeToast() throws RemoteException {
            a r0 = (a) this.val$mCustomDisableHandler;
            r0.getClass();
            return r0.a.b.showSomeToast();
        L5:
            e = move-exception;
            Log.e("BusinessRecentVisitEnableConfig", "showSomeToast", e);
            return false;
        }

        @Override // com.ss.android.lark.forwardv2.impl.IRemoteForwardDisableTargetHandler
        public boolean disableHandle(ForwardTarget r3) throws RemoteException {
            a r0 = (a) this.val$mCustomDisableHandler;
            r0.getClass();
            return r0.a.b.disableHandle(r3);
        L5:
            e = move-exception;
            Log.e("BusinessRecentVisitEnableConfig", "disableHandle", e);
            return false;
        }

        public AnonymousClass1(BusinessRecentVisitEnableConfig r1, com.ss.android.lark.forwardv2.dto.template.a r2) {
            this.this$0 = r1;
            this.val$mCustomDisableHandler = r2;
        }
    }

    public class a implements com.ss.android.lark.forwardv2.dto.template.a {
        public final /* synthetic */ BusinessRecentVisitEnableConfig a;

        public a(BusinessRecentVisitEnableConfig r1) {
            this.a = r1;
        }
    }

    public class b implements Parcelable.Creator<BusinessRecentVisitEnableConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final BusinessRecentVisitEnableConfig createFromParcel(Parcel r2) {
            return new BusinessRecentVisitEnableConfig(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final BusinessRecentVisitEnableConfig[] newArray(int r1) {
            return new BusinessRecentVisitEnableConfig[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new b();
    }

    public final com.ss.android.lark.forwardv2.dto.template.a a() {
        if (this.a != null) goto L8;
        if (this.b == null) goto L8;
        this.a = new a(this);
    L8:
        return this.a;
    }

    public BusinessRecentVisitEnableConfig() {
        this.c = new ArrayList();
    }

    public BusinessRecentVisitEnableConfig(Parcel r3) {
        ArrayList<EntityItem> r0 = new ArrayList();
        this.c = r0;
        r3.readTypedList(r0, EntityItem.CREATOR);
        if (r3.readInt() <= 0) goto L6;
        this.b = IRemoteForwardDisableTargetHandler.Stub.asInterface(r3.readStrongBinder());
        return;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeTypedList(this.c);
        if (this.b == null) goto L5;
        r1.writeInt(1);
        r1.writeStrongBinder(this.b.asBinder());
        return;
    L5:
        r1.writeInt(0);
    }
}
