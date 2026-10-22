package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class LookupUtils {
    private static Map<Integer, MatchMode> matchModeMap;
    private static Map<Integer, SearchMode> searchModeMap;

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.functions.LookupUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$formula$functions$LookupUtils$MatchMode = null;

        static {
            int[] r0 = new int[MatchMode.values().length];
            $SwitchMap$org$apache$poi$ss$formula$functions$LookupUtils$MatchMode = r0;
            r0[MatchMode.ExactMatchFallbackToLargerValue.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$org$apache$poi$ss$formula$functions$LookupUtils$MatchMode[MatchMode.ExactMatchFallbackToSmallerValue.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private static final class BinarySearchIndexes {
        private int _highIx;
        private int _lowIx;

        public BinarySearchIndexes(int r2) {
            this._lowIx = -1;
            this._highIx = r2;
        }

        public int getHighIx() {
            return this._highIx;
        }

        public int getLowIx() {
            return this._lowIx;
        }

        public int getMidIx() {
            int r0 = this._highIx;
            int r2 = this._lowIx;
            int r1 = r0 - r2;
            if (r1 >= 2) goto L7;
            return -1;
        L7:
            return r2 + (r1 / 2);
        }

        public void narrowSearch(int r1, boolean r2) {
            if (r2 == false) goto L4;
            this._highIx = r1;
            return;
        L4:
            this._lowIx = r1;
        }
    }

    private static final class BooleanLookupComparer extends LookupValueComparerBase {
        private final boolean _value;

        public BooleanLookupComparer(BoolEval r1) {
            super(r1);
            this._value = r1.getBooleanValue();
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.LookupValueComparerBase
        public CompareResult compareSameType(ValueEval r3) {
            boolean r4 = ((BoolEval) ZeusTransformUtils.preCheckCast((ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin"), BoolEval.class, "com.obric.memorydata.plugin")).getBooleanValue();
            boolean r2 = this._value;
            if (r2 == r4) goto L5;
            if (r2 == false) goto L10;
            return CompareResult.GREATER_THAN;
        L10:
            return CompareResult.LESS_THAN;
        L5:
            return CompareResult.EQUAL;
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.LookupValueComparerBase
        public String getValueAsString() {
            return String.valueOf(this._value);
        }
    }

    private static final class ColumnVector implements ValueVector {
        private final int _columnIndex;
        private final int _size;
        private final TwoDEval _tableArray;

        public ColumnVector(TwoDEval r3, int r4) {
            TwoDEval r5 = (TwoDEval) ZeusTransformUtils.wrapperContextForParams(r3, TwoDEval.class, "com.obric.memorydata.plugin");
            this._columnIndex = r4;
            int r0 = r5.getWidth() - 1;
            if (r4 < 0) goto L8;
            if (r4 > r0) goto L8;
            this._tableArray = r5;
            this._size = r5.getHeight();
            return;
        L8:
            throw new IllegalArgumentException("Specified column index (" + r4 + ") is outside the allowed range (0.." + r0 + ")");
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public ValueEval getItem(int r4) {
            if (r4 > this._size) goto L7;
            return this._tableArray.getValue(r4, this._columnIndex);
        L7:
            throw new ArrayIndexOutOfBoundsException("Specified index (" + r4 + ") is outside the allowed range (0.." + (this._size - 1) + ")");
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public int getSize() {
            return this._size;
        }
    }

    public static final class CompareResult {
        public static final CompareResult EQUAL = null;
        public static final CompareResult GREATER_THAN = null;
        public static final CompareResult LESS_THAN = null;
        public static final CompareResult TYPE_MISMATCH = null;
        private final boolean _isEqual;
        private final boolean _isGreaterThan;
        private final boolean _isLessThan;
        private final boolean _isTypeMismatch;

        static {
            TYPE_MISMATCH = new CompareResult(true, 0);
            LESS_THAN = new CompareResult(false, -1);
            EQUAL = new CompareResult(false, 0);
            GREATER_THAN = new CompareResult(false, 1);
        }

        private CompareResult(boolean r3, int r4) {
            boolean r0 = true;
            if (r3 == false) goto L5;
            this._isTypeMismatch = true;
            this._isLessThan = false;
            this._isEqual = false;
            this._isGreaterThan = false;
            return;
        L5:
            this._isTypeMismatch = false;
            if (r4 >= 0) goto L8;
            boolean r5 = true;
        L9:
            this._isLessThan = r5;
            if (r4 != 0) goto L12;
            boolean r6 = true;
        L13:
            this._isEqual = r6;
            if (r4 > 0) goto L17;
            r0 = false;
        L17:
            this._isGreaterThan = r0;
            return;
        L12:
            r6 = false;
            goto L13
        L8:
            r5 = false;
            goto L9
        }

        private String formatAsString() {
            if (this._isTypeMismatch == false) goto L7;
            return "TYPE_MISMATCH";
        L7:
            if (this._isLessThan == false) goto L11;
            return "LESS_THAN";
        L11:
            if (this._isEqual == false) goto L15;
            return "EQUAL";
        L15:
            if (this._isGreaterThan == false) goto L18;
            return "GREATER_THAN";
        L18:
            return "??error??";
        }

        public static CompareResult valueOf(int r0) {
            if (r0 < 0) goto L4;
            if (r0 <= 0) goto L9;
            return GREATER_THAN;
        L9:
            return EQUAL;
        L4:
            return LESS_THAN;
        }

        public static CompareResult valueOf(boolean r0) {
            if (r0 == false) goto L6;
            return EQUAL;
        L6:
            return LESS_THAN;
        }

        public boolean isEqual() {
            return this._isEqual;
        }

        public boolean isGreaterThan() {
            return this._isGreaterThan;
        }

        public boolean isLessThan() {
            return this._isLessThan;
        }

        public boolean isTypeMismatch() {
            return this._isTypeMismatch;
        }

        public String toString() {
            return getClass().getName() + " [" + formatAsString() + "]";
        }
    }

    public interface LookupValueComparer {
        CompareResult compareTo(ValueEval r1);
    }

    private static abstract class LookupValueComparerBase implements LookupValueComparer {
        private final Class<? extends ValueEval> _targetClass;

        public LookupValueComparerBase(ValueEval r3) {
            ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L7;
            this._targetClass = r4.getClass();
            return;
        L7:
            throw new RuntimeException("targetValue cannot be null");
        }

        public abstract CompareResult compareSameType(ValueEval r1);

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.LookupValueComparer
        public final CompareResult compareTo(ValueEval r3) {
            ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L11;
            if (this._targetClass == r4.getClass()) goto L9;
            return CompareResult.TYPE_MISMATCH;
        L9:
            return compareSameType(r4);
        L11:
            throw new RuntimeException("compare to value cannot be null");
        }

        public abstract String getValueAsString();

        public String toString() {
            return getClass().getName() + " [" + getValueAsString() + "]";
        }
    }

    public static final enum MatchMode extends Enum<MatchMode> {
        private static final /* synthetic */ MatchMode[] $VALUES = null;
        public static final MatchMode ExactMatch = null;
        public static final MatchMode ExactMatchFallbackToLargerValue = null;
        public static final MatchMode ExactMatchFallbackToSmallerValue = null;
        public static final MatchMode WildcardMatch = null;
        private final int intValue;

        static {
            MatchMode r0 = new MatchMode("ExactMatch", 0, 0);
            ExactMatch = r0;
            MatchMode r1 = new MatchMode("ExactMatchFallbackToSmallerValue", 1, -1);
            ExactMatchFallbackToSmallerValue = r1;
            MatchMode r3 = new MatchMode("ExactMatchFallbackToLargerValue", 2, 1);
            ExactMatchFallbackToLargerValue = r3;
            MatchMode r5 = new MatchMode("WildcardMatch", 3, 2);
            WildcardMatch = r5;
            $VALUES = new MatchMode[]{r0, r1, r3, r5};
        }

        private MatchMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.intValue = r3;
        }

        public static MatchMode valueOf(String r2) {
            return (MatchMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(MatchMode.class, r2), MatchMode.class, "com.obric.memorydata.plugin");
        }

        public static MatchMode[] values() {
            return (MatchMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MatchMode[].class, "com.obric.memorydata.plugin");
        }

        public int getIntValue() {
            return this.intValue;
        }
    }

    private static final class NumberLookupComparer extends LookupValueComparerBase {
        private final double _value;

        public NumberLookupComparer(NumberEval r3) {
            super(r3);
            this._value = r3.getNumberValue();
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.LookupValueComparerBase
        public CompareResult compareSameType(ValueEval r3) {
            NumberEval r4 = (NumberEval) ZeusTransformUtils.preCheckCast((ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin"), NumberEval.class, "com.obric.memorydata.plugin");
            return CompareResult.valueOf(Double.compare(this._value, r4.getNumberValue()));
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.LookupValueComparerBase
        public String getValueAsString() {
            return String.valueOf(this._value);
        }
    }

    private static final class RowVector implements ValueVector {
        private final int _rowIndex;
        private final int _size;
        private final TwoDEval _tableArray;

        public RowVector(TwoDEval r3, int r4) {
            TwoDEval r5 = (TwoDEval) ZeusTransformUtils.wrapperContextForParams(r3, TwoDEval.class, "com.obric.memorydata.plugin");
            this._rowIndex = r4;
            int r0 = r5.getHeight() - 1;
            if (r4 < 0) goto L8;
            if (r4 > r0) goto L8;
            this._tableArray = r5;
            this._size = r5.getWidth();
            return;
        L8:
            throw new IllegalArgumentException("Specified row index (" + r4 + ") is outside the allowed range (0.." + r0 + ")");
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public ValueEval getItem(int r4) {
            if (r4 > this._size) goto L7;
            return this._tableArray.getValue(this._rowIndex, r4);
        L7:
            throw new ArrayIndexOutOfBoundsException("Specified index (" + r4 + ") is outside the allowed range (0.." + (this._size - 1) + ")");
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public int getSize() {
            return this._size;
        }
    }

    public static final enum SearchMode extends Enum<SearchMode> {
        private static final /* synthetic */ SearchMode[] $VALUES = null;
        public static final SearchMode BinarySearchBackward = null;
        public static final SearchMode BinarySearchForward = null;
        public static final SearchMode IterateBackward = null;
        public static final SearchMode IterateForward = null;
        private final int intValue;

        static {
            SearchMode r0 = new SearchMode("IterateForward", 0, 1);
            IterateForward = r0;
            SearchMode r1 = new SearchMode("IterateBackward", 1, -1);
            IterateBackward = r1;
            SearchMode r4 = new SearchMode("BinarySearchForward", 2, 2);
            BinarySearchForward = r4;
            SearchMode r5 = new SearchMode("BinarySearchBackward", 3, -2);
            BinarySearchBackward = r5;
            $VALUES = new SearchMode[]{r0, r1, r4, r5};
        }

        private SearchMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.intValue = r3;
        }

        public static SearchMode valueOf(String r2) {
            return (SearchMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(SearchMode.class, r2), SearchMode.class, "com.obric.memorydata.plugin");
        }

        public static SearchMode[] values() {
            return (SearchMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SearchMode[].class, "com.obric.memorydata.plugin");
        }

        public int getIntValue() {
            return this.intValue;
        }
    }

    private static final class SheetVector implements ValueVector {
        private final RefEval _re;
        private final int _size;

        public SheetVector(RefEval r3) {
            RefEval r4 = (RefEval) ZeusTransformUtils.wrapperContextForParams(r3, RefEval.class, "com.obric.memorydata.plugin");
            this._size = r4.getNumberOfSheets();
            this._re = r4;
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public ValueEval getItem(int r4) {
            if (r4 >= this._size) goto L7;
            return this._re.getInnerValueEval(this._re.getFirstSheetIndex() + r4);
        L7:
            throw new ArrayIndexOutOfBoundsException("Specified index (" + r4 + ") is outside the allowed range (0.." + (this._size - 1) + ")");
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public int getSize() {
            return this._size;
        }
    }

    private static class StringLookupComparer extends LookupValueComparerBase {
        protected final boolean _isMatchFunction;
        protected final boolean _matchExact;
        protected final String _value;
        protected final Pattern _wildCardPattern;

        public StringLookupComparer(StringEval r1, boolean r2, boolean r3) {
            super(r1);
            String r4 = r1.getStringValue();
            this._value = r4;
            this._wildCardPattern = Countif.StringMatcher.getWildCardPattern(r4);
            this._matchExact = r2;
            this._isMatchFunction = r3;
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.LookupValueComparerBase
        public CompareResult compareSameType(ValueEval r3) {
            String r4 = convertToString((ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin"));
            Pattern r0 = this._wildCardPattern;
            if (r0 == null) goto L11;
            if (this._isMatchFunction == true) goto L9;
            if (this._matchExact == true) goto L11;
        L9:
            return CompareResult.valueOf(r0.matcher(r4).matches());
        L11:
            return CompareResult.valueOf(this._value.compareToIgnoreCase(r4));
        }

        public String convertToString(ValueEval r2) {
            return ((StringEval) ZeusTransformUtils.preCheckCast((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), StringEval.class, "com.obric.memorydata.plugin")).getStringValue();
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.LookupValueComparerBase
        public String getValueAsString() {
            return this._value;
        }
    }

    private static final class TolerantStringLookupComparer extends StringLookupComparer {
        public TolerantStringLookupComparer(ValueEval r3, boolean r4, boolean r5) {
            super(convertToStringEval((ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin")), r4, r5);
        }

        static StringEval convertToStringEval(ValueEval r2) {
            ValueEval r3 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r3, StringEval.class) == false) goto L7;
            return (StringEval) ZeusTransformUtils.preCheckCast(r3, StringEval.class, "com.obric.memorydata.plugin");
        L7:
            return new StringEval(OperandResolver.coerceValueToString(r3));
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.StringLookupComparer
        public String convertToString(ValueEval r2) {
            return OperandResolver.coerceValueToString((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"));
        }
    }

    public interface ValueVector {
        ValueEval getItem(int r1);

        int getSize();

        default Iterator<Integer> indexIterator() {
            return new AnonymousClass1(this);
        }

        default Iterator<Integer> reverseIndexIterator() {
            return new AnonymousClass2(this);
        }
    }

    static {
        matchModeMap = new HashMap();
        searchModeMap = new HashMap();
        MatchMode[] r0 = MatchMode.values();
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        MatchMode r4 = r0[r3];
        matchModeMap.put(Integer.valueOf(r4.getIntValue()), r4);
        r3 = r3 + 1;
        goto L3
    L5:
        SearchMode[] r5 = SearchMode.values();
        int r6 = r5.length;
    L6:
        if (r2 >= r6) goto L8;
        SearchMode r7 = r5[r2];
        searchModeMap.put(Integer.valueOf(r7.getIntValue()), r7);
        r2 = r2 + 1;
        goto L6
    }

    private static int binarySearchIndexOfValue(LookupValueComparer r10, ValueVector r11, MatchMode r12, boolean r13) {
        LookupValueComparer r14 = (LookupValueComparer) ZeusTransformUtils.wrapperContextForParams(r10, LookupValueComparer.class, "com.obric.memorydata.plugin");
        ValueVector r15 = (ValueVector) ZeusTransformUtils.wrapperContextForParams(r11, ValueVector.class, "com.obric.memorydata.plugin");
        HashSet r0 = new HashSet();
        BinarySearchIndexes r1 = new BinarySearchIndexes(r15.getSize());
        int r2 = -1;
        ValueEval r3 = null;
    L3:
        int r4 = r1.getMidIx();
        if (r4 < 0) goto L39;
        if (r0.contains(Integer.valueOf(r4)) == true) goto L39;
        r0.add(Integer.valueOf(r4));
        ValueEval r5 = r15.getItem(r4);
        CompareResult r6 = r14.compareTo(r5);
        if (r6.isEqual() == true) goto L10;
        int r7 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$formula$functions$LookupUtils$MatchMode[r12.ordinal()];
        if (r7 == 1) goto L24;
        if (r7 != 2) goto L31;
        if (r6.isGreaterThan() == false) goto L31;
        if (r3 != null) goto L21;
    L26:
        r2 = r4;
        r3 = r5;
        goto L31
    L21:
        if (createTolerantLookupComparer(r5, true, true).compareTo(r3).isGreaterThan() == true) goto L26;
    L31:
        if (r6.isTypeMismatch() == true) goto L32;
        if (r13 == false) goto L37;
        boolean r8 = r6.isGreaterThan();
    L38:
        r1.narrowSearch(r4, r8);
        goto L3
    L37:
        r8 = r6.isLessThan();
        goto L38
    L32:
        int r9 = handleMidValueTypeMismatch(r14, r15, r1, r4, r13);
        if (r9 < 0) goto L3;
        return r9;
    L24:
        if (r6.isLessThan() == false) goto L31;
        if (r3 == null) goto L26;
        if (createTolerantLookupComparer(r5, true, true).compareTo(r3).isLessThan() == false) goto L31;
    L10:
        return r4;
    L39:
        return r2;
    }

    public static ValueVector createColumnVector(TwoDEval r2, int r3) {
        return new ColumnVector((TwoDEval) ZeusTransformUtils.wrapperContextForParams(r2, TwoDEval.class, "com.obric.memorydata.plugin"), r3);
    }

    static LookupValueComparer createLookupComparer(ValueEval r3, boolean r4, boolean r5) {
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        if (r6 != BlankEval.instance) goto L7;
        return new NumberLookupComparer(NumberEval.ZERO);
    L7:
        if (ZeusTransformUtils.instanceOf(r6, StringEval.class) == false) goto L11;
        return new StringLookupComparer((StringEval) ZeusTransformUtils.preCheckCast(r6, StringEval.class, "com.obric.memorydata.plugin"), r4, r5);
    L11:
        if (ZeusTransformUtils.instanceOf(r6, NumberEval.class) == false) goto L15;
        return new NumberLookupComparer((NumberEval) ZeusTransformUtils.preCheckCast(r6, NumberEval.class, "com.obric.memorydata.plugin"));
    L15:
        if (ZeusTransformUtils.instanceOf(r6, BoolEval.class) == false) goto L19;
        return new BooleanLookupComparer((BoolEval) ZeusTransformUtils.preCheckCast(r6, BoolEval.class, "com.obric.memorydata.plugin"));
    L19:
        throw new IllegalArgumentException("Bad lookup value type (" + r6.getClass().getName() + ")");
    }

    public static ValueVector createRowVector(TwoDEval r2, int r3) {
        return new RowVector((TwoDEval) ZeusTransformUtils.wrapperContextForParams(r2, TwoDEval.class, "com.obric.memorydata.plugin"), r3);
    }

    private static LookupValueComparer createTolerantLookupComparer(ValueEval r2, boolean r3, boolean r4) {
        ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
        if (r5 != BlankEval.instance) goto L7;
        return new TolerantStringLookupComparer(new StringEval(""), r3, r4);
    L7:
        if (ZeusTransformUtils.instanceOf(r5, BoolEval.class) == true) goto L9;
        if (r3 == false) goto L16;
        if (ZeusTransformUtils.instanceOf(r5, NumberEval.class) == false) goto L16;
        return new NumberLookupComparer((NumberEval) ZeusTransformUtils.preCheckCast(r5, NumberEval.class, "com.obric.memorydata.plugin"));
    L16:
        return new TolerantStringLookupComparer(r5, r3, r4);
    L9:
        return new BooleanLookupComparer((BoolEval) ZeusTransformUtils.preCheckCast(r5, BoolEval.class, "com.obric.memorydata.plugin"));
    }

    public static ValueVector createVector(TwoDEval r2) {
        TwoDEval r3 = (TwoDEval) ZeusTransformUtils.wrapperContextForParams(r2, TwoDEval.class, "com.obric.memorydata.plugin");
        if (r3.isColumn() == false) goto L7;
        return createColumnVector(r3, 0);
    L7:
        if (r3.isRow() == true) goto L9;
        return null;
    L9:
        return createRowVector(r3, 0);
    }

    public static ValueVector createVector(RefEval r2) {
        return new SheetVector((RefEval) ZeusTransformUtils.wrapperContextForParams(r2, RefEval.class, "com.obric.memorydata.plugin"));
    }

    private static int findLastIndexInRunOfEqualValues(LookupValueComparer r2, ValueVector r3, int r4, int r5) {
        LookupValueComparer r6 = (LookupValueComparer) ZeusTransformUtils.wrapperContextForParams(r2, LookupValueComparer.class, "com.obric.memorydata.plugin");
        ValueVector r7 = (ValueVector) ZeusTransformUtils.wrapperContextForParams(r3, ValueVector.class, "com.obric.memorydata.plugin");
    L3:
        r4 = r4 + 1;
        if (r4 >= r5) goto L10;
        if (r6.compareTo(r7.getItem(r4)).isEqual() == true) goto L3;
        return r4 - 1;
    L10:
        return r5 - 1;
    }

    private static int handleMidValueTypeMismatch(LookupValueComparer r6, ValueVector r7, BinarySearchIndexes r8, int r9, boolean r10) {
        LookupValueComparer r11 = (LookupValueComparer) ZeusTransformUtils.wrapperContextForParams(r6, LookupValueComparer.class, "com.obric.memorydata.plugin");
        ValueVector r12 = (ValueVector) ZeusTransformUtils.wrapperContextForParams(r7, ValueVector.class, "com.obric.memorydata.plugin");
        int r0 = r8.getHighIx();
        int r1 = r9;
    L3:
        r1 = r1 + 1;
        if (r1 == r0) goto L5;
        CompareResult r4 = r11.compareTo(r12.getItem(r1));
        if (r4.isLessThan() == false) goto L15;
        if (r10 == true) goto L15;
        if (r1 != (r0 - 1)) goto L15;
        r8.narrowSearch(r9, true);
        return -1;
    L15:
        if (r4.isGreaterThan() == false) goto L22;
        if (r10 == false) goto L22;
        if (r1 != (r0 - 1)) goto L22;
        r8.narrowSearch(r9, true);
        return -1;
    L22:
        if (r4.isTypeMismatch() == true) goto L3;
        if (r4.isEqual() == false) goto L27;
        return r1;
    L27:
        if (r10 == false) goto L29;
        boolean r13 = r4.isGreaterThan();
    L30:
        r8.narrowSearch(r1, r13);
        return -1;
    L29:
        r13 = r4.isLessThan();
        goto L30
    L5:
        r8.narrowSearch(r9, true);
        return -1;
    }

    public static int lookupFirstIndexOfValue(ValueEval r2, ValueVector r3, boolean r4) {
        ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
        ValueVector r6 = (ValueVector) ZeusTransformUtils.wrapperContextForParams(r3, ValueVector.class, "com.obric.memorydata.plugin");
        LookupValueComparer r7 = createLookupComparer(r5, r4, false);
        if (r4 == false) goto L5;
        int r8 = performBinarySearch(r6, r7);
    L6:
        if (r8 < 0) goto L9;
        return r8;
    L9:
        throw new EvaluationException(ErrorEval.NA);
    L5:
        r8 = lookupFirstIndexOfValue(r7, r6, MatchMode.ExactMatch);
        goto L6
    }

    private static int lookupFirstIndexOfValue(LookupValueComparer r2, ValueVector r3, MatchMode r4) {
        return lookupIndexOfValue((LookupValueComparer) ZeusTransformUtils.wrapperContextForParams(r2, LookupValueComparer.class, "com.obric.memorydata.plugin"), (ValueVector) ZeusTransformUtils.wrapperContextForParams(r3, ValueVector.class, "com.obric.memorydata.plugin"), r4, false);
    }

    private static int lookupIndexOfValue(LookupValueComparer r9, ValueVector r10, MatchMode r11, boolean r12) {
        LookupValueComparer r13 = (LookupValueComparer) ZeusTransformUtils.wrapperContextForParams(r9, LookupValueComparer.class, "com.obric.memorydata.plugin");
        ValueVector r14 = (ValueVector) ZeusTransformUtils.wrapperContextForParams(r10, ValueVector.class, "com.obric.memorydata.plugin");
        if (r12 == false) goto L5;
        Iterator<Integer> r15 = r14.reverseIndexIterator();
    L6:
        int r0 = -1;
        ValueEval r2 = null;
    L8:
        if (r15.hasNext() == false) goto L31;
        int r3 = ((Integer) ZeusTransformUtils.preCheckCast(r15.next(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        ValueEval r4 = r14.getItem(r3);
        CompareResult r5 = r13.compareTo(r4);
        if (r5.isEqual() == true) goto L11;
        int r6 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$formula$functions$LookupUtils$MatchMode[r11.ordinal()];
        if (r6 != 1) goto L15;
        if (r5.isLessThan() == false) goto L8;
        if (r2 == null) goto L30;
        if (createTolerantLookupComparer(r4, true, true).compareTo(r2).isLessThan() == false) goto L8;
    L30:
        r0 = r3;
        r2 = r4;
        goto L8
    L15:
        if (r6 != 2) goto L8;
        if (r5.isGreaterThan() == false) goto L8;
        if (r2 == null) goto L30;
        if (createTolerantLookupComparer(r4, true, true).compareTo(r2).isGreaterThan() == false) goto L8;
    L11:
        return r3;
    L31:
        return r0;
    L5:
        r15 = r14.indexIterator();
        goto L6
    }

    private static int lookupLastIndexOfValue(LookupValueComparer r2, ValueVector r3, MatchMode r4) {
        return lookupIndexOfValue((LookupValueComparer) ZeusTransformUtils.wrapperContextForParams(r2, LookupValueComparer.class, "com.obric.memorydata.plugin"), (ValueVector) ZeusTransformUtils.wrapperContextForParams(r3, ValueVector.class, "com.obric.memorydata.plugin"), r4, true);
    }

    public static MatchMode matchMode(int r3) {
        MatchMode r0 = (MatchMode) ZeusTransformUtils.preCheckCast(matchModeMap.get(Integer.valueOf(r3)), MatchMode.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("unknown match mode " + r3);
    }

    private static int performBinarySearch(ValueVector r4, LookupValueComparer r5) {
        ValueVector r6 = (ValueVector) ZeusTransformUtils.wrapperContextForParams(r4, ValueVector.class, "com.obric.memorydata.plugin");
        LookupValueComparer r7 = (LookupValueComparer) ZeusTransformUtils.wrapperContextForParams(r5, LookupValueComparer.class, "com.obric.memorydata.plugin");
        BinarySearchIndexes r0 = new BinarySearchIndexes(r6.getSize());
    L3:
        int r1 = r0.getMidIx();
        if (r1 < 0) goto L6;
        CompareResult r2 = r7.compareTo(r6.getItem(r1));
        if (r2.isTypeMismatch() == false) goto L14;
        r1 = handleMidValueTypeMismatch(r7, r6, r0, r1, false);
        if (r1 < 0) goto L3;
        r2 = r7.compareTo(r6.getItem(r1));
    L14:
        if (r2.isEqual() == true) goto L16;
        r0.narrowSearch(r1, r2.isLessThan());
        goto L3
    L16:
        return findLastIndexInRunOfEqualValues(r7, r6, r1, r0.getHighIx());
    L6:
        return r0.getLowIx();
    }

    public static boolean resolveRangeLookupArg(ValueEval r3, int r4, int r5) {
        ValueEval r6 = OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin"), r4, r5);
        if (r6 != MissingArgEval.instance) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, BlankEval.class) == false) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r6, BoolEval.class) == false) goto L13;
        return ((BoolEval) ZeusTransformUtils.preCheckCast(r6, BoolEval.class, "com.obric.memorydata.plugin")).getBooleanValue();
    L13:
        if (ZeusTransformUtils.instanceOf(r6, StringEval.class) == false) goto L25;
        String r7 = ((StringEval) ZeusTransformUtils.preCheckCast(r6, StringEval.class, "com.obric.memorydata.plugin")).getStringValue();
        if (r7.length() < 1) goto L23;
        Boolean r8 = Countif.parseBoolean(r7);
        if (r8 == null) goto L21;
        return r8.booleanValue();
    L21:
        throw EvaluationException.invalidValue();
    L23:
        throw EvaluationException.invalidValue();
    L25:
        if (ZeusTransformUtils.instanceOf(r6, NumericValueEval.class) == false) goto L31;
        if (0.0d != ((NumericValueEval) ZeusTransformUtils.preCheckCast(r6, NumericValueEval.class, "com.obric.memorydata.plugin")).getNumberValue()) goto L29;
        return false;
    L29:
        return true;
    L31:
        throw new RuntimeException("Unexpected eval type (" + r6 + ")");
    }

    public static int resolveRowOrColIndexArg(ValueEval r2, int r3, int r4) {
        ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L22;
        ValueEval r6 = OperandResolver.getSingleValue(r5, r3, (short) r4);     // Catch: EvaluationException -> L19
        if (ZeusTransformUtils.instanceOf(r6, StringEval.class) == true) goto L9;
    L13:
        int r7 = OperandResolver.coerceValueToInt(r6);
        if (r7 < 1) goto L18;
        return r7 - 1;
    L18:
        throw EvaluationException.invalidValue();
    L9:
        if (OperandResolver.parseDouble(((StringEval) ZeusTransformUtils.preCheckCast(r6, StringEval.class, "com.obric.memorydata.plugin")).getStringValue()) != null) goto L13;
        throw EvaluationException.invalidRef();
    L20:
        throw EvaluationException.invalidRef();
    L22:
        throw new IllegalArgumentException("argument must not be null");
    }

    public static TwoDEval resolveTableArrayArg(ValueEval r2) {
        ValueEval r3 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, TwoDEval.class) == false) goto L7;
        return (TwoDEval) ZeusTransformUtils.preCheckCast(r3, TwoDEval.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r3, RefEval.class) == false) goto L11;
        return ((RefEval) ZeusTransformUtils.preCheckCast(r3, RefEval.class, "com.obric.memorydata.plugin")).offset(0, 0, 0, 0);
    L11:
        throw EvaluationException.invalidValue();
    }

    public static SearchMode searchMode(int r3) {
        SearchMode r0 = (SearchMode) ZeusTransformUtils.preCheckCast(searchModeMap.get(Integer.valueOf(r3)), SearchMode.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("unknown search mode " + r3);
    }

    public static int xlookupIndexOfValue(ValueEval r9, ValueVector r10, MatchMode r11, SearchMode r12) {
        ValueEval r13 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r9, ValueEval.class, "com.obric.memorydata.plugin");
        ValueVector r14 = (ValueVector) ZeusTransformUtils.wrapperContextForParams(r10, ValueVector.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, StringEval.class) == false) goto L24;
        if (r11 != MatchMode.ExactMatchFallbackToLargerValue) goto L7;
    L8:
        String r0 = ((StringEval) ZeusTransformUtils.preCheckCast(r13, StringEval.class, "com.obric.memorydata.plugin")).getStringValue();
        StringBuilder r1 = new StringBuilder(r0.length());
        char[] r2 = r0.toCharArray();
        int r4 = r2.length;
        int r5 = 0;
        boolean r6 = false;
    L9:
        if (r5 >= r4) goto L21;
        char r7 = r2[r5];
        if (r7 != '*') goto L13;
    L17:
        r6 = true;
    L18:
        if (r6 == true) goto L21;
        r5 = r5 + 1;
        goto L9
    L13:
        if (r7 == '?') goto L17;
        if (r7 == '~') goto L17;
        r1.append(r7);
    L21:
        if (r6 == false) goto L24;
        r13 = new StringEval(r1.toString());
        goto L24
    L7:
        if (r11 == MatchMode.ExactMatchFallbackToSmallerValue) goto L8;
    L24:
        if (r11 == MatchMode.WildcardMatch) goto L26;
        boolean r3 = true;
    L27:
        LookupValueComparer r15 = createTolerantLookupComparer(r13, r3, true);
        if (r12 != SearchMode.BinarySearchForward) goto L31;
        int r16 = binarySearchIndexOfValue(r15, r14, r11, false);
    L37:
        if (r16 < 0) goto L40;
        return r16;
    L40:
        throw new EvaluationException(ErrorEval.NA);
    L31:
        if (r12 != SearchMode.BinarySearchBackward) goto L34;
        r16 = binarySearchIndexOfValue(r15, r14, r11, true);
        goto L37
    L34:
        if (r12 != SearchMode.IterateBackward) goto L36;
        r16 = lookupLastIndexOfValue(r15, r14, r11);
        goto L37
    L36:
        r16 = lookupFirstIndexOfValue(r15, r14, r11);
        goto L37
    L26:
        r3 = false;
        goto L27
    }
}
