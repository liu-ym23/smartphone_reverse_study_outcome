package com.ss.android.lark.forwardv3.configuration.targetconfig;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/targetconfig/DisableConfig;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "disableItem", "", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/EntityItem;", "getDisableItem", "()Ljava/util/List;", "setDisableItem", "(Ljava/util/List;)V", "writeToParcel", "", "flags", "", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class DisableConfig implements Parcelable {
    public static final b CREATOR = null;
    public final List<EntityItem> a;

    public static final class a {
        public final List<EntityItem> a;

        public final DisableConfig b() {
            DisableConfig r0 = new DisableConfig();
            List<EntityItem> r1 = r0.a;
            ArrayList r2 = (ArrayList) r1;
            r2.addAll(this.a);
            return r0;
        }

        public a() {
            this.a = new ArrayList();
        }

        public final void a(EntityItem r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            ((ArrayList) this.a).add(r2);
        }
    }

    public static final class b implements Parcelable.Creator<DisableConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final DisableConfig createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            Intrinsics.checkNotNullParameter(r4, "parcel");
            DisableConfig r1 = new DisableConfig();
            r4.readTypedList(r1.a, EntityItem.CREATOR);
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public final DisableConfig[] newArray(int r1) {
            return new DisableConfig[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public DisableConfig() {
        this.a = new ArrayList();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeTypedList(this.a);
    }
}
