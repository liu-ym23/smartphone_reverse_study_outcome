package androidx.room.vo;

import androidx.room.BuiltInTypeConverters;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0015\u0010\u0003\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0082\u0002¨\u0006\u0005"}, d2 = {"isEnabled", "", "Landroidx/room/BuiltInTypeConverters$State;", "plus", "other", "room-compiler"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BuiltInConverterFlagsKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[BuiltInTypeConverters.State.values().length];
            r5[BuiltInTypeConverters.State.INHERITED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public static final /* synthetic */ BuiltInTypeConverters.State access$plus(BuiltInTypeConverters.State r5, BuiltInTypeConverters.State r10) {
        return plus(r5, r10);
    }

    public static final boolean isEnabled(BuiltInTypeConverters.State r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5 == BuiltInTypeConverters.State.DISABLED) goto L5;
        return true;
    L5:
        return false;
    }

    private static final BuiltInTypeConverters.State plus(BuiltInTypeConverters.State r5, BuiltInTypeConverters.State r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (WhenMappings.$EnumSwitchMapping$0[r10.ordinal()] != 1) goto L6;
        return r5;
    L6:
        return r10;
    }
}
