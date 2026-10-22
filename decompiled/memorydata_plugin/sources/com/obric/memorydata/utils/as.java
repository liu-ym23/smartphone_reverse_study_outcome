package com.obric.memorydata.utils;

import android.content.Context;
import android.content.Intent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B/\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ \u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/utils/StartActivityAction;", "Lcom/obric/memorydata/utils/ClickAction;", "activityClass", "Ljava/lang/Class;", "intentBuilder", "Lkotlin/Function1;", "Landroid/content/Intent;", "", "<init>", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)V", "execute", "context", "Landroid/content/Context;", "keyword", "", "data", "parseUrlParams", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class as implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f13179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<Intent, Unit> f13180b;

    /* JADX WARN: Multi-variable type inference failed */
    public as() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public as(Class<?> r3, Function1<? super Intent, Unit> r4) {
        Function1<Intent, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        this.f13179a = r3;
        this.f13180b = r5;
    }

    public /* synthetic */ as(Class r2, Function1 r3, int r4, DefaultConstructorMarker r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r6 = null;
    L8:
        this(r2, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<String, String> a(String r13) {
        Map<String, String> r12 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L10;
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.substringAfter$default(r13, "?", null, 2, null), CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"&"}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r14.hasNext() == false) goto L10;
        List r0 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"="}, false, 0, 6, null);
        if (r0.size() != 2) goto L6;
        r12.put(r0.get(0), r0.get(1));
    L10:
        return r12;
    }

    @Override // com.obric.memorydata.utils.e
    public void a(Context r7, String r8, String r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r8, "keyword");
        Intrinsics.checkNotNullParameter(r9, "data");
        if (this.f13179a == null) goto L5;
        Intent r11 = new Intent(r10, this.f13179a);
    L6:
        Function1<Intent, Unit> r0 = this.f13180b;
        if (r0 == null) goto L10;
        r0.invoke(r11);
    L10:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L15;
        Iterator<Map.Entry<String, String>> r6 = a(r9).entrySet().iterator();
    L13:
        if (r6.hasNext() == false) goto L15;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r11.putExtra((String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r12.getValue(), String.class, "com.obric.memorydata.plugin"));
    L15:
        ZeusTransformUtils.startActivity(r10, r11, "com.obric.memorydata.plugin");
        return;
    L5:
        r11 = new Intent(r10, ZeusTransformUtils.forName(r9, "com.obric.memorydata.plugin"));
        goto L6
    }
}
