package io.noties.markwon.core.spans.a;

import android.text.NoCopySpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\r¨\u0006\u000e"}, d2 = {"Lio/noties/markwon/core/spans/codeblock/CodeCopyInfoSpan;", "Landroid/text/NoCopySpan;", "Lcom/larus/business/markdown/api/model/ICodeCopyInfoSpan;", "codeInfo", "", "code", "isCompleted", "", "isShare", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getCode", "()Ljava/lang/String;", "getCodeInfo", "()Z", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c implements NoCopySpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f16449b;
    private final boolean c;
    private final boolean d;

    public c(String r2, String r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "codeInfo");
        Intrinsics.checkNotNullParameter(r3, "code");
        this.f16448a = r2;
        this.f16449b = r3;
        this.c = r4;
        this.d = r5;
    }
}
