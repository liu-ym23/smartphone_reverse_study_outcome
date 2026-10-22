package androidx.core.view;

import android.view.ViewParent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class ViewKt$ancestors$1 extends FunctionReferenceImpl implements Function1<ViewParent, ViewParent> {
    public static final ViewKt$ancestors$1 INSTANCE = null;

    static {
        INSTANCE = new ViewKt$ancestors$1();
    }

    ViewKt$ancestors$1() {
        super(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ViewParent invoke2(ViewParent r2) {
        return ((ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.memorydata.plugin")).getParent();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ ViewParent invoke(ViewParent r3) {
        return invoke2((ViewParent) ZeusTransformUtils.preCheckCast(r3, ViewParent.class, "com.obric.memorydata.plugin"));
    }
}
