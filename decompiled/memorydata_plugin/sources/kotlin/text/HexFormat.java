package kotlin.text;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0004\u0011\u0012\u0013\u0014B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lkotlin/text/HexFormat;", "", "upperCase", "", "bytes", "Lkotlin/text/HexFormat$BytesHexFormat;", "number", "Lkotlin/text/HexFormat$NumberHexFormat;", "(ZLkotlin/text/HexFormat$BytesHexFormat;Lkotlin/text/HexFormat$NumberHexFormat;)V", "getBytes", "()Lkotlin/text/HexFormat$BytesHexFormat;", "getNumber", "()Lkotlin/text/HexFormat$NumberHexFormat;", "getUpperCase", "()Z", "toString", "", "Builder", "BytesHexFormat", "Companion", "NumberHexFormat", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        public Builder() {
            this.upperCase = HexFormat.Companion.getDefault().getUpperCase();
        }

        private final void bytes(Function1<? super BytesHexFormat.Builder, Unit> r3) {
            Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "builderAction");
            r4.invoke(getBytes());
        }

        private final void number(Function1<? super NumberHexFormat.Builder, Unit> r3) {
            Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "builderAction");
            r4.invoke(getNumber());
        }

        public final HexFormat build() {
            boolean r1 = this.upperCase;
            BytesHexFormat.Builder r2 = this._bytes;
            if (r2 == null) goto L6;
            BytesHexFormat r3 = r2.build$kotlin_stdlib();
            if (r3 == null) goto L6;
        L7:
            NumberHexFormat.Builder r4 = this._number;
            if (r4 == null) goto L11;
            NumberHexFormat r5 = r4.build$kotlin_stdlib();
            if (r5 == null) goto L11;
        L13:
            return new HexFormat(r1, r3, r5);
        L11:
            r5 = NumberHexFormat.Companion.getDefault$kotlin_stdlib();
        L6:
            r3 = BytesHexFormat.Companion.getDefault$kotlin_stdlib();
            goto L7
        }

        public final BytesHexFormat.Builder getBytes() {
            if (this._bytes != null) goto L5;
            this._bytes = new BytesHexFormat.Builder();
        L5:
            BytesHexFormat.Builder r1 = this._bytes;
            Intrinsics.checkNotNull(r1);
            return r1;
        }

        public final NumberHexFormat.Builder getNumber() {
            if (this._number != null) goto L5;
            this._number = new NumberHexFormat.Builder();
        L5:
            NumberHexFormat.Builder r1 = this._number;
            Intrinsics.checkNotNull(r1);
            return r1;
        }

        public final boolean getUpperCase() {
            return this.upperCase;
        }

        public final void setUpperCase(boolean r1) {
            this.upperCase = r1;
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

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\r\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\b\u001eR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\t¨\u0006\u001f"}, d2 = {"Lkotlin/text/HexFormat$BytesHexFormat$Builder;", "", "()V", EventBody.KEY_VALUE, "", "bytePrefix", "getBytePrefix", "()Ljava/lang/String;", "setBytePrefix", "(Ljava/lang/String;)V", "byteSeparator", "getByteSeparator", "setByteSeparator", "byteSuffix", "getByteSuffix", "setByteSuffix", "", "bytesPerGroup", "getBytesPerGroup", "()I", "setBytesPerGroup", "(I)V", "bytesPerLine", "getBytesPerLine", "setBytesPerLine", "groupSeparator", "getGroupSeparator", "setGroupSeparator", "build", "Lkotlin/text/HexFormat$BytesHexFormat;", "build$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Builder {
            private String bytePrefix;
            private String byteSeparator;
            private String byteSuffix;
            private int bytesPerGroup;
            private int bytesPerLine;
            private String groupSeparator;

            public Builder() {
                this.bytesPerLine = BytesHexFormat.Companion.getDefault$kotlin_stdlib().getBytesPerLine();
                this.bytesPerGroup = BytesHexFormat.Companion.getDefault$kotlin_stdlib().getBytesPerGroup();
                this.groupSeparator = BytesHexFormat.Companion.getDefault$kotlin_stdlib().getGroupSeparator();
                this.byteSeparator = BytesHexFormat.Companion.getDefault$kotlin_stdlib().getByteSeparator();
                this.bytePrefix = BytesHexFormat.Companion.getDefault$kotlin_stdlib().getBytePrefix();
                this.byteSuffix = BytesHexFormat.Companion.getDefault$kotlin_stdlib().getByteSuffix();
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

            public final void setBytePrefix(String r7) {
                Intrinsics.checkNotNullParameter(r7, EventBody.KEY_VALUE);
                if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), '\n', false, 2, null) == true) goto L9;
                if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), '\r', false, 2, null) == true) goto L9;
                this.bytePrefix = r7;
                return;
            L9:
                throw new IllegalArgumentException("LF and CR characters are prohibited in bytePrefix, but was " + r7);
            }

            public final void setByteSeparator(String r7) {
                Intrinsics.checkNotNullParameter(r7, EventBody.KEY_VALUE);
                if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), '\n', false, 2, null) == true) goto L9;
                if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), '\r', false, 2, null) == true) goto L9;
                this.byteSeparator = r7;
                return;
            L9:
                throw new IllegalArgumentException("LF and CR characters are prohibited in byteSeparator, but was " + r7);
            }

            public final void setByteSuffix(String r7) {
                Intrinsics.checkNotNullParameter(r7, EventBody.KEY_VALUE);
                if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), '\n', false, 2, null) == true) goto L9;
                if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), '\r', false, 2, null) == true) goto L9;
                this.byteSuffix = r7;
                return;
            L9:
                throw new IllegalArgumentException("LF and CR characters are prohibited in byteSuffix, but was " + r7);
            }

            public final void setBytesPerGroup(int r3) {
                if (r3 <= 0) goto L6;
                this.bytesPerGroup = r3;
                return;
            L6:
                throw new IllegalArgumentException("Non-positive values are prohibited for bytesPerGroup, but was " + r3);
            }

            public final void setBytesPerLine(int r3) {
                if (r3 <= 0) goto L6;
                this.bytesPerLine = r3;
                return;
            L6:
                throw new IllegalArgumentException("Non-positive values are prohibited for bytesPerLine, but was " + r3);
            }

            public final void setGroupSeparator(String r2) {
                Intrinsics.checkNotNullParameter(r2, "<set-?>");
                this.groupSeparator = r2;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/text/HexFormat$BytesHexFormat$Companion;", "", "()V", "Default", "Lkotlin/text/HexFormat$BytesHexFormat;", "getDefault$kotlin_stdlib", "()Lkotlin/text/HexFormat$BytesHexFormat;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
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

        public BytesHexFormat(int r4, int r5, String r6, String r7, String r8, String r9) {
            Intrinsics.checkNotNullParameter(r6, "groupSeparator");
            Intrinsics.checkNotNullParameter(r7, "byteSeparator");
            Intrinsics.checkNotNullParameter(r8, "bytePrefix");
            Intrinsics.checkNotNullParameter(r9, "byteSuffix");
            this.bytesPerLine = r4;
            this.bytesPerGroup = r5;
            this.groupSeparator = r6;
            this.byteSeparator = r7;
            this.bytePrefix = r8;
            this.byteSuffix = r9;
            boolean r1 = false;
            if (r4 != Integer.MAX_VALUE) goto L6;
            if (r5 != Integer.MAX_VALUE) goto L6;
            boolean r10 = true;
        L7:
            this.noLineAndGroupSeparator = r10;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L10;
            boolean r11 = true;
        L11:
            if (r11 == true) goto L13;
        L20:
            boolean r12 = false;
        L21:
            this.shortByteSeparatorNoPrefixAndSuffix = r12;
            if (HexFormatKt.access$isCaseSensitive(r6) == false) goto L24;
        L29:
            r1 = true;
        L30:
            this.ignoreCase = r1;
            return;
        L24:
            if (HexFormatKt.access$isCaseSensitive(r7) == true) goto L29;
            if (HexFormatKt.access$isCaseSensitive(r8) == true) goto L29;
            if (HexFormatKt.access$isCaseSensitive(r9) == false) goto L30;
        L13:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L15;
            boolean r13 = true;
        L16:
            if (r13 == false) goto L20;
            if (r7.length() > 1) goto L20;
            r12 = true;
            goto L21
        L15:
            r13 = false;
            goto L16
        L10:
            r11 = false;
        L6:
            r10 = false;
            goto L7
        }

        public static final /* synthetic */ BytesHexFormat access$getDefault$cp() {
            return Default;
        }

        public final StringBuilder appendOptionsTo$kotlin_stdlib(StringBuilder r6, String r7) {
            Intrinsics.checkNotNullParameter(r6, "sb");
            Intrinsics.checkNotNullParameter(r7, "indent");
            StringBuilder r0 = r6.append(r7).append("bytesPerLine = ").append(this.bytesPerLine);
            Intrinsics.checkNotNullExpressionValue(r0, "append(...)");
            StringBuilder r1 = r0.append(",");
            Intrinsics.checkNotNullExpressionValue(r1, "append(...)");
            Intrinsics.checkNotNullExpressionValue(r1.append('\n'), "append(...)");
            StringBuilder r2 = r6.append(r7).append("bytesPerGroup = ").append(this.bytesPerGroup);
            Intrinsics.checkNotNullExpressionValue(r2, "append(...)");
            StringBuilder r3 = r2.append(",");
            Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
            Intrinsics.checkNotNullExpressionValue(r3.append('\n'), "append(...)");
            StringBuilder r4 = r6.append(r7).append("groupSeparator = \"").append(this.groupSeparator);
            Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
            StringBuilder r5 = r4.append("\",");
            Intrinsics.checkNotNullExpressionValue(r5, "append(...)");
            Intrinsics.checkNotNullExpressionValue(r5.append('\n'), "append(...)");
            StringBuilder r8 = r6.append(r7).append("byteSeparator = \"").append(this.byteSeparator);
            Intrinsics.checkNotNullExpressionValue(r8, "append(...)");
            StringBuilder r9 = r8.append("\",");
            Intrinsics.checkNotNullExpressionValue(r9, "append(...)");
            Intrinsics.checkNotNullExpressionValue(r9.append('\n'), "append(...)");
            StringBuilder r10 = r6.append(r7).append("bytePrefix = \"").append(this.bytePrefix);
            Intrinsics.checkNotNullExpressionValue(r10, "append(...)");
            StringBuilder r11 = r10.append("\",");
            Intrinsics.checkNotNullExpressionValue(r11, "append(...)");
            Intrinsics.checkNotNullExpressionValue(r11.append('\n'), "append(...)");
            r6.append(r7).append("byteSuffix = \"").append(this.byteSuffix).append("\"");
            return r6;
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
            StringBuilder r0 = new StringBuilder();
            StringBuilder r1 = r0.append("BytesHexFormat(");
            Intrinsics.checkNotNullExpressionValue(r1, "append(...)");
            Intrinsics.checkNotNullExpressionValue(r1.append('\n'), "append(...)");
            Intrinsics.checkNotNullExpressionValue(appendOptionsTo$kotlin_stdlib(r0, "    ").append('\n'), "append(...)");
            r0.append(")");
            String r4 = r0.toString();
            Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
            return r4;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/text/HexFormat$Companion;", "", "()V", "Default", "Lkotlin/text/HexFormat;", "getDefault", "()Lkotlin/text/HexFormat;", "UpperCase", "getUpperCase", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final HexFormat getDefault() {
            return HexFormat.access$getDefault$cp();
        }

        public final HexFormat getUpperCase() {
            return HexFormat.access$getUpperCase$cp();
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

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\r\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0016"}, d2 = {"Lkotlin/text/HexFormat$NumberHexFormat$Builder;", "", "()V", EventBody.KEY_VALUE, "", "prefix", "getPrefix", "()Ljava/lang/String;", "setPrefix", "(Ljava/lang/String;)V", "removeLeadingZeros", "", "getRemoveLeadingZeros", "()Z", "setRemoveLeadingZeros", "(Z)V", "suffix", "getSuffix", "setSuffix", "build", "Lkotlin/text/HexFormat$NumberHexFormat;", "build$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Builder {
            private String prefix;
            private boolean removeLeadingZeros;
            private String suffix;

            public Builder() {
                this.prefix = NumberHexFormat.Companion.getDefault$kotlin_stdlib().getPrefix();
                this.suffix = NumberHexFormat.Companion.getDefault$kotlin_stdlib().getSuffix();
                this.removeLeadingZeros = NumberHexFormat.Companion.getDefault$kotlin_stdlib().getRemoveLeadingZeros();
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

            public final void setPrefix(String r7) {
                Intrinsics.checkNotNullParameter(r7, EventBody.KEY_VALUE);
                if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), '\n', false, 2, null) == true) goto L9;
                if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), '\r', false, 2, null) == true) goto L9;
                this.prefix = r7;
                return;
            L9:
                throw new IllegalArgumentException("LF and CR characters are prohibited in prefix, but was " + r7);
            }

            public final void setRemoveLeadingZeros(boolean r1) {
                this.removeLeadingZeros = r1;
            }

            public final void setSuffix(String r7) {
                Intrinsics.checkNotNullParameter(r7, EventBody.KEY_VALUE);
                if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), '\n', false, 2, null) == true) goto L9;
                if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), '\r', false, 2, null) == true) goto L9;
                this.suffix = r7;
                return;
            L9:
                throw new IllegalArgumentException("LF and CR characters are prohibited in suffix, but was " + r7);
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/text/HexFormat$NumberHexFormat$Companion;", "", "()V", "Default", "Lkotlin/text/HexFormat$NumberHexFormat;", "getDefault$kotlin_stdlib", "()Lkotlin/text/HexFormat$NumberHexFormat;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
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

        public NumberHexFormat(String r4, String r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r4, "prefix");
            Intrinsics.checkNotNullParameter(r5, "suffix");
            this.prefix = r4;
            this.suffix = r5;
            this.removeLeadingZeros = r6;
            boolean r1 = true;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
            boolean r7 = true;
        L6:
            if (r7 == true) goto L8;
        L13:
            boolean r8 = false;
        L14:
            this.isDigitsOnly = r8;
            if (HexFormatKt.access$isCaseSensitive(r4) == false) goto L17;
        L20:
            this.ignoreCase = r1;
            return;
        L17:
            if (HexFormatKt.access$isCaseSensitive(r5) == true) goto L20;
            r1 = false;
            goto L20
        L8:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L10;
            boolean r9 = true;
        L11:
            if (r9 == false) goto L13;
            r8 = true;
            goto L14
        L10:
            r9 = false;
            goto L11
        L5:
            r7 = false;
            goto L6
        }

        public static final /* synthetic */ NumberHexFormat access$getDefault$cp() {
            return Default;
        }

        public final StringBuilder appendOptionsTo$kotlin_stdlib(StringBuilder r6, String r7) {
            Intrinsics.checkNotNullParameter(r6, "sb");
            Intrinsics.checkNotNullParameter(r7, "indent");
            StringBuilder r0 = r6.append(r7).append("prefix = \"").append(this.prefix);
            Intrinsics.checkNotNullExpressionValue(r0, "append(...)");
            StringBuilder r1 = r0.append("\",");
            Intrinsics.checkNotNullExpressionValue(r1, "append(...)");
            Intrinsics.checkNotNullExpressionValue(r1.append('\n'), "append(...)");
            StringBuilder r2 = r6.append(r7).append("suffix = \"").append(this.suffix);
            Intrinsics.checkNotNullExpressionValue(r2, "append(...)");
            StringBuilder r3 = r2.append("\",");
            Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
            Intrinsics.checkNotNullExpressionValue(r3.append('\n'), "append(...)");
            r6.append(r7).append("removeLeadingZeros = ").append(this.removeLeadingZeros);
            return r6;
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
            StringBuilder r0 = new StringBuilder();
            StringBuilder r1 = r0.append("NumberHexFormat(");
            Intrinsics.checkNotNullExpressionValue(r1, "append(...)");
            Intrinsics.checkNotNullExpressionValue(r1.append('\n'), "append(...)");
            Intrinsics.checkNotNullExpressionValue(appendOptionsTo$kotlin_stdlib(r0, "    ").append('\n'), "append(...)");
            r0.append(")");
            String r4 = r0.toString();
            Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
            return r4;
        }
    }

    static {
        Companion = new Companion(null);
        Default = new HexFormat(false, BytesHexFormat.Companion.getDefault$kotlin_stdlib(), NumberHexFormat.Companion.getDefault$kotlin_stdlib());
        UpperCase = new HexFormat(true, BytesHexFormat.Companion.getDefault$kotlin_stdlib(), NumberHexFormat.Companion.getDefault$kotlin_stdlib());
    }

    public HexFormat(boolean r2, BytesHexFormat r3, NumberHexFormat r4) {
        Intrinsics.checkNotNullParameter(r3, "bytes");
        Intrinsics.checkNotNullParameter(r4, "number");
        this.upperCase = r2;
        this.bytes = r3;
        this.number = r4;
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
        StringBuilder r0 = new StringBuilder();
        StringBuilder r1 = r0.append("HexFormat(");
        Intrinsics.checkNotNullExpressionValue(r1, "append(...)");
        Intrinsics.checkNotNullExpressionValue(r1.append('\n'), "append(...)");
        StringBuilder r2 = r0.append("    upperCase = ").append(this.upperCase);
        Intrinsics.checkNotNullExpressionValue(r2, "append(...)");
        StringBuilder r3 = r2.append(",");
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        Intrinsics.checkNotNullExpressionValue(r3.append('\n'), "append(...)");
        StringBuilder r4 = r0.append("    bytes = BytesHexFormat(");
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        Intrinsics.checkNotNullExpressionValue(r4.append('\n'), "append(...)");
        Intrinsics.checkNotNullExpressionValue(this.bytes.appendOptionsTo$kotlin_stdlib(r0, "        ").append('\n'), "append(...)");
        StringBuilder r5 = r0.append("    ),");
        Intrinsics.checkNotNullExpressionValue(r5, "append(...)");
        Intrinsics.checkNotNullExpressionValue(r5.append('\n'), "append(...)");
        StringBuilder r6 = r0.append("    number = NumberHexFormat(");
        Intrinsics.checkNotNullExpressionValue(r6, "append(...)");
        Intrinsics.checkNotNullExpressionValue(r6.append('\n'), "append(...)");
        Intrinsics.checkNotNullExpressionValue(this.number.appendOptionsTo$kotlin_stdlib(r0, "        ").append('\n'), "append(...)");
        StringBuilder r7 = r0.append("    )");
        Intrinsics.checkNotNullExpressionValue(r7, "append(...)");
        Intrinsics.checkNotNullExpressionValue(r7.append('\n'), "append(...)");
        r0.append(")");
        String r8 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r8, "toString(...)");
        return r8;
    }
}
