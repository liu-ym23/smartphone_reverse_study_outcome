package kotlin.text;

import ai.j0;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.9")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0004\u0011\u0012\u0013\u0014B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lkotlin/text/HexFormat;", "", "upperCase", "", "bytes", "Lkotlin/text/HexFormat$BytesHexFormat;", "number", "Lkotlin/text/HexFormat$NumberHexFormat;", "(ZLkotlin/text/HexFormat$BytesHexFormat;Lkotlin/text/HexFormat$NumberHexFormat;)V", "getBytes", "()Lkotlin/text/HexFormat$BytesHexFormat;", "getNumber", "()Lkotlin/text/HexFormat$NumberHexFormat;", "getUpperCase", "()Z", "toString", "", "Builder", "BytesHexFormat", "Companion", "NumberHexFormat", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@ExperimentalStdlibApi
public final class HexFormat {
    public static final Companion Companion = null;
    private static final HexFormat Default = null;
    private static final HexFormat UpperCase = null;
    private final BytesHexFormat bytes;
    private final NumberHexFormat number;
    private final boolean upperCase;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0001¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0001J%\u0010\u0007\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0017¢\u0006\u0002\b\u0018H\u0087\bø\u0001\u0000J%\u0010\n\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\u0017¢\u0006\u0002\b\u0018H\u0087\bø\u0001\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0019"}, d2 = {"Lkotlin/text/HexFormat$Builder;", "", "()V", "_bytes", "Lkotlin/text/HexFormat$BytesHexFormat$Builder;", "_number", "Lkotlin/text/HexFormat$NumberHexFormat$Builder;", "bytes", "getBytes", "()Lkotlin/text/HexFormat$BytesHexFormat$Builder;", "number", "getNumber", "()Lkotlin/text/HexFormat$NumberHexFormat$Builder;", "upperCase", "", "getUpperCase", "()Z", "setUpperCase", "(Z)V", "build", "Lkotlin/text/HexFormat;", "", "builderAction", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Builder {
        private BytesHexFormat.Builder _bytes;
        private NumberHexFormat.Builder _number;
        private boolean upperCase;

        @PublishedApi
        public Builder() {
            this.upperCase = HexFormat.Companion.getDefault().getUpperCase();
        }

        @InlineOnly
        private final void bytes(Function1<? super BytesHexFormat.Builder, Unit> r5) {
            Intrinsics.checkNotNullParameter(r5, "builderAction");
            r5.invoke(getBytes());
        }

        @InlineOnly
        private final void number(Function1<? super NumberHexFormat.Builder, Unit> r5) {
            Intrinsics.checkNotNullParameter(r5, "builderAction");
            r5.invoke(getNumber());
        }

        @PublishedApi
        public final HexFormat build() {
            boolean r5 = this.upperCase;
            BytesHexFormat.Builder r10 = this._bytes;
            if (r10 == null) goto L6;
            BytesHexFormat r11 = r10.build$kotlin_stdlib();
            if (r11 == null) goto L6;
        L7:
            NumberHexFormat.Builder r12 = this._number;
            if (r12 == null) goto L11;
            NumberHexFormat r13 = r12.build$kotlin_stdlib();
            if (r13 == null) goto L11;
        L13:
            return new HexFormat(r5, r11, r13);
        L11:
            r13 = NumberHexFormat.Companion.getDefault$kotlin_stdlib();
        L6:
            r11 = BytesHexFormat.Companion.getDefault$kotlin_stdlib();
            goto L7
        }

        public final BytesHexFormat.Builder getBytes() {
            if (this._bytes != null) goto L5;
            this._bytes = new BytesHexFormat.Builder();
        L5:
            BytesHexFormat.Builder r5 = this._bytes;
            Intrinsics.checkNotNull(r5);
            return r5;
        }

        public final NumberHexFormat.Builder getNumber() {
            if (this._number != null) goto L5;
            this._number = new NumberHexFormat.Builder();
        L5:
            NumberHexFormat.Builder r5 = this._number;
            Intrinsics.checkNotNull(r5);
            return r5;
        }

        public final boolean getUpperCase() {
            return this.upperCase;
        }

