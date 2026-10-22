package kotlin.text;

import com.bytedance.crash.entity.EventBody;
import kotlin.ExperimentalStdlibApi;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.9")
@ExperimentalStdlibApi
public final class HexFormat {
    public static final Companion Companion = null;
    private static final HexFormat Default = null;
    private static final HexFormat UpperCase = null;
    private final BytesHexFormat bytes;
    private final NumberHexFormat number;
    private final boolean upperCase;

    public static final class Builder {
        private BytesHexFormat.Builder _bytes;
        private NumberHexFormat.Builder _number;
        private boolean upperCase;

        @PublishedApi
        public Builder() {
            this.upperCase = HexFormat.Companion.getDefault().getUpperCase();
        }

        @InlineOnly
        private final void bytes(Function1<? super BytesHexFormat.Builder, Unit> r10) {
            Intrinsics.checkNotNullParameter(r10, "builderAction");
            r10.invoke(getBytes());
        }

        @InlineOnly
        private final void number(Function1<? super NumberHexFormat.Builder, Unit> r10) {
            Intrinsics.checkNotNullParameter(r10, "builderAction");
            r10.invoke(getNumber());
        }

        @PublishedApi
        public final HexFormat build() {
            boolean r10 = this.upperCase;
            BytesHexFormat.Builder r11 = this._bytes;
            if (r11 == null) goto L6;
            BytesHexFormat r12 = r11.build$kotlin_stdlib();
            if (r12 == null) goto L6;
        L7:
            NumberHexFormat.Builder r13 = this._number;
            if (r13 == null) goto L11;
            NumberHexFormat r14 = r13.build$kotlin_stdlib();
            if (r14 == null) goto L11;
        L13:
            return new HexFormat(r10, r12, r14);
        L11:
            r14 = NumberHexFormat.Companion.getDefault$kotlin_stdlib();
        L6:
            r12 = BytesHexFormat.Companion.getDefault$kotlin_stdlib();
            goto L7
        }

        public final BytesHexFormat.Builder getBytes() {
            if (this._bytes != null) goto L5;
            this._bytes = new BytesHexFormat.Builder();
        L5:
            BytesHexFormat.Builder r10 = this._bytes;
            Intrinsics.checkNotNull(r10);
            return r10;
        }

        public final NumberHexFormat.Builder getNumber() {
            if (this._number != null) goto L5;
            this._number = new NumberHexFormat.Builder();
        L5:
            NumberHexFormat.Builder r10 = this._number;
            Intrinsics.checkNotNull(r10);
            return r10;
        }

        public final boolean getUpperCase() {
            return this.upperCase;
        }

        public final void setUpperCase(boolean r10) {
            this.upperCase = r10;
        }
    }

    public static final class BytesHexFormat {
        public static final Companion Companion = null;
        private static final BytesHexFormat Default = null;
        private final String bytePrefix;
        private final String byteSeparator;
        private final String byteSuffix;
        private final int bytesPerGroup;
        private final int bytesPerLine;
        private final String groupSeparator;

        public static final class Builder {
            private String bytePrefix;
            private String byteSeparator;
            private String byteSuffix;
            private int bytesPerGroup;
            private int bytesPerLine;
            private String groupSeparator;

