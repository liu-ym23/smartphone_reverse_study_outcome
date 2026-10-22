package com.larus.business.markdown.impl.markwon.custom.title;

import android.text.NoCopySpan;
import com.larus.business.markdown.api.FullScreenDetailType;
import com.obric.aikernel.sdk.ext.Params;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0014\u0010\u000b\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/custom/title/FullScreenDetailInfoSpan;", "Landroid/text/NoCopySpan;", "Lcom/larus/business/markdown/api/IFullScreenDetailSpan;", "info", "", Params.CONTENT, "copyContent", "type", "Lcom/larus/business/markdown/api/FullScreenDetailType;", "isCompleted", "", "isPreview", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/business/markdown/api/FullScreenDetailType;ZZ)V", "getContent", "()Ljava/lang/String;", "getCopyContent", "getInfo", "()Z", "getType", "()Lcom/larus/business/markdown/api/FullScreenDetailType;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b implements NoCopySpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5232b;
    private final String c;
    private final FullScreenDetailType d;
    private final boolean e;
    private final boolean f;

    public b(String r2, String r3, String r4, FullScreenDetailType r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "info");
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r4, "copyContent");
        Intrinsics.checkNotNullParameter(r5, "type");
        this.f5231a = r2;
        this.f5232b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public /* synthetic */ b(String r8, String r9, String r10, FullScreenDetailType r11, boolean r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 32) == 0) goto L5;
        r13 = false;
    L5:
        this(r8, r9, r10, r11, r12, r13);
    }

    public FullScreenDetailType getType() {
        return this.d;
    }
}
