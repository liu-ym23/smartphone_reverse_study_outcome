package androidx.room.processor;

import androidx.room.OnConflictStrategy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Landroidx/room/processor/OnConflictProcessor;", "", "()V", "INVALID_ON_CONFLICT", "", "getINVALID_ON_CONFLICT", "()I", "onConflictText", "", "onConflict", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OnConflictProcessor {
    public static final OnConflictProcessor INSTANCE = null;
    private static final int INVALID_ON_CONFLICT = 0;

    static {
        INSTANCE = new OnConflictProcessor();
        INVALID_ON_CONFLICT = -1;
    }

    private OnConflictProcessor() {
    }

    public final int getINVALID_ON_CONFLICT() {
        return INVALID_ON_CONFLICT;
    }

    public final String onConflictText(@OnConflictStrategy int r5) {
        if (r5 != 0) goto L4;
        return "";
    L4:
        if (r5 != 1) goto L6;
        return "REPLACE";
    L6:
        if (r5 != 2) goto L8;
        return "ROLLBACK";
    L8:
        if (r5 != 3) goto L10;
        return "ABORT";
    L10:
        if (r5 != 4) goto L12;
        return "FAIL";
    L12:
        if (r5 == 5) goto L14;
        return "BAD_CONFLICT_CONSTRAINT";
    L14:
        return "IGNORE";
    }
}