        public final void setUpperCase(boolean r5) {
            this.upperCase = r5;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0002\"#B7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ%\u0010\u001b\u001a\u00060\u001cj\u0002`\u001d2\n\u0010\u001e\u001a\u00060\u001cj\u0002`\u001d2\u0006\u0010\u001f\u001a\u00020\u0006H\u0000¢\u0006\u0002\b J\b\u0010!\u001a\u00020\u0006H\u0016R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016¨\u0006$"}, d2 = {"Lkotlin/text/HexFormat$BytesHexFormat;", "", "bytesPerLine", "", "bytesPerGroup", "groupSeparator", "", "byteSeparator", "bytePrefix", "byteSuffix", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBytePrefix", "()Ljava/lang/String;", "getByteSeparator", "getByteSuffix", "getBytesPerGroup", "()I", "getBytesPerLine", "getGroupSeparator", "ignoreCase", "", "getIgnoreCase$kotlin_stdlib", "()Z", "noLineAndGroupSeparator", "getNoLineAndGroupSeparator$kotlin_stdlib", "shortByteSeparatorNoPrefixAndSuffix", "getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib", "appendOptionsTo", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "indent", "appendOptionsTo$kotlin_stdlib", "toString", "Builder", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BytesHexFormat {
        public static final Companion Companion = null;
        private static final BytesHexFormat Default = null;
        private final String bytePrefix;
        private final String byteSeparator;
        private final String byteSuffix;
        private final int bytesPerGroup;
        private final int bytesPerLine;
        private final String groupSeparator;
        private final boolean ignoreCase;
        private final boolean noLineAndGroupSeparator;
        private final boolean shortByteSeparatorNoPrefixAndSuffix;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\r\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\b\u001eR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\t¨\u0006\u001f"}, d2 = {"Lkotlin/text/HexFormat$BytesHexFormat$Builder;", "", "()V", "value", "", "bytePrefix", "getBytePrefix", "()Ljava/lang/String;", "setBytePrefix", "(Ljava/lang/String;)V", "byteSeparator", "getByteSeparator", "setByteSeparator", "byteSuffix", "getByteSuffix", "setByteSuffix", "", "bytesPerGroup", "getBytesPerGroup", "()I", "setBytesPerGroup", "(I)V", "bytesPerLine", "getBytesPerLine", "setBytesPerLine", "groupSeparator", "getGroupSeparator", "setGroupSeparator", "build", "Lkotlin/text/HexFormat$BytesHexFormat;", "build$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Builder {
            private String bytePrefix;
            private String byteSeparator;
            private String byteSuffix;
            private int bytesPerGroup;
            private int bytesPerLine;
            private String groupSeparator;

            public Builder() {
                Companion r5 = BytesHexFormat.Companion;
                this.bytesPerLine = r5.getDefault$kotlin_stdlib().getBytesPerLine();
                this.bytesPerGroup = r5.getDefault$kotlin_stdlib().getBytesPerGroup();
                this.groupSeparator = r5.getDefault$kotlin_stdlib().getGroupSeparator();
                this.byteSeparator = r5.getDefault$kotlin_stdlib().getByteSeparator();
                this.bytePrefix = r5.getDefault$kotlin_stdlib().getBytePrefix();
                this.byteSuffix = r5.getDefault$kotlin_stdlib().getByteSuffix();
            }

            public final BytesHexFormat build$kotlin_stdlib() {
                return new BytesHexFormat(this.bytesPerLine, this.bytesPerGroup, this.groupSeparator, this.byteSeparator, this.bytePrefix, this.byteSuffix);
            }

            public final String getBytePrefix() {
                return this.bytePrefix;
            }

            public final String getByteSeparator() {
                return this.byteSeparator;
            }

            public final String getByteSuffix() {
                return this.byteSuffix;
            }

            public final int getBytesPerGroup() {
                return this.bytesPerGroup;
            }

            public final int getBytesPerLine() {
                return this.bytesPerLine;
            }

            public final String getGroupSeparator() {
                return this.groupSeparator;
            }

            public final void setBytePrefix(String r5) {
                Intrinsics.checkNotNullParameter(r5, "value");
                if (StringsKt__StringsKt.contains$default(r5, '\n', false, 2, null) == true) goto L9;
                if (StringsKt__StringsKt.contains$default(r5, '\r', false, 2, null) == true) goto L9;
                this.bytePrefix = r5;
                return;
            L9:
                throw new IllegalArgumentException(j0.C("LF and CR characters are prohibited in bytePrefix, but was ", r5));
            }

            public final void setByteSeparator(String r5) {
                Intrinsics.checkNotNullParameter(r5, "value");
                if (StringsKt__StringsKt.contains$default(r5, '\n', false, 2, null) == true) goto L9;
                if (StringsKt__StringsKt.contains$default(r5, '\r', false, 2, null) == true) goto L9;
                this.byteSeparator = r5;
                return;
            L9:
                throw new IllegalArgumentException(j0.C("LF and CR characters are prohibited in byteSeparator, but was ", r5));
            }

            public final void setByteSuffix(String r5) {
                Intrinsics.checkNotNullParameter(r5, "value");
                if (StringsKt__StringsKt.contains$default(r5, '\n', false, 2, null) == true) goto L9;
                if (StringsKt__StringsKt.contains$default(r5, '\r', false, 2, null) == true) goto L9;
                this.byteSuffix = r5;
                return;
            L9:
                throw new IllegalArgumentException(j0.C("LF and CR characters are prohibited in byteSuffix, but was ", r5));
            }

            public final void setBytesPerGroup(int r5) {
                if (r5 <= 0) goto L6;
                this.bytesPerGroup = r5;
                return;
            L6:
                throw new IllegalArgumentException(j0.g(r5, "Non-positive values are prohibited for bytesPerGroup, but was "));
            }

            public final void setBytesPerLine(int r5) {
                if (r5 <= 0) goto L6;
                this.bytesPerLine = r5;
                return;
            L6:
                throw new IllegalArgumentException(j0.g(r5, "Non-positive values are prohibited for bytesPerLine, but was "));
            }

            public final void setGroupSeparator(String r5) {
                Intrinsics.checkNotNullParameter(r5, "<set-?>");
                this.groupSeparator = r5;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/text/HexFormat$BytesHexFormat$Companion;", "", "()V", "Default", "Lkotlin/text/HexFormat$BytesHexFormat;", "getDefault$kotlin_stdlib", "()Lkotlin/text/HexFormat$BytesHexFormat;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r5) {
                this();
            }

            public final BytesHexFormat getDefault$kotlin_stdlib() {
                return BytesHexFormat.access$getDefault$cp();
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
            Default = new BytesHexFormat(Integer.MAX_VALUE, Integer.MAX_VALUE, "  ", "", "", "");
        }

        public BytesHexFormat(int r5, int r10, String r11, String r12, String r13, String r14) {
            Intrinsics.checkNotNullParameter(r11, "groupSeparator");
            Intrinsics.checkNotNullParameter(r12, "byteSeparator");
            Intrinsics.checkNotNullParameter(r13, "bytePrefix");
            Intrinsics.checkNotNullParameter(r14, "byteSuffix");
            this.bytesPerLine = r5;
            this.bytesPerGroup = r10;
            this.groupSeparator = r11;
            this.byteSeparator = r12;
            this.bytePrefix = r13;
            this.byteSuffix = r14;
            boolean r15 = false;
            if (r5 != Integer.MAX_VALUE) goto L6;
            if (r10 != Integer.MAX_VALUE) goto L6;
            boolean r16 = true;
        L7:
            this.noLineAndGroupSeparator = r16;
            if (r13.length() == 0) goto L10;
        L14:
            boolean r17 = false;
        L15:
            this.shortByteSeparatorNoPrefixAndSuffix = r17;
            if (HexFormatKt.access$isCaseSensitive(r11) == false) goto L18;
        L23:
            r15 = true;
        L24:
            this.ignoreCase = r15;
            return;
        L18:
            if (HexFormatKt.access$isCaseSensitive(r12) == true) goto L23;
            if (HexFormatKt.access$isCaseSensitive(r13) == true) goto L23;
            if (HexFormatKt.access$isCaseSensitive(r14) == false) goto L24;
        L10:
            if (r14.length() != 0) goto L14;
            if (r12.length() > 1) goto L14;
            r17 = true;
        L6:
            r16 = false;
            goto L7
        }

        public static final /* synthetic */ BytesHexFormat access$getDefault$cp() {
            return Default;
        }

        public final StringBuilder appendOptionsTo$kotlin_stdlib(StringBuilder r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "sb");
            Intrinsics.checkNotNullParameter(r10, "indent");
            r5.append(r10);
            r5.append("bytesPerLine = ");
            r5.append(this.bytesPerLine);
            r5.append(",");
            r5.append('\n');
            r5.append(r10);
            r5.append("bytesPerGroup = ");
            r5.append(this.bytesPerGroup);
            r5.append(",");
            r5.append('\n');
            r5.append(r10);
            r5.append("groupSeparator = \"");
            r5.append(this.groupSeparator);
            r5.append("\",");
            r5.append('\n');
            r5.append(r10);
            r5.append("byteSeparator = \"");
            r5.append(this.byteSeparator);
            r5.append("\",");
            r5.append('\n');
            r5.append(r10);
            r5.append("bytePrefix = \"");
            r5.append(this.bytePrefix);
            r5.append("\",");
            r5.append('\n');
            r5.append(r10);
            r5.append("byteSuffix = \"");
            r5.append(this.byteSuffix);
            r5.append("\"");
            return r5;
        }

        public final String getBytePrefix() {
            return this.bytePrefix;
        }

        public final String getByteSeparator() {
            return this.byteSeparator;
        }

        public final String getByteSuffix() {
            return this.byteSuffix;
        }

        public final int getBytesPerGroup() {
            return this.bytesPerGroup;
        }

        public final int getBytesPerLine() {
            return this.bytesPerLine;
        }

        public final String getGroupSeparator() {
            return this.groupSeparator;
        }

        public final boolean getIgnoreCase$kotlin_stdlib() {
            return this.ignoreCase;
        }

        public final boolean getNoLineAndGroupSeparator$kotlin_stdlib() {
            return this.noLineAndGroupSeparator;
        }

        public final boolean getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib() {
            return this.shortByteSeparatorNoPrefixAndSuffix;
        }

        public String toString() {
            StringBuilder r5 = j0.u("BytesHexFormat(\n");
            appendOptionsTo$kotlin_stdlib(r5, "    ").append('\n');
            r5.append(")");
            return r5.toString();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/text/HexFormat$Companion;", "", "()V", "Default", "Lkotlin/text/HexFormat;", "getDefault", "()Lkotlin/text/HexFormat;", "UpperCase", "getUpperCase", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final HexFormat getDefault() {
            return HexFormat.access$getDefault$cp();
        }

        public final HexFormat getUpperCase() {
            return HexFormat.access$getUpperCase$cp();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010\u0011\u001a\u00060\u0012j\u0002`\u00132\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u00132\u0006\u0010\u0015\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u0014\u0010\b\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001a"}, d2 = {"Lkotlin/text/HexFormat$NumberHexFormat;", "", "prefix", "", "suffix", "removeLeadingZeros", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "ignoreCase", "getIgnoreCase$kotlin_stdlib", "()Z", "isDigitsOnly", "isDigitsOnly$kotlin_stdlib", "getPrefix", "()Ljava/lang/String;", "getRemoveLeadingZeros", "getSuffix", "appendOptionsTo", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "indent", "appendOptionsTo$kotlin_stdlib", "toString", "Builder", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class NumberHexFormat {
        public static final Companion Companion = null;
        private static final NumberHexFormat Default = null;
        private final boolean ignoreCase;
        private final boolean isDigitsOnly;
        private final String prefix;
        private final boolean removeLeadingZeros;
        private final String suffix;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\r\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0016"}, d2 = {"Lkotlin/text/HexFormat$NumberHexFormat$Builder;", "", "()V", "value", "", "prefix", "getPrefix", "()Ljava/lang/String;", "setPrefix", "(Ljava/lang/String;)V", "removeLeadingZeros", "", "getRemoveLeadingZeros", "()Z", "setRemoveLeadingZeros", "(Z)V", "suffix", "getSuffix", "setSuffix", "build", "Lkotlin/text/HexFormat$NumberHexFormat;", "build$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Builder {
            private String prefix;
            private boolean removeLeadingZeros;
            private String suffix;

            public Builder() {
                Companion r5 = NumberHexFormat.Companion;
                this.prefix = r5.getDefault$kotlin_stdlib().getPrefix();
                this.suffix = r5.getDefault$kotlin_stdlib().getSuffix();
                this.removeLeadingZeros = r5.getDefault$kotlin_stdlib().getRemoveLeadingZeros();
            }

            public final NumberHexFormat build$kotlin_stdlib() {
                return new NumberHexFormat(this.prefix, this.suffix, this.removeLeadingZeros);
            }

            public final String getPrefix() {
                return this.prefix;
            }

            public final boolean getRemoveLeadingZeros() {
                return this.removeLeadingZeros;
            }

            public final String getSuffix() {
                return this.suffix;
            }

            public final void setPrefix(String r5) {
                Intrinsics.checkNotNullParameter(r5, "value");
                if (StringsKt__StringsKt.contains$default(r5, '\n', false, 2, null) == true) goto L9;
                if (StringsKt__StringsKt.contains$default(r5, '\r', false, 2, null) == true) goto L9;
                this.prefix = r5;
                return;
            L9:
                throw new IllegalArgumentException(j0.C("LF and CR characters are prohibited in prefix, but was ", r5));
            }

            public final void setRemoveLeadingZeros(boolean r5) {
                this.removeLeadingZeros = r5;
            }

            public final void setSuffix(String r5) {
                Intrinsics.checkNotNullParameter(r5, "value");
                if (StringsKt__StringsKt.contains$default(r5, '\n', false, 2, null) == true) goto L9;
                if (StringsKt__StringsKt.contains$default(r5, '\r', false, 2, null) == true) goto L9;
                this.suffix = r5;
                return;
            L9:
                throw new IllegalArgumentException(j0.C("LF and CR characters are prohibited in suffix, but was ", r5));
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/text/HexFormat$NumberHexFormat$Companion;", "", "()V", "Default", "Lkotlin/text/HexFormat$NumberHexFormat;", "getDefault$kotlin_stdlib", "()Lkotlin/text/HexFormat$NumberHexFormat;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r5) {
                this();
            }

            public final NumberHexFormat getDefault$kotlin_stdlib() {
                return NumberHexFormat.access$getDefault$cp();
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
            Default = new NumberHexFormat("", "", false);
        }

        public NumberHexFormat(String r5, String r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r5, "prefix");
            Intrinsics.checkNotNullParameter(r10, "suffix");
            this.prefix = r5;
            this.suffix = r10;
            this.removeLeadingZeros = r11;
            boolean r12 = false;
            if (r5.length() == 0) goto L5;
        L7:
            boolean r13 = false;
        L8:
            this.isDigitsOnly = r13;
            if (HexFormatKt.access$isCaseSensitive(r5) == false) goto L11;
        L12:
            r12 = true;
        L13:
            this.ignoreCase = r12;
            return;
        L11:
            if (HexFormatKt.access$isCaseSensitive(r10) == false) goto L13;
        L5:
            if (r10.length() != 0) goto L7;
            r13 = true;
            goto L8
        }

        public static final /* synthetic */ NumberHexFormat access$getDefault$cp() {
            return Default;
        }

        public final StringBuilder appendOptionsTo$kotlin_stdlib(StringBuilder r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "sb");
            Intrinsics.checkNotNullParameter(r10, "indent");
            r5.append(r10);
            r5.append("prefix = \"");
            r5.append(this.prefix);
            r5.append("\",");
            r5.append('\n');
            r5.append(r10);
            r5.append("suffix = \"");
            r5.append(this.suffix);
            r5.append("\",");
            r5.append('\n');
            r5.append(r10);
            r5.append("removeLeadingZeros = ");
            r5.append(this.removeLeadingZeros);
            return r5;
        }

        public final boolean getIgnoreCase$kotlin_stdlib() {
            return this.ignoreCase;
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final boolean getRemoveLeadingZeros() {
            return this.removeLeadingZeros;
        }

        public final String getSuffix() {
            return this.suffix;
        }

        public final boolean isDigitsOnly$kotlin_stdlib() {
            return this.isDigitsOnly;
        }

        public String toString() {
            StringBuilder r5 = j0.u("NumberHexFormat(\n");
            appendOptionsTo$kotlin_stdlib(r5, "    ").append('\n');
            r5.append(")");
            return r5.toString();
        }
    }

    static {
        Companion = new Companion(null);
        BytesHexFormat.Companion r5 = BytesHexFormat.Companion;
        BytesHexFormat r10 = r5.getDefault$kotlin_stdlib();
        NumberHexFormat.Companion r11 = NumberHexFormat.Companion;
        Default = new HexFormat(false, r10, r11.getDefault$kotlin_stdlib());
        UpperCase = new HexFormat(true, r5.getDefault$kotlin_stdlib(), r11.getDefault$kotlin_stdlib());
    }

    public HexFormat(boolean r5, BytesHexFormat r10, NumberHexFormat r11) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        Intrinsics.checkNotNullParameter(r11, "number");
        this.upperCase = r5;
        this.bytes = r10;
        this.number = r11;
    }

    public static final /* synthetic */ HexFormat access$getDefault$cp() {
        return Default;
    }

    public static final /* synthetic */ HexFormat access$getUpperCase$cp() {
        return UpperCase;
    }

    public final BytesHexFormat getBytes() {
        return this.bytes;
    }

    public final NumberHexFormat getNumber() {
        return this.number;
    }

    public final boolean getUpperCase() {
        return this.upperCase;
    }

    public String toString() {
        StringBuilder r5 = j0.u("HexFormat(\n    upperCase = ");
        r5.append(this.upperCase);
        r5.append(",\n    bytes = BytesHexFormat(\n");
        this.bytes.appendOptionsTo$kotlin_stdlib(r5, "        ").append('\n');
        r5.append("    ),");
        r5.append('\n');
        r5.append("    number = NumberHexFormat(");
        r5.append('\n');
        this.number.appendOptionsTo$kotlin_stdlib(r5, "        ").append('\n');
        r5.append("    )");
        r5.append('\n');
        r5.append(")");
        return r5.toString();
    }
}
