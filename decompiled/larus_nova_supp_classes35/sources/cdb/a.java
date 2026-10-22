package cdb;

import com.bytedance.lark.pb.basic.v1.CardComponent;
import com.ss.android.lark.tangram.base.style.Value;
import com.ss.android.lark.tangram.base.style.ValueType;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final Value a(CardComponent.Value r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        ValueType.a r1 = ValueType.Companion;
        int r2 = r3.type.getValue();
        r1.getClass();
        return new Value(ValueType.a.a(r2), r3.value);
    }
}
