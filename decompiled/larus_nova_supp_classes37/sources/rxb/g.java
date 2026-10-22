package rxb;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB\t\b\u0016¢\u0006\u0004\b\u0007\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u000bJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u001bJ\u0012\u0010\u001c\u001a\u00020\u001b2\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001fJ)\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0086\u0002J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0000R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006#"}, d2 = {"Lcom/ss/android/lark/officewebview/webview_api/platform/ViewRect;", "", "x", "", "y", "width", "height", "<init>", "(IIII)V", "()V", "rect", "(Lcom/ss/android/lark/officewebview/webview_api/platform/ViewRect;)V", "getX", "()I", "setX", "(I)V", "getY", "setY", "getWidth", "setWidth", "getHeight", "setHeight", "equals", "", "other", "hashCode", "toString", "", "toShortString", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "set", "", "src", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class g {

    @SerializedName("height")
    private int height;

    @SerializedName("width")
    private int width;

    @SerializedName("x")
    private int x;

    @SerializedName("y")
    private int y;

    public g() {
        this(0, 0, 0, 0);
    }

    public final int hashCode() {
        return (((((this.x * 31) + this.y) * 31) + this.width) * 31) + this.height;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder(32);
        r0.append("Rect(");
        r0.append(this.x);
        r0.append(", ");
        r0.append(this.y);
        r0.append(" - ");
        r0.append(this.width);
        r0.append(", ");
        r0.append(this.height);
        r0.append(")");
        return r0.toString();
    }

    public final void a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "src");
        this.x = r2.x;
        this.y = r2.y;
        this.width = r2.width;
        this.height = r2.height;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(g.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.officewebview.webview_api.platform.ViewRect");
        g r6 = (g) r5;
        if (this.x == r6.x) goto L16;
        return false;
    L16:
        if (this.y == r6.y) goto L19;
        return false;
    L19:
        if (this.width == r6.width) goto L22;
        return false;
    L22:
        if (this.height == r6.height) goto L24;
        return false;
    L24:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public g(int r1, int r2, int r3, int r4) {
        this.x = r1;
        this.y = r2;
        this.width = r3;
        this.height = r4;
    }
}
