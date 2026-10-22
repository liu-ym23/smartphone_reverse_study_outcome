package androidx.room.compiler.processing;

import com.squareup.javapoet.o;
import com.squareup.kotlinpoet.i;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\fJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/XFiler;", "", "Lcom/squareup/javapoet/o;", "javaFile", "Landroidx/room/compiler/processing/XFiler$Mode;", "mode", "", "write", "(Lcom/squareup/javapoet/o;Landroidx/room/compiler/processing/XFiler$Mode;)V", "Lcom/squareup/kotlinpoet/i;", "fileSpec", "(Lcom/squareup/kotlinpoet/i;Landroidx/room/compiler/processing/XFiler$Mode;)V", "Mode", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XFiler {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/room/compiler/processing/XFiler$Mode;", "", "(Ljava/lang/String;I)V", "Aggregating", "Isolating", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode Aggregating = null;
        public static final Mode Isolating = null;

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{Aggregating, Isolating};
        }

        static {
            Aggregating = new Mode("Aggregating", 0);
            Isolating = new Mode("Isolating", 1);
            $VALUES = $values();
        }

        private Mode(String r5, int r10) {
            super(r5, r10);
        }

        public static Mode valueOf(String r5) {
            return (Mode) Enum.valueOf(Mode.class, r5);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    static /* synthetic */ void write$default(XFiler r5, o r10, Mode r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 2) == 0) goto L6;
        r11 = Mode.Isolating;
    L6:
        r5.write(r10, r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
    }

    void write(o r5, Mode r10);

    void write(i r5, Mode r10);

    static /* synthetic */ void write$default(XFiler r5, i r10, Mode r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 2) == 0) goto L6;
        r11 = Mode.Isolating;
    L6:
        r5.write(r10, r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
    }
}
