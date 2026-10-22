package androidx.room.parser.expansion;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import com.bytedance.ai.event.MessageIndication;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Landroidx/room/parser/expansion/ExpandableSection;", "", "()V", MessageIndication.CONTENT_TYPE_TEXT, "", "getText", "()Ljava/lang/String;", "BindVar", "Newline", "Projection", "Text", "Landroidx/room/parser/expansion/ExpandableSection$BindVar;", "Landroidx/room/parser/expansion/ExpandableSection$Newline;", "Landroidx/room/parser/expansion/ExpandableSection$Projection;", "Landroidx/room/parser/expansion/ExpandableSection$Text;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class ExpandableSection {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Landroidx/room/parser/expansion/ExpandableSection$BindVar;", "Landroidx/room/parser/expansion/ExpandableSection;", "symbol", "", "(Ljava/lang/String;)V", "getSymbol", "()Ljava/lang/String;", MessageIndication.CONTENT_TYPE_TEXT, "getText", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class BindVar extends ExpandableSection {
        private final String symbol;

        public BindVar(String r5) {
            Intrinsics.checkNotNullParameter(r5, "symbol");
            super(null);
            this.symbol = r5;
        }

        public static /* synthetic */ BindVar copy$default(BindVar r5, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.symbol;
        L6:
            return r5.copy(r10);
        }

        public final String component1() {
            return this.symbol;
        }

        public final BindVar copy(String r5) {
            Intrinsics.checkNotNullParameter(r5, "symbol");
            return new BindVar(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof BindVar) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.symbol, ((BindVar) r5).symbol) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final String getSymbol() {
            return this.symbol;
        }

        @Override // androidx.room.parser.expansion.ExpandableSection
        public String getText() {
            return this.symbol;
        }

        public int hashCode() {
            return this.symbol.hashCode();
        }

        public String toString() {
            return j0.k("BindVar(symbol=", this.symbol, ")");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/parser/expansion/ExpandableSection$Newline;", "Landroidx/room/parser/expansion/ExpandableSection;", "()V", MessageIndication.CONTENT_TYPE_TEXT, "", "getText", "()Ljava/lang/String;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Newline extends ExpandableSection {
        public static final Newline INSTANCE = null;

        static {
            INSTANCE = new Newline();
        }

        private Newline() {
            super(null);
        }

        @Override // androidx.room.parser.expansion.ExpandableSection
        public String getText() {
            return "\n";
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/parser/expansion/ExpandableSection$Projection;", "Landroidx/room/parser/expansion/ExpandableSection;", "()V", "All", "Table", "Landroidx/room/parser/expansion/ExpandableSection$Projection$All;", "Landroidx/room/parser/expansion/ExpandableSection$Projection$Table;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class Projection extends ExpandableSection {

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/parser/expansion/ExpandableSection$Projection$All;", "Landroidx/room/parser/expansion/ExpandableSection$Projection;", "()V", MessageIndication.CONTENT_TYPE_TEXT, "", "getText", "()Ljava/lang/String;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class All extends Projection {
            public static final All INSTANCE = null;

            static {
                INSTANCE = new All();
            }

            private All() {
                super(null);
            }

            @Override // androidx.room.parser.expansion.ExpandableSection
            public String getText() {
                return XPath.WILDCARD;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/room/parser/expansion/ExpandableSection$Projection$Table;", "Landroidx/room/parser/expansion/ExpandableSection$Projection;", "tableAlias", "", MessageIndication.CONTENT_TYPE_TEXT, "(Ljava/lang/String;Ljava/lang/String;)V", "getTableAlias", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Table extends Projection {
            private final String tableAlias;
            private final String text;

            public Table(String r5, String r10) {
                Intrinsics.checkNotNullParameter(r5, "tableAlias");
                Intrinsics.checkNotNullParameter(r10, MessageIndication.CONTENT_TYPE_TEXT);
                super(null);
                this.tableAlias = r5;
                this.text = r10;
            }

            public static /* synthetic */ Table copy$default(Table r5, String r10, String r11, int r12, Object r13) {
                if ((r12 & 1) == 0) goto L6;
                r10 = r5.tableAlias;
            L6:
                if ((r12 & 2) == 0) goto L9;
                r11 = r5.getText();
            L9:
                return r5.copy(r10, r11);
            }

            public final String component1() {
                return this.tableAlias;
            }

            public final String component2() {
                return getText();
            }

            public final Table copy(String r5, String r10) {
                Intrinsics.checkNotNullParameter(r5, "tableAlias");
                Intrinsics.checkNotNullParameter(r10, MessageIndication.CONTENT_TYPE_TEXT);
                return new Table(r5, r10);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof Table) == true) goto L8;
                return false;
            L8:
                Table r10 = (Table) r5;
                if (Intrinsics.areEqual(this.tableAlias, r10.tableAlias) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(getText(), r10.getText()) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final String getTableAlias() {
                return this.tableAlias;
            }

            @Override // androidx.room.parser.expansion.ExpandableSection
            public String getText() {
                return this.text;
            }

            public int hashCode() {
                int r5 = this.tableAlias.hashCode() * 31;
                return getText().hashCode() + r5;
            }

            public String toString() {
                return j0.l("Table(tableAlias=", this.tableAlias, ", text=", getText(), ")");
            }
        }

        public /* synthetic */ Projection(DefaultConstructorMarker r5) {
            this();
        }

        private Projection() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Landroidx/room/parser/expansion/ExpandableSection$Text;", "Landroidx/room/parser/expansion/ExpandableSection;", "content", "", "(Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", MessageIndication.CONTENT_TYPE_TEXT, "getText", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Text extends ExpandableSection {
        private final String content;

        public Text(String r5) {
            Intrinsics.checkNotNullParameter(r5, "content");
            super(null);
            this.content = r5;
        }

        public static /* synthetic */ Text copy$default(Text r5, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.content;
        L6:
            return r5.copy(r10);
        }

        public final String component1() {
            return this.content;
        }

        public final Text copy(String r5) {
            Intrinsics.checkNotNullParameter(r5, "content");
            return new Text(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Text) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.content, ((Text) r5).content) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final String getContent() {
            return this.content;
        }

        @Override // androidx.room.parser.expansion.ExpandableSection
        public String getText() {
            return this.content;
        }

        public int hashCode() {
            return this.content.hashCode();
        }

        public String toString() {
            return j0.k("Text(content=", this.content, ")");
        }
    }

    public /* synthetic */ ExpandableSection(DefaultConstructorMarker r5) {
        this();
    }

    public abstract String getText();

    private ExpandableSection() {
    }
}
