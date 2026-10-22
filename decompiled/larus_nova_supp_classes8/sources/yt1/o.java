package yt1;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.dsl.api.DSLType;
import com.bytedance.android.livesdkapi.depend.model.live.DslTypeInt;
import com.bytedance.android.livesdkapi.depend.model.live.LiveDSLModel;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o {
    public static final a e = null;
    public e a;
    public final q b;
    public final p c;
    public final String d;

    public static final class a {
        public a() {
        }

        public static o b(LiveDSLModel r7) {
            Intrinsics.checkNotNullParameter(r7, "model");
            long r0 = r7.getDslType();
            if (r0 != DslTypeInt.DslTypeSlice.getValue()) goto L6;
            String r1 = DSLType.Slice;
        L13:
            if (Intrinsics.areEqual(r1, DSLType.Lynx) == true) goto L15;
        L19:
            String r2 = r7.getUrl();
            if (r2 == null) goto L27;
            if (r2.length() <= 0) goto L24;
            boolean r3 = true;
        L25:
            if (r3 != true) goto L27;
        L28:
            StringBuilder r4 = new StringBuilder();
            String r5 = r7.getUrl();
            if (r5 == null) goto L32;
            String r6 = String.valueOf(r5.hashCode());
            if (r6 == null) goto L32;
        L33:
            r4.append(r6);
            r4.append("-");
            r4.append(String.valueOf(r7.getVersion()));
            String r8 = r4.toString();
        L35:
            String r9 = String.valueOf(r7.getId());
            String r10 = r7.getSliceContent();
            String r11 = r7.getUrl();
            Intrinsics.checkNotNullParameter(r9, "id");
            Intrinsics.checkNotNullParameter(r8, "hashCode");
            Intrinsics.checkNotNullParameter(r1, "type");
            o r12 = new o(new q(r9, r8), new p(r10, r11), r1);
            LiveDSLModel.ExtraInfo r13 = r7.getExtra();
            if (r13 == null) goto L38;
            e r14 = new e();
            r14.b = r13.getWidth();
            r14.a = r13.getHeight();
            Unit r15 = Unit.INSTANCE;
            r12.a = r14;
        L38:
            return r12;
        L32:
            r6 = String.valueOf(r7.getId());
            goto L33
        L24:
            r3 = false;
        L27:
            if (r7.getVersion() > 0) goto L28;
            r8 = "";
            goto L35
        L15:
            if (v.a() == false) goto L19;
            throw new Exception("not support lynx now.");
        L6:
            if (r0 != DslTypeInt.DslTypeLynxAir.getValue()) goto L9;
            r1 = DSLType.LynxAir;
            goto L13
        L9:
            if (r0 != DslTypeInt.DslTypeLynx.getValue()) goto L11;
            r1 = DSLType.Lynx;
            goto L13
        L11:
            r1 = DSLType.Unknown;
            goto L13
        }

        public static o a(String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r3, "id");
            Intrinsics.checkNotNullParameter(r4, "hashCode");
            Intrinsics.checkNotNullParameter(r5, "content");
            return new o(new q(r3, r4), new p(r5, null, 2), DSLType.Slice);
        }
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof o) == false) goto L12;
        o r4 = (o) r3;
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        q r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        p r4 = this.c;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.d;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "TemplateData(key=" + this.b + ", source=" + this.c + ", type=" + this.d + ")";
    }

    static {
        e = new a();
    }

    public final String getType() {
        return this.d;
    }

    public o(q r2, p r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "type");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
