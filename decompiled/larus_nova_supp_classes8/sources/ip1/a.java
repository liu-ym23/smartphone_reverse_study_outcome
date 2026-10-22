package ip1;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class a<T> implements lp1.b<T> {
    public final ArrayList<T> a;
    public final ElementType b;

    @Override // lp1.b
    public final ArrayList<T> getChildren() {
        return this.a;
    }

    @Override // lp1.b
    public final ElementType getElementType() {
        return this.b;
    }

    public a(ElementType r2) {
        Intrinsics.checkNotNullParameter(r2, "elementType");
        this.b = r2;
        this.a = new ArrayList();
    }
}
