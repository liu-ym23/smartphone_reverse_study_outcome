package com.larus.bmhome.bigimg;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00060\u0001j\u0002`\u0002:\u0001\u0012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/bigimg/ImageAuthException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", "<init>", "(I)V", "getCode", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ImageAuthException extends Exception {
    public static final a Companion = null;
    public static final int NET_ERROR = -3;
    public static final int NO_AUTH = -1;
    public static final int REQUEST_INVALID = -2;
    private final int code;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ ImageAuthException copy$default(ImageAuthException r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        return r0.copy(r1);
    }

    public final int component1() {
        return this.code;
    }

    public final ImageAuthException copy(int r2) {
        return new ImageAuthException(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ImageAuthException) == true) goto L9;
        return false;
    L9:
        if (this.code == ((ImageAuthException) r4).code) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "ImageAuthException(code=" + this.code + ')';
    }

    public final int getCode() {
        return this.code;
    }

    public ImageAuthException(int r1) {
        this.code = r1;
    }
}
