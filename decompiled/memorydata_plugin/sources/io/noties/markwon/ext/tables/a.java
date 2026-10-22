package io.noties.markwon.ext.tables;

import android.text.style.ReplacementSpan;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0016J(\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\u0010\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH&J=\u0010\u0011\u001a\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\u0012\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH&¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\nH\u0014J\u0012\u0010\u0003\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J>\u0010\u0018\u001a\u00020\n\"\b\b\u0000\u0010\u0019*\u00020\f\"\b\b\u0001\u0010\u001a*\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00190\u000e2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001a0\u001dH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001f"}, d2 = {"Lio/noties/markwon/ext/tables/AbsTableRowSpan;", "Landroid/text/style/ReplacementSpan;", "()V", "invalidator", "Lio/noties/markwon/ext/tables/AbsTableRowSpan$Invalidator;", "getInvalidator", "()Lio/noties/markwon/ext/tables/AbsTableRowSpan$Invalidator;", "setInvalidator", "(Lio/noties/markwon/ext/tables/AbsTableRowSpan$Invalidator;)V", "clearSpansInTable", "", com.tom_roush.pdfbox.pdmodel.a.d.i.F, "", "span", "Ljava/lang/Class;", "findSpanInRow", "", "findSpanInTable", "", "x", "", "y", "(IILjava/lang/Class;)[Ljava/lang/Object;", "invalidateSelf", "setSpansInTable", "coveredSpan", "setSpan", "toCoveredSpan", "getToSetSpan", "Lkotlin/Function1;", "Invalidator", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
public abstract class a extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterfaceC0862a f16493a;

    /* JADX INFO: renamed from: io.noties.markwon.ext.tables.a$a, reason: collision with other inner class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lio/noties/markwon/ext/tables/AbsTableRowSpan$Invalidator;", "", "invalidate", "", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
    public interface InterfaceC0862a {
        void a();
    }

    public a() {
    }

    public void a() {
        InterfaceC0862a r0 = this.f16493a;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public void a(InterfaceC0862a r3) {
        this.f16493a = (InterfaceC0862a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0862a.class, "com.obric.memorydata.plugin");
    }

    public abstract <Span> Span[] a(int r1, int r2, Class<Span> r3);
}