            public Builder() {
                Companion r10 = BytesHexFormat.Companion;
                this.bytesPerLine = r10.getDefault$kotlin_stdlib().getBytesPerLine();
                this.bytesPerGroup = r10.getDefault$kotlin_stdlib().getBytesPerGroup();
                this.groupSeparator = r10.getDefault$kotlin_stdlib().getGroupSeparator();
                this.byteSeparator = r10.getDefault$kotlin_stdlib().getByteSeparator();
                this.bytePrefix = r10.getDefault$kotlin_stdlib().getBytePrefix();
                this.byteSuffix = r10.getDefault$kotlin_stdlib().getByteSuffix();
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

            public final void setBytePrefix(String r10) {
                Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
                if (StringsKt.contains$default(r10, '\n', false, 2, null) == true) goto L9;
                if (StringsKt.contains$default(r10, '\r', false, 2, null) == true) goto L9;
                this.bytePrefix = r10;
                return;
            L9:
                throw new IllegalArgumentException("LF and CR characters are prohibited in bytePrefix, but was " + r10);
            }

            public final void setByteSeparator(String r10) {
                Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
                if (StringsKt.contains$default(r10, '\n', false, 2, null) == true) goto L9;
                if (StringsKt.contains$default(r10, '\r', false, 2, null) == true) goto L9;
                this.byteSeparator = r10;
                return;
            L9:
                throw new IllegalArgumentException("LF and CR characters are prohibited in byteSeparator, but was " + r10);
            }

            public final void setByteSuffix(String r10) {
                Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
                if (StringsKt.contains$default(r10, '\n', false, 2, null) == true) goto L9;
                if (StringsKt.contains$default(r10, '\r', false, 2, null) == true) goto L9;
                this.byteSuffix = r10;
                return;
            L9:
                throw new IllegalArgumentException("LF and CR characters are prohibited in byteSuffix, but was " + r10);
            }

            public final void setBytesPerGroup(int r10) {
                if (r10 <= 0) goto L6;
                this.bytesPerGroup = r10;
                return;
            L6:
                throw new IllegalArgumentException("Non-positive values are prohibited for bytesPerGroup, but was " + r10);
            }

            public final void setBytesPerLine(int r10) {
                if (r10 <= 0) goto L6;
                this.bytesPerLine = r10;
                return;
            L6:
                throw new IllegalArgumentException("Non-positive values are prohibited for bytesPerLine, but was " + r10);
            }

            public final void setGroupSeparator(String r10) {
                Intrinsics.checkNotNullParameter(r10, "<set-?>");
                this.groupSeparator = r10;
            }
        }

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }

            public final BytesHexFormat getDefault$kotlin_stdlib() {
                return BytesHexFormat.access$getDefault$cp();
            }
        }

        static {
            Companion = new Companion(null);
            Default = new BytesHexFormat(Integer.MAX_VALUE, Integer.MAX_VALUE, "  ", "", "", "");
        }

        public BytesHexFormat(int r10, int r11, String r12, String r13, String r14, String r15) {
            Intrinsics.checkNotNullParameter(r12, "groupSeparator");
            Intrinsics.checkNotNullParameter(r13, "byteSeparator");
            Intrinsics.checkNotNullParameter(r14, "bytePrefix");
            Intrinsics.checkNotNullParameter(r15, "byteSuffix");
            this.bytesPerLine = r10;
            this.bytesPerGroup = r11;
            this.groupSeparator = r12;
            this.byteSeparator = r13;
            this.bytePrefix = r14;
            this.byteSuffix = r15;
        }

        public static final /* synthetic */ BytesHexFormat access$getDefault$cp() {
            return Default;
        }

        public final StringBuilder appendOptionsTo$kotlin_stdlib(StringBuilder r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "sb");
            Intrinsics.checkNotNullParameter(r11, "indent");
            r10.append(r11);
            r10.append("bytesPerLine = ");
            r10.append(this.bytesPerLine);
            Intrinsics.checkNotNullExpressionValue(r10, "sb.append(indent).append…= \").append(bytesPerLine)");
            r10.append(",");
            Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
            r10.append('\n');
            Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
            r10.append(r11);
            r10.append("bytesPerGroup = ");
            r10.append(this.bytesPerGroup);
            Intrinsics.checkNotNullExpressionValue(r10, "sb.append(indent).append… \").append(bytesPerGroup)");
            r10.append(",");
            Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
            r10.append('\n');
            Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
            r10.append(r11);
            r10.append("groupSeparator = \"");
            r10.append(this.groupSeparator);
            Intrinsics.checkNotNullExpressionValue(r10, "sb.append(indent).append…\").append(groupSeparator)");
            r10.append("\",");
            Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
            r10.append('\n');
            Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
            r10.append(r11);
            r10.append("byteSeparator = \"");
            r10.append(this.byteSeparator);
            Intrinsics.checkNotNullExpressionValue(r10, "sb.append(indent).append…\"\").append(byteSeparator)");
            r10.append("\",");
            Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
            r10.append('\n');
            Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
            r10.append(r11);
            r10.append("bytePrefix = \"");
            r10.append(this.bytePrefix);
            Intrinsics.checkNotNullExpressionValue(r10, "sb.append(indent).append…= \\\"\").append(bytePrefix)");
            r10.append("\",");
            Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
            r10.append('\n');
            Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
            r10.append(r11);
            r10.append("byteSuffix = \"");
            r10.append(this.byteSuffix);
            r10.append("\"");
            return r10;
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

