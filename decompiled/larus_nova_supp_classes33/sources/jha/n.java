package jha;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.state.multitask.core.TaskDispatchResult;
import jha.o;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface n<S extends o> {

    public static final class a<S extends o> implements n<S> {
        public final Deferred<Unit> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Closing(closed=" + this.a + ')';
        }

        public a(CompletableDeferred r2) {
            Intrinsics.checkNotNullParameter(r2, "closed");
            this.a = r2;
        }
    }

    public static final class b<S extends o> implements n<S> {
        public final l<S> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ExistingOpen(handle=" + this.a + ')';
        }

        public b(l<S> r2) {
            Intrinsics.checkNotNullParameter(r2, "handle");
            this.a = r2;
        }
    }

    public static final class c<S extends o> implements n<S> {
        public final TaskDispatchResult a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.a == ((c) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Failed(result=" + this.a + ')';
        }

        public c(TaskDispatchResult r2) {
            Intrinsics.checkNotNullParameter(r2, WindowEvent.Params.RESULT);
            this.a = r2;
        }
    }

    public static final class d<S extends o> implements n<S> {
        public final l<S> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Started(handle=" + this.a + ')';
        }

        public d(l<S> r2) {
            Intrinsics.checkNotNullParameter(r2, "handle");
            this.a = r2;
        }
    }
}
