package androidx.room.parser;

import ai.j0;
import com.bytedance.ai.event.MessageIndication;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b2\u00020\u0001:\u0004\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Landroidx/room/parser/Section;", "", "()V", MessageIndication.CONTENT_TYPE_TEXT, "", "getText", "()Ljava/lang/String;", "BindVar", "Companion", "NewLine", "Text", "Landroidx/room/parser/Section$BindVar;", "Landroidx/room/parser/Section$NewLine;", "Landroidx/room/parser/Section$Text;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class Section {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u0004\u0018\u00010\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Landroidx/room/parser/Section$BindVar;", "Landroidx/room/parser/Section;", MessageIndication.CONTENT_TYPE_TEXT, "", "isMultiple", "", "(Ljava/lang/String;Z)V", "()Z", "getText", "()Ljava/lang/String;", "varName", "getVarName", "varName$delegate", "Lkotlin/Lazy;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class BindVar extends Section {
        private final boolean isMultiple;
        private final String text;
        private final Lazy varName$delegate;

        public BindVar(String r5, boolean r10) {
            Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
            super(null);
            this.text = r5;
            this.isMultiple = r10;
            this.varName$delegate = LazyKt.lazy(new Section$BindVar$varName$2(this));
        }

        public static /* synthetic */ BindVar copy$default(BindVar r5, String r10, boolean r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = r5.getText();
        L6:
            if ((r12 & 2) == 0) goto L9;
            r11 = r5.isMultiple;
        L9:
            return r5.copy(r10, r11);
        }

        public final String component1() {
            return getText();
        }

        public final boolean component2() {
            return this.isMultiple;
        }

        public final BindVar copy(String r5, boolean r10) {
            Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
            return new BindVar(r5, r10);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof BindVar) == true) goto L8;
            return false;
        L8:
            BindVar r10 = (BindVar) r5;
            if (Intrinsics.areEqual(getText(), r10.getText()) == true) goto L12;
            return false;
        L12:
            if (this.isMultiple == r10.isMultiple) goto L14;
            return false;
        L14:
            return true;
        }

        @Override // androidx.room.parser.Section
        public String getText() {
            return this.text;
        }

        public final String getVarName() {
            return (String) this.varName$delegate.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        public int hashCode() {
            int r5 = getText().hashCode() * 31;
            boolean r10 = this.isMultiple;
            ?? r11 = r10;
            if (r10 == false) goto L6;
            r11 = 1;
        L6:
            return r5 + r11;
        }

        public final boolean isMultiple() {
            return this.isMultiple;
        }

        public String toString() {
            return "BindVar(text=" + getText() + ", isMultiple=" + this.isMultiple + ")";
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Landroidx/room/parser/Section$Companion;", "", "()V", "bindVar", "Landroidx/room/parser/Section$BindVar;", MessageIndication.CONTENT_TYPE_TEXT, "", "isMultiple", "", "newline", "Landroidx/room/parser/Section$NewLine;", "Landroidx/room/parser/Section$Text;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final BindVar bindVar(String r5, boolean r10) {
            Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
            return new BindVar(r5, r10);
        }

        public final NewLine newline() {
            return NewLine.INSTANCE;
        }

        public final Text text(String r5) {
            Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
            return new Text(r5);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/parser/Section$NewLine;", "Landroidx/room/parser/Section;", "()V", MessageIndication.CONTENT_TYPE_TEXT, "", "getText", "()Ljava/lang/String;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class NewLine extends Section {
        public static final NewLine INSTANCE = null;

        static {
            INSTANCE = new NewLine();
        }

        private NewLine() {
            super(null);
        }

        @Override // androidx.room.parser.Section
        public String getText() {
            return "";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/room/parser/Section$Text;", "Landroidx/room/parser/Section;", MessageIndication.CONTENT_TYPE_TEXT, "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Text extends Section {
        private final String text;

        public Text(String r5) {
            Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
            super(null);
            this.text = r5;
        }

        public static /* synthetic */ Text copy$default(Text r5, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.getText();
        L6:
            return r5.copy(r10);
        }

        public final String component1() {
            return getText();
        }

        public final Text copy(String r5) {
            Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
            return new Text(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Text) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(getText(), ((Text) r5).getText()) == true) goto L11;
            return false;
        L11:
            return true;
        }

        @Override // androidx.room.parser.Section
        public String getText() {
            return this.text;
        }

        public int hashCode() {
            return getText().hashCode();
        }

        public String toString() {
            return j0.k("Text(text=", getText(), ")");
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ Section(DefaultConstructorMarker r5) {
        this();
    }

    public abstract String getText();

    private Section() {
    }
}
