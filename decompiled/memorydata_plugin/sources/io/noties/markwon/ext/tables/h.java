package io.noties.markwon.ext.tables;

import android.text.Spanned;
import android.widget.TextView;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\u0017\u0018\u0019B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lio/noties/markwon/ext/tables/TablePlugin2;", "Lio/noties/markwon/AbstractMarkwonPlugin;", "tableTheme", "Lio/noties/markwon/ext/tables/TableTheme2;", "scrollBarTheme", "Lio/noties/markwon/scrollable/ScrollBarTheme;", "tableOptions", "Lio/noties/markwon/ext/tables/TableOptions;", "(Lio/noties/markwon/ext/tables/TableTheme2;Lio/noties/markwon/scrollable/ScrollBarTheme;Lio/noties/markwon/ext/tables/TableOptions;)V", "visitor", "Lio/noties/markwon/ext/tables/TablePlugin2$TableVisitor;", "afterSetText", "", "textView", "Landroid/widget/TextView;", "beforeSetText", "markdown", "Landroid/text/Spanned;", "configureParser", "builder", "Lorg/commonmark/parser/Parser$Builder;", "configureVisitor", "Lio/noties/markwon/MarkwonVisitor$Builder;", "Cell", com.tom_roush.pdfbox.pdmodel.a.d.h.i, "TableVisitor", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
public final class h extends io.noties.markwon.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f16499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m f16500b;
    private final io.noties.markwon.scrollable.e c;
    private final g d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000e@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\""}, d2 = {"Lio/noties/markwon/ext/tables/TablePlugin2$Cell;", "", "alignment", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "(ILjava/lang/CharSequence;)V", "getAlignment", "()I", "<set-?>", "end", "getEnd", "setEnd$markwon_ext_tables_release", "(I)V", "", "maxWidth", "getMaxWidth", "()F", "setMaxWidth$markwon_ext_tables_release", "(F)V", CommonConsts.APM_INNER_EVENT_COST_START, "getStart", "setStart$markwon_ext_tables_release", "getText", "()Ljava/lang/CharSequence;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f16501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f16502b;
        private float c;
        private final int d;
        private final CharSequence e;

        public a(int r3, CharSequence r4) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r5, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            this.d = r3;
            this.e = r5;
            this.f16501a = -1;
            this.f16502b = -1;
        }

        public final int a() {
            return this.f16501a;
        }

        public final void a(float r1) {
            this.c = r1;
        }

        public final void a(int r1) {
            this.f16501a = r1;
        }

        public final int b() {
            return this.f16502b;
        }

        public final void b(int r1) {
            this.f16502b = r1;
        }

        public final float c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public final CharSequence e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L5;
        L15:
            return true;
        L5:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == false) goto L14;
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.d != r6.d) goto L9;
            boolean r0 = true;
        L10:
            if (r0 == false) goto L14;
            if (Intrinsics.areEqual(this.e, r6.e) == false) goto L14;
        L9:
            r0 = false;
        L14:
            return false;
        }

        public int hashCode() {
            int r0 = this.d * 31;
            CharSequence r1 = this.e;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        public String toString() {
            return "Cell(alignment=" + this.d + ", text=" + this.e + ")";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\bHÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000e¨\u0006\u0018"}, d2 = {"Lio/noties/markwon/ext/tables/TablePlugin2$Row;", "", "index", "", "cells", "", "Lio/noties/markwon/ext/tables/TablePlugin2$Cell;", "isHeader", "", "(ILjava/util/List;Z)V", "getCells", "()Ljava/util/List;", "getIndex", "()I", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f16503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<a> f16504b;
        private final boolean c;

        public b(int r3, List<a> r4, boolean r5) {
            List<a> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r6, "cells");
            this.f16503a = r3;
            this.f16504b = r6;
            this.c = r5;
        }

        public final int a() {
            return this.f16503a;
        }

        public final List<a> b() {
            return this.f16504b;
        }

        public final boolean c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L5;
        L20:
            return true;
        L5:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == false) goto L19;
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (this.f16503a != r6.f16503a) goto L9;
            boolean r0 = true;
        L10:
            if (r0 == false) goto L19;
            if (Intrinsics.areEqual(this.f16504b, r6.f16504b) == false) goto L19;
            if (this.c != r6.c) goto L16;
            boolean r4 = true;
        L17:
            if (r4 == false) goto L19;
        L16:
            r4 = false;
            goto L17
        L9:
            r0 = false;
        L19:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public int hashCode() {
            int r0 = this.f16503a * 31;
            List<a> r1 = this.f16504b;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L6:
            int r3 = (r0 + r2) * 31;
            boolean r4 = this.c;
            ?? r5 = r4;
            if (r4 == false) goto L10;
            r5 = 1;
        L10:
            return r3 + r5;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "Row(index=" + this.f16503a + ", cells=" + this.f16504b + ", isHeader=" + this.c + ")";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lio/noties/markwon/ext/tables/TablePlugin2$TableVisitor;", "", "(Lio/noties/markwon/ext/tables/TablePlugin2;)V", "pendingRow", "", "Lio/noties/markwon/ext/tables/TablePlugin2$Cell;", "pendingTable", "Lio/noties/markwon/ext/tables/TablePlugin2$Row;", "tableBodyIndex", "", "tableRowIndex", "tableRowIsHeader", "", "clear", "", "configure", "builder", "Lio/noties/markwon/MarkwonVisitor$Builder;", "visitRow", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "node", "Lorg/commonmark/node/Node;", "visitTable", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
    private final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f16505a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<a> f16506b;
        private final List<b> c;
        private boolean d;
        private int e;
        private int f;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "tableBlock", "Lorg/commonmark/ext/gfm/tables/TableBlock;", "visit"}, k = 3, mv = {1, 1, 15})
        static final class a<N extends Node> implements io.noties.markwon.n.c<TableBlock> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f16507a;

            a(c r1) {
                this.f16507a = r1;
            }

            public final void a(io.noties.markwon.n r4, TableBlock r5) {
                io.noties.markwon.n r6 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r4, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
                Intrinsics.checkParameterIsNotNull(r6, "visitor");
                Intrinsics.checkParameterIsNotNull(r5, "tableBlock");
                c.a(this.f16507a);
                r6.e((Node) ZeusTransformUtils.preCheckCast(r5, Node.class, "com.obric.memorydata.plugin"));
                c.a(this.f16507a, r6, (Node) ZeusTransformUtils.preCheckCast(r5, Node.class, "com.obric.memorydata.plugin"));
                r6.f((Node) ZeusTransformUtils.preCheckCast(r5, Node.class, "com.obric.memorydata.plugin"));
                c.a(this.f16507a);
            }

            @Override // io.noties.markwon.n.c
            public /* synthetic */ void a(io.noties.markwon.n r3, Node r4) {
                a((io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.n.class, "com.obric.memorydata.plugin"), (TableBlock) ZeusTransformUtils.preCheckCast(r4, TableBlock.class, "com.obric.memorydata.plugin"));
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "tableTitle", "Lio/noties/markwon/ext/tables/TableTitle;", "visit"}, k = 3, mv = {1, 1, 15})
        static final class b<N extends Node> implements io.noties.markwon.n.c<n> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f16508a = null;

            static {
                f16508a = new b();
            }

            b() {
            }

            public final void a(io.noties.markwon.n r2, n r3) {
                io.noties.markwon.n r1 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r2, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
                Intrinsics.checkParameterIsNotNull(r1, "visitor");
                Intrinsics.checkParameterIsNotNull(r3, "tableTitle");
                r1.c((Node) ZeusTransformUtils.preCheckCast(r3, Node.class, "com.obric.memorydata.plugin"));
            }

            @Override // io.noties.markwon.n.c
            public /* synthetic */ void a(io.noties.markwon.n r3, Node r4) {
                a((io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.n.class, "com.obric.memorydata.plugin"), (n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.memorydata.plugin"));
            }
        }

        /* JADX INFO: renamed from: io.noties.markwon.ext.tables.h$c$c, reason: collision with other inner class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "tableBody", "Lorg/commonmark/ext/gfm/tables/TableBody;", "visit"}, k = 3, mv = {1, 1, 15})
        static final class C0863c<N extends Node> implements io.noties.markwon.n.c<TableBody> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0863c f16509a = null;

            static {
                f16509a = new C0863c();
            }

            C0863c() {
            }

            public final void a(io.noties.markwon.n r2, TableBody r3) {
                io.noties.markwon.n r1 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r2, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
                Intrinsics.checkParameterIsNotNull(r1, "visitor");
                Intrinsics.checkParameterIsNotNull(r3, "tableBody");
                r1.c((Node) ZeusTransformUtils.preCheckCast(r3, Node.class, "com.obric.memorydata.plugin"));
            }

            @Override // io.noties.markwon.n.c
            public /* synthetic */ void a(io.noties.markwon.n r3, Node r4) {
                a((io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.n.class, "com.obric.memorydata.plugin"), (TableBody) ZeusTransformUtils.preCheckCast(r4, TableBody.class, "com.obric.memorydata.plugin"));
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "tableRow", "Lorg/commonmark/ext/gfm/tables/TableRow;", "visit"}, k = 3, mv = {1, 1, 15})
        static final class d<N extends Node> implements io.noties.markwon.n.c<TableRow> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f16510a;

            d(c r1) {
                this.f16510a = r1;
            }

            public final void a(io.noties.markwon.n r3, TableRow r4) {
                io.noties.markwon.n r5 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
                Intrinsics.checkParameterIsNotNull(r5, "visitor");
                Intrinsics.checkParameterIsNotNull(r4, "tableRow");
                c.b(this.f16510a, r5, (Node) ZeusTransformUtils.preCheckCast(r4, Node.class, "com.obric.memorydata.plugin"));
            }

            @Override // io.noties.markwon.n.c
            public /* synthetic */ void a(io.noties.markwon.n r3, Node r4) {
                a((io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.n.class, "com.obric.memorydata.plugin"), (TableRow) ZeusTransformUtils.preCheckCast(r4, TableRow.class, "com.obric.memorydata.plugin"));
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "tableHead", "Lorg/commonmark/ext/gfm/tables/TableHead;", "visit"}, k = 3, mv = {1, 1, 15})
        static final class e<N extends Node> implements io.noties.markwon.n.c<TableHead> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f16511a;

            e(c r1) {
                this.f16511a = r1;
            }

            public final void a(io.noties.markwon.n r4, TableHead r5) {
                io.noties.markwon.n r6 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r4, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
                Intrinsics.checkParameterIsNotNull(r6, "visitor");
                Intrinsics.checkParameterIsNotNull(r5, "tableHead");
                c.a(this.f16511a, true);
                r6.c((Node) ZeusTransformUtils.preCheckCast(r5, Node.class, "com.obric.memorydata.plugin"));
                c.a(this.f16511a, false);
            }

            @Override // io.noties.markwon.n.c
            public /* synthetic */ void a(io.noties.markwon.n r3, Node r4) {
                a((io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.n.class, "com.obric.memorydata.plugin"), (TableHead) ZeusTransformUtils.preCheckCast(r4, TableHead.class, "com.obric.memorydata.plugin"));
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "tableCell", "Lorg/commonmark/ext/gfm/tables/TableCell;", "visit"}, k = 3, mv = {1, 1, 15})
        static final class f<N extends Node> implements io.noties.markwon.n.c<TableCell> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f16512a;

            f(c r1) {
                this.f16512a = r1;
            }

            public final void a(io.noties.markwon.n r4, TableCell r5) {
                io.noties.markwon.n r6 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r4, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
                Intrinsics.checkParameterIsNotNull(r6, "visitor");
                Intrinsics.checkParameterIsNotNull(r5, "tableCell");
                int r0 = r6.f();
                r6.c((Node) ZeusTransformUtils.preCheckCast(r5, Node.class, "com.obric.memorydata.plugin"));
                List r3 = c.b(this.f16512a);
                int r7 = io.noties.markwon.ext.tables.b.a(r5.getAlignment());
                CharSequence r8 = r6.c().a(r0);
                Intrinsics.checkExpressionValueIsNotNull(r8, "visitor.builder().removeFromEnd(length)");
                r3.add(new a(r7, r8));
            }

            @Override // io.noties.markwon.n.c
            public /* synthetic */ void a(io.noties.markwon.n r3, Node r4) {
                a((io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.n.class, "com.obric.memorydata.plugin"), (TableCell) ZeusTransformUtils.preCheckCast(r4, TableCell.class, "com.obric.memorydata.plugin"));
            }
        }

        public c(h r3) {
            this.f16505a = r3;
            this.f16506b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            this.c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        }

        private final void a() {
            this.f16506b.clear();
            this.c.clear();
            this.d = false;
            this.f = 0;
            this.e = 0;
        }

        public static final /* synthetic */ void a(c r0) {
            r0.a();
        }

        public static final /* synthetic */ void a(c r2, io.noties.markwon.n r3, Node r4) {
            r2.b((io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.n.class, "com.obric.memorydata.plugin"), r4);
        }

        public static final /* synthetic */ void a(c r0, boolean r1) {
            r0.d = r1;
        }

        private final void a(io.noties.markwon.n r4, Node r5) {
            ((io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r4, io.noties.markwon.n.class, "com.obric.memorydata.plugin")).c(r5);
            this.c.add(new b(this.f, CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.f16506b, Iterable.class, "com.obric.memorydata.plugin")), this.d));
            this.f++;
            this.f16506b.clear();
        }

        public static final /* synthetic */ List b(c r0) {
            return r0.f16506b;
        }

        public static final /* synthetic */ void b(c r2, io.noties.markwon.n r3, Node r4) {
            r2.a((io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.n.class, "com.obric.memorydata.plugin"), r4);
        }

        private final void b(io.noties.markwon.n r23, Node r24) {
            io.noties.markwon.n r1 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r23, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
            int r3 = r1.f();
            r1.c(r24);
            io.noties.markwon.scrollable.b r10 = new io.noties.markwon.scrollable.b(0.0f);
            List r11 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin"));
            Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r12.hasNext() == false) goto L16;
            b r8 = (b) ZeusTransformUtils.preCheckCast(r12.next(), b.class, "com.obric.memorydata.plugin");
            int r13 = r1.f();
            if (h.a(this.f16505a).m() != 1) goto L11;
            Iterator<a> r4 = r8.b().iterator();
        L9:
            if (r4.hasNext() == false) goto L15;
            a r7 = (a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.memorydata.plugin");
            int r9 = r1.f();
            r1.c().a(StringsKt.replace$default(r7.e().toString(), "\n", " ", false, 4, null)).a(" ");
            r7.a(r9);
            r7.b(r1.f() - 1);
        L15:
            r1.d();
            r1.a(r13, new i(h.a(this.f16505a), h.b(this.f16505a), r11, r8, r10));
            goto L4
        L11:
            r1.c().a("|");
            Iterator<a> r5 = r8.b().iterator();
        L13:
            if (r5.hasNext() == false) goto L15;
            a r14 = (a) ZeusTransformUtils.preCheckCast(r5.next(), a.class, "com.obric.memorydata.plugin");
            int r15 = r1.f();
            r1.c().a(" ").a(StringsKt.replace$default(r14.e().toString(), "\n", " ", false, 4, null)).a(" |");
            r14.a(r15);
            r14.b(r1.f() - 1);
            goto L13
        L16:
            r1.a(r3, r10);
            r1.a(r3, new k());
        }

        public final void a(io.noties.markwon.n.b r5) {
            io.noties.markwon.n.b r6 = (io.noties.markwon.n.b) ZeusTransformUtils.wrapperContextForParams(r5, io.noties.markwon.n.b.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r6, "builder");
            r6.a(TableBlock.class, (io.noties.markwon.n.c) ZeusTransformUtils.preCheckCast(new a(this), io.noties.markwon.n.c.class, "com.obric.memorydata.plugin")).a(n.class, (io.noties.markwon.n.c) ZeusTransformUtils.preCheckCast(b.f16508a, io.noties.markwon.n.c.class, "com.obric.memorydata.plugin")).a(TableBody.class, (io.noties.markwon.n.c) ZeusTransformUtils.preCheckCast(C0863c.f16509a, io.noties.markwon.n.c.class, "com.obric.memorydata.plugin")).a(TableRow.class, (io.noties.markwon.n.c) ZeusTransformUtils.preCheckCast(new d(this), io.noties.markwon.n.c.class, "com.obric.memorydata.plugin")).a(TableHead.class, (io.noties.markwon.n.c) ZeusTransformUtils.preCheckCast(new e(this), io.noties.markwon.n.c.class, "com.obric.memorydata.plugin")).a(TableCell.class, (io.noties.markwon.n.c) ZeusTransformUtils.preCheckCast(new f(this), io.noties.markwon.n.c.class, "com.obric.memorydata.plugin"));
        }
    }

    public h(m r2, io.noties.markwon.scrollable.e r3, g r4) {
        Intrinsics.checkParameterIsNotNull(r2, "tableTheme");
        Intrinsics.checkParameterIsNotNull(r3, "scrollBarTheme");
        Intrinsics.checkParameterIsNotNull(r4, "tableOptions");
        this.f16500b = r2;
        this.c = r3;
        this.d = r4;
        this.f16499a = new c(this);
    }

    public static final /* synthetic */ m a(h r0) {
        return r0.f16500b;
    }

    public static final /* synthetic */ io.noties.markwon.scrollable.e b(h r0) {
        return r0.c;
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(TextView r1) {
        Intrinsics.checkParameterIsNotNull(r1, "textView");
        j.a(r1);
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(TextView r2, Spanned r3) {
        Spanned r1 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r3, Spanned.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r2, "textView");
        Intrinsics.checkParameterIsNotNull(r1, "markdown");
        j.b(r2);
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(io.noties.markwon.n.b r3) {
        io.noties.markwon.n.b r4 = (io.noties.markwon.n.b) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.n.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "builder");
        this.f16499a.a(r4);
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(Parser.Builder r3) {
        Intrinsics.checkParameterIsNotNull(r3, "builder");
        r3.extensions((Iterable) ZeusTransformUtils.preCheckCast(SetsKt.setOf(new o(this.d)), Iterable.class, "com.obric.memorydata.plugin"));
    }
}
