package com.obric.memorydata.task.utils;

import com.bytedance.crash.entity.EventBody;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00060\u0007j\u0002`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/task/utils/BoundedTextAccumulator;", "", XSDatatype.FACET_MAXLENGTH, "", "<init>", "(I)V", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", EventBody.KEY_VALUE, "originalLength", "getOriginalLength", "()I", "truncated", "", "getTruncated", "()Z", "appendLine", "", Params.CONTENT, "", "build", "", "append", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StringBuilder f12968b;
    private int c;

    public a(int r2) {
        this.f12967a = r2;
        this.f12968b = new StringBuilder();
        if (r2 < 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("maxLength must not be negative".toString());
    L5:
        r1 = false;
        goto L6
    }

    public static /* synthetic */ void a(a r1, CharSequence r2, int r3, Object r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L5:
        r1.a(r5);
    }

    private final void b(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        this.c += r5.length();
        int r0 = this.f12967a - this.f12968b.length();
        if (r0 > 0) goto L5;
        return;
    L5:
        this.f12968b.append(r5, 0, Math.min(r5.length(), r0));
    }

    public final int a() {
        return this.c;
    }

    public final void a(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
        b(r4);
        b((CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public final boolean b() {
        if (this.c <= this.f12967a) goto L5;
        return true;
    L5:
        return false;
    }

    public final String c() {
        String r1 = this.f12968b.toString();
        Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");
        return r1;
    }
}
