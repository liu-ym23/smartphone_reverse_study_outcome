package kotlin.text;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class Regex$Serialized implements Serializable {
    public static final Companion Companion = null;
    private static final long serialVersionUID = 0;
    private final int flags;
    private final String pattern;

    static {
        Companion = new Companion(null);
    }

    private final Object readResolve() {
        return new Regex(PatternProtector.compile(this.pattern, this.flags));
    }

    public final int getFlags() {
        return this.flags;
    }

    public final String getPattern() {
        return this.pattern;
    }

    public Regex$Serialized(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "pattern");
        this.pattern = r2;
        this.flags = r3;
    }
}