        public String toString() {
            StringBuilder r10 = new StringBuilder();
            r10.append("BytesHexFormat(");
            Intrinsics.checkNotNullExpressionValue(r10, "append(\"BytesHexFormat(\")");
            r10.append('\n');
            Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
            StringBuilder r11 = appendOptionsTo$kotlin_stdlib(r10, "    ");
            r11.append('\n');
            Intrinsics.checkNotNullExpressionValue(r11, "append('\\n')");
            r10.append(")");
            String r12 = r10.toString();
            Intrinsics.checkNotNullExpressionValue(r12, "StringBuilder().apply(builderAction).toString()");
            return r12;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final HexFormat getDefault() {
            return HexFormat.access$getDefault$cp();
        }

        public final HexFormat getUpperCase() {
            return HexFormat.access$getUpperCase$cp();
        }
    }

    public static final class NumberHexFormat {
        public static final Companion Companion = null;
        private static final NumberHexFormat Default = null;
        private final String prefix;
        private final boolean removeLeadingZeros;
        private final String suffix;

        public static final class Builder {
            private String prefix;
            private boolean removeLeadingZeros;
            private String suffix;

            public Builder() {
                Companion r10 = NumberHexFormat.Companion;
                this.prefix = r10.getDefault$kotlin_stdlib().getPrefix();
                this.suffix = r10.getDefault$kotlin_stdlib().getSuffix();
                this.removeLeadingZeros = r10.getDefault$kotlin_stdlib().getRemoveLeadingZeros();
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

            public final void setPrefix(String r10) {
                Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
                if (StringsKt.contains$default(r10, '\n', false, 2, null) == true) goto L9;
                if (StringsKt.contains$default(r10, '\r', false, 2, null) == true) goto L9;
                this.prefix = r10;
                return;
            L9:
                throw new IllegalArgumentException("LF and CR characters are prohibited in prefix, but was " + r10);
            }

            public final void setRemoveLeadingZeros(boolean r10) {
                this.removeLeadingZeros = r10;
            }

            public final void setSuffix(String r10) {
                Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
                if (StringsKt.contains$default(r10, '\n', false, 2, null) == true) goto L9;
                if (StringsKt.contains$default(r10, '\r', false, 2, null) == true) goto L9;
                this.suffix = r10;
                return;
            L9:
                throw new IllegalArgumentException("LF and CR characters are prohibited in suffix, but was " + r10);
            }
        }

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }

            public final NumberHexFormat getDefault$kotlin_stdlib() {
                return NumberHexFormat.access$getDefault$cp();
            }
        }

        static {
            Companion = new Companion(null);
            Default = new NumberHexFormat("", "", false);
        }

