package io.noties.markwon.html.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00060\tj\u0002`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lio/noties/markwon/html/customdata/BlockContent;", "", "()V", Params.CONTENT, "", "(Ljava/lang/String;)V", "lineCount", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", TypedValues.Custom.S_STRING, "getString", "()Ljava/lang/String;", "add", "", "line", "", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f16550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16551b;

    public a() {
        this.f16550a = new StringBuilder();
    }

    public final String a() {
        String r1 = this.f16550a.toString();
        Intrinsics.checkExpressionValueIsNotNull(r1, "sb.toString()");
        return r1;
    }

    public final void a(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.f16551b == 0) goto L5;
        this.f16550a.append('\n');
    L5:
        this.f16550a.append(r4);
        this.f16551b++;
    }
}
