package androidx.room.vo;

import androidx.room.compiler.processing.XElement;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Landroidx/room/vo/LanguageId;", "", "declaredIn", "Landroidx/room/compiler/processing/XElement;", "field", "Landroidx/room/vo/Field;", "(Landroidx/room/compiler/processing/XElement;Landroidx/room/vo/Field;)V", "getDeclaredIn", "()Landroidx/room/compiler/processing/XElement;", "getField", "()Landroidx/room/vo/Field;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LanguageId {
    public static final Companion Companion = null;
    private static final LanguageId MISSING = null;
    private final XElement declaredIn;
    private final Field field;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/vo/LanguageId$Companion;", "", "()V", "MISSING", "Landroidx/room/vo/LanguageId;", "getMISSING", "()Landroidx/room/vo/LanguageId;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final LanguageId getMISSING() {
            return LanguageId.access$getMISSING$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        MISSING = new LanguageId(null, null);
    }

    public LanguageId(XElement r5, Field r10) {
        this.declaredIn = r5;
        this.field = r10;
    }

    public static final /* synthetic */ LanguageId access$getMISSING$cp() {
        return MISSING;
    }

    public static /* synthetic */ LanguageId copy$default(LanguageId r5, XElement r10, Field r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.declaredIn;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.field;
    L9:
        return r5.copy(r10, r11);
    }

    public final XElement component1() {
        return this.declaredIn;
    }

    public final Field component2() {
        return this.field;
    }

    public final LanguageId copy(XElement r5, Field r10) {
        return new LanguageId(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LanguageId) == true) goto L8;
        return false;
    L8:
        LanguageId r10 = (LanguageId) r5;
        if (Intrinsics.areEqual(this.declaredIn, r10.declaredIn) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.field, r10.field) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final XElement getDeclaredIn() {
        return this.declaredIn;
    }

    public final Field getField() {
        return this.field;
    }

    public int hashCode() {
        XElement r5 = this.declaredIn;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        Field r13 = this.field;
        if (r13 == null) goto L11;
        r10 = r13.hashCode();
    L11:
        return r12 + r10;
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public String toString() {
        return "LanguageId(declaredIn=" + this.declaredIn + ", field=" + this.field + ")";
    }
}
