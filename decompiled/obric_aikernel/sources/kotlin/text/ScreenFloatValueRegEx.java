package kotlin.text;

import kotlin.jvm.JvmField;

/* JADX INFO: loaded from: classes3.dex */
final class ScreenFloatValueRegEx {
    public static final ScreenFloatValueRegEx INSTANCE = null;

    @JvmField
    public static final Regex value = null;

    static {
        INSTANCE = new ScreenFloatValueRegEx();
        String r10 = "[eE][+-]?(\\p{Digit}+)";
        value = new Regex("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ("((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)(" + r10 + ")?)|(\\.((\\p{Digit}+))(" + r10 + ")?)|((" + ("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))") + ")[pP][+-]?(\\p{Digit}+))") + ")[fFdD]?))[\\x00-\\x20]*");
    }

    private ScreenFloatValueRegEx() {
    }
}
