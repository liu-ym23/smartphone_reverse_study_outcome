package r2;

import com.bytedance.ai.applet.components.input.AppletChatActionBarCapability;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class a {

    /* JADX INFO: renamed from: r2.a$a, reason: collision with other inner class name */
    public static final class C0187a extends a {
        public final AppletChatActionBarCapability a;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof C0187a) == true) goto L9;
            return false;
        L9:
            if (this.a == ((C0187a) r10).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "OpenCapability(capability=" + this.a + ')';
        }

        public C0187a(AppletChatActionBarCapability r10) {
            Intrinsics.checkNotNullParameter(r10, "capability");
            this.a = r10;
        }
    }

    public static final class b extends a {
        public final String a;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r10).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "OpenSchema(schema=" + this.a + ')';
        }

        public b(String r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            this.a = r10;
        }
    }

    public static final class c extends a {
        public final String a;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r10).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "SendPrompt(prompt=" + this.a + ')';
        }

        public c(String r10) {
            Intrinsics.checkNotNullParameter(r10, "prompt");
            this.a = r10;
        }
    }

    public a() {
    }
}
