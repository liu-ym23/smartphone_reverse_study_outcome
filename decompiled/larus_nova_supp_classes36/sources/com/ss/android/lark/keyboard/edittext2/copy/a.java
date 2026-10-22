package com.ss.android.lark.keyboard.edittext2.copy;

import com.bytedance.lark.pb.im.v1.ResourceExtraInfo;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a {
    public static final b a = null;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.copy.a$a, reason: collision with other inner class name */
    public static final class C0136a {
        public final RichText a;
        public final List<ResourceExtraInfo> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0136a) == true) goto L8;
            return false;
        L8:
            C0136a r6 = (C0136a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "HtmlParseResult(richText=" + this.a + ", resourcesExtraInfo=" + this.b + ')';
        }

        public C0136a(RichText r2, List<ResourceExtraInfo> r3) {
            Intrinsics.checkNotNullParameter(r2, "richText");
            Intrinsics.checkNotNullParameter(r3, "resourcesExtraInfo");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b implements a {
        public static final /* synthetic */ b c = null;
        public final /* synthetic */ CopyProtocolServiceImpl b;

        static {
            c = new b();
        }

        public b() {
            this.b = new CopyProtocolServiceImpl();
        }
    }

    static {
        a = b.c;
    }
}
