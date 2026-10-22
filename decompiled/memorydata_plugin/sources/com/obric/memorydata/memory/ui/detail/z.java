package com.obric.memorydata.memory.ui.detail;

import android.content.Context;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J,\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\rH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/NavLinkHandler;", "Lcom/obric/memorydata/markdown/custom/LinkClickHandler;", "onDismiss", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "onClick", "context", "Landroid/content/Context;", EventBody.KEY_VALUE, "", WsConstants.KEY_EXTRA, "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class z implements com.obric.memorydata.markdown.custom.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<Unit> f10890a;

    /* JADX WARN: Multi-variable type inference failed */
    public z() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public z(Function0<Unit> r3) {
        this.f10890a = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ z(Function0 r2, int r3, DefaultConstructorMarker r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }

    private static final Unit a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "defaultMapPackageName");
        com.obric.memorydata.memory.ui.settings.l.f11479a.a().a(r1);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$VGGYA9DKk1XThH5RW5n_wbxFJ7A(String r0) {
        return a(r0);
    }

    @Override // com.obric.memorydata.markdown.custom.d
    public void a(Context r3, String r4, Map<String, String> r5) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
        Intrinsics.checkNotNullParameter(r6, WsConstants.KEY_EXTRA);
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        com.obric.memorydata.markdown.custom.e.f9983a.a(r2, r7, (String) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.ui.settings.l.f11479a.a().e().c(), String.class, "com.obric.memorydata.plugin"), $$Lambda$z$VGGYA9DKk1XThH5RW5n_wbxFJ7A.INSTANCE);
    }
}
