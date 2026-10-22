package com.obric.memorydata.memory.ui.detail;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J,\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\rH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/PhoneLinkHandler;", "Lcom/obric/memorydata/markdown/custom/LinkClickHandler;", "onDismiss", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "onClick", "context", "Landroid/content/Context;", EventBody.KEY_VALUE, "", WsConstants.KEY_EXTRA, "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class aa implements com.obric.memorydata.markdown.custom.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<Unit> f10842a;

    /* JADX WARN: Multi-variable type inference failed */
    public aa() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public aa(Function0<Unit> r3) {
        this.f10842a = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ aa(Function0 r2, int r3, DefaultConstructorMarker r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }

    @Override // com.obric.memorydata.markdown.custom.d
    public void a(Context r3, String r4, Map<String, String> r5) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
        Intrinsics.checkNotNullParameter(r6, WsConstants.KEY_EXTRA);
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.get("action"), String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        r7 = "menu";
    L5:
        String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r8, "toLowerCase(...)");
        String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        switch(r8.hashCode()) {
            case 96417: goto L21;
            case 114009: goto L17;
            case 3045982: goto L13;
            case 3059573: goto L9;
            default: goto L24;
        };
    L24:
        com.obric.memorydata.markdown.custom.j.f9994a.d(r2, r9);
        return;
    L9:
        if (r8.equals("copy") == false) goto L24;
        com.obric.memorydata.markdown.custom.j.f9994a.c(r2, r9);
        return;
    L13:
        if (r8.equals(NotificationCompat.CATEGORY_CALL) == false) goto L24;
        com.obric.memorydata.markdown.custom.j.f9994a.a(r2, r9);
        return;
    L17:
        if (r8.equals("sms") == false) goto L24;
        com.obric.memorydata.markdown.custom.j.f9994a.a(r2, r9, (String) ZeusTransformUtils.preCheckCast(r6.get("body"), String.class, "com.obric.memorydata.plugin"));
        return;
    L21:
        if (r8.equals("add") == false) goto L24;
        com.obric.memorydata.markdown.custom.j.f9994a.b(r2, r9);
    }
}
