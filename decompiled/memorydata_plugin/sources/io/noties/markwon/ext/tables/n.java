package io.noties.markwon.ext.tables;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.CustomNode;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lio/noties/markwon/ext/tables/TableTitle;", "Lorg/commonmark/node/CustomNode;", "()V", "excelLiteral", "", "getExcelLiteral", "()Ljava/lang/String;", "setExcelLiteral", "(Ljava/lang/String;)V", "info", "getInfo", "setInfo", "literal", "getLiteral", "setLiteral", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
public final class n extends CustomNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16526b;
    private String c;

    public n() {
        this.f16525a = "";
        this.f16526b = "";
        this.c = "";
    }

    public final String a() {
        return this.f16525a;
    }

    public final void a(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.f16525a = r2;
    }

    public final String b() {
        return this.f16526b;
    }

    public final void b(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.f16526b = r2;
    }

    public final String c() {
        return this.c;
    }

    public final void c(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.c = r2;
    }
}
