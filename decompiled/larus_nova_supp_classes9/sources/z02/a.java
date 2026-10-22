package z02;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.tray.DialogStatus;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends MVIState<a> {
    public static final /* synthetic */ KProperty[] b = null;
    public final r a;

    static {
        b = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "containerPosition", "getContainerPosition()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r a() {
        r r0 = this.a;
        KProperty r1 = b[0];
        r0.getClass();
        return r0;
    }

    public a() {
        Pair r0 = TuplesKt.to(DialogStatus.DIALOG_CLOSE, Integer.valueOf((int) s1.getContext().getResources().getDimension(2131168683)));
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        r r1 = new r(r0, r2, r3);
        ((c) r1).a = b[0].getName();
        r3.invoke(r1);
        this.a = r1;
    }
}
