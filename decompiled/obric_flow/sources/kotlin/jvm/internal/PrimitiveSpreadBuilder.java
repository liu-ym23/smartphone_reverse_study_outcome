package kotlin.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0004H\u0004J\u001d\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0004*\u00028\u0000H$¢\u0006\u0002\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000bX\u0082\u0004¢\u0006\n\n\u0002\u0010\u000e\u0012\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", ExifInterface.GPS_DIRECTION_TRUE, "", "size", "", "(I)V", "position", "getPosition", "()I", "setPosition", "spreads", "", "getSpreads$annotations", "()V", "[Ljava/lang/Object;", "addSpread", "", "spreadArgument", "(Ljava/lang/Object;)V", "toArray", "values", "result", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getSize", "(Ljava/lang/Object;)I", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class PrimitiveSpreadBuilder<T> {
    private int position;
    private final int size;
    private final T[] spreads;

    public PrimitiveSpreadBuilder(int r5) {
        this.size = r5;
        this.spreads = (T[]) new Object[r5];
    }

    private static /* synthetic */ void getSpreads$annotations() {
    }

    public final void addSpread(T r5) {
        Intrinsics.checkNotNullParameter(r5, "spreadArgument");
        T[] r10 = this.spreads;
        int r11 = this.position;
        this.position = r11 + 1;
        r10[r11] = r5;
    }

    public final int getPosition() {
        return this.position;
    }

    public abstract int getSize(T r5);

    public final void setPosition(int r5) {
        this.position = r5;
    }

    public final int size() {
        int r5 = this.size - 1;
        int r10 = 0;
        if (r5 < 0) goto L12;
        int r11 = 0;
    L5:
        T r12 = this.spreads[r11];
        if (r12 == null) goto L8;
        int r13 = getSize(r12);
    L9:
        r10 = r10 + r13;
        if (r11 == r5) goto L12;
        r11 = r11 + 1;
        goto L5
    L8:
        r13 = 1;
    L12:
        return r10;
    }

    public final T toArray(T r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "values");
        Intrinsics.checkNotNullParameter(r11, "result");
        int r5 = this.size - 1;
        int r12 = 0;
        if (r5 < 0) goto L13;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L5:
        T r16 = this.spreads[r13];
        if (r16 == null) goto L10;
        if (r14 >= r13) goto L9;
        int r17 = r13 - r14;
        System.arraycopy(r10, r14, r11, r15, r17);
        r15 = r15 + r17;
    L9:
        int r18 = getSize(r16);
        System.arraycopy(r16, 0, r11, r15, r18);
        r15 = r15 + r18;
        r14 = r13 + 1;
    L10:
        if (r13 == r5) goto L12;
        r13 = r13 + 1;
        goto L5
    L12:
        r12 = r14;
    L14:
        int r19 = this.size;
        if (r12 >= r19) goto L17;
        System.arraycopy(r10, r12, r11, r15, r19 - r12);
    L17:
        return r11;
    L13:
        r15 = 0;
        goto L14
    }
}