        public NumberHexFormat(String r10, String r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r10, "prefix");
            Intrinsics.checkNotNullParameter(r11, "suffix");
            this.prefix = r10;
            this.suffix = r11;
            this.removeLeadingZeros = r12;
        }

        public static final /* synthetic */ NumberHexFormat access$getDefault$cp() {
            return Default;
        }

        public final StringBuilder appendOptionsTo$kotlin_stdlib(StringBuilder r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "sb");
            Intrinsics.checkNotNullParameter(r11, "indent");
            r10.append(r11);
            r10.append("prefix = \"");
            r10.append(this.prefix);
            Intrinsics.checkNotNullExpressionValue(r10, "sb.append(indent).append…fix = \\\"\").append(prefix)");
            r10.append("\",");
            Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
            r10.append('\n');
            Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
            r10.append(r11);
            r10.append("suffix = \"");
            r10.append(this.suffix);
            Intrinsics.checkNotNullExpressionValue(r10, "sb.append(indent).append…fix = \\\"\").append(suffix)");
            r10.append("\",");
            Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
            r10.append('\n');
            Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
            r10.append(r11);
            r10.append("removeLeadingZeros = ");
            r10.append(this.removeLeadingZeros);
            return r10;
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

        public String toString() {
            StringBuilder r10 = new StringBuilder();
            r10.append("NumberHexFormat(");
            Intrinsics.checkNotNullExpressionValue(r10, "append(\"NumberHexFormat(\")");
            r10.append('\n');
            Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
            StringBuilder r11 = appendOptionsTo$kotlin_stdlib(r10, "    ");
            r11.append('\n');
            Intrinsics.checkNotNullExpressionValue(r11, "append('\\n')");
            r10.append(")");
            String r12 = r10.toString();
            Intrinsics.checkNotNullExpressionValue(r12, "StringBuilder().apply(builderAction).toString()");
            return r12;
        }
    }

    static {
        Companion = new Companion(null);
        BytesHexFormat.Companion r10 = BytesHexFormat.Companion;
        BytesHexFormat r11 = r10.getDefault$kotlin_stdlib();
        NumberHexFormat.Companion r12 = NumberHexFormat.Companion;
        Default = new HexFormat(false, r11, r12.getDefault$kotlin_stdlib());
        UpperCase = new HexFormat(true, r10.getDefault$kotlin_stdlib(), r12.getDefault$kotlin_stdlib());
    }

    public HexFormat(boolean r10, BytesHexFormat r11, NumberHexFormat r12) {
        Intrinsics.checkNotNullParameter(r11, "bytes");
        Intrinsics.checkNotNullParameter(r12, "number");
        this.upperCase = r10;
        this.bytes = r11;
        this.number = r12;
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
        StringBuilder r10 = new StringBuilder();
        r10.append("HexFormat(");
        Intrinsics.checkNotNullExpressionValue(r10, "append(\"HexFormat(\")");
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        r10.append("    upperCase = ");
        r10.append(this.upperCase);
        Intrinsics.checkNotNullExpressionValue(r10, "append(\"    upperCase = \").append(upperCase)");
        r10.append(",");
        Intrinsics.checkNotNullExpressionValue(r10, "append(value)");
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        r10.append("    bytes = BytesHexFormat(");
        Intrinsics.checkNotNullExpressionValue(r10, "append(\"    bytes = BytesHexFormat(\")");
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        StringBuilder r11 = this.bytes.appendOptionsTo$kotlin_stdlib(r10, "        ");
        r11.append('\n');
        Intrinsics.checkNotNullExpressionValue(r11, "append('\\n')");
        r10.append("    ),");
        Intrinsics.checkNotNullExpressionValue(r10, "append(\"    ),\")");
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        r10.append("    number = NumberHexFormat(");
        Intrinsics.checkNotNullExpressionValue(r10, "append(\"    number = NumberHexFormat(\")");
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        StringBuilder r12 = this.number.appendOptionsTo$kotlin_stdlib(r10, "        ");
        r12.append('\n');
        Intrinsics.checkNotNullExpressionValue(r12, "append('\\n')");
        r10.append("    )");
        Intrinsics.checkNotNullExpressionValue(r10, "append(\"    )\")");
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        r10.append(")");
        String r13 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r13, "StringBuilder().apply(builderAction).toString()");
        return r13;
    }
}
