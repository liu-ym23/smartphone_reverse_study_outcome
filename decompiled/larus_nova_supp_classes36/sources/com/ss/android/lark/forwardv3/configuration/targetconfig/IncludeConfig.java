package com.ss.android.lark.forwardv3.configuration.targetconfig;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\tJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/targetconfig/IncludeConfig;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "includeItem", "", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/EntityItem;", "getIncludeItem", "()Ljava/util/List;", "setIncludeItem", "(Ljava/util/List;)V", "addItem", "item", "writeToParcel", "", "flags", "", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class IncludeConfig implements Parcelable {
    public static final b CREATOR = null;
    public final List<EntityItem> a;

    public static final class a {
        public final List<EntityItem> a;

        public final IncludeConfig b() {
            IncludeConfig r0 = new IncludeConfig();
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

    public static final class b implements Parcelable.Creator<IncludeConfig> {
        public static IncludeConfig a() {
            a r0 = new a();
            EntityItem.a r1 = new EntityItem.a();
            r1.f(new UserConfig.a().a());
            r0.a(r1.c());
            EntityItem.a r2 = new EntityItem.a();
            r2.e(new ThreadConfig.a().a());
            r0.a(r2.c());
            EntityItem.a r3 = new EntityItem.a();
            r3.d(new GroupConfig.a().a());
            r0.a(r3.c());
            EntityItem.a r4 = new EntityItem.a();
            r4.b(new BotConfig());
            r0.a(r4.c());
            return r0.b();
        }

        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final IncludeConfig createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            Intrinsics.checkNotNullParameter(r4, "parcel");
            IncludeConfig r1 = new IncludeConfig();
            r4.readTypedList(r1.a, EntityItem.CREATOR);
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public final IncludeConfig[] newArray(int r1) {
            return new IncludeConfig[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public IncludeConfig() {
        this.a = new ArrayList();
    }

    public final void a(EntityItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        ((ArrayList) this.a).add(r2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeTypedList(this.a);
    }
}
