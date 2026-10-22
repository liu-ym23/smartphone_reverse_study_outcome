package ju1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0015\u0018\u00002\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b)\u0010*R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010 \u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\"\u0010#\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\"\u0010&\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001c¨\u0006+"}, d2 = {"Lju1/d;", "", "", "factor", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setFactor", "(Ljava/lang/String;)V", "mappingType", "d", "setMappingType", "expression", "b", "setExpression", "", "isMultiply", "Z", "i", "()Z", "setMultiply", "(Z)V", "", "plusNum", "D", "h", "()D", "setPlusNum", "(D)V", "multiplyNum", "e", "setMultiplyNum", "exponentNum", "a", "setExponentNum", "pMax", "f", "setPMax", "pMin", "g", "setPMin", "<init>", "()V", "dynamicstrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("exponent_num")
    private double exponentNum;

    @SerializedName("expression")
    private String expression;

    @SerializedName("factor")
    private String factor;

    @SerializedName("is_multiply")
    private boolean isMultiply;

    @SerializedName("mapping_type")
    private String mappingType;

    @SerializedName("multiply_num")
    private double multiplyNum;

    @SerializedName("p_max")
    private double pMax;

    @SerializedName("p_min")
    private double pMin;

    @SerializedName("plus_num")
    private double plusNum;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "FormulaRule(factor='" + this.factor + "', mappingType='" + this.mappingType + "', expression='" + this.expression + "', isMultiply=" + this.isMultiply + ", plusNum=" + this.plusNum + ", multiplyNum=" + this.multiplyNum + ", exponentNum=" + this.exponentNum + ", pMax=" + this.pMax + ", pMin=" + this.pMin + ')';
    }

    public d() {
        this.factor = "";
        this.mappingType = "";
        this.expression = "";
        this.isMultiply = true;
        this.plusNum = 1.0d;
        this.pMax = 1.0d;
    }

    public final double a() {
        return this.exponentNum;
    }

    public final String b() {
        return this.expression;
    }

    public final String c() {
        return this.factor;
    }

    public final String d() {
        return this.mappingType;
    }

    public final double e() {
        return this.multiplyNum;
    }

    public final double f() {
        return this.pMax;
    }

    public final double g() {
        return this.pMin;
    }

    public final double h() {
        return this.plusNum;
    }

    public final boolean i() {
        return this.isMultiply;
    }
}
