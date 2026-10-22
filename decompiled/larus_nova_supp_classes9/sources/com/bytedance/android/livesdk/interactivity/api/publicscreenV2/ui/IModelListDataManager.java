package com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.bdlocation.BuildConfig;
import h52.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m52.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface IModelListDataManager {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreenV2/ui/IModelListDataManager$ModelChangeType;", BuildConfig.FLAVOR, "INSERT_BOTTOM", "UPDATE_BOTTOM", "REMOVE_ITEM", "UPDATE_ITEM", "INSERT_ITEM", "REMOVE_RANGE", "INIT_LIST", "RELOAD_ALL", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ModelChangeType extends Enum<ModelChangeType> {
        public static final ModelChangeType INIT_LIST = null;
        public static final ModelChangeType INSERT_BOTTOM = null;
        public static final ModelChangeType INSERT_ITEM = null;
        public static final ModelChangeType RELOAD_ALL = null;
        public static final ModelChangeType REMOVE_ITEM = null;
        public static final ModelChangeType REMOVE_RANGE = null;
        public static final ModelChangeType UPDATE_BOTTOM = null;
        public static final ModelChangeType UPDATE_ITEM = null;
        public static final /* synthetic */ ModelChangeType[] a = null;

        static {
            ModelChangeType r1 = new ModelChangeType("INSERT_BOTTOM", 0);
            INSERT_BOTTOM = r1;
            ModelChangeType r2 = new ModelChangeType("UPDATE_BOTTOM", 1);
            UPDATE_BOTTOM = r2;
            ModelChangeType r3 = new ModelChangeType("REMOVE_ITEM", 2);
            REMOVE_ITEM = r3;
            ModelChangeType r4 = new ModelChangeType("UPDATE_ITEM", 3);
            UPDATE_ITEM = r4;
            ModelChangeType r5 = new ModelChangeType("INSERT_ITEM", 4);
            INSERT_ITEM = r5;
            ModelChangeType r6 = new ModelChangeType("REMOVE_RANGE", 5);
            REMOVE_RANGE = r6;
            ModelChangeType r7 = new ModelChangeType("INIT_LIST", 6);
            INIT_LIST = r7;
            ModelChangeType r8 = new ModelChangeType("RELOAD_ALL", 7);
            RELOAD_ALL = r8;
            a = new ModelChangeType[]{r1, r2, r3, r4, r5, r6, r7, r8};
        }

        public static ModelChangeType valueOf(String r1) {
            return (ModelChangeType) r27.a.a(ModelChangeType.class, r1);
        }

        public static ModelChangeType[] values() {
            return (ModelChangeType[]) a.clone();
        }

        public ModelChangeType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final ModelChangeType a;
        public final int b;
        public final int c;
        public final int d;
        public final c e;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L16;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            ModelChangeType r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = ((((((r2 * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
            c r4 = this.e;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "ModelChangeEvent(type=" + this.a + ", position=" + this.b + ", rangeStart=" + this.c + ", rangeEnd=" + this.d + ", message=" + this.e + ")";
        }

        public final ModelChangeType getType() {
            return this.a;
        }

        public a(ModelChangeType r3, int r4, int r5, c r6, int r7) {
            if ((r7 & 2) == 0) goto L6;
            r4 = 0;
        L6:
            if ((r7 & 8) == 0) goto L9;
            r5 = 0;
        L9:
            if ((r7 & 16) == 0) goto L11;
            r6 = null;
        L11:
            Intrinsics.checkNotNullParameter(r3, "type");
            this.a = r3;
            this.b = r4;
            this.c = 0;
            this.d = r5;
            this.e = r6;
        }
    }

    PropertyOwner a();

    void b(c r1);

    e c();

    void destroy();

    List<c> getMessageList();
}
