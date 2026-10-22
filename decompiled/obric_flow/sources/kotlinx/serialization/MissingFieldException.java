package kotlinx.serialization;

import ai.j0;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u000f\b\u0011\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\tB'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlinx/serialization/MissingFieldException;", "Lkotlinx/serialization/SerializationException;", "missingFields", "", "", "serialName", "(Ljava/util/List;Ljava/lang/String;)V", "missingField", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;)V", "message", "cause", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Throwable;)V", "getMissingFields", "()Ljava/util/List;", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MissingFieldException extends SerializationException {
    private final List<String> missingFields;

    public MissingFieldException(List<String> r5, String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r5, "missingFields");
        super(r10, r11);
        this.missingFields = r5;
    }

    public final List<String> getMissingFields() {
        return this.missingFields;
    }

    public MissingFieldException(List<String> r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "missingFields");
        Intrinsics.checkNotNullParameter(r10, "serialName");
        if (r5.size() != 1) goto L5;
        String r11 = androidx.constraintlayout.motion.widget.a.u(new StringBuilder("Field '"), r5.get(0), "' is required for type with serial name '", r10, "', but it was missing");
    L6:
        this(r5, r11, null);
        return;
    L5:
        r11 = "Fields " + r5 + " are required for type with serial name '" + r10 + "', but they were missing";
        goto L6
    }

    public MissingFieldException(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "missingField");
        Intrinsics.checkNotNullParameter(r10, "serialName");
        this(CollectionsKt.listOf(r5), j0.l("Field '", r5, "' is required for type with serial name '", r10, "', but it was missing"), null);
    }

    @PublishedApi
    public MissingFieldException(String r5) {
        Intrinsics.checkNotNullParameter(r5, "missingField");
        this(CollectionsKt.listOf(r5), j0.k("Field '", r5, "' is required, but it was missing"), null);
    }
}
