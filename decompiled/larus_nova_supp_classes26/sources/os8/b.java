package os8;

import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.utils.c4;
import kotlin.jvm.internal.Intrinsics;
import nr9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class b {

    public static final class a extends b {
        public final AiGenVideoContentData a;
        public final c4 b;
        public final String c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "AiGeneration(aiGenVideoContentData=" + this.a + ", eventParams=" + this.b + ", videoEngineTag=" + this.c + ", videoEngineSubTag=" + this.d + ')';
        }

        public a(AiGenVideoContentData r4, c4 r5) {
            Intrinsics.checkNotNullParameter(r4, "aiGenVideoContentData");
            Intrinsics.checkNotNullParameter(r5, "eventParams");
            Intrinsics.checkNotNullParameter("ugc_video", "videoEngineTag");
            Intrinsics.checkNotNullParameter("immersive_preview", "videoEngineSubTag");
            this.a = r4;
            this.b = r5;
            this.c = "ugc_video";
            this.d = "immersive_preview";
        }
    }

    /* JADX INFO: renamed from: os8.b$b, reason: collision with other inner class name */
    public static final class C0128b extends b {
        public static final C0128b a = null;

        static {
            a = new C0128b();
        }

        public C0128b() {
        }
    }

    public static final class c extends b {
        public final g a;
        public final c4 b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "UserUpload(videoPlayData=" + this.a + ", eventParams=" + this.b + ", disableShare=" + this.c + ')';
        }

        public c(g r2, c4 r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "videoPlayData");
            Intrinsics.checkNotNullParameter(r3, "eventParams");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public b() {
    }
}
