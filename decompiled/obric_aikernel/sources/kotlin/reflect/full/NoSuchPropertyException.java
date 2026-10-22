package kotlin.reflect.full;

import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.1")
public final class NoSuchPropertyException extends Exception {
    /* JADX WARN: Multi-variable type inference failed */
    public NoSuchPropertyException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public NoSuchPropertyException(Exception r10) {
        super(r10);
    }

    public /* synthetic */ NoSuchPropertyException(Exception r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = null;
    L5:
        this(r10);
    }
}
