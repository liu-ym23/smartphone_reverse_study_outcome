package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "method", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 3})
final class LiveOpenGameClient$checkOpenApi$1 extends Lambda implements Function1<Method, Boolean> {
    final /* synthetic */ Ref.ObjectRef $requestPath;

    public LiveOpenGameClient$checkOpenApi$1(Ref.ObjectRef r1) {
        this.$requestPath = r1;
        super(1);
    }

    public final boolean invoke(Method r8) {
        Ref.ObjectRef r0 = this.$requestPath;
        GET[] r9 = r8.getAnnotations();
        int r1 = r9.length;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L15;
        GET r5 = r9[r3];
        if ((r5 instanceof GET) == false) goto L8;
    L11:
        boolean r6 = true;
    L12:
        if (r6 == true) goto L17;
        r3 = r3 + 1;
    L17:
        if ((r5 instanceof GET) == false) goto L20;
        String r11 = r5.value();
    L23:
        r0.element = r11;
        return StringsKt.contains$default((String) this.$requestPath.element, "openapi", false, 2, null);
    L20:
        if ((r5 instanceof POST) == false) goto L22;
        r11 = ((POST) r5).value();
        goto L23
    L22:
        r11 = "";
        goto L23
    L8:
        if ((r5 instanceof POST) == true) goto L11;
        r6 = false;
        goto L12
    L15:
        r5 = null;
        goto L17
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Boolean.valueOf(invoke((Method) r1));
    }
}
